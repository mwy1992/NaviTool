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
/*     */ public class ECarXCarPassapManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbpasprkgdstctrlsysswt = 32982;
/*     */   public static final int ManagerId_cbpassapreboot = 32984;
/*     */   public static final int ManagerId_cbpebprkgemgbrksysswt = 32983;
/*     */   public static final int ManagerId_cbsapdrvrasscsysbtnpush = 32981;
/*     */   public static final int ManagerId_papasaudwarnofsnsrparkassifrnt = 33570;
/*     */   public static final int ManagerId_papasaudwarnofsnsrparkassire = 33569;
/*     */   public static final int ManagerId_papasinsdleofsnsrprkgassifrnt = 33565;
/*     */   public static final int ManagerId_papasinsdleofsnsrprkgassire = 33561;
/*     */   public static final int ManagerId_papasinsdriofsnsrprkgassifrnt = 33566;
/*     */   public static final int ManagerId_papasinsdriofsnsrprkgassire = 33562;
/*     */   public static final int ManagerId_papasmsgend = 33919;
/*     */   public static final int ManagerId_papasoutdleofsnsrprkgassifrnt = 33567;
/*     */   public static final int ManagerId_papasoutdleofsnsrprkgassire = 33563;
/*     */   public static final int ManagerId_papasoutdriofsnsrprkgassifrnt = 33568;
/*     */   public static final int ManagerId_papasoutdriofsnsrprkgassire = 33564;
/*     */   public static final int ManagerId_papasprkgdstctrlsts = 33560;
/*     */   public static final int ManagerId_papasprkgdstctrlsysswt = 33559;
/*     */   public static final int ManagerId_papassnsrfltstswarn = 33573;
/*     */   public static final int ManagerId_papebprkgemgbrksysswt = 33571;
/*     */   public static final int ManagerId_papebprkgemgybrksyssts = 33572;
/*     */   public static final int ManagerId_pasapdrvrasscsysbtnpush = 33553;
/*     */   public static final int ManagerId_pasapdrvrasscsysdisp = 33556;
/*     */   public static final int ManagerId_pasapdrvrasscsyssts = 33555;
/*     */   public static final int ManagerId_pasapprkgfctdidisp = 33554;
/*     */   public static final int ManagerId_pasapprkgprogsdisp = 33557;
/*     */   public static final int ManagerId_pasaptouchunlcktyp = 33558;
/*     */   private static final String TAG = "ECarXCarPassapManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarPassapManager() {}
/*     */   
/*     */   public ECarXCarPassapManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  77 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SAP_DrvrAsscSysBtnPush(int paramInt) {
/*  87 */     ApiResult apiResult = ApiResult.FAILED;
/*  88 */     if (OnOff1.isValid(paramInt)) {
/*  89 */       apiResult = this.mMgr.setIntProperty(32981, 1, paramInt);
/*     */     } else {
/*  91 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  93 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAS_PrkgDstCtrlSysSwt(int paramInt) {
/* 103 */     ApiResult apiResult = ApiResult.FAILED;
/* 104 */     if (OnOff1.isValid(paramInt)) {
/* 105 */       apiResult = this.mMgr.setIntProperty(32982, 1, paramInt);
/*     */     } else {
/* 107 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 109 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PEB_PrkgEmgBrkSysSwt(int paramInt) {
/* 119 */     ApiResult apiResult = ApiResult.FAILED;
/* 120 */     if (OnOff1.isValid(paramInt)) {
/* 121 */       apiResult = this.mMgr.setIntProperty(32983, 1, paramInt);
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
/*     */   public ApiResult CB_PASSAP_Reboot(int paramInt) {
/* 135 */     return this.mMgr.setIntProperty(32984, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SAP_DrvrAsscSysBtnPush getPA_SAP_DrvrAsscSysBtnPush() throws CarNotConnectedException {
/* 146 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33553, 1);
/*     */     
/* 148 */     PATypes.PA_SAP_DrvrAsscSysBtnPush pA_SAP_DrvrAsscSysBtnPush = null;
/*     */     try {
/* 150 */       PATypes.PA_SAP_DrvrAsscSysBtnPush pA_SAP_DrvrAsscSysBtnPush1 = new PATypes.PA_SAP_DrvrAsscSysBtnPush(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SAP_DrvrAsscSysBtnPush = pA_SAP_DrvrAsscSysBtnPush1;
/* 151 */     } catch (Exception exception) {}
/*     */     
/* 153 */     return pA_SAP_DrvrAsscSysBtnPush;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SAP_PrkgFctDiDisp getPA_SAP_PrkgFctDiDisp() throws CarNotConnectedException {
/* 162 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33554, 1);
/*     */     
/* 164 */     PATypes.PA_SAP_PrkgFctDiDisp pA_SAP_PrkgFctDiDisp = null;
/*     */     try {
/* 166 */       PATypes.PA_SAP_PrkgFctDiDisp pA_SAP_PrkgFctDiDisp1 = new PATypes.PA_SAP_PrkgFctDiDisp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SAP_PrkgFctDiDisp = pA_SAP_PrkgFctDiDisp1;
/* 167 */     } catch (Exception exception) {}
/*     */     
/* 169 */     return pA_SAP_PrkgFctDiDisp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SAP_DrvrAsscSysSts getPA_SAP_DrvrAsscSysSts() throws CarNotConnectedException {
/* 178 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33555, 1);
/*     */     
/* 180 */     PATypes.PA_SAP_DrvrAsscSysSts pA_SAP_DrvrAsscSysSts = null;
/*     */     try {
/* 182 */       PATypes.PA_SAP_DrvrAsscSysSts pA_SAP_DrvrAsscSysSts1 = new PATypes.PA_SAP_DrvrAsscSysSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SAP_DrvrAsscSysSts = pA_SAP_DrvrAsscSysSts1;
/* 183 */     } catch (Exception exception) {}
/*     */     
/* 185 */     return pA_SAP_DrvrAsscSysSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SAP_DrvrAsscSysDisp getPA_SAP_DrvrAsscSysDisp() throws CarNotConnectedException {
/* 194 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33556, 1);
/*     */     
/* 196 */     PATypes.PA_SAP_DrvrAsscSysDisp pA_SAP_DrvrAsscSysDisp = null;
/*     */     try {
/* 198 */       PATypes.PA_SAP_DrvrAsscSysDisp pA_SAP_DrvrAsscSysDisp1 = new PATypes.PA_SAP_DrvrAsscSysDisp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SAP_DrvrAsscSysDisp = pA_SAP_DrvrAsscSysDisp1;
/* 199 */     } catch (Exception exception) {}
/*     */     
/* 201 */     return pA_SAP_DrvrAsscSysDisp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SAP_PrkgProgsDisp getPA_SAP_PrkgProgsDisp() throws CarNotConnectedException {
/* 210 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33557, 1);
/*     */     
/* 212 */     PATypes.PA_SAP_PrkgProgsDisp pA_SAP_PrkgProgsDisp = null;
/*     */     try {
/* 214 */       PATypes.PA_SAP_PrkgProgsDisp pA_SAP_PrkgProgsDisp1 = new PATypes.PA_SAP_PrkgProgsDisp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SAP_PrkgProgsDisp = pA_SAP_PrkgProgsDisp1;
/* 215 */     } catch (Exception exception) {}
/*     */     
/* 217 */     return pA_SAP_PrkgProgsDisp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SAP_TouchUnlckTyp getPA_SAP_TouchUnlckTyp() throws CarNotConnectedException {
/* 226 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33558, 1);
/*     */     
/* 228 */     PATypes.PA_SAP_TouchUnlckTyp pA_SAP_TouchUnlckTyp = null;
/*     */     try {
/* 230 */       PATypes.PA_SAP_TouchUnlckTyp pA_SAP_TouchUnlckTyp1 = new PATypes.PA_SAP_TouchUnlckTyp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SAP_TouchUnlckTyp = pA_SAP_TouchUnlckTyp1;
/* 231 */     } catch (Exception exception) {}
/*     */     
/* 233 */     return pA_SAP_TouchUnlckTyp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_PrkgDstCtrlSysSwt getPA_PAS_PrkgDstCtrlSysSwt() throws CarNotConnectedException {
/* 242 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33559, 1);
/*     */     
/* 244 */     PATypes.PA_PAS_PrkgDstCtrlSysSwt pA_PAS_PrkgDstCtrlSysSwt = null;
/*     */     try {
/* 246 */       PATypes.PA_PAS_PrkgDstCtrlSysSwt pA_PAS_PrkgDstCtrlSysSwt1 = new PATypes.PA_PAS_PrkgDstCtrlSysSwt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_PrkgDstCtrlSysSwt = pA_PAS_PrkgDstCtrlSysSwt1;
/* 247 */     } catch (Exception exception) {}
/*     */     
/* 249 */     return pA_PAS_PrkgDstCtrlSysSwt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_PrkgDstCtrlSts getPA_PAS_PrkgDstCtrlSts() throws CarNotConnectedException {
/* 258 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33560, 1);
/*     */     
/* 260 */     PATypes.PA_PAS_PrkgDstCtrlSts pA_PAS_PrkgDstCtrlSts = null;
/*     */     try {
/* 262 */       PATypes.PA_PAS_PrkgDstCtrlSts pA_PAS_PrkgDstCtrlSts1 = new PATypes.PA_PAS_PrkgDstCtrlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_PrkgDstCtrlSts = pA_PAS_PrkgDstCtrlSts1;
/* 263 */     } catch (Exception exception) {}
/*     */     
/* 265 */     return pA_PAS_PrkgDstCtrlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe getPA_PAS_InsdLeOfSnsrPrkgAssiRe() throws CarNotConnectedException {
/* 274 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33561, 1);
/*     */     
/* 276 */     PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe pA_PAS_InsdLeOfSnsrPrkgAssiRe = null;
/*     */     try {
/* 278 */       PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe pA_PAS_InsdLeOfSnsrPrkgAssiRe1 = new PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_InsdLeOfSnsrPrkgAssiRe = pA_PAS_InsdLeOfSnsrPrkgAssiRe1;
/* 279 */     } catch (Exception exception) {}
/*     */     
/* 281 */     return pA_PAS_InsdLeOfSnsrPrkgAssiRe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe getPA_PAS_InsdRiOfSnsrPrkgAssiRe() throws CarNotConnectedException {
/* 290 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33562, 1);
/*     */     
/* 292 */     PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe pA_PAS_InsdRiOfSnsrPrkgAssiRe = null;
/*     */     try {
/* 294 */       PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe pA_PAS_InsdRiOfSnsrPrkgAssiRe1 = new PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_InsdRiOfSnsrPrkgAssiRe = pA_PAS_InsdRiOfSnsrPrkgAssiRe1;
/* 295 */     } catch (Exception exception) {}
/*     */     
/* 297 */     return pA_PAS_InsdRiOfSnsrPrkgAssiRe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe getPA_PAS_OutdLeOfSnsrPrkgAssiRe() throws CarNotConnectedException {
/* 306 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33563, 1);
/*     */     
/* 308 */     PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe pA_PAS_OutdLeOfSnsrPrkgAssiRe = null;
/*     */     try {
/* 310 */       PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe pA_PAS_OutdLeOfSnsrPrkgAssiRe1 = new PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_OutdLeOfSnsrPrkgAssiRe = pA_PAS_OutdLeOfSnsrPrkgAssiRe1;
/* 311 */     } catch (Exception exception) {}
/*     */     
/* 313 */     return pA_PAS_OutdLeOfSnsrPrkgAssiRe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe getPA_PAS_OutdRiOfSnsrPrkgAssiRe() throws CarNotConnectedException {
/* 322 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33564, 1);
/*     */     
/* 324 */     PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe pA_PAS_OutdRiOfSnsrPrkgAssiRe = null;
/*     */     try {
/* 326 */       PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe pA_PAS_OutdRiOfSnsrPrkgAssiRe1 = new PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_OutdRiOfSnsrPrkgAssiRe = pA_PAS_OutdRiOfSnsrPrkgAssiRe1;
/* 327 */     } catch (Exception exception) {}
/*     */     
/* 329 */     return pA_PAS_OutdRiOfSnsrPrkgAssiRe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt getPA_PAS_InsdLeOfSnsrPrkgAssiFrnt() throws CarNotConnectedException {
/* 338 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33565, 1);
/*     */     
/* 340 */     PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt pA_PAS_InsdLeOfSnsrPrkgAssiFrnt = null;
/*     */     try {
/* 342 */       PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt pA_PAS_InsdLeOfSnsrPrkgAssiFrnt1 = new PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_InsdLeOfSnsrPrkgAssiFrnt = pA_PAS_InsdLeOfSnsrPrkgAssiFrnt1;
/* 343 */     } catch (Exception exception) {}
/*     */     
/* 345 */     return pA_PAS_InsdLeOfSnsrPrkgAssiFrnt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt getPA_PAS_InsdRiOfSnsrPrkgAssiFrnt() throws CarNotConnectedException {
/* 354 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33566, 1);
/*     */     
/* 356 */     PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt pA_PAS_InsdRiOfSnsrPrkgAssiFrnt = null;
/*     */     try {
/* 358 */       PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt pA_PAS_InsdRiOfSnsrPrkgAssiFrnt1 = new PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_InsdRiOfSnsrPrkgAssiFrnt = pA_PAS_InsdRiOfSnsrPrkgAssiFrnt1;
/* 359 */     } catch (Exception exception) {}
/*     */     
/* 361 */     return pA_PAS_InsdRiOfSnsrPrkgAssiFrnt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt getPA_PAS_OutdLeOfSnsrPrkgAssiFrnt() throws CarNotConnectedException {
/* 370 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33567, 1);
/*     */     
/* 372 */     PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt pA_PAS_OutdLeOfSnsrPrkgAssiFrnt = null;
/*     */     try {
/* 374 */       PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt pA_PAS_OutdLeOfSnsrPrkgAssiFrnt1 = new PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_OutdLeOfSnsrPrkgAssiFrnt = pA_PAS_OutdLeOfSnsrPrkgAssiFrnt1;
/* 375 */     } catch (Exception exception) {}
/*     */     
/* 377 */     return pA_PAS_OutdLeOfSnsrPrkgAssiFrnt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt getPA_PAS_OutdRiOfSnsrPrkgAssiFrnt() throws CarNotConnectedException {
/* 386 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33568, 1);
/*     */     
/* 388 */     PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt pA_PAS_OutdRiOfSnsrPrkgAssiFrnt = null;
/*     */     try {
/* 390 */       PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt pA_PAS_OutdRiOfSnsrPrkgAssiFrnt1 = new PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_OutdRiOfSnsrPrkgAssiFrnt = pA_PAS_OutdRiOfSnsrPrkgAssiFrnt1;
/* 391 */     } catch (Exception exception) {}
/*     */     
/* 393 */     return pA_PAS_OutdRiOfSnsrPrkgAssiFrnt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe getPA_PAS_AudWarnOfSnsrParkAssiRe() throws CarNotConnectedException {
/* 402 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33569, 1);
/*     */     
/* 404 */     PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe pA_PAS_AudWarnOfSnsrParkAssiRe = null;
/*     */     try {
/* 406 */       PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe pA_PAS_AudWarnOfSnsrParkAssiRe1 = new PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_AudWarnOfSnsrParkAssiRe = pA_PAS_AudWarnOfSnsrParkAssiRe1;
/* 407 */     } catch (Exception exception) {}
/*     */     
/* 409 */     return pA_PAS_AudWarnOfSnsrParkAssiRe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt getPA_PAS_AudWarnOfSnsrParkAssiFrnt() throws CarNotConnectedException {
/* 418 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33570, 1);
/*     */     
/* 420 */     PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt pA_PAS_AudWarnOfSnsrParkAssiFrnt = null;
/*     */     try {
/* 422 */       PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt pA_PAS_AudWarnOfSnsrParkAssiFrnt1 = new PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_AudWarnOfSnsrParkAssiFrnt = pA_PAS_AudWarnOfSnsrParkAssiFrnt1;
/* 423 */     } catch (Exception exception) {}
/*     */     
/* 425 */     return pA_PAS_AudWarnOfSnsrParkAssiFrnt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PEB_PrkgEmgBrkSysSwt getPA_PEB_PrkgEmgBrkSysSwt() throws CarNotConnectedException {
/* 434 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33571, 1);
/*     */     
/* 436 */     PATypes.PA_PEB_PrkgEmgBrkSysSwt pA_PEB_PrkgEmgBrkSysSwt = null;
/*     */     try {
/* 438 */       PATypes.PA_PEB_PrkgEmgBrkSysSwt pA_PEB_PrkgEmgBrkSysSwt1 = new PATypes.PA_PEB_PrkgEmgBrkSysSwt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PEB_PrkgEmgBrkSysSwt = pA_PEB_PrkgEmgBrkSysSwt1;
/* 439 */     } catch (Exception exception) {}
/*     */     
/* 441 */     return pA_PEB_PrkgEmgBrkSysSwt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PEB_PrkgEmgyBrkSysSts getPA_PEB_PrkgEmgyBrkSysSts() throws CarNotConnectedException {
/* 450 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33572, 1);
/*     */     
/* 452 */     PATypes.PA_PEB_PrkgEmgyBrkSysSts pA_PEB_PrkgEmgyBrkSysSts = null;
/*     */     try {
/* 454 */       PATypes.PA_PEB_PrkgEmgyBrkSysSts pA_PEB_PrkgEmgyBrkSysSts1 = new PATypes.PA_PEB_PrkgEmgyBrkSysSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PEB_PrkgEmgyBrkSysSts = pA_PEB_PrkgEmgyBrkSysSts1;
/* 455 */     } catch (Exception exception) {}
/*     */     
/* 457 */     return pA_PEB_PrkgEmgyBrkSysSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_SnsrFltStsWarn getPA_PAS_SnsrFltStsWarn() throws CarNotConnectedException {
/* 466 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33573, 1);
/*     */     
/* 468 */     PATypes.PA_PAS_SnsrFltStsWarn pA_PAS_SnsrFltStsWarn = null;
/*     */     try {
/* 470 */       PATypes.PA_PAS_SnsrFltStsWarn pA_PAS_SnsrFltStsWarn1 = new PATypes.PA_PAS_SnsrFltStsWarn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_SnsrFltStsWarn = pA_PAS_SnsrFltStsWarn1;
/* 471 */     } catch (Exception exception) {}
/*     */     
/* 473 */     return pA_PAS_SnsrFltStsWarn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAS_MsgEnd getPA_PAS_MsgEnd() throws CarNotConnectedException {
/* 482 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33919, 1);
/*     */     
/* 484 */     PATypes.PA_PAS_MsgEnd pA_PAS_MsgEnd = null;
/*     */     try {
/* 486 */       PATypes.PA_PAS_MsgEnd pA_PAS_MsgEnd1 = new PATypes.PA_PAS_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAS_MsgEnd = pA_PAS_MsgEnd1;
/* 487 */     } catch (Exception exception) {}
/*     */     
/* 489 */     return pA_PAS_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarPassapManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */