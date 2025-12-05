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

    public static boolean isDebugEnabled(Context context) {
        if (!BuildConfig.DEBUG) {
            return false;
        }
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_DEBUG_MODE, false);
    }

    public static void setDebugEnabled(Context context, boolean enabled) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_DEBUG_MODE, enabled).apply();

        if (!enabled) {
            // Delete log file if debug is disabled
            File file = new File(Environment.getExternalStorageDirectory(), LOG_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void log(Context context, String tag, String message) {
        if (isDebugEnabled(context)) {
            Log.d(tag, message);
            writeToFile(tag + ": " + message);
        }
    }

    public static void toast(Context context, String message) {
        if (isDebugEnabled(context)) {
            new android.os.Handler(android.os.Looper.getMainLooper())
                    .post(() -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show());
            writeToFile("TOAST: " + message);
        }
    }

    private static void writeToFile(String message) {
        File file = new File(Environment.getExternalStorageDirectory(), LOG_FILE_NAME);
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
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
            if (isDebugEnabled(context)) {
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                String logMessage = "软件已启动 " + timestamp;
                log(context, "BootLogger", logMessage);
            }
            prefs.edit().putLong("last_log_time", currentTime).apply();
        } else {
            Log.d("BootLogger", "Skipping boot log, cooldown active.");
        }
    }
}
