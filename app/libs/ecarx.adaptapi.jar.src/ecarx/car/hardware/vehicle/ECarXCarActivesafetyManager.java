/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.ChgWarnMod;
/*     */ import ecarx.car.hardware.annotation.CllsnAidSnvtySeldSts;
/*     */ import ecarx.car.hardware.annotation.DY1;
/*     */ import ecarx.car.hardware.annotation.IntvAndWarnModForLaneKeepAidSts;
/*     */ import ecarx.car.hardware.annotation.OffsForSpdWarnSetgReq;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
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
/*     */ public class ECarXCarActivesafetyManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbasyaccandtsr = 32768;
/*     */   public static final int ManagerId_cbasycms = 32779;
/*     */   public static final int ManagerId_cbasycmswarning = 32780;
/*     */   public static final int ManagerId_cbasydow = 32785;
/*     */   public static final int ManagerId_cbasydps = 32777;
/*     */   public static final int ManagerId_cbasydpsreminder = 32778;
/*     */   public static final int ManagerId_cbasyelka = 32789;
/*     */   public static final int ManagerId_cbasyelow = 32776;
/*     */   public static final int ManagerId_cbasyema = 32790;
/*     */   public static final int ManagerId_cbasyhwa = 32769;
/*     */   public static final int ManagerId_cbasylca = 32781;
/*     */   public static final int ManagerId_cbasylcawarning = 32782;
/*     */   public static final int ManagerId_cbasylka = 32786;
/*     */   public static final int ManagerId_cbasylkamode = 32787;
/*     */   public static final int ManagerId_cbasylkawarningmode = 32788;
/*     */   public static final int ManagerId_cbasyothertsr = 32771;
/*     */   public static final int ManagerId_cbasyrcta = 32784;
/*     */   public static final int ManagerId_cbasyrcw = 32783;
/*     */   public static final int ManagerId_cbasyreboot = 32791;
/*     */   public static final int ManagerId_cbasyspeedcompensation = 32773;
/*     */   public static final int ManagerId_cbasytla = 32774;
/*     */   public static final int ManagerId_cbasytlasoundwarning = 32775;
/*     */   public static final int ManagerId_cbasytsr = 32770;
/*     */   public static final int ManagerId_cbasytsrwarning = 32772;
/*     */   public static final int ManagerId_paasyaccandtsr = 33294;
/*     */   public static final int ManagerId_paasycms = 33305;
/*     */   public static final int ManagerId_paasycmswarning = 33306;
/*     */   public static final int ManagerId_paasydow = 33311;
/*     */   public static final int ManagerId_paasydps = 33303;
/*     */   public static final int ManagerId_paasydpsreminder = 33304;
/*     */   public static final int ManagerId_paasyelka = 33315;
/*     */   public static final int ManagerId_paasyelow = 33302;
/*     */   public static final int ManagerId_paasyema = 33316;
/*     */   public static final int ManagerId_paasyhwa = 33295;
/*     */   public static final int ManagerId_paasylca = 33307;
/*     */   public static final int ManagerId_paasylcawarning = 33308;
/*     */   public static final int ManagerId_paasylka = 33312;
/*     */   public static final int ManagerId_paasylkamode = 33313;
/*     */   public static final int ManagerId_paasylkawarningmode = 33314;
/*     */   public static final int ManagerId_paasymsgend = 33904;
/*     */   public static final int ManagerId_paasyothertsr = 33297;
/*     */   public static final int ManagerId_paasyrcta = 33310;
/*     */   public static final int ManagerId_paasyrcw = 33309;
/*     */   public static final int ManagerId_paasyspeedcompensation = 33299;
/*     */   public static final int ManagerId_paasytla = 33300;
/*     */   public static final int ManagerId_paasytlasoundwarning = 33301;
/*     */   public static final int ManagerId_paasytsr = 33296;
/*     */   public static final int ManagerId_paasytsrwarning = 33298;
/*     */   private static final String TAG = "ECarXCarActivesafetyManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarActivesafetyManager() {}
/*     */   
/*     */   public ECarXCarActivesafetyManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 104 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_ACCandTSR(int paramInt) {
/* 114 */     ApiResult apiResult = ApiResult.FAILED;
/* 115 */     if (OnOff1.isValid(paramInt)) {
/* 116 */       apiResult = this.mMgr.setIntProperty(32768, 1, paramInt);
/*     */     } else {
/* 118 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 120 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_HWA(int paramInt) {
/* 130 */     ApiResult apiResult = ApiResult.FAILED;
/* 131 */     if (OnOff1.isValid(paramInt)) {
/* 132 */       apiResult = this.mMgr.setIntProperty(32769, 1, paramInt);
/*     */     } else {
/* 134 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 136 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_TSR(int paramInt) {
/* 146 */     ApiResult apiResult = ApiResult.FAILED;
/* 147 */     if (OnOff1.isValid(paramInt)) {
/* 148 */       apiResult = this.mMgr.setIntProperty(32770, 1, paramInt);
/*     */     } else {
/* 150 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 152 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_OtherTSR(int paramInt) {
/* 162 */     ApiResult apiResult = ApiResult.FAILED;
/* 163 */     if (OnOff1.isValid(paramInt)) {
/* 164 */       apiResult = this.mMgr.setIntProperty(32771, 1, paramInt);
/*     */     } else {
/* 166 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 168 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_TSR_Warning(int paramInt) {
/* 178 */     ApiResult apiResult = ApiResult.FAILED;
/* 179 */     if (DY1.isValid(paramInt)) {
/* 180 */       apiResult = this.mMgr.setIntProperty(32772, 1, paramInt);
/*     */     } else {
/* 182 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 184 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_SpeedCompensation(int paramInt) {
/* 194 */     ApiResult apiResult = ApiResult.FAILED;
/* 195 */     if (OffsForSpdWarnSetgReq.isValid(paramInt)) {
/* 196 */       apiResult = this.mMgr.setIntProperty(32773, 1, paramInt);
/*     */     } else {
/* 198 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 200 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_TLA(int paramInt) {
/* 210 */     ApiResult apiResult = ApiResult.FAILED;
/* 211 */     if (OnOff1.isValid(paramInt)) {
/* 212 */       apiResult = this.mMgr.setIntProperty(32774, 1, paramInt);
/*     */     } else {
/* 214 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 216 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_TLA_Sound_Warning(int paramInt) {
/* 226 */     ApiResult apiResult = ApiResult.FAILED;
/* 227 */     if (OnOff1.isValid(paramInt)) {
/* 228 */       apiResult = this.mMgr.setIntProperty(32775, 1, paramInt);
/*     */     } else {
/* 230 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 232 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_ELOW(int paramInt) {
/* 242 */     ApiResult apiResult = ApiResult.FAILED;
/* 243 */     if (OnOff1.isValid(paramInt)) {
/* 244 */       apiResult = this.mMgr.setIntProperty(32776, 1, paramInt);
/*     */     } else {
/* 246 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 248 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_DPS(int paramInt) {
/* 258 */     ApiResult apiResult = ApiResult.FAILED;
/* 259 */     if (OnOff1.isValid(paramInt)) {
/* 260 */       apiResult = this.mMgr.setIntProperty(32777, 1, paramInt);
/*     */     } else {
/* 262 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 264 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_DPS_Reminder(int paramInt) {
/* 274 */     ApiResult apiResult = ApiResult.FAILED;
/* 275 */     if (OnOff1.isValid(paramInt)) {
/* 276 */       apiResult = this.mMgr.setIntProperty(32778, 1, paramInt);
/*     */     } else {
/* 278 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 280 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_CMS(int paramInt) {
/* 290 */     ApiResult apiResult = ApiResult.FAILED;
/* 291 */     if (OnOff1.isValid(paramInt)) {
/* 292 */       apiResult = this.mMgr.setIntProperty(32779, 1, paramInt);
/*     */     } else {
/* 294 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 296 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_CMS_Warning(int paramInt) {
/* 306 */     ApiResult apiResult = ApiResult.FAILED;
/* 307 */     if (CllsnAidSnvtySeldSts.isValid(paramInt)) {
/* 308 */       apiResult = this.mMgr.setIntProperty(32780, 1, paramInt);
/*     */     } else {
/* 310 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 312 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_LCA(int paramInt) {
/* 322 */     ApiResult apiResult = ApiResult.FAILED;
/* 323 */     if (OnOff1.isValid(paramInt)) {
/* 324 */       apiResult = this.mMgr.setIntProperty(32781, 1, paramInt);
/*     */     } else {
/* 326 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 328 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_LCA_Warning(int paramInt) {
/* 338 */     ApiResult apiResult = ApiResult.FAILED;
/* 339 */     if (OnOff1.isValid(paramInt)) {
/* 340 */       apiResult = this.mMgr.setIntProperty(32782, 1, paramInt);
/*     */     } else {
/* 342 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 344 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_RCW(int paramInt) {
/* 354 */     ApiResult apiResult = ApiResult.FAILED;
/* 355 */     if (OnOff1.isValid(paramInt)) {
/* 356 */       apiResult = this.mMgr.setIntProperty(32783, 1, paramInt);
/*     */     } else {
/* 358 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 360 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_RCTA(int paramInt) {
/* 370 */     ApiResult apiResult = ApiResult.FAILED;
/* 371 */     if (OnOff1.isValid(paramInt)) {
/* 372 */       apiResult = this.mMgr.setIntProperty(32784, 1, paramInt);
/*     */     } else {
/* 374 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 376 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_DOW(int paramInt) {
/* 386 */     ApiResult apiResult = ApiResult.FAILED;
/* 387 */     if (OnOff1.isValid(paramInt)) {
/* 388 */       apiResult = this.mMgr.setIntProperty(32785, 1, paramInt);
/*     */     } else {
/* 390 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 392 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_LKA(int paramInt) {
/* 402 */     ApiResult apiResult = ApiResult.FAILED;
/* 403 */     if (OnOff1.isValid(paramInt)) {
/* 404 */       apiResult = this.mMgr.setIntProperty(32786, 1, paramInt);
/*     */     } else {
/* 406 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 408 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_LKA_MODE(int paramInt) {
/* 418 */     ApiResult apiResult = ApiResult.FAILED;
/* 419 */     if (IntvAndWarnModForLaneKeepAidSts.isValid(paramInt)) {
/* 420 */       apiResult = this.mMgr.setIntProperty(32787, 1, paramInt);
/*     */     } else {
/* 422 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 424 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_LKA_Warning_MODE(int paramInt) {
/* 434 */     ApiResult apiResult = ApiResult.FAILED;
/* 435 */     if (ChgWarnMod.isValid(paramInt)) {
/* 436 */       apiResult = this.mMgr.setIntProperty(32788, 1, paramInt);
/*     */     } else {
/* 438 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 440 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_ELKA(int paramInt) {
/* 450 */     ApiResult apiResult = ApiResult.FAILED;
/* 451 */     if (OnOff1.isValid(paramInt)) {
/* 452 */       apiResult = this.mMgr.setIntProperty(32789, 1, paramInt);
/*     */     } else {
/* 454 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 456 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_EMA(int paramInt) {
/* 466 */     ApiResult apiResult = ApiResult.FAILED;
/* 467 */     if (OnOff1.isValid(paramInt)) {
/* 468 */       apiResult = this.mMgr.setIntProperty(32790, 1, paramInt);
/*     */     } else {
/* 470 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 472 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ASY_Reboot(int paramInt) {
/* 482 */     return this.mMgr.setIntProperty(32791, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_ACCandTSR getPA_Asy_ACCandTSR() throws CarNotConnectedException {
/* 493 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33294, 1);
/*     */     
/* 495 */     PATypes.PA_Asy_ACCandTSR pA_Asy_ACCandTSR = null;
/*     */     try {
/* 497 */       PATypes.PA_Asy_ACCandTSR pA_Asy_ACCandTSR1 = new PATypes.PA_Asy_ACCandTSR(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_ACCandTSR = pA_Asy_ACCandTSR1;
/* 498 */     } catch (Exception exception) {}
/*     */     
/* 500 */     return pA_Asy_ACCandTSR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_HWA getPA_Asy_HWA() throws CarNotConnectedException {
/* 509 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33295, 1);
/*     */     
/* 511 */     PATypes.PA_Asy_HWA pA_Asy_HWA = null;
/*     */     try {
/* 513 */       PATypes.PA_Asy_HWA pA_Asy_HWA1 = new PATypes.PA_Asy_HWA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_HWA = pA_Asy_HWA1;
/* 514 */     } catch (Exception exception) {}
/*     */     
/* 516 */     return pA_Asy_HWA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_TSR getPA_Asy_TSR() throws CarNotConnectedException {
/* 525 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33296, 1);
/*     */     
/* 527 */     PATypes.PA_Asy_TSR pA_Asy_TSR = null;
/*     */     try {
/* 529 */       PATypes.PA_Asy_TSR pA_Asy_TSR1 = new PATypes.PA_Asy_TSR(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_TSR = pA_Asy_TSR1;
/* 530 */     } catch (Exception exception) {}
/*     */     
/* 532 */     return pA_Asy_TSR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_OtherTSR getPA_Asy_OtherTSR() throws CarNotConnectedException {
/* 541 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33297, 1);
/*     */     
/* 543 */     PATypes.PA_Asy_OtherTSR pA_Asy_OtherTSR = null;
/*     */     try {
/* 545 */       PATypes.PA_Asy_OtherTSR pA_Asy_OtherTSR1 = new PATypes.PA_Asy_OtherTSR(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_OtherTSR = pA_Asy_OtherTSR1;
/* 546 */     } catch (Exception exception) {}
/*     */     
/* 548 */     return pA_Asy_OtherTSR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_TSR_Warning getPA_Asy_TSR_Warning() throws CarNotConnectedException {
/* 557 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33298, 1);
/*     */     
/* 559 */     PATypes.PA_Asy_TSR_Warning pA_Asy_TSR_Warning = null;
/*     */     try {
/* 561 */       PATypes.PA_Asy_TSR_Warning pA_Asy_TSR_Warning1 = new PATypes.PA_Asy_TSR_Warning(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_TSR_Warning = pA_Asy_TSR_Warning1;
/* 562 */     } catch (Exception exception) {}
/*     */     
/* 564 */     return pA_Asy_TSR_Warning;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_SpeedCompensation getPA_Asy_SpeedCompensation() throws CarNotConnectedException {
/* 573 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33299, 1);
/*     */     
/* 575 */     PATypes.PA_Asy_SpeedCompensation pA_Asy_SpeedCompensation = null;
/*     */     try {
/* 577 */       PATypes.PA_Asy_SpeedCompensation pA_Asy_SpeedCompensation1 = new PATypes.PA_Asy_SpeedCompensation(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_SpeedCompensation = pA_Asy_SpeedCompensation1;
/* 578 */     } catch (Exception exception) {}
/*     */     
/* 580 */     return pA_Asy_SpeedCompensation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_TLA getPA_Asy_TLA() throws CarNotConnectedException {
/* 589 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33300, 1);
/*     */     
/* 591 */     PATypes.PA_Asy_TLA pA_Asy_TLA = null;
/*     */     try {
/* 593 */       PATypes.PA_Asy_TLA pA_Asy_TLA1 = new PATypes.PA_Asy_TLA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_TLA = pA_Asy_TLA1;
/* 594 */     } catch (Exception exception) {}
/*     */     
/* 596 */     return pA_Asy_TLA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_TLA_Sound_Warning getPA_Asy_TLA_Sound_Warning() throws CarNotConnectedException {
/* 605 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33301, 1);
/*     */     
/* 607 */     PATypes.PA_Asy_TLA_Sound_Warning pA_Asy_TLA_Sound_Warning = null;
/*     */     try {
/* 609 */       PATypes.PA_Asy_TLA_Sound_Warning pA_Asy_TLA_Sound_Warning1 = new PATypes.PA_Asy_TLA_Sound_Warning(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_TLA_Sound_Warning = pA_Asy_TLA_Sound_Warning1;
/* 610 */     } catch (Exception exception) {}
/*     */     
/* 612 */     return pA_Asy_TLA_Sound_Warning;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_ELOW getPA_Asy_ELOW() throws CarNotConnectedException {
/* 621 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33302, 1);
/*     */     
/* 623 */     PATypes.PA_Asy_ELOW pA_Asy_ELOW = null;
/*     */     try {
/* 625 */       PATypes.PA_Asy_ELOW pA_Asy_ELOW1 = new PATypes.PA_Asy_ELOW(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_ELOW = pA_Asy_ELOW1;
/* 626 */     } catch (Exception exception) {}
/*     */     
/* 628 */     return pA_Asy_ELOW;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_DPS getPA_Asy_DPS() throws CarNotConnectedException {
/* 637 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33303, 1);
/*     */     
/* 639 */     PATypes.PA_Asy_DPS pA_Asy_DPS = null;
/*     */     try {
/* 641 */       PATypes.PA_Asy_DPS pA_Asy_DPS1 = new PATypes.PA_Asy_DPS(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_DPS = pA_Asy_DPS1;
/* 642 */     } catch (Exception exception) {}
/*     */     
/* 644 */     return pA_Asy_DPS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_DPS_Reminder getPA_Asy_DPS_Reminder() throws CarNotConnectedException {
/* 653 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33304, 1);
/*     */     
/* 655 */     PATypes.PA_Asy_DPS_Reminder pA_Asy_DPS_Reminder = null;
/*     */     try {
/* 657 */       PATypes.PA_Asy_DPS_Reminder pA_Asy_DPS_Reminder1 = new PATypes.PA_Asy_DPS_Reminder(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_DPS_Reminder = pA_Asy_DPS_Reminder1;
/* 658 */     } catch (Exception exception) {}
/*     */     
/* 660 */     return pA_Asy_DPS_Reminder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_CMS getPA_Asy_CMS() throws CarNotConnectedException {
/* 669 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33305, 1);
/*     */     
/* 671 */     PATypes.PA_Asy_CMS pA_Asy_CMS = null;
/*     */     try {
/* 673 */       PATypes.PA_Asy_CMS pA_Asy_CMS1 = new PATypes.PA_Asy_CMS(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_CMS = pA_Asy_CMS1;
/* 674 */     } catch (Exception exception) {}
/*     */     
/* 676 */     return pA_Asy_CMS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_CMS_Warning getPA_Asy_CMS_Warning() throws CarNotConnectedException {
/* 685 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33306, 1);
/*     */     
/* 687 */     PATypes.PA_Asy_CMS_Warning pA_Asy_CMS_Warning = null;
/*     */     try {
/* 689 */       PATypes.PA_Asy_CMS_Warning pA_Asy_CMS_Warning1 = new PATypes.PA_Asy_CMS_Warning(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_CMS_Warning = pA_Asy_CMS_Warning1;
/* 690 */     } catch (Exception exception) {}
/*     */     
/* 692 */     return pA_Asy_CMS_Warning;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_LCA getPA_Asy_LCA() throws CarNotConnectedException {
/* 701 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33307, 1);
/*     */     
/* 703 */     PATypes.PA_Asy_LCA pA_Asy_LCA = null;
/*     */     try {
/* 705 */       PATypes.PA_Asy_LCA pA_Asy_LCA1 = new PATypes.PA_Asy_LCA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_LCA = pA_Asy_LCA1;
/* 706 */     } catch (Exception exception) {}
/*     */     
/* 708 */     return pA_Asy_LCA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_LCA_Warning getPA_Asy_LCA_Warning() throws CarNotConnectedException {
/* 717 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33308, 1);
/*     */     
/* 719 */     PATypes.PA_Asy_LCA_Warning pA_Asy_LCA_Warning = null;
/*     */     try {
/* 721 */       PATypes.PA_Asy_LCA_Warning pA_Asy_LCA_Warning1 = new PATypes.PA_Asy_LCA_Warning(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_LCA_Warning = pA_Asy_LCA_Warning1;
/* 722 */     } catch (Exception exception) {}
/*     */     
/* 724 */     return pA_Asy_LCA_Warning;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_RCW getPA_Asy_RCW() throws CarNotConnectedException {
/* 733 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33309, 1);
/*     */     
/* 735 */     PATypes.PA_Asy_RCW pA_Asy_RCW = null;
/*     */     try {
/* 737 */       PATypes.PA_Asy_RCW pA_Asy_RCW1 = new PATypes.PA_Asy_RCW(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_RCW = pA_Asy_RCW1;
/* 738 */     } catch (Exception exception) {}
/*     */     
/* 740 */     return pA_Asy_RCW;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_RCTA getPA_Asy_RCTA() throws CarNotConnectedException {
/* 749 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33310, 1);
/*     */     
/* 751 */     PATypes.PA_Asy_RCTA pA_Asy_RCTA = null;
/*     */     try {
/* 753 */       PATypes.PA_Asy_RCTA pA_Asy_RCTA1 = new PATypes.PA_Asy_RCTA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_RCTA = pA_Asy_RCTA1;
/* 754 */     } catch (Exception exception) {}
/*     */     
/* 756 */     return pA_Asy_RCTA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_DOW getPA_Asy_DOW() throws CarNotConnectedException {
/* 765 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33311, 1);
/*     */     
/* 767 */     PATypes.PA_Asy_DOW pA_Asy_DOW = null;
/*     */     try {
/* 769 */       PATypes.PA_Asy_DOW pA_Asy_DOW1 = new PATypes.PA_Asy_DOW(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_DOW = pA_Asy_DOW1;
/* 770 */     } catch (Exception exception) {}
/*     */     
/* 772 */     return pA_Asy_DOW;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_LKA getPA_Asy_LKA() throws CarNotConnectedException {
/* 781 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33312, 1);
/*     */     
/* 783 */     PATypes.PA_Asy_LKA pA_Asy_LKA = null;
/*     */     try {
/* 785 */       PATypes.PA_Asy_LKA pA_Asy_LKA1 = new PATypes.PA_Asy_LKA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_LKA = pA_Asy_LKA1;
/* 786 */     } catch (Exception exception) {}
/*     */     
/* 788 */     return pA_Asy_LKA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_LKA_Mode getPA_Asy_LKA_Mode() throws CarNotConnectedException {
/* 797 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33313, 1);
/*     */     
/* 799 */     PATypes.PA_Asy_LKA_Mode pA_Asy_LKA_Mode = null;
/*     */     try {
/* 801 */       PATypes.PA_Asy_LKA_Mode pA_Asy_LKA_Mode1 = new PATypes.PA_Asy_LKA_Mode(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_LKA_Mode = pA_Asy_LKA_Mode1;
/* 802 */     } catch (Exception exception) {}
/*     */     
/* 804 */     return pA_Asy_LKA_Mode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_LKA_Warning_Mode getPA_Asy_LKA_Warning_Mode() throws CarNotConnectedException {
/* 813 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33314, 1);
/*     */     
/* 815 */     PATypes.PA_Asy_LKA_Warning_Mode pA_Asy_LKA_Warning_Mode = null;
/*     */     try {
/* 817 */       PATypes.PA_Asy_LKA_Warning_Mode pA_Asy_LKA_Warning_Mode1 = new PATypes.PA_Asy_LKA_Warning_Mode(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_LKA_Warning_Mode = pA_Asy_LKA_Warning_Mode1;
/* 818 */     } catch (Exception exception) {}
/*     */     
/* 820 */     return pA_Asy_LKA_Warning_Mode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_ELKA getPA_Asy_ELKA() throws CarNotConnectedException {
/* 829 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33315, 1);
/*     */     
/* 831 */     PATypes.PA_Asy_ELKA pA_Asy_ELKA = null;
/*     */     try {
/* 833 */       PATypes.PA_Asy_ELKA pA_Asy_ELKA1 = new PATypes.PA_Asy_ELKA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_ELKA = pA_Asy_ELKA1;
/* 834 */     } catch (Exception exception) {}
/*     */     
/* 836 */     return pA_Asy_ELKA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_EMA getPA_Asy_EMA() throws CarNotConnectedException {
/* 845 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33316, 1);
/*     */     
/* 847 */     PATypes.PA_Asy_EMA pA_Asy_EMA = null;
/*     */     try {
/* 849 */       PATypes.PA_Asy_EMA pA_Asy_EMA1 = new PATypes.PA_Asy_EMA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_EMA = pA_Asy_EMA1;
/* 850 */     } catch (Exception exception) {}
/*     */     
/* 852 */     return pA_Asy_EMA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Asy_MsgEnd getPA_Asy_MsgEnd() throws CarNotConnectedException {
/* 861 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33904, 1);
/*     */     
/* 863 */     PATypes.PA_Asy_MsgEnd pA_Asy_MsgEnd = null;
/*     */     try {
/* 865 */       PATypes.PA_Asy_MsgEnd pA_Asy_MsgEnd1 = new PATypes.PA_Asy_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Asy_MsgEnd = pA_Asy_MsgEnd1;
/* 866 */     } catch (Exception exception) {}
/*     */     
/* 868 */     return pA_Asy_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarActivesafetyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */