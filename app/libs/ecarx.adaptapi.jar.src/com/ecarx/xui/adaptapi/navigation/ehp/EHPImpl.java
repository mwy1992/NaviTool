/*     */ package com.ecarx.xui.adaptapi.navigation.ehp;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import com.ecarx.xui.adaptapi.navigation.ehp.v2.IV2Manager;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EHPImpl
/*     */   implements IEHP, IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final String TAG = "EHPImpl";
/*     */   private Context mContext;
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */   private EHPGpsModule mEHPGpsModule;
/*  26 */   private final int[] mSupportedEHPProtocols = new int[] { 2 };
/*     */ 
/*     */   
/*     */   private IV2Manager mV2Manager;
/*     */ 
/*     */   
/*     */   public EHPImpl(Context paramContext) {
/*  33 */     this.mContext = paramContext;
/*     */     
/*  35 */     this.mEHPGpsModule = new EHPGpsModule(paramContext);
/*  36 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/*  37 */     this.mECarXCarProxy.initECarXCar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isEHPSupported() {
/*  45 */     return FunctionStatus.active;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getSupportedEHPProtocol() {
/*  53 */     return this.mSupportedEHPProtocols;
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
/*     */   public FunctionStatus isEHPByteProtocolSupported(int paramInt) {
/*  67 */     FunctionStatus functionStatus = FunctionStatus.notavailable;
/*  68 */     if (2 == paramInt) {
/*  69 */       functionStatus = FunctionStatus.active;
/*     */     }
/*  71 */     return functionStatus;
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
/*     */   public IV2Manager getEHPV2Manager() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mV2Manager : Lcom/ecarx/xui/adaptapi/navigation/ehp/v2/IV2Manager;
/*     */     //   6: ifnonnull -> 26
/*     */     //   9: new com/ecarx/xui/adaptapi/navigation/ehp/v2/EHPV2ManagerImpl
/*     */     //   12: astore_1
/*     */     //   13: aload_1
/*     */     //   14: aload_0
/*     */     //   15: getfield mContext : Landroid/content/Context;
/*     */     //   18: invokespecial <init> : (Landroid/content/Context;)V
/*     */     //   21: aload_0
/*     */     //   22: aload_1
/*     */     //   23: putfield mV2Manager : Lcom/ecarx/xui/adaptapi/navigation/ehp/v2/IV2Manager;
/*     */     //   26: aload_0
/*     */     //   27: monitorexit
/*     */     //   28: aload_0
/*     */     //   29: getfield mV2Manager : Lcom/ecarx/xui/adaptapi/navigation/ehp/v2/IV2Manager;
/*     */     //   32: areturn
/*     */     //   33: astore_1
/*     */     //   34: aload_0
/*     */     //   35: monitorexit
/*     */     //   36: aload_1
/*     */     //   37: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #81	-> 0
/*     */     //   #82	-> 2
/*     */     //   #83	-> 9
/*     */     //   #85	-> 26
/*     */     //   #86	-> 28
/*     */     //   #85	-> 33
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	33	finally
/*     */     //   9	26	33	finally
/*     */     //   26	28	33	finally
/*     */     //   34	36	33	finally
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
/*     */   public int updadteEHPProtocolData(int paramInt, IEHP.IEHPDataInfo paramIEHPDataInfo) {
/*  95 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerEHPProviderListener(int paramInt, IEHP.IEHPProviderListener paramIEHPProviderListener) {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterEHPProviderListener(IEHP.IEHPProviderListener paramIEHPProviderListener) {
/* 116 */     return false;
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
/*     */   public void updateEhpDtc(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 131 */     Log.i("EHPImpl", "updateEhpDtc()");
/* 132 */     this.mEHPGpsModule.updateEhpDtc(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerEhpCallback(IEHPCallBack paramIEHPCallBack) {
/* 142 */     this.mEHPGpsModule.registerEhpCallback(paramIEHPCallBack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterEhpCallback(IEHPCallBack paramIEHPCallBack) {
/* 152 */     this.mEHPGpsModule.unregisterEhpCallback(paramIEHPCallBack);
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
/* 163 */     Log.i("EHPImpl", "onECarXCarServiceConnected start ...");
/* 164 */     this.mEHPGpsModule.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 165 */     Log.i("EHPImpl", "onECarXCarServiceConnected done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 173 */     Log.w("EHPImpl", "onECarXCarServiceDeath start ...");
/* 174 */     this.mEHPGpsModule.onECarXCarServiceDeath();
/* 175 */     Log.w("EHPImpl", "onECarXCarServiceDeath done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 185 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 193 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */   
/*     */   public void connect() {}
/*     */   
/*     */   public void disconnect() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\EHPImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */