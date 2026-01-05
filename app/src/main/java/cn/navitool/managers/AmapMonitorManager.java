package cn.navitool.managers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import cn.navitool.DebugLogger;

public class AmapMonitorManager {
    private static final String TAG = "AmapMonitorManager";
    private static final String AMAP_BROADCAST_ACTION = "AUTONAVI_STANDARD_BROADCAST_SEND";
    private static final String LOG_FILENAME = "amap_broadcast.txt";

    // Singleton instance
    private static AmapMonitorManager instance;
    private Context mContext;
    private boolean isRegistered = false;

    private AmapMonitorManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized AmapMonitorManager getInstance(Context context) {
        if (instance == null) {
            instance = new AmapMonitorManager(context);
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
            DebugLogger.i(TAG, "Starting Amap Broadcast Monitor...");
            logToFile("Monitor Started: Listening for " + AMAP_BROADCAST_ACTION);
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
            DebugLogger.i(TAG, "Stopped Amap Broadcast Monitor.");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to unregister receiver", e);
        }
    }

    private final BroadcastReceiver mAmapReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (AMAP_BROADCAST_ACTION.equals(intent.getAction())) {
                parseAndLogBroadcast(intent);
            }
        }
    };

    private void parseAndLogBroadcast(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }

        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("--- Broadcast Received ---\n");

        int keyType = -1;
        if (extras.containsKey("KEY_TYPE")) {
            keyType = extras.getInt("KEY_TYPE", -1);
        }

        // Special handling for Traffic Light Info
        if (keyType == 60073) {
            logBuilder.append(">>> TARGET FOUND: TRAFFIC LIGHT INFO (60073) <<<\n");
            int status = extras.getInt("trafficLightStatus", -1);
            int redCount = extras.getInt("redLightCountDownSeconds", -1);
            int greenLast = extras.getInt("greenLightLastSecond", -1);
            int dir = extras.getInt("dir", -1);
            int waitRound = extras.getInt("waitRound", -1);

            logBuilder.append("Status: ").append(status).append("\n");
            logBuilder.append("Red Count: ").append(redCount).append("\n");
            logBuilder.append("Green Last: ").append(greenLast).append("\n");
            logBuilder.append("Direction: ").append(dir).append("\n");
            logBuilder.append("Wait Round: ").append(waitRound).append("\n");
            logBuilder.append("--------------------------\n");

            // Also log to Logcat for immediate visibility
            DebugLogger.e(TAG, "Captured Traffic Light: Status=" + status + ", Red=" + redCount);
        }

        // Log all keys as before
        Set<String> keys = extras.keySet();
        for (String key : keys) {
            Object value = extras.get(key);
            String valueStr = (value != null) ? value.toString() : "null";
            logBuilder.append(key).append(" = ").append(valueStr).append("\n");
        }
        logBuilder.append("--------------------------\n");

        // Write to file
        logToFile(logBuilder.toString());
    }

    private void logToFile(String content) {
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
    }
}
