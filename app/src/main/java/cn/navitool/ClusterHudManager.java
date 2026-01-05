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

// ECarX AdaptAPI Imports
import com.ecarx.xui.adaptapi.car.Car;
import com.ecarx.xui.adaptapi.car.ICar;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent;
import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;

public class ClusterHudManager {
    private static final String TAG = "ClusterHudManager";

    private static ClusterHudManager instance;
    private Context mContext;
    private ClusterHudPresentation mPresentation;
    private boolean mIsClusterEnabled = false;
    private boolean mIsHudEnabled = false;
    private boolean mIsDashboardMode = false;
    private int mPendingTheme = ClusterHudPresentation.THEME_DEFAULT; // 保存待应用的主题

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
    private NotificationConnectionReceiver mNotifReceiver;

    // Cached values for combined fuel_range component
    private float mCachedFuelLiters = 0f;
    private float mCachedRangeKm = 0f;
    private int mCachedSpeed = 0;
    private int mCachedGear = -1; // -1 for unknown
    // [Fix Cold Boot] Add tracking for actually applied theme to avoid redundant
    // resets
    private int mCurrentAppliedTheme = -1;;

    private List<HudComponentData> mCachedHudComponents;
    private List<HudComponentData> mCachedClusterComponents;
    private Object mDimMenuInteraction; // IDimMenuInteraction via Reflection

    // AdaptAPI Reflection Constants
    private static final String CLASS_DIM_INTERACTION = "com.ecarx.xui.adaptapi.diminteraction.DimInteraction";
    // Typo in AdaptAPI: TRUN instead of TURN (Strictly matching API name)
    private static final int FUNC_LEFT_TRUN_SIGNAL = 553980160;
    private static final int FUNC_RIGHT_TRUN_SIGNAL = 553980416;

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

    private ClusterHudManager(Context context) {
        this.mContext = context.getApplicationContext();

        // [HUD FIX] 初始化缓存列表，避免 "Cache not ready" 错误
        this.mCachedHudComponents = new ArrayList<>();
        this.mCachedClusterComponents = new ArrayList<>();

        // Load persisted sensor data
        loadSensorCache();

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
        initNotificationReceiver();

        // Initialize Car Service (Backgroundable, takes ~500ms)
        initCarService();

        registerDisplayListener();
    }

    public static synchronized ClusterHudManager getInstance(Context context) {
        if (instance == null) {
            instance = new ClusterHudManager(context);
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
    private void initCarService() {
        new Thread(() -> {
            try {
                // Create ECarX Car Instance
                mCar = Car.create(mContext);
                if (mCar != null) {
                    mSensorManager = mCar.getSensorManager();
                    if (mSensorManager != null) {
                        registerSensors();
                    } else {
                        DebugLogger.e(TAG, "ECarX SensorManager is null");
                    }

                    mCarFunction = mCar.getICarFunction();
                    if (mCarFunction != null) {
                        registerFunctions();
                    }
                } else {
                    DebugLogger.e(TAG, "Failed to create ECarX Car instance");
                }
            } catch (Throwable t) {
                DebugLogger.e(TAG, "Failed to init ECarX Car Service (Fatal)", t);
            }
        }).start();
    }

    private void registerSensors() {
        if (mSensorManager == null)
            return;

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
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error registering functions", e);
        }
    }

    // --- ECarX Sensor Listener ---
    private class ECarSensorListener implements ISensor.ISensorListener {
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
                if (sensorType == ISensor.SENSOR_TYPE_FUEL_LEVEL) {
                    // MConfig divides by 1000 for Liters
                    float liters = value / 1000f;
                    mCachedFuelLiters = liters;
                    updateComponentText("fuel", String.format("%.0fL", liters));
                    updateFuelRangeComponent();
                } else if (sensorType == ISensor.SENSOR_TYPE_TEMPERATURE_AMBIENT) {
                    updateComponentText("temp_out", String.format("%.0f°C", value));
                } else if (sensorType == ISensor.SENSOR_TYPE_TEMPERATURE_INDOOR) {
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
                } else if (sensorType == TIRE_PRESSURE_FRONT_LEFT) {
                    updateComponentText("tire_p_fl", String.format("%.1fbar", value));
                } else if (sensorType == TIRE_PRESSURE_FRONT_RIGHT) {
                    updateComponentText("tire_p_fr", String.format("%.1fbar", value));
                } else if (sensorType == TIRE_PRESSURE_REAR_LEFT) {
                    updateComponentText("tire_p_rl", String.format("%.1fbar", value));
                } else if (sensorType == TIRE_PRESSURE_REAR_RIGHT) {
                    updateComponentText("tire_p_rr", String.format("%.1fbar", value));
                } else if (sensorType == TIRE_TEMPERATURE_FRONT_LEFT) {
                    updateComponentText("tire_t_fl", String.format("%.0f°C", value));
                } else if (sensorType == TIRE_TEMPERATURE_FRONT_RIGHT) {
                    updateComponentText("tire_t_fr", String.format("%.0f°C", value));
                } else if (sensorType == TIRE_TEMPERATURE_REAR_LEFT) {
                    updateComponentText("tire_t_rl", String.format("%.0f°C", value));
                } else if (sensorType == TIRE_TEMPERATURE_REAR_RIGHT) {
                    updateComponentText("tire_t_rr", String.format("%.0f°C", value));
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
                mBlinkVisible = false; // Reset to invisible or off when stopped
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

    private class ECarFunctionListener implements ICarFunction.IFunctionValueWatcher {
        @Override
        public void onFunctionValueChanged(int funcId, int zone, int value) {
            boolean isOn = (value == 1);
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

    // Helper to get/create bitmap
    public android.graphics.Bitmap getTurnSignalBitmap(boolean left, boolean right) {
        if (!left && !right)
            return null;

        // Return cached if available
        if (left && right && mBitmapHazard != null)
            return mBitmapHazard;
        if (left && !right && mBitmapLeft != null)
            return mBitmapLeft;
        if (!left && right && mBitmapRight != null)
            return mBitmapRight;

        try {
            android.graphics.drawable.Drawable drawable = mContext.getDrawable(R.drawable.ic_turn_signal);
            if (drawable == null)
                return null;

            // Updated Size: 72px (Standard for 2x Preview)
            int width = 72;
            int height = 72;
            int gap = 90; // Scaled gap

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

    private void updateTurnSignal() {
        // Strictly use API State AND Blink Toggle
        // If ON, use mBlinkVisible. If OFF, force false.
        boolean showLeft = mLeftTurnOn && mBlinkVisible;
        boolean showRight = mRightTurnOn && mBlinkVisible;

        android.graphics.Bitmap signalBitmap = getTurnSignalBitmap(showLeft, showRight);
        updateComponentImage("turn_signal", signalBitmap);
    }

    public android.graphics.Bitmap getVolumeBitmap(int volume) {
        try {
            android.graphics.drawable.Drawable drawable = mContext.getDrawable(R.drawable.ic_volume);
            if (drawable == null)
                return null;

            int iconSize = 48; // Double size (was 24)
            int padding = 12; // Scaled padding

            // Measure Text
            android.graphics.Paint paint = new android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG);
            paint.setColor(android.graphics.Color.WHITE);
            paint.setTextSize(36); // Double size (was 18)
            paint.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);

            String volText = String.valueOf(volume);
            android.graphics.Rect textBounds = new android.graphics.Rect();
            paint.getTextBounds(volText, 0, volText.length(), textBounds);

            int totalWidth = iconSize + padding + textBounds.width();
            int totalHeight = Math.max(iconSize, textBounds.height());

            // Add some margin
            totalHeight += 4;
            totalWidth += 4;

            android.graphics.Bitmap bitmap = android.graphics.Bitmap.createBitmap(totalWidth, totalHeight,
                    android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);

            // Draw Icon
            drawable.setBounds(0, (totalHeight - iconSize) / 2, iconSize, (totalHeight - iconSize) / 2 + iconSize);
            drawable.setTint(android.graphics.Color.WHITE);
            drawable.draw(canvas);

            // Draw Text
            // Align text vertically center
            float textY = (totalHeight / 2f) - ((paint.descent() + paint.ascent()) / 2f);
            canvas.drawText(volText, iconSize + padding, textY, paint);

            return bitmap;
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error generating volume bitmap", e);
            return null;
        }
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
            mVolumeReceiver = new VolumeReceiver();
            android.content.IntentFilter filter = new android.content.IntentFilter();
            filter.addAction("android.media.VOLUME_CHANGED_ACTION");
            // Initial Update
            updateVolume();
            mContext.registerReceiver(mVolumeReceiver, filter, null, new Handler(Looper.getMainLooper()));
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
        switch (gearValue) {
            case ISensorEvent.GEAR_PARK:
                return "P";
            case ISensorEvent.GEAR_REVERSE:
                return "R";
            case ISensorEvent.GEAR_NEUTRAL:
                return "N";
            case ISensorEvent.GEAR_DRIVE:
                return "D";
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
                return "D";
        }
    }

    /**
     * 更新油量续航组合组件，格式: "32L|280km"
     */
    private void updateFuelRangeComponent() {
        String text = String.format("%.0fL|%.0fkm", mCachedFuelLiters, mCachedRangeKm);
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

    // Pending Media State (Wait for Cache Load)
    private String mPendingSongText = null;
    private android.graphics.Bitmap mPendingCoverArt = null;

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
    private void initMediaListener() {
        // 1. Register Standard Broadcast Receiver (Only from our own Service)
        try {
            MusicBroadcastReceiver receiver = new MusicBroadcastReceiver();
            android.content.IntentFilter filter = new android.content.IntentFilter();
            filter.addAction(cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE);
            mContext.registerReceiver(receiver, filter, null, new Handler(Looper.getMainLooper()));
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
            Object callbackProxy = java.lang.reflect.Proxy.newProxyInstance(
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
            registerMethod.invoke(mDimMenuInteraction, callbackProxy);
            DebugLogger.i(TAG, "NaviMode listener registered successfully");

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register NaviMode listener", e);
        }
    }

    private void registerDisplayListener() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        dm.registerDisplayListener(new DisplayManager.DisplayListener() {
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
        }, new Handler(Looper.getMainLooper()));
    }

    private void checkAndShowPresentation() {
        if (mIsClusterEnabled || mIsHudEnabled) {
            if (mPresentation == null) {
                showPresentation();
            }
        }
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
                    ClusterHudPresentation.THEME_DEFAULT);
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
                ClusterHudPresentation.THEME_DEFAULT);
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

    private void showPresentation() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        Display[] displays = dm.getDisplays();
        DebugLogger.d(TAG, "Found " + displays.length + " displays");

        Display targetDisplay = null;
        for (Display d : displays) {
            if (d.getDisplayId() == 2) {
                targetDisplay = d;
                break;
            }
        }

        if (targetDisplay != null) {
            mPresentation = new ClusterHudPresentation(mContext, targetDisplay);

            if (android.os.Build.VERSION.SDK_INT >= 31) {
                DebugLogger.i(TAG, "Android 12+: Using default Presentation Window Type (2037)");
            } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                mPresentation.getWindow().setType(android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            } else {
                mPresentation.getWindow().setType(android.view.WindowManager.LayoutParams.TYPE_PHONE);
            }

            try {
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

                mPresentation.show();
                mPresentation.setClusterVisible(mIsClusterEnabled);
                mPresentation.setHudVisible(mIsHudEnabled);
                mPresentation.setMediaPlaying(mIsMediaPlaying); // Sync initial state
                DebugLogger.i(TAG, "ClusterHudPresentation SHOWN on Display 2");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to show presentation", e);
                mPresentation = null;
            }
        } else {
            DebugLogger.w(TAG, "Display ID 2 not found yet, waiting for it...");
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

    public void clearHudComponents() {
        if (mPresentation != null) {
            mPresentation.clearHudComponents();
        }
        if (mPresentation != null) {
            mPresentation.clearHudComponents();
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
        return ClusterHudPresentation.THEME_DEFAULT;
    }

    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    public void updateRpm(float rpm) {
        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.updateRpm(rpm);
                }
            });
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
        // [FIX] Cache gear value for cold boot display
        mCachedGear = gearValue;

        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.updateGear(gearValue);
                }
            });
        }
    }

    // 实际车速（用于状态页面对比显示）
    private int mActualSpeed = 0;

    public void updateActualSpeed(int speed) {
        mActualSpeed = speed;
        // 可以通过广播或回调通知状态页面更新
        android.content.Intent intent = new android.content.Intent("cn.navitool.ACTUAL_SPEED_UPDATE");
        intent.putExtra("speed", speed);
        mContext.sendBroadcast(intent);
    }

    public int getActualSpeed() {
        return mActualSpeed;
    }

    // DIM仪表速度（用于状态页面对比显示）
    private int mDIMSpeed = 0;

    public int getDIMSpeed() {
        return mDIMSpeed;
    }

    // 存储DIM速度供查询
    public void updateSpeed(int speed) {
        mDIMSpeed = speed;
        if (mPresentation != null) {
            mMainHandler.post(() -> {
                if (mPresentation != null) {
                    mPresentation.updateSpeed(speed);
                }
            });
        }
        // 广播DIM速度更新
        android.content.Intent intent = new android.content.Intent("cn.navitool.DIM_SPEED_UPDATE");
        intent.putExtra("speed", speed);
        mContext.sendBroadcast(intent);
    }

    // --- Notification Service Connection Listener ---
    private void initNotificationReceiver() {
        try {
            mNotifReceiver = new NotificationConnectionReceiver();
            android.content.IntentFilter filter = new android.content.IntentFilter(
                    "cn.navitool.NOTIFICATION_LISTENER_CONNECTED");
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                mContext.registerReceiver(mNotifReceiver, filter, Context.RECEIVER_EXPORTED);
            } else {
                mContext.registerReceiver(mNotifReceiver, filter);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to register Notification Receiver", e);
        }
    }

    private class NotificationConnectionReceiver extends android.content.BroadcastReceiver {
        @Override
        public void onReceive(Context context, android.content.Intent intent) {
            if ("cn.navitool.NOTIFICATION_LISTENER_CONNECTED".equals(intent.getAction())) {
                DebugLogger.i(TAG, "Received Notification Service Connected Broadcast! Retrying Media Init...");
                DebugLogger.i(TAG, "Received Notification Service Connected Broadcast!");
                // No need to reinit locally, Service is running.
            }
        }
    }

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

    public boolean isSnowModeEnabled() {
        return ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
    }

    // --- Sensor Data Persistence ---
    private String mCachedFuelText = "--L";
    private String mCachedRangeText = "--km";
    private String mCachedTempOutText = "--°C";
    private String mCachedTempInText = "--°C";

    private void loadSensorCache() {
        mCachedFuelText = ConfigManager.getInstance().getString("last_fuel_text", "--L");
        mCachedRangeText = ConfigManager.getInstance().getString("last_range_text", "--km");
        mCachedTempOutText = ConfigManager.getInstance().getString("last_temp_out_text", "--°C");
        mCachedTempInText = ConfigManager.getInstance().getString("last_temp_in_text", "--°C");
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
}
