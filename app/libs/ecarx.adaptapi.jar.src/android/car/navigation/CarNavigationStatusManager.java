/*    */ package android.car.navigation;
/*    */ 
/*    */ import android.car.CarApiUtil;
/*    */ import android.car.CarManagerBase;
/*    */ import android.car.CarNotConnectedException;
/*    */ import android.car.cluster.renderer.IInstrumentClusterNavigation;
/*    */ import android.os.Bundle;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CarNavigationStatusManager
/*    */   implements CarManagerBase
/*    */ {
/*    */   private static final String TAG = "CAR.L.NAV";
/*    */   private final IInstrumentClusterNavigation mService;
/*    */   
/*    */   public CarNavigationStatusManager(IBinder paramIBinder) {
/* 41 */     this.mService = IInstrumentClusterNavigation.Stub.asInterface(paramIBinder);
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
/*    */   
/*    */   public void sendEvent(int paramInt, Bundle paramBundle) throws CarNotConnectedException {
/*    */     try {
/* 56 */       this.mService.onEvent(paramInt, paramBundle);
/* 57 */     } catch (IllegalStateException illegalStateException) {
/* 58 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 59 */     } catch (RemoteException remoteException) {
/* 60 */       handleCarServiceRemoteExceptionAndThrow(remoteException);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onCarDisconnected() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public CarNavigationInstrumentCluster getInstrumentClusterInfo() throws CarNotConnectedException {
/*    */     try {
/* 72 */       return this.mService.getInstrumentClusterInfo();
/* 73 */     } catch (RemoteException remoteException) {
/* 74 */       handleCarServiceRemoteExceptionAndThrow(remoteException);
/*    */       
/* 76 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   private void handleCarServiceRemoteExceptionAndThrow(RemoteException paramRemoteException) throws CarNotConnectedException {
/* 81 */     handleCarServiceRemoteException(paramRemoteException);
/* 82 */     throw new CarNotConnectedException();
/*    */   }
/*    */   
/*    */   private void handleCarServiceRemoteException(RemoteException paramRemoteException) {
/* 86 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("RemoteException from car service:"); stringBuilder.append(paramRemoteException.getMessage()); Log.w("CAR.L.NAV", stringBuilder.toString());
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\navigation\CarNavigationStatusManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */