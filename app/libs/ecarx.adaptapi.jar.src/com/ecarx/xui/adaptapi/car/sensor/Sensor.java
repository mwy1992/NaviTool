/*      */ package com.ecarx.xui.adaptapi.car.sensor;
/*      */ 
/*      */ import android.car.CarNotConnectedException;
/*      */ import android.content.Context;
/*      */ import android.hardware.SensorEvent;
/*      */ import android.hardware.SensorEventListener;
/*      */ import android.hardware.SensorManager;
/*      */ import android.os.IBinder;
/*      */ import android.os.IPowerStatusListener;
/*      */ import android.os.RemoteException;
/*      */ import android.os.ServiceManager;
/*      */ import android.os.SystemClock;
/*      */ import android.util.Log;
/*      */ import android.util.SparseArray;
/*      */ import android.util.SparseBooleanArray;
/*      */ import android.util.SparseIntArray;
/*      */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*      */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*      */ import com.ecarx.xui.adaptapi.SignalUtils;
/*      */ import ecarx.car.IECarXCar;
/*      */ import ecarx.car.IECarXCarSensorTmp;
/*      */ import ecarx.car.ISensorTmperListener;
/*      */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*      */ import ecarx.car.hardware.signal.CarSignalManager;
/*      */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarAirqlyandfragraManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSystemsettingManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVehchargManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*      */ import ecarx.car.hardware.vehicle.PATypes;
/*      */ import ecarx.power.BrightnessManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.CopyOnWriteArrayList;
/*      */ import java.util.concurrent.Executors;
/*      */ import java.util.concurrent.ScheduledExecutorService;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Sensor
/*      */   extends AbsCarSignal
/*      */   implements ISensor
/*      */ {
/*   79 */   private int mSaveByte6 = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   88 */   private final ISensorGroup.IMountAngle mMountAngle = new SensorGroup.MountAngle();
/*   89 */   private final ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(10);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  113 */   private volatile float mYawRate = Float.MIN_VALUE;
/*  114 */   private volatile float mLonAcc = Float.MIN_VALUE;
/*  115 */   private volatile float mLatAcc = Float.MIN_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  123 */   private static final int[] TIRE_NOTIFICATION = new int[] { 5245184, 5245440, 5245696, 5245952, 5246208, 5246464, 5246720, 5246976, 5247232, 5247488, 5247744, 5248000, 5248256, 5248512, 5248768, 5249024, 5259264 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  139 */   private final SensorEventListener mGyroSensorEventListener = new SensorEventListener()
/*      */     {
/*      */       final Sensor this$0;
/*      */       
/*      */       public void onSensorChanged(SensorEvent param1SensorEvent) {
/*  144 */         Sensor.access$002(Sensor.this, param1SensorEvent);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void onAccuracyChanged(android.hardware.Sensor param1Sensor, int param1Int) {}
/*      */     };
/*      */ 
/*      */   
/*  153 */   private final SensorEventListener mAcceSensorEventListener = new SensorEventListener()
/*      */     {
/*      */       final Sensor this$0;
/*      */       
/*      */       public void onSensorChanged(SensorEvent param1SensorEvent) {
/*  158 */         Sensor.access$102(Sensor.this, param1SensorEvent);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void onAccuracyChanged(android.hardware.Sensor param1Sensor, int param1Int) {}
/*      */     };
/*      */ 
/*      */   
/*  167 */   private final ISensorTmperListener mSensorTmperListener = (ISensorTmperListener)new ISensorTmperListener.Stub() {
/*      */       final Sensor this$0;
/*      */       
/*      */       public void onSensorTmperChanged(float param1Float) {
/*  171 */         Sensor.access$202(Sensor.this, param1Float);
/*      */       }
/*      */     };
/*      */   
/*  175 */   private final ConcurrentHashMap<Integer, List<ISensor.ISensorListener>> mSensorListenerMap = new ConcurrentHashMap<>();
/*      */   
/*  177 */   private final SparseBooleanArray mCallbackThreadofRateStatus = new SparseBooleanArray();
/*  178 */   private final SparseArray<List<Integer>> mRateOfSensorArray = new SparseArray();
/*  179 */   private final ConcurrentHashMap<Integer, Float> mContinuousSensorValueMap = new ConcurrentHashMap<>();
/*      */   
/*  181 */   private final ConcurrentHashMap<Integer, Integer> mEventSensorValueMap = new ConcurrentHashMap<>();
/*      */   
/*  183 */   private final SparseIntArray mSignalSensorCorrArray = new SparseIntArray();
/*  184 */   private final ConcurrentHashMap<Integer, int[]> mTireTmpANDPreStatusMap = (ConcurrentHashMap)new ConcurrentHashMap<>();
/*      */   
/*  186 */   private final ConcurrentHashMap<Integer, FunctionStatus> mSensorStatus = new ConcurrentHashMap<>(); private static final int CAR_CONFIG_OK = 3; private static final int DAY_MODE = 1; private static final int DRREFRESH_PERIOD = 100; private static final int LEFT_FRONT_TIRE = 0; private static final int LEFT_REAR_TIRE = 1; private static final int LONGEST_PERIOD = 1000; private static final int LONG_PERIOD = 500; private static final int NIGHT_MODE = 0; private static final int NORMAL_PERIOD = 200; private static final int RIGHT_FRONT_TIRE = 2; private static final int RIGHT_REAR_TIRE = 3; private static final int SENSOR_TYPE_CONTINUOUS = 1; private static final int SENSOR_TYPE_EVENT = 2; private static final int SENSOR_TYPE_GROUP = 3; private static final int SENSOR_TYPE_NOT_SUPPORT = 0; private static final int SHORTEST_PERIOD = 5; private static final int SHORT_PERIOD = 10; private static final String TAG = "Sensor"; private static final int UIREFRESH_PERIOD = 60; private long mAccePreCallbackTime; private android.hardware.Sensor mAcceSensor; private volatile SensorEvent mAcceSensorEvent; private volatile ISensorGroupValue mAcceValue; private ECarXCarAirqlyandfragraManager mAirQandFragMgr; private final CarPAEventCallback mAirQandFragPACallback; private volatile float mAverFuelCon; private BrightnessManager mBrightnessManager; private final Context mContext; private volatile int mCoolAntLvl; private volatile int mEngCoolantSysWarn; private volatile int mGear; private volatile int mGearState; private long mGyroPreCallbackTime; private android.hardware.Sensor mGyroSensor; private volatile SensorEvent mGyroSensorEvent; private volatile ISensorGroupValue mGyroValue; private volatile ISensorGroupValue mPluseValue; private long mPulsePreCallbackTime; private final SensorManager mSensorManager; private IECarXCarSensorTmp mSensorTmpService; private volatile float mSingFuelCon; private volatile float mSteerAngle; private ECarXCarSystemsettingManager mSysSetMgr; private final CarPAEventCallback mSysSetPACallback; private volatile float mTemper; private volatile int mTranSysWarn; private volatile float mVFL; private final CarPAEventCallback mVFMiscPACallback; private volatile float mVFR; private volatile float mVRL; private volatile float mVRR; private final CarPAEventCallback mVehChargPACallback; private ECarXCarVehchargManager mVehchargMgr; private volatile float mVehicleSpeed; private ECarXCarVfmiscManager mVfmiscMgr;
/*      */   private long mW4mUpdateTime;
/*      */   private volatile ISensorGroupValue mW4mValue;
/*      */   
/*      */   private class CallbackScheduled implements Runnable { private final int mRate;
/*      */     final Sensor this$0;
/*      */     
/*      */     CallbackScheduled(int param1Int) {
/*  194 */       this.mRate = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public void run() {
/*      */       try {
/*  200 */         List list = (List)Sensor.this.mRateOfSensorArray.get(this.mRate);
/*  201 */         for (Integer integer : list) {
/*  202 */           Sensor.this.callbackListener(integer.intValue());
/*      */         }
/*  204 */       } catch (Exception exception) {
/*  205 */         exception.printStackTrace();
/*      */       } 
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Sensor(Context paramContext) {
/*  219 */     super(paramContext);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2892 */     this.mVFMiscPACallback = new CarPAEventCallback()
/*      */       {
/*      */         final Sensor this$0;
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2917 */     this.mAirQandFragPACallback = new CarPAEventCallback() { final Sensor this$0;
/*      */         
/*      */         public void onPA_PM25_OutdPm25Lvl(PATypes.PA_PM25_OutdPm25Lvl param1PA_PM25_OutdPm25Lvl) {
/* 2920 */           Sensor.this.callSensorSupportChanged(2105600, 33401, (PATypes.PA_IntBase)param1PA_PM25_OutdPm25Lvl);
/*      */           
/* 2922 */           int i = param1PA_PM25_OutdPm25Lvl.getData();
/* 2923 */           i = Sensor.this.getSensorEventFromSigVlu(33401, i);
/*      */           
/* 2925 */           Sensor.this.mEventSensorValueMap.put(Integer.valueOf(2105600), Integer.valueOf(i));
/* 2926 */           Sensor.this.callbackListener(2105600);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onPA_PM25_IntPm25Lvl(PATypes.PA_PM25_IntPm25Lvl param1PA_PM25_IntPm25Lvl) {
/* 2931 */           Sensor.this.callSensorSupportChanged(2105856, 33400, (PATypes.PA_IntBase)param1PA_PM25_IntPm25Lvl);
/*      */           
/* 2933 */           int i = param1PA_PM25_IntPm25Lvl.getData();
/* 2934 */           i = Sensor.this.getSensorEventFromSigVlu(33400, i);
/*      */           
/* 2936 */           Sensor.this.mEventSensorValueMap.put(Integer.valueOf(2105856), Integer.valueOf(i));
/* 2937 */           Sensor.this.callbackListener(2105856);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onPA_PM25_OutdPm25Vlu(PATypes.PA_PM25_OutdPm25Vlu param1PA_PM25_OutdPm25Vlu) {
/* 2942 */           Sensor.this.callSensorSupportChanged(1049088, 33399, (PATypes.PA_IntBase)param1PA_PM25_OutdPm25Vlu);
/*      */           
/* 2944 */           int i = param1PA_PM25_OutdPm25Vlu.getData();
/* 2945 */           Sensor.this.mContinuousSensorValueMap.put(Integer.valueOf(1049088), Float.valueOf(i));
/*      */         }
/*      */ 
/*      */         
/*      */         public void onPA_PM25_IntPm25Vlu(PATypes.PA_PM25_IntPm25Vlu param1PA_PM25_IntPm25Vlu) {
/* 2950 */           Sensor.this.callSensorSupportChanged(1049344, 33398, (PATypes.PA_IntBase)param1PA_PM25_IntPm25Vlu);
/*      */           
/* 2952 */           int i = param1PA_PM25_IntPm25Vlu.getData();
/* 2953 */           Sensor.this.mContinuousSensorValueMap.put(Integer.valueOf(1049344), Float.valueOf(i));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void onPA_IAQC_ActnSts(PATypes.PA_IAQC_ActnSts param1PA_IAQC_ActnSts) {
/* 2959 */           Sensor.this.callSensorSupportChanged(2106112, 33396, (PATypes.PA_IntBase)param1PA_IAQC_ActnSts);
/*      */           
/* 2961 */           int i = param1PA_IAQC_ActnSts.getData();
/* 2962 */           i = Sensor.this.getSensorEventFromSigVlu(33396, i);
/*      */           
/* 2964 */           Sensor.this.mEventSensorValueMap.put(Integer.valueOf(2106112), Integer.valueOf(i));
/* 2965 */           Sensor.this.callbackListener(2106112);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onPA_PM25_OutdPm25Sts(PATypes.PA_PM25_OutdPm25Sts param1PA_PM25_OutdPm25Sts) {
/* 2970 */           Sensor.this.callSensorSupportChanged(2106880, 33404, (PATypes.PA_IntBase)param1PA_PM25_OutdPm25Sts);
/*      */           
/* 2972 */           int i = param1PA_PM25_OutdPm25Sts.getData();
/* 2973 */           i = Sensor.this.getSensorEventFromSigVlu(33404, i);
/*      */           
/* 2975 */           Sensor.this.mEventSensorValueMap.put(Integer.valueOf(2106880), Integer.valueOf(i));
/* 2976 */           Sensor.this.callbackListener(2106880);
/*      */         }
/*      */ 
/*      */         
/*      */         public void onPA_PM25_IntPm25Sts(PATypes.PA_PM25_IntPm25Sts param1PA_PM25_IntPm25Sts) {
/* 2981 */           Sensor.this.callSensorSupportChanged(2107136, 33403, (PATypes.PA_IntBase)param1PA_PM25_IntPm25Sts);
/*      */           
/* 2983 */           int i = param1PA_PM25_IntPm25Sts.getData();
/* 2984 */           i = Sensor.this.getSensorEventFromSigVlu(33403, i);
/*      */           
/* 2986 */           Sensor.this.mEventSensorValueMap.put(Integer.valueOf(2107136), Integer.valueOf(i));
/* 2987 */           Sensor.this.callbackListener(2107136);
/*      */         } }
/*      */       ;
/*      */     
/* 2991 */     this.mVehChargPACallback = new CarPAEventCallback()
/*      */       {
/*      */         final Sensor this$0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void onPA_VehCharg_DispHvBattLvlOfChrg(PATypes.PA_VehCharg_DispHvBattLvlOfChrg param1PA_VehCharg_DispHvBattLvlOfChrg) {
/* 3003 */           Sensor.this.callSensorSupportChanged(4210688, 33799, (PATypes.PA_IntBase)param1PA_VehCharg_DispHvBattLvlOfChrg);
/*      */           
/* 3005 */           ConcurrentHashMap<Integer, Float> concurrentHashMap = Sensor.this.mContinuousSensorValueMap;
/* 3006 */           float f = (float)(param1PA_VehCharg_DispHvBattLvlOfChrg.getData() * 0.1D);
/*      */           concurrentHashMap.put(Integer.valueOf(4210688), Float.valueOf(f));
/*      */         }
/*      */       };
/* 3010 */     this.mSysSetPACallback = new CarPAEventCallback() {
/*      */         final Sensor this$0;
/*      */         public void onPA_DayNightMode(PATypes.PA_DayNightMode param1PA_DayNightMode) {}
/*      */       }; this.mContext = paramContext; this.mRateOfSensorArray.put(5, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(4, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(3, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(2, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(1, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(0, new CopyOnWriteArrayList()); this.mRateOfSensorArray.put(16, new CopyOnWriteArrayList()); initSignalSensorCorrArray(); this.mTireTmpANDPreStatusMap.put(Integer.valueOf(31320), new int[] { 5243136, 5244160 }); this.mTireTmpANDPreStatusMap.put(Integer.valueOf(31322), new int[] { 5243392, 5244416 }); this.mTireTmpANDPreStatusMap.put(Integer.valueOf(31321), new int[] { 5243648, 5244672 }); this.mTireTmpANDPreStatusMap.put(Integer.valueOf(31323), new int[] { 5243904, 5244928 }); this.mSensorManager = (SensorManager)this.mContext.getSystemService("sensor"); this.mBrightnessManager = BrightnessManager.getInstance(paramContext); this.mBrightnessManager.registerCallBack((IPowerStatusListener)new AutoDayModeReceiver());
/*      */   }
/*      */   private void registerAcceListener() { this.mAcceSensor = this.mSensorManager.getDefaultSensor(1); if (this.mAcceSensor != null) { this.mSensorManager.registerListener(this.mAcceSensorEventListener, this.mAcceSensor, 0); this.mAccePreCallbackTime = SystemClock.elapsedRealtime(); }  }
/*      */   private void registerGyroListener() { this.mGyroSensor = this.mSensorManager.getDefaultSensor(4); if (this.mGyroSensor == null)
/*      */       this.mGyroSensor = this.mSensorManager.getDefaultSensor(16);  if (this.mGyroSensor != null) { this.mSensorManager.registerListener(this.mGyroSensorEventListener, this.mGyroSensor, 0); this.mGyroPreCallbackTime = SystemClock.elapsedRealtime(); }  }
/*      */   private void initSignalSensorCorrArray() { this.mSignalSensorCorrArray.put(30962, 1050112); this.mSignalSensorCorrArray.put(30889, 1050368); this.mSignalSensorCorrArray.put(31415, 1050880); this.mSignalSensorCorrArray.put(30532, 1051392); this.mSignalSensorCorrArray.put(30536, 1051648); this.mSignalSensorCorrArray.put(30482, 1052160); this.mSignalSensorCorrArray.put(31549, 1052672); this.mSignalSensorCorrArray.put(31550, 1052928); this.mSignalSensorCorrArray.put(31573, 1053184); this.mSignalSensorCorrArray.put(30961, 4194816); this.mSignalSensorCorrArray.put(30906, 4206592); this.mSignalSensorCorrArray.put(30901, 4206848); this.mSignalSensorCorrArray.put(33799, 4210688); this.mSignalSensorCorrArray.put(30925, 4211968); this.mSignalSensorCorrArray.put(30788, 2097408); this.mSignalSensorCorrArray.put(31577, 3148288); this.mSignalSensorCorrArray.put(30922, 3148544); this.mSignalSensorCorrArray.put(31413, 2098176); this.mSignalSensorCorrArray.put(30779, 2102272); this.mSignalSensorCorrArray.put(30449, 2106624); this.mSignalSensorCorrArray.put(30915, 3145984); this.mSignalSensorCorrArray.put(31414, 3146496); this.mSignalSensorCorrArray.put(31409, 3146752); this.mSignalSensorCorrArray.put(30614, 5243136); this.mSignalSensorCorrArray.put(30696, 5243392); this.mSignalSensorCorrArray.put(30623, 5243648); this.mSignalSensorCorrArray.put(30705, 5243904); this.mSignalSensorCorrArray.put(30617, 5244160); this.mSignalSensorCorrArray.put(30699, 5244416); this.mSignalSensorCorrArray.put(30626, 5244672); this.mSignalSensorCorrArray.put(30708, 5244928); this.mSignalSensorCorrArray.put(30615, 5245184); this.mSignalSensorCorrArray.put(30697, 5245440); this.mSignalSensorCorrArray.put(30624, 5245696); this.mSignalSensorCorrArray.put(30706, 5245952); this.mSignalSensorCorrArray.put(30618, 5246208); this.mSignalSensorCorrArray.put(30700, 5246464); this.mSignalSensorCorrArray.put(30627, 5246720); this.mSignalSensorCorrArray.put(30709, 5246976); this.mSignalSensorCorrArray.put(30612, 5247232); this.mSignalSensorCorrArray.put(30694, 5247488); this.mSignalSensorCorrArray.put(30621, 5247744); this.mSignalSensorCorrArray.put(30703, 5248000); this.mSignalSensorCorrArray.put(30621, 5247744); this.mSignalSensorCorrArray.put(30621, 5247744); this.mSignalSensorCorrArray.put(30621, 5247744); this.mSignalSensorCorrArray.put(30611, 5248256); this.mSignalSensorCorrArray.put(30693, 5248512); this.mSignalSensorCorrArray.put(30620, 5248768); this.mSignalSensorCorrArray.put(30702, 5249024); this.mSignalSensorCorrArray.put(31265, 2110464); this.mSignalSensorCorrArray.put(31492, 8389376); this.mSignalSensorCorrArray.put(31608, 8389632); this.mSignalSensorCorrArray.put(31610, 8389632); this.mSignalSensorCorrArray.put(31602, 8389632); this.mSignalSensorCorrArray.put(31605, 8389632); this.mSignalSensorCorrArray.put(30989, 1055232); this.mSignalSensorCorrArray.put(30988, 1055232); this.mSignalSensorCorrArray.put(31272, 2101760); this.mSignalSensorCorrArray.put(31274, 2102016); this.mSignalSensorCorrArray.put(33401, 2105600); this.mSignalSensorCorrArray.put(33400, 2105856); this.mSignalSensorCorrArray.put(33399, 1049088); this.mSignalSensorCorrArray.put(33398, 1049344); this.mSignalSensorCorrArray.put(33396, 2106112); this.mSignalSensorCorrArray.put(33404, 2106880); this.mSignalSensorCorrArray.put(33403, 2107136); this.mSignalSensorCorrArray.put(33477, 2101248); this.mSignalSensorCorrArray.put(30956, 1054720); this.mSignalSensorCorrArray.put(30954, 1054976); }
/*      */   protected void onInitCarSignalManager() { this.mAirQandFragMgr = this.mECarXCarSetManager.getECarXCarAirqlyandfragraManager(); this.mVehchargMgr = this.mECarXCarSetManager.getECarXCarVehchargManager(); this.mSysSetMgr = this.mECarXCarSetManager.getECarXCarSystemsettingManager(); try { this.mAirQandFragMgr.registerCallback(this.mAirQandFragPACallback, getPAFilter()); this.mVehchargMgr.registerCallback(this.mVehChargPACallback, getPAFilter()); this.mSysSetMgr.registerCallback(this.mSysSetPACallback, getPAFilter()); IBinder iBinder2 = ServiceManager.getService("ecarxcar_service"); IECarXCar iECarXCar = IECarXCar.Stub.asInterface(iBinder2); IBinder iBinder1 = iECarXCar.getCarService("car_sensor_tmp"); this.mSensorTmpService = IECarXCarSensorTmp.Stub.asInterface(iBinder1); try { this.mSensorTmpService.registerListener(this.mSensorTmperListener); } catch (RemoteException remoteException) { remoteException.printStackTrace(); }  addSignalFilter(Integer.valueOf(29341)); addSignalFilter(Integer.valueOf(30788)); addLocalSignalFilter(Integer.valueOf(8389376)); addLocalSignalFilter(Integer.valueOf(8389632)); } catch (Exception exception) { exception.printStackTrace(); }  super.onInitCarSignalManager(); }
/*      */   protected void initPAFilter() { super.initPAFilter(); addPAFilter(Integer.valueOf(33404)); addPAFilter(Integer.valueOf(33403)); addPAFilter(Integer.valueOf(33399)); addPAFilter(Integer.valueOf(33398)); addPAFilter(Integer.valueOf(33401)); addPAFilter(Integer.valueOf(33400)); addPAFilter(Integer.valueOf(33477)); addPAFilter(Integer.valueOf(33396)); addPAFilter(Integer.valueOf(33799)); }
/*      */   private void addLocalSignalFilter(Integer paramInteger) { switch (paramInteger.intValue()) { case 8389632: addSignalFilter(Integer.valueOf(31608)); addSignalFilter(Integer.valueOf(31610)); addSignalFilter(Integer.valueOf(31602)); addSignalFilter(Integer.valueOf(31605)); break;case 8389376: addSignalFilter(Integer.valueOf(31578)); addSignalFilter(Integer.valueOf(31492)); this.mPulsePreCallbackTime = SystemClock.elapsedRealtime(); break;case 5259264: addSignalFilter(Integer.valueOf(30616)); addSignalFilter(Integer.valueOf(30698)); addSignalFilter(Integer.valueOf(30625)); addSignalFilter(Integer.valueOf(30707)); break;case 5249024: addSignalFilter(Integer.valueOf(30702)); break;case 5248768: addSignalFilter(Integer.valueOf(30620)); break;case 5248512: addSignalFilter(Integer.valueOf(30693)); break;case 5248256: addSignalFilter(Integer.valueOf(30611)); break;case 5248000: addSignalFilter(Integer.valueOf(30703)); break;case 5247744: addSignalFilter(Integer.valueOf(30621)); break;case 5247488: addSignalFilter(Integer.valueOf(30694)); break;case 5247232: addSignalFilter(Integer.valueOf(30612)); break;case 5246976: addSignalFilter(Integer.valueOf(30709)); break;case 5246720: addSignalFilter(Integer.valueOf(30627)); break;case 5246464: addSignalFilter(Integer.valueOf(30700)); break;case 5246208: addSignalFilter(Integer.valueOf(30618)); break;case 5245952: addSignalFilter(Integer.valueOf(30706)); break;case 5245696: addSignalFilter(Integer.valueOf(30624)); break;case 5245440: addSignalFilter(Integer.valueOf(30697)); break;case 5245184: addSignalFilter(Integer.valueOf(30615)); break;case 5244928: addSignalFilter(Integer.valueOf(30708)); addSignalFilter(Integer.valueOf(31323)); break;case 5244672: addSignalFilter(Integer.valueOf(30626)); addSignalFilter(Integer.valueOf(31321)); break;case 5244416: addSignalFilter(Integer.valueOf(30699)); addSignalFilter(Integer.valueOf(31322)); break;case 5244160: addSignalFilter(Integer.valueOf(30617)); addSignalFilter(Integer.valueOf(31320)); break;case 5243904: addSignalFilter(Integer.valueOf(30705)); addSignalFilter(Integer.valueOf(31323)); break;case 5243648: addSignalFilter(Integer.valueOf(30623)); addSignalFilter(Integer.valueOf(31321)); break;case 5243392: addSignalFilter(Integer.valueOf(30696)); addSignalFilter(Integer.valueOf(31322)); break;case 5243136: addSignalFilter(Integer.valueOf(30614)); addSignalFilter(Integer.valueOf(31320)); break;case 4211968: addSignalFilter(Integer.valueOf(30925)); break;case 4206848: addSignalFilter(Integer.valueOf(30901)); break;case 4206592: addSignalFilter(Integer.valueOf(30906)); break;case 4194816: addSignalFilter(Integer.valueOf(30961)); break;case 3148544: addSignalFilter(Integer.valueOf(30922)); break;case 3148288: addSignalFilter(Integer.valueOf(31577)); break;case 3147264: addSignalFilter(Integer.valueOf(30978)); addSignalFilter(Integer.valueOf(30979)); addSignalFilter(Integer.valueOf(30980)); addSignalFilter(Integer.valueOf(30981)); addSignalFilter(Integer.valueOf(30984)); break;case 3147008: addSignalFilter(Integer.valueOf(30984)); break;case 3146496: addSignalFilter(Integer.valueOf(31414)); break;case 3145984: addSignalFilter(Integer.valueOf(30915)); break;case 2110464: addSignalFilter(Integer.valueOf(31265)); break;case 2106624: addSignalFilter(Integer.valueOf(30449)); break;case 2102272: addSignalFilter(Integer.valueOf(30779)); break;case 2102016: addSignalFilter(Integer.valueOf(31274)); break;case 2101760: addSignalFilter(Integer.valueOf(31272)); break;case 2098432: case 3146752: case 3148032: addSignalFilter(Integer.valueOf(31409)); break;case 2098176: addSignalFilter(Integer.valueOf(31413)); break;case 2097664: addSignalFilter(Integer.valueOf(31419)); addSignalFilter(Integer.valueOf(31509)); break;case 2097408: addSignalFilter(Integer.valueOf(30788)); break;case 1055232: addSignalFilter(Integer.valueOf(30988)); addSignalFilter(Integer.valueOf(30989)); break;case 1054976: addSignalFilter(Integer.valueOf(30954)); break;case 1054720: addSignalFilter(Integer.valueOf(30956)); break;case 1053184: addSignalFilter(Integer.valueOf(31573));case 4194560: case 4195072: addSignalFilter(Integer.valueOf(30959)); addSignalFilter(Integer.valueOf(30958)); break;case 1052928: addSignalFilter(Integer.valueOf(31550)); break;case 1052672: addSignalFilter(Integer.valueOf(31549)); break;case 1052160: addSignalFilter(Integer.valueOf(30482)); break;case 1051648: addSignalFilter(Integer.valueOf(30536)); addSignalFilter(Integer.valueOf(30538)); break;case 1051392: addSignalFilter(Integer.valueOf(30532)); addSignalFilter(Integer.valueOf(30533)); break;case 1050880: addSignalFilter(Integer.valueOf(31415)); break;case 1050624: addSignalFilter(Integer.valueOf(30956)); addSignalFilter(Integer.valueOf(30954)); break;case 1050368: addSignalFilter(Integer.valueOf(30889)); break;case 1050112: addSignalFilter(Integer.valueOf(30962)); break;case 1048832: addSignalFilter(Integer.valueOf(31578)); break; }  try { this.mCarSignalManager.registerCallback(this.mCarSignalEventCallback, getSignalFilter()); } catch (Exception exception) { exception.printStackTrace(); }  }
/*      */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) { ConcurrentHashMap<Integer, Float> concurrentHashMap; float f; i = paramECarXCarPropertyValue.getPropertyId(); null = ((Integer)paramECarXCarPropertyValue.getValue()).intValue(); null = this.mSignalSensorCorrArray.get(i); if (null != 0) { int j = getSensorType(null); if (j == 1 || j == 3) { float f1 = getSensorVluFromSigVlu(i, null).floatValue(); this.mContinuousSensorValueMap.put(Integer.valueOf(null), Float.valueOf(f1)); } else if (j == 2) { j = getSensorEventFromSigVlu(i, null); this.mEventSensorValueMap.put(Integer.valueOf(null), Integer.valueOf(j)); callbackListener(null); }  }  if (this.mTireTmpANDPreStatusMap.get(Integer.valueOf(i)) != null)
/*      */       for (int j : (int[])this.mTireTmpANDPreStatusMap.get(Integer.valueOf(i)))
/*      */         callbackFunctionStatus(j, getTireTmANDPreStatus(j));   switch (i) { default: return;case 31578: f = getSensorVluFromSigVlu(i, null).floatValue(); this.mContinuousSensorValueMap.put(Integer.valueOf(1048832), Float.valueOf(f));case 31419: case 31509: null = getGera(); if (null != this.mGear) { this.mGear = null; this.mEventSensorValueMap.put(Integer.valueOf(2097664), Integer.valueOf(this.mGear)); callbackListener(2097664); } case 31409: if (null == 9) { null = 3145729; } else { null = 3145728; }  if (null != this.mEngCoolantSysWarn) { this.mEngCoolantSysWarn = null; ConcurrentHashMap<Integer, Integer> concurrentHashMap1 = this.mEventSensorValueMap; null = this.mEngCoolantSysWarn; concurrentHashMap1.put(Integer.valueOf(3148032), Integer.valueOf(null)); callbackListener(3148032); }  null = getCoolAntLvl(null); if (null != this.mCoolAntLvl) { this.mCoolAntLvl = null; this.mEventSensorValueMap.put(Integer.valueOf(2098432), Integer.valueOf(this.mCoolAntLvl)); callbackListener(2098432); } case 30988: case 30989: concurrentHashMap = this.mContinuousSensorValueMap; f = getSensorLatestValue(1055232); concurrentHashMap.put(Integer.valueOf(1055232), Float.valueOf(f));case 30978: case 30979: case 30980: case 30981: case 30984: null = getTransMissionSys(); if (null != this.mTranSysWarn) { this.mTranSysWarn = null; ConcurrentHashMap<Integer, Integer> concurrentHashMap1 = this.mEventSensorValueMap; null = this.mTranSysWarn; concurrentHashMap1.put(Integer.valueOf(3147264), Integer.valueOf(null)); callbackListener(3147264); }  if (i == 30984)
/*      */           try { null = this.mCarSignalManager.getVehNotifAndLedFltStsByte0(); String str1 = String.format("%8s", new Object[] { Integer.toBinaryString(null) }); String str2 = str1.replaceAll(" ", "0"); StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append(str2.charAt(0)); stringBuilder.append(""); null = Integer.parseInt(stringBuilder.toString()); if (null == 5 && null != this.mSaveByte6) { this.mSaveByte6 = null; ConcurrentHashMap<Integer, Integer> concurrentHashMap1 = this.mEventSensorValueMap; null = getHTTWStatus(); concurrentHashMap1.put(Integer.valueOf(3147008), Integer.valueOf(null)); callbackListener(3147008); }  } catch (Exception exception) { exception.printStackTrace(); }  case 30958: case 30959: getCurrFuel();case 30954: case 30956: f = getSensorLatestValue(1050624); this.mContinuousSensorValueMap.put(Integer.valueOf(1050624), Float.valueOf(f));case 30616: case 30625: case 30698: case 30707: null = getTPMSStatus(); this.mEventSensorValueMap.put(Integer.valueOf(5259264), Integer.valueOf(null)); callbackListener(5259264); judgeContinueCallback(null);case 30538: functionStatus = getInOrOutTemSts(1051648); callbackFunctionStatus(1051648, functionStatus);case 30533: functionStatus = getInOrOutTemSts(1051392); callbackFunctionStatus(1051392, functionStatus);case 29341: case 30779: case 30788: break; }  for (int i : TIRE_NOTIFICATION)
/*      */       callbackFunctionStatus(i, getTireFunctionStatus());  FunctionStatus functionStatus = getFuelconStatus(); callbackFunctionStatus(4194560, functionStatus); functionStatus = getFuelconStatus(); callbackFunctionStatus(4195072, functionStatus); functionStatus = isSensorSupportedForSelf(4206848); callbackFunctionStatus(4206848, functionStatus); functionStatus = isSensorSupportedForSelf(4206592); callbackFunctionStatus(4206592, functionStatus); for (Iterator<Integer> iterator = this.mTireTmpANDPreStatusMap.keySet().iterator(); iterator.hasNext(); ) { null = ((Integer)iterator.next()).intValue(); for (int i : (int[])this.mTireTmpANDPreStatusMap.get(Integer.valueOf(null)))
/*      */         callbackFunctionStatus(i, getTireTmANDPreStatus(i));  }  }
/*      */   private void getCurrFuel() { float f = Float.MIN_VALUE; try { int i = this.mCarSignalManager.getFuCnsAvgIndcdFuCnsIndcdVal(); int k = this.mCarSignalManager.getFuCnsAvgIndcdFuCnsIndcdUnit(); int j = i & 0xFFF; switch (k) { case 3: f = (float)(25600.0D / (109 * j) * 0.1D); break;case 2: f = (float)(25600.0D / (91 * j) * 0.1D); break;case 1: f = (float)(100.0D / j * 0.1D); break;case 0: f = (float)(j * 0.1D); break; }  if ((i & 0x1000) == 0) { if (f != Float.MIN_VALUE)
/*      */           this.mAverFuelCon = f;  ConcurrentHashMap<Integer, Float> concurrentHashMap = this.mContinuousSensorValueMap; f = this.mAverFuelCon; concurrentHashMap.put(Integer.valueOf(4194560), Float.valueOf(f)); } else { if (j != 0 && f != Float.MIN_VALUE)
/*      */           this.mSingFuelCon = f;  ConcurrentHashMap<Integer, Float> concurrentHashMap = this.mContinuousSensorValueMap; f = this.mSingFuelCon; concurrentHashMap.put(Integer.valueOf(4195072), Float.valueOf(f)); }  } catch (Exception exception) { exception.printStackTrace(); }  }
/*      */   private void callbackFunctionStatus(int paramInt, FunctionStatus paramFunctionStatus) { if (this.mSensorStatus.get(Integer.valueOf(paramInt)) != null)
/*      */       if (paramFunctionStatus != this.mSensorStatus.get(Integer.valueOf(paramInt))) { this.mSensorStatus.put(Integer.valueOf(paramInt), paramFunctionStatus); List list = this.mSensorListenerMap.get(Integer.valueOf(paramInt)); if (list != null) { for (ISensor.ISensorListener iSensorListener : list) { try { iSensorListener.onSensorSupportChanged(paramInt, paramFunctionStatus); } catch (Exception exception) { exception.printStackTrace(); }  }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onSensorSupportChanged: sensor: "); stringBuilder.append(paramInt); stringBuilder.append("FunctionStatus: "); stringBuilder.append(paramFunctionStatus.name()); String str = stringBuilder.toString(); Log.d("Sensor", str); } else { this.mSensorStatus.remove(Integer.valueOf(paramInt)); }  }   }
/*      */   private FunctionStatus getEnduranceMileageStatus(int paramInt) { if (paramInt == 1 || paramInt == 4)
/*      */       return FunctionStatus.active;  return FunctionStatus.notavailable; }
/*      */   private void judgeContinueCallback(int paramInt) { if (paramInt == 5259266) { ArrayList<Integer> arrayList = new ArrayList(); try { arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeFrntTireMsgSysWarnFlg())); arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeReTireMsgSysWarnFlg())); arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiFrntTireMsgSysWarnFlg())); arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiReTireMsgSysWarnFlg())); } catch (Exception exception) { exception.printStackTrace(); }  for (paramInt = 0; paramInt < arrayList.size(); paramInt++) { if (((Integer)arrayList.get(paramInt)).intValue() == 1) { this.mEventSensorValueMap.put(Integer.valueOf(5259264), Integer.valueOf(getNumberTPMS(paramInt))); callbackListener(5259264); }  }  }  }
/*      */   private int getNumberTPMS(int paramInt) { int i = 5259265; switch (paramInt) { default: paramInt = i; return paramInt;case 3: paramInt = 5259270; return paramInt;case 2: paramInt = 5259268; return paramInt;case 1: paramInt = 5259269; return paramInt;case 0: break; }  paramInt = 5259267; return paramInt; }
/*      */   private int getHTTWStatus() { int i = 3145728; if (this.mSaveByte6 == 1)
/*      */       i = 3145729;  return i; } private int getSensorEventFromSigVlu(int paramInt1, int paramInt2) { StringBuilder stringBuilder; byte b = -1; switch (paramInt1) { default: paramInt1 = b; return paramInt1;case 33477: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 1: paramInt1 = 2101249; return paramInt1;case 0: break; }  paramInt1 = 2101250; return paramInt1;case 33403: case 33404: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 3: paramInt1 = 2106883; return paramInt1;case 2: paramInt1 = 2106884; return paramInt1;case 1: paramInt1 = 2106882; return paramInt1;case 0: break; }  paramInt1 = 2106881; return paramInt1;case 33400: case 33401: if (paramInt2 != 7) { switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 5: paramInt1 = 2105605; return paramInt1;case 4: paramInt1 = 2105604; return paramInt1;case 3: paramInt1 = 2105603; return paramInt1;case 2: paramInt1 = 2105602; return paramInt1;case 1: paramInt1 = 2105606; return paramInt1;case 0: break; }  paramInt1 = 2105601; } else { paramInt1 = -1; }  return paramInt1;case 33396: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 3: paramInt1 = 2106116; return paramInt1;case 2: paramInt1 = 2106115; return paramInt1;case 1: paramInt1 = 2106114; return paramInt1;case 0: break; }  paramInt1 = 2106113; return paramInt1;case 31577: switch (paramInt2) { default: paramInt1 = 3148288; break;case 3: paramInt1 = 3148291; break;case 2: paramInt1 = 3148290; break;case 1: paramInt1 = 3148289; break;case 0: case 4: case 5: case 6: case 7: paramInt1 = 3148288; break; }  stringBuilder = new StringBuilder(); stringBuilder.append("getSensorEventFromSigVlu: CarSignalManager.SignalId_VehMtnStVehMtnSt: "); stringBuilder.append(paramInt2); Log.d("Sensor", stringBuilder.toString()); return paramInt1;case 31414: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 1: paramInt1 = 3145729; return paramInt1;case 0: break; }  paramInt1 = 3145728; return paramInt1;case 31413: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 3: paramInt1 = 2098180; return paramInt1;case 2: paramInt1 = 2098179; return paramInt1;case 1: paramInt1 = 2098178; return paramInt1;case 0: break; }  paramInt1 = 2098177; return paramInt1;case 31409: switch (paramInt2) { default: paramInt1 = 3145728; return paramInt1;case 2: case 3: paramInt1 = 3145731; return paramInt1;case 1: case 4: paramInt1 = 3145730; return paramInt1;case 0: break; }  paramInt1 = 3145728; return paramInt1;case 31272: case 31274: if (paramInt2 == 1) { paramInt1 = 2101762; } else { paramInt1 = b; if (paramInt2 == 0)
/*      */             paramInt1 = 2101761;  }  return paramInt1;case 31265: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 3: paramInt1 = -1; return paramInt1;case 1: case 2: paramInt1 = 2110210; return paramInt1;case 0: break; }  paramInt1 = 2110209; return paramInt1;case 30922: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 1: paramInt1 = 3148545; return paramInt1;case 0: break; }  paramInt1 = 3148546; return paramInt1;case 30915: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 1: paramInt1 = 3145729; return paramInt1;case 0: break; }  paramInt1 = 3145728; return paramInt1;case 30788: if (paramInt2 != 11) { if (paramInt2 != 13) { switch (paramInt2) { default: paramInt1 = 2097409; break;case 2: paramInt1 = 2097413; break;case 1: paramInt1 = 2097411; break;case 0: paramInt1 = 2097410; break; }  } else { paramInt1 = 2097415; }  } else { paramInt1 = 2097414; }  stringBuilder = new StringBuilder(); stringBuilder.append("getSensorEventFromSigVlu: usg mode(UsgModAbdnd:0, UsgModInActv:1,UsgModCnvinc:2, UsgModActv:11, UsgModDrvg:13): "); stringBuilder.append(paramInt2); Log.d("Sensor", stringBuilder.toString()); return paramInt1;case 30779: if (paramInt2 != 5) { switch (paramInt2) { default: paramInt1 = b; break;case 3: paramInt1 = 2102276; break;case 2: paramInt1 = 2102274; break;case 1: paramInt1 = 2102275; break;case 0: paramInt1 = 2102273; break; }  } else { paramInt1 = 2102277; }  stringBuilder = new StringBuilder(); stringBuilder.append("getSensorEventFromSigVlu: car mode(CarModNorm:0, CarModTrnsp:1,CarModFcy:2, CarModCrash:3, CarModDyno:5): "); stringBuilder.append(paramInt2); Log.d("Sensor", stringBuilder.toString()); return paramInt1;case 30618: case 30627: case 30700: case 30709: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 1: paramInt1 = 5245187; return paramInt1;case 0: break; }  paramInt1 = 5245185; return paramInt1;case 30615: case 30624: case 30697: case 30706: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 2: paramInt1 = 5245189; return paramInt1;case 1: paramInt1 = 5245187; return paramInt1;case 0: break; }  paramInt1 = 5245185; return paramInt1;case 30612: case 30621: case 30694: case 30703: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 1: paramInt1 = 5247234; return paramInt1;case 0: break; }  paramInt1 = 5247233; return paramInt1;case 30611: case 30620: case 30693: case 30702: switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 1: paramInt1 = 5248261; return paramInt1;case 0: break; }  paramInt1 = -1; return paramInt1;case 30449: break; }  switch (paramInt2) { default: paramInt1 = b; return paramInt1;case 3: paramInt1 = 2106628; return paramInt1;case 2: paramInt1 = 2106627; return paramInt1;case 1: paramInt1 = 2106626; return paramInt1;case 0: break; }  paramInt1 = 2106630; return paramInt1; } private Float getSensorVluFromSigVlu(int paramInt1, int paramInt2) { float f = -1.0F; switch (paramInt1) { default: return Float.valueOf(f);case 33799: f = (float)(paramInt2 * 0.1D);case 31610: this.mVRR = getSpeedFromValue(paramInt2);case 31608: this.mVRL = getSpeedFromValue(paramInt2);case 31605: this.mVFR = getSpeedFromValue(paramInt2);case 31602: this.mVFL = getSpeedFromValue(paramInt2);case 31578: this.mVehicleSpeed = (float)(paramInt2 * 0.00391D * 3.6D); f = (float)(paramInt2 * 0.00391D);case 31550: f = (float)(paramInt2 * 0.0078125D);case 31549: f = (float)(paramInt2 * 9.765625E-4D); this.mSteerAngle = f;case 31492: if (paramInt2 == 2) { this.mGearState = 0; } else { this.mGearState = 1; } case 31415: f = (float)(paramInt2 * 0.5D);case 30962: f = (float)(paramInt2 * 0.2D * 1000.0D);case 30961: f = (float)(paramInt2 * 0.1D);case 30925: case 30954: case 30956: f = paramInt2;
/*      */       case 30901: f = (paramInt2 * 24);
/*      */       case 30617: case 30626: case 30699: case 30708: f = (paramInt2 - 50);
/*      */       case 30614: case 30623: case 30696: case 30705: f = (float)(paramInt2 * 1.373D);
/*      */       case 30536: f = (float)(paramInt2 * 0.1D - 60.0D);
/*      */       case 30532: f = (float)(paramInt2 * 0.1D - 70.0D);
/*      */       case 30482: case 30889: case 30906: case 31573: break; }  f = paramInt2; } private float getSpeedFromValue(int paramInt) { float f; if (this.mGearState == 0) { f = (float)(0.0D - paramInt * 0.00391D * 3.6D); } else { f = (float)(paramInt * 0.00391D * 3.6D); }  return f; } private void callbackListener(int paramInt) { int i = getSensorType(paramInt); List list = this.mSensorListenerMap.get(Integer.valueOf(paramInt)); if (list != null && list.size() > 0)
/*      */       if (i == 2) { i = Integer.MIN_VALUE; if (this.mEventSensorValueMap.get(Integer.valueOf(paramInt)) != null)
/*      */           i = ((Integer)this.mEventSensorValueMap.get(Integer.valueOf(paramInt))).intValue();  for (ISensor.ISensorListener iSensorListener : list) { try { iSensorListener.onSensorEventChanged(paramInt, i); } catch (Exception exception) { exception.printStackTrace(); }  }  } else if (i == 1) { float f = Float.MIN_VALUE; if (this.mContinuousSensorValueMap.get(Integer.valueOf(paramInt)) != null)
/*      */           f = ((Float)this.mContinuousSensorValueMap.get(Integer.valueOf(paramInt))).floatValue();  for (ISensor.ISensorListener iSensorListener : exception) { try { iSensorListener.onSensorValueChanged(paramInt, f); } catch (Exception exception1) { exception1.printStackTrace(); }  }  } else if (i == 3) { long l = SystemClock.elapsedRealtime(); ISensorGroupValue iSensorGroupValue = getGroupSensorValue(paramInt, l); for (ISensor.ISensorListener iSensorListener : exception1) { if (iSensorGroupValue != null)
/* 3049 */             try { ((ISensorGroup.ISensorGroupListener)iSensorListener).onSensorGroupChanged(paramInt, iSensorGroupValue); } catch (Exception exception2) { exception2.printStackTrace(); }   }  }   } private int getSensorType(int paramInt) { byte b = -1;
/* 3050 */     if (isSensorSupportedForSelf(paramInt) == FunctionStatus.notavailable)
/* 3051 */     { paramInt = 0; }
/*      */     else
/* 3053 */     { switch (paramInt) { default: paramInt = b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3138 */           return paramInt;case 8388864: case 8389120: case 8389376: case 8389632: paramInt = 3; return paramInt;case 2097408: case 2097664: case 2098176: case 2098432: case 2101248: case 2101760: case 2102016: case 2102272: case 2105600: case 2105856: case 2106112: case 2106624: case 2106880: case 2107136: case 2110464: case 3145984: case 3146496: case 3146752: case 3147008: case 3147264: case 3148032: case 3148288: case 3148544: case 5245184: case 5245440: case 5245696: case 5245952: case 5246208: case 5246464: case 5246720: case 5246976: case 5247232: case 5247488: case 5247744: case 5248000: case 5248256: case 5248512: case 5248768: case 5249024: case 5259264: paramInt = 2; return paramInt;case 1048832: case 1049088: case 1049344: case 1050112: case 1050368: case 1050624: case 1050880: case 1051136: case 1051392: case 1051648: case 1052160: case 1052672: case 1052928: case 1053184: case 1054720: case 1054976: case 1055232: case 4194560: case 4194816: case 4195072: case 4206592: case 4206848: case 4210688: case 4211968: case 5243136: case 5243392: case 5243648: case 5243904: case 5244160: case 5244416: case 5244672: case 5244928: break; }  paramInt = 1; }  return paramInt; }
/*      */   protected void onErrorEvent(int paramInt1, int paramInt2) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onErrorEvent: propertyId: "); stringBuilder.append(paramInt1); Log.e("Sensor", stringBuilder.toString()); }
/*      */   public FunctionStatus isSensorSupported(int paramInt) { FunctionStatus functionStatus = isSensorSupportedForSelf(paramInt); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isSensorSupported: sensor: 0x"); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(", status: "); stringBuilder.append(functionStatus.name()); String str = stringBuilder.toString(); Log.d("Sensor", str); return functionStatus; }
/*      */   private FunctionStatus isSensorSupportedForSelf(int paramInt) { boolean bool1; FunctionStatus functionStatus2, functionStatus1 = FunctionStatus.notavailable; boolean bool = false; switch (paramInt) { default: return functionStatus1;case 5245184: case 5245440: case 5245696: case 5245952: case 5246208: case 5246464: case 5246720: case 5246976: case 5247232: case 5247488: case 5247744: case 5248000: case 5248256: case 5248512: case 5248768: case 5249024: case 5259264: functionStatus1 = getTireFunctionStatus();case 5243136: case 5243392: case 5243648: case 5243904: case 5244160: case 5244416: case 5244672: case 5244928: functionStatus1 = getTireTmANDPreStatus(paramInt);case 4210688: bool1 = carConfigAnyMatch(29337, new int[] { 3 }); if (usageModeAnyMatch(new int[] { 2, 1, 11, 13 })) if (carModeAnyMatch(new int[] { 0, 3, 5 })) bool = true;   functionStatus1 = SignalUtils.functionStatusIs(bool1, bool);case 4206592: case 4206848: if (usageModeAnyMatch(new int[] { 13 })) functionStatus1 = FunctionStatus.active; case 4194560: case 4195072: functionStatus1 = getFuelconStatus();case 2107136: try { PATypes.PA_PM25_IntPm25Sts pA_PM25_IntPm25Sts = this.mAirQandFragMgr.getPA_PM25_IntPm25Sts(); FunctionStatus functionStatus = functionStatus1; if (pA_PM25_IntPm25Sts != null) functionStatus = SignalUtils.convertToFunctionStatus(pA_PM25_IntPm25Sts.getAvailability());  functionStatus1 = functionStatus; } catch (Exception exception) { exception.printStackTrace(); } case 2106880: try { PATypes.PA_PM25_OutdPm25Sts pA_PM25_OutdPm25Sts = this.mAirQandFragMgr.getPA_PM25_OutdPm25Sts(); FunctionStatus functionStatus = functionStatus1; if (pA_PM25_OutdPm25Sts != null) functionStatus = SignalUtils.convertToFunctionStatus(pA_PM25_OutdPm25Sts.getAvailability());  functionStatus1 = functionStatus; } catch (Exception exception) { exception.printStackTrace(); } case 2106112: try { PATypes.PA_IAQC_ActnSts pA_IAQC_ActnSts = this.mAirQandFragMgr.getPA_IAQC_ActnSts(); FunctionStatus functionStatus = functionStatus1; if (pA_IAQC_ActnSts != null) functionStatus = SignalUtils.convertToFunctionStatus(pA_IAQC_ActnSts.getAvailability());  functionStatus1 = functionStatus; } catch (Exception exception) { exception.printStackTrace(); } case 2105856: try { PATypes.PA_PM25_IntPm25Lvl pA_PM25_IntPm25Lvl = this.mAirQandFragMgr.getPA_PM25_IntPm25Lvl(); FunctionStatus functionStatus = functionStatus1; if (pA_PM25_IntPm25Lvl != null) functionStatus = SignalUtils.convertToFunctionStatus(pA_PM25_IntPm25Lvl.getAvailability());  functionStatus1 = functionStatus; } catch (CarNotConnectedException carNotConnectedException) { carNotConnectedException.printStackTrace(); } case 2105600: try { PATypes.PA_PM25_OutdPm25Lvl pA_PM25_OutdPm25Lvl = this.mAirQandFragMgr.getPA_PM25_OutdPm25Lvl(); FunctionStatus functionStatus = functionStatus1; if (pA_PM25_OutdPm25Lvl != null) functionStatus = SignalUtils.convertToFunctionStatus(pA_PM25_OutdPm25Lvl.getAvailability());  functionStatus1 = functionStatus; } catch (CarNotConnectedException carNotConnectedException) { carNotConnectedException.printStackTrace(); } case 2101248: try { PATypes.PA_DayNightMode pA_DayNightMode = this.mSysSetMgr.getPA_DayNightMode(); FunctionStatus functionStatus = functionStatus1; if (pA_DayNightMode != null) functionStatus = SignalUtils.convertToFunctionStatus(pA_DayNightMode.getAvailability());  functionStatus1 = functionStatus; } catch (CarNotConnectedException carNotConnectedException) { carNotConnectedException.printStackTrace(); } case 1054976: functionStatus2 = functionStatus1; try { if (3 == this.mCarSignalManager.getcarconfig13()) functionStatus2 = FunctionStatus.active;  functionStatus1 = functionStatus2; } catch (Exception exception) { exception.printStackTrace(); } case 1051648: functionStatus1 = getInOrOutTemSts(1051648);case 1051392: functionStatus1 = getInOrOutTemSts(1051392);case 1049600: case 1049856: case 1051904: case 1052416: case 2097920: case 2098688: case 2101504: case 2102528: case 2106368: case 3146240: case 4214784: functionStatus1 = FunctionStatus.notavailable;case 1049344: try { PATypes.PA_PM25_IntPm25Vlu pA_PM25_IntPm25Vlu = this.mAirQandFragMgr.getPA_PM25_IntPm25Vlu(); functionStatus2 = functionStatus1; if (pA_PM25_IntPm25Vlu != null) functionStatus2 = SignalUtils.convertToFunctionStatus(pA_PM25_IntPm25Vlu.getAvailability());  functionStatus1 = functionStatus2; } catch (Exception exception) { exception.printStackTrace(); } case 1049088: try { PATypes.PA_PM25_OutdPm25Vlu pA_PM25_OutdPm25Vlu = this.mAirQandFragMgr.getPA_PM25_OutdPm25Vlu(); functionStatus2 = functionStatus1; if (pA_PM25_OutdPm25Vlu != null) functionStatus2 = SignalUtils.convertToFunctionStatus(pA_PM25_OutdPm25Vlu.getAvailability());  functionStatus1 = functionStatus2; } catch (Exception exception) { exception.printStackTrace(); } case 1048832: case 1050112: case 1050368: case 1050624: case 1050880: case 1052160: case 1052672: case 1052928: case 1053184: case 1054720: case 1055232: case 2097408: case 2097664: case 2098176: case 2098432: case 2101760: case 2102016: case 2102272: case 2106624: case 2110464: case 3145984: case 3146496: case 3146752: case 3147008: case 3147264: case 3148032: case 3148288: case 3148544: case 4194816: case 4211968: case 8388864: case 8389120: case 8389376: case 8389632: break; }  functionStatus1 = FunctionStatus.active; }
/*      */   private FunctionStatus getInOrOutTemSts(int paramInt) { FunctionStatus functionStatus = FunctionStatus.notavailable; byte b = -1; if (paramInt == 1051648) { try { paramInt = this.mCarSignalManager.getCmptmtTFrntQf(); } catch (Exception exception) { exception.printStackTrace(); paramInt = b; }  } else { paramInt = this.mCarSignalManager.getAmbTRawQly(); }  if (paramInt == 3) { functionStatus = FunctionStatus.active; } else { functionStatus = FunctionStatus.error; }  return functionStatus; } private FunctionStatus getFuelconStatus() { FunctionStatus functionStatus2 = FunctionStatus.notavailable; FunctionStatus functionStatus1 = functionStatus2; try { if (this.mCarSignalManager.getVehModMngtGlbSafe1UsgModSts() != 0) functionStatus1 = FunctionStatus.active;  } catch (Exception exception) { exception.printStackTrace(); functionStatus1 = functionStatus2; }  return functionStatus1; } private FunctionStatus getTireTmANDPreStatus(int paramInt) { // Byte code:
/*      */     //   0: getstatic com/ecarx/xui/adaptapi/FunctionStatus.notavailable : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   3: astore_3
/*      */     //   4: aload_3
/*      */     //   5: astore_2
/*      */     //   6: aload_0
/*      */     //   7: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   10: invokevirtual getcarconfig19 : ()I
/*      */     //   13: iconst_1
/*      */     //   14: if_icmple -> 226
/*      */     //   17: aload_0
/*      */     //   18: iconst_1
/*      */     //   19: newarray int
/*      */     //   21: dup
/*      */     //   22: iconst_0
/*      */     //   23: iconst_0
/*      */     //   24: iastore
/*      */     //   25: invokevirtual carModeAnyMatch : ([I)Z
/*      */     //   28: ifeq -> 222
/*      */     //   31: aload_0
/*      */     //   32: iconst_3
/*      */     //   33: newarray int
/*      */     //   35: dup
/*      */     //   36: iconst_0
/*      */     //   37: bipush #13
/*      */     //   39: iastore
/*      */     //   40: dup
/*      */     //   41: iconst_1
/*      */     //   42: iconst_2
/*      */     //   43: iastore
/*      */     //   44: dup
/*      */     //   45: iconst_2
/*      */     //   46: bipush #11
/*      */     //   48: iastore
/*      */     //   49: invokevirtual usageModeAnyMatch : ([I)Z
/*      */     //   52: ifeq -> 222
/*      */     //   55: iload_1
/*      */     //   56: ldc_w 5243136
/*      */     //   59: if_icmpeq -> 197
/*      */     //   62: iload_1
/*      */     //   63: ldc_w 5244160
/*      */     //   66: if_icmpne -> 72
/*      */     //   69: goto -> 197
/*      */     //   72: iload_1
/*      */     //   73: ldc_w 5243392
/*      */     //   76: if_icmpeq -> 172
/*      */     //   79: iload_1
/*      */     //   80: ldc_w 5244416
/*      */     //   83: if_icmpne -> 89
/*      */     //   86: goto -> 172
/*      */     //   89: iload_1
/*      */     //   90: ldc_w 5243648
/*      */     //   93: if_icmpeq -> 147
/*      */     //   96: iload_1
/*      */     //   97: ldc_w 5244672
/*      */     //   100: if_icmpne -> 106
/*      */     //   103: goto -> 147
/*      */     //   106: iload_1
/*      */     //   107: ldc_w 5243904
/*      */     //   110: if_icmpeq -> 122
/*      */     //   113: aload_3
/*      */     //   114: astore_2
/*      */     //   115: iload_1
/*      */     //   116: ldc_w 5244928
/*      */     //   119: if_icmpne -> 226
/*      */     //   122: aload_0
/*      */     //   123: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   126: invokevirtual getRiReTireMsgPTimeout : ()I
/*      */     //   129: iconst_1
/*      */     //   130: if_icmpne -> 140
/*      */     //   133: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   136: astore_2
/*      */     //   137: goto -> 226
/*      */     //   140: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   143: astore_2
/*      */     //   144: goto -> 226
/*      */     //   147: aload_0
/*      */     //   148: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   151: invokevirtual getLeReTireMsgPTimeout : ()I
/*      */     //   154: iconst_1
/*      */     //   155: if_icmpne -> 165
/*      */     //   158: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   161: astore_2
/*      */     //   162: goto -> 226
/*      */     //   165: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   168: astore_2
/*      */     //   169: goto -> 226
/*      */     //   172: aload_0
/*      */     //   173: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   176: invokevirtual getRiFrntTireMsgPTimeout : ()I
/*      */     //   179: iconst_1
/*      */     //   180: if_icmpne -> 190
/*      */     //   183: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   186: astore_2
/*      */     //   187: goto -> 226
/*      */     //   190: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   193: astore_2
/*      */     //   194: goto -> 226
/*      */     //   197: aload_0
/*      */     //   198: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   201: invokevirtual getLeFrntTireMsgPTimeout : ()I
/*      */     //   204: iconst_1
/*      */     //   205: if_icmpne -> 215
/*      */     //   208: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   211: astore_2
/*      */     //   212: goto -> 226
/*      */     //   215: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   218: astore_2
/*      */     //   219: goto -> 226
/*      */     //   222: getstatic com/ecarx/xui/adaptapi/FunctionStatus.notactive : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   225: astore_2
/*      */     //   226: goto -> 236
/*      */     //   229: astore_2
/*      */     //   230: aload_2
/*      */     //   231: invokevirtual printStackTrace : ()V
/*      */     //   234: aload_3
/*      */     //   235: astore_2
/*      */     //   236: aload_2
/*      */     //   237: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #2119	-> 0
/*      */     //   #2121	-> 4
/*      */     //   #2122	-> 17
/*      */     //   #2124	-> 55
/*      */     //   #2131	-> 72
/*      */     //   #2139	-> 89
/*      */     //   #2146	-> 106
/*      */     //   #2148	-> 122
/*      */     //   #2149	-> 133
/*      */     //   #2151	-> 140
/*      */     //   #2141	-> 147
/*      */     //   #2142	-> 158
/*      */     //   #2144	-> 165
/*      */     //   #2133	-> 172
/*      */     //   #2134	-> 183
/*      */     //   #2136	-> 190
/*      */     //   #2126	-> 197
/*      */     //   #2127	-> 208
/*      */     //   #2129	-> 215
/*      */     //   #2155	-> 222
/*      */     //   #2160	-> 226
/*      */     //   #2158	-> 229
/*      */     //   #2159	-> 230
/*      */     //   #2161	-> 236
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   6	17	229	java/lang/Exception
/*      */     //   17	55	229	java/lang/Exception
/*      */     //   122	133	229	java/lang/Exception
/*      */     //   133	137	229	java/lang/Exception
/*      */     //   140	144	229	java/lang/Exception
/*      */     //   147	158	229	java/lang/Exception
/*      */     //   158	162	229	java/lang/Exception
/*      */     //   165	169	229	java/lang/Exception
/*      */     //   172	183	229	java/lang/Exception
/*      */     //   183	187	229	java/lang/Exception
/*      */     //   190	194	229	java/lang/Exception
/*      */     //   197	208	229	java/lang/Exception
/*      */     //   208	212	229	java/lang/Exception
/*      */     //   215	219	229	java/lang/Exception
/* 3142 */     //   222	226	229	java/lang/Exception } private FunctionStatus getTireFunctionStatus() { FunctionStatus functionStatus2 = FunctionStatus.notavailable; FunctionStatus functionStatus1 = functionStatus2; try { if (this.mCarSignalManager.getcarconfig19() > 1) { CarSignalManager carSignalManager = this.mCarSignalManager; functionStatus1 = functionStatus2; if (carSignalManager.getVehModMngtGlbSafe1UsgModSts() == 13) functionStatus1 = FunctionStatus.active;  }  } catch (Exception exception) { exception.printStackTrace(); functionStatus1 = functionStatus2; }  return functionStatus1; } public ISensorGroup.IMountAngle getMountAngle() { return this.mMountAngle; } public ISensorGroupValue getSensorGroupLatestValue(int paramInt) { ISensorGroupValue iSensorGroupValue = null; long l = SystemClock.elapsedRealtime(); if (paramInt != 8388864) { if (paramInt != 8389120) { if (paramInt != 8389376) { if (paramInt == 8389632) iSensorGroupValue = getGroupSensorValue(8389632, l);  } else { iSensorGroupValue = getGroupSensorValue(8389376, l); }  } else { iSensorGroupValue = getGroupSensorValue(8389120, l); }  } else { iSensorGroupValue = getGroupSensorValue(8388864, l); }  return iSensorGroupValue; } public int getSensorEvent(int paramInt) { int i; Integer integer2; StringBuilder stringBuilder1, stringBuilder3, stringBuilder4; Integer integer4 = Integer.valueOf(-1); byte b = -1; int j = -1; switch (paramInt) { default: integer2 = integer4; i = b; break;case 5259264: integer2 = integer4; try { integer4 = Integer.valueOf(getTPMSStatus()); integer2 = integer4; i = b; break; } catch (Exception exception) { exception.printStackTrace(); }  stringBuilder3 = new StringBuilder(); stringBuilder3.append("getSensorEvent: sensor: "); stringBuilder3.append(paramInt); stringBuilder3.append(" , event: "); stringBuilder3.append(integer2); Log.d("Sensor", stringBuilder3.toString()); return integer2.intValue();case 5249024: j = 30702; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiReTireMsgBattLoSt(); stringBuilder1 = stringBuilder3; break;case 5248768: j = 30620; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeReTireMsgBattLoSt(); stringBuilder1 = stringBuilder3; break;case 5248512: j = 30693; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiFrntTireMsgBattLoSt(); stringBuilder1 = stringBuilder3; break;case 5248256: j = 30611; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeFrntTireMsgBattLoSt(); stringBuilder1 = stringBuilder3; break;case 5248000: j = 30703; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiReTireMsgFastLoseWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5247744: j = 30621; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeReTireMsgFastLoseWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5247488: j = 30694; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiFrntTireMsgFastLoseWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5247232: j = 30612; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeFrntTireMsgFastLoseWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5246976: j = 30709; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiReTireMsgTWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5246720: j = 30627; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeReTireMsgTWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5246464: j = 30700; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiFrntTireMsgTWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5246208: j = 30618; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeFrntTireMsgTWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5245952: j = 30706; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiReTireMsgPWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5245696: j = 30624; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeReTireMsgPWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5245440: j = 30697; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getRiFrntTireMsgPWarnFlg(); stringBuilder1 = stringBuilder3; break;case 5245184: j = 30615; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getLeFrntTireMsgPWarnFlg(); stringBuilder1 = stringBuilder3; break;case 3148544: j = 30922; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getNavActvMenuReq(); stringBuilder1 = stringBuilder3; break;case 3148288: j = 31577; stringBuilder1 = stringBuilder3; i = this.mCarSignalManager.getVehMtnStVehMtnSt(); stringBuilder1 = stringBuilder3; break;case 3148032: stringBuilder1 = stringBuilder3; if (this.mCarSignalManager.getEngCooltIndcnReq() == 9) { i = 3145729; } else { i = 3145728; }  stringBuilder1 = stringBuilder3; integer3 = Integer.valueOf(i); integer1 = integer3; this.mEngCoolantSysWarn = integer3.intValue(); integer1 = integer3; i = b; break;case 3147264: integer1 = integer3; integer3 = Integer.valueOf(getTransMissionSys()); integer1 = integer3; this.mTranSysWarn = integer3.intValue(); integer1 = integer3; i = b; break;case 3147008: integer1 = integer3; integer3 = Integer.valueOf(getHTTWStatus()); integer1 = integer3; i = b; break;case 3146752: j = 31409; integer1 = integer3; i = this.mCarSignalManager.getEngCooltIndcnReq(); integer1 = integer3; break;case 3146496: j = 31414; integer1 = integer3; i = this.mCarSignalManager.getEngOilPWarn(); integer1 = integer3; break;case 3145984: j = 30915; integer1 = integer3; i = this.mCarSignalManager.getFuLvlLoWarn(); integer1 = integer3; break;case 2110464: j = 31265; integer1 = integer3; i = this.mCarSignalManager.getPassSeatSts(); integer1 = integer3; break;case 2107136: j = 33403; integer1 = integer3; i = this.mAirQandFragMgr.getPA_PM25_IntPm25Sts().getData(); integer1 = integer3; break;case 2106880: j = 33404; integer1 = integer3; i = this.mAirQandFragMgr.getPA_PM25_OutdPm25Sts().getData(); integer1 = integer3; break;case 2106624: j = 30449; integer1 = integer3; i = this.mCarSignalManager.getInCarCo2HighWarn(); integer1 = integer3; break;case 2106112: j = 33396; integer1 = integer3; i = this.mAirQandFragMgr.getPA_IAQC_ActnSts().getData(); integer1 = integer3; break;case 2105856: j = 33400; integer1 = integer3; i = this.mAirQandFragMgr.getPA_PM25_IntPm25Lvl().getData(); integer1 = integer3; break;case 2105600: j = 33401; integer1 = integer3; i = this.mAirQandFragMgr.getPA_PM25_OutdPm25Lvl().getData(); integer1 = integer3; break;case 2102272: j = 30779; integer1 = integer3; i = this.mCarSignalManager.getVehModMngtGlbSafe1CarModSts1(); integer1 = integer3; break;case 2102016: j = 31274; integer1 = integer3; i = this.mCarSignalManager.getBltLockStAtPassBltLockSt1(); integer1 = integer3; break;case 2101760: j = 31272; integer1 = integer3; i = this.mCarSignalManager.getBltLockStAtDrvrBltLockSt1(); integer1 = integer3; break;case 2101248: integer1 = integer3; i = this.mBrightnessManager.getAutoDayNightMode(); integer1 = integer3; stringBuilder4 = new StringBuilder(); integer1 = integer3; this(); integer1 = integer3; stringBuilder4.append("获取总线上日夜模式:"); integer1 = integer3; stringBuilder4.append(i); integer1 = integer3; Log.d("Sensor", stringBuilder4.toString()); integer1 = integer3; return convertDayNightModeToEvent(i);case 2098432: integer1 = integer3; integer3 = Integer.valueOf(getCoolAntLvl(this.mCarSignalManager.getEngCooltIndcnReq())); integer1 = integer3; this.mCoolAntLvl = integer3.intValue(); integer1 = integer3; i = b; break;case 2098176: j = 31413; integer1 = integer3; i = this.mCarSignalManager.getEngOilLvlSts(); integer1 = integer3; break;case 2097664: integer1 = integer3; integer3 = Integer.valueOf(getGera()); integer1 = integer3; this.mGear = integer3.intValue(); integer1 = integer3; i = b; break;case 2097408: j = 30788; integer1 = integer3; i = this.mCarSignalManager.getVehModMngtGlbSafe1UsgModSts(); integer1 = integer3; break; }  Integer integer3 = integer1; if (j != -1) { integer3 = integer1; if (i != -1) { i = getSensorEventFromSigVlu(j, i); integer3 = Integer.valueOf(i); }  }  Integer integer1 = integer3; StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append("getSensorEvent: sensor: "); stringBuilder2.append(paramInt); stringBuilder2.append(" , event: "); stringBuilder2.append(integer1); Log.d("Sensor", stringBuilder2.toString()); return integer1.intValue(); } private int getCoolAntLvl(int paramInt) { int i = 2098433; switch (paramInt) { default: paramInt = i; return paramInt;case 7: case 8: case 9: paramInt = 2098434; return paramInt;case 5: case 6: break; }  paramInt = 2098435; return paramInt; } private int getTransMissionSys() { int i, j = 3145728; try { int k = this.mCarSignalManager.getVehNotifAndLedFltStsByte0(); int n = this.mCarSignalManager.getVehNotifAndLedFltStsByte1(); int m = this.mCarSignalManager.getVehNotifAndLedFltStsByte2(); i = this.mCarSignalManager.getVehNotifAndLedFltStsByte3(); int i1 = this.mCarSignalManager.getVehNotifAndLedFltStsByte6(); if (k == 1 && (n & 0x20) == 32) { i = 3145730; } else if (k == 1 && (m & 0x8) == 8) { i = 3145730; } else if (k == 1 && (n & 0x40) == 64) { i = 3145731; } else if (k == 5 && (i1 & 0x8) == 8) { i = 3145730; } else if (k == 1 && (n & 0x80) == 128) { i = 3145731; } else if (k == 5 && (i1 & 0x10) == 16) { i = 3145730; } else if (k == 1 && (m & 0x20) == 32) { i = 3145730; } else if (k == 5 && (i1 & 0x20) == 32) { i = 3145730; } else if (k == 5 && (i1 & 0x40) == 64) { i = 3145730; } else if (k == 1 && (m & 0x40) == 64) { i = 3145730; } else if (k == 1 && (m & 0x80) == 128) { i = 3145730; } else if (k == 1 && (i & 0x1) == 1) { i = 3145730; } else if (k == 1 && (i & 0x2) == 2) { i = 3145730; } else if (k == 1 && (m & 0x1) == 1) { i = 3145730; } else if (k == 1 && (i & 0x4) == 4) { i = 3145730; } else if (k == 1 && (m & 0x2) == 2) { i = 3145730; } else { i = j; if (k == 1) { i = j; if ((m & 0x4) == 4) i = 3145730;  }  }  } catch (Exception exception) { exception.printStackTrace(); i = j; }  return i; } public float getSensorLatestValue(int paramInt) { int j; CarSignalManager carSignalManager; float f3 = Float.MIN_VALUE, f2 = Float.MIN_VALUE; byte b = -1; int i = -1; switch (paramInt) { default: f1 = f3; paramInt = b; break;case 5244928: paramInt = 30708; f1 = f2; try { i = this.mCarSignalManager.getRiReTireMsgT(); f1 = f3; break; } catch (Exception exception) { exception.printStackTrace(); }  return f1;case 5244672: paramInt = 30626; f1 = f2; i = this.mCarSignalManager.getLeReTireMsgT(); f1 = f3; break;case 5244416: paramInt = 30699; f1 = f2; i = this.mCarSignalManager.getRiFrntTireMsgT(); f1 = f3; break;case 5244160: paramInt = 30617; f1 = f2; i = this.mCarSignalManager.getLeFrntTireMsgT(); f1 = f3; break;case 5243904: paramInt = 30705; f1 = f2; i = this.mCarSignalManager.getRiReTireMsgP(); f1 = f3; break;case 5243648: paramInt = 30623; f1 = f2; i = this.mCarSignalManager.getLeReTireMsgP(); f1 = f3; break;case 5243392: paramInt = 30696; f1 = f2; i = this.mCarSignalManager.getRiFrntTireMsgP(); f1 = f3; break;case 5243136: paramInt = 30614; f1 = f2; i = this.mCarSignalManager.getLeFrntTireMsgP(); f1 = f3; break;case 4211968: paramInt = 30925; f1 = f2; i = this.mCarSignalManager.getPercOfFuLvlIndcn(); f1 = f3; break;case 4210688: paramInt = 33799; f1 = f2; i = this.mVehchargMgr.getPA_VehCharg_DispHvBattLvlOfChrg().getData(); f1 = f3; break;case 4206848: paramInt = 30901; f1 = f2; i = this.mCarSignalManager.getDayToSrv(); f1 = f3; break;case 4206592: paramInt = 30906; f1 = f2; i = this.mCarSignalManager.getDstToSrv(); f1 = f3; break;case 4195072: f1 = f2; f2 = this.mSingFuelCon; f1 = f2; paramInt = b; break;case 4194816: paramInt = 30961; f1 = f2; i = this.mCarSignalManager.getFuCnsIndcdVal(); f1 = f3; break;case 4194560: f1 = f2; f2 = this.mAverFuelCon; f1 = f2; paramInt = b; break;case 1055232: f1 = f2; paramInt = this.mCarSignalManager.getVehSpdIndcdVehSpdIndcd(); f1 = f2; j = this.mCarSignalManager.getVehSpdIndcdVeSpdIndcdUnit(); f1 = f2; f1 = f2 = getDIMSpd(paramInt, j); paramInt = b; break;case 1054976: paramInt = 30954; f1 = f2; i = this.mCarSignalManager.getDstEstimdToEmptyForDrvgElecIndcdDstToEmpty(); f1 = f3; break;case 1054720: paramInt = 30956; f1 = f2; i = this.mCarSignalManager.getDstToEmptyIndcdDstToEmpty(); f1 = f3; break;case 1053184: paramInt = 31573; f1 = f2; i = this.mCarSignalManager.getVehMNomVehM(); f1 = f3; break;case 1052928: paramInt = 31550; f1 = f2; i = this.mCarSignalManager.getSteerWhlSnsrAgSpd(); f1 = f3; break;case 1052672: paramInt = 31549; f1 = f2; i = this.mCarSignalManager.getSteerWhlSnsrAg(); f1 = f3; break;case 1052160: paramInt = 30482; f1 = f2; i = this.mCarSignalManager.getRainfallAmnt(); f1 = f3; break;case 1051648: paramInt = 30536; f1 = f2; i = this.mCarSignalManager.getCmptmtTFrntCmptmtTFrnt(); f1 = f3; break;case 1051392: paramInt = 30532; f1 = f2; i = this.mCarSignalManager.getAmbTRawAmbTVal(); f1 = f3; break;case 1050880: paramInt = 31415; f1 = f2; i = this.mCarSignalManager.getEngSpdDispd(); f1 = f3; break;case 1050624: f1 = f2; j = this.mCarSignalManager.getDstToEmptyIndcdDstToEmpty(); f1 = f2; carSignalManager = this.mCarSignalManager; f1 = f2; paramInt = carSignalManager.getDstEstimdToEmptyForDrvgElecIndcdDstToEmpty(); f1 = (j + paramInt); paramInt = b; break;case 1050368: paramInt = 30889; f1 = f2; i = this.mCarSignalManager.getBkpOfDstTrvld(); f1 = f3; break;case 1050112: paramInt = 30962; f1 = f2; i = this.mCarSignalManager.getFuLvlIndcdFuLvlValFromFuTbl(); f1 = f3; break;case 1049344: paramInt = 33398; f1 = f2; i = this.mAirQandFragMgr.getPA_PM25_IntPm25Vlu().getData(); f1 = f3; break;case 1049088: paramInt = 33399; f1 = f2; i = this.mAirQandFragMgr.getPA_PM25_OutdPm25Vlu().getData(); f1 = f3; break;case 1048832: paramInt = 31578; f1 = f2; i = this.mCarSignalManager.getVehSpdLgtA(); f1 = f3; break; }  f2 = f1; if (paramInt != -1) { f2 = f1; if (i != -1) f2 = getSensorVluFromSigVlu(paramInt, i).floatValue();  }  float f1 = f2; return f1; } private float getDIMSpd(int paramInt1, int paramInt2) { float f = Float.MIN_VALUE; if (paramInt2 == 0) { f = (float)(paramInt1 * 0.2778D); } else if (paramInt2 == 1) { f = (float)(paramInt1 * 0.2778D / 0.6214D); }  return f; } public boolean registerListener(ISensor.ISensorListener paramISensorListener, int paramInt) { return registerListener(paramISensorListener, paramInt, 3); } public boolean registerListener(ISensor.ISensorListener paramISensorListener, int paramInt1, int paramInt2) { boolean bool2 = true; null = true; boolean bool1 = true; int i = getSensorType(paramInt1); if (i == 0) { bool1 = false; } else { this.mSensorStatus.put(Integer.valueOf(paramInt1), isSensorSupportedForSelf(paramInt1)); if (i == 2) { List<ISensor.ISensorListener> list = this.mSensorListenerMap.get(Integer.valueOf(paramInt1)); if (list != null) { if (!list.contains(paramISensorListener)) { list.add(paramISensorListener); addLocalSignalFilter(Integer.valueOf(paramInt1)); bool1 = bool2; } else { Log.e("Sensor", "sensor has been listened"); bool1 = false; }  } else { list = new ArrayList<>(); list.add(paramISensorListener); addLocalSignalFilter(Integer.valueOf(paramInt1)); this.mSensorListenerMap.put(Integer.valueOf(paramInt1), list); bool1 = bool2; }  } else if (i == 1 || i == 3) { boolean bool4; if (i == 1 && this.mContinuousSensorValueMap.get(Integer.valueOf(paramInt1)) == null) this.mContinuousSensorValueMap.put(Integer.valueOf(paramInt1), Float.valueOf(getSensorLatestValue(paramInt1)));  byte b = 0; if (i == 3 && !(paramISensorListener instanceof ISensorGroup.ISensorGroupListener)) { Log.e("Sensor", "error listener, should be ISensorGroupListener"); return false; }  boolean bool3 = false; if ((i == 1 || paramInt1 == 8389376) && paramInt2 == 0) paramInt2 = 1;  while (true) { Iterator<Integer> iterator = ((List)this.mRateOfSensorArray.valueAt(b)).iterator(); while (true) { bool1 = null; bool4 = bool3; if (iterator.hasNext()) { Integer integer = iterator.next(); if (integer.intValue() == paramInt1) { bool4 = true; if (this.mRateOfSensorArray.keyAt(b) == paramInt2) { ((List<ISensor.ISensorListener>)this.mSensorListenerMap.get(integer)).add(paramISensorListener); bool1 = null; break; }  Log.e("Sensor", "The same sensor must have same rate."); bool1 = false; break; }  continue; }  break; }  b++; if (b < this.mRateOfSensorArray.size()) { null = bool1; bool3 = bool4; if (bool4) break;  continue; }  break; }  null = bool1; if (!bool4) { List<Integer> list = (List)this.mRateOfSensorArray.get(paramInt2); if (list != null) { list.add(Integer.valueOf(paramInt1)); ArrayList<ISensor.ISensorListener> arrayList = new ArrayList(); arrayList.add(paramISensorListener); this.mSensorListenerMap.put(Integer.valueOf(paramInt1), arrayList); if (i == 1) addLocalSignalFilter(Integer.valueOf(paramInt1));  if (paramInt1 == 8388864 && this.mGyroSensor == null) registerGyroListener();  if (paramInt1 == 8389120 && this.mAcceSensor == null) registerAcceListener();  if (paramInt1 == 8389632) this.mW4mUpdateTime = getCallbackPeriod(paramInt2);  if (bool1 && list.size() == 1 && !this.mCallbackThreadofRateStatus.get(paramInt2)) { this.mCallbackThreadofRateStatus.put(paramInt2, true); paramInt1 = getCallbackPeriod(paramInt2); this.scheduledService.scheduleAtFixedRate(new CallbackScheduled(paramInt2), 0L, paramInt1, TimeUnit.MILLISECONDS); }  null = bool1; } else { null = false; Log.e("Sensor", "param \"rate\" is not available"); }  }  return null; }  }  return bool1; } private int getCallbackPeriod(int paramInt) { char c = 'È'; if (paramInt != 16) { switch (paramInt) { default: paramInt = c; return paramInt;case 5: paramInt = 1000; return paramInt;case 4: paramInt = 500; return paramInt;case 3: paramInt = 200; return paramInt;case 2: paramInt = 60; return paramInt;case 1: paramInt = 10; return paramInt;case 0: break; }  paramInt = 5; } else { paramInt = 100; }  return paramInt; } public void unregisterListener(ISensor.ISensorListener paramISensorListener) { for (Map.Entry<Integer, List<ISensor.ISensorListener>> entry : this.mSensorListenerMap.entrySet()) { List list = (List)entry.getValue(); list.remove(paramISensorListener); if (list.size() == 0) { int i = ((Integer)entry.getKey()).intValue(); int j = getSensorType(i); if (j == 1 || j == 3) { int k = 0; while (true) { for (Integer integer : this.mRateOfSensorArray.valueAt(k)) { if (integer.intValue() == i) { ((List)this.mRateOfSensorArray.valueAt(k)).remove(integer); break; }  }  int m = k + 1; k = m; if (m >= this.mRateOfSensorArray.size()) { if (i == 8388864) { this.mSensorManager.unregisterListener(this.mGyroSensorEventListener, this.mGyroSensor); try { this.mSensorTmpService.unregisterListener(this.mSensorTmperListener); } catch (RemoteException remoteException) { remoteException.printStackTrace(); }  continue; }  if (i == 8389120) { this.mSensorManager.unregisterListener(this.mAcceSensorEventListener, this.mAcceSensor); continue; }  break; }  }  if (j == 1) this.mContinuousSensorValueMap.remove(Integer.valueOf(i));  continue; }  if (j == getSensorType(2)) this.mEventSensorValueMap.remove(Integer.valueOf(i));  }  }  } private void callSensorSupportChanged(int paramInt1, int paramInt2, PATypes.PA_IntBase paramPA_IntBase) { recordPADate(paramInt2, paramPA_IntBase);
/* 3143 */     List list = this.mSensorListenerMap.get(Integer.valueOf(paramInt1));
/* 3144 */     if (list != null) {
/* 3145 */       for (ISensor.ISensorListener iSensorListener : list) {
/*      */         
/*      */         try {
/* 3148 */           FunctionStatus functionStatus = SignalUtils.convertToFunctionStatus(paramPA_IntBase.getAvailability()); iSensorListener.onSensorSupportChanged(paramInt1, functionStatus);
/* 3149 */         } catch (Exception exception) {
/* 3150 */           exception.printStackTrace();
/*      */         } 
/*      */       } 
/*      */     } }
/*      */ 
/*      */   
/*      */   private int getTPMSStatus() {
/* 3157 */     int j = 5259265;
/* 3158 */     ArrayList<Integer> arrayList = new ArrayList();
/*      */     try {
/* 3160 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeFrntTireMsgSysWarnFlg()));
/* 3161 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeReTireMsgSysWarnFlg()));
/* 3162 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiFrntTireMsgSysWarnFlg()));
/* 3163 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiReTireMsgSysWarnFlg()));
/* 3164 */     } catch (Exception exception) {
/* 3165 */       exception.printStackTrace();
/*      */     } 
/* 3167 */     int[] arrayOfInt = new int[2]; int i; byte b;
/* 3168 */     for (b = 0, i = 0; i < arrayList.size(); i++) {
/* 3169 */       if (((Integer)arrayList.get(i)).intValue() == 0) {
/* 3170 */         arrayOfInt[0] = arrayOfInt[0] + 1;
/*      */       } else {
/* 3172 */         arrayOfInt[1] = arrayOfInt[1] + 1;
/*      */       } 
/*      */     } 
/* 3175 */     if (arrayOfInt[1] > 1)
/* 3176 */     { i = 5259266; }
/*      */     else { while (true) {
/* 3178 */         i = j; if (b < arrayList.size()) {
/* 3179 */           if (((Integer)arrayList.get(b)).intValue() == 1) {
/* 3180 */             switch (b) { default: i = j;
/*      */                 break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 3:
/* 3191 */                 i = 5259270;
/*      */                 break;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 2:
/*      */                 i = 5259268;
/*      */                 break;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 1:
/*      */                 i = 5259269;
/*      */                 break;
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 0:
/*      */                 break; }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             i = 5259267;
/*      */             break;
/*      */           } 
/*      */           b++;
/*      */           continue;
/*      */         } 
/*      */         break;
/*      */       }  }
/*      */     
/* 3226 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   private int getGera() {
/* 3231 */     int j, i = -1;
/* 3232 */     int k = -1;
/*      */     
/* 3234 */     try { j = this.mCarSignalManager.getGearLvrIndcn();
/* 3235 */       i = j; int m = this.mCarSignalManager.getGearIndcnRecGearIndcn();
/*      */ 
/*      */       
/* 3238 */       k = j; j = i; } catch (Exception exception) { exception.printStackTrace(); j = k; k = i; }
/* 3239 */      switch (k)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 3256 */         i = getManMod(j);
/*      */ 
/*      */         
/* 3259 */         return i;case 4: i = getManMod(j); return i;case 3: i = 2097696; return i;case 2: i = 2097680; return i;case 1: i = 2097728; return i;case 0: break; }  i = 2097712; return i;
/*      */   }
/*      */   
/*      */   private int getManMod(int paramInt) {
/* 3263 */     int i = -1;
/*      */     try {
/* 3265 */       int j = this.mCarSignalManager.getcarconfig10();
/* 3266 */     } catch (Exception exception) {
/* 3267 */       exception.printStackTrace();
/*      */     } 
/*      */     
/* 3270 */     byte b = -1;
/* 3271 */     switch (paramInt) { default: paramInt = b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3315 */         return paramInt;case 15: paramInt = b; if (i == 1) paramInt = 2097728;  return paramInt;case 14: paramInt = b; if (i == 1) paramInt = 2097680;  return paramInt;case 10: paramInt = 2097674; return paramInt;case 9: paramInt = 2097673; return paramInt;case 8: paramInt = 2097672; return paramInt;case 7: paramInt = 2097671; return paramInt;case 6: paramInt = 2097670; return paramInt;case 5: paramInt = 2097669; return paramInt;case 4: paramInt = 2097668; return paramInt;case 3: paramInt = 2097667; return paramInt;case 2: paramInt = 2097666; return paramInt;case 1: break; }  paramInt = 2097665; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private ISensorGroupValue getGroupSensorValue(int paramInt, long paramLong) {
/* 3320 */     if (paramInt == 8388864)
/* 3321 */     { if (this.mGyroSensorEvent != null) {
/* 3322 */         this.mGyroValue = new SensorGroupValue.GyroValue(this.mGyroSensorEvent, (int)(paramLong - this.mGyroPreCallbackTime), paramLong, this.mTemper);
/*      */         
/* 3324 */         this.mGyroPreCallbackTime = paramLong;
/* 3325 */         return this.mGyroValue;
/*      */       }  }
/* 3327 */     else if (paramInt == 8389120)
/* 3328 */     { if (this.mAcceSensorEvent != null) {
/* 3329 */         this.mAcceValue = new SensorGroupValue.Acc3dValue(this.mAcceSensorEvent, (int)(paramLong - this.mAccePreCallbackTime), paramLong);
/*      */         
/* 3331 */         this.mAccePreCallbackTime = paramLong;
/* 3332 */         return this.mAcceValue;
/*      */       }  }
/* 3334 */     else { ISensorGroupValue iSensorGroupValue; if (paramInt == 8389376)
/* 3335 */       { float f = this.mVehicleSpeed;
/* 3336 */         if (this.mGearState == 0) {
/* 3337 */           f = 0.0F - this.mVehicleSpeed;
/*      */         }
/* 3339 */         this.mPluseValue = new SensorGroupValue.SpeedPulseValue((int)(paramLong - this.mPulsePreCallbackTime), paramLong, f);
/*      */         
/* 3341 */         this.mPulsePreCallbackTime = paramLong;
/* 3342 */         iSensorGroupValue = this.mPluseValue; }
/* 3343 */       else { if (paramInt == 8389632) {
/* 3344 */           this.mW4mValue = new SensorGroupValue.W4mValue(this.mVRL, this.mVRR, this.mVFL, this.mVFR, this.mSteerAngle, this.mYawRate, this.mLonAcc, this.mLatAcc, this.mGearState, (int)this.mW4mUpdateTime, paramLong);
/*      */ 
/*      */           
/* 3347 */           return this.mW4mValue;
/*      */         } 
/*      */         
/* 3350 */         iSensorGroupValue = null; }  return iSensorGroupValue; }  Object object = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class AutoDayModeReceiver
/*      */     extends IPowerStatusListener.Stub
/*      */   {
/*      */     final Sensor this$0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onStatusChanged(int param1Int1, int param1Int2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onDayNightChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onBrightnessModeChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onDayBrightnessChanged(int param1Int1, int param1Int2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onNightBrightnessChanged(int param1Int1, int param1Int2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onVehicleBrightnessChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onSettingManagerReady(int param1Int) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onDayNightModeChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onManualDayNightModeChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void onAutoDayNightModeChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void onCustomDayTimeChanged(float param1Float) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void onCustomNightTimeChanged(float param1Float) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void onScreenSaverStyleChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void onScreenSaverNameChanged(String param1String) {}
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int convertDayNightModeToEvent(int paramInt) {
/* 3430 */     switch (paramInt)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 3438 */         paramInt = 2101249;
/*      */ 
/*      */         
/* 3441 */         return paramInt;case 1: paramInt = 2101249; return paramInt;case 0: break; }  paramInt = 2101250; return paramInt;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\Sensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */