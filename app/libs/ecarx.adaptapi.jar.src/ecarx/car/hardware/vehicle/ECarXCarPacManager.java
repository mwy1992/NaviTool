/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.annotation.PlaModSts;
/*     */ import ecarx.car.hardware.annotation.TouchEveTyp1;
/*     */ import ecarx.car.hardware.annotation.TxStrtVisResp1;
/*     */ import ecarx.car.hardware.annotation.VisnImgAgWide2D;
/*     */ import ecarx.car.hardware.annotation.VisnImgAgWide3D;
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
/*     */ public class ECarXCarPacManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbpaccoordinatex = 32976;
/*     */   public static final int ManagerId_cbpaccoordinatey = 32977;
/*     */   public static final int ManagerId_cbpacpeddetnreq = 32970;
/*     */   public static final int ManagerId_cbpacplamodreq = 32979;
/*     */   public static final int ManagerId_cbpacprkgindcrlinereq = 32968;
/*     */   public static final int ManagerId_cbpacreboot = 32980;
/*     */   public static final int ManagerId_cbpacroadcalforvisnagwide = 32975;
/*     */   public static final int ManagerId_cbpacswtdisponandoffreq = 32964;
/*     */   public static final int ManagerId_cbpacthrdobjdethreq = 32971;
/*     */   public static final int ManagerId_cbpacthrdtouringviewreq = 32972;
/*     */   public static final int ManagerId_cbpactouchevetyp = 32978;
/*     */   public static final int ManagerId_cbpacturnentryagwidevisreq = 32973;
/*     */   public static final int ManagerId_cbpactxstrtvisresp = 32965;
/*     */   public static final int ManagerId_cbpacvehmdlclrreq = 32974;
/*     */   public static final int ManagerId_cbpacvisnagextnreq = 32969;
/*     */   public static final int ManagerId_cbpacvisnimgagwide2dinusereq = 32966;
/*     */   public static final int ManagerId_cbpacvisnimgagwide3dinusereq = 32967;
/*     */   public static final int ManagerId_papacimgsnsrclrreq = 33550;
/*     */   public static final int ManagerId_papacmsgend = 33918;
/*     */   public static final int ManagerId_papacpeddetnresp = 33543;
/*     */   public static final int ManagerId_papacplamodstsresp = 33549;
/*     */   public static final int ManagerId_papacprkgindcrlineresp = 33541;
/*     */   public static final int ManagerId_papacrctaindcnle = 33551;
/*     */   public static final int ManagerId_papacrctaindcnre = 33552;
/*     */   public static final int ManagerId_papacroadcalforvisnagwideresp = 33548;
/*     */   public static final int ManagerId_papacswtdisponandoffstsresp = 33537;
/*     */   public static final int ManagerId_papacthrdobjdethresp = 33544;
/*     */   public static final int ManagerId_papacthrdtouringviewresp = 33545;
/*     */   public static final int ManagerId_papacturnentryagwidevisresp = 33546;
/*     */   public static final int ManagerId_papactxstrtvisreq = 33538;
/*     */   public static final int ManagerId_papacvehmdlclrresp = 33547;
/*     */   public static final int ManagerId_papacvisnagextnresp = 33542;
/*     */   public static final int ManagerId_papacvisnimgagwide2dinuse = 33539;
/*     */   public static final int ManagerId_papacvisnimgagwide3dinuse = 33540;
/*     */   private static final String TAG = "ECarXCarPacManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarPacManager() {}
/*     */   
/*     */   public ECarXCarPacManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  90 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_SwtDispOnAndOffReq(int paramInt) {
/* 100 */     ApiResult apiResult = ApiResult.FAILED;
/* 101 */     if (OnOff1.isValid(paramInt)) {
/* 102 */       apiResult = this.mMgr.setIntProperty(32964, 1, paramInt);
/*     */     } else {
/* 104 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 106 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_TxStrtVisResp(int paramInt) {
/* 116 */     ApiResult apiResult = ApiResult.FAILED;
/* 117 */     if (TxStrtVisResp1.isValid(paramInt)) {
/* 118 */       apiResult = this.mMgr.setIntProperty(32965, 1, paramInt);
/*     */     } else {
/* 120 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 122 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_VisnImgAgWide2DInUseReq(int paramInt) {
/* 132 */     ApiResult apiResult = ApiResult.FAILED;
/* 133 */     if (VisnImgAgWide2D.isValid(paramInt)) {
/* 134 */       apiResult = this.mMgr.setIntProperty(32966, 1, paramInt);
/*     */     } else {
/* 136 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 138 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_VisnImgAgWide3DInUseReq(int paramInt) {
/* 148 */     ApiResult apiResult = ApiResult.FAILED;
/* 149 */     if (VisnImgAgWide3D.isValid(paramInt)) {
/* 150 */       apiResult = this.mMgr.setIntProperty(32967, 1, paramInt);
/*     */     } else {
/* 152 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 154 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_PrkgIndcrLineReq(int paramInt) {
/* 164 */     ApiResult apiResult = ApiResult.FAILED;
/* 165 */     if (OnOff1.isValid(paramInt)) {
/* 166 */       apiResult = this.mMgr.setIntProperty(32968, 1, paramInt);
/*     */     } else {
/* 168 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 170 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_VisnAgExtnReq(int paramInt) {
/* 180 */     ApiResult apiResult = ApiResult.FAILED;
/* 181 */     if (OnOff1.isValid(paramInt)) {
/* 182 */       apiResult = this.mMgr.setIntProperty(32969, 1, paramInt);
/*     */     } else {
/* 184 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 186 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_PedDetnReq(int paramInt) {
/* 196 */     ApiResult apiResult = ApiResult.FAILED;
/* 197 */     if (OnOff1.isValid(paramInt)) {
/* 198 */       apiResult = this.mMgr.setIntProperty(32970, 1, paramInt);
/*     */     } else {
/* 200 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 202 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_ThrDObjDethReq(int paramInt) {
/* 212 */     ApiResult apiResult = ApiResult.FAILED;
/* 213 */     if (OnOff1.isValid(paramInt)) {
/* 214 */       apiResult = this.mMgr.setIntProperty(32971, 1, paramInt);
/*     */     } else {
/* 216 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 218 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_ThrDTouringViewReq(int paramInt) {
/* 228 */     ApiResult apiResult = ApiResult.FAILED;
/* 229 */     if (OnOff1.isValid(paramInt)) {
/* 230 */       apiResult = this.mMgr.setIntProperty(32972, 1, paramInt);
/*     */     } else {
/* 232 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 234 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_TurnEntryAgWideVisReq(int paramInt) {
/* 244 */     ApiResult apiResult = ApiResult.FAILED;
/* 245 */     if (OnOff1.isValid(paramInt)) {
/* 246 */       apiResult = this.mMgr.setIntProperty(32973, 1, paramInt);
/*     */     } else {
/* 248 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 250 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_VehMdlClrReq(int paramInt) {
/* 260 */     ApiResult apiResult = ApiResult.FAILED;
/* 261 */     if (OnOff1.isValid(paramInt)) {
/* 262 */       apiResult = this.mMgr.setIntProperty(32974, 1, paramInt);
/*     */     } else {
/* 264 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 266 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_RoadCalForVisnAgWide(int paramInt) {
/* 276 */     ApiResult apiResult = ApiResult.FAILED;
/* 277 */     if (OnOff1.isValid(paramInt)) {
/* 278 */       apiResult = this.mMgr.setIntProperty(32975, 1, paramInt);
/*     */     } else {
/* 280 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 282 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_CoordinateX(int paramInt) {
/* 292 */     return this.mMgr.setIntProperty(32976, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_CoordinateY(int paramInt) {
/* 302 */     return this.mMgr.setIntProperty(32977, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_TouchEveTyp(int paramInt) {
/* 312 */     ApiResult apiResult = ApiResult.FAILED;
/* 313 */     if (TouchEveTyp1.isValid(paramInt)) {
/* 314 */       apiResult = this.mMgr.setIntProperty(32978, 1, paramInt);
/*     */     } else {
/* 316 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 318 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_PlaModReq(int paramInt) {
/* 328 */     ApiResult apiResult = ApiResult.FAILED;
/* 329 */     if (PlaModSts.isValid(paramInt)) {
/* 330 */       apiResult = this.mMgr.setIntProperty(32979, 1, paramInt);
/*     */     } else {
/* 332 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 334 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PAC_Reboot(int paramInt) {
/* 344 */     return this.mMgr.setIntProperty(32980, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_SwtDispOnAndOffStsResp getPA_PAC_SwtDispOnAndOffStsResp() throws CarNotConnectedException {
/* 355 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33537, 1);
/*     */     
/* 357 */     PATypes.PA_PAC_SwtDispOnAndOffStsResp pA_PAC_SwtDispOnAndOffStsResp = null;
/*     */     try {
/* 359 */       PATypes.PA_PAC_SwtDispOnAndOffStsResp pA_PAC_SwtDispOnAndOffStsResp1 = new PATypes.PA_PAC_SwtDispOnAndOffStsResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_SwtDispOnAndOffStsResp = pA_PAC_SwtDispOnAndOffStsResp1;
/* 360 */     } catch (Exception exception) {}
/*     */     
/* 362 */     return pA_PAC_SwtDispOnAndOffStsResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_TxStrtVisReq getPA_PAC_TxStrtVisReq() throws CarNotConnectedException {
/* 371 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33538, 1);
/*     */     
/* 373 */     PATypes.PA_PAC_TxStrtVisReq pA_PAC_TxStrtVisReq = null;
/*     */     try {
/* 375 */       PATypes.PA_PAC_TxStrtVisReq pA_PAC_TxStrtVisReq1 = new PATypes.PA_PAC_TxStrtVisReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_TxStrtVisReq = pA_PAC_TxStrtVisReq1;
/* 376 */     } catch (Exception exception) {}
/*     */     
/* 378 */     return pA_PAC_TxStrtVisReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_VisnImgAgWide2DInUse getPA_PAC_VisnImgAgWide2DInUse() throws CarNotConnectedException {
/* 387 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33539, 1);
/*     */     
/* 389 */     PATypes.PA_PAC_VisnImgAgWide2DInUse pA_PAC_VisnImgAgWide2DInUse = null;
/*     */     try {
/* 391 */       PATypes.PA_PAC_VisnImgAgWide2DInUse pA_PAC_VisnImgAgWide2DInUse1 = new PATypes.PA_PAC_VisnImgAgWide2DInUse(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_VisnImgAgWide2DInUse = pA_PAC_VisnImgAgWide2DInUse1;
/* 392 */     } catch (Exception exception) {}
/*     */     
/* 394 */     return pA_PAC_VisnImgAgWide2DInUse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_VisnImgAgWide3DInUse getPA_PAC_VisnImgAgWide3DInUse() throws CarNotConnectedException {
/* 403 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33540, 1);
/*     */     
/* 405 */     PATypes.PA_PAC_VisnImgAgWide3DInUse pA_PAC_VisnImgAgWide3DInUse = null;
/*     */     try {
/* 407 */       PATypes.PA_PAC_VisnImgAgWide3DInUse pA_PAC_VisnImgAgWide3DInUse1 = new PATypes.PA_PAC_VisnImgAgWide3DInUse(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_VisnImgAgWide3DInUse = pA_PAC_VisnImgAgWide3DInUse1;
/* 408 */     } catch (Exception exception) {}
/*     */     
/* 410 */     return pA_PAC_VisnImgAgWide3DInUse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_PrkgIndcrLineResp getPA_PAC_PrkgIndcrLineResp() throws CarNotConnectedException {
/* 419 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33541, 1);
/*     */     
/* 421 */     PATypes.PA_PAC_PrkgIndcrLineResp pA_PAC_PrkgIndcrLineResp = null;
/*     */     try {
/* 423 */       PATypes.PA_PAC_PrkgIndcrLineResp pA_PAC_PrkgIndcrLineResp1 = new PATypes.PA_PAC_PrkgIndcrLineResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_PrkgIndcrLineResp = pA_PAC_PrkgIndcrLineResp1;
/* 424 */     } catch (Exception exception) {}
/*     */     
/* 426 */     return pA_PAC_PrkgIndcrLineResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_VisnAgExtnResp getPA_PAC_VisnAgExtnResp() throws CarNotConnectedException {
/* 435 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33542, 1);
/*     */     
/* 437 */     PATypes.PA_PAC_VisnAgExtnResp pA_PAC_VisnAgExtnResp = null;
/*     */     try {
/* 439 */       PATypes.PA_PAC_VisnAgExtnResp pA_PAC_VisnAgExtnResp1 = new PATypes.PA_PAC_VisnAgExtnResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_VisnAgExtnResp = pA_PAC_VisnAgExtnResp1;
/* 440 */     } catch (Exception exception) {}
/*     */     
/* 442 */     return pA_PAC_VisnAgExtnResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_PedDetnResp getPA_PAC_PedDetnResp() throws CarNotConnectedException {
/* 451 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33543, 1);
/*     */     
/* 453 */     PATypes.PA_PAC_PedDetnResp pA_PAC_PedDetnResp = null;
/*     */     try {
/* 455 */       PATypes.PA_PAC_PedDetnResp pA_PAC_PedDetnResp1 = new PATypes.PA_PAC_PedDetnResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_PedDetnResp = pA_PAC_PedDetnResp1;
/* 456 */     } catch (Exception exception) {}
/*     */     
/* 458 */     return pA_PAC_PedDetnResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_ThrDObjDethResp getPA_PAC_ThrDObjDethResp() throws CarNotConnectedException {
/* 467 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33544, 1);
/*     */     
/* 469 */     PATypes.PA_PAC_ThrDObjDethResp pA_PAC_ThrDObjDethResp = null;
/*     */     try {
/* 471 */       PATypes.PA_PAC_ThrDObjDethResp pA_PAC_ThrDObjDethResp1 = new PATypes.PA_PAC_ThrDObjDethResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_ThrDObjDethResp = pA_PAC_ThrDObjDethResp1;
/* 472 */     } catch (Exception exception) {}
/*     */     
/* 474 */     return pA_PAC_ThrDObjDethResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_ThrDTouringViewResp getPA_PAC_ThrDTouringViewResp() throws CarNotConnectedException {
/* 483 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33545, 1);
/*     */     
/* 485 */     PATypes.PA_PAC_ThrDTouringViewResp pA_PAC_ThrDTouringViewResp = null;
/*     */     try {
/* 487 */       PATypes.PA_PAC_ThrDTouringViewResp pA_PAC_ThrDTouringViewResp1 = new PATypes.PA_PAC_ThrDTouringViewResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_ThrDTouringViewResp = pA_PAC_ThrDTouringViewResp1;
/* 488 */     } catch (Exception exception) {}
/*     */     
/* 490 */     return pA_PAC_ThrDTouringViewResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_TurnEntryAgWideVisResp getPA_PAC_TurnEntryAgWideVisResp() throws CarNotConnectedException {
/* 499 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33546, 1);
/*     */     
/* 501 */     PATypes.PA_PAC_TurnEntryAgWideVisResp pA_PAC_TurnEntryAgWideVisResp = null;
/*     */     try {
/* 503 */       PATypes.PA_PAC_TurnEntryAgWideVisResp pA_PAC_TurnEntryAgWideVisResp1 = new PATypes.PA_PAC_TurnEntryAgWideVisResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_TurnEntryAgWideVisResp = pA_PAC_TurnEntryAgWideVisResp1;
/* 504 */     } catch (Exception exception) {}
/*     */     
/* 506 */     return pA_PAC_TurnEntryAgWideVisResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_VehMdlClrResp getPA_PAC_VehMdlClrResp() throws CarNotConnectedException {
/* 515 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33547, 1);
/*     */     
/* 517 */     PATypes.PA_PAC_VehMdlClrResp pA_PAC_VehMdlClrResp = null;
/*     */     try {
/* 519 */       PATypes.PA_PAC_VehMdlClrResp pA_PAC_VehMdlClrResp1 = new PATypes.PA_PAC_VehMdlClrResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_VehMdlClrResp = pA_PAC_VehMdlClrResp1;
/* 520 */     } catch (Exception exception) {}
/*     */     
/* 522 */     return pA_PAC_VehMdlClrResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_RoadCalForVisnAgWideResp getPA_PAC_RoadCalForVisnAgWideResp() throws CarNotConnectedException {
/* 531 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33548, 1);
/*     */     
/* 533 */     PATypes.PA_PAC_RoadCalForVisnAgWideResp pA_PAC_RoadCalForVisnAgWideResp = null;
/*     */     try {
/* 535 */       PATypes.PA_PAC_RoadCalForVisnAgWideResp pA_PAC_RoadCalForVisnAgWideResp1 = new PATypes.PA_PAC_RoadCalForVisnAgWideResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_RoadCalForVisnAgWideResp = pA_PAC_RoadCalForVisnAgWideResp1;
/* 536 */     } catch (Exception exception) {}
/*     */     
/* 538 */     return pA_PAC_RoadCalForVisnAgWideResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_PlaModStsResp getPA_PAC_PlaModStsResp() throws CarNotConnectedException {
/* 547 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33549, 1);
/*     */     
/* 549 */     PATypes.PA_PAC_PlaModStsResp pA_PAC_PlaModStsResp = null;
/*     */     try {
/* 551 */       PATypes.PA_PAC_PlaModStsResp pA_PAC_PlaModStsResp1 = new PATypes.PA_PAC_PlaModStsResp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_PlaModStsResp = pA_PAC_PlaModStsResp1;
/* 552 */     } catch (Exception exception) {}
/*     */     
/* 554 */     return pA_PAC_PlaModStsResp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_ImgSnsrClrReq getPA_PAC_ImgSnsrClrReq() throws CarNotConnectedException {
/* 563 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33550, 1);
/*     */     
/* 565 */     PATypes.PA_PAC_ImgSnsrClrReq pA_PAC_ImgSnsrClrReq = null;
/*     */     try {
/* 567 */       PATypes.PA_PAC_ImgSnsrClrReq pA_PAC_ImgSnsrClrReq1 = new PATypes.PA_PAC_ImgSnsrClrReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_ImgSnsrClrReq = pA_PAC_ImgSnsrClrReq1;
/* 568 */     } catch (Exception exception) {}
/*     */     
/* 570 */     return pA_PAC_ImgSnsrClrReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_RctaIndcnLe getPA_PAC_RctaIndcnLe() throws CarNotConnectedException {
/* 579 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33551, 1);
/*     */     
/* 581 */     PATypes.PA_PAC_RctaIndcnLe pA_PAC_RctaIndcnLe = null;
/*     */     try {
/* 583 */       PATypes.PA_PAC_RctaIndcnLe pA_PAC_RctaIndcnLe1 = new PATypes.PA_PAC_RctaIndcnLe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_RctaIndcnLe = pA_PAC_RctaIndcnLe1;
/* 584 */     } catch (Exception exception) {}
/*     */     
/* 586 */     return pA_PAC_RctaIndcnLe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_RctaIndcnRe getPA_PAC_RctaIndcnRe() throws CarNotConnectedException {
/* 595 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33552, 1);
/*     */     
/* 597 */     PATypes.PA_PAC_RctaIndcnRe pA_PAC_RctaIndcnRe = null;
/*     */     try {
/* 599 */       PATypes.PA_PAC_RctaIndcnRe pA_PAC_RctaIndcnRe1 = new PATypes.PA_PAC_RctaIndcnRe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_RctaIndcnRe = pA_PAC_RctaIndcnRe1;
/* 600 */     } catch (Exception exception) {}
/*     */     
/* 602 */     return pA_PAC_RctaIndcnRe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PAC_MsgEnd getPA_PAC_MsgEnd() throws CarNotConnectedException {
/* 611 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33918, 1);
/*     */     
/* 613 */     PATypes.PA_PAC_MsgEnd pA_PAC_MsgEnd = null;
/*     */     try {
/* 615 */       PATypes.PA_PAC_MsgEnd pA_PAC_MsgEnd1 = new PATypes.PA_PAC_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PAC_MsgEnd = pA_PAC_MsgEnd1;
/* 616 */     } catch (Exception exception) {}
/*     */     
/* 618 */     return pA_PAC_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarPacManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */