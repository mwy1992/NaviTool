package cn.navitool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SimulateIgnitionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("cn.navitool.ACTION_SIMULATE_ENGINE_START".equals(intent.getAction())) {
            try {
                android.widget.Toast.makeText(context, "收到模拟点火广播", android.widget.Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                // Ignore if background thread or context issue
            }

            DebugLogger.i("SimulateIgnitionReceiver", "Received Simulation Broadcast");
            if (KeepAliveAccessibilityService.getInstance() != null) {
                // Reset Ignition State for simulation to ensure it triggers every time we ask
                KeepAliveAccessibilityService.getInstance().resetIgnitionState();
                KeepAliveAccessibilityService.getInstance().handleIgnitionDriving();
            } else {
                DebugLogger.e("SimulateIgnitionReceiver", "Service is NULL - cannot simulate ignition");
                try {
                    android.widget.Toast.makeText(context, "错误: 无障碍服务未运行!", android.widget.Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                }
            }
        }
    }
}
