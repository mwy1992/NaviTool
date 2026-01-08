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
    public static final int ZONE_DOOR_FR = 4; // Front Right (Passenger)

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
        // Zone 4 (Front Right) check
        boolean wasOpen = (oldStatus & ZONE_DOOR_FR) != 0;
        boolean isOpen = (newStatus & ZONE_DOOR_FR) != 0;

        if (!wasOpen && isOpen) {
            playSound("sound_door_passenger");
        }
    }

    public void playDoorPassengerSound() {
        playSound("sound_door_passenger");
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

    public void setAudioStreamType(int streamType) {
        mAudioStreamType = streamType;
        DebugLogger.d(TAG, "Audio Stream Type Changed: " +
                (streamType == android.media.AudioManager.STREAM_MUSIC ? "MUSIC (Media)" : "NOTIFICATION (Navi)"));
    }

    private void playFile(String filePath) {
        try {
            // Request Audio Focus
            android.media.AudioManager am = (android.media.AudioManager) mContext
                    .getSystemService(Context.AUDIO_SERVICE);
            android.media.AudioFocusRequest focusRequest = null;
            android.media.AudioManager.OnAudioFocusChangeListener focusChangeListener = focusChange -> {
                // 添加日志以调试焦点变化
                DebugLogger.d(TAG, "Audio Focus Changed: " + focusChange);
            };
            final android.media.AudioManager.OnAudioFocusChangeListener finalFocusListener = focusChangeListener;

            if (am != null) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                    int focusType;
                    if (mIsDirectPlaybackMode) {
                        // Direct Mode: Try Exclusive if available to force pause
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                            focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE;
                        } else {
                            focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
                        }
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

                    focusRequest = new android.media.AudioFocusRequest.Builder(focusType)
                            .setAudioAttributes(playbackAttributes)
                            .setAcceptsDelayedFocusGain(false)
                            .setOnAudioFocusChangeListener(focusChangeListener)
                            .build();
                    int focusResult = am.requestAudioFocus(focusRequest);
                    DebugLogger.d(TAG, "Audio Focus Requested (" + (mIsDirectPlaybackMode ? "DIRECT" : "MIX")
                            + ", Stream="
                            + (mAudioStreamType == android.media.AudioManager.STREAM_MUSIC ? "MEDIA" : "NAVI")
                            + "), result=" + focusResult);
                } else {
                    int focusType;
                    if (mIsDirectPlaybackMode) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                            focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE;
                        } else {
                            focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
                        }
                    } else {
                        focusType = android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
                    }

                    int stream = mAudioStreamType;
                    // Use the selected stream for legacy request

                    int focusResult = am.requestAudioFocus(focusChangeListener, stream, focusType);
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

            final android.media.AudioFocusRequest finalRequest = focusRequest;
            mMediaPlayer.setOnCompletionListener(mediaPlayer -> {
                // Abandon Focus
                DebugLogger.d(TAG, "Sound completed, abandoning audio focus...");
                if (am != null) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O && finalRequest != null) {
                        int result = am.abandonAudioFocusRequest(finalRequest);
                        DebugLogger.d(TAG, "abandonAudioFocusRequest result: " + result);
                    } else {
                        int result = am.abandonAudioFocus(finalFocusListener);
                        DebugLogger.d(TAG, "abandonAudioFocus result: " + result);
                    }
                }
            });

            // Clean up on error too
            mMediaPlayer.setOnErrorListener((mp, what, extra) -> {
                DebugLogger.e(TAG, "MediaPlayer Error: what=" + what + ", extra=" + extra);
                if (am != null) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O && finalRequest != null) {
                        am.abandonAudioFocusRequest(finalRequest);
                    } else {
                        am.abandonAudioFocus(finalFocusListener);
                    }
                }
                return true;
            });

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to play sound: " + filePath, e);
        }
    }
}
