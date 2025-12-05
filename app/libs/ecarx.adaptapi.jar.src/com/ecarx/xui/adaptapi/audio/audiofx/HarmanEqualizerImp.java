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
/*     */ import com.ecarx.car.audio.manager.IHarmanEqualizerCallback;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HarmanEqualizerImp
/*     */   implements IHarmanEqualizer
/*     */ {
/*     */   private static final int INVALID_STATUS = -1;
/*     */   private static final String TAG = "HarmanEqualizerImp";
/*     */   Context mContext;
/*     */   private EcarxAudioManager mEcarxAudioManager;
/*  25 */   private IHarmanEqualizer.IHarmanSettingListener mHarmanSettingListener = null;
/*     */ 
/*     */   
/*     */   public HarmanEqualizerImp(Context paramContext) {
/*  29 */     this.mContext = paramContext;
/*  30 */     ServiceConnection serviceConnection = new ServiceConnection() { final HarmanEqualizerImp this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  33 */           if (HarmanEqualizerImp.this.mEcarxAudioManager == null) {
/*  34 */             Log.e("HarmanEqualizerImp", "onServiceConnected mEcarxAudioManager is null");
/*     */           }
/*  36 */           Log.d("HarmanEqualizerImp", "onServiceConnected");
/*     */         }
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/*  41 */           if (HarmanEqualizerImp.this.mEcarxAudioManager != null) {
/*  42 */             HarmanEqualizerImp.this.mEcarxAudioManager.connect();
/*  43 */             Log.d("HarmanEqualizerImp", "onServiceDisconnected mEcarxAudioManager.connect()");
/*     */           } 
/*  45 */           Log.d("HarmanEqualizerImp", "onServiceDisconnected"); } }
/*     */       ;
/*  47 */     Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
/*  48 */     this.mEcarxAudioManager.connect();
/*  49 */     this.mEcarxAudioManager.registerHarmanEqualizerCallback((IHarmanEqualizerCallback)new HarmanEqualizerCallback());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHarmanClariFiOnOff() {
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSurroundSoundOnOff() {
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHarmanClariFiOnOff(boolean paramBoolean) {
/*  79 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setHarmanClariFiOnOff onOff:"); stringBuilder.append(paramBoolean); Log.d("HarmanEqualizerImp", stringBuilder.toString());
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSurroundSoundOnOff(boolean paramBoolean) {
/*  90 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setSurroundSoundOnOff onOff:"); stringBuilder.append(paramBoolean); Log.d("HarmanEqualizerImp", stringBuilder.toString());
/*  91 */     return false;
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
/*     */   public short[] getBandLevelRange() {
/* 103 */     return new short[] { -10, 10 };
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
/*     */   public void setBandLevel(int paramInt, short paramShort) {
/* 117 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setBandLevel  band:"); stringBuilder.append(paramInt); stringBuilder.append("  level:"); stringBuilder.append(paramShort); Log.d("HarmanEqualizerImp", stringBuilder.toString());
/* 118 */     switch (paramInt) {
/*     */       default:
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 126 */         this.mEcarxAudioManager.setTreble(paramShort);
/*     */       case 2:
/*     */         this.mEcarxAudioManager.setMiddle(paramShort);
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     this.mEcarxAudioManager.setBass(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBandLevel(int paramInt) {
/* 142 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getBandLevel  band:"); stringBuilder.append(paramInt); Log.d("HarmanEqualizerImp", stringBuilder.toString());
/* 143 */     short s = 0;
/* 144 */     switch (paramInt) {
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
/*     */       default:
/* 157 */         return s;
/*     */       case 3:
/*     */         s = (short)this.mEcarxAudioManager.getTreble();
/*     */       case 2:
/*     */         s = (short)this.mEcarxAudioManager.getMiddle();
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     s = (short)this.mEcarxAudioManager.getBass();
/*     */   }
/*     */   
/* 168 */   public FunctionStatus isHarmanSettingSupported(int paramInt) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isHarmanSettingSupported   harmanSetting:"); stringBuilder.append(paramInt); Log.d("HarmanEqualizerImp", stringBuilder.toString());
/* 169 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 177 */         return FunctionStatus.notavailable;
/*     */       case 8195:
/*     */         return FunctionStatus.active;
/*     */       case 8194:
/*     */         return FunctionStatus.active;
/*     */       case 8193:
/*     */         break;
/*     */     } 
/*     */     return FunctionStatus.active; } public boolean registerHarmanSettingListener(IHarmanEqualizer.IHarmanSettingListener paramIHarmanSettingListener) {
/* 186 */     Log.d("HarmanEqualizerImp", "registerHarmanSettingListener");
/* 187 */     this.mHarmanSettingListener = paramIHarmanSettingListener;
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterHarmanSettingListener(IHarmanEqualizer.IHarmanSettingListener paramIHarmanSettingListener) {
/* 196 */     Log.d("HarmanEqualizerImp", "unregisterHarmanSettingListener");
/* 197 */     this.mHarmanSettingListener = null;
/* 198 */     return true;
/*     */   }
/*     */   
/*     */   class HarmanEqualizerCallback extends IHarmanEqualizerCallback.Stub { final HarmanEqualizerImp this$0;
/*     */     
/*     */     public void onBandChanged(int param1Int1, int param1Int2) throws RemoteException {
/* 204 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onBandChanged: band: "); stringBuilder.append(param1Int1); stringBuilder.append(", value: "); stringBuilder.append(param1Int2); Log.d("HarmanEqualizerImp", stringBuilder.toString());
/* 205 */       if (HarmanEqualizerImp.this.mHarmanSettingListener != null) {
/* 206 */         byte b = -1;
/* 207 */         switch (param1Int1) { default: param1Int1 = b;
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 215 */             param1Int1 = 3; break;
/*     */           case 2:
/*     */             param1Int1 = 2; break;
/*     */           case 1:
/*     */             param1Int1 = 1; break; }
/* 220 */          if (param1Int1 != -1) {
/* 221 */           HarmanEqualizerImp.this.mHarmanSettingListener.onBandChanged(param1Int1, param1Int2);
/*     */         } else {
/* 223 */           Log.e("HarmanEqualizerImp", "onBandChanged fw_band is INVALID_STATUS");
/*     */         } 
/*     */       } else {
/* 226 */         Log.e("HarmanEqualizerImp", "onBandChanged mHarmanSettingListener is null");
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\HarmanEqualizerImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */