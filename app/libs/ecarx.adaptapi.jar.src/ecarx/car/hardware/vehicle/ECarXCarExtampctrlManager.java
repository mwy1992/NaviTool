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
/*    */ public class ECarXCarExtampctrlManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_paampdiagresult = 33901;
/*    */   private static final String TAG = "ECarXCarExtampctrlManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarExtampctrlManager() {}
/*    */   
/*    */   public ECarXCarExtampctrlManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
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
/*    */   public PATypes.PA_AmpDiagResult getPA_AmpDiagResult() throws CarNotConnectedException {
/* 64 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33901, 1);
/*    */     
/* 66 */     PATypes.PA_AmpDiagResult pA_AmpDiagResult = null;
/*    */     try {
/* 68 */       PATypes.PA_AmpDiagResult pA_AmpDiagResult1 = new PATypes.PA_AmpDiagResult(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmpDiagResult = pA_AmpDiagResult1;
/* 69 */     } catch (Exception exception) {}
/*    */     
/* 71 */     return pA_AmpDiagResult;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarExtampctrlManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */