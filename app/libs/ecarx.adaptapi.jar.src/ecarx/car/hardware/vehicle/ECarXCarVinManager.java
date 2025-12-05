/*    */ package ecarx.car.hardware.vehicle;
/*    */ 
/*    */ import android.car.CarNotConnectedException;
/*    */ import ecarx.car.hardware.annotation.ApiResult;
/*    */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
/*    */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ECarXCarVinManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_cbvinreboot = 32922;
/*    */   public static final int ManagerId_pavinvinnum = 33492;
/*    */   private static final String TAG = "ECarXCarVinManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarVinManager() {}
/*    */   
/*    */   public ECarXCarVinManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 52 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_VIN_Reboot(int paramInt) {
/* 62 */     return this.mMgr.setIntProperty(32922, 1, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PATypes.PA_VIN_VinNum getPA_VIN_VinNum() throws CarNotConnectedException {
/* 73 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33492, 1);
/*    */     
/* 75 */     PATypes.PA_VIN_VinNum pA_VIN_VinNum = null;
/*    */     try {
/* 77 */       PATypes.PA_VIN_VinNum pA_VIN_VinNum1 = new PATypes.PA_VIN_VinNum(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_VIN_VinNum = pA_VIN_VinNum1;
/* 78 */     } catch (Exception exception) {}
/*    */     
/* 80 */     return pA_VIN_VinNum;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVinManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */