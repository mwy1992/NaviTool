/*    */ package com.android.car.internal;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Binder;
/*    */ import android.os.Process;
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
/*    */ public class CarPermission
/*    */ {
/*    */   private final Context mContext;
/*    */   private final String mName;
/*    */   
/*    */   public CarPermission(Context paramContext, String paramString) {
/* 35 */     this.mContext = paramContext;
/* 36 */     this.mName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkGranted() {
/* 41 */     String str = this.mName; boolean bool = true; if (str != null && 
/* 42 */       Binder.getCallingUid() != Process.myUid()) {
/* 43 */       Context context = this.mContext; str = this.mName;
/* 44 */       if (context.checkCallingOrSelfPermission(str) != 0) bool = false; 
/*    */       return bool;
/*    */     } 
/* 47 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void assertGranted() {
/* 52 */     if (checkGranted())
/* 53 */       return;  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("client does not have permission:"); stringBuilder.append(this.mName); stringBuilder.append(" pid:");
/*    */ 
/*    */ 
/*    */     
/* 57 */     stringBuilder.append(Binder.getCallingPid()); stringBuilder.append(" uid:");
/*    */     
/* 59 */     stringBuilder.append(Binder.getCallingUid()); throw new SecurityException(stringBuilder.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     return this.mName;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\android\car\internal\CarPermission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */