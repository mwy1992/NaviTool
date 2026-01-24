package cn.navitool.managers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import android.app.ActivityManager;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import cn.navitool.utils.DebugLogger;

public class AmapMonitorManager {
    private static final String TAG = "AmapMonitorManager";
    private static final String AMAP_BROADCAST_ACTION = "AUTONAVI_STANDARD_BROADCAST_SEND";
    private static final String LOG_FILENAME = "amap_broadcast.txt";

    // Singleton instance
    private static volatile AmapMonitorManager instance;
    private Context mContext;
    private boolean isRegistered = false;

    // Async Logging
    private HandlerThread mLogThread;
    private Handler mLogHandler;

    private AmapMonitorManager(Context context) {
        this.mContext = context.getApplicationContext();
        // initLogThread();
    }

    private void initLogThread() {
        mLogThread = new HandlerThread("AmapMonitorLogThread");
        mLogThread.start();
        mLogHandler = new Handler(mLogThread.getLooper());
    }

    public static AmapMonitorManager getInstance(Context context) {
        if (instance == null) {
            synchronized (AmapMonitorManager.class) {
                if (instance == null) {
                    instance = new AmapMonitorManager(context);
                }
            }
        }
        return instance;
    }

    public void startMonitoring() {
        if (isRegistered) {
            return;
        }
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction(AMAP_BROADCAST_ACTION);
            mContext.registerReceiver(mAmapReceiver, filter);
            isRegistered = true;
            startProcessMonitor(); // Start Polling
            DebugLogger.i(TAG, "Starting Amap Broadcast Monitor...");
            // logToFile("Monitor Started: Listening for " + AMAP_BROADCAST_ACTION);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register receiver", e);
        }
    }

    public void stopMonitoring() {
        if (!isRegistered) {
            return;
        }
        try {
            mContext.unregisterReceiver(mAmapReceiver);
            isRegistered = false;
            stopProcessMonitor(); // Stop Polling
            DebugLogger.i(TAG, "Stopped Amap Broadcast Monitor.");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to unregister receiver", e);
        }
    }

    // --- Process Monitor ---
    private static final String AMAP_PKG = "com.autonavi.amapauto";
    // private static final String AMAP_PKG_MOBILE = "com.autonavi.minimap"; // Removed per user request
    private Handler mMonitorHandler;
    private boolean mIsAmapAlive = true; // Assume alive initially to avoid startup clear (let broadcasts handle it)
    // Actually, if we start assuming alive, and it's dead, we detect it in 10s and clear. Perfect.

    private final Runnable mMonitorRunnable = new Runnable() {
        @Override
        public void run() {
            checkAmapProcess();
            if (mMonitorHandler != null) {
                mMonitorHandler.postDelayed(this, 10000); // 10s interval
            }
        }
    };

    private void startProcessMonitor() {
        if (mMonitorHandler == null) {
            mMonitorHandler = new Handler(android.os.Looper.getMainLooper());
        }
        mMonitorHandler.removeCallbacks(mMonitorRunnable);
        mMonitorHandler.postDelayed(mMonitorRunnable, 10000); // Start check 10s later
    }

    private void stopProcessMonitor() {
        if (mMonitorHandler != null) {
            mMonitorHandler.removeCallbacks(mMonitorRunnable);
            mMonitorHandler = null;
        }
    }

    private void checkAmapProcess() {
        try {
            ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
            if (am == null) return;

            List<ActivityManager.RunningAppProcessInfo> processes = am.getRunningAppProcesses();
            if (processes == null || processes.isEmpty()) {
                // API restricted or error, do not assume death
                return;
            }

            boolean isRunning = false;
            for (ActivityManager.RunningAppProcessInfo info : processes) {
                if (info.processName.equals(AMAP_PKG)) {
                    isRunning = true;
                    break;
                }
            }

            if (!isRunning) {
                if (mIsAmapAlive) {
                    DebugLogger.w(TAG, "Monitor: Amap process died. Force Stop Navi.");
                    mIsAmapAlive = false;
                    // Trigger STOP event
                    if (mListener != null) {
                        mListener.onNaviStatusUpdate(2); // State 2 = Stop
                    }
                }
            } else {
                mIsAmapAlive = true;
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error checking process", e);
        }
    }

    private final BroadcastReceiver mAmapReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (AMAP_BROADCAST_ACTION.equals(intent.getAction())) {
                    parseAndLogBroadcast(intent);
                }
            } catch (Throwable t) {
                // [FIX] Catch BadParcelableException/ClassNotFoundException on Android 11+
                // triggered when unparceling extras from external apps (e.g. Amap)
                DebugLogger.e(TAG, "Error processing Amap broadcast: " + t.getMessage());
            }
        }
    };

    // Listener Interface for Broadcast Updates
    public interface OnBroadcastListener {
        void onTrafficLightUpdate(cn.navitool.managers.NaviInfoManager.TrafficLightInfo info);

        void onGuideInfoUpdate(cn.navitool.managers.NaviInfoManager.GuideInfo info);

        void onNaviStatusUpdate(int state);
    }

    private OnBroadcastListener mListener;

    public void setListener(OnBroadcastListener listener) {
        this.mListener = listener;
        // [STICKY] Push cached data immediately on attach
        // This ensures UI shows data even if no new broadcast arrives immediately
        if (mListener != null && mCachedGuideInfo != null) {
            DebugLogger.i(TAG, "setListener: Pushing cached GuideInfo");
            mListener.onGuideInfoUpdate(mCachedGuideInfo);
        }
    }

    // [CACHE] For Broadcast Deduplication
    private int mLastRouteRemainDis = -1;
    private int mLastRouteRemainTime = -1;
    private String mLastNextRoadName = "";
    private String mLastEtaText = ""; // [FIX] Added missing field
    private int mLastIcon = -1;
    // [STICKY] Cache latest GuideInfo for new listeners
    private cn.navitool.managers.NaviInfoManager.GuideInfo mCachedGuideInfo = null;

    private void parseAndLogBroadcast(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }

        int keyType = -1;
        if (extras.containsKey("KEY_TYPE")) {
            keyType = extras.getInt("KEY_TYPE", -1);
        }
        
        // [OPTIMIZATION] Filter out heavy/useless broadcasts IMMEDIATELY
        if (keyType == 13011 || keyType == 12205) {
            // 13011 = TMC Traffic Bar (Heavy JSON)
            // 12205 = Geolocation (High frequency)
            return; 
        }

        // [OPTIMIZATION] Handle Traffic Light FIRST with minimal processing
        // UI update is dispatched before any logging to minimize delay
        if (keyType == 60073) {
            // Traffic Light
            int status = getInt(extras, "trafficLightStatus");
            int time = getInt(extras, "redLightCountDownSeconds");
            int greenTime = getInt(extras, "greenLightLastSecond");
            int dir = getInt(extras, "dir");
            int wait = getInt(extras, "waitRound");

            if (mListener != null) {
                cn.navitool.managers.NaviInfoManager.TrafficLightInfo info = new cn.navitool.managers.NaviInfoManager.TrafficLightInfo();
                info.status = status;
                info.redCountdown = time;
                info.greenCountdown = greenTime;
                info.direction = dir;
                info.waitRound = wait;
                mListener.onTrafficLightUpdate(info);
            }
        } else if (keyType == 10001) {
            // Guide Info from Broadcast
            String roadName = extras.getString("CUR_ROAD_NAME");
            String nextRoadName = extras.getString("NEXT_ROAD_NAME");
            int icon = getInt(extras, "ICON");
            int routeRemainDis = getInt(extras, "ROUTE_REMAIN_DIS");
            int routeRemainTime = getInt(extras, "ROUTE_REMAIN_TIME");
            int segRemainDis = getInt(extras, "SEG_REMAIN_DIS");
            
            // [OPTIMIZATION] Deduplication
            // [FIX] Removed strict return. Previous logic suppressed updates for ETA/SegDis changes
            // and potentially caused state desync. We now allow all updates to flow to the UI.
            if (routeRemainDis == mLastRouteRemainDis && 
                routeRemainTime == mLastRouteRemainTime && 
                icon == mLastIcon &&
                (nextRoadName == null ? mLastNextRoadName == null : nextRoadName.equals(mLastNextRoadName)) &&
                (extras.getString("ETA_TEXT", "").equals(mLastEtaText != null ? mLastEtaText : ""))) {
                
                // If strictly identical (including ETA), we can skip LOGGING, 
                // but we should probably still notify listener to be safe, 
                // OR we can trust that if everything is identical, UI doesn't need update.
                // However, user reports "Logic not executing", so we FORCE UPDATE.
                // return; // <--- REMOVED
            }
            
            // Update Cache
            mLastRouteRemainDis = routeRemainDis;
            mLastRouteRemainTime = routeRemainTime;
            mLastIcon = icon;

            mLastNextRoadName = nextRoadName;
            mLastEtaText = extras.getString("ETA_TEXT", ""); // [FIX] Update ETA Cache

            if (mListener != null) {
                cn.navitool.managers.NaviInfoManager.GuideInfo info = new cn.navitool.managers.NaviInfoManager.GuideInfo();
                info.currentRoadName = roadName;
                info.nextRoadName = nextRoadName;
                info.iconType = icon;
                info.routeRemainDis = routeRemainDis;
                info.routeRemainTime = routeRemainTime;
                info.segRemainDis = segRemainDis;
                info.etaText = extras.getString("ETA_TEXT"); // Parse ETA Text

                // [STICKY] Update Cache
                mCachedGuideInfo = info;

                mListener.onGuideInfoUpdate(info);
            }
            System.out.println(
                    "Captured GuideInfo (Broadcast): Road=" + roadName + ", Next=" + nextRoadName + ", Dis="
                            + routeRemainDis);
        } else if (keyType == 10019) {
            // [NEW] Navigation State Update (Start/Stop)
            int state = getInt(extras, "EXTRA_STATE");
            
            // [FIX] 导航结束时清理所有缓存 (Changed from 2 to 40)
            if (state == 40) {
                mLastRouteRemainDis = -1;
                mLastRouteRemainTime = -1;
                mLastNextRoadName = "";
                mLastIcon = -1;
                mCachedGuideInfo = null;
                DebugLogger.i(TAG, "Navigation ended (state=2), cache cleared");
            }
            
            if (mListener != null) {
                mListener.onNaviStatusUpdate(state);
            }
            System.out.println("Captured NaviStatus (Broadcast): State=" + state);
        }

        // [DEBUG] Log ALL broadcasts (Reserved for deep debugging, disabled for release)
        /*
        if (keyType != 60073) { 
            StringBuilder consoleLog = new StringBuilder();
            consoleLog.append("[AMAP_RAW] KEY_TYPE=").append(keyType).append(" | ");
            Set<String> allKeys = extras.keySet();
            for (String key : allKeys) {
                Object value = extras.get(key);
                consoleLog.append(key).append("=").append(value).append(", ");
            }
            DebugLogger.e(TAG, consoleLog.toString());
        }
        */

        // File logging is async (via mLogHandler), so it won't block
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("--- Broadcast Received ---\n");
        logBuilder.append("KEY_TYPE: ").append(keyType).append("\n");
        Set<String> keys = extras.keySet();
        for (String key : keys) {
            Object value = extras.get(key);
            String valueStr = (value != null) ? value.toString() : "null";
            logBuilder.append(key).append(" = ").append(valueStr).append("\n");
        }
        logBuilder.append("--------------------------\n");

        // Write to file (async)
        // logToFile(logBuilder.toString());
    }

    /**
     * Helper to safely get Int from Bundle (handles String parsing)
     */
    private int getInt(Bundle extras, String key) {
        Object val = extras.get(key);
        if (val instanceof Integer) {
            return (Integer) val;
        } else if (val instanceof String) {
            try {
                return Integer.parseInt((String) val);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else if (val instanceof Double) {
            return ((Double) val).intValue();
        }
        return 0;
    }

    private void logToFile(String content) {
        if (mLogHandler == null)
            return;

        mLogHandler.post(() -> {
            File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, LOG_FILENAME);
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
            String finalLog = timestamp + "\n" + content + "\n";

            try (FileOutputStream fos = new FileOutputStream(file, true)) {
                fos.write(finalLog.getBytes());
            } catch (IOException e) {
                Log.e(TAG, "Failed to write Amap log to file", e);
            }
        });
    }
}
