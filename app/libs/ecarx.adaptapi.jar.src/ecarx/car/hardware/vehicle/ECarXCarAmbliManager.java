/*      */ package ecarx.car.hardware.vehicle;
/*      */ 
/*      */ import android.car.CarNotConnectedException;
/*      */ import ecarx.car.hardware.annotation.AmbLiMod;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.annotation.IntrLiInten;
/*      */ import ecarx.car.hardware.annotation.MoodLiColorAdjReq;
/*      */ import ecarx.car.hardware.annotation.OnOff1;
/*      */ import ecarx.car.hardware.annotation.OnOffNoReq;
/*      */ import ecarx.car.hardware.annotation.VFMiscCustomEffect;
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
/*      */ public class ECarXCarAmbliManager
/*      */   extends ECarXCarFuncManagerBase
/*      */ {
/*      */   private static final boolean DBG = false;
/*      */   public static final int ManagerId_cbambliall = 33207;
/*      */   public static final int ManagerId_cbamblimilgopenreq = 33226;
/*      */   public static final int ManagerId_cbamblimodsetting = 33208;
/*      */   public static final int ManagerId_cbambliphoneopenreq = 33227;
/*      */   public static final int ManagerId_cbambliradarcorrlnreq = 33242;
/*      */   public static final int ManagerId_cbamblireboot = 33241;
/*      */   public static final int ManagerId_cbcourtesylight = 33235;
/*      */   public static final int ManagerId_cbcustomeffect = 33209;
/*      */   public static final int ManagerId_cbcustomeffectbreath = 33239;
/*      */   public static final int ManagerId_cbgoodbyelight = 33237;
/*      */   public static final int ManagerId_cbmoodlicoloradjreq = 33240;
/*      */   public static final int ManagerId_cbmoodlightswitch = 33225;
/*      */   public static final int ManagerId_cbreadlightallonswitch = 33238;
/*      */   public static final int ManagerId_cbreadlightfrontleft = 33228;
/*      */   public static final int ManagerId_cbreadlightfrontright = 33229;
/*      */   public static final int ManagerId_cbreadlightsecondrowleft = 33230;
/*      */   public static final int ManagerId_cbreadlightsecondrowright = 33231;
/*      */   public static final int ManagerId_cbreadlightthirdrowleft = 33232;
/*      */   public static final int ManagerId_cbreadlightthirdrowright = 33233;
/*      */   public static final int ManagerId_cbtransitioncolor1settings = 33211;
/*      */   public static final int ManagerId_cbtransitioncolor2settings = 33212;
/*      */   public static final int ManagerId_cbtransitioneffectsel = 33210;
/*      */   public static final int ManagerId_cbweatherinfoconservice = 33234;
/*      */   public static final int ManagerId_cbwelcomelight = 33236;
/*      */   public static final int ManagerId_cbzone1colorsettings = 33218;
/*      */   public static final int ManagerId_cbzone1intensitysettings = 33217;
/*      */   public static final int ManagerId_cbzone1statussettings = 33216;
/*      */   public static final int ManagerId_cbzone2colorsettings = 33221;
/*      */   public static final int ManagerId_cbzone2intensitysettings = 33220;
/*      */   public static final int ManagerId_cbzone2statussettings = 33219;
/*      */   public static final int ManagerId_cbzone3colorsettings = 33224;
/*      */   public static final int ManagerId_cbzone3intensitysettings = 33223;
/*      */   public static final int ManagerId_cbzone3statussettings = 33222;
/*      */   public static final int ManagerId_cbzoneallcolorsettings = 33215;
/*      */   public static final int ManagerId_cbzoneallintensitysettings = 33214;
/*      */   public static final int ManagerId_cbzoneallstatussettings = 33213;
/*      */   public static final int ManagerId_paambliall = 33815;
/*      */   public static final int ManagerId_paamblimilgopenreq = 33839;
/*      */   public static final int ManagerId_paamblimodcustomizedmode = 33818;
/*      */   public static final int ManagerId_paamblimoddrivemode = 33819;
/*      */   public static final int ManagerId_paamblimodmusicshowmode = 33820;
/*      */   public static final int ManagerId_paamblimodnone = 33817;
/*      */   public static final int ManagerId_paamblimodsetting = 33816;
/*      */   public static final int ManagerId_paamblimodweatherindn = 33821;
/*      */   public static final int ManagerId_paamblimsgend = 33925;
/*      */   public static final int ManagerId_paambliphoneopenreq = 33840;
/*      */   public static final int ManagerId_paambliradarcorrlnreq = 33854;
/*      */   public static final int ManagerId_pacourtesylight = 33848;
/*      */   public static final int ManagerId_pacustomeffect = 33822;
/*      */   public static final int ManagerId_pacustomeffectbreath = 33852;
/*      */   public static final int ManagerId_pagoodbyelight = 33850;
/*      */   public static final int ManagerId_pamoodlicoloradjreq = 33853;
/*      */   public static final int ManagerId_pamoodlightswitch = 33838;
/*      */   public static final int ManagerId_pareadlightallonswitch = 33851;
/*      */   public static final int ManagerId_pareadlightfrontleft = 33841;
/*      */   public static final int ManagerId_pareadlightfrontright = 33842;
/*      */   public static final int ManagerId_pareadlightsecondrowleft = 33843;
/*      */   public static final int ManagerId_pareadlightsecondrowright = 33844;
/*      */   public static final int ManagerId_pareadlightthirdrowleft = 33845;
/*      */   public static final int ManagerId_pareadlightthirdrowright = 33846;
/*      */   public static final int ManagerId_patransitioncolor1settings = 33824;
/*      */   public static final int ManagerId_patransitioncolor2settings = 33825;
/*      */   public static final int ManagerId_patransitioneffectsel = 33823;
/*      */   public static final int ManagerId_paweatherinfoconservice = 33847;
/*      */   public static final int ManagerId_pawelcomelight = 33849;
/*      */   public static final int ManagerId_pazone1colorsettings = 33831;
/*      */   public static final int ManagerId_pazone1intensitysettings = 33830;
/*      */   public static final int ManagerId_pazone1statussettings = 33829;
/*      */   public static final int ManagerId_pazone2colorsettings = 33834;
/*      */   public static final int ManagerId_pazone2intensitysettings = 33833;
/*      */   public static final int ManagerId_pazone2statussettings = 33832;
/*      */   public static final int ManagerId_pazone3colorsettings = 33837;
/*      */   public static final int ManagerId_pazone3intensitysettings = 33836;
/*      */   public static final int ManagerId_pazone3statussettings = 33835;
/*      */   public static final int ManagerId_pazoneallcolorsettings = 33828;
/*      */   public static final int ManagerId_pazoneallintensitysettings = 33827;
/*      */   public static final int ManagerId_pazoneallstatussettings = 33826;
/*      */   private static final String TAG = "ECarXCarAmbliManager";
/*      */   public static final int VehicleArea_Global = 1;
/*      */   public static final int VehicleArea_Zone = 2;
/*      */   
/*      */   public ECarXCarAmbliManager() {}
/*      */   
/*      */   public ECarXCarAmbliManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  133 */     super(paramECarXCarPropertyManagerBase);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AmbLiAll(int paramInt) {
/*  143 */     ApiResult apiResult = ApiResult.FAILED;
/*  144 */     if (OnOff1.isValid(paramInt)) {
/*  145 */       apiResult = this.mMgr.setIntProperty(33207, 1, paramInt);
/*      */     } else {
/*  147 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  149 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AmbLiModSetting(int paramInt) {
/*  159 */     ApiResult apiResult = ApiResult.FAILED;
/*  160 */     if (AmbLiMod.isValid(paramInt)) {
/*  161 */       apiResult = this.mMgr.setIntProperty(33208, 1, paramInt);
/*      */     } else {
/*  163 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  165 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CustomEffect(int paramInt) {
/*  175 */     ApiResult apiResult = ApiResult.FAILED;
/*  176 */     if (VFMiscCustomEffect.isValid(paramInt)) {
/*  177 */       apiResult = this.mMgr.setIntProperty(33209, 1, paramInt);
/*      */     } else {
/*  179 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  181 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TransitionEffectSel(int paramInt) {
/*  191 */     ApiResult apiResult = ApiResult.FAILED;
/*  192 */     if (IntrLiInten.isValid(paramInt)) {
/*  193 */       apiResult = this.mMgr.setIntProperty(33210, 1, paramInt);
/*      */     } else {
/*  195 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  197 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TransitionColor1Settings(int paramInt) {
/*  207 */     return this.mMgr.setIntProperty(33211, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_TransitionColor2Settings(int paramInt) {
/*  217 */     return this.mMgr.setIntProperty(33212, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ZoneAllStatusSettings(int paramInt) {
/*  227 */     ApiResult apiResult = ApiResult.FAILED;
/*  228 */     if (OnOff1.isValid(paramInt)) {
/*  229 */       apiResult = this.mMgr.setIntProperty(33213, 1, paramInt);
/*      */     } else {
/*  231 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  233 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ZoneAllIntensitySettings(int paramInt) {
/*  243 */     return this.mMgr.setIntProperty(33214, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ZoneAllColorSettings(int paramInt) {
/*  253 */     return this.mMgr.setIntProperty(33215, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone1StatusSettings(int paramInt) {
/*  263 */     ApiResult apiResult = ApiResult.FAILED;
/*  264 */     if (OnOff1.isValid(paramInt)) {
/*  265 */       apiResult = this.mMgr.setIntProperty(33216, 1, paramInt);
/*      */     } else {
/*  267 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  269 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone1IntensitySettings(int paramInt) {
/*  279 */     return this.mMgr.setIntProperty(33217, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone1ColorSettings(int paramInt) {
/*  289 */     return this.mMgr.setIntProperty(33218, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone2StatusSettings(int paramInt) {
/*  299 */     ApiResult apiResult = ApiResult.FAILED;
/*  300 */     if (OnOff1.isValid(paramInt)) {
/*  301 */       apiResult = this.mMgr.setIntProperty(33219, 1, paramInt);
/*      */     } else {
/*  303 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  305 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone2IntensitySettings(int paramInt) {
/*  315 */     return this.mMgr.setIntProperty(33220, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone2ColorSettings(int paramInt) {
/*  325 */     return this.mMgr.setIntProperty(33221, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone3StatusSettings(int paramInt) {
/*  335 */     ApiResult apiResult = ApiResult.FAILED;
/*  336 */     if (OnOff1.isValid(paramInt)) {
/*  337 */       apiResult = this.mMgr.setIntProperty(33222, 1, paramInt);
/*      */     } else {
/*  339 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  341 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone3IntensitySettings(int paramInt) {
/*  351 */     return this.mMgr.setIntProperty(33223, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_Zone3ColorSettings(int paramInt) {
/*  361 */     return this.mMgr.setIntProperty(33224, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MoodLightSwitch(int paramInt) {
/*  371 */     ApiResult apiResult = ApiResult.FAILED;
/*  372 */     if (OnOff1.isValid(paramInt)) {
/*  373 */       apiResult = this.mMgr.setIntProperty(33225, 1, paramInt);
/*      */     } else {
/*  375 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  377 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AmbLiMilgOpenReq(int paramInt) {
/*  387 */     ApiResult apiResult = ApiResult.FAILED;
/*  388 */     if (OnOff1.isValid(paramInt)) {
/*  389 */       apiResult = this.mMgr.setIntProperty(33226, 1, paramInt);
/*      */     } else {
/*  391 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  393 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AmbLiPhoneOpenReq(int paramInt) {
/*  403 */     ApiResult apiResult = ApiResult.FAILED;
/*  404 */     if (OnOff1.isValid(paramInt)) {
/*  405 */       apiResult = this.mMgr.setIntProperty(33227, 1, paramInt);
/*      */     } else {
/*  407 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  409 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ReadLightFrontLeft(int paramInt) {
/*  419 */     ApiResult apiResult = ApiResult.FAILED;
/*  420 */     if (OnOffNoReq.isValid(paramInt)) {
/*  421 */       apiResult = this.mMgr.setIntProperty(33228, 1, paramInt);
/*      */     } else {
/*  423 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  425 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ReadLightFrontRight(int paramInt) {
/*  435 */     ApiResult apiResult = ApiResult.FAILED;
/*  436 */     if (OnOffNoReq.isValid(paramInt)) {
/*  437 */       apiResult = this.mMgr.setIntProperty(33229, 1, paramInt);
/*      */     } else {
/*  439 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  441 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ReadLightSecondRowLeft(int paramInt) {
/*  451 */     ApiResult apiResult = ApiResult.FAILED;
/*  452 */     if (OnOffNoReq.isValid(paramInt)) {
/*  453 */       apiResult = this.mMgr.setIntProperty(33230, 1, paramInt);
/*      */     } else {
/*  455 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  457 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ReadLightSecondRowRight(int paramInt) {
/*  467 */     ApiResult apiResult = ApiResult.FAILED;
/*  468 */     if (OnOffNoReq.isValid(paramInt)) {
/*  469 */       apiResult = this.mMgr.setIntProperty(33231, 1, paramInt);
/*      */     } else {
/*  471 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  473 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ReadLightThirdRowLeft(int paramInt) {
/*  483 */     ApiResult apiResult = ApiResult.FAILED;
/*  484 */     if (OnOffNoReq.isValid(paramInt)) {
/*  485 */       apiResult = this.mMgr.setIntProperty(33232, 1, paramInt);
/*      */     } else {
/*  487 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  489 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ReadLightThirdRowRight(int paramInt) {
/*  499 */     ApiResult apiResult = ApiResult.FAILED;
/*  500 */     if (OnOffNoReq.isValid(paramInt)) {
/*  501 */       apiResult = this.mMgr.setIntProperty(33233, 1, paramInt);
/*      */     } else {
/*  503 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  505 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_WeatherInfoConService(int paramInt) {
/*  515 */     return this.mMgr.setIntProperty(33234, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CourtesyLight(int paramInt) {
/*  525 */     ApiResult apiResult = ApiResult.FAILED;
/*  526 */     if (OnOff1.isValid(paramInt)) {
/*  527 */       apiResult = this.mMgr.setIntProperty(33235, 1, paramInt);
/*      */     } else {
/*  529 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  531 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_WelcomeLight(int paramInt) {
/*  541 */     ApiResult apiResult = ApiResult.FAILED;
/*  542 */     if (OnOff1.isValid(paramInt)) {
/*  543 */       apiResult = this.mMgr.setIntProperty(33236, 1, paramInt);
/*      */     } else {
/*  545 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  547 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_GoodbyeLight(int paramInt) {
/*  557 */     ApiResult apiResult = ApiResult.FAILED;
/*  558 */     if (OnOff1.isValid(paramInt)) {
/*  559 */       apiResult = this.mMgr.setIntProperty(33237, 1, paramInt);
/*      */     } else {
/*  561 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  563 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_ReadLightAllOnSwitch(int paramInt) {
/*  573 */     ApiResult apiResult = ApiResult.FAILED;
/*  574 */     if (OnOff1.isValid(paramInt)) {
/*  575 */       apiResult = this.mMgr.setIntProperty(33238, 1, paramInt);
/*      */     } else {
/*  577 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  579 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_CustomEffectBreath(int paramInt) {
/*  589 */     ApiResult apiResult = ApiResult.FAILED;
/*  590 */     if (OnOff1.isValid(paramInt)) {
/*  591 */       apiResult = this.mMgr.setIntProperty(33239, 1, paramInt);
/*      */     } else {
/*  593 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  595 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_MoodLiColorAdjReq(int paramInt) {
/*  605 */     ApiResult apiResult = ApiResult.FAILED;
/*  606 */     if (MoodLiColorAdjReq.isValid(paramInt)) {
/*  607 */       apiResult = this.mMgr.setIntProperty(33240, 1, paramInt);
/*      */     } else {
/*  609 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  611 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AmbLi_Reboot(int paramInt) {
/*  621 */     return this.mMgr.setIntProperty(33241, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApiResult CB_AmbLiRadarCorrlnReq(int paramInt) {
/*  631 */     ApiResult apiResult = ApiResult.FAILED;
/*  632 */     if (OnOff1.isValid(paramInt)) {
/*  633 */       apiResult = this.mMgr.setIntProperty(33242, 1, paramInt);
/*      */     } else {
/*  635 */       apiResult = ApiResult.PARAM_ERROR;
/*      */     } 
/*  637 */     return apiResult;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiAll getPA_AmbLiAll() throws CarNotConnectedException {
/*  648 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33815, 1);
/*      */     
/*  650 */     PATypes.PA_AmbLiAll pA_AmbLiAll = null;
/*      */     try {
/*  652 */       PATypes.PA_AmbLiAll pA_AmbLiAll1 = new PATypes.PA_AmbLiAll(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiAll = pA_AmbLiAll1;
/*  653 */     } catch (Exception exception) {}
/*      */     
/*  655 */     return pA_AmbLiAll;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiModSetting getPA_AmbLiModSetting() throws CarNotConnectedException {
/*  664 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33816, 1);
/*      */     
/*  666 */     PATypes.PA_AmbLiModSetting pA_AmbLiModSetting = null;
/*      */     try {
/*  668 */       PATypes.PA_AmbLiModSetting pA_AmbLiModSetting1 = new PATypes.PA_AmbLiModSetting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiModSetting = pA_AmbLiModSetting1;
/*  669 */     } catch (Exception exception) {}
/*      */     
/*  671 */     return pA_AmbLiModSetting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiMod_None getPA_AmbLiMod_None() throws CarNotConnectedException {
/*  680 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33817, 1);
/*      */     
/*  682 */     PATypes.PA_AmbLiMod_None pA_AmbLiMod_None = null;
/*      */     try {
/*  684 */       PATypes.PA_AmbLiMod_None pA_AmbLiMod_None1 = new PATypes.PA_AmbLiMod_None(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiMod_None = pA_AmbLiMod_None1;
/*  685 */     } catch (Exception exception) {}
/*      */     
/*  687 */     return pA_AmbLiMod_None;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiMod_CustomizedMode getPA_AmbLiMod_CustomizedMode() throws CarNotConnectedException {
/*  696 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33818, 1);
/*      */     
/*  698 */     PATypes.PA_AmbLiMod_CustomizedMode pA_AmbLiMod_CustomizedMode = null;
/*      */     try {
/*  700 */       PATypes.PA_AmbLiMod_CustomizedMode pA_AmbLiMod_CustomizedMode1 = new PATypes.PA_AmbLiMod_CustomizedMode(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiMod_CustomizedMode = pA_AmbLiMod_CustomizedMode1;
/*  701 */     } catch (Exception exception) {}
/*      */     
/*  703 */     return pA_AmbLiMod_CustomizedMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiMod_DriveMode getPA_AmbLiMod_DriveMode() throws CarNotConnectedException {
/*  712 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33819, 1);
/*      */     
/*  714 */     PATypes.PA_AmbLiMod_DriveMode pA_AmbLiMod_DriveMode = null;
/*      */     try {
/*  716 */       PATypes.PA_AmbLiMod_DriveMode pA_AmbLiMod_DriveMode1 = new PATypes.PA_AmbLiMod_DriveMode(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiMod_DriveMode = pA_AmbLiMod_DriveMode1;
/*  717 */     } catch (Exception exception) {}
/*      */     
/*  719 */     return pA_AmbLiMod_DriveMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiMod_MusicShowMode getPA_AmbLiMod_MusicShowMode() throws CarNotConnectedException {
/*  728 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33820, 1);
/*      */     
/*  730 */     PATypes.PA_AmbLiMod_MusicShowMode pA_AmbLiMod_MusicShowMode = null;
/*      */     try {
/*  732 */       PATypes.PA_AmbLiMod_MusicShowMode pA_AmbLiMod_MusicShowMode1 = new PATypes.PA_AmbLiMod_MusicShowMode(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiMod_MusicShowMode = pA_AmbLiMod_MusicShowMode1;
/*  733 */     } catch (Exception exception) {}
/*      */     
/*  735 */     return pA_AmbLiMod_MusicShowMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiMod_WeatherIndn getPA_AmbLiMod_WeatherIndn() throws CarNotConnectedException {
/*  744 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33821, 1);
/*      */     
/*  746 */     PATypes.PA_AmbLiMod_WeatherIndn pA_AmbLiMod_WeatherIndn = null;
/*      */     try {
/*  748 */       PATypes.PA_AmbLiMod_WeatherIndn pA_AmbLiMod_WeatherIndn1 = new PATypes.PA_AmbLiMod_WeatherIndn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiMod_WeatherIndn = pA_AmbLiMod_WeatherIndn1;
/*  749 */     } catch (Exception exception) {}
/*      */     
/*  751 */     return pA_AmbLiMod_WeatherIndn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CustomEffect getPA_CustomEffect() throws CarNotConnectedException {
/*  760 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33822, 1);
/*      */     
/*  762 */     PATypes.PA_CustomEffect pA_CustomEffect = null;
/*      */     try {
/*  764 */       PATypes.PA_CustomEffect pA_CustomEffect1 = new PATypes.PA_CustomEffect(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CustomEffect = pA_CustomEffect1;
/*  765 */     } catch (Exception exception) {}
/*      */     
/*  767 */     return pA_CustomEffect;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TransitionEffectSel getPA_TransitionEffectSel() throws CarNotConnectedException {
/*  776 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33823, 1);
/*      */     
/*  778 */     PATypes.PA_TransitionEffectSel pA_TransitionEffectSel = null;
/*      */     try {
/*  780 */       PATypes.PA_TransitionEffectSel pA_TransitionEffectSel1 = new PATypes.PA_TransitionEffectSel(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TransitionEffectSel = pA_TransitionEffectSel1;
/*  781 */     } catch (Exception exception) {}
/*      */     
/*  783 */     return pA_TransitionEffectSel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TransitionColor1Settings getPA_TransitionColor1Settings() throws CarNotConnectedException {
/*  792 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33824, 1);
/*      */     
/*  794 */     PATypes.PA_TransitionColor1Settings pA_TransitionColor1Settings = null;
/*      */     try {
/*  796 */       PATypes.PA_TransitionColor1Settings pA_TransitionColor1Settings1 = new PATypes.PA_TransitionColor1Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TransitionColor1Settings = pA_TransitionColor1Settings1;
/*  797 */     } catch (Exception exception) {}
/*      */     
/*  799 */     return pA_TransitionColor1Settings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_TransitionColor2Settings getPA_TransitionColor2Settings() throws CarNotConnectedException {
/*  808 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33825, 1);
/*      */     
/*  810 */     PATypes.PA_TransitionColor2Settings pA_TransitionColor2Settings = null;
/*      */     try {
/*  812 */       PATypes.PA_TransitionColor2Settings pA_TransitionColor2Settings1 = new PATypes.PA_TransitionColor2Settings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TransitionColor2Settings = pA_TransitionColor2Settings1;
/*  813 */     } catch (Exception exception) {}
/*      */     
/*  815 */     return pA_TransitionColor2Settings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ZoneAllStatusSettings getPA_ZoneAllStatusSettings() throws CarNotConnectedException {
/*  824 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33826, 1);
/*      */     
/*  826 */     PATypes.PA_ZoneAllStatusSettings pA_ZoneAllStatusSettings = null;
/*      */     try {
/*  828 */       PATypes.PA_ZoneAllStatusSettings pA_ZoneAllStatusSettings1 = new PATypes.PA_ZoneAllStatusSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ZoneAllStatusSettings = pA_ZoneAllStatusSettings1;
/*  829 */     } catch (Exception exception) {}
/*      */     
/*  831 */     return pA_ZoneAllStatusSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ZoneAllIntensitySettings getPA_ZoneAllIntensitySettings() throws CarNotConnectedException {
/*  840 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33827, 1);
/*      */     
/*  842 */     PATypes.PA_ZoneAllIntensitySettings pA_ZoneAllIntensitySettings = null;
/*      */     try {
/*  844 */       PATypes.PA_ZoneAllIntensitySettings pA_ZoneAllIntensitySettings1 = new PATypes.PA_ZoneAllIntensitySettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ZoneAllIntensitySettings = pA_ZoneAllIntensitySettings1;
/*  845 */     } catch (Exception exception) {}
/*      */     
/*  847 */     return pA_ZoneAllIntensitySettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ZoneAllColorSettings getPA_ZoneAllColorSettings() throws CarNotConnectedException {
/*  856 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33828, 1);
/*      */     
/*  858 */     PATypes.PA_ZoneAllColorSettings pA_ZoneAllColorSettings = null;
/*      */     try {
/*  860 */       PATypes.PA_ZoneAllColorSettings pA_ZoneAllColorSettings1 = new PATypes.PA_ZoneAllColorSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ZoneAllColorSettings = pA_ZoneAllColorSettings1;
/*  861 */     } catch (Exception exception) {}
/*      */     
/*  863 */     return pA_ZoneAllColorSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone1StatusSettings getPA_Zone1StatusSettings() throws CarNotConnectedException {
/*  872 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33829, 1);
/*      */     
/*  874 */     PATypes.PA_Zone1StatusSettings pA_Zone1StatusSettings = null;
/*      */     try {
/*  876 */       PATypes.PA_Zone1StatusSettings pA_Zone1StatusSettings1 = new PATypes.PA_Zone1StatusSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone1StatusSettings = pA_Zone1StatusSettings1;
/*  877 */     } catch (Exception exception) {}
/*      */     
/*  879 */     return pA_Zone1StatusSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone1IntensitySettings getPA_Zone1IntensitySettings() throws CarNotConnectedException {
/*  888 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33830, 1);
/*      */     
/*  890 */     PATypes.PA_Zone1IntensitySettings pA_Zone1IntensitySettings = null;
/*      */     try {
/*  892 */       PATypes.PA_Zone1IntensitySettings pA_Zone1IntensitySettings1 = new PATypes.PA_Zone1IntensitySettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone1IntensitySettings = pA_Zone1IntensitySettings1;
/*  893 */     } catch (Exception exception) {}
/*      */     
/*  895 */     return pA_Zone1IntensitySettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone1ColorSettings getPA_Zone1ColorSettings() throws CarNotConnectedException {
/*  904 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33831, 1);
/*      */     
/*  906 */     PATypes.PA_Zone1ColorSettings pA_Zone1ColorSettings = null;
/*      */     try {
/*  908 */       PATypes.PA_Zone1ColorSettings pA_Zone1ColorSettings1 = new PATypes.PA_Zone1ColorSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone1ColorSettings = pA_Zone1ColorSettings1;
/*  909 */     } catch (Exception exception) {}
/*      */     
/*  911 */     return pA_Zone1ColorSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone2StatusSettings getPA_Zone2StatusSettings() throws CarNotConnectedException {
/*  920 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33832, 1);
/*      */     
/*  922 */     PATypes.PA_Zone2StatusSettings pA_Zone2StatusSettings = null;
/*      */     try {
/*  924 */       PATypes.PA_Zone2StatusSettings pA_Zone2StatusSettings1 = new PATypes.PA_Zone2StatusSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone2StatusSettings = pA_Zone2StatusSettings1;
/*  925 */     } catch (Exception exception) {}
/*      */     
/*  927 */     return pA_Zone2StatusSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone2IntensitySettings getPA_Zone2IntensitySettings() throws CarNotConnectedException {
/*  936 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33833, 1);
/*      */     
/*  938 */     PATypes.PA_Zone2IntensitySettings pA_Zone2IntensitySettings = null;
/*      */     try {
/*  940 */       PATypes.PA_Zone2IntensitySettings pA_Zone2IntensitySettings1 = new PATypes.PA_Zone2IntensitySettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone2IntensitySettings = pA_Zone2IntensitySettings1;
/*  941 */     } catch (Exception exception) {}
/*      */     
/*  943 */     return pA_Zone2IntensitySettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone2ColorSettings getPA_Zone2ColorSettings() throws CarNotConnectedException {
/*  952 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33834, 1);
/*      */     
/*  954 */     PATypes.PA_Zone2ColorSettings pA_Zone2ColorSettings = null;
/*      */     try {
/*  956 */       PATypes.PA_Zone2ColorSettings pA_Zone2ColorSettings1 = new PATypes.PA_Zone2ColorSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone2ColorSettings = pA_Zone2ColorSettings1;
/*  957 */     } catch (Exception exception) {}
/*      */     
/*  959 */     return pA_Zone2ColorSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone3StatusSettings getPA_Zone3StatusSettings() throws CarNotConnectedException {
/*  968 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33835, 1);
/*      */     
/*  970 */     PATypes.PA_Zone3StatusSettings pA_Zone3StatusSettings = null;
/*      */     try {
/*  972 */       PATypes.PA_Zone3StatusSettings pA_Zone3StatusSettings1 = new PATypes.PA_Zone3StatusSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone3StatusSettings = pA_Zone3StatusSettings1;
/*  973 */     } catch (Exception exception) {}
/*      */     
/*  975 */     return pA_Zone3StatusSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone3IntensitySettings getPA_Zone3IntensitySettings() throws CarNotConnectedException {
/*  984 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33836, 1);
/*      */     
/*  986 */     PATypes.PA_Zone3IntensitySettings pA_Zone3IntensitySettings = null;
/*      */     try {
/*  988 */       PATypes.PA_Zone3IntensitySettings pA_Zone3IntensitySettings1 = new PATypes.PA_Zone3IntensitySettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone3IntensitySettings = pA_Zone3IntensitySettings1;
/*  989 */     } catch (Exception exception) {}
/*      */     
/*  991 */     return pA_Zone3IntensitySettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_Zone3ColorSettings getPA_Zone3ColorSettings() throws CarNotConnectedException {
/* 1000 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33837, 1);
/*      */     
/* 1002 */     PATypes.PA_Zone3ColorSettings pA_Zone3ColorSettings = null;
/*      */     try {
/* 1004 */       PATypes.PA_Zone3ColorSettings pA_Zone3ColorSettings1 = new PATypes.PA_Zone3ColorSettings(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Zone3ColorSettings = pA_Zone3ColorSettings1;
/* 1005 */     } catch (Exception exception) {}
/*      */     
/* 1007 */     return pA_Zone3ColorSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_MoodLightSwitch getPA_MoodLightSwitch() throws CarNotConnectedException {
/* 1016 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33838, 1);
/*      */     
/* 1018 */     PATypes.PA_MoodLightSwitch pA_MoodLightSwitch = null;
/*      */     try {
/* 1020 */       PATypes.PA_MoodLightSwitch pA_MoodLightSwitch1 = new PATypes.PA_MoodLightSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_MoodLightSwitch = pA_MoodLightSwitch1;
/* 1021 */     } catch (Exception exception) {}
/*      */     
/* 1023 */     return pA_MoodLightSwitch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiMilgOpenReq getPA_AmbLiMilgOpenReq() throws CarNotConnectedException {
/* 1032 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33839, 1);
/*      */     
/* 1034 */     PATypes.PA_AmbLiMilgOpenReq pA_AmbLiMilgOpenReq = null;
/*      */     try {
/* 1036 */       PATypes.PA_AmbLiMilgOpenReq pA_AmbLiMilgOpenReq1 = new PATypes.PA_AmbLiMilgOpenReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiMilgOpenReq = pA_AmbLiMilgOpenReq1;
/* 1037 */     } catch (Exception exception) {}
/*      */     
/* 1039 */     return pA_AmbLiMilgOpenReq;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiPhoneOpenReq getPA_AmbLiPhoneOpenReq() throws CarNotConnectedException {
/* 1048 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33840, 1);
/*      */     
/* 1050 */     PATypes.PA_AmbLiPhoneOpenReq pA_AmbLiPhoneOpenReq = null;
/*      */     try {
/* 1052 */       PATypes.PA_AmbLiPhoneOpenReq pA_AmbLiPhoneOpenReq1 = new PATypes.PA_AmbLiPhoneOpenReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiPhoneOpenReq = pA_AmbLiPhoneOpenReq1;
/* 1053 */     } catch (Exception exception) {}
/*      */     
/* 1055 */     return pA_AmbLiPhoneOpenReq;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ReadLightFrontLeft getPA_ReadLightFrontLeft() throws CarNotConnectedException {
/* 1064 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33841, 1);
/*      */     
/* 1066 */     PATypes.PA_ReadLightFrontLeft pA_ReadLightFrontLeft = null;
/*      */     try {
/* 1068 */       PATypes.PA_ReadLightFrontLeft pA_ReadLightFrontLeft1 = new PATypes.PA_ReadLightFrontLeft(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ReadLightFrontLeft = pA_ReadLightFrontLeft1;
/* 1069 */     } catch (Exception exception) {}
/*      */     
/* 1071 */     return pA_ReadLightFrontLeft;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ReadLightFrontRight getPA_ReadLightFrontRight() throws CarNotConnectedException {
/* 1080 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33842, 1);
/*      */     
/* 1082 */     PATypes.PA_ReadLightFrontRight pA_ReadLightFrontRight = null;
/*      */     try {
/* 1084 */       PATypes.PA_ReadLightFrontRight pA_ReadLightFrontRight1 = new PATypes.PA_ReadLightFrontRight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ReadLightFrontRight = pA_ReadLightFrontRight1;
/* 1085 */     } catch (Exception exception) {}
/*      */     
/* 1087 */     return pA_ReadLightFrontRight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ReadLightSecondRowLeft getPA_ReadLightSecondRowLeft() throws CarNotConnectedException {
/* 1096 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33843, 1);
/*      */     
/* 1098 */     PATypes.PA_ReadLightSecondRowLeft pA_ReadLightSecondRowLeft = null;
/*      */     try {
/* 1100 */       PATypes.PA_ReadLightSecondRowLeft pA_ReadLightSecondRowLeft1 = new PATypes.PA_ReadLightSecondRowLeft(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ReadLightSecondRowLeft = pA_ReadLightSecondRowLeft1;
/* 1101 */     } catch (Exception exception) {}
/*      */     
/* 1103 */     return pA_ReadLightSecondRowLeft;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ReadLightSecondRowRight getPA_ReadLightSecondRowRight() throws CarNotConnectedException {
/* 1112 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33844, 1);
/*      */     
/* 1114 */     PATypes.PA_ReadLightSecondRowRight pA_ReadLightSecondRowRight = null;
/*      */     try {
/* 1116 */       PATypes.PA_ReadLightSecondRowRight pA_ReadLightSecondRowRight1 = new PATypes.PA_ReadLightSecondRowRight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ReadLightSecondRowRight = pA_ReadLightSecondRowRight1;
/* 1117 */     } catch (Exception exception) {}
/*      */     
/* 1119 */     return pA_ReadLightSecondRowRight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ReadLightThirdRowLeft getPA_ReadLightThirdRowLeft() throws CarNotConnectedException {
/* 1128 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33845, 1);
/*      */     
/* 1130 */     PATypes.PA_ReadLightThirdRowLeft pA_ReadLightThirdRowLeft = null;
/*      */     try {
/* 1132 */       PATypes.PA_ReadLightThirdRowLeft pA_ReadLightThirdRowLeft1 = new PATypes.PA_ReadLightThirdRowLeft(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ReadLightThirdRowLeft = pA_ReadLightThirdRowLeft1;
/* 1133 */     } catch (Exception exception) {}
/*      */     
/* 1135 */     return pA_ReadLightThirdRowLeft;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ReadLightThirdRowRight getPA_ReadLightThirdRowRight() throws CarNotConnectedException {
/* 1144 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33846, 1);
/*      */     
/* 1146 */     PATypes.PA_ReadLightThirdRowRight pA_ReadLightThirdRowRight = null;
/*      */     try {
/* 1148 */       PATypes.PA_ReadLightThirdRowRight pA_ReadLightThirdRowRight1 = new PATypes.PA_ReadLightThirdRowRight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ReadLightThirdRowRight = pA_ReadLightThirdRowRight1;
/* 1149 */     } catch (Exception exception) {}
/*      */     
/* 1151 */     return pA_ReadLightThirdRowRight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_WeatherInfoConService getPA_WeatherInfoConService() throws CarNotConnectedException {
/* 1160 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33847, 1);
/*      */     
/* 1162 */     PATypes.PA_WeatherInfoConService pA_WeatherInfoConService = null;
/*      */     try {
/* 1164 */       PATypes.PA_WeatherInfoConService pA_WeatherInfoConService1 = new PATypes.PA_WeatherInfoConService(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WeatherInfoConService = pA_WeatherInfoConService1;
/* 1165 */     } catch (Exception exception) {}
/*      */     
/* 1167 */     return pA_WeatherInfoConService;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CourtesyLight getPA_CourtesyLight() throws CarNotConnectedException {
/* 1176 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33848, 1);
/*      */     
/* 1178 */     PATypes.PA_CourtesyLight pA_CourtesyLight = null;
/*      */     try {
/* 1180 */       PATypes.PA_CourtesyLight pA_CourtesyLight1 = new PATypes.PA_CourtesyLight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CourtesyLight = pA_CourtesyLight1;
/* 1181 */     } catch (Exception exception) {}
/*      */     
/* 1183 */     return pA_CourtesyLight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_WelcomeLight getPA_WelcomeLight() throws CarNotConnectedException {
/* 1192 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33849, 1);
/*      */     
/* 1194 */     PATypes.PA_WelcomeLight pA_WelcomeLight = null;
/*      */     try {
/* 1196 */       PATypes.PA_WelcomeLight pA_WelcomeLight1 = new PATypes.PA_WelcomeLight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WelcomeLight = pA_WelcomeLight1;
/* 1197 */     } catch (Exception exception) {}
/*      */     
/* 1199 */     return pA_WelcomeLight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_GoodbyeLight getPA_GoodbyeLight() throws CarNotConnectedException {
/* 1208 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33850, 1);
/*      */     
/* 1210 */     PATypes.PA_GoodbyeLight pA_GoodbyeLight = null;
/*      */     try {
/* 1212 */       PATypes.PA_GoodbyeLight pA_GoodbyeLight1 = new PATypes.PA_GoodbyeLight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_GoodbyeLight = pA_GoodbyeLight1;
/* 1213 */     } catch (Exception exception) {}
/*      */     
/* 1215 */     return pA_GoodbyeLight;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_ReadLightAllOnSwitch getPA_ReadLightAllOnSwitch() throws CarNotConnectedException {
/* 1224 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33851, 1);
/*      */     
/* 1226 */     PATypes.PA_ReadLightAllOnSwitch pA_ReadLightAllOnSwitch = null;
/*      */     try {
/* 1228 */       PATypes.PA_ReadLightAllOnSwitch pA_ReadLightAllOnSwitch1 = new PATypes.PA_ReadLightAllOnSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ReadLightAllOnSwitch = pA_ReadLightAllOnSwitch1;
/* 1229 */     } catch (Exception exception) {}
/*      */     
/* 1231 */     return pA_ReadLightAllOnSwitch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_CustomEffectBreath getPA_CustomEffectBreath() throws CarNotConnectedException {
/* 1240 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33852, 1);
/*      */     
/* 1242 */     PATypes.PA_CustomEffectBreath pA_CustomEffectBreath = null;
/*      */     try {
/* 1244 */       PATypes.PA_CustomEffectBreath pA_CustomEffectBreath1 = new PATypes.PA_CustomEffectBreath(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_CustomEffectBreath = pA_CustomEffectBreath1;
/* 1245 */     } catch (Exception exception) {}
/*      */     
/* 1247 */     return pA_CustomEffectBreath;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_MoodLiColorAdjReq getPA_MoodLiColorAdjReq() throws CarNotConnectedException {
/* 1256 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33853, 1);
/*      */     
/* 1258 */     PATypes.PA_MoodLiColorAdjReq pA_MoodLiColorAdjReq = null;
/*      */     try {
/* 1260 */       PATypes.PA_MoodLiColorAdjReq pA_MoodLiColorAdjReq1 = new PATypes.PA_MoodLiColorAdjReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_MoodLiColorAdjReq = pA_MoodLiColorAdjReq1;
/* 1261 */     } catch (Exception exception) {}
/*      */     
/* 1263 */     return pA_MoodLiColorAdjReq;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLiRadarCorrlnReq getPA_AmbLiRadarCorrlnReq() throws CarNotConnectedException {
/* 1272 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33854, 1);
/*      */     
/* 1274 */     PATypes.PA_AmbLiRadarCorrlnReq pA_AmbLiRadarCorrlnReq = null;
/*      */     try {
/* 1276 */       PATypes.PA_AmbLiRadarCorrlnReq pA_AmbLiRadarCorrlnReq1 = new PATypes.PA_AmbLiRadarCorrlnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLiRadarCorrlnReq = pA_AmbLiRadarCorrlnReq1;
/* 1277 */     } catch (Exception exception) {}
/*      */     
/* 1279 */     return pA_AmbLiRadarCorrlnReq;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PATypes.PA_AmbLi_MsgEnd getPA_AmbLi_MsgEnd() throws CarNotConnectedException {
/* 1288 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33925, 1);
/*      */     
/* 1290 */     PATypes.PA_AmbLi_MsgEnd pA_AmbLi_MsgEnd = null;
/*      */     try {
/* 1292 */       PATypes.PA_AmbLi_MsgEnd pA_AmbLi_MsgEnd1 = new PATypes.PA_AmbLi_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AmbLi_MsgEnd = pA_AmbLi_MsgEnd1;
/* 1293 */     } catch (Exception exception) {}
/*      */     
/* 1295 */     return pA_AmbLi_MsgEnd;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarAmbliManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */