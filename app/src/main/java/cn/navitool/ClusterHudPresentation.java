package cn.navitool;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

public class ClusterHudPresentation extends Presentation {
    private static final String TAG = "ClusterHudPresentation";
    private View mLayoutCluster;
    private View mLayoutHud;

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
        if (mLayoutHud != null) {
            if (isDebug) {
                // Light Green #3300FF00
                mLayoutHud.setBackgroundColor(0x3300FF00);
            } else {
                mLayoutHud.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            }
        }
    }

    private java.util.List<View> mRealHudComponents = new java.util.ArrayList<>();
    private java.util.List<View> mRealClusterComponents = new java.util.ArrayList<>();

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
                    tvTitle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                    tvTitle.setMarqueeRepeatLimit(-1);
                    tvTitle.setSelected(true); // Trigger Marquee
                    tvTitle.setIncludeFontPadding(false);
                    ll.addView(tvTitle);

                    // Artist View (Only if exists)
                    if (!artist.isEmpty()) {
                        android.widget.TextView tvArtist = new android.widget.TextView(getContext());
                        tvArtist.setText(artist);
                        tvArtist.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
                        tvArtist.setTextColor(data.color);
                        tvArtist.setSingleLine(true);
                        tvArtist.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                        tvArtist.setMarqueeRepeatLimit(-1);
                        tvArtist.setSelected(true); // Trigger Marquee
                        tvArtist.setIncludeFontPadding(false);
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

                    if (isMediaCover) {
                        // Fixed size for cover
                        params.width = 100;
                        params.height = 100;
                    } else {
                        // Turn Signal & Volume: Explicitly constrain height to prevent upscaling
                        // User Request: Real HUD size should be ~1/4 of Media Cover (100px), i.e.,
                        // ~25px.
                        if (isTurnSignal) {
                            params.height = 36; // User Request: 36px
                        } else if (isVolume) {
                            params.height = 36; // User Request: 36px
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
                    tc.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24); // User Request: 24px
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
                    tv.setTextColor(data.color);
                    if (data.typeface != null) {
                        tv.setTypeface(data.typeface);
                    }

                    // Rule 2: Font size logic
                    if ("gear".equals(data.type)) {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 48); // User Request: 48px (2x Standard)
                    } else if ("speed".equals(data.type)) {
                        // Also larger for speed text?
                        if (data.text != null && data.text.length() < 5) // Simple heuristic
                            tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 48);
                        else
                            tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
                    } else {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24); // User Request: 24px
                    }

                    // Rule 3: Song Component Layout (Handled by LinearLayout block above)
                    view = tv;
                }

                view.setTag(data); // CRITICAL: Tag with Data for updateSpeed loop!
                params.gravity = android.view.Gravity.TOP | android.view.Gravity.START;
                container.addView(view, params);

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

                // Bounds Clamp, using dynamic maxWidth/maxHeight
                float clampedX = Math.max(0, Math.min(data.x, maxWidth - measuredWidth));
                float clampedY = Math.max(0, Math.min(data.y, maxHeight - measuredHeight));

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
            if (tag != null) {
                if ("media".equals(group)) {
                    if (tag.equals("song") || tag.equals("media_cover") || tag.equals("test_media")
                            || tag.equals("test_media_cover")) {
                        v.setVisibility(visible ? View.VISIBLE : View.GONE);
                    }
                } else if ("volume".equals(group)) {
                    if ("volume".equals(tag)) {
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
            if (tag != null && tag.equals(type)) {
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
                            tvArtist.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                            tvArtist.setMarqueeRepeatLimit(-1);
                            tvArtist.setSelected(true);
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
    private View mClusterSpeedPointer;
    private View mClusterRpmPointer;

    public void enableClusterDashboard() {
        if (mLayoutCluster instanceof android.view.ViewGroup) {
            android.view.ViewGroup container = (android.view.ViewGroup) mLayoutCluster;
            container.removeAllViews();
            mRealClusterComponents.clear(); // Clear tracked components

            android.view.LayoutInflater.from(getContext()).inflate(R.layout.layout_cluster_dashboard, container, true);

            // Find Components
            mClusterSpeedPointer = container.findViewById(R.id.ivClusterSpeedPointer);
            mClusterRpmPointer = container.findViewById(R.id.ivClusterRpmPointer);
        }
    }

    public void updateSpeed(float speed) {
        if (mClusterSpeedPointer != null) {
            // Speed 0 -> 0 km/h (Bottom/South) = 180 degrees.
            // Speed 270 -> 270 km/h (Right/East) = 180 + 270 = 450 (90) degrees.
            // Direction: Clockwise (Positive addition).
            mClusterSpeedPointer.setRotation(180 + speed);
        }

        // Dynamic Gauge Update
        android.util.Log.e("ClusterHudPresentation",
                "updateSpeed(" + speed + ") - mRealClusterComponents.size=" + mRealClusterComponents.size());
        if (!mRealClusterComponents.isEmpty()) {
            for (View v : mRealClusterComponents) {
                Object tag = v.getTag();
                android.util.Log.d("ClusterHudPresentation", "  View: " + v.getClass().getSimpleName() + ", Tag: "
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
                            ((android.widget.TextView) v).setText(String.valueOf((int) speed));
                        }
                    } else if ("path_gauge".equals(data.type) && "speed".equals(data.text)) {
                        if (v instanceof PathGaugeView) {
                            android.util.Log.e("ClusterHudPresentation",
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
        if (mClusterRpmPointer != null) {
            // RPM 0 -> Left (West) = 270 degrees.
            // RPM 8000 -> Bottom (South) = 180 + 360 = 540 degrees.
            // Range: 270 degrees Clockwise (Left -> Top -> Right -> Bottom).
            // Factor: 270 / 8000 = 0.03375
            mClusterRpmPointer.setRotation(270 + (rpm * 0.03375f));
        }

        // Dynamic Gauge Update
        if (!mRealClusterComponents.isEmpty()) {
            for (View v : mRealClusterComponents) {
                Object tag = v.getTag();
                if (tag instanceof ClusterHudManager.HudComponentData) {
                    ClusterHudManager.HudComponentData data = (ClusterHudManager.HudComponentData) tag;
                    if ("gauge".equals(data.type) && "rpm".equals(data.text)) { // text field used as ID for RPM
                        if (data.gaugeConfig != null && data.gaugeConfig.length >= 4) {
                            float min = data.gaugeConfig[0];
                            float max = data.gaugeConfig[1];
                            float start = data.gaugeConfig[2];
                            float end = data.gaugeConfig[3];

                            if (max > min) {
                                float ratio = (rpm - min) / (max - min);
                                float angle = start + (ratio * (end - start));
                                v.setRotation(angle);
                            }
                        }
                    } else if ("rpm".equals(data.type)) {
                        if (v instanceof android.widget.TextView) {
                            ((android.widget.TextView) v).setText(String.valueOf((int) rpm));
                        }
                        if (v instanceof android.widget.TextView) {
                            ((android.widget.TextView) v).setText(String.valueOf((int) rpm));
                        }
                    } else if ("path_gauge".equals(data.type) && "rpm".equals(data.text)) {
                        if (v instanceof PathGaugeView) {
                            ((PathGaugeView) v).setProgress(rpm);
                        }
                    } else if ("path_gauge".equals(data.type) && "speed".equals(data.text)) { // Handle speed path gauge
                                                                                              // also in this loop just
                                                                                              // in case, but usually
                                                                                              // seperated
                        // logic belongs in updateSpeed, but safely ignored here.
                    }
                }
            }
        }
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
            while (i < tokens.length) {
                String cmd = tokens[i];
                if ("M".equalsIgnoreCase(cmd)) {
                    float x = Float.parseFloat(tokens[i + 1]);
                    float y = Float.parseFloat(tokens[i + 2]);
                    path.moveTo(x, y);
                    i += 3;
                } else if ("L".equalsIgnoreCase(cmd)) {
                    float x = Float.parseFloat(tokens[i + 1]);
                    float y = Float.parseFloat(tokens[i + 2]);
                    path.lineTo(x, y);
                    i += 3;
                } else {
                    // Try to parse implicit command if it's numbers? SVG repeats last cmd.
                    // But our strings are explicit.
                    i++;
                }
            }
            return path;
        } catch (Exception e) {
            DebugLogger.e("ClusterHud", "Manual Parser Exception", e);
            return null;
        }
    }
}
