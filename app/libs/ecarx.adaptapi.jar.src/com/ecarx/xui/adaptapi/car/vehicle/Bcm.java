/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.util.SparseIntArray;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarAmbliManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfmisc2Manager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfsmallcycleManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Bcm
/*     */   extends AbsCarFunction
/*     */   implements IBcm
/*     */ {
/*  48 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*     */   private static final int[] WINDOW_POS_TYPE;
/*  50 */   private static final int[] WINDOW_POS_VALUE = new int[] { 0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96, 100 }; private ECarXCarAmbliManager mAmbliManager; private ECarXCarVfmisc2Manager mVfmisc2Mgr; private ECarXCarVfmiscManager mVfmiscMgr;
/*     */   private ECarXCarVfsmallcycleManager mVfsmallMgr;
/*     */   
/*     */   static {
/*  54 */     WINDOW_POS_TYPE = new int[] { 1, 0, 2, 4, 3, 8, 4, 12, 5, 16, 6, 20, 7, 24, 8, 28, 9, 32, 10, 36, 11, 40, 12, 44, 13, 48, 14, 52, 15, 56, 16, 60, 17, 64, 18, 68, 19, 72, 20, 76, 21, 80, 22, 84, 23, 88, 24, 92, 25, 96, 26, 100 };
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
/*  65 */   private final BidirectionalSparseIntArray mWindowPosSignalToApiPar = new BidirectionalSparseIntArray(WINDOW_POS_TYPE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int convertToWindowSignal(float paramFloat) {
/*  72 */     int i = 0;
/*  73 */     if (paramFloat >= 10.0F && paramFloat <= 100.0F) {
/*  74 */       i = (int)Math.floor(((2.0F + paramFloat) / 4.0F)) * 4;
/*  75 */     } else if (paramFloat > 100.0F) {
/*  76 */       i = 100;
/*     */     } 
/*  78 */     return this.mWindowPosSignalToApiPar.getKey(i, 0);
/*     */   }
/*     */   
/*     */   private float convertToWindowAdapt(int paramInt) {
/*  82 */     return this.mWindowPosSignalToApiPar.getValue(paramInt, 255);
/*     */   }
/*     */   
/*     */   protected Bcm(Context paramContext) {
/*  86 */     super(paramContext, 553648128);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  91 */     this.mAmbliManager = this.mECarXCarSetManager.getECarXCarAmbliManager();
/*  92 */     this.mVfmiscMgr = this.mECarXCarSetManager.getECarXCarVfmiscManager();
/*  93 */     this.mVfmisc2Mgr = this.mECarXCarSetManager.getECarXCarVfmisc2Manager();
/*  94 */     this.mVfsmallMgr = this.mECarXCarSetManager.getECarXCarVfsmallcycleManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/* 100 */     Pairs pairs2 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/* 101 */     Pairs pairs4 = pairs2.add(Integer.valueOf(1), Integer.valueOf(1));
/* 102 */     pairs2 = pairs4.reverse();
/*     */ 
/*     */     
/* 105 */     Pairs pairs5 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2));
/* 106 */     Pairs pairs6 = pairs5.add(Integer.valueOf(1), Integer.valueOf(1));
/* 107 */     pairs5 = pairs6.reverse();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     IVehicleFunction iVehicleFunction18 = VehicleFunction.intFunction(553779456);
/* 114 */     IVehicleFunction.IZone iZone45 = iVehicleFunction18.createZone(new int[] { 536870912 }); -$$Lambda$Bcm$mL87E_ZujmJCcmR91H2Ys4r7isY -$$Lambda$Bcm$mL87E_ZujmJCcmR91H2Ys4r7isY = new -$$Lambda$Bcm$mL87E_ZujmJCcmR91H2Ys4r7isY(this);
/* 115 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild5 = iZone45.supportedFunctionValue(-$$Lambda$Bcm$mL87E_ZujmJCcmR91H2Ys4r7isY, new int[] { 33684, 33685 });
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
/* 129 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus = iStatusTaskBuild5.useStatusSignals(new int[] { 33684, 33685 }); -$$Lambda$Bcm$iVe0LAVRZK5vinHs9Lq4DDf-39I -$$Lambda$Bcm$iVe0LAVRZK5vinHs9Lq4DDf-39I = new -$$Lambda$Bcm$iVe0LAVRZK5vinHs9Lq4DDf-39I(this);
/*     */ 
/*     */     
/* 132 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild45 = iMultiSignalStatus.onStatusSignalChanged(-$$Lambda$Bcm$iVe0LAVRZK5vinHs9Lq4DDf-39I); -$$Lambda$Bcm$j28WUWfFH3hQ6OkjbJZyG6dhZWA -$$Lambda$Bcm$j28WUWfFH3hQ6OkjbJZyG6dhZWA = new -$$Lambda$Bcm$j28WUWfFH3hQ6OkjbJZyG6dhZWA(this);
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
/* 159 */     Pairs pairs14 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 160 */     pairs14 = pairs14.add(Integer.valueOf(0), Integer.valueOf(2));
/* 161 */     pairs14 = pairs14.add(Integer.valueOf(553779457), Integer.valueOf(3)); iValueTaskBuild45 = iValueTaskBuild45.onSetFunctionValue(-$$Lambda$Bcm$j28WUWfFH3hQ6OkjbJZyG6dhZWA, pairs14);
/* 162 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue = iValueTaskBuild45.useValueSignals(new int[] { 30515, 33687 }); -$$Lambda$Bcm$wII93UzP9ZQaf2h4SE9_YSAzyKI -$$Lambda$Bcm$wII93UzP9ZQaf2h4SE9_YSAzyKI = new -$$Lambda$Bcm$wII93UzP9ZQaf2h4SE9_YSAzyKI(this);
/*     */     
/* 164 */     IVehicleFunction.IFilterCallback iFilterCallback34 = iMultiSignalValue.onValueSignalChanged(-$$Lambda$Bcm$wII93UzP9ZQaf2h4SE9_YSAzyKI);
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
/* 184 */     IVehicleFunction.IZone iZone33 = iFilterCallback34.createZone(new int[] { 1 });
/* 185 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild4 = iZone33.supportedFunctionValue(new int[] { 0, 1 }); FunctionStatus functionStatus22 = FunctionStatus.active;
/* 186 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild44 = iStatusTaskBuild4.fixStatus(functionStatus22); -$$Lambda$Bcm$XqjQ3isPF1hchjv6-duDGX5OI1M -$$Lambda$Bcm$XqjQ3isPF1hchjv6-duDGX5OI1M = -$$Lambda$Bcm$XqjQ3isPF1hchjv6-duDGX5OI1M.INSTANCE;
/* 187 */     IVehicleFunction.IFilterCallback iFilterCallback33 = iValueTaskBuild44.useValueSignal(30412, -$$Lambda$Bcm$XqjQ3isPF1hchjv6-duDGX5OI1M);
/*     */ 
/*     */     
/* 190 */     IVehicleFunction.IZone iZone32 = iFilterCallback33.createZone(new int[] { 4 });
/* 191 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild3 = iZone32.supportedFunctionValue(new int[] { 0, 1 }); FunctionStatus functionStatus21 = FunctionStatus.active;
/* 192 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild58 = iStatusTaskBuild3.fixStatus(functionStatus21); -$$Lambda$Bcm$fce9DtcM1ZiA1r2LDF_O5Ik64k0 -$$Lambda$Bcm$fce9DtcM1ZiA1r2LDF_O5Ik64k0 = -$$Lambda$Bcm$fce9DtcM1ZiA1r2LDF_O5Ik64k0.INSTANCE;
/* 193 */     IVehicleFunction.IFilterCallback iFilterCallback32 = iValueTaskBuild58.useValueSignal(30418, -$$Lambda$Bcm$fce9DtcM1ZiA1r2LDF_O5Ik64k0);
/*     */ 
/*     */     
/* 196 */     IVehicleFunction.IZone iZone31 = iFilterCallback32.createZone(new int[] { 16 });
/* 197 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild2 = iZone31.supportedFunctionValue(new int[] { 0, 1 }); FunctionStatus functionStatus20 = FunctionStatus.active;
/* 198 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild43 = iStatusTaskBuild2.fixStatus(functionStatus20); -$$Lambda$Bcm$OwS3ruVaFoGg6cZlBXifU2WpXbY -$$Lambda$Bcm$OwS3ruVaFoGg6cZlBXifU2WpXbY = -$$Lambda$Bcm$OwS3ruVaFoGg6cZlBXifU2WpXbY.INSTANCE;
/* 199 */     IVehicleFunction.IFilterCallback iFilterCallback31 = iValueTaskBuild43.useValueSignal(30415, -$$Lambda$Bcm$OwS3ruVaFoGg6cZlBXifU2WpXbY);
/*     */     
/* 201 */     IVehicleFunction.IZone iZone30 = iFilterCallback31.createZone(new int[] { 64 });
/* 202 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild7 = iZone30.supportedFunctionValue(new int[] { 0, 1 }); FunctionStatus functionStatus15 = FunctionStatus.active;
/* 203 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild42 = iStatusTaskBuild7.fixStatus(functionStatus15); -$$Lambda$Bcm$6mkSLBstGJq1HJZT9M-V0l5XiEI -$$Lambda$Bcm$6mkSLBstGJq1HJZT9M-V0l5XiEI = -$$Lambda$Bcm$6mkSLBstGJq1HJZT9M-V0l5XiEI.INSTANCE;
/* 204 */     IVehicleFunction.IFilterCallback iFilterCallback30 = iValueTaskBuild42.useValueSignal(30421, -$$Lambda$Bcm$6mkSLBstGJq1HJZT9M-V0l5XiEI);
/*     */     
/* 206 */     IVehicleFunction.IZone iZone29 = iFilterCallback30.createZone(new int[] { 268435456 });
/* 207 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild6 = iZone29.supportedFunctionValue(new int[] { 0, 1 }); FunctionStatus functionStatus14 = FunctionStatus.active;
/* 208 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild41 = iStatusTaskBuild6.fixStatus(functionStatus14); -$$Lambda$Bcm$aeZL44sZAS75-v0OnM-hfqQUnSc -$$Lambda$Bcm$aeZL44sZAS75-v0OnM-hfqQUnSc = -$$Lambda$Bcm$aeZL44sZAS75-v0OnM-hfqQUnSc.INSTANCE;
/* 209 */     IVehicleFunction.IFilterCallback iFilterCallback29 = iValueTaskBuild41.useValueSignal(30447, -$$Lambda$Bcm$aeZL44sZAS75-v0OnM-hfqQUnSc); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA17 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 211 */     iFilterCallback29.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA17);
/*     */ 
/*     */     
/* 214 */     IVehicleFunction iVehicleFunction23 = VehicleFunction.intFunction(553779712); int[] arrayOfInt7 = COMMON_ON_OFF;
/* 215 */     IVehicleFunction iVehicleFunction17 = iVehicleFunction23.supportedFunctionValue(arrayOfInt7);
/* 216 */     IVehicleFunction.IZone iZone28 = iVehicleFunction17.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus19 = FunctionStatus.active;
/* 217 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild40 = iZone28.fixStatus(functionStatus19); -$$Lambda$Bcm$f86pjrm1YJPSr9C5pw4cYTmT2n4 -$$Lambda$Bcm$f86pjrm1YJPSr9C5pw4cYTmT2n4 = -$$Lambda$Bcm$f86pjrm1YJPSr9C5pw4cYTmT2n4.INSTANCE;
/* 218 */     IVehicleFunction.IFilterCallback iFilterCallback28 = iValueTaskBuild40.useValueSignal(30641, -$$Lambda$Bcm$f86pjrm1YJPSr9C5pw4cYTmT2n4); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA16 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */ 
/*     */     
/* 221 */     iFilterCallback28.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     Pairs pairs8 = Pairs.of(Integer.valueOf(1), Integer.valueOf(2));
/* 229 */     pairs8 = pairs8.add(Integer.valueOf(0), Integer.valueOf(1));
/*     */ 
/*     */     
/* 232 */     Pairs pairs12 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 233 */     pairs12 = pairs12.add(Integer.valueOf(2), Integer.valueOf(0));
/*     */     
/* 235 */     IVehicleFunction iVehicleFunction25 = VehicleFunction.intFunction(553780224); int[] arrayOfInt14 = COMMON_ON_OFF;
/* 236 */     iVehicleFunction25 = iVehicleFunction25.supportedFunctionValue(arrayOfInt14);
/* 237 */     IVehicleFunction.IZone iZone49 = iVehicleFunction25.createZone(new int[] { 16 });
/* 238 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild63 = iZone49.useStatusPAByIntBase(33864); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager12 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager12); -$$Lambda$XOIBrJ1pcJyQ6XRM-lpbBLXmDrU -$$Lambda$XOIBrJ1pcJyQ6XRM-lpbBLXmDrU = new -$$Lambda$XOIBrJ1pcJyQ6XRM-lpbBLXmDrU(eCarXCarVfsmallcycleManager12);
/* 239 */     iValueTaskBuild63 = iValueTaskBuild63.onSetFunctionValue(-$$Lambda$XOIBrJ1pcJyQ6XRM-lpbBLXmDrU, pairs8);
/* 240 */     IVehicleFunction.IFilterCallback iFilterCallback43 = iValueTaskBuild63.useValuePAByIntBase(33864, pairs12);
/*     */     
/* 242 */     IVehicleFunction.IZone iZone48 = iFilterCallback43.createZone(new int[] { 64 });
/* 243 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild62 = iZone48.useStatusPAByIntBase(33865); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager11 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager11); -$$Lambda$7SFsyucJmYzzwKsDUIJw8z7WPSA -$$Lambda$7SFsyucJmYzzwKsDUIJw8z7WPSA = new -$$Lambda$7SFsyucJmYzzwKsDUIJw8z7WPSA(eCarXCarVfsmallcycleManager11);
/* 244 */     iValueTaskBuild62 = iValueTaskBuild62.onSetFunctionValue(-$$Lambda$7SFsyucJmYzzwKsDUIJw8z7WPSA, pairs8);
/* 245 */     IVehicleFunction.IFilterCallback iFilterCallback42 = iValueTaskBuild62.useValuePAByIntBase(33865, pairs12); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA18 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 247 */     iFilterCallback42.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA18);
/*     */ 
/*     */     
/* 250 */     IVehicleFunction iVehicleFunction26 = VehicleFunction.intFunction(553780992); int[] arrayOfInt13 = COMMON_ON_OFF;
/* 251 */     IVehicleFunction iVehicleFunction24 = iVehicleFunction26.supportedFunctionValue(arrayOfInt13);
/* 252 */     IVehicleFunction.IZone iZone47 = iVehicleFunction24.createZone(new int[] { 16 });
/* 253 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild61 = iZone47.useStatusPAByIntBase(33866); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager10 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager10); -$$Lambda$JHQ6ixeqPYKc6_Aq0SMFR_pwnDo -$$Lambda$JHQ6ixeqPYKc6_Aq0SMFR_pwnDo = new -$$Lambda$JHQ6ixeqPYKc6_Aq0SMFR_pwnDo(eCarXCarVfsmallcycleManager10);
/* 254 */     iValueTaskBuild61 = iValueTaskBuild61.onSetFunctionValue(-$$Lambda$JHQ6ixeqPYKc6_Aq0SMFR_pwnDo, pairs8);
/* 255 */     IVehicleFunction.IFilterCallback iFilterCallback41 = iValueTaskBuild61.useValuePAByIntBase(33866, pairs12);
/*     */     
/* 257 */     IVehicleFunction.IZone iZone46 = iFilterCallback41.createZone(new int[] { 64 });
/* 258 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild60 = iZone46.useStatusPAByIntBase(33867); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager9 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager9); -$$Lambda$5WLXLDP53Z4qhfx0JzeYu3wTPt4 -$$Lambda$5WLXLDP53Z4qhfx0JzeYu3wTPt4 = new -$$Lambda$5WLXLDP53Z4qhfx0JzeYu3wTPt4(eCarXCarVfsmallcycleManager9);
/* 259 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild39 = iValueTaskBuild60.onSetFunctionValue(-$$Lambda$5WLXLDP53Z4qhfx0JzeYu3wTPt4, pairs8);
/* 260 */     IVehicleFunction.IFilterCallback iFilterCallback27 = iValueTaskBuild39.useValuePAByIntBase(33867, pairs12); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA15 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 262 */     iFilterCallback27.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA15);
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
/* 280 */     Pairs pairs7 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 281 */     pairs7 = pairs7.add(Integer.valueOf(2), Integer.valueOf(0));
/* 282 */     pairs7 = pairs7.add(Integer.valueOf(0), Integer.valueOf(255));
/* 283 */     IVehicleFunction iVehicleFunction22 = VehicleFunction.intFunction(553780736); int[] arrayOfInt12 = COMMON_ON_OFF;
/* 284 */     iVehicleFunction22 = iVehicleFunction22.supportedFunctionValue(arrayOfInt12);
/* 285 */     IVehicleFunction.IZone iZone44 = iVehicleFunction22.createZone(); FunctionStatus functionStatus23 = FunctionStatus.active;
/* 286 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild57 = iZone44.fixStatus(functionStatus23);
/* 287 */     IVehicleFunction.IFilterCallback iFilterCallback40 = iValueTaskBuild57.useValueSignal(30512, pairs7); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA11 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/* 288 */     iFilterCallback40.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA11);
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
/* 304 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(553844992);
/* 305 */     iVehicleFunction16 = iVehicleFunction16.supportedFunctionValue(new int[] { 0, 1, 553844995, 553844996 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     IVehicleFunction.IZone iZone27 = iVehicleFunction16.createZone(new int[] { 4 });
/* 312 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild38 = iZone27.useStatusPAByIntBase(33805); -$$Lambda$Bcm$XIzEhQ2fdsOip21inX1qGIjr9Cs -$$Lambda$Bcm$XIzEhQ2fdsOip21inX1qGIjr9Cs = new -$$Lambda$Bcm$XIzEhQ2fdsOip21inX1qGIjr9Cs(this);
/* 313 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild56 = iValueTaskBuild38.onSetFunctionValue(-$$Lambda$Bcm$XIzEhQ2fdsOip21inX1qGIjr9Cs); -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4 -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO43 = new -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4(this);
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
/* 326 */     IVehicleFunction.IFilterCallback iFilterCallback26 = iValueTaskBuild56.useValuePAByIntBase(33809, -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO43);
/*     */ 
/*     */     
/* 329 */     IVehicleFunction.IZone iZone26 = iFilterCallback26.createZone(new int[] { 8 });
/* 330 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild37 = iZone26.useStatusPAByIntBase(33807); -$$Lambda$Bcm$ij92JdRIJAugKgnwVH49UZcLNGI -$$Lambda$Bcm$ij92JdRIJAugKgnwVH49UZcLNGI = new -$$Lambda$Bcm$ij92JdRIJAugKgnwVH49UZcLNGI(this);
/* 331 */     iValueTaskBuild37 = iValueTaskBuild37.onSetFunctionValue(-$$Lambda$Bcm$ij92JdRIJAugKgnwVH49UZcLNGI); -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4 -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO46 = new -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4(this);
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
/* 344 */     IVehicleFunction.IFilterCallback iFilterCallback25 = iValueTaskBuild37.useValuePAByIntBase(33810, -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO46);
/*     */ 
/*     */     
/* 347 */     IVehicleFunction.IZone iZone43 = iFilterCallback25.createZone(new int[] { 16 }); FunctionStatus functionStatus13 = FunctionStatus.active;
/* 348 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild36 = iZone43.fixStatus(functionStatus13); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager8 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager8); -$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY -$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY2 = new -$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY(eCarXCarVfsmallcycleManager8); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM8 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 349 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild55 = iValueTaskBuild36.onSetFunctionValue(-$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY2, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM8); -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4 -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO42 = new -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4(this);
/* 350 */     IVehicleFunction.IFilterCallback iFilterCallback24 = iValueTaskBuild55.useValuePAByIntBase(33860, -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO42);
/*     */     
/* 352 */     IVehicleFunction.IZone iZone42 = iFilterCallback24.createZone(new int[] { 32 }); FunctionStatus functionStatus12 = FunctionStatus.active;
/* 353 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild35 = iZone42.fixStatus(functionStatus12); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager7 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager7); -$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU -$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU2 = new -$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU(eCarXCarVfsmallcycleManager7); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM8 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 354 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild54 = iValueTaskBuild35.onSetFunctionValue(-$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU2, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM8); -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4 -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO41 = new -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4(this);
/* 355 */     IVehicleFunction.IFilterCallback iFilterCallback23 = iValueTaskBuild54.useValuePAByIntBase(33861, -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO41);
/*     */     
/* 357 */     IVehicleFunction.IZone iZone25 = iFilterCallback23.createZone(new int[] { 256 }); FunctionStatus functionStatus18 = FunctionStatus.active;
/* 358 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild34 = iZone25.fixStatus(functionStatus18); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager6 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager6); -$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q -$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q2 = new -$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q(eCarXCarVfsmallcycleManager6); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM6 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 359 */     iValueTaskBuild34 = iValueTaskBuild34.onSetFunctionValue(-$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q2, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM6); -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4 -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO45 = new -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4(this);
/* 360 */     IVehicleFunction.IFilterCallback iFilterCallback22 = iValueTaskBuild34.useValuePAByIntBase(33862, -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO45);
/*     */     
/* 362 */     IVehicleFunction.IZone iZone24 = iFilterCallback22.createZone(new int[] { 512 }); FunctionStatus functionStatus17 = FunctionStatus.active;
/* 363 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild33 = iZone24.fixStatus(functionStatus17); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager5 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager5); -$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I -$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I2 = new -$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I(eCarXCarVfsmallcycleManager5); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM5 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 364 */     iValueTaskBuild33 = iValueTaskBuild33.onSetFunctionValue(-$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I2, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM5); -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4 -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO44 = new -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO4(this);
/* 365 */     IVehicleFunction.IFilterCallback iFilterCallback21 = iValueTaskBuild33.useValuePAByIntBase(33863, -$$Lambda$Bcm$gR05JlF5KhNaDq07ispgbvklvO44);
/*     */     
/* 367 */     IVehicleFunction.IZone iZone41 = iFilterCallback21.createZone(new int[] { 48 }); FunctionStatus functionStatus11 = FunctionStatus.active;
/* 368 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild59 = iZone41.fixStatus(functionStatus11); -$$Lambda$Bcm$ezRIFEy3RCu5m8Mj42kWhyks6jQ -$$Lambda$Bcm$ezRIFEy3RCu5m8Mj42kWhyks6jQ = new -$$Lambda$Bcm$ezRIFEy3RCu5m8Mj42kWhyks6jQ(this); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM4 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 369 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild32 = iValueTaskBuild59.onSetFunctionValue(-$$Lambda$Bcm$ezRIFEy3RCu5m8Mj42kWhyks6jQ, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     IVehicleFunction.IZone iZone40 = iValueTaskBuild32.createZone(new int[] { 768 }); FunctionStatus functionStatus10 = FunctionStatus.active;
/* 376 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild53 = iZone40.fixStatus(functionStatus10); -$$Lambda$Bcm$nNY3Q-57uyPkFWD6lAn08Xf6lTE -$$Lambda$Bcm$nNY3Q-57uyPkFWD6lAn08Xf6lTE = new -$$Lambda$Bcm$nNY3Q-57uyPkFWD6lAn08Xf6lTE(this); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM2 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 377 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild31 = iValueTaskBuild53.onSetFunctionValue(-$$Lambda$Bcm$nNY3Q-57uyPkFWD6lAn08Xf6lTE, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 383 */     IVehicleFunction.IZone iZone39 = iValueTaskBuild31.createZone(new int[] { 272 }); FunctionStatus functionStatus9 = FunctionStatus.active;
/* 384 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iZone39.fixStatus(functionStatus9); -$$Lambda$Bcm$YL2J_N8ZPi5hByGJcx-EyJ8kXtI -$$Lambda$Bcm$YL2J_N8ZPi5hByGJcx-EyJ8kXtI = new -$$Lambda$Bcm$YL2J_N8ZPi5hByGJcx-EyJ8kXtI(this); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM7 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 385 */     iValueTaskBuild30 = iValueTaskBuild30.onSetFunctionValue(-$$Lambda$Bcm$YL2J_N8ZPi5hByGJcx-EyJ8kXtI, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 391 */     IVehicleFunction.IZone iZone23 = iValueTaskBuild30.createZone(new int[] { 544 }); FunctionStatus functionStatus16 = FunctionStatus.active;
/* 392 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild52 = iZone23.fixStatus(functionStatus16); -$$Lambda$Bcm$OND4Ayqqsf5NXhZFbcCS82bQMcc -$$Lambda$Bcm$OND4Ayqqsf5NXhZFbcCS82bQMcc = new -$$Lambda$Bcm$OND4Ayqqsf5NXhZFbcCS82bQMcc(this); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM1 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 393 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iValueTaskBuild52.onSetFunctionValue(-$$Lambda$Bcm$OND4Ayqqsf5NXhZFbcCS82bQMcc, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 399 */     IVehicleFunction.IZone iZone38 = iValueTaskBuild29.createZone(new int[] { 816 }); FunctionStatus functionStatus8 = FunctionStatus.active;
/*     */     
/* 401 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iZone38.fixStatus(functionStatus8); -$$Lambda$Bcm$RODZSLrHQACbZvfoDAM8a2q7bdE -$$Lambda$Bcm$RODZSLrHQACbZvfoDAM8a2q7bdE = new -$$Lambda$Bcm$RODZSLrHQACbZvfoDAM8a2q7bdE(this); -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM3 = new -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM(this);
/* 402 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild51 = iValueTaskBuild28.onSetFunctionValue(-$$Lambda$Bcm$RODZSLrHQACbZvfoDAM8a2q7bdE, -$$Lambda$Bcm$UywCEtfMaT6WqcfT_TthH5eHwwM3); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA10 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 411 */     iValueTaskBuild51.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA10);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 417 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.customFunction(553845504); int[] arrayOfInt11 = WINDOW_POS_VALUE;
/* 418 */     iVehicleFunction15 = iVehicleFunction15.supportedFunctionValue(arrayOfInt11);
/*     */     
/* 420 */     IVehicleFunction.IZone iZone22 = iVehicleFunction15.createZone(new int[] { 4 });
/* 421 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iZone22.useStatusPAByIntBase(33811); ECarXCarVfmisc2Manager eCarXCarVfmisc2Manager3 = this.mVfmisc2Mgr; Objects.requireNonNull(eCarXCarVfmisc2Manager3); -$$Lambda$eUOecOuBbKpb10ssOdkY0xdgK04 -$$Lambda$eUOecOuBbKpb10ssOdkY0xdgK04 = new -$$Lambda$eUOecOuBbKpb10ssOdkY0xdgK04(eCarXCarVfmisc2Manager3); -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac2 = new -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac(this);
/* 422 */     iValueTaskBuild27 = iValueTaskBuild27.onSetFunctionValue(-$$Lambda$eUOecOuBbKpb10ssOdkY0xdgK04, -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac2); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk8 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 423 */     IVehicleFunction.IFilterCallback iFilterCallback20 = iValueTaskBuild27.useValuePAByIntBase(33809, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk8);
/*     */ 
/*     */     
/* 426 */     IVehicleFunction.IZone iZone21 = iFilterCallback20.createZone(new int[] { 8 });
/* 427 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iZone21.useStatusPAByIntBase(33812); ECarXCarVfmisc2Manager eCarXCarVfmisc2Manager2 = this.mVfmisc2Mgr; Objects.requireNonNull(eCarXCarVfmisc2Manager2); -$$Lambda$QM_o4x3Lr1SsOYKux1FhR6PuphU -$$Lambda$QM_o4x3Lr1SsOYKux1FhR6PuphU = new -$$Lambda$QM_o4x3Lr1SsOYKux1FhR6PuphU(eCarXCarVfmisc2Manager2); -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3 = new -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac(this);
/* 428 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild50 = iValueTaskBuild26.onSetFunctionValue(-$$Lambda$QM_o4x3Lr1SsOYKux1FhR6PuphU, -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk5 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 429 */     IVehicleFunction.IFilterCallback iFilterCallback19 = iValueTaskBuild50.useValuePAByIntBase(33810, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk5);
/*     */ 
/*     */     
/* 432 */     IVehicleFunction.IZone iZone20 = iFilterCallback19.createZone(new int[] { 16 });
/* 433 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iZone20.useStatusPAByIntBase(33856); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager4 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager4); -$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY -$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY1 = new -$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY(eCarXCarVfsmallcycleManager4); -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3 = new -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac(this);
/* 434 */     iValueTaskBuild25 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$zEjDttGttkvmrMvYvc1Zg39ZIyY1, -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk7 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 435 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild25.useValuePAByIntBase(33860, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk7);
/*     */ 
/*     */     
/* 438 */     IVehicleFunction.IZone iZone19 = iFilterCallback18.createZone(new int[] { 32 });
/* 439 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iZone19.useStatusPAByIntBase(33857); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager3 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager3); -$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU -$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU1 = new -$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU(eCarXCarVfsmallcycleManager3); -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3 = new -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac(this);
/* 440 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild49 = iValueTaskBuild24.onSetFunctionValue(-$$Lambda$caT4ETLsQJZz8NW-nwqEGMm0xKU1, -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk4 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 441 */     IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild49.useValuePAByIntBase(33861, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk4);
/*     */ 
/*     */     
/* 444 */     IVehicleFunction.IZone iZone18 = iFilterCallback17.createZone(new int[] { 256 });
/* 445 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iZone18.useStatusPAByIntBase(33858); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager2 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager2); -$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q -$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q1 = new -$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q(eCarXCarVfsmallcycleManager2); -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3 = new -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac(this);
/* 446 */     iValueTaskBuild23 = iValueTaskBuild23.onSetFunctionValue(-$$Lambda$mxPNdg2Eub-Vju5r4LHAKh5Hs_Q1, -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac3); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk6 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 447 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild23.useValuePAByIntBase(33862, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk6);
/*     */ 
/*     */     
/* 450 */     IVehicleFunction.IZone iZone17 = iFilterCallback16.createZone(new int[] { 512 });
/* 451 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iZone17.useStatusPAByIntBase(33859); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager1 = this.mVfsmallMgr; Objects.requireNonNull(eCarXCarVfsmallcycleManager1); -$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I -$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I1 = new -$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I(eCarXCarVfsmallcycleManager1); -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac1 = new -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac(this);
/* 452 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild48 = iValueTaskBuild22.onSetFunctionValue(-$$Lambda$gniRRNvABewUwZvFd6UY0-qBx8I1, -$$Lambda$Bcm$yRVfSwmHO9LEJMrA-AmRBL9e4Ac1); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk3 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 453 */     IVehicleFunction.IFilterCallback iFilterCallback39 = iValueTaskBuild48.useValuePAByIntBase(33863, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk3); -$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I -$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I2 = new -$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I(this);
/*     */     
/* 455 */     iFilterCallback39.addTo(-$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I2);
/*     */ 
/*     */     
/* 458 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(553845760);
/* 459 */     iVehicleFunction14 = iVehicleFunction14.supportedFunctionValue(new int[] { 0, 1 });
/* 460 */     IVehicleFunction.IZone iZone16 = iVehicleFunction14.createZone();
/* 461 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iZone16.useStatusPAByIntBase(33813); ECarXCarVfmisc2Manager eCarXCarVfmisc2Manager1 = this.mVfmisc2Mgr; Objects.requireNonNull(eCarXCarVfmisc2Manager1); -$$Lambda$MUbTnZbu4JI5n2hNz6whaAbbkSY -$$Lambda$MUbTnZbu4JI5n2hNz6whaAbbkSY = new -$$Lambda$MUbTnZbu4JI5n2hNz6whaAbbkSY(eCarXCarVfmisc2Manager1);
/*     */     
/* 463 */     Pairs pairs13 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 464 */     pairs13 = pairs13.add(Integer.valueOf(0), Integer.valueOf(0));
/*     */     iValueTaskBuild21 = iValueTaskBuild21.onSetFunctionValue(-$$Lambda$MUbTnZbu4JI5n2hNz6whaAbbkSY, pairs13);
/* 466 */     Pairs pairs11 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 467 */     pairs11 = pairs11.add(Integer.valueOf(0), Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild21.useValuePAByIntBase(33813, pairs11); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA14 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/* 468 */     iFilterCallback15.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA14);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 475 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.customFunction(553846272);
/* 476 */     IVehicleFunction.IZone iZone37 = iVehicleFunction13.createZone(new int[] { 4 }); FunctionStatus functionStatus7 = FunctionStatus.active;
/* 477 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild47 = iZone37.fixStatus(functionStatus7); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk2 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 478 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild47.useValueSignal(30509, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk2);
/*     */     
/* 480 */     IVehicleFunction.IZone iZone36 = iFilterCallback14.createZone(new int[] { 8 }); FunctionStatus functionStatus6 = FunctionStatus.active;
/* 481 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild46 = iZone36.fixStatus(functionStatus6); -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk1 = new -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk(this);
/* 482 */     IVehicleFunction.IFilterCallback iFilterCallback38 = iValueTaskBuild46.useValueSignal(30506, -$$Lambda$Bcm$tWw7LBkD0VAVkEem4_O-wQTxDNk1); -$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I -$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I1 = new -$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I(this);
/*     */     
/* 484 */     iFilterCallback38.addTo(-$$Lambda$Bcm$QshaLZb2dcSOLnUClB_ywpw4-_I1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 490 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.intFunction(553976064); int[] arrayOfInt10 = COMMON_ON_OFF;
/* 491 */     iVehicleFunction12 = iVehicleFunction12.supportedFunctionValue(arrayOfInt10);
/* 492 */     IVehicleFunction.IZone iZone15 = iVehicleFunction12.createZone(new int[] { Integer.MIN_VALUE });
/* 493 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iZone15.useStatusPAByIntBase(33645); ECarXCarVfmiscManager eCarXCarVfmiscManager5 = this.mVfmiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager5); -$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ -$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ = new -$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ(eCarXCarVfmiscManager5);
/* 494 */     iValueTaskBuild20 = iValueTaskBuild20.onSetFunctionValue(-$$Lambda$7bcoBToVVUh1y0Z8hpjFl4yLzPQ, pairs4);
/* 495 */     IVehicleFunction.IFilterCallback iFilterCallback37 = iValueTaskBuild20.useValuePAByIntBase(33645, pairs2); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA9 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 497 */     iFilterCallback37.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA9);
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
/* 512 */     IVehicleFunction iVehicleFunction21 = VehicleFunction.intFunction(553977344); int[] arrayOfInt6 = COMMON_ON_OFF;
/* 513 */     IVehicleFunction iVehicleFunction11 = iVehicleFunction21.supportedFunctionValue(arrayOfInt6);
/* 514 */     IVehicleFunction.IZone iZone14 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE });
/* 515 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iZone14.useStatusPAByIntBase(33646); ECarXCarVfmiscManager eCarXCarVfmiscManager4 = this.mVfmiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager4); -$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI -$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI = new -$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI(eCarXCarVfmiscManager4);
/* 516 */     iValueTaskBuild19 = iValueTaskBuild19.onSetFunctionValue(-$$Lambda$CXdOhDuN2jfxQkPv9TozjmI1SQI, pairs4);
/* 517 */     IVehicleFunction.IFilterCallback iFilterCallback36 = iValueTaskBuild19.useValuePAByIntBase(33646, pairs2); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA8 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 519 */     iFilterCallback36.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA8);
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
/* 549 */     IVehicleFunction iVehicleFunction20 = VehicleFunction.intFunction(553979904); int[] arrayOfInt5 = COMMON_ON_OFF;
/* 550 */     IVehicleFunction iVehicleFunction10 = iVehicleFunction20.supportedFunctionValue(arrayOfInt5);
/* 551 */     IVehicleFunction.IZone iZone13 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE });
/* 552 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iZone13.useStatusPAByIntBase(33815); ECarXCarAmbliManager eCarXCarAmbliManager7 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager7); -$$Lambda$gsdh3-FKP2AGFBr7fgQvAHj8yHY -$$Lambda$gsdh3-FKP2AGFBr7fgQvAHj8yHY = new -$$Lambda$gsdh3-FKP2AGFBr7fgQvAHj8yHY(eCarXCarAmbliManager7);
/* 553 */     iValueTaskBuild18 = iValueTaskBuild18.onSetFunctionValue(-$$Lambda$gsdh3-FKP2AGFBr7fgQvAHj8yHY, pairs4);
/*     */     
/* 555 */     IVehicleFunction.IFilterCallback iFilterCallback35 = iValueTaskBuild18.useValuePAByIntBase(33815, pairs2); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA7 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 557 */     iFilterCallback35.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA7);
/*     */ 
/*     */     
/* 560 */     IVehicleFunction iVehicleFunction19 = VehicleFunction.intFunction(553980160); int[] arrayOfInt4 = COMMON_ON_OFF;
/* 561 */     IVehicleFunction iVehicleFunction9 = iVehicleFunction19.supportedFunctionValue(arrayOfInt4);
/* 562 */     IVehicleFunction.IZone iZone35 = iVehicleFunction9.createZone(); FunctionStatus functionStatus5 = FunctionStatus.active;
/* 563 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iZone35.fixStatus(functionStatus5);
/*     */     
/* 565 */     Pairs pairs10 = Pairs.of(Integer.valueOf(3), Integer.valueOf(1));
/* 566 */     pairs10 = pairs10.add(Integer.valueOf(0), Integer.valueOf(0));
/* 567 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(1));
/* 568 */     pairs10 = pairs10.add(Integer.valueOf(2), Integer.valueOf(0)); IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild17.useValueSignal(30451, pairs10); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA13 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/* 569 */     iFilterCallback13.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA13);
/*     */ 
/*     */ 
/*     */     
/* 573 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(553980416); int[] arrayOfInt9 = COMMON_ON_OFF;
/* 574 */     iVehicleFunction8 = iVehicleFunction8.supportedFunctionValue(arrayOfInt9);
/* 575 */     IVehicleFunction.IZone iZone34 = iVehicleFunction8.createZone(); FunctionStatus functionStatus4 = FunctionStatus.active;
/* 576 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iZone34.fixStatus(functionStatus4);
/*     */     
/* 578 */     Pairs pairs9 = Pairs.of(Integer.valueOf(3), Integer.valueOf(1));
/* 579 */     pairs9 = pairs9.add(Integer.valueOf(0), Integer.valueOf(0));
/* 580 */     pairs9 = pairs9.add(Integer.valueOf(1), Integer.valueOf(0));
/* 581 */     pairs9 = pairs9.add(Integer.valueOf(2), Integer.valueOf(1)); IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild16.useValueSignal(30451, pairs9); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA12 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/* 582 */     iFilterCallback12.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA12);
/*     */ 
/*     */ 
/*     */     
/* 586 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(553980672); int[] arrayOfInt8 = COMMON_ON_OFF;
/* 587 */     iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(arrayOfInt8);
/* 588 */     IVehicleFunction.IZone iZone12 = iVehicleFunction7.createZone(new int[] { 1 });
/* 589 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone12.useStatusPAByIntBase(33841); ECarXCarAmbliManager eCarXCarAmbliManager6 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager6); -$$Lambda$WNKi-qQKM4Jx7wniNu-HoIAWAps -$$Lambda$WNKi-qQKM4Jx7wniNu-HoIAWAps = new -$$Lambda$WNKi-qQKM4Jx7wniNu-HoIAWAps(eCarXCarAmbliManager6);
/* 590 */     iValueTaskBuild15 = iValueTaskBuild15.onSetFunctionValue(-$$Lambda$WNKi-qQKM4Jx7wniNu-HoIAWAps, pairs6);
/*     */     
/* 592 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild15.useValuePAByIntBase(33841, pairs5);
/*     */ 
/*     */     
/* 595 */     IVehicleFunction.IZone iZone11 = iFilterCallback11.createZone(new int[] { 4 });
/* 596 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone11.useStatusPAByIntBase(33842); ECarXCarAmbliManager eCarXCarAmbliManager5 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager5); -$$Lambda$DQqHNEaOiXEHbxcnD4I0Kk4YvJ0 -$$Lambda$DQqHNEaOiXEHbxcnD4I0Kk4YvJ0 = new -$$Lambda$DQqHNEaOiXEHbxcnD4I0Kk4YvJ0(eCarXCarAmbliManager5);
/* 597 */     iValueTaskBuild14 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$DQqHNEaOiXEHbxcnD4I0Kk4YvJ0, pairs6);
/*     */     
/* 599 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild14.useValuePAByIntBase(33842, pairs5);
/*     */ 
/*     */     
/* 602 */     IVehicleFunction.IZone iZone10 = iFilterCallback10.createZone(new int[] { 16 });
/* 603 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone10.useStatusPAByIntBase(33843); ECarXCarAmbliManager eCarXCarAmbliManager4 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager4); -$$Lambda$y1EuHieQQFrXuK9CEltb9DMuaPg -$$Lambda$y1EuHieQQFrXuK9CEltb9DMuaPg = new -$$Lambda$y1EuHieQQFrXuK9CEltb9DMuaPg(eCarXCarAmbliManager4);
/* 604 */     iValueTaskBuild13 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$y1EuHieQQFrXuK9CEltb9DMuaPg, pairs6);
/*     */     
/* 606 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild13.useValuePAByIntBase(33843, pairs5);
/*     */ 
/*     */     
/* 609 */     IVehicleFunction.IZone iZone9 = iFilterCallback9.createZone(new int[] { 64 });
/* 610 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone9.useStatusPAByIntBase(33844); ECarXCarAmbliManager eCarXCarAmbliManager3 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager3); -$$Lambda$usbT8_O3DYcC4Mu1Xu2w2xT8des -$$Lambda$usbT8_O3DYcC4Mu1Xu2w2xT8des = new -$$Lambda$usbT8_O3DYcC4Mu1Xu2w2xT8des(eCarXCarAmbliManager3);
/* 611 */     iValueTaskBuild12 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$usbT8_O3DYcC4Mu1Xu2w2xT8des, pairs6);
/*     */     
/* 613 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild12.useValuePAByIntBase(33844, pairs5);
/*     */ 
/*     */     
/* 616 */     IVehicleFunction.IZone iZone8 = iFilterCallback8.createZone(new int[] { 256 });
/* 617 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone8.useStatusPAByIntBase(33845); ECarXCarAmbliManager eCarXCarAmbliManager2 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager2); -$$Lambda$A2pf6U84eAPYkYrhqHDtyOhmx-k -$$Lambda$A2pf6U84eAPYkYrhqHDtyOhmx-k = new -$$Lambda$A2pf6U84eAPYkYrhqHDtyOhmx-k(eCarXCarAmbliManager2);
/* 618 */     iValueTaskBuild11 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$A2pf6U84eAPYkYrhqHDtyOhmx-k, pairs6);
/*     */     
/* 620 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild11.useValuePAByIntBase(33845, pairs5);
/*     */ 
/*     */     
/* 623 */     IVehicleFunction.IZone iZone7 = iFilterCallback7.createZone(new int[] { 1024 });
/* 624 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone7.useStatusPAByIntBase(33846); ECarXCarAmbliManager eCarXCarAmbliManager1 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager1); -$$Lambda$UtdIeJNeMImObMRXC484aCw9cqA -$$Lambda$UtdIeJNeMImObMRXC484aCw9cqA = new -$$Lambda$UtdIeJNeMImObMRXC484aCw9cqA(eCarXCarAmbliManager1);
/* 625 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$UtdIeJNeMImObMRXC484aCw9cqA, pairs6);
/*     */     
/* 627 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild9.useValuePAByIntBase(33846, pairs5); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA6 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 629 */     iFilterCallback6.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA6);
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
/* 656 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(554107136); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 657 */     IVehicleFunction iVehicleFunction5 = iVehicleFunction6.supportedFunctionValue(arrayOfInt2);
/* 658 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 659 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone5.useStatusPAByIntBase(33642); ECarXCarVfmiscManager eCarXCarVfmiscManager3 = this.mVfmiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager3); -$$Lambda$k5FTOkClIOVJ0Ty8xvOJ7A8GbqQ -$$Lambda$k5FTOkClIOVJ0Ty8xvOJ7A8GbqQ = new -$$Lambda$k5FTOkClIOVJ0Ty8xvOJ7A8GbqQ(eCarXCarVfmiscManager3);
/* 660 */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$k5FTOkClIOVJ0Ty8xvOJ7A8GbqQ, pairs4);
/*     */     
/* 662 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild8.useValuePAByIntBase(33642, pairs2); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA5 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 664 */     iFilterCallback5.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA5);
/*     */ 
/*     */     
/* 667 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(554696960); int[] arrayOfInt3 = COMMON_ON_OFF;
/* 668 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(arrayOfInt3);
/* 669 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 670 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone4.useStatusPAByIntBase(33643); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mVfmiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ -$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ = new -$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ(eCarXCarVfmiscManager2);
/* 671 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ, pairs4);
/* 672 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild5.useValuePAByIntBase(33643, pairs2); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA4 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 674 */     iFilterCallback2.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA4);
/*     */     
/* 676 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(554697216); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 677 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(arrayOfInt1);
/* 678 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { 4 }); FunctionStatus functionStatus3 = FunctionStatus.active;
/* 679 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone2.fixStatus(functionStatus3); -$$Lambda$Bcm$oSQXLe5qJ2X32-OoyG3fktfY5SI -$$Lambda$Bcm$oSQXLe5qJ2X32-OoyG3fktfY5SI = new -$$Lambda$Bcm$oSQXLe5qJ2X32-OoyG3fktfY5SI(this);
/* 680 */     iValueTaskBuild2 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$Bcm$oSQXLe5qJ2X32-OoyG3fktfY5SI); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA3 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
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
/* 691 */     iValueTaskBuild2.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 696 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(1));
/* 697 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(2));
/*     */     
/* 699 */     pairs1 = pairs1.add(Integer.valueOf(2), Integer.valueOf(3));
/* 700 */     pairs1 = pairs1.add(Integer.valueOf(3), Integer.valueOf(0));
/*     */     
/* 702 */     pairs1 = pairs1.add(Integer.valueOf(4), Integer.valueOf(4));
/*     */     
/* 704 */     pairs1 = pairs1.add(Integer.valueOf(5), Integer.valueOf(5));
/*     */     
/* 706 */     Pairs pairs3 = pairs1.add(Integer.valueOf(6), Integer.valueOf(6));
/*     */ 
/*     */     
/* 709 */     pairs1 = pairs3.reverse();
/* 710 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(554762496);
/* 711 */     IVehicleFunction.IZone iZone6 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$Bcm$Z7mEPzUaJfQ021oHwdHbcMsKO_U -$$Lambda$Bcm$Z7mEPzUaJfQ021oHwdHbcMsKO_U = new -$$Lambda$Bcm$Z7mEPzUaJfQ021oHwdHbcMsKO_U(this);
/* 712 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild1 = iZone6.supportedFunctionValue(-$$Lambda$Bcm$Z7mEPzUaJfQ021oHwdHbcMsKO_U, new int[] { 33693, 33692, 33691, 33690, 33689, 33694, 33707 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 720 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iStatusTaskBuild1.useStatusPAByIntBase(33693); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mVfmiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$XGafKz_wzSjnBa9HdZ8SYyII19E -$$Lambda$XGafKz_wzSjnBa9HdZ8SYyII19E = new -$$Lambda$XGafKz_wzSjnBa9HdZ8SYyII19E(eCarXCarVfmiscManager1);
/* 721 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$XGafKz_wzSjnBa9HdZ8SYyII19E, pairs3);
/*     */     
/* 723 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild4.useValuePAByIntBase(33688, pairs1); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA2 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 725 */     iFilterCallback4.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA2);
/*     */ 
/*     */     
/* 728 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(554762752);
/* 729 */     IVehicleFunction.IZone iZone3 = iVehicleFunction1.createZone(new int[] { 4 }); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 730 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone3.fixStatus(functionStatus1); -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc2 = -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc.INSTANCE;
/* 731 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValueSignal(30507, -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc2);
/*     */     
/* 733 */     IVehicleFunction.IZone iZone1 = iFilterCallback1.createZone(new int[] { 8 }); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 734 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone1.fixStatus(functionStatus2); -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc1 = -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc.INSTANCE;
/* 735 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild3.useValueSignal(30505, -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc1); -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA1 = new -$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA(this);
/*     */     
/* 737 */     iFilterCallback3.addTo(-$$Lambda$Bcm$Ip-Gct-tnH98NluQKF8zNQCGrEA1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] getSupportedHardKey() {
/* 744 */     ArrayList<Integer> arrayList = new ArrayList();
/* 745 */     if (getFunctionStatus(33693) != FunctionStatus.notavailable)
/*     */     {
/* 747 */       arrayList.add(Integer.valueOf(4));
/*     */     }
/* 749 */     if (getFunctionStatus(33692) != FunctionStatus.notavailable)
/*     */     {
/* 751 */       arrayList.add(Integer.valueOf(2));
/*     */     }
/* 753 */     if (getFunctionStatus(33691) != FunctionStatus.notavailable)
/*     */     {
/* 755 */       arrayList.add(Integer.valueOf(1));
/*     */     }
/* 757 */     if (getFunctionStatus(33690) != FunctionStatus.notavailable)
/*     */     {
/* 759 */       arrayList.add(Integer.valueOf(0));
/*     */     }
/* 761 */     if (getFunctionStatus(33689) != FunctionStatus.notavailable)
/*     */     {
/* 763 */       arrayList.add(Integer.valueOf(3));
/*     */     }
/* 765 */     if (getFunctionStatus(33694) != FunctionStatus.notavailable)
/*     */     {
/* 767 */       arrayList.add(Integer.valueOf(5));
/*     */     }
/* 769 */     if (getFunctionStatus(33707) != FunctionStatus.notavailable)
/*     */     {
/* 771 */       arrayList.add(Integer.valueOf(6));
/*     */     }
/*     */     
/* 774 */     return arrayList.stream().mapToInt(-$$Lambda$Bcm$gfCssnBJI7TKfXb_Jmv7raVYNkY.INSTANCE).toArray();
/*     */   }
/*     */   
/*     */   private int convertToWindowPos(int paramInt) {
/* 778 */     boolean bool = false;
/* 779 */     if (isEX11())
/* 780 */     { paramInt = this.mWindowPosSignalToApiPar.getKey((int)Math.floor((paramInt / 4.0F)) * 4, 0);
/*     */        }
/*     */     
/* 783 */     else if (paramInt != 553844994) { switch (paramInt) { default: paramInt = bool;
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
/* 799 */           return paramInt;case 1: paramInt = 26; return paramInt;case 0: break; }  paramInt = 1; } else { paramInt = 13; }  return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isEX11() {
/* 804 */     boolean bool = false; try { int i = this.mCarSignalManager.getcarconfig1();
/* 805 */       if (i == 161) bool = true;  return bool; }
/* 806 */     catch (CarNotConnectedException carNotConnectedException)
/* 807 */     { carNotConnectedException.printStackTrace();
/*     */       
/* 809 */       return false; }
/*     */   
/*     */   }
/*     */   
/*     */   private int convertToWindowControlType(int paramInt) {
/* 814 */     if (paramInt != 13) { if (paramInt != 26)
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 822 */         paramInt = 0; } else { paramInt = 1; }
/*     */        }
/*     */     else { paramInt = 553844994; }
/* 825 */      return paramInt;
/*     */   }
/*     */   
/*     */   private static class BidirectionalSparseIntArray {
/*     */     private SparseIntArray mMap;
/*     */     private SparseIntArray mReverseMap;
/*     */     
/*     */     public BidirectionalSparseIntArray(int[] param1ArrayOfint) {
/* 833 */       int i = param1ArrayOfint.length;
/* 834 */       if (i % 2 == 0) {
/*     */ 
/*     */ 
/*     */         
/* 838 */         this.mMap = new SparseIntArray(i / 2);
/* 839 */         this.mReverseMap = new SparseIntArray(i / 2);
/* 840 */         for (byte b = 0; b < i / 2; b++) {
/* 841 */           this.mMap.put(param1ArrayOfint[2 * b], param1ArrayOfint[2 * b + 1]);
/* 842 */           this.mReverseMap.put(param1ArrayOfint[2 * b + 1], param1ArrayOfint[2 * b]);
/*     */         } 
/*     */         return;
/*     */       } 
/*     */       throw new IllegalArgumentException("Odd number of key-value elements"); } public void put(int param1Int1, int param1Int2) {
/* 847 */       this.mMap.put(param1Int1, param1Int2);
/* 848 */       this.mReverseMap.put(param1Int2, param1Int1);
/*     */     }
/*     */     
/*     */     private int getValue(int param1Int1, int param1Int2) {
/* 852 */       return this.mMap.get(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     private int getKey(int param1Int1, int param1Int2) {
/* 856 */       return this.mReverseMap.get(param1Int1, param1Int2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Bcm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */