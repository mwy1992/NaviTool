/*    */ package com.ecarx.xui.adaptapi.oncall;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.NonNull;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
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
/*    */ @VendorDefinition(author = "@ECARX", date = "2022-02-28", project = "SMART")
/*    */ public abstract class CallCenterConfig
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int CONFIG_ECALL_112 = 0;
/*    */   public static final int CONFIG_ECALL_TPS = 1;
/*    */   
/*    */   @NonNull
/*    */   public static CallCenterConfig create(Context paramContext) {
/* 43 */     return null;
/*    */   }
/*    */   
/*    */   public abstract int getConfig(int paramInt);
/*    */   
/*    */   public abstract FunctionStatus isConfigSupported(int paramInt);
/*    */   
/*    */   public abstract boolean setConfig(int paramInt1, int paramInt2);
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface CallConfigValues {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\oncall\CallCenterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */