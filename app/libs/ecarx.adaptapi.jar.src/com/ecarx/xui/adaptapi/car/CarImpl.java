/*     */ package com.ecarx.xui.adaptapi.car;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import com.ecarx.xui.adaptapi.car.base.CarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.base.CarInfo;
/*     */ import com.ecarx.xui.adaptapi.car.base.ICarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.base.ICarInfo;
/*     */ import com.ecarx.xui.adaptapi.car.diagnostics.Diagnostics;
/*     */ import com.ecarx.xui.adaptapi.car.diagnostics.IDiagnostics;
/*     */ import com.ecarx.xui.adaptapi.car.hev.Hev;
/*     */ import com.ecarx.xui.adaptapi.car.hev.IHev;
/*     */ import com.ecarx.xui.adaptapi.car.roadpath.IRoadPath;
/*     */ import com.ecarx.xui.adaptapi.car.sensor.ISensor;
/*     */ import com.ecarx.xui.adaptapi.car.sensor.SensorNew;
/*     */ import com.ecarx.xui.adaptapi.car.userprofile.CarKey;
/*     */ import com.ecarx.xui.adaptapi.car.userprofile.ICarKey;
/*     */ import com.ecarx.xui.adaptapi.car.userprofile.IUserProfile;
/*     */ import com.ecarx.xui.adaptapi.car.userprofile.UserProfile;
/*     */ import com.ecarx.xui.adaptapi.utils.Authority;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ 
/*     */ public class CarImpl
/*     */   implements ICar, IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   @GuardedBy("mCarManagerLock")
/*     */   private CarFunction mCarFunction;
/*     */   @GuardedBy("mCarManagerLock")
/*     */   private CarInfo mCarInfo;
/*     */   @GuardedBy("mCarManagerLock")
/*     */   private CarKey mCarKey;
/*  35 */   private final Object mCarManagerLock = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Context mContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GuardedBy("mCarManagerLock")
/*     */   private Diagnostics mDiagnostics;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GuardedBy("mCarManagerLock")
/*     */   private Hev mHev;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GuardedBy("mCarManagerLock")
/*     */   private SensorNew mSensor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GuardedBy("mCarManagerLock")
/*     */   private UserProfile mUserProfile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CarImpl(Context paramContext) {
/*  85 */     this.mContext = paramContext;
/*  86 */     this.mECarXCarProxy = new ECarXCarProxy(this.mContext, this);
/*  87 */     this.mECarXCarProxy.initECarXCar();
/*     */   }
/*     */   
/*     */   public static ICar create(Context paramContext) {
/*  91 */     CarImpl carImpl = null;
/*  92 */     if (paramContext != null) {
/*  93 */       Authority.verifyAuthority(paramContext);
/*  94 */       carImpl = new CarImpl(paramContext);
/*     */     } 
/*  96 */     return carImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICarFunction getICarFunction() {
/* 104 */     synchronized (this.mCarManagerLock) {
/* 105 */       if (this.mCarFunction == null) {
/* 106 */         CarFunction carFunction = new CarFunction(); this(this.mContext); this.mCarFunction = carFunction;
/*     */         
/* 108 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/* 109 */           carFunction = this.mCarFunction; ECarXCar eCarXCar = this.mECarXCarProxy.getECarXCar(); ECarXCarProxy eCarXCarProxy = this.mECarXCarProxy;
/* 110 */           CarSignalManager carSignalManager = eCarXCarProxy.getCarSignalManager(); carFunction.initCarSignalManager(eCarXCar, carSignalManager);
/*     */         } 
/*     */       } 
/* 113 */       return (ICarFunction)this.mCarFunction;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISensor getSensorManager() {
/* 122 */     synchronized (this.mCarManagerLock) {
/* 123 */       if (this.mSensor == null) {
/* 124 */         SensorNew sensorNew = new SensorNew(); this(this.mContext); this.mSensor = sensorNew;
/*     */         
/* 126 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/* 127 */           SensorNew sensorNew1 = this.mSensor; ECarXCar eCarXCar = this.mECarXCarProxy.getECarXCar(); ECarXCarProxy eCarXCarProxy = this.mECarXCarProxy;
/* 128 */           CarSignalManager carSignalManager = eCarXCarProxy.getCarSignalManager();
/*     */           sensorNew1.initCarSignalManager(eCarXCar, carSignalManager);
/*     */         } 
/*     */       } 
/* 132 */       return (ISensor)this.mSensor;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IHev getHevManager() {
/* 141 */     synchronized (this.mCarManagerLock) {
/* 142 */       if (this.mHev == null) {
/* 143 */         Hev hev = new Hev(); this(this.mContext); this.mHev = hev;
/*     */         
/* 145 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/* 146 */           hev = this.mHev; ECarXCar eCarXCar = this.mECarXCarProxy.getECarXCar(); ECarXCarProxy eCarXCarProxy = this.mECarXCarProxy;
/* 147 */           CarSignalManager carSignalManager = eCarXCarProxy.getCarSignalManager();
/*     */           hev.initCarSignalManager(eCarXCar, carSignalManager);
/*     */         } 
/*     */       } 
/* 151 */       return (IHev)this.mHev;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IRoadPath getRoadPathManager() {
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICarInfo getCarInfoManager() {
/* 168 */     synchronized (this.mCarManagerLock) {
/* 169 */       if (this.mCarInfo == null) {
/* 170 */         CarInfo carInfo = new CarInfo(); this(this.mContext); this.mCarInfo = carInfo;
/*     */         
/* 172 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/* 173 */           carInfo = this.mCarInfo; ECarXCar eCarXCar = this.mECarXCarProxy.getECarXCar(); ECarXCarProxy eCarXCarProxy = this.mECarXCarProxy;
/* 174 */           CarSignalManager carSignalManager = eCarXCarProxy.getCarSignalManager();
/*     */           carInfo.initCarSignalManager(eCarXCar, carSignalManager);
/*     */         } 
/*     */       } 
/* 178 */       return (ICarInfo)this.mCarInfo;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDiagnostics getDiagnosticManager() {
/* 187 */     synchronized (this.mCarManagerLock) {
/* 188 */       if (this.mDiagnostics == null) {
/* 189 */         Diagnostics diagnostics = new Diagnostics(); this(this.mContext); this.mDiagnostics = diagnostics;
/*     */         
/* 191 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/* 192 */           diagnostics = this.mDiagnostics; ECarXCar eCarXCar = this.mECarXCarProxy.getECarXCar(); ECarXCarProxy eCarXCarProxy = this.mECarXCarProxy;
/* 193 */           CarSignalManager carSignalManager = eCarXCarProxy.getCarSignalManager();
/*     */           diagnostics.initCarSignalManager(eCarXCar, carSignalManager);
/*     */         } 
/*     */       } 
/* 197 */       return (IDiagnostics)this.mDiagnostics;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IUserProfile getUserProfileManager() {
/* 206 */     synchronized (this.mCarManagerLock) {
/* 207 */       if (this.mUserProfile == null) {
/* 208 */         UserProfile userProfile = new UserProfile(); this(this.mContext); this.mUserProfile = userProfile;
/*     */         
/* 210 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/* 211 */           UserProfile userProfile1 = this.mUserProfile; ECarXCar eCarXCar = this.mECarXCarProxy.getECarXCar(); ECarXCarProxy eCarXCarProxy = this.mECarXCarProxy;
/* 212 */           CarSignalManager carSignalManager = eCarXCarProxy.getCarSignalManager();
/*     */           userProfile1.initCarSignalManager(eCarXCar, carSignalManager);
/*     */         } 
/*     */       } 
/* 216 */       return (IUserProfile)this.mUserProfile;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICarKey getCarKeyManager() {
/* 225 */     synchronized (this.mCarManagerLock) {
/* 226 */       if (this.mCarKey == null) {
/* 227 */         CarKey carKey = new CarKey(); this(this.mContext); this.mCarKey = carKey;
/*     */         
/* 229 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/* 230 */           carKey = this.mCarKey; ECarXCar eCarXCar = this.mECarXCarProxy.getECarXCar(); ECarXCarProxy eCarXCarProxy = this.mECarXCarProxy;
/* 231 */           CarSignalManager carSignalManager = eCarXCarProxy.getCarSignalManager();
/*     */           carKey.initCarSignalManager(eCarXCar, carSignalManager);
/*     */         } 
/*     */       } 
/* 235 */       return (ICarKey)this.mCarKey;
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
/*     */   public void onECarXCarServiceConnected(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 247 */     synchronized (this.mCarManagerLock) {
/* 248 */       if (this.mCarFunction != null) {
/* 249 */         this.mCarFunction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */       }
/*     */       
/* 252 */       if (this.mSensor != null) {
/* 253 */         this.mSensor.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */       }
/*     */       
/* 256 */       if (this.mHev != null) {
/* 257 */         this.mHev.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */       }
/*     */       
/* 260 */       if (this.mCarInfo != null) {
/* 261 */         this.mCarInfo.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */       }
/*     */       
/* 264 */       if (this.mDiagnostics != null) {
/* 265 */         this.mDiagnostics.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */       }
/*     */       
/* 268 */       if (this.mUserProfile != null) {
/* 269 */         this.mUserProfile.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */       }
/*     */       
/* 272 */       if (this.mCarKey != null) {
/* 273 */         this.mCarKey.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 283 */     synchronized (this.mCarManagerLock) {
/* 284 */       if (this.mCarFunction != null) {
/* 285 */         this.mCarFunction.onECarXCarServiceDeath();
/*     */       }
/*     */       
/* 288 */       if (this.mSensor != null) {
/* 289 */         this.mSensor.onECarXCarServiceDeath();
/*     */       }
/*     */       
/* 292 */       if (this.mHev != null) {
/* 293 */         this.mHev.onECarXCarServiceDeath();
/*     */       }
/*     */       
/* 296 */       if (this.mCarInfo != null) {
/* 297 */         this.mCarInfo.onECarXCarServiceDeath();
/*     */       }
/*     */       
/* 300 */       if (this.mDiagnostics != null) {
/* 301 */         this.mDiagnostics.onECarXCarServiceDeath();
/*     */       }
/*     */       
/* 304 */       if (this.mUserProfile != null) {
/* 305 */         this.mUserProfile.onECarXCarServiceDeath();
/*     */       }
/*     */       
/* 308 */       if (this.mCarKey != null) {
/* 309 */         this.mCarKey.onECarXCarServiceDeath();
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 321 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 329 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */   
/*     */   public void connect() {}
/*     */   
/*     */   public void disconnect() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\CarImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */