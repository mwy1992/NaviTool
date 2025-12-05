/*    */ package android.car.test;
/*    */ 
/*    */ import android.annotation.SystemApi;
/*    */ import android.car.CarManagerBase;
/*    */ import android.os.IBinder;
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
/*    */ public class CarTestManagerBinderWrapper
/*    */   implements CarManagerBase
/*    */ {
/*    */   public final IBinder binder;
/*    */   
/*    */   public CarTestManagerBinderWrapper(IBinder paramIBinder) {
/* 31 */     this.binder = paramIBinder;
/*    */   }
/*    */   
/*    */   public void onCarDisconnected() {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\test\CarTestManagerBinderWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */