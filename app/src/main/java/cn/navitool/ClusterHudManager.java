package cn.navitool;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import java.lang.reflect.Method;

public class ClusterHudManager {
    private static final String TAG = "ClusterHudManager";
    private static ClusterHudManager instance;
    private Context mContext;
    private ClusterHudPresentation mPresentation;
    private boolean mIsClusterEnabled = false;
    private boolean mIsHudEnabled = false;
    private Object mDimMenuInteraction; // IDimMenuInteraction via Reflection

    // AdaptAPI Reflection Constants
    private static final String CLASS_DIM_INTERACTION = "com.ecarx.xui.adaptapi.diminteraction.DimInteraction";
    private static final String CLASS_DIM_MENU_INTERACTION = "com.ecarx.xui.adaptapi.diminteraction.IDimMenuInteraction";

    private ClusterHudManager(Context context) {
        this.mContext = context.getApplicationContext();
        initAdaptApi();
    }

    public static synchronized ClusterHudManager getInstance(Context context) {
        if (instance == null) {
            instance = new ClusterHudManager(context);
        }
        return instance;
    }

    private void initAdaptApi() {
        try {
            // DimInteraction.create(context)
            Class<?> dimInteractionClass = Class.forName(CLASS_DIM_INTERACTION);
            Method createMethod = dimInteractionClass.getMethod("create", Context.class);
            Object dimInteraction = createMethod.invoke(null, mContext);

            // dimInteraction.getDimMenuInteraction()
            Method getMenuInteractionMethod = dimInteractionClass.getMethod("getDimMenuInteraction");
            mDimMenuInteraction = getMenuInteractionMethod.invoke(dimInteraction);
            DebugLogger.i(TAG, "AdaptAPI DimMenuInteraction initialized successfully: " + mDimMenuInteraction);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to initialize AdaptAPI DimMenuInteraction", e);
        }
    }

    public void setClusterEnabled(boolean enabled) {
        if (mIsClusterEnabled == enabled)
            return;
        mIsClusterEnabled = enabled;
        DebugLogger.d(TAG, "setClusterEnabled: " + enabled);

        updatePresentation();

        // Handle API Call for Cluster Mode
        // Cluster Switch ON -> switchNaviMode(3)
        // Cluster Switch OFF -> switchNaviMode(1)
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
        DebugLogger.d(TAG, "setHudEnabled: " + enabled);
        updatePresentation();
    }

    private void updatePresentation() {
        // If either is enabled, we need the Presentation shown
        if (mIsClusterEnabled || mIsHudEnabled) {
            if (mPresentation == null) {
                showPresentation();
            } else {
                // Update visibility
                mPresentation.setClusterVisible(mIsClusterEnabled);
                mPresentation.setHudVisible(mIsHudEnabled);
            }
        } else {
            // Both disabled, dismiss presentation
            dismissPresentation();
        }
    }

    private void showPresentation() {
        DisplayManager dm = (DisplayManager) mContext.getSystemService(Context.DISPLAY_SERVICE);
        Display[] displays = dm.getDisplays();
        DebugLogger.d(TAG, "Found " + displays.length + " displays");

        // Target Display ID 2
        Display targetDisplay = null;
        for (Display d : displays) {
            DebugLogger.d(TAG, "Display ID=" + d.getDisplayId() + ", Name=" + d.getName());
            if (d.getDisplayId() == 2) {
                targetDisplay = d;
                break;
            }
        }

        if (targetDisplay != null) {
            mPresentation = new ClusterHudPresentation(mContext, targetDisplay);
            // Need to set window type for system overlays if using Application Context?
            // Actually, for Presentation on secondary display, standard setup usually works
            // if started from Activity context
            // but we are using Application context here.
            // IMPORTANT: Presentation usually needs a Token from an Activity or
            // TYPE_APPLICATION_OVERLAY window type.
            // Since this is triggered from MainActivity, we should technically pass an
            // Activity Context or use System Alert Window permission.
            // However, starting from Activity context is safer for Presentation.
            // NOTE: Changing constructor to accept Context from MainActivity call might be
            // better, OR use explicit Window Type.
            // Let's try specifying type if we can, OR rely on MainActivity passing Context.
            // But this Manager is singleton...
            // Let's assume TYPE_APPLICATION_OVERLAY if we have permission, otherwise use
            // the Activity context passed in getInstance() if possible?
            // Wait, getInstance(Context) uses getApplicationContext(). This might crash
            // with "Unable to add window -- token null".
            // FIX: Use TYPE_APPLICATION_OVERLAY.

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                mPresentation.getWindow().setType(android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            } else {
                mPresentation.getWindow().setType(android.view.WindowManager.LayoutParams.TYPE_PHONE);
            }

            try {
                mPresentation.show();
                mPresentation.setClusterVisible(mIsClusterEnabled);
                mPresentation.setHudVisible(mIsHudEnabled);
                DebugLogger.i(TAG, "ClusterHudPresentation SHOWN on Display 2");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to show presentation", e);
                mPresentation = null;
            }
        } else {
            DebugLogger.e(TAG, "Display ID 2 not found!");
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

    public static class HudComponentData {
        public String type; // "text" or "time"
        public String text;
        public float x;
        public float y;
        public int color; // ARGB Color

        public HudComponentData(String type, String text, float x, float y, int color) {
            this.type = type;
            this.text = text;
            this.x = x;
            this.y = y;
            this.color = color;
        }

        // Overload for backward compatibility (defaults to White)
        public HudComponentData(String type, String text, float x, float y) {
            this(type, text, x, y, android.graphics.Color.WHITE);
        }
    }

    public void syncHudLayout(java.util.List<HudComponentData> components) {
        if (mPresentation != null) {
            mPresentation.syncHudLayout(components);
        }
    }

    // Deprecated single sync, keeping for backward compat if needed temporarily
    public void syncTestComponent(String text, float x, float y) {
        java.util.List<HudComponentData> list = new java.util.ArrayList<>();
        list.add(new HudComponentData("text", text, x, y));
        syncHudLayout(list);
    }

    public void clearHudComponents() {
        if (mPresentation != null) {
            mPresentation.clearHudComponents();
        }
    }

    public void capturePresentation(String filePath) {
        if (mPresentation != null) {
            mPresentation.saveScreenshot(filePath);
        }
    }
}
