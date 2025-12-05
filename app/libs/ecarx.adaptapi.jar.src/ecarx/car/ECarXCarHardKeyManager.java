/*     */ package ecarx.car;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ public class ECarXCarHardKeyManager
/*     */   implements ECarXCarManagerBase
/*     */ {
/*     */   private static boolean DEBUG = true;
/*  35 */   private HashMap<Integer, IKeyEventListener> mKeyListener = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static List<Integer> ECARX_HARDKEY_MAP = new ArrayList<>();
/*  40 */   private static List<Integer> ECARX_HICAR_MAP = new ArrayList<>(); public static final int COOKIE_GKUI = 0; public static final int COOKIE_HICAR = 1; public static final int COOKIE_NONE = -1; public static final int DURATION_BUTTON_STUCK = 2; public static final int DURATION_HOLD_PRESS_INTERVAL_TRIGGER = 3; public static final int DURATION_HOLD_SHORT = 1; public static final int INPUT_SETTING_LONG_PRESS_VOLUME_ADJUSTMENT_RATE = 2; public static final int INPUT_SETTING_MAX_STEP_TO_STEP = 5;
/*     */   
/*     */   static {
/*  43 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(110007));
/*  44 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(110008));
/*     */ 
/*     */     
/*  47 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200024));
/*  48 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200025));
/*  49 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200231));
/*  50 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200085));
/*  51 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200088));
/*  52 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200087));
/*  53 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200005));
/*  54 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200006));
/*  55 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(26));
/*  56 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200082));
/*  57 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200164));
/*  58 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(119));
/*  59 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(200400));
/*  60 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300020));
/*  61 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300021));
/*  62 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300022));
/*  63 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300023));
/*  64 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300030));
/*  65 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300031));
/*  66 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300032));
/*  67 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300033));
/*  68 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300034));
/*  69 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(210020));
/*  70 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300050));
/*     */ 
/*     */     
/*  73 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300002));
/*  74 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300001));
/*  75 */     ECARX_HARDKEY_MAP.add(Integer.valueOf(300003));
/*     */   }
/*     */   public static final int INPUT_SETTING_MOVE_OPERATION_DECREASE_RATE = 6; public static final int INPUT_SETTING_MOVE_OPERATION_INCREASE_RATE = 7; public static final int INPUT_SETTING_MOVE_VOLUME_ADJUSTMENT_RATE = 3; public static final int INPUT_SETTING_SHORT_PRESS_VOLUME_ADJUSTMENT = 1; public static final int INPUT_SETTING_SWIPE_VOLUME_ADJUSTMENT_RATE = 4; private static final String TAG = "ECarXHardKeyManager"; private Context mContext; private IHardKey mHardKeyService;
/*     */   public ECarXCarHardKeyManager(Context paramContext, IBinder paramIBinder) {
/*  79 */     this.mContext = paramContext;
/*  80 */     this.mHardKeyService = IHardKey.Stub.asInterface(paramIBinder);
/*     */   }
/*     */   
/*     */   public void serviceDisconnected() {
/*  84 */     this.mHardKeyService = null;
/*  85 */     if (!this.mKeyListener.isEmpty())
/*  86 */       this.mKeyListener.clear(); 
/*     */   }
/*     */   
/*     */   private boolean checkHardKeyService() {
/*     */     boolean bool;
/*  91 */     if (this.mHardKeyService != null) { bool = true; } else { bool = false; }
/*  92 */      if (!bool) {
/*  93 */       Log.e("ECarXHardKeyManager", "HardKeyService disconnected!");
/*     */     }
/*  95 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] requestHardKeyEvent(int[] paramArrayOfint, IKeyEventListener paramIKeyEventListener, int paramInt) {
/* 105 */     if (DEBUG) Log.d("ECarXHardKeyManager", "requestHardKeyEvent"); 
/* 106 */     if (paramIKeyEventListener == null) {
/* 107 */       Log.e("ECarXHardKeyManager", "listener must not be null");
/* 108 */       return null;
/*     */     } 
/* 110 */     if (paramArrayOfint.length == 0) {
/* 111 */       Log.e("ECarXHardKeyManager", "keycode list is empty");
/* 112 */       return paramArrayOfint;
/*     */     } 
/*     */     
/* 115 */     if (!checkHardKeyService()) {
/* 116 */       return null;
/*     */     }
/*     */     
/* 119 */     ArrayList<Integer> arrayList = new ArrayList(); byte b; int i;
/* 120 */     for (i = paramArrayOfint.length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/* 121 */       if (ECARX_HARDKEY_MAP.contains(Integer.valueOf(j))) {
/* 122 */         arrayList.add(Integer.valueOf(j));
/*     */       } else {
/* 124 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("unsupport keycode: "); stringBuilder.append(j); Log.i("ECarXHardKeyManager", stringBuilder.toString());
/*     */       }  b++; }
/*     */     
/* 127 */     paramArrayOfint = new int[arrayList.size()];
/* 128 */     b = 0;
/* 129 */     for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) { i = ((Integer)iterator.next()).intValue();
/* 130 */       paramArrayOfint[b] = i;
/* 131 */       b++; }
/*     */     
/* 133 */     this.mKeyListener.put(Integer.valueOf(paramInt), paramIKeyEventListener);
/*     */     try {
/* 135 */       this.mHardKeyService.requestHardKeyEvent(this.mKeyListener.get(Integer.valueOf(paramInt)), paramInt);
/* 136 */     } catch (RemoteException remoteException) {
/* 137 */       remoteException.printStackTrace();
/*     */     } 
/* 139 */     return paramArrayOfint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void abandonHardKeyEvent(IKeyEventListener paramIKeyEventListener, int paramInt) {
/* 148 */     if (DEBUG) Log.d("ECarXHardKeyManager", "abandonHardKeyEvent"); 
/* 149 */     if (!checkHardKeyService()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 154 */       this.mHardKeyService.abandonHardKeyEvent(paramIKeyEventListener, paramInt);
/* 155 */     } catch (RemoteException remoteException) {
/* 156 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyPowerKeySingleTap() {
/* 164 */     if (!checkHardKeyService()) {
/*     */       return;
/*     */     }
/*     */     
/* 168 */     if (DEBUG) Log.d("ECarXHardKeyManager", "notifyPowerKeySingleTap"); 
/*     */     try {
/* 170 */       this.mHardKeyService.notifyPowerKeySingleTap();
/* 171 */     } catch (RemoteException remoteException) {
/* 172 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyMediaPlayPause() {
/* 180 */     if (!checkHardKeyService()) {
/*     */       return;
/*     */     }
/*     */     
/* 184 */     if (DEBUG) Log.d("ECarXHardKeyManager", "notifyMediaPlayPause"); 
/*     */     try {
/* 186 */       this.mHardKeyService.notifyMediaPlayPause();
/* 187 */     } catch (RemoteException remoteException) {
/* 188 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getInputSettingDuration(int paramInt) {
/*     */     long l1;
/* 198 */     if (paramInt < 1 || paramInt > 3) {
/* 199 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("wrong type for get duration type:"); stringBuilder.append(paramInt); Log.i("ECarXHardKeyManager", stringBuilder.toString());
/* 200 */       return -1L;
/*     */     } 
/* 202 */     if (!checkHardKeyService()) {
/* 203 */       return -1L;
/*     */     }
/*     */     
/* 206 */     long l2 = 0L;
/*     */     try {
/* 208 */       l1 = this.mHardKeyService.getInputSettingDuration(paramInt);
/* 209 */     } catch (RemoteException remoteException) {
/* 210 */       remoteException.printStackTrace(); l1 = l2;
/*     */     } 
/* 212 */     return l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInputSettingValue(int paramInt) {
/* 221 */     if (paramInt < 1 || paramInt > 7) {
/*     */       
/* 223 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("wrong type for get setting value type:"); stringBuilder.append(paramInt); Log.i("ECarXHardKeyManager", stringBuilder.toString());
/* 224 */       return -1;
/*     */     } 
/* 226 */     if (!checkHardKeyService()) {
/* 227 */       return -1;
/*     */     }
/*     */     
/* 230 */     boolean bool = false;
/*     */     try {
/* 232 */       paramInt = this.mHardKeyService.getInputSettingValue(paramInt);
/* 233 */     } catch (RemoteException remoteException) {
/* 234 */       remoteException.printStackTrace(); paramInt = bool;
/*     */     } 
/* 236 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 242 */     if (DEBUG) Log.e("ECarXHardKeyManager", "onCarDisconnected"); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\ECarXCarHardKeyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */