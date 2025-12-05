/*     */ package com.ecarx.xui.adaptapi.car;
/*     */ 
/*     */ import android.util.SparseArray;
/*     */ import com.ecarx.xui.adaptapi.CallStatus;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.base.IProFunction;
/*     */ import com.ecarx.xui.adaptapi.car.base.IProValue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProFunction<T>
/*     */ {
/*     */   private final ArrayList<IProFunction.IPropertyWatcher> mPropertyCallback;
/*     */   private final SparseArray<Zone<T>> mZones;
/*     */   private final int property;
/*     */   
/*     */   private ProFunction(int paramInt) {
/*  22 */     this.property = paramInt;
/*  23 */     this.mZones = new SparseArray();
/*  24 */     this.mPropertyCallback = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public static <E> ProFunction<E> proFunction(int paramInt) {
/*  28 */     return new ProFunction<>(paramInt);
/*     */   }
/*     */   
/*     */   public Zone<T> createZone(int paramInt) {
/*  32 */     Zone<T> zone = new Zone(this, paramInt);
/*  33 */     this.mZones.put(paramInt, zone);
/*  34 */     return zone;
/*     */   }
/*     */   
/*     */   public void addProFunction(Consumer<ProFunction<T>> paramConsumer) {
/*  38 */     paramConsumer.accept(this);
/*     */   }
/*     */   
/*     */   public Zone<T> getZone(int paramInt) {
/*  42 */     return (Zone<T>)this.mZones.get(paramInt);
/*     */   }
/*     */   
/*     */   public int getProperty() {
/*  46 */     return this.property;
/*     */   }
/*     */   
/*     */   public boolean register(IProFunction.IPropertyWatcher paramIPropertyWatcher) {
/*  50 */     if (!this.mPropertyCallback.contains(paramIPropertyWatcher)) {
/*  51 */       this.mPropertyCallback.add(paramIPropertyWatcher);
/*     */     }
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public boolean unregister(IProFunction.IPropertyWatcher paramIPropertyWatcher) {
/*  57 */     if (!this.mPropertyCallback.contains(paramIPropertyWatcher)) {
/*  58 */       return this.mPropertyCallback.remove(paramIPropertyWatcher);
/*     */     }
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   public void notifyCallback() {
/*  64 */     for (byte b = 0; b < this.mZones.size(); b++) {
/*  65 */       Zone zone = (Zone)this.mZones.valueAt(b);
/*  66 */       for (IProFunction.IPropertyWatcher iPropertyWatcher : this.mPropertyCallback) {
/*  67 */         iPropertyWatcher.onPropertyChanged(zone.getProperty());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Zone<T>
/*     */   {
/*     */     private final ProFunction<T> mProFunction;
/*     */     
/*     */     private Function<IProValue<T>, CallStatus> mSetFunction;
/*     */     private Supplier<FunctionStatus> mStatusFunction;
/*     */     private Supplier<T> mValueFunction;
/*     */     private final int zone;
/*     */     
/*     */     private Zone(ProFunction<T> param1ProFunction, int param1Int) {
/*  83 */       this.mProFunction = param1ProFunction;
/*  84 */       this.zone = param1Int;
/*     */     }
/*     */     
/*     */     public Zone<T> onSetProperty(Function<IProValue<T>, CallStatus> param1Function) {
/*  88 */       this.mSetFunction = param1Function;
/*  89 */       return this;
/*     */     }
/*     */     
/*     */     public Zone<T> onPropertyStatus(Supplier<FunctionStatus> param1Supplier) {
/*  93 */       this.mStatusFunction = param1Supplier;
/*  94 */       return this;
/*     */     }
/*     */     
/*     */     public ProFunction<T> onPropertyValue(Supplier<T> param1Supplier) {
/*  98 */       this.mValueFunction = param1Supplier;
/*  99 */       return this.mProFunction;
/*     */     }
/*     */     
/*     */     public CallStatus setProperty(IProValue<T> param1IProValue) {
/* 103 */       if (this.mSetFunction != null) {
/* 104 */         return this.mSetFunction.apply(param1IProValue);
/*     */       }
/* 106 */       return CallStatus.NOT_IMPLEMENT;
/*     */     }
/*     */     
/*     */     public IProValue<T> getProperty()
/*     */     {
/* 111 */       return new IProValue<T>() { final ProFunction.Zone this$0;
/*     */           
/*     */           public FunctionStatus getStatus() {
/* 114 */             if (ProFunction.Zone.this.mStatusFunction != null) {
/* 115 */               return ProFunction.Zone.this.mStatusFunction.get();
/*     */             }
/* 117 */             return FunctionStatus.notavailable;
/*     */           }
/*     */ 
/*     */           
/*     */           public int getPropertyId() {
/* 122 */             return ProFunction.Zone.this.mProFunction.property;
/*     */           }
/*     */ 
/*     */           
/*     */           public int getZoneId() {
/* 127 */             return ProFunction.Zone.this.zone;
/*     */           }
/*     */           
/*     */           public T getValue()
/*     */           {
/* 132 */             if (ProFunction.Zone.this.mValueFunction != null) {
/* 133 */               return ProFunction.Zone.this.mValueFunction.get();
/*     */             }
/* 135 */             return null; } }; } } class null implements IProValue<T> { public T getValue() { if (this.this$0.mValueFunction != null) return this.this$0.mValueFunction.get();  return null; }
/*     */ 
/*     */     
/*     */     final ProFunction.Zone this$0;
/*     */     
/*     */     public FunctionStatus getStatus() {
/*     */       if (this.this$0.mStatusFunction != null)
/*     */         return this.this$0.mStatusFunction.get(); 
/*     */       return FunctionStatus.notavailable;
/*     */     }
/*     */     
/*     */     public int getPropertyId() {
/*     */       return this.this$0.mProFunction.property;
/*     */     }
/*     */     
/*     */     public int getZoneId() {
/*     */       return this.this$0.zone;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\ProFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */