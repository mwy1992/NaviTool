/*     */ package com.ecarx.xui.adaptapi.audio.audiofx;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.provider.Settings;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ import com.ecarx.car.audio.manager.IAudioSettingsCallback;
/*     */ import com.ecarx.car.audio.manager.ICompensationCallback;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
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
/*     */ public class CompensationImp
/*     */   implements ICompensation
/*     */ {
/*  51 */   private ICompensation.ICompensationSettingListener mCompensationSettingListener = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private final Object mECarXCarLock = new Object();
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
/*  71 */   private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { final CompensationImp this$0;
/*     */       
/*     */       public void binderDied() {
/*  74 */         Log.e("CompensationImp", "binderDied");
/*  75 */         if (CompensationImp.this.mEcarxAudioManager != null)
/*  76 */           CompensationImp.this.mEcarxAudioManager.connect(); 
/*     */       } }
/*     */   ; private static final int HIGH_EX11_NG08 = 133; private static final int HIGH_KX11_NG06 = 132; private static final int INVALID_STATUS = -1; private static final int LOW_KX11_NG02_NG01 = 128; private static final int MID_EX11_NG03 = 129; private static final int MID_KX11_NG03 = 130; private static final int PRODUCT_EX11 = 161; private static final int PRODUCT_KX11 = 162; private static final String SpeedLevelKey = "speed_level_key"; private static final String SpeedLevelKeyEnable = "speed_level_switch_enable"; private static final int SpeedLevelKeyEnableFalse = 0; private static final int SpeedLevelKeyEnableTrue = 1; private static final String TAG = "CompensationImp"; private CarSignalManager mCarSignalManager; private Context mContext; @GuardedBy("mECarXCarLock")
/*     */   private ECarXCar mECarXCar; private IECarXCar mECarXCarService; private EcarxAudioManager mEcarxAudioManager;
/*     */   
/*     */   public CompensationImp(Context paramContext) {
/*  82 */     ServiceConnection serviceConnection = new ServiceConnection() { final CompensationImp this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  85 */           Log.d("CompensationImp", "onServiceConnected");
/*  86 */           if (CompensationImp.this.mEcarxAudioManager == null) {
/*  87 */             Log.e("CompensationImp", "onServiceConnected mEcarxAudioManager is null");
/*     */           }
/*     */           
/*     */           try {
/*  91 */             param1IBinder.linkToDeath(CompensationImp.this.mDeathRecipient, 0);
/*  92 */           } catch (RemoteException remoteException) {
/*  93 */             remoteException.printStackTrace();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/*  99 */           Log.d("CompensationImp", "onServiceDisconnected");
/* 100 */           if (CompensationImp.this.mEcarxAudioManager != null) {
/* 101 */             CompensationImp.this.mEcarxAudioManager.connect();
/* 102 */             Log.d("CompensationImp", "onServiceDisconnected mEcarxAudioManager.connect()");
/*     */           }  } }
/*     */       ;
/* 105 */     Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
/* 106 */     this.mEcarxAudioManager.connect();
/* 107 */     this.mEcarxAudioManager.registerCompensationCallback((ICompensationCallback)new CompensationCallback());
/* 108 */     this.mEcarxAudioManager.registerAudioSettingsCallback((IAudioSettingsCallback)new AudioSettingsCallback());
/*     */     
/* 110 */     this.mContext = paramContext;
/* 111 */     initECarXCar();
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
/*     */   public boolean isLoudnessEnabled() {
/* 123 */     return this.mEcarxAudioManager.isLoudnessEnabled();
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
/*     */   public void setLoudnessEnable(boolean paramBoolean) {
/* 135 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setLoudnessEnable   enable:"); stringBuilder.append(paramBoolean); Log.d("CompensationImp", stringBuilder.toString());
/* 136 */     this.mEcarxAudioManager.setLoudness(paramBoolean);
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
/*     */   public boolean isSpeedCompensatedVolumeEnabled() {
/* 149 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isSpeedCompensatedVolumeEnabled   status:"); ContentResolver contentResolver = this.mContext.getContentResolver(); boolean bool = true; stringBuilder.append(Settings.System.getInt(contentResolver, "speed_level_switch_enable", 1)); Log.d("CompensationImp", stringBuilder.toString());
/* 150 */     if (Settings.System.getInt(this.mContext.getContentResolver(), "speed_level_switch_enable", 1) != 1) bool = false;  return bool;
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
/*     */   public void setSpeedCompensatedVolumeEnable(boolean paramBoolean) {
/* 162 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("++setSpeedCompensatedVolumeEnable  enable:"); stringBuilder.append(paramBoolean); Log.d("CompensationImp", stringBuilder.toString());
/* 163 */     if (!paramBoolean) {
/* 164 */       this.mEcarxAudioManager.setVehicleSpeedLevel(0);
/* 165 */       Settings.System.putInt(this.mContext.getContentResolver(), "speed_level_switch_enable", 0);
/*     */     } else {
/* 167 */       Settings.System.putInt(this.mContext.getContentResolver(), "speed_level_switch_enable", 1);
/* 168 */       int i = Settings.System.getInt(this.mContext.getContentResolver(), "speed_level_key", 2);
/* 169 */       stringBuilder = new StringBuilder(); stringBuilder.append("打开音量随速开关，设置当前等级到MCU。  level:"); stringBuilder.append(i); Log.d("CompensationImp", stringBuilder.toString());
/* 170 */       this.mEcarxAudioManager.setVehicleSpeedLevel(i);
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
/*     */ 
/*     */   
/*     */   public int getCompensationLevelOfSpeedCompensatedVolume() {
/* 200 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getCompensationLevelOfSpeedCompensatedVolume:"); Context context = this.mContext;
/* 201 */     stringBuilder.append(Settings.System.getInt(context.getContentResolver(), "speed_level_key", 2)); String str = stringBuilder.toString(); Log.d("CompensationImp", str);
/* 202 */     switch (Settings.System.getInt(this.mContext.getContentResolver(), "speed_level_key", 2)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 210 */         return 100;
/*     */       case 3:
/*     */         return 101;
/*     */       case 2:
/*     */         return 100;
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     return 99;
/*     */   }
/*     */   
/*     */   public void setCompensationLevelOfSpeedCompensatedVolume(int paramInt) {
/* 222 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setCompensationLevelOfSpeedCompensatedVolume   level:"); stringBuilder.append(paramInt); Log.d("CompensationImp", stringBuilder.toString());
/*     */     
/* 224 */     switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 236 */         paramInt = 2; break;
/*     */       case 101: paramInt = 3; break;
/*     */       case 100: paramInt = 2; break;
/* 239 */       case 99: paramInt = 1; break; }  Settings.System.putInt(this.mContext.getContentResolver(), "speed_level_key", paramInt);
/* 240 */     this.mEcarxAudioManager.setVehicleSpeedLevel(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getSupportedEffectEnhanceMode() {
/* 251 */     return new int[] { 1, 2, 4, 5 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEffectEnhanceMode() {
/*     */     StringBuilder stringBuilder;
/* 263 */     byte b = 4;
/* 264 */     switch (this.mEcarxAudioManager.getBoseRoomMode()) {
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
/*     */       default:
/* 280 */         stringBuilder = new StringBuilder(); stringBuilder.append("getEffectEnhanceMode:"); stringBuilder.append(b); Log.d("CompensationImp", stringBuilder.toString());
/* 281 */         return b;
/*     */       case 3:
/*     */         b = 5;
/*     */       case 2:
/*     */         b = 2;
/*     */       case 1:
/*     */         b = 1;
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     b = 4;
/*     */   }
/*     */   public boolean setEffectEnhanceMode(int paramInt) {
/* 294 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setEffectEnhanceMode:"); stringBuilder.append(paramInt); Log.d("CompensationImp", stringBuilder.toString());
/* 295 */     boolean bool = false;
/* 296 */     switch (paramInt) { default: paramInt = bool;
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
/* 313 */         this.mEcarxAudioManager.setBoseRoomMode(paramInt);
/* 314 */         return true;case 5: paramInt = 3; this.mEcarxAudioManager.setBoseRoomMode(paramInt); return true;case 4: paramInt = 0; this.mEcarxAudioManager.setBoseRoomMode(paramInt); return true;case 2: paramInt = 2; this.mEcarxAudioManager.setBoseRoomMode(paramInt); return true;case 1: paramInt = 1; this.mEcarxAudioManager.setBoseRoomMode(paramInt); return true;case 0: break; }  Log.d("CompensationImp", "EFFECT_ENHANCE_OFF"); paramInt = bool; this.mEcarxAudioManager.setBoseRoomMode(paramInt); return true;
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
/*     */   public boolean isDtsSoundEnabled() {
/* 327 */     return false;
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
/*     */   public int getDtsSoundMode() {
/* 340 */     return 0;
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
/*     */   public boolean setDtsSoundMode(int paramInt) {
/* 354 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isCompensationSettingSupported(int paramInt) {
/* 365 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("++isCompensationSettingSupported   compensationSetting:"); stringBuilder.append(paramInt); Log.d("CompensationImp", stringBuilder.toString());
/* 366 */     switch (paramInt)
/*     */     
/*     */     { 
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
/*     */       default:
/* 389 */         return FunctionStatus.error;
/*     */       case 5: Log.d("CompensationImp", "isCompensationSettingSupported  AUDIO_SETTING_DTS_SOUND: IHU不支持DTS音效"); return FunctionStatus.notavailable;
/*     */       case 4: if (Audio.create(this.mContext).getAudioProvider() == 2) { Log.d("CompensationImp", "isCompensationSettingSupported  AUDIO_SETTING_EFFECT_ENHANCE:AUDIO_PROVIDER_BOSE "); return FunctionStatus.active; }  Log.d("CompensationImp", "isCompensationSettingSupported  AUDIO_SETTING_EFFECT_ENHANCE:AUDIO_PROVIDER_DEFAULT "); return FunctionStatus.active;
/*     */       case 3: Log.d("CompensationImp", "isCompensationSettingSupported   AUDIO_SETTING_COMPENSATION_LEVEL:return FunctionStatus.active"); return FunctionStatus.active;
/*     */       case 2: Log.d("CompensationImp", "isCompensationSettingSupported   AUDIO_SETTING_SPEED_COMPENSATION:return FunctionStatus.active"); return FunctionStatus.active;
/*     */       case 1:
/* 395 */         break; }  return FunctionStatus.notavailable; } public void initECarXCar() { try { synchronized (this.mECarXCarLock) {
/*     */         
/* 397 */         IBinder iBinder = ServiceManager.getService("ecarxcar_service");
/*     */         this.mECarXCarService = IECarXCar.Stub.asInterface(iBinder);
/* 399 */         if (this.mContext != null && this.mECarXCarService != null) {
/* 400 */           this.mECarXCar = ECarXCar.createCar(this.mContext, this.mECarXCarService);
/*     */         }
/*     */         
/* 403 */         if (this.mECarXCar != null) {
/* 404 */           ECarXCar eCarXCar = this.mECarXCar; ECarXCar.CarServiceDieCallback carServiceDieCallback = new ECarXCar.CarServiceDieCallback() {
/*     */               final CompensationImp this$0;
/*     */               
/* 407 */               public void onServiceDeath() { Log.d("CompensationImp", "Car service died!"); }
/*     */             };
/*     */           super(this);
/*     */           eCarXCar.registerDieCallback(carServiceDieCallback);
/* 411 */           eCarXCar = this.mECarXCar;
/* 412 */           this.mCarSignalManager = (CarSignalManager)eCarXCar.getCarManager("car_signal");
/*     */         } else {
/* 414 */           Log.d("CompensationImp", "ECarXCar createCar failed!");
/*     */         } 
/*     */       }  }
/* 417 */     catch (Exception exception)
/* 418 */     { exception.printStackTrace(); }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerCompensationSettingListener(ICompensation.ICompensationSettingListener paramICompensationSettingListener) {
/* 427 */     Log.d("CompensationImp", "registerCompensationSettingListener");
/* 428 */     this.mCompensationSettingListener = paramICompensationSettingListener;
/* 429 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterCompensationSettingListener(ICompensation.ICompensationSettingListener paramICompensationSettingListener) {
/* 437 */     Log.d("CompensationImp", "unregisterCompensationSettingListener");
/* 438 */     this.mCompensationSettingListener = null;
/* 439 */     return true;
/*     */   }
/*     */   
/*     */   class CompensationCallback extends ICompensationCallback.Stub { final CompensationImp this$0;
/*     */     
/*     */     public void onBoseRoomModeChanged(int param1Int) throws RemoteException {
/* 445 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onBoseRoomModeChanged mode:"); stringBuilder.append(param1Int); Log.d("CompensationImp", stringBuilder.toString());
/* 446 */       if (CompensationImp.this.mCompensationSettingListener != null) {
/* 447 */         byte b = -1;
/* 448 */         switch (param1Int) { default: param1Int = b;
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 459 */             param1Int = 5; break;
/*     */           case 2: param1Int = 2; break;
/*     */           case 1:
/*     */             param1Int = 1; break;
/*     */           case 0:
/* 464 */             param1Int = 4; break; }  if (param1Int != -1) {
/* 465 */           CompensationImp.this.mCompensationSettingListener.onEffectEnhanceModeChanged(param1Int);
/*     */         } else {
/* 467 */           Log.e("CompensationImp", "onBoseRoomModeChanged fw_effectMode is INVALID_STATUS");
/*     */         } 
/*     */       } else {
/* 470 */         Log.e("CompensationImp", "onBoseRoomModeChanged mCompensationSettingListener is null");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void onVehicleSpeedLevelChanged(int param1Int) throws RemoteException {
/* 476 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onVehicleSpeedLevelChanged level:"); stringBuilder.append(param1Int); Log.d("CompensationImp", stringBuilder.toString());
/* 477 */       if (CompensationImp.this.mCompensationSettingListener != null) {
/* 478 */         byte b = -1;
/* 479 */         switch (param1Int) { default: param1Int = b;
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 3:
/* 490 */             param1Int = 101; break;
/*     */           case 2: param1Int = 100; break;
/*     */           case 1:
/*     */             param1Int = 99; break;
/*     */           case 0:
/* 495 */             param1Int = 98; break; }  if (param1Int != -1) {
/* 496 */           CompensationImp.this.mCompensationSettingListener.onLevelOfSpeedVolumeChanged(param1Int);
/*     */         } else {
/* 498 */           Log.e("CompensationImp", "onVehicleSpeedLevelChanged fwLevel is INVALID_STATUS");
/*     */         } 
/*     */       } else {
/* 501 */         Log.e("CompensationImp", "onVehicleSpeedLevelChanged mCompensationSettingListener is null");
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class AudioSettingsCallback
/*     */     extends IAudioSettingsCallback.Stub
/*     */   {
/*     */     final CompensationImp this$0;
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSoundEffectsStatusChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onPDCWarningChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onMixModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onLoudnessChanged(boolean param1Boolean) {
/* 528 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onLoudnessChanged:"); stringBuilder.append(param1Boolean); Log.d("CompensationImp", stringBuilder.toString());
/* 529 */       if (CompensationImp.this.mCompensationSettingListener != null) {
/* 530 */         CompensationImp.this.mCompensationSettingListener.onLoudnessChanged(param1Boolean);
/*     */       } else {
/* 532 */         Log.d("CompensationImp", "mCompensationSettingListener is null");
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onTwoSurroundChanged(boolean param1Boolean) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\CompensationImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */