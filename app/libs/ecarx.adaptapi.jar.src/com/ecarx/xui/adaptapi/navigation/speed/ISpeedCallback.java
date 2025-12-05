package com.ecarx.xui.adaptapi.navigation.speed;

public interface ISpeedCallback {
  public static final int SPEED_DOWN_BIG_RAIN = 1;
  
  public static final int SPEED_DOWN_TSR = 2;
  
  public static final int SPEED_DOWN_UNKNOWN = -2147483646;
  
  void onSpeedDownReminder(@SpeedDownReason int paramInt);
  
  void onSpeedLimitEnableChanged(boolean paramBoolean);
  
  void onTsrSpeedLimit(int paramInt);
  
  public static @interface SpeedDownReason {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\speed\ISpeedCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */