package cn.navitool.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.navitool.utils.DebugLogger;
import cn.navitool.R;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "BootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action) ||
                "android.intent.action.QUICKBOOT_POWERON".equals(action) ||
                "com.htc.intent.action.QUICKBOOT_POWERON".equals(action) ||
                Intent.ACTION_USER_PRESENT.equals(action) ||
                Intent.ACTION_POWER_CONNECTED.equals(action) ||
                Intent.ACTION_POWER_DISCONNECTED.equals(action)) {

            DebugLogger.toast(context, context.getString(R.string.boot_event_detected));
            DebugLogger.log(context, TAG, "Boot event received: " + action);

            // Log boot event via DebugLogger
            DebugLogger.logBootEvent(context);

            // Start Traffic Light Monitoring (Broadcast)
            DebugLogger.log(context, TAG, "Starting Amap Broadcast Monitor...");
            cn.navitool.managers.AmapMonitorManager.getInstance(context).startMonitoring();

            // Start Amap AIDL Connection
            DebugLogger.log(context, TAG, "Connecting to Amap AIDL Service...");
            // AmapAidlManager removed
            // cn.navitool.managers.AmapAidlManager.getInstance(context).connect();

        }
    }
}
