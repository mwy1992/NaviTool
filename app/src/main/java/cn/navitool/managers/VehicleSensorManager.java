package cn.navitool.managers;

import android.content.Context;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;
import cn.navitool.DebugLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆传感器管理器
 * 集中管理所有车辆传感器数据的获取和分发
 * 参考 DmService 设计模式
 */
public class VehicleSensorManager {
    private static final String TAG = "VehicleSensorManager";

    // --- 传感器类型常量 (参考 DmService 和 ISensor) ---
    // 事件类型 (使用 getSensorEvent)
    public static final int SENSOR_TYPE_IGNITION = 2097408; // 点火状态
    public static final int SENSOR_TYPE_GEAR = 2097664; // 档位
    public static final int SENSOR_TYPE_DAY_NIGHT = 2101248; // 日夜模式
    public static final int SENSOR_TYPE_SEATBELT_LEFT = 2101760; // 左侧安全带
    public static final int SENSOR_TYPE_SEATBELT_RIGHT = 2102016;// 右侧安全带
    public static final int SENSOR_TYPE_SEAT_OCCUPIED = 2110464; // 座椅占用

    // 数值类型 (使用 getSensorLatestValue)
    public static final int SENSOR_TYPE_SPEED = 1048832; // 车速 (m/s)
    public static final int SENSOR_TYPE_RPM = 1050880; // 转速
    public static final int SENSOR_TYPE_FUEL = 1050112; // 油量 (升)
    public static final int SENSOR_TYPE_FUEL_PERCENT = 4211968; // 油量百分比
    public static final int SENSOR_TYPE_TEMP_INDOOR = 1051648; // 室内温度
    public static final int SENSOR_TYPE_TEMP_OUTDOOR = 1051392; // 室外温度
    public static final int SENSOR_TYPE_RANGE = 1050624; // 续航里程
    public static final int SENSOR_TYPE_ODOMETER = 1050368; // 总里程
    public static final int SENSOR_TYPE_LIGHT = 0x200F00; // 光照传感器

    // --- 单例 ---
    private static VehicleSensorManager sInstance;
    private Context mContext;
    private ISensor mSensor;
    private boolean mIsInitialized = false;

    // --- 缓存值 ---
    private float mSpeed = 0; // km/h
    private float mRpm = 0;
    private float mFuel = 0;
    private float mFuelPercent = 0;
    private float mTempIndoor = 0;
    private float mTempOutdoor = 0;
    private float mRange = 0;
    private float mOdometer = 0;
    private float mLight = 0;

    private int mIgnition = 0;
    private int mGear = 0;
    private int mDayNight = 0;

    // --- 监听器 ---
    private final List<Listener> mListeners = new ArrayList<>();

    public interface Listener {
        default void onSpeedChanged(float speedKmh) {
        }

        default void onRpmChanged(float rpm) {
        }

        default void onFuelChanged(float fuel, float percent) {
        }

        default void onTemperatureChanged(float indoor, float outdoor) {
        }

        default void onRangeChanged(float range) {
        }

        default void onGearChanged(int gear) {
        }

        default void onIgnitionChanged(int state) {
        }

        default void onDayNightChanged(int mode) {
        }

        default void onLightChanged(float light) {
        }
    }

    // --- 单例获取 ---
    public static synchronized VehicleSensorManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VehicleSensorManager(context.getApplicationContext());
        }
        return sInstance;
    }

    private VehicleSensorManager(Context context) {
        mContext = context;
    }

    // --- 初始化 ---
    public void init() {
        if (mIsInitialized) {
            DebugLogger.d(TAG, "Already initialized");
            return;
        }

        CarServiceManager.getInstance(mContext).registerListener(() -> {
            mSensor = CarServiceManager.getInstance(mContext).getSensor();
            if (mSensor != null) {
                registerSensors();
                mIsInitialized = true;
                DebugLogger.action(TAG, "传感器管理器初始化完成");
            } else {
                DebugLogger.e(TAG, "Failed to get ISensor");
            }
        });
    }

    private void registerSensors() {
        if (mSensor == null)
            return;

        ISensor.ISensorListener listener = new ISensor.ISensorListener() {
            @Override
            public void onSensorEventChanged(int sensorType, int value) {
                handleEventSensor(sensorType, value);
            }

            @Override
            public void onSensorValueChanged(int sensorType, float value) {
                handleValueSensor(sensorType, value);
            }

            @Override
            public void onSensorSupportChanged(int sensorType, com.ecarx.xui.adaptapi.FunctionStatus status) {
                // Not used
            }
        };

        // 注册事件类型传感器
        mSensor.registerListener(listener, SENSOR_TYPE_IGNITION);
        mSensor.registerListener(listener, SENSOR_TYPE_GEAR);
        mSensor.registerListener(listener, SENSOR_TYPE_DAY_NIGHT);

        // 注册数值类型传感器
        mSensor.registerListener(listener, SENSOR_TYPE_SPEED, ISensor.RATE_UI);
        mSensor.registerListener(listener, SENSOR_TYPE_RPM, ISensor.RATE_UI);
        mSensor.registerListener(listener, SENSOR_TYPE_FUEL, ISensor.RATE_NORMAL);
        mSensor.registerListener(listener, SENSOR_TYPE_TEMP_INDOOR, ISensor.RATE_NORMAL);
        mSensor.registerListener(listener, SENSOR_TYPE_TEMP_OUTDOOR, ISensor.RATE_NORMAL);
        mSensor.registerListener(listener, SENSOR_TYPE_RANGE, ISensor.RATE_NORMAL);
        mSensor.registerListener(listener, SENSOR_TYPE_ODOMETER, ISensor.RATE_NORMAL);
        mSensor.registerListener(listener, SENSOR_TYPE_LIGHT, ISensor.RATE_NORMAL);

        DebugLogger.i(TAG, "All sensors registered");

        // 获取初始值
        refreshAllValues();
    }

    private void handleEventSensor(int sensorType, int value) {
        switch (sensorType) {
            case SENSOR_TYPE_IGNITION:
                if (mIgnition != value) {
                    mIgnition = value;
                    DebugLogger.action(TAG, "点火状态变化: " + value);
                    notifyIgnitionChanged(value);
                }
                break;
            case SENSOR_TYPE_GEAR:
                if (mGear != value) {
                    mGear = value;
                    DebugLogger.action(TAG, "档位变化: " + value);
                    notifyGearChanged(value);
                }
                break;
            case SENSOR_TYPE_DAY_NIGHT:
                if (mDayNight != value) {
                    mDayNight = value;
                    DebugLogger.action(TAG, "日夜模式变化: " + value);
                    notifyDayNightChanged(value);
                }
                break;
        }
    }

    private void handleValueSensor(int sensorType, float value) {
        switch (sensorType) {
            case SENSOR_TYPE_SPEED:
                float speedKmh = value * 3.6f; // m/s -> km/h
                if (Math.abs(mSpeed - speedKmh) > 0.5f) {
                    mSpeed = speedKmh;
                    notifySpeedChanged(speedKmh);
                }
                break;
            case SENSOR_TYPE_RPM:
                if (Math.abs(mRpm - value) > 10) {
                    mRpm = value;
                    notifyRpmChanged(value);
                }
                break;
            case SENSOR_TYPE_FUEL:
                mFuel = value;
                notifyFuelChanged(mFuel, mFuelPercent);
                break;
            case SENSOR_TYPE_FUEL_PERCENT:
                mFuelPercent = value;
                notifyFuelChanged(mFuel, mFuelPercent);
                break;
            case SENSOR_TYPE_TEMP_INDOOR:
                mTempIndoor = value;
                notifyTemperatureChanged(mTempIndoor, mTempOutdoor);
                break;
            case SENSOR_TYPE_TEMP_OUTDOOR:
                mTempOutdoor = value;
                notifyTemperatureChanged(mTempIndoor, mTempOutdoor);
                break;
            case SENSOR_TYPE_RANGE:
                mRange = value;
                notifyRangeChanged(value);
                break;
            case SENSOR_TYPE_ODOMETER:
                mOdometer = value;
                break;
            case SENSOR_TYPE_LIGHT:
                mLight = value;
                notifyLightChanged(value);
                break;
        }
    }

    // --- 主动刷新 (参考 DmService 的 getSensorLatestValue) ---
    public void refreshAllValues() {
        if (mSensor == null)
            return;

        try {
            mSpeed = mSensor.getSensorLatestValue(SENSOR_TYPE_SPEED) * 3.6f;
            mRpm = mSensor.getSensorLatestValue(SENSOR_TYPE_RPM);
            mFuel = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL);
            mFuelPercent = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL_PERCENT);
            mTempIndoor = mSensor.getSensorLatestValue(SENSOR_TYPE_TEMP_INDOOR);
            mTempOutdoor = mSensor.getSensorLatestValue(SENSOR_TYPE_TEMP_OUTDOOR);
            mRange = mSensor.getSensorLatestValue(SENSOR_TYPE_RANGE);
            mOdometer = mSensor.getSensorLatestValue(SENSOR_TYPE_ODOMETER);

            mIgnition = mSensor.getSensorEvent(SENSOR_TYPE_IGNITION);
            mGear = mSensor.getSensorEvent(SENSOR_TYPE_GEAR);
            mDayNight = mSensor.getSensorEvent(SENSOR_TYPE_DAY_NIGHT);

            DebugLogger.d(TAG, "Refreshed all sensor values");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to refresh values", e);
        }
    }

    // --- Getter 方法 ---
    public float getSpeed() {
        return mSpeed;
    }

    public float getRpm() {
        return mRpm;
    }

    public float getFuel() {
        return mFuel;
    }

    public float getFuelPercent() {
        return mFuelPercent;
    }

    public float getTempIndoor() {
        return mTempIndoor;
    }

    public float getTempOutdoor() {
        return mTempOutdoor;
    }

    public float getRange() {
        return mRange;
    }

    public float getOdometer() {
        return mOdometer;
    }

    public float getLight() {
        return mLight;
    }

    public int getIgnition() {
        return mIgnition;
    }

    public int getGear() {
        return mGear;
    }

    public int getDayNight() {
        return mDayNight;
    }

    public boolean isIgnitionOn() {
        return mIgnition == ISensorEvent.IGNITION_STATE_DRIVING;
    }

    public boolean isDayMode() {
        return mDayNight == ISensorEvent.DAY_NIGHT_MODE_DAY;
    }

    // --- 监听器管理 ---
    public void addListener(Listener listener) {
        if (!mListeners.contains(listener)) {
            mListeners.add(listener);
        }
    }

    public void removeListener(Listener listener) {
        mListeners.remove(listener);
    }

    // --- 通知方法 ---
    private void notifySpeedChanged(float speed) {
        for (Listener l : mListeners)
            l.onSpeedChanged(speed);
    }

    private void notifyRpmChanged(float rpm) {
        for (Listener l : mListeners)
            l.onRpmChanged(rpm);
    }

    private void notifyFuelChanged(float fuel, float percent) {
        for (Listener l : mListeners)
            l.onFuelChanged(fuel, percent);
    }

    private void notifyTemperatureChanged(float indoor, float outdoor) {
        for (Listener l : mListeners)
            l.onTemperatureChanged(indoor, outdoor);
    }

    private void notifyRangeChanged(float range) {
        for (Listener l : mListeners)
            l.onRangeChanged(range);
    }

    private void notifyGearChanged(int gear) {
        for (Listener l : mListeners)
            l.onGearChanged(gear);
    }

    private void notifyIgnitionChanged(int state) {
        for (Listener l : mListeners)
            l.onIgnitionChanged(state);
    }

    private void notifyDayNightChanged(int mode) {
        for (Listener l : mListeners)
            l.onDayNightChanged(mode);
    }

    private void notifyLightChanged(float light) {
        for (Listener l : mListeners)
            l.onLightChanged(light);
    }
}
