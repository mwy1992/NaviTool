/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.DemApEventStatus;
/*     */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
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
/*     */ 
/*     */ 
/*     */ public class ECarXCarDtcManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbdem956b87csdlvdssignalmessagefailuresmissingmessage = 33081;
/*     */   public static final int ManagerId_cbdem976e11chatvideosignalinputshorttoground = 33088;
/*     */   public static final int ManagerId_cbdem976e13chatvideosignalinputopen = 33089;
/*     */   public static final int ManagerId_cbdembacklighticfault = 33114;
/*     */   public static final int ManagerId_cbdemcertificatecomponentfailures = 33127;
/*     */   public static final int ManagerId_cbdemcsdfogfault = 33113;
/*     */   public static final int ManagerId_cbdemcsdgeneralelectricalfailurescircuitvoltageoutofrange = 33103;
/*     */   public static final int ManagerId_cbdemcsdlvdsgeneralelectricalfailurescircuitopen = 33102;
/*     */   public static final int ManagerId_cbdemcsdlvdsgeneralelectricalfailurescircuitshorttoground = 33101;
/*     */   public static final int ManagerId_cbdemcsdmbacklighticfault = 33123;
/*     */   public static final int ManagerId_cbdemcsdmbussignalmessagefailuresmissingmessage = 33108;
/*     */   public static final int ManagerId_cbdemcsdmbussignalmessagefailuresvalueofsignalprotectioncalculationincorrect = 33107;
/*     */   public static final int ManagerId_cbdemcsdmfogfault = 33122;
/*     */   public static final int ManagerId_cbdemcsdmgeneralelectricalfailurescircuitvoltageoutofrange = 33105;
/*     */   public static final int ManagerId_cbdemcsdmlcdonoffstate = 33124;
/*     */   public static final int ManagerId_cbdemcsdmsysteminternalfailuresovertemperature = 33106;
/*     */   public static final int ManagerId_cbdemcsdmvideosignallockloss = 33121;
/*     */   public static final int ManagerId_cbdemcsdsysteminternalfailuresovertemperature = 33104;
/*     */   public static final int ManagerId_cbdemcsdvideosignallockloss = 33112;
/*     */   public static final int ManagerId_cbdemd03011dimlvdsbussignalshorttogroundlvds1minus = 33094;
/*     */   public static final int ManagerId_cbdemd03013dimlvdsbussignalopenlvds1minus = 33095;
/*     */   public static final int ManagerId_cbdemd09111pasvideosignalinputshorttoground = 33082;
/*     */   public static final int ManagerId_cbdemd09113pasvideosignalinputopen = 33083;
/*     */   public static final int ManagerId_cbdemd09211dvrvideosignalinputshorttoground = 33084;
/*     */   public static final int ManagerId_cbdemd09213dvrvideosignalinputopen = 33085;
/*     */   public static final int ManagerId_cbdemd09411psdlvdsbussignalshorttogroundlvds1minus = 33090;
/*     */   public static final int ManagerId_cbdemd09413psdlvdsbussignalopenlvds1minus = 33091;
/*     */   public static final int ManagerId_cbdemd09611conslvdsbussignalshorttogroundlvds1plus = 33092;
/*     */   public static final int ManagerId_cbdemd09613conslvdsbussignalopenlvds1plus = 33093;
/*     */   public static final int ManagerId_cbdemef3411gesturevideosignalinputshorttoground = 33086;
/*     */   public static final int ManagerId_cbdemef3413gesturevideosignalinputopen = 33087;
/*     */   public static final int ManagerId_cbdemhdmapinternalfailure = 33126;
/*     */   public static final int ManagerId_cbdemincompatibleipbussignalreceivedfromasdm = 33100;
/*     */   public static final int ManagerId_cbdemincompatibleipbussignalreceivedfromtcam = 33099;
/*     */   public static final int ManagerId_cbdemincompatibleipbussignalreceivedfromvgm = 33116;
/*     */   public static final int ManagerId_cbdemlcdonoffstate = 33115;
/*     */   public static final int ManagerId_cbdemlostudpcommunicationwithasdm = 33098;
/*     */   public static final int ManagerId_cbdemlostudpcommunicationwithtcam = 33097;
/*     */   public static final int ManagerId_cbdemlostudpcommunicationwithvgm = 33096;
/*     */   public static final int ManagerId_cbdempsdbacklighticfault = 33119;
/*     */   public static final int ManagerId_cbdempsdbussignalmessagefailuresmissingmessage = 33111;
/*     */   public static final int ManagerId_cbdempsdfogfault = 33118;
/*     */   public static final int ManagerId_cbdempsdgeneralelectricalfailurescircuitvoltageoutofrange = 33109;
/*     */   public static final int ManagerId_cbdempsdlcdonoffstate = 33120;
/*     */   public static final int ManagerId_cbdempsdsysteminternalfailuresovertemperature = 33110;
/*     */   public static final int ManagerId_cbdempsdvideosignallockloss = 33117;
/*     */   public static final int ManagerId_cbdemsystemfailuredetectedbyhdmap = 33125;
/*     */   private static final String TAG = "ECarXCarDtcManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDtcManager() {}
/*     */   
/*     */   public ECarXCarDtcManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  98 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_956B87_CSDLVDSSignalMessageFailuresMissingmessage(int paramInt) {
/* 108 */     ApiResult apiResult = ApiResult.FAILED;
/* 109 */     if (DemApEventStatus.isValid(paramInt)) {
/* 110 */       apiResult = this.mMgr.setIntProperty(33081, 1, paramInt);
/*     */     } else {
/* 112 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 114 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09111_PASVideoSignalInputShortToGround(int paramInt) {
/* 124 */     ApiResult apiResult = ApiResult.FAILED;
/* 125 */     if (DemApEventStatus.isValid(paramInt)) {
/* 126 */       apiResult = this.mMgr.setIntProperty(33082, 1, paramInt);
/*     */     } else {
/* 128 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 130 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09113_PASVideoSignalInputOpen(int paramInt) {
/* 140 */     ApiResult apiResult = ApiResult.FAILED;
/* 141 */     if (DemApEventStatus.isValid(paramInt)) {
/* 142 */       apiResult = this.mMgr.setIntProperty(33083, 1, paramInt);
/*     */     } else {
/* 144 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 146 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09211_DVRVideoSignalInputShortToGround(int paramInt) {
/* 156 */     ApiResult apiResult = ApiResult.FAILED;
/* 157 */     if (DemApEventStatus.isValid(paramInt)) {
/* 158 */       apiResult = this.mMgr.setIntProperty(33084, 1, paramInt);
/*     */     } else {
/* 160 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 162 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09213_DVRVideoSignalInputOpen(int paramInt) {
/* 172 */     ApiResult apiResult = ApiResult.FAILED;
/* 173 */     if (DemApEventStatus.isValid(paramInt)) {
/* 174 */       apiResult = this.mMgr.setIntProperty(33085, 1, paramInt);
/*     */     } else {
/* 176 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 178 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_EF3411_GestureVideoSignalInputShortToGround(int paramInt) {
/* 188 */     ApiResult apiResult = ApiResult.FAILED;
/* 189 */     if (DemApEventStatus.isValid(paramInt)) {
/* 190 */       apiResult = this.mMgr.setIntProperty(33086, 1, paramInt);
/*     */     } else {
/* 192 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 194 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_EF3413_GestureVideoSignalInputOpen(int paramInt) {
/* 204 */     ApiResult apiResult = ApiResult.FAILED;
/* 205 */     if (DemApEventStatus.isValid(paramInt)) {
/* 206 */       apiResult = this.mMgr.setIntProperty(33087, 1, paramInt);
/*     */     } else {
/* 208 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 210 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_976E11_ChatVideoSignalInputShortToGround(int paramInt) {
/* 220 */     ApiResult apiResult = ApiResult.FAILED;
/* 221 */     if (DemApEventStatus.isValid(paramInt)) {
/* 222 */       apiResult = this.mMgr.setIntProperty(33088, 1, paramInt);
/*     */     } else {
/* 224 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 226 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_976E13_ChatVideoSignalInputOpen(int paramInt) {
/* 236 */     ApiResult apiResult = ApiResult.FAILED;
/* 237 */     if (DemApEventStatus.isValid(paramInt)) {
/* 238 */       apiResult = this.mMgr.setIntProperty(33089, 1, paramInt);
/*     */     } else {
/* 240 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 242 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09411_PSDLVDSBUSSignalShortToGroundLVDS1Minus(int paramInt) {
/* 252 */     ApiResult apiResult = ApiResult.FAILED;
/* 253 */     if (DemApEventStatus.isValid(paramInt)) {
/* 254 */       apiResult = this.mMgr.setIntProperty(33090, 1, paramInt);
/*     */     } else {
/* 256 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 258 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09413_PSDLVDSBUSSignalOpenLVDS1Minus(int paramInt) {
/* 268 */     ApiResult apiResult = ApiResult.FAILED;
/* 269 */     if (DemApEventStatus.isValid(paramInt)) {
/* 270 */       apiResult = this.mMgr.setIntProperty(33091, 1, paramInt);
/*     */     } else {
/* 272 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 274 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09611_CONSLVDSBUSSignalShortToGroundLVDS1Plus(int paramInt) {
/* 284 */     ApiResult apiResult = ApiResult.FAILED;
/* 285 */     if (DemApEventStatus.isValid(paramInt)) {
/* 286 */       apiResult = this.mMgr.setIntProperty(33092, 1, paramInt);
/*     */     } else {
/* 288 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 290 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D09613_CONSLVDSBUSSignalOpenLVDS1Plus(int paramInt) {
/* 300 */     ApiResult apiResult = ApiResult.FAILED;
/* 301 */     if (DemApEventStatus.isValid(paramInt)) {
/* 302 */       apiResult = this.mMgr.setIntProperty(33093, 1, paramInt);
/*     */     } else {
/* 304 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 306 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D03011_DIMLVDSBUSSignalShortToGroundLVDS1Minus(int paramInt) {
/* 316 */     ApiResult apiResult = ApiResult.FAILED;
/* 317 */     if (DemApEventStatus.isValid(paramInt)) {
/* 318 */       apiResult = this.mMgr.setIntProperty(33094, 1, paramInt);
/*     */     } else {
/* 320 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 322 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_D03013_DIMLVDSBUSSignalOpenLVDS1Minus(int paramInt) {
/* 332 */     ApiResult apiResult = ApiResult.FAILED;
/* 333 */     if (DemApEventStatus.isValid(paramInt)) {
/* 334 */       apiResult = this.mMgr.setIntProperty(33095, 1, paramInt);
/*     */     } else {
/* 336 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 338 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_LostUDPCommunicationWithVGM(int paramInt) {
/* 348 */     ApiResult apiResult = ApiResult.FAILED;
/* 349 */     if (DemApEventStatus.isValid(paramInt)) {
/* 350 */       apiResult = this.mMgr.setIntProperty(33096, 1, paramInt);
/*     */     } else {
/* 352 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 354 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_LostUDPCommunicationWithTCAM(int paramInt) {
/* 364 */     ApiResult apiResult = ApiResult.FAILED;
/* 365 */     if (DemApEventStatus.isValid(paramInt)) {
/* 366 */       apiResult = this.mMgr.setIntProperty(33097, 1, paramInt);
/*     */     } else {
/* 368 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 370 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_LostUDPCommunicationWithASDM(int paramInt) {
/* 380 */     ApiResult apiResult = ApiResult.FAILED;
/* 381 */     if (DemApEventStatus.isValid(paramInt)) {
/* 382 */       apiResult = this.mMgr.setIntProperty(33098, 1, paramInt);
/*     */     } else {
/* 384 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 386 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_IncompatibleIPBusSignalReceivedFromTCAM(int paramInt) {
/* 396 */     ApiResult apiResult = ApiResult.FAILED;
/* 397 */     if (DemApEventStatus.isValid(paramInt)) {
/* 398 */       apiResult = this.mMgr.setIntProperty(33099, 1, paramInt);
/*     */     } else {
/* 400 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 402 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_IncompatibleIPBusSignalReceivedFromASDM(int paramInt) {
/* 412 */     ApiResult apiResult = ApiResult.FAILED;
/* 413 */     if (DemApEventStatus.isValid(paramInt)) {
/* 414 */       apiResult = this.mMgr.setIntProperty(33100, 1, paramInt);
/*     */     } else {
/* 416 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 418 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSD_LVDSGeneralElectricalFailuresCircuitshorttoground(int paramInt) {
/* 428 */     ApiResult apiResult = ApiResult.FAILED;
/* 429 */     if (DemApEventStatus.isValid(paramInt)) {
/* 430 */       apiResult = this.mMgr.setIntProperty(33101, 1, paramInt);
/*     */     } else {
/* 432 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 434 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSD_LVDSGeneralElectricalFailuresCircuitopen(int paramInt) {
/* 444 */     ApiResult apiResult = ApiResult.FAILED;
/* 445 */     if (DemApEventStatus.isValid(paramInt)) {
/* 446 */       apiResult = this.mMgr.setIntProperty(33102, 1, paramInt);
/*     */     } else {
/* 448 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 450 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSD_GeneralElectricalFailuresCircuitvoltageoutofrange(int paramInt) {
/* 460 */     ApiResult apiResult = ApiResult.FAILED;
/* 461 */     if (DemApEventStatus.isValid(paramInt)) {
/* 462 */       apiResult = this.mMgr.setIntProperty(33103, 1, paramInt);
/*     */     } else {
/* 464 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 466 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSD_SystemInternalFailuresOvertemperature(int paramInt) {
/* 476 */     ApiResult apiResult = ApiResult.FAILED;
/* 477 */     if (DemApEventStatus.isValid(paramInt)) {
/* 478 */       apiResult = this.mMgr.setIntProperty(33104, 1, paramInt);
/*     */     } else {
/* 480 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 482 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_GeneralElectricalFailuresCircuitvoltageoutofrange(int paramInt) {
/* 492 */     ApiResult apiResult = ApiResult.FAILED;
/* 493 */     if (DemApEventStatus.isValid(paramInt)) {
/* 494 */       apiResult = this.mMgr.setIntProperty(33105, 1, paramInt);
/*     */     } else {
/* 496 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 498 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_SystemInternalFailuresOvertemperature(int paramInt) {
/* 508 */     ApiResult apiResult = ApiResult.FAILED;
/* 509 */     if (DemApEventStatus.isValid(paramInt)) {
/* 510 */       apiResult = this.mMgr.setIntProperty(33106, 1, paramInt);
/*     */     } else {
/* 512 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 514 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_BusSignalMessageFailuresValueofsignalprotectioncalculationincorrect(int paramInt) {
/* 524 */     ApiResult apiResult = ApiResult.FAILED;
/* 525 */     if (DemApEventStatus.isValid(paramInt)) {
/* 526 */       apiResult = this.mMgr.setIntProperty(33107, 1, paramInt);
/*     */     } else {
/* 528 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 530 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_BusSignalMessageFailuresMissingmessage(int paramInt) {
/* 540 */     ApiResult apiResult = ApiResult.FAILED;
/* 541 */     if (DemApEventStatus.isValid(paramInt)) {
/* 542 */       apiResult = this.mMgr.setIntProperty(33108, 1, paramInt);
/*     */     } else {
/* 544 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 546 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_PSD_GeneralElectricalFailuresCircuitvoltageoutofrange(int paramInt) {
/* 556 */     ApiResult apiResult = ApiResult.FAILED;
/* 557 */     if (DemApEventStatus.isValid(paramInt)) {
/* 558 */       apiResult = this.mMgr.setIntProperty(33109, 1, paramInt);
/*     */     } else {
/* 560 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 562 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_PSD_SystemInternalFailuresOvertemperature(int paramInt) {
/* 572 */     ApiResult apiResult = ApiResult.FAILED;
/* 573 */     if (DemApEventStatus.isValid(paramInt)) {
/* 574 */       apiResult = this.mMgr.setIntProperty(33110, 1, paramInt);
/*     */     } else {
/* 576 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 578 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_PSD_BusSignalMessageFailuresMissingmessage(int paramInt) {
/* 588 */     ApiResult apiResult = ApiResult.FAILED;
/* 589 */     if (DemApEventStatus.isValid(paramInt)) {
/* 590 */       apiResult = this.mMgr.setIntProperty(33111, 1, paramInt);
/*     */     } else {
/* 592 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 594 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSD_VideoSignalLockLoss(int paramInt) {
/* 604 */     ApiResult apiResult = ApiResult.FAILED;
/* 605 */     if (DemApEventStatus.isValid(paramInt)) {
/* 606 */       apiResult = this.mMgr.setIntProperty(33112, 1, paramInt);
/*     */     } else {
/* 608 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 610 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSD_FOGFault(int paramInt) {
/* 620 */     ApiResult apiResult = ApiResult.FAILED;
/* 621 */     if (DemApEventStatus.isValid(paramInt)) {
/* 622 */       apiResult = this.mMgr.setIntProperty(33113, 1, paramInt);
/*     */     } else {
/* 624 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 626 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_BacklightICFault(int paramInt) {
/* 636 */     ApiResult apiResult = ApiResult.FAILED;
/* 637 */     if (DemApEventStatus.isValid(paramInt)) {
/* 638 */       apiResult = this.mMgr.setIntProperty(33114, 1, paramInt);
/*     */     } else {
/* 640 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 642 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_LCD_ON_OFFstate(int paramInt) {
/* 652 */     ApiResult apiResult = ApiResult.FAILED;
/* 653 */     if (DemApEventStatus.isValid(paramInt)) {
/* 654 */       apiResult = this.mMgr.setIntProperty(33115, 1, paramInt);
/*     */     } else {
/* 656 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 658 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_IncompatibleIPbussignalreceivedfromVGM(int paramInt) {
/* 668 */     ApiResult apiResult = ApiResult.FAILED;
/* 669 */     if (DemApEventStatus.isValid(paramInt)) {
/* 670 */       apiResult = this.mMgr.setIntProperty(33116, 1, paramInt);
/*     */     } else {
/* 672 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 674 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_PSD_VideoSignalLockLoss(int paramInt) {
/* 684 */     ApiResult apiResult = ApiResult.FAILED;
/* 685 */     if (DemApEventStatus.isValid(paramInt)) {
/* 686 */       apiResult = this.mMgr.setIntProperty(33117, 1, paramInt);
/*     */     } else {
/* 688 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 690 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_PSD_FOGFault(int paramInt) {
/* 700 */     ApiResult apiResult = ApiResult.FAILED;
/* 701 */     if (DemApEventStatus.isValid(paramInt)) {
/* 702 */       apiResult = this.mMgr.setIntProperty(33118, 1, paramInt);
/*     */     } else {
/* 704 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 706 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_PSD_BacklightICFault(int paramInt) {
/* 716 */     ApiResult apiResult = ApiResult.FAILED;
/* 717 */     if (DemApEventStatus.isValid(paramInt)) {
/* 718 */       apiResult = this.mMgr.setIntProperty(33119, 1, paramInt);
/*     */     } else {
/* 720 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 722 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_PSD_LCD_ON_OFFstate(int paramInt) {
/* 732 */     ApiResult apiResult = ApiResult.FAILED;
/* 733 */     if (DemApEventStatus.isValid(paramInt)) {
/* 734 */       apiResult = this.mMgr.setIntProperty(33120, 1, paramInt);
/*     */     } else {
/* 736 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 738 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_VideoSignalLockLoss(int paramInt) {
/* 748 */     ApiResult apiResult = ApiResult.FAILED;
/* 749 */     if (DemApEventStatus.isValid(paramInt)) {
/* 750 */       apiResult = this.mMgr.setIntProperty(33121, 1, paramInt);
/*     */     } else {
/* 752 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 754 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_FOGFault(int paramInt) {
/* 764 */     ApiResult apiResult = ApiResult.FAILED;
/* 765 */     if (DemApEventStatus.isValid(paramInt)) {
/* 766 */       apiResult = this.mMgr.setIntProperty(33122, 1, paramInt);
/*     */     } else {
/* 768 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 770 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_BacklightICFault(int paramInt) {
/* 780 */     ApiResult apiResult = ApiResult.FAILED;
/* 781 */     if (DemApEventStatus.isValid(paramInt)) {
/* 782 */       apiResult = this.mMgr.setIntProperty(33123, 1, paramInt);
/*     */     } else {
/* 784 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 786 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_CSDM_LCD_ON_OFF_state(int paramInt) {
/* 796 */     ApiResult apiResult = ApiResult.FAILED;
/* 797 */     if (DemApEventStatus.isValid(paramInt)) {
/* 798 */       apiResult = this.mMgr.setIntProperty(33124, 1, paramInt);
/*     */     } else {
/* 800 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 802 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_System_Failure_Detected_by_HDMap(int paramInt) {
/* 812 */     ApiResult apiResult = ApiResult.FAILED;
/* 813 */     if (DemApEventStatus.isValid(paramInt)) {
/* 814 */       apiResult = this.mMgr.setIntProperty(33125, 1, paramInt);
/*     */     } else {
/* 816 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 818 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_HD_Map_Internal_Failure(int paramInt) {
/* 828 */     ApiResult apiResult = ApiResult.FAILED;
/* 829 */     if (DemApEventStatus.isValid(paramInt)) {
/* 830 */       apiResult = this.mMgr.setIntProperty(33126, 1, paramInt);
/*     */     } else {
/* 832 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 834 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dem_Certificate_Component_Failures(int paramInt) {
/* 844 */     ApiResult apiResult = ApiResult.FAILED;
/* 845 */     if (DemApEventStatus.isValid(paramInt)) {
/* 846 */       apiResult = this.mMgr.setIntProperty(33127, 1, paramInt);
/*     */     } else {
/* 848 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 850 */     return apiResult;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDtcManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */