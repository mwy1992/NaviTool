package cn.navitool;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BootLogService extends Service {

    private static final long LOG_COOLDOWN_MS = 60000; // 60 seconds cooldown

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.content.SharedPreferences prefs = getSharedPreferences("boot_log_prefs", MODE_PRIVATE);
        long lastLogTime = prefs.getLong("last_log_time", 0);
        long currentTime = System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory(), "bootcount.txt");

        if (currentTime - lastLogTime > LOG_COOLDOWN_MS || !file.exists()) {
            writeBootLog();
            prefs.edit().putLong("last_log_time", currentTime).apply();
        } else {
            Log.d("BootLogService", "Skipping log, cooldown active.");
        }
        
        // Execute configured app launches
        AppLaunchManager.executeLaunch(this);
        
        return START_NOT_STICKY;
    }

    private void writeBootLog() {
        if (!DebugLogger.isDebugEnabled(this)) {
            Log.d("BootLogService", getString(R.string.boot_log_skipped));
            stopSelf();
            return;
        }

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        String logMessage = "软件已启动 " + timestamp;

        DebugLogger.log(this, "BootLogService", logMessage);
        
        // Stop the service after logging
        stopSelf();
    }
}
