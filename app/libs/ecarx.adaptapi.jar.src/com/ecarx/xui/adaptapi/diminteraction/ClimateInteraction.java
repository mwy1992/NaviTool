/*    */ package com.ecarx.xui.adaptapi.diminteraction;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClimateInteraction
/*    */   extends AbsCarSignal
/*    */   implements IClimateInteraction
/*    */ {
/*    */   private static final String TAG = "ClimateInteraction";
/*    */   
/*    */   protected ClimateInteraction(Context paramContext) {
/* 15 */     super(paramContext);
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
/*    */   public boolean updateFunctionValue(int paramInt1, int paramInt2) {
/* 27 */     return false;
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
/*    */   public boolean updateFunctionValue(int paramInt, float paramFloat) {
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\ClimateInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */