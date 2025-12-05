/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.util.Log;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ECarXCarFuncManagerBase
/*     */ {
/*  39 */   private final ConcurrentHashMap<CarPAEventCallback, SignalFilter> mCallback = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  42 */   private final SignalFilter mAllSignals = new SignalFilter();
/*     */   
/*  44 */   private CarPAEventListenerToBase mListenerToBase = null;
/*     */   
/*     */   public ECarXCarFuncManagerBase() {
/*  47 */     this.mMgr = null;
/*     */   }
/*     */   
/*     */   private static final boolean DBG = false;
/*     */   private static final String TAG = "ECarXCarFuncManagerBase";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   protected final ECarXCarPropertyManagerBase mMgr;
/*     */   
/*     */   public ECarXCarFuncManagerBase(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  57 */     this.mMgr = paramECarXCarPropertyManagerBase;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerCallback(CarPAEventCallback paramCarPAEventCallback, SignalFilter paramSignalFilter) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   6: invokevirtual isEmpty : ()Z
/*     */     //   9: ifeq -> 40
/*     */     //   12: new ecarx/car/hardware/vehicle/ECarXCarFuncManagerBase$CarPAEventListenerToBase
/*     */     //   15: astore #5
/*     */     //   17: aload #5
/*     */     //   19: aload_0
/*     */     //   20: invokespecial <init> : (Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase;)V
/*     */     //   23: aload_0
/*     */     //   24: aload #5
/*     */     //   26: putfield mListenerToBase : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase$CarPAEventListenerToBase;
/*     */     //   29: aload_0
/*     */     //   30: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*     */     //   33: aload_0
/*     */     //   34: getfield mListenerToBase : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase$CarPAEventListenerToBase;
/*     */     //   37: invokevirtual registerCallback : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase$CarPropertyEventCallback;)V
/*     */     //   40: new ecarx/car/hardware/signal/SignalFilter
/*     */     //   43: astore #5
/*     */     //   45: aload #5
/*     */     //   47: invokespecial <init> : ()V
/*     */     //   50: iconst_0
/*     */     //   51: istore #4
/*     */     //   53: iconst_0
/*     */     //   54: istore_3
/*     */     //   55: iload_3
/*     */     //   56: aload_2
/*     */     //   57: invokevirtual getFilterCount : ()I
/*     */     //   60: if_icmpge -> 106
/*     */     //   63: aload_0
/*     */     //   64: getfield mAllSignals : Lecarx/car/hardware/signal/SignalFilter;
/*     */     //   67: aload_2
/*     */     //   68: iload_3
/*     */     //   69: invokevirtual getSignal : (I)Ljava/lang/Integer;
/*     */     //   72: invokevirtual contains : (Ljava/lang/Integer;)Z
/*     */     //   75: ifne -> 100
/*     */     //   78: aload_0
/*     */     //   79: getfield mAllSignals : Lecarx/car/hardware/signal/SignalFilter;
/*     */     //   82: aload_2
/*     */     //   83: iload_3
/*     */     //   84: invokevirtual getSignal : (I)Ljava/lang/Integer;
/*     */     //   87: invokevirtual add : (Ljava/lang/Integer;)V
/*     */     //   90: aload #5
/*     */     //   92: aload_2
/*     */     //   93: iload_3
/*     */     //   94: invokevirtual getSignal : (I)Ljava/lang/Integer;
/*     */     //   97: invokevirtual add : (Ljava/lang/Integer;)V
/*     */     //   100: iinc #3, 1
/*     */     //   103: goto -> 55
/*     */     //   106: aload_0
/*     */     //   107: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   110: aload_1
/*     */     //   111: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   114: checkcast ecarx/car/hardware/signal/SignalFilter
/*     */     //   117: astore #6
/*     */     //   119: aload #6
/*     */     //   121: ifnonnull -> 137
/*     */     //   124: aload_0
/*     */     //   125: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   128: aload_1
/*     */     //   129: aload_2
/*     */     //   130: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   133: pop
/*     */     //   134: goto -> 188
/*     */     //   137: iload #4
/*     */     //   139: istore_3
/*     */     //   140: iload_3
/*     */     //   141: aload_2
/*     */     //   142: invokevirtual getFilterCount : ()I
/*     */     //   145: if_icmpge -> 177
/*     */     //   148: aload #6
/*     */     //   150: aload_2
/*     */     //   151: iload_3
/*     */     //   152: invokevirtual getSignal : (I)Ljava/lang/Integer;
/*     */     //   155: invokevirtual contains : (Ljava/lang/Integer;)Z
/*     */     //   158: ifne -> 171
/*     */     //   161: aload #6
/*     */     //   163: aload_2
/*     */     //   164: iload_3
/*     */     //   165: invokevirtual getSignal : (I)Ljava/lang/Integer;
/*     */     //   168: invokevirtual add : (Ljava/lang/Integer;)V
/*     */     //   171: iinc #3, 1
/*     */     //   174: goto -> 140
/*     */     //   177: aload_0
/*     */     //   178: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   181: aload_1
/*     */     //   182: aload #6
/*     */     //   184: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   187: pop
/*     */     //   188: aload #5
/*     */     //   190: invokevirtual getFilterCount : ()I
/*     */     //   193: ifle -> 202
/*     */     //   196: aload_0
/*     */     //   197: aload #5
/*     */     //   199: invokevirtual registerSignals : (Lecarx/car/hardware/signal/SignalFilter;)V
/*     */     //   202: aload_0
/*     */     //   203: monitorexit
/*     */     //   204: return
/*     */     //   205: astore_1
/*     */     //   206: aload_0
/*     */     //   207: monitorexit
/*     */     //   208: aload_1
/*     */     //   209: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #69	-> 2
/*     */     //   #70	-> 12
/*     */     //   #71	-> 29
/*     */     //   #73	-> 40
/*     */     //   #74	-> 50
/*     */     //   #75	-> 63
/*     */     //   #76	-> 78
/*     */     //   #77	-> 90
/*     */     //   #74	-> 100
/*     */     //   #80	-> 106
/*     */     //   #81	-> 119
/*     */     //   #82	-> 124
/*     */     //   #84	-> 137
/*     */     //   #85	-> 148
/*     */     //   #86	-> 161
/*     */     //   #84	-> 171
/*     */     //   #89	-> 177
/*     */     //   #92	-> 188
/*     */     //   #93	-> 196
/*     */     //   #95	-> 202
/*     */     //   #68	-> 205
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	12	205	finally
/*     */     //   12	29	205	finally
/*     */     //   29	40	205	finally
/*     */     //   40	50	205	finally
/*     */     //   55	63	205	finally
/*     */     //   63	78	205	finally
/*     */     //   78	90	205	finally
/*     */     //   90	100	205	finally
/*     */     //   106	119	205	finally
/*     */     //   124	134	205	finally
/*     */     //   140	148	205	finally
/*     */     //   148	161	205	finally
/*     */     //   161	171	205	finally
/*     */     //   177	188	205	finally
/*     */     //   188	196	205	finally
/*     */     //   196	202	205	finally
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterCallback(CarPAEventCallback paramCarPAEventCallback) throws CarNotConnectedException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   10: checkcast ecarx/car/hardware/signal/SignalFilter
/*     */     //   13: astore #5
/*     */     //   15: aload_0
/*     */     //   16: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   19: aload_1
/*     */     //   20: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   23: pop
/*     */     //   24: aload_0
/*     */     //   25: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   28: invokevirtual isEmpty : ()Z
/*     */     //   31: ifeq -> 50
/*     */     //   34: aload_0
/*     */     //   35: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*     */     //   38: aload_0
/*     */     //   39: getfield mListenerToBase : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase$CarPAEventListenerToBase;
/*     */     //   42: invokevirtual unregisterCallback : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase$CarPropertyEventCallback;)V
/*     */     //   45: aload_0
/*     */     //   46: aconst_null
/*     */     //   47: putfield mListenerToBase : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase$CarPAEventListenerToBase;
/*     */     //   50: aload #5
/*     */     //   52: ifnonnull -> 95
/*     */     //   55: new java/lang/StringBuilder
/*     */     //   58: astore #5
/*     */     //   60: aload #5
/*     */     //   62: invokespecial <init> : ()V
/*     */     //   65: aload #5
/*     */     //   67: ldc_w 'unregisterCallback wrong callback'
/*     */     //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   73: pop
/*     */     //   74: aload #5
/*     */     //   76: aload_1
/*     */     //   77: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   80: pop
/*     */     //   81: ldc 'ECarXCarFuncManagerBase'
/*     */     //   83: aload #5
/*     */     //   85: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   88: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   91: pop
/*     */     //   92: aload_0
/*     */     //   93: monitorexit
/*     */     //   94: return
/*     */     //   95: new ecarx/car/hardware/signal/SignalFilter
/*     */     //   98: astore_1
/*     */     //   99: aload_1
/*     */     //   100: invokespecial <init> : ()V
/*     */     //   103: iconst_0
/*     */     //   104: istore_2
/*     */     //   105: iload_2
/*     */     //   106: aload #5
/*     */     //   108: invokevirtual getFilterCount : ()I
/*     */     //   111: if_icmpge -> 283
/*     */     //   114: iconst_0
/*     */     //   115: istore #4
/*     */     //   117: aload #5
/*     */     //   119: iload_2
/*     */     //   120: invokevirtual getSignal : (I)Ljava/lang/Integer;
/*     */     //   123: astore #6
/*     */     //   125: aload_0
/*     */     //   126: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   129: invokevirtual values : ()Ljava/util/Collection;
/*     */     //   132: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   137: astore #8
/*     */     //   139: iload #4
/*     */     //   141: istore_3
/*     */     //   142: aload #8
/*     */     //   144: invokeinterface hasNext : ()Z
/*     */     //   149: ifeq -> 220
/*     */     //   152: aload #8
/*     */     //   154: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   159: checkcast ecarx/car/hardware/signal/SignalFilter
/*     */     //   162: astore #7
/*     */     //   164: aload #7
/*     */     //   166: aload #6
/*     */     //   168: invokevirtual contains : (Ljava/lang/Integer;)Z
/*     */     //   171: ifeq -> 217
/*     */     //   174: iconst_1
/*     */     //   175: istore_3
/*     */     //   176: new java/lang/StringBuilder
/*     */     //   179: astore #7
/*     */     //   181: aload #7
/*     */     //   183: invokespecial <init> : ()V
/*     */     //   186: aload #7
/*     */     //   188: ldc_w 'unregisterCallback found '
/*     */     //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   194: pop
/*     */     //   195: aload #7
/*     */     //   197: aload #6
/*     */     //   199: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   202: pop
/*     */     //   203: ldc 'ECarXCarFuncManagerBase'
/*     */     //   205: aload #7
/*     */     //   207: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   210: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   213: pop
/*     */     //   214: goto -> 220
/*     */     //   217: goto -> 139
/*     */     //   220: iload_3
/*     */     //   221: ifne -> 277
/*     */     //   224: aload_1
/*     */     //   225: aload #6
/*     */     //   227: invokevirtual add : (Ljava/lang/Integer;)V
/*     */     //   230: aload_0
/*     */     //   231: getfield mAllSignals : Lecarx/car/hardware/signal/SignalFilter;
/*     */     //   234: aload #6
/*     */     //   236: invokevirtual remove : (Ljava/lang/Integer;)V
/*     */     //   239: new java/lang/StringBuilder
/*     */     //   242: astore #7
/*     */     //   244: aload #7
/*     */     //   246: invokespecial <init> : ()V
/*     */     //   249: aload #7
/*     */     //   251: ldc_w 'unregisterCallback found1 '
/*     */     //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   257: pop
/*     */     //   258: aload #7
/*     */     //   260: aload #6
/*     */     //   262: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   265: pop
/*     */     //   266: ldc 'ECarXCarFuncManagerBase'
/*     */     //   268: aload #7
/*     */     //   270: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   273: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   276: pop
/*     */     //   277: iinc #2, 1
/*     */     //   280: goto -> 105
/*     */     //   283: aload_0
/*     */     //   284: aload_1
/*     */     //   285: invokevirtual unregisterSignals : (Lecarx/car/hardware/signal/SignalFilter;)V
/*     */     //   288: aload_0
/*     */     //   289: monitorexit
/*     */     //   290: return
/*     */     //   291: astore_1
/*     */     //   292: aload_0
/*     */     //   293: monitorexit
/*     */     //   294: aload_1
/*     */     //   295: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #104	-> 2
/*     */     //   #106	-> 15
/*     */     //   #107	-> 24
/*     */     //   #108	-> 34
/*     */     //   #109	-> 45
/*     */     //   #112	-> 50
/*     */     //   #113	-> 55
/*     */     //   #114	-> 92
/*     */     //   #116	-> 95
/*     */     //   #117	-> 103
/*     */     //   #118	-> 114
/*     */     //   #119	-> 117
/*     */     //   #120	-> 125
/*     */     //   #121	-> 164
/*     */     //   #122	-> 174
/*     */     //   #123	-> 176
/*     */     //   #124	-> 214
/*     */     //   #126	-> 217
/*     */     //   #127	-> 220
/*     */     //   #128	-> 224
/*     */     //   #129	-> 230
/*     */     //   #130	-> 239
/*     */     //   #117	-> 277
/*     */     //   #133	-> 283
/*     */     //   #134	-> 288
/*     */     //   #103	-> 291
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	15	291	finally
/*     */     //   15	24	291	finally
/*     */     //   24	34	291	finally
/*     */     //   34	45	291	finally
/*     */     //   45	50	291	finally
/*     */     //   55	92	291	finally
/*     */     //   95	103	291	finally
/*     */     //   105	114	291	finally
/*     */     //   117	125	291	finally
/*     */     //   125	139	291	finally
/*     */     //   142	164	291	finally
/*     */     //   164	174	291	finally
/*     */     //   176	214	291	finally
/*     */     //   224	230	291	finally
/*     */     //   230	239	291	finally
/*     */     //   239	277	291	finally
/*     */     //   283	288	291	finally
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleOnChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/* 138 */     Iterator<Map.Entry> iterator = this.mCallback.entrySet().iterator();
/* 139 */     while (iterator.hasNext()) {
/* 140 */       Map.Entry entry = iterator.next();
/* 141 */       SignalFilter signalFilter = (SignalFilter)entry.getValue();
/* 142 */       CarPAEventCallback carPAEventCallback = (CarPAEventCallback)entry.getKey();
/* 143 */       if (signalFilter.contains(Integer.valueOf(paramECarXCarPropertyValue.getPropertyId()))) {
/* 144 */         carPAEventCallback.onPAChanged(paramECarXCarPropertyValue);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleOnErrorEvent(int paramInt1, int paramInt2) {
/* 152 */     Iterator<Map.Entry> iterator = this.mCallback.entrySet().iterator();
/*     */     
/* 154 */     while (iterator.hasNext()) {
/* 155 */       Map.Entry entry = iterator.next();
/* 156 */       SignalFilter signalFilter = (SignalFilter)entry.getValue();
/* 157 */       CarPAEventCallback carPAEventCallback = (CarPAEventCallback)entry.getKey();
/* 158 */       if (signalFilter.contains(Integer.valueOf(paramInt1))) {
/* 159 */         carPAEventCallback.onErrorEvent(paramInt1, paramInt2);
/* 160 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("handleOnErrorEvent "); stringBuilder.append(paramInt1); Log.d("ECarXCarFuncManagerBase", stringBuilder.toString());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerSignals(SignalFilter paramSignalFilter) throws CarNotConnectedException {
/* 168 */     this.mMgr.registerSignals(paramSignalFilter);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void unregisterSignals(SignalFilter paramSignalFilter) throws CarNotConnectedException {
/* 173 */     this.mMgr.unregisterSignals(paramSignalFilter);
/*     */   }
/*     */   
/*     */   private static class CarPAEventListenerToBase implements ECarXCarPropertyManagerBase.CarPropertyEventCallback {
/*     */     private final WeakReference<ECarXCarFuncManagerBase> mManager;
/*     */     
/*     */     public CarPAEventListenerToBase(ECarXCarFuncManagerBase param1ECarXCarFuncManagerBase) {
/* 180 */       this.mManager = new WeakReference<>(param1ECarXCarFuncManagerBase);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/* 186 */       ECarXCarFuncManagerBase eCarXCarFuncManagerBase = this.mManager.get();
/* 187 */       if (eCarXCarFuncManagerBase != null) {
/* 188 */         eCarXCarFuncManagerBase.handleOnChangeEvent(param1ECarXCarPropertyValue);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void onErrorEvent(int param1Int1, int param1Int2) {
/* 194 */       ECarXCarFuncManagerBase eCarXCarFuncManagerBase = this.mManager.get();
/* 195 */       if (eCarXCarFuncManagerBase != null) {
/* 196 */         eCarXCarFuncManagerBase.handleOnErrorEvent(param1Int1, param1Int2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnect() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mAllSignals : Lecarx/car/hardware/signal/SignalFilter;
/*     */     //   6: invokevirtual clear : ()V
/*     */     //   9: aload_0
/*     */     //   10: getfield mCallback : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   13: invokevirtual clear : ()V
/*     */     //   16: aload_0
/*     */     //   17: monitorexit
/*     */     //   18: return
/*     */     //   19: astore_1
/*     */     //   20: aload_0
/*     */     //   21: monitorexit
/*     */     //   22: aload_1
/*     */     //   23: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #202	-> 2
/*     */     //   #203	-> 9
/*     */     //   #204	-> 16
/*     */     //   #201	-> 19
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	19	finally
/*     */     //   9	16	19	finally
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCBValueForUt(int paramInt) {
/* 210 */     boolean bool = false;
/*     */     
/* 212 */     try { paramInt = this.mMgr.getIntProperty(paramInt, 1); }
/* 213 */     catch (Exception exception) { paramInt = bool; }
/*     */ 
/*     */     
/* 216 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getByteCBValueForUt(int paramInt) {
/* 223 */     byte[] arrayOfByte = null;
/*     */     try {
/* 225 */       byte[] arrayOfByte1 = this.mMgr.getBytesProperty(paramInt, 1);
/* 226 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 229 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setbytesPropertyForUt(int paramInt, byte[] paramArrayOfbyte) {
/*     */     try {
/* 237 */       this.mMgr.setbytesProperty(paramInt, 1, paramArrayOfbyte);
/* 238 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_IntBase getPA_IntBase(int paramInt) {
/* 245 */     PATypes.PA_IntBase pA_IntBase = null;
/*     */     
/*     */     try {
/* 248 */       byte[] arrayOfByte = this.mMgr.getBytesProperty(paramInt, 1);
/* 249 */       PATypes.PA_IntBase pA_IntBase1 = new PATypes.PA_IntBase(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_IntBase = pA_IntBase1;
/* 250 */     } catch (Exception exception) {
/* 251 */       exception.printStackTrace();
/*     */     } 
/* 253 */     return pA_IntBase;
/*     */   }
/*     */ 
/*     */   
/*     */   public PATypes.PA_StringBase getPA_StringBase(int paramInt) {
/* 258 */     PATypes.PA_StringBase pA_StringBase = null;
/*     */     
/*     */     try {
/* 261 */       byte[] arrayOfByte = this.mMgr.getBytesProperty(paramInt, 1);
/* 262 */       PATypes.PA_StringBase pA_StringBase1 = new PATypes.PA_StringBase(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_StringBase = pA_StringBase1;
/* 263 */     } catch (Exception exception) {
/* 264 */       exception.printStackTrace();
/*     */     } 
/* 266 */     return pA_StringBase;
/*     */   }
/*     */ 
/*     */   
/*     */   public PATypes.PA_IntArrayBase getPA_IntArrayBase(int paramInt) {
/* 271 */     PATypes.PA_IntArrayBase pA_IntArrayBase = null;
/*     */     
/*     */     try {
/* 274 */       byte[] arrayOfByte = this.mMgr.getBytesProperty(paramInt, 1);
/* 275 */       PATypes.PA_IntArrayBase pA_IntArrayBase1 = new PATypes.PA_IntArrayBase(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_IntArrayBase = pA_IntArrayBase1;
/* 276 */     } catch (Exception exception) {
/* 277 */       exception.printStackTrace();
/*     */     } 
/* 279 */     return pA_IntArrayBase;
/*     */   }
/*     */ 
/*     */   
/*     */   public PATypes.PA_ByteArrayBase getPA_ByteArrayBase(int paramInt) {
/* 284 */     PATypes.PA_ByteArrayBase pA_ByteArrayBase = null;
/*     */     
/*     */     try {
/* 287 */       byte[] arrayOfByte = this.mMgr.getBytesProperty(paramInt, 1);
/* 288 */       PATypes.PA_ByteArrayBase pA_ByteArrayBase1 = new PATypes.PA_ByteArrayBase(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_ByteArrayBase = pA_ByteArrayBase1;
/* 289 */     } catch (Exception exception) {
/* 290 */       exception.printStackTrace();
/*     */     } 
/* 292 */     return pA_ByteArrayBase;
/*     */   }
/*     */   
/*     */   public ECarXCarPropertyValue<?> getBaseProperty(int paramInt) {
/* 296 */     return this.mMgr.getBaseProperty(paramInt, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarFuncManagerBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */