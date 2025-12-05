/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.OpendClsd2;
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
/*     */ public class ECarXCarVfnaviManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbnavivehegycoornopenandcls = 33275;
/*     */   public static final int ManagerId_panavivehegycoornfctstchg = 33933;
/*     */   public static final int ManagerId_panavivehegycoornopenandcls = 33932;
/*     */   private static final String TAG = "ECarXCarVfnaviManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarVfnaviManager() {}
/*     */   
/*     */   public ECarXCarVfnaviManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  54 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_NAVI_VehEgyCoornOpenAndCls(int paramInt) {
/*  64 */     ApiResult apiResult = ApiResult.FAILED;
/*  65 */     if (OpendClsd2.isValid(paramInt)) {
/*  66 */       apiResult = this.mMgr.setIntProperty(33275, 1, paramInt);
/*     */     } else {
/*  68 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  70 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_NAVI_VehEgyCoornOpenAndCls getPA_NAVI_VehEgyCoornOpenAndCls() throws CarNotConnectedException {
/*  81 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33932, 1);
/*     */     
/*  83 */     PATypes.PA_NAVI_VehEgyCoornOpenAndCls pA_NAVI_VehEgyCoornOpenAndCls = null;
/*     */     try {
/*  85 */       PATypes.PA_NAVI_VehEgyCoornOpenAndCls pA_NAVI_VehEgyCoornOpenAndCls1 = new PATypes.PA_NAVI_VehEgyCoornOpenAndCls(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_NAVI_VehEgyCoornOpenAndCls = pA_NAVI_VehEgyCoornOpenAndCls1;
/*  86 */     } catch (Exception exception) {}
/*     */     
/*  88 */     return pA_NAVI_VehEgyCoornOpenAndCls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_NAVI_VehEgyCoornFctStChg getPA_NAVI_VehEgyCoornFctStChg() throws CarNotConnectedException {
/*  97 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33933, 1);
/*     */     
/*  99 */     PATypes.PA_NAVI_VehEgyCoornFctStChg pA_NAVI_VehEgyCoornFctStChg = null;
/*     */     try {
/* 101 */       PATypes.PA_NAVI_VehEgyCoornFctStChg pA_NAVI_VehEgyCoornFctStChg1 = new PATypes.PA_NAVI_VehEgyCoornFctStChg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_NAVI_VehEgyCoornFctStChg = pA_NAVI_VehEgyCoornFctStChg1;
/* 102 */     } catch (Exception exception) {}
/*     */     
/* 104 */     return pA_NAVI_VehEgyCoornFctStChg;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVfnaviManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */