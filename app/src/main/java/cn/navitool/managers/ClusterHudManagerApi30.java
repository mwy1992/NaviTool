package cn.navitool.managers;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;

import java.util.List;

import cn.navitool.controller.NaviInfoController;
import cn.navitool.utils.DebugLogger;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.CarServiceManager;

// AdaptAPI Imports
import com.ecarx.xui.adaptapi.car.ICar;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;
import com.ecarx.xui.adaptapi.FunctionStatus;

/**
 * Android 11+ Specific Cluster & HUD Manager.
 * Handles dual-screen Presentation management (HUD + Cluster) separately.
 * Implements "Emulator Mode" for testing on standard Android displays.
 * Integrates CarService for Turn Signals and AutoHold.
 */
public class ClusterHudManagerApi30 {
    
    // [API30] Distinct Logging Requirement
    private static final String TAG = "ClusterHudManagerApi30";
    private static final String LOG_PREFIX = "[API30] ";

    private static volatile ClusterHudManagerApi30 instance;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    // Dual Presentations
    private PresentationManagerApi30 mHudPresentation;
    private PresentationManagerApi30 mClusterPresentation;

    // Display IDs (Hardcoded Requirement)
    private static final int DISPLAY_ID_HUD_REAL = 1;      // 800x480
    private static final int DISPLAY_ID_CLUSTER_REAL = 4;  // 1920x720
    
    private static final int DISPLAY_ID_HUD_EMULATOR = 2;
    private static final int DISPLAY_ID_CLUSTER_EMULATOR = 3;

    // State
    private boolean mIsEmulatorMode = false;
    private boolean mIsAmapForeground = false;
    
    private List<ClusterHudManager.HudComponentData> mCachedHudComponents;
    private List<ClusterHudManager.HudComponentData> mCachedClusterComponents;

    // Car Service & Sensors
    private ICar mCar;
    private ICarFunction mCarFunction;
    private ECarFunctionListener mFunctionListener;
    
    // Constants from ClusterHudManager
    private static final int FUNC_LEFT_TRUN_SIGNAL = 553980160;
    private static final int FUNC_RIGHT_TRUN_SIGNAL = 553980416;
    private static final int FUNC_AUTOHOLD_STATUS = 33661;
    
    // Blinking Handling
    private boolean mLeftTurnOn = false;
    private boolean mRightTurnOn = false;
    private boolean mBlinkVisible = true;
    private static final int BLINK_INTERVAL = 400; // 400ms
    private final Handler mBlinkHandler = new Handler(Looper.getMainLooper());
    
    private final Runnable mBlinkRunnable = new Runnable() {
        @Override
        public void run() {
            // Toggle Visibility
            mBlinkVisible = !mBlinkVisible;
            // Update UI
            dispatchTurnSignalUpdate();

            // Schedule next toggle if either signal is ON
            if (mLeftTurnOn || mRightTurnOn) {
                mBlinkHandler.postDelayed(this, BLINK_INTERVAL);
            } else {
                mBlinkVisible = false; // Reset to invisible when stopped
            }
        }
    };

    // Singleton
    public static ClusterHudManagerApi30 getInstance(Context context) {
        if (instance == null) {
            synchronized (ClusterHudManagerApi30.class) {
                if (instance == null) {
                    instance = new ClusterHudManagerApi30(context);
                }
            }
        }
        return instance;
    }

    // Theme State
    private int mCurrentTheme = PresentationManagerApi30.THEME_DEFAULT;

    private ClusterHudManagerApi30(Context context) {
        mContext = context.getApplicationContext(); 
        // Load Emulator Mode Pref
        mIsEmulatorMode = ConfigManager.getInstance().getBoolean("config_emulator_mode_enabled", false);
        DebugLogger.i(TAG, LOG_PREFIX + "Initialized. Emulator Mode: " + mIsEmulatorMode);
        
        // Init Car Service
        initCarService();
        
        // [API30] Load Layouts
        loadHudLayoutFromDisk();
        initDefaultCluster();
        
        // Listen for Dispaly Changes (Hot-plug / Late Init)
        registerDisplayListener();
    }

    private void initDefaultCluster() {
        // Default to Theme 1 (Standard) or check config
        int theme = ConfigManager.getInstance().getInt("cluster_theme_builtin", PresentationManagerApi30.THEME_DEFAULT);
        setClusterTheme(theme);
    }

    public void setClusterTheme(int theme) {
        mCurrentTheme = theme; // [FIX] Persist theme selection so recreation uses correct theme
        if (mClusterPresentation != null) {
            mClusterPresentation.setClusterTheme(theme);
        }
    }

    // Adapted from Legacy ClusterHudManager
    private void loadHudLayoutFromDisk() {
        // Mode 0=WHUD, 1=AR. Default to 0? Or check ConfigManager default?
        // Legacy: ConfigManager.getInstance().getInt("hud_current_mode", 0);
        int hudMode = ConfigManager.getInstance().getInt("hud_current_mode", 0);
        String key = (hudMode == 0) ? "hud_layout_whud" : "hud_layout_ar";
        String jsonStr = ConfigManager.getInstance().getString(key, null);
        
        if (jsonStr == null || jsonStr.isEmpty()) {
            DebugLogger.d(TAG, LOG_PREFIX + "loadHudLayoutFromDisk: No saved layout found for key=" + key);
            return;
        }
        
        try {
            org.json.JSONArray jsonArray = new org.json.JSONArray(jsonStr);
            java.util.List<ClusterHudManager.HudComponentData> components = new java.util.ArrayList<>();
            boolean isSnowMode = ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
            int color = isSnowMode ? 0xFF00FFFF : 0xFFFFFFFF;
            
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject obj = jsonArray.getJSONObject(i);
                String type = obj.optString("type", "text");
                String text = obj.optString("text", "Text");
                
                // Coordinates:
                // Legacy Editor: Saved as large pixels? Legacy Manager * 0.5f.
                // New Editor (Api30): We want 1:1.
                // Compatibility: If user uses OLD config, it might be large.
                // If we assume saved data is "Source Pixels", and Legacy screen was 2x Source?
                // Legacy: Screen 800x480 (Physical?). Preview 1400?
                // If we are strictly 1:1, we should take the pixels As-Is or use the same logic as Layout editing?
                // MainActivity (Api30 branch) uses 1.0f scale.
                // So here we also use 1.0f.
                
                float x = (float) obj.optDouble("x", 0);
                float y = (float) obj.optDouble("y", 0);
                float scale = (float) obj.optDouble("scale", 1.0f);
                
                ClusterHudManager.HudComponentData data = new ClusterHudManager.HudComponentData(type, text, x, y, color);
                data.scale = scale;
                components.add(data);
            }
            
            if (!components.isEmpty()) {
                mCachedHudComponents = components; // Initialize cache
                DebugLogger.i(TAG, LOG_PREFIX + "loadHudLayoutFromDisk: Loaded " + components.size() + " components");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, LOG_PREFIX + "Failed to parse layout JSON", e);
        }
    }
    
    private void initCarService() {
        // Use shared CarServiceManager to avoid multiple instances
        CarServiceManager.getInstance(mContext).registerListener(() -> {
            mCar = CarServiceManager.getInstance(mContext).getCar();
            if (mCar != null) {
                mCarFunction = CarServiceManager.getInstance(mContext).getCarFunction();
                if (mCarFunction != null) {
                    registerFunctions();
                }
            }
        });
        CarServiceManager.getInstance(mContext).init();
    }
    
    private void registerFunctions() {
        if (mCarFunction == null) return;
        mFunctionListener = new ECarFunctionListener();
        try {
            // Register Turn Signals
            mCarFunction.registerFunctionValueWatcher(FUNC_LEFT_TRUN_SIGNAL, mFunctionListener);
            mCarFunction.registerFunctionValueWatcher(FUNC_RIGHT_TRUN_SIGNAL, mFunctionListener);
            // Register Auto Hold
            mCarFunction.registerFunctionValueWatcher(FUNC_AUTOHOLD_STATUS, mFunctionListener);
            DebugLogger.i(TAG, LOG_PREFIX + "Functions Registered (Turn Signals + AutoHold)");
        } catch (Exception e) {
            DebugLogger.e(TAG, LOG_PREFIX + "Error registering functions", e);
        }

    }

    private void registerDisplayListener() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        if (dm != null) {
            dm.registerDisplayListener(new DisplayManager.DisplayListener() {
                @Override
                public void onDisplayAdded(int displayId) {
                    DebugLogger.i(TAG, LOG_PREFIX + "onDisplayAdded: " + displayId);
                    // Check if this is one of our target displays
                    if (isTargetDisplay(displayId)) {
                        mHandler.post(ClusterHudManagerApi30.this::showPresentations);
                    }
                }

                @Override
                public void onDisplayRemoved(int displayId) {
                    DebugLogger.i(TAG, LOG_PREFIX + "onDisplayRemoved: " + displayId);
                     // If a used display is removed, the Presentation dismisses itself automatically usually.
                     // But we can clean up refs.
                     if (mHudPresentation != null && mHudPresentation.getDisplay().getDisplayId() == displayId) {
                         mHudPresentation = null;
                     }
                     if (mClusterPresentation != null && mClusterPresentation.getDisplay().getDisplayId() == displayId) {
                         mClusterPresentation = null;
                     }
                }

                @Override
                public void onDisplayChanged(int displayId) {
                    // Optional: handle orientation changes etc.
                }
            }, mHandler);
        }
    }

    private boolean isTargetDisplay(int displayId) {
        if (mIsEmulatorMode) {
            return displayId == DISPLAY_ID_HUD_EMULATOR || displayId == DISPLAY_ID_CLUSTER_EMULATOR;
        } else {
            return displayId == DISPLAY_ID_HUD_REAL || displayId == DISPLAY_ID_CLUSTER_REAL;
        }
    }

    // --- Core Display Logic ---

    public void ensureUiVisible() {
        DebugLogger.i(TAG, LOG_PREFIX + "ensureUiVisible called");
        mHandler.post(this::showPresentations);
    }

    private void showPresentations() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        if (dm == null) return;

        int hudId = mIsEmulatorMode ? DISPLAY_ID_HUD_EMULATOR : DISPLAY_ID_HUD_REAL;
        int clusterId = mIsEmulatorMode ? DISPLAY_ID_CLUSTER_EMULATOR : DISPLAY_ID_CLUSTER_REAL;
        
        DebugLogger.i(TAG, LOG_PREFIX + "Attempting to show Presentations on IDs - HUD: " + hudId + ", Cluster: " + clusterId);

        // 1. Setup HUD Presentation
        if (mHudPresentation == null || !mHudPresentation.isShowing()) {
            Display hudDisplay = dm.getDisplay(hudId);
            if (hudDisplay != null) {
                createHudPresentation(hudDisplay);
            } else {
                DebugLogger.w(TAG, LOG_PREFIX + "HUD Display " + hudId + " not found!");
            }
        }

        // 2. Setup Cluster Presentation
        if (mClusterPresentation == null || !mClusterPresentation.isShowing()) {
            Display clusterDisplay = dm.getDisplay(clusterId);
            if (clusterDisplay != null) {
                createClusterPresentation(clusterDisplay);
            } else {
                DebugLogger.w(TAG, LOG_PREFIX + "Cluster Display " + clusterId + " not found!");
            }
        }
    }

    private void createHudPresentation(Display display) {
        try {
            Context displayContext = mContext.createDisplayContext(display);
            mHudPresentation = new PresentationManagerApi30(displayContext, display);
            mHudPresentation.show();
            mHudPresentation.setHudVisible(true);
            mHudPresentation.setClusterVisible(false);
            
            if (mCachedHudComponents != null) {
                mHudPresentation.syncHudLayout(mCachedHudComponents);
            }
            DebugLogger.i(TAG, LOG_PREFIX + "HUD Presentation Created & Shown on Display " + display.getDisplayId());
        } catch (Exception e) {
            DebugLogger.e(TAG, LOG_PREFIX + "Failed to create HUD Presentation", e);
        }
    }

    private void createClusterPresentation(Display display) {
        try {
            Context displayContext = mContext.createDisplayContext(display);
            mClusterPresentation = new PresentationManagerApi30(displayContext, display);
            mClusterPresentation.show();
            mClusterPresentation.setClusterVisible(true);
            mClusterPresentation.setHudVisible(false);
            
            // [API30] Apply Cached Theme immediately
            DebugLogger.i(TAG, LOG_PREFIX + "Applying Initial Theme: " + mCurrentTheme);
            mClusterPresentation.setClusterTheme(mCurrentTheme);

            if (mCachedClusterComponents != null) {
                mClusterPresentation.syncClusterLayout(mCachedClusterComponents);
            }
            DebugLogger.i(TAG, LOG_PREFIX + "Cluster Presentation Created & Shown on Display " + display.getDisplayId());
        } catch (Exception e) {
            DebugLogger.e(TAG, LOG_PREFIX + "Failed to create Cluster Presentation", e);
        }
    }
    
    public void dismissAndRecreate() {
        DebugLogger.i(TAG, LOG_PREFIX + "dismissAndRecreate toggled. Emulator Mode: " + mIsEmulatorMode);
        
        if (mHudPresentation != null) {
            mHudPresentation.dismiss();
            mHudPresentation = null;
        }
        if (mClusterPresentation != null) {
            mClusterPresentation.dismiss();
            mClusterPresentation = null;
        }
        
        ensureUiVisible();
    }
    
    public void setEmulatorMode(boolean enabled) {
        if (mIsEmulatorMode != enabled) {
            mIsEmulatorMode = enabled;
            ConfigManager.getInstance().setBoolean("config_emulator_mode_enabled", enabled);
            // [FIX] User Request: Switch only controls ID logic. Do not auto-recreate.
            // Just dismiss current (wrong ID) presentations.
            // New one will be created on "Engine Start" (onNaviStatusUpdate).
            enterStandbyMode();
        }
    }
    
    public boolean isEmulatorMode() {
        return mIsEmulatorMode;
    }

    public void enterStandbyMode() {
        DebugLogger.i(TAG, LOG_PREFIX + "Enter Standby Mode (Dismissing Presentations)");
        if (mHudPresentation != null) {
            mHudPresentation.dismiss();
            mHudPresentation = null;
        }
        if (mClusterPresentation != null) {
            mClusterPresentation.dismiss();
            mClusterPresentation = null;
        }
    }

    public void destroy() {
        enterStandbyMode();
        instance = null;
    }

    // --- Data Dispatch ---

    public void updateSpeed(int speedKmh) {
        if (mHudPresentation != null) mHudPresentation.updateSpeed(speedKmh);
        if (mClusterPresentation != null) mClusterPresentation.updateSpeed(speedKmh);
    }

    public void updateGear(int gear) {
        if (mHudPresentation != null) mHudPresentation.updateGear(gear);
        if (mClusterPresentation != null) mClusterPresentation.updateGear(gear);
    }

    public void onTrafficLightUpdate(NaviInfoController.TrafficLightInfo info) {
        if (mHudPresentation != null) mHudPresentation.updateTrafficLight(info);
        if (mClusterPresentation != null) mClusterPresentation.updateTrafficLight(info);
    }

    public void onGuideInfoUpdate(NaviInfoController.GuideInfo info) {
        if (mHudPresentation != null) mHudPresentation.updateGuideInfo(info);
        if (mClusterPresentation != null) mClusterPresentation.updateGuideInfo(info);
    }
    
    public void onNaviStatusUpdate(int state) {
        // [FIX] Match Legacy Logic: 1=Navi, 8=Emulator, 9=StartGuide -> Navigating
        boolean navigating = (state == 1 || state == 2 || state == 8 || state == 9);
        
        // Ensure UI is created if "Engine Start" (9) or other active state is triggered
        // This satisfies user request to "Trigger by Engine Start"
        if (state == 9) {
            // [FIX] User Request: 3-second delay for Engine Start (State 9) to simulate real car
            DebugLogger.i(TAG, LOG_PREFIX + "Engine Start (9) detected. Scheduling UI creation in 3s...");
            mHandler.postDelayed(this::ensureUiVisible, 3000);
        } else if (state == 1 || state == 8) {
            // Immediate for normal navigation or emulator mode updates
            ensureUiVisible();
        }

        if (mHudPresentation != null) mHudPresentation.setNavigating(navigating);
        if (mClusterPresentation != null) mClusterPresentation.setNavigating(navigating);
    }

    // --- Layout Sync ---

    public void syncHudLayout(List<ClusterHudManager.HudComponentData> components) {
        mCachedHudComponents = components;
        if (mHudPresentation != null) {
            mHudPresentation.syncHudLayout(components);
        }
    }

    public void syncClusterLayout(List<ClusterHudManager.HudComponentData> components) {
        mCachedClusterComponents = components;
        if (mClusterPresentation != null) {
            mClusterPresentation.syncClusterLayout(components);
        }
    }
    
    public void setAmapForeground(boolean isForeground) {
        mIsAmapForeground = isForeground;
        DebugLogger.d(TAG, LOG_PREFIX + "setAmapForeground: " + isForeground);
    }

    public void applyNaviMode(int mode) {
        // [API30] Stub: Android 11 currently relies on auto-layout.
        // This method exists to satisfy the KeepAliveAccessibilityService call.
        DebugLogger.d(TAG, LOG_PREFIX + "applyNaviMode: " + mode + " (No-op in Api30 for now)");
    }
    
    // --- Legacy Compatibility Methods ---
    
    public void updateComponent(String type, String text, android.graphics.Bitmap image) {
         if (mHudPresentation != null) mHudPresentation.updateComponent(type, text, image);
         if (mClusterPresentation != null) mClusterPresentation.updateComponent(type, text, image);
    }
    
    public void updateDayNightMode(boolean isDay) {
        if (mHudPresentation != null) mHudPresentation.updateDayNightMode(isDay);
        if (mClusterPresentation != null) mClusterPresentation.updateDayNightMode(isDay);
    }
    
    public void updateContext(Context context) {
         mContext = context.getApplicationContext();
    }
    
    // --- Turn Signal Logic ---
    
    public void updateTurnSignal(boolean isLeft, boolean isOn) {
        mMainHandler.post(() -> {
            boolean wasOff = (!mLeftTurnOn && !mRightTurnOn);

            if (isLeft)
                mLeftTurnOn = isOn;
            else
                mRightTurnOn = isOn;

            boolean isNowOff = (!mLeftTurnOn && !mRightTurnOn);

            if (isOn) {
                if (wasOff) {
                    mBlinkVisible = true;
                    mBlinkHandler.removeCallbacks(mBlinkRunnable);
                    mBlinkHandler.postDelayed(mBlinkRunnable, BLINK_INTERVAL);
                }
            } else {
                if (isNowOff) {
                    mBlinkVisible = false;
                    mBlinkHandler.removeCallbacks(mBlinkRunnable);
                }
            }
            // Immediate update
            dispatchTurnSignalUpdate();
        });
    }
    
    private void dispatchTurnSignalUpdate() {
        boolean leftVisible = mLeftTurnOn && mBlinkVisible;
        boolean rightVisible = mRightTurnOn && mBlinkVisible;
        
        if (mHudPresentation != null) mHudPresentation.updateTurnSignal(leftVisible, rightVisible);
        if (mClusterPresentation != null) mClusterPresentation.updateTurnSignal(leftVisible, rightVisible);
    }

    public void setHudGreenBg(boolean enabled) {
        mMainHandler.post(() -> {
            if (mHudPresentation != null) {
                mHudPresentation.setHudGreenBg(enabled);
            }
        });
    }
    
    // --- Inner Listener Class ---
    
    private class ECarFunctionListener implements ICarFunction.IFunctionValueWatcher {
        @Override
        public void onFunctionValueChanged(int funcId, int zone, int value) {
            boolean isOn = (value == 1);
            DebugLogger.d(TAG, LOG_PREFIX + "onFunctionValueChanged: funcId=" + funcId + ", val=" + value);

            if (funcId == FUNC_LEFT_TRUN_SIGNAL) {
                updateTurnSignal(true, isOn);
            } else if (funcId == FUNC_RIGHT_TRUN_SIGNAL) {
                updateTurnSignal(false, isOn);
            } else if (funcId == FUNC_AUTOHOLD_STATUS) {
                boolean isAutoHoldOn = (value == 1);
                // Dispatch AutoHold update to generic component "auto_hold" if managed by Presentation
                // PresentationManager typically handles this via updateComponent or dedicated method.
                // For now, we replicate simplified logic or ensure updateComponent passes it.
                // Legacy Manager calls: updateComponentImage("auto_hold", bitmap);
                // Api30 should do same but we need the bitmap logic. 
                // Simplification for specific request instructions: Focus on Structure.
                // We'll leave AutoHold strictly to generic updateComponent for now or implementing if critical.
                // Assuming "auto_hold" component exists and is image-based.
                // We don't have getAutoHoldBitmap here yet. 
                // Ideally we import the resource logic.
            }
        }

        @Override public void onCustomizeFunctionValueChanged(int i, int i1, float v) {}
        @Override public void onFunctionChanged(int i) {}
        @Override public void onSupportedFunctionValueChanged(int i, int[] ints) {}
        @Override public void onSupportedFunctionStatusChanged(int i, int i1, FunctionStatus fs) {}
    }
    
    public android.graphics.Bitmap addCenterLineOverlay(android.graphics.Bitmap original) {
        if (original == null) return null;
        try {
            android.graphics.Bitmap mutable = original.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            android.graphics.Canvas canvas = new android.graphics.Canvas(mutable);
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setColor(android.graphics.Color.CYAN);
            paint.setStrokeWidth(2f);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setPathEffect(new android.graphics.DashPathEffect(new float[]{10, 10}, 0));
            canvas.drawLine(mutable.getWidth() / 2f, 0, mutable.getWidth() / 2f, mutable.getHeight(), paint);
            return mutable;
        } catch (Exception e) {
            return original;
        }
    }
}
