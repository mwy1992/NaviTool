/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarActivesafetyManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfcipwakeupManager;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ADAS
/*     */   extends AbsCarFunction
/*     */   implements IADAS
/*     */ {
/*  55 */   private final ArrayList<Integer> speedIndex = new ArrayList<>(); private int oldSpeedLimit;
/*     */   private ECarXCarVfcipwakeupManager mVfcIPWakeupManager;
/*     */   private ECarXCarVfsmallcycleManager mVFSmallCycleManager;
/*  58 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 };
/*     */   private ECarXCarVfmiscManager mVFMiscMgr;
/*     */   
/*     */   protected ADAS(Context paramContext) {
/*  62 */     super(paramContext, 671088640);
/*  63 */     this.speedIndex.add(Integer.valueOf(671482885));
/*  64 */     this.speedIndex.add(Integer.valueOf(671482884));
/*  65 */     this.speedIndex.add(Integer.valueOf(671482881));
/*  66 */     this.speedIndex.add(Integer.valueOf(671482882));
/*  67 */     this.speedIndex.add(Integer.valueOf(671482883));
/*     */   }
/*     */   private ECarXCarVfmisc2Manager mVFMisc2Mgr; private ECarXCarActivesafetyManager mActSafeMgr;
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  72 */     this.mActSafeMgr = this.mECarXCarSetManager.getECarXCarActivesafetyManager();
/*  73 */     this.mVFMiscMgr = this.mECarXCarSetManager.getECarXCarVfmiscManager();
/*  74 */     this.mVFMisc2Mgr = this.mECarXCarSetManager.getECarXCarVfmisc2Manager();
/*  75 */     this.mVfcIPWakeupManager = this.mECarXCarSetManager.getECarXCarVfcipwakeupManager();
/*  76 */     this.mVFSmallCycleManager = this.mECarXCarSetManager.getECarXCarVfsmallcycleManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  82 */     Pairs pairs1 = Pairs.of(Integer.valueOf(2), Integer.valueOf(671482881));
/*     */     
/*  84 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(671482884));
/*  85 */     pairs1 = pairs1.add(Integer.valueOf(0), Integer.valueOf(671482885));
/*  86 */     pairs1 = pairs1.add(Integer.valueOf(3), Integer.valueOf(671482882));
/*  87 */     Pairs pairs3 = pairs1.add(Integer.valueOf(4), Integer.valueOf(671482883));
/*     */ 
/*     */ 
/*     */     
/*  91 */     pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  92 */     Pairs pairs2 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*  93 */     pairs1 = pairs2.reverse();
/*     */ 
/*     */     
/*  96 */     IVehicleFunction iVehicleFunction40 = VehicleFunction.intFunction(537003520); int[] arrayOfInt11 = COMMON_ON_OFF;
/*  97 */     IVehicleFunction iVehicleFunction29 = iVehicleFunction40.supportedFunctionValue(arrayOfInt11);
/*  98 */     IVehicleFunction.IZone iZone31 = iVehicleFunction29.createZone(new int[] { Integer.MIN_VALUE });
/*  99 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild31 = iZone31.useStatusPAByIntBase(33869); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager = this.mVFSmallCycleManager; Objects.requireNonNull(eCarXCarVfsmallcycleManager); -$$Lambda$ZGqejLhBUyYK5C60s0wX1Qw-6zg -$$Lambda$ZGqejLhBUyYK5C60s0wX1Qw-6zg = new -$$Lambda$ZGqejLhBUyYK5C60s0wX1Qw-6zg(eCarXCarVfsmallcycleManager);
/* 100 */     iValueTaskBuild31 = iValueTaskBuild31.onSetFunctionValue(-$$Lambda$ZGqejLhBUyYK5C60s0wX1Qw-6zg, pairs2);
/*     */     
/* 102 */     IVehicleFunction.IFilterCallback iFilterCallback34 = iValueTaskBuild31.useValuePAByIntBase(33869, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs21 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 104 */     iFilterCallback34.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs21);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     IVehicleFunction iVehicleFunction28 = VehicleFunction.intFunction(537264640); int[] arrayOfInt22 = COMMON_ON_OFF;
/* 113 */     iVehicleFunction28 = iVehicleFunction28.supportedFunctionValue(arrayOfInt22);
/* 114 */     IVehicleFunction.IZone iZone30 = iVehicleFunction28.createZone(new int[] { Integer.MIN_VALUE });
/* 115 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus = iZone30.useStatusSignals(new int[] { 29508, 30788, 30779 }); -$$Lambda$ADAS$hqE7p4LhOeJoIzUPhTf_8VayQSA -$$Lambda$ADAS$hqE7p4LhOeJoIzUPhTf_8VayQSA = new -$$Lambda$ADAS$hqE7p4LhOeJoIzUPhTf_8VayQSA(this);
/*     */ 
/*     */     
/* 118 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild35 = iMultiSignalStatus.onStatusSignalChanged(-$$Lambda$ADAS$hqE7p4LhOeJoIzUPhTf_8VayQSA); -$$Lambda$ADAS$FV_6cn6fCQhZZ6ILoNqOFnqYUIY -$$Lambda$ADAS$FV_6cn6fCQhZZ6ILoNqOFnqYUIY = new -$$Lambda$ADAS$FV_6cn6fCQhZZ6ILoNqOFnqYUIY(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     iValueTaskBuild35 = iValueTaskBuild35.onSetFunctionValue(-$$Lambda$ADAS$FV_6cn6fCQhZZ6ILoNqOFnqYUIY); -$$Lambda$ADAS$K3HVZgu1aOq0CwT4tGVeJ2Hget8 -$$Lambda$ADAS$K3HVZgu1aOq0CwT4tGVeJ2Hget8 = -$$Lambda$ADAS$K3HVZgu1aOq0CwT4tGVeJ2Hget8.INSTANCE;
/*     */ 
/*     */ 
/*     */     
/* 133 */     IVehicleFunction.IFilterCallback iFilterCallback33 = iValueTaskBuild35.useValueSignal(28996, -$$Lambda$ADAS$K3HVZgu1aOq0CwT4tGVeJ2Hget8); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs20 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 135 */     iFilterCallback33.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs20);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     IVehicleFunction iVehicleFunction39 = VehicleFunction.intFunction(537265408); int[] arrayOfInt10 = COMMON_ON_OFF;
/* 142 */     IVehicleFunction iVehicleFunction27 = iVehicleFunction39.supportedFunctionValue(arrayOfInt10);
/* 143 */     IVehicleFunction.IZone iZone29 = iVehicleFunction27.createZone(new int[] { Integer.MIN_VALUE });
/* 144 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iZone29.useStatusPAByIntBase(33655); ECarXCarVfmiscManager eCarXCarVfmiscManager7 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager7); -$$Lambda$vKF0w6i_6itUl3Jjv_qW9M5pZZg -$$Lambda$vKF0w6i_6itUl3Jjv_qW9M5pZZg = new -$$Lambda$vKF0w6i_6itUl3Jjv_qW9M5pZZg(eCarXCarVfmiscManager7);
/* 145 */     iValueTaskBuild30 = iValueTaskBuild30.onSetFunctionValue(-$$Lambda$vKF0w6i_6itUl3Jjv_qW9M5pZZg, pairs2);
/*     */     
/* 147 */     IVehicleFunction.IFilterCallback iFilterCallback32 = iValueTaskBuild30.useValuePAByIntBase(33655, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs19 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 149 */     iFilterCallback32.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs19);
/*     */ 
/*     */     
/* 152 */     IVehicleFunction iVehicleFunction26 = VehicleFunction.intFunction(537329920); int[] arrayOfInt21 = COMMON_ON_OFF;
/* 153 */     iVehicleFunction26 = iVehicleFunction26.supportedFunctionValue(arrayOfInt21);
/* 154 */     IVehicleFunction.IZone iZone28 = iVehicleFunction26.createZone(new int[] { Integer.MIN_VALUE });
/* 155 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iZone28.useStatusPAByIntBase(33312); ECarXCarActivesafetyManager eCarXCarActivesafetyManager19 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager19); -$$Lambda$9HbUM9u717dtAq8eUUUICPxHu10 -$$Lambda$9HbUM9u717dtAq8eUUUICPxHu10 = new -$$Lambda$9HbUM9u717dtAq8eUUUICPxHu10(eCarXCarActivesafetyManager19);
/* 156 */     iValueTaskBuild29 = iValueTaskBuild29.onSetFunctionValue(-$$Lambda$9HbUM9u717dtAq8eUUUICPxHu10, pairs2);
/*     */     
/* 158 */     IVehicleFunction.IFilterCallback iFilterCallback31 = iValueTaskBuild29.useValuePAByIntBase(33312, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs18 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 160 */     iFilterCallback31.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs18);
/*     */ 
/*     */     
/* 163 */     IVehicleFunction iVehicleFunction25 = VehicleFunction.intFunction(537330176);
/* 164 */     iVehicleFunction25 = iVehicleFunction25.supportedFunctionValue(new int[] { 0, 537330177, 537330178, 537330179 });
/*     */ 
/*     */ 
/*     */     
/* 168 */     IVehicleFunction.IZone iZone27 = iVehicleFunction25.createZone(new int[] { Integer.MIN_VALUE });
/* 169 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iZone27.useStatusPAByIntBase(33313); ECarXCarActivesafetyManager eCarXCarActivesafetyManager18 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager18); -$$Lambda$XHQMTMxQoZ43FcPzA67OY0km3C8 -$$Lambda$XHQMTMxQoZ43FcPzA67OY0km3C8 = new -$$Lambda$XHQMTMxQoZ43FcPzA67OY0km3C8(eCarXCarActivesafetyManager18); -$$Lambda$ADAS$7B1pBYcmlcDKEzlYaSZDlvFUL8s -$$Lambda$ADAS$7B1pBYcmlcDKEzlYaSZDlvFUL8s = -$$Lambda$ADAS$7B1pBYcmlcDKEzlYaSZDlvFUL8s.INSTANCE;
/* 170 */     iValueTaskBuild28 = iValueTaskBuild28.onSetFunctionValue(-$$Lambda$XHQMTMxQoZ43FcPzA67OY0km3C8, -$$Lambda$ADAS$7B1pBYcmlcDKEzlYaSZDlvFUL8s);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     Pairs pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*     */     
/* 177 */     pairs10 = pairs10.add(Integer.valueOf(3), Integer.valueOf(537330179));
/*     */     
/* 179 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(537330177));
/*     */     
/* 181 */     pairs10 = pairs10.add(Integer.valueOf(2), Integer.valueOf(537330178)); IVehicleFunction.IFilterCallback iFilterCallback30 = iValueTaskBuild28.useValuePAByIntBase(33313, pairs10);
/*     */     -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs17 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/* 183 */     iFilterCallback30.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs17);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     Pairs pairs6 = Pairs.of(Integer.valueOf(537330945), Integer.valueOf(1));
/*     */     
/* 193 */     pairs6 = pairs6.add(Integer.valueOf(537330946), Integer.valueOf(2));
/* 194 */     pairs6 = pairs6.add(Integer.valueOf(0), Integer.valueOf(0));
/* 195 */     IVehicleFunction iVehicleFunction38 = VehicleFunction.intFunction(537330944);
/* 196 */     iVehicleFunction38 = iVehicleFunction38.supportedFunctionValue(new int[] { 0, 537330945, 537330946 });
/*     */ 
/*     */     
/* 199 */     IVehicleFunction.IZone iZone32 = iVehicleFunction38.createZone(new int[] { Integer.MIN_VALUE });
/* 200 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild34 = iZone32.useStatusPAByIntBase(33314); ECarXCarActivesafetyManager eCarXCarActivesafetyManager20 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager20); -$$Lambda$DaUS3Hb0i7AOtz94ryjkcTquYhU -$$Lambda$DaUS3Hb0i7AOtz94ryjkcTquYhU = new -$$Lambda$DaUS3Hb0i7AOtz94ryjkcTquYhU(eCarXCarActivesafetyManager20);
/* 201 */     iValueTaskBuild34 = iValueTaskBuild34.onSetFunctionValue(-$$Lambda$DaUS3Hb0i7AOtz94ryjkcTquYhU, pairs6);
/*     */     
/* 203 */     pairs6 = pairs6.reverse(); IVehicleFunction.IFilterCallback iFilterCallback29 = iValueTaskBuild34.useValuePAByIntBase(33314, pairs6); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs16 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/* 204 */     iFilterCallback29.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs16);
/*     */ 
/*     */     
/* 207 */     IVehicleFunction iVehicleFunction24 = VehicleFunction.intFunction(537331200); int[] arrayOfInt20 = COMMON_ON_OFF;
/* 208 */     iVehicleFunction24 = iVehicleFunction24.supportedFunctionValue(arrayOfInt20);
/* 209 */     IVehicleFunction.IZone iZone26 = iVehicleFunction24.createZone(new int[] { Integer.MIN_VALUE });
/* 210 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iZone26.useStatusPAByIntBase(33315); ECarXCarActivesafetyManager eCarXCarActivesafetyManager17 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager17); -$$Lambda$zp1bYEt0q13zP-Xo54awJyM-xWo -$$Lambda$zp1bYEt0q13zP-Xo54awJyM-xWo = new -$$Lambda$zp1bYEt0q13zP-Xo54awJyM-xWo(eCarXCarActivesafetyManager17);
/* 211 */     iValueTaskBuild27 = iValueTaskBuild27.onSetFunctionValue(-$$Lambda$zp1bYEt0q13zP-Xo54awJyM-xWo, pairs2);
/*     */     
/* 213 */     IVehicleFunction.IFilterCallback iFilterCallback28 = iValueTaskBuild27.useValuePAByIntBase(33315, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs15 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 215 */     iFilterCallback28.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs15);
/*     */ 
/*     */     
/* 218 */     IVehicleFunction iVehicleFunction23 = VehicleFunction.intFunction(537331456); int[] arrayOfInt19 = COMMON_ON_OFF;
/* 219 */     iVehicleFunction23 = iVehicleFunction23.supportedFunctionValue(arrayOfInt19);
/* 220 */     IVehicleFunction.IZone iZone25 = iVehicleFunction23.createZone(new int[] { Integer.MIN_VALUE });
/* 221 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iZone25.useStatusPAByIntBase(33307); ECarXCarActivesafetyManager eCarXCarActivesafetyManager16 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager16); -$$Lambda$F2c03bHrTE9-22B6dzcl1O2TJmY -$$Lambda$F2c03bHrTE9-22B6dzcl1O2TJmY = new -$$Lambda$F2c03bHrTE9-22B6dzcl1O2TJmY(eCarXCarActivesafetyManager16);
/* 222 */     iValueTaskBuild26 = iValueTaskBuild26.onSetFunctionValue(-$$Lambda$F2c03bHrTE9-22B6dzcl1O2TJmY, pairs2);
/*     */     
/* 224 */     IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild26.useValuePAByIntBase(33307, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs28 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 226 */     iFilterCallback15.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs28);
/*     */ 
/*     */     
/* 229 */     IVehicleFunction iVehicleFunction22 = VehicleFunction.intFunction(537331712);
/* 230 */     iVehicleFunction22 = iVehicleFunction22.supportedFunctionValue(new int[] { 537331715, 537331714, 537331713 });
/*     */ 
/*     */     
/* 233 */     IVehicleFunction.IZone iZone24 = iVehicleFunction22.createZone(new int[] { Integer.MIN_VALUE });
/* 234 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iZone24.useStatusPAByIntBase(33640); ECarXCarVfmiscManager eCarXCarVfmiscManager6 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager6); -$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0 -$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0 = new -$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0(eCarXCarVfmiscManager6);
/*     */     
/* 236 */     Pairs pairs11 = Pairs.of(Integer.valueOf(537331713), Integer.valueOf(1));
/* 237 */     pairs11 = pairs11.add(Integer.valueOf(537331714), Integer.valueOf(2));
/* 238 */     pairs11 = pairs11.add(Integer.valueOf(537331715), Integer.valueOf(3));
/*     */     iValueTaskBuild25 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$WrYem9F3X7-ZACryJOzKxXP0NC0, pairs11);
/* 240 */     Pairs pairs9 = Pairs.of(Integer.valueOf(1), Integer.valueOf(537331713));
/* 241 */     pairs9 = pairs9.add(Integer.valueOf(2), Integer.valueOf(537331714));
/* 242 */     pairs9 = pairs9.add(Integer.valueOf(3), Integer.valueOf(537331715)); IVehicleFunction.IFilterCallback iFilterCallback27 = iValueTaskBuild25.useValuePAByIntBase(33640, pairs9); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs14 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/* 243 */     iFilterCallback27.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs14);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     IVehicleFunction iVehicleFunction21 = VehicleFunction.intFunction(537332224); int[] arrayOfInt18 = COMMON_ON_OFF;
/* 250 */     iVehicleFunction21 = iVehicleFunction21.supportedFunctionValue(arrayOfInt18);
/* 251 */     IVehicleFunction.IZone iZone23 = iVehicleFunction21.createZone(new int[] { Integer.MIN_VALUE });
/* 252 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iZone23.useStatusPAByIntBase(33310); ECarXCarActivesafetyManager eCarXCarActivesafetyManager15 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager15); -$$Lambda$usY2XkX_ccNv7qmNgcClUIG1BE0 -$$Lambda$usY2XkX_ccNv7qmNgcClUIG1BE0 = new -$$Lambda$usY2XkX_ccNv7qmNgcClUIG1BE0(eCarXCarActivesafetyManager15);
/* 253 */     iValueTaskBuild24 = iValueTaskBuild24.onSetFunctionValue(-$$Lambda$usY2XkX_ccNv7qmNgcClUIG1BE0, pairs2);
/*     */     
/* 255 */     IVehicleFunction.IFilterCallback iFilterCallback26 = iValueTaskBuild24.useValuePAByIntBase(33310, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs13 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 257 */     iFilterCallback26.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs13);
/*     */ 
/*     */     
/* 260 */     IVehicleFunction iVehicleFunction20 = VehicleFunction.intFunction(537332480); int[] arrayOfInt17 = COMMON_ON_OFF;
/* 261 */     iVehicleFunction20 = iVehicleFunction20.supportedFunctionValue(arrayOfInt17);
/* 262 */     IVehicleFunction.IZone iZone22 = iVehicleFunction20.createZone(new int[] { Integer.MIN_VALUE });
/* 263 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iZone22.useStatusPAByIntBase(33302); ECarXCarActivesafetyManager eCarXCarActivesafetyManager14 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager14); -$$Lambda$OQVPoDgoeE07Wy2sEmwS8jEYuYc -$$Lambda$OQVPoDgoeE07Wy2sEmwS8jEYuYc = new -$$Lambda$OQVPoDgoeE07Wy2sEmwS8jEYuYc(eCarXCarActivesafetyManager14);
/* 264 */     iValueTaskBuild23 = iValueTaskBuild23.onSetFunctionValue(-$$Lambda$OQVPoDgoeE07Wy2sEmwS8jEYuYc, pairs2);
/*     */     
/* 266 */     IVehicleFunction.IFilterCallback iFilterCallback25 = iValueTaskBuild23.useValuePAByIntBase(33302, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs12 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 268 */     iFilterCallback25.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs12);
/*     */ 
/*     */     
/* 271 */     IVehicleFunction iVehicleFunction37 = VehicleFunction.intFunction(537332736); int[] arrayOfInt9 = COMMON_ON_OFF;
/* 272 */     IVehicleFunction iVehicleFunction19 = iVehicleFunction37.supportedFunctionValue(arrayOfInt9);
/* 273 */     IVehicleFunction.IZone iZone21 = iVehicleFunction19.createZone(new int[] { Integer.MIN_VALUE });
/* 274 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iZone21.useStatusPAByIntBase(33316); ECarXCarActivesafetyManager eCarXCarActivesafetyManager13 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager13); -$$Lambda$_c_oHpjB8kG2M7bEl1jHSwFmZyY -$$Lambda$_c_oHpjB8kG2M7bEl1jHSwFmZyY = new -$$Lambda$_c_oHpjB8kG2M7bEl1jHSwFmZyY(eCarXCarActivesafetyManager13); -$$Lambda$ADAS$yLgMAvm-wMihEjyHKN7t-RyMapA -$$Lambda$ADAS$yLgMAvm-wMihEjyHKN7t-RyMapA = -$$Lambda$ADAS$yLgMAvm-wMihEjyHKN7t-RyMapA.INSTANCE;
/* 275 */     iValueTaskBuild22 = iValueTaskBuild22.onSetFunctionValue(-$$Lambda$_c_oHpjB8kG2M7bEl1jHSwFmZyY, -$$Lambda$ADAS$yLgMAvm-wMihEjyHKN7t-RyMapA);
/* 276 */     IVehicleFunction.IFilterCallback iFilterCallback24 = iValueTaskBuild22.useValuePAByIntBase(33316, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs11 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 278 */     iFilterCallback24.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs11);
/*     */ 
/*     */ 
/*     */     
/* 282 */     IVehicleFunction iVehicleFunction36 = VehicleFunction.intFunction(537332992); int[] arrayOfInt8 = COMMON_ON_OFF;
/* 283 */     IVehicleFunction iVehicleFunction18 = iVehicleFunction36.supportedFunctionValue(arrayOfInt8);
/* 284 */     IVehicleFunction.IZone iZone20 = iVehicleFunction18.createZone(new int[] { Integer.MIN_VALUE });
/* 285 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iZone20.useStatusPAByIntBase(33300); ECarXCarActivesafetyManager eCarXCarActivesafetyManager12 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager12); -$$Lambda$i7v4Mdylwg3KsCnPMDCPhN63gr4 -$$Lambda$i7v4Mdylwg3KsCnPMDCPhN63gr4 = new -$$Lambda$i7v4Mdylwg3KsCnPMDCPhN63gr4(eCarXCarActivesafetyManager12);
/* 286 */     iValueTaskBuild21 = iValueTaskBuild21.onSetFunctionValue(-$$Lambda$i7v4Mdylwg3KsCnPMDCPhN63gr4, pairs2);
/*     */     
/* 288 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild21.useValuePAByIntBase(33300, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs27 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 290 */     iFilterCallback14.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs27);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     IVehicleFunction iVehicleFunction35 = VehicleFunction.intFunction(537333504); int[] arrayOfInt7 = COMMON_ON_OFF;
/* 300 */     IVehicleFunction iVehicleFunction17 = iVehicleFunction35.supportedFunctionValue(arrayOfInt7);
/* 301 */     IVehicleFunction.IZone iZone19 = iVehicleFunction17.createZone(new int[] { Integer.MIN_VALUE });
/* 302 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iZone19.useStatusPAByIntBase(33678); ECarXCarVfmiscManager eCarXCarVfmiscManager5 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager5); -$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg -$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg2 = new -$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg(eCarXCarVfmiscManager5);
/* 303 */     iValueTaskBuild20 = iValueTaskBuild20.onSetFunctionValue(-$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg2, pairs2);
/*     */     
/* 305 */     IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild20.useValuePAByIntBase(33678, pairs1);
/*     */ 
/*     */     
/* 308 */     IVehicleFunction.IZone iZone18 = iFilterCallback13.createZone(new int[] { 1 });
/* 309 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iZone18.useStatusPAByIntBase(33678); ECarXCarVfmiscManager eCarXCarVfmiscManager4 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager4); -$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg -$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg1 = new -$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg(eCarXCarVfmiscManager4);
/* 310 */     iValueTaskBuild19 = iValueTaskBuild19.onSetFunctionValue(-$$Lambda$QwPVJMRYxy8zstoRVxnYEJ_uIJg1, pairs2);
/*     */     
/* 312 */     IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild19.useValuePAByIntBase(33678, pairs1);
/*     */ 
/*     */     
/* 315 */     IVehicleFunction.IZone iZone17 = iFilterCallback12.createZone(new int[] { 4 });
/* 316 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iZone17.useStatusPAByIntBase(33679); ECarXCarVfmiscManager eCarXCarVfmiscManager3 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager3); -$$Lambda$eUN5fXPImDuXQjp639eXkY4obTU -$$Lambda$eUN5fXPImDuXQjp639eXkY4obTU = new -$$Lambda$eUN5fXPImDuXQjp639eXkY4obTU(eCarXCarVfmiscManager3);
/* 317 */     iValueTaskBuild18 = iValueTaskBuild18.onSetFunctionValue(-$$Lambda$eUN5fXPImDuXQjp639eXkY4obTU, pairs2);
/*     */     
/* 319 */     IVehicleFunction.IFilterCallback iFilterCallback23 = iValueTaskBuild18.useValuePAByIntBase(33679, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs10 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */ 
/*     */     
/* 322 */     iFilterCallback23.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs10);
/*     */ 
/*     */     
/* 325 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(537333760); int[] arrayOfInt16 = COMMON_ON_OFF;
/* 326 */     iVehicleFunction16 = iVehicleFunction16.supportedFunctionValue(arrayOfInt16);
/* 327 */     IVehicleFunction.IZone iZone16 = iVehicleFunction16.createZone(new int[] { Integer.MIN_VALUE });
/* 328 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iZone16.useStatusPAByIntBase(33309); ECarXCarActivesafetyManager eCarXCarActivesafetyManager11 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager11); -$$Lambda$sIymbkFcgrFm67WpFT86jaIJY7k -$$Lambda$sIymbkFcgrFm67WpFT86jaIJY7k = new -$$Lambda$sIymbkFcgrFm67WpFT86jaIJY7k(eCarXCarActivesafetyManager11);
/* 329 */     iValueTaskBuild17 = iValueTaskBuild17.onSetFunctionValue(-$$Lambda$sIymbkFcgrFm67WpFT86jaIJY7k, pairs2);
/*     */     
/* 331 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild17.useValuePAByIntBase(33309, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs26 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 333 */     iFilterCallback11.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs26);
/*     */ 
/*     */     
/* 336 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.intFunction(537592064); int[] arrayOfInt15 = COMMON_ON_OFF;
/* 337 */     iVehicleFunction15 = iVehicleFunction15.supportedFunctionValue(arrayOfInt15);
/* 338 */     IVehicleFunction.IZone iZone15 = iVehicleFunction15.createZone(new int[] { Integer.MIN_VALUE });
/* 339 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iZone15.useStatusPAByIntBase(33297); ECarXCarActivesafetyManager eCarXCarActivesafetyManager10 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager10); -$$Lambda$YG0LbX4It-rY5oUIVwPthRLZ_Y4 -$$Lambda$YG0LbX4It-rY5oUIVwPthRLZ_Y4 = new -$$Lambda$YG0LbX4It-rY5oUIVwPthRLZ_Y4(eCarXCarActivesafetyManager10);
/* 340 */     iValueTaskBuild16 = iValueTaskBuild16.onSetFunctionValue(-$$Lambda$YG0LbX4It-rY5oUIVwPthRLZ_Y4, pairs2);
/*     */     
/* 342 */     IVehicleFunction.IFilterCallback iFilterCallback22 = iValueTaskBuild16.useValuePAByIntBase(33297, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs9 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 344 */     iFilterCallback22.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs9);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 351 */     IVehicleFunction iVehicleFunction34 = VehicleFunction.intFunction(537788672); int[] arrayOfInt6 = COMMON_ON_OFF;
/* 352 */     IVehicleFunction iVehicleFunction14 = iVehicleFunction34.supportedFunctionValue(arrayOfInt6);
/* 353 */     IVehicleFunction.IZone iZone14 = iVehicleFunction14.createZone(new int[] { Integer.MIN_VALUE });
/* 354 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone14.useStatusPAByIntBase(33305); ECarXCarActivesafetyManager eCarXCarActivesafetyManager9 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager9); -$$Lambda$iCPk4AjbR7e7vQMypau0HPyew0g -$$Lambda$iCPk4AjbR7e7vQMypau0HPyew0g = new -$$Lambda$iCPk4AjbR7e7vQMypau0HPyew0g(eCarXCarActivesafetyManager9);
/* 355 */     iValueTaskBuild15 = iValueTaskBuild15.onSetFunctionValue(-$$Lambda$iCPk4AjbR7e7vQMypau0HPyew0g, pairs2);
/*     */     
/* 357 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild15.useValuePAByIntBase(33305, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs25 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 359 */     iFilterCallback10.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs25);
/*     */ 
/*     */     
/* 362 */     Pairs pairs5 = Pairs.of(Integer.valueOf(0), Integer.valueOf(1));
/*     */     
/* 364 */     pairs5 = pairs5.add(Integer.valueOf(537788929), Integer.valueOf(2));
/* 365 */     pairs5 = pairs5.add(Integer.valueOf(537788930), Integer.valueOf(3));
/* 366 */     Pairs pairs8 = pairs5.add(Integer.valueOf(537788931), Integer.valueOf(4));
/* 367 */     pairs5 = pairs8.reverse();
/*     */     
/* 369 */     IVehicleFunction iVehicleFunction42 = VehicleFunction.intFunction(537788928);
/* 370 */     iVehicleFunction42 = iVehicleFunction42.supportedFunctionValue(new int[] { 0, 537788929, 537788930, 537788931 });
/*     */ 
/*     */ 
/*     */     
/* 374 */     IVehicleFunction.IZone iZone34 = iVehicleFunction42.createZone(new int[] { Integer.MIN_VALUE });
/* 375 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild37 = iZone34.useStatusPAByIntBase(33306); ECarXCarActivesafetyManager eCarXCarActivesafetyManager22 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager22); -$$Lambda$8xhISzJqKNZpxKz68yWSfY3ZT50 -$$Lambda$8xhISzJqKNZpxKz68yWSfY3ZT50 = new -$$Lambda$8xhISzJqKNZpxKz68yWSfY3ZT50(eCarXCarActivesafetyManager22);
/* 376 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild33 = iValueTaskBuild37.onSetFunctionValue(-$$Lambda$8xhISzJqKNZpxKz68yWSfY3ZT50, pairs8);
/* 377 */     IVehicleFunction.IFilterCallback iFilterCallback21 = iValueTaskBuild33.useValuePAByIntBase(33306, pairs5); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs8 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 379 */     iFilterCallback21.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs8);
/*     */ 
/*     */     
/* 382 */     IVehicleFunction iVehicleFunction33 = VehicleFunction.intFunction(538050816); int[] arrayOfInt5 = COMMON_ON_OFF;
/* 383 */     IVehicleFunction iVehicleFunction13 = iVehicleFunction33.supportedFunctionValue(arrayOfInt5);
/* 384 */     IVehicleFunction.IZone iZone13 = iVehicleFunction13.createZone(new int[] { Integer.MIN_VALUE });
/* 385 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone13.useStatusPAByIntBase(33311); ECarXCarActivesafetyManager eCarXCarActivesafetyManager8 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager8); -$$Lambda$vJvyotFU2dkp8ZTX1IFWNsxzcIY -$$Lambda$vJvyotFU2dkp8ZTX1IFWNsxzcIY = new -$$Lambda$vJvyotFU2dkp8ZTX1IFWNsxzcIY(eCarXCarActivesafetyManager8);
/* 386 */     iValueTaskBuild14 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$vJvyotFU2dkp8ZTX1IFWNsxzcIY, pairs2);
/*     */     
/* 388 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild14.useValuePAByIntBase(33311, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs24 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 390 */     iFilterCallback9.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs24);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     IVehicleFunction iVehicleFunction32 = VehicleFunction.intFunction(671154432); int[] arrayOfInt4 = COMMON_ON_OFF;
/* 398 */     IVehicleFunction iVehicleFunction12 = iVehicleFunction32.supportedFunctionValue(arrayOfInt4);
/* 399 */     IVehicleFunction.IZone iZone12 = iVehicleFunction12.createZone(new int[] { Integer.MIN_VALUE });
/* 400 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone12.useStatusPAByIntBase(33301); ECarXCarActivesafetyManager eCarXCarActivesafetyManager7 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager7); -$$Lambda$7glidpUbrzYuDJLslU4E_tflIGs -$$Lambda$7glidpUbrzYuDJLslU4E_tflIGs = new -$$Lambda$7glidpUbrzYuDJLslU4E_tflIGs(eCarXCarActivesafetyManager7);
/* 401 */     iValueTaskBuild13 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$7glidpUbrzYuDJLslU4E_tflIGs, pairs2);
/*     */     
/* 403 */     IVehicleFunction.IFilterCallback iFilterCallback20 = iValueTaskBuild13.useValuePAByIntBase(33301, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs7 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 405 */     iFilterCallback20.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs7);
/*     */ 
/*     */ 
/*     */     
/* 409 */     IVehicleFunction iVehicleFunction31 = VehicleFunction.intFunction(671219968); int[] arrayOfInt3 = COMMON_ON_OFF;
/* 410 */     IVehicleFunction iVehicleFunction11 = iVehicleFunction31.supportedFunctionValue(arrayOfInt3);
/* 411 */     IVehicleFunction.IZone iZone11 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE });
/* 412 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone11.useStatusPAByIntBase(33304); ECarXCarActivesafetyManager eCarXCarActivesafetyManager6 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager6); -$$Lambda$OJZ2M429mXGpgu6kAs2HyCLqg_g -$$Lambda$OJZ2M429mXGpgu6kAs2HyCLqg_g = new -$$Lambda$OJZ2M429mXGpgu6kAs2HyCLqg_g(eCarXCarActivesafetyManager6);
/* 413 */     iValueTaskBuild12 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$OJZ2M429mXGpgu6kAs2HyCLqg_g, pairs2);
/*     */     
/* 415 */     IVehicleFunction.IFilterCallback iFilterCallback19 = iValueTaskBuild12.useValuePAByIntBase(33304, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs6 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 417 */     iFilterCallback19.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs6);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 424 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(671351040); int[] arrayOfInt14 = COMMON_ON_OFF;
/* 425 */     iVehicleFunction10 = iVehicleFunction10.supportedFunctionValue(arrayOfInt14);
/* 426 */     IVehicleFunction.IZone iZone10 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE });
/* 427 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone10.useStatusPAByIntBase(33295); ECarXCarActivesafetyManager eCarXCarActivesafetyManager5 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager5); -$$Lambda$X1pk-F1OscrSyEq0CjB-5mZLfNA -$$Lambda$X1pk-F1OscrSyEq0CjB-5mZLfNA = new -$$Lambda$X1pk-F1OscrSyEq0CjB-5mZLfNA(eCarXCarActivesafetyManager5);
/* 428 */     iValueTaskBuild11 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$X1pk-F1OscrSyEq0CjB-5mZLfNA, pairs2);
/*     */     
/* 430 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild11.useValuePAByIntBase(33295, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs5 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 432 */     iFilterCallback18.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs5);
/*     */ 
/*     */ 
/*     */     
/* 436 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.intFunction(671351296); int[] arrayOfInt13 = COMMON_ON_OFF;
/* 437 */     iVehicleFunction9 = iVehicleFunction9.supportedFunctionValue(arrayOfInt13);
/* 438 */     IVehicleFunction.IZone iZone9 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE });
/* 439 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone9.useStatusPAByIntBase(33308); ECarXCarActivesafetyManager eCarXCarActivesafetyManager4 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager4); -$$Lambda$B9IYZF0Ei-8Y5OBjMDOu0zq4cfk -$$Lambda$B9IYZF0Ei-8Y5OBjMDOu0zq4cfk = new -$$Lambda$B9IYZF0Ei-8Y5OBjMDOu0zq4cfk(eCarXCarActivesafetyManager4);
/* 440 */     iValueTaskBuild10 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$B9IYZF0Ei-8Y5OBjMDOu0zq4cfk, pairs2);
/*     */     
/* 442 */     IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild10.useValuePAByIntBase(33308, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs4 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 444 */     iFilterCallback17.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 454 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(671482112); int[] arrayOfInt12 = COMMON_ON_OFF;
/* 455 */     iVehicleFunction8 = iVehicleFunction8.supportedFunctionValue(arrayOfInt12);
/* 456 */     IVehicleFunction.IZone iZone8 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/* 457 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone8.useStatusPAByIntBase(33296); ECarXCarActivesafetyManager eCarXCarActivesafetyManager3 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager3); -$$Lambda$NeBmH-w_DdnGEhpL9Ts6tXZddQs -$$Lambda$NeBmH-w_DdnGEhpL9Ts6tXZddQs = new -$$Lambda$NeBmH-w_DdnGEhpL9Ts6tXZddQs(eCarXCarActivesafetyManager3);
/* 458 */     iValueTaskBuild9 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$NeBmH-w_DdnGEhpL9Ts6tXZddQs, pairs2);
/*     */     
/* 460 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild9.useValuePAByIntBase(33296, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs23 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 462 */     iFilterCallback8.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs23);
/*     */ 
/*     */ 
/*     */     
/* 466 */     Pairs pairs4 = Pairs.of(Integer.valueOf(671482369), Integer.valueOf(1));
/*     */     
/* 468 */     pairs4 = pairs4.add(Integer.valueOf(671482370), Integer.valueOf(2));
/* 469 */     Pairs pairs7 = pairs4.add(Integer.valueOf(671482371), Integer.valueOf(3));
/* 470 */     pairs4 = pairs7.reverse();
/* 471 */     IVehicleFunction iVehicleFunction41 = VehicleFunction.intFunction(671482368);
/* 472 */     iVehicleFunction41 = iVehicleFunction41.supportedFunctionValue(new int[] { 0, 671482369, 671482370, 671482371 });
/*     */ 
/*     */ 
/*     */     
/* 476 */     IVehicleFunction.IZone iZone33 = iVehicleFunction41.createZone(new int[] { Integer.MIN_VALUE });
/* 477 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild36 = iZone33.useStatusPAByIntBase(33298); ECarXCarActivesafetyManager eCarXCarActivesafetyManager21 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager21); -$$Lambda$xu68EyV-cvNVkTt3qlp7AT_YyTc -$$Lambda$xu68EyV-cvNVkTt3qlp7AT_YyTc = new -$$Lambda$xu68EyV-cvNVkTt3qlp7AT_YyTc(eCarXCarActivesafetyManager21);
/* 478 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild32 = iValueTaskBuild36.onSetFunctionValue(-$$Lambda$xu68EyV-cvNVkTt3qlp7AT_YyTc, pairs7);
/* 479 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild32.useValuePAByIntBase(33298, pairs4); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs3 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 481 */     iFilterCallback16.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs3);
/*     */ 
/*     */     
/* 484 */     IVehicleFunction iVehicleFunction30 = VehicleFunction.intFunction(671482624); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 485 */     IVehicleFunction iVehicleFunction7 = iVehicleFunction30.supportedFunctionValue(arrayOfInt2);
/* 486 */     IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/* 487 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone7.useStatusPAByIntBase(33294); ECarXCarActivesafetyManager eCarXCarActivesafetyManager2 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager2); -$$Lambda$5pn_iTK44C5TdFK_jCGfkHyC7Sc -$$Lambda$5pn_iTK44C5TdFK_jCGfkHyC7Sc = new -$$Lambda$5pn_iTK44C5TdFK_jCGfkHyC7Sc(eCarXCarActivesafetyManager2);
/* 488 */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$5pn_iTK44C5TdFK_jCGfkHyC7Sc, pairs2);
/*     */     
/* 490 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild8.useValuePAByIntBase(33294, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs22 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 492 */     iFilterCallback7.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs22);
/*     */ 
/*     */     
/* 495 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(671482880);
/* 496 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 671482881, 671482882, 671482883, 671482884, 671482885 });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 501 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/* 502 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone6.useStatusPAByIntBase(33299); ECarXCarActivesafetyManager eCarXCarActivesafetyManager1 = this.mActSafeMgr; Objects.requireNonNull(eCarXCarActivesafetyManager1); -$$Lambda$41H8-x5efMSjbZWWnaViIWZsNtQ -$$Lambda$41H8-x5efMSjbZWWnaViIWZsNtQ = new -$$Lambda$41H8-x5efMSjbZWWnaViIWZsNtQ(eCarXCarActivesafetyManager1); -$$Lambda$ADAS$ff7xQngmzMyyqzvIrHORyDNYttM -$$Lambda$ADAS$ff7xQngmzMyyqzvIrHORyDNYttM = new -$$Lambda$ADAS$ff7xQngmzMyyqzvIrHORyDNYttM(this, pairs3);
/* 503 */     iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$41H8-x5efMSjbZWWnaViIWZsNtQ, -$$Lambda$ADAS$ff7xQngmzMyyqzvIrHORyDNYttM);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 513 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild7.useValuePAByIntBase(33299, pairs3); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs2 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 515 */     iFilterCallback6.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs2);
/*     */ 
/*     */ 
/*     */     
/* 519 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.customFunction(671483136);
/* 520 */     IVehicleFunction.IZone iZone4 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 521 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone4.useStatusPAByIntBase(33664); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$UsOCh6En5q9cF1hSZyusUl9lQZo -$$Lambda$UsOCh6En5q9cF1hSZyusUl9lQZo = new -$$Lambda$UsOCh6En5q9cF1hSZyusUl9lQZo(eCarXCarVfmiscManager2); -$$Lambda$ADAS$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$ADAS$Cdx7vHInof1EQrtz2WxT4MQ7JiU = -$$Lambda$ADAS$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE; -$$Lambda$ADAS$lH25oncjPeoQhzb70-OGMeUs3MQ -$$Lambda$ADAS$lH25oncjPeoQhzb70-OGMeUs3MQ = new -$$Lambda$ADAS$lH25oncjPeoQhzb70-OGMeUs3MQ(this);
/* 522 */     iValueTaskBuild3 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$UsOCh6En5q9cF1hSZyusUl9lQZo, -$$Lambda$ADAS$Cdx7vHInof1EQrtz2WxT4MQ7JiU, -$$Lambda$ADAS$lH25oncjPeoQhzb70-OGMeUs3MQ); -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI2 = -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI.INSTANCE;
/*     */     
/* 524 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild3.useValuePAByIntBase(33664, -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI2); -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww4 = new -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww(this);
/* 525 */     iFilterCallback4.addTo(-$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww4);
/*     */ 
/*     */     
/* 528 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.customFunction(671483392);
/* 529 */     IVehicleFunction.IZone iZone3 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 530 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone3.useStatusPAByIntBase(33667); -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI1 = -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI.INSTANCE;
/* 531 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild6.useValuePAByIntBase(33667, -$$Lambda$ADAS$63YeFJYeCu5K77AI4V_SWugWqvI1); -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww3 = new -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww(this);
/*     */     
/* 533 */     iFilterCallback3.addTo(-$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww3);
/*     */ 
/*     */     
/* 536 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.customFunction(671483648);
/* 537 */     IVehicleFunction.IZone iZone5 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 538 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone5.fixStatus(functionStatus1); -$$Lambda$ADAS$eKET6My6EMQxXbTHEsqiA-vPJdU -$$Lambda$ADAS$eKET6My6EMQxXbTHEsqiA-vPJdU = -$$Lambda$ADAS$eKET6My6EMQxXbTHEsqiA-vPJdU.INSTANCE;
/* 539 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild5.customValue(-$$Lambda$ADAS$eKET6My6EMQxXbTHEsqiA-vPJdU); -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww2 = new -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww(this);
/* 540 */     iFilterCallback2.addTo(-$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww2);
/*     */ 
/*     */     
/* 543 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.customFunction(671483904);
/* 544 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 545 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone2.fixStatus(functionStatus2); -$$Lambda$ADAS$-VBk3LVCCJRQInnOK3JxcBYqn88 -$$Lambda$ADAS$-VBk3LVCCJRQInnOK3JxcBYqn88 = -$$Lambda$ADAS$-VBk3LVCCJRQInnOK3JxcBYqn88.INSTANCE;
/* 546 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild4.customValue(-$$Lambda$ADAS$-VBk3LVCCJRQInnOK3JxcBYqn88); -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww1 = new -$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww(this);
/* 547 */     iFilterCallback5.addTo(-$$Lambda$ADAS$nwPrtmZJtS8rWBXrGm4MaUZoVww1);
/*     */ 
/*     */     
/* 550 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(671484160); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 551 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(arrayOfInt1);
/* 552 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/* 553 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone1.useStatusPAByIntBase(33666); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mVFMiscMgr; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$tbeVk6p16p-k6C7EtJJ6B2pguzE -$$Lambda$tbeVk6p16p-k6C7EtJJ6B2pguzE = new -$$Lambda$tbeVk6p16p-k6C7EtJJ6B2pguzE(eCarXCarVfmiscManager1);
/* 554 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$tbeVk6p16p-k6C7EtJJ6B2pguzE, pairs2);
/*     */     
/* 556 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33666, pairs1); -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs1 = new -$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs(this);
/*     */     
/* 558 */     iFilterCallback1.addTo(-$$Lambda$ADAS$isFMY2exRbisABHoHK4v0LIZHLs1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getSpeedWarnMax() {
/* 603 */     int i = 120;
/*     */     try {
/* 605 */       PATypes.PA_SpeedWarnSpeedLimit pA_SpeedWarnSpeedLimit = this.mVFMiscMgr.getPA_SpeedWarnSpeedLimit();
/* 606 */       int j = pA_SpeedWarnSpeedLimit.getData();
/* 607 */     } catch (Exception exception) {
/* 608 */       exception.printStackTrace();
/*     */     } 
/* 610 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\ADAS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */