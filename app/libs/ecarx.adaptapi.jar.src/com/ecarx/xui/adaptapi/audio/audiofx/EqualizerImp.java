/*     */ package com.ecarx.xui.adaptapi.audio.audiofx;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ import com.ecarx.car.audio.manager.IEqualizerCallback;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ 
/*     */ 
/*     */ public class EqualizerImp
/*     */   implements IEqualizer
/*     */ {
/*     */   private static final String TAG = "EqualizerImp";
/*     */   private EcarxAudioManager mEcarxAudioManager;
/*  21 */   private IEqualizer.IEqualizerStateListener mEqualizerStateListener = null;
/*     */   
/*     */   public EqualizerImp(Context paramContext) {
/*  24 */     ServiceConnection serviceConnection = new ServiceConnection() { final EqualizerImp this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  27 */           if (EqualizerImp.this.mEcarxAudioManager == null) {
/*  28 */             Log.e("EqualizerImp", "onServiceConnected mEcarxAudioManager is null");
/*     */           }
/*  30 */           Log.d("EqualizerImp", "onServiceConnected");
/*     */         }
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/*  35 */           if (EqualizerImp.this.mEcarxAudioManager != null) {
/*  36 */             EqualizerImp.this.mEcarxAudioManager.connect();
/*  37 */             Log.d("EqualizerImp", "onServiceDisconnected mEcarxAudioManager.connect()");
/*     */           } 
/*  39 */           Log.d("EqualizerImp", "onServiceDisconnected"); } }
/*     */       ;
/*  41 */     Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
/*  42 */     this.mEcarxAudioManager.connect();
/*  43 */     this.mEcarxAudioManager.registerEqualizerCallback((IEqualizerCallback)new EqualizerCallback());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumberOfBands() {
/*  54 */     return (short)this.mEcarxAudioManager.getNumberOfBands();
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
/*     */   public short[] getBandLevelRange() {
/*  68 */     return this.mEcarxAudioManager.getBandLevelRange();
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
/*     */   public void setBandLevel(short paramShort1, short paramShort2) {
/*  89 */     byte b2 = (byte)paramShort1;
/*  90 */     byte b1 = (byte)paramShort2;
/*  91 */     this.mEcarxAudioManager.setBandLevel(b2, b1);
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
/*     */   public short getBandLevel(short paramShort) {
/* 106 */     byte b = (byte)paramShort;
/* 107 */     return (short)this.mEcarxAudioManager.getBandLevel(b);
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
/*     */   public int getCenterFreq(short paramShort) {
/* 121 */     byte b = (byte)paramShort;
/* 122 */     return this.mEcarxAudioManager.getCenterFreq(b);
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
/*     */   public int[] getBandFreqRange(short paramShort) {
/* 144 */     byte b = (byte)paramShort;
/* 145 */     return this.mEcarxAudioManager.getBandFreqRange(b);
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
/*     */   public short getBand(int paramInt) {
/* 160 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("frequency:"); stringBuilder.append(paramInt); stringBuilder.append("  getBand:"); stringBuilder.append(this.mEcarxAudioManager.getBand(paramInt)); Log.d("EqualizerImp", stringBuilder.toString());
/* 161 */     return (short)this.mEcarxAudioManager.getBand(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCurrentPreset() {
/* 171 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getCurrentPreset:"); stringBuilder.append((short)this.mEcarxAudioManager.getEqualizerMode()); Log.d("EqualizerImp", stringBuilder.toString());
/* 172 */     return (short)this.mEcarxAudioManager.getEqualizerMode();
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
/*     */   public void usePreset(short paramShort) {
/* 184 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("usePreset  preset:"); stringBuilder.append(paramShort); Log.d("EqualizerImp", stringBuilder.toString());
/* 185 */     this.mEcarxAudioManager.setEqualizerMode(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumberOfPresets() {
/* 196 */     EcarxAudioManager ecarxAudioManager = this.mEcarxAudioManager; return 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPresetName(short paramShort) {
/* 207 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getPresetName:preset:"); stringBuilder.append(paramShort); stringBuilder.append("  name:"); stringBuilder.append(this.mEcarxAudioManager.getPresetName((byte)paramShort)); Log.d("EqualizerImp", stringBuilder.toString());
/*     */     
/* 209 */     return this.mEcarxAudioManager.getPresetName((byte)paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isEqualizerSupported() {
/*     */     FunctionStatus functionStatus;
/* 219 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isEqualizerSupported    mEcarxAudioManager.isInternalAmplifier:"); stringBuilder.append(this.mEcarxAudioManager.isInternalAmplifier()); Log.d("EqualizerImp", stringBuilder.toString());
/* 220 */     if (this.mEcarxAudioManager.isInternalAmplifier()) { functionStatus = FunctionStatus.active; } else { functionStatus = FunctionStatus.notavailable; }  return functionStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerEqualizerStateListener(IEqualizer.IEqualizerStateListener paramIEqualizerStateListener) {
/* 228 */     Log.d("EqualizerImp", "registerEqualizerStateListener");
/* 229 */     this.mEqualizerStateListener = paramIEqualizerStateListener;
/* 230 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterEqualizerStateListener(IEqualizer.IEqualizerStateListener paramIEqualizerStateListener) {
/* 238 */     Log.d("EqualizerImp", "unregisterEqualizerStateListener");
/* 239 */     this.mEqualizerStateListener = null;
/* 240 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxBassLevel() {
/* 251 */     return 0;
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
/*     */   public void setMaxBassLevel(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMaxBassOn() {
/* 273 */     return false;
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
/*     */   public void setMaxBassOn(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMaxBassSupported() {
/* 295 */     return false;
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
/*     */   public void setMaxBassOnOff(boolean paramBoolean) {}
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
/*     */   public int getSoundTuningSet() {
/* 323 */     return 0;
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
/*     */   public void setSoundTuningSet(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getSupportAudioEqualizerArr() {
/* 345 */     return new int[0];
/*     */   }
/*     */   
/*     */   class EqualizerCallback extends IEqualizerCallback.Stub { final EqualizerImp this$0;
/*     */     
/*     */     public void onEqualizerModeChanged(int param1Int) throws RemoteException {
/* 351 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onEqualizerModeChanged mode: "); stringBuilder.append(param1Int); Log.d("EqualizerImp", stringBuilder.toString());
/* 352 */       if (EqualizerImp.this.mEqualizerStateListener != null) {
/* 353 */         EqualizerImp.this.mEqualizerStateListener.onEqualizerModeChanged(param1Int);
/*     */       } else {
/* 355 */         Log.e("EqualizerImp", "onEqualizerModeChanged mEqualizerStateListener is null");
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\EqualizerImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */