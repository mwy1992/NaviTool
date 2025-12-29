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
            for (View v : viewList) {
                container.removeView(v);
            }
            viewList.clear();

            // Add new
            for (ClusterHudManager.HudComponentData data : components) {
                View view;
                boolean isSong = "song".equals(data.type);
                boolean isMediaCover = "media_cover".equals(data.type) || "test_media_cover".equals(data.type);
                int measuredWidth = 0;
                int measuredHeight = 0;

                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);

                if (isMediaCover) {
                    android.widget.ImageView iv = new android.widget.ImageView(getContext());
                    if (data.image != null) {
                        iv.setImageBitmap(data.image);
                        iv.clearColorFilter(); // Ensure no tint on real image
                    } else {
                        // Placeholder or transparent
                        iv.setImageResource(android.R.drawable.ic_media_play); // Fallback
                        iv.setColorFilter(data.color); // Apply color to icon if needed
                    }
                    iv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    // Fixed size for cover
                    params.width = 100;
                    params.height = 100;
                    view = iv;
                } else if ("time".equals(data.type)) {
                    android.widget.TextClock tc = new android.widget.TextClock(getContext());
                    tc.setFormat12Hour(data.text);
                    tc.setFormat24Hour(data.text);
                    tc.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tc.setTextColor(data.color);
                    tc.setPadding(0, 0, 0, 0);
                    tc.setIncludeFontPadding(false); // Minimized vertical spacing
                    tc.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 12);
                    view = tc;
                } else {
                    android.widget.TextView tv = new android.widget.TextView(getContext());
                    tv.setText(data.text);
                    tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tv.setPadding(0, 0, 0, 0);
                    tv.setIncludeFontPadding(false); // Minimized vertical spacing
                    tv.setTextColor(data.color);

                    // Rule 2: Font size logic
                    if ("gear".equals(data.type)) {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
                    } else if ("turn_signal".equals(data.type)) {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24); // Same size as gear
                    } else {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 12);
                    }

                    // Rule 3: Song Component Layout
                    if (isSong) {
                        params.width = 300;
                        tv.setSingleLine(false);
                        tv.setMaxLines(2);
                    }
                    view = tv;
                }

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
                }

                view.measure(widthSpec, heightSpec);
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();

                // Bounds Clamp, using dynamic maxWidth/maxHeight
                float clampedX = Math.max(0, Math.min(data.x, maxWidth - measuredWidth));
                float clampedY = Math.max(0, Math.min(data.y, maxHeight - measuredHeight));

                view.setX(clampedX);
                view.setY(clampedY);

                // Tag the view for dynamic visibility control
                view.setTag(data.type);

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
    }

    public void updateRpm(float rpm) {
        if (mClusterRpmPointer != null) {
            // RPM 0 -> Left (West) = 270 degrees.
            // RPM 8000 -> Bottom (South) = 180 + 360 = 540 degrees.
            // Range: 270 degrees Clockwise (Left -> Top -> Right -> Bottom).
            // Factor: 270 / 8000 = 0.03375
            mClusterRpmPointer.setRotation(270 + (rpm * 0.03375f));
        }
    }
}
