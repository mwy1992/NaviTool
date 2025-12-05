/*     */ package android.car.drivingstate;
/*     */ 
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
/*     */ 
/*     */ public final class CarUxRestrictionsManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   private static final int MSG_HANDLE_UX_RESTRICTIONS_CHANGE = 0;
/*     */   private static final String TAG = "CarUxRManager";
/*     */   private static final boolean VDBG = false;
/*     */   private final Context mContext;
/*     */   private final EventCallbackHandler mEventCallbackHandler;
/*     */   private CarUxRestrictionsChangeListenerToService mListenerToService;
/*     */   private OnUxRestrictionsChangedListener mUxRListener;
/*     */   private final ICarUxRestrictionsManager mUxRService;
/*     */   
/*     */   public CarUxRestrictionsManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/*  54 */     this.mContext = paramContext;
/*  55 */     this.mUxRService = ICarUxRestrictionsManager.Stub.asInterface(paramIBinder);
/*  56 */     this.mEventCallbackHandler = new EventCallbackHandler(this, paramHandler.getLooper());
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
/*     */   
/*     */   public void onCarDisconnected() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: aconst_null
/*     */     //   4: putfield mListenerToService : Landroid/car/drivingstate/CarUxRestrictionsManager$CarUxRestrictionsChangeListenerToService;
/*     */     //   7: aload_0
/*     */     //   8: aconst_null
/*     */     //   9: putfield mUxRListener : Landroid/car/drivingstate/CarUxRestrictionsManager$OnUxRestrictionsChangedListener;
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
/*     */     //   #62	-> 2
/*     */     //   #63	-> 7
/*     */     //   #64	-> 12
/*     */     //   #61	-> 15
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
/*     */   
/*     */   public void registerListener(OnUxRestrictionsChangedListener paramOnUxRestrictionsChangedListener) throws CarNotConnectedException, IllegalArgumentException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_1
/*     */     //   3: ifnull -> 142
/*     */     //   6: aload_0
/*     */     //   7: getfield mUxRListener : Landroid/car/drivingstate/CarUxRestrictionsManager$OnUxRestrictionsChangedListener;
/*     */     //   10: astore_2
/*     */     //   11: aload_2
/*     */     //   12: ifnull -> 18
/*     */     //   15: aload_0
/*     */     //   16: monitorexit
/*     */     //   17: return
/*     */     //   18: aload_0
/*     */     //   19: aload_1
/*     */     //   20: putfield mUxRListener : Landroid/car/drivingstate/CarUxRestrictionsManager$OnUxRestrictionsChangedListener;
/*     */     //   23: aload_0
/*     */     //   24: getfield mListenerToService : Landroid/car/drivingstate/CarUxRestrictionsManager$CarUxRestrictionsChangeListenerToService;
/*     */     //   27: ifnonnull -> 44
/*     */     //   30: new android/car/drivingstate/CarUxRestrictionsManager$CarUxRestrictionsChangeListenerToService
/*     */     //   33: astore_1
/*     */     //   34: aload_1
/*     */     //   35: aload_0
/*     */     //   36: invokespecial <init> : (Landroid/car/drivingstate/CarUxRestrictionsManager;)V
/*     */     //   39: aload_0
/*     */     //   40: aload_1
/*     */     //   41: putfield mListenerToService : Landroid/car/drivingstate/CarUxRestrictionsManager$CarUxRestrictionsChangeListenerToService;
/*     */     //   44: aload_0
/*     */     //   45: getfield mUxRService : Landroid/car/drivingstate/ICarUxRestrictionsManager;
/*     */     //   48: aload_0
/*     */     //   49: getfield mListenerToService : Landroid/car/drivingstate/CarUxRestrictionsManager$CarUxRestrictionsChangeListenerToService;
/*     */     //   52: invokeinterface registerUxRestrictionsChangeListener : (Landroid/car/drivingstate/ICarUxRestrictionsChangeListener;)V
/*     */     //   57: goto -> 96
/*     */     //   60: astore_2
/*     */     //   61: new java/lang/StringBuilder
/*     */     //   64: astore_1
/*     */     //   65: aload_1
/*     */     //   66: invokespecial <init> : ()V
/*     */     //   69: aload_1
/*     */     //   70: ldc 'Could not register a listener to CarUxRestrictionsManagerService '
/*     */     //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   75: pop
/*     */     //   76: aload_1
/*     */     //   77: aload_2
/*     */     //   78: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   81: pop
/*     */     //   82: ldc 'CarUxRManager'
/*     */     //   84: aload_1
/*     */     //   85: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   88: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   91: pop
/*     */     //   92: aload_2
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
/*     */     //   109: ldc 'Could not register a listener to CarUxRestrictionsManagerService '
/*     */     //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   114: pop
/*     */     //   115: aload_2
/*     */     //   116: aload_1
/*     */     //   117: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   120: pop
/*     */     //   121: ldc 'CarUxRManager'
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
/*     */     //   #90	-> 2
/*     */     //   #97	-> 6
/*     */     //   #101	-> 15
/*     */     //   #103	-> 18
/*     */     //   #105	-> 23
/*     */     //   #106	-> 30
/*     */     //   #109	-> 44
/*     */     //   #116	-> 57
/*     */     //   #113	-> 60
/*     */     //   #114	-> 61
/*     */     //   #115	-> 92
/*     */     //   #117	-> 96
/*     */     //   #110	-> 99
/*     */     //   #111	-> 100
/*     */     //   #112	-> 131
/*     */     //   #94	-> 142
/*     */     //   #89	-> 154
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
/*     */   
/*     */   public void unregisterListener() throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mUxRListener : Landroid/car/drivingstate/CarUxRestrictionsManager$OnUxRestrictionsChangedListener;
/*     */     //   6: astore_1
/*     */     //   7: aload_1
/*     */     //   8: ifnonnull -> 14
/*     */     //   11: aload_0
/*     */     //   12: monitorexit
/*     */     //   13: return
/*     */     //   14: aload_0
/*     */     //   15: getfield mUxRService : Landroid/car/drivingstate/ICarUxRestrictionsManager;
/*     */     //   18: aload_0
/*     */     //   19: getfield mListenerToService : Landroid/car/drivingstate/CarUxRestrictionsManager$CarUxRestrictionsChangeListenerToService;
/*     */     //   22: invokeinterface unregisterUxRestrictionsChangeListener : (Landroid/car/drivingstate/ICarUxRestrictionsChangeListener;)V
/*     */     //   27: aload_0
/*     */     //   28: aconst_null
/*     */     //   29: putfield mUxRListener : Landroid/car/drivingstate/CarUxRestrictionsManager$OnUxRestrictionsChangedListener;
/*     */     //   32: aload_0
/*     */     //   33: monitorexit
/*     */     //   34: return
/*     */     //   35: astore_1
/*     */     //   36: new java/lang/StringBuilder
/*     */     //   39: astore_2
/*     */     //   40: aload_2
/*     */     //   41: invokespecial <init> : ()V
/*     */     //   44: aload_2
/*     */     //   45: ldc 'Could not unregister listener from Driving State Service '
/*     */     //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   50: pop
/*     */     //   51: aload_2
/*     */     //   52: aload_1
/*     */     //   53: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   56: pop
/*     */     //   57: ldc 'CarUxRManager'
/*     */     //   59: aload_2
/*     */     //   60: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   63: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   66: pop
/*     */     //   67: new android/car/CarNotConnectedException
/*     */     //   70: astore_2
/*     */     //   71: aload_2
/*     */     //   72: aload_1
/*     */     //   73: invokespecial <init> : (Ljava/lang/Exception;)V
/*     */     //   76: aload_2
/*     */     //   77: athrow
/*     */     //   78: astore_1
/*     */     //   79: aload_0
/*     */     //   80: monitorexit
/*     */     //   81: aload_1
/*     */     //   82: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #124	-> 2
/*     */     //   #128	-> 11
/*     */     //   #131	-> 14
/*     */     //   #132	-> 27
/*     */     //   #136	-> 32
/*     */     //   #137	-> 32
/*     */     //   #133	-> 35
/*     */     //   #134	-> 36
/*     */     //   #135	-> 67
/*     */     //   #123	-> 78
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	7	78	finally
/*     */     //   14	27	35	android/os/RemoteException
/*     */     //   14	27	78	finally
/*     */     //   27	32	35	android/os/RemoteException
/*     */     //   27	32	78	finally
/*     */     //   36	67	78	finally
/*     */     //   67	78	78	finally
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
/*     */   public CarUxRestrictions getCurrentCarUxRestrictions() throws CarNotConnectedException {
/*     */     try {
/* 148 */       return this.mUxRService.getCurrentUxRestrictions();
/* 149 */     } catch (RemoteException remoteException) {
/* 150 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Could not get current UX restrictions "); stringBuilder.append(remoteException); Log.e("CarUxRManager", stringBuilder.toString());
/* 151 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CarUxRestrictionsChangeListenerToService
/*     */     extends ICarUxRestrictionsChangeListener.Stub
/*     */   {
/*     */     private final WeakReference<CarUxRestrictionsManager> mUxRestrictionsManager;
/*     */ 
/*     */     
/*     */     public CarUxRestrictionsChangeListenerToService(CarUxRestrictionsManager param1CarUxRestrictionsManager) {
/* 164 */       this.mUxRestrictionsManager = new WeakReference<>(param1CarUxRestrictionsManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onUxRestrictionsChanged(CarUxRestrictions param1CarUxRestrictions) {
/* 169 */       CarUxRestrictionsManager carUxRestrictionsManager = this.mUxRestrictionsManager.get();
/* 170 */       if (carUxRestrictionsManager != null) {
/* 171 */         carUxRestrictionsManager.handleUxRestrictionsChanged(param1CarUxRestrictions);
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
/*     */   private void handleUxRestrictionsChanged(CarUxRestrictions paramCarUxRestrictions) {
/* 185 */     this.mEventCallbackHandler.sendMessage(this.mEventCallbackHandler.obtainMessage(0, paramCarUxRestrictions));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class EventCallbackHandler
/*     */     extends Handler
/*     */   {
/*     */     private final WeakReference<CarUxRestrictionsManager> mUxRestrictionsManager;
/*     */ 
/*     */     
/*     */     public EventCallbackHandler(CarUxRestrictionsManager param1CarUxRestrictionsManager, Looper param1Looper) {
/* 197 */       super(param1Looper);
/* 198 */       this.mUxRestrictionsManager = new WeakReference<>(param1CarUxRestrictionsManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 203 */       CarUxRestrictionsManager carUxRestrictionsManager = this.mUxRestrictionsManager.get();
/* 204 */       if (carUxRestrictionsManager != null)
/* 205 */         carUxRestrictionsManager.dispatchUxRChangeToClient((CarUxRestrictions)param1Message.obj); 
/*     */     }
/*     */   }
/*     */   
/*     */   private void dispatchUxRChangeToClient(CarUxRestrictions paramCarUxRestrictions) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull -> 5
/*     */     //   4: return
/*     */     //   5: aload_0
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield mUxRListener : Landroid/car/drivingstate/CarUxRestrictionsManager$OnUxRestrictionsChangedListener;
/*     */     //   11: astore_2
/*     */     //   12: aload_0
/*     */     //   13: monitorexit
/*     */     //   14: aload_2
/*     */     //   15: ifnull -> 25
/*     */     //   18: aload_2
/*     */     //   19: aload_1
/*     */     //   20: invokeinterface onUxRestrictionsChanged : (Landroid/car/drivingstate/CarUxRestrictions;)V
/*     */     //   25: return
/*     */     //   26: astore_1
/*     */     //   27: aload_0
/*     */     //   28: monitorexit
/*     */     //   29: aload_1
/*     */     //   30: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #218	-> 0
/*     */     //   #219	-> 4
/*     */     //   #222	-> 5
/*     */     //   #223	-> 7
/*     */     //   #224	-> 12
/*     */     //   #225	-> 14
/*     */     //   #226	-> 18
/*     */     //   #228	-> 25
/*     */     //   #224	-> 26
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	12	26	finally
/*     */     //   12	14	26	finally
/*     */     //   27	29	26	finally
/*     */   }
/*     */   
/*     */   public void registerListener(onUxRestrictionsChangedListener paramonUxRestrictionsChangedListener) throws CarNotConnectedException, IllegalArgumentException {
/*     */     /* monitor enter ThisExpression{ObjectType{android/car/drivingstate/CarUxRestrictionsManager}} */
/*     */     /* monitor exit ThisExpression{ObjectType{android/car/drivingstate/CarUxRestrictionsManager}} */
/*     */   }
/*     */   
/*     */   public static interface OnUxRestrictionsChangedListener {
/*     */     void onUxRestrictionsChanged(CarUxRestrictions param1CarUxRestrictions);
/*     */   }
/*     */   
/*     */   public static interface onUxRestrictionsChangedListener {
/*     */     void dummy();
/*     */     
/*     */     void onUxRestrictionsChanged(CarUxRestrictions param1CarUxRestrictions);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\CarUxRestrictionsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */