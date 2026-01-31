package cn.navitool.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

import cn.navitool.interfaces.NaviStatusListener;
import cn.navitool.model.GuideInfo;
import cn.navitool.model.TrafficLightInfo;
import cn.navitool.utils.DebugLogger;
import cn.navitool.utils.NaviDataRecorder;

import com.autonavi.amapauto.aidl.IJsonProtocolInterface;
import com.autonavi.amapauto.aidl.IJsonProtocolReceiveInterface;

/**
 * 导航信息管理器 (NaviInfoManager)
 * [Refactored] Pure Data Publisher - Decoupled from UI
 */
public class NaviInfoManager {
    private static final String TAG = "NaviInfoManager";

    // Status State
    public static final int STATUS_IDLE = 0;
    public static final int STATUS_NAVI = 1;
    public static final int STATUS_CRUISE = 2;
    private int mCurrentStatus = STATUS_IDLE;

    // Listeners
    private final List<NaviStatusListener> mListeners = new CopyOnWriteArrayList<>();

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
    
    // [FIX] Cached GuideInfo for HUD preview
    private GuideInfo mCachedGuideInfo;

    private NaviInfoManager(Context context) {
        mContext = context.getApplicationContext();
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    public void startManager(Context context) {
        this.mContext = context.getApplicationContext(); 
        if (mMainHandler == null) {
            mMainHandler = new Handler(Looper.getMainLooper());
        }
        
        // Initialize Recorder and Register it
        NaviDataRecorder.getInstance().init(context);
        addListener(NaviDataRecorder.getInstance());
        
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
    
    /**
     * [FIX] Get instance without context (for HUD preview use)
     * Returns null if not initialized.
     */
    public static NaviInfoManager getInstance() {
        return instance;
    }
    
    /**
     * [FIX] Get cached GuideInfo for HUD preview
     * @return Cached GuideInfo or null if not available
     */
    public GuideInfo getCachedGuideInfo() {
        return mCachedGuideInfo;
    }
    
    // --- Listener Management ---
    public void addListener(NaviStatusListener listener) {
        if (listener != null && !mListeners.contains(listener)) {
            mListeners.add(listener);
            // Verify: Send current status to new listener immediately?
            // listener.onNaviStatusChanged(mCurrentStatus); 
        }
    }

    public void removeListener(NaviStatusListener listener) {
        mListeners.remove(listener);
    }
    
    private void notifyListenersStatus(int status) {
        for (NaviStatusListener l : mListeners) {
            l.onNaviStatusChanged(status);
        }
    }

    private void notifyListenersTrafficLight(List<TrafficLightInfo> lights) {
        for (NaviStatusListener l : mListeners) {
            l.onTrafficLightUpdate(lights);
        }
    }

    private void notifyListenersGuideInfo(GuideInfo info) {
        for (NaviStatusListener l : mListeners) {
            l.onGuideInfoUpdate(info);
        }
    }

    private void notifyListenersOriginalPacket(String json, JSONObject parsed) {
        for (NaviStatusListener l : mListeners) {
            l.onOriginalPacketReceived(json, parsed);
        }
    }

    // --- Shared AIDL Callback ---
    private IJsonProtocolReceiveInterface mCallback = new IJsonProtocolReceiveInterface.Stub() {
        @Override
        public void received(String message) throws RemoteException {
            // DebugLogger.d(TAG, "AIDL RAW: " + message);
            mMainHandler.post(() -> processRawPacket(message));
        }

        @Override
        public String receivedSync(String message) throws RemoteException {
            return null;
        }
    };

    private void processRawPacket(String rawJson) {
        try {
            JSONObject json = new JSONObject(rawJson);
            // Notify recorder first
            notifyListenersOriginalPacket(rawJson, json);
            // Process logic
            processPacket(json);
        } catch (JSONException e) {
            DebugLogger.e(TAG, "JSON Parse Error", e);
        }
    }

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
            mMainHandler.postDelayed(() -> bindToPackage(PKG_AMAP, mAmapConnection, false), 3000);
        }
    };
    
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
        
        notifyListenersStatus(mCurrentStatus);
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
                     notifyListenersTrafficLight(list);
                     // [FIX] Update watchdog timestamp to prevent flicker
                     mLastNaviUpdateTime = System.currentTimeMillis();
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
                         notifyListenersTrafficLight(list);
                         // [FIX] Update watchdog timestamp to prevent flicker
                         mLastNaviUpdateTime = System.currentTimeMillis();
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
    
    // Legacy method for external calls (if any)
    public void updateTrafficLight(TrafficLightInfo info) {
         if (info == null) return;
         List<TrafficLightInfo> list = new ArrayList<>();
         list.add(info);
         notifyListenersTrafficLight(list);
    }
    
    private void processGuideInfoData(JSONObject data) {
         GuideInfo info = new GuideInfo();
         info.routeRemainDis = data.optInt("routeRemainDis", -1);
         info.routeRemainTime = data.optInt("routeRemainTime", -1);
         info.currentRoadName = data.optString("curRoadName", "");
         info.nextRoadName = data.optString("nextRoadName", "");
         info.destinationName = data.optString("endPOIName", ""); // 目的地
         // info.etaText = ... 
         
         // [FIX] Cache GuideInfo for HUD preview
         mCachedGuideInfo = info;
         
         // [Logic] Determine status based on distance/time
         if (info.routeRemainDis > 0 || info.routeRemainTime > 0) {
             updateStatus(STATUS_NAVI);
         } else {
             // If we were in NAVI, receiving 0/0 means we arrived or navi cancelled
             if (mCurrentStatus == STATUS_NAVI) {
                 DebugLogger.i(TAG, "Navi Finished (Distance/Time is 0) -> IDLE");
                 updateStatus(STATUS_IDLE);
                 reset(); 
             }
         }
         
         notifyListenersGuideInfo(info);
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

    public static int mapStatus(int status) {
        if (status == 1 || status == 2) return 2; // RED (Fixed: 2 is also RED)
        else if (status == 4 || status >= 4) return 1; // GREEN (Usually 4+)
        else if (status == 3 || status == -1) return 3; // YELLOW
        else return 0; // NONE
    }

    public void reset() {
        updateStatus(STATUS_IDLE); 
        // Notify empty?
        // Usually IDLE status is enough for listeners to hide UI
    }
    
    // --- Utilities ---
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
    // --- Hook Broadcast Receiver (Original Amap 9.1+) ---
    private static final String HOOK_ACTION = "com.autonavi.cruise.LIGHT_INFO";
    private android.content.BroadcastReceiver mHookReceiver;
    private boolean mHookModeEnabled = false;

    public void setHookModeEnabled(boolean enabled) {
        if (mHookModeEnabled == enabled) return;
        mHookModeEnabled = enabled;
        if (enabled) {
            registerHookReceiver();
        } else {
            unregisterHookReceiver();
        }
        DebugLogger.i(TAG, "Hook Mode set to: " + enabled);
    }
    
    public boolean isHookModeEnabled() {
        return mHookModeEnabled;
    }

    private void registerHookReceiver() {
        if (mHookReceiver != null) return;
        
        mHookReceiver = new android.content.BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (!HOOK_ACTION.equals(intent.getAction())) return;
                
                try {
                    // Get Parcelable Wrapper
                    // Note: Must align with com.autonavi.amapauto.CameraLightInfo.* package structure
                    intent.setExtrasClassLoader(com.autonavi.amapauto.CameraLightInfo.CameraLightInfoWrapper.class.getClassLoader());
                    com.autonavi.amapauto.CameraLightInfo.CameraLightInfoWrapper wrapper = 
                            intent.getParcelableExtra("data");
                    
                    if (wrapper != null) {
                        processHookData(wrapper);
                    }
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Hook Broadcast Parse Error", e);
                }
            }
        };
        
        android.content.IntentFilter filter = new android.content.IntentFilter(HOOK_ACTION);
        mContext.registerReceiver(mHookReceiver, filter);
        DebugLogger.i(TAG, "Hook Receiver Registered");
    }

    private void unregisterHookReceiver() {
        if (mHookReceiver != null) {
            try {
                mContext.unregisterReceiver(mHookReceiver);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Unregister Hook Receiver failed", e);
            }
            mHookReceiver = null;
            DebugLogger.i(TAG, "Hook Receiver Unregistered");
        }
    }

    private void processHookData(com.autonavi.amapauto.CameraLightInfo.CameraLightInfoWrapper wrapper) {
        // [LOG] Print raw data for debugging
        DebugLogger.d(TAG, "Hook Received: " + (wrapper != null ? wrapper.toString() : "null"));

        if (wrapper == null || wrapper.a == null || wrapper.a.isEmpty()) return;

        // Start Cruise Mode if not Navigating
        if (mCurrentStatus != STATUS_NAVI) {
            updateStatus(STATUS_CRUISE);
        }

        List<TrafficLightInfo> list = new ArrayList<>();
        
        for (com.autonavi.amapauto.CameraLightInfo.CameraLightInfo light : wrapper.a) {
             TrafficLightInfo info = new TrafficLightInfo();
             
             // Convert Dir (Hook -> Internal)
             // Hook: 0=U-Turn(??), 1=Left, 2=Str, 3=Right (Based on NaviTest log analysis??)
             // Wait, NaviTest says:
             // Hook: 0=掉头, 1=左转, 2=直行, 3=右转 (Found in switch case)
             // App Internal (TrafficLightInfo/NaviTest Defined): 3=U-Turn, 1=Left, 4=Str, 2=Right
             // Let's match NaviTest logic:
             switch (light.c) {
                 case 0: info.direction = 3; break; // U-Turn
                 case 1: info.direction = 1; break; // Left
                 case 2: info.direction = 4; break; // Straight
                 case 3: info.direction = 2; break; // Right
                 default: info.direction = light.c; break;
             }
             
             // Convert Status (Hook -> Internal)
             // Hook: 0=Unknown(Red?), 1=Red, 2=Green, 3=Yellow
             // NaviTest: 
             // "Hook: 0=红灯, 1=绿灯" -> App: 1=Red, 4=Green
             // Wait, let's check NaviTest source again for mapping
             /*
                // Hook: 0=红灯, 1=绿灯
                if (light.d == 1) appStatus = 4; // Green
                else if (light.d == 0) appStatus = 1; // Red
                else appStatus = 3; // Yellow
             */
             if (light.d == 1) {
                 info.status = 4; // Green
             } else if (light.d == 0) {
                 info.status = 1; // Red
             } else {
                 info.status = 3; // Yellow
             }
             
             info.redCountdown = light.e;
             // info.greenCountdown = ?? Hook doesn't seem to provide green countdown, or mixed?
             // Use same value for now or leave 0
             
             list.add(info);
        }
        
        notifyListenersTrafficLight(list);
        
        // [FIX] Update watchdog timestamp to prevent "IDLE" reset flickering
        mLastNaviUpdateTime = System.currentTimeMillis();
    }
}
