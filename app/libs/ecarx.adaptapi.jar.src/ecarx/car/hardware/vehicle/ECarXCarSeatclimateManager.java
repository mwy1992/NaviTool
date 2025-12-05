/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.SeatClimaLvl;
/*     */ import ecarx.car.hardware.annotation.SeatClimaTmr;
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
/*     */ public class ECarXCarSeatclimateManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbschfirstlelvl = 32846;
/*     */   public static final int ManagerId_cbschfirstletmr = 32848;
/*     */   public static final int ManagerId_cbschfirstrilvl = 32847;
/*     */   public static final int ManagerId_cbschfirstritmr = 32849;
/*     */   public static final int ManagerId_cbschseclelvl = 32850;
/*     */   public static final int ManagerId_cbschsecletmr = 32852;
/*     */   public static final int ManagerId_cbschsecrilvl = 32851;
/*     */   public static final int ManagerId_cbschsecritmr = 32853;
/*     */   public static final int ManagerId_cbscvfirstlelvl = 32854;
/*     */   public static final int ManagerId_cbscvfirstletmr = 32856;
/*     */   public static final int ManagerId_cbscvfirstrilvl = 32855;
/*     */   public static final int ManagerId_cbscvfirstritmr = 32857;
/*     */   public static final int ManagerId_cbseatclimatereboot = 32858;
/*     */   public static final int ManagerId_paschfirstactvn = 33371;
/*     */   public static final int ManagerId_paschfirstleavlsts = 33381;
/*     */   public static final int ManagerId_paschfirstlelvlsts = 33373;
/*     */   public static final int ManagerId_paschfirstletmrsts = 33377;
/*     */   public static final int ManagerId_paschfirstriavlsts = 33382;
/*     */   public static final int ManagerId_paschfirstrilvlsts = 33374;
/*     */   public static final int ManagerId_paschfirstritmrsts = 33378;
/*     */   public static final int ManagerId_paschsecactvn = 33372;
/*     */   public static final int ManagerId_paschsecleavlsts = 33383;
/*     */   public static final int ManagerId_paschseclelvlsts = 33375;
/*     */   public static final int ManagerId_paschsecletmrsts = 33379;
/*     */   public static final int ManagerId_paschsecriavlsts = 33384;
/*     */   public static final int ManagerId_paschsecrilvlsts = 33376;
/*     */   public static final int ManagerId_paschsecritmrsts = 33380;
/*     */   public static final int ManagerId_pascvfirstactvn = 33385;
/*     */   public static final int ManagerId_pascvfirstleavlsts = 33390;
/*     */   public static final int ManagerId_pascvfirstlelvlsts = 33386;
/*     */   public static final int ManagerId_pascvfirstletmrsts = 33388;
/*     */   public static final int ManagerId_pascvfirstriavlsts = 33391;
/*     */   public static final int ManagerId_pascvfirstrilvlsts = 33387;
/*     */   public static final int ManagerId_pascvfirstritmrsts = 33389;
/*     */   public static final int ManagerId_pascvmsgend = 33908;
/*     */   private static final String TAG = "ECarXCarSeatclimateManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarSeatclimateManager() {}
/*     */   
/*     */   public ECarXCarSeatclimateManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  87 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_FirstLeLvl(int paramInt) {
/*  97 */     ApiResult apiResult = ApiResult.FAILED;
/*  98 */     if (SeatClimaLvl.isValid(paramInt)) {
/*  99 */       apiResult = this.mMgr.setIntProperty(32846, 1, paramInt);
/*     */     } else {
/* 101 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 103 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_FirstRiLvl(int paramInt) {
/* 113 */     ApiResult apiResult = ApiResult.FAILED;
/* 114 */     if (SeatClimaLvl.isValid(paramInt)) {
/* 115 */       apiResult = this.mMgr.setIntProperty(32847, 1, paramInt);
/*     */     } else {
/* 117 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 119 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_FirstLeTmr(int paramInt) {
/* 129 */     ApiResult apiResult = ApiResult.FAILED;
/* 130 */     if (SeatClimaTmr.isValid(paramInt)) {
/* 131 */       apiResult = this.mMgr.setIntProperty(32848, 1, paramInt);
/*     */     } else {
/* 133 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 135 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_FirstRiTmr(int paramInt) {
/* 145 */     ApiResult apiResult = ApiResult.FAILED;
/* 146 */     if (SeatClimaTmr.isValid(paramInt)) {
/* 147 */       apiResult = this.mMgr.setIntProperty(32849, 1, paramInt);
/*     */     } else {
/* 149 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 151 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_SecLeLvl(int paramInt) {
/* 161 */     ApiResult apiResult = ApiResult.FAILED;
/* 162 */     if (SeatClimaLvl.isValid(paramInt)) {
/* 163 */       apiResult = this.mMgr.setIntProperty(32850, 1, paramInt);
/*     */     } else {
/* 165 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 167 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_SecRiLvl(int paramInt) {
/* 177 */     ApiResult apiResult = ApiResult.FAILED;
/* 178 */     if (SeatClimaLvl.isValid(paramInt)) {
/* 179 */       apiResult = this.mMgr.setIntProperty(32851, 1, paramInt);
/*     */     } else {
/* 181 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 183 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_SecLeTmr(int paramInt) {
/* 193 */     ApiResult apiResult = ApiResult.FAILED;
/* 194 */     if (SeatClimaTmr.isValid(paramInt)) {
/* 195 */       apiResult = this.mMgr.setIntProperty(32852, 1, paramInt);
/*     */     } else {
/* 197 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 199 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCH_SecRiTmr(int paramInt) {
/* 209 */     ApiResult apiResult = ApiResult.FAILED;
/* 210 */     if (SeatClimaTmr.isValid(paramInt)) {
/* 211 */       apiResult = this.mMgr.setIntProperty(32853, 1, paramInt);
/*     */     } else {
/* 213 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 215 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCV_FirstLeLvl(int paramInt) {
/* 225 */     ApiResult apiResult = ApiResult.FAILED;
/* 226 */     if (SeatClimaLvl.isValid(paramInt)) {
/* 227 */       apiResult = this.mMgr.setIntProperty(32854, 1, paramInt);
/*     */     } else {
/* 229 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 231 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCV_FirstRiLvl(int paramInt) {
/* 241 */     ApiResult apiResult = ApiResult.FAILED;
/* 242 */     if (SeatClimaLvl.isValid(paramInt)) {
/* 243 */       apiResult = this.mMgr.setIntProperty(32855, 1, paramInt);
/*     */     } else {
/* 245 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 247 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCV_FirstLeTmr(int paramInt) {
/* 257 */     ApiResult apiResult = ApiResult.FAILED;
/* 258 */     if (SeatClimaTmr.isValid(paramInt)) {
/* 259 */       apiResult = this.mMgr.setIntProperty(32856, 1, paramInt);
/*     */     } else {
/* 261 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 263 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCV_FirstRiTmr(int paramInt) {
/* 273 */     ApiResult apiResult = ApiResult.FAILED;
/* 274 */     if (SeatClimaTmr.isValid(paramInt)) {
/* 275 */       apiResult = this.mMgr.setIntProperty(32857, 1, paramInt);
/*     */     } else {
/* 277 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 279 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SeatClimate_Reboot(int paramInt) {
/* 289 */     return this.mMgr.setIntProperty(32858, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_FirstActvn getPA_SCH_FirstActvn() throws CarNotConnectedException {
/* 300 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33371, 1);
/*     */     
/* 302 */     PATypes.PA_SCH_FirstActvn pA_SCH_FirstActvn = null;
/*     */     try {
/* 304 */       PATypes.PA_SCH_FirstActvn pA_SCH_FirstActvn1 = new PATypes.PA_SCH_FirstActvn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_FirstActvn = pA_SCH_FirstActvn1;
/* 305 */     } catch (Exception exception) {}
/*     */     
/* 307 */     return pA_SCH_FirstActvn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_SecActvn getPA_SCH_SecActvn() throws CarNotConnectedException {
/* 316 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33372, 1);
/*     */     
/* 318 */     PATypes.PA_SCH_SecActvn pA_SCH_SecActvn = null;
/*     */     try {
/* 320 */       PATypes.PA_SCH_SecActvn pA_SCH_SecActvn1 = new PATypes.PA_SCH_SecActvn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_SecActvn = pA_SCH_SecActvn1;
/* 321 */     } catch (Exception exception) {}
/*     */     
/* 323 */     return pA_SCH_SecActvn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_FirstLeLvlSts getPA_SCH_FirstLeLvlSts() throws CarNotConnectedException {
/* 332 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33373, 1);
/*     */     
/* 334 */     PATypes.PA_SCH_FirstLeLvlSts pA_SCH_FirstLeLvlSts = null;
/*     */     try {
/* 336 */       PATypes.PA_SCH_FirstLeLvlSts pA_SCH_FirstLeLvlSts1 = new PATypes.PA_SCH_FirstLeLvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_FirstLeLvlSts = pA_SCH_FirstLeLvlSts1;
/* 337 */     } catch (Exception exception) {}
/*     */     
/* 339 */     return pA_SCH_FirstLeLvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_FirstRiLvlSts getPA_SCH_FirstRiLvlSts() throws CarNotConnectedException {
/* 348 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33374, 1);
/*     */     
/* 350 */     PATypes.PA_SCH_FirstRiLvlSts pA_SCH_FirstRiLvlSts = null;
/*     */     try {
/* 352 */       PATypes.PA_SCH_FirstRiLvlSts pA_SCH_FirstRiLvlSts1 = new PATypes.PA_SCH_FirstRiLvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_FirstRiLvlSts = pA_SCH_FirstRiLvlSts1;
/* 353 */     } catch (Exception exception) {}
/*     */     
/* 355 */     return pA_SCH_FirstRiLvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_SecLeLvlSts getPA_SCH_SecLeLvlSts() throws CarNotConnectedException {
/* 364 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33375, 1);
/*     */     
/* 366 */     PATypes.PA_SCH_SecLeLvlSts pA_SCH_SecLeLvlSts = null;
/*     */     try {
/* 368 */       PATypes.PA_SCH_SecLeLvlSts pA_SCH_SecLeLvlSts1 = new PATypes.PA_SCH_SecLeLvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_SecLeLvlSts = pA_SCH_SecLeLvlSts1;
/* 369 */     } catch (Exception exception) {}
/*     */     
/* 371 */     return pA_SCH_SecLeLvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_SecRiLvlSts getPA_SCH_SecRiLvlSts() throws CarNotConnectedException {
/* 380 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33376, 1);
/*     */     
/* 382 */     PATypes.PA_SCH_SecRiLvlSts pA_SCH_SecRiLvlSts = null;
/*     */     try {
/* 384 */       PATypes.PA_SCH_SecRiLvlSts pA_SCH_SecRiLvlSts1 = new PATypes.PA_SCH_SecRiLvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_SecRiLvlSts = pA_SCH_SecRiLvlSts1;
/* 385 */     } catch (Exception exception) {}
/*     */     
/* 387 */     return pA_SCH_SecRiLvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_FirstLeTmrSts getPA_SCH_FirstLeTmrSts() throws CarNotConnectedException {
/* 396 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33377, 1);
/*     */     
/* 398 */     PATypes.PA_SCH_FirstLeTmrSts pA_SCH_FirstLeTmrSts = null;
/*     */     try {
/* 400 */       PATypes.PA_SCH_FirstLeTmrSts pA_SCH_FirstLeTmrSts1 = new PATypes.PA_SCH_FirstLeTmrSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_FirstLeTmrSts = pA_SCH_FirstLeTmrSts1;
/* 401 */     } catch (Exception exception) {}
/*     */     
/* 403 */     return pA_SCH_FirstLeTmrSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_FirstRiTmrSts getPA_SCH_FirstRiTmrSts() throws CarNotConnectedException {
/* 412 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33378, 1);
/*     */     
/* 414 */     PATypes.PA_SCH_FirstRiTmrSts pA_SCH_FirstRiTmrSts = null;
/*     */     try {
/* 416 */       PATypes.PA_SCH_FirstRiTmrSts pA_SCH_FirstRiTmrSts1 = new PATypes.PA_SCH_FirstRiTmrSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_FirstRiTmrSts = pA_SCH_FirstRiTmrSts1;
/* 417 */     } catch (Exception exception) {}
/*     */     
/* 419 */     return pA_SCH_FirstRiTmrSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_SecLeTmrSts getPA_SCH_SecLeTmrSts() throws CarNotConnectedException {
/* 428 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33379, 1);
/*     */     
/* 430 */     PATypes.PA_SCH_SecLeTmrSts pA_SCH_SecLeTmrSts = null;
/*     */     try {
/* 432 */       PATypes.PA_SCH_SecLeTmrSts pA_SCH_SecLeTmrSts1 = new PATypes.PA_SCH_SecLeTmrSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_SecLeTmrSts = pA_SCH_SecLeTmrSts1;
/* 433 */     } catch (Exception exception) {}
/*     */     
/* 435 */     return pA_SCH_SecLeTmrSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_SecRiTmrSts getPA_SCH_SecRiTmrSts() throws CarNotConnectedException {
/* 444 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33380, 1);
/*     */     
/* 446 */     PATypes.PA_SCH_SecRiTmrSts pA_SCH_SecRiTmrSts = null;
/*     */     try {
/* 448 */       PATypes.PA_SCH_SecRiTmrSts pA_SCH_SecRiTmrSts1 = new PATypes.PA_SCH_SecRiTmrSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_SecRiTmrSts = pA_SCH_SecRiTmrSts1;
/* 449 */     } catch (Exception exception) {}
/*     */     
/* 451 */     return pA_SCH_SecRiTmrSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_FirstLeAvlSts getPA_SCH_FirstLeAvlSts() throws CarNotConnectedException {
/* 460 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33381, 1);
/*     */     
/* 462 */     PATypes.PA_SCH_FirstLeAvlSts pA_SCH_FirstLeAvlSts = null;
/*     */     try {
/* 464 */       PATypes.PA_SCH_FirstLeAvlSts pA_SCH_FirstLeAvlSts1 = new PATypes.PA_SCH_FirstLeAvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_FirstLeAvlSts = pA_SCH_FirstLeAvlSts1;
/* 465 */     } catch (Exception exception) {}
/*     */     
/* 467 */     return pA_SCH_FirstLeAvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_FirstRiAvlSts getPA_SCH_FirstRiAvlSts() throws CarNotConnectedException {
/* 476 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33382, 1);
/*     */     
/* 478 */     PATypes.PA_SCH_FirstRiAvlSts pA_SCH_FirstRiAvlSts = null;
/*     */     try {
/* 480 */       PATypes.PA_SCH_FirstRiAvlSts pA_SCH_FirstRiAvlSts1 = new PATypes.PA_SCH_FirstRiAvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_FirstRiAvlSts = pA_SCH_FirstRiAvlSts1;
/* 481 */     } catch (Exception exception) {}
/*     */     
/* 483 */     return pA_SCH_FirstRiAvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_SecLeAvlSts getPA_SCH_SecLeAvlSts() throws CarNotConnectedException {
/* 492 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33383, 1);
/*     */     
/* 494 */     PATypes.PA_SCH_SecLeAvlSts pA_SCH_SecLeAvlSts = null;
/*     */     try {
/* 496 */       PATypes.PA_SCH_SecLeAvlSts pA_SCH_SecLeAvlSts1 = new PATypes.PA_SCH_SecLeAvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_SecLeAvlSts = pA_SCH_SecLeAvlSts1;
/* 497 */     } catch (Exception exception) {}
/*     */     
/* 499 */     return pA_SCH_SecLeAvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCH_SecRiAvlSts getPA_SCH_SecRiAvlSts() throws CarNotConnectedException {
/* 508 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33384, 1);
/*     */     
/* 510 */     PATypes.PA_SCH_SecRiAvlSts pA_SCH_SecRiAvlSts = null;
/*     */     try {
/* 512 */       PATypes.PA_SCH_SecRiAvlSts pA_SCH_SecRiAvlSts1 = new PATypes.PA_SCH_SecRiAvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCH_SecRiAvlSts = pA_SCH_SecRiAvlSts1;
/* 513 */     } catch (Exception exception) {}
/*     */     
/* 515 */     return pA_SCH_SecRiAvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_FirstActvn getPA_SCV_FirstActvn() throws CarNotConnectedException {
/* 524 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33385, 1);
/*     */     
/* 526 */     PATypes.PA_SCV_FirstActvn pA_SCV_FirstActvn = null;
/*     */     try {
/* 528 */       PATypes.PA_SCV_FirstActvn pA_SCV_FirstActvn1 = new PATypes.PA_SCV_FirstActvn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_FirstActvn = pA_SCV_FirstActvn1;
/* 529 */     } catch (Exception exception) {}
/*     */     
/* 531 */     return pA_SCV_FirstActvn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_FirstLeLvlSts getPA_SCV_FirstLeLvlSts() throws CarNotConnectedException {
/* 540 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33386, 1);
/*     */     
/* 542 */     PATypes.PA_SCV_FirstLeLvlSts pA_SCV_FirstLeLvlSts = null;
/*     */     try {
/* 544 */       PATypes.PA_SCV_FirstLeLvlSts pA_SCV_FirstLeLvlSts1 = new PATypes.PA_SCV_FirstLeLvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_FirstLeLvlSts = pA_SCV_FirstLeLvlSts1;
/* 545 */     } catch (Exception exception) {}
/*     */     
/* 547 */     return pA_SCV_FirstLeLvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_FirstRiLvlSts getPA_SCV_FirstRiLvlSts() throws CarNotConnectedException {
/* 556 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33387, 1);
/*     */     
/* 558 */     PATypes.PA_SCV_FirstRiLvlSts pA_SCV_FirstRiLvlSts = null;
/*     */     try {
/* 560 */       PATypes.PA_SCV_FirstRiLvlSts pA_SCV_FirstRiLvlSts1 = new PATypes.PA_SCV_FirstRiLvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_FirstRiLvlSts = pA_SCV_FirstRiLvlSts1;
/* 561 */     } catch (Exception exception) {}
/*     */     
/* 563 */     return pA_SCV_FirstRiLvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_FirstLeTmrSts getPA_SCV_FirstLeTmrSts() throws CarNotConnectedException {
/* 572 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33388, 1);
/*     */     
/* 574 */     PATypes.PA_SCV_FirstLeTmrSts pA_SCV_FirstLeTmrSts = null;
/*     */     try {
/* 576 */       PATypes.PA_SCV_FirstLeTmrSts pA_SCV_FirstLeTmrSts1 = new PATypes.PA_SCV_FirstLeTmrSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_FirstLeTmrSts = pA_SCV_FirstLeTmrSts1;
/* 577 */     } catch (Exception exception) {}
/*     */     
/* 579 */     return pA_SCV_FirstLeTmrSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_FirstRiTmrSts getPA_SCV_FirstRiTmrSts() throws CarNotConnectedException {
/* 588 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33389, 1);
/*     */     
/* 590 */     PATypes.PA_SCV_FirstRiTmrSts pA_SCV_FirstRiTmrSts = null;
/*     */     try {
/* 592 */       PATypes.PA_SCV_FirstRiTmrSts pA_SCV_FirstRiTmrSts1 = new PATypes.PA_SCV_FirstRiTmrSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_FirstRiTmrSts = pA_SCV_FirstRiTmrSts1;
/* 593 */     } catch (Exception exception) {}
/*     */     
/* 595 */     return pA_SCV_FirstRiTmrSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_FirstLeAvlSts getPA_SCV_FirstLeAvlSts() throws CarNotConnectedException {
/* 604 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33390, 1);
/*     */     
/* 606 */     PATypes.PA_SCV_FirstLeAvlSts pA_SCV_FirstLeAvlSts = null;
/*     */     try {
/* 608 */       PATypes.PA_SCV_FirstLeAvlSts pA_SCV_FirstLeAvlSts1 = new PATypes.PA_SCV_FirstLeAvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_FirstLeAvlSts = pA_SCV_FirstLeAvlSts1;
/* 609 */     } catch (Exception exception) {}
/*     */     
/* 611 */     return pA_SCV_FirstLeAvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_FirstRiAvlSts getPA_SCV_FirstRiAvlSts() throws CarNotConnectedException {
/* 620 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33391, 1);
/*     */     
/* 622 */     PATypes.PA_SCV_FirstRiAvlSts pA_SCV_FirstRiAvlSts = null;
/*     */     try {
/* 624 */       PATypes.PA_SCV_FirstRiAvlSts pA_SCV_FirstRiAvlSts1 = new PATypes.PA_SCV_FirstRiAvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_FirstRiAvlSts = pA_SCV_FirstRiAvlSts1;
/* 625 */     } catch (Exception exception) {}
/*     */     
/* 627 */     return pA_SCV_FirstRiAvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCV_MsgEnd getPA_SCV_MsgEnd() throws CarNotConnectedException {
/* 636 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33908, 1);
/*     */     
/* 638 */     PATypes.PA_SCV_MsgEnd pA_SCV_MsgEnd = null;
/*     */     try {
/* 640 */       PATypes.PA_SCV_MsgEnd pA_SCV_MsgEnd1 = new PATypes.PA_SCV_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCV_MsgEnd = pA_SCV_MsgEnd1;
/* 641 */     } catch (Exception exception) {}
/*     */     
/* 643 */     return pA_SCV_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarSeatclimateManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */