/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.PinType;
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
/*     */ public class ECarXCarDiagdidManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbappartitionpercentage = 33159;
/*     */   public static final int ManagerId_cbcsdmonitoren = 33155;
/*     */   public static final int ManagerId_cbcsdmpsden = 33161;
/*     */   public static final int ManagerId_cbd0d0 = 33163;
/*     */   public static final int ManagerId_cbd0d1 = 33164;
/*     */   public static final int ManagerId_cbd907 = 33162;
/*     */   public static final int ManagerId_cbdcmd903paswamvideoin = 33150;
/*     */   public static final int ManagerId_cbdcmd904dvrvideoin = 33151;
/*     */   public static final int ManagerId_cbdcmd905gesturevideoin = 33152;
/*     */   public static final int ManagerId_cbdcmd906chatvideoin = 33153;
/*     */   public static final int ManagerId_cbdcmd912psdmonitoren = 33154;
/*     */   public static final int ManagerId_cbdiagdidreboot = 33165;
/*     */   public static final int ManagerId_cbihuconnectedwifiname = 33156;
/*     */   public static final int ManagerId_cbihuwificonnection = 33158;
/*     */   public static final int ManagerId_cbmanufacturingdidrequest = 33160;
/*     */   public static final int ManagerId_cbrvdcstatu = 33157;
/*     */   public static final int ManagerId_pachatvideoin = 33728;
/*     */   public static final int ManagerId_pacsdmonitoren = 33724;
/*     */   public static final int ManagerId_pacsdmpsden = 33740;
/*     */   public static final int ManagerId_pad907 = 33739;
/*     */   public static final int ManagerId_padcmd912psdmonitoren = 33729;
/*     */   public static final int ManagerId_padidmsgend = 33906;
/*     */   public static final int ManagerId_padvrvideoin = 33726;
/*     */   public static final int ManagerId_pageelydeliveryassemblereading = 33734;
/*     */   public static final int ManagerId_pageelyhswdreading = 33735;
/*     */   public static final int ManagerId_pagesturevideoin = 33727;
/*     */   public static final int ManagerId_pahwversionreading = 33733;
/*     */   public static final int ManagerId_paihuidreading = 33732;
/*     */   public static final int ManagerId_pamanufacturingsignal = 33738;
/*     */   public static final int ManagerId_papaswamvideoin = 33725;
/*     */   public static final int ManagerId_paproductserialnumber = 33730;
/*     */   public static final int ManagerId_pavolvodeliveryassemblereading = 33736;
/*     */   public static final int ManagerId_pavolvohwsdreading = 33737;
/*     */   public static final int ManagerId_paxdsnreading = 33731;
/*     */   private static final String TAG = "ECarXCarDiagdidManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDiagdidManager() {}
/*     */   
/*     */   public ECarXCarDiagdidManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  86 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dcm_D903_PAS_WAM_Video_in(int paramInt) {
/*  96 */     ApiResult apiResult = ApiResult.FAILED;
/*  97 */     if (PinType.isValid(paramInt)) {
/*  98 */       apiResult = this.mMgr.setIntProperty(33150, 1, paramInt);
/*     */     } else {
/* 100 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 102 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dcm_D904_DVR_Video_IN(int paramInt) {
/* 112 */     ApiResult apiResult = ApiResult.FAILED;
/* 113 */     if (PinType.isValid(paramInt)) {
/* 114 */       apiResult = this.mMgr.setIntProperty(33151, 1, paramInt);
/*     */     } else {
/* 116 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 118 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dcm_D905_Gesture_Video_IN(int paramInt) {
/* 128 */     ApiResult apiResult = ApiResult.FAILED;
/* 129 */     if (PinType.isValid(paramInt)) {
/* 130 */       apiResult = this.mMgr.setIntProperty(33152, 1, paramInt);
/*     */     } else {
/* 132 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 134 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dcm_D906_Chat_Video_IN(int paramInt) {
/* 144 */     ApiResult apiResult = ApiResult.FAILED;
/* 145 */     if (PinType.isValid(paramInt)) {
/* 146 */       apiResult = this.mMgr.setIntProperty(33153, 1, paramInt);
/*     */     } else {
/* 148 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 150 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Dcm_D912_PSD_MONITOR_EN(int paramInt) {
/* 160 */     ApiResult apiResult = ApiResult.FAILED;
/* 161 */     if (PinType.isValid(paramInt)) {
/* 162 */       apiResult = this.mMgr.setIntProperty(33154, 1, paramInt);
/*     */     } else {
/* 164 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 166 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_CSD_MONITOR_EN(int paramInt) {
/* 176 */     ApiResult apiResult = ApiResult.FAILED;
/* 177 */     if (PinType.isValid(paramInt)) {
/* 178 */       apiResult = this.mMgr.setIntProperty(33155, 1, paramInt);
/*     */     } else {
/* 180 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 182 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_IHU_connected_WIFI_NAME(byte[] paramArrayOfbyte) {
/* 191 */     this.mMgr.setbytesProperty(33156, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_RVDC_Statu(byte[] paramArrayOfbyte) {
/* 200 */     this.mMgr.setbytesProperty(33157, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_IHU_WIFI_connection(int paramInt) {
/* 210 */     return this.mMgr.setIntProperty(33158, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_AP_partition_percentage(byte[] paramArrayOfbyte) {
/* 219 */     this.mMgr.setbytesProperty(33159, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Manufacturing_DID_Request(int paramInt) {
/* 229 */     return this.mMgr.setIntProperty(33160, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_CSDM_PSD_EN(int paramInt) {
/* 239 */     return this.mMgr.setIntProperty(33161, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_D907(int paramInt) {
/* 249 */     return this.mMgr.setIntProperty(33162, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_D0D0(byte[] paramArrayOfbyte) {
/* 258 */     this.mMgr.setbytesProperty(33163, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_D0D1(byte[] paramArrayOfbyte) {
/* 267 */     this.mMgr.setbytesProperty(33164, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DiagDID_Reboot(int paramInt) {
/* 277 */     return this.mMgr.setIntProperty(33165, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_CSD_MONITOR_EN getPA_CSD_MONITOR_EN() throws CarNotConnectedException {
/* 288 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33724, 1);
/*     */     
/* 290 */     PATypes.PA_CSD_MONITOR_EN pA_CSD_MONITOR_EN = null;
/*     */     try {
/* 292 */       PATypes.PA_CSD_MONITOR_EN pA_CSD_MONITOR_EN1 = new PATypes.PA_CSD_MONITOR_EN(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CSD_MONITOR_EN = pA_CSD_MONITOR_EN1;
/* 293 */     } catch (Exception exception) {}
/*     */     
/* 295 */     return pA_CSD_MONITOR_EN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PASWAM_Video_in getPA_PASWAM_Video_in() throws CarNotConnectedException {
/* 304 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33725, 1);
/*     */     
/* 306 */     PATypes.PA_PASWAM_Video_in pA_PASWAM_Video_in = null;
/*     */     try {
/* 308 */       PATypes.PA_PASWAM_Video_in pA_PASWAM_Video_in1 = new PATypes.PA_PASWAM_Video_in(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PASWAM_Video_in = pA_PASWAM_Video_in1;
/* 309 */     } catch (Exception exception) {}
/*     */     
/* 311 */     return pA_PASWAM_Video_in;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DVR_Video_IN getPA_DVR_Video_IN() throws CarNotConnectedException {
/* 320 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33726, 1);
/*     */     
/* 322 */     PATypes.PA_DVR_Video_IN pA_DVR_Video_IN = null;
/*     */     try {
/* 324 */       PATypes.PA_DVR_Video_IN pA_DVR_Video_IN1 = new PATypes.PA_DVR_Video_IN(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DVR_Video_IN = pA_DVR_Video_IN1;
/* 325 */     } catch (Exception exception) {}
/*     */     
/* 327 */     return pA_DVR_Video_IN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Gesture_Video_IN getPA_Gesture_Video_IN() throws CarNotConnectedException {
/* 336 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33727, 1);
/*     */     
/* 338 */     PATypes.PA_Gesture_Video_IN pA_Gesture_Video_IN = null;
/*     */     try {
/* 340 */       PATypes.PA_Gesture_Video_IN pA_Gesture_Video_IN1 = new PATypes.PA_Gesture_Video_IN(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Gesture_Video_IN = pA_Gesture_Video_IN1;
/* 341 */     } catch (Exception exception) {}
/*     */     
/* 343 */     return pA_Gesture_Video_IN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Chat_Video_IN getPA_Chat_Video_IN() throws CarNotConnectedException {
/* 352 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33728, 1);
/*     */     
/* 354 */     PATypes.PA_Chat_Video_IN pA_Chat_Video_IN = null;
/*     */     try {
/* 356 */       PATypes.PA_Chat_Video_IN pA_Chat_Video_IN1 = new PATypes.PA_Chat_Video_IN(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Chat_Video_IN = pA_Chat_Video_IN1;
/* 357 */     } catch (Exception exception) {}
/*     */     
/* 359 */     return pA_Chat_Video_IN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Dcm_D912_PSD_MONITOR_EN getPA_Dcm_D912_PSD_MONITOR_EN() throws CarNotConnectedException {
/* 368 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33729, 1);
/*     */     
/* 370 */     PATypes.PA_Dcm_D912_PSD_MONITOR_EN pA_Dcm_D912_PSD_MONITOR_EN = null;
/*     */     try {
/* 372 */       PATypes.PA_Dcm_D912_PSD_MONITOR_EN pA_Dcm_D912_PSD_MONITOR_EN1 = new PATypes.PA_Dcm_D912_PSD_MONITOR_EN(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Dcm_D912_PSD_MONITOR_EN = pA_Dcm_D912_PSD_MONITOR_EN1;
/* 373 */     } catch (Exception exception) {}
/*     */     
/* 375 */     return pA_Dcm_D912_PSD_MONITOR_EN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Product_Serial_Number getPA_Product_Serial_Number() throws CarNotConnectedException {
/* 384 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33730, 1);
/*     */     
/* 386 */     PATypes.PA_Product_Serial_Number pA_Product_Serial_Number = null;
/*     */     try {
/* 388 */       PATypes.PA_Product_Serial_Number pA_Product_Serial_Number1 = new PATypes.PA_Product_Serial_Number(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_Product_Serial_Number = pA_Product_Serial_Number1;
/* 389 */     } catch (Exception exception) {}
/*     */     
/* 391 */     return pA_Product_Serial_Number;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_XDSN_Reading getPA_XDSN_Reading() throws CarNotConnectedException {
/* 400 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33731, 1);
/*     */     
/* 402 */     PATypes.PA_XDSN_Reading pA_XDSN_Reading = null;
/*     */     try {
/* 404 */       PATypes.PA_XDSN_Reading pA_XDSN_Reading1 = new PATypes.PA_XDSN_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_XDSN_Reading = pA_XDSN_Reading1;
/* 405 */     } catch (Exception exception) {}
/*     */     
/* 407 */     return pA_XDSN_Reading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_IHUID_Reading getPA_IHUID_Reading() throws CarNotConnectedException {
/* 416 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33732, 1);
/*     */     
/* 418 */     PATypes.PA_IHUID_Reading pA_IHUID_Reading = null;
/*     */     try {
/* 420 */       PATypes.PA_IHUID_Reading pA_IHUID_Reading1 = new PATypes.PA_IHUID_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_IHUID_Reading = pA_IHUID_Reading1;
/* 421 */     } catch (Exception exception) {}
/*     */     
/* 423 */     return pA_IHUID_Reading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_HW_Version_Reading getPA_HW_Version_Reading() throws CarNotConnectedException {
/* 432 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33733, 1);
/*     */     
/* 434 */     PATypes.PA_HW_Version_Reading pA_HW_Version_Reading = null;
/*     */     try {
/* 436 */       PATypes.PA_HW_Version_Reading pA_HW_Version_Reading1 = new PATypes.PA_HW_Version_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_HW_Version_Reading = pA_HW_Version_Reading1;
/* 437 */     } catch (Exception exception) {}
/*     */     
/* 439 */     return pA_HW_Version_Reading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Geely_Delivery_Assemble_Reading getPA_Geely_Delivery_Assemble_Reading() throws CarNotConnectedException {
/* 448 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33734, 1);
/*     */     
/* 450 */     PATypes.PA_Geely_Delivery_Assemble_Reading pA_Geely_Delivery_Assemble_Reading = null;
/*     */     try {
/* 452 */       PATypes.PA_Geely_Delivery_Assemble_Reading pA_Geely_Delivery_Assemble_Reading1 = new PATypes.PA_Geely_Delivery_Assemble_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_Geely_Delivery_Assemble_Reading = pA_Geely_Delivery_Assemble_Reading1;
/* 453 */     } catch (Exception exception) {}
/*     */     
/* 455 */     return pA_Geely_Delivery_Assemble_Reading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_GeelyHSWD_Reading getPA_GeelyHSWD_Reading() throws CarNotConnectedException {
/* 464 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33735, 1);
/*     */     
/* 466 */     PATypes.PA_GeelyHSWD_Reading pA_GeelyHSWD_Reading = null;
/*     */     try {
/* 468 */       PATypes.PA_GeelyHSWD_Reading pA_GeelyHSWD_Reading1 = new PATypes.PA_GeelyHSWD_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_GeelyHSWD_Reading = pA_GeelyHSWD_Reading1;
/* 469 */     } catch (Exception exception) {}
/*     */     
/* 471 */     return pA_GeelyHSWD_Reading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VolvoDelivery_Assemble_Reading getPA_VolvoDelivery_Assemble_Reading() throws CarNotConnectedException {
/* 480 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33736, 1);
/*     */     
/* 482 */     PATypes.PA_VolvoDelivery_Assemble_Reading pA_VolvoDelivery_Assemble_Reading = null;
/*     */     try {
/* 484 */       PATypes.PA_VolvoDelivery_Assemble_Reading pA_VolvoDelivery_Assemble_Reading1 = new PATypes.PA_VolvoDelivery_Assemble_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_VolvoDelivery_Assemble_Reading = pA_VolvoDelivery_Assemble_Reading1;
/* 485 */     } catch (Exception exception) {}
/*     */     
/* 487 */     return pA_VolvoDelivery_Assemble_Reading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VolvoHWSD_Reading getPA_VolvoHWSD_Reading() throws CarNotConnectedException {
/* 496 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33737, 1);
/*     */     
/* 498 */     PATypes.PA_VolvoHWSD_Reading pA_VolvoHWSD_Reading = null;
/*     */     try {
/* 500 */       PATypes.PA_VolvoHWSD_Reading pA_VolvoHWSD_Reading1 = new PATypes.PA_VolvoHWSD_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_VolvoHWSD_Reading = pA_VolvoHWSD_Reading1;
/* 501 */     } catch (Exception exception) {}
/*     */     
/* 503 */     return pA_VolvoHWSD_Reading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Manufacturing_Signal getPA_Manufacturing_Signal() throws CarNotConnectedException {
/* 512 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33738, 1);
/*     */     
/* 514 */     PATypes.PA_Manufacturing_Signal pA_Manufacturing_Signal = null;
/*     */     try {
/* 516 */       PATypes.PA_Manufacturing_Signal pA_Manufacturing_Signal1 = new PATypes.PA_Manufacturing_Signal(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Manufacturing_Signal = pA_Manufacturing_Signal1;
/* 517 */     } catch (Exception exception) {}
/*     */     
/* 519 */     return pA_Manufacturing_Signal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_D907 getPA_D907() throws CarNotConnectedException {
/* 528 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33739, 1);
/*     */     
/* 530 */     PATypes.PA_D907 pA_D907 = null;
/*     */     try {
/* 532 */       PATypes.PA_D907 pA_D9071 = new PATypes.PA_D907(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_D907 = pA_D9071;
/* 533 */     } catch (Exception exception) {}
/*     */     
/* 535 */     return pA_D907;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_CSDM_PSD_EN getPA_CSDM_PSD_EN() throws CarNotConnectedException {
/* 544 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33740, 1);
/*     */     
/* 546 */     PATypes.PA_CSDM_PSD_EN pA_CSDM_PSD_EN = null;
/*     */     try {
/* 548 */       PATypes.PA_CSDM_PSD_EN pA_CSDM_PSD_EN1 = new PATypes.PA_CSDM_PSD_EN(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CSDM_PSD_EN = pA_CSDM_PSD_EN1;
/* 549 */     } catch (Exception exception) {}
/*     */     
/* 551 */     return pA_CSDM_PSD_EN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DID_MsgEnd getPA_DID_MsgEnd() throws CarNotConnectedException {
/* 560 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33906, 1);
/*     */     
/* 562 */     PATypes.PA_DID_MsgEnd pA_DID_MsgEnd = null;
/*     */     try {
/* 564 */       PATypes.PA_DID_MsgEnd pA_DID_MsgEnd1 = new PATypes.PA_DID_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DID_MsgEnd = pA_DID_MsgEnd1;
/* 565 */     } catch (Exception exception) {}
/*     */     
/* 567 */     return pA_DID_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDiagdidManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */