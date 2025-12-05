/*     */ package com.ecarx.xui.adaptapi.navigation;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import com.ecarx.xui.adaptapi.navigation.dr.DrAutoByMapImpl;
/*     */ import com.ecarx.xui.adaptapi.navigation.dr.IDrAutoByFwk;
/*     */ import com.ecarx.xui.adaptapi.navigation.dr.IDrAutoByMap;
/*     */ import com.ecarx.xui.adaptapi.navigation.eco.ECONavigationImp;
/*     */ import com.ecarx.xui.adaptapi.navigation.eco.IECONavigation;
/*     */ import com.ecarx.xui.adaptapi.navigation.ehp.EHPImpl;
/*     */ import com.ecarx.xui.adaptapi.navigation.ehp.IEHP;
/*     */ import com.ecarx.xui.adaptapi.navigation.gps.IGCJLocation;
/*     */ import com.ecarx.xui.adaptapi.navigation.speed.ISpeed;
/*     */ import com.ecarx.xui.adaptapi.navigation.speed.SpeedImpl;
/*     */ import com.ecarx.xui.adaptapi.navigation.vcu.IVCUNavigation;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NavigationImp
/*     */   extends Navigation
/*     */   implements INavigation, IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final String TAG = "NavigationImp";
/*     */   private Context mContext;
/*     */   private DrAutoByMapImpl mDrAutoByMap;
/*     */   private ECONavigationImp mECONavigationImp;
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */   private IECarXCar mECarXCarService;
/*     */   private EHPImpl mEHPImpl;
/*  36 */   private final Object mNaviLock = new Object();
/*     */   
/*     */   private NavigationImp(Context paramContext) {
/*  39 */     this.mContext = paramContext;
/*  40 */     this.mSpeed = new SpeedImpl(this.mContext);
/*  41 */     this.mEHPImpl = new EHPImpl(this.mContext);
/*  42 */     this.mECONavigationImp = new ECONavigationImp(this.mContext);
/*  43 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/*  44 */     this.mECarXCarProxy.initECarXCar();
/*     */   }
/*     */   private SpeedImpl mSpeed;
/*     */   public static INavigation create(Context paramContext) {
/*  48 */     NavigationImp navigationImp = null;
/*  49 */     if (paramContext != null) {
/*  50 */       navigationImp = new NavigationImp(paramContext);
/*     */     }
/*  52 */     return navigationImp;
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
/*     */   public ISpeed getSpeedInfo() {
/*  66 */     return (ISpeed)this.mSpeed;
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
/*     */   public IDrAutoByFwk getDrAutoByFwk() {
/*  80 */     return null;
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
/*     */   public IDrAutoByMap getDrAutoByMap() {
/*  94 */     synchronized (this.mNaviLock) {
/*  95 */       if (this.mDrAutoByMap == null) {
/*  96 */         DrAutoByMapImpl drAutoByMapImpl = new DrAutoByMapImpl(); this(this.mContext); this.mDrAutoByMap = drAutoByMapImpl;
/*     */         
/*  98 */         if (this.mECarXCarProxy.isECarXCarConnected()) {
/*  99 */           this.mDrAutoByMap.initCarService(this.mECarXCarProxy.getCarService());
/*     */         }
/*     */       } 
/* 102 */       return (IDrAutoByMap)this.mDrAutoByMap;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IEHP getEHPManager() {
/* 113 */     return (IEHP)this.mEHPImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IECONavigation getECONavigation() {
/* 123 */     return (IECONavigation)this.mECONavigationImp;
/*     */   }
/*     */ 
/*     */   
/*     */   public IGCJLocation getGCJLocation() {
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IVCUNavigation getVCUNavigation() {
/* 138 */     return null;
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
/*     */     try {
/* 150 */       Log.i("NavigationImp", "onECarXCarServiceConnected");
/*     */ 
/*     */ 
/*     */       
/* 154 */       synchronized (this.mNaviLock)
/* 155 */       { if (this.mDrAutoByMap != null) {
/* 156 */           this.mDrAutoByMap.initCarService(this.mECarXCarProxy.getCarService());
/*     */         }
/*     */         
/* 159 */         this.mECONavigationImp.initCarSignalManager(paramECarXCar, paramCarSignalManager); } 
/* 160 */     } catch (Exception exception) {
/* 161 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 170 */     Log.w("NavigationImp", "onECarXCarServiceDeath");
/*     */ 
/*     */     
/* 173 */     this.mECarXCarService = null;
/* 174 */     synchronized (this.mNaviLock) {
/* 175 */       if (this.mDrAutoByMap != null) {
/* 176 */         this.mDrAutoByMap.onECarXCarServiceDeath();
/*     */       }
/*     */       
/* 179 */       this.mECONavigationImp.onECarXCarServiceDeath();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 189 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 197 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */   
/*     */   public void connect() {}
/*     */   
/*     */   public void disconnect() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\NavigationImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */