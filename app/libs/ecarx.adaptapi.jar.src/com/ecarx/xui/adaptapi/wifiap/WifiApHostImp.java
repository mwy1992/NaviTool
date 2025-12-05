/*     */ package com.ecarx.xui.adaptapi.wifiap;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WifiApHostImp
/*     */   implements IWifiAPHost, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final String TAG = "WifiApHostImp";
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private Context mContext;
/*     */   private ECarXCarProxy mECarXCarProxy;
/*     */   private final HashMap<Integer, IWifiAPHost.IWifiAPFrequencyChangeCallBack> mRegisteredApFreqCallbacks;
/*     */   private CarSignalManager.CarSignalEventCallback mSignalCallback;
/*     */   private SignalFilter mSignalFilter;
/*     */   private IWifiAPHost.IWifiAPFrequencyChangeCallBack mWifiAPFrequencyChangeCallBack;
/*     */   
/*     */   public WifiApHostImp(Context paramContext) {
/*  37 */     this.mSignalCallback = new CarSignalManager.CarSignalEventCallback() {
/*     */         final WifiApHostImp this$0;
/*     */         public void onErrorEvent(int param1Int1, int param1Int2) {}
/*  40 */         public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onChangeEvent "); stringBuilder.append(Integer.toHexString(param1ECarXCarPropertyValue.getPropertyId())); Log.d("WifiApHostImp", stringBuilder.toString());
/*  41 */           if (WifiApHostImp.this.mRegisteredApFreqCallbacks != null && !WifiApHostImp.this.mRegisteredApFreqCallbacks.isEmpty()) {
/*  42 */             Iterator<IWifiAPHost.IWifiAPFrequencyChangeCallBack> iterator = WifiApHostImp.this.mRegisteredApFreqCallbacks.values().iterator();
/*  43 */             while (iterator.hasNext()) {
/*  44 */               IWifiAPHost.IWifiAPFrequencyChangeCallBack iWifiAPFrequencyChangeCallBack = iterator.next();
/*  45 */               iWifiAPFrequencyChangeCallBack.onWifiAPFrequencyChange(((Integer)param1ECarXCarPropertyValue.getValue()).intValue());
/*     */             } 
/*     */           }  }
/*     */       };
/*     */     this.mContext = paramContext;
/*     */     this.mRegisteredApFreqCallbacks = new HashMap<>();
/*     */     this.mECarXCarProxy = new ECarXCarProxy(this.mContext, this);
/*     */     this.mECarXCarProxy.initECarXCar();
/*     */     this.mSignalFilter = new SignalFilter();
/*     */     initSignalFilter();
/*     */     registerSignalCallback();
/*     */   } private void registerSignalCallback() {
/*  57 */     if (this.mCarSignalManager != null) {
/*     */       try {
/*  59 */         Log.d("WifiApHostImp", "registerSignalCallback");
/*  60 */         this.mCarSignalManager.registerCallback(this.mSignalCallback, this.mSignalFilter);
/*  61 */       } catch (CarNotConnectedException carNotConnectedException) {
/*  62 */         carNotConnectedException.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void addSignalFilter(Integer paramInteger) {
/*  68 */     this.mSignalFilter.add(paramInteger);
/*     */   }
/*     */   
/*     */   protected void initSignalFilter() {
/*  72 */     addSignalFilter(Integer.valueOf(29422));
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
/*     */   public int[] getSupportedWifiAPFrequency() {
/*  86 */     if (this.mCarSignalManager != null) {
/*     */       try {
/*  88 */         int i = this.mCarSignalManager.getcarconfig196();
/*  89 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("mCarConfig196: "); stringBuilder.append(i); Log.d("WifiApHostImp", stringBuilder.toString());
/*  90 */         if (i == 1)
/*     */         {
/*  92 */           return new int[] { 1 }; } 
/*  93 */         if (i == 2)
/*     */         {
/*  95 */           return new int[] { 2 }; } 
/*  96 */         if (i == 3)
/*     */         {
/*  98 */           return new int[] { 1, 2 };
/*     */         }
/* 100 */       } catch (CarNotConnectedException carNotConnectedException) {
/* 101 */         carNotConnectedException.printStackTrace();
/* 102 */       } catch (Exception exception) {
/* 103 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 107 */     Log.d("WifiApHostImp", "return default 5G");
/*     */     
/* 109 */     return new int[] { 2 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentFrequencyMode() {
/* 120 */     Log.d("WifiApHostImp", "plz use aosp interface");
/* 121 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFrequencyMode(int paramInt) {
/* 132 */     Log.d("WifiApHostImp", "plz use aosp interface");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerWifiAPFrequencyCallBack(IWifiAPHost.IWifiAPFrequencyChangeCallBack paramIWifiAPFrequencyChangeCallBack) {
/* 142 */     if (paramIWifiAPFrequencyChangeCallBack != null) {
/* 143 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerWifiAPFrequencyCallBack: callback="); stringBuilder.append(paramIWifiAPFrequencyChangeCallBack); Log.d("WifiApHostImp", stringBuilder.toString());
/* 144 */       this.mRegisteredApFreqCallbacks.put(Integer.valueOf(paramIWifiAPFrequencyChangeCallBack.hashCode()), paramIWifiAPFrequencyChangeCallBack);
/* 145 */       return true;
/*     */     } 
/* 147 */     Log.e("WifiApHostImp", "callBack cannot be null");
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterWifiAPFrequencyCallBack(IWifiAPHost.IWifiAPFrequencyChangeCallBack paramIWifiAPFrequencyChangeCallBack) {
/* 158 */     if (paramIWifiAPFrequencyChangeCallBack != null) {
/* 159 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("unregisterWifiAPFrequencyCallBack: callback="); stringBuilder.append(paramIWifiAPFrequencyChangeCallBack); Log.d("WifiApHostImp", stringBuilder.toString());
/* 160 */       this.mRegisteredApFreqCallbacks.remove(Integer.valueOf(paramIWifiAPFrequencyChangeCallBack.hashCode()));
/* 161 */       return true;
/*     */     } 
/* 163 */     Log.e("WifiApHostImp", "callBack cannot be null");
/* 164 */     return false;
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
/* 175 */     Log.d("WifiApHostImp", "onECarXCarServiceConnected");
/* 176 */     this.mCarSignalManager = paramCarSignalManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 184 */     Log.e("WifiApHostImp", "onECarXCarServiceDeath");
/* 185 */     this.mCarSignalManager = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\WifiApHostImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */