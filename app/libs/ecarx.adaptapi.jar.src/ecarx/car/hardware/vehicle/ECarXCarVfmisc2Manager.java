/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.annotation.PsdNotPsd1;
/*     */ import ecarx.car.hardware.annotation.WinAndRoofAndCurtPosnTyp;
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
/*     */ public class ECarXCarVfmisc2Manager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbclosesuncurtainbtn = 33201;
/*     */   public static final int ManagerId_cbclosesunroofbtn = 33199;
/*     */   public static final int ManagerId_cbhmicarlocatorsetreq = 33206;
/*     */   public static final int ManagerId_cbopensuncurtainbtn = 33200;
/*     */   public static final int ManagerId_cbopensunroofbtn = 33198;
/*     */   public static final int ManagerId_cbsuncurtainsetting = 33197;
/*     */   public static final int ManagerId_cbsuncurtopenposnreq = 33203;
/*     */   public static final int ManagerId_cbsunroofopenposnreq = 33202;
/*     */   public static final int ManagerId_cbsunrooftiltreq = 33204;
/*     */   public static final int ManagerId_cbvfmisc2reboot = 33205;
/*     */   public static final int ManagerId_paclosesuncurtainbtn = 33808;
/*     */   public static final int ManagerId_paclosesunroofbtn = 33806;
/*     */   public static final int ManagerId_pahmicarlocatorsetreq = 33814;
/*     */   public static final int ManagerId_paopensuncurtainbtn = 33807;
/*     */   public static final int ManagerId_paopensunroofbtn = 33805;
/*     */   public static final int ManagerId_pasuncurtainposnsts = 33810;
/*     */   public static final int ManagerId_pasuncurtainsetting = 33804;
/*     */   public static final int ManagerId_pasuncurtopenposnreq = 33812;
/*     */   public static final int ManagerId_pasunroofopenposnreq = 33811;
/*     */   public static final int ManagerId_pasunroofposnsts = 33809;
/*     */   public static final int ManagerId_pasunrooftiltreq = 33813;
/*     */   public static final int ManagerId_pavm2msgend = 33924;
/*     */   private static final String TAG = "ECarXCarVfmisc2Manager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarVfmisc2Manager() {}
/*     */   
/*     */   public ECarXCarVfmisc2Manager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  75 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SunCurtain_Setting(int paramInt) {
/*  85 */     ApiResult apiResult = ApiResult.FAILED;
/*  86 */     if (OnOff1.isValid(paramInt)) {
/*  87 */       apiResult = this.mMgr.setIntProperty(33197, 1, paramInt);
/*     */     } else {
/*  89 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  91 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_OpenSunRoof_Btn(int paramInt) {
/* 101 */     ApiResult apiResult = ApiResult.FAILED;
/* 102 */     if (PsdNotPsd1.isValid(paramInt)) {
/* 103 */       apiResult = this.mMgr.setIntProperty(33198, 1, paramInt);
/*     */     } else {
/* 105 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 107 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_CloseSunRoof_Btn(int paramInt) {
/* 117 */     ApiResult apiResult = ApiResult.FAILED;
/* 118 */     if (PsdNotPsd1.isValid(paramInt)) {
/* 119 */       apiResult = this.mMgr.setIntProperty(33199, 1, paramInt);
/*     */     } else {
/* 121 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 123 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_OpenSunCurtain_Btn(int paramInt) {
/* 133 */     ApiResult apiResult = ApiResult.FAILED;
/* 134 */     if (PsdNotPsd1.isValid(paramInt)) {
/* 135 */       apiResult = this.mMgr.setIntProperty(33200, 1, paramInt);
/*     */     } else {
/* 137 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 139 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_CloseSunCurtain_Btn(int paramInt) {
/* 149 */     ApiResult apiResult = ApiResult.FAILED;
/* 150 */     if (PsdNotPsd1.isValid(paramInt)) {
/* 151 */       apiResult = this.mMgr.setIntProperty(33201, 1, paramInt);
/*     */     } else {
/* 153 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 155 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SunRoofOpenPosnReq(int paramInt) {
/* 165 */     ApiResult apiResult = ApiResult.FAILED;
/* 166 */     if (WinAndRoofAndCurtPosnTyp.isValid(paramInt)) {
/* 167 */       apiResult = this.mMgr.setIntProperty(33202, 1, paramInt);
/*     */     } else {
/* 169 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 171 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SunCurtOpenPosnReq(int paramInt) {
/* 181 */     ApiResult apiResult = ApiResult.FAILED;
/* 182 */     if (WinAndRoofAndCurtPosnTyp.isValid(paramInt)) {
/* 183 */       apiResult = this.mMgr.setIntProperty(33203, 1, paramInt);
/*     */     } else {
/* 185 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 187 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SunRoofTiltReq(int paramInt) {
/* 197 */     ApiResult apiResult = ApiResult.FAILED;
/* 198 */     if (OnOff1.isValid(paramInt)) {
/* 199 */       apiResult = this.mMgr.setIntProperty(33204, 1, paramInt);
/*     */     } else {
/* 201 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 203 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFMisc2_Reboot(int paramInt) {
/* 213 */     return this.mMgr.setIntProperty(33205, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_HmiCarLocatorSetReq(int paramInt) {
/* 223 */     ApiResult apiResult = ApiResult.FAILED;
/* 224 */     if (OnOff1.isValid(paramInt)) {
/* 225 */       apiResult = this.mMgr.setIntProperty(33206, 1, paramInt);
/*     */     } else {
/* 227 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 229 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SunCurtain_Setting getPA_SunCurtain_Setting() throws CarNotConnectedException {
/* 240 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33804, 1);
/*     */     
/* 242 */     PATypes.PA_SunCurtain_Setting pA_SunCurtain_Setting = null;
/*     */     try {
/* 244 */       PATypes.PA_SunCurtain_Setting pA_SunCurtain_Setting1 = new PATypes.PA_SunCurtain_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SunCurtain_Setting = pA_SunCurtain_Setting1;
/* 245 */     } catch (Exception exception) {}
/*     */     
/* 247 */     return pA_SunCurtain_Setting;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_OpenSunRoof_Btn getPA_OpenSunRoof_Btn() throws CarNotConnectedException {
/* 256 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33805, 1);
/*     */     
/* 258 */     PATypes.PA_OpenSunRoof_Btn pA_OpenSunRoof_Btn = null;
/*     */     try {
/* 260 */       PATypes.PA_OpenSunRoof_Btn pA_OpenSunRoof_Btn1 = new PATypes.PA_OpenSunRoof_Btn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_OpenSunRoof_Btn = pA_OpenSunRoof_Btn1;
/* 261 */     } catch (Exception exception) {}
/*     */     
/* 263 */     return pA_OpenSunRoof_Btn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_CloseSunRoof_Btn getPA_CloseSunRoof_Btn() throws CarNotConnectedException {
/* 272 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33806, 1);
/*     */     
/* 274 */     PATypes.PA_CloseSunRoof_Btn pA_CloseSunRoof_Btn = null;
/*     */     try {
/* 276 */       PATypes.PA_CloseSunRoof_Btn pA_CloseSunRoof_Btn1 = new PATypes.PA_CloseSunRoof_Btn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CloseSunRoof_Btn = pA_CloseSunRoof_Btn1;
/* 277 */     } catch (Exception exception) {}
/*     */     
/* 279 */     return pA_CloseSunRoof_Btn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_OpenSunCurtain_Btn getPA_OpenSunCurtain_Btn() throws CarNotConnectedException {
/* 288 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33807, 1);
/*     */     
/* 290 */     PATypes.PA_OpenSunCurtain_Btn pA_OpenSunCurtain_Btn = null;
/*     */     try {
/* 292 */       PATypes.PA_OpenSunCurtain_Btn pA_OpenSunCurtain_Btn1 = new PATypes.PA_OpenSunCurtain_Btn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_OpenSunCurtain_Btn = pA_OpenSunCurtain_Btn1;
/* 293 */     } catch (Exception exception) {}
/*     */     
/* 295 */     return pA_OpenSunCurtain_Btn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_CloseSunCurtain_Btn getPA_CloseSunCurtain_Btn() throws CarNotConnectedException {
/* 304 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33808, 1);
/*     */     
/* 306 */     PATypes.PA_CloseSunCurtain_Btn pA_CloseSunCurtain_Btn = null;
/*     */     try {
/* 308 */       PATypes.PA_CloseSunCurtain_Btn pA_CloseSunCurtain_Btn1 = new PATypes.PA_CloseSunCurtain_Btn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CloseSunCurtain_Btn = pA_CloseSunCurtain_Btn1;
/* 309 */     } catch (Exception exception) {}
/*     */     
/* 311 */     return pA_CloseSunCurtain_Btn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SunRoofPosnSts getPA_SunRoofPosnSts() throws CarNotConnectedException {
/* 320 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33809, 1);
/*     */     
/* 322 */     PATypes.PA_SunRoofPosnSts pA_SunRoofPosnSts = null;
/*     */     try {
/* 324 */       PATypes.PA_SunRoofPosnSts pA_SunRoofPosnSts1 = new PATypes.PA_SunRoofPosnSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SunRoofPosnSts = pA_SunRoofPosnSts1;
/* 325 */     } catch (Exception exception) {}
/*     */     
/* 327 */     return pA_SunRoofPosnSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SunCurtainPosnSts getPA_SunCurtainPosnSts() throws CarNotConnectedException {
/* 336 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33810, 1);
/*     */     
/* 338 */     PATypes.PA_SunCurtainPosnSts pA_SunCurtainPosnSts = null;
/*     */     try {
/* 340 */       PATypes.PA_SunCurtainPosnSts pA_SunCurtainPosnSts1 = new PATypes.PA_SunCurtainPosnSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SunCurtainPosnSts = pA_SunCurtainPosnSts1;
/* 341 */     } catch (Exception exception) {}
/*     */     
/* 343 */     return pA_SunCurtainPosnSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SunRoofOpenPosnReq getPA_SunRoofOpenPosnReq() throws CarNotConnectedException {
/* 352 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33811, 1);
/*     */     
/* 354 */     PATypes.PA_SunRoofOpenPosnReq pA_SunRoofOpenPosnReq = null;
/*     */     try {
/* 356 */       PATypes.PA_SunRoofOpenPosnReq pA_SunRoofOpenPosnReq1 = new PATypes.PA_SunRoofOpenPosnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SunRoofOpenPosnReq = pA_SunRoofOpenPosnReq1;
/* 357 */     } catch (Exception exception) {}
/*     */     
/* 359 */     return pA_SunRoofOpenPosnReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SunCurtOpenPosnReq getPA_SunCurtOpenPosnReq() throws CarNotConnectedException {
/* 368 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33812, 1);
/*     */     
/* 370 */     PATypes.PA_SunCurtOpenPosnReq pA_SunCurtOpenPosnReq = null;
/*     */     try {
/* 372 */       PATypes.PA_SunCurtOpenPosnReq pA_SunCurtOpenPosnReq1 = new PATypes.PA_SunCurtOpenPosnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SunCurtOpenPosnReq = pA_SunCurtOpenPosnReq1;
/* 373 */     } catch (Exception exception) {}
/*     */     
/* 375 */     return pA_SunCurtOpenPosnReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SunRoofTiltReq getPA_SunRoofTiltReq() throws CarNotConnectedException {
/* 384 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33813, 1);
/*     */     
/* 386 */     PATypes.PA_SunRoofTiltReq pA_SunRoofTiltReq = null;
/*     */     try {
/* 388 */       PATypes.PA_SunRoofTiltReq pA_SunRoofTiltReq1 = new PATypes.PA_SunRoofTiltReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SunRoofTiltReq = pA_SunRoofTiltReq1;
/* 389 */     } catch (Exception exception) {}
/*     */     
/* 391 */     return pA_SunRoofTiltReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_HmiCarLocatorSetReq getPA_HmiCarLocatorSetReq() throws CarNotConnectedException {
/* 400 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33814, 1);
/*     */     
/* 402 */     PATypes.PA_HmiCarLocatorSetReq pA_HmiCarLocatorSetReq = null;
/*     */     try {
/* 404 */       PATypes.PA_HmiCarLocatorSetReq pA_HmiCarLocatorSetReq1 = new PATypes.PA_HmiCarLocatorSetReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HmiCarLocatorSetReq = pA_HmiCarLocatorSetReq1;
/* 405 */     } catch (Exception exception) {}
/*     */     
/* 407 */     return pA_HmiCarLocatorSetReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VM2_MsgEnd getPA_VM2_MsgEnd() throws CarNotConnectedException {
/* 416 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33924, 1);
/*     */     
/* 418 */     PATypes.PA_VM2_MsgEnd pA_VM2_MsgEnd = null;
/*     */     try {
/* 420 */       PATypes.PA_VM2_MsgEnd pA_VM2_MsgEnd1 = new PATypes.PA_VM2_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VM2_MsgEnd = pA_VM2_MsgEnd1;
/* 421 */     } catch (Exception exception) {}
/*     */     
/* 423 */     return pA_VM2_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVfmisc2Manager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */