/*     */ package com.ecarx.xui.adaptapi.dvr;
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
/*     */ public class DvrImp
/*     */   extends Dvr
/*     */   implements IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final String TAG = "DvrImp";
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */   private final Operation mOperation;
/*     */   private final Ota mOta;
/*     */   private final Settings mSettings;
/*     */   
/*     */   private DvrImp(Context paramContext) {
/*  28 */     this.mOperation = new Operation(paramContext);
/*  29 */     this.mSettings = new Settings(paramContext);
/*  30 */     this.mOta = new Ota(paramContext);
/*     */     
/*  32 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/*  33 */     this.mECarXCarProxy.initECarXCar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Dvr create(Context paramContext) {
/*  44 */     return new DvrImp(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISettings getSettings() {
/*  53 */     return this.mSettings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOperation getOperation() {
/*  62 */     return this.mOperation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOta getOta() {
/*  71 */     return (IOta)this.mOta;
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
/*  82 */     Log.i("DvrImp", "onECarXCarServiceConnected start ...");
/*  83 */     this.mOperation.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  84 */     this.mSettings.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  85 */     this.mOta.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  86 */     Log.i("DvrImp", "onECarXCarServiceConnected done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/*  94 */     Log.w("DvrImp", "onECarXCarServiceDeath start ...");
/*  95 */     this.mOperation.onECarXCarServiceDeath();
/*  96 */     this.mSettings.onECarXCarServiceDeath();
/*  97 */     this.mOta.onECarXCarServiceDeath();
/*  98 */     Log.w("DvrImp", "onECarXCarServiceDeath done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 108 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 116 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */   
/*     */   public void connect() {}
/*     */   
/*     */   public void disconnect() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\DvrImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */