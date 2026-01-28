package cn.navitool.service;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.List;

import cn.navitool.utils.DebugLogger;

public class MediaNotificationListener extends NotificationListenerService {
    private static final String TAG = "MediaNotifListener";
    public static final String ACTION_MEDIA_INFO_UPDATE = "cn.navitool.MEDIA_INFO_UPDATE";
    public static final String ACTION_REQUEST_MEDIA_REBROADCAST = "cn.navitool.ACTION_REQUEST_MEDIA_REBROADCAST";

    private android.os.Handler mWorkHandler;
    private android.os.HandlerThread mHandlerThread;
    private RequestReceiver mRequestReceiver;

    private MediaSessionManager mMediaSessionManager;
    private MediaController mCurrentController;
    private final MediaControllerCallback mMediaControllerCallback = new MediaControllerCallback();

    @Override
    public void onCreate() {
        super.onCreate();
        DebugLogger.i(TAG, "MediaNotificationListener created");

        // Initialize Background Worker
        mHandlerThread = new android.os.HandlerThread("MediaNotifWorker");
        mHandlerThread.start();
        mWorkHandler = new android.os.Handler(mHandlerThread.getLooper());

        // Initialize MediaSessionManager
        try {
            mMediaSessionManager = (MediaSessionManager) getSystemService(Context.MEDIA_SESSION_SERVICE);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to get MediaSessionManager", e);
        }

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

        // Unregister Session Listener
        if (mMediaSessionManager != null) {
            try {
                mMediaSessionManager.removeOnActiveSessionsChangedListener(mSessionChangedListener);
            } catch (Exception e) {
                // Ignore
            }
        }

        // Unregister Controller Callback
        unregisterCurrentController();

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

        // Initialize Media Session Monitoring logic in Background
        if (mWorkHandler != null) {
            mWorkHandler.post(this::initMediaSessionMonitoring);
        }
    }

    private void initMediaSessionMonitoring() {
        if (mMediaSessionManager == null)
            return;

        ComponentName componentName = new ComponentName(this, MediaNotificationListener.class);
        try {
            mMediaSessionManager.addOnActiveSessionsChangedListener(mSessionChangedListener, componentName,
                    mWorkHandler);
            // Initial Check
            List<MediaController> controllers = mMediaSessionManager.getActiveSessions(componentName);
            updateActiveSession(controllers);
        } catch (SecurityException e) {
            DebugLogger.e(TAG, "Security Exception accessing Active Sessions. Is Notification Permission granted?", e);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error init monitoring", e);
        }
    }

    private final MediaSessionManager.OnActiveSessionsChangedListener mSessionChangedListener = this::updateActiveSession;

    private void updateActiveSession(List<MediaController> controllers) {
        if (controllers == null || controllers.isEmpty()) {
            unregisterCurrentController();
            broadcastClearState(); // [FIX] Broadcast cleanup when no sessions exist (Process Death)
            return;
        }

        // Strategy: Find the first controller that is PLAYING, or default to the first
        // one
        MediaController targetController = null;

        for (MediaController controller : controllers) {
            PlaybackState state = controller.getPlaybackState();
            if (state != null && state.getState() == PlaybackState.STATE_PLAYING) {
                targetController = controller;
                break;
            }
        }

        if (targetController == null && !controllers.isEmpty()) {
            targetController = controllers.get(0);
        }

        if (targetController != null) {
            // Check if it's the same as current
            if (mCurrentController != null &&
                    mCurrentController.getPackageName().equals(targetController.getPackageName())) {
                // Same app, maybe nice to just keep it, but ensure callback is registered
                // For simplicity, if it's the same object, do nothing. If different object
                // (recreated), re-register.
                // But MediaController objects might be different for same session?
                // Let's just switch if the Token is different?
                // Actually, simple logic: Unregister old, Register new.
            }
            registerNewController(targetController);
        }
    }

    private void registerNewController(MediaController controller) {
        unregisterCurrentController();
        mCurrentController = controller;
        if (mCurrentController != null) {
            // Unregister needs to be happening on mCurrentController, which is now set.
            // Wait, logic is: Unregister OLD, set NEW, Register NEW.
            mCurrentController.registerCallback(mMediaControllerCallback, mWorkHandler);
            // Force immediate update
            extractMediaInfo(mCurrentController);
        }
    }

    private void unregisterCurrentController() {
        if (mCurrentController != null) {
            mCurrentController.unregisterCallback(mMediaControllerCallback);
            mCurrentController = null;
        }
    }

    private class MediaControllerCallback extends MediaController.Callback {
        @Override
        public void onPlaybackStateChanged(PlaybackState state) {
            if (mCurrentController != null) {
                extractMediaInfo(mCurrentController);
            }
        }

        @Override
        public void onMetadataChanged(MediaMetadata metadata) {
            if (mCurrentController != null) {
                extractMediaInfo(mCurrentController);
            }
        }

        @Override
        public void onSessionDestroyed() {
            super.onSessionDestroyed();
            // [FIX] Broadcast cleanup when current session is destroyed
            unregisterCurrentController();
            broadcastClearState();
        }
    }

    // [FIX] Helper to broadcast empty/clear state
    private void broadcastClearState() {
        Intent intent = new Intent(ACTION_MEDIA_INFO_UPDATE);
        MediaInfo emptyInfo = new MediaInfo();
        intent.putExtra("media_info", emptyInfo);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
        
        mLastMediaInfo = null; // Reset cache
        DebugLogger.i(TAG, "Broadcast Clear State (Session End/Destroyed)");
    }

    // Keep RequestReceiver for Re-Broadcasts
    private class RequestReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ACTION_REQUEST_MEDIA_REBROADCAST.equals(intent.getAction())) {
                DebugLogger.i(TAG, "Received Re-Broadcast Request");
                if (mWorkHandler != null) {
                    mWorkHandler.post(() -> {
                        if (mCurrentController != null) {
                            extractMediaInfo(mCurrentController, true); // [FIX] Force update on request
                        } else {
                            // Try to refresh active sessions
                            initMediaSessionMonitoring();
                        }
                    });
                }
            }
        }
    }

    // Fallback: If no sessions, or to catch legacy/odd apps, we can still listen to
    // notifications?
    // User requested optimization using MediaSession, implying Session is primary.
    // mconfig+ logic relies heavily on MediaSession logic but might have used
    // Notification as entry point?
    // No, mconfig+ NotificationListener inherits NLS but uses getActiveSessions
    // primarily.
    // We will stick to Session logic as primary.

    // Fallback variable for Notification Large Icon
    private Bitmap mFallbackNotificationBitmap = null;

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (mCurrentController != null && sbn.getPackageName().equals(mCurrentController.getPackageName())) {
            Notification notification = sbn.getNotification();
            Bundle extras = notification.extras;
            if (extras != null) {
                Bitmap largeIcon = null;
                // [FIX] 兼容 API 23+: EXTRA_LARGE_ICON 可能是 Icon 或 Bitmap
                Object iconObj = extras.getParcelable(Notification.EXTRA_LARGE_ICON);
                if (iconObj instanceof Bitmap) {
                    largeIcon = (Bitmap) iconObj;
                } else if (iconObj instanceof android.graphics.drawable.Icon) {
                    // 将 Icon 转换为 Bitmap
                    try {
                        android.graphics.drawable.Icon icon = (android.graphics.drawable.Icon) iconObj;
                        android.graphics.drawable.Drawable drawable = icon.loadDrawable(MediaNotificationListener.this);
                        if (drawable != null) {
                            int width = drawable.getIntrinsicWidth();
                            int height = drawable.getIntrinsicHeight();
                            if (width > 0 && height > 0) {
                                largeIcon = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                                android.graphics.Canvas canvas = new android.graphics.Canvas(largeIcon);
                                drawable.setBounds(0, 0, width, height);
                                drawable.draw(canvas);
                            }
                        }
                    } catch (Exception e) {
                        DebugLogger.w(TAG, "Failed to convert Icon to Bitmap: " + e.getMessage());
                    }
                }
                if (largeIcon != null) {
                    DebugLogger.d(TAG, "Captured LargeIcon from Notification for fallback: " + sbn.getPackageName());
                    mFallbackNotificationBitmap = largeIcon;
                    // Trigger update to use this new bitmap if needed
                    extractMediaInfo(mCurrentController);
                }
            }
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        if (mCurrentController != null && sbn.getPackageName().equals(mCurrentController.getPackageName())) {
            // If we rely on notification for art, and it's gone, maybe we should clear it?
            // But music might still be playing. Let's keep it until session dies or new art
            // comes.
        }
    }

    // [Refactor] Use MediaInfo model
    private MediaInfo mLastMediaInfo = null;

    private void extractMediaInfo(MediaController controller) {
        extractMediaInfo(controller, false);
    }

    private void extractMediaInfo(MediaController controller, boolean force) {
        if (controller == null)
            return;

        MediaMetadata metadata = controller.getMetadata();
        PlaybackState playbackState = controller.getPlaybackState();
        String packageName = controller.getPackageName();

        // Reset fallback if package changed (Optimization: Check packageName against stored MediaInfo)
        if (mLastMediaInfo != null && !packageName.equals(mLastMediaInfo.packageName)) {
            mFallbackNotificationBitmap = null;
        }

        String title = null;
        String artist = null;
        String album = null;
        Bitmap albumArt = null;

        if (metadata != null) {
            title = metadata.getString(MediaMetadata.METADATA_KEY_TITLE);
            artist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
            album = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
            
            // [FIX] Reset fallback if Song Title Changed (Prevents Ghost Art from previous song)
            if (mLastMediaInfo != null && title != null && !title.equals(mLastMediaInfo.title)) {
                // If we are same package but different song, clear old fallback art
                // This ensures we don't apply Song A's cached Notification Icon to Song B
                if (packageName.equals(mLastMediaInfo.packageName)) {
                     mFallbackNotificationBitmap = null;
                }
            }

            albumArt = metadata.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART);

            if (albumArt == null) {
                albumArt = metadata.getBitmap(MediaMetadata.METADATA_KEY_ART);
            }
            if (albumArt == null) {
                albumArt = metadata.getBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON);
            }

            // Fallback: Check for URI strings
            if (albumArt == null) {
                String artUriStr = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM_ART_URI);
                if (artUriStr == null)
                    artUriStr = metadata.getString(MediaMetadata.METADATA_KEY_ART_URI);
                if (artUriStr == null)
                    artUriStr = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_ICON_URI);

                if (artUriStr != null) {
                    try {
                        android.net.Uri uri = android.net.Uri.parse(artUriStr);
                        try (java.io.InputStream is = getContentResolver().openInputStream(uri)) {
                            if (is != null) {
                                albumArt = android.graphics.BitmapFactory.decodeStream(is);
                            }
                        }
                    } catch (Exception e) {
                        DebugLogger.w(TAG, "Failed URI load: " + e.getMessage());
                    }
                }
            }
        }

        // Final Fallback: Notification Large Icon
        if (albumArt == null && mFallbackNotificationBitmap != null) {
            DebugLogger.d(TAG, "Using Notification LargeIcon as fallback artwork");
            albumArt = mFallbackNotificationBitmap;
        }

        // Ensure we have a Title
        if (title == null) {
            boolean isPlayingCheck = false;
            if (playbackState != null) {
                isPlayingCheck = playbackState.getState() == PlaybackState.STATE_PLAYING;
            }
            // NetEase delay fix
            if (isPlayingCheck) {
                DebugLogger.w(TAG, "Playing but Title is null. Retrying in 1000ms...");
                if (mWorkHandler != null) {
                    mWorkHandler.postDelayed(() -> {
                        if (mCurrentController != null)
                            extractMediaInfo(mCurrentController, force);
                    }, 1000);
                }
            }
            return;
        }

        boolean isPlaying = false;
        if (playbackState != null) {
            isPlaying = playbackState.getState() == PlaybackState.STATE_PLAYING;
        }

        // [Scaling] Optimize Bitmap for Parcelable (Max 1MB limit for entire transaction)
        // Scale down to ~200x200 which is enough for HUD
        if (albumArt != null) {
            int byteCount = albumArt.getByteCount();
            if (byteCount > 100000) { // If > 100KB (approx), scale it down safely
                 try {
                     float aspectRatio = (float) albumArt.getWidth() / albumArt.getHeight();
                     int targetW = 200;
                     int targetH = (int) (200 / aspectRatio);
                     
                     // Don't upscale
                     if (targetW < albumArt.getWidth()) {
                         Bitmap scaled = Bitmap.createScaledBitmap(albumArt, targetW, targetH, true);
                         // If we created a new bitmap, use it. The original (metadata) bitmap is managed by system?
                         // Actually MediaMetadata logic caches it, we shouldn't recycle it if we didn't create it.
                         // But createScaledBitmap returns a new one (usually).
                         albumArt = scaled;
                     }
                 } catch (Exception e) {
                     DebugLogger.e(TAG, "Failed to scale artwork", e);
                 }
            }
        }

        // Construct MediaInfo
        MediaInfo currentInfo = new MediaInfo(packageName, title, artist, album, albumArt, isPlaying);

        // Check for Diff
        boolean isMetadataChanged = currentInfo.isMetadataDifferent(mLastMediaInfo);
        boolean isStateChanged = (mLastMediaInfo == null) || (mLastMediaInfo.isPlaying != isPlaying);
        
        // If nothing changed, and not forced, return
        if (!isMetadataChanged && !isStateChanged && !force) {
            return;
        }

        // Update Cache
        mLastMediaInfo = currentInfo;

        // Broadcast
        Intent intent = new Intent(ACTION_MEDIA_INFO_UPDATE);
        intent.putExtra("media_info", currentInfo); // [Core Change] Send Object
        intent.setPackage(getPackageName());
        sendBroadcast(intent);

        DebugLogger.i(TAG, "Broadcast MediaInfo: " + currentInfo.toString() + " (Force: " + force + ")");
    }
}
