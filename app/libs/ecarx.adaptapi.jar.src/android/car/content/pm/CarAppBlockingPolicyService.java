/*    */ package android.car.content.pm;
/*    */ 
/*    */ import android.annotation.SystemApi;
/*    */ import android.app.Service;
/*    */ import android.content.Intent;
/*    */ import android.os.Handler;
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
/*    */ @SystemApi
/*    */ public abstract class CarAppBlockingPolicyService
/*    */   extends Service
/*    */ {
/*    */   public static final String SERVICE_INTERFACE = "android.car.content.pm.CarAppBlockingPolicyService";
/* 38 */   private static final String TAG = CarAppBlockingPolicyService.class.getSimpleName();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   private final ICarAppBlockingPoicyImpl mBinder = new ICarAppBlockingPoicyImpl();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Handler mHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
/* 54 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public IBinder onBind(Intent paramIntent) {
/* 59 */     Log.i(TAG, "onBind");
/* 60 */     return (IBinder)this.mBinder;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onUnbind(Intent paramIntent) {
/* 65 */     Log.i(TAG, "onUnbind");
/* 66 */     stopSelf();
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   protected abstract CarAppBlockingPolicy getAppBlockingPolicy();
/*    */   
/*    */   private class ICarAppBlockingPoicyImpl
/*    */     extends ICarAppBlockingPolicy.Stub {
/*    */     public void setAppBlockingPolicySetter(ICarAppBlockingPolicySetter param1ICarAppBlockingPolicySetter) {
/* 75 */       Log.i(CarAppBlockingPolicyService.TAG, "setAppBlockingPolicySetter will set policy");
/* 76 */       CarAppBlockingPolicy carAppBlockingPolicy = CarAppBlockingPolicyService.this.getAppBlockingPolicy();
/*    */       try {
/* 78 */         param1ICarAppBlockingPolicySetter.setAppBlockingPolicy(carAppBlockingPolicy);
/* 79 */       } catch (RemoteException remoteException) {}
/*    */     }
/*    */     
/*    */     final CarAppBlockingPolicyService this$0;
/*    */     
/*    */     private ICarAppBlockingPoicyImpl() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\content\pm\CarAppBlockingPolicyService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */