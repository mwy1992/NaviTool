package com.ecarx.xui.adaptapi.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VehicleZone {
  public static final int ZONE_ALL = -2147483648;
  
  public static final int ZONE_ROOF_TOP = 268435456;
  
  public static final int ZONE_ROW_1_ALL = 8;
  
  public static final int ZONE_ROW_1_CENTER = 2;
  
  public static final int ZONE_ROW_1_LEFT = 1;
  
  public static final int ZONE_ROW_1_RIGHT = 4;
  
  public static final int ZONE_ROW_2_ALL = 128;
  
  public static final int ZONE_ROW_2_CENTER = 32;
  
  public static final int ZONE_ROW_2_LEFT = 16;
  
  public static final int ZONE_ROW_2_RIGHT = 64;
  
  public static final int ZONE_ROW_3_ALL = 2048;
  
  public static final int ZONE_ROW_3_CENTER = 512;
  
  public static final int ZONE_ROW_3_LEFT = 256;
  
  public static final int ZONE_ROW_3_RIGHT = 1024;
  
  public static final int ZONE_ROW_4_ALL = 32768;
  
  public static final int ZONE_ROW_4_CENTER = 8192;
  
  public static final int ZONE_ROW_4_LEFT = 4096;
  
  public static final int ZONE_ROW_4_RIGHT = 16384;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ZoneType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\vehicle\VehicleZone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */