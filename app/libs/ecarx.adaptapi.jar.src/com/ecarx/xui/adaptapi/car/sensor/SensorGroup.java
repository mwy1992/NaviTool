/*    */ package com.ecarx.xui.adaptapi.car.sensor;
/*    */ 
/*    */ import ecarx.os.LocalConfig;
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
/*    */ public class SensorGroup
/*    */   implements ISensorGroup
/*    */ {
/*    */   static class MountAngle
/*    */     implements ISensorGroup.IMountAngle
/*    */   {
/* 25 */     private LocalConfig mLocalConfig = LocalConfig.get();
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
/*    */     public boolean hasMountAngle() {
/* 37 */       return true;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public float getYawMountAngle() {
/* 46 */       return this.mLocalConfig.getFloat(LocalConfig.KEY.LCFG_NAVI_MountAngle_YAW);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public float getPitchMountAngle() {
/* 55 */       return this.mLocalConfig.getFloat(LocalConfig.KEY.LCFG_NAVI_MountAngle_PITCH);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public float getRollMountAngle() {
/* 64 */       return this.mLocalConfig.getFloat(LocalConfig.KEY.LCFG_NAVI_MountAngle_ROLL);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\SensorGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */