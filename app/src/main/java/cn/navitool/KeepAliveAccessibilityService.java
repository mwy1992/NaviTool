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
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;

public class KeepAliveAccessibilityService extends AccessibilityService {

    private static final String TAG = "KeepAliveService";
    private static final String AUTONAVI_PKG = "com.autonavi.amapauto";

    private ICarFunction iCarFunction;
    private ISensor iSensor;

    private final SharedPreferences.OnSharedPreferenceChangeListener prefsListener = (sharedPreferences, key) -> {
        if ("force_auto_day_night".equals(key)) {
            if (sharedPreferences.getBoolean(key, false)) {
                startMonitoring();
            } else {
                stopMonitoring();
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

        // Initial check for auto day/night mode
        if (prefs.getBoolean("force_auto_day_night", false)) {
            startMonitoring();
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
        ContextCompat.registerReceiver(this, configChangeReceiver, filter, ContextCompat.RECEIVER_EXPORTED);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroying, cleaning up resources...");
        stopMonitoring();

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
    private static final int ZONE_ALL = 0x80000000;
    private static final int VALUE_DAYMODE_DAY = 0x20150101;
    private static final int VALUE_DAYMODE_NIGHT = 0x20150102;
    private static final int VALUE_DAYMODE_AUTO = 0x20150103;
    private static final int VALUE_DAYMODE_CUSTOM = 0x20150104;
    private static final int VALUE_DAYMODE_SUNRISE_AND_SUNSET = 0x20150105;

    private final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private boolean mIsMonitoring = false;
    private static final long MONITOR_INTERVAL_MS = 3000;

    private final Runnable mMonitorRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsMonitoring)
                return;
            checkAndForceAutoDayNight();
            mHandler.postDelayed(this, MONITOR_INTERVAL_MS);
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
        checkDayNightStatus(true);
    }

    private void checkDayNightStatus(boolean enforceAuto) {
        new Thread(() -> {
            initCar();
            if (iCarFunction != null) {
                try {
                    int currentMode = iCarFunction.getFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL);

                    // Broadcast status to UI
                    Intent intent = new Intent("cn.navitool.ACTION_DAY_NIGHT_STATUS");
                    intent.putExtra("mode", currentMode);
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
        if (action == 1) { // 启动应用
            String packageName = prefs.getString("wechat_short_press_app", "");
            if (!packageName.isEmpty()) {
                launchApp(packageName);
            }
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
        if (action == 1) { // 启动应用
            String packageName = prefs.getString("wechat_long_press_app", "");
            if (!packageName.isEmpty()) {
                launchApp(packageName);
            }
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
                        registerIgnitionListener();
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to initialize Car AdaptAPI", e);
        }
    }

    private void registerIgnitionListener() {
        try {
            if (iSensor != null) {
                iSensor.registerListener(new ISensor.ISensorListener() {
                    @Override
                    public void onSensorValueChanged(int sensorType, float value) {
                        if (sensorType == ISensor.SENSOR_TYPE_IGNITION_STATE) {
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
                        }
                    }

                    @Override
                    public void onSensorSupportChanged(int sensorType, com.ecarx.xui.adaptapi.FunctionStatus status) {
                    }
                }, ISensor.SENSOR_TYPE_IGNITION_STATE);

                Log.i(TAG, "Ignition listener registered");
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to register ignition listener", e);
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