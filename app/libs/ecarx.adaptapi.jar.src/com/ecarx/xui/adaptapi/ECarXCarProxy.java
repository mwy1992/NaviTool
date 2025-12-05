/*     */ package com.ecarx.xui.adaptapi;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.ServiceManager;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ECarXCarProxy
/*     */ {
/*     */   private CarHandler mCarHandler;
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private IConnectable.IConnectWatcher mConnectWatcher;
/*     */   private Context mContext;
/*     */   @GuardedBy("mECarXCarLock")
/*     */   private ECarXCar mECarXCar;
/*  44 */   private final Object mECarXCarLock = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IECarXCar mECarXCarService;
/*     */ 
/*     */ 
/*     */   
/*     */   private HandlerThread mHandlerThread;
/*     */ 
/*     */ 
/*     */   
/*     */   private ECarXCarProxyMethod mProxyMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ECarXCarProxy(Context paramContext, ECarXCarProxyMethod paramECarXCarProxyMethod) {
/*  63 */     this.mContext = paramContext;
/*  64 */     this.mProxyMethod = paramECarXCarProxyMethod;
/*     */     
/*  66 */     this.mHandlerThread = new HandlerThread("CarImplHandler");
/*  67 */     this.mHandlerThread.start();
/*  68 */     this.mCarHandler = new CarHandler(this.mHandlerThread.getLooper());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanup() {
/*  75 */     synchronized (this.mECarXCarLock) {
/*  76 */       if (this.mECarXCar != null) {
/*  77 */         this.mECarXCar.unregisterDieCallback();
/*     */       }
/*     */ 
/*     */       
/*  81 */       if (this.mHandlerThread != null) {
/*  82 */         this.mHandlerThread.quit();
/*  83 */         this.mHandlerThread = null;
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void initECarXCar() {
/*  91 */     ECarXCar eCarXCar = null;
/*     */     
/*     */     try {
/*  94 */       synchronized (this.mECarXCarLock) {
/*  95 */         IBinder iBinder = ServiceManager.getService("ecarxcar_service");
/*     */         
/*  97 */         if (iBinder == null || !iBinder.isBinderAlive() || !iBinder.pingBinder()) {
/*  98 */           this.mCarHandler.sendEmptyMessageDelayed(1, 100L);
/*     */         } else {
/* 100 */           this.mECarXCarService = IECarXCar.Stub.asInterface(iBinder);
/*     */           
/* 102 */           if (this.mContext != null && this.mECarXCarService != null) {
/* 103 */             this.mECarXCar = ECarXCar.createCar(this.mContext, this.mECarXCarService);
/*     */           }
/*     */           
/* 106 */           if (this.mECarXCar != null) {
/* 107 */             eCarXCar = this.mECarXCar;
/* 108 */             ECarXCar eCarXCar2 = this.mECarXCar; ECarXCar.CarServiceDieCallback carServiceDieCallback = new ECarXCar.CarServiceDieCallback() {
/*     */                 final ECarXCarProxy this$0;
/*     */                 
/* 111 */                 public void onServiceDeath() { ECarXCarProxy.this.callECarXCarServiceDeath(); }
/*     */               };
/*     */             super(this);
/*     */             eCarXCar2.registerDieCallback(carServiceDieCallback);
/* 115 */             ECarXCar eCarXCar1 = this.mECarXCar;
/* 116 */             this.mCarSignalManager = (CarSignalManager)eCarXCar1.getCarManager("car_signal");
/*     */           } else {
/* 118 */             this.mCarHandler.sendEmptyMessageDelayed(1, 100L);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 123 */         if (this.mProxyMethod != null && eCarXCar != null) {
/* 124 */           this.mProxyMethod.onECarXCarServiceConnected(eCarXCar, this.mCarSignalManager);
/*     */           
/* 126 */           IConnectable.IConnectWatcher iConnectWatcher = this.mConnectWatcher; if (iConnectWatcher != null)
/*     */             try {
/* 128 */               this.mConnectWatcher.onConnected();
/* 129 */             } catch (Exception exception) {
/* 130 */               exception.printStackTrace();
/*     */             }  
/*     */         } 
/*     */       } 
/* 134 */     } catch (Exception exception) {
/* 135 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isECarXCarConnected() {
/* 145 */     synchronized (this.mECarXCarLock) {
/* 146 */       boolean bool; if (this.mECarXCar != null && this.mECarXCar.isConnected()) { bool = true; } else { bool = false; }
/*     */       
/* 148 */       return bool;
/*     */     } 
/*     */   }
/*     */   public void stopReconnection() {
/* 152 */     if (this.mCarHandler != null) {
/* 153 */       this.mCarHandler.removeMessages(1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ECarXCar getECarXCar() {
/* 161 */     synchronized (this.mECarXCarLock) {
/* 162 */       return this.mECarXCar;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarSignalManager getCarSignalManager() {
/* 170 */     return this.mCarSignalManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IECarXCar getCarService() {
/* 177 */     return this.mECarXCarService;
/*     */   }
/*     */   
/*     */   private void callECarXCarServiceDeath() {
/* 181 */     this.mCarHandler.removeMessages(2);
/*     */     
/* 183 */     if (this.mConnectWatcher != null) {
/*     */       try {
/* 185 */         this.mConnectWatcher.onDisConnected();
/* 186 */       } catch (Exception exception) {
/* 187 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 191 */     if (this.mProxyMethod != null) {
/* 192 */       this.mProxyMethod.onECarXCarServiceDeath();
/*     */     }
/*     */     
/* 195 */     synchronized (this.mECarXCarLock) {
/* 196 */       this.mECarXCar = null;
/* 197 */       this.mECarXCarService = null;
/*     */ 
/*     */       
/* 200 */       this.mCarHandler.sendEmptyMessageDelayed(1, 600L);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 209 */     this.mConnectWatcher = paramIConnectWatcher;
/*     */     
/* 211 */     if (this.mConnectWatcher != null && isECarXCarConnected()) {
/* 212 */       this.mCarHandler.sendEmptyMessage(2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 220 */     this.mConnectWatcher = null;
/*     */   }
/*     */   
/*     */   private class CarHandler
/*     */     extends Handler
/*     */   {
/*     */     static final int CAR_CONNECTED_MSG = 2;
/*     */     static final int INIT_CAR_SERVICE_MSG = 1;
/*     */     final ECarXCarProxy this$0;
/*     */     
/*     */     CarHandler(Looper param1Looper) {
/* 231 */       super(param1Looper);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 236 */       if (param1Message.what == 1) {
/* 237 */         ECarXCarProxy.this.initECarXCar();
/* 238 */       } else if (param1Message.what == 2 && 
/* 239 */         ECarXCarProxy.this.mConnectWatcher != null) {
/*     */         try {
/* 241 */           ECarXCarProxy.this.mConnectWatcher.onConnected();
/* 242 */         } catch (Exception exception) {
/* 243 */           exception.printStackTrace();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface ECarXCarProxyMethod {
/*     */     void onECarXCarServiceConnected(ECarXCar param1ECarXCar, CarSignalManager param1CarSignalManager);
/*     */     
/*     */     void onECarXCarServiceDeath();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ECarXCarProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */