package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IUnits {
  public static final int FUNC_UNIT_AVG_FUEL = 620822784;
  
  public static final int FUNC_UNIT_DATE_FORMAT = 620888576;
  
  public static final int FUNC_UNIT_DRIVEN_DISTANCE = 620823040;
  
  public static final int FUNC_UNIT_SPEED = 620823808;
  
  public static final int FUNC_UNIT_TEMPERATURE = 620823296;
  
  public static final int FUNC_UNIT_TIME_INDICATION = 620888320;
  
  public static final int FUNC_UNIT_TIRE_PRESSURE = 620823552;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-27", project = "KX11/EX11", requirement = "")
  public static final int FUNC_UNIT_WARN_SPEED = 620888832;
  
  public static final int UNIT_AVG_FUEL_KM_L = 620822786;
  
  public static final int UNIT_AVG_FUEL_L_100KM = 620822785;
  
  public static final int UNIT_AVG_FUEL_UK_MPG = 620822788;
  
  public static final int UNIT_AVG_FUEL_US_MPG = 620822787;
  
  public static final int UNIT_DATE_FORMAT_DMY = 620888578;
  
  public static final int UNIT_DATE_FORMAT_MDY = 620888579;
  
  public static final int UNIT_DATE_FORMAT_YMD = 620888577;
  
  public static final int UNIT_DRIVEN_DISTANCE_KM = 620823041;
  
  public static final int UNIT_DRIVEN_DISTANCE_MILES = 620823042;
  
  public static final int UNIT_SPEED_KM_H = 620823809;
  
  public static final int UNIT_SPEED_MPH = 620823810;
  
  public static final int UNIT_TEMPERATURE_C = 620823297;
  
  public static final int UNIT_TEMPERATURE_F = 620823298;
  
  public static final int UNIT_TIME_INDICATION_24H = 620888322;
  
  public static final int UNIT_TIME_INDICATION_AM_PM = 620888321;
  
  public static final int UNIT_TIRE_PRESSURE_BAR = 620823554;
  
  public static final int UNIT_TIRE_PRESSURE_KPA = 620823553;
  
  public static final int UNIT_TIRE_PRESSURE_PSI = 620823555;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AvgFuelUnits {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DateFormatUnits {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DrivenDistanceUnits {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SpeedUnits {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TemperatureUnits {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TimeIndicationUnits {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TirePressureUnits {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface UnitFunction {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IUnits.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */