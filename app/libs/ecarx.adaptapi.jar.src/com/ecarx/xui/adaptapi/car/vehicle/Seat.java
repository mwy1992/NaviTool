/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarProfileManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSeatctrlManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
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
/*     */ public class Seat
/*     */   extends AbsCarFunction
/*     */   implements ISeat
/*     */ {
/*     */   private ECarXCarProfileManager mECarXCarProfileManager;
/*     */   private ECarXCarSeatctrlManager mECarXCarSeatclimateManager;
/*     */   
/*     */   protected Seat(Context paramContext) {
/*  31 */     super(paramContext, 754974720);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  36 */     this.mECarXCarSeatclimateManager = this.mECarXCarSetManager.getECarXCarSeatctrlManager();
/*  37 */     this.mECarXCarProfileManager = this.mECarXCarSetManager.getECarXCarProfileManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  44 */     Pairs pairs7 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  45 */     pairs7 = pairs7.add(Integer.valueOf(1), Integer.valueOf(1));
/*     */ 
/*     */     
/*  48 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.intFunction(538378496);
/*  49 */     iVehicleFunction13 = iVehicleFunction13.supportedFunctionValue(new int[] { 0, 1 });
/*     */ 
/*     */     
/*  52 */     IVehicleFunction.IZone iZone10 = iVehicleFunction13.createZone(new int[] { 1 });
/*  53 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iZone10.useStatusPAByIntBase(33590); ECarXCarSeatctrlManager eCarXCarSeatctrlManager5 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager5); -$$Lambda$lXKhXH0eGwR4UKZFyS0wfhGVxVg -$$Lambda$lXKhXH0eGwR4UKZFyS0wfhGVxVg = new -$$Lambda$lXKhXH0eGwR4UKZFyS0wfhGVxVg(eCarXCarSeatctrlManager5);
/*  54 */     iValueTaskBuild21 = iValueTaskBuild21.onSetFunctionValue(-$$Lambda$lXKhXH0eGwR4UKZFyS0wfhGVxVg, pairs7);
/*     */ 
/*     */     
/*  57 */     Pairs pairs22 = pairs7.reverse(); IVehicleFunction.IFilterCallback iFilterCallback38 = iValueTaskBuild21.useValuePAByIntBase(33591, pairs22); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU14 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*  58 */     iFilterCallback38.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU14);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     Pairs pairs18 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  69 */     pairs18 = pairs18.add(Integer.valueOf(755106049), Integer.valueOf(1));
/*  70 */     pairs18 = pairs18.add(Integer.valueOf(755106050), Integer.valueOf(2));
/*  71 */     IVehicleFunction iVehicleFunction21 = VehicleFunction.intFunction(755106048);
/*  72 */     iVehicleFunction21 = iVehicleFunction21.supportedFunctionValue(new int[] { 0, 755106049, 755106050 });
/*     */ 
/*     */ 
/*     */     
/*  76 */     IVehicleFunction.IZone iZone40 = iVehicleFunction21.createZone(new int[] { 1 });
/*  77 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild50 = iZone40.useStatusPAByIntBase(33574); ECarXCarSeatctrlManager eCarXCarSeatctrlManager25 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager25); -$$Lambda$2M3b5pQq_U5Yjj2aH9ZUsoSb9NU -$$Lambda$2M3b5pQq_U5Yjj2aH9ZUsoSb9NU = new -$$Lambda$2M3b5pQq_U5Yjj2aH9ZUsoSb9NU(eCarXCarSeatctrlManager25);
/*  78 */     iValueTaskBuild50 = iValueTaskBuild50.onSetFunctionValue(-$$Lambda$2M3b5pQq_U5Yjj2aH9ZUsoSb9NU, pairs18);
/*     */ 
/*     */     
/*  81 */     Pairs pairs29 = pairs18.reverse(); IVehicleFunction.IFilterCallback iFilterCallback37 = iValueTaskBuild50.useValuePAByIntBase(33575, pairs29);
/*  82 */     IVehicleFunction.IZone iZone39 = iFilterCallback37.createZone(new int[] { 4 });
/*  83 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild49 = iZone39.useStatusPAByIntBase(33576); ECarXCarSeatctrlManager eCarXCarSeatctrlManager24 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager24); -$$Lambda$meWvbXgreM2KwHvOAdDNOn-N7Zk -$$Lambda$meWvbXgreM2KwHvOAdDNOn-N7Zk = new -$$Lambda$meWvbXgreM2KwHvOAdDNOn-N7Zk(eCarXCarSeatctrlManager24);
/*  84 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild54 = iValueTaskBuild49.onSetFunctionValue(-$$Lambda$meWvbXgreM2KwHvOAdDNOn-N7Zk, pairs18);
/*     */ 
/*     */     
/*  87 */     Pairs pairs21 = pairs18.reverse(); IVehicleFunction.IFilterCallback iFilterCallback36 = iValueTaskBuild54.useValuePAByIntBase(33577, pairs21);
/*  88 */     IVehicleFunction.IZone iZone38 = iFilterCallback36.createZone(new int[] { 16 });
/*  89 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild48 = iZone38.useStatusPAByIntBase(33622); ECarXCarSeatctrlManager eCarXCarSeatctrlManager23 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager23); -$$Lambda$REUmSp3AZaN8jZ6G2y38Uy62utA -$$Lambda$REUmSp3AZaN8jZ6G2y38Uy62utA = new -$$Lambda$REUmSp3AZaN8jZ6G2y38Uy62utA(eCarXCarSeatctrlManager23);
/*     */     
/*  91 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild53 = iValueTaskBuild48.onSetFunctionValue(-$$Lambda$REUmSp3AZaN8jZ6G2y38Uy62utA, pairs18);
/*     */ 
/*     */ 
/*     */     
/*  95 */     Pairs pairs20 = pairs18.reverse(); IVehicleFunction.IFilterCallback iFilterCallback35 = iValueTaskBuild53.useValuePAByIntBase(33623, pairs20);
/*  96 */     IVehicleFunction.IZone iZone37 = iFilterCallback35.createZone(new int[] { 64 });
/*  97 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild47 = iZone37.useStatusPAByIntBase(33624); ECarXCarSeatctrlManager eCarXCarSeatctrlManager22 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager22); -$$Lambda$ZfCDKItXDNONIiBHw11jMlXdLWw -$$Lambda$ZfCDKItXDNONIiBHw11jMlXdLWw = new -$$Lambda$ZfCDKItXDNONIiBHw11jMlXdLWw(eCarXCarSeatctrlManager22);
/*     */     
/*  99 */     iValueTaskBuild47 = iValueTaskBuild47.onSetFunctionValue(-$$Lambda$ZfCDKItXDNONIiBHw11jMlXdLWw, pairs18);
/*     */ 
/*     */ 
/*     */     
/* 103 */     pairs18 = pairs18.reverse(); IVehicleFunction.IFilterCallback iFilterCallback34 = iValueTaskBuild47.useValuePAByIntBase(33625, pairs18); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU13 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 104 */     iFilterCallback34.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU13);
/*     */ 
/*     */ 
/*     */     
/* 108 */     Pairs pairs17 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 109 */     pairs17 = pairs17.add(Integer.valueOf(755106305), Integer.valueOf(1));
/* 110 */     pairs17 = pairs17.add(Integer.valueOf(755106306), Integer.valueOf(2));
/* 111 */     IVehicleFunction iVehicleFunction20 = VehicleFunction.intFunction(755106304);
/* 112 */     iVehicleFunction20 = iVehicleFunction20.supportedFunctionValue(new int[] { 0, 755106305, 755106306 });
/*     */ 
/*     */ 
/*     */     
/* 116 */     IVehicleFunction.IZone iZone36 = iVehicleFunction20.createZone(new int[] { 1 });
/* 117 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild46 = iZone36.useStatusPAByIntBase(33578); ECarXCarSeatctrlManager eCarXCarSeatctrlManager21 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager21); -$$Lambda$ml6SFPq85Fv9O6zcdHe2YRvJwlo -$$Lambda$ml6SFPq85Fv9O6zcdHe2YRvJwlo = new -$$Lambda$ml6SFPq85Fv9O6zcdHe2YRvJwlo(eCarXCarSeatctrlManager21);
/* 118 */     iValueTaskBuild46 = iValueTaskBuild46.onSetFunctionValue(-$$Lambda$ml6SFPq85Fv9O6zcdHe2YRvJwlo, pairs17);
/*     */ 
/*     */     
/* 121 */     Pairs pairs28 = pairs17.reverse(); IVehicleFunction.IFilterCallback iFilterCallback33 = iValueTaskBuild46.useValuePAByIntBase(33579, pairs28);
/* 122 */     IVehicleFunction.IZone iZone35 = iFilterCallback33.createZone(new int[] { 4 });
/* 123 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild45 = iZone35.useStatusPAByIntBase(33580); ECarXCarSeatctrlManager eCarXCarSeatctrlManager20 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager20); -$$Lambda$f2u4A47x0sij-_3_gDILzjNQm3A -$$Lambda$f2u4A47x0sij-_3_gDILzjNQm3A = new -$$Lambda$f2u4A47x0sij-_3_gDILzjNQm3A(eCarXCarSeatctrlManager20);
/* 124 */     iValueTaskBuild45 = iValueTaskBuild45.onSetFunctionValue(-$$Lambda$f2u4A47x0sij-_3_gDILzjNQm3A, pairs17);
/*     */ 
/*     */     
/* 127 */     pairs17 = pairs17.reverse(); IVehicleFunction.IFilterCallback iFilterCallback24 = iValueTaskBuild45.useValuePAByIntBase(33581, pairs17); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU18 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 128 */     iFilterCallback24.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU18);
/*     */ 
/*     */     
/* 131 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.customFunction(755106560);
/* 132 */     IVehicleFunction.IZone iZone34 = iVehicleFunction12.createZone(new int[] { 1 }); FunctionStatus functionStatus12 = FunctionStatus.active;
/* 133 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild44 = iZone34.fixStatus(functionStatus12); -$$Lambda$Seat$X5wYFyETRbQLZP9LTmVYkJCkosQ -$$Lambda$Seat$X5wYFyETRbQLZP9LTmVYkJCkosQ = -$$Lambda$Seat$X5wYFyETRbQLZP9LTmVYkJCkosQ.INSTANCE;
/* 134 */     IVehicleFunction.IFilterCallback iFilterCallback23 = iValueTaskBuild44.useValueSignal(30559, -$$Lambda$Seat$X5wYFyETRbQLZP9LTmVYkJCkosQ);
/*     */     
/* 136 */     IVehicleFunction.IZone iZone9 = iFilterCallback23.createZone(new int[] { 4 }); FunctionStatus functionStatus17 = FunctionStatus.active;
/* 137 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild43 = iZone9.fixStatus(functionStatus17); -$$Lambda$Seat$KTWVh2SEY6INigQLei3_Eck-SmQ -$$Lambda$Seat$KTWVh2SEY6INigQLei3_Eck-SmQ = -$$Lambda$Seat$KTWVh2SEY6INigQLei3_Eck-SmQ.INSTANCE;
/* 138 */     IVehicleFunction.IFilterCallback iFilterCallback22 = iValueTaskBuild43.useValueSignal(30652, -$$Lambda$Seat$KTWVh2SEY6INigQLei3_Eck-SmQ); -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk4 = new -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk(this);
/*     */     
/* 140 */     iFilterCallback22.addTo(-$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk4);
/*     */ 
/*     */     
/* 143 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.customFunction(755106816);
/* 144 */     IVehicleFunction.IZone iZone33 = iVehicleFunction11.createZone(new int[] { 1 }); FunctionStatus functionStatus11 = FunctionStatus.active;
/* 145 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iZone33.fixStatus(functionStatus11); -$$Lambda$Seat$4_NjlxteX-f1jlurFLfFJ0jrwSU -$$Lambda$Seat$4_NjlxteX-f1jlurFLfFJ0jrwSU = -$$Lambda$Seat$4_NjlxteX-f1jlurFLfFJ0jrwSU.INSTANCE;
/* 146 */     IVehicleFunction.IFilterCallback iFilterCallback21 = iValueTaskBuild20.useValueSignal(30557, -$$Lambda$Seat$4_NjlxteX-f1jlurFLfFJ0jrwSU);
/*     */     
/* 148 */     IVehicleFunction.IZone iZone32 = iFilterCallback21.createZone(new int[] { 4 }); FunctionStatus functionStatus10 = FunctionStatus.active;
/* 149 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild42 = iZone32.fixStatus(functionStatus10); -$$Lambda$Seat$pFZ2_vwwazw9AP8tv6X-jMOf1T8 -$$Lambda$Seat$pFZ2_vwwazw9AP8tv6X-jMOf1T8 = -$$Lambda$Seat$pFZ2_vwwazw9AP8tv6X-jMOf1T8.INSTANCE;
/* 150 */     IVehicleFunction.IFilterCallback iFilterCallback20 = iValueTaskBuild42.useValueSignal(30650, -$$Lambda$Seat$pFZ2_vwwazw9AP8tv6X-jMOf1T8); -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk3 = new -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk(this);
/*     */     
/* 152 */     iFilterCallback20.addTo(-$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk3);
/*     */ 
/*     */ 
/*     */     
/* 156 */     Pairs pairs16 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 157 */     pairs16 = pairs16.add(Integer.valueOf(755171585), Integer.valueOf(1));
/* 158 */     pairs16 = pairs16.add(Integer.valueOf(755171586), Integer.valueOf(2));
/* 159 */     IVehicleFunction iVehicleFunction19 = VehicleFunction.intFunction(755171584);
/* 160 */     iVehicleFunction19 = iVehicleFunction19.supportedFunctionValue(new int[] { 0, 755171585, 755171586 });
/*     */ 
/*     */ 
/*     */     
/* 164 */     IVehicleFunction.IZone iZone31 = iVehicleFunction19.createZone(new int[] { 1 });
/* 165 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild41 = iZone31.useStatusPAByIntBase(33582); ECarXCarSeatctrlManager eCarXCarSeatctrlManager19 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager19); -$$Lambda$hf13QDpj_JPs94AYCIeC-Tus6Bg -$$Lambda$hf13QDpj_JPs94AYCIeC-Tus6Bg = new -$$Lambda$hf13QDpj_JPs94AYCIeC-Tus6Bg(eCarXCarSeatctrlManager19);
/*     */     
/* 167 */     iValueTaskBuild41 = iValueTaskBuild41.onSetFunctionValue(-$$Lambda$hf13QDpj_JPs94AYCIeC-Tus6Bg, pairs16);
/*     */ 
/*     */     
/* 170 */     Pairs pairs27 = pairs16.reverse(); IVehicleFunction.IFilterCallback iFilterCallback32 = iValueTaskBuild41.useValuePAByIntBase(33583, pairs27);
/* 171 */     IVehicleFunction.IZone iZone30 = iFilterCallback32.createZone(new int[] { 4 });
/* 172 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild40 = iZone30.useStatusPAByIntBase(33584); ECarXCarSeatctrlManager eCarXCarSeatctrlManager18 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager18); -$$Lambda$x0HM3eQqixhAjPk29UResVzmsAQ -$$Lambda$x0HM3eQqixhAjPk29UResVzmsAQ = new -$$Lambda$x0HM3eQqixhAjPk29UResVzmsAQ(eCarXCarSeatctrlManager18);
/*     */     
/* 174 */     iValueTaskBuild40 = iValueTaskBuild40.onSetFunctionValue(-$$Lambda$x0HM3eQqixhAjPk29UResVzmsAQ, pairs16);
/*     */ 
/*     */     
/* 177 */     pairs16 = pairs16.reverse(); IVehicleFunction.IFilterCallback iFilterCallback31 = iValueTaskBuild40.useValuePAByIntBase(33585, pairs16); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU12 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 178 */     iFilterCallback31.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU12);
/*     */ 
/*     */ 
/*     */     
/* 182 */     Pairs pairs15 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 183 */     pairs15 = pairs15.add(Integer.valueOf(755171841), Integer.valueOf(1));
/* 184 */     Pairs pairs19 = pairs15.add(Integer.valueOf(755171842), Integer.valueOf(2));
/*     */     
/* 186 */     pairs15 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 187 */     pairs15 = pairs15.add(Integer.valueOf(755171841), Integer.valueOf(1));
/* 188 */     pairs15 = pairs15.add(Integer.valueOf(755171842), Integer.valueOf(2));
/* 189 */     IVehicleFunction iVehicleFunction22 = VehicleFunction.intFunction(755171840);
/* 190 */     iVehicleFunction22 = iVehicleFunction22.supportedFunctionValue(new int[] { 0, 755171841, 755171842 });
/*     */ 
/*     */ 
/*     */     
/* 194 */     IVehicleFunction.IZone iZone42 = iVehicleFunction22.createZone(new int[] { 1 });
/* 195 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild52 = iZone42.useStatusPAByIntBase(33586); ECarXCarSeatctrlManager eCarXCarSeatctrlManager27 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager27); -$$Lambda$LPioFyTm8y265FfjnFvic4p8qEc -$$Lambda$LPioFyTm8y265FfjnFvic4p8qEc = new -$$Lambda$LPioFyTm8y265FfjnFvic4p8qEc(eCarXCarSeatctrlManager27);
/* 196 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild55 = iValueTaskBuild52.onSetFunctionValue(-$$Lambda$LPioFyTm8y265FfjnFvic4p8qEc, pairs19);
/*     */ 
/*     */     
/* 199 */     Pairs pairs26 = pairs15.reverse(); IVehicleFunction.IFilterCallback iFilterCallback44 = iValueTaskBuild55.useValuePAByIntBase(33587, pairs26);
/* 200 */     IVehicleFunction.IZone iZone41 = iFilterCallback44.createZone(new int[] { 4 });
/* 201 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild51 = iZone41.useStatusPAByIntBase(33588); ECarXCarSeatctrlManager eCarXCarSeatctrlManager26 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager26); -$$Lambda$ZFO3t8pIlTOvwJaEgcbMsJSJLRM -$$Lambda$ZFO3t8pIlTOvwJaEgcbMsJSJLRM = new -$$Lambda$ZFO3t8pIlTOvwJaEgcbMsJSJLRM(eCarXCarSeatctrlManager26);
/* 202 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild39 = iValueTaskBuild51.onSetFunctionValue(-$$Lambda$ZFO3t8pIlTOvwJaEgcbMsJSJLRM, pairs19);
/*     */ 
/*     */     
/* 205 */     Pairs pairs25 = pairs15.reverse(); IVehicleFunction.IFilterCallback iFilterCallback30 = iValueTaskBuild39.useValuePAByIntBase(33589, pairs25);
/* 206 */     IVehicleFunction.IZone iZone29 = iFilterCallback30.createZone(new int[] { 16 });
/* 207 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild38 = iZone29.useStatusPAByIntBase(33626); ECarXCarSeatctrlManager eCarXCarSeatctrlManager17 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager17); -$$Lambda$LU7XXdwDrLebQnISecOgolH8igc -$$Lambda$LU7XXdwDrLebQnISecOgolH8igc = new -$$Lambda$LU7XXdwDrLebQnISecOgolH8igc(eCarXCarSeatctrlManager17);
/*     */     
/* 209 */     iValueTaskBuild38 = iValueTaskBuild38.onSetFunctionValue(-$$Lambda$LU7XXdwDrLebQnISecOgolH8igc, pairs15);
/*     */ 
/*     */ 
/*     */     
/* 213 */     Pairs pairs24 = pairs15.reverse(); IVehicleFunction.IFilterCallback iFilterCallback29 = iValueTaskBuild38.useValuePAByIntBase(33628, pairs24);
/* 214 */     IVehicleFunction.IZone iZone28 = iFilterCallback29.createZone(new int[] { 64 });
/* 215 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild37 = iZone28.useStatusPAByIntBase(33627); ECarXCarSeatctrlManager eCarXCarSeatctrlManager16 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager16); -$$Lambda$fS_I6UoWbaMxk8bkeTlz_5O4JHw -$$Lambda$fS_I6UoWbaMxk8bkeTlz_5O4JHw = new -$$Lambda$fS_I6UoWbaMxk8bkeTlz_5O4JHw(eCarXCarSeatctrlManager16);
/*     */     
/* 217 */     iValueTaskBuild37 = iValueTaskBuild37.onSetFunctionValue(-$$Lambda$fS_I6UoWbaMxk8bkeTlz_5O4JHw, pairs15);
/*     */ 
/*     */ 
/*     */     
/* 221 */     pairs15 = pairs15.reverse(); IVehicleFunction.IFilterCallback iFilterCallback19 = iValueTaskBuild37.useValuePAByIntBase(33629, pairs15); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU17 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 222 */     iFilterCallback19.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU17);
/*     */ 
/*     */     
/* 225 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.customFunction(755172096);
/* 226 */     IVehicleFunction.IZone iZone27 = iVehicleFunction10.createZone(new int[] { 1 }); FunctionStatus functionStatus9 = FunctionStatus.active;
/* 227 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iZone27.fixStatus(functionStatus9); -$$Lambda$Seat$-0ZBUi4ZUvZu4V2sYzwM0-QaolY -$$Lambda$Seat$-0ZBUi4ZUvZu4V2sYzwM0-QaolY = -$$Lambda$Seat$-0ZBUi4ZUvZu4V2sYzwM0-QaolY.INSTANCE;
/* 228 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild19.useValueSignal(30555, -$$Lambda$Seat$-0ZBUi4ZUvZu4V2sYzwM0-QaolY);
/*     */     
/* 230 */     IVehicleFunction.IZone iZone26 = iFilterCallback18.createZone(new int[] { 4 }); FunctionStatus functionStatus8 = FunctionStatus.active;
/* 231 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild36 = iZone26.fixStatus(functionStatus8); -$$Lambda$Seat$Z9VZdnoqS3JDPBeAoGaSGb5BQ0E -$$Lambda$Seat$Z9VZdnoqS3JDPBeAoGaSGb5BQ0E = -$$Lambda$Seat$Z9VZdnoqS3JDPBeAoGaSGb5BQ0E.INSTANCE;
/* 232 */     IVehicleFunction.IFilterCallback iFilterCallback28 = iValueTaskBuild36.useValueSignal(30648, -$$Lambda$Seat$Z9VZdnoqS3JDPBeAoGaSGb5BQ0E); -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk1 = new -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk(this);
/*     */     
/* 234 */     iFilterCallback28.addTo(-$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk1);
/*     */ 
/*     */     
/* 237 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.customFunction(755172352);
/* 238 */     IVehicleFunction.IZone iZone8 = iVehicleFunction9.createZone(new int[] { 1 }); FunctionStatus functionStatus16 = FunctionStatus.active;
/* 239 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild35 = iZone8.fixStatus(functionStatus16); -$$Lambda$Seat$bWVC3AghWiT_3p-yoJXjir-5GCg -$$Lambda$Seat$bWVC3AghWiT_3p-yoJXjir-5GCg = -$$Lambda$Seat$bWVC3AghWiT_3p-yoJXjir-5GCg.INSTANCE;
/* 240 */     IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild35.useValueSignal(30484, -$$Lambda$Seat$bWVC3AghWiT_3p-yoJXjir-5GCg);
/*     */     
/* 242 */     IVehicleFunction.IZone iZone25 = iFilterCallback17.createZone(new int[] { 4 }); FunctionStatus functionStatus7 = FunctionStatus.active;
/* 243 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild34 = iZone25.fixStatus(functionStatus7); -$$Lambda$Seat$9ks0aOcoY6vH-WP8x6qrw6TZd28 -$$Lambda$Seat$9ks0aOcoY6vH-WP8x6qrw6TZd28 = -$$Lambda$Seat$9ks0aOcoY6vH-WP8x6qrw6TZd28.INSTANCE;
/* 244 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild34.useValueSignal(30485, -$$Lambda$Seat$9ks0aOcoY6vH-WP8x6qrw6TZd28); -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk2 = new -$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk(this);
/*     */     
/* 246 */     iFilterCallback16.addTo(-$$Lambda$Seat$0F334e2LrZy-Rx9HCLbrstAOZMk2);
/*     */ 
/*     */ 
/*     */     
/* 250 */     Pairs pairs14 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 251 */     pairs14 = pairs14.add(Integer.valueOf(1), Integer.valueOf(755237121));
/* 252 */     pairs14 = pairs14.add(Integer.valueOf(2), Integer.valueOf(755237122));
/* 253 */     IVehicleFunction iVehicleFunction18 = VehicleFunction.intFunction(755237120);
/* 254 */     iVehicleFunction18 = iVehicleFunction18.supportedFunctionValue(new int[] { 0, 755237121, 755237122 });
/*     */ 
/*     */ 
/*     */     
/* 258 */     IVehicleFunction.IZone iZone24 = iVehicleFunction18.createZone(new int[] { 1 });
/* 259 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild33 = iZone24.useStatusPAByIntBase(33604); ECarXCarSeatctrlManager eCarXCarSeatctrlManager15 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager15); -$$Lambda$02HCpbgcilKWpKxn-FU1cf5XUQA -$$Lambda$02HCpbgcilKWpKxn-FU1cf5XUQA = new -$$Lambda$02HCpbgcilKWpKxn-FU1cf5XUQA(eCarXCarSeatctrlManager15);
/*     */ 
/*     */     
/* 262 */     Pairs pairs23 = pairs14.reverse(); iValueTaskBuild33 = iValueTaskBuild33.onSetFunctionValue(-$$Lambda$02HCpbgcilKWpKxn-FU1cf5XUQA, pairs23);
/* 263 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue7 = iValueTaskBuild33.useValueSignals(new int[] { 33594, 33592 }); -$$Lambda$Seat$LlV_wzn82zWDlBwMcoqH0dOSCgI -$$Lambda$Seat$LlV_wzn82zWDlBwMcoqH0dOSCgI = new -$$Lambda$Seat$LlV_wzn82zWDlBwMcoqH0dOSCgI(this);
/*     */ 
/*     */ 
/*     */     
/* 267 */     IVehicleFunction.IFilterCallback iFilterCallback43 = iMultiSignalValue7.onValueSignalChanged(33594, -$$Lambda$Seat$LlV_wzn82zWDlBwMcoqH0dOSCgI); -$$Lambda$Seat$hFM3HIak1SXoC-AD9yn-KLAdCEg -$$Lambda$Seat$hFM3HIak1SXoC-AD9yn-KLAdCEg = new -$$Lambda$Seat$hFM3HIak1SXoC-AD9yn-KLAdCEg(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     IVehicleFunction.ITaskEnd iTaskEnd12 = iFilterCallback43.filterValue(-$$Lambda$Seat$hFM3HIak1SXoC-AD9yn-KLAdCEg);
/*     */ 
/*     */     
/* 277 */     IVehicleFunction.IZone iZone23 = iTaskEnd12.createZone(new int[] { 4 });
/* 278 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild32 = iZone23.useStatusPAByIntBase(33605); ECarXCarSeatctrlManager eCarXCarSeatctrlManager14 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager14); -$$Lambda$6TeI9_LDm7gApA0hHT7AWUpT5Ew -$$Lambda$6TeI9_LDm7gApA0hHT7AWUpT5Ew = new -$$Lambda$6TeI9_LDm7gApA0hHT7AWUpT5Ew(eCarXCarSeatctrlManager14);
/*     */ 
/*     */     
/* 281 */     pairs14 = pairs14.reverse(); IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iValueTaskBuild32.onSetFunctionValue(-$$Lambda$6TeI9_LDm7gApA0hHT7AWUpT5Ew, pairs14);
/* 282 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue1 = iValueTaskBuild18.useValueSignals(new int[] { 33596, 33593 }); -$$Lambda$Seat$PzkoF4XBeRWhLQn72KSVHKExVUQ -$$Lambda$Seat$PzkoF4XBeRWhLQn72KSVHKExVUQ = new -$$Lambda$Seat$PzkoF4XBeRWhLQn72KSVHKExVUQ(this);
/*     */ 
/*     */     
/* 285 */     IVehicleFunction.IFilterCallback iFilterCallback15 = iMultiSignalValue1.onValueSignalChanged(33596, -$$Lambda$Seat$PzkoF4XBeRWhLQn72KSVHKExVUQ); -$$Lambda$Seat$j2XPfNlwtleO-8cK80TfGkSyIpc -$$Lambda$Seat$j2XPfNlwtleO-8cK80TfGkSyIpc = new -$$Lambda$Seat$j2XPfNlwtleO-8cK80TfGkSyIpc(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     IVehicleFunction.ITaskEnd iTaskEnd4 = iFilterCallback15.filterValue(-$$Lambda$Seat$j2XPfNlwtleO-8cK80TfGkSyIpc); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU16 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 295 */     iTaskEnd4.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU16);
/*     */ 
/*     */     
/* 298 */     Pairs pairs13 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 299 */     pairs13 = pairs13.add(Integer.valueOf(755237377), Integer.valueOf(1)); pairs13 = pairs13.add(Integer.valueOf(755237378), Integer.valueOf(2));
/*     */     
/* 301 */     IVehicleFunction iVehicleFunction17 = VehicleFunction.intFunction(755237376);
/* 302 */     iVehicleFunction17 = iVehicleFunction17.supportedFunctionValue(new int[] { 0, 755237377, 755237378 });
/*     */ 
/*     */ 
/*     */     
/* 306 */     IVehicleFunction.IZone iZone22 = iVehicleFunction17.createZone(new int[] { 1 });
/* 307 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild31 = iZone22.useStatusPAByIntBase(33602); ECarXCarSeatctrlManager eCarXCarSeatctrlManager13 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager13); -$$Lambda$gMsxLmyqJW5uUWuoJS3s9fFmko0 -$$Lambda$gMsxLmyqJW5uUWuoJS3s9fFmko0 = new -$$Lambda$gMsxLmyqJW5uUWuoJS3s9fFmko0(eCarXCarSeatctrlManager13);
/*     */     
/* 309 */     iValueTaskBuild31 = iValueTaskBuild31.onSetFunctionValue(-$$Lambda$gMsxLmyqJW5uUWuoJS3s9fFmko0, pairs13);
/*     */ 
/*     */     
/* 312 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue10 = iValueTaskBuild31.useValueSignals(new int[] { 33592, 33595 }); -$$Lambda$Seat$TkaWX9jqgHnV-3jVmMSDh369zCk -$$Lambda$Seat$TkaWX9jqgHnV-3jVmMSDh369zCk = new -$$Lambda$Seat$TkaWX9jqgHnV-3jVmMSDh369zCk(this);
/*     */     
/* 314 */     IVehicleFunction.IFilterCallback iFilterCallback42 = iMultiSignalValue10.onValueSignalChanged(33595, -$$Lambda$Seat$TkaWX9jqgHnV-3jVmMSDh369zCk); -$$Lambda$Seat$2spzxYCDE8EP2wg4BeskTxdPrcA -$$Lambda$Seat$2spzxYCDE8EP2wg4BeskTxdPrcA = new -$$Lambda$Seat$2spzxYCDE8EP2wg4BeskTxdPrcA(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 321 */     IVehicleFunction.ITaskEnd iTaskEnd11 = iFilterCallback42.filterValue(-$$Lambda$Seat$2spzxYCDE8EP2wg4BeskTxdPrcA);
/*     */ 
/*     */     
/* 324 */     IVehicleFunction.IZone iZone21 = iTaskEnd11.createZone(new int[] { 4 });
/* 325 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iZone21.useStatusPAByIntBase(33603); ECarXCarSeatctrlManager eCarXCarSeatctrlManager12 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager12); -$$Lambda$wRWW5DYMTIB5yatwtqUyvWMmrW0 -$$Lambda$wRWW5DYMTIB5yatwtqUyvWMmrW0 = new -$$Lambda$wRWW5DYMTIB5yatwtqUyvWMmrW0(eCarXCarSeatctrlManager12);
/*     */     
/* 327 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iValueTaskBuild30.onSetFunctionValue(-$$Lambda$wRWW5DYMTIB5yatwtqUyvWMmrW0, pairs13);
/*     */ 
/*     */     
/* 330 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue6 = iValueTaskBuild17.useValueSignals(new int[] { 33593, 33597 }); -$$Lambda$Seat$8_bWKCMSxZI0qUttrHm5HOxw0Tk -$$Lambda$Seat$8_bWKCMSxZI0qUttrHm5HOxw0Tk = new -$$Lambda$Seat$8_bWKCMSxZI0qUttrHm5HOxw0Tk(this);
/*     */     
/* 332 */     IVehicleFunction.IFilterCallback iFilterCallback27 = iMultiSignalValue6.onValueSignalChanged(33597, -$$Lambda$Seat$8_bWKCMSxZI0qUttrHm5HOxw0Tk); -$$Lambda$Seat$avQV4yU7Mziw6XImLLcBNjAo6Js -$$Lambda$Seat$avQV4yU7Mziw6XImLLcBNjAo6Js = new -$$Lambda$Seat$avQV4yU7Mziw6XImLLcBNjAo6Js(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 339 */     IVehicleFunction.ITaskEnd iTaskEnd10 = iFilterCallback27.filterValue(-$$Lambda$Seat$avQV4yU7Mziw6XImLLcBNjAo6Js); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU11 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 342 */     iTaskEnd10.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU11);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     Pairs pairs12 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 359 */     pairs12 = pairs12.add(Integer.valueOf(755368193), Integer.valueOf(1));
/* 360 */     pairs12 = pairs12.add(Integer.valueOf(755368194), Integer.valueOf(2));
/* 361 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(755368192);
/* 362 */     iVehicleFunction16 = iVehicleFunction16.supportedFunctionValue(new int[] { 0, 755368193, 755368194 });
/*     */ 
/*     */ 
/*     */     
/* 366 */     IVehicleFunction.IZone iZone20 = iVehicleFunction16.createZone(new int[] { 1 });
/* 367 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iZone20.useStatusPAByIntBase(33599); ECarXCarSeatctrlManager eCarXCarSeatctrlManager11 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager11); -$$Lambda$jj4Ex0Qna0JI905ldakoB-D8FEM -$$Lambda$jj4Ex0Qna0JI905ldakoB-D8FEM = new -$$Lambda$jj4Ex0Qna0JI905ldakoB-D8FEM(eCarXCarSeatctrlManager11);
/*     */     
/* 369 */     iValueTaskBuild29 = iValueTaskBuild29.onSetFunctionValue(-$$Lambda$jj4Ex0Qna0JI905ldakoB-D8FEM, pairs12);
/*     */     
/* 371 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue9 = iValueTaskBuild29.useValueSignals(new int[] { 33592, 33594 }); -$$Lambda$Seat$4qJ9Ck5dSBDzt6Ps_zeNt0UpLQs -$$Lambda$Seat$4qJ9Ck5dSBDzt6Ps_zeNt0UpLQs = new -$$Lambda$Seat$4qJ9Ck5dSBDzt6Ps_zeNt0UpLQs(this);
/*     */     
/* 373 */     IVehicleFunction.IFilterCallback iFilterCallback41 = iMultiSignalValue9.onValueSignalChanged(33594, -$$Lambda$Seat$4qJ9Ck5dSBDzt6Ps_zeNt0UpLQs); -$$Lambda$Seat$vQEmSOjkaeTbEhM_OcvLLak9Erk -$$Lambda$Seat$vQEmSOjkaeTbEhM_OcvLLak9Erk = new -$$Lambda$Seat$vQEmSOjkaeTbEhM_OcvLLak9Erk(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 380 */     IVehicleFunction.ITaskEnd iTaskEnd9 = iFilterCallback41.filterValue(-$$Lambda$Seat$vQEmSOjkaeTbEhM_OcvLLak9Erk);
/*     */ 
/*     */     
/* 383 */     IVehicleFunction.IZone iZone19 = iTaskEnd9.createZone(new int[] { 4 });
/* 384 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iZone19.useStatusPAByIntBase(33601); ECarXCarSeatctrlManager eCarXCarSeatctrlManager10 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager10); -$$Lambda$vYcnbTeEzzAPdPTFyL9r34qOtdk -$$Lambda$vYcnbTeEzzAPdPTFyL9r34qOtdk = new -$$Lambda$vYcnbTeEzzAPdPTFyL9r34qOtdk(eCarXCarSeatctrlManager10);
/*     */     
/* 386 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iValueTaskBuild28.onSetFunctionValue(-$$Lambda$vYcnbTeEzzAPdPTFyL9r34qOtdk, pairs12);
/*     */     
/* 388 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue5 = iValueTaskBuild16.useValueSignals(new int[] { 33593, 33596 }); -$$Lambda$Seat$R9_G95hpnc5R3x1W6tgJSIFKm94 -$$Lambda$Seat$R9_G95hpnc5R3x1W6tgJSIFKm94 = new -$$Lambda$Seat$R9_G95hpnc5R3x1W6tgJSIFKm94(this);
/*     */     
/* 390 */     IVehicleFunction.IFilterCallback iFilterCallback26 = iMultiSignalValue5.onValueSignalChanged(33596, -$$Lambda$Seat$R9_G95hpnc5R3x1W6tgJSIFKm94); -$$Lambda$Seat$yZ4YERBg1NQWgrwaaSMnp5wmbkw -$$Lambda$Seat$yZ4YERBg1NQWgrwaaSMnp5wmbkw = new -$$Lambda$Seat$yZ4YERBg1NQWgrwaaSMnp5wmbkw(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     IVehicleFunction.ITaskEnd iTaskEnd8 = iFilterCallback26.filterValue(-$$Lambda$Seat$yZ4YERBg1NQWgrwaaSMnp5wmbkw); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU10 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 400 */     iTaskEnd8.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU10);
/*     */ 
/*     */ 
/*     */     
/* 404 */     Pairs pairs11 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 405 */     pairs11 = pairs11.add(Integer.valueOf(755368449), Integer.valueOf(1));
/* 406 */     pairs11 = pairs11.add(Integer.valueOf(755368450), Integer.valueOf(2));
/* 407 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.intFunction(755368448);
/* 408 */     iVehicleFunction15 = iVehicleFunction15.supportedFunctionValue(new int[] { 0, 755368449, 755368450 });
/*     */ 
/*     */ 
/*     */     
/* 412 */     IVehicleFunction.IZone iZone18 = iVehicleFunction15.createZone(new int[] { 1 });
/* 413 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iZone18.useStatusPAByIntBase(33598); ECarXCarSeatctrlManager eCarXCarSeatctrlManager9 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager9); -$$Lambda$2xCPr2rhm4LQAWTkKLWNXb7-U5Q -$$Lambda$2xCPr2rhm4LQAWTkKLWNXb7-U5Q = new -$$Lambda$2xCPr2rhm4LQAWTkKLWNXb7-U5Q(eCarXCarSeatctrlManager9);
/*     */     
/* 415 */     iValueTaskBuild27 = iValueTaskBuild27.onSetFunctionValue(-$$Lambda$2xCPr2rhm4LQAWTkKLWNXb7-U5Q, pairs11);
/*     */     
/* 417 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue4 = iValueTaskBuild27.useValueSignals(new int[] { 33592, 33595 }); -$$Lambda$Seat$1NiJEBHKPch5ZCgmblF9RorQC0k -$$Lambda$Seat$1NiJEBHKPch5ZCgmblF9RorQC0k = new -$$Lambda$Seat$1NiJEBHKPch5ZCgmblF9RorQC0k(this);
/*     */     
/* 419 */     IVehicleFunction.IFilterCallback iFilterCallback40 = iMultiSignalValue4.onValueSignalChanged(33595, -$$Lambda$Seat$1NiJEBHKPch5ZCgmblF9RorQC0k); -$$Lambda$Seat$PDow2nMF4ngsyuv_n4sjJPMNRwk -$$Lambda$Seat$PDow2nMF4ngsyuv_n4sjJPMNRwk = new -$$Lambda$Seat$PDow2nMF4ngsyuv_n4sjJPMNRwk(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 426 */     IVehicleFunction.ITaskEnd iTaskEnd7 = iFilterCallback40.filterValue(-$$Lambda$Seat$PDow2nMF4ngsyuv_n4sjJPMNRwk);
/*     */ 
/*     */     
/* 429 */     IVehicleFunction.IZone iZone17 = iTaskEnd7.createZone(new int[] { 4 });
/* 430 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iZone17.useStatusPAByIntBase(33600); ECarXCarSeatctrlManager eCarXCarSeatctrlManager8 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager8); -$$Lambda$memmndMMALD8pxxIS3TLiKmvvVk -$$Lambda$memmndMMALD8pxxIS3TLiKmvvVk = new -$$Lambda$memmndMMALD8pxxIS3TLiKmvvVk(eCarXCarSeatctrlManager8);
/*     */     
/* 432 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iValueTaskBuild26.onSetFunctionValue(-$$Lambda$memmndMMALD8pxxIS3TLiKmvvVk, pairs11);
/*     */     
/* 434 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue3 = iValueTaskBuild15.useValueSignals(new int[] { 33593, 33597 }); -$$Lambda$Seat$1l1v4DGCrzLEbDW2nYdMsPSaPcM -$$Lambda$Seat$1l1v4DGCrzLEbDW2nYdMsPSaPcM = new -$$Lambda$Seat$1l1v4DGCrzLEbDW2nYdMsPSaPcM(this);
/*     */     
/* 436 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iMultiSignalValue3.onValueSignalChanged(33597, -$$Lambda$Seat$1l1v4DGCrzLEbDW2nYdMsPSaPcM); -$$Lambda$Seat$KylolbIeO6Yt-VCQHU1VDsiMbXI -$$Lambda$Seat$KylolbIeO6Yt-VCQHU1VDsiMbXI = new -$$Lambda$Seat$KylolbIeO6Yt-VCQHU1VDsiMbXI(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 443 */     IVehicleFunction.ITaskEnd iTaskEnd3 = iFilterCallback14.filterValue(-$$Lambda$Seat$KylolbIeO6Yt-VCQHU1VDsiMbXI); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU15 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 446 */     iTaskEnd3.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU15);
/*     */ 
/*     */ 
/*     */     
/* 450 */     Pairs pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 451 */     pairs10 = pairs10.add(Integer.valueOf(755433729), Integer.valueOf(1));
/* 452 */     pairs10 = pairs10.add(Integer.valueOf(755433730), Integer.valueOf(2));
/*     */     
/* 454 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(755433728);
/* 455 */     iVehicleFunction14 = iVehicleFunction14.supportedFunctionValue(new int[] { 0, 755433729, 755433730 });
/*     */ 
/*     */ 
/*     */     
/* 459 */     IVehicleFunction.IZone iZone16 = iVehicleFunction14.createZone(new int[] { 1 });
/* 460 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iZone16.useStatusPAByIntBase(33606); ECarXCarSeatctrlManager eCarXCarSeatctrlManager7 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager7); -$$Lambda$YsO7F3oj7ftRk08tZP5bwPXOAy8 -$$Lambda$YsO7F3oj7ftRk08tZP5bwPXOAy8 = new -$$Lambda$YsO7F3oj7ftRk08tZP5bwPXOAy8(eCarXCarSeatctrlManager7);
/*     */     
/* 462 */     iValueTaskBuild25 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$YsO7F3oj7ftRk08tZP5bwPXOAy8, pairs10);
/*     */     
/* 464 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue8 = iValueTaskBuild25.useValueSignals(new int[] { 33592, 33595 }); -$$Lambda$Seat$syfYkr_T1reFDbmR1AqGe6F4RcI -$$Lambda$Seat$syfYkr_T1reFDbmR1AqGe6F4RcI = new -$$Lambda$Seat$syfYkr_T1reFDbmR1AqGe6F4RcI(this);
/*     */     
/* 466 */     IVehicleFunction.IFilterCallback iFilterCallback39 = iMultiSignalValue8.onValueSignalChanged(33595, -$$Lambda$Seat$syfYkr_T1reFDbmR1AqGe6F4RcI); -$$Lambda$Seat$J_V1Zs9lGnSxqK5fy2ZpNcxESI4 -$$Lambda$Seat$J_V1Zs9lGnSxqK5fy2ZpNcxESI4 = new -$$Lambda$Seat$J_V1Zs9lGnSxqK5fy2ZpNcxESI4(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 473 */     IVehicleFunction.ITaskEnd iTaskEnd6 = iFilterCallback39.filterValue(-$$Lambda$Seat$J_V1Zs9lGnSxqK5fy2ZpNcxESI4);
/*     */ 
/*     */     
/* 476 */     IVehicleFunction.IZone iZone15 = iTaskEnd6.createZone(new int[] { 4 });
/* 477 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iZone15.useStatusPAByIntBase(33607); ECarXCarSeatctrlManager eCarXCarSeatctrlManager6 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager6); -$$Lambda$MYeFlShYtg4a59K2j-DyGrOpea8 -$$Lambda$MYeFlShYtg4a59K2j-DyGrOpea8 = new -$$Lambda$MYeFlShYtg4a59K2j-DyGrOpea8(eCarXCarSeatctrlManager6);
/*     */     
/* 479 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iValueTaskBuild24.onSetFunctionValue(-$$Lambda$MYeFlShYtg4a59K2j-DyGrOpea8, pairs10);
/*     */     
/* 481 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue2 = iValueTaskBuild14.useValueSignals(new int[] { 33593, 33597 }); -$$Lambda$Seat$S7qIPe7RgW85UQ-SRgHAK0bVkZs -$$Lambda$Seat$S7qIPe7RgW85UQ-SRgHAK0bVkZs = new -$$Lambda$Seat$S7qIPe7RgW85UQ-SRgHAK0bVkZs(this);
/*     */     
/* 483 */     IVehicleFunction.IFilterCallback iFilterCallback25 = iMultiSignalValue2.onValueSignalChanged(33597, -$$Lambda$Seat$S7qIPe7RgW85UQ-SRgHAK0bVkZs); -$$Lambda$Seat$Let2_jCxukl4l8cel_zJZgijdag -$$Lambda$Seat$Let2_jCxukl4l8cel_zJZgijdag = new -$$Lambda$Seat$Let2_jCxukl4l8cel_zJZgijdag(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 490 */     IVehicleFunction.ITaskEnd iTaskEnd5 = iFilterCallback25.filterValue(-$$Lambda$Seat$Let2_jCxukl4l8cel_zJZgijdag); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU9 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 493 */     iTaskEnd5.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU9);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 508 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(759169280);
/* 509 */     IVehicleFunction.IZone iZone7 = iVehicleFunction8.createZone(new int[] { 1 });
/* 510 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone7.useStatusPAByIntBase(33894); ECarXCarProfileManager eCarXCarProfileManager2 = this.mECarXCarProfileManager; Objects.requireNonNull(eCarXCarProfileManager2); -$$Lambda$Ur4-eeWzNobjgVTPIk65ge6s2WU -$$Lambda$Ur4-eeWzNobjgVTPIk65ge6s2WU = new -$$Lambda$Ur4-eeWzNobjgVTPIk65ge6s2WU(eCarXCarProfileManager2);
/* 511 */     iValueTaskBuild13 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$Ur4-eeWzNobjgVTPIk65ge6s2WU, pairs7);
/*     */ 
/*     */     
/* 514 */     pairs7 = pairs7.reverse(); IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild13.useValuePAByIntBase(33894, pairs7); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU5 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 515 */     iFilterCallback13.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU5);
/*     */ 
/*     */     
/* 518 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(759169536);
/* 519 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 0, 1, 2, 3 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 525 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { 1 });
/* 526 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useStatusPAByIntBase(33895); ECarXCarProfileManager eCarXCarProfileManager1 = this.mECarXCarProfileManager; Objects.requireNonNull(eCarXCarProfileManager1); -$$Lambda$tjF92ATwN5hWvzNcOI4tGJIcgTc -$$Lambda$tjF92ATwN5hWvzNcOI4tGJIcgTc = new -$$Lambda$tjF92ATwN5hWvzNcOI4tGJIcgTc(eCarXCarProfileManager1);
/* 527 */     iValueTaskBuild1 = iValueTaskBuild1.onSetFunctionValue(-$$Lambda$tjF92ATwN5hWvzNcOI4tGJIcgTc); -$$Lambda$Seat$QsMxIEZSVmMpSQdWAd_-OGEtsXU -$$Lambda$Seat$QsMxIEZSVmMpSQdWAd_-OGEtsXU = -$$Lambda$Seat$QsMxIEZSVmMpSQdWAd_-OGEtsXU.INSTANCE;
/* 528 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild1.useValuePAByIntBase(33895, -$$Lambda$Seat$QsMxIEZSVmMpSQdWAd_-OGEtsXU); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU8 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 529 */     iFilterCallback2.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 550 */     Pairs pairs6 = Pairs.of(Integer.valueOf(759236355), Integer.valueOf(0));
/* 551 */     pairs6 = pairs6.add(Integer.valueOf(759236353), Integer.valueOf(1)); pairs6 = pairs6.add(Integer.valueOf(759236354), Integer.valueOf(2));
/*     */     
/* 553 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(759236352);
/* 554 */     iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(new int[] { 759236353, 759236354, 759236355 });
/*     */ 
/*     */     
/* 557 */     IVehicleFunction.IZone iZone6 = iVehicleFunction7.createZone(new int[] { 256 });
/* 558 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone6.useStatusPAByIntBase(33620); ECarXCarSeatctrlManager eCarXCarSeatctrlManager4 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager4); -$$Lambda$c35VGsX4gL1g9KiW4XvxtxTt9DM -$$Lambda$c35VGsX4gL1g9KiW4XvxtxTt9DM = new -$$Lambda$c35VGsX4gL1g9KiW4XvxtxTt9DM(eCarXCarSeatctrlManager4);
/*     */     
/* 560 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$c35VGsX4gL1g9KiW4XvxtxTt9DM, pairs6);
/*     */ 
/*     */ 
/*     */     
/* 564 */     Pairs pairs9 = pairs6.reverse(); IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild23.useValuePAByIntBase(33620, pairs9);
/* 565 */     IVehicleFunction.IZone iZone5 = iFilterCallback12.createZone(new int[] { 1024 });
/* 566 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone5.useStatusPAByIntBase(33621); ECarXCarSeatctrlManager eCarXCarSeatctrlManager3 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager3); -$$Lambda$r_b1fDjLBi3F7Z1zooRDEX9uxyE -$$Lambda$r_b1fDjLBi3F7Z1zooRDEX9uxyE = new -$$Lambda$r_b1fDjLBi3F7Z1zooRDEX9uxyE(eCarXCarSeatctrlManager3);
/*     */     
/* 568 */     iValueTaskBuild11 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$r_b1fDjLBi3F7Z1zooRDEX9uxyE, pairs6);
/*     */ 
/*     */ 
/*     */     
/* 572 */     pairs6 = pairs6.reverse(); IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild11.useValuePAByIntBase(33621, pairs6); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU4 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 573 */     iFilterCallback11.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU4);
/*     */ 
/*     */     
/* 576 */     Pairs pairs5 = Pairs.of(Integer.valueOf(759236609), Integer.valueOf(1));
/*     */     
/* 578 */     pairs5 = pairs5.add(Integer.valueOf(759236610), Integer.valueOf(3)); pairs5 = pairs5.add(Integer.valueOf(759236611), Integer.valueOf(2));
/*     */     
/* 580 */     pairs5 = pairs5.add(Integer.valueOf(759236612), Integer.valueOf(5));
/* 581 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(759236608);
/* 582 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 759236609, 759236610, 759236611, 759236612 });
/*     */ 
/*     */ 
/*     */     
/* 586 */     IVehicleFunction.IZone iZone14 = iVehicleFunction6.createZone(new int[] { 1 }); FunctionStatus functionStatus6 = FunctionStatus.active;
/* 587 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone14.fixStatus(functionStatus6); ECarXCarSeatctrlManager eCarXCarSeatctrlManager2 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager2); -$$Lambda$EkPg2iEk5Kd5EQ_LTN_zE8kxMv0 -$$Lambda$EkPg2iEk5Kd5EQ_LTN_zE8kxMv0 = new -$$Lambda$EkPg2iEk5Kd5EQ_LTN_zE8kxMv0(eCarXCarSeatctrlManager2);
/* 588 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$EkPg2iEk5Kd5EQ_LTN_zE8kxMv0, pairs5);
/*     */ 
/*     */     
/* 591 */     Pairs pairs8 = pairs5.reverse(); IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild22.useValuePAByIntBase(33592, pairs8); -$$Lambda$Seat$ERNl8iwd9Z7GUXN6RR86o_vpLbM -$$Lambda$Seat$ERNl8iwd9Z7GUXN6RR86o_vpLbM = new -$$Lambda$Seat$ERNl8iwd9Z7GUXN6RR86o_vpLbM(this);
/* 592 */     IVehicleFunction.ITaskEnd iTaskEnd2 = iFilterCallback10.filterValue(-$$Lambda$Seat$ERNl8iwd9Z7GUXN6RR86o_vpLbM);
/*     */ 
/*     */     
/* 595 */     IVehicleFunction.IZone iZone4 = iTaskEnd2.createZone(new int[] { 4 }); FunctionStatus functionStatus15 = FunctionStatus.active;
/* 596 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone4.fixStatus(functionStatus15); ECarXCarSeatctrlManager eCarXCarSeatctrlManager1 = this.mECarXCarSeatclimateManager; Objects.requireNonNull(eCarXCarSeatctrlManager1); -$$Lambda$NvTO0AbctIMTRyEzI385PJuO3VE -$$Lambda$NvTO0AbctIMTRyEzI385PJuO3VE = new -$$Lambda$NvTO0AbctIMTRyEzI385PJuO3VE(eCarXCarSeatctrlManager1);
/* 597 */     iValueTaskBuild9 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$NvTO0AbctIMTRyEzI385PJuO3VE, pairs5);
/*     */ 
/*     */     
/* 600 */     pairs5 = pairs5.reverse(); IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild9.useValuePAByIntBase(33593, pairs5); -$$Lambda$Seat$vPs0hCTVFyeDmCLql8fY5Xcjwnc -$$Lambda$Seat$vPs0hCTVFyeDmCLql8fY5Xcjwnc = new -$$Lambda$Seat$vPs0hCTVFyeDmCLql8fY5Xcjwnc(this);
/* 601 */     IVehicleFunction.ITaskEnd iTaskEnd1 = iFilterCallback9.filterValue(-$$Lambda$Seat$vPs0hCTVFyeDmCLql8fY5Xcjwnc); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU7 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 604 */     iTaskEnd1.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU7);
/*     */ 
/*     */ 
/*     */     
/* 608 */     Pairs pairs4 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*     */     
/* 610 */     pairs4 = pairs4.add(Integer.valueOf(1), Integer.valueOf(759237121));
/* 611 */     pairs4 = pairs4.add(Integer.valueOf(2), Integer.valueOf(759237122));
/* 612 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(759237120);
/* 613 */     iVehicleFunction5 = iVehicleFunction5.supportedFunctionValue(new int[] { 0, 759237121, 759237122 });
/*     */ 
/*     */     
/* 616 */     IVehicleFunction.IZone iZone13 = iVehicleFunction5.createZone(new int[] { 1 }); FunctionStatus functionStatus5 = FunctionStatus.active;
/* 617 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone13.fixStatus(functionStatus5);
/* 618 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild8.useValuePAByIntBase(33594, pairs4);
/*     */ 
/*     */     
/* 621 */     iZone13 = iFilterCallback8.createZone(new int[] { 4 }); FunctionStatus functionStatus4 = FunctionStatus.active;
/* 622 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone13.fixStatus(functionStatus4);
/* 623 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild7.useValuePAByIntBase(33596, pairs4); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU3 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 626 */     iFilterCallback7.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU3);
/*     */ 
/*     */ 
/*     */     
/* 630 */     Pairs pairs3 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*     */     
/* 632 */     pairs3 = pairs3.add(Integer.valueOf(1), Integer.valueOf(759237377));
/* 633 */     pairs3 = pairs3.add(Integer.valueOf(2), Integer.valueOf(759237378));
/* 634 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(759237376);
/* 635 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(new int[] { 0, 759237377, 759237378 });
/*     */ 
/*     */     
/* 638 */     IVehicleFunction.IZone iZone3 = iVehicleFunction4.createZone(new int[] { 1 }); FunctionStatus functionStatus14 = FunctionStatus.active;
/* 639 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone3.fixStatus(functionStatus14);
/* 640 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild6.useValuePAByIntBase(33595, pairs3);
/*     */ 
/*     */     
/* 643 */     IVehicleFunction.IZone iZone12 = iFilterCallback6.createZone(new int[] { 4 }); FunctionStatus functionStatus3 = FunctionStatus.active;
/* 644 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone12.fixStatus(functionStatus3);
/* 645 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild5.useValuePAByIntBase(33597, pairs3); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU6 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 648 */     iFilterCallback1.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU6);
/*     */ 
/*     */     
/* 651 */     Pairs pairs2 = Pairs.of(Integer.valueOf(0), Integer.valueOf(759237635)); pairs2 = pairs2.add(Integer.valueOf(1), Integer.valueOf(759237634));
/* 652 */     pairs2 = pairs2.add(Integer.valueOf(2), Integer.valueOf(759237633));
/* 653 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(759237632);
/* 654 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(new int[] { 759237633, 759237634, 759237635 });
/*     */ 
/*     */     
/* 657 */     IVehicleFunction.IZone iZone2 = iVehicleFunction3.createZone(new int[] { 1 }); FunctionStatus functionStatus13 = FunctionStatus.active;
/* 658 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone2.fixStatus(functionStatus13);
/* 659 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild4.useValuePAByIntBase(33632, pairs2);
/*     */ 
/*     */     
/* 662 */     IVehicleFunction.IZone iZone11 = iFilterCallback5.createZone(new int[] { 4 }); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 663 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone11.fixStatus(functionStatus2);
/* 664 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild3.useValuePAByIntBase(33633, pairs2); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU2 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/*     */ 
/*     */     
/* 667 */     iFilterCallback4.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU2);
/*     */ 
/*     */     
/* 670 */     Pairs pairs1 = Pairs.of(Integer.valueOf(2), Integer.valueOf(5)).add(Integer.valueOf(3), Integer.valueOf(7)).add(Integer.valueOf(4), Integer.valueOf(4)).add(Integer.valueOf(5), Integer.valueOf(3)); pairs1 = pairs1.add(Integer.valueOf(6), Integer.valueOf(4));
/* 671 */     pairs1 = pairs1.add(Integer.valueOf(7), Integer.valueOf(1)).add(Integer.valueOf(8), Integer.valueOf(2)).add(Integer.valueOf(9), Integer.valueOf(6)).orDefault(Integer.valueOf(0));
/* 672 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(759238400);
/* 673 */     iZone11 = iVehicleFunction2.createZone(); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 674 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone11.fixStatus(functionStatus1);
/* 675 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild2.useValueSignal(29344, pairs1); -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU1 = new -$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU(this);
/* 676 */     iFilterCallback3.addTo(-$$Lambda$Seat$3eNQ8MIlGJrvgZti9apykMzR0NU1);
/*     */   }
/*     */   
/*     */   private int convertPAEventCushExe(int paramInt) {
/* 680 */     boolean bool = false;
/* 681 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 691 */         return paramInt;case 2: paramInt = 755433730; return paramInt;case 1: break; }  paramInt = 755433729; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int convertPAEventSeatCushionSide(int paramInt) {
/* 702 */     boolean bool = false;
/* 703 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 716 */         return paramInt;case 2: paramInt = 755237122; return paramInt;case 1: paramInt = 755237121; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int convertPAEventSeatLumbarHeight(int paramInt) {
/* 727 */     boolean bool = false;
/* 728 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 741 */         return paramInt;case 2: paramInt = 755368194; return paramInt;case 1: paramInt = 755368193; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
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
/*     */   private int convertPAEventSeatBackrestSide(int paramInt) {
/* 753 */     boolean bool = false;
/* 754 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 767 */         return paramInt;case 2: paramInt = 755237378; return paramInt;case 1: paramInt = 755237377; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int convertPAEventSeatLumbarExtended(int paramInt) {
/* 778 */     boolean bool = false;
/* 779 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 792 */         return paramInt;case 2: paramInt = 755368450; return paramInt;case 1: paramInt = 755368449; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Seat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */