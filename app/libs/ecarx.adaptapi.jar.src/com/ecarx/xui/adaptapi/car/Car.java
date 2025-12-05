/*    */ package com.ecarx.xui.adaptapi.car;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
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
/*    */ public final class Car
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static ICar create(Context paramContext) {
/* 26 */     return CarImpl.create(paramContext);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\Car.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */