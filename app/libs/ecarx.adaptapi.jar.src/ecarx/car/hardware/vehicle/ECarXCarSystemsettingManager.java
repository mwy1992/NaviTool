/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.AmbTIndcdUnit;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.ClkFmt;
/*     */ import ecarx.car.hardware.annotation.DateFmt;
/*     */ import ecarx.car.hardware.annotation.DayNightModeSts;
/*     */ import ecarx.car.hardware.annotation.DstLong;
/*     */ import ecarx.car.hardware.annotation.FuCnsIndcdUnit;
/*     */ import ecarx.car.hardware.annotation.LangTyp;
/*     */ import ecarx.car.hardware.annotation.PUnit;
/*     */ import ecarx.car.hardware.annotation.VehSpdIndcdUnit;
/*     */ import ecarx.car.hardware.annotation.VolUnit;
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
/*     */ public class ECarXCarSystemsettingManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbbackbrightness = 32914;
/*     */   public static final int ManagerId_cbcsdbrightness = 32916;
/*     */   public static final int ManagerId_cbdaynightmode = 32915;
/*     */   public static final int ManagerId_cblinkswitch = 32918;
/*     */   public static final int ManagerId_cbpsdbrightness = 32917;
/*     */   public static final int ManagerId_cbsyssetclkfmt = 32906;
/*     */   public static final int ManagerId_cbsyssetdatefmt = 32907;
/*     */   public static final int ManagerId_cbsyssetdstlong = 32912;
/*     */   public static final int ManagerId_cbsyssetfucnsunit = 32909;
/*     */   public static final int ManagerId_cbsyssetoflang = 32905;
/*     */   public static final int ManagerId_cbsyssetpunit = 32913;
/*     */   public static final int ManagerId_cbsyssetspdunit = 32910;
/*     */   public static final int ManagerId_cbsyssettempunit = 32908;
/*     */   public static final int ManagerId_cbsyssetvolunit = 32911;
/*     */   public static final int ManagerId_cbsystemsettingreboot = 32919;
/*     */   public static final int ManagerId_pabackbrightness = 33476;
/*     */   public static final int ManagerId_pacsdbrightness = 33478;
/*     */   public static final int ManagerId_padaynightmode = 33477;
/*     */   public static final int ManagerId_palcfgcsddayval = 33484;
/*     */   public static final int ManagerId_palcfgcsdnightval = 33485;
/*     */   public static final int ManagerId_palcfgdftbckval = 33483;
/*     */   public static final int ManagerId_palcfgpsddayval = 33486;
/*     */   public static final int ManagerId_palcfgpsdnightval = 33487;
/*     */   public static final int ManagerId_palinkswitch = 33488;
/*     */   public static final int ManagerId_papowersoftkeybrightness = 33490;
/*     */   public static final int ManagerId_papowersoftkeyswitch = 33489;
/*     */   public static final int ManagerId_papsdbrightness = 33479;
/*     */   public static final int ManagerId_passmsgend = 33914;
/*     */   public static final int ManagerId_pasyssetclkfmt = 33468;
/*     */   public static final int ManagerId_pasyssetdatefmt = 33469;
/*     */   public static final int ManagerId_pasyssetdstlong = 33474;
/*     */   public static final int ManagerId_pasyssetfucnsunit = 33471;
/*     */   public static final int ManagerId_pasyssetoflang = 33467;
/*     */   public static final int ManagerId_pasyssetpunit = 33475;
/*     */   public static final int ManagerId_pasyssetspdunit = 33472;
/*     */   public static final int ManagerId_pasyssettempunit = 33470;
/*     */   public static final int ManagerId_pasyssetvolunit = 33473;
/*     */   public static final int ManagerId_patdimfast = 33480;
/*     */   public static final int ManagerId_patdimrheo = 33482;
/*     */   public static final int ManagerId_patdimslow = 33481;
/*     */   private static final String TAG = "ECarXCarSystemsettingManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarSystemsettingManager() {}
/*     */   
/*     */   public ECarXCarSystemsettingManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 100 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetOfLang(int paramInt) {
/* 110 */     ApiResult apiResult = ApiResult.FAILED;
/* 111 */     if (LangTyp.isValid(paramInt)) {
/* 112 */       apiResult = this.mMgr.setIntProperty(32905, 1, paramInt);
/*     */     } else {
/* 114 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 116 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetClkFmt(int paramInt) {
/* 126 */     ApiResult apiResult = ApiResult.FAILED;
/* 127 */     if (ClkFmt.isValid(paramInt)) {
/* 128 */       apiResult = this.mMgr.setIntProperty(32906, 1, paramInt);
/*     */     } else {
/* 130 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 132 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetDateFmt(int paramInt) {
/* 142 */     ApiResult apiResult = ApiResult.FAILED;
/* 143 */     if (DateFmt.isValid(paramInt)) {
/* 144 */       apiResult = this.mMgr.setIntProperty(32907, 1, paramInt);
/*     */     } else {
/* 146 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 148 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetTempUnit(int paramInt) {
/* 158 */     ApiResult apiResult = ApiResult.FAILED;
/* 159 */     if (AmbTIndcdUnit.isValid(paramInt)) {
/* 160 */       apiResult = this.mMgr.setIntProperty(32908, 1, paramInt);
/*     */     } else {
/* 162 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 164 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetFuCnsUnit(int paramInt) {
/* 174 */     ApiResult apiResult = ApiResult.FAILED;
/* 175 */     if (FuCnsIndcdUnit.isValid(paramInt)) {
/* 176 */       apiResult = this.mMgr.setIntProperty(32909, 1, paramInt);
/*     */     } else {
/* 178 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 180 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetSpdUnit(int paramInt) {
/* 190 */     ApiResult apiResult = ApiResult.FAILED;
/* 191 */     if (VehSpdIndcdUnit.isValid(paramInt)) {
/* 192 */       apiResult = this.mMgr.setIntProperty(32910, 1, paramInt);
/*     */     } else {
/* 194 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 196 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetVolUnit(int paramInt) {
/* 206 */     ApiResult apiResult = ApiResult.FAILED;
/* 207 */     if (VolUnit.isValid(paramInt)) {
/* 208 */       apiResult = this.mMgr.setIntProperty(32911, 1, paramInt);
/*     */     } else {
/* 210 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 212 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetDstLong(int paramInt) {
/* 222 */     ApiResult apiResult = ApiResult.FAILED;
/* 223 */     if (DstLong.isValid(paramInt)) {
/* 224 */       apiResult = this.mMgr.setIntProperty(32912, 1, paramInt);
/*     */     } else {
/* 226 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 228 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SysSetPUnit(int paramInt) {
/* 238 */     ApiResult apiResult = ApiResult.FAILED;
/* 239 */     if (PUnit.isValid(paramInt)) {
/* 240 */       apiResult = this.mMgr.setIntProperty(32913, 1, paramInt);
/*     */     } else {
/* 242 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 244 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_BackBrightness(int paramInt) {
/* 254 */     return this.mMgr.setIntProperty(32914, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DayNightMode(int paramInt) {
/* 264 */     ApiResult apiResult = ApiResult.FAILED;
/* 265 */     if (DayNightModeSts.isValid(paramInt)) {
/* 266 */       apiResult = this.mMgr.setIntProperty(32915, 1, paramInt);
/*     */     } else {
/* 268 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 270 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_CSDBrightness(int paramInt) {
/* 280 */     return this.mMgr.setIntProperty(32916, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSDBrightness(int paramInt) {
/* 290 */     return this.mMgr.setIntProperty(32917, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_LinkSwitch(int paramInt) {
/* 300 */     return this.mMgr.setIntProperty(32918, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SystemSetting_Reboot(int paramInt) {
/* 310 */     return this.mMgr.setIntProperty(32919, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetOfLang getPA_SysSetOfLang() throws CarNotConnectedException {
/* 321 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33467, 1);
/*     */     
/* 323 */     PATypes.PA_SysSetOfLang pA_SysSetOfLang = null;
/*     */     try {
/* 325 */       PATypes.PA_SysSetOfLang pA_SysSetOfLang1 = new PATypes.PA_SysSetOfLang(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetOfLang = pA_SysSetOfLang1;
/* 326 */     } catch (Exception exception) {}
/*     */     
/* 328 */     return pA_SysSetOfLang;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetClkFmt getPA_SysSetClkFmt() throws CarNotConnectedException {
/* 337 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33468, 1);
/*     */     
/* 339 */     PATypes.PA_SysSetClkFmt pA_SysSetClkFmt = null;
/*     */     try {
/* 341 */       PATypes.PA_SysSetClkFmt pA_SysSetClkFmt1 = new PATypes.PA_SysSetClkFmt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetClkFmt = pA_SysSetClkFmt1;
/* 342 */     } catch (Exception exception) {}
/*     */     
/* 344 */     return pA_SysSetClkFmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetDateFmt getPA_SysSetDateFmt() throws CarNotConnectedException {
/* 353 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33469, 1);
/*     */     
/* 355 */     PATypes.PA_SysSetDateFmt pA_SysSetDateFmt = null;
/*     */     try {
/* 357 */       PATypes.PA_SysSetDateFmt pA_SysSetDateFmt1 = new PATypes.PA_SysSetDateFmt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetDateFmt = pA_SysSetDateFmt1;
/* 358 */     } catch (Exception exception) {}
/*     */     
/* 360 */     return pA_SysSetDateFmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetTempUnit getPA_SysSetTempUnit() throws CarNotConnectedException {
/* 369 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33470, 1);
/*     */     
/* 371 */     PATypes.PA_SysSetTempUnit pA_SysSetTempUnit = null;
/*     */     try {
/* 373 */       PATypes.PA_SysSetTempUnit pA_SysSetTempUnit1 = new PATypes.PA_SysSetTempUnit(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetTempUnit = pA_SysSetTempUnit1;
/* 374 */     } catch (Exception exception) {}
/*     */     
/* 376 */     return pA_SysSetTempUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetFuCnsUnit getPA_SysSetFuCnsUnit() throws CarNotConnectedException {
/* 385 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33471, 1);
/*     */     
/* 387 */     PATypes.PA_SysSetFuCnsUnit pA_SysSetFuCnsUnit = null;
/*     */     try {
/* 389 */       PATypes.PA_SysSetFuCnsUnit pA_SysSetFuCnsUnit1 = new PATypes.PA_SysSetFuCnsUnit(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetFuCnsUnit = pA_SysSetFuCnsUnit1;
/* 390 */     } catch (Exception exception) {}
/*     */     
/* 392 */     return pA_SysSetFuCnsUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetSpdUnit getPA_SysSetSpdUnit() throws CarNotConnectedException {
/* 401 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33472, 1);
/*     */     
/* 403 */     PATypes.PA_SysSetSpdUnit pA_SysSetSpdUnit = null;
/*     */     try {
/* 405 */       PATypes.PA_SysSetSpdUnit pA_SysSetSpdUnit1 = new PATypes.PA_SysSetSpdUnit(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetSpdUnit = pA_SysSetSpdUnit1;
/* 406 */     } catch (Exception exception) {}
/*     */     
/* 408 */     return pA_SysSetSpdUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetVolUnit getPA_SysSetVolUnit() throws CarNotConnectedException {
/* 417 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33473, 1);
/*     */     
/* 419 */     PATypes.PA_SysSetVolUnit pA_SysSetVolUnit = null;
/*     */     try {
/* 421 */       PATypes.PA_SysSetVolUnit pA_SysSetVolUnit1 = new PATypes.PA_SysSetVolUnit(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetVolUnit = pA_SysSetVolUnit1;
/* 422 */     } catch (Exception exception) {}
/*     */     
/* 424 */     return pA_SysSetVolUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetDstLong getPA_SysSetDstLong() throws CarNotConnectedException {
/* 433 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33474, 1);
/*     */     
/* 435 */     PATypes.PA_SysSetDstLong pA_SysSetDstLong = null;
/*     */     try {
/* 437 */       PATypes.PA_SysSetDstLong pA_SysSetDstLong1 = new PATypes.PA_SysSetDstLong(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetDstLong = pA_SysSetDstLong1;
/* 438 */     } catch (Exception exception) {}
/*     */     
/* 440 */     return pA_SysSetDstLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SysSetPUnit getPA_SysSetPUnit() throws CarNotConnectedException {
/* 449 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33475, 1);
/*     */     
/* 451 */     PATypes.PA_SysSetPUnit pA_SysSetPUnit = null;
/*     */     try {
/* 453 */       PATypes.PA_SysSetPUnit pA_SysSetPUnit1 = new PATypes.PA_SysSetPUnit(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SysSetPUnit = pA_SysSetPUnit1;
/* 454 */     } catch (Exception exception) {}
/*     */     
/* 456 */     return pA_SysSetPUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_BackBrightness getPA_BackBrightness() throws CarNotConnectedException {
/* 465 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33476, 1);
/*     */     
/* 467 */     PATypes.PA_BackBrightness pA_BackBrightness = null;
/*     */     try {
/* 469 */       PATypes.PA_BackBrightness pA_BackBrightness1 = new PATypes.PA_BackBrightness(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_BackBrightness = pA_BackBrightness1;
/* 470 */     } catch (Exception exception) {}
/*     */     
/* 472 */     return pA_BackBrightness;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_DayNightMode getPA_DayNightMode() throws CarNotConnectedException {
/* 481 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33477, 1);
/*     */     
/* 483 */     PATypes.PA_DayNightMode pA_DayNightMode = null;
/*     */     try {
/* 485 */       PATypes.PA_DayNightMode pA_DayNightMode1 = new PATypes.PA_DayNightMode(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DayNightMode = pA_DayNightMode1;
/* 486 */     } catch (Exception exception) {}
/*     */     
/* 488 */     return pA_DayNightMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_CSDBrightness getPA_CSDBrightness() throws CarNotConnectedException {
/* 497 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33478, 1);
/*     */     
/* 499 */     PATypes.PA_CSDBrightness pA_CSDBrightness = null;
/*     */     try {
/* 501 */       PATypes.PA_CSDBrightness pA_CSDBrightness1 = new PATypes.PA_CSDBrightness(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CSDBrightness = pA_CSDBrightness1;
/* 502 */     } catch (Exception exception) {}
/*     */     
/* 504 */     return pA_CSDBrightness;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSDBrightness getPA_PSDBrightness() throws CarNotConnectedException {
/* 513 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33479, 1);
/*     */     
/* 515 */     PATypes.PA_PSDBrightness pA_PSDBrightness = null;
/*     */     try {
/* 517 */       PATypes.PA_PSDBrightness pA_PSDBrightness1 = new PATypes.PA_PSDBrightness(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSDBrightness = pA_PSDBrightness1;
/* 518 */     } catch (Exception exception) {}
/*     */     
/* 520 */     return pA_PSDBrightness;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_t_dim_fast getPA_t_dim_fast() throws CarNotConnectedException {
/* 529 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33480, 1);
/*     */     
/* 531 */     PATypes.PA_t_dim_fast pA_t_dim_fast = null;
/*     */     try {
/* 533 */       PATypes.PA_t_dim_fast pA_t_dim_fast1 = new PATypes.PA_t_dim_fast(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_t_dim_fast = pA_t_dim_fast1;
/* 534 */     } catch (Exception exception) {}
/*     */     
/* 536 */     return pA_t_dim_fast;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_t_dim_slow getPA_t_dim_slow() throws CarNotConnectedException {
/* 545 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33481, 1);
/*     */     
/* 547 */     PATypes.PA_t_dim_slow pA_t_dim_slow = null;
/*     */     try {
/* 549 */       PATypes.PA_t_dim_slow pA_t_dim_slow1 = new PATypes.PA_t_dim_slow(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_t_dim_slow = pA_t_dim_slow1;
/* 550 */     } catch (Exception exception) {}
/*     */     
/* 552 */     return pA_t_dim_slow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_t_dim_rheo getPA_t_dim_rheo() throws CarNotConnectedException {
/* 561 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33482, 1);
/*     */     
/* 563 */     PATypes.PA_t_dim_rheo pA_t_dim_rheo = null;
/*     */     try {
/* 565 */       PATypes.PA_t_dim_rheo pA_t_dim_rheo1 = new PATypes.PA_t_dim_rheo(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_t_dim_rheo = pA_t_dim_rheo1;
/* 566 */     } catch (Exception exception) {}
/*     */     
/* 568 */     return pA_t_dim_rheo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_LcfgDftBckVal getPA_LcfgDftBckVal() throws CarNotConnectedException {
/* 577 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33483, 1);
/*     */     
/* 579 */     PATypes.PA_LcfgDftBckVal pA_LcfgDftBckVal = null;
/*     */     try {
/* 581 */       PATypes.PA_LcfgDftBckVal pA_LcfgDftBckVal1 = new PATypes.PA_LcfgDftBckVal(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LcfgDftBckVal = pA_LcfgDftBckVal1;
/* 582 */     } catch (Exception exception) {}
/*     */     
/* 584 */     return pA_LcfgDftBckVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_LcfgCsdDayVal getPA_LcfgCsdDayVal() throws CarNotConnectedException {
/* 593 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33484, 1);
/*     */     
/* 595 */     PATypes.PA_LcfgCsdDayVal pA_LcfgCsdDayVal = null;
/*     */     try {
/* 597 */       PATypes.PA_LcfgCsdDayVal pA_LcfgCsdDayVal1 = new PATypes.PA_LcfgCsdDayVal(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LcfgCsdDayVal = pA_LcfgCsdDayVal1;
/* 598 */     } catch (Exception exception) {}
/*     */     
/* 600 */     return pA_LcfgCsdDayVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_LcfgCsdNightVal getPA_LcfgCsdNightVal() throws CarNotConnectedException {
/* 609 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33485, 1);
/*     */     
/* 611 */     PATypes.PA_LcfgCsdNightVal pA_LcfgCsdNightVal = null;
/*     */     try {
/* 613 */       PATypes.PA_LcfgCsdNightVal pA_LcfgCsdNightVal1 = new PATypes.PA_LcfgCsdNightVal(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LcfgCsdNightVal = pA_LcfgCsdNightVal1;
/* 614 */     } catch (Exception exception) {}
/*     */     
/* 616 */     return pA_LcfgCsdNightVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_LcfgPsdDayVal getPA_LcfgPsdDayVal() throws CarNotConnectedException {
/* 625 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33486, 1);
/*     */     
/* 627 */     PATypes.PA_LcfgPsdDayVal pA_LcfgPsdDayVal = null;
/*     */     try {
/* 629 */       PATypes.PA_LcfgPsdDayVal pA_LcfgPsdDayVal1 = new PATypes.PA_LcfgPsdDayVal(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LcfgPsdDayVal = pA_LcfgPsdDayVal1;
/* 630 */     } catch (Exception exception) {}
/*     */     
/* 632 */     return pA_LcfgPsdDayVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_LcfgPsdNightVal getPA_LcfgPsdNightVal() throws CarNotConnectedException {
/* 641 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33487, 1);
/*     */     
/* 643 */     PATypes.PA_LcfgPsdNightVal pA_LcfgPsdNightVal = null;
/*     */     try {
/* 645 */       PATypes.PA_LcfgPsdNightVal pA_LcfgPsdNightVal1 = new PATypes.PA_LcfgPsdNightVal(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LcfgPsdNightVal = pA_LcfgPsdNightVal1;
/* 646 */     } catch (Exception exception) {}
/*     */     
/* 648 */     return pA_LcfgPsdNightVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_LinkSwitch getPA_LinkSwitch() throws CarNotConnectedException {
/* 657 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33488, 1);
/*     */     
/* 659 */     PATypes.PA_LinkSwitch pA_LinkSwitch = null;
/*     */     try {
/* 661 */       PATypes.PA_LinkSwitch pA_LinkSwitch1 = new PATypes.PA_LinkSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_LinkSwitch = pA_LinkSwitch1;
/* 662 */     } catch (Exception exception) {}
/*     */     
/* 664 */     return pA_LinkSwitch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PowerSoftKeySwitch getPA_PowerSoftKeySwitch() throws CarNotConnectedException {
/* 673 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33489, 1);
/*     */     
/* 675 */     PATypes.PA_PowerSoftKeySwitch pA_PowerSoftKeySwitch = null;
/*     */     try {
/* 677 */       PATypes.PA_PowerSoftKeySwitch pA_PowerSoftKeySwitch1 = new PATypes.PA_PowerSoftKeySwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PowerSoftKeySwitch = pA_PowerSoftKeySwitch1;
/* 678 */     } catch (Exception exception) {}
/*     */     
/* 680 */     return pA_PowerSoftKeySwitch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PowerSoftKeyBrightness getPA_PowerSoftKeyBrightness() throws CarNotConnectedException {
/* 689 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33490, 1);
/*     */     
/* 691 */     PATypes.PA_PowerSoftKeyBrightness pA_PowerSoftKeyBrightness = null;
/*     */     try {
/* 693 */       PATypes.PA_PowerSoftKeyBrightness pA_PowerSoftKeyBrightness1 = new PATypes.PA_PowerSoftKeyBrightness(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PowerSoftKeyBrightness = pA_PowerSoftKeyBrightness1;
/* 694 */     } catch (Exception exception) {}
/*     */     
/* 696 */     return pA_PowerSoftKeyBrightness;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SS_MsgEnd getPA_SS_MsgEnd() throws CarNotConnectedException {
/* 705 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33914, 1);
/*     */     
/* 707 */     PATypes.PA_SS_MsgEnd pA_SS_MsgEnd = null;
/*     */     try {
/* 709 */       PATypes.PA_SS_MsgEnd pA_SS_MsgEnd1 = new PATypes.PA_SS_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SS_MsgEnd = pA_SS_MsgEnd1;
/* 710 */     } catch (Exception exception) {}
/*     */     
/* 712 */     return pA_SS_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarSystemsettingManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */