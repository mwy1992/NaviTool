/*      */ package com.ecarx.xui.adaptapi.car.sensor;
/*      */ 
/*      */ import android.content.Context;
/*      */ import android.os.SystemClock;
/*      */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*      */ import com.ecarx.xui.adaptapi.SignalUtils;
/*      */ import com.ecarx.xui.adaptapi.car.Pairs;
/*      */ import ecarx.car.hardware.signal.CarSignalManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarAirqlyandfragraManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*      */ import ecarx.car.hardware.vehicle.PATypes;
/*      */ import java.util.ArrayList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SensorNew
/*      */   extends AbsSensorFunction
/*      */ {
/*      */   private ECarXCarAirqlyandfragraManager mECarXCarAirqlyandfragraManager;
/*      */   
/*      */   public SensorNew(Context paramContext) {
/*   48 */     super(paramContext);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*   55 */     this.mECarXCarAirqlyandfragraManager = paramECarXCarSetManager.getECarXCarAirqlyandfragraManager();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void buildSensorFunction() {
/*   61 */     ISensorFunction<Float> iSensorFunction57 = FloatSenFunction(1048832);
/*   62 */     ISensorFunction.ISensorStatus<Float> iSensorStatus85 = iSensorFunction57.sensorType(1); FunctionStatus functionStatus17 = FunctionStatus.active;
/*   63 */     ISensorFunction.ISensorValue<Float> iSensorValue104 = iSensorStatus85.fixStatus(functionStatus17); -$$Lambda$SensorNew$pzSeIwSNQmZC2OAGcyQMQ0HJBJc -$$Lambda$SensorNew$pzSeIwSNQmZC2OAGcyQMQ0HJBJc = -$$Lambda$SensorNew$pzSeIwSNQmZC2OAGcyQMQ0HJBJc.INSTANCE;
/*   64 */     ISensorFunction.ISensorEnd<Float> iSensorEnd44 = iSensorValue104.useSigOrPaToValue(31578, -$$Lambda$SensorNew$pzSeIwSNQmZC2OAGcyQMQ0HJBJc); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng48 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*   65 */     iSensorEnd44.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng48);
/*      */ 
/*      */     
/*   68 */     ISensorFunction<Float> iSensorFunction56 = FloatSenFunction(1049088);
/*   69 */     ISensorFunction.ISensorStatus<Float> iSensorStatus32 = iSensorFunction56.sensorType(1);
/*   70 */     ISensorFunction.ISensorValue<Float> iSensorValue103 = iSensorStatus32.usePAToStatus(33399); -$$Lambda$SensorNew$20EJmcr-9Vs55AHQc7KbKnmz2Lk -$$Lambda$SensorNew$20EJmcr-9Vs55AHQc7KbKnmz2Lk = -$$Lambda$SensorNew$20EJmcr-9Vs55AHQc7KbKnmz2Lk.INSTANCE;
/*   71 */     ISensorFunction.ISensorEnd<Float> iSensorEnd43 = iSensorValue103.useSigOrPaToValue(33399, -$$Lambda$SensorNew$20EJmcr-9Vs55AHQc7KbKnmz2Lk); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng47 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */     
/*   74 */     iSensorEnd43.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng47);
/*      */ 
/*      */     
/*   77 */     ISensorFunction<Float> iSensorFunction55 = FloatSenFunction(1049344);
/*   78 */     ISensorFunction.ISensorStatus<Float> iSensorStatus31 = iSensorFunction55.sensorType(1);
/*   79 */     ISensorFunction.ISensorValue<Float> iSensorValue33 = iSensorStatus31.usePAToStatus(33398); -$$Lambda$SensorNew$L-k-gue_qJbac-S3jApsOfHO7M0 -$$Lambda$SensorNew$L-k-gue_qJbac-S3jApsOfHO7M0 = -$$Lambda$SensorNew$L-k-gue_qJbac-S3jApsOfHO7M0.INSTANCE;
/*   80 */     ISensorFunction.ISensorEnd<Float> iSensorEnd94 = iSensorValue33.useSigOrPaToValue(33398, -$$Lambda$SensorNew$L-k-gue_qJbac-S3jApsOfHO7M0); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng26 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*   82 */     iSensorEnd94.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng26);
/*      */ 
/*      */     
/*   85 */     ISensorFunction<Float> iSensorFunction54 = FloatSenFunction(1050112);
/*   86 */     ISensorFunction.ISensorStatus<Float> iSensorStatus84 = iSensorFunction54.sensorType(1); FunctionStatus functionStatus16 = FunctionStatus.active;
/*   87 */     ISensorFunction.ISensorValue<Float> iSensorValue102 = iSensorStatus84.fixStatus(functionStatus16); -$$Lambda$SensorNew$u4z1YOPAXJlAQm-810CCU7gROT4 -$$Lambda$SensorNew$u4z1YOPAXJlAQm-810CCU7gROT4 = -$$Lambda$SensorNew$u4z1YOPAXJlAQm-810CCU7gROT4.INSTANCE;
/*   88 */     ISensorFunction.ISensorEnd<Float> iSensorEnd93 = iSensorValue102.useSigOrPaToValue(30962, -$$Lambda$SensorNew$u4z1YOPAXJlAQm-810CCU7gROT4); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng25 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*   90 */     iSensorEnd93.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng25);
/*      */ 
/*      */     
/*   93 */     ISensorFunction<Float> iSensorFunction53 = FloatSenFunction(1050368);
/*   94 */     ISensorFunction.ISensorStatus<Float> iSensorStatus83 = iSensorFunction53.sensorType(1); FunctionStatus functionStatus15 = FunctionStatus.active;
/*   95 */     ISensorFunction.ISensorValue<Float> iSensorValue32 = iSensorStatus83.fixStatus(functionStatus15); -$$Lambda$SensorNew$FjjN-zPMIISo1soUrDeKJThnMY4 -$$Lambda$SensorNew$FjjN-zPMIISo1soUrDeKJThnMY4 = -$$Lambda$SensorNew$FjjN-zPMIISo1soUrDeKJThnMY4.INSTANCE;
/*   96 */     ISensorFunction.ISensorEnd<Float> iSensorEnd92 = iSensorValue32.useSigOrPaToValue(30889, -$$Lambda$SensorNew$FjjN-zPMIISo1soUrDeKJThnMY4); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng24 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*   98 */     iSensorEnd92.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng24);
/*      */ 
/*      */     
/*  101 */     ISensorFunction<Float> iSensorFunction52 = FloatSenFunction(1050624);
/*  102 */     ISensorFunction.ISensorStatus<Float> iSensorStatus30 = iSensorFunction52.sensorType(1); FunctionStatus functionStatus41 = FunctionStatus.active;
/*  103 */     ISensorFunction.ISensorValue<Float> iSensorValue31 = iSensorStatus30.fixStatus(functionStatus41); -$$Lambda$SensorNew$3c1kP04UZXN7iGEsqWKZ4ugBoyc -$$Lambda$SensorNew$3c1kP04UZXN7iGEsqWKZ4ugBoyc = new -$$Lambda$SensorNew$3c1kP04UZXN7iGEsqWKZ4ugBoyc(this);
/*  104 */     ISensorFunction.ISensorEnd<Float> iSensorEnd91 = iSensorValue31.useSigsOrPasToValue(-$$Lambda$SensorNew$3c1kP04UZXN7iGEsqWKZ4ugBoyc, new int[] { 30956, 30954 }); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng23 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  120 */     iSensorEnd91.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng23);
/*      */ 
/*      */     
/*  123 */     ISensorFunction<Float> iSensorFunction51 = FloatSenFunction(1050880);
/*  124 */     ISensorFunction.ISensorStatus<Float> iSensorStatus29 = iSensorFunction51.sensorType(1); FunctionStatus functionStatus40 = FunctionStatus.active;
/*  125 */     ISensorFunction.ISensorValue<Float> iSensorValue101 = iSensorStatus29.fixStatus(functionStatus40); -$$Lambda$SensorNew$WRvBQNRNbDyqOdfgB1mEY8xs0fc -$$Lambda$SensorNew$WRvBQNRNbDyqOdfgB1mEY8xs0fc = -$$Lambda$SensorNew$WRvBQNRNbDyqOdfgB1mEY8xs0fc.INSTANCE;
/*  126 */     ISensorFunction.ISensorEnd<Float> iSensorEnd90 = iSensorValue101.useSigOrPaToValue(31415, -$$Lambda$SensorNew$WRvBQNRNbDyqOdfgB1mEY8xs0fc); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng22 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  128 */     iSensorEnd90.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng22);
/*      */ 
/*      */     
/*  131 */     ISensorFunction<Float> iSensorFunction50 = FloatSenFunction(1051392);
/*  132 */     ISensorFunction.ISensorStatus<Float> iSensorStatus82 = iSensorFunction50.sensorType(1); -$$Lambda$SensorNew$wH58zLlCji5kXXxRV_ztyLpe1kE -$$Lambda$SensorNew$wH58zLlCji5kXXxRV_ztyLpe1kE = -$$Lambda$SensorNew$wH58zLlCji5kXXxRV_ztyLpe1kE.INSTANCE;
/*  133 */     ISensorFunction.ISensorValue<Float> iSensorValue100 = iSensorStatus82.useSigToStatus(30533, -$$Lambda$SensorNew$wH58zLlCji5kXXxRV_ztyLpe1kE); -$$Lambda$SensorNew$rDXEEOedO1MF3YOUK_5Fr6rcrUI -$$Lambda$SensorNew$rDXEEOedO1MF3YOUK_5Fr6rcrUI = -$$Lambda$SensorNew$rDXEEOedO1MF3YOUK_5Fr6rcrUI.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  142 */     ISensorFunction.ISensorEnd<Float> iSensorEnd42 = iSensorValue100.useSigOrPaToValue(30532, -$$Lambda$SensorNew$rDXEEOedO1MF3YOUK_5Fr6rcrUI); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng46 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  144 */     iSensorEnd42.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng46);
/*      */ 
/*      */     
/*  147 */     ISensorFunction<Float> iSensorFunction49 = FloatSenFunction(1051648);
/*  148 */     ISensorFunction.ISensorStatus<Float> iSensorStatus28 = iSensorFunction49.sensorType(1); -$$Lambda$SensorNew$BIEHOz1xRmdjsIEOLMlpAtFQLtg -$$Lambda$SensorNew$BIEHOz1xRmdjsIEOLMlpAtFQLtg = -$$Lambda$SensorNew$BIEHOz1xRmdjsIEOLMlpAtFQLtg.INSTANCE;
/*  149 */     ISensorFunction.ISensorValue<Float> iSensorValue99 = iSensorStatus28.useSigToStatus(30538, -$$Lambda$SensorNew$BIEHOz1xRmdjsIEOLMlpAtFQLtg); -$$Lambda$SensorNew$V5rBOu3nPNXvQcfqfG7VHAlrfJw -$$Lambda$SensorNew$V5rBOu3nPNXvQcfqfG7VHAlrfJw = -$$Lambda$SensorNew$V5rBOu3nPNXvQcfqfG7VHAlrfJw.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  158 */     ISensorFunction.ISensorEnd<Float> iSensorEnd41 = iSensorValue99.useSigOrPaToValue(30536, -$$Lambda$SensorNew$V5rBOu3nPNXvQcfqfG7VHAlrfJw); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng45 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  160 */     iSensorEnd41.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng45);
/*      */ 
/*      */     
/*  163 */     ISensorFunction<Float> iSensorFunction48 = FloatSenFunction(1052160);
/*  164 */     ISensorFunction.ISensorStatus<Float> iSensorStatus27 = iSensorFunction48.sensorType(1); FunctionStatus functionStatus39 = FunctionStatus.active;
/*  165 */     ISensorFunction.ISensorValue<Float> iSensorValue30 = iSensorStatus27.fixStatus(functionStatus39); -$$Lambda$SensorNew$rkIqO0SmYQE_DbXXxh706XUelK8 -$$Lambda$SensorNew$rkIqO0SmYQE_DbXXxh706XUelK8 = -$$Lambda$SensorNew$rkIqO0SmYQE_DbXXxh706XUelK8.INSTANCE;
/*  166 */     ISensorFunction.ISensorEnd<Float> iSensorEnd40 = iSensorValue30.useSigOrPaToValue(30482, -$$Lambda$SensorNew$rkIqO0SmYQE_DbXXxh706XUelK8); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng44 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  168 */     iSensorEnd40.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng44);
/*      */ 
/*      */     
/*  171 */     ISensorFunction<Float> iSensorFunction47 = FloatSenFunction(1052672);
/*  172 */     ISensorFunction.ISensorStatus<Float> iSensorStatus81 = iSensorFunction47.sensorType(1); FunctionStatus functionStatus14 = FunctionStatus.active;
/*  173 */     ISensorFunction.ISensorValue<Float> iSensorValue29 = iSensorStatus81.fixStatus(functionStatus14); -$$Lambda$SensorNew$xNvOX0yFYKsI-Bfdo0y15H2V4Bg -$$Lambda$SensorNew$xNvOX0yFYKsI-Bfdo0y15H2V4Bg = -$$Lambda$SensorNew$xNvOX0yFYKsI-Bfdo0y15H2V4Bg.INSTANCE;
/*  174 */     ISensorFunction.ISensorEnd<Float> iSensorEnd39 = iSensorValue29.useSigOrPaToValue(31549, -$$Lambda$SensorNew$xNvOX0yFYKsI-Bfdo0y15H2V4Bg); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng43 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  183 */     iSensorEnd39.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng43);
/*      */ 
/*      */     
/*  186 */     ISensorFunction<Float> iSensorFunction46 = FloatSenFunction(1052928);
/*  187 */     ISensorFunction.ISensorStatus<Float> iSensorStatus80 = iSensorFunction46.sensorType(1); FunctionStatus functionStatus13 = FunctionStatus.active;
/*  188 */     ISensorFunction.ISensorValue<Float> iSensorValue28 = iSensorStatus80.fixStatus(functionStatus13); -$$Lambda$SensorNew$wpnFpKDvRmBRsI9jenMx4Y51uFE -$$Lambda$SensorNew$wpnFpKDvRmBRsI9jenMx4Y51uFE = -$$Lambda$SensorNew$wpnFpKDvRmBRsI9jenMx4Y51uFE.INSTANCE;
/*  189 */     ISensorFunction.ISensorEnd<Float> iSensorEnd38 = iSensorValue28.useSigOrPaToValue(31550, -$$Lambda$SensorNew$wpnFpKDvRmBRsI9jenMx4Y51uFE); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng42 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  191 */     iSensorEnd38.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng42);
/*      */ 
/*      */     
/*  194 */     ISensorFunction<Float> iSensorFunction45 = FloatSenFunction(1053184);
/*  195 */     ISensorFunction.ISensorStatus<Float> iSensorStatus26 = iSensorFunction45.sensorType(1); FunctionStatus functionStatus38 = FunctionStatus.active;
/*  196 */     ISensorFunction.ISensorValue<Float> iSensorValue27 = iSensorStatus26.fixStatus(functionStatus38); -$$Lambda$SensorNew$iqSZYntl_LHD4K0ThvQf5iwRnw0 -$$Lambda$SensorNew$iqSZYntl_LHD4K0ThvQf5iwRnw0 = -$$Lambda$SensorNew$iqSZYntl_LHD4K0ThvQf5iwRnw0.INSTANCE;
/*  197 */     ISensorFunction.ISensorEnd<Float> iSensorEnd37 = iSensorValue27.useSigOrPaToValue(31573, -$$Lambda$SensorNew$iqSZYntl_LHD4K0ThvQf5iwRnw0); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng41 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  199 */     iSensorEnd37.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng41);
/*      */ 
/*      */     
/*  202 */     ISensorFunction<Float> iSensorFunction44 = FloatSenFunction(1054720);
/*  203 */     ISensorFunction.ISensorStatus<Float> iSensorStatus79 = iSensorFunction44.sensorType(1); FunctionStatus functionStatus12 = FunctionStatus.active;
/*  204 */     ISensorFunction.ISensorValue<Float> iSensorValue98 = iSensorStatus79.fixStatus(functionStatus12); -$$Lambda$SensorNew$8xUSvxOwq54D5EIAn56_uWPkV_I -$$Lambda$SensorNew$8xUSvxOwq54D5EIAn56_uWPkV_I = -$$Lambda$SensorNew$8xUSvxOwq54D5EIAn56_uWPkV_I.INSTANCE;
/*  205 */     ISensorFunction.ISensorEnd<Float> iSensorEnd36 = iSensorValue98.useSigOrPaToValue(30956, -$$Lambda$SensorNew$8xUSvxOwq54D5EIAn56_uWPkV_I); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng40 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  207 */     iSensorEnd36.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng40);
/*      */ 
/*      */     
/*  210 */     ISensorFunction<Float> iSensorFunction43 = FloatSenFunction(1054976);
/*  211 */     ISensorFunction.ISensorStatus<Float> iSensorStatus78 = iSensorFunction43.sensorType(1); -$$Lambda$SensorNew$6xDqZDh2SkS6HeV5dBKZABNzQUQ -$$Lambda$SensorNew$6xDqZDh2SkS6HeV5dBKZABNzQUQ = -$$Lambda$SensorNew$6xDqZDh2SkS6HeV5dBKZABNzQUQ.INSTANCE;
/*  212 */     ISensorFunction.ISensorValue<Float> iSensorValue97 = iSensorStatus78.useSigToStatus(29337, -$$Lambda$SensorNew$6xDqZDh2SkS6HeV5dBKZABNzQUQ); -$$Lambda$SensorNew$DxCTNgXAzpvqt-zGXN-IMtNDiyk -$$Lambda$SensorNew$DxCTNgXAzpvqt-zGXN-IMtNDiyk = -$$Lambda$SensorNew$DxCTNgXAzpvqt-zGXN-IMtNDiyk.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  223 */     ISensorFunction.ISensorEnd<Float> iSensorEnd89 = iSensorValue97.useSigOrPaToValue(30954, -$$Lambda$SensorNew$DxCTNgXAzpvqt-zGXN-IMtNDiyk); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng21 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */     
/*  226 */     iSensorEnd89.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng21);
/*      */ 
/*      */     
/*  229 */     ISensorFunction<Float> iSensorFunction42 = FloatSenFunction(1055232);
/*  230 */     ISensorFunction.ISensorStatus<Float> iSensorStatus25 = iSensorFunction42.sensorType(1); FunctionStatus functionStatus37 = FunctionStatus.active;
/*  231 */     ISensorFunction.ISensorValue<Float> iSensorValue26 = iSensorStatus25.fixStatus(functionStatus37); -$$Lambda$SensorNew$_B0zcCesqEgPnUpB2NKgWLhYn2s -$$Lambda$SensorNew$_B0zcCesqEgPnUpB2NKgWLhYn2s = new -$$Lambda$SensorNew$_B0zcCesqEgPnUpB2NKgWLhYn2s(this);
/*  232 */     ISensorFunction.ISensorEnd<Float> iSensorEnd35 = iSensorValue26.useSigsOrPasToValue(-$$Lambda$SensorNew$_B0zcCesqEgPnUpB2NKgWLhYn2s, new int[] { 30989, 30988 }); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng39 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  243 */     iSensorEnd35.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng39);
/*      */ 
/*      */     
/*  246 */     ISensorFunction<Float> iSensorFunction41 = FloatSenFunction(4194560);
/*  247 */     ISensorFunction.ISensorStatus<Float> iSensorStatus77 = iSensorFunction41.sensorType(1); -$$Lambda$SensorNew$UE4ckaB5R_16KQQSt4PI862PNig -$$Lambda$SensorNew$UE4ckaB5R_16KQQSt4PI862PNig = -$$Lambda$SensorNew$UE4ckaB5R_16KQQSt4PI862PNig.INSTANCE;
/*  248 */     ISensorFunction.ISensorValue<Float> iSensorValue96 = iSensorStatus77.useSigToStatus(30788, -$$Lambda$SensorNew$UE4ckaB5R_16KQQSt4PI862PNig); -$$Lambda$SensorNew$irX8RbRWHxmm5RqkP2AN3J-p3mc -$$Lambda$SensorNew$irX8RbRWHxmm5RqkP2AN3J-p3mc = new -$$Lambda$SensorNew$irX8RbRWHxmm5RqkP2AN3J-p3mc(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  255 */     ISensorFunction.ISensorEnd<Float> iSensorEnd34 = iSensorValue96.useSigsOrPasToValue(-$$Lambda$SensorNew$irX8RbRWHxmm5RqkP2AN3J-p3mc, new int[] { 30959, 30958 }); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng38 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  290 */     iSensorEnd34.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng38);
/*      */ 
/*      */     
/*  293 */     ISensorFunction<Float> iSensorFunction40 = FloatSenFunction(4194816);
/*  294 */     ISensorFunction.ISensorStatus<Float> iSensorStatus76 = iSensorFunction40.sensorType(1); FunctionStatus functionStatus11 = FunctionStatus.active;
/*  295 */     ISensorFunction.ISensorValue<Float> iSensorValue25 = iSensorStatus76.fixStatus(functionStatus11); -$$Lambda$SensorNew$9CqrO1wJKXP82Rl5t3TzoLI8Bgs -$$Lambda$SensorNew$9CqrO1wJKXP82Rl5t3TzoLI8Bgs = -$$Lambda$SensorNew$9CqrO1wJKXP82Rl5t3TzoLI8Bgs.INSTANCE;
/*  296 */     ISensorFunction.ISensorEnd<Float> iSensorEnd88 = iSensorValue25.useSigOrPaToValue(30961, -$$Lambda$SensorNew$9CqrO1wJKXP82Rl5t3TzoLI8Bgs); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng20 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  298 */     iSensorEnd88.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng20);
/*      */ 
/*      */     
/*  301 */     ISensorFunction<Float> iSensorFunction39 = FloatSenFunction(4195072);
/*  302 */     ISensorFunction.ISensorStatus<Float> iSensorStatus24 = iSensorFunction39.sensorType(1); -$$Lambda$SensorNew$BNgFL6oMOeIgxa7qcNok0pv8S8g -$$Lambda$SensorNew$BNgFL6oMOeIgxa7qcNok0pv8S8g = -$$Lambda$SensorNew$BNgFL6oMOeIgxa7qcNok0pv8S8g.INSTANCE;
/*  303 */     ISensorFunction.ISensorValue<Float> iSensorValue24 = iSensorStatus24.useSigToStatus(30788, -$$Lambda$SensorNew$BNgFL6oMOeIgxa7qcNok0pv8S8g); -$$Lambda$SensorNew$fbIN1sX7bN3fEwFwY1AAHcCbDf4 -$$Lambda$SensorNew$fbIN1sX7bN3fEwFwY1AAHcCbDf4 = new -$$Lambda$SensorNew$fbIN1sX7bN3fEwFwY1AAHcCbDf4(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  310 */     ISensorFunction.ISensorEnd<Float> iSensorEnd33 = iSensorValue24.useSigsOrPasToValue(-$$Lambda$SensorNew$fbIN1sX7bN3fEwFwY1AAHcCbDf4, new int[] { 30959, 30958 }); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng37 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  344 */     iSensorEnd33.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng37);
/*      */ 
/*      */     
/*  347 */     ISensorFunction<Float> iSensorFunction38 = FloatSenFunction(4206592);
/*  348 */     ISensorFunction.ISensorStatus<Float> iSensorStatus23 = iSensorFunction38.sensorType(1);
/*  349 */     ISensorFunction.ISensorValue<Float> iSensorValue95 = iSensorStatus23.usePAToStatus(33956); -$$Lambda$SensorNew$JDP667ByNd8c5adTnHSvTqH2L3Y -$$Lambda$SensorNew$JDP667ByNd8c5adTnHSvTqH2L3Y = -$$Lambda$SensorNew$JDP667ByNd8c5adTnHSvTqH2L3Y.INSTANCE;
/*  350 */     ISensorFunction.ISensorEnd<Float> iSensorEnd87 = iSensorValue95.useSigOrPaToValue(33956, -$$Lambda$SensorNew$JDP667ByNd8c5adTnHSvTqH2L3Y); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng19 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  352 */     iSensorEnd87.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng19);
/*      */ 
/*      */     
/*  355 */     ISensorFunction<Float> iSensorFunction37 = FloatSenFunction(4206848);
/*  356 */     ISensorFunction.ISensorStatus<Float> iSensorStatus22 = iSensorFunction37.sensorType(1);
/*  357 */     ISensorFunction.ISensorValue<Float> iSensorValue94 = iSensorStatus22.usePAToStatus(33957); -$$Lambda$SensorNew$qBRq6YNOItZ1M28XHIe4fyJm3Tc -$$Lambda$SensorNew$qBRq6YNOItZ1M28XHIe4fyJm3Tc = -$$Lambda$SensorNew$qBRq6YNOItZ1M28XHIe4fyJm3Tc.INSTANCE;
/*  358 */     ISensorFunction.ISensorEnd<Float> iSensorEnd86 = iSensorValue94.useSigOrPaToValue(33957, -$$Lambda$SensorNew$qBRq6YNOItZ1M28XHIe4fyJm3Tc); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng18 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  360 */     iSensorEnd86.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng18);
/*      */ 
/*      */     
/*  363 */     ISensorFunction<Float> iSensorFunction36 = FloatSenFunction(4215296);
/*  364 */     ISensorFunction.ISensorStatus<Float> iSensorStatus21 = iSensorFunction36.sensorType(1);
/*  365 */     ISensorFunction.ISensorValue<Float> iSensorValue93 = iSensorStatus21.usePAToStatus(33957); -$$Lambda$SensorNew$j3mDiPrCg0O5cAjITmabG_xRZEA -$$Lambda$SensorNew$j3mDiPrCg0O5cAjITmabG_xRZEA = -$$Lambda$SensorNew$j3mDiPrCg0O5cAjITmabG_xRZEA.INSTANCE;
/*  366 */     ISensorFunction.ISensorEnd<Float> iSensorEnd85 = iSensorValue93.useSigOrPaToValue(33957, -$$Lambda$SensorNew$j3mDiPrCg0O5cAjITmabG_xRZEA); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng17 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  368 */     iSensorEnd85.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng17);
/*      */ 
/*      */     
/*  371 */     ISensorFunction<Float> iSensorFunction35 = FloatSenFunction(4215552);
/*  372 */     ISensorFunction.ISensorStatus<Float> iSensorStatus20 = iSensorFunction35.sensorType(1);
/*  373 */     ISensorFunction.ISensorValue<Float> iSensorValue23 = iSensorStatus20.usePAToStatus(33711); -$$Lambda$SensorNew$xIB13ame0KHGIpezmbdiZm2EgYI -$$Lambda$SensorNew$xIB13ame0KHGIpezmbdiZm2EgYI = -$$Lambda$SensorNew$xIB13ame0KHGIpezmbdiZm2EgYI.INSTANCE;
/*  374 */     ISensorFunction.ISensorEnd<Float> iSensorEnd84 = iSensorValue23.useSigOrPaToValue(33712, -$$Lambda$SensorNew$xIB13ame0KHGIpezmbdiZm2EgYI); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng16 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  376 */     iSensorEnd84.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng16);
/*      */ 
/*      */     
/*  379 */     ISensorFunction<Float> iSensorFunction34 = FloatSenFunction(4215808);
/*  380 */     ISensorFunction.ISensorStatus<Float> iSensorStatus19 = iSensorFunction34.sensorType(1);
/*  381 */     ISensorFunction.ISensorValue<Float> iSensorValue92 = iSensorStatus19.usePAToStatus(33711); -$$Lambda$SensorNew$e9I97SXpVrCJt3ysNS0bGFJknTM -$$Lambda$SensorNew$e9I97SXpVrCJt3ysNS0bGFJknTM = -$$Lambda$SensorNew$e9I97SXpVrCJt3ysNS0bGFJknTM.INSTANCE;
/*  382 */     ISensorFunction.ISensorEnd<Float> iSensorEnd83 = iSensorValue92.useSigOrPaToValue(33713, -$$Lambda$SensorNew$e9I97SXpVrCJt3ysNS0bGFJknTM); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng15 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  384 */     iSensorEnd83.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng15);
/*      */ 
/*      */     
/*  387 */     ISensorFunction<Float> iSensorFunction33 = FloatSenFunction(4216064);
/*  388 */     ISensorFunction.ISensorStatus<Float> iSensorStatus18 = iSensorFunction33.sensorType(1);
/*  389 */     ISensorFunction.ISensorValue<Float> iSensorValue91 = iSensorStatus18.usePAToStatus(33711); -$$Lambda$SensorNew$08cQSYpcG6htpTNm2h74PQsHAK4 -$$Lambda$SensorNew$08cQSYpcG6htpTNm2h74PQsHAK4 = -$$Lambda$SensorNew$08cQSYpcG6htpTNm2h74PQsHAK4.INSTANCE;
/*  390 */     ISensorFunction.ISensorEnd<Float> iSensorEnd82 = iSensorValue91.useSigOrPaToValue(33714, -$$Lambda$SensorNew$08cQSYpcG6htpTNm2h74PQsHAK4); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng14 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  392 */     iSensorEnd82.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng14);
/*      */ 
/*      */     
/*  395 */     ISensorFunction<Float> iSensorFunction32 = FloatSenFunction(4216320);
/*  396 */     ISensorFunction.ISensorStatus<Float> iSensorStatus17 = iSensorFunction32.sensorType(1);
/*  397 */     ISensorFunction.ISensorValue<Float> iSensorValue22 = iSensorStatus17.usePAToStatus(33711); -$$Lambda$SensorNew$iG8unUGRDy3SpNhALl_dHaUI8f8 -$$Lambda$SensorNew$iG8unUGRDy3SpNhALl_dHaUI8f8 = -$$Lambda$SensorNew$iG8unUGRDy3SpNhALl_dHaUI8f8.INSTANCE;
/*  398 */     ISensorFunction.ISensorEnd<Float> iSensorEnd32 = iSensorValue22.useSigOrPaToValue(33715, -$$Lambda$SensorNew$iG8unUGRDy3SpNhALl_dHaUI8f8); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng36 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  400 */     iSensorEnd32.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng36);
/*      */ 
/*      */     
/*  403 */     ISensorFunction<Float> iSensorFunction31 = FloatSenFunction(4216576);
/*  404 */     ISensorFunction.ISensorStatus<Float> iSensorStatus16 = iSensorFunction31.sensorType(1);
/*  405 */     ISensorFunction.ISensorValue<Float> iSensorValue21 = iSensorStatus16.usePAToStatus(33711); -$$Lambda$SensorNew$1DlrvsBDGm8dXy8wcxS3XkwzYPI -$$Lambda$SensorNew$1DlrvsBDGm8dXy8wcxS3XkwzYPI = -$$Lambda$SensorNew$1DlrvsBDGm8dXy8wcxS3XkwzYPI.INSTANCE;
/*  406 */     ISensorFunction.ISensorEnd<Float> iSensorEnd81 = iSensorValue21.useSigOrPaToValue(33716, -$$Lambda$SensorNew$1DlrvsBDGm8dXy8wcxS3XkwzYPI); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng13 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  408 */     iSensorEnd81.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng13);
/*      */ 
/*      */     
/*  411 */     ISensorFunction<Float> iSensorFunction30 = FloatSenFunction(4210688);
/*  412 */     ISensorFunction.ISensorStatus<Float> iSensorStatus75 = iSensorFunction30.sensorType(1); -$$Lambda$SensorNew$HpSnXqMsoDOfAIxzaCgkdN2SlgM -$$Lambda$SensorNew$HpSnXqMsoDOfAIxzaCgkdN2SlgM = new -$$Lambda$SensorNew$HpSnXqMsoDOfAIxzaCgkdN2SlgM(this);
/*  413 */     ISensorFunction.ISensorValue<Float> iSensorValue90 = iSensorStatus75.useSigsToStatus(-$$Lambda$SensorNew$HpSnXqMsoDOfAIxzaCgkdN2SlgM, new int[] { 29337, 30788, 30779 }); -$$Lambda$SensorNew$bnqPhGhKBkaXz0wcIbJXzV5TtzE -$$Lambda$SensorNew$bnqPhGhKBkaXz0wcIbJXzV5TtzE = new -$$Lambda$SensorNew$bnqPhGhKBkaXz0wcIbJXzV5TtzE(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  425 */     ISensorFunction.ISensorEnd<Float> iSensorEnd80 = iSensorValue90.useSigsOrPasToValue(-$$Lambda$SensorNew$bnqPhGhKBkaXz0wcIbJXzV5TtzE, new int[] { 33799, 31325 }); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng12 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  436 */     iSensorEnd80.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng12);
/*      */ 
/*      */     
/*  439 */     ISensorFunction<Float> iSensorFunction29 = FloatSenFunction(4211968);
/*  440 */     ISensorFunction.ISensorStatus<Float> iSensorStatus15 = iSensorFunction29.sensorType(1); FunctionStatus functionStatus36 = FunctionStatus.active;
/*  441 */     ISensorFunction.ISensorValue<Float> iSensorValue20 = iSensorStatus15.fixStatus(functionStatus36); -$$Lambda$SensorNew$HpENn4Ag9bqoeP0C3M__fWiuamo -$$Lambda$SensorNew$HpENn4Ag9bqoeP0C3M__fWiuamo = -$$Lambda$SensorNew$HpENn4Ag9bqoeP0C3M__fWiuamo.INSTANCE;
/*  442 */     ISensorFunction.ISensorEnd<Float> iSensorEnd79 = iSensorValue20.useSigOrPaToValue(30925, -$$Lambda$SensorNew$HpENn4Ag9bqoeP0C3M__fWiuamo); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng11 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  444 */     iSensorEnd79.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng11);
/*      */ 
/*      */     
/*  447 */     ISensorFunction<Float> iSensorFunction28 = FloatSenFunction(5243136);
/*  448 */     ISensorFunction.ISensorStatus<Float> iSensorStatus74 = iSensorFunction28.sensorType(1); -$$Lambda$SensorNew$pyYf041dAozmNGOn6MNLb53JaKA -$$Lambda$SensorNew$pyYf041dAozmNGOn6MNLb53JaKA = new -$$Lambda$SensorNew$pyYf041dAozmNGOn6MNLb53JaKA(this);
/*  449 */     ISensorFunction.ISensorValue<Float> iSensorValue19 = iSensorStatus74.useSigsToStatus(-$$Lambda$SensorNew$pyYf041dAozmNGOn6MNLb53JaKA, new int[] { 30779, 30788, 31320 }); -$$Lambda$SensorNew$pf7IbhDKiVs4B6WjKm5DYT0HC1E -$$Lambda$SensorNew$pf7IbhDKiVs4B6WjKm5DYT0HC1E = -$$Lambda$SensorNew$pf7IbhDKiVs4B6WjKm5DYT0HC1E.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  454 */     ISensorFunction.ISensorEnd<Float> iSensorEnd31 = iSensorValue19.useSigOrPaToValue(30614, -$$Lambda$SensorNew$pf7IbhDKiVs4B6WjKm5DYT0HC1E); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng35 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  456 */     iSensorEnd31.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng35);
/*      */ 
/*      */     
/*  459 */     ISensorFunction<Float> iSensorFunction27 = FloatSenFunction(5243392);
/*  460 */     ISensorFunction.ISensorStatus<Float> iSensorStatus14 = iSensorFunction27.sensorType(1); -$$Lambda$SensorNew$75NafN5oFYy5Sdox1H5tlZcOPbE -$$Lambda$SensorNew$75NafN5oFYy5Sdox1H5tlZcOPbE = new -$$Lambda$SensorNew$75NafN5oFYy5Sdox1H5tlZcOPbE(this);
/*  461 */     ISensorFunction.ISensorValue<Float> iSensorValue18 = iSensorStatus14.useSigsToStatus(-$$Lambda$SensorNew$75NafN5oFYy5Sdox1H5tlZcOPbE, new int[] { 30779, 30788, 31322 }); -$$Lambda$SensorNew$YTSQVleuTnY1Eid7wwI30TAStUk -$$Lambda$SensorNew$YTSQVleuTnY1Eid7wwI30TAStUk = -$$Lambda$SensorNew$YTSQVleuTnY1Eid7wwI30TAStUk.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  466 */     ISensorFunction.ISensorEnd<Float> iSensorEnd78 = iSensorValue18.useSigOrPaToValue(30696, -$$Lambda$SensorNew$YTSQVleuTnY1Eid7wwI30TAStUk); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng10 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  468 */     iSensorEnd78.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng10);
/*      */ 
/*      */     
/*  471 */     ISensorFunction<Float> iSensorFunction26 = FloatSenFunction(5243648);
/*  472 */     ISensorFunction.ISensorStatus<Float> iSensorStatus13 = iSensorFunction26.sensorType(1); -$$Lambda$SensorNew$1qSq3PgscW08RUbNzl_fDK3tfCc -$$Lambda$SensorNew$1qSq3PgscW08RUbNzl_fDK3tfCc = new -$$Lambda$SensorNew$1qSq3PgscW08RUbNzl_fDK3tfCc(this);
/*  473 */     ISensorFunction.ISensorValue<Float> iSensorValue17 = iSensorStatus13.useSigsToStatus(-$$Lambda$SensorNew$1qSq3PgscW08RUbNzl_fDK3tfCc, new int[] { 30779, 30788, 31321 }); -$$Lambda$SensorNew$HqbSuoJGlOUzmRhhOQGc6JdbXq4 -$$Lambda$SensorNew$HqbSuoJGlOUzmRhhOQGc6JdbXq4 = -$$Lambda$SensorNew$HqbSuoJGlOUzmRhhOQGc6JdbXq4.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  478 */     ISensorFunction.ISensorEnd<Float> iSensorEnd30 = iSensorValue17.useSigOrPaToValue(30623, -$$Lambda$SensorNew$HqbSuoJGlOUzmRhhOQGc6JdbXq4); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng34 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  480 */     iSensorEnd30.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng34);
/*      */ 
/*      */     
/*  483 */     ISensorFunction<Float> iSensorFunction25 = FloatSenFunction(5243904);
/*  484 */     ISensorFunction.ISensorStatus<Float> iSensorStatus12 = iSensorFunction25.sensorType(1); -$$Lambda$SensorNew$BdMzfrB_DUfnidK2E-w4RSAUgmE -$$Lambda$SensorNew$BdMzfrB_DUfnidK2E-w4RSAUgmE = new -$$Lambda$SensorNew$BdMzfrB_DUfnidK2E-w4RSAUgmE(this);
/*  485 */     ISensorFunction.ISensorValue<Float> iSensorValue16 = iSensorStatus12.useSigsToStatus(-$$Lambda$SensorNew$BdMzfrB_DUfnidK2E-w4RSAUgmE, new int[] { 30779, 30788, 31323 }); -$$Lambda$SensorNew$eqK24ZUAIYDFBeDjC9OCmmCEUu0 -$$Lambda$SensorNew$eqK24ZUAIYDFBeDjC9OCmmCEUu0 = -$$Lambda$SensorNew$eqK24ZUAIYDFBeDjC9OCmmCEUu0.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  490 */     ISensorFunction.ISensorEnd<Float> iSensorEnd77 = iSensorValue16.useSigOrPaToValue(30705, -$$Lambda$SensorNew$eqK24ZUAIYDFBeDjC9OCmmCEUu0); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng9 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  492 */     iSensorEnd77.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng9);
/*      */ 
/*      */     
/*  495 */     ISensorFunction<Float> iSensorFunction24 = FloatSenFunction(5244160);
/*  496 */     ISensorFunction.ISensorStatus<Float> iSensorStatus73 = iSensorFunction24.sensorType(1); -$$Lambda$SensorNew$pjPE6n4GB6u_ZmshGvY6ZGog4zM -$$Lambda$SensorNew$pjPE6n4GB6u_ZmshGvY6ZGog4zM = new -$$Lambda$SensorNew$pjPE6n4GB6u_ZmshGvY6ZGog4zM(this);
/*  497 */     ISensorFunction.ISensorValue<Float> iSensorValue15 = iSensorStatus73.useSigsToStatus(-$$Lambda$SensorNew$pjPE6n4GB6u_ZmshGvY6ZGog4zM, new int[] { 30779, 30788, 31320 }); -$$Lambda$SensorNew$bdOynZGb0LtUmYQGItVTCx5Y-v4 -$$Lambda$SensorNew$bdOynZGb0LtUmYQGItVTCx5Y-v4 = -$$Lambda$SensorNew$bdOynZGb0LtUmYQGItVTCx5Y-v4.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  502 */     ISensorFunction.ISensorEnd<Float> iSensorEnd76 = iSensorValue15.useSigOrPaToValue(30617, -$$Lambda$SensorNew$bdOynZGb0LtUmYQGItVTCx5Y-v4); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng8 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  504 */     iSensorEnd76.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng8);
/*      */ 
/*      */     
/*  507 */     ISensorFunction<Float> iSensorFunction23 = FloatSenFunction(5244416);
/*  508 */     ISensorFunction.ISensorStatus<Float> iSensorStatus11 = iSensorFunction23.sensorType(1); -$$Lambda$SensorNew$nH98s9JFxD0fkJUHFI_l9xlb4Ug -$$Lambda$SensorNew$nH98s9JFxD0fkJUHFI_l9xlb4Ug = new -$$Lambda$SensorNew$nH98s9JFxD0fkJUHFI_l9xlb4Ug(this);
/*  509 */     ISensorFunction.ISensorValue<Float> iSensorValue14 = iSensorStatus11.useSigsToStatus(-$$Lambda$SensorNew$nH98s9JFxD0fkJUHFI_l9xlb4Ug, new int[] { 30779, 30788, 31322 }); -$$Lambda$SensorNew$cn_avnBfReaRrQBaAA06eLMzqjc -$$Lambda$SensorNew$cn_avnBfReaRrQBaAA06eLMzqjc = -$$Lambda$SensorNew$cn_avnBfReaRrQBaAA06eLMzqjc.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  514 */     ISensorFunction.ISensorEnd<Float> iSensorEnd75 = iSensorValue14.useSigOrPaToValue(30699, -$$Lambda$SensorNew$cn_avnBfReaRrQBaAA06eLMzqjc); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng7 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  516 */     iSensorEnd75.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng7);
/*      */ 
/*      */     
/*  519 */     ISensorFunction<Float> iSensorFunction22 = FloatSenFunction(5244672);
/*  520 */     ISensorFunction.ISensorStatus<Float> iSensorStatus72 = iSensorFunction22.sensorType(1); -$$Lambda$SensorNew$ScA1s1O_1e4JgE0weNJ0GiO4a9g -$$Lambda$SensorNew$ScA1s1O_1e4JgE0weNJ0GiO4a9g = new -$$Lambda$SensorNew$ScA1s1O_1e4JgE0weNJ0GiO4a9g(this);
/*  521 */     ISensorFunction.ISensorValue<Float> iSensorValue13 = iSensorStatus72.useSigsToStatus(-$$Lambda$SensorNew$ScA1s1O_1e4JgE0weNJ0GiO4a9g, new int[] { 30779, 30788, 31321 }); -$$Lambda$SensorNew$rD9MsEuHesjv6we5zv29Gl5S_dU -$$Lambda$SensorNew$rD9MsEuHesjv6we5zv29Gl5S_dU = -$$Lambda$SensorNew$rD9MsEuHesjv6we5zv29Gl5S_dU.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  526 */     ISensorFunction.ISensorEnd<Float> iSensorEnd29 = iSensorValue13.useSigOrPaToValue(30626, -$$Lambda$SensorNew$rD9MsEuHesjv6we5zv29Gl5S_dU); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng33 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  528 */     iSensorEnd29.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng33);
/*      */ 
/*      */     
/*  531 */     ISensorFunction<Float> iSensorFunction21 = FloatSenFunction(5244928);
/*  532 */     ISensorFunction.ISensorStatus<Float> iSensorStatus71 = iSensorFunction21.sensorType(1); -$$Lambda$SensorNew$rPRcx9iNuAmad-qbTDGjqTg_fiE -$$Lambda$SensorNew$rPRcx9iNuAmad-qbTDGjqTg_fiE = new -$$Lambda$SensorNew$rPRcx9iNuAmad-qbTDGjqTg_fiE(this);
/*  533 */     ISensorFunction.ISensorValue<Float> iSensorValue89 = iSensorStatus71.useSigsToStatus(-$$Lambda$SensorNew$rPRcx9iNuAmad-qbTDGjqTg_fiE, new int[] { 30779, 30788, 31323 }); -$$Lambda$SensorNew$jX9GbS96jXyWnj7nh7o0Tchu7r8 -$$Lambda$SensorNew$jX9GbS96jXyWnj7nh7o0Tchu7r8 = -$$Lambda$SensorNew$jX9GbS96jXyWnj7nh7o0Tchu7r8.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  538 */     ISensorFunction.ISensorEnd<Float> iSensorEnd28 = iSensorValue89.useSigOrPaToValue(30708, -$$Lambda$SensorNew$jX9GbS96jXyWnj7nh7o0Tchu7r8); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng32 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/*      */     
/*  540 */     iSensorEnd28.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng32);
/*      */ 
/*      */     
/*  543 */     Pairs<Integer, Integer> pairs32 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2097410));
/*      */     
/*  545 */     pairs32 = pairs32.add(Integer.valueOf(1), Integer.valueOf(2097411));
/*  546 */     pairs32 = pairs32.add(Integer.valueOf(2), Integer.valueOf(2097413));
/*  547 */     pairs32 = pairs32.add(Integer.valueOf(11), Integer.valueOf(2097414));
/*  548 */     pairs32 = pairs32.add(Integer.valueOf(13), Integer.valueOf(2097415));
/*  549 */     ISensorFunction<Integer> iSensorFunction104 = IntSenFunction(2097408);
/*  550 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus70 = iSensorFunction104.sensorType(2); FunctionStatus functionStatus48 = FunctionStatus.active;
/*  551 */     ISensorFunction.ISensorValue<Integer> iSensorValue88 = iSensorStatus70.fixStatus(functionStatus48);
/*  552 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd27 = iSensorValue88.useSigOrPaToValue(pairs32, 30788); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q47 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  553 */     iSensorEnd27.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q47);
/*      */ 
/*      */     
/*  556 */     ISensorFunction<Integer> iSensorFunction20 = IntSenFunction(2097664);
/*  557 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus69 = iSensorFunction20.sensorType(2); FunctionStatus functionStatus10 = FunctionStatus.active;
/*  558 */     ISensorFunction.ISensorValue<Integer> iSensorValue87 = iSensorStatus69.fixStatus(functionStatus10); -$$Lambda$SensorNew$3wbfMgznu0JaSMG2RV77sI4qdeo -$$Lambda$SensorNew$3wbfMgznu0JaSMG2RV77sI4qdeo = new -$$Lambda$SensorNew$3wbfMgznu0JaSMG2RV77sI4qdeo(this);
/*  559 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd26 = iSensorValue87.useSigsOrPasToValue(-$$Lambda$SensorNew$3wbfMgznu0JaSMG2RV77sI4qdeo, new int[] { 31419, 31509, 29335 }); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q46 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */ 
/*      */     
/*  562 */     iSensorEnd26.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q46);
/*      */ 
/*      */     
/*  565 */     Pairs<Integer, Integer> pairs31 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2098177));
/*      */     
/*  567 */     pairs31 = pairs31.add(Integer.valueOf(1), Integer.valueOf(2098178));
/*  568 */     pairs31 = pairs31.add(Integer.valueOf(2), Integer.valueOf(2098179));
/*  569 */     pairs31 = pairs31.add(Integer.valueOf(3), Integer.valueOf(2098180));
/*  570 */     ISensorFunction<Integer> iSensorFunction103 = IntSenFunction(2098176);
/*  571 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus68 = iSensorFunction103.sensorType(2); functionStatus48 = FunctionStatus.active;
/*  572 */     ISensorFunction.ISensorValue<Integer> iSensorValue86 = iSensorStatus68.fixStatus(functionStatus48);
/*  573 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd74 = iSensorValue86.useSigOrPaToValue(pairs31, 31413); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q17 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  574 */     iSensorEnd74.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q17);
/*      */ 
/*      */     
/*  577 */     ISensorFunction<Integer> iSensorFunction19 = IntSenFunction(2101248);
/*  578 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus10 = iSensorFunction19.sensorType(2); FunctionStatus functionStatus35 = FunctionStatus.active;
/*  579 */     ISensorFunction.ISensorValue<Integer> iSensorValue85 = iSensorStatus10.fixStatus(functionStatus35); -$$Lambda$SensorNew$7AA0a2ypOXFjTtN48jitl2tc9Do -$$Lambda$SensorNew$7AA0a2ypOXFjTtN48jitl2tc9Do = new -$$Lambda$SensorNew$7AA0a2ypOXFjTtN48jitl2tc9Do(this);
/*  580 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd25 = iSensorValue85.useSigsOrPasToValue(-$$Lambda$SensorNew$7AA0a2ypOXFjTtN48jitl2tc9Do, new int[0]); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q45 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  582 */     iSensorEnd25.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q45);
/*      */ 
/*      */     
/*  585 */     Pairs<Integer, Integer> pairs30 = Pairs.of(Integer.valueOf(1), Integer.valueOf(2101762));
/*      */     
/*  587 */     pairs30 = pairs30.add(Integer.valueOf(0), Integer.valueOf(2101761));
/*  588 */     ISensorFunction<Integer> iSensorFunction102 = IntSenFunction(2101760);
/*  589 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus99 = iSensorFunction102.sensorType(2); FunctionStatus functionStatus34 = FunctionStatus.active;
/*  590 */     ISensorFunction.ISensorValue<Integer> iSensorValue84 = iSensorStatus99.fixStatus(functionStatus34);
/*  591 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd73 = iSensorValue84.useSigOrPaToValue(pairs30, 31272); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q52 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  592 */     iSensorEnd73.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q52);
/*      */ 
/*      */     
/*  595 */     ISensorFunction<Integer> iSensorFunction101 = IntSenFunction(2102016);
/*  596 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus98 = iSensorFunction101.sensorType(2); FunctionStatus functionStatus33 = FunctionStatus.active;
/*  597 */     ISensorFunction.ISensorValue<Integer> iSensorValue83 = iSensorStatus98.fixStatus(functionStatus33);
/*  598 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd24 = iSensorValue83.useSigOrPaToValue(pairs30, 31274); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q44 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  599 */     iSensorEnd24.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q44);
/*      */ 
/*      */     
/*  602 */     Pairs<Integer, Integer> pairs29 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2102273));
/*      */     
/*  604 */     pairs29 = pairs29.add(Integer.valueOf(1), Integer.valueOf(2102275));
/*  605 */     pairs29 = pairs29.add(Integer.valueOf(2), Integer.valueOf(2102274));
/*  606 */     pairs29 = pairs29.add(Integer.valueOf(3), Integer.valueOf(2102276));
/*  607 */     pairs29 = pairs29.add(Integer.valueOf(5), Integer.valueOf(2102277));
/*  608 */     ISensorFunction<Integer> iSensorFunction100 = IntSenFunction(2102272);
/*  609 */     iSensorStatus98 = iSensorFunction100.sensorType(2); FunctionStatus functionStatus32 = FunctionStatus.active;
/*  610 */     ISensorFunction.ISensorValue<Integer> iSensorValue82 = iSensorStatus98.fixStatus(functionStatus32);
/*  611 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd23 = iSensorValue82.useSigOrPaToValue(pairs29, 30779); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q43 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  612 */     iSensorEnd23.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q43);
/*      */ 
/*      */     
/*  615 */     Pairs<Integer, Integer> pairs28 = Pairs.of(Integer.valueOf(7), Integer.valueOf(-1));
/*      */     
/*  617 */     pairs28 = pairs28.add(Integer.valueOf(0), Integer.valueOf(2105601));
/*  618 */     pairs28 = pairs28.add(Integer.valueOf(1), Integer.valueOf(2105606));
/*  619 */     pairs28 = pairs28.add(Integer.valueOf(2), Integer.valueOf(2105602));
/*  620 */     pairs28 = pairs28.add(Integer.valueOf(3), Integer.valueOf(2105603));
/*  621 */     pairs28 = pairs28.add(Integer.valueOf(4), Integer.valueOf(2105604));
/*  622 */     pairs28 = pairs28.add(Integer.valueOf(5), Integer.valueOf(2105605));
/*  623 */     ISensorFunction<Integer> iSensorFunction99 = IntSenFunction(2105600);
/*  624 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus67 = iSensorFunction99.sensorType(2); FunctionStatus functionStatus47 = FunctionStatus.active;
/*  625 */     ISensorFunction.ISensorValue<Integer> iSensorValue81 = iSensorStatus67.fixStatus(functionStatus47);
/*  626 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd104 = iSensorValue81.useSigOrPaToValue(pairs28, 33401); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q42 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  628 */     iSensorEnd104.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q42);
/*      */ 
/*      */     
/*  631 */     ISensorFunction<Integer> iSensorFunction98 = IntSenFunction(2105856);
/*  632 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus66 = iSensorFunction98.sensorType(2); FunctionStatus functionStatus46 = FunctionStatus.active;
/*  633 */     ISensorFunction.ISensorValue<Integer> iSensorValue80 = iSensorStatus66.fixStatus(functionStatus46);
/*  634 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd22 = iSensorValue80.useSigOrPaToValue(pairs28, 33400); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q41 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  636 */     iSensorEnd22.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q41);
/*      */ 
/*      */     
/*  639 */     Pairs<Integer, Integer> pairs27 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2106113));
/*  640 */     pairs27 = pairs27.add(Integer.valueOf(1), Integer.valueOf(2106114));
/*      */     
/*  642 */     pairs27 = pairs27.add(Integer.valueOf(2), Integer.valueOf(2106115)); pairs27 = pairs27.add(Integer.valueOf(3), Integer.valueOf(2106116));
/*      */     
/*  644 */     ISensorFunction<Integer> iSensorFunction97 = IntSenFunction(2106112);
/*  645 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus65 = iSensorFunction97.sensorType(2);
/*  646 */     ISensorFunction.ISensorValue<Integer> iSensorValue79 = iSensorStatus65.usePAToStatus(33396);
/*  647 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd21 = iSensorValue79.useSigOrPaToValue(pairs27, 33396); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q40 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  648 */     iSensorEnd21.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q40);
/*      */ 
/*      */     
/*  651 */     Pairs<Integer, Integer> pairs26 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2106630));
/*      */     
/*  653 */     pairs26 = pairs26.add(Integer.valueOf(1), Integer.valueOf(2106626));
/*  654 */     pairs26 = pairs26.add(Integer.valueOf(2), Integer.valueOf(2106627));
/*  655 */     pairs26 = pairs26.add(Integer.valueOf(3), Integer.valueOf(2106628));
/*  656 */     ISensorFunction<Integer> iSensorFunction96 = IntSenFunction(2106624);
/*  657 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus64 = iSensorFunction96.sensorType(2); functionStatus46 = FunctionStatus.active;
/*  658 */     ISensorFunction.ISensorValue<Integer> iSensorValue78 = iSensorStatus64.fixStatus(functionStatus46);
/*  659 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd72 = iSensorValue78.useSigOrPaToValue(pairs26, 30449); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q16 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  660 */     iSensorEnd72.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q16);
/*      */ 
/*      */     
/*  663 */     Pairs<Integer, Integer> pairs25 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2106881));
/*      */     
/*  665 */     pairs25 = pairs25.add(Integer.valueOf(1), Integer.valueOf(2106882));
/*  666 */     pairs25 = pairs25.add(Integer.valueOf(2), Integer.valueOf(2106884));
/*  667 */     pairs25 = pairs25.add(Integer.valueOf(3), Integer.valueOf(2106883));
/*  668 */     ISensorFunction<Integer> iSensorFunction95 = IntSenFunction(2106880);
/*  669 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus63 = iSensorFunction95.sensorType(2);
/*  670 */     ISensorFunction.ISensorValue<Integer> iSensorValue77 = iSensorStatus63.usePAToStatus(33404);
/*  671 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd103 = iSensorValue77.useSigOrPaToValue(pairs25, 33404); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q39 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  673 */     iSensorEnd103.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q39);
/*      */ 
/*      */     
/*  676 */     ISensorFunction<Integer> iSensorFunction94 = IntSenFunction(2107136);
/*  677 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus97 = iSensorFunction94.sensorType(2); FunctionStatus functionStatus31 = FunctionStatus.active;
/*  678 */     ISensorFunction.ISensorValue<Integer> iSensorValue76 = iSensorStatus97.fixStatus(functionStatus31);
/*  679 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd71 = iSensorValue76.useSigOrPaToValue(pairs25, 33403); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q15 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  681 */     iSensorEnd71.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q15);
/*      */ 
/*      */     
/*  684 */     Pairs<Integer, Integer> pairs24 = Pairs.of(Integer.valueOf(0), Integer.valueOf(2110209));
/*      */     
/*  686 */     pairs24 = pairs24.add(Integer.valueOf(1), Integer.valueOf(2110210));
/*  687 */     pairs24 = pairs24.add(Integer.valueOf(2), Integer.valueOf(2110210));
/*  688 */     pairs24 = pairs24.add(Integer.valueOf(3), Integer.valueOf(-1));
/*  689 */     ISensorFunction<Integer> iSensorFunction93 = IntSenFunction(2110464);
/*  690 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus62 = iSensorFunction93.sensorType(2); FunctionStatus functionStatus45 = FunctionStatus.active;
/*  691 */     ISensorFunction.ISensorValue<Integer> iSensorValue75 = iSensorStatus62.fixStatus(functionStatus45);
/*  692 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd70 = iSensorValue75.useSigOrPaToValue(pairs24, 31265); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q14 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  693 */     iSensorEnd70.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q14);
/*      */ 
/*      */     
/*  696 */     Pairs<Integer, Integer> pairs23 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3145728));
/*  697 */     pairs23 = pairs23.add(Integer.valueOf(1), Integer.valueOf(3145729));
/*  698 */     ISensorFunction<Integer> iSensorFunction92 = IntSenFunction(3145984);
/*  699 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus61 = iSensorFunction92.sensorType(2); functionStatus45 = FunctionStatus.active;
/*  700 */     ISensorFunction.ISensorValue<Integer> iSensorValue74 = iSensorStatus61.fixStatus(functionStatus45);
/*  701 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd69 = iSensorValue74.useSigOrPaToValue(pairs23, 30915); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q13 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  702 */     iSensorEnd69.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q13);
/*      */ 
/*      */     
/*  705 */     Pairs<Integer, Integer> pairs22 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3145728));
/*      */     
/*  707 */     pairs22 = pairs22.add(Integer.valueOf(1), Integer.valueOf(3145729));
/*  708 */     ISensorFunction<Integer> iSensorFunction91 = IntSenFunction(3146496);
/*  709 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus96 = iSensorFunction91.sensorType(2); FunctionStatus functionStatus30 = FunctionStatus.active;
/*  710 */     ISensorFunction.ISensorValue<Integer> iSensorValue73 = iSensorStatus96.fixStatus(functionStatus30);
/*  711 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd68 = iSensorValue73.useSigOrPaToValue(pairs22, 31414); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q12 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  712 */     iSensorEnd68.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q12);
/*      */ 
/*      */     
/*  715 */     Pairs<Integer, Integer> pairs21 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3145728));
/*      */     
/*  717 */     pairs21 = pairs21.add(Integer.valueOf(1), Integer.valueOf(3145730));
/*  718 */     pairs21 = pairs21.add(Integer.valueOf(4), Integer.valueOf(3145730));
/*  719 */     pairs21 = pairs21.add(Integer.valueOf(2), Integer.valueOf(3145731));
/*  720 */     pairs21 = pairs21.add(Integer.valueOf(3), Integer.valueOf(3145731));
/*  721 */     pairs21 = pairs21.orDefault(Integer.valueOf(3145728));
/*  722 */     ISensorFunction<Integer> iSensorFunction90 = IntSenFunction(3146752);
/*  723 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus60 = iSensorFunction90.sensorType(2); FunctionStatus functionStatus44 = FunctionStatus.active;
/*  724 */     ISensorFunction.ISensorValue<Integer> iSensorValue72 = iSensorStatus60.fixStatus(functionStatus44);
/*  725 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd67 = iSensorValue72.useSigOrPaToValue(pairs21, 31409); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q11 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  726 */     iSensorEnd67.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q11);
/*      */ 
/*      */     
/*  729 */     ISensorFunction<Integer> iSensorFunction18 = IntSenFunction(3147008);
/*  730 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus59 = iSensorFunction18.sensorType(2); FunctionStatus functionStatus9 = FunctionStatus.active;
/*  731 */     ISensorFunction.ISensorValue<Integer> iSensorValue71 = iSensorStatus59.fixStatus(functionStatus9); -$$Lambda$SensorNew$9xR708o1UnGEKVib9B69C6LOs2s -$$Lambda$SensorNew$9xR708o1UnGEKVib9B69C6LOs2s = new -$$Lambda$SensorNew$9xR708o1UnGEKVib9B69C6LOs2s(this);
/*  732 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd66 = iSensorValue71.useSigsOrPasToValue(-$$Lambda$SensorNew$9xR708o1UnGEKVib9B69C6LOs2s, new int[] { 30984, 30978 }); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q10 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  751 */     iSensorEnd66.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q10);
/*      */ 
/*      */     
/*  754 */     Pairs<Integer, Integer> pairs20 = Pairs.of(Integer.valueOf(1), Integer.valueOf(3148289));
/*      */     
/*  756 */     pairs20 = pairs20.add(Integer.valueOf(2), Integer.valueOf(3148290));
/*  757 */     pairs20 = pairs20.add(Integer.valueOf(3), Integer.valueOf(3148291));
/*  758 */     pairs20 = pairs20.orDefault(Integer.valueOf(3148288));
/*  759 */     ISensorFunction<Integer> iSensorFunction89 = IntSenFunction(3148288);
/*  760 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus58 = iSensorFunction89.sensorType(2); functionStatus44 = FunctionStatus.active;
/*  761 */     ISensorFunction.ISensorValue<Integer> iSensorValue70 = iSensorStatus58.fixStatus(functionStatus44);
/*  762 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd65 = iSensorValue70.useSigOrPaToValue(pairs20, 31577); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q9 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  763 */     iSensorEnd65.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q9);
/*      */ 
/*      */     
/*  766 */     Pairs<Integer, Integer> pairs19 = Pairs.of(Integer.valueOf(1), Integer.valueOf(3148545));
/*      */     
/*  768 */     pairs19 = pairs19.add(Integer.valueOf(0), Integer.valueOf(3148546));
/*  769 */     ISensorFunction<Integer> iSensorFunction88 = IntSenFunction(3148544);
/*  770 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus57 = iSensorFunction88.sensorType(2); functionStatus44 = FunctionStatus.active;
/*  771 */     ISensorFunction.ISensorValue<Integer> iSensorValue69 = iSensorStatus57.fixStatus(functionStatus44);
/*  772 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd20 = iSensorValue69.useSigOrPaToValue(pairs19, 30922); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q38 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  773 */     iSensorEnd20.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q38);
/*      */ 
/*      */     
/*  776 */     Pairs<Integer, Integer> pairs18 = Pairs.of(Integer.valueOf(0), Integer.valueOf(5245185));
/*      */     
/*  778 */     pairs18 = pairs18.add(Integer.valueOf(1), Integer.valueOf(5245187));
/*  779 */     pairs18 = pairs18.add(Integer.valueOf(2), Integer.valueOf(5245189));
/*  780 */     ISensorFunction<Integer> iSensorFunction87 = IntSenFunction(5245184);
/*  781 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus95 = iSensorFunction87.sensorType(2); -$$Lambda$SensorNew$l2DaOFURySuZ42wN_rinnYVA49o -$$Lambda$SensorNew$l2DaOFURySuZ42wN_rinnYVA49o = new -$$Lambda$SensorNew$l2DaOFURySuZ42wN_rinnYVA49o(this);
/*  782 */     ISensorFunction.ISensorValue<Integer> iSensorValue68 = iSensorStatus95.useSigsToStatus(-$$Lambda$SensorNew$l2DaOFURySuZ42wN_rinnYVA49o, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  785 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd102 = iSensorValue68.useSigOrPaToValue(pairs18, 30615); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q37 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  787 */     iSensorEnd102.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q37);
/*      */ 
/*      */     
/*  790 */     ISensorFunction<Integer> iSensorFunction86 = IntSenFunction(5245440);
/*  791 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus56 = iSensorFunction86.sensorType(2); -$$Lambda$SensorNew$i12MDATzP9dw0Lt8w-CM3F4fiUU -$$Lambda$SensorNew$i12MDATzP9dw0Lt8w-CM3F4fiUU = new -$$Lambda$SensorNew$i12MDATzP9dw0Lt8w-CM3F4fiUU(this);
/*  792 */     ISensorFunction.ISensorValue<Integer> iSensorValue67 = iSensorStatus56.useSigsToStatus(-$$Lambda$SensorNew$i12MDATzP9dw0Lt8w-CM3F4fiUU, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  795 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd101 = iSensorValue67.useSigOrPaToValue(pairs18, 30697); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q36 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  797 */     iSensorEnd101.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q36);
/*      */ 
/*      */     
/*  800 */     ISensorFunction<Integer> iSensorFunction85 = IntSenFunction(5245696);
/*  801 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus94 = iSensorFunction85.sensorType(2); -$$Lambda$SensorNew$6S9ObQRiUP8wa8azkuwgpzRQpOU -$$Lambda$SensorNew$6S9ObQRiUP8wa8azkuwgpzRQpOU = new -$$Lambda$SensorNew$6S9ObQRiUP8wa8azkuwgpzRQpOU(this);
/*  802 */     ISensorFunction.ISensorValue<Integer> iSensorValue66 = iSensorStatus94.useSigsToStatus(-$$Lambda$SensorNew$6S9ObQRiUP8wa8azkuwgpzRQpOU, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  805 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd100 = iSensorValue66.useSigOrPaToValue(pairs18, 30624); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q35 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  806 */     iSensorEnd100.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q35);
/*      */ 
/*      */     
/*  809 */     ISensorFunction<Integer> iSensorFunction84 = IntSenFunction(5245952);
/*  810 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus55 = iSensorFunction84.sensorType(2); -$$Lambda$SensorNew$n4svft3qVn0rBKOK9f3Y0-Bo834 -$$Lambda$SensorNew$n4svft3qVn0rBKOK9f3Y0-Bo834 = new -$$Lambda$SensorNew$n4svft3qVn0rBKOK9f3Y0-Bo834(this);
/*  811 */     ISensorFunction.ISensorValue<Integer> iSensorValue65 = iSensorStatus55.useSigsToStatus(-$$Lambda$SensorNew$n4svft3qVn0rBKOK9f3Y0-Bo834, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  814 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd64 = iSensorValue65.useSigOrPaToValue(pairs18, 30706); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q8 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  815 */     iSensorEnd64.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q8);
/*      */ 
/*      */     
/*  818 */     Pairs<Integer, Integer> pairs17 = Pairs.of(Integer.valueOf(0), Integer.valueOf(5245185));
/*      */     
/*  820 */     pairs17 = pairs17.add(Integer.valueOf(1), Integer.valueOf(5245187));
/*  821 */     ISensorFunction<Integer> iSensorFunction83 = IntSenFunction(5246208);
/*  822 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus54 = iSensorFunction83.sensorType(2); -$$Lambda$SensorNew$dhh7o6kYTInIGKYI2-t7XQi4Nj4 -$$Lambda$SensorNew$dhh7o6kYTInIGKYI2-t7XQi4Nj4 = new -$$Lambda$SensorNew$dhh7o6kYTInIGKYI2-t7XQi4Nj4(this);
/*  823 */     ISensorFunction.ISensorValue<Integer> iSensorValue64 = iSensorStatus54.useSigsToStatus(-$$Lambda$SensorNew$dhh7o6kYTInIGKYI2-t7XQi4Nj4, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  826 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd99 = iSensorValue64.useSigOrPaToValue(pairs17, 30618); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q34 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  828 */     iSensorEnd99.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q34);
/*      */ 
/*      */     
/*  831 */     ISensorFunction<Integer> iSensorFunction82 = IntSenFunction(5246464);
/*  832 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus53 = iSensorFunction82.sensorType(2); -$$Lambda$SensorNew$5RGscXw0aGpS3A3xDLwDQ7LNQtw -$$Lambda$SensorNew$5RGscXw0aGpS3A3xDLwDQ7LNQtw = new -$$Lambda$SensorNew$5RGscXw0aGpS3A3xDLwDQ7LNQtw(this);
/*  833 */     ISensorFunction.ISensorValue<Integer> iSensorValue63 = iSensorStatus53.useSigsToStatus(-$$Lambda$SensorNew$5RGscXw0aGpS3A3xDLwDQ7LNQtw, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  836 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd63 = iSensorValue63.useSigOrPaToValue(pairs17, 30700); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q51 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  838 */     iSensorEnd63.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q51);
/*      */ 
/*      */     
/*  841 */     ISensorFunction<Integer> iSensorFunction81 = IntSenFunction(5246720);
/*  842 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus93 = iSensorFunction81.sensorType(2); -$$Lambda$SensorNew$UQpAISCaLBRBKsuRZHzv4TBKBko -$$Lambda$SensorNew$UQpAISCaLBRBKsuRZHzv4TBKBko = new -$$Lambda$SensorNew$UQpAISCaLBRBKsuRZHzv4TBKBko(this);
/*  843 */     ISensorFunction.ISensorValue<Integer> iSensorValue62 = iSensorStatus93.useSigsToStatus(-$$Lambda$SensorNew$UQpAISCaLBRBKsuRZHzv4TBKBko, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  846 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd62 = iSensorValue62.useSigOrPaToValue(pairs17, 30627); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q50 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  847 */     iSensorEnd62.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q50);
/*      */ 
/*      */     
/*  850 */     ISensorFunction<Integer> iSensorFunction80 = IntSenFunction(5246976);
/*  851 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus52 = iSensorFunction80.sensorType(2); -$$Lambda$SensorNew$kM1zmbw_l7hEkUywK12zRjZfrZE -$$Lambda$SensorNew$kM1zmbw_l7hEkUywK12zRjZfrZE = new -$$Lambda$SensorNew$kM1zmbw_l7hEkUywK12zRjZfrZE(this);
/*  852 */     ISensorFunction.ISensorValue<Integer> iSensorValue61 = iSensorStatus52.useSigsToStatus(-$$Lambda$SensorNew$kM1zmbw_l7hEkUywK12zRjZfrZE, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  855 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd19 = iSensorValue61.useSigOrPaToValue(pairs17, 30709); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q33 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  856 */     iSensorEnd19.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q33);
/*      */ 
/*      */     
/*  859 */     Pairs<Integer, Integer> pairs16 = Pairs.of(Integer.valueOf(0), Integer.valueOf(5247233));
/*      */     
/*  861 */     pairs16 = pairs16.add(Integer.valueOf(1), Integer.valueOf(5247234));
/*  862 */     ISensorFunction<Integer> iSensorFunction79 = IntSenFunction(5247232);
/*  863 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus51 = iSensorFunction79.sensorType(2); -$$Lambda$SensorNew$mQ3QhqWFoiyiX5IgQJW52mmZ3AM -$$Lambda$SensorNew$mQ3QhqWFoiyiX5IgQJW52mmZ3AM = new -$$Lambda$SensorNew$mQ3QhqWFoiyiX5IgQJW52mmZ3AM(this);
/*  864 */     ISensorFunction.ISensorValue<Integer> iSensorValue60 = iSensorStatus51.useSigsToStatus(-$$Lambda$SensorNew$mQ3QhqWFoiyiX5IgQJW52mmZ3AM, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  867 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd98 = iSensorValue60.useSigOrPaToValue(pairs16, 30612); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q32 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  869 */     iSensorEnd98.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q32);
/*      */ 
/*      */     
/*  872 */     ISensorFunction<Integer> iSensorFunction78 = IntSenFunction(5247488);
/*  873 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus50 = iSensorFunction78.sensorType(2); -$$Lambda$SensorNew$4p_JlPVaSa9NWVcipOsPBykPyb0 -$$Lambda$SensorNew$4p_JlPVaSa9NWVcipOsPBykPyb0 = new -$$Lambda$SensorNew$4p_JlPVaSa9NWVcipOsPBykPyb0(this);
/*  874 */     ISensorFunction.ISensorValue<Integer> iSensorValue59 = iSensorStatus50.useSigsToStatus(-$$Lambda$SensorNew$4p_JlPVaSa9NWVcipOsPBykPyb0, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  877 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd61 = iSensorValue59.useSigOrPaToValue(pairs16, 30694); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q49 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  879 */     iSensorEnd61.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q49);
/*      */ 
/*      */     
/*  882 */     ISensorFunction<Integer> iSensorFunction77 = IntSenFunction(5247744);
/*  883 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus92 = iSensorFunction77.sensorType(2); -$$Lambda$SensorNew$PnfgNvZOu-5GeMBp219DsHUXt1s -$$Lambda$SensorNew$PnfgNvZOu-5GeMBp219DsHUXt1s = new -$$Lambda$SensorNew$PnfgNvZOu-5GeMBp219DsHUXt1s(this);
/*  884 */     ISensorFunction.ISensorValue<Integer> iSensorValue58 = iSensorStatus92.useSigsToStatus(-$$Lambda$SensorNew$PnfgNvZOu-5GeMBp219DsHUXt1s, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  887 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd97 = iSensorValue58.useSigOrPaToValue(pairs16, 30621); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q31 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  889 */     iSensorEnd97.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q31);
/*      */ 
/*      */     
/*  892 */     ISensorFunction<Integer> iSensorFunction76 = IntSenFunction(5248000);
/*  893 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus49 = iSensorFunction76.sensorType(2); -$$Lambda$SensorNew$eeAko0UK8v7CHVGS-1i_M_7rLQw -$$Lambda$SensorNew$eeAko0UK8v7CHVGS-1i_M_7rLQw = new -$$Lambda$SensorNew$eeAko0UK8v7CHVGS-1i_M_7rLQw(this);
/*  894 */     ISensorFunction.ISensorValue<Integer> iSensorValue57 = iSensorStatus49.useSigsToStatus(-$$Lambda$SensorNew$eeAko0UK8v7CHVGS-1i_M_7rLQw, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  897 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd18 = iSensorValue57.useSigOrPaToValue(pairs16, 30703); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q30 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  899 */     iSensorEnd18.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q30);
/*      */ 
/*      */     
/*  902 */     Pairs<Integer, Integer> pairs15 = Pairs.of(Integer.valueOf(1), Integer.valueOf(5248261));
/*      */     
/*  904 */     pairs15 = pairs15.add(Integer.valueOf(0), Integer.valueOf(-1));
/*  905 */     ISensorFunction<Integer> iSensorFunction75 = IntSenFunction(5248256);
/*  906 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus91 = iSensorFunction75.sensorType(2); -$$Lambda$SensorNew$BwY2ibRxN8LBJnUe6m5WWJBZYbo -$$Lambda$SensorNew$BwY2ibRxN8LBJnUe6m5WWJBZYbo = new -$$Lambda$SensorNew$BwY2ibRxN8LBJnUe6m5WWJBZYbo(this);
/*  907 */     ISensorFunction.ISensorValue<Integer> iSensorValue56 = iSensorStatus91.useSigsToStatus(-$$Lambda$SensorNew$BwY2ibRxN8LBJnUe6m5WWJBZYbo, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  910 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd96 = iSensorValue56.useSigOrPaToValue(pairs15, 30611); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q29 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  912 */     iSensorEnd96.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q29);
/*      */ 
/*      */     
/*  915 */     ISensorFunction<Integer> iSensorFunction74 = IntSenFunction(5248512);
/*  916 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus48 = iSensorFunction74.sensorType(2); -$$Lambda$SensorNew$L2P69LWjee7zv92br1acEJSS-Oo -$$Lambda$SensorNew$L2P69LWjee7zv92br1acEJSS-Oo = new -$$Lambda$SensorNew$L2P69LWjee7zv92br1acEJSS-Oo(this);
/*  917 */     ISensorFunction.ISensorValue<Integer> iSensorValue55 = iSensorStatus48.useSigsToStatus(-$$Lambda$SensorNew$L2P69LWjee7zv92br1acEJSS-Oo, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  920 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd60 = iSensorValue55.useSigOrPaToValue(pairs15, 30620); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q48 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  921 */     iSensorEnd60.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q48);
/*      */ 
/*      */     
/*  924 */     ISensorFunction<Integer> iSensorFunction73 = IntSenFunction(5248768);
/*  925 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus90 = iSensorFunction73.sensorType(2); -$$Lambda$SensorNew$OCenwtKfTU1_IV5T8d8kE57Bqug -$$Lambda$SensorNew$OCenwtKfTU1_IV5T8d8kE57Bqug = new -$$Lambda$SensorNew$OCenwtKfTU1_IV5T8d8kE57Bqug(this);
/*  926 */     ISensorFunction.ISensorValue<Integer> iSensorValue54 = iSensorStatus90.useSigsToStatus(-$$Lambda$SensorNew$OCenwtKfTU1_IV5T8d8kE57Bqug, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  929 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd95 = iSensorValue54.useSigOrPaToValue(pairs15, 30693); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q28 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */     
/*  931 */     iSensorEnd95.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q28);
/*      */ 
/*      */     
/*  934 */     ISensorFunction<Integer> iSensorFunction72 = IntSenFunction(5249024);
/*  935 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus47 = iSensorFunction72.sensorType(2); -$$Lambda$SensorNew$O06SyDXldFRDtsfFJq0j3Vp0-18 -$$Lambda$SensorNew$O06SyDXldFRDtsfFJq0j3Vp0-18 = new -$$Lambda$SensorNew$O06SyDXldFRDtsfFJq0j3Vp0-18(this);
/*  936 */     ISensorFunction.ISensorValue<Integer> iSensorValue53 = iSensorStatus47.useSigsToStatus(-$$Lambda$SensorNew$O06SyDXldFRDtsfFJq0j3Vp0-18, new int[] { 29341, 30788 });
/*      */ 
/*      */     
/*  939 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd59 = iSensorValue53.useSigOrPaToValue(pairs15, 30702); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q7 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  940 */     iSensorEnd59.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q7);
/*      */ 
/*      */     
/*  943 */     ISensorFunction<Integer> iSensorFunction17 = IntSenFunction(5259264);
/*  944 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus9 = iSensorFunction17.sensorType(2); -$$Lambda$SensorNew$A6wFcHNvR_TwDpo_ka3EtScIeBI -$$Lambda$SensorNew$A6wFcHNvR_TwDpo_ka3EtScIeBI = new -$$Lambda$SensorNew$A6wFcHNvR_TwDpo_ka3EtScIeBI(this);
/*  945 */     ISensorFunction.ISensorValue<Integer> iSensorValue12 = iSensorStatus9.useSigsToStatus(-$$Lambda$SensorNew$A6wFcHNvR_TwDpo_ka3EtScIeBI, new int[] { 29341, 30788 }); -$$Lambda$SensorNew$uvEwpZ52y3NYJDKQy7iO-9uB9FM -$$Lambda$SensorNew$uvEwpZ52y3NYJDKQy7iO-9uB9FM = new -$$Lambda$SensorNew$uvEwpZ52y3NYJDKQy7iO-9uB9FM(this);
/*      */ 
/*      */     
/*  948 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd58 = iSensorValue12.useSigsOrPasToValue(-$$Lambda$SensorNew$uvEwpZ52y3NYJDKQy7iO-9uB9FM, new int[] { 30616, 30625, 30698, 30707 }); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q6 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  953 */     iSensorEnd58.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q6);
/*      */ 
/*      */     
/*  956 */     Pairs<Integer, Integer> pairs14 = Pairs.of(Integer.valueOf(9), Integer.valueOf(3145729));
/*  957 */     pairs14 = pairs14.orDefault(Integer.valueOf(3145728));
/*  958 */     ISensorFunction<Integer> iSensorFunction71 = IntSenFunction(3148032);
/*  959 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus46 = iSensorFunction71.sensorType(2); FunctionStatus functionStatus43 = FunctionStatus.active;
/*  960 */     ISensorFunction.ISensorValue<Integer> iSensorValue52 = iSensorStatus46.fixStatus(functionStatus43);
/*  961 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd17 = iSensorValue52.useSigOrPaToValue(pairs14, 31409); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q27 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  962 */     iSensorEnd17.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q27);
/*      */ 
/*      */     
/*  965 */     Pairs<Integer, Integer> pairs13 = Pairs.of(Integer.valueOf(5), Integer.valueOf(2098435));
/*      */     
/*  967 */     pairs13 = pairs13.add(Integer.valueOf(6), Integer.valueOf(2098435));
/*  968 */     pairs13 = pairs13.add(Integer.valueOf(7), Integer.valueOf(2098434));
/*  969 */     pairs13 = pairs13.add(Integer.valueOf(8), Integer.valueOf(2098434));
/*  970 */     pairs13 = pairs13.add(Integer.valueOf(9), Integer.valueOf(2098434));
/*  971 */     pairs13 = pairs13.orDefault(Integer.valueOf(2098433));
/*  972 */     ISensorFunction<Integer> iSensorFunction70 = IntSenFunction(2098432);
/*  973 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus89 = iSensorFunction70.sensorType(2); FunctionStatus functionStatus29 = FunctionStatus.active;
/*  974 */     ISensorFunction.ISensorValue<Integer> iSensorValue51 = iSensorStatus89.fixStatus(functionStatus29);
/*  975 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd57 = iSensorValue51.useSigOrPaToValue(pairs13, 31409); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q5 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*  976 */     iSensorEnd57.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q5);
/*      */ 
/*      */     
/*  979 */     ISensorFunction<Integer> iSensorFunction16 = IntSenFunction(3147264);
/*  980 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus45 = iSensorFunction16.sensorType(2); FunctionStatus functionStatus8 = FunctionStatus.active;
/*  981 */     ISensorFunction.ISensorValue<Integer> iSensorValue11 = iSensorStatus45.fixStatus(functionStatus8); -$$Lambda$SensorNew$gbVMXrndaNQEeXxj9x6rEF7MKno -$$Lambda$SensorNew$gbVMXrndaNQEeXxj9x6rEF7MKno = new -$$Lambda$SensorNew$gbVMXrndaNQEeXxj9x6rEF7MKno(this);
/*  982 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd16 = iSensorValue11.useSigsOrPasToValue(-$$Lambda$SensorNew$gbVMXrndaNQEeXxj9x6rEF7MKno, new int[] { 30978, 30979, 30980, 30981, 30984, 30985 }); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q26 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  989 */     iSensorEnd16.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q26);
/*      */ 
/*      */ 
/*      */     
/*  993 */     ISensorFunction<ISensorGroupValue> iSensorFunction15 = GroupSenFunction(8389120);
/*  994 */     ISensorFunction.ISensorStatus<ISensorGroupValue> iSensorStatus44 = iSensorFunction15.sensorType(3); FunctionStatus functionStatus7 = FunctionStatus.active;
/*  995 */     ISensorFunction.ISensorValue<ISensorGroupValue> iSensorValue50 = iSensorStatus44.fixStatus(functionStatus7); -$$Lambda$SensorNew$VfobhqMou4KrzBS8DKxJDQnm3lk -$$Lambda$SensorNew$VfobhqMou4KrzBS8DKxJDQnm3lk = new -$$Lambda$SensorNew$VfobhqMou4KrzBS8DKxJDQnm3lk(this);
/*  996 */     ISensorFunction.ISensorEnd<ISensorGroupValue> iSensorEnd56 = iSensorValue50.useSigsOrPasToValue(-$$Lambda$SensorNew$VfobhqMou4KrzBS8DKxJDQnm3lk, new int[0]); -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak2 = new -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak(this);
/*      */ 
/*      */ 
/*      */     
/* 1000 */     iSensorEnd56.addTo(-$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak2);
/*      */     
/* 1002 */     ISensorFunction<ISensorGroupValue> iSensorFunction14 = GroupSenFunction(8388864);
/* 1003 */     ISensorFunction.ISensorStatus<ISensorGroupValue> iSensorStatus43 = iSensorFunction14.sensorType(3); FunctionStatus functionStatus6 = FunctionStatus.active;
/* 1004 */     ISensorFunction.ISensorValue<ISensorGroupValue> iSensorValue10 = iSensorStatus43.fixStatus(functionStatus6); -$$Lambda$SensorNew$90DgSbXlvj4IrVWIUw3WBXbc6xM -$$Lambda$SensorNew$90DgSbXlvj4IrVWIUw3WBXbc6xM = new -$$Lambda$SensorNew$90DgSbXlvj4IrVWIUw3WBXbc6xM(this);
/* 1005 */     ISensorFunction.ISensorEnd<ISensorGroupValue> iSensorEnd15 = iSensorValue10.useSigsOrPasToValue(-$$Lambda$SensorNew$90DgSbXlvj4IrVWIUw3WBXbc6xM, new int[0]); -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak4 = new -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak(this);
/*      */ 
/*      */ 
/*      */     
/* 1009 */     iSensorEnd15.addTo(-$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak4);
/*      */     
/* 1011 */     ISensorFunction<ISensorGroupValue> iSensorFunction13 = GroupSenFunction(8389376);
/* 1012 */     ISensorFunction.ISensorStatus<ISensorGroupValue> iSensorStatus8 = iSensorFunction13.sensorType(3); FunctionStatus functionStatus28 = FunctionStatus.active;
/* 1013 */     ISensorFunction.ISensorValue<ISensorGroupValue> iSensorValue9 = iSensorStatus8.fixStatus(functionStatus28); -$$Lambda$SensorNew$VEoi0tRA1AYKQE8TJBnAiLRsuRE -$$Lambda$SensorNew$VEoi0tRA1AYKQE8TJBnAiLRsuRE = new -$$Lambda$SensorNew$VEoi0tRA1AYKQE8TJBnAiLRsuRE(this);
/* 1014 */     ISensorFunction.ISensorEnd<ISensorGroupValue> iSensorEnd14 = iSensorValue9.useSigsOrPasToValue(-$$Lambda$SensorNew$VEoi0tRA1AYKQE8TJBnAiLRsuRE, new int[] { 31578, 31492 }); -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak3 = new -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1034 */     iSensorEnd14.addTo(-$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak3);
/*      */     
/* 1036 */     ISensorFunction<ISensorGroupValue> iSensorFunction12 = GroupSenFunction(8389632);
/* 1037 */     ISensorFunction.ISensorStatus<ISensorGroupValue> iSensorStatus7 = iSensorFunction12.sensorType(3); FunctionStatus functionStatus27 = FunctionStatus.active;
/* 1038 */     ISensorFunction.ISensorValue<ISensorGroupValue> iSensorValue49 = iSensorStatus7.fixStatus(functionStatus27); -$$Lambda$SensorNew$zf6GpYtlxvfpaofIJAn1b619P6I -$$Lambda$SensorNew$zf6GpYtlxvfpaofIJAn1b619P6I = new -$$Lambda$SensorNew$zf6GpYtlxvfpaofIJAn1b619P6I(this);
/* 1039 */     ISensorFunction.ISensorEnd<ISensorGroupValue> iSensorEnd55 = iSensorValue49.useSigsOrPasToValue(-$$Lambda$SensorNew$zf6GpYtlxvfpaofIJAn1b619P6I, new int[] { 31608, 31610, 31602, 31605, 31492, 31549 }); -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak1 = new -$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1074 */     iSensorEnd55.addTo(-$$Lambda$d4vhR0sRUyxruDRGDj-jEc7LUak1);
/*      */ 
/*      */     
/* 1077 */     Pairs<Integer, Integer> pairs12 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3149824));
/* 1078 */     pairs12 = pairs12.add(Integer.valueOf(1), Integer.valueOf(3149825));
/* 1079 */     pairs12 = pairs12.add(Integer.valueOf(2), Integer.valueOf(3149826));
/* 1080 */     pairs12 = pairs12.add(Integer.valueOf(3), Integer.valueOf(3149827));
/* 1081 */     pairs12 = pairs12.add(Integer.valueOf(4), Integer.valueOf(3149828));
/* 1082 */     pairs12 = pairs12.add(Integer.valueOf(5), Integer.valueOf(3149829));
/* 1083 */     pairs12 = pairs12.add(Integer.valueOf(6), Integer.valueOf(3149830));
/* 1084 */     ISensorFunction<Integer> iSensorFunction69 = IntSenFunction(3149824);
/* 1085 */     iSensorStatus89 = iSensorFunction69.sensorType(2); FunctionStatus functionStatus26 = FunctionStatus.active;
/* 1086 */     ISensorFunction.ISensorValue<Integer> iSensorValue48 = iSensorStatus89.fixStatus(functionStatus26);
/* 1087 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd13 = iSensorValue48.useSigOrPaToValue(pairs12, 28954); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q25 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1088 */     iSensorEnd13.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q25);
/*      */ 
/*      */     
/* 1091 */     ISensorFunction<Float> iSensorFunction11 = FloatSenFunction(1057792);
/* 1092 */     ISensorFunction.ISensorStatus<Float> iSensorStatus6 = iSensorFunction11.sensorType(1); FunctionStatus functionStatus25 = FunctionStatus.active;
/* 1093 */     ISensorFunction.ISensorValue<Float> iSensorValue8 = iSensorStatus6.fixStatus(functionStatus25); -$$Lambda$SensorNew$UlMRCsi9nFnVesQfICll_RltfTo -$$Lambda$SensorNew$UlMRCsi9nFnVesQfICll_RltfTo = -$$Lambda$SensorNew$UlMRCsi9nFnVesQfICll_RltfTo.INSTANCE;
/* 1094 */     ISensorFunction.ISensorEnd<Float> iSensorEnd54 = iSensorValue8.useSigOrPaToValue(30557, -$$Lambda$SensorNew$UlMRCsi9nFnVesQfICll_RltfTo); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng6 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1095 */     iSensorEnd54.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng6);
/*      */ 
/*      */     
/* 1098 */     ISensorFunction<Float> iSensorFunction10 = FloatSenFunction(1058048);
/* 1099 */     ISensorFunction.ISensorStatus<Float> iSensorStatus42 = iSensorFunction10.sensorType(1); FunctionStatus functionStatus5 = FunctionStatus.active;
/* 1100 */     ISensorFunction.ISensorValue<Float> iSensorValue7 = iSensorStatus42.fixStatus(functionStatus5); -$$Lambda$SensorNew$cCbu1d66xQHybNJBIVKdyxx5VlU -$$Lambda$SensorNew$cCbu1d66xQHybNJBIVKdyxx5VlU = -$$Lambda$SensorNew$cCbu1d66xQHybNJBIVKdyxx5VlU.INSTANCE;
/* 1101 */     ISensorFunction.ISensorEnd<Float> iSensorEnd12 = iSensorValue7.useSigOrPaToValue(30559, -$$Lambda$SensorNew$cCbu1d66xQHybNJBIVKdyxx5VlU); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng31 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1102 */     iSensorEnd12.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng31);
/*      */ 
/*      */     
/* 1105 */     ISensorFunction<Float> iSensorFunction9 = FloatSenFunction(1058304);
/* 1106 */     ISensorFunction.ISensorStatus<Float> iSensorStatus5 = iSensorFunction9.sensorType(1); FunctionStatus functionStatus24 = FunctionStatus.active;
/* 1107 */     ISensorFunction.ISensorValue<Float> iSensorValue6 = iSensorStatus5.fixStatus(functionStatus24); -$$Lambda$SensorNew$0QWGrxlWnmDfPo1Q51d9SqNIO5Y -$$Lambda$SensorNew$0QWGrxlWnmDfPo1Q51d9SqNIO5Y = -$$Lambda$SensorNew$0QWGrxlWnmDfPo1Q51d9SqNIO5Y.INSTANCE;
/* 1108 */     ISensorFunction.ISensorEnd<Float> iSensorEnd53 = iSensorValue6.useSigOrPaToValue(30555, -$$Lambda$SensorNew$0QWGrxlWnmDfPo1Q51d9SqNIO5Y); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng5 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1109 */     iSensorEnd53.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng5);
/*      */ 
/*      */     
/* 1112 */     ISensorFunction<Float> iSensorFunction8 = FloatSenFunction(1058560);
/* 1113 */     ISensorFunction.ISensorStatus<Float> iSensorStatus41 = iSensorFunction8.sensorType(1); FunctionStatus functionStatus4 = FunctionStatus.active;
/* 1114 */     ISensorFunction.ISensorValue<Float> iSensorValue47 = iSensorStatus41.fixStatus(functionStatus4); -$$Lambda$SensorNew$_GYh1d29xt6YsErxbkR3aYBBulk -$$Lambda$SensorNew$_GYh1d29xt6YsErxbkR3aYBBulk = -$$Lambda$SensorNew$_GYh1d29xt6YsErxbkR3aYBBulk.INSTANCE;
/* 1115 */     ISensorFunction.ISensorEnd<Float> iSensorEnd52 = iSensorValue47.useSigOrPaToValue(30484, -$$Lambda$SensorNew$_GYh1d29xt6YsErxbkR3aYBBulk); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng4 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1116 */     iSensorEnd52.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng4);
/*      */ 
/*      */     
/* 1119 */     ISensorFunction<Float> iSensorFunction7 = FloatSenFunction(1058816);
/* 1120 */     ISensorFunction.ISensorStatus<Float> iSensorStatus40 = iSensorFunction7.sensorType(1); FunctionStatus functionStatus3 = FunctionStatus.active;
/* 1121 */     ISensorFunction.ISensorValue<Float> iSensorValue46 = iSensorStatus40.fixStatus(functionStatus3); -$$Lambda$SensorNew$U2b4_ZIun1lNVwX-nWBd2euOjwU -$$Lambda$SensorNew$U2b4_ZIun1lNVwX-nWBd2euOjwU = -$$Lambda$SensorNew$U2b4_ZIun1lNVwX-nWBd2euOjwU.INSTANCE;
/* 1122 */     ISensorFunction.ISensorEnd<Float> iSensorEnd11 = iSensorValue46.useSigOrPaToValue(30650, -$$Lambda$SensorNew$U2b4_ZIun1lNVwX-nWBd2euOjwU); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng30 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1123 */     iSensorEnd11.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng30);
/*      */ 
/*      */     
/* 1126 */     ISensorFunction<Float> iSensorFunction6 = FloatSenFunction(1059072);
/* 1127 */     ISensorFunction.ISensorStatus<Float> iSensorStatus4 = iSensorFunction6.sensorType(1); FunctionStatus functionStatus23 = FunctionStatus.active;
/* 1128 */     ISensorFunction.ISensorValue<Float> iSensorValue5 = iSensorStatus4.fixStatus(functionStatus23); -$$Lambda$SensorNew$XxCxrf_e6Ar1tU8hzDTtIoodybM -$$Lambda$SensorNew$XxCxrf_e6Ar1tU8hzDTtIoodybM = -$$Lambda$SensorNew$XxCxrf_e6Ar1tU8hzDTtIoodybM.INSTANCE;
/* 1129 */     ISensorFunction.ISensorEnd<Float> iSensorEnd51 = iSensorValue5.useSigOrPaToValue(30652, -$$Lambda$SensorNew$XxCxrf_e6Ar1tU8hzDTtIoodybM); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng3 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1130 */     iSensorEnd51.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng3);
/*      */ 
/*      */     
/* 1133 */     ISensorFunction<Float> iSensorFunction5 = FloatSenFunction(1059328);
/* 1134 */     ISensorFunction.ISensorStatus<Float> iSensorStatus39 = iSensorFunction5.sensorType(1); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 1135 */     ISensorFunction.ISensorValue<Float> iSensorValue4 = iSensorStatus39.fixStatus(functionStatus2); -$$Lambda$SensorNew$rH7O1XVKhp5Y3Lxtq74r57wdybk -$$Lambda$SensorNew$rH7O1XVKhp5Y3Lxtq74r57wdybk = -$$Lambda$SensorNew$rH7O1XVKhp5Y3Lxtq74r57wdybk.INSTANCE;
/* 1136 */     ISensorFunction.ISensorEnd<Float> iSensorEnd10 = iSensorValue4.useSigOrPaToValue(30648, -$$Lambda$SensorNew$rH7O1XVKhp5Y3Lxtq74r57wdybk); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng29 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1137 */     iSensorEnd10.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng29);
/*      */ 
/*      */     
/* 1140 */     ISensorFunction<Float> iSensorFunction4 = FloatSenFunction(1059584);
/* 1141 */     ISensorFunction.ISensorStatus<Float> iSensorStatus3 = iSensorFunction4.sensorType(1); FunctionStatus functionStatus22 = FunctionStatus.active;
/* 1142 */     ISensorFunction.ISensorValue<Float> iSensorValue3 = iSensorStatus3.fixStatus(functionStatus22); -$$Lambda$SensorNew$EJMbW9twaXB_x1fO5P7lOv9cxXQ -$$Lambda$SensorNew$EJMbW9twaXB_x1fO5P7lOv9cxXQ = -$$Lambda$SensorNew$EJMbW9twaXB_x1fO5P7lOv9cxXQ.INSTANCE;
/* 1143 */     ISensorFunction.ISensorEnd<Float> iSensorEnd50 = iSensorValue3.useSigOrPaToValue(30485, -$$Lambda$SensorNew$EJMbW9twaXB_x1fO5P7lOv9cxXQ); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng2 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1144 */     iSensorEnd50.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng2);
/*      */ 
/*      */     
/* 1147 */     ISensorFunction<Float> iSensorFunction3 = FloatSenFunction(1059840);
/* 1148 */     ISensorFunction.ISensorStatus<Float> iSensorStatus2 = iSensorFunction3.sensorType(1); FunctionStatus functionStatus21 = FunctionStatus.active;
/* 1149 */     ISensorFunction.ISensorValue<Float> iSensorValue45 = iSensorStatus2.fixStatus(functionStatus21); -$$Lambda$SensorNew$kbs3GgNXLdNnh1tCtC14l4to-NA -$$Lambda$SensorNew$kbs3GgNXLdNnh1tCtC14l4to-NA = -$$Lambda$SensorNew$kbs3GgNXLdNnh1tCtC14l4to-NA.INSTANCE;
/* 1150 */     ISensorFunction.ISensorEnd<Float> iSensorEnd49 = iSensorValue45.useSigOrPaToValue(31412, -$$Lambda$SensorNew$kbs3GgNXLdNnh1tCtC14l4to-NA); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng1 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1151 */     iSensorEnd49.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng1);
/*      */ 
/*      */     
/* 1154 */     Pairs<Integer, Integer> pairs11 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3153921));
/* 1155 */     pairs11 = pairs11.add(Integer.valueOf(1), Integer.valueOf(3153922));
/* 1156 */     ISensorFunction<Integer> iSensorFunction68 = IntSenFunction(3153920);
/* 1157 */     iSensorStatus89 = iSensorFunction68.sensorType(2); FunctionStatus functionStatus20 = FunctionStatus.active;
/* 1158 */     ISensorFunction.ISensorValue<Integer> iSensorValue44 = iSensorStatus89.fixStatus(functionStatus20);
/* 1159 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd48 = iSensorValue44.useSigOrPaToValue(pairs11, 31472); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q4 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1160 */     iSensorEnd48.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q4);
/*      */ 
/*      */     
/* 1163 */     Pairs<Integer, Integer> pairs10 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3158017));
/* 1164 */     pairs10 = pairs10.add(Integer.valueOf(1), Integer.valueOf(3158018));
/* 1165 */     pairs10 = pairs10.add(Integer.valueOf(2), Integer.valueOf(3158019));
/* 1166 */     pairs10 = pairs10.add(Integer.valueOf(3), Integer.valueOf(3158020));
/* 1167 */     ISensorFunction<Integer> iSensorFunction67 = IntSenFunction(3158016);
/* 1168 */     iSensorStatus89 = iSensorFunction67.sensorType(2); FunctionStatus functionStatus19 = FunctionStatus.active;
/* 1169 */     ISensorFunction.ISensorValue<Integer> iSensorValue43 = iSensorStatus89.fixStatus(functionStatus19);
/* 1170 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd9 = iSensorValue43.useSigOrPaToValue(pairs10, 31471); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q24 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1171 */     iSensorEnd9.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q24);
/*      */ 
/*      */     
/* 1174 */     Pairs<Integer, Integer> pairs9 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3162113));
/* 1175 */     pairs9 = pairs9.add(Integer.valueOf(1), Integer.valueOf(3162114));
/* 1176 */     pairs9 = pairs9.add(Integer.valueOf(2), Integer.valueOf(3162115));
/* 1177 */     pairs9 = pairs9.add(Integer.valueOf(3), Integer.valueOf(3162116));
/* 1178 */     ISensorFunction<Integer> iSensorFunction66 = IntSenFunction(3162112);
/* 1179 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus38 = iSensorFunction66.sensorType(2); FunctionStatus functionStatus42 = FunctionStatus.active;
/* 1180 */     ISensorFunction.ISensorValue<Integer> iSensorValue42 = iSensorStatus38.fixStatus(functionStatus42);
/* 1181 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd47 = iSensorValue42.useSigOrPaToValue(pairs9, 31508); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q3 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1182 */     iSensorEnd47.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q3);
/*      */ 
/*      */     
/* 1185 */     Pairs<Integer, Integer> pairs8 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1186 */     pairs8 = pairs8.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1187 */     ISensorFunction<Integer> iSensorFunction65 = IntSenFunction(3166208);
/* 1188 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus37 = iSensorFunction65.sensorType(2); -$$Lambda$SensorNew$JVbfWzVhO2laJYNv4bfup35nVH0 -$$Lambda$SensorNew$JVbfWzVhO2laJYNv4bfup35nVH0 = new -$$Lambda$SensorNew$JVbfWzVhO2laJYNv4bfup35nVH0(this);
/* 1189 */     ISensorFunction.ISensorValue<Integer> iSensorValue41 = iSensorStatus37.useSigsToStatus(-$$Lambda$SensorNew$JVbfWzVhO2laJYNv4bfup35nVH0, new int[] { 29394 });
/* 1190 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd46 = iSensorValue41.useSigOrPaToValue(pairs8, 28966); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q2 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1191 */     iSensorEnd46.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q2);
/*      */ 
/*      */     
/* 1194 */     Pairs<Integer, Integer> pairs7 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1195 */     pairs7 = pairs7.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1196 */     ISensorFunction<Integer> iSensorFunction64 = IntSenFunction(3170304);
/* 1197 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus88 = iSensorFunction64.sensorType(2); -$$Lambda$SensorNew$w3fQysvciLWwlJgyHgXN8dL7Sy8 -$$Lambda$SensorNew$w3fQysvciLWwlJgyHgXN8dL7Sy8 = new -$$Lambda$SensorNew$w3fQysvciLWwlJgyHgXN8dL7Sy8(this);
/* 1198 */     ISensorFunction.ISensorValue<Integer> iSensorValue40 = iSensorStatus88.useSigsToStatus(-$$Lambda$SensorNew$w3fQysvciLWwlJgyHgXN8dL7Sy8, new int[] { 29394 });
/* 1199 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd8 = iSensorValue40.useSigOrPaToValue(pairs7, 28968); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q23 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1200 */     iSensorEnd8.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q23);
/*      */ 
/*      */     
/* 1203 */     Pairs<Integer, Integer> pairs6 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1204 */     pairs6 = pairs6.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1205 */     ISensorFunction<Integer> iSensorFunction63 = IntSenFunction(3174400);
/* 1206 */     iSensorStatus88 = iSensorFunction63.sensorType(2); -$$Lambda$SensorNew$3rUpSilu_G6q6Ky9HYzg_mA5N20 -$$Lambda$SensorNew$3rUpSilu_G6q6Ky9HYzg_mA5N20 = new -$$Lambda$SensorNew$3rUpSilu_G6q6Ky9HYzg_mA5N20(this);
/* 1207 */     ISensorFunction.ISensorValue<Integer> iSensorValue39 = iSensorStatus88.useSigsToStatus(-$$Lambda$SensorNew$3rUpSilu_G6q6Ky9HYzg_mA5N20, new int[] { 29394 });
/* 1208 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd7 = iSensorValue39.useSigOrPaToValue(pairs6, 28967); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q22 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1209 */     iSensorEnd7.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q22);
/*      */ 
/*      */     
/* 1212 */     Pairs<Integer, Integer> pairs5 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1213 */     pairs5 = pairs5.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1214 */     ISensorFunction<Integer> iSensorFunction62 = IntSenFunction(3178496);
/* 1215 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus36 = iSensorFunction62.sensorType(2); -$$Lambda$SensorNew$eKKdWEgsexgFh4-e2uW9wmNTWq4 -$$Lambda$SensorNew$eKKdWEgsexgFh4-e2uW9wmNTWq4 = new -$$Lambda$SensorNew$eKKdWEgsexgFh4-e2uW9wmNTWq4(this);
/* 1216 */     ISensorFunction.ISensorValue<Integer> iSensorValue38 = iSensorStatus36.useSigsToStatus(-$$Lambda$SensorNew$eKKdWEgsexgFh4-e2uW9wmNTWq4, new int[] { 29394 });
/* 1217 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd6 = iSensorValue38.useSigOrPaToValue(pairs5, 28969); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q21 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1218 */     iSensorEnd6.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q21);
/*      */ 
/*      */     
/* 1221 */     Pairs<Integer, Integer> pairs4 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1222 */     pairs4 = pairs4.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1223 */     ISensorFunction<Integer> iSensorFunction61 = IntSenFunction(3182592);
/* 1224 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus87 = iSensorFunction61.sensorType(2); -$$Lambda$SensorNew$JAyHdwZU94PbtRtOKkEV5XxJ2i4 -$$Lambda$SensorNew$JAyHdwZU94PbtRtOKkEV5XxJ2i4 = new -$$Lambda$SensorNew$JAyHdwZU94PbtRtOKkEV5XxJ2i4(this);
/* 1225 */     ISensorFunction.ISensorValue<Integer> iSensorValue37 = iSensorStatus87.useSigsToStatus(-$$Lambda$SensorNew$JAyHdwZU94PbtRtOKkEV5XxJ2i4, new int[] { 29394 });
/* 1226 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd5 = iSensorValue37.useSigOrPaToValue(pairs4, 29109); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q20 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1227 */     iSensorEnd5.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q20);
/*      */ 
/*      */     
/* 1230 */     Pairs<Integer, Integer> pairs3 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1231 */     pairs3 = pairs3.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1232 */     ISensorFunction<Integer> iSensorFunction60 = IntSenFunction(3186688);
/* 1233 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus35 = iSensorFunction60.sensorType(2); -$$Lambda$SensorNew$Hz8XrNNtC_TRS1Nx75TAWMnrJag -$$Lambda$SensorNew$Hz8XrNNtC_TRS1Nx75TAWMnrJag = new -$$Lambda$SensorNew$Hz8XrNNtC_TRS1Nx75TAWMnrJag(this);
/* 1234 */     ISensorFunction.ISensorValue<Integer> iSensorValue36 = iSensorStatus35.useSigsToStatus(-$$Lambda$SensorNew$Hz8XrNNtC_TRS1Nx75TAWMnrJag, new int[] { 29394 });
/* 1235 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd4 = iSensorValue36.useSigOrPaToValue(pairs3, 29111); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q19 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1236 */     iSensorEnd4.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q19);
/*      */ 
/*      */     
/* 1239 */     Pairs<Integer, Integer> pairs2 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1240 */     pairs2 = pairs2.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1241 */     ISensorFunction<Integer> iSensorFunction59 = IntSenFunction(3190784);
/* 1242 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus86 = iSensorFunction59.sensorType(2); -$$Lambda$SensorNew$3LMgCJYoEjE4KOO_id3lUtc8nAI -$$Lambda$SensorNew$3LMgCJYoEjE4KOO_id3lUtc8nAI = new -$$Lambda$SensorNew$3LMgCJYoEjE4KOO_id3lUtc8nAI(this);
/* 1243 */     ISensorFunction.ISensorValue<Integer> iSensorValue35 = iSensorStatus86.useSigsToStatus(-$$Lambda$SensorNew$3LMgCJYoEjE4KOO_id3lUtc8nAI, new int[] { 29394 });
/* 1244 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd3 = iSensorValue35.useSigOrPaToValue(pairs2, 29110); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q18 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1245 */     iSensorEnd3.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q18);
/*      */ 
/*      */     
/* 1248 */     Pairs<Integer, Integer> pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(3166209));
/* 1249 */     pairs1 = pairs1.add(Integer.valueOf(1), Integer.valueOf(3166210));
/* 1250 */     ISensorFunction<Integer> iSensorFunction58 = IntSenFunction(3194880);
/* 1251 */     ISensorFunction.ISensorStatus<Integer> iSensorStatus34 = iSensorFunction58.sensorType(2); -$$Lambda$SensorNew$ZsiFvlvH-pLLAV7uSP2ipShH8Tk -$$Lambda$SensorNew$ZsiFvlvH-pLLAV7uSP2ipShH8Tk = new -$$Lambda$SensorNew$ZsiFvlvH-pLLAV7uSP2ipShH8Tk(this);
/* 1252 */     ISensorFunction.ISensorValue<Integer> iSensorValue34 = iSensorStatus34.useSigsToStatus(-$$Lambda$SensorNew$ZsiFvlvH-pLLAV7uSP2ipShH8Tk, new int[] { 29394 });
/* 1253 */     ISensorFunction.ISensorEnd<Integer> iSensorEnd45 = iSensorValue34.useSigOrPaToValue(pairs1, 29112); -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q1 = new -$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q(this);
/* 1254 */     iSensorEnd45.addTo(-$$Lambda$APUqAQ9KYy4PKqrx7kxjZ5Vrf7Q1);
/*      */ 
/*      */     
/* 1257 */     ISensorFunction<Float> iSensorFunction2 = FloatSenFunction(1053696);
/* 1258 */     ISensorFunction.ISensorStatus<Float> iSensorStatus1 = iSensorFunction2.sensorType(1); FunctionStatus functionStatus18 = FunctionStatus.active;
/* 1259 */     ISensorFunction.ISensorValue<Float> iSensorValue2 = iSensorStatus1.fixStatus(functionStatus18); -$$Lambda$SensorNew$urNGIIrS1Y7yD0IUtCiNMp6-xf8 -$$Lambda$SensorNew$urNGIIrS1Y7yD0IUtCiNMp6-xf8 = -$$Lambda$SensorNew$urNGIIrS1Y7yD0IUtCiNMp6-xf8.INSTANCE;
/* 1260 */     ISensorFunction.ISensorEnd<Float> iSensorEnd2 = iSensorValue2.useSigOrPaToValue(31468, -$$Lambda$SensorNew$urNGIIrS1Y7yD0IUtCiNMp6-xf8); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng28 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1261 */     iSensorEnd2.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng28);
/*      */ 
/*      */     
/* 1264 */     ISensorFunction<Float> iSensorFunction1 = FloatSenFunction(1053440);
/* 1265 */     ISensorFunction.ISensorStatus<Float> iSensorStatus33 = iSensorFunction1.sensorType(1); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 1266 */     ISensorFunction.ISensorValue<Float> iSensorValue1 = iSensorStatus33.fixStatus(functionStatus1); -$$Lambda$SensorNew$XmJ5oRkNO-8fELUKsKSvT1h6WHY -$$Lambda$SensorNew$XmJ5oRkNO-8fELUKsKSvT1h6WHY = -$$Lambda$SensorNew$XmJ5oRkNO-8fELUKsKSvT1h6WHY.INSTANCE;
/* 1267 */     ISensorFunction.ISensorEnd<Float> iSensorEnd1 = iSensorValue1.useSigOrPaToValue(31484, -$$Lambda$SensorNew$XmJ5oRkNO-8fELUKsKSvT1h6WHY); -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng27 = new -$$Lambda$JyKicxDc78wCSzLwVfUueRebGng(this);
/* 1268 */     iSensorEnd1.addTo(-$$Lambda$JyKicxDc78wCSzLwVfUueRebGng27);
/*      */   }
/*      */   
/*      */   private int getTransMissionSys() {
/* 1272 */     int i, j = 3145728;
/*      */     
/*      */     try {
/* 1275 */       int m = this.mCarSignalManager.getVehNotifAndLedFltStsByte0();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1284 */       int i2 = this.mCarSignalManager.getVehNotifAndLedFltStsByte1();
/* 1285 */       int k = this.mCarSignalManager.getVehNotifAndLedFltStsByte2();
/* 1286 */       i = this.mCarSignalManager.getVehNotifAndLedFltStsByte3();
/*      */ 
/*      */       
/* 1289 */       int n = this.mCarSignalManager.getVehNotifAndLedFltStsByte6();
/* 1290 */       int i1 = this.mCarSignalManager.getVehNotifAndLedFltStsByte7();
/*      */       
/* 1292 */       if (m == 1 && (i2 & 0x20) == 32)
/*      */       
/* 1294 */       { i = 3145730; }
/* 1295 */       else if (m == 1 && (k & 0x8) == 8)
/*      */       
/* 1297 */       { i = 3145730; }
/* 1298 */       else if (m == 1 && (i2 & 0x40) == 64)
/*      */       
/* 1300 */       { i = 3145731; }
/* 1301 */       else if (m == 5 && (n & 0x40) == 64)
/*      */       
/* 1303 */       { i = 3145730; }
/* 1304 */       else if (m == 1 && (i2 & 0x80) == 128)
/*      */       
/* 1306 */       { i = 3145731; }
/* 1307 */       else if (m == 5 && (n & 0x80) == 128)
/*      */       
/* 1309 */       { i = 3145730; }
/* 1310 */       else if (m == 1 && (k & 0x20) == 32)
/*      */       
/* 1312 */       { i = 3145730; }
/* 1313 */       else if (m == 5 && (i1 & 0x1) == 1)
/*      */       
/* 1315 */       { i = 3145730; }
/* 1316 */       else if (m == 5 && (i1 & 0x2) == 2)
/*      */       
/* 1318 */       { i = 3145730; }
/* 1319 */       else if (m == 1 && (k & 0x40) == 64)
/*      */       
/* 1321 */       { i = 3145730; }
/* 1322 */       else if (m == 1 && (k & 0x80) == 128)
/*      */       
/* 1324 */       { i = 3145730; }
/* 1325 */       else if (m == 1 && (i & 0x1) == 1)
/*      */       
/* 1327 */       { i = 3145730; }
/* 1328 */       else if (m == 1 && (i & 0x2) == 2)
/*      */       
/* 1330 */       { i = 3145730; }
/* 1331 */       else if (m == 1 && (k & 0x1) == 1)
/*      */       
/* 1333 */       { i = 3145730; }
/* 1334 */       else if (m == 1 && (i & 0x4) == 4)
/*      */       
/* 1336 */       { i = 3145730; }
/* 1337 */       else if (m == 1 && (k & 0x2) == 2)
/*      */       
/* 1339 */       { i = 3145730; }
/* 1340 */       else { i = j; if (m == 1) { i = j; if ((k & 0x4) == 4)
/*      */           {
/* 1342 */             i = 3145730; }  }  }
/*      */     
/* 1344 */     } catch (Exception exception) {
/* 1345 */       exception.printStackTrace(); i = j;
/*      */     } 
/* 1347 */     return i;
/*      */   }
/*      */   
/*      */   private int getTPMSStatus() {
/* 1351 */     int j = 5259265;
/* 1352 */     ArrayList<Integer> arrayList = new ArrayList();
/*      */     try {
/* 1354 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeFrntTireMsgSysWarnFlg()));
/* 1355 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getLeReTireMsgSysWarnFlg()));
/* 1356 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiFrntTireMsgSysWarnFlg()));
/* 1357 */       arrayList.add(Integer.valueOf(this.mCarSignalManager.getRiReTireMsgSysWarnFlg()));
/* 1358 */     } catch (Exception exception) {
/* 1359 */       exception.printStackTrace();
/*      */     } 
/* 1361 */     int[] arrayOfInt = new int[2]; int i; byte b;
/* 1362 */     for (b = 0, i = 0; i < arrayList.size(); i++) {
/* 1363 */       if (((Integer)arrayList.get(i)).intValue() == 0) {
/* 1364 */         arrayOfInt[0] = arrayOfInt[0] + 1;
/*      */       } else {
/* 1366 */         arrayOfInt[1] = arrayOfInt[1] + 1;
/*      */       } 
/*      */     } 
/* 1369 */     if (arrayOfInt[1] > 1)
/* 1370 */     { i = 5259266; }
/*      */     else { while (true)
/* 1372 */       { i = j; if (b < arrayList.size())
/* 1373 */         { if (((Integer)arrayList.get(b)).intValue() == 1)
/* 1374 */           { switch (b) { default: i = j;
/*      */                 break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 3:
/* 1385 */                 i = 5259270; break;
/*      */               case 2:
/*      */                 i = 5259268; break;
/*      */               case 1:
/*      */                 i = 5259269; break;
/*      */               case 0:
/*      */                 break; }  i = 5259267; break; }  b++; continue; }  break; }  }
/* 1392 */      return i;
/*      */   }
/*      */   
/*      */   private FunctionStatus getTireFunctionStatus() {
/* 1396 */     FunctionStatus functionStatus2 = FunctionStatus.notavailable;
/*      */     
/* 1398 */     FunctionStatus functionStatus1 = functionStatus2; try { if (this.mCarSignalManager.getcarconfig19() > 1) { CarSignalManager carSignalManager = this.mCarSignalManager;
/* 1399 */         functionStatus1 = functionStatus2; if (carSignalManager.getVehModMngtGlbSafe1UsgModSts() == 13)
/*      */         {
/* 1401 */           functionStatus1 = FunctionStatus.active; }  }
/*      */        }
/* 1403 */     catch (Exception exception)
/* 1404 */     { exception.printStackTrace(); functionStatus1 = functionStatus2; }
/*      */     
/* 1406 */     return functionStatus1;
/*      */   }
/*      */   
/*      */   private FunctionStatus getAvmFunctionStatus() {
/* 1410 */     FunctionStatus functionStatus1, functionStatus2 = FunctionStatus.notavailable;
/*      */     
/* 1412 */     try { int i = this.mCarSignalManager.getcarconfig154();
/* 1413 */       if (i != 3 && i != 6 && i != 11 && i != 12 && i != 130 && i != 132) { FunctionStatus functionStatus = functionStatus2; if (i == 134)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1420 */           functionStatus = FunctionStatus.active;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1425 */         return functionStatus; }  functionStatus1 = FunctionStatus.active; } catch (Exception exception) { exception.printStackTrace(); functionStatus1 = functionStatus2; }  return functionStatus1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int getGera() {
/* 1431 */     int j, i = -1;
/* 1432 */     int k = -1;
/*      */     
/* 1434 */     try { j = this.mCarSignalManager.getGearLvrIndcn();
/* 1435 */       i = j; int m = this.mCarSignalManager.getGearIndcnRecGearIndcn();
/*      */ 
/*      */       
/* 1438 */       i = j; j = k; } catch (Exception exception) { exception.printStackTrace(); j = k; }
/* 1439 */      switch (i)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1456 */         i = getManMod(j);
/*      */ 
/*      */         
/* 1459 */         return i;case 4: i = getManMod(j); return i;case 3: i = 2097696; return i;case 2: i = 2097680; return i;case 1: i = 2097728; return i;case 0: break; }  i = 2097712; return i;
/*      */   }
/*      */   
/*      */   private int getManMod(int paramInt) {
/* 1463 */     int i = -1;
/*      */     try {
/* 1465 */       int j = this.mCarSignalManager.getcarconfig10();
/* 1466 */     } catch (Exception exception) {
/* 1467 */       exception.printStackTrace();
/*      */     } 
/*      */     
/* 1470 */     byte b = -1;
/* 1471 */     switch (paramInt) { default: paramInt = b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1515 */         return paramInt;case 15: paramInt = b; if (i == 1) paramInt = 2097728;  return paramInt;case 14: paramInt = b; if (i == 1) paramInt = 2097680;  return paramInt;case 10: paramInt = 2097674; return paramInt;case 9: paramInt = 2097673; return paramInt;case 8: paramInt = 2097672; return paramInt;case 7: paramInt = 2097671; return paramInt;case 6: paramInt = 2097670; return paramInt;case 5: paramInt = 2097669; return paramInt;case 4: paramInt = 2097668; return paramInt;case 3: paramInt = 2097667; return paramInt;case 2: paramInt = 2097666; return paramInt;case 1: break; }  paramInt = 2097665; return paramInt;
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
/*      */   private FunctionStatus getTireTmANDPreStatus(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: getstatic com/ecarx/xui/adaptapi/FunctionStatus.notavailable : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   3: astore_3
/*      */     //   4: aload_3
/*      */     //   5: astore_2
/*      */     //   6: aload_0
/*      */     //   7: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   10: invokevirtual getcarconfig19 : ()I
/*      */     //   13: iconst_1
/*      */     //   14: if_icmple -> 218
/*      */     //   17: aload_0
/*      */     //   18: iconst_1
/*      */     //   19: newarray int
/*      */     //   21: dup
/*      */     //   22: iconst_0
/*      */     //   23: iconst_0
/*      */     //   24: iastore
/*      */     //   25: invokevirtual carModeAnyMatch : ([I)Z
/*      */     //   28: ifeq -> 214
/*      */     //   31: aload_0
/*      */     //   32: iconst_3
/*      */     //   33: newarray int
/*      */     //   35: dup
/*      */     //   36: iconst_0
/*      */     //   37: bipush #13
/*      */     //   39: iastore
/*      */     //   40: dup
/*      */     //   41: iconst_1
/*      */     //   42: iconst_2
/*      */     //   43: iastore
/*      */     //   44: dup
/*      */     //   45: iconst_2
/*      */     //   46: bipush #11
/*      */     //   48: iastore
/*      */     //   49: invokevirtual usageModeAnyMatch : ([I)Z
/*      */     //   52: ifeq -> 214
/*      */     //   55: iload_1
/*      */     //   56: ldc 5243136
/*      */     //   58: if_icmpeq -> 189
/*      */     //   61: iload_1
/*      */     //   62: ldc 5244160
/*      */     //   64: if_icmpne -> 70
/*      */     //   67: goto -> 189
/*      */     //   70: iload_1
/*      */     //   71: ldc 5243392
/*      */     //   73: if_icmpeq -> 164
/*      */     //   76: iload_1
/*      */     //   77: ldc 5244416
/*      */     //   79: if_icmpne -> 85
/*      */     //   82: goto -> 164
/*      */     //   85: iload_1
/*      */     //   86: ldc 5243648
/*      */     //   88: if_icmpeq -> 139
/*      */     //   91: iload_1
/*      */     //   92: ldc 5244672
/*      */     //   94: if_icmpne -> 100
/*      */     //   97: goto -> 139
/*      */     //   100: iload_1
/*      */     //   101: ldc 5243904
/*      */     //   103: if_icmpeq -> 114
/*      */     //   106: aload_3
/*      */     //   107: astore_2
/*      */     //   108: iload_1
/*      */     //   109: ldc 5244928
/*      */     //   111: if_icmpne -> 218
/*      */     //   114: aload_0
/*      */     //   115: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   118: invokevirtual getRiReTireMsgPTimeout : ()I
/*      */     //   121: iconst_1
/*      */     //   122: if_icmpne -> 132
/*      */     //   125: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   128: astore_2
/*      */     //   129: goto -> 218
/*      */     //   132: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   135: astore_2
/*      */     //   136: goto -> 218
/*      */     //   139: aload_0
/*      */     //   140: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   143: invokevirtual getLeReTireMsgPTimeout : ()I
/*      */     //   146: iconst_1
/*      */     //   147: if_icmpne -> 157
/*      */     //   150: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   153: astore_2
/*      */     //   154: goto -> 218
/*      */     //   157: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   160: astore_2
/*      */     //   161: goto -> 218
/*      */     //   164: aload_0
/*      */     //   165: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   168: invokevirtual getRiFrntTireMsgPTimeout : ()I
/*      */     //   171: iconst_1
/*      */     //   172: if_icmpne -> 182
/*      */     //   175: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   178: astore_2
/*      */     //   179: goto -> 218
/*      */     //   182: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   185: astore_2
/*      */     //   186: goto -> 218
/*      */     //   189: aload_0
/*      */     //   190: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   193: invokevirtual getLeFrntTireMsgPTimeout : ()I
/*      */     //   196: iconst_1
/*      */     //   197: if_icmpne -> 207
/*      */     //   200: getstatic com/ecarx/xui/adaptapi/FunctionStatus.error : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   203: astore_2
/*      */     //   204: goto -> 218
/*      */     //   207: getstatic com/ecarx/xui/adaptapi/FunctionStatus.active : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   210: astore_2
/*      */     //   211: goto -> 218
/*      */     //   214: getstatic com/ecarx/xui/adaptapi/FunctionStatus.notactive : Lcom/ecarx/xui/adaptapi/FunctionStatus;
/*      */     //   217: astore_2
/*      */     //   218: goto -> 228
/*      */     //   221: astore_2
/*      */     //   222: aload_2
/*      */     //   223: invokevirtual printStackTrace : ()V
/*      */     //   226: aload_3
/*      */     //   227: astore_2
/*      */     //   228: aload_2
/*      */     //   229: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1519	-> 0
/*      */     //   #1521	-> 4
/*      */     //   #1522	-> 17
/*      */     //   #1524	-> 55
/*      */     //   #1531	-> 70
/*      */     //   #1539	-> 85
/*      */     //   #1546	-> 100
/*      */     //   #1548	-> 114
/*      */     //   #1549	-> 125
/*      */     //   #1551	-> 132
/*      */     //   #1541	-> 139
/*      */     //   #1542	-> 150
/*      */     //   #1544	-> 157
/*      */     //   #1533	-> 164
/*      */     //   #1534	-> 175
/*      */     //   #1536	-> 182
/*      */     //   #1526	-> 189
/*      */     //   #1527	-> 200
/*      */     //   #1529	-> 207
/*      */     //   #1555	-> 214
/*      */     //   #1560	-> 218
/*      */     //   #1558	-> 221
/*      */     //   #1559	-> 222
/*      */     //   #1561	-> 228
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   6	17	221	java/lang/Exception
/*      */     //   17	55	221	java/lang/Exception
/*      */     //   114	125	221	java/lang/Exception
/*      */     //   125	129	221	java/lang/Exception
/*      */     //   132	136	221	java/lang/Exception
/*      */     //   139	150	221	java/lang/Exception
/*      */     //   150	154	221	java/lang/Exception
/*      */     //   157	161	221	java/lang/Exception
/*      */     //   164	175	221	java/lang/Exception
/*      */     //   175	179	221	java/lang/Exception
/*      */     //   182	186	221	java/lang/Exception
/*      */     //   189	200	221	java/lang/Exception
/*      */     //   200	204	221	java/lang/Exception
/*      */     //   207	211	221	java/lang/Exception
/*      */     //   214	218	221	java/lang/Exception
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
/*      */   private float getDIMSpd(int paramInt1, int paramInt2) {
/* 1565 */     float f = Float.MIN_VALUE;
/* 1566 */     if (paramInt2 == 0) {
/*      */       
/* 1568 */       f = (float)(paramInt1 * 0.2778D);
/* 1569 */     } else if (paramInt2 == 1) {
/* 1570 */       f = (float)(paramInt1 * 0.2778D / 0.6214D);
/*      */     } 
/* 1572 */     return f;
/*      */   }
/*      */   
/*      */   private float getSpeedFromValue(int paramInt1, int paramInt2) {
/*      */     float f;
/* 1577 */     if (paramInt2 == 0) {
/*      */       
/* 1579 */       f = (float)(0.0D - paramInt1 * 0.00391D * 3.6D);
/*      */     } else {
/* 1581 */       f = (float)(paramInt1 * 0.00391D * 3.6D);
/*      */     } 
/* 1583 */     return f;
/*      */   }
/*      */   
/*      */   private int getGearState() {
/* 1587 */     byte b = -1;
/*      */     try {
/* 1589 */       int i = this.mCarSignalManager.getDrvrDesDirDrvrDesDir();
/* 1590 */       if (i == 2) {
/* 1591 */         b = 0;
/*      */       } else {
/* 1593 */         b = 1;
/*      */       } 
/* 1595 */     } catch (Exception exception) {
/* 1596 */       exception.printStackTrace();
/*      */     } 
/* 1598 */     return b;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\SensorNew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */