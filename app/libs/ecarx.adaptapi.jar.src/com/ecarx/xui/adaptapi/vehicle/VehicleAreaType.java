package com.ecarx.xui.adaptapi.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VehicleAreaType {
  public static final int VEHICLE_AREA_TYPE_DOOR = 4;
  
  public static final int VEHICLE_AREA_TYPE_MIRROR = 5;
  
  public static final int VEHICLE_AREA_TYPE_NONE = 0;
  
  public static final int VEHICLE_AREA_TYPE_SEAT = 3;
  
  public static final int VEHICLE_AREA_TYPE_WINDOW = 2;
  
  public static final int VEHICLE_AREA_TYPE_ZONE = 1;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VehicleAreaTypeValue {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\vehicle\VehicleAreaType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */