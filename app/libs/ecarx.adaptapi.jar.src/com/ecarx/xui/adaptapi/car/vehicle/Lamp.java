/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarAmbliManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Lamp
/*     */   extends AbsCarFunction
/*     */   implements ILamp
/*     */ {
/*  28 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 }; private ECarXCarAmbliManager mECarXCarAmbliManager;
/*     */   
/*     */   protected Lamp(Context paramContext) {
/*  31 */     super(paramContext, 721420288);
/*     */   }
/*     */   private ECarXCarVfmiscManager mECarXCarVfmiscManager;
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  36 */     this.mECarXCarVfmiscManager = paramECarXCarSetManager.getECarXCarVfmiscManager();
/*  37 */     this.mECarXCarAmbliManager = paramECarXCarSetManager.getECarXCarAmbliManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  44 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  45 */     Pairs pairs2 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*  46 */     pairs1 = pairs2.reverse();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(537134336); int[] arrayOfInt3 = COMMON_ON_OFF;
/*  62 */     IVehicleFunction iVehicleFunction7 = iVehicleFunction10.supportedFunctionValue(arrayOfInt3);
/*  63 */     IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/*  64 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone7.useStatusPAByIntBase(33649); ECarXCarVfmiscManager eCarXCarVfmiscManager5 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager5); -$$Lambda$sC-HBxzaqPaOtEplqkbfWlv7U1Q -$$Lambda$sC-HBxzaqPaOtEplqkbfWlv7U1Q = new -$$Lambda$sC-HBxzaqPaOtEplqkbfWlv7U1Q(eCarXCarVfmiscManager5);
/*  65 */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$sC-HBxzaqPaOtEplqkbfWlv7U1Q, pairs2);
/*     */     
/*  67 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild8.useValuePAByIntBase(33649, pairs1); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM10 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/*  69 */     iFilterCallback7.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM10);
/*     */ 
/*     */     
/*  72 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(537134592); int[] arrayOfInt7 = COMMON_ON_OFF;
/*  73 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(arrayOfInt7);
/*  74 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/*  75 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone6.useStatusPAByIntBase(33848); ECarXCarAmbliManager eCarXCarAmbliManager2 = this.mECarXCarAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager2); -$$Lambda$a7FpCPOtlBmq9lbHdzk6YpabCfc -$$Lambda$a7FpCPOtlBmq9lbHdzk6YpabCfc = new -$$Lambda$a7FpCPOtlBmq9lbHdzk6YpabCfc(eCarXCarAmbliManager2);
/*  76 */     iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$a7FpCPOtlBmq9lbHdzk6YpabCfc, pairs2);
/*     */     
/*  78 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild7.useValuePAByIntBase(33848, pairs1); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM4 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/*  80 */     iFilterCallback10.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM4);
/*     */ 
/*     */ 
/*     */     
/*  84 */     Pairs pairs5 = Pairs.of(Integer.valueOf(537134849), Integer.valueOf(3));
/*     */     
/*  86 */     pairs5 = pairs5.add(Integer.valueOf(537134850), Integer.valueOf(6));
/*  87 */     pairs5 = pairs5.add(Integer.valueOf(537134851), Integer.valueOf(9));
/*  88 */     Pairs pairs8 = pairs5.add(Integer.valueOf(0), Integer.valueOf(0));
/*  89 */     pairs5 = pairs8.reverse();
/*  90 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.intFunction(537134848);
/*  91 */     iVehicleFunction13 = iVehicleFunction13.supportedFunctionValue(new int[] { 0, 537134849, 537134850, 537134851 });
/*     */ 
/*     */ 
/*     */     
/*  95 */     IVehicleFunction.IZone iZone10 = iVehicleFunction13.createZone(new int[] { Integer.MIN_VALUE });
/*  96 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone10.useStatusPAByIntBase(33647); ECarXCarVfmiscManager eCarXCarVfmiscManager8 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager8); -$$Lambda$hFWFn_OR5NYHBAlpF5uwctMzQcA -$$Lambda$hFWFn_OR5NYHBAlpF5uwctMzQcA = new -$$Lambda$hFWFn_OR5NYHBAlpF5uwctMzQcA(eCarXCarVfmiscManager8);
/*  97 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$hFWFn_OR5NYHBAlpF5uwctMzQcA, pairs8);
/*     */     
/*  99 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild11.useValuePAByIntBase(33647, pairs5); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM9 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 101 */     iFilterCallback6.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM9);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.intFunction(537135360); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 108 */     IVehicleFunction iVehicleFunction5 = iVehicleFunction9.supportedFunctionValue(arrayOfInt2);
/* 109 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 110 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone5.useStatusPAByIntBase(33648); ECarXCarVfmiscManager eCarXCarVfmiscManager4 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager4); -$$Lambda$Tf3yD5WApzVrfOA8UH9Uiqbcj8c -$$Lambda$Tf3yD5WApzVrfOA8UH9Uiqbcj8c = new -$$Lambda$Tf3yD5WApzVrfOA8UH9Uiqbcj8c(eCarXCarVfmiscManager4);
/* 111 */     iValueTaskBuild6 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$Tf3yD5WApzVrfOA8UH9Uiqbcj8c, pairs2);
/*     */     
/* 113 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild6.useValuePAByIntBase(33648, pairs1); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM3 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 115 */     iFilterCallback9.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM3);
/*     */ 
/*     */     
/* 118 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(537135616); int[] arrayOfInt6 = COMMON_ON_OFF;
/* 119 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(arrayOfInt6);
/* 120 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 121 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone4.useStatusPAByIntBase(33646); ECarXCarVfmiscManager eCarXCarVfmiscManager3 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager3); -$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI -$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI = new -$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI(eCarXCarVfmiscManager3);
/* 122 */     iValueTaskBuild5 = iValueTaskBuild5.onSetFunctionValue(-$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI, pairs2);
/*     */     
/* 124 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild5.useValuePAByIntBase(33646, pairs1); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM2 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 126 */     iFilterCallback8.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(537136384); int[] arrayOfInt5 = COMMON_ON_OFF;
/* 136 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(arrayOfInt5);
/* 137 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/* 138 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone3.useStatusPAByIntBase(33645); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ -$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ = new -$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ(eCarXCarVfmiscManager2);
/* 139 */     iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ, pairs2);
/*     */     
/* 141 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild4.useValuePAByIntBase(33645, pairs1); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM8 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 143 */     iFilterCallback5.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     Pairs pairs4 = Pairs.of(Integer.valueOf(721551617), Integer.valueOf(1));
/*     */     
/* 157 */     Pairs pairs7 = pairs4.add(Integer.valueOf(721551618), Integer.valueOf(0));
/* 158 */     pairs4 = pairs7.reverse();
/* 159 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.intFunction(721551616);
/* 160 */     iVehicleFunction12 = iVehicleFunction12.supportedFunctionValue(new int[] { 721551617, 721551618 });
/*     */ 
/*     */     
/* 163 */     IVehicleFunction.IZone iZone9 = iVehicleFunction12.createZone(new int[] { Integer.MIN_VALUE });
/* 164 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone9.useStatusPAByIntBase(33650); ECarXCarVfmiscManager eCarXCarVfmiscManager7 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager7); -$$Lambda$8xzuvOg6SLTyTNqgLGqoiYbuLng -$$Lambda$8xzuvOg6SLTyTNqgLGqoiYbuLng = new -$$Lambda$8xzuvOg6SLTyTNqgLGqoiYbuLng(eCarXCarVfmiscManager7);
/* 165 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$8xzuvOg6SLTyTNqgLGqoiYbuLng, pairs7);
/*     */     
/* 167 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild10.useValuePAByIntBase(33650, pairs4); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM7 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 169 */     iFilterCallback4.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 179 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(721617152); int[] arrayOfInt4 = COMMON_ON_OFF;
/* 180 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(arrayOfInt4);
/* 181 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/* 182 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone2.useStatusPAByIntBase(33651); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$Fz6qQo4jikzFoexNBI442yhiidQ -$$Lambda$Fz6qQo4jikzFoexNBI442yhiidQ = new -$$Lambda$Fz6qQo4jikzFoexNBI442yhiidQ(eCarXCarVfmiscManager1);
/* 183 */     iValueTaskBuild3 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$Fz6qQo4jikzFoexNBI442yhiidQ, pairs2);
/*     */     
/* 185 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild3.useValuePAByIntBase(33651, pairs1); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM6 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 187 */     iFilterCallback3.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM6);
/*     */ 
/*     */ 
/*     */     
/* 191 */     Pairs pairs3 = Pairs.of(Integer.valueOf(721617409), Integer.valueOf(0));
/* 192 */     pairs3 = pairs3.add(Integer.valueOf(721617410), Integer.valueOf(1));
/* 193 */     pairs3 = pairs3.add(Integer.valueOf(721617411), Integer.valueOf(2));
/* 194 */     pairs3 = pairs3.add(Integer.valueOf(721617412), Integer.valueOf(3));
/* 195 */     pairs3 = pairs3.add(Integer.valueOf(721617413), Integer.valueOf(4));
/* 196 */     Pairs pairs6 = pairs3.add(Integer.valueOf(721617414), Integer.valueOf(5));
/* 197 */     pairs3 = pairs6.reverse();
/*     */     
/* 199 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(721617408);
/* 200 */     iVehicleFunction11 = iVehicleFunction11.supportedFunctionValue(new int[] { 721617409, 721617410, 721617411, 721617412, 721617413, 721617414 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     IVehicleFunction.IZone iZone8 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE });
/* 208 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone8.useStatusPAByIntBase(33652); ECarXCarVfmiscManager eCarXCarVfmiscManager6 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager6); -$$Lambda$B641nUad9mnPZ3jXE6xPlOMq7E4 -$$Lambda$B641nUad9mnPZ3jXE6xPlOMq7E4 = new -$$Lambda$B641nUad9mnPZ3jXE6xPlOMq7E4(eCarXCarVfmiscManager6);
/* 209 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$B641nUad9mnPZ3jXE6xPlOMq7E4, pairs6);
/*     */     
/* 211 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild9.useValuePAByIntBase(33652, pairs3); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM5 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 213 */     iFilterCallback2.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM5);
/*     */ 
/*     */     
/* 216 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(721617664); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 217 */     IVehicleFunction iVehicleFunction1 = iVehicleFunction8.supportedFunctionValue(arrayOfInt1);
/* 218 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/* 219 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone1.useStatusPAByIntBase(33852); ECarXCarAmbliManager eCarXCarAmbliManager1 = this.mECarXCarAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager1); -$$Lambda$nfsB-rc77OiO1k72HDlzgj5QvxI -$$Lambda$nfsB-rc77OiO1k72HDlzgj5QvxI = new -$$Lambda$nfsB-rc77OiO1k72HDlzgj5QvxI(eCarXCarAmbliManager1);
/* 220 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$nfsB-rc77OiO1k72HDlzgj5QvxI, pairs2);
/*     */     
/* 222 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33852, pairs1); -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM1 = new -$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM(this);
/*     */     
/* 224 */     iFilterCallback1.addTo(-$$Lambda$Lamp$rn4wmomRvWm2ndRoeQsYdBxzZOM1);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Lamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */