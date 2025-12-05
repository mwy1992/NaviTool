/*    */ package com.ecarx.xui.adaptapi.uiinteraction;
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
/*    */ 
/*    */ 
/*    */ public class UiInteraction
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static IUiInteraction create(Context paramContext) {
/* 28 */     return UiInteractionImpl.create(paramContext);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\UiInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */