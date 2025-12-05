/*     */ package com.ecarx.xui.adaptapi.car.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.IPowerStatusListener;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*     */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*     */ import com.ecarx.xui.adaptapi.car.Pairs;
/*     */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.power.BrightnessManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DayMode
/*     */   extends AbsCarFunction
/*     */   implements IDayMode
/*     */ {
/*     */   private static final int AUTO_MODE = 2;
/*     */   private static final int AUTO_THEME = 2;
/*     */   private static final int[] BACKLIGHT_LEVEL_LIST;
/*     */   private static final int[] BACKLIGHT_LINKAGE_STATUS_LIST;
/*     */   private static final int BRIGHT_MODE = 1;
/*     */   private static final int CUSTOM_THEME = 3;
/*     */   private static final int DARK_MODE = 0;
/*  72 */   private static final int[] DAY_MODE_BRI_VALUE_LIST = new int[] { 538247425, 538247426, 538247427 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   private static final int[] DAY_MODE_THEME_VALUE_LIST = new int[] { 538247425, 538247426, 538247427, 538247428, 538247429 }; private static final int DAY_THEME = 1; private static final int MGR_CSD = 1; private static final int MGR_PSD = 2; private static final int MSG_BACKLIGHT_LINKAGE = 5; private static final int MSG_BRIGHTNESS_BACKLIGHT = 6; private static final int MSG_BRIGHTNESS_DAY = 1; private static final int MSG_BRIGHTNESS_NIGHT = 2; private static final int MSG_BRI_DAYMODE_SETTING = 4; private static final int MSG_DAYMODE_SETTING = 3; private static final int NIGHT_THEME = 0; private static final int SUN_THEME = 4;
/*     */   private static final String TAG = "DayMode_API";
/*     */   private static final int VEHICLE_BACKLIGHT_OFF = 2;
/*     */   private static final int VEHICLE_BACKLIGHT_ON = 1;
/*     */   private BrightnessManager mBrightnessMgr;
/*     */   private Handler mHandler;
/*     */   
/*     */   static {
/*  86 */     BACKLIGHT_LINKAGE_STATUS_LIST = new int[] { 1, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     BACKLIGHT_LEVEL_LIST = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
/*     */   }
/*     */ 
/*     */   
/*     */   protected DayMode(Context paramContext) {
/*  96 */     super(paramContext, 687865856);
/*  97 */     Log.d("DayMode_API", "DayMode constructed");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/* 103 */     this.mBrightnessMgr = BrightnessManager.getInstance(this.mContext);
/* 104 */     this.mBrightnessMgr.registerCallBack((IPowerStatusListener)new DayModeReceiver());
/* 105 */     this.mHandler = new Handler(Looper.getMainLooper()) {
/*     */         final DayMode this$0;
/*     */         
/* 108 */         public void handleMessage(Message param1Message) { switch (param1Message.what)
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             default:
/* 150 */               Log.d("DayMode_API", "Nothing to notify app"); return;
/*     */             case 6: stringBuilder = new StringBuilder(); stringBuilder.append("Notify app MSG_BRIGHTNESS_BACKLIGHT msg.arg2: "); stringBuilder.append(param1Message.arg2); stringBuilder.append(" msg.arg1: "); stringBuilder.append(param1Message.arg1); Log.d("DayMode_API", stringBuilder.toString()); DayMode.this.onFunctionChanged(687997184); DayMode.this.onCustomizeFunctionValueChanged(687997184, param1Message.arg2, param1Message.arg1); return;
/*     */             case 5: stringBuilder = new StringBuilder(); stringBuilder.append("Notify app MSG_BACKLIGHT_LINKAGE msg.arg2: "); stringBuilder.append(param1Message.arg2); stringBuilder.append(" msg.arg1: "); stringBuilder.append(param1Message.arg1); Log.d("DayMode_API", stringBuilder.toString()); DayMode.this.onFunctionChanged(687931648); DayMode.this.onFunctionValueChanged(687931648, param1Message.arg2, param1Message.arg1); return;
/*     */             case 4:
/*     */               stringBuilder = new StringBuilder(); stringBuilder.append("Notify app MSG_BRI_DAYMODE_SETTING msg.arg2: "); stringBuilder.append(param1Message.arg2); stringBuilder.append(" msg.arg1: "); stringBuilder.append(param1Message.arg1); Log.d("DayMode_API", stringBuilder.toString()); DayMode.this.onFunctionChanged(688062976); DayMode.this.onCustomizeFunctionValueChanged(688062976, param1Message.arg2, param1Message.arg1); return;
/*     */             case 3:
/*     */               stringBuilder = new StringBuilder(); stringBuilder.append("Notify app MSG_DAYMODE_SETTING msg.arg2: "); stringBuilder.append(param1Message.arg2); stringBuilder.append(" msg.arg1: "); stringBuilder.append(param1Message.arg1); Log.d("DayMode_API", stringBuilder.toString()); DayMode.this.onFunctionChanged(538247424); DayMode.this.onFunctionValueChanged(538247424, param1Message.arg2, param1Message.arg1); return;
/*     */             case 2:
/*     */               stringBuilder = new StringBuilder(); stringBuilder.append("Notify app MSG_BRIGHTNESS_NIGHT msg.arg2: "); stringBuilder.append(param1Message.arg2); stringBuilder.append(" msg.arg1: "); stringBuilder.append(param1Message.arg1); Log.d("DayMode_API", stringBuilder.toString()); DayMode.this.onFunctionChanged(538248192); DayMode.this.onCustomizeFunctionValueChanged(538248192, param1Message.arg2, param1Message.arg1); return;
/*     */             case 1:
/* 160 */               break; }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Notify app MSG_BRIGHTNESS_DAY msg.arg2: "); stringBuilder.append(param1Message.arg2); stringBuilder.append(" msg.arg1: "); stringBuilder.append(param1Message.arg1); Log.d("DayMode_API", stringBuilder.toString()); DayMode.this.onFunctionChanged(538247936); DayMode.this.onCustomizeFunctionValueChanged(538247936, param1Message.arg2, param1Message.arg1); } }; } protected void buildFunctions() { Pairs pairs1 = Pairs.of(Integer.valueOf(538247425), Integer.valueOf(1));
/* 161 */     pairs1 = pairs1.add(Integer.valueOf(538247426), Integer.valueOf(0));
/* 162 */     Pairs pairs2 = pairs1.add(Integer.valueOf(538247427), Integer.valueOf(2));
/*     */     
/* 164 */     pairs1 = Pairs.of(Integer.valueOf(538247425), Integer.valueOf(1));
/* 165 */     pairs1 = pairs1.add(Integer.valueOf(538247426), Integer.valueOf(0));
/* 166 */     pairs1 = pairs1.add(Integer.valueOf(538247427), Integer.valueOf(2));
/* 167 */     pairs1 = pairs1.add(Integer.valueOf(538247428), Integer.valueOf(3));
/* 168 */     Pairs pairs3 = pairs1.add(Integer.valueOf(538247429), Integer.valueOf(4));
/*     */     
/* 170 */     pairs1 = Pairs.of(Integer.valueOf(1), Integer.valueOf(1));
/* 171 */     pairs1 = pairs1.add(Integer.valueOf(0), Integer.valueOf(2));
/*     */ 
/*     */     
/* 174 */     IVehicleFunction iVehicleFunction18 = VehicleFunction.intFunction(538247424); int[] arrayOfInt4 = DAY_MODE_THEME_VALUE_LIST;
/* 175 */     IVehicleFunction iVehicleFunction17 = iVehicleFunction18.supportedFunctionValue(arrayOfInt4);
/* 176 */     IVehicleFunction.IZone iZone18 = iVehicleFunction17.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus14 = FunctionStatus.active;
/* 177 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iZone18.fixStatus(functionStatus14); -$$Lambda$DayMode$LQR_d87rXqCqfPy5OEYzM7uIlDQ -$$Lambda$DayMode$LQR_d87rXqCqfPy5OEYzM7uIlDQ = new -$$Lambda$DayMode$LQR_d87rXqCqfPy5OEYzM7uIlDQ(this);
/* 178 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$DayMode$LQR_d87rXqCqfPy5OEYzM7uIlDQ, pairs3); -$$Lambda$DayMode$GIhTb4F-7K_GtuYuUGYoaSxuqhU -$$Lambda$DayMode$GIhTb4F-7K_GtuYuUGYoaSxuqhU = new -$$Lambda$DayMode$GIhTb4F-7K_GtuYuUGYoaSxuqhU(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild24.customValue(-$$Lambda$DayMode$GIhTb4F-7K_GtuYuUGYoaSxuqhU); -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo3 = new -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     iFilterCallback18.addTo(-$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo3);
/*     */ 
/*     */     
/* 204 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.intFunction(688062976); int[] arrayOfInt3 = DAY_MODE_BRI_VALUE_LIST;
/* 205 */     IVehicleFunction iVehicleFunction15 = iVehicleFunction16.supportedFunctionValue(arrayOfInt3);
/* 206 */     IVehicleFunction.IZone iZone17 = iVehicleFunction15.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus13 = FunctionStatus.active;
/* 207 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iZone17.fixStatus(functionStatus13); -$$Lambda$DayMode$XHnRwNTq49DI1zMzZbmPeWebumg -$$Lambda$DayMode$XHnRwNTq49DI1zMzZbmPeWebumg = new -$$Lambda$DayMode$XHnRwNTq49DI1zMzZbmPeWebumg(this);
/* 208 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iValueTaskBuild23.onSetFunctionValue(-$$Lambda$DayMode$XHnRwNTq49DI1zMzZbmPeWebumg, pairs2); -$$Lambda$DayMode$Fj5O1Ch_yAcYgSyE9GizaZ4sZiA -$$Lambda$DayMode$Fj5O1Ch_yAcYgSyE9GizaZ4sZiA = new -$$Lambda$DayMode$Fj5O1Ch_yAcYgSyE9GizaZ4sZiA(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild20.customValue(-$$Lambda$DayMode$Fj5O1Ch_yAcYgSyE9GizaZ4sZiA); -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo2 = new -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     iFilterCallback17.addTo(-$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo2);
/*     */ 
/*     */     
/* 230 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(687931648); int[] arrayOfInt2 = BACKLIGHT_LINKAGE_STATUS_LIST;
/* 231 */     IVehicleFunction iVehicleFunction13 = iVehicleFunction14.supportedFunctionValue(arrayOfInt2);
/* 232 */     IVehicleFunction.IZone iZone16 = iVehicleFunction13.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$DayMode$eVlSsXhaGwu99DtQCBS73hxr1Uk -$$Lambda$DayMode$eVlSsXhaGwu99DtQCBS73hxr1Uk = new -$$Lambda$DayMode$eVlSsXhaGwu99DtQCBS73hxr1Uk(this);
/* 233 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iZone16.customStatus(-$$Lambda$DayMode$eVlSsXhaGwu99DtQCBS73hxr1Uk); -$$Lambda$DayMode$HBEbj5sioYCPkWhPPRgwuKN1t10 -$$Lambda$DayMode$HBEbj5sioYCPkWhPPRgwuKN1t10 = new -$$Lambda$DayMode$HBEbj5sioYCPkWhPPRgwuKN1t10(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     iValueTaskBuild19 = iValueTaskBuild19.onSetFunctionValue(-$$Lambda$DayMode$HBEbj5sioYCPkWhPPRgwuKN1t10, pairs1); -$$Lambda$DayMode$9LHBOnMDSeru0dW2cpvnU1-jQio -$$Lambda$DayMode$9LHBOnMDSeru0dW2cpvnU1-jQio = new -$$Lambda$DayMode$9LHBOnMDSeru0dW2cpvnU1-jQio(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 259 */     IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild19.customValue(-$$Lambda$DayMode$9LHBOnMDSeru0dW2cpvnU1-jQio); -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo1 = new -$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     iFilterCallback12.addTo(-$$Lambda$DayMode$yPSd_4ozO8os9Y0QQ6PDDBcEdAo1);
/*     */ 
/*     */     
/* 267 */     IVehicleFunction iVehicleFunction12 = VehicleFunction.customFunction(687997184); int[] arrayOfInt1 = BACKLIGHT_LEVEL_LIST;
/* 268 */     IVehicleFunction iVehicleFunction11 = iVehicleFunction12.supportedFunctionValue(arrayOfInt1);
/* 269 */     IVehicleFunction.IZone iZone15 = iVehicleFunction11.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$DayMode$Gcxw7Cde3q0hOo1BQX7NwOBhvDw -$$Lambda$DayMode$Gcxw7Cde3q0hOo1BQX7NwOBhvDw = new -$$Lambda$DayMode$Gcxw7Cde3q0hOo1BQX7NwOBhvDw(this);
/* 270 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iZone15.customStatus(-$$Lambda$DayMode$Gcxw7Cde3q0hOo1BQX7NwOBhvDw); -$$Lambda$DayMode$vvHRSKyO7sY-poR3ESsbBLPWEoA -$$Lambda$DayMode$vvHRSKyO7sY-poR3ESsbBLPWEoA = new -$$Lambda$DayMode$vvHRSKyO7sY-poR3ESsbBLPWEoA(this); -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU4 = -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 291 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$DayMode$vvHRSKyO7sY-poR3ESsbBLPWEoA, -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU4); -$$Lambda$DayMode$7xMQkCjPferJ-4W1bTxgOD-9wgE -$$Lambda$DayMode$7xMQkCjPferJ-4W1bTxgOD-9wgE = new -$$Lambda$DayMode$7xMQkCjPferJ-4W1bTxgOD-9wgE(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild18.customValue(-$$Lambda$DayMode$7xMQkCjPferJ-4W1bTxgOD-9wgE); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY11 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 302 */     iFilterCallback11.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY11);
/*     */ 
/*     */     
/* 305 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.customFunction(538247936);
/* 306 */     IVehicleFunction.IZone iZone8 = iVehicleFunction10.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus12 = FunctionStatus.active;
/* 307 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iZone8.fixStatus(functionStatus12); -$$Lambda$DayMode$EKkha9tzJV9d2Y4zPUwHm7HGdQk -$$Lambda$DayMode$EKkha9tzJV9d2Y4zPUwHm7HGdQk = new -$$Lambda$DayMode$EKkha9tzJV9d2Y4zPUwHm7HGdQk(this); -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU6 = -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/* 308 */     iValueTaskBuild12 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$DayMode$EKkha9tzJV9d2Y4zPUwHm7HGdQk, -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU6); -$$Lambda$DayMode$D38L6Czxf-w3wJoJjNnv0L21qrY -$$Lambda$DayMode$D38L6Czxf-w3wJoJjNnv0L21qrY = new -$$Lambda$DayMode$D38L6Czxf-w3wJoJjNnv0L21qrY(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild12.customValue(-$$Lambda$DayMode$D38L6Czxf-w3wJoJjNnv0L21qrY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 324 */     IVehicleFunction.IZone iZone7 = iFilterCallback10.createZone(new int[] { 1 }); FunctionStatus functionStatus11 = FunctionStatus.active;
/* 325 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iZone7.fixStatus(functionStatus11); -$$Lambda$DayMode$pftM3mUpefuZvKgpscLvCeOKwfQ -$$Lambda$DayMode$pftM3mUpefuZvKgpscLvCeOKwfQ = new -$$Lambda$DayMode$pftM3mUpefuZvKgpscLvCeOKwfQ(this); -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU6 = -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/* 326 */     iValueTaskBuild17 = iValueTaskBuild17.onSetFunctionValue(-$$Lambda$DayMode$pftM3mUpefuZvKgpscLvCeOKwfQ, -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU6); -$$Lambda$DayMode$TVy7xTKOwCRk3NDRW95_TkRu5hw -$$Lambda$DayMode$TVy7xTKOwCRk3NDRW95_TkRu5hw = new -$$Lambda$DayMode$TVy7xTKOwCRk3NDRW95_TkRu5hw(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild17.customValue(-$$Lambda$DayMode$TVy7xTKOwCRk3NDRW95_TkRu5hw);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     IVehicleFunction.IZone iZone14 = iFilterCallback9.createZone(new int[] { 4 }); -$$Lambda$DayMode$LSwdhgTRiFeQ3xRC9zAD7Hdl0ao -$$Lambda$DayMode$LSwdhgTRiFeQ3xRC9zAD7Hdl0ao = new -$$Lambda$DayMode$LSwdhgTRiFeQ3xRC9zAD7Hdl0ao(this);
/* 343 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iZone14.customStatus(-$$Lambda$DayMode$LSwdhgTRiFeQ3xRC9zAD7Hdl0ao); -$$Lambda$DayMode$NXeeOnUOG_0yrYzq53Bl59lleXw -$$Lambda$DayMode$NXeeOnUOG_0yrYzq53Bl59lleXw = new -$$Lambda$DayMode$NXeeOnUOG_0yrYzq53Bl59lleXw(this); -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU1 = -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iValueTaskBuild16.onSetFunctionValue(-$$Lambda$DayMode$NXeeOnUOG_0yrYzq53Bl59lleXw, -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU1); -$$Lambda$DayMode$EcpQ48LhOk-NOZoC1lp4LP_PSPM -$$Lambda$DayMode$EcpQ48LhOk-NOZoC1lp4LP_PSPM = new -$$Lambda$DayMode$EcpQ48LhOk-NOZoC1lp4LP_PSPM(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild11.customValue(-$$Lambda$DayMode$EcpQ48LhOk-NOZoC1lp4LP_PSPM); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY4 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     iFilterCallback16.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY4);
/*     */ 
/*     */     
/* 376 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.customFunction(538248192);
/* 377 */     IVehicleFunction.IZone iZone13 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus4 = FunctionStatus.active;
/* 378 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iZone13.fixStatus(functionStatus4); -$$Lambda$DayMode$vurTiEUTmV8Nu7pCFXlBHFDem-Y -$$Lambda$DayMode$vurTiEUTmV8Nu7pCFXlBHFDem-Y = new -$$Lambda$DayMode$vurTiEUTmV8Nu7pCFXlBHFDem-Y(this); -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU3 = -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/* 379 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iValueTaskBuild22.onSetFunctionValue(-$$Lambda$DayMode$vurTiEUTmV8Nu7pCFXlBHFDem-Y, -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU3); -$$Lambda$DayMode$9KXh_3YEfX7nx7IOT8IpngMNBQQ -$$Lambda$DayMode$9KXh_3YEfX7nx7IOT8IpngMNBQQ = new -$$Lambda$DayMode$9KXh_3YEfX7nx7IOT8IpngMNBQQ(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild10.customValue(-$$Lambda$DayMode$9KXh_3YEfX7nx7IOT8IpngMNBQQ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 395 */     IVehicleFunction.IZone iZone12 = iFilterCallback8.createZone(new int[] { 1 }); FunctionStatus functionStatus3 = FunctionStatus.active;
/* 396 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iZone12.fixStatus(functionStatus3); -$$Lambda$DayMode$k6kuuLBk_FK3aMqnz6g0XrlwjMw -$$Lambda$DayMode$k6kuuLBk_FK3aMqnz6g0XrlwjMw = new -$$Lambda$DayMode$k6kuuLBk_FK3aMqnz6g0XrlwjMw(this); -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU5 = -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/* 397 */     iValueTaskBuild9 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$DayMode$k6kuuLBk_FK3aMqnz6g0XrlwjMw, -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU5); -$$Lambda$DayMode$zMn_G8veUDEMIFTmiF9bk6AvKqQ -$$Lambda$DayMode$zMn_G8veUDEMIFTmiF9bk6AvKqQ = new -$$Lambda$DayMode$zMn_G8veUDEMIFTmiF9bk6AvKqQ(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 404 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild9.customValue(-$$Lambda$DayMode$zMn_G8veUDEMIFTmiF9bk6AvKqQ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 412 */     IVehicleFunction.IZone iZone11 = iFilterCallback7.createZone(new int[] { 4 }); -$$Lambda$DayMode$0mL-GuKlBQ-_TSjkqx_1Lju-yhE -$$Lambda$DayMode$0mL-GuKlBQ-_TSjkqx_1Lju-yhE = new -$$Lambda$DayMode$0mL-GuKlBQ-_TSjkqx_1Lju-yhE(this);
/* 413 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iZone11.customStatus(-$$Lambda$DayMode$0mL-GuKlBQ-_TSjkqx_1Lju-yhE); -$$Lambda$DayMode$0zZ_zW8HHVqo0zMmguib51xMfEc -$$Lambda$DayMode$0zZ_zW8HHVqo0zMmguib51xMfEc = new -$$Lambda$DayMode$0zZ_zW8HHVqo0zMmguib51xMfEc(this); -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU2 = -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 428 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iValueTaskBuild21.onSetFunctionValue(-$$Lambda$DayMode$0zZ_zW8HHVqo0zMmguib51xMfEc, -$$Lambda$DayMode$Cdx7vHInof1EQrtz2WxT4MQ7JiU2); -$$Lambda$DayMode$IJmInEiVJTRsVDPv3Vk2SYyvTP8 -$$Lambda$DayMode$IJmInEiVJTRsVDPv3Vk2SYyvTP8 = new -$$Lambda$DayMode$IJmInEiVJTRsVDPv3Vk2SYyvTP8(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 435 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild8.customValue(-$$Lambda$DayMode$IJmInEiVJTRsVDPv3Vk2SYyvTP8); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY10 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 442 */     iFilterCallback6.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY10);
/*     */ 
/*     */     
/* 445 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.customFunction(688063232);
/* 446 */     IVehicleFunction.IZone iZone6 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus10 = FunctionStatus.active;
/* 447 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iZone6.fixStatus(functionStatus10); -$$Lambda$DayMode$5uh6IXDbG19XO-IHJ8svfjuQ5iY -$$Lambda$DayMode$5uh6IXDbG19XO-IHJ8svfjuQ5iY = new -$$Lambda$DayMode$5uh6IXDbG19XO-IHJ8svfjuQ5iY(this);
/* 448 */     iValueTaskBuild15 = iValueTaskBuild15.onSetFunctionValue(-$$Lambda$DayMode$5uh6IXDbG19XO-IHJ8svfjuQ5iY); -$$Lambda$DayMode$gFrrLzU0ISlg7LTtVBaHbm8MP1I -$$Lambda$DayMode$gFrrLzU0ISlg7LTtVBaHbm8MP1I = new -$$Lambda$DayMode$gFrrLzU0ISlg7LTtVBaHbm8MP1I(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 453 */     IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild15.customValue(-$$Lambda$DayMode$gFrrLzU0ISlg7LTtVBaHbm8MP1I); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY3 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 458 */     iFilterCallback15.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY3);
/*     */ 
/*     */     
/* 461 */     IVehicleFunction iVehicleFunction7 = VehicleFunction.customFunction(688063488);
/* 462 */     IVehicleFunction.IZone iZone5 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus9 = FunctionStatus.active;
/* 463 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iZone5.fixStatus(functionStatus9); -$$Lambda$DayMode$kA3uGn1pv13-zeCIjKk3WHvsAMU -$$Lambda$DayMode$kA3uGn1pv13-zeCIjKk3WHvsAMU = new -$$Lambda$DayMode$kA3uGn1pv13-zeCIjKk3WHvsAMU(this);
/* 464 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$DayMode$kA3uGn1pv13-zeCIjKk3WHvsAMU); -$$Lambda$DayMode$RWF1YJFmUOKku5RcffNr8M-Zj94 -$$Lambda$DayMode$RWF1YJFmUOKku5RcffNr8M-Zj94 = new -$$Lambda$DayMode$RWF1YJFmUOKku5RcffNr8M-Zj94(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 469 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild14.customValue(-$$Lambda$DayMode$RWF1YJFmUOKku5RcffNr8M-Zj94); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY2 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 474 */     iFilterCallback14.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY2);
/*     */     
/* 476 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.customFunction(687997440);
/* 477 */     IVehicleFunction.IZone iZone4 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus8 = FunctionStatus.active;
/* 478 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iZone4.fixStatus(functionStatus8); -$$Lambda$DayMode$I0lKPk0KTmZ4qF7ldAvQvag-OJA -$$Lambda$DayMode$I0lKPk0KTmZ4qF7ldAvQvag-OJA = -$$Lambda$DayMode$I0lKPk0KTmZ4qF7ldAvQvag-OJA.INSTANCE;
/* 479 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild6.customValue(-$$Lambda$DayMode$I0lKPk0KTmZ4qF7ldAvQvag-OJA); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY9 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/* 480 */     iFilterCallback5.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY9);
/*     */     
/* 482 */     IVehicleFunction iVehicleFunction5 = VehicleFunction.customFunction(538248448);
/* 483 */     IVehicleFunction.IZone iZone10 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus2 = FunctionStatus.active;
/* 484 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iZone10.fixStatus(functionStatus2); -$$Lambda$DayMode$ObBhrtdP5JUwrFvju03lIrqaTvk -$$Lambda$DayMode$ObBhrtdP5JUwrFvju03lIrqaTvk = -$$Lambda$DayMode$ObBhrtdP5JUwrFvju03lIrqaTvk.INSTANCE;
/* 485 */     IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild5.customValue(-$$Lambda$DayMode$ObBhrtdP5JUwrFvju03lIrqaTvk); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY1 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/* 486 */     iFilterCallback13.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY1);
/*     */     
/* 488 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.customFunction(687997696);
/* 489 */     IVehicleFunction.IZone iZone9 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus1 = FunctionStatus.active;
/* 490 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iZone9.fixStatus(functionStatus1); -$$Lambda$DayMode$2D0gnN0nBi8_aDuh7vYaB5JUrm4 -$$Lambda$DayMode$2D0gnN0nBi8_aDuh7vYaB5JUrm4 = -$$Lambda$DayMode$2D0gnN0nBi8_aDuh7vYaB5JUrm4.INSTANCE;
/* 491 */     IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild4.customValue(-$$Lambda$DayMode$2D0gnN0nBi8_aDuh7vYaB5JUrm4); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY8 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/* 492 */     iFilterCallback4.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY8);
/*     */     
/* 494 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.customFunction(538248704);
/* 495 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus7 = FunctionStatus.active;
/* 496 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iZone3.fixStatus(functionStatus7); -$$Lambda$DayMode$zy12SKxdRSPsuXnynB5rRa-J9aU -$$Lambda$DayMode$zy12SKxdRSPsuXnynB5rRa-J9aU = -$$Lambda$DayMode$zy12SKxdRSPsuXnynB5rRa-J9aU.INSTANCE;
/* 497 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild3.customValue(-$$Lambda$DayMode$zy12SKxdRSPsuXnynB5rRa-J9aU); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY7 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/* 498 */     iFilterCallback3.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY7);
/*     */     
/* 500 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.customFunction(687997952);
/* 501 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus6 = FunctionStatus.active;
/* 502 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iZone2.fixStatus(functionStatus6); -$$Lambda$DayMode$UI_F9IPcoEcKbx_bP4Z41Ak4Mtw -$$Lambda$DayMode$UI_F9IPcoEcKbx_bP4Z41Ak4Mtw = -$$Lambda$DayMode$UI_F9IPcoEcKbx_bP4Z41Ak4Mtw.INSTANCE;
/* 503 */     IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild2.customValue(-$$Lambda$DayMode$UI_F9IPcoEcKbx_bP4Z41Ak4Mtw); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY6 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/* 504 */     iFilterCallback2.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY6);
/*     */     
/* 506 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.customFunction(538248960);
/* 507 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE }); FunctionStatus functionStatus5 = FunctionStatus.active;
/* 508 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iZone1.fixStatus(functionStatus5); -$$Lambda$DayMode$97IdyvN7eb4wNj9Q79cGKCDitnI -$$Lambda$DayMode$97IdyvN7eb4wNj9Q79cGKCDitnI = -$$Lambda$DayMode$97IdyvN7eb4wNj9Q79cGKCDitnI.INSTANCE;
/* 509 */     IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.customValue(-$$Lambda$DayMode$97IdyvN7eb4wNj9Q79cGKCDitnI); -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY5 = new -$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY(this);
/* 510 */     iFilterCallback1.addTo(-$$Lambda$DayMode$im71x2Ckjh3lg-34SHOY96m3DeY5); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean setCustomDayNightTimeSetting(float[] paramArrayOffloat) {
/* 517 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public float[] getCustomDayNightTimeSetting() {
/* 524 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private int convertVehicleZoneToAdapt(int paramInt) {
/* 529 */     switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 537 */         paramInt = 1;
/*     */ 
/*     */         
/* 540 */         return paramInt;case 2: paramInt = 4; return paramInt;case 1: break; }  paramInt = 1; return paramInt;
/*     */   }
/*     */   private int convertBriModeToAdapt(int paramInt) {
/*     */     StringBuilder stringBuilder;
/* 544 */     char c = 'ÿ';
/*     */     
/* 546 */     switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 554 */         stringBuilder = new StringBuilder(); stringBuilder.append("convertBriModeToAdapt -- illigal parm briMode: "); stringBuilder.append(paramInt); Log.e("DayMode_API", stringBuilder.toString()); paramInt = c;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 559 */         return paramInt;case 2: paramInt = 0; return paramInt;case 1: break; }  paramInt = 1; return paramInt;
/*     */   }
/*     */   
/*     */   private class DayModeReceiver
/*     */     extends IPowerStatusListener.Stub {
/*     */     final DayMode this$0;
/*     */     
/*     */     private DayModeReceiver() {}
/*     */     
/*     */     public void onStatusChanged(int param1Int1, int param1Int2) {}
/*     */     
/*     */     public void onDayNightChanged(int param1Int) {
/* 571 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onDayNightChanged: mode="); stringBuilder.append(param1Int); Log.d("DayMode_API", stringBuilder.toString());
/* 572 */       Message message = DayMode.this.mHandler.obtainMessage();
/* 573 */       message.what = 3;
/* 574 */       message.arg1 = convertDayModeSettingToAdapt(param1Int);
/* 575 */       message.arg2 = 1;
/* 576 */       DayMode.this.mHandler.sendMessage(message);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onBrightnessModeChanged(int param1Int) {
/* 581 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onBrightnessModeChanged mode: "); stringBuilder.append(param1Int); Log.d("DayMode_API", stringBuilder.toString());
/* 582 */       Message message = DayMode.this.mHandler.obtainMessage();
/* 583 */       message.what = 5;
/* 584 */       message.arg1 = DayMode.this.convertBriModeToAdapt(param1Int);
/* 585 */       message.arg2 = Integer.MIN_VALUE;
/* 586 */       DayMode.this.mHandler.sendMessage(message);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onDayBrightnessChanged(int param1Int1, int param1Int2) {
/* 591 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onDayBrightnessChanged brightness: "); stringBuilder.append(param1Int1); stringBuilder.append(", vehicleZone: "); stringBuilder.append(param1Int2); Log.d("DayMode_API", stringBuilder.toString());
/*     */ 
/*     */       
/* 594 */       Message message = DayMode.this.mHandler.obtainMessage();
/* 595 */       message.what = 1;
/* 596 */       message.arg1 = param1Int1;
/* 597 */       message.arg2 = DayMode.this.convertVehicleZoneToAdapt(param1Int2);
/*     */       
/* 599 */       DayMode.this.mHandler.sendMessage(message);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onNightBrightnessChanged(int param1Int1, int param1Int2) {
/* 604 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onNightBrightnessChanged brightness: "); stringBuilder.append(param1Int1); stringBuilder.append(", vehicleZone: "); stringBuilder.append(param1Int2); Log.d("DayMode_API", stringBuilder.toString());
/*     */ 
/*     */       
/* 607 */       Message message = DayMode.this.mHandler.obtainMessage();
/* 608 */       message.what = 2;
/* 609 */       message.arg1 = param1Int1;
/* 610 */       message.arg2 = DayMode.this.convertVehicleZoneToAdapt(param1Int2);
/*     */       
/* 612 */       DayMode.this.mHandler.sendMessage(message);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onVehicleBrightnessChanged(int param1Int) {
/* 617 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onVehicleBrightnessChanged: "); stringBuilder.append(param1Int); Log.d("DayMode_API", stringBuilder.toString());
/* 618 */       Message message = DayMode.this.mHandler.obtainMessage();
/* 619 */       message.what = 6;
/* 620 */       message.arg1 = param1Int;
/* 621 */       message.arg2 = Integer.MIN_VALUE;
/* 622 */       DayMode.this.mHandler.sendMessage(message);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSettingManagerReady(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onDayNightModeChanged(int param1Int) {
/* 632 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onDayNightModeChanged mode: "); stringBuilder.append(param1Int); Log.d("DayMode_API", stringBuilder.toString());
/* 633 */       Message message = DayMode.this.mHandler.obtainMessage();
/* 634 */       message.what = 4;
/* 635 */       message.arg1 = param1Int;
/* 636 */       message.arg2 = 1;
/* 637 */       DayMode.this.mHandler.sendMessage(message);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onManualDayNightModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onAutoDayNightModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     private int convertDayModeSettingToAdapt(int param1Int) {
/* 652 */       char c = 'ÿ';
/*     */       
/* 654 */       switch (param1Int) { default: param1Int = c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 668 */           return param1Int;case 2: param1Int = 538247427; return param1Int;case 1: param1Int = 538247425; return param1Int;case 0: break; }  param1Int = 538247426; return param1Int;
/*     */     }
/*     */     
/*     */     public void onCustomDayTimeChanged(float param1Float) {}
/*     */     
/*     */     public void onCustomNightTimeChanged(float param1Float) {}
/*     */     
/*     */     public void onScreenSaverStyleChanged(int param1Int) {}
/*     */     
/*     */     public void onScreenSaverNameChanged(String param1String) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\DayMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */