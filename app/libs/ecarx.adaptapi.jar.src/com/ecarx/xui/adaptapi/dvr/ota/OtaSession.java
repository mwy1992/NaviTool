/*    */ package com.ecarx.xui.adaptapi.dvr.ota;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.dvr.AbsDvrSignal;
/*    */ 
/*    */ public class OtaSession
/*    */   extends AbsDvrSignal
/*    */   implements IOtaSession {
/*    */   protected OtaSession(Context paramContext) {
/* 10 */     super(paramContext);
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
/*    */   public int getOtaProgress() {
/* 22 */     return 0;
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
/*    */   public boolean ifSystemWillRebootAfterOta() {
/* 34 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\ota\OtaSession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */