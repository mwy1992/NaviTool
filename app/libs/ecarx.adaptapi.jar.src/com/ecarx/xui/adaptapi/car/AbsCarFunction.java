/*     */ package com.ecarx.xui.adaptapi.car;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.SystemClock;
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import com.ecarx.xui.adaptapi.CallStatus;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.base.ICarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.base.IProFunction;
/*     */ import com.ecarx.xui.adaptapi.car.base.IProValue;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.IntStream;
/*     */ import java.util.stream.Stream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbsCarFunction
/*     */   extends AbsCarSignal
/*     */   implements IProFunction
/*     */ {
/*  40 */   private final List<VehicleFunction<Integer>> mIntFunctions = new ArrayList<>(30);
/*  41 */   private final List<VehicleFunction<Float>> mFloatFunctions = new ArrayList<>(30);
/*  42 */   private final SparseArray<VehicleFunction<Integer>> mFunctionIdToIntFunction = new SparseArray();
/*     */   
/*  44 */   private final SparseArray<VehicleFunction<Float>> mFunctionIdToCustomFunction = new SparseArray();
/*     */ 
/*     */   
/*  47 */   private final SparseArray<List<VehicleFunction<Integer>>> mPropertyToIntFunction = new SparseArray();
/*     */   
/*  49 */   private final SparseArray<List<VehicleFunction<Float>>> mPropertyToCustomFunction = new SparseArray();
/*     */ 
/*     */   
/*  52 */   private final SparseArray<List<IVehicleFunction.IAssociatedStatus<?>>> groupAssociated = new SparseArray();
/*     */ 
/*     */   
/*  55 */   private final SparseArray<ProFunction<?>> mProFunctions = new SparseArray();
/*     */   
/*     */   private boolean isBuildFunctions = false;
/*  58 */   private static final int[] EMPTY_SUPPORT_FUNCTION_VALUE = new int[0];
/*     */ 
/*     */   
/*  61 */   private final Object mCallbackLock = new Object(); private static final int ALL_FUNCTION_ID = -1;
/*     */   private static final int REGISTER_TASK = 1;
/*     */   private static final String TAG = "AbsCarFunction";
/*     */   @GuardedBy("mCallbackLock")
/*     */   private final SparseArray<ArrayList<ICarFunction.IFunctionValueWatcher>> mCallbackArray;
/*     */   private final CarPAEventCallback mPAEventCallback;
/*     */   private final Handler mRegisterHandler;
/*     */   
/*  69 */   protected AbsCarFunction(Context paramContext, int paramInt) { super(paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 496 */     this.mPAEventCallback = new CarPAEventCallback() { final AbsCarFunction this$0;
/*     */         
/*     */         public void onPAChanged(ECarXCarPropertyValue param1ECarXCarPropertyValue) { String str;
/* 499 */           Object object = convertPAData(param1ECarXCarPropertyValue);
/* 500 */           if (object == null) {
/* 501 */             object = AbsCarFunction.this.getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onPAChanged the propertyId 0x");
/* 502 */             stringBuilder.append(Integer.toHexString(param1ECarXCarPropertyValue.getPropertyId())); stringBuilder.append(" convertPAData is null "); str = stringBuilder.toString();
/*     */             Log.i((String)object, str);
/*     */             return;
/*     */           } 
/* 506 */           Log.i(AbsCarFunction.this.getModuleName(), object.toString());
/*     */           
/* 508 */           AbsCarFunction.this.recordPADate(str.getPropertyId(), object);
/* 509 */           int i = str.getPropertyId();
/* 510 */           List list = (List)AbsCarFunction.this.mPropertyToIntFunction.get(i);
/*     */           
/* 512 */           if (list != null) {
/* 513 */             Stream stream = list.stream(); object = new -$$Lambda$AbsCarFunction$1$qwr8X36HB6zeeEVpegSWqO6wCnY(this, i);
/*     */             
/* 515 */             stream = stream.flatMap((Function)object); object = new -$$Lambda$AbsCarFunction$1$F9KcFIMpaDT9zHNITXNwHvjIB1w(this, i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 522 */             stream.forEach((Consumer)object);
/*     */           } 
/* 524 */           list = (List)AbsCarFunction.this.mPropertyToCustomFunction.get(i);
/*     */           
/* 526 */           if (list != null)
/* 527 */           { Stream stream = list.stream(); object = new -$$Lambda$AbsCarFunction$1$ESj4soWjpz127dIb1KluJyZ7pvA(this, i);
/*     */             
/* 529 */             stream = stream.flatMap((Function)object); object = new -$$Lambda$AbsCarFunction$1$S5bVZw7pblh2bjrCKDzLzEJydac(this, i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 536 */             stream.forEach((Consumer)object); }  } }; this.mCallbackArray = new SparseArray(); this.mCallbackArray.put(-1, new ArrayList()); this.mRegisterHandler = new Handler(Looper.getMainLooper(), new -$$Lambda$AbsCarFunction$_Q6kwPJgTR8gWZWt4cb0OfwO6AE(this)); }
/*     */   protected final void onInitCarSignalManager() { onCarSignalConnected(this.mECarXCarSetManager); if (!this.isBuildFunctions) { this.isBuildFunctions = true; buildFunctions(); addSignalFilter(Integer.valueOf(29329)); addSignalFilter(Integer.valueOf(29334)); addSignalFilter(Integer.valueOf(30788)); }  }
/*     */   public final boolean validCarFunction(int paramInt) { if (!validCarFunctionInt(paramInt) && !validCarFunctionFlt(paramInt)) { SparseArray<ProFunction<?>> sparseArray = this.mProFunctions; return (sparseArray.indexOfKey(paramInt) >= 0); }  return true; }
/*     */   public final boolean validCarFunctionInt(int paramInt) { boolean bool; if (this.mFunctionIdToIntFunction.indexOfKey(paramInt) >= 0) { bool = true; } else { bool = false; }  return bool; }
/*     */   public final boolean validCarFunctionFlt(int paramInt) { boolean bool; if (this.mFunctionIdToCustomFunction.indexOfKey(paramInt) >= 0) { bool = true; } else { bool = false; }  return bool; }
/*     */   public FunctionStatus isFunctionSupported(int paramInt) { return isFunctionSupported(paramInt, -2147483648); }
/* 542 */   public FunctionStatus isFunctionSupported(int paramInt1, int paramInt2) { return isFunctionSupported(paramInt1, paramInt2, 0); } public FunctionStatus isFunctionSupported(int paramInt1, int paramInt2, int paramInt3) { FunctionStatus functionStatus2, functionStatus1 = FunctionStatus.notavailable; if (validCarFunctionInt(paramInt1)) { VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToIntFunction.get(paramInt1); VehicleType vehicleType = getVehicleType(); VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(vehicleType, paramInt2); functionStatus2 = functionStatus1; if (zoneTask != null) { IVehicleFunction.IStatus iStatus = zoneTask.getStatusTask(); functionStatus2 = functionStatus1; if (iStatus != null) functionStatus2 = iStatus.getStatus(this);  }  vehicleFunction.tryRegisterFunctionSignal(this); } else { functionStatus2 = functionStatus1; if (validCarFunctionFlt(paramInt1)) { VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToCustomFunction.get(paramInt1); VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(getVehicleType(), paramInt2); functionStatus2 = functionStatus1; if (zoneTask != null) { IVehicleFunction.IStatus iStatus = zoneTask.getStatusTask(); functionStatus2 = functionStatus1; if (iStatus != null) functionStatus2 = iStatus.getStatus(this);  }  vehicleFunction.tryRegisterFunctionSignal(this); }  }  String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isFunctionSupported function "); stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone "); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" status "); stringBuilder.append(functionStatus2); String str2 = stringBuilder.toString(); Log.d(str1, str2); return functionStatus2; } public int[] getSupportedFunctionZones(int paramInt) { if (validCarFunctionInt(paramInt)) { VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToIntFunction.get(paramInt); return vehicleFunction.getZones(); }  if (validCarFunctionFlt(paramInt)) { VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToCustomFunction.get(paramInt); return vehicleFunction.getZones(); }  return EMPTY_SUPPORT_FUNCTION_VALUE; } public int[] getSupportedFunctionValue(int paramInt) { return getSupportedFunctionValue(paramInt, -2147483648); } public int[] getSupportedFunctionValue(int paramInt1, int paramInt2) { VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToIntFunction.get(paramInt1); if (vehicleFunction != null) { VehicleType vehicleType = getVehicleType(); VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(vehicleType, paramInt2); if (zoneTask != null) return zoneTask.getValues();  vehicleFunction.tryRegisterFunctionSignal(this); } else { vehicleFunction = (VehicleFunction)this.mFunctionIdToCustomFunction.get(paramInt1); if (vehicleFunction != null) { VehicleType vehicleType = getVehicleType(); VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(vehicleType, paramInt2); if (zoneTask != null) return zoneTask.getValues();  vehicleFunction.tryRegisterFunctionSignal(this); }  }  return EMPTY_SUPPORT_FUNCTION_VALUE; } public boolean setFunctionValue(int paramInt1, int paramInt2) { return setFunctionValue(paramInt1, -2147483648, paramInt2); } public boolean setFunctionValue(int paramInt1, int paramInt2, int paramInt3) { boolean bool; String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setFunctionValue function "); stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone "); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" value "); stringBuilder.append(paramInt3); String str2 = stringBuilder.toString(); Log.d(str1, str2); ApiResult apiResult2 = ApiResult.FAILED; VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToIntFunction.get(paramInt1); ApiResult apiResult1 = apiResult2; if (vehicleFunction != null) { VehicleFunction.ZoneTask<Integer> zoneTask = vehicleFunction.getZoneTask(getVehicleType(), paramInt2); apiResult1 = apiResult2; if (zoneTask != null) apiResult1 = zoneTask.callSetFunction(Integer.valueOf(paramInt3));  }  if (apiResult1 != ApiResult.SUCCEED) { String str3 = getModuleName(); StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("setFunctionValue function "); stringBuilder1.append(CarLog.funId2Str(paramInt1)); stringBuilder1.append(" zone "); stringBuilder1.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder1.append(" value "); stringBuilder1.append(paramInt3); stringBuilder1.append(" result "); stringBuilder1.append(apiResult1); String str4 = stringBuilder1.toString(); Log.d(str3, str4); }  if (apiResult1 == ApiResult.SUCCEED) { bool = true; } else { bool = false; }  return bool; } private void notifyIntCallback(VehicleFunction.ZoneTask<Integer> paramZoneTask, int paramInt) { VehicleFunction.Data<Integer> data = paramZoneTask.getData(this, paramInt);
/* 543 */     String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Function:"); stringBuilder.append(CarLog.funId2Str(paramZoneTask.getFunctionId())); stringBuilder.append(" zone:");
/* 544 */     stringBuilder.append(CarLog.zoneValue2Str(paramZoneTask.getZone())); stringBuilder.append(" ");
/* 545 */     stringBuilder.append(data.toString()); String str2 = stringBuilder.toString(); Log.i(str1, str2);
/* 546 */     if (data.isStatusChanged() || data.isValueChanged() || data.isSupportValueChanged()) {
/* 547 */       onFunctionChanged(paramZoneTask.getFunctionId());
/*     */     }
/* 549 */     if (data.isStatusChanged()) {
/* 550 */       paramInt = paramZoneTask.getFunctionId();
/* 551 */       int i = paramZoneTask.getZone();
/* 552 */       FunctionStatus functionStatus = data.getStatus();
/*     */       onSupportedFunctionStatusChanged(paramInt, i, functionStatus);
/* 554 */       SparseArray<List<IVehicleFunction.IAssociatedStatus<?>>> sparseArray = this.groupAssociated;
/* 555 */       List list = (List)sparseArray.get(paramZoneTask.getFunctionId());
/* 556 */       if (list != null && !list.isEmpty()) {
/* 557 */         Stream stream1 = list.stream(); -$$Lambda$AbsCarFunction$BXf9vV71a3aQqlH4BJDw8umRhww -$$Lambda$AbsCarFunction$BXf9vV71a3aQqlH4BJDw8umRhww = new -$$Lambda$AbsCarFunction$BXf9vV71a3aQqlH4BJDw8umRhww(paramZoneTask);
/* 558 */         Stream stream2 = stream1.filter(-$$Lambda$AbsCarFunction$BXf9vV71a3aQqlH4BJDw8umRhww); -$$Lambda$AbsCarFunction$BkLzaxp-tDfWpdG9baz_LryI7pg -$$Lambda$AbsCarFunction$BkLzaxp-tDfWpdG9baz_LryI7pg = new -$$Lambda$AbsCarFunction$BkLzaxp-tDfWpdG9baz_LryI7pg(this, data);
/* 559 */         stream2.forEach(-$$Lambda$AbsCarFunction$BkLzaxp-tDfWpdG9baz_LryI7pg);
/*     */       } 
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
/* 571 */     if (data.isSupportValueChanged()) {
/* 572 */       onSupportedFunctionValueChanged(paramZoneTask.getFunctionId(), data.getSupportValues());
/*     */     }
/* 574 */     if (data.isValueChanged())
/* 575 */     { paramInt = paramZoneTask.getFunctionId(); int i = paramZoneTask.getZone();
/* 576 */       int j = ((Integer)data.getValue()).intValue(); onFunctionValueChanged(paramInt, i, j); }  }
/*     */   public int getFunctionValue(int paramInt) { return getFunctionValue(paramInt, -2147483648); }
/*     */   public int getFunctionValue(int paramInt1, int paramInt2) { Integer integer; VehicleType vehicleType1 = null, vehicleType2 = null; VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToIntFunction.get(paramInt1); if (vehicleFunction != null) { vehicleType1 = getVehicleType(); VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(vehicleType1, paramInt2); vehicleType1 = vehicleType2; if (zoneTask != null) { IVehicleFunction.IValue<Integer> iValue = zoneTask.getValueTask(); vehicleType1 = vehicleType2; if (iValue != null) integer = iValue.getValue(this);  }  vehicleFunction.tryRegisterFunctionSignal(this); }  String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getFunctionValue function "); stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone "); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" value "); stringBuilder.append(integer); String str2 = stringBuilder.toString(); Log.d(str1, str2); if (integer == null) { paramInt1 = 255; } else { paramInt1 = integer.intValue(); }  return paramInt1; }
/*     */   public boolean setCustomizeFunctionValue(int paramInt, float paramFloat) { return setCustomizeFunctionValue(paramInt, -2147483648, paramFloat); }
/*     */   public boolean setCustomizeFunctionValue(int paramInt1, int paramInt2, float paramFloat) { boolean bool; String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setCustomizeFunctionValue function "); stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone "); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" value "); stringBuilder.append(paramFloat); String str2 = stringBuilder.toString(); Log.d(str1, str2); ApiResult apiResult2 = ApiResult.FAILED; VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToCustomFunction.get(paramInt1); ApiResult apiResult1 = apiResult2; if (vehicleFunction != null) { VehicleFunction.ZoneTask<Float> zoneTask = vehicleFunction.getZoneTask(getVehicleType(), paramInt2); apiResult1 = apiResult2; if (zoneTask != null) apiResult1 = zoneTask.callSetFunction(Float.valueOf(paramFloat));  }  if (apiResult1 != ApiResult.SUCCEED) { String str3 = getModuleName(); StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("setCustomizeFunctionValue function "); stringBuilder1.append(CarLog.funId2Str(paramInt1)); stringBuilder1.append(" zone "); stringBuilder1.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder1.append(" value "); stringBuilder1.append(paramFloat); stringBuilder1.append(" result "); stringBuilder1.append(apiResult1); String str4 = stringBuilder1.toString(); Log.d(str3, str4); }  if (apiResult1 == ApiResult.SUCCEED) { bool = true; } else { bool = false; }  return bool; }
/* 581 */   public float getCustomizeFunctionValue(int paramInt) { return getCustomizeFunctionValue(paramInt, -2147483648); } public float getCustomizeFunctionValue(int paramInt1, int paramInt2) { float f; Float float_1 = null, float_2 = null; VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToCustomFunction.get(paramInt1); if (vehicleFunction != null) { VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(getVehicleType(), paramInt2); float_1 = float_2; if (zoneTask != null) { IVehicleFunction.IValue<Float> iValue = zoneTask.getValueTask(); float_1 = float_2; if (iValue != null) float_1 = iValue.getValue(this);  }  vehicleFunction.tryRegisterFunctionSignal(this); }  String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getFunctionValue function "); stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone "); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" value "); stringBuilder.append(float_1); String str2 = stringBuilder.toString(); Log.d(str1, str2); if (float_1 == null) { f = Float.MIN_VALUE; } else { f = float_1.floatValue(); }  return f; } boolean registerPAOrSignal(SignalFilter paramSignalFilter1, SignalFilter paramSignalFilter2) { this.mRegisterHandler.removeMessages(1); int i = paramSignalFilter1.getFilterCount(); byte b = 0; if (i > 0) for (byte b1 = 0; b1 < i; b1++) addPAFilter(paramSignalFilter1.getSignal(b1));   i = paramSignalFilter2.getFilterCount(); if (i > 0) for (byte b1 = b; b1 < i; b1++) addSignalFilter(paramSignalFilter2.getSignal(b1));   this.mRegisterHandler.sendEmptyMessageDelayed(1, 100L); return true; } protected void addIntFunction(VehicleFunction<Integer> paramVehicleFunction) { this.mIntFunctions.add(paramVehicleFunction); this.mFunctionIdToIntFunction.put(paramVehicleFunction.getFunction(), paramVehicleFunction); for (Iterator<Integer> iterator = paramVehicleFunction.getPropertyList().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue(); paramVehicleFunction.addPAOrSignal(i); List<VehicleFunction<Integer>> list = (List)this.mPropertyToIntFunction.get(i, new ArrayList()); if (list.isEmpty()) this.mPropertyToIntFunction.put(i, list);  list.add(paramVehicleFunction); }  Set<IVehicleFunction.IAssociatedStatus<Integer>> set = paramVehicleFunction.getAssociatedStatusList(); if (!set.isEmpty()) for (IVehicleFunction.IAssociatedStatus<Integer> iAssociatedStatus : set) { SparseArray<List<IVehicleFunction.IAssociatedStatus<?>>> sparseArray = this.groupAssociated; int i = iAssociatedStatus.getAssociatedFunction(); ArrayList arrayList = new ArrayList(); List<IVehicleFunction.IAssociatedStatus> list = (List)sparseArray.get(i, arrayList); if (list.isEmpty()) this.groupAssociated.put(iAssociatedStatus.getAssociatedFunction(), list);  list.add(iAssociatedStatus); }   } protected void addCustomFunction(VehicleFunction<Float> paramVehicleFunction) { this.mFloatFunctions.add(paramVehicleFunction); this.mFunctionIdToCustomFunction.put(paramVehicleFunction.getFunction(), paramVehicleFunction); for (Iterator<Integer> iterator = paramVehicleFunction.getPropertyList().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue(); paramVehicleFunction.addPAOrSignal(i); List<VehicleFunction<Float>> list = (List)this.mPropertyToCustomFunction.get(i, new ArrayList()); if (list.isEmpty()) this.mPropertyToCustomFunction.put(i, list);  list.add(paramVehicleFunction); }  Set<IVehicleFunction.IAssociatedStatus<Float>> set = paramVehicleFunction.getAssociatedStatusList(); if (!set.isEmpty()) for (IVehicleFunction.IAssociatedStatus<Float> iAssociatedStatus : set) { SparseArray<List<IVehicleFunction.IAssociatedStatus<?>>> sparseArray = this.groupAssociated; int i = iAssociatedStatus.getAssociatedFunction(); ArrayList arrayList = new ArrayList(); List<IVehicleFunction.IAssociatedStatus> list = (List)sparseArray.get(i, arrayList); if (list.isEmpty()) this.groupAssociated.put(iAssociatedStatus.getAssociatedFunction(), list);  list.add(iAssociatedStatus); }   } protected void addProFunction(ProFunction<?> paramProFunction) { this.mProFunctions.put(paramProFunction.getProperty(), paramProFunction); } protected void triggerCallback(int paramInt1, int paramInt2) { if (validCarFunctionInt(paramInt1)) { String str; VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToIntFunction.get(paramInt1); VehicleType vehicleType = getVehicleType(); VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(vehicleType, paramInt2); if (zoneTask == null) { str = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Function notify failed:"); stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:"); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" zoneTask is null"); String str1 = stringBuilder.toString(); Log.i(str, str1); } else { notifyIntCallback((VehicleFunction.ZoneTask<Integer>)str, -1); }  } else if (validCarFunctionFlt(paramInt1)) { String str; VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToCustomFunction.get(paramInt1); VehicleFunction.ZoneTask zoneTask = vehicleFunction.getZoneTask(getVehicleType(), paramInt2); if (zoneTask == null) { str = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Function notify failed:"); stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:"); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" zoneTask is null"); String str1 = stringBuilder.toString(); Log.i(str, str1); } else { notifyCustomCallback((VehicleFunction.ZoneTask<Float>)str, -1); }  }  } protected void propCallback(int paramInt1, int paramInt2) { ProFunction proFunction = (ProFunction)this.mProFunctions.get(paramInt1); if (proFunction != null) proFunction.notifyCallback();  } protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) { recordSignalDate(paramECarXCarPropertyValue); int i = paramECarXCarPropertyValue.getPropertyId(); if (i == 29329) { VehicleType vehicleType = getVehicleType(); Stream<VehicleFunction<Integer>> stream = this.mIntFunctions.stream(); -$$Lambda$AbsCarFunction$BMySpx1hcxxrtgdNEia_VHD2x9M -$$Lambda$AbsCarFunction$BMySpx1hcxxrtgdNEia_VHD2x9M = -$$Lambda$AbsCarFunction$BMySpx1hcxxrtgdNEia_VHD2x9M.INSTANCE; Stream<?> stream3 = stream.flatMap(-$$Lambda$AbsCarFunction$BMySpx1hcxxrtgdNEia_VHD2x9M); -$$Lambda$AbsCarFunction$yjJt4yrRryDsWZoEVwYKvB80NXM -$$Lambda$AbsCarFunction$yjJt4yrRryDsWZoEVwYKvB80NXM = new -$$Lambda$AbsCarFunction$yjJt4yrRryDsWZoEVwYKvB80NXM(vehicleType); Stream<?> stream4 = stream3.filter(-$$Lambda$AbsCarFunction$yjJt4yrRryDsWZoEVwYKvB80NXM); -$$Lambda$AbsCarFunction$X8c1Zlw-PEFECs2aHJRO1WT-XKM -$$Lambda$AbsCarFunction$X8c1Zlw-PEFECs2aHJRO1WT-XKM = new -$$Lambda$AbsCarFunction$X8c1Zlw-PEFECs2aHJRO1WT-XKM(this); stream4.forEach(-$$Lambda$AbsCarFunction$X8c1Zlw-PEFECs2aHJRO1WT-XKM); stream4 = this.mFloatFunctions.stream(); -$$Lambda$AbsCarFunction$zurxrYJlOCa2A11l_wN6IYXpqpM -$$Lambda$AbsCarFunction$zurxrYJlOCa2A11l_wN6IYXpqpM = -$$Lambda$AbsCarFunction$zurxrYJlOCa2A11l_wN6IYXpqpM.INSTANCE; Stream<?> stream2 = stream4.flatMap(-$$Lambda$AbsCarFunction$zurxrYJlOCa2A11l_wN6IYXpqpM); -$$Lambda$AbsCarFunction$zIJHOGcL52aFEKhQC2AoLz3f8r8 -$$Lambda$AbsCarFunction$zIJHOGcL52aFEKhQC2AoLz3f8r8 = new -$$Lambda$AbsCarFunction$zIJHOGcL52aFEKhQC2AoLz3f8r8(vehicleType); Stream<?> stream1 = stream2.filter(-$$Lambda$AbsCarFunction$zIJHOGcL52aFEKhQC2AoLz3f8r8); -$$Lambda$AbsCarFunction$Hx35KRLsh_kcAgMXSMdl3qvFhbc -$$Lambda$AbsCarFunction$Hx35KRLsh_kcAgMXSMdl3qvFhbc = new -$$Lambda$AbsCarFunction$Hx35KRLsh_kcAgMXSMdl3qvFhbc(this); stream1.forEach(-$$Lambda$AbsCarFunction$Hx35KRLsh_kcAgMXSMdl3qvFhbc); } else { List list = (List)this.mPropertyToIntFunction.get(i); if (list != null) { Stream stream = list.stream(); -$$Lambda$AbsCarFunction$_8ZjeJEEpfNlAnpJ3Zzel-FfBm4 -$$Lambda$AbsCarFunction$_8ZjeJEEpfNlAnpJ3Zzel-FfBm4 = new -$$Lambda$AbsCarFunction$_8ZjeJEEpfNlAnpJ3Zzel-FfBm4(this, i); stream = stream.flatMap(-$$Lambda$AbsCarFunction$_8ZjeJEEpfNlAnpJ3Zzel-FfBm4); -$$Lambda$AbsCarFunction$FHFnK6l3VQyPQnLOtGV6BLNb5Nk -$$Lambda$AbsCarFunction$FHFnK6l3VQyPQnLOtGV6BLNb5Nk = new -$$Lambda$AbsCarFunction$FHFnK6l3VQyPQnLOtGV6BLNb5Nk(this, i); stream.forEach(-$$Lambda$AbsCarFunction$FHFnK6l3VQyPQnLOtGV6BLNb5Nk); }  list = (List)this.mPropertyToCustomFunction.get(i); if (list != null) { Stream stream = list.stream(); -$$Lambda$AbsCarFunction$mSOvrxLNlpbZh4W6poCRSFTgBfc -$$Lambda$AbsCarFunction$mSOvrxLNlpbZh4W6poCRSFTgBfc = new -$$Lambda$AbsCarFunction$mSOvrxLNlpbZh4W6poCRSFTgBfc(this, i); stream = stream.flatMap(-$$Lambda$AbsCarFunction$mSOvrxLNlpbZh4W6poCRSFTgBfc); -$$Lambda$AbsCarFunction$tVMZWLyCeM66gMMMGX1RTj7I14M -$$Lambda$AbsCarFunction$tVMZWLyCeM66gMMMGX1RTj7I14M = new -$$Lambda$AbsCarFunction$tVMZWLyCeM66gMMMGX1RTj7I14M(this, i); stream.forEach(-$$Lambda$AbsCarFunction$tVMZWLyCeM66gMMMGX1RTj7I14M); }  }  } private void notifyCustomCallback(VehicleFunction.ZoneTask<Float> paramZoneTask, int paramInt) { VehicleFunction.Data<Float> data = paramZoneTask.getData(this, paramInt);
/* 582 */     String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Function:"); stringBuilder.append(CarLog.funId2Str(paramZoneTask.getFunctionId())); stringBuilder.append(" zone:");
/* 583 */     stringBuilder.append(CarLog.zoneValue2Str(paramZoneTask.getZone())); stringBuilder.append(" ");
/* 584 */     stringBuilder.append(data.toString()); String str2 = stringBuilder.toString(); Log.i(str1, str2);
/* 585 */     if (data.isStatusChanged() || data.isValueChanged() || data.isSupportValueChanged()) {
/* 586 */       onFunctionChanged(paramZoneTask.getFunctionId());
/*     */     }
/* 588 */     if (data.isStatusChanged()) {
/* 589 */       paramInt = paramZoneTask.getFunctionId();
/* 590 */       int i = paramZoneTask.getZone();
/* 591 */       FunctionStatus functionStatus = data.getStatus();
/*     */       onSupportedFunctionStatusChanged(paramInt, i, functionStatus);
/* 593 */       SparseArray<List<IVehicleFunction.IAssociatedStatus<?>>> sparseArray = this.groupAssociated;
/* 594 */       List list = (List)sparseArray.get(paramZoneTask.getFunctionId());
/* 595 */       if (list != null && !list.isEmpty()) {
/* 596 */         Stream stream = list.stream(); -$$Lambda$AbsCarFunction$9ip1X18JOwbjFQ4kyAV7zN7QMpo -$$Lambda$AbsCarFunction$9ip1X18JOwbjFQ4kyAV7zN7QMpo = new -$$Lambda$AbsCarFunction$9ip1X18JOwbjFQ4kyAV7zN7QMpo(paramZoneTask);
/* 597 */         stream = stream.filter(-$$Lambda$AbsCarFunction$9ip1X18JOwbjFQ4kyAV7zN7QMpo); -$$Lambda$AbsCarFunction$Oicjw7ftDZP9BUY2IOgcK0F9-yk -$$Lambda$AbsCarFunction$Oicjw7ftDZP9BUY2IOgcK0F9-yk = new -$$Lambda$AbsCarFunction$Oicjw7ftDZP9BUY2IOgcK0F9-yk(this, data);
/* 598 */         stream.forEach(-$$Lambda$AbsCarFunction$Oicjw7ftDZP9BUY2IOgcK0F9-yk);
/*     */       } 
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
/* 610 */     if (data.isSupportValueChanged()) {
/* 611 */       onSupportedFunctionValueChanged(paramZoneTask.getFunctionId(), data.getSupportValues());
/*     */     }
/* 613 */     if (data.isValueChanged()) {
/* 614 */       paramInt = paramZoneTask.getFunctionId();
/* 615 */       int i = paramZoneTask.getZone();
/* 616 */       float f = ((Float)data.getValue()).floatValue();
/*     */       onCustomizeFunctionValueChanged(paramInt, i, f);
/*     */     }  }
/*     */ 
/*     */   
/*     */   private void registerCarFunctionSignal(int paramInt) {
/* 622 */     if (validCarFunctionInt(paramInt)) {
/* 623 */       VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToIntFunction.get(paramInt);
/* 624 */       vehicleFunction.tryRegisterFunctionSignal(this);
/*     */     }
/* 626 */     else if (validCarFunctionFlt(paramInt)) {
/* 627 */       VehicleFunction vehicleFunction = (VehicleFunction)this.mFunctionIdToCustomFunction.get(paramInt);
/* 628 */       vehicleFunction.tryRegisterFunctionSignal(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean registerFunctionValueWatcher(ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 634 */     synchronized (this.mCallbackLock) {
/* 635 */       ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = (ArrayList)this.mCallbackArray.get(-1);
/* 636 */       if (arrayList != null) {
/* 637 */         arrayList.remove(paramIFunctionValueWatcher);
/* 638 */         arrayList.add(paramIFunctionValueWatcher);
/*     */       } 
/*     */       
/* 641 */       registerAllSignal();
/* 642 */       return true;
/*     */     } 
/*     */   }
/*     */   public void registerAllSignal() {
/* 646 */     for (VehicleFunction<Integer> vehicleFunction : this.mIntFunctions) {
/* 647 */       vehicleFunction.tryRegisterFunctionSignal(this);
/*     */     }
/* 649 */     for (VehicleFunction<Float> vehicleFunction : this.mFloatFunctions) {
/* 650 */       vehicleFunction.tryRegisterFunctionSignal(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerFunctionValueWatcher(int paramInt, ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 657 */     synchronized (this.mCallbackLock) {
/* 658 */       if (this.mCallbackArray.indexOfKey(paramInt) < 0) {
/* 659 */         SparseArray<ArrayList<ICarFunction.IFunctionValueWatcher>> sparseArray = this.mCallbackArray; ArrayList arrayList1 = new ArrayList(); this(); sparseArray.put(paramInt, arrayList1);
/*     */       } 
/* 661 */       ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = (ArrayList)this.mCallbackArray.get(paramInt);
/* 662 */       if (arrayList != null && !arrayList.contains(paramIFunctionValueWatcher)) {
/* 663 */         arrayList.add(paramIFunctionValueWatcher);
/*     */       }
/*     */ 
/*     */       
/* 667 */       registerCarFunctionSignal(paramInt);
/* 668 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean registerFunctionValueWatcher(int[] paramArrayOfint, ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 674 */     synchronized (this.mCallbackLock) {
/* 675 */       int i; int j; int k; for (k = paramArrayOfint.length, j = 0, i = 0; i < k; ) { Integer integer = Integer.valueOf(paramArrayOfint[i]);
/* 676 */         if (this.mCallbackArray.indexOfKey(integer.intValue()) < 0) {
/* 677 */           SparseArray<ArrayList<ICarFunction.IFunctionValueWatcher>> sparseArray = this.mCallbackArray; int m = integer.intValue(); ArrayList arrayList1 = new ArrayList(); this(); sparseArray.put(m, arrayList1);
/*     */         } 
/*     */         
/* 680 */         ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = (ArrayList)this.mCallbackArray.get(integer.intValue());
/* 681 */         if (arrayList != null && !arrayList.contains(paramIFunctionValueWatcher)) {
/* 682 */           arrayList.add(paramIFunctionValueWatcher);
/*     */         }
/*     */         i++; }
/*     */       
/* 686 */       for (k = paramArrayOfint.length, i = j; i < k; ) { j = paramArrayOfint[i];
/* 687 */         registerCarFunctionSignal(j); i++; }
/*     */       
/* 689 */       return true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean unregisterFunctionValueWatcher(ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 694 */     synchronized (this.mCallbackLock) {
/* 695 */       int i = this.mCallbackArray.size();
/* 696 */       for (byte b = 0; b < i; b++) {
/* 697 */         ArrayList arrayList = (ArrayList)this.mCallbackArray.valueAt(b);
/* 698 */         arrayList.remove(paramIFunctionValueWatcher);
/*     */       } 
/*     */       
/* 701 */       return true;
/*     */     } 
/*     */   }
/*     */   public boolean registerProFunction(int paramInt, IProFunction.IPropertyWatcher paramIPropertyWatcher) {
/* 705 */     ProFunction proFunction = (ProFunction)this.mProFunctions.get(paramInt);
/* 706 */     if (proFunction != null) {
/* 707 */       return proFunction.register(paramIPropertyWatcher);
/*     */     }
/* 709 */     String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("can't register ");
/* 710 */     stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" not found implement"); String str2 = stringBuilder.toString(); Log.w(str1, str2);
/* 711 */     return false;
/*     */   }
/*     */   
/*     */   public boolean unregisterProFunction(IProFunction.IPropertyWatcher paramIPropertyWatcher) {
/* 715 */     for (byte b = 0; b < this.mProFunctions.size(); b++) {
/* 716 */       ProFunction proFunction = (ProFunction)this.mProFunctions.valueAt(b);
/* 717 */       proFunction.unregister(paramIPropertyWatcher);
/*     */     } 
/* 719 */     return true;
/*     */   }
/*     */   
/*     */   public boolean unregisterProFunction(int paramInt, IProFunction.IPropertyWatcher paramIPropertyWatcher) {
/* 723 */     ProFunction proFunction = (ProFunction)this.mProFunctions.get(paramInt);
/* 724 */     if (proFunction != null) {
/* 725 */       return proFunction.register(paramIPropertyWatcher);
/*     */     }
/* 727 */     String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("can't register ");
/* 728 */     stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(" not found implement"); String str2 = stringBuilder.toString(); Log.w(str1, str2);
/* 729 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public <E> IProValue<E> getProperty(int paramInt) throws UnsupportedOperationException {
/* 734 */     return getProperty(paramInt, -2147483648);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> IProValue<E> getProperty(int paramInt1, int paramInt2) throws UnsupportedOperationException {
/* 740 */     ProFunction proFunction = (ProFunction)this.mProFunctions.get(paramInt1);
/* 741 */     if (proFunction != null) {
/* 742 */       ProFunction.Zone<E> zone = proFunction.getZone(paramInt2);
/* 743 */       if (zone != null) {
/* 744 */         return zone.getProperty();
/*     */       }
/*     */     } 
/* 747 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public <E> CallStatus setProperty(IProValue<E> paramIProValue) {
/* 752 */     ProFunction proFunction = (ProFunction)this.mProFunctions.get(paramIProValue.getPropertyId());
/* 753 */     if (proFunction != null) {
/* 754 */       ProFunction.Zone<E> zone = proFunction.getZone(paramIProValue.getZoneId());
/* 755 */       if (zone != null) {
/* 756 */         return zone.setProperty(paramIProValue);
/*     */       }
/*     */     } 
/* 759 */     return CallStatus.NOT_IMPLEMENT;
/*     */   }
/*     */   
/*     */   private ArrayList<ICarFunction.IFunctionValueWatcher> getCallbackList(int paramInt) {
/* 763 */     null = new ArrayList();
/* 764 */     synchronized (this.mCallbackLock) {
/* 765 */       SparseArray<ArrayList<ICarFunction.IFunctionValueWatcher>> sparseArray1 = this.mCallbackArray; ArrayList arrayList3 = new ArrayList(); this(); ArrayList arrayList1 = (ArrayList)sparseArray1.get(paramInt, arrayList3);
/*     */       
/* 767 */       SparseArray<ArrayList<ICarFunction.IFunctionValueWatcher>> sparseArray2 = this.mCallbackArray; ArrayList arrayList4 = new ArrayList(); this(); ArrayList arrayList2 = (ArrayList)sparseArray2.get(-1, arrayList4);
/*     */ 
/*     */ 
/*     */       
/* 771 */       null.addAll(arrayList1);
/*     */       
/* 773 */       for (ICarFunction.IFunctionValueWatcher iFunctionValueWatcher : arrayList2) {
/* 774 */         if (!null.contains(iFunctionValueWatcher)) {
/* 775 */           null.add(iFunctionValueWatcher);
/*     */         }
/*     */       } 
/*     */       
/* 779 */       return null;
/*     */     } 
/*     */   }
/*     */   public void onFunctionChanged(int paramInt) {
/* 783 */     long l = SystemClock.uptimeMillis();
/* 784 */     ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = getCallbackList(paramInt);
/* 785 */     for (ICarFunction.IFunctionValueWatcher iFunctionValueWatcher : arrayList) {
/*     */       try {
/* 787 */         iFunctionValueWatcher.onFunctionChanged(paramInt);
/* 788 */       } catch (Exception exception) {
/* 789 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 793 */     String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onFunctionChanged:");
/* 794 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" durationtime:");
/* 795 */     stringBuilder.append(SystemClock.uptimeMillis() - l); String str2 = stringBuilder.toString();
/*     */     Log.d(str1, str2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onSupportedFunctionStatusChanged(int paramInt1, int paramInt2, FunctionStatus paramFunctionStatus) {
/* 801 */     long l = SystemClock.uptimeMillis();
/* 802 */     ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = getCallbackList(paramInt1);
/* 803 */     for (ICarFunction.IFunctionValueWatcher iFunctionValueWatcher : arrayList) {
/*     */       try {
/* 805 */         iFunctionValueWatcher.onSupportedFunctionStatusChanged(paramInt1, paramInt2, paramFunctionStatus);
/* 806 */       } catch (Exception exception) {
/* 807 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 811 */     String str2 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onSupportedFunctionStatusChanged function:");
/* 812 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 813 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" status:"); stringBuilder.append(paramFunctionStatus); stringBuilder.append(" durationtime:");
/*     */     
/* 815 */     stringBuilder.append(SystemClock.uptimeMillis() - l); String str1 = stringBuilder.toString();
/*     */     Log.d(str2, str1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onFunctionValueChanged(int paramInt1, int paramInt2, int paramInt3) {
/* 821 */     long l = SystemClock.uptimeMillis();
/* 822 */     ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = getCallbackList(paramInt1);
/* 823 */     for (ICarFunction.IFunctionValueWatcher iFunctionValueWatcher : arrayList) {
/*     */       try {
/* 825 */         iFunctionValueWatcher.onFunctionValueChanged(paramInt1, paramInt2, paramInt3);
/* 826 */       } catch (Exception exception) {
/* 827 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 831 */     String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onFunctionValueChanged function:");
/* 832 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 833 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" value:"); stringBuilder.append(CarLog.funValue2Str(paramInt3)); stringBuilder.append(" durationTime:");
/* 834 */     stringBuilder.append(SystemClock.uptimeMillis() - l); String str2 = stringBuilder.toString();
/*     */     Log.d(str1, str2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCustomizeFunctionValueChanged(int paramInt1, int paramInt2, float paramFloat) {
/* 840 */     long l = SystemClock.uptimeMillis();
/* 841 */     ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = getCallbackList(paramInt1);
/* 842 */     for (ICarFunction.IFunctionValueWatcher iFunctionValueWatcher : arrayList) {
/*     */       try {
/* 844 */         iFunctionValueWatcher.onCustomizeFunctionValueChanged(paramInt1, paramInt2, paramFloat);
/* 845 */       } catch (Exception exception) {
/* 846 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/* 849 */     String str1 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onCustomizeFunctionValueChanged function:");
/* 850 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 851 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" value:"); stringBuilder.append(paramFloat); stringBuilder.append(" durationTime:");
/*     */     
/* 853 */     stringBuilder.append(SystemClock.uptimeMillis() - l); String str2 = stringBuilder.toString();
/*     */     Log.d(str1, str2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onSupportedFunctionValueChanged(int paramInt, int[] paramArrayOfint) {
/* 859 */     long l = SystemClock.uptimeMillis();
/* 860 */     ArrayList<ICarFunction.IFunctionValueWatcher> arrayList = getCallbackList(paramInt);
/* 861 */     for (ICarFunction.IFunctionValueWatcher iFunctionValueWatcher : arrayList) {
/*     */       try {
/* 863 */         iFunctionValueWatcher.onSupportedFunctionValueChanged(paramInt, paramArrayOfint);
/* 864 */       } catch (Exception exception) {
/* 865 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 869 */     String str2 = getModuleName(); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onSupportedFunctionValueChanged function:");
/* 870 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" ");
/* 871 */     stringBuilder.append(Arrays.toString(paramArrayOfint)); stringBuilder.append(" durationTime:");
/* 872 */     stringBuilder.append(SystemClock.uptimeMillis() - l); String str1 = stringBuilder.toString();
/*     */     Log.d(str2, str1);
/*     */   }
/*     */   
/*     */   private String getModuleName() {
/* 877 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("AbsCarFunction::"); stringBuilder.append(getClass().getSimpleName()); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected abstract void buildFunctions();
/*     */   
/*     */   protected abstract void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager);
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\AbsCarFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */