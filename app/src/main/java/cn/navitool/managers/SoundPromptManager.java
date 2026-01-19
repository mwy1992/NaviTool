package cn.navitool.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import cn.navitool.DebugLogger;

public class SoundPromptManager {
    private static final String TAG = "SoundPromptManager";
    private static volatile SoundPromptManager instance;
    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private boolean mIsDirectPlaybackMode = false; // Default: Mix (false)

    // [FIX] Singleton focus listener to prevent leak when sounds are rapidly
    // triggered
    private android.media.AudioManager.OnAudioFocusChangeListener mFocusListener;
    private android.media.AudioFocusRequest mFocusRequest; // For Android O+

    public void setPlaybackMode(boolean isDirect) {
        mIsDirectPlaybackMode = isDirect;
        DebugLogger.d(TAG, "Playback Mode Changed: " + (isDirect ? "DIRECT (Pause Music)" : "MIX (Duck Music)"));
    }

    // Gear Constants (Matched to KeepAliveAccessibilityService)
    public static final int GEAR_PARK = 2097712;
    public static final int GEAR_REVERSE = 2097728;
    public static final int GEAR_NEUTRAL = 2097680;
    public static final int GEAR_DRIVE = 2097696;

    // Transmission Backup Values
    public static final int TRSM_GEAR_PARK = 15;
    public static final int TRSM_GEAR_DRIVE = 13;
    public static final int TRSM_GEAR_NEUT = 14;
    public static final int TRSM_GEAR_RVS = 11;

    // Door Constants
    public static final int ZONE_DOOR_FL = 1; // Front Left (Driver)
    public static final int ZONE_DOOR_FR = 4; // Front Right (Passenger)
    public static final int ZONE_DOOR_RL = 16; // Rear Left
    public static final int ZONE_DOOR_RR = 64; // Rear Right
    public static final int ZONE_DOOR_HOOD = 268435456; // Hood
    public static final int ZONE_DOOR_REAR = 536870912; // Trunk

    private SoundPromptManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static SoundPromptManager getInstance(Context context) {
        if (instance == null) {
            synchronized (SoundPromptManager.class) {
                if (instance == null) {
                    instance = new SoundPromptManager(context);
                }
            }
        }
        return instance;
    }

    public void init() {
        DebugLogger.i(TAG, "SoundPromptManager Initialized");
        MemoryMonitor.setComponentStatus("SoundManager", "Initialized");
    }

    public void destroy() {
        if (mMediaPlayer != null) {
            try {
                mMediaPlayer.release();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error releasing MediaPlayer", e);
            }
            mMediaPlayer = null;
        }
        DebugLogger.i(TAG, "SoundPromptManager Destroyed");
    }

    public void playGearSound(int gear) {
        String key = null;
        if (gear == GEAR_DRIVE || gear == TRSM_GEAR_DRIVE) {
            key = "sound_gear_d";
        } else if (gear == GEAR_REVERSE || gear == TRSM_GEAR_RVS) {
            key = "sound_gear_r";
        } else if (gear == GEAR_NEUTRAL || gear == TRSM_GEAR_NEUT) {
            key = "sound_gear_n";
        } else if (gear == GEAR_PARK || gear == TRSM_GEAR_PARK) {
            key = "sound_gear_p";
        }

        if (key != null) {
            playSound(key);
        }
    }

    public void playStartSound() {
        playSound("sound_start");
    }

    public void checkDoorSound(int oldStatus, int newStatus) {
        // Legacy method, logic moved to KeepAliveAccessibilityService
    }

    public void playDoorDriverSound() {
        playSound("sound_door_driver");
    }

    public void playDoorPassengerSound() {
        playSound("sound_door_passenger");
    }

    public void playDoorPassengerEmptySound() {
        playSound("sound_door_passenger_empty");
    }

    public void playDoorRearLeftSound() {
        playSound("sound_door_rear_left");
    }

    public void playDoorRearRightSound() {
        playSound("sound_door_rear_right");
    }

    public void playDoorHoodSound() {
        playSound("sound_door_hood");
    }

    public void playDoorTrunkSound() {
        playSound("sound_door_trunk");
    }

    public void playCustomSound(String absolutePath) {
        if (absolutePath == null || absolutePath.isEmpty())
            return;

        playFile(absolutePath);
    }

    private void playSound(String prefKeyPrefix) {
        SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean enabled = prefs.getBoolean(prefKeyPrefix + "_enabled", false);
        if (!enabled) {
            DebugLogger.d(TAG, "Sound skipped (Disabled): " + prefKeyPrefix);
            return;
        }

        String filePath = prefs.getString(prefKeyPrefix + "_file", null);
        if (filePath == null || filePath.isEmpty()) {
            DebugLogger.d(TAG, "Sound skipped (Path Empty): " + prefKeyPrefix);
            return;
        }

        // Check if absolute path or just filename
        java.io.File file = new java.io.File(filePath);
        if (!file.exists()) {
            // Try standard directory
            java.io.File stdDir = new java.io.File(android.os.Environment.getExternalStorageDirectory(),
                    "NaviTool/Sound");
            file = new java.io.File(stdDir, filePath);
        }

        if (file.exists()) {
            playFile(file.getAbsolutePath());
        } else {
            DebugLogger.e(TAG, "Sound file not found: " + filePath + " (Orig: " + filePath + ")");
        }
    }

    private int mAudioStreamType = android.media.AudioManager.STREAM_NOTIFICATION; // Default to old behavior
                                                                                   // (Navi-like)
    // Actually, traditionally we used USAGE_NAVIGATION. Let's make the "Navigation"
    // option default.

    // [ECARX] ECARX 车机系统定义的音频通道
    // 这些通道对应系统设置中可独立控制音量的 4 个通道中的 2 个
    public static final int ECARX_CHANNEL_ENT = 0; // 娱乐/媒体通道 (Entertainment)
    public static final int ECARX_CHANNEL_NAVI = 1; // 导航通道 (Navigation)
    public static final int ECARX_CHANNEL_BEEP = 2; // 提示音通道 (Beep)

    private int mEcarxChannel = ECARX_CHANNEL_NAVI; // 默认使用导航通道

    /**
     * 设置 ECARX 音频通道
     * 
     * @param channel ECARX_CHANNEL_ENT (0) = 媒体通道, ECARX_CHANNEL_NAVI (1) = 导航通道
     */
    public void setEcarxChannel(int channel) {
        mEcarxChannel = channel;
        // 同时更新 AudioStreamType 以保持兼容性
        if (channel == ECARX_CHANNEL_ENT) {
            mAudioStreamType = android.media.AudioManager.STREAM_MUSIC;
        } else {
            mAudioStreamType = android.media.AudioManager.STREAM_NOTIFICATION;
        }
        DebugLogger.d(TAG, "ECARX Audio Channel Changed: " +
                (channel == ECARX_CHANNEL_ENT ? "ENT (媒体=0)"
                        : channel == ECARX_CHANNEL_NAVI ? "NAVI (导航=1)" : "BEEP (提示=2)"));
    }

    public void setAudioStreamType(int streamType) {
        mAudioStreamType = streamType;
        DebugLogger.d(TAG, "Audio Stream Type Changed: " +
                (streamType == android.media.AudioManager.STREAM_MUSIC ? "MUSIC (Media)" : "NOTIFICATION (Navi)"));
    }

    // [FIX] Proactive abandon to prevent focus leak from reset() canceling
    // OnCompletionListener
    private void abandonFocus() {
        android.media.AudioManager am = (android.media.AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        if (am == null)
            return;
        DebugLogger.d(TAG, "Proactively abandoning previous audio focus...");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O && mFocusRequest != null) {
            am.abandonAudioFocusRequest(mFocusRequest);
            mFocusRequest = null;
        } else if (mFocusListener != null) {
            am.abandonAudioFocus(mFocusListener);
        }
    }

    private void playFile(String filePath) {
        try {
            // [FIX] Initialize singleton listener if needed
            if (mFocusListener == null) {
                mFocusListener = focusChange -> {
                    DebugLogger.d(TAG, "Audio Focus Changed: " + focusChange);
                };
            }

            android.media.AudioManager am = (android.media.AudioManager) mContext
                    .getSystemService(Context.AUDIO_SERVICE);

            // [FIX] Only request focus in Direct Mode. 
            // In Mix Mode, we purposefully skip it to avoid interrupting music (pause bug).
            if (mIsDirectPlaybackMode && am != null) {
                // [FIX] Proactively abandon previous focus before requesting new one
                abandonFocus();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                    int focusType;
                    if (mIsDirectPlaybackMode) {
                        // Direct Mode: Use TRANSIENT (not EXCLUSIVE) to allow music to auto-resume
                        // EXCLUSIVE causes some players (QQ Music) to not auto-resume
                        focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
                    } else {
                        // Mix Mode: Duck
                        focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
                    }

                    android.media.AudioAttributes.Builder attrBuilder = new android.media.AudioAttributes.Builder();

                    if (mAudioStreamType == android.media.AudioManager.STREAM_MUSIC) {
                        // Media Channel
                        attrBuilder.setUsage(android.media.AudioAttributes.USAGE_MEDIA);
                        attrBuilder.setContentType(android.media.AudioAttributes.CONTENT_TYPE_MUSIC);
                    } else {
                        // Navigation Channel (Default)
                        attrBuilder.setUsage(android.media.AudioAttributes.USAGE_ASSISTANCE_NAVIGATION_GUIDANCE);
                        attrBuilder.setContentType(android.media.AudioAttributes.CONTENT_TYPE_SPEECH);
                    }

                    android.media.AudioAttributes playbackAttributes = attrBuilder.build();

                    mFocusRequest = new android.media.AudioFocusRequest.Builder(focusType)
                            .setAudioAttributes(playbackAttributes)
                            .setAcceptsDelayedFocusGain(false)
                            .setOnAudioFocusChangeListener(mFocusListener)
                            .build();
                    int focusResult = am.requestAudioFocus(mFocusRequest);
                    DebugLogger.d(TAG, "Audio Focus Requested (" + (mIsDirectPlaybackMode ? "DIRECT" : "MIX")
                            + ", ECARX Channel=" + mEcarxChannel
                            + " [" + (mEcarxChannel == ECARX_CHANNEL_ENT ? "ENT/媒体" : "NAVI/导航") + "]"
                            + "), result=" + focusResult);
                } else {
                    int focusType;
                    if (mIsDirectPlaybackMode) {
                        // Direct Mode: Use TRANSIENT to allow music to auto-resume
                        focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
                    } else {
                        focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
                    }

                    int stream = mAudioStreamType;
                    // Use the selected stream for legacy request

                    int focusResult = am.requestAudioFocus(mFocusListener, stream, focusType);
                    DebugLogger.d(TAG, "Audio Focus Requested (Legacy " + (mIsDirectPlaybackMode ? "DIRECT" : "MIX")
                            + "), result=" + focusResult);
                }
            }

            if (mMediaPlayer == null) {
                mMediaPlayer = new MediaPlayer();
            } else {
                mMediaPlayer.reset();
            }

            // Set attributes for MediaPlayer as well
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                android.media.AudioAttributes.Builder attrBuilder = new android.media.AudioAttributes.Builder();
                if (mAudioStreamType == android.media.AudioManager.STREAM_MUSIC) {
                    attrBuilder.setUsage(android.media.AudioAttributes.USAGE_MEDIA);
                    attrBuilder.setContentType(android.media.AudioAttributes.CONTENT_TYPE_MUSIC);
                } else {
                    attrBuilder.setUsage(android.media.AudioAttributes.USAGE_ASSISTANCE_NAVIGATION_GUIDANCE);
                    attrBuilder.setContentType(android.media.AudioAttributes.CONTENT_TYPE_SPEECH);
                }
                mMediaPlayer.setAudioAttributes(attrBuilder.build());
            } else {
                mMediaPlayer.setAudioStreamType(mAudioStreamType);
            }

            mMediaPlayer.setDataSource(filePath);

            // [CRITICAL FIX] Use Async Prepare and set listener
            mMediaPlayer.setOnPreparedListener(mp -> {
                DebugLogger.d(TAG, "MediaPlayer Prepared (Async). Starting playback...");
                mp.start();
            });

            mMediaPlayer.prepareAsync(); // Async to avoid blocking Main Thread
            DebugLogger.d(TAG, "Preparing sound async: " + filePath);

            mMediaPlayer.setOnCompletionListener(mediaPlayer -> {
                // [FIX] Now uses singleton, so abandonFocus() works correctly
                // [FIX] Only abandon if Direct Mode
                DebugLogger.d(TAG, "Sound completed...");
                if (mIsDirectPlaybackMode) {
                    abandonFocus();
                }
            });

            // Clean up on error too
            mMediaPlayer.setOnErrorListener((mp, what, extra) -> {
                DebugLogger.e(TAG, "MediaPlayer Error: what=" + what + ", extra=" + extra);
                if (mIsDirectPlaybackMode) {
                    abandonFocus();
                }
                return true;
            });

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to play sound: " + filePath, e);
        }
    }
}
