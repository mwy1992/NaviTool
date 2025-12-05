/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.PhevSwitchsts;
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
/*     */ 
/*     */ public class ECarXCarPhevManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbphev10or100switch = 33186;
/*     */   public static final int ManagerId_cbphevreboot = 33187;
/*     */   public static final int ManagerId_patscurtripdis = 33934;
/*     */   public static final int ManagerId_patscurtriptime = 33935;
/*     */   public static final int ManagerId_patsdtehvbattindicated = 33769;
/*     */   public static final int ManagerId_patsdtehvround = 33770;
/*     */   public static final int ManagerId_patsdteindicated = 33768;
/*     */   public static final int ManagerId_patsedttime2 = 33771;
/*     */   public static final int ManagerId_patsenergyrestats10 = 33782;
/*     */   public static final int ManagerId_patsenergyrestats100 = 33783;
/*     */   public static final int ManagerId_patsenergystats10 = 33780;
/*     */   public static final int ManagerId_patsenergystats100 = 33781;
/*     */   public static final int ManagerId_patsfuelstats10 = 33778;
/*     */   public static final int ManagerId_patsfuelstats100 = 33779;
/*     */   public static final int ManagerId_patsmsgend = 33903;
/*     */   public static final int ManagerId_patsodometertripmeter2 = 33773;
/*     */   public static final int ManagerId_patstripaverageconsumption05km = 33774;
/*     */   public static final int ManagerId_patstripaverageconsumption5km = 33775;
/*     */   public static final int ManagerId_patstripaverageenconsumption05km = 33776;
/*     */   public static final int ManagerId_patstripaverageenconsumption5km = 33777;
/*     */   public static final int ManagerId_patszeroemission = 33772;
/*     */   private static final String TAG = "ECarXCarPhevManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarPhevManager() {}
/*     */   
/*     */   public ECarXCarPhevManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  73 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PHEV_10or100Switch(int paramInt) {
/*  83 */     ApiResult apiResult = ApiResult.FAILED;
/*  84 */     if (PhevSwitchsts.isValid(paramInt)) {
/*  85 */       apiResult = this.mMgr.setIntProperty(33186, 1, paramInt);
/*     */     } else {
/*  87 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  89 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PHEV_Reboot(int paramInt) {
/*  99 */     return this.mMgr.setIntProperty(33187, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_DTEIndicated getPA_TS_DTEIndicated() throws CarNotConnectedException {
/* 110 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33768, 1);
/*     */     
/* 112 */     PATypes.PA_TS_DTEIndicated pA_TS_DTEIndicated = null;
/*     */     try {
/* 114 */       PATypes.PA_TS_DTEIndicated pA_TS_DTEIndicated1 = new PATypes.PA_TS_DTEIndicated(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_DTEIndicated = pA_TS_DTEIndicated1;
/* 115 */     } catch (Exception exception) {}
/*     */     
/* 117 */     return pA_TS_DTEIndicated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_DTEHVBattIndicated getPA_TS_DTEHVBattIndicated() throws CarNotConnectedException {
/* 126 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33769, 1);
/*     */     
/* 128 */     PATypes.PA_TS_DTEHVBattIndicated pA_TS_DTEHVBattIndicated = null;
/*     */     try {
/* 130 */       PATypes.PA_TS_DTEHVBattIndicated pA_TS_DTEHVBattIndicated1 = new PATypes.PA_TS_DTEHVBattIndicated(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_DTEHVBattIndicated = pA_TS_DTEHVBattIndicated1;
/* 131 */     } catch (Exception exception) {}
/*     */     
/* 133 */     return pA_TS_DTEHVBattIndicated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_DTEHV_round getPA_TS_DTEHV_round() throws CarNotConnectedException {
/* 142 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33770, 1);
/*     */     
/* 144 */     PATypes.PA_TS_DTEHV_round pA_TS_DTEHV_round = null;
/*     */     try {
/* 146 */       PATypes.PA_TS_DTEHV_round pA_TS_DTEHV_round1 = new PATypes.PA_TS_DTEHV_round(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_DTEHV_round = pA_TS_DTEHV_round1;
/* 147 */     } catch (Exception exception) {}
/*     */     
/* 149 */     return pA_TS_DTEHV_round;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_EDT_time2 getPA_TS_EDT_time2() throws CarNotConnectedException {
/* 158 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33771, 1);
/*     */     
/* 160 */     PATypes.PA_TS_EDT_time2 pA_TS_EDT_time2 = null;
/*     */     try {
/* 162 */       PATypes.PA_TS_EDT_time2 pA_TS_EDT_time21 = new PATypes.PA_TS_EDT_time2(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_EDT_time2 = pA_TS_EDT_time21;
/* 163 */     } catch (Exception exception) {}
/*     */     
/* 165 */     return pA_TS_EDT_time2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_Zero_Emission getPA_TS_Zero_Emission() throws CarNotConnectedException {
/* 174 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33772, 1);
/*     */     
/* 176 */     PATypes.PA_TS_Zero_Emission pA_TS_Zero_Emission = null;
/*     */     try {
/* 178 */       PATypes.PA_TS_Zero_Emission pA_TS_Zero_Emission1 = new PATypes.PA_TS_Zero_Emission(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_Zero_Emission = pA_TS_Zero_Emission1;
/* 179 */     } catch (Exception exception) {}
/*     */     
/* 181 */     return pA_TS_Zero_Emission;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_OdometerTripMeter2 getPA_TS_OdometerTripMeter2() throws CarNotConnectedException {
/* 190 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33773, 1);
/*     */     
/* 192 */     PATypes.PA_TS_OdometerTripMeter2 pA_TS_OdometerTripMeter2 = null;
/*     */     try {
/* 194 */       PATypes.PA_TS_OdometerTripMeter2 pA_TS_OdometerTripMeter21 = new PATypes.PA_TS_OdometerTripMeter2(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_OdometerTripMeter2 = pA_TS_OdometerTripMeter21;
/* 195 */     } catch (Exception exception) {}
/*     */     
/* 197 */     return pA_TS_OdometerTripMeter2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_TripAverageConsumption05Km getPA_TS_TripAverageConsumption05Km() throws CarNotConnectedException {
/* 206 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33774, 1);
/*     */     
/* 208 */     PATypes.PA_TS_TripAverageConsumption05Km pA_TS_TripAverageConsumption05Km = null;
/*     */     try {
/* 210 */       PATypes.PA_TS_TripAverageConsumption05Km pA_TS_TripAverageConsumption05Km1 = new PATypes.PA_TS_TripAverageConsumption05Km(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_TripAverageConsumption05Km = pA_TS_TripAverageConsumption05Km1;
/* 211 */     } catch (Exception exception) {}
/*     */     
/* 213 */     return pA_TS_TripAverageConsumption05Km;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_TripAverageConsumption5Km getPA_TS_TripAverageConsumption5Km() throws CarNotConnectedException {
/* 222 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33775, 1);
/*     */     
/* 224 */     PATypes.PA_TS_TripAverageConsumption5Km pA_TS_TripAverageConsumption5Km = null;
/*     */     try {
/* 226 */       PATypes.PA_TS_TripAverageConsumption5Km pA_TS_TripAverageConsumption5Km1 = new PATypes.PA_TS_TripAverageConsumption5Km(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_TripAverageConsumption5Km = pA_TS_TripAverageConsumption5Km1;
/* 227 */     } catch (Exception exception) {}
/*     */     
/* 229 */     return pA_TS_TripAverageConsumption5Km;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_TripAverageEnConsumption05Km getPA_TS_TripAverageEnConsumption05Km() throws CarNotConnectedException {
/* 238 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33776, 1);
/*     */     
/* 240 */     PATypes.PA_TS_TripAverageEnConsumption05Km pA_TS_TripAverageEnConsumption05Km = null;
/*     */     try {
/* 242 */       PATypes.PA_TS_TripAverageEnConsumption05Km pA_TS_TripAverageEnConsumption05Km1 = new PATypes.PA_TS_TripAverageEnConsumption05Km(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_TripAverageEnConsumption05Km = pA_TS_TripAverageEnConsumption05Km1;
/* 243 */     } catch (Exception exception) {}
/*     */     
/* 245 */     return pA_TS_TripAverageEnConsumption05Km;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_TripAverageEnConsumption5Km getPA_TS_TripAverageEnConsumption5Km() throws CarNotConnectedException {
/* 254 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33777, 1);
/*     */     
/* 256 */     PATypes.PA_TS_TripAverageEnConsumption5Km pA_TS_TripAverageEnConsumption5Km = null;
/*     */     try {
/* 258 */       PATypes.PA_TS_TripAverageEnConsumption5Km pA_TS_TripAverageEnConsumption5Km1 = new PATypes.PA_TS_TripAverageEnConsumption5Km(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_TripAverageEnConsumption5Km = pA_TS_TripAverageEnConsumption5Km1;
/* 259 */     } catch (Exception exception) {}
/*     */     
/* 261 */     return pA_TS_TripAverageEnConsumption5Km;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_fuelStats10 getPA_TS_fuelStats10() throws CarNotConnectedException {
/* 270 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33778, 1);
/*     */     
/* 272 */     PATypes.PA_TS_fuelStats10 pA_TS_fuelStats10 = null;
/*     */     try {
/* 274 */       PATypes.PA_TS_fuelStats10 pA_TS_fuelStats101 = new PATypes.PA_TS_fuelStats10(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_TS_fuelStats10 = pA_TS_fuelStats101;
/* 275 */     } catch (Exception exception) {}
/*     */     
/* 277 */     return pA_TS_fuelStats10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_fuelStats100 getPA_TS_fuelStats100() throws CarNotConnectedException {
/* 286 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33779, 1);
/*     */     
/* 288 */     PATypes.PA_TS_fuelStats100 pA_TS_fuelStats100 = null;
/*     */     try {
/* 290 */       PATypes.PA_TS_fuelStats100 pA_TS_fuelStats1001 = new PATypes.PA_TS_fuelStats100(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_TS_fuelStats100 = pA_TS_fuelStats1001;
/* 291 */     } catch (Exception exception) {}
/*     */     
/* 293 */     return pA_TS_fuelStats100;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_energyStats10 getPA_TS_energyStats10() throws CarNotConnectedException {
/* 302 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33780, 1);
/*     */     
/* 304 */     PATypes.PA_TS_energyStats10 pA_TS_energyStats10 = null;
/*     */     try {
/* 306 */       PATypes.PA_TS_energyStats10 pA_TS_energyStats101 = new PATypes.PA_TS_energyStats10(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_TS_energyStats10 = pA_TS_energyStats101;
/* 307 */     } catch (Exception exception) {}
/*     */     
/* 309 */     return pA_TS_energyStats10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_energyStats100 getPA_TS_energyStats100() throws CarNotConnectedException {
/* 318 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33781, 1);
/*     */     
/* 320 */     PATypes.PA_TS_energyStats100 pA_TS_energyStats100 = null;
/*     */     try {
/* 322 */       PATypes.PA_TS_energyStats100 pA_TS_energyStats1001 = new PATypes.PA_TS_energyStats100(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_TS_energyStats100 = pA_TS_energyStats1001;
/* 323 */     } catch (Exception exception) {}
/*     */     
/* 325 */     return pA_TS_energyStats100;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_energyReStats10 getPA_TS_energyReStats10() throws CarNotConnectedException {
/* 334 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33782, 1);
/*     */     
/* 336 */     PATypes.PA_TS_energyReStats10 pA_TS_energyReStats10 = null;
/*     */     try {
/* 338 */       PATypes.PA_TS_energyReStats10 pA_TS_energyReStats101 = new PATypes.PA_TS_energyReStats10(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_TS_energyReStats10 = pA_TS_energyReStats101;
/* 339 */     } catch (Exception exception) {}
/*     */     
/* 341 */     return pA_TS_energyReStats10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_energyReStats100 getPA_TS_energyReStats100() throws CarNotConnectedException {
/* 350 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33783, 1);
/*     */     
/* 352 */     PATypes.PA_TS_energyReStats100 pA_TS_energyReStats100 = null;
/*     */     try {
/* 354 */       PATypes.PA_TS_energyReStats100 pA_TS_energyReStats1001 = new PATypes.PA_TS_energyReStats100(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_TS_energyReStats100 = pA_TS_energyReStats1001;
/* 355 */     } catch (Exception exception) {}
/*     */     
/* 357 */     return pA_TS_energyReStats100;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_MsgEnd getPA_TS_MsgEnd() throws CarNotConnectedException {
/* 366 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33903, 1);
/*     */     
/* 368 */     PATypes.PA_TS_MsgEnd pA_TS_MsgEnd = null;
/*     */     try {
/* 370 */       PATypes.PA_TS_MsgEnd pA_TS_MsgEnd1 = new PATypes.PA_TS_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_MsgEnd = pA_TS_MsgEnd1;
/* 371 */     } catch (Exception exception) {}
/*     */     
/* 373 */     return pA_TS_MsgEnd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_CurTripDis getPA_TS_CurTripDis() throws CarNotConnectedException {
/* 382 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33934, 1);
/*     */     
/* 384 */     PATypes.PA_TS_CurTripDis pA_TS_CurTripDis = null;
/*     */     try {
/* 386 */       PATypes.PA_TS_CurTripDis pA_TS_CurTripDis1 = new PATypes.PA_TS_CurTripDis(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_CurTripDis = pA_TS_CurTripDis1;
/* 387 */     } catch (Exception exception) {}
/*     */     
/* 389 */     return pA_TS_CurTripDis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TS_CurTripTime getPA_TS_CurTripTime() throws CarNotConnectedException {
/* 398 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33935, 1);
/*     */     
/* 400 */     PATypes.PA_TS_CurTripTime pA_TS_CurTripTime = null;
/*     */     try {
/* 402 */       PATypes.PA_TS_CurTripTime pA_TS_CurTripTime1 = new PATypes.PA_TS_CurTripTime(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TS_CurTripTime = pA_TS_CurTripTime1;
/* 403 */     } catch (Exception exception) {}
/*     */     
/* 405 */     return pA_TS_CurTripTime;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarPhevManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */