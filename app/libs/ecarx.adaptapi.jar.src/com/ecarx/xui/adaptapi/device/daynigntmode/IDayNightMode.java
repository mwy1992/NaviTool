package com.ecarx.xui.adaptapi.device.daynigntmode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDayNightMode {
  public static final int DISPLAY_DAY = 1;
  
  public static final int DISPLAY_INVALID = 0;
  
  public static final int DISPLAY_MODE_AUTO = 3;
  
  public static final int DISPLAY_MODE_CUSTOM = 4;
  
  public static final int DISPLAY_MODE_DAY = 1;
  
  public static final int DISPLAY_MODE_INVALID = 0;
  
  public static final int DISPLAY_MODE_NIGHT = 2;
  
  public static final int DISPLAY_NIGHT = 2;
  
  int getDayNight();
  
  int getDayNightMode();
  
  boolean registerDayNightModeCallBack(IDayNightChangeCallBack paramIDayNightChangeCallBack);
  
  boolean unregisterDayNigntModeCallBack(IDayNightChangeCallBack paramIDayNightChangeCallBack);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DayNight {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DayNightMode {}
  
  public static interface IDayNightChangeCallBack {
    void onDayNightChanged(int param1Int);
    
    void onDayNightModeChange(int param1Int);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\daynigntmode\IDayNightMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */