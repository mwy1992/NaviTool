package cn.navitool.managers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;

import cn.navitool.DebugLogger;
import cn.navitool.R;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;
import com.ecarx.xui.adaptapi.car.vehicle.IPAS;
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle;

public class ThemeBrightnessManager {
    private static final String TAG = "ThemeManager";
    private static ThemeBrightnessManager instance;
    private Context mContext;

    // Constants
    private static final int FUNC_DAYMODE_SETTING = 0x20150100;
    private static final int FUNC_BRIGHTNESS_DAY = IVehicle.SETTING_FUNC_BRIGHTNESS_DAY;
    private static final int FUNC_BRIGHTNESS_NIGHT = IVehicle.SETTING_FUNC_BRIGHTNESS_NIGHT;
    private static final int FUNC_AVM_STATUS = IPAS.PAS_FUNC_PAC_ACTIVATION;
    private static final int FUNC_BRIGHTNESS_DAYMODE = 688062976;
    private static final int ZONE_ALL = 0x80000000;
    private static final int ZONE_CSD = 1;
    private static final int SENSOR_TYPE_LIGHT = 0x200F00;
    private static final int VALUE_DAYMODE_DAY = 0x20150101;
    private static final int VALUE_DAYMODE_NIGHT = 0x20150102;
    private static final int VALUE_DAYMODE_AUTO = 0x20150103;
    private static final String AUTONAVI_PKG = "com.autonavi.amapauto";

    // Brightness State
    private boolean mIsOverrideEnabled = false;
    private int mTargetBrightnessDay = 5;
    private int mTargetBrightnessNight = 3;
    private int mTargetBrightnessAvm = 15;

    // Cache
    private int mLastAvmValue = 0;
    private int mLastDayNightSensorValue = -1;
    private int mLastBrightnessDayValue = -1;
    private int mLastBrightnessNightValue = -1;
    private int mLastThemeMode = -1;
    private float mLastLightSensorValue = -1f;
    private int mLastSetBrightness = -1;

    // Polling Control
    private boolean mIsMonitoring = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    // Day/Night Monitor (Replacing mMonitorRunnable part)
    private final Runnable mMonitorRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsMonitoring)
                return;
            checkAndForceAutoDayNight();
            mHandler.postDelayed(this, 1000); // Polling interval 1s
        }
    };

    // Brightness Enforcement Handler
    private final Handler mOverrideHandler = new Handler(Looper.getMainLooper());
    private final Runnable mOverrideRunnable = new Runnable() {
        @Override
        public void run() {
            checkAndEnforceBrightness();
            mOverrideHandler.postDelayed(this, 150);
        }
    };
    private int mEnforceCounter = 0;

    private ThemeBrightnessManager(Context context) {
        mContext = context.getApplicationContext();
    }

    public static synchronized ThemeBrightnessManager getInstance(Context context) {
        if (instance == null) {
            instance = new ThemeBrightnessManager(context);
        }
        return instance;
    }

    public void init() {
        SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        mIsOverrideEnabled = prefs.getBoolean("override_brightness_enabled", false);
        mTargetBrightnessDay = prefs.getInt("override_day_value", 12);
        mTargetBrightnessNight = prefs.getInt("override_night_value", 5);
        mTargetBrightnessAvm = prefs.getInt("override_avm_value", 15);

        boolean forceAuto = prefs.getBoolean("force_auto_day_night", false);
        boolean sensor2425 = prefs.getBoolean("enable_24_25_light_sensor", false);

        CarServiceManager.getInstance(mContext).registerListener(() -> {
            DebugLogger.i(TAG, "Car Service Ready. Triggering Initial Check...");
            checkDayNightStatus(forceAuto); // Trigger initial check once connected
        });

        // Also try immediately in case it's already ready (handled by registerListener
        // logic)
        // But for fallback or retry logic, we can also check regularly if we want,
        // though registerListener handles the "ready" event better.

        if (forceAuto || sensor2425) {
            startMonitoring();
        }

        if (mIsOverrideEnabled) {
            mOverrideHandler.post(mOverrideRunnable);
        }
    }

    public void destroy() {
        stopMonitoring();
        mOverrideHandler.removeCallbacksAndMessages(null);
    }

    // --- Public API for Config Changes ---

    public void setOverrideEnabled(boolean enabled) {
        mIsOverrideEnabled = enabled;
        if (mIsOverrideEnabled) {
            mOverrideHandler.removeCallbacks(mOverrideRunnable);
            mOverrideHandler.post(mOverrideRunnable);
        } else {
            mOverrideHandler.removeCallbacks(mOverrideRunnable);
        }
    }

    public void setTargetBrightness(int day, int night, int avm) {
        mTargetBrightnessDay = day;
        mTargetBrightnessNight = night;
        mTargetBrightnessAvm = avm;
    }

    public void checkMonitoringRequirement() {
        SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean forceAuto = prefs.getBoolean("force_auto_day_night", false);
        boolean sensor2425 = prefs.getBoolean("enable_24_25_light_sensor", false);
        if (forceAuto || sensor2425) {
            startMonitoring();
        } else {
            stopMonitoring();
        }
    }

    private void startMonitoring() {
        if (mIsMonitoring)
            return;
        mIsMonitoring = true;
        mHandler.post(mMonitorRunnable);
        DebugLogger.i(TAG, "Started Day/Night mode monitoring");
    }

    private void stopMonitoring() {
        mIsMonitoring = false;
        mHandler.removeCallbacks(mMonitorRunnable);
        DebugLogger.i(TAG, "Stopped Day/Night mode monitoring");
    }

    // --- Logic ---

    public void onSensorChanged(int sensorType, float value) {
        if (sensorType == SENSOR_TYPE_LIGHT) {
            if (mLastLightSensorValue != value) {
                mLastLightSensorValue = value;
                check2425LightSensorLogic();
            }
        }
    }

    public void onSensorEventChanged(int sensorType, int value) {
        if (sensorType == ISensor.SENSOR_TYPE_DAY_NIGHT) {
            // Polling handles this mostly, but good to have
            mLastDayNightSensorValue = value;
        }
    }

    public void onFunctionValueChanged(int functionId, int value) {
        if (functionId == FUNC_AVM_STATUS) {
            // Detect AVM Exit
            if (mLastAvmValue == 1 && value == 0) {
                DebugLogger.i(TAG, "AVM Exit detected. Initiating brightness enforcement burst.");
                triggerBrightnessBurst();
            }
            broadcastSensorValues(mLastDayNightSensorValue, value, mLastBrightnessDayValue, mLastBrightnessNightValue);
        } else if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
            // DebugLogger.d(TAG, "Brightness Changed: " + value);
            pollAndBroadcastBrightness();
        }
    }

    public void onCustomizeFunctionValueChanged(int functionId, float value) {
        if (functionId == FUNC_BRIGHTNESS_DAY || functionId == FUNC_BRIGHTNESS_NIGHT) {
            pollAndBroadcastBrightness();
        }
    }

    public void checkDayNightStatus(boolean enforceAuto) {
        new Thread(() -> {
            ICarFunction iCarFunction = CarServiceManager.getInstance(mContext).getCarFunction();
            ISensor iSensor = CarServiceManager.getInstance(mContext).getSensor();
            if (iCarFunction == null)
                return;

            try {
                int currentMode = iCarFunction.getFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL);

                // Poll Values
                int avm = iCarFunction.getFunctionValue(FUNC_AVM_STATUS, ZONE_ALL);
                if (avm != -1)
                    mLastAvmValue = avm;

                float brightDay = iCarFunction.getCustomizeFunctionValue(FUNC_BRIGHTNESS_DAY, ZONE_ALL);
                if (brightDay != -1f)
                    mLastBrightnessDayValue = (int) brightDay;

                float brightNight = iCarFunction.getCustomizeFunctionValue(FUNC_BRIGHTNESS_NIGHT, ZONE_ALL);
                if (brightNight != -1f)
                    mLastBrightnessNightValue = (int) brightNight;

                if (iSensor != null) {
                    int dayNight = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_DAY_NIGHT);
                    if (dayNight != -1)
                        mLastDayNightSensorValue = dayNight;

                    float lightVal = iSensor.getSensorEvent(SENSOR_TYPE_LIGHT);
                    if (lightVal != -1)
                        mLastLightSensorValue = lightVal;
                }

                if (currentMode != -1 && currentMode != 0) {
                    mLastThemeMode = currentMode;
                }

                broadcastSensorValues(mLastDayNightSensorValue, mLastAvmValue, mLastBrightnessDayValue,
                        mLastBrightnessNightValue);

                if (enforceAuto) {
                    SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
                    boolean isForceEnabled = prefs.getBoolean("force_auto_day_night", false);

                    if (isForceEnabled && currentMode != VALUE_DAYMODE_AUTO) {
                        DebugLogger.i(TAG, "Forcing AUTO Mode...");
                        boolean success = iCarFunction.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL,
                                VALUE_DAYMODE_AUTO);
                        if (success) {
                            DebugLogger.toast(mContext, "已强制恢复为自动模式");
                            broadcastSensorValues(mLastDayNightSensorValue, mLastAvmValue, mLastBrightnessDayValue,
                                    mLastBrightnessNightValue);
                        }
                    }
                }

                check2425LightSensorLogic();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error checking Day/Night status", e);
            }
        }).start();
    }

    private void checkAndForceAutoDayNight() {
        checkAndEnforceBrightness();
        pollAndBroadcastBrightness();
        checkDayNightStatus(true);
    }

    private void check2425LightSensorLogic() {
        SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean enabled = prefs.getBoolean("enable_24_25_light_sensor", false);
        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();

        if (!enabled || carFunc == null || mLastDayNightSensorValue == -1)
            return;

        try {
            int currentMode = carFunc.getFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL);
            if (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_NIGHT) {
                if (currentMode != VALUE_DAYMODE_NIGHT) {
                    DebugLogger.i(TAG, "24-25 Logic: Sensor NIGHT -> Theme NIGHT");
                    carFunc.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL, VALUE_DAYMODE_NIGHT);
                }
            } else if (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_DAY) {
                if (currentMode != VALUE_DAYMODE_DAY) {
                    DebugLogger.i(TAG, "24-25 Logic: Sensor DAY -> Theme DAY");
                    carFunc.setFunctionValue(FUNC_DAYMODE_SETTING, ZONE_ALL, VALUE_DAYMODE_DAY);
                }
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error in 24-25 Logic", e);
        }
    }

    private void checkAndEnforceBrightness() {
        if (!mIsOverrideEnabled)
            return;
        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
        if (carFunc == null)
            return;

        mEnforceCounter++;
        if (mEnforceCounter > 20) {
            mLastSetBrightness = -1;
            mEnforceCounter = 0;
        }

        int targetValue;
        int funcId;

        boolean isAvmActive = (mLastAvmValue == 1);
        if (isAvmActive) {
            targetValue = mTargetBrightnessAvm;
            if (mLastDayNightSensorValue == -1) {
                funcId = FUNC_BRIGHTNESS_DAY;
            } else {
                boolean isDay = (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_DAY);
                funcId = isDay ? FUNC_BRIGHTNESS_DAY : FUNC_BRIGHTNESS_NIGHT;
            }
        } else {
            if (mLastDayNightSensorValue == -1)
                return;
            boolean isDay = (mLastDayNightSensorValue == ISensorEvent.DAY_NIGHT_MODE_DAY);
            funcId = isDay ? FUNC_BRIGHTNESS_DAY : FUNC_BRIGHTNESS_NIGHT;
            targetValue = isDay ? mTargetBrightnessDay : mTargetBrightnessNight;
        }

        int currentKnownValue = (funcId == FUNC_BRIGHTNESS_DAY) ? mLastBrightnessDayValue : mLastBrightnessNightValue;

        if (currentKnownValue != targetValue) {
            if (mLastSetBrightness != targetValue) {
                DebugLogger.i(TAG, "Enforcing Brightness. Target: " + targetValue + " Cur: " + currentKnownValue);
                try {
                    carFunc.setCustomizeFunctionValue(funcId, ZONE_CSD, (float) targetValue);
                    mLastSetBrightness = targetValue;
                    if (funcId == FUNC_BRIGHTNESS_DAY)
                        mLastBrightnessDayValue = targetValue;
                    else
                        mLastBrightnessNightValue = targetValue;
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Failed to set brightness", e);
                }
            }
        }
    }

    private void triggerBrightnessBurst() {
        mLastSetBrightness = -1;
        mOverrideHandler.post(() -> checkAndEnforceBrightness());
        mOverrideHandler.postDelayed(() -> {
            mLastSetBrightness = -1;
            checkAndEnforceBrightness();
        }, 500);
        mOverrideHandler.postDelayed(() -> {
            mLastSetBrightness = -1;
            checkAndEnforceBrightness();
        }, 1500);
        mOverrideHandler.postDelayed(() -> {
            mLastSetBrightness = -1;
            checkAndEnforceBrightness();
        }, 3000);
    }

    private void pollAndBroadcastBrightness() {
        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
        ISensor iSensor = CarServiceManager.getInstance(mContext).getSensor();
        if (carFunc == null)
            return;

        try {
            boolean changed = false;
            float brightDay = carFunc.getCustomizeFunctionValue(FUNC_BRIGHTNESS_DAY, ZONE_ALL);
            if (brightDay != -1f && (int) brightDay != mLastBrightnessDayValue) {
                mLastBrightnessDayValue = (int) brightDay;
                changed = true;
            }
            float brightNight = carFunc.getCustomizeFunctionValue(FUNC_BRIGHTNESS_NIGHT, ZONE_ALL);
            if (brightNight != -1f && (int) brightNight != mLastBrightnessNightValue) {
                mLastBrightnessNightValue = (int) brightNight;
                changed = true;
            }
            if (iSensor != null) {
                int dayNight = iSensor.getSensorEvent(ISensor.SENSOR_TYPE_DAY_NIGHT);
                if (dayNight != -1 && dayNight != mLastDayNightSensorValue) {
                    mLastDayNightSensorValue = dayNight;
                    changed = true;
                }
            }

            if (changed) {
                broadcastSensorValues(mLastDayNightSensorValue, mLastAvmValue, mLastBrightnessDayValue,
                        mLastBrightnessNightValue);
            }
        } catch (Exception e) {
        }
    }

    private void broadcastSensorValues(int dayNight, int avm, int bDay, int bNight) {
        mLastDayNightSensorValue = dayNight;
        mLastAvmValue = avm;
        mLastBrightnessDayValue = bDay;
        mLastBrightnessNightValue = bNight;

        Intent intent = new Intent("cn.navitool.ACTION_DAY_NIGHT_STATUS");
        intent.putExtra("mode", mLastThemeMode);
        intent.putExtra("sensor_day_night", dayNight);
        intent.putExtra("prop_avm", avm);
        intent.putExtra("prop_brightness_day", bDay);
        intent.putExtra("prop_brightness_night", bNight);
        mContext.sendBroadcast(intent);
    }

    public void syncAutoNaviTheme() {
        SharedPreferences prefs = mContext.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        if (!prefs.getBoolean("auto_theme_sync", true))
            return;

        int currentNightMode = mContext.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        int autoNaviMode = (currentNightMode == Configuration.UI_MODE_NIGHT_YES) ? 2 : 1;

        Intent intent = new Intent("AUTONAVI_STANDARD_BROADCAST_RECV");
        intent.setComponent(
                new ComponentName(AUTONAVI_PKG, "com.autonavi.amapauto.adapter.internal.AmapAutoBroadcastReceiver"));
        intent.putExtra("KEY_TYPE", 10048);
        intent.putExtra("EXTRA_DAY_NIGHT_MODE", autoNaviMode);
        mContext.sendBroadcast(intent);
        DebugLogger.toast(mContext, mContext.getString(R.string.sent_autonavi_broadcast, autoNaviMode));
    }
}
