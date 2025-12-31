package cn.navitool.managers;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import cn.navitool.ClusterHudManager;
import cn.navitool.ConfigManager;
import cn.navitool.DebugLogger;

public class ClusterManager {
    private static final String TAG = "ClusterManager";
    private static ClusterManager instance;
    private final Context mContext;

    private ClusterManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized ClusterManager getInstance(Context context) {
        if (instance == null) {
            instance = new ClusterManager(context);
        }
        return instance;
    }

    // --- Cluster Layout Management ---
    // Currently only handles Theme Selection which might imply different sets of
    // components

    public void applyClusterTheme(String themeId) {
        // Prepare layout based on Theme ID
        ClusterHudManager manager = ClusterHudManager.getInstance(mContext);

        if ("1".equals(themeId)) {
            // Style 1: Speedometer Dashboard (Built-in)
            manager.enableClusterDashboard();
        } else {
            // Custom Theme or Unknown (Treat as Layout Clear if unknown, or Load if Custom)
            // Check if it's a custom theme
            List<ClusterHudManager.HudComponentData> customData = CustomThemeManager.getInstance(mContext)
                    .loadTheme(themeId);

            if (!customData.isEmpty()) {
                // It's a valid custom theme
                manager.syncClusterLayout(customData);
            } else {
                // Fallback or Clear
                manager.clearHudComponents();
                // Ensure list is cleared in Presentation via sync
                manager.syncClusterLayout(new ArrayList<>());
            }
        }

        // Ensure Cluster is Enabled and Visible -> REMOVED
        // The Enabled state should be controlled by the Switch in MainActivity, not
        // forced by Theme selection.
        // manager.setClusterEnabled(true);

        // Save using ConfigManager - REMOVED: MainActivity already saves before calling
        // applyClusterTheme.
        // ConfigManager.getInstance().setString("cluster_theme_id", themeId);
        // DebugLogger.e(TAG, "Verified ConfigManager setString: " + themeId);

        // Notify Presentation (TODO: Implement listener if instant switch needed)
    }

    // Legacy overload for compatibility with existing int calls until updated
    public void applyClusterTheme(int themeId) {
        applyClusterTheme(String.valueOf(themeId));
    }
}
