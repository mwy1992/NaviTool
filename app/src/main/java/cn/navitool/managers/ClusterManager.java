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

    public void applyClusterTheme(int themeId) {
        // Prepare layout based on Theme ID
        ClusterHudManager manager = ClusterHudManager.getInstance(mContext);

        if (themeId == 1) {
            // Style 1: Speedometer Dashboard
            manager.enableClusterDashboard();
        } else {
            // Style 2/3: Placeholder
            manager.clearHudComponents(); // Clears BOTH HUD and Cluster? Method name is misleading in HudManager.
            // Actually clearHudComponents checks layout types.
            // Let's rely on Manager logic or create specific method if needed.
            // For now, let's just send empty list to syncClusterLayout to clear Cluster
            // only if we used that.
            // But enableClusterDashboard replaces the view.
            // If switching FROM Dashboard TO List, we need to restore FrameLayout?
            // The enableClusterDashboard REPLACES views.
            // Resetting to FrameLayout might be needed if we want to use component list
            // again.
            // For now, assuming Style 2/3 are not implemented fully.
            manager.syncClusterLayout(new ArrayList<>());
        }

        // Ensure Cluster is Enabled and Visible
        manager.setClusterEnabled(true);

        // Save choice
        ConfigManager.getInstance().setInt("cluster_theme", themeId);

        // Note: syncClusterLayout logic in Manager is separate from Dashboard Mode.
        // I might need to explicitly disable Dashboard Mode if switching back,
        // but since I removeAllViews in enable, it's a one-way street unless I re-add
        // logic.
        // Assuming Style 1 is the main focus now.
    }
}
