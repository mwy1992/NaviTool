package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDayMode {
  public static final int DAYMODE_SETTING_BRIGHTNESS_AUTO = 538247427;
  
  public static final int DAYMODE_SETTING_BRIGHTNESS_DAY = 538247425;
  
  public static final int DAYMODE_SETTING_BRIGHTNESS_NIGHT = 538247426;
  
  public static final int DAYMODE_SETTING_BRIGHTNESS_OFF = 0;
  
  public static final int SETTING_FUNC_BACKLIGHT_LINKAGE = 687931648;
  
  public static final int SETTING_FUNC_BRIGHTNESS_BACKLIGHT = 687997184;
  
  public static final int SETTING_FUNC_BRIGHTNESS_BACKLIGHT_MAX = 687997440;
  
  public static final int SETTING_FUNC_BRIGHTNESS_BACKLIGHT_MIN = 687997696;
  
  public static final int SETTING_FUNC_BRIGHTNESS_BACKLIGHT_STEP = 687997952;
  
  @Deprecated
  public static final int SETTING_FUNC_BRIGHTNESS_DAY = 538247936;
  
  @VendorDefinition(author = "@ECARX", date = "2021-8-16", project = "EX11")
  public static final int SETTING_FUNC_BRIGHTNESS_DAYMODE = 688062976;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_DIM = 687998208;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_DIM_MAX = 687998464;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_DIM_MIN = 687998720;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_DIM_STEP = 687998976;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_FLOODLIGHT = 687999232;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_FLOODLIGHT_MAX = 687999488;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_FLOODLIGHT_MIN = 687999744;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_BRIGHTNESS_FLOODLIGHT_STEP = 688000000;
  
  public static final int SETTING_FUNC_BRIGHTNESS_MAX = 538248448;
  
  public static final int SETTING_FUNC_BRIGHTNESS_MIN = 538248704;
  
  public static final int SETTING_FUNC_BRIGHTNESS_NIGHT = 538248192;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-14")
  public static final int SETTING_FUNC_BRIGHTNESS_SCREEN = 688063744;
  
  public static final int SETTING_FUNC_BRIGHTNESS_STEP = 538248960;
  
  @VendorDefinition(author = "@ECARX", date = "2021-9-1", project = "EX11")
  public static final int SETTING_FUNC_CUSTOM_DAY_TIME = 688063232;
  
  @VendorDefinition(author = "@ECARX", date = "2021-9-1", project = "EX11")
  public static final int SETTING_FUNC_CUSTOM_NIGHT_TIME = 688063488;
  
  public static final int SETTING_FUNC_DAYMODE_SETTING = 538247424;
  
  public static final int SETTING_FUNC_DAYMODE_SYNC = 538247680;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_ELECTRIC_REAR_VIEW_MIRROR_DISPLAYS = 688000256;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_ELECTRIC_REAR_VIEW_MIRROR_DISPLAYS_MAX = 688000768;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_ELECTRIC_REAR_VIEW_MIRROR_DISPLAYS_MIN = 688000512;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-7", project = "Lambda")
  public static final int SETTING_FUNC_ELECTRIC_REAR_VIEW_MIRROR_DISPLAYS_STEP = 688062720;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-07")
  public static final int SETTING_FUNC_SUN_TIME = 688064000;
  
  @Deprecated
  @VendorDefinition(author = "@ECARX", date = "2021-8-16", project = "EX11")
  float[] getCustomDayNightTimeSetting();
  
  @Deprecated
  @VendorDefinition(author = "@ECARX", date = "2021-8-16", project = "EX11")
  boolean setCustomDayNightTimeSetting(float[] paramArrayOffloat);
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-8-16", project = "EX11")
  public static @interface DayModeBrightnessSettings {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DayModeFunction {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IDayMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */