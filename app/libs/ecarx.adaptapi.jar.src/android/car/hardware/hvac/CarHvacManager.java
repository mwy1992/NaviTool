/*     */ package android.car.hardware.hvac;
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
/*     */ @SystemApi
/*     */ public final class CarHvacManager
/*     */   implements CarManagerBase
/*     */ {
/*  49 */   private final ArraySet<CarHvacEventCallback> mCallbacks = new ArraySet();
/*  50 */   private CarPropertyEventListenerToBase mListenerToBase = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 196 */   private final ArraySet<Integer> mHvacPropertyIds = new ArraySet(Arrays.asList(new Integer[] { Integer.valueOf(339739916), Integer.valueOf(289408269), Integer.valueOf(291505923), Integer.valueOf(289408270), Integer.valueOf(358614275), Integer.valueOf(358614274), Integer.valueOf(356517120), Integer.valueOf(356517135), Integer.valueOf(356582673), Integer.valueOf(356517121), Integer.valueOf(356517131), Integer.valueOf(354419973), Integer.valueOf(354419978), Integer.valueOf(354419976), Integer.valueOf(354419974), Integer.valueOf(354419977), Integer.valueOf(354419975), Integer.valueOf(354419984), Integer.valueOf(354419986), Integer.valueOf(320865540) }));
/*     */   
/*     */   private static final boolean DBG = false;
/*     */   
/*     */   public static final int FAN_DIRECTION_DEFROST = 4;
/*     */   
/*     */   public static final int FAN_DIRECTION_FACE = 1;
/*     */   
/*     */   public static final int FAN_DIRECTION_FLOOR = 2;
/*     */   
/*     */   public static final int ID_MIRROR_DEFROSTER_ON = 339739916;
/*     */   
/*     */   public static final int ID_OUTSIDE_AIR_TEMP = 291505923;
/*     */   
/*     */   public static final int ID_STEERING_WHEEL_HEAT = 289408269;
/*     */   
/*     */   public static final int ID_TEMPERATURE_DISPLAY_UNITS = 289408270;
/*     */   
/*     */   public static final int ID_WINDOW_DEFROSTER_ON = 320865540;
/*     */   
/*     */   public static final int ID_ZONED_AC_ON = 354419973;
/*     */   
/*     */   public static final int ID_ZONED_AIR_RECIRCULATION_ON = 354419976;
/*     */   
/*     */   public static final int ID_ZONED_AUTOMATIC_MODE_ON = 354419978;
/*     */   
/*     */   public static final int ID_ZONED_DUAL_ZONE_ON = 354419977;
/*     */   
/*     */   public static final int ID_ZONED_FAN_DIRECTION = 356517121;
/*     */   
/*     */   public static final int ID_ZONED_FAN_DIRECTION_AVAILABLE = 356582673;
/*     */   
/*     */   public static final int ID_ZONED_FAN_SPEED_RPM = 356517135;
/*     */   
/*     */   public static final int ID_ZONED_FAN_SPEED_SETPOINT = 356517120;
/*     */   
/*     */   public static final int ID_ZONED_HVAC_AUTO_RECIRC_ON = 354419986;
/*     */   
/*     */   public static final int ID_ZONED_HVAC_POWER_ON = 354419984;
/*     */   
/*     */   public static final int ID_ZONED_MAX_AC_ON = 354419974;
/*     */   
/*     */   public static final int ID_ZONED_MAX_DEFROST_ON = 354419975;
/*     */   
/*     */   public static final int ID_ZONED_SEAT_TEMP = 356517131;
/*     */   
/*     */   public static final int ID_ZONED_TEMP_ACTUAL = 358614274;
/*     */   public static final int ID_ZONED_TEMP_SETPOINT = 358614275;
/*     */   private static final String TAG = "CarHvacManager";
/*     */   private final CarPropertyManager mCarPropertyMgr;
/*     */   
/*     */   public static interface CarHvacEventCallback
/*     */   {
/*     */     void onChangeEvent(CarPropertyValue param1CarPropertyValue);
/*     */     
/*     */     void onErrorEvent(int param1Int1, int param1Int2);
/*     */   }
/*     */   
/*     */   private static class CarPropertyEventListenerToBase
/*     */     implements CarPropertyManager.CarPropertyEventListener
/*     */   {
/*     */     private final WeakReference<CarHvacManager> mManager;
/*     */     
/*     */     public CarPropertyEventListenerToBase(CarHvacManager param1CarHvacManager) {
/* 260 */       this.mManager = new WeakReference<>(param1CarHvacManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onChangeEvent(CarPropertyValue param1CarPropertyValue) {
/* 265 */       CarHvacManager carHvacManager = this.mManager.get();
/* 266 */       if (carHvacManager != null) {
/* 267 */         carHvacManager.handleOnChangeEvent(param1CarPropertyValue);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void onErrorEvent(int param1Int1, int param1Int2) {
/* 273 */       CarHvacManager carHvacManager = this.mManager.get();
/* 274 */       if (carHvacManager != null) {
/* 275 */         carHvacManager.handleOnErrorEvent(param1Int1, param1Int2);
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
/*     */     //   17: invokeinterface isEmpty : ()Z
/*     */     //   22: ifne -> 61
/*     */     //   25: aload_2
/*     */     //   26: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   31: astore_3
/*     */     //   32: aload_3
/*     */     //   33: invokeinterface hasNext : ()Z
/*     */     //   38: ifeq -> 61
/*     */     //   41: aload_3
/*     */     //   42: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   47: checkcast android/car/hardware/hvac/CarHvacManager$CarHvacEventCallback
/*     */     //   50: astore_2
/*     */     //   51: aload_2
/*     */     //   52: aload_1
/*     */     //   53: invokeinterface onChangeEvent : (Landroid/car/hardware/CarPropertyValue;)V
/*     */     //   58: goto -> 32
/*     */     //   61: return
/*     */     //   62: astore_1
/*     */     //   63: aload_0
/*     */     //   64: monitorexit
/*     */     //   65: aload_1
/*     */     //   66: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #282	-> 0
/*     */     //   #283	-> 2
/*     */     //   #284	-> 14
/*     */     //   #285	-> 16
/*     */     //   #286	-> 25
/*     */     //   #287	-> 51
/*     */     //   #288	-> 58
/*     */     //   #290	-> 61
/*     */     //   #284	-> 62
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	14	62	finally
/*     */     //   14	16	62	finally
/*     */     //   63	65	62	finally
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
/*     */     //   22: ifne -> 65
/*     */     //   25: aload_3
/*     */     //   26: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   31: astore #4
/*     */     //   33: aload #4
/*     */     //   35: invokeinterface hasNext : ()Z
/*     */     //   40: ifeq -> 65
/*     */     //   43: aload #4
/*     */     //   45: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   50: checkcast android/car/hardware/hvac/CarHvacManager$CarHvacEventCallback
/*     */     //   53: astore_3
/*     */     //   54: aload_3
/*     */     //   55: iload_1
/*     */     //   56: iload_2
/*     */     //   57: invokeinterface onErrorEvent : (II)V
/*     */     //   62: goto -> 33
/*     */     //   65: return
/*     */     //   66: astore_3
/*     */     //   67: aload_0
/*     */     //   68: monitorexit
/*     */     //   69: aload_3
/*     */     //   70: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #294	-> 0
/*     */     //   #295	-> 2
/*     */     //   #296	-> 14
/*     */     //   #297	-> 16
/*     */     //   #298	-> 25
/*     */     //   #299	-> 54
/*     */     //   #300	-> 62
/*     */     //   #302	-> 65
/*     */     //   #296	-> 66
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	14	66	finally
/*     */     //   14	16	66	finally
/*     */     //   67	69	66	finally
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
/*     */   public CarHvacManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/* 314 */     this.mCarPropertyMgr = new CarPropertyManager(paramIBinder, paramHandler, false, "CarHvacManager");
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
/*     */   public void registerCallback(CarHvacEventCallback paramCarHvacEventCallback) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   6: invokevirtual isEmpty : ()Z
/*     */     //   9: ifeq -> 26
/*     */     //   12: new android/car/hardware/hvac/CarHvacManager$CarPropertyEventListenerToBase
/*     */     //   15: astore_2
/*     */     //   16: aload_2
/*     */     //   17: aload_0
/*     */     //   18: invokespecial <init> : (Landroid/car/hardware/hvac/CarHvacManager;)V
/*     */     //   21: aload_0
/*     */     //   22: aload_2
/*     */     //   23: putfield mListenerToBase : Landroid/car/hardware/hvac/CarHvacManager$CarPropertyEventListenerToBase;
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
/*     */     //   62: getfield mListenerToBase : Landroid/car/hardware/hvac/CarHvacManager$CarPropertyEventListenerToBase;
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
/*     */     //   #323	-> 2
/*     */     //   #324	-> 12
/*     */     //   #326	-> 26
/*     */     //   #327	-> 31
/*     */     //   #329	-> 57
/*     */     //   #330	-> 74
/*     */     //   #331	-> 77
/*     */     //   #332	-> 86
/*     */     //   #322	-> 89
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
/*     */   public void unregisterCallback(CarHvacEventCallback paramCarHvacEventCallback) {
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
/*     */     //   47: getfield mListenerToBase : Landroid/car/hardware/hvac/CarHvacManager$CarPropertyEventListenerToBase;
/*     */     //   50: aload_2
/*     */     //   51: invokevirtual getPropertyId : ()I
/*     */     //   54: invokevirtual unregisterListener : (Landroid/car/hardware/property/CarPropertyManager$CarPropertyEventListener;I)V
/*     */     //   57: goto -> 23
/*     */     //   60: goto -> 73
/*     */     //   63: astore_1
/*     */     //   64: ldc 'CarHvacManager'
/*     */     //   66: ldc 'getPropertyList exception '
/*     */     //   68: aload_1
/*     */     //   69: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
/*     */     //   72: pop
/*     */     //   73: aload_0
/*     */     //   74: getfield mCallbacks : Landroid/util/ArraySet;
/*     */     //   77: invokevirtual isEmpty : ()Z
/*     */     //   80: ifeq -> 99
/*     */     //   83: aload_0
/*     */     //   84: getfield mCarPropertyMgr : Landroid/car/hardware/property/CarPropertyManager;
/*     */     //   87: aload_0
/*     */     //   88: getfield mListenerToBase : Landroid/car/hardware/hvac/CarHvacManager$CarPropertyEventListenerToBase;
/*     */     //   91: invokevirtual unregisterListener : (Landroid/car/hardware/property/CarPropertyManager$CarPropertyEventListener;)V
/*     */     //   94: aload_0
/*     */     //   95: aconst_null
/*     */     //   96: putfield mListenerToBase : Landroid/car/hardware/hvac/CarHvacManager$CarPropertyEventListenerToBase;
/*     */     //   99: aload_0
/*     */     //   100: monitorexit
/*     */     //   101: return
/*     */     //   102: astore_1
/*     */     //   103: aload_0
/*     */     //   104: monitorexit
/*     */     //   105: aload_1
/*     */     //   106: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #340	-> 2
/*     */     //   #342	-> 11
/*     */     //   #343	-> 16
/*     */     //   #345	-> 42
/*     */     //   #346	-> 57
/*     */     //   #349	-> 60
/*     */     //   #347	-> 63
/*     */     //   #348	-> 64
/*     */     //   #350	-> 73
/*     */     //   #351	-> 83
/*     */     //   #352	-> 94
/*     */     //   #354	-> 99
/*     */     //   #339	-> 102
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	11	102	finally
/*     */     //   11	16	63	java/lang/Exception
/*     */     //   11	16	102	finally
/*     */     //   16	23	63	java/lang/Exception
/*     */     //   16	23	102	finally
/*     */     //   23	42	63	java/lang/Exception
/*     */     //   23	42	102	finally
/*     */     //   42	57	63	java/lang/Exception
/*     */     //   42	57	102	finally
/*     */     //   64	73	102	finally
/*     */     //   73	83	102	finally
/*     */     //   83	94	102	finally
/*     */     //   94	99	102	finally
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
/*     */   public List<CarPropertyConfig> getPropertyList() throws CarNotConnectedException {
/* 362 */     return this.mCarPropertyMgr.getPropertyList(this.mHvacPropertyIds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPropertyAvailable(int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 371 */     return this.mCarPropertyMgr.isPropertyAvailable(paramInt1, paramInt2);
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
/* 383 */     return this.mCarPropertyMgr.getBooleanProperty(paramInt1, paramInt2);
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
/* 395 */     return this.mCarPropertyMgr.getFloatProperty(paramInt1, paramInt2);
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
/* 407 */     return this.mCarPropertyMgr.getIntProperty(paramInt1, paramInt2);
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
/* 419 */     if (this.mHvacPropertyIds.contains(Integer.valueOf(paramInt1))) {
/* 420 */       this.mCarPropertyMgr.setBooleanProperty(paramInt1, paramInt2, paramBoolean);
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
/* 433 */     if (this.mHvacPropertyIds.contains(Integer.valueOf(paramInt1))) {
/* 434 */       this.mCarPropertyMgr.setFloatProperty(paramInt1, paramInt2, paramFloat);
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
/* 447 */     if (this.mHvacPropertyIds.contains(Integer.valueOf(paramInt1))) {
/* 448 */       this.mCarPropertyMgr.setIntProperty(paramInt1, paramInt2, paramInt3);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 454 */     this.mCarPropertyMgr.onCarDisconnected();
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface PropertyId {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\hvac\CarHvacManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */