/*     */ package com.ecarx.xui.adaptapi.tpms;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TPMSImp
/*     */   extends TPMS
/*     */   implements IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*  27 */   private final Map<Integer, TireState> mTireState = new ConcurrentHashMap<>();
/*  28 */   private final List<TPMS.ITireStateMonitor> mITireStateMonitor = new ArrayList<>();
/*  29 */   private final CarSignalManager.CarSignalEventCallback LeFrntTireMsgCallback = new CarSignalManager.CarSignalEventCallback() { final TPMSImp this$0; public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/*     */         float f;
/*     */         boolean bool;
/*     */         TPMSImp tPMSImp;
/*  33 */         Log.d("TPMSImp", "LeFrntTireMsgCallback");
/*  34 */         TireState tireState = (TireState)TPMSImp.this.mTireState.get(Integer.valueOf(1));
/*  35 */         switch (param1ECarXCarPropertyValue.getPropertyId())
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 30618:
/*  55 */             tPMSImp = TPMSImp.this;
/*  56 */             bool = tPMSImp.isTemperatureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setTemperatureWarning(bool); break;
/*     */           case 30617: tPMSImp = TPMSImp.this; f = tPMSImp.getTireTemperature(((Integer)param1ECarXCarPropertyValue.getValue()).intValue()); tireState.setTemperature(f); break;
/*     */           case 30615: tPMSImp = TPMSImp.this; bool = tPMSImp.isPressureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setPressureWarning(bool); break;
/*     */           case 30614: tireState.setPressure(TPMSImp.this.getTirePressure(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break;
/*  60 */           case 30612: tireState.setQuickLeaking(TPMSImp.this.isQuickLeaking(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break; }  TPMSImp.this.callbackTireState(1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onErrorEvent(int param1Int1, int param1Int2) {} }
/*     */   ;
/*     */   
/*  68 */   private final CarSignalManager.CarSignalEventCallback LeReTireMsgCallback = new CarSignalManager.CarSignalEventCallback() { final TPMSImp this$0; public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/*     */         float f;
/*     */         boolean bool;
/*     */         TPMSImp tPMSImp;
/*  72 */         Log.d("TPMSImp", "LeReTireMsgCallback");
/*  73 */         TireState tireState = (TireState)TPMSImp.this.mTireState.get(Integer.valueOf(2));
/*  74 */         switch (param1ECarXCarPropertyValue.getPropertyId())
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 30627:
/*  94 */             tPMSImp = TPMSImp.this;
/*  95 */             bool = tPMSImp.isTemperatureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setTemperatureWarning(bool); break;
/*     */           case 30626: tPMSImp = TPMSImp.this; f = tPMSImp.getTireTemperature(((Integer)param1ECarXCarPropertyValue.getValue()).intValue()); tireState.setTemperature(f); break;
/*     */           case 30624: tPMSImp = TPMSImp.this; bool = tPMSImp.isPressureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setPressureWarning(bool); break;
/*     */           case 30623: tireState.setPressure(TPMSImp.this.getTirePressure(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break;
/*     */           case 30621:
/* 100 */             tireState.setQuickLeaking(TPMSImp.this.isQuickLeaking(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break; }  TPMSImp.this.callbackTireState(2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onErrorEvent(int param1Int1, int param1Int2) {} }
/*     */   ;
/*     */   
/* 108 */   private final CarSignalManager.CarSignalEventCallback RiFrntTireMsgCallback = new CarSignalManager.CarSignalEventCallback() { final TPMSImp this$0; public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/*     */         float f;
/*     */         boolean bool;
/*     */         TPMSImp tPMSImp;
/* 112 */         Log.d("TPMSImp", "RiFrntTireMsgCallback");
/* 113 */         TireState tireState = (TireState)TPMSImp.this.mTireState.get(Integer.valueOf(3));
/* 114 */         switch (param1ECarXCarPropertyValue.getPropertyId())
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 30700:
/* 134 */             tPMSImp = TPMSImp.this;
/* 135 */             bool = tPMSImp.isTemperatureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setTemperatureWarning(bool); break;
/*     */           case 30699: tPMSImp = TPMSImp.this; f = tPMSImp.getTireTemperature(((Integer)param1ECarXCarPropertyValue.getValue()).intValue()); tireState.setTemperature(f); break;
/*     */           case 30697: tPMSImp = TPMSImp.this; bool = tPMSImp.isPressureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setPressureWarning(bool); break;
/*     */           case 30696: tireState.setPressure(TPMSImp.this.getTirePressure(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break;
/* 139 */           case 30694: tireState.setQuickLeaking(TPMSImp.this.isQuickLeaking(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break; }  TPMSImp.this.callbackTireState(3);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onErrorEvent(int param1Int1, int param1Int2) {} }
/*     */   ;
/*     */   
/* 147 */   private final CarSignalManager.CarSignalEventCallback RiReTireMsgCallback = new CarSignalManager.CarSignalEventCallback() { final TPMSImp this$0; public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/*     */         float f;
/*     */         boolean bool;
/*     */         TPMSImp tPMSImp;
/* 151 */         Log.d("TPMSImp", "RiReTireMsgCallback");
/* 152 */         TireState tireState = (TireState)TPMSImp.this.mTireState.get(Integer.valueOf(4));
/* 153 */         switch (param1ECarXCarPropertyValue.getPropertyId())
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 30709:
/* 173 */             tPMSImp = TPMSImp.this;
/* 174 */             bool = tPMSImp.isTemperatureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setTemperatureWarning(bool); break;
/*     */           case 30708: tPMSImp = TPMSImp.this; f = tPMSImp.getTireTemperature(((Integer)param1ECarXCarPropertyValue.getValue()).intValue()); tireState.setTemperature(f); break;
/*     */           case 30706: tPMSImp = TPMSImp.this; bool = tPMSImp.isPressureWarning((Integer)param1ECarXCarPropertyValue.getValue()); tireState.setPressureWarning(bool); break;
/*     */           case 30705: tireState.setPressure(TPMSImp.this.getTirePressure(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break;
/* 178 */           case 30703: tireState.setQuickLeaking(TPMSImp.this.isQuickLeaking(((Integer)param1ECarXCarPropertyValue.getValue()).intValue())); break; }  TPMSImp.this.callbackTireState(4);
/*     */       }
/*     */       
/*     */       public void onErrorEvent(int param1Int1, int param1Int2) {} }
/*     */   ;
/*     */   private static final String TAG = "TPMSImp";
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */   
/*     */   private TPMSImp(Context paramContext) {
/* 188 */     Log.d("TPMSImp", "create TPMSImp");
/* 189 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/* 190 */     this.mECarXCarProxy.initECarXCar();
/*     */     
/* 192 */     registerTireMsgCallback();
/*     */   }
/*     */   
/*     */   public static TPMS create(Context paramContext) {
/* 196 */     TPMSImp tPMSImp = null;
/* 197 */     if (paramContext != null) {
/* 198 */       tPMSImp = new TPMSImp(paramContext);
/*     */     }
/* 200 */     return tPMSImp;
/*     */   }
/*     */   
/*     */   private TireState InitGetLeFState() throws CarNotConnectedException {
/* 204 */     TireState tireState = new TireState();
/* 205 */     CarSignalManager carSignalManager = this.mCarSignalManager;
/* 206 */     boolean bool = isQuickLeaking(carSignalManager.getLeFrntTireMsgFastLoseWarnFlg()); tireState.setQuickLeaking(bool);
/* 207 */     tireState.setPressure(getTirePressure(this.mCarSignalManager.getLeFrntTireMsgP()));
/* 208 */     tireState.setTemperature(getTireTemperature(this.mCarSignalManager.getLeFrntTireMsgT()));
/* 209 */     carSignalManager = this.mCarSignalManager;
/* 210 */     bool = isPressureWarning(Integer.valueOf(carSignalManager.getLeFrntTireMsgPWarnFlg())); tireState.setPressureWarning(bool);
/* 211 */     carSignalManager = this.mCarSignalManager;
/* 212 */     bool = isTemperatureWarning(Integer.valueOf(carSignalManager.getLeFrntTireMsgTWarnFlg())); tireState.setTemperatureWarning(bool);
/* 213 */     return tireState;
/*     */   }
/*     */   
/*     */   private TireState InitGetLeRState() throws CarNotConnectedException {
/* 217 */     TireState tireState = new TireState();
/* 218 */     CarSignalManager carSignalManager = this.mCarSignalManager;
/* 219 */     boolean bool = isQuickLeaking(carSignalManager.getLeReTireMsgFastLoseWarnFlg()); tireState.setQuickLeaking(bool);
/* 220 */     tireState.setPressure(getTirePressure(this.mCarSignalManager.getLeReTireMsgP()));
/* 221 */     tireState.setTemperature(getTireTemperature(this.mCarSignalManager.getLeReTireMsgT()));
/* 222 */     tireState.setPressureWarning(isPressureWarning(Integer.valueOf(this.mCarSignalManager.getLeReTireMsgPWarnFlg())));
/* 223 */     carSignalManager = this.mCarSignalManager;
/* 224 */     bool = isTemperatureWarning(Integer.valueOf(carSignalManager.getLeReTireMsgTWarnFlg())); tireState.setTemperatureWarning(bool);
/* 225 */     return tireState;
/*     */   }
/*     */ 
/*     */   
/*     */   private TireState InitGetRiFState() throws CarNotConnectedException {
/* 230 */     TireState tireState = new TireState();
/* 231 */     CarSignalManager carSignalManager = this.mCarSignalManager;
/* 232 */     boolean bool = isQuickLeaking(carSignalManager.getRiFrntTireMsgFastLoseWarnFlg()); tireState.setQuickLeaking(bool);
/* 233 */     tireState.setPressure(getTirePressure(this.mCarSignalManager.getRiFrntTireMsgP()));
/* 234 */     tireState.setTemperature(getTireTemperature(this.mCarSignalManager.getRiFrntTireMsgT()));
/* 235 */     carSignalManager = this.mCarSignalManager;
/* 236 */     bool = isPressureWarning(Integer.valueOf(carSignalManager.getRiFrntTireMsgPWarnFlg())); tireState.setPressureWarning(bool);
/* 237 */     carSignalManager = this.mCarSignalManager;
/* 238 */     bool = isTemperatureWarning(Integer.valueOf(carSignalManager.getRiFrntTireMsgTWarnFlg())); tireState.setTemperatureWarning(bool);
/* 239 */     return tireState;
/*     */   }
/*     */   
/*     */   private TireState InitGetRiRState() throws CarNotConnectedException {
/* 243 */     TireState tireState = new TireState();
/* 244 */     CarSignalManager carSignalManager = this.mCarSignalManager;
/* 245 */     boolean bool = isQuickLeaking(carSignalManager.getRiReTireMsgFastLoseWarnFlg()); tireState.setQuickLeaking(bool);
/* 246 */     tireState.setPressure(getTirePressure(this.mCarSignalManager.getRiReTireMsgP()));
/* 247 */     tireState.setTemperature(getTireTemperature(this.mCarSignalManager.getRiReTireMsgT()));
/* 248 */     tireState.setPressureWarning(isPressureWarning(Integer.valueOf(this.mCarSignalManager.getRiReTireMsgPWarnFlg())));
/* 249 */     carSignalManager = this.mCarSignalManager;
/* 250 */     bool = isTemperatureWarning(Integer.valueOf(carSignalManager.getRiReTireMsgTWarnFlg())); tireState.setTemperatureWarning(bool);
/* 251 */     return tireState;
/*     */   }
/*     */   
/*     */   private void registerTireMsgCallback() {
/*     */     try {
/* 256 */       this.mCarSignalManager.registerCallback(this.LeFrntTireMsgCallback, getTireSignal());
/*     */       
/* 258 */       this.mCarSignalManager.registerCallback(this.LeReTireMsgCallback, getTireSignal());
/*     */       
/* 260 */       this.mCarSignalManager.registerCallback(this.RiFrntTireMsgCallback, getTireSignal());
/*     */       
/* 262 */       this.mCarSignalManager.registerCallback(this.RiReTireMsgCallback, getTireSignal());
/* 263 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 264 */       carNotConnectedException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private SignalFilter getTireSignal() {
/* 270 */     SignalFilter signalFilter = new SignalFilter();
/*     */ 
/*     */     
/* 273 */     CarSignalManager carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30612));
/*     */     
/* 275 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30614));
/*     */     
/* 277 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30615));
/*     */     
/* 279 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30617));
/*     */     
/* 281 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30618));
/*     */ 
/*     */     
/* 284 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30621));
/*     */     
/* 286 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30623));
/*     */     
/* 288 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30624));
/*     */     
/* 290 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30626));
/*     */     
/* 292 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30627));
/*     */ 
/*     */     
/* 295 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30694));
/*     */     
/* 297 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30696));
/*     */     
/* 299 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30697));
/*     */     
/* 301 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30699));
/*     */     
/* 303 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30700));
/*     */ 
/*     */     
/* 306 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30703));
/*     */     
/* 308 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30705));
/*     */     
/* 310 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30706));
/*     */     
/* 312 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30708));
/*     */     
/* 314 */     carSignalManager = this.mCarSignalManager; signalFilter.add(Integer.valueOf(30709));
/* 315 */     return signalFilter;
/*     */   }
/*     */   
/*     */   private void callbackTireState(int paramInt) {
/* 319 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("tell APP tireState change: "); stringBuilder.append(paramInt); Log.d("TPMSImp", stringBuilder.toString());
/* 320 */     if (this.mITireStateMonitor != null && this.mITireStateMonitor.size() > 0) {
/* 321 */       for (TPMS.ITireStateMonitor iTireStateMonitor : this.mITireStateMonitor) {
/* 322 */         iTireStateMonitor.onTireStateChanged(paramInt, this.mTireState.get(Integer.valueOf(paramInt)));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isTirePressureCalibrationSupported(int paramInt) {
/* 333 */     FunctionStatus functionStatus = FunctionStatus.error;
/* 334 */     if (paramInt == 0) {
/* 335 */       functionStatus = FunctionStatus.active;
/* 336 */     } else if (paramInt == 1) {
/* 337 */       functionStatus = FunctionStatus.notavailable;
/*     */     } 
/* 339 */     return functionStatus;
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
/*     */   public ITireState getTireState(int paramInt) {
/* 351 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getTireState: "); stringBuilder.append(paramInt); Log.d("TPMSImp", stringBuilder.toString());
/* 352 */     return this.mTireState.get(Integer.valueOf(paramInt));
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
/*     */   public ICalibrator getTireCalibrator() {
/* 364 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerTireStateMonitor(TPMS.ITireStateMonitor paramITireStateMonitor) {
/* 375 */     Log.d("TPMSImp", "registerTireStateMonitor");
/* 376 */     boolean bool = false;
/* 377 */     if (!this.mITireStateMonitor.contains(paramITireStateMonitor)) {
/* 378 */       this.mITireStateMonitor.add(paramITireStateMonitor);
/* 379 */       bool = true;
/*     */     } 
/* 381 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterTireStateMonitor(TPMS.ITireStateMonitor paramITireStateMonitor) {
/* 392 */     Log.d("TPMSImp", "unregisterTireStateMonitor");
/* 393 */     boolean bool = false;
/* 394 */     if (this.mITireStateMonitor.contains(paramITireStateMonitor)) {
/* 395 */       this.mITireStateMonitor.remove(paramITireStateMonitor);
/* 396 */       bool = true;
/*     */     } 
/* 398 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean isPressureWarning(Integer paramInteger) {
/*     */     boolean bool;
/* 403 */     if (paramInteger.intValue() != 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */   private boolean isTemperatureWarning(Integer paramInteger) {
/*     */     boolean bool;
/* 407 */     if (paramInteger.intValue() != 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */   
/*     */   private float getTireTemperature(int paramInt) {
/* 411 */     return (paramInt - 50);
/*     */   }
/*     */   
/*     */   private float getTirePressure(int paramInt) {
/* 415 */     return (float)(paramInt * 1.373D);
/*     */   }
/*     */   private boolean isQuickLeaking(int paramInt) {
/*     */     boolean bool;
/* 419 */     if (paramInt != 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceConnected(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 424 */     Log.d("TPMSImp", "onECarXCarServiceConnected");
/* 425 */     this.mCarSignalManager = paramCarSignalManager;
/*     */     try {
/* 427 */       this.mTireState.put(Integer.valueOf(1), InitGetLeFState());
/* 428 */       this.mTireState.put(Integer.valueOf(2), InitGetLeRState());
/* 429 */       this.mTireState.put(Integer.valueOf(3), InitGetRiFState());
/* 430 */       this.mTireState.put(Integer.valueOf(4), InitGetRiRState());
/* 431 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 432 */       carNotConnectedException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 443 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 448 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */   
/*     */   public void connect() {}
/*     */   
/*     */   public void disconnect() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tpms\TPMSImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */