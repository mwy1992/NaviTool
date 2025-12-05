/*     */ package com.ecarx.xui.adaptapi.policy;
/*     */ 
/*     */ import android.car.Car;
/*     */ import android.car.media.CarAudioManager;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.media.AudioAttributes;
/*     */ import android.media.AudioFocusInfo;
/*     */ import android.media.AudioManager;
/*     */ import android.media.audiopolicy.AudioPolicy;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.SystemProperties;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import android.view.Display;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AudioAttributesImp
/*     */   implements IAudioAttributes
/*     */ {
/*     */   private static final String BT_MUSIC_PKG_NAME = "com.android.bluetooth";
/*     */   private static final String TAG = "AudioAttributesImp";
/*     */   private AudioManager mAudioManager;
/*     */   private AudioPolicy mAudioPolicy;
/*     */   private Car mCar;
/*     */   private CarAudioManager mCarAudioManager;
/*     */   private Context mContext;
/*     */   private EcarxAudioManager mEcarxAudioManager;
/*  46 */   private final AudioPolicy.AudioPolicyFocusListener mFocusListener = new AudioPolicy.AudioPolicyFocusListener() { final AudioAttributesImp this$0;
/*     */       public void onAudioFocusGrant(AudioFocusInfo param1AudioFocusInfo, int param1Int) {
/*     */         String str;
/*  49 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onAudioFocusGrant: pkg="); stringBuilder.append(param1AudioFocusInfo.getPackageName()); stringBuilder.append(" reqRes="); stringBuilder.append(param1Int); stringBuilder.append(", attr="); stringBuilder.append(param1AudioFocusInfo.getAttributes()); Log.v("AudioAttributesImp", stringBuilder.toString());
/*     */         
/*  51 */         if (param1AudioFocusInfo.getPackageName().contains("com.android.bluetooth")) {
/*  52 */           str = "BT_AUDIO";
/*     */         } else {
/*  54 */           str = AudioAttributes.usageToString(param1AudioFocusInfo.getAttributes().getUsage());
/*     */         } 
/*  56 */         if (AudioAttributesImp.this.mFocusOwnerChangedListener != null) {
/*  57 */           AudioAttributesImp.this.mFocusOwnerChangedListener.onAudioFocusCallbackGain(str, param1AudioFocusInfo.getPackageName());
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public void onAudioFocusLoss(AudioFocusInfo param1AudioFocusInfo, boolean param1Boolean) {
/*     */         String str;
/*  64 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onAudioFocusLoss: pkg="); stringBuilder.append(param1AudioFocusInfo.getPackageName()); stringBuilder.append(" wasNotified="); stringBuilder.append(param1Boolean); stringBuilder.append(", attr="); stringBuilder.append(param1AudioFocusInfo.getAttributes()); Log.v("AudioAttributesImp", stringBuilder.toString());
/*     */         
/*  66 */         if (param1AudioFocusInfo.getPackageName().contains("com.android.bluetooth")) {
/*  67 */           str = "BT_AUDIO";
/*     */         } else {
/*  69 */           str = AudioAttributes.usageToString(param1AudioFocusInfo.getAttributes().getUsage());
/*     */         } 
/*  71 */         if (AudioAttributesImp.this.mFocusOwnerChangedListener != null) {
/*  72 */           AudioAttributesImp.this.mFocusOwnerChangedListener.onAudioFocusCallbackLoss(str, param1AudioFocusInfo.getPackageName());
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onAudioFocusRequest(AudioFocusInfo param1AudioFocusInfo, int param1Int) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void onAudioFocusAbandon(AudioFocusInfo param1AudioFocusInfo) {} }
/*     */   ;
/*     */ 
/*     */   
/*     */   private IAudioAttributes.IAudioFocusCallback mFocusOwnerChangedListener;
/*     */ 
/*     */   
/*     */   private Looper mLooper;
/*     */ 
/*     */   
/*     */   private PolicyImp mPolicyImp;
/*     */ 
/*     */   
/*     */   private final ServiceConnection mServiceConnection;
/*     */ 
/*     */   
/*     */   private WorkHandler mWorkHandler;
/*     */ 
/*     */ 
/*     */   
/*     */   private EcarxAudioManager createEcarxAudioManagerInstance(Context paramContext) {
/* 103 */     ServiceConnection serviceConnection = new ServiceConnection() { final AudioAttributesImp this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/* 106 */           Log.d("AudioAttributesImp", "mEcarxAudioManager.onServiceConnected");
/*     */         }
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/* 111 */           Log.d("AudioAttributesImp", "mEcarxAudioManager.onServiceDisconnected");
/* 112 */           if (AudioAttributesImp.this.mEcarxAudioManager != null) {
/* 113 */             AudioAttributesImp.this.mEcarxAudioManager.connect();
/* 114 */             Log.d("AudioAttributesImp", "mEcarxAudioManager.reconnect when disconnected !!!");
/*     */           }  } }
/*     */       ;
/* 117 */     Handler handler = new Handler(Looper.getMainLooper());
/*     */     return EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
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
/*     */   public int getAudioAtrributesUsage(String paramString) {
/*     */     byte b;
/* 132 */     switch (paramString.hashCode()) { default: b = -1; break;case 1959001893: if (paramString.equals("BICALL")) { b = 6; break; } case 1331256137: if (paramString.equals("VOICE_COMMUNICATION")) { b = 8; break; } case 1132509524: if (paramString.equals("VOICE_COMMUNICATION_SIGNALLING")) { b = 1; break; } case 77732827: if (paramString.equals("RADIO")) { b = 3; break; } case 73234372: if (paramString.equals("MEDIA")) { b = 2; break; } case 65783843: if (paramString.equals("ECALL")) { b = 7; break; } case 83411: if (paramString.equals("TTS")) { b = 11; break; } case 74765: if (paramString.equals("KTV")) { b = 5; break; } case -15028957: if (paramString.equals("NAVIGATION_GUIDANCE")) { b = 10; break; } case -78544194: if (paramString.equals("ASSISTANT")) { b = 0; break; } case -915338871: if (paramString.equals("BT_AUDIO")) { b = 4; break; } case -2129181230: if (paramString.equals("NAVIGATION_HINT")) { b = 9; break; }  }  switch (b)
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
/*     */       
/*     */       default:
/* 156 */         return 0;
/*     */       case 11: return 17;
/*     */       case 10:
/*     */         return 12;
/*     */       case 9:
/*     */         return 23;
/*     */       case 8:
/*     */         return 2;
/*     */       case 7:
/*     */         return 19;
/*     */       case 6:
/*     */         return 20;
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */         return 1;
/*     */       case 1:
/*     */         return 3;
/*     */       case 0:
/* 176 */         break; }  return 18; } public int getAudioAtrributesUsage(String paramString, Display paramDisplay) { int i = paramDisplay.getDisplayId();
/* 177 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getAudioAtrributesUsage   displayId: "); stringBuilder.append(i); stringBuilder.append(" usage: "); stringBuilder.append(paramString); stringBuilder.append("isBluetoothA2dpOn: "); AudioManager audioManager = this.mAudioManager;
/* 178 */     stringBuilder.append(audioManager.isBluetoothA2dpOn()); String str = stringBuilder.toString(); Log.d("AudioAttributesImp", str);
/* 179 */     if (i == 3 && this.mAudioManager.isBluetoothA2dpOn())
/* 180 */     { i = -1; int j = paramString.hashCode(); if (j != -915338871) { if (j != 74765) { if (j == 73234372 && paramString.equals("MEDIA")) i = 0;  } else if (paramString.equals("KTV")) { i = 2; }  } else if (paramString.equals("BT_AUDIO")) { i = 1; }  switch (i)
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 187 */           return getAudioAtrributesUsage(paramString);
/*     */         case 0: case 1:
/*     */         case 2:
/* 190 */           break; }  Log.d("AudioAttributesImp", "USAGE_MUSIC_PSD"); return 31; }  return getAudioAtrributesUsage(paramString); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAudioAtrributesContentType(String paramString) {
/*     */     byte b;
/* 209 */     switch (paramString.hashCode()) { default: b = -1; break;case 864375761: if (paramString.equals("NAVI_GUIDANCE")) { b = 16; break; } case 433141802: if (paramString.equals("UNKNOWN")) { b = 0; break; } case 73725445: if (paramString.equals("MUSIC")) { b = 3; break; } case 73549584: if (paramString.equals("MOVIE")) { b = 4; break; } case 69477927: if (paramString.equals("ICALL")) { b = 11; break; } case 65783843: if (paramString.equals("ECALL")) { b = 13; break; } case 63013280: if (paramString.equals("BCALL")) { b = 10; break; } case 83411: if (paramString.equals("TTS")) { b = 5; break; } case 74765: if (paramString.equals("KTV")) { b = 17; break; } case 65188: if (paramString.equals("AUX")) { b = 6; break; } case 2247: if (paramString.equals("FM")) { b = 8; break; } case 2092: if (paramString.equals("AM")) { b = 7; break; } case -733187200: if (paramString.equals("NAVI_HINT")) { b = 15; break; } case -915338871: if (paramString.equals("BT_AUDIO")) { b = 9; break; } case -1447616031: if (paramString.equals("BLUETOOTH_HFP")) { b = 14; break; } case -1947802945: if (paramString.equals("AUDIO_ASSISTAN")) { b = 1; break; } case -1959168835: if (paramString.equals("ONCALL")) { b = 12; break; } case -2053328940: if (paramString.equals("PHONE_COMING_HINT")) { b = 2; break; }  }  switch (b)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 249 */         return 0;case 17: return 2;case 16: return 11;case 15: return 12;case 14: return 5;case 13: return 8;case 12: return 9;case 11: return 10;case 10: return 9;case 9: return 2;case 8: return 14;case 7: return 13;case 6: return 2;
/*     */       case 5: return 6;
/*     */       case 4: return 3;
/*     */       case 3: return 2;
/*     */       case 2: return 5;
/*     */       case 1: return 7;
/* 255 */       case 0: break; }  return 0; } public int getActiveAudioFocusType() { String str = SystemProperties.get("ro.build.product", "");
/* 256 */     int j = 3;
/* 257 */     int i = j; if (!TextUtils.isEmpty(str))
/* 258 */       if (str.toUpperCase(Locale.US).startsWith("KX11")) {
/* 259 */         i = this.mAudioManager.getActiveStreamType(-2147483648);
/*     */       } else {
/* 261 */         i = j; if (str.toUpperCase(Locale.US).startsWith("EX11")) {
/* 262 */           if (this.mCarAudioManager != null) {
/*     */             
/* 264 */             i = j; try { j = this.mCarAudioManager.getCurrentStreamType();
/* 265 */               i = j; StringBuilder stringBuilder1 = new StringBuilder(); i = j; this(); i = j; stringBuilder1.append("getCurrentStreamType: "); i = j; stringBuilder1.append(j); i = j; Log.d("AudioAttributesImp", stringBuilder1.toString()); i = j; }
/* 266 */             catch (Exception exception)
/* 267 */             { exception.printStackTrace(); }
/*     */           
/*     */           } else {
/* 270 */             Log.d("AudioAttributesImp", "mCarAudioManager null"); i = j;
/*     */           } 
/*     */         }
/*     */       }  
/* 274 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getActiveAudioFocusType: "); stringBuilder.append(i); Log.d("AudioAttributesImp", stringBuilder.toString());
/* 275 */     return i; }
/*     */   
/*     */   public AudioAttributesImp(Context paramContext, PolicyImp paramPolicyImp) {
/* 278 */     this.mServiceConnection = new ServiceConnection()
/*     */       {
/*     */         final AudioAttributesImp this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/* 295 */           if (param1IBinder != null) {
/*     */             try {
/* 297 */               AudioAttributesImp.access$202(AudioAttributesImp.this, (CarAudioManager)AudioAttributesImp.this.mCar.getCarManager("audio"));
/* 298 */               AudioAttributesImp.this.mPolicyImp.connect();
/* 299 */               Log.d("AudioAttributesImp", "mCarAudioManager onServiceConnected");
/* 300 */             } catch (Exception exception) {
/* 301 */               exception.printStackTrace();
/*     */             } 
/*     */           } else {
/* 304 */             Log.e("AudioAttributesImp", "mServiceConnection, err service null");
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/* 320 */           AudioAttributesImp.access$202(AudioAttributesImp.this, null);
/* 321 */           AudioAttributesImp.this.mPolicyImp.disconnect();
/* 322 */           AudioAttributesImp.this.mWorkHandler.sendEmptyMessageDelayed(1, 100L);
/*     */           
/* 324 */           Log.d("AudioAttributesImp", "mServiceConnection --> CarService Disconnected");
/*     */         }
/*     */       };
/*     */     this.mContext = paramContext;
/*     */     this.mAudioManager = (AudioManager)paramContext.getSystemService("audio");
/*     */     if (Looper.myLooper() == null)
/*     */       Looper.prepare(); 
/*     */     this.mPolicyImp = paramPolicyImp;
/*     */     this.mWorkHandler = new WorkHandler();
/*     */     this.mCar = Car.createCar(paramContext, this.mServiceConnection);
/*     */     this.mCar.connect();
/*     */     this.mEcarxAudioManager = createEcarxAudioManagerInstance(paramContext);
/*     */     this.mEcarxAudioManager.connect();
/*     */   }
/*     */   private final class WorkHandler extends Handler { public static final int CAR_SERVICE_RECONNECT = 1; public static final int CAR_SERVICE_RECONNECT_DELAYED = 100;
/*     */     final AudioAttributesImp this$0;
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 342 */       if (param1Message.what == 1) {
/*     */         
/*     */         try {
/* 345 */           AudioAttributesImp.this.mCar.disconnect();
/* 346 */           AudioAttributesImp.this.mCar.connect();
/* 347 */         } catch (Exception exception) {
/* 348 */           StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Car connect err, Exception, e: "); stringBuilder.append(exception); Log.d("AudioAttributesImp", stringBuilder.toString());
/*     */         } 
/*     */       }
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAndroidAutoInputSource(String paramString) {
/* 360 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCarplayInputSource(String paramString) {
/* 366 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int registerAudioFocusCallback(IAudioAttributes.IAudioFocusCallback paramIAudioFocusCallback) {
/* 371 */     Log.d("AudioAttributesImp", "registerAudioFocusCallback() ");
/* 372 */     this.mFocusOwnerChangedListener = paramIAudioFocusCallback;
/* 373 */     int i = registerAudioPolicy();
/*     */     
/* 375 */     if (i != 0) {
/* 376 */       Log.e("AudioAttributesImp", "registerAudioFocusCallback failed !!!");
/*     */     }
/* 378 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int registerAudioPolicy() {
/* 383 */     Log.d("AudioAttributesImp", "registerAudioPolicy() ");
/* 384 */     if (this.mAudioPolicy == null) {
/* 385 */       if (this.mLooper == null) {
/* 386 */         this.mLooper = Looper.getMainLooper();
/*     */       }
/*     */       
/* 389 */       AudioPolicy.Builder builder = new AudioPolicy.Builder(this.mContext);
/* 390 */       builder.setLooper(this.mLooper);
/* 391 */       builder.setAudioPolicyFocusListener(this.mFocusListener);
/* 392 */       builder.setIsAudioFocusPolicy(false);
/*     */       
/* 394 */       AudioPolicy audioPolicy = builder.build();
/*     */       
/* 396 */       if (audioPolicy == null) {
/* 397 */         Log.e("AudioAttributesImp", "build audiopolicy failed !!!");
/* 398 */         return -1;
/*     */       } 
/* 400 */       Log.d("AudioAttributesImp", "build audiopolicy succeed !!!");
/* 401 */       this.mAudioPolicy = audioPolicy;
/*     */     } 
/* 403 */     int i = this.mAudioManager.registerAudioPolicy(this.mAudioPolicy);
/* 404 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerAudioPolicyRet="); stringBuilder.append(i); Log.d("AudioAttributesImp", stringBuilder.toString());
/* 405 */     if (i != 0) {
/* 406 */       Log.e("AudioAttributesImp", "registerAudioPolicy failed !!!");
/*     */     }
/* 408 */     return i;
/*     */   }
/*     */   
/*     */   public void unregisterAudioPolicy() {
/* 412 */     Log.d("AudioAttributesImp", "unregisterAudioPolicy() ");
/* 413 */     if (this.mAudioPolicy != null) {
/* 414 */       this.mAudioManager.unregisterAudioPolicyAsync(this.mAudioPolicy);
/* 415 */       this.mAudioPolicy = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDuckAudioPolicy(int paramInt1, int paramInt2, int paramInt3) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterAudioPolicyAsync(IAudioAttributes.IAudioFocusCallback paramIAudioFocusCallback) {
/* 427 */     Log.d("AudioAttributesImp", "unregisterAudioPolicyAsync() ");
/* 428 */     unregisterAudioPolicy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String usageToString() {
/* 438 */     return "USAGE_UNKNOWN";
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAudioUsageWithPackageName(String paramString) {
/* 443 */     byte b = 0;
/* 444 */     if (paramString == null) {
/* 445 */       Log.e("AudioAttributesImp", "packageName is null");
/* 446 */       return 0;
/*     */     } 
/* 448 */     List list = this.mAudioManager.getCurrentAudioFocusInfo();
/* 449 */     int i = b; if (list.size() > 0) {
/* 450 */       Iterator<AudioFocusInfo> iterator = list.iterator(); while (true) { i = b; if (iterator.hasNext()) { AudioFocusInfo audioFocusInfo = iterator.next();
/* 451 */           if (audioFocusInfo.getPackageName().contains(paramString)) {
/* 452 */             i = audioFocusInfo.getAttributes().getUsage();
/* 453 */             StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("packageName: "); stringBuilder.append(paramString); stringBuilder.append(", usage:"); stringBuilder.append(i); Log.d("AudioAttributesImp", stringBuilder.toString()); break;
/*     */           }  continue; }
/*     */          break; }
/*     */     
/*     */     } 
/* 458 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\AudioAttributesImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */