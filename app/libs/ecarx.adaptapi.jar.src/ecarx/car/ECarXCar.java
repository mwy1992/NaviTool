/*     */ package ecarx.car;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.os.UserHandle;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.HashMap;
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
/*     */ public class ECarXCar
/*     */ {
/* 111 */   private final Object mCarManagerLock = new Object(); @GuardedBy("mCarManagerLock")
/* 112 */   private final HashMap<String, ECarXCarManagerBase> mServiceMap = new HashMap<>();
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
/* 127 */   private final ServiceConnection mServiceConnectionListener = new ServiceConnection() { final ECarXCar this$0;
/*     */       
/*     */       public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/* 130 */         Log.d("ECarXCar", "onServiceConnected");
/* 131 */         ECarXCar.access$002(ECarXCar.this, new ECarXCar.ManagerDeathRecipient());
/*     */         try {
/* 133 */           param1IBinder.linkToDeath(ECarXCar.this.mDeathRecipient, 0);
/* 134 */           ECarXCar.access$202(ECarXCar.this, param1IBinder);
/* 135 */         } catch (RemoteException remoteException) {}
/*     */ 
/*     */         
/* 138 */         synchronized (ECarXCar.this) {
/* 139 */           ECarXCar.access$302(ECarXCar.this, IECarXCar.Stub.asInterface(param1IBinder));
/* 140 */           ECarXCar.access$402(ECarXCar.this, 2);
/*     */           
/* 142 */           ECarXCar.this.mServiceConnectionListenerClient.onServiceConnected(param1ComponentName, param1IBinder);
/*     */           return;
/*     */         } 
/*     */       }
/* 146 */       public void onServiceDisconnected(ComponentName param1ComponentName) { Log.d("ECarXCar", "onServiceDisconnected");
/* 147 */         synchronized (ECarXCar.this) {
/* 148 */           ECarXCar.access$302(ECarXCar.this, null);
/* 149 */           if (ECarXCar.this.mConnectionState == 0) {
/*     */             return;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 155 */           ECarXCar.this.disconnect();
/* 156 */           ECarXCar.this.mServiceConnectionListenerClient.onServiceDisconnected(param1ComponentName);
/*     */           return;
/*     */         }  } }
/* 159 */   ; private final Runnable mConnectionRetryFailedRunnable = new Runnable() { final ECarXCar this$0;
/*     */       
/*     */       public void run() {
/* 162 */         ECarXCar.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName("com.ecarx.car", "com.ecarx.car.ECarXCarService"));
/*     */       } }
/*     */   ;
/*     */   
/* 166 */   private final Runnable mConnectionRetryRunnable = new Runnable() { final ECarXCar this$0;
/*     */       
/*     */       public void run() {
/* 169 */         ECarXCar.this.startCarService();
/*     */       } }
/*     */   ; public static final String CAR_HARDKEY_SERVICE = "car_hardkey"; public static final String CAR_INFO_SERVICE = "car_info"; public static final String CAR_NOT_CONNECTED_EXCEPTION_MSG = "CarNotConnected"; public static final String CAR_SENSOR_TMP_SERVICE = "car_sensor_tmp"; private static final long CAR_SERVICE_BIND_MAX_RETRY = 20L; private static final long CAR_SERVICE_BIND_RETRY_INTERVAL_MS = 500L; private static final String CAR_SERVICE_CLASS = "com.ecarx.car.ECarXCarService"; public static final String CAR_SERVICE_INTERFACE_NAME = "ecarx.car.IECarXCar"; private static final String CAR_SERVICE_PACKAGE = "com.ecarx.car"; public static final int CONNECTION_TYPE_EMBEDDED = 5;
/*     */   public static final String PA_SERVICE = "car_publicattribute";
/*     */   public static final String SERVICE_NAME = "ecarxcar_service";
/*     */   public static final String SIGNAL_SERVICE = "car_signal";
/*     */   private static final int STATE_CONNECTED = 2;
/*     */   private static final int STATE_CONNECTING = 1;
/*     */   
/*     */   public ECarXCar(Context paramContext) {
/* 179 */     this.mContext = paramContext;
/* 180 */     this.mEventHandler = null;
/* 181 */     this.mMainThreadEventHandler = null;
/*     */     
/* 183 */     this.mService = null;
/* 184 */     this.mOwnsService = false;
/* 185 */     this.mConnectionState = 0;
/* 186 */     this.mServiceConnectionListenerClient = null;
/* 187 */     this.mDeaCallback = null;
/*     */   } private static final int STATE_DISCONNECTED = 0; private static final String TAG = "ECarXCar"; public static final String XMA_DVR_HTTP_SERVICE = "xma_dvr_http_service"; public static final String XMA_DVR_SERVICE = "xma_dvr_service"; @GuardedBy("this")
/*     */   private int mConnectionRetryCount; @GuardedBy("this")
/*     */   private int mConnectionState; private final Context mContext; private CarServiceDieCallback mDeaCallback; private IBinder mDeaService; private ManagerDeathRecipient mDeathRecipient; private final Handler mEventHandler; private final Handler mMainThreadEventHandler; private final boolean mOwnsService; @GuardedBy("this")
/*     */   private IECarXCar mService; private final ServiceConnection mServiceConnectionListenerClient; private ECarXCar(Context paramContext, ServiceConnection paramServiceConnection, Handler paramHandler) {
/* 192 */     this.mContext = paramContext;
/* 193 */     this.mEventHandler = determineEventHandler(paramHandler);
/* 194 */     this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
/*     */     
/* 196 */     this.mService = null;
/* 197 */     this.mOwnsService = true;
/* 198 */     this.mConnectionState = 0;
/* 199 */     this.mServiceConnectionListenerClient = paramServiceConnection;
/* 200 */     this.mDeaCallback = null;
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
/*     */   private ECarXCar(Context paramContext, IECarXCar paramIECarXCar, Handler paramHandler) {
/* 214 */     this.mContext = paramContext;
/* 215 */     this.mEventHandler = determineEventHandler(paramHandler);
/* 216 */     this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
/*     */     
/* 218 */     this.mService = paramIECarXCar;
/* 219 */     this.mOwnsService = true;
/* 220 */     this.mConnectionState = 2;
/* 221 */     this.mServiceConnectionListenerClient = null;
/* 222 */     this.mDeaCallback = null;
/* 223 */     this.mDeathRecipient = new ManagerDeathRecipient();
/*     */     try {
/* 225 */       this.mService.asBinder().linkToDeath(this.mDeathRecipient, 0);
/* 226 */       this.mDeaService = this.mService.asBinder();
/* 227 */     } catch (RemoteException remoteException) {}
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
/*     */   public static ECarXCar createCar(Context paramContext, ServiceConnection paramServiceConnection, Handler paramHandler) {
/* 245 */     if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
/* 246 */       Log.e("ECarXCar", "FEATURE_AUTOMOTIVE not declared while android.car is used");
/*     */       
/* 248 */       return null;
/*     */     } 
/*     */     try {
/* 251 */       Log.d("ECarXCar", "createCar");
/* 252 */       return new ECarXCar(paramContext, paramServiceConnection, paramHandler);
/* 253 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */       
/* 256 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ECarXCar createCar(Context paramContext, IECarXCar paramIECarXCar) {
/* 267 */     Log.d("ECarXCar", "createCar using main thread with binder proxy object");
/* 268 */     return createCar(paramContext, paramIECarXCar, (Handler)null);
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
/*     */   public static ECarXCar createCar(Context paramContext, IECarXCar paramIECarXCar, Handler paramHandler) {
/* 284 */     if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
/* 285 */       Log.e("ECarXCar", "FEATURE_AUTOMOTIVE not declared while android.car is used");
/*     */       
/* 287 */       return null;
/*     */     } 
/*     */     try {
/* 290 */       Log.d("ECarXCar", "createCar service with handler");
/* 291 */       return new ECarXCar(paramContext, paramIECarXCar, paramHandler);
/* 292 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */       
/* 295 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ECarXCar createCar(Context paramContext, ServiceConnection paramServiceConnection) {
/* 305 */     Log.d("ECarXCar", "createCar using main thread with serviceconnectionListener");
/* 306 */     return createCar(paramContext, paramServiceConnection, (Handler)null);
/*     */   }
/*     */   
/*     */   private static Handler determineMainThreadEventHandler(Handler paramHandler) {
/* 310 */     Looper looper = Looper.getMainLooper();
/* 311 */     if (paramHandler.getLooper() != looper) paramHandler = new Handler(looper);  return paramHandler;
/*     */   }
/*     */   
/*     */   private static Handler determineEventHandler(Handler paramHandler) {
/* 315 */     Handler handler = paramHandler; if (paramHandler == null) {
/*     */       
/* 317 */       HandlerThread handlerThread = new HandlerThread("EventDispatch");
/* 318 */       handlerThread.start();
/* 319 */       handler = new Handler(handlerThread.getLooper());
/*     */     } 
/* 321 */     return handler;
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
/*     */   public static void checkCarNotConnectedExceptionFromCarService(IllegalStateException paramIllegalStateException) throws CarNotConnectedException, IllegalStateException {
/* 335 */     String str = paramIllegalStateException.getMessage();
/* 336 */     if ("CarNotConnected".equals(str)) {
/* 337 */       throw new CarNotConnectedException();
/*     */     }
/* 339 */     throw paramIllegalStateException;
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
/*     */   public void connect() throws IllegalStateException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mConnectionState : I
/*     */     //   6: ifne -> 21
/*     */     //   9: aload_0
/*     */     //   10: iconst_1
/*     */     //   11: putfield mConnectionState : I
/*     */     //   14: aload_0
/*     */     //   15: invokespecial startCarService : ()V
/*     */     //   18: aload_0
/*     */     //   19: monitorexit
/*     */     //   20: return
/*     */     //   21: new java/lang/IllegalStateException
/*     */     //   24: astore_1
/*     */     //   25: aload_1
/*     */     //   26: ldc_w 'already connected or connecting'
/*     */     //   29: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   32: aload_1
/*     */     //   33: athrow
/*     */     //   34: astore_1
/*     */     //   35: aload_0
/*     */     //   36: monitorexit
/*     */     //   37: aload_1
/*     */     //   38: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #350	-> 0
/*     */     //   #351	-> 2
/*     */     //   #354	-> 9
/*     */     //   #355	-> 14
/*     */     //   #356	-> 18
/*     */     //   #357	-> 20
/*     */     //   #352	-> 21
/*     */     //   #356	-> 34
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	34	finally
/*     */     //   9	14	34	finally
/*     */     //   14	18	34	finally
/*     */     //   18	20	34	finally
/*     */     //   21	34	34	finally
/*     */     //   35	37	34	finally
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
/*     */   public void disconnect() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: new java/lang/StringBuilder
/*     */     //   5: astore_1
/*     */     //   6: aload_1
/*     */     //   7: invokespecial <init> : ()V
/*     */     //   10: aload_1
/*     */     //   11: ldc_w 'disconnect '
/*     */     //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   17: pop
/*     */     //   18: aload_1
/*     */     //   19: aload_0
/*     */     //   20: getfield mConnectionState : I
/*     */     //   23: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   26: pop
/*     */     //   27: ldc 'ECarXCar'
/*     */     //   29: aload_1
/*     */     //   30: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   33: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   36: pop
/*     */     //   37: aload_0
/*     */     //   38: getfield mConnectionState : I
/*     */     //   41: ifne -> 47
/*     */     //   44: aload_0
/*     */     //   45: monitorexit
/*     */     //   46: return
/*     */     //   47: aload_0
/*     */     //   48: getfield mEventHandler : Landroid/os/Handler;
/*     */     //   51: aload_0
/*     */     //   52: getfield mConnectionRetryRunnable : Ljava/lang/Runnable;
/*     */     //   55: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
/*     */     //   58: aload_0
/*     */     //   59: getfield mMainThreadEventHandler : Landroid/os/Handler;
/*     */     //   62: aload_0
/*     */     //   63: getfield mConnectionRetryFailedRunnable : Ljava/lang/Runnable;
/*     */     //   66: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
/*     */     //   69: aload_0
/*     */     //   70: iconst_0
/*     */     //   71: putfield mConnectionRetryCount : I
/*     */     //   74: aload_0
/*     */     //   75: invokespecial tearDownCarManagers : ()V
/*     */     //   78: aload_0
/*     */     //   79: aconst_null
/*     */     //   80: putfield mService : Lecarx/car/IECarXCar;
/*     */     //   83: aload_0
/*     */     //   84: iconst_0
/*     */     //   85: putfield mConnectionState : I
/*     */     //   88: aload_0
/*     */     //   89: getfield mOwnsService : Z
/*     */     //   92: ifeq -> 106
/*     */     //   95: aload_0
/*     */     //   96: getfield mContext : Landroid/content/Context;
/*     */     //   99: aload_0
/*     */     //   100: getfield mServiceConnectionListener : Landroid/content/ServiceConnection;
/*     */     //   103: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
/*     */     //   106: aload_0
/*     */     //   107: monitorexit
/*     */     //   108: return
/*     */     //   109: astore_1
/*     */     //   110: aload_0
/*     */     //   111: monitorexit
/*     */     //   112: aload_1
/*     */     //   113: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #366	-> 0
/*     */     //   #367	-> 2
/*     */     //   #368	-> 37
/*     */     //   #369	-> 44
/*     */     //   #371	-> 47
/*     */     //   #372	-> 58
/*     */     //   #373	-> 69
/*     */     //   #374	-> 74
/*     */     //   #375	-> 78
/*     */     //   #376	-> 83
/*     */     //   #378	-> 88
/*     */     //   #379	-> 95
/*     */     //   #381	-> 106
/*     */     //   #382	-> 108
/*     */     //   #381	-> 109
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	37	109	finally
/*     */     //   37	44	109	finally
/*     */     //   44	46	109	finally
/*     */     //   47	58	109	finally
/*     */     //   58	69	109	finally
/*     */     //   69	74	109	finally
/*     */     //   74	78	109	finally
/*     */     //   78	83	109	finally
/*     */     //   83	88	109	finally
/*     */     //   88	95	109	finally
/*     */     //   95	106	109	finally
/*     */     //   106	108	109	finally
/*     */     //   110	112	109	finally
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
/*     */   public boolean isConnected() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mService : Lecarx/car/IECarXCar;
/*     */     //   6: ifnull -> 14
/*     */     //   9: iconst_1
/*     */     //   10: istore_1
/*     */     //   11: goto -> 16
/*     */     //   14: iconst_0
/*     */     //   15: istore_1
/*     */     //   16: aload_0
/*     */     //   17: monitorexit
/*     */     //   18: iload_1
/*     */     //   19: ireturn
/*     */     //   20: astore_2
/*     */     //   21: aload_0
/*     */     //   22: monitorexit
/*     */     //   23: aload_2
/*     */     //   24: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #389	-> 0
/*     */     //   #390	-> 2
/*     */     //   #391	-> 20
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	20	finally
/*     */     //   16	18	20	finally
/*     */     //   21	23	20	finally
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
/*     */   public boolean isConnecting() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mConnectionState : I
/*     */     //   6: istore_1
/*     */     //   7: iconst_1
/*     */     //   8: istore_2
/*     */     //   9: iload_1
/*     */     //   10: iconst_1
/*     */     //   11: if_icmpne -> 17
/*     */     //   14: goto -> 19
/*     */     //   17: iconst_0
/*     */     //   18: istore_2
/*     */     //   19: aload_0
/*     */     //   20: monitorexit
/*     */     //   21: iload_2
/*     */     //   22: ireturn
/*     */     //   23: astore_3
/*     */     //   24: aload_0
/*     */     //   25: monitorexit
/*     */     //   26: aload_3
/*     */     //   27: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #398	-> 0
/*     */     //   #399	-> 2
/*     */     //   #400	-> 23
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	7	23	finally
/*     */     //   19	21	23	finally
/*     */     //   24	26	23	finally
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
/*     */   public Object getCarManager(String paramString) throws CarNotConnectedException {
/* 415 */     IECarXCar iECarXCar = getICarOrThrow();
/* 416 */     synchronized (this.mCarManagerLock) {
/* 417 */       ECarXCarManagerBase eCarXCarManagerBase2 = this.mServiceMap.get(paramString);
/* 418 */       ECarXCarManagerBase eCarXCarManagerBase1 = eCarXCarManagerBase2; if (eCarXCarManagerBase2 == null) {
/*     */         
/* 420 */         eCarXCarManagerBase1 = eCarXCarManagerBase2; try { StringBuilder stringBuilder; IBinder iBinder = iECarXCar.getCarService(paramString);
/* 421 */           if (iBinder == null) {
/* 422 */             eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder = new StringBuilder(); eCarXCarManagerBase1 = eCarXCarManagerBase2; this(); eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder.append("getCarManager could not get binder for service:"); eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder.append(paramString); eCarXCarManagerBase1 = eCarXCarManagerBase2; Log.w("ECarXCar", stringBuilder.toString());
/*     */ 
/*     */             
/* 425 */             return null;
/*     */           } 
/* 427 */           eCarXCarManagerBase1 = eCarXCarManagerBase2; eCarXCarManagerBase2 = createCarManager(paramString, (IBinder)stringBuilder);
/* 428 */           if (eCarXCarManagerBase2 == null) {
/* 429 */             eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder = new StringBuilder(); eCarXCarManagerBase1 = eCarXCarManagerBase2; this(); eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder.append("getCarManager could not create manager for service:"); eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder.append(paramString); eCarXCarManagerBase1 = eCarXCarManagerBase2; Log.w("ECarXCar", stringBuilder.toString());
/*     */ 
/*     */             
/* 432 */             return null;
/*     */           } 
/* 434 */           eCarXCarManagerBase1 = eCarXCarManagerBase2; this.mServiceMap.put(paramString, eCarXCarManagerBase2);
/*     */ 
/*     */           
/* 437 */           eCarXCarManagerBase1 = eCarXCarManagerBase2; }
/*     */         catch (RemoteException remoteException) { handleRemoteException(remoteException); }
/*     */       
/* 440 */       }  return eCarXCarManagerBase1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getCarManager(String paramString, IECarXCar paramIECarXCar) {
/* 457 */     synchronized (this.mCarManagerLock) {
/* 458 */       ECarXCarManagerBase eCarXCarManagerBase2 = this.mServiceMap.get(paramString);
/* 459 */       ECarXCarManagerBase eCarXCarManagerBase1 = eCarXCarManagerBase2; if (eCarXCarManagerBase2 == null) {
/*     */         
/* 461 */         eCarXCarManagerBase1 = eCarXCarManagerBase2; try { StringBuilder stringBuilder; IBinder iBinder = paramIECarXCar.getCarService(paramString);
/* 462 */           if (iBinder == null) {
/* 463 */             eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder = new StringBuilder(); eCarXCarManagerBase1 = eCarXCarManagerBase2; this(); eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder.append("getCarManager could not get binder for service:"); eCarXCarManagerBase1 = eCarXCarManagerBase2; stringBuilder.append(paramString); eCarXCarManagerBase1 = eCarXCarManagerBase2; Log.w("ECarXCar", stringBuilder.toString());
/*     */ 
/*     */             
/* 466 */             return null;
/*     */           } 
/*     */           
/* 469 */           eCarXCarManagerBase1 = eCarXCarManagerBase2; ECarXCarManagerBase eCarXCarManagerBase = createCarManager(paramString, (IBinder)stringBuilder);
/* 470 */           if (eCarXCarManagerBase == null) {
/* 471 */             eCarXCarManagerBase1 = eCarXCarManagerBase; StringBuilder stringBuilder1 = new StringBuilder(); eCarXCarManagerBase1 = eCarXCarManagerBase; this(); eCarXCarManagerBase1 = eCarXCarManagerBase; stringBuilder1.append("getCarManager could not create manager for service:"); eCarXCarManagerBase1 = eCarXCarManagerBase; stringBuilder1.append(paramString); eCarXCarManagerBase1 = eCarXCarManagerBase; Log.w("ECarXCar", stringBuilder1.toString());
/*     */ 
/*     */             
/* 474 */             return null;
/*     */           } 
/* 476 */           eCarXCarManagerBase1 = eCarXCarManagerBase; this.mServiceMap.put(paramString, eCarXCarManagerBase);
/*     */ 
/*     */           
/* 479 */           eCarXCarManagerBase1 = eCarXCarManagerBase; }
/*     */         catch (Exception exception) { exception.printStackTrace(); }
/*     */       
/* 482 */       }  return eCarXCarManagerBase1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCarConnectionType()
/*     */   {
/* 490 */     return 5; } private ECarXCarManagerBase createCarManager(String paramString, IBinder paramIBinder) { StringBuilder stringBuilder1; ECarXCarHardKeyManager eCarXCarHardKeyManager;
/*     */     XmaDvrHttpManager xmaDvrHttpManager;
/*     */     XmaDvrManager xmaDvrManager;
/*     */     byte b;
/* 494 */     StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append("createCarManager: "); stringBuilder2.append(paramString); Log.d("ECarXCar", stringBuilder2.toString());
/* 495 */     stringBuilder2 = null;
/* 496 */     switch (paramString.hashCode()) { default: b = -1; break;case 1494249872: if (paramString.equals("xma_dvr_http_service")) { b = 3; break; } case 1413494131: if (paramString.equals("car_signal")) { b = 0; break; } case 1364676579: if (paramString.equals("xma_dvr_service")) { b = 2; break; } case 1197624296: if (paramString.equals("car_publicattribute")) { b = 1; break; } case -523123671: if (paramString.equals("car_hardkey")) { b = 4; break; }  }  switch (b) { default: return (ECarXCarManagerBase)stringBuilder2;
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
/*     */       case 4:
/* 510 */         return new ECarXCarHardKeyManager(this.mContext, paramIBinder);
/*     */       case 3: return new XmaDvrHttpManager(paramIBinder, this.mContext, this.mEventHandler);
/*     */       case 2:
/*     */         return new XmaDvrManager(paramIBinder, this.mContext, this.mEventHandler);
/*     */       case 1:
/*     */         return (ECarXCarManagerBase)new ECarXCarSetManager(paramIBinder, this.mContext, this.mEventHandler);
/*     */       case 0:
/* 517 */         break; }  return (ECarXCarManagerBase)new CarSignalManager(paramIBinder, this.mContext, this.mEventHandler); } private void startCarService() { Intent intent = new Intent();
/* 518 */     intent.setPackage("com.ecarx.car");
/* 519 */     intent.setAction("ecarx.car.IECarXCar");
/* 520 */     Log.d("ECarXCar", "startCarService: start");
/* 521 */     boolean bool = this.mContext.bindServiceAsUser(intent, this.mServiceConnectionListener, 1, UserHandle.SYSTEM);
/*     */     
/* 523 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("startCarService: "); stringBuilder.append(bool); Log.d("ECarXCar", stringBuilder.toString());
/*     */     
/*     */     /* monitor enter ThisExpression{ObjectType{ecarx/car/ECarXCar}} */
/* 526 */     if (!bool) { try {
/* 527 */         this.mConnectionRetryCount++;
/* 528 */         if (this.mConnectionRetryCount > 20L) {
/* 529 */           Log.w("ECarXCar", "cannot bind to car service after max retry");
/* 530 */           this.mMainThreadEventHandler.post(this.mConnectionRetryFailedRunnable);
/*     */         } else {
/* 532 */           this.mEventHandler.postDelayed(this.mConnectionRetryRunnable, 500L);
/*     */         } 
/*     */       } finally {} }
/*     */     else
/* 536 */     { this.mConnectionRetryCount = 0; }
/*     */     
/*     */     /* monitor exit ThisExpression{ObjectType{ecarx/car/ECarXCar}} */ }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IECarXCar getICarOrThrow() throws IllegalStateException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mService : Lecarx/car/IECarXCar;
/*     */     //   6: ifnull -> 18
/*     */     //   9: aload_0
/*     */     //   10: getfield mService : Lecarx/car/IECarXCar;
/*     */     //   13: astore_1
/*     */     //   14: aload_0
/*     */     //   15: monitorexit
/*     */     //   16: aload_1
/*     */     //   17: areturn
/*     */     //   18: new java/lang/IllegalStateException
/*     */     //   21: astore_1
/*     */     //   22: aload_1
/*     */     //   23: ldc_w 'not connected'
/*     */     //   26: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   29: aload_1
/*     */     //   30: athrow
/*     */     //   31: astore_1
/*     */     //   32: aload_0
/*     */     //   33: monitorexit
/*     */     //   34: aload_1
/*     */     //   35: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #542	-> 2
/*     */     //   #545	-> 9
/*     */     //   #543	-> 18
/*     */     //   #541	-> 31
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	31	finally
/*     */     //   9	14	31	finally
/*     */     //   18	31	31	finally
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleRemoteException(RemoteException paramRemoteException) {
/* 549 */     Log.w("ECarXCar", "RemoteException", (Throwable)paramRemoteException);
/* 550 */     disconnect();
/*     */   }
/*     */   
/*     */   private void tearDownCarManagers() {
/* 554 */     synchronized (this.mCarManagerLock) {
/* 555 */       if (!this.mServiceMap.isEmpty()) {
/* 556 */         for (ECarXCarManagerBase eCarXCarManagerBase : this.mServiceMap.values()) {
/* 557 */           eCarXCarManagerBase.onCarDisconnected();
/*     */         }
/* 559 */         this.mServiceMap.clear();
/* 560 */         Log.d("ECarXCar", "tearDownCarManagers");
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   } public static interface CarServiceDieCallback {
/*     */     void onServiceDeath(); } @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface ConnectionType {} private class ManagerDeathRecipient implements IBinder.DeathRecipient { final ECarXCar this$0;
/*     */     private ManagerDeathRecipient() {}
/*     */     public void binderDied() {
/* 569 */       Log.w("ECarXCar", "Signal Service died.");
/* 570 */       ECarXCar.this.mDeaService.unlinkToDeath(ECarXCar.this.mDeathRecipient, 0);
/* 571 */       ECarXCar.this.tearDownCarManagers();
/* 572 */       if (ECarXCar.this.mDeaCallback != null)
/* 573 */         ECarXCar.this.mDeaCallback.onServiceDeath(); 
/*     */     } }
/*     */ 
/*     */   
/*     */   public void registerDieCallback(CarServiceDieCallback paramCarServiceDieCallback) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: aload_1
/*     */     //   4: putfield mDeaCallback : Lecarx/car/ECarXCar$CarServiceDieCallback;
/*     */     //   7: aload_0
/*     */     //   8: monitorexit
/*     */     //   9: return
/*     */     //   10: astore_1
/*     */     //   11: aload_0
/*     */     //   12: monitorexit
/*     */     //   13: aload_1
/*     */     //   14: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #591	-> 2
/*     */     //   #592	-> 7
/*     */     //   #590	-> 10
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	7	10	finally
/*     */   }
/*     */   
/*     */   public void unregisterDieCallback() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: aconst_null
/*     */     //   4: putfield mDeaCallback : Lecarx/car/ECarXCar$CarServiceDieCallback;
/*     */     //   7: aload_0
/*     */     //   8: monitorexit
/*     */     //   9: return
/*     */     //   10: astore_1
/*     */     //   11: aload_0
/*     */     //   12: monitorexit
/*     */     //   13: aload_1
/*     */     //   14: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #597	-> 2
/*     */     //   #598	-> 7
/*     */     //   #596	-> 10
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	7	10	finally
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\ECarXCar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */