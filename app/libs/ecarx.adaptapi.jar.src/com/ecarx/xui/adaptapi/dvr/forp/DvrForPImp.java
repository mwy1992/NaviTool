/*     */ package com.ecarx.xui.adaptapi.dvr.forp;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import com.ecarx.xui.adaptapi.dvr.ota.IOta;
/*     */ import com.ecarx.xui.adaptapi.dvr.ota.Ota;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DvrForPImp
/*     */   extends Dvr
/*     */   implements IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final String TAG = "DvrForPImp";
/*     */   private Context mContext;
/*     */   private DvrForPFunction mDvrForPFunction;
/*     */   private DvrForPInfo mDvrForPInfo;
/*     */   private DvrForPManager mDvrForPManager;
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */   private Ota mOta;
/*     */   
/*     */   private DvrForPImp(Context paramContext) {
/*  30 */     this.mContext = paramContext;
/*  31 */     this.mDvrForPInfo = new DvrForPInfo(paramContext);
/*  32 */     this.mDvrForPManager = new DvrForPManager(paramContext);
/*  33 */     this.mDvrForPFunction = new DvrForPFunction(paramContext);
/*  34 */     this.mOta = new Ota(paramContext);
/*     */     
/*  36 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/*  37 */     this.mECarXCarProxy.initECarXCar();
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
/*     */   public static Dvr create(Context paramContext) {
/*  50 */     DvrForPImp dvrForPImp = new DvrForPImp(paramContext);
/*  51 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("create: "); stringBuilder.append(dvrForPImp.toString()); Log.d("DvrForPImp", stringBuilder.toString());
/*  52 */     return dvrForPImp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDvrInfo getDvrInfos() {
/*  60 */     return this.mDvrForPInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDvrManager getDvrManager() {
/*  68 */     return this.mDvrForPManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDvrFunction getDvrFunction() {
/*  76 */     return this.mDvrForPFunction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOta getOta() {
/*  84 */     return (IOta)this.mOta;
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
/*  95 */     Log.i("DvrForPImp", "onECarXCarServiceConnected start ...");
/*  96 */     this.mDvrForPInfo.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  97 */     this.mDvrForPManager.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  98 */     this.mDvrForPFunction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  99 */     this.mOta.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 100 */     Log.i("DvrForPImp", "onECarXCarServiceConnected done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 108 */     Log.w("DvrForPImp", "onECarXCarServiceDeath start ...");
/* 109 */     this.mDvrForPInfo.onECarXCarServiceDeath();
/* 110 */     this.mDvrForPManager.onECarXCarServiceDeath();
/* 111 */     this.mDvrForPFunction.onECarXCarServiceDeath();
/* 112 */     this.mOta.onECarXCarServiceDeath();
/* 113 */     Log.w("DvrForPImp", "onECarXCarServiceDeath done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 123 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 131 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */   
/*     */   public void connect() {}
/*     */   
/*     */   public void disconnect() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\DvrForPImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */