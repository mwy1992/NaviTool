/*     */ package com.ecarx.xui.adaptapi.hudinteraction;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.ServiceManager;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfhudManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import ecarx.dimprotocol.DIMProtocolManager;
/*     */ import ecarx.dimprotocol.IDIMProtocolServiceCallback;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HUDInteractionImpl
/*     */   extends HUDInteraction
/*     */ {
/*  35 */   private final Object mECarXCarLock = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   private CarSignalManager.CarSignalEventCallback mSignalCallback = new CarSignalManager.CarSignalEventCallback() {
/*     */       final HUDInteractionImpl this$0;
/*     */       
/*     */       public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/*  56 */         Message message = HUDInteractionImpl.this.mCarHandler.obtainMessage(4, param1ECarXCarPropertyValue.getPropertyId(), ((Integer)param1ECarXCarPropertyValue.getValue()).intValue());
/*  57 */         HUDInteractionImpl.this.mCarHandler.sendMessage(message);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onErrorEvent(int param1Int1, int param1Int2) {}
/*     */     };
/*     */   
/*  65 */   private final int CALIBRATION_START = 1;
/*  66 */   private final int CALIBRATION_END = 0;
/*     */ 
/*     */   
/*  69 */   private HUDInteraction.IInteractionCallback mCallback = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   private int[] mAr300 = new int[8];
/*  78 */   private float[] mAr310 = new float[9];
/*  79 */   private int mCalibrationState = 0;
/*  80 */   private final Object mLock = new Object(); private static final String TAG = "HUDInteractionImpl"; private int hudposition; private CarHandler mCarHandler; private CarSignalManager mCarSignalManager; private Context mContext; private IDIMProtocolServiceCallback mDIMServiceCallback; private DIMProtocolManager mDimProtocolManager; private ADASDrivingAidSyncInfo.InfoData mDrivingAidInfo; @GuardedBy("mECarXCarLock")
/*     */   private ECarXCar mECarXCar; private IECarXCar mECarXCarService; private HandlerThread mHandlerThread; private ECarXCarVfhudManager mHudManager; private int mHudMode; private ADASLaneSyncInfo.LaneInfoData mLaneInfo; private boolean mLaneInfoFlag; private CarPAEventCallback mPACallback; private SignalFilter mSignalFilter; private int mTiGapSetForLgtCtrl; private VehicleSyncInfo.SyncInfoData mVehicleInfo; private boolean mVehicleInfoFlag;
/*     */   
/*     */   private int convertHudDispMode(int paramInt) {
/*  84 */     boolean bool = true;
/*  85 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 102 */         return paramInt;case 3: paramInt = 1; return paramInt;case 2: paramInt = 4; return paramInt;case 1: paramInt = 2; return paramInt;case 0: break; }  paramInt = 3; return paramInt;
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
/*     */   public static HUDInteraction create(Context paramContext) {
/* 114 */     HUDInteractionImpl hUDInteractionImpl = null;
/* 115 */     if (paramContext != null) {
/* 116 */       hUDInteractionImpl = new HUDInteractionImpl(paramContext);
/*     */     }
/* 118 */     return hUDInteractionImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HUDCalibrationParamImpl getHUDCalibrationParam() {
/* 126 */     null = new HUDCalibrationParamImpl();
/* 127 */     synchronized (this.mLock) {
/* 128 */       null.setCoordinate(this.mAr300);
/* 129 */       null.setParameter(this.mAr310);
/*     */       
/* 131 */       return null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initParam() {
/*     */     try {
/* 164 */       Log.d("HUDInteractionImpl", "used for debug");
/* 165 */       byte[] arrayOfByte1 = this.mHudManager.getPA_VF_HUD_ARD300Data().getData();
/* 166 */       StringBuilder stringBuilder2 = new StringBuilder(); this(); stringBuilder2.append("initParam AR300 "); stringBuilder2.append(Arrays.toString(arrayOfByte1)); Log.d("HUDInteractionImpl", stringBuilder2.toString()); int i;
/* 167 */       for (i = 0; i < 8; i++) {
/* 168 */         int[] arrayOfInt = this.mAr300; byte b2 = arrayOfByte1[i * 4], b1 = arrayOfByte1[i * 4 + 1]; arrayOfInt[i] = (arrayOfByte1[i * 4 + 2] & 0xFF) << 8 | (b1 & 0xFF) << 16 | (b2 & 0xFF) << 24 | arrayOfByte1[i * 4 + 3] & 0xFF;
/*     */       } 
/*     */       
/* 171 */       StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("initParam AR300 int"); stringBuilder1.append(Arrays.toString(this.mAr300)); Log.d("HUDInteractionImpl", stringBuilder1.toString());
/*     */       
/* 173 */       byte[] arrayOfByte2 = this.mHudManager.getPA_VF_HUD_ARD310Data().getData();
/* 174 */       stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("initParam AR310 "); stringBuilder1.append(Arrays.toString(arrayOfByte2)); Log.d("HUDInteractionImpl", stringBuilder1.toString());
/* 175 */       for (i = 0; i < 9; i++) {
/* 176 */         this.mAr310[i] = ((arrayOfByte2[i * 4] & 0xFF) << 24 | (arrayOfByte2[i * 4 + 1] & 0xFF) << 16 | (arrayOfByte2[i * 4 + 2] & 0xFF) << 8 | arrayOfByte2[i * 4 + 3] & 0xFF) * 0.01F;
/*     */       }
/*     */       
/* 179 */       stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("initParam AR300 float"); stringBuilder1.append(Arrays.toString(this.mAr310)); Log.d("HUDInteractionImpl", stringBuilder1.toString());
/*     */       
/* 181 */       arrayOfByte2 = this.mHudManager.getPA_VF_HUD_ARD311Data().getData();
/* 182 */       stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("initParam AR311 "); stringBuilder1.append(Arrays.toString(arrayOfByte2)); Log.d("HUDInteractionImpl", stringBuilder1.toString());
/*     */       
/* 184 */       i = arrayOfByte2[0] << 8 | arrayOfByte2[1];
/* 185 */       if (i == 769) {
/* 186 */         this.mCalibrationState = 1;
/* 187 */       } else if (i == 768) {
/* 188 */         this.mCalibrationState = 0;
/*     */       } 
/* 190 */       stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("initParam AR311 initMode "); stringBuilder1.append(this.mCalibrationState); Log.d("HUDInteractionImpl", stringBuilder1.toString());
/* 191 */     } catch (Exception exception) {
/* 192 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void registerSignalCallback() {
/* 197 */     if (this.mCarSignalManager != null) {
/*     */       try {
/* 199 */         Log.d("HUDInteractionImpl", "registerSignalCallback");
/* 200 */         this.mCarSignalManager.registerCallback(this.mSignalCallback, this.mSignalFilter);
/* 201 */       } catch (CarNotConnectedException carNotConnectedException) {
/* 202 */         carNotConnectedException.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void registerHudCallback() {
/* 208 */     SignalFilter signalFilter = new SignalFilter();
/* 209 */     signalFilter.add(Integer.valueOf(33931));
/* 210 */     signalFilter.add(Integer.valueOf(33506));
/* 211 */     signalFilter.add(Integer.valueOf(33507));
/* 212 */     signalFilter.add(Integer.valueOf(33508));
/*     */     try {
/* 214 */       this.mHudManager.registerCallback(this.mPACallback, signalFilter);
/* 215 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 216 */       carNotConnectedException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/* 220 */   private HUDInteractionImpl(Context paramContext) { this.mPACallback = new CarPAEventCallback() { final HUDInteractionImpl this$0;
/*     */         
/*     */         public void onPA_HUD_DispModSet(PATypes.PA_HUD_DispModSet param1PA_HUD_DispModSet) {
/* 223 */           Message message = HUDInteractionImpl.this.mCarHandler.obtainMessage(6, param1PA_HUD_DispModSet.getData(), 0);
/* 224 */           HUDInteractionImpl.this.mCarHandler.sendMessage(message);
/*     */         }
/*     */ 
/*     */         
/*     */         public void onPA_VF_HUD_ARD300Data(PATypes.PA_VF_HUD_ARD300Data param1PA_VF_HUD_ARD300Data) {
/* 229 */           Message message = HUDInteractionImpl.this.mCarHandler.obtainMessage(9, param1PA_VF_HUD_ARD300Data.getData());
/* 230 */           HUDInteractionImpl.this.mCarHandler.sendMessage(message);
/*     */         }
/*     */ 
/*     */         
/*     */         public void onPA_VF_HUD_ARD310Data(PATypes.PA_VF_HUD_ARD310Data param1PA_VF_HUD_ARD310Data) {
/* 235 */           Message message = HUDInteractionImpl.this.mCarHandler.obtainMessage(10, param1PA_VF_HUD_ARD310Data.getData());
/* 236 */           HUDInteractionImpl.this.mCarHandler.sendMessage(message);
/*     */         }
/*     */ 
/*     */         
/*     */         public void onPA_VF_HUD_ARD311Data(PATypes.PA_VF_HUD_ARD311Data param1PA_VF_HUD_ARD311Data) {
/* 241 */           Message message = HUDInteractionImpl.this.mCarHandler.obtainMessage(11, param1PA_VF_HUD_ARD311Data.getData());
/* 242 */           HUDInteractionImpl.this.mCarHandler.sendMessage(message); } }; this.mContext = paramContext; this.mDrivingAidInfo = new ADASDrivingAidSyncInfo.InfoData(); this.mLaneInfo = new ADASLaneSyncInfo.LaneInfoData(); this.mVehicleInfo = new VehicleSyncInfo.SyncInfoData(); this.mLaneInfoFlag = false; this.hudposition = 0; this.mTiGapSetForLgtCtrl = 0; this.mSignalFilter = new SignalFilter(); this.mHandlerThread = new HandlerThread("CarHudHandler"); this.mHandlerThread.start(); this.mCarHandler = new CarHandler(this.mHandlerThread.getLooper()); initECarXCar(); if (this.mHudManager != null) { initParam(); initSignalFilter(); registerSignalCallback(); registerHudCallback(); try {
/*     */         this.mHudMode = convertHudDispMode(this.mHudManager.getPA_HUD_DispModSet().getData());
/*     */       } catch (CarNotConnectedException carNotConnectedException) {
/*     */         carNotConnectedException.printStackTrace();
/*     */       }  }
/* 247 */      Log.d("HUDInteractionImpl", "HUDInteractionImpl"); } protected void initSignalFilter() { addSignalFilter(Integer.valueOf(29058));
/* 248 */     addSignalFilter(Integer.valueOf(29059));
/* 249 */     addSignalFilter(Integer.valueOf(29060));
/* 250 */     addSignalFilter(Integer.valueOf(29061));
/* 251 */     addSignalFilter(Integer.valueOf(29062));
/* 252 */     addSignalFilter(Integer.valueOf(29063));
/* 253 */     addSignalFilter(Integer.valueOf(29064));
/* 254 */     addSignalFilter(Integer.valueOf(29065));
/* 255 */     addSignalFilter(Integer.valueOf(29074));
/* 256 */     addSignalFilter(Integer.valueOf(29075));
/* 257 */     addSignalFilter(Integer.valueOf(29076));
/* 258 */     addSignalFilter(Integer.valueOf(29077));
/* 259 */     addSignalFilter(Integer.valueOf(29078));
/* 260 */     addSignalFilter(Integer.valueOf(29079));
/* 261 */     addSignalFilter(Integer.valueOf(29080));
/* 262 */     addSignalFilter(Integer.valueOf(29081));
/* 263 */     addSignalFilter(Integer.valueOf(28930));
/* 264 */     addSignalFilter(Integer.valueOf(28928));
/* 265 */     addSignalFilter(Integer.valueOf(28924));
/* 266 */     addSignalFilter(Integer.valueOf(28925));
/* 267 */     addSignalFilter(Integer.valueOf(28926));
/* 268 */     addSignalFilter(Integer.valueOf(28927));
/* 269 */     addSignalFilter(Integer.valueOf(28933));
/* 270 */     addSignalFilter(Integer.valueOf(28934));
/* 271 */     addSignalFilter(Integer.valueOf(28935));
/* 272 */     addSignalFilter(Integer.valueOf(28936));
/*     */     
/* 274 */     addSignalFilter(Integer.valueOf(28917));
/* 275 */     addSignalFilter(Integer.valueOf(29141));
/* 276 */     addSignalFilter(Integer.valueOf(29142));
/* 277 */     addSignalFilter(Integer.valueOf(29143));
/* 278 */     addSignalFilter(Integer.valueOf(29144));
/* 279 */     addSignalFilter(Integer.valueOf(28932));
/* 280 */     addSignalFilter(Integer.valueOf(28938));
/* 281 */     addSignalFilter(Integer.valueOf(28937));
/* 282 */     addSignalFilter(Integer.valueOf(28932));
/* 283 */     addSignalFilter(Integer.valueOf(31578));
/* 284 */     addSignalFilter(Integer.valueOf(31549));
/* 285 */     addSignalFilter(Integer.valueOf(31550));
/* 286 */     addSignalFilter(Integer.valueOf(30964));
/* 287 */     addSignalFilter(Integer.valueOf(29153));
/* 288 */     addSignalFilter(Integer.valueOf(31612));
/* 289 */     addSignalFilter(Integer.valueOf(29024)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void requestADASSyncInfo() {
/* 297 */     this.mCarHandler.sendEmptyMessage(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void requestVehicleSyncInfo() {
/* 305 */     this.mCarHandler.sendEmptyMessage(5);
/*     */   }
/*     */ 
/*     */   
/*     */   public int requestHUDMode() {
/* 310 */     this.mCarHandler.sendEmptyMessage(7);
/* 311 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int requestCarFollowingGAPLevel() {
/* 316 */     this.mCarHandler.sendEmptyMessage(8);
/* 317 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int requestADASOpenStatus() {
/* 325 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int requestCalibrationMode() {
/* 333 */     this.mCarHandler.sendEmptyMessage(12);
/* 334 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerCallback(HUDInteraction.IInteractionCallback paramIInteractionCallback) {
/* 344 */     this.mCallback = paramIInteractionCallback;
/*     */     
/* 346 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterCallback(HUDInteraction.IInteractionCallback paramIInteractionCallback) {
/* 356 */     this.mCallback = null;
/* 357 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void requestHUDHeight() {
/* 362 */     this.mCarHandler.sendEmptyMessage(3);
/*     */   }
/*     */   
/*     */   private void addSignalFilter(Integer paramInteger) {
/* 366 */     this.mSignalFilter.add(paramInteger);
/*     */   }
/*     */   
/*     */   private class CarHandler extends Handler { static final int CALLBACK_ADAS_INFO = 2;
/*     */     static final int CALLBACK_AR300 = 9;
/*     */     static final int CALLBACK_AR310 = 10;
/*     */     static final int CALLBACK_AR311 = 11;
/*     */     static final int CALLBACK_DISPMOD = 6;
/*     */     static final int CALLBACK_DISPMOD_INIT = 7;
/*     */     static final int CALLBACK_HUD_INFO = 3;
/*     */     static final int CALLBACK_TIGAPSET = 8;
/*     */     static final int CALLBACK_UPDATE_CALMOD = 12;
/*     */     static final int CALLBACK_VEHICLE_SPEED = 5;
/*     */     static final int INIT_CAR_SERVICE_MSG = 1;
/*     */     static final int UPDATE_SIGNAL_VALUE = 4;
/*     */     final HUDInteractionImpl this$0;
/*     */     
/*     */     CarHandler(Looper param1Looper) {
/* 384 */       super(param1Looper);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: getfield what : I
/*     */       //   4: istore #4
/*     */       //   6: iconst_0
/*     */       //   7: istore_3
/*     */       //   8: iconst_0
/*     */       //   9: istore_2
/*     */       //   10: iload #4
/*     */       //   12: tableswitch default -> 76, 1 -> 790, 2 -> 780, 3 -> 770, 4 -> 752, 5 -> 742, 6 -> 713, 7 -> 703, 8 -> 693, 9 -> 482, 10 -> 269, 11 -> 89, 12 -> 79
/*     */       //   76: goto -> 871
/*     */       //   79: aload_0
/*     */       //   80: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   83: invokestatic access$1300 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   86: goto -> 871
/*     */       //   89: iconst_2
/*     */       //   90: newarray byte
/*     */       //   92: astore #5
/*     */       //   94: aload_1
/*     */       //   95: getfield obj : Ljava/lang/Object;
/*     */       //   98: checkcast [B
/*     */       //   101: iconst_0
/*     */       //   102: aload #5
/*     */       //   104: iconst_0
/*     */       //   105: iconst_2
/*     */       //   106: invokestatic arraycopy : ([BI[BII)V
/*     */       //   109: new java/lang/StringBuilder
/*     */       //   112: astore_1
/*     */       //   113: aload_1
/*     */       //   114: invokespecial <init> : ()V
/*     */       //   117: aload_1
/*     */       //   118: ldc 'Ar311 '
/*     */       //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   123: pop
/*     */       //   124: aload_1
/*     */       //   125: aload #5
/*     */       //   127: invokestatic toString : ([B)Ljava/lang/String;
/*     */       //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   133: pop
/*     */       //   134: ldc 'HUDInteractionImpl'
/*     */       //   136: aload_1
/*     */       //   137: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   140: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   143: pop
/*     */       //   144: aload #5
/*     */       //   146: iconst_0
/*     */       //   147: baload
/*     */       //   148: bipush #8
/*     */       //   150: ishl
/*     */       //   151: aload #5
/*     */       //   153: iconst_1
/*     */       //   154: baload
/*     */       //   155: ior
/*     */       //   156: istore_2
/*     */       //   157: iload_2
/*     */       //   158: sipush #769
/*     */       //   161: if_icmpne -> 176
/*     */       //   164: aload_0
/*     */       //   165: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   168: iconst_1
/*     */       //   169: invokestatic access$1702 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;I)I
/*     */       //   172: pop
/*     */       //   173: goto -> 192
/*     */       //   176: iload_2
/*     */       //   177: sipush #768
/*     */       //   180: if_icmpne -> 192
/*     */       //   183: aload_0
/*     */       //   184: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   187: iconst_0
/*     */       //   188: invokestatic access$1702 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;I)I
/*     */       //   191: pop
/*     */       //   192: aload_0
/*     */       //   193: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   196: invokestatic access$1800 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteraction$IInteractionCallback;
/*     */       //   199: ifnull -> 258
/*     */       //   202: new java/lang/StringBuilder
/*     */       //   205: astore_1
/*     */       //   206: aload_1
/*     */       //   207: invokespecial <init> : ()V
/*     */       //   210: aload_1
/*     */       //   211: ldc 'Ar311 callback to app '
/*     */       //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   216: pop
/*     */       //   217: aload_1
/*     */       //   218: aload_0
/*     */       //   219: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   222: invokestatic access$1700 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)I
/*     */       //   225: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */       //   228: pop
/*     */       //   229: ldc 'HUDInteractionImpl'
/*     */       //   231: aload_1
/*     */       //   232: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   235: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   238: pop
/*     */       //   239: aload_0
/*     */       //   240: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   243: invokestatic access$1800 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteraction$IInteractionCallback;
/*     */       //   246: aload_0
/*     */       //   247: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   250: invokestatic access$1700 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)I
/*     */       //   253: invokeinterface onCalibrationMode : (I)V
/*     */       //   258: goto -> 871
/*     */       //   261: astore_1
/*     */       //   262: aload_1
/*     */       //   263: invokevirtual printStackTrace : ()V
/*     */       //   266: goto -> 871
/*     */       //   269: bipush #36
/*     */       //   271: newarray byte
/*     */       //   273: astore #5
/*     */       //   275: aload_1
/*     */       //   276: getfield obj : Ljava/lang/Object;
/*     */       //   279: checkcast [B
/*     */       //   282: iconst_0
/*     */       //   283: aload #5
/*     */       //   285: iconst_0
/*     */       //   286: bipush #36
/*     */       //   288: invokestatic arraycopy : ([BI[BII)V
/*     */       //   291: new java/lang/StringBuilder
/*     */       //   294: astore_1
/*     */       //   295: aload_1
/*     */       //   296: invokespecial <init> : ()V
/*     */       //   299: aload_1
/*     */       //   300: ldc 'Ar310 '
/*     */       //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   305: pop
/*     */       //   306: aload_1
/*     */       //   307: aload #5
/*     */       //   309: invokestatic toString : ([B)Ljava/lang/String;
/*     */       //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   315: pop
/*     */       //   316: ldc 'HUDInteractionImpl'
/*     */       //   318: aload_1
/*     */       //   319: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   322: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   325: pop
/*     */       //   326: aload_0
/*     */       //   327: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   330: invokestatic access$1400 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)Ljava/lang/Object;
/*     */       //   333: astore_1
/*     */       //   334: aload_1
/*     */       //   335: monitorenter
/*     */       //   336: iload_2
/*     */       //   337: bipush #9
/*     */       //   339: if_icmpge -> 424
/*     */       //   342: aload_0
/*     */       //   343: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   346: invokestatic access$1600 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)[F
/*     */       //   349: iload_2
/*     */       //   350: aload #5
/*     */       //   352: iload_2
/*     */       //   353: iconst_4
/*     */       //   354: imul
/*     */       //   355: baload
/*     */       //   356: sipush #255
/*     */       //   359: iand
/*     */       //   360: bipush #24
/*     */       //   362: ishl
/*     */       //   363: aload #5
/*     */       //   365: iload_2
/*     */       //   366: iconst_4
/*     */       //   367: imul
/*     */       //   368: iconst_1
/*     */       //   369: iadd
/*     */       //   370: baload
/*     */       //   371: sipush #255
/*     */       //   374: iand
/*     */       //   375: bipush #16
/*     */       //   377: ishl
/*     */       //   378: ior
/*     */       //   379: aload #5
/*     */       //   381: iload_2
/*     */       //   382: iconst_4
/*     */       //   383: imul
/*     */       //   384: iconst_2
/*     */       //   385: iadd
/*     */       //   386: baload
/*     */       //   387: sipush #255
/*     */       //   390: iand
/*     */       //   391: bipush #8
/*     */       //   393: ishl
/*     */       //   394: ior
/*     */       //   395: aload #5
/*     */       //   397: iload_2
/*     */       //   398: iconst_4
/*     */       //   399: imul
/*     */       //   400: iconst_3
/*     */       //   401: iadd
/*     */       //   402: baload
/*     */       //   403: sipush #255
/*     */       //   406: iand
/*     */       //   407: ior
/*     */       //   408: i2f
/*     */       //   409: ldc 0.01
/*     */       //   411: fmul
/*     */       //   412: fastore
/*     */       //   413: iinc #2, 1
/*     */       //   416: goto -> 336
/*     */       //   419: astore #5
/*     */       //   421: goto -> 469
/*     */       //   424: aload_1
/*     */       //   425: monitorexit
/*     */       //   426: new java/lang/StringBuilder
/*     */       //   429: astore_1
/*     */       //   430: aload_1
/*     */       //   431: invokespecial <init> : ()V
/*     */       //   434: aload_1
/*     */       //   435: ldc 'Ar310 float '
/*     */       //   437: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   440: pop
/*     */       //   441: aload_1
/*     */       //   442: aload_0
/*     */       //   443: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   446: invokestatic access$1600 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)[F
/*     */       //   449: invokestatic toString : ([F)Ljava/lang/String;
/*     */       //   452: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   455: pop
/*     */       //   456: ldc 'HUDInteractionImpl'
/*     */       //   458: aload_1
/*     */       //   459: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   462: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   465: pop
/*     */       //   466: goto -> 871
/*     */       //   469: aload_1
/*     */       //   470: monitorexit
/*     */       //   471: aload #5
/*     */       //   473: athrow
/*     */       //   474: astore_1
/*     */       //   475: aload_1
/*     */       //   476: invokevirtual printStackTrace : ()V
/*     */       //   479: goto -> 871
/*     */       //   482: bipush #32
/*     */       //   484: newarray byte
/*     */       //   486: astore #5
/*     */       //   488: aload_1
/*     */       //   489: getfield obj : Ljava/lang/Object;
/*     */       //   492: checkcast [B
/*     */       //   495: iconst_0
/*     */       //   496: aload #5
/*     */       //   498: iconst_0
/*     */       //   499: bipush #32
/*     */       //   501: invokestatic arraycopy : ([BI[BII)V
/*     */       //   504: new java/lang/StringBuilder
/*     */       //   507: astore_1
/*     */       //   508: aload_1
/*     */       //   509: invokespecial <init> : ()V
/*     */       //   512: aload_1
/*     */       //   513: ldc 'Ar300 '
/*     */       //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   518: pop
/*     */       //   519: aload_1
/*     */       //   520: aload #5
/*     */       //   522: invokestatic toString : ([B)Ljava/lang/String;
/*     */       //   525: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   528: pop
/*     */       //   529: ldc 'HUDInteractionImpl'
/*     */       //   531: aload_1
/*     */       //   532: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   535: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   538: pop
/*     */       //   539: aload_0
/*     */       //   540: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   543: invokestatic access$1400 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)Ljava/lang/Object;
/*     */       //   546: astore_1
/*     */       //   547: aload_1
/*     */       //   548: monitorenter
/*     */       //   549: iload_3
/*     */       //   550: istore_2
/*     */       //   551: iload_2
/*     */       //   552: bipush #8
/*     */       //   554: if_icmpge -> 635
/*     */       //   557: aload_0
/*     */       //   558: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   561: invokestatic access$1500 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)[I
/*     */       //   564: iload_2
/*     */       //   565: aload #5
/*     */       //   567: iload_2
/*     */       //   568: iconst_4
/*     */       //   569: imul
/*     */       //   570: baload
/*     */       //   571: sipush #255
/*     */       //   574: iand
/*     */       //   575: bipush #24
/*     */       //   577: ishl
/*     */       //   578: aload #5
/*     */       //   580: iload_2
/*     */       //   581: iconst_4
/*     */       //   582: imul
/*     */       //   583: iconst_1
/*     */       //   584: iadd
/*     */       //   585: baload
/*     */       //   586: sipush #255
/*     */       //   589: iand
/*     */       //   590: bipush #16
/*     */       //   592: ishl
/*     */       //   593: ior
/*     */       //   594: aload #5
/*     */       //   596: iload_2
/*     */       //   597: iconst_4
/*     */       //   598: imul
/*     */       //   599: iconst_2
/*     */       //   600: iadd
/*     */       //   601: baload
/*     */       //   602: sipush #255
/*     */       //   605: iand
/*     */       //   606: bipush #8
/*     */       //   608: ishl
/*     */       //   609: ior
/*     */       //   610: aload #5
/*     */       //   612: iload_2
/*     */       //   613: iconst_4
/*     */       //   614: imul
/*     */       //   615: iconst_3
/*     */       //   616: iadd
/*     */       //   617: baload
/*     */       //   618: sipush #255
/*     */       //   621: iand
/*     */       //   622: ior
/*     */       //   623: iastore
/*     */       //   624: iinc #2, 1
/*     */       //   627: goto -> 551
/*     */       //   630: astore #5
/*     */       //   632: goto -> 680
/*     */       //   635: aload_1
/*     */       //   636: monitorexit
/*     */       //   637: new java/lang/StringBuilder
/*     */       //   640: astore_1
/*     */       //   641: aload_1
/*     */       //   642: invokespecial <init> : ()V
/*     */       //   645: aload_1
/*     */       //   646: ldc 'Ar300 int '
/*     */       //   648: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   651: pop
/*     */       //   652: aload_1
/*     */       //   653: aload_0
/*     */       //   654: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   657: invokestatic access$1500 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)[I
/*     */       //   660: invokestatic toString : ([I)Ljava/lang/String;
/*     */       //   663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   666: pop
/*     */       //   667: ldc 'HUDInteractionImpl'
/*     */       //   669: aload_1
/*     */       //   670: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   673: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   676: pop
/*     */       //   677: goto -> 871
/*     */       //   680: aload_1
/*     */       //   681: monitorexit
/*     */       //   682: aload #5
/*     */       //   684: athrow
/*     */       //   685: astore_1
/*     */       //   686: aload_1
/*     */       //   687: invokevirtual printStackTrace : ()V
/*     */       //   690: goto -> 871
/*     */       //   693: aload_0
/*     */       //   694: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   697: invokestatic access$1200 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   700: goto -> 871
/*     */       //   703: aload_0
/*     */       //   704: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   707: invokestatic access$900 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   710: goto -> 871
/*     */       //   713: aload_0
/*     */       //   714: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   717: aload_0
/*     */       //   718: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   721: aload_1
/*     */       //   722: getfield arg1 : I
/*     */       //   725: invokestatic access$600 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;I)I
/*     */       //   728: invokestatic access$502 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;I)I
/*     */       //   731: pop
/*     */       //   732: aload_0
/*     */       //   733: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   736: invokestatic access$900 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   739: goto -> 871
/*     */       //   742: aload_0
/*     */       //   743: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   746: invokestatic access$1000 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   749: goto -> 871
/*     */       //   752: aload_0
/*     */       //   753: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   756: aload_1
/*     */       //   757: getfield arg1 : I
/*     */       //   760: aload_1
/*     */       //   761: getfield arg2 : I
/*     */       //   764: invokestatic access$1100 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;II)V
/*     */       //   767: goto -> 871
/*     */       //   770: aload_0
/*     */       //   771: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   774: invokestatic access$800 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   777: goto -> 871
/*     */       //   780: aload_0
/*     */       //   781: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   784: invokestatic access$700 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   787: goto -> 871
/*     */       //   790: aload_0
/*     */       //   791: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   794: invokevirtual initECarXCar : ()V
/*     */       //   797: aload_0
/*     */       //   798: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   801: invokestatic access$100 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)Lecarx/car/hardware/vehicle/ECarXCarVfhudManager;
/*     */       //   804: ifnull -> 871
/*     */       //   807: aload_0
/*     */       //   808: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   811: invokestatic access$200 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   814: aload_0
/*     */       //   815: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   818: invokevirtual initSignalFilter : ()V
/*     */       //   821: aload_0
/*     */       //   822: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   825: invokestatic access$300 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   828: aload_0
/*     */       //   829: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   832: invokestatic access$400 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)V
/*     */       //   835: aload_0
/*     */       //   836: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   839: aload_0
/*     */       //   840: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   843: aload_0
/*     */       //   844: getfield this$0 : Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;
/*     */       //   847: invokestatic access$100 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;)Lecarx/car/hardware/vehicle/ECarXCarVfhudManager;
/*     */       //   850: invokevirtual getPA_HUD_DispModSet : ()Lecarx/car/hardware/vehicle/PATypes$PA_HUD_DispModSet;
/*     */       //   853: invokevirtual getData : ()I
/*     */       //   856: invokestatic access$600 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;I)I
/*     */       //   859: invokestatic access$502 : (Lcom/ecarx/xui/adaptapi/hudinteraction/HUDInteractionImpl;I)I
/*     */       //   862: pop
/*     */       //   863: goto -> 871
/*     */       //   866: astore_1
/*     */       //   867: aload_1
/*     */       //   868: invokevirtual printStackTrace : ()V
/*     */       //   871: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #390	-> 0
/*     */       //   #432	-> 79
/*     */       //   #433	-> 86
/*     */       //   #467	-> 89
/*     */       //   #468	-> 94
/*     */       //   #469	-> 109
/*     */       //   #470	-> 144
/*     */       //   #471	-> 144
/*     */       //   #472	-> 157
/*     */       //   #473	-> 164
/*     */       //   #474	-> 176
/*     */       //   #475	-> 183
/*     */       //   #477	-> 192
/*     */       //   #478	-> 202
/*     */       //   #479	-> 239
/*     */       //   #483	-> 258
/*     */       //   #481	-> 261
/*     */       //   #482	-> 262
/*     */       //   #451	-> 269
/*     */       //   #452	-> 275
/*     */       //   #453	-> 291
/*     */       //   #454	-> 326
/*     */       //   #455	-> 336
/*     */       //   #456	-> 342
/*     */       //   #455	-> 413
/*     */       //   #459	-> 419
/*     */       //   #460	-> 426
/*     */       //   #463	-> 466
/*     */       //   #459	-> 469
/*     */       //   #461	-> 474
/*     */       //   #462	-> 475
/*     */       //   #464	-> 479
/*     */       //   #436	-> 482
/*     */       //   #437	-> 488
/*     */       //   #438	-> 504
/*     */       //   #439	-> 539
/*     */       //   #440	-> 549
/*     */       //   #441	-> 557
/*     */       //   #440	-> 624
/*     */       //   #443	-> 630
/*     */       //   #444	-> 637
/*     */       //   #447	-> 677
/*     */       //   #443	-> 680
/*     */       //   #445	-> 685
/*     */       //   #446	-> 686
/*     */       //   #448	-> 690
/*     */       //   #429	-> 693
/*     */       //   #430	-> 700
/*     */       //   #420	-> 703
/*     */       //   #421	-> 710
/*     */       //   #413	-> 713
/*     */       //   #414	-> 732
/*     */       //   #418	-> 739
/*     */       //   #423	-> 742
/*     */       //   #424	-> 749
/*     */       //   #426	-> 752
/*     */       //   #427	-> 767
/*     */       //   #409	-> 770
/*     */       //   #410	-> 777
/*     */       //   #406	-> 780
/*     */       //   #407	-> 787
/*     */       //   #392	-> 790
/*     */       //   #393	-> 797
/*     */       //   #394	-> 807
/*     */       //   #395	-> 814
/*     */       //   #396	-> 821
/*     */       //   #397	-> 828
/*     */       //   #399	-> 835
/*     */       //   #400	-> 866
/*     */       //   #401	-> 867
/*     */       //   #402	-> 871
/*     */       //   #486	-> 871
/*     */       // Exception table:
/*     */       //   from	to	target	type
/*     */       //   89	94	261	java/lang/Exception
/*     */       //   94	109	261	java/lang/Exception
/*     */       //   109	144	261	java/lang/Exception
/*     */       //   164	173	261	java/lang/Exception
/*     */       //   183	192	261	java/lang/Exception
/*     */       //   192	202	261	java/lang/Exception
/*     */       //   202	239	261	java/lang/Exception
/*     */       //   239	258	261	java/lang/Exception
/*     */       //   269	275	474	java/lang/Exception
/*     */       //   275	291	474	java/lang/Exception
/*     */       //   291	326	474	java/lang/Exception
/*     */       //   326	336	474	java/lang/Exception
/*     */       //   342	413	419	finally
/*     */       //   424	426	419	finally
/*     */       //   426	466	474	java/lang/Exception
/*     */       //   469	471	419	finally
/*     */       //   471	474	474	java/lang/Exception
/*     */       //   482	488	685	java/lang/Exception
/*     */       //   488	504	685	java/lang/Exception
/*     */       //   504	539	685	java/lang/Exception
/*     */       //   539	549	685	java/lang/Exception
/*     */       //   557	624	630	finally
/*     */       //   635	637	630	finally
/*     */       //   637	677	685	java/lang/Exception
/*     */       //   680	682	630	finally
/*     */       //   682	685	685	java/lang/Exception
/*     */       //   835	863	866	android/car/CarNotConnectedException
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void notifyAdasInfo() {
/* 490 */     ADASDrivingAidSyncInfo aDASDrivingAidSyncInfo = new ADASDrivingAidSyncInfo();
/* 491 */     ADASLaneSyncInfo aDASLaneSyncInfo = new ADASLaneSyncInfo();
/* 492 */     aDASDrivingAidSyncInfo.setInfoData(this.mDrivingAidInfo);
/* 493 */     aDASLaneSyncInfo.setInfoData(this.mLaneInfo);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 501 */     aDASLaneSyncInfo.getLeftUpperLaneCoordinate();
/* 502 */     aDASLaneSyncInfo.getLeftLowerLaneCoordinate();
/* 503 */     aDASLaneSyncInfo.getRightUpperLaneCoordinate();
/* 504 */     aDASLaneSyncInfo.getRightLowerLaneCoordinate();
/* 505 */     aDASLaneSyncInfo.getLeftLaneLeftDetectStartEnd();
/* 506 */     aDASLaneSyncInfo.getLeftLaneRightDetectStartEnd();
/* 507 */     aDASLaneSyncInfo.getRightLaneLeftDetectStartEnd();
/* 508 */     aDASLaneSyncInfo.getRightLaneRightDetectStartEnd();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 519 */       if (this.mCallback != null) {
/* 520 */         this.mCallback.onADASLaneAidSyncInfo(aDASLaneSyncInfo, aDASDrivingAidSyncInfo);
/*     */       }
/* 522 */     } catch (Exception exception) {
/* 523 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyHudInfo() {
/* 528 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyHudInfo "); stringBuilder.append(this.hudposition); Log.d("HUDInteractionImpl", stringBuilder.toString());
/*     */     try {
/* 530 */       if (this.mCallback != null) {
/* 531 */         this.mCallback.onHUDHeightChanged(this.hudposition);
/*     */       }
/* 533 */     } catch (Exception exception) {
/* 534 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyHudMod() {
/* 539 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyHudMod "); stringBuilder.append(this.mHudMode); Log.d("HUDInteractionImpl", stringBuilder.toString());
/*     */     try {
/* 541 */       if (this.mCallback != null) {
/* 542 */         this.mCallback.onHUDModeChanged(this.mHudMode);
/*     */       }
/* 544 */     } catch (Exception exception) {
/* 545 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateCalibrationmode() {
/* 550 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateCalibrationmode "); stringBuilder.append(this.mCalibrationState); Log.d("HUDInteractionImpl", stringBuilder.toString());
/*     */     try {
/* 552 */       if (this.mCallback != null) {
/* 553 */         this.mCallback.onCalibrationMode(this.mCalibrationState);
/*     */       }
/* 555 */     } catch (Exception exception) {
/* 556 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyTiGapSetForLgtCtrl() {
/* 561 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyTiGapSetForLgtCtrl "); stringBuilder.append(this.mTiGapSetForLgtCtrl); Log.d("HUDInteractionImpl", stringBuilder.toString());
/*     */     try {
/* 563 */       if (this.mCallback != null) {
/* 564 */         this.mCallback.onCarFollowingGAPChanged(this.mTiGapSetForLgtCtrl);
/*     */       }
/* 566 */     } catch (Exception exception) {
/* 567 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyVehicleSpeed() {
/* 572 */     VehicleSyncInfo vehicleSyncInfo = new VehicleSyncInfo();
/* 573 */     vehicleSyncInfo.setInfoData(this.mVehicleInfo);
/*     */     try {
/* 575 */       if (this.mCallback != null)
/*     */       {
/*     */ 
/*     */         
/* 579 */         this.mCallback.onVehicleSyncInfo(vehicleSyncInfo);
/*     */       }
/* 581 */     } catch (Exception exception) {
/* 582 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateDataInfo(int paramInt1, int paramInt2) {
/* 588 */     switch (paramInt1) { default: switch (paramInt1) { default: switch (paramInt1) { default: switch (paramInt1) { default: switch (paramInt1) { default: switch (paramInt1) { default: switch (paramInt1)
/*     */                             { default:
/*     */                                 return;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                               
/*     */                               case 31612:
/* 759 */                                 if (this.mVehicleInfoFlag == true)
/* 760 */                                 { this.mVehicleInfoFlag = false;
/* 761 */                                   this.mCarHandler.sendEmptyMessage(5); } case 31578: this.mVehicleInfo.vehicleSpeed = paramInt2 * 0.00391D; this.mVehicleInfoFlag = true;case 30964: this.hudposition = paramInt2; this.mCarHandler.sendEmptyMessage(3);case 29153: if (this.mLaneInfoFlag == true) { this.mLaneInfoFlag = false; this.mCarHandler.sendEmptyMessage(2); } case 29024: this.mTiGapSetForLgtCtrl = paramInt2; this.mCarHandler.sendEmptyMessage(8);case 28930: this.mLaneInfo.AsyLineRiColor = paramInt2; this.mLaneInfoFlag = true;case 28917: break; }  this.mDrivingAidInfo.AsyALgtIndcr = paramInt2; this.mLaneInfoFlag = true;case 31550: this.mVehicleInfo.steerWhlSnsrAgSpd = (short)paramInt2 * 0.0078125D; this.mVehicleInfoFlag = true;case 31549: break; }  this.mVehicleInfo.steerWhlSnsrAg = (short)paramInt2 * 9.765625E-4D; this.mVehicleInfoFlag = true;case 29144: this.mDrivingAidInfo.ObjFrnt1TypOfObjFrnt1 = paramInt2; this.mLaneInfoFlag = true;case 29143: this.mDrivingAidInfo.ObjFrnt1HdDirOfObjFrnt1 = paramInt2; this.mLaneInfoFlag = true;case 29142: this.mDrivingAidInfo.ObjFrnt1DstLgtOfObjFrnt1 = (paramInt2 - 30); this.mLaneInfoFlag = true;case 29141: break; }  this.mDrivingAidInfo.ObjFrnt1DstLatOfObjFrnt1 = paramInt2 * 0.1D - 12.7D; this.mLaneInfoFlag = true;case 29081: this.mLaneInfo.AsyLineRiPah2PrmD = paramInt2 * 1.0E-6D - 0.001D; this.mLaneInfoFlag = true;case 29080: this.mLaneInfo.AsyLineRiPah2PrmC = paramInt2 * 1.0E-4D - 0.1D; this.mLaneInfoFlag = true;case 29079: this.mLaneInfo.AsyLineRiPah2PrmB = paramInt2 * 0.001D - 1.6D; this.mLaneInfoFlag = true;case 29078: this.mLaneInfo.AsyLineRiPah2PrmA = paramInt2 * 0.01D - 30.0D; this.mLaneInfoFlag = true;case 29077: this.mLaneInfo.AsyLineRiPahPrmD = paramInt2 * 1.0E-6D - 0.001D; this.mLaneInfoFlag = true;case 29076: this.mLaneInfo.AsyLineRiPahPrmC = paramInt2 * 1.0E-4D - 0.1D; this.mLaneInfoFlag = true;case 29075: this.mLaneInfo.AsyLineRiPahPrmB = paramInt2 * 0.001D - 1.6D; this.mLaneInfoFlag = true;case 29074: break; }  this.mLaneInfo.AsyLineRiPahPrmA = paramInt2 * 0.01D - 30.0D; this.mLaneInfoFlag = true;case 29065: this.mLaneInfo.AsyLineLePah2PrmD = paramInt2 * 1.0E-6D - 0.001D; this.mLaneInfoFlag = true;case 29064: this.mLaneInfo.AsyLineLePah2PrmC = paramInt2 * 1.0E-4D - 0.1D; this.mLaneInfoFlag = true;case 29063: this.mLaneInfo.AsyLineLePah2PrmB = paramInt2 * 0.001D - 1.6D; this.mLaneInfoFlag = true;case 29062: this.mLaneInfo.AsyLineLePah2PrmA = paramInt2 * 0.01D - 30.0D; this.mLaneInfoFlag = true;case 29061: this.mLaneInfo.AsyLineLePahPrmD = paramInt2 * 1.0E-6D - 0.001D; this.mLaneInfoFlag = true;case 29060: this.mLaneInfo.AsyLineLePahPrmC = paramInt2 * 1.0E-4D - 0.1D; this.mLaneInfoFlag = true;case 29059: this.mLaneInfo.AsyLineLePahPrmB = paramInt2 * 0.001D - 1.6D; this.mLaneInfoFlag = true;case 29058: break; }  this.mLaneInfo.AsyLineLePahPrmA = paramInt2 * 0.01D - 30.0D; this.mLaneInfoFlag = true;case 28938: this.mDrivingAidInfo.CllsnFwdWarn = paramInt2; this.mLaneInfoFlag = true;case 28937: this.mDrivingAidInfo.CllsnAidPost = paramInt2; this.mLaneInfoFlag = true;case 28936: this.mLaneInfo.AsyRiSecStrt = (paramInt2 - 30); this.mLaneInfoFlag = true;case 28935: this.mLaneInfo.AsyRiSecEnd = (paramInt2 - 30); this.mLaneInfoFlag = true;
/*     */           case 28934: this.mLaneInfo.AsyRiFirstStrt = (paramInt2 - 30); this.mLaneInfoFlag = true;
/*     */           case 28933: this.mLaneInfo.AsyRiFirstEnd = (paramInt2 - 30); this.mLaneInfoFlag = true;
/*     */           case 28932: break; }  this.mDrivingAidInfo.frontType = paramInt2; this.mLaneInfoFlag = true;
/*     */       case 28928: this.mLaneInfo.AsyLineLeColor = paramInt2; this.mLaneInfoFlag = true;
/*     */       case 28927: this.mLaneInfo.AsyLeSecStrt = (paramInt2 - 30); this.mLaneInfoFlag = true;
/*     */       case 28926: this.mLaneInfo.AsyLeSecEnd = (paramInt2 - 30); this.mLaneInfoFlag = true;
/*     */       case 28925: this.mLaneInfo.AsyLeFirstStrt = (paramInt2 - 30); this.mLaneInfoFlag = true;
/* 769 */       case 28924: break; }  this.mLaneInfo.AsyLeFirstEnd = (paramInt2 - 30); this.mLaneInfoFlag = true; } public void initECarXCar() { try { synchronized (this.mECarXCarLock) {
/*     */         
/* 771 */         IBinder iBinder = ServiceManager.getService("ecarxcar_service");
/*     */         this.mECarXCarService = IECarXCar.Stub.asInterface(iBinder);
/* 773 */         if (this.mContext != null && this.mECarXCarService != null) {
/* 774 */           this.mECarXCar = ECarXCar.createCar(this.mContext, this.mECarXCarService);
/*     */         }
/*     */         
/* 777 */         if (this.mECarXCar != null) {
/* 778 */           ECarXCar eCarXCar2 = this.mECarXCar; ECarXCar.CarServiceDieCallback carServiceDieCallback = new ECarXCar.CarServiceDieCallback() {
/*     */               final HUDInteractionImpl this$0;
/*     */               
/* 781 */               public void onServiceDeath() { HUDInteractionImpl.this.callECarXCarServiceDeath(); }
/*     */             };
/*     */           super(this);
/*     */           eCarXCar2.registerDieCallback(carServiceDieCallback);
/* 785 */           ECarXCar eCarXCar1 = this.mECarXCar;
/* 786 */           this.mCarSignalManager = (CarSignalManager)eCarXCar1.getCarManager("car_signal");
/* 787 */           this.mHudManager = ((ECarXCarSetManager)this.mECarXCar.getCarManager("car_publicattribute")).getECarXCarVfhudManager();
/*     */         } else {
/* 789 */           this.mCarHandler.sendEmptyMessageDelayed(1, 100L);
/*     */         } 
/*     */       }  }
/* 792 */     catch (Exception exception)
/* 793 */     { exception.printStackTrace(); }
/*     */      }
/*     */ 
/*     */   
/*     */   private void callECarXCarServiceDeath() {
/* 798 */     synchronized (this.mECarXCarLock) {
/* 799 */       this.mECarXCar = null;
/* 800 */       this.mECarXCarService = null;
/*     */ 
/*     */       
/* 803 */       this.mCarHandler.sendEmptyMessageDelayed(1, 100L);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\HUDInteractionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */