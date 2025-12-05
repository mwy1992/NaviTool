/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.media.AudioManager;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ import com.ecarx.car.audio.manager.IAudioAdapterAPICallback;
/*     */ import com.ecarx.car.audio.manager.IAudioSettingsCallback;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfcipwakeupManager;
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
/*     */ public class Audio
/*     */   extends AbsCarFunction
/*     */   implements IAudio
/*     */ {
/*     */   private ECarXCarVfcipwakeupManager mVfcipwakeupManager;
/*  53 */   private int mLastDIMWarningLevel = -1;
/*     */ 
/*     */   
/*     */   private EcarxAudioManager mEcarxAudioManager;
/*     */   
/*  58 */   private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { final Audio this$0;
/*     */       
/*     */       public void binderDied() {
/*  61 */         Log.e("Audio_API", "binderDied");
/*  62 */         if (Audio.this.mEcarxAudioManager != null)
/*  63 */           Audio.this.mEcarxAudioManager.connect(); 
/*     */       } }
/*     */   ; private IAudioSettingsCallback mAudioSettingsCallback; AudioManager mAudioManager; private IAudioAdapterAPICallback mAudioAdapterAPICallback; private static final int mCAEFunction = 1; private static final int USAGE_MODE_ABANDON = 0; private static final String TAG = "Audio_API"; private static final int HIGH_KX11_NG06 = 132; private static final int HIGH_EX11_NG08 = 133; private static final int DIM_WARNING_OFF = 3; private static final int DIM_WARNING_MID = 0; private static final int DIM_WARNING_LOW = 1;
/*     */   private static final int DIM_WARNING_HIGH = 2;
/*     */   
/*     */   protected Audio(Context paramContext) {
/*  69 */     super(paramContext, 771751936);
/*  70 */     this.mAudioManager = (AudioManager)paramContext.getSystemService("audio");
/*  71 */     ServiceConnection serviceConnection = new ServiceConnection() {
/*     */         final Audio this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  75 */           if (Audio.this.mEcarxAudioManager == null) {
/*  76 */             Log.e("Audio_API", "onServiceConnected mEcarxAudioManager is null");
/*     */           }
/*     */           try {
/*  79 */             param1IBinder.linkToDeath(Audio.this.mDeathRecipient, 0);
/*  80 */           } catch (RemoteException remoteException) {
/*  81 */             remoteException.printStackTrace();
/*     */           } 
/*  83 */           Log.d("Audio_API", "onServiceConnected");
/*     */         }
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/*  88 */           if (Audio.this.mEcarxAudioManager != null) {
/*  89 */             Audio.this.mEcarxAudioManager.connect();
/*  90 */             Log.d("Audio_API", "onServiceDisconnected mEcarxAudioManager.connect()");
/*     */           } 
/*  92 */           Log.d("Audio_API", "onServiceDisconnected"); }
/*     */       };
/*  94 */     Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
/*  95 */     this.mEcarxAudioManager.connect();
/*  96 */     this.mAudioAdapterAPICallback = (IAudioAdapterAPICallback)new AudioAdapterAPICallback();
/*  97 */     this.mEcarxAudioManager.registerAdapterAPICallBack(this.mAudioAdapterAPICallback);
/*  98 */     this.mAudioSettingsCallback = (IAudioSettingsCallback)new AudioSettingsCallback();
/*  99 */     this.mEcarxAudioManager.registerAudioSettingsCallback(this.mAudioSettingsCallback);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/* 105 */     recordSignalDate(paramECarXCarPropertyValue);
/* 106 */     if (paramECarXCarPropertyValue.getPropertyId() == 30940) {
/* 107 */       int i = this.mEcarxAudioManager.getDIMSoundWarningLevel();
/*     */       
/* 109 */       switch (i)
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
/*     */         case 3:
/* 130 */           Log.d("Audio_API", "WARNING_VOLUME_LEVEL_OFF");
/* 131 */           onFunctionChanged(538771712);
/* 132 */           onFunctionValueChanged(538771712, -2147483648, 0); break;
/*     */         case 2:
/*     */           Log.d("Audio_API", "DIM_WARNING_HIGH"); onFunctionChanged(538771712); onFunctionValueChanged(538771712, -2147483648, 538771715); break;
/*     */         case 1:
/*     */           Log.d("Audio_API", "DIM_WARNING_LOW"); onFunctionChanged(538771712); onFunctionValueChanged(538771712, -2147483648, 538771713); break;
/*     */         case 0:
/* 138 */           Log.d("Audio_API", "DIM_WARNING_MID"); onFunctionChanged(538771712); onFunctionValueChanged(538771712, -2147483648, 538771714); break; }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("SignalId_SoundVolLvl: "); stringBuilder.append(i); Log.d("Audio_API", stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void initSignalFilter() {
/* 144 */     addSignalFilter(Integer.valueOf(30940));
/* 145 */     Log.d("Audio_API", "initSignalFilter SignalId_SoundVolLvl");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/* 150 */     this.mVfcipwakeupManager = paramECarXCarSetManager.getECarXCarVfcipwakeupManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/* 156 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(538771712);
/* 157 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 0, 538771713, 538771714, 538771715 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus2 = FunctionStatus.active;
/*     */     
/* 165 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone6.fixStatus(functionStatus2); -$$Lambda$Audio$QAXAOFfcEdRNkIpUegeYXgbnLlY -$$Lambda$Audio$QAXAOFfcEdRNkIpUegeYXgbnLlY = new -$$Lambda$Audio$QAXAOFfcEdRNkIpUegeYXgbnLlY(this);
/*     */ 
/*     */     
/* 168 */     Pairs pairs = Pairs.of(Integer.valueOf(538771713), Integer.valueOf(1));
/* 169 */     pairs = pairs.add(Integer.valueOf(538771714), Integer.valueOf(0));
/* 170 */     pairs = pairs.add(Integer.valueOf(538771715), Integer.valueOf(2));
/* 171 */     pairs = pairs.add(Integer.valueOf(0), Integer.valueOf(3)); IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$Audio$QAXAOFfcEdRNkIpUegeYXgbnLlY, pairs); -$$Lambda$Audio$DTEcNk8JLqV5l1coJpGZYweRDD8 -$$Lambda$Audio$DTEcNk8JLqV5l1coJpGZYweRDD8 = new -$$Lambda$Audio$DTEcNk8JLqV5l1coJpGZYweRDD8(this);
/* 172 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild8.customValue(-$$Lambda$Audio$DTEcNk8JLqV5l1coJpGZYweRDD8); -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM6 = new -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM(this);
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
/* 192 */     iFilterCallback1.addTo(-$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM6);
/*     */ 
/*     */     
/* 195 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(771817728);
/* 196 */     iVehicleFunction5 = iVehicleFunction5.supportedFunctionValue(new int[] { 0, 771817729, 771817730 });
/*     */ 
/*     */     
/* 199 */     IVehicleFunction.IZone iZone4 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus5 = FunctionStatus.active;
/* 200 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone4.fixStatus(functionStatus5); -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM5 = new -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM(this);
/*     */ 
/*     */     
/* 203 */     iValueTaskBuild2.addTo(-$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM5);
/*     */ 
/*     */     
/* 206 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(771817984);
/* 207 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(new int[] { 1, 0 });
/* 208 */     IVehicleFunction.IZone iZone3 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus4 = FunctionStatus.active;
/* 209 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone3.fixStatus(functionStatus4); -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM4 = new -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM(this);
/*     */ 
/*     */     
/* 212 */     iValueTaskBuild7.addTo(-$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM4);
/*     */ 
/*     */ 
/*     */     
/* 216 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(771818240);
/* 217 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(new int[] { 1, 0 });
/* 218 */     IVehicleFunction.IZone iZone2 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$Audio$wTEZ-YmG7y2BeGhaFZSziO9WL-M -$$Lambda$Audio$wTEZ-YmG7y2BeGhaFZSziO9WL-M = new -$$Lambda$Audio$wTEZ-YmG7y2BeGhaFZSziO9WL-M(this);
/* 219 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone2.customStatus(-$$Lambda$Audio$wTEZ-YmG7y2BeGhaFZSziO9WL-M); -$$Lambda$Audio$DkjB_gyTuJo7AHUA0iUUujFZ6gg -$$Lambda$Audio$DkjB_gyTuJo7AHUA0iUUujFZ6gg = new -$$Lambda$Audio$DkjB_gyTuJo7AHUA0iUUujFZ6gg(this);
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
/* 241 */     pairs = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 242 */     pairs = pairs.add(Integer.valueOf(0), Integer.valueOf(0)); iValueTaskBuild6 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$Audio$DkjB_gyTuJo7AHUA0iUUujFZ6gg, pairs); -$$Lambda$Audio$tPAgGSfi8KNf-c0jGQAs4Fy1kYY -$$Lambda$Audio$tPAgGSfi8KNf-c0jGQAs4Fy1kYY = new -$$Lambda$Audio$tPAgGSfi8KNf-c0jGQAs4Fy1kYY(this);
/* 243 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild6.customValue(-$$Lambda$Audio$tPAgGSfi8KNf-c0jGQAs4Fy1kYY); -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM3 = new -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM(this);
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
/* 254 */     iFilterCallback3.addTo(-$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM3);
/*     */ 
/*     */     
/* 257 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(771883264);
/* 258 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(new int[] { 0, 771883265, 771883266, 771883267 });
/*     */ 
/*     */ 
/*     */     
/* 262 */     IVehicleFunction.IZone iZone5 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 263 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone5.fixStatus(functionStatus1); -$$Lambda$Audio$7GvmUv-5vqmxwpBPkIY5SHhPi-o -$$Lambda$Audio$7GvmUv-5vqmxwpBPkIY5SHhPi-o = new -$$Lambda$Audio$7GvmUv-5vqmxwpBPkIY5SHhPi-o(this);
/*     */     
/* 265 */     pairs = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 266 */     pairs = pairs.add(Integer.valueOf(771883265), Integer.valueOf(1));
/* 267 */     pairs = pairs.add(Integer.valueOf(771883266), Integer.valueOf(2));
/* 268 */     pairs = pairs.add(Integer.valueOf(771883267), Integer.valueOf(3)); IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iValueTaskBuild5.onSetFunctionValue(-$$Lambda$Audio$7GvmUv-5vqmxwpBPkIY5SHhPi-o, pairs); -$$Lambda$Audio$kD-RdgyjOAPN4IDa_jWERLhsekY -$$Lambda$Audio$kD-RdgyjOAPN4IDa_jWERLhsekY = new -$$Lambda$Audio$kD-RdgyjOAPN4IDa_jWERLhsekY(this);
/* 269 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild1.customValue(-$$Lambda$Audio$kD-RdgyjOAPN4IDa_jWERLhsekY); -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM2 = new -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM(this);
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
/* 291 */     iFilterCallback2.addTo(-$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM2);
/*     */ 
/*     */     
/* 294 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(771948800);
/* 295 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 1, 0 });
/* 296 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus3 = FunctionStatus.active;
/* 297 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone1.fixStatus(functionStatus3); -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM1 = new -$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM(this);
/*     */ 
/*     */     
/* 300 */     iValueTaskBuild4.addTo(-$$Lambda$Audio$UUwX3ka11cU28_2yMVWa_p3KnBM1);
/*     */   }
/*     */ 
/*     */   
/*     */   private ApiResult setDIMSoundWarningLevel(int paramInt) {
/* 305 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setDIMSoundWarningLevel  value: "); stringBuilder.append(paramInt); Log.d("Audio_API", stringBuilder.toString());
/* 306 */     this.mEcarxAudioManager.setDIMSoundWarningLevel(paramInt);
/*     */     try {
/* 308 */       if (this.mCarSignalManager.getVehModMngtGlbSafe1UsgModSts() != 0 && this.mLastDIMWarningLevel != paramInt) {
/*     */         
/* 310 */         Log.d("Audio_API", "setDIMSoundWarningLevel  激活VFC");
/* 311 */         this.mVfcipwakeupManager.CB_VFCRsrv1(1);
/*     */       } 
/* 313 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 314 */       carNotConnectedException.printStackTrace();
/*     */     } 
/* 316 */     this.mLastDIMWarningLevel = paramInt;
/*     */     
/* 318 */     return ApiResult.SUCCEED;
/*     */   }
/*     */   
/*     */   private ApiResult setCAEOn(int paramInt) {
/* 322 */     this.mEcarxAudioManager.setCAEOn(paramInt);
/* 323 */     return ApiResult.SUCCEED;
/*     */   }
/*     */   
/*     */   private ApiResult setSoundEffectsStatus(int paramInt) {
/* 327 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setSoundEffectsStatus  value:"); stringBuilder.append(paramInt); Log.d("Audio_API", stringBuilder.toString());
/* 328 */     this.mAudioManager.setSoundEffectsStatus(paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 336 */     return ApiResult.SUCCEED;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getSoundEffectsStatus() {
/* 342 */     return this.mAudioManager.getSoundEffectsStatus();
/*     */   }
/*     */ 
/*     */   
/*     */   class AudioAdapterAPICallback
/*     */     extends IAudioAdapterAPICallback.Stub
/*     */   {
/*     */     final Audio this$0;
/*     */     
/*     */     public void onAudioAdapterAPIFunctionChanged(int param1Int1, int param1Int2) {
/* 352 */       if (param1Int1 == 1) {
/*     */         
/* 354 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CAE 回调 value:"); stringBuilder.append(param1Int2); Log.d("Audio_API", stringBuilder.toString());
/* 355 */         Audio.this.triggerCallback(771818240, -2147483648);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   class AudioSettingsCallback
/*     */     extends IAudioSettingsCallback.Stub
/*     */   {
/*     */     final Audio this$0;
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSoundEffectsStatusChanged(int param1Int) {
/* 370 */       int i = 0;
/* 371 */       if (param1Int == 0) {
/* 372 */         i = 0;
/* 373 */       } else if (param1Int == 1) {
/* 374 */         i = 771883265;
/* 375 */       } else if (param1Int == 2) {
/* 376 */         i = 771883266;
/* 377 */       } else if (param1Int == 3) {
/* 378 */         i = 771883267;
/*     */       } 
/* 380 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onSoundEffectsStatusChanged   function:SETTING_FUNC_SOFT_BUTTON_SOUND_TYPE  soundEffectsStatus:"); stringBuilder.append(param1Int); stringBuilder.append(", ret=0x");
/*     */ 
/*     */       
/* 383 */       stringBuilder.append(Integer.toHexString(i)); String str = stringBuilder.toString(); Log.d("Audio_API", str);
/* 384 */       Audio.this.onFunctionChanged(771883264);
/* 385 */       Audio.this.onFunctionValueChanged(771883264, -2147483648, i);
/*     */     }
/*     */     
/*     */     public void onPDCWarningChanged(int param1Int) {}
/*     */     
/*     */     public void onMixModeChanged(int param1Int) {}
/*     */     
/*     */     public void onLoudnessChanged(boolean param1Boolean) {}
/*     */     
/*     */     public void onTwoSurroundChanged(boolean param1Boolean) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Audio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */