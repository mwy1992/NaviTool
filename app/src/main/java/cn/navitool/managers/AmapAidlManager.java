package cn.navitool.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.autonavi.amapauto.protocol.connector.IProtocolAidlInterface;
import com.autonavi.amapauto.protocol.connector.IProtocolCallBackInterface;
import com.autonavi.amapauto.protocol.model.base.ProtocolModel;
import com.autonavi.amapauto.protocol.model.service.ProtocolErrorModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cn.navitool.DebugLogger;

public class AmapAidlManager {
    private static final String TAG = "AmapAidlManager";
    private static final String SERVICE_ACTION = "com.autonavi.amapauto.protocolService";
    private static final String SERVICE_PACKAGE = "com.autonavi.amapauto";
    private static final String LOG_FILENAME = "amap_aidl.txt";

    // Hardcoded auth key found in analysis
    private static final String AUTH_KEY = "AlSimulate";

    private static volatile AmapAidlManager instance;
    private Context mContext;
    private IProtocolAidlInterface mService;
    private boolean mIsBound = false;
    private boolean mIsIntentionalDisconnect = false;
    private static final int RECONNECT_DELAY_MS = 5000;
    private int mRetryCount = 0;
    private static final int MAX_RETRIES = 10;
    private final Handler mMainHandler = new Handler(android.os.Looper.getMainLooper());

    private final Runnable mReconnectRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsBound && !mIsIntentionalDisconnect) {
                if (mRetryCount < MAX_RETRIES) {
                    mRetryCount++;
                    DebugLogger.i(TAG, "Attempting reconnection (Try " + mRetryCount + "/" + MAX_RETRIES + ")...");
                    logToFile("Attempting reconnection (Try " + mRetryCount + ")...");
                    connect();
                } else {
                    DebugLogger.e(TAG, "Max retries reached. Giving up reconnection.");
                    logToFile("Max retries reached. Giving up.");
                    mRetryCount = 0;
                }
            }
        }
    };

    // Async Logging Handler
    private HandlerThread mLogThread;
    private Handler mLogHandler;

    private AmapAidlManager(Context context) {
        this.mContext = context.getApplicationContext();
        initLogThread();
    }

    private void initLogThread() {
        mLogThread = new HandlerThread("AmapAidlLogThread");
        mLogThread.start();
        mLogHandler = new Handler(mLogThread.getLooper());
    }

    public static AmapAidlManager getInstance(Context context) {
        if (instance == null) {
            synchronized (AmapAidlManager.class) {
                if (instance == null) {
                    instance = new AmapAidlManager(context);
                }
            }
        }
        return instance;
    }

    public void connect() {
        if (mIsBound) {
            DebugLogger.e(TAG, "Already bound to Amap AIDL Service.");
            return;
        }
        mIsIntentionalDisconnect = false;
        mMainHandler.removeCallbacks(mReconnectRunnable);

        Intent intent = new Intent();
        intent.setAction(SERVICE_ACTION);
        intent.setPackage(SERVICE_PACKAGE);

        try {
            boolean result = mContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
            String msg = "Binding to Amap AIDL Service result: " + result;
            DebugLogger.e(TAG, msg);
            logToFile(msg);

            if (!result) {
                DebugLogger.e(TAG, "Bind failed. Is Amap Auto installed and version compatible?");
                logToFile("Bind failed. Is Amap Auto installed?");
                if (!mIsIntentionalDisconnect) {
                    mMainHandler.postDelayed(mReconnectRunnable, RECONNECT_DELAY_MS);
                }
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Bind exception", e);
            logToFile("Bind exception: " + e.getMessage());
        }
    }

    public void disconnect() {
        mIsIntentionalDisconnect = true; // Mark as intentional
        mMainHandler.removeCallbacks(mReconnectRunnable);
        if (mIsBound) {
            try {
                mContext.unbindService(mConnection);
                mIsBound = false;
                mService = null;
                String msg = "Unbound from Amap AIDL Service.";
                DebugLogger.e(TAG, msg);
                logToFile(msg);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Unbind exception", e);
                logToFile("Unbind exception: " + e.getMessage());
            }
        }
    }

    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            String msg = "onServiceConnected: " + name;
            DebugLogger.e(TAG, msg);
            logToFile(msg);
            mService = IProtocolAidlInterface.Stub.asInterface(service);
            mIsBound = true;
            mRetryCount = 0; // Reset retry count on success

            performHandshakeAndRegister();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            String msg = "onServiceDisconnected: " + name;
            DebugLogger.e(TAG, msg);
            logToFile(msg);
            mService = null;
            mIsBound = false;

            if (!mIsIntentionalDisconnect) {
                DebugLogger.w(TAG, "Service disconnected unexpectedly! Scheduling reconnect...");
                logToFile("Unexpected disconnection. Reconnecting in " + (RECONNECT_DELAY_MS / 1000) + "s...");
                mMainHandler.postDelayed(mReconnectRunnable, RECONNECT_DELAY_MS);
            }
        }
    };

    private void performHandshakeAndRegister() {
        if (mService == null)
            return;

        try {
            // 1. Authentication / Handshake (Method ID 7)
            boolean authResult = mService.r(AUTH_KEY);
            String authMsg = "Handshake (r) result: " + authResult;
            DebugLogger.e(TAG, authMsg);
            logToFile(authMsg);

            // 2. Register Callback (Method ID 5 - b)
            mService.b(mContext.getPackageName(), mCallback);
            String regMsg = "Registered callback via method 'b' for package: " + mContext.getPackageName();
            DebugLogger.e(TAG, regMsg);
            logToFile(regMsg);

            // 3. Send Test Requests
            sendTestRequest();

        } catch (android.os.DeadObjectException e) {
            DebugLogger.e(TAG, "DeadObjectException during handshake", e);
            logToFile("DeadObjectException: Service died.");
            mService = null;
            mIsBound = false;
            // Trigger reconnect logic handled by onServiceDisconnected usually, but safe to
            // ensure
            if (!mIsIntentionalDisconnect) {
                mMainHandler.postDelayed(mReconnectRunnable, RECONNECT_DELAY_MS);
            }
        } catch (RemoteException e) {
            DebugLogger.e(TAG, "RemoteException during handshake/register", e);
            logToFile("RemoteException during handshake/register: " + e.getMessage());
        }
    }

    private void sendTestRequest() {
        if (mService == null)
            return;
        try {
            // Test 1: Vehicle State
            com.autonavi.amapauto.protocol.model.service.ReqGetVehicleStateModel req1 = new com.autonavi.amapauto.protocol.model.service.ReqGetVehicleStateModel();
            req1.type = 1;

            ProtocolModel wrapper1 = new ProtocolModel();
            wrapper1.data = req1;

            int result1 = mService.f(wrapper1);
            String msg1 = "Sent ReqGetVehicleStateModel (type 1), Result: " + result1;
            DebugLogger.e(TAG, msg1);
            logToFile(msg1);

            // Test 2: Bring to Foreground (Visible Effect)
            com.autonavi.amapauto.protocol.model.service.ReqBringAutoToForegroundModel req2 = new com.autonavi.amapauto.protocol.model.service.ReqBringAutoToForegroundModel();

            ProtocolModel wrapper2 = new ProtocolModel();
            wrapper2.data = req2;

            int result2 = mService.f(wrapper2);
            String msg2 = "Sent ReqBringAutoToForegroundModel, Result: " + result2;
            DebugLogger.e(TAG, msg2);
            logToFile(msg2);

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to send test request", e);
            logToFile("Failed to send test request: " + e.getMessage());
        }
    }

    private final IProtocolCallBackInterface mCallback = new IProtocolCallBackInterface.Stub() {
        @Override
        public void onReceiveProtocolModel(ProtocolModel model) throws RemoteException {
            if (model != null && model.data != null) {
                String msg = "AIDL onReceiveProtocolModel received: " + model.data.getClass().getName();
                DebugLogger.e(TAG, msg);
                logToFile(msg + "\nData: " + model.data.toString());
            } else {
                String msg = "AIDL onReceiveProtocolModel received null or empty model";
                DebugLogger.e(TAG, msg);
                logToFile(msg);
            }
        }

        @Override
        public void onReceiveErrorModel(ProtocolErrorModel errorModel) throws RemoteException {
            if (errorModel != null) {
                String msg = "AIDL onReceiveErrorModel received: " + errorModel.resultCode + ", "
                        + errorModel.errorMessage;
                DebugLogger.e(TAG, msg);
                logToFile(msg);
            }
        }

        @Override
        public void onReceiveProtocolModelE(ProtocolModel model) throws RemoteException {
            if (model != null && model.data != null) {
                String msg = "AIDL onReceiveProtocolModelE received: " + model.data.getClass().getName();
                DebugLogger.e(TAG, msg);
                logToFile(msg + "\nData: " + model.data.toString());
            }
        }

        @Override
        public void onReceiveJson(String json) throws RemoteException {
            String msg = "AIDL onReceiveJson received JSON: " + json;
            DebugLogger.e(TAG, msg);
            logToFile(msg);
        }

        @Override
        public void onReceiveJsonResult(String jsonResult) throws RemoteException {
            String msg = "AIDL onReceiveJsonResult received JSON: " + jsonResult;
            DebugLogger.e(TAG, msg);
            logToFile(msg);
        }
    };

    private void logToFile(String content) {
        if (mLogHandler == null)
            return;

        mLogHandler.post(() -> {
            File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, LOG_FILENAME);
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
            String finalLog = timestamp + "\n" + content + "\n--------------------------------\n";

            try (FileOutputStream fos = new FileOutputStream(file, true)) {
                fos.write(finalLog.getBytes());
            } catch (IOException e) {
                Log.e(TAG, "Failed to write Amap AIDL log to file", e);
            }
        });
    }
}
