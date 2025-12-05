/*     */ package com.ecarx.xui.adaptapi.navigation.dr;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.hardware.Sensor;
/*     */ import android.hardware.SensorEvent;
/*     */ import android.hardware.SensorEventListener;
/*     */ import android.hardware.SensorManager;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.os.SystemClock;
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.IECarXCarSensorTmp;
/*     */ import ecarx.car.ISensorTmperListener;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DrAutoByMapImpl
/*     */   implements IDrAutoByMap
/*     */ {
/*  36 */   private static final int[] mKeyTypeSupportedArray = new int[] { 1, 3, 2, 4 };
/*     */   
/*  38 */   private int sensor_delay = 2;
/*  39 */   private SparseArray<List<IDrAutoByMap.OnDrChangedListener>> mListenersArray = new SparseArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private int mRate = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private IDrAPInfo.IMountAngle mMountAngle = new DrAPInfoImpl.MountAngle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   private volatile float mYawRate = Float.MIN_VALUE;
/*  69 */   private volatile float mLonAcc = Float.MIN_VALUE;
/*  70 */   private volatile float mLatAcc = Float.MIN_VALUE;
/*     */   
/*     */   private boolean servicedied = false;
/*  73 */   private SensorEventListener mGyroSensorEventListener = new SensorEventListener() {
/*     */       final DrAutoByMapImpl this$0;
/*     */       
/*     */       public void onSensorChanged(SensorEvent param1SensorEvent) {
/*  77 */         DrAutoByMapImpl.access$002(DrAutoByMapImpl.this, param1SensorEvent);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
/*     */     };
/*     */   
/*  85 */   private SensorEventListener mAcceSensorEventListener = new SensorEventListener()
/*     */     {
/*     */       final DrAutoByMapImpl this$0;
/*     */       
/*     */       public void onSensorChanged(SensorEvent param1SensorEvent) {
/*  90 */         DrAutoByMapImpl.access$102(DrAutoByMapImpl.this, param1SensorEvent);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
/*     */     };
/*     */ 
/*     */   
/*  99 */   private CarSignalManager.CarSignalEventCallback mCarSignalEventCallback = new CarSignalManager.CarSignalEventCallback() {
/*     */       final DrAutoByMapImpl this$0;
/*     */       
/* 102 */       public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) { Log.d("DrAutoByMapImpl", "onChangeEvent");
/* 103 */         int i = param1ECarXCarPropertyValue.getPropertyId(); if (i != 31492) { if (i != 31549) { if (i != 31578) { if (i != 31602) { if (i != 31605) { if (i != 31608) { if (i == 31610)
/*     */                     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                       
/* 128 */                       DrAutoByMapImpl.access$902(DrAutoByMapImpl.this, DrAutoByMapImpl.this.getSpeedFromValue(param1ECarXCarPropertyValue)); }  } else { DrAutoByMapImpl.access$802(DrAutoByMapImpl.this, DrAutoByMapImpl.this.getSpeedFromValue(param1ECarXCarPropertyValue)); }  } else { DrAutoByMapImpl.access$702(DrAutoByMapImpl.this, DrAutoByMapImpl.this.getSpeedFromValue(param1ECarXCarPropertyValue)); }
/*     */                  }
/*     */               else { DrAutoByMapImpl.access$602(DrAutoByMapImpl.this, DrAutoByMapImpl.this.getSpeedFromValue(param1ECarXCarPropertyValue)); }
/*     */                }
/*     */             else { DrAutoByMapImpl.access$202(DrAutoByMapImpl.this, DrAutoByMapImpl.this.getSpeedFromValue(param1ECarXCarPropertyValue)); }
/*     */              }
/*     */           else { DrAutoByMapImpl.access$502(DrAutoByMapImpl.this, (float)(((Integer)param1ECarXCarPropertyValue.getValue()).intValue() * 9.765625E-4D)); }
/*     */            }
/*     */         else { i = ((Integer)param1ECarXCarPropertyValue.getValue()).intValue(); if (i == 2) { DrAutoByMapImpl.access$402(DrAutoByMapImpl.this, 0); }
/*     */           else { DrAutoByMapImpl.access$402(DrAutoByMapImpl.this, 1); }
/*     */            }
/* 139 */          } public void onErrorEvent(int param1Int1, int param1Int2) {} }; private ISensorTmperListener mSensorTmperListener = (ISensorTmperListener)new ISensorTmperListener.Stub() { final DrAutoByMapImpl this$0;
/*     */       
/*     */       public void onSensorTmperChanged(float param1Float) {
/* 142 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("temp:"); stringBuilder.append(param1Float); Log.i("DrAutoByMapImpl", stringBuilder.toString());
/* 143 */         DrAutoByMapImpl.access$1002(DrAutoByMapImpl.this, param1Float);
/*     */       } }
/*     */   ; private static final String TAG = "DrAutoByMapImpl"; private IDrAPInfo.IAcc3d mAcc3d; private volatile SensorEvent mAcceSensorEvent; private Sensor mAccelSensor; private ECarXCar mCar; private CarSignalManager mCarSignalManager; private Context mContext; private int mCycle; private volatile int mGearState; private IDrAPInfo.IGyro mGyro; private Sensor mGyroSensor; private volatile SensorEvent mGyroSensorEvent; private long mPreCallbackTime; private IDrAPInfo.IPulse mPules;
/*     */   
/*     */   public DrAutoByMapImpl(Context paramContext) {
/*     */     try {
/* 149 */       this.mContext = paramContext;
/* 150 */       this.mSensorManager = (SensorManager)this.mContext.getSystemService("sensor");
/*     */       
/* 152 */       this.mGyroSensor = this.mSensorManager.getDefaultSensor(4);
/* 153 */       if (this.mGyroSensor == null) {
/* 154 */         this.mGyroSensor = this.mSensorManager.getDefaultSensor(16);
/*     */       }
/* 156 */       this.mAccelSensor = this.mSensorManager.getDefaultSensor(1);
/* 157 */     } catch (Exception exception) {
/* 158 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   private int mSensorDt; private SensorManager mSensorManager; private IECarXCarSensorTmp mSensorTmpService;
/*     */   private IECarXCar mService;
/*     */   private SignalFilter mSignalFilter;
/*     */   private volatile float mSteerAngle;
/*     */   private volatile float mTemper;
/*     */   private volatile float mVFL;
/*     */   private volatile float mVFR;
/*     */   private volatile float mVRL;
/*     */   private volatile float mVRR;
/*     */   private volatile float mVehicleSpeed;
/*     */   private IDrAPInfo.IW4m mW4m;
/*     */   private ScheduledExecutorService scheduledService;
/*     */   
/*     */   public FunctionStatus isKeyTypeSupported(int paramInt) {
/*     */     FunctionStatus functionStatus;
/* 176 */     if (Arrays.binarySearch(mKeyTypeSupportedArray, paramInt) > 0) { functionStatus = FunctionStatus.active; } else { functionStatus = FunctionStatus.notavailable; }  return functionStatus;
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
/*     */   public int[] getSupportedKeyTypes() {
/* 190 */     return mKeyTypeSupportedArray;
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
/*     */   public IDrAPInfo getDrLatestInfo(int paramInt) {
/* 208 */     return new DrAPInfoImpl(this.mGyro, this.mPules, this.mAcc3d, this.mMountAngle, this.mW4m);
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
/*     */   public boolean registerListener(IDrAutoByMap.OnDrChangedListener paramOnDrChangedListener, int paramInt) {
/* 229 */     return registerListener(paramOnDrChangedListener, paramInt, 3);
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
/*     */   public boolean registerListener(IDrAutoByMap.OnDrChangedListener paramOnDrChangedListener, int paramInt1, int paramInt2) {
/* 252 */     boolean bool = true;
/* 253 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("mRate:"); stringBuilder.append(this.mRate); stringBuilder.append(", rate: "); stringBuilder.append(paramInt2); stringBuilder.append(", keyType:"); stringBuilder.append(paramInt1); Log.d("DrAutoByMapImpl", stringBuilder.toString());
/* 254 */     if (this.mRate == paramInt2 || this.mRate == -1)
/* 255 */     { this.mRate = paramInt2;
/* 256 */       switch (paramInt2)
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
/* 281 */           bool = false; break;case 4: this.mCycle = 200; this.sensor_delay = 3;case 5: this.mCycle = 500; this.sensor_delay = 3; break;case 3: this.mCycle = 100; this.sensor_delay = 2; break;case 2: this.mCycle = 60; this.sensor_delay = 2; break;
/*     */         case 1: this.mCycle = 30; this.sensor_delay = 0; break;
/* 283 */         case 0: this.mCycle = 10; this.sensor_delay = 0; break; }  if (bool) {
/* 284 */         StringBuilder stringBuilder1; stringBuilder = new StringBuilder(); stringBuilder.append("sensor_delay = "); stringBuilder.append(this.sensor_delay); Log.d("DrAutoByMapImpl", stringBuilder.toString());
/* 285 */         envSetup();
/* 286 */         List<IDrAutoByMap.OnDrChangedListener> list = (List)this.mListenersArray.get(paramInt1);
/* 287 */         if (list == null) {
/* 288 */           list = new ArrayList();
/* 289 */           list.add(paramOnDrChangedListener);
/* 290 */           this.mListenersArray.put(paramInt1, list);
/* 291 */           stringBuilder1 = new StringBuilder(); stringBuilder1.append("listener arraySize = "); stringBuilder1.append(this.mListenersArray.size()); Log.d("DrAutoByMapImpl", stringBuilder1.toString());
/*     */         }
/* 293 */         else if (!list.contains(stringBuilder1)) {
/* 294 */           list.add(stringBuilder1);
/*     */         } else {
/* 296 */           bool = false;
/* 297 */           Log.i("DrAutoByMapImpl", "Duplicate register onDrChangedListener");
/*     */         } 
/*     */       } else {
/*     */         
/* 301 */         Log.e("DrAutoByMapImpl", "Rate is Notavailable");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 307 */       return bool; }  Log.e("DrAutoByMapImpl", "Rate is not allowed to set different values twice or more"); bool = false; return bool;
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
/*     */   public boolean registerListener(IDrAutoByMap.OnDrChangedListener paramOnDrChangedListener, int[] paramArrayOfint, int paramInt) {
/* 330 */     boolean bool = false; byte b; int i;
/* 331 */     for (i = paramArrayOfint.length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/* 332 */       bool = registerListener(paramOnDrChangedListener, j, paramInt);
/*     */       b++; }
/*     */     
/* 335 */     return bool;
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
/*     */   public void unregisterListener(IDrAutoByMap.OnDrChangedListener paramOnDrChangedListener) {
/* 349 */     Log.d("DrAutoByMapImpl", "unregisterListener");
/* 350 */     boolean bool = true;
/* 351 */     for (byte b = 0; b < this.mListenersArray.size(); b++, bool = bool1) {
/* 352 */       List list = (List)this.mListenersArray.valueAt(b);
/* 353 */       boolean bool1 = bool; if (list != null) {
/* 354 */         if (list.contains(paramOnDrChangedListener)) {
/* 355 */           list.remove(paramOnDrChangedListener);
/*     */         }
/*     */         
/* 358 */         bool1 = bool; if (list.size() != 0) {
/* 359 */           bool1 = false;
/*     */         }
/*     */       } 
/*     */     } 
/* 363 */     if (bool) {
/* 364 */       releaseRes();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void initCarService(IECarXCar paramIECarXCar) {
/* 370 */     this.mService = paramIECarXCar;
/* 371 */     initCarService();
/* 372 */     if (this.servicedied) {
/* 373 */       registercar();
/* 374 */       this.servicedied = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 379 */     unregistercar();
/* 380 */     this.servicedied = true;
/*     */   }
/*     */   
/*     */   private void envSetup() {
/* 384 */     if (this.scheduledService == null || this.scheduledService.isShutdown()) {
/* 385 */       this.scheduledService = Executors.newScheduledThreadPool(10);
/* 386 */       this.scheduledService.scheduleAtFixedRate(new CallbackThread(), this.mCycle, this.mCycle, TimeUnit.MILLISECONDS);
/* 387 */       boolean bool1 = this.mSensorManager.registerListener(this.mGyroSensorEventListener, this.mGyroSensor, this.sensor_delay);
/* 388 */       boolean bool2 = this.mSensorManager.registerListener(this.mAcceSensorEventListener, this.mAccelSensor, this.sensor_delay);
/* 389 */       registercar();
/* 390 */       this.mPreCallbackTime = SystemClock.elapsedRealtime();
/* 391 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerListener Gyro: "); stringBuilder.append(bool1); stringBuilder.append(" Acce: "); stringBuilder.append(bool2); Log.i("DrAutoByMapImpl", stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void releaseRes() {
/* 397 */     if (this.scheduledService != null) {
/* 398 */       this.scheduledService.shutdown();
/* 399 */       this.mSensorManager.unregisterListener(this.mGyroSensorEventListener);
/* 400 */       this.mSensorManager.unregisterListener(this.mAcceSensorEventListener);
/* 401 */       unregistercar();
/* 402 */       this.mRate = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void registercar() {
/*     */     try {
/* 408 */       this.mCarSignalManager.registerCallback(this.mCarSignalEventCallback, this.mSignalFilter);
/* 409 */       this.mSensorTmpService.registerListener(this.mSensorTmperListener);
/* 410 */     } catch (Exception exception) {
/* 411 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void unregistercar() {
/*     */     try {
/* 417 */       this.mCarSignalManager.unregisterCallback(this.mCarSignalEventCallback);
/* 418 */       this.mSensorTmpService.unregisterListener(this.mSensorTmperListener);
/* 419 */     } catch (Exception exception) {
/* 420 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   private void initCarService() {
/*     */     try {
/* 425 */       this.mCar = ECarXCar.createCar(this.mContext, this.mService);
/* 426 */       if (this.mCar != null) {
/* 427 */         this.mCarSignalManager = (CarSignalManager)this.mCar.getCarManager("car_signal", this.mService);
/*     */         
/* 429 */         initSignalFilter();
/*     */         try {
/* 431 */           IECarXCar iECarXCar = this.mService;
/* 432 */           IBinder iBinder = iECarXCar.getCarService("car_sensor_tmp"); this.mSensorTmpService = IECarXCarSensorTmp.Stub.asInterface(iBinder);
/* 433 */         } catch (RemoteException remoteException) {
/* 434 */           remoteException.printStackTrace();
/*     */         } 
/*     */       } else {
/* 437 */         Log.i("DrAutoByMapImpl", "DrAutoByMapImpl: createCar failed");
/*     */       } 
/* 439 */     } catch (Exception exception) {
/* 440 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void initSignalFilter() {
/* 446 */     this.mSignalFilter = new SignalFilter();
/* 447 */     this.mSignalFilter.add(Integer.valueOf(31578));
/* 448 */     this.mSignalFilter.add(Integer.valueOf(31492));
/* 449 */     this.mSignalFilter.add(Integer.valueOf(31602));
/* 450 */     this.mSignalFilter.add(Integer.valueOf(31605));
/* 451 */     this.mSignalFilter.add(Integer.valueOf(31608));
/* 452 */     this.mSignalFilter.add(Integer.valueOf(31610));
/* 453 */     this.mSignalFilter.add(Integer.valueOf(31549));
/*     */   }
/*     */   
/*     */   private float getSpeedFromValue(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/*     */     float f;
/* 458 */     if (this.mGearState == 0) {
/*     */       
/* 460 */       f = (float)(0.0D - ((Integer)paramECarXCarPropertyValue.getValue()).intValue() * 0.00391D * 3.6D);
/*     */     } else {
/* 462 */       f = (float)(((Integer)paramECarXCarPropertyValue.getValue()).intValue() * 0.00391D * 3.6D);
/*     */     } 
/* 464 */     return f;
/*     */   }
/*     */   
/*     */   private void callbackListeners(int paramInt, IDrAPInfo paramIDrAPInfo) {
/* 468 */     List list = (List)this.mListenersArray.get(paramInt);
/* 469 */     for (IDrAutoByMap.OnDrChangedListener onDrChangedListener : list) {
/*     */       try {
/* 471 */         StringBuilder stringBuilder2 = new StringBuilder(); this(); stringBuilder2.append("start onSensorChanged key "); stringBuilder2.append(paramInt); Log.d("DrAutoByMapImpl", stringBuilder2.toString());
/* 472 */         stringBuilder2 = new StringBuilder(); this(); stringBuilder2.append("drInfo Gyro Z_Yaw: "); stringBuilder2.append(paramIDrAPInfo.getGyro().getValueYaw()); stringBuilder2.append(" Y_Roll: "); stringBuilder2.append(paramIDrAPInfo.getGyro().getValueRoll()); stringBuilder2.append(" X_Pitch: ");
/* 473 */         stringBuilder2.append(paramIDrAPInfo.getGyro().getValuePitch()); stringBuilder2.append(" tickTime: "); stringBuilder2.append(paramIDrAPInfo.getGyro().getTickTime()); String str = stringBuilder2.toString(); Log.d("DrAutoByMapImpl", str);
/* 474 */         onDrChangedListener.onSensorChanged(paramInt, paramIDrAPInfo);
/* 475 */         StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("end onSensorChanged key "); stringBuilder1.append(paramInt); Log.d("DrAutoByMapImpl", stringBuilder1.toString());
/* 476 */       } catch (Exception exception) {
/* 477 */         exception.printStackTrace();
/*     */       } 
/*     */       try {
/* 480 */         onDrChangedListener.onSensorChanged(paramIDrAPInfo);
/* 481 */       } catch (Exception exception) {
/* 482 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private class CallbackThread implements Runnable { final DrAutoByMapImpl this$0;
/*     */     
/*     */     private CallbackThread() {}
/*     */     
/*     */     public void run() {
/* 491 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("start CallbackThread tid="); stringBuilder.append(Thread.currentThread().getId()); Log.d("DrAutoByMapImpl", stringBuilder.toString());
/* 492 */       long l = SystemClock.elapsedRealtime();
/* 493 */       DrAutoByMapImpl.access$1202(DrAutoByMapImpl.this, (int)(l - DrAutoByMapImpl.this.mPreCallbackTime));
/* 494 */       DrAutoByMapImpl.access$1302(DrAutoByMapImpl.this, l);
/* 495 */       if (DrAutoByMapImpl.this.mListenersArray.get(1) != null) {
/* 496 */         if (DrAutoByMapImpl.this.mGyroSensorEvent != null) {
/* 497 */           DrAutoByMapImpl.access$1502(DrAutoByMapImpl.this, new DrAPInfoImpl.Gyro(DrAutoByMapImpl.this.mGyroSensorEvent, DrAutoByMapImpl.this.mSensorDt, l, DrAutoByMapImpl.this.mTemper));
/* 498 */           DrAPInfoImpl drAPInfoImpl = new DrAPInfoImpl(DrAutoByMapImpl.this.mGyro, DrAutoByMapImpl.this.mPules, DrAutoByMapImpl.this.mAcc3d, DrAutoByMapImpl.this.mMountAngle, DrAutoByMapImpl.this.mW4m);
/* 499 */           DrAutoByMapImpl.this.callbackListeners(1, drAPInfoImpl);
/*     */         } else {
/* 501 */           Log.i("DrAutoByMapImpl", "sendToTarget: gyro sensor not available,wait a moment");
/*     */         } 
/*     */       }
/*     */       
/* 505 */       if (DrAutoByMapImpl.this.mListenersArray.get(2) != null) {
/* 506 */         if (DrAutoByMapImpl.this.mAcceSensorEvent != null) {
/* 507 */           DrAutoByMapImpl.access$1702(DrAutoByMapImpl.this, new DrAPInfoImpl.Acc3d(DrAutoByMapImpl.this.mAcceSensorEvent, DrAutoByMapImpl.this.mSensorDt, l));
/* 508 */           DrAPInfoImpl drAPInfoImpl = new DrAPInfoImpl(DrAutoByMapImpl.this.mGyro, DrAutoByMapImpl.this.mPules, DrAutoByMapImpl.this.mAcc3d, DrAutoByMapImpl.this.mMountAngle, DrAutoByMapImpl.this.mW4m);
/* 509 */           DrAutoByMapImpl.this.callbackListeners(2, drAPInfoImpl);
/*     */         } else {
/* 511 */           Log.i("DrAutoByMapImpl", "sendToTarget: accel sensor not available,wait a moment");
/*     */         } 
/*     */       }
/*     */       
/* 515 */       if (DrAutoByMapImpl.this.mListenersArray.get(5) != null) {
/* 516 */         DrAutoByMapImpl.access$1902(DrAutoByMapImpl.this, new DrAPInfoImpl.W4m(DrAutoByMapImpl.this.mVRL, DrAutoByMapImpl.this.mVRR, DrAutoByMapImpl.this.mVFL, DrAutoByMapImpl.this.mVFR, DrAutoByMapImpl.this.mSteerAngle, DrAutoByMapImpl.this.mYawRate, DrAutoByMapImpl.this.mLonAcc, DrAutoByMapImpl.this.mLatAcc, DrAutoByMapImpl.this.mGearState, DrAutoByMapImpl.this.mSensorDt, l));
/* 517 */         DrAPInfoImpl drAPInfoImpl = new DrAPInfoImpl(DrAutoByMapImpl.this.mGyro, DrAutoByMapImpl.this.mPules, DrAutoByMapImpl.this.mAcc3d, DrAutoByMapImpl.this.mMountAngle, DrAutoByMapImpl.this.mW4m);
/* 518 */         DrAutoByMapImpl.this.callbackListeners(5, drAPInfoImpl);
/*     */       } 
/*     */       
/* 521 */       if (DrAutoByMapImpl.this.mListenersArray.get(3) != null) {
/* 522 */         DrAutoByMapImpl.access$1602(DrAutoByMapImpl.this, new DrAPInfoImpl.Pulse(DrAutoByMapImpl.this.mSensorDt, l, DrAutoByMapImpl.this.mVehicleSpeed));
/* 523 */         DrAPInfoImpl drAPInfoImpl = new DrAPInfoImpl(DrAutoByMapImpl.this.mGyro, DrAutoByMapImpl.this.mPules, DrAutoByMapImpl.this.mAcc3d, DrAutoByMapImpl.this.mMountAngle, DrAutoByMapImpl.this.mW4m);
/* 524 */         DrAutoByMapImpl.this.callbackListeners(3, drAPInfoImpl);
/*     */       } 
/* 526 */       stringBuilder = new StringBuilder(); stringBuilder.append("end CallbackThread tid="); stringBuilder.append(Thread.currentThread().getId()); Log.d("DrAutoByMapImpl", stringBuilder.toString());
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\DrAutoByMapImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */