/*     */ package com.ecarx.xui.adaptapi.car.sensor;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.hardware.Sensor;
/*     */ import android.hardware.SensorEvent;
/*     */ import android.hardware.SensorEventListener;
/*     */ import android.hardware.SensorManager;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.IPowerStatusListener;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.os.SystemClock;
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import android.util.SparseBooleanArray;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.IECarXCarSensorTmp;
/*     */ import ecarx.car.ISensorTmperListener;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.power.BrightnessManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbsSensorFunction
/*     */   extends AbsCarSignal
/*     */   implements ISensor
/*     */ {
/*  58 */   private final ConcurrentHashMap<Integer, SensorFunction<Integer>> mEventSensor = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  61 */   private final ConcurrentHashMap<Integer, SensorFunction<Float>> mContinuousSensor = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  64 */   private final ConcurrentHashMap<Integer, SensorFunction<ISensorGroupValue>> mSensorGroup = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  67 */   private final SparseArray<List<SensorFunction<?>>> mPropertyToSensorStsOrVal = new SparseArray();
/*     */ 
/*     */ 
/*     */   
/*  71 */   private final ConcurrentHashMap<Integer, SensorFunction.Data<Float>> mSaveContinuousSenVal = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  74 */   private final ConcurrentHashMap<Integer, SensorFunction.Data<Integer>> mSaveEventSenVal = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  77 */   private final ConcurrentHashMap<Integer, SensorFunction.Data<ISensorGroupValue>> mSaveGroupSenVal = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  80 */   private final SparseArray<List<Integer>> mRateOfSensorArray = new SparseArray();
/*     */   
/*  82 */   private final SparseBooleanArray mCallbackThreadofRateStatus = new SparseBooleanArray();
/*     */   
/*  84 */   private final ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(10);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class CallbackScheduled
/*     */     implements Runnable
/*     */   {
/*     */     private final int mRate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final AbsSensorFunction this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CallbackScheduled(int param1Int) {
/* 111 */       this.mRate = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/* 117 */         List list = (List)AbsSensorFunction.this.mRateOfSensorArray.get(this.mRate);
/* 118 */         for (Integer integer : list) {
/*     */ 
/*     */           
/* 121 */           SensorFunction<Float> sensorFunction = (SensorFunction)AbsSensorFunction.this.mContinuousSensor.get(integer); if (sensorFunction != null) {
/* 122 */             ConcurrentHashMap concurrentHashMap = AbsSensorFunction.this.mSaveContinuousSenVal;
/* 123 */             int i = sensorFunction.getSensorId(); SensorFunction.Data<Float> data = (SensorFunction.Data)concurrentHashMap.get(Integer.valueOf(i));
/* 124 */             if (data != null) {
/* 125 */               if (data.getStatus() != FunctionStatus.notavailable)
/*     */               {
/* 127 */                 for (ISensor.ISensorListener iSensorListener : sensorFunction.getSensorListeners()) {
/*     */                   try {
/* 129 */                     i = integer.intValue();
/* 130 */                     float f = ((Float)data.getValue()).floatValue(); iSensorListener.onSensorValueChanged(i, f);
/* 131 */                   } catch (Exception exception) {
/* 132 */                     StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("run: 0x"); stringBuilder.append(Integer.toHexString(integer.intValue())); Log.e("AbsSensorFunction", stringBuilder.toString());
/* 133 */                     exception.printStackTrace();
/*     */                   } 
/*     */                 }  }  continue;
/*     */             } 
/* 137 */             if (sensorFunction.getFunctionStatus() != FunctionStatus.notavailable)
/*     */             {
/*     */               
/* 140 */               for (ISensor.ISensorListener iSensorListener : sensorFunction.getSensorListeners()) {
/*     */                 try {
/* 142 */                   i = integer.intValue();
/* 143 */                   float f = ((Float)sensorFunction.getFunctionVal()).floatValue(); iSensorListener.onSensorValueChanged(i, f);
/* 144 */                 } catch (Exception exception) {
/* 145 */                   StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("run: 0x"); stringBuilder.append(Integer.toHexString(integer.intValue())); Log.e("AbsSensorFunction", stringBuilder.toString());
/* 146 */                   exception.printStackTrace();
/*     */                 } 
/*     */               }  } 
/*     */             continue;
/*     */           } 
/* 151 */           sensorFunction = (SensorFunction<Float>)AbsSensorFunction.this.mSensorGroup.get(integer); if (sensorFunction != null) {
/* 152 */             for (ISensor.ISensorListener iSensorListener : sensorFunction.getSensorListeners()) {
/*     */               try {
/* 154 */                 iSensorListener = iSensorListener;
/* 155 */                 int j = integer.intValue(); AbsSensorFunction absSensorFunction = AbsSensorFunction.this; int i = integer.intValue();
/* 156 */                 long l = SystemClock.elapsedRealtime(); ISensorGroupValue iSensorGroupValue = absSensorFunction.getGroupSensorValue(i, l); iSensorListener.onSensorGroupChanged(j, iSensorGroupValue);
/* 157 */               } catch (Exception exception) {
/* 158 */                 StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("run: 0x"); stringBuilder.append(Integer.toHexString(integer.intValue())); Log.e("AbsSensorFunction", stringBuilder.toString());
/* 159 */                 exception.printStackTrace();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/* 164 */       } catch (Exception exception) {
/* 165 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/* 170 */   private final ISensorTmperListener mSensorTmperListener = (ISensorTmperListener)new ISensorTmperListener.Stub() {
/*     */       final AbsSensorFunction this$0;
/*     */       
/*     */       public void onSensorTmperChanged(float param1Float) {
/* 174 */         AbsSensorFunction.this.mTemper = param1Float;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class AutoDayModeReceiver
/*     */     extends IPowerStatusListener.Stub
/*     */   {
/*     */     final AbsSensorFunction this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private AutoDayModeReceiver() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onStatusChanged(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onDayNightChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onBrightnessModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onDayBrightnessChanged(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onNightBrightnessChanged(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onVehicleBrightnessChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSettingManagerReady(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onDayNightModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onManualDayNightModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onAutoDayNightModeChanged(int param1Int) {
/*     */       try {
/* 245 */         ConcurrentHashMap concurrentHashMap = AbsSensorFunction.this.mEventSensor; SensorFunction sensorFunction = (SensorFunction)concurrentHashMap.get(Integer.valueOf(2101248));
/* 246 */         List<ISensor.ISensorListener> list = sensorFunction.getSensorListeners();
/* 247 */         int i = AbsSensorFunction.this.convertDayNightModeToEvent(param1Int);
/* 248 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("onAutoDayNightModeChanged   SENSOR_TYPE_DAY_NIGHT, FunctionStatus.active , mode: "); stringBuilder.append(param1Int); stringBuilder.append(", event: "); stringBuilder.append(i); Log.d("AbsSensorFunction", stringBuilder.toString());
/*     */ 
/*     */         
/* 251 */         if (list != null) {
/* 252 */           for (ISensor.ISensorListener iSensorListener : list) {
/* 253 */             iSensorListener.onSensorSupportChanged(2101248, FunctionStatus.active);
/*     */             
/* 255 */             iSensorListener.onSensorEventChanged(2101248, i);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 260 */           Log.d("AbsSensorFunction", "onAutoDayNightModeChanged   listener is null.");
/*     */         } 
/* 262 */       } catch (Exception exception) {
/* 263 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onCustomDayTimeChanged(float param1Float) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onCustomNightTimeChanged(float param1Float) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onScreenSaverStyleChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onScreenSaverNameChanged(String param1String) {}
/*     */   }
/*     */ 
/*     */   
/* 288 */   private final SensorEventListener mGyroSensorEventListener = new SensorEventListener()
/*     */     {
/*     */       final AbsSensorFunction this$0;
/*     */       
/*     */       public void onSensorChanged(SensorEvent param1SensorEvent) {
/* 293 */         AbsSensorFunction.this.mGyroSensorEvent = param1SensorEvent;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
/*     */     };
/*     */ 
/*     */   
/* 302 */   private final SensorEventListener mAcceSensorEventListener = new SensorEventListener()
/*     */     {
/*     */       final AbsSensorFunction this$0;
/*     */ 
/*     */       
/*     */       public void onSensorChanged(SensorEvent param1SensorEvent) {
/* 308 */         AbsSensorFunction.this.mAcceSensorEvent = param1SensorEvent;
/*     */       }
/*     */       public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
/*     */     }; private static final int DAY_MODE = 1; private static final int DRREFRESH_PERIOD = 100; protected static final int LEFT_FRONT_TIRE = 0; protected static final int LEFT_REAR_TIRE = 1; private static final int LONGEST_PERIOD = 1000; private static final int LONG_PERIOD = 500; private static final int NIGHT_MODE = 0; private static final int NORMAL_PERIOD = 200; private static final int PA = 32768; private static final int REGISTER_TASK = 1; protected static final int RIGHT_FRONT_TIRE = 2; protected static final int RIGHT_REAR_TIRE = 3; private static final int SHORTEST_PERIOD = 5; private static final int SHORT_PERIOD = 10; private static final int SIGNAL = 28672; private static final String TAG = "AbsSensorFunction"; private static final int UIREFRESH_PERIOD = 60; protected long mAccePreCallbackTime; private Sensor mAcceSensor; protected volatile SensorEvent mAcceSensorEvent; protected BrightnessManager mBrightnessManager; protected long mGyroPreCallbackTime; private Sensor mGyroSensor; protected volatile SensorEvent mGyroSensorEvent; private long mHandleTime;
/*     */   private final CarPAEventCallback mPAEventCallback;
/*     */   protected long mPulsePreCallbackTime;
/*     */   private final Handler mRegisterHandler;
/*     */   private final SensorManager mSensorManager;
/*     */   private IECarXCarSensorTmp mSensorTmpService;
/*     */   protected volatile float mTemper;
/*     */   protected long mW4mUpdateTime;
/*     */   
/*     */   protected ISensorFunction<Integer> IntSenFunction(int paramInt) {
/* 321 */     return new SensorFunction<>(this, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ISensorFunction<Float> FloatSenFunction(int paramInt) {
/* 326 */     return new SensorFunction<>(this, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ISensorFunction<ISensorGroupValue> GroupSenFunction(int paramInt) {
/* 331 */     return new SensorFunction<>(this, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addEventSensor(ISensorFunction<Integer> paramISensorFunction) {
/* 336 */     this.mEventSensor.put(Integer.valueOf(((SensorFunction)paramISensorFunction).getSensorId()), (SensorFunction<Integer>)paramISensorFunction);
/*     */ 
/*     */     
/* 339 */     storePropertyToSensor((SensorFunction)paramISensorFunction);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addConSensor(ISensorFunction<Float> paramISensorFunction) {
/* 345 */     this.mContinuousSensor.put(Integer.valueOf(((SensorFunction)paramISensorFunction).getSensorId()), (SensorFunction<Float>)paramISensorFunction);
/*     */     
/* 347 */     storePropertyToSensor((SensorFunction)paramISensorFunction);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addGroupSensor(ISensorFunction<ISensorGroupValue> paramISensorFunction) {
/* 352 */     this.mSensorGroup.put(Integer.valueOf(((SensorFunction)paramISensorFunction).getSensorId()), (SensorFunction<ISensorGroupValue>)paramISensorFunction);
/*     */     
/* 354 */     storePropertyToSensor((SensorFunction)paramISensorFunction);
/*     */   }
/*     */   
/*     */   protected AbsSensorFunction(Context paramContext)
/*     */   {
/* 359 */     super(paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 691 */     this.mPAEventCallback = new CarPAEventCallback() { final AbsSensorFunction this$0;
/*     */         
/*     */         public void onPAChanged(ECarXCarPropertyValue param1ECarXCarPropertyValue) { String str;
/* 694 */           Object object = convertPAData(param1ECarXCarPropertyValue);
/* 695 */           if (object == null) {
/* 696 */             object = new StringBuilder(); object.append("onPAChanged the propertyId 0x");
/* 697 */             object.append(Integer.toHexString(param1ECarXCarPropertyValue.getPropertyId())); object.append(" convertPAData is null "); str = object.toString();
/*     */             Log.i("AbsSensorFunction", str);
/*     */             return;
/*     */           } 
/* 701 */           Log.i("AbsSensorFunction", object.toString());
/*     */           
/* 703 */           AbsSensorFunction.this.recordPADate(str.getPropertyId(), object);
/* 704 */           AbsSensorFunction.this.callbackListener(str.getPropertyId()); } }; this.mRateOfSensorArray.put(5, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(4, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(3, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(2, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(1, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(0, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(16, new CopyOnWriteArrayList()); HandlerThread handlerThread = new HandlerThread("AbsCarFunction register thread"); handlerThread.setDaemon(true); handlerThread.start(); -$$Lambda$AbsSensorFunction$TJrbLZOuD-m0c26tueNeknraS60 -$$Lambda$AbsSensorFunction$TJrbLZOuD-m0c26tueNeknraS60 = new -$$Lambda$AbsSensorFunction$TJrbLZOuD-m0c26tueNeknraS60(this); this.mRegisterHandler = new Handler(handlerThread.getLooper(), -$$Lambda$AbsSensorFunction$TJrbLZOuD-m0c26tueNeknraS60); this.mSensorManager = (SensorManager)paramContext.getSystemService("sensor"); this.mBrightnessManager = BrightnessManager.getInstance(paramContext); this.mBrightnessManager.registerCallBack((IPowerStatusListener)new AutoDayModeReceiver()); Log.d("AbsSensorFunction", "AbsSensorFunction: 构造结束"); }
/*     */   protected final void onInitCarSignalManager() { onCarSignalConnected(this.mECarXCarSetManager); try { IBinder iBinder2 = ServiceManager.getService("ecarxcar_service"); IECarXCar iECarXCar = IECarXCar.Stub.asInterface(iBinder2); IBinder iBinder1 = iECarXCar.getCarService("car_sensor_tmp"); this.mSensorTmpService = IECarXCarSensorTmp.Stub.asInterface(iBinder1); this.mSensorTmpService.registerListener(this.mSensorTmperListener); } catch (Exception exception) { exception.printStackTrace(); }  Log.d("AbsSensorFunction", "onInitCarSignalManager: 准备build"); buildSensorFunction(); }
/*     */   public FunctionStatus isSensorSupported(int paramInt) { FunctionStatus functionStatus = FunctionStatus.notavailable; SensorFunction<?> sensorFunction = this.mEventSensor.get(Integer.valueOf(paramInt)); if (sensorFunction != null) { judgeIsReg(sensorFunction, paramInt); SensorFunction.Data data = this.mSaveEventSenVal.get(Integer.valueOf(paramInt)); if (data != null) { FunctionStatus functionStatus1 = data.getStatus(); } else { registerSigOrPA(sensorFunction, paramInt); FunctionStatus functionStatus1 = sensorFunction.getFunctionStatus(); }  } else { sensorFunction = this.mContinuousSensor.get(Integer.valueOf(paramInt)); if (sensorFunction != null) { judgeIsReg(sensorFunction, paramInt); SensorFunction.Data data = this.mSaveContinuousSenVal.get(Integer.valueOf(paramInt)); if (data != null) { FunctionStatus functionStatus1 = data.getStatus(); } else { registerSigOrPA(sensorFunction, paramInt); FunctionStatus functionStatus1 = sensorFunction.getFunctionStatus(); }  } else { sensorFunction = this.mSensorGroup.get(Integer.valueOf(paramInt)); if (sensorFunction != null) { judgeIsReg(sensorFunction, paramInt); SensorFunction.Data data = this.mSaveGroupSenVal.get(Integer.valueOf(paramInt)); if (data != null) { FunctionStatus functionStatus1 = data.getStatus(); } else { registerSigOrPA(sensorFunction, paramInt); functionStatus = sensorFunction.getFunctionStatus(); }  }  }  }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isSensorSupported: sensor: 0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" , Status: "); stringBuilder.append(functionStatus.name()); String str = stringBuilder.toString(); Log.d("AbsSensorFunction", str); return functionStatus; }
/*     */   public ISensorGroup.IMountAngle getMountAngle() { return new SensorGroup.MountAngle(); }
/*     */   public ISensorGroupValue getSensorGroupLatestValue(int paramInt) { ISensorGroupValue iSensorGroupValue = getGroupSensorValue(paramInt, SystemClock.elapsedRealtime()); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSensorGroupLatestValue: sensor: 0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" , value: "); stringBuilder.append(iSensorGroupValue.toString()); stringBuilder.append(", in: "); stringBuilder.append(iSensorGroupValue.getInterval()); String str = stringBuilder.toString(); Log.d("AbsSensorFunction", str); return iSensorGroupValue; }
/*     */   public int getSensorEvent(int paramInt) { try { SensorFunction<?> sensorFunction = this.mEventSensor.get(Integer.valueOf(paramInt)); if (sensorFunction != null) { int i; judgeIsReg(sensorFunction, paramInt); SensorFunction.Data<Integer> data = this.mSaveEventSenVal.get(Integer.valueOf(paramInt)); if (data != null) { i = ((Integer)data.getValue()).intValue(); } else { registerSigOrPA(sensorFunction, paramInt); if (sensorFunction.getFunctionVal() != null) { i = ((Integer)sensorFunction.getFunctionVal()).intValue(); } else { i = Integer.MIN_VALUE; }  }  StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("getSensorEvent: sensor: 0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" , value: "); stringBuilder.append(i); Log.d("AbsSensorFunction", stringBuilder.toString()); return i; }  } catch (Exception exception) { exception.printStackTrace(); }
/* 710 */      return Integer.MIN_VALUE; } private void callbackListener(int paramInt) { List list = (List)this.mPropertyToSensorStsOrVal.get(paramInt); if (list != null)
/* 711 */       for (SensorFunction<?> sensorFunction : (Iterable<SensorFunction<?>>)list)
/* 712 */       { SensorFunction.Data<Integer> data = sensorFunction.getData();
/* 713 */         if (data.isStatusChange()) {
/* 714 */           for (ISensor.ISensorListener iSensorListener : sensorFunction.getSensorListeners()) {
/*     */             try {
/* 716 */               paramInt = sensorFunction.getSensorId();
/* 717 */               FunctionStatus functionStatus = data.getStatus(); iSensorListener.onSensorSupportChanged(paramInt, functionStatus);
/* 718 */             } catch (Exception exception) {
/* 719 */               StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("callbackListener: 0x");
/* 720 */               paramInt = sensorFunction.getSensorId(); stringBuilder1.append(Integer.toHexString(paramInt)); Log.e("AbsSensorFunction", stringBuilder1.toString());
/* 721 */               exception.printStackTrace();
/*     */             } 
/*     */           } 
/* 724 */           StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onSensorSupportChanged: sensor: 0x");
/* 725 */           paramInt = sensorFunction.getSensorId(); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" , status: ");
/* 726 */           stringBuilder.append(data.getStatus().name()); String str = stringBuilder.toString();
/*     */           Log.d("AbsSensorFunction", str);
/*     */         } 
/* 729 */         if (data.getStatus() != FunctionStatus.notavailable && data.isValueChange()) {
/* 730 */           if (data.getType() == 2) {
/* 731 */             for (ISensor.ISensorListener iSensorListener : sensorFunction.getSensorListeners()) {
/*     */               try {
/* 733 */                 paramInt = sensorFunction.getSensorId();
/* 734 */                 int i = ((Integer)data.getValue()).intValue(); iSensorListener.onSensorEventChanged(paramInt, i);
/* 735 */               } catch (Exception exception) {
/* 736 */                 StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("callbackListener: 0x");
/* 737 */                 paramInt = sensorFunction.getSensorId(); stringBuilder1.append(Integer.toHexString(paramInt)); Log.e("AbsSensorFunction", stringBuilder1.toString());
/* 738 */                 exception.printStackTrace();
/*     */               } 
/*     */             } 
/* 741 */             StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onSensorEventChanged: sensor: 0x");
/* 742 */             paramInt = sensorFunction.getSensorId(); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" , val: ");
/* 743 */             stringBuilder.append(data.getValue()); String str = stringBuilder.toString(); Log.d("AbsSensorFunction", str);
/*     */           } 
/*     */         } else {
/* 746 */           StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("cannot notify value, because 0x");
/* 747 */           paramInt = sensorFunction.getSensorId(); stringBuilder.append(Integer.toHexString(paramInt));
/*     */           stringBuilder.append("is notavailable or not change");
/*     */           Log.d("AbsSensorFunction", stringBuilder.toString());
/*     */         } 
/* 751 */         judgeContinueCallback(sensorFunction, data);
/*     */         
/* 753 */         if ((data.isStatusChange() || data.isValueChange()) && 
/* 754 */           sensorFunction.isRegistered())
/* 755 */         { switch (data.getType())
/*     */           { default:
/*     */               continue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 3:
/* 768 */               this.mSaveGroupSenVal.put(Integer.valueOf(sensorFunction.getSensorId()), data); continue;
/*     */             case 2: this.mSaveEventSenVal.put(Integer.valueOf(sensorFunction.getSensorId()), data); continue;
/*     */             case 1: break; }  this.mSaveContinuousSenVal.put(Integer.valueOf(sensorFunction.getSensorId()), data); }  }   }
/*     */   public float getSensorLatestValue(int paramInt) { SensorFunction<?> sensorFunction = this.mContinuousSensor.get(Integer.valueOf(paramInt)); if (sensorFunction != null) { float f; judgeIsReg(sensorFunction, paramInt); SensorFunction.Data<Float> data = this.mSaveContinuousSenVal.get(Integer.valueOf(paramInt)); if (data != null) { f = ((Float)data.getValue()).floatValue(); } else { f = ((Float)sensorFunction.getFunctionVal()).floatValue(); }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSensorLatestValue: sensor: 0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" , value: "); stringBuilder.append(f); String str = stringBuilder.toString(); Log.d("AbsSensorFunction", str); return f; }  return Float.MAX_VALUE; }
/*     */   private void judgeIsReg(SensorFunction<?> paramSensorFunction, int paramInt) { if (!paramSensorFunction.isRegistered())
/*     */       registerSigOrPA(paramSensorFunction, paramInt);  }
/*     */   public boolean registerListener(ISensor.ISensorListener paramISensorListener, int paramInt) { return registerListener(paramISensorListener, paramInt, 3); }
/*     */   public boolean registerListener(ISensor.ISensorListener paramISensorListener, int paramInt1, int paramInt2) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield mEventSensor : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   4: iload_2
/*     */     //   5: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   8: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   11: checkcast com/ecarx/xui/adaptapi/car/sensor/SensorFunction
/*     */     //   14: astore #5
/*     */     //   16: aload #5
/*     */     //   18: ifnull -> 82
/*     */     //   21: aload #5
/*     */     //   23: invokevirtual getSensorListeners : ()Ljava/util/List;
/*     */     //   26: astore #6
/*     */     //   28: aload #6
/*     */     //   30: invokeinterface size : ()I
/*     */     //   35: ifeq -> 63
/*     */     //   38: aload #6
/*     */     //   40: aload_1
/*     */     //   41: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   46: ifne -> 52
/*     */     //   49: goto -> 63
/*     */     //   52: ldc 'AbsSensorFunction'
/*     */     //   54: ldc_w 'sensor has been listened'
/*     */     //   57: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   60: pop
/*     */     //   61: iconst_0
/*     */     //   62: ireturn
/*     */     //   63: aload #6
/*     */     //   65: aload_1
/*     */     //   66: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   71: pop
/*     */     //   72: aload_0
/*     */     //   73: aload #5
/*     */     //   75: iload_2
/*     */     //   76: invokespecial registerSigOrPA : (Lcom/ecarx/xui/adaptapi/car/sensor/SensorFunction;I)V
/*     */     //   79: goto -> 408
/*     */     //   82: aload_0
/*     */     //   83: getfield mContinuousSensor : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   86: iload_2
/*     */     //   87: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   90: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   93: checkcast com/ecarx/xui/adaptapi/car/sensor/SensorFunction
/*     */     //   96: astore #6
/*     */     //   98: aload #6
/*     */     //   100: astore #5
/*     */     //   102: aload #6
/*     */     //   104: ifnonnull -> 136
/*     */     //   107: aload_0
/*     */     //   108: getfield mSensorGroup : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   111: astore #5
/*     */     //   113: aload #5
/*     */     //   115: iload_2
/*     */     //   116: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   119: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   122: checkcast com/ecarx/xui/adaptapi/car/sensor/SensorFunction
/*     */     //   125: astore #6
/*     */     //   127: aload #6
/*     */     //   129: astore #5
/*     */     //   131: aload #6
/*     */     //   133: ifnull -> 408
/*     */     //   136: iload_2
/*     */     //   137: ldc_w 8388864
/*     */     //   140: if_icmpne -> 154
/*     */     //   143: aload_0
/*     */     //   144: getfield mGyroSensor : Landroid/hardware/Sensor;
/*     */     //   147: ifnonnull -> 154
/*     */     //   150: aload_0
/*     */     //   151: invokespecial registerGyroListener : ()V
/*     */     //   154: iload_2
/*     */     //   155: ldc_w 8389120
/*     */     //   158: if_icmpne -> 172
/*     */     //   161: aload_0
/*     */     //   162: getfield mAcceSensor : Landroid/hardware/Sensor;
/*     */     //   165: ifnonnull -> 172
/*     */     //   168: aload_0
/*     */     //   169: invokespecial registerAcceListener : ()V
/*     */     //   172: aload #5
/*     */     //   174: invokevirtual getType : ()I
/*     */     //   177: iconst_1
/*     */     //   178: if_icmpeq -> 191
/*     */     //   181: iload_3
/*     */     //   182: istore #4
/*     */     //   184: iload_2
/*     */     //   185: ldc_w 8389376
/*     */     //   188: if_icmpne -> 201
/*     */     //   191: iload_3
/*     */     //   192: istore #4
/*     */     //   194: iload_3
/*     */     //   195: ifne -> 201
/*     */     //   198: iconst_1
/*     */     //   199: istore #4
/*     */     //   201: aload #5
/*     */     //   203: invokevirtual getRate : ()I
/*     */     //   206: iconst_m1
/*     */     //   207: if_icmpeq -> 234
/*     */     //   210: aload #5
/*     */     //   212: invokevirtual getRate : ()I
/*     */     //   215: iload #4
/*     */     //   217: if_icmpne -> 223
/*     */     //   220: goto -> 234
/*     */     //   223: ldc 'AbsSensorFunction'
/*     */     //   225: ldc_w 'The same sensor must have same rate.'
/*     */     //   228: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   231: pop
/*     */     //   232: iconst_0
/*     */     //   233: ireturn
/*     */     //   234: aload_0
/*     */     //   235: getfield mRateOfSensorArray : Landroid/util/SparseArray;
/*     */     //   238: iload #4
/*     */     //   240: invokevirtual indexOfKey : (I)I
/*     */     //   243: ifge -> 257
/*     */     //   246: ldc 'AbsSensorFunction'
/*     */     //   248: ldc_w 'param "rate" is not available'
/*     */     //   251: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   254: pop
/*     */     //   255: iconst_0
/*     */     //   256: ireturn
/*     */     //   257: aload #5
/*     */     //   259: invokevirtual getRate : ()I
/*     */     //   262: iconst_m1
/*     */     //   263: if_icmpne -> 273
/*     */     //   266: aload #5
/*     */     //   268: iload #4
/*     */     //   270: invokevirtual setRate : (I)V
/*     */     //   273: aload #5
/*     */     //   275: invokevirtual getSensorListeners : ()Ljava/util/List;
/*     */     //   278: aload_1
/*     */     //   279: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   284: pop
/*     */     //   285: aload_0
/*     */     //   286: getfield mRateOfSensorArray : Landroid/util/SparseArray;
/*     */     //   289: iload #4
/*     */     //   291: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   294: checkcast java/util/List
/*     */     //   297: iload_2
/*     */     //   298: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   301: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   306: pop
/*     */     //   307: aload_0
/*     */     //   308: aload #5
/*     */     //   310: iload_2
/*     */     //   311: invokespecial registerSigOrPA : (Lcom/ecarx/xui/adaptapi/car/sensor/SensorFunction;I)V
/*     */     //   314: iload_2
/*     */     //   315: ldc_w 8389632
/*     */     //   318: if_icmpne -> 332
/*     */     //   321: aload_0
/*     */     //   322: aload_0
/*     */     //   323: iload #4
/*     */     //   325: invokespecial getCallbackPeriod : (I)I
/*     */     //   328: i2l
/*     */     //   329: putfield mW4mUpdateTime : J
/*     */     //   332: aload_0
/*     */     //   333: getfield mRateOfSensorArray : Landroid/util/SparseArray;
/*     */     //   336: iload #4
/*     */     //   338: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   341: checkcast java/util/List
/*     */     //   344: invokeinterface size : ()I
/*     */     //   349: iconst_1
/*     */     //   350: if_icmpne -> 408
/*     */     //   353: aload_0
/*     */     //   354: getfield mCallbackThreadofRateStatus : Landroid/util/SparseBooleanArray;
/*     */     //   357: iload #4
/*     */     //   359: invokevirtual get : (I)Z
/*     */     //   362: ifne -> 408
/*     */     //   365: aload_0
/*     */     //   366: getfield mCallbackThreadofRateStatus : Landroid/util/SparseBooleanArray;
/*     */     //   369: iload #4
/*     */     //   371: iconst_1
/*     */     //   372: invokevirtual put : (IZ)V
/*     */     //   375: aload_0
/*     */     //   376: iload #4
/*     */     //   378: invokespecial getCallbackPeriod : (I)I
/*     */     //   381: istore_2
/*     */     //   382: aload_0
/*     */     //   383: getfield scheduledService : Ljava/util/concurrent/ScheduledExecutorService;
/*     */     //   386: new com/ecarx/xui/adaptapi/car/sensor/AbsSensorFunction$CallbackScheduled
/*     */     //   389: dup
/*     */     //   390: aload_0
/*     */     //   391: iload #4
/*     */     //   393: invokespecial <init> : (Lcom/ecarx/xui/adaptapi/car/sensor/AbsSensorFunction;I)V
/*     */     //   396: lconst_0
/*     */     //   397: iload_2
/*     */     //   398: i2l
/*     */     //   399: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
/*     */     //   402: invokeinterface scheduleAtFixedRate : (Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
/*     */     //   407: pop
/*     */     //   408: iconst_1
/*     */     //   409: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #568	-> 0
/*     */     //   #569	-> 0
/*     */     //   #570	-> 0
/*     */     //   #573	-> 21
/*     */     //   #574	-> 28
/*     */     //   #578	-> 52
/*     */     //   #579	-> 61
/*     */     //   #576	-> 63
/*     */     //   #582	-> 72
/*     */     //   #584	-> 79
/*     */     //   #585	-> 113
/*     */     //   #587	-> 136
/*     */     //   #588	-> 150
/*     */     //   #590	-> 154
/*     */     //   #591	-> 168
/*     */     //   #594	-> 172
/*     */     //   #597	-> 198
/*     */     //   #600	-> 201
/*     */     //   #612	-> 223
/*     */     //   #613	-> 232
/*     */     //   #602	-> 234
/*     */     //   #603	-> 246
/*     */     //   #604	-> 255
/*     */     //   #606	-> 257
/*     */     //   #607	-> 266
/*     */     //   #609	-> 273
/*     */     //   #610	-> 285
/*     */     //   #621	-> 307
/*     */     //   #623	-> 314
/*     */     //   #624	-> 321
/*     */     //   #627	-> 332
/*     */     //   #631	-> 365
/*     */     //   #632	-> 375
/*     */     //   #633	-> 382
/*     */     //   #638	-> 408 }
/*     */   public void unregisterListener(ISensor.ISensorListener paramISensorListener) { boolean bool1, bool2 = false; Iterator<SensorFunction> iterator = this.mEventSensor.values().iterator(); while (true) { bool1 = bool2; if (iterator.hasNext()) { SensorFunction sensorFunction = iterator.next(); List<ISensor.ISensorListener> list = sensorFunction.getSensorListeners(); if (list.contains(paramISensorListener)) { bool1 = true; list.remove(paramISensorListener); break; }  continue; }  break; }  bool2 = bool1; if (!bool1) { Iterator<SensorFunction> iterator1 = this.mContinuousSensor.values().iterator(); while (true) { bool2 = bool1; if (iterator1.hasNext()) { SensorFunction sensorFunction = iterator1.next(); List<ISensor.ISensorListener> list = sensorFunction.getSensorListeners(); if (list.contains(paramISensorListener)) { bool2 = true; list.remove(paramISensorListener); ((List)this.mRateOfSensorArray.get(sensorFunction.getRate())).remove(paramISensorListener); break; }  continue; }  break; }  }  if (!bool2)
/*     */       for (SensorFunction<ISensorGroupValue> sensorFunction : this.mSensorGroup.values()) { List<ISensor.ISensorListener> list = sensorFunction.getSensorListeners(); if (list.contains(paramISensorListener)) { list.remove(paramISensorListener); ((List)this.mRateOfSensorArray.get(sensorFunction.getRate())).remove(paramISensorListener); if (sensorFunction.getSensorId() == 8388864) { this.mSensorManager.unregisterListener(this.mGyroSensorEventListener, this.mGyroSensor); try { this.mSensorTmpService.unregisterListener(this.mSensorTmperListener); } catch (RemoteException remoteException) { remoteException.printStackTrace(); }  continue; }  if (remoteException.getSensorId() == 8389120)
/*     */             this.mSensorManager.unregisterListener(this.mAcceSensorEventListener, this.mAcceSensor);  }  }   }
/* 779 */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) { recordSignalDate(paramECarXCarPropertyValue); callbackListener(paramECarXCarPropertyValue.getPropertyId()); } private void judgeContinueCallback(SensorFunction<?> paramSensorFunction, SensorFunction.Data<?> paramData) { if (paramSensorFunction.getSensorId() == 5259264 && (
/* 780 */       (Integer)paramData.getValue()).intValue() == 5259266 && 
/* 781 */       paramData.getStatus() != FunctionStatus.notavailable) {
/* 782 */       if (!paramData.isValueChange()) {
/* 783 */         for (ISensor.ISensorListener iSensorListener : paramSensorFunction.getSensorListeners()) {
/*     */           try {
/* 785 */             iSensorListener.onSensorEventChanged(5259264, 5259266);
/*     */           }
/* 787 */           catch (Exception exception) {
/* 788 */             exception.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 793 */       ArrayList<Integer> arrayList = new ArrayList();
/*     */       try {
/* 795 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeFrntTireMsgSysWarnFlg()));
/* 796 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeReTireMsgSysWarnFlg()));
/* 797 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiFrntTireMsgSysWarnFlg()));
/* 798 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiReTireMsgSysWarnFlg()));
/* 799 */       } catch (Exception exception) {
/* 800 */         exception.printStackTrace();
/*     */       } 
/* 802 */       for (byte b = 0; b < arrayList.size(); b++) {
/* 803 */         if (((Integer)arrayList.get(b)).intValue() == 1) {
/* 804 */           for (ISensor.ISensorListener iSensorListener : paramSensorFunction.getSensorListeners()) {
/*     */             
/*     */             try {
/* 807 */               int i = getNumberTPMS(b); iSensorListener.onSensorEventChanged(5259264, i);
/* 808 */             } catch (Exception exception) {
/* 809 */               exception.printStackTrace();
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }  }
/*     */ 
/*     */   
/*     */   private void registerGyroListener() {
/* 818 */     this.mGyroSensor = this.mSensorManager.getDefaultSensor(4);
/* 819 */     if (this.mGyroSensor == null) {
/* 820 */       this.mGyroSensor = this.mSensorManager.getDefaultSensor(16);
/*     */     }
/*     */     
/* 823 */     if (this.mGyroSensor != null) {
/* 824 */       this.mSensorManager.registerListener(this.mGyroSensorEventListener, this.mGyroSensor, 0);
/*     */       
/* 826 */       this.mGyroPreCallbackTime = SystemClock.elapsedRealtime();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void registerAcceListener() {
/* 831 */     this.mAcceSensor = this.mSensorManager.getDefaultSensor(1);
/* 832 */     if (this.mAcceSensor != null) {
/* 833 */       this.mSensorManager.registerListener(this.mAcceSensorEventListener, this.mAcceSensor, 0);
/*     */       
/* 835 */       this.mAccePreCallbackTime = SystemClock.elapsedRealtime();
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getCallbackPeriod(int paramInt) {
/* 840 */     char c = 'È';
/* 841 */     if (paramInt != 16) { switch (paramInt) { default: paramInt = c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 864 */           return paramInt;case 5: paramInt = 1000; return paramInt;case 4: paramInt = 500; return paramInt;case 3: paramInt = 200; return paramInt;case 2: paramInt = 60; return paramInt;case 1: paramInt = 10; return paramInt;case 0: break; }  paramInt = 5; } else { paramInt = 100; }  return paramInt;
/*     */   }
/*     */   
/*     */   private void registerSigOrPA(SensorFunction<?> paramSensorFunction, int paramInt) {
/* 868 */     paramSensorFunction.setRegistered(true);
/* 869 */     long l = SystemClock.elapsedRealtime();
/* 870 */     for (Iterator<Integer> iterator = paramSensorFunction.getAssociatedStatusOrVal().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 871 */       if (!addPAOrSignal(i)) {
/* 872 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("StatusOrVal: "); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" not found the propertyId 0x");
/*     */         
/* 874 */         stringBuilder.append(Integer.toHexString(i)); stringBuilder.append(" is PA or Signal"); String str = stringBuilder.toString();
/*     */         Log.i("AbsSensorFunction", str);
/*     */       }  }
/*     */     
/* 878 */     l -= this.mHandleTime;
/* 879 */     if (l < 500L) {
/* 880 */       this.mRegisterHandler.removeMessages(1);
/* 881 */       this.mRegisterHandler.sendEmptyMessageDelayed(1, l);
/*     */     } else {
/* 883 */       this.mRegisterHandler.sendEmptyMessage(1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean addPAOrSignal(int paramInt) {
/* 889 */     boolean bool = false;
/* 890 */     int i = 0xFFFF & paramInt;
/* 891 */     if (i >= 32768) {
/* 892 */       addPAFilter(Integer.valueOf(paramInt));
/* 893 */       bool = true;
/* 894 */     } else if (i >= 28672) {
/* 895 */       addSignalFilter(Integer.valueOf(paramInt));
/* 896 */       bool = true;
/*     */     } 
/* 898 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int convertDayNightModeToEvent(int paramInt) {
/* 903 */     switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 911 */         paramInt = 2101249;
/*     */ 
/*     */         
/* 914 */         return paramInt;case 1: paramInt = 2101249; return paramInt;case 0: break; }  paramInt = 2101250; return paramInt;
/*     */   }
/*     */   
/*     */   private void storePropertyToSensor(SensorFunction<?> paramSensorFunction) {
/* 918 */     for (Iterator<Integer> iterator = paramSensorFunction.getAssociatedStatusOrVal().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 919 */       List<SensorFunction<?>> list = (List)this.mPropertyToSensorStsOrVal.get(i, new ArrayList());
/*     */       
/* 921 */       if (list.isEmpty()) {
/* 922 */         this.mPropertyToSensorStsOrVal.put(i, list);
/*     */       }
/* 924 */       list.add(paramSensorFunction); }
/*     */   
/*     */   }
/*     */   
/*     */   private int getNumberTPMS(int paramInt) {
/* 929 */     int i = 5259265;
/* 930 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 944 */         return paramInt;case 3: paramInt = 5259270; return paramInt;case 2: paramInt = 5259268; return paramInt;case 1: paramInt = 5259269; return paramInt;case 0: break; }  paramInt = 5259267; return paramInt;
/*     */   }
/*     */   
/*     */   protected ISensorGroupValue getGroupSensorValue(int paramInt, long paramLong) {
/* 948 */     ISensorGroupValue iSensorGroupValue = null;
/* 949 */     if (paramInt == 8388864) {
/* 950 */       if (this.mGyroSensorEvent != null) {
/* 951 */         iSensorGroupValue = new SensorGroupValue.GyroValue(this.mGyroSensorEvent, (int)(paramLong - this.mGyroPreCallbackTime), paramLong, this.mTemper);
/*     */         
/* 953 */         this.mGyroPreCallbackTime = paramLong;
/*     */       } 
/* 955 */     } else if (paramInt == 8389120) {
/* 956 */       if (this.mAcceSensorEvent != null) {
/* 957 */         SensorGroupValue.Acc3dValue acc3dValue = new SensorGroupValue.Acc3dValue(this.mAcceSensorEvent, (int)(paramLong - this.mAccePreCallbackTime), paramLong);
/*     */         
/* 959 */         this.mAccePreCallbackTime = paramLong;
/*     */       } 
/* 961 */     } else if (paramInt == 8389376) {
/* 962 */       SensorFunction.Data<ISensorGroupValue.ISpeedPulseValue> data = (SensorFunction.Data)this.mSaveGroupSenVal.get(Integer.valueOf(paramInt));
/* 963 */       if (data != null) {
/*     */         
/* 965 */         ISensorGroupValue.ISpeedPulseValue iSpeedPulseValue = data.getValue();
/* 966 */         int i = (int)(paramLong - this.mPulsePreCallbackTime);
/*     */         
/* 968 */         iSpeedPulseValue = new SensorGroupValue.SpeedPulseValue(i, paramLong, iSpeedPulseValue.getSpeedValue());
/* 969 */         this.mPulsePreCallbackTime = paramLong;
/* 970 */         ((SensorFunction.Data<ISensorGroupValue.ISpeedPulseValue>)this.mSaveGroupSenVal.get(Integer.valueOf(paramInt))).setValue(iSpeedPulseValue);
/*     */       } else {
/* 972 */         registerSigOrPA(this.mSensorGroup.get(Integer.valueOf(paramInt)), paramInt);
/* 973 */         ISensorGroupValue iSensorGroupValue1 = ((SensorFunction<ISensorGroupValue>)this.mSensorGroup.get(Integer.valueOf(paramInt))).getFunctionVal();
/*     */       } 
/* 975 */     } else if (paramInt == 8389632) {
/* 976 */       ConcurrentHashMap<Integer, SensorFunction.Data<ISensorGroupValue>> concurrentHashMap = this.mSaveGroupSenVal;
/* 977 */       SensorFunction.Data<SensorGroupValue.W4mValue> data = (SensorFunction.Data)concurrentHashMap.get(Integer.valueOf(paramInt));
/* 978 */       if (data != null) {
/* 979 */         SensorGroupValue.W4mValue w4mValue = data.getValue();
/* 980 */         float f3 = w4mValue.getVRLSpeed(), f8 = w4mValue.getVRRSpeed();
/* 981 */         float f2 = w4mValue.getVFLSpeed(), f4 = w4mValue.getVFRSpeed(), f6 = w4mValue.getSteerAngle();
/* 982 */         float f7 = w4mValue.getYawRate(), f1 = w4mValue.getLonAcc(), f5 = w4mValue.getLatAcc();
/* 983 */         w4mValue = new SensorGroupValue.W4mValue(f3, f8, f2, f4, f6, f7, f1, f5, w4mValue.getGearState(), (int)(paramLong - this.mW4mUpdateTime), paramLong);
/*     */         
/* 985 */         this.mW4mUpdateTime = paramLong;
/* 986 */         ((SensorFunction.Data<SensorGroupValue.W4mValue>)this.mSaveGroupSenVal.get(Integer.valueOf(paramInt))).setValue(w4mValue);
/*     */       } else {
/* 988 */         registerSigOrPA(this.mSensorGroup.get(Integer.valueOf(paramInt)), paramInt);
/* 989 */         iSensorGroupValue = ((SensorFunction<ISensorGroupValue>)this.mSensorGroup.get(Integer.valueOf(paramInt))).getFunctionVal();
/*     */       } 
/*     */     } 
/* 992 */     return iSensorGroupValue;
/*     */   }
/*     */   
/*     */   protected abstract void buildSensorFunction();
/*     */   
/*     */   protected abstract void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager);
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\AbsSensorFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */