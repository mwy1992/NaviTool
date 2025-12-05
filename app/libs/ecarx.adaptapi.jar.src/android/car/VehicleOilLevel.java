package android.car;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VehicleOilLevel {
  public static final int CRITICALLY_LOW = 0;
  
  public static final int ERROR = 4;
  
  public static final int HIGH = 3;
  
  public static final int LOW = 1;
  
  public static final int NORMAL = 2;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Enum {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\VehicleOilLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */