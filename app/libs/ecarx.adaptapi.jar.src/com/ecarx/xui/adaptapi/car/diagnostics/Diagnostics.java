/*    */ package com.ecarx.xui.adaptapi.car.diagnostics;
/*    */ 
/*    */ import android.content.Context;
/*    */ import ecarx.car.ECarXCar;
/*    */ import ecarx.car.hardware.signal.CarSignalManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Diagnostics
/*    */   implements IDiagnostics
/*    */ {
/*    */   private final BtDebug mBtDebug;
/*    */   private final DiagnosticMonitor mDiagnosticMonitor;
/*    */   private final DtcManager mDtcManager;
/*    */   private final PartInfos mPartInfos;
/*    */   private final ShCommand mShCommand;
/*    */   
/*    */   public Diagnostics(Context paramContext) {
/* 38 */     this.mShCommand = new ShCommand();
/* 39 */     this.mDtcManager = new DtcManager(paramContext);
/* 40 */     this.mDiagnosticMonitor = new DiagnosticMonitor(paramContext);
/* 41 */     this.mPartInfos = new PartInfos();
/* 42 */     this.mBtDebug = new BtDebug();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 52 */     this.mDtcManager.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onECarXCarServiceDeath() {
/* 59 */     this.mDtcManager.onECarXCarServiceDeath();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IShCommand getShCommandManager() {
/* 67 */     return this.mShCommand;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IDtcManager getDtcManager() {
/* 75 */     return this.mDtcManager;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IDiagnosticMonitor getDiagMonitor() {
/* 83 */     return this.mDiagnosticMonitor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IPartInfos getPartInfoManager() {
/* 91 */     return this.mPartInfos;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IBtDebug getBtDebug() {
/* 99 */     return this.mBtDebug;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\Diagnostics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */