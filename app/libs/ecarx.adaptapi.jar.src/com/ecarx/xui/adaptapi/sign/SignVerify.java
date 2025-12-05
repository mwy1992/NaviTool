/*    */ package com.ecarx.xui.adaptapi.sign;
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
/*    */ public class SignVerify
/*    */ {
/*    */   static {
/* 98 */     System.loadLibrary("signer_verify");
/*    */   }
/*    */   
/*    */   public native String getVerifyVersion();
/*    */   
/*    */   @Deprecated
/*    */   public native boolean verifyEnablePermissionKey(Context paramContext, String paramString);
/*    */   
/*    */   public native boolean verifyPackage(Context paramContext);
/*    */   
/*    */   public native boolean verifyPkgECarxSignature(Context paramContext);
/*    */   
/*    */   public native boolean verifyPkgSystemApp(Context paramContext);
/*    */   
/*    */   public native boolean verifyPkgSystemSignature(Context paramContext);
/*    */   
/*    */   @Deprecated
/*    */   public native int verifySignKey(Context paramContext, String paramString);
/*    */   
/*    */   public native boolean verifyWhiteApp(Context paramContext);
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\sign\SignVerify.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */