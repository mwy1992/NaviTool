package cn.navitool.managers;

import android.content.Context;
import android.content.ComponentName;
import android.hardware.display.DisplayManager;
import cn.navitool.R;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;

import cn.navitool.managers.PresentationManager;
import cn.navitool.utils.DebugLogger;
import cn.navitool.utils.SimulateFunction;
import cn.navitool.utils.AdbShell;
import cn.navitool.utils.MemoryMonitor;
import cn.navitool.managers.SimulateGear;
import cn.navitool.activity.MainActivity;
import cn.navitool.managers.NaviInfoManager;
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
    private PresentationManager mPresentationManager;
    private boolean mIsClusterEnabled = false;
    private boolean mIsHudEnabled = false;
    private boolean mIsFloatingEnabled = false; // Floating Traffic Light State
    private boolean mIsDashboardMode = false;
    private int mPendingTheme = PresentationManager.THEME_DEFAULT; // 保存待应用的主题
    // [Fix Cold Boot] Retry counter for Display id 2 discovery
    private int mRetryCount = 0;

    // ECarX Car API
    // ECarX Car API fields removed - using VehicleSensorManager

    // Media & Volume
    private android.media.session.MediaSessionManager mMediaSessionManager;
    private android.media.AudioManager mAudioManager;
    private VolumeReceiver mVolumeReceiver;

    private float mCachedFuelLiters = 0f;
    private float mCachedRangeKm = 0f;
    private float mCachedSpeed = 0f;
    private float mCachedRpm = 0f;
    // [FIX] Add missing cache fields for Cluster Init
    private float mCachedOdometer = 0f;
    private float mCachedFuelIns = 0f;
    
    // [FIX] Music Cache for Consistency (Backfill)
    private String mCachedSongTitle = null;
    private String mCachedSongArtist = null;
    private android.graphics.Bitmap mCachedCoverArt = null;
    private boolean mCachedIsPlaying = false;

    // Bug 2 Fix: Independent timeout for navigation info
    // [FIX] Removed Timeout Logic to prevent hiding static data
    // private static final long NAVI_INFO_TIMEOUT_MS = 5000;
    // private final Runnable mNaviInfoTimeoutRunnable ... removed
    // [FIX] Initialize to -999 (No Data) instead of 0 (P) or -1 (M)
    // to prevent any default gear display before real data arrives.
    private int mCachedGear = -999; 

    // [Fix Cold Boot] Add tracking for actually applied theme to avoid redundant
    // resets
    private int mCurrentAppliedTheme = -1;

    // [NEW] 点火状态标志 - 仅在收到点火信号后才允许显示PresentationManager
    private boolean mIgnitionReady = false;

    // [Fix] Simulated Gear Support
    private boolean mSimulatedGearEnabled = false;
    // private float mCachedRpm = 0f; // Moved up

    // [OPTIMIZATION] Use LinkedHashMap for O(1) Lookup + Ordered Iteration (Z-Order)
    private java.util.LinkedHashMap<String, HudComponentData> mCachedHudComponents;
    private java.util.LinkedHashMap<String, HudComponentData> mCachedClusterComponents;
    private Object mDimMenuInteraction; // IDimMenuInteraction via Reflection
    private Integer mPendingNaviMode = null; // [FIX] Pending NaviMode for Race Condition
    
    // [FIX] NaviMode Deduplication and Throttle
    private int mLastAppliedNaviMode = -1; // Cache to prevent duplicate calls
    private long mLastNaviModeApplyTime = 0; // Throttle timestamp
    private static final long NAVI_MODE_THROTTLE_MS = 500; // 500ms throttle

    // AdaptAPI Reflection Constants
    private static final String CLASS_DIM_INTERACTION = "com.ecarx.xui.adaptapi.diminteraction.DimInteraction";
    // Typo in AdaptAPI: TRUN instead of TURN (Strictly matching API name)
    private static final int FUNC_LEFT_TRUN_SIGNAL = 553980160;
    private static final int FUNC_RIGHT_TRUN_SIGNAL = 553980416;
    private static final int FUNC_AUTOHOLD_STATUS = 33661;
    
    // [OPTIMIZATION] Shared Handler to reduce allocation
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    public Handler getSharedHandler() { return mMainHandler; }

    // [FIX] Traffic Light Timeout - Auto-clear traffic light UI only
    // Note: Navigation state is now managed solely by onNaviStatusUpdate(state==2)
    private static final long TRAFFIC_LIGHT_TIMEOUT_MS = 3000; // 3 seconds
    private final Runnable mTrafficLightTimeoutRunnable = new Runnable() {
        @Override
        public void run() {
            DebugLogger.d(TAG, "Traffic Light Timeout (3s) - Clearing traffic light UI only");
            if (mPresentationManager != null) {
                mPresentationManager.resetTrafficLights();
            }
        }
    };
    

    
    // [FIX] Navi Info Timeout - Logic moved/removed, clearing duplicates
    // private static final long NAVI_INFO_TIMEOUT_MS = 3000;
    // private final Runnable mNaviInfoTimeoutRunnable ... removed (redundant)

    // [New] Allow MainActivity to inject a "Better" Context (Activity Context)
    public void updateContext(Context context) {
        this.mContext = context;
        DebugLogger.i(TAG, "ClusterHudManager Context updated to: " + context.getClass().getName());
    }

    private ClusterHudManager(Context context) {
        // [FIX] Ensure Context is Application Context to avoid memory leaks,
        // BUT we might need Activity Context for Themes.
        // We will Wrap it later if needed.
        this.mContext = context.getApplicationContext();
        MemoryMonitor.logMemory("ClusterHudManager.Init-Start");

        // [HUD FIX] 初始化缓存列表，避免 "Cache not ready" 错误
        this.mCachedHudComponents = new java.util.LinkedHashMap<>();
        this.mCachedClusterComponents = new java.util.LinkedHashMap<>();

        // [Self-Init] Load all saved configurations immediately
        // [Self-Init] Load all saved configurations immediately
        loadSavedState();

        // Register Sensor Listener (including TPMS)
        VehicleSensorManager.getInstance(mContext).registerListener(this);

        // [Refactor] Load initial sensor data directly from Manager (No more disk cache)
        loadInitialSensorData();

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

        // [FIX] 移除自动显示逻辑 - 仅在点火启动后才显示PresentationManager
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
                    public void onTrafficLightUpdate(NaviInfoManager.TrafficLightInfo info) {
                        ClusterHudManager.this.onTrafficLightUpdate(info);
                    }

                    @Override
                    public void onGuideInfoUpdate(NaviInfoManager.GuideInfo info) {
                        ClusterHudManager.this.onGuideInfoUpdate(info);
                    }

                    @Override
                    public void onNaviStatusUpdate(int state) {
                        ClusterHudManager.this.onNaviStatusUpdate(state);
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
            // [OPTIMIZATION] Convert Map values to List
            return new ArrayList<>(mCachedClusterComponents.values());
        } else if ("hud".equals(type)) {
            return new ArrayList<>(mCachedHudComponents.values());
        }
        return null;
    }

    // --- ECarX Car Service Initialization ---
    private boolean mIsDayMode = true;

    public void updateDayNightMode(boolean isDay) {
        if (mIsDayMode != isDay) {
            mIsDayMode = isDay;
            DebugLogger.d(TAG, "updateDayNightMode: " + isDay);
            if (mPresentationManager != null) {
                mPresentationManager.updateDayNightMode(isDay);
            }
        }
    }

    // --- Traffic Light Listener (AIDL) --- [REMOVED]

    private void initCarService() {
        // Use shared CarServiceManager to ensure connection
        cn.navitool.managers.CarServiceManager.getInstance(mContext).registerListener(() -> {
             // Just ensure init is called, actual logic is in VehicleSensorManager
        });
        cn.navitool.managers.CarServiceManager.getInstance(mContext).init();
    }
    
    // [Refactor] registerSensors() removed - Logic moved to VehicleSensorManager
    
    // [Refactor] registerFunctions removed - Logic moved to VehicleSensorManager

    // --- Traffic Light Listener (AIDL) ---

    // [Refactor] ECarSensorListener class removed logic moved to switch case using VehicleSensorManager.Listener

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
    public void updateTurnSignal(boolean isLeft, boolean isOn) {
        // [FIX] Force Main Thread Execution to eliminate Race Condition with mBlinkRunnable
        mMainHandler.post(() -> {
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
                    // Immediate Update handled below
                }
                // If already running, state variable change will be picked up by next Runnable
                // tick or immediate update
                // Logic Fix: Immediate update to reflect Side Switch without waiting for tick
            } else {
                // If both are now OFF, stop blinking
                if (isNowOff) {
                    mBlinkHandler.removeCallbacks(mBlinkRunnable);
                    mBlinkVisible = false;
                }
            }
            
            // Immediate update for all cases
            // (Start, Stop, or Side Switch)
            // Use no-arg updateTurnSignal() which just calls PresentationManager
             updateTurnSignal(); 

            // [FIX] Forward Turn Signal State to PresentationManager (for Traffic Light filtering)
            if (mPresentationManager != null) {
                mPresentationManager.updateTurnSignal(isLeft, isOn);
            }
        });
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
        if (mPresentationManager != null) {
            mPresentationManager.setFloatingTrafficLightEnabled(shouldShow);
        }
    }

    public void toggleFloatingTrafficLightStyle() {
        if (mPresentationManager != null) {
            mPresentationManager.toggleFloatingTrafficLightStyle();
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

    // [Refactor] ECarFunctionListener removed - Logic moved to VSM callbacks

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
            for (HudComponentData data : mCachedHudComponents.values()) {
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
            // PresentationManager handles null by not setting image (invisible), which is desired.
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

            int iconSize = 22; // Reduced from 32 to 24
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

        dismissPresentationManager();

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
        VehicleSensorManager.getInstance(mContext).unregisterListener(this);
    }

    // --- Volume Listener ---
    private int mCurrentVolume = 0;
    private Handler mVolumeHandler = new Handler(Looper.getMainLooper());
    private Runnable mVolumeHideRunnable = () -> {
        if (mPresentationManager != null) {
            mPresentationManager.setVolumeVisible(false);
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
        if (mPresentationManager != null) {
            mPresentationManager.setVolumeVisible(true);
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

    // --- VehicleSensorManager Listener Logic ---

    // [Refactor] Using unified VehicleSensorManager instead of internal Listener
    @Override
    public void onSpeedChanged(float speedKmh) {
        // [FIX] Restore Float Precision (No Cast)
        updateSpeed(speedKmh);
    }

    @Override
    public void onRpmChanged(float rpm) {
        // [FIX] Ensure RPM update triggers simulated gear calculation
        updateRpm(rpm);
    }

    @Override
    public void onFuelChanged(float fuel, float percent) {
        updateFuelWithValue(fuel);
    }

    @Override
    public void onRangeChanged(float range) {
        mCachedRangeKm = range;
        updateFuelRangeComponent();
        updateComponentText("range", String.format(Locale.US, "%.0fKM", range));
    }

    @Override
    public void onTemperatureChanged(float indoor, float outdoor) {
        updateComponentText("temp_in", String.format(Locale.US, "%.1f°C", indoor));
        updateComponentText("temp_out", String.format(Locale.US, "%.1f°C", outdoor));
        
        // [NEW] Forward to Audi RS Theme
        if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.updateIndoorTemp(indoor);
                }
            });
        }
    }

    // [Refactor] Implement methods for new sensors
    @Override
    public void onTripDataChanged(float distanceKm, long durationSec, float avgFuel) {
         if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.updateTripInfo(distanceKm, durationSec);
                }
            });
        }
    }

    @Override
    public void onOdometerChanged(float odometer) {
         mCachedOdometer = odometer; // [FIX] Cache Odometer
         if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.updateOdometer(odometer);
                }
            });
        }
    }

    @Override
    public void onFuelConsumptionChanged(float instant, float average) {
         mCachedFuelIns = instant; // [FIX] Cache Instant Fuel
         if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.updateInstantFuel(instant);
                }
            });
        }
    }

    @Override
    public void onGearChanged(int gear) {
        updateGear(gear);
    }

    @Override
    public void onTireDataChanged(int index, float pressure, float temp) {
         if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.updateTirePressure(index, pressure);
                    mPresentationManager.updateTireTemp(index, temp);
                }
            });
        }
    }
    
    // [Refactor] New VehicleSensorManager overrides
    @Override
    public void onTurnSignalChanged(boolean isLeft, boolean isOn) {
        if (isLeft) {
            if (mLeftTurnOn != isOn) {
                DebugLogger.d(TAG, "TurnSignal (VSM): Left Changed -> " + isOn);
                updateTurnSignal(true, isOn);
            }
        } else {
            if (mRightTurnOn != isOn) {
                DebugLogger.d(TAG, "TurnSignal (VSM): Right Changed -> " + isOn);
                updateTurnSignal(false, isOn);
            }
        }
    }

    @Override
    public void onFunctionChanged(int functionId, int zone, int value) {
        boolean isOn = (value == 1);
        if (functionId == VehicleSensorManager.FUNC_AUTOHOLD_STATUS) {
            DebugLogger.d(TAG, "AutoHold (VSM): Changed -> " + value);
            mIsAutoHoldOn = isOn;
            android.graphics.Bitmap bitmap = getAutoHoldBitmap(mIsAutoHoldOn);
            updateComponentImage("auto_hold", bitmap);
        }
    }
    
    // [Refactor] Removed internal ECarSensorListener class and registerSensors method

    /**
     * [NEW] Public method to get current display gear string (including simulation logic)
     * Used by HUD Editor to initialize component with correct value.
     */
    public String getCurrentDisplayGear() {
        return getGearString(mCachedGear);
    }

    private String getGearString(int gearValue) {
        // [FIX] Stagnation and Deadlock Fix
        // Always try to calculate simulated gear if enabled, even if currently "P" or "N"
        // This allows recovery if the state was stuck.
        if (mSimulatedGearEnabled) {
            // [Fix Fluctuation] Prefer cached last simulated gear to avoid recalculation side-effects
            if (mLastSimulatedGear != null && !mLastSimulatedGear.isEmpty()) {
                 // Return the stable, smoothed result from the last real update
                 return mLastSimulatedGear;
            }

            // Pass current raw logic result as "CurrentSensorGear"
            String baseGear = SimulateGear.mapRawGearToChar(gearValue);
            
            // Force "D" as base if we are in raw "D" mode (13) to allow D1-D8 calculation
            // If raw is -1 (M), baseGear is "M", SimulateGear handles "M" -> "M1" etc.
            if (gearValue == ISensorEvent.GEAR_DRIVE || gearValue == 13) {
                baseGear = "D";
            }
            
            // Call calculation [FIX] Use Peek mode to avoid polluting smoothing history
            return SimulateGear.getInstance().calculateGearPeek(mCachedSpeed, mCachedRpm, baseGear);
        } else {
            return SimulateGear.mapRawGearToChar(gearValue);
        }
    }
    
    // ... (Existing updateFuelRangeComponent) ...
    private void updateFuelRangeComponent() {
        String text = String.format("⛽ %.0fL|%.0fKM", mCachedFuelLiters, mCachedRangeKm);
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
                for (HudComponentData data : mCachedHudComponents.values()) {
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
            // (Placeholder is handled by PresentationManager if image is null, so we pass a
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
                if ("song_2line".equals(type)) {
                    mPendingSongText = newText;
                    // 减少日志输出，只在首次存储时记录
                    if (mPendingSongText == null || !mPendingSongText.equals(newText)) {
                        DebugLogger.d(TAG, "Pending song text: " + newText);
                    }
                } else if ("song_cover".equals(type)) {
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

        HudComponentData data = null;
        boolean found = false;

        synchronized (this) {
            // [OPTIMIZATION] O(1) Lookup
            if (mCachedHudComponents != null) {
                HudComponentData hudData = mCachedHudComponents.get(type);
                if (hudData != null) {
                    if (newText != null) hudData.text = newText;
                    if (newImage != null) hudData.image = newImage;
                    found = true;
                }
            }

            if (mCachedClusterComponents != null) {
                HudComponentData clusterData = mCachedClusterComponents.get(type);
                if (clusterData != null) {
                    if (newText != null) clusterData.text = newText;
                    if (newImage != null) clusterData.image = newImage;
                    found = true;
                }
            }
        }

        if (found) {
            final String fText = newText;
            final android.graphics.Bitmap fImage = newImage;
             mMainHandler.post(() -> {
                // Efficient Update: directly update view property instead of full rebuild
                if (mPresentationManager != null) {
                    mPresentationManager.updateComponent(type, fText, fImage);
                } else {
                    // Fallback if presentation isn't ready
                }

                if (mListener != null) {
                    mListener.onHudDataChanged(type, fText, fImage);
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

                        if (isPlaying) {
                            String display = title;
                            if (artist != null && !artist.isEmpty()) {
                                display = title + "\n" + artist;
                            }
                            updateComponentText("song_2line", display);
                            updateComponentText("song_1line", title == null ? "" : title);

                            // [FIX] Update Cache
                            mCachedSongTitle = title;
                            mCachedSongArtist = artist;
                            
                            // Update Cover (Byte Array)
                            boolean hasArtwork = intent.getBooleanExtra("has_artwork", true); // Default true
                            if (!hasArtwork) {
                                updateComponentImage("song_cover", null);
                                mCachedCoverArt = null; // Clear Cache
                            } else {
                                byte[] artwork = intent.getByteArrayExtra("artwork");
                                if (artwork != null) {
                                    android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeByteArray(artwork, 0,
                                            artwork.length);
                                    if (bmp != null) {
                                        updateComponentImage("song_cover", bmp);
                                        mCachedCoverArt = bmp; // Update Cache
                                    }
                                }
                            }
                        } else {
                            // Paused: Clear UI
                            updateComponentText("song_2line", "");
                            updateComponentText("song_1line", "");
                            updateComponentImage("song_cover", null);
                            
                            // Clear Cache
                            mCachedSongTitle = null;
                            mCachedSongArtist = null;
                            mCachedCoverArt = null;
                        }

                        // Update Playing State (for other logic if needed)
                        updateMediaPlayingState(isPlaying);
                        mCachedIsPlaying = isPlaying;
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

        // [OPTIMIZATION] Retry sync after 2 seconds to catch Service/Player startup lag
        mMainHandler.postDelayed(() -> {
            try {
                android.content.Intent requestIntent = new android.content.Intent(
                        "cn.navitool.ACTION_REQUEST_MEDIA_REBROADCAST");
                requestIntent.setPackage(mContext.getPackageName());
                mContext.sendBroadcast(requestIntent);
                DebugLogger.i(TAG, "Sent Retry Media Sync Request (2s delay)");
            } catch (Exception e) {
                // Ignore
            }
        }, 2000);
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
                updateComponentText("song_2line", display);
                updateComponentText("song_1line", title == null ? "" : title);

                // Update Playing State
                updateMediaPlayingState(isPlaying);

                // Update Cover (Byte Array)
                boolean hasArtwork = intent.getBooleanExtra("has_artwork", true); // Default true
                if (!hasArtwork) {
                    updateComponentImage("song_cover", null);
                } else {
                    byte[] artwork = intent.getByteArrayExtra("artwork");
                    if (artwork != null) {
                        android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeByteArray(artwork, 0,
                                artwork.length);
                        if (bmp != null) {
                            updateComponentImage("song_cover", bmp);
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
            // Register Volume Listener
            initVolumeListener();
        });
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

                // [FIX] Apply pending NaviMode if exists (Race Condition Fix)
                if (mPendingNaviMode != null) {
                    DebugLogger.i(TAG, "[PENDING] Found pending NaviMode(" + mPendingNaviMode + "), applying now...");
                    applyNaviMode(mPendingNaviMode, "PENDING");
                    mPendingNaviMode = null;
                }

                // [FIX] Double Insurance: Force retry switchNaviMode(3) after 2 seconds
                // Now uses applyNaviMode which has deduplication logic.
                // We reset mLastAppliedNaviMode to force re-application in case the first call was ignored
                if (mIsClusterEnabled) {
                     mMainHandler.postDelayed(() -> {
                         new Thread(() -> {
                             try {
                                 if (mDimMenuInteraction != null) {
                                     // Cheat the deduplication check to force re-send
                                     mLastAppliedNaviMode = -1; 
                                     applyNaviMode(3, "DOUBLE-INS");
                                 }
                             } catch (Exception e) {
                                 DebugLogger.e(TAG, "Double Insurance Failed", e);
                             }
                         }).start();
                     }, 2000); // 2 Seconds Delay
                }

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
                                if (mPresentationManager != null) {
                                    mPresentationManager.setNavigating(false);
                                }

                                mMainHandler.postDelayed(() -> {
                                    DebugLogger.i(TAG, "Re-displaying cluster after navigation end...");
                                    // 重新调用 switchNaviMode(3) 并刷新显示
                                    applyNaviMode(3, "LISTENER");
                                    if (mPresentationManager != null) {
                                        mPresentationManager.setClusterVisible(true);
                                    }
                                }, 1000);
                            } else if (naviMode == 3) {
                                // [New] Update Theme Logic: Navi Started -> Active
                                // REVERTED/CHANGED (Issue 3):
                                // We NO LONGER setNavigating(true) just because system is in Navi Mode (3).
                                // Background switching is now strictly tied to DATA arrival (Traffic
                                // Light/Guide Info).
                                // mPresentationManager.setNavigating(true);
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
                checkAndShowPresentationManager();
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



    private void checkAndShowPresentationManager() {
        mMainHandler.post(() -> {
            // [FIX] 仅在收到点火信号后才显示
            if (!mIgnitionReady) {
                DebugLogger.d(TAG, "checkAndShowPresentationManager: Ignition not ready, skipping");
                return;
            }
            if (mIsClusterEnabled || mIsHudEnabled) {
                if (mPresentationManager == null) {
                    showPresentationManager();
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
        updatePresentationManager();

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

    public boolean isClusterEnabled() {
        return mIsClusterEnabled;
    }


    public void setHudEnabled(boolean enabled) {
        if (mIsHudEnabled == enabled)
            return;
        mIsHudEnabled = enabled;
        DebugLogger.action(TAG, "HUD状态变更: " + enabled);
        DebugLogger.d(TAG, "setHudEnabled: " + enabled);
        updatePresentationManager();
    }

    public void setDebugMode(boolean enabled) {
        if (mPresentationManager != null) {
            mPresentationManager.updateDebugMode(enabled);
        }
    }

    /**
     * 强制刷新 PresentationManager 显示，用于延迟激活场景
     * 绕过状态检查，直接调用 showPresentationManager
     */
    public void forceRefreshPresentationManager() {
        DebugLogger.i(TAG, "forceRefreshPresentationManager called");

        // Use new clear method to ensure clean state
        clearHudComponents();

        // 先关闭现有的 presentation
        if (mPresentationManager != null) {
            try {
                mPresentationManager.dismiss();
            } catch (Exception e) {
                DebugLogger.w(TAG, "Error dismissing presentation for refresh", e);
            }
            mPresentationManager = null;
        }

        // 重新创建并显示
        if (mIsClusterEnabled || mIsHudEnabled) {
            // 在创建 presentation 前，先加载保存的主题
            int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                    PresentationManager.THEME_DEFAULT);
            mPendingTheme = savedTheme;
            DebugLogger.i(TAG, "forceRefresh: Loaded saved theme: " + savedTheme);

            showPresentationManager();

            // 调用 switchNaviMode
            if (mIsClusterEnabled && mDimMenuInteraction != null) {
                applyNaviMode(3, "REFRESH");
            }
        }
    }

    /**
     * 强制激活并设置状态，用于延迟激活场景
     * 直接设置状态并创建 PresentationManager，绕过所有状态检查
     */
    /**
     * 仅显示 UI，不切换导航模式。
     * 用于冷启动时立即显示画面，避免等待。
     */
    public void showUiOnly(boolean clusterEnabled, boolean hudEnabled) {
        DebugLogger.i(TAG, "showUiOnly: cluster=" + clusterEnabled + ", hud=" + hudEnabled);

        // 关闭现有的 presentation
        if (mPresentationManager != null) {
            try {
                mPresentationManager.dismiss();
            } catch (Exception e) {
                DebugLogger.w(TAG, "Error dismissing presentation", e);
            }
            mPresentationManager = null;
        }

        // 直接设置内部状态（绕过状态检查）
        mIsClusterEnabled = clusterEnabled;
        mIsHudEnabled = hudEnabled;

        // 加载保存的主题
        int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                PresentationManager.THEME_DEFAULT);
        mPendingTheme = savedTheme;
        DebugLogger.i(TAG, "showUiOnly: Loaded saved theme: " + savedTheme);

        // [FIX Cold Boot] 加载 HUD 组件配置到缓存（如果 MainActivity 还没启动）
        if (hudEnabled && (mCachedHudComponents == null || mCachedHudComponents.isEmpty())) {
            loadCachedHudLayout();
        }

        // 创建并显示 PresentationManager
        if (clusterEnabled || hudEnabled) {
            showPresentationManager();
        }
    }

    /**
     * 仅切换导航模式。
     * 用于冷启动后的延迟切换。
     */
    public void applyNaviMode(int mode) {
        applyNaviMode(mode, null);
    }
    
    /**
     * 仅切换导航模式（带调用来源标识）
     * @param mode 目标模式
     * @param source 调用来源标识（用于日志追踪）
     */
    public void applyNaviMode(int mode, String source) {
        String sourceTag = (source != null) ? "[" + source + "] " : "";
        
        // [FIX] Deduplication and Throttle
        long now = System.currentTimeMillis();
        if (mode == mLastAppliedNaviMode && (now - mLastNaviModeApplyTime) < NAVI_MODE_THROTTLE_MS) {
            DebugLogger.d(TAG, sourceTag + "applyNaviMode(" + mode + ") throttled (duplicate within " + NAVI_MODE_THROTTLE_MS + "ms)");
            return;
        }
        
        DebugLogger.i(TAG, sourceTag + "applyNaviMode: " + mode);
        
        if (mIsClusterEnabled && mDimMenuInteraction != null) {
            try {
                Method switchNaviModeMethod = mDimMenuInteraction.getClass().getMethod("switchNaviMode", int.class);
                switchNaviModeMethod.invoke(mDimMenuInteraction, mode);
                
                // Update cache after successful call
                mLastAppliedNaviMode = mode;
                mLastNaviModeApplyTime = now;
                
                DebugLogger.i(TAG, sourceTag + "applyNaviMode: Called switchNaviMode(" + mode + ")");
            } catch (Exception e) {
                DebugLogger.e(TAG, sourceTag + "applyNaviMode: Failed to call switchNaviMode", e);
            }
        } else {
             // [FIX] Handle Race Condition: AdaptAPI might not be ready yet
             if (mIsClusterEnabled && mDimMenuInteraction == null) {
                 mPendingNaviMode = mode;
                 DebugLogger.w(TAG, sourceTag + "applyNaviMode: AdaptAPI not ready, caching pending mode: " + mode);
             } else {
                 DebugLogger.w(TAG, sourceTag + "applyNaviMode: Skipped (Cluster disabled=" + !mIsClusterEnabled + ")");
             }
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
                    mCachedHudComponents.clear();
                    for (HudComponentData data : syncList) {
                        mCachedHudComponents.put(data.type, data);
                    }
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

        // [FIX] Check Overlay Permission for background start
        if (!(mContext instanceof android.app.Activity)) {
             boolean canOverlay = false;
             if (android.os.Build.VERSION.SDK_INT >= 23) {
                 canOverlay = android.provider.Settings.canDrawOverlays(mContext);
             } else {
                 canOverlay = true; // Pre-M implicit
             }
             if (!canOverlay) {
                 DebugLogger.e(TAG, "ensureUiVisible: FATAL - Missing SYSTEM_ALERT_WINDOW permission. UI usually cannot show strictly from Service Context.");
                 // We proceed anyway as some systems bypass this, but log it.
             }
        }

        // [FIX] 调用ensureUiVisible时标记点火就绪
        // 因为此方法只应由handleIgnitionDriving触发
        mIgnitionReady = true;

        // [FIX] Check if features are enabled before showing
        // Force reload config to be safe
        boolean isCluster = ConfigManager.getInstance().getBoolean("switch_cluster", false);
        boolean isHud = ConfigManager.getInstance().getBoolean("switch_hud", false);
        mIsClusterEnabled = isCluster;
        mIsHudEnabled = isHud;
        
        if (!mIsClusterEnabled && !mIsHudEnabled) {
            DebugLogger.w(TAG, "ensureUiVisible: Ignored. Both Cluster and HUD are disabled (Config: Cluster=" + isCluster + ", HUD=" + isHud + ")");
            return;
        }

        // [FIX] 确保UI重建时，缓存被重新填充 (解决热启动显示0的问题)
        // 这一步至关重要：因为我们在standbyMode中清空了缓存，必须重新拉取一次静态数据
        // 否则直到下一次传感器变动前，界面都会显示0
        loadInitialSensorData();

        // Use post to ensure we are on main thread (redundant but safe)
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            DebugLogger.d(TAG, "ensureUiVisible: Already on Main Thread, showing now.");
            showPresentationManager();
        } else {
            DebugLogger.d(TAG, "ensureUiVisible: Posting to Main Thread handler.");
            mMainHandler.post(this::showPresentationManager);
        }
    }

    /**
     * [New] Enter Standby Mode
     * Called by KeepAliveAccessibilityService when ignition is OFF/LOCK/ACC.
     * Destroy UI resources and reset caches.
     */
    public void enterStandbyMode() {
        DebugLogger.i(TAG, "Entering Standby Mode (Destroying PresentationManager)...");

        // 1. 销毁 PresentationManager 窗口 (释放 Surface/Window 资源)
        if (mPresentationManager != null) {
            // Dismissing ensures strict cleanup of the display context
            mPresentationManager.dismiss();
            mPresentationManager = null; // Key step: Force ensureUiVisible to perform full recreation next time
        }

        // 2. 彻底清理缓存数据 (防止闪现旧数据)
        // 由于 HUD 数据是实时读取的，在下次启动(ensureUiVisible)时会通过 loadInitialSensorData
        // 重新拉取最新值，因此这里重置为默认值是安全的。
        synchronized (this) {
            mCachedSpeed = 0;
            mCachedRpm = 0;
            mCachedGear = 0; // Reset to P
            mCachedFuelLiters = 0;
            mCachedRangeKm = 0;
            // Clear lists? Maybe keeps layout components but data resets?
            // Actually layout components (text/pos) are static config, only their content
            // updates.
            // So we don't need to clear mCachedHudComponents list itself, just the *values*
            // inside?
            // loadInitialSensorData will update the *values* via updateComponentText calls.
            // So this is fine.
        }

        // 3. 重置内部状态
        mSimulatedGearEnabled = ConfigManager.getInstance().getBoolean("simulated_gear_enabled", false);
        
        DebugLogger.i(TAG, "Standby Mode Active: UI Dismissed, Caches Reset.");
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

    private void updatePresentationManager() {
        // Fix: Decoupled Cluster and HUD. PresentationManager should only stay alive if AT
        // LEAST ONE is enabled.
        if (mIsClusterEnabled || mIsHudEnabled) {
            if (mPresentationManager == null) {
                showPresentationManager();
            } else {
                // Ensure specific visibilities are updated
                mPresentationManager.setClusterVisible(mIsClusterEnabled);
                mPresentationManager.setHudVisible(mIsHudEnabled);
            }
        } else {
            // Only dismiss if BOTH are disabled
            dismissPresentationManager();
        }
    }

    // [New] Allow Service to configure and trigger UI directly
    public void configureAndShowUi(boolean showCluster, boolean showHud) {
        this.mIsClusterEnabled = showCluster;
        this.mIsHudEnabled = showHud;
        DebugLogger.i(TAG, "configureAndShowUi: Cluster=" + showCluster + ", HUD=" + showHud);
        ensureUiVisible();
    }

    private void showPresentationManager() {
        DebugLogger.d(TAG, "showPresentationManager: [Step 1] Getting DisplayManager");
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        if (dm == null) {
            DebugLogger.e(TAG, "showPresentationManager: Failed to get DisplayManager");
            return;
        }
        Display[] displays = dm.getDisplays();
        DebugLogger.d(TAG, "showPresentationManager: [Step 2] Found " + displays.length + " displays total");

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
            // [FIX] Prevent Duplicate PresentationManager (Ghosting Issue)
            if (mPresentationManager != null) {
                DebugLogger.w(TAG, "showPresentationManager: PresentationManager already exists! Skipping creation.");
                if (!mPresentationManager.isShowing()) {
                    mPresentationManager.show();
                }
                return;
            }

            mRetryCount = 0; // Reset retry counter on success
            DebugLogger.d(TAG, "showPresentationManager: [Step 3] Creating PresentationManager Window");
            try {
                // [FIX] Z-Order Correction: Use standard Presentation constructor
                // This ensures correct Z-Order handling (system managed)
                mPresentationManager = new PresentationManager(mContext, targetDisplay);
                mCurrentAppliedTheme = -1; // [FIX] Reset state so theme is re-applied to new instance
                DebugLogger.d(TAG, "showPresentationManager: [Step 4] Presentation Object Created (Standard Presentation)");

                // Logging for verification
                if (mPresentationManager.getWindow() != null) {
                    DebugLogger.d(TAG, "Dialog Window Type: " + mPresentationManager.getWindow().getAttributes().type);
                }

                mPresentationManager.setOnShowListener(dialog -> {
                    // Logic Fix: Apply Persistence Mode (Dashboard vs List)
                    if (mIsDashboardMode) {
                        mPresentationManager.enableClusterDashboard();
                        DebugLogger.d(TAG, "Restored Dashboard Mode on show");
                    } else if (mCachedClusterComponents != null) {
                        mPresentationManager.syncClusterLayout(new java.util.ArrayList<>(mCachedClusterComponents.values()));
                        DebugLogger.d(TAG, "Applied cached Cluster components on show");
                    }

                    if (mCachedHudComponents != null) {
                        mPresentationManager.syncHudLayout(new java.util.ArrayList<>(mCachedHudComponents.values()));
                        DebugLogger.d(TAG, "Applied cached HUD components on show");
                    }

                    // 应用保存的主题（始终应用，确保正确的布局被加载）
                    mPresentationManager.setClusterTheme(mPendingTheme);
                    DebugLogger.d(TAG, "Applied pending theme on show: " + mPendingTheme);

                    // [FIX Cold Boot] Apply cached gear value (Use String with Simulation Logic)
                    if (mCachedGear != -1) {
                        mPresentationManager.updateGear(getCurrentDisplayGear());
                        DebugLogger.d(TAG, "Applied cached gear on show: " + getCurrentDisplayGear() + " (Raw: " + mCachedGear + ")");
                    }

                    // [FIX Cold Boot] Apply cached sensor values
                    if (mPresentationManager != null) {
                        // Sync Text Components (HUD)
                        mPresentationManager.updateComponent("fuel", mCachedFuelText, null);
                        mPresentationManager.updateComponent("temp_out", mCachedTempOutText, null);
                        mPresentationManager.updateComponent("temp_in", mCachedTempInText, null);
                        mPresentationManager.updateComponent("range", mCachedRangeText, null);
                        mPresentationManager.updateComponent("fuel_range", mCachedFuelText + "|" + mCachedRangeText, null);
                        
                        // [FIX] Sync Numeric Values (Cluster Theme)
                        // This ensures the Audi/Standard cluster gets data immediately, not just on next change.
                        mPresentationManager.updateFuelRemain(mCachedFuelLiters);
                        mPresentationManager.updateOdometer(mCachedOdometer);
                        mPresentationManager.updateSpeed(mCachedSpeed);
                        mPresentationManager.updateRpm(mCachedRpm);
                        mPresentationManager.updateInstantFuel(mCachedFuelIns); 
                    }
                    
                    // [FIX] Apply Visibility inside OnShowListener to ensure Views are inflated and ready
                    // Doing this outside show() caused race condition where views were still null/gone.
                    DebugLogger.i(TAG, "OnShowListener: Applying Visibility - Cluster=" + mIsClusterEnabled + ", HUD=" + mIsHudEnabled);
                    mPresentationManager.setClusterVisible(mIsClusterEnabled);
                    mPresentationManager.setHudVisible(mIsHudEnabled);
                    
                    // [FIX] Apply Floating Traffic Light State
                    mPresentationManager.setFloatingTrafficLightEnabled(mIsFloatingEnabled);
                    mPresentationManager.setMediaPlaying(mIsMediaPlaying); // Sync initial state
                    mPresentationManager.setHudGreenBg(mIsHudGreenBgExposed); // Apply Green Bg State
                });

                mPresentationManager.show();
                // [MOVED] Visibility setting moved to OnShowListener to ensure View readiness
                // mPresentationManager.setClusterVisible(mIsClusterEnabled);
                // mPresentationManager.setHudVisible(mIsHudEnabled);
                // mPresentationManager.setFloatingTrafficLightEnabled(mIsFloatingEnabled); // Apply Floating State
                // mPresentationManager.setMediaPlaying(mIsMediaPlaying); // Sync initial state
                // mPresentationManager.setHudGreenBg(mIsHudGreenBgExposed); // Apply Green Bg State

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
                        if (mPresentationManager != null && mPresentationManager.getContext() != null) {
                            presUiMode = mPresentationManager.getContext().getResources().getConfiguration().uiMode
                                    & Configuration.UI_MODE_NIGHT_MASK;
                        }
                        DebugLogger.i(TAG, "Delayed (2s) DayMode Re-Check: SystemUI=" + delayedUiMode + ", PresUI="
                                + presUiMode + " -> isDay=" + delayedIsDay);

                        if (mPresentationManager != null) {
                            mPresentationManager.setDayMode(delayedIsDay);
                        }
                    } catch (Exception e) {
                        DebugLogger.e(TAG, "Error in Delayed DayMode Check", e);
                    }
                }, 2000);

                DebugLogger.i(TAG, "ClusterHudPresentationManager SHOWN on Display 2");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to show presentation", e);
                mPresentationManager = null;
            }
        } else {
            // [Fix Cold Boot] Retry Logic for Display 2
            // The HDMI display might take longer to initialize than the app.
            // We retry every 1 second for up to 30 seconds.
            if (mRetryCount < 30) {
                mRetryCount++;
                DebugLogger.w(TAG, "Display ID 2 not found yet. Retrying in 1s... (Attempt " + mRetryCount + "/30)");
                mMainHandler.postDelayed(this::showPresentationManager, 1000);
            } else {
                DebugLogger.e(TAG, "Display ID 2 check timed out after 30s. Background UI start failed.");
                // Optionally reset retry count here if we want to allow manual retries later
                mRetryCount = 0;
            }
        }
    }

    private void dismissPresentationManager() {
        if (mPresentationManager != null) {
            try {
                mPresentationManager.dismiss();
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to dismiss presentation", e);
            } finally {
                mPresentationManager = null;
                DebugLogger.i(TAG, "ClusterHudPresentationManager DISMISSED");
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
        dismissPresentationManager();
        // If either Cluster or HUD is enabled, recreate immediately
        if (mIsClusterEnabled || mIsHudEnabled) {
            mMainHandler.postDelayed(this::showPresentationManager, 100);
        }
    }

    public void syncHudLayout(List<HudComponentData> components) {
        if (components == null)
            return;
        synchronized (this) {
            // [OPTIMIZATION] Efficient Map Sync (O(N) instead of O(N^2))
            
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
                } else if ("gear".equals(newData.type)) {
                    // [FIX] Backfill current gear (Sync Logic - Existing Data)
                    newData.text = getGearString(mCachedGear);
                } else if ("song_2line".equals(newData.type)) {
                    // [FIX] Backfill Music Title/Artist
                    if (mCachedSongTitle != null && !mCachedSongTitle.isEmpty()) {
                        String display = mCachedSongTitle;
                        if (mCachedSongArtist != null && !mCachedSongArtist.isEmpty()) {
                            display = mCachedSongTitle + "\n" + mCachedSongArtist;
                        }
                        newData.text = display;
                    } else if ("歌曲标题".equals(newData.text)) {
                         // Placeholder preservation: do nothing if cache is empty
                    } else if (mCachedSongTitle != null) {
                        // Cache is empty string but not null, and current text isn't placeholder
                        // We can overwrite it (e.g. music stopped)
                         newData.text = "";
                    }
                } else if ("song_1line".equals(newData.type)) {
                    // [FIX] Backfill Music Title Only
                    if (mCachedSongTitle != null && !mCachedSongTitle.isEmpty()) {
                        newData.text = mCachedSongTitle;
                    } else if ("歌曲标题".equals(newData.text)) {
                        // Placeholder preservation
                    } else if (mCachedSongTitle != null) {
                         newData.text = "";
                    }
                } else if ("song_cover".equals(newData.type)) {
                    // [FIX] Backfill Cover Art
                    if (mCachedCoverArt != null) {
                        newData.image = mCachedCoverArt;
                    }
                } else if ("fuel".equals(newData.type)) {
                    if (mCachedFuelText != null) newData.text = mCachedFuelText;
                } else if ("range".equals(newData.type)) {
                    if (mCachedRangeText != null) newData.text = mCachedRangeText;
                } else if ("temp_out".equals(newData.type)) {
                    if (mCachedTempOutText != null) newData.text = mCachedTempOutText;
                } else if ("temp_in".equals(newData.type)) {
                    if (mCachedTempInText != null) newData.text = mCachedTempInText;
                } else if ("fuel_range".equals(newData.type)) {
                    newData.text = String.format("⛽ %.0fL|%.0fKM", mCachedFuelLiters, mCachedRangeKm);
                } else if ("hud_rpm".equals(newData.type)) {
                    // [FIX] Backfill RPM with cached value
                    newData.text = String.format(Locale.getDefault(), "%.0fRPM", mCachedRpm);
                }

                // Preserve Image Logic (O(1) Lookup)
                if (newData.image == null) {
                    HudComponentData oldData = mCachedHudComponents.get(newData.type);
                    if (oldData != null && oldData.image != null) {
                        newData.image = oldData.image;
                        DebugLogger.d(TAG, "Restored image for " + newData.type + " during sync");
                    }
                }
            }

            // Rebuild Map
            mCachedHudComponents.clear();
            for (HudComponentData data : components) {
                mCachedHudComponents.put(data.type, data);
            }

            applyMediaPersistence(); // Apply saved media state over defaults

            // Logic Fix: Apply Pending Media (from Startup Race Condition)
            if (mPendingSongText != null) {
                DebugLogger.d(TAG, "Applying pending song text from cache: " + mPendingSongText);
                updateComponentText("song_2line", mPendingSongText);
                mPendingSongText = null; // Clear
            }
            if (mPendingCoverArt != null) {
                DebugLogger.d(TAG, "Applying pending cover art from cache");
                updateComponentImage("song_cover", mPendingCoverArt);
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
        if (mPresentationManager != null) {
            // [Fix] Convert Map values to List
            mPresentationManager.syncHudLayout(new ArrayList<>(mCachedHudComponents.values()));
            // Force update turn_signal with current real sensor state (hiding placeholder)
            updateTurnSignal();
        }

        // Notify Listener (MainActivity Preview) of the full sync (Logic Fix for
        // Preview Persistence)
        if (mListener != null) {
            final java.util.List<HudComponentData> snapshot = new java.util.ArrayList<>(mCachedHudComponents.values());
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
            final java.util.List<HudComponentData> snapshot = new java.util.ArrayList<>(mCachedHudComponents.values());
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
            mCachedClusterComponents.clear(); // [FIX] Clear map
            for (HudComponentData data : components) {
                mCachedClusterComponents.put(data.type, data);
            }
        }
        if (mPresentationManager != null) {
            // [Fix] Convert values to List
            mPresentationManager.syncClusterLayout(new ArrayList<>(mCachedClusterComponents.values()));
            updateTurnSignal(); // Force update
        }
    }

    public List<HudComponentData> getCachedHudComponents() {
        synchronized (this) {
             // [Optimization] Return list from map values
            return mCachedHudComponents != null ? new ArrayList<>(mCachedHudComponents.values()) : null;
        }
    }

    public void syncTestMedia() {
        String title = "测试歌曲 Title";
        String artist = "测试歌手 Artist";
        android.graphics.Bitmap art = android.graphics.Bitmap.createBitmap(100, 100,
                android.graphics.Bitmap.Config.ARGB_8888);
        art.eraseColor(android.graphics.Color.RED);

        String display = "测试歌词 Lyric\n" + title + " - " + artist;
        updateComponentText("song_2line", display);
        updateComponentImage("song_cover", art);
        updateMediaPlayingState(true); // Force show for testing
    }


    public void clearHudComponents() {
        DebugLogger.i(TAG, "Clearing HUD/Cluster components cache");
        if (mPresentationManager != null) {
            mPresentationManager.clearHudComponents();
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
        if (mPresentationManager != null) {
            mPresentationManager.enableClusterDashboard();
        } else {
            // Need to handle if presentation not ready?
            // For now, assume it's synced when presentation shows if we store mode state.
            // But skipping complexity for this step.
        }
    }

    /**
     * 设置仪表盘主题
     * 
     * @param theme ClusterHudPresentationManager.THEME_DEFAULT 或
     *              ClusterHudPresentationManager.THEME_AUDI_RS
     */
    public void setClusterTheme(int theme) {
        // [Fix Cold Boot] Skip if already applied to active presentation
        if (mPresentationManager != null && mCurrentAppliedTheme == theme) {
            DebugLogger.d(TAG, "setClusterTheme: Theme " + theme + " already applied, skipping.");
            return;
        }

        // 始终保存主题，以便后续presentation创建时使用
        mPendingTheme = theme;
        DebugLogger.d(TAG, "setClusterTheme: theme=" + theme + ", mPresentationManager=" + (mPresentationManager != null));

        if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.setClusterTheme(theme);
                    mCurrentAppliedTheme = theme; // Update applied theme
                    
                    // [FIX] Persist theme immediately to prevent reset after restart/update
                    ConfigManager.getInstance().setInt("cluster_theme_builtin", theme);
                    
                    // [FIX] Theme Switch State Sync
                    // Force push current static states to the new theme controller
                    // Speed/RPM update frequently so they self-correct, but Gear is static.
                    if (mCachedGear != -1) {
                        mPresentationManager.updateGear(mCachedGear);
                    }
                }
            });
        }
    }

    public int getCurrentClusterTheme() {
        if (mPresentationManager != null) {
            return mPresentationManager.getCurrentTheme();
        }
        return PresentationManager.THEME_DEFAULT;
    }

    // Moved to top: private final Handler mMainHandler = new
    // Handler(Looper.getMainLooper());

    // --- Simulated Gear Logic ---

    public void setSimulatedGearEnabled(boolean enabled) {
        mSimulatedGearEnabled = enabled;
        DebugLogger.d(TAG, "Simulated Gear Enabled: " + enabled);
        if (mSimulatedGearEnabled) {
            calculateAndPushSimulatedGear();
        } else {

            // [Fix] Restore real gear immediately when simulation is disabled
            String realGear = SimulateGear.mapRawGearToChar(mCachedGear);
            
            // [Fix] Force reset LastSimulatedGear to ensure next toggle works
            mLastSimulatedGear = ""; 
            
            updateComponentText("gear", realGear);
            
            // [Safety] Also force update via updateGear(int) path which updates specific Theme Controllers
            // (StandardThemeController or AudiRsThemeController)
            if (mPresentationManager != null) {
                 mPresentationManager.updateGear(mCachedGear);
            }
        }
    }

    // [FIX] Changed to float for precision
    public void updateRpm(float rpm) {
        // [FIX] Throttle RPM updates to prevent ANR (~50Hz -> ~10Hz effective for UI or just filter noise)
        // Using 5.0f threshold still keeps it stable while allowing micro-movements if consistent
        if (Math.abs(mCachedRpm - rpm) < 5.0f && mCachedRpm != 0) {
             return;
        }
        mCachedRpm = rpm;
        
        // [NEW] HUD RPM Component Logic
        // Logic: Round to nearest 50rpm for stability (prevent flickering digits)
        // e.g. 2123 -> 2100; 2135 -> 2150
        int displayRpm = Math.round(rpm / 50.0f) * 50;
        String rpmText = displayRpm + "RPM";
        // Directly update component via text (handled by HUD logic)
        updateComponentText("hud_rpm", rpmText);

        if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.updateRpm(rpm);
                }
            });
        }
        if (mSimulatedGearEnabled) {
            calculateAndPushSimulatedGear();
        }
    }

    public void cycleGear() {
        if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.cycleGear();
                }
            });
        }
    }

    public void updateGear(int gearValue) {
        boolean gearChanged = (mCachedGear != gearValue);
        mCachedGear = gearValue;

        // [FIX] Route gear updates through generic component system 
        // This ensures BOTH the PresentationManager (Real HUD) and the Listener (Preview) are updated.
        if (mSimulatedGearEnabled) {
            // Pass true to force update if real gear changed background state
            calculateAndPushSimulatedGear(gearChanged);
        } else {
             // Real Gear Update
             String gearStr = SimulateGear.mapRawGearToChar(gearValue);
             updateComponentText("gear", gearStr);
             
             // [FIX] Ensure Theme Controllers (Standard/Audi) also get the update!
             // Now passing STRING to support D1-D8/M1-M8 on all themes consistently.
             if (mPresentationManager != null) {
                 mMainHandler.post(() -> {
                     if (mPresentationManager != null) {
                         mPresentationManager.updateGear(gearStr);
                     }
                 });
             }
        }
    }

    // [FIX] Changed to float for precision
    public void updateSpeed(float speed) {
        if (mCachedSpeed == speed) return; // [FIX] Filter duplicates (Float comparison)

        // [DEBUG] Log updateSpeed call (Reduced)
        // if (mSimulatedGearEnabled) { DebugLogger.d(TAG, "updateSpeed: " + speed); }
        
        mCachedSpeed = speed;
        if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.updateSpeed(speed);
                }
            });
        }
        if (mSimulatedGearEnabled) {
            calculateAndPushSimulatedGear();
        }
    }

    private String mLastSimulatedGear = ""; // Cache for dedup

    private void calculateAndPushSimulatedGear() {
        // [FIX] Removed spammy log "Triggering Simulated Gear Calculation"
        calculateAndPushSimulatedGear(false);
    }

    private void calculateAndPushSimulatedGear(boolean forceImmediate) {
        // [FIX] 即使是 -1 也传递给转换函数，因为 -1 代表 M 档，不应替换为 P
        String baseGear = SimulateGear.mapRawGearToChar(mCachedGear);

        String calculated = SimulateGear.getInstance().calculateGear(
                mCachedSpeed,
                mCachedRpm,
                baseGear,
                forceImmediate);

        // [FIX] Only push to UI if changed to prevent Main Thread flooding (ANR fix)
        if (!forceImmediate && calculated != null && calculated.equals(mLastSimulatedGear)) {
            return;
        }
        
        mLastSimulatedGear = calculated;

        if (mPresentationManager != null) {
             // [FIX] Update via Component System for Preview Sync
             updateComponentText("gear", calculated);
             
             // [FIX] Also update Theme Controllers (Standard/Audi) for simulated gears like D1/M1!
             // Previously only updateComponentText was called, so controllers never saw "D1" etc.
             mMainHandler.post(() -> {
                 if (mPresentationManager != null) {
                     mPresentationManager.updateGear(calculated);
                 }
             });
        }
    }

    private String convertGearValueToString(int gearValue) {
        // M Gear support: Priority check for -1
        if (gearValue == -1) {
            return "M";
        }

        // Gear constants (Duplicated from PresentationManager/SoundPromptManager)
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

        if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.setDayMode(isDay);
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
            if (mPresentationManager != null) {
                mPresentationManager.setMediaPlaying(mIsMediaPlaying);
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
        public String type; // "text", "time", "song_2line", "song_1line", "fuel", "temp_out", "temp_in", "range", "gear",
                            // "song_cover", "turn_signal", "volume", "gauge"
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
        if (mPresentationManager != null) {
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.setHudGreenBg(enabled);
                }
            });
        }
    }

    public boolean isSnowModeEnabled() {
        return ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
    }

    // --- Sensor Data Variables ---
    // [Note] Duplicate declarations removed.
    // The active declarations are below this block.

    // --- Sensor Data Persistence [REMOVED] ---
    private boolean mSensorsRegistered = false; 

    private String mCachedFuelText = "⛽ 0L";
    private String mCachedRangeText = "0KM";
    private String mCachedTempOutText = "0.0°C";
    private String mCachedTempInText = "0.0°C";

    /**
     * [NEW] Initialize sensor data from VehicleSensorManager
     * Direct data fetching, no disk cache.
     */
    private void loadInitialSensorData() {
        VehicleSensorManager manager = VehicleSensorManager.getInstance(mContext);
        
        // Fuel
        float fuel = manager.getFuel();
        updateFuelWithValue(fuel);
        
        // Range
        float range = manager.getRange();
        updateRange(String.format(Locale.US, "%.0fKM", range));
        
        // Temp
        updateTempOut(String.format(Locale.US, "%.1f°C", manager.getTempOutdoor())); // [FIX] Use %.1f matching runtime
        updateTempIn(String.format(Locale.US, "%.1f°C", manager.getTempIndoor()));   // [FIX] Use %.1f matching runtime
        
        // [FIX] PRM & Speed - Direct Read logic as requested by user
        float rpm = manager.getRpm();
        updateRpm(rpm); 
        
        float speed = manager.getSpeed();
        updateSpeed(speed);

        // Gear
        // [FIX] Read current gear immediately to replace default
        int gear = manager.getGear();
        updateGear(gear);
        
        // [FIX] Odometer Init
        float odometer = manager.getOdometer();
        if (mPresentationManager != null) {
             final float finalOdo = odometer;
             mMainHandler.post(() -> {
                 if (mPresentationManager != null) {
                     mPresentationManager.updateOdometer(finalOdo);
                 }
             });
        }
        // Also update Trip info if needed?
        // [User Request] Soft Trip Logic Removed
        /* if (odometer > 0) {
             updateSoftTripDistance(odometer);
        } */
    }

    /**
     * [NEW] Live Sensor Data Getters for HUD Editor
     * Bypasses internal cache to ensure Preview shows real-time data.
     */
    public String getCurrentFuelText() {
        float val = VehicleSensorManager.getInstance(mContext).getFuel();
        return String.format(Locale.US, "⛽ %.0fL", val);
    }

    public String getCurrentRangeText() {
        float val = VehicleSensorManager.getInstance(mContext).getRange();
        return String.format(Locale.US, "%.0fKM", val);
    }

    public String getCurrentTotalFuelRangeText() {
        VehicleSensorManager vsm = VehicleSensorManager.getInstance(mContext);
        return String.format(Locale.US, "⛽ %.0fL|%.0fKM", vsm.getFuel(), vsm.getRange());
    }

    public String getCurrentTempOutText() {
        float val = VehicleSensorManager.getInstance(mContext).getTempOutdoor();
        return String.format(Locale.US, "%.1f°C", val);
    }

    public String getCurrentTempInText() {
        float val = VehicleSensorManager.getInstance(mContext).getTempIndoor();
        return String.format(Locale.US, "%.1f°C", val);
    }

    public String getCurrentRpmText() {
        float val = VehicleSensorManager.getInstance(mContext).getRpm();
        return String.format(Locale.US, "%.0fRPM", val);
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
                mCachedHudComponents.clear();
                for (HudComponentData data : components) {
                     mCachedHudComponents.put(data.type, data);
                }
                DebugLogger.i(TAG, "loadHudLayoutFromDisk: Loaded " + components.size() + " components from disk");
            }
        } catch (org.json.JSONException e) {
            DebugLogger.e(TAG, "loadHudLayoutFromDisk: Failed to parse layout JSON", e);
        }
    }

    public void updateFuel(String text) {
        mCachedFuelText = text;
        // saveSensorCache("last_fuel_text", text); [REMOVED]
        if (mPresentationManager != null) {
            updateComponentText("fuel", text);
        }
    }

    /**
     * [NEW] Update fuel with float value (in liters).
     * This properly updates both mCachedFuelLiters and mCachedFuelText.
     */
    public void updateFuelWithValue(float liters) {
        // [FIX] Throttle updates (0.1L threshold) to prevent spam
        if (Math.abs(mCachedFuelLiters - liters) < 0.1f) {
            return; 
        }
        mCachedFuelLiters = liters;
        String text = String.format("⛽ %.0fL", liters);
        mCachedFuelText = text;
        // saveSensorCache("last_fuel_text", text); [REMOVED]
        if (mPresentationManager != null) {
            updateComponentText("fuel", text);
            updateFuelRangeComponent();
            mPresentationManager.updateFuelRemain(liters);
        }
    }

    public void updateRange(String text) {
        mCachedRangeText = text;
        // saveSensorCache("last_range_text", text); [REMOVED]
        if (mPresentationManager != null) {
            updateComponentText("range", text);
            updateComponentText("fuel_range", mCachedFuelText + "|" + mCachedRangeText); // Update combined too
        }
    }

    public void updateTempOut(String text) {
        mCachedTempOutText = text;
        // saveSensorCache("last_temp_out_text", text); [REMOVED]
        if (mPresentationManager != null) {
            updateComponentText("temp_out", text);
        }
    }

    public void updateTempIn(String text) {
        mCachedTempInText = text;
        // saveSensorCache("last_temp_in_text", text); [REMOVED]
        if (mPresentationManager != null) {
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
            mSimulatedGearEnabled = ConfigManager.getInstance().getBoolean("simulated_gear_enabled", false);
            // [NEW] Load Green Background State
            mIsHudGreenBgExposed = ConfigManager.getInstance().getBoolean("hud_green_bg_enabled", false);
            DebugLogger.i(TAG, "Self-Init: Loaded State -> Cluster=" + mIsClusterEnabled + ", HUD=" + mIsHudEnabled
                    + ", Floating=" + mIsFloatingEnabled + ", SimGear=" + mSimulatedGearEnabled + ", GreenBg="
                    + mIsHudGreenBgExposed);

            // 2. Load Theme
            mPendingTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                    PresentationManager.THEME_DEFAULT);
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
     * Called by NaviInfoManager when valid data arrives or times out.
     */
    public void updateNaviInputState(boolean isNavigating) {
        if (mPresentationManager != null) {
            // Ensure we are on main thread
            mMainHandler.post(() -> {
                if (mPresentationManager != null) {
                    mPresentationManager.setNavigating(isNavigating);
                }
            });
        }
    }

    // --- Simplified Navigation Logic ---

    // [SIMPLIFIED] Direct Pass-through
    public void onTrafficLightUpdate(final NaviInfoManager.TrafficLightInfo info) {
        mMainHandler.post(() -> {
            if (mPresentationManager != null) {
                // [FIX] Do NOT force navigating state on data. Rely on onNaviStatusUpdate.
                mPresentationManager.updateTrafficLight(info);
            }
            // Also update Main Screen Manager
            NaviInfoManager.getInstance(mContext).updateTrafficLight(info);
        });
    }

    // [SIMPLIFIED] Direct Pass-through
    // [SIMPLIFIED] Direct Pass-through & Auto-Start
    public void onGuideInfoUpdate(final NaviInfoManager.GuideInfo info) {
        mMainHandler.post(() -> {
            // [FIX] Auto-Start Logic: If we receive valid data, we are navigating.
            // We NO LONGER block updates based on !isNavigating().
            // Instead, we FORCE it to true if data comes in.
            if (mPresentationManager != null && !mPresentationManager.isNavigating()) {
                 DebugLogger.e(TAG, "[NAVI_CYCLE] Auto-Starting Navigation (Data Received)");
                 mPresentationManager.setNavigating(true);
            }

            // [FIX] Explicitly update generic components (text/cache)
            // This ensures HUD components like navi_next_road, navi_current_road update correctly,
            // and mCachedHudComponents is kept in sync.
            if (info != null) {
                updateComponentText("navi_current_road", info.currentRoadName);
                updateComponentText("navi_next_road", info.nextRoadName);
                
                // Distance and Time need formatting
                String distanceText = info.routeRemainDis >= 1000 ? 
                        String.format(Locale.US, "%.1fKM", info.routeRemainDis / 1000f) : 
                        info.routeRemainDis + "M";
                updateComponentText("navi_distance_remaining", distanceText);
                
                String etaText = NaviInfoManager.calculateEta(info.routeRemainTime);
                updateComponentText("navi_arrival_time", etaText);
            }

            if (mPresentationManager != null) {
                mPresentationManager.updateGuideInfo(info);
            }
            NaviInfoManager.getInstance(mContext).updateGuideInfo(info);
        });
    }


    public void onNaviStatusUpdate(final int state) {
        mMainHandler.post(() -> {
            try {
                DebugLogger.e(TAG, "[NAVI_CYCLE] onNaviStatusUpdate: State=" + state); // [LOG] High Priority
                
                // State 1=Navi, 8=Emulator, 9=StartGuide
                if (state == 1 || state == 8 || state == 9) {
                    if (mPresentationManager != null) {
                        DebugLogger.e(TAG, "[NAVI_CYCLE] Starting Navigation (setNavigating=true)"); // [LOG]
                        mPresentationManager.setNavigating(true);
                    }
                } 
                // State 2 = Stopped (User says NO), 40 = End (Confirmed?)
                // [FIX] State 40 is a KEEP-ALIVE heartbeat (every ~10s). IGNORE IT.
                // [FIX] Log analysis shows State 35, 308 appear at END sequence.
                // We use 35 and 308 as explicit hard-stop triggers.
                else if (state == 35 || state == 308) {
                     DebugLogger.e(TAG, "[NAVI_CYCLE] STOP DETECTED (State " + state + ") -> calling resetAllNavigationUI"); // [LOG]
                     resetAllNavigationUI();
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error in onNaviStatusUpdate state=" + state, e);
            }
        });
    }

    /**
     * Centralized Reset for ALL Navigation UI
     */
    private void resetAllNavigationUI() {
        DebugLogger.e(TAG, "[NAVI_CYCLE] resetAllNavigationUI: EXECUTE START"); // [LOG]
        try {
            if (mPresentationManager != null) {
                // 1. Force state to false
                DebugLogger.e(TAG, "[NAVI_CYCLE] 1. setNavigating(false)");
                mPresentationManager.setNavigating(false);

                // 2. Clear Traffic Lights
                DebugLogger.e(TAG, "[NAVI_CYCLE] 2. resetTrafficLights");
                mPresentationManager.resetTrafficLights();

                // 3. Clear Guide Info (Strings/HUD)
                DebugLogger.e(TAG, "[NAVI_CYCLE] 3. resetNaviInfo");
                mPresentationManager.resetNaviInfo();
            }

            // 4. Force Remove Window (Redundant safety)
            DebugLogger.e(TAG, "[NAVI_CYCLE] 4. forceRemoveFloatingWindow (Backup)");
            // The original code called mPresentationManager.forceRemoveFloatingWindow();
            // Assuming forceRemoveFloatingWindow() is a method of the current class or accessible.
            // If it's a method of mPresentationManager, it should be mPresentationManager.forceRemoveFloatingWindow();
            // Based on the original code, it was mPresentationManager.forceRemoveFloatingWindow();
            // Reverting to that for correctness.
            if (mPresentationManager != null) {
                mPresentationManager.forceRemoveFloatingWindow();
            }


            DebugLogger.e(TAG, "[NAVI_CYCLE] resetAllNavigationUI: EXECUTE END (Success)");
        } catch (Exception e) {
            DebugLogger.e(TAG, "[NAVI_CYCLE] CRITICAL ERROR in resetAllNavigationUI", e);
        }

        // 2. Reset Data Manager (State)
        try {
            NaviInfoManager.getInstance(mContext).reset();
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error resetting NaviInfoManager", e);
        }
        
        // 3. Restore Instrument Mode (3) asynchronously
        new Thread(() -> {
            try {
                applyNaviMode(3, "NAVI-END");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error applying navi mode", e);
            }
        }).start();
    }

}
