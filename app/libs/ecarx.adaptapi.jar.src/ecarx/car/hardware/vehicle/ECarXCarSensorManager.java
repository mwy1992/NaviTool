/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
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
/*     */ public class ECarXCarSensorManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbsensorjoylimitswitch = 33279;
/*     */   public static final int ManagerId_pasensordaytosrvvalue = 33957;
/*     */   public static final int ManagerId_pasensordsttosrvvalue = 33956;
/*     */   public static final int ManagerId_pasensorenghrtosrvvalue = 33958;
/*     */   public static final int ManagerId_pasensorjoyforbidstate = 33960;
/*     */   public static final int ManagerId_pasensorjoylimitstate = 33959;
/*     */   private static final String TAG = "ECarXCarSensorManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarSensorManager() {}
/*     */   
/*     */   public ECarXCarSensorManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  57 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SENSOR_JoyLimitSwitch(int paramInt) {
/*  67 */     ApiResult apiResult = ApiResult.FAILED;
/*  68 */     if (OnOff1.isValid(paramInt)) {
/*  69 */       apiResult = this.mMgr.setIntProperty(33279, 1, paramInt);
/*     */     } else {
/*  71 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  73 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SENSOR_DstToSrvValue getPA_SENSOR_DstToSrvValue() throws CarNotConnectedException {
/*  84 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33956, 1);
/*     */     
/*  86 */     PATypes.PA_SENSOR_DstToSrvValue pA_SENSOR_DstToSrvValue = null;
/*     */     try {
/*  88 */       PATypes.PA_SENSOR_DstToSrvValue pA_SENSOR_DstToSrvValue1 = new PATypes.PA_SENSOR_DstToSrvValue(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SENSOR_DstToSrvValue = pA_SENSOR_DstToSrvValue1;
/*  89 */     } catch (Exception exception) {}
/*     */     
/*  91 */     return pA_SENSOR_DstToSrvValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SENSOR_DayToSrvValue getPA_SENSOR_DayToSrvValue() throws CarNotConnectedException {
/* 100 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33957, 1);
/*     */     
/* 102 */     PATypes.PA_SENSOR_DayToSrvValue pA_SENSOR_DayToSrvValue = null;
/*     */     try {
/* 104 */       PATypes.PA_SENSOR_DayToSrvValue pA_SENSOR_DayToSrvValue1 = new PATypes.PA_SENSOR_DayToSrvValue(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SENSOR_DayToSrvValue = pA_SENSOR_DayToSrvValue1;
/* 105 */     } catch (Exception exception) {}
/*     */     
/* 107 */     return pA_SENSOR_DayToSrvValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SENSOR_EngHrToSrvValue getPA_SENSOR_EngHrToSrvValue() throws CarNotConnectedException {
/* 116 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33958, 1);
/*     */     
/* 118 */     PATypes.PA_SENSOR_EngHrToSrvValue pA_SENSOR_EngHrToSrvValue = null;
/*     */     try {
/* 120 */       PATypes.PA_SENSOR_EngHrToSrvValue pA_SENSOR_EngHrToSrvValue1 = new PATypes.PA_SENSOR_EngHrToSrvValue(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SENSOR_EngHrToSrvValue = pA_SENSOR_EngHrToSrvValue1;
/* 121 */     } catch (Exception exception) {}
/*     */     
/* 123 */     return pA_SENSOR_EngHrToSrvValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SENSOR_JoyLimitState getPA_SENSOR_JoyLimitState() throws CarNotConnectedException {
/* 132 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33959, 1);
/*     */     
/* 134 */     PATypes.PA_SENSOR_JoyLimitState pA_SENSOR_JoyLimitState = null;
/*     */     try {
/* 136 */       PATypes.PA_SENSOR_JoyLimitState pA_SENSOR_JoyLimitState1 = new PATypes.PA_SENSOR_JoyLimitState(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SENSOR_JoyLimitState = pA_SENSOR_JoyLimitState1;
/* 137 */     } catch (Exception exception) {}
/*     */     
/* 139 */     return pA_SENSOR_JoyLimitState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SENSOR_JoyForbidState getPA_SENSOR_JoyForbidState() throws CarNotConnectedException {
/* 148 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33960, 1);
/*     */     
/* 150 */     PATypes.PA_SENSOR_JoyForbidState pA_SENSOR_JoyForbidState = null;
/*     */     try {
/* 152 */       PATypes.PA_SENSOR_JoyForbidState pA_SENSOR_JoyForbidState1 = new PATypes.PA_SENSOR_JoyForbidState(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SENSOR_JoyForbidState = pA_SENSOR_JoyForbidState1;
/* 153 */     } catch (Exception exception) {}
/*     */     
/* 155 */     return pA_SENSOR_JoyForbidState;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarSensorManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */