/*    */ package com.ecarx.xui.adaptapi.hudinteraction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VehicleSyncInfo
/*    */   implements IVehicleSyncInfo
/*    */ {
/* 10 */   private SyncInfoData infoData = new SyncInfoData();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getVehicleSpeed() {
/* 17 */     return this.infoData.vehicleSpeed;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getSteerWhlSnsrAg() {
/* 25 */     return this.infoData.steerWhlSnsrAg;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getSteerWhlSnsrAgSpd() {
/* 33 */     return this.infoData.steerWhlSnsrAgSpd;
/*    */   }
/*    */   
/*    */   public static class SyncInfoData {
/*    */     double steerWhlSnsrAg;
/*    */     double steerWhlSnsrAgSpd;
/*    */     double vehicleSpeed;
/*    */   }
/*    */   
/*    */   public void setInfoData(SyncInfoData paramSyncInfoData) {
/* 43 */     this.infoData.vehicleSpeed = paramSyncInfoData.vehicleSpeed;
/* 44 */     this.infoData.steerWhlSnsrAg = paramSyncInfoData.steerWhlSnsrAg;
/* 45 */     this.infoData.steerWhlSnsrAgSpd = paramSyncInfoData.steerWhlSnsrAgSpd;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\VehicleSyncInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */