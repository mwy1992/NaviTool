/*    */ package com.ecarx.xui.adaptapi.input;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
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
/*    */ public abstract class Input
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static Input create(Context paramContext) {
/* 30 */     return InputImpl.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract boolean abandonKeysInterception(IKeyCallback paramIKeyCallback);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL")
/*    */   public abstract IInputSettings getInputSettings();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL")
/*    */   public abstract FunctionStatus isInputSettingsSupported();
/*    */   
/*    */   public abstract int[] requestKeysInterception(int[] paramArrayOfint, IKeyCallback paramIKeyCallback);
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\input\Input.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */