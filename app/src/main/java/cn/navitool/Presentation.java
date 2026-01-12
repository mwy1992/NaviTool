package cn.navitool;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.hardware.display.DisplayManager;
import android.widget.TextView;
import cn.navitool.managers.CustomThemeManager;
import cn.navitool.view.TrafficLightView;

public class Presentation extends android.app.Dialog {
    private static final String TAG = "Presentation";
    private View mLayoutCluster;
    private View mLayoutHud;
    private AudiRsThemeController mThemeController;
    private View mAudiRsLayout;
    private android.view.View mDefaultDashboardRoot; // Keep track of default layout
    private int mCurrentTheme = -1; // THEME_DEFAULT

    // Floating Traffic Light
    private WindowManager mFloatingWindowManager;
    private WindowManager.LayoutParams mFloatingParams;
    private View mFloatingTrafficLightContainer;
    private TextView mFloatingCountdown;
    private ImageView mFloatingArrow;
    private ImageView mFloatingLightRed, mFloatingLightYellow, mFloatingLightGreen;
    private boolean mIsFloatingEnabled = false;
    private boolean mIsPositioningMode = false;
    private float dX, dY;
    private int mFloatingRawStatus = 0; // Store status for flashing logic
    private boolean mIsFloatingFlashing = false;
    private boolean mFloatingFlashOn = true;
    private Runnable mFloatingFlashRunnable; // Flashing Logic Runnable
    private boolean mIsHudStyle = false; // false = Dashboard (AudiRS), true = HUD (Simple)
    private View mBtnFloatingStyleSwitch;
    // HUD Style Views
    private View mContainerDashboard;
    private cn.navitool.view.TrafficLightView mHudTrafficLightView;
    private cn.navitool.NaviInfoController.TrafficLightInfo mLatestTrafficLightInfo = null; // Track latest data

    public Presentation(Context context) {
        super(context, R.style.Theme_NaviTool); // Use Theme directly
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_cluster_hud);

        mLayoutCluster = findViewById(R.id.layoutCluster);
        mLayoutHud = findViewById(R.id.layoutHud);

        if (mLayoutHud != null) {
            mLayoutHud.setBackgroundColor(0xFF90EE90);
        }

        cn.navitool.managers.MemoryMonitor.logMemory("Presentation.onCreate-Start");

        // Ensure transparent background for the window itself
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(
                    new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));

            // [FIX] Z-Order Correction: Use TYPE_APPLICATION_OVERLAY
            // Since we are now a raw Dialog (not Presentation class), we can strictly
            // enforce
            // the overlay type to ensure we cover system UI elements on the secondary
            // display.
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            } else {
                getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            }

            // Critical Flags for Overlay
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                    | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                    | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        }

        // Apply initial debug state
        updateDebugMode(DebugLogger.isDebugEnabled(getContext()));

        initializeFloatingTrafficLight();

        // Log Detailed Component Memory
        if (DebugLogger.isDebugEnabled(getContext())) {
            logComponentMemoryBreakdown();
        }
    }

    // Memory Breakdown Logger
    private void logComponentMemoryBreakdown() {
        long totalEstimate = 0;

        DebugLogger.i("NaviMemory", "=== Memory Breakdown Start ===");

        // 1. Audi RS Theme
        if (mAudiRsLayout != null) {
            long size = calculateViewTreeMemory(mAudiRsLayout);
            DebugLogger.i("NaviMemory",
                    String.format("Component: AUDI_RS_THEME | Size: %.2f MB", size / 1024f / 1024f));
            totalEstimate += size;
        } else {
            DebugLogger.i("NaviMemory", "Component: AUDI_RS_THEME | Size: 0 MB (Not Loaded)");
        }

        // 2. Default Cluster
        if (mLayoutCluster != null && mLayoutCluster.getVisibility() == View.VISIBLE && mAudiRsLayout == null) {
            long size = calculateViewTreeMemory(mLayoutCluster);
            DebugLogger.i("NaviMemory",
                    String.format("Component: DEFAULT_CLUSTER | Size: %.2f MB", size / 1024f / 1024f));
            totalEstimate += size;
        }

        // 3. HUD
        if (mLayoutHud != null) {
            long size = calculateViewTreeMemory(mLayoutHud);
            DebugLogger.i("NaviMemory", String.format("Component: HUD_LAYER | Size: %.2f MB", size / 1024f / 1024f));
            totalEstimate += size;
        }

        // 4. Floating Traffic Light
        if (mFloatingTrafficLightContainer != null) {
            long size = calculateViewTreeMemory(mFloatingTrafficLightContainer);
            DebugLogger.i("NaviMemory",
                    String.format("Component: FLOATING_LIGHT | Size: %.2f MB", size / 1024f / 1024f));
            totalEstimate += size;
        }

        // 5. Logic Components (Status Only)
        // These use negligible memory (<1MB) compared to Bitmaps, so we just show their
        // status.
        java.util.Map<String, String> statuses = cn.navitool.managers.MemoryMonitor.getComponentStatuses();
        if (!statuses.isEmpty()) {
            for (java.util.Map.Entry<String, String> entry : statuses.entrySet()) {
                DebugLogger.i("NaviMemory",
                        String.format("Component: %s | Status: %s", entry.getKey(), entry.getValue()));
            }
        }

        DebugLogger.i("NaviMemory", String.format("--- Summary ---"));
        long totalNative = android.os.Debug.getNativeHeapAllocatedSize();
        long unaccounted = totalNative - totalEstimate;

        DebugLogger.i("NaviMemory", String.format("Total Known UI Bitmaps: %.2f MB", totalEstimate / 1024f / 1024f));
        DebugLogger.i("NaviMemory", String.format("Total Native Heap: %.2f MB", totalNative / 1024f / 1024f));
        DebugLogger.i("NaviMemory",
                String.format("Unaccounted (System/Logic/Other): %.2f MB", unaccounted / 1024f / 1024f));

        DebugLogger.i("NaviMemory", "=== Memory Breakdown End ===");
    }

    private long calculateViewTreeMemory(View view) {
        if (view == null)
            return 0;

        final java.util.concurrent.atomic.AtomicLong size = new java.util.concurrent.atomic.AtomicLong(0);

        // Simple recursive traversal
        traverseView(view, v -> {
            if (v instanceof ImageView) {
                android.graphics.drawable.Drawable d = ((ImageView) v).getDrawable();
                if (d instanceof android.graphics.drawable.BitmapDrawable) {
                    android.graphics.Bitmap bmp = ((android.graphics.drawable.BitmapDrawable) d).getBitmap();
                    if (bmp != null && !bmp.isRecycled()) {
                        size.addAndGet(bmp.getByteCount());
                    }
                }
            }
            // Check background also
            android.graphics.drawable.Drawable bg = v.getBackground();
            if (bg instanceof android.graphics.drawable.BitmapDrawable) {
                android.graphics.Bitmap bmp = ((android.graphics.drawable.BitmapDrawable) bg).getBitmap();
                if (bmp != null && !bmp.isRecycled()) {
                    size.addAndGet(bmp.getByteCount());
                }
            }
        });

        return size.get();
    }

    private void traverseView(View view, androidx.core.util.Consumer<View> action) {
        if (view == null)
            return;
        action.accept(view);
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup vg = (android.view.ViewGroup) view;
            for (int i = 0; i < vg.getChildCount(); i++) {
                traverseView(vg.getChildAt(i), action);
            }
        }
    }

    private void initializeFloatingTrafficLight() {
        if (mFloatingTrafficLightContainer != null)
            return;

        try {
            // Target Display ID 1 (User Request)
            DisplayManager dm = (DisplayManager) getContext().getSystemService(Context.DISPLAY_SERVICE);
            android.view.Display targetDisplay = null;
            if (dm != null) {
                targetDisplay = dm.getDisplay(1);
            }
            if (targetDisplay == null) {
                DebugLogger.w(TAG, "Display ID 1 not found, falling back to Default Display");
                targetDisplay = dm != null ? dm.getDisplay(android.view.Display.DEFAULT_DISPLAY) : null;
            }

            if (targetDisplay == null) {
                DebugLogger.e(TAG, "Target Display Not Found");
                return;
            }

            DebugLogger.i(TAG, "Initializing Floating Traffic Light on Display: " + targetDisplay.getName() + " (ID="
                    + targetDisplay.getDisplayId() + ")");

            // Create Context for Target Display
            Context targetContext = getContext().createDisplayContext(targetDisplay);
            mFloatingWindowManager = (WindowManager) targetContext.getSystemService(Context.WINDOW_SERVICE);

            android.view.LayoutInflater inflater = android.view.LayoutInflater.from(targetContext);
            mFloatingTrafficLightContainer = inflater.inflate(R.layout.layout_floating_traffic_light, null);

            // Layout Params for Application Overlay
            int type = (android.os.Build.VERSION.SDK_INT >= 26) ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                    : WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;

            mFloatingParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    type,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    android.graphics.PixelFormat.TRANSLUCENT);

            // Load saved position
            int savedX = ConfigManager.getInstance().getInt("floating_traffic_light_x", 100);
            int savedY = ConfigManager.getInstance().getInt("floating_traffic_light_y", 100);
            mFloatingParams.x = savedX;
            mFloatingParams.y = savedY;
            mFloatingParams.gravity = android.view.Gravity.TOP | android.view.Gravity.START;

            // Initial Visibility
            mFloatingTrafficLightContainer.setVisibility(View.GONE);
            mFloatingWindowManager.addView(mFloatingTrafficLightContainer, mFloatingParams);

            // Bind Views
            mFloatingCountdown = mFloatingTrafficLightContainer.findViewById(R.id.floatingCountdown);
            mFloatingArrow = mFloatingTrafficLightContainer.findViewById(R.id.floatingDirectionArrow);
            mFloatingLightRed = mFloatingTrafficLightContainer.findViewById(R.id.floatingLightRed);
            mFloatingLightYellow = mFloatingTrafficLightContainer.findViewById(R.id.floatingLightYellow);
            mFloatingLightGreen = mFloatingTrafficLightContainer.findViewById(R.id.floatingLightGreen);

            mContainerDashboard = mFloatingTrafficLightContainer.findViewById(R.id.containerDashboard);
            mContainerDashboard = mFloatingTrafficLightContainer.findViewById(R.id.containerDashboard);
            mHudTrafficLightView = mFloatingTrafficLightContainer.findViewById(R.id.hudTrafficLightView);

            mBtnFloatingStyleSwitch = mFloatingTrafficLightContainer.findViewById(R.id.btnFloatingStyleSwitch);

            // Load Style
            mIsHudStyle = ConfigManager.getInstance().getBoolean("floating_style_hud", false);
            updateFloatingTrafficLightStyle();

            // Style Switch Click
            if (mBtnFloatingStyleSwitch != null) {
                mBtnFloatingStyleSwitch.setOnClickListener(v -> {
                    mIsHudStyle = !mIsHudStyle;
                    ConfigManager.getInstance().setBoolean("floating_style_hud", mIsHudStyle);
                    updateFloatingTrafficLightStyle();
                });
            }

            // Drag Listener
            mFloatingTrafficLightContainer.setOnTouchListener(new android.view.View.OnTouchListener() {
                private float initialTouchX;
                private float initialTouchY;
                private int initialX;
                private int initialY;

                @Override
                public boolean onTouch(View view, android.view.MotionEvent event) {
                    if (!mIsPositioningMode)
                        return false;

                    switch (event.getAction()) {
                        case android.view.MotionEvent.ACTION_DOWN:
                            initialX = mFloatingParams.x;
                            initialY = mFloatingParams.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            return true;

                        case android.view.MotionEvent.ACTION_MOVE:
                            mFloatingParams.x = initialX + (int) (event.getRawX() - initialTouchX);
                            mFloatingParams.y = initialY + (int) (event.getRawY() - initialTouchY);
                            // Ensure update
                            mFloatingWindowManager.updateViewLayout(mFloatingTrafficLightContainer, mFloatingParams);
                            return true;

                        case android.view.MotionEvent.ACTION_UP:
                            // Save Position
                            ConfigManager.getInstance().setInt("floating_traffic_light_x", mFloatingParams.x);
                            ConfigManager.getInstance().setInt("floating_traffic_light_y", mFloatingParams.y);
                            return true;
                    }
                    return false;
                }
            });

        } catch (Exception e) {
            DebugLogger.e(TAG, "Error initializing Floating Traffic Light on Display 1", e);
        }
    }

    private void updateFloatingTrafficLightStyle() {
        if (mContainerDashboard != null) {
            mContainerDashboard.setVisibility(!mIsHudStyle ? View.VISIBLE : View.GONE);
        }
        if (mHudTrafficLightView != null) {
            mHudTrafficLightView.setVisibility(mIsHudStyle ? View.VISIBLE : View.GONE);
        }

        if (mIsPositioningMode) {
            // Positioning Preview
            if (mIsHudStyle) {
                // HUD Preview: Red style, Time 14, Straight
                if (mHudTrafficLightView != null) {
                    mHudTrafficLightView.updateState(TrafficLightView.STATUS_RED, 14, 4);
                }
            } else {
                // Dashboard Preview
                mFloatingLightRed.setImageResource(R.drawable.audi_rs_light_red);
                mFloatingLightYellow.setImageResource(R.drawable.audi_rs_light_yellow);
                mFloatingLightGreen.setImageResource(R.drawable.audi_rs_light_green);
                mFloatingLightRed.setAlpha(1.0f);
                mFloatingLightYellow.setAlpha(1.0f);
                mFloatingLightGreen.setAlpha(1.0f);
            }
        }
    }

    public void setFloatingTrafficLightEnabled(boolean enabled) {
        mIsFloatingEnabled = enabled;
        updateFloatingTrafficLightVisibility();
    }

    public void toggleFloatingTrafficLightPositioning() {
        mIsPositioningMode = !mIsPositioningMode;
        if (mIsPositioningMode) {
            initializeFloatingTrafficLight();
            if (mFloatingTrafficLightContainer != null) {
                mFloatingTrafficLightContainer.setVisibility(View.VISIBLE);
                mFloatingTrafficLightContainer.setBackgroundResource(R.drawable.bg_hud_pending); // Visible bg for
                                                                                                 // dragging

                // Show Style Switch
                if (mBtnFloatingStyleSwitch != null) {
                    mBtnFloatingStyleSwitch.setVisibility(View.VISIBLE);
                    mBtnFloatingStyleSwitch.bringToFront(); // Ensure clickable
                }

                // Force show dummy data
                if (mFloatingCountdown != null)
                    mFloatingCountdown.setText("60");

                updateFloatingTrafficLightStyle();

                DebugLogger.toast(getContext(), getContext().getString(R.string.toast_floating_position_instruction));
            }
        } else {
            if (mFloatingTrafficLightContainer != null) {
                mFloatingTrafficLightContainer.setBackgroundResource(0); // Transparent bg

                // Hide Style Switch
                if (mBtnFloatingStyleSwitch != null) {
                    mBtnFloatingStyleSwitch.setVisibility(View.GONE);
                }

                updateFloatingTrafficLightVisibility(); // Hide if no real data
                DebugLogger.toast(getContext(), getContext().getString(R.string.toast_position_saved_simple));
            }
        }
    }

    private void updateFloatingTrafficLightVisibility() {
        if (mFloatingTrafficLightContainer == null)
            return;

        // Show if Positioning Mode OR (Enabled AND Has Data)
        if (mIsPositioningMode) {
            mFloatingTrafficLightContainer.setVisibility(View.VISIBLE);
        } else {
            // Not positioning mode: Only show if enabled AND has valid data
            if (mIsFloatingEnabled && mLatestTrafficLightInfo != null) {
                mFloatingTrafficLightContainer.setVisibility(View.VISIBLE);
            } else {
                mFloatingTrafficLightContainer.setVisibility(View.GONE);
            }
        }
    }

    private void updateFloatingTrafficLightLogic(cn.navitool.NaviInfoController.TrafficLightInfo info) {
        if (!mIsPositioningMode) {
            mLatestTrafficLightInfo = info; // Only update tracking if not positioning (or always? Let's say always so
                                            // we know state on exit)
        }
        // Actually always update it so we have state when exiting positioning
        mLatestTrafficLightInfo = info;

        if (mFloatingTrafficLightContainer == null)
            initializeFloatingTrafficLight();
        if (mFloatingTrafficLightContainer == null)
            return;

        if (!mIsFloatingEnabled && !mIsPositioningMode) {
            mFloatingTrafficLightContainer.setVisibility(View.GONE);
            return;
        }

        if (info == null && !mIsPositioningMode) {
            mFloatingTrafficLightContainer.setVisibility(View.GONE);
            return;
        }

        if (mIsPositioningMode && info == null)
            return; // Keep dummy data

        mFloatingTrafficLightContainer.setVisibility(View.VISIBLE);
        mFloatingTrafficLightContainer.setBackgroundResource(mIsPositioningMode ? R.drawable.bg_hud_pending : 0);

        // Ensure correct visibility of containers
        if (mContainerDashboard != null)
            mContainerDashboard.setVisibility(!mIsHudStyle ? View.VISIBLE : View.GONE);
        if (mHudTrafficLightView != null)
            mHudTrafficLightView.setVisibility(mIsHudStyle ? View.VISIBLE : View.GONE);

        int mappedStatus = NaviInfoController.mapStatus(info.status);
        int time = info.redCountdown;

        if (mIsHudStyle) {
            // HUD Style Update using Custom View
            if (mHudTrafficLightView != null) {
                // Pass direction as is, assuming TrafficLightView handles mapping
                mHudTrafficLightView.updateState(mappedStatus, time, info.direction);
            }
            return; // End HUD Update
        }

        // Dashboard Style Update (Existing Logic)
        if (mFloatingCountdown != null) {
            if (time > 0) {
                mFloatingCountdown.setText(String.valueOf(time));
                mFloatingCountdown.setVisibility(View.VISIBLE);

                // Color
                int color = 0xFFFFFFFF;
                if (mappedStatus == TrafficLightView.STATUS_RED)
                    color = 0xFFFF0000;
                else if (mappedStatus == TrafficLightView.STATUS_YELLOW)
                    color = 0xFFFFFF00;
                else if (mappedStatus == TrafficLightView.STATUS_GREEN)
                    color = 0xFF00FF00;
                mFloatingCountdown.setTextColor(color);
                if (mFloatingArrow != null)
                    mFloatingArrow.setColorFilter(color);

            } else {
                mFloatingCountdown.setVisibility(View.GONE);
            }
        }

        // Images (Dim/Bright based on mappedStatus)
        updateFloatingLightImages(mappedStatus, 1.0f);

        // Arrow Rotation
        if (mFloatingArrow != null) {
            float rotation = 0;
            switch (info.direction) {
                case 1:
                    rotation = 0f; // Left
                    break;
                case 2:
                    rotation = 180f; // Right
                    break;
                case 3:
                    rotation = -45f; // Left Front
                    break;
                case 4:
                    rotation = 90f; // Straight (Up)
                    break;
                case 5:
                    rotation = 45f; // Right Front
                    break;
                case 6:
                    rotation = -90f; // Back
                    break;
                default:
                    rotation = 90f; // Default to Straight (Up)
                    break;
            }
            mFloatingArrow.setRotation(rotation);
        }
    }

    private void updateFloatingLightImages(int mappedStatus, float alpha) {
        final float ALPHA_DIM = 0.3f;
        if (mFloatingLightRed != null)
            mFloatingLightRed.setAlpha(mappedStatus == TrafficLightView.STATUS_RED ? alpha : ALPHA_DIM);
        if (mFloatingLightYellow != null)
            mFloatingLightYellow.setAlpha(mappedStatus == TrafficLightView.STATUS_YELLOW ? alpha : ALPHA_DIM);
        if (mFloatingLightGreen != null)
            mFloatingLightGreen.setAlpha(mappedStatus == TrafficLightView.STATUS_GREEN ? alpha : ALPHA_DIM);
    }

    public void setClusterVisible(boolean visible) {
        if (mLayoutCluster != null) {
            mLayoutCluster.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        }
    }

    public void setHudVisible(boolean visible) {
        if (mLayoutHud != null) {
            mLayoutHud.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        }
    }

    public void updateDebugMode(boolean isDebug) {
        // [DEBUG] User Request: Light Green Background to wrap content
        if (mLayoutHud != null) {
            // [配置] HUD 背景颜色
            // 调试时可改为 0xFF90EE90 (浅绿色) 以观察边界
            // Default: Transparent (全透明)
            mLayoutHud.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            mLayoutHud.setVisibility(View.VISIBLE); // Force visible for debug
        }

        // Log Detailed Component Memory
        if (isDebug) {
            logComponentMemoryBreakdown();
        }
    }

    /**
     * 设置仪表盘主题
     * 
     * @param theme THEME_DEFAULT 或 THEME_AUDI_RS
     */
    public void setClusterTheme(int theme) {
        // 不再检查主题是否相同，始终执行切换逻辑
        // 这样确保从任何状态都能正确切换
        mCurrentTheme = theme;
        DebugLogger.d("ClusterHudPresentation", "setClusterTheme: " + theme);

        long memBefore = android.os.Debug.getNativeHeapAllocatedSize();
        cn.navitool.managers.MemoryMonitor.logMemory("Before Theme Switch: " + theme);

        try {
            if (theme == THEME_AUDI_RS) {
                // 初始化奥迪RS主题
                DebugLogger.d("ClusterHudPresentation",
                        "[AUDI] mAudiRsLayout is " + (mAudiRsLayout == null ? "NULL" : "NOT NULL"));
                DebugLogger.d("ClusterHudPresentation", "[AUDI] mLayoutCluster is "
                        + (mLayoutCluster == null ? "NULL" : mLayoutCluster.getClass().getSimpleName()));

                if (mAudiRsLayout == null && mLayoutCluster != null) {
                    try {
                        android.view.LayoutInflater inflater = android.view.LayoutInflater.from(getContext());
                        mAudiRsLayout = inflater.inflate(R.layout.layout_cluster_audi_rs, null);
                        DebugLogger.d("ClusterHudPresentation", "[AUDI] Inflated mAudiRsLayout: " + mAudiRsLayout);
                    } catch (Exception e) {
                        DebugLogger.e("ClusterHudPresentation", "[AUDI] FATAL: Failed to inflate layout", e);
                        // Fallback to default if inflation fails
                        enableClusterDashboard();
                        return;
                    }
                }

                // Ensure added to parent (fix for switching back from default which clears
                // views)
                if (mAudiRsLayout != null && mLayoutCluster instanceof android.view.ViewGroup) {
                    android.view.ViewGroup container = (android.view.ViewGroup) mLayoutCluster;
                    if (mAudiRsLayout.getParent() == null) {
                        container.addView(mAudiRsLayout,
                                new android.view.ViewGroup.LayoutParams(
                                        android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                                        android.view.ViewGroup.LayoutParams.MATCH_PARENT));
                        DebugLogger.d("ClusterHudPresentation", "[AUDI] Added mAudiRsLayout to container");
                    }
                }

                if (mThemeController == null) {
                    mThemeController = new AudiRsThemeController();
                    DebugLogger.d("ClusterHudPresentation", "[AUDI] Created new AudiRsThemeController");
                }

                if (mAudiRsLayout != null) {
                    // 使用 View.post() 确保布局完全渲染后再绑定视图
                    mAudiRsLayout.post(() -> {
                        try {
                            if (mThemeController != null && mAudiRsLayout != null) {
                                ((AudiRsThemeController) mThemeController).bindViews(mAudiRsLayout);

                                // [DEBUG] Inject Debug RPM View - Commented out
                                /*
                                 * TextView debugText = findViewById(R.id.debugRpmText);
                                 * if (debugText != null) {
                                 * ((AudiRsThemeController) mThemeController).setDebugRpmView(debugText);
                                 * }
                                 */

                                mAudiRsLayout.setVisibility(View.VISIBLE);
                                DebugLogger.d("ClusterHudPresentation", "[AUDI-POST] Set mAudiRsLayout VISIBLE");

                                // 隐藏默认元素
                                hideDefaultClusterElements();
                            }
                        } catch (Exception e) {
                            DebugLogger.e("ClusterHudPresentation", "[AUDI-POST] Error binding views", e);
                        }
                    });
                }
            } else {
                // 切回默认主题
                if (mAudiRsLayout != null) {
                    mAudiRsLayout.setVisibility(View.GONE);
                }
                if (mThemeController != null) {
                    mThemeController.release();
                }
                // 重新加载默认仪表布局
                // 重新加载默认仪表布局
                enableClusterDashboard();
                DebugLogger.d("ClusterHudPresentation", "Switched to default theme, enableClusterDashboard called");
            }
        } catch (Exception e) {
            DebugLogger.e("ClusterHudPresentation", "Error setting cluster theme: " + theme, e);
        }

        long memAfter = android.os.Debug.getNativeHeapAllocatedSize();
        long delta = (memAfter - memBefore) / 1024
                / 1024;
        cn.navitool.managers.MemoryMonitor.logMemory("After Theme Switch: " + theme + " (Delta: " + delta + "MB)");

        // Detailed breakdown
        logComponentMemoryBreakdown();

    }

    private void hideDefaultClusterElements() {
        if (mDefaultDashboardRoot != null) {
            mDefaultDashboardRoot.setVisibility(View.GONE);
        }
        if (mClusterSpeedPointer != null)
            mClusterSpeedPointer.setVisibility(View.GONE);
        if (mClusterRpmPointer != null)
            mClusterRpmPointer.setVisibility(View.GONE);
    }

    private void showDefaultClusterElements() {
        if (mDefaultDashboardRoot != null) {
            mDefaultDashboardRoot.setVisibility(View.VISIBLE);
        }
        if (mClusterSpeedPointer != null)
            mClusterSpeedPointer.setVisibility(View.VISIBLE);
        if (mClusterRpmPointer != null)
            mClusterRpmPointer.setVisibility(View.VISIBLE);
    }

    public int getCurrentTheme() {
        return mCurrentTheme;
    }

    /**
     * 更新日夜模式
     */
    public void updateDayNightMode(boolean isDay) {
        if (mThemeController != null) {
            mThemeController.setDayMode(isDay);
        }
    }

    public void updateTrafficLight(cn.navitool.NaviInfoController.TrafficLightInfo info) {
        // Update Floating Light first
        updateFloatingTrafficLightLogic(info);

        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateTrafficLight(info);
        }

        // Generic Component Update
        updateTrafficLightGeneric(mRealHudComponents, info);
        updateTrafficLightGeneric(mRealClusterComponents, info);
    }

    public void updateGuideInfo(cn.navitool.NaviInfoController.GuideInfo info) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateGuideInfo(info);
        }

        // Generic Component Update
        updateGuideInfoGeneric(mRealHudComponents, info);
        updateGuideInfoGeneric(mRealClusterComponents, info);
    }

    // [FIX] New method to propagate navigation state to AudiRsThemeController
    public void setNavigating(boolean isNavigating) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).setNavigating(isNavigating);
        }
    }

    // Helper for Generic Traffic Light Update
    private void updateTrafficLightGeneric(java.util.List<View> viewList,
            cn.navitool.NaviInfoController.TrafficLightInfo info) {
        if (info == null)
            return;
        for (View v : viewList) {
            Object tag = v.getTag();
            String viewType = null;
            if (tag instanceof ClusterHudManager.HudComponentData) {
                viewType = ((ClusterHudManager.HudComponentData) tag).type;
            } else if (tag instanceof String) {
                viewType = (String) tag;
            }

            if ("traffic_light".equals(viewType) && v instanceof cn.navitool.view.TrafficLightView) {
                cn.navitool.view.TrafficLightView tlv = (cn.navitool.view.TrafficLightView) v;

                // [FIX] Use shared status mapping from NaviInfoController
                int mappedStatus = cn.navitool.NaviInfoController.mapStatus(info.status);

                // Determine time - always use redCountdown (same as NaviInfoController)
                int time = info.redCountdown;

                // Only show if we have a valid status
                if (mappedStatus == 0) {
                    v.setVisibility(View.INVISIBLE);
                } else {
                    v.setVisibility(View.VISIBLE);
                    tlv.updateState(mappedStatus, time, info.direction);
                }
            }
        }
    }

    // Helper for Generic Guide Info Update
    private void updateGuideInfoGeneric(java.util.List<View> viewList, cn.navitool.NaviInfoController.GuideInfo info) {
        if (info == null)
            return;
        for (View v : viewList) {
            Object tag = v.getTag();
            String viewType = null;
            if (tag instanceof ClusterHudManager.HudComponentData) {
                viewType = ((ClusterHudManager.HudComponentData) tag).type;
            } else if (tag instanceof String) {
                viewType = (String) tag;
            }

            if ("navi_arrival_time".equals(viewType) && v instanceof android.widget.TextView) {
                // Parse ETA using NaviInfoController logic
                String etaText = info.etaText;
                String displayText = cn.navitool.NaviInfoController.parseEta(etaText);
                ((android.widget.TextView) v).setText(displayText);
                // [FIX] Visibility management
                v.setVisibility(displayText.isEmpty() ? View.GONE : View.VISIBLE);

            } else if ("navi_distance_remaining".equals(viewType) && v instanceof android.widget.TextView) {
                // Use NaviInfoController formatting
                int dist = info.routeRemainDis;
                String text = cn.navitool.NaviInfoController.formatDistance(dist);
                ((android.widget.TextView) v).setText(text);
                // [FIX] Visibility management
                v.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);
            }
        }
    }

    public void resetTrafficLights() {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).resetTrafficLights();
        }
        // [FIX] Reset generic HUD traffic lights
        resetTrafficLightsGeneric(mRealHudComponents);
        resetTrafficLightsGeneric(mRealClusterComponents);

        // Reset Floating Light
        if (mFloatingTrafficLightContainer != null && !mIsPositioningMode) {
            mFloatingTrafficLightContainer.setVisibility(View.GONE);
        }
    }

    private void resetTrafficLightsGeneric(java.util.List<View> viewList) {
        for (View v : viewList) {
            Object tag = v.getTag();
            String viewType = null;
            if (tag instanceof ClusterHudManager.HudComponentData) {
                viewType = ((ClusterHudManager.HudComponentData) tag).type;
            } else if (tag instanceof String) {
                viewType = (String) tag;
            }

            if ("traffic_light".equals(viewType)) {
                v.setVisibility(View.INVISIBLE);
            }
        }
    }

    // [FIX] Reset navigation info (distance/ETA) when navigation ends
    // [FIX] Reset navigation info (distance/ETA) when navigation ends
    public void resetNaviInfo() {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).resetNaviInfo();
        }
        // [FIX] Reset generic HUD navi info
        resetNaviInfoGeneric(mRealHudComponents);
        resetNaviInfoGeneric(mRealClusterComponents);
    }

    private void resetNaviInfoGeneric(java.util.List<View> viewList) {
        for (View v : viewList) {
            Object tag = v.getTag();
            String viewType = null;
            if (tag instanceof ClusterHudManager.HudComponentData) {
                viewType = ((ClusterHudManager.HudComponentData) tag).type;
            } else if (tag instanceof String) {
                viewType = (String) tag;
            }

            if ("navi_arrival_time".equals(viewType) || "navi_distance_remaining".equals(viewType)) {
                v.setVisibility(View.GONE); // Hide completely if no navi
                if (v instanceof TextView) {
                    ((TextView) v).setText("");
                }
            }
        }
    }

    private java.util.List<View> mRealHudComponents = new java.util.concurrent.CopyOnWriteArrayList<>();
    private java.util.List<View> mRealClusterComponents = new java.util.concurrent.CopyOnWriteArrayList<>();

    // Theme Support
    // Theme Support
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_AUDI_RS = 1;
    // Duplicates removed (mCurrentTheme, mAudiRsController, mAudiRsLayout)

    public void syncHudLayout(java.util.List<ClusterHudManager.HudComponentData> components) {
        syncLayoutGeneric(mLayoutHud, mRealHudComponents, components, 728, 190);
    }

    public void syncClusterLayout(java.util.List<ClusterHudManager.HudComponentData> components) {
        syncLayoutGeneric(mLayoutCluster, mRealClusterComponents, components, 1920, 720);
    }

    private void syncLayoutGeneric(View layoutView, java.util.List<View> viewList,
            java.util.List<ClusterHudManager.HudComponentData> components,
            int maxWidth, int maxHeight) {
        if (layoutView instanceof android.widget.FrameLayout) {
            android.widget.FrameLayout container = (android.widget.FrameLayout) layoutView;

            // Clear existing
            // Clear all views to ensure clean state (especially when switching from
            // Dashboard XML)
            container.removeAllViews();
            viewList.clear();

            // Add new
            for (ClusterHudManager.HudComponentData data : components) {
                View view;
                boolean isSong = "song".equals(data.type) || "test_media".equals(data.type)
                        || "song_1line".equals(data.type);
                boolean isTurnSignal = "turn_signal".equals(data.type);
                boolean isVolume = "volume".equals(data.type);
                boolean isMediaCover = "media_cover".equals(data.type) || "test_media_cover".equals(data.type);
                int measuredWidth = 0;
                int measuredHeight = 0;

                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);

                if (isSong) {
                    android.widget.LinearLayout ll = new android.widget.LinearLayout(getContext());
                    ll.setOrientation(android.widget.LinearLayout.VERTICAL);
                    ll.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    // Ensure padding/margins are minimal
                    ll.setPadding(0, 0, 0, 0);

                    String text = data.text != null ? data.text : "";
                    // Split Title/Artist by newline
                    String[] parts = text.split("\n");
                    String title = parts.length > 0 ? parts[0] : "";
                    String artist = parts.length > 1 ? parts[1] : "";

                    // Title View
                    android.widget.TextView tvTitle = new android.widget.TextView(getContext());
                    tvTitle.setText(title);
                    tvTitle.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 22);
                    tvTitle.setTextColor(data.color);
                    tvTitle.setSingleLine(true);
                    tvTitle.setMaxLines(1);
                    tvTitle.setEllipsize(android.text.TextUtils.TruncateAt.END); // 使用...省略，不滚动
                    tvTitle.setIncludeFontPadding(false);
                    tvTitle.setPadding(0, 0, 0, 0);
                    tvTitle.setLineSpacing(0, 1f);
                    ll.addView(tvTitle);

                    // Artist View (Only if exists)
                    if (!artist.isEmpty()) {
                        android.widget.TextView tvArtist = new android.widget.TextView(getContext());
                        tvArtist.setText(artist);
                        tvArtist.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 22);
                        tvArtist.setTextColor(data.color);
                        tvArtist.setSingleLine(true);
                        tvArtist.setMaxLines(1);
                        tvArtist.setEllipsize(android.text.TextUtils.TruncateAt.END); // 使用...省略，不滚动
                        tvArtist.setIncludeFontPadding(false);
                        tvArtist.setPadding(0, 0, 0, 0);
                        tvArtist.setLineSpacing(0, 1f);
                        ll.addView(tvArtist);
                    }

                    params.width = 300;
                    view = ll;
                } else if (isMediaCover || isTurnSignal || isVolume) {
                    android.widget.ImageView iv = new android.widget.ImageView(getContext());
                    if (data.image != null) {
                        iv.setImageBitmap(data.image);
                        iv.clearColorFilter(); // Ensure no tint on real image
                    } else {
                        // Placeholder or transparent
                        if (isMediaCover) {
                            iv.setImageResource(android.R.drawable.ic_media_play); // Fallback
                            iv.setColorFilter(data.color); // Apply color to icon if needed
                        } else if (isVolume) {
                            iv.setImageResource(R.drawable.ic_volume); // Fallback
                            iv.setColorFilter(data.color);
                        }
                    }
                    iv.setBackgroundColor(android.graphics.Color.TRANSPARENT);

                    // 将dp转为px的辅助计算
                    float density = getContext().getResources().getDisplayMetrics().density;

                    if (isMediaCover) {
                        // 媒体封面: 100px (预览中为200px, 保持1:2比例)
                        params.width = 100;
                        params.height = 100;
                    } else {
                        // 转向灯 & 音量: 36px (预览中为72px, 保持1:2比例)
                        if (isTurnSignal || isVolume) {
                            params.height = 36;
                        } else {
                            params.height = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;
                        }
                        params.width = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;

                        iv.setAdjustViewBounds(true);
                        iv.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                    }
                    view = iv;
                } else if ("time".equals(data.type)) {
                    android.widget.TextClock tc = new android.widget.TextClock(getContext());
                    tc.setFormat12Hour(data.text);
                    tc.setFormat24Hour(data.text);
                    tc.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tc.setTextColor(data.color);
                    tc.setPadding(0, 0, 0, 0);
                    tc.setIncludeFontPadding(false); // Minimized vertical spacing
                    tc.setLineSpacing(0, 1f); // Remove line spacing
                    tc.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
                    if (data.typeface != null) {
                        tc.setTypeface(data.typeface);
                    }
                    view = tc;
                } else if ("gauge".equals(data.type)) {
                    android.widget.ImageView iv = new android.widget.ImageView(getContext());
                    if (data.image != null) {
                        iv.setImageBitmap(data.image);
                        iv.clearColorFilter();
                    }
                    iv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    iv.setScaleType(android.widget.ImageView.ScaleType.FIT_XY); // Allow stretching or exact fit

                    // Apply Pivot if config exists
                    if (data.gaugeConfig != null && data.gaugeConfig.length >= 6) {
                        // Config: [min, max, start, end, px, py]
                        float px = data.gaugeConfig[4];
                        float py = data.gaugeConfig[5];
                        iv.setPivotX(0); // Will be set after layout? No, setPivotX is absolute or relative?
                        // View.setPivotX takes pixels. We need width to know pixels.
                        // So we must do it after measurement or use a helper that sets it on layout.
                        // Actually, we can just store the relative PIVOT and apply it in update
                        // rotation?
                        // Or wait for layout.
                        // Let's store config in Tag and handle pivot in update or layout.
                        // iv.setTag(data.gaugeConfig); // REMOVED: Use generic data tag
                    }

                    // Mark as gauge for update loop
                    // We need to know if it's SPEED or RPM gauge.
                    // The 'id' field isn't in HudComponentData?
                    // User JSON has "id": "speed_gauge".
                    // I need to map "type"="gauge" + something?
                    // Ah, HudComponentData needs 'id' or 'subtype'?
                    // Or I use 'text' field as identifier if type is gauge?
                    // User JSON: "type": "gauge", "id": "speed_gauge".
                    // I'll assume 'text' field holds the ID for gauge, or add 'id' field.
                    // 'text' is String, effectively ID.
                    // So if type="gauge", text="speed_gauge" (or "speed").

                    // Let's rely on type="gauge" and check text/id to determine data source.
                    // But wait, updateSpeed calls with float speed.
                    // It needs to find views that WANT speed.
                    // So I'll check: if (type == gauge && text == "speed") -> respond to speed.

                    view = iv;
                    // Set explicit size from bitmap to ensure proper positioning
                    if (data.image != null) {
                        params.width = data.image.getWidth();
                        params.height = data.image.getHeight();
                    }
                } else if ("path_gauge".equals(data.type) && data.pathData != null) {
                    PathGaugeView pgv = new PathGaugeView(getContext());
                    // Parse Path String (Using standard SVG path format)
                    try {
                        pgv.setPath(androidx.core.graphics.PathParser.createPathFromPathData(data.pathData));
                    } catch (Exception e) {
                        try {
                            // Fallback for older API or manual parsing if needed.
                            // But PathParser is standard in AndroidX. Assuming AndroidX is available.
                            // If build fails, we might need a simple parser or use vector drawable parsing.
                            // For now, let's assume valid path string.
                            android.graphics.Path p = parsePathSimple(data.pathData);
                            if (p != null)
                                pgv.setPath(p);
                            else
                                DebugLogger.e("ClusterHud", "Manual parsing failed for: " + data.pathData);
                        } catch (Exception ex) {
                            DebugLogger.e("ClusterHud", "All parsing failed", ex);
                        }
                    }
                    pgv.setColor(data.color);
                    if (data.gaugeConfig != null && data.gaugeConfig.length > 0) {
                        pgv.setStrokeWidth(data.gaugeConfig[0]);
                    }
                    pgv.setMaxValue(data.maxValue > 0 ? data.maxValue : 100);

                    pgv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    view = pgv;
                    // Use explicit dimensions from gaugeConfig if available [strokeWidth,
                    // viewWidth, viewHeight, ...]
                    if (data.gaugeConfig != null && data.gaugeConfig.length >= 3 && data.gaugeConfig[1] > 0
                            && data.gaugeConfig[2] > 0) {
                        int viewW = (int) data.gaugeConfig[1];
                        int viewH = (int) data.gaugeConfig[2];
                        params.width = viewW;
                        params.height = viewH;
                    } else {
                        // Fallback to wrap_content
                        params.width = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;
                        params.height = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;
                    }
                } else if ("debug_status".equals(data.type)) {
                    android.widget.TextView tv = new android.widget.TextView(getContext());
                    tv.setText(data.text);
                    tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 32);
                    tv.setTextColor(data.color);
                    view = tv;
                    // Tag it so we can find it
                    // view.setTag("debug_status_view"); // REMOVED: Use generic data tag
                } else if ("traffic_light".equals(data.type)) {
                    // Traffic Light Component
                    cn.navitool.view.TrafficLightView tlv = new cn.navitool.view.TrafficLightView(getContext());
                    // [FIX] Use WRAP_CONTENT to let TrafficLightView calculate its own size
                    params.width = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
                    params.height = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

                    // Mark tag so it can be updated
                    // We'll trust the generic tag assignment below
                    view = tlv;
                } else if ("navi_arrival_time".equals(data.type) || "navi_distance_remaining".equals(data.type)) {
                    // Navi Info Components - Start GONE until actual navigation data arrives
                    android.widget.TextView tv = new android.widget.TextView(getContext());
                    // [FIX] Only show in preview, hide in real HUD until navigation starts
                    // Preview: text comes from config, Real HUD: starts empty
                    tv.setText(""); // Start empty in real HUD
                    tv.setVisibility(View.GONE); // Hide until navigation provides data
                    tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tv.setTextColor(data.color);
                    // [FIX] Alignment Settings for Navigation Components
                    tv.setPadding(0, 0, 0, 0);
                    tv.setIncludeFontPadding(false);
                    tv.setLineSpacing(0, 1f);
                    // [FIX] Normal weight, 24px size to match other text

                    tv.setTypeface(android.graphics.Typeface.DEFAULT);
                    tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
                    view = tv;
                } else if ("fuel_range".equals(data.type) || "fuel".equals(data.type)) {
                    // [Refactor] Fuel & Fuel Range Structural Split (LinearLayout)
                    // Create horizontal container
                    android.widget.LinearLayout containerLayout = new android.widget.LinearLayout(getContext());
                    containerLayout.setOrientation(android.widget.LinearLayout.HORIZONTAL);
                    containerLayout.setGravity(android.view.Gravity.CENTER_VERTICAL);

                    // 1. Emoji View "⛽" (Hardcoded Size 18px)
                    android.widget.TextView tvEmoji = new android.widget.TextView(getContext());
                    tvEmoji.setText("⛽");
                    tvEmoji.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 18f); // 18px
                    tvEmoji.setTextColor(data.color);
                    tvEmoji.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tvEmoji.setPadding(0, 0, 4, 0); // Right padding 4px
                    tvEmoji.setIncludeFontPadding(false);

                    // 2. Value View (Standard Size 24px)
                    android.widget.TextView tvValue = new android.widget.TextView(getContext());
                    // Extract value, e.g. "⛽ 32L|280km" -> "32L|280km"
                    String valText = data.text != null ? data.text.replace("⛽", "").trim() : "";
                    tvValue.setText(valText);
                    tvValue.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24f);
                    tvValue.setTextColor(data.color);
                    tvValue.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tvValue.setIncludeFontPadding(false);

                    containerLayout.addView(tvEmoji);
                    containerLayout.addView(tvValue);

                    view = containerLayout;
                    params.width = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;
                    params.height = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;

                } else if ("temp_out".equals(data.type) || "temp_in".equals(data.type)) {
                    // Temperature Components - Right-aligned to keep °C position stable
                    android.widget.TextView tv = new android.widget.TextView(getContext());
                    tv.setText(data.text);
                    tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tv.setPadding(0, 0, 0, 0);
                    tv.setIncludeFontPadding(false);
                    tv.setLineSpacing(0, 1f);
                    tv.setTextColor(data.color);
                    tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);

                    // [Issue 10 Final Fix] Fixed Width 150px + Gravity.END to prevent jitter
                    tv.setGravity(android.view.Gravity.END);
                    params.width = 90; // Fixed width to allow right alignment stability

                    if (data.typeface != null) {
                        tv.setTypeface(data.typeface);
                    }

                    // Dynamic Margin REMOVED - Rely on setY tolerance
                    // int margin = (int) (-24f * 0.2f);
                    view = tv;
                } else {
                    android.widget.TextView tv = new android.widget.TextView(getContext());
                    tv.setText(data.text);
                    tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tv.setPadding(0, 0, 0, 0);
                    tv.setIncludeFontPadding(false); // Minimized vertical spacing
                    tv.setLineSpacing(0, 1f); // Remove line spacing
                    tv.setTextColor(data.color);
                    if (data.typeface != null) {
                        tv.setTypeface(data.typeface);
                    }

                    // Rule 2: Font size logic - gear uses 48px, others use 24px
                    // Preview: gear=96px, others=48px -> HUD: gear=48px, others=24px
                    // Rule 2: Font size logic - Gear Special Case
                    if ("gear".equals(data.type)) {
                        float gearSize = 36f; // [Issue 4] 48 -> 36
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, gearSize);
                        tv.setGravity(android.view.Gravity.CENTER);
                        params.width = 80; // Fixed width

                        // [Issue 10] Dynamic Percentage Negative Margin (-20%) - REMOVED
                        // int margin = (int) (-gearSize * 0.2f);

                    } else {
                        // Generic Text (Speed, etc.)
                        float textSize = 24f;
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, textSize);

                        // [Issue 10] Dynamic Percentage Negative Margin (-20%) - REMOVED
                        // int margin = (int) (-textSize * 0.2f);

                    }

                    // Rule 3: Song Component Layout (Handled by LinearLayout block above)
                    view = tv;
                }

                view.setTag(data); // CRITICAL: Tag with Data for updateSpeed loop!
                params.gravity = android.view.Gravity.TOP | android.view.Gravity.START;
                container.addView(view, params);

                // 应用组件缩放 - 设置缩放中心点为左上角 (与预览一致)
                view.setPivotX(0);
                view.setPivotY(0);
                view.setScaleX(data.scale);
                view.setScaleY(data.scale);

                // Measure
                int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

                if (isSong) {
                    widthSpec = View.MeasureSpec.makeMeasureSpec(300, View.MeasureSpec.EXACTLY);
                } else if (isMediaCover) {
                    widthSpec = View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY);
                    heightSpec = View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY);
                } else if (isTurnSignal) {
                    heightSpec = View.MeasureSpec.makeMeasureSpec(36, View.MeasureSpec.EXACTLY);
                } else if (isVolume) {
                    heightSpec = View.MeasureSpec.makeMeasureSpec(36, View.MeasureSpec.EXACTLY);
                } else if ("gauge".equals(data.type) && data.image != null) {
                    // Gauges use intrinsic image size
                    widthSpec = View.MeasureSpec.makeMeasureSpec(data.image.getWidth(), View.MeasureSpec.EXACTLY);
                    heightSpec = View.MeasureSpec.makeMeasureSpec(data.image.getHeight(), View.MeasureSpec.EXACTLY);
                }

                view.measure(widthSpec, heightSpec);
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();

                // Bounds Clamp, using dynamic maxWidth/maxHeight - 使用缩放后的尺寸
                float scaledWidth = measuredWidth * data.scale;
                float scaledHeight = measuredHeight * data.scale;

                // [FIX] Allow overshoot for TextViews to match Preview logic (Visual Margin
                // Compensation)
                float tolerance = 0f;
                if (view instanceof android.widget.TextView) {
                    float currentSize = ((android.widget.TextView) view).getTextSize();
                    tolerance = currentSize * 0.2f * data.scale;
                } else if (view instanceof android.widget.LinearLayout
                        && ((android.widget.LinearLayout) view).getChildCount() > 0) {
                    // [FIX] Handle Song Component (LinearLayout with TextViews)
                    android.view.View child = ((android.widget.LinearLayout) view).getChildAt(0);
                    if (child instanceof android.widget.TextView) {
                        float currentSize = ((android.widget.TextView) child).getTextSize();
                        tolerance = currentSize * 0.2f * data.scale;
                    }
                }

                float clampedX = Math.max(0, Math.min(data.x, maxWidth - scaledWidth));
                // Allow Y to go slightly negative or beyond bottom to hide padding
                float clampedY = Math.max(-tolerance, Math.min(data.y, maxHeight - scaledHeight + tolerance));

                view.setX(clampedX);
                view.setY(clampedY);

                // Tag the view for dynamic visibility AND gauge config
                // Note: view.setTag(data) already done above, but we may need to update pivot
                if ("gauge".equals(data.type)) {
                    // Calculate Pivot now that we have measured dim
                    if (data.gaugeConfig != null && data.gaugeConfig.length >= 6) {
                        float px = data.gaugeConfig[4]; // 0.0 - 1.0
                        float py = data.gaugeConfig[5];
                        view.setPivotX(measuredWidth * px);
                        view.setPivotY(measuredHeight * py);
                    }
                }
                // REMOVED: Tag override that was breaking path_gauge updates
                // view.setTag(data) is already set at line 297

                // Update boolean flags for visibility check
                isSong = "song".equals(data.type) || "test_media".equals(data.type) || "song_1line".equals(data.type);
                isMediaCover = "media_cover".equals(data.type) || "test_media_cover".equals(data.type);

                // Apply Media/Volume Visibility Rule immediately
                if (isSong || isMediaCover) {
                    view.setVisibility(mIsMediaPlaying ? View.VISIBLE : View.GONE);
                } else if ("volume".equals(data.type)) {
                    view.setVisibility(mIsVolumeVisible ? View.VISIBLE : View.GONE);
                } else {
                    view.setVisibility(View.VISIBLE);
                }

                viewList.add(view);
            }
        }
    }

    private boolean mIsMediaPlaying = false;
    private boolean mIsVolumeVisible = false;

    public void setMediaPlaying(boolean isPlaying) {
        if (mIsMediaPlaying == isPlaying)
            return;
        mIsMediaPlaying = isPlaying;

        // Update existing views (HUD)
        updateVisibilityGeneric(mRealHudComponents, isPlaying, "media");
        // Update existing views (Cluster)
        updateVisibilityGeneric(mRealClusterComponents, isPlaying, "media");
    }

    public void setVolumeVisible(boolean isVisible) {
        if (mIsVolumeVisible == isVisible)
            return;
        mIsVolumeVisible = isVisible;

        // Update existing views (HUD)
        updateVisibilityGeneric(mRealHudComponents, isVisible, "volume");
        // Update existing views (Cluster)
        updateVisibilityGeneric(mRealClusterComponents, isVisible, "volume");
    }

    // Helper to update visibility based on Tag Groups
    private void updateVisibilityGeneric(java.util.List<View> viewList, boolean visible, String group) {
        for (View v : viewList) {
            Object tag = v.getTag();
            // [FIX] Tag can be HudComponentData or String
            String viewType = null;
            if (tag instanceof ClusterHudManager.HudComponentData) {
                viewType = ((ClusterHudManager.HudComponentData) tag).type;
            } else if (tag instanceof String) {
                viewType = (String) tag;
            }

            if (viewType != null) {
                if ("media".equals(group)) {
                    if (viewType.equals("song") || viewType.equals("media_cover") || viewType.equals("test_media")
                            || viewType.equals("test_media_cover") || viewType.equals("song_1line")) {
                        v.setVisibility(visible ? View.VISIBLE : View.GONE);
                    }
                } else if ("volume".equals(group)) {
                    if ("volume".equals(viewType)) {
                        v.setVisibility(visible ? View.VISIBLE : View.GONE);
                    }
                }
            }
        }
    }

    public void updateComponent(String type, String text, android.graphics.Bitmap image) {
        // Update HUD
        updateComponentGeneric(mRealHudComponents, type, text, image);
        // Update Cluster
        updateComponentGeneric(mRealClusterComponents, type, text, image);
    }

    private void updateComponentGeneric(java.util.List<View> viewList, String type, String text,
            android.graphics.Bitmap image) {
        for (View v : viewList) {
            Object tag = v.getTag();
            // [FIX] Tag can be HudComponentData or String, handle both
            String viewType = null;
            if (tag instanceof ClusterHudManager.HudComponentData) {
                viewType = ((ClusterHudManager.HudComponentData) tag).type;
            } else if (tag instanceof String) {
                viewType = (String) tag;
            }

            if (viewType != null && viewType.equals(type)) {
                if (v instanceof android.widget.TextView && text != null) {
                    android.widget.TextView tv = (android.widget.TextView) v;
                    // [FIX] Clear text first and invalidate to prevent overlap artifacts
                    tv.setText("");
                    tv.setText(text);
                    tv.invalidate();
                } else if (v instanceof android.widget.LinearLayout && text != null) {
                    android.widget.LinearLayout ll = (android.widget.LinearLayout) v;

                    // [Refactor] Handle Fuel & Fuel Range Update
                    if ("fuel_range".equals(viewType) || "fuel".equals(viewType)) {
                        if (ll.getChildCount() > 1 && ll.getChildAt(1) instanceof android.widget.TextView) {
                            // Update Value Text Only (remove emoji from input text if present)
                            String cleanText = text.replace("⛽", "").trim();
                            ((android.widget.TextView) ll.getChildAt(1)).setText(cleanText);
                        }
                    } else {
                        // Song Logic
                        String[] parts = (text != null ? text : "").split("\n");
                        String title = parts.length > 0 ? parts[0] : "";
                        String artist = parts.length > 1 ? parts[1] : "";

                        // Update Title
                        if (ll.getChildCount() > 0 && ll.getChildAt(0) instanceof android.widget.TextView) {
                            ((android.widget.TextView) ll.getChildAt(0)).setText(title);
                        }

                        // Update Artist
                        if (!artist.isEmpty()) {
                            if (ll.getChildCount() > 1) {
                                ((android.widget.TextView) ll.getChildAt(1)).setText(artist);
                                ll.getChildAt(1).setVisibility(android.view.View.VISIBLE);
                            } else {
                                // Add text view
                                android.widget.TextView tvArtist = new android.widget.TextView(v.getContext());
                                tvArtist.setText(artist);
                                tvArtist.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
                                // Reuse color from Title
                                if (ll.getChildCount() > 0) {
                                    tvArtist.setTextColor(
                                            ((android.widget.TextView) ll.getChildAt(0)).getTextColors());
                                } else {
                                    tvArtist.setTextColor(android.graphics.Color.WHITE);
                                }
                                tvArtist.setSingleLine(true);
                                tvArtist.setMaxLines(1);
                                tvArtist.setEllipsize(android.text.TextUtils.TruncateAt.END); // 使用...省略
                                tvArtist.setIncludeFontPadding(false);
                                ll.addView(tvArtist);
                            }
                        } else {
                            if (ll.getChildCount() > 1) {
                                ll.getChildAt(1).setVisibility(android.view.View.GONE);
                            }
                        }
                    }
                } else if (v instanceof android.widget.ImageView && image != null) {
                    ((android.widget.ImageView) v).setImageBitmap(image);
                    ((android.widget.ImageView) v).clearColorFilter();
                }
            }
        }
    }

    public void clearHudComponents() {
        if (mLayoutHud instanceof android.widget.FrameLayout) {
            android.widget.FrameLayout container = (android.widget.FrameLayout) mLayoutHud;
            for (View v : mRealHudComponents) {
                container.removeView(v);
            }
            mRealHudComponents.clear();
        }

        if (mLayoutCluster instanceof android.widget.FrameLayout) {
            android.widget.FrameLayout container = (android.widget.FrameLayout) mLayoutCluster;
            for (View v : mRealClusterComponents) {
                container.removeView(v);
            }
            mRealClusterComponents.clear();
        }
    }

    // --- Cluster Dashboard Mode ---
    // --- Cluster Dashboard Mode ---
    private View mClusterSpeedPointer;
    private View mClusterRpmPointer;

    // mDefaultDashboardRoot removed (duplicate)

    public void enableClusterDashboard() {
        if (mLayoutCluster instanceof android.view.ViewGroup) {
            android.view.ViewGroup container = (android.view.ViewGroup) mLayoutCluster;
            container.removeAllViews();
            mRealClusterComponents.clear(); // Clear tracked components

            // Capture root view for visibility toggling
            mDefaultDashboardRoot = android.view.LayoutInflater.from(getContext())
                    .inflate(R.layout.layout_cluster_dashboard, container, false);
            container.addView(mDefaultDashboardRoot);

            // Find Components inside the root
            mClusterSpeedPointer = mDefaultDashboardRoot.findViewById(R.id.ivClusterSpeedPointer);
            mClusterRpmPointer = mDefaultDashboardRoot.findViewById(R.id.ivClusterRpmPointer);
        }
    }

    public void updateSpeed(int speed) {
        // 如果是奥迪RS主题，使用专用控制器
        if (mCurrentTheme == THEME_AUDI_RS && mThemeController != null) {
            mThemeController.updateSpeed(speed);
            return;
        }

        if (mClusterSpeedPointer != null) {
            // Speed 0 -> 0 km/h (Bottom/South) = 180 degrees.
            // Speed 230 -> 230 km/h max = 180 + 270 = 450 (90) degrees.
            // Formula: 180 + (speed / 230) * 270
            // Direction: Clockwise (Positive addition).
            float angle = 180 + (speed / 230f) * 270f;
            mClusterSpeedPointer.setRotation(angle);
        }

        // Dynamic Gauge Update
        DebugLogger.e("ClusterHudPresentation",
                "updateSpeed(" + speed + ") - mRealClusterComponents.size=" + mRealClusterComponents.size());
        if (!mRealClusterComponents.isEmpty()) {
            for (View v : mRealClusterComponents) {
                Object tag = v.getTag();
                DebugLogger.d("ClusterHudPresentation", "  View: " + v.getClass().getSimpleName() + ", Tag: "
                        + (tag != null ? tag.getClass().getSimpleName() : "null"));
                if (tag instanceof ClusterHudManager.HudComponentData) {
                    ClusterHudManager.HudComponentData data = (ClusterHudManager.HudComponentData) tag;
                    if ("gauge".equals(data.type) && "speed".equals(data.text)) { // text field used as ID
                        if (data.gaugeConfig != null && data.gaugeConfig.length >= 4) {
                            // [min, max, start, end]
                            float min = data.gaugeConfig[0];
                            float max = data.gaugeConfig[1];
                            float start = data.gaugeConfig[2];
                            float end = data.gaugeConfig[3];

                            // Calculate Factor
                            // Range = max - min
                            // Sweep = end - start
                            // Ratio = (val - min) / Range
                            // Angle = start + Ratio * Sweep

                            if (max > min) {
                                float ratio = (speed - min) / (max - min);
                                float angle = start + (ratio * (end - start));
                                v.setRotation(angle);
                            }
                        }
                    } else if ("speed".equals(data.type)) {
                        // Also update Text Speed if type matches (text/speed)
                        if (v instanceof android.widget.TextView) {
                            ((android.widget.TextView) v).setText(String.valueOf(speed));
                        }
                    } else if ("path_gauge".equals(data.type) && "speed".equals(data.text)) {
                        if (v instanceof PathGaugeView) {
                            DebugLogger.e("ClusterHudPresentation",
                                    "    -> Found SPEED PathGaugeView, setting progress=" + speed);
                            ((PathGaugeView) v).setProgress(speed);
                        }
                    } else if ("debug_status_view".equals(data) || "debug_status".equals(data.type)
                            || "debug_status_view".equals(tag)) {
                        // Fallback tag check
                        if (v instanceof android.widget.TextView) {
                            ((android.widget.TextView) v).setText("Speed: " + speed);
                        }
                    } else {
                        // Check strict tag
                        if ("debug_status_view".equals(tag) && v instanceof android.widget.TextView) {
                            ((android.widget.TextView) v).setText("Speed: " + speed);
                        }
                    }
                }
            }
        }
    }

    public void updateRpm(float rpm) {
        // 如果是奥迪RS主题，使用专用控制器
        if (mCurrentTheme == THEME_AUDI_RS && mThemeController != null) {
            mThemeController.updateRpm((int) rpm);
            return;
        }

        if (mClusterRpmPointer != null) {
            // RPM 0 -> Left (West) = 270 degrees.
            // RPM 8000 -> Bottom (South) = 180 + 360 = 540 degrees.
            // Range: 270 degrees Clockwise (Left -> Top -> Right -> Bottom).
            // Factor: 270 / 8000 = 0.03375
            mClusterRpmPointer.setRotation(270 + (rpm * 0.03375f));
        }
    }

    public void cycleGear() {
        if (mCurrentTheme == THEME_AUDI_RS && mThemeController != null) {
            mThemeController.cycleGear();
        }
    }

    public void setDayMode(boolean isDay) {
        if (mThemeController != null) {
            mThemeController.setDayMode(isDay);
        }
    }

    public void updateAudiRsSpeed(int speed) {
        if (mCurrentTheme == THEME_AUDI_RS && mThemeController != null) {
            mThemeController.updateSpeed(speed);
        }
    }

    public void updateGear(int gearValue) {
        // Update Audi RS theme gear (Native Int)
        if (mCurrentTheme == THEME_AUDI_RS && mThemeController != null) {
            mThemeController.setGear(gearValue);
        }

        // Standard HUD/Cluster Update
        String gearStr = convertGearValueToString(gearValue);
        updateGear(gearStr);
    }

    public void updateGear(String gearStr) {
        if (gearStr != null) {
            updateComponentGeneric(mRealHudComponents, "gear", gearStr, null);

            // Also update generic cluster text if present
            updateComponentGeneric(mRealClusterComponents, "gear", gearStr, null);
        }
    }

    public void updateTurnSignal(boolean isLeft, boolean isOn) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateTurnSignal(isLeft, isOn);
        }
    }

    public void updateTirePressure(int index, float pressure) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateTirePressure(index, pressure);
        }
    }

    public void updateTireTemp(int index, float temp) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateTireTemp(index, temp);
        }
    }

    /**
     * Convert raw gear int value to display string (P, R, N, D)
     */
    private String convertGearValueToString(int gearValue) {
        // Gear constants from SoundPromptManager
        final int GEAR_PARK = 2097712;
        final int GEAR_REVERSE = 2097728;
        final int GEAR_NEUTRAL = 2097680;
        final int GEAR_DRIVE = 2097696;
        final int TRSM_GEAR_PARK = 15;
        final int TRSM_GEAR_DRIVE = 13;
        final int TRSM_GEAR_NEUT = 14;
        final int TRSM_GEAR_RVS = 11;

        if (gearValue == GEAR_DRIVE || gearValue == TRSM_GEAR_DRIVE) {
            return "D";
        } else if (gearValue == GEAR_REVERSE || gearValue == TRSM_GEAR_RVS) {
            return "R";
        } else if (gearValue == GEAR_NEUTRAL || gearValue == TRSM_GEAR_NEUT) {
            return "N";
        } else if (gearValue == GEAR_PARK || gearValue == TRSM_GEAR_PARK) {
            return "P";
        }
        return null;
    }

    // --- Path Gauge View ---
    private static class PathGaugeView extends android.view.View {
        private android.graphics.Path mPath;
        private android.graphics.Paint mPaint;
        private android.graphics.PathMeasure mPathMeasure;
        private float mLength;
        private float mMaxValue = 100;
        private float mCurrentValue = 0;

        public PathGaugeView(Context context) {
            super(context);
            init();
        }

        private void init() {
            mPaint = new android.graphics.Paint();
            mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            mPaint.setStrokeWidth(30); // Default, matches Style 2 width
            mPaint.setStrokeCap(android.graphics.Paint.Cap.BUTT);
            mPaint.setAntiAlias(true);
        }

        public void setPath(android.graphics.Path path) {
            mPath = path;
            mPathMeasure = new android.graphics.PathMeasure(mPath, false);
            mLength = mPathMeasure.getLength();
            invalidate();
        }

        public void setColor(int color) {
            mPaint.setColor(color);
            invalidate();
        }

        public void setStrokeWidth(float width) {
            mPaint.setStrokeWidth(width);
            // Request layout because bounds depend on stroke width
            requestLayout();
            invalidate();
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int w = 300;
            int h = 150;
            if (mPath != null) {
                android.graphics.RectF bounds = new android.graphics.RectF();
                mPath.computeBounds(bounds, true);
                float stroke = mPaint.getStrokeWidth();
                w = (int) (bounds.right + stroke);
                h = (int) (bounds.bottom + stroke);
                // Ensure valid dimensions
                if (w < 1)
                    w = 300;
                if (h < 1)
                    h = 150;
            }
            setMeasuredDimension(resolveSize(w, widthMeasureSpec), resolveSize(h, heightMeasureSpec));
        }

        public void setMaxValue(float max) {
            mMaxValue = max;
        }

        public void setProgress(float value) {
            mCurrentValue = value;
            if (mCurrentValue < 0)
                mCurrentValue = 0;
            if (mCurrentValue > mMaxValue)
                mCurrentValue = mMaxValue;
            invalidate();
        }

        @Override
        protected void onDraw(android.graphics.Canvas canvas) {
            super.onDraw(canvas);

            // Debug: Draw a red border to verify View visibility/bounds
            // Enable this if users report "nothing visible"
            // mPaint.setColor(android.graphics.Color.RED);
            // canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
            // mPaint.setColor(mColor); // Restore

            if (mPath == null || mLength <= 0) {
                // Try to draw a fallback line text if logic fails?
                return;
            }

            float ratio = mCurrentValue / mMaxValue;

            // Always draw at least a tiny bit if ratio > 0, or handle 0
            if (ratio <= 0.01f) {
                // ratio = 0.01f; // Debug: Force small visibility?
                return;
            }

            // Draw Partial Path
            // We use DashPathEffect to simulate drawing only a portion
            // Actually, PathMeasure.getSegment is better.
            android.graphics.Path dst = new android.graphics.Path();
            // Start from 0 to length * ratio
            mPathMeasure.getSegment(0, mLength * ratio, dst, true);
            canvas.drawPath(dst, mPaint);
        }

    }

    // Manual Path Parser for simple "M x,y L x,y" commands
    private android.graphics.Path parsePathSimple(String d) {
        if (d == null || d.isEmpty())
            return null;
        try {
            android.graphics.Path path = new android.graphics.Path();
            String[] parts = d.split("(?=[ML])"); // Split by 'M' or 'L' but keep delimiter? No, split by space/comma is
                                                  // better
            // d = "M 14.7,120.7 L 122.9,12.5 L 276,12.5"
            // Normalize
            String clean = d.replace(",", " ");
            String[] tokens = clean.trim().split("\\s+");

            int i = 0;
            try {
                while (i < tokens.length) {
                    String cmd = tokens[i];
                    if ("M".equalsIgnoreCase(cmd)) {
                        if (i + 2 >= tokens.length)
                            break;
                        float x = Float.parseFloat(tokens[i + 1]);
                        float y = Float.parseFloat(tokens[i + 2]);
                        path.moveTo(x, y);
                        i += 3;

                    } else if ("L".equalsIgnoreCase(cmd)) {
                        if (i + 2 >= tokens.length)
                            break;
                        float x = Float.parseFloat(tokens[i + 1]);
                        float y = Float.parseFloat(tokens[i + 2]);
                        path.lineTo(x, y);
                        i += 3;
                    } else if ("Z".equalsIgnoreCase(cmd)) {
                        path.close();
                        i += 1;
                    } else {
                        // Forward compatibility: skip 1 token
                        i++;
                    }
                }
            } catch (Exception e) {
                DebugLogger.e(TAG, "Path parse error for: " + d, e);
            }
            return path;
        } catch (Exception e) {
            DebugLogger.e("ClusterHud", "Manual Parser Exception", e);
            return null;
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (mFloatingWindowManager != null && mFloatingTrafficLightContainer != null) {
            try {
                mFloatingWindowManager.removeView(mFloatingTrafficLightContainer);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error removing Floating Traffic Light", e);
            }
            mFloatingTrafficLightContainer = null;
        }
    }
}
