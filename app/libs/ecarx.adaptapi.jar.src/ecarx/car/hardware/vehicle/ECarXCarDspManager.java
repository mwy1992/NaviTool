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
/*    */ public class ECarXCarDspManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_cbdspreboot = 32963;
/*    */   public static final int ManagerId_cbgetdspversion = 32962;
/*    */   public static final int ManagerId_padspversion = 33536;
/*    */   private static final String TAG = "ECarXCarDspManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarDspManager() {}
/*    */   
/*    */   public ECarXCarDspManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 53 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_GetDspVersion(int paramInt) {
/* 63 */     return this.mMgr.setIntProperty(32962, 1, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_DspReboot(int paramInt) {
/* 73 */     return this.mMgr.setIntProperty(32963, 1, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PATypes.PA_DspVersion getPA_DspVersion() throws CarNotConnectedException {
/* 84 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33536, 1);
/*    */     
/* 86 */     PATypes.PA_DspVersion pA_DspVersion = null;
/*    */     try {
/* 88 */       PATypes.PA_DspVersion pA_DspVersion1 = new PATypes.PA_DspVersion(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_DspVersion = pA_DspVersion1;
/* 89 */     } catch (Exception exception) {}
/*    */     
/* 91 */     return pA_DspVersion;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDspManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */