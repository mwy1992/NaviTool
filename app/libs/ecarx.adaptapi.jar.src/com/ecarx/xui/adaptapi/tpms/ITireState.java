package com.ecarx.xui.adaptapi.tpms;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public interface ITireState {
  public static final int WARNING_LEVEL_HARD_WARN = 2;
  
  public static final int WARNING_LEVEL_NO_WARN = 0;
  
  public static final int WARNING_LEVEL_SENSOR_FAULT = 3;
  
  public static final int WARNING_LEVEL_SOFT_WARN = 1;
  
  float getPressure();
  
  float getTemperature();
  
  int getTireWarning();
  
  boolean hasPressureWarning();
  
  boolean isQuickLeaking();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TireWarning {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tpms\ITireState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */