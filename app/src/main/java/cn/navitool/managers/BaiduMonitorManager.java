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

import cn.navitool.utils.DebugLogger;

/**
 * 百度地图车机版广播监听管理器
 * 用于记录 com.baidu.naviauto 相关的广播数据
 */
public class BaiduMonitorManager {
    private static final String TAG = "BaiduMonitorManager";
    private static final String LOG_FILENAME = "baidu_broadcast.txt";

    // 官方文档定义的导航诱导广播 Action
    private static final String ACTION_NAVI_INDUCED = "com.baidu.map.auto.NOTIFY.ACTION_NAVI_INDUCUD";

    // 监听列表
    private static final String[] ACTIONS_TO_MONITOR = {
            ACTION_NAVI_INDUCED,
            "com.baidu.naviauto.action.recv", // 百度地图接收的广播（可能用于调试）
            "com.baidu.naviauto.action.send" // 百度地图发送的广播
    };

    private static volatile BaiduMonitorManager instance;
    private Context mContext;
    private boolean isRegistered = false;

    // 异步日志线程
    private HandlerThread mLogThread;
    private Handler mLogHandler;

    private BaiduMonitorManager(Context context) {
        this.mContext = context.getApplicationContext();
        initLogThread();
    }

    private void initLogThread() {
        mLogThread = new HandlerThread("BaiduMonitorLogThread");
        mLogThread.start();
        mLogHandler = new Handler(mLogThread.getLooper());
    }

    public static BaiduMonitorManager getInstance(Context context) {
        if (instance == null) {
            synchronized (BaiduMonitorManager.class) {
                if (instance == null) {
                    instance = new BaiduMonitorManager(context);
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

            mContext.registerReceiver(mReceiver, filter);
            isRegistered = true;
            DebugLogger.i(TAG,
                    "Starting Baidu Broadcast Monitor. Listening for: " + String.join(", ", ACTIONS_TO_MONITOR));
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
            DebugLogger.i(TAG, "Stopped Baidu Broadcast Monitor.");
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
                DebugLogger.e(TAG, "Error processing Baidu broadcast: " + t.getMessage());
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
                Log.e(TAG, "Failed to write Baidu log to file", e);
            }
        });
    }
}
