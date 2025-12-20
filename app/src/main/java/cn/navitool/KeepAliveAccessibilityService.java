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
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;

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

    // Brightness Polling
    private boolean mIsOverrideEnabled = false;
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
                    // Force PSD ON (1)
                    iCarFunction.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 1);
                    Log.d(TAG, "Enforced PSD Screen ON");
                } catch (Exception e) {
                    Log.e(TAG, "Failed to enforce PSD Screen ON", e);
                }
            }
            // 10s interval
            mPsdHandler.postDelayed(this, 10000);
        }
    };

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
                mPsdHandler.post(mPsdRunnable); // Start immediately
            } else {
                mPsdHandler.removeCallbacks(mPsdRunnable);
                // Optional: Turn off when disabled? User didn't specify, but safer to just stop
                // enforcing.
                // If user wants to turn it off, they might need manual control or it just
                // reverts to system behavior.
                // For now, let's just stop enforcing.
                // Actually, if I toggle it OFF, I should probably send a 0?
                // "开关开启后...常开". Implies switch OFF = Not always on (or OFF).
                // Let's send 0 once to be responsive.
                if (iCarFunction != null) {
                    try {
                        iCarFunction.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 0);
                    } catch (Exception e) {
                    }
                }
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service Created");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.i(TAG, "Service Connected");

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
        }

        // Bind OneOS Service
        bindOneOSService();

        // Log boot event (with cooldown check)
        DebugLogger.logBootEvent(this);

        // Register receiver for config changes
        Log.i(TAG, "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        // Register receiver for config changes
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        filter.addAction("cn.navitool.ACTION_REQUEST_ONEOS_STATUS");
        try {
            ContextCompat.registerReceiver(this, configChangeReceiver, filter, ContextCompat.RECEIVER_EXPORTED);
        } catch (Exception e) {
            Log.e(TAG, "Failed to register configChangeReceiver with EXPORTED flag. Retrying without flag...", e);
            try {
                registerReceiver(configChangeReceiver, filter);
            } catch (Exception ex) {
                Log.e(TAG, "Failed to register configChangeReceiver fallback", ex);
            }
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroying, cleaning up resources...");
        stopMonitoring();
        mOverrideHandler.removeCallbacks(mOverrideRunnable);
        mPsdHandler.removeCallbacks(mPsdRunnable);

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.unregisterOnSharedPreferenceChangeListener(prefsListener);

        try {
            unregisterReceiver(configChangeReceiver);
            Log.d(TAG, "Unregistered config change receiver");
        } catch (Exception e) {
            // Ignore
        }

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            CharSequence packageName = event.getPackageName();
            if (packageName != null && AUTONAVI_PKG.equals(packageName.toString())) {
                Log.d(TAG, "AutoNavi detected in foreground. Syncing theme...");
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
        Log.d(TAG, "onConfigurationChanged called.");
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
    private static final int ZONE_PSD = 4; // Passenger Screen Zone ID
    private static final int VALUE_DAYMODE_DAY = 0x20150101;
    private static final int VALUE_DAYMODE_NIGHT = 0x20150102;
    private static final int VALUE_DAYMODE_AUTO = 0x20150103;
    private static final int VALUE_DAYMODE_CUSTOM = 0x20150104;
    private static final int VALUE_DAYMODE_SUNRISE_AND_SUNSET = 0x20150105;

    // 24-25 Model Light Sensor (Found in ISensor.java)
    // SENSOR_TYPE_LIGHT = 2100992 (0x200F00)
    private static final int SENSOR_TYPE_LIGHT = 0x200F00;

    private final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private boolean mIsMonitoring = false;
    private static final long MONITOR_INTERVAL_MS = 1000; // Updated to 1s (User Request)

    private final Runnable mMonitorRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsMonitoring)
                return;
            checkAndForceAutoDayNight();
            mHandler.postDelayed(this, 1000); // 1s Interval
        }
    };

    private void startMonitoring() {
        if (mIsMonitoring)
            return;
        mIsMonitoring = true;
        mHandler.post(mMonitorRunnable);
        Log.i(TAG, "Started Day/Night mode monitoring");
    }

    private void stopMonitoring() {
        mIsMonitoring = false;
        mHandler.removeCallbacks(mMonitorRunnable);
        Log.i(TAG, "Stopped Day/Night mode monitoring");
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
                Log.d(TAG, "Polled Brightness Changed - Day: " + mLastBrightnessDayValue + ", Night: "
                        + mLastBrightnessNightValue);
                broadcastSensorValues(mLastDayNightSensorValue,
                        mLastAvmValue, mLastBrightnessDayValue, mLastBrightnessNightValue);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error polling brightness", e);
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
                        Log.w(TAG, "Failed to poll initial function values: " + e.getMessage());
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
                            Log.i(TAG, "Detected non-Auto mode: " + Integer.toHexString(currentMode)
                                    + ". Forcing AUTO...");
                            boolean success = iCarFunction.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL,
                                    VALUE_DAYMODE_AUTO);
                            if (success) {
                                DebugLogger.toast(this, "已强制恢复为自动模式");
                                // Broadcast update immediately
                                intent.putExtra("mode", VALUE_DAYMODE_AUTO);
                                sendBroadcast(intent);
                            } else {
                                Log.e(TAG, "Failed to set Day/Night mode to AUTO");
                            }
                        }
                    }

                    // Check 24-25 Model Light Sensor Logic (in background)
                    check2425LightSensorLogic();
                } catch (Exception e) {
                    Log.e(TAG, "Error checking/setting Day/Night mode", e);
                }
            }
        }).start();

    }

    private void handleShortClick(int keyCode) {
        Log.i(TAG, "handleShortClick: " + keyCode);

        if (keyCode == 200087 || keyCode == 200088 || keyCode == 200085) {
            SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
            boolean enabled = prefs.getBoolean("steering_wheel_control", false);
            if (!enabled) {
                Log.d(TAG, "Steering wheel control disabled, skipping media key");
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
                Log.d(TAG, "Unhandled short click key code: " + keyCode);
                break;
        }
    }

    private void handleLongPress(int keyCode) {
        Log.i(TAG, "handleLongPress: " + keyCode);
        switch (keyCode) {
            // case 200087: // R_MEDIA_NEXT - 长按下一曲（快进）
            // Log.i(TAG, "Long press NEXT - fast forward");
            // break;
            // case 200088: // R_MEDIA_PREVIOUS - 长按上一曲（快退）
            // Log.i(TAG, "Long press PREVIOUS - rewind");
            // break;
            // case 200085: // R_MEDIA_PLAY_PAUSE - 长按播放/暂停
            // Log.i(TAG, "Long press PLAY_PAUSE");
            // break;
            case 200400: // R_WECHAT - 长按微信按键
                handleWechatLongPress();
                break;
            default:
                Log.d(TAG, "Unhandled long press key code: " + keyCode);
                break;
        }
    }

    private void handleWechatShortPress() {
        SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean enabled = prefs.getBoolean("wechat_button_enabled", false);
        if (!enabled) {
            Log.d(TAG, "WeChat button function disabled");
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
            Log.d(TAG, "WeChat button function disabled");
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
                Log.i(TAG, "Launched app: " + packageName);
                DebugLogger.toast(this, "正在启动: " + packageName);
            } else {
                Log.e(TAG, "Could not find launch intent for " + packageName);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error launching app " + packageName, e);
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
                    Log.i(TAG, "24-25 Logic: Sensor is NIGHT. Switching Theme to NIGHT.");
                    iCarFunction.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL, VALUE_DAYMODE_NIGHT);
                }
            } else if (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_DAY) {
                // Sensor says Day -> Set Day Mode
                if (currentMode != VALUE_DAYMODE_DAY) {
                    Log.i(TAG, "24-25 Logic: Sensor is DAY. Switching Theme to DAY.");
                    iCarFunction.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL, VALUE_DAYMODE_DAY);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in 24-25 Light Sensor Logic", e);
        }
    }

    private void checkAndEnforceBrightness() {
        if (!mIsOverrideEnabled || iCarFunction == null)
            return;

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
                Log.i(TAG, "Enforcing Unified Brightness. Target: " + targetValue + " Current: " + currentKnownValue);
                try {
                    // 1. Unified Backlight Control (Instrument Cluster)
                    iCarFunction.setCustomizeFunctionValue(FUNC_BRIGHTNESS_BACKLIGHT, ZONE_ALL, (float) targetValue);

                    // 2. CSD Control (Central Screen) - Restored
                    iCarFunction.setCustomizeFunctionValue(funcId, zone, (float) targetValue);

                    // 3. PSD Sync (Passenger Screen) - Restored
                    try {
                        iCarFunction.setCustomizeFunctionValue(funcId, ZONE_PSD, (float) targetValue);
                    } catch (Exception e) {
                        // ignore
                    }

                    // 4. Update Local Cache
                    mLastSetBrightness = targetValue;
                    if (funcId == FUNC_BRIGHTNESS_DAY)
                        mLastBrightnessDayValue = targetValue;
                    else
                        mLastBrightnessNightValue = targetValue;

                } catch (Exception e) {
                    Log.e(TAG, "Failed to set unified brightness", e);
                }
            }
        }

        // Sync Dashboard (DIM) Brightness - Removed per user request

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
                        Log.w(TAG, "getSensorManager not found via reflection");
                    }

                    Log.i(TAG, "Car AdaptAPI initialized successfully");

                    if (iSensor != null) {
                        registerSensorListeners();
                    }
                    if (iCarFunction != null) {
                        registerFunctionListeners();
                    }
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "Failed to initialize Car AdaptAPI: " + e.getMessage());
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
                            Log.d(TAG, "Ignition State Changed (float): " + val);
                            if (val == ISensorEvent.IGNITION_STATE_DRIVING) {
                                Log.i(TAG, "Ignition State: DRIVING");
                                DebugLogger.toast(KeepAliveAccessibilityService.this, "检测到行车状态");
                                AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);
                            }

                        }
                    }

                    @Override
                    public void onSensorEventChanged(int sensorType, int value) {
                        if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
                            Log.d(TAG, "Ignition State Changed (int): " + value);
                            if (value == ISensorEvent.IGNITION_STATE_DRIVING) {
                                Log.i(TAG, "Ignition State: DRIVING");
                                DebugLogger.toast(KeepAliveAccessibilityService.this, "检测到行车状态");
                                AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);
                            }
                        } else if (sensorType == ISensor.SENSOR_TYPE_DAY_NIGHT) {
                            // Passive listener removed in favor of polling to ensure data consistency
                            // Log.d(TAG, "Day/Night Sensor Changed (int): " + value);
                            // mLastDayNightSensorValue = value;
                            // check2425LightSensorLogic();
                        }
                    }

                    @Override
                    public void onSensorSupportChanged(int sensorType, com.ecarx.xui.adaptapi.FunctionStatus status) {
                    }
                };

                // Register for Ignition
                iSensor.registerListener(listener, ISensor.SENSOR_TYPE_IGNITION_STATE);

                // Register for Day/Night Sensor (Restored per user request)
                iSensor.registerListener(listener, ISensor.SENSOR_TYPE_DAY_NIGHT);

                Log.i(TAG, "Sensor listeners registered (Ignition, DayNight 0x100900)");
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to register sensor listeners", e);
        }
    }

    private void registerFunctionListeners() {
        try {
            if (iCarFunction != null) {
                ICarFunction.IFunctionValueWatcher watcher = new ICarFunction.IFunctionValueWatcher() {
                    @Override
                    public void onFunctionValueChanged(int functionId, int zone, int value) {
                        if (functionId == FUNC_AVM_STATUS) {
                            Log.d(TAG, "AVM Status Changed: " + value);
                            broadcastSensorValues(mLastDayNightSensorValue,
                                    value, mLastBrightnessDayValue, mLastBrightnessNightValue);
                        } else if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
                            Log.d(TAG, "Brightness Changed (Int): " + value + " for ID: " + functionId);
                            // Always poll both to ensure consistency and avoid flickering
                            pollAndBroadcastBrightness();
                        }
                    }

                    @Override
                    public void onCustomizeFunctionValueChanged(int functionId, int zone, float value) {
                        if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
                            Log.d(TAG, "Brightness Changed (Float): " + value + " for ID: " + functionId);
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
                // FUNC_DAYMODE_SETTING listener removed as per user request (not supported)

                Log.i(TAG, "Function watchers registered (AVM, Brightness)");
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to register function watchers", e);
        }
    }

    private final BroadcastReceiver configChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_CONFIGURATION_CHANGED.equals(action)) {
                Log.d(TAG, "Configuration changed, checking day/night status...");
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
            Log.d(TAG, "Auto theme sync is disabled by user.");
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
        Log.d(TAG, "Sent AutoNavi Theme Broadcast: Mode=" + autoNaviMode);
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
            Log.i(TAG, "========================");
            Log.i(TAG, "OneOSApiService Connected!");
            Log.i(TAG, "ComponentName: " + name);
            Log.i(TAG, "IBinder: " + service);
            Log.i(TAG, "========================");
            DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 服务已连接");

            try {
                if (service == null) {
                    Log.e(TAG, "Service IBinder is NULL!");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS IBinder 为空");
                    return;
                }

                mOneOSServiceManager = com.geely.lib.oneosapi.IServiceManager.Stub.asInterface(service);
                Log.i(TAG, "IServiceManager.Stub.asInterface called, result: " + mOneOSServiceManager);

                if (mOneOSServiceManager != null) {
                    Log.i(TAG, "IServiceManager obtained successfully");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "IServiceManager 获取成功");
                    mRetryCount = 0;
                    mOneOSInputManager = null; // Reset
                    // before
                    // trying
                    tryGetInputManager();
                    broadcastOneOSStatus(true);
                } else {
                    Log.e(TAG, "IServiceManager.Stub.asInterface returned NULL!");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "IServiceManager 为空");
                }
            } catch (Exception e) {
                Log.e(TAG, "Error in OneOS Service Connected", e);
                DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 连接异常: " + e.getMessage());
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "OneOSApiService Disconnected");
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
            Log.i(TAG, "Calling getService(8) for InputManager...");
            IBinder inputBinder = mOneOSServiceManager.getService(8);
            Log.i(TAG, "getService(8) returned: " + inputBinder);

            if (inputBinder != null) {
                mOneOSInputManager = com.geely.lib.oneosapi.input.IInputManager.Stub.asInterface(inputBinder);
                Log.i(TAG, "IInputManager obtained: " + mOneOSInputManager);
                DebugLogger.toast(KeepAliveAccessibilityService.this, "IInputManager 获取成功");

                try {
                    int controllerId = mOneOSInputManager.getControlIndex();
                    Log.i(TAG, "getControlIndex() returned: " + controllerId);
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "Controller ID: " + controllerId);
                } catch (Exception e) {
                    Log.w(TAG, "Failed to call getControlIndex(): " + e.getMessage());
                }

                registerOneOSListener();
            } else {
                Log.e(TAG, "Failed to get InputManager binder (type 8) - returned NULL");
                if (mRetryCount < MAX_RETRIES) {
                    mRetryCount++;
                    Log.w(TAG, "InputManager not ready, retrying... (" + mRetryCount + ")");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 初始化中... (" + mRetryCount + ")");
                    mHandler.postDelayed(this::tryGetInputManager, 500); // Reduced from 2000ms to 500ms
                } else {
                    Log.e(TAG, "Failed to get InputManager after max retries");
                    DebugLogger.toast(KeepAliveAccessibilityService.this, "OneOS 初始化失败: 重试超时");
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error getting InputManager", e);
        }
    }

    private void bindOneOSService() {
        try {
            Log.i(TAG, "========================");
            Log.i(TAG, "Attempting to bind OneOSApiService...");
            Log.i(TAG, "========================");

            Intent intent = new Intent();
            intent.setClassName("com.geely.service.oneosapi", "com.geely.service.oneosapi.OneOSApiService");

            Log.i(TAG, "Intent created: " + intent);
            Log.i(TAG, "Package: com.geely.service.oneosapi");
            Log.i(TAG, "Class: com.geely.service.oneosapi.OneOSApiService");

            boolean bound = bindService(intent, mOneOSConnection, Context.BIND_AUTO_CREATE);

            Log.i(TAG, "bindService() returned: " + bound);

            if (bound) {
                DebugLogger.toast(this, "OneOS 服务绑定成功，等待连接...");
            } else {
                Log.e(TAG, "bindService() returned FALSE - service not found or permission denied");
                DebugLogger.toast(this, "OneOS 服务绑定失败！");
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception while binding OneOSApiService", e);
            DebugLogger.toast(this, "OneOS 绑定异常: " + e.getMessage());
        }
    }

    private void registerOneOSListener() {
        Log.i(TAG, "registerOneOSListener() called, mOneOSInputManager: " + mOneOSInputManager);

        if (mOneOSInputManager == null) {
            Log.e(TAG, "mOneOSInputManager is NULL, cannot register");
            DebugLogger.toast(this, "IInputManager 为空，无法注册");
            return;
        }

        try {
            int[] keyCodes = {
                    200087, 200088, 200085, 200400 // 媒体按键 + 微信按键
            };

            Log.i(TAG, "Creating IInputListener stub...");

            if (mOneOSInputListener == null) {
                mOneOSInputListener = new com.geely.lib.oneosapi.input.IInputListener.Stub() {
                    @Override
                    public void onKeyEvent(int keyCode, int event, int keyController) throws RemoteException {
                        int currentIndex = -1;
                        if (mOneOSInputManager != null) {
                            try {
                                currentIndex = mOneOSInputManager.getControlIndex();
                            } catch (Exception e) {
                                Log.e(TAG, "Failed to get control index in onKeyEvent", e);
                            }
                        }

                        Log.i(TAG, "OneOS onKeyEvent: keyCode=" + keyCode + ", event=" + event
                                + ", paramKeyController=" + keyController + ", globalControlIndex=" + currentIndex);

                        if (event == 1) { // ACTION_UP
                            // 关键逻辑修改：不再依赖参数 keyController (始终为0)，而是依赖 getControlIndex() (返回2)
                            // 如果全局 Index 为 2，说明处于媒体控制模式，此时处理按键是安全的
                            if (currentIndex == 2) {
                                if (keyCode == 200087 || keyCode == 200088 || keyCode == 200085) {
                                    handleShortClick(keyCode);
                                }
                            } else {
                                Log.w(TAG, "Ignored media key because globalControlIndex is " + currentIndex
                                        + " (expected 2)");
                            }
                        }
                    }

                    @Override
                    public void onShortClick(int keyCode, int keyController) throws RemoteException {
                        Log.i(TAG, "OneOS onShortClick: keyCode=" + keyCode + ", keyController=" + keyController);
                        // 只处理微信按键，媒体按键已由 onKeyEvent 处理
                        if (keyCode == 200400) {
                            DebugLogger.toast(KeepAliveAccessibilityService.this, "微信按键短按");
                            handleShortClick(keyCode);
                        }
                    }

                    @Override
                    public void onHoldingPressStarted(int keyCode, int keyController) throws RemoteException {
                        Log.i(TAG, "OneOS onHoldingPressStarted: keyCode=" + keyCode);
                    }

                    @Override
                    public void onHoldingPressStopped(int keyCode, int keyController) throws RemoteException {
                        Log.i(TAG, "OneOS onHoldingPressStopped: keyCode=" + keyCode);
                    }

                    @Override
                    public void onLongPressTriggered(int keyCode, int keyController) throws RemoteException {
                        Log.i(TAG,
                                "OneOS onLongPressTriggered: keyCode=" + keyCode + ", keyController=" + keyController);
                        // 只处理微信按键
                        if (keyCode == 200400) {
                            DebugLogger.toast(KeepAliveAccessibilityService.this, "微信按键长按");
                            handleLongPress(keyCode);
                        }
                    }

                    @Override
                    public void onDoubleClick(int keyCode, int keyController) throws RemoteException {
                        Log.i(TAG, "OneOS onDoubleClick: keyCode=" + keyCode);
                    }
                };
            }

            Log.i(TAG, "Registering listener: " + mOneOSInputListener);

            String packageName = getPackageName();
            Log.i(TAG, "Package name: " + packageName);
            Log.i(TAG, "Key codes to register: " + java.util.Arrays.toString(keyCodes));

            mOneOSInputManager.registerListener(mOneOSInputListener, packageName, keyCodes);

            Log.i(TAG, "registerListener() COMPLETED SUCCESSFULLY!");

            DebugLogger.toast(this, "OneOS 监听已注册");

        } catch (Exception e) {
            Log.e(TAG, "OneOS 注册失败: " + e.getMessage());
            DebugLogger.toast(this, "OneOS 注册失败: " + e.getMessage());
        }
    }
}