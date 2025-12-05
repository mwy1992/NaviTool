/*      */ package com.ecarx.xui.adaptapi.car.hev;
/*      */ 
/*      */ import android.content.Context;
/*      */ import android.os.RemoteException;
/*      */ import android.util.Log;
/*      */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*      */ import com.ecarx.xui.adaptapi.SignalUtils;
/*      */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*      */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*      */ import com.ecarx.xui.adaptapi.car.Pairs;
/*      */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVehchargManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfcipwakeupManager;
/*      */ import ecarx.car.hardware.vehicle.PATypes;
/*      */ import ecarx.tcam.ITcamServiceCallback;
/*      */ import ecarx.tcam.TcamManager;
/*      */ import ecarx.tcam.TcamServiceCallbackImpl;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.concurrent.CopyOnWriteArrayList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Charging
/*      */   extends AbsCarFunction
/*      */   implements ICharging
/*      */ {
/*   56 */   private static final int[] ChargingPlugState = new int[] { 255, 605225473, 605225474, 605225475, 605225476, 605225477, 605225478, 605225479, 605225480, 605225481, 605225482, 605225483, 605225484 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   72 */   private static final int[] PreChargingStatus = new int[] { 255, 605094913, 605094914, 605094915, 605094916, 605094917, 605094918 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*   80 */     COMMON_ON_OFF = new int[] { 1, 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  123 */     mCalendarArray = new Calendar[2];
/*  124 */   } private int rangeTarget = -1; private static final int CAR_CONFIG_OK = 3; private static final int CB_CURRENT_STEP = 100; private static final float CHARGING_CURRENT_MAX = 64.0F; private static final float CHARGING_CURRENT_MIN = 5.0F; private static final float CHARGING_CURRENT_STEP = 1.0F; private static final int CHARGING_LEN = 21; private static final float CHARGING_SOC_MAX = 100.0F; private static final float CHARGING_SOC_MIN = 50.0F;
/*  125 */   private int electricCurrent = -1; private static final float CHARGING_SOC_STEP = 1.0F; private static final int[] COMMON_ON_OFF; private static final int DEFAULT = 0; private static final int DISCHARGING_MIN = 20; private static final float DISCHARGING_SOC_MAX = 100.0F; private static final float DISCHARGING_SOC_MIN = 20.0F;
/*      */   private static final float DISCHARGING_SOC_STEP = 1.0F;
/*      */   private static final int EGY_INDEX = 10;
/*      */   
/*      */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  130 */     this.mChargMgr = paramECarXCarSetManager.getECarXCarVehchargManager();
/*  131 */     this.mVfcipwakeupManager = paramECarXCarSetManager.getECarXCarVfcipwakeupManager();
/*      */   }
/*      */   private static final int ITEM_INDEX = 20; private static final int LOCAL_BOOK_CHARGE_MAX = 100; private static final float LOCAL_BOOK_CHARGE_MIN = 50.0F; private static final int MAX_SIZE = 2; private static final long MILLISSECONDS = 1000L; private static final float PA_CURRENT_STEP = 0.1F; private static final float PA_VOLTAGE_STEP = 0.25F; private static final int START_CHARGE = 1; private static final int START_TIME = 0; private static final int STOP_TIME = 1; private static final String TAG = "Charging"; private static Calendar[] mCalendarArray; private ECarXCarVehchargManager mChargMgr; private final CopyOnWriteArrayList<ICharging.IChargingListener> mChargingListeners;
/*      */   private TcamManager mTcamManager;
/*      */   private ECarXCarVfcipwakeupManager mVfcipwakeupManager;
/*      */   
/*      */   protected void buildFunctions() {
/*  138 */     Pairs pairs = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  139 */     pairs = pairs.add(Integer.valueOf(1), Integer.valueOf(1));
/*  140 */     pairs.reverse();
/*      */     
/*  142 */     IVehicleFunction iVehicleFunction33 = VehicleFunction.intFunction(605225216);
/*  143 */     iVehicleFunction33 = iVehicleFunction33.supportedFunctionValue(new int[] { 255, 605225217, 605225218, 605225219 });
/*      */     
/*  145 */     IVehicleFunction.IZone iZone33 = iVehicleFunction33.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus = FunctionStatus.active;
/*  146 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iZone33.fixStatus(functionStatus); -$$Lambda$Charging$zbpM6kL3wWJBkMRcThrAVvWUU6I -$$Lambda$Charging$zbpM6kL3wWJBkMRcThrAVvWUU6I = new -$$Lambda$Charging$zbpM6kL3wWJBkMRcThrAVvWUU6I(this);
/*  147 */     IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild21.useValueSignal(31435, -$$Lambda$Charging$zbpM6kL3wWJBkMRcThrAVvWUU6I); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo12 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */     
/*  149 */     iFilterCallback13.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo12);
/*      */ 
/*      */     
/*  152 */     IVehicleFunction iVehicleFunction32 = VehicleFunction.intFunction(605225472); int[] arrayOfInt5 = ChargingPlugState;
/*  153 */     iVehicleFunction32 = iVehicleFunction32.supportedFunctionValue(arrayOfInt5);
/*  154 */     IVehicleFunction.IZone iZone32 = iVehicleFunction32.createZone(new int[] { Integer.MIN_VALUE });
/*  155 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild38 = iZone32.useStatusPAByIntBase(33784); -$$Lambda$Charging$CmqIRdj_DEVtQ8nJ1LKnaiYTJQ0 -$$Lambda$Charging$CmqIRdj_DEVtQ8nJ1LKnaiYTJQ0 = -$$Lambda$Charging$CmqIRdj_DEVtQ8nJ1LKnaiYTJQ0.INSTANCE;
/*  156 */     IVehicleFunction.IFilterCallback iFilterCallback33 = iValueTaskBuild38.useValuePAByIntBase(33803, -$$Lambda$Charging$CmqIRdj_DEVtQ8nJ1LKnaiYTJQ0); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo8 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */ 
/*      */     
/*  159 */     iFilterCallback33.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo8);
/*      */ 
/*      */     
/*  162 */     IVehicleFunction iVehicleFunction31 = VehicleFunction.intFunction(605094144); int[] arrayOfInt4 = COMMON_ON_OFF;
/*  163 */     iVehicleFunction31 = iVehicleFunction31.supportedFunctionValue(arrayOfInt4);
/*  164 */     IVehicleFunction.IZone iZone31 = iVehicleFunction31.createZone(new int[] { Integer.MIN_VALUE });
/*  165 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus22 = iZone31.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik3 = new -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik(this);
/*      */ 
/*      */     
/*  168 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iMultiSignalStatus22.onStatusSignalChanged(-$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik3); -$$Lambda$Charging$nudhTdpbf4Ip0lyka-PwiR_tv44 -$$Lambda$Charging$nudhTdpbf4Ip0lyka-PwiR_tv44 = new -$$Lambda$Charging$nudhTdpbf4Ip0lyka-PwiR_tv44(this);
/*  169 */     iValueTaskBuild20 = iValueTaskBuild20.onSetFunctionValue(-$$Lambda$Charging$nudhTdpbf4Ip0lyka-PwiR_tv44); -$$Lambda$Charging$Y8PtKPpmyq87eAIUvtaqRgbxs3Q -$$Lambda$Charging$Y8PtKPpmyq87eAIUvtaqRgbxs3Q = new -$$Lambda$Charging$Y8PtKPpmyq87eAIUvtaqRgbxs3Q(this);
/*  170 */     IVehicleFunction.IFilterCallback iFilterCallback32 = iValueTaskBuild20.useValueSignal(31616, -$$Lambda$Charging$Y8PtKPpmyq87eAIUvtaqRgbxs3Q); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo7 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  183 */     iFilterCallback32.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo7);
/*      */ 
/*      */     
/*  186 */     IVehicleFunction iVehicleFunction30 = VehicleFunction.intFunction(605094912); int[] arrayOfInt3 = PreChargingStatus;
/*  187 */     iVehicleFunction30 = iVehicleFunction30.supportedFunctionValue(arrayOfInt3);
/*  188 */     IVehicleFunction.IZone iZone30 = iVehicleFunction30.createZone(new int[] { Integer.MIN_VALUE });
/*  189 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus8 = iZone30.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik4 = new -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik(this);
/*      */ 
/*      */     
/*  192 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iMultiSignalStatus8.onStatusSignalChanged(-$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik4);
/*  193 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue2 = iValueTaskBuild19.useValueSignals(new int[] { 31390, 31324 }); -$$Lambda$Charging$BykwI7RGuSKa-poOf6ZSxOoceN0 -$$Lambda$Charging$BykwI7RGuSKa-poOf6ZSxOoceN0 = new -$$Lambda$Charging$BykwI7RGuSKa-poOf6ZSxOoceN0(this);
/*      */     
/*  195 */     IVehicleFunction.IFilterCallback iFilterCallback31 = iMultiSignalValue2.onValueSignalChanged(-$$Lambda$Charging$BykwI7RGuSKa-poOf6ZSxOoceN0); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo6 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  206 */     iFilterCallback31.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo6);
/*      */ 
/*      */     
/*  209 */     IVehicleFunction iVehicleFunction29 = VehicleFunction.customFunction(605094400);
/*  210 */     IVehicleFunction.IZone iZone29 = iVehicleFunction29.createZone(new int[] { Integer.MIN_VALUE });
/*  211 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus21 = iZone29.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik2 = new -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik(this);
/*      */ 
/*      */     
/*  214 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iMultiSignalStatus21.onStatusSignalChanged(-$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik2); -$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A -$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A2 = new -$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A(this);
/*  215 */     iValueTaskBuild18 = iValueTaskBuild18.onSetFunctionValue(-$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A2); -$$Lambda$Charging$mCZ88KlMBi4_-rnn54WVTxsYejQ -$$Lambda$Charging$mCZ88KlMBi4_-rnn54WVTxsYejQ = -$$Lambda$Charging$mCZ88KlMBi4_-rnn54WVTxsYejQ.INSTANCE;
/*  216 */     IVehicleFunction.IFilterCallback iFilterCallback30 = iValueTaskBuild18.useValuePAByIntBase(33786, -$$Lambda$Charging$mCZ88KlMBi4_-rnn54WVTxsYejQ); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE12 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  217 */     iFilterCallback30.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE12);
/*      */ 
/*      */     
/*  220 */     IVehicleFunction iVehicleFunction28 = VehicleFunction.customFunction(605094656);
/*  221 */     IVehicleFunction.IZone iZone28 = iVehicleFunction28.createZone(new int[] { Integer.MIN_VALUE });
/*  222 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus20 = iZone28.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik1 = new -$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik(this);
/*      */ 
/*      */     
/*  225 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iMultiSignalStatus20.onStatusSignalChanged(-$$Lambda$Charging$sOBFefu0S2mqogltHZeR_Eyyiik1); -$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k -$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k2 = new -$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k(this);
/*  226 */     iValueTaskBuild17 = iValueTaskBuild17.onSetFunctionValue(-$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k2);
/*  227 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue1 = iValueTaskBuild17.useValueSignals(new int[] { 31312, 31432 }); -$$Lambda$Charging$NI-DHeVMEfbWSMSUO5S9Uux0CCI -$$Lambda$Charging$NI-DHeVMEfbWSMSUO5S9Uux0CCI = new -$$Lambda$Charging$NI-DHeVMEfbWSMSUO5S9Uux0CCI(this);
/*      */ 
/*      */     
/*  230 */     IVehicleFunction.IFilterCallback iFilterCallback12 = iMultiSignalValue1.onValueSignalChanged(-$$Lambda$Charging$NI-DHeVMEfbWSMSUO5S9Uux0CCI); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE21 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  235 */     iFilterCallback12.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE21);
/*      */ 
/*      */     
/*  238 */     IVehicleFunction iVehicleFunction27 = VehicleFunction.customFunction(605029888);
/*  239 */     IVehicleFunction.IZone iZone27 = iVehicleFunction27.createZone(new int[] { Integer.MIN_VALUE });
/*  240 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus19 = iZone27.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ5 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  243 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iMultiSignalStatus19.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ5); -$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k -$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k1 = new -$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k(this);
/*  244 */     iValueTaskBuild16 = iValueTaskBuild16.onSetFunctionValue(-$$Lambda$Charging$dfCdzse6tFsjjZfoQ5bS28ajW0k1);
/*  245 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue3 = iValueTaskBuild16.useValueSignals(new int[] { 31312, 31432 }); -$$Lambda$Charging$Itl2LXesmSQFBFQQhz01ERzt4ko -$$Lambda$Charging$Itl2LXesmSQFBFQQhz01ERzt4ko = new -$$Lambda$Charging$Itl2LXesmSQFBFQQhz01ERzt4ko(this);
/*      */ 
/*      */     
/*  248 */     IVehicleFunction.IFilterCallback iFilterCallback29 = iMultiSignalValue3.onValueSignalChanged(-$$Lambda$Charging$Itl2LXesmSQFBFQQhz01ERzt4ko); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE11 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  253 */     iFilterCallback29.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE11);
/*      */     
/*  255 */     IVehicleFunction iVehicleFunction26 = VehicleFunction.customFunction(605030656);
/*  256 */     IVehicleFunction.IZone iZone26 = iVehicleFunction26.createZone(new int[] { Integer.MIN_VALUE });
/*  257 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus7 = iZone26.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ8 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  260 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild37 = iMultiSignalStatus7.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ8); -$$Lambda$Charging$ZG1Y-hDFLJEsAgFkhS7Kx_-rNpM -$$Lambda$Charging$ZG1Y-hDFLJEsAgFkhS7Kx_-rNpM = -$$Lambda$Charging$ZG1Y-hDFLJEsAgFkhS7Kx_-rNpM.INSTANCE;
/*  261 */     IVehicleFunction.IFilterCallback iFilterCallback28 = iValueTaskBuild37.customValue(-$$Lambda$Charging$ZG1Y-hDFLJEsAgFkhS7Kx_-rNpM); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE10 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  262 */     iFilterCallback28.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE10);
/*      */     
/*  264 */     IVehicleFunction iVehicleFunction25 = VehicleFunction.customFunction(605030400);
/*  265 */     IVehicleFunction.IZone iZone25 = iVehicleFunction25.createZone(new int[] { Integer.MIN_VALUE });
/*  266 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus18 = iZone25.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ4 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  269 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iMultiSignalStatus18.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ4); -$$Lambda$Charging$b2OKrYDTu6qhaYUpXZFCEA-BqqE -$$Lambda$Charging$b2OKrYDTu6qhaYUpXZFCEA-BqqE = -$$Lambda$Charging$b2OKrYDTu6qhaYUpXZFCEA-BqqE.INSTANCE;
/*  270 */     IVehicleFunction.IFilterCallback iFilterCallback27 = iValueTaskBuild15.customValue(-$$Lambda$Charging$b2OKrYDTu6qhaYUpXZFCEA-BqqE); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE9 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  271 */     iFilterCallback27.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE9);
/*      */     
/*  273 */     IVehicleFunction iVehicleFunction24 = VehicleFunction.customFunction(605030144);
/*  274 */     IVehicleFunction.IZone iZone24 = iVehicleFunction24.createZone(new int[] { Integer.MIN_VALUE });
/*  275 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus17 = iZone24.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ3 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  278 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild36 = iMultiSignalStatus17.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ3); -$$Lambda$Charging$JxPItVIW6kdap3BscCs-G5RWl68 -$$Lambda$Charging$JxPItVIW6kdap3BscCs-G5RWl68 = -$$Lambda$Charging$JxPItVIW6kdap3BscCs-G5RWl68.INSTANCE;
/*  279 */     IVehicleFunction.IFilterCallback iFilterCallback26 = iValueTaskBuild36.customValue(-$$Lambda$Charging$JxPItVIW6kdap3BscCs-G5RWl68); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE8 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  280 */     iFilterCallback26.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE8);
/*      */ 
/*      */     
/*  283 */     IVehicleFunction iVehicleFunction23 = VehicleFunction.customFunction(605028864);
/*  284 */     IVehicleFunction.IZone iZone23 = iVehicleFunction23.createZone(new int[] { Integer.MIN_VALUE });
/*  285 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus6 = iZone23.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ7 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  288 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild35 = iMultiSignalStatus6.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ7); -$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A -$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A1 = new -$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A(this);
/*  289 */     iValueTaskBuild35 = iValueTaskBuild35.onSetFunctionValue(-$$Lambda$Charging$S3ZLA2mWu0Gr8rAxG8tsMHxtD-A1); -$$Lambda$Charging$c0PX_3rjoBAObZD6AMES--ZeXEc -$$Lambda$Charging$c0PX_3rjoBAObZD6AMES--ZeXEc = -$$Lambda$Charging$c0PX_3rjoBAObZD6AMES--ZeXEc.INSTANCE;
/*  290 */     IVehicleFunction.IFilterCallback iFilterCallback25 = iValueTaskBuild35.useValueSignal(31392, -$$Lambda$Charging$c0PX_3rjoBAObZD6AMES--ZeXEc); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE7 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  291 */     iFilterCallback25.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE7);
/*      */     
/*  293 */     IVehicleFunction iVehicleFunction22 = VehicleFunction.customFunction(605029632);
/*  294 */     IVehicleFunction.IZone iZone22 = iVehicleFunction22.createZone(new int[] { Integer.MIN_VALUE });
/*  295 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus16 = iZone22.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ2 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  298 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iMultiSignalStatus16.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ2); -$$Lambda$Charging$RpMMgsuuDZq2NiNsdzLgsJeXfsE -$$Lambda$Charging$RpMMgsuuDZq2NiNsdzLgsJeXfsE = -$$Lambda$Charging$RpMMgsuuDZq2NiNsdzLgsJeXfsE.INSTANCE;
/*  299 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild14.customValue(-$$Lambda$Charging$RpMMgsuuDZq2NiNsdzLgsJeXfsE); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE20 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  300 */     iFilterCallback11.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE20);
/*      */     
/*  302 */     IVehicleFunction iVehicleFunction21 = VehicleFunction.customFunction(605029376);
/*  303 */     IVehicleFunction.IZone iZone21 = iVehicleFunction21.createZone(new int[] { Integer.MIN_VALUE });
/*  304 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus5 = iZone21.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ6 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  307 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iMultiSignalStatus5.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ6); -$$Lambda$Charging$1VHeEplGM6CmTwRYgopSQFcHBC4 -$$Lambda$Charging$1VHeEplGM6CmTwRYgopSQFcHBC4 = -$$Lambda$Charging$1VHeEplGM6CmTwRYgopSQFcHBC4.INSTANCE;
/*  308 */     IVehicleFunction.IFilterCallback iFilterCallback24 = iValueTaskBuild13.customValue(-$$Lambda$Charging$1VHeEplGM6CmTwRYgopSQFcHBC4); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE6 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  309 */     iFilterCallback24.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE6);
/*      */     
/*  311 */     IVehicleFunction iVehicleFunction20 = VehicleFunction.customFunction(605029120);
/*  312 */     IVehicleFunction.IZone iZone20 = iVehicleFunction20.createZone(new int[] { Integer.MIN_VALUE });
/*  313 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus15 = iZone20.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ1 = new -$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ(this);
/*      */ 
/*      */     
/*  316 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iMultiSignalStatus15.onStatusSignalChanged(-$$Lambda$Charging$yaw3qjldDMjcdIT5z6BhySareSQ1); -$$Lambda$Charging$DFWmYFElFP8jLpqNzsCSln4U-HM -$$Lambda$Charging$DFWmYFElFP8jLpqNzsCSln4U-HM = -$$Lambda$Charging$DFWmYFElFP8jLpqNzsCSln4U-HM.INSTANCE;
/*  317 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild12.customValue(-$$Lambda$Charging$DFWmYFElFP8jLpqNzsCSln4U-HM); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE19 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  318 */     iFilterCallback10.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE19);
/*      */ 
/*      */ 
/*      */     
/*  322 */     IVehicleFunction iVehicleFunction19 = VehicleFunction.customFunction(605291264);
/*  323 */     IVehicleFunction.IZone iZone19 = iVehicleFunction19.createZone(new int[] { Integer.MIN_VALUE });
/*  324 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone19.useStatusPAByIntBase(33788); -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI2 = -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI.INSTANCE;
/*  325 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild11.useValuePAByIntBase(33802, -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI2); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE18 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */ 
/*      */     
/*  328 */     iFilterCallback9.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE18);
/*      */ 
/*      */     
/*  331 */     IVehicleFunction iVehicleFunction18 = VehicleFunction.customFunction(605290752);
/*  332 */     IVehicleFunction.IZone iZone18 = iVehicleFunction18.createZone(new int[] { Integer.MIN_VALUE });
/*  333 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild34 = iZone18.useStatusPAByIntBase(33788); -$$Lambda$Charging$2ZTQZv29KmA5LIR59sz-dSEO3NQ -$$Lambda$Charging$2ZTQZv29KmA5LIR59sz-dSEO3NQ = -$$Lambda$Charging$2ZTQZv29KmA5LIR59sz-dSEO3NQ.INSTANCE;
/*  334 */     IVehicleFunction.IFilterCallback iFilterCallback23 = iValueTaskBuild34.useValuePAByIntBase(33800, -$$Lambda$Charging$2ZTQZv29KmA5LIR59sz-dSEO3NQ); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE5 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */     
/*  336 */     iFilterCallback23.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE5);
/*      */ 
/*      */     
/*  339 */     IVehicleFunction iVehicleFunction17 = VehicleFunction.customFunction(605291008);
/*  340 */     IVehicleFunction.IZone iZone17 = iVehicleFunction17.createZone(new int[] { Integer.MIN_VALUE });
/*  341 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone17.useStatusPAByIntBase(33788); -$$Lambda$Charging$th6XqdV-xrJIAZ1BC24pFhbMWkE -$$Lambda$Charging$th6XqdV-xrJIAZ1BC24pFhbMWkE = -$$Lambda$Charging$th6XqdV-xrJIAZ1BC24pFhbMWkE.INSTANCE;
/*  342 */     IVehicleFunction.IFilterCallback iFilterCallback22 = iValueTaskBuild10.useValuePAByIntBase(33801, -$$Lambda$Charging$th6XqdV-xrJIAZ1BC24pFhbMWkE); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE4 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */     
/*  344 */     iFilterCallback22.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  358 */     IVehicleFunction iVehicleFunction35 = VehicleFunction.intFunction(605028608); int[] arrayOfInt2 = COMMON_ON_OFF;
/*  359 */     IVehicleFunction iVehicleFunction16 = iVehicleFunction35.supportedFunctionValue(arrayOfInt2);
/*  360 */     IVehicleFunction.IZone iZone16 = iVehicleFunction16.createZone(new int[] { Integer.MIN_VALUE });
/*  361 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus4 = iZone16.useStatusSignals(new int[] { 29337, 30788, 30779, 31435, 33803 }); -$$Lambda$Charging$IL42DKozxCf6SAG5RqdgJo9SDMo -$$Lambda$Charging$IL42DKozxCf6SAG5RqdgJo9SDMo = new -$$Lambda$Charging$IL42DKozxCf6SAG5RqdgJo9SDMo(this);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  366 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iMultiSignalStatus4.onStatusSignalChanged(-$$Lambda$Charging$IL42DKozxCf6SAG5RqdgJo9SDMo); -$$Lambda$Charging$CBqKXeIqg2sXdDB_AKM0gLEACWs -$$Lambda$Charging$CBqKXeIqg2sXdDB_AKM0gLEACWs = new -$$Lambda$Charging$CBqKXeIqg2sXdDB_AKM0gLEACWs(this);
/*  367 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild33 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$Charging$CBqKXeIqg2sXdDB_AKM0gLEACWs); -$$Lambda$Charging$z__6v5nJXUrknzdantu4cW-Cmxs -$$Lambda$Charging$z__6v5nJXUrknzdantu4cW-Cmxs = new -$$Lambda$Charging$z__6v5nJXUrknzdantu4cW-Cmxs(this);
/*  368 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild33.useValuePAByIntBase(33803, -$$Lambda$Charging$z__6v5nJXUrknzdantu4cW-Cmxs); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo11 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */ 
/*      */     
/*  371 */     iFilterCallback8.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo11);
/*      */ 
/*      */     
/*  374 */     IVehicleFunction iVehicleFunction34 = VehicleFunction.intFunction(605031936); int[] arrayOfInt1 = COMMON_ON_OFF;
/*  375 */     IVehicleFunction iVehicleFunction15 = iVehicleFunction34.supportedFunctionValue(arrayOfInt1);
/*  376 */     IVehicleFunction.IZone iZone15 = iVehicleFunction15.createZone(new int[] { Integer.MIN_VALUE });
/*  377 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus14 = iZone15.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$tcXu4qfVTAGWnJ9Ad0liPvbaKYE -$$Lambda$Charging$tcXu4qfVTAGWnJ9Ad0liPvbaKYE = new -$$Lambda$Charging$tcXu4qfVTAGWnJ9Ad0liPvbaKYE(this);
/*      */ 
/*      */     
/*  380 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild32 = iMultiSignalStatus14.onStatusSignalChanged(-$$Lambda$Charging$tcXu4qfVTAGWnJ9Ad0liPvbaKYE); -$$Lambda$Charging$Zay4aMLWtAuCrf821IJsNLdTmWw -$$Lambda$Charging$Zay4aMLWtAuCrf821IJsNLdTmWw = new -$$Lambda$Charging$Zay4aMLWtAuCrf821IJsNLdTmWw(this);
/*  381 */     iValueTaskBuild32 = iValueTaskBuild32.onSetFunctionValue(-$$Lambda$Charging$Zay4aMLWtAuCrf821IJsNLdTmWw); -$$Lambda$Charging$582LjztmIW9cibMOGRWDw5oTjSk -$$Lambda$Charging$582LjztmIW9cibMOGRWDw5oTjSk = new -$$Lambda$Charging$582LjztmIW9cibMOGRWDw5oTjSk(this);
/*  382 */     IVehicleFunction.IFilterCallback iFilterCallback21 = iValueTaskBuild32.useValueSignal(30404, -$$Lambda$Charging$582LjztmIW9cibMOGRWDw5oTjSk); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo5 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */     
/*  384 */     iFilterCallback21.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo5);
/*      */ 
/*      */     
/*  387 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.customFunction(605160192);
/*  388 */     IVehicleFunction.IZone iZone14 = iVehicleFunction14.createZone(new int[] { Integer.MIN_VALUE });
/*  389 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus3 = iZone14.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E5 = new -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E(this);
/*      */ 
/*      */     
/*  392 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild31 = iMultiSignalStatus3.onStatusSignalChanged(-$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E5); -$$Lambda$Charging$EQJq2q8avPStAFy-Xl5IWlG6gdU -$$Lambda$Charging$EQJq2q8avPStAFy-Xl5IWlG6gdU = new -$$Lambda$Charging$EQJq2q8avPStAFy-Xl5IWlG6gdU(this);
/*  393 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iValueTaskBuild31.onSetFunctionValue(-$$Lambda$Charging$EQJq2q8avPStAFy-Xl5IWlG6gdU); -$$Lambda$Charging$wdr6E-njeoLrAEa8bE0MtL6Pcw8 -$$Lambda$Charging$wdr6E-njeoLrAEa8bE0MtL6Pcw8 = new -$$Lambda$Charging$wdr6E-njeoLrAEa8bE0MtL6Pcw8(this);
/*  394 */     IVehicleFunction.IFilterCallback iFilterCallback20 = iValueTaskBuild8.useValueSignal(31398, -$$Lambda$Charging$wdr6E-njeoLrAEa8bE0MtL6Pcw8); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE3 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */     
/*  396 */     iFilterCallback20.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE3);
/*      */ 
/*      */     
/*  399 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.customFunction(605160448);
/*  400 */     IVehicleFunction.IZone iZone13 = iVehicleFunction13.createZone(new int[] { Integer.MIN_VALUE });
/*  401 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus13 = iZone13.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E3 = new -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E(this);
/*      */ 
/*      */     
/*  404 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iMultiSignalStatus13.onStatusSignalChanged(-$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E3); -$$Lambda$Charging$itK_6aArziwxjgxiEcjsVIZ_owM -$$Lambda$Charging$itK_6aArziwxjgxiEcjsVIZ_owM = -$$Lambda$Charging$itK_6aArziwxjgxiEcjsVIZ_owM.INSTANCE;
/*  405 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild30.customValue(-$$Lambda$Charging$itK_6aArziwxjgxiEcjsVIZ_owM); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE17 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  406 */     iFilterCallback7.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE17);
/*      */ 
/*      */     
/*  409 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.customFunction(605160704);
/*  410 */     IVehicleFunction.IZone iZone12 = iVehicleFunction12.createZone(new int[] { Integer.MIN_VALUE });
/*  411 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus12 = iZone12.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E2 = new -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E(this);
/*      */ 
/*      */     
/*  414 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iMultiSignalStatus12.onStatusSignalChanged(-$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E2); -$$Lambda$Charging$Aa080s3SgynfRk-Hwn6QqVX8IkY -$$Lambda$Charging$Aa080s3SgynfRk-Hwn6QqVX8IkY = -$$Lambda$Charging$Aa080s3SgynfRk-Hwn6QqVX8IkY.INSTANCE;
/*  415 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild7.customValue(-$$Lambda$Charging$Aa080s3SgynfRk-Hwn6QqVX8IkY); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE16 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  416 */     iFilterCallback6.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE16);
/*      */ 
/*      */     
/*  419 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.customFunction(605160960);
/*  420 */     IVehicleFunction.IZone iZone11 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE });
/*  421 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus2 = iZone11.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E4 = new -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E(this);
/*      */ 
/*      */     
/*  424 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iMultiSignalStatus2.onStatusSignalChanged(-$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E4); -$$Lambda$Charging$eXvRSoqHFx2Ng_CQh333U-uTOpY -$$Lambda$Charging$eXvRSoqHFx2Ng_CQh333U-uTOpY = -$$Lambda$Charging$eXvRSoqHFx2Ng_CQh333U-uTOpY.INSTANCE;
/*  425 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild29.customValue(-$$Lambda$Charging$eXvRSoqHFx2Ng_CQh333U-uTOpY); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE15 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*  426 */     iFilterCallback5.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE15);
/*      */ 
/*      */ 
/*      */     
/*  430 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.customFunction(605356288);
/*  431 */     IVehicleFunction.IZone iZone10 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE });
/*  432 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iZone10.useStatusPAByIntBase(33795); -$$Lambda$Charging$KFcvH7TWNf5F2fZif-swSo3og3o -$$Lambda$Charging$KFcvH7TWNf5F2fZif-swSo3og3o = -$$Lambda$Charging$KFcvH7TWNf5F2fZif-swSo3og3o.INSTANCE;
/*  433 */     IVehicleFunction.IFilterCallback iFilterCallback19 = iValueTaskBuild28.useValuePAByIntBase(33795, -$$Lambda$Charging$KFcvH7TWNf5F2fZif-swSo3og3o); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE2 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */ 
/*      */     
/*  436 */     iFilterCallback19.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE2);
/*      */ 
/*      */     
/*  439 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.customFunction(605356544);
/*  440 */     IVehicleFunction.IZone iZone9 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE });
/*  441 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iZone9.useStatusPAByIntBase(33796); -$$Lambda$Charging$HTRcu0nywehwhJRyAX4UZ6TAkRE -$$Lambda$Charging$HTRcu0nywehwhJRyAX4UZ6TAkRE = -$$Lambda$Charging$HTRcu0nywehwhJRyAX4UZ6TAkRE.INSTANCE;
/*  442 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild27.useValuePAByIntBase(33796, -$$Lambda$Charging$HTRcu0nywehwhJRyAX4UZ6TAkRE); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE1 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */ 
/*      */     
/*  445 */     iFilterCallback18.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE1);
/*      */ 
/*      */     
/*  448 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.customFunction(605357056);
/*  449 */     IVehicleFunction.IZone iZone8 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/*  450 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iZone8.useStatusPAByIntBase(33798); -$$Lambda$Charging$WuUYHNosG9jwTMSTQjUvc8fnoCM -$$Lambda$Charging$WuUYHNosG9jwTMSTQjUvc8fnoCM = -$$Lambda$Charging$WuUYHNosG9jwTMSTQjUvc8fnoCM.INSTANCE;
/*  451 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild26.useValuePAByIntBase(33798, -$$Lambda$Charging$WuUYHNosG9jwTMSTQjUvc8fnoCM); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE14 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */ 
/*      */     
/*  454 */     iFilterCallback4.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE14);
/*      */ 
/*      */     
/*  457 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.customFunction(605356800);
/*  458 */     IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/*  459 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone7.useStatusPAByIntBase(33797); -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI1 = -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI.INSTANCE;
/*      */     
/*  461 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild6.useValuePAByIntBase(33797, -$$Lambda$Charging$63YeFJYeCu5K77AI4V_SWugWqvI1); -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE13 = new -$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE(this);
/*      */ 
/*      */     
/*  464 */     iFilterCallback3.addTo(-$$Lambda$Charging$eMPsVbeTGFG3aVG_5EFTQvrpBjE13);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  477 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(605159936);
/*  478 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/*  479 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus11 = iZone6.useStatusSignals(new int[] { 29337, 30788, 30779, 31405 }); -$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq8 -$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq82 = new -$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq8(this);
/*      */ 
/*      */ 
/*      */     
/*  483 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iMultiSignalStatus11.onStatusSignalChanged(-$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq82); -$$Lambda$Charging$yT7xrgjW5ICY2i5j-rcbpEuCEr8 -$$Lambda$Charging$yT7xrgjW5ICY2i5j-rcbpEuCEr8 = new -$$Lambda$Charging$yT7xrgjW5ICY2i5j-rcbpEuCEr8(this);
/*  484 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$Charging$yT7xrgjW5ICY2i5j-rcbpEuCEr8); -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI2 = -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI.INSTANCE;
/*  485 */     IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild5.useValueSignal(31454, -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI2); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo4 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */     
/*  487 */     iFilterCallback17.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo4);
/*      */ 
/*      */     
/*  490 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(605159680);
/*  491 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/*  492 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus10 = iZone5.useStatusSignals(new int[] { 29337, 30788, 30779, 31405 }); -$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq8 -$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq81 = new -$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq8(this);
/*      */ 
/*      */ 
/*      */     
/*  496 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iMultiSignalStatus10.onStatusSignalChanged(-$$Lambda$Charging$_fO8sKn_oVmql8-PtzMtm512tq81); -$$Lambda$Charging$HYTBozIEakMxoacibpIrJjrXJTE -$$Lambda$Charging$HYTBozIEakMxoacibpIrJjrXJTE = new -$$Lambda$Charging$HYTBozIEakMxoacibpIrJjrXJTE(this);
/*  497 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iValueTaskBuild24.onSetFunctionValue(-$$Lambda$Charging$HYTBozIEakMxoacibpIrJjrXJTE); -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI1 = -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI.INSTANCE;
/*  498 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild4.useValueSignal(31454, -$$Lambda$8g9rI_hLeu88C5QKNASdcCeB4PI1); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo3 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */     
/*  500 */     iFilterCallback16.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo3);
/*      */ 
/*      */     
/*  503 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(606078976);
/*  504 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/*  505 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus1 = iZone4.useStatusSignals(new int[] { 29337, 30788, 30779, 31398, 31394 }); -$$Lambda$Charging$-Uj0IpQmNs353cLjzvWQwa9e1bA -$$Lambda$Charging$-Uj0IpQmNs353cLjzvWQwa9e1bA = new -$$Lambda$Charging$-Uj0IpQmNs353cLjzvWQwa9e1bA(this);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  510 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iMultiSignalStatus1.onStatusSignalChanged(-$$Lambda$Charging$-Uj0IpQmNs353cLjzvWQwa9e1bA); -$$Lambda$Charging$q-NcmrDuMQ9Q9PjvU93AVSlFUlQ -$$Lambda$Charging$q-NcmrDuMQ9Q9PjvU93AVSlFUlQ = new -$$Lambda$Charging$q-NcmrDuMQ9Q9PjvU93AVSlFUlQ(this);
/*  511 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$Charging$q-NcmrDuMQ9Q9PjvU93AVSlFUlQ); -$$Lambda$zK3o6bjeoVc21esLrjbwU_PYn1o -$$Lambda$zK3o6bjeoVc21esLrjbwU_PYn1o = -$$Lambda$zK3o6bjeoVc21esLrjbwU_PYn1o.INSTANCE;
/*  512 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild23.useValueSignal(31394, -$$Lambda$zK3o6bjeoVc21esLrjbwU_PYn1o); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo10 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */     
/*  514 */     iFilterCallback2.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo10);
/*      */ 
/*      */     
/*  517 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(606078720);
/*  518 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/*  519 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone3.useStatusPAByIntBase(33683); -$$Lambda$Charging$TNNjzE54lsDqCoQ77TvIZGtiWy8 -$$Lambda$Charging$TNNjzE54lsDqCoQ77TvIZGtiWy8 = -$$Lambda$Charging$TNNjzE54lsDqCoQ77TvIZGtiWy8.INSTANCE;
/*  520 */     IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild2.useValuePA(33683, -$$Lambda$Charging$TNNjzE54lsDqCoQ77TvIZGtiWy8); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo2 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  526 */     iFilterCallback15.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo2);
/*      */ 
/*      */     
/*  529 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(606079232);
/*  530 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/*  531 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus9 = iZone2.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E1 = new -$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E(this);
/*      */ 
/*      */     
/*  534 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iMultiSignalStatus9.onStatusSignalChanged(-$$Lambda$Charging$PVCu3KOiburCc6R3tA_nR9bb5-E1); -$$Lambda$apuPidKsCTXrisTqeC7KKeMDDl4 -$$Lambda$apuPidKsCTXrisTqeC7KKeMDDl4 = -$$Lambda$apuPidKsCTXrisTqeC7KKeMDDl4.INSTANCE;
/*  535 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild22.useValueSignal(31401, -$$Lambda$apuPidKsCTXrisTqeC7KKeMDDl4); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo1 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */     
/*  537 */     iFilterCallback14.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo1);
/*      */ 
/*      */     
/*  540 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(606079488);
/*  541 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/*  542 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useStatusPAByIntBase(33963); -$$Lambda$TGy-mzp8Dkm1QQHYEJLo2uiJme8 -$$Lambda$TGy-mzp8Dkm1QQHYEJLo2uiJme8 = -$$Lambda$TGy-mzp8Dkm1QQHYEJLo2uiJme8.INSTANCE;
/*      */     
/*  544 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33963, -$$Lambda$TGy-mzp8Dkm1QQHYEJLo2uiJme8); -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo9 = new -$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo(this);
/*      */ 
/*      */     
/*  547 */     iFilterCallback1.addTo(-$$Lambda$Charging$py1F5WXLvhTSO5ROZh6O0K6ffRo9);
/*      */ 
/*      */     
/*  550 */     addPAFilter(Integer.valueOf(33794));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setChargeLightSwitch(int paramInt) {
/*  558 */     if (paramInt == 0) { paramInt = 2; } else { paramInt = 1; }
/*  559 */      if (usageModeAnyMatch(new int[] { 1, 2 })) {
/*  560 */       this.mVfcipwakeupManager.CB_SetVehCharging(1);
/*      */     }
/*  562 */     ApiResult apiResult = this.mCarSignalManager.setChrgnLiSwt(paramInt);
/*  563 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setChargeLightStatus result: "); stringBuilder.append(paramInt); stringBuilder.append(" apiResult:"); stringBuilder.append(apiResult); Log.d("Charging", stringBuilder.toString());
/*      */     
/*  565 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setV2LSwitch(int paramInt) {
/*  572 */     ApiResult apiResult = ApiResult.PARAM_ERROR;
/*  573 */     if (ApiResult.SUCCEED == this.mVfcipwakeupManager.CB_SetVehCharging(1)) {
/*      */       
/*  575 */       if (1 == paramInt) {
/*  576 */         apiResult = this.mCarSignalManager.setV2XDchaSwt(2);
/*  577 */       } else if (paramInt == 0) {
/*  578 */         apiResult = this.mCarSignalManager.setV2XDchaSwt(0);
/*      */       } 
/*      */     } else {
/*  581 */       apiResult = ApiResult.FAILED;
/*  582 */       Log.e("Charging", "VFC setV2XDchaSwt failed");
/*      */     } 
/*  584 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setV2VSwitch(int paramInt) {
/*  592 */     ApiResult apiResult = ApiResult.PARAM_ERROR;
/*  593 */     if (ApiResult.SUCCEED == this.mVfcipwakeupManager.CB_SetVehCharging(1)) {
/*      */       
/*  595 */       if (1 == paramInt) {
/*  596 */         apiResult = this.mCarSignalManager.setV2XDchaSwt(1);
/*  597 */       } else if (paramInt == 0) {
/*  598 */         apiResult = this.mCarSignalManager.setV2XDchaSwt(0);
/*      */       } 
/*      */     } else {
/*  601 */       apiResult = ApiResult.FAILED;
/*  602 */       Log.e("Charging", "VFC setV2XDchaSwt failed");
/*      */     } 
/*  604 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setExPowerSupplySwitch(int paramInt) {
/*  612 */     ApiResult apiResult = ApiResult.PARAM_ERROR;
/*  613 */     if (ApiResult.SUCCEED == this.mVfcipwakeupManager.CB_SetVehCharging(1)) {
/*      */       
/*  615 */       if (606078977 == paramInt) {
/*  616 */         apiResult = this.mCarSignalManager.setDChaEngStsCtrl(1);
/*  617 */       } else if (606078978 == paramInt) {
/*  618 */         apiResult = this.mCarSignalManager.setDChaEngStsCtrl(2);
/*      */       } 
/*      */     } else {
/*  621 */       apiResult = ApiResult.FAILED;
/*  622 */       Log.e("Charging", "VFC setV2XDchaSwt failed");
/*      */     } 
/*  624 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setChargingSwitch(int paramInt) {
/*  635 */     ApiResult apiResult1, apiResult2 = ApiResult.PARAM_ERROR;
/*  636 */     if (ApiResult.SUCCEED == this.mVfcipwakeupManager.CB_SetVehCharging(1))
/*  637 */     { if (paramInt == 0)
/*  638 */       { apiResult1 = this.mCarSignalManager.setChrgSoftSwCtrlSt(2); }
/*      */       else
/*  640 */       { int i = getSignalValue(31435);
/*      */         
/*  642 */         if (1 != i && 2 != i) { ApiResult apiResult = apiResult2; if (3 == i)
/*      */           {
/*      */ 
/*      */             
/*  646 */             apiResult = apiResult2;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  657 */           return apiResult; }  apiResult1 = apiResult2; }  } else { apiResult1 = ApiResult.FAILED; Log.e("Charging", "VFC setChrgSoftSwCtrlSt failed"); }  return apiResult1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setDisChargeSoc(float paramFloat) {
/*  664 */     ApiResult apiResult = ApiResult.PARAM_ERROR;
/*  665 */     int j = (int)(getSignalValue(31405) * 0.1D);
/*      */     
/*  667 */     int i = (int)paramFloat;
/*  668 */     if (20 <= j && 20 <= i && i <= j) {
/*      */       
/*  670 */       if (ApiResult.SUCCEED == this.mVfcipwakeupManager.CB_SetVehCharging(1)) {
/*      */ 
/*      */         
/*  673 */         apiResult = this.mCarSignalManager.setDchaChrgnTarVal(i * 10);
/*      */       } else {
/*      */         
/*  676 */         apiResult = ApiResult.FAILED;
/*  677 */         Log.e("Charging", "VFC setDchaChrgnTarVal failed");
/*      */       } 
/*  679 */     } else if (20 >= j) {
/*  680 */       apiResult = ApiResult.INVALID;
/*  681 */     } else if (i > j) {
/*  682 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  684 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getChargingSwitch(int paramInt) {
/*  694 */     char c = 'ÿ';
/*      */     
/*  696 */     if (paramInt == 2 || paramInt == 5)
/*      */     
/*  698 */     { c = '\001';
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  703 */       return c; }  if (paramInt == 3) c = Character.MIN_VALUE;  return c;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float getDisChargingSOC(int paramInt) {
/*  743 */     return (float)(paramInt * 0.1D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getChrgnOrDischrgnStsFb() {
/*  750 */     int i = getIntValue(33803, 0);
/*      */     
/*  752 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getChrgnOrDischrgnStsFb: "); stringBuilder.append(i); Log.d("Charging", stringBuilder.toString());
/*  753 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void notifyBookChargeStatus() {
/*  760 */     float f = (float)(getSignalValue(31392) * 0.001D);
/*      */     
/*  762 */     onFunctionChanged(605028864);
/*  763 */     onSupportedFunctionStatusChanged(605028864, -2147483648, getLocalBookChargeStatus());
/*  764 */     onCustomizeFunctionValueChanged(605028864, -2147483648, f);
/*  765 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyBookChargeStatus: "); stringBuilder.append(f); Log.d("Charging", stringBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getDisChargingStatus() {
/*  774 */     boolean bool = true;
/*  775 */     boolean bool1 = carConfigAnyMatch(29337, new int[] { 3 });
/*  776 */     if (usageModeAnyMatch(new int[] { 2, 1, 11, 13 }))
/*      */     {
/*  778 */       if (carModeAnyMatch(new int[] { 0, 3, 5 })) {
/*      */         return SignalUtils.functionStatusIs(bool1, bool);
/*      */       }
/*      */     }
/*      */     bool = false;
/*      */     return SignalUtils.functionStatusIs(bool1, bool);
/*      */   }
/*      */   
/*      */   private FunctionStatus getDisChargingSwitchStatus() {
/*      */     boolean bool1;
/*  788 */     double d = getSignalValue(31405); boolean bool2 = false; if (d * 0.1D > 20.0D) { bool1 = true; } else { bool1 = false; }
/*      */ 
/*      */     
/*  791 */     boolean bool = carConfigAnyMatch(29337, new int[] { 3 });
/*  792 */     if (usageModeAnyMatch(new int[] { 2, 1, 11, 13 }))
/*      */     {
/*  794 */       if (carModeAnyMatch(new int[] { 0, 3, 5 }) && bool1) {
/*      */         bool2 = true;
/*      */       }
/*      */     }
/*      */     return SignalUtils.functionStatusIs(bool, bool2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getExernalPowerSupplyStatus() {
/*  804 */     int i = (int)(getSignalValue(31405) * 0.1D);
/*      */     
/*  806 */     int j = (int)(getSignalValue(31398) * 0.1D);
/*      */     
/*  808 */     int k = getSignalValue(31394);
/*      */     
/*  810 */     float f = j; boolean bool2 = false; if (20.0F >= f || j >= i || (k != 1 && k != 0)) { bool1 = true; } else { bool1 = false; }
/*      */     
/*  812 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(" currentSoc: "); stringBuilder.append(i); stringBuilder.append(" disChargeSoc: "); stringBuilder.append(j); stringBuilder.append(" engSts: "); stringBuilder.append(k); stringBuilder.append(" isOk: "); stringBuilder.append(bool1); Log.d("Charging", stringBuilder.toString());
/*      */ 
/*      */     
/*  815 */     boolean bool = carConfigAnyMatch(29337, new int[] { 3 });
/*  816 */     if (usageModeAnyMatch(new int[] { 2, 1, 11, 13 }))
/*      */     {
/*  818 */       if (carModeAnyMatch(new int[] { 0, 3, 5 }) && bool1) { bool1 = true; return SignalUtils.functionStatusIs(bool, bool1); }  }  boolean bool1 = bool2;
/*      */     return SignalUtils.functionStatusIs(bool, bool1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getTargetSocStatus() {
/*  829 */     int i = getSignalValue(31441);
/*      */     
/*  831 */     boolean bool = true; if (i != 2) { i = 1; } else { i = 0; }
/*      */     
/*  833 */     boolean bool1 = carConfigAnyMatch(29337, new int[] { 3 });
/*  834 */     if (!usageModeAnyMatch(new int[] { 13
/*  835 */         }) || !carModeAnyMatch(new int[] { 0 }) || i == 0) {
/*      */       bool = false;
/*      */     }
/*      */     return SignalUtils.functionStatusIs(bool1, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getRemBookChargingStatus() {
/*  844 */     FunctionStatus functionStatus2 = FunctionStatus.notavailable;
/*  845 */     FunctionStatus functionStatus1 = functionStatus2; functionStatus1 = functionStatus2; if (1 == this.mTcamManager.getChargingSwitchStatus() && carConfigAnyMatch(29337, new int[] { 3 }))
/*      */     {
/*  847 */       functionStatus1 = FunctionStatus.active;
/*      */     }
/*  849 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getRemBookChargingStatus(active: 0): "); stringBuilder.append(functionStatus1); Log.d("Charging", stringBuilder.toString());
/*  850 */     return functionStatus1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getChargingStatus() {
/*  859 */     boolean bool = true;
/*  860 */     boolean bool1 = carConfigAnyMatch(29337, new int[] { 3 });
/*  861 */     if (usageModeAnyMatch(new int[] { 2, 1, 11, 13 }))
/*      */     {
/*  863 */       if (carModeAnyMatch(new int[] { 0, 3, 5 })) {
/*      */         return SignalUtils.functionStatusIs(bool1, bool);
/*      */       }
/*      */     }
/*      */     bool = false;
/*      */     return SignalUtils.functionStatusIs(bool1, bool);
/*      */   }
/*      */ 
/*      */   
/*      */   private FunctionStatus getChargeButtonStatus() {
/*  873 */     int j = getSignalValue(31435);
/*      */     
/*  875 */     int i = getChrgnOrDischrgnStsFb(); boolean bool = false; if (i == 2 || getChrgnOrDischrgnStsFb() == 3 || 
/*  876 */       getChrgnOrDischrgnStsFb() == 5) { i = 1; } else { i = 0; }
/*  877 */      if (1 == j || 2 == j || 3 == j) { j = 1; } else { j = 0; }
/*      */ 
/*      */ 
/*      */     
/*  881 */     boolean bool1 = carConfigAnyMatch(29337, new int[] { 3 });
/*  882 */     if (usageModeAnyMatch(new int[] { 2, 1, 11, 13
/*  883 */         }) && carModeAnyMatch(new int[] { 0, 3, 5 }) && j != 0 && i != 0) {
/*      */       bool = true;
/*      */     }
/*      */     return SignalUtils.functionStatusIs(bool1, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLocalBookChargeStatus() {
/*  895 */     boolean bool = true;
/*  896 */     boolean bool1 = carConfigAnyMatch(29337, new int[] { 3 });
/*  897 */     if (usageModeAnyMatch(new int[] { 1, 2, 11, 13 }))
/*      */     {
/*  899 */       if (carModeAnyMatch(new int[] { 0, 3, 5 })) {
/*      */         return SignalUtils.functionStatusIs(bool1, bool);
/*      */       }
/*      */     }
/*      */     bool = false;
/*      */     return SignalUtils.functionStatusIs(bool1, bool);
/*      */   }
/*      */ 
/*      */   
/*      */   private FunctionStatus getChargLightSwitchStatus() {
/*  909 */     boolean bool = true;
/*  910 */     boolean bool1 = carConfigAnyMatch(29337, new int[] { 3 });
/*  911 */     if (usageModeAnyMatch(new int[] { 1, 2, 11, 13 }))
/*      */     {
/*  913 */       if (carModeAnyMatch(new int[] { 0, 3, 5 })) {
/*      */         return SignalUtils.functionStatusIs(bool1, bool);
/*      */       }
/*      */     }
/*      */     bool = false;
/*      */     return SignalUtils.functionStatusIs(bool1, bool);
/*      */   }
/*      */   
/*      */   private int convertPABookChargeSetResponse(int paramInt) {
/*  922 */     char c = 'ÿ';
/*  923 */     switch (paramInt) { default: paramInt = c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  936 */         return paramInt;case 3: paramInt = 605094914; return paramInt;case 2: paramInt = 605094918; return paramInt;case 1: break; }  paramInt = 605094913; return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int convertReBookOnOffNoReq(int paramInt) {
/*  944 */     boolean bool = false;
/*  945 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  955 */         return paramInt;case 1: paramInt = 0; return paramInt;case 0: break; }  paramInt = 1; return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int convertToChargePlugType(int paramInt) {
/*      */     int i;
/*  963 */     char c = 'ÿ';
/*  964 */     if (paramInt != 5 && paramInt != 7) { if (paramInt != 9) { switch (paramInt)
/*      */         
/*      */         { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           default:
/*  982 */             i = c; if (paramInt != 0) { i = c; if (8 == paramInt)
/*      */               {
/*      */ 
/*      */ 
/*      */                 
/*  987 */                 i = 255;
/*      */               } }
/*      */ 
/*      */ 
/*      */             
/*  992 */             return i;case 1: case 2: case 3: break; }  i = 605225217; } else { i = 605225220; }  } else { i = 605225219; }  return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int convertToChargeStatus(int paramInt) {
/* 1000 */     char c = 'ÿ';
/* 1001 */     switch (paramInt) { default: paramInt = c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1040 */         return paramInt;case 12: paramInt = 605225484; return paramInt;case 11: paramInt = 605225477; return paramInt;case 9: paramInt = 605225479; return paramInt;case 8: paramInt = 605225478; return paramInt;case 6: paramInt = 605094916; return paramInt;case 5: paramInt = 605225480; return paramInt;case 3: case 4: paramInt = 605225475; return paramInt;case 2: break; }  paramInt = 605225474; return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int convertChargLightStatus(int paramInt) {
/* 1048 */     char c = 'ÿ';
/* 1049 */     switch (paramInt) { default: paramInt = c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1059 */         return paramInt;case 1: paramInt = 1; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int convertPADisChrgrSW(int paramInt) {
/* 1067 */     byte b = 0;
/* 1068 */     if (paramInt == 1) {
/* 1069 */       b = 1;
/* 1070 */     } else if (paramInt == 0) {
/* 1071 */       b = 0;
/* 1072 */     } else if (paramInt == 2) {
/* 1073 */       b = 2;
/*      */     } 
/* 1075 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int convertEngStsDurgDcha(int paramInt) {
/* 1083 */     int i = 606078978;
/* 1084 */     if (paramInt == 0) {
/* 1085 */       i = 606078978;
/* 1086 */     } else if (paramInt == 1) {
/* 1087 */       i = 606078977;
/* 1088 */     } else if (paramInt == 2) {
/* 1089 */       i = 606078979;
/* 1090 */     } else if (paramInt == 3) {
/* 1091 */       i = 606078980;
/* 1092 */     } else if (paramInt == 4) {
/* 1093 */       i = 606078981;
/* 1094 */     } else if (paramInt == 5) {
/* 1095 */       i = 606078982;
/* 1096 */     } else if (paramInt == 6) {
/* 1097 */       i = 1;
/*      */     } 
/* 1099 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int convertDchaStop(int paramInt) {
/* 1107 */     int i = 606079233;
/* 1108 */     if (paramInt == 1) {
/* 1109 */       i = 606079234;
/*      */     }
/* 1111 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int converColumnColor(int paramInt) {
/* 1119 */     int i = 255;
/* 1120 */     if (paramInt == 0) {
/* 1121 */       i = 606079489;
/* 1122 */     } else if (paramInt == 1) {
/* 1123 */       i = 606079490;
/* 1124 */     } else if (paramInt == 2) {
/* 1125 */       i = 606079491;
/* 1126 */     } else if (paramInt == 3) {
/* 1127 */       i = 606079492;
/* 1128 */     } else if (paramInt == 4) {
/* 1129 */       i = 606079493;
/* 1130 */     } else if (paramInt == 5) {
/* 1131 */       i = 606079494;
/* 1132 */     } else if (paramInt == 6) {
/* 1133 */       i = 606079495;
/* 1134 */     } else if (paramInt == 7) {
/* 1135 */       i = 606079496;
/*      */     } 
/* 1137 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float convertPADchaIActStep(int paramInt) {
/* 1144 */     return (float)(paramInt * 0.1D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float convertPAEgyStep(int paramInt) {
/* 1151 */     return (float)(paramInt * 0.1D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float convertPABattery(int paramInt) {
/* 1158 */     return (float)(paramInt * 0.1D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float convertPAVoltStep(int paramInt) {
/* 1165 */     return (float)(paramInt * 0.25D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float convertPACurrentStep(int paramInt) {
/* 1172 */     return (float)(paramInt * 0.1D - 200.0D);
/*      */   }
/*      */   
/*      */   public Charging(Context paramContext) {
/* 1176 */     super(paramContext, 603979776);
/* 1177 */     this.mChargingListeners = new CopyOnWriteArrayList<>();
/* 1178 */     this.mTcamManager = TcamManager.getInstance(paramContext);
/* 1179 */     if (this.mTcamManager != null) {
/* 1180 */       this.mTcamManager.registerCallback((ITcamServiceCallback)new TcamCallback());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private ApiResult setLocalBookChrgnTarVal(float paramFloat) {
/* 1186 */     ApiResult apiResult = ApiResult.INVALID;
/* 1187 */     int i = (int)(getSignalValue(31405) * 0.1D);
/*      */     
/* 1189 */     int j = (int)paramFloat;
/* 1190 */     boolean bool2 = false;
/*      */ 
/*      */     
/* 1193 */     boolean bool1 = bool2; if (j >= 50.0F) { bool1 = bool2; if (j <= 100) {
/* 1194 */         bool1 = true;
/*      */       } }
/*      */     
/* 1197 */     if (bool1) {
/* 1198 */       if (ApiResult.SUCCEED == this.mVfcipwakeupManager.CB_SetVehCharging(1)) {
/*      */ 
/*      */         
/* 1201 */         apiResult = this.mCarSignalManager.setLocalBookChrgnTarVal(j * 10);
/*      */       }
/*      */       else {
/*      */         
/* 1205 */         apiResult = ApiResult.FAILED;
/* 1206 */         Log.e("Charging", "VFC setLocalBookChrgnTarVal failed");
/*      */       } 
/*      */     }
/* 1209 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setCustomizeFunctionValue CHARGE_FUNC_CHARGING_SOC isNotify: "); stringBuilder.append(bool1); stringBuilder.append(" currentValue : "); stringBuilder.append(i); stringBuilder.append(" setValue: "); stringBuilder.append(j); stringBuilder.append(" apiResult: "); stringBuilder.append(apiResult); Log.d("Charging", stringBuilder.toString());
/*      */ 
/*      */     
/* 1212 */     return apiResult;
/*      */   }
/*      */ 
/*      */   
/*      */   private ApiResult setMaxAcInpCurrentSet(float paramFloat) {
/*      */     ApiResult apiResult;
/* 1218 */     if (ApiResult.SUCCEED == this.mVfcipwakeupManager.CB_SetVehCharging(1)) {
/*      */       
/* 1220 */       apiResult = this.mCarSignalManager.setMaxAcInpCurrentSet((int)paramFloat);
/*      */     } else {
/*      */       
/* 1223 */       apiResult = ApiResult.FAILED;
/* 1224 */       Log.e("Charging", "VFC setMaxAcInpCurrentSet failed");
/*      */     } 
/* 1226 */     return apiResult;
/*      */   } private ApiResult setPerCharging(int paramInt) {
/*      */     ApiResult apiResult1;
/*      */     Calendar calendar;
/* 1230 */     ApiResult apiResult2 = ApiResult.INVALID;
/* 1231 */     if (1 == paramInt) {
/* 1232 */       apiResult1 = apiResult2; if (mCalendarArray[0] != null) { apiResult1 = apiResult2; if (mCalendarArray[1] != null) {
/*      */           
/* 1234 */           TcamManager tcamManager = this.mTcamManager; calendar = mCalendarArray[0];
/*      */           
/* 1236 */           long l2 = calendar.getTimeInMillis(); calendar = mCalendarArray[1];
/* 1237 */           long l1 = calendar.getTimeInMillis(); boolean bool = tcamManager.setChargingInfo(1, l2, l1);
/* 1238 */           if (bool) {
/* 1239 */             ApiResult apiResult = ApiResult.SUCCEED;
/*      */           } else {
/* 1241 */             ApiResult apiResult = ApiResult.FAILED;
/*      */           } 
/*      */         }  }
/*      */     
/*      */     } else {
/* 1246 */       Calendar calendar1 = calendar; if (this.mTcamManager.setChargingSwitchClose()) {
/* 1247 */         apiResult1 = ApiResult.SUCCEED;
/*      */       }
/*      */     } 
/* 1250 */     return apiResult1;
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
/*      */   public boolean setChargingTimeSetting(int paramInt, Calendar[] paramArrayOfCalendar) {
/* 1263 */     return false;
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
/*      */   public Calendar[] getChargingTimeSetting(int paramInt) {
/* 1275 */     return new Calendar[0];
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
/*      */   public boolean setPreChargingTime(Calendar paramCalendar1, Calendar paramCalendar2) {
/* 1287 */     mCalendarArray[0] = paramCalendar1;
/* 1288 */     mCalendarArray[1] = paramCalendar2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1293 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Calendar[] changedChargingTimeToCalendar() {
/* 1302 */     Calendar calendar2 = Calendar.getInstance();
/* 1303 */     Calendar calendar1 = Calendar.getInstance();
/* 1304 */     Date date2 = new Date(this.mTcamManager.getChargingStartTime());
/* 1305 */     Date date1 = new Date(this.mTcamManager.getChargingStopTime());
/* 1306 */     calendar2.setTime(date2);
/* 1307 */     calendar1.setTime(date1);
/* 1308 */     mCalendarArray[0] = calendar2;
/* 1309 */     mCalendarArray[1] = calendar1;
/* 1310 */     return mCalendarArray;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Calendar[] getPreChargingTime() {
/* 1320 */     return changedChargingTimeToCalendar();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void registerListener(ICharging.IChargingListener paramIChargingListener) {
/* 1330 */     if (!this.mChargingListeners.contains(paramIChargingListener)) {
/* 1331 */       this.mChargingListeners.add(paramIChargingListener);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unregisterListener(ICharging.IChargingListener paramIChargingListener) {
/* 1342 */     this.mChargingListeners.remove(paramIChargingListener);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final class TcamCallback
/*      */     extends TcamServiceCallbackImpl
/*      */   {
/*      */     final Charging this$0;
/*      */ 
/*      */ 
/*      */     
/*      */     private TcamCallback() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void onChargingInfo(int param1Int, long param1Long1, long param1Long2) throws RemoteException {
/* 1360 */       super.onChargingInfo(param1Int, param1Long1, param1Long2);
/* 1361 */       if (!Charging.this.mChargingListeners.isEmpty()) {
/* 1362 */         for (ICharging.IChargingListener iChargingListener : Charging.this.mChargingListeners) {
/* 1363 */           iChargingListener.onPreChargingTimeChanged(Charging.this.changedChargingTimeToCalendar());
/* 1364 */           Charging.this.notifyBookChargeStatus();
/* 1365 */           Charging.this.onFunctionChanged(605094144);
/* 1366 */           Charging charging1 = Charging.this, charging2 = Charging.this;
/* 1367 */           FunctionStatus functionStatus = charging2.getRemBookChargingStatus(); charging1.onSupportedFunctionStatusChanged(605094144, -2147483648, functionStatus);
/* 1368 */           Charging.this.onFunctionValueChanged(605094144, -2147483648, param1Int);
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1373 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onChargingInfo switchStatus: "); stringBuilder.append(param1Int); stringBuilder.append(" getRemBookChargingStatus: "); Charging charging = Charging.this;
/* 1374 */         stringBuilder.append(charging.getRemBookChargingStatus()); String str = stringBuilder.toString();
/*      */         Log.d("Charging", str);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Calendar[] getHistoricalDischargeCapacityTime() {
/* 1387 */     PATypes.PA_VehCharg_DisChargeRecord pA_VehCharg_DisChargeRecord = (PATypes.PA_VehCharg_DisChargeRecord)getPAData(33794);
/*      */     
/* 1389 */     int[] arrayOfInt = pA_VehCharg_DisChargeRecord.getData();
/* 1390 */     if (arrayOfInt != null && 21 == arrayOfInt.length) {
/* 1391 */       int i = arrayOfInt[20];
/* 1392 */       if (i > 0) {
/* 1393 */         Calendar[] arrayOfCalendar = new Calendar[i];
/*      */         
/* 1395 */         byte b = 0; while (true) { if (b < i)
/* 1396 */             try { Calendar calendar = Calendar.getInstance();
/* 1397 */               calendar.clear();
/* 1398 */               calendar.setTimeInMillis(arrayOfInt[b] * 1000L);
/* 1399 */               arrayOfCalendar[b] = calendar;
/* 1400 */               StringBuilder stringBuilder6 = new StringBuilder(); this(); stringBuilder6.append("changeDateType: startDate.getYear() ");
/* 1401 */               stringBuilder6.append(calendar.get(1)); String str6 = stringBuilder6.toString(); Log.d("Charging", str6);
/* 1402 */               StringBuilder stringBuilder5 = new StringBuilder(); this(); stringBuilder5.append("changeDateType: startDate.getMonth() ");
/* 1403 */               stringBuilder5.append(calendar.get(2) + 1); String str5 = stringBuilder5.toString(); Log.d("Charging", str5);
/* 1404 */               StringBuilder stringBuilder4 = new StringBuilder(); this(); stringBuilder4.append("changeDateType: startDate.getDay() ");
/* 1405 */               stringBuilder4.append(calendar.get(5)); String str4 = stringBuilder4.toString(); Log.d("Charging", str4);
/* 1406 */               StringBuilder stringBuilder3 = new StringBuilder(); this(); stringBuilder3.append("changeDateType: startDate.getHours() ");
/* 1407 */               stringBuilder3.append(calendar.get(11)); String str3 = stringBuilder3.toString(); Log.d("Charging", str3);
/* 1408 */               StringBuilder stringBuilder2 = new StringBuilder(); this(); stringBuilder2.append("changeDateType: startDate.getMinutes() ");
/* 1409 */               stringBuilder2.append(calendar.get(12)); String str2 = stringBuilder2.toString(); Log.d("Charging", str2);
/* 1410 */               StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("changeDateType: startDate.getSeconds() ");
/* 1411 */               stringBuilder1.append(calendar.get(13)); String str1 = stringBuilder1.toString(); Log.d("Charging", str1);
/*      */               b++;
/*      */               continue; }
/* 1414 */             catch (Exception exception)
/* 1415 */             { exception.printStackTrace(); break; }
/*      */               return (Calendar[])exception; }
/*      */       
/*      */       } 
/* 1419 */     }  return new Calendar[0];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Float[] getHistoricalDischargeCapacityValue() {
/* 1429 */     PATypes.PA_VehCharg_DisChargeRecord pA_VehCharg_DisChargeRecord = (PATypes.PA_VehCharg_DisChargeRecord)getPAData(33794);
/*      */     
/* 1431 */     int[] arrayOfInt = pA_VehCharg_DisChargeRecord.getData();
/*      */     
/* 1433 */     if (arrayOfInt != null && 21 == arrayOfInt.length) {
/* 1434 */       int i = arrayOfInt[20];
/* 1435 */       if (i > 0) {
/* 1436 */         Float[] arrayOfFloat = new Float[i];
/*      */         
/* 1438 */         byte b = 0; while (true) { if (b < i)
/* 1439 */             try { arrayOfFloat[b] = Float.valueOf((float)(arrayOfInt[b + 10] * 0.1D));
/* 1440 */               StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("getHistoricalDischargeCapacityValue: "); stringBuilder.append(arrayOfFloat[b]); Log.d("Charging", stringBuilder.toString());
/*      */               
/*      */               b++;
/*      */               continue; }
/* 1444 */             catch (Exception exception)
/* 1445 */             { exception.printStackTrace(); break; }
/*      */               return arrayOfFloat; }
/*      */       
/*      */       } 
/* 1449 */     }  return new Float[0];
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\Charging.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */