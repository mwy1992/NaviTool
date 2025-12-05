package com.ecarx.xui.adaptapi.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VehicleDoor {
  public static final int DOOR_HOOD = 268435456;
  
  public static final int DOOR_REAR = 536870912;
  
  public static final int DOOR_ROW_1_LEFT = 1;
  
  public static final int DOOR_ROW_1_RIGHT = 4;
  
  public static final int DOOR_ROW_2_LEFT = 16;
  
  public static final int DOOR_ROW_2_RIGHT = 64;
  
  public static final int DOOR_ROW_3_LEFT = 256;
  
  public static final int DOOR_ROW_3_RIGHT = 1024;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DoorType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\vehicle\VehicleDoor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */