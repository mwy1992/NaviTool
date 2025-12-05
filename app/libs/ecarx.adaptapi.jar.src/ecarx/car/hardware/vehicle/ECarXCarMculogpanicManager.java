/*    */ package ecarx.car.hardware.vehicle;
/*    */ 
/*    */ import android.car.CarNotConnectedException;
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
/*    */ 
/*    */ 
/*    */ public class ECarXCarMculogpanicManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_pamculogpanic = 33533;
/*    */   private static final String TAG = "ECarXCarMculogpanicManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarMculogpanicManager() {}
/*    */   
/*    */   public ECarXCarMculogpanicManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 52 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PATypes.PA_McuLog_Panic getPA_McuLog_Panic() throws CarNotConnectedException {
/* 64 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33533, 1);
/*    */     
/* 66 */     PATypes.PA_McuLog_Panic pA_McuLog_Panic = null;
/*    */     try {
/* 68 */       PATypes.PA_McuLog_Panic pA_McuLog_Panic1 = new PATypes.PA_McuLog_Panic(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_McuLog_Panic = pA_McuLog_Panic1;
/* 69 */     } catch (Exception exception) {}
/*    */     
/* 71 */     return pA_McuLog_Panic;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarMculogpanicManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */