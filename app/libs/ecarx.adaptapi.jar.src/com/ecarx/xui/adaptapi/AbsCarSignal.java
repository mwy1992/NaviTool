/*     */ package com.ecarx.xui.adaptapi;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleSignalStore2;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleType;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.IntStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbsCarSignal
/*     */ {
/*     */   private final VehicleSignalStore2 mSignalStore;
/*     */   private final SignalFilter mSignalFilter;
/*     */   private final SignalFilter mPAFilter;
/*     */   protected ECarXCarSetManager mECarXCarSetManager;
/*  35 */   private final Object mECarXCarLock = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GuardedBy("mECarXCarLock")
/*     */   protected ECarXCar mECarXCar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Context mContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CarSignalManager mCarSignalManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   protected final CarSignalManager.CarSignalEventCallback mCarSignalEventCallback = new CarSignalManager.CarSignalEventCallback()
/*     */     {
/*     */       final AbsCarSignal this$0;
/*     */       
/*     */       public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/*     */         try {
/*  67 */           AbsCarSignal.this.onChangeEvent(param1ECarXCarPropertyValue);
/*  68 */         } catch (Exception exception) {
/*  69 */           exception.printStackTrace();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void onErrorEvent(int param1Int1, int param1Int2) {
/*     */         try {
/*  76 */           AbsCarSignal.this.onErrorEvent(param1Int1, param1Int2);
/*  77 */         } catch (Exception exception) {
/*  78 */           exception.printStackTrace();
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   protected AbsCarSignal(Context paramContext) {
/*  84 */     this.mContext = paramContext;
/*  85 */     this.mSignalFilter = new SignalFilter();
/*  86 */     this.mPAFilter = new SignalFilter();
/*  87 */     this.mSignalStore = new VehicleSignalStore2();
/*  88 */     initSignalFilter();
/*  89 */     initPAFilter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SignalFilter getPAFilter() {
/*  96 */     return this.mPAFilter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SignalFilter getSignalFilter() {
/* 103 */     return this.mSignalFilter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ECarXCar getECarXCar() {
/* 110 */     synchronized (this.mECarXCarLock) {
/* 111 */       return this.mECarXCar;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 122 */     synchronized (this.mECarXCarLock) {
/* 123 */       this.mECarXCar = paramECarXCar;
/* 124 */       this.mCarSignalManager = paramCarSignalManager;
/*     */       
/* 126 */       if (paramCarSignalManager != null) {
/* 127 */         try { paramCarSignalManager.registerCallback(this.mCarSignalEventCallback, getSignalFilter());
/*     */ 
/*     */ 
/*     */           
/*     */            }
/*     */         
/* 133 */         catch (Exception exception) {}
/*     */       }
/*     */       if (this.mECarXCar != null) {
/*     */         this.mECarXCarSetManager = (ECarXCarSetManager)this.mECarXCar.getCarManager("car_publicattribute");
/*     */       }
/* 138 */       onInitCarSignalManager();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isECarXCarConnected() {
/* 154 */     synchronized (this.mECarXCarLock) {
/* 155 */       boolean bool; if (this.mECarXCar != null && this.mECarXCar.isConnected()) { bool = true; } else { bool = false; }
/*     */       
/* 157 */       return bool;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onInitCarSignalManager() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <E> E getValue(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/* 173 */     return (E)paramECarXCarPropertyValue.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addPAFilter(Integer paramInteger) {
/* 182 */     this.mPAFilter.add(paramInteger);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addSignalFilter(Integer paramInteger) {
/* 191 */     this.mSignalFilter.add(paramInteger);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initPAFilter() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initSignalFilter() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/* 214 */     recordSignalDate(paramECarXCarPropertyValue);
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
/*     */   protected void onErrorEvent(int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void recordPADate(int paramInt, Object paramObject) {
/* 235 */     this.mSignalStore.recordPAData(paramInt, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void recordSignalDate(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/* 243 */     this.mSignalStore.recordSignalData(paramECarXCarPropertyValue);
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
/*     */   public <PA_TYPE> PA_TYPE getPAData(int paramInt) {
/* 255 */     return (PA_TYPE)this.mSignalStore.getPAData(paramInt, new -$$Lambda$AbsCarSignal$W5d7M55kjFSEV-aH7IsuWStuDjI(this, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSignalValue(int paramInt1, int paramInt2) {
/* 262 */     return this.mSignalStore.getSignalData(paramInt1, new -$$Lambda$AbsCarSignal$rwUv3QKFj510vETUeMYcn1ganRA(this, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSignalValue(int paramInt) {
/* 273 */     return getSignalValue(paramInt, -2147483648);
/*     */   }
/*     */ 
/*     */   
/*     */   public FunctionStatus getFunctionStatus(int paramInt) {
/* 278 */     PATypes.PA_IntBase pA_IntBase = getPAData(paramInt);
/* 279 */     if (pA_IntBase != null) {
/* 280 */       return SignalUtils.convertToFunctionStatus(pA_IntBase.getAvailability());
/*     */     }
/* 282 */     return FunctionStatus.notavailable;
/*     */   }
/*     */   
/*     */   public int getIntValue(int paramInt1, int paramInt2) {
/* 286 */     PATypes.PA_IntBase pA_IntBase = getPAData(paramInt1);
/* 287 */     if (pA_IntBase == null) { paramInt1 = paramInt2; } else { paramInt1 = pA_IntBase.getData(); }  return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getConvertIntData(int paramInt1, @NonNull Function<Integer, Integer> paramFunction, int paramInt2) {
/* 293 */     PATypes.PA_IntBase pA_IntBase = getPAData(paramInt1);
/* 294 */     if (pA_IntBase != null) {
/* 295 */       if (paramFunction == null) { paramInt1 = pA_IntBase.getData(); } else { paramInt1 = ((Integer)paramFunction.apply(Integer.valueOf(pA_IntBase.getData()))).intValue(); }  return paramInt1;
/*     */     } 
/* 297 */     return paramInt2;
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
/*     */   public boolean carModeAnyMatch(int... paramVarArgs) {
/* 309 */     int i = getSignalValue(30779);
/* 310 */     return IntStream.of(paramVarArgs).anyMatch(new -$$Lambda$AbsCarSignal$nz8_C5p51019aJ6WFBK4DcFJnB8(i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usageModeAnyMatch(int... paramVarArgs) {
/* 320 */     int i = getSignalValue(30788);
/*     */     
/* 322 */     return IntStream.of(paramVarArgs).anyMatch(new -$$Lambda$AbsCarSignal$3npoiFZPDriPHAn_qoC_Tufr8g4(i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usageModeNotMatch(int paramInt) {
/*     */     boolean bool;
/* 332 */     int i = getSignalValue(30788);
/*     */     
/* 334 */     if (i != paramInt) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean carConfigAnyMatch(int paramInt, int... paramVarArgs) {
/* 345 */     paramInt = getSignalValue(paramInt);
/* 346 */     return IntStream.of(paramVarArgs).anyMatch(new -$$Lambda$AbsCarSignal$kSEKG9dzdnFx0o7UlhGGhQOkopM(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDriverRightSide() {
/* 355 */     return carConfigAnyMatch(29334, new int[] { 2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VehicleType getVehicleType() {
/* 364 */     int i = getSignalValue(29329);
/* 365 */     return VehicleType.get(i);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\AbsCarSignal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */