package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IPAS {
  public static final int AUTO_REVERSE_CAMERA_OFF = 0;
  
  public static final int AUTO_REVERSE_CAMERA_REAR = 587400193;
  
  public static final int AUTO_REVERSE_CAMERA_TOP = 587400194;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_ABORT = 588317196;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_CONFIRM_BTN = 588317192;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_CONFIRM_PARK_OUT = 588317194;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_ENTER_APA = 588317193;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_ENTER_APA_OR_AVM = 588317190;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_EXIT_APA = 588317189;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_MANUAL_BTN = 588317191;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_NO_REQ = 254;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_SELT_APA = 588317185;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_SELT_RPA = 588317186;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_START_PARK = 588317188;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_SUSPEND = 588317195;
  
  public static final int DRVR_ASSC_SYS_BTN_PUSH_UNDO_BTN = 588317187;
  
  public static final int DRVR_ASSC_SYS_DISP_ANSWER_ERROR_ACT_RPA = 588317041;
  
  public static final int DRVR_ASSC_SYS_DISP_APA_SELT_R_RAP_SELT_P = 588316981;
  
  public static final int DRVR_ASSC_SYS_DISP_APA_SELT_R_RPA_SELT_P_SMALL_SLOT_RECOM_RPA = 588316992;
  
  public static final int DRVR_ASSC_SYS_DISP_AVM_FAIL_OR_NOCALIB_UNDO_INVAD = 588316973;
  
  public static final int DRVR_ASSC_SYS_DISP_BT_OFF_ACT_RPA = 588317042;
  
  public static final int DRVR_ASSC_SYS_DISP_CAMERA_FAILURE_BEF_ACT = 588317023;
  
  public static final int DRVR_ASSC_SYS_DISP_CAMERA_FAILURE_UNDO_INVAD = 588317016;
  
  public static final int DRVR_ASSC_SYS_DISP_CAMERA_SMUGLED_ACT = 588316977;
  
  public static final int DRVR_ASSC_SYS_DISP_CAMERA_SMUGLED_BEF_ACT = 588316945;
  
  public static final int DRVR_ASSC_SYS_DISP_CAN_NOT_PARK_OUT_ON_SPD_ZERO = 588316935;
  
  public static final int DRVR_ASSC_SYS_DISP_CHOSE_PARK_MODE = 588316930;
  
  public static final int DRVR_ASSC_SYS_DISP_CHOSE_PARK_MODE_APA_OR_RPA_NON_SMALL = 588317018;
  
  public static final int DRVR_ASSC_SYS_DISP_CHOSE_PARK_MODE_APA_OR_RPA_SMALL = 588317020;
  
  public static final int DRVR_ASSC_SYS_DISP_CONNOT_MOVE_UNDO_INVAD = 588316993;
  
  public static final int DRVR_ASSC_SYS_DISP_CONN_APP_TAKEOUT_KEY = 588317007;
  
  public static final int DRVR_ASSC_SYS_DISP_DOOR_OPEN_ACT = 588316950;
  
  public static final int DRVR_ASSC_SYS_DISP_DOOR_OPEN_BEF_ACT = 588316938;
  
  public static final int DRVR_ASSC_SYS_DISP_DOOR_UNLOCK_ACT_RPA = 588317050;
  
  public static final int DRVR_ASSC_SYS_DISP_DOOR_UNLOCK_BEF_ACT_RPA = 588317055;
  
  public static final int DRVR_ASSC_SYS_DISP_ECALL_ACTIVE_BEF_ACT = 588317031;
  
  public static final int DRVR_ASSC_SYS_DISP_ECALL_ACTIVE_UNDO_INVAD = 588317032;
  
  public static final int DRVR_ASSC_SYS_DISP_ENG_OFF_UNDO_INVAD = 588316970;
  
  public static final int DRVR_ASSC_SYS_DISP_EPB_ACTIVATED_ACT = 588316957;
  
  public static final int DRVR_ASSC_SYS_DISP_FAIL_BY_PASS_ABSTACLE_ACT_RPP = 588317039;
  
  public static final int DRVR_ASSC_SYS_DISP_FCTA_ACTIVE_ATC = 588316998;
  
  public static final int DRVR_ASSC_SYS_DISP_FOUND_PARK_SLOT = 588317006;
  
  public static final int DRVR_ASSC_SYS_DISP_FRONT_AND_REAR_USS_COVERED_ACT = 588316978;
  
  public static final int DRVR_ASSC_SYS_DISP_FRONT_USS_COVERED_ACT = 588316996;
  
  public static final int DRVR_ASSC_SYS_DISP_FRONT_USS_COVERED_BEF_ACT = 588317000;
  
  public static final int DRVR_ASSC_SYS_DISP_FUNC_CONFLICT_BEF_ACT = 588316966;
  
  public static final int DRVR_ASSC_SYS_DISP_GRADE_OF_RAIN_OVER_FLOW_UNDO_INVAD = 588316975;
  
  public static final int DRVR_ASSC_SYS_DISP_GRADIENT_ORR_UNDO_INVAD = 588316961;
  
  public static final int DRVR_ASSC_SYS_DISP_GRADIENT_ORR_UNDO_VAD = 588316976;
  
  public static final int DRVR_ASSC_SYS_DISP_GRADIENT_OVER_RANGE_BEF_ACT = 588316943;
  
  public static final int DRVR_ASSC_SYS_DISP_GRADIENT_OVER_RANGE_TO_SEARCH = 588316941;
  
  public static final int DRVR_ASSC_SYS_DISP_HEAVY_RAIN_BEF_ACT = 588316967;
  
  public static final int DRVR_ASSC_SYS_DISP_HOOD_OPEN_ACT = 588316955;
  
  public static final int DRVR_ASSC_SYS_DISP_HOOD_OPEN_BEF_ACT = 588316948;
  
  public static final int DRVR_ASSC_SYS_DISP_INTERRUPT_RECOVERY_TIMEOUT_UNDO_INVAD = 588317017;
  
  public static final int DRVR_ASSC_SYS_DISP_INTERRUPT_TOF_UNDO_INVAD = 588316960;
  
  public static final int DRVR_ASSC_SYS_DISP_INTERVENE_SYS_ACTIVE_UNDO_INVAD = 588316963;
  
  public static final int DRVR_ASSC_SYS_DISP_KEEP_P_GEAR_BEF_ACT = 588317004;
  
  public static final int DRVR_ASSC_SYS_DISP_MIRROR_FOLD_ACT = 588316954;
  
  public static final int DRVR_ASSC_SYS_DISP_MIRROR_FOLD_BEF_ACT = 588316946;
  
  public static final int DRVR_ASSC_SYS_DISP_MIRROR_OPEN_ACT_RSPA = 588317040;
  
  public static final int DRVR_ASSC_SYS_DISP_MIRROR_OPEN_BEF_ACT_RSPA = 588317054;
  
  public static final int DRVR_ASSC_SYS_DISP_MOVE_TOF_UNDO_INVAD = 588316959;
  
  public static final int DRVR_ASSC_SYS_DISP_MOVE_TOO_LONG_ACT_RSPA = 588317051;
  
  public static final int DRVR_ASSC_SYS_DISP_NOT_DISP = 588317033;
  
  public static final int DRVR_ASSC_SYS_DISP_OBSTACLE_OCCUR_ACT = 588316956;
  
  public static final int DRVR_ASSC_SYS_DISP_OFF = 0;
  
  public static final int DRVR_ASSC_SYS_DISP_OOFRA_UNDO_INVAD = 588316964;
  
  public static final int DRVR_ASSC_SYS_DISP_OVERRIDE_BY_GAS_PEDAL_ACT = 588316979;
  
  public static final int DRVR_ASSC_SYS_DISP_OVERRIDE_BY_GEAR_SHIFT_ACT = 588316974;
  
  public static final int DRVR_ASSC_SYS_DISP_OVERRIDE_BY_STEERING_WHEEL_ACT = 588316985;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_FINISHED = 588316984;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_INTERRUPT_RECOVER = 588317003;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_INTERRUPT_RECOVER_UNDO_INVAD = 588316994;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_INTERRUPT_RECOVER_UNDO_VAD = 588316995;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_MODE_ERROR_BEF_ACTIVE = 588317021;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_QUIT = 588317002;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_SOLT_SEARCHED_APA = 588316932;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_SOLT_SEARCHED_APA_RPA = 588316937;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_SOLT_SEARCHED_RPA = 588316939;
  
  public static final int DRVR_ASSC_SYS_DISP_PARK_TIMEOUT_UNDO_INVAD = 588316968;
  
  public static final int DRVR_ASSC_SYS_DISP_PAS_FAILURE_BEF_ACT = 588317014;
  
  public static final int DRVR_ASSC_SYS_DISP_PAS_FAIL_UNDO_INVAD = 588316972;
  
  public static final int DRVR_ASSC_SYS_DISP_POWER_MODE_ERROR_UNDO_INVAD = 588317015;
  
  public static final int DRVR_ASSC_SYS_DISP_PRESS_START_PARK_BTN_CHOSE_SPACE = 588317022;
  
  public static final int DRVR_ASSC_SYS_DISP_RCTA_ACTIVE_ATC = 588316999;
  
  public static final int DRVR_ASSC_SYS_DISP_REAR_USS_COVERED_ACT = 588316997;
  
  public static final int DRVR_ASSC_SYS_DISP_REAR_USS_COVERED_BEF_ACT = 588317001;
  
  public static final int DRVR_ASSC_SYS_DISP_REL_BRAKE_PEDAL = 588316982;
  
  public static final int DRVR_ASSC_SYS_DISP_REL_SYS_ACTIVE_ACT = 588317011;
  
  public static final int DRVR_ASSC_SYS_DISP_REL_SYS_FAIL_BEF_ACT = 588316988;
  
  public static final int DRVR_ASSC_SYS_DISP_REL_SYS_FAIL_UNDO_INVAD = 588316962;
  
  public static final int DRVR_ASSC_SYS_DISP_REMOTE_CTRL_INVAD_ACT_RPA = 588317052;
  
  public static final int DRVR_ASSC_SYS_DISP_REMOTE_PARK_ASSIST_FINISHED = 588317010;
  
  public static final int DRVR_ASSC_SYS_DISP_REMOTE_PARK_ASSIST_QUIT = 588317009;
  
  public static final int DRVR_ASSC_SYS_DISP_REMOTE_PARK_ASSIST_WORKING = 588317008;
  
  public static final int DRVR_ASSC_SYS_DISP_REMOTE_TRIGGER_FUNC_FAILED_BEF_ACT_RPA = 588317049;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_107 = 588317035;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_108 = 588317036;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_109 = 588317037;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_110 = 588317038;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_62 = 588316990;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_63 = 588316991;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_84 = 588317012;
  
  public static final int DRVR_ASSC_SYS_DISP_RESERVE_85 = 588317013;
  
  public static final int DRVR_ASSC_SYS_DISP_SAFETY_BTN_REL_ACT_RPA = 588317053;
  
  public static final int DRVR_ASSC_SYS_DISP_SEARCH_PARK_SLOT = 588317005;
  
  public static final int DRVR_ASSC_SYS_DISP_SEAT_BELT_RELEASED_ACT = 588316949;
  
  public static final int DRVR_ASSC_SYS_DISP_SEAT_BELT_RELEASED_BEF_ACT = 588316936;
  
  public static final int DRVR_ASSC_SYS_DISP_SELF_CRUISE_DIST_TOO_LONG_UNDO_INVAD_RPA = 588317047;
  
  public static final int DRVR_ASSC_SYS_DISP_SELF_CRUISE_PROC_TIMEOUT_UNDO_INVAD_RPA = 588317046;
  
  public static final int DRVR_ASSC_SYS_DISP_SELT_D_GEAR = 588316987;
  
  public static final int DRVR_ASSC_SYS_DISP_SELT_PARKIN_PARKOUT = 588316929;
  
  public static final int DRVR_ASSC_SYS_DISP_SELT_PARK_SPACE_TYPE = 588317019;
  
  public static final int DRVR_ASSC_SYS_DISP_SELT_RECOM_PKSP_HAND_D = 588316933;
  
  public static final int DRVR_ASSC_SYS_DISP_SELT_RECOM_PKSP_HAND_R = 588316934;
  
  public static final int DRVR_ASSC_SYS_DISP_SELT_R_GEAR = 588316989;
  
  public static final int DRVR_ASSC_SYS_DISP_SPD_LIMIT_UNDO_INVAD = 588316969;
  
  public static final int DRVR_ASSC_SYS_DISP_SPD_ORR_UNDO_INVAD = 588316958;
  
  public static final int DRVR_ASSC_SYS_DISP_SPD_TOO_FAST = 588316931;
  
  public static final int DRVR_ASSC_SYS_DISP_SPD_TOO_FAST_SYS_QUIT = 588317026;
  
  public static final int DRVR_ASSC_SYS_DISP_SYS_FAULT_BEF_ACT = 588316965;
  
  public static final int DRVR_ASSC_SYS_DISP_SYS_TIMEOUT_QUIT_PARK = 588316983;
  
  public static final int DRVR_ASSC_SYS_DISP_TAKE_ON_PHONE_ACT_RPA = 588317043;
  
  public static final int DRVR_ASSC_SYS_DISP_TIMEOUT_PHONE_AND_CAR_WITHIN_SPECIFY_TIME = 588317045;
  
  public static final int DRVR_ASSC_SYS_DISP_TOWBAR_ACTIVE_ACT = 588316953;
  
  public static final int DRVR_ASSC_SYS_DISP_TOWBAR_ACTIVE_BEF_ACT = 588316944;
  
  public static final int DRVR_ASSC_SYS_DISP_TRAILER_ACTIVE_ACT = 588316952;
  
  public static final int DRVR_ASSC_SYS_DISP_TRAILER_ACTIVE_BEF_ACT = 588316942;
  
  public static final int DRVR_ASSC_SYS_DISP_TRIGGER_RPP_CONDI_NOOK_UNDO_INVAD_RPA = 588317048;
  
  public static final int DRVR_ASSC_SYS_DISP_TRUNK_ACTIVE_ACT = 588316951;
  
  public static final int DRVR_ASSC_SYS_DISP_TRUNK_OPEN_BEF_ACT = 588316940;
  
  public static final int DRVR_ASSC_SYS_DISP_UI_RUN_IN_BG_ACT_RPA = 588317044;
  
  public static final int DRVR_ASSC_SYS_DISP_UNDO_FINISHED_RPA = 588317030;
  
  public static final int DRVR_ASSC_SYS_DISP_UNDO_FINISHED_UNDO = 588317027;
  
  public static final int DRVR_ASSC_SYS_DISP_USR_RESP_TIMEOUT_UNDO_INVAD = 588316971;
  
  public static final int DRVR_ASSC_SYS_DISP_USR_RESP_TIMEOUT_UNDO_INVAD_2 = 588316986;
  
  public static final int DRVR_ASSC_SYS_DISP_USR_RESP_TIMEOUT_UNDO_VAD = 588316980;
  
  public static final int DRVR_ASSC_SYS_DISP_USS_COVERED_BEF_ACT = 588316947;
  
  public static final int DRVR_ASSC_SYS_DISP_USS_FAILURE_BEF_ACT = 588317025;
  
  public static final int DRVR_ASSC_SYS_DISP_USS_FAILURE_UNDO_INVAD = 588317024;
  
  public static final int DRVR_ASSC_SYS_DISP_USS_UNDER_INTERFERING_UNDO_INVAD = 588317034;
  
  public static final int DRVR_ASSC_SYS_DISP_WASH_MODE_ON_BEF_ACT = 588317029;
  
  public static final int DRVR_ASSC_SYS_DISP_WASH_MODE_ON_UNDO_INVAD = 588317028;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_CANCEL = 588317441;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_DEFAULT = 2;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_HORIZ_LEFT_PARK_OUT = 588317449;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_HORIZ_PARK_IN = 588317442;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_HORIZ_RIGHT_PARK_OUT = 588317450;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_PERPDIR_LEFT_PARK_OUT_BW = 588317453;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_PERPDIR_LEFT_PARK_OUT_FW = 588317451;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_PERPDIR_PARK_IN = 588317443;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_PERPDIR_PARK_IN_BW = 588317445;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_PERPDIR_PARK_IN_FW = 588317444;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_PERPDIR_RIGHT_PARK_OUT_BW = 588317454;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_PERPDIR_RIGHT_PARK_OUT_FW = 588317452;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_RESERVE_15 = 588317455;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_RESERVE_6 = 588317446;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_RESERVE_7 = 588317447;
  
  public static final int DRVR_ASSC_SYS_PARK_MOD_RESERVE_8 = 588317448;
  
  public static final int PAC_3DVIEW_POSITION_FRONT_CENTER = 587403777;
  
  public static final int PAC_3DVIEW_POSITION_FRONT_LEFT = 587403779;
  
  public static final int PAC_3DVIEW_POSITION_FRONT_RIGHT = 587403778;
  
  public static final int PAC_3DVIEW_POSITION_LEFT = 587403780;
  
  public static final int PAC_3DVIEW_POSITION_OFF = 0;
  
  public static final int PAC_3DVIEW_POSITION_REAR_CENTER = 587403782;
  
  public static final int PAC_3DVIEW_POSITION_REAR_LEFT = 587403783;
  
  public static final int PAC_3DVIEW_POSITION_REAR_RIGHT = 587403784;
  
  public static final int PAC_3DVIEW_POSITION_RIGHT = 587403781;
  
  public static final int PAC_CAMERA_360CAM = 587400450;
  
  public static final int PAC_CAMERA_REARONLY = 587400449;
  
  public static final int PAC_CAMERA_TYPE_NONE = 0;
  
  public static final int PAC_SYS_AVA_STATUS_AVAILABLE = 587404033;
  
  public static final int PAC_SYS_AVA_STATUS_HADNSHAKE_TIMEOUT = 587404036;
  
  public static final int PAC_SYS_AVA_STATUS_SERVICE_REQUIRED = 587404035;
  
  public static final int PAC_SYS_AVA_STATUS_UNAVAILABLE = 587404034;
  
  public static final int PAC_VIEW_SELECTION_2DVIEW = 587403531;
  
  public static final int PAC_VIEW_SELECTION_3DVIEW = 587403530;
  
  public static final int PAC_VIEW_SELECTION_DOUBLE_SIDE = 587403529;
  
  public static final int PAC_VIEW_SELECTION_FRONT = 587403521;
  
  public static final int PAC_VIEW_SELECTION_FRONT_JUNC = 587403522;
  
  public static final int PAC_VIEW_SELECTION_FRONT_TOP = 587403523;
  
  public static final int PAC_VIEW_SELECTION_OFF = 0;
  
  public static final int PAC_VIEW_SELECTION_REAR = 587403525;
  
  public static final int PAC_VIEW_SELECTION_REAR_JUNC = 587403526;
  
  public static final int PAC_VIEW_SELECTION_REAR_LEFT_3D = 587403532;
  
  public static final int PAC_VIEW_SELECTION_REAR_RIGHT_3D = 587403533;
  
  public static final int PAC_VIEW_SELECTION_REAR_TOP = 587403528;
  
  public static final int PAC_VIEW_SELECTION_TOP = 587403524;
  
  public static final int PAC_VIEW_SELECTION_ZOOMED_REAR = 587403527;
  
  @VendorDefinition(author = "@ECARX", date = "2022-7-1", project = "HX11")
  public static final int PAS_FUNC_APA_DETECT_PARKING_SPACE = 588251904;
  
  public static final int PAS_FUNC_APA_RPA_SWITCH = 587596288;
  
  public static final int PAS_FUNC_APA_SELF_RECOMMENDED = 587596032;
  
  public static final int PAS_FUNC_AUT_PRKG_SLOT_NR_REQ = 588317952;
  
  public static final int PAS_FUNC_AVP_ACTIVATED = 588251392;
  
  public static final int PAS_FUNC_DRVR_ASSC_SYS_BTN_PUSH = 588317184;
  
  public static final int PAS_FUNC_DRVR_ASSC_SYS_DISP = 588316928;
  
  public static final int PAS_FUNC_DRVR_ASSC_SYS_PARK_MOD = 588317440;
  
  public static final int PAS_FUNC_ELE_MIRROR_SYS_ACTIVATED = 588251648;
  
  public static final int PAS_FUNC_PAC_3DVIEW_LOCK = 587404288;
  
  public static final int PAS_FUNC_PAC_3DVIEW_POSITION = 587403776;
  
  public static final int PAS_FUNC_PAC_ACTIVATION = 587399424;
  
  public static final int PAS_FUNC_PAC_APP_INIT_COMPLETED = 587404544;
  
  public static final int PAS_FUNC_PAC_AUTO_FRONT_ACTIV = 587399936;
  
  public static final int PAS_FUNC_PAC_AUTO_REVERSE_CAMERA = 587400192;
  
  public static final int PAS_FUNC_PAC_CAMERA_TYPE = 587400448;
  
  public static final int PAS_FUNC_PAC_CAR_MODE_TRANSPARENT = 587407616;
  
  public static final int PAS_FUNC_PAC_NEARBY_OBJ_TRIGGER = 587407872;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "Lambda")
  public static final int PAS_FUNC_PAC_OBSTACLE_DETECTION = 587408128;
  
  public static final int PAS_FUNC_PAC_OVERLAY_DSTINFO = 587401728;
  
  public static final int PAS_FUNC_PAC_OVERLAY_STEERPATH = 587401216;
  
  public static final int PAS_FUNC_PAC_OVERLAY_TOWBAR = 587401472;
  
  @VendorDefinition(author = "@ECARX", date = "2022-7-1", project = "HX11")
  public static final int PAS_FUNC_PAC_STATUS = 587399425;
  
  public static final int PAS_FUNC_PAC_STEER_LINK = 587399680;
  
  public static final int PAS_FUNC_PAC_SYS_AVA_STATUS = 587404032;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "Lambda")
  public static final int PAS_FUNC_PAC_TOP_VIEW_ZOOM_IN = 587408384;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "Lambda")
  public static final int PAS_FUNC_PAC_TOURING_VIEW = 587408640;
  
  public static final int PAS_FUNC_PAC_VIEW_SELECTION = 587403520;
  
  public static final int PAS_FUNC_PAS_ACTIVATED = 537723136;
  
  public static final int PAS_FUNC_PAS_MUTE = 587268608;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-03", project = "5BE02", requirement = "")
  public static final int PAS_FUNC_PAS_RADAR_FRONT_CENTER = 587338240;
  
  public static final int PAS_FUNC_PAS_RADAR_FRONT_INNER_LEFT = 587333888;
  
  public static final int PAS_FUNC_PAS_RADAR_FRONT_INNER_RIGHT = 587334144;
  
  public static final int PAS_FUNC_PAS_RADAR_FRONT_LEFT_SIDE = 587334912;
  
  public static final int PAS_FUNC_PAS_RADAR_FRONT_OUT_LEFT = 587334400;
  
  public static final int PAS_FUNC_PAS_RADAR_FRONT_OUT_RIGHT = 587334656;
  
  public static final int PAS_FUNC_PAS_RADAR_FRONT_RIGHT_SIDE = 587335168;
  
  public static final int PAS_FUNC_PAS_RADAR_MAX_DISTANCE = 587336960;
  
  public static final int PAS_FUNC_PAS_RADAR_MIN_DISTANCE = 587337216;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-03", project = "5BE02", requirement = "")
  public static final int PAS_FUNC_PAS_RADAR_REAR_CENTER = 587338496;
  
  public static final int PAS_FUNC_PAS_RADAR_REAR_INNER_LEFT = 587336448;
  
  public static final int PAS_FUNC_PAS_RADAR_REAR_INNER_RIGHT = 587336704;
  
  public static final int PAS_FUNC_PAS_RADAR_REAR_LEFT_SIDE = 587335424;
  
  public static final int PAS_FUNC_PAS_RADAR_REAR_OUT_LEFT = 587335936;
  
  public static final int PAS_FUNC_PAS_RADAR_REAR_OUT_RIGHT = 587336192;
  
  public static final int PAS_FUNC_PAS_RADAR_REAR_RIGHT_SIDE = 587335680;
  
  public static final int PAS_FUNC_PAS_RADAR_WORK_MODE = 587337728;
  
  public static final int PAS_FUNC_PAS_RADAR_WORK_STATUS = 587337984;
  
  public static final int PAS_FUNC_PAS_SHOW_GRAPHICS = 587269376;
  
  public static final int PAS_FUNC_PAS_STATUS = 587268352;
  
  public static final int PAS_FUNC_PAS_TOP_VIEW = 587269120;
  
  public static final int PAS_FUNC_PAS_TRAILER_PRESENT = 587268864;
  
  public static final int PAS_FUNC_PAS_VOLUME = 537723392;
  
  public static final int PAS_FUNC_PRKG_AUX_INFO_DISP = 588317696;
  
  public static final int PAS_FUNC_PRKG_INTRPT_RELD_BTN = 588318208;
  
  public static final int PAS_FUNC_RCTA_ACTIVATION = 587530496;
  
  public static final int PAS_FUNC_RCTA_LEFT_WARNING = 587530752;
  
  public static final int PAS_FUNC_RCTA_RIGHT_WARNING = 587531008;
  
  public static final int PAS_FUNC_RCTA_SHOW_GRAPHICS = 587531264;
  
  public static final int PAS_FUNC_RCTA_WARNING_VOLUME = 587531520;
  
  public static final int PAS_FUNC_SAP_ACTIVATION = 587464960;
  
  public static final int PAS_FUNC_SAP_PARK_IN_NOTI = 587469056;
  
  public static final int PAS_FUNC_SAP_PARK_IN_RESUME = 587465728;
  
  public static final int PAS_FUNC_SAP_PARK_IN_TYPE = 587465472;
  
  public static final int PAS_FUNC_SAP_PARK_IN_TYPE_RECOMMEND = 587466496;
  
  public static final int PAS_FUNC_SAP_PARK_OUT_COMFIRM = 587465984;
  
  public static final int PAS_FUNC_SAP_PARK_OUT_NOTI = 587469312;
  
  public static final int PAS_FUNC_SAP_PARK_TYPE = 587465216;
  
  public static final int PAS_FUNC_SAP_PROGRESS = 587466240;
  
  public static final int PAS_RADAR_WORK_MODE_FAILURE = 587337733;
  
  public static final int PAS_RADAR_WORK_MODE_FRONT_ACTIVE = 587337731;
  
  public static final int PAS_RADAR_WORK_MODE_FRONT_REAR_ACTIVE = 587337730;
  
  public static final int PAS_RADAR_WORK_MODE_INHIBITED = 587337734;
  
  public static final int PAS_RADAR_WORK_MODE_OFF = 0;
  
  public static final int PAS_RADAR_WORK_MODE_REAR_ACTIVE = 587337732;
  
  public static final int PAS_RADAR_WORK_MODE_STANDBY = 587337729;
  
  public static final int PAS_RADAR_WORK_STATUS_FRONT_ACTIVE_REAR_FAILURE = 587337985;
  
  public static final int PAS_RADAR_WORK_STATUS_FRONT_INACTIVE_REAR_FAILURE = 587337988;
  
  public static final int PAS_RADAR_WORK_STATUS_NONE = 0;
  
  public static final int PAS_RADAR_WORK_STATUS_REAR_ACTIVE_FRONT_FAILURE = 587337986;
  
  public static final int PAS_RADAR_WORK_STATUS_REAR_INACTIVE_FRONT_FAILURE = 587337987;
  
  public static final int PRKG_AUX_INFO_DISP_CHOSE_MODE_OR_CHG_OTHER_SPACES = 588317703;
  
  public static final int PRKG_AUX_INFO_DISP_CHOSE_PARK_MODE = 588317704;
  
  public static final int PRKG_AUX_INFO_DISP_DEFAULT = 2;
  
  public static final int PRKG_AUX_INFO_DISP_FORWARD = 588317698;
  
  public static final int PRKG_AUX_INFO_DISP_PARK_SLOT_SELTED = 588317701;
  
  public static final int PRKG_AUX_INFO_DISP_PAY_ATTENTION_TO_SURROUND = 588317697;
  
  public static final int PRKG_AUX_INFO_DISP_PRESS_BRAKE_PEDAL = 588317699;
  
  public static final int PRKG_AUX_INFO_DISP_PRESS_BRAKE_PEDAL_ONLY_REAR = 588317709;
  
  public static final int PRKG_AUX_INFO_DISP_PRESS_BRAKE_PEDAL_THEN_SEARCH_SPACES_RPP = 588317706;
  
  public static final int PRKG_AUX_INFO_DISP_RELEASE_BRAKE_PEDAL = 588317705;
  
  public static final int PRKG_AUX_INFO_DISP_SELT_DIRECTION_START = 588317711;
  
  public static final int PRKG_AUX_INFO_DISP_SELT_PARK_DIRECTION_BEF_ACT = 588317707;
  
  public static final int PRKG_AUX_INFO_DISP_SELT_PARK_SLOT = 588317700;
  
  public static final int PRKG_AUX_INFO_DISP_TIP_START_PARK_ONLY_REAR = 588317710;
  
  public static final int PRKG_AUX_INFO_DISP_TIP_START_PARK_RPA = 588317708;
  
  public static final int PRKG_AUX_INFO_DISP_TYPE_RECOMM_BTN_OFF = 588317702;
  
  public static final int PRKG_INTRPT_RELD_BACK_TO_START_POINT = 588318211;
  
  public static final int PRKG_INTRPT_RELD_CONTINUE = 588318209;
  
  public static final int PRKG_INTRPT_RELD_NOT_CONTINUE = 588318210;
  
  public static final int PRKG_INTRPT_RELD_NO_REQ = 254;
  
  public static final int RCTA_WARNING_VOLUME_HIGH = 587531523;
  
  public static final int RCTA_WARNING_VOLUME_LOW = 587531521;
  
  public static final int RCTA_WARNING_VOLUME_MID = 587531522;
  
  public static final int RCTA_WARNING_VOLUME_OFF = 0;
  
  public static final int SAP_PARK_IN_NOTI_CANCEL_DRIVER_DEACTIVATION = 587469080;
  
  public static final int SAP_PARK_IN_NOTI_CANCEL_HIGH_SPEED = 587469076;
  
  public static final int SAP_PARK_IN_NOTI_CANCEL_SLIPPERY_ROAD = 587469077;
  
  public static final int SAP_PARK_IN_NOTI_CANCEL_STEERING_INTERVENTION = 587469079;
  
  public static final int SAP_PARK_IN_NOTI_CANCEL_TRAILER_CONNECT = 587469078;
  
  public static final int SAP_PARK_IN_NOTI_CANCEL_WRONG_GEAR = 587469081;
  
  public static final int SAP_PARK_IN_NOTI_DRV_FWD_SLOWLY = 587469069;
  
  public static final int SAP_PARK_IN_NOTI_EMGY_BRK_ACTV = 587469083;
  
  public static final int SAP_PARK_IN_NOTI_EMGY_BRK_DIS = 587469084;
  
  public static final int SAP_PARK_IN_NOTI_FAIL_TOO_MANY_MOVES = 587469074;
  
  public static final int SAP_PARK_IN_NOTI_FINISHED = 587469072;
  
  public static final int SAP_PARK_IN_NOTI_FIRST_REV_SLOWLY = 587469067;
  
  public static final int SAP_PARK_IN_NOTI_LOOK_AROUND_LEFT = 587469065;
  
  public static final int SAP_PARK_IN_NOTI_LOOK_AROUND_RIGHT = 587469066;
  
  public static final int SAP_PARK_IN_NOTI_NO_NOTIFICATION = 587469057;
  
  public static final int SAP_PARK_IN_NOTI_OVER_SPEED_SCAN = 587469061;
  
  public static final int SAP_PARK_IN_NOTI_PARK_FOUND_STOP = 587469062;
  
  public static final int SAP_PARK_IN_NOTI_PUT_REV_GEAR = 587469063;
  
  public static final int SAP_PARK_IN_NOTI_PUT_REV_GEAR_AGAIN = 587469064;
  
  public static final int SAP_PARK_IN_NOTI_RESUMED = 587469082;
  
  public static final int SAP_PARK_IN_NOTI_REV_SLOWLY = 587469071;
  
  public static final int SAP_PARK_IN_NOTI_SCAN_LEFT = 587469059;
  
  public static final int SAP_PARK_IN_NOTI_SCAN_RIGHT = 587469058;
  
  public static final int SAP_PARK_IN_NOTI_SLOT_FOUND_CON_FWD = 587469060;
  
  public static final int SAP_PARK_IN_NOTI_STOP_PUT_FWD_GEAR = 587469068;
  
  public static final int SAP_PARK_IN_NOTI_STOP_PUT_REV_GEAR = 587469070;
  
  public static final int SAP_PARK_IN_NOTI_TEMP_NOT_AVAIL = 587469075;
  
  public static final int SAP_PARK_IN_TYPE_PARA = 587465474;
  
  public static final int SAP_PARK_IN_TYPE_PERP = 587465473;
  
  public static final int SAP_PARK_OUT_CANCEL_DRIVER_DEACTIVATION = 587469334;
  
  public static final int SAP_PARK_OUT_CANCEL_HIGH_SPEED = 587469330;
  
  public static final int SAP_PARK_OUT_CANCEL_SLIPPERY_ROAD = 587469331;
  
  public static final int SAP_PARK_OUT_CANCEL_STEERING_INTERVENTION = 587469333;
  
  public static final int SAP_PARK_OUT_CANCEL_TRAILER_CONNECT = 587469332;
  
  public static final int SAP_PARK_OUT_CHANGE_GEAR = 587469318;
  
  public static final int SAP_PARK_OUT_CHANGE_GEAR_REV = 587469319;
  
  public static final int SAP_PARK_OUT_DRV_FWD_SLOWLY = 587469324;
  
  public static final int SAP_PARK_OUT_FAIL_NO_PATH = 587469328;
  
  public static final int SAP_PARK_OUT_FAIL_TOO_MANY_MOVES = 587469327;
  
  public static final int SAP_PARK_OUT_FINISHED = 587469326;
  
  public static final int SAP_PARK_OUT_LOOK_AROUND_LEFT = 587469320;
  
  public static final int SAP_PARK_OUT_LOOK_AROUND_RIGHT = 587469321;
  
  public static final int SAP_PARK_OUT_NOTI_EMGY_BRK_ACTV = 587469337;
  
  public static final int SAP_PARK_OUT_NOTI_EMGY_BRK_DIS = 587469338;
  
  public static final int SAP_PARK_OUT_NO_NOTIFICATION = 587469313;
  
  public static final int SAP_PARK_OUT_RESUMED = 587469335;
  
  public static final int SAP_PARK_OUT_REV_SLOWLY = 587469322;
  
  public static final int SAP_PARK_OUT_SCAN_LEFT = 587469316;
  
  public static final int SAP_PARK_OUT_SCAN_RIGHT = 587469317;
  
  public static final int SAP_PARK_OUT_SELECT_PARK_OUT = 587469315;
  
  public static final int SAP_PARK_OUT_SELECT_PARK_OUT_CONFIRM = 587469314;
  
  public static final int SAP_PARK_OUT_SLOT_TOO_SMALL = 587469336;
  
  public static final int SAP_PARK_OUT_STOP_PUT_FWD_GEAR = 587469323;
  
  public static final int SAP_PARK_OUT_STOP_PUT_REV_GEAR = 587469325;
  
  public static final int SAP_PARK_OUT_TEMP_NOT_AVAIL = 587469329;
  
  public static final int SAP_PARK_TYPE_IN = 587465217;
  
  public static final int SAP_PARK_TYPE_OUT = 587465218;
  
  public static final int SAP_REC_PARK_IN_TYPE_PARA = 587466498;
  
  public static final int SAP_REC_PARK_IN_TYPE_PERP = 587466497;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DrvrAsscSysBtnPush {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DrvrAsscSysDisplay {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DrvrAsscSysParkMod {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PACStatus {
    public static final int FULL_SCREEN = 1;
    
    public static final int OFF = 0;
    
    public static final int SUSPENSION_WINDOW = 2;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Pac3DViewPosition {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PacCameraType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PacSysAvailableStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PacViewSelecion {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PasFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PrkgAuxInfoDisp {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PrkgIntrptReld {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RCTAWarningVolumeMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RadarWorkMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RadarWorkStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ReverseCamera {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SapParkInNotification {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SapParkInType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SapParkInTypeRecommend {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SapParkOutNotification {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SapParkType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IPAS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */