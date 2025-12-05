/*     */ package android.car;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.cluster.CarInstrumentClusterManager;
/*     */ import android.car.content.pm.CarPackageManager;
/*     */ import android.car.diagnostic.CarDiagnosticManager;
/*     */ import android.car.drivingstate.CarDrivingStateManager;
/*     */ import android.car.drivingstate.CarUxRestrictionsManager;
/*     */ import android.car.hardware.CarSensorManager;
/*     */ import android.car.hardware.CarVendorExtensionManager;
/*     */ import android.car.hardware.cabin.CarCabinManager;
/*     */ import android.car.hardware.hvac.CarHvacManager;
/*     */ import android.car.hardware.power.CarPowerManager;
/*     */ import android.car.hardware.property.CarPropertyManager;
/*     */ import android.car.media.CarAudioManager;
/*     */ import android.car.navigation.CarNavigationStatusManager;
/*     */ import android.car.settings.CarConfigurationManager;
/*     */ import android.car.storagemonitoring.CarStorageMonitoringManager;
/*     */ import android.car.test.CarTestManagerBinderWrapper;
/*     */ import android.car.vms.VmsSubscriberManager;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.os.UserHandle;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Car
/*     */ {
/* 473 */   private final Runnable mConnectionRetryRunnable = new Runnable() { final Car this$0;
/*     */       
/*     */       public void run() {
/* 476 */         Car.this.startCarService();
/*     */       } }
/*     */   ;
/*     */   
/* 480 */   private final Runnable mConnectionRetryFailedRunnable = new Runnable() { final Car this$0;
/*     */       
/*     */       public void run() {
/* 483 */         Car.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName("com.android.car", "com.android.car.CarService"));
/*     */       } }
/*     */   ;
/*     */ 
/*     */   
/* 488 */   private final ServiceConnection mServiceConnectionListener = new ServiceConnection() { final Car this$0;
/*     */       
/*     */       public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/* 491 */         synchronized (Car.this) {
/* 492 */           Car.access$202(Car.this, ICar.Stub.asInterface(param1IBinder));
/* 493 */           Car.access$302(Car.this, 2);
/*     */           
/* 495 */           Car.this.mServiceConnectionListenerClient.onServiceConnected(param1ComponentName, param1IBinder);
/*     */           return;
/*     */         } 
/*     */       } public void onServiceDisconnected(ComponentName param1ComponentName) {
/* 499 */         synchronized (Car.this) {
/* 500 */           Car.access$202(Car.this, null);
/* 501 */           if (Car.this.mConnectionState == 0) {
/*     */             return;
/*     */           }
/* 504 */           Car.access$302(Car.this, 0);
/*     */ 
/*     */           
/* 507 */           Car.this.disconnect();
/* 508 */           Car.this.mServiceConnectionListenerClient.onServiceDisconnected(param1ComponentName);
/*     */           return;
/*     */         } 
/*     */       } }
/*     */   ;
/* 513 */   private final Object mCarManagerLock = new Object(); @GuardedBy("mCarManagerLock")
/* 514 */   private final HashMap<String, CarManagerBase> mServiceMap = new HashMap<>(); public static final String APP_FOCUS_SERVICE = "app_focus"; public static final String AUDIO_SERVICE = "audio"; public static final String BLUETOOTH_SERVICE = "car_bluetooth"; @SystemApi
/*     */   public static final String CABIN_SERVICE = "cabin"; public static final String CAR_CONFIGURATION_SERVICE = "configuration"; @SystemApi
/*     */   public static final String CAR_DRIVING_STATE_SERVICE = "drivingstate"; public static final String CAR_EXTRA_MEDIA_PACKAGE = "android.car.intent.extra.MEDIA_PACKAGE"; public static final String CAR_INSTRUMENT_CLUSTER_SERVICE = "cluster_service"; public static final String CAR_INTENT_ACTION_MEDIA_TEMPLATE = "android.car.intent.action.MEDIA_TEMPLATE"; public static final String CAR_NAVIGATION_SERVICE = "car_navigation_service"; public static final String CAR_NOT_CONNECTED_EXCEPTION_MSG = "CarNotConnected"; private static final long CAR_SERVICE_BIND_MAX_RETRY = 20L; private static final long CAR_SERVICE_BIND_RETRY_INTERVAL_MS = 500L; private static final String CAR_SERVICE_CLASS = "com.android.car.CarService"; public static final String CAR_SERVICE_INTERFACE_NAME = "android.car.ICar"; private static final String CAR_SERVICE_PACKAGE = "com.android.car"; public static final String CAR_UX_RESTRICTION_SERVICE = "uxrestriction"; public static final int CONNECTION_TYPE_EMBEDDED = 5; @SystemApi
/*     */   public static final String DIAGNOSTIC_SERVICE = "diagnostic"; @SystemApi
/*     */   public static final String HVAC_SERVICE = "hvac"; public static final String INFO_SERVICE = "info"; public static final String PACKAGE_SERVICE = "package"; public static final String PERMISSION_CAR_CONTROL_AUDIO_SETTINGS = "android.car.permission.CAR_CONTROL_AUDIO_SETTINGS"; public static final String PERMISSION_CAR_CONTROL_AUDIO_VOLUME = "android.car.permission.CAR_CONTROL_AUDIO_VOLUME"; @SystemApi
/*     */   public static final String PERMISSION_CAR_DIAGNOSTIC_CLEAR = "android.car.permission.CLEAR_CAR_DIAGNOSTICS"; @SystemApi
/*     */   public static final String PERMISSION_CAR_DIAGNOSTIC_READ_ALL = "android.car.permission.CAR_DIAGNOSTICS"; public static final String PERMISSION_CAR_DISPLAY_IN_CLUSTER = "android.car.permission.CAR_DISPLAY_IN_CLUSTER"; @SystemApi
/*     */   public static final String PERMISSION_CAR_DRIVING_STATE = "android.car.permission.CAR_DRIVING_STATE"; @SystemApi
/*     */   public static final String PERMISSION_CAR_DYNAMICS_STATE = "android.car.permission.CAR_DYNAMICS_STATE"; @SystemApi
/*     */   public static final String PERMISSION_CAR_ENGINE_DETAILED = "android.car.permission.CAR_ENGINE_DETAILED"; public static final String PERMISSION_CAR_INFO = "android.car.permission.CAR_INFO"; @SystemApi
/*     */   public static final String PERMISSION_CAR_INSTRUMENT_CLUSTER_CONTROL = "android.car.permission.CAR_INSTRUMENT_CLUSTER_CONTROL"; public static final String PERMISSION_CAR_NAVIGATION_MANAGER = "android.car.permission.CAR_NAVIGATION_MANAGER"; @SystemApi
/*     */   public static final String PERMISSION_CAR_POWER = "android.car.permission.CAR_POWER"; @SystemApi
/*     */   public static final String PERMISSION_CAR_PROJECTION = "android.car.permission.CAR_PROJECTION"; @SystemApi
/*     */   public static final String PERMISSION_CAR_TEST_SERVICE = "android.car.permission.CAR_TEST_SERVICE";
/*     */   @SystemApi
/*     */   public static final String PERMISSION_CONTROL_APP_BLOCKING = "android.car.permission.CONTROL_APP_BLOCKING";
/*     */   @SystemApi
/*     */   public static final String PERMISSION_CONTROL_CAR_CLIMATE = "android.car.permission.CONTROL_CAR_CLIMATE";
/*     */   
/* 533 */   public static Car createCar(Context paramContext, ServiceConnection paramServiceConnection, Handler paramHandler) { if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
/* 534 */       Log.e("CAR.L", "FEATURE_AUTOMOTIVE not declared while android.car is used");
/* 535 */       return null;
/*     */     } 
/*     */     try {
/* 538 */       return new Car(paramContext, paramServiceConnection, paramHandler);
/* 539 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */       
/* 542 */       return null;
/*     */     }  } @SystemApi public static final String PERMISSION_CONTROL_CAR_DOORS = "android.car.permission.CONTROL_CAR_DOORS"; @SystemApi public static final String PERMISSION_CONTROL_CAR_MIRRORS = "android.car.permission.CONTROL_CAR_MIRRORS"; @SystemApi public static final String PERMISSION_CONTROL_CAR_SEATS = "android.car.permission.CONTROL_CAR_SEATS"; @SystemApi public static final String PERMISSION_CONTROL_CAR_WINDOWS = "android.car.permission.CONTROL_CAR_WINDOWS"; @SystemApi
/*     */   public static final String PERMISSION_CONTROL_EXTERIOR_LIGHTS = "android.car.permission.CONTROL_CAR_EXTERIOR_LIGHTS"; public static final String PERMISSION_ENERGY = "android.car.permission.CAR_ENERGY"; public static final String PERMISSION_ENERGY_PORTS = "android.car.permission.CAR_ENERGY_PORTS"; public static final String PERMISSION_EXTERIOR_ENVIRONMENT = "android.car.permission.CAR_EXTERIOR_ENVIRONMENT"; @SystemApi
/*     */   public static final String PERMISSION_EXTERIOR_LIGHTS = "android.car.permission.CAR_EXTERIOR_LIGHTS"; public static final String PERMISSION_IDENTIFICATION = "android.car.permission.CAR_IDENTIFICATION"; @SystemApi
/*     */   public static final String PERMISSION_MILEAGE = "android.car.permission.CAR_MILEAGE"; @SystemApi
/*     */   public static final String PERMISSION_MOCK_VEHICLE_HAL = "android.car.permission.CAR_MOCK_VEHICLE_HAL"; public static final String PERMISSION_POWERTRAIN = "android.car.permission.CAR_POWERTRAIN"; public static final String PERMISSION_SPEED = "android.car.permission.CAR_SPEED"; @SystemApi
/*     */   public static final String PERMISSION_STORAGE_MONITORING = "android.car.permission.STORAGE_MONITORING"; @SystemApi
/*     */   public static final String PERMISSION_TIRES = "android.car.permission.CAR_TIRES"; @SystemApi
/*     */   public static final String PERMISSION_VENDOR_EXTENSION = "android.car.permission.CAR_VENDOR_EXTENSION"; @SystemApi
/*     */   public static final String PERMISSION_VMS_PUBLISHER = "android.car.permission.VMS_PUBLISHER"; @SystemApi
/* 552 */   public static final String PERMISSION_VMS_SUBSCRIBER = "android.car.permission.VMS_SUBSCRIBER"; public static Car createCar(Context paramContext, ServiceConnection paramServiceConnection) { return createCar(paramContext, paramServiceConnection, null); } @SystemApi public static final String POWER_SERVICE = "power"; @SystemApi public static final String PROJECTION_SERVICE = "projection"; @SystemApi public static final String PROPERTY_SERVICE = "property"; public static final String SENSOR_SERVICE = "sensor"; private static final int STATE_CONNECTED = 2; private static final int STATE_CONNECTING = 1; private static final int STATE_DISCONNECTED = 0; @SystemApi public static final String STORAGE_MONITORING_SERVICE = "storage_monitoring"; @SystemApi public static final String TEST_SERVICE = "car-service-test"; @SystemApi
/*     */   public static final String VENDOR_EXTENSION_SERVICE = "vendor_extension"; public static final int VERSION = 3; @SystemApi
/*     */   public static final String VMS_SUBSCRIBER_SERVICE = "vehicle_map_subscriber_service"; @GuardedBy("this")
/*     */   private int mConnectionRetryCount; @GuardedBy("this")
/*     */   private int mConnectionState; private final Context mContext; private final Handler mEventHandler; private final Handler mMainThreadEventHandler; private final boolean mOwnsService; @GuardedBy("this")
/* 557 */   private ICar mService; private final ServiceConnection mServiceConnectionListenerClient; private Car(Context paramContext, ServiceConnection paramServiceConnection, Handler paramHandler) { this.mContext = paramContext;
/* 558 */     this.mEventHandler = determineEventHandler(paramHandler);
/* 559 */     this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
/*     */     
/* 561 */     this.mService = null;
/* 562 */     this.mOwnsService = true;
/* 563 */     this.mServiceConnectionListenerClient = paramServiceConnection; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Car(Context paramContext, ICar paramICar, Handler paramHandler) {
/* 572 */     this.mContext = paramContext;
/* 573 */     this.mEventHandler = determineEventHandler(paramHandler);
/* 574 */     this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
/*     */     
/* 576 */     this.mService = paramICar;
/* 577 */     this.mOwnsService = false;
/* 578 */     this.mConnectionState = 2;
/* 579 */     this.mServiceConnectionListenerClient = null;
/*     */   }
/*     */   
/*     */   private static Handler determineMainThreadEventHandler(Handler paramHandler) {
/* 583 */     Looper looper = Looper.getMainLooper();
/* 584 */     if (paramHandler.getLooper() != looper) paramHandler = new Handler(looper);  return paramHandler;
/*     */   }
/*     */   
/*     */   private static Handler determineEventHandler(Handler paramHandler) {
/* 588 */     Handler handler = paramHandler; if (paramHandler == null) {
/* 589 */       Looper looper = Looper.getMainLooper();
/* 590 */       handler = new Handler(looper);
/*     */     } 
/* 592 */     return handler;
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
/*     */     //   #601	-> 0
/*     */     //   #602	-> 2
/*     */     //   #605	-> 9
/*     */     //   #606	-> 14
/*     */     //   #607	-> 18
/*     */     //   #608	-> 20
/*     */     //   #603	-> 21
/*     */     //   #607	-> 34
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
/*     */     //   2: aload_0
/*     */     //   3: getfield mConnectionState : I
/*     */     //   6: ifne -> 12
/*     */     //   9: aload_0
/*     */     //   10: monitorexit
/*     */     //   11: return
/*     */     //   12: aload_0
/*     */     //   13: getfield mEventHandler : Landroid/os/Handler;
/*     */     //   16: aload_0
/*     */     //   17: getfield mConnectionRetryRunnable : Ljava/lang/Runnable;
/*     */     //   20: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
/*     */     //   23: aload_0
/*     */     //   24: getfield mMainThreadEventHandler : Landroid/os/Handler;
/*     */     //   27: aload_0
/*     */     //   28: getfield mConnectionRetryFailedRunnable : Ljava/lang/Runnable;
/*     */     //   31: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
/*     */     //   34: aload_0
/*     */     //   35: iconst_0
/*     */     //   36: putfield mConnectionRetryCount : I
/*     */     //   39: aload_0
/*     */     //   40: invokespecial tearDownCarManagers : ()V
/*     */     //   43: aload_0
/*     */     //   44: aconst_null
/*     */     //   45: putfield mService : Landroid/car/ICar;
/*     */     //   48: aload_0
/*     */     //   49: iconst_0
/*     */     //   50: putfield mConnectionState : I
/*     */     //   53: aload_0
/*     */     //   54: getfield mOwnsService : Z
/*     */     //   57: ifeq -> 71
/*     */     //   60: aload_0
/*     */     //   61: getfield mContext : Landroid/content/Context;
/*     */     //   64: aload_0
/*     */     //   65: getfield mServiceConnectionListener : Landroid/content/ServiceConnection;
/*     */     //   68: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
/*     */     //   71: aload_0
/*     */     //   72: monitorexit
/*     */     //   73: return
/*     */     //   74: astore_1
/*     */     //   75: aload_0
/*     */     //   76: monitorexit
/*     */     //   77: aload_1
/*     */     //   78: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #616	-> 0
/*     */     //   #617	-> 2
/*     */     //   #618	-> 9
/*     */     //   #620	-> 12
/*     */     //   #621	-> 23
/*     */     //   #622	-> 34
/*     */     //   #623	-> 39
/*     */     //   #624	-> 43
/*     */     //   #625	-> 48
/*     */     //   #627	-> 53
/*     */     //   #628	-> 60
/*     */     //   #630	-> 71
/*     */     //   #631	-> 73
/*     */     //   #630	-> 74
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	74	finally
/*     */     //   9	11	74	finally
/*     */     //   12	23	74	finally
/*     */     //   23	34	74	finally
/*     */     //   34	39	74	finally
/*     */     //   39	43	74	finally
/*     */     //   43	48	74	finally
/*     */     //   48	53	74	finally
/*     */     //   53	60	74	finally
/*     */     //   60	71	74	finally
/*     */     //   71	73	74	finally
/*     */     //   75	77	74	finally
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
/*     */     //   3: getfield mService : Landroid/car/ICar;
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
/*     */     //   #639	-> 0
/*     */     //   #640	-> 2
/*     */     //   #641	-> 20
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
/*     */     //   #649	-> 0
/*     */     //   #650	-> 2
/*     */     //   #651	-> 23
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
/*     */   public Object getCarManager(String paramString) throws CarNotConnectedException {
/* 665 */     ICar iCar = getICarOrThrow();
/* 666 */     synchronized (this.mCarManagerLock) {
/* 667 */       CarManagerBase carManagerBase2 = this.mServiceMap.get(paramString);
/* 668 */       CarManagerBase carManagerBase1 = carManagerBase2; if (carManagerBase2 == null) {
/*     */         
/* 670 */         carManagerBase1 = carManagerBase2; try { StringBuilder stringBuilder; IBinder iBinder = iCar.getCarService(paramString);
/* 671 */           if (iBinder == null) {
/* 672 */             carManagerBase1 = carManagerBase2; stringBuilder = new StringBuilder(); carManagerBase1 = carManagerBase2; this(); carManagerBase1 = carManagerBase2; stringBuilder.append("getCarManager could not get binder for service:"); carManagerBase1 = carManagerBase2; stringBuilder.append(paramString); carManagerBase1 = carManagerBase2; Log.w("CAR.L", stringBuilder.toString());
/*     */             
/* 674 */             return null;
/*     */           } 
/* 676 */           carManagerBase1 = carManagerBase2; carManagerBase2 = createCarManager(paramString, (IBinder)stringBuilder);
/* 677 */           if (carManagerBase2 == null) {
/* 678 */             carManagerBase1 = carManagerBase2; stringBuilder = new StringBuilder(); carManagerBase1 = carManagerBase2; this(); carManagerBase1 = carManagerBase2; stringBuilder.append("getCarManager could not create manager for service:"); carManagerBase1 = carManagerBase2; stringBuilder.append(paramString); carManagerBase1 = carManagerBase2; Log.w("CAR.L", stringBuilder.toString());
/*     */ 
/*     */             
/* 681 */             return null;
/*     */           } 
/* 683 */           carManagerBase1 = carManagerBase2; this.mServiceMap.put(paramString, carManagerBase2);
/*     */ 
/*     */           
/* 686 */           carManagerBase1 = carManagerBase2; }
/*     */         catch (RemoteException remoteException) { handleRemoteException(remoteException); }
/*     */       
/* 689 */       }  return carManagerBase1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCarConnectionType() {
/* 698 */     return 5;
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
/* 712 */     String str = paramIllegalStateException.getMessage();
/* 713 */     if ("CarNotConnected".equals(str)) {
/* 714 */       throw new CarNotConnectedException();
/*     */     }
/* 716 */     throw paramIllegalStateException;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hideCarNotConnectedExceptionFromCarService(IllegalStateException paramIllegalStateException) throws IllegalStateException
/*     */   {
/* 723 */     String str = paramIllegalStateException.getMessage();
/* 724 */     if ("CarNotConnected".equals(str)) {
/*     */       return;
/*     */     }
/* 727 */     throw paramIllegalStateException; } private CarManagerBase createCarManager(String paramString, IBinder paramIBinder) throws CarNotConnectedException { CarConfigurationManager carConfigurationManager; CarUxRestrictionsManager carUxRestrictionsManager; CarDrivingStateManager carDrivingStateManager; CarStorageMonitoringManager carStorageMonitoringManager; CarBluetoothManager carBluetoothManager; VmsSubscriberManager vmsSubscriberManager; CarTestManagerBinderWrapper carTestManagerBinderWrapper; CarInstrumentClusterManager carInstrumentClusterManager; CarVendorExtensionManager carVendorExtensionManager; CarPropertyManager carPropertyManager; CarProjectionManager carProjectionManager; CarPowerManager carPowerManager; CarHvacManager carHvacManager; CarDiagnosticManager carDiagnosticManager; CarCabinManager carCabinManager;
/*     */     CarNavigationStatusManager carNavigationStatusManager;
/*     */     CarPackageManager carPackageManager;
/*     */     CarAppFocusManager carAppFocusManager;
/*     */     CarInfoManager carInfoManager;
/*     */     byte b;
/* 733 */     String str = null;
/* 734 */     switch (paramString.hashCode()) { default: b = -1; break;case 1932752118: if (paramString.equals("configuration")) { b = 20; break; } case 1830376762: if (paramString.equals("app_focus")) { b = 3; break; } case 1644291440: if (paramString.equals("cluster_service")) { b = 13; break; } case 1075548489: if (paramString.equals("uxrestriction")) { b = 19; break; } case 486923284: if (paramString.equals("vehicle_map_subscriber_service")) { b = 15; break; } case 106858757: if (paramString.equals("power")) { b = 9; break; } case 94415849: if (paramString.equals("cabin")) { b = 6; break; } case 93166550: if (paramString.equals("audio")) { b = 0; break; } case 3237038: if (paramString.equals("info")) { b = 2; break; } case 3214768: if (paramString.equals("hvac")) { b = 8; break; } case -259003252: if (paramString.equals("storage_monitoring")) { b = 17; break; } case -444756694: if (paramString.equals("drivingstate")) { b = 18; break; } case -603093501: if (paramString.equals("car-service-test")) { b = 14; break; } case -807062458: if (paramString.equals("package")) { b = 4; break; } case -874200568: if (paramString.equals("vendor_extension")) { b = 12; break; } case -905948230: if (paramString.equals("sensor")) { b = 1; break; } case -993141291: if (paramString.equals("property")) { b = 11; break; } case -1547904089: if (paramString.equals("diagnostic")) { b = 7; break; } case -1853877803: if (paramString.equals("car_navigation_service")) { b = 5; break; } case -1855028221: if (paramString.equals("car_bluetooth")) { b = 16; break; } case -1969960369: if (paramString.equals("projection")) { b = 10; break; }  }  switch (b) { default: paramString = str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 804 */         return (CarManagerBase)paramString;case 20: return (CarManagerBase)new CarConfigurationManager(paramIBinder);case 19: return (CarManagerBase)new CarUxRestrictionsManager(paramIBinder, this.mContext, this.mEventHandler);case 18: return (CarManagerBase)new CarDrivingStateManager(paramIBinder, this.mContext, this.mEventHandler);case 17: return (CarManagerBase)new CarStorageMonitoringManager(paramIBinder, this.mEventHandler);case 16: return new CarBluetoothManager(paramIBinder, this.mContext);case 15: return (CarManagerBase)new VmsSubscriberManager(paramIBinder);case 14: return (CarManagerBase)new CarTestManagerBinderWrapper(paramIBinder);case 13: return (CarManagerBase)new CarInstrumentClusterManager(paramIBinder, this.mEventHandler);case 12: return (CarManagerBase)new CarVendorExtensionManager(paramIBinder, this.mEventHandler);case 11: return (CarManagerBase)new CarPropertyManager(paramIBinder, this.mEventHandler, false, "CarPropertyManager");case 10: return new CarProjectionManager(paramIBinder, this.mEventHandler);case 9: return (CarManagerBase)new CarPowerManager(paramIBinder, this.mContext, this.mEventHandler);case 8: return (CarManagerBase)new CarHvacManager(paramIBinder, this.mContext, this.mEventHandler);case 7: return (CarManagerBase)new CarDiagnosticManager(paramIBinder, this.mContext, this.mEventHandler);case 6: return (CarManagerBase)new CarCabinManager(paramIBinder, this.mContext, this.mEventHandler);case 5: return (CarManagerBase)new CarNavigationStatusManager(paramIBinder);case 4: return (CarManagerBase)new CarPackageManager(paramIBinder, this.mContext);
/*     */       case 3: return new CarAppFocusManager(paramIBinder, this.mEventHandler);
/*     */       case 2: return new CarInfoManager(paramIBinder);
/*     */       case 1: return (CarManagerBase)new CarSensorManager(paramIBinder, this.mContext, this.mEventHandler);
/* 808 */       case 0: break; }  return (CarManagerBase)new CarAudioManager(paramIBinder, this.mContext, this.mEventHandler); } private void startCarService() { Intent intent = new Intent();
/* 809 */     intent.setPackage("com.android.car");
/* 810 */     intent.setAction("android.car.ICar");
/* 811 */     boolean bool = this.mContext.bindServiceAsUser(intent, this.mServiceConnectionListener, 1, UserHandle.CURRENT_OR_SELF);
/*     */     
/* 813 */     if (!bool) {
/* 814 */       this.mConnectionRetryCount++;
/* 815 */       if (this.mConnectionRetryCount > 20L) {
/* 816 */         Log.w("CAR.L", "cannot bind to car service after max retry");
/* 817 */         this.mMainThreadEventHandler.post(this.mConnectionRetryFailedRunnable);
/*     */       } else {
/* 819 */         this.mEventHandler.postDelayed(this.mConnectionRetryRunnable, 500L);
/*     */       } 
/*     */     } else {
/*     */       
/* 823 */       this.mConnectionRetryCount = 0;
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ICar getICarOrThrow() throws IllegalStateException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mService : Landroid/car/ICar;
/*     */     //   6: ifnull -> 18
/*     */     //   9: aload_0
/*     */     //   10: getfield mService : Landroid/car/ICar;
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
/*     */     //   #828	-> 2
/*     */     //   #831	-> 9
/*     */     //   #829	-> 18
/*     */     //   #827	-> 31
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	31	finally
/*     */     //   9	14	31	finally
/*     */     //   18	31	31	finally
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleRemoteException(RemoteException paramRemoteException) {
/* 835 */     Log.w("CAR.L", "RemoteException", (Throwable)paramRemoteException);
/* 836 */     disconnect();
/*     */   }
/*     */   
/*     */   private void tearDownCarManagers() {
/* 840 */     synchronized (this.mCarManagerLock) {
/* 841 */       for (CarManagerBase carManagerBase : this.mServiceMap.values()) {
/* 842 */         carManagerBase.onCarDisconnected();
/*     */       }
/* 844 */       this.mServiceMap.clear();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface ConnectionType {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\Car.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */