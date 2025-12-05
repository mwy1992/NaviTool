/*    */ package com.ecarx.xui.adaptapi.tbox.ota;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.utils.ProperUtils;
/*    */ 
/*    */ public class OtaImp
/*    */   implements IOta
/*    */ {
/*    */   private IOtaSession mOtaSession;
/*    */   private IOtaSessionCallback mOtaSessionCallback;
/*    */   
/*    */   public OtaImp(Context paramContext) {
/* 13 */     this.mOtaSession = new OtaSessionImp(paramContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IOtaSession requestOta(IOtaSessionCallback paramIOtaSessionCallback) {
/* 24 */     this.mOtaSessionCallback = paramIOtaSessionCallback;
/* 25 */     return this.mOtaSession;
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
/*    */   public void releaseOtaCallback(IOtaSessionCallback paramIOtaSessionCallback) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean installPackage(IOtaSession paramIOtaSession, String paramString) {
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getOtaBaseSoftwareVersionCode() {
/* 57 */     return ((Integer)ProperUtils.getPropertyValue("IOta_OtaBaseSoftwareVersionCode", int.class)).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getOtaBaseSoftwareVersionName() {
/* 67 */     return (String)ProperUtils.getPropertyValue("IOta_OtaBaseSoftwareVersionName", String.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\ota\OtaImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */