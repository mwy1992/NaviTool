/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.InhibitApSwdlType;
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
/*     */ public class ECarXCarDiagproxyManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbapdiaggwready = 33147;
/*     */   public static final int ManagerId_cbcsdgwresponse = 33142;
/*     */   public static final int ManagerId_cbcsdmgwresponse = 33148;
/*     */   public static final int ManagerId_cbdcmc00esalkeymanagement = 33143;
/*     */   public static final int ManagerId_cbdcmc00fsalsystemaccess = 33144;
/*     */   public static final int ManagerId_cbdcmc012salotaevents = 33145;
/*     */   public static final int ManagerId_cbdcmcncap = 33140;
/*     */   public static final int ManagerId_cbdcmcncapvp = 33141;
/*     */   public static final int ManagerId_cbdcmd02evlanpriority = 33128;
/*     */   public static final int ManagerId_cbdcmded0customersettingparameters = 33129;
/*     */   public static final int ManagerId_cbdcmded1systemadaptiondata = 33130;
/*     */   public static final int ManagerId_cbdcmf12eecusoftwarepartnumbersihuaploadmodulepartnumber = 33131;
/*     */   public static final int ManagerId_cbdcmf12eecusoftwarepartnumbersihuaplocalconfigpartnumber = 33134;
/*     */   public static final int ManagerId_cbdcmf12eecusoftwarepartnumbersihulanguagedbpartnumber = 33132;
/*     */   public static final int ManagerId_cbdcmf12eecusoftwarepartnumbersihumapdatapartnumber = 33133;
/*     */   public static final int ManagerId_cbdcmf1aeecusoftwarepartnumbersgeelyihuaploadmodulepartnumber = 33135;
/*     */   public static final int ManagerId_cbdcmf1aeecusoftwarepartnumbersgeelyihuaplocalconfigpartnumber = 33138;
/*     */   public static final int ManagerId_cbdcmf1aeecusoftwarepartnumbersgeelyihulanguagedbpartnumber = 33136;
/*     */   public static final int ManagerId_cbdcmf1aeecusoftwarepartnumbersgeelyihumapdatapartnumber = 33137;
/*     */   public static final int ManagerId_cbdcminhibitapswdl = 33139;
/*     */   public static final int ManagerId_cbdiagproxyreboot = 33146;
/*     */   public static final int ManagerId_cbpsdgwresponse = 33149;
/*     */   public static final int ManagerId_cbsetccinfo = 33272;
/*     */   public static final int ManagerId_padiagproxycsdgwfun = 33719;
/*     */   public static final int ManagerId_padiagproxycsdgwphy = 33718;
/*     */   public static final int ManagerId_padiagproxycsdmgwfun = 33721;
/*     */   public static final int ManagerId_padiagproxycsdmgwphy = 33720;
/*     */   public static final int ManagerId_padiagproxymsgend = 33905;
/*     */   public static final int ManagerId_padiagproxypsdgwfun = 33723;
/*     */   public static final int ManagerId_padiagproxypsdgwphy = 33722;
/*     */   public static final int ManagerId_padiagproxystatus = 33717;
/*     */   private static final String TAG = "ECarXCarDiagproxyManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDiagproxyManager() {}
/*     */   
/*     */   public ECarXCarDiagproxyManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  83 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_D02E_VLANPriority(byte[] paramArrayOfbyte) {
/*  92 */     this.mMgr.setbytesProperty(33128, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_DED0_CustomerSettingParameters(byte[] paramArrayOfbyte) {
/* 101 */     this.mMgr.setbytesProperty(33129, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_DED1_SystemAdaptionData(byte[] paramArrayOfbyte) {
/* 110 */     this.mMgr.setbytesProperty(33130, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F12E_ECUSoftwarePartNumbers_IHUAPLoadModulePartNumber(byte[] paramArrayOfbyte) {
/* 119 */     this.mMgr.setbytesProperty(33131, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F12E_ECUSoftwarePartNumbers_IHULanguageDBPartNumber(byte[] paramArrayOfbyte) {
/* 128 */     this.mMgr.setbytesProperty(33132, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F12E_ECUSoftwarePartNumbers_IHUMapDataPartNumber(byte[] paramArrayOfbyte) {
/* 137 */     this.mMgr.setbytesProperty(33133, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F12E_ECUSoftwarePartNumbers_IHUAPLocalConfigPartNumber(byte[] paramArrayOfbyte) {
/* 146 */     this.mMgr.setbytesProperty(33134, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F1AE_ECUSoftwarePartNumbersGeely_IHUAPLoadModulePartNumber(byte[] paramArrayOfbyte) {
/* 155 */     this.mMgr.setbytesProperty(33135, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F1AE_ECUSoftwarePartNumbersGeely_IHULanguageDBPartNumber(byte[] paramArrayOfbyte) {
/* 164 */     this.mMgr.setbytesProperty(33136, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F1AE_ECUSoftwarePartNumbersGeely_IHUMapDataPartNumber(byte[] paramArrayOfbyte) {
/* 173 */     this.mMgr.setbytesProperty(33137, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_F1AE_ECUSoftwarePartNumbersGeely_IHUAPLocalConfigPartNumber(byte[] paramArrayOfbyte) {
/* 182 */     this.mMgr.setbytesProperty(33138, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dcm_Inhibit_AP_SWDL(int paramInt) {
/* 192 */     ApiResult apiResult = ApiResult.FAILED;
/* 193 */     if (InhibitApSwdlType.isValid(paramInt)) {
/* 194 */       apiResult = this.mMgr.setIntProperty(33139, 1, paramInt);
/*     */     } else {
/* 196 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 198 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_CNCAP(byte[] paramArrayOfbyte) {
/* 207 */     this.mMgr.setbytesProperty(33140, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_CNCAPVP(byte[] paramArrayOfbyte) {
/* 216 */     this.mMgr.setbytesProperty(33141, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_CSD_GW_RESPONSE(byte[] paramArrayOfbyte) {
/* 225 */     this.mMgr.setbytesProperty(33142, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_C00E_SAL_KeyManagement(byte[] paramArrayOfbyte) {
/* 234 */     this.mMgr.setbytesProperty(33143, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_C00F_SAL_SystemAccess(byte[] paramArrayOfbyte) {
/* 243 */     this.mMgr.setbytesProperty(33144, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Dcm_C012_SAL_OTAEvents(byte[] paramArrayOfbyte) {
/* 252 */     this.mMgr.setbytesProperty(33145, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DiagProxy_Reboot(int paramInt) {
/* 262 */     return this.mMgr.setIntProperty(33146, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AP_DiagGWReady(int paramInt) {
/* 272 */     return this.mMgr.setIntProperty(33147, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_CSDM_GW_RESPONSE(byte[] paramArrayOfbyte) {
/* 281 */     this.mMgr.setbytesProperty(33148, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_PSD_GW_RESPONSE(byte[] paramArrayOfbyte) {
/* 290 */     this.mMgr.setbytesProperty(33149, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_Set_CCInfo(byte[] paramArrayOfbyte) {
/* 299 */     this.mMgr.setbytesProperty(33272, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_Status getPA_DiagProxy_Status() throws CarNotConnectedException {
/* 310 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33717, 1);
/*     */     
/* 312 */     PATypes.PA_DiagProxy_Status pA_DiagProxy_Status = null;
/*     */     try {
/* 314 */       PATypes.PA_DiagProxy_Status pA_DiagProxy_Status1 = new PATypes.PA_DiagProxy_Status(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DiagProxy_Status = pA_DiagProxy_Status1;
/* 315 */     } catch (Exception exception) {}
/*     */     
/* 317 */     return pA_DiagProxy_Status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_Csd_GW_Phy getPA_DiagProxy_Csd_GW_Phy() throws CarNotConnectedException {
/* 326 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33718, 1);
/*     */     
/* 328 */     PATypes.PA_DiagProxy_Csd_GW_Phy pA_DiagProxy_Csd_GW_Phy = null;
/*     */     try {
/* 330 */       PATypes.PA_DiagProxy_Csd_GW_Phy pA_DiagProxy_Csd_GW_Phy1 = new PATypes.PA_DiagProxy_Csd_GW_Phy(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DiagProxy_Csd_GW_Phy = pA_DiagProxy_Csd_GW_Phy1;
/* 331 */     } catch (Exception exception) {}
/*     */     
/* 333 */     return pA_DiagProxy_Csd_GW_Phy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_Csd_GW_Fun getPA_DiagProxy_Csd_GW_Fun() throws CarNotConnectedException {
/* 342 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33719, 1);
/*     */     
/* 344 */     PATypes.PA_DiagProxy_Csd_GW_Fun pA_DiagProxy_Csd_GW_Fun = null;
/*     */     try {
/* 346 */       PATypes.PA_DiagProxy_Csd_GW_Fun pA_DiagProxy_Csd_GW_Fun1 = new PATypes.PA_DiagProxy_Csd_GW_Fun(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DiagProxy_Csd_GW_Fun = pA_DiagProxy_Csd_GW_Fun1;
/* 347 */     } catch (Exception exception) {}
/*     */     
/* 349 */     return pA_DiagProxy_Csd_GW_Fun;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_Csdm_GW_Phy getPA_DiagProxy_Csdm_GW_Phy() throws CarNotConnectedException {
/* 358 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33720, 1);
/*     */     
/* 360 */     PATypes.PA_DiagProxy_Csdm_GW_Phy pA_DiagProxy_Csdm_GW_Phy = null;
/*     */     try {
/* 362 */       PATypes.PA_DiagProxy_Csdm_GW_Phy pA_DiagProxy_Csdm_GW_Phy1 = new PATypes.PA_DiagProxy_Csdm_GW_Phy(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DiagProxy_Csdm_GW_Phy = pA_DiagProxy_Csdm_GW_Phy1;
/* 363 */     } catch (Exception exception) {}
/*     */     
/* 365 */     return pA_DiagProxy_Csdm_GW_Phy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_Csdm_GW_Fun getPA_DiagProxy_Csdm_GW_Fun() throws CarNotConnectedException {
/* 374 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33721, 1);
/*     */     
/* 376 */     PATypes.PA_DiagProxy_Csdm_GW_Fun pA_DiagProxy_Csdm_GW_Fun = null;
/*     */     try {
/* 378 */       PATypes.PA_DiagProxy_Csdm_GW_Fun pA_DiagProxy_Csdm_GW_Fun1 = new PATypes.PA_DiagProxy_Csdm_GW_Fun(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DiagProxy_Csdm_GW_Fun = pA_DiagProxy_Csdm_GW_Fun1;
/* 379 */     } catch (Exception exception) {}
/*     */     
/* 381 */     return pA_DiagProxy_Csdm_GW_Fun;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_Psd_GW_Phy getPA_DiagProxy_Psd_GW_Phy() throws CarNotConnectedException {
/* 390 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33722, 1);
/*     */     
/* 392 */     PATypes.PA_DiagProxy_Psd_GW_Phy pA_DiagProxy_Psd_GW_Phy = null;
/*     */     try {
/* 394 */       PATypes.PA_DiagProxy_Psd_GW_Phy pA_DiagProxy_Psd_GW_Phy1 = new PATypes.PA_DiagProxy_Psd_GW_Phy(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DiagProxy_Psd_GW_Phy = pA_DiagProxy_Psd_GW_Phy1;
/* 395 */     } catch (Exception exception) {}
/*     */     
/* 397 */     return pA_DiagProxy_Psd_GW_Phy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_Psd_GW_Fun getPA_DiagProxy_Psd_GW_Fun() throws CarNotConnectedException {
/* 406 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33723, 1);
/*     */     
/* 408 */     PATypes.PA_DiagProxy_Psd_GW_Fun pA_DiagProxy_Psd_GW_Fun = null;
/*     */     try {
/* 410 */       PATypes.PA_DiagProxy_Psd_GW_Fun pA_DiagProxy_Psd_GW_Fun1 = new PATypes.PA_DiagProxy_Psd_GW_Fun(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DiagProxy_Psd_GW_Fun = pA_DiagProxy_Psd_GW_Fun1;
/* 411 */     } catch (Exception exception) {}
/*     */     
/* 413 */     return pA_DiagProxy_Psd_GW_Fun;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DiagProxy_MsgEnd getPA_DiagProxy_MsgEnd() throws CarNotConnectedException {
/* 422 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33905, 1);
/*     */     
/* 424 */     PATypes.PA_DiagProxy_MsgEnd pA_DiagProxy_MsgEnd = null;
/*     */     try {
/* 426 */       PATypes.PA_DiagProxy_MsgEnd pA_DiagProxy_MsgEnd1 = new PATypes.PA_DiagProxy_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DiagProxy_MsgEnd = pA_DiagProxy_MsgEnd1;
/* 427 */     } catch (Exception exception) {}
/*     */     
/* 429 */     return pA_DiagProxy_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDiagproxyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */