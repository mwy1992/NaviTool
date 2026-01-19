package cn.navitool.managers;

import android.content.Context;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;
import com.ecarx.xui.adaptapi.car.hev.IHev;
import com.ecarx.xui.adaptapi.car.hev.ITripData;
import cn.navitool.utils.DebugLogger;

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
    
    // 新增油耗相关
    public static final int SENSOR_TYPE_FUEL_CONSUMPTION_INS = 4194816; // 瞬时油耗
    public static final int SENSOR_TYPE_FUEL_CONSUMPTION_AVG = 4194560; // 平均油耗

    // --- 胎压监测系统 (TPMS) ---
    // 胎压 (Pressure)
    public static final int SENSOR_TYPE_TIRE_PRESSURE_FL = 5243136;
    public static final int SENSOR_TYPE_TIRE_PRESSURE_FR = 5243392;
    public static final int SENSOR_TYPE_TIRE_PRESSURE_RL = 5243648;
    public static final int SENSOR_TYPE_TIRE_PRESSURE_RR = 5243904;

    // 胎温 (Temperature)
    public static final int SENSOR_TYPE_TIRE_TEMP_FL = 5244160;
    public static final int SENSOR_TYPE_TIRE_TEMP_FR = 5244416;
    public static final int SENSOR_TYPE_TIRE_TEMP_RL = 5244672;
    public static final int SENSOR_TYPE_TIRE_TEMP_RR = 5244928;

    // --- 单例 ---
    private static VehicleSensorManager sInstance;
    private Context mContext;
    private ISensor mSensor;
    private ITripData mTripData; // [NEW] Trip Data
    private boolean mIsInitialized = false;

    // --- 缓存值 ---
    private float mSpeed = 0; // km/h
    private float mRpm = 0;
    private float mFuel = 0;
    private float mFuelPercent = 0;
    private float mFuelIns = 0; // Instantaneous Fuel Consumption
    private float mFuelAvg = 0; // Average Fuel Consumption
    private float mTempIndoor = 0;
    private float mTempOutdoor = 0;
    private float mRange = 0;
    private float mOdometer = 0;
    private float mLight = 0;
    
    // [NEW] Current Trip Data (From API)
    private float mCurrentTripKm = 0f;
    private long mCurrentTripDuration = 0;

    // [NEW] Trip Data Cache (API - Subtotal)
    private int mTripDistance = 0; // Unit: meters
    private long mTripDuration = 0; // Unit: seconds
    private float mAvgFuelConsumption = 0; // Unit: L/100km

    private int mIgnition = 0;
    private int mGear = 0;
    private int mDayNight = 0;

    // TPMS Cache (0:FL, 1:FR, 2:RL, 3:RR)
    private float[] mTirePressure = new float[4];
    private float[] mTireTemp = new float[4];

    // --- 监听器 ---
    private final List<Listener> mListeners = new ArrayList<>();
    private ISensor.ISensorListener mSensorListener;
    private ITripData.ITripListener mTripListener; // [NEW] Trip Listener

    public interface Listener {
        default void onSpeedChanged(float speedKmh) {}
        default void onRpmChanged(float rpm) {}
        default void onFuelChanged(float fuel, float percent) {}
        // 新增: 油耗回调
        default void onFuelConsumptionChanged(float instant, float average) {}
        default void onTemperatureChanged(float indoor, float outdoor) {}
        default void onRangeChanged(float range) {}
        // 新增: 里程回调
        default void onOdometerChanged(float odometer) {}
        default void onGearChanged(int gear) {}
        default void onIgnitionChanged(int state) {}
        default void onDayNightChanged(int mode) {}
        default void onLightChanged(float light) {}
        default void onTireDataChanged(int index, float pressure, float temp) {}
        // [NEW] Trip Data Callback (Updated to float distance for km)
        // distance: Current Trip (km) if calculated, or API Trip (km)
        // duration: seconds
        default void onTripDataChanged(float distanceKm, long durationSec, float avgFuel) {}
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
                registerTripData(); // [NEW] Register Trip Data
                mIsInitialized = true;
                DebugLogger.action(TAG, "传感器管理器初始化完成");
            } else {
                DebugLogger.e(TAG, "Failed to get ISensor");
            }
        });
    }

    private void registerSensors() {
        if (mSensor == null) return;
        
        if (mSensorListener == null) {
            mSensorListener = new ISensor.ISensorListener() {
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
        }

        // 注册事件类型传感器 (保持不变)
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_IGNITION);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_GEAR);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_DAY_NIGHT);

        // 注册数值类型传感器 (添加新传感器)
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_SPEED, ISensor.RATE_UI);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_RPM, ISensor.RATE_UI);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL_PERCENT, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL_CONSUMPTION_INS, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL_CONSUMPTION_AVG, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TEMP_INDOOR, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TEMP_OUTDOOR, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_RANGE, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_ODOMETER, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_LIGHT, ISensor.RATE_NORMAL);

        // 注册 TPMS 传感器 (保持不变)
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_FL, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_FR, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_RL, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_RR, ISensor.RATE_NORMAL);

        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_FL, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_FR, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_RL, ISensor.RATE_NORMAL);
        mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_RR, ISensor.RATE_NORMAL);

        DebugLogger.i(TAG, "All sensors registered (including Fuel Consumption)");
        refreshAllValues();
    }

    private void registerTripData() {
        IHev hev = CarServiceManager.getInstance(mContext).getHevManager();
        if (hev != null) {
            mTripData = hev.getTripData();
            if (mTripData != null) {
                if (mTripListener == null) {
                    mTripListener = new ITripData.ITripListener() {
                        @Override
                        public void onDrivingInfoUpdate(ITripData.IDrivingInfo info) {
                            if (info != null) {
                                // [FIX] Use API parameters directly (No Freestyle)
                                // mTripDistance = Subtotal Mileage
                                mTripDistance = info.getTripDistance();
                                // mCurrentTripKm = Current Day Mileage (Assuming meters)
                                int currentDayDist = info.getTripDistanceInCurrentDay();
                                mCurrentTripKm = currentDayDist / 1000.0f;
                                
                                // mTripDuration = Travel Time
                                mTripDuration = info.getTripDuration();
                                mCurrentTripDuration = mTripDuration; // Mapping API duration to current for now
                                
                                DebugLogger.d(TAG, "Trip Update: Subtotal=" + mTripDistance + ", CurrentDay=" + currentDayDist);
                                notifyTripDataChanged();
                            }
                        }

                        @Override
                        public void onAvgEnergyInfoUpdate(ITripData.IAvgEnergyInfo info) {
                            if (info != null) {
                                mAvgFuelConsumption = info.getAvgFuelConsumption();
                                DebugLogger.d(TAG, "Avg Fuel Update: " + mAvgFuelConsumption);
                                notifyTripDataChanged();
                            }
                        }
                    };
                }
                mTripData.registerTripListener(mTripListener);
                DebugLogger.i(TAG, "Trip Data Registered");
                
                // Initial Fetch
                refreshTripValues();
            }
        }
    }
    
    private void refreshTripValues() {
         if (mTripData != null) {
             try {
                ITripData.IDrivingInfo driveInfo = mTripData.getLatestDrivingInfo();
                if (driveInfo != null) {
                    mTripDistance = driveInfo.getTripDistance();
                    int currentDayDist = driveInfo.getTripDistanceInCurrentDay();
                    mCurrentTripKm = currentDayDist / 1000.0f;
                    mTripDuration = driveInfo.getTripDuration();
                    mCurrentTripDuration = mTripDuration;
                }
                
                ITripData.IAvgEnergyInfo energyInfo = mTripData.getLatestAvgEnergyInfo();
                if (energyInfo != null) {
                    mAvgFuelConsumption = energyInfo.getAvgFuelConsumption();
                }
             } catch (Exception e) {
                 DebugLogger.e(TAG, "Error refreshing trip values", e);
             }
         }
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
                // [FIX] 统一单位转换: ml -> L
                // 假设原始值小于1000则已经是L，否则是ml需要除以1000 (安全策略)
                // 原 ClusterHudManager 逻辑: String.format("%.0fL", value / 1000.0f)
                // 这里我们统一存储为 L (Float)
                float fuelL;
                if (value > 200.0f) { // 阈值判断，通常油箱不会超过200L，如果数值很大说明是ml
                     fuelL = value / 1000.0f;
                } else {
                     fuelL = value;
                }
                mFuel = fuelL;
                notifyFuelChanged(mFuel, mFuelPercent);
                break;
            case SENSOR_TYPE_FUEL_PERCENT:
                mFuelPercent = value;
                notifyFuelChanged(mFuel, mFuelPercent);
                break;
            case SENSOR_TYPE_FUEL_CONSUMPTION_INS:
                mFuelIns = value;
                notifyFuelConsumptionChanged(mFuelIns, mFuelAvg);
                break;
            case SENSOR_TYPE_FUEL_CONSUMPTION_AVG:
                mFuelAvg = value;
                notifyFuelConsumptionChanged(mFuelIns, mFuelAvg);
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
                // [FIX] Add notification for Odometer
                notifyOdometerChanged(value);
                break;
            case SENSOR_TYPE_LIGHT:
                mLight = value;
                notifyLightChanged(value);
                break;

            // TPMS Logic (Preserved)
            case SENSOR_TYPE_TIRE_PRESSURE_FL: mTirePressure[0] = value; notifyTireDataChanged(0); break;
            case SENSOR_TYPE_TIRE_PRESSURE_FR: mTirePressure[1] = value; notifyTireDataChanged(1); break;
            case SENSOR_TYPE_TIRE_PRESSURE_RL: mTirePressure[2] = value; notifyTireDataChanged(2); break;
            case SENSOR_TYPE_TIRE_PRESSURE_RR: mTirePressure[3] = value; notifyTireDataChanged(3); break;
            case SENSOR_TYPE_TIRE_TEMP_FL: mTireTemp[0] = value; notifyTireDataChanged(0); break;
            case SENSOR_TYPE_TIRE_TEMP_FR: mTireTemp[1] = value; notifyTireDataChanged(1); break;
            case SENSOR_TYPE_TIRE_TEMP_RL: mTireTemp[2] = value; notifyTireDataChanged(2); break;
            case SENSOR_TYPE_TIRE_TEMP_RR: mTireTemp[3] = value; notifyTireDataChanged(3); break;
        }
    }

    public void refreshAllValues() {
        if (mSensor == null) return;
        try {
            mSpeed = mSensor.getSensorLatestValue(SENSOR_TYPE_SPEED) * 3.6f;
            mRpm = mSensor.getSensorLatestValue(SENSOR_TYPE_RPM);
            
            // Fuel Logic with safety check
            float rawFuel = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL);
             if (rawFuel > 200.0f) {
                 mFuel = rawFuel / 1000.0f;
            } else {
                 mFuel = rawFuel;
            }
            mFuelPercent = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL_PERCENT);
            
            // New Fuel Cons
            mFuelIns = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL_CONSUMPTION_INS);
            mFuelAvg = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL_CONSUMPTION_AVG);

            mTempIndoor = mSensor.getSensorLatestValue(SENSOR_TYPE_TEMP_INDOOR);
            mTempOutdoor = mSensor.getSensorLatestValue(SENSOR_TYPE_TEMP_OUTDOOR);
            mRange = mSensor.getSensorLatestValue(SENSOR_TYPE_RANGE);
            mOdometer = mSensor.getSensorLatestValue(SENSOR_TYPE_ODOMETER);

            mIgnition = mSensor.getSensorEvent(SENSOR_TYPE_IGNITION);
            mGear = mSensor.getSensorEvent(SENSOR_TYPE_GEAR);
            mDayNight = mSensor.getSensorEvent(SENSOR_TYPE_DAY_NIGHT);

            // Refresh TPMS
            mTirePressure[0] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_PRESSURE_FL);
            mTirePressure[1] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_PRESSURE_FR);
            mTirePressure[2] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_PRESSURE_RL);
            mTirePressure[3] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_PRESSURE_RR);

            mTireTemp[0] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_TEMP_FL);
            mTireTemp[1] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_TEMP_FR);
            mTireTemp[2] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_TEMP_RL);
            mTireTemp[3] = mSensor.getSensorLatestValue(SENSOR_TYPE_TIRE_TEMP_RR);

            DebugLogger.d(TAG, "Refreshed all sensor values");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to refresh values", e);
        }
    }

    // --- Getter 方法 ---
    public float getSpeed() { return mSpeed; }
    public float getRpm() { return mRpm; }
    public float getFuel() { return mFuel; }
    public float getFuelPercent() { return mFuelPercent; }
    public float getTempIndoor() { return mTempIndoor; }
    public float getTempOutdoor() { return mTempOutdoor; }
    public float getRange() { return mRange; }
    public float getOdometer() { return mOdometer; }
    public float getLight() { return mLight; }
    public int getIgnition() { return mIgnition; }
    public int getGear() { return mGear; }
    public int getDayNight() { return mDayNight; }

    public float getFuelIns() { return mFuelIns; }
    public float getFuelAvg() { return mFuelAvg; }
    
    // [NEW] Trip getters
    public int getTripDistance() { return mTripDistance; }
    public long getTripDuration() { return mTripDuration; }
    public float getAvgFuelConsumption() { return mAvgFuelConsumption; }

    public boolean isIgnitionOn() {
        return mIgnition == ISensorEvent.IGNITION_STATE_DRIVING;
    }

    public boolean isDayMode() {
        return mDayNight == ISensorEvent.DAY_NIGHT_MODE_DAY;
    }

    // [NEW] Getters for Calculated Current Trip
    public float getCurrentTripKm() { return mCurrentTripKm; }
    public long getCurrentTripDuration() { return mCurrentTripDuration; }

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
        for (Listener l : mListeners) l.onSpeedChanged(speed);
    }

    private void notifyRpmChanged(float rpm) {
        for (Listener l : mListeners) l.onRpmChanged(rpm);
    }

    private void notifyFuelChanged(float fuel, float percent) {
        for (Listener l : mListeners) l.onFuelChanged(fuel, percent);
    }

    private void notifyFuelConsumptionChanged(float instant, float average) {
        for (Listener l : mListeners) l.onFuelConsumptionChanged(instant, average);
    }

    private void notifyTemperatureChanged(float indoor, float outdoor) {
        for (Listener l : mListeners) l.onTemperatureChanged(indoor, outdoor);
    }

    private void notifyRangeChanged(float range) {
        for (Listener l : mListeners) l.onRangeChanged(range);
    }

    private void notifyOdometerChanged(float odometer) {
        for (Listener l : mListeners) l.onOdometerChanged(odometer);
    }

    private void notifyGearChanged(int gear) {
        for (Listener l : mListeners) l.onGearChanged(gear);
    }

    private void notifyIgnitionChanged(int state) {
        for (Listener l : mListeners) l.onIgnitionChanged(state);
    }

    private void notifyDayNightChanged(int mode) {
        for (Listener l : mListeners) l.onDayNightChanged(mode);
    }

    private void notifyLightChanged(float light) {
        for (Listener l : mListeners) l.onLightChanged(light);
    }

    private void notifyTireDataChanged(int index) {
        for (Listener l : mListeners) l.onTireDataChanged(index, mTirePressure[index], mTireTemp[index]);
    }

    private void notifyTripDataChanged() {
        // [FIX] Use Calculated Current Trip (Since Ignition) as priority, 
        // fallback to API Trip if calculating isn't active (e.g. ODO start invalid),
        // BUT user strictly wants "Current Trip". 
        // We pass mCurrentTripKm (Calculated) and mCurrentTripDuration (Calculated).
        // For Avg Fuel, we still use API value as we can't calculate it easily.
        
        // If Ignition hasn't triggered reset, mOdometerStart is -1. 
        // In that case mCurrentTripKm is 0.
        
        for (Listener l : mListeners) l.onTripDataChanged(mCurrentTripKm, mCurrentTripDuration, mAvgFuelConsumption);
    }

    public void destroy() {
        if (mSensor != null && mSensorListener != null) {
            try {
                mSensor.unregisterListener(mSensorListener);
                DebugLogger.i(TAG, "Unregistered all sensors");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error unregistering sensors", e);
            }
        }
        
        if (mTripData != null && mTripListener != null) {
             try {
                 mTripData.unregisterTripListener(mTripListener);
             } catch (Exception e) {
                 DebugLogger.e(TAG, "Error unregistering trip listener", e);
             }
        }
        mListeners.clear();
        mSensorListener = null;
        mSensor = null;
        mIsInitialized = false;
        sInstance = null;
    }
}
