/*     */ package android.car.hardware.property;
/*     */ 
/*     */ import android.car.CarApiUtil;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.car.hardware.CarPropertyConfig;
/*     */ import android.car.hardware.CarPropertyValue;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.util.ArraySet;
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import com.android.car.internal.CarRatedFloatListeners;
/*     */ import com.android.car.internal.SingleMessageHandler;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Consumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarPropertyManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   private static final int MSG_GENERIC_EVENT = 0;
/*  59 */   private final SparseArray<CarPropertyListeners> mActivePropertyListener = new SparseArray();
/*     */   
/*     */   private CarPropertyEventListenerToService mCarPropertyEventToService;
/*     */   
/*     */   private final List<CarPropertyConfig> mConfigs;
/*     */   
/*     */   private final boolean mDbg;
/*     */   
/*     */   private final SingleMessageHandler<CarPropertyEvent> mHandler;
/*     */   
/*     */   private final ICarProperty mService;
/*     */   
/*     */   private final String mTag;
/*     */   
/*     */   public CarPropertyManager(IBinder paramIBinder, Handler paramHandler, boolean paramBoolean, String paramString)
/*     */   {
/*  75 */     this.mDbg = paramBoolean;
/*  76 */     this.mTag = paramString;
/*  77 */     this.mService = ICarProperty.Stub.asInterface(paramIBinder);
/*     */     try {
/*  79 */       this.mConfigs = this.mService.getPropertyList();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  84 */       if (paramHandler == null) {
/*  85 */         this.mHandler = null;
/*     */         return;
/*     */       } 
/*  88 */       this.mHandler = new SingleMessageHandler<CarPropertyEvent>(paramHandler.getLooper(), 0)
/*     */         {
/*     */           final CarPropertyManager this$0;
/*     */           
/*     */           protected void handleEvent(CarPropertyEvent param1CarPropertyEvent) {
/*  93 */             synchronized (CarPropertyManager.this.mActivePropertyListener) {
/*  94 */               SparseArray sparseArray = CarPropertyManager.this.mActivePropertyListener;
/*  95 */               int i = param1CarPropertyEvent.getCarPropertyValue().getPropertyId();
/*     */               CarPropertyManager.CarPropertyListeners carPropertyListeners = (CarPropertyManager.CarPropertyListeners)sparseArray.get(i);
/*  97 */               if (carPropertyListeners != null) {
/*  98 */                 switch (param1CarPropertyEvent.getEventType()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   default:
/* 106 */                     throw new IllegalArgumentException();
/*     */                   case 1:
/*     */                     carPropertyListeners.onErrorEvent(param1CarPropertyEvent); return;
/*     */                   case 0:
/*     */                     break;
/*     */                 }  carPropertyListeners.onPropertyChanged(param1CarPropertyEvent);
/*     */               }  return;
/*     */             }  } }; return;
/*     */     } catch (Exception exception) {
/*     */       Log.e(this.mTag, "getPropertyList exception ", exception); throw new RuntimeException(exception);
/* 116 */     }  } public boolean registerListener(CarPropertyEventListener paramCarPropertyEventListener, int paramInt, float paramFloat) throws CarNotConnectedException { synchronized (this.mActivePropertyListener) {
/* 117 */       if (this.mCarPropertyEventToService == null) {
/* 118 */         CarPropertyEventListenerToService carPropertyEventListenerToService = new CarPropertyEventListenerToService(); this(this, this); this.mCarPropertyEventToService = carPropertyEventListenerToService;
/*     */       } 
/* 120 */       boolean bool = false;
/*     */       
/* 122 */       CarPropertyListeners carPropertyListeners2 = (CarPropertyListeners)this.mActivePropertyListener.get(paramInt);
/* 123 */       CarPropertyListeners carPropertyListeners1 = carPropertyListeners2; if (carPropertyListeners2 == null) {
/* 124 */         carPropertyListeners1 = new CarPropertyListeners(); this(this, paramFloat);
/* 125 */         this.mActivePropertyListener.put(paramInt, carPropertyListeners1);
/* 126 */         bool = true;
/*     */       } 
/* 128 */       if (carPropertyListeners1.addAndUpdateRate(paramCarPropertyEventListener, paramFloat)) {
/* 129 */         bool = true;
/*     */       }
/* 131 */       if (bool && 
/* 132 */         !registerOrUpdatePropertyListener(paramInt, paramFloat)) {
/* 133 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 137 */       return true;
/*     */     }  }
/*     */ 
/*     */   
/*     */   private boolean registerOrUpdatePropertyListener(int paramInt, float paramFloat) throws CarNotConnectedException {
/*     */     try {
/* 143 */       this.mService.registerListener(paramInt, paramFloat, this.mCarPropertyEventToService);
/* 144 */     } catch (IllegalStateException illegalStateException) {
/* 145 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 146 */     } catch (RemoteException remoteException) {
/* 147 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/* 149 */     return true;
/*     */   }
/*     */   public static interface CarPropertyEventListener {
/*     */     void onChangeEvent(CarPropertyValue param1CarPropertyValue);
/*     */     void onErrorEvent(int param1Int1, int param1Int2); }
/*     */   private class CarPropertyEventListenerToService extends ICarPropertyEventListener.Stub { private final WeakReference<CarPropertyManager> mMgr; final CarPropertyManager this$0;
/*     */     CarPropertyEventListenerToService(CarPropertyManager param1CarPropertyManager1) {
/* 156 */       this.mMgr = new WeakReference<>(param1CarPropertyManager1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onEvent(List<CarPropertyEvent> param1List) throws RemoteException {
/* 161 */       CarPropertyManager carPropertyManager = this.mMgr.get();
/* 162 */       if (carPropertyManager != null) {
/* 163 */         carPropertyManager.handleEvent(param1List);
/*     */       }
/*     */     } }
/*     */ 
/*     */   
/*     */   private void handleEvent(List<CarPropertyEvent> paramList) {
/* 169 */     if (this.mHandler != null) {
/* 170 */       this.mHandler.sendEvents(paramList);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterListener(CarPropertyEventListener paramCarPropertyEventListener) {
/* 180 */     synchronized (this.mActivePropertyListener) {
/* 181 */       int[] arrayOfInt = new int[this.mActivePropertyListener.size()]; int i, j;
/* 182 */       for (j = 0, i = 0; i < this.mActivePropertyListener.size(); i++) {
/* 183 */         arrayOfInt[i] = this.mActivePropertyListener.keyAt(i);
/*     */       }
/* 185 */       for (int k = arrayOfInt.length; i < k; ) { j = arrayOfInt[i];
/* 186 */         doUnregisterListenerLocked(paramCarPropertyEventListener, j);
/*     */         i++; }
/*     */       
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterListener(CarPropertyEventListener paramCarPropertyEventListener, int paramInt) {
/* 198 */     synchronized (this.mActivePropertyListener) {
/* 199 */       doUnregisterListenerLocked(paramCarPropertyEventListener, paramInt);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private void doUnregisterListenerLocked(CarPropertyEventListener paramCarPropertyEventListener, int paramInt) {
/* 204 */     CarPropertyListeners carPropertyListeners = (CarPropertyListeners)this.mActivePropertyListener.get(paramInt);
/* 205 */     if (carPropertyListeners != null) {
/* 206 */       boolean bool = false;
/* 207 */       if (carPropertyListeners.contains(paramCarPropertyEventListener)) {
/* 208 */         bool = carPropertyListeners.remove(paramCarPropertyEventListener);
/*     */       }
/* 210 */       if (carPropertyListeners.isEmpty()) {
/*     */         try {
/* 212 */           this.mService.unregisterListener(paramInt, this.mCarPropertyEventToService);
/* 213 */         } catch (RemoteException remoteException) {}
/*     */ 
/*     */         
/* 216 */         this.mActivePropertyListener.remove(paramInt);
/* 217 */       } else if (bool) {
/*     */         try {
/* 219 */           registerOrUpdatePropertyListener(paramInt, carPropertyListeners.getRate());
/* 220 */         } catch (CarNotConnectedException carNotConnectedException) {}
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CarPropertyConfig> getPropertyList() {
/* 231 */     return this.mConfigs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CarPropertyConfig> getPropertyList(ArraySet<Integer> paramArraySet) {
/* 239 */     ArrayList<CarPropertyConfig> arrayList = new ArrayList();
/* 240 */     for (CarPropertyConfig carPropertyConfig : this.mConfigs) {
/* 241 */       if (paramArraySet.contains(Integer.valueOf(carPropertyConfig.getPropertyId()))) {
/* 242 */         arrayList.add(carPropertyConfig);
/*     */       }
/*     */     } 
/* 245 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPropertyAvailable(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     
/* 255 */     try { CarPropertyValue carPropertyValue = this.mService.getProperty(paramInt1, paramInt2);
/* 256 */       if (carPropertyValue != null)
/* 257 */       { int i = carPropertyValue.getStatus(); if (i == 0)
/* 258 */           return true;  }  return false; } catch (RemoteException remoteException)
/* 259 */     { String str1 = this.mTag; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isPropertyAvailable failed with "); stringBuilder.append(remoteException.toString()); stringBuilder.append(", propId: 0x");
/* 260 */       stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", area: 0x"); stringBuilder.append(Integer.toHexString(paramInt2)); String str2 = stringBuilder.toString(); Log.e(str1, str2, (Throwable)remoteException);
/* 261 */       throw new CarNotConnectedException(remoteException); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBooleanProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     boolean bool;
/* 272 */     CarPropertyValue<Boolean> carPropertyValue = getProperty(Boolean.class, paramInt1, paramInt2);
/* 273 */     if (carPropertyValue != null) { bool = ((Boolean)carPropertyValue.getValue()).booleanValue(); } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFloatProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     float f;
/* 283 */     CarPropertyValue<Float> carPropertyValue = getProperty(Float.class, paramInt1, paramInt2);
/* 284 */     if (carPropertyValue != null) { f = ((Float)carPropertyValue.getValue()).floatValue(); } else { f = 0.0F; }  return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 294 */     CarPropertyValue<Integer> carPropertyValue = getProperty(Integer.class, paramInt1, paramInt2);
/* 295 */     if (carPropertyValue != null) { paramInt1 = ((Integer)carPropertyValue.getValue()).intValue(); } else { paramInt1 = 0; }  return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getIntArrayProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     int[] arrayOfInt;
/* 305 */     CarPropertyValue<Integer> carPropertyValue = getProperty((Class)Integer[].class, paramInt1, paramInt2);
/* 306 */     if (carPropertyValue != null) { arrayOfInt = toIntArray((Integer[])carPropertyValue.getValue()); } else { arrayOfInt = new int[0]; }  return arrayOfInt;
/*     */   }
/*     */   
/*     */   private static int[] toIntArray(Integer[] paramArrayOfInteger) {
/* 310 */     int i = paramArrayOfInteger.length;
/* 311 */     int[] arrayOfInt = new int[i];
/* 312 */     for (byte b = 0; b < i; b++) {
/* 313 */       arrayOfInt[b] = paramArrayOfInteger[b].intValue();
/*     */     }
/* 315 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> CarPropertyValue<E> getProperty(Class<E> paramClass, int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 322 */     if (this.mDbg) {
/* 323 */       String str1 = this.mTag; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getProperty, propId: 0x"); stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", area: 0x");
/* 324 */       stringBuilder.append(Integer.toHexString(paramInt2)); stringBuilder.append(", class: "); stringBuilder.append(paramClass); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/*     */     }  try {
/*     */       IllegalArgumentException illegalArgumentException;
/* 327 */       CarPropertyValue carPropertyValue = this.mService.getProperty(paramInt1, paramInt2);
/* 328 */       if (carPropertyValue != null && carPropertyValue.getValue() != null) {
/* 329 */         Class<?> clazz = carPropertyValue.getValue().getClass();
/* 330 */         if (clazz != paramClass) {
/* 331 */           illegalArgumentException = new IllegalArgumentException(); StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("Invalid property type. Expected: "); stringBuilder.append(paramClass); stringBuilder.append(", but was: "); stringBuilder.append(clazz); this(stringBuilder.toString()); throw illegalArgumentException;
/*     */         } 
/*     */       } 
/*     */       
/* 335 */       return (CarPropertyValue<E>)illegalArgumentException;
/* 336 */     } catch (RemoteException remoteException) {
/* 337 */       String str1 = this.mTag; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getProperty failed with "); stringBuilder.append(remoteException.toString()); stringBuilder.append(", propId: 0x");
/* 338 */       stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", area: 0x"); stringBuilder.append(Integer.toHexString(paramInt2)); String str2 = stringBuilder.toString(); Log.e(str1, str2, (Throwable)remoteException);
/* 339 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> CarPropertyValue<E> getProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/* 347 */       return this.mService.getProperty(paramInt1, paramInt2);
/*     */     }
/* 349 */     catch (RemoteException remoteException) {
/* 350 */       String str1 = this.mTag; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getProperty failed with "); stringBuilder.append(remoteException.toString()); stringBuilder.append(", propId: 0x");
/* 351 */       stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", area: 0x"); stringBuilder.append(Integer.toHexString(paramInt2)); String str2 = stringBuilder.toString(); Log.e(str1, str2, (Throwable)remoteException);
/* 352 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> void setProperty(Class<E> paramClass, int paramInt1, int paramInt2, E paramE) throws CarNotConnectedException {
/* 359 */     if (this.mDbg) {
/* 360 */       String str2 = this.mTag; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setProperty, propId: 0x"); stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", area: 0x");
/* 361 */       stringBuilder.append(Integer.toHexString(paramInt2)); stringBuilder.append(", class: "); stringBuilder.append(paramClass); stringBuilder.append(", val: "); stringBuilder.append(paramE); String str1 = stringBuilder.toString(); Log.d(str2, str1);
/*     */     } 
/*     */     try {
/* 364 */       ICarProperty iCarProperty = this.mService; CarPropertyValue carPropertyValue = new CarPropertyValue(); this(paramInt1, paramInt2, paramE); iCarProperty.setProperty(carPropertyValue); return;
/* 365 */     } catch (RemoteException remoteException) {
/* 366 */       String str = this.mTag; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setProperty failed with "); stringBuilder.append(remoteException.toString()); Log.e(str, stringBuilder.toString(), (Throwable)remoteException);
/* 367 */       throw new CarNotConnectedException(remoteException);
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
/*     */   public void setBooleanProperty(int paramInt1, int paramInt2, boolean paramBoolean) throws CarNotConnectedException {
/* 381 */     setProperty(Boolean.class, paramInt1, paramInt2, Boolean.valueOf(paramBoolean));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFloatProperty(int paramInt1, int paramInt2, float paramFloat) throws CarNotConnectedException {
/* 386 */     setProperty(Float.class, paramInt1, paramInt2, Float.valueOf(paramFloat));
/*     */   }
/*     */   
/*     */   public void setIntProperty(int paramInt1, int paramInt2, int paramInt3) throws CarNotConnectedException {
/* 390 */     setProperty(Integer.class, paramInt1, paramInt2, Integer.valueOf(paramInt3));
/*     */   }
/*     */   
/*     */   private class CarPropertyListeners extends CarRatedFloatListeners<CarPropertyEventListener> { final CarPropertyManager this$0;
/*     */     
/*     */     CarPropertyListeners(float param1Float) {
/* 396 */       super(param1Float);
/*     */     }
/*     */     
/*     */     void onPropertyChanged(final CarPropertyEvent event) {
/* 400 */       long l = event.getCarPropertyValue().getTimestamp();
/* 401 */       if (l < this.mLastUpdateTime) {
/* 402 */         Log.w(CarPropertyManager.this.mTag, "dropping old property data");
/*     */         return;
/*     */       } 
/* 405 */       this.mLastUpdateTime = l;
/*     */       
/* 407 */       synchronized (CarPropertyManager.this.mActivePropertyListener) {
/* 408 */         ArrayList arrayList = new ArrayList(); this(getListeners());
/*     */         
/* 410 */         arrayList.forEach(new Consumer<CarPropertyManager.CarPropertyEventListener>() { final CarPropertyManager.CarPropertyListeners this$1; final CarPropertyEvent val$event;
/*     */               
/*     */               public void accept(CarPropertyManager.CarPropertyEventListener param2CarPropertyEventListener) {
/* 413 */                 param2CarPropertyEventListener.onChangeEvent(event.getCarPropertyValue());
/*     */               } }
/*     */           );
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/* 420 */     void onErrorEvent(CarPropertyEvent param1CarPropertyEvent) { null = param1CarPropertyEvent.getCarPropertyValue();
/* 421 */       synchronized (CarPropertyManager.this.mActivePropertyListener)
/* 422 */       { ArrayList arrayList = new ArrayList(); this(getListeners());
/*     */         
/* 424 */         arrayList.forEach(new Consumer<CarPropertyManager.CarPropertyEventListener>() { final CarPropertyManager.CarPropertyListeners this$1;
/*     */               final CarPropertyValue val$value;
/*     */               
/* 427 */               public void accept(CarPropertyManager.CarPropertyEventListener param2CarPropertyEventListener) { param2CarPropertyEventListener.onErrorEvent(value.getPropertyId(), value.getAreaId()); } }); return; }  } } class null implements Consumer<CarPropertyEventListener> { final CarPropertyManager.CarPropertyListeners this$1; final CarPropertyEvent val$event; public void accept(CarPropertyManager.CarPropertyEventListener param1CarPropertyEventListener) { param1CarPropertyEventListener.onChangeEvent(event.getCarPropertyValue()); } } class null implements Consumer<CarPropertyEventListener> { public void accept(CarPropertyManager.CarPropertyEventListener param1CarPropertyEventListener) { param1CarPropertyEventListener.onErrorEvent(value.getPropertyId(), value.getAreaId()); }
/*     */ 
/*     */ 
/*     */     
/*     */     final CarPropertyManager.CarPropertyListeners this$1;
/*     */     final CarPropertyValue val$value; }
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 436 */     synchronized (this.mActivePropertyListener) {
/* 437 */       this.mActivePropertyListener.clear();
/* 438 */       this.mCarPropertyEventToService = null;
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\property\CarPropertyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */