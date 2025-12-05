/*     */ package com.ecarx.xui.adaptapi.car.hev;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarPhevManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfmiscManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TripData
/*     */   extends AbsCarFunction
/*     */   implements ITripData
/*     */ {
/*     */   private AvgEnergyInfo mAvgEnergyInfo;
/*     */   private DrivingInfo mDrivingInfo;
/*     */   private final CarPAEventCallback mPAEventCallback;
/*     */   private ECarXCarPhevManager mPhevManager;
/*     */   private final CopyOnWriteArrayList<ITripData.ITripListener> mTripListeners;
/*     */   private ECarXCarVfmiscManager mVfmiscManager;
/*     */   
/*     */   public TripData(Context paramContext) {
/*  40 */     super(paramContext, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 454 */     this.mPAEventCallback = new CarPAEventCallback()
/*     */       {
/*     */         public void onPA_TS_DTEIndicated(PATypes.PA_TS_DTEIndicated param1PA_TS_DTEIndicated) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_DTEHVBattIndicated(PATypes.PA_TS_DTEHVBattIndicated param1PA_TS_DTEHVBattIndicated) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_DTEHV_round(PATypes.PA_TS_DTEHV_round param1PA_TS_DTEHV_round) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_Zero_Emission(PATypes.PA_TS_Zero_Emission param1PA_TS_Zero_Emission) {
/* 478 */           TripData.this.mDrivingInfo.setEleDrivingPercentage(param1PA_TS_Zero_Emission.getData());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_EDT_time2(PATypes.PA_TS_EDT_time2 param1PA_TS_EDT_time2) {
/* 484 */           TripData.this.mDrivingInfo.setTripDuration(param1PA_TS_EDT_time2.getData());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_OdometerTripMeter2(PATypes.PA_TS_OdometerTripMeter2 param1PA_TS_OdometerTripMeter2) {
/* 491 */           int i = param1PA_TS_OdometerTripMeter2.getData();
/* 492 */           TripData.this.mDrivingInfo.setTripDistanceInCurrentDay(i);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_TripAverageConsumption5Km(PATypes.PA_TS_TripAverageConsumption5Km param1PA_TS_TripAverageConsumption5Km) {}
/*     */ 
/*     */         
/*     */         private boolean avgChanged = false;
/*     */         
/*     */         final TripData this$0;
/*     */ 
/*     */         
/*     */         public void onPA_TS_TripAverageConsumption05Km(PATypes.PA_TS_TripAverageConsumption05Km param1PA_TS_TripAverageConsumption05Km) {
/* 506 */           float f = param1PA_TS_TripAverageConsumption05Km.getData() / 1000.0F;
/* 507 */           TripData.this.mAvgEnergyInfo.setAvgFuelConsumption(f);
/* 508 */           this.avgChanged = true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_TripAverageEnConsumption5Km(PATypes.PA_TS_TripAverageEnConsumption5Km param1PA_TS_TripAverageEnConsumption5Km) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_TripAverageEnConsumption05Km(PATypes.PA_TS_TripAverageEnConsumption05Km param1PA_TS_TripAverageEnConsumption05Km) {
/* 521 */           TripData.this.mAvgEnergyInfo.setAvgEleConsumption(param1PA_TS_TripAverageEnConsumption05Km.getData());
/* 522 */           this.avgChanged = true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_CurTripDis(PATypes.PA_TS_CurTripDis param1PA_TS_CurTripDis) {
/* 529 */           int i = param1PA_TS_CurTripDis.getData();
/* 530 */           TripData.this.mDrivingInfo.setTripDistance(i);
/* 531 */           TripData.this.onDrivingInfoUpdate(TripData.this.mDrivingInfo);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onPA_TS_CurTripTime(PATypes.PA_TS_CurTripTime param1PA_TS_CurTripTime) {
/* 538 */           int i = param1PA_TS_CurTripTime.getData();
/* 539 */           TripData.this.mDrivingInfo.setTripDuration(i);
/* 540 */           TripData.this.onDrivingInfoUpdate(TripData.this.mDrivingInfo);
/*     */         }
/*     */         
/*     */         public void onPA_TS_MsgEnd(PATypes.PA_TS_MsgEnd param1PA_TS_MsgEnd)
/*     */         {
/* 545 */           if (this.avgChanged) {
/* 546 */             this.avgChanged = false;
/* 547 */             TripData.this.onAvgEnergyInfoUpdate(TripData.this.mAvgEnergyInfo);
/*     */           } 
/* 549 */           TripData.this.onDrivingInfoUpdate(TripData.this.mDrivingInfo); }
/*     */       }; this.mTripListeners = new CopyOnWriteArrayList<>(); this.mDrivingInfo = new DrivingInfo(); this.mAvgEnergyInfo = new AvgEnergyInfo();
/*     */   }
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) { try { this.mVfmiscManager = paramECarXCarSetManager.getECarXCarVfmiscManager(); this.mPhevManager = paramECarXCarSetManager.getECarXCarPhevManager(); this.mPhevManager.registerCallback(this.mPAEventCallback, getPAFilter()); } catch (Exception exception) { exception.printStackTrace(); }  }
/*     */   protected void buildFunctions() { IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(612369152); iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(new int[] { 612369155, 612369156 }); IVehicleFunction.IZone iZone6 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus4 = iZone6.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms -$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms1 = new -$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iMultiSignalStatus4.onStatusSignalChanged(-$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms1); -$$Lambda$TripData$76R-Vtv6lPxQV068505N_UMbBJk -$$Lambda$TripData$76R-Vtv6lPxQV068505N_UMbBJk = new -$$Lambda$TripData$76R-Vtv6lPxQV068505N_UMbBJk(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$TripData$76R-Vtv6lPxQV068505N_UMbBJk); IVehicleFunction.IMultiSignalValue iMultiSignalValue = iValueTaskBuild5.useValueSignals(new int[] { 33697, 33696 }); -$$Lambda$TripData$0mvYjVSmAtxUVJG3Zuiyre8llk0 -$$Lambda$TripData$0mvYjVSmAtxUVJG3Zuiyre8llk0 = new -$$Lambda$TripData$0mvYjVSmAtxUVJG3Zuiyre8llk0(this); IVehicleFunction.IFilterCallback iFilterCallback5 = iMultiSignalValue.onValueSignalChanged(-$$Lambda$TripData$0mvYjVSmAtxUVJG3Zuiyre8llk0); -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8 -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA83 = new -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8(this); iFilterCallback5.addTo(-$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA83); IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(612369920); iVehicleFunction3 = iVehicleFunction3.supportedFunctionValue(new int[] { 612369921, 612369922, 612369923, 612369924, 612369925, 612369926 }); IVehicleFunction.IZone iZone5 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus3 = iZone5.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc -$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc1 = new -$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iMultiSignalStatus3.onStatusSignalChanged(-$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc1); -$$Lambda$TripData$VOCv05D8z040HUHckTpsFXXSJEc -$$Lambda$TripData$VOCv05D8z040HUHckTpsFXXSJEc = new -$$Lambda$TripData$VOCv05D8z040HUHckTpsFXXSJEc(this); iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$TripData$VOCv05D8z040HUHckTpsFXXSJEc); -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8 -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA82 = new -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8(this); iValueTaskBuild8.addTo(-$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA82); IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(612368896); iVehicleFunction2 = iVehicleFunction2.supportedFunctionValue(new int[] { 1, 0 }); IVehicleFunction.IZone iZone4 = iVehicleFunction2.createZone(new int[] { 0 }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus2 = iZone4.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc -$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc2 = new -$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iMultiSignalStatus2.onStatusSignalChanged(-$$Lambda$TripData$FLv7cAQ1AYn7qodZEC5s7BcqqZc2); ECarXCarVfmiscManager eCarXCarVfmiscManager2 = this.mVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager2); -$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT4 -$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT42 = new -$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT4(eCarXCarVfmiscManager2); -$$Lambda$TripData$J54gZNj99XHsjZnjm0AsOMuPdnY -$$Lambda$TripData$J54gZNj99XHsjZnjm0AsOMuPdnY = -$$Lambda$TripData$J54gZNj99XHsjZnjm0AsOMuPdnY.INSTANCE; IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iValueTaskBuild4.onSetFunctionValue(-$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT42, -$$Lambda$TripData$J54gZNj99XHsjZnjm0AsOMuPdnY); -$$Lambda$TripData$DK-7tJfyDhWi_0mpM2uRX5yvQUc -$$Lambda$TripData$DK-7tJfyDhWi_0mpM2uRX5yvQUc = -$$Lambda$TripData$DK-7tJfyDhWi_0mpM2uRX5yvQUc.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild7.customValue(-$$Lambda$TripData$DK-7tJfyDhWi_0mpM2uRX5yvQUc); IVehicleFunction.IZone iZone3 = iFilterCallback3.createZone(new int[] { 1 }); IVehicleFunction.IMultiSignalStatus iMultiSignalStatus1 = iZone3.useStatusSignals(new int[] { 29337, 30788, 30779 }); -$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms -$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms2 = new -$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms(this); IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iMultiSignalStatus1.onStatusSignalChanged(-$$Lambda$TripData$x6tLI921VEoc-vx371oZiA8Dmms2); ECarXCarVfmiscManager eCarXCarVfmiscManager1 = this.mVfmiscManager; Objects.requireNonNull(eCarXCarVfmiscManager1); -$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT4 -$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT41 = new -$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT4(eCarXCarVfmiscManager1); -$$Lambda$TripData$dTL5737VEfzrh5ohP6RmFsPJnss -$$Lambda$TripData$dTL5737VEfzrh5ohP6RmFsPJnss = -$$Lambda$TripData$dTL5737VEfzrh5ohP6RmFsPJnss.INSTANCE; IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$rL6FqSvbRuv2Af0ggPsWrI6DeT41, -$$Lambda$TripData$dTL5737VEfzrh5ohP6RmFsPJnss); -$$Lambda$TripData$oVu-LQBQ4BcHB_hh8kS0W6guHqo -$$Lambda$TripData$oVu-LQBQ4BcHB_hh8kS0W6guHqo = -$$Lambda$TripData$oVu-LQBQ4BcHB_hh8kS0W6guHqo.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild6.customValue(-$$Lambda$TripData$oVu-LQBQ4BcHB_hh8kS0W6guHqo); -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8 -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA81 = new -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8(this); iFilterCallback4.addTo(-$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA81); IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(612368640); iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 612368641, 612368642 }); IVehicleFunction.IZone iZone2 = iVehicleFunction1.createZone(new int[] { 0 }); IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone2.useOtherFunctionStatus(612369920); -$$Lambda$TripData$cvVzyMKFpRY-VVppu-hkpeI87vc -$$Lambda$TripData$cvVzyMKFpRY-VVppu-hkpeI87vc = -$$Lambda$TripData$cvVzyMKFpRY-VVppu-hkpeI87vc.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild2.customValue(-$$Lambda$TripData$cvVzyMKFpRY-VVppu-hkpeI87vc); IVehicleFunction.IZone iZone1 = iFilterCallback2.createZone(new int[] { 1 }); IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.useOtherFunctionStatus(612369152); -$$Lambda$TripData$ws2gRBx2TbwPN0eS6YKSKlYJRYg -$$Lambda$TripData$ws2gRBx2TbwPN0eS6YKSKlYJRYg = -$$Lambda$TripData$ws2gRBx2TbwPN0eS6YKSKlYJRYg.INSTANCE; IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.customValue(-$$Lambda$TripData$ws2gRBx2TbwPN0eS6YKSKlYJRYg); -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8 -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA84 = new -$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA8(this); iFilterCallback1.addTo(-$$Lambda$TripData$CfQMqrIDg8K69pbjMPX6RaMDVA84); }
/*     */   protected void initPAFilter() { addPAFilter(Integer.valueOf(33768)); addPAFilter(Integer.valueOf(33774)); addPAFilter(Integer.valueOf(33775)); addPAFilter(Integer.valueOf(33776)); addPAFilter(Integer.valueOf(33777)); addPAFilter(Integer.valueOf(33779)); addPAFilter(Integer.valueOf(33781)); addPAFilter(Integer.valueOf(33934)); addPAFilter(Integer.valueOf(33935)); addPAFilter(Integer.valueOf(33781)); addPAFilter(Integer.valueOf(33903)); }
/*     */   private boolean supportTripReset() { int i = getSignalValue(29337); boolean bool2 = true, bool1 = bool2; if (i != 1) { bool1 = bool2; if (i != 128) { bool1 = bool2; if (i != 3) if (i == 2) { bool1 = bool2; } else { bool1 = false; }   }  }  return bool1; }
/*     */   public FunctionStatus isTripDataSupported() { FunctionStatus functionStatus = FunctionStatus.notavailable; if (supportTripReset()) functionStatus = FunctionStatus.active;  return functionStatus; }
/*     */   public FunctionStatus isTripDataSupported(int paramInt) { if (paramInt == 0) return drivingComputerStatus();  if (paramInt == 1) return resetTripSettingStatus();  return FunctionStatus.notavailable; }
/*     */   public FunctionStatus isTripDataSupported(int paramInt1, int paramInt2) { if (paramInt2 == 4096) return FunctionStatus.active;  return FunctionStatus.notavailable; }
/*     */   private FunctionStatus resetTripSettingStatus() { if (supportTripReset()) { FunctionStatus functionStatus; int j = getSignalValue(30788); int i = getSignalValue(30779); if (j != 0 && (i == 0 || i == 3)) { functionStatus = FunctionStatus.active; } else { functionStatus = FunctionStatus.notactive; }  return functionStatus; }  return FunctionStatus.notavailable; } private FunctionStatus drivingComputerStatus() { if (supportTripReset()) { int i = getSignalValue(30788); int j = getSignalValue(30779); return ((i == 11 || i == 13) && (j == 0 || j == 3)) ? FunctionStatus.active : FunctionStatus.notactive; }  return FunctionStatus.notavailable; } @Deprecated public void setUpdateFrequencyUnit(int paramInt) {} @Deprecated public int getUpdateFrequencyUnit() { return 500; } public int[] getSupportedUpdateFrequencyUnit() { return new int[] { 500 }; } public ITripData.IAvgEnergyInfo getLatestAvgEnergyInfo() { return this.mAvgEnergyInfo; } public ITripData.IDrivingInfo getLatestDrivingInfo() { return this.mDrivingInfo; } public ITripData.ITripInfo getLatestTripInfo(int paramInt1, int paramInt2) { return null; } public ITripData.ITripInfo[] getTripInfo(int paramInt1, int paramInt2) { return new ITripData.ITripInfo[0]; } public void registerTripListener(ITripData.ITripListener paramITripListener) { if (!this.mTripListeners.contains(paramITripListener)) this.mTripListeners.add(paramITripListener);  } public void registerTripListener(int paramInt, ITripData.ITripListener paramITripListener) {} public void unregisterTripListener(ITripData.ITripListener paramITripListener) { this.mTripListeners.remove(paramITripListener); } private void onAvgEnergyInfoUpdate(ITripData.IAvgEnergyInfo paramIAvgEnergyInfo) { for (ITripData.ITripListener iTripListener : this.mTripListeners) { try { iTripListener.onAvgEnergyInfoUpdate(paramIAvgEnergyInfo); } catch (Exception exception) { exception.printStackTrace(); }  }  } private void onDrivingInfoUpdate(ITripData.IDrivingInfo paramIDrivingInfo) { for (ITripData.ITripListener iTripListener : this.mTripListeners) { try { iTripListener.onDrivingInfoUpdate(paramIDrivingInfo); } catch (Exception exception) { exception.printStackTrace(); }  }  } private static class AvgEnergyInfo extends TripInfo implements ITripData.IAvgEnergyInfo
/*     */   {
/* 561 */     public AvgEnergyInfo() { super(0, 0); }
/*     */ 
/*     */ 
/*     */     
/*     */     private float mAvgEleConsumption;
/*     */     
/*     */     private float mAvgEnergyFeedback;
/*     */     private float mAvgFuelConsumption;
/*     */     
/*     */     public float getAvgFuelConsumption() {
/* 571 */       return this.mAvgFuelConsumption;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getAvgEleConsumption() {
/* 581 */       return this.mAvgEleConsumption;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getAvgEnergyFeedback() {
/* 591 */       return this.mAvgEnergyFeedback;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getFrequencyUnit() {
/* 597 */       return 500;
/*     */     }
/*     */     
/*     */     private void setAvgFuelConsumption(float param1Float) {
/* 601 */       this.mAvgFuelConsumption = param1Float;
/*     */     }
/*     */     
/*     */     private void setAvgEleConsumption(float param1Float) {
/* 605 */       this.mAvgEleConsumption = param1Float;
/*     */     }
/*     */     
/*     */     private void setAvgEnergyFeedback(float param1Float) {
/* 609 */       this.mAvgEnergyFeedback = param1Float;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class DrivingInfo
/*     */     extends TripInfo
/*     */     implements ITripData.IDrivingInfo
/*     */   {
/*     */     private float mEleDrivingPercentage;
/*     */     private int mTripDistance;
/*     */     private int mTripDistanceByEle;
/*     */     private int mTripDistanceByFuel;
/*     */     private int mTripDistanceInCurrentDay;
/*     */     private int mTripDuration;
/*     */     private float mTripEleConsumption;
/*     */     private float mTripFuelConsumption;
/*     */     
/*     */     public DrivingInfo() {
/* 627 */       super(0, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTripDistanceInCurrentDay() {
/* 637 */       return this.mTripDistanceInCurrentDay;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTripDistance() {
/* 647 */       return this.mTripDistance;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTripDuration() {
/* 657 */       return this.mTripDuration;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTripDistanceByFuel() {
/* 667 */       return this.mTripDistanceByFuel;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTripDistanceByEle() {
/* 677 */       return this.mTripDistanceByEle;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getTripFuelConsumption() {
/* 687 */       return this.mTripFuelConsumption;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getTripEleConsumption() {
/* 697 */       return this.mTripEleConsumption;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getEleDrivingPercentage() {
/* 708 */       return this.mEleDrivingPercentage;
/*     */     }
/*     */     
/*     */     private void setTripDistanceInCurrentDay(int param1Int) {
/* 712 */       this.mTripDistanceInCurrentDay = param1Int;
/*     */     }
/*     */     
/*     */     private void setTripDistance(int param1Int) {
/* 716 */       this.mTripDistance = param1Int;
/*     */     }
/*     */     
/*     */     private void setTripDuration(int param1Int) {
/* 720 */       this.mTripDuration = param1Int;
/*     */     }
/*     */     
/*     */     private void setTripDistanceByFuel(int param1Int) {
/* 724 */       this.mTripDistanceByFuel = param1Int;
/*     */     }
/*     */     
/*     */     private void setTripDistanceByEle(int param1Int) {
/* 728 */       this.mTripDistanceByEle = param1Int;
/*     */     }
/*     */     
/*     */     private void setTripFuelConsumption(float param1Float) {
/* 732 */       this.mTripFuelConsumption = param1Float;
/*     */     }
/*     */     
/*     */     private void setTripEleConsumption(float param1Float) {
/* 736 */       this.mTripEleConsumption = param1Float;
/*     */     }
/*     */     
/*     */     private void setEleDrivingPercentage(float param1Float) {
/* 740 */       this.mEleDrivingPercentage = param1Float;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class TripInfo
/*     */     implements ITripData.ITripInfo
/*     */   {
/*     */     private final int mInfoType;
/*     */     private final int mTripType;
/*     */     
/*     */     public TripInfo(int param1Int1, int param1Int2) {
/* 752 */       this.mTripType = param1Int1;
/* 753 */       this.mInfoType = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getTripType() {
/* 758 */       return this.mTripType;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getInfoType() {
/* 763 */       return this.mInfoType;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getFrequencyUnit() {
/* 769 */       return 500;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsInfoId(int param1Int) {
/* 774 */       return (param1Int == 8193 || param1Int == 8194 || param1Int == 8195 || param1Int == 12289 || param1Int == 12290 || param1Int == 12291 || param1Int == 12292 || param1Int == 12293 || param1Int == 12543);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int[] getContainsInfoIds() {
/* 787 */       return new int[] { 8193, 8194, 8195, 12289, 12290, 12291, 12292, 12293, 12543 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getInfoValue(int param1Int) {
/* 811 */       return 0.0F;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\TripData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */