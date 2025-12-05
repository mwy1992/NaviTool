/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.SignalUtils;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
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
/*     */ public class Hybrid
/*     */   extends AbsCarFunction
/*     */   implements IHybrid
/*     */ {
/*  27 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*     */   private ECarXCarVfmiscManager mECarXCarVfmiscManager;
/*     */   
/*     */   protected Hybrid(Context paramContext) {
/*  31 */     super(paramContext, 603979776);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  36 */     this.mECarXCarVfmiscManager = paramECarXCarSetManager.getECarXCarVfmiscManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  42 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  43 */     Pairs pairs2 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*  44 */     pairs1 = pairs2.reverse();
/*     */ 
/*     */ 
/*     */     
/*  48 */     Pairs pairs3 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  49 */     pairs3 = pairs3.add(Integer.valueOf(1), Integer.valueOf(604045569));
/*  50 */     pairs3 = pairs3.add(Integer.valueOf(2), Integer.valueOf(604045570));
/*  51 */     pairs3 = pairs3.add(Integer.valueOf(3), Integer.valueOf(604045571));
/*  52 */     pairs3 = pairs3.add(Integer.valueOf(4), Integer.valueOf(604045572));
/*  53 */     pairs3 = pairs3.add(Integer.valueOf(5), Integer.valueOf(604045573));
/*  54 */     pairs3 = pairs3.add(Integer.valueOf(6), Integer.valueOf(604045574));
/*  55 */     pairs3 = pairs3.add(Integer.valueOf(7), Integer.valueOf(604045575));
/*  56 */     pairs3 = pairs3.add(Integer.valueOf(8), Integer.valueOf(604045576));
/*     */     
/*  58 */     pairs3 = pairs3.add(Integer.valueOf(9), Integer.valueOf(604045577));
/*     */     
/*  60 */     pairs3 = pairs3.add(Integer.valueOf(10), Integer.valueOf(604045578));
/*     */     
/*  62 */     pairs3 = pairs3.add(Integer.valueOf(11), Integer.valueOf(604045579));
/*     */     
/*  64 */     pairs3 = pairs3.add(Integer.valueOf(12), Integer.valueOf(604045580));
/*     */     
/*  66 */     pairs3 = pairs3.add(Integer.valueOf(13), Integer.valueOf(604045581));
/*  67 */     pairs3 = pairs3.add(Integer.valueOf(14), Integer.valueOf(604045591));
/*     */     
/*  69 */     pairs3 = pairs3.add(Integer.valueOf(15), Integer.valueOf(604045592));
/*     */     
/*  71 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(604045568);
/*  72 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 0, 604045569, 604045570, 604045571, 604045572, 604045573, 604045574, 604045575, 604045576, 604045577, 604045578, 604045579, 604045580, 604045581, 604045582, 604045583, 604045584, 604045585, 604045586, 604045587, 604045588, 604045589, 604045590, 604045591, 604045592 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     IVehicleFunction.IZone iZone4 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/* 100 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus = iZone4.useStatusSignals(new int[] { 33705, 33669 }); -$$Lambda$Hybrid$UgSfkpmEmkxR1aadSQ-Z8NVab38 -$$Lambda$Hybrid$UgSfkpmEmkxR1aadSQ-Z8NVab38 = new -$$Lambda$Hybrid$UgSfkpmEmkxR1aadSQ-Z8NVab38(this);
/*     */     
/* 102 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iMultiSignalStatus.onStatusSignalChanged(-$$Lambda$Hybrid$UgSfkpmEmkxR1aadSQ-Z8NVab38);
/* 103 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue = iValueTaskBuild5.useValueSignals(new int[] { 33705, 33669 }); -$$Lambda$Hybrid$e8lLk4fe-as__PGIwFfshQthnZ4 -$$Lambda$Hybrid$e8lLk4fe-as__PGIwFfshQthnZ4 = new -$$Lambda$Hybrid$e8lLk4fe-as__PGIwFfshQthnZ4(this, pairs3);
/*     */     
/* 105 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iMultiSignalValue.onValueSignalChanged(-$$Lambda$Hybrid$e8lLk4fe-as__PGIwFfshQthnZ4); -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so3 = new -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     iFilterCallback4.addTo(-$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so3);
/*     */ 
/*     */     
/* 123 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(604111104); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 124 */     IVehicleFunction iVehicleFunction3 = iVehicleFunction5.supportedFunctionValue(arrayOfInt2);
/* 125 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$Hybrid$qtFXIOfPVEuo4MYFTyrYNPUH0mg -$$Lambda$Hybrid$qtFXIOfPVEuo4MYFTyrYNPUH0mg = -$$Lambda$Hybrid$qtFXIOfPVEuo4MYFTyrYNPUH0mg.INSTANCE;
/* 126 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone3.useStatusPAByIntBase(33680, -$$Lambda$Hybrid$qtFXIOfPVEuo4MYFTyrYNPUH0mg); ECarXCarVfmiscManager eCarXCarVfmiscManager3 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager3); -$$Lambda$leajoFBPPtqLUjd6-CYwtLyQ5Ao -$$Lambda$leajoFBPPtqLUjd6-CYwtLyQ5Ao = new -$$Lambda$leajoFBPPtqLUjd6-CYwtLyQ5Ao(eCarXCarVfmiscManager3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$leajoFBPPtqLUjd6-CYwtLyQ5Ao, pairs2);
/*     */     
/* 134 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild4.useValuePAByIntBase(33680, pairs1); -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so2 = new -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so(this);
/*     */     
/* 136 */     iFilterCallback3.addTo(-$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so2);
/*     */ 
/*     */     
/* 139 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(604111360); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 140 */     IVehicleFunction iVehicleFunction2 = iVehicleFunction4.supportedFunctionValue(arrayOfInt1);
/* 141 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$Hybrid$bq8-ADAJlRMrNsJ2Ib4pzTbEzBM -$$Lambda$Hybrid$bq8-ADAJlRMrNsJ2Ib4pzTbEzBM = -$$Lambda$Hybrid$bq8-ADAJlRMrNsJ2Ib4pzTbEzBM.INSTANCE;
/* 142 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone2.useStatusPAByIntBase(33681, -$$Lambda$Hybrid$bq8-ADAJlRMrNsJ2Ib4pzTbEzBM); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$uqBh0HwAnWAg0-eeJDIsWnEoNm4 -$$Lambda$uqBh0HwAnWAg0-eeJDIsWnEoNm4 = new -$$Lambda$uqBh0HwAnWAg0-eeJDIsWnEoNm4(eCarXCarVfmiscManager2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$uqBh0HwAnWAg0-eeJDIsWnEoNm4, pairs2);
/*     */     
/* 150 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild2.useValuePAByIntBase(33681, pairs1); -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so1 = new -$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so(this);
/*     */     
/* 152 */     iFilterCallback1.addTo(-$$Lambda$Hybrid$wXUaVDHzs2Xk6VAUhziHP0hi_so1);
/*     */ 
/*     */     
/* 155 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.customFunction(604176640);
/* 156 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$Hybrid$jpVUrnbtAhYINsRp4WTypIrzi2o -$$Lambda$Hybrid$jpVUrnbtAhYINsRp4WTypIrzi2o = -$$Lambda$Hybrid$jpVUrnbtAhYINsRp4WTypIrzi2o.INSTANCE;
/* 157 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useStatusPAByIntBase(33682, -$$Lambda$Hybrid$jpVUrnbtAhYINsRp4WTypIrzi2o); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mECarXCarVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$nuVxSLyjUT7KV1Y2BECOi8EEr50 -$$Lambda$nuVxSLyjUT7KV1Y2BECOi8EEr50 = new -$$Lambda$nuVxSLyjUT7KV1Y2BECOi8EEr50(eCarXCarVfmiscManager1); -$$Lambda$Hybrid$aDz8ThQY7Lv4Ht8OSNuu8xpfGtw -$$Lambda$Hybrid$aDz8ThQY7Lv4Ht8OSNuu8xpfGtw = -$$Lambda$Hybrid$aDz8ThQY7Lv4Ht8OSNuu8xpfGtw.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     iValueTaskBuild1 = iValueTaskBuild1.onSetFunctionValue(-$$Lambda$nuVxSLyjUT7KV1Y2BECOi8EEr50, -$$Lambda$Hybrid$aDz8ThQY7Lv4Ht8OSNuu8xpfGtw); -$$Lambda$Hybrid$NtFay-2Tf1j0dkC_MUV9tEYBjY8 -$$Lambda$Hybrid$NtFay-2Tf1j0dkC_MUV9tEYBjY8 = -$$Lambda$Hybrid$NtFay-2Tf1j0dkC_MUV9tEYBjY8.INSTANCE;
/*     */     
/* 165 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild1.useValuePAByIntBase(33682, -$$Lambda$Hybrid$NtFay-2Tf1j0dkC_MUV9tEYBjY8); -$$Lambda$Hybrid$fNiXKUj-2Vz_eEDbi5DBO00gEzg -$$Lambda$Hybrid$fNiXKUj-2Vz_eEDbi5DBO00gEzg = new -$$Lambda$Hybrid$fNiXKUj-2Vz_eEDbi5DBO00gEzg(this);
/*     */     
/* 167 */     iFilterCallback2.addTo(-$$Lambda$Hybrid$fNiXKUj-2Vz_eEDbi5DBO00gEzg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FunctionStatus getPowerFlowStatus() {
/* 176 */     FunctionStatus functionStatus = FunctionStatus.notavailable;
/* 177 */     int i = getSignalValue(29546);
/*     */     
/* 179 */     if (i == 129) {
/*     */       
/* 181 */       functionStatus = getFunctionStatus(33669);
/*     */     }
/* 183 */     else if (i == 139) {
/*     */       
/* 185 */       functionStatus = getFunctionStatus(33705);
/*     */     } 
/*     */     
/* 188 */     return functionStatus;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Hybrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */