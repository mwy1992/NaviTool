package com.ecarx.xui.adaptapi.car.sensor;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IVirtualSensor {
  public static final int MAINTENANCE_REMIND_STATE_ACTIVE = 4207106;
  
  public static final int MAINTENANCE_REMIND_STATE_NORMAL = 4207105;
  
  public static final int MAINTENANCE_REMIND_STATE_UNKNOWN = -1;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-01", project = "EX11")
  public static final int TYPE_ADDITIONAL_ENDURANCE_ENGINE_TIME = 4215296;
  
  public static final int TYPE_ADDITIONAL_EV_CONSUMPTION_ALL = 4214784;
  
  public static final int TYPE_ADDITIONAL_EV_CONSUMPTION_CLIMATE = 4215040;
  
  public static final int TYPE_AVG_ENERGY_CONSUMPTION = 4195328;
  
  public static final int TYPE_AVG_FUEL_CONSUMPTION = 4194560;
  
  public static final int TYPE_AVG_FUEL_CONSUMPTION_ONE_IGNITION = 4195072;
  
  public static final int TYPE_CHARGING_ENDURANCE_MILEAGE = 4210944;
  
  public static final int TYPE_DISCHARGING_ENDURANCE_MILEAGE = 4211200;
  
  public static final int TYPE_EV_BATTERY_PERCENTAGE = 4210688;
  
  public static final int TYPE_FUEL_PERCENTAGE = 4211968;
  
  public static final int TYPE_INS_FUEL_CONSUMPTION = 4194816;
  
  public static final int TYPE_JOY_FORBID_STATE = 4195584;
  
  public static final int TYPE_JOY_LIMIT_STATE = 4195840;
  
  public static final int TYPE_MAINTENANCE_MILEAGE = 4206592;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "KX")
  public static final int TYPE_MAINTENANCE_MILEAGE_EV_SINCE_LAST = 4215808;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "KX")
  public static final int TYPE_MAINTENANCE_MILEAGE_PURE_OIL_SINCE_LAST = 4216064;
  
  public static final int TYPE_MAINTENANCE_MILEAGE_REMIND = 4207104;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "KX")
  public static final int TYPE_MAINTENANCE_MILEAGE_SINCE_LAST_ALL = 4215552;
  
  public static final int TYPE_MAINTENANCE_TIME = 4206848;
  
  public static final int TYPE_MAINTENANCE_TIME_REMIND = 4207360;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-25", project = "EF1E")
  public static final int TYPE_MAX_POTENTIAL_ENDURANCE_MILEAGE_EV = 4211712;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "KX")
  public static final int TYPE_OIL_HEALTH = 4216576;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "KX")
  public static final int TYPE_OIL_NUMBER_OF_DAY = 4216320;
  
  public static final int TYPE_POTENTIAL_ENDURANCE_MILEAGE = 4211456;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MaintenanceRemindState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Type {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\IVirtualSensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */