/*      */ package ecarx.car.hardware.vehicle;
/*      */ 
/*      */ import android.car.CarNotConnectedException;
/*      */ import ecarx.car.hardware.annotation.ActvnAvl3;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.annotation.BooleanType;
/*      */ import ecarx.car.hardware.annotation.CarFindrHornLiSetActv;
/*      */ import ecarx.car.hardware.annotation.ClassnQly;
/*      */ import ecarx.car.hardware.annotation.DoorOpenerReq1;
/*      */ import ecarx.car.hardware.annotation.DrvrDispSetg;
/*      */ import ecarx.car.hardware.annotation.IdRst;
/*      */ import ecarx.car.hardware.annotation.LDACSoftBtnSwtSt;
/*      */ import ecarx.car.hardware.annotation.LiTi2;
/*      */ import ecarx.car.hardware.annotation.ModeReq;
/*      */ import ecarx.car.hardware.annotation.NoYes1;
/*      */ import ecarx.car.hardware.annotation.OnOff1;
/*      */ import ecarx.car.hardware.annotation.PosPerc1;
/*      */ import ecarx.car.hardware.annotation.RiLeTyp;
/*      */ import ecarx.car.hardware.annotation.SteerAsscLvl;
/*      */ import ecarx.car.hardware.annotation.SteerMod;
/*      */ import ecarx.car.hardware.annotation.SuspHeiLvlCtrl;
/*      */ import ecarx.car.hardware.annotation.UnlckKeylsCfg2;
/*      */ import ecarx.car.hardware.annotation.UnlckRemCfg1;
/*      */ import ecarx.car.hardware.annotation.VFMiscMirrTiltSetg;
/*      */ import ecarx.car.hardware.annotation.VFMiscSelfDefineFunReq;
/*      */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
/*      */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ECarXCarVfmiscManager
/*      */   extends ECarXCarFuncManagerBase
/*      */ {
/*      */   private static final boolean DBG = false;
/*      */   public static final int ManagerId_cbafslightsetting = 33030;
/*      */   public static final int ManagerId_cbalhomesafelight = 33032;
/*      */   public static final int ManagerId_cbapproachlightonoffsetting = 33033;
/*      */   public static final int ManagerId_cbbatterychargebtn = 33062;
/*      */   public static final int ManagerId_cbbatterychargepercent = 33061;
/*      */   public static final int ManagerId_cbbendinglight = 33034;
/*      */   public static final int ManagerId_cbcornrglisetting = 33031;
/*      */   public static final int ManagerId_cbdeaclevctrsetting = 33042;
/*      */   public static final int ManagerId_cbdimthemedrvsetting = 33056;
/*      */   public static final int ManagerId_cbdoublelock = 33079;
/*      */   public static final int ManagerId_cbeasyentrysetting = 33041;
/*      */   public static final int ManagerId_cbelecseatbeltdriver = 33057;
/*      */   public static final int ManagerId_cbelecseatbeltpassenger = 33058;
/*      */   public static final int ManagerId_cbelectrictailgateopenbtn = 33064;
/*      */   public static final int ManagerId_cbelectrictailgatepossetting = 33065;
/*      */   public static final int ManagerId_cbelectrictailgatesetting = 33063;
/*      */   public static final int ManagerId_cbepbautoapply = 33044;
/*      */   public static final int ManagerId_cbexternalsoundsetting = 33046;
/*      */   public static final int ManagerId_cbfindcaremindersetting = 33024;
/*      */   public static final int ManagerId_cbhilldescentsetting = 33040;
/*      */   public static final int ManagerId_cbindividualthemeonoff = 33055;
/*      */   public static final int ManagerId_cbintelligentfusave = 33076;
/*      */   public static final int ManagerId_cbleftrightsetting = 33035;
/*      */   public static final int ManagerId_cblifedetectionswitch = 33077;
/*      */   public static final int ManagerId_cblockgfbsoundset = 33054;
/*      */   public static final int ManagerId_cblockingapproachtoopentrswt = 33080;
/*      */   public static final int ManagerId_cblowalarmvolset = 33048;
/*      */   public static final int ManagerId_cbmirrtiltsetg = 33039;
/*      */   public static final int ManagerId_cbparkingautoresetsetting = 33067;
/*      */   public static final int ManagerId_cbpasacslocksetting = 33052;
/*      */   public static final int ManagerId_cbpbcescsportactiv = 33029;
/*      */   public static final int ManagerId_cbpmcharge = 33060;
/*      */   public static final int ManagerId_cbpmhold = 33059;
/*      */   public static final int ManagerId_cbpressautoholdbtn = 33045;
/*      */   public static final int ManagerId_cbrearmirrorfoldauto = 33038;
/*      */   public static final int ManagerId_cbrearmirrors = 33078;
/*      */   public static final int ManagerId_cbrefuleautoresetsetting = 33068;
/*      */   public static final int ManagerId_cbsailingswitch = 33050;
/*      */   public static final int ManagerId_cbselfdefinefuncreq = 33066;
/*      */   public static final int ManagerId_cbspeedwarnonoff = 33049;
/*      */   public static final int ManagerId_cbspeedwarnset = 33047;
/*      */   public static final int ManagerId_cbssactivation = 33028;
/*      */   public static final int ManagerId_cbsteeringmod = 33026;
/*      */   public static final int ManagerId_cbsteeringwheelposadj = 33027;
/*      */   public static final int ManagerId_cbsteersteerassclvl = 33025;
/*      */   public static final int ManagerId_cbsuspheisetting = 33043;
/*      */   public static final int ManagerId_cbtripcomretall = 33069;
/*      */   public static final int ManagerId_cbtripcomrstaec = 33074;
/*      */   public static final int ManagerId_cbtripcomrstafc = 33073;
/*      */   public static final int ManagerId_cbtripcomrstavs = 33071;
/*      */   public static final int ManagerId_cbtripcomrstedt = 33072;
/*      */   public static final int ManagerId_cbtripcomrsttrip = 33070;
/*      */   public static final int ManagerId_cbtwostepunlcksetting = 33053;
/*      */   public static final int ManagerId_cbunlocksetting = 33051;
/*      */   public static final int ManagerId_cbuunpasarmngsts = 33022;
/*      */   public static final int ManagerId_cbuunredguardsts = 33023;
/*      */   public static final int ManagerId_cbvfmiscreboot = 33075;
/*      */   public static final int ManagerId_cbwelgoodbyelightmod = 33037;
/*      */   public static final int ManagerId_cbwelgoodbyelightswitch = 33036;
/*      */   public static final int ManagerId_pa360panorama = 33691;
/*      */   public static final int ManagerId_paafslightsetting = 33645;
/*      */   public static final int ManagerId_paalhomesafelight = 33647;
/*      */   public static final int ManagerId_paapproachlightonoffsetting = 33648;
/*      */   public static final int ManagerId_paautoholdstatus = 33661;
/*      */   public static final int ManagerId_pabatterychargepercent = 33682;
/*      */   public static final int ManagerId_pabendinglight = 33649;
/*      */   public static final int ManagerId_pachangefailmsg = 33683;
/*      */   public static final int ManagerId_pacollectionradio = 33694;
/*      */   public static final int ManagerId_pacornrglisetting = 33646;
/*      */   public static final int ManagerId_pacsdthemesetting = 33677;
/*      */   public static final int ManagerId_padeaclevctrsetting = 33657;
/*      */   public static final int ManagerId_padimthemedrvsetting = 33676;
/*      */   public static final int ManagerId_padoublelock = 33709;
/*      */   public static final int ManagerId_padsttrvldact = 33712;
/*      */   public static final int ManagerId_padsttrvldofeng = 33714;
/*      */   public static final int ManagerId_padsttrvldofev = 33713;
/*      */   public static final int ManagerId_padvr = 33690;
/*      */   public static final int ManagerId_paeasyentrysetting = 33656;
/*      */   public static final int ManagerId_paelecseatbeltdriver = 33678;
/*      */   public static final int ManagerId_paelecseatbeltpassenger = 33679;
/*      */   public static final int ManagerId_paelectrictailgateopenbtn = 33685;
/*      */   public static final int ManagerId_paelectrictailgatepossetting = 33686;
/*      */   public static final int ManagerId_paelectrictailgatesetting = 33684;
/*      */   public static final int ManagerId_paepbautoapply = 33660;
/*      */   public static final int ManagerId_paexternalsoundsetting = 33663;
/*      */   public static final int ManagerId_pafindcaremindersetting = 33639;
/*      */   public static final int ManagerId_pahealthofengoil = 33716;
/*      */   public static final int ManagerId_pahilldescentsetting = 33655;
/*      */   public static final int ManagerId_paindividualthemeonoff = 33675;
/*      */   public static final int ManagerId_paintelligentfusave = 33704;
/*      */   public static final int ManagerId_paleftrightsetting = 33650;
/*      */   public static final int ManagerId_palifedetectionswitch = 33706;
/*      */   public static final int ManagerId_palockgfbsoundset = 33674;
/*      */   public static final int ManagerId_palockingapproachtoopentrswt = 33710;
/*      */   public static final int ManagerId_palowalarmvolset = 33665;
/*      */   public static final int ManagerId_pamirrtiltsetg = 33654;
/*      */   public static final int ManagerId_panatusgdayofoil = 33715;
/*      */   public static final int ManagerId_panavihome = 33692;
/*      */   public static final int ManagerId_paparkingautoresetsetting = 33696;
/*      */   public static final int ManagerId_papasacslocksetting = 33672;
/*      */   public static final int ManagerId_papbcescsportactiv = 33644;
/*      */   public static final int ManagerId_papmcharge = 33681;
/*      */   public static final int ManagerId_papmhold = 33680;
/*      */   public static final int ManagerId_papowerflow = 33669;
/*      */   public static final int ManagerId_papowerflowhev = 33705;
/*      */   public static final int ManagerId_papowerflowmhev = 33670;
/*      */   public static final int ManagerId_parearmirrorfoldauto = 33653;
/*      */   public static final int ManagerId_parearmirrors = 33708;
/*      */   public static final int ManagerId_parefuleautoresetsetting = 33697;
/*      */   public static final int ManagerId_pasailingswitch = 33668;
/*      */   public static final int ManagerId_pascreenswitch = 33689;
/*      */   public static final int ManagerId_paselfdefinefuncreq = 33688;
/*      */   public static final int ManagerId_paserviceremindertype = 33711;
/*      */   public static final int ManagerId_pasourceswitch = 33693;
/*      */   public static final int ManagerId_paspeedwarnonoff = 33666;
/*      */   public static final int ManagerId_paspeedwarnset = 33664;
/*      */   public static final int ManagerId_paspeedwarnspeedlimit = 33667;
/*      */   public static final int ManagerId_passactivation = 33643;
/*      */   public static final int ManagerId_pasteeringwheelposadj = 33642;
/*      */   public static final int ManagerId_pasteersteerassclvl = 33640;
/*      */   public static final int ManagerId_pasteersteeringmod = 33641;
/*      */   public static final int ManagerId_pasuspheisetting = 33658;
/*      */   public static final int ManagerId_pasuspmovedirinform = 33659;
/*      */   public static final int ManagerId_patailgatests = 33687;
/*      */   public static final int ManagerId_patotaltraveleddistance = 33662;
/*      */   public static final int ManagerId_patripcomretall = 33698;
/*      */   public static final int ManagerId_patripcomrstaec = 33703;
/*      */   public static final int ManagerId_patripcomrstafc = 33702;
/*      */   public static final int ManagerId_patripcomrstavs = 33700;
/*      */   public static final int ManagerId_patripcomrstedt = 33701;
/*      */   public static final int ManagerId_patripcomrsttrip = 33699;
/*      */   public static final int ManagerId_patwostepunlcksetting = 33673;
/*      */   public static final int ManagerId_paunlcktrunk = 33707;
/*      */   public static final int ManagerId_paunlocksetting = 33671;
/*      */   public static final int ManagerId_pauunpasarmngsts = 33637;
/*      */   public static final int ManagerId_pauunredguardsts = 33638;
/*      */   public static final int ManagerId_pavindiffmsg = 33695;
/*      */   public static final int ManagerId_pavmmsgend = 33923;
/*      */   public static final int ManagerId_pawelgoodbyelightmod = 33652;
/*      */   public static final int ManagerId_pawelgoodbyelightswitch = 33651;
/*      */   private static final String TAG = "ECarXCarVfmiscManager";
/*      */   public static final int VehicleArea_Global = 1;
/*      */   public static final int VehicleArea_Zone = 2;
/*      */   
/*      */   public ECarXCarVfmiscManager() {}
/*      */   
/*      */   public ECarXCarVfmiscManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  211 */     super(paramECarXCarPropertyManagerBase);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_UUN_PasArmngSts(int paramInt) {
/*  221 */     ApiResult apiResult = ApiResult.FAILED;
/*  222 */     if (OnOff1.isValid(paramInt)) {
/*  223 */       apiResult = this.mMgr.setIntProperty(33022, 1, paramInt);
/*      */     } else {
/*  225 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  227 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_UUN_RedGuardSts(int paramInt) {
/*  237 */     ApiResult apiResult = ApiResult.FAILED;
/*  238 */     if (OnOff1.isValid(paramInt)) {
/*  239 */       apiResult = this.mMgr.setIntProperty(33023, 1, paramInt);
/*      */     } else {
/*  241 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  243 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_FindCaReminder_Setting(int paramInt) {
/*  253 */     ApiResult apiResult = ApiResult.FAILED;
/*  254 */     if (CarFindrHornLiSetActv.isValid(paramInt)) {
/*  255 */       apiResult = this.mMgr.setIntProperty(33024, 1, paramInt);
/*      */     } else {
/*  257 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  259 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Steer_SteerAsscLvl(int paramInt) {
/*  269 */     ApiResult apiResult = ApiResult.FAILED;
/*  270 */     if (SteerAsscLvl.isValid(paramInt)) {
/*  271 */       apiResult = this.mMgr.setIntProperty(33025, 1, paramInt);
/*      */     } else {
/*  273 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  275 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SteeringMod(int paramInt) {
/*  285 */     ApiResult apiResult = ApiResult.FAILED;
/*  286 */     if (SteerMod.isValid(paramInt)) {
/*  287 */       apiResult = this.mMgr.setIntProperty(33026, 1, paramInt);
/*      */     } else {
/*  289 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  291 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SteeringWheelPosAdj(int paramInt) {
/*  301 */     ApiResult apiResult = ApiResult.FAILED;
/*  302 */     if (OnOff1.isValid(paramInt)) {
/*  303 */       apiResult = this.mMgr.setIntProperty(33027, 1, paramInt);
/*      */     } else {
/*  305 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  307 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SS_Activation(int paramInt) {
/*  317 */     ApiResult apiResult = ApiResult.FAILED;
/*  318 */     if (OnOff1.isValid(paramInt)) {
/*  319 */       apiResult = this.mMgr.setIntProperty(33028, 1, paramInt);
/*      */     } else {
/*  321 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  323 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_PBC_ESCSportActiv(int paramInt) {
/*  333 */     ApiResult apiResult = ApiResult.FAILED;
/*  334 */     if (OnOff1.isValid(paramInt)) {
/*  335 */       apiResult = this.mMgr.setIntProperty(33029, 1, paramInt);
/*      */     } else {
/*  337 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  339 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AFSLight_Setting(int paramInt) {
/*  349 */     ApiResult apiResult = ApiResult.FAILED;
/*  350 */     if (OnOff1.isValid(paramInt)) {
/*  351 */       apiResult = this.mMgr.setIntProperty(33030, 1, paramInt);
/*      */     } else {
/*  353 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  355 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CornrgLi_Setting(int paramInt) {
/*  365 */     ApiResult apiResult = ApiResult.FAILED;
/*  366 */     if (OnOff1.isValid(paramInt)) {
/*  367 */       apiResult = this.mMgr.setIntProperty(33031, 1, paramInt);
/*      */     } else {
/*  369 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  371 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AL_HomeSafeLight(int paramInt) {
/*  381 */     ApiResult apiResult = ApiResult.FAILED;
/*  382 */     if (LiTi2.isValid(paramInt)) {
/*  383 */       apiResult = this.mMgr.setIntProperty(33032, 1, paramInt);
/*      */     } else {
/*  385 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  387 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ApproachLightOnOff_Setting(int paramInt) {
/*  397 */     ApiResult apiResult = ApiResult.FAILED;
/*  398 */     if (OnOff1.isValid(paramInt)) {
/*  399 */       apiResult = this.mMgr.setIntProperty(33033, 1, paramInt);
/*      */     } else {
/*  401 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  403 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_BendingLight(int paramInt) {
/*  413 */     ApiResult apiResult = ApiResult.FAILED;
/*  414 */     if (OnOff1.isValid(paramInt)) {
/*  415 */       apiResult = this.mMgr.setIntProperty(33034, 1, paramInt);
/*      */     } else {
/*  417 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  419 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LeftRightSetting(int paramInt) {
/*  429 */     ApiResult apiResult = ApiResult.FAILED;
/*  430 */     if (RiLeTyp.isValid(paramInt)) {
/*  431 */       apiResult = this.mMgr.setIntProperty(33035, 1, paramInt);
/*      */     } else {
/*  433 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  435 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_WelGoodbyeLightSwitch(int paramInt) {
/*  445 */     ApiResult apiResult = ApiResult.FAILED;
/*  446 */     if (OnOff1.isValid(paramInt)) {
/*  447 */       apiResult = this.mMgr.setIntProperty(33036, 1, paramInt);
/*      */     } else {
/*  449 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  451 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_WelGoodbyeLightMod(int paramInt) {
/*  461 */     ApiResult apiResult = ApiResult.FAILED;
/*  462 */     if (ModeReq.isValid(paramInt)) {
/*  463 */       apiResult = this.mMgr.setIntProperty(33037, 1, paramInt);
/*      */     } else {
/*  465 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  467 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_RearMirrorFold_Auto(int paramInt) {
/*  477 */     ApiResult apiResult = ApiResult.FAILED;
/*  478 */     if (OnOff1.isValid(paramInt)) {
/*  479 */       apiResult = this.mMgr.setIntProperty(33038, 1, paramInt);
/*      */     } else {
/*  481 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  483 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MirrTiltSetg(int paramInt) {
/*  493 */     ApiResult apiResult = ApiResult.FAILED;
/*  494 */     if (VFMiscMirrTiltSetg.isValid(paramInt)) {
/*  495 */       apiResult = this.mMgr.setIntProperty(33039, 1, paramInt);
/*      */     } else {
/*  497 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  499 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_HillDescentSetting(int paramInt) {
/*  509 */     ApiResult apiResult = ApiResult.FAILED;
/*  510 */     if (OnOff1.isValid(paramInt)) {
/*  511 */       apiResult = this.mMgr.setIntProperty(33040, 1, paramInt);
/*      */     } else {
/*  513 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  515 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_EasyEntrySetting(int paramInt) {
/*  525 */     ApiResult apiResult = ApiResult.FAILED;
/*  526 */     if (NoYes1.isValid(paramInt)) {
/*  527 */       apiResult = this.mMgr.setIntProperty(33041, 1, paramInt);
/*      */     } else {
/*  529 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  531 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_DeacLevCtrSetting(int paramInt) {
/*  541 */     ApiResult apiResult = ApiResult.FAILED;
/*  542 */     if (BooleanType.isValid(paramInt)) {
/*  543 */       apiResult = this.mMgr.setIntProperty(33042, 1, paramInt);
/*      */     } else {
/*  545 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  547 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SuspHeiSetting(int paramInt) {
/*  557 */     ApiResult apiResult = ApiResult.FAILED;
/*  558 */     if (SuspHeiLvlCtrl.isValid(paramInt)) {
/*  559 */       apiResult = this.mMgr.setIntProperty(33043, 1, paramInt);
/*      */     } else {
/*  561 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  563 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_EPBAutoApply(int paramInt) {
/*  573 */     ApiResult apiResult = ApiResult.FAILED;
/*  574 */     if (OnOff1.isValid(paramInt)) {
/*  575 */       apiResult = this.mMgr.setIntProperty(33044, 1, paramInt);
/*      */     } else {
/*  577 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  579 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_PressAutoholdBtn(int paramInt) {
/*  589 */     ApiResult apiResult = ApiResult.FAILED;
/*  590 */     if (OnOff1.isValid(paramInt)) {
/*  591 */       apiResult = this.mMgr.setIntProperty(33045, 1, paramInt);
/*      */     } else {
/*  593 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  595 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_External_Sound_Setting(int paramInt) {
/*  605 */     ApiResult apiResult = ApiResult.FAILED;
/*  606 */     if (OnOff1.isValid(paramInt)) {
/*  607 */       apiResult = this.mMgr.setIntProperty(33046, 1, paramInt);
/*      */     } else {
/*  609 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  611 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SpeedWarnSet(int paramInt) {
/*  621 */     return this.mMgr.setIntProperty(33047, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LowAlarmVolSet(int paramInt) {
/*  631 */     ApiResult apiResult = ApiResult.FAILED;
/*  632 */     if (ClassnQly.isValid(paramInt)) {
/*  633 */       apiResult = this.mMgr.setIntProperty(33048, 1, paramInt);
/*      */     } else {
/*  635 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  637 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SpeedWarnOnOff(int paramInt) {
/*  647 */     ApiResult apiResult = ApiResult.FAILED;
/*  648 */     if (OnOff1.isValid(paramInt)) {
/*  649 */       apiResult = this.mMgr.setIntProperty(33049, 1, paramInt);
/*      */     } else {
/*  651 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  653 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SailingSwitch(int paramInt) {
/*  663 */     ApiResult apiResult = ApiResult.FAILED;
/*  664 */     if (ActvnAvl3.isValid(paramInt)) {
/*  665 */       apiResult = this.mMgr.setIntProperty(33050, 1, paramInt);
/*      */     } else {
/*  667 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  669 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_UnlockSetting(int paramInt) {
/*  679 */     ApiResult apiResult = ApiResult.FAILED;
/*  680 */     if (UnlckKeylsCfg2.isValid(paramInt)) {
/*  681 */       apiResult = this.mMgr.setIntProperty(33051, 1, paramInt);
/*      */     } else {
/*  683 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  685 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_PasAcsLock_Setting(int paramInt) {
/*  695 */     ApiResult apiResult = ApiResult.FAILED;
/*  696 */     if (OnOff1.isValid(paramInt)) {
/*  697 */       apiResult = this.mMgr.setIntProperty(33052, 1, paramInt);
/*      */     } else {
/*  699 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  701 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TwoStepUnlck_Setting(int paramInt) {
/*  711 */     ApiResult apiResult = ApiResult.FAILED;
/*  712 */     if (UnlckRemCfg1.isValid(paramInt)) {
/*  713 */       apiResult = this.mMgr.setIntProperty(33053, 1, paramInt);
/*      */     } else {
/*  715 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  717 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LockgFbSoundSet(int paramInt) {
/*  727 */     ApiResult apiResult = ApiResult.FAILED;
/*  728 */     if (OnOff1.isValid(paramInt)) {
/*  729 */       apiResult = this.mMgr.setIntProperty(33054, 1, paramInt);
/*      */     } else {
/*  731 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  733 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Individualtheme_OnOff(int paramInt) {
/*  743 */     ApiResult apiResult = ApiResult.FAILED;
/*  744 */     if (OnOff1.isValid(paramInt)) {
/*  745 */       apiResult = this.mMgr.setIntProperty(33055, 1, paramInt);
/*      */     } else {
/*  747 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  749 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_DIMTheme_DrvSetting(int paramInt) {
/*  759 */     ApiResult apiResult = ApiResult.FAILED;
/*  760 */     if (DrvrDispSetg.isValid(paramInt)) {
/*  761 */       apiResult = this.mMgr.setIntProperty(33056, 1, paramInt);
/*      */     } else {
/*  763 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  765 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ElecSeatbelt_Driver(int paramInt) {
/*  775 */     ApiResult apiResult = ApiResult.FAILED;
/*  776 */     if (OnOff1.isValid(paramInt)) {
/*  777 */       apiResult = this.mMgr.setIntProperty(33057, 1, paramInt);
/*      */     } else {
/*  779 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  781 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ElecSeatbelt_Passenger(int paramInt) {
/*  791 */     ApiResult apiResult = ApiResult.FAILED;
/*  792 */     if (OnOff1.isValid(paramInt)) {
/*  793 */       apiResult = this.mMgr.setIntProperty(33058, 1, paramInt);
/*      */     } else {
/*  795 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  797 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_PM_Hold(int paramInt) {
/*  807 */     ApiResult apiResult = ApiResult.FAILED;
/*  808 */     if (OnOff1.isValid(paramInt)) {
/*  809 */       apiResult = this.mMgr.setIntProperty(33059, 1, paramInt);
/*      */     } else {
/*  811 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  813 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_PM_Charge(int paramInt) {
/*  823 */     ApiResult apiResult = ApiResult.FAILED;
/*  824 */     if (OnOff1.isValid(paramInt)) {
/*  825 */       apiResult = this.mMgr.setIntProperty(33060, 1, paramInt);
/*      */     } else {
/*  827 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  829 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Battery_Charge_Percent(int paramInt) {
/*  839 */     return this.mMgr.setIntProperty(33061, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Battery_Charge_Btn(int paramInt) {
/*  849 */     return this.mMgr.setIntProperty(33062, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ElectricTailgate_Setting(int paramInt) {
/*  859 */     ApiResult apiResult = ApiResult.FAILED;
/*  860 */     if (DoorOpenerReq1.isValid(paramInt)) {
/*  861 */       apiResult = this.mMgr.setIntProperty(33063, 1, paramInt);
/*      */     } else {
/*  863 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  865 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ElectricTailgate_OpenBtn(int paramInt) {
/*  875 */     ApiResult apiResult = ApiResult.FAILED;
/*  876 */     if (DoorOpenerReq1.isValid(paramInt)) {
/*  877 */       apiResult = this.mMgr.setIntProperty(33064, 1, paramInt);
/*      */     } else {
/*  879 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  881 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ElectricTailgate_PosSetting(int paramInt) {
/*  891 */     ApiResult apiResult = ApiResult.FAILED;
/*  892 */     if (PosPerc1.isValid(paramInt)) {
/*  893 */       apiResult = this.mMgr.setIntProperty(33065, 1, paramInt);
/*      */     } else {
/*  895 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  897 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SelfDefineFuncReq(int paramInt) {
/*  907 */     ApiResult apiResult = ApiResult.FAILED;
/*  908 */     if (VFMiscSelfDefineFunReq.isValid(paramInt)) {
/*  909 */       apiResult = this.mMgr.setIntProperty(33066, 1, paramInt);
/*      */     } else {
/*  911 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  913 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ParkingAutoResetSetting(int paramInt) {
/*  923 */     ApiResult apiResult = ApiResult.FAILED;
/*  924 */     if (OnOff1.isValid(paramInt)) {
/*  925 */       apiResult = this.mMgr.setIntProperty(33067, 1, paramInt);
/*      */     } else {
/*  927 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  929 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_RefuleAutoResetSetting(int paramInt) {
/*  939 */     ApiResult apiResult = ApiResult.FAILED;
/*  940 */     if (OnOff1.isValid(paramInt)) {
/*  941 */       apiResult = this.mMgr.setIntProperty(33068, 1, paramInt);
/*      */     } else {
/*  943 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  945 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TripCom_RetALL(int paramInt) {
/*  955 */     ApiResult apiResult = ApiResult.FAILED;
/*  956 */     if (IdRst.isValid(paramInt)) {
/*  957 */       apiResult = this.mMgr.setIntProperty(33069, 1, paramInt);
/*      */     } else {
/*  959 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  961 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TripCom_RstTrip(int paramInt) {
/*  971 */     ApiResult apiResult = ApiResult.FAILED;
/*  972 */     if (IdRst.isValid(paramInt)) {
/*  973 */       apiResult = this.mMgr.setIntProperty(33070, 1, paramInt);
/*      */     } else {
/*  975 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  977 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TripCom_RstAVS(int paramInt) {
/*  987 */     ApiResult apiResult = ApiResult.FAILED;
/*  988 */     if (IdRst.isValid(paramInt)) {
/*  989 */       apiResult = this.mMgr.setIntProperty(33071, 1, paramInt);
/*      */     } else {
/*  991 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  993 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TripCom_RstEDT(int paramInt) {
/* 1003 */     ApiResult apiResult = ApiResult.FAILED;
/* 1004 */     if (IdRst.isValid(paramInt)) {
/* 1005 */       apiResult = this.mMgr.setIntProperty(33072, 1, paramInt);
/*      */     } else {
/* 1007 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1009 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TripCom_RstAFC(int paramInt) {
/* 1019 */     ApiResult apiResult = ApiResult.FAILED;
/* 1020 */     if (IdRst.isValid(paramInt)) {
/* 1021 */       apiResult = this.mMgr.setIntProperty(33073, 1, paramInt);
/*      */     } else {
/* 1023 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1025 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TripCom_RstAEC(int paramInt) {
/* 1035 */     ApiResult apiResult = ApiResult.FAILED;
/* 1036 */     if (IdRst.isValid(paramInt)) {
/* 1037 */       apiResult = this.mMgr.setIntProperty(33074, 1, paramInt);
/*      */     } else {
/* 1039 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1041 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_VFMisc_Reboot(int paramInt) {
/* 1051 */     return this.mMgr.setIntProperty(33075, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_IntelligentFuSave(int paramInt) {
/* 1061 */     ApiResult apiResult = ApiResult.FAILED;
/* 1062 */     if (OnOff1.isValid(paramInt)) {
/* 1063 */       apiResult = this.mMgr.setIntProperty(33076, 1, paramInt);
/*      */     } else {
/* 1065 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1067 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LifeDetectionSwitch(int paramInt) {
/* 1077 */     ApiResult apiResult = ApiResult.FAILED;
/* 1078 */     if (LDACSoftBtnSwtSt.isValid(paramInt)) {
/* 1079 */       apiResult = this.mMgr.setIntProperty(33077, 1, paramInt);
/*      */     } else {
/* 1081 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1083 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_RearMirrors(int paramInt) {
/* 1093 */     ApiResult apiResult = ApiResult.FAILED;
/* 1094 */     if (OnOff1.isValid(paramInt)) {
/* 1095 */       apiResult = this.mMgr.setIntProperty(33078, 1, paramInt);
/*      */     } else {
/* 1097 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1099 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_DoubleLock(int paramInt) {
/* 1109 */     ApiResult apiResult = ApiResult.FAILED;
/* 1110 */     if (OnOff1.isValid(paramInt)) {
/* 1111 */       apiResult = this.mMgr.setIntProperty(33079, 1, paramInt);
/*      */     } else {
/* 1113 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1115 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Locking_ApproachToOpenTrSwt(int paramInt) {
/* 1125 */     ApiResult apiResult = ApiResult.FAILED;
/* 1126 */     if (OnOff1.isValid(paramInt)) {
/* 1127 */       apiResult = this.mMgr.setIntProperty(33080, 1, paramInt);
/*      */     } else {
/* 1129 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/* 1131 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_UUN_PasArmngSts getPA_UUN_PasArmngSts() throws CarNotConnectedException {
/* 1142 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33637, 1);
/*      */     
/* 1144 */     PATypes.PA_UUN_PasArmngSts pA_UUN_PasArmngSts = null;
/*      */     try {
/* 1146 */       PATypes.PA_UUN_PasArmngSts pA_UUN_PasArmngSts1 = new PATypes.PA_UUN_PasArmngSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_UUN_PasArmngSts = pA_UUN_PasArmngSts1;
/* 1147 */     } catch (Exception exception) {}
/*      */     
/* 1149 */     return pA_UUN_PasArmngSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_UUN_RedGuardSts getPA_UUN_RedGuardSts() throws CarNotConnectedException {
/* 1158 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33638, 1);
/*      */     
/* 1160 */     PATypes.PA_UUN_RedGuardSts pA_UUN_RedGuardSts = null;
/*      */     try {
/* 1162 */       PATypes.PA_UUN_RedGuardSts pA_UUN_RedGuardSts1 = new PATypes.PA_UUN_RedGuardSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_UUN_RedGuardSts = pA_UUN_RedGuardSts1;
/* 1163 */     } catch (Exception exception) {}
/*      */     
/* 1165 */     return pA_UUN_RedGuardSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_FindCaReminder_Setting getPA_FindCaReminder_Setting() throws CarNotConnectedException {
/* 1174 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33639, 1);
/*      */     
/* 1176 */     PATypes.PA_FindCaReminder_Setting pA_FindCaReminder_Setting = null;
/*      */     try {
/* 1178 */       PATypes.PA_FindCaReminder_Setting pA_FindCaReminder_Setting1 = new PATypes.PA_FindCaReminder_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FindCaReminder_Setting = pA_FindCaReminder_Setting1;
/* 1179 */     } catch (Exception exception) {}
/*      */     
/* 1181 */     return pA_FindCaReminder_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Steer_SteerAsscLvl getPA_Steer_SteerAsscLvl() throws CarNotConnectedException {
/* 1190 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33640, 1);
/*      */     
/* 1192 */     PATypes.PA_Steer_SteerAsscLvl pA_Steer_SteerAsscLvl = null;
/*      */     try {
/* 1194 */       PATypes.PA_Steer_SteerAsscLvl pA_Steer_SteerAsscLvl1 = new PATypes.PA_Steer_SteerAsscLvl(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Steer_SteerAsscLvl = pA_Steer_SteerAsscLvl1;
/* 1195 */     } catch (Exception exception) {}
/*      */     
/* 1197 */     return pA_Steer_SteerAsscLvl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Steer_SteeringMod getPA_Steer_SteeringMod() throws CarNotConnectedException {
/* 1206 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33641, 1);
/*      */     
/* 1208 */     PATypes.PA_Steer_SteeringMod pA_Steer_SteeringMod = null;
/*      */     try {
/* 1210 */       PATypes.PA_Steer_SteeringMod pA_Steer_SteeringMod1 = new PATypes.PA_Steer_SteeringMod(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Steer_SteeringMod = pA_Steer_SteeringMod1;
/* 1211 */     } catch (Exception exception) {}
/*      */     
/* 1213 */     return pA_Steer_SteeringMod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SteeringWheelPosAdj getPA_SteeringWheelPosAdj() throws CarNotConnectedException {
/* 1222 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33642, 1);
/*      */     
/* 1224 */     PATypes.PA_SteeringWheelPosAdj pA_SteeringWheelPosAdj = null;
/*      */     try {
/* 1226 */       PATypes.PA_SteeringWheelPosAdj pA_SteeringWheelPosAdj1 = new PATypes.PA_SteeringWheelPosAdj(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SteeringWheelPosAdj = pA_SteeringWheelPosAdj1;
/* 1227 */     } catch (Exception exception) {}
/*      */     
/* 1229 */     return pA_SteeringWheelPosAdj;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SS_Activation getPA_SS_Activation() throws CarNotConnectedException {
/* 1238 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33643, 1);
/*      */     
/* 1240 */     PATypes.PA_SS_Activation pA_SS_Activation = null;
/*      */     try {
/* 1242 */       PATypes.PA_SS_Activation pA_SS_Activation1 = new PATypes.PA_SS_Activation(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SS_Activation = pA_SS_Activation1;
/* 1243 */     } catch (Exception exception) {}
/*      */     
/* 1245 */     return pA_SS_Activation;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PBC_ESCSportActiv getPA_PBC_ESCSportActiv() throws CarNotConnectedException {
/* 1254 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33644, 1);
/*      */     
/* 1256 */     PATypes.PA_PBC_ESCSportActiv pA_PBC_ESCSportActiv = null;
/*      */     try {
/* 1258 */       PATypes.PA_PBC_ESCSportActiv pA_PBC_ESCSportActiv1 = new PATypes.PA_PBC_ESCSportActiv(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PBC_ESCSportActiv = pA_PBC_ESCSportActiv1;
/* 1259 */     } catch (Exception exception) {}
/*      */     
/* 1261 */     return pA_PBC_ESCSportActiv;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AFSLight_Setting getPA_AFSLight_Setting() throws CarNotConnectedException {
/* 1270 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33645, 1);
/*      */     
/* 1272 */     PATypes.PA_AFSLight_Setting pA_AFSLight_Setting = null;
/*      */     try {
/* 1274 */       PATypes.PA_AFSLight_Setting pA_AFSLight_Setting1 = new PATypes.PA_AFSLight_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AFSLight_Setting = pA_AFSLight_Setting1;
/* 1275 */     } catch (Exception exception) {}
/*      */     
/* 1277 */     return pA_AFSLight_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CornrgLi_Setting getPA_CornrgLi_Setting() throws CarNotConnectedException {
/* 1286 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33646, 1);
/*      */     
/* 1288 */     PATypes.PA_CornrgLi_Setting pA_CornrgLi_Setting = null;
/*      */     try {
/* 1290 */       PATypes.PA_CornrgLi_Setting pA_CornrgLi_Setting1 = new PATypes.PA_CornrgLi_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CornrgLi_Setting = pA_CornrgLi_Setting1;
/* 1291 */     } catch (Exception exception) {}
/*      */     
/* 1293 */     return pA_CornrgLi_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AL_HomeSafeLight getPA_AL_HomeSafeLight() throws CarNotConnectedException {
/* 1302 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33647, 1);
/*      */     
/* 1304 */     PATypes.PA_AL_HomeSafeLight pA_AL_HomeSafeLight = null;
/*      */     try {
/* 1306 */       PATypes.PA_AL_HomeSafeLight pA_AL_HomeSafeLight1 = new PATypes.PA_AL_HomeSafeLight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AL_HomeSafeLight = pA_AL_HomeSafeLight1;
/* 1307 */     } catch (Exception exception) {}
/*      */     
/* 1309 */     return pA_AL_HomeSafeLight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ApproachLightOnOff_Setting getPA_ApproachLightOnOff_Setting() throws CarNotConnectedException {
/* 1318 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33648, 1);
/*      */     
/* 1320 */     PATypes.PA_ApproachLightOnOff_Setting pA_ApproachLightOnOff_Setting = null;
/*      */     try {
/* 1322 */       PATypes.PA_ApproachLightOnOff_Setting pA_ApproachLightOnOff_Setting1 = new PATypes.PA_ApproachLightOnOff_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ApproachLightOnOff_Setting = pA_ApproachLightOnOff_Setting1;
/* 1323 */     } catch (Exception exception) {}
/*      */     
/* 1325 */     return pA_ApproachLightOnOff_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_BendingLight getPA_BendingLight() throws CarNotConnectedException {
/* 1334 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33649, 1);
/*      */     
/* 1336 */     PATypes.PA_BendingLight pA_BendingLight = null;
/*      */     try {
/* 1338 */       PATypes.PA_BendingLight pA_BendingLight1 = new PATypes.PA_BendingLight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_BendingLight = pA_BendingLight1;
/* 1339 */     } catch (Exception exception) {}
/*      */     
/* 1341 */     return pA_BendingLight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_LeftRightSetting getPA_LeftRightSetting() throws CarNotConnectedException {
/* 1350 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33650, 1);
/*      */     
/* 1352 */     PATypes.PA_LeftRightSetting pA_LeftRightSetting = null;
/*      */     try {
/* 1354 */       PATypes.PA_LeftRightSetting pA_LeftRightSetting1 = new PATypes.PA_LeftRightSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LeftRightSetting = pA_LeftRightSetting1;
/* 1355 */     } catch (Exception exception) {}
/*      */     
/* 1357 */     return pA_LeftRightSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_WelGoodbyeLightSwitch getPA_WelGoodbyeLightSwitch() throws CarNotConnectedException {
/* 1366 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33651, 1);
/*      */     
/* 1368 */     PATypes.PA_WelGoodbyeLightSwitch pA_WelGoodbyeLightSwitch = null;
/*      */     try {
/* 1370 */       PATypes.PA_WelGoodbyeLightSwitch pA_WelGoodbyeLightSwitch1 = new PATypes.PA_WelGoodbyeLightSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WelGoodbyeLightSwitch = pA_WelGoodbyeLightSwitch1;
/* 1371 */     } catch (Exception exception) {}
/*      */     
/* 1373 */     return pA_WelGoodbyeLightSwitch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_WelGoodbyeLightMod getPA_WelGoodbyeLightMod() throws CarNotConnectedException {
/* 1382 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33652, 1);
/*      */     
/* 1384 */     PATypes.PA_WelGoodbyeLightMod pA_WelGoodbyeLightMod = null;
/*      */     try {
/* 1386 */       PATypes.PA_WelGoodbyeLightMod pA_WelGoodbyeLightMod1 = new PATypes.PA_WelGoodbyeLightMod(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WelGoodbyeLightMod = pA_WelGoodbyeLightMod1;
/* 1387 */     } catch (Exception exception) {}
/*      */     
/* 1389 */     return pA_WelGoodbyeLightMod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_RearMirrorFold_Auto getPA_RearMirrorFold_Auto() throws CarNotConnectedException {
/* 1398 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33653, 1);
/*      */     
/* 1400 */     PATypes.PA_RearMirrorFold_Auto pA_RearMirrorFold_Auto = null;
/*      */     try {
/* 1402 */       PATypes.PA_RearMirrorFold_Auto pA_RearMirrorFold_Auto1 = new PATypes.PA_RearMirrorFold_Auto(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_RearMirrorFold_Auto = pA_RearMirrorFold_Auto1;
/* 1403 */     } catch (Exception exception) {}
/*      */     
/* 1405 */     return pA_RearMirrorFold_Auto;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_MirrTiltSetg getPA_MirrTiltSetg() throws CarNotConnectedException {
/* 1414 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33654, 1);
/*      */     
/* 1416 */     PATypes.PA_MirrTiltSetg pA_MirrTiltSetg = null;
/*      */     try {
/* 1418 */       PATypes.PA_MirrTiltSetg pA_MirrTiltSetg1 = new PATypes.PA_MirrTiltSetg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_MirrTiltSetg = pA_MirrTiltSetg1;
/* 1419 */     } catch (Exception exception) {}
/*      */     
/* 1421 */     return pA_MirrTiltSetg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_HillDescentSetting getPA_HillDescentSetting() throws CarNotConnectedException {
/* 1430 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33655, 1);
/*      */     
/* 1432 */     PATypes.PA_HillDescentSetting pA_HillDescentSetting = null;
/*      */     try {
/* 1434 */       PATypes.PA_HillDescentSetting pA_HillDescentSetting1 = new PATypes.PA_HillDescentSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HillDescentSetting = pA_HillDescentSetting1;
/* 1435 */     } catch (Exception exception) {}
/*      */     
/* 1437 */     return pA_HillDescentSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_EasyEntrySetting getPA_EasyEntrySetting() throws CarNotConnectedException {
/* 1446 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33656, 1);
/*      */     
/* 1448 */     PATypes.PA_EasyEntrySetting pA_EasyEntrySetting = null;
/*      */     try {
/* 1450 */       PATypes.PA_EasyEntrySetting pA_EasyEntrySetting1 = new PATypes.PA_EasyEntrySetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_EasyEntrySetting = pA_EasyEntrySetting1;
/* 1451 */     } catch (Exception exception) {}
/*      */     
/* 1453 */     return pA_EasyEntrySetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DeacLevCtrSetting getPA_DeacLevCtrSetting() throws CarNotConnectedException {
/* 1462 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33657, 1);
/*      */     
/* 1464 */     PATypes.PA_DeacLevCtrSetting pA_DeacLevCtrSetting = null;
/*      */     try {
/* 1466 */       PATypes.PA_DeacLevCtrSetting pA_DeacLevCtrSetting1 = new PATypes.PA_DeacLevCtrSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DeacLevCtrSetting = pA_DeacLevCtrSetting1;
/* 1467 */     } catch (Exception exception) {}
/*      */     
/* 1469 */     return pA_DeacLevCtrSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SuspHeiSetting getPA_SuspHeiSetting() throws CarNotConnectedException {
/* 1478 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33658, 1);
/*      */     
/* 1480 */     PATypes.PA_SuspHeiSetting pA_SuspHeiSetting = null;
/*      */     try {
/* 1482 */       PATypes.PA_SuspHeiSetting pA_SuspHeiSetting1 = new PATypes.PA_SuspHeiSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SuspHeiSetting = pA_SuspHeiSetting1;
/* 1483 */     } catch (Exception exception) {}
/*      */     
/* 1485 */     return pA_SuspHeiSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SuspMoveDirInform getPA_SuspMoveDirInform() throws CarNotConnectedException {
/* 1494 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33659, 1);
/*      */     
/* 1496 */     PATypes.PA_SuspMoveDirInform pA_SuspMoveDirInform = null;
/*      */     try {
/* 1498 */       PATypes.PA_SuspMoveDirInform pA_SuspMoveDirInform1 = new PATypes.PA_SuspMoveDirInform(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SuspMoveDirInform = pA_SuspMoveDirInform1;
/* 1499 */     } catch (Exception exception) {}
/*      */     
/* 1501 */     return pA_SuspMoveDirInform;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_EPBAutoApply getPA_EPBAutoApply() throws CarNotConnectedException {
/* 1510 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33660, 1);
/*      */     
/* 1512 */     PATypes.PA_EPBAutoApply pA_EPBAutoApply = null;
/*      */     try {
/* 1514 */       PATypes.PA_EPBAutoApply pA_EPBAutoApply1 = new PATypes.PA_EPBAutoApply(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_EPBAutoApply = pA_EPBAutoApply1;
/* 1515 */     } catch (Exception exception) {}
/*      */     
/* 1517 */     return pA_EPBAutoApply;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AutoHoldStatus getPA_AutoHoldStatus() throws CarNotConnectedException {
/* 1526 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33661, 1);
/*      */     
/* 1528 */     PATypes.PA_AutoHoldStatus pA_AutoHoldStatus = null;
/*      */     try {
/* 1530 */       PATypes.PA_AutoHoldStatus pA_AutoHoldStatus1 = new PATypes.PA_AutoHoldStatus(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AutoHoldStatus = pA_AutoHoldStatus1;
/* 1531 */     } catch (Exception exception) {}
/*      */     
/* 1533 */     return pA_AutoHoldStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Total_Traveled_Distance getPA_Total_Traveled_Distance() throws CarNotConnectedException {
/* 1542 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33662, 1);
/*      */     
/* 1544 */     PATypes.PA_Total_Traveled_Distance pA_Total_Traveled_Distance = null;
/*      */     try {
/* 1546 */       PATypes.PA_Total_Traveled_Distance pA_Total_Traveled_Distance1 = new PATypes.PA_Total_Traveled_Distance(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Total_Traveled_Distance = pA_Total_Traveled_Distance1;
/* 1547 */     } catch (Exception exception) {}
/*      */     
/* 1549 */     return pA_Total_Traveled_Distance;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_External_Sound_Setting getPA_External_Sound_Setting() throws CarNotConnectedException {
/* 1558 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33663, 1);
/*      */     
/* 1560 */     PATypes.PA_External_Sound_Setting pA_External_Sound_Setting = null;
/*      */     try {
/* 1562 */       PATypes.PA_External_Sound_Setting pA_External_Sound_Setting1 = new PATypes.PA_External_Sound_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_External_Sound_Setting = pA_External_Sound_Setting1;
/* 1563 */     } catch (Exception exception) {}
/*      */     
/* 1565 */     return pA_External_Sound_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SpeedWarnSet getPA_SpeedWarnSet() throws CarNotConnectedException {
/* 1574 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33664, 1);
/*      */     
/* 1576 */     PATypes.PA_SpeedWarnSet pA_SpeedWarnSet = null;
/*      */     try {
/* 1578 */       PATypes.PA_SpeedWarnSet pA_SpeedWarnSet1 = new PATypes.PA_SpeedWarnSet(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SpeedWarnSet = pA_SpeedWarnSet1;
/* 1579 */     } catch (Exception exception) {}
/*      */     
/* 1581 */     return pA_SpeedWarnSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_LowAlarmVolSet getPA_LowAlarmVolSet() throws CarNotConnectedException {
/* 1590 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33665, 1);
/*      */     
/* 1592 */     PATypes.PA_LowAlarmVolSet pA_LowAlarmVolSet = null;
/*      */     try {
/* 1594 */       PATypes.PA_LowAlarmVolSet pA_LowAlarmVolSet1 = new PATypes.PA_LowAlarmVolSet(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LowAlarmVolSet = pA_LowAlarmVolSet1;
/* 1595 */     } catch (Exception exception) {}
/*      */     
/* 1597 */     return pA_LowAlarmVolSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SpeedWarnOnOff getPA_SpeedWarnOnOff() throws CarNotConnectedException {
/* 1606 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33666, 1);
/*      */     
/* 1608 */     PATypes.PA_SpeedWarnOnOff pA_SpeedWarnOnOff = null;
/*      */     try {
/* 1610 */       PATypes.PA_SpeedWarnOnOff pA_SpeedWarnOnOff1 = new PATypes.PA_SpeedWarnOnOff(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SpeedWarnOnOff = pA_SpeedWarnOnOff1;
/* 1611 */     } catch (Exception exception) {}
/*      */     
/* 1613 */     return pA_SpeedWarnOnOff;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SpeedWarnSpeedLimit getPA_SpeedWarnSpeedLimit() throws CarNotConnectedException {
/* 1622 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33667, 1);
/*      */     
/* 1624 */     PATypes.PA_SpeedWarnSpeedLimit pA_SpeedWarnSpeedLimit = null;
/*      */     try {
/* 1626 */       PATypes.PA_SpeedWarnSpeedLimit pA_SpeedWarnSpeedLimit1 = new PATypes.PA_SpeedWarnSpeedLimit(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SpeedWarnSpeedLimit = pA_SpeedWarnSpeedLimit1;
/* 1627 */     } catch (Exception exception) {}
/*      */     
/* 1629 */     return pA_SpeedWarnSpeedLimit;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SailingSwitch getPA_SailingSwitch() throws CarNotConnectedException {
/* 1638 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33668, 1);
/*      */     
/* 1640 */     PATypes.PA_SailingSwitch pA_SailingSwitch = null;
/*      */     try {
/* 1642 */       PATypes.PA_SailingSwitch pA_SailingSwitch1 = new PATypes.PA_SailingSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SailingSwitch = pA_SailingSwitch1;
/* 1643 */     } catch (Exception exception) {}
/*      */     
/* 1645 */     return pA_SailingSwitch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PowerFlow getPA_PowerFlow() throws CarNotConnectedException {
/* 1654 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33669, 1);
/*      */     
/* 1656 */     PATypes.PA_PowerFlow pA_PowerFlow = null;
/*      */     try {
/* 1658 */       PATypes.PA_PowerFlow pA_PowerFlow1 = new PATypes.PA_PowerFlow(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PowerFlow = pA_PowerFlow1;
/* 1659 */     } catch (Exception exception) {}
/*      */     
/* 1661 */     return pA_PowerFlow;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PowerFlow_MHEV getPA_PowerFlow_MHEV() throws CarNotConnectedException {
/* 1670 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33670, 1);
/*      */     
/* 1672 */     PATypes.PA_PowerFlow_MHEV pA_PowerFlow_MHEV = null;
/*      */     try {
/* 1674 */       PATypes.PA_PowerFlow_MHEV pA_PowerFlow_MHEV1 = new PATypes.PA_PowerFlow_MHEV(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PowerFlow_MHEV = pA_PowerFlow_MHEV1;
/* 1675 */     } catch (Exception exception) {}
/*      */     
/* 1677 */     return pA_PowerFlow_MHEV;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_UnLockSetting getPA_UnLockSetting() throws CarNotConnectedException {
/* 1686 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33671, 1);
/*      */     
/* 1688 */     PATypes.PA_UnLockSetting pA_UnLockSetting = null;
/*      */     try {
/* 1690 */       PATypes.PA_UnLockSetting pA_UnLockSetting1 = new PATypes.PA_UnLockSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_UnLockSetting = pA_UnLockSetting1;
/* 1691 */     } catch (Exception exception) {}
/*      */     
/* 1693 */     return pA_UnLockSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PasAcsLock_Setting getPA_PasAcsLock_Setting() throws CarNotConnectedException {
/* 1702 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33672, 1);
/*      */     
/* 1704 */     PATypes.PA_PasAcsLock_Setting pA_PasAcsLock_Setting = null;
/*      */     try {
/* 1706 */       PATypes.PA_PasAcsLock_Setting pA_PasAcsLock_Setting1 = new PATypes.PA_PasAcsLock_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PasAcsLock_Setting = pA_PasAcsLock_Setting1;
/* 1707 */     } catch (Exception exception) {}
/*      */     
/* 1709 */     return pA_PasAcsLock_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TwoStepUnlck_Setting getPA_TwoStepUnlck_Setting() throws CarNotConnectedException {
/* 1718 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33673, 1);
/*      */     
/* 1720 */     PATypes.PA_TwoStepUnlck_Setting pA_TwoStepUnlck_Setting = null;
/*      */     try {
/* 1722 */       PATypes.PA_TwoStepUnlck_Setting pA_TwoStepUnlck_Setting1 = new PATypes.PA_TwoStepUnlck_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TwoStepUnlck_Setting = pA_TwoStepUnlck_Setting1;
/* 1723 */     } catch (Exception exception) {}
/*      */     
/* 1725 */     return pA_TwoStepUnlck_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_LockgFbSoundSet getPA_LockgFbSoundSet() throws CarNotConnectedException {
/* 1734 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33674, 1);
/*      */     
/* 1736 */     PATypes.PA_LockgFbSoundSet pA_LockgFbSoundSet = null;
/*      */     try {
/* 1738 */       PATypes.PA_LockgFbSoundSet pA_LockgFbSoundSet1 = new PATypes.PA_LockgFbSoundSet(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LockgFbSoundSet = pA_LockgFbSoundSet1;
/* 1739 */     } catch (Exception exception) {}
/*      */     
/* 1741 */     return pA_LockgFbSoundSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Individualtheme_OnOff getPA_Individualtheme_OnOff() throws CarNotConnectedException {
/* 1750 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33675, 1);
/*      */     
/* 1752 */     PATypes.PA_Individualtheme_OnOff pA_Individualtheme_OnOff = null;
/*      */     try {
/* 1754 */       PATypes.PA_Individualtheme_OnOff pA_Individualtheme_OnOff1 = new PATypes.PA_Individualtheme_OnOff(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Individualtheme_OnOff = pA_Individualtheme_OnOff1;
/* 1755 */     } catch (Exception exception) {}
/*      */     
/* 1757 */     return pA_Individualtheme_OnOff;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DIMTheme_DrvSetting getPA_DIMTheme_DrvSetting() throws CarNotConnectedException {
/* 1766 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33676, 1);
/*      */     
/* 1768 */     PATypes.PA_DIMTheme_DrvSetting pA_DIMTheme_DrvSetting = null;
/*      */     try {
/* 1770 */       PATypes.PA_DIMTheme_DrvSetting pA_DIMTheme_DrvSetting1 = new PATypes.PA_DIMTheme_DrvSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DIMTheme_DrvSetting = pA_DIMTheme_DrvSetting1;
/* 1771 */     } catch (Exception exception) {}
/*      */     
/* 1773 */     return pA_DIMTheme_DrvSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CSDTheme_Setting getPA_CSDTheme_Setting() throws CarNotConnectedException {
/* 1782 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33677, 1);
/*      */     
/* 1784 */     PATypes.PA_CSDTheme_Setting pA_CSDTheme_Setting = null;
/*      */     try {
/* 1786 */       PATypes.PA_CSDTheme_Setting pA_CSDTheme_Setting1 = new PATypes.PA_CSDTheme_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CSDTheme_Setting = pA_CSDTheme_Setting1;
/* 1787 */     } catch (Exception exception) {}
/*      */     
/* 1789 */     return pA_CSDTheme_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ElecSeatbelt_Driver getPA_ElecSeatbelt_Driver() throws CarNotConnectedException {
/* 1798 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33678, 1);
/*      */     
/* 1800 */     PATypes.PA_ElecSeatbelt_Driver pA_ElecSeatbelt_Driver = null;
/*      */     try {
/* 1802 */       PATypes.PA_ElecSeatbelt_Driver pA_ElecSeatbelt_Driver1 = new PATypes.PA_ElecSeatbelt_Driver(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ElecSeatbelt_Driver = pA_ElecSeatbelt_Driver1;
/* 1803 */     } catch (Exception exception) {}
/*      */     
/* 1805 */     return pA_ElecSeatbelt_Driver;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ElecSeatbelt_Passenger getPA_ElecSeatbelt_Passenger() throws CarNotConnectedException {
/* 1814 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33679, 1);
/*      */     
/* 1816 */     PATypes.PA_ElecSeatbelt_Passenger pA_ElecSeatbelt_Passenger = null;
/*      */     try {
/* 1818 */       PATypes.PA_ElecSeatbelt_Passenger pA_ElecSeatbelt_Passenger1 = new PATypes.PA_ElecSeatbelt_Passenger(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ElecSeatbelt_Passenger = pA_ElecSeatbelt_Passenger1;
/* 1819 */     } catch (Exception exception) {}
/*      */     
/* 1821 */     return pA_ElecSeatbelt_Passenger;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PM_Hold getPA_PM_Hold() throws CarNotConnectedException {
/* 1830 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33680, 1);
/*      */     
/* 1832 */     PATypes.PA_PM_Hold pA_PM_Hold = null;
/*      */     try {
/* 1834 */       PATypes.PA_PM_Hold pA_PM_Hold1 = new PATypes.PA_PM_Hold(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM_Hold = pA_PM_Hold1;
/* 1835 */     } catch (Exception exception) {}
/*      */     
/* 1837 */     return pA_PM_Hold;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PM_Charge getPA_PM_Charge() throws CarNotConnectedException {
/* 1846 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33681, 1);
/*      */     
/* 1848 */     PATypes.PA_PM_Charge pA_PM_Charge = null;
/*      */     try {
/* 1850 */       PATypes.PA_PM_Charge pA_PM_Charge1 = new PATypes.PA_PM_Charge(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM_Charge = pA_PM_Charge1;
/* 1851 */     } catch (Exception exception) {}
/*      */     
/* 1853 */     return pA_PM_Charge;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Battery_Charge_Percent getPA_Battery_Charge_Percent() throws CarNotConnectedException {
/* 1862 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33682, 1);
/*      */     
/* 1864 */     PATypes.PA_Battery_Charge_Percent pA_Battery_Charge_Percent = null;
/*      */     try {
/* 1866 */       PATypes.PA_Battery_Charge_Percent pA_Battery_Charge_Percent1 = new PATypes.PA_Battery_Charge_Percent(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Battery_Charge_Percent = pA_Battery_Charge_Percent1;
/* 1867 */     } catch (Exception exception) {}
/*      */     
/* 1869 */     return pA_Battery_Charge_Percent;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ChangeFailMsg getPA_ChangeFailMsg() throws CarNotConnectedException {
/* 1878 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33683, 1);
/*      */     
/* 1880 */     PATypes.PA_ChangeFailMsg pA_ChangeFailMsg = null;
/*      */     try {
/* 1882 */       PATypes.PA_ChangeFailMsg pA_ChangeFailMsg1 = new PATypes.PA_ChangeFailMsg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ChangeFailMsg = pA_ChangeFailMsg1;
/* 1883 */     } catch (Exception exception) {}
/*      */     
/* 1885 */     return pA_ChangeFailMsg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ElectricTailgate_Setting getPA_ElectricTailgate_Setting() throws CarNotConnectedException {
/* 1894 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33684, 1);
/*      */     
/* 1896 */     PATypes.PA_ElectricTailgate_Setting pA_ElectricTailgate_Setting = null;
/*      */     try {
/* 1898 */       PATypes.PA_ElectricTailgate_Setting pA_ElectricTailgate_Setting1 = new PATypes.PA_ElectricTailgate_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ElectricTailgate_Setting = pA_ElectricTailgate_Setting1;
/* 1899 */     } catch (Exception exception) {}
/*      */     
/* 1901 */     return pA_ElectricTailgate_Setting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ElectricTailgate_OpenBtn getPA_ElectricTailgate_OpenBtn() throws CarNotConnectedException {
/* 1910 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33685, 1);
/*      */     
/* 1912 */     PATypes.PA_ElectricTailgate_OpenBtn pA_ElectricTailgate_OpenBtn = null;
/*      */     try {
/* 1914 */       PATypes.PA_ElectricTailgate_OpenBtn pA_ElectricTailgate_OpenBtn1 = new PATypes.PA_ElectricTailgate_OpenBtn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ElectricTailgate_OpenBtn = pA_ElectricTailgate_OpenBtn1;
/* 1915 */     } catch (Exception exception) {}
/*      */     
/* 1917 */     return pA_ElectricTailgate_OpenBtn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ElectricTailgate_PosSetting getPA_ElectricTailgate_PosSetting() throws CarNotConnectedException {
/* 1926 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33686, 1);
/*      */     
/* 1928 */     PATypes.PA_ElectricTailgate_PosSetting pA_ElectricTailgate_PosSetting = null;
/*      */     try {
/* 1930 */       PATypes.PA_ElectricTailgate_PosSetting pA_ElectricTailgate_PosSetting1 = new PATypes.PA_ElectricTailgate_PosSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ElectricTailgate_PosSetting = pA_ElectricTailgate_PosSetting1;
/* 1931 */     } catch (Exception exception) {}
/*      */     
/* 1933 */     return pA_ElectricTailgate_PosSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TailgateSts getPA_TailgateSts() throws CarNotConnectedException {
/* 1942 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33687, 1);
/*      */     
/* 1944 */     PATypes.PA_TailgateSts pA_TailgateSts = null;
/*      */     try {
/* 1946 */       PATypes.PA_TailgateSts pA_TailgateSts1 = new PATypes.PA_TailgateSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TailgateSts = pA_TailgateSts1;
/* 1947 */     } catch (Exception exception) {}
/*      */     
/* 1949 */     return pA_TailgateSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SelfDefineFuncReq getPA_SelfDefineFuncReq() throws CarNotConnectedException {
/* 1958 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33688, 1);
/*      */     
/* 1960 */     PATypes.PA_SelfDefineFuncReq pA_SelfDefineFuncReq = null;
/*      */     try {
/* 1962 */       PATypes.PA_SelfDefineFuncReq pA_SelfDefineFuncReq1 = new PATypes.PA_SelfDefineFuncReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SelfDefineFuncReq = pA_SelfDefineFuncReq1;
/* 1963 */     } catch (Exception exception) {}
/*      */     
/* 1965 */     return pA_SelfDefineFuncReq;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ScreenSwitch getPA_ScreenSwitch() throws CarNotConnectedException {
/* 1974 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33689, 1);
/*      */     
/* 1976 */     PATypes.PA_ScreenSwitch pA_ScreenSwitch = null;
/*      */     try {
/* 1978 */       PATypes.PA_ScreenSwitch pA_ScreenSwitch1 = new PATypes.PA_ScreenSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ScreenSwitch = pA_ScreenSwitch1;
/* 1979 */     } catch (Exception exception) {}
/*      */     
/* 1981 */     return pA_ScreenSwitch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DVR getPA_DVR() throws CarNotConnectedException {
/* 1990 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33690, 1);
/*      */     
/* 1992 */     PATypes.PA_DVR pA_DVR = null;
/*      */     try {
/* 1994 */       PATypes.PA_DVR pA_DVR1 = new PATypes.PA_DVR(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DVR = pA_DVR1;
/* 1995 */     } catch (Exception exception) {}
/*      */     
/* 1997 */     return pA_DVR;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_360Panorama getPA_360Panorama() throws CarNotConnectedException {
/* 2006 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33691, 1);
/*      */     
/* 2008 */     PATypes.PA_360Panorama pA_360Panorama = null;
/*      */     try {
/* 2010 */       PATypes.PA_360Panorama pA_360Panorama1 = new PATypes.PA_360Panorama(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_360Panorama = pA_360Panorama1;
/* 2011 */     } catch (Exception exception) {}
/*      */     
/* 2013 */     return pA_360Panorama;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_NaviHome getPA_NaviHome() throws CarNotConnectedException {
/* 2022 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33692, 1);
/*      */     
/* 2024 */     PATypes.PA_NaviHome pA_NaviHome = null;
/*      */     try {
/* 2026 */       PATypes.PA_NaviHome pA_NaviHome1 = new PATypes.PA_NaviHome(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_NaviHome = pA_NaviHome1;
/* 2027 */     } catch (Exception exception) {}
/*      */     
/* 2029 */     return pA_NaviHome;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SourceSwitch getPA_SourceSwitch() throws CarNotConnectedException {
/* 2038 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33693, 1);
/*      */     
/* 2040 */     PATypes.PA_SourceSwitch pA_SourceSwitch = null;
/*      */     try {
/* 2042 */       PATypes.PA_SourceSwitch pA_SourceSwitch1 = new PATypes.PA_SourceSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SourceSwitch = pA_SourceSwitch1;
/* 2043 */     } catch (Exception exception) {}
/*      */     
/* 2045 */     return pA_SourceSwitch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CollectionRadio getPA_CollectionRadio() throws CarNotConnectedException {
/* 2054 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33694, 1);
/*      */     
/* 2056 */     PATypes.PA_CollectionRadio pA_CollectionRadio = null;
/*      */     try {
/* 2058 */       PATypes.PA_CollectionRadio pA_CollectionRadio1 = new PATypes.PA_CollectionRadio(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CollectionRadio = pA_CollectionRadio1;
/* 2059 */     } catch (Exception exception) {}
/*      */     
/* 2061 */     return pA_CollectionRadio;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_VINDiffMsg getPA_VINDiffMsg() throws CarNotConnectedException {
/* 2070 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33695, 1);
/*      */     
/* 2072 */     PATypes.PA_VINDiffMsg pA_VINDiffMsg = null;
/*      */     try {
/* 2074 */       PATypes.PA_VINDiffMsg pA_VINDiffMsg1 = new PATypes.PA_VINDiffMsg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VINDiffMsg = pA_VINDiffMsg1;
/* 2075 */     } catch (Exception exception) {}
/*      */     
/* 2077 */     return pA_VINDiffMsg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ParkingAutoResetSetting getPA_ParkingAutoResetSetting() throws CarNotConnectedException {
/* 2086 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33696, 1);
/*      */     
/* 2088 */     PATypes.PA_ParkingAutoResetSetting pA_ParkingAutoResetSetting = null;
/*      */     try {
/* 2090 */       PATypes.PA_ParkingAutoResetSetting pA_ParkingAutoResetSetting1 = new PATypes.PA_ParkingAutoResetSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ParkingAutoResetSetting = pA_ParkingAutoResetSetting1;
/* 2091 */     } catch (Exception exception) {}
/*      */     
/* 2093 */     return pA_ParkingAutoResetSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_RefuleAutoResetSetting getPA_RefuleAutoResetSetting() throws CarNotConnectedException {
/* 2102 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33697, 1);
/*      */     
/* 2104 */     PATypes.PA_RefuleAutoResetSetting pA_RefuleAutoResetSetting = null;
/*      */     try {
/* 2106 */       PATypes.PA_RefuleAutoResetSetting pA_RefuleAutoResetSetting1 = new PATypes.PA_RefuleAutoResetSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_RefuleAutoResetSetting = pA_RefuleAutoResetSetting1;
/* 2107 */     } catch (Exception exception) {}
/*      */     
/* 2109 */     return pA_RefuleAutoResetSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TripCom_RetALL getPA_TripCom_RetALL() throws CarNotConnectedException {
/* 2118 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33698, 1);
/*      */     
/* 2120 */     PATypes.PA_TripCom_RetALL pA_TripCom_RetALL = null;
/*      */     try {
/* 2122 */       PATypes.PA_TripCom_RetALL pA_TripCom_RetALL1 = new PATypes.PA_TripCom_RetALL(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TripCom_RetALL = pA_TripCom_RetALL1;
/* 2123 */     } catch (Exception exception) {}
/*      */     
/* 2125 */     return pA_TripCom_RetALL;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TripCom_RstTrip getPA_TripCom_RstTrip() throws CarNotConnectedException {
/* 2134 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33699, 1);
/*      */     
/* 2136 */     PATypes.PA_TripCom_RstTrip pA_TripCom_RstTrip = null;
/*      */     try {
/* 2138 */       PATypes.PA_TripCom_RstTrip pA_TripCom_RstTrip1 = new PATypes.PA_TripCom_RstTrip(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TripCom_RstTrip = pA_TripCom_RstTrip1;
/* 2139 */     } catch (Exception exception) {}
/*      */     
/* 2141 */     return pA_TripCom_RstTrip;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TripCom_RstAVS getPA_TripCom_RstAVS() throws CarNotConnectedException {
/* 2150 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33700, 1);
/*      */     
/* 2152 */     PATypes.PA_TripCom_RstAVS pA_TripCom_RstAVS = null;
/*      */     try {
/* 2154 */       PATypes.PA_TripCom_RstAVS pA_TripCom_RstAVS1 = new PATypes.PA_TripCom_RstAVS(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TripCom_RstAVS = pA_TripCom_RstAVS1;
/* 2155 */     } catch (Exception exception) {}
/*      */     
/* 2157 */     return pA_TripCom_RstAVS;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TripCom_RstEDT getPA_TripCom_RstEDT() throws CarNotConnectedException {
/* 2166 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33701, 1);
/*      */     
/* 2168 */     PATypes.PA_TripCom_RstEDT pA_TripCom_RstEDT = null;
/*      */     try {
/* 2170 */       PATypes.PA_TripCom_RstEDT pA_TripCom_RstEDT1 = new PATypes.PA_TripCom_RstEDT(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TripCom_RstEDT = pA_TripCom_RstEDT1;
/* 2171 */     } catch (Exception exception) {}
/*      */     
/* 2173 */     return pA_TripCom_RstEDT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TripCom_RstAFC getPA_TripCom_RstAFC() throws CarNotConnectedException {
/* 2182 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33702, 1);
/*      */     
/* 2184 */     PATypes.PA_TripCom_RstAFC pA_TripCom_RstAFC = null;
/*      */     try {
/* 2186 */       PATypes.PA_TripCom_RstAFC pA_TripCom_RstAFC1 = new PATypes.PA_TripCom_RstAFC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TripCom_RstAFC = pA_TripCom_RstAFC1;
/* 2187 */     } catch (Exception exception) {}
/*      */     
/* 2189 */     return pA_TripCom_RstAFC;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TripCom_RstAEC getPA_TripCom_RstAEC() throws CarNotConnectedException {
/* 2198 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33703, 1);
/*      */     
/* 2200 */     PATypes.PA_TripCom_RstAEC pA_TripCom_RstAEC = null;
/*      */     try {
/* 2202 */       PATypes.PA_TripCom_RstAEC pA_TripCom_RstAEC1 = new PATypes.PA_TripCom_RstAEC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TripCom_RstAEC = pA_TripCom_RstAEC1;
/* 2203 */     } catch (Exception exception) {}
/*      */     
/* 2205 */     return pA_TripCom_RstAEC;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_IntelligentFuSave getPA_IntelligentFuSave() throws CarNotConnectedException {
/* 2214 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33704, 1);
/*      */     
/* 2216 */     PATypes.PA_IntelligentFuSave pA_IntelligentFuSave = null;
/*      */     try {
/* 2218 */       PATypes.PA_IntelligentFuSave pA_IntelligentFuSave1 = new PATypes.PA_IntelligentFuSave(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_IntelligentFuSave = pA_IntelligentFuSave1;
/* 2219 */     } catch (Exception exception) {}
/*      */     
/* 2221 */     return pA_IntelligentFuSave;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PowerFlow_HEV getPA_PowerFlow_HEV() throws CarNotConnectedException {
/* 2230 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33705, 1);
/*      */     
/* 2232 */     PATypes.PA_PowerFlow_HEV pA_PowerFlow_HEV = null;
/*      */     try {
/* 2234 */       PATypes.PA_PowerFlow_HEV pA_PowerFlow_HEV1 = new PATypes.PA_PowerFlow_HEV(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PowerFlow_HEV = pA_PowerFlow_HEV1;
/* 2235 */     } catch (Exception exception) {}
/*      */     
/* 2237 */     return pA_PowerFlow_HEV;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_LifeDetectionSwitch getPA_LifeDetectionSwitch() throws CarNotConnectedException {
/* 2246 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33706, 1);
/*      */     
/* 2248 */     PATypes.PA_LifeDetectionSwitch pA_LifeDetectionSwitch = null;
/*      */     try {
/* 2250 */       PATypes.PA_LifeDetectionSwitch pA_LifeDetectionSwitch1 = new PATypes.PA_LifeDetectionSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LifeDetectionSwitch = pA_LifeDetectionSwitch1;
/* 2251 */     } catch (Exception exception) {}
/*      */     
/* 2253 */     return pA_LifeDetectionSwitch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_UnlckTrunk getPA_UnlckTrunk() throws CarNotConnectedException {
/* 2262 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33707, 1);
/*      */     
/* 2264 */     PATypes.PA_UnlckTrunk pA_UnlckTrunk = null;
/*      */     try {
/* 2266 */       PATypes.PA_UnlckTrunk pA_UnlckTrunk1 = new PATypes.PA_UnlckTrunk(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_UnlckTrunk = pA_UnlckTrunk1;
/* 2267 */     } catch (Exception exception) {}
/*      */     
/* 2269 */     return pA_UnlckTrunk;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_RearMirrors getPA_RearMirrors() throws CarNotConnectedException {
/* 2278 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33708, 1);
/*      */     
/* 2280 */     PATypes.PA_RearMirrors pA_RearMirrors = null;
/*      */     try {
/* 2282 */       PATypes.PA_RearMirrors pA_RearMirrors1 = new PATypes.PA_RearMirrors(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_RearMirrors = pA_RearMirrors1;
/* 2283 */     } catch (Exception exception) {}
/*      */     
/* 2285 */     return pA_RearMirrors;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DoubleLock getPA_DoubleLock() throws CarNotConnectedException {
/* 2294 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33709, 1);
/*      */     
/* 2296 */     PATypes.PA_DoubleLock pA_DoubleLock = null;
/*      */     try {
/* 2298 */       PATypes.PA_DoubleLock pA_DoubleLock1 = new PATypes.PA_DoubleLock(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DoubleLock = pA_DoubleLock1;
/* 2299 */     } catch (Exception exception) {}
/*      */     
/* 2301 */     return pA_DoubleLock;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Locking_ApproachToOpenTrSwt getPA_Locking_ApproachToOpenTrSwt() throws CarNotConnectedException {
/* 2310 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33710, 1);
/*      */     
/* 2312 */     PATypes.PA_Locking_ApproachToOpenTrSwt pA_Locking_ApproachToOpenTrSwt = null;
/*      */     try {
/* 2314 */       PATypes.PA_Locking_ApproachToOpenTrSwt pA_Locking_ApproachToOpenTrSwt1 = new PATypes.PA_Locking_ApproachToOpenTrSwt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Locking_ApproachToOpenTrSwt = pA_Locking_ApproachToOpenTrSwt1;
/* 2315 */     } catch (Exception exception) {}
/*      */     
/* 2317 */     return pA_Locking_ApproachToOpenTrSwt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ServiceReminderType getPA_ServiceReminderType() throws CarNotConnectedException {
/* 2326 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33711, 1);
/*      */     
/* 2328 */     PATypes.PA_ServiceReminderType pA_ServiceReminderType = null;
/*      */     try {
/* 2330 */       PATypes.PA_ServiceReminderType pA_ServiceReminderType1 = new PATypes.PA_ServiceReminderType(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ServiceReminderType = pA_ServiceReminderType1;
/* 2331 */     } catch (Exception exception) {}
/*      */     
/* 2333 */     return pA_ServiceReminderType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DstTrvldAct getPA_DstTrvldAct() throws CarNotConnectedException {
/* 2342 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33712, 1);
/*      */     
/* 2344 */     PATypes.PA_DstTrvldAct pA_DstTrvldAct = null;
/*      */     try {
/* 2346 */       PATypes.PA_DstTrvldAct pA_DstTrvldAct1 = new PATypes.PA_DstTrvldAct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DstTrvldAct = pA_DstTrvldAct1;
/* 2347 */     } catch (Exception exception) {}
/*      */     
/* 2349 */     return pA_DstTrvldAct;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DstTrvldOfEV getPA_DstTrvldOfEV() throws CarNotConnectedException {
/* 2358 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33713, 1);
/*      */     
/* 2360 */     PATypes.PA_DstTrvldOfEV pA_DstTrvldOfEV = null;
/*      */     try {
/* 2362 */       PATypes.PA_DstTrvldOfEV pA_DstTrvldOfEV1 = new PATypes.PA_DstTrvldOfEV(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DstTrvldOfEV = pA_DstTrvldOfEV1;
/* 2363 */     } catch (Exception exception) {}
/*      */     
/* 2365 */     return pA_DstTrvldOfEV;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DstTrvldOfEng getPA_DstTrvldOfEng() throws CarNotConnectedException {
/* 2374 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33714, 1);
/*      */     
/* 2376 */     PATypes.PA_DstTrvldOfEng pA_DstTrvldOfEng = null;
/*      */     try {
/* 2378 */       PATypes.PA_DstTrvldOfEng pA_DstTrvldOfEng1 = new PATypes.PA_DstTrvldOfEng(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DstTrvldOfEng = pA_DstTrvldOfEng1;
/* 2379 */     } catch (Exception exception) {}
/*      */     
/* 2381 */     return pA_DstTrvldOfEng;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_NatUsgDayOfOil getPA_NatUsgDayOfOil() throws CarNotConnectedException {
/* 2390 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33715, 1);
/*      */     
/* 2392 */     PATypes.PA_NatUsgDayOfOil pA_NatUsgDayOfOil = null;
/*      */     try {
/* 2394 */       PATypes.PA_NatUsgDayOfOil pA_NatUsgDayOfOil1 = new PATypes.PA_NatUsgDayOfOil(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_NatUsgDayOfOil = pA_NatUsgDayOfOil1;
/* 2395 */     } catch (Exception exception) {}
/*      */     
/* 2397 */     return pA_NatUsgDayOfOil;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_HealthOfEngOil getPA_HealthOfEngOil() throws CarNotConnectedException {
/* 2406 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33716, 1);
/*      */     
/* 2408 */     PATypes.PA_HealthOfEngOil pA_HealthOfEngOil = null;
/*      */     try {
/* 2410 */       PATypes.PA_HealthOfEngOil pA_HealthOfEngOil1 = new PATypes.PA_HealthOfEngOil(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HealthOfEngOil = pA_HealthOfEngOil1;
/* 2411 */     } catch (Exception exception) {}
/*      */     
/* 2413 */     return pA_HealthOfEngOil;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_VM_MsgEnd getPA_VM_MsgEnd() throws CarNotConnectedException {
/* 2422 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33923, 1);
/*      */     
/* 2424 */     PATypes.PA_VM_MsgEnd pA_VM_MsgEnd = null;
/*      */     try {
/* 2426 */       PATypes.PA_VM_MsgEnd pA_VM_MsgEnd1 = new PATypes.PA_VM_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VM_MsgEnd = pA_VM_MsgEnd1;
/* 2427 */     } catch (Exception exception) {}
/*      */     
/* 2429 */     return pA_VM_MsgEnd;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVfmiscManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */