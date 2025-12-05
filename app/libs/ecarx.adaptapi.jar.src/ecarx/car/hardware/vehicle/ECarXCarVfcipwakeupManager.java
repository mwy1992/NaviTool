/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
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
/*     */ public class ECarXCarVfcipwakeupManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbgenchasettingsforhmicen = 32944;
/*     */   public static final int ManagerId_cbnavigationinfosharing = 32945;
/*     */   public static final int ManagerId_cbsetvehapa = 32939;
/*     */   public static final int ManagerId_cbsetvehavm = 32940;
/*     */   public static final int ManagerId_cbsetvehcenclkindcnandsetg = 32937;
/*     */   public static final int ManagerId_cbsetvehcharging = 32943;
/*     */   public static final int ManagerId_cbsetvehdvr = 32942;
/*     */   public static final int ManagerId_cbsetvehface = 32953;
/*     */   public static final int ManagerId_cbsetvehprivatelock = 32938;
/*     */   public static final int ManagerId_cbsetvehtcam = 32941;
/*     */   public static final int ManagerId_cbvfcexteriorlightshow = 32947;
/*     */   public static final int ManagerId_cbvfcexteriorlightshowwin = 32946;
/*     */   public static final int ManagerId_cbvfcfaceidnforhmicen = 32935;
/*     */   public static final int ManagerId_cbvfcipwakeup = 32933;
/*     */   public static final int ManagerId_cbvfcparkassictrlforhmicen = 32934;
/*     */   public static final int ManagerId_cbvfcreboot = 32956;
/*     */   public static final int ManagerId_cbvfcrsrv1 = 32948;
/*     */   public static final int ManagerId_cbvfcrsrv2 = 32949;
/*     */   public static final int ManagerId_cbvfcrsrv3 = 32950;
/*     */   public static final int ManagerId_cbvfcrsrv4 = 32951;
/*     */   public static final int ManagerId_cbvfcrsrv5 = 32952;
/*     */   public static final int ManagerId_cbvfcscenemodepdc = 32954;
/*     */   public static final int ManagerId_cbvfcsetvehscenemode = 32955;
/*     */   public static final int ManagerId_cbvfctelephonemanager = 32936;
/*     */   public static final int ManagerId_pavfcexteriorlightshow = 33523;
/*     */   public static final int ManagerId_pavfcexteriorlightshowwin = 33522;
/*     */   public static final int ManagerId_pavfcfaceidnforhmicen = 33511;
/*     */   public static final int ManagerId_pavfcgenchasettingsforhmicen = 33520;
/*     */   public static final int ManagerId_pavfcipwakeup = 33509;
/*     */   public static final int ManagerId_pavfcmsgend = 33917;
/*     */   public static final int ManagerId_pavfcnavigationinfosharing = 33521;
/*     */   public static final int ManagerId_pavfcparkassictrlforhmicen = 33510;
/*     */   public static final int ManagerId_pavfcscenemodepdc = 33531;
/*     */   public static final int ManagerId_pavfcsetvehapa = 33515;
/*     */   public static final int ManagerId_pavfcsetvehavm = 33516;
/*     */   public static final int ManagerId_pavfcsetvehcenclkindcnandsetg = 33513;
/*     */   public static final int ManagerId_pavfcsetvehcharging = 33519;
/*     */   public static final int ManagerId_pavfcsetvehdvr = 33518;
/*     */   public static final int ManagerId_pavfcsetvehface = 33529;
/*     */   public static final int ManagerId_pavfcsetvehprivatelock = 33514;
/*     */   public static final int ManagerId_pavfcsetvehscenemode = 33532;
/*     */   public static final int ManagerId_pavfcsetvehtcam = 33517;
/*     */   public static final int ManagerId_pavfctelephonemanager = 33512;
/*     */   public static final int ManagerId_pavfcvfcreboot = 33530;
/*     */   public static final int ManagerId_pavfcvfcrsrv1 = 33524;
/*     */   public static final int ManagerId_pavfcvfcrsrv2 = 33525;
/*     */   public static final int ManagerId_pavfcvfcrsrv3 = 33526;
/*     */   public static final int ManagerId_pavfcvfcrsrv4 = 33527;
/*     */   public static final int ManagerId_pavfcvfcrsrv5 = 33528;
/*     */   private static final String TAG = "ECarXCarVfcipwakeupManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarVfcipwakeupManager() {}
/*     */   
/*     */   public ECarXCarVfcipwakeupManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 100 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFC_IPWakeup(int paramInt) {
/* 110 */     ApiResult apiResult = ApiResult.FAILED;
/* 111 */     if (OnOff1.isValid(paramInt)) {
/* 112 */       apiResult = this.mMgr.setIntProperty(32933, 1, paramInt);
/*     */     } else {
/* 114 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 116 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFC_ParkAssiCtrlForHmiCen(int paramInt) {
/* 126 */     ApiResult apiResult = ApiResult.FAILED;
/* 127 */     if (OnOff1.isValid(paramInt)) {
/* 128 */       apiResult = this.mMgr.setIntProperty(32934, 1, paramInt);
/*     */     } else {
/* 130 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 132 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFC_FaceIdnForHmiCen(int paramInt) {
/* 142 */     ApiResult apiResult = ApiResult.FAILED;
/* 143 */     if (OnOff1.isValid(paramInt)) {
/* 144 */       apiResult = this.mMgr.setIntProperty(32935, 1, paramInt);
/*     */     } else {
/* 146 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 148 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFC_TelephoneManager(int paramInt) {
/* 158 */     ApiResult apiResult = ApiResult.FAILED;
/* 159 */     if (OnOff1.isValid(paramInt)) {
/* 160 */       apiResult = this.mMgr.setIntProperty(32936, 1, paramInt);
/*     */     } else {
/* 162 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 164 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehCenClkIndcnAndSetg(int paramInt) {
/* 174 */     ApiResult apiResult = ApiResult.FAILED;
/* 175 */     if (OnOff1.isValid(paramInt)) {
/* 176 */       apiResult = this.mMgr.setIntProperty(32937, 1, paramInt);
/*     */     } else {
/* 178 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 180 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehPrivateLock(int paramInt) {
/* 190 */     ApiResult apiResult = ApiResult.FAILED;
/* 191 */     if (OnOff1.isValid(paramInt)) {
/* 192 */       apiResult = this.mMgr.setIntProperty(32938, 1, paramInt);
/*     */     } else {
/* 194 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 196 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehApa(int paramInt) {
/* 206 */     ApiResult apiResult = ApiResult.FAILED;
/* 207 */     if (OnOff1.isValid(paramInt)) {
/* 208 */       apiResult = this.mMgr.setIntProperty(32939, 1, paramInt);
/*     */     } else {
/* 210 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 212 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehAvm(int paramInt) {
/* 222 */     ApiResult apiResult = ApiResult.FAILED;
/* 223 */     if (OnOff1.isValid(paramInt)) {
/* 224 */       apiResult = this.mMgr.setIntProperty(32940, 1, paramInt);
/*     */     } else {
/* 226 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 228 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehTcam(int paramInt) {
/* 238 */     ApiResult apiResult = ApiResult.FAILED;
/* 239 */     if (OnOff1.isValid(paramInt)) {
/* 240 */       apiResult = this.mMgr.setIntProperty(32941, 1, paramInt);
/*     */     } else {
/* 242 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 244 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehDvr(int paramInt) {
/* 254 */     ApiResult apiResult = ApiResult.FAILED;
/* 255 */     if (OnOff1.isValid(paramInt)) {
/* 256 */       apiResult = this.mMgr.setIntProperty(32942, 1, paramInt);
/*     */     } else {
/* 258 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 260 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehCharging(int paramInt) {
/* 271 */     ApiResult apiResult = ApiResult.FAILED;
/* 272 */     if (OnOff1.isValid(paramInt)) {
/* 273 */       apiResult = this.mMgr.setIntProperty(32943, 1, paramInt);
/*     */     } else {
/* 275 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 277 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_GenChaSettingsForHmiCen(int paramInt) {
/* 288 */     ApiResult apiResult = ApiResult.FAILED;
/* 289 */     if (OnOff1.isValid(paramInt)) {
/* 290 */       apiResult = this.mMgr.setIntProperty(32944, 1, paramInt);
/*     */     } else {
/* 292 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 294 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_NavigationInfoSharing(int paramInt) {
/* 304 */     ApiResult apiResult = ApiResult.FAILED;
/* 305 */     if (OnOff1.isValid(paramInt)) {
/* 306 */       apiResult = this.mMgr.setIntProperty(32945, 1, paramInt);
/*     */     } else {
/* 308 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 310 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFC_ExteriorLightShowWin(int paramInt) {
/* 320 */     ApiResult apiResult = ApiResult.FAILED;
/* 321 */     if (OnOff1.isValid(paramInt)) {
/* 322 */       apiResult = this.mMgr.setIntProperty(32946, 1, paramInt);
/*     */     } else {
/* 324 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 326 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFC_ExteriorLightShow(int paramInt) {
/* 336 */     ApiResult apiResult = ApiResult.FAILED;
/* 337 */     if (OnOff1.isValid(paramInt)) {
/* 338 */       apiResult = this.mMgr.setIntProperty(32947, 1, paramInt);
/*     */     } else {
/* 340 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 342 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFCRsrv1(int paramInt) {
/* 352 */     return this.mMgr.setIntProperty(32948, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFCRsrv2(int paramInt) {
/* 362 */     return this.mMgr.setIntProperty(32949, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFCRsrv3(int paramInt) {
/* 372 */     return this.mMgr.setIntProperty(32950, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFCRsrv4(int paramInt) {
/* 382 */     return this.mMgr.setIntProperty(32951, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFCRsrv5(int paramInt) {
/* 392 */     return this.mMgr.setIntProperty(32952, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SetVehFace(int paramInt) {
/* 402 */     ApiResult apiResult = ApiResult.FAILED;
/* 403 */     if (OnOff1.isValid(paramInt)) {
/* 404 */       apiResult = this.mMgr.setIntProperty(32953, 1, paramInt);
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
/*     */   public ApiResult CB_VFC_SceneModePDC(int paramInt) {
/* 418 */     ApiResult apiResult = ApiResult.FAILED;
/* 419 */     if (OnOff1.isValid(paramInt)) {
/* 420 */       apiResult = this.mMgr.setIntProperty(32954, 1, paramInt);
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
/*     */   
/*     */   public ApiResult CB_VFC_SetVehSceneMode(int paramInt) {
/* 435 */     ApiResult apiResult = ApiResult.FAILED;
/* 436 */     if (OnOff1.isValid(paramInt)) {
/* 437 */       apiResult = this.mMgr.setIntProperty(32955, 1, paramInt);
/*     */     } else {
/* 439 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 441 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFC_Reboot(int paramInt) {
/* 451 */     return this.mMgr.setIntProperty(32956, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_IPWakeup getPA_VFC_IPWakeup() throws CarNotConnectedException {
/* 462 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33509, 1);
/*     */     
/* 464 */     PATypes.PA_VFC_IPWakeup pA_VFC_IPWakeup = null;
/*     */     try {
/* 466 */       PATypes.PA_VFC_IPWakeup pA_VFC_IPWakeup1 = new PATypes.PA_VFC_IPWakeup(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_IPWakeup = pA_VFC_IPWakeup1;
/* 467 */     } catch (Exception exception) {}
/*     */     
/* 469 */     return pA_VFC_IPWakeup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_ParkAssiCtrlForHmiCen getPA_VFC_ParkAssiCtrlForHmiCen() throws CarNotConnectedException {
/* 478 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33510, 1);
/*     */     
/* 480 */     PATypes.PA_VFC_ParkAssiCtrlForHmiCen pA_VFC_ParkAssiCtrlForHmiCen = null;
/*     */     try {
/* 482 */       PATypes.PA_VFC_ParkAssiCtrlForHmiCen pA_VFC_ParkAssiCtrlForHmiCen1 = new PATypes.PA_VFC_ParkAssiCtrlForHmiCen(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_ParkAssiCtrlForHmiCen = pA_VFC_ParkAssiCtrlForHmiCen1;
/* 483 */     } catch (Exception exception) {}
/*     */     
/* 485 */     return pA_VFC_ParkAssiCtrlForHmiCen;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_FaceIdnForHmiCen getPA_VFC_FaceIdnForHmiCen() throws CarNotConnectedException {
/* 494 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33511, 1);
/*     */     
/* 496 */     PATypes.PA_VFC_FaceIdnForHmiCen pA_VFC_FaceIdnForHmiCen = null;
/*     */     try {
/* 498 */       PATypes.PA_VFC_FaceIdnForHmiCen pA_VFC_FaceIdnForHmiCen1 = new PATypes.PA_VFC_FaceIdnForHmiCen(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_FaceIdnForHmiCen = pA_VFC_FaceIdnForHmiCen1;
/* 499 */     } catch (Exception exception) {}
/*     */     
/* 501 */     return pA_VFC_FaceIdnForHmiCen;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_TelephoneManager getPA_VFC_TelephoneManager() throws CarNotConnectedException {
/* 510 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33512, 1);
/*     */     
/* 512 */     PATypes.PA_VFC_TelephoneManager pA_VFC_TelephoneManager = null;
/*     */     try {
/* 514 */       PATypes.PA_VFC_TelephoneManager pA_VFC_TelephoneManager1 = new PATypes.PA_VFC_TelephoneManager(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_TelephoneManager = pA_VFC_TelephoneManager1;
/* 515 */     } catch (Exception exception) {}
/*     */     
/* 517 */     return pA_VFC_TelephoneManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehCenClkIndcnAndSetg getPA_VFC_SetVehCenClkIndcnAndSetg() throws CarNotConnectedException {
/* 526 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33513, 1);
/*     */     
/* 528 */     PATypes.PA_VFC_SetVehCenClkIndcnAndSetg pA_VFC_SetVehCenClkIndcnAndSetg = null;
/*     */     try {
/* 530 */       PATypes.PA_VFC_SetVehCenClkIndcnAndSetg pA_VFC_SetVehCenClkIndcnAndSetg1 = new PATypes.PA_VFC_SetVehCenClkIndcnAndSetg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehCenClkIndcnAndSetg = pA_VFC_SetVehCenClkIndcnAndSetg1;
/* 531 */     } catch (Exception exception) {}
/*     */     
/* 533 */     return pA_VFC_SetVehCenClkIndcnAndSetg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehPrivateLock getPA_VFC_SetVehPrivateLock() throws CarNotConnectedException {
/* 542 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33514, 1);
/*     */     
/* 544 */     PATypes.PA_VFC_SetVehPrivateLock pA_VFC_SetVehPrivateLock = null;
/*     */     try {
/* 546 */       PATypes.PA_VFC_SetVehPrivateLock pA_VFC_SetVehPrivateLock1 = new PATypes.PA_VFC_SetVehPrivateLock(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehPrivateLock = pA_VFC_SetVehPrivateLock1;
/* 547 */     } catch (Exception exception) {}
/*     */     
/* 549 */     return pA_VFC_SetVehPrivateLock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehApa getPA_VFC_SetVehApa() throws CarNotConnectedException {
/* 558 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33515, 1);
/*     */     
/* 560 */     PATypes.PA_VFC_SetVehApa pA_VFC_SetVehApa = null;
/*     */     try {
/* 562 */       PATypes.PA_VFC_SetVehApa pA_VFC_SetVehApa1 = new PATypes.PA_VFC_SetVehApa(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehApa = pA_VFC_SetVehApa1;
/* 563 */     } catch (Exception exception) {}
/*     */     
/* 565 */     return pA_VFC_SetVehApa;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehAvm getPA_VFC_SetVehAvm() throws CarNotConnectedException {
/* 574 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33516, 1);
/*     */     
/* 576 */     PATypes.PA_VFC_SetVehAvm pA_VFC_SetVehAvm = null;
/*     */     try {
/* 578 */       PATypes.PA_VFC_SetVehAvm pA_VFC_SetVehAvm1 = new PATypes.PA_VFC_SetVehAvm(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehAvm = pA_VFC_SetVehAvm1;
/* 579 */     } catch (Exception exception) {}
/*     */     
/* 581 */     return pA_VFC_SetVehAvm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehTcam getPA_VFC_SetVehTcam() throws CarNotConnectedException {
/* 590 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33517, 1);
/*     */     
/* 592 */     PATypes.PA_VFC_SetVehTcam pA_VFC_SetVehTcam = null;
/*     */     try {
/* 594 */       PATypes.PA_VFC_SetVehTcam pA_VFC_SetVehTcam1 = new PATypes.PA_VFC_SetVehTcam(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehTcam = pA_VFC_SetVehTcam1;
/* 595 */     } catch (Exception exception) {}
/*     */     
/* 597 */     return pA_VFC_SetVehTcam;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehDvr getPA_VFC_SetVehDvr() throws CarNotConnectedException {
/* 606 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33518, 1);
/*     */     
/* 608 */     PATypes.PA_VFC_SetVehDvr pA_VFC_SetVehDvr = null;
/*     */     try {
/* 610 */       PATypes.PA_VFC_SetVehDvr pA_VFC_SetVehDvr1 = new PATypes.PA_VFC_SetVehDvr(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehDvr = pA_VFC_SetVehDvr1;
/* 611 */     } catch (Exception exception) {}
/*     */     
/* 613 */     return pA_VFC_SetVehDvr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFCSetVehCharging getPA_VFCSetVehCharging() throws CarNotConnectedException {
/* 622 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33519, 1);
/*     */     
/* 624 */     PATypes.PA_VFCSetVehCharging pA_VFCSetVehCharging = null;
/*     */     try {
/* 626 */       PATypes.PA_VFCSetVehCharging pA_VFCSetVehCharging1 = new PATypes.PA_VFCSetVehCharging(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFCSetVehCharging = pA_VFCSetVehCharging1;
/* 627 */     } catch (Exception exception) {}
/*     */     
/* 629 */     return pA_VFCSetVehCharging;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFCGenChaSettingsForHmiCen getPA_VFCGenChaSettingsForHmiCen() throws CarNotConnectedException {
/* 638 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33520, 1);
/*     */     
/* 640 */     PATypes.PA_VFCGenChaSettingsForHmiCen pA_VFCGenChaSettingsForHmiCen = null;
/*     */     try {
/* 642 */       PATypes.PA_VFCGenChaSettingsForHmiCen pA_VFCGenChaSettingsForHmiCen1 = new PATypes.PA_VFCGenChaSettingsForHmiCen(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFCGenChaSettingsForHmiCen = pA_VFCGenChaSettingsForHmiCen1;
/* 643 */     } catch (Exception exception) {}
/*     */     
/* 645 */     return pA_VFCGenChaSettingsForHmiCen;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFCNavigationInfoSharing getPA_VFCNavigationInfoSharing() throws CarNotConnectedException {
/* 654 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33521, 1);
/*     */     
/* 656 */     PATypes.PA_VFCNavigationInfoSharing pA_VFCNavigationInfoSharing = null;
/*     */     try {
/* 658 */       PATypes.PA_VFCNavigationInfoSharing pA_VFCNavigationInfoSharing1 = new PATypes.PA_VFCNavigationInfoSharing(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFCNavigationInfoSharing = pA_VFCNavigationInfoSharing1;
/* 659 */     } catch (Exception exception) {}
/*     */     
/* 661 */     return pA_VFCNavigationInfoSharing;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_ExteriorLightShowWin getPA_VFC_ExteriorLightShowWin() throws CarNotConnectedException {
/* 670 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33522, 1);
/*     */     
/* 672 */     PATypes.PA_VFC_ExteriorLightShowWin pA_VFC_ExteriorLightShowWin = null;
/*     */     try {
/* 674 */       PATypes.PA_VFC_ExteriorLightShowWin pA_VFC_ExteriorLightShowWin1 = new PATypes.PA_VFC_ExteriorLightShowWin(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_ExteriorLightShowWin = pA_VFC_ExteriorLightShowWin1;
/* 675 */     } catch (Exception exception) {}
/*     */     
/* 677 */     return pA_VFC_ExteriorLightShowWin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_ExteriorLightShow getPA_VFC_ExteriorLightShow() throws CarNotConnectedException {
/* 686 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33523, 1);
/*     */     
/* 688 */     PATypes.PA_VFC_ExteriorLightShow pA_VFC_ExteriorLightShow = null;
/*     */     try {
/* 690 */       PATypes.PA_VFC_ExteriorLightShow pA_VFC_ExteriorLightShow1 = new PATypes.PA_VFC_ExteriorLightShow(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_ExteriorLightShow = pA_VFC_ExteriorLightShow1;
/* 691 */     } catch (Exception exception) {}
/*     */     
/* 693 */     return pA_VFC_ExteriorLightShow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_VFCRsrv1 getPA_VFC_VFCRsrv1() throws CarNotConnectedException {
/* 702 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33524, 1);
/*     */     
/* 704 */     PATypes.PA_VFC_VFCRsrv1 pA_VFC_VFCRsrv1 = null;
/*     */     try {
/* 706 */       PATypes.PA_VFC_VFCRsrv1 pA_VFC_VFCRsrv11 = new PATypes.PA_VFC_VFCRsrv1(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_VFCRsrv1 = pA_VFC_VFCRsrv11;
/* 707 */     } catch (Exception exception) {}
/*     */     
/* 709 */     return pA_VFC_VFCRsrv1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_VFCRsrv2 getPA_VFC_VFCRsrv2() throws CarNotConnectedException {
/* 718 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33525, 1);
/*     */     
/* 720 */     PATypes.PA_VFC_VFCRsrv2 pA_VFC_VFCRsrv2 = null;
/*     */     try {
/* 722 */       PATypes.PA_VFC_VFCRsrv2 pA_VFC_VFCRsrv21 = new PATypes.PA_VFC_VFCRsrv2(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_VFCRsrv2 = pA_VFC_VFCRsrv21;
/* 723 */     } catch (Exception exception) {}
/*     */     
/* 725 */     return pA_VFC_VFCRsrv2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_VFCRsrv3 getPA_VFC_VFCRsrv3() throws CarNotConnectedException {
/* 734 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33526, 1);
/*     */     
/* 736 */     PATypes.PA_VFC_VFCRsrv3 pA_VFC_VFCRsrv3 = null;
/*     */     try {
/* 738 */       PATypes.PA_VFC_VFCRsrv3 pA_VFC_VFCRsrv31 = new PATypes.PA_VFC_VFCRsrv3(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_VFCRsrv3 = pA_VFC_VFCRsrv31;
/* 739 */     } catch (Exception exception) {}
/*     */     
/* 741 */     return pA_VFC_VFCRsrv3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_VFCRsrv4 getPA_VFC_VFCRsrv4() throws CarNotConnectedException {
/* 750 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33527, 1);
/*     */     
/* 752 */     PATypes.PA_VFC_VFCRsrv4 pA_VFC_VFCRsrv4 = null;
/*     */     try {
/* 754 */       PATypes.PA_VFC_VFCRsrv4 pA_VFC_VFCRsrv41 = new PATypes.PA_VFC_VFCRsrv4(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_VFCRsrv4 = pA_VFC_VFCRsrv41;
/* 755 */     } catch (Exception exception) {}
/*     */     
/* 757 */     return pA_VFC_VFCRsrv4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_VFCRsrv5 getPA_VFC_VFCRsrv5() throws CarNotConnectedException {
/* 766 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33528, 1);
/*     */     
/* 768 */     PATypes.PA_VFC_VFCRsrv5 pA_VFC_VFCRsrv5 = null;
/*     */     try {
/* 770 */       PATypes.PA_VFC_VFCRsrv5 pA_VFC_VFCRsrv51 = new PATypes.PA_VFC_VFCRsrv5(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_VFCRsrv5 = pA_VFC_VFCRsrv51;
/* 771 */     } catch (Exception exception) {}
/*     */     
/* 773 */     return pA_VFC_VFCRsrv5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehFace getPA_VFC_SetVehFace() throws CarNotConnectedException {
/* 782 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33529, 1);
/*     */     
/* 784 */     PATypes.PA_VFC_SetVehFace pA_VFC_SetVehFace = null;
/*     */     try {
/* 786 */       PATypes.PA_VFC_SetVehFace pA_VFC_SetVehFace1 = new PATypes.PA_VFC_SetVehFace(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehFace = pA_VFC_SetVehFace1;
/* 787 */     } catch (Exception exception) {}
/*     */     
/* 789 */     return pA_VFC_SetVehFace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_VFC_Reboot getPA_VFC_VFC_Reboot() throws CarNotConnectedException {
/* 798 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33530, 1);
/*     */     
/* 800 */     PATypes.PA_VFC_VFC_Reboot pA_VFC_VFC_Reboot = null;
/*     */     try {
/* 802 */       PATypes.PA_VFC_VFC_Reboot pA_VFC_VFC_Reboot1 = new PATypes.PA_VFC_VFC_Reboot(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_VFC_Reboot = pA_VFC_VFC_Reboot1;
/* 803 */     } catch (Exception exception) {}
/*     */     
/* 805 */     return pA_VFC_VFC_Reboot;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SceneModePDC getPA_VFC_SceneModePDC() throws CarNotConnectedException {
/* 814 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33531, 1);
/*     */     
/* 816 */     PATypes.PA_VFC_SceneModePDC pA_VFC_SceneModePDC = null;
/*     */     try {
/* 818 */       PATypes.PA_VFC_SceneModePDC pA_VFC_SceneModePDC1 = new PATypes.PA_VFC_SceneModePDC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SceneModePDC = pA_VFC_SceneModePDC1;
/* 819 */     } catch (Exception exception) {}
/*     */     
/* 821 */     return pA_VFC_SceneModePDC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_SetVehSceneMode getPA_VFC_SetVehSceneMode() throws CarNotConnectedException {
/* 830 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33532, 1);
/*     */     
/* 832 */     PATypes.PA_VFC_SetVehSceneMode pA_VFC_SetVehSceneMode = null;
/*     */     try {
/* 834 */       PATypes.PA_VFC_SetVehSceneMode pA_VFC_SetVehSceneMode1 = new PATypes.PA_VFC_SetVehSceneMode(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_SetVehSceneMode = pA_VFC_SetVehSceneMode1;
/* 835 */     } catch (Exception exception) {}
/*     */     
/* 837 */     return pA_VFC_SetVehSceneMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFC_MsgEnd getPA_VFC_MsgEnd() throws CarNotConnectedException {
/* 846 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33917, 1);
/*     */     
/* 848 */     PATypes.PA_VFC_MsgEnd pA_VFC_MsgEnd = null;
/*     */     try {
/* 850 */       PATypes.PA_VFC_MsgEnd pA_VFC_MsgEnd1 = new PATypes.PA_VFC_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFC_MsgEnd = pA_VFC_MsgEnd1;
/* 851 */     } catch (Exception exception) {}
/*     */     
/* 853 */     return pA_VFC_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVfcipwakeupManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */