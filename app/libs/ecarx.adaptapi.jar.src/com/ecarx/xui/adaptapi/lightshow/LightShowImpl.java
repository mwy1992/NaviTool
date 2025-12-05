/*     */ package com.ecarx.xui.adaptapi.lightshow;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.lighting.ILightingShow;
/*     */ import com.ecarx.xui.adaptapi.lighting.LightingShow;
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
/*     */ 
/*     */ 
/*     */ public class LightShowImpl
/*     */   extends LightingShow
/*     */   implements ILightingShow
/*     */ {
/*     */   private static final String TAG = "LightShowImpl";
/*     */   private static LightShowImpl mLightShowImpl;
/*     */   private static LightingShowInfoImpl mLightingShowInfoImpl;
/*     */   private Context mContext;
/*     */   private ILightingShow.ILightingShowWatcher mLightingShowWatcher;
/*     */   private TcamCallback mTcamCallback;
/*     */   private TcamManager mTcamManager;
/*     */   
/*     */   public static LightShowImpl create(Context paramContext) {
/*     */     /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/lightshow/LightShowImpl}} */
/*  35 */     if (paramContext != null)
/*  36 */       try { LightShowImpl lightShowImpl1 = new LightShowImpl(); this(paramContext); mLightShowImpl = lightShowImpl1;
/*  37 */         LightingShowInfoImpl lightingShowInfoImpl = new LightingShowInfoImpl(); this(); mLightingShowInfoImpl = lightingShowInfoImpl; }
/*     */       finally {} 
/*  39 */     LightShowImpl lightShowImpl = mLightShowImpl; /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/lightshow/LightShowImpl}} */ return lightShowImpl;
/*     */   }
/*     */   
/*     */   private LightShowImpl(Context paramContext) {
/*  43 */     this.mContext = paramContext;
/*  44 */     if (this.mContext != null) {
/*  45 */       this.mTcamManager = TcamManager.getInstance(this.mContext);
/*  46 */       if (this.mTcamManager != null) {
/*  47 */         this.mTcamCallback = new TcamCallback();
/*  48 */         this.mTcamManager.registerCallback((ITcamServiceCallback)this.mTcamCallback);
/*     */       } else {
/*  50 */         Log.e("LightShowImpl", "mTcamManager is null");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String changedShowState(int paramInt) {
/*  56 */     String str = "SHOW_STATE_UNKNOWN";
/*  57 */     if (paramInt != 255) { switch (paramInt)
/*     */       
/*     */       { 
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
/*     */         default:
/*  82 */           return str;
/*     */         case 6: str = "SHOW_STATE_PREPARE";
/*     */         case 5: str = "SHOW_STATE_ERROR";
/*     */         case 4: str = "SHOW_STATE_END";
/*     */         case 3: str = "SHOW_STATE_STOP";
/*     */         case 2:
/*     */           str = "SHOW_STATE_SHOWING";
/*     */         case 1:
/*  90 */           break; }  str = "SHOW_STATE_START"; }  str = "SHOW_STATE_IDLE"; } public FunctionStatus isLightingShowEnabled() { FunctionStatus functionStatus = FunctionStatus.notavailable;
/*  91 */     int i = this.mTcamManager.islightingshowenabled();
/*  92 */     if (FunctionStatus.active.ordinal() == i) {
/*  93 */       functionStatus = FunctionStatus.active;
/*  94 */     } else if (FunctionStatus.notactive.ordinal() == i) {
/*  95 */       functionStatus = FunctionStatus.notactive;
/*  96 */     } else if (FunctionStatus.error.ordinal() == i) {
/*  97 */       functionStatus = FunctionStatus.error;
/*     */     } 
/*  99 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isLightingShowEnabled: "); stringBuilder.append(functionStatus); Log.d("LightShowImpl", stringBuilder.toString());
/* 100 */     return functionStatus; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightingShowState() {
/* 108 */     return this.mTcamManager.getLightingShowState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getLightingShowError() {
/* 116 */     return this.mTcamManager.getLightingShowError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLightingShowType(int paramInt) {
/* 124 */     boolean bool = false;
/*     */     
/* 126 */     if (this.mTcamManager != null) {
/* 127 */       bool = this.mTcamManager.setLightingShowType(paramInt);
/*     */     } else {
/* 129 */       StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("mTcamManager is null or ShowType error"); stringBuilder1.append(paramInt); Log.e("LightShowImpl", stringBuilder1.toString());
/*     */     } 
/* 131 */     if (bool) {
/* 132 */       mLightingShowInfoImpl.setShowType(paramInt);
/*     */     }
/* 134 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setLightingShowType(1:SHOW_TYPE_EXTERIOR, 2:SHOW_TYPE_INTERIOR): "); stringBuilder.append(paramInt); stringBuilder.append(" result: "); stringBuilder.append(bool); Log.d("LightShowImpl", stringBuilder.toString());
/*     */     
/* 136 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightingShowType() {
/* 146 */     return this.mTcamManager.getLightingShowType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLightingShowMode(int paramInt) {
/* 157 */     boolean bool = false;
/* 158 */     if (this.mTcamManager != null) {
/* 159 */       bool = this.mTcamManager.setLightShowMode(paramInt);
/*     */     } else {
/* 161 */       StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("mTcamManager is null or ShowMode error"); stringBuilder1.append(paramInt); Log.e("LightShowImpl", stringBuilder1.toString());
/*     */     } 
/* 163 */     if (bool) {
/* 164 */       mLightingShowInfoImpl.setShowMode(paramInt);
/*     */     }
/* 166 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setLightingShowMode(1:SHOW_MODE_SINGLE, 2:SHOW_MODE_MULTIPLE): "); stringBuilder.append(paramInt); stringBuilder.append(" result: "); stringBuilder.append(bool); Log.d("LightShowImpl", stringBuilder.toString());
/*     */     
/* 168 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightingShowMode() {
/* 178 */     return this.mTcamManager.getLightShowMode();
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
/*     */   public ILightingShow.ILightingShowInfo[] getLightingShowInfo(int paramInt) {
/* 190 */     ILightingShow.ILightingShowInfo[] arrayOfILightingShowInfo = new ILightingShow.ILightingShowInfo[1];
/* 191 */     if (1 == paramInt) {
/* 192 */       arrayOfILightingShowInfo[0] = mLightingShowInfoImpl;
/*     */     }
/* 194 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getLightingShowInfo（1:SHOW_TYPE_EXTERIOR, 2:SHOW_TYPE_INTERIOR）: "); stringBuilder.append(paramInt); Log.d("LightShowImpl", stringBuilder.toString());
/* 195 */     return arrayOfILightingShowInfo;
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
/*     */   public int[] getVehicleIpTable(int paramInt) {
/* 208 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getVehicleIpTable: "); stringBuilder.append(paramInt); Log.d("LightShowImpl", stringBuilder.toString());
/* 209 */     if (1 == paramInt)
/* 210 */       return new int[] { this.mTcamManager.getExternalTcamIp() }; 
/* 211 */     if (2 == paramInt)
/* 212 */       return this.mTcamManager.getMasterTcamExtIp(); 
/* 213 */     if (3 == paramInt) {
/* 214 */       return this.mTcamManager.getSlaveTcamExtIp();
/*     */     }
/* 216 */     return new int[0];
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
/*     */   public boolean sendIpMessage(int paramInt, String paramString) {
/* 229 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sendLightingShowSourceStart() {
/* 240 */     boolean bool = this.mTcamManager.sendLightingShowSourceStart();
/* 241 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("sendLightingShowSourceStart isOk: "); stringBuilder.append(bool); Log.d("LightShowImpl", stringBuilder.toString());
/* 242 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sendLightingShowSourceEnd() {
/* 253 */     boolean bool = this.mTcamManager.sendLightingShowSourceEnd();
/* 254 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("sendLightingShowSourceEnd: "); stringBuilder.append(bool); Log.d("LightShowImpl", stringBuilder.toString());
/* 255 */     return bool;
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
/*     */   public boolean sendLightingShowSource(byte[] paramArrayOfbyte) {
/* 267 */     boolean bool = this.mTcamManager.sendLightingShowSource(paramArrayOfbyte);
/* 268 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("sendLightingShowSource: "); stringBuilder.append(bool); Log.d("LightShowImpl", stringBuilder.toString());
/* 269 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startLightingShow() {
/* 277 */     boolean bool = this.mTcamManager.startLightingShow();
/* 278 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("startLightingShow: "); stringBuilder.append(bool); Log.d("LightShowImpl", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopLightingShow() {
/* 286 */     boolean bool = this.mTcamManager.stopLightingShow();
/* 287 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("stopLightingShow: "); stringBuilder.append(bool); Log.d("LightShowImpl", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerLightingShowWatcher(ILightingShow.ILightingShowWatcher paramILightingShowWatcher) {
/* 295 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerLightingShowWatcher: "); stringBuilder.append(paramILightingShowWatcher); Log.e("LightShowImpl", stringBuilder.toString());
/* 296 */     if (paramILightingShowWatcher != null) {
/* 297 */       this.mLightingShowWatcher = paramILightingShowWatcher;
/*     */     } else {
/* 299 */       Log.e("LightShowImpl", "watcher is null");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterLightingShowWatcher(ILightingShow.ILightingShowWatcher paramILightingShowWatcher) {
/* 308 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("unregisterLightingShowWatcher: "); stringBuilder.append(paramILightingShowWatcher); Log.e("LightShowImpl", stringBuilder.toString());
/* 309 */     if (this.mLightingShowWatcher != null) {
/* 310 */       this.mLightingShowWatcher = null;
/*     */     } else {
/* 312 */       Log.e("LightShowImpl", "mLightingShowWatcher is null");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private class TcamCallback
/*     */     extends TcamServiceCallbackImpl
/*     */   {
/*     */     final LightShowImpl this$0;
/*     */     
/*     */     private TcamCallback() {}
/*     */     
/*     */     public void onExternalTcamIpNotify(int param1Int) {
/* 325 */       super.onExternalTcamIpNotify(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSlaveTcamExtIpNotifyCyclic(int[] param1ArrayOfint) {
/* 335 */       super.onSlaveTcamExtIpNotifyCyclic(param1ArrayOfint);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onMasterTcamExtIpNotifyCyclic(int[] param1ArrayOfint) {
/* 345 */       super.onMasterTcamExtIpNotifyCyclic(param1ArrayOfint);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onLightingShowEnableChanged(int param1Int) {
/* 355 */       super.onLightingShowEnableChanged(param1Int);
/* 356 */       if (LightShowImpl.this.mLightingShowWatcher != null) {
/* 357 */         FunctionStatus functionStatus = FunctionStatus.notavailable;
/* 358 */         if (FunctionStatus.active.ordinal() == param1Int) {
/* 359 */           functionStatus = FunctionStatus.active;
/* 360 */         } else if (FunctionStatus.notactive.ordinal() == param1Int) {
/* 361 */           functionStatus = FunctionStatus.notactive;
/* 362 */         } else if (FunctionStatus.error.ordinal() == param1Int) {
/* 363 */           functionStatus = FunctionStatus.error;
/* 364 */         } else if (FunctionStatus.notavailable.ordinal() == param1Int) {
/* 365 */           functionStatus = FunctionStatus.notavailable;
/*     */         } 
/* 367 */         LightShowImpl.this.mLightingShowWatcher.onLightingShowEnableChanged(functionStatus);
/* 368 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onLightingShowEnableChanged: "); stringBuilder.append(functionStatus); Log.d("LightShowImpl", stringBuilder.toString());
/*     */       } else {
/* 370 */         Log.e("LightShowImpl", "onLightingShowEnableChanged: mLightingShowWatcher is null");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onLightingShowStateChanged(int param1Int) {
/* 381 */       if (LightShowImpl.this.mLightingShowWatcher != null) {
/* 382 */         LightShowImpl.this.mLightingShowWatcher.onLightingShowStateChanged(param1Int);
/* 383 */         if (255 == param1Int)
/*     */         {
/* 385 */           LightShowImpl.mLightingShowInfoImpl.clearLightShowInfo();
/*     */         }
/* 387 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onLightingShowStateChanged: "); stringBuilder.append(LightShowImpl.changedShowState(param1Int)); Log.d("LightShowImpl", stringBuilder.toString());
/*     */       } else {
/* 389 */         Log.e("LightShowImpl", "onLightingShowStateChanged: mLightingShowWatcher is null");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onLightingShowError(int[] param1ArrayOfint) {
/* 400 */       if (LightShowImpl.this.mLightingShowWatcher != null) {
/* 401 */         LightShowImpl.this.mLightingShowWatcher.onLightingShowError(param1ArrayOfint);
/* 402 */         Log.d("LightShowImpl", "onLightingShowError");
/*     */       } else {
/* 404 */         Log.e("LightShowImpl", "onLightingShowStateChanged: mLightingShowWatcher is null");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightShowFileDownloadReq() {
/* 415 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int setLightShowFileRequestResult(int paramInt) {
/* 424 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int setLightShowFileDownloadResult(int paramInt) {
/* 433 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isLightingShowFileDownload() {
/* 442 */     return FunctionStatus.active;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isWelcomeLightFileDownload() {
/* 451 */     return FunctionStatus.active;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\lightshow\LightShowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */