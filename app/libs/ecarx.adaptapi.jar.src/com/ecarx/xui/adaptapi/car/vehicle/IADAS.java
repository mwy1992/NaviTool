package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IADAS {
  public static final int AI_ASSIST_LANE_CHANGE_STRATEGY_GENTLE = 671614209;
  
  public static final int AI_ASSIST_LANE_CHANGE_STRATEGY_OFF = 0;
  
  public static final int AI_ASSIST_LANE_CHANGE_STRATEGY_RADICAL = 671614211;
  
  public static final int AI_ASSIST_LANE_CHANGE_STRATEGY_STANDARD = 671614210;
  
  public static final int AI_ASSIST_LANE_CHANGE_WARNING_BOTH = 671614723;
  
  public static final int AI_ASSIST_LANE_CHANGE_WARNING_OFF = 0;
  
  public static final int AI_ASSIST_LANE_CHANGE_WARNING_VIBRATE = 671614722;
  
  public static final int AI_ASSIST_LANE_CHANGE_WARNING_VOICE = 671614721;
  
  public static final int PDC_WARNING_VOLUME_HIGH = 671416579;
  
  public static final int PDC_WARNING_VOLUME_LOW = 671416577;
  
  public static final int PDC_WARNING_VOLUME_MID = 671416578;
  
  public static final int PDC_WARNING_VOLUME_OFF = 0;
  
  public static final int SETTING_FUNC_ACC_WITH_TSR = 671482624;
  
  public static final int SETTING_FUNC_ADAS_ADAPTIVE_CRUISE_FAILURE = 671618816;
  
  public static final int SETTING_FUNC_ADAS_DRIVER_FATIGUE_DETECTION_FAILURE = 671619328;
  
  public static final int SETTING_FUNC_ADAS_EMERGENCY_LANE_OCCUPANCY_ALERT_FAILURE = 671617792;
  
  public static final int SETTING_FUNC_ADAS_EMERGENCY_STEERING_ASSIST_FAILURE = 671618048;
  
  public static final int SETTING_FUNC_ADAS_FORWARD_PRECOLLISION_ASSIST_FAULT = 671618304;
  
  public static final int SETTING_FUNC_ADAS_FRONT_SIDE_ASSIST_FAILURE = 671618560;
  
  public static final int SETTING_FUNC_ADAS_LANE_KEEPING_ASSISTANCE_FAILURE = 671617536;
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-6", project = "FX11", requirement = "Default OFF")
  public static final int SETTING_FUNC_ADAS_PADDLE_LANE_CHANGE_ASSIST = 671619840;
  
  public static final int SETTING_FUNC_ADAS_REAR_COLLISION_WARNING_FAILURE = 671619072;
  
  public static final int SETTING_FUNC_ADAS_TRAFFIC_LIGHTS_IDENTIFY_FAULTS = 671619584;
  
  public static final int SETTING_FUNC_ADAS_TRAFFIC_SIGN_INFORMATION_FAILURE = 671617280;
  
  public static final int SETTING_FUNC_AI_ASSIST_DEFAULT_ON = 671613440;
  
  public static final int SETTING_FUNC_AI_ASSIST_FUSION_NAVI = 671613696;
  
  public static final int SETTING_FUNC_AI_ASSIST_LANE_CHANGE_CONFIRM = 671614464;
  
  public static final int SETTING_FUNC_AI_ASSIST_LANE_CHANGE_STRATEGY = 671614208;
  
  public static final int SETTING_FUNC_AI_ASSIST_LANE_CHANGE_WARNING = 671614720;
  
  public static final int SETTING_FUNC_AI_ASSIST_OUT_OVERTAKING_LANE = 671613952;
  
  public static final int SETTING_FUNC_AI_DRIVER_ASSIST = 671613184;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11")
  public static final int SETTING_FUNC_APA_TTS_VOICE_PROMPT_REQ = 671744256;
  
  public static final int SETTING_FUNC_APB_MODE = 671615488;
  
  public static final int SETTING_FUNC_APB_SWITCH = 671615232;
  
  public static final int SETTING_FUNC_AUTONOMOUS_EMERGENCY_BRAKING = 537333248;
  
  public static final int SETTING_FUNC_AUTONOMOUS_EMERGENCY_BRAKING_WARN = 537333249;
  
  public static final int SETTING_FUNC_AUTO_LANE_CHANGE_ASSIST = 671351040;
  
  public static final int SETTING_FUNC_BIG_DATA_SPEED_LIMIT = 671484416;
  
  public static final int SETTING_FUNC_BLIND_SPOT_DETECTION = 671547648;
  
  public static final int SETTING_FUNC_BLIND_SPOT_DETECTION_WARNING = 671547904;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
  public static final int SETTING_FUNC_CAR_HORIZON_CONTROL = 671549184;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
  public static final int SETTING_FUNC_CAR_VERTICAL_CONTROL = 671549440;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "EF1E")
  public static final int SETTING_FUNC_COLLISION_WARN_STATUS = 671550720;
  
  public static final int SETTING_FUNC_DOOR_OPEN_WARN_ACTIVE = 538050816;
  
  public static final int SETTING_FUNC_DOOR_OPEN_WARN_VOLUME = 538051072;
  
  public static final int SETTING_FUNC_DOW_WARNING_STATUS = 671416832;
  
  public static final int SETTING_FUNC_DRIVER_PERFOR_SUPPORT = 537003520;
  
  public static final int SETTING_FUNC_DRIVER_PERFOR_SUPPORT_REMINDER = 671219968;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
  public static final int SETTING_FUNC_DRIVE_NZP_STATUS = 671549696;
  
  public static final int SETTING_FUNC_DRIVE_PILOT = 671548416;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
  public static final int SETTING_FUNC_DRIVE_PILOT_ACC_LCC_SWITCH = 671550208;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
  public static final int SETTING_FUNC_DRIVE_PILOT_ALARM_INFO = 671549952;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-09", project = "EF1E")
  public static final int SETTING_FUNC_DRIVE_PILOT_ALARM_INFO_CANCEL = 671554048;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
  public static final int SETTING_FUNC_DRIVE_PILOT_STATUS = 671548672;
  
  public static final int SETTING_FUNC_ELE_SEATBELT_COMFORT = 537333504;
  
  public static final int SETTING_FUNC_EMGY_LANE_KEEP_AID = 537331200;
  
  public static final int SETTING_FUNC_EMGY_LANE_OCC_WARNING = 537332480;
  
  public static final int SETTING_FUNC_EVASIVE_MANEUVER_AID = 537332736;
  
  public static final int SETTING_FUNC_FORWARD_COLLISION_WARN = 537788672;
  
  public static final int SETTING_FUNC_FORWARD_COLLISION_WARN_SNVTY = 537788928;
  
  public static final int SETTING_FUNC_FRONT_CROSS_TRAFFIC_ALERT = 537331968;
  
  public static final int SETTING_FUNC_HDC_SWITCH = 537265408;
  
  public static final int SETTING_FUNC_LANE_CHANGE_ASSIST = 537331456;
  
  public static final int SETTING_FUNC_LANE_CHANGE_ASSIST_WARNING = 671351296;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-20", project = "EF1E")
  public static final int SETTING_FUNC_LANE_CHANGE_STATUS = 671550464;
  
  public static final int SETTING_FUNC_LANE_CHANGE_WARING = 537330432;
  
  public static final int SETTING_FUNC_LANE_CHANGE_WARNING_MODE = 537330704;
  
  public static final int SETTING_FUNC_LANE_CHANGE_WARNING_SOUND = 537330688;
  
  public static final int SETTING_FUNC_LANE_DEPARTURE_WARNING = 671285504;
  
  public static final int SETTING_FUNC_LANE_KEEPING_AID = 537329920;
  
  public static final int SETTING_FUNC_LANE_KEEPING_AID_MODE = 537330176;
  
  public static final int SETTING_FUNC_LANE_KEEPING_AID_WARNING = 537330944;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
  public static final int SETTING_FUNC_MAX_CRUISING_SPEED = 671548928;
  
  public static final int SETTING_FUNC_NOP_SPEED_LIMIT_WARNING_OFFSET = 671490304;
  
  public static final int SETTING_FUNC_OTHER_ROAD_SIGH_INFO = 671485952;
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-6", project = "FX11", requirement = "Default OFF")
  public static final int SETTING_FUNC_PDC_ALARM_SOUND = 671620096;
  
  public static final int SETTING_FUNC_PDC_SWITCH = 537264896;
  
  public static final int SETTING_FUNC_PDC_WARNING_VOLUME = 671416576;
  
  public static final int SETTING_FUNC_PEB_MODE = 537264640;
  
  public static final int SETTING_FUNC_PILOT_LANE_CHANGE_ASSIST = 671351552;
  
  public static final int SETTING_FUNC_PRE_COLLISION_SYS = 671548160;
  
  public static final int SETTING_FUNC_REAR_COLLISION_WARNING = 537333760;
  
  public static final int SETTING_FUNC_REAR_CROSS_TRAFFIC_ALERT = 537332224;
  
  @VendorDefinition(author = "@ECARX", date = "2022-02-21", project = "FX11")
  public static final int SETTING_FUNC_RIS_SWITCH = 671678720;
  
  public static final int SETTING_FUNC_SPEED_CONTROL_MODE = 537069056;
  
  public static final int SETTING_FUNC_SPEED_LIMITATION_MODE = 537068800;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARN = 671482112;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_MODE = 671482368;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET = 671482880;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET_MODE = 671494144;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET_PERCENT = 671490048;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET_VALUE = 671483136;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET_VALUE_MAX = 671483392;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET_VALUE_MIN = 671483648;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET_VALUE_STEP = 671483904;
  
  public static final int SETTING_FUNC_SPEED_LIMIT_WARNING_OFFSET_VALUE_SWITCH = 671484160;
  
  public static final int SETTING_FUNC_STEERING_ASSISTANCE_LEVEL = 537331712;
  
  public static final int SETTING_FUNC_TLB_MODE = 671616000;
  
  public static final int SETTING_FUNC_TLB_SWITCH = 671615744;
  
  public static final int SETTING_FUNC_TRAFFIC_LIGHT_ATTENTION = 537332992;
  
  public static final int SETTING_FUNC_TRAFFIC_LIGHT_ATTENTION_SOUND = 671154432;
  
  public static final int SETTING_FUNC_TRAFFIC_SIGN_RECOGNITION = 537592064;
  
  public static final int SETTING_FUNC_TRAFFIC_SIGN_RECOGNITION_ALERT = 537592320;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11, EX_A2")
  public static final int SETTING_FUNC_TTS_ACC_ACTIVATE = 671746816;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11")
  public static final int SETTING_FUNC_TTS_ACC_EXIT = 671747072;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11，EX_A2")
  public static final int SETTING_FUNC_TTS_ASY_EYES_OFF_WARN_RQRD_SOUND = 671746048;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11")
  public static final int SETTING_FUNC_TTS_ASY_INFORM_FOR_DRIVER_SOUND = 671745024;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11")
  public static final int SETTING_FUNC_TTS_ASY_LAN_CHG_REMINDER = 671745280;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11, EX_A2")
  public static final int SETTING_FUNC_TTS_ASY_STEER_APPLY_RQRD_SOUND = 671746304;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11, EX_A2")
  public static final int SETTING_FUNC_TTS_ICC_ACTIVATE = 671744768;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11")
  public static final int SETTING_FUNC_TTS_ICC_ACTIVATE_REMINDER = 671745792;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11")
  public static final int SETTING_FUNC_TTS_ICC_DRIVING_STATUS = 671746560;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-12", project = "FX11")
  public static final int SETTING_FUNC_TTS_ICC_EXIT = 671745536;
  
  @VendorDefinition(author = "@ECARX", date = "2023-05-06", project = "EX11_A2")
  public static final int SETTING_FUNC_VOICE_BRST_MODE = 671747072;
  
  public static final int SPEED_LIMIT_WARNING_MODE_FLASHING = 671482370;
  
  public static final int SPEED_LIMIT_WARNING_MODE_NO_WARNING = 671482369;
  
  public static final int SPEED_LIMIT_WARNING_MODE_OFF = 0;
  
  public static final int SPEED_LIMIT_WARNING_MODE_SOUND = 671482371;
  
  public static final int SPEED_LIMIT_WARNING_OFFSET_0KM = 671482881;
  
  public static final int SPEED_LIMIT_WARNING_OFFSET_10KM = 671482883;
  
  public static final int SPEED_LIMIT_WARNING_OFFSET_5KM = 671482882;
  
  public static final int SPEED_LIMIT_WARNING_OFFSET_MINUS_10KM = 671482885;
  
  public static final int SPEED_LIMIT_WARNING_OFFSET_MINUS_5KM = 671482884;
  
  public static final int SPEED_LIMIT_WARNING_OFFSET_OFF = 0;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ACCActivateStatus {
    public static final int CANNOT_ACTIVATE = 2;
    
    public static final int CANNOT_DRV_BUCD_RQRD = 3;
    
    public static final int CANNOT_DRV_DOOR_NOT_CLSD = 4;
    
    public static final int CANNOT_DRV_GEAER_NOT_IN_DRV = 5;
    
    public static final int CANNOT_DRV_MOD_SELD_NOT_OK = 7;
    
    public static final int CANNOT_EPB = 6;
    
    public static final int CANNOT_ESC_OFF = 9;
    
    public static final int CANNOT_HDC_ON = 8;
    
    public static final int FIRST_ACTIVATE = 1;
    
    public static final int UNKNOWN = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ADASFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AEBWarning {
    public static final int HIGH = 3;
    
    public static final int LOW = 1;
    
    public static final int MEDIUM = 2;
    
    public static final int OFF = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface APAVoicePromptReq {
    public static final int REQ_VALUE_1 = 1;
    
    public static final int REQ_VALUE_10 = 10;
    
    public static final int REQ_VALUE_11 = 11;
    
    public static final int REQ_VALUE_12 = 12;
    
    public static final int REQ_VALUE_13 = 13;
    
    public static final int REQ_VALUE_14 = 14;
    
    public static final int REQ_VALUE_15 = 15;
    
    public static final int REQ_VALUE_16 = 16;
    
    public static final int REQ_VALUE_17 = 17;
    
    public static final int REQ_VALUE_18 = 18;
    
    public static final int REQ_VALUE_19 = 19;
    
    public static final int REQ_VALUE_2 = 2;
    
    public static final int REQ_VALUE_20 = 20;
    
    public static final int REQ_VALUE_21 = 21;
    
    public static final int REQ_VALUE_22 = 22;
    
    public static final int REQ_VALUE_3 = 3;
    
    public static final int REQ_VALUE_4 = 4;
    
    public static final int REQ_VALUE_5 = 5;
    
    public static final int REQ_VALUE_6 = 6;
    
    public static final int REQ_VALUE_7 = 7;
    
    public static final int REQ_VALUE_8 = 8;
    
    public static final int REQ_VALUE_9 = 9;
  }
  
  public static @interface ApbMode {
    public static final int APB_MODE_HIGH = 671615491;
    
    public static final int APB_MODE_LOW = 671615489;
    
    public static final int APB_MODE_MIDDLE = 671615490;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AsySteerApplyWarningMode {
    public static final int NO_WARNING = 0;
    
    public static final int WARNING_1 = 1;
    
    public static final int WARNING_2 = 2;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CarSpeedDisplayStatus {
    public static final int CAR_SPEED_HORIZON_DISPLAY_STATUS_ACTIVE = 4;
    
    public static final int CAR_SPEED_HORIZON_DISPLAY_STATUS_FAILURE_DISPLAY = 6;
    
    public static final int CAR_SPEED_HORIZON_DISPLAY_STATUS_NO_DISPLAY = 1;
    
    public static final int CAR_SPEED_HORIZON_DISPLAY_STATUS_OFF_DISPLAY = 2;
    
    public static final int CAR_SPEED_HORIZON_DISPLAY_STATUS_OVERRIDE = 5;
    
    public static final int CAR_SPEED_HORIZON_DISPLAY_STATUS_STANDBY = 3;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DPSWarningEyeMode {
    public static final int DPS_WARNING_EYE_LOSS_DETECTION_1 = 1;
    
    public static final int DPS_WARNING_EYE_LOSS_DETECTION_2 = 2;
    
    public static final int DPS_WARNING_OFF = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DoorOpenWarningStatus {
    public static final int DOW_WARNING_STATUS_LEVEL_1 = 671416833;
    
    public static final int DOW_WARNING_STATUS_LEVEL_2 = 671416834;
    
    public static final int DOW_WARNING_STATUS_LEVEL_3 = 671416835;
    
    public static final int DOW_WARNING_STATUS_NONE = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DrivingRoadInfoReminder {
    public static final int CONSTRUCTION = 3;
    
    public static final int MUCH_TRUCKS = 6;
    
    public static final int SHARP_BEND = 4;
    
    public static final int UNKNOWN = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ICCActivateStatus {
    public static final int CANNOT_ACTIVATE = 2;
    
    public static final int CANNOT_ALLWD_AREA = 10;
    
    public static final int CANNOT_DRV_BUCD_RQRD = 3;
    
    public static final int CANNOT_DRV_DOOR_NOT_CLSD = 4;
    
    public static final int CANNOT_DRV_GEAER_NOT_IN_DRV = 5;
    
    public static final int CANNOT_DRV_MOD_SELD_NOT_OK = 7;
    
    public static final int CANNOT_EPB = 6;
    
    public static final int CANNOT_ESC_OFF = 9;
    
    public static final int CANNOT_HDC_ON = 8;
    
    public static final int FIRST_ACTIVATE = 1;
    
    public static final int UNKNOWN = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ICCDrivingStatus {
    public static final int ICC_EXITED = 4;
    
    public static final int ICC_EXITING_2000_AHEAD = 2;
    
    public static final int ICC_EXITING_500_AHEAD = 1;
    
    public static final int ICC_ON = 5;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LaneChangeReminder {
    public static final int ABOUT_TO_CHANGE_LANE_LEFT = 12;
    
    public static final int ABOUT_TO_CHANGE_LANE_RIGHT = 13;
    
    public static final int ABOUT_TO_DRIVE_INTO_FAST_LANE = 10;
    
    public static final int ABOUT_TO_DRIVE_INTO_RAMP = 11;
    
    public static final int ABOUT_TO_MERGE_INTO_MAIN = 9;
    
    public static final int ABOUT_TO_OVERTAKE_LEFT = 7;
    
    public static final int ABOUT_TO_OVERTAKE_RIGHT = 8;
    
    public static final int CANCEL = 4;
    
    public static final int COMPLEX_ENVIRONMENT = 6;
    
    public static final int HOLD_STEER_WAKE_UP = 2;
    
    public static final int LANE_CHANGE_TO_LEFT = 19;
    
    public static final int LANE_CHANGE_TO_RIGHT = 20;
    
    public static final int NOT_SUITABLE = 1;
    
    public static final int PLEASE_TURN_ON_ICC = 21;
    
    public static final int SOLID_LINE = 5;
    
    public static final int SPEED_TO_LOW_TO_CHANGE = 3;
    
    public static final int TURN_OFF_LEFT_TURN_SIGNAL_LAMP = 15;
    
    public static final int TURN_OFF_RIGHT_TURN_SIGNAL_LAMP = 16;
    
    public static final int TURN_OFF_TURN_SIGNAL_LAMP = 14;
    
    public static final int VOICE_WAKE_UP_NOT_SUPPORT = 18;
    
    public static final int VOICE_WAKE_UP_SUPPORT = 17;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LaneChangeStrategy {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LaneChangeWarningMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NZPChangeLaneStatus {
    public static final int LANE_LEFT_CANCEL = 9;
    
    public static final int LANE_LEFT_CHANGING = 7;
    
    public static final int LANE_LEFT_FAILED = 3;
    
    public static final int LANE_LEFT_INVALID = 5;
    
    public static final int LANE_LEFT_SUCCESS = 1;
    
    public static final int LANE_NORMAL = 0;
    
    public static final int LANE_RIGHT_CANCEL = 16;
    
    public static final int LANE_RIGHT_CHANGING = 8;
    
    public static final int LANE_RIGHT_FAILED = 4;
    
    public static final int LANE_RIGHT_INVALID = 6;
    
    public static final int LANE_RIGHT_SUCCESS = 2;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NZPCollisionWarning {
    public static final int NORMAL = 0;
    
    public static final int RED = 2;
    
    public static final int YELLOW = 1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NZPStatus {
    public static final int NZP_STATUS_STATUS_ENTER = 1;
    
    public static final int NZP_STATUS_STATUS_EXIT = 2;
    
    public static final int NZP_STATUS_STATUS_FAULT = 3;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NZPType {
    public static final int NZP_ACC_LCC = 3;
    
    public static final int NZP_SMART_PILOT = 2;
    
    public static final int NZP_UNKNOWN = 1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PDCWarningVolumeMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PilotAlarmInfoMessage {
    public static final int LEVEL1_ABOUT_TO_CHANGE_LANE_TO_THE_LEFT = 12;
    
    public static final int LEVEL1_ABOUT_TO_CHANGE_LANE_TO_THE_RIGHT = 11;
    
    public static final int LEVEL1_AI_ASSISTED_DRIVING_IS_ON = 1;
    
    public static final int LEVEL1_HAS_BEEN_DOWNGRADED_TO_AI_ASSISTED_DRIVING = 18;
    
    public static final int LEVEL1_HAS_BEEN_DOWNGRADED_TO_NZP_INTELLIGENT_PILOT = 37;
    
    public static final int LEVEL1_HAS_BEEN_UPGRADED_TO_AI_ASSISTED_DRIVING = 19;
    
    public static final int LEVEL1_HAS_BEEN_UPGRADED_TO_NZP_AUTONOMOUS_NAVIGATION = 20;
    
    public static final int LEVEL1_LANE_CHANGE_COMPLETED = 9;
    
    public static final int LEVEL1_LANE_CHANGE_CONDITIONS_ARE_NOT_MET = 36;
    
    public static final int LEVEL1_LANE_CHANGE_HAS_BEEN_CANCELLED = 35;
    
    public static final int LEVEL1_LANE_CHANGE_IN_PROGRESS = 7;
    
    public static final int LEVEL1_LANE_CHANGE_IS_CANCELLED = 34;
    
    public static final int LEVEL1_LANE_CHANGING_IN_PROGRESS_PLEASE_PAY_ATTENTION = 8;
    
    public static final int LEVEL1_LCC_IS_RUNNING = 33;
    
    public static final int LEVEL1_NZP_AUTONOMOUS_PILOTING_HAS_BEEN_ACTIVATED = 2;
    
    public static final int LEVEL1_NZP_AUTONOMOUS_PILOT_IS_IN_OPERATION = 3;
    
    public static final int LEVEL1_PLEASE_HOLD_THE_STEERING_WHEEL = 15;
    
    public static final int LEVEL1_PLEASE_HOLD_THE_STEERING_WHEEL_PRESS_THE_CANCEL = 16;
    
    public static final int LEVEL1_PLEASE_LOOK_AT_THE_ROAD_AHEAD = 17;
    
    public static final int LEVEL1_PLEASE_OPERATE_THE_STEERING_LEVER_CHANGE_THE_LEFT = 14;
    
    public static final int LEVEL1_PLEASE_OPERATE_THE_STEERING_LEVER_CHANGE_THE_RIGHT = 13;
    
    public static final int LEVEL1_THE_FUNCTION_CANNOT_BE_ACTIVATED = 10;
    
    public static final int LEVEL1_THIS_LANE_CHANGE_FAILED = 6;
    
    public static final int LEVEL1_ZCA_IS_RUNNING = 4;
    
    public static final int LEVEL1_ZEEKR_PILOT_EXITED = 5;
    
    public static final int LEVEL2_ABOUT_TO_LEAVE_THE_WORKABLE_AREA = 22;
    
    public static final int LEVEL2_DOWNGRADED_TO_MANUAL_DRIVING_PLEASE_HOLD_THE_STEERING_WHEEL = 26;
    
    public static final int LEVEL2_HAS_BEEN_DOWNGRADED_TO_A_MANUAL_DRIVING_CONDITION = 27;
    
    public static final int LEVEL2_HAS_BEEN_DOWNGRADED_TO_LCC = 39;
    
    public static final int LEVEL2_HAS_BEEN_DOWNGRADED_TO_MANUAL_AUXILIARY_DRIVING_CONDITION = 25;
    
    public static final int LEVEL2_PILOT_FUNCTION_EXIT_FAILURE_TO_TAKE_OVER = 21;
    
    public static final int LEVEL2_PLEASE_HOLD_THE_STEERING_WHEEL = 23;
    
    public static final int LEVEL2_PLEASE_LOOK_AT_THE_ROAD_AHEAD = 24;
    
    public static final int LEVEL2_ZEEKR_PILOT_FUNCTION_EXIT = 38;
    
    public static final int LEVEL3_HAS_BEEN_DOWNGRADED_TO_MANUAL_DRIVING_CONDITION = 32;
    
    public static final int LEVEL3_PLEASE_HOLD_THE_STEERING_WHEEL = 30;
    
    public static final int LEVEL3_PLEASE_LOOK_AT_THE_ROAD_AHEAD = 31;
    
    public static final int LEVEL3_PLEASE_TAKE_OVER_THE_VEHICLE_IMMEDIATELY = 29;
    
    public static final int LEVEL3_PLEASE_TAKE_OVER_THE_VEHICLE_IMMEDIATELY_LCC = 41;
    
    public static final int LEVEL3_PLEASE_TAKE_OVER_THE_VEHICLE_IN_THE_SAFE_PARKING = 28;
    
    public static final int LEVEL3_ZEEKR_PILOT_FUNCTION_EXIT = 40;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PilotDrivingStatus {
    public static final int PILOT_DRIVING_STATUS_ACC = 2;
    
    public static final int PILOT_DRIVING_STATUS_AI_ASSIT = 4;
    
    public static final int PILOT_DRIVING_STATUS_MANUAL = 1;
    
    public static final int PILOT_DRIVING_STATUS_NZP = 5;
    
    public static final int PILOT_DRIVING_STATUS_UNKNOWN = 0;
    
    public static final int PILOT_DRIVING_STATUS_ZCA = 3;
  }
  
  public static @interface SpeedLimitOffsetMode {
    public static final int SPEED_LIMIT_WARNING_OFFSET_MODE_OFF = 0;
    
    public static final int SPEED_LIMIT_WARNING_OFFSET_MODE_PERCENT = 671494146;
    
    public static final int SPEED_LIMIT_WARNING_OFFSET_MODE_VALUE = 671494145;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SpeedLimitWarningMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SpeedLimitWarningOffset {}
  
  public static @interface TlbMode {
    public static final int TLB_MODE_HIGH = 671616003;
    
    public static final int TLB_MODE_LOW = 671616001;
    
    public static final int TLB_MODE_MIDDLE = 671616002;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VoiceBrstMode {
    public static final int VOICE_BRST_MODE_DETAIL = 671747073;
    
    public static final int VOICE_BRST_MODE_STREAM_LINE = 671747074;
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IADAS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */