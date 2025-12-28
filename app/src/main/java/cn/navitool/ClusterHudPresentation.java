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
            mLayoutCluster.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    public void setHudVisible(boolean visible) {
        if (mLayoutHud != null) {
            mLayoutHud.setVisibility(visible ? View.VISIBLE : View.GONE);
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

    public void syncHudLayout(java.util.List<ClusterHudManager.HudComponentData> components) {
        if (mLayoutHud instanceof android.widget.FrameLayout) {
            android.widget.FrameLayout container = (android.widget.FrameLayout) mLayoutHud;

            // Clear existing
            for (View v : mRealHudComponents) {
                container.removeView(v);
            }
            mRealHudComponents.clear();

            // Add new
            for (ClusterHudManager.HudComponentData data : components) {
                View view;
                boolean isSong = "song".equals(data.type);
                boolean isMediaCover = "media_cover".equals(data.type);
                int measuredWidth = 0;
                int measuredHeight = 0;

                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);

                if (isMediaCover) {
                    android.widget.ImageView iv = new android.widget.ImageView(getContext());
                    if (data.image != null) {
                        iv.setImageBitmap(data.image);
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
                    tc.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 10);
                    view = tc;
                } else {
                    android.widget.TextView tv = new android.widget.TextView(getContext());
                    tv.setText(data.text);
                    tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tv.setPadding(0, 0, 0, 0);
                    tv.setTextColor(data.color);

                    // Rule 2: Font size logic
                    if ("gear".equals(data.type)) {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 20);
                    } else {
                        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 10);
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

                // Bounds Clamp
                int containerWidth = 728;
                int containerHeight = 190;
                float clampedX = Math.max(0, Math.min(data.x, containerWidth - measuredWidth));
                float clampedY = Math.max(0, Math.min(data.y, containerHeight - measuredHeight));

                view.setX(clampedX);
                view.setY(clampedY);
                view.setVisibility(View.VISIBLE);

                mRealHudComponents.add(view);
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
    }

}
