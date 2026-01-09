package cn.navitool;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DebugLogger {

    private static final String PREF_NAME = "navitool_prefs";
    private static final String KEY_DEBUG_MODE = "debug_mode";
    private static final String DEBUG_FILE_PREFIX = "navitool.debug."; // 用户动作日志
    private static final String LOGCAT_FILE_PREFIX = "navitool.logcat."; // Logcat输出
    private static final String FILE_SUFFIX = ".txt";
    private static String sCurrentDate = null;

    private static String getDebugFileName() {
        updateCurrentDate();
        return DEBUG_FILE_PREFIX + sCurrentDate + FILE_SUFFIX;
    }

    private static String getLogcatFileName() {
        updateCurrentDate();
        return LOGCAT_FILE_PREFIX + sCurrentDate + FILE_SUFFIX;
    }

    private static void updateCurrentDate() {
        String today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        if (!today.equals(sCurrentDate)) {
            sCurrentDate = today;
        }
    }

    private static final long LOG_COOLDOWN_MS = 60000; // 60 seconds cooldown

    private static boolean sIsDebugEnabled = false;

    public static void init(Context context) {
        if (context == null)
            return;
        // Debug 版本默认开启所有 debug 功能，无需手动开关
        if (BuildConfig.DEBUG) {
            sIsDebugEnabled = true;
        } else {
            sIsDebugEnabled = ConfigManager.getInstance().getBoolean(KEY_DEBUG_MODE, false);
        }
        if (sIsDebugEnabled) {
            new Thread(DebugLogger::createDirectories).start();
        }
    }

    public static boolean isDebugEnabled(Context context) {
        // Debug 版本始终返回 true
        if (BuildConfig.DEBUG) {
            return true;
        }
        return sIsDebugEnabled;
    }

    public static void setDebugEnabled(Context context, boolean enabled) {
        ConfigManager.getInstance().setBoolean(KEY_DEBUG_MODE, enabled);
        sIsDebugEnabled = enabled;
        if (enabled) {
            createDirectories();
        } else {
            deleteAllLogs();
        }
    }

    public static void deleteAllLogs() {
        try {
            File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
            // Delete all navitool log files and amap records
            File[] logFiles = dir.listFiles(
                    (d, name) -> (name.startsWith("navitool.") || name.startsWith("amap_")) && name.endsWith(".txt"));
            if (logFiles != null) {
                for (File f : logFiles) {
                    f.delete();
                }
            }
        } catch (Exception e) {
            Log.e("DebugLogger", "Failed to delete log files", e);
        }
    }

    public static void createDirectories() {
        try {
            File rootDir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
            if (!rootDir.exists()) {
                rootDir.mkdirs();
            }
            File soundDir = new File(rootDir, "Sound");
            if (!soundDir.exists()) {
                soundDir.mkdirs();
            }
        } catch (Exception e) {
            Log.e("DebugLogger", "Failed to create directories", e);
        }
    }

    // --- Action Log (写入 debug.txt，不输出 Logcat) ---
    public static void action(String tag, String message) {
        if (sIsDebugEnabled) {
            writeToFile(getDebugFileName(), "ACTION: " + tag + ": " + message);
        }
    }

    // --- Standard Log Wrappers (写入 logcat.txt) ---

    public static void d(String tag, String message) {
        Log.d(tag, message);
        if (sIsDebugEnabled) {
            writeToFile(getLogcatFileName(), "DEBUG: " + tag + ": " + message);
        }
    }

    public static void i(String tag, String message) {
        Log.i(tag, message);
        if (sIsDebugEnabled) {
            writeToFile(getLogcatFileName(), "INFO: " + tag + ": " + message);
        }
    }

    public static void w(String tag, String message) {
        Log.w(tag, message);
        if (sIsDebugEnabled) {
            writeToFile(getLogcatFileName(), "WARN: " + tag + ": " + message);
        }
    }

    public static void w(String tag, String message, Throwable tr) {
        Log.w(tag, message, tr);
        if (sIsDebugEnabled) {
            writeToFile(getLogcatFileName(),
                    "WARN: " + tag + ": " + message + "\nSTACK TRACE:\n" + android.util.Log.getStackTraceString(tr));
        }
    }

    public static void e(String tag, String message) {
        Log.e(tag, message);
        if (sIsDebugEnabled) {
            writeToFile(getLogcatFileName(), "ERROR: " + tag + ": " + message);
        }
    }

    public static void e(String tag, String message, Throwable tr) {
        Log.e(tag, message, tr);
        if (sIsDebugEnabled) {
            writeToFile(getLogcatFileName(),
                    "ERROR: " + tag + ": " + message + "\nSTACK TRACE:\n" + android.util.Log.getStackTraceString(tr));
        }
    }

    // --- Legacy / Specific Methods ---

    public static void log(Context context, String tag, String message) {
        // Redirect to new method, context ignored
        d(tag, message);
    }

    public static void toast(Context context, String message) {
        // Toast visible only in debug? Original logic seems to imply it.
        // Or "Debug Logger" toast implies it's for debug info.
        if (sIsDebugEnabled) {
            new android.os.Handler(android.os.Looper.getMainLooper())
                    .post(() -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show());
            writeToFile(getDebugFileName(), "TOAST: " + message);
        }
    }

    public static void toastAlways(Context context, String message) {
        new android.os.Handler(android.os.Looper.getMainLooper())
                .post(() -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show());
        if (sIsDebugEnabled) {
            writeToFile(getDebugFileName(), "TOAST: " + message);
        }
    }

    private static final java.util.concurrent.ExecutorService sLogExecutor = java.util.concurrent.Executors
            .newSingleThreadExecutor();

    private static void writeToFile(String fileName, String message) {
        sLogExecutor.execute(() -> {
            try {
                File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File file = new File(dir, fileName);
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
                        .format(new Date());
                String logMessage = timestamp + " " + message + "\n";

                try (FileOutputStream fos = new FileOutputStream(file, true)) {
                    fos.write(logMessage.getBytes());
                }
            } catch (Exception e) {
                // Look, if logging fails, we can't really log it to file, so just Logcat it
                Log.e("DebugLogger", "Failed to write to log file: " + fileName, e);
            }
        });
    }

    public static void logBootEvent(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("boot_log_prefs", Context.MODE_PRIVATE);
        long lastLogTime = prefs.getLong("last_log_time", 0);
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastLogTime > LOG_COOLDOWN_MS) {
            // Check debug state properly
            if (sIsDebugEnabled) {
                i("BootLogger", "软件已启动");
            }
            prefs.edit().putLong("last_log_time", currentTime).apply();
        } else {
            d("BootLogger", "Skipping boot log, cooldown active.");
        }
    }
}
