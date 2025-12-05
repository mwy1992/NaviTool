/*     */ package com.ecarx.xui.adaptapi.car.hvac;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarAirqlyandfragraManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Fragrance
/*     */   extends AbsCarFunction
/*     */   implements IFragrance
/*     */ {
/*     */   private ECarXCarAirqlyandfragraManager mFragranceMgr;
/*     */   
/*     */   public Fragrance(Context paramContext) {
/*  42 */     super(paramContext, 268435456);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  47 */     this.mFragranceMgr = this.mECarXCarSetManager.getECarXCarAirqlyandfragraManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  53 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(269156608);
/*  54 */     iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(new int[] { 1, 0 });
/*  55 */     IVehicleFunction.IZone iZone10 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/*  56 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone10.useStatusPAByIntBase(33406); ECarXCarAirqlyandfragraManager eCarXCarAirqlyandfragraManager3 = this.mFragranceMgr; Objects.requireNonNull(eCarXCarAirqlyandfragraManager3); -$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW4 -$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW42 = new -$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW4(eCarXCarAirqlyandfragraManager3);
/*     */ 
/*     */     
/*  59 */     Pairs pairs5 = Pairs.of(Integer.valueOf(1), Integer.valueOf(2));
/*  60 */     pairs5 = pairs5.add(Integer.valueOf(0), Integer.valueOf(0));
/*     */     
/*     */     iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW42, pairs5);
/*  63 */     Pairs pairs4 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  64 */     pairs4 = pairs4.orDefault(Integer.valueOf(1)); IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild7.useValuePAByIntBase(33413, pairs4); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg8 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/*  65 */     iFilterCallback9.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg8);
/*     */ 
/*     */     
/*  68 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(269156864);
/*  69 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 0, 269156865, 269156866, 269156867, 269156868, 269156869, 269156870 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     IVehicleFunction.IZone iZone9 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/*  77 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone9.useStatusPAByIntBase(33406); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg4 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/*  78 */     iValueTaskBuild15.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg4);
/*     */ 
/*     */     
/*  81 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(269157120);
/*  82 */     iVehicleFunction5 = iVehicleFunction5.supportedFunctionValue(new int[] { 0, 269157121, 269157122, 269157123 });
/*     */ 
/*     */ 
/*     */     
/*  86 */     IVehicleFunction.IZone iZone8 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/*  87 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus = iZone8.useStatusSignals(new int[] { 33406, 33416 }); -$$Lambda$Fragrance$v4smPWLlCvoQu3fifW4s2Fewbj8 -$$Lambda$Fragrance$v4smPWLlCvoQu3fifW4s2Fewbj8 = new -$$Lambda$Fragrance$v4smPWLlCvoQu3fifW4s2Fewbj8(this);
/*     */ 
/*     */     
/*  90 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iMultiSignalStatus.onStatusSignalChanged(-$$Lambda$Fragrance$v4smPWLlCvoQu3fifW4s2Fewbj8); ECarXCarAirqlyandfragraManager eCarXCarAirqlyandfragraManager2 = this.mFragranceMgr; Objects.requireNonNull(eCarXCarAirqlyandfragraManager2); -$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW4 -$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW41 = new -$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW4(eCarXCarAirqlyandfragraManager2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     pairs5 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 104 */     pairs5 = pairs5.add(Integer.valueOf(269157121), Integer.valueOf(1));
/* 105 */     pairs5 = pairs5.add(Integer.valueOf(269157122), Integer.valueOf(2));
/* 106 */     pairs5 = pairs5.add(Integer.valueOf(269157123), Integer.valueOf(3)); iValueTaskBuild6 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$z08oYD6UCxAqb6FzXxXmpTPlxW41, pairs5); -$$Lambda$Fragrance$OdAcXVjZUJGkXTdc6K_QmOL5Gno -$$Lambda$Fragrance$OdAcXVjZUJGkXTdc6K_QmOL5Gno = new -$$Lambda$Fragrance$OdAcXVjZUJGkXTdc6K_QmOL5Gno(this);
/* 107 */     IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild6.useValuePAByIntBase(33413, -$$Lambda$Fragrance$OdAcXVjZUJGkXTdc6K_QmOL5Gno); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg3 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/* 108 */     iFilterCallback15.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg3);
/*     */ 
/*     */     
/* 111 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(269157376);
/* 112 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(new int[] { 269157377, 269157378, 269157379 });
/*     */ 
/*     */ 
/*     */     
/* 116 */     IVehicleFunction.IZone iZone7 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 117 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone7.useStatusPAByIntBase(33406); -$$Lambda$Fragrance$vXGD8FB9tbqa1lCnCQA0HHqjoDg -$$Lambda$Fragrance$vXGD8FB9tbqa1lCnCQA0HHqjoDg = new -$$Lambda$Fragrance$vXGD8FB9tbqa1lCnCQA0HHqjoDg(this);
/* 118 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$Fragrance$vXGD8FB9tbqa1lCnCQA0HHqjoDg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue = iValueTaskBuild5.useValueSignals(new int[] { 33428, 33429, 33430 }); -$$Lambda$Fragrance$U2ZrnxSVxbS8uCs-R3bowTni_fQ -$$Lambda$Fragrance$U2ZrnxSVxbS8uCs-R3bowTni_fQ = new -$$Lambda$Fragrance$U2ZrnxSVxbS8uCs-R3bowTni_fQ(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iMultiSignalValue.onValueSignalChanged(-$$Lambda$Fragrance$U2ZrnxSVxbS8uCs-R3bowTni_fQ); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg7 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     iFilterCallback8.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg7);
/*     */ 
/*     */     
/* 160 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(269157632);
/* 161 */     IVehicleFunction.IZone iZone6 = iVehicleFunction3.createZone(new int[] { 269157377 });
/* 162 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone6.useStatusPAByIntBase(33406);
/*     */     
/* 164 */     Function<?, ?> function4 = Function.identity(); IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild4.useValuePAByIntBase(33418, function4);
/* 165 */     IVehicleFunction.IZone iZone5 = iFilterCallback7.createZone(new int[] { 269157378 });
/* 166 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone5.useStatusPAByIntBase(33406);
/*     */     
/* 168 */     function4 = Function.identity(); IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild3.useValuePAByIntBase(33419, function4);
/* 169 */     IVehicleFunction.IZone iZone4 = iFilterCallback6.createZone(new int[] { 269157379 });
/* 170 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone4.useStatusPAByIntBase(33406);
/*     */     
/* 172 */     Function<?, ?> function3 = Function.identity(); IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild13.useValuePAByIntBase(33420, function3);
/* 173 */     IVehicleFunction.IZone iZone3 = iFilterCallback5.createZone(new int[] { 269157380 });
/* 174 */     iValueTaskBuild13 = iZone3.useStatusPAByIntBase(33406);
/*     */     
/* 176 */     Function<?, ?> function2 = Function.identity(); IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild13.useValuePAByIntBase(33421, function2);
/* 177 */     IVehicleFunction.IZone iZone2 = iFilterCallback4.createZone(new int[] { 269157381 });
/* 178 */     iValueTaskBuild13 = iZone2.useStatusPAByIntBase(33406);
/*     */     
/* 180 */     Function<?, ?> function1 = Function.identity(); IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild13.useValuePAByIntBase(33422, function1); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg6 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/* 181 */     iFilterCallback3.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg6);
/*     */ 
/*     */     
/* 184 */     Pairs pairs1 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 185 */     pairs1 = pairs1.add(Integer.valueOf(0), Integer.valueOf(0));
/* 186 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(269157888);
/* 187 */     IVehicleFunction.IZone iZone16 = iVehicleFunction8.createZone(new int[] { 269157377 });
/* 188 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone16.useStatusPAByIntBase(33406);
/* 189 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild12.useValuePAByIntBase(33423, pairs1);
/*     */     
/* 191 */     IVehicleFunction.IZone iZone15 = iFilterCallback14.createZone(new int[] { 269157378 });
/* 192 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone15.useStatusPAByIntBase(33406);
/* 193 */     IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild11.useValuePAByIntBase(33424, pairs1);
/*     */     
/* 195 */     IVehicleFunction.IZone iZone14 = iFilterCallback13.createZone(new int[] { 269157379 });
/* 196 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone14.useStatusPAByIntBase(33406);
/* 197 */     IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild10.useValuePAByIntBase(33425, pairs1);
/*     */     
/* 199 */     IVehicleFunction.IZone iZone13 = iFilterCallback12.createZone(new int[] { 269157380 });
/* 200 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone13.useStatusPAByIntBase(33406);
/* 201 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild9.useValuePAByIntBase(33426, pairs1);
/*     */     
/* 203 */     IVehicleFunction.IZone iZone12 = iFilterCallback11.createZone(new int[] { 269157381 });
/* 204 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone12.useStatusPAByIntBase(33406);
/* 205 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild8.useValuePAByIntBase(33427, pairs1); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg2 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/*     */     
/* 207 */     iFilterCallback10.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg2);
/*     */ 
/*     */     
/* 210 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(269160704);
/* 211 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(new int[] { 1, 0 });
/* 212 */     IVehicleFunction.IZone iZone1 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/* 213 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone1.useStatusPAByIntBase(33406); ECarXCarAirqlyandfragraManager eCarXCarAirqlyandfragraManager1 = this.mFragranceMgr; Objects.requireNonNull(eCarXCarAirqlyandfragraManager1); -$$Lambda$nsvyUHUHdXEWitiVCquvjWgb10U -$$Lambda$nsvyUHUHdXEWitiVCquvjWgb10U = new -$$Lambda$nsvyUHUHdXEWitiVCquvjWgb10U(eCarXCarAirqlyandfragraManager1);
/*     */     
/* 215 */     pairs5 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 216 */     pairs5 = pairs5.add(Integer.valueOf(0), Integer.valueOf(0));
/*     */     
/*     */     iValueTaskBuild2 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$nsvyUHUHdXEWitiVCquvjWgb10U, pairs5);
/* 219 */     Pairs pairs3 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 220 */     pairs3 = pairs3.add(Integer.valueOf(0), Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild2.useValuePAByIntBase(33433, pairs3); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg5 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/* 221 */     iFilterCallback2.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg5);
/*     */ 
/*     */     
/* 224 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(269160960);
/* 225 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 269160961 });
/* 226 */     IVehicleFunction.IZone iZone11 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus = FunctionStatus.active;
/* 227 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone11.fixStatus(functionStatus);
/*     */ 
/*     */     
/* 230 */     Pairs pairs2 = Pairs.of(Integer.valueOf(1), Integer.valueOf(269160961));
/* 231 */     pairs2 = pairs2.orDefault(Integer.valueOf(255)); IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33417, pairs2); -$$Lambda$Fragrance$YiDTTBB431PKcHmZRbIWGhOYSKM -$$Lambda$Fragrance$YiDTTBB431PKcHmZRbIWGhOYSKM = -$$Lambda$Fragrance$YiDTTBB431PKcHmZRbIWGhOYSKM.INSTANCE;
/* 232 */     IVehicleFunction.ITaskEnd iTaskEnd = iFilterCallback1.filterValue(-$$Lambda$Fragrance$YiDTTBB431PKcHmZRbIWGhOYSKM); -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg1 = new -$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg(this);
/* 233 */     iTaskEnd.addTo(-$$Lambda$Fragrance$UTtTjKtUKhTM7WRd7ZzphZD9ydg1);
/*     */   }
/*     */ 
/*     */   
/*     */   private int convertFragranceLevel(int paramInt) {
/* 238 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 246 */         return 0;
/*     */       case 3:
/*     */         return 269157123;
/*     */       case 2:
/*     */         return 269157122;
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     return 269157121;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hvac\Fragrance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */