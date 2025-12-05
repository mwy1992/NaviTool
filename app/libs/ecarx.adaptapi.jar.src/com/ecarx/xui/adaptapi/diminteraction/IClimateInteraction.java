package com.ecarx.xui.adaptapi.diminteraction;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public interface IClimateInteraction {
  public static final int CAR_MODULE_HVAC = 268435456;
  
  public static final int HVAC_FUNC_TEMP = 268828928;
  
  public static final int HVAC_FUNC_TEMP_MAX = 268829184;
  
  public static final int HVAC_FUNC_TEMP_MIN = 268829440;
  
  public static final int HVAC_FUNC_TEMP_UNIT = 268830208;
  
  public static final int TEMPERATURE_UNIT_C = 268830209;
  
  public static final int TEMPERATURE_UNIT_F = 268830210;
  
  boolean updateFunctionValue(int paramInt, float paramFloat);
  
  boolean updateFunctionValue(int paramInt1, int paramInt2);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ClimateFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TemperatureUnit {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\IClimateInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */