/*    */ package android.car.settings;
/*    */ 
/*    */ import android.car.CarManagerBase;
/*    */ import android.car.CarNotConnectedException;
/*    */ import android.os.IBinder;
/*    */ import android.os.RemoteException;
/*    */ import android.util.Log;
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
/*    */ public class CarConfigurationManager
/*    */   implements CarManagerBase
/*    */ {
/*    */   private static final String TAG = "CarConfigurationManager";
/*    */   private final ICarConfigurationManager mConfigurationService;
/*    */   
/*    */   public CarConfigurationManager(IBinder paramIBinder) {
/* 35 */     this.mConfigurationService = ICarConfigurationManager.Stub.asInterface(paramIBinder);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SpeedBumpConfiguration getSpeedBumpConfiguration() throws CarNotConnectedException {
/*    */     try {
/* 46 */       return this.mConfigurationService.getSpeedBumpConfiguration();
/* 47 */     } catch (RemoteException remoteException) {
/* 48 */       Log.e("CarConfigurationManager", "Could not retrieve SpeedBumpConfiguration", (Throwable)remoteException);
/* 49 */       throw new CarNotConnectedException(remoteException);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onCarDisconnected() {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\settings\CarConfigurationManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */