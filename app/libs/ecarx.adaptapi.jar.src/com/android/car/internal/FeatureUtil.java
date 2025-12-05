/*    */ package com.android.car.internal;
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
/*    */ public class FeatureUtil
/*    */ {
/*    */   public static void assertFeature(boolean paramBoolean) {
/* 25 */     if (paramBoolean)
/* 26 */       return;  throw new IllegalStateException("Feature not enabled");
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\android\car\internal\FeatureUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */