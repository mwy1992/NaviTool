/*    */ package ecarx.car;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Handler;
/*    */ import android.os.IBinder;
/*    */ import android.util.Log;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmaDvrManager
/*    */   implements ECarXCarManagerBase
/*    */ {
/*    */   public static final int FAIL = 0;
/*    */   public static final int SUCCESS = 1;
/*    */   private static final String TAG = "XmaDvrManager";
/*    */   public static final int TIMEOUT = 2;
/*    */   private IXmaDvrService mXmaDvrService;
/*    */   
/*    */   public XmaDvrManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/* 22 */     this.mXmaDvrService = IXmaDvrService.Stub.asInterface(paramIBinder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCarDisconnected() {
/* 27 */     Log.w("XmaDvrManager", "onCarDisconnected");
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
/* 38 */     return sendSignal(paramInt1, paramInt2, 1500);
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
/*    */   public int sendSignal(int paramInt1, int paramInt2, int paramInt3) {
/* 52 */     boolean bool = false;
/*    */     
/*    */     try {
/* 55 */       paramInt1 = this.mXmaDvrService.sendSignal(paramInt1, paramInt2, paramInt3);
/* 56 */     } catch (Exception exception) {
/* 57 */       exception.printStackTrace(); paramInt1 = bool;
/*    */     } 
/*    */     
/* 60 */     return paramInt1;
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
/* 71 */     boolean bool1, bool2 = false;
/*    */     
/*    */     try {
/* 74 */       bool1 = this.mXmaDvrService.checkActivateDvrVfc(paramInt);
/* 75 */     } catch (Exception exception) {
/* 76 */       exception.printStackTrace(); bool1 = bool2;
/*    */     } 
/*    */     
/* 79 */     return bool1;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\XmaDvrManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */