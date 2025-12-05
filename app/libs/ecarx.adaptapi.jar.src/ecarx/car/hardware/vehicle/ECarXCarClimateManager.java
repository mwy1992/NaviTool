/*      */ package ecarx.car.hardware.vehicle;
/*      */ 
/*      */ import android.car.CarNotConnectedException;
/*      */ import com.google.protobuf.nano.MessageNano;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.annotation.ElecAirDirMod;
/*      */ import ecarx.car.hardware.annotation.HmiCmptmtAirDistbnFrnt;
/*      */ import ecarx.car.hardware.annotation.HmiHvacFanLvl;
/*      */ import ecarx.car.hardware.annotation.LongPresBtn;
/*      */ import ecarx.car.hardware.annotation.OnOff1;
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
/*      */ 
/*      */ public class ECarXCarClimateManager
/*      */   extends ECarXCarFuncManagerBase
/*      */ {
/*      */   private static final boolean DBG = false;
/*      */   public static final int ManagerId_cbclac = 32798;
/*      */   public static final int ManagerId_cbclairctrloff = 32812;
/*      */   public static final int ManagerId_cbclauto = 32799;
/*      */   public static final int ManagerId_cbclautodefrostpop = 32818;
/*      */   public static final int ManagerId_cbclautodefrostsetting = 32817;
/*      */   public static final int ManagerId_cbclautosetting = 32793;
/*      */   public static final int ManagerId_cbclclmclosewinpop = 32839;
/*      */   public static final int ManagerId_cbclecoclimate = 32823;
/*      */   public static final int ManagerId_cbclelecairdirdrvmod = 32824;
/*      */   public static final int ManagerId_cbclelecairdirpassmod = 32825;
/*      */   public static final int ManagerId_cbclelecairdrvlepos = 32828;
/*      */   public static final int ManagerId_cbclelecairdrvripos = 32829;
/*      */   public static final int ManagerId_cbclelecairdrvrleriswng = 32832;
/*      */   public static final int ManagerId_cbclelecairdrvruponswng = 32833;
/*      */   public static final int ManagerId_cbclelecairdrvswt = 32826;
/*      */   public static final int ManagerId_cbclelecairpasslepos = 32830;
/*      */   public static final int ManagerId_cbclelecairpassleriswng = 32834;
/*      */   public static final int ManagerId_cbclelecairpassripos = 32831;
/*      */   public static final int ManagerId_cbclelecairpassswt = 32827;
/*      */   public static final int ManagerId_cbclelecairpassuponswng = 32835;
/*      */   public static final int ManagerId_cbclfanlevel = 32805;
/*      */   public static final int ManagerId_cbclfrontdefrost = 32809;
/*      */   public static final int ManagerId_cbclgclean = 32843;
/*      */   public static final int ManagerId_cbclhumctrl = 32820;
/*      */   public static final int ManagerId_cbclhumpop = 32821;
/*      */   public static final int ManagerId_cbclhvacrectrl = 32813;
/*      */   public static final int ManagerId_cbclintecleanunplesmell = 32844;
/*      */   public static final int ManagerId_cbclintelliclimapop = 32822;
/*      */   public static final int ManagerId_cbcllefttemp = 32806;
/*      */   public static final int ManagerId_cbclmaxac = 32804;
/*      */   public static final int ManagerId_cbclmaxdefrost = 32808;
/*      */   public static final int ManagerId_cbclmodefrstleft = 32801;
/*      */   public static final int ManagerId_cbclmodefrstright = 32802;
/*      */   public static final int ManagerId_cbclmodesec = 32803;
/*      */   public static final int ManagerId_cbclpost = 32796;
/*      */   public static final int ManagerId_cbclpre = 32797;
/*      */   public static final int ManagerId_cbclrcirc = 32800;
/*      */   public static final int ManagerId_cbclreardefrost = 32810;
/*      */   public static final int ManagerId_cbclreboot = 32845;
/*      */   public static final int ManagerId_cbclrecircsetting = 32792;
/*      */   public static final int ManagerId_cbclrighttemp = 32807;
/*      */   public static final int ManagerId_cbclsecautosw = 32842;
/*      */   public static final int ManagerId_cbclsecfanlevel = 32816;
/*      */   public static final int ManagerId_cbclseclefttemp = 32814;
/*      */   public static final int ManagerId_cbclseclockclimasw = 32841;
/*      */   public static final int ManagerId_cbclsecrighttemp = 32815;
/*      */   public static final int ManagerId_cbclsecrowonoffswith = 32819;
/*      */   public static final int ManagerId_cbclsync = 32811;
/*      */   public static final int ManagerId_cbcltwinrfclsdpopsw = 32840;
/*      */   public static final int ManagerId_cbclwipfrntsrvmod = 32837;
/*      */   public static final int ManagerId_cbclwipreautreq = 32836;
/*      */   public static final int ManagerId_cbclwipresrvmod = 32838;
/*      */   public static final int ManagerId_cbwdcautofrontdefrost = 32794;
/*      */   public static final int ManagerId_cbwdcautoreardefrost = 32795;
/*      */   public static final int ManagerId_paclac = 33317;
/*      */   public static final int ManagerId_paclairctrloff = 33338;
/*      */   public static final int ManagerId_paclauto = 33318;
/*      */   public static final int ManagerId_paclautodefrostpopup = 33344;
/*      */   public static final int ManagerId_paclautodefrostsetting = 33343;
/*      */   public static final int ManagerId_paclautosetting = 33328;
/*      */   public static final int ManagerId_paclccsmpopup = 33365;
/*      */   public static final int ManagerId_paclclmclosewinpop = 33355;
/*      */   public static final int ManagerId_pacldrvelecair = 33363;
/*      */   public static final int ManagerId_pacldrvswt = 33356;
/*      */   public static final int ManagerId_paclecoclimate = 33335;
/*      */   public static final int ManagerId_paclelecairavlstspop = 33358;
/*      */   public static final int ManagerId_paclelecdefrunerr = 33366;
/*      */   public static final int ManagerId_paclfanlevel = 33324;
/*      */   public static final int ManagerId_paclfanlevelbyhardkey = 33368;
/*      */   public static final int ManagerId_paclfrntdefrostpopup = 33345;
/*      */   public static final int ManagerId_paclfrontdefrost = 33332;
/*      */   public static final int ManagerId_paclgclean = 33362;
/*      */   public static final int ManagerId_paclhumctrl = 33349;
/*      */   public static final int ManagerId_paclhumpop = 33350;
/*      */   public static final int ManagerId_paclhvacrectr = 33339;
/*      */   public static final int ManagerId_paclintecleanunplesmell = 33367;
/*      */   public static final int ManagerId_paclintelliclimapop = 33351;
/*      */   public static final int ManagerId_pacllefttemp = 33325;
/*      */   public static final int ManagerId_pacllefttempbyhardkey = 33369;
/*      */   public static final int ManagerId_paclmaxac = 33323;
/*      */   public static final int ManagerId_paclmaxdefrost = 33329;
/*      */   public static final int ManagerId_paclmodefrstleft = 33320;
/*      */   public static final int ManagerId_paclmodefrstleftbyhardkey = 33370;
/*      */   public static final int ManagerId_paclmodefrstright = 33321;
/*      */   public static final int ManagerId_paclmodesec = 33322;
/*      */   public static final int ManagerId_paclmsgend = 33907;
/*      */   public static final int ManagerId_paclpasselecair = 33364;
/*      */   public static final int ManagerId_paclpassswt = 33357;
/*      */   public static final int ManagerId_paclpost = 33337;
/*      */   public static final int ManagerId_paclpostclimawarn = 33348;
/*      */   public static final int ManagerId_paclpre = 33336;
/*      */   public static final int ManagerId_paclreardefrost = 33333;
/*      */   public static final int ManagerId_paclreardefrostpopup = 33346;
/*      */   public static final int ManagerId_paclrecirc = 33319;
/*      */   public static final int ManagerId_paclrecircsetting = 33327;
/*      */   public static final int ManagerId_paclrighttemp = 33326;
/*      */   public static final int ManagerId_paclsecautosw = 33361;
/*      */   public static final int ManagerId_paclsecfanlevel = 33342;
/*      */   public static final int ManagerId_paclseclefttemp = 33340;
/*      */   public static final int ManagerId_paclseclockclimasw = 33360;
/*      */   public static final int ManagerId_paclsecrighttemp = 33341;
/*      */   public static final int ManagerId_paclsecrowonoffswith = 33347;
/*      */   public static final int ManagerId_paclsync = 33334;
/*      */   public static final int ManagerId_pacltwinrfclsdpopsw = 33359;
/*      */   public static final int ManagerId_paclwipfrntsrvmod = 33353;
/*      */   public static final int ManagerId_paclwipreautreq = 33352;
/*      */   public static final int ManagerId_paclwipresrvmod = 33354;
/*      */   public static final int ManagerId_pawdcautofrontdefrost = 33330;
/*      */   public static final int ManagerId_pawdcautoreardefrost = 33331;
/*      */   private static final String TAG = "ECarXCarClimateManager";
/*      */   public static final int VehicleArea_Global = 1;
/*      */   public static final int VehicleArea_Zone = 2;
/*      */   
/*      */   public ECarXCarClimateManager() {}
/*      */   
/*      */   public ECarXCarClimateManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  166 */     super(paramECarXCarPropertyManagerBase);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_RecircSetting(int paramInt) {
/*  176 */     ApiResult apiResult = ApiResult.FAILED;
/*  177 */     if (OnOff1.isValid(paramInt)) {
/*  178 */       apiResult = this.mMgr.setIntProperty(32792, 1, paramInt);
/*      */     } else {
/*  180 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  182 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_AutoSetting(int paramInt) {
/*  192 */     ApiResult apiResult = ApiResult.FAILED;
/*  193 */     if (OnOff1.isValid(paramInt)) {
/*  194 */       apiResult = this.mMgr.setIntProperty(32793, 1, paramInt);
/*      */     } else {
/*  196 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  198 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_WDC_AutoFrontDefrost(int paramInt) {
/*  208 */     ApiResult apiResult = ApiResult.FAILED;
/*  209 */     if (OnOff1.isValid(paramInt)) {
/*  210 */       apiResult = this.mMgr.setIntProperty(32794, 1, paramInt);
/*      */     } else {
/*  212 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  214 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_WDC_AutoRearDefrost(int paramInt) {
/*  224 */     ApiResult apiResult = ApiResult.FAILED;
/*  225 */     if (OnOff1.isValid(paramInt)) {
/*  226 */       apiResult = this.mMgr.setIntProperty(32795, 1, paramInt);
/*      */     } else {
/*  228 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  230 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_Post(int paramInt) {
/*  240 */     ApiResult apiResult = ApiResult.FAILED;
/*  241 */     if (OnOff1.isValid(paramInt)) {
/*  242 */       apiResult = this.mMgr.setIntProperty(32796, 1, paramInt);
/*      */     } else {
/*  244 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  246 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_Pre(int paramInt) {
/*  256 */     ApiResult apiResult = ApiResult.FAILED;
/*  257 */     if (OnOff1.isValid(paramInt)) {
/*  258 */       apiResult = this.mMgr.setIntProperty(32797, 1, paramInt);
/*      */     } else {
/*  260 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  262 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_AC(int paramInt) {
/*  272 */     ApiResult apiResult = ApiResult.FAILED;
/*  273 */     if (OnOff1.isValid(paramInt)) {
/*  274 */       apiResult = this.mMgr.setIntProperty(32798, 1, paramInt);
/*      */     } else {
/*  276 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  278 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_Auto(int paramInt) {
/*  288 */     ApiResult apiResult = ApiResult.FAILED;
/*  289 */     if (LongPresBtn.isValid(paramInt)) {
/*  290 */       apiResult = this.mMgr.setIntProperty(32799, 1, paramInt);
/*      */     } else {
/*  292 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  294 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_Rcirc(int paramInt) {
/*  304 */     ApiResult apiResult = ApiResult.FAILED;
/*  305 */     if (LongPresBtn.isValid(paramInt)) {
/*  306 */       apiResult = this.mMgr.setIntProperty(32800, 1, paramInt);
/*      */     } else {
/*  308 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  310 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ModeFrstLeft(int paramInt) {
/*  320 */     ApiResult apiResult = ApiResult.FAILED;
/*  321 */     if (HmiCmptmtAirDistbnFrnt.isValid(paramInt)) {
/*  322 */       apiResult = this.mMgr.setIntProperty(32801, 1, paramInt);
/*      */     } else {
/*  324 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  326 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ModeFrstRight(int paramInt) {
/*  336 */     ApiResult apiResult = ApiResult.FAILED;
/*  337 */     if (HmiCmptmtAirDistbnFrnt.isValid(paramInt)) {
/*  338 */       apiResult = this.mMgr.setIntProperty(32802, 1, paramInt);
/*      */     } else {
/*  340 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  342 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ModeSec(int paramInt) {
/*  352 */     ApiResult apiResult = ApiResult.FAILED;
/*  353 */     if (HmiCmptmtAirDistbnFrnt.isValid(paramInt)) {
/*  354 */       apiResult = this.mMgr.setIntProperty(32803, 1, paramInt);
/*      */     } else {
/*  356 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  358 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_MaxAC(int paramInt) {
/*  368 */     ApiResult apiResult = ApiResult.FAILED;
/*  369 */     if (OnOff1.isValid(paramInt)) {
/*  370 */       apiResult = this.mMgr.setIntProperty(32804, 1, paramInt);
/*      */     } else {
/*  372 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  374 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_FanLevel(int paramInt) {
/*  384 */     ApiResult apiResult = ApiResult.FAILED;
/*  385 */     if (HmiHvacFanLvl.isValid(paramInt)) {
/*  386 */       apiResult = this.mMgr.setIntProperty(32805, 1, paramInt);
/*      */     } else {
/*  388 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  390 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_LeftTemp(int paramInt) {
/*  400 */     return this.mMgr.setIntProperty(32806, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_RightTemp(int paramInt) {
/*  410 */     return this.mMgr.setIntProperty(32807, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_MaxDefrost(int paramInt) {
/*  420 */     ApiResult apiResult = ApiResult.FAILED;
/*  421 */     if (OnOff1.isValid(paramInt)) {
/*  422 */       apiResult = this.mMgr.setIntProperty(32808, 1, paramInt);
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
/*      */   public ApiResult CB_CL_FrontDefrost(int paramInt) {
/*  436 */     ApiResult apiResult = ApiResult.FAILED;
/*  437 */     if (OnOff1.isValid(paramInt)) {
/*  438 */       apiResult = this.mMgr.setIntProperty(32809, 1, paramInt);
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
/*      */   public ApiResult CB_CL_RearDefrost(int paramInt) {
/*  452 */     ApiResult apiResult = ApiResult.FAILED;
/*  453 */     if (OnOff1.isValid(paramInt)) {
/*  454 */       apiResult = this.mMgr.setIntProperty(32810, 1, paramInt);
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
/*      */   public ApiResult CB_CL_Sync(int paramInt) {
/*  468 */     ApiResult apiResult = ApiResult.FAILED;
/*  469 */     if (OnOff1.isValid(paramInt)) {
/*  470 */       apiResult = this.mMgr.setIntProperty(32811, 1, paramInt);
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
/*      */   public ApiResult CB_CL_AirCtrlOff(int paramInt) {
/*  484 */     ApiResult apiResult = ApiResult.FAILED;
/*  485 */     if (OnOff1.isValid(paramInt)) {
/*  486 */       apiResult = this.mMgr.setIntProperty(32812, 1, paramInt);
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
/*      */   public ApiResult CB_CL_HvacReCtrl(int paramInt) {
/*  500 */     ApiResult apiResult = ApiResult.FAILED;
/*  501 */     if (OnOff1.isValid(paramInt)) {
/*  502 */       apiResult = this.mMgr.setIntProperty(32813, 1, paramInt);
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
/*      */   public ApiResult CB_CL_SecLeftTemp(int paramInt) {
/*  516 */     return this.mMgr.setIntProperty(32814, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_SecRightTemp(int paramInt) {
/*  526 */     return this.mMgr.setIntProperty(32815, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_SecFanLevel(int paramInt) {
/*  536 */     ApiResult apiResult = ApiResult.FAILED;
/*  537 */     if (HmiHvacFanLvl.isValid(paramInt)) {
/*  538 */       apiResult = this.mMgr.setIntProperty(32816, 1, paramInt);
/*      */     } else {
/*  540 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  542 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_AutoDefrostSetting(int paramInt) {
/*  552 */     ApiResult apiResult = ApiResult.FAILED;
/*  553 */     if (OnOff1.isValid(paramInt)) {
/*  554 */       apiResult = this.mMgr.setIntProperty(32817, 1, paramInt);
/*      */     } else {
/*  556 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  558 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_AutoDefrostPop(int paramInt) {
/*  568 */     ApiResult apiResult = ApiResult.FAILED;
/*  569 */     if (OnOff1.isValid(paramInt)) {
/*  570 */       apiResult = this.mMgr.setIntProperty(32818, 1, paramInt);
/*      */     } else {
/*  572 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  574 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_SecRowOnOffSwith(int paramInt) {
/*  584 */     ApiResult apiResult = ApiResult.FAILED;
/*  585 */     if (OnOff1.isValid(paramInt)) {
/*  586 */       apiResult = this.mMgr.setIntProperty(32819, 1, paramInt);
/*      */     } else {
/*  588 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  590 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_HumCtrl(int paramInt) {
/*  600 */     ApiResult apiResult = ApiResult.FAILED;
/*  601 */     if (OnOff1.isValid(paramInt)) {
/*  602 */       apiResult = this.mMgr.setIntProperty(32820, 1, paramInt);
/*      */     } else {
/*  604 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  606 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_HumPop(int paramInt) {
/*  616 */     ApiResult apiResult = ApiResult.FAILED;
/*  617 */     if (OnOff1.isValid(paramInt)) {
/*  618 */       apiResult = this.mMgr.setIntProperty(32821, 1, paramInt);
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
/*      */   public ApiResult CB_CL_IntelliClimaPop(int paramInt) {
/*  632 */     ApiResult apiResult = ApiResult.FAILED;
/*  633 */     if (OnOff1.isValid(paramInt)) {
/*  634 */       apiResult = this.mMgr.setIntProperty(32822, 1, paramInt);
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
/*      */   public ApiResult CB_CL_ECOClimate(int paramInt) {
/*  648 */     ApiResult apiResult = ApiResult.FAILED;
/*  649 */     if (OnOff1.isValid(paramInt)) {
/*  650 */       apiResult = this.mMgr.setIntProperty(32823, 1, paramInt);
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
/*      */   public ApiResult CB_CL_ElecAirDirDrvMod(int paramInt) {
/*  664 */     ApiResult apiResult = ApiResult.FAILED;
/*  665 */     if (ElecAirDirMod.isValid(paramInt)) {
/*  666 */       apiResult = this.mMgr.setIntProperty(32824, 1, paramInt);
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
/*      */   public ApiResult CB_CL_ElecAirDirPassMod(int paramInt) {
/*  680 */     ApiResult apiResult = ApiResult.FAILED;
/*  681 */     if (ElecAirDirMod.isValid(paramInt)) {
/*  682 */       apiResult = this.mMgr.setIntProperty(32825, 1, paramInt);
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
/*      */   public ApiResult CB_CL_ElecAirDrvSwt(int paramInt) {
/*  696 */     ApiResult apiResult = ApiResult.FAILED;
/*  697 */     if (OnOff1.isValid(paramInt)) {
/*  698 */       apiResult = this.mMgr.setIntProperty(32826, 1, paramInt);
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
/*      */   public ApiResult CB_CL_ElecAirPassSwt(int paramInt) {
/*  712 */     ApiResult apiResult = ApiResult.FAILED;
/*  713 */     if (OnOff1.isValid(paramInt)) {
/*  714 */       apiResult = this.mMgr.setIntProperty(32827, 1, paramInt);
/*      */     } else {
/*  716 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  718 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void CB_CL_ElecAirDrvLePos(VendorVehicleHalPAProto.Coordinates paramCoordinates) {
/*  726 */     this.mMgr.setbytesProperty(32828, 1, VendorVehicleHalPAProto.Coordinates.toByteArray((MessageNano)paramCoordinates));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void CB_CL_ElecAirDrvRiPos(VendorVehicleHalPAProto.Coordinates paramCoordinates) {
/*  734 */     this.mMgr.setbytesProperty(32829, 1, VendorVehicleHalPAProto.Coordinates.toByteArray((MessageNano)paramCoordinates));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void CB_CL_ElecAirPassLePos(VendorVehicleHalPAProto.Coordinates paramCoordinates) {
/*  742 */     this.mMgr.setbytesProperty(32830, 1, VendorVehicleHalPAProto.Coordinates.toByteArray((MessageNano)paramCoordinates));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void CB_CL_ElecAirPassRiPos(VendorVehicleHalPAProto.Coordinates paramCoordinates) {
/*  750 */     this.mMgr.setbytesProperty(32831, 1, VendorVehicleHalPAProto.Coordinates.toByteArray((MessageNano)paramCoordinates));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ElecAirDrvrLeRiSwng(int paramInt) {
/*  760 */     ApiResult apiResult = ApiResult.FAILED;
/*  761 */     if (OnOff1.isValid(paramInt)) {
/*  762 */       apiResult = this.mMgr.setIntProperty(32832, 1, paramInt);
/*      */     } else {
/*  764 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  766 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ElecAirDrvrUpOnSwng(int paramInt) {
/*  776 */     ApiResult apiResult = ApiResult.FAILED;
/*  777 */     if (OnOff1.isValid(paramInt)) {
/*  778 */       apiResult = this.mMgr.setIntProperty(32833, 1, paramInt);
/*      */     } else {
/*  780 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  782 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ElecAirPassLeRiSwng(int paramInt) {
/*  792 */     ApiResult apiResult = ApiResult.FAILED;
/*  793 */     if (OnOff1.isValid(paramInt)) {
/*  794 */       apiResult = this.mMgr.setIntProperty(32834, 1, paramInt);
/*      */     } else {
/*  796 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  798 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ElecAirPassUpOnSwng(int paramInt) {
/*  808 */     ApiResult apiResult = ApiResult.FAILED;
/*  809 */     if (OnOff1.isValid(paramInt)) {
/*  810 */       apiResult = this.mMgr.setIntProperty(32835, 1, paramInt);
/*      */     } else {
/*  812 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  814 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_WipReAutReq(int paramInt) {
/*  824 */     ApiResult apiResult = ApiResult.FAILED;
/*  825 */     if (OnOff1.isValid(paramInt)) {
/*  826 */       apiResult = this.mMgr.setIntProperty(32836, 1, paramInt);
/*      */     } else {
/*  828 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  830 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_WipFrntSrvMod(int paramInt) {
/*  840 */     ApiResult apiResult = ApiResult.FAILED;
/*  841 */     if (OnOff1.isValid(paramInt)) {
/*  842 */       apiResult = this.mMgr.setIntProperty(32837, 1, paramInt);
/*      */     } else {
/*  844 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  846 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_WipReSrvMod(int paramInt) {
/*  856 */     ApiResult apiResult = ApiResult.FAILED;
/*  857 */     if (OnOff1.isValid(paramInt)) {
/*  858 */       apiResult = this.mMgr.setIntProperty(32838, 1, paramInt);
/*      */     } else {
/*  860 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  862 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_ClmCloseWinPop(int paramInt) {
/*  872 */     ApiResult apiResult = ApiResult.FAILED;
/*  873 */     if (OnOff1.isValid(paramInt)) {
/*  874 */       apiResult = this.mMgr.setIntProperty(32839, 1, paramInt);
/*      */     } else {
/*  876 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  878 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_TWinRfClsdPopSw(int paramInt) {
/*  888 */     ApiResult apiResult = ApiResult.FAILED;
/*  889 */     if (OnOff1.isValid(paramInt)) {
/*  890 */       apiResult = this.mMgr.setIntProperty(32840, 1, paramInt);
/*      */     } else {
/*  892 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  894 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_SecLockClimaSw(int paramInt) {
/*  904 */     ApiResult apiResult = ApiResult.FAILED;
/*  905 */     if (OnOff1.isValid(paramInt)) {
/*  906 */       apiResult = this.mMgr.setIntProperty(32841, 1, paramInt);
/*      */     } else {
/*  908 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  910 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_SecAutoSw(int paramInt) {
/*  920 */     ApiResult apiResult = ApiResult.FAILED;
/*  921 */     if (OnOff1.isValid(paramInt)) {
/*  922 */       apiResult = this.mMgr.setIntProperty(32842, 1, paramInt);
/*      */     } else {
/*  924 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  926 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_GClean(int paramInt) {
/*  936 */     ApiResult apiResult = ApiResult.FAILED;
/*  937 */     if (OnOff1.isValid(paramInt)) {
/*  938 */       apiResult = this.mMgr.setIntProperty(32843, 1, paramInt);
/*      */     } else {
/*  940 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  942 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_InteCleanUnpleSmell(int paramInt) {
/*  953 */     ApiResult apiResult = ApiResult.FAILED;
/*  954 */     if (OnOff1.isValid(paramInt)) {
/*  955 */       apiResult = this.mMgr.setIntProperty(32844, 1, paramInt);
/*      */     } else {
/*  957 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  959 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CL_Reboot(int paramInt) {
/*  969 */     return this.mMgr.setIntProperty(32845, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_AC getPA_CL_AC() throws CarNotConnectedException {
/*  980 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33317, 1);
/*      */     
/*  982 */     PATypes.PA_CL_AC pA_CL_AC = null;
/*      */     try {
/*  984 */       PATypes.PA_CL_AC pA_CL_AC1 = new PATypes.PA_CL_AC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_AC = pA_CL_AC1;
/*  985 */     } catch (Exception exception) {}
/*      */     
/*  987 */     return pA_CL_AC;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_Auto getPA_CL_Auto() throws CarNotConnectedException {
/*  996 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33318, 1);
/*      */     
/*  998 */     PATypes.PA_CL_Auto pA_CL_Auto = null;
/*      */     try {
/* 1000 */       PATypes.PA_CL_Auto pA_CL_Auto1 = new PATypes.PA_CL_Auto(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_Auto = pA_CL_Auto1;
/* 1001 */     } catch (Exception exception) {}
/*      */     
/* 1003 */     return pA_CL_Auto;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_Recirc getPA_CL_Recirc() throws CarNotConnectedException {
/* 1012 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33319, 1);
/*      */     
/* 1014 */     PATypes.PA_CL_Recirc pA_CL_Recirc = null;
/*      */     try {
/* 1016 */       PATypes.PA_CL_Recirc pA_CL_Recirc1 = new PATypes.PA_CL_Recirc(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_Recirc = pA_CL_Recirc1;
/* 1017 */     } catch (Exception exception) {}
/*      */     
/* 1019 */     return pA_CL_Recirc;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ModeFrstLeft getPA_CL_ModeFrstLeft() throws CarNotConnectedException {
/* 1028 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33320, 1);
/*      */     
/* 1030 */     PATypes.PA_CL_ModeFrstLeft pA_CL_ModeFrstLeft = null;
/*      */     try {
/* 1032 */       PATypes.PA_CL_ModeFrstLeft pA_CL_ModeFrstLeft1 = new PATypes.PA_CL_ModeFrstLeft(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ModeFrstLeft = pA_CL_ModeFrstLeft1;
/* 1033 */     } catch (Exception exception) {}
/*      */     
/* 1035 */     return pA_CL_ModeFrstLeft;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ModeFrstRight getPA_CL_ModeFrstRight() throws CarNotConnectedException {
/* 1044 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33321, 1);
/*      */     
/* 1046 */     PATypes.PA_CL_ModeFrstRight pA_CL_ModeFrstRight = null;
/*      */     try {
/* 1048 */       PATypes.PA_CL_ModeFrstRight pA_CL_ModeFrstRight1 = new PATypes.PA_CL_ModeFrstRight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ModeFrstRight = pA_CL_ModeFrstRight1;
/* 1049 */     } catch (Exception exception) {}
/*      */     
/* 1051 */     return pA_CL_ModeFrstRight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ModeSec getPA_CL_ModeSec() throws CarNotConnectedException {
/* 1060 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33322, 1);
/*      */     
/* 1062 */     PATypes.PA_CL_ModeSec pA_CL_ModeSec = null;
/*      */     try {
/* 1064 */       PATypes.PA_CL_ModeSec pA_CL_ModeSec1 = new PATypes.PA_CL_ModeSec(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ModeSec = pA_CL_ModeSec1;
/* 1065 */     } catch (Exception exception) {}
/*      */     
/* 1067 */     return pA_CL_ModeSec;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_MaxAC getPA_CL_MaxAC() throws CarNotConnectedException {
/* 1076 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33323, 1);
/*      */     
/* 1078 */     PATypes.PA_CL_MaxAC pA_CL_MaxAC = null;
/*      */     try {
/* 1080 */       PATypes.PA_CL_MaxAC pA_CL_MaxAC1 = new PATypes.PA_CL_MaxAC(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_MaxAC = pA_CL_MaxAC1;
/* 1081 */     } catch (Exception exception) {}
/*      */     
/* 1083 */     return pA_CL_MaxAC;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_FanLevel getPA_CL_FanLevel() throws CarNotConnectedException {
/* 1092 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33324, 1);
/*      */     
/* 1094 */     PATypes.PA_CL_FanLevel pA_CL_FanLevel = null;
/*      */     try {
/* 1096 */       PATypes.PA_CL_FanLevel pA_CL_FanLevel1 = new PATypes.PA_CL_FanLevel(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_FanLevel = pA_CL_FanLevel1;
/* 1097 */     } catch (Exception exception) {}
/*      */     
/* 1099 */     return pA_CL_FanLevel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_LeftTemp getPA_CL_LeftTemp() throws CarNotConnectedException {
/* 1108 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33325, 1);
/*      */     
/* 1110 */     PATypes.PA_CL_LeftTemp pA_CL_LeftTemp = null;
/*      */     try {
/* 1112 */       PATypes.PA_CL_LeftTemp pA_CL_LeftTemp1 = new PATypes.PA_CL_LeftTemp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_LeftTemp = pA_CL_LeftTemp1;
/* 1113 */     } catch (Exception exception) {}
/*      */     
/* 1115 */     return pA_CL_LeftTemp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_RightTemp getPA_CL_RightTemp() throws CarNotConnectedException {
/* 1124 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33326, 1);
/*      */     
/* 1126 */     PATypes.PA_CL_RightTemp pA_CL_RightTemp = null;
/*      */     try {
/* 1128 */       PATypes.PA_CL_RightTemp pA_CL_RightTemp1 = new PATypes.PA_CL_RightTemp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_RightTemp = pA_CL_RightTemp1;
/* 1129 */     } catch (Exception exception) {}
/*      */     
/* 1131 */     return pA_CL_RightTemp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_RecircSetting getPA_CL_RecircSetting() throws CarNotConnectedException {
/* 1140 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33327, 1);
/*      */     
/* 1142 */     PATypes.PA_CL_RecircSetting pA_CL_RecircSetting = null;
/*      */     try {
/* 1144 */       PATypes.PA_CL_RecircSetting pA_CL_RecircSetting1 = new PATypes.PA_CL_RecircSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_RecircSetting = pA_CL_RecircSetting1;
/* 1145 */     } catch (Exception exception) {}
/*      */     
/* 1147 */     return pA_CL_RecircSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_AutoSetting getPA_CL_AutoSetting() throws CarNotConnectedException {
/* 1156 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33328, 1);
/*      */     
/* 1158 */     PATypes.PA_CL_AutoSetting pA_CL_AutoSetting = null;
/*      */     try {
/* 1160 */       PATypes.PA_CL_AutoSetting pA_CL_AutoSetting1 = new PATypes.PA_CL_AutoSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_AutoSetting = pA_CL_AutoSetting1;
/* 1161 */     } catch (Exception exception) {}
/*      */     
/* 1163 */     return pA_CL_AutoSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_MaxDefrost getPA_CL_MaxDefrost() throws CarNotConnectedException {
/* 1172 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33329, 1);
/*      */     
/* 1174 */     PATypes.PA_CL_MaxDefrost pA_CL_MaxDefrost = null;
/*      */     try {
/* 1176 */       PATypes.PA_CL_MaxDefrost pA_CL_MaxDefrost1 = new PATypes.PA_CL_MaxDefrost(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_MaxDefrost = pA_CL_MaxDefrost1;
/* 1177 */     } catch (Exception exception) {}
/*      */     
/* 1179 */     return pA_CL_MaxDefrost;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_WDC_AutoFrontDefrost getPA_WDC_AutoFrontDefrost() throws CarNotConnectedException {
/* 1188 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33330, 1);
/*      */     
/* 1190 */     PATypes.PA_WDC_AutoFrontDefrost pA_WDC_AutoFrontDefrost = null;
/*      */     try {
/* 1192 */       PATypes.PA_WDC_AutoFrontDefrost pA_WDC_AutoFrontDefrost1 = new PATypes.PA_WDC_AutoFrontDefrost(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WDC_AutoFrontDefrost = pA_WDC_AutoFrontDefrost1;
/* 1193 */     } catch (Exception exception) {}
/*      */     
/* 1195 */     return pA_WDC_AutoFrontDefrost;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_WDC_AutoRearDefrost getPA_WDC_AutoRearDefrost() throws CarNotConnectedException {
/* 1204 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33331, 1);
/*      */     
/* 1206 */     PATypes.PA_WDC_AutoRearDefrost pA_WDC_AutoRearDefrost = null;
/*      */     try {
/* 1208 */       PATypes.PA_WDC_AutoRearDefrost pA_WDC_AutoRearDefrost1 = new PATypes.PA_WDC_AutoRearDefrost(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WDC_AutoRearDefrost = pA_WDC_AutoRearDefrost1;
/* 1209 */     } catch (Exception exception) {}
/*      */     
/* 1211 */     return pA_WDC_AutoRearDefrost;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_FrontDefrost getPA_CL_FrontDefrost() throws CarNotConnectedException {
/* 1220 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33332, 1);
/*      */     
/* 1222 */     PATypes.PA_CL_FrontDefrost pA_CL_FrontDefrost = null;
/*      */     try {
/* 1224 */       PATypes.PA_CL_FrontDefrost pA_CL_FrontDefrost1 = new PATypes.PA_CL_FrontDefrost(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_FrontDefrost = pA_CL_FrontDefrost1;
/* 1225 */     } catch (Exception exception) {}
/*      */     
/* 1227 */     return pA_CL_FrontDefrost;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_RearDefrost getPA_CL_RearDefrost() throws CarNotConnectedException {
/* 1236 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33333, 1);
/*      */     
/* 1238 */     PATypes.PA_CL_RearDefrost pA_CL_RearDefrost = null;
/*      */     try {
/* 1240 */       PATypes.PA_CL_RearDefrost pA_CL_RearDefrost1 = new PATypes.PA_CL_RearDefrost(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_RearDefrost = pA_CL_RearDefrost1;
/* 1241 */     } catch (Exception exception) {}
/*      */     
/* 1243 */     return pA_CL_RearDefrost;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_Sync getPA_CL_Sync() throws CarNotConnectedException {
/* 1252 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33334, 1);
/*      */     
/* 1254 */     PATypes.PA_CL_Sync pA_CL_Sync = null;
/*      */     try {
/* 1256 */       PATypes.PA_CL_Sync pA_CL_Sync1 = new PATypes.PA_CL_Sync(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_Sync = pA_CL_Sync1;
/* 1257 */     } catch (Exception exception) {}
/*      */     
/* 1259 */     return pA_CL_Sync;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ECOClimate getPA_CL_ECOClimate() throws CarNotConnectedException {
/* 1268 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33335, 1);
/*      */     
/* 1270 */     PATypes.PA_CL_ECOClimate pA_CL_ECOClimate = null;
/*      */     try {
/* 1272 */       PATypes.PA_CL_ECOClimate pA_CL_ECOClimate1 = new PATypes.PA_CL_ECOClimate(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ECOClimate = pA_CL_ECOClimate1;
/* 1273 */     } catch (Exception exception) {}
/*      */     
/* 1275 */     return pA_CL_ECOClimate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_Pre getPA_CL_Pre() throws CarNotConnectedException {
/* 1284 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33336, 1);
/*      */     
/* 1286 */     PATypes.PA_CL_Pre pA_CL_Pre = null;
/*      */     try {
/* 1288 */       PATypes.PA_CL_Pre pA_CL_Pre1 = new PATypes.PA_CL_Pre(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_Pre = pA_CL_Pre1;
/* 1289 */     } catch (Exception exception) {}
/*      */     
/* 1291 */     return pA_CL_Pre;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_Post getPA_CL_Post() throws CarNotConnectedException {
/* 1300 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33337, 1);
/*      */     
/* 1302 */     PATypes.PA_CL_Post pA_CL_Post = null;
/*      */     try {
/* 1304 */       PATypes.PA_CL_Post pA_CL_Post1 = new PATypes.PA_CL_Post(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_Post = pA_CL_Post1;
/* 1305 */     } catch (Exception exception) {}
/*      */     
/* 1307 */     return pA_CL_Post;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_AirCtrlOff getPA_CL_AirCtrlOff() throws CarNotConnectedException {
/* 1316 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33338, 1);
/*      */     
/* 1318 */     PATypes.PA_CL_AirCtrlOff pA_CL_AirCtrlOff = null;
/*      */     try {
/* 1320 */       PATypes.PA_CL_AirCtrlOff pA_CL_AirCtrlOff1 = new PATypes.PA_CL_AirCtrlOff(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_AirCtrlOff = pA_CL_AirCtrlOff1;
/* 1321 */     } catch (Exception exception) {}
/*      */     
/* 1323 */     return pA_CL_AirCtrlOff;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_HvacReCtr getPA_CL_HvacReCtr() throws CarNotConnectedException {
/* 1332 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33339, 1);
/*      */     
/* 1334 */     PATypes.PA_CL_HvacReCtr pA_CL_HvacReCtr = null;
/*      */     try {
/* 1336 */       PATypes.PA_CL_HvacReCtr pA_CL_HvacReCtr1 = new PATypes.PA_CL_HvacReCtr(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_HvacReCtr = pA_CL_HvacReCtr1;
/* 1337 */     } catch (Exception exception) {}
/*      */     
/* 1339 */     return pA_CL_HvacReCtr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_SecLeftTemp getPA_CL_SecLeftTemp() throws CarNotConnectedException {
/* 1348 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33340, 1);
/*      */     
/* 1350 */     PATypes.PA_CL_SecLeftTemp pA_CL_SecLeftTemp = null;
/*      */     try {
/* 1352 */       PATypes.PA_CL_SecLeftTemp pA_CL_SecLeftTemp1 = new PATypes.PA_CL_SecLeftTemp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_SecLeftTemp = pA_CL_SecLeftTemp1;
/* 1353 */     } catch (Exception exception) {}
/*      */     
/* 1355 */     return pA_CL_SecLeftTemp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_SecRightTemp getPA_CL_SecRightTemp() throws CarNotConnectedException {
/* 1364 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33341, 1);
/*      */     
/* 1366 */     PATypes.PA_CL_SecRightTemp pA_CL_SecRightTemp = null;
/*      */     try {
/* 1368 */       PATypes.PA_CL_SecRightTemp pA_CL_SecRightTemp1 = new PATypes.PA_CL_SecRightTemp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_SecRightTemp = pA_CL_SecRightTemp1;
/* 1369 */     } catch (Exception exception) {}
/*      */     
/* 1371 */     return pA_CL_SecRightTemp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_SecFanLevel getPA_CL_SecFanLevel() throws CarNotConnectedException {
/* 1380 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33342, 1);
/*      */     
/* 1382 */     PATypes.PA_CL_SecFanLevel pA_CL_SecFanLevel = null;
/*      */     try {
/* 1384 */       PATypes.PA_CL_SecFanLevel pA_CL_SecFanLevel1 = new PATypes.PA_CL_SecFanLevel(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_SecFanLevel = pA_CL_SecFanLevel1;
/* 1385 */     } catch (Exception exception) {}
/*      */     
/* 1387 */     return pA_CL_SecFanLevel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_AutoDefrostSetting getPA_CL_AutoDefrostSetting() throws CarNotConnectedException {
/* 1396 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33343, 1);
/*      */     
/* 1398 */     PATypes.PA_CL_AutoDefrostSetting pA_CL_AutoDefrostSetting = null;
/*      */     try {
/* 1400 */       PATypes.PA_CL_AutoDefrostSetting pA_CL_AutoDefrostSetting1 = new PATypes.PA_CL_AutoDefrostSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_AutoDefrostSetting = pA_CL_AutoDefrostSetting1;
/* 1401 */     } catch (Exception exception) {}
/*      */     
/* 1403 */     return pA_CL_AutoDefrostSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_AutoDefrostPopup getPA_CL_AutoDefrostPopup() throws CarNotConnectedException {
/* 1412 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33344, 1);
/*      */     
/* 1414 */     PATypes.PA_CL_AutoDefrostPopup pA_CL_AutoDefrostPopup = null;
/*      */     try {
/* 1416 */       PATypes.PA_CL_AutoDefrostPopup pA_CL_AutoDefrostPopup1 = new PATypes.PA_CL_AutoDefrostPopup(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_AutoDefrostPopup = pA_CL_AutoDefrostPopup1;
/* 1417 */     } catch (Exception exception) {}
/*      */     
/* 1419 */     return pA_CL_AutoDefrostPopup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_FrntDefrostPopup getPA_CL_FrntDefrostPopup() throws CarNotConnectedException {
/* 1428 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33345, 1);
/*      */     
/* 1430 */     PATypes.PA_CL_FrntDefrostPopup pA_CL_FrntDefrostPopup = null;
/*      */     try {
/* 1432 */       PATypes.PA_CL_FrntDefrostPopup pA_CL_FrntDefrostPopup1 = new PATypes.PA_CL_FrntDefrostPopup(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_FrntDefrostPopup = pA_CL_FrntDefrostPopup1;
/* 1433 */     } catch (Exception exception) {}
/*      */     
/* 1435 */     return pA_CL_FrntDefrostPopup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_RearDefrostPopup getPA_CL_RearDefrostPopup() throws CarNotConnectedException {
/* 1444 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33346, 1);
/*      */     
/* 1446 */     PATypes.PA_CL_RearDefrostPopup pA_CL_RearDefrostPopup = null;
/*      */     try {
/* 1448 */       PATypes.PA_CL_RearDefrostPopup pA_CL_RearDefrostPopup1 = new PATypes.PA_CL_RearDefrostPopup(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_RearDefrostPopup = pA_CL_RearDefrostPopup1;
/* 1449 */     } catch (Exception exception) {}
/*      */     
/* 1451 */     return pA_CL_RearDefrostPopup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_SecRowOnOffSwith getPA_CL_SecRowOnOffSwith() throws CarNotConnectedException {
/* 1460 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33347, 1);
/*      */     
/* 1462 */     PATypes.PA_CL_SecRowOnOffSwith pA_CL_SecRowOnOffSwith = null;
/*      */     try {
/* 1464 */       PATypes.PA_CL_SecRowOnOffSwith pA_CL_SecRowOnOffSwith1 = new PATypes.PA_CL_SecRowOnOffSwith(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_SecRowOnOffSwith = pA_CL_SecRowOnOffSwith1;
/* 1465 */     } catch (Exception exception) {}
/*      */     
/* 1467 */     return pA_CL_SecRowOnOffSwith;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_PostClimaWarn getPA_CL_PostClimaWarn() throws CarNotConnectedException {
/* 1476 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33348, 1);
/*      */     
/* 1478 */     PATypes.PA_CL_PostClimaWarn pA_CL_PostClimaWarn = null;
/*      */     try {
/* 1480 */       PATypes.PA_CL_PostClimaWarn pA_CL_PostClimaWarn1 = new PATypes.PA_CL_PostClimaWarn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_PostClimaWarn = pA_CL_PostClimaWarn1;
/* 1481 */     } catch (Exception exception) {}
/*      */     
/* 1483 */     return pA_CL_PostClimaWarn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_HumCtrl getPA_CL_HumCtrl() throws CarNotConnectedException {
/* 1492 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33349, 1);
/*      */     
/* 1494 */     PATypes.PA_CL_HumCtrl pA_CL_HumCtrl = null;
/*      */     try {
/* 1496 */       PATypes.PA_CL_HumCtrl pA_CL_HumCtrl1 = new PATypes.PA_CL_HumCtrl(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_HumCtrl = pA_CL_HumCtrl1;
/* 1497 */     } catch (Exception exception) {}
/*      */     
/* 1499 */     return pA_CL_HumCtrl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_HumPop getPA_CL_HumPop() throws CarNotConnectedException {
/* 1508 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33350, 1);
/*      */     
/* 1510 */     PATypes.PA_CL_HumPop pA_CL_HumPop = null;
/*      */     try {
/* 1512 */       PATypes.PA_CL_HumPop pA_CL_HumPop1 = new PATypes.PA_CL_HumPop(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_HumPop = pA_CL_HumPop1;
/* 1513 */     } catch (Exception exception) {}
/*      */     
/* 1515 */     return pA_CL_HumPop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_IntelliClimaPop getPA_CL_IntelliClimaPop() throws CarNotConnectedException {
/* 1524 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33351, 1);
/*      */     
/* 1526 */     PATypes.PA_CL_IntelliClimaPop pA_CL_IntelliClimaPop = null;
/*      */     try {
/* 1528 */       PATypes.PA_CL_IntelliClimaPop pA_CL_IntelliClimaPop1 = new PATypes.PA_CL_IntelliClimaPop(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_IntelliClimaPop = pA_CL_IntelliClimaPop1;
/* 1529 */     } catch (Exception exception) {}
/*      */     
/* 1531 */     return pA_CL_IntelliClimaPop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_WipReAutReq getPA_CL_WipReAutReq() throws CarNotConnectedException {
/* 1540 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33352, 1);
/*      */     
/* 1542 */     PATypes.PA_CL_WipReAutReq pA_CL_WipReAutReq = null;
/*      */     try {
/* 1544 */       PATypes.PA_CL_WipReAutReq pA_CL_WipReAutReq1 = new PATypes.PA_CL_WipReAutReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_WipReAutReq = pA_CL_WipReAutReq1;
/* 1545 */     } catch (Exception exception) {}
/*      */     
/* 1547 */     return pA_CL_WipReAutReq;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_WipFrntSrvMod getPA_CL_WipFrntSrvMod() throws CarNotConnectedException {
/* 1556 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33353, 1);
/*      */     
/* 1558 */     PATypes.PA_CL_WipFrntSrvMod pA_CL_WipFrntSrvMod = null;
/*      */     try {
/* 1560 */       PATypes.PA_CL_WipFrntSrvMod pA_CL_WipFrntSrvMod1 = new PATypes.PA_CL_WipFrntSrvMod(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_WipFrntSrvMod = pA_CL_WipFrntSrvMod1;
/* 1561 */     } catch (Exception exception) {}
/*      */     
/* 1563 */     return pA_CL_WipFrntSrvMod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_WipReSrvMod getPA_CL_WipReSrvMod() throws CarNotConnectedException {
/* 1572 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33354, 1);
/*      */     
/* 1574 */     PATypes.PA_CL_WipReSrvMod pA_CL_WipReSrvMod = null;
/*      */     try {
/* 1576 */       PATypes.PA_CL_WipReSrvMod pA_CL_WipReSrvMod1 = new PATypes.PA_CL_WipReSrvMod(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_WipReSrvMod = pA_CL_WipReSrvMod1;
/* 1577 */     } catch (Exception exception) {}
/*      */     
/* 1579 */     return pA_CL_WipReSrvMod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ClmCloseWinPop getPA_CL_ClmCloseWinPop() throws CarNotConnectedException {
/* 1588 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33355, 1);
/*      */     
/* 1590 */     PATypes.PA_CL_ClmCloseWinPop pA_CL_ClmCloseWinPop = null;
/*      */     try {
/* 1592 */       PATypes.PA_CL_ClmCloseWinPop pA_CL_ClmCloseWinPop1 = new PATypes.PA_CL_ClmCloseWinPop(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ClmCloseWinPop = pA_CL_ClmCloseWinPop1;
/* 1593 */     } catch (Exception exception) {}
/*      */     
/* 1595 */     return pA_CL_ClmCloseWinPop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_DrvSwt getPA_CL_DrvSwt() throws CarNotConnectedException {
/* 1604 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33356, 1);
/*      */     
/* 1606 */     PATypes.PA_CL_DrvSwt pA_CL_DrvSwt = null;
/*      */     try {
/* 1608 */       PATypes.PA_CL_DrvSwt pA_CL_DrvSwt1 = new PATypes.PA_CL_DrvSwt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_DrvSwt = pA_CL_DrvSwt1;
/* 1609 */     } catch (Exception exception) {}
/*      */     
/* 1611 */     return pA_CL_DrvSwt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_PassSwt getPA_CL_PassSwt() throws CarNotConnectedException {
/* 1620 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33357, 1);
/*      */     
/* 1622 */     PATypes.PA_CL_PassSwt pA_CL_PassSwt = null;
/*      */     try {
/* 1624 */       PATypes.PA_CL_PassSwt pA_CL_PassSwt1 = new PATypes.PA_CL_PassSwt(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_PassSwt = pA_CL_PassSwt1;
/* 1625 */     } catch (Exception exception) {}
/*      */     
/* 1627 */     return pA_CL_PassSwt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ElecAirAvlStsPop getPA_CL_ElecAirAvlStsPop() throws CarNotConnectedException {
/* 1636 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33358, 1);
/*      */     
/* 1638 */     PATypes.PA_CL_ElecAirAvlStsPop pA_CL_ElecAirAvlStsPop = null;
/*      */     try {
/* 1640 */       PATypes.PA_CL_ElecAirAvlStsPop pA_CL_ElecAirAvlStsPop1 = new PATypes.PA_CL_ElecAirAvlStsPop(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ElecAirAvlStsPop = pA_CL_ElecAirAvlStsPop1;
/* 1641 */     } catch (Exception exception) {}
/*      */     
/* 1643 */     return pA_CL_ElecAirAvlStsPop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_TWinRfClsdPopSw getPA_CL_TWinRfClsdPopSw() throws CarNotConnectedException {
/* 1652 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33359, 1);
/*      */     
/* 1654 */     PATypes.PA_CL_TWinRfClsdPopSw pA_CL_TWinRfClsdPopSw = null;
/*      */     try {
/* 1656 */       PATypes.PA_CL_TWinRfClsdPopSw pA_CL_TWinRfClsdPopSw1 = new PATypes.PA_CL_TWinRfClsdPopSw(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_TWinRfClsdPopSw = pA_CL_TWinRfClsdPopSw1;
/* 1657 */     } catch (Exception exception) {}
/*      */     
/* 1659 */     return pA_CL_TWinRfClsdPopSw;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_SecLockClimaSw getPA_CL_SecLockClimaSw() throws CarNotConnectedException {
/* 1668 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33360, 1);
/*      */     
/* 1670 */     PATypes.PA_CL_SecLockClimaSw pA_CL_SecLockClimaSw = null;
/*      */     try {
/* 1672 */       PATypes.PA_CL_SecLockClimaSw pA_CL_SecLockClimaSw1 = new PATypes.PA_CL_SecLockClimaSw(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_SecLockClimaSw = pA_CL_SecLockClimaSw1;
/* 1673 */     } catch (Exception exception) {}
/*      */     
/* 1675 */     return pA_CL_SecLockClimaSw;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_SecAutoSw getPA_CL_SecAutoSw() throws CarNotConnectedException {
/* 1684 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33361, 1);
/*      */     
/* 1686 */     PATypes.PA_CL_SecAutoSw pA_CL_SecAutoSw = null;
/*      */     try {
/* 1688 */       PATypes.PA_CL_SecAutoSw pA_CL_SecAutoSw1 = new PATypes.PA_CL_SecAutoSw(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_SecAutoSw = pA_CL_SecAutoSw1;
/* 1689 */     } catch (Exception exception) {}
/*      */     
/* 1691 */     return pA_CL_SecAutoSw;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_GClean getPA_CL_GClean() throws CarNotConnectedException {
/* 1700 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33362, 1);
/*      */     
/* 1702 */     PATypes.PA_CL_GClean pA_CL_GClean = null;
/*      */     try {
/* 1704 */       PATypes.PA_CL_GClean pA_CL_GClean1 = new PATypes.PA_CL_GClean(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_GClean = pA_CL_GClean1;
/* 1705 */     } catch (Exception exception) {}
/*      */     
/* 1707 */     return pA_CL_GClean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_DrvElecAir getPA_CL_DrvElecAir() throws CarNotConnectedException {
/* 1716 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33363, 1);
/*      */     
/* 1718 */     PATypes.PA_CL_DrvElecAir pA_CL_DrvElecAir = null;
/*      */     try {
/* 1720 */       PATypes.PA_CL_DrvElecAir pA_CL_DrvElecAir1 = new PATypes.PA_CL_DrvElecAir(); this(VendorVehicleHalPAProto.Elecairalldata.parseFrom(arrayOfByte)); pA_CL_DrvElecAir = pA_CL_DrvElecAir1;
/* 1721 */     } catch (Exception exception) {}
/*      */     
/* 1723 */     return pA_CL_DrvElecAir;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_PassElecAir getPA_CL_PassElecAir() throws CarNotConnectedException {
/* 1732 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33364, 1);
/*      */     
/* 1734 */     PATypes.PA_CL_PassElecAir pA_CL_PassElecAir = null;
/*      */     try {
/* 1736 */       PATypes.PA_CL_PassElecAir pA_CL_PassElecAir1 = new PATypes.PA_CL_PassElecAir(); this(VendorVehicleHalPAProto.Elecairalldata.parseFrom(arrayOfByte)); pA_CL_PassElecAir = pA_CL_PassElecAir1;
/* 1737 */     } catch (Exception exception) {}
/*      */     
/* 1739 */     return pA_CL_PassElecAir;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_CCSMPopUp getPA_CL_CCSMPopUp() throws CarNotConnectedException {
/* 1748 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33365, 1);
/*      */     
/* 1750 */     PATypes.PA_CL_CCSMPopUp pA_CL_CCSMPopUp = null;
/*      */     try {
/* 1752 */       PATypes.PA_CL_CCSMPopUp pA_CL_CCSMPopUp1 = new PATypes.PA_CL_CCSMPopUp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_CCSMPopUp = pA_CL_CCSMPopUp1;
/* 1753 */     } catch (Exception exception) {}
/*      */     
/* 1755 */     return pA_CL_CCSMPopUp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ElecDefRunErr getPA_CL_ElecDefRunErr() throws CarNotConnectedException {
/* 1764 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33366, 1);
/*      */     
/* 1766 */     PATypes.PA_CL_ElecDefRunErr pA_CL_ElecDefRunErr = null;
/*      */     try {
/* 1768 */       PATypes.PA_CL_ElecDefRunErr pA_CL_ElecDefRunErr1 = new PATypes.PA_CL_ElecDefRunErr(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ElecDefRunErr = pA_CL_ElecDefRunErr1;
/* 1769 */     } catch (Exception exception) {}
/*      */     
/* 1771 */     return pA_CL_ElecDefRunErr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_InteCleanUnpleSmell getPA_CL_InteCleanUnpleSmell() throws CarNotConnectedException {
/* 1780 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33367, 1);
/*      */     
/* 1782 */     PATypes.PA_CL_InteCleanUnpleSmell pA_CL_InteCleanUnpleSmell = null;
/*      */     try {
/* 1784 */       PATypes.PA_CL_InteCleanUnpleSmell pA_CL_InteCleanUnpleSmell1 = new PATypes.PA_CL_InteCleanUnpleSmell(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_InteCleanUnpleSmell = pA_CL_InteCleanUnpleSmell1;
/* 1785 */     } catch (Exception exception) {}
/*      */     
/* 1787 */     return pA_CL_InteCleanUnpleSmell;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_FanLevel_ByHardKey getPA_CL_FanLevel_ByHardKey() throws CarNotConnectedException {
/* 1796 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33368, 1);
/*      */     
/* 1798 */     PATypes.PA_CL_FanLevel_ByHardKey pA_CL_FanLevel_ByHardKey = null;
/*      */     try {
/* 1800 */       PATypes.PA_CL_FanLevel_ByHardKey pA_CL_FanLevel_ByHardKey1 = new PATypes.PA_CL_FanLevel_ByHardKey(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_FanLevel_ByHardKey = pA_CL_FanLevel_ByHardKey1;
/* 1801 */     } catch (Exception exception) {}
/*      */     
/* 1803 */     return pA_CL_FanLevel_ByHardKey;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_LeftTemp_ByHardKey getPA_CL_LeftTemp_ByHardKey() throws CarNotConnectedException {
/* 1812 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33369, 1);
/*      */     
/* 1814 */     PATypes.PA_CL_LeftTemp_ByHardKey pA_CL_LeftTemp_ByHardKey = null;
/*      */     try {
/* 1816 */       PATypes.PA_CL_LeftTemp_ByHardKey pA_CL_LeftTemp_ByHardKey1 = new PATypes.PA_CL_LeftTemp_ByHardKey(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_LeftTemp_ByHardKey = pA_CL_LeftTemp_ByHardKey1;
/* 1817 */     } catch (Exception exception) {}
/*      */     
/* 1819 */     return pA_CL_LeftTemp_ByHardKey;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_ModeFrstLeft_ByHardKey getPA_CL_ModeFrstLeft_ByHardKey() throws CarNotConnectedException {
/* 1828 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33370, 1);
/*      */     
/* 1830 */     PATypes.PA_CL_ModeFrstLeft_ByHardKey pA_CL_ModeFrstLeft_ByHardKey = null;
/*      */     try {
/* 1832 */       PATypes.PA_CL_ModeFrstLeft_ByHardKey pA_CL_ModeFrstLeft_ByHardKey1 = new PATypes.PA_CL_ModeFrstLeft_ByHardKey(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_ModeFrstLeft_ByHardKey = pA_CL_ModeFrstLeft_ByHardKey1;
/* 1833 */     } catch (Exception exception) {}
/*      */     
/* 1835 */     return pA_CL_ModeFrstLeft_ByHardKey;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CL_MsgEnd getPA_CL_MsgEnd() throws CarNotConnectedException {
/* 1844 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33907, 1);
/*      */     
/* 1846 */     PATypes.PA_CL_MsgEnd pA_CL_MsgEnd = null;
/*      */     try {
/* 1848 */       PATypes.PA_CL_MsgEnd pA_CL_MsgEnd1 = new PATypes.PA_CL_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CL_MsgEnd = pA_CL_MsgEnd1;
/* 1849 */     } catch (Exception exception) {}
/*      */     
/* 1851 */     return pA_CL_MsgEnd;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarClimateManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */