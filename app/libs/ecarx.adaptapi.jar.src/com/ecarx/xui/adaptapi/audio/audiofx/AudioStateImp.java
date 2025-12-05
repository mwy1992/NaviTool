/*     */ package com.ecarx.xui.adaptapi.audio.audiofx;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.media.AudioManager;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.util.Log;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ 
/*     */ 
/*     */ public class AudioStateImp
/*     */   implements IAudioState
/*     */ {
/*     */   private static final String TAG = "AudioStateImp";
/*     */   private AudioManager mAudioManager;
/*     */   private EcarxAudioManager mEcarxAudioManager;
/*     */   
/*     */   public AudioStateImp(Context paramContext) {
/*  22 */     this.mAudioManager = (AudioManager)paramContext.getSystemService("audio");
/*  23 */     ServiceConnection serviceConnection = new ServiceConnection() { final AudioStateImp this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  26 */           if (AudioStateImp.this.mEcarxAudioManager == null) {
/*  27 */             Log.e("AudioStateImp", "onServiceConnected ---> mEcarxAudioManager is null");
/*     */           }
/*  29 */           Log.d("AudioStateImp", "onServiceConnected done");
/*     */         }
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/*  34 */           if (AudioStateImp.this.mEcarxAudioManager != null) {
/*  35 */             AudioStateImp.this.mEcarxAudioManager.connect();
/*  36 */             Log.d("AudioStateImp", "onServiceDisconnected ---> mEcarxAudioManager.connect()");
/*     */           } 
/*  38 */           Log.d("AudioStateImp", "onServiceDisconnected done"); } }
/*     */       ;
/*  40 */     Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
/*  41 */     this.mEcarxAudioManager.connect();
/*  42 */     Log.d("AudioStateImp", "AudioStateImp ---> mEcarxAudioManager.connect()");
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
/*     */   public int getNaviVoiceMixMode() {
/*  59 */     if (this.mEcarxAudioManager.getMixMode() == 1) {
/*  60 */       Log.d("AudioStateImp", "getNaviVoiceMixMode  NAVI_VOICE_MIX_AUTO");
/*  61 */       return 1;
/*     */     } 
/*  63 */     Log.d("AudioStateImp", "getNaviVoiceMixMode  NAVI_VOICE_MIX_DIRECTLY");
/*  64 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSoundStageOptimizedSeat() {
/*  75 */     byte b = 85;
/*     */     
/*  77 */     if (this.mEcarxAudioManager == null) {
/*  78 */       StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("getSoundStageOptimizedSeat--->mEcarxAudioManager is null, zone: 0x"); stringBuilder1.append(Integer.toHexString(85)); Log.e("AudioStateImp", stringBuilder1.toString());
/*  79 */       return 85;
/*     */     } 
/*     */     
/*  82 */     int i = this.mEcarxAudioManager.getSeatOptimization();
/*     */     
/*  84 */     switch (i) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/*  93 */         b = 85; break;
/*     */       case 1:
/*     */         b = 80; break;
/*     */       case 0:
/*     */         b = 1; break;
/*     */     } 
/*  99 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSoundStageOptimizedSeat: type: 0x"); stringBuilder.append(Integer.toHexString(i)); stringBuilder.append(", zone: 0x");
/* 100 */     stringBuilder.append(Integer.toHexString(b)); String str = stringBuilder.toString(); Log.d("AudioStateImp", str);
/* 101 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSoundStageOptimizedSeatSupported() {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBootUpMusicOn() {
/* 121 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\AudioStateImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */