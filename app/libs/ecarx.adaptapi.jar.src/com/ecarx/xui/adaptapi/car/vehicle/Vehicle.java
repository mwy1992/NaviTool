/*      */ package com.ecarx.xui.adaptapi.car.vehicle;
/*      */ 
/*      */ import android.car.CarNotConnectedException;
/*      */ import android.content.Context;
/*      */ import android.os.IPowerStatusListener;
/*      */ import android.os.RemoteException;
/*      */ import android.util.Log;
/*      */ import com.ecarx.xui.adaptapi.CallStatus;
/*      */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*      */ import com.ecarx.xui.adaptapi.SignalUtils;
/*      */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*      */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*      */ import com.ecarx.xui.adaptapi.car.Pairs;
/*      */ import com.ecarx.xui.adaptapi.car.ProFunction;
/*      */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*      */ import com.ecarx.xui.adaptapi.car.base.IProValue;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.signal.CarSignalManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarClimateManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarFaceidManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarPassapManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfcipwakeupManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfmisc2Manager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfnaviManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfsmallcycleManager;
/*      */ import ecarx.dimprotocol.DIMProtocolManager;
/*      */ import ecarx.dimprotocol.IDIMProtocolServiceCallback;
/*      */ import ecarx.multidisplay.EcarxMultidisplayManager;
/*      */ import ecarx.multidisplay.IEcarxMultidisplayCallback;
/*      */ import ecarx.power.BrightnessManager;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Vehicle
/*      */   extends AbsCarFunction
/*      */   implements IVehicle
/*      */ {
/*  112 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 }; private boolean isHoliday = false; private boolean isFirst = true; private static final int CAR_CONFIG_ALLOW = 2; private static final int CAR_CONFIG_OK = 3;
/*      */   private static final String FESTIVAL_KEY = "festivalswitch";
/*      */   private static final String LINKAGE_KEY = "linkageswitch";
/*      */   private static final byte MSG_TYPE_NOTIFY = 2;
/*      */   private static final String TAG = "Vehicle_AdaptAPi";
/*      */   private static final String WALLPAPER_KEY = "wallpaper";
/*      */   private final BrightnessManager mBrightnessMgr;
/*      */   private ECarXCarClimateManager mClimateManager;
/*      */   private final IDIMProtocolServiceCallback mDIMServiceCallback;
/*      */   private final DIMProtocolManager mDimProtocolManager;
/*      */   private ECarXCarFaceidManager mECarXCarFaceidManager;
/*      */   private ECarXCarVfcipwakeupManager mECarXCarVfcipwakeupManager;
/*      */   private ECarXCarVfnaviManager mECarXCarVfnaviManager;
/*      */   private EcarxMultidisplayManager mEcarxMultidisplayManager;
/*      */   private IEcarxMultidisplayCallback mIEcarxMultidisplayCallback;
/*      */   private ECarXCarPassapManager mParkAssistManager;
/*      */   private ECarXCarVfmisc2Manager mVFMisc2Manager;
/*      */   private ECarXCarVfmiscManager mVFMiscManager;
/*      */   private ECarXCarVfsmallcycleManager mVFSmallCycleManager;
/*      */   
/*      */   protected Vehicle(Context paramContext) {
/*  133 */     super(paramContext, 536870912);
/*  134 */     this.mDimProtocolManager = DIMProtocolManager.getInstance(paramContext);
/*  135 */     this.mDIMServiceCallback = (IDIMProtocolServiceCallback)new DIMProtocolServiceCallbackImpl();
/*  136 */     this.mDimProtocolManager.registerCallback(this.mDIMServiceCallback);
/*      */     
/*  138 */     this.mBrightnessMgr = BrightnessManager.getInstance(this.mContext);
/*  139 */     this.mBrightnessMgr.registerCallBack((IPowerStatusListener)new BrightnessMgrReceiver());
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  144 */     this.mVFMiscManager = this.mECarXCarSetManager.getECarXCarVfmiscManager();
/*  145 */     this.mVFMisc2Manager = this.mECarXCarSetManager.getECarXCarVfmisc2Manager();
/*  146 */     this.mVFSmallCycleManager = this.mECarXCarSetManager.getECarXCarVfsmallcycleManager();
/*  147 */     this.mClimateManager = this.mECarXCarSetManager.getECarXCarClimateManager();
/*  148 */     this.mParkAssistManager = this.mECarXCarSetManager.getECarXCarPassapManager();
/*  149 */     this.mECarXCarVfcipwakeupManager = this.mECarXCarSetManager.getECarXCarVfcipwakeupManager();
/*  150 */     this.mECarXCarFaceidManager = this.mECarXCarSetManager.getECarXCarFaceidManager();
/*  151 */     this.mECarXCarVfnaviManager = this.mECarXCarSetManager.getECarXCarVfnaviManager();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void buildFunctions() {
/*  158 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  159 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*  160 */     Pairs pairs4 = pairs1.reverse();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  166 */     IVehicleFunction iVehicleFunction42 = VehicleFunction.intFunction(537002240); int[] arrayOfInt8 = COMMON_ON_OFF;
/*  167 */     IVehicleFunction iVehicleFunction39 = iVehicleFunction42.supportedFunctionValue(arrayOfInt8);
/*  168 */     IVehicleFunction.IZone iZone35 = iVehicleFunction39.createZone(new int[] { Integer.MIN_VALUE });
/*  169 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild36 = iZone35.useStatusPAByIntBase(33643); ECarXCarVfmiscManager eCarXCarVfmiscManager16 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager16); -$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ -$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ = new -$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ(eCarXCarVfmiscManager16);
/*  170 */     iValueTaskBuild36 = iValueTaskBuild36.onSetFunctionValue(-$$Lambda$md37V4CfGUq5GWPX3JHJbb3sIeQ, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M14 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  171 */     IVehicleFunction.IFilterCallback iFilterCallback27 = iValueTaskBuild36.useValuePAByIntBase(33643, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M14); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk34 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  173 */     iFilterCallback27.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk34);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  179 */     IVehicleFunction iVehicleFunction38 = VehicleFunction.intFunction(537002752); int[] arrayOfInt20 = COMMON_ON_OFF;
/*  180 */     iVehicleFunction38 = iVehicleFunction38.supportedFunctionValue(arrayOfInt20);
/*  181 */     IVehicleFunction.IZone iZone34 = iVehicleFunction38.createZone(new int[] { Integer.MIN_VALUE });
/*  182 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild35 = iZone34.useStatusPAByIntBase(33644); ECarXCarVfmiscManager eCarXCarVfmiscManager15 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager15); -$$Lambda$MUJplghB5GAYvYjBk0UMOzEBb2Q -$$Lambda$MUJplghB5GAYvYjBk0UMOzEBb2Q = new -$$Lambda$MUJplghB5GAYvYjBk0UMOzEBb2Q(eCarXCarVfmiscManager15);
/*  183 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild46 = iValueTaskBuild35.onSetFunctionValue(-$$Lambda$MUJplghB5GAYvYjBk0UMOzEBb2Q, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M9 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  184 */     IVehicleFunction.IFilterCallback iFilterCallback26 = iValueTaskBuild46.useValuePAByIntBase(33644, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M9); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk33 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  186 */     iFilterCallback26.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk33);
/*      */ 
/*      */     
/*  189 */     IVehicleFunction iVehicleFunction37 = VehicleFunction.intFunction(537003008); int[] arrayOfInt19 = COMMON_ON_OFF;
/*  190 */     iVehicleFunction37 = iVehicleFunction37.supportedFunctionValue(arrayOfInt19);
/*  191 */     IVehicleFunction.IZone iZone33 = iVehicleFunction37.createZone(new int[] { Integer.MIN_VALUE });
/*  192 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild34 = iZone33.useStatusPAByIntBase(33668); ECarXCarVfmiscManager eCarXCarVfmiscManager14 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager14); -$$Lambda$GjhQU6_R_WbVBuSMNeuYllVPeJg -$$Lambda$GjhQU6_R_WbVBuSMNeuYllVPeJg = new -$$Lambda$GjhQU6_R_WbVBuSMNeuYllVPeJg(eCarXCarVfmiscManager14);
/*      */     
/*  194 */     Pairs pairs7 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2));
/*  195 */     pairs7 = pairs7.add(Integer.valueOf(1), Integer.valueOf(1)); iValueTaskBuild34 = iValueTaskBuild34.onSetFunctionValue(-$$Lambda$GjhQU6_R_WbVBuSMNeuYllVPeJg, pairs7); -$$Lambda$Vehicle$5XxHVtuK9FlW9Gt4ErmpuUPxQ28 -$$Lambda$Vehicle$5XxHVtuK9FlW9Gt4ErmpuUPxQ28 = new -$$Lambda$Vehicle$5XxHVtuK9FlW9Gt4ErmpuUPxQ28(this);
/*  196 */     IVehicleFunction.IFilterCallback iFilterCallback34 = iValueTaskBuild34.useValuePAByIntBase(33668, -$$Lambda$Vehicle$5XxHVtuK9FlW9Gt4ErmpuUPxQ28); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk18 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  198 */     iFilterCallback34.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk18);
/*      */ 
/*      */     
/*  201 */     IVehicleFunction iVehicleFunction36 = VehicleFunction.intFunction(537003264);
/*  202 */     iVehicleFunction36 = iVehicleFunction36.supportedFunctionValue(new int[] { 537003265, 537003266, 537003267 });
/*      */ 
/*      */ 
/*      */     
/*  206 */     IVehicleFunction.IZone iZone32 = iVehicleFunction36.createZone(new int[] { Integer.MIN_VALUE });
/*  207 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild33 = iZone32.useStatusPAByIntBase(33855); ECarXCarVfsmallcycleManager eCarXCarVfsmallcycleManager = this.mVFSmallCycleManager; Objects.requireNonNull(eCarXCarVfsmallcycleManager); -$$Lambda$aJb53REm-Y8w_zSLTRSrjrQlGB8 -$$Lambda$aJb53REm-Y8w_zSLTRSrjrQlGB8 = new -$$Lambda$aJb53REm-Y8w_zSLTRSrjrQlGB8(eCarXCarVfsmallcycleManager);
/*      */     
/*  209 */     pairs7 = Pairs.of(Integer.valueOf(537003265), Integer.valueOf(0));
/*  210 */     pairs7 = pairs7.add(Integer.valueOf(537003266), Integer.valueOf(1));
/*  211 */     pairs7 = pairs7.add(Integer.valueOf(537003267), Integer.valueOf(2)); iValueTaskBuild33 = iValueTaskBuild33.onSetFunctionValue(-$$Lambda$aJb53REm-Y8w_zSLTRSrjrQlGB8, pairs7); -$$Lambda$Vehicle$wSTkwWUsepESvX7JPom41VdqO94 -$$Lambda$Vehicle$wSTkwWUsepESvX7JPom41VdqO94 = new -$$Lambda$Vehicle$wSTkwWUsepESvX7JPom41VdqO94(this);
/*  212 */     IVehicleFunction.IFilterCallback iFilterCallback33 = iValueTaskBuild33.useValuePAByIntBase(33855, -$$Lambda$Vehicle$wSTkwWUsepESvX7JPom41VdqO94); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk17 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  214 */     iFilterCallback33.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk17);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  274 */     IVehicleFunction iVehicleFunction41 = VehicleFunction.intFunction(537264384); int[] arrayOfInt7 = COMMON_ON_OFF;
/*  275 */     IVehicleFunction iVehicleFunction35 = iVehicleFunction41.supportedFunctionValue(arrayOfInt7);
/*  276 */     IVehicleFunction.IZone iZone31 = iVehicleFunction35.createZone(new int[] { Integer.MIN_VALUE });
/*  277 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild32 = iZone31.useStatusPAByIntBase(33660); ECarXCarVfmiscManager eCarXCarVfmiscManager13 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager13); -$$Lambda$d3nzkPTC2rfMOWgIOmbW7GpEiU8 -$$Lambda$d3nzkPTC2rfMOWgIOmbW7GpEiU8 = new -$$Lambda$d3nzkPTC2rfMOWgIOmbW7GpEiU8(eCarXCarVfmiscManager13);
/*  278 */     iValueTaskBuild32 = iValueTaskBuild32.onSetFunctionValue(-$$Lambda$d3nzkPTC2rfMOWgIOmbW7GpEiU8, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M13 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  279 */     IVehicleFunction.IFilterCallback iFilterCallback25 = iValueTaskBuild32.useValuePAByIntBase(33660, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M13); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk32 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  281 */     iFilterCallback25.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk32);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  290 */     IVehicleFunction iVehicleFunction34 = VehicleFunction.intFunction(537265152); int[] arrayOfInt18 = COMMON_ON_OFF;
/*  291 */     iVehicleFunction34 = iVehicleFunction34.supportedFunctionValue(arrayOfInt18);
/*  292 */     IVehicleFunction.IZone iZone30 = iVehicleFunction34.createZone(new int[] { Integer.MIN_VALUE });
/*  293 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild31 = iZone30.useStatusPAByIntBase(33661); ECarXCarVfmiscManager eCarXCarVfmiscManager12 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager12); -$$Lambda$XzbKI5vAw3xCdiAlNezhrNABXeg -$$Lambda$XzbKI5vAw3xCdiAlNezhrNABXeg = new -$$Lambda$XzbKI5vAw3xCdiAlNezhrNABXeg(eCarXCarVfmiscManager12);
/*  294 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild45 = iValueTaskBuild31.onSetFunctionValue(-$$Lambda$XzbKI5vAw3xCdiAlNezhrNABXeg, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M8 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  295 */     IVehicleFunction.IFilterCallback iFilterCallback24 = iValueTaskBuild45.useValuePAByIntBase(33661, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M8); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk31 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  297 */     iFilterCallback24.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk31);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  303 */     IVehicleFunction iVehicleFunction33 = VehicleFunction.intFunction(537268224); int[] arrayOfInt17 = COMMON_ON_OFF;
/*  304 */     iVehicleFunction33 = iVehicleFunction33.supportedFunctionValue(arrayOfInt17);
/*  305 */     IVehicleFunction.IZone iZone29 = iVehicleFunction33.createZone(new int[] { Integer.MIN_VALUE });
/*  306 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iZone29.useStatusPAByIntBase(33571); ECarXCarPassapManager eCarXCarPassapManager = this.mParkAssistManager; Objects.requireNonNull(eCarXCarPassapManager); -$$Lambda$eTibOiWm_mCZBgSL1rwvnsfS0eE -$$Lambda$eTibOiWm_mCZBgSL1rwvnsfS0eE = new -$$Lambda$eTibOiWm_mCZBgSL1rwvnsfS0eE(eCarXCarPassapManager);
/*  307 */     iValueTaskBuild30 = iValueTaskBuild30.onSetFunctionValue(-$$Lambda$eTibOiWm_mCZBgSL1rwvnsfS0eE, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M12 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/*  309 */     IVehicleFunction.IFilterCallback iFilterCallback32 = iValueTaskBuild30.useValuePAByIntBase(33571, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M12); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk16 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  311 */     iFilterCallback32.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk16);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  362 */     IVehicleFunction iVehicleFunction32 = VehicleFunction.intFunction(537395456); int[] arrayOfInt16 = COMMON_ON_OFF;
/*  363 */     iVehicleFunction32 = iVehicleFunction32.supportedFunctionValue(arrayOfInt16);
/*  364 */     IVehicleFunction.IZone iZone28 = iVehicleFunction32.createZone(new int[] { Integer.MIN_VALUE });
/*  365 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iZone28.useStatusPAByIntBase(33804); ECarXCarVfmisc2Manager eCarXCarVfmisc2Manager = this.mVFMisc2Manager; Objects.requireNonNull(eCarXCarVfmisc2Manager); -$$Lambda$PS-DP72nztnvqjddJNHv0HFAA0Q -$$Lambda$PS-DP72nztnvqjddJNHv0HFAA0Q = new -$$Lambda$PS-DP72nztnvqjddJNHv0HFAA0Q(eCarXCarVfmisc2Manager);
/*  366 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild44 = iValueTaskBuild29.onSetFunctionValue(-$$Lambda$PS-DP72nztnvqjddJNHv0HFAA0Q, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M7 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  367 */     IVehicleFunction.IFilterCallback iFilterCallback31 = iValueTaskBuild44.useValuePAByIntBase(33804, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M7); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk15 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  369 */     iFilterCallback31.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk15);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  393 */     IVehicleFunction iVehicleFunction31 = VehicleFunction.intFunction(537461248); int[] arrayOfInt15 = COMMON_ON_OFF;
/*  394 */     iVehicleFunction31 = iVehicleFunction31.supportedFunctionValue(arrayOfInt15);
/*  395 */     IVehicleFunction.IZone iZone27 = iVehicleFunction31.createZone(new int[] { Integer.MIN_VALUE });
/*  396 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iZone27.useStatusPAByIntBase(33653); ECarXCarVfmiscManager eCarXCarVfmiscManager11 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager11); -$$Lambda$BRkVq8k2P78ekt2mLEN8dYRxHaM -$$Lambda$BRkVq8k2P78ekt2mLEN8dYRxHaM = new -$$Lambda$BRkVq8k2P78ekt2mLEN8dYRxHaM(eCarXCarVfmiscManager11);
/*  397 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild43 = iValueTaskBuild28.onSetFunctionValue(-$$Lambda$BRkVq8k2P78ekt2mLEN8dYRxHaM, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M6 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/*  399 */     IVehicleFunction.IFilterCallback iFilterCallback23 = iValueTaskBuild43.useValuePAByIntBase(33653, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M6); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk30 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  401 */     iFilterCallback23.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk30);
/*      */ 
/*      */     
/*  404 */     IVehicleFunction iVehicleFunction30 = VehicleFunction.intFunction(537461504);
/*  405 */     iVehicleFunction30 = iVehicleFunction30.supportedFunctionValue(new int[] { 537461507, 537461505, 537461506, 0 });
/*      */ 
/*      */ 
/*      */     
/*  409 */     IVehicleFunction.IZone iZone26 = iVehicleFunction30.createZone(new int[] { Integer.MIN_VALUE });
/*  410 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iZone26.useStatusPAByIntBase(33654); ECarXCarVfmiscManager eCarXCarVfmiscManager10 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager10); -$$Lambda$1DUhDufqtAOvVShAv7xJcvhWHvM -$$Lambda$1DUhDufqtAOvVShAv7xJcvhWHvM = new -$$Lambda$1DUhDufqtAOvVShAv7xJcvhWHvM(eCarXCarVfmiscManager10);
/*      */     
/*  412 */     pairs7 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  413 */     pairs7 = pairs7.add(Integer.valueOf(537461507), Integer.valueOf(3));
/*  414 */     pairs7 = pairs7.add(Integer.valueOf(537461505), Integer.valueOf(1));
/*  415 */     pairs7 = pairs7.add(Integer.valueOf(537461506), Integer.valueOf(2)); iValueTaskBuild27 = iValueTaskBuild27.onSetFunctionValue(-$$Lambda$1DUhDufqtAOvVShAv7xJcvhWHvM, pairs7); -$$Lambda$Vehicle$H_rz8Fof_ixgM_8Q2VJfeKH2c6M -$$Lambda$Vehicle$H_rz8Fof_ixgM_8Q2VJfeKH2c6M = new -$$Lambda$Vehicle$H_rz8Fof_ixgM_8Q2VJfeKH2c6M(this);
/*  416 */     IVehicleFunction.IFilterCallback iFilterCallback22 = iValueTaskBuild27.useValuePAByIntBase(33654, -$$Lambda$Vehicle$H_rz8Fof_ixgM_8Q2VJfeKH2c6M); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk29 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  418 */     iFilterCallback22.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk29);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  457 */     IVehicleFunction iVehicleFunction29 = VehicleFunction.intFunction(537657600); int[] arrayOfInt14 = COMMON_ON_OFF;
/*  458 */     iVehicleFunction29 = iVehicleFunction29.supportedFunctionValue(arrayOfInt14);
/*  459 */     IVehicleFunction.IZone iZone25 = iVehicleFunction29.createZone(new int[] { Integer.MIN_VALUE, 1 });
/*  460 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iZone25.useStatusPAByIntBase(33353); ECarXCarClimateManager eCarXCarClimateManager3 = this.mClimateManager; Objects.requireNonNull(eCarXCarClimateManager3); -$$Lambda$rj4171WHQ5uXXLOYL2681LkDWYo -$$Lambda$rj4171WHQ5uXXLOYL2681LkDWYo = new -$$Lambda$rj4171WHQ5uXXLOYL2681LkDWYo(eCarXCarClimateManager3);
/*  461 */     iValueTaskBuild26 = iValueTaskBuild26.onSetFunctionValue(-$$Lambda$rj4171WHQ5uXXLOYL2681LkDWYo, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M11 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  462 */     IVehicleFunction.IFilterCallback iFilterCallback21 = iValueTaskBuild26.useValuePAByIntBase(33353, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M11);
/*      */     
/*  464 */     IVehicleFunction.IZone iZone24 = iFilterCallback21.createZone(new int[] { 2 });
/*  465 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iZone24.useStatusPAByIntBase(33354); ECarXCarClimateManager eCarXCarClimateManager2 = this.mClimateManager; Objects.requireNonNull(eCarXCarClimateManager2); -$$Lambda$hcDHt8kYEfv7jpiJrL4OTx67iRg -$$Lambda$hcDHt8kYEfv7jpiJrL4OTx67iRg = new -$$Lambda$hcDHt8kYEfv7jpiJrL4OTx67iRg(eCarXCarClimateManager2);
/*  466 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild42 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$hcDHt8kYEfv7jpiJrL4OTx67iRg, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M5 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*  467 */     IVehicleFunction.IFilterCallback iFilterCallback20 = iValueTaskBuild42.useValuePAByIntBase(33354, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M5); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk28 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  469 */     iFilterCallback20.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk28);
/*      */ 
/*      */     
/*  472 */     IVehicleFunction iVehicleFunction28 = VehicleFunction.intFunction(537657856); int[] arrayOfInt13 = COMMON_ON_OFF;
/*  473 */     iVehicleFunction28 = iVehicleFunction28.supportedFunctionValue(arrayOfInt13);
/*  474 */     IVehicleFunction.IZone iZone23 = iVehicleFunction28.createZone(new int[] { Integer.MIN_VALUE });
/*  475 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iZone23.useStatusPAByIntBase(33352); ECarXCarClimateManager eCarXCarClimateManager1 = this.mClimateManager; Objects.requireNonNull(eCarXCarClimateManager1); -$$Lambda$Eeuo9W26CBJAw95LHfHOYRwL6OY -$$Lambda$Eeuo9W26CBJAw95LHfHOYRwL6OY = new -$$Lambda$Eeuo9W26CBJAw95LHfHOYRwL6OY(eCarXCarClimateManager1);
/*  476 */     iValueTaskBuild24 = iValueTaskBuild24.onSetFunctionValue(-$$Lambda$Eeuo9W26CBJAw95LHfHOYRwL6OY, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M10 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/*  478 */     IVehicleFunction.IFilterCallback iFilterCallback19 = iValueTaskBuild24.useValuePAByIntBase(33352, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M10); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk27 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  480 */     iFilterCallback19.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk27);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  573 */     IVehicleFunction iVehicleFunction27 = VehicleFunction.intFunction(538312960);
/*  574 */     IVehicleFunction.IZone iZone22 = iVehicleFunction27.createZone(new int[] { Integer.MIN_VALUE });
/*  575 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus3 = iZone22.useStatusSignals(new int[] { 29475, 30788, 30779 }); -$$Lambda$Vehicle$E3_c0bFhjQXLlgRK3pwYe-s85TI -$$Lambda$Vehicle$E3_c0bFhjQXLlgRK3pwYe-s85TI = new -$$Lambda$Vehicle$E3_c0bFhjQXLlgRK3pwYe-s85TI(this);
/*      */ 
/*      */     
/*  578 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild41 = iMultiSignalStatus3.onStatusSignalChanged(-$$Lambda$Vehicle$E3_c0bFhjQXLlgRK3pwYe-s85TI); -$$Lambda$Vehicle$nSm3Ddh0mAl0wpfUu73wCXHeIhc -$$Lambda$Vehicle$nSm3Ddh0mAl0wpfUu73wCXHeIhc = new -$$Lambda$Vehicle$nSm3Ddh0mAl0wpfUu73wCXHeIhc(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  585 */     iValueTaskBuild41 = iValueTaskBuild41.onSetFunctionValue(-$$Lambda$Vehicle$nSm3Ddh0mAl0wpfUu73wCXHeIhc); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M4 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  608 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild41.useValuePAByIntBase(33814, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M4); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk26 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*  609 */     iFilterCallback18.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk26);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  618 */     IVehicleFunction iVehicleFunction26 = VehicleFunction.intFunction(538313728);
/*  619 */     iVehicleFunction26 = iVehicleFunction26.supportedFunctionValue(new int[] { 538313729, 538313730, 538313731 });
/*      */ 
/*      */ 
/*      */     
/*  623 */     IVehicleFunction.IZone iZone21 = iVehicleFunction26.createZone(new int[] { Integer.MIN_VALUE });
/*  624 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iZone21.useStatusPAByIntBase(33639); ECarXCarVfmiscManager eCarXCarVfmiscManager9 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager9); -$$Lambda$OWYGVopLS5Q8kbcIHkM-DwNSFy8 -$$Lambda$OWYGVopLS5Q8kbcIHkM-DwNSFy8 = new -$$Lambda$OWYGVopLS5Q8kbcIHkM-DwNSFy8(eCarXCarVfmiscManager9);
/*      */     
/*  626 */     pairs7 = Pairs.of(Integer.valueOf(538313729), Integer.valueOf(1));
/*      */     
/*  628 */     pairs7 = pairs7.add(Integer.valueOf(538313730), Integer.valueOf(2));
/*      */     
/*  630 */     pairs7 = pairs7.add(Integer.valueOf(538313731), Integer.valueOf(0));
/*      */     
/*  632 */     pairs7 = pairs7.orDefault(Integer.valueOf(0));
/*      */     iValueTaskBuild23 = iValueTaskBuild23.onSetFunctionValue(-$$Lambda$OWYGVopLS5Q8kbcIHkM-DwNSFy8, pairs7);
/*  634 */     Pairs pairs5 = Pairs.of(Integer.valueOf(1), Integer.valueOf(538313729));
/*      */     
/*  636 */     pairs5 = pairs5.add(Integer.valueOf(2), Integer.valueOf(538313730));
/*      */     
/*  638 */     pairs5 = pairs5.add(Integer.valueOf(0), Integer.valueOf(538313731));
/*      */     
/*  640 */     pairs5 = pairs5.orDefault(Integer.valueOf(538313731)); IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild23.useValuePAByIntBase(33639, pairs5); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk25 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*  641 */     iFilterCallback17.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk25);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  647 */     IVehicleFunction iVehicleFunction25 = VehicleFunction.intFunction(538314240);
/*  648 */     iVehicleFunction25 = iVehicleFunction25.supportedFunctionValue(new int[] { 1 });
/*  649 */     IVehicleFunction.IZone iZone20 = iVehicleFunction25.createZone(new int[] { Integer.MIN_VALUE });
/*  650 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus2 = iZone20.useStatusSignals(new int[] { 29475, 30788 }); -$$Lambda$Vehicle$0yyI6rumv8tzy5FfZ5IUY_o4eUQ -$$Lambda$Vehicle$0yyI6rumv8tzy5FfZ5IUY_o4eUQ = new -$$Lambda$Vehicle$0yyI6rumv8tzy5FfZ5IUY_o4eUQ(this);
/*      */     
/*  652 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild40 = iMultiSignalStatus2.onStatusSignalChanged(-$$Lambda$Vehicle$0yyI6rumv8tzy5FfZ5IUY_o4eUQ); -$$Lambda$Vehicle$KMDgF_R5xgUfBWgVJugYPWfIAes -$$Lambda$Vehicle$KMDgF_R5xgUfBWgVJugYPWfIAes = new -$$Lambda$Vehicle$KMDgF_R5xgUfBWgVJugYPWfIAes(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  664 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iValueTaskBuild40.onSetFunctionValue(-$$Lambda$Vehicle$KMDgF_R5xgUfBWgVJugYPWfIAes); -$$Lambda$Vehicle$sezPMZZDx83_ENiIWguOgzaPSIU -$$Lambda$Vehicle$sezPMZZDx83_ENiIWguOgzaPSIU = new -$$Lambda$Vehicle$sezPMZZDx83_ENiIWguOgzaPSIU(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  675 */     IVehicleFunction.IFilterCallback iFilterCallback30 = iValueTaskBuild22.useValueSignal(31714, -$$Lambda$Vehicle$sezPMZZDx83_ENiIWguOgzaPSIU); IVehicleFunction.Mode mode = IVehicleFunction.Mode.ALWAYS; -$$Lambda$Vehicle$zQVSFGHt2wsX85K7JJLZrVVo7NI -$$Lambda$Vehicle$zQVSFGHt2wsX85K7JJLZrVVo7NI = -$$Lambda$Vehicle$zQVSFGHt2wsX85K7JJLZrVVo7NI.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  689 */     IVehicleFunction.ITaskEnd iTaskEnd2 = iFilterCallback30.filterValue(mode, -$$Lambda$Vehicle$zQVSFGHt2wsX85K7JJLZrVVo7NI); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk24 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*  690 */     iTaskEnd2.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk24);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  699 */     IVehicleFunction iVehicleFunction24 = VehicleFunction.intFunction(538509568);
/*  700 */     iVehicleFunction24 = iVehicleFunction24.supportedFunctionValue(new int[] { 538509569, 538509570, 538509571, 538509572, 538509573 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  706 */     IVehicleFunction.IZone iZone19 = iVehicleFunction24.createZone(new int[] { Integer.MIN_VALUE });
/*  707 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iZone19.useStatusPAByIntBase(33658); ECarXCarVfmiscManager eCarXCarVfmiscManager8 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager8); -$$Lambda$vdjULCOZLDK5N2kJ_HSueECs2z0 -$$Lambda$vdjULCOZLDK5N2kJ_HSueECs2z0 = new -$$Lambda$vdjULCOZLDK5N2kJ_HSueECs2z0(eCarXCarVfmiscManager8);
/*      */     
/*  709 */     Pairs pairs6 = Pairs.of(Integer.valueOf(538509569), Integer.valueOf(1));
/*  710 */     pairs6 = pairs6.add(Integer.valueOf(538509570), Integer.valueOf(2));
/*  711 */     pairs6 = pairs6.add(Integer.valueOf(538509571), Integer.valueOf(0));
/*  712 */     pairs6 = pairs6.add(Integer.valueOf(538509572), Integer.valueOf(3));
/*  713 */     pairs6 = pairs6.add(Integer.valueOf(538509573), Integer.valueOf(4)); iValueTaskBuild21 = iValueTaskBuild21.onSetFunctionValue(-$$Lambda$vdjULCOZLDK5N2kJ_HSueECs2z0, pairs6); -$$Lambda$Vehicle$3QaZmvxD6rBx4q_PdQu3oF_1hN0 -$$Lambda$Vehicle$3QaZmvxD6rBx4q_PdQu3oF_1hN0 = new -$$Lambda$Vehicle$3QaZmvxD6rBx4q_PdQu3oF_1hN0(this);
/*  714 */     IVehicleFunction.IFilterCallback iFilterCallback29 = iValueTaskBuild21.useValuePAByIntBase(33658, -$$Lambda$Vehicle$3QaZmvxD6rBx4q_PdQu3oF_1hN0); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk14 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  716 */     iFilterCallback29.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk14);
/*      */ 
/*      */     
/*  719 */     IVehicleFunction iVehicleFunction23 = VehicleFunction.intFunction(538509824); int[] arrayOfInt12 = COMMON_ON_OFF;
/*  720 */     iVehicleFunction23 = iVehicleFunction23.supportedFunctionValue(arrayOfInt12);
/*  721 */     IVehicleFunction.IZone iZone18 = iVehicleFunction23.createZone(new int[] { Integer.MIN_VALUE });
/*  722 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iZone18.useStatusPAByIntBase(33657); ECarXCarVfmiscManager eCarXCarVfmiscManager7 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager7); -$$Lambda$eU_tp8uKOeXIqIucAWJvFw93VRo -$$Lambda$eU_tp8uKOeXIqIucAWJvFw93VRo = new -$$Lambda$eU_tp8uKOeXIqIucAWJvFw93VRo(eCarXCarVfmiscManager7);
/*      */     
/*  724 */     pairs6 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  725 */     pairs6 = pairs6.add(Integer.valueOf(1), Integer.valueOf(1)); iValueTaskBuild20 = iValueTaskBuild20.onSetFunctionValue(-$$Lambda$eU_tp8uKOeXIqIucAWJvFw93VRo, pairs6); -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc = -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc.INSTANCE;
/*  726 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild20.useValuePAByIntBase(33657, -$$Lambda$xzUZgG6sFOTTnEGWcw2k-8-_khc); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk23 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  728 */     iFilterCallback16.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk23);
/*      */ 
/*      */     
/*  731 */     IVehicleFunction iVehicleFunction22 = VehicleFunction.intFunction(538510080); int[] arrayOfInt11 = COMMON_ON_OFF;
/*  732 */     iVehicleFunction22 = iVehicleFunction22.supportedFunctionValue(arrayOfInt11);
/*  733 */     IVehicleFunction.IZone iZone17 = iVehicleFunction22.createZone(new int[] { Integer.MIN_VALUE });
/*  734 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iZone17.useStatusPAByIntBase(33656); ECarXCarVfmiscManager eCarXCarVfmiscManager6 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager6); -$$Lambda$O1oPMyFARlWiHoTm0jStKDFWIog -$$Lambda$O1oPMyFARlWiHoTm0jStKDFWIog = new -$$Lambda$O1oPMyFARlWiHoTm0jStKDFWIog(eCarXCarVfmiscManager6);
/*      */     
/*  736 */     pairs6 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  737 */     pairs6 = pairs6.add(Integer.valueOf(1), Integer.valueOf(1)); iValueTaskBuild19 = iValueTaskBuild19.onSetFunctionValue(-$$Lambda$O1oPMyFARlWiHoTm0jStKDFWIog, pairs6); -$$Lambda$4KZDUrqdnrWwy8Oyxq3D9XVPM9c -$$Lambda$4KZDUrqdnrWwy8Oyxq3D9XVPM9c = -$$Lambda$4KZDUrqdnrWwy8Oyxq3D9XVPM9c.INSTANCE;
/*  738 */     IVehicleFunction.IFilterCallback iFilterCallback28 = iValueTaskBuild19.useValuePAByIntBase(33656, -$$Lambda$4KZDUrqdnrWwy8Oyxq3D9XVPM9c); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk13 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  740 */     iFilterCallback28.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk13);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  746 */     IVehicleFunction iVehicleFunction21 = VehicleFunction.intFunction(538575104); int[] arrayOfInt10 = COMMON_ON_OFF;
/*  747 */     iVehicleFunction21 = iVehicleFunction21.supportedFunctionValue(arrayOfInt10);
/*  748 */     IVehicleFunction.IZone iZone16 = iVehicleFunction21.createZone(new int[] { Integer.MIN_VALUE });
/*  749 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iZone16.useStatusPAByIntBase(33663); ECarXCarVfmiscManager eCarXCarVfmiscManager5 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager5); -$$Lambda$yClVFS7RGLP5t0rWr31RlK3c8FY -$$Lambda$yClVFS7RGLP5t0rWr31RlK3c8FY = new -$$Lambda$yClVFS7RGLP5t0rWr31RlK3c8FY(eCarXCarVfmiscManager5);
/*  750 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild39 = iValueTaskBuild18.onSetFunctionValue(-$$Lambda$yClVFS7RGLP5t0rWr31RlK3c8FY, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M3 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/*      */     
/*  752 */     IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild39.useValuePAByIntBase(33663, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M3); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk22 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  754 */     iFilterCallback15.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk22);
/*      */ 
/*      */     
/*  757 */     IVehicleFunction iVehicleFunction20 = VehicleFunction.intFunction(538575360);
/*  758 */     iVehicleFunction20 = iVehicleFunction20.supportedFunctionValue(new int[] { 538575361, 538575362, 538575363 });
/*      */ 
/*      */ 
/*      */     
/*  762 */     IVehicleFunction.IZone iZone15 = iVehicleFunction20.createZone(new int[] { Integer.MIN_VALUE });
/*  763 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iZone15.useStatusPAByIntBase(33665); ECarXCarVfmiscManager eCarXCarVfmiscManager4 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager4); -$$Lambda$-D3CuWfPSF0NZ0NJ1Xy14aIKSzc -$$Lambda$-D3CuWfPSF0NZ0NJ1Xy14aIKSzc = new -$$Lambda$-D3CuWfPSF0NZ0NJ1Xy14aIKSzc(eCarXCarVfmiscManager4);
/*      */     
/*  765 */     pairs6 = Pairs.of(Integer.valueOf(538575362), Integer.valueOf(1));
/*  766 */     pairs6 = pairs6.add(Integer.valueOf(538575361), Integer.valueOf(0));
/*  767 */     pairs6 = pairs6.add(Integer.valueOf(538575363), Integer.valueOf(2)); IVehicleFunction.IValueTaskBuild iValueTaskBuild38 = iValueTaskBuild17.onSetFunctionValue(-$$Lambda$-D3CuWfPSF0NZ0NJ1Xy14aIKSzc, pairs6); -$$Lambda$Vehicle$RyXhnWaHnOAbTwThfLQkjuNKz7Q -$$Lambda$Vehicle$RyXhnWaHnOAbTwThfLQkjuNKz7Q = new -$$Lambda$Vehicle$RyXhnWaHnOAbTwThfLQkjuNKz7Q(this);
/*  768 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild38.useValuePAByIntBase(33665, -$$Lambda$Vehicle$RyXhnWaHnOAbTwThfLQkjuNKz7Q); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk21 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  770 */     iFilterCallback14.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk21);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  804 */     IVehicleFunction iVehicleFunction19 = VehicleFunction.intFunction(538706432);
/*  805 */     iVehicleFunction19 = iVehicleFunction19.supportedFunctionValue(new int[] { 1, 0 });
/*  806 */     IVehicleFunction.IZone iZone14 = iVehicleFunction19.createZone(new int[] { Integer.MIN_VALUE });
/*  807 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iZone14.useStatusPAByIntBase(33868); ECarXCarFaceidManager eCarXCarFaceidManager = this.mECarXCarFaceidManager; Objects.requireNonNull(eCarXCarFaceidManager); -$$Lambda$bdlMlLYwpAzIYZ9bDW73vPICDtg -$$Lambda$bdlMlLYwpAzIYZ9bDW73vPICDtg = new -$$Lambda$bdlMlLYwpAzIYZ9bDW73vPICDtg(eCarXCarFaceidManager); -$$Lambda$Vehicle$bmeQIWSVbdiYZuuE0x6OuqayOxU -$$Lambda$Vehicle$bmeQIWSVbdiYZuuE0x6OuqayOxU = new -$$Lambda$Vehicle$bmeQIWSVbdiYZuuE0x6OuqayOxU(this);
/*  808 */     iValueTaskBuild16 = iValueTaskBuild16.onSetFunctionValue(-$$Lambda$bdlMlLYwpAzIYZ9bDW73vPICDtg, -$$Lambda$Vehicle$bmeQIWSVbdiYZuuE0x6OuqayOxU);
/*  809 */     IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild16.useValuePAByIntBase(33868, pairs4); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk20 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  811 */     iFilterCallback13.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk20);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  850 */     IVehicleFunction iVehicleFunction18 = VehicleFunction.intFunction(538903808); int[] arrayOfInt9 = COMMON_ON_OFF;
/*  851 */     iVehicleFunction18 = iVehicleFunction18.supportedFunctionValue(arrayOfInt9);
/*  852 */     IVehicleFunction.IZone iZone13 = iVehicleFunction18.createZone();
/*  853 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone13.useStatusPAByIntBase(33932); ECarXCarVfnaviManager eCarXCarVfnaviManager = this.mECarXCarVfnaviManager; Objects.requireNonNull(eCarXCarVfnaviManager); -$$Lambda$hEnzCyoYEmdaMoNxCiP7mdOJcbA -$$Lambda$hEnzCyoYEmdaMoNxCiP7mdOJcbA = new -$$Lambda$hEnzCyoYEmdaMoNxCiP7mdOJcbA(eCarXCarVfnaviManager); -$$Lambda$Vehicle$7MwRGctTwxWyjQZwDxNIhp46YdE -$$Lambda$Vehicle$7MwRGctTwxWyjQZwDxNIhp46YdE = new -$$Lambda$Vehicle$7MwRGctTwxWyjQZwDxNIhp46YdE(this);
/*  854 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild37 = iValueTaskBuild15.onSetFunctionValue(-$$Lambda$hEnzCyoYEmdaMoNxCiP7mdOJcbA, -$$Lambda$Vehicle$7MwRGctTwxWyjQZwDxNIhp46YdE); -$$Lambda$dn0QO40cpNUNPZjuHMib-6TAzJs -$$Lambda$dn0QO40cpNUNPZjuHMib-6TAzJs = new -$$Lambda$dn0QO40cpNUNPZjuHMib-6TAzJs(this);
/*      */     
/*  856 */     IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild37.useValuePAByIntBase(33932, -$$Lambda$dn0QO40cpNUNPZjuHMib-6TAzJs); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk19 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  858 */     iFilterCallback12.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk19);
/*      */ 
/*      */     
/*  861 */     IVehicleFunction iVehicleFunction40 = VehicleFunction.intFunction(538904064); int[] arrayOfInt6 = COMMON_ON_OFF;
/*  862 */     IVehicleFunction iVehicleFunction17 = iVehicleFunction40.supportedFunctionValue(arrayOfInt6);
/*  863 */     IVehicleFunction.IZone iZone12 = iVehicleFunction17.createZone();
/*  864 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iZone12.useStatusPAByIntBase(33704); ECarXCarVfmiscManager eCarXCarVfmiscManager3 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager3); -$$Lambda$5r5pIfDCmLmCJa8bhhUzrTP8kOc -$$Lambda$5r5pIfDCmLmCJa8bhhUzrTP8kOc = new -$$Lambda$5r5pIfDCmLmCJa8bhhUzrTP8kOc(eCarXCarVfmiscManager3);
/*  865 */     iValueTaskBuild14 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$5r5pIfDCmLmCJa8bhhUzrTP8kOc, pairs1);
/*  866 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild14.useValuePAByIntBase(33704, pairs4); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk12 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/*  868 */     iFilterCallback7.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk12);
/*      */ 
/*      */     
/*  871 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(538904320); int[] arrayOfInt5 = COMMON_ON_OFF;
/*  872 */     IVehicleFunction iVehicleFunction9 = iVehicleFunction16.supportedFunctionValue(arrayOfInt5);
/*  873 */     IVehicleFunction.IZone iZone7 = iVehicleFunction9.createZone(); -$$Lambda$Vehicle$mE2PwRBCqczJ_d5SHPTqCpmTmjU -$$Lambda$Vehicle$mE2PwRBCqczJ_d5SHPTqCpmTmjU = new -$$Lambda$Vehicle$mE2PwRBCqczJ_d5SHPTqCpmTmjU(this);
/*  874 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iZone7.customStatus(-$$Lambda$Vehicle$mE2PwRBCqczJ_d5SHPTqCpmTmjU); -$$Lambda$Vehicle$GAXNiSWlbTKaWSQc5xmjNgW9IQw -$$Lambda$Vehicle$GAXNiSWlbTKaWSQc5xmjNgW9IQw = new -$$Lambda$Vehicle$GAXNiSWlbTKaWSQc5xmjNgW9IQw(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  888 */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$Vehicle$GAXNiSWlbTKaWSQc5xmjNgW9IQw); -$$Lambda$Vehicle$hpen1KvtqnGmh2QXyGd6K-pbfbI -$$Lambda$Vehicle$hpen1KvtqnGmh2QXyGd6K-pbfbI = new -$$Lambda$Vehicle$hpen1KvtqnGmh2QXyGd6K-pbfbI(this);
/*  889 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild8.customValue(-$$Lambda$Vehicle$hpen1KvtqnGmh2QXyGd6K-pbfbI); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk11 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  897 */     iFilterCallback6.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk11);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  904 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(538904832);
/*  905 */     iVehicleFunction8 = iVehicleFunction8.supportedFunctionValue(new int[] { 538904832, 538904833, 538904834 });
/*      */ 
/*      */     
/*  908 */     IVehicleFunction.IZone iZone6 = iVehicleFunction8.createZone();
/*  909 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus1 = iZone6.useStatusSignals(new int[] { 29337, 30788 }); -$$Lambda$Vehicle$U-uLHXtQY8QzSMDewUxPfrSe9og -$$Lambda$Vehicle$U-uLHXtQY8QzSMDewUxPfrSe9og = new -$$Lambda$Vehicle$U-uLHXtQY8QzSMDewUxPfrSe9og(this);
/*      */     
/*  911 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iMultiSignalStatus1.onStatusSignalChanged(-$$Lambda$Vehicle$U-uLHXtQY8QzSMDewUxPfrSe9og);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  919 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue = iValueTaskBuild7.useValueSignals(new int[] { 31458 }); -$$Lambda$Vehicle$6CoJ3r0kssjW1dgje1zcER_0vtU -$$Lambda$Vehicle$6CoJ3r0kssjW1dgje1zcER_0vtU = new -$$Lambda$Vehicle$6CoJ3r0kssjW1dgje1zcER_0vtU(this);
/*  920 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iMultiSignalValue.onValueSignalChanged(-$$Lambda$Vehicle$6CoJ3r0kssjW1dgje1zcER_0vtU); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk6 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  938 */     iFilterCallback11.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk6);
/*      */ 
/*      */     
/*  941 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.intFunction(538968320); int[] arrayOfInt4 = COMMON_ON_OFF;
/*  942 */     IVehicleFunction iVehicleFunction7 = iVehicleFunction15.supportedFunctionValue(arrayOfInt4);
/*  943 */     IVehicleFunction.IZone iZone5 = iVehicleFunction7.createZone(); FunctionStatus functionStatus4 = FunctionStatus.active;
/*  944 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone5.fixStatus(functionStatus4); CarSignalManager carSignalManager = this.mCarSignalManager; Objects.requireNonNull(carSignalManager); -$$Lambda$qxzK8OBr7uk45yw0JD3eXdD24nM -$$Lambda$qxzK8OBr7uk45yw0JD3eXdD24nM = new -$$Lambda$qxzK8OBr7uk45yw0JD3eXdD24nM(carSignalManager); -$$Lambda$Vehicle$Zgm_s6LuIgJaRK3N55rPX3pCF2Q -$$Lambda$Vehicle$Zgm_s6LuIgJaRK3N55rPX3pCF2Q = -$$Lambda$Vehicle$Zgm_s6LuIgJaRK3N55rPX3pCF2Q.INSTANCE;
/*  945 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$qxzK8OBr7uk45yw0JD3eXdD24nM, -$$Lambda$Vehicle$Zgm_s6LuIgJaRK3N55rPX3pCF2Q); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk5 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*  946 */     iValueTaskBuild13.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk5);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  953 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(539033856); int[] arrayOfInt3 = COMMON_ON_OFF;
/*  954 */     IVehicleFunction iVehicleFunction6 = iVehicleFunction14.supportedFunctionValue(arrayOfInt3);
/*  955 */     IVehicleFunction.IZone iZone11 = iVehicleFunction6.createZone(); FunctionStatus functionStatus3 = FunctionStatus.active;
/*  956 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone11.fixStatus(functionStatus3); -$$Lambda$Vehicle$yYbfNCZOfbxnzl7tOwaOT-LjDRU -$$Lambda$Vehicle$yYbfNCZOfbxnzl7tOwaOT-LjDRU = new -$$Lambda$Vehicle$yYbfNCZOfbxnzl7tOwaOT-LjDRU(this);
/*  957 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild12.customValue(-$$Lambda$Vehicle$yYbfNCZOfbxnzl7tOwaOT-LjDRU); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk10 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*  958 */     iFilterCallback5.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk10);
/*      */ 
/*      */ 
/*      */     
/*  962 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.intFunction(539034112);
/*  963 */     iVehicleFunction5 = iVehicleFunction5.supportedFunctionValue(new int[] { 0, 539034113, 539034114, 539034115, 539034116, 539034117, 539034118, 539034119, 539034120, 539034121, 539034122, 539034123, 539034124, 539034125, 539034126, 539034127, 539034128, 539034129, 539034130, 539034131, 539034132, 539034133, 539034134, 539034135, 539034136, 539034137, 539034138, 539034139, 539034140, 539034141, 539034142, 539034143, 539034144, 539034145, 539034146, 539034147, 539034148, 539034149, 539034150, 539034151, 539034152 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1005 */     IVehicleFunction.IZone iZone4 = iVehicleFunction5.createZone(); -$$Lambda$Vehicle$OVUTDG4sXHGPMNnfrF1YUWoGzlk -$$Lambda$Vehicle$OVUTDG4sXHGPMNnfrF1YUWoGzlk = new -$$Lambda$Vehicle$OVUTDG4sXHGPMNnfrF1YUWoGzlk(this);
/* 1006 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone4.customStatus(-$$Lambda$Vehicle$OVUTDG4sXHGPMNnfrF1YUWoGzlk); -$$Lambda$Vehicle$vpFpUMpiMI7qtq18fyy5lboUaHo -$$Lambda$Vehicle$vpFpUMpiMI7qtq18fyy5lboUaHo = new -$$Lambda$Vehicle$vpFpUMpiMI7qtq18fyy5lboUaHo(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1020 */     iValueTaskBuild5 = iValueTaskBuild5.onSetFunctionValue(-$$Lambda$Vehicle$vpFpUMpiMI7qtq18fyy5lboUaHo); -$$Lambda$Vehicle$uq7_Z8SEgPMzN_Kd6Z9b3W7UP-8 -$$Lambda$Vehicle$uq7_Z8SEgPMzN_Kd6Z9b3W7UP-8 = new -$$Lambda$Vehicle$uq7_Z8SEgPMzN_Kd6Z9b3W7UP-8(this);
/* 1021 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild5.customValue(-$$Lambda$Vehicle$uq7_Z8SEgPMzN_Kd6Z9b3W7UP-8); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk4 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1112 */     iFilterCallback10.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk4);
/*      */ 
/*      */     
/* 1115 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(539034368);
/* 1116 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(new int[] { 0, 539034369, 539034370, 539034371 });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1121 */     IVehicleFunction.IZone iZone10 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 1122 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iZone10.fixStatus(functionStatus2); -$$Lambda$Vehicle$v8j6mLpczsMiSvPcRCphewvswj8 -$$Lambda$Vehicle$v8j6mLpczsMiSvPcRCphewvswj8 = new -$$Lambda$Vehicle$v8j6mLpczsMiSvPcRCphewvswj8(this);
/* 1123 */     iValueTaskBuild11 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$Vehicle$v8j6mLpczsMiSvPcRCphewvswj8); -$$Lambda$Vehicle$eyA8BoEnWVUsxUrOaal2rQGBbZM -$$Lambda$Vehicle$eyA8BoEnWVUsxUrOaal2rQGBbZM = new -$$Lambda$Vehicle$eyA8BoEnWVUsxUrOaal2rQGBbZM(this);
/* 1124 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild11.customValue(-$$Lambda$Vehicle$eyA8BoEnWVUsxUrOaal2rQGBbZM); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk3 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1143 */     iFilterCallback9.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk3);
/*      */ 
/*      */     
/* 1146 */     ProFunction proFunction2 = ProFunction.proFunction(539034624);
/* 1147 */     ProFunction.Zone zone = proFunction2.createZone(-2147483648); -$$Lambda$Vehicle$vA5-AFut9yq7qnr7xyv-fVy2ehc -$$Lambda$Vehicle$vA5-AFut9yq7qnr7xyv-fVy2ehc = -$$Lambda$Vehicle$vA5-AFut9yq7qnr7xyv-fVy2ehc.INSTANCE;
/* 1148 */     zone = zone.onPropertyStatus(-$$Lambda$Vehicle$vA5-AFut9yq7qnr7xyv-fVy2ehc); -$$Lambda$Vehicle$5_aJ0qVBs-n43juP0uufga1SQd8 -$$Lambda$Vehicle$5_aJ0qVBs-n43juP0uufga1SQd8 = new -$$Lambda$Vehicle$5_aJ0qVBs-n43juP0uufga1SQd8(this);
/* 1149 */     zone = zone.onSetProperty(-$$Lambda$Vehicle$5_aJ0qVBs-n43juP0uufga1SQd8); -$$Lambda$Vehicle$9MA5Rh3z3y-fwb6nJ_HXqVnj9Vc -$$Lambda$Vehicle$9MA5Rh3z3y-fwb6nJ_HXqVnj9Vc = new -$$Lambda$Vehicle$9MA5Rh3z3y-fwb6nJ_HXqVnj9Vc(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1164 */     ProFunction proFunction1 = zone.onPropertyValue(-$$Lambda$Vehicle$9MA5Rh3z3y-fwb6nJ_HXqVnj9Vc); -$$Lambda$Vehicle$WxRDvhiryPN7bd9t6QNo8p-Bqyk -$$Lambda$Vehicle$WxRDvhiryPN7bd9t6QNo8p-Bqyk = new -$$Lambda$Vehicle$WxRDvhiryPN7bd9t6QNo8p-Bqyk(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1174 */     proFunction1.addProFunction(-$$Lambda$Vehicle$WxRDvhiryPN7bd9t6QNo8p-Bqyk);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1238 */     Pairs pairs3 = Pairs.of(Integer.valueOf(0), Integer.valueOf(539430400));
/* 1239 */     pairs3 = pairs3.add(Integer.valueOf(1), Integer.valueOf(539430401));
/* 1240 */     pairs3 = pairs3.add(Integer.valueOf(2), Integer.valueOf(539430402)); pairs3 = pairs3.add(Integer.valueOf(3), Integer.valueOf(539430403));
/* 1241 */     pairs3 = pairs3.add(Integer.valueOf(4), Integer.valueOf(539430404));
/*      */     
/* 1243 */     pairs3 = pairs3.add(Integer.valueOf(5), Integer.valueOf(539430405)); pairs3 = pairs3.add(Integer.valueOf(6), Integer.valueOf(539430406));
/* 1244 */     pairs3 = pairs3.add(Integer.valueOf(7), Integer.valueOf(539430407));
/*      */     
/* 1246 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.intFunction(539430400);
/* 1247 */     iVehicleFunction13 = iVehicleFunction13.supportedFunctionValue(new int[] { 539430400, 539430401, 539430402, 539430403, 539430404, 539430405, 539430406, 539430407 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1255 */     IVehicleFunction.IZone iZone9 = iVehicleFunction13.createZone(); FunctionStatus functionStatus5 = FunctionStatus.active;
/* 1256 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iZone9.fixStatus(functionStatus5);
/* 1257 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild10.useValueSignal(31455, pairs3); -$$Lambda$Vehicle$gWI5Rl79B84mMYe2O4sQKOZXJYk -$$Lambda$Vehicle$gWI5Rl79B84mMYe2O4sQKOZXJYk = new -$$Lambda$Vehicle$gWI5Rl79B84mMYe2O4sQKOZXJYk(this);
/* 1258 */     IVehicleFunction.ITaskEnd iTaskEnd1 = iFilterCallback8.filterValue(-$$Lambda$Vehicle$gWI5Rl79B84mMYe2O4sQKOZXJYk); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk9 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */ 
/*      */     
/* 1261 */     iTaskEnd1.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk9);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1301 */     Pairs pairs2 = Pairs.of(Integer.valueOf(0), Integer.valueOf(539495680));
/*      */     
/* 1303 */     pairs2 = pairs2.add(Integer.valueOf(1), Integer.valueOf(539495681));
/*      */     
/* 1305 */     pairs2 = pairs2.add(Integer.valueOf(2), Integer.valueOf(539495682));
/*      */     
/* 1307 */     pairs2 = pairs2.add(Integer.valueOf(3), Integer.valueOf(539495683));
/*      */     
/* 1309 */     pairs2 = pairs2.add(Integer.valueOf(4), Integer.valueOf(539495684));
/*      */     
/* 1311 */     pairs2 = pairs2.add(Integer.valueOf(5), Integer.valueOf(539495685));
/*      */     
/* 1313 */     pairs2 = pairs2.add(Integer.valueOf(6), Integer.valueOf(539495686));
/*      */     
/* 1315 */     pairs2 = pairs2.add(Integer.valueOf(7), Integer.valueOf(539495688));
/*      */     
/* 1317 */     pairs2 = pairs2.add(Integer.valueOf(8), Integer.valueOf(539495689));
/*      */     
/* 1319 */     pairs2 = pairs2.add(Integer.valueOf(9), Integer.valueOf(539495696));
/*      */     
/* 1321 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.intFunction(539495680);
/* 1322 */     iVehicleFunction12 = iVehicleFunction12.supportedFunctionValue(new int[] { 539495680, 539495681, 539495682, 539495683, 539495684, 539495685, 539495686, 539495688, 539495689, 539495696 });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1332 */     IVehicleFunction.IZone iZone8 = iVehicleFunction12.createZone(); functionStatus5 = FunctionStatus.active;
/* 1333 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone8.fixStatus(functionStatus5);
/* 1334 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild9.useValueSignal(31457, pairs2); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk8 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/* 1336 */     iFilterCallback4.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk8);
/*      */ 
/*      */     
/* 1339 */     int i = getSignalValue(29480);
/* 1340 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("multidisplay carConfig449Value=0x"); stringBuilder.append(Integer.toHexString(i)); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 1341 */     if (132 == i) {
/* 1342 */       this.mIEcarxMultidisplayCallback = (IEcarxMultidisplayCallback)new EcarxMultidisplayCallbackImpl();
/* 1343 */       this.mEcarxMultidisplayManager = EcarxMultidisplayManager.getInstance(this.mContext);
/* 1344 */       this.mEcarxMultidisplayManager.registerCallback(this.mIEcarxMultidisplayCallback);
/*      */       
/* 1346 */       Log.d("Vehicle_AdaptAPi", "multidisplay SETTING_FUNC_PSD_SCREEN_SWITCH init");
/*      */       
/* 1348 */       Pairs pairs = Pairs.of(Integer.valueOf(0), Integer.valueOf(1));
/* 1349 */       pairs = pairs.add(Integer.valueOf(1), Integer.valueOf(2));
/* 1350 */       IVehicleFunction iVehicleFunction44 = VehicleFunction.intFunction(539495936); int[] arrayOfInt = COMMON_ON_OFF;
/* 1351 */       IVehicleFunction iVehicleFunction43 = iVehicleFunction44.supportedFunctionValue(arrayOfInt);
/* 1352 */       IVehicleFunction.IZone iZone = iVehicleFunction43.createZone(new int[] { Integer.MIN_VALUE });
/* 1353 */       IVehicleFunction.IMultiSignalStatus iMultiSignalStatus = iZone.useStatusSignals(new int[] { 29480 }); -$$Lambda$Vehicle$k5-Sw3HHss9r9vDiEO2Lj-tl8hU -$$Lambda$Vehicle$k5-Sw3HHss9r9vDiEO2Lj-tl8hU = new -$$Lambda$Vehicle$k5-Sw3HHss9r9vDiEO2Lj-tl8hU(this);
/* 1354 */       IVehicleFunction.IValueTaskBuild iValueTaskBuild48 = iMultiSignalStatus.onStatusSignalChanged(-$$Lambda$Vehicle$k5-Sw3HHss9r9vDiEO2Lj-tl8hU); -$$Lambda$Vehicle$6KVi3HetxCqQBDRJHbHU4w6Ub7c -$$Lambda$Vehicle$6KVi3HetxCqQBDRJHbHU4w6Ub7c = new -$$Lambda$Vehicle$6KVi3HetxCqQBDRJHbHU4w6Ub7c(this);
/* 1355 */       IVehicleFunction.IValueTaskBuild iValueTaskBuild47 = iValueTaskBuild48.onSetFunctionValue(-$$Lambda$Vehicle$6KVi3HetxCqQBDRJHbHU4w6Ub7c, pairs); -$$Lambda$Vehicle$bcyEUzkK53EqX7R1ahyMKnsJQAo -$$Lambda$Vehicle$bcyEUzkK53EqX7R1ahyMKnsJQAo = new -$$Lambda$Vehicle$bcyEUzkK53EqX7R1ahyMKnsJQAo(this);
/* 1356 */       IVehicleFunction.IFilterCallback iFilterCallback = iValueTaskBuild47.customValue(-$$Lambda$Vehicle$bcyEUzkK53EqX7R1ahyMKnsJQAo); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1381 */       iFilterCallback.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk);
/*      */     } 
/*      */ 
/*      */     
/* 1385 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(539755776); int[] arrayOfInt2 = COMMON_ON_OFF;
/* 1386 */     IVehicleFunction iVehicleFunction3 = iVehicleFunction11.supportedFunctionValue(arrayOfInt2);
/* 1387 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE });
/* 1388 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone3.useStatusPAByIntBase(33708); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$0-QtXDD7x7yRjpapxAnqDb-w8NI -$$Lambda$0-QtXDD7x7yRjpapxAnqDb-w8NI = new -$$Lambda$0-QtXDD7x7yRjpapxAnqDb-w8NI(eCarXCarVfmiscManager2);
/* 1389 */     iValueTaskBuild4 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$0-QtXDD7x7yRjpapxAnqDb-w8NI, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/* 1390 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild4.useValuePAByIntBase(33708, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M2); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk7 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/* 1392 */     iFilterCallback3.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk7);
/*      */ 
/*      */     
/* 1395 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(539756032); int[] arrayOfInt1 = COMMON_ON_OFF;
/* 1396 */     IVehicleFunction iVehicleFunction2 = iVehicleFunction10.supportedFunctionValue(arrayOfInt1);
/* 1397 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE });
/* 1398 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone2.useStatusPAByIntBase(33709); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mVFMiscManager; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$mv5XizcUvPO3J61K-ocS0embMds -$$Lambda$mv5XizcUvPO3J61K-ocS0embMds = new -$$Lambda$mv5XizcUvPO3J61K-ocS0embMds(eCarXCarVfmiscManager1);
/* 1399 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$mv5XizcUvPO3J61K-ocS0embMds, pairs1); -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1 = -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M.INSTANCE;
/* 1400 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild2.useValuePAByIntBase(33709, -$$Lambda$Vcy9HOtIvo-0-B5R01_4B6NMm3M1); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk2 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/*      */     
/* 1402 */     iFilterCallback1.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk2);
/*      */ 
/*      */     
/* 1405 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(539756288);
/* 1406 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 1407 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.fixStatus(functionStatus1); -$$Lambda$Vehicle$AJB7ezlTWud0_gcEp6Fxl9KbVHY -$$Lambda$Vehicle$AJB7ezlTWud0_gcEp6Fxl9KbVHY = -$$Lambda$Vehicle$AJB7ezlTWud0_gcEp6Fxl9KbVHY.INSTANCE;
/* 1408 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild1.useValueSignal(30463, -$$Lambda$Vehicle$AJB7ezlTWud0_gcEp6Fxl9KbVHY); -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk1 = new -$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk(this);
/* 1409 */     iFilterCallback2.addTo(-$$Lambda$Vehicle$mDSG_gu-cxNEsefBS49BX_3Xzxk1);
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
/*      */   private ApiResult setPsdScreenSwitch(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: monitorenter
/*      */     //   2: aload_0
/*      */     //   3: sipush #29480
/*      */     //   6: invokevirtual getSignalValue : (I)I
/*      */     //   9: istore_2
/*      */     //   10: new java/lang/StringBuilder
/*      */     //   13: astore #4
/*      */     //   15: aload #4
/*      */     //   17: invokespecial <init> : ()V
/*      */     //   20: aload #4
/*      */     //   22: ldc_w 'multidisplay setPsdScreenSwitch onOff='
/*      */     //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   28: pop
/*      */     //   29: aload #4
/*      */     //   31: iload_1
/*      */     //   32: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   35: pop
/*      */     //   36: ldc 'Vehicle_AdaptAPi'
/*      */     //   38: aload #4
/*      */     //   40: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   43: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   46: pop
/*      */     //   47: sipush #132
/*      */     //   50: iload_2
/*      */     //   51: if_icmpne -> 198
/*      */     //   54: aload_0
/*      */     //   55: getfield mEcarxMultidisplayManager : Lecarx/multidisplay/EcarxMultidisplayManager;
/*      */     //   58: ifnonnull -> 80
/*      */     //   61: ldc 'Vehicle_AdaptAPi'
/*      */     //   63: ldc_w 'multidisplay setPsdScreenSwitch failed, mEcarxMultidisplayManager=null return ApiResult.FAILED'
/*      */     //   66: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   69: pop
/*      */     //   70: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*      */     //   73: astore #4
/*      */     //   75: aload_0
/*      */     //   76: monitorexit
/*      */     //   77: aload #4
/*      */     //   79: areturn
/*      */     //   80: iload_1
/*      */     //   81: iconst_2
/*      */     //   82: if_icmpne -> 106
/*      */     //   85: ldc 'Vehicle_AdaptAPi'
/*      */     //   87: ldc_w 'multidisplay setPsdScreenSwitch on'
/*      */     //   90: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   93: pop
/*      */     //   94: aload_0
/*      */     //   95: getfield mEcarxMultidisplayManager : Lecarx/multidisplay/EcarxMultidisplayManager;
/*      */     //   98: iconst_2
/*      */     //   99: invokevirtual setPsdDisplayOnAndOff : (I)Z
/*      */     //   102: istore_3
/*      */     //   103: goto -> 129
/*      */     //   106: iload_1
/*      */     //   107: iconst_1
/*      */     //   108: if_icmpne -> 153
/*      */     //   111: ldc 'Vehicle_AdaptAPi'
/*      */     //   113: ldc_w 'multidisplay setPsdScreenSwitch off'
/*      */     //   116: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   119: pop
/*      */     //   120: aload_0
/*      */     //   121: getfield mEcarxMultidisplayManager : Lecarx/multidisplay/EcarxMultidisplayManager;
/*      */     //   124: iconst_1
/*      */     //   125: invokevirtual setPsdDisplayOnAndOff : (I)Z
/*      */     //   128: istore_3
/*      */     //   129: iload_3
/*      */     //   130: ifeq -> 143
/*      */     //   133: getstatic ecarx/car/hardware/annotation/ApiResult.SUCCEED : Lecarx/car/hardware/annotation/ApiResult;
/*      */     //   136: astore #4
/*      */     //   138: aload_0
/*      */     //   139: monitorexit
/*      */     //   140: aload #4
/*      */     //   142: areturn
/*      */     //   143: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*      */     //   146: astore #4
/*      */     //   148: aload_0
/*      */     //   149: monitorexit
/*      */     //   150: aload #4
/*      */     //   152: areturn
/*      */     //   153: ldc 'Vehicle_AdaptAPi'
/*      */     //   155: ldc_w 'multidisplay setPsdScreenSwitch failed with invalid onOff, do nothing'
/*      */     //   158: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   161: pop
/*      */     //   162: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*      */     //   165: astore #4
/*      */     //   167: aload_0
/*      */     //   168: monitorexit
/*      */     //   169: aload #4
/*      */     //   171: areturn
/*      */     //   172: astore #4
/*      */     //   174: aload #4
/*      */     //   176: invokevirtual printStackTrace : ()V
/*      */     //   179: ldc 'Vehicle_AdaptAPi'
/*      */     //   181: ldc_w 'multidisplay setPsdScreenSwitch failed. Remote exception happens'
/*      */     //   184: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   187: pop
/*      */     //   188: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*      */     //   191: astore #4
/*      */     //   193: aload_0
/*      */     //   194: monitorexit
/*      */     //   195: aload #4
/*      */     //   197: areturn
/*      */     //   198: new java/lang/StringBuilder
/*      */     //   201: astore #4
/*      */     //   203: aload #4
/*      */     //   205: invokespecial <init> : ()V
/*      */     //   208: aload #4
/*      */     //   210: ldc_w 'multidisplay setPsdScreenSwitch failed. Invaid carconfig449=0x'
/*      */     //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   216: pop
/*      */     //   217: aload #4
/*      */     //   219: iload_2
/*      */     //   220: invokestatic toHexString : (I)Ljava/lang/String;
/*      */     //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   226: pop
/*      */     //   227: ldc 'Vehicle_AdaptAPi'
/*      */     //   229: aload #4
/*      */     //   231: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   234: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   237: pop
/*      */     //   238: getstatic ecarx/car/hardware/annotation/ApiResult.FAILED : Lecarx/car/hardware/annotation/ApiResult;
/*      */     //   241: astore #4
/*      */     //   243: aload_0
/*      */     //   244: monitorexit
/*      */     //   245: aload #4
/*      */     //   247: areturn
/*      */     //   248: astore #4
/*      */     //   250: aload_0
/*      */     //   251: monitorexit
/*      */     //   252: aload #4
/*      */     //   254: athrow
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1413	-> 2
/*      */     //   #1414	-> 10
/*      */     //   #1415	-> 47
/*      */     //   #1416	-> 47
/*      */     //   #1418	-> 54
/*      */     //   #1419	-> 61
/*      */     //   #1420	-> 70
/*      */     //   #1422	-> 80
/*      */     //   #1423	-> 85
/*      */     //   #1424	-> 94
/*      */     //   #1425	-> 106
/*      */     //   #1426	-> 111
/*      */     //   #1427	-> 120
/*      */     //   #1439	-> 129
/*      */     //   #1440	-> 129
/*      */     //   #1441	-> 133
/*      */     //   #1443	-> 143
/*      */     //   #1432	-> 153
/*      */     //   #1433	-> 162
/*      */     //   #1435	-> 172
/*      */     //   #1436	-> 174
/*      */     //   #1437	-> 179
/*      */     //   #1438	-> 188
/*      */     //   #1446	-> 198
/*      */     //   #1447	-> 238
/*      */     //   #1412	-> 248
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   2	10	248	finally
/*      */     //   10	47	248	finally
/*      */     //   54	61	172	java/lang/Exception
/*      */     //   54	61	248	finally
/*      */     //   61	70	172	java/lang/Exception
/*      */     //   61	70	248	finally
/*      */     //   70	75	172	java/lang/Exception
/*      */     //   70	75	248	finally
/*      */     //   85	94	172	java/lang/Exception
/*      */     //   85	94	248	finally
/*      */     //   94	103	172	java/lang/Exception
/*      */     //   94	103	248	finally
/*      */     //   111	120	172	java/lang/Exception
/*      */     //   111	120	248	finally
/*      */     //   120	129	172	java/lang/Exception
/*      */     //   120	129	248	finally
/*      */     //   133	138	248	finally
/*      */     //   143	148	248	finally
/*      */     //   153	162	172	java/lang/Exception
/*      */     //   153	162	248	finally
/*      */     //   162	167	172	java/lang/Exception
/*      */     //   162	167	248	finally
/*      */     //   174	179	248	finally
/*      */     //   179	188	248	finally
/*      */     //   188	193	248	finally
/*      */     //   198	238	248	finally
/*      */     //   238	243	248	finally
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
/*      */   private FunctionStatus getPsdScreenSwitchEffect() {
/* 1452 */     int i = getSignalValue(29480);
/* 1453 */     if (i != 132) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1458 */       StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("multidisplay getPsdScreenSwitchEffect carconfig449=0x"); stringBuilder1.append(Integer.toHexString(i)); stringBuilder1.append(" psd function is notavailable"); Log.e("Vehicle_AdaptAPi", stringBuilder1.toString());
/* 1459 */       return FunctionStatus.notavailable;
/*      */     } 
/*      */     StringBuilder stringBuilder = new StringBuilder();
/*      */     stringBuilder.append("multidisplay getPsdScreenSwitchEffect carconfig449=0x");
/*      */     stringBuilder.append(Integer.toHexString(i));
/*      */     stringBuilder.append(" psd function is available");
/*      */     Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 1466 */     return FunctionStatus.active; } private class EcarxMultidisplayCallbackImpl extends IEcarxMultidisplayCallback.Stub { final Vehicle this$0; private EcarxMultidisplayCallbackImpl() {} public void updatePsdDisplayOnAndOff(int param1Int) throws RemoteException { StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("multidisplay updatePsdDisplayOnAndOff onOff="); stringBuilder1.append(param1Int); Log.d("Vehicle_AdaptAPi", stringBuilder1.toString());
/* 1467 */       StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append("multidisplay updatePsdDisplayOnAndOff onOff=");
/* 1468 */       if (param1Int == 2) { str = "psd on"; } else { str = "psd off"; }  stringBuilder2.append(str); String str = stringBuilder2.toString(); Log.d("Vehicle_AdaptAPi", str);
/* 1469 */       Vehicle.this.onFunctionChanged(539495936);
/* 1470 */       if (param1Int == 2) {
/* 1471 */         Vehicle.this.onFunctionValueChanged(539495936, -2147483648, 1);
/* 1472 */       } else if (param1Int == 1) {
/* 1473 */         Vehicle.this.onFunctionValueChanged(539495936, -2147483648, 0);
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1478 */         Log.d("Vehicle_AdaptAPi", "multidisplay updatePsdDisplayOnAndOff failed with invalid onOff, do nothing");
/*      */       }  }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setWallPaper(int paramInt) {
/*      */     byte b;
/* 1489 */     if (paramInt != 0) { switch (paramInt)
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1615 */           b = 1; break;case 539034152: b = 40; break;case 539034151: b = 39; break;case 539034150: b = 38; break;case 539034149: b = 37; break;case 539034148: b = 36; break;case 539034147: b = 35; break;case 539034146: b = 34; break;case 539034145: b = 33; break;case 539034144: b = 32; break;case 539034143: b = 31; break;case 539034142: b = 30; break;case 539034141: b = 29; break;case 539034140: b = 28; break;case 539034139: b = 27; break;case 539034138: b = 26; break;case 539034137: b = 25; break;case 539034136: b = 24; break;case 539034135: b = 23; break;case 539034134: b = 22; break;case 539034133: b = 21; break;case 539034132: b = 20; break;case 539034131: b = 19; break;case 539034130: b = 18; break;case 539034129: b = 17; break;case 539034128: b = 16; break;case 539034127: b = 15; break;case 539034126: b = 14; break;case 539034125: b = 13; break;case 539034124: b = 12; break;case 539034123: b = 11; break;case 539034122: b = 10; break;case 539034121: b = 9; break;case 539034120: b = 8; break;case 539034119: b = 7; break;case 539034118: b = 6; break;case 539034117: b = 5; break;
/*      */         case 539034116: b = 4; break;
/*      */         case 539034115: b = 3; break;
/*      */         case 539034114: b = 2; break;
/* 1619 */         case 539034113: b = 1; break; }  } else { b = 0; this.mDimProtocolManager.setWallPaperValue(0); }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setWallPaper  wallpaper:"); stringBuilder.append(paramInt); stringBuilder.append("  wallpaperFW:"); stringBuilder.append(b); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/*      */     
/* 1621 */     if (b == 1 || b == 2 || b == 3 || (b >= 5 && b <= 40)) {
/*      */       
/* 1623 */       byte b1 = (byte)b;
/* 1624 */       this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)19, new byte[] { b1 });
/* 1625 */       this.mDimProtocolManager.setWallPaperValue(b);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1631 */     return ApiResult.SUCCEED;
/*      */   }
/*      */ 
/*      */   
/*      */   private int getWallPaper() {
/* 1636 */     return this.mDimProtocolManager.getWallPaperValue();
/*      */   }
/*      */ 
/*      */   
/*      */   private void setMutiDisplayLinkage(int paramInt) {
/* 1641 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setMutiDisplayLinkage  value:"); stringBuilder.append(paramInt); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int getMutiDisplayLinkage() {
/* 1647 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ApiResult setFestivalPaperSwitch(int paramInt) {
/* 1653 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setFestivalPaperSwitch:"); stringBuilder.append(paramInt); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 1654 */     this.mDimProtocolManager.setFestivalPaperValue(paramInt);
/* 1655 */     return ApiResult.SUCCEED;
/*      */   }
/*      */ 
/*      */   
/*      */   private int getFestivalPaperSwitch() {
/* 1660 */     return this.mDimProtocolManager.getFestivalPaperValue();
/*      */   }
/*      */   
/*      */   private ApiResult setScreenSaverStyle(int paramInt) {
/* 1664 */     StringBuilder stringBuilder2, stringBuilder1 = new StringBuilder(); stringBuilder1.append("onSetFunctionValue PSD screensaver style: "); stringBuilder1.append(paramInt); Log.d("Vehicle_AdaptAPi", stringBuilder1.toString());
/* 1665 */     ApiResult apiResult = ApiResult.FAILED;
/* 1666 */     boolean bool = false;
/* 1667 */     switch (paramInt)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1678 */         stringBuilder2 = new StringBuilder(); stringBuilder2.append("onSetFunctionValue PSD screensaver style value error: "); stringBuilder2.append(paramInt); Log.e("Vehicle_AdaptAPi", stringBuilder2.toString()); paramInt = bool; break;
/*      */       case 539034371: paramInt = 3; break;
/*      */       case 539034370: paramInt = 2; break;
/* 1681 */       case 539034369: paramInt = 1; break; }  if (this.mBrightnessMgr != null) {
/* 1682 */       this.mBrightnessMgr.setScreenSaverStyle(paramInt);
/* 1683 */       apiResult = ApiResult.SUCCEED;
/*      */     } else {
/* 1685 */       Log.e("Vehicle_AdaptAPi", "setScreenSaverStyle: mBrightnessMgr is null");
/*      */     } 
/* 1687 */     return apiResult;
/*      */   }
/*      */   private class DIMProtocolServiceCallbackImpl extends IDIMProtocolServiceCallback.Stub { final Vehicle this$0;
/*      */     
/*      */     private DIMProtocolServiceCallbackImpl() {}
/*      */     
/*      */     public void onAck(byte param1Byte) {
/* 1694 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onAck  opcode:"); stringBuilder.append(param1Byte); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/*      */     }
/*      */ 
/*      */     
/*      */     public void onError(byte param1Byte) {
/* 1699 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onError  opcode:"); stringBuilder.append(param1Byte); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onReceived(byte param1Byte1, byte param1Byte2) {
/* 1707 */       if (param1Byte1 == 20)
/*      */       
/*      */       { 
/* 1710 */         param1Byte1 = param1Byte2; if (4 == param1Byte2) {
/*      */           
/* 1712 */           StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("节日壁纸  data:"); stringBuilder1.append(param1Byte2); Log.d("Vehicle_AdaptAPi", stringBuilder1.toString());
/* 1713 */           param1Byte1 = 0;
/*      */         } 
/*      */         
/* 1716 */         int i = Vehicle.this.mDimProtocolManager.getWallPaperValue();
/*      */ 
/*      */         
/* 1719 */         if (param1Byte1 == i);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1727 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimMenu 壁纸切换 data: "); stringBuilder.append(param1Byte1); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 1728 */         switch (param1Byte1)
/*      */         { default:
/*      */             return;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 40:
/* 1891 */             Vehicle.access$402(Vehicle.this, false);
/* 1892 */             Vehicle.this.mDimProtocolManager.setWallPaperValue(40);case 39: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(39);case 38: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(38);case 37: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(37);case 36: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(36);case 35: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(35);case 34: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(34);case 33: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(33);case 32: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(32);case 31: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(31);case 30: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(30);case 29: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(29);case 28: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(28);case 27: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(27);case 26: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(26);case 25: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(25);case 24: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(24);case 23: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(23);case 22: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(22);case 21: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(21);case 20: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(20);case 19: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(19);case 18: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(18);case 17: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(17);case 16: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(16);case 15: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(15);case 14: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(14);case 13: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(13);case 12: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(12);
/*      */           case 11: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(11);
/*      */           case 10: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(10);
/*      */           case 9: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(9);
/*      */           case 8: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(8);
/*      */           case 7: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(7);
/*      */           case 6: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(6);
/*      */           case 5: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(5);
/*      */           case 4: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(4);
/*      */           case 3: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(3);
/*      */           case 2: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(2);
/*      */           case 1: Vehicle.access$402(Vehicle.this, false); Vehicle.this.mDimProtocolManager.setWallPaperValue(1);
/* 1904 */           case 0: break; }  Vehicle.access$402(Vehicle.this, true); Vehicle.access$502(Vehicle.this, true); Vehicle.this.mDimProtocolManager.setWallPaperValue(0); }  } public void onFestivalPaperStatusChanged() { Log.d("Vehicle_AdaptAPi", "setFestivalPaperSwitch  关闭节日壁纸，节日壁纸开关置灰");
/* 1905 */       Vehicle.this.onSupportedFunctionStatusChanged(538904320, -2147483648, FunctionStatus.notactive);
/*      */       
/* 1907 */       Vehicle.this.onSupportedFunctionStatusChanged(539034112, -2147483648, FunctionStatus.active); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void onWallPaperStatusChanged(int param1Int) {
/* 1913 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onWallPaperStatusChanged value: "); stringBuilder.append(param1Int); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 1914 */       switch (param1Int)
/*      */       { default:
/*      */           return;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 40:
/* 2078 */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034152);
/*      */         case 39: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034151);
/*      */         case 38: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034150);
/*      */         case 37: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034149);
/*      */         case 36: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034148);
/*      */         case 35: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034147);
/*      */         case 34: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034146);
/*      */         case 33: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034145);
/*      */         case 32: Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034144);
/*      */         case 31:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034143);
/*      */         case 30:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034142);
/*      */         case 29:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034141);
/*      */         case 28:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034140);
/*      */         case 27:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034139);
/*      */         case 26:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034138);
/*      */         case 25:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034137);
/*      */         case 24:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034136);
/*      */         case 23:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034135);
/*      */         case 22:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034134);
/*      */         case 21:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034133);
/*      */         case 20:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034132);
/*      */         case 19:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034131);
/*      */         case 18:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034130);
/*      */         case 17:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034129);
/*      */         case 16:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034128);
/*      */         case 15:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034127);
/*      */         case 14:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034126);
/*      */         case 13:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034125);
/*      */         case 12:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034124);
/*      */         case 11:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034123);
/*      */         case 10:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034122);
/*      */         case 9:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034121);
/*      */         case 8:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034120);
/*      */         case 7:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034119);
/*      */         case 6:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034118);
/*      */         case 5:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034117);
/*      */         case 4:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034116);
/*      */         case 3:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034115);
/*      */         case 2:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034114);
/*      */         case 1:
/*      */           Vehicle.this.onFunctionValueChanged(539034112, -2147483648, 539034113);
/*      */         case 0:
/* 2150 */           break; }  Vehicle.this.onSupportedFunctionStatusChanged(538904320, -2147483648, FunctionStatus.active); Vehicle.this.onSupportedFunctionStatusChanged(539034112, -2147483648, FunctionStatus.notactive); } } private class BrightnessMgrReceiver extends IPowerStatusListener.Stub { final Vehicle this$0; private BrightnessMgrReceiver() {} public void onStatusChanged(int param1Int1, int param1Int2) {} public void onDayNightChanged(int param1Int) {} public void onBrightnessModeChanged(int param1Int) {} public void onDayBrightnessChanged(int param1Int1, int param1Int2) {} public void onNightBrightnessChanged(int param1Int1, int param1Int2) {} public void onVehicleBrightnessChanged(int param1Int) {} public void onSettingManagerReady(int param1Int) {} public void onDayNightModeChanged(int param1Int) {} public void onManualDayNightModeChanged(int param1Int) {} public void onAutoDayNightModeChanged(int param1Int) {} public void onCustomDayTimeChanged(float param1Float) {} public void onCustomNightTimeChanged(float param1Float) {} public void onScreenSaverStyleChanged(int param1Int) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onScreenSaverStyleChanged: "); stringBuilder.append(param1Int); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 2151 */       if (param1Int == 1) {
/* 2152 */         param1Int = 539034369;
/* 2153 */       } else if (param1Int == 2) {
/* 2154 */         param1Int = 539034370;
/* 2155 */       } else if (param1Int == 3) {
/* 2156 */         param1Int = 539034371;
/*      */       } else {
/* 2158 */         param1Int = 0;
/*      */       } 
/* 2160 */       Vehicle.this.onFunctionValueChanged(539034368, -2147483648, param1Int); }
/*      */ 
/*      */ 
/*      */     
/*      */     public void onScreenSaverNameChanged(String param1String) {
/* 2165 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onScreenSaverNameChanged: "); stringBuilder.append(param1String); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 2166 */       Vehicle.this.propCallback(539034624, -2147483648);
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public int convertOpendClsd(int paramInt) {
/* 2172 */     char c = 'ÿ';
/* 2173 */     if (paramInt == 0) {
/* 2174 */       c = Character.MIN_VALUE;
/* 2175 */     } else if (paramInt == 1) {
/* 2176 */       c = '\001';
/*      */     } 
/* 2178 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertToOpendClsdSwitch(int paramInt) {
/* 2183 */     boolean bool = false;
/* 2184 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2194 */         return paramInt;case 1: paramInt = 1; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */   
/*      */   private int convertFaceIdnReq(int paramInt) {
/* 2198 */     boolean bool = false;
/* 2199 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2211 */         return paramInt;case 1: paramInt = 1; this.mVFSmallCycleManager.CB_VFS_FaceIdnReq(1); return paramInt;case 0: break; }  paramInt = 0; this.mVFSmallCycleManager.CB_VFS_FaceIdnReq(0); return paramInt;
/*      */   }
/*      */   
/*      */   private int convertEgyLvl(int paramInt) {
/* 2215 */     boolean bool = false;
/* 2216 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2229 */         return paramInt;case 2: paramInt = 537003267; return paramInt;case 1: paramInt = 537003266; return paramInt;case 0: break; }  paramInt = 537003265; return paramInt;
/*      */   }
/*      */   
/*      */   private int convertSusHeightLvl(int paramInt) {
/* 2233 */     int i = 538509571;
/* 2234 */     switch (paramInt) { default: paramInt = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2248 */         return paramInt;case 4: paramInt = 538509573; return paramInt;case 3: paramInt = 538509572; return paramInt;case 2: paramInt = 538509570; return paramInt;case 1: break; }  paramInt = 538509569; return paramInt;
/*      */   }
/*      */   
/*      */   private int convertToSailingSwitch(int paramInt) {
/* 2252 */     boolean bool = false;
/* 2253 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2263 */         return paramInt;case 2: paramInt = 0; return paramInt;case 1: break; }  paramInt = 1; return paramInt;
/*      */   }
/*      */   
/*      */   private int convertMirrLvl(int paramInt) {
/* 2267 */     int i = 537461507;
/* 2268 */     switch (paramInt) { default: paramInt = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2282 */         return paramInt;case 3: paramInt = 537461507; return paramInt;case 2: paramInt = 537461506; return paramInt;case 1: paramInt = 537461505; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int convertToAPPLowAlarmVol(int paramInt) {
/* 2288 */     int i = 538575362;
/* 2289 */     if (paramInt != 0) { if (paramInt != 2) { paramInt = i;
/*      */          }
/*      */       
/*      */       else
/*      */       
/* 2294 */       { paramInt = 538575363; }
/*      */        }
/*      */     else
/*      */     { paramInt = 538575361; }
/*      */     
/* 2299 */     return paramInt;
/*      */   }
/*      */   
/*      */   private int convertTCAM(int paramInt) {
/*      */     StringBuilder stringBuilder;
/* 2304 */     byte b = 2;
/* 2305 */     switch (paramInt) {
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
/* 2316 */         stringBuilder = new StringBuilder(); stringBuilder.append("convertTCAM: lvl is "); stringBuilder.append(paramInt); stringBuilder.append(" val is "); stringBuilder.append(b); Log.d("Vehicle_AdaptAPi", stringBuilder.toString());
/* 2317 */         return b;
/*      */       case 1:
/*      */         b = 1;
/*      */       case 0:
/*      */       case 2:
/*      */         break;
/*      */     } 
/*      */     b = 0;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\Vehicle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */