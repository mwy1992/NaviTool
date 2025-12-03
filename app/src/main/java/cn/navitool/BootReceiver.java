package cn.navitool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

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
            
            // Start the BootLogService
            Intent serviceIntent = new Intent(context, BootLogService.class);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent);
            } else {
                context.startService(serviceIntent);
            }
        }
    }
}
