/*     */ package com.ecarx.xui.adaptapi.car.sensor;
/*     */ 
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.IntFunction;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SensorFunction<T>
/*     */   implements ISensorFunction<T>
/*     */ {
/*  24 */   private Data<T> mData = new Data<>();
/*     */   
/*  26 */   private List<Integer> mAssociatedStatusOrVal = new ArrayList<>();
/*  27 */   private int mValPropId = -1;
/*  28 */   private int mStsPropId = -1;
/*     */   
/*  30 */   private Supplier<FunctionStatus> mStatusFun = null;
/*  31 */   private IntFunction<FunctionStatus> mStatusFunction = null;
/*     */   
/*  33 */   private Supplier<T> mValFun = null;
/*  34 */   private IntFunction<T> mValFunction = null;
/*     */   
/*  36 */   private List<ISensor.ISensorListener> mSensorListeners = new ArrayList<>();
/*     */   
/*  38 */   private int mRate = -1; private boolean isRegistered = false; private static final String TAG = "SensorFunction";
/*     */   private AbsSensorFunction mAbsSensorFunction;
/*     */   private int mSensorId;
/*     */   private int mType;
/*     */   
/*     */   SensorFunction(AbsSensorFunction paramAbsSensorFunction, int paramInt) {
/*  44 */     this.mAbsSensorFunction = paramAbsSensorFunction;
/*  45 */     this.mSensorId = paramInt;
/*     */   }
/*     */   
/*     */   public boolean isRegistered() {
/*  49 */     return this.isRegistered;
/*     */   }
/*     */   
/*     */   public void setRegistered(boolean paramBoolean) {
/*  53 */     this.isRegistered = paramBoolean;
/*     */   }
/*     */   
/*     */   public int getRate() {
/*  57 */     return this.mRate;
/*     */   }
/*     */   
/*     */   public void setRate(int paramInt) {
/*  61 */     this.mRate = paramInt;
/*     */   }
/*     */   
/*     */   public List<ISensor.ISensorListener> getSensorListeners() {
/*  65 */     return this.mSensorListeners;
/*     */   }
/*     */   
/*     */   public int getSensorId() {
/*  69 */     return this.mSensorId;
/*     */   }
/*     */   
/*     */   public Data<T> getData() {
/*  73 */     this.mData.setStatus(getFunctionStatus());
/*  74 */     this.mData.setValue(getFunctionVal());
/*     */     
/*  76 */     return this.mData;
/*     */   }
/*     */   
/*     */   public void setData(Data<T> paramData) {
/*  80 */     this.mData = paramData;
/*     */   }
/*     */   
/*     */   public int getType() {
/*  84 */     return this.mData.getType();
/*     */   }
/*     */   
/*     */   public List<Integer> getAssociatedStatusOrVal() {
/*  88 */     return this.mAssociatedStatusOrVal;
/*     */   }
/*     */   
/*     */   public void setValPropId(int paramInt) {
/*  92 */     this.mValPropId = paramInt;
/*     */   }
/*     */   
/*     */   public void setStsPropId(int paramInt) {
/*  96 */     this.mStsPropId = paramInt;
/*     */   }
/*     */   
/*     */   public T getFunctionVal() {
/* 100 */     T t = null;
/* 101 */     if (this.mValFunction != null) {
/* 102 */       if (isPAOrSignal(this.mValPropId).equals("signal")) {
/* 103 */         t = this.mValFunction.apply(this.mAbsSensorFunction.getSignalValue(this.mValPropId));
/* 104 */       } else if (isPAOrSignal(this.mValPropId).equals("pa")) {
/* 105 */         t = this.mValFunction.apply(this.mAbsSensorFunction.getIntValue(this.mValPropId, -1));
/*     */       } 
/*     */     } else {
/* 108 */       t = this.mValFun.get();
/*     */     } 
/* 110 */     return t;
/*     */   }
/*     */   
/*     */   public FunctionStatus getFunctionStatus() {
/* 114 */     FunctionStatus functionStatus = FunctionStatus.notavailable;
/* 115 */     if (this.mStatusFunction != null) {
/* 116 */       functionStatus = this.mStatusFunction.apply(this.mAbsSensorFunction.getSignalValue(this.mStsPropId));
/*     */     } else {
/* 118 */       functionStatus = this.mStatusFun.get();
/*     */     } 
/* 120 */     return functionStatus;
/*     */   }
/*     */ 
/*     */   
/*     */   private String isPAOrSignal(int paramInt) {
/* 125 */     String str = "";
/* 126 */     paramInt = 0xFFFF & paramInt;
/* 127 */     if (paramInt >= 32768) {
/* 128 */       str = "pa";
/* 129 */     } else if (paramInt >= 28672) {
/* 130 */       str = "signal";
/*     */     } 
/* 132 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ISensorFunction.ISensorStatus<T> sensorType(int paramInt) {
/* 138 */     this.mData.setType(paramInt);
/* 139 */     return new SensorStatus<>(this);
/*     */   }
/*     */   
/*     */   public static class SensorStatus<T> implements ISensorFunction.ISensorStatus<T> {
/*     */     private SensorFunction<T> mSensorFunction;
/*     */     
/*     */     public SensorStatus(SensorFunction<T> param1SensorFunction) {
/* 146 */       this.mSensorFunction = param1SensorFunction;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ISensorFunction.ISensorValue<T> fixStatus(FunctionStatus param1FunctionStatus) {
/* 152 */       SensorFunction.access$002(this.mSensorFunction, new -$$Lambda$SensorFunction$SensorStatus$mArVFrdTWbslEJJQDBzUB4jv_20(param1FunctionStatus));
/* 153 */       return new SensorFunction.SensorValue<>(this.mSensorFunction);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ISensorFunction.ISensorValue<T> useSigsToStatus(Supplier<FunctionStatus> param1Supplier, int... param1VarArgs) {
/* 159 */       SensorFunction.access$002(this.mSensorFunction, param1Supplier);
/* 160 */       if (param1VarArgs.length > 0) {
/* 161 */         Stream<Integer> stream = Arrays.stream(param1VarArgs).boxed();
/* 162 */         Collector<?, ?, List<?>> collector = Collectors.toList(); Collection<? extends Integer> collection = stream.collect((Collector)collector);
/* 163 */         this.mSensorFunction.getAssociatedStatusOrVal().addAll(collection);
/*     */       } 
/* 165 */       return new SensorFunction.SensorValue<>(this.mSensorFunction);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ISensorFunction.ISensorValue<T> usePAToStatus(int param1Int) {
/* 171 */       this.mSensorFunction.getAssociatedStatusOrVal().add(Integer.valueOf(param1Int));
/*     */ 
/*     */       
/* 174 */       SensorFunction.access$002(this.mSensorFunction, new -$$Lambda$SensorFunction$SensorStatus$Cy_GWHlJuvdccCZm6TaIuoOp5VY(this, param1Int));
/*     */ 
/*     */ 
/*     */       
/* 178 */       return new SensorFunction.SensorValue<>(this.mSensorFunction);
/*     */     }
/*     */ 
/*     */     
/*     */     public ISensorFunction.ISensorValue<T> useSigToStatus(int param1Int, IntFunction<FunctionStatus> param1IntFunction) {
/* 183 */       this.mSensorFunction.getAssociatedStatusOrVal().add(Integer.valueOf(param1Int));
/* 184 */       this.mSensorFunction.setStsPropId(param1Int);
/* 185 */       SensorFunction.access$102(this.mSensorFunction, param1IntFunction);
/* 186 */       return new SensorFunction.SensorValue<>(this.mSensorFunction);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SensorValue<T>
/*     */     implements ISensorFunction.ISensorValue<T> {
/*     */     private SensorFunction<T> mSensorFunction;
/*     */     
/*     */     public SensorValue(SensorFunction<T> param1SensorFunction) {
/* 195 */       this.mSensorFunction = param1SensorFunction;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ISensorFunction.ISensorEnd<T> useSigOrPaToValue(int param1Int, IntFunction<T> param1IntFunction) {
/* 201 */       this.mSensorFunction.getAssociatedStatusOrVal().add(Integer.valueOf(param1Int));
/* 202 */       this.mSensorFunction.setValPropId(param1Int);
/* 203 */       SensorFunction.access$302(this.mSensorFunction, param1IntFunction);
/* 204 */       return new SensorFunction.SensorEnd<>(this.mSensorFunction);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ISensorFunction.ISensorEnd<T> useSigOrPaToValue(Pairs<Integer, T> param1Pairs, int param1Int) {
/* 210 */       this.mSensorFunction.getAssociatedStatusOrVal().add(Integer.valueOf(param1Int));
/*     */       
/* 212 */       if (this.mSensorFunction.isPAOrSignal(param1Int).equals("pa")) {
/* 213 */         SensorFunction.access$502(this.mSensorFunction, new -$$Lambda$SensorFunction$SensorValue$RVBJMB_W4frF9B6Aqx3hgsmI6Uo(this, param1Pairs, param1Int));
/*     */       
/*     */       }
/* 216 */       else if (this.mSensorFunction.isPAOrSignal(param1Int).equals("signal")) {
/* 217 */         SensorFunction.access$502(this.mSensorFunction, new -$$Lambda$SensorFunction$SensorValue$K8NfURKKxnJOjnX16aC-I3rAtwQ(this, param1Pairs, param1Int));
/*     */       } 
/*     */       
/* 220 */       return new SensorFunction.SensorEnd<>(this.mSensorFunction);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ISensorFunction.ISensorEnd<T> useSigsOrPasToValue(Supplier<T> param1Supplier, int... param1VarArgs) {
/* 226 */       if (param1VarArgs.length > 0) {
/* 227 */         Stream<Integer> stream = Arrays.stream(param1VarArgs).boxed();
/* 228 */         Collector<?, ?, List<?>> collector = Collectors.toList(); Collection<? extends Integer> collection = stream.collect((Collector)collector);
/* 229 */         this.mSensorFunction.getAssociatedStatusOrVal().addAll(collection);
/*     */       } 
/* 231 */       SensorFunction.access$502(this.mSensorFunction, param1Supplier);
/* 232 */       return new SensorFunction.SensorEnd<>(this.mSensorFunction);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SensorEnd<T>
/*     */     implements ISensorFunction.ISensorEnd<T>
/*     */   {
/*     */     private SensorFunction<T> mSensorFunction;
/*     */     
/*     */     public SensorEnd(SensorFunction<T> param1SensorFunction) {
/* 242 */       this.mSensorFunction = param1SensorFunction;
/*     */     }
/*     */ 
/*     */     
/*     */     public void addTo(Consumer<ISensorFunction<T>> param1Consumer) {
/* 247 */       param1Consumer.accept(this.mSensorFunction);
/*     */     }
/*     */   }
/*     */   public static class Data<T> { private FunctionStatus mStatus; private boolean mStatusChange; private int mType; private T mValue;
/*     */     private boolean mValueChange;
/*     */     
/* 253 */     public Data() { this.mType = 0;
/*     */ 
/*     */       
/* 256 */       this.mStatusChange = false;
/* 257 */       this.mValueChange = false; } public Data(FunctionStatus param1FunctionStatus, int param1Int, T param1T) { boolean bool = false; this.mType = 0; this.mStatusChange = false; this.mValueChange = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 264 */       if (this.mStatus != param1FunctionStatus) bool = true;  this.mStatusChange = bool;
/* 265 */       this.mValueChange = this.mValue.equals(param1T) ^ true;
/* 266 */       this.mStatus = param1FunctionStatus;
/* 267 */       this.mType = param1Int;
/* 268 */       this.mValue = param1T; }
/*     */ 
/*     */ 
/*     */     
/*     */     public FunctionStatus getStatus() {
/* 273 */       return this.mStatus;
/*     */     }
/*     */     public void setStatus(FunctionStatus param1FunctionStatus) {
/*     */       boolean bool;
/* 277 */       if (param1FunctionStatus != this.mStatus) { bool = true; } else { bool = false; }  this.mStatusChange = bool;
/* 278 */       this.mStatus = param1FunctionStatus;
/*     */     }
/*     */     
/*     */     public int getType() {
/* 282 */       return this.mType;
/*     */     }
/*     */     
/*     */     public void setType(int param1Int) {
/* 286 */       this.mType = param1Int;
/*     */     }
/*     */     public T getValue() {
/*     */       Float float_;
/* 290 */       T t2 = this.mValue;
/* 291 */       T t1 = t2; if (this.mValue == null)
/* 292 */         if (this.mType == 2)
/* 293 */         { Integer integer = Integer.valueOf(-1); }
/* 294 */         else { t1 = t2; if (this.mType == 1) {
/* 295 */             float_ = Float.valueOf(Float.MIN_VALUE);
/*     */           } }
/*     */          
/* 298 */       return (T)float_;
/*     */     }
/*     */     
/*     */     public void setValue(T param1T) {
/* 302 */       if (param1T != null) {
/* 303 */         this.mValueChange = param1T.equals(this.mValue) ^ true;
/*     */       }
/* 305 */       this.mValue = param1T;
/*     */     }
/*     */     
/*     */     public boolean isStatusChange() {
/* 309 */       return this.mStatusChange;
/*     */     }
/*     */     
/*     */     public boolean isValueChange() {
/* 313 */       return this.mValueChange;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 318 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Data{mStatus="); stringBuilder.append(this.mStatus); stringBuilder.append(", mType="); stringBuilder.append(this.mType); stringBuilder.append(", mValue="); stringBuilder.append(this.mValue); stringBuilder.append(", mStatusChange="); stringBuilder.append(this.mStatusChange); stringBuilder.append(", mValueChange="); stringBuilder.append(this.mValueChange); stringBuilder.append('}'); return stringBuilder.toString();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\SensorFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */