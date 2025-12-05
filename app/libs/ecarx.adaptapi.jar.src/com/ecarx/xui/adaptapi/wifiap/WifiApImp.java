/*     */ package com.ecarx.xui.adaptapi.wifiap;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.net.wifi.SoftApConDevInfo;
/*     */ import android.net.wifi.WifiManager;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WifiApImp
/*     */   extends WifiAp implements ECarXCarProxy.ECarXCarProxyMethod {
/*     */   private static final String TAG = "WifiApImp";
/*     */   private static WifiApImp instance;
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private Context mContext;
/*     */   private ECarXCarProxy mECarXCarProxy;
/*     */   private Handler mHandler;
/*     */   private final HashMap<Integer, IWifiApClientCallback> mRegisteredWifiApClientCallbacks;
/*     */   private WifiManager.SoftApCallback mSoftApCallback;
/*     */   private IWifiAPHost mWifiAPHost;
/*     */   private IWifiApClientCallback mWifiApClientCallback;
/*     */   private HandlerThread mWifiApHandlerThread;
/*  32 */   private List<IWifiApClient> mWifiApList = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WifiManager mWifiManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WifiAp create(Context paramContext) {
/*  50 */     if (paramContext != null && instance == null)
/*  51 */       instance = new WifiApImp(paramContext); 
/*  52 */     return instance;
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
/*     */   public FunctionStatus isWifiSupported() {
/*  68 */     if (this.mCarSignalManager != null) {
/*     */       try {
/*  70 */         int j = this.mCarSignalManager.getcarconfig201();
/*  71 */         int i = this.mCarSignalManager.getcarconfig200();
/*  72 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("mCarConfig200: "); stringBuilder.append(i); Log.d("WifiApImp", stringBuilder.toString());
/*  73 */         stringBuilder = new StringBuilder(); this(); stringBuilder.append("mCarConfig201: "); stringBuilder.append(j); Log.d("WifiApImp", stringBuilder.toString());
/*  74 */         if (j == 2 && (i == 2 || i == 4)) {
/*  75 */           return FunctionStatus.active;
/*     */         }
/*  77 */         return FunctionStatus.notavailable;
/*     */       }
/*  79 */       catch (CarNotConnectedException carNotConnectedException) {
/*  80 */         carNotConnectedException.printStackTrace();
/*  81 */       } catch (Exception exception) {
/*  82 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  86 */     Log.d("WifiApImp", "mCarSignalManager is null, cannot get carconfig200 and 201");
/*  87 */     return FunctionStatus.error;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isWifiAPSupported() {
/*  95 */     if (this.mCarSignalManager != null) {
/*     */       try {
/*  97 */         int j = this.mCarSignalManager.getcarconfig201();
/*  98 */         int i = this.mCarSignalManager.getcarconfig200();
/*  99 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("mCarConfig200: "); stringBuilder.append(i); Log.d("WifiApImp", stringBuilder.toString());
/* 100 */         stringBuilder = new StringBuilder(); this(); stringBuilder.append("mCarConfig201: "); stringBuilder.append(j); Log.d("WifiApImp", stringBuilder.toString());
/* 101 */         if (j == 2 && (i == 3 || i == 4)) {
/* 102 */           return FunctionStatus.active;
/*     */         }
/* 104 */         return FunctionStatus.notavailable;
/*     */       }
/* 106 */       catch (CarNotConnectedException carNotConnectedException) {
/* 107 */         carNotConnectedException.printStackTrace();
/* 108 */       } catch (Exception exception) {
/* 109 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 113 */     Log.d("WifiApImp", "mCarSignalManager is null, cannot get carconfig200 and 201");
/* 114 */     return FunctionStatus.error;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IWifiAPHost getWifiAPHost() {
/* 124 */     return this.mWifiAPHost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxConnections() {
/* 135 */     Log.d("WifiApImp", "not support setMaxConnections");
/* 136 */     return -1;
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
/*     */   public boolean setMaxConnections(int paramInt) {
/* 149 */     Log.d("WifiApImp", "not support setMaxConnections");
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IWifiApClient> getWifiApClients() {
/* 161 */     this.mWifiApList.clear();
/* 162 */     List list = this.mWifiManager.getSoftApConDevInfo();
/* 163 */     for (SoftApConDevInfo softApConDevInfo : list) {
/* 164 */       WifiApClientImp wifiApClientImp = new WifiApClientImp(softApConDevInfo.devName, softApConDevInfo.macAddr, softApConDevInfo.devIpAddr, softApConDevInfo.status);
/* 165 */       this.mWifiApList.add(wifiApClientImp);
/*     */     } 
/* 167 */     return this.mWifiApList;
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
/*     */   public boolean setWifiApClientCallback(IWifiApClientCallback paramIWifiApClientCallback) {
/* 179 */     if (paramIWifiApClientCallback != null) {
/* 180 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setWifiApClientCallback: callback="); stringBuilder.append(paramIWifiApClientCallback); Log.d("WifiApImp", stringBuilder.toString());
/* 181 */       this.mRegisteredWifiApClientCallbacks.put(Integer.valueOf(paramIWifiApClientCallback.hashCode()), paramIWifiApClientCallback);
/* 182 */       this.mWifiManager.registerSoftApCallback(this.mSoftApCallback, this.mHandler);
/* 183 */       return true;
/*     */     } 
/* 185 */     Log.e("WifiApImp", "callback cannot be null");
/* 186 */     return false;
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
/*     */   public boolean unsetWifiApClientCallback(IWifiApClientCallback paramIWifiApClientCallback) {
/* 198 */     if (paramIWifiApClientCallback != null) {
/* 199 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("unsetWifiApClientCallback: callback="); stringBuilder.append(paramIWifiApClientCallback); Log.d("WifiApImp", stringBuilder.toString());
/* 200 */       this.mRegisteredWifiApClientCallbacks.remove(Integer.valueOf(paramIWifiApClientCallback.hashCode()));
/* 201 */       this.mWifiManager.unregisterSoftApCallback(this.mSoftApCallback);
/* 202 */       return true;
/*     */     } 
/* 204 */     Log.e("WifiApImp", "callback cannot be null");
/* 205 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceConnected(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 216 */     Log.d("WifiApImp", "onECarXCarServiceConnected");
/* 217 */     this.mCarSignalManager = paramCarSignalManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 225 */     Log.e("WifiApImp", "onECarXCarServiceDeath");
/* 226 */     this.mCarSignalManager = null;
/*     */   }
/*     */   
/* 229 */   public WifiApImp(Context paramContext) { this.mSoftApCallback = new WifiManager.SoftApCallback() { final WifiApImp this$0;
/*     */         
/*     */         public void onStateChanged(int param1Int1, int param1Int2) {
/* 232 */           Log.d("WifiApImp", "onStateChanged");
/*     */         }
/*     */ 
/*     */         
/*     */         public void onNumClientsChanged(int param1Int) {
/* 237 */           Log.d("WifiApImp", "onNumClientsChanged");
/* 238 */           Iterator<IWifiApClientCallback> iterator = WifiApImp.this.mRegisteredWifiApClientCallbacks.values().iterator();
/* 239 */           while (iterator.hasNext()) {
/* 240 */             IWifiApClientCallback iWifiApClientCallback = iterator.next();
/* 241 */             iWifiApClientCallback.onWifiApClientChanged(WifiApImp.this.getWifiApClients());
/*     */           }  } };
/*     */     this.mContext = paramContext;
/*     */     this.mWifiAPHost = new WifiApHostImp(paramContext);
/*     */     this.mWifiManager = (WifiManager)this.mContext.getSystemService("wifi");
/*     */     this.mECarXCarProxy = new ECarXCarProxy(this.mContext, this);
/*     */     this.mECarXCarProxy.initECarXCar();
/*     */     this.mWifiApHandlerThread = new HandlerThread("WifiApImpl");
/*     */     this.mWifiApHandlerThread.start();
/*     */     this.mHandler = new Handler(this.mWifiApHandlerThread.getLooper());
/* 251 */     this.mRegisteredWifiApClientCallbacks = new HashMap<>(); } public boolean query5GMode() { Log.d("WifiApImp", "query5GMode");
/* 252 */     return this.mWifiManager.query5GMode(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set5GMode(boolean paramBoolean) {
/* 261 */     Log.d("WifiApImp", "set5GMode");
/* 262 */     this.mWifiManager.set5GMode(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isWifi5GModeSupported() {
/* 270 */     if (this.mCarSignalManager != null) {
/*     */       try {
/* 272 */         int i = this.mCarSignalManager.getcarconfig461();
/* 273 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("mCarConfig461: "); stringBuilder.append(i); Log.d("WifiApImp", stringBuilder.toString());
/* 274 */         if (i == 1) {
/* 275 */           return FunctionStatus.active;
/*     */         }
/* 277 */         return FunctionStatus.notavailable;
/*     */       }
/* 279 */       catch (CarNotConnectedException carNotConnectedException) {
/* 280 */         carNotConnectedException.printStackTrace();
/* 281 */       } catch (Exception exception) {
/* 282 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 286 */     Log.d("WifiApImp", "mCarSignalManager is null, cannot get carconfig461");
/* 287 */     return FunctionStatus.error;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\WifiApImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */