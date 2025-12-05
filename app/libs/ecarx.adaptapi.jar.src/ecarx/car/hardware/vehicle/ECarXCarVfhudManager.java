/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.Inact;
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
/*     */ 
/*     */ public class ECarXCarVfhudManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbhuddispmodset = 33274;
/*     */   public static final int ManagerId_cbvfhudactvreq = 32925;
/*     */   public static final int ManagerId_cbvfhudaractvreq = 32931;
/*     */   public static final int ManagerId_cbvfhudergoadjmtreq = 32927;
/*     */   public static final int ManagerId_cbvfhudhudrstforsetganddata = 32929;
/*     */   public static final int ManagerId_cbvfhudhudsnowmodereq = 32930;
/*     */   public static final int ManagerId_cbvfhudillmnreq = 32926;
/*     */   public static final int ManagerId_cbvfhudimgrotadjmtreq = 32928;
/*     */   public static final int ManagerId_cbvfhudreboot = 32932;
/*     */   public static final int ManagerId_pahuddispmodset = 33931;
/*     */   public static final int ManagerId_pahudmsgend = 33916;
/*     */   public static final int ManagerId_pavfhudactvsts = 33499;
/*     */   public static final int ManagerId_pavfhudaractvsts = 33505;
/*     */   public static final int ManagerId_pavfhudard300data = 33506;
/*     */   public static final int ManagerId_pavfhudard310data = 33507;
/*     */   public static final int ManagerId_pavfhudard311data = 33508;
/*     */   public static final int ManagerId_pavfhudergoadjmtreq = 33501;
/*     */   public static final int ManagerId_pavfhudhudrstforsetganddata = 33503;
/*     */   public static final int ManagerId_pavfhudhudsnowmodereq = 33504;
/*     */   public static final int ManagerId_pavfhudillmnreq = 33500;
/*     */   public static final int ManagerId_pavfhudimgrotadjmtreq = 33502;
/*     */   private static final String TAG = "ECarXCarVfhudManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarVfhudManager() {}
/*     */   
/*     */   public ECarXCarVfhudManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  74 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VF_HUD_ActvReq(int paramInt) {
/*  84 */     ApiResult apiResult = ApiResult.FAILED;
/*  85 */     if (OnOff1.isValid(paramInt)) {
/*  86 */       apiResult = this.mMgr.setIntProperty(32925, 1, paramInt);
/*     */     } else {
/*  88 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  90 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VF_HUD_IllmnReq(int paramInt) {
/* 100 */     ApiResult apiResult = ApiResult.FAILED;
/* 101 */     if (Inact.isValid(paramInt)) {
/* 102 */       apiResult = this.mMgr.setIntProperty(32926, 1, paramInt);
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
/*     */   public ApiResult CB_VF_HUD_ErgoAdjmtReq(int paramInt) {
/* 116 */     ApiResult apiResult = ApiResult.FAILED;
/* 117 */     if (Inact.isValid(paramInt)) {
/* 118 */       apiResult = this.mMgr.setIntProperty(32927, 1, paramInt);
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
/*     */   public ApiResult CB_VF_HUD_ImgRotAdjmtReq(int paramInt) {
/* 132 */     ApiResult apiResult = ApiResult.FAILED;
/* 133 */     if (Inact.isValid(paramInt)) {
/* 134 */       apiResult = this.mMgr.setIntProperty(32928, 1, paramInt);
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
/*     */   public ApiResult CB_VF_HUD_HudRstForSetgAndData(int paramInt) {
/* 148 */     ApiResult apiResult = ApiResult.FAILED;
/* 149 */     if (OnOff1.isValid(paramInt)) {
/* 150 */       apiResult = this.mMgr.setIntProperty(32929, 1, paramInt);
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
/*     */   public ApiResult CB_VF_HUD_HudSnowModeReq(int paramInt) {
/* 164 */     ApiResult apiResult = ApiResult.FAILED;
/* 165 */     if (OnOff1.isValid(paramInt)) {
/* 166 */       apiResult = this.mMgr.setIntProperty(32930, 1, paramInt);
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
/*     */   public ApiResult CB_VF_HUD_ARActvReq(int paramInt) {
/* 180 */     ApiResult apiResult = ApiResult.FAILED;
/* 181 */     if (OnOff1.isValid(paramInt)) {
/* 182 */       apiResult = this.mMgr.setIntProperty(32931, 1, paramInt);
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
/*     */   public ApiResult CB_VF_HUD_Reboot(int paramInt) {
/* 196 */     return this.mMgr.setIntProperty(32932, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_HUD_DispModSet(int paramInt) {
/* 206 */     return this.mMgr.setIntProperty(33274, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_ActvSts getPA_VF_HUD_ActvSts() throws CarNotConnectedException {
/* 217 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33499, 1);
/*     */     
/* 219 */     PATypes.PA_VF_HUD_ActvSts pA_VF_HUD_ActvSts = null;
/*     */     try {
/* 221 */       PATypes.PA_VF_HUD_ActvSts pA_VF_HUD_ActvSts1 = new PATypes.PA_VF_HUD_ActvSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VF_HUD_ActvSts = pA_VF_HUD_ActvSts1;
/* 222 */     } catch (Exception exception) {}
/*     */     
/* 224 */     return pA_VF_HUD_ActvSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_IllmnReq getPA_VF_HUD_IllmnReq() throws CarNotConnectedException {
/* 233 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33500, 1);
/*     */     
/* 235 */     PATypes.PA_VF_HUD_IllmnReq pA_VF_HUD_IllmnReq = null;
/*     */     try {
/* 237 */       PATypes.PA_VF_HUD_IllmnReq pA_VF_HUD_IllmnReq1 = new PATypes.PA_VF_HUD_IllmnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VF_HUD_IllmnReq = pA_VF_HUD_IllmnReq1;
/* 238 */     } catch (Exception exception) {}
/*     */     
/* 240 */     return pA_VF_HUD_IllmnReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_ErgoAdjmtReq getPA_VF_HUD_ErgoAdjmtReq() throws CarNotConnectedException {
/* 249 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33501, 1);
/*     */     
/* 251 */     PATypes.PA_VF_HUD_ErgoAdjmtReq pA_VF_HUD_ErgoAdjmtReq = null;
/*     */     try {
/* 253 */       PATypes.PA_VF_HUD_ErgoAdjmtReq pA_VF_HUD_ErgoAdjmtReq1 = new PATypes.PA_VF_HUD_ErgoAdjmtReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VF_HUD_ErgoAdjmtReq = pA_VF_HUD_ErgoAdjmtReq1;
/* 254 */     } catch (Exception exception) {}
/*     */     
/* 256 */     return pA_VF_HUD_ErgoAdjmtReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_ImgRotAdjmtReq getPA_VF_HUD_ImgRotAdjmtReq() throws CarNotConnectedException {
/* 265 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33502, 1);
/*     */     
/* 267 */     PATypes.PA_VF_HUD_ImgRotAdjmtReq pA_VF_HUD_ImgRotAdjmtReq = null;
/*     */     try {
/* 269 */       PATypes.PA_VF_HUD_ImgRotAdjmtReq pA_VF_HUD_ImgRotAdjmtReq1 = new PATypes.PA_VF_HUD_ImgRotAdjmtReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VF_HUD_ImgRotAdjmtReq = pA_VF_HUD_ImgRotAdjmtReq1;
/* 270 */     } catch (Exception exception) {}
/*     */     
/* 272 */     return pA_VF_HUD_ImgRotAdjmtReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_HudRstForSetgAndData getPA_VF_HUD_HudRstForSetgAndData() throws CarNotConnectedException {
/* 281 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33503, 1);
/*     */     
/* 283 */     PATypes.PA_VF_HUD_HudRstForSetgAndData pA_VF_HUD_HudRstForSetgAndData = null;
/*     */     try {
/* 285 */       PATypes.PA_VF_HUD_HudRstForSetgAndData pA_VF_HUD_HudRstForSetgAndData1 = new PATypes.PA_VF_HUD_HudRstForSetgAndData(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VF_HUD_HudRstForSetgAndData = pA_VF_HUD_HudRstForSetgAndData1;
/* 286 */     } catch (Exception exception) {}
/*     */     
/* 288 */     return pA_VF_HUD_HudRstForSetgAndData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_HudSnowModeReq getPA_VF_HUD_HudSnowModeReq() throws CarNotConnectedException {
/* 297 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33504, 1);
/*     */     
/* 299 */     PATypes.PA_VF_HUD_HudSnowModeReq pA_VF_HUD_HudSnowModeReq = null;
/*     */     try {
/* 301 */       PATypes.PA_VF_HUD_HudSnowModeReq pA_VF_HUD_HudSnowModeReq1 = new PATypes.PA_VF_HUD_HudSnowModeReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VF_HUD_HudSnowModeReq = pA_VF_HUD_HudSnowModeReq1;
/* 302 */     } catch (Exception exception) {}
/*     */     
/* 304 */     return pA_VF_HUD_HudSnowModeReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_ARActvSts getPA_VF_HUD_ARActvSts() throws CarNotConnectedException {
/* 313 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33505, 1);
/*     */     
/* 315 */     PATypes.PA_VF_HUD_ARActvSts pA_VF_HUD_ARActvSts = null;
/*     */     try {
/* 317 */       PATypes.PA_VF_HUD_ARActvSts pA_VF_HUD_ARActvSts1 = new PATypes.PA_VF_HUD_ARActvSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VF_HUD_ARActvSts = pA_VF_HUD_ARActvSts1;
/* 318 */     } catch (Exception exception) {}
/*     */     
/* 320 */     return pA_VF_HUD_ARActvSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_ARD300Data getPA_VF_HUD_ARD300Data() throws CarNotConnectedException {
/* 329 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33506, 1);
/*     */     
/* 331 */     PATypes.PA_VF_HUD_ARD300Data pA_VF_HUD_ARD300Data = null;
/*     */     try {
/* 333 */       PATypes.PA_VF_HUD_ARD300Data pA_VF_HUD_ARD300Data1 = new PATypes.PA_VF_HUD_ARD300Data(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_VF_HUD_ARD300Data = pA_VF_HUD_ARD300Data1;
/* 334 */     } catch (Exception exception) {}
/*     */     
/* 336 */     return pA_VF_HUD_ARD300Data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_ARD310Data getPA_VF_HUD_ARD310Data() throws CarNotConnectedException {
/* 345 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33507, 1);
/*     */     
/* 347 */     PATypes.PA_VF_HUD_ARD310Data pA_VF_HUD_ARD310Data = null;
/*     */     try {
/* 349 */       PATypes.PA_VF_HUD_ARD310Data pA_VF_HUD_ARD310Data1 = new PATypes.PA_VF_HUD_ARD310Data(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_VF_HUD_ARD310Data = pA_VF_HUD_ARD310Data1;
/* 350 */     } catch (Exception exception) {}
/*     */     
/* 352 */     return pA_VF_HUD_ARD310Data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VF_HUD_ARD311Data getPA_VF_HUD_ARD311Data() throws CarNotConnectedException {
/* 361 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33508, 1);
/*     */     
/* 363 */     PATypes.PA_VF_HUD_ARD311Data pA_VF_HUD_ARD311Data = null;
/*     */     try {
/* 365 */       PATypes.PA_VF_HUD_ARD311Data pA_VF_HUD_ARD311Data1 = new PATypes.PA_VF_HUD_ARD311Data(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_VF_HUD_ARD311Data = pA_VF_HUD_ARD311Data1;
/* 366 */     } catch (Exception exception) {}
/*     */     
/* 368 */     return pA_VF_HUD_ARD311Data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_HUD_MsgEnd getPA_HUD_MsgEnd() throws CarNotConnectedException {
/* 377 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33916, 1);
/*     */     
/* 379 */     PATypes.PA_HUD_MsgEnd pA_HUD_MsgEnd = null;
/*     */     try {
/* 381 */       PATypes.PA_HUD_MsgEnd pA_HUD_MsgEnd1 = new PATypes.PA_HUD_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HUD_MsgEnd = pA_HUD_MsgEnd1;
/* 382 */     } catch (Exception exception) {}
/*     */     
/* 384 */     return pA_HUD_MsgEnd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_HUD_DispModSet getPA_HUD_DispModSet() throws CarNotConnectedException {
/* 393 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33931, 1);
/*     */     
/* 395 */     PATypes.PA_HUD_DispModSet pA_HUD_DispModSet = null;
/*     */     try {
/* 397 */       PATypes.PA_HUD_DispModSet pA_HUD_DispModSet1 = new PATypes.PA_HUD_DispModSet(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HUD_DispModSet = pA_HUD_DispModSet1;
/* 398 */     } catch (Exception exception) {}
/*     */     
/* 400 */     return pA_HUD_DispModSet;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVfhudManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */