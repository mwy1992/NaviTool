package com.ecarx.xui.adaptapi.car.hev;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VendorDefinition(author = "@ECARX", date = "2022-01-07", project = "Lambda")
public interface IBatteryPack {
  public static final int FUNC_AC_HIGH_POWER = 607126272;
  
  public static final int FUNC_FRONT_DRIVE_HVDC_CURRENT = 607127040;
  
  public static final int FUNC_FRONT_DRIVE_HVDC_VOLTAGE = 607127296;
  
  public static final int FUNC_HEATING_STATE = 607125760;
  
  public static final int FUNC_MAIN_DCDC_HV_MEASURED_CURRENT = 607126528;
  
  public static final int FUNC_REAR_DRIVE_HVDC_CURRENT = 607127552;
  
  public static final int FUNC_REAR_DRIVE_HVDC_VOLTAGE = 607127808;
  
  public static final int FUNC_SECOND_DCDC_HV_MEASURED_CURRENT = 607126784;
  
  public static final int FUNC_THERMAL_MANAGEMENT_HIGH_POWER = 607126016;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BatteryPackFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BatteryPackHeatState {
    public static final int ACTIVE = 607125764;
    
    public static final int IDLE = 607125761;
    
    public static final int OFF = 607125765;
    
    public static final int PRESTART = 607125762;
    
    public static final int STANDBY = 607125763;
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\IBatteryPack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */