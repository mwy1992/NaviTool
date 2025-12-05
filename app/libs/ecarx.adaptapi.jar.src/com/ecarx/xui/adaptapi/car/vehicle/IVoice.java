package com.ecarx.xui.adaptapi.car.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IVoice {
  public static final int CNCL_WARN_FOR_AUT_DRV_PILOT_CANCELED = 805372417;
  
  public static final int CNCL_WARN_FOR_AUT_DRV_PILOT_NO_WARN = 805372418;
  
  public static final int DEFAULT_IDLE = 0;
  
  public static final int DPS_ANNOUNCEMENTS_BLOCKED = 805437956;
  
  public static final int DPS_ANNOUNCEMENTS_FAULTY = 805437957;
  
  public static final int DPS_ANNOUNCEMENTS_NOT_DETECTED = 805437958;
  
  public static final int DPS_ANNOUNCEMENTS_RUNNING = 805437955;
  
  public static final int DPS_ANNOUNCEMENTS_SHUTDOWN = 805437954;
  
  public static final int DPS_ANNOUNCEMENTS_STARTUP = 805437953;
  
  public static final int DRVR_SOD_REQ_CHG_LEFT_LAN = 805372929;
  
  public static final int DRVR_SOD_REQ_CHG_NO = 254;
  
  public static final int DRVR_SOD_REQ_CHG_RIGHT_LAN = 805372930;
  
  public static final int LAN_CHG_SOD_CAMERA_BLOCK = 805372701;
  
  public static final int LAN_CHG_SOD_CHANGING_TO_CHANGE = 805372699;
  
  public static final int LAN_CHG_SOD_DEGRADATION_in_TUNNELS = 805372700;
  
  public static final int LAN_CHG_SOD_LANCHG_SOD_RESERVE_15 = 805372687;
  
  public static final int LAN_CHG_SOD_LANCHG_SOD_RESERVE_5 = 805372677;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_CACEL = 805372676;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_CACEL_OF_ROAD_ENVIRO = 805372678;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_NO = 0;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_NO_AVAL = 805372673;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_NO_AVAL_OF_HANDS_OFF = 805372674;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_NO_AVAL_OF_LOW_SPED = 805372675;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_OF_DRIVE_FAST_LANE = 805372682;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_OF_DRIVE_RAMP = 805372683;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_OF_JOIN_MAIN_ROAD = 805372681;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_OF_LEFT = 805372684;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_OF_LEFT_OVERTAKING = 805372679;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_OF_RIGHT = 805372685;
  
  public static final int LAN_CHG_SOD_LANE_CHANGE_OF_RIGHT_OVERTAKING = 805372680;
  
  public static final int LAN_CHG_SOD_LEFT_LANE_CHANGE_CONFIM = 805372692;
  
  public static final int LAN_CHG_SOD_LEFT_TURN_INDICATOR_NOT_CLOSED = 805372688;
  
  public static final int LAN_CHG_SOD_ODD_NOT_FULFILLED = 805372690;
  
  public static final int LAN_CHG_SOD_PILOT_CLOSED = 805372694;
  
  public static final int LAN_CHG_SOD_RIGHT_LANE_CHANGE_CONFIM = 805372693;
  
  public static final int LAN_CHG_SOD_RIGHT_TURN_INDICATOR_NOT_CLOSED = 805372689;
  
  public static final int LAN_CHG_SOD_SOUND_LANE_CHANGE_NOT_SUPPORT = 805372691;
  
  public static final int LAN_CHG_SOD_TAKE_OVER = 805372696;
  
  public static final int LAN_CHG_SOD_TAKE_OVER_DETAIL = 805372695;
  
  public static final int LAN_CHG_SOD_TAKE_OVER_NEAR_TOLL_STATION = 805372698;
  
  public static final int LAN_CHG_SOD_TAKE_OVER_NOW = 805372697;
  
  public static final int LAN_CHG_SOD_TURN_INDICATOR_NOT_CLOSED_FOR_LONG_TIME = 805372686;
  
  public static final int NOV_DISTAN_MSG_END_OF_ODD = 805372164;
  
  public static final int NOV_DISTAN_MSG_END_OF_ODD_FARAWAY_2000 = 805372161;
  
  public static final int NOV_DISTAN_MSG_END_OF_ODD_FARAWAY_500 = 805372162;
  
  public static final int NOV_DISTAN_MSG_IDLE = 0;
  
  public static final int NOV_DISTAN_MSG_START_OF_ODD = 805372165;
  
  public static final int PROMPT_REQ_CONN_APP_TAKEOUT_KEY = 805437701;
  
  public static final int PROMPT_REQ_FORWARD = 805437697;
  
  public static final int PROMPT_REQ_PARK_ABORT = 805437710;
  
  public static final int PROMPT_REQ_PARK_FINISHED = 805437703;
  
  public static final int PROMPT_REQ_PARK_INTERRUPT_RECOVER = 805437709;
  
  public static final int PROMPT_REQ_PARK_SLOT_MORE_THAN_ONE = 805437700;
  
  public static final int PROMPT_REQ_PARK_SLOT_ONLY_ONE = 805437699;
  
  public static final int PROMPT_REQ_PARK_SUSPEND = 805437708;
  
  public static final int PROMPT_REQ_PAY_ATTENTION_SURROUNDING = 805437702;
  
  public static final int PROMPT_REQ_PRESS_BRAKE_PEDAL_SELF = 805437707;
  
  public static final int PROMPT_REQ_PRESS_PARKINGOUT_BTN = 805437705;
  
  public static final int PROMPT_REQ_SELECT_PARK_DIRECTION = 805437704;
  
  public static final int PROMPT_REQ_SELECT_PARK_SPACE_TYPE = 805437706;
  
  public static final int PROMPT_REQ_SPD_TOO_FAST = 805437698;
  
  public static final int PROMPT_REQ_START_BACK_TO_START_UNDO = 805437711;
  
  public static final int PROMPT_REQ_UNDO_FINISHED = 805437712;
  
  public static final int SOD_PILOT_CFIRM_ACTIVE = 805373697;
  
  public static final int SOD_PILOT_CFIRM_ACTIVE_NO_CMD = 805373699;
  
  public static final int SOD_PILOT_CFIRM_CAN_NOT_ACTIVE = 805373698;
  
  public static final int TJP_ANNOUNCEMENTS_FRONT_VEH_LEAVES = 805438213;
  
  public static final int TJP_ANNOUNCEMENTS_INATTENTION = 805438209;
  
  public static final int TJP_ANNOUNCEMENTS_NONE = 254;
  
  public static final int TJP_ANNOUNCEMENTS_PILOT_EXIT_FROM_500M = 805438214;
  
  public static final int TJP_ANNOUNCEMENTS_SAFE_STOP = 805438212;
  
  public static final int TJP_ANNOUNCEMENTS_SPEED_REDUCE = 805438211;
  
  public static final int TJP_ANNOUNCEMENTS_TAKEOVER_REQ = 805438210;
  
  public static final int VOICE_FUNC_ANNOUNCEMENTS_FOR_DPS = 805437952;
  
  public static final int VOICE_FUNC_ANNOUNCEMENTS_FOR_NOA = 805438464;
  
  public static final int VOICE_FUNC_ANNOUNCEMENTS_FOR_NOA_START = 805438720;
  
  public static final int VOICE_FUNC_ANNOUNCEMENTS_FOR_TJP = 805438208;
  
  public static final int VOICE_FUNC_CNCL_WARN_FOR_AUT_DRV = 805372416;
  
  public static final int VOICE_FUNC_DRVR_SOD_REQ_CHG = 805372928;
  
  public static final int VOICE_FUNC_DRVR_SOD_REQ_PILOT = 805373440;
  
  public static final int VOICE_FUNC_LAN_CHG_SOD = 805372672;
  
  public static final int VOICE_FUNC_NOV_DISTAN_MSG = 805372160;
  
  public static final int VOICE_FUNC_PROMPT_REQ = 805437696;
  
  public static final int VOICE_FUNC_SOD_LANE_CHG_SWITCH = 805373184;
  
  public static final int VOICE_FUNC_SOD_PILOT_CFIRM = 805373696;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CnclWarnForAutDrv {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DpsAns {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DrvrSodReqChg {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LanChgSod {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NoaDistanMsg {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SodPilotCfirm {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TjpAns {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VoiceFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VoicePromptParking {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IVoice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */