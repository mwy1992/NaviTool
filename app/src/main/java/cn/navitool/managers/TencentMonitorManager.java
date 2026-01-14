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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import cn.navitool.DebugLogger;

/**
 * 腾讯地图广播监听管理器
 * 用于记录 com.tencent.wecarnavi 相关的广播数据
 */
public class TencentMonitorManager {
    private static final String TAG = "TencentMonitorManager";
    private static final String LOG_FILENAME = "tencent_broadcast.txt";

    // 预设监听的 Action (由于未公开，这里包含一些推测的 Action)
    // 用户可根据实际日志反馈补充 Action
    private static final String[] ACTIONS_TO_MONITOR = {
            "com.tencent.wecarnavi",
            "com.tencent.map.navigation.broadcast",
            "com.tencent.wecarnavi.broadcast",
            "com.tencent.wecarnavi.action.NAVI_INFO",
            "WECARNAVIAUTO_STANDARD_BROADCAST_SEND", // 用户解包发现的发送广播
            "WECARNAVIAUTO_STANDARD_BROADCAST_RECV" // 用户解包发现的接收广播
    };

    private static volatile TencentMonitorManager instance;
    private Context mContext;
    private boolean isRegistered = false;

    // 异步日志线程
    private HandlerThread mLogThread;
    private Handler mLogHandler;

    private TencentMonitorManager(Context context) {
        this.mContext = context.getApplicationContext();
        initLogThread();
    }

    private void initLogThread() {
        mLogThread = new HandlerThread("TencentMonitorLogThread");
        mLogThread.start();
        mLogHandler = new Handler(mLogThread.getLooper());
    }

    public static TencentMonitorManager getInstance(Context context) {
        if (instance == null) {
            synchronized (TencentMonitorManager.class) {
                if (instance == null) {
                    instance = new TencentMonitorManager(context);
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
            for (String action : ACTIONS_TO_MONITOR) {
                filter.addAction(action);
            }
            // 允许接收未知的 Action (如果能匹配到 category 或 data，但通常广播需要精准 Action)
            // 这里我们尽量覆盖可能的命名空间

            mContext.registerReceiver(mReceiver, filter);
            isRegistered = true;
            DebugLogger.i(TAG,
                    "Starting Tencent Broadcast Monitor. Listening for: " + String.join(", ", ACTIONS_TO_MONITOR));
            logToFile("Monitor Started at " + new Date().toString());
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register receiver", e);
        }
    }

    public void stopMonitoring() {
        if (!isRegistered) {
            return;
        }
        try {
            mContext.unregisterReceiver(mReceiver);
            isRegistered = false;
            DebugLogger.i(TAG, "Stopped Tencent Broadcast Monitor.");
            logToFile("Monitor Stopped at " + new Date().toString());
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to unregister receiver", e);
        }
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                DebugLogger.d(TAG, "Received Broadcast: " + action);
                parseAndLogBroadcast(intent);
            } catch (Throwable t) {
                DebugLogger.e(TAG, "Error processing Tencent broadcast: " + t.getMessage());
            }
        }
    };

    private void parseAndLogBroadcast(Intent intent) {
        StringBuilder logBuilder = new StringBuilder();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());

        logBuilder.append("=== Broadcast Received [").append(timestamp).append("] ===\n");
        logBuilder.append("Action: ").append(intent.getAction()).append("\n");

        Bundle extras = intent.getExtras();
        if (extras != null) {
            Set<String> keys = extras.keySet();
            for (String key : keys) {
                Object value = extras.get(key);
                String valueStr = (value != null) ? value.toString() : "null";
                logBuilder.append("  ").append(key).append(" = ").append(valueStr).append("\n");
            }
        } else {
            logBuilder.append("  (No Extras)\n");
        }
        logBuilder.append("==============================================\n");

        // 打印到 Logcat
        System.out.println(TAG + ": " + logBuilder.toString());

        // 写入文件
        logToFile(logBuilder.toString());
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

            try (FileOutputStream fos = new FileOutputStream(file, true)) {
                fos.write((content + "\n").getBytes());
            } catch (IOException e) {
                Log.e(TAG, "Failed to write Tencent log to file", e);
            }
        });
    }
}
