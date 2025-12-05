/*    */ package ecarx.car.hardware.vehicle;
/*    */ 
/*    */ import android.car.CarNotConnectedException;
/*    */ import ecarx.car.hardware.annotation.ApiResult;
/*    */ import ecarx.car.hardware.annotation.OnOff1;
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
/*    */ public class ECarXCarFaceidManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_cbfdfaceidnreq = 33278;
/*    */   public static final int ManagerId_pafdfaceidnreq = 33955;
/*    */   private static final String TAG = "ECarXCarFaceidManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarFaceidManager() {}
/*    */   
/*    */   public ECarXCarFaceidManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 53 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_FD_FaceIdnReq(int paramInt) {
/* 63 */     ApiResult apiResult = ApiResult.FAILED;
/* 64 */     if (OnOff1.isValid(paramInt)) {
/* 65 */       apiResult = this.mMgr.setIntProperty(33278, 1, paramInt);
/*    */     } else {
/* 67 */       apiResult = ApiResult.PARAM_ERROR;
/*    */     } 
/* 69 */     return apiResult;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PATypes.PA_FD_FaceIdnReq getPA_FD_FaceIdnReq() throws CarNotConnectedException {
/* 80 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33955, 1);
/*    */     
/* 82 */     PATypes.PA_FD_FaceIdnReq pA_FD_FaceIdnReq = null;
/*    */     try {
/* 84 */       PATypes.PA_FD_FaceIdnReq pA_FD_FaceIdnReq1 = new PATypes.PA_FD_FaceIdnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD_FaceIdnReq = pA_FD_FaceIdnReq1;
/* 85 */     } catch (Exception exception) {}
/*    */     
/* 87 */     return pA_FD_FaceIdnReq;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarFaceidManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */