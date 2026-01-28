package cn.navitool.interfaces;

import android.view.View;
import cn.navitool.managers.NaviInfoManager;
import cn.navitool.model.TrafficLightInfo;
import cn.navitool.model.GuideInfo;
import java.util.List;

/**
 * Interface for all Cluster Theme Controllers.
 * Standardizes the interaction between Presentation and Theme implementations.
 */
public interface IClusterTheme {
    // Lifecycle
    void bindViews(View rootView);
    void detachViews();
    
    // State
    void setDayMode(boolean isDay);
    void setNavigating(boolean isNavigating);
    
    // Driving Data
    void updateSpeed(float speed);
    void updateRpm(float rpm);
    void setGear(int gearValue);
    void setGear(String gearCode);
    
    // Trip Computer
    void updateTripInfo(float distance, long duration);
    void updateOdometer(float odometer);
    void updateInstantFuel(float fuel);
    void updateFuelRemain(float fuelLiters);
    
    // Environment
    void updateIndoorTemp(float temp);
    
    // Navigation & ADAS
    void updateTrafficLight(List<TrafficLightInfo> lights);
    void resetTrafficLights();
    void updateGuideInfo(GuideInfo info);
    void resetNaviInfo();
    
    // TPMS
    void updateTirePressure(int index, float pressure);
    void updateTireTemp(int index, float temp);
}
