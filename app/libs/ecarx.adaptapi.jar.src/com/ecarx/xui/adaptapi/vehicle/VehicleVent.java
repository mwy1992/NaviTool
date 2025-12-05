package com.ecarx.xui.adaptapi.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VendorDefinition(author = "@ECARX", date = "2021-07-23", project = "lambda", requirement = "")
public final class VehicleVent {
  public static final int VENT_ROW_1_LEFT_CENTER = 2;
  
  public static final int VENT_ROW_1_LEFT_SIDE = 1;
  
  public static final int VENT_ROW_1_RIGHT_CENTER = 4;
  
  public static final int VENT_ROW_1_RIGHT_SIDE = 8;
  
  public static final int VENT_ROW_2_LEFT = 16;
  
  public static final int VENT_ROW_2_LEFT_CENTER = 32;
  
  public static final int VENT_ROW_2_RIGHT = 64;
  
  public static final int VENT_ROW_2_RIGHT_CENTER = 128;
  
  public static final int VENT_ROW_3_LEFT = 256;
  
  public static final int VENT_ROW_3_RIGHT = 1024;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\vehicle\VehicleVent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */