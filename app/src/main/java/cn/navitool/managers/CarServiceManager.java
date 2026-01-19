package cn.navitool.managers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import cn.navitool.utils.DebugLogger;
import com.ecarx.xui.adaptapi.binder.IConnectable;
import com.ecarx.xui.adaptapi.car.Car;
import com.ecarx.xui.adaptapi.car.ICar;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;
import com.ecarx.xui.adaptapi.car.hev.IHev;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;

import java.util.ArrayList;
import java.util.List;

public class CarServiceManager implements IConnectable.IConnectWatcher {
    private static final String TAG = "CarServiceManager";
    private static volatile CarServiceManager instance;
    private Context mContext;

    private ICar mCar;
    private ICarFunction mCarFunction;
    private ISensor mSensor;
    private IHev mHev;

    private boolean mIsInitialized = false;
    private boolean mIsConnecting = false;

    private CarServiceManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static CarServiceManager getInstance(Context context) {
        if (instance == null) {
            synchronized (CarServiceManager.class) {
                if (instance == null) {
                    instance = new CarServiceManager(context);
                }
            }
        }
        return instance;
    }

    private final List<ICarServiceListener> mListeners = new ArrayList<>();
    private final Handler mInitHandler = new Handler(Looper.getMainLooper());
    private static final int RETRY_INTERVAL_MS = 5000;
    private int mRetryCount = 0;

    public interface ICarServiceListener {
        void onCarServiceReady();
    }

    public void registerListener(ICarServiceListener listener) {
        synchronized (mListeners) {
            if (!mListeners.contains(listener)) {
                mListeners.add(listener);
            }
        }
        // If already initialized, notify immediately
        if (mIsInitialized) {
            listener.onCarServiceReady();
        }
    }

    public void init() {
        if (mIsInitialized) {
            DebugLogger.d(TAG, "CarServiceManager already initialized");
            return;
        }
        if (mIsConnecting) {
            DebugLogger.d(TAG, "CarServiceManager already connecting...");
            return;
        }

        mIsConnecting = true;
        try {
            // AdaptAPI initialization is ASYNC. We must create the instance and wait for
            // connection.
            mCar = Car.create(mContext);

            if (mCar != null) {
                if (mCar instanceof IConnectable) {
                    ((IConnectable) mCar).registerConnectWatcher(this);
                    ((IConnectable) mCar).connect(); // Prompt connection
                    DebugLogger.i(TAG, "Registered ConnectWatcher and requested connection...");
                } else {
                    // Fallback for older API versions if they are synchronous (Unlikely for
                    // AdaptAPI)
                    // But if it doesn't implement IConnectable, we try urgent init
                    DebugLogger.w(TAG, "Car instance does not implement IConnectable, trying direct init...");
                    onConnected();
                }
            } else {
                DebugLogger.e(TAG,
                        "Failed to create Car instance (null). Retrying in " + (RETRY_INTERVAL_MS / 1000) + "s...");
                scheduleRetry();
            }
        } catch (Throwable e) {
            DebugLogger.e(TAG, "Failed to initialize Car AdaptAPI: " + e.getMessage() + ". Retrying...");
            scheduleRetry();
        }
    }

    private void scheduleRetry() {
        mIsConnecting = false;
        mInitHandler.removeCallbacksAndMessages(null);
        mInitHandler.postDelayed(() -> {
            mRetryCount++;
            DebugLogger.d(TAG, "Retrying Car Service Init (Attempt " + mRetryCount + ")...");
            init();
        }, RETRY_INTERVAL_MS);
    }

    @Override
    public void onConnected() {
        DebugLogger.i(TAG, "AdaptAPI Service Connected!");
        mInitHandler.post(() -> {
            try {
                if (mCar == null)
                    return;

                mCarFunction = mCar.getICarFunction();

                if (mCar instanceof ISensor) {
                    mSensor = (ISensor) mCar;
                }

                try {
                    if (mSensor == null) {
                        java.lang.reflect.Method method = mCar.getClass().getMethod("getSensorManager");
                        mSensor = (ISensor) method.invoke(mCar);
                    }
                } catch (Exception ex) {
                    DebugLogger.w(TAG, "getSensorManager not found via reflection");
                }

                // [NEW] Get Hev Manager (Trip Data)
                try {
                    mHev = mCar.getHevManager();
                } catch (Exception e) {
                     DebugLogger.w(TAG, "Failed to getHevManager: " + e.getMessage());
                }

                if (mCarFunction != null || mSensor != null || mHev != null) {
                    mIsInitialized = true;
                    mIsConnecting = false;
                    DebugLogger.i(TAG, "Car AdaptAPI components retrieved successfully");
                    notifyListeners();
                } else {
                    DebugLogger.e(TAG, "Connected but failed to get managers? Retrying...");
                    scheduleRetry();
                }

            } catch (Exception e) {
                DebugLogger.e(TAG, "Error during onConnected init", e);
                scheduleRetry();
            }
        });
    }

    @Override
    public void onDisConnected() {
        DebugLogger.w(TAG, "AdaptAPI Service Disconnected!");
        mIsInitialized = false;
        mIsConnecting = false;
        // Optional: schedule retry or wait for reconnect?
        // Usually AdaptAPI handles reconnect, but we mark as uninitialized.
    }

    private void notifyListeners() {
        synchronized (mListeners) {
            for (ICarServiceListener listener : mListeners) {
                try {
                    listener.onCarServiceReady();
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Error notifying listener", e);
                }
            }
        }
    }

    public ICarFunction getCarFunction() {
        return mCarFunction;
    }

    public ISensor getSensor() {
        return mSensor;
    }

    public IHev getHevManager() {
        return mHev;
    }

    public ICar getCar() {
        return mCar;
    }

    public boolean isInitialized() {
        return mIsInitialized;
    }
}
