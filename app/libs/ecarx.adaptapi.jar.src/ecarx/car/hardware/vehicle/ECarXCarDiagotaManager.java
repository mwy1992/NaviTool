/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
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
/*     */ public class ECarXCarDiagotaManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbd0d2 = 33184;
/*     */   public static final int ManagerId_cbdiagotareboot = 33185;
/*     */   public static final int ManagerId_pad0d0 = 33767;
/*     */   public static final int ManagerId_pad0d1 = 33766;
/*     */   public static final int ManagerId_pad0d2 = 33765;
/*     */   private static final String TAG = "ECarXCarDiagotaManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDiagotaManager() {}
/*     */   
/*     */   public ECarXCarDiagotaManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  55 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_D0D2(byte[] paramArrayOfbyte) {
/*  64 */     this.mMgr.setbytesProperty(33184, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DiagOTAReboot(int paramInt) {
/*  74 */     return this.mMgr.setIntProperty(33185, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_D0D2 getPA_D0D2() throws CarNotConnectedException {
/*  85 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33765, 1);
/*     */     
/*  87 */     PATypes.PA_D0D2 pA_D0D2 = null;
/*     */     try {
/*  89 */       PATypes.PA_D0D2 pA_D0D21 = new PATypes.PA_D0D2(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_D0D2 = pA_D0D21;
/*  90 */     } catch (Exception exception) {}
/*     */     
/*  92 */     return pA_D0D2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_D0D1 getPA_D0D1() throws CarNotConnectedException {
/* 101 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33766, 1);
/*     */     
/* 103 */     PATypes.PA_D0D1 pA_D0D1 = null;
/*     */     try {
/* 105 */       PATypes.PA_D0D1 pA_D0D11 = new PATypes.PA_D0D1(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_D0D1 = pA_D0D11;
/* 106 */     } catch (Exception exception) {}
/*     */     
/* 108 */     return pA_D0D1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_D0D0 getPA_D0D0() throws CarNotConnectedException {
/* 117 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33767, 1);
/*     */     
/* 119 */     PATypes.PA_D0D0 pA_D0D0 = null;
/*     */     try {
/* 121 */       PATypes.PA_D0D0 pA_D0D01 = new PATypes.PA_D0D0(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_D0D0 = pA_D0D01;
/* 122 */     } catch (Exception exception) {}
/*     */     
/* 124 */     return pA_D0D0;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDiagotaManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */