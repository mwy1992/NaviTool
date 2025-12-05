/*    */ package ecarx.car.hardware.vehicle;
/*    */ 
/*    */ import ecarx.car.hardware.annotation.ApiResult;
/*    */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
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
/*    */ 
/*    */ public class ECarXCarApplogManager
/*    */   extends ECarXCarFuncManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int ManagerId_cbapplogreboot = 33293;
/*    */   public static final int ManagerId_cblogservicestatusap = 33292;
/*    */   private static final String TAG = "ECarXCarApplogManager";
/*    */   public static final int VehicleArea_Global = 1;
/*    */   public static final int VehicleArea_Zone = 2;
/*    */   
/*    */   public ECarXCarApplogManager() {}
/*    */   
/*    */   public ECarXCarApplogManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 53 */     super(paramECarXCarPropertyManagerBase);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_LogServiceStatusAP(int paramInt) {
/* 63 */     return this.mMgr.setIntProperty(33292, 1, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ApiResult CB_AppLog_Reboot(int paramInt) {
/* 73 */     return this.mMgr.setIntProperty(33293, 1, paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarApplogManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */