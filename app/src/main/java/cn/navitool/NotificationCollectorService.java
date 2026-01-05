package cn.navitool;

import android.os.Bundle;
import android.service.notification.NotificationListenerService;

// This service exists solely to gain "Notification Access" permission,
// which is required to use MediaSessionManager.addOnActiveSessionsChangedListener
// on non-system apps without root.
public class NotificationCollectorService extends NotificationListenerService {
    private static final String TAG = "NotificationService";

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        DebugLogger.i(TAG, "Notification Listener CONNECTED! We have permission.");
        // Notify ClusterHudManager to re-init media listener immediately
        android.content.Intent intent = new android.content.Intent("cn.navitool.NOTIFICATION_LISTENER_CONNECTED");
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    @Override
    public void onNotificationPosted(android.service.notification.StatusBarNotification sbn) {
        if ("com.autonavi.amapauto".equals(sbn.getPackageName())) {
            android.app.Notification notification = sbn.getNotification();
            if (notification == null)
                return;

            Bundle extras = notification.extras;
            StringBuilder logBuilder = new StringBuilder();
            logBuilder.append("--- Notification Received ---\n");
            logBuilder.append("Time: ").append(new java.text.SimpleDateFormat("HH:mm:ss", java.util.Locale.getDefault())
                    .format(new java.util.Date())).append("\n");

            CharSequence title = extras.getCharSequence(android.app.Notification.EXTRA_TITLE);
            CharSequence text = extras.getCharSequence(android.app.Notification.EXTRA_TEXT);
            CharSequence subText = extras.getCharSequence(android.app.Notification.EXTRA_SUB_TEXT);

            logBuilder.append("Title: ").append(title).append("\n");
            logBuilder.append("Text: ").append(text).append("\n");
            logBuilder.append("SubText: ").append(subText).append("\n");

            // Ticker text (often updates more frequently)
            if (notification.tickerText != null) {
                logBuilder.append("Ticker: ").append(notification.tickerText).append("\n");
            }
            logBuilder.append("-----------------------------\n");

            // Reuse DebugLogger logic but to a separate file
            writeFile("amap_notification.txt", logBuilder.toString());
        }
    }

    private void writeFile(String fileName, String content) {
        try {
            java.io.File dir = new java.io.File(android.os.Environment.getExternalStorageDirectory(), "NaviTool");
            if (!dir.exists())
                dir.mkdirs();
            java.io.File file = new java.io.File(dir, fileName);
            try (java.io.FileOutputStream fos = new java.io.FileOutputStream(file, true)) {
                fos.write(content.getBytes());
            }
        } catch (Exception e) {
            android.util.Log.e(TAG, "Failed to write notification log", e);
        }
    }
}
