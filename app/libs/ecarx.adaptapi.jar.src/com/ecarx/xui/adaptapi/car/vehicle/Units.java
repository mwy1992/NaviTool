/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.provider.Settings;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSystemsettingManager;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Units
/*     */   extends AbsCarFunction
/*     */   implements IUnits
/*     */ {
/*     */   private static final String HOURS_12 = "12";
/*     */   private static final String HOURS_24 = "24";
/*     */   private ECarXCarSystemsettingManager mECarXCarSystemsettingManager;
/*     */   
/*     */   protected Units(Context paramContext) {
/*  37 */     super(paramContext, 620756992);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  42 */     this.mECarXCarSystemsettingManager = paramECarXCarSetManager.getECarXCarSystemsettingManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildFunctions() {
/*  49 */     Pairs pairs7 = Pairs.of(Integer.valueOf(620822785), Integer.valueOf(0));
/*     */     
/*  51 */     pairs7 = pairs7.add(Integer.valueOf(620822786), Integer.valueOf(1));
/*  52 */     pairs7 = pairs7.add(Integer.valueOf(620822787), Integer.valueOf(3));
/*  53 */     pairs7 = pairs7.add(Integer.valueOf(620822788), Integer.valueOf(2));
/*  54 */     Pairs pairs14 = pairs7.reverse();
/*  55 */     pairs14 = pairs14.add(Integer.valueOf(4), Integer.valueOf(620822785));
/*     */     
/*  57 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(620822784);
/*  58 */     iVehicleFunction8 = iVehicleFunction8.supportedFunctionValue(new int[] { 620822785, 620822786, 620822787, 620822788 });
/*     */ 
/*     */ 
/*     */     
/*  62 */     IVehicleFunction.IZone iZone8 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/*  63 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone8.useStatusPAByIntBase(33471); ECarXCarSystemsettingManager eCarXCarSystemsettingManager5 = this.mECarXCarSystemsettingManager; Objects.requireNonNull(eCarXCarSystemsettingManager5); -$$Lambda$30ZUTqkqL9DDa0Q47RVR7oZOTRY -$$Lambda$30ZUTqkqL9DDa0Q47RVR7oZOTRY = new -$$Lambda$30ZUTqkqL9DDa0Q47RVR7oZOTRY(eCarXCarSystemsettingManager5);
/*  64 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iValueTaskBuild15.onSetFunctionValue(-$$Lambda$30ZUTqkqL9DDa0Q47RVR7oZOTRY, pairs7);
/*     */     
/*  66 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild5.useValuePAByIntBase(33471, pairs14); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag6 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */     
/*  68 */     iFilterCallback8.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag6);
/*     */ 
/*     */ 
/*     */     
/*  72 */     Pairs pairs6 = Pairs.of(Integer.valueOf(620823041), Integer.valueOf(0));
/*  73 */     Pairs pairs13 = pairs6.add(Integer.valueOf(620823042), Integer.valueOf(1));
/*  74 */     pairs6 = pairs13.reverse();
/*  75 */     pairs6 = pairs6.add(Integer.valueOf(2), Integer.valueOf(620823041));
/*     */     
/*  77 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.intFunction(620823040);
/*  78 */     iVehicleFunction7 = iVehicleFunction7.supportedFunctionValue(new int[] { 620823041, 620823042 });
/*     */ 
/*     */     
/*  81 */     IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/*  82 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone7.useStatusPAByIntBase(33474); ECarXCarSystemsettingManager eCarXCarSystemsettingManager4 = this.mECarXCarSystemsettingManager; Objects.requireNonNull(eCarXCarSystemsettingManager4); -$$Lambda$t9B1Y1TEPkexhWRypjSOojjX52A -$$Lambda$t9B1Y1TEPkexhWRypjSOojjX52A = new -$$Lambda$t9B1Y1TEPkexhWRypjSOojjX52A(eCarXCarSystemsettingManager4);
/*  83 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$t9B1Y1TEPkexhWRypjSOojjX52A, pairs13);
/*     */     
/*  85 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild8.useValuePAByIntBase(33474, pairs6); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag8 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */     
/*  87 */     iFilterCallback2.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag8);
/*     */ 
/*     */ 
/*     */     
/*  91 */     Pairs pairs5 = Pairs.of(Integer.valueOf(620823297), Integer.valueOf(0));
/*  92 */     pairs5 = pairs5.add(Integer.valueOf(620823298), Integer.valueOf(1));
/*  93 */     Pairs pairs12 = pairs5.reverse();
/*  94 */     pairs12 = pairs12.add(Integer.valueOf(2), Integer.valueOf(620823297));
/*     */     
/*  96 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(620823296);
/*  97 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(new int[] { 620823297, 620823298 });
/*     */     
/*  99 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/* 100 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone6.useStatusPAByIntBase(33470); ECarXCarSystemsettingManager eCarXCarSystemsettingManager3 = this.mECarXCarSystemsettingManager; Objects.requireNonNull(eCarXCarSystemsettingManager3); -$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs -$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs = new -$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs(eCarXCarSystemsettingManager3);
/* 101 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$upsaV90d6UoSGJ8iYtMci8e7RNs, pairs5);
/*     */     
/* 103 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild4.useValuePAByIntBase(33470, pairs12); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag7 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */     
/* 105 */     iFilterCallback1.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag7);
/*     */ 
/*     */     
/* 108 */     Pairs pairs4 = Pairs.of(Integer.valueOf(620823553), Integer.valueOf(0));
/* 109 */     pairs4 = pairs4.add(Integer.valueOf(620823555), Integer.valueOf(1));
/* 110 */     pairs4 = pairs4.add(Integer.valueOf(620823554), Integer.valueOf(2));
/* 111 */     Pairs pairs11 = pairs4.reverse();
/* 112 */     pairs11 = pairs11.add(Integer.valueOf(3), Integer.valueOf(620823553));
/* 113 */     pairs11 = pairs11.add(Integer.valueOf(4), Integer.valueOf(620823553));
/*     */     
/* 115 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(620823552);
/* 116 */     iVehicleFunction5 = iVehicleFunction5.supportedFunctionValue(new int[] { 620823553, 620823554, 620823555 });
/*     */ 
/*     */     
/* 119 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/* 120 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone5.useStatusPAByIntBase(33475); ECarXCarSystemsettingManager eCarXCarSystemsettingManager2 = this.mECarXCarSystemsettingManager; Objects.requireNonNull(eCarXCarSystemsettingManager2); -$$Lambda$C4cyVAicFnVoIWdXiBMmD__6dN0 -$$Lambda$C4cyVAicFnVoIWdXiBMmD__6dN0 = new -$$Lambda$C4cyVAicFnVoIWdXiBMmD__6dN0(eCarXCarSystemsettingManager2);
/* 121 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$C4cyVAicFnVoIWdXiBMmD__6dN0, pairs4);
/*     */     
/* 123 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild3.useValuePAByIntBase(33475, pairs11); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag5 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */     
/* 125 */     iFilterCallback7.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag5);
/*     */ 
/*     */     
/* 128 */     Pairs pairs3 = Pairs.of(Integer.valueOf(620823809), Integer.valueOf(0));
/*     */     
/* 130 */     pairs3 = pairs3.add(Integer.valueOf(620823810), Integer.valueOf(1));
/* 131 */     Pairs pairs10 = pairs3.reverse();
/* 132 */     pairs10 = pairs10.add(Integer.valueOf(2), Integer.valueOf(620823809));
/*     */     
/* 134 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(620823808);
/* 135 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(new int[] { 620823809, 620823810 });
/*     */     
/* 137 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/* 138 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone4.useStatusPAByIntBase(33472); ECarXCarSystemsettingManager eCarXCarSystemsettingManager1 = this.mECarXCarSystemsettingManager; Objects.requireNonNull(eCarXCarSystemsettingManager1); -$$Lambda$SL51oG-ErOKgSPY6HA9aaqlVfUU -$$Lambda$SL51oG-ErOKgSPY6HA9aaqlVfUU = new -$$Lambda$SL51oG-ErOKgSPY6HA9aaqlVfUU(eCarXCarSystemsettingManager1);
/* 139 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$SL51oG-ErOKgSPY6HA9aaqlVfUU, pairs3);
/*     */     
/* 141 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild2.useValuePAByIntBase(33472, pairs10); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag4 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */     
/* 143 */     iFilterCallback6.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag4);
/*     */ 
/*     */     
/* 146 */     Pairs pairs2 = Pairs.of(Integer.valueOf(620888322), Integer.valueOf(0));
/*     */     
/* 148 */     Pairs pairs9 = pairs2.add(Integer.valueOf(620888321), Integer.valueOf(1));
/* 149 */     pairs2 = pairs9.reverse();
/* 150 */     pairs2 = pairs2.add(Integer.valueOf(2), Integer.valueOf(620888322));
/*     */     
/* 152 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(620888320);
/* 153 */     iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(new int[] { 620888321, 620888322 });
/*     */     
/* 155 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/* 156 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone3.useStatusPAByIntBase(33468); -$$Lambda$Units$ZqUiXQ1W3bTaQMwvQyaCvxxUc_E -$$Lambda$Units$ZqUiXQ1W3bTaQMwvQyaCvxxUc_E = new -$$Lambda$Units$ZqUiXQ1W3bTaQMwvQyaCvxxUc_E(this, pairs9);
/* 157 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$Units$ZqUiXQ1W3bTaQMwvQyaCvxxUc_E);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild7.useValuePAByIntBase(33468, pairs2); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag3 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */     
/* 167 */     iFilterCallback5.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag3);
/*     */ 
/*     */ 
/*     */     
/* 171 */     Pairs pairs1 = Pairs.of(Integer.valueOf(620888577), Integer.valueOf(0));
/* 172 */     pairs1 = pairs1.add(Integer.valueOf(620888578), Integer.valueOf(2));
/* 173 */     Pairs pairs8 = pairs1.add(Integer.valueOf(620888579), Integer.valueOf(1));
/* 174 */     pairs1 = pairs8.reverse();
/* 175 */     pairs1 = pairs1.add(Integer.valueOf(3), Integer.valueOf(620888577));
/* 176 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(620888576);
/* 177 */     iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(new int[] { 620888577, 620888578, 620888579 });
/*     */ 
/*     */ 
/*     */     
/* 181 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/* 182 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone2.useStatusPAByIntBase(33469); -$$Lambda$Units$P7Un45q8D7kqgb8YLiYYslP1zZ8 -$$Lambda$Units$P7Un45q8D7kqgb8YLiYYslP1zZ8 = new -$$Lambda$Units$P7Un45q8D7kqgb8YLiYYslP1zZ8(this, pairs8);
/* 183 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$Units$P7Un45q8D7kqgb8YLiYYslP1zZ8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild6.useValuePAByIntBase(33469, pairs1); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag2 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */     
/* 193 */     iFilterCallback4.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag2);
/*     */ 
/*     */     
/* 196 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(620888832);
/* 197 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 620823809, 620823810 });
/* 198 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/* 199 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useStatusPAByIntBase(33667); -$$Lambda$Units$on1bL_2KuJ8RbWzKsIbYrV_Ff1o -$$Lambda$Units$on1bL_2KuJ8RbWzKsIbYrV_Ff1o = -$$Lambda$Units$on1bL_2KuJ8RbWzKsIbYrV_Ff1o.INSTANCE;
/* 200 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild1.useValuePA(33667, -$$Lambda$Units$on1bL_2KuJ8RbWzKsIbYrV_Ff1o); -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag1 = new -$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     iFilterCallback3.addTo(-$$Lambda$Units$Pjrbganf-I0D4dtayyubzLQ21Ag1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void update24HourFormat(Context paramContext, Boolean paramBoolean) {
/*     */     boolean bool;
/*     */     String str;
/* 217 */     if (paramBoolean == null) { str = null; } else if (paramBoolean.booleanValue()) { str = "24"; } else { str = "12"; }
/* 218 */      Settings.System.putString(paramContext.getContentResolver(), "time_12_24", str);
/*     */     
/* 220 */     Intent intent = new Intent("android.intent.action.TIME_SET");
/* 221 */     intent.addFlags(16777216);
/*     */     
/* 223 */     if (paramBoolean == null)
/* 224 */     { bool = true; }
/*     */     
/* 226 */     else if (paramBoolean.booleanValue()) { bool = true; }
/* 227 */     else { bool = false; }
/*     */     
/* 229 */     intent.putExtra("android.intent.extra.TIME_PREF_24_HOUR_FORMAT", bool);
/* 230 */     paramContext.sendBroadcast(intent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void setDateFormat(Context paramContext, int paramInt) {
/* 237 */     String str = "yyyy/mm/dd";
/* 238 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 620888579:
/* 246 */         str = "mm/dd/yyyy"; break;
/*     */       case 620888578:
/*     */         str = "dd/mm/yyyy"; break;
/*     */       case 620888577:
/*     */         str = "yyyy/mm/dd"; break;
/*     */     } 
/* 252 */     Settings.System.putString(paramContext.getContentResolver(), "date_format", str);
/* 253 */     paramContext.sendBroadcast(new Intent("android.intent.action.DATE_CHANGED"));
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Units.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */