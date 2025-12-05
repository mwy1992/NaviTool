package android.car;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class FuelType {
  public static final int BIODIESEL = 5;
  
  public static final int CNG = 8;
  
  public static final int DIESEL_1 = 3;
  
  public static final int DIESEL_2 = 4;
  
  public static final int E85 = 6;
  
  public static final int ELECTRIC = 10;
  
  public static final int HYDROGEN = 11;
  
  public static final int LEADED = 2;
  
  public static final int LNG = 9;
  
  public static final int LPG = 7;
  
  public static final int OTHER = 12;
  
  public static final int UNKNOWN = 0;
  
  public static final int UNLEADED = 1;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Enum {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\FuelType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */