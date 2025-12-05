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
/*    */ public class ECarXCarApversionManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_paapversion = 33902;
/*    */   private static final String TAG = "ECarXCarApversionManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarApversionManager() {}
/*    */   
/*    */   public ECarXCarApversionManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
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
/*    */   public PATypes.PA_AP_Version getPA_AP_Version() throws CarNotConnectedException {
/* 64 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33902, 1);
/*    */     
/* 66 */     PATypes.PA_AP_Version pA_AP_Version = null;
/*    */     try {
/* 68 */       PATypes.PA_AP_Version pA_AP_Version1 = new PATypes.PA_AP_Version(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AP_Version = pA_AP_Version1;
/* 69 */     } catch (Exception exception) {}
/*    */     
/* 71 */     return pA_AP_Version;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarApversionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */