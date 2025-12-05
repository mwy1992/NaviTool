/*     */ package android.car.drivingstate;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
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
/*     */ @SystemApi
/*     */ public final class CarDrivingStateManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   private static final int MSG_HANDLE_DRIVING_STATE_CHANGE = 0;
/*     */   private static final String TAG = "CarDrivingStateMgr";
/*     */   private static final boolean VDBG = false;
/*     */   private final Context mContext;
/*     */   private final ICarDrivingState mDrivingService;
/*     */   private CarDrivingStateEventListener mDrvStateEventListener;
/*     */   private final EventCallbackHandler mEventCallbackHandler;
/*     */   private CarDrivingStateChangeListenerToService mListenerToService;
/*     */   
/*     */   public CarDrivingStateManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/*  55 */     this.mContext = paramContext;
/*  56 */     this.mDrivingService = ICarDrivingState.Stub.asInterface(paramIBinder);
/*  57 */     this.mEventCallbackHandler = new EventCallbackHandler(this, paramHandler.getLooper());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: aconst_null
/*     */     //   4: putfield mListenerToService : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateChangeListenerToService;
/*     */     //   7: aload_0
/*     */     //   8: aconst_null
/*     */     //   9: putfield mDrvStateEventListener : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateEventListener;
/*     */     //   12: aload_0
/*     */     //   13: monitorexit
/*     */     //   14: return
/*     */     //   15: astore_1
/*     */     //   16: aload_0
/*     */     //   17: monitorexit
/*     */     //   18: aload_1
/*     */     //   19: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #63	-> 2
/*     */     //   #64	-> 7
/*     */     //   #65	-> 12
/*     */     //   #62	-> 15
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	7	15	finally
/*     */     //   7	12	15	finally
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerListener(CarDrivingStateEventListener paramCarDrivingStateEventListener) throws CarNotConnectedException, IllegalArgumentException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_1
/*     */     //   3: ifnull -> 142
/*     */     //   6: aload_0
/*     */     //   7: getfield mDrvStateEventListener : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateEventListener;
/*     */     //   10: astore_2
/*     */     //   11: aload_2
/*     */     //   12: ifnull -> 18
/*     */     //   15: aload_0
/*     */     //   16: monitorexit
/*     */     //   17: return
/*     */     //   18: aload_0
/*     */     //   19: aload_1
/*     */     //   20: putfield mDrvStateEventListener : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateEventListener;
/*     */     //   23: aload_0
/*     */     //   24: getfield mListenerToService : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateChangeListenerToService;
/*     */     //   27: ifnonnull -> 44
/*     */     //   30: new android/car/drivingstate/CarDrivingStateManager$CarDrivingStateChangeListenerToService
/*     */     //   33: astore_1
/*     */     //   34: aload_1
/*     */     //   35: aload_0
/*     */     //   36: invokespecial <init> : (Landroid/car/drivingstate/CarDrivingStateManager;)V
/*     */     //   39: aload_0
/*     */     //   40: aload_1
/*     */     //   41: putfield mListenerToService : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateChangeListenerToService;
/*     */     //   44: aload_0
/*     */     //   45: getfield mDrivingService : Landroid/car/drivingstate/ICarDrivingState;
/*     */     //   48: aload_0
/*     */     //   49: getfield mListenerToService : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateChangeListenerToService;
/*     */     //   52: invokeinterface registerDrivingStateChangeListener : (Landroid/car/drivingstate/ICarDrivingStateChangeListener;)V
/*     */     //   57: goto -> 96
/*     */     //   60: astore_1
/*     */     //   61: new java/lang/StringBuilder
/*     */     //   64: astore_2
/*     */     //   65: aload_2
/*     */     //   66: invokespecial <init> : ()V
/*     */     //   69: aload_2
/*     */     //   70: ldc 'Could not register a listener to Driving State Service '
/*     */     //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   75: pop
/*     */     //   76: aload_2
/*     */     //   77: aload_1
/*     */     //   78: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   81: pop
/*     */     //   82: ldc 'CarDrivingStateMgr'
/*     */     //   84: aload_2
/*     */     //   85: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   88: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   91: pop
/*     */     //   92: aload_1
/*     */     //   93: invokestatic checkCarNotConnectedExceptionFromCarService : (Ljava/lang/IllegalStateException;)V
/*     */     //   96: aload_0
/*     */     //   97: monitorexit
/*     */     //   98: return
/*     */     //   99: astore_1
/*     */     //   100: new java/lang/StringBuilder
/*     */     //   103: astore_2
/*     */     //   104: aload_2
/*     */     //   105: invokespecial <init> : ()V
/*     */     //   108: aload_2
/*     */     //   109: ldc 'Could not register a listener to Driving State Service '
/*     */     //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   114: pop
/*     */     //   115: aload_2
/*     */     //   116: aload_1
/*     */     //   117: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   120: pop
/*     */     //   121: ldc 'CarDrivingStateMgr'
/*     */     //   123: aload_2
/*     */     //   124: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   127: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   130: pop
/*     */     //   131: new android/car/CarNotConnectedException
/*     */     //   134: astore_2
/*     */     //   135: aload_2
/*     */     //   136: aload_1
/*     */     //   137: invokespecial <init> : (Ljava/lang/Exception;)V
/*     */     //   140: aload_2
/*     */     //   141: athrow
/*     */     //   142: new java/lang/IllegalArgumentException
/*     */     //   145: astore_1
/*     */     //   146: aload_1
/*     */     //   147: ldc 'Listener is null'
/*     */     //   149: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   152: aload_1
/*     */     //   153: athrow
/*     */     //   154: astore_1
/*     */     //   155: aload_0
/*     */     //   156: monitorexit
/*     */     //   157: aload_1
/*     */     //   158: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #85	-> 2
/*     */     //   #92	-> 6
/*     */     //   #96	-> 15
/*     */     //   #98	-> 18
/*     */     //   #100	-> 23
/*     */     //   #101	-> 30
/*     */     //   #104	-> 44
/*     */     //   #111	-> 57
/*     */     //   #108	-> 60
/*     */     //   #109	-> 61
/*     */     //   #110	-> 92
/*     */     //   #112	-> 96
/*     */     //   #105	-> 99
/*     */     //   #106	-> 100
/*     */     //   #107	-> 131
/*     */     //   #89	-> 142
/*     */     //   #84	-> 154
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	11	154	finally
/*     */     //   18	23	154	finally
/*     */     //   23	30	99	android/os/RemoteException
/*     */     //   23	30	60	java/lang/IllegalStateException
/*     */     //   23	30	154	finally
/*     */     //   30	44	99	android/os/RemoteException
/*     */     //   30	44	60	java/lang/IllegalStateException
/*     */     //   30	44	154	finally
/*     */     //   44	57	99	android/os/RemoteException
/*     */     //   44	57	60	java/lang/IllegalStateException
/*     */     //   44	57	154	finally
/*     */     //   61	92	154	finally
/*     */     //   92	96	154	finally
/*     */     //   100	131	154	finally
/*     */     //   131	142	154	finally
/*     */     //   142	154	154	finally
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterListener() throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mDrvStateEventListener : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateEventListener;
/*     */     //   6: astore_1
/*     */     //   7: aload_1
/*     */     //   8: ifnonnull -> 14
/*     */     //   11: aload_0
/*     */     //   12: monitorexit
/*     */     //   13: return
/*     */     //   14: aload_0
/*     */     //   15: getfield mDrivingService : Landroid/car/drivingstate/ICarDrivingState;
/*     */     //   18: aload_0
/*     */     //   19: getfield mListenerToService : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateChangeListenerToService;
/*     */     //   22: invokeinterface unregisterDrivingStateChangeListener : (Landroid/car/drivingstate/ICarDrivingStateChangeListener;)V
/*     */     //   27: aload_0
/*     */     //   28: aconst_null
/*     */     //   29: putfield mDrvStateEventListener : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateEventListener;
/*     */     //   32: aload_0
/*     */     //   33: aconst_null
/*     */     //   34: putfield mListenerToService : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateChangeListenerToService;
/*     */     //   37: aload_0
/*     */     //   38: monitorexit
/*     */     //   39: return
/*     */     //   40: astore_1
/*     */     //   41: new java/lang/StringBuilder
/*     */     //   44: astore_2
/*     */     //   45: aload_2
/*     */     //   46: invokespecial <init> : ()V
/*     */     //   49: aload_2
/*     */     //   50: ldc 'Could not unregister listener from Driving State Service '
/*     */     //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   55: pop
/*     */     //   56: aload_2
/*     */     //   57: aload_1
/*     */     //   58: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   61: pop
/*     */     //   62: ldc 'CarDrivingStateMgr'
/*     */     //   64: aload_2
/*     */     //   65: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   68: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   71: pop
/*     */     //   72: new android/car/CarNotConnectedException
/*     */     //   75: astore_2
/*     */     //   76: aload_2
/*     */     //   77: aload_1
/*     */     //   78: invokespecial <init> : (Ljava/lang/Exception;)V
/*     */     //   81: aload_2
/*     */     //   82: athrow
/*     */     //   83: astore_1
/*     */     //   84: aload_0
/*     */     //   85: monitorexit
/*     */     //   86: aload_1
/*     */     //   87: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #120	-> 2
/*     */     //   #124	-> 11
/*     */     //   #127	-> 14
/*     */     //   #128	-> 27
/*     */     //   #129	-> 32
/*     */     //   #133	-> 37
/*     */     //   #134	-> 37
/*     */     //   #130	-> 40
/*     */     //   #131	-> 41
/*     */     //   #132	-> 72
/*     */     //   #119	-> 83
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	7	83	finally
/*     */     //   14	27	40	android/os/RemoteException
/*     */     //   14	27	83	finally
/*     */     //   27	32	40	android/os/RemoteException
/*     */     //   27	32	83	finally
/*     */     //   32	37	40	android/os/RemoteException
/*     */     //   32	37	83	finally
/*     */     //   41	72	83	finally
/*     */     //   72	83	83	finally
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarDrivingStateEvent getCurrentCarDrivingState() throws CarNotConnectedException {
/*     */     try {
/* 145 */       return this.mDrivingService.getCurrentDrivingState();
/* 146 */     } catch (RemoteException remoteException) {
/* 147 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Could not get current driving state "); stringBuilder.append(remoteException); Log.e("CarDrivingStateMgr", stringBuilder.toString());
/* 148 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CarDrivingStateChangeListenerToService
/*     */     extends ICarDrivingStateChangeListener.Stub
/*     */   {
/*     */     private final WeakReference<CarDrivingStateManager> mDrvStateMgr;
/*     */ 
/*     */     
/*     */     public CarDrivingStateChangeListenerToService(CarDrivingStateManager param1CarDrivingStateManager) {
/* 161 */       this.mDrvStateMgr = new WeakReference<>(param1CarDrivingStateManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onDrivingStateChanged(CarDrivingStateEvent param1CarDrivingStateEvent) {
/* 166 */       CarDrivingStateManager carDrivingStateManager = this.mDrvStateMgr.get();
/* 167 */       if (carDrivingStateManager != null) {
/* 168 */         carDrivingStateManager.handleDrivingStateChanged(param1CarDrivingStateEvent);
/*     */       }
/*     */     }
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
/*     */   private void handleDrivingStateChanged(CarDrivingStateEvent paramCarDrivingStateEvent) {
/* 182 */     EventCallbackHandler eventCallbackHandler1 = this.mEventCallbackHandler, eventCallbackHandler2 = this.mEventCallbackHandler;
/* 183 */     Message message = eventCallbackHandler2.obtainMessage(0, paramCarDrivingStateEvent);
/*     */     eventCallbackHandler1.sendMessage(message);
/*     */   }
/*     */   
/*     */   public static interface CarDrivingStateEventListener {
/*     */     void onDrivingStateChanged(CarDrivingStateEvent param1CarDrivingStateEvent);
/*     */   }
/*     */   
/*     */   private static final class EventCallbackHandler extends Handler {
/*     */     private final WeakReference<CarDrivingStateManager> mDrvStateMgr;
/*     */     
/*     */     public EventCallbackHandler(CarDrivingStateManager param1CarDrivingStateManager, Looper param1Looper) {
/* 195 */       super(param1Looper);
/* 196 */       this.mDrvStateMgr = new WeakReference<>(param1CarDrivingStateManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 201 */       CarDrivingStateManager carDrivingStateManager = this.mDrvStateMgr.get();
/* 202 */       if (carDrivingStateManager != null)
/* 203 */         carDrivingStateManager.dispatchDrivingStateChangeToClient((CarDrivingStateEvent)param1Message.obj); 
/*     */     }
/*     */   }
/*     */   
/*     */   private void dispatchDrivingStateChangeToClient(CarDrivingStateEvent paramCarDrivingStateEvent) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull -> 5
/*     */     //   4: return
/*     */     //   5: aload_0
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield mDrvStateEventListener : Landroid/car/drivingstate/CarDrivingStateManager$CarDrivingStateEventListener;
/*     */     //   11: astore_2
/*     */     //   12: aload_0
/*     */     //   13: monitorexit
/*     */     //   14: aload_2
/*     */     //   15: ifnull -> 25
/*     */     //   18: aload_2
/*     */     //   19: aload_1
/*     */     //   20: invokeinterface onDrivingStateChanged : (Landroid/car/drivingstate/CarDrivingStateEvent;)V
/*     */     //   25: return
/*     */     //   26: astore_1
/*     */     //   27: aload_0
/*     */     //   28: monitorexit
/*     */     //   29: aload_1
/*     */     //   30: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #216	-> 0
/*     */     //   #217	-> 4
/*     */     //   #220	-> 5
/*     */     //   #221	-> 7
/*     */     //   #222	-> 12
/*     */     //   #223	-> 14
/*     */     //   #224	-> 18
/*     */     //   #226	-> 25
/*     */     //   #222	-> 26
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	12	26	finally
/*     */     //   12	14	26	finally
/*     */     //   27	29	26	finally
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\CarDrivingStateManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */