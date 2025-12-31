package cn.navitool;

import android.accessibilityservice.AccessibilityService;
import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;

import android.content.res.Configuration;
import android.os.Build;

import android.os.PowerManager;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
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
import cn.navitool.managers.AppLaunchManager;

public class KeepAliveAccessibilityService extends AccessibilityService {

    private static final String TAG = "KeepAliveService";
    private static final String AUTONAVI_PKG = "com.autonavi.amapauto";

    private ICarFunction iCarFunction;

    private ISensor iSensor;

    private final SharedPreferences.OnSharedPreferenceChangeListener prefsListener = (sharedPreferences, key) -> {
        if ("force_auto_day_night".equals(key) || "enable_24_25_light_sensor".equals(key)) {
            cn.navitool.managers.ThemeBrightnessManager.getInstance(this).checkMonitoringRequirement();
        } else if ("adb_wireless_enabled".equals(key)) {
            if (sharedPreferences.getBoolean(key, false)) {
                AdbShell.getInstance(KeepAliveAccessibilityService.this).connect();
            } else {
                AdbShell.getInstance(KeepAliveAccessibilityService.this).close();
            }
        } else if ("override_brightness_enabled".equals(key)) {
            boolean enabled = sharedPreferences.getBoolean(key, false);
            cn.navitool.managers.ThemeBrightnessManager.getInstance(this).setOverrideEnabled(enabled);
        } else if ("override_day_value".equals(key) || "override_night_value".equals(key)
                || "override_avm_value".equals(key)) {
            int d = sharedPreferences.getInt("override_day_value", 12);
            int n = sharedPreferences.getInt("override_night_value", 5);
            int a = sharedPreferences.getInt("override_avm_value", 15);
            cn.navitool.managers.ThemeBrightnessManager.getInstance(this).setTargetBrightness(d, n, a);
        } else if ("psd_always_on_enabled".equals(key)) {
            boolean enabled = sharedPreferences.getBoolean(key, false);
            cn.navitool.managers.PsdManager.getInstance(KeepAliveAccessibilityService.this).setEnabled(enabled);
        } else if ("psd_always_on_method2_enabled".equals(key)) {
            boolean enabled = sharedPreferences.getBoolean(key, false);
            cn.navitool.managers.PsdManager.getInstance(KeepAliveAccessibilityService.this).setEnabledMethod2(enabled);
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
        cn.navitool.managers.PsdManager.getInstance(this).init();

        // 启动 OneOS 服务 (方控/微信按键) - 必须在 onCreate 调用以确保最快绑定
        cn.navitool.managers.KeyHandlerManager.getInstance(this).init();

        // [新增] 初始化车辆控制接口 (监听发动机、档位、车门等)
        initCar();
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        DebugLogger.init(this); // Initialize DebugLogger
        ConfigManager.init(this); // Initialize ConfigManager (Syncs Prefs)
        DebugLogger.i(TAG, "Service Connected");

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.registerOnSharedPreferenceChangeListener(prefsListener);

        // Initialize ThemeBrightnessManager
        cn.navitool.managers.ThemeBrightnessManager.getInstance(this).init();
        cn.navitool.managers.SoundPromptManager.getInstance(this).init();
        cn.navitool.managers.KeyHandlerManager.getInstance(this).init();

        // Initialize PSD
        boolean mIsPsdAlwaysOnEnabled = ConfigManager.getInstance().getBoolean("psd_always_on_enabled", false);
        if (mIsPsdAlwaysOnEnabled) {
            cn.navitool.managers.PsdManager.getInstance(this).setEnabled(true);
        }
        boolean mIsMethod2Enabled = ConfigManager.getInstance().getBoolean("psd_always_on_method2_enabled", false);
        if (mIsMethod2Enabled) {
            cn.navitool.managers.PsdManager.getInstance(this).setEnabledMethod2(true);
        }

        // Initialize ADB Loopback if enabled
        if (ConfigManager.getInstance().getBoolean("adb_wireless_enabled", false)) {
            AdbShell.getInstance(this).connect();
        }

        // Log boot event (with cooldown check)
        DebugLogger.logBootEvent(this);

        // Register receiver for config changes
        DebugLogger.i(TAG, "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        // Register receiver for config changes
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        filter.addAction("cn.navitool.ACTION_REQUEST_ONEOS_STATUS");
        filter.addAction("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
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
        cn.navitool.managers.ThemeBrightnessManager.getInstance(this).destroy();
        cn.navitool.managers.SoundPromptManager.getInstance(this).destroy();
        cn.navitool.managers.KeyHandlerManager.getInstance(this).destroy();
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
                cn.navitool.managers.ThemeBrightnessManager.getInstance(this).syncAutoNaviTheme();
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
        cn.navitool.managers.ThemeBrightnessManager.getInstance(this).syncAutoNaviTheme();
    }

    // Day/Night Mode Constants
    private static final int FUNC_DAYMODE_SETTING = 0x20150100;
    // Removed local SENSOR_TYPE_DAY_NIGHT, using ISensor.SENSOR_TYPE_DAY_NIGHT
    // Restored Constants
    private static final int FUNC_PSD_SCREEN_SWITCH = 539495936; // SETTING_FUNC_PSD_SCREEN_SWITCH
    private static final int FUNC_AVM_STATUS = IPAS.PAS_FUNC_PAC_ACTIVATION;
    private static final int FUNC_BRIGHTNESS_DAY = IVehicle.SETTING_FUNC_BRIGHTNESS_DAY;
    private static final int FUNC_BRIGHTNESS_NIGHT = IVehicle.SETTING_FUNC_BRIGHTNESS_NIGHT;
    private static final int FUNC_BRIGHTNESS_DIM = 687998208; // SETTING_FUNC_BRIGHTNESS_DIM
    private static final int FUNC_BRIGHTNESS_BACKLIGHT = 687997184; // Unified Vehicle Brightness

    private static final int ZONE_ALL = 0x80000000;
    private static final int ZONE_CSD = 1; // Central Screen
    private static final int ZONE_PSD = 4; // Passenger Screen
    private static final int ZONE_PSD_FUNC = 4; // Passenger Screen Zone ID

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

    // Door Zones
    private static final int ZONE_DOOR_FL = 1; // Front Left
    private static final int ZONE_DOOR_FR = 4; // Front Right
    private static final int ZONE_DOOR_RL = 16; // Rear Left
    private static final int ZONE_DOOR_RR = 64; // Rear Right

    // Constants for Listeners

    // user log confirms 0x21051100 is Left Turn Signal
    private static final int BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL = 0x21051100; // 553976320
    private static final int BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL = 0x21051200; // 553976576
    // private static final int BCM_FUNC_LIGHT_MAIN_BEAM = 553976320; // 0x21051100
    // (CONFLICT - Commented out)

    // Sound Prompt States
    private int mLastIgnition = -1;
    private int mLastGear = -1;
    private int mLastDoor = -1;

    // --- Car AdaptAPI Implementation ---

    private void initCar() {
        cn.navitool.managers.CarServiceManager manager = cn.navitool.managers.CarServiceManager.getInstance(this);
        manager.init();

        this.iCarFunction = manager.getCarFunction();
        this.iSensor = manager.getSensor();

        if (this.iCarFunction == null || this.iSensor == null) {
            DebugLogger.w(TAG, "Car Service not ready yet. Retrying in 3s...");
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(this::initCar, 3000);
            return;
        }

        DebugLogger.i(TAG, "Car Service Initialized Successfully.");

        if (iSensor != null) {
            registerSensorListeners();
        }
        if (iCarFunction != null) {
            registerFunctionListeners();
        }
    }

    private void registerSensorListeners() {
        try {
            if (iSensor != null) {
                ISensor.ISensorListener listener = new ISensor.ISensorListener() {
                    @Override
                    public void onSensorValueChanged(int sensorType, float value) {
                        try {
                            if (sensorType == SENSOR_TYPE_LIGHT) {
                                cn.navitool.managers.ThemeBrightnessManager
                                        .getInstance(KeepAliveAccessibilityService.this)
                                        .onSensorChanged(sensorType, value);
                            }
                            // Some cars might report Ignition as float? keeping checking just in case
                            // But primary should be EventChanged (int)
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Error in onSensorValueChanged", e);
                        }
                    }

                    @Override
                    public void onSensorEventChanged(int sensorType, int value) {
                        try {
                            if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
                                DebugLogger.d(TAG, "Ignition State Changed (int): " + value);
                                mLastIgnition = value;

                                // User Request: Only trigger on DRIVING (6)
                                if (value == 6) { // IGNITION_STATE_DRIVING
                                    DebugLogger.i(TAG,
                                            "Ignition DRIVING (6) detected - Triggering Auto Start Sequence");
                                    triggerAutoStart(); // Extracted method
                                }
                            } else if (sensorType == SENSOR_TYPE_GEAR) {
                                DebugLogger.d(TAG, "Gear Changed (int): " + value);
                                if (mLastGear != value) {
                                    cn.navitool.managers.SoundPromptManager
                                            .getInstance(KeepAliveAccessibilityService.this)
                                            .playGearSound(value);
                                    mLastGear = value;
                                }
                            } else if (sensorType == ISensor.SENSOR_TYPE_DAY_NIGHT) {
                                cn.navitool.managers.ThemeBrightnessManager
                                        .getInstance(KeepAliveAccessibilityService.this)
                                        .onSensorEventChanged(sensorType, value);
                            }
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Error in onSensorEventChanged", e);
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
                iSensor.registerListener(listener, SENSOR_TYPE_LIGHT);

                DebugLogger.i(TAG, "Sensor listeners registered (Ignition, DayNight, Gear, Light)");

                // [Auto Start Fix] Poll Ignition immediately in case we missed the event
                try {
                    int currentIgnition = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_IGNITION_STATE);
                    DebugLogger.i(TAG, "Initial Ignition Poll: " + currentIgnition);
                    if (currentIgnition == 6 || currentIgnition == 4) { // 6=Driving, 4=On (Assumption, user focused on
                                                                        // 6)
                        DebugLogger.i(TAG, "Ignition already ON/DRIVING. Triggering Auto Start...");
                        triggerAutoStart();
                    }
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Failed to poll initial ignition state", e);
                }

            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register sensor listeners", e);
        }
    }

    private void triggerAutoStart() {
        // 1. Repair Permissions (Fixes Auto Repair bug)
        checkAndRepairPermissions();

        // 2. Launch Apps
        AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);

        // 3. Play Sound
        cn.navitool.managers.SoundPromptManager
                .getInstance(KeepAliveAccessibilityService.this)
                .playStartSound();
    }

    private void registerFunctionListeners() {
        try {
            if (iCarFunction != null) {
                ICarFunction.IFunctionValueWatcher watcher = new ICarFunction.IFunctionValueWatcher() {
                    @Override
                    public void onFunctionValueChanged(int functionId, int zone, int value) {
                        try {
                            if (functionId == FUNC_AVM_STATUS || functionId == FUNC_BRIGHTNESS_DAY
                                    || functionId == FUNC_BRIGHTNESS_NIGHT || functionId == FUNC_DAYMODE_SETTING) {
                                cn.navitool.managers.ThemeBrightnessManager
                                        .getInstance(KeepAliveAccessibilityService.this)
                                        .onFunctionValueChanged(functionId, value);
                            }

                            // Door Logic
                            if (functionId == BCM_FUNC_DOOR) {
                                DebugLogger.d(TAG, "Door Function Changed: Zone=" + zone + ", Value=" + value);
                                // Delegate to SoundPromptManager to handle sound logic and file checks safely
                                // Assuming 1 = Open
                                if (value == 1) {
                                    String key = "";
                                    if (zone == 4)
                                        key = "sound_door_passenger_file";
                                    else if (zone == 1)
                                        key = "sound_door_driver_file"; // Example
                                    else if (zone == 16)
                                        key = "sound_door_rear_left_file";
                                    else if (zone == 32)
                                        key = "sound_door_rear_right_file";

                                    if (!key.isEmpty()) {
                                        String ret = getSharedPreferences("navitool_prefs", MODE_PRIVATE).getString(key,
                                                "");
                                        if (!ret.isEmpty()) {
                                            cn.navitool.managers.SoundPromptManager
                                                    .getInstance(KeepAliveAccessibilityService.this)
                                                    .playCustomSound(ret);
                                        }
                                    }
                                }

                            } else if (functionId == BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL) {
                                DebugLogger.d(TAG, "Left Turn Signal Changed: " + value);
                                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                        .updateTurnSignal(true, value == 1);
                            } else if (functionId == BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL) {
                                DebugLogger.d(TAG, "Right Turn Signal Changed: " + value);
                                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                        .updateTurnSignal(false, value == 1);
                                /*
                                 * } else if (functionId == BCM_FUNC_LIGHT_MAIN_BEAM) {
                                 * DebugLogger.d(TAG, "Main Beam Changed: " + value);
                                 * Intent intent = new Intent("cn.navitool.ACTION_HEADLIGHT_STATUS");
                                 * intent.putExtra("type", "main");
                                 * intent.putExtra("status", value);
                                 * sendBroadcast(intent);
                                 */
                            } else if (functionId == FUNC_PSD_SCREEN_SWITCH) {
                                DebugLogger.d(TAG, "PSD Screen Status Changed: " + value);
                                cn.navitool.managers.PsdManager.getInstance(KeepAliveAccessibilityService.this)
                                        .onPsdStatusChanged(value);
                            }
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Error in onFunctionValueChanged", e);
                        }
                    }

                    @Override
                    public void onCustomizeFunctionValueChanged(int functionId, int zone, float value) {
                        try {
                            if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
                                cn.navitool.managers.ThemeBrightnessManager
                                        .getInstance(KeepAliveAccessibilityService.this)
                                        .onCustomizeFunctionValueChanged(functionId, value);
                            }
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Error in onCustomizeFunctionValueChanged", e);
                        }
                    }

                    @Override
                    public void onFunctionChanged(int functionId) {
                        // Not used
                    }

                    @Override
                    public void onSupportedFunctionStatusChanged(int functionId, int zone,
                            com.ecarx.xui.adaptapi.FunctionStatus status) {
                    }

                    @Override
                    public void onSupportedFunctionValueChanged(int functionId, int[] values) {
                    }
                };

                // Register Watchers
                iCarFunction.registerFunctionValueWatcher(FUNC_AVM_STATUS, watcher);
                iCarFunction.registerFunctionValueWatcher(FUNC_BRIGHTNESS_DAY, watcher);
                iCarFunction.registerFunctionValueWatcher(FUNC_BRIGHTNESS_NIGHT, watcher);
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_DOOR, watcher);

                // iCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_MAIN_BEAM, watcher);
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL, watcher);
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL, watcher);
                // Also PSD if needed
                iCarFunction.registerFunctionValueWatcher(FUNC_PSD_SCREEN_SWITCH, watcher);
                // Restore FUNC_DAYMODE_SETTING for Auto Theme Logic
                iCarFunction.registerFunctionValueWatcher(FUNC_DAYMODE_SETTING, watcher);

                DebugLogger.i(TAG, "Function watchers registered (AVM, Brightness, Door, Lights)");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register function listeners", e);
        }
    }

    private final BroadcastReceiver configChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_CONFIGURATION_CHANGED.equals(action)) {
                DebugLogger.d(TAG, "Configuration changed, checking day/night status...");
                cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                        .checkDayNightStatus(false);
            } else if ("cn.navitool.ACTION_REQUEST_ONEOS_STATUS".equals(action)) {
                boolean isConnected = cn.navitool.managers.KeyHandlerManager
                        .getInstance(KeepAliveAccessibilityService.this).isOneOSConnected();
                cn.navitool.managers.KeyHandlerManager.getInstance(KeepAliveAccessibilityService.this)
                        .broadcastOneOSStatus(isConnected);
            } else if ("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS".equals(action)) {
                DebugLogger.d(TAG, "Request Day/Night Status Received");
                cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                        .checkDayNightStatus(true);
            }
        }
    };

    // OneOS Logic moved to KeyHandlerManager

    private void playCustomSound(String filename) {
        if (filename == null || filename.isEmpty())
            return;

        java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory(),
                "NaviTool/Sound/" + filename);
        if (file.exists()) {
            cn.navitool.managers.SoundPromptManager.getInstance(this).playCustomSound(file.getAbsolutePath());
        } else {
            DebugLogger.e(TAG, "Sound file not found: " + filename);
        }
    }

    private void checkAndRepairPermissions() {
        if (!android.provider.Settings.canDrawOverlays(this)) {
            AdbShell.getInstance(this)
                    .exec("appops set " + getPackageName() + " SYSTEM_ALERT_WINDOW allow");
            DebugLogger.i(TAG, "AutoRepair: Repaired Overlay Permission");
        }

        if (checkSelfPermission(
                android.Manifest.permission.WRITE_SECURE_SETTINGS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            AdbShell.getInstance(this)
                    .exec("pm grant " + getPackageName() + " android.permission.WRITE_SECURE_SETTINGS");
            DebugLogger.i(TAG, "AutoRepair: Repaired Secure Settings");
        }

        if (checkSelfPermission(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            AdbShell.getInstance(this)
                    .exec("pm grant " + getPackageName() + " android.permission.READ_EXTERNAL_STORAGE");
            AdbShell.getInstance(this)
                    .exec("pm grant " + getPackageName() + " android.permission.WRITE_EXTERNAL_STORAGE");
            DebugLogger.i(TAG, "AutoRepair: Repaired Storage Permissions");
        }

        android.os.PowerManager pm = (android.os.PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean ignoringBattery = pm != null && pm.isIgnoringBatteryOptimizations(getPackageName());
        if (!ignoringBattery) {
            AdbShell.getInstance(this).exec("dumpsys deviceidle whitelist +" + getPackageName());
            DebugLogger.i(TAG, "AutoRepair: Repaired Battery Opt");
        }
    }

}
