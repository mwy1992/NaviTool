/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.Co2Lvl;
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
/*     */ public class ECarXCarAudioradioManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbarecallstate = 32958;
/*     */   public static final int ManagerId_cbarwarningvlo = 32957;
/*     */   public static final int ManagerId_cbaudioradioreboot = 32959;
/*     */   public static final int ManagerId_paarwarningvlo = 33534;
/*     */   private static final String TAG = "ECarXCarAudioradioManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarAudioradioManager() {}
/*     */   
/*     */   public ECarXCarAudioradioManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  56 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AR_WarningVlo(int paramInt) {
/*  66 */     ApiResult apiResult = ApiResult.FAILED;
/*  67 */     if (Co2Lvl.isValid(paramInt)) {
/*  68 */       apiResult = this.mMgr.setIntProperty(32957, 1, paramInt);
/*     */     } else {
/*  70 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  72 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AR_EcallState(int paramInt) {
/*  82 */     ApiResult apiResult = ApiResult.FAILED;
/*  83 */     if (OnOff1.isValid(paramInt)) {
/*  84 */       apiResult = this.mMgr.setIntProperty(32958, 1, paramInt);
/*     */     } else {
/*  86 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  88 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AudioRadio_Reboot(int paramInt) {
/*  98 */     return this.mMgr.setIntProperty(32959, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_AR_WarningVlo getPA_AR_WarningVlo() throws CarNotConnectedException {
/* 109 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33534, 1);
/*     */     
/* 111 */     PATypes.PA_AR_WarningVlo pA_AR_WarningVlo = null;
/*     */     try {
/* 113 */       PATypes.PA_AR_WarningVlo pA_AR_WarningVlo1 = new PATypes.PA_AR_WarningVlo(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AR_WarningVlo = pA_AR_WarningVlo1;
/* 114 */     } catch (Exception exception) {}
/*     */     
/* 116 */     return pA_AR_WarningVlo;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarAudioradioManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */