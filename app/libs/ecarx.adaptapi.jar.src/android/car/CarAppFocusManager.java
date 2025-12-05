/*     */ package android.car;
/*     */ 
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CarAppFocusManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   public static final int APP_FOCUS_MAX = 2;
/*     */   public static final int APP_FOCUS_REQUEST_FAILED = 0;
/*     */   public static final int APP_FOCUS_REQUEST_SUCCEEDED = 1;
/*     */   public static final int APP_FOCUS_TYPE_NAVIGATION = 1;
/*     */   public static final int APP_FOCUS_TYPE_VOICE_COMMAND = 2;
/* 116 */   private final Map<OnAppFocusChangedListener, IAppFocusListenerImpl> mChangeBinders = new HashMap<>();
/*     */   private final Handler mHandler;
/* 118 */   private final Map<OnAppFocusOwnershipCallback, IAppFocusOwnershipCallbackImpl> mOwnershipBinders = new HashMap<>();
/*     */ 
/*     */   
/*     */   private final IAppFocus mService;
/*     */ 
/*     */   
/*     */   CarAppFocusManager(IBinder paramIBinder, Handler paramHandler) {
/* 125 */     this.mService = IAppFocus.Stub.asInterface(paramIBinder);
/* 126 */     this.mHandler = paramHandler;
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
/*     */   public void addFocusListener(OnAppFocusChangedListener paramOnAppFocusChangedListener, int paramInt) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 86
/*     */     //   4: aload_0
/*     */     //   5: monitorenter
/*     */     //   6: aload_0
/*     */     //   7: getfield mChangeBinders : Ljava/util/Map;
/*     */     //   10: aload_1
/*     */     //   11: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   16: checkcast android/car/CarAppFocusManager$IAppFocusListenerImpl
/*     */     //   19: astore #4
/*     */     //   21: aload #4
/*     */     //   23: astore_3
/*     */     //   24: aload #4
/*     */     //   26: ifnonnull -> 52
/*     */     //   29: new android/car/CarAppFocusManager$IAppFocusListenerImpl
/*     */     //   32: astore_3
/*     */     //   33: aload_3
/*     */     //   34: aload_0
/*     */     //   35: aload_1
/*     */     //   36: aconst_null
/*     */     //   37: invokespecial <init> : (Landroid/car/CarAppFocusManager;Landroid/car/CarAppFocusManager$OnAppFocusChangedListener;Landroid/car/CarAppFocusManager$1;)V
/*     */     //   40: aload_0
/*     */     //   41: getfield mChangeBinders : Ljava/util/Map;
/*     */     //   44: aload_1
/*     */     //   45: aload_3
/*     */     //   46: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   51: pop
/*     */     //   52: aload_3
/*     */     //   53: iload_2
/*     */     //   54: invokevirtual addAppType : (I)V
/*     */     //   57: aload_0
/*     */     //   58: monitorexit
/*     */     //   59: aload_0
/*     */     //   60: getfield mService : Landroid/car/IAppFocus;
/*     */     //   63: aload_3
/*     */     //   64: iload_2
/*     */     //   65: invokeinterface registerFocusListener : (Landroid/car/IAppFocusListener;I)V
/*     */     //   70: return
/*     */     //   71: astore_1
/*     */     //   72: new android/car/CarNotConnectedException
/*     */     //   75: dup
/*     */     //   76: aload_1
/*     */     //   77: invokespecial <init> : (Ljava/lang/Exception;)V
/*     */     //   80: athrow
/*     */     //   81: astore_1
/*     */     //   82: aload_0
/*     */     //   83: monitorexit
/*     */     //   84: aload_1
/*     */     //   85: athrow
/*     */     //   86: new java/lang/IllegalArgumentException
/*     */     //   89: dup
/*     */     //   90: ldc 'null listener'
/*     */     //   92: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   95: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #137	-> 0
/*     */     //   #141	-> 4
/*     */     //   #142	-> 6
/*     */     //   #143	-> 21
/*     */     //   #144	-> 29
/*     */     //   #145	-> 40
/*     */     //   #147	-> 52
/*     */     //   #148	-> 57
/*     */     //   #150	-> 59
/*     */     //   #153	-> 70
/*     */     //   #154	-> 70
/*     */     //   #151	-> 71
/*     */     //   #152	-> 72
/*     */     //   #148	-> 81
/*     */     //   #138	-> 86
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	21	81	finally
/*     */     //   29	40	81	finally
/*     */     //   40	52	81	finally
/*     */     //   52	57	81	finally
/*     */     //   57	59	81	finally
/*     */     //   59	70	71	android/os/RemoteException
/*     */     //   82	84	81	finally
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
/*     */   public void removeFocusListener(OnAppFocusChangedListener paramOnAppFocusChangedListener, int paramInt) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mChangeBinders : Ljava/util/Map;
/*     */     //   6: aload_1
/*     */     //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   12: checkcast android/car/CarAppFocusManager$IAppFocusListenerImpl
/*     */     //   15: astore_3
/*     */     //   16: aload_3
/*     */     //   17: ifnonnull -> 23
/*     */     //   20: aload_0
/*     */     //   21: monitorexit
/*     */     //   22: return
/*     */     //   23: aload_0
/*     */     //   24: monitorexit
/*     */     //   25: aload_0
/*     */     //   26: getfield mService : Landroid/car/IAppFocus;
/*     */     //   29: aload_3
/*     */     //   30: iload_2
/*     */     //   31: invokeinterface unregisterFocusListener : (Landroid/car/IAppFocusListener;I)V
/*     */     //   36: goto -> 41
/*     */     //   39: astore #4
/*     */     //   41: aload_0
/*     */     //   42: monitorenter
/*     */     //   43: aload_3
/*     */     //   44: iload_2
/*     */     //   45: invokevirtual removeAppType : (I)V
/*     */     //   48: aload_3
/*     */     //   49: invokevirtual hasAppTypes : ()Z
/*     */     //   52: ifne -> 66
/*     */     //   55: aload_0
/*     */     //   56: getfield mChangeBinders : Ljava/util/Map;
/*     */     //   59: aload_1
/*     */     //   60: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   65: pop
/*     */     //   66: aload_0
/*     */     //   67: monitorexit
/*     */     //   68: return
/*     */     //   69: astore_1
/*     */     //   70: aload_0
/*     */     //   71: monitorexit
/*     */     //   72: aload_1
/*     */     //   73: athrow
/*     */     //   74: astore_1
/*     */     //   75: aload_0
/*     */     //   76: monitorexit
/*     */     //   77: aload_1
/*     */     //   78: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #164	-> 0
/*     */     //   #165	-> 2
/*     */     //   #166	-> 16
/*     */     //   #167	-> 20
/*     */     //   #169	-> 23
/*     */     //   #171	-> 25
/*     */     //   #174	-> 36
/*     */     //   #172	-> 39
/*     */     //   #175	-> 41
/*     */     //   #176	-> 43
/*     */     //   #177	-> 48
/*     */     //   #178	-> 55
/*     */     //   #181	-> 66
/*     */     //   #182	-> 68
/*     */     //   #181	-> 69
/*     */     //   #169	-> 74
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	16	74	finally
/*     */     //   20	22	74	finally
/*     */     //   23	25	74	finally
/*     */     //   25	36	39	android/os/RemoteException
/*     */     //   43	48	69	finally
/*     */     //   48	55	69	finally
/*     */     //   55	66	69	finally
/*     */     //   66	68	69	finally
/*     */     //   70	72	69	finally
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeFocusListener(OnAppFocusChangedListener paramOnAppFocusChangedListener) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mChangeBinders : Ljava/util/Map;
/*     */     //   6: aload_1
/*     */     //   7: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   12: checkcast android/car/CarAppFocusManager$IAppFocusListenerImpl
/*     */     //   15: astore_3
/*     */     //   16: aload_3
/*     */     //   17: ifnonnull -> 23
/*     */     //   20: aload_0
/*     */     //   21: monitorexit
/*     */     //   22: return
/*     */     //   23: aload_0
/*     */     //   24: monitorexit
/*     */     //   25: aload_3
/*     */     //   26: invokevirtual getAppTypes : ()Ljava/util/Set;
/*     */     //   29: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   34: astore_1
/*     */     //   35: aload_1
/*     */     //   36: invokeinterface hasNext : ()Z
/*     */     //   41: ifeq -> 71
/*     */     //   44: aload_1
/*     */     //   45: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   50: checkcast java/lang/Integer
/*     */     //   53: astore_2
/*     */     //   54: aload_0
/*     */     //   55: getfield mService : Landroid/car/IAppFocus;
/*     */     //   58: aload_3
/*     */     //   59: aload_2
/*     */     //   60: invokevirtual intValue : ()I
/*     */     //   63: invokeinterface unregisterFocusListener : (Landroid/car/IAppFocusListener;I)V
/*     */     //   68: goto -> 35
/*     */     //   71: goto -> 75
/*     */     //   74: astore_1
/*     */     //   75: return
/*     */     //   76: astore_1
/*     */     //   77: aload_0
/*     */     //   78: monitorexit
/*     */     //   79: aload_1
/*     */     //   80: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #191	-> 0
/*     */     //   #192	-> 2
/*     */     //   #193	-> 16
/*     */     //   #194	-> 20
/*     */     //   #196	-> 23
/*     */     //   #198	-> 25
/*     */     //   #199	-> 54
/*     */     //   #200	-> 68
/*     */     //   #203	-> 71
/*     */     //   #201	-> 74
/*     */     //   #204	-> 75
/*     */     //   #196	-> 76
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	16	76	finally
/*     */     //   20	22	76	finally
/*     */     //   23	25	76	finally
/*     */     //   25	35	74	android/os/RemoteException
/*     */     //   35	54	74	android/os/RemoteException
/*     */     //   54	68	74	android/os/RemoteException
/*     */     //   77	79	76	finally
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
/*     */   public int[] getActiveAppTypes() throws CarNotConnectedException {
/*     */     try {
/* 213 */       return this.mService.getActiveAppTypes();
/* 214 */     } catch (RemoteException remoteException) {
/* 215 */       throw new CarNotConnectedException(remoteException);
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
/*     */   public boolean isOwningFocus(OnAppFocusOwnershipCallback paramOnAppFocusOwnershipCallback, int paramInt) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mOwnershipBinders : Ljava/util/Map;
/*     */     //   6: aload_1
/*     */     //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   12: checkcast android/car/CarAppFocusManager$IAppFocusOwnershipCallbackImpl
/*     */     //   15: astore_1
/*     */     //   16: aload_1
/*     */     //   17: ifnonnull -> 24
/*     */     //   20: aload_0
/*     */     //   21: monitorexit
/*     */     //   22: iconst_0
/*     */     //   23: ireturn
/*     */     //   24: aload_0
/*     */     //   25: monitorexit
/*     */     //   26: aload_0
/*     */     //   27: getfield mService : Landroid/car/IAppFocus;
/*     */     //   30: aload_1
/*     */     //   31: iload_2
/*     */     //   32: invokeinterface isOwningFocus : (Landroid/car/IAppFocusOwnershipCallback;I)Z
/*     */     //   37: istore_3
/*     */     //   38: iload_3
/*     */     //   39: ireturn
/*     */     //   40: astore_1
/*     */     //   41: new android/car/CarNotConnectedException
/*     */     //   44: dup
/*     */     //   45: aload_1
/*     */     //   46: invokespecial <init> : (Ljava/lang/Exception;)V
/*     */     //   49: athrow
/*     */     //   50: astore_1
/*     */     //   51: aload_0
/*     */     //   52: monitorexit
/*     */     //   53: aload_1
/*     */     //   54: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #228	-> 0
/*     */     //   #229	-> 2
/*     */     //   #230	-> 16
/*     */     //   #231	-> 20
/*     */     //   #233	-> 24
/*     */     //   #235	-> 26
/*     */     //   #236	-> 40
/*     */     //   #237	-> 41
/*     */     //   #233	-> 50
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	16	50	finally
/*     */     //   20	22	50	finally
/*     */     //   24	26	50	finally
/*     */     //   26	38	40	android/os/RemoteException
/*     */     //   51	53	50	finally
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
/*     */   public int requestAppFocus(int paramInt, OnAppFocusOwnershipCallback paramOnAppFocusOwnershipCallback) throws SecurityException, CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: ifnull -> 88
/*     */     //   4: aload_0
/*     */     //   5: monitorenter
/*     */     //   6: aload_0
/*     */     //   7: getfield mOwnershipBinders : Ljava/util/Map;
/*     */     //   10: aload_2
/*     */     //   11: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   16: checkcast android/car/CarAppFocusManager$IAppFocusOwnershipCallbackImpl
/*     */     //   19: astore #4
/*     */     //   21: aload #4
/*     */     //   23: astore_3
/*     */     //   24: aload #4
/*     */     //   26: ifnonnull -> 52
/*     */     //   29: new android/car/CarAppFocusManager$IAppFocusOwnershipCallbackImpl
/*     */     //   32: astore_3
/*     */     //   33: aload_3
/*     */     //   34: aload_0
/*     */     //   35: aload_2
/*     */     //   36: aconst_null
/*     */     //   37: invokespecial <init> : (Landroid/car/CarAppFocusManager;Landroid/car/CarAppFocusManager$OnAppFocusOwnershipCallback;Landroid/car/CarAppFocusManager$1;)V
/*     */     //   40: aload_0
/*     */     //   41: getfield mOwnershipBinders : Ljava/util/Map;
/*     */     //   44: aload_2
/*     */     //   45: aload_3
/*     */     //   46: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   51: pop
/*     */     //   52: aload_3
/*     */     //   53: iload_1
/*     */     //   54: invokevirtual addAppType : (I)V
/*     */     //   57: aload_0
/*     */     //   58: monitorexit
/*     */     //   59: aload_0
/*     */     //   60: getfield mService : Landroid/car/IAppFocus;
/*     */     //   63: aload_3
/*     */     //   64: iload_1
/*     */     //   65: invokeinterface requestAppFocus : (Landroid/car/IAppFocusOwnershipCallback;I)I
/*     */     //   70: istore_1
/*     */     //   71: iload_1
/*     */     //   72: ireturn
/*     */     //   73: astore_2
/*     */     //   74: new android/car/CarNotConnectedException
/*     */     //   77: dup
/*     */     //   78: aload_2
/*     */     //   79: invokespecial <init> : (Ljava/lang/Exception;)V
/*     */     //   82: athrow
/*     */     //   83: astore_2
/*     */     //   84: aload_0
/*     */     //   85: monitorexit
/*     */     //   86: aload_2
/*     */     //   87: athrow
/*     */     //   88: new java/lang/IllegalArgumentException
/*     */     //   91: dup
/*     */     //   92: ldc 'null listener'
/*     */     //   94: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   97: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #256	-> 0
/*     */     //   #260	-> 4
/*     */     //   #261	-> 6
/*     */     //   #262	-> 21
/*     */     //   #263	-> 29
/*     */     //   #264	-> 40
/*     */     //   #266	-> 52
/*     */     //   #267	-> 57
/*     */     //   #269	-> 59
/*     */     //   #270	-> 73
/*     */     //   #271	-> 74
/*     */     //   #267	-> 83
/*     */     //   #257	-> 88
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	21	83	finally
/*     */     //   29	40	83	finally
/*     */     //   40	52	83	finally
/*     */     //   52	57	83	finally
/*     */     //   57	59	83	finally
/*     */     //   59	71	73	android/os/RemoteException
/*     */     //   84	86	83	finally
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
/*     */   public void abandonAppFocus(OnAppFocusOwnershipCallback paramOnAppFocusOwnershipCallback, int paramInt) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 83
/*     */     //   4: aload_0
/*     */     //   5: monitorenter
/*     */     //   6: aload_0
/*     */     //   7: getfield mOwnershipBinders : Ljava/util/Map;
/*     */     //   10: aload_1
/*     */     //   11: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   16: checkcast android/car/CarAppFocusManager$IAppFocusOwnershipCallbackImpl
/*     */     //   19: astore_3
/*     */     //   20: aload_3
/*     */     //   21: ifnonnull -> 27
/*     */     //   24: aload_0
/*     */     //   25: monitorexit
/*     */     //   26: return
/*     */     //   27: aload_0
/*     */     //   28: monitorexit
/*     */     //   29: aload_0
/*     */     //   30: getfield mService : Landroid/car/IAppFocus;
/*     */     //   33: aload_3
/*     */     //   34: iload_2
/*     */     //   35: invokeinterface abandonAppFocus : (Landroid/car/IAppFocusOwnershipCallback;I)V
/*     */     //   40: goto -> 45
/*     */     //   43: astore #4
/*     */     //   45: aload_0
/*     */     //   46: monitorenter
/*     */     //   47: aload_3
/*     */     //   48: iload_2
/*     */     //   49: invokevirtual removeAppType : (I)V
/*     */     //   52: aload_3
/*     */     //   53: invokevirtual hasAppTypes : ()Z
/*     */     //   56: ifne -> 70
/*     */     //   59: aload_0
/*     */     //   60: getfield mOwnershipBinders : Ljava/util/Map;
/*     */     //   63: aload_1
/*     */     //   64: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   69: pop
/*     */     //   70: aload_0
/*     */     //   71: monitorexit
/*     */     //   72: return
/*     */     //   73: astore_1
/*     */     //   74: aload_0
/*     */     //   75: monitorexit
/*     */     //   76: aload_1
/*     */     //   77: athrow
/*     */     //   78: astore_1
/*     */     //   79: aload_0
/*     */     //   80: monitorexit
/*     */     //   81: aload_1
/*     */     //   82: athrow
/*     */     //   83: new java/lang/IllegalArgumentException
/*     */     //   86: dup
/*     */     //   87: ldc 'null callback'
/*     */     //   89: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   92: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #284	-> 0
/*     */     //   #288	-> 4
/*     */     //   #289	-> 6
/*     */     //   #290	-> 20
/*     */     //   #291	-> 24
/*     */     //   #293	-> 27
/*     */     //   #295	-> 29
/*     */     //   #298	-> 40
/*     */     //   #296	-> 43
/*     */     //   #299	-> 45
/*     */     //   #300	-> 47
/*     */     //   #301	-> 52
/*     */     //   #302	-> 59
/*     */     //   #304	-> 70
/*     */     //   #305	-> 72
/*     */     //   #304	-> 73
/*     */     //   #293	-> 78
/*     */     //   #285	-> 83
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	20	78	finally
/*     */     //   24	26	78	finally
/*     */     //   27	29	78	finally
/*     */     //   29	40	43	android/os/RemoteException
/*     */     //   47	52	73	finally
/*     */     //   52	59	73	finally
/*     */     //   59	70	73	finally
/*     */     //   70	72	73	finally
/*     */     //   74	76	73	finally
/*     */     //   79	81	78	finally
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
/*     */   public void abandonAppFocus(OnAppFocusOwnershipCallback paramOnAppFocusOwnershipCallback) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mOwnershipBinders : Ljava/util/Map;
/*     */     //   6: aload_1
/*     */     //   7: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   12: checkcast android/car/CarAppFocusManager$IAppFocusOwnershipCallbackImpl
/*     */     //   15: astore_1
/*     */     //   16: aload_1
/*     */     //   17: ifnonnull -> 23
/*     */     //   20: aload_0
/*     */     //   21: monitorexit
/*     */     //   22: return
/*     */     //   23: aload_0
/*     */     //   24: monitorexit
/*     */     //   25: aload_1
/*     */     //   26: invokevirtual getAppTypes : ()Ljava/util/Set;
/*     */     //   29: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   34: astore_2
/*     */     //   35: aload_2
/*     */     //   36: invokeinterface hasNext : ()Z
/*     */     //   41: ifeq -> 71
/*     */     //   44: aload_2
/*     */     //   45: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   50: checkcast java/lang/Integer
/*     */     //   53: astore_3
/*     */     //   54: aload_0
/*     */     //   55: getfield mService : Landroid/car/IAppFocus;
/*     */     //   58: aload_1
/*     */     //   59: aload_3
/*     */     //   60: invokevirtual intValue : ()I
/*     */     //   63: invokeinterface abandonAppFocus : (Landroid/car/IAppFocusOwnershipCallback;I)V
/*     */     //   68: goto -> 35
/*     */     //   71: goto -> 75
/*     */     //   74: astore_1
/*     */     //   75: return
/*     */     //   76: astore_1
/*     */     //   77: aload_0
/*     */     //   78: monitorexit
/*     */     //   79: aload_1
/*     */     //   80: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #315	-> 0
/*     */     //   #316	-> 2
/*     */     //   #317	-> 16
/*     */     //   #318	-> 20
/*     */     //   #320	-> 23
/*     */     //   #322	-> 25
/*     */     //   #323	-> 54
/*     */     //   #324	-> 68
/*     */     //   #327	-> 71
/*     */     //   #325	-> 74
/*     */     //   #328	-> 75
/*     */     //   #320	-> 76
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	16	76	finally
/*     */     //   20	22	76	finally
/*     */     //   23	25	76	finally
/*     */     //   25	35	74	android/os/RemoteException
/*     */     //   35	54	74	android/os/RemoteException
/*     */     //   54	68	74	android/os/RemoteException
/*     */     //   77	79	76	finally
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
/*     */   public void onCarDisconnected() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface AppFocusRequestResult {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface AppFocusType {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class IAppFocusListenerImpl
/*     */     extends IAppFocusListener.Stub
/*     */   {
/* 340 */     private final Set<Integer> mAppTypes = new HashSet<>(); private final WeakReference<CarAppFocusManager.OnAppFocusChangedListener> mListener;
/*     */     private final WeakReference<CarAppFocusManager> mManager;
/*     */     
/*     */     private IAppFocusListenerImpl(CarAppFocusManager param1CarAppFocusManager, CarAppFocusManager.OnAppFocusChangedListener param1OnAppFocusChangedListener) {
/* 344 */       this.mManager = new WeakReference<>(param1CarAppFocusManager);
/* 345 */       this.mListener = new WeakReference<>(param1OnAppFocusChangedListener);
/*     */     }
/*     */     
/*     */     public void addAppType(int param1Int) {
/* 349 */       this.mAppTypes.add(Integer.valueOf(param1Int));
/*     */     }
/*     */     
/*     */     public void removeAppType(int param1Int) {
/* 353 */       this.mAppTypes.remove(Integer.valueOf(param1Int));
/*     */     }
/*     */     
/*     */     public Set<Integer> getAppTypes() {
/* 357 */       return this.mAppTypes;
/*     */     }
/*     */     
/*     */     public boolean hasAppTypes() {
/* 361 */       return this.mAppTypes.isEmpty() ^ true;
/*     */     }
/*     */     
/*     */     public void onAppFocusChanged(final int appType, final boolean active)
/*     */     {
/* 366 */       CarAppFocusManager carAppFocusManager = this.mManager.get();
/* 367 */       final CarAppFocusManager.OnAppFocusChangedListener listener = this.mListener.get();
/* 368 */       if (carAppFocusManager == null || onAppFocusChangedListener == null) {
/*     */         return;
/*     */       }
/* 371 */       carAppFocusManager.mHandler.post(new Runnable() { final CarAppFocusManager.IAppFocusListenerImpl this$0; final boolean val$active; final int val$appType;
/*     */             final CarAppFocusManager.OnAppFocusChangedListener val$listener;
/*     */             
/* 374 */             public void run() { listener.onAppFocusChanged(appType, active); } }); } } class null implements Runnable { final CarAppFocusManager.IAppFocusListenerImpl this$0; final boolean val$active; final int val$appType; final CarAppFocusManager.OnAppFocusChangedListener val$listener; public void run() { listener.onAppFocusChanged(appType, active); }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class IAppFocusOwnershipCallbackImpl
/*     */     extends IAppFocusOwnershipCallback.Stub
/*     */   {
/* 384 */     private final Set<Integer> mAppTypes = new HashSet<>(); private final WeakReference<CarAppFocusManager.OnAppFocusOwnershipCallback> mCallback;
/*     */     private final WeakReference<CarAppFocusManager> mManager;
/*     */     
/*     */     private IAppFocusOwnershipCallbackImpl(CarAppFocusManager param1CarAppFocusManager, CarAppFocusManager.OnAppFocusOwnershipCallback param1OnAppFocusOwnershipCallback) {
/* 388 */       this.mManager = new WeakReference<>(param1CarAppFocusManager);
/* 389 */       this.mCallback = new WeakReference<>(param1OnAppFocusOwnershipCallback);
/*     */     }
/*     */     
/*     */     public void addAppType(int param1Int) {
/* 393 */       this.mAppTypes.add(Integer.valueOf(param1Int));
/*     */     }
/*     */     
/*     */     public void removeAppType(int param1Int) {
/* 397 */       this.mAppTypes.remove(Integer.valueOf(param1Int));
/*     */     }
/*     */     
/*     */     public Set<Integer> getAppTypes() {
/* 401 */       return this.mAppTypes;
/*     */     }
/*     */     
/*     */     public boolean hasAppTypes() {
/* 405 */       return this.mAppTypes.isEmpty() ^ true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void onAppFocusOwnershipLost(final int appType) {
/* 410 */       CarAppFocusManager carAppFocusManager = this.mManager.get();
/* 411 */       final CarAppFocusManager.OnAppFocusOwnershipCallback callback = this.mCallback.get();
/* 412 */       if (carAppFocusManager == null || onAppFocusOwnershipCallback == null) {
/*     */         return;
/*     */       }
/* 415 */       carAppFocusManager.mHandler.post(new Runnable() { final CarAppFocusManager.IAppFocusOwnershipCallbackImpl this$0; final int val$appType; final CarAppFocusManager.OnAppFocusOwnershipCallback val$callback;
/*     */             
/*     */             public void run() {
/* 418 */               callback.onAppFocusOwnershipLost(appType);
/*     */             } }
/*     */         );
/*     */     }
/*     */     
/*     */     public void onAppFocusOwnershipGranted(final int appType)
/*     */     {
/* 425 */       CarAppFocusManager carAppFocusManager = this.mManager.get();
/* 426 */       final CarAppFocusManager.OnAppFocusOwnershipCallback callback = this.mCallback.get();
/* 427 */       if (carAppFocusManager == null || onAppFocusOwnershipCallback == null) {
/*     */         return;
/*     */       }
/* 430 */       carAppFocusManager.mHandler.post(new Runnable() { final CarAppFocusManager.IAppFocusOwnershipCallbackImpl this$0; final int val$appType;
/*     */             final CarAppFocusManager.OnAppFocusOwnershipCallback val$callback;
/*     */             
/* 433 */             public void run() { callback.onAppFocusOwnershipGranted(appType); } }); } } class null implements Runnable { final CarAppFocusManager.IAppFocusOwnershipCallbackImpl this$0; final int val$appType; final CarAppFocusManager.OnAppFocusOwnershipCallback val$callback; public void run() { callback.onAppFocusOwnershipLost(appType); } } class null implements Runnable { public void run() { callback.onAppFocusOwnershipGranted(appType); }
/*     */ 
/*     */     
/*     */     final CarAppFocusManager.IAppFocusOwnershipCallbackImpl this$0;
/*     */     final int val$appType;
/*     */     final CarAppFocusManager.OnAppFocusOwnershipCallback val$callback; }
/*     */ 
/*     */   
/*     */   public static interface OnAppFocusChangedListener {
/*     */     void onAppFocusChanged(int param1Int, boolean param1Boolean);
/*     */   }
/*     */   
/*     */   public static interface OnAppFocusOwnershipCallback {
/*     */     void onAppFocusOwnershipGranted(int param1Int);
/*     */     
/*     */     void onAppFocusOwnershipLost(int param1Int);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\CarAppFocusManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */