package cn.navitool.theme;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import cn.navitool.interfaces.IClusterTheme;
import cn.navitool.controller.NaviInfoController;
import cn.navitool.controller.NaviInfoController.GuideInfo;
import cn.navitool.controller.NaviInfoController.TrafficLightInfo;

/**
 * Base Controller for Cluster Themes.
 * Implements common logic for Gear mapping, Speed filtering, and default interface methods.
 */
public abstract class BaseThemeController implements IClusterTheme {
    protected static final String TAG = "BaseThemeController";

    protected Context mContext;
    protected View mRootView;
    
    // Common Views (Subclasses must assign these in bindViews)
    protected TextView mSpeedText;
    protected TextView mGearText;

    // --- Gear Logic Constants ---
    protected static final int GEAR_PARK = 2097712;
    protected static final int GEAR_REVERSE = 2097728;
    protected static final int GEAR_NEUTRAL = 2097680;
    protected static final int GEAR_DRIVE = 2097696;
    protected static final int TRSM_GEAR_PARK = 15;
    protected static final int TRSM_GEAR_DRIVE = 13;
    protected static final int TRSM_GEAR_NEUT = 14;
    protected static final int TRSM_GEAR_RVS = 11;
    
    protected static final String[] GEARS = { "P", "R", "N", "D" };
    protected int mCurrentGearIndex = 0;

    // Speed Logic
    protected float mLastSpeed = -1f;

    @Override
    public void bindViews(View rootView) {
        if (rootView == null) return;
        mRootView = rootView;
        mContext = rootView.getContext();
        onBindViews(rootView);
    }

    /**
     * Abstract method for subclasses to bind their specific views
     */
    protected abstract void onBindViews(View rootView);

    @Override
    public void detachViews() {
        mRootView = null;
        mContext = null;
        mSpeedText = null;
        mGearText = null;
    }

    // --- Common Gear Implementation ---

    @Override
    public void setGear(int gearValue) {
        String gearStr = "P"; // Default
        if (gearValue == -1) {
            gearStr = "M";
        } else if (gearValue == GEAR_DRIVE || gearValue == TRSM_GEAR_DRIVE) {
            gearStr = "D";
        } else if (gearValue == GEAR_REVERSE || gearValue == TRSM_GEAR_RVS) {
            gearStr = "R";
        } else if (gearValue == GEAR_NEUTRAL || gearValue == TRSM_GEAR_NEUT) {
            gearStr = "N";
        } else if (gearValue == GEAR_PARK || gearValue == TRSM_GEAR_PARK) {
            gearStr = "P";
        }
        setGear(gearStr);
    }

    @Override
    public void setGear(String gearCode) {
        if (mGearText != null && gearCode != null) {
            mGearText.setText(gearCode);

            int color = Color.WHITE;
            if (gearCode.startsWith("D")) {
                color = Color.GREEN;
                mCurrentGearIndex = 3;
            } else if (gearCode.startsWith("R")) {
                color = Color.RED;
                mCurrentGearIndex = 1;
            } else if (gearCode.startsWith("N")) {
                color = Color.YELLOW;
                mCurrentGearIndex = 2;
            } else if (gearCode.startsWith("P")) {
                color = Color.WHITE;
                mCurrentGearIndex = 0;
            } else if (gearCode.startsWith("M") || gearCode.startsWith("S")) {
                color = Color.CYAN;
                mCurrentGearIndex = 3;
            }
            mGearText.setTextColor(color);
        }
    }

    /**
     * Helper for cycling gears (Testing/Demo)
     */
    public void cycleGear() {
        mCurrentGearIndex = (mCurrentGearIndex + 1) % GEARS.length;
        setGear(GEARS[mCurrentGearIndex]);
    }

    // --- Common Speed Implementation ---

    @Override
    public void updateSpeed(float speed) {
        // Jitter Filter (< 0.1 ignore)
        if (Math.abs(speed - mLastSpeed) < 0.1f) {
            return;
        }
        mLastSpeed = speed;

        // Update Text
        if (mSpeedText != null) {
            mSpeedText.setText(String.valueOf((int) speed));
        }

        // Hook for specific pointer/visual updates
        onSpeedUpdated(speed);
    }

    /**
     * Hook for subclasses to update speed pointers or other visuals
     */
    protected void onSpeedUpdated(float speed) {
        // Default empty
    }

    // --- Default Empty Implementations (Optional Support) ---

    @Override public void setDayMode(boolean isDay) {}
    @Override public void setNavigating(boolean isNavigating) {}
    @Override public void updateRpm(float rpm) {}
    @Override public void updateTripInfo(float distance, long duration) {}
    @Override public void updateOdometer(float odometer) {}
    @Override public void updateInstantFuel(float fuel) {}
    @Override public void updateFuelRemain(float fuelLiters) {}
    @Override public void updateIndoorTemp(float temp) {}
    @Override public void updateTrafficLight(TrafficLightInfo info) {}
    @Override public void resetTrafficLights() {}
    @Override public void updateGuideInfo(GuideInfo info) {}
    @Override public void resetNaviInfo() {}
    @Override public void updateTirePressure(int index, float pressure) {}
    @Override public void updateTireTemp(int index, float temp) {}
}
