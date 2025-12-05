/*     */ package com.ecarx.xui.adaptapi.car;
/*     */ 
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Predicate;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VehicleFunction<T>
/*     */   implements IVehicleFunction<T>
/*     */ {
/*  38 */   private final SparseArray<SparseArray<ZoneTask<T>>> mZoneTasks = new SparseArray();
/*  39 */   private final List<ZoneTask<T>> mTasks = new ArrayList<>();
/*     */   
/*  41 */   private final Set<Integer> zones = new HashSet<>(10);
/*     */ 
/*     */   
/*  44 */   private final Set<Integer> mPropertyList = new HashSet<>();
/*     */ 
/*     */   
/*  47 */   private final Set<IVehicleFunction.IAssociatedStatus<T>> mAssociatedStatusList = new HashSet<>();
/*     */ 
/*     */   
/*  50 */   private int[] values = new int[0];
/*     */ 
/*     */   
/*  53 */   private final AtomicBoolean isRegister = new AtomicBoolean(false);
/*     */ 
/*     */   
/*  56 */   private Function<Integer, Integer> convertDriverSide = Function.identity();
/*     */   private static final int PA = 32768;
/*     */   private static final int SIGNAL = 28672;
/*     */   private static final String TAG = "VehicleFunction";
/*     */   private final int function;
/*     */   private final SignalFilter mPAFilter;
/*     */   private final SignalFilter mSignalFilter;
/*     */   
/*     */   private VehicleFunction(int paramInt) {
/*  65 */     this.function = paramInt;
/*  66 */     this.mPAFilter = new SignalFilter();
/*  67 */     this.mSignalFilter = new SignalFilter();
/*     */   }
/*     */   
/*     */   public static IVehicleFunction<Integer> intFunction(int paramInt) {
/*  71 */     return new VehicleFunction<>(paramInt);
/*     */   }
/*     */   
/*     */   public static IVehicleFunction<Float> customFunction(int paramInt) {
/*  75 */     return new VehicleFunction<>(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VehicleFunction<T> supportedFunctionValue(int... paramVarArgs) {
/*  81 */     this.values = paramVarArgs;
/*  82 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public IVehicleFunction<T> supportDriverSide(Function<Integer, Integer> paramFunction) {
/*  87 */     this.convertDriverSide = paramFunction;
/*  88 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IVehicleFunction.IZone<T> createZone(VehicleType paramVehicleType, int... paramVarArgs) {
/*  94 */     ZoneTask<T> zoneTask = new ZoneTask(this, paramVehicleType, paramVarArgs);
/*  95 */     zoneTask.supportedFunctionValue(this.values); byte b; int i;
/*  96 */     for (i = paramVarArgs.length, b = 0; b < i; ) { int j = paramVarArgs[b];
/*  97 */       this.zones.add(Integer.valueOf(j));
/*  98 */       addTask(zoneTask); b++; }
/*     */     
/* 100 */     return zoneTask;
/*     */   }
/*     */   
/*     */   public int getFunction() {
/* 104 */     return this.function;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZoneTask<T> getZoneTask(VehicleType paramVehicleType, int paramInt) {
/* 114 */     SparseArray sparseArray = (SparseArray)this.mZoneTasks.get(((Integer)this.convertDriverSide.apply(Integer.valueOf(paramInt))).intValue());
/* 115 */     if (sparseArray != null) {
/* 116 */       paramInt = paramVehicleType.ordinal(); paramVehicleType = VehicleType.COMMON;
/* 117 */       ZoneTask zoneTask = (ZoneTask)sparseArray.get(paramVehicleType.ordinal()); return (ZoneTask<T>)sparseArray.get(paramInt, zoneTask);
/*     */     } 
/* 119 */     return null;
/*     */   }
/*     */   
/*     */   public int[] getZones() {
/* 123 */     return this.zones.stream().mapToInt(-$$Lambda$VehicleFunction$kqW3OCT0jopV1F5ukATwRAdLwZM.INSTANCE).toArray();
/*     */   }
/*     */   
/*     */   private void addTask(ZoneTask<T> paramZoneTask) {
/* 127 */     VehicleType vehicleType = paramZoneTask.getVehicleType();
/* 128 */     int i = paramZoneTask.getZone();
/* 129 */     SparseArray sparseArray2 = (SparseArray)this.mZoneTasks.get(i);
/* 130 */     SparseArray sparseArray1 = sparseArray2; if (sparseArray2 == null) {
/* 131 */       sparseArray1 = new SparseArray();
/* 132 */       this.mZoneTasks.put(i, sparseArray1);
/*     */     } 
/* 134 */     sparseArray1.put(vehicleType.ordinal(), paramZoneTask);
/* 135 */     this.mTasks.add(paramZoneTask);
/*     */   }
/*     */   
/*     */   public void addPAOrSignal(int paramInt) {
/* 139 */     int i = 0xFFFF & paramInt;
/* 140 */     if (i >= 32768) {
/* 141 */       this.mPAFilter.add(Integer.valueOf(paramInt));
/* 142 */     } else if (i >= 28672) {
/* 143 */       this.mSignalFilter.add(Integer.valueOf(paramInt));
/*     */     } else {
/* 145 */       StringBuilder stringBuilder = new StringBuilder(); i = this.function;
/* 146 */       stringBuilder.append(CarLog.funId2Str(i)); stringBuilder.append(" not found the propertyId 0x");
/* 147 */       stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" is PA or Signal"); String str = stringBuilder.toString();
/*     */       Log.i("VehicleFunction", str);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<ZoneTask<T>> getZoneTasks() {
/* 153 */     return this.mTasks;
/*     */   }
/*     */   
/*     */   public Set<Integer> getPropertyList() {
/* 157 */     return this.mPropertyList;
/*     */   }
/*     */   
/*     */   public Set<IVehicleFunction.IAssociatedStatus<T>> getAssociatedStatusList() {
/* 161 */     return this.mAssociatedStatusList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void tryRegisterFunctionSignal(AbsCarFunction paramAbsCarFunction) {
/* 166 */     if ((this.mPAFilter.getFilterCount() > 0 || this.mSignalFilter.getFilterCount() > 0) && 
/* 167 */       this.isRegister.compareAndSet(false, true)) {
/* 168 */       this.isRegister.set(paramAbsCarFunction.registerPAOrSignal(this.mPAFilter, this.mSignalFilter));
/*     */       
/* 170 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("The Function "); int i = this.function;
/* 171 */       stringBuilder.append(CarLog.funValue2Str(i)); stringBuilder.append(" registerSignalOrPAProperties "); stringBuilder.append(this.isRegister); String str = stringBuilder.toString();
/*     */       Log.i("VehicleFunction", str);
/*     */     } 
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
/*     */   public static class ZoneTask<T>
/*     */     implements IVehicleFunction.IZone<T>
/*     */   {
/* 187 */     private final VehicleFunction.Data<T> mData = new VehicleFunction.Data<>();
/*     */     
/* 189 */     private final List<Integer> properties = new ArrayList<>();
/*     */ 
/*     */     
/* 192 */     private int eventSupportValueSignal = -1;
/* 193 */     private IVehicleFunction.SupportFunctionValue mSupportFunctionValueFn = -$$Lambda$VehicleFunction$ZoneTask$sxzEYgyr-lYXsITYqrGBhfDYQHg.INSTANCE;
/*     */     
/*     */     private Function<T, ApiResult> mSetFunctionValueFn;
/*     */     
/*     */     private IVehicleFunction.IStatus<T> mStatusTask;
/*     */     private IVehicleFunction.IValue<T> mValueTask;
/*     */     private final VehicleFunction<T> mVehicleFunction;
/*     */     private final VehicleType mVehicleType;
/*     */     private final int[] mZone;
/*     */     
/*     */     public ZoneTask(VehicleFunction<T> param1VehicleFunction, VehicleType param1VehicleType, int... param1VarArgs) {
/* 204 */       this.mVehicleFunction = param1VehicleFunction;
/* 205 */       this.mVehicleType = param1VehicleType;
/* 206 */       this.mZone = param1VarArgs;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IZone<T> supportedFunctionValue(IVehicleFunction.SupportFunctionValue param1SupportFunctionValue, int... param1VarArgs) {
/* 211 */       this.mSupportFunctionValueFn = param1SupportFunctionValue;
/* 212 */       if (param1VarArgs.length > 0) {
/* 213 */         Stream<Integer> stream = Arrays.stream(param1VarArgs).boxed();
/* 214 */         Collector<?, ?, List<?>> collector = Collectors.toList(); Collection<? extends Integer> collection = stream.collect((Collector)collector);
/* 215 */         this.properties.addAll(collection);
/* 216 */         this.mVehicleFunction.mPropertyList.addAll(collection);
/*     */       } 
/* 218 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IStatusTaskBuild<T> supportedFunctionValue(int param1Int, IVehicleFunction.SupportFunctionValue param1SupportFunctionValue, int... param1VarArgs) {
/* 224 */       this.eventSupportValueSignal = param1Int;
/* 225 */       this.mSupportFunctionValueFn = param1SupportFunctionValue;
/* 226 */       if (param1Int != -1) {
/* 227 */         this.properties.add(Integer.valueOf(param1Int));
/* 228 */         this.mVehicleFunction.mPropertyList.add(Integer.valueOf(param1Int));
/*     */       } 
/* 230 */       if (param1VarArgs.length > 0) {
/* 231 */         Stream<Integer> stream = Arrays.stream(param1VarArgs).boxed();
/* 232 */         Collector<?, ?, List<?>> collector = Collectors.toList(); Collection<? extends Integer> collection = stream.collect((Collector)collector);
/* 233 */         this.properties.addAll(collection);
/* 234 */         this.mVehicleFunction.mPropertyList.addAll(collection);
/*     */       } 
/* 236 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IValueTaskBuild<T> customStatus(Supplier<FunctionStatus> param1Supplier) {
/* 241 */       VehicleFunction.CustomStatus<T> customStatus = new VehicleFunction.CustomStatus<>(this.mVehicleFunction, this, param1Supplier);
/* 242 */       this.mStatusTask = customStatus;
/* 243 */       return customStatus;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IValueTaskBuild<T> useOtherFunctionStatus(int param1Int) {
/* 248 */       VehicleFunction.AssociatedStatus<T> associatedStatus = new VehicleFunction.AssociatedStatus<>(this.mVehicleFunction, this, param1Int);
/*     */       
/* 250 */       this.mStatusTask = associatedStatus;
/* 251 */       this.mVehicleFunction.mAssociatedStatusList.add(associatedStatus);
/* 252 */       return associatedStatus;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <PA_TYPE> IVehicleFunction.IValueTaskBuild<T> useStatusPA(int param1Int, Function<PA_TYPE, FunctionStatus> param1Function) {
/* 258 */       VehicleFunction.SinglePATask<T, Object> singlePATask = new VehicleFunction.SinglePATask<>(this.mVehicleFunction, this, param1Int);
/*     */       
/* 260 */       singlePATask.mapToAdapterApiStatus((Function)param1Function);
/* 261 */       this.mVehicleFunction.mPropertyList.add(Integer.valueOf(param1Int));
/* 262 */       this.properties.add(Integer.valueOf(param1Int));
/* 263 */       this.mStatusTask = singlePATask;
/* 264 */       return singlePATask;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IMultiSignalStatus<T> useStatusSignals(int... param1VarArgs) {
/* 269 */       VehicleFunction.MultiSignalTask<T> multiSignalTask = new VehicleFunction.MultiSignalTask<>(this.mVehicleFunction, this, param1VarArgs);
/*     */       
/* 271 */       Stream<Integer> stream = Arrays.stream(param1VarArgs).boxed();
/* 272 */       Collector<?, ?, List<?>> collector = Collectors.toList(); Collection<? extends Integer> collection = stream.collect((Collector)collector);
/* 273 */       this.mVehicleFunction.mPropertyList.addAll(collection);
/* 274 */       this.properties.addAll(collection);
/* 275 */       this.mStatusTask = multiSignalTask;
/* 276 */       return multiSignalTask;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IValueTaskBuild<T> useStatusSignal(int param1Int, Function<Integer, FunctionStatus> param1Function) {
/* 282 */       VehicleFunction.SingleSignalTask<T> singleSignalTask = new VehicleFunction.SingleSignalTask<>(this.mVehicleFunction, this, param1Int);
/* 283 */       singleSignalTask.mapToAdapterApiStatus(param1Function);
/* 284 */       this.mVehicleFunction.mPropertyList.add(Integer.valueOf(param1Int));
/* 285 */       this.properties.add(Integer.valueOf(param1Int));
/* 286 */       this.mStatusTask = singleSignalTask;
/* 287 */       return singleSignalTask;
/*     */     }
/*     */     
/*     */     public void addProperties(List<Integer> param1List) {
/* 291 */       this.properties.addAll(param1List);
/*     */     }
/*     */     
/*     */     public int getZone() {
/* 295 */       return this.mZone[0];
/*     */     }
/*     */     
/*     */     public VehicleType getVehicleType() {
/* 299 */       return this.mVehicleType;
/*     */     }
/*     */     
/*     */     public int[] getValues() {
/*     */       try {
/* 304 */         return this.mSupportFunctionValueFn.get();
/* 305 */       } catch (Exception exception) {
/* 306 */         Log.e("VehicleFunction", "find a error", exception);
/*     */         
/* 308 */         return new int[0];
/*     */       } 
/*     */     }
/*     */     
/*     */     public IVehicleFunction.IStatus<T> getStatusTask() {
/* 313 */       return this.mStatusTask;
/*     */     }
/*     */     
/*     */     public IVehicleFunction.IValue<T> getValueTask() {
/* 317 */       return this.mValueTask;
/*     */     }
/*     */     
/*     */     public Function<T, ApiResult> getSetFunctionValueFn() {
/* 321 */       return this.mSetFunctionValueFn;
/*     */     }
/*     */     public boolean containerProperty(int param1Int) {
/*     */       boolean bool;
/* 325 */       if (Collections.binarySearch((List)this.properties, Integer.valueOf(param1Int)) >= 0) { bool = true; } else { bool = false; }  return bool;
/*     */     }
/*     */     
/*     */     public VehicleFunction.Data<T> getData(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 329 */       this.mData.setStatus(this.mStatusTask.getStatusWithPropertyId(param1AbsCarFunction, param1Int));
/* 330 */       if (this.eventSupportValueSignal == -1 || param1Int == this.eventSupportValueSignal)
/*     */       {
/* 332 */         this.mData.setSupportValues(getValues());
/*     */       }
/* 334 */       if (this.mValueTask != null) {
/* 335 */         VehicleFunction.Data<T> data = this.mData; IVehicleFunction.Mode mode = this.mValueTask.getCallbackMode(); boolean bool = this.mValueTask.canNotify(param1AbsCarFunction); IVehicleFunction.IValue<T> iValue = this.mValueTask;
/* 336 */         param1AbsCarFunction = (AbsCarFunction)iValue.getValueWithPropertyId(param1AbsCarFunction, param1Int); data.setValue(mode, bool, (T)param1AbsCarFunction);
/*     */       } 
/* 338 */       return this.mData;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getFunctionId() {
/* 343 */       return this.mVehicleFunction.function;
/*     */     }
/*     */     
/*     */     public ApiResult callSetFunction(T param1T) {
/* 347 */       if (this.mSetFunctionValueFn != null) {
/* 348 */         return this.mSetFunctionValueFn.apply(param1T);
/*     */       }
/*     */       
/* 351 */       return ApiResult.INVALID;
/*     */     }
/*     */     
/*     */     private void lazyCreateZoneTask() {
/* 355 */       Collections.sort(this.properties);
/* 356 */       if (this.mZone.length == 1) {
/* 357 */         this.mVehicleFunction.addTask(this);
/*     */       } else {
/* 359 */         for (int i : this.mZone) {
/* 360 */           ZoneTask zoneTask = new ZoneTask(this.mVehicleFunction, this.mVehicleType, new int[] { i });
/*     */           
/* 362 */           zoneTask.mSupportFunctionValueFn = this.mSupportFunctionValueFn;
/* 363 */           zoneTask.mStatusTask = getStatusTask();
/* 364 */           zoneTask.mValueTask = getValueTask();
/* 365 */           zoneTask.mSetFunctionValueFn = getSetFunctionValueFn();
/* 366 */           zoneTask.addProperties(this.properties);
/* 367 */           this.mVehicleFunction.addTask(zoneTask);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CustomStatus<T>
/*     */     extends AbsTask<T>
/*     */     implements IVehicleFunction.IStatus<T>
/*     */   {
/*     */     private final Supplier<FunctionStatus> mFunctionStatusFn;
/*     */     
/*     */     public CustomStatus(VehicleFunction<T> param1VehicleFunction, VehicleFunction.ZoneTask<T> param1ZoneTask, Supplier<FunctionStatus> param1Supplier) {
/* 381 */       super(param1VehicleFunction, param1ZoneTask);
/* 382 */       this.mFunctionStatusFn = param1Supplier;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FunctionStatus getStatusWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 389 */       FunctionStatus functionStatus = FunctionStatus.notavailable;
/*     */       try {
/* 391 */         FunctionStatus functionStatus1 = this.mFunctionStatusFn.get();
/* 392 */       } catch (Exception exception) {
/* 393 */         Log.e("VehicleFunction", "getStatus has a error", exception);
/*     */       } 
/* 395 */       return functionStatus;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AssociatedStatus<T>
/*     */     extends AbsTask<T>
/*     */     implements IVehicleFunction.IAssociatedStatus<T>
/*     */   {
/*     */     private final int functionId;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AssociatedStatus(VehicleFunction<T> param1VehicleFunction, VehicleFunction.ZoneTask<T> param1ZoneTask, int param1Int) {
/* 412 */       super(param1VehicleFunction, param1ZoneTask);
/* 413 */       this.functionId = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FunctionStatus getStatusWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 420 */       return param1AbsCarFunction.isFunctionSupported(this.functionId, getZone());
/*     */     }
/*     */ 
/*     */     
/*     */     public int getAssociatedFunction() {
/* 425 */       return this.functionId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SinglePATask<T, PA_TYPE>
/*     */     extends AbsTask<T>
/*     */     implements IVehicleFunction.IStatus<T>, IVehicleFunction.IValue<T>, IVehicleFunction.IFilterCallback<T, PA_TYPE>
/*     */   {
/*     */     private final int paId;
/*     */ 
/*     */     
/*     */     private Function<PA_TYPE, T> mFunctionValueFn;
/*     */ 
/*     */     
/*     */     private Function<PA_TYPE, FunctionStatus> mFunctionStatusFn;
/*     */ 
/*     */     
/* 444 */     private Predicate<PA_TYPE> mFilter = -$$Lambda$VehicleFunction$SinglePATask$s2M95GckYU4EsqFVX0-sklToXYs.INSTANCE;
/*     */     
/* 446 */     private IVehicleFunction.Mode mCallbackMode = IVehicleFunction.Mode.VALUE_CHANGE;
/*     */ 
/*     */ 
/*     */     
/*     */     public SinglePATask(VehicleFunction<T> param1VehicleFunction, VehicleFunction.ZoneTask<T> param1ZoneTask, int param1Int) {
/* 451 */       super(param1VehicleFunction, param1ZoneTask);
/* 452 */       this.paId = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FunctionStatus getStatusWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 459 */       FunctionStatus functionStatus1, functionStatus2 = FunctionStatus.notavailable;
/*     */       try {
/* 461 */         functionStatus1 = this.mFunctionStatusFn.apply((PA_TYPE)param1AbsCarFunction.getPAData(this.paId));
/* 462 */       } catch (Exception exception) {
/* 463 */         Log.e("VehicleFunction", "getStatus has a error", exception); functionStatus1 = functionStatus2;
/*     */       } 
/* 465 */       return functionStatus1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void mapToAdapterApiStatus(Function<PA_TYPE, FunctionStatus> param1Function) {
/* 470 */       this.mFunctionStatusFn = param1Function;
/*     */     }
/*     */ 
/*     */     
/*     */     public T getValueWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 475 */       Exception exception2 = null;
/*     */       try {
/* 477 */         param1AbsCarFunction = (AbsCarFunction)this.mFunctionValueFn.apply((PA_TYPE)param1AbsCarFunction.getPAData(this.paId));
/* 478 */       } catch (Exception exception1) {
/* 479 */         Log.e("VehicleFunction", "getValue has a error", exception1); exception1 = exception2;
/*     */       } 
/* 481 */       return (T)exception1;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canNotify(AbsCarFunction param1AbsCarFunction) {
/* 486 */       return this.mFilter.test((PA_TYPE)param1AbsCarFunction.getPAData(this.paId));
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.Mode getCallbackMode() {
/* 491 */       return this.mCallbackMode;
/*     */     }
/*     */ 
/*     */     
/*     */     public void mapToAdapterApiValue(Function<PA_TYPE, T> param1Function) {
/* 496 */       this.mFunctionValueFn = param1Function;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.ITaskEnd<T> filterValue(IVehicleFunction.Mode param1Mode, Predicate<PA_TYPE> param1Predicate) {
/* 501 */       this.mCallbackMode = param1Mode;
/* 502 */       this.mFilter = param1Predicate;
/* 503 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SingleSignalTask<T>
/*     */     extends AbsTask<T>
/*     */     implements IVehicleFunction.IStatus<T>, IVehicleFunction.IValue<T>, IVehicleFunction.IFilterCallback<T, Integer>
/*     */   {
/*     */     private final int signalId;
/*     */ 
/*     */     
/*     */     private Function<Integer, T> mFunctionValueFn;
/*     */ 
/*     */     
/*     */     private Function<Integer, FunctionStatus> mFunctionStatusFn;
/*     */ 
/*     */     
/* 523 */     private Predicate<Integer> mFilter = -$$Lambda$VehicleFunction$SingleSignalTask$9weHMZN6JycCDDWb81_v3rqS5RM.INSTANCE;
/*     */     
/* 525 */     private IVehicleFunction.Mode mCallbackMode = IVehicleFunction.Mode.VALUE_CHANGE;
/*     */ 
/*     */     
/*     */     public SingleSignalTask(VehicleFunction<T> param1VehicleFunction, VehicleFunction.ZoneTask<T> param1ZoneTask, int param1Int) {
/* 529 */       super(param1VehicleFunction, param1ZoneTask);
/* 530 */       this.signalId = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public FunctionStatus getStatusWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 536 */       FunctionStatus functionStatus1, functionStatus2 = FunctionStatus.notavailable;
/*     */       try {
/* 538 */         functionStatus1 = this.mFunctionStatusFn.apply(Integer.valueOf(param1AbsCarFunction.getSignalValue(this.signalId)));
/* 539 */       } catch (Exception exception) {
/* 540 */         Log.e("VehicleFunction", "getStatus has a error", exception); functionStatus1 = functionStatus2;
/*     */       } 
/* 542 */       return functionStatus1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void mapToAdapterApiStatus(Function<Integer, FunctionStatus> param1Function) {
/* 547 */       this.mFunctionStatusFn = param1Function;
/*     */     }
/*     */ 
/*     */     
/*     */     public T getValueWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 552 */       Exception exception2 = null;
/*     */       try {
/* 554 */         param1AbsCarFunction = (AbsCarFunction)this.mFunctionValueFn.apply(Integer.valueOf(param1AbsCarFunction.getSignalValue(this.signalId)));
/* 555 */       } catch (Exception exception1) {
/* 556 */         Log.e("VehicleFunction", "getValue has a error", exception1); exception1 = exception2;
/*     */       } 
/* 558 */       return (T)exception1;
/*     */     }
/*     */     
/*     */     public void mapToAdapterApiValue(Function<Integer, T> param1Function) {
/* 562 */       this.mFunctionValueFn = param1Function;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canNotify(AbsCarFunction param1AbsCarFunction) {
/* 567 */       return this.mFilter.test(Integer.valueOf(param1AbsCarFunction.getSignalValue(this.signalId)));
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.Mode getCallbackMode() {
/* 572 */       return this.mCallbackMode;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.ITaskEnd<T> filterValue(IVehicleFunction.Mode param1Mode, Predicate<Integer> param1Predicate) {
/* 577 */       this.mCallbackMode = param1Mode;
/* 578 */       this.mFilter = param1Predicate;
/* 579 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class MultiSignalTask<T>
/*     */     extends AbsTask<T>
/*     */     implements IVehicleFunction.IMultiSignalStatus<T>, IVehicleFunction.IMultiSignalValue<T>, IVehicleFunction.IFilterCallback<T, Void>
/*     */   {
/* 592 */     private int eventStatusSignal = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 597 */     private int eventValueSignal = -1;
/*     */ 
/*     */ 
/*     */     
/* 601 */     private Predicate<Void> mFilter = -$$Lambda$VehicleFunction$MultiSignalTask$jPI_JrUdPeM1o5f_VCOUC0qKImU.INSTANCE;
/*     */     
/* 603 */     private IVehicleFunction.Mode mCallbackMode = IVehicleFunction.Mode.VALUE_CHANGE; private FunctionStatus mCurrentStatus;
/*     */     private T mCurrentValue;
/*     */     
/*     */     public MultiSignalTask(VehicleFunction<T> param1VehicleFunction, VehicleFunction.ZoneTask<T> param1ZoneTask, int... param1VarArgs) {
/* 607 */       super(param1VehicleFunction, param1ZoneTask);
/* 608 */       this.signals = param1VarArgs;
/*     */     }
/*     */     private Supplier<FunctionStatus> mPAStatusChangeFn; private Supplier<T> mPAValueChangeFn; private final int[] signals;
/*     */     
/*     */     public FunctionStatus getStatus(AbsCarFunction param1AbsCarFunction) {
/* 613 */       return this.mPAStatusChangeFn.get();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public FunctionStatus getStatusWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 619 */       if (param1Int == -1 || this.eventStatusSignal == -1 || param1Int == this.eventStatusSignal) {
/* 620 */         this.mCurrentStatus = this.mPAStatusChangeFn.get();
/*     */       }
/* 622 */       return this.mCurrentStatus;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IValueTaskBuild<T> onStatusSignalChanged(int param1Int, Supplier<FunctionStatus> param1Supplier) {
/* 629 */       if (param1Int != -1) {
/* 630 */         this.mZoneTask.properties.add(Integer.valueOf(param1Int));
/* 631 */         this.mVehicleFunction.mPropertyList.add(Integer.valueOf(param1Int));
/*     */       } 
/* 633 */       this.eventStatusSignal = param1Int;
/* 634 */       this.mPAStatusChangeFn = param1Supplier;
/* 635 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public T getValueWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/* 641 */       if (param1Int == -1 || this.eventValueSignal == -1 || this.eventValueSignal == param1Int) {
/*     */         try {
/* 643 */           this.mCurrentValue = this.mPAValueChangeFn.get();
/* 644 */         } catch (Exception exception) {
/* 645 */           Log.i("VehicleFunction", "getValue has a error", exception);
/*     */         } 
/*     */       }
/* 648 */       return this.mCurrentValue;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IFilterCallback<T, Void> onValueSignalChanged(int param1Int, Supplier<T> param1Supplier) {
/* 653 */       if (param1Int != -1) {
/* 654 */         this.mZoneTask.properties.add(Integer.valueOf(param1Int));
/* 655 */         this.mVehicleFunction.mPropertyList.add(Integer.valueOf(param1Int));
/*     */       } 
/* 657 */       this.eventValueSignal = param1Int;
/* 658 */       this.mPAValueChangeFn = param1Supplier;
/* 659 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canNotify(AbsCarFunction param1AbsCarFunction) {
/* 664 */       return this.mFilter.test(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.Mode getCallbackMode() {
/* 669 */       return this.mCallbackMode;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.ITaskEnd<T> filterValue(IVehicleFunction.Mode param1Mode, Predicate<Void> param1Predicate) {
/* 674 */       this.mCallbackMode = param1Mode;
/* 675 */       this.mFilter = param1Predicate;
/* 676 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CustomValueTask<T>
/*     */     extends AbsTask<T>
/*     */     implements IVehicleFunction.IValue<T>, IVehicleFunction.IFilterCallback<T, Void>
/*     */   {
/*     */     private final Supplier<T> mFunctionValueFn;
/* 686 */     private Predicate<Void> mFilter = -$$Lambda$VehicleFunction$CustomValueTask$QmaZ6uOSMp9ZTdUBP8njwKp5Fng.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 692 */     private IVehicleFunction.Mode mCallbackMode = IVehicleFunction.Mode.VALUE_CHANGE;
/*     */ 
/*     */ 
/*     */     
/*     */     public CustomValueTask(VehicleFunction<T> param1VehicleFunction, VehicleFunction.ZoneTask<T> param1ZoneTask, Supplier<T> param1Supplier) {
/* 697 */       super(param1VehicleFunction, param1ZoneTask);
/* 698 */       this.mFunctionValueFn = param1Supplier;
/*     */     }
/*     */     
/*     */     public T getValueWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int) {
/*     */       T t;
/* 703 */       param1AbsCarFunction = null;
/*     */       try {
/* 705 */         T t1 = this.mFunctionValueFn.get();
/* 706 */       } catch (Exception exception) {
/* 707 */         Log.i("VehicleFunction", "getValue has a error", exception);
/*     */       } 
/* 709 */       return t;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canNotify(AbsCarFunction param1AbsCarFunction) {
/* 714 */       return this.mFilter.test(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.Mode getCallbackMode() {
/* 719 */       return this.mCallbackMode;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public IVehicleFunction.ITaskEnd<T> filterValue(IVehicleFunction.Mode param1Mode, Predicate<Void> param1Predicate) {
/* 725 */       this.mCallbackMode = param1Mode;
/* 726 */       this.mFilter = param1Predicate;
/* 727 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class AbsTask<T>
/*     */     implements IVehicleFunction.ITask<T>, IVehicleFunction.IValueTaskBuild<T>, IVehicleFunction.ITaskEnd<T>
/*     */   {
/*     */     protected final VehicleFunction<T> mVehicleFunction;
/*     */ 
/*     */     
/*     */     protected final VehicleFunction.ZoneTask<T> mZoneTask;
/*     */ 
/*     */ 
/*     */     
/*     */     public AbsTask(VehicleFunction<T> param1VehicleFunction, VehicleFunction.ZoneTask<T> param1ZoneTask) {
/* 744 */       this.mVehicleFunction = param1VehicleFunction;
/* 745 */       this.mZoneTask = param1ZoneTask;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IFilterCallback<T, Void> customValue(Supplier<T> param1Supplier) {
/* 750 */       VehicleFunction.CustomValueTask<T> customValueTask = new VehicleFunction.CustomValueTask<>(this.mVehicleFunction, this.mZoneTask, param1Supplier);
/*     */       
/* 752 */       VehicleFunction.ZoneTask.access$502(this.mZoneTask, customValueTask);
/* 753 */       return customValueTask;
/*     */     }
/*     */ 
/*     */     
/*     */     public <PA_TYPE> IVehicleFunction.IFilterCallback<T, PA_TYPE> useValuePA(int param1Int, Function<PA_TYPE, T> param1Function) {
/* 758 */       VehicleFunction.SinglePATask<T, Object> singlePATask = new VehicleFunction.SinglePATask<>(this.mVehicleFunction, this.mZoneTask, param1Int);
/*     */       
/* 760 */       singlePATask.mapToAdapterApiValue((Function)param1Function);
/* 761 */       this.mZoneTask.properties.add(Integer.valueOf(param1Int));
/* 762 */       this.mVehicleFunction.mPropertyList.add(Integer.valueOf(param1Int));
/* 763 */       VehicleFunction.ZoneTask.access$502(this.mZoneTask, singlePATask);
/* 764 */       return (IVehicleFunction.IFilterCallback)singlePATask;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IMultiSignalValue<T> useValueSignals(int... param1VarArgs) {
/* 769 */       VehicleFunction.MultiSignalTask<T> multiSignalTask = new VehicleFunction.MultiSignalTask<>(this.mVehicleFunction, this.mZoneTask, param1VarArgs);
/*     */       
/* 771 */       Stream<Integer> stream = Arrays.stream(param1VarArgs).boxed();
/* 772 */       Collector<?, ?, List<?>> collector = Collectors.toList(); Collection collection = stream.collect((Collector)collector);
/* 773 */       this.mZoneTask.properties.addAll(collection);
/* 774 */       this.mVehicleFunction.mPropertyList.addAll(collection);
/* 775 */       VehicleFunction.ZoneTask.access$502(this.mZoneTask, multiSignalTask);
/* 776 */       return multiSignalTask;
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IFilterCallback<T, Integer> useValueSignal(int param1Int, Function<Integer, T> param1Function) {
/* 781 */       VehicleFunction.SingleSignalTask<T> singleSignalTask = new VehicleFunction.SingleSignalTask<>(this.mVehicleFunction, this.mZoneTask, param1Int);
/*     */       
/* 783 */       singleSignalTask.mapToAdapterApiValue(param1Function);
/* 784 */       this.mZoneTask.properties.add(Integer.valueOf(param1Int));
/* 785 */       this.mVehicleFunction.mPropertyList.add(Integer.valueOf(param1Int));
/* 786 */       VehicleFunction.ZoneTask.access$502(this.mZoneTask, singleSignalTask);
/* 787 */       return singleSignalTask;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IValueTaskBuild<T> onSetFunctionValue(Function<T, ApiResult> param1Function) {
/* 794 */       VehicleFunction.ZoneTask.access$602(this.mZoneTask, new -$$Lambda$VehicleFunction$AbsTask$g2AavIeTQ_3QG9019e0YFm2qjn0(param1Function));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 803 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getFunctionId() {
/* 808 */       return this.mVehicleFunction.function;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getZone() {
/* 813 */       return this.mZoneTask.getZone();
/*     */     }
/*     */ 
/*     */     
/*     */     public IVehicleFunction.IZone<T> createZone(VehicleType param1VehicleType, int... param1VarArgs) {
/* 818 */       this.mZoneTask.lazyCreateZoneTask();
/* 819 */       return this.mVehicleFunction.createZone(param1VehicleType, param1VarArgs);
/*     */     }
/*     */ 
/*     */     
/*     */     public void addTo(Consumer<VehicleFunction<T>> param1Consumer) {
/* 824 */       this.mZoneTask.lazyCreateZoneTask();
/* 825 */       param1Consumer.accept(this.mVehicleFunction);
/*     */     } }
/*     */   
/*     */   public static class Data<T> {
/*     */     private FunctionStatus mStatus;
/*     */     private int[] mSupportValues;
/*     */     private T mValue;
/*     */     private boolean statusChanged;
/*     */     private boolean supportValueChanged;
/*     */     private boolean valueChanged;
/*     */     
/*     */     public Data() {
/* 837 */       this.mSupportValues = new int[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FunctionStatus getStatus() {
/* 845 */       return this.mStatus;
/*     */     }
/*     */     public void setStatus(FunctionStatus param1FunctionStatus) {
/*     */       boolean bool;
/* 849 */       if (this.mStatus != param1FunctionStatus) { bool = true; } else { bool = false; }  this.statusChanged = bool;
/* 850 */       this.mStatus = param1FunctionStatus;
/*     */     }
/*     */     
/*     */     public T getValue() {
/* 854 */       return this.mValue;
/*     */     }
/*     */     
/*     */     public void setValue(IVehicleFunction.Mode param1Mode, boolean param1Boolean, T param1T) {
/* 858 */       boolean bool = false; if (param1T != null) {
/* 859 */         this.valueChanged = false;
/* 860 */         if (this.mStatus != FunctionStatus.notavailable) {
/* 861 */           if (param1Mode == IVehicleFunction.Mode.ALWAYS) {
/* 862 */             this.valueChanged = param1Boolean;
/*     */           } else {
/* 864 */             boolean bool1 = bool; if (param1Boolean) { bool1 = bool; if (!param1T.equals(this.mValue)) bool1 = true;  }  this.valueChanged = bool1;
/*     */           } 
/*     */         }
/* 867 */         this.mValue = param1T;
/*     */       } else {
/* 869 */         this.valueChanged = false;
/*     */       } 
/*     */     }
/*     */     
/*     */     public int[] getSupportValues() {
/* 874 */       return this.mSupportValues;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSupportValues(int[] param1ArrayOfint) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield mStatus : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*     */       //   4: getstatic com/ecarx/xui/adaptapi/FunctionStatus.notavailable : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*     */       //   7: if_acmpeq -> 28
/*     */       //   10: aload_0
/*     */       //   11: getfield mSupportValues : [I
/*     */       //   14: astore_3
/*     */       //   15: aload_3
/*     */       //   16: aload_1
/*     */       //   17: invokestatic equals : ([I[I)Z
/*     */       //   20: ifne -> 28
/*     */       //   23: iconst_1
/*     */       //   24: istore_2
/*     */       //   25: goto -> 30
/*     */       //   28: iconst_0
/*     */       //   29: istore_2
/*     */       //   30: aload_0
/*     */       //   31: iload_2
/*     */       //   32: putfield supportValueChanged : Z
/*     */       //   35: aload_0
/*     */       //   36: aload_1
/*     */       //   37: putfield mSupportValues : [I
/*     */       //   40: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #878	-> 0
/*     */       //   #879	-> 15
/*     */       //   #880	-> 35
/*     */       //   #881	-> 40
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isStatusChanged() {
/* 884 */       return this.statusChanged;
/*     */     }
/*     */     
/*     */     public boolean isValueChanged() {
/* 888 */       return this.valueChanged;
/*     */     }
/*     */     
/*     */     public boolean isSupportValueChanged() {
/* 892 */       return this.supportValueChanged;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 897 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Data{mStatus="); stringBuilder.append(this.mStatus); stringBuilder.append(", mSupportValues="); int[] arrayOfInt = this.mSupportValues;
/*     */       
/* 899 */       stringBuilder.append(Arrays.toString(arrayOfInt)); stringBuilder.append(", mValue="); stringBuilder.append(this.mValue); stringBuilder.append(", statusChanged="); stringBuilder.append(this.statusChanged); stringBuilder.append(", supportValueChanged="); stringBuilder.append(this.supportValueChanged); stringBuilder.append(", valueChanged="); stringBuilder.append(this.valueChanged); stringBuilder.append('}'); return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\VehicleFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */