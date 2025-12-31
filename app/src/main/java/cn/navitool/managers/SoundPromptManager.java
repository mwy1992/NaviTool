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

    private void playFile(String filePath) {
        try {
            // Request Audio Focus
            android.media.AudioManager am = (android.media.AudioManager) mContext
                    .getSystemService(Context.AUDIO_SERVICE);
            android.media.AudioFocusRequest focusRequest = null;
            android.media.AudioManager.OnAudioFocusChangeListener focusChangeListener = focusChange -> {
            };
            final android.media.AudioManager.OnAudioFocusChangeListener finalFocusListener = focusChangeListener;

            if (am != null) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    android.media.AudioAttributes playbackAttributes = new android.media.AudioAttributes.Builder()
                            .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
                            .setContentType(android.media.AudioAttributes.CONTENT_TYPE_SPEECH)
                            .build();
                    focusRequest = new android.media.AudioFocusRequest.Builder(
                            android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                            .setAudioAttributes(playbackAttributes)
                            .setAcceptsDelayedFocusGain(false)
                            .setOnAudioFocusChangeListener(focusChangeListener)
                            .build();
                    am.requestAudioFocus(focusRequest);
                } else {
                    am.requestAudioFocus(focusChangeListener, android.media.AudioManager.STREAM_MUSIC,
                            android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                }
            }

            if (mMediaPlayer == null) {
                mMediaPlayer = new MediaPlayer();
            } else {
                mMediaPlayer.reset();
            }
            mMediaPlayer.setDataSource(filePath);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            DebugLogger.d(TAG, "Playing sound: " + filePath);

            final android.media.AudioFocusRequest finalRequest = focusRequest;
            mMediaPlayer.setOnCompletionListener(mediaPlayer -> {
                // Abandon Focus
                if (am != null) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O && finalRequest != null) {
                        am.abandonAudioFocusRequest(finalRequest);
                    } else {
                        am.abandonAudioFocus(finalFocusListener);
                    }
                }
            });

            // Clean up on error too
            mMediaPlayer.setOnErrorListener((mp, what, extra) -> {
                if (am != null) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O && finalRequest != null) {
                        am.abandonAudioFocusRequest(finalRequest);
                    } else {
                        am.abandonAudioFocus(finalFocusListener);
                    }
                }
                return false;
            });

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to play sound: " + filePath, e);
        }
    }
}
