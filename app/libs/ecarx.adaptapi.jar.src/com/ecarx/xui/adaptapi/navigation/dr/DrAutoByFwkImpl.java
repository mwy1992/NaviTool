/*    */ package com.ecarx.xui.adaptapi.navigation.dr;
/*    */ 
/*    */ import android.content.Context;
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
/*    */ public class DrAutoByFwkImpl
/*    */   implements IDrAutoByFwk
/*    */ {
/*    */   private IDrAutoByFwk.IDrPosListener mDrPosListener;
/*    */   
/*    */   public DrAutoByFwkImpl(Context paramContext) {}
/*    */   
/*    */   public void updateFeedback(IDrAutoByFwk.IDrPos paramIDrPos, IDrFeedback paramIDrFeedback) {}
/*    */   
/*    */   public void registerListener(IDrAutoByFwk.IDrPosListener paramIDrPosListener) {
/* 41 */     this.mDrPosListener = paramIDrPosListener;
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
/*    */ 
/*    */   
/*    */   public void unregisterListener(IDrAutoByFwk.IDrPosListener paramIDrPosListener) {
/* 55 */     this.mDrPosListener = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\DrAutoByFwkImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */