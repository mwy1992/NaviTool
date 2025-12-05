package com.ecarx.xui.adaptapi.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VehicleWindow {
  public static final int WINDOW_CUTOFF = 196608;
  
  public static final int WINDOW_FRONT_ROOF_ABAT_VENT = 65544;
  
  public static final int WINDOW_FRONT_WINDSHIELD = 1;
  
  public static final int WINDOW_REAR_ROOF_ABAT_VENT = 131080;
  
  public static final int WINDOW_REAR_WINDSHIELD = 2;
  
  public static final int WINDOW_ROOF_ABAT_VENT = 8;
  
  public static final int WINDOW_ROOF_TOP = 4;
  
  public static final int WINDOW_ROW_1_LEFT = 16;
  
  public static final int WINDOW_ROW_1_RIGHT = 32;
  
  public static final int WINDOW_ROW_2_LEFT = 256;
  
  public static final int WINDOW_ROW_2_RIGHT = 512;
  
  public static final int WINDOW_ROW_3_LEFT = 4096;
  
  public static final int WINDOW_ROW_3_RIGHT = 8192;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WindowType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\vehicle\VehicleWindow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */