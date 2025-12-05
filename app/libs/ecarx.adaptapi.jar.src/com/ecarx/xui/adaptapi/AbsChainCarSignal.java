/*     */ package com.ecarx.xui.adaptapi;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import android.util.SparseBooleanArray;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarFuncManagerBase;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Consumer;
/*     */ 
/*     */ public abstract class AbsChainCarSignal extends AbsCarSignal {
/*     */   private static final int PA = 32768;
/*     */   private static final int SIGNAL = 28672;
/*     */   private static final String TAG = "AbsChainCarSignal";
/*     */   private final SparseArray<EndQueueTask> endQueue;
/*     */   private final SparseArray<List<Runnable>> filterChain;
/*     */   private boolean isBuildFunctions = false;
/*     */   private final CarPAEventCallback mPAEventCallback;
/*     */   private final SparseBooleanArray paChange;
/*     */   
/*     */   protected AbsChainCarSignal(Context paramContext) {
/*  29 */     super(paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     this.mPAEventCallback = new CarPAEventCallback() {
/*     */         final AbsChainCarSignal this$0;
/*     */         
/*     */         public void onPAChanged(ECarXCarPropertyValue param1ECarXCarPropertyValue) { String str;
/*  84 */           Object object = convertPAData(param1ECarXCarPropertyValue);
/*  85 */           if (object == null) {
/*  86 */             object = AbsChainCarSignal.this.getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onPAChanged the propertyId 0x");
/*  87 */             stringBuilder.append(Integer.toHexString(param1ECarXCarPropertyValue.getPropertyId())); stringBuilder.append(" convertPAData is null "); str = stringBuilder.toString();
/*     */             Log.i((String)object, str);
/*     */             return;
/*     */           } 
/*  91 */           Log.i(AbsChainCarSignal.this.getModuleName(), object.toString());
/*     */           
/*  93 */           AbsChainCarSignal.this.recordPADate(str.getPropertyId(), object);
/*  94 */           object = AbsChainCarSignal.this.filterChain.get(str.getPropertyId());
/*  95 */           if (object != null && object.size() > 0) {
/*  96 */             for (Runnable runnable : object) {
/*  97 */               runnable.run();
/*     */             }
/*     */           } else {
/*     */             
/* 101 */             AbsChainCarSignal.this.paChange.put(str.getPropertyId(), true);
/*     */           } 
/* 103 */           AbsChainCarSignal.EndQueueTask endQueueTask = (AbsChainCarSignal.EndQueueTask)AbsChainCarSignal.this.endQueue.get(str.getPropertyId());
/* 104 */           if (endQueueTask != null)
/* 105 */             endQueueTask.run();  }
/*     */       }; this.filterChain = new SparseArray(); this.endQueue = new SparseArray(); this.paChange = new SparseBooleanArray(); } protected final void onInitCarSignalManager() { onCarSignalConnected(this.mECarXCarSetManager); if (!this.isBuildFunctions) { this.isBuildFunctions = true; buildFilterChains(); }
/*     */      try { int i = getSignalFilter().getFilterCount(); if (i > 0)
/*     */         this.mCarSignalManager.registerCallback(this.mCarSignalEventCallback, getSignalFilter());  i = getPAFilter().getFilterCount(); if (i > 0) { ECarXCarFuncManagerBase eCarXCarFuncManagerBase = this.mECarXCarSetManager.getECarXCarBaseManager(); CarPAEventCallback carPAEventCallback = this.mPAEventCallback; SignalFilter signalFilter = getPAFilter(); eCarXCarFuncManagerBase.registerCallback(carPAEventCallback, signalFilter); }
/*     */        }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 111 */      } private boolean isChange(int paramInt) { boolean bool = this.paChange.get(paramInt, false);
/* 112 */     if (bool) {
/* 113 */       this.paChange.put(paramInt, false);
/*     */     }
/* 115 */     return bool; }
/*     */   public int getSignalValue(int paramInt) { return getSignalValue(paramInt, -2147483648); }
/*     */   protected final void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) { recordSignalDate(paramECarXCarPropertyValue); List list = (List)this.filterChain.get(paramECarXCarPropertyValue.getPropertyId()); if (list != null && list.size() > 0)
/*     */       for (Runnable runnable : list)
/* 119 */         runnable.run();   } private String getModuleName() { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("AbsChainCarSignal::"); stringBuilder.append(getClass().getSimpleName()); return stringBuilder.toString(); }
/*     */    protected void addChain(Runnable paramRunnable, int... paramVarArgs) {
/*     */     byte b;
/*     */     int i;
/* 123 */     for (i = paramVarArgs.length, b = 0; b < i; ) { int j = paramVarArgs[b];
/* 124 */       List<Runnable> list = (List)this.filterChain.get(j, new ArrayList());
/* 125 */       if (list.isEmpty()) {
/* 126 */         this.filterChain.put(j, list);
/*     */       }
/* 128 */       list.add(paramRunnable);
/* 129 */       int k = 0xFFFF & j;
/* 130 */       if (k >= 32768) {
/* 131 */         addPAFilter(Integer.valueOf(j));
/* 132 */       } else if (k >= 28672) {
/* 133 */         addSignalFilter(Integer.valueOf(j));
/*     */       } else {
/* 135 */         String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("not found the propertyId 0x");
/* 136 */         stringBuilder.append(Integer.toHexString(j)); stringBuilder.append(" is PA or Signal"); String str2 = stringBuilder.toString();
/*     */         Log.i(str1, str2);
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   protected void addSignalChain(Consumer<Integer> paramConsumer, int paramInt) {
/* 144 */     addChain(new -$$Lambda$AbsChainCarSignal$vv9N2eAdAIW8Ty0tNlrsc7G4QG4(this, paramConsumer, paramInt), new int[] { paramInt });
/*     */   }
/*     */   
/*     */   protected <PA_TYPE> void addPATypeChain(Consumer<PA_TYPE> paramConsumer, int paramInt) {
/* 148 */     addChain(new -$$Lambda$AbsChainCarSignal$0tdJpJ9pgnaFBRI7qE2UDIdWUWk(this, paramInt, paramConsumer), new int[] { paramInt });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addPAByDataChain(Consumer<Integer> paramConsumer, int paramInt) {
/* 153 */     addChain(new -$$Lambda$AbsChainCarSignal$uNSXIDXUUEEzbgWb-pCbjNWXA2o(this, paramInt, paramConsumer), new int[] { paramInt });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addPAByAvailableChain(Consumer<FunctionStatus> paramConsumer, int paramInt) {
/* 158 */     addChain(new -$$Lambda$AbsChainCarSignal$6dPFgmCb5w4vkXMaYr8msRPsKms(this, paramInt, paramConsumer), new int[] { paramInt });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EndQueueTask whenMsgEnd(int paramInt) {
/* 165 */     EndQueueTask endQueueTask2 = (EndQueueTask)this.endQueue.get(paramInt);
/* 166 */     EndQueueTask endQueueTask1 = endQueueTask2; if (endQueueTask2 == null) {
/* 167 */       endQueueTask1 = new EndQueueTask(this);
/* 168 */       this.endQueue.put(paramInt, endQueueTask1);
/* 169 */       addPAFilter(Integer.valueOf(paramInt));
/*     */     } 
/* 171 */     return endQueueTask1;
/*     */   }
/*     */   protected abstract void buildFilterChains();
/*     */   
/*     */   protected abstract void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager);
/*     */   
/*     */   public static final class EndQueueTask { private final AbsChainCarSignal parent;
/*     */     private final List<Runnable> taskRunnable;
/*     */     
/*     */     public EndQueueTask(AbsChainCarSignal param1AbsChainCarSignal) {
/* 181 */       this.parent = param1AbsChainCarSignal;
/* 182 */       this.taskRunnable = new ArrayList<>(5);
/*     */     }
/*     */     
/*     */     public <PA_TYPE> EndQueueTask observerChange(int param1Int, Consumer<PA_TYPE> param1Consumer) {
/* 186 */       this.parent.addPAFilter(Integer.valueOf(param1Int));
/* 187 */       this.taskRunnable.add(new -$$Lambda$AbsChainCarSignal$EndQueueTask$o-LXO46cZ_fL5lH8NhdgJyFH02E(this, param1Int, param1Consumer));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     private void run() {
/* 198 */       if (this.taskRunnable.size() > 0)
/* 199 */         for (Runnable runnable : this.taskRunnable)
/* 200 */           runnable.run();  
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\AbsChainCarSignal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */