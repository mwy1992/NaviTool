package cn.navitool.managers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.ecarx.xui.adaptapi.car.base.ICarFunction;

import cn.navitool.utils.DebugLogger;
import cn.navitool.service.KeepAliveAccessibilityService;

public class SunshadeManager {
    private static final String TAG = "SunshadeManager";
    private static SunshadeManager instance;
    private Context mContext;
    private Handler mMainHandler;

    // Sunshade Control Constants (From Analysis)
    private static final int FUNC_SUNSHADE_POS = 553845504;
    private static final int ZONE_SUNSHADE = 8;

    // Config Keys
    public static final String KEY_AUTO_OPEN_ENABLE = "sunshade_auto_open_enable";
    public static final String KEY_NIGHT_MODE_ONLY = "sunshade_night_mode_only";
    public static final String KEY_TARGET_Position = "sunshade_target_pos"; // 0-100

    private SunshadeManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public static synchronized SunshadeManager getInstance(Context context) {
        if (instance == null) {
            instance = new SunshadeManager(context);
        }
        return instance;
    }

    /**
     * Executes the auto-open logic.
     * Should be called on engine start or service ready.
     */
    public void executeAutoOpen() {
        if (!isAutoOpenEnabled()) {
            DebugLogger.i(TAG, "Auto Open Disabled");
            return;
        }

        // Night Mode Check
        if (isNightModeOnly()) {
            boolean isNight = isCurrentNight();
            if (!isNight) {
                DebugLogger.i(TAG, "Skipped: Day Mode (Night Only Enabled)");
                return;
            }
        }

        // Execute Open
        int targetPos = getTargetPosition();
        DebugLogger.i(TAG, "Executing Auto Open to: " + targetPos + "%");
        setSunshadePosition(targetPos);
    }

    public void setSunshadePosition(int percent) {
        try {
            ICarFunction carFunction = cn.navitool.managers.CarServiceManager.getInstance(mContext).getCarFunction();
            if (carFunction != null) {
                // Ensure range 0-100
                if (percent < 0)
                    percent = 0;
                if (percent > 100)
                    percent = 100;

                // Set Float Property
                // Note: GlySunroofFragment uses setFloatProperty or setFunctionValue with
                // float?
                // Analysis showed: mCarViewModel.setFloatProperty(553845504, 8,
                // (float)percent);
                // ICarFunction usually has setFunctionValue(int func, int zone, int value)
                // which is int.
                // But for position it might be setCustomizeFunctionValue(int func, int zone,
                // float value)
                // Let's check ICarFunction definition again or try setFunctionValue first if it
                // accepts int percent.
                // Usually positions are int 0-100 in setFunctionValue(func, zone, value).
                // Let's try setFunctionValue(func, zone, intValue) first as standard.

                // WAIT: Analysis said "setFloatProperty".
                // In ICarFunction: boolean setCustomizeFunctionValue(int paramInt1, int
                // paramInt2, float paramFloat);
                // This matches (func, zone, float).

                carFunction.setCustomizeFunctionValue(FUNC_SUNSHADE_POS, ZONE_SUNSHADE, (float) percent);
                // DebugLogger.d(TAG, "Set Sunshade to " + percent);
            } else {
                DebugLogger.w(TAG, "ICarFunction is null");
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Error setting sunshade", e);
        }
    }

    private boolean isCurrentNight() {
        // Reuse ThemeBrightnessManager's logic if possible, or check sensor directly.
        // For simplicity and decoupling, let's use the ThemeManager logic if
        // accessible,
        // or just check if the current system is in Night mode (UI Mode).
        int uiMode = mContext.getResources().getConfiguration().uiMode
                & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
        return uiMode == android.content.res.Configuration.UI_MODE_NIGHT_YES;
    }

    // Config Getters/Setters
    public boolean isAutoOpenEnabled() {
        return ConfigManager.getInstance().getBoolean(KEY_AUTO_OPEN_ENABLE, false);
    }

    public void setAutoOpenEnabled(boolean enabled) {
        ConfigManager.getInstance().setBoolean(KEY_AUTO_OPEN_ENABLE, enabled);
    }

    public boolean isNightModeOnly() {
        return ConfigManager.getInstance().getBoolean(KEY_NIGHT_MODE_ONLY, false);
    }

    public void setNightModeOnly(boolean enabled) {
        ConfigManager.getInstance().setBoolean(KEY_NIGHT_MODE_ONLY, enabled);
    }

    public int getTargetPosition() {
        return ConfigManager.getInstance().getInt(KEY_TARGET_Position, 100); // Default 100%
    }

    public void setTargetPosition(int pos) {
        ConfigManager.getInstance().setInt(KEY_TARGET_Position, pos);
    }
}
