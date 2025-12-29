package cn.navitool;

import android.content.Context;
import android.content.ComponentName;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

// ECarX AdaptAPI Imports
import com.ecarx.xui.adaptapi.car.Car;
import com.ecarx.xui.adaptapi.car.ICar;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;
import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;

public class ClusterHudManager {
    private static final String TAG = "ClusterHudManager";

    private static ClusterHudManager instance;
    private Context mContext;
    private ClusterHudPresentation mPresentation;
    private boolean mIsClusterEnabled = false;
    private boolean mIsHudEnabled = false;
    private boolean mIsDashboardMode = false;

    // ECarX Car API
    private ICar mCar;
    private ISensor mSensorManager;
    private ICarFunction mCarFunction;
    private ECarSensorListener mSensorListener;
    private ECarFunctionListener mFunctionListener;

    // Media & Volume
    private android.media.session.MediaSessionManager mMediaSessionManager;
    private android.media.AudioManager mAudioManager;
    private VolumeReceiver mVolumeReceiver;
    private NotificationConnectionReceiver mNotifReceiver;

    private List<HudComponentData> mCachedHudComponents;
    private List<HudComponentData> mCachedClusterComponents;
    private Object mDimMenuInteraction; // IDimMenuInteraction via Reflection

    // AdaptAPI Reflection Constants
    private static final String CLASS_DIM_INTERACTION = "com.ecarx.xui.adaptapi.diminteraction.DimInteraction";
    // Typo in AdaptAPI: TRUN instead of TURN
    private static final int FUNC_LEFT_TURN = 553980160;
    private static final int FUNC_RIGHT_TURN = 553980416;

    private ClusterHudManager(Context context) {
        this.mContext = context.getApplicationContext();

        initAdaptApi();

        // 1. Initialize Media & Volume Listeners IMMEDIATELY on Main Thread (Critical
        // for QQ Music Cover)
        // User reported regressions when this was backgrounded.
        initMediaListener();
        initVolumeListener();
        initNotificationReceiver();

        // 2. Initialize Car Service (Backgroundable, takes ~500ms)
        initCarService();

        registerDisplayListener();

        initNotificationReceiver(); // Listen for Service Connection

        registerDisplayListener();
    }

    // ... (Lines 60-120 unchanged via copy/paste or keeping surrounding context if
    // I could... but here I replace the block mostly)

    public static synchronized ClusterHudManager getInstance(Context context) {
        if (instance == null) {
            instance = new ClusterHudManager(context);
        }
        return instance;
    }

    // --- ECarX Car Service Initialization ---
    private void initCarService() {
        new Thread(() -> {
            try {
                // Create ECarX Car Instance
                mCar = Car.create(mContext);
                if (mCar != null) {
                    mSensorManager = mCar.getSensorManager();
                    if (mSensorManager != null) {
                        registerSensors();
                    } else {
                        DebugLogger.e(TAG, "ECarX SensorManager is null");
                    }

                    mCarFunction = mCar.getICarFunction();
                    if (mCarFunction != null) {
                        registerFunctions();
                    }
                } else {
                    DebugLogger.e(TAG, "Failed to create ECarX Car instance");
                }
            } catch (Throwable t) {
                DebugLogger.e(TAG, "Failed to init ECarX Car Service (Fatal)", t);
            }
        }).start();
    }

    private void registerSensors() {
        if (mSensorManager == null)
            return;

        mSensorListener = new ECarSensorListener();
        try {
            // Register Fuel Level
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_FUEL_LEVEL, ISensor.RATE_NORMAL);
            // Register Ambient Temp (Outside)
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_TEMPERATURE_AMBIENT,
                    ISensor.RATE_NORMAL);
            // Register Indoor Temp (Inside)
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_TEMPERATURE_INDOOR,
                    ISensor.RATE_NORMAL);
            // Register Gear
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_GEAR, ISensor.RATE_NORMAL);
            // Register Range (Endurance) - Try Standard and Fuel variants
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_ENDURANCE_MILEAGE,
                    ISensor.RATE_NORMAL);
            // mSensorManager.registerListener(mSensorListener,
            // ISensor.SENSOR_TYPE_ENDURANCE_MILEAGE_FUEL, ISensor.RATE_NORMAL);

            // Register Speed
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_RPM, ISensor.RATE_UI);
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_CAR_SPEED, ISensor.RATE_UI);

            DebugLogger.i(TAG, "ECarX Sensors Registered");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error registering sensors", e);
        }
    }

    private void registerFunctions() {
        if (mCarFunction == null)
            return;
        mFunctionListener = new ECarFunctionListener();
        try {
            // Register Turn Signals (Separate IDs)
            mCarFunction.registerFunctionValueWatcher(FUNC_LEFT_TURN, mFunctionListener);
            mCarFunction.registerFunctionValueWatcher(FUNC_RIGHT_TURN, mFunctionListener);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error registering functions", e);
        }
    }

    // --- ECarX Sensor Listener ---
    private class ECarSensorListener implements ISensor.ISensorListener {
        @Override
        public void onSensorEventChanged(int sensorType, int eventValue) {
            // Handle Integer Events (Gear, etc.)
            try {
                if (sensorType == ISensor.SENSOR_TYPE_GEAR) {
                    updateComponentText("gear", getGearString(eventValue));
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error handling sensor event changed", e);
            }
        }

        @Override
        public void onSensorValueChanged(int sensorType, float value) {
            // Handle Float Values (Temp, Fuel, Range)
            try {
                if (sensorType == ISensor.SENSOR_TYPE_FUEL_LEVEL) {
                    // MConfig divides by 1000 for Liters
                    float liters = value / 1000f;
                    updateComponentText("fuel", String.format("油量: %.0fL", liters));
                } else if (sensorType == ISensor.SENSOR_TYPE_TEMPERATURE_AMBIENT) {
                    updateComponentText("temp_out", String.format("外: %.1f°C", value));
                } else if (sensorType == ISensor.SENSOR_TYPE_TEMPERATURE_INDOOR) {
                    updateComponentText("temp_in", String.format("内: %.1f°C", value));
                } else if (sensorType == ISensor.SENSOR_TYPE_ENDURANCE_MILEAGE) {
                    updateComponentText("range", String.format("续航: %.0fkm", value));
                } else if (sensorType == ISensor.SENSOR_TYPE_RPM) {
                    updateRpm(value);
                } else if (sensorType == ISensor.SENSOR_TYPE_CAR_SPEED) {
                    updateSpeed(value);
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error handling sensor value changed", e);
            }
        }

        @Override
        public void onSensorSupportChanged(int sensorType, FunctionStatus status) {
            // Not used
        }
    }

    private boolean mLeftTurnOn = false;
    private boolean mRightTurnOn = false;

    // --- ECarX Function Listener ---
    private class ECarFunctionListener implements ICarFunction.IFunctionValueWatcher {
        @Override
        public void onFunctionValueChanged(int funcId, int zone, int value) {
            boolean isOn = (value == 1);
            if (funcId == FUNC_LEFT_TURN) {
                mLeftTurnOn = isOn;
            } else if (funcId == FUNC_RIGHT_TURN) {
                mRightTurnOn = isOn;
            }
            updateTurnSignal();
        }

        @Override
        public void onCustomizeFunctionValueChanged(int i, int i1, float v) {
        }

        @Override
        public void onFunctionChanged(int i) {
        }

        @Override
        public void onSupportedFunctionValueChanged(int i, int[] ints) {
        }

        @Override
        public void onSupportedFunctionStatusChanged(int i, int i1, FunctionStatus functionStatus) {
        }
    }

    private void updateTurnSignal() {
        String signal = "";
        // Use spaces to maintain layout relative to center (assuming gear is in middle)
        if (mLeftTurnOn && mRightTurnOn) {
            signal = "←      →"; // Hazard
        } else if (mLeftTurnOn) {
            signal = "←       "; // Left only
        } else if (mRightTurnOn) {
            signal = "       →"; // Right only
        }
        // If both off, signal is "" (Hidden)
        updateComponentText("turn_signal", signal);
    }

    // --- Volume Listener ---
    private Handler mVolumeHandler = new Handler(Looper.getMainLooper());
    private Runnable mVolumeHideRunnable = () -> {
        if (mPresentation != null) {
            mPresentation.setVolumeVisible(false);
        }
    };

    private void initVolumeListener() {
        try {
            mAudioManager = (android.media.AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
            mVolumeReceiver = new VolumeReceiver();
            android.content.IntentFilter filter = new android.content.IntentFilter();
            filter.addAction("android.media.VOLUME_CHANGED_ACTION");
            // Initial Update
            updateVolume();
            mContext.registerReceiver(mVolumeReceiver, filter, null, new Handler(Looper.getMainLooper()));
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to init Volume Listener", e);
        }
    }

    private void updateVolume() {
        if (mAudioManager != null) {
            int vol = mAudioManager.getStreamVolume(android.media.AudioManager.STREAM_MUSIC);
            updateComponentText("volume", "音量: " + vol);

            // Auto-Hide Logic
            if (mPresentation != null) {
                mPresentation.setVolumeVisible(true);
            }
            mVolumeHandler.removeCallbacks(mVolumeHideRunnable);
            mVolumeHandler.postDelayed(mVolumeHideRunnable, 3000); // Hide after 3 seconds
        }
    }

    private class VolumeReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, android.content.Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                updateVolume();
            }
        }
    }

    private String getGearString(int gearValue) {
        switch (gearValue) {
            case ISensorEvent.GEAR_PARK:
                return "P";
            case ISensorEvent.GEAR_REVERSE:
                return "R";
            case ISensorEvent.GEAR_NEUTRAL:
                return "N";
            case ISensorEvent.GEAR_DRIVE:
                return "D";
            case ISensorEvent.GEAR_FIRST:
                return "D1";
            case ISensorEvent.GEAR_SECOND:
                return "D2";
            case ISensorEvent.GEAR_THIRD:
                return "D3";
            case ISensorEvent.GEAR_FOURTH:
                return "D4";
            case ISensorEvent.GEAR_FIFTH:
                return "D5";
            case ISensorEvent.GEAR_SIXTH:
                return "D6";
            case ISensorEvent.GEAR_SEVENTH:
                return "D7";
            case ISensorEvent.GEAR_EIGHTH:
                return "D8";
            default:
                return "D";
        }
    }

    // --- Listener for Preview UI ---
    public interface OnHudDataChangedListener {
        void onHudDataChanged(String type, String text, android.graphics.Bitmap image);
    }

    private OnHudDataChangedListener mListener;

    public void setListener(OnHudDataChangedListener listener) {
        mListener = listener;
        if (mListener != null && mCachedHudComponents != null) {
            // Immediately sync current state to the new listener (fixes Resume Sync issue)
            synchronized (this) {
                for (HudComponentData data : mCachedHudComponents) {
                    new Handler(Looper.getMainLooper()).post(() -> {
                        if (mListener != null) {
                            mListener.onHudDataChanged(data.type, data.text, data.image);
                        }
                    });
                }
            }
        }
    }

    // --- Core Update Logic ---
    public void updateComponentText(String type, String newText) {
        updateComponent(type, newText, null);
    }

    public void updateComponentImage(String type, android.graphics.Bitmap image) {
        updateComponent(type, null, image);
    }

    // Pending Media State (Wait for Cache Load)
    private String mPendingSongText = null;
    private android.graphics.Bitmap mPendingCoverArt = null;

    private void updateComponent(String type, String newText, android.graphics.Bitmap newImage) {
        if (mCachedHudComponents == null) {
            // Logic Fix: Store pending updates if cache isn't ready (Startup Optimization
            // Race Condition)
            synchronized (this) {
                if ("song".equals(type) || "test_media".equals(type)) {
                    mPendingSongText = newText;
                    DebugLogger.d(TAG, "Cache not ready, stored pending text: " + newText);
                } else if ("media_cover".equals(type) || "test_media_cover".equals(type)) {
                    if (newImage != null) {
                        mPendingCoverArt = newImage;
                        DebugLogger.d(TAG, "Cache not ready, stored pending cover art");
                    }
                }
            }
            return;
        }

        boolean changed = false;

        synchronized (this) {
            if (mCachedHudComponents == null && mCachedClusterComponents == null)
                return;

            if (mCachedHudComponents != null) {
                for (HudComponentData data : mCachedHudComponents) {
                    if (type.equals(data.type)) {
                        if (newText != null && !newText.equals(data.text)) {
                            data.text = newText;
                            changed = true;
                        }
                        if (newImage != null) {
                            data.image = newImage;
                            changed = true;
                        }
                    }
                }
            }

            if (mCachedClusterComponents != null) {
                for (HudComponentData data : mCachedClusterComponents) {
                    if (type.equals(data.type)) {
                        if (newText != null && !newText.equals(data.text)) {
                            data.text = newText;
                            changed = true;
                        }
                        if (newImage != null) {
                            data.image = newImage;
                            changed = true;
                        }
                    }
                }
            }
        }

        if (changed) {
            new Handler(Looper.getMainLooper()).post(() -> {
                // Efficient Update: directly update view property instead of full rebuild
                if (mPresentation != null) {
                    mPresentation.updateComponent(type, newText, newImage);
                } else {
                    // Fallback if presentation isn't ready
                }

                if (mListener != null) {
                    mListener.onHudDataChanged(type, newText, newImage);
                }
            });
        }
    }

    // --- Media (Broadcast & Session) ---
    private void initMediaListener() {
        // 1. Register Standard Broadcast Receiver
        try {
            MusicBroadcastReceiver receiver = new MusicBroadcastReceiver();
            android.content.IntentFilter filter = new android.content.IntentFilter();
            filter.addAction("com.android.music.metachanged");
            filter.addAction("com.android.music.playstatechanged");
            filter.addAction("com.android.music.playbackcomplete");
            filter.addAction("com.android.music.queuechanged");
            // Generic Players (Chinese Market)
            filter.addAction("com.tencent.qqmusic.intent.action.MUSIC_CHANGED");
            filter.addAction("com.netease.cloudmusic.metachanged");
            filter.addAction("com.kugou.android.music.metachanged");
            filter.addAction("com.kugou.android.music.playstatechanged");
            filter.addAction("cn.kuwo.player.metachanged");
            filter.addAction("cn.kuwo.player.playstatechanged");
            filter.addAction("cn.kuwo.player.playstatechanged");
            // Add other common players if needed, e.g. Kugou, QQMusic often broadcast on
            // standard actions or their own
            filter.addAction(cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE); // Listen to
                                                                                                      // Service
                                                                                                      // directly
                                                                                                      // background
            mContext.registerReceiver(receiver, filter, null, new Handler(Looper.getMainLooper()));
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to init Media Broadcast Receiver", e);
        }

        // 2. Keep MediaSession as backup/supplement (Modern Android)
        initMediaSession();
    }

    public void reinitMediaListener() {
        if (mMediaSessionManager == null) {
            DebugLogger.d(TAG, "Re-initializing Media Session Listener...");
            initMediaSession();
        }
    }

    private void initMediaSession() {
        try {
            if (mMediaSessionManager == null) {
                mMediaSessionManager = (android.media.session.MediaSessionManager) mContext
                        .getSystemService(Context.MEDIA_SESSION_SERVICE);
            }
            if (mMediaSessionManager != null) {
                // Use ComponentName to be explicit, though null works IF we have permission.
                // But permission is key.
                ComponentName notifComponent = new ComponentName(mContext, NotificationCollectorService.class);

                // 1. Register Listener with Main Handler (Required since we are on bg thread)
                mMediaSessionManager.addOnActiveSessionsChangedListener(controllers -> {
                    DebugLogger.d(TAG,
                            "ActiveSessionsChanged Callback: " + (controllers != null ? controllers.size() : "null"));
                    updateMediaControllers(controllers);
                }, notifComponent, new Handler(Looper.getMainLooper()));
                DebugLogger.i(TAG, "MediaSession Listener Registered Successfully");

                // 2. Start Polling (To ensure we catch sessions even if callback misses or
                // service connects late)
                startMediaPolling();

            }
        } catch (SecurityException se) {
            DebugLogger.e(TAG, "Media permission missing! Please grant Notification Access.", se);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to init MediaSession Listener", e);
        }
    }

    private void startMediaPolling() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if (mMediaSessionManager != null) {
                        ComponentName notifComponent = new ComponentName(mContext, NotificationCollectorService.class);
                        List<android.media.session.MediaController> controllers = mMediaSessionManager
                                .getActiveSessions(notifComponent);
                        if (controllers != null && !controllers.isEmpty()) {
                            // Only update if we found something, to avoid clearing valid data if glitch
                            updateMediaControllers(controllers);
                        }
                    }
                } catch (SecurityException e) {
                    // Permission not granted yet
                } catch (Exception e) {
                    // Ignore
                }
                // Poll every 5 seconds
                new Handler(Looper.getMainLooper()).postDelayed(this, 5000);
            }
        }, 1000);
    }

    private void updateMediaControllers(List<android.media.session.MediaController> controllers) {
        if (controllers != null && !controllers.isEmpty()) {
            // Find playing controller first? Or just take first.
            android.media.session.MediaController controller = controllers.get(0);
            updateMediaInfoFromController(controller);
            // Register callback on this specific controller
            controller.registerCallback(new android.media.session.MediaController.Callback() {
                @Override
                public void onMetadataChanged(android.media.MediaMetadata metadata) {
                    updateMediaInfoFromController(controller);
                }

                @Override
                public void onPlaybackStateChanged(android.media.session.PlaybackState state) {
                    updateMediaInfoFromController(controller); // Update on pause/play too
                }
            });
        }
    }

    // Broadcast Receiver
    private class MusicBroadcastReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, android.content.Intent intent) {
            String action = intent.getAction();
            DebugLogger.d(TAG, "MusicBroadcast Received Action: " + action); // Debug Log

            if (action == null)
                return;

            if (cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE.equals(action)) {
                // Handle Direct Service Broadcast (Works in Background for QQ Music)
                String title = intent.getStringExtra("title");
                String artist = intent.getStringExtra("artist");
                boolean isPlaying = intent.getBooleanExtra("is_playing", false);

                String display = title;
                if (artist != null && !artist.isEmpty()) {
                    display = title + "\n" + artist;
                }
                updateComponentText("song", display);
                updateComponentText("test_media", display);

                // Update Playing State
                updateMediaPlayingState(isPlaying);

                // Update Cover (Byte Array)
                boolean hasArtwork = intent.getBooleanExtra("has_artwork", true); // Default true to be safe
                if (!hasArtwork) {
                    // Explicitly Clear if listener says no artwork
                    updateComponentImage("media_cover", null);
                    updateComponentImage("test_media_cover", null);
                } else {
                    byte[] artwork = intent.getByteArrayExtra("artwork");
                    if (artwork != null) {
                        android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeByteArray(artwork, 0,
                                artwork.length);
                        if (bmp != null) {
                            updateComponentImage("media_cover", bmp);
                            updateComponentImage("test_media_cover", bmp);
                        }
                    }
                }
            } else {
                // Reject generic broadcasts if text/track is missing to avoid overwriting valid
                // data with garbage
                // But generally, accept them.

                // Debug: Log all keys to find correct ones for QQ Music/NetEase
                android.os.Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String key : extras.keySet()) {
                        // DebugLogger.v(TAG, "Extra: " + key + " = " + extras.get(key));
                    }
                }

                String cmd = intent.getStringExtra("command");
                String artist = intent.getStringExtra("artist");
                String track = intent.getStringExtra("track");
                String lyric = intent.getStringExtra("lyric");

                // Fallback keys for some players (e.g. old Android music)
                if (track == null)
                    track = intent.getStringExtra("songName");
                if (track == null)
                    track = intent.getStringExtra("song");

                // QQ Music / Kugou specific checks (sometimes they use different keys depending
                // on version)
                // Assuming standard keys but monitoring logs if they fail.

                if (lyric == null)
                    lyric = "暂无歌词"; // Default

                DebugLogger.d(TAG, "Music Info: " + track + " - " + artist);

                // Update Text: Line 1 Lyric, Line 2 Title - Artist
                String display = lyric + "\n" + (track != null ? track : "") + " - " + (artist != null ? artist : "");
                updateComponentText("song", display);

                // Determine Playing State from Broadcast
                boolean isPlaying = intent.getBooleanExtra("playing", true); // Default to true if receiving metadata
                if ("com.android.music.playbackcomplete".equals(action)) {
                    isPlaying = false;
                }
                updateMediaPlayingState(isPlaying);

                // Update Cover from Intent Extras (QQ Music often sends URI here)
                String artUriStr = intent.getStringExtra("album_art_uri"); // Standard/QQ
                if (artUriStr == null)
                    artUriStr = intent.getStringExtra("album_uri");
                if (artUriStr == null)
                    artUriStr = intent.getStringExtra("artwork_uri");

                if (artUriStr != null) {
                    try {
                        android.net.Uri uri = android.net.Uri.parse(artUriStr);
                        java.io.InputStream is = mContext.getContentResolver().openInputStream(uri);
                        android.graphics.Bitmap broadcastArt = android.graphics.BitmapFactory.decodeStream(is);
                        if (is != null)
                            is.close();
                        if (broadcastArt != null) {
                            updateComponentImage("media_cover", broadcastArt);
                            updateComponentImage("test_media_cover", broadcastArt);
                        }
                    } catch (Exception e) {
                        DebugLogger.w(TAG, "Failed to load Art from Broadcast URI: " + artUriStr);
                    }
                }
            }
        }
    }

    private void updateMediaInfoFromController(android.media.session.MediaController controller) {
        if (controller == null || controller.getMetadata() == null) {
            DebugLogger.d(TAG, "updateMediaInfo: Controller or Metadata is null");
            return;
        }

        android.media.MediaMetadata meta = controller.getMetadata();
        String title = meta.getString(android.media.MediaMetadata.METADATA_KEY_TITLE);
        String artist = meta.getString(android.media.MediaMetadata.METADATA_KEY_ARTIST);
        android.graphics.Bitmap art = meta.getBitmap(android.media.MediaMetadata.METADATA_KEY_ALBUM_ART);
        if (art == null) {
            // Disabled fallback to DISPLAY_ICON. QQ Music puts app icon here which
            // overwrites
            // valid Notification Art.
            // art = meta.getBitmap(android.media.MediaMetadata.METADATA_KEY_DISPLAY_ICON);
        }

        // 3. Fallback: URI (Android 9/Pie often relies on this to avoid Binder size
        // limits)
        if (art == null) {
            String artUriStr = meta.getString(android.media.MediaMetadata.METADATA_KEY_ALBUM_ART_URI);
            if (artUriStr == null) {
                artUriStr = meta.getString(android.media.MediaMetadata.METADATA_KEY_DISPLAY_ICON_URI);
            }
            if (artUriStr != null) {
                try {
                    android.net.Uri uri = android.net.Uri.parse(artUriStr);
                    // Use ContentResolver to open stream
                    java.io.InputStream is = mContext.getContentResolver().openInputStream(uri);
                    art = android.graphics.BitmapFactory.decodeStream(is);
                    if (is != null)
                        is.close();
                    DebugLogger.d(TAG, "Loaded Art from URI: " + artUriStr);
                } catch (Exception e) {
                    DebugLogger.w(TAG, "Failed to load Art from URI: " + artUriStr + " (" + e.getMessage() + ")");
                }
            }
        }

        DebugLogger.d(TAG, "updateMediaInfo: Title=" + (title != null ? title : "null") + ", Artist="
                + (artist != null ? artist : "null") + ", Art=" + (art != null ? "Found" : "null"));

        // Try to find lyrics via hidden keys
        String lyric = "暂无歌词";
        // 1. Try generic keys found in some apps
        String[] potentialLyricKeys = {
                "android.media.metadata.LYRIC", "lyric",
                "kugou.lyric", "qqmusic.lyric"
        };
        for (String key : potentialLyricKeys) {
            String val = meta.getString(key);
            if (val != null && !val.isEmpty()) {
                lyric = val;
                DebugLogger.d(TAG, "Found Lyric via Key: " + key);
                break;
            }
        }

        // 2. Dump keys to find candidates if still missing (Only dump if title is valid
        // to avoid spam)
        if (("暂无歌词".equals(lyric) || art == null) && title != null) {
            java.util.Set<String> keys = meta.keySet();
            StringBuilder sb = new StringBuilder("MetaDump: ");
            for (String k : keys) {
                sb.append(k).append(",");
                // String v = meta.getString(k); // Can throw if types mismatch
            }
            DebugLogger.d(TAG, sb.toString());
        }

        if (title == null)
            title = "未知歌曲";
        if (artist == null)
            artist = "未知歌手";

        // User Preference: Line 1 Title, Line 2 Artist
        String display = title + "\n" + artist;
        updateComponentText("song", display);
        updateComponentText("test_media", display); // Also update test component

        if (art != null) {
            updateComponentImage("media_cover", art);
            updateComponentImage("test_media_cover", art); // Also update test cover
        } else {
            // Logic Fix: If MediaSession art is null (common in QQ Music), DO NOT overwrite
            // potential artwork from NotificationListener (pushed from MainActivity).
            // Only clear artwork if the song has ACTUALLY changed.
            // But we don't track previous song title here easily without cache lookup.
            // Simpler check: If art is null, just DON'T update image component at all.
            // Let the old image persist until a new valid image comes OR the text update
            // implies a change.
            // Wait, if it's a new song with NO art, we WANT to clear the old art.
            // But we can't distinguish "New Song No Art" vs "Old Song Art from
            // Notification".
            // Given QQ Music notification works well, let's just rely on that for art.
            // If MediaSession has art, great. If not, do nothing and hope
            // NotificationListener fills it.
        }

        // Determine Playing State
        boolean isPlaying = false;
        if (controller.getPlaybackState() != null) {
            isPlaying = (controller.getPlaybackState().getState() == android.media.session.PlaybackState.STATE_PLAYING);
        }
        updateMediaPlayingState(isPlaying);

        // Save State (Removed Logic called above, method body is empty now)
        saveMediaState(display, art);
    }

    // --- AdaptAPI Init ---
    private void initAdaptApi() {
        new Thread(() -> {
            try {
                // DimInteraction.create(context)
                Class<?> dimInteractionClass = Class.forName(CLASS_DIM_INTERACTION);
                Method createMethod = dimInteractionClass.getMethod("create", Context.class);
                Object dimInteraction = createMethod.invoke(null, mContext);

                // dimInteraction.getDimMenuInteraction()
                Method getMenuInteractionMethod = dimInteractionClass.getMethod("getDimMenuInteraction");
                mDimMenuInteraction = getMenuInteractionMethod.invoke(dimInteraction);
                DebugLogger.i(TAG, "AdaptAPI DimMenuInteraction initialized successfully: " + mDimMenuInteraction);

                // If Cluster was enabled waiting for this, triggered by logic?
                // unlikely, setClusterEnabled is manual.
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to initialize AdaptAPI DimMenuInteraction", e);
            }
        }).start();
    }

    private void registerDisplayListener() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        dm.registerDisplayListener(new DisplayManager.DisplayListener() {
            @Override
            public void onDisplayAdded(int displayId) {
                DebugLogger.i(TAG, "Display added: " + displayId);
                checkAndShowPresentation();
            }

            @Override
            public void onDisplayRemoved(int displayId) {
                DebugLogger.i(TAG, "Display removed: " + displayId);
            }

            @Override
            public void onDisplayChanged(int displayId) {
            }
        }, new Handler(Looper.getMainLooper()));
    }

    private void checkAndShowPresentation() {
        if (mIsClusterEnabled || mIsHudEnabled) {
            if (mPresentation == null) {
                showPresentation();
            }
        }
    }

    public void setClusterEnabled(boolean enabled) {
        if (mIsClusterEnabled == enabled)
            return;
        mIsClusterEnabled = enabled;
        DebugLogger.d(TAG, "setClusterEnabled: " + enabled);

        updatePresentation();

        if (mDimMenuInteraction != null) {
            try {
                int mode = enabled ? 3 : 1;
                Method switchNaviModeMethod = mDimMenuInteraction.getClass().getMethod("switchNaviMode", int.class);
                switchNaviModeMethod.invoke(mDimMenuInteraction, mode);
                DebugLogger.i(TAG, "Called switchNaviMode(" + mode + ")");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to call switchNaviMode", e);
            }
        } else {
            DebugLogger.w(TAG, "DimMenuInteraction is null, skipping switchNaviMode");
        }
    }

    public void setHudEnabled(boolean enabled) {
        if (mIsHudEnabled == enabled)
            return;
        mIsHudEnabled = enabled;
        DebugLogger.d(TAG, "setHudEnabled: " + enabled);
        updatePresentation();
    }

    public void setDebugMode(boolean enabled) {
        if (mPresentation != null) {
            mPresentation.updateDebugMode(enabled);
        }
    }

    private void updatePresentation() {
        if (mIsClusterEnabled || mIsHudEnabled) {
            if (mPresentation == null) {
                showPresentation();
            } else {
                mPresentation.setClusterVisible(mIsClusterEnabled);
                mPresentation.setHudVisible(mIsHudEnabled);
            }
        } else {
            dismissPresentation();
        }
    }

    private void showPresentation() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        Display[] displays = dm.getDisplays();
        DebugLogger.d(TAG, "Found " + displays.length + " displays");

        Display targetDisplay = null;
        for (Display d : displays) {
            if (d.getDisplayId() == 2) {
                targetDisplay = d;
                break;
            }
        }

        if (targetDisplay != null) {
            mPresentation = new ClusterHudPresentation(mContext, targetDisplay);

            if (android.os.Build.VERSION.SDK_INT >= 31) {
                DebugLogger.i(TAG, "Android 12+: Using default Presentation Window Type (2037)");
            } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                mPresentation.getWindow().setType(android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            } else {
                mPresentation.getWindow().setType(android.view.WindowManager.LayoutParams.TYPE_PHONE);
            }

            try {
                mPresentation.setOnShowListener(dialog -> {
                    // Logic Fix: Apply Persistence Mode (Dashboard vs List)
                    if (mIsDashboardMode) {
                        mPresentation.enableClusterDashboard();
                        DebugLogger.d(TAG, "Restored Dashboard Mode on show");
                    } else if (mCachedClusterComponents != null) {
                        mPresentation.syncClusterLayout(mCachedClusterComponents);
                        DebugLogger.d(TAG, "Applied cached Cluster components on show");
                    }

                    if (mCachedHudComponents != null) {
                        mPresentation.syncHudLayout(mCachedHudComponents);
                        DebugLogger.d(TAG, "Applied cached HUD components on show");
                    }
                });

                mPresentation.show();
                mPresentation.setClusterVisible(mIsClusterEnabled);
                mPresentation.setHudVisible(mIsHudEnabled);
                mPresentation.setMediaPlaying(mIsMediaPlaying); // Sync initial state
                DebugLogger.i(TAG, "ClusterHudPresentation SHOWN on Display 2");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to show presentation", e);
                mPresentation = null;
            }
        } else {
            DebugLogger.w(TAG, "Display ID 2 not found yet, waiting for it...");
        }
    }

    private void dismissPresentation() {
        if (mPresentation != null) {
            try {
                mPresentation.dismiss();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to dismiss presentation", e);
            } finally {
                mPresentation = null;
                DebugLogger.i(TAG, "ClusterHudPresentation DISMISSED");
            }
        }
    }

    public void syncHudLayout(List<HudComponentData> components) {
        if (components == null)
            return;
        synchronized (this) {
            mCachedHudComponents = new ArrayList<>(components);
            applyMediaPersistence(); // Apply saved media state over defaults

            // Logic Fix: Apply Pending Media (from Startup Race Condition)
            if (mPendingSongText != null) {
                DebugLogger.d(TAG, "Applying pending song text from cache: " + mPendingSongText);
                updateComponentText("song", mPendingSongText);
                updateComponentText("test_media", mPendingSongText);
                mPendingSongText = null; // Clear
            }
            if (mPendingCoverArt != null) {
                DebugLogger.d(TAG, "Applying pending cover art from cache");
                updateComponentImage("media_cover", mPendingCoverArt);
                updateComponentImage("test_media_cover", mPendingCoverArt);
                mPendingCoverArt = null; // Clear
            }
        }
        if (mPresentation != null) {
            mPresentation.syncHudLayout(mCachedHudComponents);
            // Force update turn_signal with current real sensor state (hiding placeholder)
            updateTurnSignal();
        }

        // Notify Listener (MainActivity Preview) of the full sync (Logic Fix for
        // Preview Persistence)
        if (mListener != null) {
            synchronized (this) {
                for (HudComponentData data : mCachedHudComponents) {
                    final HudComponentData finalData = data;
                    new Handler(Looper.getMainLooper()).post(() -> {
                        if (mListener != null) {
                            mListener.onHudDataChanged(finalData.type, finalData.text, finalData.image);
                        }
                    });
                }
            }
        }
    }

    public void syncClusterLayout(List<HudComponentData> components) {
        if (components == null)
            return;
        synchronized (this) {
            mIsDashboardMode = false; // Switch to List Mode
            mCachedClusterComponents = new ArrayList<>(components);
        }
        if (mPresentation != null) {
            mPresentation.syncClusterLayout(mCachedClusterComponents);
            updateTurnSignal(); // Force update
        }
    }

    public void syncTestMedia() {
        String title = "测试歌曲 Title";
        String artist = "测试歌手 Artist";
        android.graphics.Bitmap art = android.graphics.Bitmap.createBitmap(100, 100,
                android.graphics.Bitmap.Config.ARGB_8888);
        art.eraseColor(android.graphics.Color.RED);

        String display = "测试歌词 Lyric\n" + title + " - " + artist;
        updateComponentText("song", display);
        updateComponentImage("media_cover", art);
        updateMediaPlayingState(true); // Force show for testing
    }

    public void clearHudComponents() {
        if (mPresentation != null) {
            mPresentation.clearHudComponents();
        }
        if (mPresentation != null) {
            mPresentation.clearHudComponents();
        }
    }

    // --- Cluster Dashboard Logic ---
    public void enableClusterDashboard() {
        mIsDashboardMode = true; // Enable Dashboard Mode persistence
        if (mPresentation != null) {
            mPresentation.enableClusterDashboard();
        } else {
            // Need to handle if presentation not ready?
            // For now, assume it's synced when presentation shows if we store mode state.
            // But skipping complexity for this step.
        }
    }

    public void updateSpeed(float speed) {
        if (mPresentation != null) {
            mPresentation.updateSpeed(speed);
        }
    }

    public void updateRpm(float rpm) {
        if (mPresentation != null) {
            mPresentation.updateRpm(rpm);
        }
    }

    // --- Notification Service Connection Listener ---
    private void initNotificationReceiver() {
        try {
            mNotifReceiver = new NotificationConnectionReceiver();
            android.content.IntentFilter filter = new android.content.IntentFilter(
                    "cn.navitool.NOTIFICATION_LISTENER_CONNECTED");
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                mContext.registerReceiver(mNotifReceiver, filter, Context.RECEIVER_EXPORTED);
            } else {
                mContext.registerReceiver(mNotifReceiver, filter);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register Notification Receiver", e);
        }
    }

    private class NotificationConnectionReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, android.content.Intent intent) {
            if ("cn.navitool.NOTIFICATION_LISTENER_CONNECTED".equals(intent.getAction())) {
                DebugLogger.i(TAG, "Received Notification Service Connected Broadcast! Retrying Media Init...");
                reinitMediaListener();
            }
        }
    }

    // --- Media Persistence ---
    // --- Media Visibility ---
    private boolean mIsMediaPlaying = false;

    private void updateMediaPlayingState(boolean isPlaying) {
        if (mIsMediaPlaying != isPlaying) {
            mIsMediaPlaying = isPlaying;
            DebugLogger.d(TAG, "Media Playing State Changed: " + isPlaying);
            if (mPresentation != null) {
                mPresentation.setMediaPlaying(mIsMediaPlaying);
            }
        }
    }

    private void applyMediaPersistence() {
        // Removed per user request: No longer restore saved media state.
        // We rely on real-time data or defaults.
    }

    private String mLastSavedText = null;

    private void saveMediaState(String text, android.graphics.Bitmap image) {
        // Removed per user request: No longer save media state to disk.
    }

    public static class HudComponentData {
        public String type; // "text", "time", "song", "fuel", "temp_out", "temp_in", "range", "gear",
                            // "media_cover", "turn_signal", "volume"
        public String text;
        public android.graphics.Bitmap image;
        public float x;
        public float y;
        public int color;

        public HudComponentData(String type, String text, float x, float y, int color) {
            this.type = type;
            this.text = text;
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public HudComponentData(String type, String text, float x, float y) {
            this(type, text, x, y, android.graphics.Color.WHITE);
        }
    }
}
