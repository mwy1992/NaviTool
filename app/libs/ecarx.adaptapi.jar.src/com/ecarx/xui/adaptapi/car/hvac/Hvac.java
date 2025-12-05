/*      */ package com.ecarx.xui.adaptapi.car.hvac;
/*      */ 
/*      */ import android.car.CarNotConnectedException;
/*      */ import android.content.Context;
/*      */ import android.os.SystemProperties;
/*      */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*      */ import com.ecarx.xui.adaptapi.SignalUtils;
/*      */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*      */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*      */ import com.ecarx.xui.adaptapi.car.Pairs;
/*      */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarAirqlyandfragraManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarClimateManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSeatclimateManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSeatctrlManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSteerwhlheatgManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSystemsettingManager;
/*      */ import ecarx.car.hardware.vehicle.PATypes;
/*      */ import java.util.Objects;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Hvac
/*      */   extends AbsCarFunction
/*      */   implements IHvac
/*      */ {
/*   53 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 }; private ECarXCarAirqlyandfragraManager mAirqlandFragraMgr; private ECarXCarClimateManager mClimateMgr; private ECarXCarSeatctrlManager mECarXCarSeatclimateManager; private ECarXCarSeatclimateManager mSeatClimateMgr; private ECarXCarSteerwhlheatgManager mSteerWhlHeatMgr;
/*      */   private ECarXCarSystemsettingManager mSystemSettingMgr;
/*      */   
/*      */   public Hvac(Context paramContext) {
/*   57 */     super(paramContext, 268435456);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*   64 */     this.mClimateMgr = this.mECarXCarSetManager.getECarXCarClimateManager();
/*      */     
/*   66 */     this.mSeatClimateMgr = this.mECarXCarSetManager.getECarXCarSeatclimateManager();
/*      */     
/*   68 */     this.mSteerWhlHeatMgr = this.mECarXCarSetManager.getECarXCarSteerwhlheatgManager();
/*      */     
/*   70 */     this.mSystemSettingMgr = this.mECarXCarSetManager.getECarXCarSystemsettingManager();
/*      */     
/*   72 */     this.mAirqlandFragraMgr = this.mECarXCarSetManager.getECarXCarAirqlyandfragraManager();
/*      */     
/*   74 */     this.mECarXCarSeatclimateManager = this.mECarXCarSetManager.getECarXCarSeatctrlManager();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void buildFunctions() {
/*   81 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*   82 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*   83 */     Pairs pairs2 = pairs1.reverse();
/*   84 */     IVehicleFunction iVehicleFunction62 = VehicleFunction.intFunction(268501248); int[] arrayOfInt8 = COMMON_ON_OFF;
/*   85 */     IVehicleFunction iVehicleFunction47 = iVehicleFunction62.supportedFunctionValue(arrayOfInt8);
/*   86 */     IVehicleFunction.IZone iZone52 = iVehicleFunction47.createZone(new int[] { Integer.MIN_VALUE });
/*   87 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild56 = iZone52.useStatusPAByIntBase(33338); ECarXCarClimateManager eCarXCarClimateManager32 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager32); -$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms -$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms2 = new -$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms(eCarXCarClimateManager32);
/*   88 */     iValueTaskBuild56 = iValueTaskBuild56.onSetFunctionValue(-$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms2, pairs1);
/*   89 */     IVehicleFunction.IFilterCallback iFilterCallback38 = iValueTaskBuild56.useValuePAByIntBase(33338, pairs2);
/*      */     
/*   91 */     IVehicleFunction.IZone iZone51 = iFilterCallback38.createZone(new int[] { 128 });
/*   92 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild55 = iZone51.useStatusPAByIntBase(33347); ECarXCarClimateManager eCarXCarClimateManager31 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager31); -$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys0 -$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys02 = new -$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys0(eCarXCarClimateManager31);
/*   93 */     iValueTaskBuild55 = iValueTaskBuild55.onSetFunctionValue(-$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys02, pairs1);
/*   94 */     IVehicleFunction.IFilterCallback iFilterCallback37 = iValueTaskBuild55.useValuePAByIntBase(33347, pairs2);
/*      */     
/*   96 */     IVehicleFunction.IZone iZone50 = iFilterCallback37.createZone(new int[] { 2048 });
/*   97 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild54 = iZone50.useStatusPAByIntBase(33339); ECarXCarClimateManager eCarXCarClimateManager30 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager30); -$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o -$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o2 = new -$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o(eCarXCarClimateManager30);
/*   98 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild95 = iValueTaskBuild54.onSetFunctionValue(-$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o2, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M4 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*   99 */     IVehicleFunction.IFilterCallback iFilterCallback72 = iValueTaskBuild95.useValuePAByIntBase(33339, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M4); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI24 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  101 */     iFilterCallback72.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI24);
/*      */ 
/*      */ 
/*      */     
/*  105 */     IVehicleFunction iVehicleFunction46 = VehicleFunction.intFunction(268501504); int[] arrayOfInt26 = COMMON_ON_OFF;
/*  106 */     iVehicleFunction46 = iVehicleFunction46.supportedFunctionValue(arrayOfInt26);
/*  107 */     IVehicleFunction.IZone iZone49 = iVehicleFunction46.createZone(new int[] { Integer.MIN_VALUE });
/*  108 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild53 = iZone49.useStatusPAByIntBase(33318); ECarXCarClimateManager eCarXCarClimateManager29 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager29); -$$Lambda$WoNiRAYYYhmqA5WfKmsBWTDasm8 -$$Lambda$WoNiRAYYYhmqA5WfKmsBWTDasm8 = new -$$Lambda$WoNiRAYYYhmqA5WfKmsBWTDasm8(eCarXCarClimateManager29);
/*      */     
/*  110 */     Pairs pairs18 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0)); pairs18 = pairs18.add(Integer.valueOf(1), Integer.valueOf(1));
/*      */     
/*      */     iValueTaskBuild53 = iValueTaskBuild53.onSetFunctionValue(-$$Lambda$WoNiRAYYYhmqA5WfKmsBWTDasm8, pairs18);
/*  113 */     Pairs pairs13 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0)); pairs13 = pairs13.add(Integer.valueOf(1), Integer.valueOf(1));
/*      */     IVehicleFunction.IFilterCallback iFilterCallback36 = iValueTaskBuild53.useValuePAByIntBase(33318, pairs13);
/*  115 */     IVehicleFunction.IZone iZone48 = iFilterCallback36.createZone(new int[] { 128 });
/*  116 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild52 = iZone48.useStatusPAByIntBase(33361); ECarXCarClimateManager eCarXCarClimateManager28 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager28); -$$Lambda$7SC_qaA5P54gB_cgod_Awv9-55M -$$Lambda$7SC_qaA5P54gB_cgod_Awv9-55M = new -$$Lambda$7SC_qaA5P54gB_cgod_Awv9-55M(eCarXCarClimateManager28);
/*  117 */     iValueTaskBuild52 = iValueTaskBuild52.onSetFunctionValue(-$$Lambda$7SC_qaA5P54gB_cgod_Awv9-55M, pairs1);
/*      */     
/*  119 */     IVehicleFunction.IFilterCallback iFilterCallback35 = iValueTaskBuild52.useValuePAByIntBase(33361, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI49 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  121 */     iFilterCallback35.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI49);
/*      */ 
/*      */     
/*  124 */     IVehicleFunction iVehicleFunction45 = VehicleFunction.intFunction(268501760); int[] arrayOfInt25 = COMMON_ON_OFF;
/*  125 */     iVehicleFunction45 = iVehicleFunction45.supportedFunctionValue(arrayOfInt25);
/*  126 */     IVehicleFunction.IZone iZone47 = iVehicleFunction45.createZone(new int[] { Integer.MIN_VALUE });
/*  127 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild51 = iZone47.useStatusPAByIntBase(33317); ECarXCarClimateManager eCarXCarClimateManager27 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager27); -$$Lambda$UevGv1l__NtYy7pMMzgfgTkRVdE -$$Lambda$UevGv1l__NtYy7pMMzgfgTkRVdE = new -$$Lambda$UevGv1l__NtYy7pMMzgfgTkRVdE(eCarXCarClimateManager27);
/*  128 */     iValueTaskBuild51 = iValueTaskBuild51.onSetFunctionValue(-$$Lambda$UevGv1l__NtYy7pMMzgfgTkRVdE, pairs1);
/*      */     
/*  130 */     IVehicleFunction.IFilterCallback iFilterCallback34 = iValueTaskBuild51.useValuePAByIntBase(33317, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI48 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  132 */     iFilterCallback34.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI48);
/*      */     
/*  134 */     IVehicleFunction iVehicleFunction44 = VehicleFunction.intFunction(268502016); int[] arrayOfInt24 = COMMON_ON_OFF;
/*  135 */     iVehicleFunction44 = iVehicleFunction44.supportedFunctionValue(arrayOfInt24);
/*  136 */     IVehicleFunction.IZone iZone46 = iVehicleFunction44.createZone(new int[] { Integer.MIN_VALUE });
/*  137 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild50 = iZone46.useStatusPAByIntBase(33323); ECarXCarClimateManager eCarXCarClimateManager26 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager26); -$$Lambda$YHDBjnGLbkhjdUBExAOveDKa834 -$$Lambda$YHDBjnGLbkhjdUBExAOveDKa834 = new -$$Lambda$YHDBjnGLbkhjdUBExAOveDKa834(eCarXCarClimateManager26);
/*  138 */     iValueTaskBuild50 = iValueTaskBuild50.onSetFunctionValue(-$$Lambda$YHDBjnGLbkhjdUBExAOveDKa834, pairs1);
/*      */     
/*  140 */     IVehicleFunction.IFilterCallback iFilterCallback71 = iValueTaskBuild50.useValuePAByIntBase(33323, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI23 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  142 */     iFilterCallback71.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI23);
/*      */ 
/*      */     
/*  145 */     IVehicleFunction iVehicleFunction43 = VehicleFunction.intFunction(268502272);
/*  146 */     iVehicleFunction43 = iVehicleFunction43.supportedFunctionValue(new int[] { 268502273, 268502274, 268502275, 268502276 });
/*      */     
/*  148 */     IVehicleFunction.IZone iZone76 = iVehicleFunction43.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus6 = FunctionStatus.active;
/*  149 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild94 = iZone76.fixStatus(functionStatus6); -$$Lambda$Hvac$6RkeSmALLU03Sg1OYId1TeGaClU -$$Lambda$Hvac$6RkeSmALLU03Sg1OYId1TeGaClU = new -$$Lambda$Hvac$6RkeSmALLU03Sg1OYId1TeGaClU(this);
/*  150 */     IVehicleFunction.IFilterCallback iFilterCallback33 = iValueTaskBuild94.useValueSignal(29405, -$$Lambda$Hvac$6RkeSmALLU03Sg1OYId1TeGaClU); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI47 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  151 */     iFilterCallback33.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI47);
/*      */ 
/*      */ 
/*      */     
/*  155 */     Pairs pairs9 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  156 */     pairs9 = pairs9.add(Integer.valueOf(268566785), Integer.valueOf(1));
/*  157 */     pairs9 = pairs9.add(Integer.valueOf(268566786), Integer.valueOf(2));
/*  158 */     pairs9 = pairs9.add(Integer.valueOf(268566787), Integer.valueOf(3));
/*  159 */     pairs9 = pairs9.add(Integer.valueOf(268566788), Integer.valueOf(4));
/*  160 */     pairs9 = pairs9.add(Integer.valueOf(268566789), Integer.valueOf(5));
/*  161 */     pairs9 = pairs9.add(Integer.valueOf(268566790), Integer.valueOf(6));
/*  162 */     pairs9 = pairs9.add(Integer.valueOf(268566791), Integer.valueOf(7));
/*  163 */     pairs9 = pairs9.add(Integer.valueOf(268566792), Integer.valueOf(8));
/*  164 */     pairs9 = pairs9.add(Integer.valueOf(268566793), Integer.valueOf(9));
/*  165 */     IVehicleFunction iVehicleFunction61 = VehicleFunction.intFunction(268566784);
/*  166 */     iVehicleFunction61 = iVehicleFunction61.supportedFunctionValue(new int[] { 0, 268566785, 268566786, 268566787, 268566788, 268566789, 268566790, 268566791, 268566792, 268566793 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  176 */     IVehicleFunction.IZone iZone75 = iVehicleFunction61.createZone(new int[] { 8 });
/*  177 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild93 = iZone75.useStatusPAByIntBase(33324); ECarXCarClimateManager eCarXCarClimateManager40 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager40); -$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd0 -$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd02 = new -$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd0(eCarXCarClimateManager40);
/*  178 */     iValueTaskBuild93 = iValueTaskBuild93.onSetFunctionValue(-$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd02, pairs9); -$$Lambda$Hvac$b_E5PhYD8IIIqWqbt-HL7qKavgQ -$$Lambda$Hvac$b_E5PhYD8IIIqWqbt-HL7qKavgQ = new -$$Lambda$Hvac$b_E5PhYD8IIIqWqbt-HL7qKavgQ(this);
/*  179 */     IVehicleFunction.IFilterCallback iFilterCallback70 = iValueTaskBuild93.useValuePA(33324, -$$Lambda$Hvac$b_E5PhYD8IIIqWqbt-HL7qKavgQ); -$$Lambda$Hvac$fzxOljBTie7urPDpU10djS76avw -$$Lambda$Hvac$fzxOljBTie7urPDpU10djS76avw = -$$Lambda$Hvac$fzxOljBTie7urPDpU10djS76avw.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  187 */     IVehicleFunction.ITaskEnd iTaskEnd11 = iFilterCallback70.filterValue(-$$Lambda$Hvac$fzxOljBTie7urPDpU10djS76avw);
/*  188 */     IVehicleFunction.IZone iZone74 = iTaskEnd11.createZone(new int[] { 128 }); -$$Lambda$Hvac$9IuQyBQjPZfXklieOd7IDK-qhow -$$Lambda$Hvac$9IuQyBQjPZfXklieOd7IDK-qhow = new -$$Lambda$Hvac$9IuQyBQjPZfXklieOd7IDK-qhow(this);
/*  189 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild3 = iZone74.supportedFunctionValue(-$$Lambda$Hvac$9IuQyBQjPZfXklieOd7IDK-qhow, new int[] { 29329 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  206 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild92 = iStatusTaskBuild3.useStatusPAByIntBase(33342); ECarXCarClimateManager eCarXCarClimateManager39 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager39); -$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc -$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc2 = new -$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc(eCarXCarClimateManager39);
/*  207 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild49 = iValueTaskBuild92.onSetFunctionValue(-$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc2, pairs9); -$$Lambda$Hvac$TK2qxZw4jM7qjZtZeEbj7t_nouY -$$Lambda$Hvac$TK2qxZw4jM7qjZtZeEbj7t_nouY = new -$$Lambda$Hvac$TK2qxZw4jM7qjZtZeEbj7t_nouY(this);
/*  208 */     IVehicleFunction.IFilterCallback iFilterCallback69 = iValueTaskBuild49.useValuePA(33342, -$$Lambda$Hvac$TK2qxZw4jM7qjZtZeEbj7t_nouY); -$$Lambda$Hvac$7irPtQVcE1YRB9JNiJSIgmj1YwA -$$Lambda$Hvac$7irPtQVcE1YRB9JNiJSIgmj1YwA = -$$Lambda$Hvac$7irPtQVcE1YRB9JNiJSIgmj1YwA.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  216 */     IVehicleFunction.ITaskEnd iTaskEnd4 = iFilterCallback69.filterValue(-$$Lambda$Hvac$7irPtQVcE1YRB9JNiJSIgmj1YwA); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI46 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  217 */     iTaskEnd4.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI46);
/*      */ 
/*      */     
/*  220 */     IVehicleFunction iVehicleFunction42 = VehicleFunction.intFunction(268567296);
/*  221 */     iVehicleFunction42 = iVehicleFunction42.supportedFunctionValue(new int[] { 0, 268566785, 268566786, 268566787, 268566788, 268566789, 268566790, 268566791, 268566792, 268566793 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  231 */     IVehicleFunction.IZone iZone45 = iVehicleFunction42.createZone(new int[] { 8 });
/*  232 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild91 = iZone45.useStatusPAByIntBase(33368); -$$Lambda$Hvac$A15Z51wnUXP8bPXJdregAAWLtSA -$$Lambda$Hvac$A15Z51wnUXP8bPXJdregAAWLtSA = new -$$Lambda$Hvac$A15Z51wnUXP8bPXJdregAAWLtSA(this);
/*      */     
/*  234 */     IVehicleFunction.IFilterCallback iFilterCallback32 = iValueTaskBuild91.useValuePA(33368, -$$Lambda$Hvac$A15Z51wnUXP8bPXJdregAAWLtSA); -$$Lambda$Hvac$Cc1h72NIIYGs8GO2BGudhsqbpZ0 -$$Lambda$Hvac$Cc1h72NIIYGs8GO2BGudhsqbpZ0 = -$$Lambda$Hvac$Cc1h72NIIYGs8GO2BGudhsqbpZ0.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  242 */     IVehicleFunction.ITaskEnd iTaskEnd3 = iFilterCallback32.filterValue(-$$Lambda$Hvac$Cc1h72NIIYGs8GO2BGudhsqbpZ0); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI45 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  243 */     iTaskEnd3.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI45);
/*      */ 
/*      */ 
/*      */     
/*  247 */     Pairs pairs8 = Pairs.of(Integer.valueOf(268567044), Integer.valueOf(10));
/*  248 */     pairs8 = pairs8.add(Integer.valueOf(0), Integer.valueOf(0));
/*  249 */     pairs8 = pairs8.add(Integer.valueOf(268567041), Integer.valueOf(11));
/*  250 */     pairs8 = pairs8.add(Integer.valueOf(268567042), Integer.valueOf(12));
/*  251 */     pairs8 = pairs8.add(Integer.valueOf(268567043), Integer.valueOf(13));
/*  252 */     pairs8 = pairs8.add(Integer.valueOf(268567045), Integer.valueOf(14));
/*  253 */     IVehicleFunction iVehicleFunction60 = VehicleFunction.intFunction(268567040);
/*  254 */     iVehicleFunction60 = iVehicleFunction60.supportedFunctionValue(new int[] { 268567041, 268567042, 268567043, 268567044, 268567045 });
/*      */ 
/*      */     
/*  257 */     IVehicleFunction.IZone iZone73 = iVehicleFunction60.createZone(new int[] { 8 });
/*  258 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild90 = iZone73.useStatusPAByIntBase(33324); ECarXCarClimateManager eCarXCarClimateManager38 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager38); -$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd0 -$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd01 = new -$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd0(eCarXCarClimateManager38);
/*  259 */     iValueTaskBuild90 = iValueTaskBuild90.onSetFunctionValue(-$$Lambda$H-nVRHhzp9MDgqoVdZBVI36bqd01, pairs8); -$$Lambda$Hvac$Hii6w8JsyrW5fYOS3jy2IO6D-No -$$Lambda$Hvac$Hii6w8JsyrW5fYOS3jy2IO6D-No = new -$$Lambda$Hvac$Hii6w8JsyrW5fYOS3jy2IO6D-No(this);
/*  260 */     IVehicleFunction.IFilterCallback iFilterCallback73 = iValueTaskBuild90.useValuePA(33324, -$$Lambda$Hvac$Hii6w8JsyrW5fYOS3jy2IO6D-No); -$$Lambda$Hvac$jMb1vBBg6Bsp46DNFlYqCD-xe4c -$$Lambda$Hvac$jMb1vBBg6Bsp46DNFlYqCD-xe4c = -$$Lambda$Hvac$jMb1vBBg6Bsp46DNFlYqCD-xe4c.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  268 */     IVehicleFunction.ITaskEnd iTaskEnd10 = iFilterCallback73.filterValue(-$$Lambda$Hvac$jMb1vBBg6Bsp46DNFlYqCD-xe4c);
/*  269 */     IVehicleFunction.IZone iZone72 = iTaskEnd10.createZone(new int[] { 128 });
/*  270 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild89 = iZone72.useStatusPAByIntBase(33342); ECarXCarClimateManager eCarXCarClimateManager37 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager37); -$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc -$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc1 = new -$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc(eCarXCarClimateManager37);
/*  271 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild48 = iValueTaskBuild89.onSetFunctionValue(-$$Lambda$0JGgcbqRYGA2duqG_E49LIsz7Tc1, pairs8); -$$Lambda$Hvac$xegEJ7zjTuXfcDuu7POJNU3XxNU -$$Lambda$Hvac$xegEJ7zjTuXfcDuu7POJNU3XxNU = new -$$Lambda$Hvac$xegEJ7zjTuXfcDuu7POJNU3XxNU(this);
/*  272 */     IVehicleFunction.IFilterCallback iFilterCallback68 = iValueTaskBuild48.useValuePA(33342, -$$Lambda$Hvac$xegEJ7zjTuXfcDuu7POJNU3XxNU); -$$Lambda$Hvac$vEKetnakf1yPHi354A4X_9dP0AE -$$Lambda$Hvac$vEKetnakf1yPHi354A4X_9dP0AE = -$$Lambda$Hvac$vEKetnakf1yPHi354A4X_9dP0AE.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  280 */     IVehicleFunction.ITaskEnd iTaskEnd9 = iFilterCallback68.filterValue(-$$Lambda$Hvac$vEKetnakf1yPHi354A4X_9dP0AE); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI22 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  281 */     iTaskEnd9.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI22);
/*      */ 
/*      */     
/*  284 */     IVehicleFunction iVehicleFunction41 = VehicleFunction.intFunction(268567552);
/*  285 */     iVehicleFunction41 = iVehicleFunction41.supportedFunctionValue(new int[] { 0, 268567041, 268567042, 268567043, 268567044, 268567045 });
/*      */ 
/*      */     
/*  288 */     IVehicleFunction.IZone iZone44 = iVehicleFunction41.createZone(new int[] { 8 });
/*  289 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild47 = iZone44.useStatusPAByIntBase(33368); -$$Lambda$Hvac$RPUrsCNCBP_3P5rjBkiBHFoZUrE -$$Lambda$Hvac$RPUrsCNCBP_3P5rjBkiBHFoZUrE = new -$$Lambda$Hvac$RPUrsCNCBP_3P5rjBkiBHFoZUrE(this);
/*  290 */     IVehicleFunction.IFilterCallback iFilterCallback31 = iValueTaskBuild47.useValuePA(33368, -$$Lambda$Hvac$RPUrsCNCBP_3P5rjBkiBHFoZUrE); -$$Lambda$Hvac$LEpqGd5qCa7CYGB0hZLIkwhhEUk -$$Lambda$Hvac$LEpqGd5qCa7CYGB0hZLIkwhhEUk = -$$Lambda$Hvac$LEpqGd5qCa7CYGB0hZLIkwhhEUk.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  298 */     IVehicleFunction.ITaskEnd iTaskEnd8 = iFilterCallback31.filterValue(-$$Lambda$Hvac$LEpqGd5qCa7CYGB0hZLIkwhhEUk); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI21 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  299 */     iTaskEnd8.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI21);
/*      */ 
/*      */     
/*  302 */     IVehicleFunction iVehicleFunction40 = VehicleFunction.intFunction(268632320);
/*  303 */     iVehicleFunction40 = iVehicleFunction40.supportedFunctionValue(new int[] { 0, 268632321 });
/*  304 */     IVehicleFunction.IZone iZone43 = iVehicleFunction40.createZone(new int[] { Integer.MIN_VALUE });
/*  305 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild46 = iZone43.useStatusPAByIntBase(33319); ECarXCarClimateManager eCarXCarClimateManager25 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager25); -$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ -$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ1 = new -$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ(eCarXCarClimateManager25);
/*      */     
/*  307 */     Pairs pairs17 = Pairs.of(Integer.valueOf(268632321), Integer.valueOf(1));
/*  308 */     pairs17 = pairs17.add(Integer.valueOf(0), Integer.valueOf(0));
/*      */     iValueTaskBuild46 = iValueTaskBuild46.onSetFunctionValue(-$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ1, pairs17);
/*  310 */     Pairs pairs12 = Pairs.of(Integer.valueOf(1), Integer.valueOf(268632321));
/*  311 */     pairs12 = pairs12.add(Integer.valueOf(0), Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback67 = iValueTaskBuild46.useValuePAByIntBase(33319, pairs12); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI20 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  312 */     iFilterCallback67.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI20);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  319 */     IVehicleFunction iVehicleFunction39 = VehicleFunction.intFunction(268632832);
/*  320 */     iVehicleFunction39 = iVehicleFunction39.supportedFunctionValue(new int[] { 2 });
/*  321 */     IVehicleFunction.IZone iZone42 = iVehicleFunction39.createZone(new int[] { Integer.MIN_VALUE });
/*  322 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild45 = iZone42.useOtherFunctionStatus(268632320); ECarXCarClimateManager eCarXCarClimateManager24 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager24); -$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ -$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ2 = new -$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ(eCarXCarClimateManager24); -$$Lambda$Hvac$rU46aJ4uFE8EGuXQrRZ04ve1JS4 -$$Lambda$Hvac$rU46aJ4uFE8EGuXQrRZ04ve1JS4 = -$$Lambda$Hvac$rU46aJ4uFE8EGuXQrRZ04ve1JS4.INSTANCE; -$$Lambda$Hvac$H-A0qPSFO6HNiF5UI06B1Z_fXwQ -$$Lambda$Hvac$H-A0qPSFO6HNiF5UI06B1Z_fXwQ = new -$$Lambda$Hvac$H-A0qPSFO6HNiF5UI06B1Z_fXwQ(this);
/*  323 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild88 = iValueTaskBuild45.onSetFunctionValue(-$$Lambda$9GYpOrq8S3dgy_X7BsJc60jLlvQ2, -$$Lambda$Hvac$rU46aJ4uFE8EGuXQrRZ04ve1JS4, -$$Lambda$Hvac$H-A0qPSFO6HNiF5UI06B1Z_fXwQ); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI19 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  324 */     iValueTaskBuild88.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI19);
/*      */ 
/*      */     
/*  327 */     IVehicleFunction iVehicleFunction38 = VehicleFunction.intFunction(268697856); int[] arrayOfInt23 = COMMON_ON_OFF;
/*  328 */     iVehicleFunction38 = iVehicleFunction38.supportedFunctionValue(arrayOfInt23);
/*  329 */     IVehicleFunction.IZone iZone41 = iVehicleFunction38.createZone(new int[] { Integer.MIN_VALUE });
/*  330 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus1 = iZone41.useStatusSignals(new int[] { 33332, 33345 }); -$$Lambda$Hvac$eBZxc8IV8tayXOXY2M2SoNLq7sM -$$Lambda$Hvac$eBZxc8IV8tayXOXY2M2SoNLq7sM = new -$$Lambda$Hvac$eBZxc8IV8tayXOXY2M2SoNLq7sM(this);
/*      */     
/*  332 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild44 = iMultiSignalStatus1.onStatusSignalChanged(-$$Lambda$Hvac$eBZxc8IV8tayXOXY2M2SoNLq7sM); ECarXCarClimateManager eCarXCarClimateManager23 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager23); -$$Lambda$e0oqERHrxyVLoXqABagiqeMB3Cw -$$Lambda$e0oqERHrxyVLoXqABagiqeMB3Cw = new -$$Lambda$e0oqERHrxyVLoXqABagiqeMB3Cw(eCarXCarClimateManager23);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  346 */     iValueTaskBuild44 = iValueTaskBuild44.onSetFunctionValue(-$$Lambda$e0oqERHrxyVLoXqABagiqeMB3Cw, pairs1);
/*      */     
/*  348 */     IVehicleFunction.IFilterCallback iFilterCallback30 = iValueTaskBuild44.useValuePAByIntBase(33332, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI44 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  350 */     iFilterCallback30.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI44);
/*      */ 
/*      */     
/*  353 */     IVehicleFunction iVehicleFunction37 = VehicleFunction.intFunction(268698112); int[] arrayOfInt22 = COMMON_ON_OFF;
/*  354 */     iVehicleFunction37 = iVehicleFunction37.supportedFunctionValue(arrayOfInt22);
/*  355 */     IVehicleFunction.IZone iZone40 = iVehicleFunction37.createZone(new int[] { Integer.MIN_VALUE });
/*  356 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild43 = iZone40.useStatusPAByIntBase(33329); ECarXCarClimateManager eCarXCarClimateManager22 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager22); -$$Lambda$fDuREcQBRhSlcq_KngtluZcPo8Q -$$Lambda$fDuREcQBRhSlcq_KngtluZcPo8Q = new -$$Lambda$fDuREcQBRhSlcq_KngtluZcPo8Q(eCarXCarClimateManager22);
/*  357 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild87 = iValueTaskBuild43.onSetFunctionValue(-$$Lambda$fDuREcQBRhSlcq_KngtluZcPo8Q, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M3 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/*  359 */     IVehicleFunction.IFilterCallback iFilterCallback29 = iValueTaskBuild87.useValuePAByIntBase(33329, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M3); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI43 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  361 */     iFilterCallback29.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI43);
/*      */ 
/*      */     
/*  364 */     IVehicleFunction iVehicleFunction36 = VehicleFunction.intFunction(268698368); int[] arrayOfInt21 = COMMON_ON_OFF;
/*  365 */     iVehicleFunction36 = iVehicleFunction36.supportedFunctionValue(arrayOfInt21);
/*  366 */     IVehicleFunction.IZone iZone39 = iVehicleFunction36.createZone(new int[] { Integer.MIN_VALUE });
/*  367 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus3 = iZone39.useStatusSignals(new int[] { 33333, 33346 }); -$$Lambda$Hvac$q5hSZj9lRQQXxvDO8PYsIWgdmTE -$$Lambda$Hvac$q5hSZj9lRQQXxvDO8PYsIWgdmTE = new -$$Lambda$Hvac$q5hSZj9lRQQXxvDO8PYsIWgdmTE(this);
/*      */     
/*  369 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild42 = iMultiSignalStatus3.onStatusSignalChanged(-$$Lambda$Hvac$q5hSZj9lRQQXxvDO8PYsIWgdmTE); ECarXCarClimateManager eCarXCarClimateManager21 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager21); -$$Lambda$A_UtIOIUGbIXzghj131QFElxiWs -$$Lambda$A_UtIOIUGbIXzghj131QFElxiWs = new -$$Lambda$A_UtIOIUGbIXzghj131QFElxiWs(eCarXCarClimateManager21);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  382 */     iValueTaskBuild42 = iValueTaskBuild42.onSetFunctionValue(-$$Lambda$A_UtIOIUGbIXzghj131QFElxiWs, pairs1);
/*      */     
/*  384 */     IVehicleFunction.IFilterCallback iFilterCallback66 = iValueTaskBuild42.useValuePAByIntBase(33333, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI18 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  386 */     iFilterCallback66.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI18);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  392 */     IVehicleFunction iVehicleFunction59 = VehicleFunction.intFunction(268698880); int[] arrayOfInt7 = COMMON_ON_OFF;
/*  393 */     IVehicleFunction iVehicleFunction35 = iVehicleFunction59.supportedFunctionValue(arrayOfInt7);
/*  394 */     IVehicleFunction.IZone iZone38 = iVehicleFunction35.createZone(new int[] { Integer.MIN_VALUE });
/*  395 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild41 = iZone38.useStatusPAByIntBase(33343); ECarXCarClimateManager eCarXCarClimateManager20 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager20); -$$Lambda$AYjM1uqkMzxN1urpzuG0PYOmHaE -$$Lambda$AYjM1uqkMzxN1urpzuG0PYOmHaE = new -$$Lambda$AYjM1uqkMzxN1urpzuG0PYOmHaE(eCarXCarClimateManager20);
/*  396 */     iValueTaskBuild41 = iValueTaskBuild41.onSetFunctionValue(-$$Lambda$AYjM1uqkMzxN1urpzuG0PYOmHaE, pairs1);
/*      */     
/*  398 */     IVehicleFunction.IFilterCallback iFilterCallback28 = iValueTaskBuild41.useValuePAByIntBase(33343, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI42 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  400 */     iFilterCallback28.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI42);
/*      */ 
/*      */     
/*  403 */     IVehicleFunction iVehicleFunction58 = VehicleFunction.intFunction(268699136); int[] arrayOfInt6 = COMMON_ON_OFF;
/*  404 */     IVehicleFunction iVehicleFunction34 = iVehicleFunction58.supportedFunctionValue(arrayOfInt6);
/*  405 */     IVehicleFunction.IZone iZone37 = iVehicleFunction34.createZone(new int[] { Integer.MIN_VALUE });
/*  406 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild40 = iZone37.useStatusPAByIntBase(33344); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M10 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  407 */     IVehicleFunction.IFilterCallback iFilterCallback65 = iValueTaskBuild40.useValuePAByIntBase(33344, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M10); -$$Lambda$Hvac$vjIEOiSkJLV_K3o8ywH6j6qOhtg -$$Lambda$Hvac$vjIEOiSkJLV_K3o8ywH6j6qOhtg = -$$Lambda$Hvac$vjIEOiSkJLV_K3o8ywH6j6qOhtg.INSTANCE;
/*      */     
/*  409 */     IVehicleFunction.ITaskEnd iTaskEnd7 = iFilterCallback65.filterValue(-$$Lambda$Hvac$vjIEOiSkJLV_K3o8ywH6j6qOhtg); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI17 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  410 */     iTaskEnd7.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI17);
/*      */ 
/*      */     
/*  413 */     IVehicleFunction iVehicleFunction33 = VehicleFunction.intFunction(268699392);
/*  414 */     iVehicleFunction33 = iVehicleFunction33.supportedFunctionValue(new int[] { 0, 1, 2 });
/*  415 */     IVehicleFunction.IZone iZone71 = iVehicleFunction33.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus5 = FunctionStatus.active;
/*  416 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild39 = iZone71.fixStatus(functionStatus5); ECarXCarClimateManager eCarXCarClimateManager19 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager19); -$$Lambda$csWCO8A4ECT_z0nPo7Yu9Sdwqdw -$$Lambda$csWCO8A4ECT_z0nPo7Yu9Sdwqdw = new -$$Lambda$csWCO8A4ECT_z0nPo7Yu9Sdwqdw(eCarXCarClimateManager19);
/*      */     
/*  418 */     Pairs pairs16 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  419 */     pairs16 = pairs16.add(Integer.valueOf(1), Integer.valueOf(1));
/*  420 */     pairs16 = pairs16.add(Integer.valueOf(2), Integer.valueOf(1)); IVehicleFunction.IValueTaskBuild iValueTaskBuild86 = iValueTaskBuild39.onSetFunctionValue(-$$Lambda$csWCO8A4ECT_z0nPo7Yu9Sdwqdw, pairs16); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI16 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  421 */     iValueTaskBuild86.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI16);
/*      */ 
/*      */ 
/*      */     
/*  425 */     Pairs pairs7 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  426 */     pairs7 = pairs7.add(Integer.valueOf(268763393), Integer.valueOf(1));
/*  427 */     pairs7 = pairs7.add(Integer.valueOf(268763394), Integer.valueOf(2));
/*  428 */     pairs7 = pairs7.add(Integer.valueOf(268763395), Integer.valueOf(3));
/*      */     
/*  430 */     IVehicleFunction iVehicleFunction57 = VehicleFunction.intFunction(268763392);
/*  431 */     iVehicleFunction57 = iVehicleFunction57.supportedFunctionValue(new int[] { 0, 268763393, 268763394, 268763395 });
/*      */     
/*  433 */     IVehicleFunction.IZone iZone70 = iVehicleFunction57.createZone(new int[] { 1 }); -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ6 = new -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ(this);
/*  434 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild85 = iZone70.useStatusPAByIntBase(33390, -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ6); ECarXCarSeatclimateManager eCarXCarSeatclimateManager12 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager12); -$$Lambda$v_tScRfI12FOgJIG2xdCVs_9nhE -$$Lambda$v_tScRfI12FOgJIG2xdCVs_9nhE = new -$$Lambda$v_tScRfI12FOgJIG2xdCVs_9nhE(eCarXCarSeatclimateManager12);
/*      */     
/*  436 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild100 = iValueTaskBuild85.onSetFunctionValue(-$$Lambda$v_tScRfI12FOgJIG2xdCVs_9nhE, pairs7); -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c2 = new -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c(this);
/*  437 */     IVehicleFunction.IFilterCallback iFilterCallback64 = iValueTaskBuild100.useValuePAByIntBase(33386, -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c2);
/*      */     
/*  439 */     IVehicleFunction.IZone iZone69 = iFilterCallback64.createZone(new int[] { 4 }); -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ5 = new -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ(this);
/*  440 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild84 = iZone69.useStatusPAByIntBase(33391, -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ5); ECarXCarSeatclimateManager eCarXCarSeatclimateManager11 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager11); -$$Lambda$3RK6jNf04HrER4uMIZsxNVGTjrA -$$Lambda$3RK6jNf04HrER4uMIZsxNVGTjrA = new -$$Lambda$3RK6jNf04HrER4uMIZsxNVGTjrA(eCarXCarSeatclimateManager11);
/*      */     
/*  442 */     iValueTaskBuild84 = iValueTaskBuild84.onSetFunctionValue(-$$Lambda$3RK6jNf04HrER4uMIZsxNVGTjrA, pairs7); -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c1 = new -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c(this);
/*  443 */     IVehicleFunction.IFilterCallback iFilterCallback27 = iValueTaskBuild84.useValuePAByIntBase(33387, -$$Lambda$Hvac$PZDP8Uve1-6pl8VUhHYhLRBzw2c1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI41 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  445 */     iFilterCallback27.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI41);
/*      */ 
/*      */ 
/*      */     
/*  449 */     Pairs pairs6 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  450 */     pairs6 = pairs6.add(Integer.valueOf(268763649), Integer.valueOf(1));
/*  451 */     pairs6 = pairs6.add(Integer.valueOf(268763650), Integer.valueOf(2));
/*  452 */     pairs6 = pairs6.add(Integer.valueOf(268763651), Integer.valueOf(3));
/*  453 */     IVehicleFunction iVehicleFunction56 = VehicleFunction.intFunction(268763648);
/*  454 */     iVehicleFunction56 = iVehicleFunction56.supportedFunctionValue(new int[] { 0, 268763649, 268763650, 268763651 });
/*      */     
/*  456 */     IVehicleFunction.IZone iZone79 = iVehicleFunction56.createZone(new int[] { 1 }); -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ3 = new -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ(this);
/*  457 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild83 = iZone79.useStatusPAByIntBase(33381, -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ3); ECarXCarSeatclimateManager eCarXCarSeatclimateManager10 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager10); -$$Lambda$FAM41-YTns63iO8Hpxus2u8nxGw -$$Lambda$FAM41-YTns63iO8Hpxus2u8nxGw = new -$$Lambda$FAM41-YTns63iO8Hpxus2u8nxGw(eCarXCarSeatclimateManager10);
/*      */     
/*  459 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild99 = iValueTaskBuild83.onSetFunctionValue(-$$Lambda$FAM41-YTns63iO8Hpxus2u8nxGw, pairs6); -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ3 = new -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ(this);
/*  460 */     IVehicleFunction.IFilterCallback iFilterCallback63 = iValueTaskBuild99.useValuePAByIntBase(33373, -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ3);
/*      */     
/*  462 */     IVehicleFunction.IZone iZone78 = iFilterCallback63.createZone(new int[] { 4 }); -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ2 = new -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ(this);
/*  463 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild82 = iZone78.useStatusPAByIntBase(33382, -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ2); ECarXCarSeatclimateManager eCarXCarSeatclimateManager9 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager9); -$$Lambda$rMM2hbkB1n8ZrIDlhRl47uL0uLA -$$Lambda$rMM2hbkB1n8ZrIDlhRl47uL0uLA = new -$$Lambda$rMM2hbkB1n8ZrIDlhRl47uL0uLA(eCarXCarSeatclimateManager9);
/*      */     
/*  465 */     iValueTaskBuild82 = iValueTaskBuild82.onSetFunctionValue(-$$Lambda$rMM2hbkB1n8ZrIDlhRl47uL0uLA, pairs6); -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ4 = new -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ(this);
/*  466 */     IVehicleFunction.IFilterCallback iFilterCallback62 = iValueTaskBuild82.useValuePAByIntBase(33374, -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ4);
/*      */     
/*  468 */     IVehicleFunction.IZone iZone68 = iFilterCallback62.createZone(new int[] { 16 }); -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ4 = new -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ(this);
/*  469 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild81 = iZone68.useStatusPAByIntBase(33383, -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ4); ECarXCarSeatclimateManager eCarXCarSeatclimateManager8 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager8); -$$Lambda$RR6iL4rNknZIAVFTQxPGoP9B0SM -$$Lambda$RR6iL4rNknZIAVFTQxPGoP9B0SM = new -$$Lambda$RR6iL4rNknZIAVFTQxPGoP9B0SM(eCarXCarSeatclimateManager8);
/*      */     
/*  471 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild98 = iValueTaskBuild81.onSetFunctionValue(-$$Lambda$RR6iL4rNknZIAVFTQxPGoP9B0SM, pairs6); -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ2 = new -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ(this);
/*  472 */     IVehicleFunction.IFilterCallback iFilterCallback61 = iValueTaskBuild98.useValuePAByIntBase(33375, -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ2);
/*      */     
/*  474 */     IVehicleFunction.IZone iZone77 = iFilterCallback61.createZone(new int[] { 64 }); -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ1 = new -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ(this);
/*  475 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild80 = iZone77.useStatusPAByIntBase(33384, -$$Lambda$Hvac$QOMmKOCM0Ai6nc52t0yzjHLiQyQ1); ECarXCarSeatclimateManager eCarXCarSeatclimateManager7 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager7); -$$Lambda$QDg8quH8vwLRqJbkMFjJ_77YlFc -$$Lambda$QDg8quH8vwLRqJbkMFjJ_77YlFc = new -$$Lambda$QDg8quH8vwLRqJbkMFjJ_77YlFc(eCarXCarSeatclimateManager7);
/*      */     
/*  477 */     iValueTaskBuild80 = iValueTaskBuild80.onSetFunctionValue(-$$Lambda$QDg8quH8vwLRqJbkMFjJ_77YlFc, pairs6); -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ1 = new -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ(this);
/*  478 */     IVehicleFunction.IFilterCallback iFilterCallback26 = iValueTaskBuild80.useValuePAByIntBase(33376, -$$Lambda$Hvac$aqrYBx9O7TKF4wPej11Vgvlv0NQ1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI40 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  480 */     iFilterCallback26.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI40);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  487 */     Pairs pairs5 = Pairs.of(Integer.valueOf(268764161), Integer.valueOf(5));
/*  488 */     pairs5 = pairs5.add(Integer.valueOf(268764162), Integer.valueOf(15));
/*  489 */     pairs5 = pairs5.add(Integer.valueOf(268764163), Integer.valueOf(30));
/*  490 */     pairs5 = pairs5.add(Integer.valueOf(268764164), Integer.valueOf(59));
/*      */     
/*  492 */     IVehicleFunction iVehicleFunction55 = VehicleFunction.intFunction(268764160);
/*  493 */     iVehicleFunction55 = iVehicleFunction55.supportedFunctionValue(new int[] { 268764161, 268764162, 268764163, 268764164 });
/*      */ 
/*      */ 
/*      */     
/*  497 */     IVehicleFunction.IZone iZone67 = iVehicleFunction55.createZone(new int[] { 1 });
/*  498 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild79 = iZone67.useStatusPAByIntBase(33390); ECarXCarSeatclimateManager eCarXCarSeatclimateManager6 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager6); -$$Lambda$a7Cz_Zj3kaBmMerk9u9vp7wzFDQ -$$Lambda$a7Cz_Zj3kaBmMerk9u9vp7wzFDQ = new -$$Lambda$a7Cz_Zj3kaBmMerk9u9vp7wzFDQ(eCarXCarSeatclimateManager6);
/*  499 */     iValueTaskBuild79 = iValueTaskBuild79.onSetFunctionValue(-$$Lambda$a7Cz_Zj3kaBmMerk9u9vp7wzFDQ, pairs5); -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k2 = new -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k(this);
/*      */     
/*  501 */     IVehicleFunction.IFilterCallback iFilterCallback60 = iValueTaskBuild79.useValuePAByIntBase(33388, -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k2);
/*      */     
/*  503 */     IVehicleFunction.IZone iZone66 = iFilterCallback60.createZone(new int[] { 4 });
/*  504 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild78 = iZone66.useStatusPAByIntBase(33391); ECarXCarSeatclimateManager eCarXCarSeatclimateManager5 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager5); -$$Lambda$bvepllMS9RP2BJ28vX6oZwkrDyE -$$Lambda$bvepllMS9RP2BJ28vX6oZwkrDyE = new -$$Lambda$bvepllMS9RP2BJ28vX6oZwkrDyE(eCarXCarSeatclimateManager5);
/*  505 */     iValueTaskBuild78 = iValueTaskBuild78.onSetFunctionValue(-$$Lambda$bvepllMS9RP2BJ28vX6oZwkrDyE, pairs5); -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k1 = new -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k(this);
/*      */     
/*  507 */     IVehicleFunction.IFilterCallback iFilterCallback25 = iValueTaskBuild78.useValuePAByIntBase(33389, -$$Lambda$Hvac$zNg0gwW4TWTs2wZvhAMPUgXPZ7k1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI39 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  509 */     iFilterCallback25.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI39);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  516 */     Pairs pairs4 = Pairs.of(Integer.valueOf(268764673), Integer.valueOf(5));
/*  517 */     pairs4 = pairs4.add(Integer.valueOf(268764674), Integer.valueOf(15));
/*  518 */     pairs4 = pairs4.add(Integer.valueOf(268764675), Integer.valueOf(30));
/*  519 */     pairs4 = pairs4.add(Integer.valueOf(268764676), Integer.valueOf(59));
/*      */     
/*  521 */     IVehicleFunction iVehicleFunction54 = VehicleFunction.intFunction(268764672);
/*  522 */     iVehicleFunction54 = iVehicleFunction54.supportedFunctionValue(new int[] { 268764673, 268764674, 268764675, 268764676 });
/*      */ 
/*      */ 
/*      */     
/*  526 */     IVehicleFunction.IZone iZone65 = iVehicleFunction54.createZone(new int[] { 1 });
/*  527 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild77 = iZone65.useStatusPAByIntBase(33381); ECarXCarSeatclimateManager eCarXCarSeatclimateManager4 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager4); -$$Lambda$QX2R-8ihXYGQ0FA9DU4WFH0i__E -$$Lambda$QX2R-8ihXYGQ0FA9DU4WFH0i__E = new -$$Lambda$QX2R-8ihXYGQ0FA9DU4WFH0i__E(eCarXCarSeatclimateManager4);
/*  528 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild97 = iValueTaskBuild77.onSetFunctionValue(-$$Lambda$QX2R-8ihXYGQ0FA9DU4WFH0i__E, pairs4); -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g2 = new -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g(this);
/*      */     
/*  530 */     IVehicleFunction.IFilterCallback iFilterCallback59 = iValueTaskBuild97.useValuePAByIntBase(33377, -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g2);
/*      */     
/*  532 */     IVehicleFunction.IZone iZone64 = iFilterCallback59.createZone(new int[] { 4 });
/*  533 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild76 = iZone64.useStatusPAByIntBase(33382); ECarXCarSeatclimateManager eCarXCarSeatclimateManager3 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager3); -$$Lambda$_pMuOP8MpR4IPWn7LdFKUyDGCww -$$Lambda$_pMuOP8MpR4IPWn7LdFKUyDGCww = new -$$Lambda$_pMuOP8MpR4IPWn7LdFKUyDGCww(eCarXCarSeatclimateManager3);
/*  534 */     iValueTaskBuild76 = iValueTaskBuild76.onSetFunctionValue(-$$Lambda$_pMuOP8MpR4IPWn7LdFKUyDGCww, pairs4); -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g4 = new -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g(this);
/*      */     
/*  536 */     IVehicleFunction.IFilterCallback iFilterCallback58 = iValueTaskBuild76.useValuePAByIntBase(33378, -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g4);
/*      */     
/*  538 */     IVehicleFunction.IZone iZone63 = iFilterCallback58.createZone(new int[] { 16 });
/*  539 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild75 = iZone63.useStatusPAByIntBase(33383); ECarXCarSeatclimateManager eCarXCarSeatclimateManager2 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager2); -$$Lambda$cw0htmZQP43Y1r7_KqN1iYDWA_c -$$Lambda$cw0htmZQP43Y1r7_KqN1iYDWA_c = new -$$Lambda$cw0htmZQP43Y1r7_KqN1iYDWA_c(eCarXCarSeatclimateManager2);
/*  540 */     iValueTaskBuild75 = iValueTaskBuild75.onSetFunctionValue(-$$Lambda$cw0htmZQP43Y1r7_KqN1iYDWA_c, pairs4); -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g3 = new -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g(this);
/*      */     
/*  542 */     IVehicleFunction.IFilterCallback iFilterCallback57 = iValueTaskBuild75.useValuePAByIntBase(33379, -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g3);
/*      */     
/*  544 */     IVehicleFunction.IZone iZone62 = iFilterCallback57.createZone(new int[] { 64 });
/*  545 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild74 = iZone62.useStatusPAByIntBase(33384); ECarXCarSeatclimateManager eCarXCarSeatclimateManager1 = this.mSeatClimateMgr; Objects.requireNonNull(eCarXCarSeatclimateManager1); -$$Lambda$FGeMO5wo71eYBapHRKnDA3Tt4Gk -$$Lambda$FGeMO5wo71eYBapHRKnDA3Tt4Gk = new -$$Lambda$FGeMO5wo71eYBapHRKnDA3Tt4Gk(eCarXCarSeatclimateManager1);
/*  546 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild38 = iValueTaskBuild74.onSetFunctionValue(-$$Lambda$FGeMO5wo71eYBapHRKnDA3Tt4Gk, pairs4); -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g1 = new -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g(this);
/*      */     
/*  548 */     IVehicleFunction.IFilterCallback iFilterCallback56 = iValueTaskBuild38.useValuePAByIntBase(33380, -$$Lambda$Hvac$DRQwADlnW8XtraGWYlHXGjzfL9g1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI15 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  550 */     iFilterCallback56.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI15);
/*      */ 
/*      */ 
/*      */     
/*  554 */     IVehicleFunction iVehicleFunction32 = VehicleFunction.intFunction(268764928);
/*  555 */     iVehicleFunction32 = iVehicleFunction32.supportedFunctionValue(new int[] { 0, 268764929, 268764930, 268764931 });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  560 */     IVehicleFunction.IZone iZone36 = iVehicleFunction32.createZone(new int[] { 1 });
/*  561 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild37 = iZone36.useStatusPAByIntBase(33608); ECarXCarSeatctrlManager eCarXCarSeatctrlManager6 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager6); -$$Lambda$qg9AKMdmicgSvaPZNE5hroeNTlw -$$Lambda$qg9AKMdmicgSvaPZNE5hroeNTlw = new -$$Lambda$qg9AKMdmicgSvaPZNE5hroeNTlw(eCarXCarSeatctrlManager6); -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM2 = new -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM(this);
/*  562 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild73 = iValueTaskBuild37.onSetFunctionValue(-$$Lambda$qg9AKMdmicgSvaPZNE5hroeNTlw, -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM2); -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g2 = new -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g(this);
/*      */     
/*  564 */     IVehicleFunction.IFilterCallback iFilterCallback24 = iValueTaskBuild73.useValuePAByIntBase(33611, -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g2);
/*      */ 
/*      */     
/*  567 */     IVehicleFunction.IZone iZone35 = iFilterCallback24.createZone(new int[] { 4 });
/*  568 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild36 = iZone35.useStatusPAByIntBase(33612); ECarXCarSeatctrlManager eCarXCarSeatctrlManager5 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager5); -$$Lambda$2N8JEDbUZrsK7X4NE4TBBGekjf0 -$$Lambda$2N8JEDbUZrsK7X4NE4TBBGekjf0 = new -$$Lambda$2N8JEDbUZrsK7X4NE4TBBGekjf0(eCarXCarSeatctrlManager5); -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM1 = new -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM(this);
/*  569 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild72 = iValueTaskBuild36.onSetFunctionValue(-$$Lambda$2N8JEDbUZrsK7X4NE4TBBGekjf0, -$$Lambda$Hvac$qvHvtI-gsZpbpJeO4Fr1KGsSafM1); -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g1 = new -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g(this);
/*      */     
/*  571 */     IVehicleFunction.IFilterCallback iFilterCallback23 = iValueTaskBuild72.useValuePAByIntBase(33615, -$$Lambda$Hvac$Oi41UPcPwX9sNDsJzCTDhqlBV2g1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI38 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */ 
/*      */     
/*  574 */     iFilterCallback23.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI38);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  583 */     IVehicleFunction iVehicleFunction31 = VehicleFunction.intFunction(268765696); int[] arrayOfInt20 = COMMON_ON_OFF;
/*  584 */     iVehicleFunction31 = iVehicleFunction31.supportedFunctionValue(arrayOfInt20);
/*  585 */     IVehicleFunction.IZone iZone34 = iVehicleFunction31.createZone(new int[] { 1 });
/*  586 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild35 = iZone34.useStatusPAByIntBase(33608); ECarXCarSeatctrlManager eCarXCarSeatctrlManager4 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager4); -$$Lambda$rAZNX_SXPZxZXIKKsO4a8ylZSgk -$$Lambda$rAZNX_SXPZxZXIKKsO4a8ylZSgk = new -$$Lambda$rAZNX_SXPZxZXIKKsO4a8ylZSgk(eCarXCarSeatctrlManager4);
/*  587 */     iValueTaskBuild35 = iValueTaskBuild35.onSetFunctionValue(-$$Lambda$rAZNX_SXPZxZXIKKsO4a8ylZSgk, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M9 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/*  589 */     IVehicleFunction.IFilterCallback iFilterCallback22 = iValueTaskBuild35.useValuePAByIntBase(33609, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M9);
/*      */     
/*  591 */     IVehicleFunction.IZone iZone33 = iFilterCallback22.createZone(new int[] { 4 });
/*  592 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild34 = iZone33.useStatusPAByIntBase(33612); ECarXCarSeatctrlManager eCarXCarSeatctrlManager3 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager3); -$$Lambda$7LjmmunR1eDpLtmc2nFsqvk4_sg -$$Lambda$7LjmmunR1eDpLtmc2nFsqvk4_sg = new -$$Lambda$7LjmmunR1eDpLtmc2nFsqvk4_sg(eCarXCarSeatctrlManager3);
/*  593 */     iValueTaskBuild34 = iValueTaskBuild34.onSetFunctionValue(-$$Lambda$7LjmmunR1eDpLtmc2nFsqvk4_sg, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M8 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/*  595 */     IVehicleFunction.IFilterCallback iFilterCallback55 = iValueTaskBuild34.useValuePAByIntBase(33613, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M8); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI14 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  597 */     iFilterCallback55.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI14);
/*      */ 
/*      */     
/*  600 */     IVehicleFunction iVehicleFunction30 = VehicleFunction.intFunction(268765952);
/*  601 */     IVehicleFunction.IZone iZone61 = iVehicleFunction30.createZone(new int[] { 1 }); -$$Lambda$Hvac$60D0MTlvm3E5N6vFnYU5eZldxBo -$$Lambda$Hvac$60D0MTlvm3E5N6vFnYU5eZldxBo = new -$$Lambda$Hvac$60D0MTlvm3E5N6vFnYU5eZldxBo(this);
/*  602 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild2 = iZone61.supportedFunctionValue(-$$Lambda$Hvac$60D0MTlvm3E5N6vFnYU5eZldxBo, new int[] { 33630 });
/*      */ 
/*      */     
/*  605 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild33 = iStatusTaskBuild2.useStatusPAByIntBase(33608); ECarXCarSeatctrlManager eCarXCarSeatctrlManager2 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager2); -$$Lambda$HHbp1q6AF6JCOEx-Hz1V0eJJkOQ -$$Lambda$HHbp1q6AF6JCOEx-Hz1V0eJJkOQ = new -$$Lambda$HHbp1q6AF6JCOEx-Hz1V0eJJkOQ(eCarXCarSeatctrlManager2); -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs2 = new -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs(this);
/*  606 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild71 = iValueTaskBuild33.onSetFunctionValue(-$$Lambda$HHbp1q6AF6JCOEx-Hz1V0eJJkOQ, -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs2); -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog2 = new -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog(this);
/*      */     
/*  608 */     IVehicleFunction.IFilterCallback iFilterCallback21 = iValueTaskBuild71.useValuePAByIntBase(33610, -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog2);
/*      */ 
/*      */     
/*  611 */     IVehicleFunction.IZone iZone32 = iFilterCallback21.createZone(new int[] { 4 }); -$$Lambda$Hvac$i51-Sj3B3VWt22pacFsDMwAq7b8 -$$Lambda$Hvac$i51-Sj3B3VWt22pacFsDMwAq7b8 = new -$$Lambda$Hvac$i51-Sj3B3VWt22pacFsDMwAq7b8(this);
/*  612 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild1 = iZone32.supportedFunctionValue(-$$Lambda$Hvac$i51-Sj3B3VWt22pacFsDMwAq7b8, new int[] { 33631 });
/*      */ 
/*      */     
/*  615 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild32 = iStatusTaskBuild1.useStatusPAByIntBase(33612); ECarXCarSeatctrlManager eCarXCarSeatctrlManager1 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager1); -$$Lambda$uyMyZ-_61Wnvdl_DThvBfLHAuok -$$Lambda$uyMyZ-_61Wnvdl_DThvBfLHAuok = new -$$Lambda$uyMyZ-_61Wnvdl_DThvBfLHAuok(eCarXCarSeatctrlManager1); -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs1 = new -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs(this);
/*  616 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild70 = iValueTaskBuild32.onSetFunctionValue(-$$Lambda$uyMyZ-_61Wnvdl_DThvBfLHAuok, -$$Lambda$Hvac$cL7GswswHQDl0UbL3JjIMIj5Tjs1); -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog1 = new -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog(this);
/*      */     
/*  618 */     IVehicleFunction.IFilterCallback iFilterCallback54 = iValueTaskBuild70.useValuePAByIntBase(33614, -$$Lambda$Hvac$PBXFjj9860xD5KSGEaVmSuZlTog1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI13 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */ 
/*      */     
/*  621 */     iFilterCallback54.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI13);
/*      */ 
/*      */     
/*  624 */     IVehicleFunction iVehicleFunction29 = VehicleFunction.customFunction(268828928);
/*  625 */     iVehicleFunction29 = iVehicleFunction29.supportedFunctionValue(new int[] { 2 });
/*  626 */     IVehicleFunction.IZone iZone31 = iVehicleFunction29.createZone(new int[] { 1 });
/*  627 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild31 = iZone31.useStatusPAByIntBase(33325); ECarXCarClimateManager eCarXCarClimateManager18 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager18); -$$Lambda$9ovKGbiO_ZTmLCQCc3B7P2IFr_g -$$Lambda$9ovKGbiO_ZTmLCQCc3B7P2IFr_g = new -$$Lambda$9ovKGbiO_ZTmLCQCc3B7P2IFr_g(eCarXCarClimateManager18); -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ2 = new -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ(this); -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg4 = new -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg(this);
/*  628 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild69 = iValueTaskBuild31.onSetFunctionValue(-$$Lambda$9ovKGbiO_ZTmLCQCc3B7P2IFr_g, -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ2, -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg4); -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s3 = new -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s(this);
/*      */     
/*  630 */     IVehicleFunction.IFilterCallback iFilterCallback20 = iValueTaskBuild69.useValuePAByIntBase(33325, -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s3);
/*      */     
/*  632 */     IVehicleFunction.IZone iZone30 = iFilterCallback20.createZone(new int[] { 4 });
/*  633 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iZone30.useStatusPAByIntBase(33326); ECarXCarClimateManager eCarXCarClimateManager17 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager17); -$$Lambda$MN8wXtNW8Fr7QCvUvVNGFkU3dPc -$$Lambda$MN8wXtNW8Fr7QCvUvVNGFkU3dPc = new -$$Lambda$MN8wXtNW8Fr7QCvUvVNGFkU3dPc(eCarXCarClimateManager17); -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ1 = new -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ(this); -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg3 = new -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg(this);
/*  634 */     iValueTaskBuild30 = iValueTaskBuild30.onSetFunctionValue(-$$Lambda$MN8wXtNW8Fr7QCvUvVNGFkU3dPc, -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ1, -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg3); -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s5 = new -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s(this);
/*      */     
/*  636 */     IVehicleFunction.IFilterCallback iFilterCallback19 = iValueTaskBuild30.useValuePAByIntBase(33326, -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s5);
/*      */     
/*  638 */     IVehicleFunction.IZone iZone29 = iFilterCallback19.createZone(new int[] { 16 });
/*  639 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iZone29.useStatusPAByIntBase(33340); ECarXCarClimateManager eCarXCarClimateManager16 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager16); -$$Lambda$hkTEkIpjOOjhzDf5Jk7wDCO3WCw -$$Lambda$hkTEkIpjOOjhzDf5Jk7wDCO3WCw = new -$$Lambda$hkTEkIpjOOjhzDf5Jk7wDCO3WCw(eCarXCarClimateManager16); -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ3 = new -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ(this); -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg2 = new -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg(this);
/*  640 */     iValueTaskBuild29 = iValueTaskBuild29.onSetFunctionValue(-$$Lambda$hkTEkIpjOOjhzDf5Jk7wDCO3WCw, -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ3, -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg2); -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s4 = new -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s(this);
/*      */     
/*  642 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild29.useValuePAByIntBase(33340, -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s4);
/*      */     
/*  644 */     IVehicleFunction.IZone iZone28 = iFilterCallback18.createZone(new int[] { 64 });
/*  645 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iZone28.useStatusPAByIntBase(33341); ECarXCarClimateManager eCarXCarClimateManager15 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager15); -$$Lambda$kwZT_NHMz5xQ6e-G9TgnQj0vmGQ -$$Lambda$kwZT_NHMz5xQ6e-G9TgnQj0vmGQ = new -$$Lambda$kwZT_NHMz5xQ6e-G9TgnQj0vmGQ(eCarXCarClimateManager15); -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ3 = new -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ(this); -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg1 = new -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg(this);
/*  646 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild68 = iValueTaskBuild28.onSetFunctionValue(-$$Lambda$kwZT_NHMz5xQ6e-G9TgnQj0vmGQ, -$$Lambda$Hvac$B5Fc63lkmwnWM3iDobRj-ZoP6CQ3, -$$Lambda$Hvac$HF9B0hkA4fAu4x_4IpGckXp8aGg1); -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s2 = new -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s(this);
/*      */     
/*  648 */     IVehicleFunction.IFilterCallback iFilterCallback53 = iValueTaskBuild68.useValuePAByIntBase(33341, -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s2); -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw3 = new -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw(this);
/*      */     
/*  650 */     iFilterCallback53.addTo(-$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw3);
/*      */ 
/*      */     
/*  653 */     IVehicleFunction iVehicleFunction28 = VehicleFunction.customFunction(268830464);
/*  654 */     iVehicleFunction28 = iVehicleFunction28.supportedFunctionValue(new int[] { 2 });
/*  655 */     IVehicleFunction.IZone iZone27 = iVehicleFunction28.createZone(new int[] { 1 });
/*  656 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild67 = iZone27.useStatusPAByIntBase(33369); -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s1 = new -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s(this);
/*      */ 
/*      */     
/*  659 */     IVehicleFunction.IFilterCallback iFilterCallback52 = iValueTaskBuild67.useValuePAByIntBase(33369, -$$Lambda$Hvac$x2eISRaLwsEdheZh7_oSba8zR5s1); -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw2 = new -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw(this);
/*      */     
/*  661 */     iFilterCallback52.addTo(-$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw2);
/*      */ 
/*      */     
/*  664 */     IVehicleFunction iVehicleFunction27 = VehicleFunction.customFunction(268829184);
/*  665 */     IVehicleFunction.IZone iZone26 = iVehicleFunction27.createZone(new int[] { Integer.MIN_VALUE, 8, 1, 4, 128, 16, 64, 2048, 256, 1024 }); FunctionStatus functionStatus11 = FunctionStatus.active;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  675 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iZone26.fixStatus(functionStatus11); -$$Lambda$Hvac$FnIh9ZOoWvhVKO_8tNimfODgTXI -$$Lambda$Hvac$FnIh9ZOoWvhVKO_8tNimfODgTXI = -$$Lambda$Hvac$FnIh9ZOoWvhVKO_8tNimfODgTXI.INSTANCE;
/*  676 */     IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild27.useValuePAByIntBase(33470, -$$Lambda$Hvac$FnIh9ZOoWvhVKO_8tNimfODgTXI); -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw5 = new -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  685 */     iFilterCallback17.addTo(-$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw5);
/*      */ 
/*      */     
/*  688 */     IVehicleFunction iVehicleFunction26 = VehicleFunction.customFunction(268829440);
/*  689 */     IVehicleFunction.IZone iZone60 = iVehicleFunction26.createZone(new int[] { Integer.MIN_VALUE, 8, 1, 4, 128, 16, 64, 2048, 256, 1024 }); FunctionStatus functionStatus4 = FunctionStatus.active;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  699 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iZone60.fixStatus(functionStatus4); -$$Lambda$Hvac$13ngukzcsZvMZn1YTsHmS75bOMI -$$Lambda$Hvac$13ngukzcsZvMZn1YTsHmS75bOMI = -$$Lambda$Hvac$13ngukzcsZvMZn1YTsHmS75bOMI.INSTANCE;
/*  700 */     IVehicleFunction.IFilterCallback iFilterCallback51 = iValueTaskBuild26.useValuePAByIntBase(33470, -$$Lambda$Hvac$13ngukzcsZvMZn1YTsHmS75bOMI); -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw1 = new -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  709 */     iFilterCallback51.addTo(-$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw1);
/*      */ 
/*      */     
/*  712 */     IVehicleFunction iVehicleFunction25 = VehicleFunction.customFunction(268829696);
/*  713 */     IVehicleFunction.IZone iZone25 = iVehicleFunction25.createZone(new int[] { Integer.MIN_VALUE, 8, 1, 4, 128, 16, 64, 2048, 256, 1024 }); FunctionStatus functionStatus10 = FunctionStatus.active;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  723 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild66 = iZone25.fixStatus(functionStatus10); -$$Lambda$Hvac$609XgYtgFbG3FBAo-LVKN4QSBfk -$$Lambda$Hvac$609XgYtgFbG3FBAo-LVKN4QSBfk = -$$Lambda$Hvac$609XgYtgFbG3FBAo-LVKN4QSBfk.INSTANCE;
/*  724 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild66.useValuePAByIntBase(33470, -$$Lambda$Hvac$609XgYtgFbG3FBAo-LVKN4QSBfk); -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw4 = new -$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  733 */     iFilterCallback16.addTo(-$$Lambda$Hvac$PzSi4DV2nJ2Yqa8RITwIne4_Ziw4);
/*      */ 
/*      */     
/*  736 */     IVehicleFunction iVehicleFunction24 = VehicleFunction.intFunction(268829952); int[] arrayOfInt19 = COMMON_ON_OFF;
/*  737 */     iVehicleFunction24 = iVehicleFunction24.supportedFunctionValue(arrayOfInt19);
/*  738 */     IVehicleFunction.IZone iZone24 = iVehicleFunction24.createZone(new int[] { Integer.MIN_VALUE });
/*  739 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iZone24.useStatusPAByIntBase(33334); ECarXCarClimateManager eCarXCarClimateManager14 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager14); -$$Lambda$1HaCAJXm85AgMoqUrFPzBuNA1AI -$$Lambda$1HaCAJXm85AgMoqUrFPzBuNA1AI = new -$$Lambda$1HaCAJXm85AgMoqUrFPzBuNA1AI(eCarXCarClimateManager14);
/*  740 */     iValueTaskBuild25 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$1HaCAJXm85AgMoqUrFPzBuNA1AI, pairs1);
/*      */     
/*  742 */     IVehicleFunction.IFilterCallback iFilterCallback50 = iValueTaskBuild25.useValuePAByIntBase(33334, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI12 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  744 */     iFilterCallback50.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI12);
/*      */ 
/*      */     
/*  747 */     IVehicleFunction iVehicleFunction23 = VehicleFunction.intFunction(268830208);
/*  748 */     iVehicleFunction23 = iVehicleFunction23.supportedFunctionValue(new int[] { 268830209, 268830210 });
/*  749 */     IVehicleFunction.IZone iZone23 = iVehicleFunction23.createZone(new int[] { Integer.MIN_VALUE, 8, 1, 4, 128, 16, 64, 2048, 256, 1024 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  759 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iZone23.useStatusPAByIntBase(33470); ECarXCarSystemsettingManager eCarXCarSystemsettingManager = this.mSystemSettingMgr; Objects.requireNonNull(eCarXCarSystemsettingManager); -$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs -$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs = new -$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs(eCarXCarSystemsettingManager);
/*      */     
/*  761 */     Pairs pairs15 = Pairs.of(Integer.valueOf(268830209), Integer.valueOf(0));
/*  762 */     pairs15 = pairs15.add(Integer.valueOf(268830210), Integer.valueOf(1));
/*      */     iValueTaskBuild24 = iValueTaskBuild24.onSetFunctionValue(-$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs, pairs15);
/*  764 */     Pairs pairs11 = Pairs.of(Integer.valueOf(0), Integer.valueOf(268830209));
/*  765 */     pairs11 = pairs11.add(Integer.valueOf(1), Integer.valueOf(268830210)); IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild24.useValuePAByIntBase(33470, pairs11); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI37 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*  766 */     iFilterCallback15.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI37);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  771 */     Pairs pairs3 = Pairs.of(Integer.valueOf(268894472), Integer.valueOf(7));
/*  772 */     pairs3 = pairs3.add(Integer.valueOf(268894468), Integer.valueOf(2));
/*  773 */     pairs3 = pairs3.add(Integer.valueOf(268894466), Integer.valueOf(0));
/*  774 */     pairs3 = pairs3.add(Integer.valueOf(268894465), Integer.valueOf(1));
/*  775 */     pairs3 = pairs3.add(Integer.valueOf(268894470), Integer.valueOf(3));
/*  776 */     pairs3 = pairs3.add(Integer.valueOf(268894467), Integer.valueOf(4));
/*  777 */     pairs3 = pairs3.add(Integer.valueOf(268894469), Integer.valueOf(5));
/*  778 */     pairs3 = pairs3.add(Integer.valueOf(268894471), Integer.valueOf(6));
/*  779 */     IVehicleFunction iVehicleFunction53 = VehicleFunction.intFunction(268894464);
/*  780 */     iVehicleFunction53 = iVehicleFunction53.supportedFunctionValue(new int[] { 0, 268894465, 268894466, 268894467, 268894468, 268894469, 268894470, 268894471, 268894472 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  789 */     IVehicleFunction.IZone iZone59 = iVehicleFunction53.createZone(new int[] { 8 });
/*  790 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild65 = iZone59.useStatusPAByIntBase(33320); ECarXCarClimateManager eCarXCarClimateManager36 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager36); -$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c -$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c2 = new -$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c(eCarXCarClimateManager36);
/*  791 */     iValueTaskBuild65 = iValueTaskBuild65.onSetFunctionValue(-$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c2, pairs3); -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU6 = new -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU(this);
/*  792 */     IVehicleFunction.IFilterCallback iFilterCallback49 = iValueTaskBuild65.useValuePAByIntBase(33320, -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU6);
/*      */     
/*  794 */     IVehicleFunction.IZone iZone58 = iFilterCallback49.createZone(new int[] { 1 });
/*  795 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild64 = iZone58.useStatusPAByIntBase(33320); ECarXCarClimateManager eCarXCarClimateManager35 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager35); -$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c -$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c1 = new -$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c(eCarXCarClimateManager35);
/*  796 */     iValueTaskBuild64 = iValueTaskBuild64.onSetFunctionValue(-$$Lambda$1s_7ej1-sQEcVObXLigA6ClX38c1, pairs3); -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU5 = new -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU(this);
/*  797 */     IVehicleFunction.IFilterCallback iFilterCallback48 = iValueTaskBuild64.useValuePAByIntBase(33320, -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU5);
/*      */     
/*  799 */     IVehicleFunction.IZone iZone57 = iFilterCallback48.createZone(new int[] { 4 });
/*  800 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild63 = iZone57.useStatusPAByIntBase(33321); ECarXCarClimateManager eCarXCarClimateManager34 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager34); -$$Lambda$c2mQF8zEdonhpxza4jyinydAUOs -$$Lambda$c2mQF8zEdonhpxza4jyinydAUOs = new -$$Lambda$c2mQF8zEdonhpxza4jyinydAUOs(eCarXCarClimateManager34);
/*  801 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild96 = iValueTaskBuild63.onSetFunctionValue(-$$Lambda$c2mQF8zEdonhpxza4jyinydAUOs, pairs3); -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU4 = new -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU(this);
/*  802 */     IVehicleFunction.IFilterCallback iFilterCallback47 = iValueTaskBuild96.useValuePAByIntBase(33321, -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU4);
/*      */     
/*  804 */     IVehicleFunction.IZone iZone56 = iFilterCallback47.createZone(new int[] { 128 });
/*  805 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild62 = iZone56.useStatusPAByIntBase(33322); ECarXCarClimateManager eCarXCarClimateManager33 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager33); -$$Lambda$bGyRdSez_4vsDZatG53hTEaxnGw -$$Lambda$bGyRdSez_4vsDZatG53hTEaxnGw = new -$$Lambda$bGyRdSez_4vsDZatG53hTEaxnGw(eCarXCarClimateManager33);
/*  806 */     iValueTaskBuild62 = iValueTaskBuild62.onSetFunctionValue(-$$Lambda$bGyRdSez_4vsDZatG53hTEaxnGw, pairs3); -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU2 = new -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU(this);
/*  807 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild62.useValuePAByIntBase(33322, -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI36 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  809 */     iFilterCallback14.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI36);
/*      */ 
/*      */     
/*  812 */     IVehicleFunction iVehicleFunction22 = VehicleFunction.intFunction(268896256);
/*  813 */     iVehicleFunction22 = iVehicleFunction22.supportedFunctionValue(new int[] { 0, 268894465, 268894466, 268894467, 268894468, 268894469, 268894470, 268894471, 268894472 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  822 */     IVehicleFunction.IZone iZone22 = iVehicleFunction22.createZone(new int[] { 8 });
/*  823 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild61 = iZone22.useStatusPAByIntBase(33370); -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU1 = new -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU(this);
/*      */     
/*  825 */     IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild61.useValuePAByIntBase(33370, -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU1);
/*      */     
/*  827 */     IVehicleFunction.IZone iZone21 = iFilterCallback13.createZone(new int[] { 1 });
/*  828 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iZone21.useStatusPAByIntBase(33370); -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU3 = new -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU(this);
/*      */     
/*  830 */     IVehicleFunction.IFilterCallback iFilterCallback46 = iValueTaskBuild23.useValuePAByIntBase(33370, -$$Lambda$Hvac$3JY23koJUjNL62lPhZAJ0UQ11EU3); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI11 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/*  832 */     iFilterCallback46.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI11);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1000 */     IVehicleFunction iVehicleFunction21 = VehicleFunction.intFunction(268895744);
/* 1001 */     IVehicleFunction.IZone iZone20 = iVehicleFunction21.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$Hvac$KQ03MKdmOzzGIjRkOhwa-BIOjc4 -$$Lambda$Hvac$KQ03MKdmOzzGIjRkOhwa-BIOjc4 = new -$$Lambda$Hvac$KQ03MKdmOzzGIjRkOhwa-BIOjc4(this);
/* 1002 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iZone20.useStatusSignal(29329, -$$Lambda$Hvac$KQ03MKdmOzzGIjRkOhwa-BIOjc4); -$$Lambda$Hvac$_5sM4xs1WF3AkuX5szavTXz7fAs -$$Lambda$Hvac$_5sM4xs1WF3AkuX5szavTXz7fAs = -$$Lambda$Hvac$_5sM4xs1WF3AkuX5szavTXz7fAs.INSTANCE;
/*      */     
/* 1004 */     IVehicleFunction.IFilterCallback iFilterCallback45 = iValueTaskBuild22.useValueSignal(30528, -$$Lambda$Hvac$_5sM4xs1WF3AkuX5szavTXz7fAs); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI10 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1012 */     iFilterCallback45.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI10);
/*      */ 
/*      */ 
/*      */     
/* 1016 */     IVehicleFunction iVehicleFunction52 = VehicleFunction.intFunction(268960000); int[] arrayOfInt5 = COMMON_ON_OFF;
/* 1017 */     IVehicleFunction iVehicleFunction20 = iVehicleFunction52.supportedFunctionValue(arrayOfInt5);
/* 1018 */     IVehicleFunction.IZone iZone19 = iVehicleFunction20.createZone(new int[] { Integer.MIN_VALUE });
/* 1019 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iZone19.useStatusPAByIntBase(33335); ECarXCarClimateManager eCarXCarClimateManager13 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager13); -$$Lambda$2gCVpCTj4_rjntMrFJTso-9uwtI -$$Lambda$2gCVpCTj4_rjntMrFJTso-9uwtI = new -$$Lambda$2gCVpCTj4_rjntMrFJTso-9uwtI(eCarXCarClimateManager13);
/* 1020 */     iValueTaskBuild21 = iValueTaskBuild21.onSetFunctionValue(-$$Lambda$2gCVpCTj4_rjntMrFJTso-9uwtI, pairs1);
/*      */     
/* 1022 */     IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild21.useValuePAByIntBase(33335, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI35 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1024 */     iFilterCallback12.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI35);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1030 */     IVehicleFunction iVehicleFunction19 = VehicleFunction.intFunction(268960512); int[] arrayOfInt18 = COMMON_ON_OFF;
/* 1031 */     iVehicleFunction19 = iVehicleFunction19.supportedFunctionValue(arrayOfInt18);
/* 1032 */     IVehicleFunction.IZone iZone18 = iVehicleFunction19.createZone(new int[] { Integer.MIN_VALUE });
/* 1033 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iZone18.useStatusPAByIntBase(33349); ECarXCarClimateManager eCarXCarClimateManager12 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager12); -$$Lambda$3fCZ7ZIcMlXJOLhSrW1_4jRQ6tk -$$Lambda$3fCZ7ZIcMlXJOLhSrW1_4jRQ6tk = new -$$Lambda$3fCZ7ZIcMlXJOLhSrW1_4jRQ6tk(eCarXCarClimateManager12);
/* 1034 */     iValueTaskBuild20 = iValueTaskBuild20.onSetFunctionValue(-$$Lambda$3fCZ7ZIcMlXJOLhSrW1_4jRQ6tk, pairs1);
/* 1035 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild20.useValuePAByIntBase(33349, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI34 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1037 */     iFilterCallback11.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI34);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1046 */     IVehicleFunction iVehicleFunction18 = VehicleFunction.intFunction(269025536);
/* 1047 */     iVehicleFunction18 = iVehicleFunction18.supportedFunctionValue(new int[] { 0, 269025537, 269025538, 269025539 });
/*      */ 
/*      */     
/* 1050 */     IVehicleFunction.IZone iZone17 = iVehicleFunction18.createZone(new int[] { Integer.MIN_VALUE });
/* 1051 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus2 = iZone17.useStatusSignals(new int[] { 33394, 33395 }); -$$Lambda$Hvac$g7AejrelFoGUGbS4SW_oGsvCCPQ -$$Lambda$Hvac$g7AejrelFoGUGbS4SW_oGsvCCPQ = new -$$Lambda$Hvac$g7AejrelFoGUGbS4SW_oGsvCCPQ(this);
/*      */     
/* 1053 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iMultiSignalStatus2.onStatusSignalChanged(-$$Lambda$Hvac$g7AejrelFoGUGbS4SW_oGsvCCPQ); ECarXCarSteerwhlheatgManager eCarXCarSteerwhlheatgManager2 = this.mSteerWhlHeatMgr; Objects.requireNonNull(eCarXCarSteerwhlheatgManager2); -$$Lambda$V9J1OFEnZgNJp_tmqCdoFSdYIbw -$$Lambda$V9J1OFEnZgNJp_tmqCdoFSdYIbw = new -$$Lambda$V9J1OFEnZgNJp_tmqCdoFSdYIbw(eCarXCarSteerwhlheatgManager2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1071 */     Pairs pairs14 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 1072 */     pairs14 = pairs14.add(Integer.valueOf(269025537), Integer.valueOf(1));
/* 1073 */     pairs14 = pairs14.add(Integer.valueOf(269025538), Integer.valueOf(2));
/* 1074 */     pairs14 = pairs14.add(Integer.valueOf(269025539), Integer.valueOf(3)); iValueTaskBuild19 = iValueTaskBuild19.onSetFunctionValue(-$$Lambda$V9J1OFEnZgNJp_tmqCdoFSdYIbw, pairs14); -$$Lambda$Hvac$x3bIo9LiwRGaSa5pbxJBlbDNFIo -$$Lambda$Hvac$x3bIo9LiwRGaSa5pbxJBlbDNFIo = new -$$Lambda$Hvac$x3bIo9LiwRGaSa5pbxJBlbDNFIo(this);
/* 1075 */     IVehicleFunction.IFilterCallback iFilterCallback44 = iValueTaskBuild19.useValuePAByIntBase(33394, -$$Lambda$Hvac$x3bIo9LiwRGaSa5pbxJBlbDNFIo); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI9 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1077 */     iFilterCallback44.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI9);
/*      */ 
/*      */     
/* 1080 */     IVehicleFunction iVehicleFunction17 = VehicleFunction.intFunction(269025792);
/* 1081 */     iVehicleFunction17 = iVehicleFunction17.supportedFunctionValue(new int[] { 0, 269025793, 269025794, 269025795 });
/*      */ 
/*      */ 
/*      */     
/* 1085 */     IVehicleFunction.IZone iZone16 = iVehicleFunction17.createZone();
/* 1086 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iZone16.useStatusPAByIntBase(33393);
/*      */     
/* 1088 */     Pairs pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 1089 */     pairs10 = pairs10.orDefault(Integer.valueOf(269025793)); IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild18.useValueSignal(30502, pairs10); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI33 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1090 */     iFilterCallback10.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI33);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1097 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(269026304); int[] arrayOfInt17 = COMMON_ON_OFF;
/* 1098 */     iVehicleFunction16 = iVehicleFunction16.supportedFunctionValue(arrayOfInt17);
/* 1099 */     IVehicleFunction.IZone iZone15 = iVehicleFunction16.createZone(new int[] { Integer.MIN_VALUE });
/* 1100 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iZone15.useStatusPAByIntBase(33393); ECarXCarSteerwhlheatgManager eCarXCarSteerwhlheatgManager1 = this.mSteerWhlHeatMgr; Objects.requireNonNull(eCarXCarSteerwhlheatgManager1); -$$Lambda$oTVqPhprg7H6PIoWgbkJVlmriXk -$$Lambda$oTVqPhprg7H6PIoWgbkJVlmriXk = new -$$Lambda$oTVqPhprg7H6PIoWgbkJVlmriXk(eCarXCarSteerwhlheatgManager1);
/* 1101 */     iValueTaskBuild17 = iValueTaskBuild17.onSetFunctionValue(-$$Lambda$oTVqPhprg7H6PIoWgbkJVlmriXk, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M7 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/* 1103 */     IVehicleFunction.IFilterCallback iFilterCallback43 = iValueTaskBuild17.useValuePAByIntBase(33393, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M7); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI8 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1105 */     iFilterCallback43.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI8);
/*      */ 
/*      */     
/* 1108 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.intFunction(269091072); int[] arrayOfInt16 = COMMON_ON_OFF;
/* 1109 */     iVehicleFunction15 = iVehicleFunction15.supportedFunctionValue(arrayOfInt16);
/* 1110 */     IVehicleFunction.IZone iZone14 = iVehicleFunction15.createZone(new int[] { Integer.MIN_VALUE });
/* 1111 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iZone14.useStatusPAByIntBase(33336); ECarXCarClimateManager eCarXCarClimateManager11 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager11); -$$Lambda$ZWct9mefRN79Ws-0HLb0a-_wPuE -$$Lambda$ZWct9mefRN79Ws-0HLb0a-_wPuE = new -$$Lambda$ZWct9mefRN79Ws-0HLb0a-_wPuE(eCarXCarClimateManager11);
/* 1112 */     iValueTaskBuild16 = iValueTaskBuild16.onSetFunctionValue(-$$Lambda$ZWct9mefRN79Ws-0HLb0a-_wPuE, pairs1);
/* 1113 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild16.useValuePAByIntBase(33336, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI32 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1114 */     iFilterCallback9.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI32);
/*      */ 
/*      */     
/* 1117 */     IVehicleFunction iVehicleFunction51 = VehicleFunction.intFunction(269091328); int[] arrayOfInt4 = COMMON_ON_OFF;
/* 1118 */     IVehicleFunction iVehicleFunction14 = iVehicleFunction51.supportedFunctionValue(arrayOfInt4);
/* 1119 */     IVehicleFunction.IZone iZone13 = iVehicleFunction14.createZone(new int[] { Integer.MIN_VALUE });
/* 1120 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone13.useStatusPAByIntBase(33337); ECarXCarClimateManager eCarXCarClimateManager10 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager10); -$$Lambda$excQ0DMLpp-OZc2v3MVpw09AjQw -$$Lambda$excQ0DMLpp-OZc2v3MVpw09AjQw = new -$$Lambda$excQ0DMLpp-OZc2v3MVpw09AjQw(eCarXCarClimateManager10);
/* 1121 */     iValueTaskBuild15 = iValueTaskBuild15.onSetFunctionValue(-$$Lambda$excQ0DMLpp-OZc2v3MVpw09AjQw, pairs1);
/* 1122 */     IVehicleFunction.IFilterCallback iFilterCallback42 = iValueTaskBuild15.useValuePAByIntBase(33337, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI7 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1123 */     iFilterCallback42.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1138 */     IVehicleFunction iVehicleFunction50 = VehicleFunction.intFunction(269222144); int[] arrayOfInt3 = COMMON_ON_OFF;
/* 1139 */     IVehicleFunction iVehicleFunction13 = iVehicleFunction50.supportedFunctionValue(arrayOfInt3);
/* 1140 */     IVehicleFunction.IZone iZone12 = iVehicleFunction13.createZone(new int[] { Integer.MIN_VALUE });
/* 1141 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone12.useStatusPAByIntBase(33398); ECarXCarAirqlyandfragraManager eCarXCarAirqlyandfragraManager2 = this.mAirqlandFragraMgr; Objects.requireNonNull(eCarXCarAirqlyandfragraManager2); -$$Lambda$f5ZNCnj1jDrWuP45qlkoYPEu7xA -$$Lambda$f5ZNCnj1jDrWuP45qlkoYPEu7xA = new -$$Lambda$f5ZNCnj1jDrWuP45qlkoYPEu7xA(eCarXCarAirqlyandfragraManager2);
/* 1142 */     iValueTaskBuild14 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$f5ZNCnj1jDrWuP45qlkoYPEu7xA, pairs1);
/*      */     
/* 1144 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild14.useValuePAByIntBase(33405, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI31 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */ 
/*      */     
/* 1147 */     iFilterCallback8.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI31);
/*      */ 
/*      */     
/* 1150 */     IVehicleFunction iVehicleFunction49 = VehicleFunction.intFunction(269222400); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 1151 */     IVehicleFunction iVehicleFunction12 = iVehicleFunction49.supportedFunctionValue(arrayOfInt2);
/* 1152 */     IVehicleFunction.IZone iZone11 = iVehicleFunction12.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus9 = FunctionStatus.active;
/* 1153 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild60 = iZone11.fixStatus(functionStatus9); -$$Lambda$Hvac$9TKS012i5D6GOBRlUCBhi7kUq4s -$$Lambda$Hvac$9TKS012i5D6GOBRlUCBhi7kUq4s = -$$Lambda$Hvac$9TKS012i5D6GOBRlUCBhi7kUq4s.INSTANCE;
/* 1154 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild60.useValuePAByIntBase(33402, -$$Lambda$Hvac$9TKS012i5D6GOBRlUCBhi7kUq4s); -$$Lambda$Hvac$R2jdLGWgvrWdUtOzHTLP8k4UpYM -$$Lambda$Hvac$R2jdLGWgvrWdUtOzHTLP8k4UpYM = -$$Lambda$Hvac$R2jdLGWgvrWdUtOzHTLP8k4UpYM.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1163 */     IVehicleFunction.ITaskEnd iTaskEnd6 = iFilterCallback7.filterValue(-$$Lambda$Hvac$R2jdLGWgvrWdUtOzHTLP8k4UpYM); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI6 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1164 */     iTaskEnd6.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI6);
/*      */ 
/*      */     
/* 1167 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(269222656);
/* 1168 */     iVehicleFunction11 = iVehicleFunction11.supportedFunctionValue(new int[] { 0, 1, 2 });
/* 1169 */     IVehicleFunction.IZone iZone10 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus8 = FunctionStatus.active;
/* 1170 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone10.fixStatus(functionStatus8); ECarXCarAirqlyandfragraManager eCarXCarAirqlyandfragraManager1 = this.mAirqlandFragraMgr; Objects.requireNonNull(eCarXCarAirqlyandfragraManager1); -$$Lambda$bjKFBe0ZacgAxLGHXLel5KGltSg -$$Lambda$bjKFBe0ZacgAxLGHXLel5KGltSg = new -$$Lambda$bjKFBe0ZacgAxLGHXLel5KGltSg(eCarXCarAirqlyandfragraManager1);
/*      */     
/* 1172 */     pairs14 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2));
/* 1173 */     pairs14 = pairs14.add(Integer.valueOf(1), Integer.valueOf(1));
/* 1174 */     pairs14 = pairs14.add(Integer.valueOf(2), Integer.valueOf(0)); IVehicleFunction.IValueTaskBuild iValueTaskBuild59 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$bjKFBe0ZacgAxLGHXLel5KGltSg, pairs14); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI5 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1175 */     iValueTaskBuild59.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI5);
/*      */ 
/*      */     
/* 1178 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(269287680); int[] arrayOfInt15 = COMMON_ON_OFF;
/* 1179 */     iVehicleFunction10 = iVehicleFunction10.supportedFunctionValue(arrayOfInt15);
/* 1180 */     IVehicleFunction.IZone iZone9 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE });
/* 1181 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild58 = iZone9.useStatusPAByIntBase(33350); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/* 1182 */     IVehicleFunction.IFilterCallback iFilterCallback41 = iValueTaskBuild58.useValuePAByIntBase(33350, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2); -$$Lambda$Hvac$iE237Ut84xoQTXuypJKIaw_k17E -$$Lambda$Hvac$iE237Ut84xoQTXuypJKIaw_k17E = -$$Lambda$Hvac$iE237Ut84xoQTXuypJKIaw_k17E.INSTANCE;
/*      */     
/* 1184 */     IVehicleFunction.ITaskEnd iTaskEnd2 = iFilterCallback41.filterValue(-$$Lambda$Hvac$iE237Ut84xoQTXuypJKIaw_k17E); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI30 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1185 */     iTaskEnd2.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI30);
/*      */ 
/*      */     
/* 1188 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.intFunction(269287936);
/* 1189 */     iVehicleFunction9 = iVehicleFunction9.supportedFunctionValue(new int[] { 0, 1, 2 });
/* 1190 */     IVehicleFunction.IZone iZone8 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus7 = FunctionStatus.active;
/* 1191 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone8.fixStatus(functionStatus7); ECarXCarClimateManager eCarXCarClimateManager9 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager9); -$$Lambda$hj1gGXupj9UUcd_8-4BGXuKzkLY -$$Lambda$hj1gGXupj9UUcd_8-4BGXuKzkLY = new -$$Lambda$hj1gGXupj9UUcd_8-4BGXuKzkLY(eCarXCarClimateManager9);
/*      */     
/* 1193 */     pairs14 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 1194 */     pairs14 = pairs14.add(Integer.valueOf(1), Integer.valueOf(1));
/* 1195 */     pairs14 = pairs14.add(Integer.valueOf(2), Integer.valueOf(1)); IVehicleFunction.IValueTaskBuild iValueTaskBuild57 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$hj1gGXupj9UUcd_8-4BGXuKzkLY, pairs14); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI4 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1196 */     iValueTaskBuild57.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1208 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(269419008); int[] arrayOfInt14 = COMMON_ON_OFF;
/* 1209 */     iVehicleFunction8 = iVehicleFunction8.supportedFunctionValue(arrayOfInt14);
/* 1210 */     IVehicleFunction.IZone iZone7 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/* 1211 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone7.useStatusPAByIntBase(33355); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M6 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/* 1212 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild11.useValuePAByIntBase(33355, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M6); -$$Lambda$Hvac$4jiBepYlryosgn7ggpolm5PjBWA -$$Lambda$Hvac$4jiBepYlryosgn7ggpolm5PjBWA = -$$Lambda$Hvac$4jiBepYlryosgn7ggpolm5PjBWA.INSTANCE;
/*      */     
/* 1214 */     IVehicleFunction.ITaskEnd iTaskEnd5 = iFilterCallback6.filterValue(-$$Lambda$Hvac$4jiBepYlryosgn7ggpolm5PjBWA); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI3 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1215 */     iTaskEnd5.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI3);
/*      */ 
/*      */     
/* 1218 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(269418752); int[] arrayOfInt13 = COMMON_ON_OFF;
/* 1219 */     iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(arrayOfInt13);
/* 1220 */     IVehicleFunction.IZone iZone6 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/* 1221 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone6.useStatusPAByIntBase(33359); ECarXCarClimateManager eCarXCarClimateManager8 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager8); -$$Lambda$_cOWRi5AYeb50-G6jRq9FVVoy_4 -$$Lambda$_cOWRi5AYeb50-G6jRq9FVVoy_4 = new -$$Lambda$_cOWRi5AYeb50-G6jRq9FVVoy_4(eCarXCarClimateManager8);
/* 1222 */     iValueTaskBuild10 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$_cOWRi5AYeb50-G6jRq9FVVoy_4, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M5 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/* 1224 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild10.useValuePAByIntBase(33359, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M5); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI29 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1226 */     iFilterCallback5.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI29);
/*      */ 
/*      */     
/* 1229 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(269419264);
/* 1230 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 1, 0, 2 });
/* 1231 */     IVehicleFunction.IZone iZone55 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus3 = FunctionStatus.active;
/* 1232 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone55.fixStatus(functionStatus3); ECarXCarClimateManager eCarXCarClimateManager7 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager7); -$$Lambda$-ECH1zN9MDsI2OcqBDmk5EROtMc -$$Lambda$-ECH1zN9MDsI2OcqBDmk5EROtMc = new -$$Lambda$-ECH1zN9MDsI2OcqBDmk5EROtMc(eCarXCarClimateManager7);
/*      */     
/* 1234 */     pairs14 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 1235 */     pairs14 = pairs14.add(Integer.valueOf(1), Integer.valueOf(1));
/* 1236 */     pairs14 = pairs14.add(Integer.valueOf(2), Integer.valueOf(0)); iValueTaskBuild9 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$-ECH1zN9MDsI2OcqBDmk5EROtMc, pairs14); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI28 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1237 */     iValueTaskBuild9.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI28);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1243 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(269484544); int[] arrayOfInt12 = COMMON_ON_OFF;
/* 1244 */     iVehicleFunction5 = iVehicleFunction5.supportedFunctionValue(arrayOfInt12);
/* 1245 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 1246 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone5.useStatusPAByIntBase(33360); ECarXCarClimateManager eCarXCarClimateManager6 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager6); -$$Lambda$RZQafiP5fpH1-z3mNZGLIH71v_E -$$Lambda$RZQafiP5fpH1-z3mNZGLIH71v_E = new -$$Lambda$RZQafiP5fpH1-z3mNZGLIH71v_E(eCarXCarClimateManager6);
/* 1247 */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$RZQafiP5fpH1-z3mNZGLIH71v_E, pairs1);
/*      */     
/* 1249 */     IVehicleFunction.IFilterCallback iFilterCallback40 = iValueTaskBuild8.useValuePAByIntBase(33360, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI2 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1251 */     iFilterCallback40.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1257 */     IVehicleFunction iVehicleFunction48 = VehicleFunction.intFunction(269485056); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 1258 */     IVehicleFunction iVehicleFunction4 = iVehicleFunction48.supportedFunctionValue(arrayOfInt1);
/* 1259 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 1260 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone4.useStatusPAByIntBase(33362); ECarXCarClimateManager eCarXCarClimateManager5 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager5); -$$Lambda$t6147U8OlOH2ZmMP8I8Ju0yUZFw -$$Lambda$t6147U8OlOH2ZmMP8I8Ju0yUZFw = new -$$Lambda$t6147U8OlOH2ZmMP8I8Ju0yUZFw(eCarXCarClimateManager5);
/* 1261 */     iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$t6147U8OlOH2ZmMP8I8Ju0yUZFw, pairs1);
/*      */     
/* 1263 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild7.useValuePAByIntBase(33362, pairs2); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI27 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1265 */     iFilterCallback4.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI27);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1280 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(269615360); int[] arrayOfInt11 = COMMON_ON_OFF;
/* 1281 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(arrayOfInt11);
/* 1282 */     IVehicleFunction.IZone iZone54 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 1283 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone54.fixStatus(functionStatus2);
/* 1284 */     IVehicleFunction.IFilterCallback iFilterCallback39 = iValueTaskBuild6.useValuePAByIntBase(33351, pairs2); -$$Lambda$Hvac$-GoIbgDuNKd7Dj3jrX1Ultnsqzc -$$Lambda$Hvac$-GoIbgDuNKd7Dj3jrX1Ultnsqzc = -$$Lambda$Hvac$-GoIbgDuNKd7Dj3jrX1Ultnsqzc.INSTANCE;
/*      */     
/* 1286 */     IVehicleFunction.ITaskEnd iTaskEnd1 = iFilterCallback39.filterValue(-$$Lambda$Hvac$-GoIbgDuNKd7Dj3jrX1Ultnsqzc); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI26 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1288 */     iTaskEnd1.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI26);
/*      */ 
/*      */     
/* 1291 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(269615616); int[] arrayOfInt10 = COMMON_ON_OFF;
/* 1292 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(arrayOfInt10);
/* 1293 */     IVehicleFunction.IZone iZone53 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 1294 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone53.fixStatus(functionStatus1); ECarXCarClimateManager eCarXCarClimateManager4 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager4); -$$Lambda$4alVPIVNKBwxCouj37TOWrkCS8k -$$Lambda$4alVPIVNKBwxCouj37TOWrkCS8k = new -$$Lambda$4alVPIVNKBwxCouj37TOWrkCS8k(eCarXCarClimateManager4);
/* 1295 */     iValueTaskBuild5 = iValueTaskBuild5.onSetFunctionValue(-$$Lambda$4alVPIVNKBwxCouj37TOWrkCS8k, pairs1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI25 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/* 1296 */     iValueTaskBuild5.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI25);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1302 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(268505344); int[] arrayOfInt9 = COMMON_ON_OFF;
/* 1303 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(arrayOfInt9);
/* 1304 */     IVehicleFunction.IZone iZone3 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/* 1305 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone3.useStatusPAByIntBase(33338); ECarXCarClimateManager eCarXCarClimateManager3 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager3); -$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms -$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms1 = new -$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms(eCarXCarClimateManager3);
/* 1306 */     iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$pdRekbBdmjXl8TOBk89__Xkqhms1, pairs1);
/* 1307 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild4.useValuePAByIntBase(33338, pairs2);
/*      */     
/* 1309 */     IVehicleFunction.IZone iZone2 = iFilterCallback3.createZone(new int[] { 128 });
/* 1310 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone2.useStatusPAByIntBase(33347); ECarXCarClimateManager eCarXCarClimateManager2 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager2); -$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys0 -$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys01 = new -$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys0(eCarXCarClimateManager2);
/* 1311 */     iValueTaskBuild3 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$RGCAiLeg34aZhOx6lAKiq-X4ys01, pairs1);
/* 1312 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild3.useValuePAByIntBase(33347, pairs2);
/*      */     
/* 1314 */     IVehicleFunction.IZone iZone1 = iFilterCallback2.createZone(new int[] { 2048 });
/* 1315 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone1.useStatusPAByIntBase(33339); ECarXCarClimateManager eCarXCarClimateManager1 = this.mClimateMgr; Objects.requireNonNull(eCarXCarClimateManager1); -$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o -$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o1 = new -$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o(eCarXCarClimateManager1);
/* 1316 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$RqP5wRd2F9VrBcDxbqDo7fpgH2o1, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/* 1317 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33339, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1); -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI1 = new -$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI(this);
/*      */     
/* 1319 */     iFilterCallback1.addTo(-$$Lambda$Hvac$drS9FFTJCCjAWZfk81ocaclnVMI1);
/*      */   }
/*      */   
/*      */   private int[] getHotStoneSupportValues(int paramInt) {
/* 1323 */     FunctionStatus functionStatus = getFunctionStatus(paramInt);
/* 1324 */     if (functionStatus == FunctionStatus.notavailable) {
/* 1325 */       return new int[] { 268765954, 268765955, 268765956, 268765957, 268765958, 268765959, 268765960 };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1335 */     return new int[] { 268765953, 268765954, 268765955, 268765956, 268765957, 268765958, 268765959, 268765960 };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getSeatVentilationHeatStatus(PATypes.PA_IntBase paramPA_IntBase) {
/* 1349 */     FunctionStatus functionStatus = SignalUtils.convertToFunctionStatus(paramPA_IntBase.getAvailability());
/* 1350 */     if (functionStatus == FunctionStatus.notavailable || functionStatus == FunctionStatus.notactive)
/*      */     {
/* 1352 */       return functionStatus;
/*      */     }
/* 1354 */     int i = paramPA_IntBase.getData();
/* 1355 */     if (i == 1 || i == 2 || i == 3) {
/* 1356 */       return functionStatus;
/*      */     }
/*      */     
/* 1359 */     return FunctionStatus.error;
/*      */   }
/*      */ 
/*      */   
/*      */   private int getClimateZone(int paramInt) {
/* 1364 */     if (paramInt == 5)
/* 1365 */       return 268502275; 
/* 1366 */     if (paramInt == 129) {
/* 1367 */       return 268502276;
/*      */     }
/* 1369 */     return 268502274;
/*      */   }
/*      */ 
/*      */   
/*      */   private float convertIndex2Temper(int paramInt) {
/* 1374 */     int i = getIntValue(33470, 0);
/*      */     
/* 1376 */     if (i == 1) {
/* 1377 */       return (59 + paramInt - 1);
/*      */     }
/* 1379 */     return 15.5F + (paramInt - 1) * 0.5F;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertTemper2Index(float paramFloat) {
/* 1384 */     int i = getIntValue(33470, 0);
/*      */     
/* 1386 */     if (i == 1) {
/* 1387 */       return (int)(paramFloat - 59.0F + 1.0F);
/*      */     }
/* 1389 */     return (int)((paramFloat - 15.5F) / 0.5F + 1.0F);
/*      */   }
/*      */   
/*      */   private boolean checkTemper(float paramFloat) {
/*      */     boolean bool;
/* 1394 */     float f1 = getCustomizeFunctionValue(268829184);
/* 1395 */     float f2 = getCustomizeFunctionValue(268829440);
/* 1396 */     if (paramFloat >= f2 && paramFloat <= f1) { bool = true; } else { bool = false; }  return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertSeatMassgProgToVP(int paramInt) {
/* 1401 */     boolean bool = false;
/* 1402 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1430 */         return paramInt;case 268765960: paramInt = 7; return paramInt;case 268765959: paramInt = 6; return paramInt;case 268765958: paramInt = 5; return paramInt;case 268765957: paramInt = 4; return paramInt;case 268765956: paramInt = 3; return paramInt;case 268765955: paramInt = 2; return paramInt;case 268765954: paramInt = 1; return paramInt;case 268765953: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertSeatMassgProgToAdapterAPI(int paramInt) {
/* 1435 */     boolean bool = false;
/* 1436 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1464 */         return paramInt;case 7: paramInt = 268765960; return paramInt;case 6: paramInt = 268765959; return paramInt;case 5: paramInt = 268765958; return paramInt;case 4: paramInt = 268765957; return paramInt;case 3: paramInt = 268765956; return paramInt;case 2: paramInt = 268765955; return paramInt;case 1: paramInt = 268765954; return paramInt;case 0: break; }  paramInt = 268765953; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertSeatMassgToAdapterAPI(int paramInt) {
/* 1469 */     int i = 268764929;
/* 1470 */     switch (paramInt) { default: paramInt = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1483 */         return paramInt;case 2: paramInt = 268764931; return paramInt;case 1: paramInt = 268764930; return paramInt;case 0: break; }  paramInt = 268764929; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertSeatMassgLevelToVP(int paramInt) {
/* 1488 */     boolean bool = false;
/* 1489 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1502 */         return paramInt;case 268764931: paramInt = 2; return paramInt;case 268764930: paramInt = 1; return paramInt;case 268764929: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertFanMode(int paramInt) {
/* 1507 */     switch (paramInt)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1528 */         return 255;case 7: return 268894472;case 6: return 268894471;case 5: return 268894469;
/*      */       case 4: return 268894467;
/*      */       case 3: return 268894470;
/*      */       case 2: return 268894468;
/*      */       case 1: return 268894465;
/* 1533 */       case 0: break; }  return 268894466; } private int convertAutoFanSpeed(int paramInt) { if (paramInt != 0) { switch (paramInt)
/*      */       
/*      */       { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         default:
/* 1547 */           return 255;
/*      */         case 14: return 268567045;
/*      */         case 13: return 268567043;
/*      */         case 12: return 268567042;
/*      */         case 11: return 268567041;
/*      */         case 10:
/* 1553 */           break; }  return 268567044; }  return 0; } private int convertManualFanSpeed(int paramInt) { switch (paramInt)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1575 */         return 255;case 9: return 268566793;case 8: return 268566792;case 7: return 268566791;case 6: return 268566790;
/*      */       case 5: return 268566789;
/*      */       case 4: return 268566788;
/*      */       case 3: return 268566787;
/*      */       case 2: return 268566786;
/*      */       case 1: return 268566785;
/* 1581 */       case 0: break; }  return 0; } private int convertHeatTimerGear(int paramInt) { if (paramInt != 5) { if (paramInt != 15) { if (paramInt != 30) { if (paramInt != 59)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1591 */             return 255; }  return 268764676; }
/*      */          return 268764675; }
/*      */       
/*      */       return 268764674; }
/*      */     
/* 1596 */     return 268764673; } private int convertVentilationTimer(int paramInt) { if (paramInt != 5) { if (paramInt != 15) { if (paramInt != 30) { if (paramInt != 59)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1606 */             return 255; }  return 268764164; }
/*      */         
/*      */         return 268764163; }
/*      */       
/*      */       return 268764162; }
/*      */     
/* 1612 */     return 268764161; } private int convertHeatGear(int paramInt) { switch (paramInt)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1622 */         return 255;
/*      */       case 3: return 268763651;
/*      */       case 2: return 268763650;
/*      */       case 1: return 268763649;
/*      */       case 0:
/* 1627 */         break; }  return 0; } private int convertSteerWheelGear(int paramInt) { switch (paramInt)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1637 */         return 255;
/*      */       case 3: return 269025539;
/*      */       case 2: return 269025538;
/*      */       case 1: return 269025537;
/*      */       case 0:
/* 1642 */         break; }  return 0; } private int convertVentilationGear(int paramInt) { switch (paramInt)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1652 */         return 255;
/*      */       case 3: return 268763395;
/*      */       case 2: return 268763394;
/*      */       case 1:
/*      */         return 268763393;
/*      */       case 0:
/* 1658 */         break; }  return 0; } private boolean isEx11() { try { boolean bool; int i = this.mCarSignalManager.getcarconfig1();
/* 1659 */       if (i == 161) { bool = true; } else { bool = false; }  return bool; }
/* 1660 */     catch (CarNotConnectedException carNotConnectedException)
/* 1661 */     { carNotConnectedException.printStackTrace();
/*      */       
/* 1663 */       String str = SystemProperties.get("ro.build.product", "");
/* 1664 */       return str.startsWith("ex11"); }
/*      */      }
/*      */    private boolean isKX11() {
/*      */     try {
/*      */       boolean bool;
/* 1669 */       int i = this.mCarSignalManager.getcarconfig1();
/* 1670 */       if (i == 162) { bool = true; } else { bool = false; }  return bool;
/* 1671 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 1672 */       carNotConnectedException.printStackTrace();
/*      */       
/* 1674 */       String str = SystemProperties.get("ro.build.product", "");
/* 1675 */       return str.startsWith("kx11");
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hvac\Hvac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */