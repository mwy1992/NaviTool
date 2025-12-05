/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfhudManager;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HUD
/*     */   extends AbsCarFunction
/*     */   implements IHUD
/*     */ {
/*  23 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*     */   
/*     */   private ECarXCarVfhudManager mECarXCarVfhudManager;
/*     */   
/*     */   protected HUD(Context paramContext) {
/*  28 */     super(paramContext, 654311424);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  33 */     this.mECarXCarVfhudManager = this.mECarXCarSetManager.getECarXCarVfhudManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  39 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  40 */     Pairs pairs2 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*  41 */     pairs1 = pairs2.reverse();
/*     */ 
/*     */     
/*  44 */     Pairs pairs3 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  45 */     Pairs pairs4 = pairs3.add(Integer.valueOf(1), Integer.valueOf(1));
/*  46 */     pairs3 = pairs4.reverse();
/*     */ 
/*     */     
/*  49 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(537985280); int[] arrayOfInt6 = COMMON_ON_OFF;
/*  50 */     IVehicleFunction iVehicleFunction8 = iVehicleFunction11.supportedFunctionValue(arrayOfInt6);
/*  51 */     IVehicleFunction.IZone iZone7 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/*  52 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone7.useStatusPAByIntBase(33499); ECarXCarVfhudManager eCarXCarVfhudManager7 = this.mECarXCarVfhudManager; Objects.requireNonNull(eCarXCarVfhudManager7); -$$Lambda$oV7_B3zd2uhQQl2eQ-rnLKM6-f8 -$$Lambda$oV7_B3zd2uhQQl2eQ-rnLKM6-f8 = new -$$Lambda$oV7_B3zd2uhQQl2eQ-rnLKM6-f8(eCarXCarVfhudManager7);
/*  53 */     iValueTaskBuild9 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$oV7_B3zd2uhQQl2eQ-rnLKM6-f8, pairs2);
/*     */     
/*  55 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild9.useValuePAByIntBase(33499, pairs1); -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4 -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I46 = new -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4(this);
/*     */     
/*  57 */     iFilterCallback7.addTo(-$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I46);
/*     */ 
/*     */     
/*  60 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(537985536); int[] arrayOfInt5 = COMMON_ON_OFF;
/*  61 */     IVehicleFunction iVehicleFunction7 = iVehicleFunction10.supportedFunctionValue(arrayOfInt5);
/*  62 */     IVehicleFunction.IZone iZone6 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/*  63 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone6.useStatusPAByIntBase(33502); ECarXCarVfhudManager eCarXCarVfhudManager6 = this.mECarXCarVfhudManager; Objects.requireNonNull(eCarXCarVfhudManager6); -$$Lambda$COjg0smbgaFoC3XtPFN_rWOGO1A -$$Lambda$COjg0smbgaFoC3XtPFN_rWOGO1A = new -$$Lambda$COjg0smbgaFoC3XtPFN_rWOGO1A(eCarXCarVfhudManager6);
/*  64 */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$COjg0smbgaFoC3XtPFN_rWOGO1A, pairs4);
/*     */     
/*  66 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild8.useValuePAByIntBase(33502, pairs3); -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4 -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I45 = new -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4(this);
/*     */     
/*  68 */     iFilterCallback6.addTo(-$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I45);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(654378240); int[] arrayOfInt7 = COMMON_ON_OFF;
/*  85 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(arrayOfInt7);
/*  86 */     IVehicleFunction.IZone iZone5 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/*  87 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone5.useStatusPAByIntBase(33500); ECarXCarVfhudManager eCarXCarVfhudManager5 = this.mECarXCarVfhudManager; Objects.requireNonNull(eCarXCarVfhudManager5); -$$Lambda$nfCAMwLeH5byinxJVG3xZEOzUKM -$$Lambda$nfCAMwLeH5byinxJVG3xZEOzUKM = new -$$Lambda$nfCAMwLeH5byinxJVG3xZEOzUKM(eCarXCarVfhudManager5);
/*  88 */     iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$nfCAMwLeH5byinxJVG3xZEOzUKM, pairs4);
/*     */     
/*  90 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild7.useValuePAByIntBase(33500, pairs3); -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4 -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I47 = new -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4(this);
/*     */     
/*  92 */     iFilterCallback5.addTo(-$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I47);
/*     */ 
/*     */     
/*  95 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.intFunction(654378496); int[] arrayOfInt4 = COMMON_ON_OFF;
/*  96 */     IVehicleFunction iVehicleFunction5 = iVehicleFunction9.supportedFunctionValue(arrayOfInt4);
/*  97 */     IVehicleFunction.IZone iZone4 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/*  98 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone4.useStatusPAByIntBase(33501); ECarXCarVfhudManager eCarXCarVfhudManager4 = this.mECarXCarVfhudManager; Objects.requireNonNull(eCarXCarVfhudManager4); -$$Lambda$JANOlqgAgmrvw04vkCdaTjmub3o -$$Lambda$JANOlqgAgmrvw04vkCdaTjmub3o = new -$$Lambda$JANOlqgAgmrvw04vkCdaTjmub3o(eCarXCarVfhudManager4);
/*  99 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$JANOlqgAgmrvw04vkCdaTjmub3o, pairs4);
/*     */     
/* 101 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild5.useValuePAByIntBase(33501, pairs3); -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4 -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I43 = new -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4(this);
/*     */     
/* 103 */     iFilterCallback4.addTo(-$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I43);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(654379008); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 110 */     IVehicleFunction iVehicleFunction3 = iVehicleFunction4.supportedFunctionValue(arrayOfInt1);
/* 111 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/* 112 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone3.useStatusPAByIntBase(33503); ECarXCarVfhudManager eCarXCarVfhudManager3 = this.mECarXCarVfhudManager; Objects.requireNonNull(eCarXCarVfhudManager3); -$$Lambda$52BdV-CKt_TQCT9MwfpOFOcU9j0 -$$Lambda$52BdV-CKt_TQCT9MwfpOFOcU9j0 = new -$$Lambda$52BdV-CKt_TQCT9MwfpOFOcU9j0(eCarXCarVfhudManager3); -$$Lambda$HUD$eaE6L6a8Bi0O3BxNDwLvTPVI_sw -$$Lambda$HUD$eaE6L6a8Bi0O3BxNDwLvTPVI_sw = -$$Lambda$HUD$eaE6L6a8Bi0O3BxNDwLvTPVI_sw.INSTANCE;
/* 113 */     iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$52BdV-CKt_TQCT9MwfpOFOcU9j0, -$$Lambda$HUD$eaE6L6a8Bi0O3BxNDwLvTPVI_sw); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*     */     
/* 115 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild4.useValuePAByIntBase(33503, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M); -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4 -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I42 = new -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4(this);
/*     */     
/* 117 */     iFilterCallback3.addTo(-$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I42);
/*     */ 
/*     */     
/* 120 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(654442752); int[] arrayOfInt3 = COMMON_ON_OFF;
/* 121 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(arrayOfInt3);
/* 122 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/* 123 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone2.useStatusPAByIntBase(33504); ECarXCarVfhudManager eCarXCarVfhudManager2 = this.mECarXCarVfhudManager; Objects.requireNonNull(eCarXCarVfhudManager2); -$$Lambda$BWFvQySaOStkQaXytqns30xXw9g -$$Lambda$BWFvQySaOStkQaXytqns30xXw9g = new -$$Lambda$BWFvQySaOStkQaXytqns30xXw9g(eCarXCarVfhudManager2);
/* 124 */     iValueTaskBuild3 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$BWFvQySaOStkQaXytqns30xXw9g, pairs2);
/*     */     
/* 126 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild3.useValuePAByIntBase(33504, pairs1); -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4 -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I44 = new -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4(this);
/*     */     
/* 128 */     iFilterCallback2.addTo(-$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I44);
/*     */ 
/*     */     
/* 131 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(654443008); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 132 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(arrayOfInt2);
/* 133 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/* 134 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone1.useStatusPAByIntBase(33505); ECarXCarVfhudManager eCarXCarVfhudManager1 = this.mECarXCarVfhudManager; Objects.requireNonNull(eCarXCarVfhudManager1); -$$Lambda$IWb6q4DqvPt1rbwHo7fwVzrnYc0 -$$Lambda$IWb6q4DqvPt1rbwHo7fwVzrnYc0 = new -$$Lambda$IWb6q4DqvPt1rbwHo7fwVzrnYc0(eCarXCarVfhudManager1);
/* 135 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$IWb6q4DqvPt1rbwHo7fwVzrnYc0, pairs2);
/*     */     
/* 137 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33505, pairs1); -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4 -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I41 = new -$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I4(this);
/*     */     
/* 139 */     iFilterCallback1.addTo(-$$Lambda$HUD$bj5bbV4NBbT12MrirsyfFgI_2I41);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\HUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */