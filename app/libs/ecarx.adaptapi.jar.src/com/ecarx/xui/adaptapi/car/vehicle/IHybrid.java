package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IHybrid {
  public static final int HYBRID_FUNC_BATTERY_CHARGE_MODE = 604111360;
  
  public static final int HYBRID_FUNC_BATTERY_SAVE_MODE = 604111104;
  
  public static final int HYBRID_FUNC_BATTERY_SOC = 604176640;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "KX")
  public static final int HYBRID_FUNC_ELECTRIC_AND_HYBRID_SELECT = 604242176;
  
  public static final int HYBRID_FUNC_ELECTRIC_MODE = 604242177;
  
  public static final int HYBRID_FUNC_EV_MODE = 604242179;
  
  public static final int HYBRID_FUNC_HYBRID_MODE = 604242178;
  
  public static final int HYBRID_FUNC_POWER_FLOW = 604045568;
  
  @VendorDefinition(author = "@ECARX", date = "2023-04-23", project = "EX_A1")
  public static final int HYBRID_FUNC_SMART_ENERGY_MANAGER = 604242176;
  
  public static final int HYBRID_FUNC_STATUS = 604963072;
  
  public static final int POWER_FLOW_BOOST = 604045570;
  
  public static final int POWER_FLOW_CHARGE_AC = 604045582;
  
  public static final int POWER_FLOW_CHARGE_DC = 604045583;
  
  public static final int POWER_FLOW_DISCHARGE = 604045584;
  
  public static final int POWER_FLOW_DRIVEN_BY_ELECTRIC_MOTOR_AND_ENGINE = 604045592;
  
  public static final int POWER_FLOW_EAWD = 604045571;
  
  public static final int POWER_FLOW_ELEC = 604045574;
  
  public static final int POWER_FLOW_ENGINEOFF_REGBRAKE = 604045578;
  
  public static final int POWER_FLOW_ENGINEONLY = 604045572;
  
  public static final int POWER_FLOW_ENGINEONLY_CHARGE = 604045573;
  
  public static final int POWER_FLOW_ENGINEON_REGBRAKE = 604045579;
  
  public static final int POWER_FLOW_ENGINEON_REGBRAKE_CHARGE = 604045580;
  
  public static final int POWER_FLOW_FRONT_ELE_DRIVE = 604045586;
  
  public static final int POWER_FLOW_MAIN_CHARGE = 604045569;
  
  public static final int POWER_FLOW_NOT_READY = 0;
  
  public static final int POWER_FLOW_PURE_ELE_AWD = 604045585;
  
  public static final int POWER_FLOW_REAR_ELE_DRIVE = 604045587;
  
  public static final int POWER_FLOW_REGENERATION = 604045589;
  
  public static final int POWER_FLOW_SAILING = 604045581;
  
  public static final int POWER_FLOW_STANDSTILL = 604045588;
  
  public static final int POWER_FLOW_STANDSTILL_AND_BOTH_EM_ENGINE_OFF = 604045590;
  
  public static final int POWER_FLOW_STANDSTILL_ENGINE_ON_WITH_ISG = 604045591;
  
  public static final int POWER_FLOW_STILL_ENGINEOFF = 604045575;
  
  public static final int POWER_FLOW_STILL_ENGINEON = 604045576;
  
  public static final int POWER_FLOW_STILL_ENGINEON_CHARGE = 604045577;
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "KX")
  public static @interface ElectricHybridSelection {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HybridFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HybridSmartEnergy {
    public static final int STATUS_CLOSE = 0;
    
    public static final int STATUS_OPEN = 2;
    
    public static final int STATUS_STANDBY = 1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HybridStatus {
    public static final int STATUS_DEACTIVATE = 1;
    
    public static final int STATUS_NONE = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PowerFlowMode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IHybrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */