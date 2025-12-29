package cn.navitool.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.io.ByteArrayOutputStream;

import cn.navitool.DebugLogger;

public class MediaNotificationListener extends NotificationListenerService {
    private static final String TAG = "MediaNotifListener";
    public static final String ACTION_MEDIA_INFO_UPDATE = "cn.navitool.MEDIA_INFO_UPDATE";
    public static final String ACTION_REQUEST_MEDIA_REBROADCAST = "cn.navitool.ACTION_REQUEST_MEDIA_REBROADCAST";
    private android.os.Handler mWorkHandler;
    private android.os.HandlerThread mHandlerThread;
    private RequestReceiver mRequestReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        DebugLogger.i(TAG, "MediaNotificationListener created");

        // Initialize Background Worker
        mHandlerThread = new android.os.HandlerThread("MediaNotifWorker");
        mHandlerThread.start();
        mWorkHandler = new android.os.Handler(mHandlerThread.getLooper());

        // Register Request Receiver
        mRequestReceiver = new RequestReceiver();
        IntentFilter filter = new IntentFilter(ACTION_REQUEST_MEDIA_REBROADCAST);
        registerReceiver(mRequestReceiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRequestReceiver != null) {
            unregisterReceiver(mRequestReceiver);
        }
        if (mHandlerThread != null) {
            mHandlerThread.quitSafely();
            mHandlerThread = null;
            mWorkHandler = null;
        }
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        DebugLogger.i(TAG, "Notification Listener Connected");
        // Offload processing to avoid blocking Main Thread startup
        if (mWorkHandler != null) {
            mWorkHandler.post(this::checkForActiveMedia);
        }
    }

    private void checkForActiveMedia() {
        try {
            StatusBarNotification[] notifications = getActiveNotifications();
            if (notifications != null) {
                for (StatusBarNotification sbn : notifications) {
                    processNotification(sbn);
                }
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error checking active media", e);
        }
    }

    private class RequestReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ACTION_REQUEST_MEDIA_REBROADCAST.equals(intent.getAction())) {
                DebugLogger.i(TAG, "Received Re-Broadcast Request");
                if (mWorkHandler != null) {
                    mWorkHandler.post(MediaNotificationListener.this::checkForActiveMedia);
                }
            }
        }
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (mWorkHandler != null) {
            mWorkHandler.post(() -> processNotification(sbn));
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // Optional: Handle removal if needed
    }

    private void processNotification(StatusBarNotification sbn) {
        if (sbn == null)
            return;

        Notification notification = sbn.getNotification();
        if (notification == null || notification.extras == null)
            return;

        Bundle extras = notification.extras;
        String packageName = sbn.getPackageName();

        // Check for MediaSession Token
        Parcelable tokenParcelable = extras.getParcelable(Notification.EXTRA_MEDIA_SESSION);
        MediaSession.Token token = null;
        if (tokenParcelable instanceof MediaSession.Token) {
            token = (MediaSession.Token) tokenParcelable;
        }

        if (token != null) {
            MediaController controller = new MediaController(this, token);
            extractMediaInfo(controller, packageName);
        }
    }

    private void extractMediaInfo(MediaController controller, String packageName) {
        if (controller == null)
            return;

        MediaMetadata metadata = controller.getMetadata();
        PlaybackState playbackState = controller.getPlaybackState();

        if (metadata == null)
            return;

        String title = metadata.getString(MediaMetadata.METADATA_KEY_TITLE);
        String artist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
        String album = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        Bitmap albumArt = metadata.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART);

        if (albumArt == null) {
            albumArt = metadata.getBitmap(MediaMetadata.METADATA_KEY_ART);
        }

        boolean isPlaying = false;
        if (playbackState != null) {
            isPlaying = playbackState.getState() == PlaybackState.STATE_PLAYING;
        }

        // Only broadcast if we have at least a title
        if (title != null) {
            Intent intent = new Intent(ACTION_MEDIA_INFO_UPDATE);
            intent.putExtra("package_name", packageName);
            intent.putExtra("title", title);
            intent.putExtra("artist", artist != null ? artist : "");
            intent.putExtra("album", album != null ? album : "");
            intent.putExtra("is_playing", isPlaying);

            // Compress Bitmap if exists (Transporting large bitmaps via Intent is risky,
            // keep it small)
            if (albumArt != null) {
                // Resize if too big to avoid TransactionTooLargeException
                if (albumArt.getByteCount() > 500000) { // Limit to ~500KB
                    // Simple scaling logic could go here, for now just skip if massive
                    // or send a flag saying "has_art" and handle retrieval separately if needed
                } else {
                    try {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        albumArt.compress(Bitmap.CompressFormat.PNG, 100, baos);
                        byte[] b = baos.toByteArray();
                        intent.putExtra("artwork", b);
                    } catch (Exception e) {
                        DebugLogger.e(TAG, "Failed to compress artwork", e);
                    }
                }
            }

            // Using sendBroadcast (explicit permission required by receiver usually,
            // but we are same app signed, so standard broadcast works for internal usage)
            // Ideally use LocalBroadcastManager if entirely internal, but HUDService might
            // be separate process later?
            // Current Plan: MainActivity receives it.
            // Since Service and Activity likely same process, simple broadcast is fine.
            intent.setPackage(getPackageName()); // Restrict to own app
            sendBroadcast(intent);

            DebugLogger.i(TAG, "Broadcast Media Update: " + title + " - " + artist);
        }
    }
}
