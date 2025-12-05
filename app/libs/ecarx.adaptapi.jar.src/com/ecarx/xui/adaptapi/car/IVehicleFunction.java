/*     */ package com.ecarx.xui.adaptapi.car;
/*     */ 
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.SignalUtils;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface IVehicleFunction<T>
/*     */ {
/*     */   default IZone<T> createZone() {
/*  47 */     return createZone(new int[] { Integer.MIN_VALUE });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default IZone<T> createZone(VehicleType paramVehicleType) {
/*  56 */     return createZone(paramVehicleType, new int[] { Integer.MIN_VALUE });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   IZone<T> createZone(VehicleType paramVehicleType, int... paramVarArgs);
/*     */ 
/*     */   
/*     */   IZone<T> createZone(int... paramVarArgs) {
/*  65 */     return createZone(VehicleType.COMMON, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   IVehicleFunction<T> supportDriverSide(Function<Integer, Integer> paramFunction);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   IVehicleFunction<T> supportedFunctionValue(int... paramVarArgs);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IZone<T>
/*     */     extends IStatusTaskBuild<T>
/*     */   {
/*     */     IVehicleFunction.IStatusTaskBuild<T> supportedFunctionValue(int... param1VarArgs) {
/*  94 */       return supportedFunctionValue(-1, new -$$Lambda$IVehicleFunction$IZone$ancXYsyt59lRoUqPbT0KycbX5gs(param1VarArgs), new int[0]);
/*     */     }
/*     */     
/*     */     IVehicleFunction.IStatusTaskBuild<T> supportedFunctionValue(IVehicleFunction.SupportFunctionValue param1SupportFunctionValue, int... param1VarArgs) {
/*  98 */       return supportedFunctionValue(-1, param1SupportFunctionValue, param1VarArgs);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.IStatusTaskBuild<T> supportedFunctionValue(int param1Int, IVehicleFunction.SupportFunctionValue param1SupportFunctionValue, int... param1VarArgs);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IStatusTaskBuild<T>
/*     */   {
/*     */     default IVehicleFunction.IValueTaskBuild<T> useStatusPAByIntBase(int param1Int) {
/* 174 */       return useStatusPAByIntBase(param1Int, -$$Lambda$IVehicleFunction$IStatusTaskBuild$qB4ZH0MkIIcZKfoIgKpSLK7fdxE.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IValueTaskBuild<T> useStatusPAByIntBase(int param1Int, Function<PATypes.PA_IntBase, FunctionStatus> param1Function) {
/* 188 */       return useStatusPA(param1Int, param1Function);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IValueTaskBuild<T> fixStatus(FunctionStatus param1FunctionStatus) {
/* 198 */       return customStatus(new -$$Lambda$IVehicleFunction$IStatusTaskBuild$9r4FpRE9SoL40Vy9F-bkQlNnGkI(param1FunctionStatus));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.IValueTaskBuild<T> customStatus(Supplier<FunctionStatus> param1Supplier);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.IValueTaskBuild<T> useOtherFunctionStatus(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     <PA_TYPE> IVehicleFunction.IValueTaskBuild<T> useStatusPA(int param1Int, Function<PA_TYPE, FunctionStatus> param1Function);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.IValueTaskBuild<T> useStatusSignal(int param1Int, Function<Integer, FunctionStatus> param1Function);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.IMultiSignalStatus<T> useStatusSignals(int... param1VarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IValueTaskBuild<T>
/*     */     extends ITaskEnd<T>
/*     */   {
/*     */     default IVehicleFunction.IFilterCallback<T, Integer> useValueSignal(int param1Int, Pairs<Integer, T> param1Pairs) {
/* 249 */       Objects.requireNonNull(param1Pairs); return useValueSignal(param1Int, new -$$Lambda$FOou6kd-rjX7cTTaNTPkS1Txyb4(param1Pairs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IFilterCallback<T, PATypes.PA_IntBase> useValuePAByIntBase(int param1Int, Pairs<Integer, T> param1Pairs) {
/* 275 */       Objects.requireNonNull(param1Pairs); return useValuePAByIntBase(param1Int, new -$$Lambda$FOou6kd-rjX7cTTaNTPkS1Txyb4(param1Pairs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IFilterCallback<T, PATypes.PA_IntBase> useValuePAByIntBase(int param1Int, Function<Integer, T> param1Function) {
/* 287 */       return useValuePA(param1Int, new -$$Lambda$IVehicleFunction$IValueTaskBuild$qcYwlqAdOelBXTLPg30H9KwmgVc(param1Function));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IValueTaskBuild<T> onSetFunctionValue(Function<Integer, ApiResult> param1Function, Function<T, Integer> param1Function1) {
/* 304 */       return onSetFunctionValue(param1Function1.andThen(param1Function));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IValueTaskBuild<T> onSetFunctionValue(Function<Integer, ApiResult> param1Function, Function<T, Integer> param1Function1, Predicate<T> param1Predicate) {
/* 321 */       return onSetFunctionValue(new -$$Lambda$IVehicleFunction$IValueTaskBuild$9eRfQcAKTxTa02JKhXEJHd_s2m8(param1Predicate, param1Function, param1Function1));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IValueTaskBuild<T> onSetFunctionValue(Function<Integer, ApiResult> param1Function, Pairs<T, Integer> param1Pairs) {
/* 341 */       param1Function = new -$$Lambda$IVehicleFunction$IValueTaskBuild$YF4BzoWNM3vheTxezN4H5UwjCpc(param1Function); Objects.requireNonNull(param1Pairs); return onSetFunctionValue(param1Function, new -$$Lambda$5NSQy4Ydkr9myUsIy1g7LE5zCKo(param1Pairs));
/*     */     }
/*     */     
/*     */     IVehicleFunction.IFilterCallback<T, Void> customValue(Supplier<T> param1Supplier);
/*     */     
/*     */     IValueTaskBuild<T> onSetFunctionValue(Function<T, ApiResult> param1Function);
/*     */     
/*     */     <PA_TYPE> IVehicleFunction.IFilterCallback<T, PA_TYPE> useValuePA(int param1Int, Function<PA_TYPE, T> param1Function);
/*     */     
/*     */     IVehicleFunction.IFilterCallback<T, Integer> useValueSignal(int param1Int, Function<Integer, T> param1Function);
/*     */     
/*     */     IVehicleFunction.IMultiSignalValue<T> useValueSignals(int... param1VarArgs);
/*     */   }
/*     */   
/*     */   public static interface IFilterCallback<T, PA_TYPE> extends ITaskEnd<T> {
/*     */     IVehicleFunction.ITaskEnd<T> filterValue(IVehicleFunction.Mode param1Mode, Predicate<PA_TYPE> param1Predicate);
/*     */     
/*     */     default IVehicleFunction.ITaskEnd<T> filterValue(Predicate<PA_TYPE> param1Predicate) {
/* 359 */       return filterValue(IVehicleFunction.Mode.VALUE_CHANGE, param1Predicate);
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
/*     */   
/*     */   public static interface ITaskEnd<T>
/*     */   {
/*     */     void addTo(Consumer<VehicleFunction<T>> param1Consumer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IZone<T> createZone() {
/* 385 */       return createZone(new int[] { Integer.MIN_VALUE });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IZone<T> createZone(VehicleType param1VehicleType) {
/* 394 */       return createZone(param1VehicleType, new int[] { Integer.MIN_VALUE });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.IZone<T> createZone(VehicleType param1VehicleType, int... param1VarArgs);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.IZone<T> createZone(int... param1VarArgs) {
/* 406 */       return createZone(VehicleType.COMMON, param1VarArgs);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IStatus<T>
/*     */     extends ITask<T>
/*     */   {
/*     */     default FunctionStatus getStatus(AbsCarFunction param1AbsCarFunction) {
/* 458 */       return getStatusWithPropertyId(param1AbsCarFunction, -1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FunctionStatus getStatusWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IValue<T>
/*     */     extends ITask<T>
/*     */   {
/*     */     boolean canNotify(AbsCarFunction param1AbsCarFunction);
/*     */ 
/*     */ 
/*     */     
/*     */     IVehicleFunction.Mode getCallbackMode();
/*     */ 
/*     */ 
/*     */     
/*     */     default T getValue(AbsCarFunction param1AbsCarFunction) {
/* 481 */       return getValueWithPropertyId(param1AbsCarFunction, -1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     T getValueWithPropertyId(AbsCarFunction param1AbsCarFunction, int param1Int);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IMultiSignalStatus<T>
/*     */     extends IStatus<T>
/*     */   {
/*     */     IVehicleFunction.IValueTaskBuild<T> onStatusSignalChanged(int param1Int, Supplier<FunctionStatus> param1Supplier);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IValueTaskBuild<T> onStatusSignalChanged(Supplier<FunctionStatus> param1Supplier) {
/* 505 */       return onStatusSignalChanged(-1, param1Supplier);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IMultiSignalValue<T>
/*     */     extends IValue<T>
/*     */   {
/*     */     IVehicleFunction.IFilterCallback<T, Void> onValueSignalChanged(int param1Int, Supplier<T> param1Supplier);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     default IVehicleFunction.IFilterCallback<T, Void> onValueSignalChanged(Supplier<T> param1Supplier) {
/* 524 */       return onValueSignalChanged(-1, param1Supplier);
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
/*     */   public enum Mode
/*     */   {
/* 537 */     ALWAYS, VALUE_CHANGE;
/*     */     private static final Mode[] $VALUES;
/*     */     
/*     */     static {
/*     */       $VALUES = new Mode[] { VALUE_CHANGE, ALWAYS };
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface IAssociatedStatus<T> extends IStatus<T> {
/*     */     int getAssociatedFunction();
/*     */   }
/*     */   
/*     */   public static interface ITask<T> {
/*     */     int getFunctionId();
/*     */     
/*     */     int getZone();
/*     */   }
/*     */   
/*     */   public static interface SupportFunctionValue {
/*     */     int[] get();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\IVehicleFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */