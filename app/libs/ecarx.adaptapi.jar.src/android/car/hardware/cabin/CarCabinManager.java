/*     */ package android.car.hardware.cabin;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.car.hardware.CarPropertyConfig;
/*     */ import android.car.hardware.CarPropertyValue;
/*     */ import android.car.hardware.property.CarPropertyManager;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.util.ArraySet;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class CarCabinManager
/*     */   implements CarManagerBase
/*     */ {
/*  61 */   private final ArraySet<CarCabinEventCallback> mCallbacks = new ArraySet();
/*  62 */   private CarPropertyEventListenerToBase mListenerToBase = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 353 */   private final ArraySet<Integer> mCabinPropertyIds = new ArraySet(Arrays.asList(new Integer[] { Integer.valueOf(373295872), Integer.valueOf(373295873), Integer.valueOf(371198722), Integer.valueOf(339741504), Integer.valueOf(339741505), Integer.valueOf(339741506), Integer.valueOf(339741507), Integer.valueOf(287312708), Integer.valueOf(287312709), Integer.valueOf(356518784), Integer.valueOf(356518785), Integer.valueOf(354421634), Integer.valueOf(356518787), Integer.valueOf(356518788), Integer.valueOf(356518789), Integer.valueOf(356518790), Integer.valueOf(356518791), Integer.valueOf(356518792), Integer.valueOf(356518793), Integer.valueOf(356518794), Integer.valueOf(356518795), Integer.valueOf(356518796), Integer.valueOf(356518797), Integer.valueOf(356518798), Integer.valueOf(356518799), Integer.valueOf(356518800), Integer.valueOf(356518801), Integer.valueOf(356518802), Integer.valueOf(356518803), Integer.valueOf(356518804), Integer.valueOf(356518805), Integer.valueOf(356518806), Integer.valueOf(356518807), Integer.valueOf(356518808), Integer.valueOf(356518809), Integer.valueOf(356518810), Integer.valueOf(322964416), Integer.valueOf(322964417), Integer.valueOf(322964420) }));
/*     */   
/*     */   private static final boolean DBG = false;
/*     */   
/*     */   public static final int ID_DOOR_LOCK = 371198722;
/*     */   
/*     */   public static final int ID_DOOR_MOVE = 373295873;
/*     */   
/*     */   public static final int ID_DOOR_POS = 373295872;
/*     */   
/*     */   public static final int ID_MIRROR_FOLD = 287312709;
/*     */   
/*     */   public static final int ID_MIRROR_LOCK = 287312708;
/*     */   
/*     */   public static final int ID_MIRROR_Y_MOVE = 339741507;
/*     */   
/*     */   public static final int ID_MIRROR_Y_POS = 339741506;
/*     */   
/*     */   public static final int ID_MIRROR_Z_MOVE = 339741505;
/*     */   public static final int ID_MIRROR_Z_POS = 339741504;
/*     */   public static final int ID_SEAT_BACKREST_ANGLE_1_MOVE = 356518792;
/*     */   public static final int ID_SEAT_BACKREST_ANGLE_1_POS = 356518791;
/*     */   public static final int ID_SEAT_BACKREST_ANGLE_2_MOVE = 356518794;
/*     */   public static final int ID_SEAT_BACKREST_ANGLE_2_POS = 356518793;
/*     */   public static final int ID_SEAT_BELT_BUCKLED = 354421634;
/*     */   public static final int ID_SEAT_BELT_HEIGHT_MOVE = 356518788;
/*     */   public static final int ID_SEAT_BELT_HEIGHT_POS = 356518787;
/*     */   public static final int ID_SEAT_DEPTH_MOVE = 356518798;
/*     */   public static final int ID_SEAT_DEPTH_POS = 356518797;
/*     */   public static final int ID_SEAT_FORE_AFT_MOVE = 356518790;
/*     */   public static final int ID_SEAT_FORE_AFT_POS = 356518789;
/*     */   public static final int ID_SEAT_HEADREST_ANGLE_MOVE = 356518808;
/*     */   public static final int ID_SEAT_HEADREST_ANGLE_POS = 356518807;
/*     */   public static final int ID_SEAT_HEADREST_FORE_AFT_MOVE = 356518810;
/*     */   public static final int ID_SEAT_HEADREST_FORE_AFT_POS = 356518809;
/*     */   public static final int ID_SEAT_HEADREST_HEIGHT_MOVE = 356518806;
/*     */   public static final int ID_SEAT_HEADREST_HEIGHT_POS = 356518805;
/*     */   public static final int ID_SEAT_HEIGHT_MOVE = 356518796;
/*     */   public static final int ID_SEAT_HEIGHT_POS = 356518795;
/*     */   public static final int ID_SEAT_LUMBAR_FORE_AFT_MOVE = 356518802;
/*     */   public static final int ID_SEAT_LUMBAR_FORE_AFT_POS = 356518801;
/*     */   public static final int ID_SEAT_LUMBAR_SIDE_SUPPORT_MOVE = 356518804;
/*     */   public static final int ID_SEAT_LUMBAR_SIDE_SUPPORT_POS = 356518803;
/*     */   public static final int ID_SEAT_MEMORY_SELECT = 356518784;
/*     */   public static final int ID_SEAT_MEMORY_SET = 356518785;
/*     */   public static final int ID_SEAT_TILT_MOVE = 356518800;
/*     */   public static final int ID_SEAT_TILT_POS = 356518799;
/*     */   public static final int ID_WINDOW_LOCK = 322964420;
/*     */   public static final int ID_WINDOW_MOVE = 322964417;
/*     */   public static final int ID_WINDOW_POS = 322964416;
/*     */   private static final String TAG = "CarCabinManager";
/*     */   private final CarPropertyManager mCarPropertyMgr;
/*     */   
/*     */   public static interface CarCabinEventCallback
/*     */   {
/*     */     void onChangeEvent(CarPropertyValue param1CarPropertyValue);
/*     */     
/*     */     void onErrorEvent(int param1Int1, int param1Int2);
/*     */   }
/*     */   
/*     */   private static class CarPropertyEventListenerToBase
/*     */     implements CarPropertyManager.CarPropertyEventListener
/*     */   {
/*     */     private final WeakReference<CarCabinManager> mManager;
/*     */     
/*     */     public CarPropertyEventListenerToBase(CarCabinManager param1CarCabinManager) {
/* 419 */       this.mManager = new WeakReference<>(param1CarCabinManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onChangeEvent(CarPropertyValue param1CarPropertyValue) {
/* 424 */       CarCabinManager carCabinManager = this.mManager.get();
/* 425 */       if (carCabinManager != null) {
/* 426 */         carCabinManager.handleOnChangeEvent(param1CarPropertyValue);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void onErrorEvent(int param1Int1, int param1Int2) {
/* 432 */       CarCabinManager carCabinManager = this.mManager.get();
/* 433 */       if (carCabinManager != null) {
/* 434 */         carCabinManager.handleOnErrorEvent(param1Int1, param1Int2);
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
/*     */   private void handleOnChangeEvent(CarPropertyValue paramCarPropertyValue) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: new android/util/ArraySet
/*     */     //   5: astore_2
/*     */     //   6: aload_2
/*     */     //   7: aload_0
/*     */     //   8: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   11: invokespecial <init> : (Landroid/util/ArraySet;)V
/*     */     //   14: aload_0
/*     */     //   15: monitorexit
/*     */     //   16: aload_2
/*     */     //   17: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   22: astore_2
/*     */     //   23: aload_2
/*     */     //   24: invokeinterface hasNext : ()Z
/*     */     //   29: ifeq -> 52
/*     */     //   32: aload_2
/*     */     //   33: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   38: checkcast android/car/hardware/cabin/CarCabinManager$CarCabinEventCallback
/*     */     //   41: astore_3
/*     */     //   42: aload_3
/*     */     //   43: aload_1
/*     */     //   44: invokeinterface onChangeEvent : (Landroid/car/hardware/CarPropertyValue;)V
/*     */     //   49: goto -> 23
/*     */     //   52: return
/*     */     //   53: astore_1
/*     */     //   54: aload_0
/*     */     //   55: monitorexit
/*     */     //   56: aload_1
/*     */     //   57: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #441	-> 0
/*     */     //   #442	-> 2
/*     */     //   #443	-> 14
/*     */     //   #444	-> 16
/*     */     //   #445	-> 42
/*     */     //   #446	-> 49
/*     */     //   #447	-> 52
/*     */     //   #443	-> 53
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	14	53	finally
/*     */     //   14	16	53	finally
/*     */     //   54	56	53	finally
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
/*     */   private void handleOnErrorEvent(int paramInt1, int paramInt2) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: new android/util/ArraySet
/*     */     //   5: astore_3
/*     */     //   6: aload_3
/*     */     //   7: aload_0
/*     */     //   8: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   11: invokespecial <init> : (Landroid/util/ArraySet;)V
/*     */     //   14: aload_0
/*     */     //   15: monitorexit
/*     */     //   16: aload_3
/*     */     //   17: invokeinterface isEmpty : ()Z
/*     */     //   22: ifne -> 64
/*     */     //   25: aload_3
/*     */     //   26: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   31: astore_3
/*     */     //   32: aload_3
/*     */     //   33: invokeinterface hasNext : ()Z
/*     */     //   38: ifeq -> 64
/*     */     //   41: aload_3
/*     */     //   42: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   47: checkcast android/car/hardware/cabin/CarCabinManager$CarCabinEventCallback
/*     */     //   50: astore #4
/*     */     //   52: aload #4
/*     */     //   54: iload_1
/*     */     //   55: iload_2
/*     */     //   56: invokeinterface onErrorEvent : (II)V
/*     */     //   61: goto -> 32
/*     */     //   64: return
/*     */     //   65: astore_3
/*     */     //   66: aload_0
/*     */     //   67: monitorexit
/*     */     //   68: aload_3
/*     */     //   69: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #451	-> 0
/*     */     //   #452	-> 2
/*     */     //   #453	-> 14
/*     */     //   #454	-> 16
/*     */     //   #455	-> 25
/*     */     //   #456	-> 52
/*     */     //   #457	-> 61
/*     */     //   #459	-> 64
/*     */     //   #453	-> 65
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	14	65	finally
/*     */     //   14	16	65	finally
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
/*     */   public CarCabinManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/* 471 */     this.mCarPropertyMgr = new CarPropertyManager(paramIBinder, paramHandler, false, "CarCabinManager");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isZonedProperty(int paramInt) {
/* 480 */     return true;
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
/*     */   public void registerCallback(CarCabinEventCallback paramCarCabinEventCallback) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   6: invokevirtual isEmpty : ()Z
/*     */     //   9: ifeq -> 26
/*     */     //   12: new android/car/hardware/cabin/CarCabinManager$CarPropertyEventListenerToBase
/*     */     //   15: astore_2
/*     */     //   16: aload_2
/*     */     //   17: aload_0
/*     */     //   18: invokespecial <init> : (Landroid/car/hardware/cabin/CarCabinManager;)V
/*     */     //   21: aload_0
/*     */     //   22: aload_2
/*     */     //   23: putfield mListenerToBase : Landroid/car/hardware/cabin/CarCabinManager$CarPropertyEventListenerToBase;
/*     */     //   26: aload_0
/*     */     //   27: invokevirtual getPropertyList : ()Ljava/util/List;
/*     */     //   30: astore_2
/*     */     //   31: aload_2
/*     */     //   32: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   37: astore_2
/*     */     //   38: aload_2
/*     */     //   39: invokeinterface hasNext : ()Z
/*     */     //   44: ifeq -> 77
/*     */     //   47: aload_2
/*     */     //   48: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   53: checkcast android/car/hardware/CarPropertyConfig
/*     */     //   56: astore_3
/*     */     //   57: aload_0
/*     */     //   58: getfield mCarPropertyMgr : Landroid/car/hardware/property/CarPropertyManager;
/*     */     //   61: aload_0
/*     */     //   62: getfield mListenerToBase : Landroid/car/hardware/cabin/CarCabinManager$CarPropertyEventListenerToBase;
/*     */     //   65: aload_3
/*     */     //   66: invokevirtual getPropertyId : ()I
/*     */     //   69: fconst_0
/*     */     //   70: invokevirtual registerListener : (Landroid/car/hardware/property/CarPropertyManager$CarPropertyEventListener;IF)Z
/*     */     //   73: pop
/*     */     //   74: goto -> 38
/*     */     //   77: aload_0
/*     */     //   78: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   81: aload_1
/*     */     //   82: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   85: pop
/*     */     //   86: aload_0
/*     */     //   87: monitorexit
/*     */     //   88: return
/*     */     //   89: astore_1
/*     */     //   90: aload_0
/*     */     //   91: monitorexit
/*     */     //   92: aload_1
/*     */     //   93: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #490	-> 2
/*     */     //   #491	-> 12
/*     */     //   #493	-> 26
/*     */     //   #494	-> 31
/*     */     //   #496	-> 57
/*     */     //   #497	-> 74
/*     */     //   #498	-> 77
/*     */     //   #501	-> 86
/*     */     //   #489	-> 89
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	12	89	finally
/*     */     //   12	26	89	finally
/*     */     //   26	31	89	finally
/*     */     //   31	38	89	finally
/*     */     //   38	57	89	finally
/*     */     //   57	74	89	finally
/*     */     //   77	86	89	finally
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
/*     */   public void unregisterCallback(CarCabinEventCallback paramCarCabinEventCallback) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual remove : (Ljava/lang/Object;)Z
/*     */     //   10: pop
/*     */     //   11: aload_0
/*     */     //   12: invokevirtual getPropertyList : ()Ljava/util/List;
/*     */     //   15: astore_1
/*     */     //   16: aload_1
/*     */     //   17: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   22: astore_1
/*     */     //   23: aload_1
/*     */     //   24: invokeinterface hasNext : ()Z
/*     */     //   29: ifeq -> 60
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   38: checkcast android/car/hardware/CarPropertyConfig
/*     */     //   41: astore_2
/*     */     //   42: aload_0
/*     */     //   43: getfield mCarPropertyMgr : Landroid/car/hardware/property/CarPropertyManager;
/*     */     //   46: aload_0
/*     */     //   47: getfield mListenerToBase : Landroid/car/hardware/cabin/CarCabinManager$CarPropertyEventListenerToBase;
/*     */     //   50: aload_2
/*     */     //   51: invokevirtual getPropertyId : ()I
/*     */     //   54: invokevirtual unregisterListener : (Landroid/car/hardware/property/CarPropertyManager$CarPropertyEventListener;I)V
/*     */     //   57: goto -> 23
/*     */     //   60: aload_0
/*     */     //   61: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   64: invokevirtual isEmpty : ()Z
/*     */     //   67: ifeq -> 75
/*     */     //   70: aload_0
/*     */     //   71: aconst_null
/*     */     //   72: putfield mListenerToBase : Landroid/car/hardware/cabin/CarCabinManager$CarPropertyEventListenerToBase;
/*     */     //   75: aload_0
/*     */     //   76: monitorexit
/*     */     //   77: return
/*     */     //   78: astore_1
/*     */     //   79: aload_0
/*     */     //   80: monitorexit
/*     */     //   81: aload_1
/*     */     //   82: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #510	-> 2
/*     */     //   #511	-> 11
/*     */     //   #512	-> 16
/*     */     //   #514	-> 42
/*     */     //   #515	-> 57
/*     */     //   #516	-> 60
/*     */     //   #517	-> 70
/*     */     //   #519	-> 75
/*     */     //   #509	-> 78
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	11	78	finally
/*     */     //   11	16	78	finally
/*     */     //   16	23	78	finally
/*     */     //   23	42	78	finally
/*     */     //   42	57	78	finally
/*     */     //   60	70	78	finally
/*     */     //   70	75	78	finally
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
/*     */   public List<CarPropertyConfig> getPropertyList() throws CarNotConnectedException {
/* 527 */     return this.mCarPropertyMgr.getPropertyList(this.mCabinPropertyIds);
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
/*     */   public boolean getBooleanProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 539 */     return this.mCarPropertyMgr.getBooleanProperty(paramInt1, paramInt2);
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
/*     */   public float getFloatProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 551 */     return this.mCarPropertyMgr.getFloatProperty(paramInt1, paramInt2);
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
/*     */   public int getIntProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 563 */     return this.mCarPropertyMgr.getIntProperty(paramInt1, paramInt2);
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
/*     */   public void setBooleanProperty(int paramInt1, int paramInt2, boolean paramBoolean) throws CarNotConnectedException {
/* 575 */     if (this.mCabinPropertyIds.contains(Integer.valueOf(paramInt1))) {
/* 576 */       this.mCarPropertyMgr.setBooleanProperty(paramInt1, paramInt2, paramBoolean);
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
/*     */   public void setFloatProperty(int paramInt1, int paramInt2, float paramFloat) throws CarNotConnectedException {
/* 589 */     if (this.mCabinPropertyIds.contains(Integer.valueOf(paramInt1))) {
/* 590 */       this.mCarPropertyMgr.setFloatProperty(paramInt1, paramInt2, paramFloat);
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
/*     */   public void setIntProperty(int paramInt1, int paramInt2, int paramInt3) throws CarNotConnectedException {
/* 603 */     if (this.mCabinPropertyIds.contains(Integer.valueOf(paramInt1))) {
/* 604 */       this.mCarPropertyMgr.setIntProperty(paramInt1, paramInt2, paramInt3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 611 */     this.mCarPropertyMgr.onCarDisconnected();
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface PropertyId {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\cabin\CarCabinManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */