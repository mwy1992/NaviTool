/*    */ package com.ecarx.xui.adaptapi.pki;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
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
/*    */ public abstract class PKI
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int SSL_AUTH_BOTH = 2;
/*    */   public static final int SSL_AUTH_NONE = 0;
/*    */   public static final int SSL_AUTH_SINGLE = 1;
/*    */   
/*    */   public static PKI create(Context paramContext) {
/* 52 */     return PKIImpl.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract String getCertificateAlias();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "Lambda")
/*    */   public abstract byte[] getECUIssuingCA();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "Lambda")
/*    */   public abstract byte[] getGlobalPolicyCA();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "Lambda")
/*    */   public abstract byte[] getRootCA();
/*    */   
/*    */   public abstract int getSSLAuthType();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "Lambda")
/*    */   public abstract byte[] getServicesIssuingCA();
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface SSLAuthType {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\pki\PKI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */