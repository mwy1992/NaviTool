/*     */ package android.car.diagnostic;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarApiUtil;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import com.android.car.internal.CarPermission;
/*     */ import com.android.car.internal.CarRatedListeners;
/*     */ import com.android.car.internal.SingleMessageHandler;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
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
/*     */ 
/*     */ @SystemApi
/*     */ public final class CarDiagnosticManager
/*     */   implements CarManagerBase
/*     */ {
/*  62 */   public static final int[] FRAME_TYPES = new int[] { 0, 1 };
/*     */   
/*     */   public static final int FRAME_TYPE_FREEZE = 1;
/*     */   
/*     */   public static final int FRAME_TYPE_LIVE = 0;
/*     */   
/*     */   private static final int MSG_DIAGNOSTIC_EVENTS = 0;
/*     */   
/*  70 */   private final SparseArray<CarDiagnosticListeners> mActiveListeners = new SparseArray();
/*     */   
/*     */   private final SingleMessageHandler<CarDiagnosticEvent> mHandlerCallback;
/*     */   
/*     */   private CarDiagnosticEventListenerToService mListenerToService;
/*     */   
/*     */   private final ICarDiagnostic mService;
/*     */   
/*     */   private final CarPermission mVendorExtensionPermission;
/*     */   
/*     */   public CarDiagnosticManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/*  81 */     this.mService = ICarDiagnostic.Stub.asInterface(paramIBinder);
/*  82 */     this.mHandlerCallback = new SingleMessageHandler<CarDiagnosticEvent>(paramHandler.getLooper(), 0)
/*     */       {
/*     */         final CarDiagnosticManager this$0;
/*     */         
/*     */         protected void handleEvent(CarDiagnosticEvent param1CarDiagnosticEvent) {
/*  87 */           synchronized (CarDiagnosticManager.this.mActiveListeners) {
/*  88 */             CarDiagnosticManager.CarDiagnosticListeners carDiagnosticListeners = (CarDiagnosticManager.CarDiagnosticListeners)CarDiagnosticManager.this.mActiveListeners.get(param1CarDiagnosticEvent.frameType);
/*     */             
/*  90 */             if (carDiagnosticListeners != null)
/*  91 */               carDiagnosticListeners.onDiagnosticEvent(param1CarDiagnosticEvent); 
/*     */             return;
/*     */           }  }
/*     */       };
/*  95 */     this.mVendorExtensionPermission = new CarPermission(paramContext, "android.car.permission.CAR_VENDOR_EXTENSION");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 101 */     synchronized (this.mActiveListeners) {
/* 102 */       this.mActiveListeners.clear();
/* 103 */       this.mListenerToService = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void assertFrameType(int paramInt) {
/* 120 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 125 */         throw new IllegalArgumentException(String.format("%d is not a valid diagnostic frame type", new Object[] { Integer.valueOf(paramInt) }));
/*     */       case 0:
/*     */       case 1:
/*     */         break;
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
/*     */   public boolean registerListener(OnDiagnosticEventListener paramOnDiagnosticEventListener, int paramInt1, int paramInt2) throws CarNotConnectedException, IllegalArgumentException {
/* 143 */     assertFrameType(paramInt1);
/* 144 */     synchronized (this.mActiveListeners) {
/* 145 */       if (this.mListenerToService == null) {
/* 146 */         CarDiagnosticEventListenerToService carDiagnosticEventListenerToService = new CarDiagnosticEventListenerToService(); this(this); this.mListenerToService = carDiagnosticEventListenerToService;
/*     */       } 
/* 148 */       boolean bool = false;
/* 149 */       CarDiagnosticListeners carDiagnosticListeners2 = (CarDiagnosticListeners)this.mActiveListeners.get(paramInt1);
/* 150 */       CarDiagnosticListeners carDiagnosticListeners1 = carDiagnosticListeners2; if (carDiagnosticListeners2 == null) {
/* 151 */         carDiagnosticListeners1 = new CarDiagnosticListeners(); this(this, paramInt2);
/* 152 */         this.mActiveListeners.put(paramInt1, carDiagnosticListeners1);
/* 153 */         bool = true;
/*     */       } 
/* 155 */       if (carDiagnosticListeners1.addAndUpdateRate(paramOnDiagnosticEventListener, paramInt2)) {
/* 156 */         bool = true;
/*     */       }
/* 158 */       if (bool && 
/* 159 */         !registerOrUpdateDiagnosticListener(paramInt1, paramInt2)) {
/* 160 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 164 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterListener(OnDiagnosticEventListener paramOnDiagnosticEventListener) {
/* 172 */     synchronized (this.mActiveListeners) {
/* 173 */       for (int i : FRAME_TYPES) {
/* 174 */         doUnregisterListenerLocked(paramOnDiagnosticEventListener, i);
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void doUnregisterListenerLocked(OnDiagnosticEventListener paramOnDiagnosticEventListener, int paramInt) {
/* 181 */     CarDiagnosticListeners carDiagnosticListeners = (CarDiagnosticListeners)this.mActiveListeners.get(paramInt);
/* 182 */     if (carDiagnosticListeners != null) {
/* 183 */       boolean bool = false;
/* 184 */       if (carDiagnosticListeners.contains(paramOnDiagnosticEventListener)) {
/* 185 */         bool = carDiagnosticListeners.remove(paramOnDiagnosticEventListener);
/*     */       }
/* 187 */       if (carDiagnosticListeners.isEmpty()) {
/*     */         try {
/* 189 */           this.mService.unregisterDiagnosticListener(paramInt, this.mListenerToService);
/*     */         }
/* 191 */         catch (RemoteException remoteException) {}
/*     */ 
/*     */         
/* 194 */         this.mActiveListeners.remove(paramInt);
/* 195 */       } else if (bool) {
/*     */         try {
/* 197 */           registerOrUpdateDiagnosticListener(paramInt, carDiagnosticListeners.getRate());
/* 198 */         } catch (CarNotConnectedException carNotConnectedException) {}
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean registerOrUpdateDiagnosticListener(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/* 208 */       return this.mService.registerOrUpdateDiagnosticListener(paramInt1, paramInt2, this.mListenerToService);
/* 209 */     } catch (IllegalStateException illegalStateException) {
/* 210 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 214 */       return false;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarDiagnosticEvent getLatestLiveFrame() throws CarNotConnectedException {
/*     */     try {
/* 228 */       return this.mService.getLatestLiveFrame();
/* 229 */     } catch (IllegalStateException illegalStateException) {
/* 230 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 234 */       return null;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
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
/*     */   public long[] getFreezeFrameTimestamps() throws CarNotConnectedException {
/*     */     try {
/* 249 */       return this.mService.getFreezeFrameTimestamps();
/* 250 */     } catch (IllegalStateException illegalStateException) {
/* 251 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 255 */       return new long[0];
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
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
/*     */   public CarDiagnosticEvent getFreezeFrame(long paramLong) throws CarNotConnectedException {
/*     */     try {
/* 272 */       return this.mService.getFreezeFrame(paramLong);
/* 273 */     } catch (IllegalStateException illegalStateException) {
/* 274 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 278 */       return null;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
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
/*     */   public boolean clearFreezeFrames(long... paramVarArgs) throws CarNotConnectedException {
/*     */     try {
/* 294 */       return this.mService.clearFreezeFrames(paramVarArgs);
/* 295 */     } catch (IllegalStateException illegalStateException) {
/* 296 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 300 */       return false;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLiveFrameSupported() throws CarNotConnectedException {
/*     */     try {
/* 310 */       return this.mService.isLiveFrameSupported();
/* 311 */     } catch (IllegalStateException illegalStateException) {
/* 312 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 316 */       return false;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFreezeFrameNotificationSupported() throws CarNotConnectedException {
/*     */     try {
/* 326 */       return this.mService.isFreezeFrameNotificationSupported();
/* 327 */     } catch (IllegalStateException illegalStateException) {
/* 328 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 332 */       return false;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGetFreezeFrameSupported() throws CarNotConnectedException {
/*     */     try {
/* 342 */       return this.mService.isGetFreezeFrameSupported();
/* 343 */     } catch (IllegalStateException illegalStateException) {
/* 344 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 348 */       return false;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
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
/*     */   public boolean isClearFreezeFramesSupported() throws CarNotConnectedException {
/*     */     try {
/* 364 */       return this.mService.isClearFreezeFramesSupported();
/* 365 */     } catch (IllegalStateException illegalStateException) {
/* 366 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 370 */       return false;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
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
/*     */   public boolean isSelectiveClearFreezeFramesSupported() throws CarNotConnectedException {
/*     */     try {
/* 386 */       return this.mService.isSelectiveClearFreezeFramesSupported();
/* 387 */     } catch (IllegalStateException illegalStateException) {
/* 388 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 392 */       return false;
/*     */     } catch (RemoteException remoteException) {
/*     */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */   private static class CarDiagnosticEventListenerToService extends ICarDiagnosticEventListener.Stub { private final WeakReference<CarDiagnosticManager> mManager;
/*     */     
/*     */     public CarDiagnosticEventListenerToService(CarDiagnosticManager param1CarDiagnosticManager) {
/* 400 */       this.mManager = new WeakReference<>(param1CarDiagnosticManager);
/*     */     }
/*     */ 
/*     */     
/*     */     private void handleOnDiagnosticEvents(CarDiagnosticManager param1CarDiagnosticManager, List<CarDiagnosticEvent> param1List) {
/* 405 */       param1CarDiagnosticManager.mHandlerCallback.sendEvents(param1List);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onDiagnosticEvents(List<CarDiagnosticEvent> param1List) {
/* 410 */       CarDiagnosticManager carDiagnosticManager = this.mManager.get();
/* 411 */       if (carDiagnosticManager != null)
/* 412 */         handleOnDiagnosticEvents(carDiagnosticManager, param1List); 
/*     */     } }
/*     */ 
/*     */   
/*     */   private class CarDiagnosticListeners extends CarRatedListeners<OnDiagnosticEventListener> { final CarDiagnosticManager this$0;
/*     */     
/*     */     CarDiagnosticListeners(int param1Int) {
/* 419 */       super(param1Int);
/*     */     }
/*     */     
/*     */     void onDiagnosticEvent(final CarDiagnosticEvent eventToDispatch)
/*     */     {
/* 424 */       long l = eventToDispatch.timestamp;
/* 425 */       if (l < this.mLastUpdateTime) {
/* 426 */         Log.w("CAR.L.DIAGNOSTIC", "dropping old data");
/*     */         return;
/*     */       } 
/* 429 */       this.mLastUpdateTime = l;
/* 430 */       boolean bool = CarDiagnosticManager.this.mVendorExtensionPermission.checkGranted();
/* 431 */       if (!bool)
/*     */       {
/* 433 */         eventToDispatch = eventToDispatch.withVendorSensorsRemoved();
/*     */       }
/* 435 */       synchronized (CarDiagnosticManager.this.mActiveListeners)
/* 436 */       { ArrayList arrayList = new ArrayList(); this(getListeners());
/*     */         
/* 438 */         arrayList.forEach(new Consumer<CarDiagnosticManager.OnDiagnosticEventListener>() {
/*     */               final CarDiagnosticManager.CarDiagnosticListeners this$1;
/*     */               final CarDiagnosticEvent val$eventToDispatch;
/*     */               
/* 442 */               public void accept(CarDiagnosticManager.OnDiagnosticEventListener param2OnDiagnosticEventListener) { param2OnDiagnosticEventListener.onDiagnosticEvent(eventToDispatch); } }); return; }  } } class null implements Consumer<OnDiagnosticEventListener> { public void accept(CarDiagnosticManager.OnDiagnosticEventListener param1OnDiagnosticEventListener) { param1OnDiagnosticEventListener.onDiagnosticEvent(eventToDispatch); }
/*     */ 
/*     */     
/*     */     final CarDiagnosticManager.CarDiagnosticListeners this$1;
/*     */     final CarDiagnosticEvent val$eventToDispatch; }
/*     */ 
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface FrameType {}
/*     */   
/*     */   public static interface OnDiagnosticEventListener {
/*     */     void onDiagnosticEvent(CarDiagnosticEvent param1CarDiagnosticEvent);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\diagnostic\CarDiagnosticManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */