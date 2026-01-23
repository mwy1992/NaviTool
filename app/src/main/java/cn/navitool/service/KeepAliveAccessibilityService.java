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
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
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
import cn.navitool.utils.MemoryMonitor;
import cn.navitool.managers.AppLaunchManager;

public class KeepAliveAccessibilityService extends AccessibilityService implements VehicleSensorManager.Listener {

    private static final String TAG = "KeepAliveService";
    private static final String AUTONAVI_PKG = "com.autonavi.amapauto";

    private static KeepAliveAccessibilityService instance;

    public static KeepAliveAccessibilityService getInstance() {
        return instance;
    }

    // ... existing fields ...
    // [Refactor] Direct ICarFunction/ISensor fields removed
    // ...

    private boolean mAmapDetected = false; // Gate for Amap Services
    private boolean mIsAmapServicesStarted = false;

    // Dynamic Receiver for ADB Simulation (Avoids Android 8+ Background Execution
    // Limits)
    private SimulateFunction.IgnitionReceiver mSimulateReceiver;

    // ... existing fields ...
    private final SharedPreferences.OnSharedPreferenceChangeListener prefsListener = (sharedPreferences, key) -> {
        if ("force_auto_day_night".equals(key)) {
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

        // initCar(); // Removed, using VehicleSensorManager
    }

    private void startForegroundService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "navitool_service_channel";
            String channelName = "KeepAlive Service";
            NotificationChannel channel = new NotificationChannel(channelId, channelName,
                    android.app.NotificationManager.IMPORTANCE_MIN);
            channel.setDescription("Background service for vehicle assistant");
            android.app.NotificationManager manager = getSystemService(android.app.NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }

            android.app.Notification.Builder builder = new android.app.Notification.Builder(this, channelId)
                    .setContentTitle("NaviTool")
                    .setContentText("车机助手正在运行")
                    .setSmallIcon(cn.navitool.R.drawable.ic_launcher) // Use app icon
                    .setOngoing(true);

            startForeground(1001, builder.build());
            DebugLogger.i(TAG, "Foreground Service Started (ID: 1001)");
        }
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        
        // 1. [New] Start Foreground Service (Priority Boost)
        try {
            startForegroundService();
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to start foreground service", e);
        }

        DebugLogger.action(TAG, "无障碍服务已连接");
        DebugLogger.i(TAG, "Service Connected");

        // [FIX] Notify UI that service is ready (Refresh Permission State)
        sendBroadcast(new Intent("cn.navitool.ACTION_ACCESSIBILITY_CONNECTED"));

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        prefs.registerOnSharedPreferenceChangeListener(prefsListener);
        
        MemoryMonitor.setComponentStatus("KeepAliveService", "Active");

        // 2. [Optimized] Immediate Light Initialization (Keys, PSD, ADB)
        // These are low-overhead and essential for hardware interaction
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

        // 3. [Optimized] Immediate UI Display (Load Shedding Step 1)
        // Ensure UI is visible immediately (T+0s), don't wait for sensors
        DebugLogger.i(TAG, "[Load Shedding] Immediate UI Display triggered");
        ClusterHudManager.getInstance(this).ensureUiVisible();
        // Force Instrument Mode immediately for feedback
        ClusterHudManager.getInstance(this).applyNaviMode(3);

        // 4. [Load Shedding] Delayed Sensor/Heavy Initialization
        // Split heavy tasks to avoid system startup congestion
        
        // Delay 1.5s: Connect Vehicle Sensors (Critical Data)
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            DebugLogger.i(TAG, "[Load Shedding] T+1.5s: Initializing Vehicle Sensors...");
            cn.navitool.managers.VehicleSensorManager.getInstance(this).init();
            cn.navitool.managers.VehicleSensorManager.getInstance(this).registerListener(this);
            checkInitialVehicleState();
        }, 1500);

        // Delay 3.0s: Sync Theme, Sound, Map Services (Non-Critical)
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            DebugLogger.i(TAG, "[Load Shedding] T+3.0s: Initializing Theme/Sound/Maps...");
            cn.navitool.managers.ThemeBrightnessManager.getInstance(this).init();
            cn.navitool.managers.SoundPromptManager.getInstance(this).init();
            
            DebugLogger.logBootEvent(this);
            
             // Start Map Services if conditions met
            checkAndStartMapServices();
        }, 3000);

        DebugLogger.i(TAG, "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        filter.addAction("cn.navitool.ACTION_REQUEST_ONEOS_STATUS");
        filter.addAction("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
        // filter.addAction("cn.navitool.ACTION_SIMULATE_ENGINE_START"); // Now handled by Manifest Receiver
        try {
            registerReceiver(configChangeReceiver, filter);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register configChangeReceiver", e);
        }

        // Register Simulation Receiver dynamically
        try {
            mSimulateReceiver = new SimulateFunction.IgnitionReceiver();
            IntentFilter simFilter = new IntentFilter("cn.navitool.ACTION_SIMULATE_ENGINE_START");
            registerReceiver(mSimulateReceiver, simFilter);
            DebugLogger.i(TAG, "Dynamic SimulateFunction.IgnitionReceiver Registered");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register SimulateFunction.IgnitionReceiver", e);
        }

        // [FIX] 备用悬浮球启动：延迟5秒后检查悬浮球是否已启动
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            if (ConfigManager.getInstance().getBoolean("floating_ball_enabled", false)) {
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
        
        // 2. Unregister Heavy Sensors - Removed (VSM stays active or is managed separately)
        // unregisterHeavySensors(); // Removed
        
        // 3. Notify ClusterHudManager to enter Standby Mode (Clean UI/Cache)
        ClusterHudManager.getInstance(this).enterStandbyMode();
        
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

        // 2. Schedule Heavy Sensor Audio/Logic (Logic managed by VSM mostly now)
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            // [Refactor] registerHeavySensors removed - VSM always listens
            // Just ensure UI is visible and mode applied
            DebugLogger.i(TAG, "Ignition + 3s: Calling ensureUiVisible() directly");
            ClusterHudManager.getInstance(KeepAliveAccessibilityService.this).ensureUiVisible();

            // [FIX] Auto-Switch to Instrument Mode (NaviMode 3)
            DebugLogger.i(TAG, "Ignition + 3s: Auto-Switching to NaviMode 3 (Instrument Mode)");
            ClusterHudManager.getInstance(KeepAliveAccessibilityService.this).applyNaviMode(3);
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
        ClusterHudManager.getInstance(this).destroy();
        cn.navitool.managers.VehicleSensorManager.getInstance(this).unregisterListener(this); // [Refactor] Unregister VSM
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

    // [Refactor] Direct CarServiceManager init removed. Logic moved to VehicleSensorManager.Listener callbacks.
    // mIgnitionReady field is defined below.

    private void checkInitialVehicleState() {
        VehicleSensorManager vsm = VehicleSensorManager.getInstance(this);
        
        // check Ignition
        int ign = vsm.getIgnition();
        if (ign == ISensorEvent.IGNITION_STATE_DRIVING) {
             handleIgnitionDriving();
        }
        
        // Initial Gear
        int gear = vsm.getGear();
        if (gear != 0) {
             ClusterHudManager.getInstance(this).updateGear(gear);
             mLastGear = gear;
        }
        
        // Passenger Seat
        mIsPassengerOccupied = vsm.isSeatOccupied();
    }

    private boolean mIgnitionReady = false;
    private boolean mIsPassengerOccupied = false;
    // [Refactor] Sensor/Function Listeners & Polling Removed - Replaced by VSM Callbacks

    @Override
    public void onIgnitionChanged(int state) {
        DebugLogger.d(TAG, "Ignition State Changed (VSM): " + state);
        mLastIgnition = state;
        if (state == ISensorEvent.IGNITION_STATE_DRIVING) {
            handleIgnitionDriving();
        } else if (state == ISensorEvent.IGNITION_STATE_OFF || 
                   state == ISensorEvent.IGNITION_STATE_ACC || 
                   state == ISensorEvent.IGNITION_STATE_LOCK) {
            if (mIgnitionReady) {
                 new android.os.Handler(android.os.Looper.getMainLooper()).post(() -> resetIgnitionState());
            }
        }
    }

    @Override
    public void onGearChanged(int gear) {
        DebugLogger.d(TAG, "Gear Changed (VSM): " + gear);
        if (mLastGear != gear) {
            boolean isInitialP = !mInitialGearSkipped &&
                    (gear == cn.navitool.managers.SoundPromptManager.GEAR_PARK ||
                            gear == cn.navitool.managers.SoundPromptManager.TRSM_GEAR_PARK);
            if (isInitialP) {
                mInitialGearSkipped = true;
                DebugLogger.d(TAG, "Skipping initial P gear sound");
            } else if (mEngineStarted) {
                cn.navitool.managers.SoundPromptManager
                        .getInstance(this)
                        .playGearSound(gear);
                mInitialGearSkipped = true;
            }
            ClusterHudManager.getInstance(this).updateGear(gear);
            mLastGear = gear;
        }
    }

    @Override
    public void onLightChanged(float light) {
        cn.navitool.managers.ThemeBrightnessManager
                .getInstance(this)
                .onSensorChanged(SENSOR_TYPE_LIGHT, light);
    }
    
    @Override
    public void onDayNightChanged(int mode) {
         cn.navitool.managers.ThemeBrightnessManager
                .getInstance(this)
                .onSensorEventChanged(ISensor.SENSOR_TYPE_DAY_NIGHT, mode);
    }

    @Override
    public void onSeatOccupiedChanged(boolean occupied) {
        if (mIsPassengerOccupied != occupied) {
            mIsPassengerOccupied = occupied;
            DebugLogger.i(TAG, "Passenger Seat Occupation (VSM): " + occupied);
        }
    }

    @Override
    public void onDoorChanged(int zone, int status) {
        DebugLogger.d(TAG, "Door Changed (VSM): Zone=" + zone + ", Status=" + status);
        handleDoorStatus(zone, status);
    }

    @Override
    public void onTurnSignalChanged(boolean isLeft, boolean isOn) {
        // Handled by ClusterHudManager directly listing to VSM, 
        // BUT KeepAlive historically logged it and called ClusterHudManager.
        // Since ClusterHudManager now listens to VSM directly, we DON'T need to forward it here.
        // We can just log it if we want.
    }

    @Override
    public void onCustomizeFunctionChanged(int functionId, int zone, float value) {
        if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
            cn.navitool.managers.ThemeBrightnessManager
                    .getInstance(this)
                    .onCustomizeFunctionValueChanged(functionId, value);
        }
    }

    @Override
    public void onFunctionChanged(int functionId, int zone, int value) {
        if (functionId == FUNC_AVM_STATUS || functionId == FUNC_BRIGHTNESS_DAY
                || functionId == FUNC_BRIGHTNESS_NIGHT || functionId == FUNC_DAYMODE_SETTING) {
            cn.navitool.managers.ThemeBrightnessManager
                    .getInstance(this)
                    .onFunctionValueChanged(functionId, value);
        } else if (functionId == FUNC_PSD_SCREEN_SWITCH) {
             cn.navitool.managers.PsdManager.getInstance(this).onPsdStatusChanged(value);
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



    private void pollDoorStatus() {
         // [Refactor] Door polling removed - relying on VSM callbacks and init
    }

    // pollDoorStatus removed

    private void handleDoorStatus(int zone, int value) {
        // [KX11-A2 Sync] Support both Open and Close sounds
        // value == 1 (Open), value == 0 (Close)
        
        cn.navitool.managers.SoundPromptManager soundMgr = cn.navitool.managers.SoundPromptManager.getInstance(this);

        if (value == 1) {
            // --- OPEN Logic ---
            DebugLogger.d(TAG, "Door Opened! Zone=" + zone);
            switch (zone) {
                case ZONE_DOOR_FL: // Driver
                    soundMgr.playDoorDriverSound();
                    break;
                case ZONE_DOOR_FR: // Passenger
                    // Open logic: Can check occupancy, but typically 'open' sound is same?
                    // User said "Passenger also has occupation detection".
                    // Assuming occupation detection applies to interactions.
                    if (mIsPassengerOccupied) {
                         soundMgr.playDoorPassengerSound();
                    } else {
                         soundMgr.playDoorPassengerEmptySound();
                    }
                    break;
                case ZONE_DOOR_RL: soundMgr.playDoorRearLeftSound(); break;
                case ZONE_DOOR_RR: soundMgr.playDoorRearRightSound(); break;
                case ZONE_DOOR_HOOD: soundMgr.playDoorHoodSound(); break;
                case ZONE_DOOR_REAR: soundMgr.playDoorTrunkSound(); break;
            }
        } else if (value == 0) {
            // --- CLOSE Logic ---
            DebugLogger.d(TAG, "Door Closed! Zone=" + zone);
            switch (zone) {
                case ZONE_DOOR_FL: // Driver
                    soundMgr.playDoorDriverCloseSound();
                    break;
                case ZONE_DOOR_FR: // Passenger
                    if (mIsPassengerOccupied) {
                        DebugLogger.d(TAG, "Passenger Door Closed & Occupied");
                        soundMgr.playDoorPassengerCloseSound();
                    } else {
                        DebugLogger.d(TAG, "Passenger Door Closed & Empty");
                        soundMgr.playDoorPassengerEmptyCloseSound();
                    }
                    break;
                case ZONE_DOOR_RL: soundMgr.playDoorRearLeftCloseSound(); break;
                case ZONE_DOOR_RR: soundMgr.playDoorRearRightCloseSound(); break;
                case ZONE_DOOR_HOOD: soundMgr.playDoorHoodCloseSound(); break;
                case ZONE_DOOR_REAR: soundMgr.playDoorTrunkCloseSound(); break;
            }
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
                // [FIX] Force sync on broadcast to ensure we catch system UI changes reliably
                cn.navitool.managers.ThemeBrightnessManager.getInstance(KeepAliveAccessibilityService.this)
                        .syncAutoNaviTheme();
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
