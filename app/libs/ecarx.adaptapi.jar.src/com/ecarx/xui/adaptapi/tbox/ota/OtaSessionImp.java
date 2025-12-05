/*    */ package com.ecarx.xui.adaptapi.tbox.ota;
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
/*    */ public class OtaSessionImp
/*    */   implements IOtaSession
/*    */ {
/*    */   public OtaSessionImp(Context paramContext) {}
/*    */   
/*    */   public boolean isInstallationStarted() {
/* 18 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean couldBeginInstallRightNow() {
/* 28 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getOtaProgress() {
/* 38 */     return ((Integer)ProperUtils.getPropertyValue("IOtaSession_OtaProgress", int.class)).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean ifSystemWillRebootAfterOta() {
/* 48 */     return ((Boolean)ProperUtils.getPropertyValue("IOtaSession_ifSystemWillRebootAfterOta", boolean.class)).booleanValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean cancel() {
/* 59 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\ota\OtaSessionImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */