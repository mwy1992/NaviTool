/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleType;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarDrivemodeManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*     */ import java.util.LinkedList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DriveMode
/*     */   extends AbsCarFunction
/*     */   implements IDriveMode
/*     */ {
/*  39 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*  40 */   private static final int[] DRIVE_MODE_ALL = new int[] { 33439, 33440, 33441, 33442, 33443, 33465, 33446, 33447, 33448, 33449, 33450, 33451, 33452 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private static final int[] DRIVE_MODE_VALUES = new int[] { 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14 };
/*     */ 
/*     */   
/*     */   private ECarXCarDrivemodeManager mECarXCarDrivemodeManager;
/*     */ 
/*     */   
/*     */   private ECarXCarVfmiscManager mVFMiscMgr;
/*     */ 
/*     */ 
/*     */   
/*     */   protected DriveMode(Context paramContext) {
/*  68 */     super(paramContext, 570425344);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  73 */     this.mECarXCarDrivemodeManager = this.mECarXCarSetManager.getECarXCarDrivemodeManager();
/*  74 */     this.mVFMiscMgr = this.mECarXCarSetManager.getECarXCarVfmiscManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  84 */     Pairs pairs9 = Pairs.of(Integer.valueOf(570491137), Integer.valueOf(1));
/*  85 */     pairs9 = pairs9.add(Integer.valueOf(570491138), Integer.valueOf(2));
/*  86 */     pairs9 = pairs9.add(Integer.valueOf(570491139), Integer.valueOf(3));
/*  87 */     pairs9 = pairs9.add(Integer.valueOf(570491155), Integer.valueOf(5));
/*  88 */     pairs9 = pairs9.add(Integer.valueOf(570491158), Integer.valueOf(6));
/*     */     
/*  90 */     pairs9 = pairs9.add(Integer.valueOf(570491149), Integer.valueOf(12));
/*  91 */     pairs9 = pairs9.add(Integer.valueOf(570491200), Integer.valueOf(4));
/*  92 */     pairs9 = pairs9.add(Integer.valueOf(570491143), Integer.valueOf(9));
/*  93 */     pairs9 = pairs9.add(Integer.valueOf(570491146), Integer.valueOf(13));
/*  94 */     pairs9 = pairs9.add(Integer.valueOf(570491142), Integer.valueOf(8));
/*  95 */     pairs9 = pairs9.add(Integer.valueOf(570491144), Integer.valueOf(10));
/*  96 */     pairs9 = pairs9.add(Integer.valueOf(570491147), Integer.valueOf(14));
/*  97 */     Pairs pairs18 = pairs9.add(Integer.valueOf(570491145), Integer.valueOf(11));
/*  98 */     pairs9 = pairs18.reverse();
/*     */     
/* 100 */     IVehicleFunction iVehicleFunction30 = VehicleFunction.intFunction(570491136);
/* 101 */     IVehicleFunction.IZone iZone25 = iVehicleFunction30.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$DriveMode$COuWj0-jHgGwZEZdt3zJmjYa8wM -$$Lambda$DriveMode$COuWj0-jHgGwZEZdt3zJmjYa8wM = new -$$Lambda$DriveMode$COuWj0-jHgGwZEZdt3zJmjYa8wM(this); int[] arrayOfInt17 = DRIVE_MODE_ALL;
/* 102 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild7 = iZone25.supportedFunctionValue(-$$Lambda$DriveMode$COuWj0-jHgGwZEZdt3zJmjYa8wM, arrayOfInt17); FunctionStatus functionStatus = FunctionStatus.active;
/* 103 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild33 = iStatusTaskBuild7.fixStatus(functionStatus); ECarXCarDrivemodeManager eCarXCarDrivemodeManager7 = this.mECarXCarDrivemodeManager; Objects.requireNonNull(eCarXCarDrivemodeManager7); -$$Lambda$aZGNVsICe6Y2blzS9anaKZ2OMyg -$$Lambda$aZGNVsICe6Y2blzS9anaKZ2OMyg = new -$$Lambda$aZGNVsICe6Y2blzS9anaKZ2OMyg(eCarXCarDrivemodeManager7);
/* 104 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iValueTaskBuild33.onSetFunctionValue(-$$Lambda$aZGNVsICe6Y2blzS9anaKZ2OMyg, pairs18);
/* 105 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild24.useValuePAByIntBase(33463, pairs9); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q23 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */     
/* 107 */     iFilterCallback6.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q23);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     Pairs pairs8 = Pairs.of(Integer.valueOf(570622209), Integer.valueOf(1));
/* 115 */     pairs8 = pairs8.add(Integer.valueOf(570622210), Integer.valueOf(2));
/* 116 */     pairs8 = pairs8.add(Integer.valueOf(570622211), Integer.valueOf(3));
/* 117 */     pairs8 = pairs8.add(Integer.valueOf(570622212), Integer.valueOf(5));
/* 118 */     pairs8 = pairs8.add(Integer.valueOf(570622213), Integer.valueOf(11));
/* 119 */     pairs8 = pairs8.add(Integer.valueOf(570622214), Integer.valueOf(12));
/* 120 */     pairs8 = pairs8.add(Integer.valueOf(570622215), Integer.valueOf(9));
/* 121 */     pairs8 = pairs8.add(Integer.valueOf(570622216), Integer.valueOf(8));
/* 122 */     pairs8 = pairs8.add(Integer.valueOf(570622217), Integer.valueOf(10));
/* 123 */     Pairs pairs17 = pairs8.add(Integer.valueOf(570491158), Integer.valueOf(6));
/* 124 */     pairs8 = pairs17.reverse();
/*     */     
/* 126 */     IVehicleFunction iVehicleFunction29 = VehicleFunction.intFunction(570622208);
/* 127 */     IVehicleFunction.IZone iZone23 = iVehicleFunction29.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$DriveMode$hslXwj1RuAO5zt4TRUubP4KFdyw -$$Lambda$DriveMode$hslXwj1RuAO5zt4TRUubP4KFdyw = new -$$Lambda$DriveMode$hslXwj1RuAO5zt4TRUubP4KFdyw(this);
/* 128 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild6 = iZone23.supportedFunctionValue(-$$Lambda$DriveMode$hslXwj1RuAO5zt4TRUubP4KFdyw, new int[] { 33457, 29337 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild32 = iStatusTaskBuild6.useStatusPAByIntBase(33457); ECarXCarDrivemodeManager eCarXCarDrivemodeManager6 = this.mECarXCarDrivemodeManager; Objects.requireNonNull(eCarXCarDrivemodeManager6); -$$Lambda$x6z-ajmQhwsC7a-V9-LlTbAzFIA -$$Lambda$x6z-ajmQhwsC7a-V9-LlTbAzFIA = new -$$Lambda$x6z-ajmQhwsC7a-V9-LlTbAzFIA(eCarXCarDrivemodeManager6);
/*     */     
/* 146 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iValueTaskBuild32.onSetFunctionValue(-$$Lambda$x6z-ajmQhwsC7a-V9-LlTbAzFIA, pairs17);
/*     */     
/* 148 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild23.useValuePAByIntBase(33457, pairs8); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q9 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */ 
/*     */     
/* 151 */     iFilterCallback10.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q9);
/*     */ 
/*     */ 
/*     */     
/* 155 */     Pairs pairs7 = Pairs.of(Integer.valueOf(570622466), Integer.valueOf(0));
/* 156 */     pairs7 = pairs7.add(Integer.valueOf(570622465), Integer.valueOf(1));
/* 157 */     pairs7 = pairs7.add(Integer.valueOf(570622467), Integer.valueOf(2));
/* 158 */     Pairs pairs16 = pairs7.add(Integer.valueOf(570622468), Integer.valueOf(3));
/*     */     
/* 160 */     pairs7 = pairs16.reverse();
/* 161 */     IVehicleFunction iVehicleFunction28 = VehicleFunction.intFunction(570622464);
/* 162 */     IVehicleFunction.IZone iZone22 = iVehicleFunction28.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$DriveMode$agIfyiSVhriMfhiNkM0yy_0G66s -$$Lambda$DriveMode$agIfyiSVhriMfhiNkM0yy_0G66s = new -$$Lambda$DriveMode$agIfyiSVhriMfhiNkM0yy_0G66s(this);
/* 163 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild5 = iZone22.supportedFunctionValue(-$$Lambda$DriveMode$agIfyiSVhriMfhiNkM0yy_0G66s, new int[] { 33462 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild31 = iStatusTaskBuild5.useStatusPAByIntBase(33462); ECarXCarDrivemodeManager eCarXCarDrivemodeManager5 = this.mECarXCarDrivemodeManager; Objects.requireNonNull(eCarXCarDrivemodeManager5); -$$Lambda$2w5fSDmzHVKBuxKM6bVugviUnuM -$$Lambda$2w5fSDmzHVKBuxKM6bVugviUnuM = new -$$Lambda$2w5fSDmzHVKBuxKM6bVugviUnuM(eCarXCarDrivemodeManager5);
/*     */     
/* 192 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iValueTaskBuild31.onSetFunctionValue(-$$Lambda$2w5fSDmzHVKBuxKM6bVugviUnuM, pairs16);
/*     */     
/* 194 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild22.useValuePAByIntBase(33462, pairs7); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q8 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */ 
/*     */     
/* 197 */     iFilterCallback9.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q8);
/*     */ 
/*     */ 
/*     */     
/* 201 */     Pairs pairs6 = Pairs.of(Integer.valueOf(570622721), Integer.valueOf(0));
/* 202 */     Pairs pairs15 = pairs6.add(Integer.valueOf(570622722), Integer.valueOf(1));
/* 203 */     pairs6 = pairs15.reverse();
/* 204 */     IVehicleFunction iVehicleFunction27 = VehicleFunction.intFunction(570622720);
/* 205 */     IVehicleFunction.IZone iZone24 = iVehicleFunction27.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$DriveMode$8XMCyYkcpR4IMnybMjgSLP4ZmvE -$$Lambda$DriveMode$8XMCyYkcpR4IMnybMjgSLP4ZmvE = new -$$Lambda$DriveMode$8XMCyYkcpR4IMnybMjgSLP4ZmvE(this);
/* 206 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild4 = iZone24.supportedFunctionValue(-$$Lambda$DriveMode$8XMCyYkcpR4IMnybMjgSLP4ZmvE, new int[] { 33456 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iStatusTaskBuild4.useStatusPAByIntBase(33456); ECarXCarDrivemodeManager eCarXCarDrivemodeManager4 = this.mECarXCarDrivemodeManager; Objects.requireNonNull(eCarXCarDrivemodeManager4); -$$Lambda$_gKyv3ZLy8Vg4CyrK49PmriaJSI -$$Lambda$_gKyv3ZLy8Vg4CyrK49PmriaJSI = new -$$Lambda$_gKyv3ZLy8Vg4CyrK49PmriaJSI(eCarXCarDrivemodeManager4);
/* 215 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iValueTaskBuild30.onSetFunctionValue(-$$Lambda$_gKyv3ZLy8Vg4CyrK49PmriaJSI, pairs15);
/*     */     
/* 217 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild21.useValuePAByIntBase(33456, pairs6); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q7 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */     
/* 219 */     iFilterCallback8.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     Pairs pairs5 = Pairs.of(Integer.valueOf(570624257), Integer.valueOf(3));
/* 228 */     pairs5 = pairs5.add(Integer.valueOf(570624258), Integer.valueOf(2));
/* 229 */     Pairs pairs14 = pairs5.add(Integer.valueOf(570624259), Integer.valueOf(1));
/* 230 */     pairs5 = pairs14.reverse();
/* 231 */     IVehicleFunction iVehicleFunction26 = VehicleFunction.intFunction(570624256);
/* 232 */     IVehicleFunction.IZone iZone21 = iVehicleFunction26.createZone(new int[] { Integer.MIN_VALUE });
/* 233 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild3 = iZone21.supportedFunctionValue(new int[] { 570624257, 570624258, 570624259 });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iStatusTaskBuild3.useStatusPAByIntBase(33640); ECarXCarVfmiscManager eCarXCarVfmiscManager4 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager4); -$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0 -$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0 = new -$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0(eCarXCarVfmiscManager4);
/*     */     
/* 240 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iValueTaskBuild29.onSetFunctionValue(-$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0, pairs14);
/*     */ 
/*     */     
/* 243 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild20.useValuePAByIntBase(33640, pairs5); VehicleType vehicleType = VehicleType.EX11;
/*     */ 
/*     */     
/* 246 */     IVehicleFunction.IZone iZone15 = iFilterCallback5.createZone(vehicleType, new int[] { Integer.MIN_VALUE });
/* 247 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild1 = iZone15.supportedFunctionValue(new int[] { 570624257, 570624259 });
/*     */ 
/*     */ 
/*     */     
/* 251 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iStatusTaskBuild1.useStatusPAByIntBase(33459); ECarXCarDrivemodeManager eCarXCarDrivemodeManager1 = this.mECarXCarDrivemodeManager; Objects.requireNonNull(eCarXCarDrivemodeManager1); -$$Lambda$yZyuX-I-aSEh6EVQVtkyih7FHIY -$$Lambda$yZyuX-I-aSEh6EVQVtkyih7FHIY = new -$$Lambda$yZyuX-I-aSEh6EVQVtkyih7FHIY(eCarXCarDrivemodeManager1);
/*     */ 
/*     */ 
/*     */     
/* 255 */     Pairs pairs19 = Pairs.of(Integer.valueOf(570624259), Integer.valueOf(1));
/* 256 */     pairs19 = pairs19.add(Integer.valueOf(570624257), Integer.valueOf(3));
/*     */     
/*     */     iValueTaskBuild10 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$yZyuX-I-aSEh6EVQVtkyih7FHIY, pairs19);
/* 259 */     Pairs pairs13 = Pairs.of(Integer.valueOf(1), Integer.valueOf(570624259));
/* 260 */     pairs13 = pairs13.add(Integer.valueOf(3), Integer.valueOf(570624257)); IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild10.useValuePAByIntBase(33459, pairs13); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q22 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 261 */     iFilterCallback4.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q22);
/*     */ 
/*     */ 
/*     */     
/* 265 */     Pairs pairs4 = Pairs.of(Integer.valueOf(570624514), Integer.valueOf(1));
/* 266 */     Pairs pairs12 = pairs4.add(Integer.valueOf(570624513), Integer.valueOf(0));
/* 267 */     pairs4 = pairs12.reverse();
/* 268 */     IVehicleFunction iVehicleFunction25 = VehicleFunction.intFunction(570624512);
/* 269 */     IVehicleFunction.IZone iZone20 = iVehicleFunction25.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$DriveMode$haLtQtBJIyohH89TrkadXP64BVM -$$Lambda$DriveMode$haLtQtBJIyohH89TrkadXP64BVM = new -$$Lambda$DriveMode$haLtQtBJIyohH89TrkadXP64BVM(this);
/* 270 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild2 = iZone20.supportedFunctionValue(-$$Lambda$DriveMode$haLtQtBJIyohH89TrkadXP64BVM, new int[] { 33458 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iStatusTaskBuild2.useStatusPAByIntBase(33458); ECarXCarDrivemodeManager eCarXCarDrivemodeManager3 = this.mECarXCarDrivemodeManager; Objects.requireNonNull(eCarXCarDrivemodeManager3); -$$Lambda$xsvdT6kFH4xbxqd-jQV7Vn3HQ_A -$$Lambda$xsvdT6kFH4xbxqd-jQV7Vn3HQ_A = new -$$Lambda$xsvdT6kFH4xbxqd-jQV7Vn3HQ_A(eCarXCarDrivemodeManager3);
/*     */     
/* 281 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iValueTaskBuild28.onSetFunctionValue(-$$Lambda$xsvdT6kFH4xbxqd-jQV7Vn3HQ_A, pairs12);
/*     */     
/* 283 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild19.useValuePAByIntBase(33458, pairs4); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q21 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */ 
/*     */     
/* 286 */     iFilterCallback3.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q21);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     Pairs pairs3 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 300 */     Pairs pairs11 = pairs3.add(Integer.valueOf(1), Integer.valueOf(1));
/* 301 */     pairs3 = pairs11.reverse();
/* 302 */     IVehicleFunction iVehicleFunction24 = VehicleFunction.intFunction(570625536); int[] arrayOfInt19 = COMMON_ON_OFF;
/* 303 */     iVehicleFunction24 = iVehicleFunction24.supportedFunctionValue(arrayOfInt19);
/* 304 */     IVehicleFunction.IZone iZone19 = iVehicleFunction24.createZone(new int[] { Integer.MIN_VALUE });
/* 305 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iZone19.useStatusPAByIntBase(33461); ECarXCarDrivemodeManager eCarXCarDrivemodeManager2 = this.mECarXCarDrivemodeManager; Objects.requireNonNull(eCarXCarDrivemodeManager2); -$$Lambda$yOUX7uoAqyfh-NYQ1D56pjuUSsI -$$Lambda$yOUX7uoAqyfh-NYQ1D56pjuUSsI = new -$$Lambda$yOUX7uoAqyfh-NYQ1D56pjuUSsI(eCarXCarDrivemodeManager2);
/* 306 */     iValueTaskBuild27 = iValueTaskBuild27.onSetFunctionValue(-$$Lambda$yOUX7uoAqyfh-NYQ1D56pjuUSsI, pairs11);
/*     */     
/* 308 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild27.useValuePAByIntBase(33461, pairs3); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q24 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */     
/* 310 */     iFilterCallback11.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q24);
/*     */     
/* 312 */     IVehicleFunction iVehicleFunction31 = VehicleFunction.intFunction(570687744); int[] arrayOfInt16 = COMMON_ON_OFF;
/* 313 */     IVehicleFunction iVehicleFunction23 = iVehicleFunction31.supportedFunctionValue(arrayOfInt16);
/* 314 */     IVehicleFunction.IZone iZone18 = iVehicleFunction23.createZone(new int[] { Integer.MIN_VALUE });
/* 315 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iZone18.useStatusPAByIntBase(33675); ECarXCarVfmiscManager eCarXCarVfmiscManager3 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager3); -$$Lambda$tk_DnKVUgqiew4TUrNAQUHqliRM -$$Lambda$tk_DnKVUgqiew4TUrNAQUHqliRM = new -$$Lambda$tk_DnKVUgqiew4TUrNAQUHqliRM(eCarXCarVfmiscManager3);
/* 316 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iValueTaskBuild26.onSetFunctionValue(-$$Lambda$tk_DnKVUgqiew4TUrNAQUHqliRM, pairs11);
/*     */     
/* 318 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild18.useValuePAByIntBase(33675, pairs3); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q20 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */     
/* 320 */     iFilterCallback2.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q20);
/*     */ 
/*     */ 
/*     */     
/* 324 */     Pairs pairs2 = Pairs.of(Integer.valueOf(570688001), Integer.valueOf(0));
/* 325 */     pairs2 = pairs2.add(Integer.valueOf(570688002), Integer.valueOf(1));
/* 326 */     Pairs pairs10 = pairs2.add(Integer.valueOf(570688003), Integer.valueOf(2));
/* 327 */     pairs2 = pairs10.reverse();
/* 328 */     IVehicleFunction iVehicleFunction22 = VehicleFunction.intFunction(570688000); int[] arrayOfInt18 = COMMON_ON_OFF;
/* 329 */     iVehicleFunction22 = iVehicleFunction22.supportedFunctionValue(arrayOfInt18);
/* 330 */     IVehicleFunction.IZone iZone17 = iVehicleFunction22.createZone(new int[] { Integer.MIN_VALUE });
/* 331 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iZone17.useStatusPAByIntBase(33676); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$kV_feDGKi4mHjxi_Ei1rA5IrZ8M -$$Lambda$kV_feDGKi4mHjxi_Ei1rA5IrZ8M = new -$$Lambda$kV_feDGKi4mHjxi_Ei1rA5IrZ8M(eCarXCarVfmiscManager2);
/* 332 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$kV_feDGKi4mHjxi_Ei1rA5IrZ8M, pairs10);
/*     */     
/* 334 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild17.useValuePAByIntBase(33676, pairs2); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q19 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/*     */     
/* 336 */     iFilterCallback1.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q19);
/*     */ 
/*     */     
/* 339 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2));
/* 340 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/* 341 */     IVehicleFunction iVehicleFunction21 = VehicleFunction.intFunction(570688256); int[] arrayOfInt15 = COMMON_ON_OFF;
/* 342 */     IVehicleFunction iVehicleFunction20 = iVehicleFunction21.supportedFunctionValue(arrayOfInt15);
/* 343 */     IVehicleFunction.IZone iZone16 = iVehicleFunction20.createZone(new int[] { Integer.MIN_VALUE });
/* 344 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iZone16.useStatusPAByIntBase(33641); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$a4u__05mFuDRfrfaE9SI3z65Icc -$$Lambda$a4u__05mFuDRfrfaE9SI3z65Icc = new -$$Lambda$a4u__05mFuDRfrfaE9SI3z65Icc(eCarXCarVfmiscManager1);
/* 345 */     iValueTaskBuild16 = iValueTaskBuild16.onSetFunctionValue(-$$Lambda$a4u__05mFuDRfrfaE9SI3z65Icc, pairs1);
/* 346 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild16.useValuePAByIntBase(33641, pairs1.reverse()); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q6 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 347 */     iFilterCallback7.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q6);
/*     */     
/* 349 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(570491137); int[] arrayOfInt14 = COMMON_ON_OFF;
/* 350 */     iVehicleFunction14 = iVehicleFunction14.supportedFunctionValue(arrayOfInt14);
/* 351 */     IVehicleFunction.IZone iZone14 = iVehicleFunction14.createZone(new int[] { Integer.MIN_VALUE });
/* 352 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone14.useStatusPAByIntBase(33439); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q18 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 353 */     iValueTaskBuild9.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q18);
/*     */     
/* 355 */     IVehicleFunction iVehicleFunction19 = VehicleFunction.intFunction(570491138); int[] arrayOfInt5 = COMMON_ON_OFF;
/* 356 */     IVehicleFunction iVehicleFunction13 = iVehicleFunction19.supportedFunctionValue(arrayOfInt5);
/* 357 */     IVehicleFunction.IZone iZone13 = iVehicleFunction13.createZone(new int[] { Integer.MIN_VALUE });
/* 358 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone13.useStatusPAByIntBase(33440); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q5 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 359 */     iValueTaskBuild15.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q5);
/*     */     
/* 361 */     IVehicleFunction iVehicleFunction18 = VehicleFunction.intFunction(570491139); int[] arrayOfInt4 = COMMON_ON_OFF;
/* 362 */     IVehicleFunction iVehicleFunction12 = iVehicleFunction18.supportedFunctionValue(arrayOfInt4);
/* 363 */     IVehicleFunction.IZone iZone12 = iVehicleFunction12.createZone(new int[] { Integer.MIN_VALUE });
/* 364 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone12.useStatusPAByIntBase(33441); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q17 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 365 */     iValueTaskBuild8.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q17);
/*     */     
/* 367 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(570491155); int[] arrayOfInt13 = COMMON_ON_OFF;
/* 368 */     iVehicleFunction11 = iVehicleFunction11.supportedFunctionValue(arrayOfInt13);
/* 369 */     IVehicleFunction.IZone iZone11 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE });
/* 370 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone11.useStatusPAByIntBase(33443); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q16 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 371 */     iValueTaskBuild7.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q16);
/*     */     
/* 373 */     IVehicleFunction iVehicleFunction17 = VehicleFunction.intFunction(570491158); int[] arrayOfInt3 = COMMON_ON_OFF;
/* 374 */     IVehicleFunction iVehicleFunction10 = iVehicleFunction17.supportedFunctionValue(arrayOfInt3);
/* 375 */     IVehicleFunction.IZone iZone10 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE });
/* 376 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone10.useStatusPAByIntBase(33465); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q15 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 377 */     iValueTaskBuild6.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q15);
/*     */     
/* 379 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(570491151); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 380 */     IVehicleFunction iVehicleFunction9 = iVehicleFunction16.supportedFunctionValue(arrayOfInt2);
/* 381 */     IVehicleFunction.IZone iZone9 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE });
/* 382 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone9.useStatusPAByIntBase(33445); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q14 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 383 */     iValueTaskBuild5.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q14);
/*     */     
/* 385 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(570491149); int[] arrayOfInt12 = COMMON_ON_OFF;
/* 386 */     iVehicleFunction8 = iVehicleFunction8.supportedFunctionValue(arrayOfInt12);
/* 387 */     IVehicleFunction.IZone iZone8 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/* 388 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone8.useStatusPAByIntBase(33450); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q13 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 389 */     iValueTaskBuild4.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q13);
/*     */     
/* 391 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(570491200); int[] arrayOfInt11 = COMMON_ON_OFF;
/* 392 */     iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(arrayOfInt11);
/* 393 */     IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/* 394 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone7.useStatusPAByIntBase(33442); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q4 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 395 */     iValueTaskBuild14.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q4);
/*     */     
/* 397 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(570491143); int[] arrayOfInt10 = COMMON_ON_OFF;
/* 398 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(arrayOfInt10);
/* 399 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/* 400 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone6.useStatusPAByIntBase(33447); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q3 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 401 */     iValueTaskBuild13.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q3);
/*     */     
/* 403 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.intFunction(570491146); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 404 */     IVehicleFunction iVehicleFunction5 = iVehicleFunction15.supportedFunctionValue(arrayOfInt1);
/* 405 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 406 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone5.useStatusPAByIntBase(33451); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q2 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 407 */     iValueTaskBuild12.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q2);
/*     */     
/* 409 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(570491142); int[] arrayOfInt9 = COMMON_ON_OFF;
/* 410 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(arrayOfInt9);
/* 411 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 412 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone4.useStatusPAByIntBase(33446); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q1 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 413 */     iValueTaskBuild11.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q1);
/*     */     
/* 415 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(570491144); int[] arrayOfInt8 = COMMON_ON_OFF;
/* 416 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(arrayOfInt8);
/* 417 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/* 418 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone3.useStatusPAByIntBase(33448); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q12 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 419 */     iValueTaskBuild3.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q12);
/*     */     
/* 421 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(570491147); int[] arrayOfInt7 = COMMON_ON_OFF;
/* 422 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(arrayOfInt7);
/* 423 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/* 424 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone2.useStatusPAByIntBase(33452); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q11 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 425 */     iValueTaskBuild2.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q11);
/*     */     
/* 427 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(570491145); int[] arrayOfInt6 = COMMON_ON_OFF;
/* 428 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(arrayOfInt6);
/* 429 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/* 430 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useStatusPAByIntBase(33449); -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q10 = new -$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q(this);
/* 431 */     iValueTaskBuild1.addTo(-$$Lambda$DriveMode$XtZaMLcq1wda9ONWKTKzaWX_D_Q10);
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
/*     */   private int convertToDrvModAdapt(int paramInt) {
/* 447 */     char c = 'ÿ';
/*     */     
/* 449 */     switch (paramInt) { default: paramInt = c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 496 */         return paramInt;case 14: paramInt = 570491147; return paramInt;case 13: paramInt = 570491146; return paramInt;case 12: paramInt = 570491149; return paramInt;case 11: paramInt = 570491145; return paramInt;case 10: paramInt = 570491144; return paramInt;case 9: paramInt = 570491143; return paramInt;case 8: paramInt = 570491142; return paramInt;case 7: paramInt = 570491157; return paramInt;case 6: paramInt = 570491158; return paramInt;case 5: paramInt = 570491155; return paramInt;case 4: paramInt = 570491200; return paramInt;case 3: paramInt = 570491139; return paramInt;case 2: paramInt = 570491138; return paramInt;case 1: break; }  paramInt = 570491137; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] getSupportedDriveMode() {
/* 505 */     LinkedList<Integer> linkedList = new LinkedList();
/* 506 */     for (byte b = 0; b < DRIVE_MODE_ALL.length; b++) {
/* 507 */       FunctionStatus functionStatus = getFunctionStatus(DRIVE_MODE_ALL[b]);
/* 508 */       if (functionStatus != FunctionStatus.notavailable) {
/* 509 */         linkedList.add(Integer.valueOf(convertToDrvModAdapt(DRIVE_MODE_VALUES[b])));
/*     */       }
/*     */     } 
/*     */     
/* 513 */     return linkedList.stream().mapToInt(-$$Lambda$DriveMode$gfCssnBJI7TKfXb_Jmv7raVYNkY.INSTANCE).toArray();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\DriveMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */