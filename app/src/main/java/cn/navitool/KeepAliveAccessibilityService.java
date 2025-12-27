package cn.navitool;

import android.accessibilityservice.AccessibilityService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.PowerManager;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import android.media.MediaPlayer;

import com.ecarx.xui.adaptapi.car.Car;
import com.ecarx.xui.adaptapi.car.ICar;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;
import com.ecarx.xui.adaptapi.car.vehicle.IDayMode;
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle;
import com.ecarx.xui.adaptapi.car.vehicle.IPAS;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;

public class KeepAliveAccessibilityService extends AccessibilityService {

    private static final String TAG = "KeepAliveService";
    private static final String AUTONAVI_PKG = "com.autonavi.amapauto";

    private ICarFunction iCarFunction;

    private ISensor iSensor;

    // WakeLock for PSD Always On
    private PowerManager.WakeLock mWakeLock;

    // Brightness Polling
    private boolean mIsOverrideEnabled = false;
    private boolean mIsSyncBrightnessEnabled = true; // Default true
    private int mTargetBrightnessDay = 5;
    private int mTargetBrightnessNight = 3;
    private int mTargetBrightnessAvm = 15;
    private int mLastAvmValue = 0;
    private int mLastDayNightSensorValue = -1;
    private int mLastBrightnessDayValue = -1;
    private int mLastBrightnessNightValue = -1;
    private int mLastThemeMode = -1;
    private float mLastLightSensorValue = -1f;

    // Polling Handler
    private final android.os.Handler mOverrideHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final Runnable mOverrideRunnable = new Runnable() {
        @Override
        public void run() {
            checkAndEnforceBrightness();
            // 150ms interval for aggressive enforcement
            mOverrideHandler.postDelayed(this, 150);
        }
    };

    // PSD Polling (10s interval)
    private boolean mIsPsdAlwaysOnEnabled = false;
    private final android.os.Handler mPsdHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final Runnable mPsdRunnable = new Runnable() {
        @Override
        public void run() {
            if (mIsPsdAlwaysOnEnabled && iCarFunction != null) {
                try {
                    // [调试] 监控 PSD 开关状态: 如果发现屏幕被关闭 (0)，记录警告日志
                    int currentPsdStatus = iCarFunction.getFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL);
                    if (currentPsdStatus == 0) {
                        DebugLogger.w(TAG, "PSD Monitor: Detected PSD Screen is OFF (0). Enforcing ON...");
                    }

                    // 1. Force PSD ON (1) - Original command
                    iCarFunction.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 1);

                    // 2. Disable Power Timeout (Set to 0 = Never, or large value)
                    // Trying large value (1h) instead of 0, as 0 might mean "immediate timeout"
                    iCarFunction.setFunctionValue(FUNC_POWER_TIMEOUT, ZONE_ALL, 3600000);

                    // 3. Force PSD Power Status (1 = On)
                    iCarFunction.setFunctionValue(FUNC_POWER_PSD_STATUS, ZONE_ALL, 1);

                    DebugLogger.d(TAG, "Enforced PSD Screen ON (Anti-Timeout)");
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Failed to enforce PSD Screen ON", e);
                }
            }
            // 2s interval - Aggressive keep-alive to prevent system override
            mPsdHandler.postDelayed(this, 2000);
        }
    };

    // PSD Countermeasure
    private final android.os.Handler mPsd10MinHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private static final long PSD_COUNTERMEASURE_DELAY_MS = 9 * 60 * 1000 + 59 * 1000 + 950; // 9m 59s 950ms
    private BroadcastReceiver mPsdTestReceiver;

    private void setPsdOn() {
        if (iCarFunction != null) {
            try {
                iCarFunction.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 1);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to set PSD ON", e);
            }
        }
    }

    private void schedulePsd10MinCountermeasure() {
        mPsd10MinHandler.removeCallbacksAndMessages(null); // Reset
        mPsd10MinHandler.postDelayed(() -> {
            DebugLogger.w(TAG, ">>> 10-MIN COUNTERMEASURE TRIGGERED! (9m59.95s after OFF)");
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    setPsdOn();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                DebugLogger.d(TAG, ">>> 10-Min Countermeasure Barrage Completed.");
            }).start();
        }, PSD_COUNTERMEASURE_DELAY_MS);
    }

    private void broadcastPsdStatus(int status) {
        Intent intent = new Intent("cn.navitool.ACTION_PSD_STATUS");
        intent.putExtra("status", status);
        intent.putExtra("timestamp", System.currentTimeMillis());
        sendBroadcast(intent);
    }

    private void registerPsdTestReceiver() {
        mPsdTestReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if ("cn.navitool.ACTION_TEST_PSD_SWITCH".equals(intent.getAction())) {
                    int delayMs = intent.getIntExtra("delay", 0);
                    DebugLogger.w(TAG, "TEST: Executing PSD Switch Test (Delay: " + delayMs + "ms)");

                    // Send 0
                    try {
                        if (iCarFunction != null)
                            iCarFunction.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Delay
                    if (delayMs > 0) {
                        try {
                            Thread.sleep(delayMs);
                        } catch (InterruptedException e) {
                        }
                    }

                    // Send 1
                    setPsdOn();
                    DebugLogger.d(TAG, "TEST: PSD Switch Test Completed.");
                }
            }
        };
        IntentFilter filter = new IntentFilter("cn.navitool.ACTION_TEST_PSD_SWITCH");
        registerReceiver(mPsdTestReceiver, filter);
    }

    private final SharedPreferences.OnSharedPreferenceChangeListener prefsListener = (sharedPreferences, key) -> {
        if ("force_auto_day_night".equals(key) || "enable_24_25_light_sensor".equals(key)) {
            boolean forceAuto = sharedPreferences.getBoolean("force_auto_day_night", false);
            boolean sensor2425 = sharedPreferences.getBoolean("enable_24_25_light_sensor", false);
            if (forceAuto || sensor2425) {
                startMonitoring();
            } else {
                stopMonitoring();
            }
        } else if ("adb_wireless_enabled".equals(key)) {
            if (sharedPreferences.getBoolean(key, false)) {
                AdbShell.getInstance(KeepAliveAccessibilityService.this).connect();
            } else {
                AdbShell.getInstance(KeepAliveAccessibilityService.this).close();
            }
        } else if ("override_brightness_enabled".equals(key)) {
            mIsOverrideEnabled = sharedPreferences.getBoolean(key, false);
            if (mIsOverrideEnabled) {
                mOverrideHandler.post(mOverrideRunnable);
            } else {
                mOverrideHandler.removeCallbacks(mOverrideRunnable);
            }
        } else if ("sync_brightness_enabled".equals(key)) {
            mIsSyncBrightnessEnabled = sharedPreferences.getBoolean(key, true);
        } else if ("override_day_value".equals(key)) {
            mTargetBrightnessDay = sharedPreferences.getInt(key, 5);
        } else if ("override_night_value".equals(key)) {
            mTargetBrightnessNight = sharedPreferences.getInt(key, 3);
        } else if ("override_avm_value".equals(key)) {
            mTargetBrightnessAvm = sharedPreferences.getInt(key, 15);
        } else if ("psd_always_on_enabled".equals(key)) {
            mIsPsdAlwaysOnEnabled = sharedPreferences.getBoolean(key, false);
            if (mIsPsdAlwaysOnEnabled) {
                mPsdHandler.removeCallbacks(mPsdRunnable);
                mPsdHandler.post(mPsdRunnable);
                acquireWakeLock();
            } else {
                mPsdHandler.removeCallbacks(mPsdRunnable);
                releaseWakeLock();
                if (iCarFunction != null) {
                    try {
                        iCarFunction.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 0);
                    } catch (Exception e) {
                        DebugLogger.e(TAG, "Failed to turn off PSD", e);
                    }
                }
            }
        }
    };

    // private KeepAlivePresentation mPsdPresentation; // Removed

    // initPsdKeepAlive and showKeepAliveOnDisplay Removed

    @Override
    public void onCreate() {
        super.onCreate();
        DebugLogger.i(TAG, "Service Created");
        DebugLogger.createDirectories();

        // 启动光照传感器验证器
        try {
            cn.navitool.verifier.LightSensorVerifier verifier = new cn.navitool.verifier.LightSensorVerifier(this);
            verifier.start();
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to start LightSensorVerifier", e);
        }

        // 启动副驾屏保活
        // initPsdKeepAlive(); // [Removed]

        registerPsdTestReceiver();

        // [新增] 初始化车辆控制接口 (监听发动机、档位、车门等)
        initCar();
        // [新增] 绑定 OneOS 服务 (用于方控/微信按键)
        bindOneOSService();
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        DebugLogger.init(this); // Initialize DebugLogger
        DebugLogger.i(TAG, "Service Connected");

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.registerOnSharedPreferenceChangeListener(prefsListener);

        // Initial check for auto day/night mode or 24-25 sensor
        boolean forceAuto = prefs.getBoolean("force_auto_day_night", false);
        boolean sensor2425 = prefs.getBoolean("enable_24_25_light_sensor", false);

        // Unconditionally initialize Car API (Sensor listeners)
        checkDayNightStatus(false);

        if (forceAuto || sensor2425) {
            startMonitoring();
        }

        // Initialize ADB Loopback if enabled
        // Initialize ADB Loopback if enabled
        if (prefs.getBoolean("adb_wireless_enabled", false)) {
            AdbShell.getInstance(this).connect();
        }

        // Initialize Brightness Override
        mIsOverrideEnabled = prefs.getBoolean("override_brightness_enabled", false);
        mIsSyncBrightnessEnabled = prefs.getBoolean("sync_brightness_enabled", true);
        mTargetBrightnessDay = prefs.getInt("override_day_value", 5);
        mTargetBrightnessNight = prefs.getInt("override_night_value", 3);
        mTargetBrightnessAvm = prefs.getInt("override_avm_value", 15);

        if (mIsOverrideEnabled) {
            mOverrideHandler.post(mOverrideRunnable);
        }

        // Initialize PSD
        mIsPsdAlwaysOnEnabled = prefs.getBoolean("psd_always_on_enabled", false);
        if (mIsPsdAlwaysOnEnabled) {
            mPsdHandler.post(mPsdRunnable);
            acquireWakeLock();
        }

        // Bind OneOS Service
        bindOneOSService();

        // Log boot event (with cooldown check)
        DebugLogger.logBootEvent(this);

        // Register receiver for config changes
        DebugLogger.i(TAG, "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        // Register receiver for config changes
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        filter.addAction("cn.navitool.ACTION_REQUEST_ONEOS_STATUS");
        try {
            if (Build.VERSION.SDK_INT >= 33) { // Android 13+ (Tiramisu)
                registerReceiver(configChangeReceiver, filter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(configChangeReceiver, filter);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register configChangeReceiver", e);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DebugLogger.i(TAG, "Service destroying, cleaning up resources...");
        stopMonitoring();
        releaseWakeLock();
        mOverrideHandler.removeCallbacks(mOverrideRunnable);
        mPsdHandler.removeCallbacks(mPsdRunnable);

        // if (mPsdPresentation != null) {
        // mPsdPresentation.dismiss();
        // }

        if (mPsdTestReceiver != null) {
            unregisterReceiver(mPsdTestReceiver);
        }
        // The following catch block and assignment were part of the mPsdPresentation
        // logic.
        // Since mPsdPresentation dismissal is commented out, these lines are also
        // commented/removed
        // to maintain syntactical correctness and reflect the intended change.
        // try {
        // if (mPsdPresentation != null) {
        // mPsdPresentation.dismiss();
        // }
        // } catch (Exception e) {
        // DebugLogger.w(TAG, "Error dismissing presentation", e);
        // }
        // mPsdPresentation = null;

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.unregisterOnSharedPreferenceChangeListener(prefsListener);

        try {
            unregisterReceiver(configChangeReceiver);
            DebugLogger.d(TAG, "Unregistered config change receiver");
        } catch (Exception e) {
            // Ignore
        }

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            CharSequence packageName = event.getPackageName();
            if (packageName != null && AUTONAVI_PKG.equals(packageName.toString())) {
                DebugLogger.d(TAG, "AutoNavi detected in foreground. Syncing theme...");
                syncAutoNaviTheme();
            }
        }
    }

    @Override
    public void onInterrupt() {
        // Service interrupted
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Sync theme when system configuration changes (e.g. Day/Night switch)
        DebugLogger.d(TAG, "onConfigurationChanged called.");
        syncAutoNaviTheme();
    }

    // Day/Night Mode Constants
    private static final int FUNC_DAYMODE_SETTING = 0x20150100;
    // Removed local SENSOR_TYPE_DAY_NIGHT, using ISensor.SENSOR_TYPE_DAY_NIGHT
    private static final int FUNC_PSD_SCREEN_SWITCH = 539495936; // SETTING_FUNC_PSD_SCREEN_SWITCH

    // Restored Constants
    private static final int FUNC_AVM_STATUS = IPAS.PAS_FUNC_PAC_ACTIVATION;
    private static final int FUNC_BRIGHTNESS_DAY = IVehicle.SETTING_FUNC_BRIGHTNESS_DAY;
    private static final int FUNC_BRIGHTNESS_NIGHT = IVehicle.SETTING_FUNC_BRIGHTNESS_NIGHT;
    private static final int FUNC_BRIGHTNESS_DIM = 687998208; // SETTING_FUNC_BRIGHTNESS_DIM
    private static final int FUNC_BRIGHTNESS_BACKLIGHT = 687997184; // Unified Vehicle Brightness

    private static final int ZONE_ALL = 0x80000000;
    private static final int ZONE_CSD = 1; // Central Screen
    private static final int ZONE_PSD = 4; // Passenger Screen
    private static final int ZONE_PSD_FUNC = 4; // Passenger Screen Zone ID (Legacy name kept if used elsewhere, or just
                                                // replace)

    private static final int FUNC_BRIGHTNESS_DAYMODE = 688062976; // New Discovery
    private static final int FUNC_BRIGHTNESS_SCREEN = 688063744; // New Discovery

    // Power Manager IDs
    private static final int FUNC_POWER_TIMEOUT = 32888;
    private static final int FUNC_POWER_PSD_STATUS = 32901;

    private static final int VALUE_DAYMODE_DAY = 0x20150101;
    private static final int VALUE_DAYMODE_NIGHT = 0x20150102;
    private static final int VALUE_DAYMODE_AUTO = 0x20150103;
    private static final int VALUE_DAYMODE_CUSTOM = 0x20150104;
    private static final int VALUE_DAYMODE_SUNRISE_AND_SUNSET = 0x20150105;

    // 24-25 Model Light Sensor (Found in ISensor.java)
    // SENSOR_TYPE_LIGHT = 2100992 (0x200F00)
    private static final int SENSOR_TYPE_LIGHT = 0x200F00;

    // Sound Prompt Sensors
    private static final int SENSOR_TYPE_GEAR = 2097664; // 0x200200
    private static final int BCM_FUNC_DOOR = 553779456; // 0x21020000

    // Door Zones (According to Logcat)
    private static final int ZONE_DOOR_FL = 1; // Front Left (Main Driver)
    private static final int ZONE_DOOR_FR = 4; // Front Right (Passenger)
    private static final int ZONE_DOOR_RL = 16; // Rear Left
    private static final int ZONE_DOOR_RR = 64; // Rear Right

    // Sound Prompt States
    private int mLastIgnition = -1;
    private int mLastGear = -1;
    private int mLastDoor = -1;
    private MediaPlayer mMediaPlayer;

    // Gear Values (from ISensorEvent)
    private static final int GEAR_PARK = 2097712;
    private static final int GEAR_REVERSE = 2097728;
    private static final int GEAR_NEUTRAL = 2097680;
    private static final int BCM_FUNC_LIGHT_DIPPED_BEAM = 553976064; // 0x21051000
    private static final int BCM_FUNC_LIGHT_MAIN_BEAM = 553976320; // 0x21051100

    private static final int GEAR_DRIVE = 2097696;

    // TrsmGear Values (Backup)
    private static final int TRSM_GEAR_PARK = 15;
    private static final int TRSM_GEAR_RVS = 14;
    private static final int TRSM_GEAR_NEUT = 0;

    // Door Masks
    private static final int DOOR_PASSENGER_MASK = 0x02; // 0010 (?) Or 0100? checking...
    // VehicleDoor.java says DOOR_ROW_1_RIGHT = 4. 4 is 0x04.
    // Let's rely on testing or standard mask. 4 usually means bit 2 (1<<2).
    // Logic below will rely on 4.
    private static final int DOOR_PASSENGER_BIT = 4;

    private final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private boolean mIsMonitoring = false;
    private static final long MONITOR_INTERVAL_MS = 1000; // Updated to 1s (User Request)

    private final Runnable mMonitorRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsMonitoring)
                return;
            checkAndForceAutoDayNight();
            mHandler.postDelayed(this, 1000); // 1s
                                              // Interval
        }
    };

    private void startMonitoring() {
        if (mIsMonitoring)
            return;
        mIsMonitoring = true;
        mHandler.post(mMonitorRunnable);
        DebugLogger.i(TAG, "Started Day/Night mode monitoring");
    }

    private void stopMonitoring() {
        mIsMonitoring = false;
        mHandler.removeCallbacks(mMonitorRunnable);
        DebugLogger.i(TAG, "Stopped Day/Night mode monitoring");
    }

    private void checkAndForceAutoDayNight() {
        checkAndEnforceBrightness();
        pollAndBroadcastBrightness();
        checkDayNightStatus(true);
    }

    private int mLastSetBrightness = -1;

    private void pollAndBroadcastBrightness() {
        if (iCarFunction == null)
            return;
        try {
            boolean changed = false;

            float brightDay = iCarFunction.getCustomizeFunctionValue(FUNC_BRIGHTNESS_DAY, ZONE_ALL);
            if (brightDay != -1f && (int) brightDay != mLastBrightnessDayValue) {
                mLastBrightnessDayValue = (int) brightDay;
                changed = true;
            }

            // Poll Night Brightness
            float brightNight = iCarFunction.getCustomizeFunctionValue(FUNC_BRIGHTNESS_NIGHT, ZONE_ALL);
            if (brightNight != -1f && (int) brightNight != mLastBrightnessNightValue) {
                mLastBrightnessNightValue = (int) brightNight;
                changed = true;
            }

            // Poll Day/Night Sensor (Fix for Unknown Status)
            if (iSensor != null) {
                int dayNight = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_DAY_NIGHT);
                if (dayNight != -1 && dayNight != mLastDayNightSensorValue) {
                    mLastDayNightSensorValue = dayNight;
                    changed = true;
                }
            }

            if (changed) {
                DebugLogger.d(TAG, "Polled Brightness Changed - Day: " + mLastBrightnessDayValue + ", Night: "
                        + mLastBrightnessNightValue);
                broadcastSensorValues(mLastDayNightSensorValue,
                        mLastAvmValue, mLastBrightnessDayValue, mLastBrightnessNightValue);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error polling brightness", e);
        }
    }

    private void broadcastSensorValues(int dayNightValue, int avmValue,
            int brightnessDay, int brightnessNight) {
        mLastDayNightSensorValue = dayNightValue;
        mLastAvmValue = avmValue;
        mLastBrightnessDayValue = brightnessDay;
        mLastBrightnessNightValue = brightnessNight;

        Intent intent = new Intent("cn.navitool.ACTION_DAY_NIGHT_STATUS");
        // We send just sensor values.
        intent.putExtra("mode", mLastThemeMode); // Include Theme Mode
        intent.putExtra("sensor_day_night", dayNightValue);
        intent.putExtra("prop_avm", avmValue);
        intent.putExtra("prop_brightness_day", brightnessDay);
        intent.putExtra("prop_brightness_night", brightnessNight);
        sendBroadcast(intent);
    }

    private void checkDayNightStatus(boolean enforceAuto) {
        new Thread(() -> {
            initCar();
            if (iCarFunction != null) {
                try {
                    int currentMode = iCarFunction.getFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL);

                    // Explicitly poll values to ensure initial state is captured
                    try {
                        // Polling Speed (0x100100) - Assuming float or int? ISensor usually callbacks.
                        // But we can try getFunctionValue? Or wait for listener.
                        // SENSOR_TYPE_SPEED is likely ISensor.
                        // But for properties (Reverse, AVM, Brightness), we SHOULD poll.

                        int avm = iCarFunction.getFunctionValue(FUNC_AVM_STATUS, ZONE_ALL);
                        if (avm != -1)
                            mLastAvmValue = avm;

                        // Poll Day Brightness
                        float brightDay = iCarFunction.getCustomizeFunctionValue(FUNC_BRIGHTNESS_DAY, ZONE_ALL);
                        if (brightDay != -1f) {
                            mLastBrightnessDayValue = (int) brightDay;
                        }

                        // Poll Night Brightness
                        float brightNight = iCarFunction.getCustomizeFunctionValue(FUNC_BRIGHTNESS_NIGHT, ZONE_ALL);
                        if (brightNight != -1f) {
                            mLastBrightnessNightValue = (int) brightNight;
                        }

                        // Poll Day/Night Sensor (User request: polling every 1s)
                        if (iSensor != null) {
                            int dayNight = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_DAY_NIGHT);
                            if (dayNight != -1) {
                                mLastDayNightSensorValue = dayNight;
                            }
                        }

                        // Poll 24-25 Light Sensor (SENSOR_TYPE_LIGHT)
                        if (iSensor != null) {
                            float lightVal = iSensor.getSensorEvent(SENSOR_TYPE_LIGHT);
                            if (lightVal != -1) {
                                mLastLightSensorValue = lightVal;
                            }
                        }

                    } catch (Exception e) {
                        DebugLogger.w(TAG, "Failed to poll initial function values: " + e.getMessage());
                    }

                    if (currentMode != -1 && currentMode != 0) {
                        mLastThemeMode = currentMode;
                    }

                    // Broadcast status to UI
                    Intent intent = new Intent("cn.navitool.ACTION_DAY_NIGHT_STATUS");
                    intent.putExtra("mode", mLastThemeMode);
                    // Include last known sensor values to keep UI in sync
                    intent.putExtra("sensor_day_night", mLastDayNightSensorValue);
                    intent.putExtra("prop_avm", mLastAvmValue);
                    intent.putExtra("prop_brightness_day", mLastBrightnessDayValue);
                    intent.putExtra("prop_brightness_night", mLastBrightnessNightValue);
                    sendBroadcast(intent);

                    if (enforceAuto) {
                        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
                        boolean isForceEnabled = prefs.getBoolean("force_auto_day_night", false);

                        if (isForceEnabled && currentMode != VALUE_DAYMODE_AUTO) {
                            DebugLogger.i(TAG, "Detected non-Auto mode: " + Integer.toHexString(currentMode)
                                    + ". Forcing AUTO...");
                            boolean success = iCarFunction.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL,
                                    VALUE_DAYMODE_AUTO);
                            if (success) {
                                DebugLogger.toast(this, "已强制恢复为自动模式");
                                // Broadcast update immediately
                                intent.putExtra("mode", VALUE_DAYMODE_AUTO);
                                sendBroadcast(intent);
                            } else {
                                DebugLogger.e(TAG, "Failed to set Day/Night mode to AUTO");
                            }
                        }
                    }

                    // Check 24-25 Model Light Sensor Logic (in background)
                    check2425LightSensorLogic();
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Error checking/setting Day/Night mode", e);
                }
            }
        }).start();

    }

    private void handleShortClick(int keyCode) {
        DebugLogger.i(TAG, "handleShortClick: " + keyCode);

        if (keyCode == 200087 || keyCode == 200088 || keyCode == 200085) {
            SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
            boolean enabled = prefs.getBoolean("steering_wheel_control", false);
            if (!enabled) {
                DebugLogger.d(TAG, "Steering wheel control disabled, skipping media key");
                return;
            }
        }

        switch (keyCode) {
            case 200087: // R_MEDIA_NEXT - 短按下一曲
                simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_NEXT);
                break;
            case 200088: // R_MEDIA_PREVIOUS - 短按上一曲
                simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS);
                break;
            case 200085: // R_MEDIA_PLAY_PAUSE - 短按播放/暂停
                simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
                break;
            case 200400: // R_WECHAT - 短按微信按键
                handleWechatShortPress();
                break;
            default:
                DebugLogger.d(TAG, "Unhandled short click key code: " + keyCode);
                break;
        }
    }

    private void handleLongPress(int keyCode) {
        DebugLogger.i(TAG, "handleLongPress: " + keyCode);
        switch (keyCode) {
            // case 200087: // R_MEDIA_NEXT - 长按下一曲（快进）
            // DebugLogger.i(TAG, "Long press NEXT - fast forward");
            // break;
            // case 200088: // R_MEDIA_PREVIOUS - 长按上一曲（快退）
            // DebugLogger.i(TAG, "Long press PREVIOUS - rewind");
            // break;
            // case 200085: // R_MEDIA_PLAY_PAUSE - 长按播放/暂停
            // DebugLogger.i(TAG, "Long press PLAY_PAUSE");
            // break;
            case 200400: // R_WECHAT - 长按微信按键
                handleWechatLongPress();
                break;
            default:
                DebugLogger.d(TAG, "Unhandled long press key code: " + keyCode);
                break;
        }
    }

    private void handleWechatShortPress() {
        SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean enabled = prefs.getBoolean("wechat_button_enabled", false);
        if (!enabled) {
            DebugLogger.d(TAG, "WeChat button function disabled");
            return;
        }

        int action = prefs.getInt("wechat_short_press_action", 0);
        String packageName = prefs.getString("wechat_short_press_app", "");

        if (packageName.isEmpty())
            return;

        if (action == 1) { // 启动应用
            launchApp(packageName);
        } else if (action == 2) { // 结束任务
            killApp(packageName);
        }
    }

    private void handleWechatLongPress() {
        SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean enabled = prefs.getBoolean("wechat_button_enabled", false);
        if (!enabled) {
            DebugLogger.d(TAG, "WeChat button function disabled");
            return;
        }

        int action = prefs.getInt("wechat_long_press_action", 0);
        String packageName = prefs.getString("wechat_long_press_app", "");

        if (packageName.isEmpty())
            return;

        if (action == 1) { // 启动应用
            launchApp(packageName);
        } else if (action == 2) { // 结束任务
            killApp(packageName);
        }
    }

    private void killApp(String packageName) {
        if (packageName == null || packageName.isEmpty())
            return;

        // Method 1: ADB Force Stop (Best)
        if (AdbShell.getInstance(this).isConnected()) {
            AdbShell.getInstance(this).exec("am force-stop " + packageName);
            DebugLogger.toast(this, String.format(getString(R.string.msg_kill_app_success), packageName));
            return;
        }

        // Method 2: API Kill Background Processes (Weak)
        try {
            android.app.ActivityManager am = (android.app.ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            if (am != null) {
                am.killBackgroundProcesses(packageName);
                DebugLogger.toast(this, String.format(getString(R.string.msg_kill_app_success), packageName) + " (后台)");
            }
        } catch (Exception e) {
            DebugLogger.toast(this, String.format(getString(R.string.msg_kill_app_failed), e.getMessage()));
        }
    }

    private void launchApp(String packageName) {
        try {
            android.content.pm.PackageManager pm = getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(packageName);
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                DebugLogger.i(TAG, "Launched app: " + packageName);
                DebugLogger.toast(this, "正在启动: " + packageName);
            } else {
                DebugLogger.e(TAG, "Could not find launch intent for " + packageName);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error launching app " + packageName, e);
        }
    }

    private void check2425LightSensorLogic() {
        SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean enabled = prefs.getBoolean("enable_24_25_light_sensor", false);

        // Require enabled switch, valid car function, and valid Day/Night sensor data
        if (!enabled || iCarFunction == null || mLastDayNightSensorValue == -1) {
            return;
        }

        try {
            int currentMode = iCarFunction.getFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL);

            // Logic: Sync Theme Mode with SENSOR_TYPE_DAY_NIGHT state
            if (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_NIGHT) {
                // Sensor says Night -> Set Night Mode
                if (currentMode != VALUE_DAYMODE_NIGHT) {
                    DebugLogger.i(TAG, "24-25 Logic: Sensor is NIGHT. Switching Theme to NIGHT.");
                    iCarFunction.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL, VALUE_DAYMODE_NIGHT);
                }
            } else if (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_DAY) {
                // Sensor says Day -> Set Day Mode
                if (currentMode != VALUE_DAYMODE_DAY) {
                    DebugLogger.i(TAG, "24-25 Logic: Sensor is DAY. Switching Theme to DAY.");
                    iCarFunction.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL, VALUE_DAYMODE_DAY);
                }
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error in 24-25 Light Sensor Logic", e);
        }
    }

    private int mEnforceCounter = 0;

    private void checkAndEnforceBrightness() {
        if (!mIsOverrideEnabled || iCarFunction == null)
            return;

        // Periodic forced check (every ~3 seconds, assuming 150ms interval => 20 ticks)
        // This ensures that if the system changes brightness behind our back, we catch
        // it eventually.
        mEnforceCounter++;
        if (mEnforceCounter > 20) {
            mLastSetBrightness = -1;
            mEnforceCounter = 0;
        }

        int targetValue;
        int funcId;
        int zone = ZONE_ALL; // Default zone

        // 1. Check AVM Status (Priority)
        // 0 = Inactive, 1 = Active (approx)
        boolean isAvmActive = (mLastAvmValue == 1);

        if (isAvmActive) {
            targetValue = mTargetBrightnessAvm;
            // AVM Mode: Check if we are in Day or Night to set the correct underlying
            // register
            if (mLastDayNightSensorValue == -1) {
                // Safety fallback
                funcId = FUNC_BRIGHTNESS_DAY;
            } else {
                boolean isDay = (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_DAY);
                funcId = isDay ? FUNC_BRIGHTNESS_DAY : FUNC_BRIGHTNESS_NIGHT;
            }
        } else {
            // 2. Normal Mode
            // Strictly require valid sensor data
            if (mLastDayNightSensorValue == -1) {
                // Sensor data not ready, do not enforce anything yet to avoid wrong brightness
                return;
            }

            // Check against official boolean/int constant
            // Assuming ISensorEvent.DAY_NIGHT_MODE_DAY is integer.
            boolean isDay = (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_DAY);
            if (isDay) {
                targetValue = mTargetBrightnessDay;
                funcId = FUNC_BRIGHTNESS_DAY;
            } else {
                targetValue = mTargetBrightnessNight;
                funcId = FUNC_BRIGHTNESS_NIGHT;
            }
        }

        // 3. Compare with current known value
        // We use our cached values which update via sensor polling
        int currentKnownValue = (funcId == FUNC_BRIGHTNESS_DAY) ? mLastBrightnessDayValue : mLastBrightnessNightValue;

        if (currentKnownValue != targetValue) {
            // Only set if we haven't already set this value successfully
            if (mLastSetBrightness != targetValue) {
                DebugLogger.i(TAG, "Enforcing Unified Brightness (Refactored). Target: " + targetValue + " Current: "
                        + currentKnownValue);
                try {
                    // 1. CSD Control (Central Screen) - Explicit Zone 1
                    iCarFunction.setCustomizeFunctionValue(funcId, ZONE_CSD, (float) targetValue);

                    // 2. Sync Logic - REMOVED per user request (Revert to CSD only)
                    // if (mIsSyncBrightnessEnabled) { ... }

                    // 4. Update Local Cache
                    mLastSetBrightness = targetValue;
                    if (funcId == FUNC_BRIGHTNESS_DAY)
                        mLastBrightnessDayValue = targetValue;
                    else
                        mLastBrightnessNightValue = targetValue;

                } catch (Exception e) {
                    DebugLogger.e(TAG, "Failed to set brightness", e);
                }
            } else {
                DebugLogger.d(TAG, "Brightness mismatch but skipped (Already set). Target=" + targetValue + " Cur="
                        + currentKnownValue);
            }
        }

        // Sync Dashboard (DIM) Brightness - Removed per user request

    }

    private void acquireWakeLock() {
        if (mWakeLock == null) {
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            if (pm != null) {
                // PARTIAL_WAKE_LOCK ensures CPU runs, but screen can go off.
                // However, since we are controlling screen via Car API, we just need CPU to
                // keep sending commands.
                mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "NaviTool:PSDKeeper");
                mWakeLock.setReferenceCounted(false);
            }
        }
        if (mWakeLock != null && !mWakeLock.isHeld()) {
            try {
                mWakeLock.acquire();
                DebugLogger.i(TAG, "WakeLock acquired (PSD Always On)");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error acquiring WakeLock", e);
            }
        }
    }

    private void releaseWakeLock() {
        if (mWakeLock != null && mWakeLock.isHeld()) {
            try {
                mWakeLock.release();
                DebugLogger.i(TAG, "WakeLock released");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error releasing WakeLock", e);
            }
        }
    }

    // --- Car AdaptAPI Implementation ---

    private void initCar() {
        try {
            if (iCarFunction == null || iSensor == null) {
                ICar car = Car.create(getApplicationContext());
                if (car != null) {
                    iCarFunction = car.getICarFunction();

                    if (car instanceof ISensor) {
                        iSensor = (ISensor) car;
                    }

                    try {
                        if (iSensor == null) {
                            java.lang.reflect.Method method = car.getClass().getMethod("getSensorManager");
                            iSensor = (ISensor) method.invoke(car);
                        }
                    } catch (Exception ex) {
                        DebugLogger.w(TAG, "getSensorManager not found via reflection");
                    }

                    DebugLogger.i(TAG, "Car AdaptAPI initialized successfully");

                    if (iSensor != null) {
                        registerSensorListeners();
                    }
                    if (iCarFunction != null) {
                        registerFunctionListeners();
                    }
                }
            }
        } catch (Throwable e) {
            DebugLogger.e(TAG, "Failed to initialize Car AdaptAPI: " + e.getMessage());
        }
    }

    private void registerSensorListeners() {
        try {
            if (iSensor != null) {
                ISensor.ISensorListener listener = new ISensor.ISensorListener() {
                    @Override
                    public void onSensorValueChanged(int sensorType, float value) {
                        if (sensorType == SENSOR_TYPE_LIGHT) {
                            if (mLastLightSensorValue != value) {
                                DebugLogger.log(KeepAliveAccessibilityService.this, "LightSensor",
                                        "Value: " + value);
                                mLastLightSensorValue = value;
                                check2425LightSensorLogic();
                            }
                        } else if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
                            int val = (int) value;
                            DebugLogger.d(TAG, "Ignition State Changed (float): " + val);
                            if (val == ISensorEvent.IGNITION_STATE_DRIVING) {
                                DebugLogger.i(TAG, "Ignition State: DRIVING");
                                DebugLogger.toast(KeepAliveAccessibilityService.this, "检测到行车状态");
                                AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);
                            }

                        }
                    }

                    @Override
                    public void onSensorEventChanged(int sensorType, int value) {
                        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);

                        if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
                            DebugLogger.d(TAG, "Ignition State Changed (int): " + value);
                            if (value == ISensorEvent.IGNITION_STATE_DRIVING) {
                                DebugLogger.i(TAG, "Ignition State: DRIVING");
                                DebugLogger.toast(KeepAliveAccessibilityService.this, "检测到行车状态");
                                AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);
                            }

                            // Sound Prompt: Start (Modified: Only play on DRIVING state)
                            if (mLastIgnition != value) {
                                if (value == ISensorEvent.IGNITION_STATE_DRIVING) {
                                    if (prefs.getBoolean("sound_start_enabled", false)) {
                                        playCustomSound(prefs.getString("sound_start_file", "start.mp3"));
                                    }
                                }
                                mLastIgnition = value;
                            }

                        } else if (sensorType == SENSOR_TYPE_GEAR) {
                            if (mLastGear != value) {
                                DebugLogger.d(TAG, "Gear Changed: " + value);
                                String soundFile = null;
                                // Support both ISensorEvent (large int) and TrsmGear (small int)
                                if (value == GEAR_DRIVE
                                        || ((value & 0x0F) != TRSM_GEAR_NEUT && (value & 0x0F) != TRSM_GEAR_RVS
                                                && (value & 0x0F) != TRSM_GEAR_PARK && value != TRSM_GEAR_NEUT
                                                && value != TRSM_GEAR_RVS && value != TRSM_GEAR_PARK)) { // Simplified
                                                                                                         // Drive Logic
                                                                                                         // check for
                                                                                                         // readability
                                    if (prefs.getBoolean("sound_gear_d_enabled", false)) {
                                        soundFile = prefs.getString("sound_gear_d_file", "gear_d.mp3");
                                        DebugLogger.d(TAG, "Gear D detected, Sound Enabled: " + soundFile);
                                    } else {
                                        DebugLogger.d(TAG, "Gear D detected, Sound Disabled");
                                    }
                                } else if (value == GEAR_NEUTRAL || value == TRSM_GEAR_NEUT) {
                                    if (prefs.getBoolean("sound_gear_n_enabled", false)) {
                                        soundFile = prefs.getString("sound_gear_n_file", "gear_n.mp3");
                                        DebugLogger.d(TAG, "Gear N detected, Sound Enabled: " + soundFile);
                                    } else {
                                        DebugLogger.d(TAG, "Gear N detected, Sound Disabled");
                                    }
                                } else if (value == GEAR_REVERSE || value == TRSM_GEAR_RVS) {
                                    if (prefs.getBoolean("sound_gear_r_enabled", false)) {
                                        soundFile = prefs.getString("sound_gear_r_file", "gear_r.mp3");
                                        DebugLogger.d(TAG, "Gear R detected, Sound Enabled: " + soundFile);
                                    } else {
                                        DebugLogger.d(TAG, "Gear R detected, Sound Disabled");
                                    }
                                } else if (value == GEAR_PARK || value == TRSM_GEAR_PARK) {
                                    if (prefs.getBoolean("sound_gear_p_enabled", false)) {
                                        soundFile = prefs.getString("sound_gear_p_file", "gear_p.mp3");
                                        DebugLogger.d(TAG, "Gear P detected, Sound Enabled: " + soundFile);
                                    } else {
                                        DebugLogger.d(TAG, "Gear P detected, Sound Disabled");
                                    }
                                }

                                if (soundFile != null) {
                                    // [限制] 仅在行车状态 (DRIVING) 下播放档位音效
                                    if (mLastIgnition == ISensorEvent.IGNITION_STATE_DRIVING) {
                                        playCustomSound(soundFile);
                                    } else {
                                        DebugLogger.d(TAG, "Skipping gear sound (Ignition not DRIVING): " + soundFile);
                                    }
                                }
                                mLastGear = value;
                            }
                        } else if (sensorType == ISensor.SENSOR_TYPE_DAY_NIGHT) {
                            // Handled by polling
                        }
                    }

                    @Override
                    public void onSensorSupportChanged(int sensorType, com.ecarx.xui.adaptapi.FunctionStatus status) {
                    }
                };

                // Register for Sensors
                iSensor.registerListener(listener, ISensor.SENSOR_TYPE_IGNITION_STATE);
                iSensor.registerListener(listener, ISensor.SENSOR_TYPE_DAY_NIGHT);
                iSensor.registerListener(listener, SENSOR_TYPE_GEAR);
                // Door checking moved to FunctionWatcher
                // iSensor.registerListener(listener, SENSOR_TYPE_DOOR);

                DebugLogger.i(TAG, "Sensor listeners registered (Ignition, DayNight, Gear)");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register sensor listeners", e);
        }
    }

    private void registerFunctionListeners() {
        try {
            if (iCarFunction != null) {
                ICarFunction.IFunctionValueWatcher watcher = new ICarFunction.IFunctionValueWatcher() {
                    @Override
                    public void onFunctionValueChanged(int functionId, int zone, int value) {
                        if (functionId == FUNC_AVM_STATUS) {
                            DebugLogger.d(TAG, "AVM Status Changed: " + value);
                            // Detect AVM Exit (1 -> 0) and force brightness update
                            if (mLastAvmValue == 1 && value == 0) {
                                DebugLogger.i(TAG, "AVM Exit detected. Initiating brightness enforcement burst.");
                                mLastSetBrightness = -1;

                                // Burst retry to ensure we overwrite system restoration
                                mHandler.post(() -> checkAndEnforceBrightness());
                                mHandler.postDelayed(() -> {
                                    mLastSetBrightness = -1;
                                    checkAndEnforceBrightness();
                                }, 500);
                                mHandler.postDelayed(() -> {
                                    mLastSetBrightness = -1;
                                    checkAndEnforceBrightness();
                                }, 1500);
                                mHandler.postDelayed(() -> {
                                    mLastSetBrightness = -1;
                                    checkAndEnforceBrightness();
                                }, 3000);
                            }
                            broadcastSensorValues(mLastDayNightSensorValue,
                                    value, mLastBrightnessDayValue, mLastBrightnessNightValue);
                        } else if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
                            DebugLogger.d(TAG, "Brightness Changed (Int): " + value + " for ID: " + functionId);
                            // Always poll both to ensure consistency and avoid flickering
                            // Always poll both to ensure consistency and avoid flickering
                            pollAndBroadcastBrightness();
                        } else if (functionId == BCM_FUNC_DOOR) {
                            DebugLogger.d(TAG, "Door Function Changed: Zone=" + zone + ", Value=" + value);

                            // Strategy: Use Zone ID to identify door. Value 1 = Open, 0 = Closed.
                            // Current Requirement: Only implement logic for Front Right (Passenger). Others
                            // are just monitored.

                            if (zone == ZONE_DOOR_FR) { // Right Front (Passenger)
                                if (value == 1) { // Open
                                    SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
                                    if (prefs.getBoolean("sound_door_passenger_enabled", false)) {
                                        String soundFile = prefs.getString("sound_door_passenger_file",
                                                "door_passenger.mp3");
                                        DebugLogger.d(TAG, "Passenger Door (Zone 4) Open, Playing sound: " + soundFile);
                                        playCustomSound(soundFile);
                                    } else {
                                        DebugLogger.d(TAG, "Passenger Door (Zone 4) Open, Sound Disabled");
                                    }
                                }
                            } else if (zone == ZONE_DOOR_FL) { // Left Front
                                DebugLogger.d(TAG, "Door FL Event (Reserved): " + value);
                            } else if (zone == ZONE_DOOR_RL) { // Left Rear
                                DebugLogger.d(TAG, "Door RL Event (Reserved): " + value);
                            } else if (zone == ZONE_DOOR_RR) { // Right Rear
                                DebugLogger.d(TAG, "Door RR Event (Reserved): " + value);
                            }
                        } else if (functionId == BCM_FUNC_LIGHT_DIPPED_BEAM) {
                            DebugLogger.d(TAG, "Dipped Beam Changed: " + value);
                            Intent intent = new Intent("cn.navitool.ACTION_HEADLIGHT_STATUS");
                            intent.putExtra("type", "dipped");
                            intent.putExtra("status", value);
                            sendBroadcast(intent);
                        } else if (functionId == BCM_FUNC_LIGHT_MAIN_BEAM) {
                            DebugLogger.d(TAG, "Main Beam Changed: " + value);
                            Intent intent = new Intent("cn.navitool.ACTION_HEADLIGHT_STATUS");
                            intent.putExtra("type", "main");
                            intent.putExtra("status", value);
                            sendBroadcast(intent);
                        } else if (functionId == FUNC_PSD_SCREEN_SWITCH) {
                            DebugLogger.d(TAG, "PSD Screen Status Changed: " + value);
                            broadcastPsdStatus((int) value);

                            if (value == 0) {
                                long now = System.currentTimeMillis();
                                DebugLogger.w(TAG, "WARNING: PSD Turned OFF at " + now);

                                // 1. Immediate Counter-Attack
                                DebugLogger.i(TAG, ">>> IMMEDIATE: Force PSD ON (Reaction to OFF)");
                                setPsdOn();

                                // 2. Schedule 10-Minute Counter-Attack (9m 59s 950ms)
                                schedulePsd10MinCountermeasure();
                            }
                        }
                    }

                    @Override
                    public void onCustomizeFunctionValueChanged(int functionId, int zone, float value) {
                        if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
                            DebugLogger.d(TAG, "Brightness Changed (Float): " + value + " for ID: " + functionId);
                            pollAndBroadcastBrightness();
                        }
                    }

                    @Override
                    public void onFunctionChanged(int functionId) {
                        // Not used
                    }

                    @Override
                    public void onSupportedFunctionStatusChanged(int functionId, int zone,
                            com.ecarx.xui.adaptapi.FunctionStatus status) {
                        // Not used
                    }

                    @Override
                    public void onSupportedFunctionValueChanged(int functionId, int[] values) {
                        // Not used
                    }

                };

                // Removed FUNC_REVERSE_GEAR watcher
                iCarFunction.registerFunctionValueWatcher(FUNC_AVM_STATUS, watcher);
                iCarFunction.registerFunctionValueWatcher(FUNC_BRIGHTNESS_DAY, watcher);
                iCarFunction.registerFunctionValueWatcher(FUNC_BRIGHTNESS_NIGHT, watcher);
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_DOOR, watcher);
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_DIPPED_BEAM, watcher);
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_MAIN_BEAM, watcher);
                // FUNC_DAYMODE_SETTING listener removed as per user request (not supported)

                DebugLogger.i(TAG, "Function watchers registered (AVM, Brightness, Door, Lights)");
            }
        } catch (

        Exception e) {
            DebugLogger.e(TAG, "Failed to register function watchers", e);
        }
    }

    private final BroadcastReceiver configChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_CONFIGURATION_CHANGED.equals(action)) {
                DebugLogger.d(TAG, "Configuration changed, checking day/night status...");
                checkDayNightStatus(false);
            } else if ("cn.navitool.ACTION_REQUEST_ONEOS_STATUS".equals(action)) {
                boolean isConnected = (mOneOSServiceManager != null);
                broadcastOneOSStatus(isConnected);
            }
        }
    };

    private void syncAutoNaviTheme() {
        SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        if (!prefs.getBoolean("auto_theme_sync", true)) {
            DebugLogger.d(TAG, "Auto theme sync is disabled by user.");
            return;
        }

        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        int autoNaviMode = (currentNightMode == Configuration.UI_MODE_NIGHT_YES) ? 2 : 1; // 2: Night, 1: Day

        Intent intent = new Intent("AUTONAVI_STANDARD_BROADCAST_RECV");
        intent.setComponent(
                new ComponentName(AUTONAVI_PKG, "com.autonavi.amapauto.adapter.internal.AmapAutoBroadcastReceiver"));
        intent.putExtra("KEY_TYPE", 10048);
        intent.putExtra("EXTRA_DAY_NIGHT_MODE", autoNaviMode);

        sendBroadcast(intent);
        DebugLogger.d(TAG, "Sent AutoNavi Theme Broadcast: Mode=" + autoNaviMode);
        DebugLogger.toast(this, getString(R.string.sent_autonavi_broadcast, autoNaviMode));
    }

    private void simulateMediaKey(int keyCode) {
        long eventTime = android.os.SystemClock.uptimeMillis();

        // Down
        android.view.KeyEvent keyDown = new android.view.KeyEvent(eventTime, eventTime,
                android.view.KeyEvent.ACTION_DOWN, keyCode, 0);
        dispatchMediaKey(keyDown);

        // Up
        android.view.KeyEvent keyUp = new android.view.KeyEvent(eventTime, eventTime, android.view.KeyEvent.ACTION_UP,
                keyCode, 0);
        dispatchMediaKey(keyUp);

        String keyName = getString(R.string.key_unknown);
        if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_NEXT)
            keyName = getString(R.string.key_next_track);
        else if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS)
            keyName = getString(R.string.key_prev_track);
        else if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
            keyName = getString(R.string.key_play_pause);

        DebugLogger.toast(this, getString(R.string.simulated_media_key, keyName));
    }

    private void dispatchMediaKey(android.view.KeyEvent keyEvent) {
        // Method 1: Dispatch via AudioManager
        android.media.AudioManager audioManager = (android.media.AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.dispatchMediaKeyEvent(keyEvent);
        }

        // Method 2: Send as broadcast (backup)
        Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaIntent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        mediaIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        mediaIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        sendBroadcast(mediaIntent);
    }

    // --- OneOS API Implementation ---

    private com.geely.lib.oneosapi.IServiceManager mOneOSServiceManager;
    private com.geely.lib.oneosapi.input.IInputManager mOneOSInputManager;
    private com.geely.lib.oneosapi.input.IInputListener mOneOSInputListener;
    private int mRetryCount = 0;

    private static final int MAX_RETRIES = 40; // Increased from 10 to 40 for faster polling

    private final ServiceConnection mOneOSConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DebugLogger.i(TAG, "========================");
            DebugLogger.i(TAG, "OneOSApiService Connected!");
            DebugLogger.i(TAG, "ComponentName: " + name);
            DebugLogger.i(TAG, "IBinder: " + service);
            DebugLogger.i(TAG, "========================");
            DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 服务已连接");

            try {
                if (service == null) {
                    DebugLogger.e(TAG, "Service IBinder is NULL!");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS IBinder 为空");
                    return;
                }

                mOneOSServiceManager = com.geely.lib.oneosapi.IServiceManager.Stub.asInterface(service);
                DebugLogger.i(TAG, "IServiceManager.Stub.asInterface called, result: " + mOneOSServiceManager);

                if (mOneOSServiceManager != null) {
                    DebugLogger.i(TAG, "IServiceManager obtained successfully");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "IServiceManager 获取成功");
                    mRetryCount = 0;
                    mOneOSInputManager = null; // Reset
                    // before
                    // trying
                    tryGetInputManager();
                    broadcastOneOSStatus(true);
                } else {
                    DebugLogger.e(TAG, "IServiceManager.Stub.asInterface returned NULL!");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "IServiceManager 为空");
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error in OneOS Service Connected", e);
                DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 连接异常: " + e.getMessage());
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            DebugLogger.i(TAG, "OneOSApiService Disconnected");
            DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 服务断开");
            mOneOSServiceManager = null;
            mOneOSInputManager = null;
            broadcastOneOSStatus(false);
        }
    };

    private void broadcastOneOSStatus(boolean isConnected) {
        Intent intent = new Intent("cn.navitool.ACTION_ONEOS_STATUS");
        intent.putExtra("is_connected", isConnected);
        sendBroadcast(intent);
    }

    private void tryGetInputManager() {
        if (mOneOSServiceManager == null)
            return;
        if (mOneOSInputManager != null)
            return; // Already initialized

        try {
            // Type 8 for InputManager (based on mediacenter analysis)
            DebugLogger.i(TAG, "Calling getService(8) for InputManager...");
            IBinder inputBinder = mOneOSServiceManager.getService(8);
            DebugLogger.i(TAG, "getService(8) returned: " + inputBinder);

            if (inputBinder != null) {
                mOneOSInputManager = com.geely.lib.oneosapi.input.IInputManager.Stub.asInterface(inputBinder);
                DebugLogger.i(TAG, "IInputManager obtained: " + mOneOSInputManager);
                DebugLogger.toast(KeepAliveAccessibilityService.this, "IInputManager 获取成功");

                try {
                    int controllerId = mOneOSInputManager.getControlIndex();
                    DebugLogger.i(TAG, "getControlIndex() returned: " + controllerId);
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "Controller ID: " + controllerId);
                } catch (Exception e) {
                    DebugLogger.w(TAG, "Failed to call getControlIndex(): " + e.getMessage());
                }

                registerOneOSListener();
            } else {
                DebugLogger.e(TAG, "Failed to get InputManager binder (type 8) - returned NULL");
                if (mRetryCount < MAX_RETRIES) {
                    mRetryCount++;
                    DebugLogger.w(TAG, "InputManager not ready, retrying... (" + mRetryCount + ")");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 初始化中... (" + mRetryCount + ")");
                    mHandler.postDelayed(this::tryGetInputManager, 500); // Reduced from 2000ms to 500ms
                } else {
                    DebugLogger.e(TAG, "Failed to get InputManager after max retries");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 初始化失败: 重试超时");
                }
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error getting InputManager", e);
        }
    }

    private void bindOneOSService() {
        try {
            DebugLogger.i(TAG, "========================");
            DebugLogger.i(TAG, "Attempting to bind OneOSApiService...");
            DebugLogger.i(TAG, "========================");

            Intent intent = new Intent();
            intent.setClassName("com.geely.service.oneosapi", "com.geely.service.oneosapi.OneOSApiService");

            DebugLogger.i(TAG, "Intent created: " + intent);
            DebugLogger.i(TAG, "Package: com.geely.service.oneosapi");
            DebugLogger.i(TAG, "Class: com.geely.service.oneosapi.OneOSApiService");

            boolean bound = bindService(intent, mOneOSConnection, Context.BIND_AUTO_CREATE);

            DebugLogger.i(TAG, "bindService() returned: " + bound);

            if (bound) {
                DebugLogger.toast(this, "OneOS 服务绑定成功，等待连接...");
            } else {
                DebugLogger.e(TAG, "bindService() returned FALSE - service not found or permission denied");
                DebugLogger.toast(this, "OneOS 服务绑定失败！");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Exception while binding OneOSApiService", e);
            DebugLogger.toast(this, "OneOS 绑定异常: " + e.getMessage());
        }
    }

    private void registerOneOSListener() {
        DebugLogger.i(TAG, "registerOneOSListener() called, mOneOSInputManager: " + mOneOSInputManager);

        if (mOneOSInputManager == null) {
            DebugLogger.e(TAG, "mOneOSInputManager is NULL, cannot register");
            DebugLogger.toast(this, "IInputManager 为空，无法注册");
            return;
        }

        try {
            int[] keyCodes = {
                    200087, 200088, 200085, 200400 // 媒体按键 + 微信按键
            };

            DebugLogger.i(TAG, "Creating IInputListener stub...");

            if (mOneOSInputListener == null) {
                mOneOSInputListener = new com.geely.lib.oneosapi.input.IInputListener.Stub() {
                    @Override
                    public void onKeyEvent(int keyCode, int event, int keyController) throws RemoteException {
                        int currentIndex = -1;
                        if (mOneOSInputManager != null) {
                            try {
                                currentIndex = mOneOSInputManager.getControlIndex();
                            } catch (Exception e) {
                                DebugLogger.e(TAG, "Failed to get control index in onKeyEvent", e);
                            }
                        }

                        DebugLogger.i(TAG, "OneOS onKeyEvent: keyCode=" + keyCode + ", event=" + event
                                + ", paramKeyController=" + keyController + ", globalControlIndex=" + currentIndex);

                        if (event == 1) { // ACTION_UP
                            // 关键逻辑修改：不再依赖参数 keyController (始终为0)，而是依赖 getControlIndex() (返回2)
                            // 如果全局 Index 为 2，说明处于媒体控制模式，此时处理按键是安全的
                            if (currentIndex == 2) {
                                if (keyCode == 200087 || keyCode == 200088 || keyCode == 200085) {
                                    handleShortClick(keyCode);
                                }
                            } else {
                                DebugLogger.w(TAG, "Ignored media key because globalControlIndex is " + currentIndex
                                        + " (expected 2)");
                            }
                        }
                    }

                    @Override
                    public void onShortClick(int keyCode, int keyController) throws RemoteException {
                        DebugLogger.i(TAG,
                                "OneOS onShortClick: keyCode=" + keyCode + ", keyController=" + keyController);
                        // 只处理微信按键，媒体按键已由 onKeyEvent 处理
                        if (keyCode == 200400) {
                            DebugLogger.toast(KeepAliveAccessibilityService.this, "微信按键短按");
                            handleShortClick(keyCode);
                        }
                    }

                    @Override
                    public void onHoldingPressStarted(int keyCode, int keyController) throws RemoteException {
                        DebugLogger.i(TAG, "OneOS onHoldingPressStarted: keyCode=" + keyCode);
                    }

                    @Override
                    public void onHoldingPressStopped(int keyCode, int keyController) throws RemoteException {
                        DebugLogger.i(TAG, "OneOS onHoldingPressStopped: keyCode=" + keyCode);
                    }

                    @Override
                    public void onLongPressTriggered(int keyCode, int keyController) throws RemoteException {
                        DebugLogger.i(TAG,
                                "OneOS onLongPressTriggered: keyCode=" + keyCode + ", keyController=" + keyController);
                        // 只处理微信按键
                        if (keyCode == 200400) {
                            DebugLogger.toast(KeepAliveAccessibilityService.this, "微信按键长按");
                            handleLongPress(keyCode);
                        }
                    }

                    @Override
                    public void onDoubleClick(int keyCode, int keyController) throws RemoteException {
                        DebugLogger.i(TAG, "OneOS onDoubleClick: keyCode=" + keyCode);
                    }
                };
            }

            DebugLogger.i(TAG, "Registering listener: " + mOneOSInputListener);

            String packageName = getPackageName();
            DebugLogger.i(TAG, "Package name: " + packageName);
            DebugLogger.i(TAG, "Key codes to register: " + java.util.Arrays.toString(keyCodes));

            mOneOSInputManager.registerListener(mOneOSInputListener, packageName, keyCodes);

            DebugLogger.i(TAG, "registerListener() COMPLETED SUCCESSFULLY!");

            DebugLogger.toast(this, "OneOS 监听已注册");

        } catch (Exception e) {
            DebugLogger.e(TAG, "OneOS 注册失败: " + e.getMessage());
            DebugLogger.toast(this, "OneOS 注册失败: " + e.getMessage());
        }
    }

    private void playCustomSound(String filename) {
        SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        // Master Switch Check
        if (!prefs.getBoolean("sound_master_enabled", true)) {
            DebugLogger.d(TAG, "Master sound switch disabled, skipping playback: " + filename);
            return;
        }

        try {
            if (mMediaPlayer != null) {
                mMediaPlayer.release();
                mMediaPlayer = null;
            }
            java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory(),
                    "NaviTool/Sound/" + filename);
            if (file.exists()) {
                // Request Audio Focus
                android.media.AudioManager am = (android.media.AudioManager) getSystemService(Context.AUDIO_SERVICE);
                android.media.AudioFocusRequest focusRequest = null;
                android.media.AudioManager.OnAudioFocusChangeListener focusListener = f -> {
                };

                if (am != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        android.media.AudioAttributes playbackAttributes = new android.media.AudioAttributes.Builder()
                                .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
                                .setContentType(android.media.AudioAttributes.CONTENT_TYPE_SPEECH)
                                .build();
                        focusRequest = new android.media.AudioFocusRequest.Builder(
                                android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                                .setAudioAttributes(playbackAttributes)
                                .setAcceptsDelayedFocusGain(false)
                                .setOnAudioFocusChangeListener(focusListener)
                                .build();
                        am.requestAudioFocus(focusRequest);
                    } else {
                        am.requestAudioFocus(focusListener, android.media.AudioManager.STREAM_MUSIC,
                                android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    }
                }

                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setDataSource(file.getAbsolutePath());
                mMediaPlayer.prepare();
                mMediaPlayer.start();
                DebugLogger.d(TAG, "Playing sound: " + filename);

                final android.media.AudioFocusRequest finalRequest = focusRequest;
                final android.media.AudioManager.OnAudioFocusChangeListener finalListener = focusListener;

                mMediaPlayer.setOnCompletionListener(mp -> {
                    mp.release();
                    mMediaPlayer = null;
                    DebugLogger.d(TAG, "Sound playback completed: " + filename);
                    // Abandon Focus
                    if (am != null) {
                        try {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && finalRequest != null) {
                                int result = am.abandonAudioFocusRequest(finalRequest);
                                DebugLogger.d(TAG, "abandonAudioFocusRequest result=" + result);
                            } else {
                                int result = am.abandonAudioFocus(finalListener);
                                DebugLogger.d(TAG, "abandonAudioFocus result=" + result);
                            }
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Failed to abandon audio focus", e);
                        }
                    }
                });

                mMediaPlayer.setOnErrorListener((mp, what, extra) -> {
                    DebugLogger.e(TAG, "MediaPlayer Error: what=" + what + ", extra=" + extra);
                    mp.release();
                    mMediaPlayer = null;
                    // Abandon Focus on Error
                    if (am != null) {
                        try {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && finalRequest != null) {
                                am.abandonAudioFocusRequest(finalRequest);
                            } else {
                                am.abandonAudioFocus(finalListener);
                            }
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Failed to abandon audio focus on error", e);
                        }
                    }
                    return true;
                });

            } else {
                DebugLogger.w(TAG, "Sound file not found: " + filename);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to play sound: " + filename, e);
        }
    }

}
