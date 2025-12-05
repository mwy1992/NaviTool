/*     */ package com.ecarx.xui.adaptapi.car.userprofile;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarProfileManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarKey
/*     */   extends AbsCarSignal
/*     */   implements ICarKey
/*     */ {
/*     */   private static final String TAG = "CarKey_API";
/*     */   private final CopyOnWriteArrayList<ICarKey.ICarKeyObserver> mCarKeyObservers;
/*     */   private ECarXCarProfileManager mECarXCarProfileManager;
/*     */   private final CarPAEventCallback mPAEventCallback;
/*     */   
/*     */   public CarKey(Context paramContext) {
/*  25 */     super(paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     this.mPAEventCallback = new CarPAEventCallback() {
/*     */         final CarKey this$0;
/*     */         
/*     */         public void onPA_PSET_Key_Result(PATypes.PA_PSET_Key_Result param1PA_PSET_Key_Result) {
/* 193 */           Log.i("CarKey_API", param1PA_PSET_Key_Result.toString());
/* 194 */           if (param1PA_PSET_Key_Result.getData() > 0)
/* 195 */             for (ICarKey.ICarKeyObserver iCarKeyObserver : CarKey.this.mCarKeyObservers) {
/* 196 */               if (param1PA_PSET_Key_Result.getData() == 1) {
/*     */                 
/* 198 */                 iCarKeyObserver.timeout(); continue;
/* 199 */               }  if (param1PA_PSET_Key_Result.getData() == 2) {
/*     */                 
/* 201 */                 iCarKeyObserver.multipleKeyFound(true); continue;
/* 202 */               }  if (param1PA_PSET_Key_Result.getData() == 3) {
/*     */                 
/* 204 */                 iCarKeyObserver.onKeyReadResult(0); continue;
/* 205 */               }  if (param1PA_PSET_Key_Result.getData() == 4)
/*     */               {
/*     */                 
/* 208 */                 iCarKeyObserver.onKeyReadResult(1);
/*     */               }
/*     */             }  
/*     */         }
/*     */       };
/*     */     this.mCarKeyObservers = new CopyOnWriteArrayList<>();
/*     */   }
/*     */   
/*     */   protected void onInitCarSignalManager() {
/*     */     try {
/*     */       this.mECarXCarProfileManager = this.mECarXCarSetManager.getECarXCarProfileManager();
/*     */       this.mECarXCarProfileManager.registerCallback(this.mPAEventCallback, getPAFilter());
/*     */     } catch (Exception exception) {
/*     */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void initPAFilter() {
/*     */     addPAFilter(Integer.valueOf(33878));
/*     */   }
/*     */   
/*     */   public void startDiscovery() {
/*     */     this.mECarXCarProfileManager.CB_PSET_ConnectKey(0);
/*     */   }
/*     */   
/*     */   public void unbindCarKey(int paramInt) {
/*     */     try {
/*     */       this.mECarXCarProfileManager.CB_PSET_ConnectKey(17);
/*     */     } catch (Exception exception) {
/*     */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void readRealKey() {
/*     */     try {
/*     */       this.mECarXCarProfileManager.CB_PSET_ConnectKey(1);
/*     */     } catch (Exception exception) {
/*     */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void cancelDiscovery() {}
/*     */   
/*     */   public boolean registerCarKeyObserver(ICarKey.ICarKeyObserver paramICarKeyObserver) {
/*     */     boolean bool = false;
/*     */     if (!this.mCarKeyObservers.contains(paramICarKeyObserver))
/*     */       bool = this.mCarKeyObservers.add(paramICarKeyObserver); 
/*     */     return bool;
/*     */   }
/*     */   
/*     */   public boolean unregisterCarKeyObserver(ICarKey.ICarKeyObserver paramICarKeyObserver) {
/*     */     return this.mCarKeyObservers.remove(paramICarKeyObserver);
/*     */   }
/*     */   
/*     */   public boolean createDigitalKey(int paramInt) {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean delAllDigitalKey() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean delDigitalKeyItem(int paramInt) {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public DigitalKeyInfo[] getDigitalKeys() {
/*     */     return new DigitalKeyInfo[0];
/*     */   }
/*     */   
/*     */   public int[] getHangupIds() {
/*     */     return new int[0];
/*     */   }
/*     */   
/*     */   public int[] getRecoverIds() {
/*     */     return new int[0];
/*     */   }
/*     */   
/*     */   public boolean registerDigitalKeyCallback(ICarKey.IDigitalKeyCallback paramIDigitalKeyCallback) {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean unregisterDigitalKeyCallback(ICarKey.IDigitalKeyCallback paramIDigitalKeyCallback) {
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ca\\userprofile\CarKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */