/*     */ package com.ecarx.xui.adaptapi.ota;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.Calendar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class OTA
/*     */   extends AdaptAPI
/*     */ {
/*     */   public static final int OTA_TYPE_IHU = 1;
/*     */   public static final int OTA_TYPE_IHU_DVR = 34;
/*     */   public static final int OTA_TYPE_IHU_VP = 18;
/*     */   public static final int OTA_TYPE_TBOX = 33;
/*     */   public static final int OTA_TYPE_VP = 17;
/*     */   public static final int OTA_TYPE_WHOLE_CAR = 2;
/*     */   @Deprecated
/*     */   public static final int UPDATE_FAILED_REASON_DEFAULT = 0;
/*     */   @Deprecated
/*     */   public static final int UPDATE_FAILED_REASON_INSUFFICIENT_STORAGE = 2;
/*     */   @Deprecated
/*     */   public static final int UPDATE_FAILED_REASON_INVALID_PACKAGE = 1;
/*     */   
/*     */   public static OTA create(Context paramContext) {
/*  35 */     return OTAImp.create(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public abstract int getOtaBaseSysVersionCode();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public abstract String getOtaBaseSysVersionName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public abstract String getOtaPkgRootPath();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public abstract int getSysVersionCode();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public abstract String getSysVersionName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean installPackage(IOtaSession paramIOtaSession, String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract FunctionStatus isOtaTypeSupported(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void releaseOtaCallback(IOtaSessionCallback paramIOtaSessionCallback);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract IOtaSession requestOta(int paramInt, IOtaSessionCallback paramIOtaSessionCallback);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract IOtaSession requestOta(int paramInt, boolean paramBoolean, IOtaSessionCallback paramIOtaSessionCallback);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract IOtaSession requestOta(boolean paramBoolean, IOtaSessionCallback paramIOtaSessionCallback);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public abstract boolean setOtaUpdateTime(Calendar paramCalendar);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean supportNoRecoveryOta();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class DecryptionKeyType
/*     */   {
/*     */     private String hashRoot;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String key;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final OTA this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getHashRoot() {
/* 266 */       return this.hashRoot;
/*     */     }
/*     */     
/*     */     public void setHashRoot(String param1String) {
/* 270 */       this.hashRoot = param1String;
/*     */     }
/*     */     
/*     */     public String getKey() {
/* 274 */       return this.key;
/*     */     }
/*     */     
/*     */     public void setKey(String param1String) {
/* 278 */       this.key = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 283 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DecryptionKeyType{hashRoot='"); stringBuilder.append(this.hashRoot); stringBuilder.append('\''); stringBuilder.append(", key='"); stringBuilder.append(this.key); stringBuilder.append('\''); stringBuilder.append('}'); return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   @Documented
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface OtaType {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ota\OTA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */