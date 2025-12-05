/*     */ package android.car.hardware;
/*     */ 
/*     */ import android.car.CarApiUtil;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.car.hardware.property.CarPropertyManager;
/*     */ import android.content.Context;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.util.ArraySet;
/*     */ import android.util.Log;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CarSensorManager
/*     */   implements CarManagerBase
/*     */ {
/* 207 */   private final ArraySet<Integer> mSensorConfigIds = new ArraySet(Arrays.asList(new Integer[] { Integer.valueOf(291504647), Integer.valueOf(291504901), Integer.valueOf(291504644), Integer.valueOf(291504903), Integer.valueOf(287310850), Integer.valueOf(289408000), Integer.valueOf(287310855), Integer.valueOf(291505923), Integer.valueOf(289408009), Integer.valueOf(290521862), Integer.valueOf(287310858), Integer.valueOf(287310859), Integer.valueOf(287310600), Integer.valueOf(291504905), Integer.valueOf(287310602), Integer.valueOf(287310603), Integer.valueOf(291504908), Integer.valueOf(289407747) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 245 */   private CarPropertyEventListenerToBase mCarPropertyEventListener = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 250 */   private final HashMap<OnSensorChangedListener, CarPropertyEventListenerToBase> mListenerMap = new HashMap<>(); private static final boolean DBG = false; private static final int INDEX_WHEEL_DISTANCE_ENABLE_FLAG = 0; private static final int INDEX_WHEEL_DISTANCE_FRONT_LEFT = 1; private static final int INDEX_WHEEL_DISTANCE_FRONT_RIGHT = 2; private static final int INDEX_WHEEL_DISTANCE_REAR_LEFT = 4; private static final int INDEX_WHEEL_DISTANCE_REAR_RIGHT = 3; public static final int SENSOR_RATE_FAST = 10; public static final int SENSOR_RATE_FASTEST = 100; public static final int SENSOR_RATE_NORMAL = 1; public static final int SENSOR_RATE_UI = 5; public static final int SENSOR_TYPE_ABS_ACTIVE = 287310858; public static final int SENSOR_TYPE_CAR_SPEED = 291504647; public static final int SENSOR_TYPE_ENGINE_OIL_LEVEL = 289407747; public static final int SENSOR_TYPE_ENV_OUTSIDE_TEMPERATURE = 291505923; public static final int SENSOR_TYPE_EV_BATTERY_CHARGE_RATE = 291504908; public static final int SENSOR_TYPE_EV_BATTERY_LEVEL = 291504905; public static final int SENSOR_TYPE_EV_CHARGE_PORT_CONNECTED = 287310603; public static final int SENSOR_TYPE_EV_CHARGE_PORT_OPEN = 287310602; public static final int SENSOR_TYPE_FUEL_DOOR_OPEN = 287310600; public static final int SENSOR_TYPE_FUEL_LEVEL = 291504903; public static final int SENSOR_TYPE_GEAR = 289408000; public static final int SENSOR_TYPE_IGNITION_STATE = 289408009; public static final int SENSOR_TYPE_NIGHT = 287310855; public static final int SENSOR_TYPE_ODOMETER = 291504644; public static final int SENSOR_TYPE_PARKING_BRAKE = 287310850; public static final int SENSOR_TYPE_RESERVED1 = 1; public static final int SENSOR_TYPE_RESERVED10 = 10; public static final int SENSOR_TYPE_RESERVED11 = 11; public static final int SENSOR_TYPE_RESERVED12 = 12; public static final int SENSOR_TYPE_RESERVED13 = 13; public static final int SENSOR_TYPE_RESERVED14 = 14; public static final int SENSOR_TYPE_RESERVED15 = 15;
/*     */   public static final int SENSOR_TYPE_RESERVED16 = 16;
/*     */   public static final int SENSOR_TYPE_RESERVED17 = 17;
/*     */   public static final int SENSOR_TYPE_RESERVED18 = 18;
/*     */   public static final int SENSOR_TYPE_RESERVED19 = 19;
/*     */   public static final int SENSOR_TYPE_RESERVED20 = 20;
/*     */   public static final int SENSOR_TYPE_RESERVED21 = 21;
/*     */   public static final int SENSOR_TYPE_RESERVED26 = 26;
/*     */   public static final int SENSOR_TYPE_RESERVED8 = 8;
/*     */   public static final int SENSOR_TYPE_RPM = 291504901;
/*     */   public static final int SENSOR_TYPE_TRACTION_CONTROL_ACTIVE = 287310859;
/*     */   public static final int SENSOR_TYPE_WHEEL_TICK_DISTANCE = 290521862;
/*     */   private static final String TAG = "CarSensorManager";
/*     */   private static final int WHEEL_TICK_DISTANCE_BUNDLE_SIZE = 6;
/*     */   private final CarPropertyManager mCarPropertyMgr;
/*     */   
/*     */   private static class CarPropertyEventListenerToBase implements CarPropertyManager.CarPropertyEventListener { private final CarSensorManager.OnSensorChangedListener mListener;
/*     */     
/*     */     CarPropertyEventListenerToBase(CarSensorManager param1CarSensorManager, CarSensorManager.OnSensorChangedListener param1OnSensorChangedListener) {
/* 269 */       this.mManager = new WeakReference<>(param1CarSensorManager);
/* 270 */       this.mListener = param1OnSensorChangedListener;
/*     */     }
/*     */     private final WeakReference<CarSensorManager> mManager;
/*     */     
/*     */     public void onChangeEvent(CarPropertyValue param1CarPropertyValue) {
/* 275 */       CarSensorManager carSensorManager = this.mManager.get();
/* 276 */       if (carSensorManager != null) {
/* 277 */         carSensorManager.handleOnChangeEvent(param1CarPropertyValue, this.mListener);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onErrorEvent(int param1Int1, int param1Int2) {} }
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleOnChangeEvent(CarPropertyValue paramCarPropertyValue, OnSensorChangedListener paramOnSensorChangedListener) {
/* 288 */     synchronized (this.mListenerMap) {
/* 289 */       CarSensorEvent carSensorEvent = createCarSensorEvent(paramCarPropertyValue);
/* 290 */       paramOnSensorChangedListener.onSensorChanged(carSensorEvent);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleOnErrorEvent(int paramInt1, int paramInt2) {}
/*     */   
/*     */   public CarSensorManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/* 299 */     this.mCarPropertyMgr = new CarPropertyManager(paramIBinder, paramHandler, false, "CarSensorManager");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 305 */     synchronized (this.mListenerMap) {
/* 306 */       this.mListenerMap.clear();
/*     */       
/* 308 */       this.mCarPropertyMgr.onCarDisconnected();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getSupportedSensors() throws CarNotConnectedException {
/*     */     try {
/* 318 */       List<CarPropertyConfig> list = getPropertyList();
/* 319 */       int[] arrayOfInt = new int[list.size()];
/* 320 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/* 321 */         arrayOfInt[b] = ((CarPropertyConfig)list.get(b)).getPropertyId();
/*     */       }
/* 323 */       return arrayOfInt;
/* 324 */     } catch (IllegalStateException illegalStateException) {
/* 325 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */       
/* 327 */       return new int[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CarPropertyConfig> getPropertyList() throws CarNotConnectedException {
/* 336 */     return this.mCarPropertyMgr.getPropertyList(this.mSensorConfigIds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSensorSupported(int paramInt) throws CarNotConnectedException {
/* 346 */     for (int i : getSupportedSensors()) {
/*     */       
/* 348 */       if (paramInt == i) {
/* 349 */         return true;
/*     */       }
/*     */     } 
/* 352 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSensorSupported(int[] paramArrayOfint, int paramInt) {
/*     */     byte b;
/*     */     int i;
/* 362 */     for (i = paramArrayOfint.length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/* 363 */       if (paramInt == j)
/* 364 */         return true; 
/*     */       b++; }
/*     */     
/* 367 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerListener(OnSensorChangedListener paramOnSensorChangedListener, int paramInt1, int paramInt2) throws CarNotConnectedException, IllegalArgumentException {
/* 402 */     if (paramInt2 == 100 || paramInt2 == 1 || paramInt2 == 5 || paramInt2 == 10) {
/*     */ 
/*     */ 
/*     */       
/* 406 */       if (this.mListenerMap.get(paramOnSensorChangedListener) == null) {
/* 407 */         this.mCarPropertyEventListener = new CarPropertyEventListenerToBase(this, paramOnSensorChangedListener);
/*     */       } else {
/* 409 */         this.mCarPropertyEventListener = this.mListenerMap.get(paramOnSensorChangedListener);
/*     */       } 
/* 411 */       if (this.mCarPropertyMgr.registerListener(this.mCarPropertyEventListener, paramInt1, paramInt2)) {
/* 412 */         this.mListenerMap.put(paramOnSensorChangedListener, this.mCarPropertyEventListener);
/* 413 */         return true;
/*     */       } 
/* 415 */       return false;
/*     */     } 
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("wrong rate ");
/*     */     stringBuilder.append(paramInt2);
/*     */     throw new IllegalArgumentException(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterListener(OnSensorChangedListener paramOnSensorChangedListener) {
/* 426 */     synchronized (this.mListenerMap) {
/* 427 */       this.mCarPropertyEventListener = this.mListenerMap.get(paramOnSensorChangedListener);
/* 428 */       this.mCarPropertyMgr.unregisterListener(this.mCarPropertyEventListener);
/* 429 */       this.mListenerMap.remove(paramOnSensorChangedListener);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterListener(OnSensorChangedListener paramOnSensorChangedListener, int paramInt) {
/* 440 */     synchronized (this.mListenerMap) {
/* 441 */       this.mCarPropertyEventListener = this.mListenerMap.get(paramOnSensorChangedListener);
/*     */       
/* 443 */       this.mCarPropertyMgr.unregisterListener(this.mCarPropertyEventListener, paramInt);
/*     */       return;
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
/*     */   public CarSensorEvent getLatestSensorEvent(int paramInt) throws CarNotConnectedException {
/*     */     try {
/* 457 */       CarPropertyValue carPropertyValue = this.mCarPropertyMgr.getProperty(paramInt, 0);
/* 458 */       return createCarSensorEvent(carPropertyValue);
/* 459 */     } catch (IllegalStateException illegalStateException) {
/* 460 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */       
/* 462 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void handleCarServiceRemoteExceptionAndThrow(RemoteException paramRemoteException) throws CarNotConnectedException {
/* 467 */     if (Log.isLoggable("CAR.L.SENSOR", 4)) {
/* 468 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("RemoteException from car service:"); stringBuilder.append(paramRemoteException.getMessage()); Log.i("CAR.L.SENSOR", stringBuilder.toString());
/*     */     } 
/* 470 */     throw new CarNotConnectedException();
/*     */   }
/*     */   private CarSensorEvent createCarSensorEvent(CarPropertyValue paramCarPropertyValue) {
/*     */     CarSensorEvent carSensorEvent;
/* 474 */     String str = null;
/* 475 */     int j = paramCarPropertyValue.getPropertyId() & 0xFF0000, i = 0; if (j != 2097152) { if (j != 4194304) { if (j != 5308416) { String str1; if (j != 6291456)
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 500 */             StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("unhandled VehiclePropertyType for propId=");
/* 501 */             stringBuilder.append(paramCarPropertyValue.getPropertyId()); str1 = stringBuilder.toString(); Log.e("CarSensorManager", str1); str1 = str; } else { i = str1.getPropertyId(); CarSensorEvent carSensorEvent1 = new CarSensorEvent(i, str1.getTimestamp(), 1, 0, 0); carSensorEvent1.floatValues[0] = ((Float)str1.getValue()).floatValue(); carSensorEvent = carSensorEvent1; }  } else { Object[] arrayOfObject = carSensorEvent.getValue(); j = carSensorEvent.getPropertyId(); carSensorEvent = new CarSensorEvent(j, carSensorEvent.getTimestamp(), 0, 0, arrayOfObject.length); for (; i < arrayOfObject.length; i++)
/*     */             carSensorEvent.longValues[i] = ((Long)arrayOfObject[i]).longValue();  }  } else { i = carSensorEvent.getPropertyId(); CarSensorEvent carSensorEvent1 = new CarSensorEvent(i, carSensorEvent.getTimestamp(), 0, 1, 0); carSensorEvent1.intValues[0] = ((Integer)carSensorEvent.getValue()).intValue(); carSensorEvent = carSensorEvent1; }  }
/*     */     else { i = carSensorEvent.getPropertyId(); CarSensorEvent carSensorEvent1 = new CarSensorEvent(i, carSensorEvent.getTimestamp(), 0, 1, 0); carSensorEvent1.intValues[0] = ((Boolean)carSensorEvent.getValue()).booleanValue(); carSensorEvent = carSensorEvent1; }
/* 504 */      return carSensorEvent;
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
/*     */   public CarSensorConfig getSensorConfig(int paramInt) throws CarNotConnectedException {
/*     */     Bundle bundle;
/* 520 */     List list = null;
/* 521 */     if (paramInt != 290521862)
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
/* 532 */       bundle = Bundle.EMPTY; } else { List list1 = this.mCarPropertyMgr.getPropertyList(); Iterator<CarPropertyConfig> iterator = list1.iterator(); while (true) { list1 = list; if (iterator.hasNext()) { CarPropertyConfig carPropertyConfig = iterator.next(); if (carPropertyConfig.getPropertyId() == paramInt) { bundle = createWheelDistanceTickBundle(carPropertyConfig.getConfigArray()); break; }  continue; }
/*     */          break; }
/*     */        }
/* 535 */      return new CarSensorConfig(paramInt, bundle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Bundle createWheelDistanceTickBundle(List<Integer> paramList) {
/* 546 */     Bundle bundle = new Bundle(6);
/*     */     
/* 548 */     int i = ((Integer)paramList.get(0)).intValue();
/*     */     bundle.putInt("android.car.wheelTickDistanceSupportedWheels", i);
/* 550 */     i = ((Integer)paramList.get(1)).intValue();
/*     */     bundle.putInt("android.car.wheelTickDistanceFrontLeftUmPerTick", i);
/* 552 */     i = ((Integer)paramList.get(2)).intValue();
/*     */     bundle.putInt("android.car.wheelTickDistanceFrontRightUmPerTick", i);
/* 554 */     i = ((Integer)paramList.get(3)).intValue();
/*     */     bundle.putInt("android.car.wheelTickDistanceRearRightUmPerTick", i);
/* 556 */     i = ((Integer)paramList.get(4)).intValue(); bundle.putInt("android.car.wheelTickDistanceRearLeftUmPerTick", i);
/* 557 */     return bundle;
/*     */   }
/*     */   
/*     */   public static interface OnSensorChangedListener {
/*     */     void onSensorChanged(CarSensorEvent param1CarSensorEvent);
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface SensorRate {}
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface SensorType {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\CarSensorManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */