/*     */ package android.car.storagemonitoring;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarApiUtil;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import com.android.car.internal.SingleMessageHandler;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class CarStorageMonitoringManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   public static final String INTENT_EXCESSIVE_IO = "android.car.storagemonitoring.EXCESSIVE_IO";
/*     */   private static final int MSG_IO_STATS_EVENT = 0;
/*     */   public static final int PRE_EOL_INFO_NORMAL = 1;
/*     */   public static final int PRE_EOL_INFO_UNKNOWN = 0;
/*     */   public static final int PRE_EOL_INFO_URGENT = 3;
/*     */   public static final int PRE_EOL_INFO_WARNING = 2;
/*     */   public static final long SHUTDOWN_COST_INFO_MISSING = -1L;
/*  42 */   private static final String TAG = CarStorageMonitoringManager.class.getSimpleName();
/*     */ 
/*     */   
/*     */   private ListenerToService mListenerToService;
/*     */ 
/*     */   
/*  48 */   private final Set<IoStatsListener> mListeners = new HashSet<>();
/*     */   private final SingleMessageHandler<IoStats> mMessageHandler;
/*     */   private final ICarStorageMonitoring mService;
/*     */   
/*     */   private static final class ListenerToService
/*     */     extends IIoStatsListener.Stub {
/*     */     private final WeakReference<CarStorageMonitoringManager> mManager;
/*     */     
/*     */     ListenerToService(CarStorageMonitoringManager param1CarStorageMonitoringManager) {
/*  57 */       this.mManager = new WeakReference<>(param1CarStorageMonitoringManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onSnapshot(IoStats param1IoStats) {
/*  62 */       CarStorageMonitoringManager carStorageMonitoringManager = this.mManager.get();
/*  63 */       if (carStorageMonitoringManager != null) {
/*  64 */         carStorageMonitoringManager.mMessageHandler.sendEvents(Collections.singletonList(param1IoStats));
/*     */       }
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
/*     */   public CarStorageMonitoringManager(IBinder paramIBinder, Handler paramHandler) {
/*  82 */     this.mService = ICarStorageMonitoring.Stub.asInterface(paramIBinder);
/*  83 */     this.mMessageHandler = new SingleMessageHandler<IoStats>(paramHandler, 0)
/*     */       {
/*     */         protected void handleEvent(IoStats param1IoStats) {
/*  86 */           for (CarStorageMonitoringManager.IoStatsListener ioStatsListener : CarStorageMonitoringManager.this.mListeners)
/*  87 */             ioStatsListener.onSnapshot(param1IoStats); 
/*     */         }
/*     */         
/*     */         final CarStorageMonitoringManager this$0;
/*     */       };
/*     */   }
/*     */   
/*     */   public static interface IoStatsListener {
/*     */     void onSnapshot(IoStats param1IoStats); }
/*     */   
/*     */   public void onCarDisconnected() {
/*  98 */     this.mListeners.clear();
/*  99 */     this.mListenerToService = null;
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
/*     */   public int getPreEolIndicatorStatus() throws CarNotConnectedException {
/*     */     try {
/* 114 */       return this.mService.getPreEolIndicatorStatus();
/* 115 */     } catch (IllegalStateException illegalStateException) {
/* 116 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 120 */       return 0;
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
/*     */   public WearEstimate getWearEstimate() throws CarNotConnectedException {
/*     */     try {
/* 135 */       return this.mService.getWearEstimate();
/* 136 */     } catch (IllegalStateException illegalStateException) {
/* 137 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 141 */       return WearEstimate.UNKNOWN_ESTIMATE;
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
/*     */   public List<WearEstimateChange> getWearEstimateHistory() throws CarNotConnectedException {
/*     */     try {
/* 158 */       return this.mService.getWearEstimateHistory();
/* 159 */     } catch (IllegalStateException illegalStateException) {
/* 160 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 164 */       return Collections.emptyList();
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
/*     */   public List<IoStatsEntry> getBootIoStats() throws CarNotConnectedException {
/*     */     try {
/* 180 */       return this.mService.getBootIoStats();
/* 181 */     } catch (IllegalStateException illegalStateException) {
/* 182 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 186 */       return Collections.emptyList();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getShutdownDiskWriteAmount() throws CarNotConnectedException {
/*     */     try {
/* 213 */       return this.mService.getShutdownDiskWriteAmount();
/* 214 */     } catch (IllegalStateException illegalStateException) {
/* 215 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 219 */       return -1L;
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
/*     */   public List<IoStatsEntry> getAggregateIoStats() throws CarNotConnectedException {
/*     */     try {
/* 233 */       return this.mService.getAggregateIoStats();
/* 234 */     } catch (IllegalStateException illegalStateException) {
/* 235 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 239 */       return Collections.emptyList();
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
/*     */   public List<IoStats> getIoStatsDeltas() throws CarNotConnectedException {
/*     */     try {
/* 256 */       return this.mService.getIoStatsDeltas();
/* 257 */     } catch (IllegalStateException illegalStateException) {
/* 258 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/*     */ 
/*     */ 
/*     */       
/* 262 */       return Collections.emptyList();
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
/*     */   public void registerListener(IoStatsListener paramIoStatsListener) throws CarNotConnectedException {
/*     */     try {
/* 276 */       if (this.mListeners.isEmpty()) {
/* 277 */         if (this.mListenerToService == null) {
/* 278 */           ListenerToService listenerToService = new ListenerToService(); this(this); this.mListenerToService = listenerToService;
/*     */         } 
/* 280 */         this.mService.registerListener(this.mListenerToService);
/*     */       } 
/* 282 */       this.mListeners.add(paramIoStatsListener);
/* 283 */     } catch (IllegalStateException illegalStateException) {
/* 284 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 285 */     } catch (RemoteException remoteException) {
/* 286 */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterListener(IoStatsListener paramIoStatsListener) throws CarNotConnectedException {
/*     */     try {
/* 296 */       if (!this.mListeners.remove(paramIoStatsListener)) {
/*     */         return;
/*     */       }
/* 299 */       if (this.mListeners.isEmpty()) {
/* 300 */         this.mService.unregisterListener(this.mListenerToService);
/* 301 */         this.mListenerToService = null;
/*     */       } 
/* 303 */     } catch (IllegalStateException illegalStateException) {
/* 304 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 305 */     } catch (RemoteException remoteException) {
/* 306 */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\CarStorageMonitoringManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */