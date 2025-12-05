package com.ecarx.xui.adaptapi.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VehicleMirror {
  public static final int MIRROR_DRIVER_CENTER = 4;
  
  public static final int MIRROR_DRIVER_LEFT = 1;
  
  public static final int MIRROR_DRIVER_RIGHT = 2;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MirrorType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\vehicle\VehicleMirror.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */