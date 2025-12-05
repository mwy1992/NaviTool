/*    */ package com.ecarx.xui.adaptapi.car.hev;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.util.Log;
/*    */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*    */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*    */ import java.util.Calendar;
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
/*    */ public class SuperHybrid
/*    */   extends AbsCarFunction
/*    */   implements ISuperHybrid
/*    */ {
/*    */   private static final String TAG = "SuperHybrid";
/*    */   
/*    */   public SuperHybrid(Context paramContext) {
/* 28 */     super(paramContext, 822083584);
/* 29 */     Log.d("SuperHybrid", "SuperHybrid: SuperHybrid");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void buildFunctions() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean setBookChargingTime(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt1, int paramInt2, int paramInt3) {
/* 46 */     Log.d("SuperHybrid", "setBookChargingTime: ");
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean requestRemoteBookChargingTime() {
/* 52 */     Log.d("SuperHybrid", "requestRemoteBookChargingTime: ");
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean addSuperHybridListener(ISuperHybrid.ISuperHybridListener paramISuperHybridListener) {
/* 58 */     Log.d("SuperHybrid", "addSuperHybridListener: ");
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean removeSuperHybridListener(ISuperHybrid.ISuperHybridListener paramISuperHybridListener) {
/* 64 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\SuperHybrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */