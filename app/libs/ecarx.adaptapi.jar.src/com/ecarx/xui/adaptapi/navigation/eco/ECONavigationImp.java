/*    */ package com.ecarx.xui.adaptapi.navigation.eco;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import ecarx.car.hardware.signal.CarSignalManager;
/*    */ 
/*    */ public class ECONavigationImp
/*    */   extends AbsCarSignal implements IECONavigation {
/*    */   public ECONavigationImp(Context paramContext) {
/* 11 */     super(paramContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FunctionStatus isECONavigationSupported() {
/* 19 */     return FunctionStatus.active;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateRoadConditionInfo(IECONavigation.IRoadConditionInfo paramIRoadConditionInfo) {
/* 30 */     this.mCarSignalManager.setNextRoadcongestionLvl(paramIRoadConditionInfo.getNextRoadCongestionLevel());
/*    */     
/* 32 */     this.mCarSignalManager.setDstToNextCongestionRrd(paramIRoadConditionInfo.getDistanceToNextCongestionRoad() / 100);
/*    */     
/* 34 */     this.mCarSignalManager.setNextRoadCongestionLen(paramIRoadConditionInfo.getNextCongestionRoadLength() / 100);
/*    */     
/* 36 */     this.mCarSignalManager.setNextRoadCongestionPassTi(paramIRoadConditionInfo.getNextCongestionRoadPassTime());
/*    */     
/* 38 */     this.mCarSignalManager.setCurrentRoadcongestionLvl(paramIRoadConditionInfo.getCurrentRoadCongestionLevel());
/*    */     
/* 40 */     CarSignalManager carSignalManager = this.mCarSignalManager;
/* 41 */     int i = paramIRoadConditionInfo.getCurrentRoadCongestionLength() / 100;
/*    */     carSignalManager.setCurrentRoadcongestionLength(i);
/* 43 */     this.mCarSignalManager.setCurrentRoadCongstionPassTime(paramIRoadConditionInfo.getCurrentRoadPassTime());
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\eco\ECONavigationImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */