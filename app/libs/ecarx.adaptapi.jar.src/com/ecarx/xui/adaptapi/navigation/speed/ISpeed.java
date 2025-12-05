package com.ecarx.xui.adaptapi.navigation.speed;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ISpeed {
  public static final int KEY_STRING_ELEC_LIMITED_SPEED_INFO = 1073741826;
  
  public static final int KEY_STRING_JCT_WAY_INFO = 1073741835;
  
  public static final int KEY_STRING_ROAD_CLASS_INFO = 1073741827;
  
  public static final int KEY_STRING_START = 1073741824;
  
  boolean isSpeedLimitEnabled();
  
  void registerSpeedCallback(ISpeedCallback paramISpeedCallback);
  
  void setSpeedLimitingInfo(int paramInt, ISpeedLimitingInfo paramISpeedLimitingInfo);
  
  void unregisterSpeedCallback(ISpeedCallback paramISpeedCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface KeyType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\speed\ISpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */