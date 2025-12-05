/*    */ package com.ecarx.xui.adaptapi.pki;
/*    */ 
/*    */ import android.content.Context;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PKIImpl
/*    */   extends PKI
/*    */ {
/*    */   private static final String PKI_ALIAS = "ECARX_IHU";
/*    */   private static PKIImpl mPKIImpl;
/*    */   
/*    */   private PKIImpl(Context paramContext) {}
/*    */   
/*    */   public static PKIImpl create(Context paramContext) {
/* 19 */     if (paramContext != null) {
/* 20 */       mPKIImpl = new PKIImpl(paramContext);
/*    */     }
/*    */     
/* 23 */     return mPKIImpl;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCertificateAlias() {
/* 34 */     return "ECARX_IHU";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getRootCA() {
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getGlobalPolicyCA() {
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getECUIssuingCA() {
/* 64 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getServicesIssuingCA() {
/* 74 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSSLAuthType() {
/* 85 */     return 2;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\pki\PKIImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */