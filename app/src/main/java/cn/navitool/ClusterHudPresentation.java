package cn.navitool;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.navitool.managers.CustomThemeManager;
import com.autonavi.amapauto.protocol.model.service.RspTrafficLightsCountdownInfoModel;

public class ClusterHudPresentation extends Presentation {
    private static final String TAG = "ClusterHudPresentation";
    private View mLayoutCluster;
    private View mLayoutHud;
    private AudiRsThemeController mThemeController;
    private View mAudiRsLayout;
    private android.view.View mDefaultDashboardRoot; // Keep track of default layout
    private int mCurrentTheme = -1; // THEME_DEFAULT

    public ClusterHudPresentation(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_cluster_hud);

        mLayoutCluster = findViewById(R.id.layoutCluster);
        mLayoutHud = findViewById(R.id.layoutHud);

        // Ensure transparent background for the window itself
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(
                    new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
        }

        // Apply initial debug state
        updateDebugMode(DebugLogger.isDebugEnabled(getContext()));
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
        // [REMOVED] Debug green background - always transparent now
        if (mLayoutHud != null) {
            mLayoutHud.setBackgroundColor(0x4400FF00); // Debug: Semi-transparent green
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
                enableClusterDashboard();
                DebugLogger.d("ClusterHudPresentation", "Switched to default theme, enableClusterDashboard called");
            }
        } catch (Exception e) {
            DebugLogger.e("ClusterHudPresentation", "Error setting cluster theme: " + theme, e);
        }
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

    public void updateTireData(int index, float pressure, float temp) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateTireData(index, pressure, temp);
        }
    }

    public void updateTrafficLight(RspTrafficLightsCountdownInfoModel info) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateTrafficLight(info);
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
                boolean isSong = "song".equals(data.type) || "test_media".equals(data.type);
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
                    tvTitle.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
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
                        tvArtist.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
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
                    if ("gear".equals(data.type)) {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 48);
                    } else {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
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
                float clampedX = Math.max(0, Math.min(data.x, maxWidth - scaledWidth));
                float clampedY = Math.max(0, Math.min(data.y, maxHeight - scaledHeight));

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
                isSong = "song".equals(data.type) || "test_media".equals(data.type);
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
                            || viewType.equals("test_media_cover")) {
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
                    ((android.widget.TextView) v).setText(text);
                } else if (v instanceof android.widget.LinearLayout && text != null) {
                    android.widget.LinearLayout ll = (android.widget.LinearLayout) v;
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

    public void updateGuideInfo(com.autonavi.amapauto.protocol.model.service.GuideInfoModel info) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateGuideInfo(info);
        }
    }

    public void updateGear(int gearValue) {
        // Update Audi RS theme gear
        if (mCurrentTheme == THEME_AUDI_RS && mThemeController != null) {
            mThemeController.setGear(gearValue);
        }

        // [FIX] Also update HUD gear components
        String gearStr = convertGearValueToString(gearValue);
        if (gearStr != null) {
            updateComponentGeneric(mRealHudComponents, "gear", gearStr, null);
        }
    }

    public void updateTurnSignal(boolean isLeft, boolean isOn) {
        if (mThemeController != null && mThemeController instanceof AudiRsThemeController) {
            ((AudiRsThemeController) mThemeController).updateTurnSignal(isLeft, isOn);
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
}
