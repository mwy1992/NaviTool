/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.BookChargeSetResponse;
/*     */ import ecarx.car.hardware.annotation.HmiFragraLvlReq;
/*     */ import ecarx.car.hardware.annotation.HmiFrangraModReq;
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
/*     */ public class ECarXCarAirqlyandfragraManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbairqlyandfragrareboot = 32874;
/*     */   public static final int ManagerId_cbfragrafragrefrshautsetg = 32873;
/*     */   public static final int ManagerId_cbfragralvlreq = 32869;
/*     */   public static final int ManagerId_cbfragramodreq = 32870;
/*     */   public static final int ManagerId_cbfragrasceneset = 32871;
/*     */   public static final int ManagerId_cbfragratypratreqa = 32863;
/*     */   public static final int ManagerId_cbfragratypratreqb = 32864;
/*     */   public static final int ManagerId_cbfragratypratreqc = 32865;
/*     */   public static final int ManagerId_cbfragratypratreqd = 32866;
/*     */   public static final int ManagerId_cbfragratypratreqe = 32867;
/*     */   public static final int ManagerId_cbfragratypratreqf = 32868;
/*     */   public static final int ManagerId_cbpm25hmipopupresp = 32862;
/*     */   public static final int ManagerId_cbpm25incomingairqlypopupreq = 32872;
/*     */   public static final int ManagerId_pafragraactn = 33406;
/*     */   public static final int ManagerId_pafragraairfragch1runngsts = 33428;
/*     */   public static final int ManagerId_pafragraairfragch2runngsts = 33429;
/*     */   public static final int ManagerId_pafragraairfragch3runngsts = 33430;
/*     */   public static final int ManagerId_pafragraairfragch4runngsts = 33431;
/*     */   public static final int ManagerId_pafragraairfragch5runngsts = 33432;
/*     */   public static final int ManagerId_pafragrafragrefrshautsetg = 33433;
/*     */   public static final int ManagerId_pafragralvlreqsts = 33413;
/*     */   public static final int ManagerId_pafragramodreqsts = 33414;
/*     */   public static final int ManagerId_pafragramsgend = 33910;
/*     */   public static final int ManagerId_pafragrarefrshreq = 33417;
/*     */   public static final int ManagerId_pafragrascenesetsts = 33415;
/*     */   public static final int ManagerId_pafragrasts = 33416;
/*     */   public static final int ManagerId_pafragratast1useuprmd = 33423;
/*     */   public static final int ManagerId_pafragratast2useuprmd = 33424;
/*     */   public static final int ManagerId_pafragratast3useuprmd = 33425;
/*     */   public static final int ManagerId_pafragratast4useuprmd = 33426;
/*     */   public static final int ManagerId_pafragratast5useuprmd = 33427;
/*     */   public static final int ManagerId_pafragrataste1id = 33418;
/*     */   public static final int ManagerId_pafragrataste2id = 33419;
/*     */   public static final int ManagerId_pafragrataste3id = 33420;
/*     */   public static final int ManagerId_pafragrataste4id = 33421;
/*     */   public static final int ManagerId_pafragrataste5id = 33422;
/*     */   public static final int ManagerId_pafragratypratreqasts = 33407;
/*     */   public static final int ManagerId_pafragratypratreqbsts = 33408;
/*     */   public static final int ManagerId_pafragratypratreqcsts = 33409;
/*     */   public static final int ManagerId_pafragratypratreqdsts = 33410;
/*     */   public static final int ManagerId_pafragratypratreqests = 33411;
/*     */   public static final int ManagerId_pafragratypratreqfsts = 33412;
/*     */   public static final int ManagerId_paiaqcactnsts = 33396;
/*     */   public static final int ManagerId_papm25actvn = 33397;
/*     */   public static final int ManagerId_papm25incomingairqlypopupreq = 33405;
/*     */   public static final int ManagerId_papm25intpm25lvl = 33400;
/*     */   public static final int ManagerId_papm25intpm25sts = 33403;
/*     */   public static final int ManagerId_papm25intpm25vlu = 33398;
/*     */   public static final int ManagerId_papm25intrpm25hiwarn = 33402;
/*     */   public static final int ManagerId_papm25outdpm25lvl = 33401;
/*     */   public static final int ManagerId_papm25outdpm25sts = 33404;
/*     */   public static final int ManagerId_papm25outdpm25vlu = 33399;
/*     */   private static final String TAG = "ECarXCarAirqlyandfragraManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarAirqlyandfragraManager() {}
/*     */   
/*     */   public ECarXCarAirqlyandfragraManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 106 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
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
/*     */   public ApiResult CB_PM25_HmiPopUpResp(int paramInt) {
/* 119 */     ApiResult apiResult = ApiResult.FAILED;
/* 120 */     if (BookChargeSetResponse.isValid(paramInt)) {
/* 121 */       apiResult = this.mMgr.setIntProperty(32862, 1, paramInt);
/*     */     } else {
/* 123 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 125 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_TypRatReqA(int paramInt) {
/* 135 */     return this.mMgr.setIntProperty(32863, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_TypRatReqB(int paramInt) {
/* 145 */     return this.mMgr.setIntProperty(32864, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_TypRatReqC(int paramInt) {
/* 155 */     return this.mMgr.setIntProperty(32865, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_TypRatReqD(int paramInt) {
/* 165 */     return this.mMgr.setIntProperty(32866, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_TypRatReqE(int paramInt) {
/* 175 */     return this.mMgr.setIntProperty(32867, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_TypRatReqF(int paramInt) {
/* 185 */     return this.mMgr.setIntProperty(32868, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_LvlReq(int paramInt) {
/* 195 */     ApiResult apiResult = ApiResult.FAILED;
/* 196 */     if (HmiFragraLvlReq.isValid(paramInt)) {
/* 197 */       apiResult = this.mMgr.setIntProperty(32869, 1, paramInt);
/*     */     } else {
/* 199 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 201 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_ModReq(int paramInt) {
/* 211 */     ApiResult apiResult = ApiResult.FAILED;
/* 212 */     if (HmiFrangraModReq.isValid(paramInt)) {
/* 213 */       apiResult = this.mMgr.setIntProperty(32870, 1, paramInt);
/*     */     } else {
/* 215 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 217 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_SceneSet(int paramInt) {
/* 227 */     return this.mMgr.setIntProperty(32871, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PM25_IncomingAirQlyPopUpReq(int paramInt) {
/* 237 */     ApiResult apiResult = ApiResult.FAILED;
/* 238 */     if (OnOff1.isValid(paramInt)) {
/* 239 */       apiResult = this.mMgr.setIntProperty(32872, 1, paramInt);
/*     */     } else {
/* 241 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 243 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Fragra_FragRefrshAutSetg(int paramInt) {
/* 253 */     ApiResult apiResult = ApiResult.FAILED;
/* 254 */     if (OnOff1.isValid(paramInt)) {
/* 255 */       apiResult = this.mMgr.setIntProperty(32873, 1, paramInt);
/*     */     } else {
/* 257 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 259 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AirQlyAndFragra_Reboot(int paramInt) {
/* 269 */     return this.mMgr.setIntProperty(32874, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_IAQC_ActnSts getPA_IAQC_ActnSts() throws CarNotConnectedException {
/* 280 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33396, 1);
/*     */     
/* 282 */     PATypes.PA_IAQC_ActnSts pA_IAQC_ActnSts = null;
/*     */     try {
/* 284 */       PATypes.PA_IAQC_ActnSts pA_IAQC_ActnSts1 = new PATypes.PA_IAQC_ActnSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_IAQC_ActnSts = pA_IAQC_ActnSts1;
/* 285 */     } catch (Exception exception) {}
/*     */     
/* 287 */     return pA_IAQC_ActnSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_Actvn getPA_PM25_Actvn() throws CarNotConnectedException {
/* 296 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33397, 1);
/*     */     
/* 298 */     PATypes.PA_PM25_Actvn pA_PM25_Actvn = null;
/*     */     try {
/* 300 */       PATypes.PA_PM25_Actvn pA_PM25_Actvn1 = new PATypes.PA_PM25_Actvn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_Actvn = pA_PM25_Actvn1;
/* 301 */     } catch (Exception exception) {}
/*     */     
/* 303 */     return pA_PM25_Actvn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_IntPm25Vlu getPA_PM25_IntPm25Vlu() throws CarNotConnectedException {
/* 312 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33398, 1);
/*     */     
/* 314 */     PATypes.PA_PM25_IntPm25Vlu pA_PM25_IntPm25Vlu = null;
/*     */     try {
/* 316 */       PATypes.PA_PM25_IntPm25Vlu pA_PM25_IntPm25Vlu1 = new PATypes.PA_PM25_IntPm25Vlu(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_IntPm25Vlu = pA_PM25_IntPm25Vlu1;
/* 317 */     } catch (Exception exception) {}
/*     */     
/* 319 */     return pA_PM25_IntPm25Vlu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_OutdPm25Vlu getPA_PM25_OutdPm25Vlu() throws CarNotConnectedException {
/* 328 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33399, 1);
/*     */     
/* 330 */     PATypes.PA_PM25_OutdPm25Vlu pA_PM25_OutdPm25Vlu = null;
/*     */     try {
/* 332 */       PATypes.PA_PM25_OutdPm25Vlu pA_PM25_OutdPm25Vlu1 = new PATypes.PA_PM25_OutdPm25Vlu(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_OutdPm25Vlu = pA_PM25_OutdPm25Vlu1;
/* 333 */     } catch (Exception exception) {}
/*     */     
/* 335 */     return pA_PM25_OutdPm25Vlu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_IntPm25Lvl getPA_PM25_IntPm25Lvl() throws CarNotConnectedException {
/* 344 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33400, 1);
/*     */     
/* 346 */     PATypes.PA_PM25_IntPm25Lvl pA_PM25_IntPm25Lvl = null;
/*     */     try {
/* 348 */       PATypes.PA_PM25_IntPm25Lvl pA_PM25_IntPm25Lvl1 = new PATypes.PA_PM25_IntPm25Lvl(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_IntPm25Lvl = pA_PM25_IntPm25Lvl1;
/* 349 */     } catch (Exception exception) {}
/*     */     
/* 351 */     return pA_PM25_IntPm25Lvl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_OutdPm25Lvl getPA_PM25_OutdPm25Lvl() throws CarNotConnectedException {
/* 360 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33401, 1);
/*     */     
/* 362 */     PATypes.PA_PM25_OutdPm25Lvl pA_PM25_OutdPm25Lvl = null;
/*     */     try {
/* 364 */       PATypes.PA_PM25_OutdPm25Lvl pA_PM25_OutdPm25Lvl1 = new PATypes.PA_PM25_OutdPm25Lvl(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_OutdPm25Lvl = pA_PM25_OutdPm25Lvl1;
/* 365 */     } catch (Exception exception) {}
/*     */     
/* 367 */     return pA_PM25_OutdPm25Lvl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_IntrPm25HiWarn getPA_PM25_IntrPm25HiWarn() throws CarNotConnectedException {
/* 376 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33402, 1);
/*     */     
/* 378 */     PATypes.PA_PM25_IntrPm25HiWarn pA_PM25_IntrPm25HiWarn = null;
/*     */     try {
/* 380 */       PATypes.PA_PM25_IntrPm25HiWarn pA_PM25_IntrPm25HiWarn1 = new PATypes.PA_PM25_IntrPm25HiWarn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_IntrPm25HiWarn = pA_PM25_IntrPm25HiWarn1;
/* 381 */     } catch (Exception exception) {}
/*     */     
/* 383 */     return pA_PM25_IntrPm25HiWarn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_IntPm25Sts getPA_PM25_IntPm25Sts() throws CarNotConnectedException {
/* 392 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33403, 1);
/*     */     
/* 394 */     PATypes.PA_PM25_IntPm25Sts pA_PM25_IntPm25Sts = null;
/*     */     try {
/* 396 */       PATypes.PA_PM25_IntPm25Sts pA_PM25_IntPm25Sts1 = new PATypes.PA_PM25_IntPm25Sts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_IntPm25Sts = pA_PM25_IntPm25Sts1;
/* 397 */     } catch (Exception exception) {}
/*     */     
/* 399 */     return pA_PM25_IntPm25Sts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_OutdPm25Sts getPA_PM25_OutdPm25Sts() throws CarNotConnectedException {
/* 408 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33404, 1);
/*     */     
/* 410 */     PATypes.PA_PM25_OutdPm25Sts pA_PM25_OutdPm25Sts = null;
/*     */     try {
/* 412 */       PATypes.PA_PM25_OutdPm25Sts pA_PM25_OutdPm25Sts1 = new PATypes.PA_PM25_OutdPm25Sts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_OutdPm25Sts = pA_PM25_OutdPm25Sts1;
/* 413 */     } catch (Exception exception) {}
/*     */     
/* 415 */     return pA_PM25_OutdPm25Sts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PM25_IncomingAirQlyPopUpReq getPA_PM25_IncomingAirQlyPopUpReq() throws CarNotConnectedException {
/* 424 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33405, 1);
/*     */     
/* 426 */     PATypes.PA_PM25_IncomingAirQlyPopUpReq pA_PM25_IncomingAirQlyPopUpReq = null;
/*     */     try {
/* 428 */       PATypes.PA_PM25_IncomingAirQlyPopUpReq pA_PM25_IncomingAirQlyPopUpReq1 = new PATypes.PA_PM25_IncomingAirQlyPopUpReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PM25_IncomingAirQlyPopUpReq = pA_PM25_IncomingAirQlyPopUpReq1;
/* 429 */     } catch (Exception exception) {}
/*     */     
/* 431 */     return pA_PM25_IncomingAirQlyPopUpReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Actn getPA_Fragra_Actn() throws CarNotConnectedException {
/* 440 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33406, 1);
/*     */     
/* 442 */     PATypes.PA_Fragra_Actn pA_Fragra_Actn = null;
/*     */     try {
/* 444 */       PATypes.PA_Fragra_Actn pA_Fragra_Actn1 = new PATypes.PA_Fragra_Actn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Actn = pA_Fragra_Actn1;
/* 445 */     } catch (Exception exception) {}
/*     */     
/* 447 */     return pA_Fragra_Actn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_TypRatReqASts getPA_Fragra_TypRatReqASts() throws CarNotConnectedException {
/* 456 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33407, 1);
/*     */     
/* 458 */     PATypes.PA_Fragra_TypRatReqASts pA_Fragra_TypRatReqASts = null;
/*     */     try {
/* 460 */       PATypes.PA_Fragra_TypRatReqASts pA_Fragra_TypRatReqASts1 = new PATypes.PA_Fragra_TypRatReqASts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_TypRatReqASts = pA_Fragra_TypRatReqASts1;
/* 461 */     } catch (Exception exception) {}
/*     */     
/* 463 */     return pA_Fragra_TypRatReqASts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_TypRatReqBSts getPA_Fragra_TypRatReqBSts() throws CarNotConnectedException {
/* 472 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33408, 1);
/*     */     
/* 474 */     PATypes.PA_Fragra_TypRatReqBSts pA_Fragra_TypRatReqBSts = null;
/*     */     try {
/* 476 */       PATypes.PA_Fragra_TypRatReqBSts pA_Fragra_TypRatReqBSts1 = new PATypes.PA_Fragra_TypRatReqBSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_TypRatReqBSts = pA_Fragra_TypRatReqBSts1;
/* 477 */     } catch (Exception exception) {}
/*     */     
/* 479 */     return pA_Fragra_TypRatReqBSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_TypRatReqCSts getPA_Fragra_TypRatReqCSts() throws CarNotConnectedException {
/* 488 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33409, 1);
/*     */     
/* 490 */     PATypes.PA_Fragra_TypRatReqCSts pA_Fragra_TypRatReqCSts = null;
/*     */     try {
/* 492 */       PATypes.PA_Fragra_TypRatReqCSts pA_Fragra_TypRatReqCSts1 = new PATypes.PA_Fragra_TypRatReqCSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_TypRatReqCSts = pA_Fragra_TypRatReqCSts1;
/* 493 */     } catch (Exception exception) {}
/*     */     
/* 495 */     return pA_Fragra_TypRatReqCSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_TypRatReqDSts getPA_Fragra_TypRatReqDSts() throws CarNotConnectedException {
/* 504 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33410, 1);
/*     */     
/* 506 */     PATypes.PA_Fragra_TypRatReqDSts pA_Fragra_TypRatReqDSts = null;
/*     */     try {
/* 508 */       PATypes.PA_Fragra_TypRatReqDSts pA_Fragra_TypRatReqDSts1 = new PATypes.PA_Fragra_TypRatReqDSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_TypRatReqDSts = pA_Fragra_TypRatReqDSts1;
/* 509 */     } catch (Exception exception) {}
/*     */     
/* 511 */     return pA_Fragra_TypRatReqDSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_TypRatReqESts getPA_Fragra_TypRatReqESts() throws CarNotConnectedException {
/* 520 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33411, 1);
/*     */     
/* 522 */     PATypes.PA_Fragra_TypRatReqESts pA_Fragra_TypRatReqESts = null;
/*     */     try {
/* 524 */       PATypes.PA_Fragra_TypRatReqESts pA_Fragra_TypRatReqESts1 = new PATypes.PA_Fragra_TypRatReqESts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_TypRatReqESts = pA_Fragra_TypRatReqESts1;
/* 525 */     } catch (Exception exception) {}
/*     */     
/* 527 */     return pA_Fragra_TypRatReqESts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_TypRatReqFSts getPA_Fragra_TypRatReqFSts() throws CarNotConnectedException {
/* 536 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33412, 1);
/*     */     
/* 538 */     PATypes.PA_Fragra_TypRatReqFSts pA_Fragra_TypRatReqFSts = null;
/*     */     try {
/* 540 */       PATypes.PA_Fragra_TypRatReqFSts pA_Fragra_TypRatReqFSts1 = new PATypes.PA_Fragra_TypRatReqFSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_TypRatReqFSts = pA_Fragra_TypRatReqFSts1;
/* 541 */     } catch (Exception exception) {}
/*     */     
/* 543 */     return pA_Fragra_TypRatReqFSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_LvlReqSts getPA_Fragra_LvlReqSts() throws CarNotConnectedException {
/* 552 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33413, 1);
/*     */     
/* 554 */     PATypes.PA_Fragra_LvlReqSts pA_Fragra_LvlReqSts = null;
/*     */     try {
/* 556 */       PATypes.PA_Fragra_LvlReqSts pA_Fragra_LvlReqSts1 = new PATypes.PA_Fragra_LvlReqSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_LvlReqSts = pA_Fragra_LvlReqSts1;
/* 557 */     } catch (Exception exception) {}
/*     */     
/* 559 */     return pA_Fragra_LvlReqSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_ModReqSts getPA_Fragra_ModReqSts() throws CarNotConnectedException {
/* 568 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33414, 1);
/*     */     
/* 570 */     PATypes.PA_Fragra_ModReqSts pA_Fragra_ModReqSts = null;
/*     */     try {
/* 572 */       PATypes.PA_Fragra_ModReqSts pA_Fragra_ModReqSts1 = new PATypes.PA_Fragra_ModReqSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_ModReqSts = pA_Fragra_ModReqSts1;
/* 573 */     } catch (Exception exception) {}
/*     */     
/* 575 */     return pA_Fragra_ModReqSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_SceneSetSts getPA_Fragra_SceneSetSts() throws CarNotConnectedException {
/* 584 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33415, 1);
/*     */     
/* 586 */     PATypes.PA_Fragra_SceneSetSts pA_Fragra_SceneSetSts = null;
/*     */     try {
/* 588 */       PATypes.PA_Fragra_SceneSetSts pA_Fragra_SceneSetSts1 = new PATypes.PA_Fragra_SceneSetSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_SceneSetSts = pA_Fragra_SceneSetSts1;
/* 589 */     } catch (Exception exception) {}
/*     */     
/* 591 */     return pA_Fragra_SceneSetSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Sts getPA_Fragra_Sts() throws CarNotConnectedException {
/* 600 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33416, 1);
/*     */     
/* 602 */     PATypes.PA_Fragra_Sts pA_Fragra_Sts = null;
/*     */     try {
/* 604 */       PATypes.PA_Fragra_Sts pA_Fragra_Sts1 = new PATypes.PA_Fragra_Sts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Sts = pA_Fragra_Sts1;
/* 605 */     } catch (Exception exception) {}
/*     */     
/* 607 */     return pA_Fragra_Sts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_RefrshReq getPA_Fragra_RefrshReq() throws CarNotConnectedException {
/* 616 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33417, 1);
/*     */     
/* 618 */     PATypes.PA_Fragra_RefrshReq pA_Fragra_RefrshReq = null;
/*     */     try {
/* 620 */       PATypes.PA_Fragra_RefrshReq pA_Fragra_RefrshReq1 = new PATypes.PA_Fragra_RefrshReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_RefrshReq = pA_Fragra_RefrshReq1;
/* 621 */     } catch (Exception exception) {}
/*     */     
/* 623 */     return pA_Fragra_RefrshReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Taste1ID getPA_Fragra_Taste1ID() throws CarNotConnectedException {
/* 632 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33418, 1);
/*     */     
/* 634 */     PATypes.PA_Fragra_Taste1ID pA_Fragra_Taste1ID = null;
/*     */     try {
/* 636 */       PATypes.PA_Fragra_Taste1ID pA_Fragra_Taste1ID1 = new PATypes.PA_Fragra_Taste1ID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Taste1ID = pA_Fragra_Taste1ID1;
/* 637 */     } catch (Exception exception) {}
/*     */     
/* 639 */     return pA_Fragra_Taste1ID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Taste2ID getPA_Fragra_Taste2ID() throws CarNotConnectedException {
/* 648 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33419, 1);
/*     */     
/* 650 */     PATypes.PA_Fragra_Taste2ID pA_Fragra_Taste2ID = null;
/*     */     try {
/* 652 */       PATypes.PA_Fragra_Taste2ID pA_Fragra_Taste2ID1 = new PATypes.PA_Fragra_Taste2ID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Taste2ID = pA_Fragra_Taste2ID1;
/* 653 */     } catch (Exception exception) {}
/*     */     
/* 655 */     return pA_Fragra_Taste2ID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Taste3ID getPA_Fragra_Taste3ID() throws CarNotConnectedException {
/* 664 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33420, 1);
/*     */     
/* 666 */     PATypes.PA_Fragra_Taste3ID pA_Fragra_Taste3ID = null;
/*     */     try {
/* 668 */       PATypes.PA_Fragra_Taste3ID pA_Fragra_Taste3ID1 = new PATypes.PA_Fragra_Taste3ID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Taste3ID = pA_Fragra_Taste3ID1;
/* 669 */     } catch (Exception exception) {}
/*     */     
/* 671 */     return pA_Fragra_Taste3ID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Taste4ID getPA_Fragra_Taste4ID() throws CarNotConnectedException {
/* 680 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33421, 1);
/*     */     
/* 682 */     PATypes.PA_Fragra_Taste4ID pA_Fragra_Taste4ID = null;
/*     */     try {
/* 684 */       PATypes.PA_Fragra_Taste4ID pA_Fragra_Taste4ID1 = new PATypes.PA_Fragra_Taste4ID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Taste4ID = pA_Fragra_Taste4ID1;
/* 685 */     } catch (Exception exception) {}
/*     */     
/* 687 */     return pA_Fragra_Taste4ID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Taste5ID getPA_Fragra_Taste5ID() throws CarNotConnectedException {
/* 696 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33422, 1);
/*     */     
/* 698 */     PATypes.PA_Fragra_Taste5ID pA_Fragra_Taste5ID = null;
/*     */     try {
/* 700 */       PATypes.PA_Fragra_Taste5ID pA_Fragra_Taste5ID1 = new PATypes.PA_Fragra_Taste5ID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Taste5ID = pA_Fragra_Taste5ID1;
/* 701 */     } catch (Exception exception) {}
/*     */     
/* 703 */     return pA_Fragra_Taste5ID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Tast1UseUpRmd getPA_Fragra_Tast1UseUpRmd() throws CarNotConnectedException {
/* 712 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33423, 1);
/*     */     
/* 714 */     PATypes.PA_Fragra_Tast1UseUpRmd pA_Fragra_Tast1UseUpRmd = null;
/*     */     try {
/* 716 */       PATypes.PA_Fragra_Tast1UseUpRmd pA_Fragra_Tast1UseUpRmd1 = new PATypes.PA_Fragra_Tast1UseUpRmd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Tast1UseUpRmd = pA_Fragra_Tast1UseUpRmd1;
/* 717 */     } catch (Exception exception) {}
/*     */     
/* 719 */     return pA_Fragra_Tast1UseUpRmd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Tast2UseUpRmd getPA_Fragra_Tast2UseUpRmd() throws CarNotConnectedException {
/* 728 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33424, 1);
/*     */     
/* 730 */     PATypes.PA_Fragra_Tast2UseUpRmd pA_Fragra_Tast2UseUpRmd = null;
/*     */     try {
/* 732 */       PATypes.PA_Fragra_Tast2UseUpRmd pA_Fragra_Tast2UseUpRmd1 = new PATypes.PA_Fragra_Tast2UseUpRmd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Tast2UseUpRmd = pA_Fragra_Tast2UseUpRmd1;
/* 733 */     } catch (Exception exception) {}
/*     */     
/* 735 */     return pA_Fragra_Tast2UseUpRmd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Tast3UseUpRmd getPA_Fragra_Tast3UseUpRmd() throws CarNotConnectedException {
/* 744 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33425, 1);
/*     */     
/* 746 */     PATypes.PA_Fragra_Tast3UseUpRmd pA_Fragra_Tast3UseUpRmd = null;
/*     */     try {
/* 748 */       PATypes.PA_Fragra_Tast3UseUpRmd pA_Fragra_Tast3UseUpRmd1 = new PATypes.PA_Fragra_Tast3UseUpRmd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Tast3UseUpRmd = pA_Fragra_Tast3UseUpRmd1;
/* 749 */     } catch (Exception exception) {}
/*     */     
/* 751 */     return pA_Fragra_Tast3UseUpRmd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Tast4UseUpRmd getPA_Fragra_Tast4UseUpRmd() throws CarNotConnectedException {
/* 760 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33426, 1);
/*     */     
/* 762 */     PATypes.PA_Fragra_Tast4UseUpRmd pA_Fragra_Tast4UseUpRmd = null;
/*     */     try {
/* 764 */       PATypes.PA_Fragra_Tast4UseUpRmd pA_Fragra_Tast4UseUpRmd1 = new PATypes.PA_Fragra_Tast4UseUpRmd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Tast4UseUpRmd = pA_Fragra_Tast4UseUpRmd1;
/* 765 */     } catch (Exception exception) {}
/*     */     
/* 767 */     return pA_Fragra_Tast4UseUpRmd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_Tast5UseUpRmd getPA_Fragra_Tast5UseUpRmd() throws CarNotConnectedException {
/* 776 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33427, 1);
/*     */     
/* 778 */     PATypes.PA_Fragra_Tast5UseUpRmd pA_Fragra_Tast5UseUpRmd = null;
/*     */     try {
/* 780 */       PATypes.PA_Fragra_Tast5UseUpRmd pA_Fragra_Tast5UseUpRmd1 = new PATypes.PA_Fragra_Tast5UseUpRmd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_Tast5UseUpRmd = pA_Fragra_Tast5UseUpRmd1;
/* 781 */     } catch (Exception exception) {}
/*     */     
/* 783 */     return pA_Fragra_Tast5UseUpRmd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_AirFragCh1RunngSts getPA_Fragra_AirFragCh1RunngSts() throws CarNotConnectedException {
/* 792 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33428, 1);
/*     */     
/* 794 */     PATypes.PA_Fragra_AirFragCh1RunngSts pA_Fragra_AirFragCh1RunngSts = null;
/*     */     try {
/* 796 */       PATypes.PA_Fragra_AirFragCh1RunngSts pA_Fragra_AirFragCh1RunngSts1 = new PATypes.PA_Fragra_AirFragCh1RunngSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_AirFragCh1RunngSts = pA_Fragra_AirFragCh1RunngSts1;
/* 797 */     } catch (Exception exception) {}
/*     */     
/* 799 */     return pA_Fragra_AirFragCh1RunngSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_AirFragCh2RunngSts getPA_Fragra_AirFragCh2RunngSts() throws CarNotConnectedException {
/* 808 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33429, 1);
/*     */     
/* 810 */     PATypes.PA_Fragra_AirFragCh2RunngSts pA_Fragra_AirFragCh2RunngSts = null;
/*     */     try {
/* 812 */       PATypes.PA_Fragra_AirFragCh2RunngSts pA_Fragra_AirFragCh2RunngSts1 = new PATypes.PA_Fragra_AirFragCh2RunngSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_AirFragCh2RunngSts = pA_Fragra_AirFragCh2RunngSts1;
/* 813 */     } catch (Exception exception) {}
/*     */     
/* 815 */     return pA_Fragra_AirFragCh2RunngSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_AirFragCh3RunngSts getPA_Fragra_AirFragCh3RunngSts() throws CarNotConnectedException {
/* 824 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33430, 1);
/*     */     
/* 826 */     PATypes.PA_Fragra_AirFragCh3RunngSts pA_Fragra_AirFragCh3RunngSts = null;
/*     */     try {
/* 828 */       PATypes.PA_Fragra_AirFragCh3RunngSts pA_Fragra_AirFragCh3RunngSts1 = new PATypes.PA_Fragra_AirFragCh3RunngSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_AirFragCh3RunngSts = pA_Fragra_AirFragCh3RunngSts1;
/* 829 */     } catch (Exception exception) {}
/*     */     
/* 831 */     return pA_Fragra_AirFragCh3RunngSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_AirFragCh4RunngSts getPA_Fragra_AirFragCh4RunngSts() throws CarNotConnectedException {
/* 840 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33431, 1);
/*     */     
/* 842 */     PATypes.PA_Fragra_AirFragCh4RunngSts pA_Fragra_AirFragCh4RunngSts = null;
/*     */     try {
/* 844 */       PATypes.PA_Fragra_AirFragCh4RunngSts pA_Fragra_AirFragCh4RunngSts1 = new PATypes.PA_Fragra_AirFragCh4RunngSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_AirFragCh4RunngSts = pA_Fragra_AirFragCh4RunngSts1;
/* 845 */     } catch (Exception exception) {}
/*     */     
/* 847 */     return pA_Fragra_AirFragCh4RunngSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_AirFragCh5RunngSts getPA_Fragra_AirFragCh5RunngSts() throws CarNotConnectedException {
/* 856 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33432, 1);
/*     */     
/* 858 */     PATypes.PA_Fragra_AirFragCh5RunngSts pA_Fragra_AirFragCh5RunngSts = null;
/*     */     try {
/* 860 */       PATypes.PA_Fragra_AirFragCh5RunngSts pA_Fragra_AirFragCh5RunngSts1 = new PATypes.PA_Fragra_AirFragCh5RunngSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_AirFragCh5RunngSts = pA_Fragra_AirFragCh5RunngSts1;
/* 861 */     } catch (Exception exception) {}
/*     */     
/* 863 */     return pA_Fragra_AirFragCh5RunngSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_FragRefrshAutSetg getPA_Fragra_FragRefrshAutSetg() throws CarNotConnectedException {
/* 872 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33433, 1);
/*     */     
/* 874 */     PATypes.PA_Fragra_FragRefrshAutSetg pA_Fragra_FragRefrshAutSetg = null;
/*     */     try {
/* 876 */       PATypes.PA_Fragra_FragRefrshAutSetg pA_Fragra_FragRefrshAutSetg1 = new PATypes.PA_Fragra_FragRefrshAutSetg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_FragRefrshAutSetg = pA_Fragra_FragRefrshAutSetg1;
/* 877 */     } catch (Exception exception) {}
/*     */     
/* 879 */     return pA_Fragra_FragRefrshAutSetg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Fragra_MsgEnd getPA_Fragra_MsgEnd() throws CarNotConnectedException {
/* 888 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33910, 1);
/*     */     
/* 890 */     PATypes.PA_Fragra_MsgEnd pA_Fragra_MsgEnd = null;
/*     */     try {
/* 892 */       PATypes.PA_Fragra_MsgEnd pA_Fragra_MsgEnd1 = new PATypes.PA_Fragra_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Fragra_MsgEnd = pA_Fragra_MsgEnd1;
/* 893 */     } catch (Exception exception) {}
/*     */     
/* 895 */     return pA_Fragra_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarAirqlyandfragraManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */