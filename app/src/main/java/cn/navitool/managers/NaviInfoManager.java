package cn.navitool.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cn.navitool.utils.DebugLogger;
import cn.navitool.view.TrafficLightView;

import com.autonavi.amapauto.aidl.IJsonProtocolInterface;
import com.autonavi.amapauto.aidl.IJsonProtocolReceiveInterface;

/**
 * 导航信息管理器 (NaviInfoManager)
 * [Refactored] Integrated AIDL Client for Amap/GeelyMap
 */
public class NaviInfoManager {
    private static final String TAG = "NaviInfoManager";

    // --- Traffic Light Views ---
    private TrafficLightView mTrafficLightLeft;
    private TrafficLightView mTrafficLightStraight;
    private TrafficLightView mTrafficLightRight;

    // --- Navi Info Views (Optional) ---
    private TextView mDistanceView;
    private TextView mEtaView;

    // --- State ---
    private int mLastValidDirection = 0;
    
    // Status State
    private static final int STATUS_IDLE = 0;
    private static final int STATUS_NAVI = 1;
    private static final int STATUS_CRUISE = 2;
    private int mCurrentStatus = STATUS_IDLE;

    // Data Cache
    private int mRouteRemainDis = -1;
    private int mRouteRemainTime = -1;
    private String mEtaText = ""; 

    private static volatile NaviInfoManager instance;
    private Context mContext;
    private Handler mMainHandler; 

    // --- AIDL Components (Dual Service: Geely Map + Amap) ---
    private IJsonProtocolInterface mGeelyService;
    private IJsonProtocolInterface mAmapService;
    private boolean mGeelyBound = false;
    private boolean mAmapBound = false;
    
    private static final String PKG_GEELY = "com.geely.map";
    private static final String PKG_AMAP = "com.autonavi.amapauto";
    private static final String AIDL_ACTION = "com.autonavi.amapauto.aidl.json_protocol_service";
    
    // Watchdog
    private long mLastNaviUpdateTime = 0;
    private static final long NAVI_TIMEOUT_MS = 5000;
    private Runnable mWatchdogRunnable;

    private NaviInfoManager(Context context) {
        mContext = context.getApplicationContext();
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    // Added: startManager method with binding logic
    public void startManager(Context context) {
        this.mContext = context.getApplicationContext(); 
        if (mMainHandler == null) {
            mMainHandler = new Handler(Looper.getMainLooper());
        }
        
        // Start Binding Services (Async, Both)
        bindAidlServices();
        startWatchdog();
        DebugLogger.action(TAG, "NaviInfoManager Started (Dual AIDL Mode)");
    }

    public static NaviInfoManager getInstance(Context context) {
        if (instance == null) {
            synchronized (NaviInfoManager.class) {
                if (instance == null) {
                    instance = new NaviInfoManager(context);
                    instance.startManager(context); 
                }
            }
        }
        return instance;
    }
    
    // --- Shared AIDL Callback (Both services use the same callback) ---
    private IJsonProtocolReceiveInterface mCallback = new IJsonProtocolReceiveInterface.Stub() {
        @Override
        public void received(String message) throws RemoteException {
            // DebugLogger.d(TAG, "AIDL RAW: " + message);
            try {
                JSONObject json = new JSONObject(message);
                mMainHandler.post(() -> processPacket(json));
            } catch (JSONException e) {
                DebugLogger.e(TAG, "JSON Parse Error", e);
            }
        }

        @Override
        public String receivedSync(String message) throws RemoteException {
            return null;
        }
    };

    // --- Geely Map Connection ---
    private ServiceConnection mGeelyConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            DebugLogger.action(TAG, "[Geely] Service Connected");
            mGeelyService = IJsonProtocolInterface.Stub.asInterface(service);
            try {
                mGeelyService.registerReceive("NaviTool", mCallback);
                DebugLogger.i(TAG, "[Geely] Callback Registered");
            } catch (RemoteException e) {
                DebugLogger.e(TAG, "[Geely] Register failed", e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            DebugLogger.w(TAG, "[Geely] Service Disconnected");
            mGeelyService = null;
            mGeelyBound = false;
            // Auto-reconnect after 3s
            mMainHandler.postDelayed(() -> bindToPackage(PKG_GEELY, mGeelyConnection, true), 3000);
        }
    };

    // --- Amap Connection ---
    private ServiceConnection mAmapConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            DebugLogger.action(TAG, "[Amap] Service Connected");
            mAmapService = IJsonProtocolInterface.Stub.asInterface(service);
            try {
                mAmapService.registerReceive("NaviTool", mCallback);
                DebugLogger.i(TAG, "[Amap] Callback Registered");
            } catch (RemoteException e) {
                DebugLogger.e(TAG, "[Amap] Register failed", e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            DebugLogger.w(TAG, "[Amap] Service Disconnected");
            mAmapService = null;
            mAmapBound = false;
            // Auto-reconnect after 3s
            mMainHandler.postDelayed(() -> bindToPackage(PKG_AMAP, mAmapConnection, false), 3000);
        }
    };
    
    // Bind to both services simultaneously
    private void bindAidlServices() {
        bindToPackage(PKG_GEELY, mGeelyConnection, true);
        bindToPackage(PKG_AMAP, mAmapConnection, false);
    }
    
    private void bindToPackage(String pkg, ServiceConnection conn, boolean isGeely) {
        if (isGeely && mGeelyBound) return;
        if (!isGeely && mAmapBound) return;
        
        Intent intent = new Intent(AIDL_ACTION);
        intent.setPackage(pkg);

        try {
            boolean ret = mContext.bindService(intent, conn, Context.BIND_AUTO_CREATE);
            if (ret) {
                if (isGeely) mGeelyBound = true;
                else mAmapBound = true;
                DebugLogger.i(TAG, "[" + pkg + "] Binding initiated");
            } else {
                DebugLogger.w(TAG, "[" + pkg + "] Bind failed (not installed?)");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "[" + pkg + "] Bind error", e);
        }
    }
    
    public void unbindService() {
        if (mGeelyBound && mGeelyConnection != null) {
            try { mContext.unbindService(mGeelyConnection); } catch (Exception e) { }
            mGeelyBound = false;
        }
        if (mAmapBound && mAmapConnection != null) {
            try { mContext.unbindService(mAmapConnection); } catch (Exception e) { }
            mAmapBound = false;
        }
    }
    
    private void updateStatus(int newStatus) {
        if (newStatus == mCurrentStatus) return;
        String statusStr = "IDLE";
        if (newStatus == STATUS_NAVI) statusStr = "NAVI";
        else if (newStatus == STATUS_CRUISE) statusStr = "CRUISE";
        
        DebugLogger.i(TAG, "Navi Status Changed: " + statusStr);
        mCurrentStatus = newStatus;
        
        // [FIX] Forward Status to ClusterHudManager (Handles Navigation Start/Stop UI logic)
        ClusterHudManager.getInstance(mContext).onNaviStatusUpdate(mCurrentStatus);
    }

    private void processPacket(JSONObject json) {
        int protocolId = json.optInt("protocolId", -1);
        
        switch (protocolId) {
             case 80189: // Navi Traffic Light
                 JSONObject dataNavi = json.optJSONObject("data");
                 if (dataNavi != null) {
                     updateStatus(STATUS_NAVI); 
                     List<TrafficLightInfo> list = new ArrayList<>();
                     list.add(parseTrafficLight(dataNavi));
                     updateTrafficLights(list);
                 }
                 break;
             case 80194: // Cruise Traffic Light
                 JSONObject dataWrapper = json.optJSONObject("data");
                 if (dataWrapper != null) {
                    JSONArray jsonArray = dataWrapper.optJSONArray("data");
                     if (jsonArray != null && jsonArray.length() > 0) {
                         // Only switch to CRUISE if not already in NAVI
                         if (mCurrentStatus != STATUS_NAVI) {
                             updateStatus(STATUS_CRUISE);
                         }
                         
                         List<TrafficLightInfo> list = new ArrayList<>();
                         for (int i=0; i<jsonArray.length(); i++) {
                             JSONObject obj = jsonArray.optJSONObject(i);
                             if (obj != null) {
                                 list.add(parseTrafficLight(obj));
                             }
                         }
                         updateTrafficLights(list);
                     }
                 }
                 break;
             case 30407: // Guide Info
                 JSONObject dataGuide = json.optJSONObject("data");
                 if (dataGuide != null) {
                     // Status update handled inside processGuideInfoData
                     processGuideInfoData(dataGuide);
                 }
                 break;
        }
    }
    
    private TrafficLightInfo parseTrafficLight(JSONObject data) {
         TrafficLightInfo info = new TrafficLightInfo();
         info.status = data.optInt("trafficLightStatus", 0);
         info.redCountdown = data.optInt("redLightCountDownSeconds", 0);
         info.greenCountdown = data.optInt("greenLightCountDownSeconds", 0);
         info.direction = data.optInt("dir", 0);
         return info;
    }
    
    // [Updated] Handle List of Lights
    public void updateTrafficLights(List<TrafficLightInfo> infos) {
        if (infos == null) return;
        
        // 1. Reset ALL views first (Prevent ghosts)
        if (mTrafficLightLeft != null) mTrafficLightLeft.setVisibility(View.INVISIBLE);
        if (mTrafficLightStraight != null) mTrafficLightStraight.setVisibility(View.INVISIBLE);
        if (mTrafficLightRight != null) mTrafficLightRight.setVisibility(View.INVISIBLE);
        
        mLastValidDirection = 0; // Reset? Or keep for fallback? 
        // In multi-light mode, fallback is tricky. Let's rely on fresh data.

        // 2. Iterate and Map
        for (TrafficLightInfo info : infos) {
            TrafficLightView targetView = null;
            
            // Simple mapping logic
            // 1=Left, 2=Right, 4=Straight, 3=TurnBack(Left)
            // 0=Unknown -> Try Straight?
            
            if (info.direction == 1 || info.direction == 3) {
                targetView = mTrafficLightLeft;
            } else if (info.direction == 2) {
                targetView = mTrafficLightRight;
            } else if (info.direction == 4 || info.direction == 8 || info.direction == 0) {
                // 8=Straight, 0=Unknown(Usually Straight in Cruise)
                targetView = mTrafficLightStraight;
            }
            
            if (targetView != null) {
                int mappedStatus = mapStatus(info.status);
                if (mappedStatus != 0) {
                    targetView.setVisibility(View.VISIBLE);
                    targetView.updateState(mappedStatus, info.redCountdown, info.direction);
                    
                    // Log debug
                    // DebugLogger.d(TAG, "Show Light: Dir=" + info.direction + " Status=" + mappedStatus);
                }
            }
            
            // [FIX] Forward to ClusterHudManager (Floating Window / Presentation)
            ClusterHudManager.getInstance(mContext).onTrafficLightUpdate(info);
        }
    }

    // Retain legacy method signature for compatibility (if any external calls exist)
    // but redirect to new logic wrapping in list
    public void updateTrafficLight(TrafficLightInfo info) {
         if (info == null) return;
         List<TrafficLightInfo> list = new ArrayList<>();
         list.add(info);
         updateTrafficLights(list);
    }
    
    private void processGuideInfoData(JSONObject data) {
         GuideInfo info = new GuideInfo();
         info.routeRemainDis = data.optInt("routeRemainDis", -1);
         info.routeRemainTime = data.optInt("routeRemainTime", -1);
         info.currentRoadName = data.optString("curRoadName", "");
         info.nextRoadName = data.optString("nextRoadName", "");
         // info.etaText = ... // Not provided in 30407 usually, calculated
         
         // [Logic] Determine status based on distance/time
         if (info.routeRemainDis > 0 || info.routeRemainTime > 0) {
             updateStatus(STATUS_NAVI);
         } else {
             // If we were in NAVI, receiving 0/0 means we arrived or navi cancelled
             if (mCurrentStatus == STATUS_NAVI) {
                 DebugLogger.i(TAG, "Navi Finished (Distance/Time is 0) -> IDLE");
                 updateStatus(STATUS_IDLE);
                 reset(); // Clear UI
             }
         }
         
         updateGuideInfo(info);
         // [FIX] Forward to ClusterHudManager
         ClusterHudManager.getInstance(mContext).onGuideInfoUpdate(info);
         
         mLastNaviUpdateTime = System.currentTimeMillis();
    }
    
    private void startWatchdog() {
        mWatchdogRunnable = new Runnable() {
            @Override
            public void run() {
                if (System.currentTimeMillis() - mLastNaviUpdateTime > NAVI_TIMEOUT_MS) {
                    if (mCurrentStatus != STATUS_IDLE) { // Use status check
                         DebugLogger.i(TAG, "Navi Timeout -> Reset to IDLE");
                         reset();
                    }
                }
                mMainHandler.postDelayed(this, 2000);
            }
        };
        mMainHandler.postDelayed(mWatchdogRunnable, 2000);
    }

    // --- Floating Window Control (Connected to ClusterHudManager) ---
    public void showTrafficLightFloating() {
        DebugLogger.i(TAG, "showTrafficLightFloating requested");
        ClusterHudManager.getInstance(mContext).setFloatingTrafficLightEnabled(true);
    }

    public void hideTrafficLightFloating() {
        DebugLogger.i(TAG, "hideTrafficLightFloating requested");
        ClusterHudManager.getInstance(mContext).setFloatingTrafficLightEnabled(false);
    }

    // [DEPRECATED] Style toggle removed - Now only capsule style is supported
    // public void toggleFloatingStyle() {
    //     DebugLogger.i(TAG, "toggleFloatingStyle requested");
    //     ClusterHudManager.getInstance(mContext).toggleFloatingTrafficLightStyle();
    // }

    /**
     * 绑定红绿灯视图
     */
    public void bindTrafficLightViews(TrafficLightView left, TrafficLightView straight, TrafficLightView right) {
        mTrafficLightLeft = left;
        mTrafficLightStraight = straight;
        mTrafficLightRight = right;

        if (mTrafficLightLeft != null) {
            mTrafficLightLeft.setOverrideDirection(1); // Left Arrow
            mTrafficLightLeft.setVisibility(View.INVISIBLE);
        }
        if (mTrafficLightStraight != null) {
            mTrafficLightStraight.setOverrideDirection(0); // Straight
            mTrafficLightStraight.setVisibility(View.INVISIBLE);
        }
        if (mTrafficLightRight != null) {
            mTrafficLightRight.setOverrideDirection(2); // Right Arrow
            mTrafficLightRight.setVisibility(View.INVISIBLE);
        }
        mLastValidDirection = 0;
    }

    /**
     * 绑定导航信息视图
     */
    public void bindNaviInfoViews(TextView distanceView, TextView etaView) {
        mDistanceView = distanceView;
        mEtaView = etaView;
        updateNaviViews();
    }

    /**
     * 更新导航引导信息
     */
    public void updateGuideInfo(GuideInfo info) {
        if (info == null) return;
        mRouteRemainDis = info.routeRemainDis;
        mRouteRemainTime = info.routeRemainTime;
        mEtaText = info.etaText; 
        updateNaviViews();
    }

    private void updateNaviViews() {
        if (mDistanceView != null) {
            String distText = formatDistance(mRouteRemainDis);
            mDistanceView.setText(distText);
            mDistanceView.setVisibility(distText.isEmpty() ? View.GONE : View.VISIBLE);
        }
        if (mEtaView != null) {
            String eta = calculateEta(mRouteRemainTime);
            String displayEta = eta.isEmpty() ? "" : "ETA " + eta;
            mEtaView.setText(displayEta);
            mEtaView.setVisibility(displayEta.isEmpty() ? View.GONE : View.VISIBLE);
        }
    }

    public static String formatDistance(int dist) {
        if (dist < 0) return "";
        if (dist < 1000) return "<1km";
        return String.format(Locale.US, "%.1fkm", dist / 1000.0f);
    }

    public static String calculateEta(int remainingSeconds) {
        if (remainingSeconds <= 0) return "";
        long arrivalTime = System.currentTimeMillis() + (remainingSeconds * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(new Date(arrivalTime));
    }
    
    // Compatibility
    public String parseEta(int remainingSeconds) { return calculateEta(remainingSeconds); }
    public static String parseEta(String etaText) { return etaText == null ? "" : etaText; }



    public static int mapStatus(int status) {
        if (status == 1) return 2; // RED
        else if (status == 2 || status == 4) return 1; // GREEN
        else if (status == 3 || status == -1) return 3; // YELLOW
        else return 0; // NONE
    }

    public void reset() {
        updateStatus(STATUS_IDLE); // Log the reset
        // mCurrentStatus = STATUS_IDLE; // Handled by updateStatus
        resetTrafficLights();
        // Reset Navi Info
        mRouteRemainDis = -1;
        mRouteRemainTime = -1;
        mEtaText = ""; // [FIX] Reset ETA text
        updateNaviViews();
    }

    public void resetTrafficLights() {
        if (mTrafficLightLeft != null) mTrafficLightLeft.setVisibility(View.INVISIBLE);
        if (mTrafficLightStraight != null) mTrafficLightStraight.setVisibility(View.INVISIBLE);
        if (mTrafficLightRight != null) mTrafficLightRight.setVisibility(View.INVISIBLE);
        mLastValidDirection = 0;
    }

    // --- Inner Models ---
    public static class TrafficLightInfo {
        public int status;
        public int redCountdown;
        public int greenCountdown;
        public int direction;
        public int waitRound;
    }

    public static class GuideInfo {
        public String currentRoadName;
        public String nextRoadName;
        public int iconType;
        public int routeRemainDis;
        public int routeRemainTime;
        public int segRemainDis;
        public String etaText;
    }
}
