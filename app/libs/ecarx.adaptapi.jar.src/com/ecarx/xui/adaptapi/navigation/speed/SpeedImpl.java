/*    */ package com.ecarx.xui.adaptapi.navigation.speed;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.utils.ProperUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpeedImpl
/*    */   implements ISpeed
/*    */ {
/*    */   private ISpeedCallback mSpeedCallback;
/*    */   
/*    */   public SpeedImpl(Context paramContext) {}
/*    */   
/*    */   public boolean isSpeedLimitEnabled() {
/* 22 */     return ((Boolean)ProperUtils.getPropertyValue("ISpeed_SpeedLimitEnabled", boolean.class)).booleanValue();
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
/*    */   public void setSpeedLimitingInfo(int paramInt, ISpeedLimitingInfo paramISpeedLimitingInfo) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerSpeedCallback(ISpeedCallback paramISpeedCallback) {
/* 43 */     this.mSpeedCallback = paramISpeedCallback;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void unregisterSpeedCallback(ISpeedCallback paramISpeedCallback) {
/* 53 */     this.mSpeedCallback = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\speed\SpeedImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */