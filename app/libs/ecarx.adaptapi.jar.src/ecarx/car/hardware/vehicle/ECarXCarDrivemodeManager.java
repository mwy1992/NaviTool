/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.AirCdnrSetg;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.BooleanType;
/*     */ import ecarx.car.hardware.annotation.DrvModReqType2;
/*     */ import ecarx.car.hardware.annotation.DrvrDispSetg;
/*     */ import ecarx.car.hardware.annotation.LvlCtrlSetgTyp;
/*     */ import ecarx.car.hardware.annotation.NormSptType;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.annotation.SteerAsscLvl;
/*     */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
/*     */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ECarXCarDrivemodeManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbdmairconditionersettings = 32882;
/*     */   public static final int ManagerId_cbdmbrakesettings = 32879;
/*     */   public static final int ManagerId_cbdmbrakingpedalfeelingsettings = 32880;
/*     */   public static final int ManagerId_cbdmdeactivationofdrivemodemenu = 32878;
/*     */   public static final int ManagerId_cbdmdimthemesettings = 32884;
/*     */   public static final int ManagerId_cbdmdrivemode = 32877;
/*     */   public static final int ManagerId_cbdmenginestartstop = 32885;
/*     */   public static final int ManagerId_cbdmpowertrainsettings = 32881;
/*     */   public static final int ManagerId_cbdmreboot = 32887;
/*     */   public static final int ManagerId_cbdmsteeringwheelassistlevelsettings = 32883;
/*     */   public static final int ManagerId_cbdmsuspensionsettings = 32886;
/*     */   public static final int ManagerId_padrivemodeactivetime = 33454;
/*     */   public static final int ManagerId_padrivemodeadaptive = 33465;
/*     */   public static final int ManagerId_padrivemodeairconditionersettings = 33458;
/*     */   public static final int ManagerId_padrivemodeanimation = 33464;
/*     */   public static final int ManagerId_padrivemodeawd = 33444;
/*     */   public static final int ManagerId_padrivemodebrakesettings = 33456;
/*     */   public static final int ManagerId_padrivemodecomfort = 33440;
/*     */   public static final int ManagerId_padrivemodeconfirmationtimeout = 33453;
/*     */   public static final int ManagerId_padrivemodedimthemesettings = 33460;
/*     */   public static final int ManagerId_padrivemodedynamic = 33441;
/*     */   public static final int ManagerId_padrivemodeeco = 33439;
/*     */   public static final int ManagerId_padrivemodeenginestartstop = 33461;
/*     */   public static final int ManagerId_padrivemodehybrid = 33447;
/*     */   public static final int ManagerId_padrivemodeindividual = 33442;
/*     */   public static final int ManagerId_padrivemodeindividualsettings = 33455;
/*     */   public static final int ManagerId_padrivemodemsgend = 33912;
/*     */   public static final int ManagerId_padrivemodemud = 33451;
/*     */   public static final int ManagerId_padrivemodepower = 33448;
/*     */   public static final int ManagerId_padrivemodepowertrainsettings = 33457;
/*     */   public static final int ManagerId_padrivemodepure = 33446;
/*     */   public static final int ManagerId_padrivemoderock = 33452;
/*     */   public static final int ManagerId_padrivemodesand = 33450;
/*     */   public static final int ManagerId_padrivemodesave = 33445;
/*     */   public static final int ManagerId_padrivemodesnow = 33449;
/*     */   public static final int ManagerId_padrivemodesteeringwheelassistlevelsettings = 33459;
/*     */   public static final int ManagerId_padrivemodesuspensionsettings = 33462;
/*     */   public static final int ManagerId_padrivemodevalue = 33463;
/*     */   public static final int ManagerId_padrivemodexc = 33443;
/*     */   private static final String TAG = "ECarXCarDrivemodeManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDrivemodeManager() {}
/*     */   
/*     */   public ECarXCarDrivemodeManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  97 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_DriveMode(int paramInt) {
/* 107 */     ApiResult apiResult = ApiResult.FAILED;
/* 108 */     if (DrvModReqType2.isValid(paramInt)) {
/* 109 */       apiResult = this.mMgr.setIntProperty(32877, 1, paramInt);
/*     */     } else {
/* 111 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 113 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_DeactivationOfDriveModeMenu(int paramInt) {
/* 123 */     ApiResult apiResult = ApiResult.FAILED;
/* 124 */     if (BooleanType.isValid(paramInt)) {
/* 125 */       apiResult = this.mMgr.setIntProperty(32878, 1, paramInt);
/*     */     } else {
/* 127 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 129 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_Brake_Settings(int paramInt) {
/* 139 */     ApiResult apiResult = ApiResult.FAILED;
/* 140 */     if (NormSptType.isValid(paramInt)) {
/* 141 */       apiResult = this.mMgr.setIntProperty(32879, 1, paramInt);
/*     */     } else {
/* 143 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 145 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_BrakingPedalFeeling_Settings(int paramInt) {
/* 155 */     ApiResult apiResult = ApiResult.FAILED;
/* 156 */     if (NormSptType.isValid(paramInt)) {
/* 157 */       apiResult = this.mMgr.setIntProperty(32880, 1, paramInt);
/*     */     } else {
/* 159 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 161 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_Powertrain_Settings(int paramInt) {
/* 171 */     ApiResult apiResult = ApiResult.FAILED;
/* 172 */     if (DrvModReqType2.isValid(paramInt)) {
/* 173 */       apiResult = this.mMgr.setIntProperty(32881, 1, paramInt);
/*     */     } else {
/* 175 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 177 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_AirConditioner_Settings(int paramInt) {
/* 187 */     ApiResult apiResult = ApiResult.FAILED;
/* 188 */     if (AirCdnrSetg.isValid(paramInt)) {
/* 189 */       apiResult = this.mMgr.setIntProperty(32882, 1, paramInt);
/*     */     } else {
/* 191 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 193 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_SteeringWheelAssistLevel_Settings(int paramInt) {
/* 203 */     ApiResult apiResult = ApiResult.FAILED;
/* 204 */     if (SteerAsscLvl.isValid(paramInt)) {
/* 205 */       apiResult = this.mMgr.setIntProperty(32883, 1, paramInt);
/*     */     } else {
/* 207 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 209 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_DIMTheme_Settings(int paramInt) {
/* 219 */     ApiResult apiResult = ApiResult.FAILED;
/* 220 */     if (DrvrDispSetg.isValid(paramInt)) {
/* 221 */       apiResult = this.mMgr.setIntProperty(32884, 1, paramInt);
/*     */     } else {
/* 223 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 225 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_Engine_StartStop(int paramInt) {
/* 235 */     ApiResult apiResult = ApiResult.FAILED;
/* 236 */     if (OnOff1.isValid(paramInt)) {
/* 237 */       apiResult = this.mMgr.setIntProperty(32885, 1, paramInt);
/*     */     } else {
/* 239 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 241 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_Suspension_Settings(int paramInt) {
/* 251 */     ApiResult apiResult = ApiResult.FAILED;
/* 252 */     if (LvlCtrlSetgTyp.isValid(paramInt)) {
/* 253 */       apiResult = this.mMgr.setIntProperty(32886, 1, paramInt);
/*     */     } else {
/* 255 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 257 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DM_Reboot(int paramInt) {
/* 267 */     return this.mMgr.setIntProperty(32887, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Eco getPA_DriveMode_Eco() throws CarNotConnectedException {
/* 278 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33439, 1);
/*     */     
/* 280 */     PATypes.PA_DriveMode_Eco pA_DriveMode_Eco = null;
/*     */     try {
/* 282 */       PATypes.PA_DriveMode_Eco pA_DriveMode_Eco1 = new PATypes.PA_DriveMode_Eco(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Eco = pA_DriveMode_Eco1;
/* 283 */     } catch (Exception exception) {}
/*     */     
/* 285 */     return pA_DriveMode_Eco;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Comfort getPA_DriveMode_Comfort() throws CarNotConnectedException {
/* 294 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33440, 1);
/*     */     
/* 296 */     PATypes.PA_DriveMode_Comfort pA_DriveMode_Comfort = null;
/*     */     try {
/* 298 */       PATypes.PA_DriveMode_Comfort pA_DriveMode_Comfort1 = new PATypes.PA_DriveMode_Comfort(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Comfort = pA_DriveMode_Comfort1;
/* 299 */     } catch (Exception exception) {}
/*     */     
/* 301 */     return pA_DriveMode_Comfort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Dynamic getPA_DriveMode_Dynamic() throws CarNotConnectedException {
/* 310 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33441, 1);
/*     */     
/* 312 */     PATypes.PA_DriveMode_Dynamic pA_DriveMode_Dynamic = null;
/*     */     try {
/* 314 */       PATypes.PA_DriveMode_Dynamic pA_DriveMode_Dynamic1 = new PATypes.PA_DriveMode_Dynamic(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Dynamic = pA_DriveMode_Dynamic1;
/* 315 */     } catch (Exception exception) {}
/*     */     
/* 317 */     return pA_DriveMode_Dynamic;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Individual getPA_DriveMode_Individual() throws CarNotConnectedException {
/* 326 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33442, 1);
/*     */     
/* 328 */     PATypes.PA_DriveMode_Individual pA_DriveMode_Individual = null;
/*     */     try {
/* 330 */       PATypes.PA_DriveMode_Individual pA_DriveMode_Individual1 = new PATypes.PA_DriveMode_Individual(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Individual = pA_DriveMode_Individual1;
/* 331 */     } catch (Exception exception) {}
/*     */     
/* 333 */     return pA_DriveMode_Individual;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_XC getPA_DriveMode_XC() throws CarNotConnectedException {
/* 342 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33443, 1);
/*     */     
/* 344 */     PATypes.PA_DriveMode_XC pA_DriveMode_XC = null;
/*     */     try {
/* 346 */       PATypes.PA_DriveMode_XC pA_DriveMode_XC1 = new PATypes.PA_DriveMode_XC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_XC = pA_DriveMode_XC1;
/* 347 */     } catch (Exception exception) {}
/*     */     
/* 349 */     return pA_DriveMode_XC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_AWD getPA_DriveMode_AWD() throws CarNotConnectedException {
/* 358 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33444, 1);
/*     */     
/* 360 */     PATypes.PA_DriveMode_AWD pA_DriveMode_AWD = null;
/*     */     try {
/* 362 */       PATypes.PA_DriveMode_AWD pA_DriveMode_AWD1 = new PATypes.PA_DriveMode_AWD(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_AWD = pA_DriveMode_AWD1;
/* 363 */     } catch (Exception exception) {}
/*     */     
/* 365 */     return pA_DriveMode_AWD;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Save getPA_DriveMode_Save() throws CarNotConnectedException {
/* 374 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33445, 1);
/*     */     
/* 376 */     PATypes.PA_DriveMode_Save pA_DriveMode_Save = null;
/*     */     try {
/* 378 */       PATypes.PA_DriveMode_Save pA_DriveMode_Save1 = new PATypes.PA_DriveMode_Save(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Save = pA_DriveMode_Save1;
/* 379 */     } catch (Exception exception) {}
/*     */     
/* 381 */     return pA_DriveMode_Save;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Pure getPA_DriveMode_Pure() throws CarNotConnectedException {
/* 390 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33446, 1);
/*     */     
/* 392 */     PATypes.PA_DriveMode_Pure pA_DriveMode_Pure = null;
/*     */     try {
/* 394 */       PATypes.PA_DriveMode_Pure pA_DriveMode_Pure1 = new PATypes.PA_DriveMode_Pure(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Pure = pA_DriveMode_Pure1;
/* 395 */     } catch (Exception exception) {}
/*     */     
/* 397 */     return pA_DriveMode_Pure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Hybrid getPA_DriveMode_Hybrid() throws CarNotConnectedException {
/* 406 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33447, 1);
/*     */     
/* 408 */     PATypes.PA_DriveMode_Hybrid pA_DriveMode_Hybrid = null;
/*     */     try {
/* 410 */       PATypes.PA_DriveMode_Hybrid pA_DriveMode_Hybrid1 = new PATypes.PA_DriveMode_Hybrid(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Hybrid = pA_DriveMode_Hybrid1;
/* 411 */     } catch (Exception exception) {}
/*     */     
/* 413 */     return pA_DriveMode_Hybrid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Power getPA_DriveMode_Power() throws CarNotConnectedException {
/* 422 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33448, 1);
/*     */     
/* 424 */     PATypes.PA_DriveMode_Power pA_DriveMode_Power = null;
/*     */     try {
/* 426 */       PATypes.PA_DriveMode_Power pA_DriveMode_Power1 = new PATypes.PA_DriveMode_Power(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Power = pA_DriveMode_Power1;
/* 427 */     } catch (Exception exception) {}
/*     */     
/* 429 */     return pA_DriveMode_Power;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Snow getPA_DriveMode_Snow() throws CarNotConnectedException {
/* 438 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33449, 1);
/*     */     
/* 440 */     PATypes.PA_DriveMode_Snow pA_DriveMode_Snow = null;
/*     */     try {
/* 442 */       PATypes.PA_DriveMode_Snow pA_DriveMode_Snow1 = new PATypes.PA_DriveMode_Snow(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Snow = pA_DriveMode_Snow1;
/* 443 */     } catch (Exception exception) {}
/*     */     
/* 445 */     return pA_DriveMode_Snow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Sand getPA_DriveMode_Sand() throws CarNotConnectedException {
/* 454 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33450, 1);
/*     */     
/* 456 */     PATypes.PA_DriveMode_Sand pA_DriveMode_Sand = null;
/*     */     try {
/* 458 */       PATypes.PA_DriveMode_Sand pA_DriveMode_Sand1 = new PATypes.PA_DriveMode_Sand(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Sand = pA_DriveMode_Sand1;
/* 459 */     } catch (Exception exception) {}
/*     */     
/* 461 */     return pA_DriveMode_Sand;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Mud getPA_DriveMode_Mud() throws CarNotConnectedException {
/* 470 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33451, 1);
/*     */     
/* 472 */     PATypes.PA_DriveMode_Mud pA_DriveMode_Mud = null;
/*     */     try {
/* 474 */       PATypes.PA_DriveMode_Mud pA_DriveMode_Mud1 = new PATypes.PA_DriveMode_Mud(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Mud = pA_DriveMode_Mud1;
/* 475 */     } catch (Exception exception) {}
/*     */     
/* 477 */     return pA_DriveMode_Mud;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Rock getPA_DriveMode_Rock() throws CarNotConnectedException {
/* 486 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33452, 1);
/*     */     
/* 488 */     PATypes.PA_DriveMode_Rock pA_DriveMode_Rock = null;
/*     */     try {
/* 490 */       PATypes.PA_DriveMode_Rock pA_DriveMode_Rock1 = new PATypes.PA_DriveMode_Rock(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Rock = pA_DriveMode_Rock1;
/* 491 */     } catch (Exception exception) {}
/*     */     
/* 493 */     return pA_DriveMode_Rock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_confirmation_timeout getPA_DriveMode_confirmation_timeout() throws CarNotConnectedException {
/* 502 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33453, 1);
/*     */     
/* 504 */     PATypes.PA_DriveMode_confirmation_timeout pA_DriveMode_confirmation_timeout = null;
/*     */     try {
/* 506 */       PATypes.PA_DriveMode_confirmation_timeout pA_DriveMode_confirmation_timeout1 = new PATypes.PA_DriveMode_confirmation_timeout(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_confirmation_timeout = pA_DriveMode_confirmation_timeout1;
/* 507 */     } catch (Exception exception) {}
/*     */     
/* 509 */     return pA_DriveMode_confirmation_timeout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_active_time getPA_DriveMode_active_time() throws CarNotConnectedException {
/* 518 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33454, 1);
/*     */     
/* 520 */     PATypes.PA_DriveMode_active_time pA_DriveMode_active_time = null;
/*     */     try {
/* 522 */       PATypes.PA_DriveMode_active_time pA_DriveMode_active_time1 = new PATypes.PA_DriveMode_active_time(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_active_time = pA_DriveMode_active_time1;
/* 523 */     } catch (Exception exception) {}
/*     */     
/* 525 */     return pA_DriveMode_active_time;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Individual_Settings getPA_DriveMode_Individual_Settings() throws CarNotConnectedException {
/* 534 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33455, 1);
/*     */     
/* 536 */     PATypes.PA_DriveMode_Individual_Settings pA_DriveMode_Individual_Settings = null;
/*     */     try {
/* 538 */       PATypes.PA_DriveMode_Individual_Settings pA_DriveMode_Individual_Settings1 = new PATypes.PA_DriveMode_Individual_Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Individual_Settings = pA_DriveMode_Individual_Settings1;
/* 539 */     } catch (Exception exception) {}
/*     */     
/* 541 */     return pA_DriveMode_Individual_Settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Brake_Settings getPA_DriveMode_Brake_Settings() throws CarNotConnectedException {
/* 550 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33456, 1);
/*     */     
/* 552 */     PATypes.PA_DriveMode_Brake_Settings pA_DriveMode_Brake_Settings = null;
/*     */     try {
/* 554 */       PATypes.PA_DriveMode_Brake_Settings pA_DriveMode_Brake_Settings1 = new PATypes.PA_DriveMode_Brake_Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Brake_Settings = pA_DriveMode_Brake_Settings1;
/* 555 */     } catch (Exception exception) {}
/*     */     
/* 557 */     return pA_DriveMode_Brake_Settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Powertrain_Settings getPA_DriveMode_Powertrain_Settings() throws CarNotConnectedException {
/* 566 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33457, 1);
/*     */     
/* 568 */     PATypes.PA_DriveMode_Powertrain_Settings pA_DriveMode_Powertrain_Settings = null;
/*     */     try {
/* 570 */       PATypes.PA_DriveMode_Powertrain_Settings pA_DriveMode_Powertrain_Settings1 = new PATypes.PA_DriveMode_Powertrain_Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Powertrain_Settings = pA_DriveMode_Powertrain_Settings1;
/* 571 */     } catch (Exception exception) {}
/*     */     
/* 573 */     return pA_DriveMode_Powertrain_Settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_AirConditioner_Settings getPA_DriveMode_AirConditioner_Settings() throws CarNotConnectedException {
/* 582 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33458, 1);
/*     */     
/* 584 */     PATypes.PA_DriveMode_AirConditioner_Settings pA_DriveMode_AirConditioner_Settings = null;
/*     */     try {
/* 586 */       PATypes.PA_DriveMode_AirConditioner_Settings pA_DriveMode_AirConditioner_Settings1 = new PATypes.PA_DriveMode_AirConditioner_Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_AirConditioner_Settings = pA_DriveMode_AirConditioner_Settings1;
/* 587 */     } catch (Exception exception) {}
/*     */     
/* 589 */     return pA_DriveMode_AirConditioner_Settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings getPA_DriveMode_SteeringWheelAssistLevel_Settings() throws CarNotConnectedException {
/* 598 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33459, 1);
/*     */     
/* 600 */     PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings pA_DriveMode_SteeringWheelAssistLevel_Settings = null;
/*     */     try {
/* 602 */       PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings pA_DriveMode_SteeringWheelAssistLevel_Settings1 = new PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_SteeringWheelAssistLevel_Settings = pA_DriveMode_SteeringWheelAssistLevel_Settings1;
/* 603 */     } catch (Exception exception) {}
/*     */     
/* 605 */     return pA_DriveMode_SteeringWheelAssistLevel_Settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_DIMTheme_Settings getPA_DriveMode_DIMTheme_Settings() throws CarNotConnectedException {
/* 614 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33460, 1);
/*     */     
/* 616 */     PATypes.PA_DriveMode_DIMTheme_Settings pA_DriveMode_DIMTheme_Settings = null;
/*     */     try {
/* 618 */       PATypes.PA_DriveMode_DIMTheme_Settings pA_DriveMode_DIMTheme_Settings1 = new PATypes.PA_DriveMode_DIMTheme_Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_DIMTheme_Settings = pA_DriveMode_DIMTheme_Settings1;
/* 619 */     } catch (Exception exception) {}
/*     */     
/* 621 */     return pA_DriveMode_DIMTheme_Settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Engine_StartStop getPA_DriveMode_Engine_StartStop() throws CarNotConnectedException {
/* 630 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33461, 1);
/*     */     
/* 632 */     PATypes.PA_DriveMode_Engine_StartStop pA_DriveMode_Engine_StartStop = null;
/*     */     try {
/* 634 */       PATypes.PA_DriveMode_Engine_StartStop pA_DriveMode_Engine_StartStop1 = new PATypes.PA_DriveMode_Engine_StartStop(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Engine_StartStop = pA_DriveMode_Engine_StartStop1;
/* 635 */     } catch (Exception exception) {}
/*     */     
/* 637 */     return pA_DriveMode_Engine_StartStop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Suspension_Settings getPA_DriveMode_Suspension_Settings() throws CarNotConnectedException {
/* 646 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33462, 1);
/*     */     
/* 648 */     PATypes.PA_DriveMode_Suspension_Settings pA_DriveMode_Suspension_Settings = null;
/*     */     try {
/* 650 */       PATypes.PA_DriveMode_Suspension_Settings pA_DriveMode_Suspension_Settings1 = new PATypes.PA_DriveMode_Suspension_Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Suspension_Settings = pA_DriveMode_Suspension_Settings1;
/* 651 */     } catch (Exception exception) {}
/*     */     
/* 653 */     return pA_DriveMode_Suspension_Settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Value getPA_DriveMode_Value() throws CarNotConnectedException {
/* 662 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33463, 1);
/*     */     
/* 664 */     PATypes.PA_DriveMode_Value pA_DriveMode_Value = null;
/*     */     try {
/* 666 */       PATypes.PA_DriveMode_Value pA_DriveMode_Value1 = new PATypes.PA_DriveMode_Value(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Value = pA_DriveMode_Value1;
/* 667 */     } catch (Exception exception) {}
/*     */     
/* 669 */     return pA_DriveMode_Value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Animation getPA_DriveMode_Animation() throws CarNotConnectedException {
/* 678 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33464, 1);
/*     */     
/* 680 */     PATypes.PA_DriveMode_Animation pA_DriveMode_Animation = null;
/*     */     try {
/* 682 */       PATypes.PA_DriveMode_Animation pA_DriveMode_Animation1 = new PATypes.PA_DriveMode_Animation(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Animation = pA_DriveMode_Animation1;
/* 683 */     } catch (Exception exception) {}
/*     */     
/* 685 */     return pA_DriveMode_Animation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_Adaptive getPA_DriveMode_Adaptive() throws CarNotConnectedException {
/* 694 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33465, 1);
/*     */     
/* 696 */     PATypes.PA_DriveMode_Adaptive pA_DriveMode_Adaptive = null;
/*     */     try {
/* 698 */       PATypes.PA_DriveMode_Adaptive pA_DriveMode_Adaptive1 = new PATypes.PA_DriveMode_Adaptive(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_Adaptive = pA_DriveMode_Adaptive1;
/* 699 */     } catch (Exception exception) {}
/*     */     
/* 701 */     return pA_DriveMode_Adaptive;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DriveMode_MsgEnd getPA_DriveMode_MsgEnd() throws CarNotConnectedException {
/* 710 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33912, 1);
/*     */     
/* 712 */     PATypes.PA_DriveMode_MsgEnd pA_DriveMode_MsgEnd = null;
/*     */     try {
/* 714 */       PATypes.PA_DriveMode_MsgEnd pA_DriveMode_MsgEnd1 = new PATypes.PA_DriveMode_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DriveMode_MsgEnd = pA_DriveMode_MsgEnd1;
/* 715 */     } catch (Exception exception) {}
/*     */     
/* 717 */     return pA_DriveMode_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDrivemodeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */