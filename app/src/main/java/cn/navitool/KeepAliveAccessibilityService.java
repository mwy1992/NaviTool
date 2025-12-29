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

        // [新增] 初始化车辆控制接口 (监听发动机、档位、车门等)
        initCar();
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        DebugLogger.init(this); // Initialize DebugLogger
        DebugLogger.i(TAG, "Service Connected");

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.registerOnSharedPreferenceChangeListener(prefsListener);

        // Initialize ADB Loopback if enabled
        // Initialize ADB Loopback if enabled
        if (prefs.getBoolean("adb_wireless_enabled", false)) {
            AdbShell.getInstance(this).connect();
        }

        // Initialize ThemeBrightnessManager
        cn.navitool.managers.ThemeBrightnessManager.getInstance(this).init();
        cn.navitool.managers.SoundPromptManager.getInstance(this).init();
        cn.navitool.managers.KeyHandlerManager.getInstance(this).init();

        // Initialize PSD
        boolean mIsPsdAlwaysOnEnabled = prefs.getBoolean("psd_always_on_enabled", false);
        if (mIsPsdAlwaysOnEnabled) {
            cn.navitool.managers.PsdManager.getInstance(this).setEnabled(true);
        }
        boolean mIsMethod2Enabled = prefs.getBoolean("psd_always_on_method2_enabled", false);
        if (mIsMethod2Enabled) {
            cn.navitool.managers.PsdManager.getInstance(this).setEnabledMethod2(true);
        }

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
    private static final int BCM_FUNC_LIGHT_DIPPED_BEAM = 553976064; // 0x21051000
    private static final int BCM_FUNC_LIGHT_MAIN_BEAM = 553976320; // 0x21051100

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
                        if (sensorType == SENSOR_TYPE_LIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                                    .onSensorChanged(sensorType, value);
                        } else if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
                            int val = (int) value;
                            DebugLogger.d(TAG, "Ignition State Changed (float): " + val);
                            mLastIgnition = val;
                            if (val == ISensorEvent.IGNITION_STATE_START) {
                                AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);
                                DebugLogger.i(TAG, "Ignition START detected");
                            }
                            if (mLastGear != val) {
                                cn.navitool.managers.SoundPromptManager.getInstance(KeepAliveAccessibilityService.this)
                                        .playGearSound(val);
                                mLastGear = val;
                            }
                        } else if (sensorType == ISensor.SENSOR_TYPE_DAY_NIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                                    .onSensorEventChanged(sensorType, (int) value);
                        }
                    }

                    @Override
                    public void onSensorEventChanged(int sensorType, int value) {
                        // Handled in onSensorValueChanged
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
                        if (functionId == FUNC_AVM_STATUS || functionId == FUNC_BRIGHTNESS_DAY
                                || functionId == FUNC_BRIGHTNESS_NIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                                    .onFunctionValueChanged(functionId, value);
                        }

                        // Door Logic
                        if (functionId == BCM_FUNC_DOOR) {
                            DebugLogger.d(TAG, "Door Function Changed: Zone=" + zone + ", Value=" + value);

                            int currentStatus = value; // AdaptAPI door logic is usually bitmap or 0/1
                            // Assuming value passed here is status like 1=open
                            // BUT checkDoorSound expects older full status bitmap logic
                            // Logic in listener saw: if (zone == ZONE_DOOR_FR && value == 1)
                            // Let's simplify: delegate to manager if value=1 (Open)

                            if (zone == 4 && value == 1) { // Passenger Open
                                cn.navitool.managers.SoundPromptManager.getInstance(KeepAliveAccessibilityService.this)
                                        .playCustomSound(getSharedPreferences("navitool_prefs", MODE_PRIVATE)
                                                .getString("sound_door_passenger_file", "door_passenger.mp3"));
                                // OR Use checkDoorSound logic?
                                // SoundPromptManager.checkDoorSound(old, new) requires tracking old state.
                                // Service maintains lastDoor?
                                // I deleted lastDoor in cleanup.
                                // So I should validly call SoundPromptManager.playCustomSound directly if Open.

                                // Use SoundPromptManager internal logic if possible, or trigger sound.
                                // SoundPromptManager.playCustomSound("sound_door_passenger") -> NO, it expects
                                // path.
                                // Wait, SoundPromptManager.checkDoorSound relies on Constants.
                                // Let's use direct play for now as logic is simple.
                                cn.navitool.managers.SoundPromptManager.getInstance(KeepAliveAccessibilityService.this)
                                        .checkDoorSound(0, 4); // Simulate 0->4 change
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
                            cn.navitool.managers.PsdManager.getInstance(KeepAliveAccessibilityService.this)
                                    .onPsdStatusChanged(value);
                        }
                    }

                    @Override
                    public void onCustomizeFunctionValueChanged(int functionId, int zone, float value) {
                        if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                                    .onCustomizeFunctionValueChanged(functionId, value);
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
                cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                        .checkDayNightStatus(false);
            } else if ("cn.navitool.ACTION_REQUEST_ONEOS_STATUS".equals(action)) {
                boolean isConnected = cn.navitool.managers.KeyHandlerManager
                        .getInstance(KeepAliveAccessibilityService.this).isOneOSConnected();
                cn.navitool.managers.KeyHandlerManager.getInstance(KeepAliveAccessibilityService.this)
                        .broadcastOneOSStatus(isConnected);
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

}
