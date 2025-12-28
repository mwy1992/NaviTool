package cn.navitool;

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
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        DebugLogger.w(TAG, "Notification Listener DISCONNECTED!");
    }
}
