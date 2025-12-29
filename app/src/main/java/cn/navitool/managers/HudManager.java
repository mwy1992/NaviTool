package cn.navitool.managers;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.navitool.ClusterHudManager;
import cn.navitool.ConfigManager;
import cn.navitool.DebugLogger;

public class HudManager {
    private static final String TAG = "HudManager";
    private static HudManager instance;
    private final Context mContext;

    private HudManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized HudManager getInstance(Context context) {
        if (instance == null) {
            instance = new HudManager(context);
        }
        return instance;
    }

    // --- HUD State Management ---

    public void setSnowMode(boolean enabled) {
        ConfigManager.getInstance().setBoolean("hud_snow_mode", enabled);
        // Refresh logic would need to be called here or in MainActivity
    }

    public boolean isSnowModeEnabled() {
        return ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
    }

    // TODO: Move Layout Editor Logic here (Save, Load, Parse JSON)
}
