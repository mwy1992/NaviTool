/*    */ package com.ecarx.xui.adaptapi.input;
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
/*    */ public abstract class InputMethod
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static InputMethod create(Context paramContext) {
/* 28 */     return InputMethodImpl.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract void registerInputMethodVisibleChangedListener(IInputMethodCallback paramIInputMethodCallback);
/*    */   
/*    */   public abstract void unregisterInputMethodVisibleChangedListener(IInputMethodCallback paramIInputMethodCallback);
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\input\InputMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */