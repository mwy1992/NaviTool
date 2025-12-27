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
                // Determine View Type
                android.widget.TextView tv;
                if ("time".equals(data.type)) {
                    android.widget.TextClock tc = new android.widget.TextClock(getContext());
                    tc.setFormat12Hour(data.text); // Use text field as format (e.g. "HH:mm")
                    tc.setFormat24Hour(data.text);
                    tc.setBackgroundColor(android.graphics.Color.TRANSPARENT);
                    tc.setPadding(0, 0, 0, 0); // No padding for time
                    tv = tc;
                } else {
                    tv = new android.widget.TextView(getContext());
                    tv.setText(data.text);
                    tv.setBackgroundColor(android.graphics.Color.WHITE);
                    tv.setPadding(8, 4, 8, 4); // Standard padding for text
                }

                tv.setTextSize(12); // Real HUD is 0.5x scale
                tv.setTextColor(data.color);

                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = android.view.Gravity.TOP | android.view.Gravity.START;

                container.addView(tv, params);

                // Measure
                tv.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                int width = tv.getMeasuredWidth();
                int height = tv.getMeasuredHeight();

                // Bounds Clamp
                int containerWidth = 728;
                int containerHeight = 190;
                float clampedX = Math.max(0, Math.min(data.x, containerWidth - width));
                float clampedY = Math.max(0, Math.min(data.y, containerHeight - height));

                tv.setX(clampedX);
                tv.setY(clampedY);
                tv.setVisibility(View.VISIBLE);

                mRealHudComponents.add(tv);
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

    public void saveScreenshot(String filePath) {
        View rootView = getWindow().getDecorView();
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0)
            return;

        try {
            android.graphics.Bitmap bitmap = android.graphics.Bitmap.createBitmap(
                    rootView.getWidth(), rootView.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
            rootView.draw(canvas);

            java.io.File file = new java.io.File(filePath);
            try (java.io.FileOutputStream fos = new java.io.FileOutputStream(file)) {
                bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fos);
                android.util.Log.i(TAG, "Software screenshot saved: " + filePath);
            }
        } catch (Exception e) {
            android.util.Log.e(TAG, "Failed to save software screenshot", e);
        }
    }
}
