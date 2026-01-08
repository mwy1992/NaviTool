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

    private static KeepAliveAccessibilityService instance;

    public static KeepAliveAccessibilityService getInstance() {
        return instance;
    }

    // ... existing fields ...
    private ICarFunction iCarFunction;
    private ISensor iSensor;
    // ...

    private boolean mAmapDetected = false; // Gate for Amap Services
    private boolean mIsAmapServicesStarted = false;

    // Dynamic Receiver for ADB Simulation (Avoids Android 8+ Background Execution
    // Limits)
    private SimulateIgnitionReceiver mSimulateReceiver;

    // ... existing fields ...
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

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this; // Set Singleton
        DebugLogger.init(this);
        ConfigManager.init(this);
        DebugLogger.i(TAG, "Service Created");
        DebugLogger.createDirectories();

        cn.navitool.managers.PsdManager.getInstance(this).init();
        initCar();
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        DebugLogger.action(TAG, "无障碍服务已连接");
        DebugLogger.i(TAG, "Service Connected");

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.registerOnSharedPreferenceChangeListener(prefsListener);

        // Initialize Managers
        cn.navitool.managers.ThemeBrightnessManager.getInstance(this).init();
        cn.navitool.managers.SoundPromptManager.getInstance(this).init();
        cn.navitool.managers.KeyHandlerManager.getInstance(this).init();
        cn.navitool.managers.VehicleSensorManager.getInstance(this).init();

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

        DebugLogger.logBootEvent(this);

        DebugLogger.i(TAG, "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        filter.addAction("cn.navitool.ACTION_REQUEST_ONEOS_STATUS");
        filter.addAction("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
        // filter.addAction("cn.navitool.ACTION_SIMULATE_ENGINE_START"); // Now handled
        // by Manifest Receiver
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                registerReceiver(configChangeReceiver, filter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(configChangeReceiver, filter);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register configChangeReceiver", e);
        }

        // Removed Early Amap Monitor Start (User Request: Gate behind Ignition +
        // Running)

        // Register Simulation Receiver dynamically
        try {
            mSimulateReceiver = new SimulateIgnitionReceiver();
            IntentFilter simFilter = new IntentFilter("cn.navitool.ACTION_SIMULATE_ENGINE_START");
            if (Build.VERSION.SDK_INT >= 33) {
                registerReceiver(mSimulateReceiver, simFilter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(mSimulateReceiver, simFilter);
            }
            DebugLogger.i(TAG, "Dynamic SimulateIgnitionReceiver Registered");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register SimulateIgnitionReceiver", e);
        }
    }

    // ... onDestroy ...

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            CharSequence packageName = event.getPackageName();
            if (packageName != null && AUTONAVI_PKG.equals(packageName.toString())) {
                boolean wasDetected = mAmapDetected;
                mAmapDetected = true;

                if (!wasDetected) {
                    DebugLogger.i(TAG, "Amap Auto Detected (" + packageName + "). Checking service requirements...");
                }

                // Sync Theme
                DebugLogger.d(TAG, "AutoNavi foreground. Syncing theme...");
                cn.navitool.managers.ThemeBrightnessManager.getInstance(this).syncAutoNaviTheme();

                // Check if we can start Amap Services now
                checkAndStartAmapServices();
            }
        }
    }

    private void checkAndStartAmapServices() {
        if (mIsAmapServicesStarted)
            return;

        // Double Gate: Ignition DRIVING + Amap Detected
        if (mIgnitionReady && mAmapDetected) {
            DebugLogger.i(TAG, "Conditions Met (Ignition + Amap). Starting Amap Services...");
            mIsAmapServicesStarted = true;
            try {
                // Start Monitor
                cn.navitool.managers.AmapMonitorManager.getInstance(this).startMonitoring();
                // Aidl might be handled by monitor or separate manager, ensure it's connected
                // if needed
                // cn.navitool.managers.AmapAidlManager.getInstance(this).connect(); // Usually
                // called by Monitor or Activity
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to start Amap Services", e);
            }
        } else {
            DebugLogger.d(TAG, "Amap Services Gated: Ignition=" + mIgnitionReady + ", AmapDetected=" + mAmapDetected);
        }
    }

    // ...

    public void resetIgnitionState() {
        mIgnitionReady = false;
        mEngineStarted = false; // [FIX] Reset engine start flag
        mHeavySensorsRegistered = false; // Allow re-registration
        DebugLogger.i(TAG, "Ignition State Reset for Simulation");
    }

    public void handleIgnitionDriving() { // Made Public for Receiver
        if (mIgnitionReady) {
            DebugLogger.w(TAG,
                    "Ignition already READY. Skipping handleIgnitionDriving. (Use resetIgnitionState() to force)");
            return;
        }
        mIgnitionReady = true;
        mEngineStarted = true; // [FIX] Ensure flag is set so gear sounds can play

        DebugLogger.i(TAG, "Ignition DRIVING detected! triggering AutoStart and scheduling Heavy Sensors...");

        // 1. Trigger Lightweight Auto Start
        triggerAutoStart();

        // 2. Schedule Heavy Sensor Audio/Logic
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            if (!mHeavySensorsRegistered) {
                registerHeavySensors();
                // [FIX] Direct UI Activation from Service (Headless Support)
                // Instead of broadcasting to Activity (which might not exist), we call Manager
                // directly.
                DebugLogger.i(TAG, "Ignition + 3s: Calling ensureUiVisible() directly");
                cn.navitool.ClusterHudManager.getInstance(KeepAliveAccessibilityService.this).ensureUiVisible();
            }
        }, 3000);

        // 3. Check Amap Services
        checkAndStartAmapServices();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DebugLogger.i(TAG, "Service destroying, cleaning up resources...");

        // LightVerifier stop logic removed

        // Stop Amap Monitor
        try {
            cn.navitool.managers.AmapMonitorManager.getInstance(this).stopMonitoring();
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to stop AmapMonitorManager", e);
        }

        cn.navitool.managers.ThemeBrightnessManager.getInstance(this).destroy();
        cn.navitool.managers.SoundPromptManager.getInstance(this).destroy();
        cn.navitool.managers.KeyHandlerManager.getInstance(this).destroy();
        cn.navitool.managers.PsdManager.getInstance(this).destroy();
        cn.navitool.ClusterHudManager.getInstance(this).destroy();
        cn.navitool.managers.VehicleSensorManager.getInstance(this).destroy();

        // Unregister Dynamic Simulation Receiver
        try {
            if (mSimulateReceiver != null) {
                unregisterReceiver(mSimulateReceiver);
                mSimulateReceiver = null;
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error unregistering SimulateIgnitionReceiver", e);
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
    // [BUG 4 FIX] 车速传感器 (from ecarx.adaptapi.jar.src -> ISensor.java)

    private static final int SENSOR_TYPE_DIM_CAR_SPEED = 1055232; // 仪表盘显示速度 (与原车仪表一致)
    private static final int BCM_FUNC_DOOR = 553779456; // 0x21020000
    private boolean mAutoStartPending = false; // Debounce flag for triggerAutoStart

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
    private boolean mEngineStarted = false; // Bug 7: 只有发动机启动后才播放声音
    private boolean mInitialGearSkipped = false; // Bug 7: 忽略启动时的第一次P档事件

    // --- Car AdaptAPI Implementation ---

    private void initCar() {
        cn.navitool.managers.CarServiceManager manager = cn.navitool.managers.CarServiceManager.getInstance(this);

        // [FIX] Use callback pattern to wait for async connection
        manager.registerListener(() -> onCarServiceReady());
        manager.init();
    }

    private void onCarServiceReady() {
        cn.navitool.managers.CarServiceManager manager = cn.navitool.managers.CarServiceManager.getInstance(this);
        this.iCarFunction = manager.getCarFunction();
        this.iSensor = manager.getSensor();

        DebugLogger.i(TAG, "Car Service Ready! iCarFunction=" + (iCarFunction != null) +
                ", iSensor=" + (iSensor != null));

        if (iSensor != null) {
            registerSensorListeners();
        }
        if (iCarFunction != null) {
            registerFunctionListeners();
        }
    }

    private boolean mIgnitionReady = false;
    private boolean mHeavySensorsRegistered = false;

    private void registerSensorListeners() {
        // [New Logic] Only register Ignition listener initially
        try {
            if (iSensor != null) {
                ISensor.ISensorListener listener = new ISensor.ISensorListener() {
                    @Override
                    public void onSensorValueChanged(int sensorType, float value) {
                        try {
                            if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
                                int val = (int) value;
                                DebugLogger.d(TAG, "Ignition State Changed (float): " + val);
                                if (val == ISensorEvent.IGNITION_STATE_DRIVING) {
                                    handleIgnitionDriving();
                                }
                            }
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
                                if (value == ISensorEvent.IGNITION_STATE_DRIVING) {
                                    handleIgnitionDriving();
                                }
                            }
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Error in onSensorEventChanged", e);
                        }
                    }

                    @Override
                    public void onSensorSupportChanged(int sensorType, com.ecarx.xui.adaptapi.FunctionStatus status) {
                    }
                };

                // Only Register Ignition initially
                iSensor.registerListener(listener, ISensor.SENSOR_TYPE_IGNITION_STATE);
                DebugLogger.i(TAG, "Ignition Listener Registered. Waiting for DRIVING state...");

                // Poll once immediately
                try {
                    int currentIgnition = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_IGNITION_STATE);
                    DebugLogger.i(TAG, "Initial Ignition Poll: " + currentIgnition);
                    if (currentIgnition == ISensorEvent.IGNITION_STATE_DRIVING) {
                        handleIgnitionDriving();
                    }
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Failed to poll initial ignition state", e);
                }

            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register sensor listeners", e);
        }
    }

    // handleIgnitionDriving moved to line 166

    private void registerHeavySensors() {
        if (mHeavySensorsRegistered || iSensor == null)
            return;
        mHeavySensorsRegistered = true;

        DebugLogger.i(TAG, "Registering HEAVY Sensors (Gear, Light, Speed)...");
        try {
            ISensor.ISensorListener heavyListener = new ISensor.ISensorListener() {
                @Override
                public void onSensorValueChanged(int sensorType, float value) {
                    try {
                        if (sensorType == SENSOR_TYPE_LIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager
                                    .getInstance(KeepAliveAccessibilityService.this)
                                    .onSensorChanged(sensorType, value);

                        } else if (sensorType == SENSOR_TYPE_DIM_CAR_SPEED) {
                            // DIM速度与实际车速格式相同，都需要乘以3.6转换为km/h
                            int speedKmh = (int) (value * 3.6f);
                            ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                    .updateSpeed(speedKmh);
                        }
                    } catch (Exception e) {
                        DebugLogger.e(TAG, "Error in Heavy onSensorValueChanged", e);
                    }
                }

                @Override
                public void onSensorEventChanged(int sensorType, int value) {
                    try {
                        if (sensorType == SENSOR_TYPE_GEAR) {
                            DebugLogger.d(TAG, "Gear Changed (int): " + value);
                            if (mLastGear != value) {
                                // Bug 7: 忽略启动时的第一次P档事件
                                boolean isInitialP = !mInitialGearSkipped &&
                                        (value == cn.navitool.managers.SoundPromptManager.GEAR_PARK ||
                                                value == cn.navitool.managers.SoundPromptManager.TRSM_GEAR_PARK);
                                if (isInitialP) {
                                    mInitialGearSkipped = true;
                                    DebugLogger.d(TAG, "Skipping initial P gear sound");
                                } else if (mEngineStarted) {
                                    cn.navitool.managers.SoundPromptManager
                                            .getInstance(KeepAliveAccessibilityService.this)
                                            .playGearSound(value);
                                }
                                // 不管是否播放声音，仪表盘显示始终更新
                                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                        .updateGear(value);
                                mLastGear = value;
                            }
                        } else if (sensorType == ISensor.SENSOR_TYPE_DAY_NIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager
                                    .getInstance(KeepAliveAccessibilityService.this)
                                    .onSensorEventChanged(sensorType, value);
                        }
                    } catch (Exception e) {
                        DebugLogger.e(TAG, "Error in Heavy onSensorEventChanged", e);
                    }
                }

                @Override
                public void onSensorSupportChanged(int sensorType, com.ecarx.xui.adaptapi.FunctionStatus status) {
                }
            };

            // Register for Heavy Sensors
            iSensor.registerListener(heavyListener, ISensor.SENSOR_TYPE_DAY_NIGHT);
            iSensor.registerListener(heavyListener, SENSOR_TYPE_GEAR);
            iSensor.registerListener(heavyListener, SENSOR_TYPE_LIGHT);

            iSensor.registerListener(heavyListener, SENSOR_TYPE_DIM_CAR_SPEED);

            DebugLogger.i(TAG, "Heavy Sensors Registered Successfully (DayNight, Gear, Light, Speed).");

            // Poll Initial Data for these sensors (Delayed 500ms to allow AdaptAPI to
            // fetch)
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(this::pollInitialSensorData, 500);

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register heavy sensors", e);
        }
    }

    private void pollInitialSensorData() {
        if (iSensor == null)
            return;
        DebugLogger.i(TAG, "Polling initial sensor data (Fuel, Range, Temp, Gear)...");
        try {
            // 1. Gear (Event Type)
            int gear = iSensor.getSensorEvent(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_GEAR);
            DebugLogger.d(TAG, "Polled Gear: " + gear);
            if (gear != 0) {
                ClusterHudManager.getInstance(this).updateGear(gear);
                mLastGear = gear;
            } else {
                DebugLogger.w(TAG, "Polled Invalid Gear (0) - Ignoring to prevent default 'P' overwrite");
            }

            // 2. Fuel Level (Value Type - Float)
            float fuel = iSensor.getSensorLatestValue(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_FUEL);
            DebugLogger.d(TAG, "Polled Fuel: " + fuel);
            ClusterHudManager.getInstance(this).updateFuel((int) fuel + "L");

            // 3. Range (Value Type - Float)
            float range = iSensor.getSensorLatestValue(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_RANGE);
            DebugLogger.d(TAG, "Polled Range: " + range);
            ClusterHudManager.getInstance(this).updateRange((int) range + "km");

            // 4. Outside Temp (Value Type - Float)
            float tempOut = iSensor
                    .getSensorLatestValue(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_TEMP_OUTDOOR);
            DebugLogger.d(TAG, "Polled TempOut: " + tempOut);
            ClusterHudManager.getInstance(this).updateTempOut(tempOut + "°C");

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to poll initial sensor data", e);
        }
    }

    private void triggerAutoStart() {
        if (mAutoStartPending) {
            return;
        }
        mAutoStartPending = true;

        // 1. Repair Permissions
        checkAndRepairPermissions();

        // 2. Play Sound (Async)
        cn.navitool.managers.SoundPromptManager
                .getInstance(KeepAliveAccessibilityService.this)
                .playStartSound();

        DebugLogger.i(TAG, "triggerAutoStart: Launching Logic (Headless Mode)...");

        // [FIX] Reverted forced MainActivity launch.
        // User requested Presentation to start WITHOUT MainActivity.
        // We rely on ClusterHudManager to show Presentation from Service Context.

        // 3. Launch configured third-party apps (if enabled)
        cn.navitool.managers.AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);

        // Reset pending flag
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            mAutoStartPending = false;
        }, 5000);
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
                                handleDoorStatus(zone, value);
                            } else if (functionId == BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL) {
                                DebugLogger.d(TAG, "Left Turn Signal Changed: " + value);
                                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                        .updateTurnSignal(true, value == 1);
                            } else if (functionId == BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL) {
                                DebugLogger.d(TAG, "Right Turn Signal Changed: " + value);
                                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                        .updateTurnSignal(false, value == 1);
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
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL, watcher);
                iCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL, watcher);
                iCarFunction.registerFunctionValueWatcher(FUNC_PSD_SCREEN_SWITCH, watcher);
                iCarFunction.registerFunctionValueWatcher(FUNC_DAYMODE_SETTING, watcher);

                DebugLogger.i(TAG, "Function watchers registered (AVM, Brightness, Door, Lights)");

                // [Fix Door Sound] Poll door status immediately
                pollDoorStatus();
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register function listeners", e);
        }
    }

    private void pollDoorStatus() {
        if (iCarFunction == null)
            return;
        try {
            // Poll Passenger Door (Zone 4)
            int val = iCarFunction.getFunctionValue(BCM_FUNC_DOOR, 4);
            DebugLogger.d(TAG, "Polled Door Zone 4 Value: " + val);
            if (val == 1) {
                handleDoorStatus(4, 1);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to poll door status", e);
        }
    }

    private void handleDoorStatus(int zone, int value) {
        // 只在门打开时播放 (value == 1)
        if (value == 1) {
            // Zone 4 = 副驾驶车门
            if (zone == 4) {
                DebugLogger.d(TAG, "Passenger Door (Zone 4) Open, triggering sound");
                // 使用与其他声音相同的方法，自动处理开关检查和路径解析
                cn.navitool.managers.SoundPromptManager
                        .getInstance(KeepAliveAccessibilityService.this)
                        .playDoorPassengerSound();
            }
            // 其他门暂时不处理
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
