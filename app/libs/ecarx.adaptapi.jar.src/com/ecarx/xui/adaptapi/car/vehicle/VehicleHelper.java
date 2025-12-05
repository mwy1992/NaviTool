/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.CallStatus;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.CarLog;
/*     */ import com.ecarx.xui.adaptapi.car.base.ICarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.base.IProFunction;
/*     */ import com.ecarx.xui.adaptapi.car.base.IProValue;
/*     */ import com.ecarx.xui.adaptapi.car.hev.Charging;
/*     */ import com.ecarx.xui.adaptapi.car.hev.TripData;
/*     */ import com.ecarx.xui.adaptapi.car.hvac.Fragrance;
/*     */ import com.ecarx.xui.adaptapi.car.hvac.Hvac;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VehicleHelper
/*     */   implements IProFunction
/*     */ {
/*     */   private static final String TAG = "VehicleHelper";
/*     */   private final ArrayList<AbsCarFunction> mAbsVehicleList;
/*     */   
/*     */   public VehicleHelper(Context paramContext) {
/*  38 */     this.mAbsVehicleList = new ArrayList<>();
/*  39 */     this.mAbsVehicleList.add(new ADAS(paramContext));
/*  40 */     this.mAbsVehicleList.add(new AmbienceLight(paramContext));
/*  41 */     this.mAbsVehicleList.add(new Audio(paramContext));
/*  42 */     this.mAbsVehicleList.add(new Bcm(paramContext));
/*  43 */     this.mAbsVehicleList.add(new DayMode(paramContext));
/*  44 */     this.mAbsVehicleList.add(new DriveMode(paramContext));
/*  45 */     this.mAbsVehicleList.add(new HUD(paramContext));
/*  46 */     this.mAbsVehicleList.add(new Hybrid(paramContext));
/*  47 */     this.mAbsVehicleList.add(new Lamp(paramContext));
/*  48 */     this.mAbsVehicleList.add(new PAS(paramContext));
/*  49 */     this.mAbsVehicleList.add(new Safety(paramContext));
/*  50 */     this.mAbsVehicleList.add(new Seat(paramContext));
/*  51 */     this.mAbsVehicleList.add(new Units(paramContext));
/*  52 */     this.mAbsVehicleList.add(new Vehicle(paramContext));
/*  53 */     this.mAbsVehicleList.add(new Wpc(paramContext));
/*  54 */     this.mAbsVehicleList.add(new Hvac(paramContext));
/*  55 */     this.mAbsVehicleList.add(new Charging(paramContext));
/*  56 */     this.mAbsVehicleList.add(new Fragrance(paramContext));
/*  57 */     this.mAbsVehicleList.add(new SceneMode(paramContext));
/*  58 */     this.mAbsVehicleList.add(new TripData(paramContext));
/*     */   }
/*     */ 
/*     */   
/*     */   private AbsCarFunction getVehicleModule(int paramInt) {
/*  63 */     AbsCarFunction absCarFunction1, absCarFunction2 = null;
/*  64 */     Iterator<AbsCarFunction> iterator = this.mAbsVehicleList.iterator(); while (true) { absCarFunction1 = absCarFunction2; if (iterator.hasNext()) { absCarFunction1 = iterator.next();
/*  65 */         if (absCarFunction1.validCarFunction(paramInt))
/*     */           break;  continue; }
/*     */       
/*     */       break; }
/*     */     
/*  70 */     return absCarFunction1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/*  80 */     for (AbsCarFunction absCarFunction : this.mAbsVehicleList) {
/*     */       try {
/*  82 */         absCarFunction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  83 */       } catch (Exception exception) {
/*  84 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/*  93 */     for (AbsCarFunction absCarFunction : this.mAbsVehicleList) {
/*     */       try {
/*  95 */         absCarFunction.onECarXCarServiceDeath();
/*  96 */       } catch (Exception exception) {
/*  97 */         exception.printStackTrace();
/*     */       } 
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
/*     */   public FunctionStatus isFunctionSupported(int paramInt) {
/* 110 */     FunctionStatus functionStatus2 = FunctionStatus.notavailable;
/* 111 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 112 */     FunctionStatus functionStatus1 = functionStatus2; if (absCarFunction != null) { functionStatus1 = functionStatus2; if (absCarFunction.isECarXCarConnected())
/* 113 */         functionStatus1 = absCarFunction.isFunctionSupported(paramInt);  }
/*     */     
/* 115 */     String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isFunctionSupported function:");
/* 116 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" status:"); stringBuilder.append(functionStatus1); String str2 = stringBuilder.toString();
/*     */     Log.d(str1, str2);
/* 118 */     return functionStatus1;
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
/* 135 */     FunctionStatus functionStatus2 = FunctionStatus.notavailable;
/* 136 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 137 */     FunctionStatus functionStatus1 = functionStatus2; if (absCarFunction != null) { functionStatus1 = functionStatus2; if (absCarFunction.isECarXCarConnected())
/* 138 */         functionStatus1 = absCarFunction.isFunctionSupported(paramInt1, paramInt2);  }
/*     */     
/* 140 */     String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isFunctionSupported function:");
/* 141 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 142 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" status:"); stringBuilder.append(functionStatus1); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/* 143 */     return functionStatus1;
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
/*     */   public FunctionStatus isFunctionSupported(int paramInt1, int paramInt2, int paramInt3) {
/* 162 */     FunctionStatus functionStatus2 = FunctionStatus.notavailable;
/* 163 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 164 */     FunctionStatus functionStatus1 = functionStatus2; if (absCarFunction != null) { functionStatus1 = functionStatus2; if (absCarFunction.isECarXCarConnected())
/* 165 */         functionStatus1 = absCarFunction.isFunctionSupported(paramInt1, paramInt2, paramInt3);  }
/*     */     
/* 167 */     String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isFunctionSupported function:");
/* 168 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 169 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" status:"); stringBuilder.append(functionStatus1); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/* 170 */     return functionStatus1;
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
/*     */   public int[] getSupportedFunctionZones(int paramInt) {
/* 184 */     int[] arrayOfInt2 = null;
/* 185 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 186 */     int[] arrayOfInt1 = arrayOfInt2; if (absCarFunction != null) { arrayOfInt1 = arrayOfInt2; if (absCarFunction.isECarXCarConnected())
/* 187 */         arrayOfInt1 = absCarFunction.getSupportedFunctionZones(paramInt);  }
/*     */     
/* 189 */     String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSupportedFunctionZones:");
/* 190 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" "); stringBuilder.append(Arrays.toString(arrayOfInt1)); String str2 = stringBuilder.toString();
/*     */     
/*     */     Log.d(str1, str2);
/* 193 */     return arrayOfInt1;
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
/* 205 */     int[] arrayOfInt2 = null;
/* 206 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 207 */     int[] arrayOfInt1 = arrayOfInt2; if (absCarFunction != null) { arrayOfInt1 = arrayOfInt2; if (absCarFunction.isECarXCarConnected())
/* 208 */         arrayOfInt1 = absCarFunction.getSupportedFunctionValue(paramInt);  }
/*     */     
/* 210 */     String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSupportedFunctionValue:");
/* 211 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" "); stringBuilder.append(Arrays.toString(arrayOfInt1)); String str2 = stringBuilder.toString();
/*     */     
/*     */     Log.d(str1, str2);
/* 214 */     return arrayOfInt1;
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
/* 233 */     int[] arrayOfInt2 = null;
/* 234 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 235 */     int[] arrayOfInt1 = arrayOfInt2; if (absCarFunction != null) { arrayOfInt1 = arrayOfInt2; if (absCarFunction.isECarXCarConnected())
/* 236 */         arrayOfInt1 = absCarFunction.getSupportedFunctionValue(paramInt1, paramInt2);  }
/*     */     
/* 238 */     String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSupportedFunctionValue:");
/* 239 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 240 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" values:"); stringBuilder.append(Arrays.toString(arrayOfInt1)); String str2 = stringBuilder.toString();
/*     */     
/*     */     Log.d(str1, str2);
/* 243 */     return arrayOfInt1;
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
/* 256 */     boolean bool2 = false;
/* 257 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 258 */     boolean bool1 = bool2; if (absCarFunction != null) { bool1 = bool2; if (absCarFunction.isECarXCarConnected()) {
/* 259 */         bool1 = bool2; if (absCarFunction.validCarFunctionInt(paramInt1))
/* 260 */         { bool1 = bool2; if (isSupportBySet(absCarFunction, paramInt1, -2147483648))
/* 261 */             bool1 = absCarFunction.setFunctionValue(paramInt1, paramInt2);  } 
/*     */       }  }
/* 263 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setFunctionValue: function:");
/* 264 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" funcValue:");
/* 265 */     stringBuilder.append(CarLog.funValue2Str(paramInt2)); stringBuilder.append(" result:"); stringBuilder.append(bool1); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/* 266 */     return bool1;
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
/*     */   public boolean setFunctionValue(int paramInt1, int paramInt2, int paramInt3) {
/* 285 */     boolean bool2 = false;
/* 286 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 287 */     boolean bool1 = bool2; if (absCarFunction != null) { bool1 = bool2; if (absCarFunction.isECarXCarConnected()) {
/* 288 */         bool1 = bool2; if (absCarFunction.validCarFunctionInt(paramInt1))
/* 289 */         { bool1 = bool2; if (isSupportBySet(absCarFunction, paramInt1, paramInt2))
/*     */           {
/* 291 */             bool1 = absCarFunction.setFunctionValue(paramInt1, paramInt2, paramInt3); }  } 
/*     */       }  }
/* 293 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setFunctionValue: function:");
/* 294 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" funcValue:");
/* 295 */     stringBuilder.append(CarLog.funValue2Str(paramInt3)); stringBuilder.append(" zone:"); stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" result:"); stringBuilder.append(bool1); String str2 = stringBuilder.toString();
/*     */     Log.d(str1, str2);
/* 297 */     return bool1;
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
/*     */   public int getFunctionValue(int paramInt) {
/* 309 */     char c = 'ÿ';
/* 310 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 311 */     int i = c; if (absCarFunction != null) { i = c; if (absCarFunction.isECarXCarConnected()) {
/* 312 */         i = c; if (absCarFunction.validCarFunctionInt(paramInt))
/* 313 */         { i = c; if (isSupport(absCarFunction, paramInt, -2147483648))
/*     */           {
/* 315 */             i = absCarFunction.getFunctionValue(paramInt); }  } 
/*     */       }  }
/* 317 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getFunctionValue: function:");
/* 318 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" result:");
/* 319 */     stringBuilder.append(CarLog.funValue2Str(i)); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/* 320 */     return i;
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
/*     */   public int getFunctionValue(int paramInt1, int paramInt2) {
/* 337 */     char c = 'ÿ';
/* 338 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 339 */     int i = c; if (absCarFunction != null) { i = c; if (absCarFunction.isECarXCarConnected()) {
/* 340 */         i = c; if (absCarFunction.validCarFunctionInt(paramInt1))
/* 341 */         { i = c; if (isSupport(absCarFunction, paramInt1, paramInt2))
/*     */           {
/* 343 */             i = absCarFunction.getFunctionValue(paramInt1, paramInt2); }  } 
/*     */       }  }
/* 345 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getFunctionValue: function:");
/* 346 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 347 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" results:"); stringBuilder.append(CarLog.funValue2Str(i)); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/* 348 */     return i;
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
/* 361 */     boolean bool2 = false;
/* 362 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 363 */     boolean bool1 = bool2; if (absCarFunction != null) { bool1 = bool2; if (absCarFunction.isECarXCarConnected()) {
/* 364 */         bool1 = bool2; if (absCarFunction.validCarFunctionFlt(paramInt))
/* 365 */         { bool1 = bool2; if (isSupportBySet(absCarFunction, paramInt, -2147483648))
/*     */           {
/* 367 */             bool1 = absCarFunction.setCustomizeFunctionValue(paramInt, paramFloat); }  } 
/*     */       }  }
/* 369 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setCustomizeFunctionValue: function:");
/* 370 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" value:"); stringBuilder.append(paramFloat); stringBuilder.append(" results:"); stringBuilder.append(bool1); String str2 = stringBuilder.toString();
/*     */     Log.d(str1, str2);
/* 372 */     return bool1;
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
/* 390 */     boolean bool2 = false;
/* 391 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 392 */     boolean bool1 = bool2; if (absCarFunction != null) { bool1 = bool2; if (absCarFunction.isECarXCarConnected()) {
/* 393 */         bool1 = bool2; if (absCarFunction.validCarFunctionFlt(paramInt1))
/* 394 */         { bool1 = bool2; if (isSupportBySet(absCarFunction, paramInt1, paramInt2))
/*     */           {
/* 396 */             bool1 = absCarFunction.setCustomizeFunctionValue(paramInt1, paramInt2, paramFloat); }  } 
/*     */       }  }
/* 398 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setCustomizeFunctionValue: function:");
/* 399 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" value:"); stringBuilder.append(paramFloat); stringBuilder.append(" zone:");
/* 400 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" results:"); stringBuilder.append(bool1); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/* 401 */     return bool1;
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
/* 413 */     float f2 = Float.MIN_VALUE;
/* 414 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 415 */     float f1 = f2; if (absCarFunction != null) { f1 = f2; if (absCarFunction.isECarXCarConnected()) {
/* 416 */         f1 = f2; if (absCarFunction.validCarFunctionFlt(paramInt))
/* 417 */         { f1 = f2; if (isSupport(absCarFunction, paramInt, -2147483648))
/*     */           {
/* 419 */             f1 = absCarFunction.getCustomizeFunctionValue(paramInt); }  } 
/*     */       }  }
/* 421 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getCustomizeFunctionValue: function:");
/* 422 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" results:"); stringBuilder.append(f1); String str2 = stringBuilder.toString();
/*     */     Log.d(str1, str2);
/* 424 */     return f1;
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
/* 441 */     float f2 = Float.MIN_VALUE;
/* 442 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 443 */     float f1 = f2; if (absCarFunction != null) { f1 = f2; if (absCarFunction.isECarXCarConnected()) {
/* 444 */         f1 = f2; if (absCarFunction.validCarFunctionFlt(paramInt1))
/* 445 */         { f1 = f2; if (isSupport(absCarFunction, paramInt1, paramInt2))
/*     */           {
/* 447 */             f1 = absCarFunction.getCustomizeFunctionValue(paramInt1, paramInt2); }  } 
/*     */       }  }
/* 449 */      String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getCustomizeFunctionValue: function:");
/* 450 */     stringBuilder.append(CarLog.funId2Str(paramInt1)); stringBuilder.append(" zone:");
/* 451 */     stringBuilder.append(CarLog.zoneValue2Str(paramInt2)); stringBuilder.append(" results:"); stringBuilder.append(f1); String str2 = stringBuilder.toString(); Log.d(str1, str2);
/* 452 */     return f1;
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
/* 464 */     for (AbsCarFunction absCarFunction : this.mAbsVehicleList) {
/* 465 */       absCarFunction.registerFunctionValueWatcher(paramIFunctionValueWatcher);
/*     */     }
/* 467 */     return true;
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
/*     */   public boolean registerFunctionValueWatcher(int paramInt, ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 480 */     boolean bool = false;
/* 481 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 482 */     if (absCarFunction != null) {
/* 483 */       if (paramIFunctionValueWatcher instanceof IProFunction.IPropertyWatcher) {
/* 484 */         bool = absCarFunction.registerProFunction(paramInt, (IProFunction.IPropertyWatcher)paramIFunctionValueWatcher);
/*     */       } else {
/* 486 */         bool = absCarFunction.registerFunctionValueWatcher(paramInt, paramIFunctionValueWatcher);
/*     */       } 
/*     */     }
/* 489 */     String str1 = getModuleName(absCarFunction); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerFunctionValueWatcher function= ");
/* 490 */     stringBuilder.append(CarLog.funId2Str(paramInt)); stringBuilder.append(" "); stringBuilder.append(bool); String str2 = stringBuilder.toString();
/*     */     Log.w(str1, str2);
/* 492 */     return bool;
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
/*     */   public boolean registerFunctionValueWatcher(int[] paramArrayOfint, ICarFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/*     */     byte b;
/*     */     int i;
/* 506 */     for (i = paramArrayOfint.length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/* 507 */       registerFunctionValueWatcher(j, paramIFunctionValueWatcher); b++; }
/*     */     
/* 509 */     return true;
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
/* 520 */     for (AbsCarFunction absCarFunction : this.mAbsVehicleList) {
/*     */       try {
/* 522 */         if (paramIFunctionValueWatcher instanceof IProFunction.IPropertyWatcher) {
/* 523 */           absCarFunction.unregisterProFunction((IProFunction.IPropertyWatcher)paramIFunctionValueWatcher); continue;
/*     */         } 
/* 525 */         absCarFunction.unregisterFunctionValueWatcher(paramIFunctionValueWatcher);
/*     */       }
/* 527 */       catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */     
/* 531 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isSupport(AbsCarFunction paramAbsCarFunction, int paramInt1, int paramInt2) {
/* 535 */     FunctionStatus functionStatus = paramAbsCarFunction.isFunctionSupported(paramInt1, paramInt2);
/* 536 */     if (functionStatus == FunctionStatus.notavailable) {
/* 537 */       String str1 = getModuleName(paramAbsCarFunction);
/*     */       
/* 539 */       String str3 = CarLog.funId2Str(paramInt1), str2 = Integer.toHexString(paramInt2), str4 = functionStatus.name(); Log.i(str1, String.format("get FunctionValue failed because 0x%s function zone 0x%s status is %s", new Object[] { str3, str2, str4 }));
/*     */     } 
/* 541 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isSupportBySet(AbsCarFunction paramAbsCarFunction, int paramInt1, int paramInt2) {
/* 545 */     FunctionStatus functionStatus = paramAbsCarFunction.isFunctionSupported(paramInt1, paramInt2);
/* 546 */     if (functionStatus == FunctionStatus.notavailable) {
/* 547 */       String str1 = getModuleName(paramAbsCarFunction);
/*     */       
/* 549 */       String str3 = CarLog.funId2Str(paramInt1), str2 = Integer.toHexString(paramInt2); Log.i(str1, String.format("set FunctionValue failed because 0x%s function zone 0x%s status is not available", new Object[] { str3, str2 }));
/* 550 */       return false;
/*     */     } 
/* 552 */     return true;
/*     */   }
/*     */   private String getModuleName(AbsCarFunction paramAbsCarFunction) {
/*     */     String str;
/* 556 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("VehicleHelper:"); if (paramAbsCarFunction == null) { str = "no Module"; } else { str = str.getClass().getSimpleName(); }  stringBuilder.append(str); return stringBuilder.toString();
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
/* 570 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt);
/* 571 */     if (absCarFunction != null && absCarFunction.isECarXCarConnected()) {
/* 572 */       return absCarFunction.getProperty(paramInt);
/*     */     }
/* 574 */     return null;
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
/* 589 */     AbsCarFunction absCarFunction = getVehicleModule(paramInt1);
/* 590 */     if (absCarFunction != null && absCarFunction.isECarXCarConnected()) {
/* 591 */       return absCarFunction.getProperty(paramInt1, paramInt2);
/*     */     }
/* 593 */     return null;
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
/* 606 */     if (paramIProValue == null) {
/* 607 */       return CallStatus.ERROR;
/*     */     }
/* 609 */     AbsCarFunction absCarFunction = getVehicleModule(paramIProValue.getPropertyId());
/* 610 */     if (absCarFunction != null && absCarFunction.isECarXCarConnected()) {
/* 611 */       return absCarFunction.setProperty(paramIProValue);
/*     */     }
/* 613 */     return CallStatus.FAILURE;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\VehicleHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */