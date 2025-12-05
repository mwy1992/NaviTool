/*     */ package com.ecarx.xui.adaptapi.tbox.TBoxSetting;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.tbox.ITBoxSettings;
/*     */ import ecarx.tcam.ITcamServiceCallback;
/*     */ import ecarx.tcam.TcamManager;
/*     */ import ecarx.tcam.TcamServiceCallbackImpl;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TBoxSettingsImpl
/*     */   implements ITBoxSettings
/*     */ {
/*     */   private static final int RVDC_STATUS_FALSE = 0;
/*     */   private static final int RVDC_STATUS_TRUE = 1;
/*     */   private static final String TAG = "TBoxSettingsImpl";
/*     */   private ITBoxSettings.ICarLocatorCallback mCarLocatorCallback;
/*     */   private Context mContext;
/*     */   private ITBoxSettings.IKeylockCallback mKeylockCallback;
/*     */   private TcamManager mTcamManager;
/*     */   
/*     */   public TBoxSettingsImpl(Context paramContext) {
/*  30 */     if (paramContext != null) {
/*  31 */       this.mContext = paramContext;
/*  32 */       this.mTcamManager = TcamManager.getInstance(this.mContext);
/*  33 */       this.mTcamManager.registerCallback((ITcamServiceCallback)new TcamCallback());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private class TcamCallback
/*     */     extends TcamServiceCallbackImpl
/*     */   {
/*     */     final TBoxSettingsImpl this$0;
/*     */     
/*     */     private TcamCallback() {}
/*     */     
/*     */     public void onCarLocatorEnabled(boolean param1Boolean) {
/*  46 */       if (TBoxSettingsImpl.this.mCarLocatorCallback != null) {
/*  47 */         TBoxSettingsImpl.this.mCarLocatorCallback.onCarLocatorEnabled(param1Boolean);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onRemoteDiagnosticsUpdate(int param1Int) {
/*  56 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onRemoteDiagnosticsUpdate:remoteDiagnostics->"); stringBuilder.append(param1Int); Log.d("TBoxSettingsImpl", stringBuilder.toString());
/*  57 */       if (TBoxSettingsImpl.this.mCarLocatorCallback != null) {
/*     */ 
/*     */         
/*  60 */         if (1 == param1Int) {
/*  61 */           TBoxSettingsImpl.this.mCarLocatorCallback.onRVDCEnabled(true);
/*     */         } else {
/*  63 */           TBoxSettingsImpl.this.mCarLocatorCallback.onRVDCEnabled(false);
/*     */         } 
/*     */       } else {
/*  66 */         Log.e("TBoxSettingsImpl", "onRVDCAuthorizationStatusNotification mCarLocatorCallback is null");
/*     */       } 
/*     */     }
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
/*     */   public FunctionStatus isCarLocatorSupported() {
/*  95 */     FunctionStatus functionStatus = FunctionStatus.notavailable;
/*  96 */     if (this.mTcamManager.isCarLocatorSupported()) {
/*  97 */       functionStatus = FunctionStatus.active;
/*     */     }
/*  99 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isCarLocatorSupported: "); stringBuilder.append(functionStatus); Log.d("TBoxSettingsImpl", stringBuilder.toString());
/* 100 */     return functionStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCarLocatorEnabled() {
/* 110 */     boolean bool = true;
/* 111 */     if (this.mTcamManager != null) {
/* 112 */       bool = this.mTcamManager.isCarLocatorEnabled();
/*     */     } else {
/* 114 */       Log.e("TBoxSettingsImpl", "isCarLocatorEnabled mTcamManager is null");
/*     */     } 
/* 116 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isCarLocatorEnabled: "); stringBuilder.append(bool); Log.d("TBoxSettingsImpl", stringBuilder.toString());
/* 117 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCarLocatorEnable(boolean paramBoolean) {
/* 127 */     boolean bool = false;
/* 128 */     if (this.mTcamManager != null) {
/* 129 */       bool = this.mTcamManager.setCarLocatorEnable(paramBoolean);
/*     */     } else {
/* 131 */       Log.e("TBoxSettingsImpl", "setCarLocatorEnable mTcamManager is null");
/*     */     } 
/* 133 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setCarLocatorEnable enable = "); stringBuilder.append(paramBoolean); stringBuilder.append(" isNotify = "); stringBuilder.append(bool); Log.d("TBoxSettingsImpl", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCarLocatorCallback(ITBoxSettings.ICarLocatorCallback paramICarLocatorCallback) {
/* 142 */     this.mCarLocatorCallback = paramICarLocatorCallback;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetCarLocatorCallback(ITBoxSettings.ICarLocatorCallback paramICarLocatorCallback) {
/* 150 */     this.mCarLocatorCallback = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isKeylockSupported() {
/* 158 */     return FunctionStatus.notavailable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isKeylockEnabled() {
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeylockEnable(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeylockCallback(ITBoxSettings.IKeylockCallback paramIKeylockCallback) {
/* 186 */     this.mKeylockCallback = paramIKeylockCallback;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetKeylockCallback(ITBoxSettings.IKeylockCallback paramIKeylockCallback) {
/* 194 */     this.mKeylockCallback = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRVDCStatus(boolean paramBoolean) {
/* 204 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setRVDCStatus enable = "); stringBuilder.append(paramBoolean); Log.d("TBoxSettingsImpl", stringBuilder.toString());
/* 205 */     if (this.mTcamManager != null) {
/*     */ 
/*     */       
/* 208 */       if (paramBoolean) {
/* 209 */         this.mTcamManager.setRequestRVDCAuthorizationStatusUserUpdate(1, 0, 1);
/*     */       } else {
/* 211 */         this.mTcamManager.setRequestRVDCAuthorizationStatusUserUpdate(1, 0, 0);
/*     */       } 
/*     */     } else {
/* 214 */       Log.e("TBoxSettingsImpl", "setRVDCStatus mTcamManager is null");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRVDCEnabled() {
/* 225 */     boolean bool1 = false, bool2 = false;
/* 226 */     if (this.mTcamManager != null) {
/* 227 */       int i = this.mTcamManager.getRemoteDiagnostics();
/* 228 */       bool1 = bool2; if (i == 1) {
/* 229 */         bool1 = true;
/*     */       }
/*     */     } else {
/* 232 */       Log.e("TBoxSettingsImpl", "isRVDCEnabled mTcamManager is null");
/*     */     } 
/* 234 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isRVDCEnabled: "); stringBuilder.append(bool1); Log.d("TBoxSettingsImpl", stringBuilder.toString());
/* 235 */     return bool1;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\TBoxSetting\TBoxSettingsImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */