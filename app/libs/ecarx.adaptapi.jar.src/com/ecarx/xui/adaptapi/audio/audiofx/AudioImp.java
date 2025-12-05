/*     */ package com.ecarx.xui.adaptapi.audio.audiofx;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.media.AudioManager;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.util.Log;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ import com.ecarx.car.audio.manager.IAudioSettingsCallback;
/*     */ import com.ecarx.xui.adaptapi.CallStatus;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.os.LocalConfig;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AudioImp
/*     */   extends Audio
/*     */   implements ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final int HIGH_EX11_NG08 = 133;
/*     */   private static final int HIGH_KX11_NG06 = 132;
/*     */   private static final int LOW_KX11_NG02_NG01 = 128;
/*     */   private static final int MID_EX11_NG03 = 129;
/*     */   private static final int MID_KX11_NG03 = 130;
/*     */   private static final int PRODUCT_EX11 = 161;
/*     */   private static final int PRODUCT_KX11 = 162;
/*     */   private static final String TAG = "AudioImp";
/*     */   private static AudioImp instance;
/*     */   private IAudioState audioState;
/*     */   
/*     */   public CallStatus switchAudioChannel(int paramInt) {
/*  41 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ICompensation compensation;
/*     */   private IEqualizer equalizer;
/*     */   private IFaderBalance faderBalance;
/*     */   private IHarmanEqualizer harmanEqualizer;
/*     */   private AudioManager mAudioManager;
/*     */   
/*     */   public int getAudioChannel() {
/*  52 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private Audio.IAudioSettingListener mAudioSettingListener;
/*     */   
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private Context mContext;
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */   private EcarxAudioManager mEcarxAudioManager;
/*     */   
/*     */   public FunctionStatus getSpeakerStatus(String paramString) {
/*  64 */     return null;
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
/*     */   public void setSpeakerStatusListener(String paramString, Audio.ISpeakerListener paramISpeakerListener) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus getMicStatus(String paramString) {
/*  86 */     return null;
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
/*     */   public void setMicStatusListener(String paramString, Audio.IMicStatusListener paramIMicStatusListener) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CallStatus setMicOccupyState(int paramInt) {
/* 108 */     return null;
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
/*     */   public CallStatus setVRState(int paramInt1, @MicState int paramInt2) {
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getICCMICState() {
/* 132 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerICCMICStateListener(Audio.IICCMICStateListener paramIICCMICStateListener) {
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterICCMICStateListener(Audio.IICCMICStateListener paramIICCMICStateListener) {
/* 152 */     return false;
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
/*     */   public void startVrPasTts(int paramInt) {}
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
/*     */   public void stopVrPasTts() {}
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
/*     */   public void setVRPasTTSSoundZoneSwitchState(int paramInt) {}
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
/*     */   public AudioImp(Context paramContext) {
/* 200 */     this.mContext = paramContext;
/* 201 */     this.equalizer = new EqualizerImp(paramContext);
/* 202 */     this.faderBalance = new FaderBalanceImp(paramContext);
/* 203 */     this.compensation = new CompensationImp(paramContext);
/* 204 */     this.audioState = new AudioStateImp(paramContext);
/* 205 */     this.harmanEqualizer = new HarmanEqualizerImp(paramContext);
/*     */     
/* 207 */     ServiceConnection serviceConnection = new ServiceConnection() { final AudioImp this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/* 210 */           if (AudioImp.this.mEcarxAudioManager == null) {
/* 211 */             Log.e("AudioImp", "onServiceConnected ---> mEcarxAudioManager is null");
/*     */           }
/* 213 */           Log.d("AudioImp", "onServiceConnected done");
/*     */         }
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName)
/*     */         {
/* 218 */           if (AudioImp.this.mEcarxAudioManager != null) {
/* 219 */             AudioImp.this.mEcarxAudioManager.connect();
/* 220 */             Log.d("AudioImp", "onServiceDisconnected ---> mEcarxAudioManager.connect()");
/*     */           } 
/* 222 */           Log.d("AudioImp", "onServiceDisconnected done"); } }
/*     */       ;
/* 224 */     Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
/* 225 */     this.mEcarxAudioManager.connect();
/* 226 */     this.mEcarxAudioManager.registerAudioSettingsCallback((IAudioSettingsCallback)new AudioSettingsCallback());
/* 227 */     Log.d("AudioImp", "AudioImp ---> mEcarxAudioManager.connect()");
/* 228 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/* 229 */     this.mECarXCarProxy.initECarXCar();
/* 230 */     this.mAudioManager = (AudioManager)this.mContext.getSystemService("audio");
/*     */   }
/*     */   
/*     */   public static Audio create(Context paramContext) {
/* 234 */     if (paramContext != null && instance == null)
/* 235 */       instance = new AudioImp(paramContext); 
/* 236 */     return instance;
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
/*     */   public IFaderBalance getFaderBalance() {
/* 248 */     return this.faderBalance;
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
/*     */   public IEqualizer getEqualizer() {
/* 260 */     return this.equalizer;
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
/*     */   public ICompensation getCompensation() {
/* 272 */     return this.compensation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAudioState getAudioState() {
/* 282 */     return this.audioState;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAudioProvider() {
/* 312 */     if (isKXSupportBoseMode()) {
/* 313 */       Log.d("AudioImp", "getAudioProvider   IAudioState.AUDIO_PROVIDER_BOSE");
/* 314 */       return 2;
/* 315 */     }  if (isKXSupportHarmanMode()) {
/* 316 */       Log.d("AudioImp", "getAudioProvider   IAudioState.AUDIO_PROVIDER_HARMAN");
/* 317 */       return 1;
/*     */     } 
/* 319 */     Log.d("AudioImp", "getAudioProvider  IAudioState.AUDIO_PROVIDER_DEFAULT");
/* 320 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isKXSupportBoseMode() {
/*     */     try {
/* 332 */       int i = this.mCarSignalManager.getcarconfig358();
/* 333 */       int j = this.mCarSignalManager.getcarconfig28();
/* 334 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("isKXSupportBoseMode carconfig358: 0x"); stringBuilder.append(Integer.toHexString(i)); stringBuilder.append(" carconfig28: 0x ");
/* 335 */       stringBuilder.append(Integer.toHexString(j)); String str = stringBuilder.toString();
/*     */       
/*     */       Log.d("AudioImp", str);
/* 338 */       if (i == 2 && j == 3) {
/* 339 */         Log.d("AudioImp", "isKXSupportBoseMode carconfig match, KX support RoomMode");
/* 340 */         return true;
/*     */       } 
/* 342 */       Log.d("AudioImp", "isKXSupportBoseMode carconfig not match, KX not support RoomMode");
/*     */       
/* 344 */       return false;
/*     */     }
/* 346 */     catch (Exception exception) {
/* 347 */       exception.printStackTrace();
/*     */       
/* 349 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isKXSupportHarmanMode() {
/*     */     try {
/* 359 */       int i = this.mCarSignalManager.getcarconfig358();
/* 360 */       int j = this.mCarSignalManager.getcarconfig28();
/* 361 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("isKXSupportHarmanMode carconfig358: 0x"); stringBuilder.append(Integer.toHexString(i)); stringBuilder.append(" carconfig28: 0x ");
/* 362 */       stringBuilder.append(Integer.toHexString(j)); String str = stringBuilder.toString();
/*     */       
/*     */       Log.d("AudioImp", str);
/* 365 */       if (i == 1 && j == 3) {
/* 366 */         Log.d("AudioImp", "isKXSupportHarmanMode carconfig match, KX support HarmanMode");
/* 367 */         return true;
/*     */       } 
/* 369 */       Log.d("AudioImp", "isKXSupportHarmanMode carconfig not match, KX not support HarmanMode");
/*     */       
/* 371 */       return false;
/*     */     }
/* 373 */     catch (Exception exception) {
/* 374 */       exception.printStackTrace();
/*     */       
/* 376 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isEXSupportBoseMode() {
/*     */     try {
/* 386 */       int j = this.mCarSignalManager.getcarconfig1();
/* 387 */       int i = this.mCarSignalManager.getcarconfig466();
/* 388 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("isEXSupportBoseMode carconfig1: 0x"); stringBuilder.append(Integer.toHexString(j)); Log.d("AudioImp", stringBuilder.toString());
/* 389 */       stringBuilder = new StringBuilder(); this(); stringBuilder.append("isEXSupportBoseMode carconfig466: 0x"); stringBuilder.append(Integer.toHexString(i)); Log.d("AudioImp", stringBuilder.toString());
/*     */       
/* 391 */       if (j == 161 && i == 133) {
/* 392 */         Log.d("AudioImp", "isEXSupportBoseMode carconfig match, EX support RoomMode");
/* 393 */         return true;
/*     */       } 
/* 395 */       Log.d("AudioImp", "isEXSupportBoseMode carconfig not match，EX not support RoomMode");
/*     */       
/* 397 */       return false;
/*     */     }
/* 399 */     catch (Exception exception) {
/* 400 */       exception.printStackTrace();
/*     */       
/* 402 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IHarmanEqualizer getHarmanEqualizer() {
/* 412 */     return new HarmanEqualizerImp(this.mContext);
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
/*     */   public void setNaviVoiceMixMode(int paramInt) {
/* 427 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setNaviVoiceMixMode   mode:"); stringBuilder.append(paramInt); Log.d("AudioImp", stringBuilder.toString());
/* 428 */     if (paramInt == 1) {
/* 429 */       this.mEcarxAudioManager.setMixMode(1);
/*     */     } else {
/* 431 */       this.mEcarxAudioManager.setMixMode(0);
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
/*     */   public void setBootUpMusicOnOff(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeatSoundStageOptimize(int paramInt) {
/* 452 */     int i = this.mEcarxAudioManager.getSeatOptimization();
/* 453 */     byte b = 2;
/*     */     
/* 455 */     if (this.mEcarxAudioManager == null) {
/* 456 */       Log.e("AudioImp", "setSeatSoundStageOptimize--->mEcarxAudioManager is null, return");
/*     */       
/*     */       return;
/*     */     } 
/* 460 */     if (85 == (paramInt & 0x55)) {
/*     */ 
/*     */       
/* 463 */       b = 2;
/* 464 */       Log.d("AudioImp", "setSeatSoundStageOptimize: seatZone: ALL");
/* 465 */     } else if (1 == (paramInt & 0x1)) {
/*     */       
/* 467 */       b = 0;
/* 468 */       Log.d("AudioImp", "setSeatSoundStageOptimize: seatZone: Driver");
/* 469 */     } else if (80 == (paramInt & 0x50)) {
/*     */ 
/*     */       
/* 472 */       b = 1;
/* 473 */       Log.d("AudioImp", "setSeatSoundStageOptimize: seatZone: Rear");
/*     */     } else {
/* 475 */       Log.w("AudioImp", "setSeatSoundStageOptimize: seatZone: Unknown");
/*     */     } 
/*     */     
/* 478 */     if (b != i) {
/* 479 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setSeatSoundStageOptimize: seatZone: 0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(", type: 0x");
/* 480 */       stringBuilder.append(Integer.toHexString(b)); String str = stringBuilder.toString(); Log.d("AudioImp", str);
/* 481 */       if (this.mEcarxAudioManager == null) {
/* 482 */         Log.e("AudioImp", "setSeatSoundStageOptimize--->mEcarxAudioManager is null");
/*     */       }
/* 484 */       this.mEcarxAudioManager.setSeatOptimization(b);
/* 485 */       if (this.mAudioSettingListener != null) {
/* 486 */         this.mAudioSettingListener.onAudioSettingStateChanged(4099);
/*     */       }
/*     */     } else {
/* 489 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setSeatSoundStageOptimize: seatZone: 0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(", type: 0x");
/* 490 */       stringBuilder.append(Integer.toHexString(b)); stringBuilder.append(" no change"); String str = stringBuilder.toString();
/*     */       Log.w("AudioImp", str);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isAudioSettingSupported(int paramInt) {
/* 502 */     if (4097 == paramInt)
/*     */     {
/* 504 */       return FunctionStatus.active;
/*     */     }
/* 506 */     if (4098 == paramInt)
/* 507 */       return FunctionStatus.notavailable; 
/* 508 */     if (4099 == paramInt) {
/* 509 */       if (isInnerAMP() || isSupportMobis()) {
/* 510 */         Log.d("AudioImp", "isInnerAMP() || isSupportMobis()   AUDIO_SETTING_SEAT_SOUND_OPTIMIZE  FunctionStatus.active");
/* 511 */         return FunctionStatus.active;
/*     */       } 
/* 513 */       Log.d("AudioImp", "not support AUDIO_SETTING_SEAT_SOUND_OPTIMIZE");
/* 514 */       return FunctionStatus.notavailable;
/*     */     } 
/*     */ 
/*     */     
/* 518 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isAudioSettingSupported --- > audioSetting(0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(") invalid param"); Log.e("AudioImp", stringBuilder.toString());
/* 519 */     return FunctionStatus.error;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSupportMobis() {
/*     */     try {
/* 526 */       int i = this.mCarSignalManager.getcarconfig1();
/* 527 */       int j = this.mCarSignalManager.getcarconfig466();
/*     */       
/* 529 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("isSupportMobis carconfig1: "); stringBuilder.append(Integer.toHexString(i)); Log.d("AudioImp", stringBuilder.toString());
/* 530 */       stringBuilder = new StringBuilder(); this(); stringBuilder.append("isSupportMobis carconfig466: "); stringBuilder.append(Integer.toHexString(j)); Log.d("AudioImp", stringBuilder.toString());
/*     */ 
/*     */       
/* 533 */       if (i == 161 && (j == 129 || j == 130 || j == 133)) {
/*     */         
/* 535 */         Log.d("AudioImp", "isSupportMobis  return: true");
/* 536 */         return true;
/*     */       } 
/* 538 */       Log.d("AudioImp", "isSupportMobis  return: false");
/* 539 */       return false;
/*     */     }
/* 541 */     catch (CarNotConnectedException carNotConnectedException) {
/* 542 */       carNotConnectedException.printStackTrace();
/*     */       
/* 544 */       return true;
/*     */     } 
/*     */   }
/*     */   private boolean isInnerAMP() {
/*     */     try {
/* 549 */       if (this.mCarSignalManager.getcarconfig1() == 161 && this.mCarSignalManager.getcarconfig466() == 128) {
/* 550 */         Log.d("AudioImp", "isInnerAMP  true");
/* 551 */         return true;
/*     */       } 
/* 553 */       Log.d("AudioImp", "isInnerAMP  false");
/* 554 */       return false;
/*     */     }
/* 556 */     catch (CarNotConnectedException carNotConnectedException) {
/* 557 */       carNotConnectedException.printStackTrace();
/*     */       
/* 559 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerAudioSettingListener(Audio.IAudioSettingListener paramIAudioSettingListener) {
/*     */     boolean bool;
/* 567 */     this.mAudioSettingListener = paramIAudioSettingListener;
/* 568 */     if (this.mAudioSettingListener != null) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterAudioSettingListener(Audio.IAudioSettingListener paramIAudioSettingListener) {
/* 576 */     this.mAudioSettingListener = null;
/* 577 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAudioSystemLevel() {
/* 588 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSourroundSoundLevel() {
/* 599 */     int i = 0;
/* 600 */     if (this.mEcarxAudioManager != null) {
/* 601 */       i = this.mEcarxAudioManager.getTwoSurroundLvl();
/*     */     } else {
/* 603 */       Log.d("AudioImp", "getSourroundSoundLevel mEcarxAudioManager : null");
/*     */     } 
/* 605 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSourroundSoundLevel : "); stringBuilder.append(i); Log.d("AudioImp", stringBuilder.toString());
/* 606 */     return i;
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
/*     */   public void setSourroundSoundLevel(int paramInt) {
/* 618 */     if (this.mEcarxAudioManager != null) {
/* 619 */       this.mEcarxAudioManager.setTwoSurroundLvl(paramInt);
/* 620 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setSourroundSoundLevel : "); stringBuilder.append(paramInt); Log.d("AudioImp", stringBuilder.toString());
/*     */     } else {
/* 622 */       Log.d("AudioImp", "setSourroundSoundLevel mEcarxAudioManager : null");
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
/*     */   public boolean isSurroundSoundLevelSupported() {
/* 635 */     String str = (String)LocalConfig.get().getValue(LocalConfig.KEY.LCFG_SurroundSoundSelection, "2");
/* 636 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isSurroundSoundLevelSupported config : "); stringBuilder.append(str); Log.d("AudioImp", stringBuilder.toString());
/* 637 */     return "0".equals(str) ^ true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSurroundSoundOn() {
/* 648 */     boolean bool = false;
/* 649 */     if (this.mEcarxAudioManager != null) {
/* 650 */       bool = this.mEcarxAudioManager.isTwoSurroundEnabled();
/*     */     } else {
/* 652 */       Log.d("AudioImp", "isSurroundSoundOn mEcarxAudioManager : null");
/*     */     } 
/* 654 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isSurroundSoundOn : "); stringBuilder.append(bool); Log.d("AudioImp", stringBuilder.toString());
/* 655 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSurroundSoundOnOff(boolean paramBoolean) {
/* 666 */     if (this.mEcarxAudioManager != null) {
/* 667 */       this.mEcarxAudioManager.setTwoSurround(paramBoolean);
/* 668 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setSurroundSoundOnOff : "); stringBuilder.append(paramBoolean); Log.d("AudioImp", stringBuilder.toString());
/*     */     } else {
/* 670 */       Log.d("AudioImp", "setSurroundSoundOnOff mEcarxAudioManager : null");
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
/*     */   public int getPresetMode() {
/* 682 */     return 0;
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
/*     */   public void setPresetMode(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getControlZonesByMode(int paramInt) {
/* 705 */     return new int[0];
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
/*     */   public void setControlZoneEnable(int paramInt1, int paramInt2, boolean paramBoolean) {}
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
/*     */   public boolean isControlZoneEnable(int paramInt1, int paramInt2) {
/* 731 */     return false;
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
/*     */   public List<String[]> getExternalArtificialSoundList() {
/* 743 */     return null;
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
/*     */   public Map<Integer, String> getExternalVirtualEngineSoundPathMap() {
/* 755 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceConnected(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/*     */     try {
/* 767 */       this.mCarSignalManager = paramCarSignalManager;
/* 768 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("onECarXCarServiceConnected, mCarSignalManager="); stringBuilder.append(this.mCarSignalManager); Log.i("AudioImp", stringBuilder.toString());
/* 769 */     } catch (Exception exception) {
/* 770 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 779 */     Log.w("AudioImp", "onECarXCarServiceDeath");
/* 780 */     this.mCarSignalManager = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void switchAudioChannel(int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class AudioSettingsCallback
/*     */     extends IAudioSettingsCallback.Stub
/*     */   {
/*     */     final AudioImp this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSoundEffectsStatusChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onPDCWarningChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onMixModeChanged(int param1Int) {
/* 810 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onMixModeChanged:"); stringBuilder.append(param1Int); Log.d("AudioImp", stringBuilder.toString());
/* 811 */       byte b = 2;
/* 812 */       if (param1Int == 1) {
/* 813 */         b = 1;
/*     */       }
/* 815 */       if (AudioImp.this.mAudioSettingListener != null) {
/* 816 */         AudioImp.this.mAudioSettingListener.onNaviMixModeChanged(b);
/*     */       } else {
/* 818 */         Log.d("AudioImp", "mAudioSettingValueListener is null");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onLoudnessChanged(boolean param1Boolean) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onTwoSurroundChanged(boolean param1Boolean) {
/* 829 */       AudioImp.this.mAudioSettingListener.onTwoSurroundChanged(param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\AudioImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */