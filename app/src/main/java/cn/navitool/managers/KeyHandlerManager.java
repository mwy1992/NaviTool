package cn.navitool.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.KeyEvent;
import cn.navitool.AdbShell;
import cn.navitool.DebugLogger;
import cn.navitool.R;

public class KeyHandlerManager {
    private static final String TAG = "KeyHandlerManager";
    private static volatile KeyHandlerManager instance;
    private Context mContext;
    private final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    // OneOS API
    private com.geely.lib.oneosapi.IServiceManager mOneOSServiceManager;
    private com.geely.lib.oneosapi.input.IInputManager mOneOSInputManager;
    private com.geely.lib.oneosapi.input.IInputListener mOneOSInputListener;
    private int mRetryCount = 0;
    private static final int MAX_RETRIES = 40;

    // Constants
    private static final String ACTION_ONEOS_STATUS = "cn.navitool.ACTION_ONEOS_STATUS";
    private static final String ACTION_REQUEST_ONEOS_STATUS = "cn.navitool.ACTION_REQUEST_ONEOS_STATUS";

    // Media Keys
    private static final int KEYCODE_MEDIA_NEXT = 87; // Android default
    private static final int KEYCODE_MEDIA_PREVIOUS = 88;
    private static final int KEYCODE_MEDIA_PLAY_PAUSE = 85;

    // OneOS Key Codes
    private static final int ONEOS_KEY_MEDIA_NEXT = 200087;
    private static final int ONEOS_KEY_MEDIA_PREV = 200088;
    private static final int ONEOS_KEY_MEDIA_PP = 200085;
    private static final int ONEOS_KEY_WECHAT = 200400;

    private KeyHandlerManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static KeyHandlerManager getInstance(Context context) {
        if (instance == null) {
            synchronized (KeyHandlerManager.class) {
                if (instance == null) {
                    instance = new KeyHandlerManager(context);
                }
            }
        }
        return instance;
    }

    public void init() {
        DebugLogger.i(TAG, "KeyHandlerManager Initializing...");
        bindOneOSService();
    }

    public void destroy() {
        DebugLogger.i(TAG, "KeyHandlerManager Destroying...");
        try {
            if (mOneOSServiceManager != null) {
                mContext.unbindService(mOneOSConnection);
                mOneOSServiceManager = null;
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error unbinding OneOS service", e);
        }
    }

    // --- OneOS Service Binding ---

    private final ServiceConnection mOneOSConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DebugLogger.i(TAG, "OneOSApiService Connected!");
            DebugLogger.toast(mContext, "OneOS 服务已连接");

            try {
                if (service == null) {
                    DebugLogger.e(TAG, "Service IBinder is NULL!");
                    return;
                }

                mOneOSServiceManager = com.geely.lib.oneosapi.IServiceManager.Stub.asInterface(service);

                if (mOneOSServiceManager != null) {
                    DebugLogger.i(TAG, "IServiceManager obtained successfully");
                    mRetryCount = 0;
                    mOneOSInputManager = null;
                    tryGetInputManager();
                    broadcastOneOSStatus(true);
                } else {
                    DebugLogger.e(TAG, "IServiceManager.Stub.asInterface returned NULL!");
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error in OneOS Service Connected", e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            DebugLogger.i(TAG, "OneOSApiService Disconnected");
            mOneOSServiceManager = null;
            mOneOSInputManager = null;
            broadcastOneOSStatus(false);
        }
    };

    private void bindOneOSService() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.geely.service.oneosapi", "com.geely.service.oneosapi.OneOSApiService");
            boolean bound = mContext.bindService(intent, mOneOSConnection, Context.BIND_AUTO_CREATE);
            if (bound) {
                DebugLogger.toast(mContext, "OneOS 服务绑定成功，等待连接...");
            } else {
                DebugLogger.e(TAG, "bindService() returned FALSE");
                DebugLogger.toast(mContext, "OneOS 服务绑定失败！");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Exception binding OneOS", e);
        }
    }

    public void broadcastOneOSStatus(boolean isConnected) {
        Intent intent = new Intent(ACTION_ONEOS_STATUS);
        intent.putExtra("is_connected", isConnected);
        mContext.sendBroadcast(intent);
    }

    public boolean isOneOSConnected() {
        return mOneOSServiceManager != null;
    }

    private void tryGetInputManager() {
        if (mOneOSServiceManager == null)
            return;
        if (mOneOSInputManager != null)
            return;

        try {
            IBinder inputBinder = mOneOSServiceManager.getService(8); // Type 8
            if (inputBinder != null) {
                mOneOSInputManager = com.geely.lib.oneosapi.input.IInputManager.Stub.asInterface(inputBinder);
                DebugLogger.i(TAG, "IInputManager obtained");
                registerOneOSListener();
            } else {
                if (mRetryCount < MAX_RETRIES) {
                    mRetryCount++;
                    mHandler.postDelayed(this::tryGetInputManager, 500);
                } else {
                    DebugLogger.e(TAG, "Failed to get InputManager after max retries");
                }
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error getting InputManager", e);
        }
    }

    private void registerOneOSListener() {
        if (mOneOSInputManager == null)
            return;
        try {
            int[] keyCodes = { ONEOS_KEY_MEDIA_NEXT, ONEOS_KEY_MEDIA_PREV, ONEOS_KEY_MEDIA_PP, ONEOS_KEY_WECHAT };
            if (mOneOSInputListener == null) {
                mOneOSInputListener = new com.geely.lib.oneosapi.input.IInputListener.Stub() {
                    @Override
                    public void onKeyEvent(int keyCode, int event, int keyController) throws RemoteException {
                        int currentIndex = -1;
                        if (mOneOSInputManager != null) {
                            try {
                                currentIndex = mOneOSInputManager.getControlIndex();
                            } catch (Exception e) {
                                DebugLogger.e(TAG, "Failed to get control index", e);
                            }
                        }
                        if (event == 1 && currentIndex == 2) { // ACTION_UP & Media Mode
                            if (keyCode == ONEOS_KEY_MEDIA_NEXT || keyCode == ONEOS_KEY_MEDIA_PREV
                                    || keyCode == ONEOS_KEY_MEDIA_PP) {
                                handleShortClick(keyCode);
                            }
                        }
                    }

                    @Override
                    public void onShortClick(int keyCode, int keyController) throws RemoteException {
                        if (keyCode == ONEOS_KEY_WECHAT) {
                            DebugLogger.toast(mContext, "微信按键短按");
                            handleShortClick(keyCode);
                        }
                    }

                    @Override
                    public void onLongPressTriggered(int keyCode, int keyController) throws RemoteException {
                        if (keyCode == ONEOS_KEY_WECHAT) {
                            DebugLogger.toast(mContext, "微信按键长按");
                            handleLongPress(keyCode);
                        }
                    }

                    @Override
                    public void onHoldingPressStarted(int keyCode, int keyController) {
                    }

                    @Override
                    public void onHoldingPressStopped(int keyCode, int keyController) {
                    }

                    @Override
                    public void onDoubleClick(int keyCode, int keyController) {
                    }
                };
            }
            mOneOSInputManager.registerListener(mOneOSInputListener, mContext.getPackageName(), keyCodes);
            DebugLogger.i(TAG, "OneOS Listener Registered");
            DebugLogger.toast(mContext, "OneOS 监听已注册");
        } catch (Exception e) {
            DebugLogger.e(TAG, "OneOS Register Failed", e);
        }
    }

    // --- Key Handling Logic ---

    public void handleShortClick(int keyCode) {
        DebugLogger.i(TAG, "handleShortClick: " + keyCode);

        if (keyCode == ONEOS_KEY_MEDIA_NEXT || keyCode == ONEOS_KEY_MEDIA_PREV || keyCode == ONEOS_KEY_MEDIA_PP) {
            SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
            if (!prefs.getBoolean("steering_wheel_control_v2", false)) {
                DebugLogger.d(TAG, "Steering wheel control disabled");
                return;
            }
        }

        switch (keyCode) {
            case ONEOS_KEY_MEDIA_NEXT:
                simulateMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT);
                break;
            case ONEOS_KEY_MEDIA_PREV:
                simulateMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
                break;
            case ONEOS_KEY_MEDIA_PP:
                simulateMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
                break;
            case ONEOS_KEY_WECHAT:
                handleWechatShortPress();
                break;
        }
    }

    public void handleLongPress(int keyCode) {
        if (keyCode == ONEOS_KEY_WECHAT) {
            handleWechatLongPress();
        }
    }

    private void handleWechatShortPress() {
        processWechatAction("short");
    }

    private void handleWechatLongPress() {
        processWechatAction("long");
    }

    private void processWechatAction(String type) {
        SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        if (!prefs.getBoolean("wechat_button_enabled_v2", false))
            return;

        int action = prefs.getInt("wechat_" + type + "_press_action", 0);
        String packageName = prefs.getString("wechat_" + type + "_press_app", "");

        if (packageName.isEmpty()) {
            DebugLogger.toast(mContext, "请先设置微信按键关联应用");
            return;
        }

        if (action == 1) { // Launch
            launchApp(packageName);
        } else if (action == 2) { // Kill
            killApp(packageName);
        }
    }

    private void launchApp(String packageName) {
        try {
            android.content.pm.PackageManager pm = mContext.getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(packageName);
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                DebugLogger.toast(mContext, "正在启动: " + packageName);
            } else {
                DebugLogger.toast(mContext, "启动失败: 未找到应用 " + packageName);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Launch App Failed", e);
        }
    }

    private void killApp(String packageName) {
        if (packageName == null || packageName.isEmpty())
            return;

        if (AdbShell.getInstance(mContext).isConnected()) {
            AdbShell.getInstance(mContext).exec("am force-stop " + packageName);
            DebugLogger.toast(mContext, "已结束应用: " + packageName);
            return;
        }

        try {
            android.app.ActivityManager am = (android.app.ActivityManager) mContext
                    .getSystemService(Context.ACTIVITY_SERVICE);
            if (am != null) {
                am.killBackgroundProcesses(packageName);
                DebugLogger.toast(mContext, "已结束应用 (后台): " + packageName);
            }
        } catch (Exception e) {
            DebugLogger.toast(mContext, "结束应用失败: " + e.getMessage());
        }
    }

    private void simulateMediaKey(int keyCode) {
        long eventTime = android.os.SystemClock.uptimeMillis();
        KeyEvent keyDown = new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_DOWN, keyCode, 0);
        dispatchMediaKey(keyDown);
        KeyEvent keyUp = new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_UP, keyCode, 0);
        dispatchMediaKey(keyUp);

        DebugLogger.toast(mContext, "模拟媒体按键: " + keyCode);
    }

    private void dispatchMediaKey(KeyEvent keyEvent) {
        android.media.AudioManager audioManager = (android.media.AudioManager) mContext
                .getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.dispatchMediaKeyEvent(keyEvent);
        }

        Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaIntent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        mediaIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        mediaIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        mContext.sendBroadcast(mediaIntent);
    }
}
