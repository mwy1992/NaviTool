/*     */ package com.ecarx.xui.adaptapi.input;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.ServiceManager;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.ECarXCarHardKeyManager;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.IKeyEventListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InputImpl
/*     */   extends Input
/*     */   implements IInputSettings, IConnectable
/*     */ {
/*     */   private static final String CLIENT_GKUI = "com.geely.inputservice";
/*     */   private static final String CLIENT_HICAR = "com.ecarx.hmi";
/*     */   private static final boolean DEBUG = true;
/*     */   private static final String TAG = "InputImpl";
/*     */   public static Context mContext;
/*     */   public static InputImpl sInstance;
/*  40 */   private static int mCookie = -1; private IKeyEventListener mCarKeyEventListener;
/*  41 */   private final Object mLock = new Object(); @GuardedBy("mLock")
/*     */   private ECarXCar mECarXCar;
/*     */   private IECarXCar mECarXCarService;
/*     */   private HandlerThread mHandlerThread;
/*     */   private ECarXCarHardKeyManager mHardKeyManager;
/*     */   private CarHandler mInputHandler;
/*     */   private IKeyCallback mKeyCallback;
/*     */   private IConnectable.IConnectWatcher mWatcher;
/*     */   
/*     */   private InputImpl(Context paramContext) {
/*  51 */     mContext = paramContext;
/*  52 */     String str = mContext.getPackageName();
/*  53 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("enter constructor app pkg: "); stringBuilder.append(str); Log.v("InputImpl", stringBuilder.toString());
/*  54 */     if (str.equals("com.geely.inputservice")) {
/*  55 */       mCookie = 0;
/*  56 */     } else if (str.equals("com.ecarx.hmi")) {
/*  57 */       mCookie = 1;
/*     */     }
/*     */     else {
/*     */       
/*  61 */       stringBuilder = new StringBuilder(); stringBuilder.append("unsupport client, override cookie_gkui pkg: "); stringBuilder.append(str); Log.w("InputImpl", stringBuilder.toString());
/*     */     } 
/*  63 */     this.mHandlerThread = new HandlerThread("InputHandler");
/*  64 */     this.mHandlerThread.start();
/*  65 */     this.mInputHandler = new CarHandler(this.mHandlerThread.getLooper());
/*  66 */     this.mCarKeyEventListener = (IKeyEventListener)new KeyEventListenerStub();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InputImpl create(Context paramContext) {
/*     */     /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/input/InputImpl}} */
/*  77 */     if (paramContext != null)
/*  78 */       try { InputImpl inputImpl1 = new InputImpl(); this(paramContext); sInstance = inputImpl1; }
/*     */       finally {} 
/*  80 */     InputImpl inputImpl = sInstance; /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/input/InputImpl}} */ return inputImpl;
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
/*     */   public int[] requestKeysInterception(int[] paramArrayOfint, IKeyCallback paramIKeyCallback) {
/*  93 */     if (!isServiceConnected()) {
/*  94 */       return null;
/*     */     }
/*  96 */     if (mCookie == -1) {
/*  97 */       Log.w("InputImpl", "unsupport client request key interception");
/*  98 */       return null;
/*     */     } 
/* 100 */     this.mKeyCallback = paramIKeyCallback;
/* 101 */     paramArrayOfint = this.mHardKeyManager.requestHardKeyEvent(paramArrayOfint, this.mCarKeyEventListener, mCookie);
/* 102 */     return paramArrayOfint;
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
/*     */   public boolean abandonKeysInterception(IKeyCallback paramIKeyCallback) {
/* 116 */     if (!isServiceConnected()) {
/* 117 */       return false;
/*     */     }
/* 119 */     this.mKeyCallback = null;
/* 120 */     if (mCookie == -1) {
/* 121 */       Log.w("InputImpl", "unsupport client abandon key interception");
/* 122 */       return false;
/*     */     } 
/* 124 */     this.mHardKeyManager.abandonHardKeyEvent(this.mCarKeyEventListener, mCookie);
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isServiceConnected() {
/* 129 */     if (this.mHardKeyManager != null && isECarXCarConnected()) {
/* 130 */       return true;
/*     */     }
/* 132 */     Log.i("InputImpl", "service disconnected!, plz connect to hardkeyservice");
/* 133 */     return false;
/*     */   }
/*     */   private class KeyEventListenerStub extends IKeyEventListener.Stub { final InputImpl this$0;
/*     */     
/*     */     private KeyEventListenerStub() {}
/*     */     
/*     */     public boolean onKeyPressed(int param1Int) {
/* 140 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onKeyPressed cookie="); stringBuilder.append(InputImpl.mCookie); stringBuilder.append(" keyCode="); stringBuilder.append(param1Int); Log.v("InputImpl", stringBuilder.toString());
/*     */       try {
/* 142 */         if (InputImpl.this.mKeyCallback != null) {
/* 143 */           return InputImpl.this.mKeyCallback.onKeyPressed(param1Int);
/*     */         }
/* 145 */         return false;
/*     */       }
/* 147 */       catch (Exception exception) {
/* 148 */         exception.printStackTrace();
/*     */         
/* 150 */         return false;
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean onKeyReleased(int param1Int) {
/* 155 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onKeyReleased cookie="); stringBuilder.append(InputImpl.mCookie); stringBuilder.append(" keyCode="); stringBuilder.append(param1Int); Log.v("InputImpl", stringBuilder.toString());
/*     */       try {
/* 157 */         if (InputImpl.this.mKeyCallback != null) {
/* 158 */           return InputImpl.this.mKeyCallback.onKeyReleased(param1Int);
/*     */         }
/* 160 */         return false;
/*     */       }
/* 162 */       catch (Exception exception) {
/* 163 */         exception.printStackTrace();
/*     */         
/* 165 */         return false;
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public IInputSettings getInputSettings() {
/* 172 */     if (sInstance == null) {
/* 173 */       sInstance = new InputImpl(mContext);
/*     */     }
/* 175 */     return sInstance;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getInputSettingDuration(int paramInt) {
/* 180 */     if (!isServiceConnected()) {
/* 181 */       return -1L;
/*     */     }
/* 183 */     return this.mHardKeyManager.getInputSettingDuration(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInputSettingValue(int paramInt) {
/* 188 */     if (!isServiceConnected()) {
/* 189 */       return -1;
/*     */     }
/* 191 */     return this.mHardKeyManager.getInputSettingValue(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSteerWheelType() {
/* 197 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCustomFunctionType() {
/* 203 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public FunctionStatus isInputSettingsSupported() {
/* 208 */     return FunctionStatus.active;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 216 */     this.mWatcher = paramIConnectWatcher;
/* 217 */     if (this.mWatcher != null && isECarXCarConnected()) {
/* 218 */       this.mInputHandler.sendEmptyMessage(2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 224 */     this.mWatcher = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void connect() {
/* 229 */     if (this.mInputHandler.hasMessages(1)) {
/* 230 */       this.mInputHandler.removeMessages(1);
/* 231 */       bindToEcarxHardKeyService();
/*     */     } else {
/* 233 */       bindToEcarxHardKeyService();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void disconnect() {
/* 239 */     if (isECarXCarConnected() && this.mHardKeyManager != null) {
/* 240 */       Log.i("InputImpl", "disconnect to hardkeyservice");
/*     */       
/* 242 */       if (this.mKeyCallback != null && this.mCarKeyEventListener != null && mCookie != -1) {
/* 243 */         this.mHardKeyManager.abandonHardKeyEvent(this.mCarKeyEventListener, mCookie);
/*     */       }
/* 245 */       this.mHardKeyManager.serviceDisconnected();
/* 246 */       this.mHardKeyManager = null;
/* 247 */       synchronized (this.mLock) {
/* 248 */         this.mECarXCar = null;
/* 249 */         this.mECarXCarService = null;
/*     */         
/* 251 */         notifyAppDisconnect();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void notifyAppDisconnect() {
/* 256 */     if (this.mWatcher != null) {
/*     */       try {
/* 258 */         this.mWatcher.onDisConnected();
/* 259 */       } catch (Exception exception) {
/* 260 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void notifyAppConnect() {
/* 266 */     if (this.mWatcher != null) {
/*     */       try {
/* 268 */         this.mWatcher.onConnected();
/* 269 */       } catch (Exception exception) {
/* 270 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isECarXCarConnected() {
/* 281 */     synchronized (this.mLock) {
/* 282 */       boolean bool; if (this.mECarXCar != null && this.mECarXCar.isConnected()) { bool = true; } else { bool = false; }
/*     */       
/* 284 */       return bool;
/*     */     } 
/*     */   }
/*     */   private void bindToEcarxHardKeyService() {
/* 288 */     ECarXCar eCarXCar = null;
/*     */     try {
/* 290 */       synchronized (this.mLock) {
/*     */         
/* 292 */         IBinder iBinder = ServiceManager.getService("ecarxcar_service");
/*     */         this.mECarXCarService = IECarXCar.Stub.asInterface(iBinder);
/* 294 */         if (mContext != null && this.mECarXCarService != null) {
/* 295 */           this.mECarXCar = ECarXCar.createCar(mContext, this.mECarXCarService);
/*     */         }
/*     */         
/* 298 */         if (this.mECarXCar != null) {
/* 299 */           eCarXCar = this.mECarXCar;
/*     */           
/* 301 */           ECarXCar eCarXCar2 = this.mECarXCar; ECarXCar.CarServiceDieCallback carServiceDieCallback = new ECarXCar.CarServiceDieCallback() {
/*     */               final InputImpl this$0;
/*     */               
/* 304 */               public void onServiceDeath() { InputImpl.this.onEcarxCarServiceDeath(); }
/*     */             };
/*     */           super(this);
/*     */           eCarXCar2.registerDieCallback(carServiceDieCallback);
/* 308 */           ECarXCar eCarXCar1 = this.mECarXCar;
/* 309 */           this.mHardKeyManager = (ECarXCarHardKeyManager)eCarXCar1.getCarManager("car_hardkey");
/*     */         } else {
/* 311 */           this.mInputHandler.sendEmptyMessageDelayed(1, 500L);
/*     */         } 
/*     */ 
/*     */         
/* 315 */         if (eCarXCar != null && this.mHardKeyManager != null)
/* 316 */           notifyAppConnect(); 
/*     */       } 
/* 318 */     } catch (Exception exception) {
/* 319 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void onEcarxCarServiceDeath() {
/* 324 */     Log.i("InputImpl", "EcarxCarService died, wait to reconnect");
/* 325 */     if (this.mInputHandler.hasMessages(2)) {
/* 326 */       this.mInputHandler.removeMessages(2);
/*     */     }
/* 328 */     if (this.mInputHandler.hasMessages(1)) {
/* 329 */       this.mInputHandler.removeMessages(1);
/*     */     }
/*     */     
/* 332 */     this.mHardKeyManager.serviceDisconnected();
/* 333 */     synchronized (this.mLock) {
/* 334 */       this.mECarXCar = null;
/* 335 */       this.mECarXCarService = null;
/*     */ 
/*     */       
/* 338 */       notifyAppDisconnect();
/* 339 */       this.mInputHandler.sendEmptyMessageDelayed(1, 500L);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private class CarHandler extends Handler {
/*     */     static final int CAR_CONNECTED_MSG = 2;
/*     */     static final int INIT_CAR_SERVICE_MSG = 1;
/*     */     final InputImpl this$0;
/*     */     
/*     */     CarHandler(Looper param1Looper) {
/* 350 */       super(param1Looper);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 355 */       if (param1Message.what == 1) {
/* 356 */         InputImpl.this.bindToEcarxHardKeyService();
/* 357 */       } else if (param1Message.what == 2) {
/* 358 */         InputImpl.this.notifyAppConnect();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\input\InputImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */