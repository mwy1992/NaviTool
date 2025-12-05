/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.DispModSetgReq;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.annotation.YesNo2;
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
/*     */ public class ECarXCarProfiletransferManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbcnclfacereqforprof = 33282;
/*     */   public static final int ManagerId_cbfaceidnreq = 33283;
/*     */   public static final int ManagerId_cbfacesgninforprof = 33284;
/*     */   public static final int ManagerId_cbhuddispmodsetgreq = 33285;
/*     */   public static final int ManagerId_cbprkgindcrlinereq = 33286;
/*     */   public static final int ManagerId_cbprofiletransferreboot = 33281;
/*     */   public static final int ManagerId_cbsurrndgsobjdetnreq = 33287;
/*     */   public static final int ManagerId_cbthrdtouringviewreq = 33288;
/*     */   public static final int ManagerId_cbtopvisndispextnreq = 33289;
/*     */   public static final int ManagerId_cbturnentryagwidevisreq = 33290;
/*     */   public static final int ManagerId_cbvehmdlclrreq = 33291;
/*     */   public static final int ManagerId_pacnclfacereqforprof = 33964;
/*     */   public static final int ManagerId_pafaceidnreq = 33965;
/*     */   public static final int ManagerId_pafacesgninforprof = 33966;
/*     */   public static final int ManagerId_pahuddispmodsetgreq = 33967;
/*     */   public static final int ManagerId_paprkgindcrlinereq = 33968;
/*     */   public static final int ManagerId_pasurrndgsobjdetnreq = 33969;
/*     */   public static final int ManagerId_pathrdtouringviewreq = 33970;
/*     */   public static final int ManagerId_patopvisndispextnreq = 33971;
/*     */   public static final int ManagerId_paturnentryagwidevisreq = 33972;
/*     */   public static final int ManagerId_pavehmdlclrreq = 33973;
/*     */   private static final String TAG = "ECarXCarProfiletransferManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarProfiletransferManager() {}
/*     */   
/*     */   public ECarXCarProfiletransferManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  74 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Profile_Transfer_Reboot(int paramInt) {
/*  84 */     return this.mMgr.setIntProperty(33281, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_CnclFaceReqForProf(int paramInt) {
/*  94 */     ApiResult apiResult = ApiResult.FAILED;
/*  95 */     if (YesNo2.isValid(paramInt)) {
/*  96 */       apiResult = this.mMgr.setIntProperty(33282, 1, paramInt);
/*     */     } else {
/*  98 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 100 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_FaceIdnReq(int paramInt) {
/* 110 */     ApiResult apiResult = ApiResult.FAILED;
/* 111 */     if (OnOff1.isValid(paramInt)) {
/* 112 */       apiResult = this.mMgr.setIntProperty(33283, 1, paramInt);
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
/*     */   public ApiResult CB_FaceSgnInForProf(int paramInt) {
/* 126 */     ApiResult apiResult = ApiResult.FAILED;
/* 127 */     if (YesNo2.isValid(paramInt)) {
/* 128 */       apiResult = this.mMgr.setIntProperty(33284, 1, paramInt);
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
/*     */   public ApiResult CB_HudDispModSetgReq(int paramInt) {
/* 142 */     ApiResult apiResult = ApiResult.FAILED;
/* 143 */     if (DispModSetgReq.isValid(paramInt)) {
/* 144 */       apiResult = this.mMgr.setIntProperty(33285, 1, paramInt);
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
/*     */   public ApiResult CB_PrkgIndcrLineReq(int paramInt) {
/* 158 */     ApiResult apiResult = ApiResult.FAILED;
/* 159 */     if (OnOff1.isValid(paramInt)) {
/* 160 */       apiResult = this.mMgr.setIntProperty(33286, 1, paramInt);
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
/*     */   public ApiResult CB_SurrndgsObjDetnReq(int paramInt) {
/* 174 */     ApiResult apiResult = ApiResult.FAILED;
/* 175 */     if (OnOff1.isValid(paramInt)) {
/* 176 */       apiResult = this.mMgr.setIntProperty(33287, 1, paramInt);
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
/*     */   public ApiResult CB_ThrDTouringViewReq(int paramInt) {
/* 190 */     ApiResult apiResult = ApiResult.FAILED;
/* 191 */     if (OnOff1.isValid(paramInt)) {
/* 192 */       apiResult = this.mMgr.setIntProperty(33288, 1, paramInt);
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
/*     */   public ApiResult CB_TopVisnDispExtnReq(int paramInt) {
/* 206 */     ApiResult apiResult = ApiResult.FAILED;
/* 207 */     if (OnOff1.isValid(paramInt)) {
/* 208 */       apiResult = this.mMgr.setIntProperty(33289, 1, paramInt);
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
/*     */   public ApiResult CB_TurnEntryAgWideVisReq(int paramInt) {
/* 222 */     ApiResult apiResult = ApiResult.FAILED;
/* 223 */     if (OnOff1.isValid(paramInt)) {
/* 224 */       apiResult = this.mMgr.setIntProperty(33290, 1, paramInt);
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
/*     */   public ApiResult CB_VehMdlClrReq(int paramInt) {
/* 238 */     ApiResult apiResult = ApiResult.FAILED;
/* 239 */     if (OnOff1.isValid(paramInt)) {
/* 240 */       apiResult = this.mMgr.setIntProperty(33291, 1, paramInt);
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
/*     */   
/*     */   public PATypes.PA_CnclFaceReqForProf getPA_CnclFaceReqForProf() throws CarNotConnectedException {
/* 255 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33964, 1);
/*     */     
/* 257 */     PATypes.PA_CnclFaceReqForProf pA_CnclFaceReqForProf = null;
/*     */     try {
/* 259 */       PATypes.PA_CnclFaceReqForProf pA_CnclFaceReqForProf1 = new PATypes.PA_CnclFaceReqForProf(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CnclFaceReqForProf = pA_CnclFaceReqForProf1;
/* 260 */     } catch (Exception exception) {}
/*     */     
/* 262 */     return pA_CnclFaceReqForProf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FaceIdnReq getPA_FaceIdnReq() throws CarNotConnectedException {
/* 271 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33965, 1);
/*     */     
/* 273 */     PATypes.PA_FaceIdnReq pA_FaceIdnReq = null;
/*     */     try {
/* 275 */       PATypes.PA_FaceIdnReq pA_FaceIdnReq1 = new PATypes.PA_FaceIdnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FaceIdnReq = pA_FaceIdnReq1;
/* 276 */     } catch (Exception exception) {}
/*     */     
/* 278 */     return pA_FaceIdnReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FaceSgnInForProf getPA_FaceSgnInForProf() throws CarNotConnectedException {
/* 287 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33966, 1);
/*     */     
/* 289 */     PATypes.PA_FaceSgnInForProf pA_FaceSgnInForProf = null;
/*     */     try {
/* 291 */       PATypes.PA_FaceSgnInForProf pA_FaceSgnInForProf1 = new PATypes.PA_FaceSgnInForProf(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FaceSgnInForProf = pA_FaceSgnInForProf1;
/* 292 */     } catch (Exception exception) {}
/*     */     
/* 294 */     return pA_FaceSgnInForProf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_HudDispModSetgReq getPA_HudDispModSetgReq() throws CarNotConnectedException {
/* 303 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33967, 1);
/*     */     
/* 305 */     PATypes.PA_HudDispModSetgReq pA_HudDispModSetgReq = null;
/*     */     try {
/* 307 */       PATypes.PA_HudDispModSetgReq pA_HudDispModSetgReq1 = new PATypes.PA_HudDispModSetgReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HudDispModSetgReq = pA_HudDispModSetgReq1;
/* 308 */     } catch (Exception exception) {}
/*     */     
/* 310 */     return pA_HudDispModSetgReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PrkgIndcrLineReq getPA_PrkgIndcrLineReq() throws CarNotConnectedException {
/* 319 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33968, 1);
/*     */     
/* 321 */     PATypes.PA_PrkgIndcrLineReq pA_PrkgIndcrLineReq = null;
/*     */     try {
/* 323 */       PATypes.PA_PrkgIndcrLineReq pA_PrkgIndcrLineReq1 = new PATypes.PA_PrkgIndcrLineReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PrkgIndcrLineReq = pA_PrkgIndcrLineReq1;
/* 324 */     } catch (Exception exception) {}
/*     */     
/* 326 */     return pA_PrkgIndcrLineReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SurrndgsObjDetnReq getPA_SurrndgsObjDetnReq() throws CarNotConnectedException {
/* 335 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33969, 1);
/*     */     
/* 337 */     PATypes.PA_SurrndgsObjDetnReq pA_SurrndgsObjDetnReq = null;
/*     */     try {
/* 339 */       PATypes.PA_SurrndgsObjDetnReq pA_SurrndgsObjDetnReq1 = new PATypes.PA_SurrndgsObjDetnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SurrndgsObjDetnReq = pA_SurrndgsObjDetnReq1;
/* 340 */     } catch (Exception exception) {}
/*     */     
/* 342 */     return pA_SurrndgsObjDetnReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_ThrDTouringViewReq getPA_ThrDTouringViewReq() throws CarNotConnectedException {
/* 351 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33970, 1);
/*     */     
/* 353 */     PATypes.PA_ThrDTouringViewReq pA_ThrDTouringViewReq = null;
/*     */     try {
/* 355 */       PATypes.PA_ThrDTouringViewReq pA_ThrDTouringViewReq1 = new PATypes.PA_ThrDTouringViewReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ThrDTouringViewReq = pA_ThrDTouringViewReq1;
/* 356 */     } catch (Exception exception) {}
/*     */     
/* 358 */     return pA_ThrDTouringViewReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TopVisnDispExtnReq getPA_TopVisnDispExtnReq() throws CarNotConnectedException {
/* 367 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33971, 1);
/*     */     
/* 369 */     PATypes.PA_TopVisnDispExtnReq pA_TopVisnDispExtnReq = null;
/*     */     try {
/* 371 */       PATypes.PA_TopVisnDispExtnReq pA_TopVisnDispExtnReq1 = new PATypes.PA_TopVisnDispExtnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TopVisnDispExtnReq = pA_TopVisnDispExtnReq1;
/* 372 */     } catch (Exception exception) {}
/*     */     
/* 374 */     return pA_TopVisnDispExtnReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TurnEntryAgWideVisReq getPA_TurnEntryAgWideVisReq() throws CarNotConnectedException {
/* 383 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33972, 1);
/*     */     
/* 385 */     PATypes.PA_TurnEntryAgWideVisReq pA_TurnEntryAgWideVisReq = null;
/*     */     try {
/* 387 */       PATypes.PA_TurnEntryAgWideVisReq pA_TurnEntryAgWideVisReq1 = new PATypes.PA_TurnEntryAgWideVisReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TurnEntryAgWideVisReq = pA_TurnEntryAgWideVisReq1;
/* 388 */     } catch (Exception exception) {}
/*     */     
/* 390 */     return pA_TurnEntryAgWideVisReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehMdlClrReq getPA_VehMdlClrReq() throws CarNotConnectedException {
/* 399 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33973, 1);
/*     */     
/* 401 */     PATypes.PA_VehMdlClrReq pA_VehMdlClrReq = null;
/*     */     try {
/* 403 */       PATypes.PA_VehMdlClrReq pA_VehMdlClrReq1 = new PATypes.PA_VehMdlClrReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehMdlClrReq = pA_VehMdlClrReq1;
/* 404 */     } catch (Exception exception) {}
/*     */     
/* 406 */     return pA_VehMdlClrReq;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarProfiletransferManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */