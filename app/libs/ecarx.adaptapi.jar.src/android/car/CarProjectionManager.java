/*     */ package android.car;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.content.Intent;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import java.lang.ref.WeakReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SystemApi
/*     */ public final class CarProjectionManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   public static final int PROJECTION_LONG_PRESS_VOICE_SEARCH = 2;
/*     */   public static final int PROJECTION_VOICE_SEARCH = 1;
/*     */   private final ICarProjectionCallbackImpl mBinderListener;
/*     */   private final Handler mHandler;
/*     */   private CarProjectionListener mListener;
/*     */   private final ICarProjection mService;
/*     */   private int mVoiceSearchFilter;
/*     */   
/*     */   CarProjectionManager(IBinder paramIBinder, Handler paramHandler) {
/*  66 */     this.mService = ICarProjection.Stub.asInterface(paramIBinder);
/*  67 */     this.mHandler = paramHandler;
/*  68 */     this.mBinderListener = new ICarProjectionCallbackImpl(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void regsiterProjectionListener(CarProjectionListener paramCarProjectionListener, int paramInt) throws CarNotConnectedException {
/*  78 */     registerProjectionListener(paramCarProjectionListener, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerProjectionListener(CarProjectionListener paramCarProjectionListener, int paramInt) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 70
/*     */     //   4: aload_0
/*     */     //   5: monitorenter
/*     */     //   6: aload_0
/*     */     //   7: getfield mListener : Landroid/car/CarProjectionManager$CarProjectionListener;
/*     */     //   10: ifnull -> 23
/*     */     //   13: aload_0
/*     */     //   14: getfield mVoiceSearchFilter : I
/*     */     //   17: istore_3
/*     */     //   18: iload_3
/*     */     //   19: iload_2
/*     */     //   20: if_icmpeq -> 37
/*     */     //   23: aload_0
/*     */     //   24: getfield mService : Landroid/car/ICarProjection;
/*     */     //   27: aload_0
/*     */     //   28: getfield mBinderListener : Landroid/car/CarProjectionManager$ICarProjectionCallbackImpl;
/*     */     //   31: iload_2
/*     */     //   32: invokeinterface registerProjectionListener : (Landroid/car/ICarProjectionCallback;I)V
/*     */     //   37: aload_0
/*     */     //   38: aload_1
/*     */     //   39: putfield mListener : Landroid/car/CarProjectionManager$CarProjectionListener;
/*     */     //   42: aload_0
/*     */     //   43: iload_2
/*     */     //   44: putfield mVoiceSearchFilter : I
/*     */     //   47: aload_0
/*     */     //   48: monitorexit
/*     */     //   49: return
/*     */     //   50: astore_1
/*     */     //   51: new android/car/CarNotConnectedException
/*     */     //   54: astore #4
/*     */     //   56: aload #4
/*     */     //   58: aload_1
/*     */     //   59: invokespecial <init> : (Ljava/lang/Exception;)V
/*     */     //   62: aload #4
/*     */     //   64: athrow
/*     */     //   65: astore_1
/*     */     //   66: aload_0
/*     */     //   67: monitorexit
/*     */     //   68: aload_1
/*     */     //   69: athrow
/*     */     //   70: new java/lang/IllegalArgumentException
/*     */     //   73: dup
/*     */     //   74: ldc 'null listener'
/*     */     //   76: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   79: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #90	-> 0
/*     */     //   #93	-> 4
/*     */     //   #94	-> 6
/*     */     //   #96	-> 23
/*     */     //   #99	-> 37
/*     */     //   #101	-> 37
/*     */     //   #102	-> 42
/*     */     //   #103	-> 47
/*     */     //   #104	-> 49
/*     */     //   #97	-> 50
/*     */     //   #98	-> 51
/*     */     //   #103	-> 65
/*     */     //   #91	-> 70
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	18	65	finally
/*     */     //   23	37	50	android/os/RemoteException
/*     */     //   23	37	65	finally
/*     */     //   37	42	65	finally
/*     */     //   42	47	65	finally
/*     */     //   47	49	65	finally
/*     */     //   51	65	65	finally
/*     */     //   66	68	65	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregsiterProjectionListener() {
/* 112 */     unregisterProjectionListener();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterProjectionListener() {
/*     */     /* monitor enter ThisExpression{ObjectType{android/car/CarProjectionManager}} */
/*     */     
/* 122 */     try { this.mService.unregisterProjectionListener(this.mBinderListener); }
/* 123 */     catch (RemoteException remoteException) {  }
/*     */     finally
/*     */     { Exception exception; }
/* 126 */      this.mListener = null;
/* 127 */     this.mVoiceSearchFilter = 0;
/*     */     /* monitor exit ThisExpression{ObjectType{android/car/CarProjectionManager}} */
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerProjectionRunner(Intent paramIntent) throws CarNotConnectedException {
/*     */     /* monitor enter ThisExpression{ObjectType{android/car/CarProjectionManager}} */
/* 138 */     if (paramIntent != null) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 143 */         this.mService.registerProjectionRunner(paramIntent); /* monitor exit ThisExpression{ObjectType{android/car/CarProjectionManager}} */ return;
/* 144 */       } catch (RemoteException remoteException) {
/* 145 */         CarNotConnectedException carNotConnectedException = new CarNotConnectedException(); this((Exception)remoteException); throw carNotConnectedException;
/*     */       } finally {} /* monitor exit ThisExpression{ObjectType{android/car/CarProjectionManager}} */
/* 147 */       throw paramIntent;
/*     */     } 
/*     */     throw new IllegalArgumentException("null serviceIntent");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterProjectionRunner(Intent paramIntent) {
/*     */     /* monitor enter ThisExpression{ObjectType{android/car/CarProjectionManager}} */
/* 157 */     if (paramIntent != null) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 162 */         this.mService.unregisterProjectionRunner(paramIntent);
/* 163 */       } catch (RemoteException remoteException) {
/*     */       
/*     */       } finally {}
/*     */       /* monitor exit ThisExpression{ObjectType{android/car/CarProjectionManager}} */
/*     */       return;
/*     */     } 
/*     */     throw new IllegalArgumentException("null serviceIntent");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {}
/*     */   
/*     */   private void handleVoiceAssistantRequest(boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mListener : Landroid/car/CarProjectionManager$CarProjectionListener;
/*     */     //   6: ifnonnull -> 12
/*     */     //   9: aload_0
/*     */     //   10: monitorexit
/*     */     //   11: return
/*     */     //   12: aload_0
/*     */     //   13: getfield mListener : Landroid/car/CarProjectionManager$CarProjectionListener;
/*     */     //   16: astore_2
/*     */     //   17: aload_0
/*     */     //   18: monitorexit
/*     */     //   19: aload_2
/*     */     //   20: iload_1
/*     */     //   21: invokeinterface onVoiceAssistantRequest : (Z)V
/*     */     //   26: return
/*     */     //   27: astore_2
/*     */     //   28: aload_0
/*     */     //   29: monitorexit
/*     */     //   30: aload_2
/*     */     //   31: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #176	-> 0
/*     */     //   #177	-> 2
/*     */     //   #178	-> 9
/*     */     //   #180	-> 12
/*     */     //   #181	-> 17
/*     */     //   #182	-> 19
/*     */     //   #183	-> 26
/*     */     //   #181	-> 27
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	27	finally
/*     */     //   9	11	27	finally
/*     */     //   12	17	27	finally
/*     */     //   17	19	27	finally
/*     */     //   28	30	27	finally
/*     */   }
/*     */   
/*     */   public static interface CarProjectionListener
/*     */   {
/*     */     void onVoiceAssistantRequest(boolean param1Boolean);
/*     */   }
/*     */   
/*     */   private static class ICarProjectionCallbackImpl
/*     */     extends ICarProjectionCallback.Stub
/*     */   {
/*     */     private final WeakReference<CarProjectionManager> mManager;
/*     */     
/*     */     private ICarProjectionCallbackImpl(CarProjectionManager param1CarProjectionManager) {
/* 190 */       this.mManager = new WeakReference<>(param1CarProjectionManager);
/*     */     }
/*     */     
/*     */     public void onVoiceAssistantRequest(final boolean fromLongPress)
/*     */     {
/* 195 */       final CarProjectionManager manager = this.mManager.get();
/* 196 */       if (carProjectionManager == null) {
/*     */         return;
/*     */       }
/* 199 */       carProjectionManager.mHandler.post(new Runnable() { final CarProjectionManager.ICarProjectionCallbackImpl this$0; final boolean val$fromLongPress;
/*     */             final CarProjectionManager val$manager;
/*     */             
/* 202 */             public void run() { manager.handleVoiceAssistantRequest(fromLongPress); } }); } } class null implements Runnable { public void run() { manager.handleVoiceAssistantRequest(fromLongPress); }
/*     */ 
/*     */     
/*     */     final CarProjectionManager.ICarProjectionCallbackImpl this$0;
/*     */     final boolean val$fromLongPress;
/*     */     final CarProjectionManager val$manager; }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\CarProjectionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */