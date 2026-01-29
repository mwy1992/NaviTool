package cn.navitool.theme;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import cn.navitool.interfaces.IClusterTheme;
import cn.navitool.managers.NaviInfoManager;
import cn.navitool.model.GuideInfo;
import cn.navitool.model.TrafficLightInfo;
import cn.navitool.view.TrafficLightView;

/**
 * Base Controller for Cluster Themes.
 * Implements common logic for Gear mapping, Speed filtering, and default interface methods.
 * Also handles Traffic Light and Navigation Info display (shared across themes).
 */
public abstract class BaseThemeController implements IClusterTheme {
    protected static final String TAG = "BaseThemeController";

    protected Context mContext;
    protected View mRootView;
    
    // Common Views (Subclasses must assign these in bindViews)
    protected TextView mSpeedText;
    protected TextView mGearText;
    
    // Traffic Light & Navi Views (Shared - Subclasses assign in onBindViews)
    protected TrafficLightView mTrafficLightMulti;
    protected View mNaviTrafficContainer;
    protected View mNaviInfoRow;
    protected TextView mCurrentRoadText;
    protected TextView mDestinationText;
    protected TextView mNaviDistance;
    protected TextView mNaviEta;
    
    // Sensor Views (Shared - Subclasses assign in onBindViews)
    protected TextView mOdometerText;
    protected TextView mFuelRemainText;
    protected TextView mTempInText;
    protected TextView mInstantFuelText;

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
    
    // [FIX 2026-01-29 Phase 3] Navigation Status for Cruise Logic
    protected int mNaviStatus = NaviInfoManager.STATUS_IDLE;

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
        // Traffic Light & Navi
        mTrafficLightMulti = null;
        mNaviTrafficContainer = null;
        mNaviInfoRow = null;
        mCurrentRoadText = null;
        mDestinationText = null;
        mNaviDistance = null;
        mNaviEta = null;
        // Sensor Views
        mOdometerText = null;
        mFuelRemainText = null;
        mTempInText = null;
        mInstantFuelText = null;
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

    // --- Traffic Light Implementation (Shared) ---

    @Override
    public void updateTrafficLight(java.util.List<TrafficLightInfo> lights) {
        if (lights == null || lights.isEmpty()) {
            resetTrafficLights();
            return;
        }

        java.util.List<TrafficLightView.LightState> lightStates = new java.util.ArrayList<>();
        
        for (TrafficLightInfo info : lights) {
            if (info == null) continue;
            
            int mappedStatus = NaviInfoManager.mapStatus(info.status);
            boolean isValidStatus = (mappedStatus == TrafficLightView.STATUS_RED || 
                                   mappedStatus == TrafficLightView.STATUS_YELLOW || 
                                   mappedStatus == TrafficLightView.STATUS_GREEN);

            if (isValidStatus || info.redCountdown > 0) {
                lightStates.add(new TrafficLightView.LightState(mappedStatus, info.redCountdown, info.direction));
            }
        }
        
        if (lightStates.isEmpty()) {
            if (mNaviTrafficContainer != null) mNaviTrafficContainer.setVisibility(View.GONE);
            return;
        }

        if (mNaviTrafficContainer != null) {
            mNaviTrafficContainer.setVisibility(View.VISIBLE);
        }
        
        if (mTrafficLightMulti != null) {
            mTrafficLightMulti.setVisibility(View.VISIBLE);
            mTrafficLightMulti.updateMultiLights(lightStates);
        }
    }

    @Override
    public void resetTrafficLights() {
        if (mTrafficLightMulti != null) mTrafficLightMulti.setVisibility(View.GONE);
        if (mNaviTrafficContainer != null) mNaviTrafficContainer.setVisibility(View.GONE);
    }

    // --- Navigation Info Implementation (Shared) ---

    @Override
    public void updateGuideInfo(GuideInfo info) {
        if (info == null) {
            if (mNaviInfoRow != null) mNaviInfoRow.setVisibility(View.GONE);
            return;
        }
        
        if (info.routeRemainDis < 0) {
            if (mNaviInfoRow != null) mNaviInfoRow.setVisibility(View.GONE);
            return;
        }
        
        // [FIX 2026-01-29 Phase 3] Cruise Mode Logic: Only show Distance/ETA row in strict NAVI mode
        boolean showNaviInfo = (mNaviStatus == NaviInfoManager.STATUS_NAVI);
        
        if (mNaviInfoRow != null) {
            if (showNaviInfo) {
                if (mNaviInfoRow.getVisibility() != View.VISIBLE) {
                    mNaviInfoRow.setVisibility(View.VISIBLE);
                }
            } else {
                if (mNaviInfoRow.getVisibility() != View.GONE) {
                    mNaviInfoRow.setVisibility(View.GONE);
                }
            }
        }

        if (mNaviDistance != null) {
            String distText = "";
            if (info.routeRemainDis >= 1000) {
                 distText = String.format(java.util.Locale.US, "%.1fKM", info.routeRemainDis / 1000f);
            } else {
                 distText = info.routeRemainDis + "M";
            }
            mNaviDistance.setText(distText);
        }

        if (mNaviEta != null) {
            String eta = NaviInfoManager.calculateEta(info.routeRemainTime);
            String displayEta = eta.isEmpty() ? "" : "ETA " + eta;
            mNaviEta.setText(displayEta);
        }
        
        // Current Road
        if (mCurrentRoadText != null) {
            if (info.currentRoadName != null && !info.currentRoadName.isEmpty()) {
                mCurrentRoadText.setText("当前：" + info.currentRoadName);
                mCurrentRoadText.setVisibility(View.VISIBLE);
            } else {
                mCurrentRoadText.setVisibility(View.GONE);
            }
        }
        
        // Destination
        if (mDestinationText != null) {
            if (info.destinationName != null && !info.destinationName.isEmpty()) {
                mDestinationText.setText("目的地：" + info.destinationName);
                mDestinationText.setVisibility(View.VISIBLE);
            } else {
                mDestinationText.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void resetNaviInfo() {
        resetTrafficLights();
        
        if (mNaviDistance != null) mNaviDistance.setText("");
        if (mNaviEta != null) mNaviEta.setText("");
        if (mCurrentRoadText != null) mCurrentRoadText.setVisibility(View.GONE);
        if (mDestinationText != null) mDestinationText.setVisibility(View.GONE);
        
        if (mNaviInfoRow != null) mNaviInfoRow.setVisibility(View.GONE);
    }

    // --- Default Empty Implementations (Optional Support) ---

    @Override public void setDayMode(boolean isDay) {}
    @Override public void setNavigating(boolean isNavigating) {}
    /** [FIX 2026-01-29 Phase 3] Store Status to control UI logic */
    @Override public void setNaviStatus(int status) {
        this.mNaviStatus = status;
    }
    @Override public void updateRpm(float rpm) {}
    @Override public void updateTripInfo(float distance, long duration) {}
    @Override public void updateTirePressure(int index, float pressure) {}
    @Override public void updateTireTemp(int index, float temp) {}

    // --- Common Sensor Implementations ---

    @Override
    public void updateOdometer(float odometer) {
        if (mOdometerText != null) {
            mOdometerText.setText(String.format(java.util.Locale.US, "总里程: %.0fkm", odometer));
        }
    }

    @Override
    public void updateFuelRemain(float fuelLiters) {
        if (mFuelRemainText != null) {
            mFuelRemainText.setText(String.format(java.util.Locale.US, "油量: %.1fL", fuelLiters));
        }
    }

    @Override
    public void updateIndoorTemp(float temp) {
        if (mTempInText != null) {
            // [FIX 2026-01-29 Phase 3] Use %.1f to match runtime format
            mTempInText.setText(String.format(java.util.Locale.US, "In: %.1f°C", temp));
        }
    }

    @Override
    public void updateInstantFuel(float fuel) {
        if (mInstantFuelText != null) {
            mInstantFuelText.setText(String.format(java.util.Locale.US, "%.1f L/100km", fuel));
        }
    }
}
