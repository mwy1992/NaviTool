/*    */ package ecarx.car.hardware.vehicle;
/*    */ 
/*    */ import android.car.CarNotConnectedException;
/*    */ import com.google.protobuf.nano.MessageNano;
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
/*    */ public class ECarXCarApvppulseManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_cbapvpinterfaceversion = 32960;
/*    */   public static final int ManagerId_cbapvpreboot = 32961;
/*    */   public static final int ManagerId_paerrorreport = 33535;
/*    */   private static final String TAG = "ECarXCarApvppulseManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarApvppulseManager() {}
/*    */   
/*    */   public ECarXCarApvppulseManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 54 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void CB_ApVp_InterfaceVersion(VendorVehicleHalPAProto.Interfaceversion paramInterfaceversion) {
/* 62 */     this.mMgr.setbytesProperty(32960, 1, VendorVehicleHalPAProto.Interfaceversion.toByteArray((MessageNano)paramInterfaceversion));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_ApVp_Reboot(int paramInt) {
/* 72 */     return this.mMgr.setIntProperty(32961, 1, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PATypes.PA_ErrorReport getPA_ErrorReport() throws CarNotConnectedException {
/* 83 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33535, 1);
/*    */     
/* 85 */     PATypes.PA_ErrorReport pA_ErrorReport = null;
/*    */     try {
/* 87 */       PATypes.PA_ErrorReport pA_ErrorReport1 = new PATypes.PA_ErrorReport(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ErrorReport = pA_ErrorReport1;
/* 88 */     } catch (Exception exception) {}
/*    */     
/* 90 */     return pA_ErrorReport;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarApvppulseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */