/*     */ package android.car.hardware.power;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.Car;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.concurrent.Executor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class CarPowerManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   public static final int BOOT_REASON_DOOR_OPEN = 4;
/*     */   public static final int BOOT_REASON_DOOR_UNLOCK = 2;
/*     */   public static final int BOOT_REASON_REMOTE_START = 5;
/*     */   public static final int BOOT_REASON_TIMER = 3;
/*     */   public static final int BOOT_REASON_USER_POWER_ON = 1;
/*     */   private static final boolean DBG = false;
/*     */   private static final String TAG = "CarPowerManager";
/*     */   private Executor mExecutor;
/*     */   private CarPowerStateListener mListener;
/*     */   @GuardedBy("mLock")
/*     */   private ICarPowerStateListener mListenerToService;
/*  54 */   private final Object mLock = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ICarPower mService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarPowerManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/* 138 */     this.mService = ICarPower.Stub.asInterface(paramIBinder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBootReason() throws CarNotConnectedException {
/*     */     try {
/* 150 */       return this.mService.getBootReason();
/* 151 */     } catch (RemoteException remoteException) {
/* 152 */       Log.e("CarPowerManager", "Exception in getBootReason", (Throwable)remoteException);
/* 153 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void requestShutdownOnNextSuspend() throws CarNotConnectedException {
/*     */     try {
/* 164 */       this.mService.requestShutdownOnNextSuspend(); return;
/* 165 */     } catch (RemoteException remoteException) {
/* 166 */       Log.e("CarPowerManager", "Exception in requestShutdownOnNextSuspend", (Throwable)remoteException);
/* 167 */       throw new CarNotConnectedException(remoteException);
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
/*     */   public void setListener(CarPowerStateListener paramCarPowerStateListener, Executor paramExecutor) throws CarNotConnectedException, IllegalStateException {
/* 188 */     synchronized (this.mLock) {
/* 189 */       CarNotConnectedException carNotConnectedException; if (this.mListenerToService == null) {
/* 190 */         ICarPowerStateListener.Stub stub = new ICarPowerStateListener.Stub() {
/*     */             final CarPowerManager this$0;
/*     */             
/* 193 */             public void onStateChanged(int param1Int1, int param1Int2) throws RemoteException { CarPowerManager.this.handleEvent(param1Int1, param1Int2); }
/*     */           };
/*     */         super(this);
/*     */         try {
/* 197 */           this.mService.registerListener(stub);
/* 198 */           this.mListenerToService = stub;
/* 199 */         } catch (RemoteException remoteException) {
/* 200 */           Log.e("CarPowerManager", "Could not connect: ", (Throwable)remoteException);
/* 201 */           carNotConnectedException = new CarNotConnectedException(); this((Exception)remoteException); throw carNotConnectedException;
/* 202 */         } catch (IllegalStateException illegalStateException1) {
/* 203 */           Car.checkCarNotConnectedExceptionFromCarService(illegalStateException1);
/*     */         } 
/*     */       } 
/* 206 */       if (this.mExecutor == null && this.mListener == null) {
/*     */         
/* 208 */         this.mExecutor = (Executor)remoteException;
/* 209 */         this.mListener = (CarPowerStateListener)carNotConnectedException; return;
/*     */       } 
/* 211 */       IllegalStateException illegalStateException = new IllegalStateException(); this("Listener must be cleared first"); throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearListener() {
/* 222 */     synchronized (this.mLock) {
/* 223 */       ICarPowerStateListener iCarPowerStateListener = this.mListenerToService;
/* 224 */       this.mListenerToService = null;
/* 225 */       this.mListener = null;
/* 226 */       this.mExecutor = null;
/*     */ 
/*     */       
/* 229 */       if (iCarPowerStateListener == null) {
/* 230 */         Log.w("CarPowerManager", "unregisterListener: listener was not registered");
/*     */         
/*     */         return;
/*     */       } 
/*     */       try {
/* 235 */         this.mService.unregisterListener(iCarPowerStateListener);
/* 236 */       } catch (RemoteException remoteException) {
/* 237 */         Log.e("CarPowerManager", "Failed to unregister listener", (Throwable)remoteException);
/*     */       }
/* 239 */       catch (IllegalStateException null) {
/* 240 */         Car.hideCarNotConnectedExceptionFromCarService((IllegalStateException)null);
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private void handleEvent(int paramInt1, int paramInt2) {
/* 246 */     synchronized (this.mLock) {
/* 247 */       Executor executor = this.mExecutor;
/*     */       
/* 249 */       if (executor != null) {
/* 250 */         executor.execute(new -$$Lambda$CarPowerManager$b20g9ldGXVMVhvtrNO8ZrWsD7O4(this, paramInt1, paramInt2));
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 256 */         handleEventInternal(paramInt1, paramInt2);
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   } private void handleEventInternal(int paramInt1, int paramInt2) {
/* 261 */     this.mListener.onStateChanged(paramInt1);
/* 262 */     if (paramInt1 == 1 || paramInt1 == 2) {
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 267 */         this.mService.finished(this.mListenerToService, paramInt2);
/* 268 */       } catch (RemoteException remoteException) {
/* 269 */         Log.e("CarPowerManager", "Exception in finished", (Throwable)remoteException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 278 */     synchronized (this.mLock) {
/* 279 */       ICarPowerStateListener iCarPowerStateListener = this.mListenerToService;
/*     */ 
/*     */       
/* 282 */       if (iCarPowerStateListener != null)
/* 283 */         clearListener(); 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface BootReason {}
/*     */   
/*     */   public static interface CarPowerStateListener {
/*     */     public static final int SHUTDOWN_CANCELLED = 0;
/*     */     public static final int SHUTDOWN_ENTER = 1;
/*     */     public static final int SUSPEND_ENTER = 2;
/*     */     public static final int SUSPEND_EXIT = 3;
/*     */     
/*     */     void onStateChanged(int param1Int);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\power\CarPowerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */