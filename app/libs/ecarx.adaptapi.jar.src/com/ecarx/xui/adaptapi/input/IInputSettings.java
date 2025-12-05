package com.ecarx.xui.adaptapi.input;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL")
public interface IInputSettings {
  public static final int CUSTOM_FUNCTION_ADAS = 2;
  
  public static final int CUSTOM_FUNCTION_MEDIA = 1;
  
  public static final int CUSTOM_FUNCTION_NONE = 0;
  
  public static final int DURATION_BUTTON_STUCK = 2;
  
  public static final int DURATION_HOLD_PRESS_INTERVAL_TRIGGER = 3;
  
  public static final int DURATION_HOLD_SHORT = 1;
  
  public static final int INPUT_SETTING_LONG_PRESS_VOLUME_ADJUSTMENT_RATE = 2;
  
  public static final int INPUT_SETTING_MAX_STEP_TO_STEP = 5;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-25", project = "EX11")
  public static final int INPUT_SETTING_MOVE_OPERATION_DECREASE_RATE = 6;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-25", project = "EX11")
  public static final int INPUT_SETTING_MOVE_OPERATION_INCREASE_RATE = 7;
  
  public static final int INPUT_SETTING_SHORT_PRESS_VOLUME_ADJUSTMENT = 1;
  
  public static final int INPUT_SETTING_SWIPE_VOLUME_ADJUSTMENT_RATE = 4;
  
  public static final int STEER_WHEEL_TYPE_COORDINATE = 3;
  
  public static final int STEER_WHEEL_TYPE_MECHANICAL = 1;
  
  public static final int STEER_WHEEL_TYPE_MECHANICAL2 = 4;
  
  public static final int STEER_WHEEL_TYPE_MECHANICAL_WITH_PADDLE = 5;
  
  public static final int STEER_WHEEL_TYPE_MOVING = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-21", project = "DHU")
  int getCustomFunctionType();
  
  long getInputSettingDuration(int paramInt);
  
  int getInputSettingValue(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-21", project = "DHU")
  int getSteerWheelType();
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-5-21", project = "DHU", requirement = "")
  public static @interface CustomFunctionType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DurationType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InputSetting {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-5-21", project = "DHU")
  public static @interface SteerWheelType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\input\IInputSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */