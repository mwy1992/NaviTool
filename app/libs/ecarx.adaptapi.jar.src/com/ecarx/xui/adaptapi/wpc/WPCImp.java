/*     */ package com.ecarx.xui.adaptapi.wpc;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarWpcmodelManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WPCImp
/*     */   extends WPC
/*     */   implements IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final String TAG = "WPCImp";
/*  35 */   private final CarPAEventCallback mCarPAEventCallback = new CarPAEventCallback() { final WPCImp this$0;
/*     */       
/*     */       public void onPA_WPC_InchargeStatus(PATypes.PA_WPC_InchargeStatus param1PA_WPC_InchargeStatus) {
/*  38 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("on incharge status "); stringBuilder.append(param1PA_WPC_InchargeStatus.getData()); Log.d("WPCImp", stringBuilder.toString());
/*  39 */         int i = WPCImp.this.convertInchargeStatus(param1PA_WPC_InchargeStatus.getData());
/*     */         
/*  41 */         for (WPC.StateListener stateListener : WPCImp.this.mStateListeners) {
/*     */           try {
/*  43 */             stateListener.onChargingStatus(i);
/*  44 */           } catch (Exception exception) {
/*  45 */             exception.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void onPA_WPC_Setting(PATypes.PA_WPC_Setting param1PA_WPC_Setting) {
/*  52 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("on work mode = "); stringBuilder.append(param1PA_WPC_Setting.getData()); stringBuilder.append(", availability = ");
/*  53 */         stringBuilder.append(param1PA_WPC_Setting.getAvailability()); String str = stringBuilder.toString(); Log.d("WPCImp", str);
/*  54 */         int i = WPCImp.this.convertWorkingMode(param1PA_WPC_Setting.getData());
/*     */         
/*  56 */         for (WPC.StateListener stateListener : WPCImp.this.mStateListeners) {
/*     */           try {
/*  58 */             stateListener.onWorkingMode(i);
/*  59 */           } catch (Exception exception) {
/*  60 */             exception.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       } }
/*     */   ; private ECarXCarWpcmodelManager mCarWpcManager; private final ECarXCarProxy mECarXCarProxy; private final SignalFilter mSignalFilter; private final CopyOnWriteArrayList<WPC.StateListener> mStateListeners;
/*     */   
/*     */   private WPCImp(Context paramContext) {
/*  67 */     this.mStateListeners = new CopyOnWriteArrayList<>();
/*  68 */     this.mSignalFilter = new SignalFilter();
/*  69 */     this.mSignalFilter.add(Integer.valueOf(33634));
/*  70 */     this.mSignalFilter.add(Integer.valueOf(33635));
/*     */     
/*  72 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/*  73 */     this.mECarXCarProxy.initECarXCar();
/*     */   }
/*     */   public static WPC create(Context paramContext) {
/*     */     /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/wpc/WPCImp}} */
/*  77 */     WPCImp wPCImp2 = null, wPCImp1 = null;
/*     */     
/*  79 */     if (paramContext != null)
/*  80 */       try { wPCImp1 = new WPCImp(); this(paramContext); }
/*     */       
/*  82 */       catch (Exception exception)
/*  83 */       { exception.printStackTrace(); wPCImp1 = wPCImp2; }
/*     */       finally {} 
/*     */     /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/wpc/WPCImp}} */
/*  86 */     return wPCImp1;
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
/*  97 */     Log.i("WPCImp", "onECarXCarServiceConnected");
/*     */     
/*     */     try {
/* 100 */       ECarXCarSetManager eCarXCarSetManager = (ECarXCarSetManager)paramECarXCar.getCarManager("car_publicattribute");
/*     */       
/* 102 */       if (eCarXCarSetManager != null) {
/* 103 */         this.mCarWpcManager = eCarXCarSetManager.getECarXCarWpcmodelManager();
/*     */       }
/*     */       
/* 106 */       if (this.mCarWpcManager != null) {
/* 107 */         this.mCarWpcManager.registerCallback(this.mCarPAEventCallback, this.mSignalFilter);
/*     */       }
/*     */     }
/* 110 */     catch (Exception exception) {
/* 111 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 120 */     Log.w("WPCImp", "onECarXCarServiceDeath");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 130 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 138 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disconnect() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isWPCSupported() {
/* 165 */     FunctionStatus functionStatus = FunctionStatus.notavailable;
/* 166 */     switch (getAvailability()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 180 */         return functionStatus;
/*     */       case 4:
/*     */         functionStatus = FunctionStatus.error;
/*     */       case 3:
/*     */         functionStatus = FunctionStatus.notavailable;
/*     */       case 2:
/*     */         functionStatus = FunctionStatus.notactive;
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     functionStatus = FunctionStatus.active; } public int setWorkingMode(@WorkingMode int paramInt) {
/* 191 */     boolean bool1 = false, bool2 = false;
/*     */     
/* 193 */     try { ECarXCarWpcmodelManager eCarXCarWpcmodelManager = this.mCarWpcManager; if (paramInt == 2) bool1 = true;  eCarXCarWpcmodelManager.CB_WPC_Setting(bool1);
/*     */ 
/*     */ 
/*     */       
/* 197 */       paramInt = bool2; } catch (Exception exception) { exception.printStackTrace(); paramInt = -1; }
/* 198 */      return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWorkingMode() {
/* 207 */     boolean bool = true; int i = 1;
/*     */     try {
/* 209 */       PATypes.PA_WPC_Setting pA_WPC_Setting = this.mCarWpcManager.getPA_WPC_Setting();
/* 210 */       if (pA_WPC_Setting != null) {
/* 211 */         i = convertWorkingMode(pA_WPC_Setting.getData());
/*     */       }
/* 213 */     } catch (Exception exception) {
/* 214 */       exception.printStackTrace(); i = bool;
/*     */     } 
/* 216 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getChargingStatus() {
/* 225 */     boolean bool = true; int i = 1;
/*     */     
/*     */     try {
/* 228 */       ECarXCarWpcmodelManager eCarXCarWpcmodelManager = this.mCarWpcManager;
/* 229 */       PATypes.PA_WPC_InchargeStatus pA_WPC_InchargeStatus = eCarXCarWpcmodelManager.getPA_WPC_InchargeStatus();
/* 230 */       if (pA_WPC_InchargeStatus != null) {
/* 231 */         i = convertInchargeStatus(pA_WPC_InchargeStatus.getData());
/*     */       }
/* 233 */     } catch (Exception exception) {
/* 234 */       exception.printStackTrace(); i = bool;
/*     */     } 
/*     */     
/* 237 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStateListener(WPC.StateListener paramStateListener) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mStateListeners : Ljava/util/concurrent/CopyOnWriteArrayList;
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   10: ifne -> 22
/*     */     //   13: aload_0
/*     */     //   14: getfield mStateListeners : Ljava/util/concurrent/CopyOnWriteArrayList;
/*     */     //   17: aload_1
/*     */     //   18: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   21: pop
/*     */     //   22: aload_0
/*     */     //   23: monitorexit
/*     */     //   24: return
/*     */     //   25: astore_1
/*     */     //   26: aload_0
/*     */     //   27: monitorexit
/*     */     //   28: aload_1
/*     */     //   29: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #246	-> 2
/*     */     //   #247	-> 13
/*     */     //   #249	-> 22
/*     */     //   #245	-> 25
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	13	25	finally
/*     */     //   13	22	25	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetStateListener(WPC.StateListener paramStateListener) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: aload_0
/*     */     //   3: getfield mStateListeners : Ljava/util/concurrent/CopyOnWriteArrayList;
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual remove : (Ljava/lang/Object;)Z
/*     */     //   10: pop
/*     */     //   11: aload_0
/*     */     //   12: monitorexit
/*     */     //   13: return
/*     */     //   14: astore_1
/*     */     //   15: aload_0
/*     */     //   16: monitorexit
/*     */     //   17: aload_1
/*     */     //   18: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #257	-> 2
/*     */     //   #258	-> 11
/*     */     //   #256	-> 14
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	11	14	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getAvailability() {
/* 262 */     byte b1, b2 = 3;
/*     */     
/*     */     try {
/* 265 */       PATypes.PA_WPC_Setting pA_WPC_Setting = this.mCarWpcManager.getPA_WPC_Setting();
/* 266 */       b1 = b2; if (pA_WPC_Setting != null) {
/* 267 */         b1 = pA_WPC_Setting.getAvailability();
/*     */       }
/* 269 */     } catch (Exception exception) {
/* 270 */       exception.printStackTrace(); b1 = b2;
/*     */     } 
/*     */     
/* 273 */     return b1;
/*     */   }
/*     */   
/*     */   @WorkingMode
/*     */   private int convertWorkingMode(int paramInt) {
/* 278 */     byte b = 1; if (paramInt == 1) b = 2;  return b;
/*     */   }
/*     */   
/*     */   @ChargingStatus
/*     */   private int convertInchargeStatus(int paramInt) {
/* 283 */     int i = 1;
/*     */     
/* 285 */     if (paramInt == 0 || paramInt == 4 || paramInt == 5)
/*     */     
/*     */     { 
/* 288 */       i = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 306 */       return i; }  if (paramInt == 1) { i = 7; } else if (paramInt == 2) { i = 2; } else if (paramInt == 3) { i = 9; } else if (paramInt == 6) { i = 5; } else if (paramInt == 7) { i = -2147483647; } else if (paramInt == 8) { i = 3; } else if (paramInt == 9) { i = -2147483647; }  return i;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wpc\WPCImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */