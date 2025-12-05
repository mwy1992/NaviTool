package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IBcm {
  public static final int ANTI_PINCH_DETECTED = 1;
  
  public static final int ANTI_PINCH_NORMAL = 0;
  
  @VendorDefinition(author = "@ECARX", date = "2021-11-05", project = "EF1E")
  public static final int BCM_FUNC_ALL_DOORS_ONE_KEY_SWITCH = 554763520;
  
  @VendorDefinition(author = "@ECARX", date = "2021-07-23", project = "EF1E")
  public static final int BCM_FUNC_ALL_READING_LIGHTS_SWITCH = 554763008;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-26", project = "EF1E")
  public static final int BCM_FUNC_AUTO_CLOSE_DOOR_BY_SPEED_SWITCH = 554763264;
  
  public static final int BCM_FUNC_CHARGING_CAP = 553780480;
  
  public static final int BCM_FUNC_CHILD_SAFETY_LOCK = 553780224;
  
  @VendorDefinition(author = "@ECARX", date = "2021-7-16", project = "EX11")
  public static final int BCM_FUNC_CHILD_SAFETY_LOCK_FOR_SCENE_MODE = 553780992;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E", requirement = "")
  public static final int BCM_FUNC_CSD_CONTROL_CUTOFF_LOCK = 553845249;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-29", project = "ALL", requirement = "")
  public static final int BCM_FUNC_CUSTOM_KEY = 554762496;
  
  public static final int BCM_FUNC_DISPLAY_ONOFF = 554697216;
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-23", project = "lambda")
  public static final int BCM_FUNC_DISPLAY_POSITION = 554764032;
  
  public static final int BCM_FUNC_DOOR = 553779456;
  
  public static final int BCM_FUNC_DOOR_ANTI_PINCH = 553785600;
  
  public static final int BCM_FUNC_DOOR_CONTROL = 553783296;
  
  public static final int BCM_FUNC_DOOR_LOCK = 553779712;
  
  public static final int BCM_FUNC_DOOR_OBSTACLE_DETECTED = 553785344;
  
  public static final int BCM_FUNC_DOOR_POS = 553779968;
  
  @VendorDefinition(author = "@ECARX", date = "2021-07-23", project = "smart/lotus")
  public static final int BCM_FUNC_DOOR_STATUS = 553785856;
  
  public static final int BCM_FUNC_FOLD_REAR_MIRROR = 554041600;
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-25", project = "lambda")
  public static final int BCM_FUNC_FOLD_REAR_MIRROR_DEFROST = 554763776;
  
  public static final int BCM_FUNC_FUEL_CAP = 553780736;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-10", project = "lambda")
  public static final int BCM_FUNC_ICC_NOTIFICATION = 554764288;
  
  public static final int BCM_FUNC_LIGHT_ALL_WEATHER_LIGHT = 553981440;
  
  public static final int BCM_FUNC_LIGHT_ATMOSPHERE_LAMPS = 553979904;
  
  public static final int BCM_FUNC_LIGHT_CORNERING_LAMPS = 553977344;
  
  public static final int BCM_FUNC_LIGHT_DAYTIME_RUNNING_LAMPS = 553978112;
  
  public static final int BCM_FUNC_LIGHT_DIM_DIP_LAMPS = 553978368;
  
  public static final int BCM_FUNC_LIGHT_DIPPED_BEAM = 553976064;
  
  public static final int BCM_FUNC_LIGHT_DRIVING_LAMPS = 553976576;
  
  public static final int BCM_FUNC_LIGHT_FRONT_FOG_LAMPS = 553976832;
  
  public static final int BCM_FUNC_LIGHT_FRONT_POSITION_LAMPS = 553977856;
  
  public static final int BCM_FUNC_LIGHT_GRILLE_LAMP = 553981184;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-01", project = "SMART", requirement = "")
  public static final int BCM_FUNC_LIGHT_GRILLE_LAMP_COLOR = 553983488;
  
  public static final int BCM_FUNC_LIGHT_HAZARD_FLASHERS = 553979648;
  
  public static final int BCM_FUNC_LIGHT_LEFT_TRUN_SIGNAL = 553980160;
  
  public static final int BCM_FUNC_LIGHT_MAIN_BEAM = 553976320;
  
  public static final int BCM_FUNC_LIGHT_NUMBER_PLATE_LIGHT = 553981696;
  
  public static final int BCM_FUNC_LIGHT_READING_LIGHT = 553980672;
  
  public static final int BCM_FUNC_LIGHT_REAR_FOG_LAMPS = 553977088;
  
  public static final int BCM_FUNC_LIGHT_REAR_LOGO_LIGHT = 553980928;
  
  public static final int BCM_FUNC_LIGHT_REAR_POSITION_LAMPS = 553978880;
  
  public static final int BCM_FUNC_LIGHT_REVERSING_LAMPS = 553979392;
  
  public static final int BCM_FUNC_LIGHT_RIGHT_TRUN_SIGNAL = 553980416;
  
  public static final int BCM_FUNC_LIGHT_SIDE_MARKER_LIGHTS = 553978624;
  
  public static final int BCM_FUNC_LIGHT_SPOT_LIGHTS = 553977600;
  
  public static final int BCM_FUNC_LIGHT_STOP_LAMPS = 553979136;
  
  public static final int BCM_FUNC_LIGHT_WELCOME_LIGHT = 553981952;
  
  public static final int BCM_FUNC_POWER_ONOFF = 554696960;
  
  public static final int BCM_FUNC_REAR_MIRROR_ADJUST = 554041856;
  
  public static final int BCM_FUNC_STEERING_WHEEL_ADJUST = 554107136;
  
  public static final int BCM_FUNC_SUNROOF_TILT = 553845760;
  
  public static final int BCM_FUNC_WASHER = 553910528;
  
  public static final int BCM_FUNC_WINDOW = 553844992;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-11", project = "EX11")
  public static final int BCM_FUNC_WINDOW_CURRENT_POS = 553846272;
  
  public static final int BCM_FUNC_WINDOW_LOCK = 553845248;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-01", project = "EX11", requirement = "")
  public static final int BCM_FUNC_WINDOW_MOVING_STATE = 554762752;
  
  public static final int BCM_FUNC_WINDOW_POS = 553845504;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E", requirement = "")
  public static final int BCM_FUNC_WINDOW_SYNC_SWITCH = 553846017;
  
  public static final int BCM_FUNC_WINDOW_TRANSPARENCY = 553846016;
  
  public static final int BCM_FUNC_WIPER = 553713920;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-29", project = "ALL", requirement = "")
  public static final int CUSTOM_KEY_TYPE_360_PANORAMA = 1;
  
  @VendorDefinition(author = "@ECARX", date = "2020-10-12", project = "ALL", requirement = "")
  public static final int CUSTOM_KEY_TYPE_COLLECT_FAV = 5;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-29", project = "ALL", requirement = "")
  public static final int CUSTOM_KEY_TYPE_DIM_FULL_SCREEN_MAP = 3;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-29", project = "ALL", requirement = "")
  public static final int CUSTOM_KEY_TYPE_DVR = 0;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-29", project = "ALL", requirement = "")
  public static final int CUSTOM_KEY_TYPE_NAVIGATION = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-29", project = "ALL", requirement = "")
  public static final int CUSTOM_KEY_TYPE_SOUND_SWITCH = 4;
  
  @VendorDefinition(author = "@GEELY", date = "2022-11-02", project = "ALL", requirement = "")
  public static final int CUSTOM_KEY_TYPE_UNLCKTRUNK = 6;
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-23", project = "Lambda", requirement = "")
  public static final int DISPLAY_POSITION_A = 554764033;
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-23", project = "Lambda", requirement = "")
  public static final int DISPLAY_POSITION_B = 554764034;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "Lambda", requirement = "")
  public static final int DISPLAY_POSITION_IDLE = 554764032;
  
  public static final int DOOR_CLOSE = 0;
  
  public static final int DOOR_OBSTACLE_DETECTED = 1;
  
  public static final int DOOR_OBSTACLE_NORMAL = 0;
  
  public static final int DOOR_OPEN = 1;
  
  public static final int DOOR_PAUSE = 553779457;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-01", project = "SMART", requirement = "")
  public static final int GRILLE_LAMP_COLOR_1 = 553983489;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-01", project = "SMART", requirement = "")
  public static final int GRILLE_LAMP_COLOR_2 = 553983490;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-01", project = "SMART", requirement = "")
  public static final int GRILLE_LAMP_COLOR_3 = 553983491;
  
  public static final int WINDOW_CLOSE = 0;
  
  @VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL")
  public static final int WINDOW_CLOSE_PAUSE = 553844996;
  
  public static final int WINDOW_HALF = 553844994;
  
  public static final int WINDOW_OPEN = 1;
  
  @VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL")
  public static final int WINDOW_OPEN_PAUSE = 553844995;
  
  public static final int WINDOW_PAUSE = 553844993;
  
  public static final int WIPER_GEAR_AUTO = 553713921;
  
  public static final int WIPER_GEAR_HIGHT = 553713923;
  
  public static final int WIPER_GEAR_INTERMITTENT = 553713924;
  
  public static final int WIPER_GEAR_LOW = 553713922;
  
  public static final int WIPER_GEAR_OFF = 0;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AntiPinchDetected {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BcmFunction {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CustomKeyType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DisplayPositions {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DoorControlType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DoorObstacleDetected {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GrilleLampColor {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ICCNotifyValue {
    @VendorDefinition(author = "@ECARX", date = "2022-08-10", project = "Lambda", requirement = "")
    public static final int ERROR = 554764293;
    
    @VendorDefinition(author = "@ECARX", date = "2022-08-10", project = "Lambda", requirement = "")
    public static final int NORMAL = 554764288;
    
    @VendorDefinition(author = "@ECARX", date = "2022-08-10", project = "Lambda", requirement = "")
    public static final int WARNING = 554764292;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WindowControlType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WiperGearMode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IBcm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */