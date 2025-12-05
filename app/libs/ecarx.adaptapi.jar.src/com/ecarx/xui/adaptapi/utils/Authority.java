/*    */ package com.ecarx.xui.adaptapi.utils;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Build;
/*    */ import android.os.SystemProperties;
/*    */ import com.ecarx.xui.adaptapi.sign.SignVerify;
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
/*    */ public class Authority
/*    */ {
/*    */   public static void verifyAuthority(Context paramContext) {
/* 32 */     boolean bool = true;
/* 33 */     if (!Build.IS_USER) {
/* 34 */       bool = SystemProperties.getBoolean("persist.adaptapi.authority.enable", false);
/*    */     }
/* 36 */     if (bool) {
/* 37 */       SignVerify signVerify = new SignVerify();
/* 38 */       if (!signVerify.verifyPackage(paramContext))
/* 39 */         throw new SecurityException("Permission denied"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\utils\Authority.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */