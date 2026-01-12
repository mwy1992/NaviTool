package cn.navitool.managers;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.ecarx.xui.adaptapi.car.base.ICarFunction;

import cn.navitool.DebugLogger;
import cn.navitool.KeepAliveAccessibilityService;

public class WelcomeLampManager {
    private static final String TAG = "WelcomeLampManager";
    private static WelcomeLampManager instance;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    // Welcome Light Control Constants
    // Switch Control: Property 33236 (ECarXCarAmbliManager.CB_WelcomeLight)
    private static final int FUNC_WELCOME_LIGHT_SWITCH = 33236;
    // Mode Control: Function 721617408 (GlyCarPropertyValue.WELCOME_LIGHT_MODE)
    private static final int FUNC_WELCOME_LIGHT_MODE = 721617408;

    private static final int ZONE_DRIVER = 1; // Usually 1 for main driver or general switch
    private static final int VALUE_ON = 1;

    // Interval for checking/enforcing the state
    private static final int LOOP_INTERVAL_MS = 5000;

    private boolean mIsAlwaysOnEnabled = false;
    private Runnable mLoopRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsAlwaysOnEnabled) {
                return;
            }
            enforceWelcomeLightOn();
            if (mHandler != null) {
                mHandler.postDelayed(this, LOOP_INTERVAL_MS);
            }
        }
    };

    private WelcomeLampManager(Context context) {
        this.mContext = context.getApplicationContext();
        mHandlerThread = new HandlerThread("WelcomeLampThread");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    public static synchronized WelcomeLampManager getInstance(Context context) {
        if (instance == null) {
            instance = new WelcomeLampManager(context);
        }
        return instance;
    }

    public void setEnabled(boolean enabled) {
        if (mIsAlwaysOnEnabled == enabled) {
            return;
        }
        mIsAlwaysOnEnabled = enabled;
        DebugLogger.i(TAG, "Welcome Lamp Always On: " + enabled);

        if (enabled) {
            // Start enforcement loop
            if (mHandler != null) {
                mHandler.removeCallbacks(mLoopRunnable);
                mHandler.post(mLoopRunnable);
            }
        } else {
            // Stop loop
            if (mHandler != null) {
                mHandler.removeCallbacks(mLoopRunnable);
            }
        }
    }

    private void enforceWelcomeLightOn() {
        try {
            ICarFunction carFunction = KeepAliveAccessibilityService.getInstance().getCarFunction();
            if (carFunction != null) {
                // Set Switch to ON
                // Note: CB_WelcomeLight uses setIntProperty(33236, 1, 1).
                // The third param is value, second is likely zone.
                // Based on analysis: mMgr.setIntProperty(33236, 1, paramInt)
                carFunction.setFunctionValue(FUNC_WELCOME_LIGHT_SWITCH, ZONE_DRIVER, VALUE_ON);
                // DebugLogger.d(TAG, "Enforced Welcome Light ON");
            } else {
                DebugLogger.w(TAG, "ICarFunction is null, cannot set property");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error setting Welcome Light", e);
        }
    }
}
