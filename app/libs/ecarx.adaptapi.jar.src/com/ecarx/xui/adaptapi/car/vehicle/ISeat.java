package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ISeat {
  @VendorDefinition(author = "@ECARX", date = "2022-01-12", project = "smart", requirement = "")
  public static final int SCENE_FUNC_SEAT_REST_PATTERN_OFF_REASON = 792789264;
  
  public static final int SEAT_BACKREST_BACKWARD = 755171842;
  
  public static final int SEAT_BACKREST_FORWARD = 755171841;
  
  public static final int SEAT_BACKREST_OFF = 0;
  
  public static final int SEAT_BACKREST_SIDE_ADJUST = 759236611;
  
  public static final int SEAT_BACKREST_SIDE_SUPPORT_BACKWARD = 755237378;
  
  public static final int SEAT_BACKREST_SIDE_SUPPORT_FORWARD = 755237377;
  
  public static final int SEAT_BACKREST_SIDE_SUPPORT_OFF = 0;
  
  public static final int SEAT_BACK_SHOULDER_ADJUST_BACK = 759236866;
  
  public static final int SEAT_BACK_SHOULDER_ADJUST_FWD = 759236865;
  
  public static final int SEAT_BACK_SHOULDER_ADJUST_IDLE = 759236864;
  
  public static final int SEAT_CUSHION_ADJUST = 759236610;
  
  public static final int SEAT_CUSHION_EXTENSION_BACKWARD = 755433730;
  
  public static final int SEAT_CUSHION_EXTENSION_FORWARD = 755433729;
  
  public static final int SEAT_CUSHION_EXTENSION_OFF = 0;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-02", project = "V216", requirement = "")
  public static final int SEAT_CUSHION_POSITION_ADJUST = 759236614;
  
  public static final int SEAT_CUSHION_SIDE_SUPPORT_DOWN = 755237122;
  
  public static final int SEAT_CUSHION_SIDE_SUPPORT_OFF = 0;
  
  public static final int SEAT_CUSHION_SIDE_SUPPORT_UP = 755237121;
  
  public static final int SEAT_CUSHION_TILT_DOWN = 755171586;
  
  public static final int SEAT_CUSHION_TILT_OFF = 0;
  
  public static final int SEAT_CUSHION_TILT_UP = 755171585;
  
  public static final int SEAT_FOLD_STATE = 759236353;
  
  public static final int SEAT_HDREST_HEI_AND_HDREST_TILT_ADJUST = 759236613;
  
  public static final int SEAT_HEADREST_HEIGHT_DOWN = 755302658;
  
  public static final int SEAT_HEADREST_HEIGHT_OFF = 0;
  
  public static final int SEAT_HEADREST_HEIGHT_UP = 755302657;
  
  public static final int SEAT_HEADREST_TILT_BACKWARD = 755302914;
  
  public static final int SEAT_HEADREST_TILT_FORWARD = 755302913;
  
  public static final int SEAT_HEADREST_TILT_OFF = 0;
  
  public static final int SEAT_HEIGHT_DOWN = 755106306;
  
  public static final int SEAT_HEIGHT_OFF = 0;
  
  public static final int SEAT_HEIGHT_UP = 755106305;
  
  public static final int SEAT_IDLE_STATE = 759236355;
  
  public static final int SEAT_KNOB_DOWN = 759237633;
  
  public static final int SEAT_KNOB_IDEL = 759237635;
  
  public static final int SEAT_KNOB_UP = 759237634;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-02", project = "V216", requirement = "")
  public static final int SEAT_LEG_SUPPORT_ADJUST = 759236615;
  
  public static final int SEAT_LEG_SUPPORT_HEIGHT_DOWN = 755499266;
  
  public static final int SEAT_LEG_SUPPORT_HEIGHT_OFF = 0;
  
  public static final int SEAT_LEG_SUPPORT_HEIGHT_UP = 755499265;
  
  public static final int SEAT_LEG_SUPPORT_LENGTH_BACKWARD = 755499522;
  
  public static final int SEAT_LEG_SUPPORT_LENGTH_FORWARD = 755499521;
  
  public static final int SEAT_LEG_SUPPORT_LENGTH_OFF = 0;
  
  public static final int SEAT_LENGTH_BACKWARD = 755106050;
  
  public static final int SEAT_LENGTH_FORWARD = 755106049;
  
  public static final int SEAT_LENGTH_OFF = 0;
  
  public static final int SEAT_LUMBAR_ADJUST = 759236609;
  
  public static final int SEAT_LUMBAR_EXTENDED_BACKWARD = 755368450;
  
  public static final int SEAT_LUMBAR_EXTENDED_FORWARD = 755368449;
  
  public static final int SEAT_LUMBAR_EXTENDED_OFF = 0;
  
  public static final int SEAT_LUMBAR_HEIGHT_DOWN = 755368194;
  
  public static final int SEAT_LUMBAR_HEIGHT_OFF = 0;
  
  public static final int SEAT_LUMBAR_HEIGHT_UP = 755368193;
  
  public static final int SEAT_MASSAGE_ADJUST = 759236612;
  
  public static final int SEAT_MENU_POSITION_HORIZONTAL_LEFT = 759237377;
  
  public static final int SEAT_MENU_POSITION_HORIZONTAL_OFF = 0;
  
  public static final int SEAT_MENU_POSITION_HORIZONTAL_RIGHT = 759237378;
  
  public static final int SEAT_MENU_POSITION_VERTICAL_DOWN = 759237122;
  
  public static final int SEAT_MENU_POSITION_VERTICAL_OFF = 0;
  
  public static final int SEAT_MENU_POSITION_VERTICAL_UP = 759237121;
  
  public static final int SEAT_POSITION_SAVED_1 = 759169281;
  
  public static final int SEAT_POSITION_SAVED_2 = 759169282;
  
  public static final int SEAT_POSITION_SAVED_3 = 759169283;
  
  public static final int SEAT_POSITION_SAVED_4 = 759169284;
  
  public static final int SEAT_POSITION_SAVED_5 = 759169285;
  
  public static final int SEAT_POSITION_SAVED_6 = 759169286;
  
  public static final int SEAT_POSITION_SAVED_7 = 759169287;
  
  public static final int SEAT_POSITION_SAVED_8 = 759169288;
  
  public static final int SEAT_POSITION_SAVED_OFF = 0;
  
  public static final int SEAT_RAISE_STATE = 759236354;
  
  public static final int SEAT_SUPPORT_CONTROL_MODE_LONG_PRESS = 755040769;
  
  public static final int SEAT_SUPPORT_CONTROL_MODE_LONG_SHORT_PRESS = 755040771;
  
  public static final int SEAT_SUPPORT_CONTROL_MODE_SHORT_PRESS = 755040770;
  
  public static final int SEAT_UNKNOWN_STATE = 0;
  
  public static final int SETTING_FUNC_DRIVER_CONTROL_PASSENGER_SEAT = 755040512;
  
  public static final int SETTING_FUNC_EASY_INGRESS_EGRESS = 538378496;
  
  public static final int SETTING_FUNC_EASY_INGRESS_EGRESS_MODE = 538378752;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-20", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_LOCK_UNLOCK_CEREMONY = 759237888;
  
  @VendorDefinition(author = "@ECARX", date = "2021-07-13", project = "EX11", requirement = "")
  public static final int SETTING_FUNC_MULTI_SEAT_MENU = 759236608;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-03", project = "EX11", requirement = "")
  public static final int SETTING_FUNC_MULTI_SEAT_MENU_HORIZONTAL_POSITION = 759237376;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-03", project = "EX11", requirement = "")
  public static final int SETTING_FUNC_MULTI_SEAT_MENU_VERTICAL_POSITION = 759237120;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-20", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_REAR_ROW_SECURITY_MODE = 759238144;
  
  public static final int SETTING_FUNC_SEAT_BACKREST = 755171840;
  
  public static final int SETTING_FUNC_SEAT_BACKREST_POS = 755172352;
  
  public static final int SETTING_FUNC_SEAT_BACKREST_SIDE_SUPPORT = 755237376;
  
  @VendorDefinition(author = "@ECARX", date = "2021-07-27", project = "Lambda", requirement = "")
  public static final int SETTING_FUNC_SEAT_BACK_SHOULDER = 759236864;
  
  public static final int SETTING_FUNC_SEAT_BOSS_KEY = 759235072;
  
  public static final int SETTING_FUNC_SEAT_CUSHION_EXTENSION = 755433728;
  
  public static final int SETTING_FUNC_SEAT_CUSHION_SIDE_SUPPORT = 755237120;
  
  public static final int SETTING_FUNC_SEAT_CUSHION_TILT = 755171584;
  
  public static final int SETTING_FUNC_SEAT_CUSHION_TILT_POS = 755172096;
  
  @VendorDefinition(author = "@ECARX", date = "2022-5-19", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_SEAT_EXCLUSIVE_TWO = 759239424;
  
  @VendorDefinition(author = "@ECARX", date = "2022-5-19", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_SEAT_EXCLUSIVE_VIP = 759239168;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-11", project = "EX11", requirement = "")
  public static final int SETTING_FUNC_SEAT_FOLD = 759236352;
  
  public static final int SETTING_FUNC_SEAT_HEADREST_HEIGHT = 755302656;
  
  public static final int SETTING_FUNC_SEAT_HEADREST_HEIGHT_POS = 755303168;
  
  public static final int SETTING_FUNC_SEAT_HEADREST_TILT = 755302912;
  
  public static final int SETTING_FUNC_SEAT_HEADREST_TILT_POS = 755303424;
  
  public static final int SETTING_FUNC_SEAT_HEIGHT = 755106304;
  
  public static final int SETTING_FUNC_SEAT_HEIGHT_POS = 755106816;
  
  @VendorDefinition(author = "@ECARX", date = "2021-05-14", project = "EX11")
  public static final int SETTING_FUNC_SEAT_HOT_STONE_MASSAGE = 759236096;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-06", project = "EX11", requirement = "")
  public static final int SETTING_FUNC_SEAT_KNOB = 759237632;
  
  public static final int SETTING_FUNC_SEAT_LEG_SUPPORT_HEIGHT = 755499264;
  
  public static final int SETTING_FUNC_SEAT_LEG_SUPPORT_HEIGHT_POS = 755499776;
  
  public static final int SETTING_FUNC_SEAT_LEG_SUPPORT_LENGTH = 755499520;
  
  public static final int SETTING_FUNC_SEAT_LEG_SUPPORT_LENGTH_POS = 755500032;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-07", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_SEAT_LEG_SUPPORT_SIDE_LENGTH = 755499520;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-07", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_SEAT_LEG_SUPPORT_SIDE_LENGTH_POS = 755500033;
  
  public static final int SETTING_FUNC_SEAT_LENGTH = 755106048;
  
  public static final int SETTING_FUNC_SEAT_LENGTH_POS = 755106560;
  
  public static final int SETTING_FUNC_SEAT_LUMBAR_EXTENDED = 755368448;
  
  public static final int SETTING_FUNC_SEAT_LUMBAR_HEIGHT = 755368192;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-03", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_SEAT_NUM = 759238400;
  
  public static final int SETTING_FUNC_SEAT_ONE_KEY_BED = 759235328;
  
  @VendorDefinition(author = "@ECARX", date = "2022-3-25", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_SEAT_ONE_KEY_COMFORT = 759238912;
  
  public static final int SETTING_FUNC_SEAT_POSITION_SAVE = 759169280;
  
  public static final int SETTING_FUNC_SEAT_POSITION_SET = 759169536;
  
  public static final int SETTING_FUNC_SEAT_POSITION_SET_MEMBTN1 = 1;
  
  public static final int SETTING_FUNC_SEAT_POSITION_SET_MEMBTN2 = 2;
  
  public static final int SETTING_FUNC_SEAT_POSITION_SET_MEMBTN3 = 3;
  
  public static final int SETTING_FUNC_SEAT_POSITION_SET_NO = 0;
  
  @VendorDefinition(author = "@ECARX", date = "2022-7-20", project = "EF1E", requirement = "")
  public static final int SETTING_FUNC_SEAT_RESTORE = 759169792;
  
  public static final int SETTING_FUNC_SEAT_REST_PATTERN = 759234816;
  
  public static final int SETTING_FUNC_SEAT_REST_PATTERN_ALARM = 759235584;
  
  public static final int SETTING_FUNC_SEAT_REST_PATTERN_ALARM_TIME = 759235840;
  
  public static final int SETTING_FUNC_SEAT_SUPPORT_CONTROL_MODE = 755040768;
  
  public static @interface RearRowSecurity {
    public static final int LEFT_OFF = 759238146;
    
    public static final int LEFT_ON = 759238145;
    
    public static final int RIGHT_OFF = 759238148;
    
    public static final int RIGHT_ON = 759238147;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-07-27", project = "EX11", requirement = "")
  public static @interface SeatBackShoulderAjustment {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatBackrestMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatBackrestSideSupportMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatComfortMode {
    public static final int SEAT_COMFORT = 759238914;
    
    public static final int SEAT_IDLE = 759238913;
    
    public static final int SEAT_RECOVERY = 759238915;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatCushionExtensionMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatCushionSideSupportMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatCushionTiltMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "Lambda")
  public static @interface SeatFoldRaiseReqMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatHeadrestHeightMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatHeadrestLengthMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatHeigthMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-08-03", project = "EX11", requirement = "")
  public static @interface SeatHorizontalPosition {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-08-06", project = "EX11")
  public static @interface SeatKnobMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatLegSupportHeightMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatLegSupportLengthMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatLengthMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatLumbarExtendedMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatLumbarHeightMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-07-13", project = "EX11", requirement = "")
  public static @interface SeatModeSelection {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2022-08-11", project = "CX11")
  public static @interface SeatPosition {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatPositionSavedMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatRestOffReasonMode {
    public static final int NON_P = 792789265;
    
    public static final int USAGE_MODE_CHANGE = 792789266;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatSupportControlMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-08-03", project = "EX11", requirement = "")
  public static @interface seatVerticalPosition {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\ISeat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */