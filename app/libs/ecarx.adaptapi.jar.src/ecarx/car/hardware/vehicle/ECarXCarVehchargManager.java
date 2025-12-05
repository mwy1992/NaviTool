/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.DisChrgrSW;
/*     */ import ecarx.car.hardware.annotation.IdleEnaDis;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.annotation.OnOffNoReq;
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
/*     */ public class ECarXCarVehchargManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbvehchargchargelight = 33193;
/*     */   public static final int ManagerId_cbvehchargchargingcolumn = 33280;
/*     */   public static final int ManagerId_cbvehchargchargst = 33190;
/*     */   public static final int ManagerId_cbvehchargdchaengstsctrl = 33195;
/*     */   public static final int ManagerId_cbvehchargdischargeswitch = 33194;
/*     */   public static final int ManagerId_cbvehchargdischargsoc = 33191;
/*     */   public static final int ManagerId_cbvehchargdischargst = 33192;
/*     */   public static final int ManagerId_cbvehchargreboot = 33196;
/*     */   public static final int ManagerId_cbvehchargseta = 33188;
/*     */   public static final int ManagerId_cbvehchargsetsoc = 33189;
/*     */   public static final int ManagerId_pavehchargappointment = 33790;
/*     */   public static final int ManagerId_pavehchargcharginfoshow = 33788;
/*     */   public static final int ManagerId_pavehchargchargingcolumn = 33963;
/*     */   public static final int ManagerId_pavehchargcharglight = 33789;
/*     */   public static final int ManagerId_pavehchargchargremind = 33784;
/*     */   public static final int ManagerId_pavehchargchargst = 33787;
/*     */   public static final int ManagerId_pavehchargchrgnordischrgnstsfb = 33803;
/*     */   public static final int ManagerId_pavehchargdchaegyact = 33798;
/*     */   public static final int ManagerId_pavehchargdchaiact = 33796;
/*     */   public static final int ManagerId_pavehchargdchauact = 33795;
/*     */   public static final int ManagerId_pavehchargdischargerecord = 33794;
/*     */   public static final int ManagerId_pavehchargdischargeswitch = 33793;
/*     */   public static final int ManagerId_pavehchargdischarginfoshow = 33792;
/*     */   public static final int ManagerId_pavehchargdischargsoc = 33791;
/*     */   public static final int ManagerId_pavehchargdisphvbattlvlofchrg = 33799;
/*     */   public static final int ManagerId_pavehcharghvbattchrgntiestimd = 33802;
/*     */   public static final int ManagerId_pavehcharghvbattdchatiestimd = 33797;
/*     */   public static final int ManagerId_pavehchargmsgend = 33921;
/*     */   public static final int ManagerId_pavehchargonbdchrgriact = 33801;
/*     */   public static final int ManagerId_pavehchargonbdchrgruact = 33800;
/*     */   public static final int ManagerId_pavehchargseta = 33785;
/*     */   public static final int ManagerId_pavehchargsetsoc = 33786;
/*     */   private static final String TAG = "ECarXCarVehchargManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarVehchargManager() {}
/*     */   
/*     */   public ECarXCarVehchargManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  87 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_SetA(int paramInt) {
/*  97 */     return this.mMgr.setIntProperty(33188, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_SetSOC(int paramInt) {
/* 107 */     return this.mMgr.setIntProperty(33189, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_ChargSt(int paramInt) {
/* 117 */     ApiResult apiResult = ApiResult.FAILED;
/* 118 */     if (OnOffNoReq.isValid(paramInt)) {
/* 119 */       apiResult = this.mMgr.setIntProperty(33190, 1, paramInt);
/*     */     } else {
/* 121 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 123 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_DisChargSOC(int paramInt) {
/* 133 */     return this.mMgr.setIntProperty(33191, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_DisChargSt(int paramInt) {
/* 143 */     ApiResult apiResult = ApiResult.FAILED;
/* 144 */     if (OnOffNoReq.isValid(paramInt)) {
/* 145 */       apiResult = this.mMgr.setIntProperty(33192, 1, paramInt);
/*     */     } else {
/* 147 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 149 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_ChargeLight(int paramInt) {
/* 159 */     ApiResult apiResult = ApiResult.FAILED;
/* 160 */     if (OnOffNoReq.isValid(paramInt)) {
/* 161 */       apiResult = this.mMgr.setIntProperty(33193, 1, paramInt);
/*     */     } else {
/* 163 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 165 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_DisChargeSwitch(int paramInt) {
/* 175 */     ApiResult apiResult = ApiResult.FAILED;
/* 176 */     if (DisChrgrSW.isValid(paramInt)) {
/* 177 */       apiResult = this.mMgr.setIntProperty(33194, 1, paramInt);
/*     */     } else {
/* 179 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 181 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_DChaEngStsCtrl(int paramInt) {
/* 191 */     ApiResult apiResult = ApiResult.FAILED;
/* 192 */     if (IdleEnaDis.isValid(paramInt)) {
/* 193 */       apiResult = this.mMgr.setIntProperty(33195, 1, paramInt);
/*     */     } else {
/* 195 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 197 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_Reboot(int paramInt) {
/* 207 */     return this.mMgr.setIntProperty(33196, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VehCharg_ChargingColumn(int paramInt) {
/* 217 */     ApiResult apiResult = ApiResult.FAILED;
/* 218 */     if (OnOff1.isValid(paramInt)) {
/* 219 */       apiResult = this.mMgr.setIntProperty(33280, 1, paramInt);
/*     */     } else {
/* 221 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 223 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_ChargRemind getPA_VehCharg_ChargRemind() throws CarNotConnectedException {
/* 234 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33784, 1);
/*     */     
/* 236 */     PATypes.PA_VehCharg_ChargRemind pA_VehCharg_ChargRemind = null;
/*     */     try {
/* 238 */       PATypes.PA_VehCharg_ChargRemind pA_VehCharg_ChargRemind1 = new PATypes.PA_VehCharg_ChargRemind(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_ChargRemind = pA_VehCharg_ChargRemind1;
/* 239 */     } catch (Exception exception) {}
/*     */     
/* 241 */     return pA_VehCharg_ChargRemind;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_SetA getPA_VehCharg_SetA() throws CarNotConnectedException {
/* 250 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33785, 1);
/*     */     
/* 252 */     PATypes.PA_VehCharg_SetA pA_VehCharg_SetA = null;
/*     */     try {
/* 254 */       PATypes.PA_VehCharg_SetA pA_VehCharg_SetA1 = new PATypes.PA_VehCharg_SetA(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_SetA = pA_VehCharg_SetA1;
/* 255 */     } catch (Exception exception) {}
/*     */     
/* 257 */     return pA_VehCharg_SetA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_SetSOC getPA_VehCharg_SetSOC() throws CarNotConnectedException {
/* 266 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33786, 1);
/*     */     
/* 268 */     PATypes.PA_VehCharg_SetSOC pA_VehCharg_SetSOC = null;
/*     */     try {
/* 270 */       PATypes.PA_VehCharg_SetSOC pA_VehCharg_SetSOC1 = new PATypes.PA_VehCharg_SetSOC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_SetSOC = pA_VehCharg_SetSOC1;
/* 271 */     } catch (Exception exception) {}
/*     */     
/* 273 */     return pA_VehCharg_SetSOC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_ChargSt getPA_VehCharg_ChargSt() throws CarNotConnectedException {
/* 282 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33787, 1);
/*     */     
/* 284 */     PATypes.PA_VehCharg_ChargSt pA_VehCharg_ChargSt = null;
/*     */     try {
/* 286 */       PATypes.PA_VehCharg_ChargSt pA_VehCharg_ChargSt1 = new PATypes.PA_VehCharg_ChargSt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_ChargSt = pA_VehCharg_ChargSt1;
/* 287 */     } catch (Exception exception) {}
/*     */     
/* 289 */     return pA_VehCharg_ChargSt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_ChargInfoShow getPA_VehCharg_ChargInfoShow() throws CarNotConnectedException {
/* 298 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33788, 1);
/*     */     
/* 300 */     PATypes.PA_VehCharg_ChargInfoShow pA_VehCharg_ChargInfoShow = null;
/*     */     try {
/* 302 */       PATypes.PA_VehCharg_ChargInfoShow pA_VehCharg_ChargInfoShow1 = new PATypes.PA_VehCharg_ChargInfoShow(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_ChargInfoShow = pA_VehCharg_ChargInfoShow1;
/* 303 */     } catch (Exception exception) {}
/*     */     
/* 305 */     return pA_VehCharg_ChargInfoShow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_ChargLight getPA_VehCharg_ChargLight() throws CarNotConnectedException {
/* 314 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33789, 1);
/*     */     
/* 316 */     PATypes.PA_VehCharg_ChargLight pA_VehCharg_ChargLight = null;
/*     */     try {
/* 318 */       PATypes.PA_VehCharg_ChargLight pA_VehCharg_ChargLight1 = new PATypes.PA_VehCharg_ChargLight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_ChargLight = pA_VehCharg_ChargLight1;
/* 319 */     } catch (Exception exception) {}
/*     */     
/* 321 */     return pA_VehCharg_ChargLight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_Appointment getPA_VehCharg_Appointment() throws CarNotConnectedException {
/* 330 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33790, 1);
/*     */     
/* 332 */     PATypes.PA_VehCharg_Appointment pA_VehCharg_Appointment = null;
/*     */     try {
/* 334 */       PATypes.PA_VehCharg_Appointment pA_VehCharg_Appointment1 = new PATypes.PA_VehCharg_Appointment(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_Appointment = pA_VehCharg_Appointment1;
/* 335 */     } catch (Exception exception) {}
/*     */     
/* 337 */     return pA_VehCharg_Appointment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DisChargSOC getPA_VehCharg_DisChargSOC() throws CarNotConnectedException {
/* 346 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33791, 1);
/*     */     
/* 348 */     PATypes.PA_VehCharg_DisChargSOC pA_VehCharg_DisChargSOC = null;
/*     */     try {
/* 350 */       PATypes.PA_VehCharg_DisChargSOC pA_VehCharg_DisChargSOC1 = new PATypes.PA_VehCharg_DisChargSOC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_DisChargSOC = pA_VehCharg_DisChargSOC1;
/* 351 */     } catch (Exception exception) {}
/*     */     
/* 353 */     return pA_VehCharg_DisChargSOC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DisChargInfoShow getPA_VehCharg_DisChargInfoShow() throws CarNotConnectedException {
/* 362 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33792, 1);
/*     */     
/* 364 */     PATypes.PA_VehCharg_DisChargInfoShow pA_VehCharg_DisChargInfoShow = null;
/*     */     try {
/* 366 */       PATypes.PA_VehCharg_DisChargInfoShow pA_VehCharg_DisChargInfoShow1 = new PATypes.PA_VehCharg_DisChargInfoShow(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_DisChargInfoShow = pA_VehCharg_DisChargInfoShow1;
/* 367 */     } catch (Exception exception) {}
/*     */     
/* 369 */     return pA_VehCharg_DisChargInfoShow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DisChargeSwitch getPA_VehCharg_DisChargeSwitch() throws CarNotConnectedException {
/* 378 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33793, 1);
/*     */     
/* 380 */     PATypes.PA_VehCharg_DisChargeSwitch pA_VehCharg_DisChargeSwitch = null;
/*     */     try {
/* 382 */       PATypes.PA_VehCharg_DisChargeSwitch pA_VehCharg_DisChargeSwitch1 = new PATypes.PA_VehCharg_DisChargeSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_DisChargeSwitch = pA_VehCharg_DisChargeSwitch1;
/* 383 */     } catch (Exception exception) {}
/*     */     
/* 385 */     return pA_VehCharg_DisChargeSwitch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DisChargeRecord getPA_VehCharg_DisChargeRecord() throws CarNotConnectedException {
/* 394 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33794, 1);
/*     */     
/* 396 */     PATypes.PA_VehCharg_DisChargeRecord pA_VehCharg_DisChargeRecord = null;
/*     */     try {
/* 398 */       PATypes.PA_VehCharg_DisChargeRecord pA_VehCharg_DisChargeRecord1 = new PATypes.PA_VehCharg_DisChargeRecord(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_VehCharg_DisChargeRecord = pA_VehCharg_DisChargeRecord1;
/* 399 */     } catch (Exception exception) {}
/*     */     
/* 401 */     return pA_VehCharg_DisChargeRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DchaUAct getPA_VehCharg_DchaUAct() throws CarNotConnectedException {
/* 410 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33795, 1);
/*     */     
/* 412 */     PATypes.PA_VehCharg_DchaUAct pA_VehCharg_DchaUAct = null;
/*     */     try {
/* 414 */       PATypes.PA_VehCharg_DchaUAct pA_VehCharg_DchaUAct1 = new PATypes.PA_VehCharg_DchaUAct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_DchaUAct = pA_VehCharg_DchaUAct1;
/* 415 */     } catch (Exception exception) {}
/*     */     
/* 417 */     return pA_VehCharg_DchaUAct;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DchaIAct getPA_VehCharg_DchaIAct() throws CarNotConnectedException {
/* 426 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33796, 1);
/*     */     
/* 428 */     PATypes.PA_VehCharg_DchaIAct pA_VehCharg_DchaIAct = null;
/*     */     try {
/* 430 */       PATypes.PA_VehCharg_DchaIAct pA_VehCharg_DchaIAct1 = new PATypes.PA_VehCharg_DchaIAct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_DchaIAct = pA_VehCharg_DchaIAct1;
/* 431 */     } catch (Exception exception) {}
/*     */     
/* 433 */     return pA_VehCharg_DchaIAct;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_HvBattDchaTiEstimd getPA_VehCharg_HvBattDchaTiEstimd() throws CarNotConnectedException {
/* 442 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33797, 1);
/*     */     
/* 444 */     PATypes.PA_VehCharg_HvBattDchaTiEstimd pA_VehCharg_HvBattDchaTiEstimd = null;
/*     */     try {
/* 446 */       PATypes.PA_VehCharg_HvBattDchaTiEstimd pA_VehCharg_HvBattDchaTiEstimd1 = new PATypes.PA_VehCharg_HvBattDchaTiEstimd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_HvBattDchaTiEstimd = pA_VehCharg_HvBattDchaTiEstimd1;
/* 447 */     } catch (Exception exception) {}
/*     */     
/* 449 */     return pA_VehCharg_HvBattDchaTiEstimd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DchaEgyAct getPA_VehCharg_DchaEgyAct() throws CarNotConnectedException {
/* 458 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33798, 1);
/*     */     
/* 460 */     PATypes.PA_VehCharg_DchaEgyAct pA_VehCharg_DchaEgyAct = null;
/*     */     try {
/* 462 */       PATypes.PA_VehCharg_DchaEgyAct pA_VehCharg_DchaEgyAct1 = new PATypes.PA_VehCharg_DchaEgyAct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_DchaEgyAct = pA_VehCharg_DchaEgyAct1;
/* 463 */     } catch (Exception exception) {}
/*     */     
/* 465 */     return pA_VehCharg_DchaEgyAct;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_DispHvBattLvlOfChrg getPA_VehCharg_DispHvBattLvlOfChrg() throws CarNotConnectedException {
/* 474 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33799, 1);
/*     */     
/* 476 */     PATypes.PA_VehCharg_DispHvBattLvlOfChrg pA_VehCharg_DispHvBattLvlOfChrg = null;
/*     */     try {
/* 478 */       PATypes.PA_VehCharg_DispHvBattLvlOfChrg pA_VehCharg_DispHvBattLvlOfChrg1 = new PATypes.PA_VehCharg_DispHvBattLvlOfChrg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_DispHvBattLvlOfChrg = pA_VehCharg_DispHvBattLvlOfChrg1;
/* 479 */     } catch (Exception exception) {}
/*     */     
/* 481 */     return pA_VehCharg_DispHvBattLvlOfChrg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_OnBdChrgrUAct getPA_VehCharg_OnBdChrgrUAct() throws CarNotConnectedException {
/* 490 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33800, 1);
/*     */     
/* 492 */     PATypes.PA_VehCharg_OnBdChrgrUAct pA_VehCharg_OnBdChrgrUAct = null;
/*     */     try {
/* 494 */       PATypes.PA_VehCharg_OnBdChrgrUAct pA_VehCharg_OnBdChrgrUAct1 = new PATypes.PA_VehCharg_OnBdChrgrUAct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_OnBdChrgrUAct = pA_VehCharg_OnBdChrgrUAct1;
/* 495 */     } catch (Exception exception) {}
/*     */     
/* 497 */     return pA_VehCharg_OnBdChrgrUAct;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_OnBdChrgrIAct getPA_VehCharg_OnBdChrgrIAct() throws CarNotConnectedException {
/* 506 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33801, 1);
/*     */     
/* 508 */     PATypes.PA_VehCharg_OnBdChrgrIAct pA_VehCharg_OnBdChrgrIAct = null;
/*     */     try {
/* 510 */       PATypes.PA_VehCharg_OnBdChrgrIAct pA_VehCharg_OnBdChrgrIAct1 = new PATypes.PA_VehCharg_OnBdChrgrIAct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_OnBdChrgrIAct = pA_VehCharg_OnBdChrgrIAct1;
/* 511 */     } catch (Exception exception) {}
/*     */     
/* 513 */     return pA_VehCharg_OnBdChrgrIAct;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_HvBattChrgnTiEstimd getPA_VehCharg_HvBattChrgnTiEstimd() throws CarNotConnectedException {
/* 522 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33802, 1);
/*     */     
/* 524 */     PATypes.PA_VehCharg_HvBattChrgnTiEstimd pA_VehCharg_HvBattChrgnTiEstimd = null;
/*     */     try {
/* 526 */       PATypes.PA_VehCharg_HvBattChrgnTiEstimd pA_VehCharg_HvBattChrgnTiEstimd1 = new PATypes.PA_VehCharg_HvBattChrgnTiEstimd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_HvBattChrgnTiEstimd = pA_VehCharg_HvBattChrgnTiEstimd1;
/* 527 */     } catch (Exception exception) {}
/*     */     
/* 529 */     return pA_VehCharg_HvBattChrgnTiEstimd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb getPA_VehCharg_ChrgnOrDisChrgnStsFb() throws CarNotConnectedException {
/* 538 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33803, 1);
/*     */     
/* 540 */     PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb pA_VehCharg_ChrgnOrDisChrgnStsFb = null;
/*     */     try {
/* 542 */       PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb pA_VehCharg_ChrgnOrDisChrgnStsFb1 = new PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_ChrgnOrDisChrgnStsFb = pA_VehCharg_ChrgnOrDisChrgnStsFb1;
/* 543 */     } catch (Exception exception) {}
/*     */     
/* 545 */     return pA_VehCharg_ChrgnOrDisChrgnStsFb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_MsgEnd getPA_VehCharg_MsgEnd() throws CarNotConnectedException {
/* 554 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33921, 1);
/*     */     
/* 556 */     PATypes.PA_VehCharg_MsgEnd pA_VehCharg_MsgEnd = null;
/*     */     try {
/* 558 */       PATypes.PA_VehCharg_MsgEnd pA_VehCharg_MsgEnd1 = new PATypes.PA_VehCharg_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_MsgEnd = pA_VehCharg_MsgEnd1;
/* 559 */     } catch (Exception exception) {}
/*     */     
/* 561 */     return pA_VehCharg_MsgEnd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VehCharg_ChargingColumn getPA_VehCharg_ChargingColumn() throws CarNotConnectedException {
/* 570 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33963, 1);
/*     */     
/* 572 */     PATypes.PA_VehCharg_ChargingColumn pA_VehCharg_ChargingColumn = null;
/*     */     try {
/* 574 */       PATypes.PA_VehCharg_ChargingColumn pA_VehCharg_ChargingColumn1 = new PATypes.PA_VehCharg_ChargingColumn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VehCharg_ChargingColumn = pA_VehCharg_ChargingColumn1;
/* 575 */     } catch (Exception exception) {}
/*     */     
/* 577 */     return pA_VehCharg_ChargingColumn;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVehchargManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */