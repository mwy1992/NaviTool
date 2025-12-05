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
/*    */ public class ECarXCarVpversionManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_cbvpreboot = 32923;
/*    */   public static final int ManagerId_pavpversion = 33493;
/*    */   private static final String TAG = "ECarXCarVpversionManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarVpversionManager() {}
/*    */   
/*    */   public ECarXCarVpversionManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 52 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_VP_Reboot(int paramInt) {
/* 62 */     return this.mMgr.setIntProperty(32923, 1, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PATypes.PA_VP_Version getPA_VP_Version() throws CarNotConnectedException {
/* 73 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33493, 1);
/*    */     
/* 75 */     PATypes.PA_VP_Version pA_VP_Version = null;
/*    */     try {
/* 77 */       PATypes.PA_VP_Version pA_VP_Version1 = new PATypes.PA_VP_Version(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_VP_Version = pA_VP_Version1;
/* 78 */     } catch (Exception exception) {}
/*    */     
/* 80 */     return pA_VP_Version;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVpversionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */