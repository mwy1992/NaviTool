/*      */ package ecarx.car.hardware.vehicle;
/*      */ 
/*      */ import android.car.CarNotConnectedException;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.annotation.MassgIntenLvl;
/*      */ import ecarx.car.hardware.annotation.MassgProgTyp;
/*      */ import ecarx.car.hardware.annotation.OnOff1;
/*      */ import ecarx.car.hardware.annotation.SaFwdback;
/*      */ import ecarx.car.hardware.annotation.SeatActvSpplFct1;
/*      */ import ecarx.car.hardware.annotation.SeatFoldRaiseReq;
/*      */ import ecarx.car.hardware.annotation.SwtHozlSts1;
/*      */ import ecarx.car.hardware.annotation.SwtVertSts1;
/*      */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
/*      */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
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
/*      */ public class ECarXCarSeatctrlManager
/*      */   extends ECarXCarFuncManagerBase
/*      */ {
/*      */   private static final boolean DBG = false;
/*      */   public static final int ManagerId_cbbackrestadjmtrowfirstdrvr = 32991;
/*      */   public static final int ManagerId_cbbackrestadjmtrowfirstpass = 32992;
/*      */   public static final int ManagerId_cbbackrestadjmtrowsecle = 33018;
/*      */   public static final int ManagerId_cbbackrestadjmtrowsecri = 33019;
/*      */   public static final int ManagerId_cbbackrestsidespprtadjmtrowfirstdrvr = 33000;
/*      */   public static final int ManagerId_cbbackrestsidespprtadjmtrowfirstpass = 33001;
/*      */   public static final int ManagerId_cbcushextnfirstdrvr = 33004;
/*      */   public static final int ManagerId_cbcushextnfirstpass = 33005;
/*      */   public static final int ManagerId_cbcushsidespprtadjmtrowfirstdrvr = 33002;
/*      */   public static final int ManagerId_cbcushsidespprtadjmtrowfirstpass = 33003;
/*      */   public static final int ManagerId_cbeasyinoutdrvrseatadjmt = 32993;
/*      */   public static final int ManagerId_cblenadjmtrowsecle = 33016;
/*      */   public static final int ManagerId_cblenadjmtrowsecri = 33017;
/*      */   public static final int ManagerId_cblumlenadjmtfwdbackwdrvr = 32996;
/*      */   public static final int ManagerId_cblumlenadjmtfwdbackwpass = 32998;
/*      */   public static final int ManagerId_cblumlenadjmtupdowndrvr = 32997;
/*      */   public static final int ManagerId_cblumlenadjmtupdownpass = 32999;
/*      */   public static final int ManagerId_cbmassgfctmassgintendrvr = 33008;
/*      */   public static final int ManagerId_cbmassgfctmassgintenpass = 33011;
/*      */   public static final int ManagerId_cbmultfuncmenudrvr = 32994;
/*      */   public static final int ManagerId_cbmultfuncmenupass = 32995;
/*      */   public static final int ManagerId_cbmultfuncmenutrg = 33012;
/*      */   public static final int ManagerId_cbmultmassgfctmassgprogdrvr = 33007;
/*      */   public static final int ManagerId_cbmultmassgfctmassgprogpass = 33010;
/*      */   public static final int ManagerId_cbmultmassgfctonoffdrvr = 33006;
/*      */   public static final int ManagerId_cbmultmassgfctonoffpass = 33009;
/*      */   public static final int ManagerId_cbseatctrlreboot = 33013;
/*      */   public static final int ManagerId_cbseatcushtiltadjmtrowfirstdrvr = 32989;
/*      */   public static final int ManagerId_cbseatcushtiltadjmtrowfirstpass = 32990;
/*      */   public static final int ManagerId_cbseatfoldraisereqrowthrdle = 33014;
/*      */   public static final int ManagerId_cbseatfoldraisereqrowthrdri = 33015;
/*      */   public static final int ManagerId_cbseatheiadjmtrowfirstdrvr = 32987;
/*      */   public static final int ManagerId_cbseatheiadjmtrowfirstpass = 32988;
/*      */   public static final int ManagerId_cbseatlenadjmtrowfirstdrvr = 32985;
/*      */   public static final int ManagerId_cbseatlenadjmtrowfirstpass = 32986;
/*      */   public static final int ManagerId_padrvrmassgrunng = 33616;
/*      */   public static final int ManagerId_padrvrmultfuncmenuext = 33618;
/*      */   public static final int ManagerId_padrvrseatactvspplfct = 33592;
/*      */   public static final int ManagerId_padrvrseatcushextstsallowd = 33606;
/*      */   public static final int ManagerId_padrvrseatdispmassgfctmassginten = 33611;
/*      */   public static final int ManagerId_padrvrseatdispmassgfctmassgprog = 33610;
/*      */   public static final int ManagerId_padrvrseatdispmassgfctonoff = 33609;
/*      */   public static final int ManagerId_padrvrseatextadjallowd = 33574;
/*      */   public static final int ManagerId_padrvrseatlmbrfwdbackwstsallowd = 33598;
/*      */   public static final int ManagerId_padrvrseatlmbrupdownstsallowd = 33599;
/*      */   public static final int ManagerId_padrvrseatmassagestsallowd = 33608;
/*      */   public static final int ManagerId_padrvrseatsidefwdbackwstsallowd = 33602;
/*      */   public static final int ManagerId_padrvrseatsideupdownstsallowd = 33604;
/*      */   public static final int ManagerId_padrvrseatswtadjmtofspplfcthozlsts = 33595;
/*      */   public static final int ManagerId_padrvrseatswtadjmtofspplfctvertsts = 33594;
/*      */   public static final int ManagerId_padrvrseatswtheifrntsts = 33583;
/*      */   public static final int ManagerId_padrvrseatswtheifrntstsallowd = 33582;
/*      */   public static final int ManagerId_padrvrseatswtheists = 33579;
/*      */   public static final int ManagerId_padrvrseatswtheistsallowd = 33578;
/*      */   public static final int ManagerId_padrvrseatswtinclsts = 33587;
/*      */   public static final int ManagerId_padrvrseatswtinclstsallowd = 33586;
/*      */   public static final int ManagerId_padrvrseatswtselnofspplfctsts = 33632;
/*      */   public static final int ManagerId_padrvrseatswtsldsts = 33575;
/*      */   public static final int ManagerId_paeasyinoutdrvrseatadjmt = 33591;
/*      */   public static final int ManagerId_paeasyinoutdrvrseatallowd = 33590;
/*      */   public static final int ManagerId_pahotstonemassagedrvrallowd = 33630;
/*      */   public static final int ManagerId_pahotstonemassagepassallowd = 33631;
/*      */   public static final int ManagerId_papassmassgrunng = 33617;
/*      */   public static final int ManagerId_papassmultfuncmenuext = 33619;
/*      */   public static final int ManagerId_papassseatactvspplfct = 33593;
/*      */   public static final int ManagerId_papassseatcushextstsallowd = 33607;
/*      */   public static final int ManagerId_papassseatdispmassgfctmassginten = 33615;
/*      */   public static final int ManagerId_papassseatdispmassgfctmassgprog = 33614;
/*      */   public static final int ManagerId_papassseatdispmassgfctonoff = 33613;
/*      */   public static final int ManagerId_papassseatextadjallowd = 33576;
/*      */   public static final int ManagerId_papassseatlmbrfwdbackwstsallowd = 33600;
/*      */   public static final int ManagerId_papassseatlmbrupdownstsallowd = 33601;
/*      */   public static final int ManagerId_papassseatmassagestsallowd = 33612;
/*      */   public static final int ManagerId_papassseatsidefwdbackwstsallowd = 33603;
/*      */   public static final int ManagerId_papassseatsideupdownstsallowd = 33605;
/*      */   public static final int ManagerId_papassseatswtadjmtofspplfcthozlsts = 33597;
/*      */   public static final int ManagerId_papassseatswtadjmtofspplfctvertsts = 33596;
/*      */   public static final int ManagerId_papassseatswtheifrntsts = 33585;
/*      */   public static final int ManagerId_papassseatswtheifrntstsallowd = 33584;
/*      */   public static final int ManagerId_papassseatswtheists = 33581;
/*      */   public static final int ManagerId_papassseatswtheistsallowd = 33580;
/*      */   public static final int ManagerId_papassseatswtinclsts = 33589;
/*      */   public static final int ManagerId_papassseatswtinclstsallowd = 33588;
/*      */   public static final int ManagerId_papassseatswtselnofspplfctsts = 33633;
/*      */   public static final int ManagerId_papassseatswtsldsts = 33577;
/*      */   public static final int ManagerId_pascmsgend = 33920;
/*      */   public static final int ManagerId_paseatfoldraiserowthrdleallowd = 33620;
/*      */   public static final int ManagerId_paseatfoldraiserowthrdriallowd = 33621;
/*      */   public static final int ManagerId_paseatrowsecleswtstspassseatswtinclsts = 33628;
/*      */   public static final int ManagerId_paseatrowsecleswtstspassseatswtsldsts = 33623;
/*      */   public static final int ManagerId_paseatrowsecriswtstspassseatswtinclsts = 33629;
/*      */   public static final int ManagerId_paseatrowsecriswtstspassseatswtsldsts = 33625;
/*      */   public static final int ManagerId_pasecrowseatincllefwdbackwallowd = 33626;
/*      */   public static final int ManagerId_pasecrowseatinclrifwdbackwallowd = 33627;
/*      */   public static final int ManagerId_pasecrowseatlenlefwdbackwallowd = 33622;
/*      */   public static final int ManagerId_pasecrowseatlenrifwdbackwallowd = 33624;
/*      */   private static final String TAG = "ECarXCarSeatctrlManager";
/*      */   public static final int VehicleArea_Global = 1;
/*      */   public static final int VehicleArea_Zone = 2;
/*      */   
/*      */   public ECarXCarSeatctrlManager() {}
/*      */   
/*      */   public ECarXCarSeatctrlManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  154 */     super(paramECarXCarPropertyManagerBase);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatLenAdjmtRowFirstDrvr(int paramInt) {
/*  164 */     ApiResult apiResult = ApiResult.FAILED;
/*  165 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  166 */       apiResult = this.mMgr.setIntProperty(32985, 1, paramInt);
/*      */     } else {
/*  168 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  170 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatLenAdjmtRowFirstPass(int paramInt) {
/*  180 */     ApiResult apiResult = ApiResult.FAILED;
/*  181 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  182 */       apiResult = this.mMgr.setIntProperty(32986, 1, paramInt);
/*      */     } else {
/*  184 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  186 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatHeiAdjmtRowFirstDrvr(int paramInt) {
/*  196 */     ApiResult apiResult = ApiResult.FAILED;
/*  197 */     if (SwtVertSts1.isValid(paramInt)) {
/*  198 */       apiResult = this.mMgr.setIntProperty(32987, 1, paramInt);
/*      */     } else {
/*  200 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  202 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatHeiAdjmtRowFirstPass(int paramInt) {
/*  212 */     ApiResult apiResult = ApiResult.FAILED;
/*  213 */     if (SwtVertSts1.isValid(paramInt)) {
/*  214 */       apiResult = this.mMgr.setIntProperty(32988, 1, paramInt);
/*      */     } else {
/*  216 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  218 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatCushTiltAdjmtRowFirstDrvr(int paramInt) {
/*  228 */     ApiResult apiResult = ApiResult.FAILED;
/*  229 */     if (SwtVertSts1.isValid(paramInt)) {
/*  230 */       apiResult = this.mMgr.setIntProperty(32989, 1, paramInt);
/*      */     } else {
/*  232 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  234 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatCushTiltAdjmtRowFirstPass(int paramInt) {
/*  244 */     ApiResult apiResult = ApiResult.FAILED;
/*  245 */     if (SwtVertSts1.isValid(paramInt)) {
/*  246 */       apiResult = this.mMgr.setIntProperty(32990, 1, paramInt);
/*      */     } else {
/*  248 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  250 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_BackRestAdjmtRowFirstDrvr(int paramInt) {
/*  260 */     ApiResult apiResult = ApiResult.FAILED;
/*  261 */     if (SaFwdback.isValid(paramInt)) {
/*  262 */       apiResult = this.mMgr.setIntProperty(32991, 1, paramInt);
/*      */     } else {
/*  264 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  266 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_BackRestAdjmtRowFirstPass(int paramInt) {
/*  276 */     ApiResult apiResult = ApiResult.FAILED;
/*  277 */     if (SaFwdback.isValid(paramInt)) {
/*  278 */       apiResult = this.mMgr.setIntProperty(32992, 1, paramInt);
/*      */     } else {
/*  280 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  282 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_EasyInOutDrvrSeatAdjmt(int paramInt) {
/*  292 */     ApiResult apiResult = ApiResult.FAILED;
/*  293 */     if (OnOff1.isValid(paramInt)) {
/*  294 */       apiResult = this.mMgr.setIntProperty(32993, 1, paramInt);
/*      */     } else {
/*  296 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  298 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MultFuncMenuDrvr(int paramInt) {
/*  308 */     ApiResult apiResult = ApiResult.FAILED;
/*  309 */     if (SeatActvSpplFct1.isValid(paramInt)) {
/*  310 */       apiResult = this.mMgr.setIntProperty(32994, 1, paramInt);
/*      */     } else {
/*  312 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  314 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MultFuncMenuPass(int paramInt) {
/*  324 */     ApiResult apiResult = ApiResult.FAILED;
/*  325 */     if (SeatActvSpplFct1.isValid(paramInt)) {
/*  326 */       apiResult = this.mMgr.setIntProperty(32995, 1, paramInt);
/*      */     } else {
/*  328 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  330 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LumLenAdjmtFwdBackwDrvr(int paramInt) {
/*  340 */     ApiResult apiResult = ApiResult.FAILED;
/*  341 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  342 */       apiResult = this.mMgr.setIntProperty(32996, 1, paramInt);
/*      */     } else {
/*  344 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  346 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LumLenAdjmtUpDownDrvr(int paramInt) {
/*  356 */     ApiResult apiResult = ApiResult.FAILED;
/*  357 */     if (SwtVertSts1.isValid(paramInt)) {
/*  358 */       apiResult = this.mMgr.setIntProperty(32997, 1, paramInt);
/*      */     } else {
/*  360 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  362 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LumLenAdjmtFwdBackwPass(int paramInt) {
/*  372 */     ApiResult apiResult = ApiResult.FAILED;
/*  373 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  374 */       apiResult = this.mMgr.setIntProperty(32998, 1, paramInt);
/*      */     } else {
/*  376 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  378 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LumLenAdjmtUpDownPass(int paramInt) {
/*  388 */     ApiResult apiResult = ApiResult.FAILED;
/*  389 */     if (SwtVertSts1.isValid(paramInt)) {
/*  390 */       apiResult = this.mMgr.setIntProperty(32999, 1, paramInt);
/*      */     } else {
/*  392 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  394 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_BackRestSideSpprtAdjmtRowFirstDrvr(int paramInt) {
/*  404 */     ApiResult apiResult = ApiResult.FAILED;
/*  405 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  406 */       apiResult = this.mMgr.setIntProperty(33000, 1, paramInt);
/*      */     } else {
/*  408 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  410 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_BackRestSideSpprtAdjmtRowFirstPass(int paramInt) {
/*  420 */     ApiResult apiResult = ApiResult.FAILED;
/*  421 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  422 */       apiResult = this.mMgr.setIntProperty(33001, 1, paramInt);
/*      */     } else {
/*  424 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  426 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CushSideSpprtAdjmtRowFirstDrvr(int paramInt) {
/*  436 */     ApiResult apiResult = ApiResult.FAILED;
/*  437 */     if (SwtVertSts1.isValid(paramInt)) {
/*  438 */       apiResult = this.mMgr.setIntProperty(33002, 1, paramInt);
/*      */     } else {
/*  440 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  442 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CushSideSpprtAdjmtRowFirstPass(int paramInt) {
/*  452 */     ApiResult apiResult = ApiResult.FAILED;
/*  453 */     if (SwtVertSts1.isValid(paramInt)) {
/*  454 */       apiResult = this.mMgr.setIntProperty(33003, 1, paramInt);
/*      */     } else {
/*  456 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  458 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CushExtnFirstDrvr(int paramInt) {
/*  468 */     ApiResult apiResult = ApiResult.FAILED;
/*  469 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  470 */       apiResult = this.mMgr.setIntProperty(33004, 1, paramInt);
/*      */     } else {
/*  472 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  474 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CushExtnFirstPass(int paramInt) {
/*  484 */     ApiResult apiResult = ApiResult.FAILED;
/*  485 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  486 */       apiResult = this.mMgr.setIntProperty(33005, 1, paramInt);
/*      */     } else {
/*  488 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  490 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MultMassgFctOnOffDrvr(int paramInt) {
/*  500 */     ApiResult apiResult = ApiResult.FAILED;
/*  501 */     if (OnOff1.isValid(paramInt)) {
/*  502 */       apiResult = this.mMgr.setIntProperty(33006, 1, paramInt);
/*      */     } else {
/*  504 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  506 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MultMassgFctMassgProgDrvr(int paramInt) {
/*  516 */     ApiResult apiResult = ApiResult.FAILED;
/*  517 */     if (MassgProgTyp.isValid(paramInt)) {
/*  518 */       apiResult = this.mMgr.setIntProperty(33007, 1, paramInt);
/*      */     } else {
/*  520 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  522 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MassgFctMassgIntenDrvr(int paramInt) {
/*  532 */     ApiResult apiResult = ApiResult.FAILED;
/*  533 */     if (MassgIntenLvl.isValid(paramInt)) {
/*  534 */       apiResult = this.mMgr.setIntProperty(33008, 1, paramInt);
/*      */     } else {
/*  536 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  538 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MultMassgFctOnOffPass(int paramInt) {
/*  548 */     ApiResult apiResult = ApiResult.FAILED;
/*  549 */     if (OnOff1.isValid(paramInt)) {
/*  550 */       apiResult = this.mMgr.setIntProperty(33009, 1, paramInt);
/*      */     } else {
/*  552 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  554 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MultMassgFctMassgProgPass(int paramInt) {
/*  564 */     ApiResult apiResult = ApiResult.FAILED;
/*  565 */     if (MassgProgTyp.isValid(paramInt)) {
/*  566 */       apiResult = this.mMgr.setIntProperty(33010, 1, paramInt);
/*      */     } else {
/*  568 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  570 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MassgFctMassgIntenPass(int paramInt) {
/*  580 */     ApiResult apiResult = ApiResult.FAILED;
/*  581 */     if (MassgIntenLvl.isValid(paramInt)) {
/*  582 */       apiResult = this.mMgr.setIntProperty(33011, 1, paramInt);
/*      */     } else {
/*  584 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  586 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MultFuncMenuTrg(int paramInt) {
/*  596 */     return this.mMgr.setIntProperty(33012, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatCtrl_Reboot(int paramInt) {
/*  606 */     return this.mMgr.setIntProperty(33013, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatFoldRaiseReqRowThrdLe(int paramInt) {
/*  616 */     ApiResult apiResult = ApiResult.FAILED;
/*  617 */     if (SeatFoldRaiseReq.isValid(paramInt)) {
/*  618 */       apiResult = this.mMgr.setIntProperty(33014, 1, paramInt);
/*      */     } else {
/*  620 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  622 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_SeatFoldRaiseReqRowThrdRi(int paramInt) {
/*  632 */     ApiResult apiResult = ApiResult.FAILED;
/*  633 */     if (SeatFoldRaiseReq.isValid(paramInt)) {
/*  634 */       apiResult = this.mMgr.setIntProperty(33015, 1, paramInt);
/*      */     } else {
/*  636 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  638 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LenAdjmtRowSecLe(int paramInt) {
/*  648 */     ApiResult apiResult = ApiResult.FAILED;
/*  649 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  650 */       apiResult = this.mMgr.setIntProperty(33016, 1, paramInt);
/*      */     } else {
/*  652 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  654 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_LenAdjmtRowSecRi(int paramInt) {
/*  664 */     ApiResult apiResult = ApiResult.FAILED;
/*  665 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  666 */       apiResult = this.mMgr.setIntProperty(33017, 1, paramInt);
/*      */     } else {
/*  668 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  670 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_BackrestAdjmtRowSecLe(int paramInt) {
/*  680 */     ApiResult apiResult = ApiResult.FAILED;
/*  681 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  682 */       apiResult = this.mMgr.setIntProperty(33018, 1, paramInt);
/*      */     } else {
/*  684 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  686 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_BackrestAdjmtRowSecRi(int paramInt) {
/*  696 */     ApiResult apiResult = ApiResult.FAILED;
/*  697 */     if (SwtHozlSts1.isValid(paramInt)) {
/*  698 */       apiResult = this.mMgr.setIntProperty(33019, 1, paramInt);
/*      */     } else {
/*  700 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  702 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatExtAdjAllowd getPA_DrvrSeatExtAdjAllowd() throws CarNotConnectedException {
/*  713 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33574, 1);
/*      */     
/*  715 */     PATypes.PA_DrvrSeatExtAdjAllowd pA_DrvrSeatExtAdjAllowd = null;
/*      */     try {
/*  717 */       PATypes.PA_DrvrSeatExtAdjAllowd pA_DrvrSeatExtAdjAllowd1 = new PATypes.PA_DrvrSeatExtAdjAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatExtAdjAllowd = pA_DrvrSeatExtAdjAllowd1;
/*  718 */     } catch (Exception exception) {}
/*      */     
/*  720 */     return pA_DrvrSeatExtAdjAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtSldSts getPA_DrvrSeatSwtSldSts() throws CarNotConnectedException {
/*  729 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33575, 1);
/*      */     
/*  731 */     PATypes.PA_DrvrSeatSwtSldSts pA_DrvrSeatSwtSldSts = null;
/*      */     try {
/*  733 */       PATypes.PA_DrvrSeatSwtSldSts pA_DrvrSeatSwtSldSts1 = new PATypes.PA_DrvrSeatSwtSldSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtSldSts = pA_DrvrSeatSwtSldSts1;
/*  734 */     } catch (Exception exception) {}
/*      */     
/*  736 */     return pA_DrvrSeatSwtSldSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatExtAdjAllowd getPA_PassSeatExtAdjAllowd() throws CarNotConnectedException {
/*  745 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33576, 1);
/*      */     
/*  747 */     PATypes.PA_PassSeatExtAdjAllowd pA_PassSeatExtAdjAllowd = null;
/*      */     try {
/*  749 */       PATypes.PA_PassSeatExtAdjAllowd pA_PassSeatExtAdjAllowd1 = new PATypes.PA_PassSeatExtAdjAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatExtAdjAllowd = pA_PassSeatExtAdjAllowd1;
/*  750 */     } catch (Exception exception) {}
/*      */     
/*  752 */     return pA_PassSeatExtAdjAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtSldSts getPA_PassSeatSwtSldSts() throws CarNotConnectedException {
/*  761 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33577, 1);
/*      */     
/*  763 */     PATypes.PA_PassSeatSwtSldSts pA_PassSeatSwtSldSts = null;
/*      */     try {
/*  765 */       PATypes.PA_PassSeatSwtSldSts pA_PassSeatSwtSldSts1 = new PATypes.PA_PassSeatSwtSldSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtSldSts = pA_PassSeatSwtSldSts1;
/*  766 */     } catch (Exception exception) {}
/*      */     
/*  768 */     return pA_PassSeatSwtSldSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtHeiStsAllowd getPA_DrvrSeatSwtHeiStsAllowd() throws CarNotConnectedException {
/*  777 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33578, 1);
/*      */     
/*  779 */     PATypes.PA_DrvrSeatSwtHeiStsAllowd pA_DrvrSeatSwtHeiStsAllowd = null;
/*      */     try {
/*  781 */       PATypes.PA_DrvrSeatSwtHeiStsAllowd pA_DrvrSeatSwtHeiStsAllowd1 = new PATypes.PA_DrvrSeatSwtHeiStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtHeiStsAllowd = pA_DrvrSeatSwtHeiStsAllowd1;
/*  782 */     } catch (Exception exception) {}
/*      */     
/*  784 */     return pA_DrvrSeatSwtHeiStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtHeiSts getPA_DrvrSeatSwtHeiSts() throws CarNotConnectedException {
/*  793 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33579, 1);
/*      */     
/*  795 */     PATypes.PA_DrvrSeatSwtHeiSts pA_DrvrSeatSwtHeiSts = null;
/*      */     try {
/*  797 */       PATypes.PA_DrvrSeatSwtHeiSts pA_DrvrSeatSwtHeiSts1 = new PATypes.PA_DrvrSeatSwtHeiSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtHeiSts = pA_DrvrSeatSwtHeiSts1;
/*  798 */     } catch (Exception exception) {}
/*      */     
/*  800 */     return pA_DrvrSeatSwtHeiSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtHeiStsAllowd getPA_PassSeatSwtHeiStsAllowd() throws CarNotConnectedException {
/*  809 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33580, 1);
/*      */     
/*  811 */     PATypes.PA_PassSeatSwtHeiStsAllowd pA_PassSeatSwtHeiStsAllowd = null;
/*      */     try {
/*  813 */       PATypes.PA_PassSeatSwtHeiStsAllowd pA_PassSeatSwtHeiStsAllowd1 = new PATypes.PA_PassSeatSwtHeiStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtHeiStsAllowd = pA_PassSeatSwtHeiStsAllowd1;
/*  814 */     } catch (Exception exception) {}
/*      */     
/*  816 */     return pA_PassSeatSwtHeiStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtHeiSts getPA_PassSeatSwtHeiSts() throws CarNotConnectedException {
/*  825 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33581, 1);
/*      */     
/*  827 */     PATypes.PA_PassSeatSwtHeiSts pA_PassSeatSwtHeiSts = null;
/*      */     try {
/*  829 */       PATypes.PA_PassSeatSwtHeiSts pA_PassSeatSwtHeiSts1 = new PATypes.PA_PassSeatSwtHeiSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtHeiSts = pA_PassSeatSwtHeiSts1;
/*  830 */     } catch (Exception exception) {}
/*      */     
/*  832 */     return pA_PassSeatSwtHeiSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd getPA_DrvrSeatSwtHeiFrntStsAllowd() throws CarNotConnectedException {
/*  841 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33582, 1);
/*      */     
/*  843 */     PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd pA_DrvrSeatSwtHeiFrntStsAllowd = null;
/*      */     try {
/*  845 */       PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd pA_DrvrSeatSwtHeiFrntStsAllowd1 = new PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtHeiFrntStsAllowd = pA_DrvrSeatSwtHeiFrntStsAllowd1;
/*  846 */     } catch (Exception exception) {}
/*      */     
/*  848 */     return pA_DrvrSeatSwtHeiFrntStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtHeiFrntSts getPA_DrvrSeatSwtHeiFrntSts() throws CarNotConnectedException {
/*  857 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33583, 1);
/*      */     
/*  859 */     PATypes.PA_DrvrSeatSwtHeiFrntSts pA_DrvrSeatSwtHeiFrntSts = null;
/*      */     try {
/*  861 */       PATypes.PA_DrvrSeatSwtHeiFrntSts pA_DrvrSeatSwtHeiFrntSts1 = new PATypes.PA_DrvrSeatSwtHeiFrntSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtHeiFrntSts = pA_DrvrSeatSwtHeiFrntSts1;
/*  862 */     } catch (Exception exception) {}
/*      */     
/*  864 */     return pA_DrvrSeatSwtHeiFrntSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtHeiFrntStsAllowd getPA_PassSeatSwtHeiFrntStsAllowd() throws CarNotConnectedException {
/*  873 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33584, 1);
/*      */     
/*  875 */     PATypes.PA_PassSeatSwtHeiFrntStsAllowd pA_PassSeatSwtHeiFrntStsAllowd = null;
/*      */     try {
/*  877 */       PATypes.PA_PassSeatSwtHeiFrntStsAllowd pA_PassSeatSwtHeiFrntStsAllowd1 = new PATypes.PA_PassSeatSwtHeiFrntStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtHeiFrntStsAllowd = pA_PassSeatSwtHeiFrntStsAllowd1;
/*  878 */     } catch (Exception exception) {}
/*      */     
/*  880 */     return pA_PassSeatSwtHeiFrntStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtHeiFrntSts getPA_PassSeatSwtHeiFrntSts() throws CarNotConnectedException {
/*  889 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33585, 1);
/*      */     
/*  891 */     PATypes.PA_PassSeatSwtHeiFrntSts pA_PassSeatSwtHeiFrntSts = null;
/*      */     try {
/*  893 */       PATypes.PA_PassSeatSwtHeiFrntSts pA_PassSeatSwtHeiFrntSts1 = new PATypes.PA_PassSeatSwtHeiFrntSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtHeiFrntSts = pA_PassSeatSwtHeiFrntSts1;
/*  894 */     } catch (Exception exception) {}
/*      */     
/*  896 */     return pA_PassSeatSwtHeiFrntSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtInclStsAllowd getPA_DrvrSeatSwtInclStsAllowd() throws CarNotConnectedException {
/*  905 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33586, 1);
/*      */     
/*  907 */     PATypes.PA_DrvrSeatSwtInclStsAllowd pA_DrvrSeatSwtInclStsAllowd = null;
/*      */     try {
/*  909 */       PATypes.PA_DrvrSeatSwtInclStsAllowd pA_DrvrSeatSwtInclStsAllowd1 = new PATypes.PA_DrvrSeatSwtInclStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtInclStsAllowd = pA_DrvrSeatSwtInclStsAllowd1;
/*  910 */     } catch (Exception exception) {}
/*      */     
/*  912 */     return pA_DrvrSeatSwtInclStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtInclSts getPA_DrvrSeatSwtInclSts() throws CarNotConnectedException {
/*  921 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33587, 1);
/*      */     
/*  923 */     PATypes.PA_DrvrSeatSwtInclSts pA_DrvrSeatSwtInclSts = null;
/*      */     try {
/*  925 */       PATypes.PA_DrvrSeatSwtInclSts pA_DrvrSeatSwtInclSts1 = new PATypes.PA_DrvrSeatSwtInclSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtInclSts = pA_DrvrSeatSwtInclSts1;
/*  926 */     } catch (Exception exception) {}
/*      */     
/*  928 */     return pA_DrvrSeatSwtInclSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtInclStsAllowd getPA_PassSeatSwtInclStsAllowd() throws CarNotConnectedException {
/*  937 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33588, 1);
/*      */     
/*  939 */     PATypes.PA_PassSeatSwtInclStsAllowd pA_PassSeatSwtInclStsAllowd = null;
/*      */     try {
/*  941 */       PATypes.PA_PassSeatSwtInclStsAllowd pA_PassSeatSwtInclStsAllowd1 = new PATypes.PA_PassSeatSwtInclStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtInclStsAllowd = pA_PassSeatSwtInclStsAllowd1;
/*  942 */     } catch (Exception exception) {}
/*      */     
/*  944 */     return pA_PassSeatSwtInclStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtInclSts getPA_PassSeatSwtInclSts() throws CarNotConnectedException {
/*  953 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33589, 1);
/*      */     
/*  955 */     PATypes.PA_PassSeatSwtInclSts pA_PassSeatSwtInclSts = null;
/*      */     try {
/*  957 */       PATypes.PA_PassSeatSwtInclSts pA_PassSeatSwtInclSts1 = new PATypes.PA_PassSeatSwtInclSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtInclSts = pA_PassSeatSwtInclSts1;
/*  958 */     } catch (Exception exception) {}
/*      */     
/*  960 */     return pA_PassSeatSwtInclSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_EasyInOutDrvrSeatAllowd getPA_EasyInOutDrvrSeatAllowd() throws CarNotConnectedException {
/*  969 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33590, 1);
/*      */     
/*  971 */     PATypes.PA_EasyInOutDrvrSeatAllowd pA_EasyInOutDrvrSeatAllowd = null;
/*      */     try {
/*  973 */       PATypes.PA_EasyInOutDrvrSeatAllowd pA_EasyInOutDrvrSeatAllowd1 = new PATypes.PA_EasyInOutDrvrSeatAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_EasyInOutDrvrSeatAllowd = pA_EasyInOutDrvrSeatAllowd1;
/*  974 */     } catch (Exception exception) {}
/*      */     
/*  976 */     return pA_EasyInOutDrvrSeatAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_EasyInOutDrvrSeatAdjmt getPA_EasyInOutDrvrSeatAdjmt() throws CarNotConnectedException {
/*  985 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33591, 1);
/*      */     
/*  987 */     PATypes.PA_EasyInOutDrvrSeatAdjmt pA_EasyInOutDrvrSeatAdjmt = null;
/*      */     try {
/*  989 */       PATypes.PA_EasyInOutDrvrSeatAdjmt pA_EasyInOutDrvrSeatAdjmt1 = new PATypes.PA_EasyInOutDrvrSeatAdjmt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_EasyInOutDrvrSeatAdjmt = pA_EasyInOutDrvrSeatAdjmt1;
/*  990 */     } catch (Exception exception) {}
/*      */     
/*  992 */     return pA_EasyInOutDrvrSeatAdjmt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatActvSpplFct getPA_DrvrSeatActvSpplFct() throws CarNotConnectedException {
/* 1001 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33592, 1);
/*      */     
/* 1003 */     PATypes.PA_DrvrSeatActvSpplFct pA_DrvrSeatActvSpplFct = null;
/*      */     try {
/* 1005 */       PATypes.PA_DrvrSeatActvSpplFct pA_DrvrSeatActvSpplFct1 = new PATypes.PA_DrvrSeatActvSpplFct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatActvSpplFct = pA_DrvrSeatActvSpplFct1;
/* 1006 */     } catch (Exception exception) {}
/*      */     
/* 1008 */     return pA_DrvrSeatActvSpplFct;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatActvSpplFct getPA_PassSeatActvSpplFct() throws CarNotConnectedException {
/* 1017 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33593, 1);
/*      */     
/* 1019 */     PATypes.PA_PassSeatActvSpplFct pA_PassSeatActvSpplFct = null;
/*      */     try {
/* 1021 */       PATypes.PA_PassSeatActvSpplFct pA_PassSeatActvSpplFct1 = new PATypes.PA_PassSeatActvSpplFct(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatActvSpplFct = pA_PassSeatActvSpplFct1;
/* 1022 */     } catch (Exception exception) {}
/*      */     
/* 1024 */     return pA_PassSeatActvSpplFct;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts getPA_DrvrSeatSwtAdjmtOfSpplFctVertSts() throws CarNotConnectedException {
/* 1033 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33594, 1);
/*      */     
/* 1035 */     PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts pA_DrvrSeatSwtAdjmtOfSpplFctVertSts = null;
/*      */     try {
/* 1037 */       PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts pA_DrvrSeatSwtAdjmtOfSpplFctVertSts1 = new PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtAdjmtOfSpplFctVertSts = pA_DrvrSeatSwtAdjmtOfSpplFctVertSts1;
/* 1038 */     } catch (Exception exception) {}
/*      */     
/* 1040 */     return pA_DrvrSeatSwtAdjmtOfSpplFctVertSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts getPA_DrvrSeatSwtAdjmtOfSpplFctHozlSts() throws CarNotConnectedException {
/* 1049 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33595, 1);
/*      */     
/* 1051 */     PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts = null;
/*      */     try {
/* 1053 */       PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts1 = new PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts = pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts1;
/* 1054 */     } catch (Exception exception) {}
/*      */     
/* 1056 */     return pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts getPA_PassSeatSwtAdjmtOfSpplFctVertSts() throws CarNotConnectedException {
/* 1065 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33596, 1);
/*      */     
/* 1067 */     PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts pA_PassSeatSwtAdjmtOfSpplFctVertSts = null;
/*      */     try {
/* 1069 */       PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts pA_PassSeatSwtAdjmtOfSpplFctVertSts1 = new PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtAdjmtOfSpplFctVertSts = pA_PassSeatSwtAdjmtOfSpplFctVertSts1;
/* 1070 */     } catch (Exception exception) {}
/*      */     
/* 1072 */     return pA_PassSeatSwtAdjmtOfSpplFctVertSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts getPA_PassSeatSwtAdjmtOfSpplFctHozlSts() throws CarNotConnectedException {
/* 1081 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33597, 1);
/*      */     
/* 1083 */     PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts pA_PassSeatSwtAdjmtOfSpplFctHozlSts = null;
/*      */     try {
/* 1085 */       PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts pA_PassSeatSwtAdjmtOfSpplFctHozlSts1 = new PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtAdjmtOfSpplFctHozlSts = pA_PassSeatSwtAdjmtOfSpplFctHozlSts1;
/* 1086 */     } catch (Exception exception) {}
/*      */     
/* 1088 */     return pA_PassSeatSwtAdjmtOfSpplFctHozlSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd getPA_DrvrSeatLmbrFwdBackwStsAllowd() throws CarNotConnectedException {
/* 1097 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33598, 1);
/*      */     
/* 1099 */     PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd pA_DrvrSeatLmbrFwdBackwStsAllowd = null;
/*      */     try {
/* 1101 */       PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd pA_DrvrSeatLmbrFwdBackwStsAllowd1 = new PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatLmbrFwdBackwStsAllowd = pA_DrvrSeatLmbrFwdBackwStsAllowd1;
/* 1102 */     } catch (Exception exception) {}
/*      */     
/* 1104 */     return pA_DrvrSeatLmbrFwdBackwStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatLmbrUpDownStsAllowd getPA_DrvrSeatLmbrUpDownStsAllowd() throws CarNotConnectedException {
/* 1113 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33599, 1);
/*      */     
/* 1115 */     PATypes.PA_DrvrSeatLmbrUpDownStsAllowd pA_DrvrSeatLmbrUpDownStsAllowd = null;
/*      */     try {
/* 1117 */       PATypes.PA_DrvrSeatLmbrUpDownStsAllowd pA_DrvrSeatLmbrUpDownStsAllowd1 = new PATypes.PA_DrvrSeatLmbrUpDownStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatLmbrUpDownStsAllowd = pA_DrvrSeatLmbrUpDownStsAllowd1;
/* 1118 */     } catch (Exception exception) {}
/*      */     
/* 1120 */     return pA_DrvrSeatLmbrUpDownStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatLmbrFwdBackwStsAllowd getPA_PassSeatLmbrFwdBackwStsAllowd() throws CarNotConnectedException {
/* 1129 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33600, 1);
/*      */     
/* 1131 */     PATypes.PA_PassSeatLmbrFwdBackwStsAllowd pA_PassSeatLmbrFwdBackwStsAllowd = null;
/*      */     try {
/* 1133 */       PATypes.PA_PassSeatLmbrFwdBackwStsAllowd pA_PassSeatLmbrFwdBackwStsAllowd1 = new PATypes.PA_PassSeatLmbrFwdBackwStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatLmbrFwdBackwStsAllowd = pA_PassSeatLmbrFwdBackwStsAllowd1;
/* 1134 */     } catch (Exception exception) {}
/*      */     
/* 1136 */     return pA_PassSeatLmbrFwdBackwStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatLmbrUpDownStsAllowd getPA_PassSeatLmbrUpDownStsAllowd() throws CarNotConnectedException {
/* 1145 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33601, 1);
/*      */     
/* 1147 */     PATypes.PA_PassSeatLmbrUpDownStsAllowd pA_PassSeatLmbrUpDownStsAllowd = null;
/*      */     try {
/* 1149 */       PATypes.PA_PassSeatLmbrUpDownStsAllowd pA_PassSeatLmbrUpDownStsAllowd1 = new PATypes.PA_PassSeatLmbrUpDownStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatLmbrUpDownStsAllowd = pA_PassSeatLmbrUpDownStsAllowd1;
/* 1150 */     } catch (Exception exception) {}
/*      */     
/* 1152 */     return pA_PassSeatLmbrUpDownStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSideFwdBackwStsAllowd getPA_DrvrSeatSideFwdBackwStsAllowd() throws CarNotConnectedException {
/* 1161 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33602, 1);
/*      */     
/* 1163 */     PATypes.PA_DrvrSeatSideFwdBackwStsAllowd pA_DrvrSeatSideFwdBackwStsAllowd = null;
/*      */     try {
/* 1165 */       PATypes.PA_DrvrSeatSideFwdBackwStsAllowd pA_DrvrSeatSideFwdBackwStsAllowd1 = new PATypes.PA_DrvrSeatSideFwdBackwStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSideFwdBackwStsAllowd = pA_DrvrSeatSideFwdBackwStsAllowd1;
/* 1166 */     } catch (Exception exception) {}
/*      */     
/* 1168 */     return pA_DrvrSeatSideFwdBackwStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSideFwdBackwStsAllowd getPA_PassSeatSideFwdBackwStsAllowd() throws CarNotConnectedException {
/* 1177 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33603, 1);
/*      */     
/* 1179 */     PATypes.PA_PassSeatSideFwdBackwStsAllowd pA_PassSeatSideFwdBackwStsAllowd = null;
/*      */     try {
/* 1181 */       PATypes.PA_PassSeatSideFwdBackwStsAllowd pA_PassSeatSideFwdBackwStsAllowd1 = new PATypes.PA_PassSeatSideFwdBackwStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSideFwdBackwStsAllowd = pA_PassSeatSideFwdBackwStsAllowd1;
/* 1182 */     } catch (Exception exception) {}
/*      */     
/* 1184 */     return pA_PassSeatSideFwdBackwStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSideUpDownStsAllowd getPA_DrvrSeatSideUpDownStsAllowd() throws CarNotConnectedException {
/* 1193 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33604, 1);
/*      */     
/* 1195 */     PATypes.PA_DrvrSeatSideUpDownStsAllowd pA_DrvrSeatSideUpDownStsAllowd = null;
/*      */     try {
/* 1197 */       PATypes.PA_DrvrSeatSideUpDownStsAllowd pA_DrvrSeatSideUpDownStsAllowd1 = new PATypes.PA_DrvrSeatSideUpDownStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSideUpDownStsAllowd = pA_DrvrSeatSideUpDownStsAllowd1;
/* 1198 */     } catch (Exception exception) {}
/*      */     
/* 1200 */     return pA_DrvrSeatSideUpDownStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSideUpDownStsAllowd getPA_PassSeatSideUpDownStsAllowd() throws CarNotConnectedException {
/* 1209 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33605, 1);
/*      */     
/* 1211 */     PATypes.PA_PassSeatSideUpDownStsAllowd pA_PassSeatSideUpDownStsAllowd = null;
/*      */     try {
/* 1213 */       PATypes.PA_PassSeatSideUpDownStsAllowd pA_PassSeatSideUpDownStsAllowd1 = new PATypes.PA_PassSeatSideUpDownStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSideUpDownStsAllowd = pA_PassSeatSideUpDownStsAllowd1;
/* 1214 */     } catch (Exception exception) {}
/*      */     
/* 1216 */     return pA_PassSeatSideUpDownStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatCushExtStsAllowd getPA_DrvrSeatCushExtStsAllowd() throws CarNotConnectedException {
/* 1225 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33606, 1);
/*      */     
/* 1227 */     PATypes.PA_DrvrSeatCushExtStsAllowd pA_DrvrSeatCushExtStsAllowd = null;
/*      */     try {
/* 1229 */       PATypes.PA_DrvrSeatCushExtStsAllowd pA_DrvrSeatCushExtStsAllowd1 = new PATypes.PA_DrvrSeatCushExtStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatCushExtStsAllowd = pA_DrvrSeatCushExtStsAllowd1;
/* 1230 */     } catch (Exception exception) {}
/*      */     
/* 1232 */     return pA_DrvrSeatCushExtStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatCushExtStsAllowd getPA_PassSeatCushExtStsAllowd() throws CarNotConnectedException {
/* 1241 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33607, 1);
/*      */     
/* 1243 */     PATypes.PA_PassSeatCushExtStsAllowd pA_PassSeatCushExtStsAllowd = null;
/*      */     try {
/* 1245 */       PATypes.PA_PassSeatCushExtStsAllowd pA_PassSeatCushExtStsAllowd1 = new PATypes.PA_PassSeatCushExtStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatCushExtStsAllowd = pA_PassSeatCushExtStsAllowd1;
/* 1246 */     } catch (Exception exception) {}
/*      */     
/* 1248 */     return pA_PassSeatCushExtStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatMassageStsAllowd getPA_DrvrSeatMassageStsAllowd() throws CarNotConnectedException {
/* 1257 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33608, 1);
/*      */     
/* 1259 */     PATypes.PA_DrvrSeatMassageStsAllowd pA_DrvrSeatMassageStsAllowd = null;
/*      */     try {
/* 1261 */       PATypes.PA_DrvrSeatMassageStsAllowd pA_DrvrSeatMassageStsAllowd1 = new PATypes.PA_DrvrSeatMassageStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatMassageStsAllowd = pA_DrvrSeatMassageStsAllowd1;
/* 1262 */     } catch (Exception exception) {}
/*      */     
/* 1264 */     return pA_DrvrSeatMassageStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatDispMassgFct_OnOff getPA_DrvrSeatDispMassgFct_OnOff() throws CarNotConnectedException {
/* 1273 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33609, 1);
/*      */     
/* 1275 */     PATypes.PA_DrvrSeatDispMassgFct_OnOff pA_DrvrSeatDispMassgFct_OnOff = null;
/*      */     try {
/* 1277 */       PATypes.PA_DrvrSeatDispMassgFct_OnOff pA_DrvrSeatDispMassgFct_OnOff1 = new PATypes.PA_DrvrSeatDispMassgFct_OnOff(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatDispMassgFct_OnOff = pA_DrvrSeatDispMassgFct_OnOff1;
/* 1278 */     } catch (Exception exception) {}
/*      */     
/* 1280 */     return pA_DrvrSeatDispMassgFct_OnOff;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatDispMassgFct_MassgProg getPA_DrvrSeatDispMassgFct_MassgProg() throws CarNotConnectedException {
/* 1289 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33610, 1);
/*      */     
/* 1291 */     PATypes.PA_DrvrSeatDispMassgFct_MassgProg pA_DrvrSeatDispMassgFct_MassgProg = null;
/*      */     try {
/* 1293 */       PATypes.PA_DrvrSeatDispMassgFct_MassgProg pA_DrvrSeatDispMassgFct_MassgProg1 = new PATypes.PA_DrvrSeatDispMassgFct_MassgProg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatDispMassgFct_MassgProg = pA_DrvrSeatDispMassgFct_MassgProg1;
/* 1294 */     } catch (Exception exception) {}
/*      */     
/* 1296 */     return pA_DrvrSeatDispMassgFct_MassgProg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatDispMassgFct_MassgInten getPA_DrvrSeatDispMassgFct_MassgInten() throws CarNotConnectedException {
/* 1305 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33611, 1);
/*      */     
/* 1307 */     PATypes.PA_DrvrSeatDispMassgFct_MassgInten pA_DrvrSeatDispMassgFct_MassgInten = null;
/*      */     try {
/* 1309 */       PATypes.PA_DrvrSeatDispMassgFct_MassgInten pA_DrvrSeatDispMassgFct_MassgInten1 = new PATypes.PA_DrvrSeatDispMassgFct_MassgInten(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatDispMassgFct_MassgInten = pA_DrvrSeatDispMassgFct_MassgInten1;
/* 1310 */     } catch (Exception exception) {}
/*      */     
/* 1312 */     return pA_DrvrSeatDispMassgFct_MassgInten;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatMassageStsAllowd getPA_PassSeatMassageStsAllowd() throws CarNotConnectedException {
/* 1321 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33612, 1);
/*      */     
/* 1323 */     PATypes.PA_PassSeatMassageStsAllowd pA_PassSeatMassageStsAllowd = null;
/*      */     try {
/* 1325 */       PATypes.PA_PassSeatMassageStsAllowd pA_PassSeatMassageStsAllowd1 = new PATypes.PA_PassSeatMassageStsAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatMassageStsAllowd = pA_PassSeatMassageStsAllowd1;
/* 1326 */     } catch (Exception exception) {}
/*      */     
/* 1328 */     return pA_PassSeatMassageStsAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatDispMassgFct_OnOff getPA_PassSeatDispMassgFct_OnOff() throws CarNotConnectedException {
/* 1337 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33613, 1);
/*      */     
/* 1339 */     PATypes.PA_PassSeatDispMassgFct_OnOff pA_PassSeatDispMassgFct_OnOff = null;
/*      */     try {
/* 1341 */       PATypes.PA_PassSeatDispMassgFct_OnOff pA_PassSeatDispMassgFct_OnOff1 = new PATypes.PA_PassSeatDispMassgFct_OnOff(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatDispMassgFct_OnOff = pA_PassSeatDispMassgFct_OnOff1;
/* 1342 */     } catch (Exception exception) {}
/*      */     
/* 1344 */     return pA_PassSeatDispMassgFct_OnOff;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatDispMassgFct_MassgProg getPA_PassSeatDispMassgFct_MassgProg() throws CarNotConnectedException {
/* 1353 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33614, 1);
/*      */     
/* 1355 */     PATypes.PA_PassSeatDispMassgFct_MassgProg pA_PassSeatDispMassgFct_MassgProg = null;
/*      */     try {
/* 1357 */       PATypes.PA_PassSeatDispMassgFct_MassgProg pA_PassSeatDispMassgFct_MassgProg1 = new PATypes.PA_PassSeatDispMassgFct_MassgProg(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatDispMassgFct_MassgProg = pA_PassSeatDispMassgFct_MassgProg1;
/* 1358 */     } catch (Exception exception) {}
/*      */     
/* 1360 */     return pA_PassSeatDispMassgFct_MassgProg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatDispMassgFct_MassgInten getPA_PassSeatDispMassgFct_MassgInten() throws CarNotConnectedException {
/* 1369 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33615, 1);
/*      */     
/* 1371 */     PATypes.PA_PassSeatDispMassgFct_MassgInten pA_PassSeatDispMassgFct_MassgInten = null;
/*      */     try {
/* 1373 */       PATypes.PA_PassSeatDispMassgFct_MassgInten pA_PassSeatDispMassgFct_MassgInten1 = new PATypes.PA_PassSeatDispMassgFct_MassgInten(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatDispMassgFct_MassgInten = pA_PassSeatDispMassgFct_MassgInten1;
/* 1374 */     } catch (Exception exception) {}
/*      */     
/* 1376 */     return pA_PassSeatDispMassgFct_MassgInten;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrMassgRunng getPA_DrvrMassgRunng() throws CarNotConnectedException {
/* 1385 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33616, 1);
/*      */     
/* 1387 */     PATypes.PA_DrvrMassgRunng pA_DrvrMassgRunng = null;
/*      */     try {
/* 1389 */       PATypes.PA_DrvrMassgRunng pA_DrvrMassgRunng1 = new PATypes.PA_DrvrMassgRunng(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrMassgRunng = pA_DrvrMassgRunng1;
/* 1390 */     } catch (Exception exception) {}
/*      */     
/* 1392 */     return pA_DrvrMassgRunng;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassMassgRunng getPA_PassMassgRunng() throws CarNotConnectedException {
/* 1401 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33617, 1);
/*      */     
/* 1403 */     PATypes.PA_PassMassgRunng pA_PassMassgRunng = null;
/*      */     try {
/* 1405 */       PATypes.PA_PassMassgRunng pA_PassMassgRunng1 = new PATypes.PA_PassMassgRunng(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassMassgRunng = pA_PassMassgRunng1;
/* 1406 */     } catch (Exception exception) {}
/*      */     
/* 1408 */     return pA_PassMassgRunng;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrMultFuncMenuExt getPA_DrvrMultFuncMenuExt() throws CarNotConnectedException {
/* 1417 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33618, 1);
/*      */     
/* 1419 */     PATypes.PA_DrvrMultFuncMenuExt pA_DrvrMultFuncMenuExt = null;
/*      */     try {
/* 1421 */       PATypes.PA_DrvrMultFuncMenuExt pA_DrvrMultFuncMenuExt1 = new PATypes.PA_DrvrMultFuncMenuExt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrMultFuncMenuExt = pA_DrvrMultFuncMenuExt1;
/* 1422 */     } catch (Exception exception) {}
/*      */     
/* 1424 */     return pA_DrvrMultFuncMenuExt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassMultFuncMenuExt getPA_PassMultFuncMenuExt() throws CarNotConnectedException {
/* 1433 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33619, 1);
/*      */     
/* 1435 */     PATypes.PA_PassMultFuncMenuExt pA_PassMultFuncMenuExt = null;
/*      */     try {
/* 1437 */       PATypes.PA_PassMultFuncMenuExt pA_PassMultFuncMenuExt1 = new PATypes.PA_PassMultFuncMenuExt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassMultFuncMenuExt = pA_PassMultFuncMenuExt1;
/* 1438 */     } catch (Exception exception) {}
/*      */     
/* 1440 */     return pA_PassMultFuncMenuExt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SeatFoldRaiseRowThrdLeAllowd getPA_SeatFoldRaiseRowThrdLeAllowd() throws CarNotConnectedException {
/* 1449 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33620, 1);
/*      */     
/* 1451 */     PATypes.PA_SeatFoldRaiseRowThrdLeAllowd pA_SeatFoldRaiseRowThrdLeAllowd = null;
/*      */     try {
/* 1453 */       PATypes.PA_SeatFoldRaiseRowThrdLeAllowd pA_SeatFoldRaiseRowThrdLeAllowd1 = new PATypes.PA_SeatFoldRaiseRowThrdLeAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SeatFoldRaiseRowThrdLeAllowd = pA_SeatFoldRaiseRowThrdLeAllowd1;
/* 1454 */     } catch (Exception exception) {}
/*      */     
/* 1456 */     return pA_SeatFoldRaiseRowThrdLeAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SeatFoldRaiseRowThrdRiAllowd getPA_SeatFoldRaiseRowThrdRiAllowd() throws CarNotConnectedException {
/* 1465 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33621, 1);
/*      */     
/* 1467 */     PATypes.PA_SeatFoldRaiseRowThrdRiAllowd pA_SeatFoldRaiseRowThrdRiAllowd = null;
/*      */     try {
/* 1469 */       PATypes.PA_SeatFoldRaiseRowThrdRiAllowd pA_SeatFoldRaiseRowThrdRiAllowd1 = new PATypes.PA_SeatFoldRaiseRowThrdRiAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SeatFoldRaiseRowThrdRiAllowd = pA_SeatFoldRaiseRowThrdRiAllowd1;
/* 1470 */     } catch (Exception exception) {}
/*      */     
/* 1472 */     return pA_SeatFoldRaiseRowThrdRiAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SecRowSeatLenLeFwdBackwAllowd getPA_SecRowSeatLenLeFwdBackwAllowd() throws CarNotConnectedException {
/* 1481 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33622, 1);
/*      */     
/* 1483 */     PATypes.PA_SecRowSeatLenLeFwdBackwAllowd pA_SecRowSeatLenLeFwdBackwAllowd = null;
/*      */     try {
/* 1485 */       PATypes.PA_SecRowSeatLenLeFwdBackwAllowd pA_SecRowSeatLenLeFwdBackwAllowd1 = new PATypes.PA_SecRowSeatLenLeFwdBackwAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SecRowSeatLenLeFwdBackwAllowd = pA_SecRowSeatLenLeFwdBackwAllowd1;
/* 1486 */     } catch (Exception exception) {}
/*      */     
/* 1488 */     return pA_SecRowSeatLenLeFwdBackwAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts getPA_SeatRowSecLeSwtStsPassSeatSwtSldSts() throws CarNotConnectedException {
/* 1497 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33623, 1);
/*      */     
/* 1499 */     PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts pA_SeatRowSecLeSwtStsPassSeatSwtSldSts = null;
/*      */     try {
/* 1501 */       PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts pA_SeatRowSecLeSwtStsPassSeatSwtSldSts1 = new PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SeatRowSecLeSwtStsPassSeatSwtSldSts = pA_SeatRowSecLeSwtStsPassSeatSwtSldSts1;
/* 1502 */     } catch (Exception exception) {}
/*      */     
/* 1504 */     return pA_SeatRowSecLeSwtStsPassSeatSwtSldSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SecRowSeatLenRiFwdBackwAllowd getPA_SecRowSeatLenRiFwdBackwAllowd() throws CarNotConnectedException {
/* 1513 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33624, 1);
/*      */     
/* 1515 */     PATypes.PA_SecRowSeatLenRiFwdBackwAllowd pA_SecRowSeatLenRiFwdBackwAllowd = null;
/*      */     try {
/* 1517 */       PATypes.PA_SecRowSeatLenRiFwdBackwAllowd pA_SecRowSeatLenRiFwdBackwAllowd1 = new PATypes.PA_SecRowSeatLenRiFwdBackwAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SecRowSeatLenRiFwdBackwAllowd = pA_SecRowSeatLenRiFwdBackwAllowd1;
/* 1518 */     } catch (Exception exception) {}
/*      */     
/* 1520 */     return pA_SecRowSeatLenRiFwdBackwAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts getPA_SeatRowSecRiSwtStsPassSeatSwtSldSts() throws CarNotConnectedException {
/* 1529 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33625, 1);
/*      */     
/* 1531 */     PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts pA_SeatRowSecRiSwtStsPassSeatSwtSldSts = null;
/*      */     try {
/* 1533 */       PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts pA_SeatRowSecRiSwtStsPassSeatSwtSldSts1 = new PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SeatRowSecRiSwtStsPassSeatSwtSldSts = pA_SeatRowSecRiSwtStsPassSeatSwtSldSts1;
/* 1534 */     } catch (Exception exception) {}
/*      */     
/* 1536 */     return pA_SeatRowSecRiSwtStsPassSeatSwtSldSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SecRowSeatInclLeFwdBackwAllowd getPA_SecRowSeatInclLeFwdBackwAllowd() throws CarNotConnectedException {
/* 1545 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33626, 1);
/*      */     
/* 1547 */     PATypes.PA_SecRowSeatInclLeFwdBackwAllowd pA_SecRowSeatInclLeFwdBackwAllowd = null;
/*      */     try {
/* 1549 */       PATypes.PA_SecRowSeatInclLeFwdBackwAllowd pA_SecRowSeatInclLeFwdBackwAllowd1 = new PATypes.PA_SecRowSeatInclLeFwdBackwAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SecRowSeatInclLeFwdBackwAllowd = pA_SecRowSeatInclLeFwdBackwAllowd1;
/* 1550 */     } catch (Exception exception) {}
/*      */     
/* 1552 */     return pA_SecRowSeatInclLeFwdBackwAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SecRowSeatInclRiFwdBackwAllowd getPA_SecRowSeatInclRiFwdBackwAllowd() throws CarNotConnectedException {
/* 1561 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33627, 1);
/*      */     
/* 1563 */     PATypes.PA_SecRowSeatInclRiFwdBackwAllowd pA_SecRowSeatInclRiFwdBackwAllowd = null;
/*      */     try {
/* 1565 */       PATypes.PA_SecRowSeatInclRiFwdBackwAllowd pA_SecRowSeatInclRiFwdBackwAllowd1 = new PATypes.PA_SecRowSeatInclRiFwdBackwAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SecRowSeatInclRiFwdBackwAllowd = pA_SecRowSeatInclRiFwdBackwAllowd1;
/* 1566 */     } catch (Exception exception) {}
/*      */     
/* 1568 */     return pA_SecRowSeatInclRiFwdBackwAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts getPA_SeatRowSecLeSwtStsPassSeatSwtInclSts() throws CarNotConnectedException {
/* 1577 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33628, 1);
/*      */     
/* 1579 */     PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts pA_SeatRowSecLeSwtStsPassSeatSwtInclSts = null;
/*      */     try {
/* 1581 */       PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts pA_SeatRowSecLeSwtStsPassSeatSwtInclSts1 = new PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SeatRowSecLeSwtStsPassSeatSwtInclSts = pA_SeatRowSecLeSwtStsPassSeatSwtInclSts1;
/* 1582 */     } catch (Exception exception) {}
/*      */     
/* 1584 */     return pA_SeatRowSecLeSwtStsPassSeatSwtInclSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts getPA_SeatRowSecRiSwtStsPassSeatSwtInclSts() throws CarNotConnectedException {
/* 1593 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33629, 1);
/*      */     
/* 1595 */     PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts pA_SeatRowSecRiSwtStsPassSeatSwtInclSts = null;
/*      */     try {
/* 1597 */       PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts pA_SeatRowSecRiSwtStsPassSeatSwtInclSts1 = new PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SeatRowSecRiSwtStsPassSeatSwtInclSts = pA_SeatRowSecRiSwtStsPassSeatSwtInclSts1;
/* 1598 */     } catch (Exception exception) {}
/*      */     
/* 1600 */     return pA_SeatRowSecRiSwtStsPassSeatSwtInclSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_HotStoneMassageDrvrAllowd getPA_HotStoneMassageDrvrAllowd() throws CarNotConnectedException {
/* 1609 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33630, 1);
/*      */     
/* 1611 */     PATypes.PA_HotStoneMassageDrvrAllowd pA_HotStoneMassageDrvrAllowd = null;
/*      */     try {
/* 1613 */       PATypes.PA_HotStoneMassageDrvrAllowd pA_HotStoneMassageDrvrAllowd1 = new PATypes.PA_HotStoneMassageDrvrAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HotStoneMassageDrvrAllowd = pA_HotStoneMassageDrvrAllowd1;
/* 1614 */     } catch (Exception exception) {}
/*      */     
/* 1616 */     return pA_HotStoneMassageDrvrAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_HotStoneMassagePassAllowd getPA_HotStoneMassagePassAllowd() throws CarNotConnectedException {
/* 1625 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33631, 1);
/*      */     
/* 1627 */     PATypes.PA_HotStoneMassagePassAllowd pA_HotStoneMassagePassAllowd = null;
/*      */     try {
/* 1629 */       PATypes.PA_HotStoneMassagePassAllowd pA_HotStoneMassagePassAllowd1 = new PATypes.PA_HotStoneMassagePassAllowd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_HotStoneMassagePassAllowd = pA_HotStoneMassagePassAllowd1;
/* 1630 */     } catch (Exception exception) {}
/*      */     
/* 1632 */     return pA_HotStoneMassagePassAllowd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts getPA_DrvrSeatSwtSelnOfSpplFctSts() throws CarNotConnectedException {
/* 1641 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33632, 1);
/*      */     
/* 1643 */     PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts pA_DrvrSeatSwtSelnOfSpplFctSts = null;
/*      */     try {
/* 1645 */       PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts pA_DrvrSeatSwtSelnOfSpplFctSts1 = new PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_DrvrSeatSwtSelnOfSpplFctSts = pA_DrvrSeatSwtSelnOfSpplFctSts1;
/* 1646 */     } catch (Exception exception) {}
/*      */     
/* 1648 */     return pA_DrvrSeatSwtSelnOfSpplFctSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_PassSeatSwtSelnOfSpplFctSts getPA_PassSeatSwtSelnOfSpplFctSts() throws CarNotConnectedException {
/* 1657 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33633, 1);
/*      */     
/* 1659 */     PATypes.PA_PassSeatSwtSelnOfSpplFctSts pA_PassSeatSwtSelnOfSpplFctSts = null;
/*      */     try {
/* 1661 */       PATypes.PA_PassSeatSwtSelnOfSpplFctSts pA_PassSeatSwtSelnOfSpplFctSts1 = new PATypes.PA_PassSeatSwtSelnOfSpplFctSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PassSeatSwtSelnOfSpplFctSts = pA_PassSeatSwtSelnOfSpplFctSts1;
/* 1662 */     } catch (Exception exception) {}
/*      */     
/* 1664 */     return pA_PassSeatSwtSelnOfSpplFctSts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_SC_MsgEnd getPA_SC_MsgEnd() throws CarNotConnectedException {
/* 1673 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33920, 1);
/*      */     
/* 1675 */     PATypes.PA_SC_MsgEnd pA_SC_MsgEnd = null;
/*      */     try {
/* 1677 */       PATypes.PA_SC_MsgEnd pA_SC_MsgEnd1 = new PATypes.PA_SC_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SC_MsgEnd = pA_SC_MsgEnd1;
/* 1678 */     } catch (Exception exception) {}
/*      */     
/* 1680 */     return pA_SC_MsgEnd;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarSeatctrlManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */