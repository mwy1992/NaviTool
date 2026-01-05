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
    private cn.navitool.verifier.LightSensorVerifier mLightVerifier;

    // initPsdKeepAlive and showKeepAliveOnDisplay Removed

    @Override
    public void onCreate() {
        super.onCreate();
        DebugLogger.init(this); // [Fix Cold Boot] Init logger early
        ConfigManager.init(this); // [Fix Cold Boot] Init config early so triggers in onCreate can read prefs
        DebugLogger.i(TAG, "Service Created");
        DebugLogger.createDirectories();

        // 启动光照传感器验证器
        try {
            mLightVerifier = new cn.navitool.verifier.LightSensorVerifier(this);
            mLightVerifier.start();
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to start LightSensorVerifier", e);
        }

        // 启动副驾屏保活
        cn.navitool.managers.PsdManager.getInstance(this).init();

        // [BUG 3 FIX] KeyHandlerManager 移到 onServiceConnected 中初始化
        // 避免在 Service 完全连接前调用

        // [新增] 初始化车辆控制接口 (监听发动机、档位、车门等)
        initCar();
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        // DebugLogger.init(this); // Moved to onCreate
        // ConfigManager.init(this); // Moved to onCreate
        DebugLogger.action(TAG, "无障碍服务已连接");
        DebugLogger.i(TAG, "Service Connected");

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.registerOnSharedPreferenceChangeListener(prefsListener);

        // Initialize ThemeBrightnessManager
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
        filter.addAction("cn.navitool.ACTION_SIMULATE_ENGINE_START"); // 模拟发动机启动
        try {
            if (Build.VERSION.SDK_INT >= 33) { // Android 13+ (Tiramisu)
                registerReceiver(configChangeReceiver, filter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(configChangeReceiver, filter);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register configChangeReceiver", e);
        }

        // Initialize and start Amap Broadcast Monitor (Silent Logger)
        try {
            cn.navitool.managers.AmapMonitorManager.getInstance(this).startMonitoring();
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to start AmapMonitorManager", e);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DebugLogger.i(TAG, "Service destroying, cleaning up resources...");

        if (mLightVerifier != null) {
            mLightVerifier.stop();
            mLightVerifier = null;
        }

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
    // [BUG 4 FIX] 车速传感器 (from ecarx.adaptapi.jar.src -> ISensor.java)
    private static final int SENSOR_TYPE_CAR_SPEED = 1048832; // 0x100100 - 实际车速
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
                            // [BUG 2 FIX] 有些车型通过 float 回调报告点火状态
                            else if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
                                int val = (int) value;
                                DebugLogger.d(TAG, "Ignition State Changed (float): " + val);
                                if (val == ISensorEvent.IGNITION_STATE_DRIVING) {
                                    DebugLogger.i(TAG, "Ignition DRIVING (float) - Triggering Auto Start");
                                    triggerAutoStart();
                                }
                            }
                            // [BUG 4 FIX] 实际车速传感器 - 用于状态页面对比显示
                            else if (sensorType == SENSOR_TYPE_CAR_SPEED) {
                                // 转换因子 3.6 (1 m/s = 3.6 km/h)
                                int speedKmh = (int) (value * 3.6f);
                                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                        .updateActualSpeed(speedKmh);
                            }
                            // DIM车速传感器 - 用于仪表盘显示（与原车仪表一致）
                            else if (sensorType == SENSOR_TYPE_DIM_CAR_SPEED) {
                                // DIM速度与实际车速格式相同，都需要乘以3.6转换为km/h
                                int speedKmh = (int) (value * 3.6f);
                                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                                        .updateSpeed(speedKmh);
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

                                // User Request: Only trigger on DRIVING (2097415)
                                if (value == ISensorEvent.IGNITION_STATE_DRIVING) {
                                    mEngineStarted = true; // Bug 7: 标记发动机已启动，允许播放档位声音
                                    DebugLogger.i(TAG,
                                            "Ignition DRIVING detected - Triggering Auto Start Sequence");
                                    triggerAutoStart(); // Extracted method
                                }
                            } else if (sensorType == SENSOR_TYPE_GEAR) {
                                DebugLogger.d(TAG, "Gear Changed (int): " + value);
                                // Bug 7: 只有发动机启动后才播放档位声音
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
                // 注册车速传感器（实际车速和DIM仪表速度）
                iSensor.registerListener(listener, SENSOR_TYPE_CAR_SPEED);
                iSensor.registerListener(listener, SENSOR_TYPE_DIM_CAR_SPEED);

                DebugLogger.i(TAG, "Sensor listeners registered (Ignition, DayNight, Gear, Light, Speed, DIMSpeed)");

                // [Auto Start Fix] Poll Ignition immediately in case we missed the event
                try {
                    int currentIgnition = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_IGNITION_STATE);
                    DebugLogger.i(TAG, "Initial Ignition Poll: " + currentIgnition);
                    if (currentIgnition == ISensorEvent.IGNITION_STATE_DRIVING ||
                            currentIgnition == ISensorEvent.IGNITION_STATE_ON) {
                        DebugLogger.i(TAG, "Ignition already ON/DRIVING. Triggering Auto Start...");
                        triggerAutoStart();
                    }
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Failed to poll initial ignition state", e);
                }

                // [HUD/Cluster Fix] Active Polling for Sensor Data to prevent delay
                pollInitialSensorData();

            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register sensor listeners", e);
        }
    }

    private void pollInitialSensorData() {
        if (iSensor == null)
            return;
        DebugLogger.i(TAG, "Polling initial sensor data (Fuel, Range, Temp, Gear)...");
        try {
            // 1. Gear (Event Type)
            // Use local constant or VehicleSensorManager constant
            int gear = iSensor.getSensorEvent(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_GEAR);
            DebugLogger.d(TAG, "Polled Gear: " + gear);
            ClusterHudManager.getInstance(this).updateGear(gear);
            mLastGear = gear;

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
        // Debounce: Prevent multiple calls during the 3-second delay period
        if (mAutoStartPending) {
            DebugLogger.i(TAG, "triggerAutoStart: Already pending, skipping duplicate call");
            return;
        }
        mAutoStartPending = true;

        // 1. Repair Permissions (Fixes Auto Repair bug)
        checkAndRepairPermissions();

        // 2. Launch Apps
        AppLaunchManager.executeLaunch(KeepAliveAccessibilityService.this);

        // 3. Play Sound
        cn.navitool.managers.SoundPromptManager
                .getInstance(KeepAliveAccessibilityService.this)
                .playStartSound();

        // 4. 立即激活 UI (不需要等待 3 秒)
        boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("switch_cluster", false);
        boolean isHudEnabled = ConfigManager.getInstance().getBoolean("switch_hud", false);

        DebugLogger.i(TAG, "triggerAutoStart: Activating UI immediately (Cluster=" + isClusterEnabled + ", HUD="
                + isHudEnabled + ")");

        if (isClusterEnabled || isHudEnabled) {
            // 立即显示 UI
            ClusterHudManager.getInstance(KeepAliveAccessibilityService.this)
                    .showUiOnly(isClusterEnabled, isHudEnabled);

            // 同时发送广播以便 MainActivity 也能更新 UI
            android.content.Intent intent = new android.content.Intent("cn.navitool.ACTION_ACTIVATE_CLUSTER_HUD");
            sendBroadcast(intent);
        }

        // 5. 延迟 3 秒后切换导航模式 (如果是仪表模式)
        // 只有开启了仪表才需要切换模式，HUD 不需要
        if (isClusterEnabled) {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                DebugLogger.i(TAG, "3s delay passed - Switching Navi Mode to 3");
                ClusterHudManager.getInstance(KeepAliveAccessibilityService.this).applyNaviMode(3);

                // Reset debounce flag after activation completes
                mAutoStartPending = false;
            }, 3000);
        } else {
            // 如果没开启仪表，直接重置标志
            mAutoStartPending = false;
        }
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
            } else if ("cn.navitool.ACTION_SIMULATE_ENGINE_START".equals(action)) {
                // 模拟发动机启动 - 执行完整的 triggerAutoStart 流程
                DebugLogger.i(TAG, "Simulate Engine Start Received - Triggering full auto start sequence");
                triggerAutoStart();
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
