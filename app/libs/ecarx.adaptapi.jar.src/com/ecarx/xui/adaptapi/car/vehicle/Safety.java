/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*     */ import ecarx.os.LocalConfig;
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
/*     */ public class Safety
/*     */   extends AbsCarFunction
/*     */   implements ISafety
/*     */ {
/*  29 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*     */   private ECarXCarVfmiscManager mECarXCarVfmiscManager;
/*     */   
/*     */   protected Safety(Context paramContext) {
/*  33 */     super(paramContext, 738197504);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  38 */     this.mECarXCarVfmiscManager = this.mECarXCarSetManager.getECarXCarVfmiscManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  45 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  46 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     IVehicleFunction iVehicleFunction17 = VehicleFunction.intFunction(537920256); int[] arrayOfInt6 = COMMON_ON_OFF;
/*  56 */     IVehicleFunction iVehicleFunction11 = iVehicleFunction17.supportedFunctionValue(arrayOfInt6);
/*  57 */     IVehicleFunction.IZone iZone10 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE });
/*  58 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone10.useStatusPAByIntBase(33674); ECarXCarVfmiscManager eCarXCarVfmiscManager8 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager8); -$$Lambda$yqh9KaswBPmch7cJ7ypWRCOPZi4 -$$Lambda$yqh9KaswBPmch7cJ7ypWRCOPZi4 = new -$$Lambda$yqh9KaswBPmch7cJ7ypWRCOPZi4(eCarXCarVfmiscManager8);
/*  59 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$yqh9KaswBPmch7cJ7ypWRCOPZi4, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M4 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*     */     
/*  61 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild16.useValuePAByIntBase(33674, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M4); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI6 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/*  63 */     iFilterCallback11.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI6);
/*     */ 
/*     */     
/*  66 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(537920512);
/*  67 */     iVehicleFunction10 = iVehicleFunction10.supportedFunctionValue(new int[] { 537920513, 537920514 });
/*     */     
/*  69 */     IVehicleFunction.IZone iZone9 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE });
/*  70 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone9.useStatusPAByIntBase(33671); ECarXCarVfmiscManager eCarXCarVfmiscManager7 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager7); -$$Lambda$8-Gj1uESGYMP58Grn7JwPCPMP-s -$$Lambda$8-Gj1uESGYMP58Grn7JwPCPMP-s = new -$$Lambda$8-Gj1uESGYMP58Grn7JwPCPMP-s(eCarXCarVfmiscManager7);
/*     */     
/*  72 */     Pairs pairs4 = Pairs.of(Integer.valueOf(537920513), Integer.valueOf(0));
/*  73 */     pairs4 = pairs4.add(Integer.valueOf(537920514), Integer.valueOf(1)); iValueTaskBuild10 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$8-Gj1uESGYMP58Grn7JwPCPMP-s, pairs4);
/*     */     -$$Lambda$Safety$wQFXxIRkmHOWLtU48SriEoKdfEc -$$Lambda$Safety$wQFXxIRkmHOWLtU48SriEoKdfEc = -$$Lambda$Safety$wQFXxIRkmHOWLtU48SriEoKdfEc.INSTANCE;
/*  75 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild10.useValuePAByIntBase(33671, -$$Lambda$Safety$wQFXxIRkmHOWLtU48SriEoKdfEc); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI11 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/*  77 */     iFilterCallback9.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI11);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(537921280); int[] arrayOfInt5 = COMMON_ON_OFF;
/*  87 */     IVehicleFunction iVehicleFunction9 = iVehicleFunction16.supportedFunctionValue(arrayOfInt5);
/*  88 */     IVehicleFunction.IZone iZone8 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE });
/*  89 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone8.useStatusPAByIntBase(33637); ECarXCarVfmiscManager eCarXCarVfmiscManager6 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager6); -$$Lambda$rswyFlSVh5LubZ9k4Lh0TE2jDV0 -$$Lambda$rswyFlSVh5LubZ9k4Lh0TE2jDV0 = new -$$Lambda$rswyFlSVh5LubZ9k4Lh0TE2jDV0(eCarXCarVfmiscManager6);
/*  90 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$rswyFlSVh5LubZ9k4Lh0TE2jDV0, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M3 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*     */     
/*  92 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild15.useValuePAByIntBase(33637, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M3); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI10 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/*  94 */     iFilterCallback8.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI10);
/*     */ 
/*     */     
/*  97 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.intFunction(537921536); int[] arrayOfInt4 = COMMON_ON_OFF;
/*  98 */     IVehicleFunction iVehicleFunction8 = iVehicleFunction15.supportedFunctionValue(arrayOfInt4);
/*  99 */     IVehicleFunction.IZone iZone7 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/* 100 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone7.useStatusPAByIntBase(33638); ECarXCarVfmiscManager eCarXCarVfmiscManager5 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager5); -$$Lambda$SOapoP6ls7LpUAwAdUovV7n38R0 -$$Lambda$SOapoP6ls7LpUAwAdUovV7n38R0 = new -$$Lambda$SOapoP6ls7LpUAwAdUovV7n38R0(eCarXCarVfmiscManager5);
/* 101 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$SOapoP6ls7LpUAwAdUovV7n38R0, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*     */     
/* 103 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild14.useValuePAByIntBase(33638, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI9 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/* 105 */     iFilterCallback7.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI9);
/*     */ 
/*     */     
/* 108 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(537921792); int[] arrayOfInt3 = COMMON_ON_OFF;
/* 109 */     IVehicleFunction iVehicleFunction7 = iVehicleFunction14.supportedFunctionValue(arrayOfInt3);
/* 110 */     IVehicleFunction.IZone iZone11 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 111 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone11.fixStatus(functionStatus2);
/*     */     
/* 113 */     Pairs pairs3 = Pairs.of(Integer.valueOf(3), Integer.valueOf(1));
/* 114 */     pairs3 = pairs3.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild7.useValueSignal(30641, pairs3); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI8 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/* 115 */     iFilterCallback6.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI8);
/*     */ 
/*     */     
/* 118 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(537922048);
/* 119 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 0, 1 });
/*     */     
/* 121 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/* 122 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone6.useStatusPAByIntBase(33673); ECarXCarVfmiscManager eCarXCarVfmiscManager4 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager4); -$$Lambda$D8KE4jMTPkzqOch7xJYWDuCOV0M -$$Lambda$D8KE4jMTPkzqOch7xJYWDuCOV0M = new -$$Lambda$D8KE4jMTPkzqOch7xJYWDuCOV0M(eCarXCarVfmiscManager4);
/*     */     
/* 124 */     pairs4 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 125 */     pairs4 = pairs4.add(Integer.valueOf(1), Integer.valueOf(1)); IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$D8KE4jMTPkzqOch7xJYWDuCOV0M, pairs4); -$$Lambda$Safety$-5fv7o2ZP5JjPDcOLTfONLYzAaI -$$Lambda$Safety$-5fv7o2ZP5JjPDcOLTfONLYzAaI = -$$Lambda$Safety$-5fv7o2ZP5JjPDcOLTfONLYzAaI.INSTANCE;
/* 126 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild13.useValuePAByIntBase(33673, -$$Lambda$Safety$-5fv7o2ZP5JjPDcOLTfONLYzAaI); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI7 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/* 128 */     iFilterCallback5.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI7);
/*     */ 
/*     */     
/* 131 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.intFunction(738263296); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 132 */     IVehicleFunction iVehicleFunction5 = iVehicleFunction13.supportedFunctionValue(arrayOfInt2);
/* 133 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 134 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone5.useStatusPAByIntBase(33672); ECarXCarVfmiscManager eCarXCarVfmiscManager3 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager3); -$$Lambda$w5RmdfpxJqHC1_RRFiGccuvGK7c -$$Lambda$w5RmdfpxJqHC1_RRFiGccuvGK7c = new -$$Lambda$w5RmdfpxJqHC1_RRFiGccuvGK7c(eCarXCarVfmiscManager3);
/* 135 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iValueTaskBuild5.onSetFunctionValue(-$$Lambda$w5RmdfpxJqHC1_RRFiGccuvGK7c, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*     */     
/* 137 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild12.useValuePAByIntBase(33672, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI5 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/* 139 */     iFilterCallback10.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.intFunction(738264320); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 156 */     IVehicleFunction iVehicleFunction4 = iVehicleFunction12.supportedFunctionValue(arrayOfInt1);
/* 157 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 158 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone4.useStatusPAByIntBase(33710); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$EOnIrTEnaNphTz_JhzycinZwLXY -$$Lambda$EOnIrTEnaNphTz_JhzycinZwLXY = new -$$Lambda$EOnIrTEnaNphTz_JhzycinZwLXY(eCarXCarVfmiscManager2);
/* 159 */     iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$EOnIrTEnaNphTz_JhzycinZwLXY, pairs1); -$$Lambda$vpmgQkU8L-t6H_6y3S9c-Bf2Dvk -$$Lambda$vpmgQkU8L-t6H_6y3S9c-Bf2Dvk = -$$Lambda$vpmgQkU8L-t6H_6y3S9c-Bf2Dvk.INSTANCE;
/*     */     
/* 161 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild4.useValuePAByIntBase(33710, -$$Lambda$vpmgQkU8L-t6H_6y3S9c-Bf2Dvk); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI4 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/* 163 */     iFilterCallback1.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(738265088);
/* 173 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(new int[] { 0, 738265089, 738265090, 738265091, 738265092, 738265093 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 179 */     IVehicleFunction.IZone iZone2 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/* 180 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone2.useStatusPAByIntBase(33686); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$LJQUjrQC_Wqg86ejtwFZgoFpLL8 -$$Lambda$LJQUjrQC_Wqg86ejtwFZgoFpLL8 = new -$$Lambda$LJQUjrQC_Wqg86ejtwFZgoFpLL8(eCarXCarVfmiscManager1);
/*     */     
/* 182 */     Pairs pairs2 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 183 */     pairs2 = pairs2.add(Integer.valueOf(738265089), Integer.valueOf(1));
/* 184 */     pairs2 = pairs2.add(Integer.valueOf(738265090), Integer.valueOf(2));
/* 185 */     pairs2 = pairs2.add(Integer.valueOf(738265091), Integer.valueOf(3));
/* 186 */     pairs2 = pairs2.add(Integer.valueOf(738265092), Integer.valueOf(4));
/* 187 */     pairs2 = pairs2.add(Integer.valueOf(738265093), Integer.valueOf(5)); iValueTaskBuild1 = iValueTaskBuild1.onSetFunctionValue(-$$Lambda$LJQUjrQC_Wqg86ejtwFZgoFpLL8, pairs2); -$$Lambda$Safety$gmGmefHDvhc4aGTlskjzeTt0fwA -$$Lambda$Safety$gmGmefHDvhc4aGTlskjzeTt0fwA = -$$Lambda$Safety$gmGmefHDvhc4aGTlskjzeTt0fwA.INSTANCE;
/* 188 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild1.useValuePAByIntBase(33686, -$$Lambda$Safety$gmGmefHDvhc4aGTlskjzeTt0fwA); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI3 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/* 190 */     iFilterCallback4.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(738330112);
/* 212 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(new int[] { 738330113, 738330114, 738330115, 738330116, 738330117, 738330118, 738330119, 738330120, 738330121, 738330128, 738330129 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     IVehicleFunction.IZone iZone1 = iVehicleFunction2.createZone();
/* 224 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone1.useStatusPAByIntBase(33687); -$$Lambda$Safety$tXF79pfr_UiXaglWfs9Hi-Xb5NU -$$Lambda$Safety$tXF79pfr_UiXaglWfs9Hi-Xb5NU = -$$Lambda$Safety$tXF79pfr_UiXaglWfs9Hi-Xb5NU.INSTANCE;
/* 225 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild3.useValuePAByIntBase(33687, -$$Lambda$Safety$tXF79pfr_UiXaglWfs9Hi-Xb5NU); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI2 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/*     */     
/* 227 */     iFilterCallback3.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI2);
/*     */ 
/*     */     
/* 230 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(738330368);
/* 231 */     IVehicleFunction.IZone iZone3 = iVehicleFunction1.createZone(); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 232 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone3.fixStatus(functionStatus1); -$$Lambda$Safety$GZEuah4x9q4hMvfCO36DFBTTXEU -$$Lambda$Safety$GZEuah4x9q4hMvfCO36DFBTTXEU = -$$Lambda$Safety$GZEuah4x9q4hMvfCO36DFBTTXEU.INSTANCE;
/* 233 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild2.customValue(-$$Lambda$Safety$GZEuah4x9q4hMvfCO36DFBTTXEU); -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI1 = new -$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI(this);
/* 234 */     iFilterCallback2.addTo(-$$Lambda$Safety$Ui-JDSpMf_ZcYWSoGw61NF3XtsI1);
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
/*     */   private static int convertToPATailGateStsValue(int paramInt) {
/* 251 */     int i = 738330113;
/* 252 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 289 */         return paramInt;case 10: paramInt = 738330129; return paramInt;case 9: paramInt = 738330128; return paramInt;case 8: paramInt = 738330121; return paramInt;case 7: paramInt = 738330120; return paramInt;case 6: paramInt = 738330119; return paramInt;case 5: paramInt = 738330118; return paramInt;case 4: paramInt = 738330117; return paramInt;case 3: paramInt = 738330116; return paramInt;case 2: paramInt = 738330115; return paramInt;case 1: paramInt = 738330114; return paramInt;case 0: break; }  paramInt = 738330113; return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int convertPAOpenPos(int paramInt) {
/* 294 */     boolean bool = false;
/* 295 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 312 */         return paramInt;case 5: paramInt = 738265093; return paramInt;case 4: paramInt = 738265092; return paramInt;case 3: paramInt = 738265091; return paramInt;case 2: paramInt = 738265090; return paramInt;case 1: break; }  paramInt = 738265089; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int convertPAEventHeylessUnlockValue(int paramInt) {
/* 320 */     int i = 537920513;
/* 321 */     if (paramInt == 1) {
/* 322 */       i = 537920514;
/*     */     }
/* 324 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int convertPAEventTwoStepUnlockingValue(int paramInt) {
/* 332 */     boolean bool = false;
/* 333 */     if (paramInt == 1) {
/* 334 */       bool = true;
/*     */     }
/* 336 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Safety.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */