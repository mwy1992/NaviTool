package cn.navitool.managers;

import android.content.Context;
import cn.navitool.DebugLogger;
import com.ecarx.xui.adaptapi.car.Car;
import com.ecarx.xui.adaptapi.car.ICar;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;

public class CarServiceManager {
    private static final String TAG = "CarServiceManager";
    private static CarServiceManager instance;
    private Context mContext;

    private ICar mCar;
    private ICarFunction mCarFunction;
    private ISensor mSensor;

    private boolean mIsInitialized = false;

    private CarServiceManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized CarServiceManager getInstance(Context context) {
        if (instance == null) {
            instance = new CarServiceManager(context);
        }
        return instance;
    }

    private final java.util.List<ICarServiceListener> mListeners = new java.util.ArrayList<>();
    private final android.os.Handler mInitHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private static final int RETRY_INTERVAL_MS = 5000;
    private int mRetryCount = 0;

    public interface ICarServiceListener {
        void onCarServiceReady();
    }

    public void registerListener(ICarServiceListener listener) {
        if (!mListeners.contains(listener)) {
            mListeners.add(listener);
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

        try {
            mCar = Car.create(mContext); // Suspicious blocking call

            if (mCar != null) {
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

                mIsInitialized = true;
                DebugLogger.i(TAG, "Car AdaptAPI initialized successfully");
                notifyListeners();
            } else {
                DebugLogger.e(TAG, "Failed to create Car instance. Retrying in " + (RETRY_INTERVAL_MS / 1000) + "s...");
                scheduleRetry();
            }
        } catch (Throwable e) {
            DebugLogger.e(TAG, "Failed to initialize Car AdaptAPI: " + e.getMessage() + ". Retrying...");
            scheduleRetry();
        }
    }

    private void scheduleRetry() {
        mInitHandler.removeCallbacksAndMessages(null);
        mInitHandler.postDelayed(() -> {
            mRetryCount++;
            DebugLogger.d(TAG, "Retrying Car Service Init (Attempt " + mRetryCount + ")...");
            init();
        }, RETRY_INTERVAL_MS);
    }

    private void notifyListeners() {
        for (ICarServiceListener listener : mListeners) {
            try {
                listener.onCarServiceReady();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error notifying listener", e);
            }
        }
    }

    public ICarFunction getCarFunction() {
        return mCarFunction;
    }

    public ISensor getSensor() {
        return mSensor;
    }

    public ICar getCar() {
        return mCar;
    }

    public boolean isInitialized() {
        return mIsInitialized;
    }
}
