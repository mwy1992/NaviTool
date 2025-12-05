/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarScenemodManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SceneMode
/*     */   extends AbsCarFunction
/*     */   implements ISceneMode
/*     */ {
/*  21 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*     */   private static final String TAG = "SceneMode_API";
/*     */   private ECarXCarScenemodManager mECarXCarScenemodManager;
/*     */   
/*     */   protected SceneMode(Context paramContext) {
/*  26 */     super(paramContext, 788529152);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  36 */     this.mECarXCarScenemodManager = this.mECarXCarSetManager.getECarXCarScenemodManager();
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
/*     */   protected void buildFunctions() {
/*  48 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(788595200); int[] arrayOfInt5 = COMMON_ON_OFF;
/*  49 */     IVehicleFunction iVehicleFunction9 = iVehicleFunction14.supportedFunctionValue(arrayOfInt5);
/*  50 */     IVehicleFunction.IZone iZone9 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE });
/*  51 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone9.useStatusPAByIntBase(33939); ECarXCarScenemodManager eCarXCarScenemodManager9 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager9); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw8 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager9);
/*     */ 
/*     */     
/*  54 */     Pairs pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  55 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(9));
/*     */     
/*     */     iValueTaskBuild9 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw8, pairs10);
/*  58 */     Pairs pairs9 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  59 */     pairs9 = pairs9.add(Integer.valueOf(9), Integer.valueOf(1)); IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild9.useValuePAByIntBase(33951, pairs9); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U9 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/*  60 */     iFilterCallback4.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U9);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.intFunction(788596224); int[] arrayOfInt4 = COMMON_ON_OFF;
/*  70 */     IVehicleFunction iVehicleFunction8 = iVehicleFunction13.supportedFunctionValue(arrayOfInt4);
/*  71 */     IVehicleFunction.IZone iZone8 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/*  72 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone8.useStatusPAByIntBase(33942); ECarXCarScenemodManager eCarXCarScenemodManager8 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager8); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw7 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager8);
/*     */ 
/*     */     
/*  75 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  76 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(2));
/*     */     
/*     */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw7, pairs10);
/*  79 */     Pairs pairs8 = Pairs.of(Integer.valueOf(2), Integer.valueOf(1));
/*  80 */     pairs8 = pairs8.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild8.useValuePAByIntBase(33951, pairs8); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U5 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/*  81 */     iFilterCallback9.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(788660736); int[] arrayOfInt9 = COMMON_ON_OFF;
/*  88 */     iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(arrayOfInt9);
/*  89 */     IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/*  90 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone7.useStatusPAByIntBase(33936); ECarXCarScenemodManager eCarXCarScenemodManager7 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager7); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw6 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager7);
/*     */     
/*  92 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  93 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(1));
/*     */     iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw6, pairs10);
/*  95 */     Pairs pairs7 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/*  96 */     pairs7 = pairs7.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild7.useValuePAByIntBase(33951, pairs7); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U8 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/*  97 */     iFilterCallback3.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(788661760); int[] arrayOfInt8 = COMMON_ON_OFF;
/* 110 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(arrayOfInt8);
/* 111 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/* 112 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone6.useStatusPAByIntBase(33937); ECarXCarScenemodManager eCarXCarScenemodManager6 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager6); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw5 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager6);
/*     */ 
/*     */     
/* 115 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 116 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(4));
/*     */     
/*     */     iValueTaskBuild6 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw5, pairs10);
/* 119 */     Pairs pairs6 = Pairs.of(Integer.valueOf(4), Integer.valueOf(1));
/* 120 */     pairs6 = pairs6.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild6.useValuePAByIntBase(33951, pairs6); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U4 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/* 121 */     iFilterCallback8.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U4);
/*     */ 
/*     */     
/* 124 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(788662016); int[] arrayOfInt7 = COMMON_ON_OFF;
/* 125 */     iVehicleFunction5 = iVehicleFunction5.supportedFunctionValue(arrayOfInt7);
/* 126 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 127 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone5.useStatusPAByIntBase(33950); ECarXCarScenemodManager eCarXCarScenemodManager5 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager5); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw4 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager5);
/*     */ 
/*     */     
/* 130 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 131 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(11));
/*     */     iValueTaskBuild5 = iValueTaskBuild5.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw4, pairs10);
/* 133 */     Pairs pairs5 = Pairs.of(Integer.valueOf(11), Integer.valueOf(1));
/* 134 */     pairs5 = pairs5.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild5.useValuePAByIntBase(33951, pairs5); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U3 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/* 135 */     iFilterCallback7.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U3);
/*     */ 
/*     */     
/* 138 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.intFunction(788594944); int[] arrayOfInt3 = COMMON_ON_OFF;
/* 139 */     IVehicleFunction iVehicleFunction4 = iVehicleFunction12.supportedFunctionValue(arrayOfInt3);
/* 140 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { 4 });
/* 141 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone4.useStatusPAByIntBase(33947); ECarXCarScenemodManager eCarXCarScenemodManager4 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager4); -$$Lambda$vJJiX8za552b22ypZtCjrmx3naI -$$Lambda$vJJiX8za552b22ypZtCjrmx3naI = new -$$Lambda$vJJiX8za552b22ypZtCjrmx3naI(eCarXCarScenemodManager4);
/*     */ 
/*     */     
/* 144 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 145 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(6));
/*     */     
/*     */     iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$vJJiX8za552b22ypZtCjrmx3naI, pairs10);
/* 148 */     Pairs pairs4 = Pairs.of(Integer.valueOf(6), Integer.valueOf(1));
/* 149 */     pairs4 = pairs4.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild4.useValuePAByIntBase(33953, pairs4); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U2 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/* 150 */     iFilterCallback6.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U2);
/*     */ 
/*     */     
/* 153 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(788662528); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 154 */     IVehicleFunction iVehicleFunction3 = iVehicleFunction11.supportedFunctionValue(arrayOfInt2);
/* 155 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/* 156 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone3.useStatusPAByIntBase(33952); ECarXCarScenemodManager eCarXCarScenemodManager3 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager3); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw3 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager3);
/*     */ 
/*     */     
/* 159 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 160 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(14));
/*     */     iValueTaskBuild3 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw3, pairs10);
/* 162 */     Pairs pairs3 = Pairs.of(Integer.valueOf(14), Integer.valueOf(1));
/* 163 */     pairs3 = pairs3.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild3.useValuePAByIntBase(33951, pairs3); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U7 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/* 164 */     iFilterCallback2.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U7);
/*     */ 
/*     */     
/* 167 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(788662272); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 168 */     IVehicleFunction iVehicleFunction2 = iVehicleFunction10.supportedFunctionValue(arrayOfInt1);
/* 169 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/* 170 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone2.useStatusPAByIntBase(33943); ECarXCarScenemodManager eCarXCarScenemodManager2 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager2); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw2 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager2);
/*     */ 
/*     */     
/* 173 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 174 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(3));
/*     */     iValueTaskBuild2 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw2, pairs10);
/* 176 */     Pairs pairs2 = Pairs.of(Integer.valueOf(3), Integer.valueOf(1));
/* 177 */     pairs2 = pairs2.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild2.useValuePAByIntBase(33951, pairs2); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U6 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/* 178 */     iFilterCallback1.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U6);
/*     */ 
/*     */     
/* 181 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(788663808); int[] arrayOfInt6 = COMMON_ON_OFF;
/* 182 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(arrayOfInt6);
/* 183 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/* 184 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useStatusPAByIntBase(33949); ECarXCarScenemodManager eCarXCarScenemodManager1 = this.mECarXCarScenemodManager; Objects.requireNonNull(eCarXCarScenemodManager1); -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw1 = new -$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw(eCarXCarScenemodManager1);
/*     */ 
/*     */     
/* 187 */     pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 188 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(10));
/*     */     iValueTaskBuild1 = iValueTaskBuild1.onSetFunctionValue(-$$Lambda$X7mTBhh5QMK2mSRNHomm2J6SWZw1, pairs10);
/* 190 */     Pairs pairs1 = Pairs.of(Integer.valueOf(10), Integer.valueOf(1));
/* 191 */     pairs1 = pairs1.orDefault(Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild1.useValuePAByIntBase(33951, pairs1); -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U1 = new -$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U(this);
/* 192 */     iFilterCallback5.addTo(-$$Lambda$SceneMode$JSAbhgNU_FbLlsAFf0sHskw4w-U1);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\SceneMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */