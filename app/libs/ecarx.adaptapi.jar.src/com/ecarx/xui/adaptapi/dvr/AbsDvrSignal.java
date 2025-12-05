/*    */ package com.ecarx.xui.adaptapi.dvr;
/*    */ 
/*    */ import android.car.CarNotConnectedException;
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ import ecarx.car.ECarXCar;
/*    */ import ecarx.car.XmaDvrManager;
/*    */ import ecarx.car.hardware.signal.CarSignalManager;
/*    */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*    */ import ecarx.car.hardware.vehicle.ECarXCarVfcipwakeupManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbsDvrSignal
/*    */   extends AbsCarSignal
/*    */ {
/*    */   private static final String TAG = "AbsDvrSignal";
/*    */   private ECarXCarVfcipwakeupManager mCarVfcipwakeupManager;
/*    */   private XmaDvrManager mXmaDvrManager;
/*    */   
/*    */   protected AbsDvrSignal(Context paramContext) {
/* 25 */     super(paramContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 36 */     super.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*    */     
/*    */     try {
/* 39 */       this.mXmaDvrManager = (XmaDvrManager)paramECarXCar.getCarManager("xma_dvr_service");
/*    */ 
/*    */       
/* 42 */       ECarXCarSetManager eCarXCarSetManager = (ECarXCarSetManager)paramECarXCar.getCarManager("car_publicattribute");
/*    */       
/* 44 */       this.mCarVfcipwakeupManager = eCarXCarSetManager.getECarXCarVfcipwakeupManager();
/* 45 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 46 */       carNotConnectedException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int sendSignal(int paramInt1, int paramInt2) {
/* 58 */     return sendSignal(paramInt1, paramInt2, 1500);
/*    */   }
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
/*    */   public int sendSignal(int paramInt1, int paramInt2, int paramInt3) {
/* 71 */     boolean bool = false;
/*    */     
/*    */     try {
/* 74 */       paramInt1 = this.mXmaDvrManager.sendSignal(paramInt1, paramInt2, paramInt3);
/* 75 */     } catch (Exception exception) {
/* 76 */       exception.printStackTrace(); paramInt1 = bool;
/*    */     } 
/*    */     
/* 79 */     return paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean checkActivateDvrVfc(int paramInt) {
/* 90 */     boolean bool = false;
/*    */     
/*    */     try {
/* 93 */       boolean bool1 = this.mXmaDvrManager.checkActivateDvrVfc(paramInt);
/* 94 */     } catch (Exception exception) {
/* 95 */       exception.printStackTrace();
/*    */     } 
/*    */     
/* 98 */     return bool;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\AbsDvrSignal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */