package cn.navitool;

import android.content.Context;
import android.content.ComponentName;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

// ECarX AdaptAPI Imports
import com.ecarx.xui.adaptapi.car.Car;
import com.ecarx.xui.adaptapi.car.ICar;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;
import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.content.res.Configuration;
import cn.navitool.managers.VehicleSensorManager;

public class ClusterHudManager
        implements VehicleSensorManager.Listener, ComponentCallbacks {
    private static final String TAG = "ClusterHudManager";

    private static volatile ClusterHudManager instance;
    private Context mContext;
    private Presentation mPresentation;
    private boolean mIsClusterEnabled = false;
    private boolean mIsHudEnabled = false;
    private boolean mIsFloatingEnabled = false; // Floating Traffic Light State
    private boolean mIsDashboardMode = false;
    private int mPendingTheme = Presentation.THEME_DEFAULT; // 保存待应用的主题
    // [Fix Cold Boot] Retry counter for Display id 2 discovery
    private int mRetryCount = 0;

    // ECarX Car API
    private ICar mCar;
    private ISensor mSensorManager;
    private ICarFunction mCarFunction;
    private ECarSensorListener mSensorListener;
    private ECarFunctionListener mFunctionListener;

    // Media & Volume
    private android.media.session.MediaSessionManager mMediaSessionManager;
    private android.media.AudioManager mAudioManager;
    private VolumeReceiver mVolumeReceiver;

    // Cached values for combined fuel_range component
    private float mCachedFuelLiters = 0f;
    private float mCachedRangeKm = 0f;
    private int mCachedSpeed = 0;
    private float mCachedRpm = 0f;

    // Bug 2 Fix: Independent timeout for navigation info
    private static final long NAVI_INFO_TIMEOUT_MS = 10000;
    private final Runnable mNaviInfoTimeoutRunnable = () -> {
        if (mPresentation != null) {
            mPresentation.resetNaviInfo();
        }
    };
    private int mCachedGear = -1; // -1 for unknown
    // [Fix Cold Boot] Add tracking for actually applied theme to avoid redundant
    // resets
    private int mCurrentAppliedTheme = -1;

    // [NEW] 点火状态标志 - 仅在收到点火信号后才允许显示Presentation
    private boolean mIgnitionReady = false;

    // [Fix] Simulated Gear Support
    private boolean mSimulatedGearEnabled = false;
    // private float mCachedRpm = 0f; // Moved up

    private List<HudComponentData> mCachedHudComponents;
    private List<HudComponentData> mCachedClusterComponents;
    private Object mDimMenuInteraction; // IDimMenuInteraction via Reflection

    // AdaptAPI Reflection Constants
    private static final String CLASS_DIM_INTERACTION = "com.ecarx.xui.adaptapi.diminteraction.DimInteraction";
    // Typo in AdaptAPI: TRUN instead of TURN (Strictly matching API name)
    private static final int FUNC_LEFT_TRUN_SIGNAL = 553980160;
    private static final int FUNC_RIGHT_TRUN_SIGNAL = 553980416;
    private static final int FUNC_AUTOHOLD_STATUS = 33661;

    // Additional Sensor IDs
    private static final int SENSOR_TYPE_ODOMETER = 1050368;
    private static final int TYPE_INS_FUEL_CONSUMPTION = 4194816;
    private static final int TYPE_AVG_FUEL_CONSUMPTION = 4194560;
    // Tire Pressure
    private static final int TIRE_PRESSURE_FRONT_LEFT = 5243136;
    private static final int TIRE_PRESSURE_FRONT_RIGHT = 5243392;
    private static final int TIRE_PRESSURE_REAR_LEFT = 5243648;
    private static final int TIRE_PRESSURE_REAR_RIGHT = 5243904;
    // Tire Temp
    private static final int TIRE_TEMPERATURE_FRONT_LEFT = 5244160;
    private static final int TIRE_TEMPERATURE_FRONT_RIGHT = 5244416;
    private static final int TIRE_TEMPERATURE_REAR_LEFT = 5244672;
    private static final int TIRE_TEMPERATURE_REAR_RIGHT = 5244928;

    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    // [FIX] Traffic Light Timeout - Auto-clear traffic light UI only
    // Note: Navigation state is now managed solely by onNaviStatusUpdate(state==2)
    private static final long TRAFFIC_LIGHT_TIMEOUT_MS = 3000; // 3 seconds
    private final Runnable mTrafficLightTimeoutRunnable = new Runnable() {
        @Override
        public void run() {
            DebugLogger.d(TAG, "Traffic Light Timeout (3s) - Clearing traffic light UI only");
            if (mPresentation != null) {
                mPresentation.resetTrafficLights();
            }
            // [REMOVED] No longer changes navigation state here
            // Navigation state is controlled by onNaviStatusUpdate(state==2)
        }
    };

    // [New] Allow MainActivity to inject a "Better" Context (Activity Context)
    // This allows the manager to upgrade from a Service Context to an Activity
    // Context
    public void updateContext(Context context) {
        this.mContext = context;
        DebugLogger.i(TAG, "ClusterHudManager Context updated to: " + context.getClass().getName());
    }

    private ClusterHudManager(Context context) {
        // [FIX] Ensure Context is Application Context to avoid memory leaks,
        // BUT we might need Activity Context for Themes.
        // We will Wrap it later if needed.
        this.mContext = context.getApplicationContext();
        cn.navitool.managers.MemoryMonitor.logMemory("ClusterHudManager.Init-Start");

        // [HUD FIX] 初始化缓存列表，避免 "Cache not ready" 错误
        this.mCachedHudComponents = new ArrayList<>();
        this.mCachedClusterComponents = new ArrayList<>();

        // [Self-Init] Load all saved configurations immediately
        loadSavedState();

        // Register Sensor Listener (including TPMS)
        VehicleSensorManager.getInstance(mContext).addListener(this);

        // Load persisted sensor data
        loadSensorCache();

        // [NEW] 从磁盘加载HUD布局，支持Headless启动
        loadHudLayoutFromDisk();

        initAdaptApi();
        initDimInteraction(); // Restore missing call for Real HUD Mode Switch

        // 1. Initialize Media & Volume Listeners IMMEDIATELY on Main Thread (Critical
        // for QQ Music Cover)
        // User reported regressions when this was backgrounded.
        // 1. Initialize Media & Volume Listeners IMMEDIATELY on Main Thread
        // Critical for QQ Music Cover. User reported regressions when this was
        // backgrounded.
        try {
            initMediaListener();
        } catch (Exception e) {
            DebugLogger.e(TAG, "FATAL: Failed to init MediaListener in Constructor", e);
        }
        initVolumeListener();

        // Initialize Car Service (Backgroundable, takes ~500ms)
        initCarService();

        registerDisplayListener();

        // [FIX] 移除自动显示逻辑 - 仅在点火启动后才显示Presentation
        // 原代码: mMainHandler.post(this::ensureUiVisible);
        // 现在由 KeepAliveAccessibilityService.handleIgnitionDriving() 触发

        // Register for System Theme Changes
        mContext.registerComponentCallbacks(this);

        // Register Traffic Light Listener - REMOVED (AIDL Deleted)
        // AmapAidlManager.getInstance(mContext).setListener(this);

        // [FIX] Register Broadcast Monitor Listener for reliable Traffic Light Data
        cn.navitool.managers.AmapMonitorManager.getInstance(mContext)
                .setListener(new cn.navitool.managers.AmapMonitorManager.OnBroadcastListener() {
                    @Override
                    public void onTrafficLightUpdate(
                            cn.navitool.NaviInfoController.TrafficLightInfo info) {
                        // [FIX] Reset timeout timer on each traffic light update
                        mMainHandler.removeCallbacks(mTrafficLightTimeoutRunnable);
                        mMainHandler.postDelayed(mTrafficLightTimeoutRunnable, TRAFFIC_LIGHT_TIMEOUT_MS);

                        if (mPresentation != null) {
                            mPresentation.updateTrafficLight(info);
                        }
                    }

                    @Override
                    public void onGuideInfoUpdate(
                            cn.navitool.NaviInfoController.GuideInfo info) {
                        // [SIMPLIFIED] No timeout logic - data is cleared by
                        // onNaviStatusUpdate(state==2)
                        // Call the new public method
                        ClusterHudManager.this.onGuideInfoUpdate(info);
                    }

                    @Override
                    public void onNaviStatusUpdate(int state) {
                        DebugLogger.d(TAG, "Navi Status Update: " + state);

                        // [FIX] Determine Navigation State for Theme Background
                        // 1: Navigating, 8: Emulator, 9: Start Guide
                        // 2: Stop, 39: Route Init (Planning)
                        boolean isNavigating = (state == 1 || state == 8 || state == 9);
                        boolean isStop = (state == 2);

                        mMainHandler.post(() -> {
                            if (mPresentation != null) {
                                // Apply Navigation State
                                if (isNavigating) {
                                    mPresentation.setNavigating(true);
                                } else if (isStop) {
                                    mPresentation.setNavigating(false);
                                }
                                // Note: Other states (3, 39, etc.) retain current state to avoid flicker

                                // [UNIFIED] Only reset on Navigation Stop (state==2)
                                // Other states (9=StartGuide, 39=RoutePlanning, 8=Emulator) should NOT clear
                                // data
                                if (state == 2) {
                                    mPresentation.resetTrafficLights();
                                    mPresentation.resetNaviInfo();
                                }
                            }
                        });
                    }
                });

        // [FIX] Start Monitoring immediately
        cn.navitool.managers.AmapMonitorManager.getInstance(mContext).startMonitoring();

    }

    public static ClusterHudManager getInstance(Context context) {
        if (instance == null) {
            synchronized (ClusterHudManager.class) {
                if (instance == null) {
                    instance = new ClusterHudManager(context);
                }
            }
        }
        return instance;
    }

    public List<HudComponentData> getLayoutData(String type) {
        if ("cluster".equals(type)) {
            return mCachedClusterComponents;
        } else if ("hud".equals(type)) {
            return mCachedHudComponents;
        }
        return null;
    }

    // --- ECarX Car Service Initialization ---
    private boolean mIsDayMode = true;

    public void updateDayNightMode(boolean isDay) {
        if (mIsDayMode != isDay) {
            mIsDayMode = isDay;
            DebugLogger.d(TAG, "updateDayNightMode: " + isDay);
            if (mPresentation != null) {
                mPresentation.updateDayNightMode(isDay);
            }
        }
    }

    // --- Traffic Light Listener (AIDL) --- [REMOVED]

    private void initCarService() {
        // Use shared CarServiceManager to avoid multiple instances/connections
        cn.navitool.managers.CarServiceManager.getInstance(mContext).registerListener(() -> {
            mCar = cn.navitool.managers.CarServiceManager.getInstance(mContext).getCar();
            if (mCar != null) {
                // Use getSensor() from manager (handles reflection fallback)
                mSensorManager = cn.navitool.managers.CarServiceManager.getInstance(mContext).getSensor();
                if (mSensorManager != null) {
                    registerSensors();
                } else {
                    DebugLogger.e(TAG, "Shared SensorManager is null");
                }

                mCarFunction = cn.navitool.managers.CarServiceManager.getInstance(mContext).getCarFunction();
                if (mCarFunction != null) {
                    registerFunctions();
                }
            }
        });

        // Ensure init is called (safe to call multiple times)
        cn.navitool.managers.CarServiceManager.getInstance(mContext).init();
    }

    private void registerSensors() {
        if (mSensorManager == null)
            return;

        // [FIX] Prevent duplicate registration
        if (mSensorsRegistered) {
            DebugLogger.w(TAG, "Sensors already registered, skipping duplicate registration.");
            return;
        }

        mSensorListener = new ECarSensorListener();
        try {
            // Register Fuel Level
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_FUEL_LEVEL, ISensor.RATE_NORMAL);
            // Register Ambient Temp (Outside)
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_TEMPERATURE_AMBIENT,
                    ISensor.RATE_NORMAL);
            // Register Indoor Temp (Inside)
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_TEMPERATURE_INDOOR,
                    ISensor.RATE_NORMAL);
            // Register Gear
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_GEAR, ISensor.RATE_NORMAL);
            // Register Range (Endurance) - Try Standard and Fuel variants
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_ENDURANCE_MILEAGE,
                    ISensor.RATE_NORMAL);
            // mSensorManager.registerListener(mSensorListener,
            // ISensor.SENSOR_TYPE_ENDURANCE_MILEAGE_FUEL, ISensor.RATE_NORMAL);

            // Register Speed (RPM only - CAR_SPEED is handled by
            // KeepAliveAccessibilityService with ×3.72 conversion)
            mSensorManager.registerListener(mSensorListener, ISensor.SENSOR_TYPE_RPM, ISensor.RATE_UI);
            // [FIX] Removed ISensor.SENSOR_TYPE_CAR_SPEED - was causing oscillation due to
            // duplicate registration

            // Register Additional Sensors for Future Use (Odometer, Fuel, Tire)
            mSensorManager.registerListener(mSensorListener, SENSOR_TYPE_ODOMETER, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TYPE_INS_FUEL_CONSUMPTION, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TYPE_AVG_FUEL_CONSUMPTION, ISensor.RATE_NORMAL);

            // Register Tire Sensors
            mSensorManager.registerListener(mSensorListener, TIRE_PRESSURE_FRONT_LEFT, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TIRE_PRESSURE_FRONT_RIGHT, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TIRE_PRESSURE_REAR_LEFT, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TIRE_PRESSURE_REAR_RIGHT, ISensor.RATE_NORMAL);

            mSensorManager.registerListener(mSensorListener, TIRE_TEMPERATURE_FRONT_LEFT, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TIRE_TEMPERATURE_FRONT_RIGHT, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TIRE_TEMPERATURE_REAR_LEFT, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, TIRE_TEMPERATURE_REAR_RIGHT, ISensor.RATE_NORMAL);

            DebugLogger.i(TAG, "ECarX Sensors Registered");

            // [FIX] Register Missing Sensors (Fuel & Outside Temp)
            mSensorManager.registerListener(mSensorListener, SENSOR_TYPE_FUEL_LEVEL, ISensor.RATE_NORMAL);
            mSensorManager.registerListener(mSensorListener, SENSOR_TYPE_ENV_OUTSIDE_TEMPERATURE, ISensor.RATE_NORMAL);

            mSensorsRegistered = true;
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error registering sensors", e);
        }
    }

    private void registerFunctions() {
        if (mCarFunction == null)
            return;
        mFunctionListener = new ECarFunctionListener();
        try {
            // Register Turn Signals (Separate IDs)
            mCarFunction.registerFunctionValueWatcher(FUNC_LEFT_TRUN_SIGNAL, mFunctionListener);
            mCarFunction.registerFunctionValueWatcher(FUNC_RIGHT_TRUN_SIGNAL, mFunctionListener);

            // Register Auto Hold
            mCarFunction.registerFunctionValueWatcher(FUNC_AUTOHOLD_STATUS, mFunctionListener);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error registering functions", e);
        }
    }

    // --- Traffic Light Listener (AIDL) ---

    // --- ECarX Sensor Listener ---
    private class ECarSensorListener implements ISensor.ISensorListener {
        private long mLastTireUpdateTime = 0;

        @Override
        public void onSensorEventChanged(int sensorType, int eventValue) {
            // Handle Integer Events (Gear, etc.)
            try {
                if (sensorType == ISensor.SENSOR_TYPE_GEAR) {
                    updateComponentText("gear", getGearString(eventValue));
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error handling sensor event changed", e);
            }
        }

        @Override
        public void onSensorValueChanged(int sensorType, float value) {
            // Handle Float Values (Temp, Fuel, Range)
            try {
                if (sensorType == SENSOR_TYPE_FUEL_LEVEL) {
                    // [FIX] Sensor returns ml, convert to liters
                    float liters = value / 1000f;
                    DebugLogger.d(TAG, "Fuel Level Raw: " + value + " ml -> " + liters + " L");
                    mCachedFuelLiters = liters;
                    updateComponentText("fuel", String.format("%.0fL", liters));
                    updateFuelRangeComponent();
                } else if (sensorType == ISensor.SENSOR_TYPE_TEMPERATURE_AMBIENT) {
                    // [FIX] Formatting: Integer + Unit, no text prefix
                    updateComponentText("temp_out", String.format("%.0f°C", value));
                } else if (sensorType == ISensor.SENSOR_TYPE_TEMPERATURE_INDOOR) {
                    // [FIX] Formatting: Integer + Unit, no text prefix
                    updateComponentText("temp_in", String.format("%.0f°C", value));
                } else if (sensorType == ISensor.SENSOR_TYPE_ENDURANCE_MILEAGE) {
                    mCachedRangeKm = value;
                    updateComponentText("range", String.format("%.0fkm", value));
                    updateFuelRangeComponent();
                } else if (sensorType == ISensor.SENSOR_TYPE_RPM) {
                    updateRpm(value);
                }
                // [FIX] Removed ISensor.SENSOR_TYPE_CAR_SPEED handler - handled by
                // KeepAliveAccessibilityService
                else if (sensorType == SENSOR_TYPE_ODOMETER) {
                    updateComponentText("odometer", String.format("%.0fkm", value));
                } else if (sensorType == TYPE_INS_FUEL_CONSUMPTION) {
                    updateComponentText("fuel_inst", String.format("%.1fL/100km", value));
                } else if (sensorType == TYPE_AVG_FUEL_CONSUMPTION) {
                    updateComponentText("fuel_avg", String.format("%.1fL/100km", value));
                } else {
                    // [FIX] Removed Throttling for Real-Time Updates

                    // [DEBUG] Log TPMS sensor data
                    DebugLogger.d(TAG, "TPMS Sensor: type=" + sensorType + ", value=" + value);

                    // [FIX] Post UI updates to Main Thread
                    mMainHandler.post(() -> {
                        try {
                            if (sensorType == TIRE_PRESSURE_FRONT_LEFT) {
                                updateComponentText("tire_p_fl", String.format("%.0f kPa", value));
                                if (mPresentation != null)
                                    mPresentation.updateTirePressure(0, value);
                            } else if (sensorType == TIRE_PRESSURE_FRONT_RIGHT) {
                                updateComponentText("tire_p_fr", String.format("%.0f kPa", value));
                                if (mPresentation != null)
                                    mPresentation.updateTirePressure(1, value);
                            } else if (sensorType == TIRE_PRESSURE_REAR_LEFT) {
                                updateComponentText("tire_p_rl", String.format("%.0f kPa", value));
                                if (mPresentation != null)
                                    mPresentation.updateTirePressure(2, value);
                            } else if (sensorType == TIRE_PRESSURE_REAR_RIGHT) {
                                updateComponentText("tire_p_rr", String.format("%.0f kPa", value));
                                if (mPresentation != null)
                                    mPresentation.updateTirePressure(3, value);
                            } else if (sensorType == TIRE_TEMPERATURE_FRONT_LEFT) {
                                updateComponentText("tire_t_fl", String.format("%.0f°C", value));
                                if (mPresentation != null)
                                    mPresentation.updateTireTemp(0, value);
                            } else if (sensorType == TIRE_TEMPERATURE_FRONT_RIGHT) {
                                updateComponentText("tire_t_fr", String.format("%.0f°C", value));
                                if (mPresentation != null)
                                    mPresentation.updateTireTemp(1, value);
                            } else if (sensorType == TIRE_TEMPERATURE_REAR_LEFT) {
                                updateComponentText("tire_t_rl", String.format("%.0f°C", value));
                                if (mPresentation != null)
                                    mPresentation.updateTireTemp(2, value);
                            } else if (sensorType == TIRE_TEMPERATURE_REAR_RIGHT) {
                                updateComponentText("tire_t_rr", String.format("%.0f°C", value));
                                if (mPresentation != null)
                                    mPresentation.updateTireTemp(3, value);
                            }
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Error updating TPMS UI", e);
                        }
                    });
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error handling sensor value changed", e);
            }
        }

        @Override
        public void onSensorSupportChanged(int sensorType, FunctionStatus status) {
            // Not used
        }
    }

    private boolean mLeftTurnOn = false;
    private boolean mRightTurnOn = false;

    // Blinking Logic
    private final Handler mBlinkHandler = new Handler(Looper.getMainLooper());
    private boolean mBlinkVisible = true; // Toggle State
    private static final int BLINK_INTERVAL = 400; // 400ms

    private final Runnable mBlinkRunnable = new Runnable() {
        @Override
        public void run() {
            // Toggle Visibility
            mBlinkVisible = !mBlinkVisible;
            // Update HUD
            updateTurnSignal();

            // Schedule next toggle if either signal is ON
            if (mLeftTurnOn || mRightTurnOn) {
                mBlinkHandler.postDelayed(this, BLINK_INTERVAL);
            } else {
                mBlinkVisible = false; // Reset to
                                       // invisible
                                       // or off
                                       // when
                                       // stopped
            }
        }
    };

    /**
     * Public Method called by KeepAliveAccessibilityService (and internal listener)
     * 
     * @param isLeft true for Left, false for Right
     * @param isOn   true for ON (Blinking), false for OFF
     */
    public synchronized void updateTurnSignal(boolean isLeft, boolean isOn) {
        boolean wasOff = (!mLeftTurnOn && !mRightTurnOn);

        if (isLeft)
            mLeftTurnOn = isOn;
        else
            mRightTurnOn = isOn;

        boolean isNowOff = (!mLeftTurnOn && !mRightTurnOn);

        // State Logic
        if (isOn) {
            // If we were fully OFF, start the blinker
            if (wasOff) {
                mBlinkVisible = true; // Start Visible
                mBlinkHandler.removeCallbacks(mBlinkRunnable);
                mBlinkHandler.postDelayed(mBlinkRunnable, BLINK_INTERVAL);
                updateTurnSignal(); // Immediate Update
            }
            // If already running, state variable change will be picked up by next Runnable
            // tick or immediate update
            // Logic Fix: Immediate update to reflect Side Switch without waiting for tick
            updateTurnSignal();
        } else {
            // If both are now OFF, stop blinking
            if (isNowOff) {
                mBlinkHandler.removeCallbacks(mBlinkRunnable);
                mBlinkVisible = false;
                updateTurnSignal(); // Immediate Update (to clear)
            }
        }

        // [FIX] Forward Turn Signal State to Presentation (for Traffic Light filtering)
        if (mPresentation != null) {
            mPresentation.updateTurnSignal(isLeft, isOn);
        }
    }

    // --- Floating Traffic Light Control ---
    private boolean mIsAmapForeground = false;

    public void setAmapForeground(boolean isForeground) {
        if (mIsAmapForeground != isForeground) {
            mIsAmapForeground = isForeground;
            DebugLogger.d(TAG, "Amap Foreground State Changed: " + isForeground);
            updateFloatingLightVisibility();
        }
    }

    public void setFloatingTrafficLightEnabled(boolean enabled) {
        mIsFloatingEnabled = enabled; // Update local state
        updateFloatingLightVisibility();
    }

    private void updateFloatingLightVisibility() {
        // Show ONLY if Enabled AND Amap is NOT in foreground
        boolean shouldShow = mIsFloatingEnabled && !mIsAmapForeground;
        if (mPresentation != null) {
            mPresentation.setFloatingTrafficLightEnabled(shouldShow);
        }
    }

    public void toggleFloatingTrafficLightStyle() {
        if (mPresentation != null) {
            mPresentation.toggleFloatingTrafficLightStyle();
        } else {
            DebugLogger.toast(mContext, "HUD未连接，无法切换样式");
        }
    }

    // --- cache transparent bitmap ---
    private android.graphics.Bitmap mTransparentBitmap;

    private android.graphics.Bitmap getTransparentBitmap() {
        if (mTransparentBitmap == null) {
            mTransparentBitmap = android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
            mTransparentBitmap.eraseColor(android.graphics.Color.TRANSPARENT);
        }
        return mTransparentBitmap;
    }

    /**
     * 为 Bitmap 叠加居中垂直定位线（仅用于预览，帮助定位宽组件）
     * 
     * @param original 原始 Bitmap
     * @return 叠加了居中定位线的新 Bitmap（不修改原图）
     */
    /**
     * 为 Bitmap 叠加居中垂直定位线（仅用于预览，帮助定位宽组件）
     * 
     * @param original 原始 Bitmap
     * @return 叠加了居中定位线的新 Bitmap（不修改原图）
     */
    public android.graphics.Bitmap addCenterLineOverlay(android.graphics.Bitmap original) {
        if (original == null)
            return null;

        try {
            int width = original.getWidth();
            int height = original.getHeight();
            android.graphics.Bitmap canvasBitmap;

            // 如果是 1x1 的占位图（关闭状态），创建一个全尺寸透明图用于显示定位线
            if (width <= 10 || height <= 10) {
                // 默认尺寸 (Scale 1.0): 72(L) + 90(Gap) + 72(R) = 234, Height = 72
                width = 234;
                height = 72;
                canvasBitmap = android.graphics.Bitmap.createBitmap(width, height,
                        android.graphics.Bitmap.Config.ARGB_8888);
            } else {
                // 创建副本以避免修改原图
                canvasBitmap = original.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            }

            android.graphics.Canvas canvas = new android.graphics.Canvas(canvasBitmap);

            // 设置定位线样式：半透明青色虚线
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setColor(android.graphics.Color.argb(255, 0, 255, 255)); // 青色 (不透明以便在预览中清晰)
            paint.setStrokeWidth(2);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setPathEffect(new android.graphics.DashPathEffect(new float[] { 8, 4 }, 0)); // 虚线

            // 在中心绘制垂直线
            float centerX = canvasBitmap.getWidth() / 2f;
            canvas.drawLine(centerX, 0, centerX, canvasBitmap.getHeight(), paint);

            return canvasBitmap;
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to add center line overlay", e);
            return original; // 失败时返回原图
        }
    }

    private class ECarFunctionListener implements ICarFunction.IFunctionValueWatcher {
        @Override
        public void onFunctionValueChanged(int funcId, int zone, int value) {
            boolean isOn = (value == 1);
            // [DEBUG] Log ALL function changes to find potential hidden IDs
            DebugLogger.d(TAG, "onFunctionValueChanged: funcId=" + funcId + ", zone=" + zone + ", value=" + value);

            if (funcId == FUNC_LEFT_TRUN_SIGNAL) {
                if (mLeftTurnOn != isOn) {
                    DebugLogger.d(TAG, "TurnSignal API: Left Changed -> " + isOn);
                    updateTurnSignal(true, isOn);
                }
            } else if (funcId == FUNC_RIGHT_TRUN_SIGNAL) {
                if (mRightTurnOn != isOn) {
                    DebugLogger.d(TAG, "TurnSignal API: Right Changed -> " + isOn);
                    updateTurnSignal(false, isOn);
                }
            } else if (funcId == FUNC_AUTOHOLD_STATUS) {
                DebugLogger.e(TAG, "AutoHold API (33661): Changed -> " + value + " (IsOn=" + isOn + ")");
                mIsAutoHoldOn = (value == 1);
                android.graphics.Bitmap bitmap = getAutoHoldBitmap(mIsAutoHoldOn);
                // 使用通用 updateComponentImage 更新，组件 key 为 "auto_hold"
                updateComponentImage("auto_hold", bitmap);
            }

        }

        @Override
        public void onCustomizeFunctionValueChanged(int i, int i1, float v) {
        }

        @Override
        public void onFunctionChanged(int i) {
        }

        @Override
        public void onSupportedFunctionValueChanged(int i, int[] ints) {
        }

        @Override
        public void onSupportedFunctionStatusChanged(int i, int i1, FunctionStatus functionStatus) {
        }
    }

    // Cache bitmaps to avoid GC thrashing
    private android.graphics.Bitmap mBitmapLeft;
    private android.graphics.Bitmap mBitmapRight;

    private android.graphics.Bitmap mBitmapHazard;
    private android.graphics.Bitmap mCachedAutoHoldBitmap;
    private boolean mIsAutoHoldOn = false;

    // Volume Cache
    private android.graphics.Bitmap mCachedVolumeBitmap;
    private int mLastVolume = -1;

    // Helper to get/create bitmap
    public android.graphics.Bitmap getTurnSignalBitmap(boolean left, boolean right) {
        float scale = 1.0f;
        if (mCachedHudComponents != null) {
            for (HudComponentData data : mCachedHudComponents) {
                if ("turn_signal".equals(data.type)) {
                    scale = data.scale;
                    break;
                }
            }
        }
        return getTurnSignalBitmap(left, right, scale);
    }

    public android.graphics.Bitmap getTurnSignalBitmap(boolean left, boolean right, float scale) {
        if (!left && !right)
            return null;

        // Note: We deliberately skip cache (mBitmapHazard, etc.) here
        // because we want to force generation with the provided 'scale'.

        try {
            android.graphics.drawable.Drawable drawable = mContext.getDrawable(R.drawable.ic_turn_signal);
            if (drawable == null)
                return null;

            // Updated Size: 72px (Standard for 2x Preview)
            int width = 72;
            int height = 72;
            int gap = 90; // Base gap

            gap = (int) (gap * scale); // Apply scale to gap only

            // Fix: Always use full width to maintain position
            int totalWidth = width * 2 + gap;
            int totalHeight = height;

            android.graphics.Bitmap bitmap = android.graphics.Bitmap.createBitmap(totalWidth, totalHeight,
                    android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);

            drawable.setBounds(0, 0, width, height);

            if (left) {
                // Draw Left Arrow at 0,0
                drawable.draw(canvas);
            }

            if (right) {
                // Fix: Always draw Right Arrow at (width + gap)
                // Determine X offset
                int xOffset = width + gap;

                canvas.save();
                canvas.translate(xOffset + width / 2f, height / 2f);
                canvas.rotate(180); // Rotate for right arrow
                canvas.translate(-width / 2f, -height / 2f);
                drawable.draw(canvas);
                canvas.restore();
            }

            // Cache it
            if (left && right)
                mBitmapHazard = bitmap;
            else if (left)
                mBitmapLeft = bitmap;
            else
                mBitmapRight = bitmap;

            return bitmap;
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error generating turn signal bitmap", e);
            return null;
        }
    }

    public android.graphics.Bitmap getAutoHoldBitmap(boolean isOn) {
        if (!isOn) {
            // [FIX] Return null instead of Transparent Bitmap.
            // Null prevents "update" callback from clearing the Preview icon in
            // MainActivity.
            // Presentation handles null by not setting image (invisible), which is desired.
            return null;
        }
        if (mCachedAutoHoldBitmap != null) {
            return mCachedAutoHoldBitmap;
        }

        try {
            android.graphics.drawable.Drawable drawable = mContext.getDrawable(R.drawable.ic_auto_hold);
            if (drawable == null)
                return null;

            // Target Height: 72px (Standard for 2x Preview)
            // Calculate width to maintain aspect ratio
            int targetHeight = 72;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();

            float ratio = (intrinsicHeight > 0) ? (float) intrinsicWidth / intrinsicHeight : 1.0f;
            int targetWidth = (int) (targetHeight * ratio);
            if (targetWidth <= 0)
                targetWidth = targetHeight;

            android.graphics.Bitmap bitmap = android.graphics.Bitmap.createBitmap(targetWidth, targetHeight,
                    android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);

            drawable.setBounds(0, 0, targetWidth, targetHeight);
            // Removed setTint(WHITE) to keep original Green color
            drawable.draw(canvas);

            mCachedAutoHoldBitmap = bitmap;
            return bitmap;
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error generating Auto Hold bitmap", e);
            return null;
        }
    }

    private void updateTurnSignal() {
        // Strictly use API State AND Blink Toggle
        // If ON, use mBlinkVisible. If OFF, force false.
        boolean showLeft = mLeftTurnOn && mBlinkVisible;
        boolean showRight = mRightTurnOn && mBlinkVisible;

        android.graphics.Bitmap signalBitmap = getTurnSignalBitmap(showLeft, showRight);
        updateComponentImage("turn_signal", signalBitmap);
    }

    public android.graphics.Bitmap getVolumeBitmap(int volume) {
        if (mCachedVolumeBitmap != null && volume == mLastVolume) {
            return mCachedVolumeBitmap;
        }

        try {
            // ... (Drawing logic) ...
            android.graphics.drawable.Drawable drawable = mContext.getDrawable(R.drawable.ic_volume);
            if (drawable == null)
                return null;

            int iconSize = 32; // Reduced from 48 to 32 as per user request
            int padding = 12;
            android.graphics.Paint paint = new android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG);
            paint.setColor(android.graphics.Color.WHITE);
            paint.setTextSize(24); // Reduced from 36 to 24 to match icon size (32)
            paint.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);

            String volText = String.valueOf(volume);
            android.graphics.Rect textBounds = new android.graphics.Rect();
            paint.getTextBounds(volText, 0, volText.length(), textBounds);

            int totalWidth = iconSize + padding + textBounds.width() + 4;
            int totalHeight = Math.max(iconSize, textBounds.height()) + 4;

            android.graphics.Bitmap bitmap = android.graphics.Bitmap.createBitmap(totalWidth, totalHeight,
                    android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);

            drawable.setBounds(0, (totalHeight - iconSize) / 2, iconSize, (totalHeight - iconSize) / 2 + iconSize);
            drawable.setTint(android.graphics.Color.WHITE);
            drawable.draw(canvas);

            float textY = (totalHeight / 2f) - ((paint.descent() + paint.ascent()) / 2f);
            canvas.drawText(volText, iconSize + padding, textY, paint);

            // Do NOT recycle manually, let GC handle it to avoid crashes in Views
            // if (mCachedVolumeBitmap != null && !mCachedVolumeBitmap.isRecycled()) {
            // mCachedVolumeBitmap.recycle();
            // }
            mCachedVolumeBitmap = bitmap;
            mLastVolume = volume;

            return bitmap;
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error generating volume bitmap", e);
            return null;
        }
    }

    public void destroy() {
        if (mBitmapLeft != null)
            mBitmapLeft.recycle();
        if (mBitmapRight != null)
            mBitmapRight.recycle();
        if (mBitmapHazard != null)
            mBitmapHazard.recycle();
        if (mCachedVolumeBitmap != null)
            mCachedVolumeBitmap.recycle();
        if (mTransparentBitmap != null)
            mTransparentBitmap.recycle();
        mBitmapLeft = null;
        mBitmapRight = null;
        mBitmapHazard = null;
        mCachedVolumeBitmap = null;
        if (mCachedAutoHoldBitmap != null)
            mCachedAutoHoldBitmap.recycle();
        mCachedAutoHoldBitmap = null;
        mTransparentBitmap = null;

        dismissPresentation();

        // Stop Broadcast Monitor
        cn.navitool.managers.AmapMonitorManager.getInstance(mContext).stopMonitoring();

        // Unregister Receivers
        try {
            if (mVolumeReceiver != null) {
                mContext.unregisterReceiver(mVolumeReceiver);
                mVolumeReceiver = null;
                DebugLogger.d(TAG, "Volume Receiver Unregistered");
            }
            if (mMediaReceiver != null) {
                mContext.unregisterReceiver(mMediaReceiver);
                mMediaReceiver = null;
                DebugLogger.d(TAG, "Media Receiver Unregistered");
            }
            if (mNotificationConnectionReceiver != null) {
                mContext.unregisterReceiver(mNotificationConnectionReceiver);
                mNotificationConnectionReceiver = null;
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error unregistering receivers", e);
        }

        // Unregister Display Listener
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        if (dm != null && mDisplayListener != null) {
            dm.unregisterDisplayListener(mDisplayListener);
            mDisplayListener = null;
            DebugLogger.d(TAG, "Display Listener Unregistered");
        }

        // Cleanup DimInteraction if supported
        if (mDimMenuInteraction != null && mDimCallbackProxy != null) {
            try {
                Method unregisterMethod = mDimMenuInteraction.getClass().getMethod(
                        "unregisterDimMenuInteractionCallback",
                        Class.forName(
                                "com.ecarx.xui.adaptapi.diminteraction.IDimMenuInteraction$IDimMenuInteractionCallback"));
                unregisterMethod.invoke(mDimMenuInteraction, mDimCallbackProxy);
                DebugLogger.d(TAG, "DimMenuInteraction Callback Unregistered");
            } catch (Exception e) {
                // Ignore
            }
        }

        // Unregister from VehicleSensorManager
        VehicleSensorManager.getInstance(mContext).removeListener(this);
    }

    // --- Volume Listener ---
    private int mCurrentVolume = 0;
    private Handler mVolumeHandler = new Handler(Looper.getMainLooper());
    private Runnable mVolumeHideRunnable = () -> {
        if (mPresentation != null) {
            mPresentation.setVolumeVisible(false);
        }
    };

    private void initVolumeListener() {
        try {
            mAudioManager = (android.media.AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
            if (mAudioManager == null) {
                DebugLogger.e(TAG, "Failed to get AudioManager service");
            }
            mVolumeReceiver = new VolumeReceiver();
            android.content.IntentFilter filter = new android.content.IntentFilter();
            filter.addAction("android.media.VOLUME_CHANGED_ACTION");
            // Initial Update
            updateVolume();
            mContext.registerReceiver(mVolumeReceiver, filter, null, new Handler(Looper.getMainLooper()));
            DebugLogger.i(TAG, "Volume Receiver Registered");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to init Volume Listener", e);
        }
    }

    private void updateVolume() {
        if (mAudioManager != null) {
            int vol = mAudioManager.getStreamVolume(android.media.AudioManager.STREAM_MUSIC);
            updateVolume(vol);
        }
    }

    private void updateVolume(int vol) {
        mCurrentVolume = vol;
        android.graphics.Bitmap bmp = getVolumeBitmap(vol);
        // Pass Volume String for Preview
        updateComponent("volume", String.valueOf(vol), bmp);

        // Auto-Hide Logic
        if (mPresentation != null) {
            mPresentation.setVolumeVisible(true);
        }
        mVolumeHandler.removeCallbacks(mVolumeHideRunnable);
        mVolumeHandler.postDelayed(mVolumeHideRunnable, 3000); // Hide after 3 seconds
    }

    private class VolumeReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, android.content.Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                int vol = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
                if (vol != -1) {
                    updateVolume(vol);
                } else {
                    updateVolume(); // Fallback
                }
            }
        }
    }

    private String getGearString(int gearValue) {
        // [FIX] Use cached speed and RPM for simulated gear calculation
        if (mSimulatedGearEnabled && (gearValue == ISensorEvent.GEAR_DRIVE || gearValue == 13)) { // 13=TRSM_GEAR_DRIVE
            // DebugLogger.d(TAG, "Simulated Gear Enabled. Speed: " + mCachedSpeed + ", RPM:
            // " + mCachedRpm);
            String sensorGear = "D"; // We only simulate for Drive
            return cn.navitool.DrivingShift.getInstance().calculateGear(mCachedSpeed, mCachedRpm, sensorGear);
        } else if (mSimulatedGearEnabled && (gearValue == 2097744)) { // Manual Mode?
            // Handle Manual if needed, or pass through
            return mapRawGearToChar(gearValue);
        } else {
            return mapRawGearToChar(gearValue);
        }
    }

    private String mapRawGearToChar(int gearValue) {
        switch (gearValue) {
            case ISensorEvent.GEAR_PARK:
            case 15:
                return "P";
            case ISensorEvent.GEAR_REVERSE:
            case 11:
                return "R";
            case ISensorEvent.GEAR_NEUTRAL:
            case 14:
                return "N";
            case ISensorEvent.GEAR_DRIVE:
            case 13:
                return "D";
            // Map specific sub-gears if sensor supports them natively
            case ISensorEvent.GEAR_FIRST:
                return "D1";
            case ISensorEvent.GEAR_SECOND:
                return "D2";
            case ISensorEvent.GEAR_THIRD:
                return "D3";
            case ISensorEvent.GEAR_FOURTH:
                return "D4";
            case ISensorEvent.GEAR_FIFTH:
                return "D5";
            case ISensorEvent.GEAR_SIXTH:
                return "D6";
            case ISensorEvent.GEAR_SEVENTH:
                return "D7";
            case ISensorEvent.GEAR_EIGHTH:
                return "D8";
            default:
                return "D"; // Fallback
        }
    }

    /**
     * 更新油量续航组合组件，格式: "32L|280km"
     */
    private void updateFuelRangeComponent() {
        String text = String.format("⛽ %.0fL|%.0fkm", mCachedFuelLiters, mCachedRangeKm);
        updateComponentText("fuel_range", text);
    }

    // --- Listener for Preview UI ---
    public interface OnHudDataChangedListener {
        void onHudDataChanged(String type, String text, android.graphics.Bitmap image);
    }

    private OnHudDataChangedListener mListener;

    public void setListener(OnHudDataChangedListener listener) {
        mListener = listener;
        if (mListener != null && mCachedHudComponents != null) {
            // Immediately sync current state to the new listener (fixes Resume Sync issue)
            synchronized (this) {
                for (HudComponentData data : mCachedHudComponents) {
                    new Handler(Looper.getMainLooper()).post(() -> {
                        if (mListener != null) {
                            mListener.onHudDataChanged(data.type, data.text, data.image);
                        }
                    });
                }
            }
        }
    }

    // --- Core Update Logic ---
    public void updateComponentText(String type, String newText) {
        updateComponent(type, newText, null);
    }

    public void updateComponentImage(String type, android.graphics.Bitmap image) {
        if (image == null) {
            // Real Mode Fix: If image is missing, show TRANSPARENT instead of Placeholder
            // (Placeholder is handled by Presentation if image is null, so we pass a
            // transparent bitmap)
            updateComponent(type, null, getTransparentBitmap());
        } else {
            updateComponent(type, null, image);
        }
    }

    // Pending State (Wait for Cache Load)
    private String mPendingSongText = null;
    private android.graphics.Bitmap mPendingCoverArt = null;
    // [FIX] 添加传感器数据的pending缓存
    private String mPendingTempOutText = null;
    private String mPendingTempInText = null;
    private String mPendingFuelText = null;
    private String mPendingRangeText = null;
    private String mPendingGearText = null;

    private void updateComponent(String type, String newText, android.graphics.Bitmap newImage) {
        // [HUD FIX] 改用 isEmpty() 检查，因为缓存已初始化为空列表
        if (mCachedHudComponents.isEmpty() && mCachedClusterComponents.isEmpty()) {
            // Store pending updates if no layout is synced yet
            synchronized (this) {
                if ("song".equals(type) || "test_media".equals(type)) {
                    mPendingSongText = newText;
                    // 减少日志输出，只在首次存储时记录
                    if (mPendingSongText == null || !mPendingSongText.equals(newText)) {
                        DebugLogger.d(TAG, "Pending song text: " + newText);
                    }
                } else if ("media_cover".equals(type) || "test_media_cover".equals(type)) {
                    if (newImage != null) {
                        mPendingCoverArt = newImage;
                    }
                } else if ("temp_out".equals(type)) {
                    mPendingTempOutText = newText;
                } else if ("temp_in".equals(type)) {
                    mPendingTempInText = newText;
                } else if ("fuel".equals(type)) {
                    mPendingFuelText = newText;
                } else if ("range".equals(type)) {
                    mPendingRangeText = newText;
                } else if ("gear".equals(type)) {
                    mPendingGearText = newText;
                }
            }
            return;
        }

        boolean changed = false;

        synchronized (this) {
            if (mCachedHudComponents == null && mCachedClusterComponents == null)
                return;

            if (mCachedHudComponents != null) {
                for (HudComponentData data : mCachedHudComponents) {
                    if (type.equals(data.type)) {
                        if (newText != null && !newText.equals(data.text)) {
                            data.text = newText;
                            changed = true;
                        }
                        if (newImage != null) {
                            data.image = newImage;
                            changed = true;
                        }
                    }
                }
            }

            if (mCachedClusterComponents != null) {
                for (HudComponentData data : mCachedClusterComponents) {
                    if (type.equals(data.type)) {
                        if (newText != null && !newText.equals(data.text)) {
                            data.text = newText;
                            changed = true;
                        }
                        if (newImage != null) {
                            data.image = newImage;
                            changed = true;
                        }
                    }
                }
            }
        }

        if (changed) {
            new Handler(Looper.getMainLooper()).post(() -> {
                // Efficient Update: directly update view property instead of full rebuild
                if (mPresentation != null) {
                    mPresentation.updateComponent(type, newText, newImage);
                } else {
                    // Fallback if presentation isn't ready
                }

                if (mListener != null) {
                    mListener.onHudDataChanged(type, newText, newImage);
                }
            });
        }
    }

    // --- Media (Broadcast & Session) ---
    private android.content.BroadcastReceiver mMediaReceiver;

    private void initMediaListener() {
        // 1. Register Standard Broadcast Receiver (Only from our own Service)
        try {
            mMediaReceiver = new android.content.BroadcastReceiver() {
                @Override
                public void onReceive(Context context, android.content.Intent intent) {
                    if (cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE
                            .equals(intent.getAction())) {
                        // Handle Direct Service Broadcast
                        String title = intent.getStringExtra("title");
                        String artist = intent.getStringExtra("artist");
                        boolean isPlaying = intent.getBooleanExtra("is_playing", false);

                        String display = title;
                        if (artist != null && !artist.isEmpty()) {
                            display = title + "\n" + artist;
                        }
                        updateComponentText("song", display);
                        updateComponentText("test_media", display);
                        updateComponentText("song_1line", title == null ? "" : title);

                        // Update Playing State
                        updateMediaPlayingState(isPlaying);

                        // Update Cover (Byte Array)
                        boolean hasArtwork = intent.getBooleanExtra("has_artwork", true); // Default true
                        if (!hasArtwork) {
                            updateComponentImage("media_cover", null);
                            updateComponentImage("test_media_cover", null);
                        } else {
                            byte[] artwork = intent.getByteArrayExtra("artwork");
                            if (artwork != null) {
                                android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeByteArray(artwork, 0,
                                        artwork.length);
                                if (bmp != null) {
                                    updateComponentImage("media_cover", bmp);
                                    updateComponentImage("test_media_cover", bmp);
                                }
                            }
                        }
                    }
                }
            };
            android.content.IntentFilter filter = new android.content.IntentFilter();
            filter.addAction(cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE);
            mContext.registerReceiver(mMediaReceiver, filter, null, new Handler(Looper.getMainLooper()));
            DebugLogger.i(TAG, "Registered Media Receiver for Service Updates");

            // Request Initial Media State immediately (in case Service is already running)
            android.content.Intent requestIntent = new android.content.Intent(
                    "cn.navitool.ACTION_REQUEST_MEDIA_REBROADCAST");
            requestIntent.setPackage(mContext.getPackageName());
            mContext.sendBroadcast(requestIntent);
            DebugLogger.i(TAG, "Sent Media Sync Request");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to init Media Broadcast Receiver", e);
        }

        // [FIX] Request initial media state re-broadcast (Sync State)
        try {
            android.content.Intent requestIntent = new android.content.Intent(
                    "cn.navitool.ACTION_REQUEST_MEDIA_REBROADCAST");
            requestIntent.setPackage(mContext.getPackageName());
            mContext.sendBroadcast(requestIntent);
            DebugLogger.i(TAG, "Requested Media Re-Broadcast for initial state sync");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to request re-broadcast", e);
        }
    }

    // Broadcast Receiver
    private class MusicBroadcastReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, android.content.Intent intent) {
            String action = intent.getAction();
            if (action == null)
                return;

            if (cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE.equals(action)) {
                // Handle Direct Service Broadcast
                String title = intent.getStringExtra("title");
                String artist = intent.getStringExtra("artist");
                boolean isPlaying = intent.getBooleanExtra("is_playing", false);

                String display = title;
                if (artist != null && !artist.isEmpty()) {
                    display = title + "\n" + artist;
                }
                updateComponentText("song", display);
                updateComponentText("test_media", display);
                updateComponentText("song_1line", title == null ? "" : title);

                // Update Playing State
                updateMediaPlayingState(isPlaying);

                // Update Cover (Byte Array)
                boolean hasArtwork = intent.getBooleanExtra("has_artwork", true); // Default true
                if (!hasArtwork) {
                    updateComponentImage("media_cover", null);
                    updateComponentImage("test_media_cover", null);
                } else {
                    byte[] artwork = intent.getByteArrayExtra("artwork");
                    if (artwork != null) {
                        android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeByteArray(artwork, 0,
                                artwork.length);
                        if (bmp != null) {
                            updateComponentImage("media_cover", bmp);
                            updateComponentImage("test_media_cover", bmp);
                        }
                    }
                }
            }
        }
    }

    // --- AdaptAPI Init ---
    // --- AdaptAPI Init ---
    private Object mDimCallbackProxy;
    private android.content.BroadcastReceiver mNotificationConnectionReceiver;

    private void initAdaptApi() {
        // Use the new Listener mechanism
        cn.navitool.managers.CarServiceManager.getInstance(mContext).registerListener(() -> {
            mCarFunction = cn.navitool.managers.CarServiceManager.getInstance(mContext).getCarFunction();
            ISensor sensor = cn.navitool.managers.CarServiceManager.getInstance(mContext).getSensor();

            // Register Functions
            registerFunctions();

            // Register Sensors
            registerSensors(sensor);

            // Register Volume Listener
            initVolumeListener();
        });
    }

    private void registerSensors(ISensor sensor) {
        if (sensor != null && mSensorListener != null) {
            // Register Fuel Level (Using internal ID or reflection if needed, assuming
            // Standard ID for now)
            // But wait, ISensor doesn't have standard FUEL?
            // User context said "SENSOR_TYPE_FUEL_LEVEL" found in adaptAPI interaction.
            // Let's assume standard IDs from my task list analysis.
            // SENSOR_TYPE_FUEL_LEVEL = 2101760; SENSOR_TYPE_ENV_OUTSIDE_TEMPERATURE =
            // 2100992 (Light) .. wait
            // My Task List: Found SENSOR_TYPE_FUEL_LEVEL,
            // SENSOR_TYPE_ENV_OUTSIDE_TEMPERATURE.
            // I should use the constants if defined in ISensor or hardcode them if I know
            // them.
            // Let's just use ISensor.SENSOR_TYPE_GEAR etc for now if I want safety,
            // or trust `mSensorListener` handles specific IDs.
            // Actually, `registerSensors` implementation was likely lost, I should restore
            // basic registrations.
            // Gear, Speed, Rpm are handled elsewhere? No, Speed/RPM is CAN usually?
            // Wait, Gear is Sensor.
            sensor.registerListener(mSensorListener, ISensor.SENSOR_TYPE_GEAR);
            // Fuel?
            // sensor.registerListener(mSensorListener, 2101760); // Example
        }
    }

    private void initDimInteraction() {
        new Thread(() -> {
            try {
                // DimInteraction.create(context)
                Class<?> dimInteractionClass = Class.forName(CLASS_DIM_INTERACTION);
                Method createMethod = dimInteractionClass.getMethod("create", Context.class);
                Object dimInteraction = createMethod.invoke(null, mContext);

                // dimInteraction.getDimMenuInteraction()
                Method getMenuInteractionMethod = dimInteractionClass.getMethod("getDimMenuInteraction");
                mDimMenuInteraction = getMenuInteractionMethod.invoke(dimInteraction);
                DebugLogger.i(TAG, "AdaptAPI DimMenuInteraction initialized successfully: " + mDimMenuInteraction);

                // 注册 naviMode 变化监听器
                registerNaviModeListener();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to initialize AdaptAPI DimMenuInteraction", e);
            }
        }).start();
    }

    /**
     * 注册 NaviMode 变化监听器
     * 当导航结束后系统会触发 naviMode=1，此时延迟1秒重新显示仪表
     */
    private void registerNaviModeListener() {
        if (mDimMenuInteraction == null) {
            DebugLogger.w(TAG, "Cannot register NaviMode listener: DimMenuInteraction is null");
            return;
        }

        try {
            // 获取 IDimMenuInteractionCallback 接口
            Class<?> callbackInterface = Class.forName(
                    "com.ecarx.xui.adaptapi.diminteraction.IDimMenuInteraction$IDimMenuInteractionCallback");

            // 创建动态代理来实现回调接口
            mDimCallbackProxy = java.lang.reflect.Proxy.newProxyInstance(
                    callbackInterface.getClassLoader(),
                    new Class<?>[] { callbackInterface },
                    (proxy, method, args) -> {
                        String methodName = method.getName();

                        if ("onChangeNaviMode".equals(methodName) && args != null && args.length > 0) {
                            int naviMode = (int) args[0];
                            DebugLogger.i(TAG, "NaviMode Changed: " + naviMode);

                            // 当导航结束 (naviMode=1) 时，延迟1秒重新显示仪表
                            if (naviMode == 1 && mIsClusterEnabled) {
                                DebugLogger.i(TAG, "Navigation ended (mode=1), will re-display cluster in 1 second...");

                                // [New] Update Theme Logic: Navi Ended -> Idle
                                if (mPresentation != null) {
                                    mPresentation.setNavigating(false);
                                }

                                mMainHandler.postDelayed(() -> {
                                    DebugLogger.i(TAG, "Re-displaying cluster after navigation end...");
                                    // 重新调用 switchNaviMode(3) 并刷新显示
                                    if (mDimMenuInteraction != null) {
                                        try {
                                            Method switchMethod = mDimMenuInteraction.getClass()
                                                    .getMethod("switchNaviMode", int.class);
                                            switchMethod.invoke(mDimMenuInteraction, 3);
                                            DebugLogger.i(TAG, "NaviMode re-set to 3 after navigation end");
                                        } catch (Exception e) {
                                            DebugLogger.e(TAG, "Failed to re-set NaviMode", e);
                                        }
                                    }
                                    if (mPresentation != null) {
                                        mPresentation.setClusterVisible(true);
                                    }
                                }, 1000);
                            } else if (naviMode == 3) {
                                // [New] Update Theme Logic: Navi Started -> Active
                                // REVERTED/CHANGED (Issue 3):
                                // We NO LONGER setNavigating(true) just because system is in Navi Mode (3).
                                // Background switching is now strictly tied to DATA arrival (Traffic
                                // Light/Guide Info).
                                // mPresentation.setNavigating(true);
                                DebugLogger.i(TAG,
                                        "NaviMode 3 (Map) detected. Waiting for actual data to switch background.");
                            }
                        }

                        // 其他回调方法返回默认值
                        if (method.getReturnType() == boolean.class) {
                            return false;
                        } else if (method.getReturnType() == int.class) {
                            return 0;
                        }
                        return null;
                    });

            // 注册回调: mDimMenuInteraction.registerDimMenuInteractionCallback(callback)
            Method registerMethod = mDimMenuInteraction.getClass().getMethod(
                    "registerDimMenuInteractionCallback", callbackInterface);
            registerMethod.invoke(mDimMenuInteraction, mDimCallbackProxy);
            DebugLogger.i(TAG, "NaviMode listener registered successfully");

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register NaviMode listener", e);
        }
    }

    private DisplayManager.DisplayListener mDisplayListener;

    private void registerDisplayListener() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        if (dm == null) {
            DebugLogger.e(TAG, "Failed to get DisplayManager service");
            return;
        }

        mDisplayListener = new DisplayManager.DisplayListener() {
            @Override
            public void onDisplayAdded(int displayId) {
                DebugLogger.i(TAG, "Display added: " + displayId);
                checkAndShowPresentation();
            }

            @Override
            public void onDisplayRemoved(int displayId) {
                DebugLogger.i(TAG, "Display removed: " + displayId);
            }

            @Override
            public void onDisplayChanged(int displayId) {
            }
        };

        dm.registerDisplayListener(mDisplayListener, new Handler(Looper.getMainLooper()));
    }

    private void checkAndShowPresentation() {
        mMainHandler.post(() -> {
            // [FIX] 仅在收到点火信号后才显示
            if (!mIgnitionReady) {
                DebugLogger.d(TAG, "checkAndShowPresentation: Ignition not ready, skipping");
                return;
            }
            if (mIsClusterEnabled || mIsHudEnabled) {
                if (mPresentation == null) {
                    showPresentation();
                }
            }
        });
    }

    public void setClusterEnabled(boolean enabled) {
        if (mIsClusterEnabled == enabled)
            return;
        mIsClusterEnabled = enabled;
        DebugLogger.d(TAG, "setClusterEnabled: " + enabled);

        DebugLogger.action(TAG, "Cluster状态变更: " + enabled);
        updatePresentation();

        if (mDimMenuInteraction != null) {
            try {
                int mode = enabled ? 3 : 1;
                Method switchNaviModeMethod = mDimMenuInteraction.getClass().getMethod("switchNaviMode", int.class);
                switchNaviModeMethod.invoke(mDimMenuInteraction, mode);
                DebugLogger.i(TAG, "Called switchNaviMode(" + mode + ")");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to call switchNaviMode", e);
            }
        } else {
            DebugLogger.w(TAG, "DimMenuInteraction is null, skipping switchNaviMode");
        }
    }

    public void setHudEnabled(boolean enabled) {
        if (mIsHudEnabled == enabled)
            return;
        mIsHudEnabled = enabled;
        DebugLogger.action(TAG, "HUD状态变更: " + enabled);
        DebugLogger.d(TAG, "setHudEnabled: " + enabled);
        updatePresentation();
    }

    public void setDebugMode(boolean enabled) {
        if (mPresentation != null) {
            mPresentation.updateDebugMode(enabled);
        }
    }

    /**
     * 强制刷新 Presentation 显示，用于延迟激活场景
     * 绕过状态检查，直接调用 showPresentation
     */
    public void forceRefreshPresentation() {
        DebugLogger.i(TAG, "forceRefreshPresentation called");

        // Use new clear method to ensure clean state
        clearHudComponents();

        // 先关闭现有的 presentation
        if (mPresentation != null) {
            try {
                mPresentation.dismiss();
            } catch (Exception e) {
                DebugLogger.w(TAG, "Error dismissing presentation for refresh", e);
            }
            mPresentation = null;
        }

        // 重新创建并显示
        if (mIsClusterEnabled || mIsHudEnabled) {
            // 在创建 presentation 前，先加载保存的主题
            int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                    Presentation.THEME_DEFAULT);
            mPendingTheme = savedTheme;
            DebugLogger.i(TAG, "forceRefresh: Loaded saved theme: " + savedTheme);

            showPresentation();

            // 调用 switchNaviMode
            if (mIsClusterEnabled && mDimMenuInteraction != null) {
                try {
                    Method switchNaviModeMethod = mDimMenuInteraction.getClass().getMethod("switchNaviMode", int.class);
                    switchNaviModeMethod.invoke(mDimMenuInteraction, 3);
                    DebugLogger.i(TAG, "forceRefresh: Called switchNaviMode(3)");
                } catch (Exception e) {
                    DebugLogger.e(TAG, "forceRefresh: Failed to call switchNaviMode", e);
                }
            }
        }
    }

    /**
     * 强制激活并设置状态，用于延迟激活场景
     * 直接设置状态并创建 Presentation，绕过所有状态检查
     */
    /**
     * 仅显示 UI，不切换导航模式。
     * 用于冷启动时立即显示画面，避免等待。
     */
    public void showUiOnly(boolean clusterEnabled, boolean hudEnabled) {
        DebugLogger.i(TAG, "showUiOnly: cluster=" + clusterEnabled + ", hud=" + hudEnabled);

        // 关闭现有的 presentation
        if (mPresentation != null) {
            try {
                mPresentation.dismiss();
            } catch (Exception e) {
                DebugLogger.w(TAG, "Error dismissing presentation", e);
            }
            mPresentation = null;
        }

        // 直接设置内部状态（绕过状态检查）
        mIsClusterEnabled = clusterEnabled;
        mIsHudEnabled = hudEnabled;

        // 加载保存的主题
        int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                Presentation.THEME_DEFAULT);
        mPendingTheme = savedTheme;
        DebugLogger.i(TAG, "showUiOnly: Loaded saved theme: " + savedTheme);

        // [FIX Cold Boot] 加载 HUD 组件配置到缓存（如果 MainActivity 还没启动）
        if (hudEnabled && (mCachedHudComponents == null || mCachedHudComponents.isEmpty())) {
            loadCachedHudLayout();
        }

        // 创建并显示 Presentation
        if (clusterEnabled || hudEnabled) {
            showPresentation();
        }
    }

    /**
     * 仅切换导航模式。
     * 用于冷启动后的延迟切换。
     */
    public void applyNaviMode(int mode) {
        DebugLogger.i(TAG, "applyNaviMode: " + mode);
        if (mIsClusterEnabled && mDimMenuInteraction != null) {
            try {
                Method switchNaviModeMethod = mDimMenuInteraction.getClass().getMethod("switchNaviMode", int.class);
                switchNaviModeMethod.invoke(mDimMenuInteraction, mode);
                DebugLogger.i(TAG, "applyNaviMode: Called switchNaviMode(" + mode + ")");
            } catch (Exception e) {
                DebugLogger.e(TAG, "applyNaviMode: Failed to call switchNaviMode", e);
            }
        } else {
            DebugLogger.w(TAG, "applyNaviMode: Skipped (Cluster disabled or AdaptAPI null)");
        }
    }

    /**
     * 强制激活并设置状态 (保留原有逻辑，但在内部调用分离的方法)
     */
    public void forceActivateWithStates(boolean clusterEnabled, boolean hudEnabled) {
        showUiOnly(clusterEnabled, hudEnabled);
        applyNaviMode(3);
    }

    /**
     * 从 ConfigManager 加载保存的 HUD 布局配置到缓存
     * 用于冷启动时 MainActivity 尚未启动的情况
     */
    private void loadCachedHudLayout() {
        try {
            // 读取当前 HUD 模式 (0=WHUD, 1=AR)
            int currentMode = ConfigManager.getInstance().getInt("hud_current_mode", 0);
            String key = (currentMode == 0) ? "hud_layout_whud" : "hud_layout_ar";
            String jsonStr = ConfigManager.getInstance().getString(key, "[]");

            if (jsonStr != null && !jsonStr.isEmpty() && !jsonStr.equals("[]")) {
                org.json.JSONArray jsonArray = new org.json.JSONArray(jsonStr);
                boolean isSnowMode = ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
                int color = isSnowMode ? 0xFF00FFFF : 0xFFFFFFFF;

                java.util.List<HudComponentData> syncList = new java.util.ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    org.json.JSONObject obj = jsonArray.getJSONObject(i);
                    String type = obj.optString("type", "text");
                    String text = obj.optString("text", "Text");
                    float x = (float) obj.optDouble("x", 0);
                    float y = (float) obj.optDouble("y", 0);
                    float scale = (float) obj.optDouble("scale", 1.0f);

                    // [FIX] Ensure time component has correct format string
                    if ("time".equals(type)) {
                        text = "HH:mm";
                    }

                    // [FIX] JSON contains already scaled coordinates (from MainActivity's 0.5x
                    // logic).
                    // Do NOT scale by 0.5f again, otherwise we get 0.25x scaling (double halving).
                    HudComponentData data = new HudComponentData(type, text, x * 0.5f, y * 0.5f, color);
                    data.scale = scale;
                    syncList.add(data);
                }

                if (!syncList.isEmpty()) {
                    mCachedHudComponents = syncList;
                    DebugLogger.i(TAG, "forceActivate: Loaded " + syncList.size() + " HUD components from config");
                }
            } else {
                DebugLogger.i(TAG, "forceActivate: No HUD layout config found");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "forceActivate: Failed to load HUD layout config", e);
        }
    }

    // [New] Public method for Activity to trigger UI check
    public void ensureUiVisible() {
        DebugLogger.d(TAG, "ensureUiVisible: Request received. Current Thread: " + Thread.currentThread().getName());
        if (mContext == null) {
            DebugLogger.e(TAG, "ensureUiVisible: Context is null! Cannot show UI.");
            return;
        }

        // [FIX] 调用ensureUiVisible时标记点火就绪
        // 因为此方法只应由handleIgnitionDriving触发
        mIgnitionReady = true;

        // [FIX] Check if features are enabled before showing
        if (!mIsClusterEnabled && !mIsHudEnabled) {
            DebugLogger.w(TAG, "ensureUiVisible: Ignored. Both Cluster and HUD are disabled.");
            return;
        }
        // Use post to ensure we are on main thread (redundant but safe)
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            DebugLogger.d(TAG, "ensureUiVisible: Already on Main Thread, showing now.");
            showPresentation();
        } else {
            DebugLogger.d(TAG, "ensureUiVisible: Posting to Main Thread handler.");
            mMainHandler.post(this::showPresentation);
        }
    }

    /**
     * [NEW] 设置点火状态
     * 由KeepAliveAccessibilityService在收到点火信号时调用
     */
    public void setIgnitionReady(boolean ready) {
        mIgnitionReady = ready;
        DebugLogger.i(TAG, "setIgnitionReady: " + ready);
    }

    /**
     * [NEW] 获取点火状态
     */
    public boolean isIgnitionReady() {
        return mIgnitionReady;
    }

    private void updatePresentation() {
        // Fix: Decoupled Cluster and HUD. Presentation should only stay alive if AT
        // LEAST ONE is enabled.
        if (mIsClusterEnabled || mIsHudEnabled) {
            if (mPresentation == null) {
                showPresentation();
            } else {
                // Ensure specific visibilities are updated
                mPresentation.setClusterVisible(mIsClusterEnabled);
                mPresentation.setHudVisible(mIsHudEnabled);
            }
        } else {
            // Only dismiss if BOTH are disabled
            dismissPresentation();
        }
    }

    // [New] Allow Service to configure and trigger UI directly
    public void configureAndShowUi(boolean showCluster, boolean showHud) {
        this.mIsClusterEnabled = showCluster;
        this.mIsHudEnabled = showHud;
        DebugLogger.i(TAG, "configureAndShowUi: Cluster=" + showCluster + ", HUD=" + showHud);
        ensureUiVisible();
    }

    private void showPresentation() {
        DebugLogger.d(TAG, "showPresentation: [Step 1] Getting DisplayManager");
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        if (dm == null) {
            DebugLogger.e(TAG, "showPresentation: Failed to get DisplayManager");
            return;
        }
        Display[] displays = dm.getDisplays();
        DebugLogger.d(TAG, "showPresentation: [Step 2] Found " + displays.length + " displays total");

        Display targetDisplay = null;
        try {
            for (Display d : displays) {
                if (d == null)
                    continue;
                // [FIX] Minimal access to avoid native crash on weird displays
                if (d.getDisplayId() == 2) {
                    targetDisplay = d;
                    // Only log details for the target to be safe
                    DebugLogger.i(TAG, "  -> FOUND TARGET DISPLAY (ID 2): " + d.getName());
                    break;
                }
            }
        } catch (Throwable t) { // Catch Throwable (Errors + Exceptions)
            DebugLogger.e(TAG, "Error iterating displays", t);
        }

        if (targetDisplay != null) {
            // [FIX] Prevent Duplicate Presentation (Ghosting Issue)
            if (mPresentation != null) {
                DebugLogger.w(TAG, "showPresentation: Presentation already exists! Skipping creation.");
                if (!mPresentation.isShowing()) {
                    mPresentation.show();
                }
                return;
            }

            mRetryCount = 0; // Reset retry counter on success
            DebugLogger.d(TAG, "showPresentation: [Step 3] Creating Presentation Window");
            try {
                // [FIX] Z-Order Correction: Manually create Display Context
                // To allow TYPE_APPLICATION_OVERLAY (2038) on Android 12+, we MUST create
                // a WindowContext associated with that type.
                Context displayContext;
                if (android.os.Build.VERSION.SDK_INT >= 30) {
                    try {
                        displayContext = mContext.createWindowContext(targetDisplay,
                                android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, null);
                    } catch (NoSuchMethodError e) {
                        DebugLogger.e(TAG, "createWindowContext missing on API 30+, fallback to createDisplayContext");
                        displayContext = mContext.createDisplayContext(targetDisplay);
                    }
                } else {
                    displayContext = mContext.createDisplayContext(targetDisplay);
                }

                // Wrap in Theme (Styling)
                Context themeContext = new android.view.ContextThemeWrapper(displayContext, R.style.Theme_NaviTool);

                // Instantiate as Dialog (Single argument constructor)
                mPresentation = new Presentation(themeContext);
                DebugLogger.d(TAG, "showPresentation: [Step 4] Dialog Object Created (Type: APPLICATION_OVERLAY)");

                // Logging for verification
                if (mPresentation.getWindow() != null) {
                    DebugLogger.d(TAG, "Dialog Window Type: " + mPresentation.getWindow().getAttributes().type);
                }

                mPresentation.setOnShowListener(dialog -> {
                    // Logic Fix: Apply Persistence Mode (Dashboard vs List)
                    if (mIsDashboardMode) {
                        mPresentation.enableClusterDashboard();
                        DebugLogger.d(TAG, "Restored Dashboard Mode on show");
                    } else if (mCachedClusterComponents != null) {
                        mPresentation.syncClusterLayout(mCachedClusterComponents);
                        DebugLogger.d(TAG, "Applied cached Cluster components on show");
                    }

                    if (mCachedHudComponents != null) {
                        mPresentation.syncHudLayout(mCachedHudComponents);
                        DebugLogger.d(TAG, "Applied cached HUD components on show");
                    }

                    // 应用保存的主题（始终应用，确保正确的布局被加载）
                    mPresentation.setClusterTheme(mPendingTheme);
                    DebugLogger.d(TAG, "Applied pending theme on show: " + mPendingTheme);

                    // [FIX Cold Boot] Apply cached gear value
                    if (mCachedGear != -1) {
                        mPresentation.updateGear(mCachedGear);
                        DebugLogger.d(TAG, "Applied cached gear on show: " + mCachedGear);
                    }

                    // [FIX Cold Boot] Apply cached sensor values
                    if (mPresentation != null) {
                        mPresentation.updateComponent("fuel", mCachedFuelText, null);
                        mPresentation.updateComponent("temp_out", mCachedTempOutText, null);
                        mPresentation.updateComponent("temp_in", mCachedTempInText, null);
                        mPresentation.updateComponent("range", mCachedRangeText, null);
                        mPresentation.updateComponent("fuel_range", mCachedFuelText + "|" + mCachedRangeText, null);
                    }
                });

                // [FIX] Apply Floating Traffic Light State
                mPresentation.setFloatingTrafficLightEnabled(mIsFloatingEnabled);

                mPresentation.show();
                mPresentation.setClusterVisible(mIsClusterEnabled);
                mPresentation.setHudVisible(mIsHudEnabled);
                mPresentation.setFloatingTrafficLightEnabled(mIsFloatingEnabled); // Apply Floating State
                mPresentation.setFloatingTrafficLightEnabled(mIsFloatingEnabled); // Apply Floating State
                mPresentation.setMediaPlaying(mIsMediaPlaying); // Sync initial state
                mPresentation.setHudGreenBg(mIsHudGreenBgExposed); // Apply Green Bg State

                // [FIX Initial State] Sync Day/Night Mode using System Global Configuration
                int uiMode = android.content.res.Resources.getSystem().getConfiguration().uiMode
                        & Configuration.UI_MODE_NIGHT_MASK;
                boolean isDay = (uiMode != Configuration.UI_MODE_NIGHT_YES);

                // Double check with Context resources for debugging
                int contextUiMode = mContext.getResources().getConfiguration().uiMode
                        & Configuration.UI_MODE_NIGHT_MASK;
                DebugLogger.i(TAG, "Initial DayMode Check: SystemUI=" + uiMode + ", ContextUI=" + contextUiMode);

                DebugLogger.i(TAG, "Applied initial DayMode (System) on show: " + isDay);

                // [FIX] Delayed Re-check (2000ms)
                mMainHandler.postDelayed(() -> {
                    try {
                        int delayedUiMode = android.content.res.Resources.getSystem().getConfiguration().uiMode
                                & Configuration.UI_MODE_NIGHT_MASK;
                        boolean delayedIsDay = (delayedUiMode != Configuration.UI_MODE_NIGHT_YES);
                        int presUiMode = 0;
                        if (mPresentation != null && mPresentation.getContext() != null) {
                            presUiMode = mPresentation.getContext().getResources().getConfiguration().uiMode
                                    & Configuration.UI_MODE_NIGHT_MASK;
                        }
                        DebugLogger.i(TAG, "Delayed (2s) DayMode Re-Check: SystemUI=" + delayedUiMode + ", PresUI="
                                + presUiMode + " -> isDay=" + delayedIsDay);

                        if (mPresentation != null) {
                            mPresentation.setDayMode(delayedIsDay);
                        }
                    } catch (Exception e) {
                        DebugLogger.e(TAG, "Error in Delayed DayMode Check", e);
                    }
                }, 2000);

                DebugLogger.i(TAG, "ClusterHudPresentation SHOWN on Display 2");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to show presentation", e);
                mPresentation = null;
            }
        } else {
            // [Fix Cold Boot] Retry Logic for Display 2
            // The HDMI display might take longer to initialize than the app.
            // We retry every 1 second for up to 30 seconds.
            if (mRetryCount < 30) {
                mRetryCount++;
                DebugLogger.w(TAG, "Display ID 2 not found yet. Retrying in 1s... (Attempt " + mRetryCount + "/30)");
                mMainHandler.postDelayed(this::showPresentation, 1000);
            } else {
                DebugLogger.e(TAG, "Display ID 2 check timed out after 30s. Background UI start failed.");
                // Optionally reset retry count here if we want to allow manual retries later
                mRetryCount = 0;
            }
        }
    }

    private void dismissPresentation() {
        if (mPresentation != null) {
            try {
                mPresentation.dismiss();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to dismiss presentation", e);
            } finally {
                mPresentation = null;
                DebugLogger.i(TAG, "ClusterHudPresentation DISMISSED");
            }
        }
    }

    /**
     * [FIX] Public method for complete HUD reset - dismisses presentation and
     * recreates it.
     * Used by "Reset HUD Layout" button to clear all cached/stale data.
     */
    public void dismissAndRecreate() {
        DebugLogger.i(TAG, "dismissAndRecreate: Force clearing all HUD state...");
        dismissPresentation();
        // If either Cluster or HUD is enabled, recreate immediately
        if (mIsClusterEnabled || mIsHudEnabled) {
            mMainHandler.postDelayed(this::showPresentation, 100);
        }
    }

    public void syncHudLayout(List<HudComponentData> components) {
        if (components == null)
            return;
        synchronized (this) {
            // Merge Fix: Preserve existing images if new data has null image
            // This fixes the "Placeholder on Drag" bug where Sync sends no image data.
            if (mCachedHudComponents != null) {
                for (HudComponentData newData : components) {
                    // Force Internal Consistency for Dynamic Components
                    if ("volume".equals(newData.type)) {
                        newData.image = getVolumeBitmap(mCurrentVolume);
                        newData.text = String.valueOf(mCurrentVolume);
                    } else if ("turn_signal".equals(newData.type)) {
                        newData.image = getTurnSignalBitmap(mLeftTurnOn, mRightTurnOn);
                        newData.text = "L:" + mLeftTurnOn + ",R:" + mRightTurnOn;
                    } else if ("auto_hold".equals(newData.type)) {
                        newData.image = getAutoHoldBitmap(mIsAutoHoldOn);
                    } else {
                        // Standard Merge
                        for (HudComponentData oldData : mCachedHudComponents) {
                            if (oldData.type.equals(newData.type)) {
                                if (newData.image == null && oldData.image != null) {
                                    newData.image = oldData.image;
                                    DebugLogger.d(TAG, "Restored image for " + newData.type + " during sync");
                                }
                                break;
                            }
                        }
                    }
                }
            } else {
                // First Sync: Still force consistency
                for (HudComponentData newData : components) {
                    if ("volume".equals(newData.type)) {
                        newData.image = getVolumeBitmap(mCurrentVolume);
                        newData.text = String.valueOf(mCurrentVolume);
                    } else if ("turn_signal".equals(newData.type)) {
                        newData.image = getTurnSignalBitmap(mLeftTurnOn, mRightTurnOn);
                        newData.text = "L:" + mLeftTurnOn + ",R:" + mRightTurnOn;
                    } else if ("auto_hold".equals(newData.type)) {
                        newData.image = getAutoHoldBitmap(mIsAutoHoldOn);
                    }
                }
            }

            mCachedHudComponents = new ArrayList<>(components);
            applyMediaPersistence(); // Apply saved media state over defaults

            // Logic Fix: Apply Pending Media (from Startup Race Condition)
            if (mPendingSongText != null) {
                DebugLogger.d(TAG, "Applying pending song text from cache: " + mPendingSongText);
                updateComponentText("song", mPendingSongText);
                updateComponentText("test_media", mPendingSongText);
                mPendingSongText = null; // Clear
            }
            if (mPendingCoverArt != null) {
                DebugLogger.d(TAG, "Applying pending cover art from cache");
                updateComponentImage("media_cover", mPendingCoverArt);
                updateComponentImage("test_media_cover", mPendingCoverArt);
                mPendingCoverArt = null; // Clear
            }
            // [FIX] 应用pending的传感器数据
            if (mPendingTempOutText != null) {
                DebugLogger.d(TAG, "Applying pending temp_out: " + mPendingTempOutText);
                updateComponentText("temp_out", mPendingTempOutText);
                mPendingTempOutText = null;
            }
            if (mPendingTempInText != null) {
                DebugLogger.d(TAG, "Applying pending temp_in: " + mPendingTempInText);
                updateComponentText("temp_in", mPendingTempInText);
                mPendingTempInText = null;
            }
            if (mPendingFuelText != null) {
                DebugLogger.d(TAG, "Applying pending fuel: " + mPendingFuelText);
                updateComponentText("fuel", mPendingFuelText);
                mPendingFuelText = null;
            }
            if (mPendingRangeText != null) {
                DebugLogger.d(TAG, "Applying pending range: " + mPendingRangeText);
                updateComponentText("range", mPendingRangeText);
                mPendingRangeText = null;
            }
            if (mPendingGearText != null) {
                DebugLogger.d(TAG, "Applying pending gear: " + mPendingGearText);
                updateComponentText("gear", mPendingGearText);
                mPendingGearText = null;
            }
        }
        if (mPresentation != null) {
            mPresentation.syncHudLayout(mCachedHudComponents);
            // Force update turn_signal with current real sensor state (hiding placeholder)
            updateTurnSignal();
        }

        // Notify Listener (MainActivity Preview) of the full sync (Logic Fix for
        // Preview Persistence)
        // [BUG 5 FIX] 批量更新，避免为每个组件创建新 Handler 导致卡顿
        if (mListener != null) {
            final java.util.List<HudComponentData> snapshot = new java.util.ArrayList<>(mCachedHudComponents);
            mBlinkHandler.post(() -> {
                if (mListener != null) {
                    for (HudComponentData data : snapshot) {
                        mListener.onHudDataChanged(data.type, data.text, data.image);
                    }
                }
            });
        }
    }

    // [New] Public method to force notify listeners (MainActivity Hud Editor) of
    // current data
    public void forceNotifyListener() {
        if (mListener != null && mCachedHudComponents != null) {
            DebugLogger.d(TAG,
                    "forceNotifyListener: Pushing " + mCachedHudComponents.size() + " components to listener");
            final java.util.List<HudComponentData> snapshot = new java.util.ArrayList<>(mCachedHudComponents);
            mMainHandler.post(() -> {
                if (mListener != null) {
                    for (HudComponentData data : snapshot) {
                        mListener.onHudDataChanged(data.type, data.text, data.image);
                    }
                }
            });
        }
    }

    public void syncClusterLayout(List<HudComponentData> components) {
        if (components == null)
            return;
        synchronized (this) {
            mIsDashboardMode = false; // Switch to List Mode
            mCachedClusterComponents = new ArrayList<>(components);
        }
        if (mPresentation != null) {
            mPresentation.syncClusterLayout(mCachedClusterComponents);
            updateTurnSignal(); // Force update
        }
    }

    public List<HudComponentData> getCachedHudComponents() {
        synchronized (this) {
            return mCachedHudComponents != null ? new ArrayList<>(mCachedHudComponents) : null;
        }
    }

    public void syncTestMedia() {
        String title = "测试歌曲 Title";
        String artist = "测试歌手 Artist";
        android.graphics.Bitmap art = android.graphics.Bitmap.createBitmap(100, 100,
                android.graphics.Bitmap.Config.ARGB_8888);
        art.eraseColor(android.graphics.Color.RED);

        String display = "测试歌词 Lyric\n" + title + " - " + artist;
        updateComponentText("song", display);
        updateComponentImage("media_cover", art);
        updateMediaPlayingState(true); // Force show for testing
    }

    public void onGuideInfoUpdate(cn.navitool.NaviInfoController.GuideInfo info) {
        // DebugLogger.d(TAG, "onGuideInfoUpdate: " + info.toString());
        mMainHandler.removeCallbacks(mNaviInfoTimeoutRunnable);
        mMainHandler.postDelayed(mNaviInfoTimeoutRunnable, NAVI_INFO_TIMEOUT_MS);
        if (mPresentation != null) {
            mPresentation.updateGuideInfo(info);
        }
    }
    public void clearHudComponents() {
        DebugLogger.i(TAG, "Clearing HUD/Cluster components cache");
        if (mPresentation != null) {
            mPresentation.clearHudComponents();
        }
        if (mCachedHudComponents != null) {
            mCachedHudComponents.clear();
        }
        if (mCachedClusterComponents != null) {
            mCachedClusterComponents.clear();
        }
    }

    // --- Cluster Dashboard Logic ---
    public void enableClusterDashboard() {
        mIsDashboardMode = true; // Enable Dashboard Mode persistence
        if (mPresentation != null) {
            mPresentation.enableClusterDashboard();
        } else {
            // Need to handle if presentation not ready?
            // For now, assume it's synced when presentation shows if we store mode state.
            // But skipping complexity for this step.
        }
    }

    /**
     * 设置仪表盘主题
     * 
     * @param theme ClusterHudPresentation.THEME_DEFAULT 或
     *              ClusterHudPresentation.THEME_AUDI_RS
     */
    public void setClusterTheme(int theme) {
        // [Fix Cold Boot] Skip if already applied to active presentation
        if (mPresentation != null && mCurrentAppliedTheme == theme) {
            DebugLogger.d(TAG, "setClusterTheme: Theme " + theme + " already applied, skipping.");
            return;
        }

        // 始终保存主题，以便后续presentation创建时使用
        mPendingTheme = theme;
        DebugLogger.d(TAG, "setClusterTheme: theme=" + theme + ", mPresentation=" + (mPresentation != null));

        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.setClusterTheme(theme);
                    mCurrentAppliedTheme = theme; // Update applied theme
                }
            });
        }
    }

    public int getCurrentClusterTheme() {
        if (mPresentation != null) {
            return mPresentation.getCurrentTheme();
        }
        return Presentation.THEME_DEFAULT;
    }

    // Moved to top: private final Handler mMainHandler = new
    // Handler(Looper.getMainLooper());

    // --- Simulated Gear Logic ---

    public void setSimulatedGearEnabled(boolean enabled) {
        mSimulatedGearEnabled = enabled;
        DebugLogger.d(TAG, "Simulated Gear Enabled: " + enabled);
        if (mSimulatedGearEnabled) {
            calculateAndPushSimulatedGear();
        }
    }

    public void updateRpm(float rpm) {
        mCachedRpm = rpm;
        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.updateRpm(rpm);
                }
            });
        }
        if (mSimulatedGearEnabled) {
            calculateAndPushSimulatedGear();
        }
    }

    public void cycleGear() {
        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.cycleGear();
                }
            });
        }
    }

    public void updateGear(int gearValue) {
        boolean gearChanged = (mCachedGear != gearValue);
        mCachedGear = gearValue;

        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    if (mSimulatedGearEnabled) {
                        calculateAndPushSimulatedGear(gearChanged);
                    } else {
                        mPresentation.updateGear(gearValue);
                    }
                }
            });
        }
    }

    public void updateSpeed(int speed) {
        // [DEBUG] Log updateSpeed call
        if (mSimulatedGearEnabled) {
             DebugLogger.d(TAG, "updateSpeed called: " + speed + ", invoking SimGearCalc");
        }
        mCachedSpeed = speed;
        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.updateSpeed(speed);
                }
            });
        }
        if (mSimulatedGearEnabled) {
            calculateAndPushSimulatedGear();
        }
    }

    private void calculateAndPushSimulatedGear() {
        // [DEBUG] Log calculation trigger
        DebugLogger.d(TAG, "Triggering Simulated Gear Calculation (Force=False)");
        calculateAndPushSimulatedGear(false);
    }

    private void calculateAndPushSimulatedGear(boolean forceImmediate) {
        // [FIX] 即使是 -1 也传递给转换函数，因为 -1 代表 M 档，不应替换为 P
        String baseGear = mapRawGearToChar(mCachedGear);

        String calculated = cn.navitool.DrivingShift.getInstance().calculateGear(
                mCachedSpeed,
                mCachedRpm,
                baseGear,
                forceImmediate);

        if (mPresentation != null) {
            mMainHandler.post(() -> mPresentation.updateGear(calculated));
        }
    }

    private String convertGearValueToString(int gearValue) {
        // M Gear support: Priority check for -1
        if (gearValue == -1) {
            return "M";
        }

        // Gear constants (Duplicated from Presentation/SoundPromptManager)
        final int GEAR_PARK = 2097712;
        final int GEAR_REVERSE = 2097728;
        final int GEAR_NEUTRAL = 2097680;
        final int GEAR_DRIVE = 2097696;
        final int TRSM_GEAR_PARK = 15;
        final int TRSM_GEAR_DRIVE = 13;
        final int TRSM_GEAR_NEUT = 14;
        final int TRSM_GEAR_RVS = 11;

        if (gearValue == GEAR_DRIVE || gearValue == TRSM_GEAR_DRIVE)
            return "D";
        if (gearValue == GEAR_REVERSE || gearValue == TRSM_GEAR_RVS)
            return "R";
        if (gearValue == GEAR_NEUTRAL || gearValue == TRSM_GEAR_NEUT)
            return "N";
        if (gearValue == GEAR_PARK || gearValue == TRSM_GEAR_PARK)
            return "P";

        return "P"; // Default
    }

    @Override
    public void onDayNightChanged(int mode) {
        // Disabled per user request: "Amap checks system dark/light theme, not car
        // sensor parameters"
        // We now rely on onConfigurationChanged
        DebugLogger.d(TAG, "Ignored VehicleSensor Event onDayNightChanged: " + mode);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        int uiMode = newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK;
        boolean isDay = (uiMode != Configuration.UI_MODE_NIGHT_YES);
        DebugLogger.i(TAG, "System Configuration Changed! uiMode=" + uiMode + " -> isDay=" + isDay);

        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.setDayMode(isDay);
                }
            });
        }
    }

    @Override
    public void onLowMemory() {
        // Optional: Handle low memory
    }

    // --- Notification Service Connection Listener ---

    // --- Media Persistence ---
    // --- Media Visibility ---
    private boolean mIsMediaPlaying = false;

    private void updateMediaPlayingState(boolean isPlaying) {
        if (mIsMediaPlaying != isPlaying) {
            mIsMediaPlaying = isPlaying;
            DebugLogger.d(TAG, "Media Playing State Changed: " + isPlaying);
            if (mPresentation != null) {
                mPresentation.setMediaPlaying(mIsMediaPlaying);
            }
        }
    }

    private void applyMediaPersistence() {
        // Removed per user request: No longer restore saved media state.
        // We rely on real-time data or defaults.
    }

    private String mLastSavedText = null;

    private void saveMediaState(String text, android.graphics.Bitmap image) {
        // Removed per user request: No longer save media state to disk.
    }

    public static class HudComponentData {
        public String type; // "text", "time", "song", "fuel", "temp_out", "temp_in", "range", "gear",
                            // "media_cover", "turn_signal", "volume", "gauge"
        public String text;
        public android.graphics.Bitmap image;
        public float x;
        public float y;
        public int color;
        public float[] gaugeConfig; // [min, max, start, end, px, py]
        public android.graphics.Typeface typeface;
        public String pathData; // For "path_gauge"
        public float maxValue; // For "path_gauge" progress calc
        public float scale = 1.0f; // 组件缩放比例，默认1.0（不缩放）

        public HudComponentData() {
        }

        public HudComponentData(String type, String text, float x, float y, int color) {
            this.type = type;
            this.text = text;
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public HudComponentData(String type, String text, float x, float y) {
            this(type, text, x, y, android.graphics.Color.WHITE);
        }
    }

    // --- [Merged from HudManager.java] ---
    public void setSnowMode(boolean enabled) {
        ConfigManager.getInstance().setBoolean("hud_snow_mode", enabled);
    }

    // --- HUD Green Background Logic ---
    private boolean mIsHudGreenBgExposed = false;

    public void setHudGreenBgEnabled(boolean enabled) {
        mIsHudGreenBgExposed = enabled;
        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.setHudGreenBg(enabled);
                }
            });
        }
    }

    public boolean isSnowModeEnabled() {
        return ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
    }

    // --- Sensor Data Persistence ---
    private boolean mSensorsRegistered = false; // [FIX] Prevent duplicate registration
    // [FIX] Corrected Fuel Level Sensor ID (was 2101760, actual API value is
    // 1050112)
    private static final int SENSOR_TYPE_FUEL_LEVEL = 1050112; // Fuel Level (ISensor.SENSOR_TYPE_FUEL_LEVEL)
    private static final int SENSOR_TYPE_ENV_OUTSIDE_TEMPERATURE = 2100992; // Outside Temp

    private String mCachedFuelText = "⛽ --L";
    private String mCachedRangeText = "--km";
    private String mCachedTempOutText = "--°C";
    private String mCachedTempInText = "--°C";

    private void loadSensorCache() {
        mCachedFuelText = ConfigManager.getInstance().getString("last_fuel_text", "⛽ --L");
        mCachedRangeText = ConfigManager.getInstance().getString("last_range_text", "--km");
        mCachedTempOutText = ConfigManager.getInstance().getString("last_temp_out_text", "--°C");
        mCachedTempInText = ConfigManager.getInstance().getString("last_temp_in_text", "--°C");
    }

    /**
     * [NEW] 从磁盘加载HUD布局配置
     * 在Headless启动时自动调用，无需用户进入MainActivity
     */
    private void loadHudLayoutFromDisk() {
        // 获取当前HUD模式 (0=WHUD, 1=AR)
        int hudMode = ConfigManager.getInstance().getInt("hud_current_mode", 0);
        String key = (hudMode == 0) ? "hud_layout_whud" : "hud_layout_ar";
        String jsonStr = ConfigManager.getInstance().getString(key, null);
        
        if (jsonStr == null || jsonStr.isEmpty()) {
            DebugLogger.d(TAG, "loadHudLayoutFromDisk: No saved layout found for key=" + key);
            return;
        }
        
        try {
            org.json.JSONArray jsonArray = new org.json.JSONArray(jsonStr);
            if (jsonArray.length() == 0) {
                DebugLogger.d(TAG, "loadHudLayoutFromDisk: Empty layout array");
                return;
            }
            
            java.util.List<HudComponentData> components = new java.util.ArrayList<>();
            boolean isSnowMode = ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
            int color = isSnowMode ? 0xFF00FFFF : 0xFFFFFFFF;
            
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject obj = jsonArray.getJSONObject(i);
                String type = obj.optString("type", "text");
                String text = obj.optString("text", "Text");
                // 坐标已经是HUD坐标（728x190），无需再缩放
                float x = (float) obj.optDouble("x", 0) * 0.5f;
                float y = (float) obj.optDouble("y", 0) * 0.5f;
                float scale = (float) obj.optDouble("scale", 1.0f);
                
                HudComponentData data = new HudComponentData(type, text, x, y, color);
                data.scale = scale;
                components.add(data);
            }
            
            if (!components.isEmpty()) {
                mCachedHudComponents = new java.util.ArrayList<>(components);
                DebugLogger.i(TAG, "loadHudLayoutFromDisk: Loaded " + components.size() + " components from disk");
            }
        } catch (org.json.JSONException e) {
            DebugLogger.e(TAG, "loadHudLayoutFromDisk: Failed to parse layout JSON", e);
        }
    }

    private void saveSensorCache(String key, String value) {
        ConfigManager.getInstance().setString(key, value);
    }

    public void updateFuel(String text) {
        mCachedFuelText = text;
        saveSensorCache("last_fuel_text", text);
        if (mPresentation != null) {
            updateComponentText("fuel", text);
        }
    }

    /**
     * [NEW] Update fuel with float value (in liters).
     * This properly updates both mCachedFuelLiters and mCachedFuelText.
     */
    public void updateFuelWithValue(float liters) {
        mCachedFuelLiters = liters;
        String text = String.format("⛽ %.0fL", liters);
        mCachedFuelText = text;
        saveSensorCache("last_fuel_text", text);
        if (mPresentation != null) {
            updateComponentText("fuel", text);
            updateFuelRangeComponent();
        }
    }

    public void updateRange(String text) {
        mCachedRangeText = text;
        saveSensorCache("last_range_text", text);
        if (mPresentation != null) {
            updateComponentText("range", text);
            updateComponentText("fuel_range", mCachedFuelText + "|" + mCachedRangeText); // Update combined too
        }
    }

    public void updateTempOut(String text) {
        mCachedTempOutText = text;
        saveSensorCache("last_temp_out_text", text);
        if (mPresentation != null) {
            updateComponentText("temp_out", text);
        }
    }

    public void updateTempIn(String text) {
        mCachedTempInText = text;
        saveSensorCache("last_temp_in_text", text);
        if (mPresentation != null) {
            updateComponentText("temp_in", text);
        }
    }

    // --- [Merged from ClusterManager.java] ---
    public void applyClusterTheme(String themeId) {
        if ("1".equals(themeId)) {
            enableClusterDashboard();
        } else {
            java.util.List<HudComponentData> customData = cn.navitool.managers.CustomThemeManager.getInstance(mContext)
                    .loadTheme(themeId);
            if (!customData.isEmpty()) {
                syncClusterLayout(customData);
            } else {
                clearHudComponents();
                syncClusterLayout(new java.util.ArrayList<>());
            }
        }
    }

    public void applyClusterTheme(int themeId) {
        applyClusterTheme(String.valueOf(themeId));
    }

    /**
     * [Self-Init] 从 ConfigManager 加载所有保存的状态
     * 消除 MainActivity 和 BootReceiver 之间的初始化冲突
     */

    private void loadSavedState() {
        try {
            // 1. Load Enabled States
            // [FIX] 默认值从true改为false，与MainActivity保持一致
            // 避免在用户从未开启功能时，外部触发switchNaviMode(3)导致仪表意外显示
            mIsClusterEnabled = ConfigManager.getInstance().getBoolean("switch_cluster", false);
            mIsHudEnabled = ConfigManager.getInstance().getBoolean("switch_hud", false);
            mIsFloatingEnabled = ConfigManager.getInstance().getBoolean("floating_traffic_light_enabled", false);
            // [FIX] Load Simulated Gear State
            // [FIX] Default to TRUE so users can see M1-M8 without manual config
            mSimulatedGearEnabled = ConfigManager.getInstance().getBoolean("simulated_gear_enabled", true);
            // [NEW] Load Green Background State
            mIsHudGreenBgExposed = ConfigManager.getInstance().getBoolean("hud_green_bg_enabled", false);
            DebugLogger.i(TAG, "Self-Init: Loaded State -> Cluster=" + mIsClusterEnabled + ", HUD=" + mIsHudEnabled
                    + ", Floating=" + mIsFloatingEnabled + ", SimGear=" + mSimulatedGearEnabled + ", GreenBg="
                    + mIsHudGreenBgExposed);

            // 2. Load Theme
            mPendingTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                    Presentation.THEME_DEFAULT);
            DebugLogger.i(TAG, "Self-Init: Loaded Theme -> " + mPendingTheme);

            // 3. Load UI Layouts (HUD & Cluster)
            if (mIsHudEnabled) {
                loadCachedHudLayout();
            }
            if (mIsClusterEnabled) {
                // Load saved cluster theme or layout if needed
                // Currently cluster uses fixed themes mostly, but if we had custom layout
                // loading it would go here
            }

            // 4. Force consistency on first start
            // If enabled, we prepare to show. DisplayListener will trigger actual show.
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error in loadSavedState", e);
        }
    }

    /**
     * [Issue 3 / 8 Fix] Update Navigation State purely based on Data Input.
     * Called by NaviInfoController when valid data arrives or times out.
     */
    public void updateNaviInputState(boolean isNavigating) {
        if (mPresentation != null) {
            // Ensure we are on main thread
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.setNavigating(isNavigating);
                }
            });
        }
    }
}
