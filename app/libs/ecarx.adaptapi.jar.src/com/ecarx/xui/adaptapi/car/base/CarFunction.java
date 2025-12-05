/*     */ package com.ecarx.xui.adaptapi.car.base;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.CallStatus;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.vehicle.VehicleHelper;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarFunction
/*     */   implements IProFunction
/*     */ {
/*     */   private Context mContext;
/*     */   private final VehicleHelper mVehicleHelper;
/*     */   
/*     */   public CarFunction(Context paramContext) {
/*  29 */     this.mContext = paramContext;
/*  30 */     this.mVehicleHelper = new VehicleHelper(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/*  40 */     this.mVehicleHelper.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/*  47 */     this.mVehicleHelper.onECarXCarServiceDeath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isFunctionSupported(int paramInt) {
/*  58 */     return this.mVehicleHelper.isFunctionSupported(paramInt);
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
/*     */   public FunctionStatus isFunctionSupported(int paramInt1, int paramInt2) {
/*  75 */     return this.mVehicleHelper.isFunctionSupported(paramInt1, paramInt2);
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
/*     */   public FunctionStatus isFunctionSupported(int paramInt1, int paramInt2, int paramInt3) {
/*  93 */     return this.mVehicleHelper.isFunctionSupported(paramInt1, paramInt2, paramInt3);
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
/*     */   public int[] getSupportedFunctionZones(int paramInt) {
/* 105 */     return this.mVehicleHelper.getSupportedFunctionZones(paramInt);
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
/*     */   public int[] getSupportedFunctionValue(int paramInt) {
/* 117 */     return this.mVehicleHelper.getSupportedFunctionValue(paramInt);
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
/*     */   public int[] getSupportedFunctionValue(int paramInt1, int paramInt2) {
/* 136 */     return this.mVehicleHelper.getSupportedFunctionValue(paramInt1, paramInt2);
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
/*     */   public boolean setFunctionValue(int paramInt1, int paramInt2) {
/* 149 */     return this.mVehicleHelper.setFunctionValue(paramInt1, paramInt2);
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
/*     */   public boolean setFunctionValue(int paramInt1, int paramInt2, int paramInt3) {
/* 167 */     return this.mVehicleHelper.setFunctionValue(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFunctionValue(int paramInt) {
/* 178 */     return this.mVehicleHelper.getFunctionValue(paramInt);
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
/*     */   public int getFunctionValue(int paramInt1, int paramInt2) {
/* 194 */     return this.mVehicleHelper.getFunctionValue(paramInt1, paramInt2);
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
/*     */   public boolean setCustomizeFunctionValue(int paramInt, float paramFloat) {
/* 207 */     return this.mVehicleHelper.setCustomizeFunctionValue(paramInt, paramFloat);
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
/*     */   public boolean setCustomizeFunctionValue(int paramInt1, int paramInt2, float paramFloat) {
/* 225 */     return this.mVehicleHelper.setCustomizeFunctionValue(paramInt1, paramInt2, paramFloat);
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
/*     */   public float getCustomizeFunctionValue(int paramInt) {
/* 237 */     return this.mVehicleHelper.getCustomizeFunctionValue(paramInt);
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
/*     */   public float getCustomizeFunctionValue(int paramInt1, int paramInt2) {
/* 254 */     return this.mVehicleHelper.getCustomizeFunctionValue(paramInt1, paramInt2);
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
/*     */   public boolean registerFunctionValueWatcher(ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 266 */     return this.mVehicleHelper.registerFunctionValueWatcher(paramIFunctionValueWatcher);
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
/*     */   public boolean registerFunctionValueWatcher(int paramInt, ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 278 */     return this.mVehicleHelper.registerFunctionValueWatcher(paramInt, paramIFunctionValueWatcher);
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
/*     */   public boolean registerFunctionValueWatcher(int[] paramArrayOfint, ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 291 */     return this.mVehicleHelper.registerFunctionValueWatcher(paramArrayOfint, paramIFunctionValueWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterFunctionValueWatcher(ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 302 */     return this.mVehicleHelper.unregisterFunctionValueWatcher(paramIFunctionValueWatcher);
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
/*     */   public <E> IProValue<E> getProperty(int paramInt) throws UnsupportedOperationException {
/* 316 */     return this.mVehicleHelper.getProperty(paramInt);
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
/*     */   public <E> IProValue<E> getProperty(int paramInt1, int paramInt2) throws UnsupportedOperationException {
/* 331 */     return this.mVehicleHelper.getProperty(paramInt1, paramInt2);
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
/*     */   public <E> CallStatus setProperty(IProValue<E> paramIProValue) {
/* 344 */     return this.mVehicleHelper.setProperty(paramIProValue);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\base\CarFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */