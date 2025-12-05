/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.os.SystemProperties;
/*     */ import android.util.Log;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ import com.ecarx.car.audio.manager.IAudioSettingsCallback;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfcipwakeupManager;
/*     */ import ecarx.pas.IPasService;
/*     */ import ecarx.pas.IPasServiceCallBack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAS
/*     */   extends AbsCarFunction
/*     */   implements IPAS
/*     */ {
/*  74 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private int mExternalAVMState = 0;
/*     */ 
/*     */   
/*  86 */   private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { final PAS this$0;
/*     */       
/*     */       public void binderDied() {
/*  89 */         Log.e("PAS_ADAPTAPI", "binderDied");
/*  90 */         if (PAS.this.mEcarxAudioManager != null)
/*  91 */           PAS.this.mEcarxAudioManager.connect(); 
/*     */       } }
/*     */   ; private static final int PDC_WARNING_HIGH = 3; private static final int PDC_WARNING_LOW = 1; private static final int PDC_WARNING_MID = 2; private static final int PDC_WARNING_NOT_SUPPORT = 1; private static final String TAG = "PAS_ADAPTAPI"; private IPasServiceCallBack callback; private IAudioSettingsCallback mAudioSettingsCallback; private EcarxAudioManager mEcarxAudioManager;
/*     */   private IPasService mPasService;
/*     */   private ECarXCarVfcipwakeupManager vfcManager;
/*     */   
/*  97 */   protected PAS(Context paramContext) { super(paramContext, 587202560);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 917 */     this.callback = (IPasServiceCallBack)new IPasServiceCallBack.Stub() { final PAS this$0; final PAS this$0; public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) { if (PAS.this.mEcarxAudioManager == null)
/*     */             Log.e("PAS_ADAPTAPI", "onServiceConnected mEcarxAudioManager is null");  try { param1IBinder.linkToDeath(PAS.this.mDeathRecipient, 0); } catch (RemoteException remoteException) { remoteException.printStackTrace(); }  Log.d("PAS_ADAPTAPI", "onServiceConnected"); } }
/*     */       ; ServiceConnection serviceConnection = new ServiceConnection() {
/* 920 */         public void onServiceDisconnected(ComponentName param1ComponentName) { if (PAS.this.mEcarxAudioManager != null) { PAS.this.mEcarxAudioManager.connect(); Log.d("PAS_ADAPTAPI", "onServiceDisconnected mEcarxAudioManager.connect()"); }  Log.d("PAS_ADAPTAPI", "onServiceDisconnected"); } public void updateAVMState(int param1Int) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("内置 AVM updateAVMState state = "); stringBuilder.append(param1Int); Log.d("PAS_ADAPTAPI", stringBuilder.toString());
/*     */           
/* 922 */           PAS.this.onFunctionChanged(587399424);
/* 923 */           if (param1Int == 0)
/* 924 */           { PAS.access$202(PAS.this, 0);
/* 925 */             PAS.this.onFunctionValueChanged(587399424, -2147483648, 0); }
/* 926 */           else if (param1Int == 1)
/* 927 */           { PAS.access$202(PAS.this, 1);
/* 928 */             PAS.this.onFunctionValueChanged(587399424, -2147483648, 1); }  }
/*     */       }; Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler); this.mEcarxAudioManager.connect(); this.mAudioSettingsCallback = (IAudioSettingsCallback)new AudioSettingsCallback(); this.mEcarxAudioManager.registerAudioSettingsCallback(this.mAudioSettingsCallback); }
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) { this.vfcManager = paramECarXCarSetManager.getECarXCarVfcipwakeupManager(); }
/*     */   protected void buildFunctions() { Pairs pairs = Pairs.of(Integer.valueOf(0), Integer.valueOf(0)).add(Integer.valueOf(1), Integer.valueOf(1)); IVehicleFunction iVehicleFunction = VehicleFunction.intFunction(587400448); iVehicleFunction = iVehicleFunction.supportedFunctionValue(new int[] { 0, 587400449, 587400450 }); IVehicleFunction.IZone iZone = iVehicleFunction.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus = FunctionStatus.active; IVehicleFunction.IValueTaskBuild iValueTaskBuild = iZone.fixStatus(functionStatus); -$$Lambda$PAS$Nxg8HCmqN-MvOJ9LScPDiP0sVBU -$$Lambda$PAS$Nxg8HCmqN-MvOJ9LScPDiP0sVBU = -$$Lambda$PAS$Nxg8HCmqN-MvOJ9LScPDiP0sVBU.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback = iValueTaskBuild.useValueSignal(29394, -$$Lambda$PAS$Nxg8HCmqN-MvOJ9LScPDiP0sVBU); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE); int i = getSignalValue(29394); if (i != 3 && i != 6 && i != 130 && i != 132) { if (i != 134) { IVehicleFunction iVehicleFunction10; FunctionStatus functionStatus1; -$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA -$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA; -$$Lambda$PAS$f55JgGdWp9DetxpOK26L186w6O8 -$$Lambda$PAS$f55JgGdWp9DetxpOK26L186w6O8; IVehicleFunction.IFilterCallback iFilterCallback7; int[] arrayOfInt; IVehicleFunction.IZone iZone8; IVehicleFunction.IValueTaskBuild iValueTaskBuild11; -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE8; switch (i) { case 11: case 12: Log.d("PAS_ADAPTAPI", "处理外置AVM开关"); iVehicleFunction10 = VehicleFunction.intFunction(587399424); arrayOfInt = COMMON_ON_OFF; iVehicleFunction10 = iVehicleFunction10.supportedFunctionValue(arrayOfInt); iZone8 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE }); functionStatus1 = FunctionStatus.active; iValueTaskBuild11 = iZone8.fixStatus(functionStatus1); -$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA = new -$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA(this); iValueTaskBuild11 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA, pairs); -$$Lambda$PAS$f55JgGdWp9DetxpOK26L186w6O8 = -$$Lambda$PAS$f55JgGdWp9DetxpOK26L186w6O8.INSTANCE; iFilterCallback7 = iValueTaskBuild11.useValueSignal(29021, -$$Lambda$PAS$f55JgGdWp9DetxpOK26L186w6O8); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE8 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback7.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE8); break; }  } else { i = 0; this.mPasService = IPasService.Stub.asInterface(ServiceManager.getService("pas")); for (; this.mPasService == null; i++) { Log.d("PAS_ADAPTAPI", "内置 AVM pas service does not start wait for 1 sec"); try { Thread.sleep(300L); } catch (Exception exception) { exception.printStackTrace(); }  this.mPasService = IPasService.Stub.asInterface(ServiceManager.getService("pas")); if (i > 3) { Log.d("PAS_ADAPTAPI", "内置 AVM tCheckNums > 3 break!"); break; }  }  try { Log.d("PAS_ADAPTAPI", "call registerPasServiceCallBack"); this.mPasService.registerPasServiceCallBack(this.callback); } catch (RemoteException remoteException) { remoteException.printStackTrace(); }  Log.d("PAS_ADAPTAPI", "处理内置AVM开关"); IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(587399424); int[] arrayOfInt = COMMON_ON_OFF; IVehicleFunction iVehicleFunction10 = iVehicleFunction11.supportedFunctionValue(arrayOfInt); IVehicleFunction.IZone iZone8 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus1 = FunctionStatus.active; IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone8.fixStatus(functionStatus1); -$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA -$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA = new -$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$PAS$j3QHgaEE3o0s19DkD8LT3X9JNcA, pairs); -$$Lambda$PAS$1YKBnYgeUmvYbKypNrNekJxtnvg -$$Lambda$PAS$1YKBnYgeUmvYbKypNrNekJxtnvg = new -$$Lambda$PAS$1YKBnYgeUmvYbKypNrNekJxtnvg(this); IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild12.customValue(-$$Lambda$PAS$1YKBnYgeUmvYbKypNrNekJxtnvg); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE8 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback7.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE8); }  IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(587464960); int[] arrayOfInt6 = COMMON_ON_OFF; iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(arrayOfInt6); IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus7 = iZone7.useStatusSignals(new int[] { 29386, 30788, 30779 }); -$$Lambda$PAS$GaVdYP8w_SlpoUY85iTesLMc9bk -$$Lambda$PAS$GaVdYP8w_SlpoUY85iTesLMc9bk = new -$$Lambda$PAS$GaVdYP8w_SlpoUY85iTesLMc9bk(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iMultiSignalStatus7.onStatusSignalChanged(-$$Lambda$PAS$GaVdYP8w_SlpoUY85iTesLMc9bk); -$$Lambda$PAS$Scwz8XqxNjcmwWD4cp8hS-MM-dQ -$$Lambda$PAS$Scwz8XqxNjcmwWD4cp8hS-MM-dQ = new -$$Lambda$PAS$Scwz8XqxNjcmwWD4cp8hS-MM-dQ(this); iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$PAS$Scwz8XqxNjcmwWD4cp8hS-MM-dQ, pairs); -$$Lambda$PAS$id0MEXqJxXSkdBELcwTND9GZJQA -$$Lambda$PAS$id0MEXqJxXSkdBELcwTND9GZJQA = -$$Lambda$PAS$id0MEXqJxXSkdBELcwTND9GZJQA.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild7.useValueSignal(28998, -$$Lambda$PAS$id0MEXqJxXSkdBELcwTND9GZJQA); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE7 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback6.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE7); IVehicleFunction iVehicleFunction9 = VehicleFunction.intFunction(588251392); int[] arrayOfInt2 = COMMON_ON_OFF; IVehicleFunction iVehicleFunction6 = iVehicleFunction9.supportedFunctionValue(arrayOfInt2); IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus4 = iZone6.useStatusSignals(new int[] { 29386, 30788, 30779 }); -$$Lambda$PAS$g5t68TRK1-BJ9242PkrMyPjpEDM -$$Lambda$PAS$g5t68TRK1-BJ9242PkrMyPjpEDM = new -$$Lambda$PAS$g5t68TRK1-BJ9242PkrMyPjpEDM(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iMultiSignalStatus4.onStatusSignalChanged(-$$Lambda$PAS$g5t68TRK1-BJ9242PkrMyPjpEDM); -$$Lambda$PAS$2_L5Gl42y7VAktbQrWegNf3IfRw -$$Lambda$PAS$2_L5Gl42y7VAktbQrWegNf3IfRw = new -$$Lambda$PAS$2_L5Gl42y7VAktbQrWegNf3IfRw(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$PAS$2_L5Gl42y7VAktbQrWegNf3IfRw, pairs); -$$Lambda$PAS$AVm7kDI8d6pqk3buZRcEsqFXr8I -$$Lambda$PAS$AVm7kDI8d6pqk3buZRcEsqFXr8I = -$$Lambda$PAS$AVm7kDI8d6pqk3buZRcEsqFXr8I.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild6.useValueSignal(28998, -$$Lambda$PAS$AVm7kDI8d6pqk3buZRcEsqFXr8I); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE6 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback5.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE6); IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(587268352); int[] arrayOfInt1 = COMMON_ON_OFF; IVehicleFunction iVehicleFunction5 = iVehicleFunction8.supportedFunctionValue(arrayOfInt1); IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus3 = iZone5.useStatusSignals(new int[] { 30788, 30779, 29386 }); -$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw -$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw2 = new -$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iMultiSignalStatus3.onStatusSignalChanged(-$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw2); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE5 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iValueTaskBuild5.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE5); IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(537723136); int[] arrayOfInt5 = COMMON_ON_OFF; iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(arrayOfInt5); IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus6 = iZone4.useStatusSignals(new int[] { 30788, 30779, 29386, 29394 }); -$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw -$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw1 = new -$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iMultiSignalStatus6.onStatusSignalChanged(-$$Lambda$PAS$3t1eyL1k4dllNOKuYiIHfSuMJYw1); -$$Lambda$PAS$7UgQrdnea6_077QXWeE7riW8Snw -$$Lambda$PAS$7UgQrdnea6_077QXWeE7riW8Snw = new -$$Lambda$PAS$7UgQrdnea6_077QXWeE7riW8Snw(this); iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$PAS$7UgQrdnea6_077QXWeE7riW8Snw, pairs); IVehicleFunction.IMultiSignalValue iMultiSignalValue = iValueTaskBuild4.useValueSignals(new int[] { 28995, 31147 }); -$$Lambda$PAS$Mxcpjp21LJ7uH63qqdch4ldcFnk -$$Lambda$PAS$Mxcpjp21LJ7uH63qqdch4ldcFnk = new -$$Lambda$PAS$Mxcpjp21LJ7uH63qqdch4ldcFnk(this); IVehicleFunction.IFilterCallback iFilterCallback4 = iMultiSignalValue.onValueSignalChanged(-$$Lambda$PAS$Mxcpjp21LJ7uH63qqdch4ldcFnk); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE4 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback4.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE4); IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(587596288); int[] arrayOfInt4 = COMMON_ON_OFF; iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(arrayOfInt4); IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus2 = iZone3.useStatusSignals(new int[] { 30788, 30779, 29386 }); -$$Lambda$PAS$mIzlLf7zGSFongyEKMyvR-PwTOc -$$Lambda$PAS$mIzlLf7zGSFongyEKMyvR-PwTOc = new -$$Lambda$PAS$mIzlLf7zGSFongyEKMyvR-PwTOc(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iMultiSignalStatus2.onStatusSignalChanged(-$$Lambda$PAS$mIzlLf7zGSFongyEKMyvR-PwTOc); -$$Lambda$PAS$iXY_Q_cwaADhvGSnL7XfTwHOLQo -$$Lambda$PAS$iXY_Q_cwaADhvGSnL7XfTwHOLQo = new -$$Lambda$PAS$iXY_Q_cwaADhvGSnL7XfTwHOLQo(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$PAS$iXY_Q_cwaADhvGSnL7XfTwHOLQo, pairs); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild9.useValueSignal(29009, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE3 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback3.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE3); IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(587596032); int[] arrayOfInt3 = COMMON_ON_OFF; iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(arrayOfInt3); IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus5 = iZone2.useStatusSignals(new int[] { 30788, 30779, 29386 }); -$$Lambda$PAS$_kZJgmWvINAmh9JvA2shAcPwwpA -$$Lambda$PAS$_kZJgmWvINAmh9JvA2shAcPwwpA = new -$$Lambda$PAS$_kZJgmWvINAmh9JvA2shAcPwwpA(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iMultiSignalStatus5.onStatusSignalChanged(-$$Lambda$PAS$_kZJgmWvINAmh9JvA2shAcPwwpA); -$$Lambda$PAS$ssp94whnikUgvR6_6xIkgLjI2hk -$$Lambda$PAS$ssp94whnikUgvR6_6xIkgLjI2hk = new -$$Lambda$PAS$ssp94whnikUgvR6_6xIkgLjI2hk(this); iValueTaskBuild2 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$PAS$ssp94whnikUgvR6_6xIkgLjI2hk, pairs); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild2.useValueSignal(29002, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE2 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback1.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE2); IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(537723392); iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 537723395, 537723394, 537723393 }); IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus1 = iZone1.useStatusSignals(new int[] { 29386 }); -$$Lambda$PAS$EjxHRtF2LMzIu3qD8tuMNWt29co -$$Lambda$PAS$EjxHRtF2LMzIu3qD8tuMNWt29co = new -$$Lambda$PAS$EjxHRtF2LMzIu3qD8tuMNWt29co(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iMultiSignalStatus1.onStatusSignalChanged(-$$Lambda$PAS$EjxHRtF2LMzIu3qD8tuMNWt29co); -$$Lambda$PAS$-6NbRst48zTqrhttaFta6tpe4D0 -$$Lambda$PAS$-6NbRst48zTqrhttaFta6tpe4D0 = new -$$Lambda$PAS$-6NbRst48zTqrhttaFta6tpe4D0(this); -$$Lambda$PAS$NrVfYdX43r8ap7GTq3XEzOBG0Jo -$$Lambda$PAS$NrVfYdX43r8ap7GTq3XEzOBG0Jo = -$$Lambda$PAS$NrVfYdX43r8ap7GTq3XEzOBG0Jo.INSTANCE; IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$PAS$-6NbRst48zTqrhttaFta6tpe4D0, -$$Lambda$PAS$NrVfYdX43r8ap7GTq3XEzOBG0Jo); -$$Lambda$PAS$VjjDGNkfhdDe50Q_BzlpnPxgzkw -$$Lambda$PAS$VjjDGNkfhdDe50Q_BzlpnPxgzkw = new -$$Lambda$PAS$VjjDGNkfhdDe50Q_BzlpnPxgzkw(this); IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild1.customValue(-$$Lambda$PAS$VjjDGNkfhdDe50Q_BzlpnPxgzkw); -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE1 = new -$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE(this); iFilterCallback2.addTo(-$$Lambda$PAS$ayWvpcyRYvYDYCDwLVYiLGyiYSE1); return; }  }
/*     */   private ApiResult avmSwitch(int paramInt) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: sipush #29394
/*     */     //   6: invokevirtual getSignalValue : (I)I
/*     */     //   9: istore_3
/*     */     //   10: iconst_m1
/*     */     //   11: istore_2
/*     */     //   12: iload_3
/*     */     //   13: iconst_3
/*     */     //   14: if_icmpeq -> 76
/*     */     //   17: iload_3
/*     */     //   18: bipush #6
/*     */     //   20: if_icmpeq -> 76
/*     */     //   23: iload_3
/*     */     //   24: sipush #130
/*     */     //   27: if_icmpeq -> 76
/*     */     //   30: iload_3
/*     */     //   31: sipush #132
/*     */     //   34: if_icmpeq -> 76
/*     */     //   37: iload_3
/*     */     //   38: sipush #134
/*     */     //   41: if_icmpeq -> 71
/*     */     //   44: iload_3
/*     */     //   45: tableswitch default -> 68, 11 -> 76, 12 -> 76
/*     */     //   68: goto -> 78
/*     */     //   71: iconst_2
/*     */     //   72: istore_2
/*     */     //   73: goto -> 78
/*     */     //   76: iconst_1
/*     */     //   77: istore_2
/*     */     //   78: new java/lang/StringBuilder
/*     */     //   81: astore #5
/*     */     //   83: aload #5
/*     */     //   85: invokespecial <init> : ()V
/*     */     //   88: aload #5
/*     */     //   90: ldc 'carconfig154 '
/*     */     //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   95: pop
/*     */     //   96: aload #5
/*     */     //   98: iload_3
/*     */     //   99: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   102: pop
/*     */     //   103: aload #5
/*     */     //   105: ldc ' avmType '
/*     */     //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   110: pop
/*     */     //   111: aload #5
/*     */     //   113: iload_2
/*     */     //   114: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   117: pop
/*     */     //   118: aload #5
/*     */     //   120: ldc ' avmSwitch '
/*     */     //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   125: pop
/*     */     //   126: iload_1
/*     */     //   127: iconst_1
/*     */     //   128: if_icmpne -> 138
/*     */     //   131: ldc ' on'
/*     */     //   133: astore #4
/*     */     //   135: goto -> 142
/*     */     //   138: ldc ' off'
/*     */     //   140: astore #4
/*     */     //   142: aload #5
/*     */     //   144: aload #4
/*     */     //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   149: pop
/*     */     //   150: ldc 'PAS_ADAPTAPI'
/*     */     //   152: aload #5
/*     */     //   154: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   157: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   160: pop
/*     */     //   161: iload_2
/*     */     //   162: iconst_1
/*     */     //   163: if_icmpne -> 499
/*     */     //   166: ldc 'PAS_ADAPTAPI'
/*     */     //   168: ldc '外置AVM'
/*     */     //   170: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   173: pop
/*     */     //   174: ldc 'vendor.sys.pason'
/*     */     //   176: iconst_0
/*     */     //   177: invokestatic getInt : (Ljava/lang/String;I)I
/*     */     //   180: istore_2
/*     */     //   181: iload_2
/*     */     //   182: iload_1
/*     */     //   183: if_icmpne -> 255
/*     */     //   186: new java/lang/StringBuilder
/*     */     //   189: astore #4
/*     */     //   191: aload #4
/*     */     //   193: invokespecial <init> : ()V
/*     */     //   196: aload #4
/*     */     //   198: ldc 'isAvmOn is '
/*     */     //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   203: pop
/*     */     //   204: aload #4
/*     */     //   206: iload_2
/*     */     //   207: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   210: pop
/*     */     //   211: aload #4
/*     */     //   213: ldc ' , the same to the request onOff1 '
/*     */     //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   218: pop
/*     */     //   219: aload #4
/*     */     //   221: iload_1
/*     */     //   222: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   225: pop
/*     */     //   226: aload #4
/*     */     //   228: ldc ' , ignore it'
/*     */     //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   233: pop
/*     */     //   234: ldc 'PAS_ADAPTAPI'
/*     */     //   236: aload #4
/*     */     //   238: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   241: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   244: pop
/*     */     //   245: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   248: astore #4
/*     */     //   250: aload_0
/*     */     //   251: monitorexit
/*     */     //   252: aload #4
/*     */     //   254: areturn
/*     */     //   255: new java/lang/StringBuilder
/*     */     //   258: astore #4
/*     */     //   260: aload #4
/*     */     //   262: invokespecial <init> : ()V
/*     */     //   265: aload #4
/*     */     //   267: ldc 'isAvmOn is '
/*     */     //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   272: pop
/*     */     //   273: aload #4
/*     */     //   275: iload_2
/*     */     //   276: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   279: pop
/*     */     //   280: aload #4
/*     */     //   282: ldc ' , the request onOff1 is '
/*     */     //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   287: pop
/*     */     //   288: aload #4
/*     */     //   290: iload_1
/*     */     //   291: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   294: pop
/*     */     //   295: ldc 'PAS_ADAPTAPI'
/*     */     //   297: aload #4
/*     */     //   299: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   302: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   305: pop
/*     */     //   306: aload_0
/*     */     //   307: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   310: ifnonnull -> 331
/*     */     //   313: ldc 'PAS_ADAPTAPI'
/*     */     //   315: ldc 'avmSwitch mCarSignalManager is null, cannot request'
/*     */     //   317: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   320: pop
/*     */     //   321: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   324: astore #4
/*     */     //   326: aload_0
/*     */     //   327: monitorexit
/*     */     //   328: aload #4
/*     */     //   330: areturn
/*     */     //   331: aload_0
/*     */     //   332: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   335: ifnonnull -> 382
/*     */     //   338: ldc 'PAS_ADAPTAPI'
/*     */     //   340: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   342: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   345: pop
/*     */     //   346: aload_0
/*     */     //   347: aload_0
/*     */     //   348: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   351: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   354: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   357: aload_0
/*     */     //   358: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   361: ifnonnull -> 382
/*     */     //   364: ldc 'PAS_ADAPTAPI'
/*     */     //   366: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   368: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   371: pop
/*     */     //   372: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   375: astore #4
/*     */     //   377: aload_0
/*     */     //   378: monitorexit
/*     */     //   379: aload #4
/*     */     //   381: areturn
/*     */     //   382: aload_0
/*     */     //   383: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   386: iconst_1
/*     */     //   387: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   390: pop
/*     */     //   391: aload_0
/*     */     //   392: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   395: iconst_1
/*     */     //   396: invokevirtual setSwtDispOnAndOffReq : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   399: pop
/*     */     //   400: iload_1
/*     */     //   401: iconst_1
/*     */     //   402: if_icmpne -> 496
/*     */     //   405: ldc 'EvsCameraService'
/*     */     //   407: invokestatic getService : (Ljava/lang/String;)Landroid/os/IBinder;
/*     */     //   410: astore #4
/*     */     //   412: aload #4
/*     */     //   414: ifnonnull -> 428
/*     */     //   417: ldc 'PAS_ADAPTAPI'
/*     */     //   419: ldc 'AVM switch Get EVS server binder is null'
/*     */     //   421: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   424: pop
/*     */     //   425: goto -> 437
/*     */     //   428: ldc 'PAS_ADAPTAPI'
/*     */     //   430: ldc_w 'AVM switch Get EVS server binder is ok'
/*     */     //   433: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   436: pop
/*     */     //   437: aload #4
/*     */     //   439: invokestatic asInterface : (Landroid/os/IBinder;)Lcom/android/evs/IEvsCameraService;
/*     */     //   442: astore #4
/*     */     //   444: aload #4
/*     */     //   446: ifnull -> 487
/*     */     //   449: ldc 'PAS_ADAPTAPI'
/*     */     //   451: ldc_w 'AVM switch mIECS is not null'
/*     */     //   454: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   457: pop
/*     */     //   458: ldc 'PAS_ADAPTAPI'
/*     */     //   460: ldc_w 'By binder call EVS server setAVMPropertyOn'
/*     */     //   463: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   466: pop
/*     */     //   467: aload #4
/*     */     //   469: invokeinterface setAVMPropertyOn : ()V
/*     */     //   474: goto -> 484
/*     */     //   477: astore #4
/*     */     //   479: aload #4
/*     */     //   481: invokevirtual printStackTrace : ()V
/*     */     //   484: goto -> 496
/*     */     //   487: ldc 'PAS_ADAPTAPI'
/*     */     //   489: ldc_w 'AVM switch mIECS is null'
/*     */     //   492: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   495: pop
/*     */     //   496: goto -> 646
/*     */     //   499: iload_2
/*     */     //   500: iconst_2
/*     */     //   501: if_icmpne -> 706
/*     */     //   504: ldc 'PAS_ADAPTAPI'
/*     */     //   506: ldc_w '内置AVM'
/*     */     //   509: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   512: pop
/*     */     //   513: new java/lang/StringBuilder
/*     */     //   516: astore #4
/*     */     //   518: aload #4
/*     */     //   520: invokespecial <init> : ()V
/*     */     //   523: aload #4
/*     */     //   525: ldc_w 'the request onOff1 is '
/*     */     //   528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   531: pop
/*     */     //   532: aload #4
/*     */     //   534: iload_1
/*     */     //   535: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   538: pop
/*     */     //   539: ldc 'PAS_ADAPTAPI'
/*     */     //   541: aload #4
/*     */     //   543: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   546: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   549: pop
/*     */     //   550: iload_1
/*     */     //   551: iconst_1
/*     */     //   552: if_icmpne -> 627
/*     */     //   555: ldc 'PAS_ADAPTAPI'
/*     */     //   557: ldc_w 'startAVM'
/*     */     //   560: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   563: pop
/*     */     //   564: aload_0
/*     */     //   565: getfield mPasService : Lecarx/pas/IPasService;
/*     */     //   568: iconst_1
/*     */     //   569: invokeinterface startOrStopAvm : (I)V
/*     */     //   574: goto -> 646
/*     */     //   577: astore #4
/*     */     //   579: new java/lang/StringBuilder
/*     */     //   582: astore #5
/*     */     //   584: aload #5
/*     */     //   586: invokespecial <init> : ()V
/*     */     //   589: aload #5
/*     */     //   591: ldc_w 'startOrStopAvm failed '
/*     */     //   594: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   597: pop
/*     */     //   598: aload #5
/*     */     //   600: aload #4
/*     */     //   602: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   605: pop
/*     */     //   606: ldc 'PAS_ADAPTAPI'
/*     */     //   608: aload #5
/*     */     //   610: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   613: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   616: pop
/*     */     //   617: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   620: astore #4
/*     */     //   622: aload_0
/*     */     //   623: monitorexit
/*     */     //   624: aload #4
/*     */     //   626: areturn
/*     */     //   627: ldc 'PAS_ADAPTAPI'
/*     */     //   629: ldc_w 'stopAVM'
/*     */     //   632: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   635: pop
/*     */     //   636: aload_0
/*     */     //   637: getfield mPasService : Lecarx/pas/IPasService;
/*     */     //   640: iconst_0
/*     */     //   641: invokeinterface startOrStopAvm : (I)V
/*     */     //   646: getstatic ecarx/car/hardware/annotation/ApiResult.SUCCEED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   649: astore #4
/*     */     //   651: aload_0
/*     */     //   652: monitorexit
/*     */     //   653: aload #4
/*     */     //   655: areturn
/*     */     //   656: astore #4
/*     */     //   658: new java/lang/StringBuilder
/*     */     //   661: astore #5
/*     */     //   663: aload #5
/*     */     //   665: invokespecial <init> : ()V
/*     */     //   668: aload #5
/*     */     //   670: ldc_w 'startOrStopAvm failed '
/*     */     //   673: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   676: pop
/*     */     //   677: aload #5
/*     */     //   679: aload #4
/*     */     //   681: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   684: pop
/*     */     //   685: ldc 'PAS_ADAPTAPI'
/*     */     //   687: aload #5
/*     */     //   689: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   692: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   695: pop
/*     */     //   696: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   699: astore #4
/*     */     //   701: aload_0
/*     */     //   702: monitorexit
/*     */     //   703: aload #4
/*     */     //   705: areturn
/*     */     //   706: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   709: astore #4
/*     */     //   711: aload_0
/*     */     //   712: monitorexit
/*     */     //   713: aload #4
/*     */     //   715: areturn
/*     */     //   716: astore #4
/*     */     //   718: aload_0
/*     */     //   719: monitorexit
/*     */     //   720: aload #4
/*     */     //   722: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #443	-> 2
/*     */     //   #444	-> 10
/*     */     //   #445	-> 12
/*     */     //   #455	-> 71
/*     */     //   #456	-> 73
/*     */     //   #452	-> 76
/*     */     //   #453	-> 78
/*     */     //   #463	-> 78
/*     */     //   #466	-> 161
/*     */     //   #468	-> 166
/*     */     //   #469	-> 174
/*     */     //   #470	-> 181
/*     */     //   #471	-> 186
/*     */     //   #472	-> 245
/*     */     //   #474	-> 255
/*     */     //   #477	-> 306
/*     */     //   #478	-> 313
/*     */     //   #479	-> 321
/*     */     //   #481	-> 331
/*     */     //   #482	-> 338
/*     */     //   #483	-> 346
/*     */     //   #484	-> 357
/*     */     //   #485	-> 364
/*     */     //   #486	-> 372
/*     */     //   #489	-> 382
/*     */     //   #490	-> 391
/*     */     //   #491	-> 400
/*     */     //   #493	-> 405
/*     */     //   #494	-> 412
/*     */     //   #495	-> 417
/*     */     //   #497	-> 428
/*     */     //   #499	-> 437
/*     */     //   #500	-> 444
/*     */     //   #501	-> 449
/*     */     //   #503	-> 458
/*     */     //   #504	-> 467
/*     */     //   #505	-> 477
/*     */     //   #507	-> 479
/*     */     //   #508	-> 484
/*     */     //   #510	-> 487
/*     */     //   #514	-> 496
/*     */     //   #516	-> 504
/*     */     //   #517	-> 513
/*     */     //   #523	-> 550
/*     */     //   #524	-> 555
/*     */     //   #526	-> 564
/*     */     //   #530	-> 574
/*     */     //   #527	-> 577
/*     */     //   #528	-> 579
/*     */     //   #529	-> 617
/*     */     //   #532	-> 627
/*     */     //   #534	-> 636
/*     */     //   #538	-> 646
/*     */     //   #545	-> 646
/*     */     //   #535	-> 656
/*     */     //   #536	-> 658
/*     */     //   #537	-> 696
/*     */     //   #542	-> 706
/*     */     //   #442	-> 716
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	10	716	finally
/*     */     //   78	126	716	finally
/*     */     //   142	161	716	finally
/*     */     //   166	174	716	finally
/*     */     //   174	181	716	finally
/*     */     //   186	245	716	finally
/*     */     //   245	250	716	finally
/*     */     //   255	306	716	finally
/*     */     //   306	313	716	finally
/*     */     //   313	321	716	finally
/*     */     //   321	326	716	finally
/*     */     //   331	338	716	finally
/*     */     //   338	346	716	finally
/*     */     //   346	357	716	finally
/*     */     //   357	364	716	finally
/*     */     //   364	372	716	finally
/*     */     //   372	377	716	finally
/*     */     //   382	391	716	finally
/*     */     //   391	400	716	finally
/*     */     //   405	412	716	finally
/*     */     //   417	425	716	finally
/*     */     //   428	437	716	finally
/*     */     //   437	444	716	finally
/*     */     //   449	458	716	finally
/*     */     //   458	467	477	android/os/RemoteException
/*     */     //   458	467	716	finally
/*     */     //   467	474	477	android/os/RemoteException
/*     */     //   467	474	716	finally
/*     */     //   479	484	716	finally
/*     */     //   487	496	716	finally
/*     */     //   504	513	716	finally
/*     */     //   513	550	716	finally
/*     */     //   555	564	716	finally
/*     */     //   564	574	577	android/os/RemoteException
/*     */     //   564	574	716	finally
/*     */     //   579	617	716	finally
/*     */     //   617	622	716	finally
/*     */     //   627	636	716	finally
/*     */     //   636	646	656	android/os/RemoteException
/*     */     //   636	646	716	finally
/*     */     //   646	651	716	finally
/*     */     //   658	696	716	finally
/*     */     //   696	701	716	finally
/*     */     //   706	711	716	finally }
/*     */   private ApiResult pdcSettingSwitch(int paramInt) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: new java/lang/StringBuilder
/*     */     //   5: astore_2
/*     */     //   6: aload_2
/*     */     //   7: invokespecial <init> : ()V
/*     */     //   10: aload_2
/*     */     //   11: ldc_w 'pdc setting switch the request onOff1 is '
/*     */     //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   17: pop
/*     */     //   18: aload_2
/*     */     //   19: iload_1
/*     */     //   20: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   23: pop
/*     */     //   24: ldc 'PAS_ADAPTAPI'
/*     */     //   26: aload_2
/*     */     //   27: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   30: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   33: pop
/*     */     //   34: aload_0
/*     */     //   35: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   38: ifnonnull -> 83
/*     */     //   41: ldc 'PAS_ADAPTAPI'
/*     */     //   43: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   45: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   48: pop
/*     */     //   49: aload_0
/*     */     //   50: aload_0
/*     */     //   51: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   54: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   57: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   60: aload_0
/*     */     //   61: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   64: ifnonnull -> 83
/*     */     //   67: ldc 'PAS_ADAPTAPI'
/*     */     //   69: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   71: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   74: pop
/*     */     //   75: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   78: astore_2
/*     */     //   79: aload_0
/*     */     //   80: monitorexit
/*     */     //   81: aload_2
/*     */     //   82: areturn
/*     */     //   83: aload_0
/*     */     //   84: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   87: iconst_1
/*     */     //   88: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   91: pop
/*     */     //   92: aload_0
/*     */     //   93: invokespecial isHighPDC : ()Z
/*     */     //   96: ifeq -> 111
/*     */     //   99: aload_0
/*     */     //   100: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   103: iconst_1
/*     */     //   104: invokevirtual setPrkgDstCtrlSysSwt : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   107: pop
/*     */     //   108: goto -> 120
/*     */     //   111: aload_0
/*     */     //   112: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   115: iconst_1
/*     */     //   116: invokevirtual setPrkgDstCtrlLoSysSwt : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   119: pop
/*     */     //   120: getstatic ecarx/car/hardware/annotation/ApiResult.SUCCEED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   123: astore_2
/*     */     //   124: aload_0
/*     */     //   125: monitorexit
/*     */     //   126: aload_2
/*     */     //   127: areturn
/*     */     //   128: astore_2
/*     */     //   129: aload_0
/*     */     //   130: monitorexit
/*     */     //   131: aload_2
/*     */     //   132: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #549	-> 2
/*     */     //   #550	-> 34
/*     */     //   #551	-> 41
/*     */     //   #552	-> 49
/*     */     //   #553	-> 60
/*     */     //   #554	-> 67
/*     */     //   #555	-> 75
/*     */     //   #558	-> 83
/*     */     //   #559	-> 92
/*     */     //   #560	-> 99
/*     */     //   #562	-> 111
/*     */     //   #564	-> 120
/*     */     //   #548	-> 128
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	34	128	finally
/*     */     //   34	41	128	finally
/*     */     //   41	49	128	finally
/*     */     //   49	60	128	finally
/*     */     //   60	67	128	finally
/*     */     //   67	75	128	finally
/*     */     //   75	79	128	finally
/*     */     //   83	92	128	finally
/*     */     //   92	99	128	finally
/*     */     //   99	108	128	finally
/*     */     //   111	120	128	finally
/*     */     //   120	124	128	finally }
/*     */   private ApiResult rpaSettingSwitch(int paramInt) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: new java/lang/StringBuilder
/*     */     //   5: astore_2
/*     */     //   6: aload_2
/*     */     //   7: invokespecial <init> : ()V
/*     */     //   10: aload_2
/*     */     //   11: ldc_w 'rpa setting switch the request onOff1 is '
/*     */     //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   17: pop
/*     */     //   18: aload_2
/*     */     //   19: iload_1
/*     */     //   20: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   23: pop
/*     */     //   24: ldc 'PAS_ADAPTAPI'
/*     */     //   26: aload_2
/*     */     //   27: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   30: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   33: pop
/*     */     //   34: aload_0
/*     */     //   35: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   38: ifnonnull -> 83
/*     */     //   41: ldc 'PAS_ADAPTAPI'
/*     */     //   43: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   45: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   48: pop
/*     */     //   49: aload_0
/*     */     //   50: aload_0
/*     */     //   51: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   54: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   57: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   60: aload_0
/*     */     //   61: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   64: ifnonnull -> 83
/*     */     //   67: ldc 'PAS_ADAPTAPI'
/*     */     //   69: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   71: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   74: pop
/*     */     //   75: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   78: astore_2
/*     */     //   79: aload_0
/*     */     //   80: monitorexit
/*     */     //   81: aload_2
/*     */     //   82: areturn
/*     */     //   83: aload_0
/*     */     //   84: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   87: iconst_1
/*     */     //   88: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   91: pop
/*     */     //   92: aload_0
/*     */     //   93: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   96: iconst_1
/*     */     //   97: invokevirtual setRemPrkgEnaReq : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   100: pop
/*     */     //   101: getstatic ecarx/car/hardware/annotation/ApiResult.SUCCEED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   104: astore_2
/*     */     //   105: aload_0
/*     */     //   106: monitorexit
/*     */     //   107: aload_2
/*     */     //   108: areturn
/*     */     //   109: astore_2
/*     */     //   110: aload_0
/*     */     //   111: monitorexit
/*     */     //   112: aload_2
/*     */     //   113: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #568	-> 2
/*     */     //   #569	-> 34
/*     */     //   #570	-> 41
/*     */     //   #571	-> 49
/*     */     //   #572	-> 60
/*     */     //   #573	-> 67
/*     */     //   #574	-> 75
/*     */     //   #577	-> 83
/*     */     //   #578	-> 92
/*     */     //   #580	-> 101
/*     */     //   #567	-> 109
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	34	109	finally
/*     */     //   34	41	109	finally
/*     */     //   41	49	109	finally
/*     */     //   49	60	109	finally
/*     */     //   60	67	109	finally
/*     */     //   67	75	109	finally
/*     */     //   75	79	109	finally
/*     */     //   83	92	109	finally
/*     */     //   92	101	109	finally
/*     */     //   101	105	109	finally }
/*     */   private ApiResult apaSettingSwitch(int paramInt) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: new java/lang/StringBuilder
/*     */     //   5: astore_2
/*     */     //   6: aload_2
/*     */     //   7: invokespecial <init> : ()V
/*     */     //   10: aload_2
/*     */     //   11: ldc 'apa setting switch the request onOff1 is '
/*     */     //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   16: pop
/*     */     //   17: aload_2
/*     */     //   18: iload_1
/*     */     //   19: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   22: pop
/*     */     //   23: ldc 'PAS_ADAPTAPI'
/*     */     //   25: aload_2
/*     */     //   26: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   29: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   32: pop
/*     */     //   33: aload_0
/*     */     //   34: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   37: ifnonnull -> 82
/*     */     //   40: ldc 'PAS_ADAPTAPI'
/*     */     //   42: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   44: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   47: pop
/*     */     //   48: aload_0
/*     */     //   49: aload_0
/*     */     //   50: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   53: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   56: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   59: aload_0
/*     */     //   60: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   63: ifnonnull -> 82
/*     */     //   66: ldc 'PAS_ADAPTAPI'
/*     */     //   68: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   70: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   73: pop
/*     */     //   74: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   77: astore_2
/*     */     //   78: aload_0
/*     */     //   79: monitorexit
/*     */     //   80: aload_2
/*     */     //   81: areturn
/*     */     //   82: aload_0
/*     */     //   83: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   86: iconst_1
/*     */     //   87: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   90: pop
/*     */     //   91: aload_0
/*     */     //   92: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   95: iconst_1
/*     */     //   96: invokevirtual setPrkgTypAutBtn : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   99: pop
/*     */     //   100: getstatic ecarx/car/hardware/annotation/ApiResult.SUCCEED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   103: astore_2
/*     */     //   104: aload_0
/*     */     //   105: monitorexit
/*     */     //   106: aload_2
/*     */     //   107: areturn
/*     */     //   108: astore_2
/*     */     //   109: aload_0
/*     */     //   110: monitorexit
/*     */     //   111: aload_2
/*     */     //   112: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #584	-> 2
/*     */     //   #585	-> 33
/*     */     //   #586	-> 40
/*     */     //   #587	-> 48
/*     */     //   #588	-> 59
/*     */     //   #589	-> 66
/*     */     //   #590	-> 74
/*     */     //   #593	-> 82
/*     */     //   #594	-> 91
/*     */     //   #596	-> 100
/*     */     //   #583	-> 108
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	33	108	finally
/*     */     //   33	40	108	finally
/*     */     //   40	48	108	finally
/*     */     //   48	59	108	finally
/*     */     //   59	66	108	finally
/*     */     //   66	74	108	finally
/*     */     //   74	78	108	finally
/*     */     //   82	91	108	finally
/*     */     //   91	100	108	finally
/*     */     //   100	104	108	finally }
/*     */   private ApiResult apaSwitch(int paramInt) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: ldc 'vendor.sys.apaon'
/*     */     //   4: iconst_0
/*     */     //   5: invokestatic getInt : (Ljava/lang/String;I)I
/*     */     //   8: istore_2
/*     */     //   9: new java/lang/StringBuilder
/*     */     //   12: astore_3
/*     */     //   13: aload_3
/*     */     //   14: invokespecial <init> : ()V
/*     */     //   17: aload_3
/*     */     //   18: ldc 'isApaOn is '
/*     */     //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   23: pop
/*     */     //   24: aload_3
/*     */     //   25: iload_2
/*     */     //   26: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   29: pop
/*     */     //   30: aload_3
/*     */     //   31: ldc ' ,  the request onOff1 is '
/*     */     //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   36: pop
/*     */     //   37: aload_3
/*     */     //   38: iload_1
/*     */     //   39: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   42: pop
/*     */     //   43: ldc 'PAS_ADAPTAPI'
/*     */     //   45: aload_3
/*     */     //   46: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   49: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   52: pop
/*     */     //   53: aload_0
/*     */     //   54: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   57: ifnonnull -> 76
/*     */     //   60: ldc 'PAS_ADAPTAPI'
/*     */     //   62: ldc 'apaSwitch mCarSignalManager is null, cannot request'
/*     */     //   64: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   67: pop
/*     */     //   68: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   71: astore_3
/*     */     //   72: aload_0
/*     */     //   73: monitorexit
/*     */     //   74: aload_3
/*     */     //   75: areturn
/*     */     //   76: iload_1
/*     */     //   77: iconst_1
/*     */     //   78: if_icmpne -> 231
/*     */     //   81: aload_0
/*     */     //   82: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   85: ifnonnull -> 130
/*     */     //   88: ldc 'PAS_ADAPTAPI'
/*     */     //   90: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   92: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   95: pop
/*     */     //   96: aload_0
/*     */     //   97: aload_0
/*     */     //   98: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   101: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   104: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   107: aload_0
/*     */     //   108: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   111: ifnonnull -> 130
/*     */     //   114: ldc 'PAS_ADAPTAPI'
/*     */     //   116: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   118: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   121: pop
/*     */     //   122: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   125: astore_3
/*     */     //   126: aload_0
/*     */     //   127: monitorexit
/*     */     //   128: aload_3
/*     */     //   129: areturn
/*     */     //   130: aload_0
/*     */     //   131: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   134: iconst_1
/*     */     //   135: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   138: pop
/*     */     //   139: aload_0
/*     */     //   140: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   143: bipush #9
/*     */     //   145: invokevirtual setDrvrAsscSysBtnPush : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   148: pop
/*     */     //   149: ldc 'EvsCameraService'
/*     */     //   151: invokestatic getService : (Ljava/lang/String;)Landroid/os/IBinder;
/*     */     //   154: astore_3
/*     */     //   155: aload_3
/*     */     //   156: ifnonnull -> 170
/*     */     //   159: ldc 'PAS_ADAPTAPI'
/*     */     //   161: ldc 'APA switch Get EVS server binder is null'
/*     */     //   163: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   166: pop
/*     */     //   167: goto -> 178
/*     */     //   170: ldc 'PAS_ADAPTAPI'
/*     */     //   172: ldc 'APA switch Get EVS server binder is ok'
/*     */     //   174: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   177: pop
/*     */     //   178: aload_3
/*     */     //   179: invokestatic asInterface : (Landroid/os/IBinder;)Lcom/android/evs/IEvsCameraService;
/*     */     //   182: astore_3
/*     */     //   183: aload_3
/*     */     //   184: ifnull -> 220
/*     */     //   187: ldc 'PAS_ADAPTAPI'
/*     */     //   189: ldc 'APA switch mIECS is not null'
/*     */     //   191: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   194: pop
/*     */     //   195: ldc 'PAS_ADAPTAPI'
/*     */     //   197: ldc 'By binder call EVS server setAPAPropertyOn'
/*     */     //   199: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   202: pop
/*     */     //   203: aload_3
/*     */     //   204: invokeinterface setAPAPropertyOn : ()V
/*     */     //   209: goto -> 217
/*     */     //   212: astore_3
/*     */     //   213: aload_3
/*     */     //   214: invokevirtual printStackTrace : ()V
/*     */     //   217: goto -> 228
/*     */     //   220: ldc 'PAS_ADAPTAPI'
/*     */     //   222: ldc 'APA switch mIECS is null'
/*     */     //   224: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   227: pop
/*     */     //   228: goto -> 298
/*     */     //   231: aload_0
/*     */     //   232: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   235: ifnonnull -> 280
/*     */     //   238: ldc 'PAS_ADAPTAPI'
/*     */     //   240: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   242: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   245: pop
/*     */     //   246: aload_0
/*     */     //   247: aload_0
/*     */     //   248: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   251: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   254: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   257: aload_0
/*     */     //   258: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   261: ifnonnull -> 280
/*     */     //   264: ldc 'PAS_ADAPTAPI'
/*     */     //   266: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   268: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   271: pop
/*     */     //   272: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   275: astore_3
/*     */     //   276: aload_0
/*     */     //   277: monitorexit
/*     */     //   278: aload_3
/*     */     //   279: areturn
/*     */     //   280: aload_0
/*     */     //   281: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   284: iconst_1
/*     */     //   285: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   288: pop
/*     */     //   289: aload_0
/*     */     //   290: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   293: iconst_5
/*     */     //   294: invokevirtual setDrvrAsscSysBtnPush : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   297: pop
/*     */     //   298: getstatic ecarx/car/hardware/annotation/ApiResult.SUCCEED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   301: astore_3
/*     */     //   302: aload_0
/*     */     //   303: monitorexit
/*     */     //   304: aload_3
/*     */     //   305: areturn
/*     */     //   306: astore_3
/*     */     //   307: aload_0
/*     */     //   308: monitorexit
/*     */     //   309: aload_3
/*     */     //   310: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #600	-> 2
/*     */     //   #605	-> 9
/*     */     //   #608	-> 53
/*     */     //   #609	-> 60
/*     */     //   #610	-> 68
/*     */     //   #613	-> 76
/*     */     //   #614	-> 81
/*     */     //   #615	-> 88
/*     */     //   #616	-> 96
/*     */     //   #617	-> 107
/*     */     //   #618	-> 114
/*     */     //   #619	-> 122
/*     */     //   #622	-> 130
/*     */     //   #623	-> 139
/*     */     //   #626	-> 149
/*     */     //   #627	-> 155
/*     */     //   #628	-> 159
/*     */     //   #630	-> 170
/*     */     //   #632	-> 178
/*     */     //   #633	-> 183
/*     */     //   #634	-> 187
/*     */     //   #636	-> 195
/*     */     //   #637	-> 203
/*     */     //   #638	-> 212
/*     */     //   #640	-> 213
/*     */     //   #641	-> 217
/*     */     //   #643	-> 220
/*     */     //   #645	-> 228
/*     */     //   #646	-> 231
/*     */     //   #647	-> 238
/*     */     //   #648	-> 246
/*     */     //   #649	-> 257
/*     */     //   #650	-> 264
/*     */     //   #651	-> 272
/*     */     //   #654	-> 280
/*     */     //   #655	-> 289
/*     */     //   #658	-> 298
/*     */     //   #599	-> 306
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	9	306	finally
/*     */     //   9	53	306	finally
/*     */     //   53	60	306	finally
/*     */     //   60	68	306	finally
/*     */     //   68	72	306	finally
/*     */     //   81	88	306	finally
/*     */     //   88	96	306	finally
/*     */     //   96	107	306	finally
/*     */     //   107	114	306	finally
/*     */     //   114	122	306	finally
/*     */     //   122	126	306	finally
/*     */     //   130	139	306	finally
/*     */     //   139	149	306	finally
/*     */     //   149	155	306	finally
/*     */     //   159	167	306	finally
/*     */     //   170	178	306	finally
/*     */     //   178	183	306	finally
/*     */     //   187	195	306	finally
/*     */     //   195	203	212	android/os/RemoteException
/*     */     //   195	203	306	finally
/*     */     //   203	209	212	android/os/RemoteException
/*     */     //   203	209	306	finally
/*     */     //   213	217	306	finally
/*     */     //   220	228	306	finally
/*     */     //   231	238	306	finally
/*     */     //   238	246	306	finally
/*     */     //   246	257	306	finally
/*     */     //   257	264	306	finally
/*     */     //   264	272	306	finally
/*     */     //   272	276	306	finally
/*     */     //   280	289	306	finally
/*     */     //   289	298	306	finally
/*     */     //   298	302	306	finally }
/*     */   private ApiResult avpSwitch(int paramInt) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: ldc_w 'persist.sys.avpon'
/*     */     //   5: iconst_0
/*     */     //   6: invokestatic getInt : (Ljava/lang/String;I)I
/*     */     //   9: istore_2
/*     */     //   10: new java/lang/StringBuilder
/*     */     //   13: astore_3
/*     */     //   14: aload_3
/*     */     //   15: invokespecial <init> : ()V
/*     */     //   18: aload_3
/*     */     //   19: ldc_w 'isAvpOn is '
/*     */     //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   25: pop
/*     */     //   26: aload_3
/*     */     //   27: iload_2
/*     */     //   28: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   31: pop
/*     */     //   32: aload_3
/*     */     //   33: ldc ' ,  the request onOff1 is '
/*     */     //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   38: pop
/*     */     //   39: aload_3
/*     */     //   40: iload_1
/*     */     //   41: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   44: pop
/*     */     //   45: ldc 'PAS_ADAPTAPI'
/*     */     //   47: aload_3
/*     */     //   48: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   51: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   54: pop
/*     */     //   55: aload_0
/*     */     //   56: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   59: ifnonnull -> 79
/*     */     //   62: ldc 'PAS_ADAPTAPI'
/*     */     //   64: ldc_w 'avpSwitch mCarSignalManager is null, cannot request'
/*     */     //   67: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   70: pop
/*     */     //   71: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   74: astore_3
/*     */     //   75: aload_0
/*     */     //   76: monitorexit
/*     */     //   77: aload_3
/*     */     //   78: areturn
/*     */     //   79: iload_1
/*     */     //   80: iconst_1
/*     */     //   81: if_icmpne -> 238
/*     */     //   84: aload_0
/*     */     //   85: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   88: ifnonnull -> 133
/*     */     //   91: ldc 'PAS_ADAPTAPI'
/*     */     //   93: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   95: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   98: pop
/*     */     //   99: aload_0
/*     */     //   100: aload_0
/*     */     //   101: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   104: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   107: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   110: aload_0
/*     */     //   111: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   114: ifnonnull -> 133
/*     */     //   117: ldc 'PAS_ADAPTAPI'
/*     */     //   119: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   121: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   124: pop
/*     */     //   125: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   128: astore_3
/*     */     //   129: aload_0
/*     */     //   130: monitorexit
/*     */     //   131: aload_3
/*     */     //   132: areturn
/*     */     //   133: aload_0
/*     */     //   134: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   137: iconst_1
/*     */     //   138: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   141: pop
/*     */     //   142: aload_0
/*     */     //   143: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   146: iconst_1
/*     */     //   147: invokevirtual setAutValtPrkgSwt : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   150: pop
/*     */     //   151: ldc 'EvsCameraService'
/*     */     //   153: invokestatic getService : (Ljava/lang/String;)Landroid/os/IBinder;
/*     */     //   156: astore_3
/*     */     //   157: aload_3
/*     */     //   158: ifnonnull -> 173
/*     */     //   161: ldc 'PAS_ADAPTAPI'
/*     */     //   163: ldc_w 'AVP switch Get EVS server binder is null'
/*     */     //   166: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   169: pop
/*     */     //   170: goto -> 182
/*     */     //   173: ldc 'PAS_ADAPTAPI'
/*     */     //   175: ldc_w 'AVP switch Get EVS server binder is ok'
/*     */     //   178: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   181: pop
/*     */     //   182: aload_3
/*     */     //   183: invokestatic asInterface : (Landroid/os/IBinder;)Lcom/android/evs/IEvsCameraService;
/*     */     //   186: astore_3
/*     */     //   187: aload_3
/*     */     //   188: ifnull -> 226
/*     */     //   191: ldc 'PAS_ADAPTAPI'
/*     */     //   193: ldc_w 'AVP switch mIECS is not null'
/*     */     //   196: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   199: pop
/*     */     //   200: ldc 'PAS_ADAPTAPI'
/*     */     //   202: ldc_w 'By binder call EVS server setAVPPropertyOn'
/*     */     //   205: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   208: pop
/*     */     //   209: aload_3
/*     */     //   210: invokeinterface setAVPPropertyOn : ()V
/*     */     //   215: goto -> 223
/*     */     //   218: astore_3
/*     */     //   219: aload_3
/*     */     //   220: invokevirtual printStackTrace : ()V
/*     */     //   223: goto -> 235
/*     */     //   226: ldc 'PAS_ADAPTAPI'
/*     */     //   228: ldc_w 'AVP switch mIECS is null'
/*     */     //   231: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   234: pop
/*     */     //   235: goto -> 305
/*     */     //   238: aload_0
/*     */     //   239: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   242: ifnonnull -> 287
/*     */     //   245: ldc 'PAS_ADAPTAPI'
/*     */     //   247: ldc 'vfcManager is null, get vfcManager object once!'
/*     */     //   249: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   252: pop
/*     */     //   253: aload_0
/*     */     //   254: aload_0
/*     */     //   255: getfield mECarXCarSetManager : Lecarx/car/hardware/vehicle/ECarXCarSetManager;
/*     */     //   258: invokevirtual getECarXCarVfcipwakeupManager : ()Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   261: putfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   264: aload_0
/*     */     //   265: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   268: ifnonnull -> 287
/*     */     //   271: ldc 'PAS_ADAPTAPI'
/*     */     //   273: ldc 'Reget vfcManager object is null, return failed!'
/*     */     //   275: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   278: pop
/*     */     //   279: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   282: astore_3
/*     */     //   283: aload_0
/*     */     //   284: monitorexit
/*     */     //   285: aload_3
/*     */     //   286: areturn
/*     */     //   287: aload_0
/*     */     //   288: getfield vfcManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*     */     //   291: iconst_1
/*     */     //   292: invokevirtual CB_VFC_ParkAssiCtrlForHmiCen : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   295: pop
/*     */     //   296: aload_0
/*     */     //   297: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   300: iconst_2
/*     */     //   301: invokevirtual setAutValtPrkgSwt : (I)Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   304: pop
/*     */     //   305: getstatic ecarx/car/hardware/annotation/ApiResult.SUCCEED : Lecarx/car/hardware/annotation/ApiResult;
/*     */     //   308: astore_3
/*     */     //   309: aload_0
/*     */     //   310: monitorexit
/*     */     //   311: aload_3
/*     */     //   312: areturn
/*     */     //   313: astore_3
/*     */     //   314: aload_0
/*     */     //   315: monitorexit
/*     */     //   316: aload_3
/*     */     //   317: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #662	-> 2
/*     */     //   #667	-> 10
/*     */     //   #670	-> 55
/*     */     //   #671	-> 62
/*     */     //   #672	-> 71
/*     */     //   #675	-> 79
/*     */     //   #676	-> 84
/*     */     //   #677	-> 91
/*     */     //   #678	-> 99
/*     */     //   #679	-> 110
/*     */     //   #680	-> 117
/*     */     //   #681	-> 125
/*     */     //   #684	-> 133
/*     */     //   #685	-> 142
/*     */     //   #688	-> 151
/*     */     //   #689	-> 157
/*     */     //   #690	-> 161
/*     */     //   #692	-> 173
/*     */     //   #694	-> 182
/*     */     //   #695	-> 187
/*     */     //   #696	-> 191
/*     */     //   #698	-> 200
/*     */     //   #699	-> 209
/*     */     //   #700	-> 218
/*     */     //   #702	-> 219
/*     */     //   #703	-> 223
/*     */     //   #705	-> 226
/*     */     //   #707	-> 235
/*     */     //   #708	-> 238
/*     */     //   #709	-> 245
/*     */     //   #710	-> 253
/*     */     //   #711	-> 264
/*     */     //   #712	-> 271
/*     */     //   #713	-> 279
/*     */     //   #716	-> 287
/*     */     //   #717	-> 296
/*     */     //   #720	-> 305
/*     */     //   #661	-> 313
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	10	313	finally
/*     */     //   10	55	313	finally
/*     */     //   55	62	313	finally
/*     */     //   62	71	313	finally
/*     */     //   71	75	313	finally
/*     */     //   84	91	313	finally
/*     */     //   91	99	313	finally
/*     */     //   99	110	313	finally
/*     */     //   110	117	313	finally
/*     */     //   117	125	313	finally
/*     */     //   125	129	313	finally
/*     */     //   133	142	313	finally
/*     */     //   142	151	313	finally
/*     */     //   151	157	313	finally
/*     */     //   161	170	313	finally
/*     */     //   173	182	313	finally
/*     */     //   182	187	313	finally
/*     */     //   191	200	313	finally
/*     */     //   200	209	218	android/os/RemoteException
/*     */     //   200	209	313	finally
/*     */     //   209	215	218	android/os/RemoteException
/*     */     //   209	215	313	finally
/*     */     //   219	223	313	finally
/*     */     //   226	235	313	finally
/*     */     //   238	245	313	finally
/*     */     //   245	253	313	finally
/*     */     //   253	264	313	finally
/*     */     //   264	271	313	finally
/*     */     //   271	279	313	finally
/*     */     //   279	283	313	finally
/*     */     //   287	296	313	finally
/*     */     //   296	305	313	finally
/*     */     //   305	309	313	finally }
/*     */   private FunctionStatus getAVMEffect() { Log.d("PAS_ADAPTAPI", "Into getAVMEffect func"); int i = getSignalValue(29394); if (i != 3 && i != 6 && i != 130 && i != 132 && i != 134) switch (i) { default: Log.e("PAS_ADAPTAPI", "Into getAVMEffect func is notavailable"); return FunctionStatus.notavailable;case 11: case 12: break; }   if (usageModeAnyMatch(new int[] { 2, 11, 13 })) if (carModeAnyMatch(new int[] { 0, 5, 3 })) { Log.d("PAS_ADAPTAPI", "Into getAVMEffect func is active"); return FunctionStatus.active; }   Log.e("PAS_ADAPTAPI", "Into getAVMEffect func is notactive"); return FunctionStatus.notactive; }
/*     */   private FunctionStatus getAPAEffect() { Log.d("PAS_ADAPTAPI", "Into getAPAEffect func"); int i = getSignalValue(29386); switch (i) { default: Log.e("PAS_ADAPTAPI", "Into getAPAEffect func is notavailable"); return FunctionStatus.notavailable;case 128: case 129: case 130: case 131: case 132: break; }  if (usageModeAnyMatch(new int[] { 13 }) && carModeAnyMatch(new int[] { 0 })) { Log.d("PAS_ADAPTAPI", "Into getAPAEffect func is active"); return FunctionStatus.active; }  Log.e("PAS_ADAPTAPI", "Into getAPAEffect func is notactive"); return FunctionStatus.notactive; }
/*     */   private FunctionStatus getAVPEffect() { Log.d("PAS_ADAPTAPI", "Into getAVPEffect func"); int i = getSignalValue(29386); if (i != 131) { Log.e("PAS_ADAPTAPI", "Into getAVPEffect func is notavailable"); return FunctionStatus.notavailable; }  if (usageModeAnyMatch(new int[] { 13 }) && carModeAnyMatch(new int[] { 0 })) { Log.d("PAS_ADAPTAPI", "Into getAVPEffect func is active"); return FunctionStatus.active; }  Log.e("PAS_ADAPTAPI", "Into getAVPEffect func is notactive"); return FunctionStatus.notactive; }
/*     */   private ApiResult setPDCWarning(int paramInt) { if (this.mEcarxAudioManager != null) { if (this.vfcManager == null) { Log.e("PAS_ADAPTAPI", "vfcManager is null, get vfcManager object once!"); this.vfcManager = this.mECarXCarSetManager.getECarXCarVfcipwakeupManager(); if (this.vfcManager == null) { Log.e("PAS_ADAPTAPI", "Reget vfcManager object is null, return failed!"); return ApiResult.FAILED; }  }  this.vfcManager.CB_VFC_ParkAssiCtrlForHmiCen(1); this.mEcarxAudioManager.setPDCWarning(paramInt); return ApiResult.SUCCEED; }  return ApiResult.FAILED; }
/*     */   private boolean isHighPDC() { Log.d("PAS_ADAPTAPI", "Into isHighPDC func"); int i = getSignalValue(29394); boolean bool = false; if (i != 3 && i != 6 && i != 130 && i != 132) { StringBuilder stringBuilder1; switch (i) { default: stringBuilder1 = new StringBuilder(); stringBuilder1.append("Into isHighPDC default is carconfig154: "); stringBuilder1.append(i); Log.d("PAS_ADAPTAPI", stringBuilder1.toString()); return bool;case 11: case 12: break; }  }  bool = true; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Into isHighPDC carconfig154: "); stringBuilder.append(i); Log.d("PAS_ADAPTAPI", stringBuilder.toString()); return bool; }
/*     */   private FunctionStatus getPDCEffect() { Log.d("PAS_ADAPTAPI", "Into getPDCEffect func"); int i = getSignalValue(29386); if (i != 3) { switch (i) { default: Log.e("PAS_ADAPTAPI", "Into getPDCEffect func is notavailable"); return FunctionStatus.notavailable;case 128: case 129: case 130: case 131: case 132: break; }  if (usageModeAnyMatch(new int[] { 1, 2, 11, 13 })) if (carModeAnyMatch(new int[] { 0 })) { Log.d("PAS_ADAPTAPI", "Into getPDCEffect func is active"); return FunctionStatus.active; }   Log.e("PAS_ADAPTAPI", "Into getPDCEffect func is notactive"); return FunctionStatus.notactive; }  if (usageModeAnyMatch(new int[] { 13 }) && carModeAnyMatch(new int[] { 0 })) { Log.d("PAS_ADAPTAPI", "Into getPDCEffect func is active"); return FunctionStatus.active; }  Log.e("PAS_ADAPTAPI", "Into getPDCEffect func is notactive"); return FunctionStatus.notactive; } private FunctionStatus getRPAEffect() { int i = getSignalValue(29386); switch (i) { default: return FunctionStatus.notavailable;case 129: case 130: case 131: case 132: break; }  if (usageModeAnyMatch(new int[] { 13 }) && carModeAnyMatch(new int[] { 0 })) return FunctionStatus.active;  return FunctionStatus.notactive; } private FunctionStatus getAPASelfRecommendedEffect() { int i = getSignalValue(29386); switch (i) { default: return FunctionStatus.notavailable;case 128: case 129: case 130: case 131: case 132: break; }  if (usageModeAnyMatch(new int[] { 1, 2, 11, 13 })) if (carModeAnyMatch(new int[] { 0 })) return FunctionStatus.active;   return FunctionStatus.notactive; } private FunctionStatus getSupportPDCWarning() { int i = getSignalValue(29386); if (i <= 1) return FunctionStatus.notavailable;  return FunctionStatus.active; } class AudioSettingsCallback extends IAudioSettingsCallback.Stub
/*     */   {
/* 945 */     public void onPDCWarningChanged(int param1Int) { int i = 255;
/* 946 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onPDCWarningChanged level:"); stringBuilder.append(param1Int); Log.d("PAS_ADAPTAPI", stringBuilder.toString());
/* 947 */       switch (param1Int) {
/*     */         case 3:
/* 949 */           i = 537723395;
/*     */           break;
/*     */         case 2:
/* 952 */           i = 537723394;
/*     */           break;
/*     */         case 1:
/* 955 */           i = 537723393;
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 961 */       stringBuilder = new StringBuilder(); stringBuilder.append("onPDCWarningChanged   function:PAS_FUNC_PAS_VOLUME  level:"); stringBuilder.append(param1Int); stringBuilder.append(", ret=0x");
/*     */ 
/*     */       
/* 964 */       stringBuilder.append(Integer.toHexString(i)); String str = stringBuilder.toString(); Log.d("PAS_ADAPTAPI", str);
/* 965 */       PAS.this.onFunctionChanged(537723392);
/* 966 */       PAS.this.onFunctionValueChanged(537723392, -2147483648, i); }
/*     */ 
/*     */     
/*     */     final PAS this$0;
/*     */     
/*     */     public void onSoundEffectsStatusChanged(int param1Int) {}
/*     */     
/*     */     public void onMixModeChanged(int param1Int) {}
/*     */     
/*     */     public void onLoudnessChanged(boolean param1Boolean) {}
/*     */     
/*     */     public void onTwoSurroundChanged(boolean param1Boolean) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\PAS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */