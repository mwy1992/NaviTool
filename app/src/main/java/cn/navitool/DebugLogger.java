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
    private static final String LOG_FILE_NAME = "navitool.debug.txt";
    private static final long LOG_COOLDOWN_MS = 60000; // 60 seconds cooldown

    private static boolean sIsDebugEnabled = false;

    public static void init(Context context) {
        if (context == null)
            return;
        sIsDebugEnabled = ConfigManager.getInstance().getBoolean(KEY_DEBUG_MODE, false);
        if (sIsDebugEnabled) {
            new Thread(DebugLogger::createDirectories).start();
        }
    }

    public static boolean isDebugEnabled(Context context) {
        return sIsDebugEnabled;
    }

    public static void setDebugEnabled(Context context, boolean enabled) {
        ConfigManager.getInstance().setBoolean(KEY_DEBUG_MODE, enabled);
        sIsDebugEnabled = enabled;
        if (enabled) {
            createDirectories();
        } else {
            deleteLogFile();
        }
    }

    private static void deleteLogFile() {
        try {
            File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
            File file = new File(dir, LOG_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            Log.e("DebugLogger", "Failed to delete log file", e);
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

    // --- Standard Log Wrappers ---

    public static void d(String tag, String message) {
        Log.d(tag, message);
        if (sIsDebugEnabled) {
            writeToFile("DEBUG: " + tag + ": " + message);
        }
    }

    public static void i(String tag, String message) {
        Log.i(tag, message);
        if (sIsDebugEnabled) {
            writeToFile("INFO: " + tag + ": " + message);
        }
    }

    public static void w(String tag, String message) {
        Log.w(tag, message);
        if (sIsDebugEnabled) {
            writeToFile("WARN: " + tag + ": " + message);
        }
    }

    public static void w(String tag, String message, Throwable tr) {
        Log.w(tag, message, tr);
        if (sIsDebugEnabled) {
            writeToFile(
                    "WARN: " + tag + ": " + message + "\nSTACK TRACE:\n" + android.util.Log.getStackTraceString(tr));
        }
    }

    public static void e(String tag, String message) {
        Log.e(tag, message);
        if (sIsDebugEnabled) {
            writeToFile("ERROR: " + tag + ": " + message);
        }
    }

    public static void e(String tag, String message, Throwable tr) {
        Log.e(tag, message, tr);
        if (sIsDebugEnabled) {
            writeToFile(
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
            writeToFile("TOAST: " + message);
        }
    }

    public static void toastAlways(Context context, String message) {
        new android.os.Handler(android.os.Looper.getMainLooper())
                .post(() -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show());
        if (sIsDebugEnabled) {
            writeToFile("TOAST: " + message);
        }
    }

    private static void writeToFile(String message) {
        File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, LOG_FILE_NAME);
        // Add timestamp if not already present?
        // Existing logic adds timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date()); // Added
                                                                                                                    // ms
        String logMessage = timestamp + " " + message + "\n";

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(logMessage.getBytes());
        } catch (IOException e) {
            Log.e("DebugLogger", "Failed to write to log file", e);
        }
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
