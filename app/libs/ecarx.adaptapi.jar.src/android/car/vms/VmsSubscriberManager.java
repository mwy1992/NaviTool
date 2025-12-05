/*     */ package android.car.vms;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.Car;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.android.internal.util.Preconditions;
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
/*     */ 
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
/*     */ public final class VmsSubscriberManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   private static final boolean DBG = true;
/*     */   private static final String TAG = "VmsSubscriberManager";
/*     */   @GuardedBy("mClientCallbackLock")
/*     */   private VmsSubscriberClientCallback mClientCallback;
/*  55 */   private final Object mClientCallbackLock = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GuardedBy("mClientCallbackLock")
/*     */   private Executor mExecutor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IVmsSubscriberClient mSubscriberManagerClient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IVmsSubscriberService mVmsSubscriberService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VmsSubscriberManager(IBinder paramIBinder) {
/*  81 */     this.mVmsSubscriberService = IVmsSubscriberService.Stub.asInterface(paramIBinder);
/*  82 */     this.mSubscriberManagerClient = new IVmsSubscriberClient.Stub() {
/*     */         final VmsSubscriberManager this$0;
/*     */         
/*     */         public void onVmsMessageReceived(VmsLayer param1VmsLayer, byte[] param1ArrayOfbyte) {
/*  86 */           synchronized (VmsSubscriberManager.this.mClientCallbackLock) {
/*  87 */             Executor executor = VmsSubscriberManager.this.mExecutor;
/*     */             
/*  89 */             if (executor == null) {
/*     */               
/*  91 */               Log.d("VmsSubscriberManager", "Executor is null in onVmsMessageReceived");
/*     */               
/*     */               return;
/*     */             } 
/*  95 */             Binder.clearCallingIdentity();
/*  96 */             executor.execute(new -$$Lambda$VmsSubscriberManager$1$afqRUqICTW_Bv-9KKLr-b1VHpUA(this, param1VmsLayer, param1ArrayOfbyte));
/*     */             return;
/*     */           } 
/*     */         }
/*     */         
/*     */         public void onLayersAvailabilityChanged(VmsAvailableLayers param1VmsAvailableLayers) {
/* 102 */           synchronized (VmsSubscriberManager.this.mClientCallbackLock) {
/* 103 */             Executor executor = VmsSubscriberManager.this.mExecutor;
/*     */             
/* 105 */             if (executor == null) {
/*     */               
/* 107 */               Log.d("VmsSubscriberManager", "Executor is null in onLayersAvailabilityChanged");
/*     */               
/*     */               return;
/*     */             } 
/* 111 */             Binder.clearCallingIdentity();
/* 112 */             executor.execute(new -$$Lambda$VmsSubscriberManager$1$YFkXlCwCneVvMYfeu4olB3-8X0o(this, param1VmsAvailableLayers));
/*     */             return;
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVmsSubscriberClientCallback(Executor paramExecutor, VmsSubscriberClientCallback paramVmsSubscriberClientCallback) throws CarNotConnectedException {
/* 126 */     Preconditions.checkNotNull(paramVmsSubscriberClientCallback);
/* 127 */     Preconditions.checkNotNull(paramExecutor);
/* 128 */     synchronized (this.mClientCallbackLock) {
/* 129 */       if (this.mClientCallback == null) {
/*     */ 
/*     */         
/* 132 */         this.mClientCallback = paramVmsSubscriberClientCallback;
/* 133 */         this.mExecutor = paramExecutor;
/*     */         
/*     */         try {
/* 136 */           this.mVmsSubscriberService.addVmsSubscriberToNotifications(this.mSubscriberManagerClient); return;
/* 137 */         } catch (RemoteException remoteException) {
/* 138 */           Log.e("VmsSubscriberManager", "Could not connect: ", (Throwable)remoteException);
/* 139 */           throw new CarNotConnectedException(remoteException);
/*     */         } 
/*     */       } 
/*     */       IllegalStateException illegalStateException = new IllegalStateException();
/*     */       this("Client callback is already configured.");
/*     */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearVmsSubscriberClientCallback() throws CarNotConnectedException {
/* 150 */     synchronized (this.mClientCallbackLock) {
/* 151 */       if (this.mExecutor == null)
/*     */         return; 
/*     */       try {
/* 154 */         this.mVmsSubscriberService.removeVmsSubscriberToNotifications(this.mSubscriberManagerClient);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 160 */         synchronized (this.mClientCallbackLock) {
/* 161 */           this.mClientCallback = null;
/* 162 */           this.mExecutor = null;
/*     */           return;
/*     */         } 
/*     */       } catch (RemoteException null) {
/*     */         Log.e("VmsSubscriberManager", "Could not connect: ", (Throwable)null);
/*     */         throw new CarNotConnectedException(null);
/*     */       } 
/*     */     } 
/*     */   } public byte[] getPublisherInfo(int paramInt) throws CarNotConnectedException, IllegalStateException {
/*     */     try {
/* 172 */       return this.mVmsSubscriberService.getPublisherInfo(paramInt);
/* 173 */     } catch (RemoteException remoteException) {
/* 174 */       Log.e("VmsSubscriberManager", "Could not connect: ", (Throwable)remoteException);
/* 175 */       throw new CarNotConnectedException(remoteException);
/* 176 */     } catch (IllegalStateException illegalStateException) {
/* 177 */       Car.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 178 */       throw new IllegalStateException(illegalStateException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VmsAvailableLayers getAvailableLayers() throws CarNotConnectedException, IllegalStateException {
/*     */     try {
/* 188 */       return this.mVmsSubscriberService.getAvailableLayers();
/* 189 */     } catch (RemoteException remoteException) {
/* 190 */       Log.e("VmsSubscriberManager", "Could not connect: ", (Throwable)remoteException);
/* 191 */       throw new CarNotConnectedException(remoteException);
/* 192 */     } catch (IllegalStateException illegalStateException) {
/* 193 */       Car.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 194 */       throw new IllegalStateException(illegalStateException);
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
/*     */   public void subscribe(VmsLayer paramVmsLayer) throws CarNotConnectedException {
/* 206 */     verifySubscriptionIsAllowed();
/*     */     try {
/* 208 */       this.mVmsSubscriberService.addVmsSubscriber(this.mSubscriberManagerClient, paramVmsLayer);
/* 209 */       VmsOperationRecorder.get().subscribe(paramVmsLayer); return;
/* 210 */     } catch (RemoteException remoteException) {
/* 211 */       Log.e("VmsSubscriberManager", "Could not connect: ", (Throwable)remoteException);
/* 212 */       throw new CarNotConnectedException(remoteException);
/* 213 */     } catch (IllegalStateException illegalStateException) {
/* 214 */       Car.checkCarNotConnectedExceptionFromCarService(illegalStateException);
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
/*     */   public void subscribe(VmsLayer paramVmsLayer, int paramInt) throws CarNotConnectedException {
/* 227 */     verifySubscriptionIsAllowed();
/*     */     try {
/* 229 */       this.mVmsSubscriberService.addVmsSubscriberToPublisher(this.mSubscriberManagerClient, paramVmsLayer, paramInt);
/*     */       
/* 231 */       VmsOperationRecorder.get().subscribe(paramVmsLayer, paramInt); return;
/* 232 */     } catch (RemoteException remoteException) {
/* 233 */       Log.e("VmsSubscriberManager", "Could not connect: ", (Throwable)remoteException);
/* 234 */       throw new CarNotConnectedException(remoteException);
/* 235 */     } catch (IllegalStateException illegalStateException) {
/* 236 */       Car.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public void startMonitoring() throws CarNotConnectedException {
/* 241 */     verifySubscriptionIsAllowed();
/*     */     try {
/* 243 */       this.mVmsSubscriberService.addVmsSubscriberPassive(this.mSubscriberManagerClient);
/* 244 */       VmsOperationRecorder.get().startMonitoring(); return;
/* 245 */     } catch (RemoteException remoteException) {
/* 246 */       Log.e("VmsSubscriberManager", "Could not connect: ", (Throwable)remoteException);
/* 247 */       throw new CarNotConnectedException(remoteException);
/* 248 */     } catch (IllegalStateException illegalStateException) {
/* 249 */       Car.checkCarNotConnectedExceptionFromCarService(illegalStateException);
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
/*     */   public void unsubscribe(VmsLayer paramVmsLayer) {
/* 261 */     verifySubscriptionIsAllowed();
/*     */     try {
/* 263 */       this.mVmsSubscriberService.removeVmsSubscriber(this.mSubscriberManagerClient, paramVmsLayer);
/* 264 */       VmsOperationRecorder.get().unsubscribe(paramVmsLayer);
/* 265 */     } catch (RemoteException remoteException) {
/* 266 */       Log.e("VmsSubscriberManager", "Failed to clear subscriber", (Throwable)remoteException);
/*     */     }
/* 268 */     catch (IllegalStateException illegalStateException) {
/* 269 */       Car.hideCarNotConnectedExceptionFromCarService(illegalStateException);
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
/*     */   public void unsubscribe(VmsLayer paramVmsLayer, int paramInt) {
/*     */     try {
/* 283 */       this.mVmsSubscriberService.removeVmsSubscriberToPublisher(this.mSubscriberManagerClient, paramVmsLayer, paramInt);
/*     */       
/* 285 */       VmsOperationRecorder.get().unsubscribe(paramVmsLayer, paramInt);
/* 286 */     } catch (RemoteException remoteException) {
/* 287 */       Log.e("VmsSubscriberManager", "Failed to clear subscriber", (Throwable)remoteException);
/*     */     }
/* 289 */     catch (IllegalStateException illegalStateException) {
/* 290 */       Car.hideCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stopMonitoring() {
/*     */     try {
/* 296 */       this.mVmsSubscriberService.removeVmsSubscriberPassive(this.mSubscriberManagerClient);
/* 297 */       VmsOperationRecorder.get().stopMonitoring();
/* 298 */     } catch (RemoteException remoteException) {
/* 299 */       Log.e("VmsSubscriberManager", "Failed to clear subscriber ", (Throwable)remoteException);
/*     */     }
/* 301 */     catch (IllegalStateException illegalStateException) {
/* 302 */       Car.hideCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dispatchOnReceiveMessage(VmsLayer paramVmsLayer, byte[] paramArrayOfbyte) {
/* 307 */     VmsSubscriberClientCallback vmsSubscriberClientCallback = getClientCallbackThreadSafe();
/* 308 */     if (vmsSubscriberClientCallback == null) {
/* 309 */       Log.e("VmsSubscriberManager", "Cannot dispatch received message.");
/*     */       return;
/*     */     } 
/* 312 */     vmsSubscriberClientCallback.onVmsMessageReceived(paramVmsLayer, paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   private void dispatchOnAvailabilityChangeMessage(VmsAvailableLayers paramVmsAvailableLayers) {
/* 316 */     VmsSubscriberClientCallback vmsSubscriberClientCallback = getClientCallbackThreadSafe();
/* 317 */     if (vmsSubscriberClientCallback == null) {
/* 318 */       Log.e("VmsSubscriberManager", "Cannot dispatch availability change message.");
/*     */       return;
/*     */     } 
/* 321 */     vmsSubscriberClientCallback.onLayersAvailabilityChanged(paramVmsAvailableLayers);
/*     */   }
/*     */ 
/*     */   
/*     */   private VmsSubscriberClientCallback getClientCallbackThreadSafe() {
/* 326 */     synchronized (this.mClientCallbackLock) {
/* 327 */       VmsSubscriberClientCallback vmsSubscriberClientCallback = this.mClientCallback;
/*     */       
/* 329 */       if (vmsSubscriberClientCallback == null) {
/* 330 */         Log.e("VmsSubscriberManager", "client callback not set.");
/*     */       }
/* 332 */       return vmsSubscriberClientCallback;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void verifySubscriptionIsAllowed() {
/* 339 */     VmsSubscriberClientCallback vmsSubscriberClientCallback = getClientCallbackThreadSafe();
/* 340 */     if (vmsSubscriberClientCallback != null)
/* 341 */       return;  throw new IllegalStateException("Cannot subscribe.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {}
/*     */ 
/*     */   
/*     */   private static final class VmsDataMessage
/*     */   {
/*     */     private final VmsLayer mLayer;
/*     */     
/*     */     private final byte[] mPayload;
/*     */ 
/*     */     
/*     */     public VmsDataMessage(VmsLayer param1VmsLayer, byte[] param1ArrayOfbyte) {
/* 357 */       this.mLayer = param1VmsLayer;
/* 358 */       this.mPayload = param1ArrayOfbyte;
/*     */     }
/*     */     
/*     */     public VmsLayer getLayer() {
/* 362 */       return this.mLayer;
/*     */     }
/*     */     
/*     */     public byte[] getPayload() {
/* 366 */       return this.mPayload;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface VmsSubscriberClientCallback {
/*     */     void onLayersAvailabilityChanged(VmsAvailableLayers param1VmsAvailableLayers);
/*     */     
/*     */     void onVmsMessageReceived(VmsLayer param1VmsLayer, byte[] param1ArrayOfbyte);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsSubscriberManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */