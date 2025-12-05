/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarWpcmodelManager;
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
/*     */ public class Wpc
/*     */   extends AbsCarFunction
/*     */   implements IWpc
/*     */ {
/*     */   private ECarXCarWpcmodelManager mWpcModelManager;
/*     */   
/*     */   protected Wpc(Context paramContext) {
/*  27 */     super(paramContext, 637534208);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  37 */     this.mWpcModelManager = paramECarXCarSetManager.getECarXCarWpcmodelManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  46 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(637731072);
/*  47 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(new int[] { 0, 1 });
/*  48 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/*  49 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone3.useStatusPAByIntBase(33635);
/*     */     
/*  51 */     Pairs pairs3 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  52 */     pairs3 = pairs3.add(Integer.valueOf(1), Integer.valueOf(1));
/*  53 */     pairs3 = pairs3.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild3.useValueSignal(30478, pairs3); -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI3 = new -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI(this);
/*  54 */     iFilterCallback3.addTo(-$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI3);
/*     */ 
/*     */     
/*  57 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(637600000);
/*  58 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(new int[] { 637600001, 0 });
/*  59 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/*  60 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone2.useStatusPAByIntBase(33634); ECarXCarWpcmodelManager eCarXCarWpcmodelManager = this.mWpcModelManager; Objects.requireNonNull(eCarXCarWpcmodelManager); -$$Lambda$YlUjKmvtoGN7FN40kIdMhm6r5_0 -$$Lambda$YlUjKmvtoGN7FN40kIdMhm6r5_0 = new -$$Lambda$YlUjKmvtoGN7FN40kIdMhm6r5_0(eCarXCarWpcmodelManager);
/*     */     
/*  62 */     Pairs pairs4 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0)); pairs4 = pairs4.add(Integer.valueOf(637600001), Integer.valueOf(1));
/*     */     
/*     */     iValueTaskBuild2 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$YlUjKmvtoGN7FN40kIdMhm6r5_0, pairs4);
/*  65 */     Pairs pairs2 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0)); pairs2 = pairs2.add(Integer.valueOf(1), Integer.valueOf(637600001)); IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild2.useValuePAByIntBase(33634, pairs2);
/*     */     -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI2 = new -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI(this);
/*  67 */     iFilterCallback2.addTo(-$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI2);
/*     */ 
/*     */     
/*  70 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(637665536);
/*  71 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 0, 255, 637665537, 637665538, 637665539, 637665540, 637665541, 637665542, 637665543, 637665544, 637665545, 637665552 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/*  85 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useStatusPAByIntBase(33635);
/*     */     
/*  87 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(637665542));
/*     */     
/*  89 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(637665538));
/*  90 */     pairs1 = pairs1.add(Integer.valueOf(2), Integer.valueOf(637665539));
/*  91 */     pairs1 = pairs1.add(Integer.valueOf(3), Integer.valueOf(637665544));
/*  92 */     pairs1 = pairs1.add(Integer.valueOf(4), Integer.valueOf(637665552));
/*  93 */     pairs1 = pairs1.add(Integer.valueOf(5), Integer.valueOf(637665543));
/*  94 */     pairs1 = pairs1.add(Integer.valueOf(6), Integer.valueOf(637665541));
/*  95 */     pairs1 = pairs1.add(Integer.valueOf(7), Integer.valueOf(0));
/*  96 */     pairs1 = pairs1.add(Integer.valueOf(8), Integer.valueOf(637665540));
/*     */     
/*  98 */     pairs1 = pairs1.add(Integer.valueOf(9), Integer.valueOf(0));
/*  99 */     pairs1 = pairs1.orDefault(Integer.valueOf(255)); IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33635, pairs1); -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI1 = new -$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI(this);
/* 100 */     iFilterCallback1.addTo(-$$Lambda$Wpc$2g_otL8F06hYhVSeupFH3AFYYzI1);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Wpc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */