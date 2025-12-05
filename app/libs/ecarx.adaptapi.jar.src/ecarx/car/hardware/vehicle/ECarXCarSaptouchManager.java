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
/*    */ public class ECarXCarSaptouchManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_cbsaptouchreboot = 32921;
/*    */   public static final int ManagerId_cbtouchtime = 32920;
/*    */   public static final int ManagerId_pasapprkgunlck = 33491;
/*    */   private static final String TAG = "ECarXCarSaptouchManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarSaptouchManager() {}
/*    */   
/*    */   public ECarXCarSaptouchManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 53 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void CB_Touch_Time(VendorVehicleHalPAProto.Touchtime paramTouchtime) {
/* 61 */     this.mMgr.setbytesProperty(32920, 1, VendorVehicleHalPAProto.Touchtime.toByteArray((MessageNano)paramTouchtime));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_SAPTOUCH_Reboot(int paramInt) {
/* 71 */     return this.mMgr.setIntProperty(32921, 1, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PATypes.PA_SAP_PrkgUnlck getPA_SAP_PrkgUnlck() throws CarNotConnectedException {
/* 82 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33491, 1);
/*    */     
/* 84 */     PATypes.PA_SAP_PrkgUnlck pA_SAP_PrkgUnlck = null;
/*    */     try {
/* 86 */       PATypes.PA_SAP_PrkgUnlck pA_SAP_PrkgUnlck1 = new PATypes.PA_SAP_PrkgUnlck(); this(VendorVehicleHalPAProto.Touchtime.parseFrom(arrayOfByte)); pA_SAP_PrkgUnlck = pA_SAP_PrkgUnlck1;
/* 87 */     } catch (Exception exception) {}
/*    */     
/* 89 */     return pA_SAP_PrkgUnlck;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarSaptouchManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */