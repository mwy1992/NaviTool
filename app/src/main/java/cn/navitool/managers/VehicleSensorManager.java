
package cn.navitool.managers;

import android.content.Context;
import android.content.SharedPreferences;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;
// Removed ITripData imports
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
    public static final int SENSOR_TYPE_DIM_CAR_SPEED = 1055232; // DIM车速 (优先)

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
    // ITripData removed as it causes crashes on 0.4.6 and is not supported by standard API
    private boolean mIsInitialized = false;

    // --- Soft Trip Persistence ---
    private static final String PREF_NAME = "trip_data";
    private static final String KEY_START_ODO = "start_odo";
    private static final String KEY_START_TIME = "start_time";
    private static final String KEY_LAST_IGNITION_OFF = "last_ignition_off";
    private SharedPreferences mPrefs;
    private static final long RESET_THRESHOLD_MS = 4 * 60 * 60 * 1000; // 4 Hours
    
    private float mStartOdo = -1f;
    private long mStartTime = 0;

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
    
    // [NEW] Current Trip Data (Soft Calculation)
    private float mCurrentTripKm = 0f;
    private long mCurrentTripDuration = 0;

    // [NEW] Trip Data Cache (Soft Calculation)
    private float mAvgFuelConsumption = 0; // Unit: L/100km

    private int mIgnition = 0;
    private int mGear = 0;
    private int mDayNight = 0;
    private boolean mSeatOccupied = false;

    // TPMS Cache (0:FL, 1:FR, 2:RL, 3:RR)
    private float[] mTirePressure = new float[4];
    private float[] mTireTemp = new float[4];


    // --- ICarFunction 引用 ---
    private com.ecarx.xui.adaptapi.car.base.ICarFunction mCarFunction;
    private com.ecarx.xui.adaptapi.car.base.ICarFunction.IFunctionValueWatcher mFunctionWatcher;

    // --- Function Constants ---
    private static final int BCM_FUNC_DOOR = 553779456;
    private static final int BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL = 0x21051100;
    private static final int BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL = 0x21051200;
    private static final int FUNC_CLUSTER_LEFT_TURN = 553980160; 
    private static final int FUNC_CLUSTER_RIGHT_TURN = 553980416;
    public static final int FUNC_AUTOHOLD_STATUS = 33661;
    private static final int FUNC_PSD_SCREEN_SWITCH = 539495936;
    
    // [NEW] HUD & Snow Mode Constants
    public static final int SETTING_FUNC_HUD_AR_ENGINE = 654443008; // AR/WHUD Switch
    public static final int SETTING_FUNC_HUD_SNOW_MODE = 654442752; // Snow Mode Switch
    
    // --- 监听器 ---
    private final List<Listener> mListeners = new ArrayList<>();
    private ISensor.ISensorListener mSensorListener;

    public interface Listener {
        default void onSpeedChanged(float speedKmh) {}
        default void onRpmChanged(float rpm) {}
        default void onFuelChanged(float fuel, float percent) {}
        default void onFuelConsumptionChanged(float instant, float average) {}
        default void onTemperatureChanged(float indoor, float outdoor) {}
        default void onRangeChanged(float range) {}
        default void onOdometerChanged(float odometer) {}
        default void onGearChanged(int gear) {}
        default void onIgnitionChanged(int state) {}
        default void onDayNightChanged(int mode) {}
        default void onLightChanged(float light) {}
        default void onTireDataChanged(int index, float pressure, float temp) {}
        default void onTripDataChanged(float distanceKm, long durationSec, float avgFuel) {}
        
        // [NEW] Added Callbacks
        default void onSeatOccupiedChanged(boolean occupied) {}
        default void onDoorChanged(int zone, int status) {} // 1: Open, 0: Close
        default void onTurnSignalChanged(boolean isLeft, boolean isOn) {}
        default void onFunctionChanged(int functionId, int zone, int value) {} // Generic Fallback (AVM, PSD, Brightness, HUD)
        default void onCustomizeFunctionChanged(int functionId, int zone, float value) {} // Generic Float
    }

    // --- 单例获取 ---
    public static synchronized VehicleSensorManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VehicleSensorManager(context);
        }
        return sInstance;
    }

    private synchronized SharedPreferences getPrefs() {
        if (mPrefs == null) {
            // Lazy load on main thread if not yet ready (fallback), though usually init() handles it
            mPrefs = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return mPrefs;
    }
    
    // [FIX] Make constructor private and handle init call properly
    private VehicleSensorManager(Context context) {
        mContext = context;
    }

    // --- 初始化 ---
    public void init() {
        if (mIsInitialized) {
            DebugLogger.d(TAG, "Already initialized");
            return;
        }

        // [OPTIMIZATION] Async Init implementation
        new Thread(() -> {
            mPrefs = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            DebugLogger.i(TAG, "SharedPreferences initialized asynchronously");
        }).start();

        CarServiceManager.getInstance(mContext).registerListener(() -> {
            try {
                mSensor = CarServiceManager.getInstance(mContext).getSensor();
                mCarFunction = CarServiceManager.getInstance(mContext).getCarFunction();
                
                if (mSensor != null) {
                    registerSensors();
                    checkTripReset();
                }
                if (mCarFunction != null) {
                    registerFunctions();
                }
                
                if (mSensor != null || mCarFunction != null) {
                    mIsInitialized = true;
                    DebugLogger.action(TAG, "车辆传感器与功能监听初始化完成");
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error in init callback", e);
            }
        });
    }

    // [NEW] Register Sensors
    private void registerSensors() {
        if (mSensor == null) return;
        
        if (mSensorListener == null) {
             mSensorListener = new ISensor.ISensorListener() {
                @Override
                public void onSensorEventChanged(int sensorType, int eventValue) {
                    handleEventSensor(sensorType, eventValue);
                }

                @Override
                public void onSensorValueChanged(int sensorType, float value) {
                    handleValueSensor(sensorType, value);
                }

                @Override
                public void onSensorSupportChanged(int sensorType, com.ecarx.xui.adaptapi.FunctionStatus status) {}
             };
        }

        try {
            // Register Event Sensors
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_IGNITION);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_GEAR);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_DAY_NIGHT);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_SEAT_OCCUPIED); // [NEW]

            // Register Value Sensors
            // mSensor.registerListener(mSensorListener, SENSOR_TYPE_SPEED); // Use DIM Speed instead
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_DIM_CAR_SPEED);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_RPM);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL_PERCENT);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL_CONSUMPTION_INS);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_FUEL_CONSUMPTION_AVG);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TEMP_INDOOR);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TEMP_OUTDOOR);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_RANGE);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_ODOMETER);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_LIGHT);
            
            // Register TPMS
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_FL);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_FR);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_RL);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_PRESSURE_RR);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_FL);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_FR);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_RL);
            mSensor.registerListener(mSensorListener, SENSOR_TYPE_TIRE_TEMP_RR);

            DebugLogger.i(TAG, "Sensors registered successfully");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error registering sensors", e);
        }
    }

    // [New] Generic Setter for Car Functions
    public void setFunctionValue(int functionId, int zone, int value) {
        if (mCarFunction != null) {
            try {
                mCarFunction.setFunctionValue(functionId, zone, value);
                DebugLogger.d(TAG, "setFunctionValue: ID=" + functionId + " Zone=" + zone + " Val=" + value);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to set function value: " + functionId, e);
            }
        } else {
             DebugLogger.w(TAG, "CarFunction not initialized, cannot set value");
        }
    }
    
    // [NEW] Register Functions
    private void registerFunctions() {
        if (mCarFunction == null) return;
        
        if (mFunctionWatcher == null) {
            mFunctionWatcher = new com.ecarx.xui.adaptapi.car.base.ICarFunction.IFunctionValueWatcher() {
                 @Override
                 public void onFunctionValueChanged(int functionId, int zone, int value) {
                     handleFunctionValue(functionId, zone, value);
                 }

                 @Override
                 public void onCustomizeFunctionValueChanged(int functionId, int zone, float value) {
                     notifyCustomizeFunctionChanged(functionId, zone, value);
                 }

                 @Override
                 public void onFunctionChanged(int functionId) {}

                 @Override
                 public void onSupportedFunctionStatusChanged(int functionId, int zone, com.ecarx.xui.adaptapi.FunctionStatus status) {}

                 @Override
                 public void onSupportedFunctionValueChanged(int functionId, int[] values) {}
            };
        }
        
        // Register Watchers
        try {
            mCarFunction.registerFunctionValueWatcher(BCM_FUNC_DOOR, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(FUNC_CLUSTER_LEFT_TURN, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(FUNC_CLUSTER_RIGHT_TURN, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(FUNC_AUTOHOLD_STATUS, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(FUNC_PSD_SCREEN_SWITCH, mFunctionWatcher);
            
            // [NEW] HUD Watchers
            mCarFunction.registerFunctionValueWatcher(SETTING_FUNC_HUD_AR_ENGINE, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(SETTING_FUNC_HUD_SNOW_MODE, mFunctionWatcher);

            // Also register AVM and Brightness explicitly
            mCarFunction.registerFunctionValueWatcher(2097152 /*FUNC_AVM_STATUS*/, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(538448128 /*FUNC_BRIGHTNESS_DAY*/, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(538448384 /*FUNC_BRIGHTNESS_NIGHT*/, mFunctionWatcher);
            mCarFunction.registerFunctionValueWatcher(538251520 /*FUNC_DAYMODE_SETTING*/, mFunctionWatcher);
            
            DebugLogger.i(TAG, "Function watchers registered (HUD, Doors, Lights...)");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error registering function watchers", e);
        }
    }

    /**
     * [Soft Trip Implementation]
     * Check if we need to reset trip data (e.g. after long parking > 4 hours)
     */
    private void checkTripReset() {
        SharedPreferences prefs = getPrefs();
        long lastOffTime = prefs.getLong(KEY_LAST_IGNITION_OFF, 0);
        long now = System.currentTimeMillis();
        
        mStartOdo = prefs.getFloat(KEY_START_ODO, -1f);
        mStartTime = prefs.getLong(KEY_START_TIME, 0);
        
        boolean needReset = false;
        
        if (mStartOdo < 0) {
            needReset = true; // First run
        } else if (lastOffTime > 0 && (now - lastOffTime) > RESET_THRESHOLD_MS) {
            needReset = true; // Long stop
        }
        
        if (needReset) {
            DebugLogger.i(TAG, "Trip Data Reset Triggered (Soft Trip)");
            mStartOdo = -1f; 
            mStartTime = now;
            prefs.edit()
                .putFloat(KEY_START_ODO, -1f)
                .putLong(KEY_START_TIME, now)
                .apply();
            mCurrentTripKm = 0;
            mCurrentTripDuration = 0;
            notifyTripDataChanged();
        } else {
             DebugLogger.i(TAG, "Trip Data Continued: StartOdo=" + mStartOdo);
        }
    }

    private void handleEventSensor(int sensorType, int value) {
        switch (sensorType) {
            case SENSOR_TYPE_IGNITION:
                if (mIgnition != value) {
                    mIgnition = value;
                    DebugLogger.action(TAG, "点火状态变化: " + value);
                    if (value == ISensorEvent.IGNITION_STATE_OFF || value == ISensorEvent.IGNITION_STATE_ACC) {
                         getPrefs().edit().putLong(KEY_LAST_IGNITION_OFF, System.currentTimeMillis()).apply();
                    } else if (value == ISensorEvent.IGNITION_STATE_DRIVING || value == ISensorEvent.IGNITION_STATE_ON) {
                         checkTripReset();
                    }
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
            case SENSOR_TYPE_SEAT_OCCUPIED:
                // 2110210 = Occupied, 2110209 = Empty
                boolean occupied = (value == 2110210);
                if (mSeatOccupied != occupied) {
                    mSeatOccupied = occupied;
                    notifySeatOccupiedChanged(occupied);
                }
                break;
        }
    }

    private void handleFunctionValue(int functionId, int zone, int value) {
        if (functionId == BCM_FUNC_DOOR) {
            notifyDoorChanged(zone, value);
        } else if (functionId == BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL || functionId == FUNC_CLUSTER_LEFT_TURN) {
            notifyTurnSignalChanged(true, value == 1);
        } else if (functionId == BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL || functionId == FUNC_CLUSTER_RIGHT_TURN) {
            notifyTurnSignalChanged(false, value == 1);
        } else {
            notifyFunctionChanged(functionId, zone, value);
        }
    }

    private void handleValueSensor(int sensorType, float value) {
        switch (sensorType) {
            case SENSOR_TYPE_SPEED:
                // IGNORE (Use DIM Speed)
                break;
            case SENSOR_TYPE_DIM_CAR_SPEED:
                float dimSpeedKmh = value * 3.6f;
                if (Math.abs(mSpeed - dimSpeedKmh) > 0.01f) {
                    mSpeed = dimSpeedKmh;
                    notifySpeedChanged(dimSpeedKmh);
                }
                break;
            case SENSOR_TYPE_RPM:
                if (Math.abs(mRpm - value) > 1.0f) { // RPM can fluctuate slightly, 1.0 is safe
                    mRpm = value;
                    notifyRpmChanged(value);
                }
                break;
            case SENSOR_TYPE_FUEL:
                float fuelL;
                if (value > 200.0f) {
                     fuelL = value / 1000.0f;
                } else {
                     fuelL = value;
                }
                if (Math.abs(mFuel - fuelL) > 0.1f) {
                    mFuel = fuelL;
                    notifyFuelChanged(mFuel, mFuelPercent);
                }
                break;
            case SENSOR_TYPE_FUEL_PERCENT:
                if (Math.abs(mFuelPercent - value) > 0.5f) {
                    mFuelPercent = value;
                    notifyFuelChanged(mFuel, mFuelPercent);
                }
                break;
            case SENSOR_TYPE_FUEL_CONSUMPTION_INS:
                if (Math.abs(mFuelIns - value) > 0.1f) {
                    mFuelIns = value;
                    notifyFuelConsumptionChanged(mFuelIns, mFuelAvg);
                }
                break;
            case SENSOR_TYPE_FUEL_CONSUMPTION_AVG:
                if (Math.abs(mFuelAvg - value) > 0.1f) {
                    mFuelAvg = value;
                    notifyFuelConsumptionChanged(mFuelIns, mFuelAvg);
                }
                break;
            case SENSOR_TYPE_TEMP_INDOOR:
                if (Math.abs(mTempIndoor - value) > 0.5f) {
                    mTempIndoor = value;
                    notifyTemperatureChanged(mTempIndoor, mTempOutdoor);
                }
                break;
            case SENSOR_TYPE_TEMP_OUTDOOR:
                if (Math.abs(mTempOutdoor - value) > 0.5f) {
                    mTempOutdoor = value;
                    notifyTemperatureChanged(mTempIndoor, mTempOutdoor);
                }
                break;
            case SENSOR_TYPE_RANGE:
                if (Math.abs(mRange - value) > 1.0f) {
                    mRange = value;
                    notifyRangeChanged(value);
                }
                break;
            case SENSOR_TYPE_ODOMETER:
                if (Math.abs(mOdometer - value) > 0.1f) {
                    mOdometer = value;
                    notifyOdometerChanged(value);
                    updateSoftTripDistance(value);
                }
                break;
            case SENSOR_TYPE_LIGHT:
                 if (Math.abs(mLight - value) > 1.0f) {
                    mLight = value;
                    notifyLightChanged(value);
                 }
                break;

            // TPMS Logic - Use 0.1PSI / 1C threshold
            case SENSOR_TYPE_TIRE_PRESSURE_FL: if(Math.abs(mTirePressure[0]-value)>0.1f){mTirePressure[0]=value; notifyTireDataChanged(0);} break;
            case SENSOR_TYPE_TIRE_PRESSURE_FR: if(Math.abs(mTirePressure[1]-value)>0.1f){mTirePressure[1]=value; notifyTireDataChanged(1);} break;
            case SENSOR_TYPE_TIRE_PRESSURE_RL: if(Math.abs(mTirePressure[2]-value)>0.1f){mTirePressure[2]=value; notifyTireDataChanged(2);} break;
            case SENSOR_TYPE_TIRE_PRESSURE_RR: if(Math.abs(mTirePressure[3]-value)>0.1f){mTirePressure[3]=value; notifyTireDataChanged(3);} break;
            case SENSOR_TYPE_TIRE_TEMP_FL: if(Math.abs(mTireTemp[0]-value)>1.0f){mTireTemp[0]=value; notifyTireDataChanged(0);} break;
            case SENSOR_TYPE_TIRE_TEMP_FR: if(Math.abs(mTireTemp[1]-value)>1.0f){mTireTemp[1]=value; notifyTireDataChanged(1);} break;
            case SENSOR_TYPE_TIRE_TEMP_RL: if(Math.abs(mTireTemp[2]-value)>1.0f){mTireTemp[2]=value; notifyTireDataChanged(2);} break;
            case SENSOR_TYPE_TIRE_TEMP_RR: if(Math.abs(mTireTemp[3]-value)>1.0f){mTireTemp[3]=value; notifyTireDataChanged(3);} break;
        }
    }

    public void refreshAllValues() {
        if (mSensor == null) return;
        try {
            // [OPTIMIZATION] Apply same thresholds to refresh logic to keep state consistent?
            // Actually refreshAllValues forces an update regardless of cache, usually for UI init.
            // But we should update internal state.

            float newSpeed = mSensor.getSensorLatestValue(SENSOR_TYPE_SPEED) * 3.6f;
            // Force update on refresh
            mSpeed = newSpeed; 
            
            mRpm = mSensor.getSensorLatestValue(SENSOR_TYPE_RPM);
            
            float rawFuel = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL);
             if (rawFuel > 200.0f) {
                 mFuel = rawFuel / 1000.0f;
            } else {
                 mFuel = rawFuel;
            }
            mFuelPercent = mSensor.getSensorLatestValue(SENSOR_TYPE_FUEL_PERCENT);
            
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
            
            // [FIX] Force notify key status to ensure UI sync on startup/refresh (Solving "Unknown" status)
            notifyIgnitionChanged(mIgnition);
            notifyGearChanged(mGear);
            notifyDayNightChanged(mDayNight);
            
            if (mOdometer > 0) {
                 updateSoftTripDistance(mOdometer);
            }
            
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to refresh values", e);
        }
    }
    
    private void updateSoftTripDistance(float currentOdo) {
        if (currentOdo <= 0) return;
        
        SharedPreferences prefs = getPrefs(); // Safe getter logic
        
        if (mStartOdo < 0) {
            mStartOdo = currentOdo;
            mStartTime = System.currentTimeMillis();
            prefs.edit()
                .putFloat(KEY_START_ODO, mStartOdo)
                .putLong(KEY_START_TIME, mStartTime)
                .apply();
             DebugLogger.i(TAG, "Soft Trip Initialized: StartOdo=" + mStartOdo);
        }
        
        mCurrentTripKm = currentOdo - mStartOdo;
        if (mCurrentTripKm < 0) mCurrentTripKm = 0; 
        
        long durationMs = System.currentTimeMillis() - mStartTime;
        mCurrentTripDuration = durationMs / 1000; 
        
        notifyTripDataChanged();
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
    
    public long getTripDuration() { return mCurrentTripDuration; }
    public float getAvgFuelConsumption() { return mAvgFuelConsumption; }

    public boolean isIgnitionOn() {
        return mIgnition == ISensorEvent.IGNITION_STATE_DRIVING;
    }

    public boolean isDayMode() {
        return mDayNight == ISensorEvent.DAY_NIGHT_MODE_DAY;
    }
    
    public boolean isSeatOccupied() {
        return mSeatOccupied;
    }

    public float getCurrentTripKm() { return mCurrentTripKm; }
    public long getCurrentTripDuration() { return mCurrentTripDuration; }

    // --- 监听器管理 (Renamed to register/unregister) ---
    public void registerListener(Listener listener) {
        if (!mListeners.contains(listener)) {
            mListeners.add(listener);
        }
    }

    public void unregisterListener(Listener listener) {
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
        for (Listener l : mListeners) l.onTripDataChanged(mCurrentTripKm, mCurrentTripDuration, mAvgFuelConsumption);
    }

    // [NEW] Notification Methods for Functions
    private void notifySeatOccupiedChanged(boolean occupied) {
        for (Listener l : mListeners) l.onSeatOccupiedChanged(occupied);
    }

    private void notifyDoorChanged(int zone, int status) {
         for (Listener l : mListeners) l.onDoorChanged(zone, status);
    }

    private void notifyTurnSignalChanged(boolean isLeft, boolean isOn) {
        for (Listener l : mListeners) l.onTurnSignalChanged(isLeft, isOn);
    }
    
    private void notifyFunctionChanged(int functionId, int zone, int value) {
        for (Listener l : mListeners) l.onFunctionChanged(functionId, zone, value);
    }

    private void notifyCustomizeFunctionChanged(int functionId, int zone, float value) {
        for (Listener l : mListeners) l.onCustomizeFunctionChanged(functionId, zone, value);
    }

    public void destroy() {
        if (mSensor != null && mSensorListener != null) {
            try {
                mSensor.unregisterListener(mSensorListener);
                DebugLogger.i(TAG, "Unregistered sensors");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error unregistering sensors", e);
            }
        }
        
        if (mCarFunction != null && mFunctionWatcher != null) {
            try {
                mCarFunction.unregisterFunctionValueWatcher(mFunctionWatcher);
                DebugLogger.i(TAG, "Unregistered function watchers");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error unregistering function watchers", e);
            }
        }
        
        mListeners.clear();
        mSensorListener = null;
        mFunctionWatcher = null;
        mSensor = null;
        mCarFunction = null;
        mIsInitialized = false;
        sInstance = null;
    }
}
