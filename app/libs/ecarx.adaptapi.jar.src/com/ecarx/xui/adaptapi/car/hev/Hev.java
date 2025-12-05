/*    */ package com.ecarx.xui.adaptapi.car.hev;
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
/*    */ public class Hev
/*    */   implements IHev
/*    */ {
/*    */   private final Charging mCharging;
/*    */   private final TripData mTripData;
/*    */   
/*    */   public Hev(Context paramContext) {
/* 24 */     this.mTripData = new TripData(paramContext);
/* 25 */     this.mCharging = new Charging(paramContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 35 */     this.mTripData.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 36 */     this.mCharging.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 37 */     this.mCharging.registerAllSignal();
/* 38 */     this.mTripData.registerAllSignal();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onECarXCarServiceDeath() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ITripData getTripData() {
/* 53 */     return this.mTripData;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ICharging getChargingManager() {
/* 61 */     return this.mCharging;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ISuperHybrid getSuperHybridManager() {
/* 69 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\Hev.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */