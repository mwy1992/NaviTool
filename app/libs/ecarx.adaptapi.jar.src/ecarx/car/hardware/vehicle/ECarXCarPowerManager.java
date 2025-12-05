/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.PowerSoftKey;
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
/*     */ public class ECarXCarPowerManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbpowerapstatus = 32891;
/*     */   public static final int ManagerId_cbpowerapupdate = 32893;
/*     */   public static final int ManagerId_cbpowerbg = 32895;
/*     */   public static final int ManagerId_cbpowercsdstatus = 32903;
/*     */   public static final int ManagerId_cbpowerheartbeats = 32904;
/*     */   public static final int ManagerId_cbpowerinstallstatus = 32889;
/*     */   public static final int ManagerId_cbpoweriplminfo = 32897;
/*     */   public static final int ManagerId_cbpowerotaupdate = 32898;
/*     */   public static final int ManagerId_cbpowerphotoview = 32896;
/*     */   public static final int ManagerId_cbpowerplaypausepress = 32894;
/*     */   public static final int ManagerId_cbpowerpsdstatus = 32901;
/*     */   public static final int ManagerId_cbpowerreboot = 32900;
/*     */   public static final int ManagerId_cbpowerresetsettings = 32890;
/*     */   public static final int ManagerId_cbpowerresetusb = 32902;
/*     */   public static final int ManagerId_cbpowerrestart = 32892;
/*     */   public static final int ManagerId_cbpowersoftkey = 32899;
/*     */   public static final int ManagerId_cbpowertimeoutvalue = 32888;
/*     */   public static final int ManagerId_papowerres = 33466;
/*     */   private static final String TAG = "ECarXCarPowerManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarPowerManager() {}
/*     */   
/*     */   public ECarXCarPowerManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  69 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_TimeoutValue(int paramInt) {
/*  79 */     return this.mMgr.setIntProperty(32888, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_InstallStatus(int paramInt) {
/*  89 */     return this.mMgr.setIntProperty(32889, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_ResetSettings(int paramInt) {
/*  99 */     return this.mMgr.setIntProperty(32890, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_APStatus(int paramInt) {
/* 109 */     return this.mMgr.setIntProperty(32891, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_Restart(int paramInt) {
/* 119 */     return this.mMgr.setIntProperty(32892, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_APUpdate(int paramInt) {
/* 129 */     return this.mMgr.setIntProperty(32893, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_PlayPausePress(int paramInt) {
/* 139 */     return this.mMgr.setIntProperty(32894, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_BG(int paramInt) {
/* 149 */     return this.mMgr.setIntProperty(32895, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_PhotoView(int paramInt) {
/* 159 */     return this.mMgr.setIntProperty(32896, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_IPLMInfo(int paramInt) {
/* 169 */     return this.mMgr.setIntProperty(32897, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_OTAUpdate(int paramInt) {
/* 179 */     return this.mMgr.setIntProperty(32898, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_Softkey(int paramInt) {
/* 189 */     ApiResult apiResult = ApiResult.FAILED;
/* 190 */     if (PowerSoftKey.isValid(paramInt)) {
/* 191 */       apiResult = this.mMgr.setIntProperty(32899, 1, paramInt);
/*     */     } else {
/* 193 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 195 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_Reboot(int paramInt) {
/* 205 */     return this.mMgr.setIntProperty(32900, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_PSDStatus(int paramInt) {
/* 215 */     return this.mMgr.setIntProperty(32901, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_ResetUSB(int paramInt) {
/* 225 */     return this.mMgr.setIntProperty(32902, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_CSDStatus(int paramInt) {
/* 235 */     return this.mMgr.setIntProperty(32903, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Power_heartbeats(int paramInt) {
/* 245 */     return this.mMgr.setIntProperty(32904, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Power_Res getPA_Power_Res() throws CarNotConnectedException {
/* 256 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33466, 1);
/*     */     
/* 258 */     PATypes.PA_Power_Res pA_Power_Res = null;
/*     */     try {
/* 260 */       PATypes.PA_Power_Res pA_Power_Res1 = new PATypes.PA_Power_Res(); this(VendorVehicleHalPAProto.PwrctrlVptoapimpl.parseFrom(arrayOfByte)); pA_Power_Res = pA_Power_Res1;
/* 261 */     } catch (Exception exception) {}
/*     */     
/* 263 */     return pA_Power_Res;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarPowerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */