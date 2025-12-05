/*     */ package com.ecarx.xui.adaptapi.navigation.ehp.v2;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.ServiceManager;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EHPV2ManagerImpl
/*     */   implements IV2Manager
/*     */ {
/*     */   private static final String ECARX_CAR_SERVICE = "ecarxcar_service";
/*     */   private static final String TAG = "EHPV2ManagerImpl";
/*     */   private static final String THREAD_NAME = "ehpv2_process";
/*     */   private static final int TIME_DELAY = 1000;
/*     */   private final CarSignalManager.CarSignalEventCallback mCarSignalEventCallback;
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private Context mContext;
/*  73 */   private List<IV2Manager.IV2ProviderListener> mIV2ProviderListenerList = new CopyOnWriteArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IECarXCar mService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorkerHandler mWorkerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isV2ProviderAvailable() {
/*  95 */     return FunctionStatus.active;
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
/*     */   public int updadteHznMessage(IV2Message paramIV2Message) {
/* 129 */     int j = 0, i = 0;
/* 130 */     if (this.mCarSignalManager != null)
/*     */       
/* 132 */       try { IHznProfLongLRMessage iHznProfLongLRMessage; j = paramIV2Message.getMessageType(); if (j != 4097) { IHznSplyElectcStatus iHznSplyElectcStatus; if (j != 4101) { VendorVehicleHalPAProto.ProtoHznData protoHznData; VendorVehicleHalPAProto.ProtoHznProfLong protoHznProfLong; VendorVehicleHalPAProto.ProtoHznProfSho protoHznProfSho; VendorVehicleHalPAProto.ProtoHznEdge protoHznEdge; VendorVehicleHalPAProto.ProtoHznSeg protoHznSeg; VendorVehicleHalPAProto.ProtoHznPosn protoHznPosn; IHznDataMessage iHznDataMessage; IHznProfLongMessage iHznProfLongMessage; IHznProfShoMessage iHznProfShoMessage; IHznEdgeMessage iHznEdgeMessage; IHznSegMessage iHznSegMessage; IHznPosnMessage iHznPosnMessage; switch (j)
/*     */             
/*     */             { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               default:
/* 350 */                 return i;
/*     */               case 6: iHznDataMessage = (IHznDataMessage)paramIV2Message; protoHznData = new VendorVehicleHalPAProto.ProtoHznData(); this(); protoHznData.hznDataCountryCode = iHznDataMessage.getCountryCode(); protoHznData.hznDataCyclicCounter = iHznDataMessage.getCyclicCounter(); protoHznData.hznDataDrivingSide = iHznDataMessage.getDrivingSide(); protoHznData.hznDataHardwareVersion = iHznDataMessage.getHardwareVersion(); protoHznData.hznDataMajorProtocolVersion = iHznDataMessage.getMajorProtocolVersion(); protoHznData.hznDataMapProvider = iHznDataMessage.getMapProvider(); protoHznData.hznDataMapVersionYear = iHznDataMessage.getMapVersionYear(); protoHznData.hznDataMapVersionYearQuarter = iHznDataMessage.getMapVersionYearQuarter(); protoHznData.hznDataMessageType = getMessageType(6); protoHznData.hznDataMinorProtocolSubVersion = iHznDataMessage.getMinorProtocolSubVersion(); protoHznData.hznDataMinorProtocolVersion = iHznDataMessage.getMinorProtocolVersion(); protoHznData.hznDataRegionCode = iHznDataMessage.getRegionCode(); protoHznData.hznDataSpeedUnits = iHznDataMessage.getSpeedUnits(); this.mCarSignalManager.setHznData(protoHznData); i = 1;
/*     */               case 5: iHznProfLongMessage = (IHznProfLongMessage)protoHznData; protoHznProfLong = new VendorVehicleHalPAProto.ProtoHznProfLong(); this(); protoHznProfLong.hznProfLongControlPoint = iHznProfLongMessage.isControlPoint(); protoHznProfLong.hznProfLongCyclicCounter = iHznProfLongMessage.getCyclicCounter(); protoHznProfLong.hznProfLongMessageType = getMessageType(5); protoHznProfLong.hznProfLongOffset = iHznProfLongMessage.getOffset(); protoHznProfLong.hznProfLongPathIndex = iHznProfLongMessage.getPathIndex(); protoHznProfLong.hznProfLongProfileType = iHznProfLongMessage.getProfileValue().getProfileType(); protoHznProfLong.hznProfLongRetransmission = iHznProfLongMessage.isRetransmission(); protoHznProfLong.hznProfLongUpdate = iHznProfLongMessage.isUpdate(); protoHznProfLong.hznProfLongValue = iHznProfLongMessage.getProfileValue().getValue(); this.mCarSignalManager.setHznProfLong(protoHznProfLong); i = 1;
/*     */               case 4: iHznProfShoMessage = (IHznProfShoMessage)protoHznProfLong; protoHznProfSho = new VendorVehicleHalPAProto.ProtoHznProfSho(); this(); protoHznProfSho.hznProfShoAccuracy = iHznProfShoMessage.getAccuracy(); protoHznProfSho.hznProfShoControlPoint = iHznProfShoMessage.isControlPoint(); protoHznProfSho.hznProfShoCyclicCounter = iHznProfShoMessage.getCyclicCounter(); protoHznProfSho.hznProfShoDistance1 = iHznProfShoMessage.getDistance1(); protoHznProfSho.hznProfShoMessageType = getMessageType(4); protoHznProfSho.hznProfShoOffset = iHznProfShoMessage.Offset(); protoHznProfSho.hznProfShoPathIndex = iHznProfShoMessage.getPathIndex(); protoHznProfSho.hznProfShoProfileType = iHznProfShoMessage.getValue0().getProfileType(); protoHznProfSho.hznProfShoRetransmission = iHznProfShoMessage.isRetransmission(); protoHznProfSho.hznProfShoUpdate = iHznProfShoMessage.isUpdate(); protoHznProfSho.hznProfShoValue0 = iHznProfShoMessage.getValue0().getValue(); protoHznProfSho.hznProfShoValue1 = iHznProfShoMessage.getValue1(); this.mCarSignalManager.setHznProfSho(protoHznProfSho); i = 1;
/*     */               case 3: iHznEdgeMessage = (IHznEdgeMessage)protoHznProfSho; protoHznEdge = new VendorVehicleHalPAProto.ProtoHznEdge(); this(); protoHznEdge.hznEdgeComplexIntersection = iHznEdgeMessage.getComplexIntersection(); protoHznEdge.hznEdgeCyclicCounter = iHznEdgeMessage.getCyclicCounter(); protoHznEdge.hznEdgeFormOfWay = iHznEdgeMessage.getFormOfWay(); protoHznEdge.hznEdgeFunctionalRoadClass = iHznEdgeMessage.getFunctionalRoadClass(); protoHznEdge.hznEdgeLastStubAtOffset = iHznEdgeMessage.isLastStubAtOffset(); protoHznEdge.hznEdgeMessageType = getMessageType(3); protoHznEdge.hznEdgeNumberOfLanesInDrivingDirection = iHznEdgeMessage.getNumberOfLanesInDrivingDirection(); protoHznEdge.hznEdgeNumberOfLanesInOppositeDirection = iHznEdgeMessage.getNumberOfLanesInOppositeDirection(); protoHznEdge.hznEdgeOffset = iHznEdgeMessage.getOffset(); protoHznEdge.hznEdgePartOfCalculatedRoute = iHznEdgeMessage.getPartOfCalculatedRoute(); protoHznEdge.hznEdgePathIndex = iHznEdgeMessage.getPathIndex(); protoHznEdge.hznEdgeRelativeProbability = iHznEdgeMessage.getRelativeProbability(); protoHznEdge.hznEdgeRetransmission = iHznEdgeMessage.isRetransmission(); protoHznEdge.hznEdgeRightofWay = iHznEdgeMessage.getRightofWay(); protoHznEdge.hznEdgeSubPathIndex = iHznEdgeMessage.getSubPathIndex(); protoHznEdge.hznEdgeTurnAngle = iHznEdgeMessage.getTurnAngle(); protoHznEdge.hznEdgeUpdate = iHznEdgeMessage.isUpdate(); this.mCarSignalManager.setHznEdge(protoHznEdge); i = 1;
/*     */               case 2:
/*     */                 iHznSegMessage = (IHznSegMessage)protoHznEdge; protoHznSeg = new VendorVehicleHalPAProto.ProtoHznSeg(); this(); protoHznSeg.hznSegBridge = iHznSegMessage.getBridge(); protoHznSeg.hznSegBuiltupArea = iHznSegMessage.getBuiltupArea(); protoHznSeg.hznSegComplexIntersection = iHznSegMessage.getComplexIntersection(); protoHznSeg.hznSegCyclicCounter = iHznSegMessage.getCyclicCounter(); protoHznSeg.hznSegDividedRoad = iHznSegMessage.getDividedRoad(); protoHznSeg.hznSegEffectiveSpdLimit = iHznSegMessage.getEffectiveSpdLimit(); protoHznSeg.hznSegEffectiveSpeedLimitType = iHznSegMessage.getEffectiveSpeedLimitType(); protoHznSeg.hznSegFormofWay = iHznSegMessage.getFormOfWay(); protoHznSeg.hznSegFunctionalRoadClass = iHznSegMessage.getFunctionalRoadClass(); protoHznSeg.hznSegMessageType = getMessageType(2); protoHznSeg.hznSegNumberoflanesindrivingdirection = iHznSegMessage.getNumberOfLanesInDrivingDirection(); protoHznSeg.hznSegNumberoflanesinoppositedirection = iHznSegMessage.getNumberOfLanesInOppositeDirection(); protoHznSeg.hznSegOffset = iHznSegMessage.getOffset(); protoHznSeg.hznSegPartOfCalculatedRoute = iHznSegMessage.getPartOfCalculatedRoute(); protoHznSeg.hznSegPathIndex = iHznSegMessage.getPathIndex(); protoHznSeg.hznSegRelativeProbability = iHznSegMessage.getRelativeProbability(); protoHznSeg.hznSegRetransmission = iHznSegMessage.isRetransmission(); protoHznSeg.hznSegTunnel = iHznSegMessage.getTunnel(); protoHznSeg.hznSegUpdate = iHznSegMessage.isUpdate(); this.mCarSignalManager.setHznSeg(protoHznSeg); i = 1;
/*     */               case 1:
/*     */                 iHznPosnMessage = (IHznPosnMessage)protoHznSeg; protoHznPosn = new VendorVehicleHalPAProto.ProtoHznPosn(); this(); protoHznPosn.hznPosnCurrentLane = iHznPosnMessage.getCurrentLane(); protoHznPosn.hznPosnCyclicCounter = iHznPosnMessage.getCyclicCounter(); protoHznPosn.hznPosnMessageType = getMessageType(1); protoHznPosn.hznPosnOffset = iHznPosnMessage.getOffset(); protoHznPosn.hznPosnPathIndex = iHznPosnMessage.getPathIndex(); protoHznPosn.hznPosnPositionAge = iHznPosnMessage.getPositionAge(); protoHznPosn.hznPosnPositionConfidence = iHznPosnMessage.getPositionConfidence(); protoHznPosn.hznPosnPositionIndex = iHznPosnMessage.getPositionIndex(); protoHznPosn.hznPosnPositionProbability = iHznPosnMessage.getPositionProbability(); protoHznPosn.hznPosnRelativeHeading = iHznPosnMessage.getRelativeHeading(); protoHznPosn.hznPosnSpeed = iHznPosnMessage.getSpeed(); this.mCarSignalManager.setHznPosn(protoHznPosn); i = 1;
/*     */               case 0:
/* 360 */                 break; }  CarSignalManager carSignalManager = this.mCarSignalManager; iHznSplyElectcStatus = (IHznSplyElectcStatus)protoHznPosn; j = iHznSplyElectcStatus.getStatus(); carSignalManager.setHznSplyElectcSts(j); i = 1; }  iHznProfLongLRMessage = (IHznProfLongLRMessage)iHznSplyElectcStatus; VendorVehicleHalPAProto.ProtoHznProfLongLR protoHznProfLongLR = new VendorVehicleHalPAProto.ProtoHznProfLongLR(); this(); protoHznProfLongLR.hznProfLongLRControlPoint = iHznProfLongLRMessage.isControlPoint(); protoHznProfLongLR.hznProfLongLRCyclicCounter = iHznProfLongLRMessage.getCyclicCounter(); protoHznProfLongLR.hznProfLongLRMessageType = getMessageType(4101); protoHznProfLongLR.hznProfLongLROffset = iHznProfLongLRMessage.getOffset(); protoHznProfLongLR.hznProfLongLRPathIndex = iHznProfLongLRMessage.getPathIndex(); protoHznProfLongLR.hznProfLongLRProfileType = iHznProfLongLRMessage.getProfileValue().getProfileType(); protoHznProfLongLR.hznProfLongLRRetransmission = iHznProfLongLRMessage.isRetransmission(); protoHznProfLongLR.hznProfLongLRUpdate = iHznProfLongLRMessage.isUpdate(); protoHznProfLongLR.hznProfLongLRValue = iHznProfLongLRMessage.getProfileValue().getValue(); this.mCarSignalManager.setHznProfLongLR(protoHznProfLongLR); i = 1; }  IHznPosnLRMessage iHznPosnLRMessage = (IHznPosnLRMessage)iHznProfLongLRMessage; VendorVehicleHalPAProto.ProtoHznPosnLR protoHznPosnLR = new VendorVehicleHalPAProto.ProtoHznPosnLR(); this(); protoHznPosnLR.hznPosnLRCurrentLane = iHznPosnLRMessage.getCurrentLane(); protoHznPosnLR.hznPosnLRCyclicCounter = iHznPosnLRMessage.getCyclicCounter(); protoHznPosnLR.hznPosnLRMessageType = getMessageType(4097); protoHznPosnLR.hznPosnLROffset = iHznPosnLRMessage.getOffset(); protoHznPosnLR.hznPosnLRPathIndex = iHznPosnLRMessage.getPathIndex(); protoHznPosnLR.hznPosnLRPositionAge = iHznPosnLRMessage.getPositionAge(); protoHznPosnLR.hznPosnLRPositionConfidence = iHznPosnLRMessage.getPositionConfidence(); protoHznPosnLR.hznPosnLRPositionIndex = iHznPosnLRMessage.getPositionIndex(); protoHznPosnLR.hznPosnLRPositionProbability = iHznPosnLRMessage.getPositionProbability(); protoHznPosnLR.hznPosnLRRelativeHeading = iHznPosnLRMessage.getRelativeHeading(); protoHznPosnLR.hznPosnLRSpeed = iHznPosnLRMessage.getSpeed(); this.mCarSignalManager.setHznPosnLR(protoHznPosnLR); i = 1; } catch (Exception exception) { exception.printStackTrace(); }   Log.e("EHPV2ManagerImpl", "updadteHznMessage: mCarSignalManager null"); i = j; } public boolean registerV2ProviderListener(IV2Manager.IV2ProviderListener paramIV2ProviderListener) { boolean bool = false;
/* 361 */     if (!this.mIV2ProviderListenerList.isEmpty()) {
/* 362 */       if (this.mIV2ProviderListenerList.contains(paramIV2ProviderListener)) {
/* 363 */         Log.d("EHPV2ManagerImpl", "registerV2ProviderListener is registered");
/*     */       } else {
/* 365 */         this.mIV2ProviderListenerList.add(paramIV2ProviderListener);
/* 366 */         bool = true;
/*     */       } 
/*     */     } else {
/* 369 */       this.mIV2ProviderListenerList.add(paramIV2ProviderListener);
/* 370 */       bool = true;
/*     */     } 
/* 372 */     return bool; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterV2ProviderListener(IV2Manager.IV2ProviderListener paramIV2ProviderListener) {
/* 382 */     boolean bool = false;
/* 383 */     if (!this.mIV2ProviderListenerList.isEmpty()) {
/* 384 */       if (this.mIV2ProviderListenerList.contains(paramIV2ProviderListener)) {
/* 385 */         this.mIV2ProviderListenerList.remove(paramIV2ProviderListener);
/* 386 */         bool = true;
/* 387 */         Log.d("EHPV2ManagerImpl", "unregisterV2ProviderListener finished");
/*     */       } else {
/* 389 */         Log.d("EHPV2ManagerImpl", "unregisterV2ProviderListener failed");
/*     */       } 
/*     */     } else {
/* 392 */       Log.d("EHPV2ManagerImpl", "unregisterV2ProviderListener failed");
/*     */     } 
/* 394 */     return bool;
/*     */   }
/*     */   
/*     */   private void initCarService(Context paramContext) {
/* 398 */     if (this.mService == null) {
/* 399 */       IBinder iBinder = ServiceManager.getService("ecarxcar_service");
/* 400 */       if (iBinder == null) {
/* 401 */         this.mWorkerHandler.sendEmptyMessageDelayed(1, 1000L);
/* 402 */         Log.e("EHPV2ManagerImpl", "ecarxcar_service is null");
/*     */         return;
/*     */       } 
/* 405 */       this.mService = IECarXCar.Stub.asInterface(iBinder);
/*     */     } 
/*     */     
/* 408 */     ECarXCar eCarXCar = ECarXCar.createCar(paramContext, this.mService);
/*     */     
/* 410 */     if (eCarXCar != null) {
/*     */       try {
/* 412 */         this.mCarSignalManager = (CarSignalManager)eCarXCar.getCarManager("car_signal");
/*     */         
/* 414 */         if (this.mCarSignalManager != null) {
/* 415 */           SignalFilter signalFilter = new SignalFilter(); this();
/* 416 */           signalFilter.add(Integer.valueOf(31456));
/* 417 */           this.mCarSignalManager.registerCallback(this.mCarSignalEventCallback, signalFilter);
/*     */         } 
/* 419 */       } catch (CarNotConnectedException carNotConnectedException) {
/* 420 */         carNotConnectedException.printStackTrace();
/*     */       } 
/*     */     } else {
/* 423 */       Log.e("EHPV2ManagerImpl", "ECarXCar is null");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int getMessageType(int paramInt) {
/* 429 */     byte b = 7;
/* 430 */     if (paramInt != 4097) if (paramInt != 4101) { switch (paramInt) { default: paramInt = b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 457 */             return paramInt;case 6: paramInt = 6; return paramInt;case 4: paramInt = 4; return paramInt;case 3: paramInt = 3; return paramInt;case 2: paramInt = 2; return paramInt;case 0: paramInt = 0; return paramInt;case 5: paramInt = 5; return paramInt;case 1: break; }  } else {  }   paramInt = 1; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class WorkerHandler
/*     */     extends Handler
/*     */   {
/*     */     private static final int MSG_RES_GET_CAR = 1;
/*     */     
/*     */     private static final int MSG_VEHEGY_COORN_DATA_REQ = 2;
/*     */     
/*     */     final EHPV2ManagerImpl this$0;
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 473 */       super.handleMessage(param1Message);
/* 474 */       switch (param1Message.what) {
/*     */         default:
/*     */           return;
/*     */ 
/*     */         
/*     */         case 2:
/* 480 */           if (!EHPV2ManagerImpl.this.mIV2ProviderListenerList.isEmpty()) {
/*     */             
/*     */             try {
/* 483 */               for (IV2Manager.IV2ProviderListener iV2ProviderListener : EHPV2ManagerImpl.this.mIV2ProviderListenerList) {
/* 484 */                 int i = EHPV2ManagerImpl.this.mCarSignalManager.getVehEgyCoornDataReq();
/* 485 */                 if (1 == i) {
/* 486 */                   iV2ProviderListener.onProviderRequested(1);
/*     */                 }
/* 488 */                 else if (i == 0) {
/* 489 */                   iV2ProviderListener.onProviderRequested(2);
/*     */                 } 
/*     */                 
/* 492 */                 StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("onProviderRequested(1:start, 2:stop): "); stringBuilder.append(i); Log.d("EHPV2ManagerImpl", stringBuilder.toString());
/*     */               } 
/* 494 */             } catch (CarNotConnectedException carNotConnectedException) {
/* 495 */               carNotConnectedException.printStackTrace();
/*     */             } 
/*     */           } else {
/* 498 */             Log.e("EHPV2ManagerImpl", "mIV2ProviderListenerList have not data");
/*     */           } 
/*     */         case 1:
/*     */           break;
/*     */       } 
/*     */       Log.d("EHPV2ManagerImpl", "Work === > in  MSG_RES_GET_CAR");
/*     */       EHPV2ManagerImpl.this.initCarService(EHPV2ManagerImpl.this.mContext);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WorkerHandler(Looper param1Looper) {
/* 512 */       super(param1Looper);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EHPV2ManagerImpl(Context paramContext) {
/* 519 */     this.mCarSignalEventCallback = new CarSignalManager.CarSignalEventCallback()
/*     */       {
/*     */         final EHPV2ManagerImpl this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue) {
/* 528 */           if (param1ECarXCarPropertyValue.getPropertyId() == 31456) {
/*     */             
/* 530 */             Log.d("EHPV2ManagerImpl", "onChangeEvent SignalId_VehEgyCoornDataReq");
/* 531 */             EHPV2ManagerImpl.this.mWorkerHandler.sendEmptyMessage(2);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onErrorEvent(int param1Int1, int param1Int2) {
/* 544 */           StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onErrorEvent: "); stringBuilder.append(param1Int1); stringBuilder.append(" zone: "); stringBuilder.append(param1Int2); Log.d("EHPV2ManagerImpl", stringBuilder.toString());
/*     */         }
/*     */       };
/*     */     this.mContext = paramContext;
/*     */     HandlerThread handlerThread = new HandlerThread("ehpv2_process");
/*     */     handlerThread.start();
/*     */     Looper looper = handlerThread.getLooper();
/*     */     if (looper != null) {
/*     */       this.mWorkerHandler = new WorkerHandler(looper);
/*     */     } else {
/*     */       Log.e("EHPV2ManagerImpl", "looper is null");
/*     */     } 
/*     */     initCarService(this.mContext);
/*     */     Log.d("EHPV2ManagerImpl", " new EHPV2ManagerImpl");
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\EHPV2ManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */