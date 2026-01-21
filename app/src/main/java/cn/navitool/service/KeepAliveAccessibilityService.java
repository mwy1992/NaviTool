package cn.navitool.service;

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
import cn.navitool.utils.DebugLogger;
import cn.navitool.utils.AdbShell;
import cn.navitool.utils.SimulateFunction;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.PsdManager;
import cn.navitool.managers.KeyHandlerManager;
import cn.navitool.managers.ThemeBrightnessManager;
import cn.navitool.managers.SoundPromptManager;
import cn.navitool.managers.VehicleSensorManager;

import cn.navitool.managers.BaiduMonitorManager;
import cn.navitool.managers.AmapMonitorManager;
import cn.navitool.managers.SunshadeManager;
import cn.navitool.managers.CarServiceManager;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.ClusterHudManagerApi30;
import cn.navitool.utils.MemoryMonitor;
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

    public ICarFunction getCarFunction() {
        return iCarFunction;
    }

    private ISensor iSensor;
    // ...

    private boolean mAmapDetected = false; // Gate for Amap Services
    private boolean mIsAmapServicesStarted = false;

    // Dynamic Receiver for ADB Simulation (Avoids Android 8+ Background Execution
    // Limits)
    private SimulateFunction.IgnitionReceiver mSimulateReceiver;

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

        // 启动 OneOS 服务 (方控/微信按键) - 必须在 onCreate 调用以确保最快绑定
        cn.navitool.managers.KeyHandlerManager.getInstance(this).init();

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
        MemoryMonitor.setComponentStatus("KeepAliveService", "Active");
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
            mSimulateReceiver = new SimulateFunction.IgnitionReceiver();
            IntentFilter simFilter = new IntentFilter("cn.navitool.ACTION_SIMULATE_ENGINE_START");
            if (Build.VERSION.SDK_INT >= 33) {
                registerReceiver(mSimulateReceiver, simFilter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(mSimulateReceiver, simFilter);
            }
            DebugLogger.i(TAG, "Dynamic SimulateFunction.IgnitionReceiver Registered");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register SimulateFunction.IgnitionReceiver", e);
        }

        // [FIX] 备用悬浮球启动：延迟5秒后检查悬浮球是否已启动，如果没有则尝试启动
        // 这是为了处理点火状态检测延迟或失败的情况
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            if (ConfigManager.getInstance().getBoolean("floating_ball_enabled", false)) {
                // 使用静态变量检查服务状态，O(1)复杂度，无IPC开销
                if (!cn.navitool.service.FloatingBallService.isRunning()) {
                    DebugLogger.i(TAG, "[Backup] FloatingBall not running, starting now...");
                    startFloatingBallIfEnabled();
                } else {
                    DebugLogger.d(TAG, "[Backup] FloatingBall already running, skipping");
                }
            }
        }, 5000);
    }

    // ... onDestroy ...

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            CharSequence packageName = event.getPackageName();
            CharSequence className = event.getClassName();
            boolean isFullScreen = event.isFullScreen();
            
            // [DEBUG] Log all window changes to diagnose Amap flashing
            DebugLogger.d(TAG, "Window Change: Pkg=" + packageName + " Class=" + className + " FullScreen=" + isFullScreen);

            // [Issue 7 Fix] Detect Amap Foreground State for Floating Window hiding
            boolean isAmapPackage = (packageName != null && AUTONAVI_PKG.equals(packageName.toString()));
            boolean isAmap = false;

            if (isAmapPackage) {
                // Refined Logic (2026-01-17):
                // Only consider it "Foreign Foreground" if it is FullScreen OR strictly an Activity/Dialog.
                // Ignore generic FrameLayout overlays which might pop up in background.
                if (isFullScreen) {
                    isAmap = true;
                } else {
                    String cls = (className != null) ? className.toString() : "";
                    if (cls.contains("Activity") || cls.contains("Dialog")) {
                         isAmap = true;
                    } else {
                         DebugLogger.d(TAG, "Ignoring Amap Background/Overlay Event: " + cls);
                         return; // [KEY] Return early for ignored events so we don't accidentally setAmapForeground(false) via else block if we were logic-bound
                         // actually, we need to be careful.
                         // If we are currently in "Amap Foreground" state, and we receive an ignored event, we should NOT change state.
                         // But the current logic below calls setAmapForeground(isAmap).
                         
                         // Wait, if I set isAmap=false here, setAmapForeground(false) will be called.
                         // If we were previously true, this would HIDE it (or SHOW it? setAmapForeground(false) means SHOW floating).
                         // Yes, false means show floating.
                         // So if I return early, I preserve previous state?
                         // ClusterHudManager.setAmapForeground checks for change.
                         
                         // Correct logic: If process is Amap but it's an overlay, we should Ignore this event completely.
                         // Do not call setAmapForeground at all.
                    }
                }
            }
            
            if (isAmapPackage && !isAmap) {
                 // It matches package but was filtered out (e.g. FrameLayout)
                 DebugLogger.d(TAG, "Event Parsed: Amap Overlay -> IGNORE State Change");
            } else {
                 // Standard Logic
                 // If isAmapPackage is true (and passed filter), then isAmap=true.
                 // If isAmapPackage is false, then isAmap=false (Other apps).
                 
                 // However, "isAmap" variable above was init to false. 
                 // If package!=Amap, isAmap=false.
                 // If package==Amap and isFull, isAmap=true.
                 
                 // We need to handle the "Exclude" case properly to avoid flipping state.
                 // So:
                 if (isAmapPackage) {
                      // Amap Logic
                      if (isFullScreen || (className != null && (className.toString().contains("Activity") || className.toString().contains("Dialog")))) {
                          // Real Foreground
                          ClusterHudManager.getInstance(this).setAmapForeground(true);
                      } else {
                          // Fake/Overlay -> Ignore
                          // Do nothing
                      }
                 } else {
                      // Other Apps -> Not Amap Foreground -> set false (Show Floating)
                      ClusterHudManager.getInstance(this).setAmapForeground(false);
                 }
            }

            if (isAmapPackage && (isFullScreen || (className != null && (className.toString().contains("Activity") || className.toString().contains("Dialog"))))) {
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

    private void checkAndStartMapServices() {
        if (mIgnitionReady) {
            // Start General Map Monitors (Tencent, Baidu) - run as long as we are driving
            try {
                // TencentMonitorManager removed
                cn.navitool.managers.BaiduMonitorManager.getInstance(this).startMonitoring();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to start Map Monitors", e);
            }
        }

        checkAndStartAmapServices();
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
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to start Amap Services", e);
            }
        } else {
            DebugLogger.d(TAG, "Amap Services Gated: Ignition=" + mIgnitionReady + ", AmapDetected=" + mAmapDetected);
        }
    }

    // ...

    public void resetIgnitionState() {
        DebugLogger.i(TAG, "Resetting Ignition State (Ignition OFF/ACC detected)...");
        
        // 1. Reset Flags
        mIgnitionReady = false;
        mEngineStarted = false; // [FIX] Reset engine start flag
        
        // 2. Unregister Heavy Sensors to prevent double-registration on restart
        unregisterHeavySensors();
        
        // 3. Notify ClusterHudManager to enter Standby Mode (Clean UI/Cache)
        // 3. Notify ClusterHudManager to enter Standby Mode (Clean UI/Cache)
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            ClusterHudManagerApi30.getInstance(this).enterStandbyMode();
        } else {
            ClusterHudManager.getInstance(this).enterStandbyMode();
        }
        
        DebugLogger.i(TAG, "Ignition State Reset Complete. Waiting for next DRIVING event.");
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

        // Bug 4 Fix: Delayed start for Floating Ball to avoid conflicts on boot
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            startFloatingBallIfEnabled();
        }, 3500);

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
                // [FIX] Direct UI Activation from Service (Headless Support)
                DebugLogger.i(TAG, "Ignition + 3s: Calling ensureUiVisible() directly");
                if (android.os.Build.VERSION.SDK_INT >= 30) {
                    ClusterHudManagerApi30.getInstance(KeepAliveAccessibilityService.this).ensureUiVisible();
                    DebugLogger.i(TAG, "Ignition + 3s: Auto-Switching to NaviMode 3 (Instrument Mode) [API30]");
                    ClusterHudManagerApi30.getInstance(KeepAliveAccessibilityService.this).applyNaviMode(3);
                } else {
                    ClusterHudManager.getInstance(KeepAliveAccessibilityService.this).ensureUiVisible();
                    DebugLogger.i(TAG, "Ignition + 3s: Auto-Switching to NaviMode 3 (Instrument Mode)");
                    ClusterHudManager.getInstance(KeepAliveAccessibilityService.this).applyNaviMode(3);
                }
            }
        }, 3000);

        // 3. Check Amap Services & Map Monitors
        checkAndStartMapServices();

        // 4. Trigger Sunshade Auto Open
        // Checks internal logic (Enabled? Night Mode?) before acting
        cn.navitool.managers.SunshadeManager.getInstance(this).executeAutoOpen();
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

        try {
            // TencentMonitorManager removed
            cn.navitool.managers.BaiduMonitorManager.getInstance(this).stopMonitoring();
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to stop Map Monitors", e);
        }

        cn.navitool.managers.ThemeBrightnessManager.getInstance(this).destroy();
        cn.navitool.managers.SoundPromptManager.getInstance(this).destroy();
        cn.navitool.managers.KeyHandlerManager.getInstance(this).destroy();
        cn.navitool.managers.PsdManager.getInstance(this).destroy();
        ClusterHudManager.getInstance(this).destroy();
        cn.navitool.managers.VehicleSensorManager.getInstance(this).destroy();

        // Unregister Dynamic Simulation Receiver
        try {
            if (mSimulateReceiver != null) {
                unregisterReceiver(mSimulateReceiver);
                mSimulateReceiver = null;
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error unregistering SimulateFunction.IgnitionReceiver", e);
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

// DIM Speed Removed to fix jitter conflict with VehicleSensorManager
    private static final int SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER = 2110464; // Event Type
    private static final int SEAT_OCCUPATION_STATUS_NONE = 2110209;     // 无人
    private static final int SEAT_OCCUPATION_STATUS_OCCUPIED = 2110210; // 有人

    private static final int BCM_FUNC_DOOR = 553779456; // 0x21020000
    private boolean mAutoStartPending = false; // Debounce flag for triggerAutoStart

    // Door Zones
    private static final int ZONE_DOOR_FL = 1; // Front Left
    private static final int ZONE_DOOR_FR = 4; // Front Right
    private static final int ZONE_DOOR_RL = 16; // Rear Left
    private static final int ZONE_DOOR_RR = 64; // Rear Right
    private static final int ZONE_DOOR_HOOD = 268435456; // Hood
    private static final int ZONE_DOOR_REAR = 536870912; // Trunk

    // Constants for Listeners

    // user log confirms 0x21051100 is Left Turn Signal
    private static final int BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL = 0x21051100; // 553976320
    private static final int BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL = 0x21051200; // 553976576
    // private static final int BCM_FUNC_LIGHT_MAIN_BEAM = 553976320; // 0x21051100
    // (CONFLICT - Commented out)

    // Sound Prompt States
    private int mLastIgnition = -1;
    private int mLastGear = -1;
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
    private ISensor.ISensorListener mHeavySensorListener; // [Refactor] Promoted to field for unregistering

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
                                } else if (val == ISensorEvent.IGNITION_STATE_OFF || 
                                           val == ISensorEvent.IGNITION_STATE_ACC || 
                                           val == ISensorEvent.IGNITION_STATE_LOCK) {
                                    // [FIX] Warm Restart: Reset state when ignition goes OFF/ACC/LOCK
                                    if (mIgnitionReady) {
                                        // [Thread Safety] Dispatch to Main Thread
                                        new android.os.Handler(android.os.Looper.getMainLooper()).post(() -> resetIgnitionState());
                                    }
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
                                } else if (value == ISensorEvent.IGNITION_STATE_OFF || 
                                           value == ISensorEvent.IGNITION_STATE_ACC || 
                                           value == ISensorEvent.IGNITION_STATE_LOCK) {
                                    // [FIX] Warm Restart: Reset state when ignition goes OFF/ACC/LOCK
                                    if (mIgnitionReady) {
                                        // [Thread Safety] Dispatch to Main Thread
                                        new android.os.Handler(android.os.Looper.getMainLooper()).post(() -> resetIgnitionState());
                                    }
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

                // Start Polling with Retry (Logic Update 2026-01-17)
                pollIgnitionStateWithRetry();

            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register sensor listeners", e);
        }
    }

    private int mIgnitionRetryCount = 0;
    private static final int MAX_IGNITION_RETRIES = 5;

    private void pollIgnitionStateWithRetry() {
        mIgnitionRetryCount = 0;
        Runnable pollRunnable = new Runnable() {
            @Override
            public void run() {
                if (mIgnitionReady || iSensor == null) {
                    return; // Already ready or invalid
                }

                try {
                    int currentIgnition = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_IGNITION_STATE);
                    DebugLogger.i(TAG, "Poll Ignition (" + (mIgnitionRetryCount + 1) + "/" + MAX_IGNITION_RETRIES + "): " + currentIgnition);

                    if (currentIgnition == ISensorEvent.IGNITION_STATE_DRIVING) {
                        handleIgnitionDriving();
                        return; // Success, stop polling
                    }
                } catch (Exception e) {
                    DebugLogger.w(TAG, "Poll Ignition Failed: " + e.getMessage());
                }

                mIgnitionRetryCount++;
                if (mIgnitionRetryCount < MAX_IGNITION_RETRIES) {
                    // Schedule next poll in 1 second
                    new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(this, 1000);
                } else {
                    DebugLogger.i(TAG, "Poll Ignition: Max retries reached. Waiting for passive event.");
                }
            }
        };

        // Execute first poll immediately
        pollRunnable.run();
    }

    // handleIgnitionDriving moved to line 166

    private void registerHeavySensors() {
        if (mHeavySensorsRegistered || iSensor == null)
            return;
        mHeavySensorsRegistered = true;

        DebugLogger.i(TAG, "Registering HEAVY Sensors (Gear, Light, Speed)...");
        try {
            // [Refactor] Use member variable instead of local
            mHeavySensorListener = new ISensor.ISensorListener() {
                @Override
                public void onSensorValueChanged(int sensorType, float value) {
                    try {
                        if (sensorType == SENSOR_TYPE_LIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager
                                    .getInstance(KeepAliveAccessibilityService.this)
                                    .onSensorChanged(sensorType, value);

                        } 
                        // [FIX] Removed DIM_CAR_SPEED handling to prevent conflict with VehicleSensorManager
                        // The dual update was causing pointer jitter.
                        
                        // [FIX] Removed SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER from Float callback.
                        // It is an Event (Int) sensor.
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
                                    // [FIX] Mark initial phase as done if we played a sound (e.g. started in D)
                                    // This prevents the *next* P gear (Parking) from being skipped.
                                    mInitialGearSkipped = true;
                                }
                                // 不管是否播放声音，仪表盘显示始终更新
                                if (android.os.Build.VERSION.SDK_INT >= 30) {
                                    ClusterHudManagerApi30.getInstance(KeepAliveAccessibilityService.this).updateGear(value);
                                } else {
                                    ClusterHudManager.getInstance(KeepAliveAccessibilityService.this).updateGear(value);
                                }
                                mLastGear = value;
                            }
                        } else if (sensorType == ISensor.SENSOR_TYPE_DAY_NIGHT) {
                            cn.navitool.managers.ThemeBrightnessManager
                                    .getInstance(KeepAliveAccessibilityService.this)
                                    .onSensorEventChanged(sensorType, value);
                        } else if (sensorType == SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER) {
                            // [FIX] Correctly handle Passenger Sensor as Event (Int)
                            // 2110210 = Occupied, 2110209 = Empty
                            boolean occupied = (value == SEAT_OCCUPATION_STATUS_OCCUPIED);
                            if (mIsPassengerOccupied != occupied) {
                                mIsPassengerOccupied = occupied;
                                DebugLogger.i(TAG, "Passenger Seat Occupation Changed (Event): " + occupied + " (Val: " + value + ")");
                            }
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
            iSensor.registerListener(mHeavySensorListener, ISensor.SENSOR_TYPE_DAY_NIGHT);
            iSensor.registerListener(mHeavySensorListener, SENSOR_TYPE_GEAR);
            iSensor.registerListener(mHeavySensorListener, SENSOR_TYPE_LIGHT);
            // iSensor.registerListener(mHeavySensorListener, SENSOR_TYPE_DIM_CAR_SPEED); // Removed Conflict
            iSensor.registerListener(mHeavySensorListener, SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER);

            DebugLogger.i(TAG, "Heavy Sensors Registered Successfully (DayNight, Gear, Light, Speed, PassSeat).");

            // Poll Initial Data for these sensors (Delayed 500ms to allow AdaptAPI to
            // fetch)
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(this::pollInitialSensorData, 500);

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register heavy sensors", e);
        }
    }

    private void unregisterHeavySensors() {
        if (iSensor != null && mHeavySensorListener != null && mHeavySensorsRegistered) {
            DebugLogger.i(TAG, "Unregistering Heavy Sensors...");
            try {
                // Must unregister all types we registered
                // [FIX] ISensor.unregisterListener takes only the listener instance and removes it for all types.
                iSensor.unregisterListener(mHeavySensorListener);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to unregister heavy sensors", e);
            }
        }
        mHeavySensorsRegistered = false;
        mHeavySensorListener = null;
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
                if (android.os.Build.VERSION.SDK_INT >= 30) {
                    ClusterHudManagerApi30.getInstance(this).updateGear(gear);
                } else {
                     ClusterHudManager.getInstance(this).updateGear(gear);
                }
                mLastGear = gear;
            } else {
                DebugLogger.w(TAG, "Polled Invalid Gear (0) - Ignoring to prevent default 'P' overwrite");
            }

            // 2. Fuel Level (Value Type - Float, returns ml)
            float fuelMl = iSensor.getSensorLatestValue(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_FUEL);
            DebugLogger.d(TAG, "Polled Fuel: " + fuelMl + " ml");
            float fuelLiters = fuelMl / 1000f;
            ClusterHudManager.getInstance(this).updateFuelWithValue(fuelLiters);

            // 3. Range (Value Type - Float)
            float range = iSensor.getSensorLatestValue(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_RANGE);
            DebugLogger.d(TAG, "Polled Range: " + range);
            ClusterHudManager.getInstance(this).updateRange((int) range + "km");

            // 4. Outside Temp (Value Type - Float)
            float tempOut = iSensor
                    .getSensorLatestValue(cn.navitool.managers.VehicleSensorManager.SENSOR_TYPE_TEMP_OUTDOOR);
            DebugLogger.d(TAG, "Polled TempOut: " + tempOut);
            ClusterHudManager.getInstance(this).updateTempOut(tempOut + "°C");

            // [FIX] 5. Passenger Seat (Event Type)
            // Fixes bug where initial state is unknown if user is already seated
            int passSeat = iSensor.getSensorEvent(SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER);
            DebugLogger.d(TAG, "Polled Passenger Seat: " + passSeat);
            if (passSeat == SEAT_OCCUPATION_STATUS_OCCUPIED) {
                mIsPassengerOccupied = true;
                DebugLogger.i(TAG, "Init: Passenger Seat is OCCUPIED");
            } else if (passSeat == SEAT_OCCUPATION_STATUS_NONE) {
                mIsPassengerOccupied = false;
                DebugLogger.i(TAG, "Init: Passenger Seat is EMPTY");
            }

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

    private void startFloatingBallIfEnabled() {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23 && !android.provider.Settings.canDrawOverlays(this)) {
                DebugLogger.w(TAG, "Cannot start FloatingBall: Overlay Permission Missing");
                return;
            }

            if (ConfigManager.getInstance().getBoolean("floating_ball_enabled", false)) {
                DebugLogger.i(TAG, "Starting FloatingBallService...");
                startService(new Intent(this, cn.navitool.service.FloatingBallService.class));
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error starting FloatingBall", e);
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

    // Sensor ID for Passenger Seat Occupation (Moved to Top)
    private boolean mIsPassengerOccupied = false; // Default to false (Empty)

    private void pollDoorStatus() {
        if (iCarFunction == null)
            return;
        try {
            // Poll all doors is ideal, but let's stick to reactive for now or just poll FR
            // Poll Passenger Door (Zone 4) as it has complex logic
            int val = iCarFunction.getFunctionValue(BCM_FUNC_DOOR, 4);
            if (val == 1) {
                // If open on boot/init, maybe we shouldn't play sound?
                // Logic says: "handleDoorStatus" plays sound if value == 1.
                // We might want to avoid playing sound on service init if door is already open?
                // For now, keep existing behavior (if it was polling, it implies checking current state)
                // Actually, existing code played sound if 1.
                // Let's keep it but maybe we only want to update state?
                // The prompt implies "Sound", so let's stick to logic which triggers sound on event.
                // Polling on init might trigger sound if door is open. That seems to be the intent of "poll".
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to poll door status", e);
        }
    }

    private void handleDoorStatus(int zone, int value) {
        // Only play sound when door opens (value == 1)
        if (value != 1) {
            return;
        }

        DebugLogger.d(TAG, "Door Opened! Zone=" + zone);
        cn.navitool.managers.SoundPromptManager soundMgr = cn.navitool.managers.SoundPromptManager.getInstance(this);

        switch (zone) {
            case ZONE_DOOR_FL: // Driver (1)
                soundMgr.playDoorDriverSound();
                break;

            case ZONE_DOOR_FR: // Passenger (4)
                if (mIsPassengerOccupied) {
                    DebugLogger.d(TAG, "Passenger Door Open & Occupied -> Playing 'Passenger' Sound");
                    soundMgr.playDoorPassengerSound();
                } else {
                    DebugLogger.d(TAG, "Passenger Door Open & Empty -> Playing 'Passenger Empty' Sound");
                    soundMgr.playDoorPassengerEmptySound();
                }
                break;

            case ZONE_DOOR_RL: // Rear Left (16)
                soundMgr.playDoorRearLeftSound();
                break;

            case ZONE_DOOR_RR: // Rear Right (64)
                soundMgr.playDoorRearRightSound();
                break;
            
            case ZONE_DOOR_HOOD: // Hood
                soundMgr.playDoorHoodSound();
                break;
            
            case ZONE_DOOR_REAR: // Trunk
                soundMgr.playDoorTrunkSound();
                break;

            default:
                DebugLogger.d(TAG, "Unknown Door Zone: " + zone);
                break;
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
