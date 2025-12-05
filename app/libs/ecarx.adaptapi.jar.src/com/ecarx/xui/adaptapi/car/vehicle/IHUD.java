package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IHUD {
  public static final int SETTING_FUNC_HUD_ACTIVE = 537985280;
  
  public static final int SETTING_FUNC_HUD_ANGLE_ADJUST = 654378752;
  
  @VendorDefinition(author = "@ECARX", date = "2021-11-17", project = "lambda")
  public static final int SETTING_FUNC_HUD_ANGLE_CHANGE = 654379520;
  
  public static final int SETTING_FUNC_HUD_ANGLE_RESET = 654379008;
  
  public static final int SETTING_FUNC_HUD_AR_ENGINE = 654443008;
  
  public static final int SETTING_FUNC_HUD_BRIGHTNESS = 654377216;
  
  public static final int SETTING_FUNC_HUD_BRIGHTNESS_ADJUST = 654378240;
  
  @VendorDefinition(author = "@ECARX", date = "2021-11-17", project = "lambda")
  public static final int SETTING_FUNC_HUD_BRIGHTNESS_CHANGE = 654379776;
  
  public static final int SETTING_FUNC_HUD_BRIGHTNESS_MAX = 654377472;
  
  public static final int SETTING_FUNC_HUD_BRIGHTNESS_MIN = 654377728;
  
  public static final int SETTING_FUNC_HUD_BRIGHTNESS_STEP = 654377984;
  
  public static final int SETTING_FUNC_HUD_CALIBRATION = 537985536;
  
  public static final int SETTING_FUNC_HUD_DISPLAY_BTPHONE = 654509056;
  
  public static final int SETTING_FUNC_HUD_DISPLAY_DRIVE_ENVIRONMENT = 654509312;
  
  public static final int SETTING_FUNC_HUD_DISPLAY_MEIDA = 654508544;
  
  public static final int SETTING_FUNC_HUD_DISPLAY_NAVI = 654508800;
  
  public static final int SETTING_FUNC_HUD_DISPLAY_SAFETY = 654508288;
  
  public static final int SETTING_FUNC_HUD_POSITION_ADJUST = 654378496;
  
  @VendorDefinition(author = "@ECARX", date = "2021-11-17", project = "lambda")
  public static final int SETTING_FUNC_HUD_POSITION_CHANGE = 654379264;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "LAMBDA")
  public static final int SETTING_FUNC_HUD_ROUTE_GUIDANCE = 654443520;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "LAMBDA")
  public static final int SETTING_FUNC_HUD_SEMI_AR_ENGINE = 654443264;
  
  public static final int SETTING_FUNC_HUD_SNOW_MODE = 654442752;
  
  public static final int SETTING_FUNC_LOCK_RFDM_REMOTE_CONTROLLER = 538707968;
  
  public static final int SETTING_FUNC_RFDM_AUTO_FOLD = 655360512;
  
  public static final int SETTING_FUNC_RFDM_POSITION = 655360768;
  
  public static final int SETTING_FUNC_RFDM_POSITION_ADJUST = 655361024;
  
  public static final int SETTING_FUNC_RFDM_POSITION_LEVEL = 655362048;
  
  public static final int SETTING_FUNC_RFDM_POSITION_MAX = 655361536;
  
  public static final int SETTING_FUNC_RFDM_POSITION_MIN = 655361280;
  
  public static final int SETTING_FUNC_RFDM_POSITION_STEP = 655361792;
  
  public static final int SETTING_FUNC_RFDM_SWITCH = 655360256;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HUDFunction {}
  
  public static @interface HudAngleChange {
    public static final int ANTI_CLOCKWISE = 654379522;
    
    public static final int CLOCKWISE = 654379521;
  }
  
  public static @interface HudBrightnessChange {
    public static final int DECREASE = 654379777;
    
    public static final int INCREASE = 654379778;
  }
  
  public static @interface HudPositionChange {
    public static final int POSITION_DOWN = 654379266;
    
    public static final int POSITION_UP = 654379265;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RFDMPositionLevel {
    public static final int RFDM_POSITION_LEVEL_1 = 655362049;
    
    public static final int RFDM_POSITION_LEVEL_2 = 655362050;
    
    public static final int RFDM_POSITION_LEVEL_3 = 655362051;
    
    public static final int RFDM_POSITION_LEVEL_4 = 655362052;
    
    public static final int RFDM_POSITION_LEVEL_5 = 655362053;
    
    public static final int RFDM_POSITION_LEVEL_NONE = 0;
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IHUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */