/*      */ package ecarx.car.hardware.vehicle;
/*      */ 
/*      */ import ecarx.car.hardware.ECarXCarPropertyValue;
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
/*      */ public class CarPAEventCallback
/*      */ {
/*      */   private static final String TAG = "CarPAEventCallback";
/*      */   private byte[] data;
/*      */   
/*      */   public void onPAChanged(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/*   22 */     if (paramECarXCarPropertyValue != null)
/*      */       
/*      */       try {
/*   25 */         convertData(paramECarXCarPropertyValue);
/*   26 */       } catch (Exception exception) {
/*   27 */         exception.printStackTrace();
/*      */       }   } private void convertData(ECarXCarPropertyValue paramECarXCarPropertyValue) { 
/*      */     try { byte[] arrayOfByte167; PATypes.PA_TopVisnDispExtnReq pA_TopVisnDispExtnReq; PATypes.PA_ThrDTouringViewReq pA_ThrDTouringViewReq; PATypes.PA_SurrndgsObjDetnReq pA_SurrndgsObjDetnReq; PATypes.PA_PrkgIndcrLineReq pA_PrkgIndcrLineReq; PATypes.PA_HudDispModSetgReq pA_HudDispModSetgReq; PATypes.PA_FaceSgnInForProf pA_FaceSgnInForProf; byte[] arrayOfByte166; PATypes.PA_VehCharg_ChargingColumn pA_VehCharg_ChargingColumn; PATypes.PA_SCEMOD_SceneModSeldCustomization pA_SCEMOD_SceneModSeldCustomization; byte[] arrayOfByte165; PATypes.PA_SENSOR_JoyForbidState pA_SENSOR_JoyForbidState; PATypes.PA_SENSOR_JoyLimitState pA_SENSOR_JoyLimitState; PATypes.PA_SENSOR_EngHrToSrvValue pA_SENSOR_EngHrToSrvValue; PATypes.PA_SENSOR_DayToSrvValue pA_SENSOR_DayToSrvValue; PATypes.PA_SENSOR_DstToSrvValue pA_SENSOR_DstToSrvValue; byte[] arrayOfByte164; PATypes.PA_SCEMOD_SceneModSeldPassengerRepose pA_SCEMOD_SceneModSeldPassengerRepose; byte[] arrayOfByte163; PATypes.PA_SCEMOD_SceneModSeldKing pA_SCEMOD_SceneModSeldKing; PATypes.PA_SCEMOD_SceneModSeldEco pA_SCEMOD_SceneModSeldEco; PATypes.PA_SCEMOD_SceneModSeldRearRowTheater pA_SCEMOD_SceneModSeldRearRowTheater; PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater pA_SCEMOD_SceneModSeldFrontRowTheater; byte[] arrayOfByte162; PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest pA_SCEMOD_SceneModSeldSecondLeftRest; PATypes.PA_SCEMOD_SceneModSeldPassengerRest pA_SCEMOD_SceneModSeldPassengerRest; byte[] arrayOfByte161; PATypes.PA_SCEMOD_SceneModSeldPet pA_SCEMOD_SceneModSeldPet; PATypes.PA_SCEMOD_SceneModSeldRomantic pA_SCEMOD_SceneModSeldRomantic; PATypes.PA_SCEMOD_SceneModSeldWakeUp pA_SCEMOD_SceneModSeldWakeUp; PATypes.PA_TS_CurTripTime pA_TS_CurTripTime; byte[] arrayOfByte160; PATypes.PA_HUD_DispModSet pA_HUD_DispModSet; PATypes.PA_PSET_NameP5 pA_PSET_NameP5; PATypes.PA_PSET_NameP4 pA_PSET_NameP4; PATypes.PA_PSET_NameP3 pA_PSET_NameP3; PATypes.PA_PSET_NameP2 pA_PSET_NameP2; PATypes.PA_PSET_NameP1 pA_PSET_NameP1; byte[] arrayOfByte159; PATypes.PA_VM2_MsgEnd pA_VM2_MsgEnd; byte[] arrayOfByte158; PATypes.PA_WPC_MsgEnd pA_WPC_MsgEnd; byte[] arrayOfByte157; PATypes.PA_SC_MsgEnd pA_SC_MsgEnd; PATypes.PA_PAS_MsgEnd pA_PAS_MsgEnd; PATypes.PA_PAC_MsgEnd pA_PAC_MsgEnd; byte[] arrayOfByte156; PATypes.PA_HUD_MsgEnd pA_HUD_MsgEnd; byte[] arrayOfByte155; PATypes.PA_PSET_MsgEnd pA_PSET_MsgEnd; byte[] arrayOfByte154; PATypes.PA_SCV_MsgEnd pA_SCV_MsgEnd; PATypes.PA_CL_MsgEnd pA_CL_MsgEnd; byte[] arrayOfByte153; PATypes.PA_Asy_MsgEnd pA_Asy_MsgEnd; PATypes.PA_TS_MsgEnd pA_TS_MsgEnd; PATypes.PA_AP_Version pA_AP_Version; PATypes.PA_AmpDiagResult pA_AmpDiagResult; byte[] arrayOfByte152; PATypes.PA_PSET_ProfileCloudData pA_PSET_ProfileCloudData; PATypes.PA_PSET_ProfAct pA_PSET_ProfAct; PATypes.PA_PSET_GID_Result pA_PSET_GID_Result; byte[] arrayOfByte151; PATypes.PA_PSET_SeatButtonOnOff pA_PSET_SeatButtonOnOff; byte[] arrayOfByte150; PATypes.PA_PSET_User2 pA_PSET_User2; byte[] arrayOfByte149; PATypes.PA_PSET_NFC_Result pA_PSET_NFC_Result; byte[] arrayOfByte148; PATypes.PA_PSET_AutLogOutCurrent pA_PSET_AutLogOutCurrent; byte[] arrayOfByte147; PATypes.PA_PSET_PChangeAllowed pA_PSET_PChangeAllowed; PATypes.PA_PSET_KeyID pA_PSET_KeyID; byte[] arrayOfByte146; PATypes.PA_PSET_ProfileFactoryDefaultResult pA_PSET_ProfileFactoryDefaultResult; byte[] arrayOfByte145; PATypes.PA_PSET_DeleteProfile pA_PSET_DeleteProfile; byte[] arrayOfByte144; PATypes.PA_VFS_DPS pA_VFS_DPS; PATypes.PA_VFS_FaceIdnReq pA_VFS_FaceIdnReq; byte[] arrayOfByte143; PATypes.PA_ChdLockReLeft_ChdMod pA_ChdLockReLeft_ChdMod; PATypes.PA_ChdLockReRight pA_ChdLockReRight; byte[] arrayOfByte142; PATypes.PA_WinPosnStsAtReLe pA_WinPosnStsAtReLe; PATypes.PA_WinPosnStsAtPass pA_WinPosnStsAtPass; PATypes.PA_WinPosnStsAtDrvr pA_WinPosnStsAtDrvr; PATypes.PA_WinOpenReRiReq pA_WinOpenReRiReq; byte[] arrayOfByte141; PATypes.PA_WinOpenPassReq pA_WinOpenPassReq; byte[] arrayOfByte140; PATypes.PA_EgyRgnLvlSet pA_EgyRgnLvlSet; byte[] arrayOfByte139; PATypes.PA_MoodLiColorAdjReq pA_MoodLiColorAdjReq; PATypes.PA_CustomEffectBreath pA_CustomEffectBreath; byte[] arrayOfByte138; PATypes.PA_GoodbyeLight pA_GoodbyeLight; PATypes.PA_WelcomeLight pA_WelcomeLight; PATypes.PA_CourtesyLight pA_CourtesyLight; PATypes.PA_WeatherInfoConService pA_WeatherInfoConService; byte[] arrayOfByte137; PATypes.PA_ReadLightThirdRowLeft pA_ReadLightThirdRowLeft; byte[] arrayOfByte136; PATypes.PA_ReadLightFrontRight pA_ReadLightFrontRight; PATypes.PA_ReadLightFrontLeft pA_ReadLightFrontLeft; PATypes.PA_AmbLiPhoneOpenReq pA_AmbLiPhoneOpenReq; byte[] arrayOfByte135; PATypes.PA_MoodLightSwitch pA_MoodLightSwitch; PATypes.PA_Zone3ColorSettings pA_Zone3ColorSettings; byte[] arrayOfByte134; PATypes.PA_Zone3StatusSettings pA_Zone3StatusSettings; byte[] arrayOfByte133; PATypes.PA_Zone2StatusSettings pA_Zone2StatusSettings; byte[] arrayOfByte132; PATypes.PA_Zone1IntensitySettings pA_Zone1IntensitySettings; PATypes.PA_Zone1StatusSettings pA_Zone1StatusSettings; byte[] arrayOfByte131; PATypes.PA_ZoneAllIntensitySettings pA_ZoneAllIntensitySettings; PATypes.PA_ZoneAllStatusSettings pA_ZoneAllStatusSettings; byte[] arrayOfByte130; PATypes.PA_TransitionColor1Settings pA_TransitionColor1Settings; PATypes.PA_TransitionEffectSel pA_TransitionEffectSel; byte[] arrayOfByte129; PATypes.PA_AmbLiMod_MusicShowMode pA_AmbLiMod_MusicShowMode; PATypes.PA_AmbLiMod_DriveMode pA_AmbLiMod_DriveMode; byte[] arrayOfByte128; PATypes.PA_AmbLiModSetting pA_AmbLiModSetting; byte[] arrayOfByte127; PATypes.PA_SunCurtOpenPosnReq pA_SunCurtOpenPosnReq; byte[] arrayOfByte126; PATypes.PA_SunCurtainPosnSts pA_SunCurtainPosnSts; PATypes.PA_SunRoofPosnSts pA_SunRoofPosnSts; PATypes.PA_CloseSunCurtain_Btn pA_CloseSunCurtain_Btn; PATypes.PA_OpenSunCurtain_Btn pA_OpenSunCurtain_Btn; PATypes.PA_CloseSunRoof_Btn pA_CloseSunRoof_Btn; byte[] arrayOfByte125; PATypes.PA_SunCurtain_Setting pA_SunCurtain_Setting; byte[] arrayOfByte124; PATypes.PA_VehCharg_DispHvBattLvlOfChrg pA_VehCharg_DispHvBattLvlOfChrg; PATypes.PA_VehCharg_DchaEgyAct pA_VehCharg_DchaEgyAct; byte[] arrayOfByte123; PATypes.PA_VehCharg_DchaIAct pA_VehCharg_DchaIAct; PATypes.PA_VehCharg_DchaUAct pA_VehCharg_DchaUAct; byte[] arrayOfByte122; PATypes.PA_VehCharg_DisChargeSwitch pA_VehCharg_DisChargeSwitch; byte[] arrayOfByte121; PATypes.PA_VehCharg_Appointment pA_VehCharg_Appointment; PATypes.PA_VehCharg_ChargLight pA_VehCharg_ChargLight; byte[] arrayOfByte120; PATypes.PA_VehCharg_SetSOC pA_VehCharg_SetSOC; PATypes.PA_VehCharg_SetA pA_VehCharg_SetA; PATypes.PA_VehCharg_ChargRemind pA_VehCharg_ChargRemind; byte[] arrayOfByte119; PATypes.PA_TS_energyReStats10 pA_TS_energyReStats10; PATypes.PA_TS_energyStats100 pA_TS_energyStats100; PATypes.PA_TS_energyStats10 pA_TS_energyStats10; byte[] arrayOfByte118; PATypes.PA_TS_TripAverageConsumption5Km pA_TS_TripAverageConsumption5Km; byte[] arrayOfByte117; PATypes.PA_TS_Zero_Emission pA_TS_Zero_Emission; PATypes.PA_TS_EDT_time2 pA_TS_EDT_time2; PATypes.PA_TS_DTEHV_round pA_TS_DTEHV_round; byte[] arrayOfByte116; PATypes.PA_TS_DTEIndicated pA_TS_DTEIndicated; PATypes.PA_D0D0 pA_D0D0; PATypes.PA_D0D1 pA_D0D1; PATypes.PA_D0D2 pA_D0D2; PATypes.PA_Privacy_Compliance_Reset pA_Privacy_Compliance_Reset; byte[] arrayOfByte115; PATypes.PA_AuthorityCameraSwitch pA_AuthorityCameraSwitch; byte[] arrayOfByte114; PATypes.PA_FD86 pA_FD86; byte[] arrayOfByte113; PATypes.PA_FD85 pA_FD85; PATypes.PA_FD62 pA_FD62; PATypes.PA_FD43 pA_FD43; PATypes.PA_FD41 pA_FD41; PATypes.PA_FD44 pA_FD44; PATypes.PA_FD42 pA_FD42; PATypes.PA_FD23 pA_FD23; PATypes.PA_FD30 pA_FD30; PATypes.PA_FD5A pA_FD5A; PATypes.PA_FD17 pA_FD17; PATypes.PA_FD12 pA_FD12; PATypes.PA_FD29 pA_FD29; byte[] arrayOfByte112; PATypes.PA_FD28 pA_FD28; byte[] arrayOfByte111; PATypes.PA_D907 pA_D907; PATypes.PA_Manufacturing_Signal pA_Manufacturing_Signal; PATypes.PA_VolvoHWSD_Reading pA_VolvoHWSD_Reading; PATypes.PA_VolvoDelivery_Assemble_Reading pA_VolvoDelivery_Assemble_Reading; PATypes.PA_GeelyHSWD_Reading pA_GeelyHSWD_Reading; PATypes.PA_Geely_Delivery_Assemble_Reading pA_Geely_Delivery_Assemble_Reading; PATypes.PA_HW_Version_Reading pA_HW_Version_Reading; PATypes.PA_IHUID_Reading pA_IHUID_Reading; PATypes.PA_XDSN_Reading pA_XDSN_Reading; PATypes.PA_Product_Serial_Number pA_Product_Serial_Number; byte[] arrayOfByte110; PATypes.PA_Gesture_Video_IN pA_Gesture_Video_IN; byte[] arrayOfByte109; PATypes.PA_CSD_MONITOR_EN pA_CSD_MONITOR_EN; PATypes.PA_DiagProxy_Psd_GW_Fun pA_DiagProxy_Psd_GW_Fun; PATypes.PA_DiagProxy_Psd_GW_Phy pA_DiagProxy_Psd_GW_Phy; PATypes.PA_DiagProxy_Csdm_GW_Fun pA_DiagProxy_Csdm_GW_Fun; PATypes.PA_DiagProxy_Csdm_GW_Phy pA_DiagProxy_Csdm_GW_Phy; PATypes.PA_DiagProxy_Csd_GW_Fun pA_DiagProxy_Csd_GW_Fun; PATypes.PA_DiagProxy_Csd_GW_Phy pA_DiagProxy_Csd_GW_Phy; PATypes.PA_DiagProxy_Status pA_DiagProxy_Status; byte[] arrayOfByte108; PATypes.PA_DstTrvldOfEng pA_DstTrvldOfEng; PATypes.PA_DstTrvldOfEV pA_DstTrvldOfEV; PATypes.PA_DstTrvldAct pA_DstTrvldAct; PATypes.PA_ServiceReminderType pA_ServiceReminderType; byte[] arrayOfByte107; PATypes.PA_DoubleLock pA_DoubleLock; byte[] arrayOfByte106; PATypes.PA_TripCom_RstAEC pA_TripCom_RstAEC; PATypes.PA_TripCom_RstAFC pA_TripCom_RstAFC; byte[] arrayOfByte105; PATypes.PA_TripCom_RstAVS pA_TripCom_RstAVS; byte[] arrayOfByte104; PATypes.PA_RefuleAutoResetSetting pA_RefuleAutoResetSetting; PATypes.PA_ParkingAutoResetSetting pA_ParkingAutoResetSetting; byte[] arrayOfByte103; PATypes.PA_CollectionRadio pA_CollectionRadio; byte[] arrayOfByte102; PATypes.PA_NaviHome pA_NaviHome; byte[] arrayOfByte101; PATypes.PA_DVR pA_DVR; byte[] arrayOfByte100; PATypes.PA_SelfDefineFuncReq pA_SelfDefineFuncReq; byte[] arrayOfByte99; PATypes.PA_ElectricTailgate_Setting pA_ElectricTailgate_Setting; PATypes.PA_ChangeFailMsg pA_ChangeFailMsg; byte[] arrayOfByte98; PATypes.PA_CSDTheme_Setting pA_CSDTheme_Setting; PATypes.PA_DIMTheme_DrvSetting pA_DIMTheme_DrvSetting; byte[] arrayOfByte97; PATypes.PA_LockgFbSoundSet pA_LockgFbSoundSet; byte[] arrayOfByte96; PATypes.PA_PasAcsLock_Setting pA_PasAcsLock_Setting; PATypes.PA_UnLockSetting pA_UnLockSetting; PATypes.PA_PowerFlow_MHEV pA_PowerFlow_MHEV; PATypes.PA_PowerFlow pA_PowerFlow; byte[] arrayOfByte95; PATypes.PA_External_Sound_Setting pA_External_Sound_Setting; byte[] arrayOfByte94; PATypes.PA_AutoHoldStatus pA_AutoHoldStatus; byte[] arrayOfByte93; PATypes.PA_SuspHeiSetting pA_SuspHeiSetting; byte[] arrayOfByte92; PATypes.PA_EasyEntrySetting pA_EasyEntrySetting; byte[] arrayOfByte91; PATypes.PA_MirrTiltSetg pA_MirrTiltSetg; byte[] arrayOfByte90; PATypes.PA_BendingLight pA_BendingLight; PATypes.PA_ApproachLightOnOff_Setting pA_ApproachLightOnOff_Setting; PATypes.PA_AL_HomeSafeLight pA_AL_HomeSafeLight; PATypes.PA_CornrgLi_Setting pA_CornrgLi_Setting; byte[] arrayOfByte89; PATypes.PA_PBC_ESCSportActiv pA_PBC_ESCSportActiv; byte[] arrayOfByte88; PATypes.PA_SteeringWheelPosAdj pA_SteeringWheelPosAdj; PATypes.PA_Steer_SteeringMod pA_Steer_SteeringMod; PATypes.PA_Steer_SteerAsscLvl pA_Steer_SteerAsscLvl; byte[] arrayOfByte87; PATypes.PA_WPC_InchargeStatus pA_WPC_InchargeStatus; byte[] arrayOfByte86; PATypes.PA_PassSeatSwtSelnOfSpplFctSts pA_PassSeatSwtSelnOfSpplFctSts; PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts pA_DrvrSeatSwtSelnOfSpplFctSts; byte[] arrayOfByte85; PATypes.PA_HotStoneMassageDrvrAllowd pA_HotStoneMassageDrvrAllowd; PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts pA_SeatRowSecRiSwtStsPassSeatSwtInclSts; PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts pA_SeatRowSecLeSwtStsPassSeatSwtInclSts; byte[] arrayOfByte84; PATypes.PA_SecRowSeatInclLeFwdBackwAllowd pA_SecRowSeatInclLeFwdBackwAllowd; byte[] arrayOfByte83; PATypes.PA_SecRowSeatLenRiFwdBackwAllowd pA_SecRowSeatLenRiFwdBackwAllowd; PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts pA_SeatRowSecLeSwtStsPassSeatSwtSldSts; byte[] arrayOfByte82; PATypes.PA_DrvrMultFuncMenuExt pA_DrvrMultFuncMenuExt; byte[] arrayOfByte81; PATypes.PA_PassSeatDispMassgFct_MassgInten pA_PassSeatDispMassgFct_MassgInten; byte[] arrayOfByte80; PATypes.PA_PassSeatMassageStsAllowd pA_PassSeatMassageStsAllowd; PATypes.PA_DrvrSeatDispMassgFct_MassgInten pA_DrvrSeatDispMassgFct_MassgInten; PATypes.PA_DrvrSeatDispMassgFct_MassgProg pA_DrvrSeatDispMassgFct_MassgProg; PATypes.PA_DrvrSeatDispMassgFct_OnOff pA_DrvrSeatDispMassgFct_OnOff; byte[] arrayOfByte79; PATypes.PA_PassSeatSideUpDownStsAllowd pA_PassSeatSideUpDownStsAllowd; PATypes.PA_DrvrSeatSideUpDownStsAllowd pA_DrvrSeatSideUpDownStsAllowd; byte[] arrayOfByte78; PATypes.PA_DrvrSeatLmbrUpDownStsAllowd pA_DrvrSeatLmbrUpDownStsAllowd; byte[] arrayOfByte77; PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts pA_PassSeatSwtAdjmtOfSpplFctVertSts; byte[] arrayOfByte76; PATypes.PA_DrvrSeatActvSpplFct pA_DrvrSeatActvSpplFct; PATypes.PA_EasyInOutDrvrSeatAdjmt pA_EasyInOutDrvrSeatAdjmt; PATypes.PA_EasyInOutDrvrSeatAllowd pA_EasyInOutDrvrSeatAllowd; PATypes.PA_PassSeatSwtInclSts pA_PassSeatSwtInclSts; byte[] arrayOfByte75; PATypes.PA_PassSeatSwtHeiFrntStsAllowd pA_PassSeatSwtHeiFrntStsAllowd; PATypes.PA_DrvrSeatSwtHeiFrntSts pA_DrvrSeatSwtHeiFrntSts; byte[] arrayOfByte74; PATypes.PA_PassSeatSwtHeiSts pA_PassSeatSwtHeiSts; PATypes.PA_PassSeatSwtHeiStsAllowd pA_PassSeatSwtHeiStsAllowd; byte[] arrayOfByte73; PATypes.PA_DrvrSeatSwtHeiStsAllowd pA_DrvrSeatSwtHeiStsAllowd; byte[] arrayOfByte72; PATypes.PA_PassSeatExtAdjAllowd pA_PassSeatExtAdjAllowd; PATypes.PA_DrvrSeatSwtSldSts pA_DrvrSeatSwtSldSts; byte[] arrayOfByte71; PATypes.PA_PEB_PrkgEmgyBrkSysSts pA_PEB_PrkgEmgyBrkSysSts; PATypes.PA_PEB_PrkgEmgBrkSysSwt pA_PEB_PrkgEmgBrkSysSwt; byte[] arrayOfByte70; PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt pA_PAS_OutdLeOfSnsrPrkgAssiFrnt; byte[] arrayOfByte69; PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt pA_PAS_InsdLeOfSnsrPrkgAssiFrnt; byte[] arrayOfByte68; PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe pA_PAS_InsdLeOfSnsrPrkgAssiRe; PATypes.PA_PAS_PrkgDstCtrlSts pA_PAS_PrkgDstCtrlSts; PATypes.PA_PAS_PrkgDstCtrlSysSwt pA_PAS_PrkgDstCtrlSysSwt; PATypes.PA_SAP_TouchUnlckTyp pA_SAP_TouchUnlckTyp; byte[] arrayOfByte67; PATypes.PA_SAP_PrkgFctDiDisp pA_SAP_PrkgFctDiDisp; PATypes.PA_SAP_DrvrAsscSysBtnPush pA_SAP_DrvrAsscSysBtnPush; byte[] arrayOfByte66; PATypes.PA_PAC_ImgSnsrClrReq pA_PAC_ImgSnsrClrReq; PATypes.PA_PAC_PlaModStsResp pA_PAC_PlaModStsResp; byte[] arrayOfByte65; PATypes.PA_PAC_TurnEntryAgWideVisResp pA_PAC_TurnEntryAgWideVisResp; PATypes.PA_PAC_ThrDTouringViewResp pA_PAC_ThrDTouringViewResp; byte[] arrayOfByte64; PATypes.PA_PAC_VisnAgExtnResp pA_PAC_VisnAgExtnResp; byte[] arrayOfByte63; PATypes.PA_PAC_VisnImgAgWide3DInUse pA_PAC_VisnImgAgWide3DInUse; PATypes.PA_PAC_VisnImgAgWide2DInUse pA_PAC_VisnImgAgWide2DInUse; byte[] arrayOfByte62; PATypes.PA_DspVersion pA_DspVersion; PATypes.PA_ErrorReport pA_ErrorReport; byte[] arrayOfByte61; PATypes.PA_McuLog_Panic pA_McuLog_Panic; byte[] arrayOfByte60; PATypes.PA_VFC_VFC_Reboot pA_VFC_VFC_Reboot; byte[] arrayOfByte59; PATypes.PA_VFC_VFCRsrv1 pA_VFC_VFCRsrv1; PATypes.PA_VFC_ExteriorLightShow pA_VFC_ExteriorLightShow; byte[] arrayOfByte58; PATypes.PA_VFCNavigationInfoSharing pA_VFCNavigationInfoSharing; PATypes.PA_VFCGenChaSettingsForHmiCen pA_VFCGenChaSettingsForHmiCen; byte[] arrayOfByte57; PATypes.PA_VFC_SetVehDvr pA_VFC_SetVehDvr; PATypes.PA_VFC_SetVehTcam pA_VFC_SetVehTcam; byte[] arrayOfByte56; PATypes.PA_VFC_SetVehApa pA_VFC_SetVehApa; byte[] arrayOfByte55; PATypes.PA_VFC_TelephoneManager pA_VFC_TelephoneManager; PATypes.PA_VFC_FaceIdnForHmiCen pA_VFC_FaceIdnForHmiCen; PATypes.PA_VFC_ParkAssiCtrlForHmiCen pA_VFC_ParkAssiCtrlForHmiCen; PATypes.PA_VFC_IPWakeup pA_VFC_IPWakeup; PATypes.PA_VF_HUD_ARD311Data pA_VF_HUD_ARD311Data; PATypes.PA_VF_HUD_ARD310Data pA_VF_HUD_ARD310Data; PATypes.PA_VF_HUD_ARD300Data pA_VF_HUD_ARD300Data; byte[] arrayOfByte54; PATypes.PA_VF_HUD_HudSnowModeReq pA_VF_HUD_HudSnowModeReq; PATypes.PA_VF_HUD_HudRstForSetgAndData pA_VF_HUD_HudRstForSetgAndData; byte[] arrayOfByte53; PATypes.PA_VF_HUD_ErgoAdjmtReq pA_VF_HUD_ErgoAdjmtReq; byte[] arrayOfByte52; PATypes.PA_VF_HUD_ActvSts pA_VF_HUD_ActvSts; PATypes.PA_Device_Supplier_Code pA_Device_Supplier_Code; PATypes.PA_Device_Project_Code pA_Device_Project_Code; PATypes.PA_Device_VPVersion_HD pA_Device_VPVersion_HD; PATypes.PA_Device_SN pA_Device_SN; PATypes.PA_Device_IHUID pA_Device_IHUID; PATypes.PA_VP_Version pA_VP_Version; PATypes.PA_VIN_VinNum pA_VIN_VinNum; PATypes.PA_SAP_PrkgUnlck pA_SAP_PrkgUnlck; byte[] arrayOfByte51; PATypes.PA_LcfgPsdDayVal pA_LcfgPsdDayVal; PATypes.PA_LcfgCsdNightVal pA_LcfgCsdNightVal; byte[] arrayOfByte50; PATypes.PA_LcfgDftBckVal pA_LcfgDftBckVal; byte[] arrayOfByte49; PATypes.PA_t_dim_fast pA_t_dim_fast; byte[] arrayOfByte48; PATypes.PA_DayNightMode pA_DayNightMode; PATypes.PA_BackBrightness pA_BackBrightness; byte[] arrayOfByte47; PATypes.PA_SysSetSpdUnit pA_SysSetSpdUnit; byte[] arrayOfByte46; PATypes.PA_SysSetTempUnit pA_SysSetTempUnit; PATypes.PA_SysSetDateFmt pA_SysSetDateFmt; PATypes.PA_SysSetClkFmt pA_SysSetClkFmt; byte[] arrayOfByte45; PATypes.PA_Power_Res pA_Power_Res; PATypes.PA_DriveMode_Adaptive pA_DriveMode_Adaptive; byte[] arrayOfByte44; PATypes.PA_DriveMode_AirConditioner_Settings pA_DriveMode_AirConditioner_Settings; PATypes.PA_DriveMode_Powertrain_Settings pA_DriveMode_Powertrain_Settings; byte[] arrayOfByte43; PATypes.PA_DriveMode_active_time pA_DriveMode_active_time; PATypes.PA_DriveMode_confirmation_timeout pA_DriveMode_confirmation_timeout; byte[] arrayOfByte42; PATypes.PA_DriveMode_Mud pA_DriveMode_Mud; PATypes.PA_DriveMode_Sand pA_DriveMode_Sand; byte[] arrayOfByte41; PATypes.PA_DriveMode_Power pA_DriveMode_Power; PATypes.PA_DriveMode_Hybrid pA_DriveMode_Hybrid; PATypes.PA_DriveMode_Pure pA_DriveMode_Pure; byte[] arrayOfByte40; PATypes.PA_DriveMode_AWD pA_DriveMode_AWD; byte[] arrayOfByte39; PATypes.PA_DriveMode_Individual pA_DriveMode_Individual; PATypes.PA_DriveMode_Dynamic pA_DriveMode_Dynamic; byte[] arrayOfByte38; PATypes.PA_TCH_CupHoldrOcpyFbSts pA_TCH_CupHoldrOcpyFbSts; PATypes.PA_TCH_CupHoldrAvlSts pA_TCH_CupHoldrAvlSts; byte[] arrayOfByte37; PATypes.PA_Fragra_FragRefrshAutSetg pA_Fragra_FragRefrshAutSetg; byte[] arrayOfByte36; PATypes.PA_Fragra_AirFragCh4RunngSts pA_Fragra_AirFragCh4RunngSts; PATypes.PA_Fragra_AirFragCh3RunngSts pA_Fragra_AirFragCh3RunngSts; byte[] arrayOfByte35; PATypes.PA_Fragra_AirFragCh1RunngSts pA_Fragra_AirFragCh1RunngSts; PATypes.PA_Fragra_Tast5UseUpRmd pA_Fragra_Tast5UseUpRmd; byte[] arrayOfByte34; PATypes.PA_Fragra_Tast3UseUpRmd pA_Fragra_Tast3UseUpRmd; PATypes.PA_Fragra_Tast2UseUpRmd pA_Fragra_Tast2UseUpRmd; PATypes.PA_Fragra_Tast1UseUpRmd pA_Fragra_Tast1UseUpRmd; byte[] arrayOfByte33; PATypes.PA_Fragra_Taste4ID pA_Fragra_Taste4ID; PATypes.PA_Fragra_Taste3ID pA_Fragra_Taste3ID; byte[] arrayOfByte32; PATypes.PA_Fragra_ModReqSts pA_Fragra_ModReqSts; byte[] arrayOfByte31; PATypes.PA_Fragra_TypRatReqFSts pA_Fragra_TypRatReqFSts; byte[] arrayOfByte30; PATypes.PA_Fragra_TypRatReqDSts pA_Fragra_TypRatReqDSts; byte[] arrayOfByte29; PATypes.PA_Fragra_TypRatReqBSts pA_Fragra_TypRatReqBSts; PATypes.PA_Fragra_TypRatReqASts pA_Fragra_TypRatReqASts; byte[] arrayOfByte28; PATypes.PA_PM25_OutdPm25Sts pA_PM25_OutdPm25Sts; byte[] arrayOfByte27; PATypes.PA_PM25_IntrPm25HiWarn pA_PM25_IntrPm25HiWarn; byte[] arrayOfByte26; PATypes.PA_PM25_IntPm25Vlu pA_PM25_IntPm25Vlu; PATypes.PA_PM25_Actvn pA_PM25_Actvn; PATypes.PA_IAQC_ActnSts pA_IAQC_ActnSts; byte[] arrayOfByte25; PATypes.PA_SWH_ManualLvlSts pA_SWH_ManualLvlSts; PATypes.PA_SWH_AutoReqSts pA_SWH_AutoReqSts; byte[] arrayOfByte24; PATypes.PA_SCV_FirstRiAvlSts pA_SCV_FirstRiAvlSts; PATypes.PA_SCV_FirstLeAvlSts pA_SCV_FirstLeAvlSts; PATypes.PA_SCV_FirstRiTmrSts pA_SCV_FirstRiTmrSts; PATypes.PA_SCV_FirstLeTmrSts pA_SCV_FirstLeTmrSts; byte[] arrayOfByte23; PATypes.PA_SCV_FirstActvn pA_SCV_FirstActvn; byte[] arrayOfByte22; PATypes.PA_SCH_SecLeAvlSts pA_SCH_SecLeAvlSts; byte[] arrayOfByte21; PATypes.PA_SCH_SecRiTmrSts pA_SCH_SecRiTmrSts; byte[] arrayOfByte20; PATypes.PA_SCH_FirstLeTmrSts pA_SCH_FirstLeTmrSts; PATypes.PA_SCH_SecRiLvlSts pA_SCH_SecRiLvlSts; byte[] arrayOfByte19; PATypes.PA_SCH_FirstRiLvlSts pA_SCH_FirstRiLvlSts; PATypes.PA_SCH_FirstLeLvlSts pA_SCH_FirstLeLvlSts; byte[] arrayOfByte18; PATypes.PA_CL_InteCleanUnpleSmell pA_CL_InteCleanUnpleSmell; PATypes.PA_CL_ElecDefRunErr pA_CL_ElecDefRunErr; byte[] arrayOfByte17; PATypes.PA_CL_PassElecAir pA_CL_PassElecAir; PATypes.PA_CL_DrvElecAir pA_CL_DrvElecAir; PATypes.PA_CL_GClean pA_CL_GClean; byte[] arrayOfByte16; PATypes.PA_CL_SecLockClimaSw pA_CL_SecLockClimaSw; PATypes.PA_CL_TWinRfClsdPopSw pA_CL_TWinRfClsdPopSw; byte[] arrayOfByte15; PATypes.PA_CL_PassSwt pA_CL_PassSwt; PATypes.PA_CL_DrvSwt pA_CL_DrvSwt; PATypes.PA_CL_ClmCloseWinPop pA_CL_ClmCloseWinPop; PATypes.PA_CL_WipReSrvMod pA_CL_WipReSrvMod; byte[] arrayOfByte14; PATypes.PA_CL_HumPop pA_CL_HumPop; PATypes.PA_CL_HumCtrl pA_CL_HumCtrl; byte[] arrayOfByte13; PATypes.PA_CL_SecRowOnOffSwith pA_CL_SecRowOnOffSwith; byte[] arrayOfByte12; PATypes.PA_CL_FrntDefrostPopup pA_CL_FrntDefrostPopup; PATypes.PA_CL_AutoDefrostPopup pA_CL_AutoDefrostPopup; byte[] arrayOfByte11; PATypes.PA_CL_SecRightTemp pA_CL_SecRightTemp; byte[] arrayOfByte10; PATypes.PA_CL_AirCtrlOff pA_CL_AirCtrlOff; byte[] arrayOfByte9; PATypes.PA_CL_ECOClimate pA_CL_ECOClimate; PATypes.PA_CL_Sync pA_CL_Sync; byte[] arrayOfByte8; PATypes.PA_CL_FrontDefrost pA_CL_FrontDefrost; PATypes.PA_WDC_AutoRearDefrost pA_WDC_AutoRearDefrost; PATypes.PA_WDC_AutoFrontDefrost pA_WDC_AutoFrontDefrost; PATypes.PA_CL_MaxDefrost pA_CL_MaxDefrost; PATypes.PA_CL_AutoSetting pA_CL_AutoSetting; byte[] arrayOfByte7; PATypes.PA_CL_RightTemp pA_CL_RightTemp; PATypes.PA_CL_LeftTemp pA_CL_LeftTemp; PATypes.PA_CL_FanLevel pA_CL_FanLevel; byte[] arrayOfByte6; PATypes.PA_CL_Recirc pA_CL_Recirc; byte[] arrayOfByte5; PATypes.PA_Asy_LKA_Warning_Mode pA_Asy_LKA_Warning_Mode; PATypes.PA_Asy_LKA_Mode pA_Asy_LKA_Mode; byte[] arrayOfByte4; PATypes.PA_Asy_CMS_Warning pA_Asy_CMS_Warning; PATypes.PA_Asy_CMS pA_Asy_CMS; byte[] arrayOfByte3; PATypes.PA_Asy_ELOW pA_Asy_ELOW; byte[] arrayOfByte2; PATypes.PA_Asy_TLA pA_Asy_TLA; byte[] arrayOfByte1; PATypes.PA_Asy_TSR_Warning pA_Asy_TSR_Warning; PATypes.PA_Asy_OtherTSR pA_Asy_OtherTSR; PATypes.PA_Asy_TSR pA_Asy_TSR; PATypes.PA_Asy_HWA pA_Asy_HWA; PATypes.PA_VehMdlClrReq pA_VehMdlClrReq; PATypes.PA_TurnEntryAgWideVisReq pA_TurnEntryAgWideVisReq; byte[] arrayOfByte332; PATypes.PA_FaceIdnReq pA_FaceIdnReq; PATypes.PA_CnclFaceReqForProf pA_CnclFaceReqForProf; byte[] arrayOfByte331; PATypes.PA_SCEMOD_SceneModSeldQuitStranger pA_SCEMOD_SceneModSeldQuitStranger; byte[] arrayOfByte330; PATypes.PA_FD_FaceIdnReq pA_FD_FaceIdnReq; byte[] arrayOfByte329; PATypes.PA_SCEMOD_PassSceneModSeldValue pA_SCEMOD_PassSceneModSeldValue; PATypes.PA_SCEMOD_SceneModSeldGoddess pA_SCEMOD_SceneModSeldGoddess; PATypes.PA_SCEMOD_SceneModSeldValue pA_SCEMOD_SceneModSeldValue; byte[] arrayOfByte328; PATypes.PA_SCEMOD_SceneModSeldSecondRightRest pA_SCEMOD_SceneModSeldSecondRightRest; byte[] arrayOfByte327; PATypes.PA_SCEMOD_SceneModSeldDriverRest pA_SCEMOD_SceneModSeldDriverRest; PATypes.PA_SCEMOD_SceneModSeldChild pA_SCEMOD_SceneModSeldChild; PATypes.PA_SCEMOD_SceneModSeldBiochal pA_SCEMOD_SceneModSeldBiochal; PATypes.PA_SCEMOD_SceneModSeldStranger pA_SCEMOD_SceneModSeldStranger; PATypes.PA_SCEMOD_SceneModSeldCarWash pA_SCEMOD_SceneModSeldCarWash; byte[] arrayOfByte326; PATypes.PA_TS_CurTripDis pA_TS_CurTripDis; PATypes.PA_NAVI_VehEgyCoornFctStChg pA_NAVI_VehEgyCoornFctStChg; PATypes.PA_NAVI_VehEgyCoornOpenAndCls pA_NAVI_VehEgyCoornOpenAndCls; byte[] arrayOfByte325; PATypes.PA_AmbLi_MsgEnd pA_AmbLi_MsgEnd; byte[] arrayOfByte324; PATypes.PA_VM_MsgEnd pA_VM_MsgEnd; byte[] arrayOfByte323; PATypes.PA_VehCharg_MsgEnd pA_VehCharg_MsgEnd; byte[] arrayOfByte322; PATypes.PA_VFC_MsgEnd pA_VFC_MsgEnd; byte[] arrayOfByte321; PATypes.PA_Device_MsgEnd pA_Device_MsgEnd; PATypes.PA_SS_MsgEnd pA_SS_MsgEnd; byte[] arrayOfByte320; PATypes.PA_DriveMode_MsgEnd pA_DriveMode_MsgEnd; PATypes.PA_TCH_MsgEnd pA_TCH_MsgEnd; PATypes.PA_Fragra_MsgEnd pA_Fragra_MsgEnd; PATypes.PA_SWH_MsgEnd pA_SWH_MsgEnd; byte[] arrayOfByte319; PATypes.PA_DID_MsgEnd pA_DID_MsgEnd; PATypes.PA_DiagProxy_MsgEnd pA_DiagProxy_MsgEnd; byte[] arrayOfByte318; PATypes.PA_PSET_ProfilesInuse pA_PSET_ProfilesInuse; PATypes.PA_PSET_ProfileDownloadStatus pA_PSET_ProfileDownloadStatus; byte[] arrayOfByte317; PATypes.PA_PSET_SeatLocationAdjust pA_PSET_SeatLocationAdjust; byte[] arrayOfByte316; PATypes.PA_PSET_User6 pA_PSET_User6; PATypes.PA_PSET_User5 pA_PSET_User5; PATypes.PA_PSET_User4 pA_PSET_User4; PATypes.PA_PSET_User3 pA_PSET_User3; byte[] arrayOfByte315; PATypes.PA_PSET_User1 pA_PSET_User1; PATypes.PA_PSET_SimplUnlockCurrent pA_PSET_SimplUnlockCurrent; byte[] arrayOfByte314; PATypes.PA_PSET_NFCID pA_PSET_NFCID; PATypes.PA_PSET_LYNKID_Result pA_PSET_LYNKID_Result; PATypes.PA_PSET_LYNKID pA_PSET_LYNKID; byte[] arrayOfByte313; PATypes.PA_PSET_MaxNrProfReached pA_PSET_MaxNrProfReached; byte[] arrayOfByte312; PATypes.PA_PSET_Key_Result pA_PSET_Key_Result; PATypes.PA_PSET_FactoryDefaultResult pA_PSET_FactoryDefaultResult; PATypes.PA_PSET_FactoryDefault pA_PSET_FactoryDefault; byte[] arrayOfByte311; PATypes.PA_PSET_ProfileFactoryDefault pA_PSET_ProfileFactoryDefault; PATypes.PA_PSET_LogOut pA_PSET_LogOut; byte[] arrayOfByte310; PATypes.PA_PSET_NewProfile pA_PSET_NewProfile; PATypes.PA_PSET_ActiveProfile pA_PSET_ActiveProfile; byte[] arrayOfByte309; PATypes.PA_ChdLockReRight_ChdMod pA_ChdLockReRight_ChdMod; byte[] arrayOfByte308; PATypes.PA_ChdLockReLeft pA_ChdLockReLeft; PATypes.PA_WinPosnStsAtReRi pA_WinPosnStsAtReRi; byte[] arrayOfByte307; PATypes.PA_WinOpenReLeReq pA_WinOpenReLeReq; byte[] arrayOfByte306; PATypes.PA_WinOpenDrvrReq pA_WinOpenDrvrReq; byte[] arrayOfByte305; PATypes.PA_AmbLiRadarCorrlnReq pA_AmbLiRadarCorrlnReq; byte[] arrayOfByte304; PATypes.PA_ReadLightAllOnSwitch pA_ReadLightAllOnSwitch; byte[] arrayOfByte303; PATypes.PA_ReadLightThirdRowRight pA_ReadLightThirdRowRight; byte[] arrayOfByte302; PATypes.PA_ReadLightSecondRowRight pA_ReadLightSecondRowRight; PATypes.PA_ReadLightSecondRowLeft pA_ReadLightSecondRowLeft; byte[] arrayOfByte301; PATypes.PA_AmbLiMilgOpenReq pA_AmbLiMilgOpenReq; byte[] arrayOfByte300; PATypes.PA_Zone3IntensitySettings pA_Zone3IntensitySettings; byte[] arrayOfByte299; PATypes.PA_Zone2ColorSettings pA_Zone2ColorSettings; PATypes.PA_Zone2IntensitySettings pA_Zone2IntensitySettings; byte[] arrayOfByte298; PATypes.PA_Zone1ColorSettings pA_Zone1ColorSettings; byte[] arrayOfByte297; PATypes.PA_ZoneAllColorSettings pA_ZoneAllColorSettings; byte[] arrayOfByte296; PATypes.PA_TransitionColor2Settings pA_TransitionColor2Settings; byte[] arrayOfByte295; PATypes.PA_CustomEffect pA_CustomEffect; PATypes.PA_AmbLiMod_WeatherIndn pA_AmbLiMod_WeatherIndn; byte[] arrayOfByte294; PATypes.PA_AmbLiMod_CustomizedMode pA_AmbLiMod_CustomizedMode; PATypes.PA_AmbLiMod_None pA_AmbLiMod_None; byte[] arrayOfByte293; PATypes.PA_AmbLiAll pA_AmbLiAll; PATypes.PA_HmiCarLocatorSetReq pA_HmiCarLocatorSetReq; PATypes.PA_SunRoofTiltReq pA_SunRoofTiltReq; byte[] arrayOfByte292; PATypes.PA_SunRoofOpenPosnReq pA_SunRoofOpenPosnReq; byte[] arrayOfByte291; PATypes.PA_OpenSunRoof_Btn pA_OpenSunRoof_Btn; byte[] arrayOfByte290; PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb pA_VehCharg_ChrgnOrDisChrgnStsFb; PATypes.PA_VehCharg_HvBattChrgnTiEstimd pA_VehCharg_HvBattChrgnTiEstimd; PATypes.PA_VehCharg_OnBdChrgrIAct pA_VehCharg_OnBdChrgrIAct; PATypes.PA_VehCharg_OnBdChrgrUAct pA_VehCharg_OnBdChrgrUAct; byte[] arrayOfByte289; PATypes.PA_VehCharg_HvBattDchaTiEstimd pA_VehCharg_HvBattDchaTiEstimd; byte[] arrayOfByte288; PATypes.PA_VehCharg_DisChargeRecord pA_VehCharg_DisChargeRecord; byte[] arrayOfByte287; PATypes.PA_VehCharg_DisChargInfoShow pA_VehCharg_DisChargInfoShow; PATypes.PA_VehCharg_DisChargSOC pA_VehCharg_DisChargSOC; byte[] arrayOfByte286; PATypes.PA_VehCharg_ChargInfoShow pA_VehCharg_ChargInfoShow; PATypes.PA_VehCharg_ChargSt pA_VehCharg_ChargSt; byte[] arrayOfByte285; PATypes.PA_TS_energyReStats100 pA_TS_energyReStats100; byte[] arrayOfByte284; PATypes.PA_TS_fuelStats100 pA_TS_fuelStats100; PATypes.PA_TS_fuelStats10 pA_TS_fuelStats10; PATypes.PA_TS_TripAverageEnConsumption5Km pA_TS_TripAverageEnConsumption5Km; PATypes.PA_TS_TripAverageEnConsumption05Km pA_TS_TripAverageEnConsumption05Km; byte[] arrayOfByte283; PATypes.PA_TS_TripAverageConsumption05Km pA_TS_TripAverageConsumption05Km; PATypes.PA_TS_OdometerTripMeter2 pA_TS_OdometerTripMeter2; byte[] arrayOfByte282; PATypes.PA_TS_DTEHVBattIndicated pA_TS_DTEHVBattIndicated; byte[] arrayOfByte281; PATypes.PA_AuthorityMicrophoneSwitch pA_AuthorityMicrophoneSwitch; byte[] arrayOfByte280; PATypes.PA_AuthorityLocationSwitch pA_AuthorityLocationSwitch; PATypes.PA_FD92 pA_FD92; PATypes.PA_FD91 pA_FD91; byte[] arrayOfByte279; PATypes.PA_FD88 pA_FD88; PATypes.PA_FD39 pA_FD39; byte[] arrayOfByte278; PATypes.PA_FD27 pA_FD27; PATypes.PA_FD26 pA_FD26; PATypes.PA_CSDM_PSD_EN pA_CSDM_PSD_EN; byte[] arrayOfByte277; PATypes.PA_Dcm_D912_PSD_MONITOR_EN pA_Dcm_D912_PSD_MONITOR_EN; PATypes.PA_Chat_Video_IN pA_Chat_Video_IN; byte[] arrayOfByte276; PATypes.PA_DVR_Video_IN pA_DVR_Video_IN; PATypes.PA_PASWAM_Video_in pA_PASWAM_Video_in; byte[] arrayOfByte275; PATypes.PA_HealthOfEngOil pA_HealthOfEngOil; PATypes.PA_NatUsgDayOfOil pA_NatUsgDayOfOil; byte[] arrayOfByte274; PATypes.PA_Locking_ApproachToOpenTrSwt pA_Locking_ApproachToOpenTrSwt; byte[] arrayOfByte273; PATypes.PA_RearMirrors pA_RearMirrors; PATypes.PA_UnlckTrunk pA_UnlckTrunk; PATypes.PA_LifeDetectionSwitch pA_LifeDetectionSwitch; PATypes.PA_PowerFlow_HEV pA_PowerFlow_HEV; PATypes.PA_IntelligentFuSave pA_IntelligentFuSave; byte[] arrayOfByte272; PATypes.PA_TripCom_RstEDT pA_TripCom_RstEDT; byte[] arrayOfByte271; PATypes.PA_TripCom_RstTrip pA_TripCom_RstTrip; PATypes.PA_TripCom_RetALL pA_TripCom_RetALL; byte[] arrayOfByte270; PATypes.PA_VINDiffMsg pA_VINDiffMsg; byte[] arrayOfByte269; PATypes.PA_SourceSwitch pA_SourceSwitch; byte[] arrayOfByte268; PATypes.PA_360Panorama pA_360Panorama; byte[] arrayOfByte267; PATypes.PA_ScreenSwitch pA_ScreenSwitch; byte[] arrayOfByte266; PATypes.PA_TailgateSts pA_TailgateSts; PATypes.PA_ElectricTailgate_PosSetting pA_ElectricTailgate_PosSetting; PATypes.PA_ElectricTailgate_OpenBtn pA_ElectricTailgate_OpenBtn; byte[] arrayOfByte265; PATypes.PA_Battery_Charge_Percent pA_Battery_Charge_Percent; PATypes.PA_PM_Charge pA_PM_Charge; PATypes.PA_PM_Hold pA_PM_Hold; PATypes.PA_ElecSeatbelt_Passenger pA_ElecSeatbelt_Passenger; PATypes.PA_ElecSeatbelt_Driver pA_ElecSeatbelt_Driver; byte[] arrayOfByte264; PATypes.PA_Individualtheme_OnOff pA_Individualtheme_OnOff; byte[] arrayOfByte263; PATypes.PA_TwoStepUnlck_Setting pA_TwoStepUnlck_Setting; byte[] arrayOfByte262; PATypes.PA_SailingSwitch pA_SailingSwitch; PATypes.PA_SpeedWarnSpeedLimit pA_SpeedWarnSpeedLimit; PATypes.PA_SpeedWarnOnOff pA_SpeedWarnOnOff; PATypes.PA_LowAlarmVolSet pA_LowAlarmVolSet; PATypes.PA_SpeedWarnSet pA_SpeedWarnSet; byte[] arrayOfByte261; PATypes.PA_Total_Traveled_Distance pA_Total_Traveled_Distance; byte[] arrayOfByte260; PATypes.PA_EPBAutoApply pA_EPBAutoApply; PATypes.PA_SuspMoveDirInform pA_SuspMoveDirInform; byte[] arrayOfByte259; PATypes.PA_DeacLevCtrSetting pA_DeacLevCtrSetting; byte[] arrayOfByte258; PATypes.PA_HillDescentSetting pA_HillDescentSetting; byte[] arrayOfByte257; PATypes.PA_RearMirrorFold_Auto pA_RearMirrorFold_Auto; PATypes.PA_WelGoodbyeLightMod pA_WelGoodbyeLightMod; PATypes.PA_WelGoodbyeLightSwitch pA_WelGoodbyeLightSwitch; PATypes.PA_LeftRightSetting pA_LeftRightSetting; byte[] arrayOfByte256; PATypes.PA_AFSLight_Setting pA_AFSLight_Setting; byte[] arrayOfByte255; PATypes.PA_SS_Activation pA_SS_Activation; byte[] arrayOfByte254; PATypes.PA_FindCaReminder_Setting pA_FindCaReminder_Setting; PATypes.PA_UUN_RedGuardSts pA_UUN_RedGuardSts; PATypes.PA_UUN_PasArmngSts pA_UUN_PasArmngSts; PATypes.PA_WPC_PhoneForget pA_WPC_PhoneForget; byte[] arrayOfByte253; PATypes.PA_WPC_Setting pA_WPC_Setting; byte[] arrayOfByte252; PATypes.PA_HotStoneMassagePassAllowd pA_HotStoneMassagePassAllowd; byte[] arrayOfByte251; PATypes.PA_SecRowSeatInclRiFwdBackwAllowd pA_SecRowSeatInclRiFwdBackwAllowd; byte[] arrayOfByte250; PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts pA_SeatRowSecRiSwtStsPassSeatSwtSldSts; byte[] arrayOfByte249; PATypes.PA_SecRowSeatLenLeFwdBackwAllowd pA_SecRowSeatLenLeFwdBackwAllowd; PATypes.PA_SeatFoldRaiseRowThrdRiAllowd pA_SeatFoldRaiseRowThrdRiAllowd; PATypes.PA_SeatFoldRaiseRowThrdLeAllowd pA_SeatFoldRaiseRowThrdLeAllowd; PATypes.PA_PassMultFuncMenuExt pA_PassMultFuncMenuExt; byte[] arrayOfByte248; PATypes.PA_PassMassgRunng pA_PassMassgRunng; PATypes.PA_DrvrMassgRunng pA_DrvrMassgRunng; byte[] arrayOfByte247; PATypes.PA_PassSeatDispMassgFct_MassgProg pA_PassSeatDispMassgFct_MassgProg; PATypes.PA_PassSeatDispMassgFct_OnOff pA_PassSeatDispMassgFct_OnOff; byte[] arrayOfByte246; PATypes.PA_DrvrSeatMassageStsAllowd pA_DrvrSeatMassageStsAllowd; PATypes.PA_PassSeatCushExtStsAllowd pA_PassSeatCushExtStsAllowd; PATypes.PA_DrvrSeatCushExtStsAllowd pA_DrvrSeatCushExtStsAllowd; byte[] arrayOfByte245; PATypes.PA_PassSeatSideFwdBackwStsAllowd pA_PassSeatSideFwdBackwStsAllowd; PATypes.PA_DrvrSeatSideFwdBackwStsAllowd pA_DrvrSeatSideFwdBackwStsAllowd; PATypes.PA_PassSeatLmbrUpDownStsAllowd pA_PassSeatLmbrUpDownStsAllowd; PATypes.PA_PassSeatLmbrFwdBackwStsAllowd pA_PassSeatLmbrFwdBackwStsAllowd; byte[] arrayOfByte244; PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd pA_DrvrSeatLmbrFwdBackwStsAllowd; PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts pA_PassSeatSwtAdjmtOfSpplFctHozlSts; byte[] arrayOfByte243; PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts; PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts pA_DrvrSeatSwtAdjmtOfSpplFctVertSts; PATypes.PA_PassSeatActvSpplFct pA_PassSeatActvSpplFct; byte[] arrayOfByte242; PATypes.PA_PassSeatSwtInclStsAllowd pA_PassSeatSwtInclStsAllowd; PATypes.PA_DrvrSeatSwtInclSts pA_DrvrSeatSwtInclSts; PATypes.PA_DrvrSeatSwtInclStsAllowd pA_DrvrSeatSwtInclStsAllowd; PATypes.PA_PassSeatSwtHeiFrntSts pA_PassSeatSwtHeiFrntSts; byte[] arrayOfByte241; PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd pA_DrvrSeatSwtHeiFrntStsAllowd; byte[] arrayOfByte240; PATypes.PA_DrvrSeatSwtHeiSts pA_DrvrSeatSwtHeiSts; byte[] arrayOfByte239; PATypes.PA_PassSeatSwtSldSts pA_PassSeatSwtSldSts; byte[] arrayOfByte238; PATypes.PA_DrvrSeatExtAdjAllowd pA_DrvrSeatExtAdjAllowd; PATypes.PA_PAS_SnsrFltStsWarn pA_PAS_SnsrFltStsWarn; byte[] arrayOfByte237; PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt pA_PAS_AudWarnOfSnsrParkAssiFrnt; PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe pA_PAS_AudWarnOfSnsrParkAssiRe; PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt pA_PAS_OutdRiOfSnsrPrkgAssiFrnt; byte[] arrayOfByte236; PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt pA_PAS_InsdRiOfSnsrPrkgAssiFrnt; byte[] arrayOfByte235; PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe pA_PAS_OutdRiOfSnsrPrkgAssiRe; PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe pA_PAS_OutdLeOfSnsrPrkgAssiRe; PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe pA_PAS_InsdRiOfSnsrPrkgAssiRe; byte[] arrayOfByte234; PATypes.PA_SAP_PrkgProgsDisp pA_SAP_PrkgProgsDisp; PATypes.PA_SAP_DrvrAsscSysDisp pA_SAP_DrvrAsscSysDisp; PATypes.PA_SAP_DrvrAsscSysSts pA_SAP_DrvrAsscSysSts; byte[] arrayOfByte233; PATypes.PA_PAC_RctaIndcnRe pA_PAC_RctaIndcnRe; PATypes.PA_PAC_RctaIndcnLe pA_PAC_RctaIndcnLe; byte[] arrayOfByte232; PATypes.PA_PAC_RoadCalForVisnAgWideResp pA_PAC_RoadCalForVisnAgWideResp; PATypes.PA_PAC_VehMdlClrResp pA_PAC_VehMdlClrResp; byte[] arrayOfByte231; PATypes.PA_PAC_ThrDObjDethResp pA_PAC_ThrDObjDethResp; PATypes.PA_PAC_PedDetnResp pA_PAC_PedDetnResp; byte[] arrayOfByte230; PATypes.PA_PAC_PrkgIndcrLineResp pA_PAC_PrkgIndcrLineResp; byte[] arrayOfByte229; PATypes.PA_PAC_TxStrtVisReq pA_PAC_TxStrtVisReq; PATypes.PA_PAC_SwtDispOnAndOffStsResp pA_PAC_SwtDispOnAndOffStsResp; byte[] arrayOfByte228; PATypes.PA_AR_WarningVlo pA_AR_WarningVlo; PATypes.PA_VFC_SetVehSceneMode pA_VFC_SetVehSceneMode; PATypes.PA_VFC_SceneModePDC pA_VFC_SceneModePDC; byte[] arrayOfByte227; PATypes.PA_VFC_SetVehFace pA_VFC_SetVehFace; PATypes.PA_VFC_VFCRsrv5 pA_VFC_VFCRsrv5; PATypes.PA_VFC_VFCRsrv4 pA_VFC_VFCRsrv4; PATypes.PA_VFC_VFCRsrv3 pA_VFC_VFCRsrv3; PATypes.PA_VFC_VFCRsrv2 pA_VFC_VFCRsrv2; byte[] arrayOfByte226; PATypes.PA_VFC_ExteriorLightShowWin pA_VFC_ExteriorLightShowWin; byte[] arrayOfByte225; PATypes.PA_VFCSetVehCharging pA_VFCSetVehCharging; byte[] arrayOfByte224; PATypes.PA_VFC_SetVehAvm pA_VFC_SetVehAvm; byte[] arrayOfByte223; PATypes.PA_VFC_SetVehPrivateLock pA_VFC_SetVehPrivateLock; PATypes.PA_VFC_SetVehCenClkIndcnAndSetg pA_VFC_SetVehCenClkIndcnAndSetg; byte[] arrayOfByte222; PATypes.PA_VF_HUD_ARActvSts pA_VF_HUD_ARActvSts; byte[] arrayOfByte221; PATypes.PA_VF_HUD_ImgRotAdjmtReq pA_VF_HUD_ImgRotAdjmtReq; byte[] arrayOfByte220; PATypes.PA_VF_HUD_IllmnReq pA_VF_HUD_IllmnReq; byte[] arrayOfByte219; PATypes.PA_PowerSoftKeyBrightness pA_PowerSoftKeyBrightness; PATypes.PA_PowerSoftKeySwitch pA_PowerSoftKeySwitch; PATypes.PA_LinkSwitch pA_LinkSwitch; PATypes.PA_LcfgPsdNightVal pA_LcfgPsdNightVal; byte[] arrayOfByte218; PATypes.PA_LcfgCsdDayVal pA_LcfgCsdDayVal; byte[] arrayOfByte217; PATypes.PA_t_dim_rheo pA_t_dim_rheo; PATypes.PA_t_dim_slow pA_t_dim_slow; byte[] arrayOfByte216; PATypes.PA_PSDBrightness pA_PSDBrightness; PATypes.PA_CSDBrightness pA_CSDBrightness; byte[] arrayOfByte215; PATypes.PA_SysSetPUnit pA_SysSetPUnit; PATypes.PA_SysSetDstLong pA_SysSetDstLong; PATypes.PA_SysSetVolUnit pA_SysSetVolUnit; byte[] arrayOfByte214; PATypes.PA_SysSetFuCnsUnit pA_SysSetFuCnsUnit; byte[] arrayOfByte213; PATypes.PA_SysSetOfLang pA_SysSetOfLang; byte[] arrayOfByte212; PATypes.PA_DriveMode_Animation pA_DriveMode_Animation; PATypes.PA_DriveMode_Value pA_DriveMode_Value; PATypes.PA_DriveMode_Suspension_Settings pA_DriveMode_Suspension_Settings; PATypes.PA_DriveMode_Engine_StartStop pA_DriveMode_Engine_StartStop; PATypes.PA_DriveMode_DIMTheme_Settings pA_DriveMode_DIMTheme_Settings; PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings pA_DriveMode_SteeringWheelAssistLevel_Settings; byte[] arrayOfByte211; PATypes.PA_DriveMode_Brake_Settings pA_DriveMode_Brake_Settings; PATypes.PA_DriveMode_Individual_Settings pA_DriveMode_Individual_Settings; byte[] arrayOfByte210; PATypes.PA_DriveMode_Rock pA_DriveMode_Rock; byte[] arrayOfByte209; PATypes.PA_DriveMode_Snow pA_DriveMode_Snow; byte[] arrayOfByte208; PATypes.PA_DriveMode_Save pA_DriveMode_Save; byte[] arrayOfByte207; PATypes.PA_DriveMode_XC pA_DriveMode_XC; byte[] arrayOfByte206; PATypes.PA_DriveMode_Comfort pA_DriveMode_Comfort; PATypes.PA_DriveMode_Eco pA_DriveMode_Eco; byte[] arrayOfByte205; PATypes.PA_TCH_CupHoldrVoltgErr pA_TCH_CupHoldrVoltgErr; PATypes.PA_TCH_CupHoldrActvAllwd pA_TCH_CupHoldrActvAllwd; PATypes.PA_TCH_CupHoldrStsFd pA_TCH_CupHoldrStsFd; byte[] arrayOfByte204; PATypes.PA_Fragra_AirFragCh5RunngSts pA_Fragra_AirFragCh5RunngSts; byte[] arrayOfByte203; PATypes.PA_Fragra_AirFragCh2RunngSts pA_Fragra_AirFragCh2RunngSts; byte[] arrayOfByte202; PATypes.PA_Fragra_Tast4UseUpRmd pA_Fragra_Tast4UseUpRmd; byte[] arrayOfByte201; PATypes.PA_Fragra_Taste5ID pA_Fragra_Taste5ID; byte[] arrayOfByte200; PATypes.PA_Fragra_Taste2ID pA_Fragra_Taste2ID; PATypes.PA_Fragra_Taste1ID pA_Fragra_Taste1ID; PATypes.PA_Fragra_RefrshReq pA_Fragra_RefrshReq; PATypes.PA_Fragra_Sts pA_Fragra_Sts; PATypes.PA_Fragra_SceneSetSts pA_Fragra_SceneSetSts; byte[] arrayOfByte199; PATypes.PA_Fragra_LvlReqSts pA_Fragra_LvlReqSts; byte[] arrayOfByte198; PATypes.PA_Fragra_TypRatReqESts pA_Fragra_TypRatReqESts; byte[] arrayOfByte197; PATypes.PA_Fragra_TypRatReqCSts pA_Fragra_TypRatReqCSts; byte[] arrayOfByte196; PATypes.PA_Fragra_Actn pA_Fragra_Actn; PATypes.PA_PM25_IncomingAirQlyPopUpReq pA_PM25_IncomingAirQlyPopUpReq; byte[] arrayOfByte195; PATypes.PA_PM25_IntPm25Sts pA_PM25_IntPm25Sts; byte[] arrayOfByte194; PATypes.PA_PM25_OutdPm25Lvl pA_PM25_OutdPm25Lvl; PATypes.PA_PM25_IntPm25Lvl pA_PM25_IntPm25Lvl; PATypes.PA_PM25_OutdPm25Vlu pA_PM25_OutdPm25Vlu; byte[] arrayOfByte193; PATypes.PA_SWH_AvlSts pA_SWH_AvlSts; byte[] arrayOfByte192; PATypes.PA_SWH_Actvn pA_SWH_Actvn; byte[] arrayOfByte191; PATypes.PA_SCV_FirstRiLvlSts pA_SCV_FirstRiLvlSts; PATypes.PA_SCV_FirstLeLvlSts pA_SCV_FirstLeLvlSts; byte[] arrayOfByte190; PATypes.PA_SCH_SecRiAvlSts pA_SCH_SecRiAvlSts; byte[] arrayOfByte189; PATypes.PA_SCH_FirstRiAvlSts pA_SCH_FirstRiAvlSts; PATypes.PA_SCH_FirstLeAvlSts pA_SCH_FirstLeAvlSts; byte[] arrayOfByte188; PATypes.PA_SCH_SecLeTmrSts pA_SCH_SecLeTmrSts; PATypes.PA_SCH_FirstRiTmrSts pA_SCH_FirstRiTmrSts; byte[] arrayOfByte187; PATypes.PA_SCH_SecLeLvlSts pA_SCH_SecLeLvlSts; byte[] arrayOfByte186; PATypes.PA_SCH_SecActvn pA_SCH_SecActvn; PATypes.PA_SCH_FirstActvn pA_SCH_FirstActvn; PATypes.PA_CL_ModeFrstLeft_ByHardKey pA_CL_ModeFrstLeft_ByHardKey; PATypes.PA_CL_LeftTemp_ByHardKey pA_CL_LeftTemp_ByHardKey; PATypes.PA_CL_FanLevel_ByHardKey pA_CL_FanLevel_ByHardKey; byte[] arrayOfByte185; PATypes.PA_CL_CCSMPopUp pA_CL_CCSMPopUp; byte[] arrayOfByte184; PATypes.PA_CL_SecAutoSw pA_CL_SecAutoSw; byte[] arrayOfByte183; PATypes.PA_CL_ElecAirAvlStsPop pA_CL_ElecAirAvlStsPop; byte[] arrayOfByte182; PATypes.PA_CL_WipFrntSrvMod pA_CL_WipFrntSrvMod; PATypes.PA_CL_WipReAutReq pA_CL_WipReAutReq; PATypes.PA_CL_IntelliClimaPop pA_CL_IntelliClimaPop; byte[] arrayOfByte181; PATypes.PA_CL_PostClimaWarn pA_CL_PostClimaWarn; byte[] arrayOfByte180; PATypes.PA_CL_RearDefrostPopup pA_CL_RearDefrostPopup; byte[] arrayOfByte179; PATypes.PA_CL_AutoDefrostSetting pA_CL_AutoDefrostSetting; PATypes.PA_CL_SecFanLevel pA_CL_SecFanLevel; byte[] arrayOfByte178; PATypes.PA_CL_SecLeftTemp pA_CL_SecLeftTemp; PATypes.PA_CL_HvacReCtr pA_CL_HvacReCtr; byte[] arrayOfByte177; PATypes.PA_CL_Post pA_CL_Post; PATypes.PA_CL_Pre pA_CL_Pre; byte[] arrayOfByte176; PATypes.PA_CL_RearDefrost pA_CL_RearDefrost; byte[] arrayOfByte175; PATypes.PA_CL_RecircSetting pA_CL_RecircSetting; byte[] arrayOfByte174; PATypes.PA_CL_MaxAC pA_CL_MaxAC; PATypes.PA_CL_ModeSec pA_CL_ModeSec; PATypes.PA_CL_ModeFrstRight pA_CL_ModeFrstRight; PATypes.PA_CL_ModeFrstLeft pA_CL_ModeFrstLeft; byte[] arrayOfByte173; PATypes.PA_CL_Auto pA_CL_Auto; PATypes.PA_CL_AC pA_CL_AC; PATypes.PA_Asy_EMA pA_Asy_EMA; PATypes.PA_Asy_ELKA pA_Asy_ELKA; byte[] arrayOfByte172; PATypes.PA_Asy_LKA pA_Asy_LKA; PATypes.PA_Asy_DOW pA_Asy_DOW; PATypes.PA_Asy_RCTA pA_Asy_RCTA; PATypes.PA_Asy_RCW pA_Asy_RCW; PATypes.PA_Asy_LCA_Warning pA_Asy_LCA_Warning; PATypes.PA_Asy_LCA pA_Asy_LCA; byte[] arrayOfByte171; PATypes.PA_Asy_DPS_Reminder pA_Asy_DPS_Reminder; PATypes.PA_Asy_DPS pA_Asy_DPS;
/*      */       byte[] arrayOfByte170;
/*      */       PATypes.PA_Asy_TLA_Sound_Warning pA_Asy_TLA_Sound_Warning;
/*      */       byte[] arrayOfByte169;
/*      */       PATypes.PA_Asy_SpeedCompensation pA_Asy_SpeedCompensation;
/*   34 */       switch (paramECarXCarPropertyValue.getPropertyId())
/*      */       { default:
/*      */           return;
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
/*      */         case 33973:
/* 4058 */           this.data = (byte[])paramECarXCarPropertyValue.getValue();
/* 4059 */           pA_VehMdlClrReq = new PATypes.PA_VehMdlClrReq(); arrayOfByte167 = this.data;
/* 4060 */           this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte167));
/* 4061 */           onPA_VehMdlClrReq(pA_VehMdlClrReq);case 33972: this.data = (byte[])arrayOfByte167.getValue(); pA_TurnEntryAgWideVisReq = new PATypes.PA_TurnEntryAgWideVisReq(); arrayOfByte167 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte167)); onPA_TurnEntryAgWideVisReq(pA_TurnEntryAgWideVisReq);case 33971: this.data = (byte[])arrayOfByte167.getValue(); pA_TopVisnDispExtnReq = new PATypes.PA_TopVisnDispExtnReq(); arrayOfByte332 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte332)); onPA_TopVisnDispExtnReq(pA_TopVisnDispExtnReq);case 33970: this.data = (byte[])pA_TopVisnDispExtnReq.getValue(); pA_ThrDTouringViewReq = new PATypes.PA_ThrDTouringViewReq(); arrayOfByte332 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte332)); onPA_ThrDTouringViewReq(pA_ThrDTouringViewReq);case 33969: this.data = (byte[])pA_ThrDTouringViewReq.getValue(); pA_SurrndgsObjDetnReq = new PATypes.PA_SurrndgsObjDetnReq(); arrayOfByte332 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte332)); onPA_SurrndgsObjDetnReq(pA_SurrndgsObjDetnReq);case 33968: this.data = (byte[])pA_SurrndgsObjDetnReq.getValue(); pA_PrkgIndcrLineReq = new PATypes.PA_PrkgIndcrLineReq(); arrayOfByte332 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte332)); onPA_PrkgIndcrLineReq(pA_PrkgIndcrLineReq);case 33967: this.data = (byte[])pA_PrkgIndcrLineReq.getValue(); pA_HudDispModSetgReq = new PATypes.PA_HudDispModSetgReq(); arrayOfByte332 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte332)); onPA_HudDispModSetgReq(pA_HudDispModSetgReq);case 33966: this.data = (byte[])pA_HudDispModSetgReq.getValue(); pA_FaceSgnInForProf = new PATypes.PA_FaceSgnInForProf(); arrayOfByte332 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte332)); onPA_FaceSgnInForProf(pA_FaceSgnInForProf);case 33965: this.data = (byte[])pA_FaceSgnInForProf.getValue(); pA_FaceIdnReq = new PATypes.PA_FaceIdnReq(); arrayOfByte166 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte166)); onPA_FaceIdnReq(pA_FaceIdnReq);case 33964: this.data = (byte[])arrayOfByte166.getValue(); pA_CnclFaceReqForProf = new PATypes.PA_CnclFaceReqForProf(); arrayOfByte166 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte166)); onPA_CnclFaceReqForProf(pA_CnclFaceReqForProf);case 33963: this.data = (byte[])arrayOfByte166.getValue(); pA_VehCharg_ChargingColumn = new PATypes.PA_VehCharg_ChargingColumn(); arrayOfByte331 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte331)); onPA_VehCharg_ChargingColumn(pA_VehCharg_ChargingColumn);case 33962: this.data = (byte[])pA_VehCharg_ChargingColumn.getValue(); pA_SCEMOD_SceneModSeldCustomization = new PATypes.PA_SCEMOD_SceneModSeldCustomization(); arrayOfByte331 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte331)); onPA_SCEMOD_SceneModSeldCustomization(pA_SCEMOD_SceneModSeldCustomization);case 33961: this.data = (byte[])pA_SCEMOD_SceneModSeldCustomization.getValue(); pA_SCEMOD_SceneModSeldQuitStranger = new PATypes.PA_SCEMOD_SceneModSeldQuitStranger(); arrayOfByte165 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte165)); onPA_SCEMOD_SceneModSeldQuitStranger(pA_SCEMOD_SceneModSeldQuitStranger);case 33960: this.data = (byte[])arrayOfByte165.getValue(); pA_SENSOR_JoyForbidState = new PATypes.PA_SENSOR_JoyForbidState(); arrayOfByte330 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte330)); onPA_SENSOR_JoyForbidState(pA_SENSOR_JoyForbidState);case 33959: this.data = (byte[])pA_SENSOR_JoyForbidState.getValue(); pA_SENSOR_JoyLimitState = new PATypes.PA_SENSOR_JoyLimitState(); arrayOfByte330 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte330)); onPA_SENSOR_JoyLimitState(pA_SENSOR_JoyLimitState);case 33958: this.data = (byte[])pA_SENSOR_JoyLimitState.getValue(); pA_SENSOR_EngHrToSrvValue = new PATypes.PA_SENSOR_EngHrToSrvValue(); arrayOfByte330 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte330)); onPA_SENSOR_EngHrToSrvValue(pA_SENSOR_EngHrToSrvValue);case 33957: this.data = (byte[])pA_SENSOR_EngHrToSrvValue.getValue(); pA_SENSOR_DayToSrvValue = new PATypes.PA_SENSOR_DayToSrvValue(); arrayOfByte330 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte330)); onPA_SENSOR_DayToSrvValue(pA_SENSOR_DayToSrvValue);case 33956: this.data = (byte[])pA_SENSOR_DayToSrvValue.getValue(); pA_SENSOR_DstToSrvValue = new PATypes.PA_SENSOR_DstToSrvValue(); arrayOfByte330 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte330)); onPA_SENSOR_DstToSrvValue(pA_SENSOR_DstToSrvValue);case 33955: this.data = (byte[])pA_SENSOR_DstToSrvValue.getValue(); pA_FD_FaceIdnReq = new PATypes.PA_FD_FaceIdnReq(); arrayOfByte164 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte164)); onPA_FD_FaceIdnReq(pA_FD_FaceIdnReq);case 33954: this.data = (byte[])arrayOfByte164.getValue(); pA_SCEMOD_SceneModSeldPassengerRepose = new PATypes.PA_SCEMOD_SceneModSeldPassengerRepose(); arrayOfByte329 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte329)); onPA_SCEMOD_SceneModSeldPassengerRepose(pA_SCEMOD_SceneModSeldPassengerRepose);case 33953: this.data = (byte[])pA_SCEMOD_SceneModSeldPassengerRepose.getValue(); pA_SCEMOD_PassSceneModSeldValue = new PATypes.PA_SCEMOD_PassSceneModSeldValue(); arrayOfByte163 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte163)); onPA_SCEMOD_PassSceneModSeldValue(pA_SCEMOD_PassSceneModSeldValue);case 33952: this.data = (byte[])arrayOfByte163.getValue(); pA_SCEMOD_SceneModSeldGoddess = new PATypes.PA_SCEMOD_SceneModSeldGoddess(); arrayOfByte163 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte163)); onPA_SCEMOD_SceneModSeldGoddess(pA_SCEMOD_SceneModSeldGoddess);case 33951: this.data = (byte[])arrayOfByte163.getValue(); pA_SCEMOD_SceneModSeldValue = new PATypes.PA_SCEMOD_SceneModSeldValue(); arrayOfByte163 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte163)); onPA_SCEMOD_SceneModSeldValue(pA_SCEMOD_SceneModSeldValue);case 33950: this.data = (byte[])arrayOfByte163.getValue(); pA_SCEMOD_SceneModSeldKing = new PATypes.PA_SCEMOD_SceneModSeldKing(); arrayOfByte328 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte328)); onPA_SCEMOD_SceneModSeldKing(pA_SCEMOD_SceneModSeldKing);case 33949: this.data = (byte[])pA_SCEMOD_SceneModSeldKing.getValue(); pA_SCEMOD_SceneModSeldEco = new PATypes.PA_SCEMOD_SceneModSeldEco(); arrayOfByte328 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte328)); onPA_SCEMOD_SceneModSeldEco(pA_SCEMOD_SceneModSeldEco);case 33948: this.data = (byte[])pA_SCEMOD_SceneModSeldEco.getValue(); pA_SCEMOD_SceneModSeldRearRowTheater = new PATypes.PA_SCEMOD_SceneModSeldRearRowTheater(); arrayOfByte328 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte328)); onPA_SCEMOD_SceneModSeldRearRowTheater(pA_SCEMOD_SceneModSeldRearRowTheater);case 33947: this.data = (byte[])pA_SCEMOD_SceneModSeldRearRowTheater.getValue(); pA_SCEMOD_SceneModSeldFrontRowTheater = new PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater(); arrayOfByte328 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte328)); onPA_SCEMOD_SceneModSeldFrontRowTheater(pA_SCEMOD_SceneModSeldFrontRowTheater);case 33946: this.data = (byte[])pA_SCEMOD_SceneModSeldFrontRowTheater.getValue(); pA_SCEMOD_SceneModSeldSecondRightRest = new PATypes.PA_SCEMOD_SceneModSeldSecondRightRest(); arrayOfByte162 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte162)); onPA_SCEMOD_SceneModSeldSecondRightRest(pA_SCEMOD_SceneModSeldSecondRightRest);case 33945: this.data = (byte[])arrayOfByte162.getValue(); pA_SCEMOD_SceneModSeldSecondLeftRest = new PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest(); arrayOfByte327 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte327)); onPA_SCEMOD_SceneModSeldSecondLeftRest(pA_SCEMOD_SceneModSeldSecondLeftRest);case 33944: this.data = (byte[])pA_SCEMOD_SceneModSeldSecondLeftRest.getValue(); pA_SCEMOD_SceneModSeldPassengerRest = new PATypes.PA_SCEMOD_SceneModSeldPassengerRest(); arrayOfByte327 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte327)); onPA_SCEMOD_SceneModSeldPassengerRest(pA_SCEMOD_SceneModSeldPassengerRest);case 33943: this.data = (byte[])pA_SCEMOD_SceneModSeldPassengerRest.getValue(); pA_SCEMOD_SceneModSeldDriverRest = new PATypes.PA_SCEMOD_SceneModSeldDriverRest(); arrayOfByte161 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte161)); onPA_SCEMOD_SceneModSeldDriverRest(pA_SCEMOD_SceneModSeldDriverRest);case 33942: this.data = (byte[])arrayOfByte161.getValue(); pA_SCEMOD_SceneModSeldChild = new PATypes.PA_SCEMOD_SceneModSeldChild(); arrayOfByte161 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte161)); onPA_SCEMOD_SceneModSeldChild(pA_SCEMOD_SceneModSeldChild);case 33941: this.data = (byte[])arrayOfByte161.getValue(); pA_SCEMOD_SceneModSeldBiochal = new PATypes.PA_SCEMOD_SceneModSeldBiochal(); arrayOfByte161 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte161)); onPA_SCEMOD_SceneModSeldBiochal(pA_SCEMOD_SceneModSeldBiochal);case 33940: this.data = (byte[])arrayOfByte161.getValue(); pA_SCEMOD_SceneModSeldStranger = new PATypes.PA_SCEMOD_SceneModSeldStranger(); arrayOfByte161 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte161)); onPA_SCEMOD_SceneModSeldStranger(pA_SCEMOD_SceneModSeldStranger);case 33939: this.data = (byte[])arrayOfByte161.getValue(); pA_SCEMOD_SceneModSeldCarWash = new PATypes.PA_SCEMOD_SceneModSeldCarWash(); arrayOfByte161 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte161)); onPA_SCEMOD_SceneModSeldCarWash(pA_SCEMOD_SceneModSeldCarWash);case 33938: this.data = (byte[])arrayOfByte161.getValue(); pA_SCEMOD_SceneModSeldPet = new PATypes.PA_SCEMOD_SceneModSeldPet(); arrayOfByte326 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte326)); onPA_SCEMOD_SceneModSeldPet(pA_SCEMOD_SceneModSeldPet);case 33937: this.data = (byte[])pA_SCEMOD_SceneModSeldPet.getValue(); pA_SCEMOD_SceneModSeldRomantic = new PATypes.PA_SCEMOD_SceneModSeldRomantic(); arrayOfByte326 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte326)); onPA_SCEMOD_SceneModSeldRomantic(pA_SCEMOD_SceneModSeldRomantic);case 33936: this.data = (byte[])pA_SCEMOD_SceneModSeldRomantic.getValue(); pA_SCEMOD_SceneModSeldWakeUp = new PATypes.PA_SCEMOD_SceneModSeldWakeUp(); arrayOfByte326 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte326)); onPA_SCEMOD_SceneModSeldWakeUp(pA_SCEMOD_SceneModSeldWakeUp);case 33935: this.data = (byte[])pA_SCEMOD_SceneModSeldWakeUp.getValue(); pA_TS_CurTripTime = new PATypes.PA_TS_CurTripTime(); arrayOfByte326 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte326)); onPA_TS_CurTripTime(pA_TS_CurTripTime);case 33934: this.data = (byte[])pA_TS_CurTripTime.getValue(); pA_TS_CurTripDis = new PATypes.PA_TS_CurTripDis(); arrayOfByte160 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte160)); onPA_TS_CurTripDis(pA_TS_CurTripDis);case 33933: this.data = (byte[])arrayOfByte160.getValue(); pA_NAVI_VehEgyCoornFctStChg = new PATypes.PA_NAVI_VehEgyCoornFctStChg(); arrayOfByte160 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte160)); onPA_NAVI_VehEgyCoornFctStChg(pA_NAVI_VehEgyCoornFctStChg);case 33932: this.data = (byte[])arrayOfByte160.getValue(); pA_NAVI_VehEgyCoornOpenAndCls = new PATypes.PA_NAVI_VehEgyCoornOpenAndCls(); arrayOfByte160 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte160)); onPA_NAVI_VehEgyCoornOpenAndCls(pA_NAVI_VehEgyCoornOpenAndCls);case 33931: this.data = (byte[])arrayOfByte160.getValue(); pA_HUD_DispModSet = new PATypes.PA_HUD_DispModSet(); arrayOfByte325 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte325)); onPA_HUD_DispModSet(pA_HUD_DispModSet);case 33930: this.data = (byte[])pA_HUD_DispModSet.getValue(); pA_PSET_NameP5 = new PATypes.PA_PSET_NameP5(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_PSET_NameP5(pA_PSET_NameP5);case 33929: this.data = (byte[])pA_PSET_NameP5.getValue(); pA_PSET_NameP4 = new PATypes.PA_PSET_NameP4(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_PSET_NameP4(pA_PSET_NameP4);case 33928: this.data = (byte[])pA_PSET_NameP4.getValue(); pA_PSET_NameP3 = new PATypes.PA_PSET_NameP3(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_PSET_NameP3(pA_PSET_NameP3);case 33927: this.data = (byte[])pA_PSET_NameP3.getValue(); pA_PSET_NameP2 = new PATypes.PA_PSET_NameP2(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_PSET_NameP2(pA_PSET_NameP2);case 33926: this.data = (byte[])pA_PSET_NameP2.getValue(); pA_PSET_NameP1 = new PATypes.PA_PSET_NameP1(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_PSET_NameP1(pA_PSET_NameP1);case 33925: this.data = (byte[])pA_PSET_NameP1.getValue(); pA_AmbLi_MsgEnd = new PATypes.PA_AmbLi_MsgEnd(); arrayOfByte159 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte159)); onPA_AmbLi_MsgEnd(pA_AmbLi_MsgEnd);case 33924: this.data = (byte[])arrayOfByte159.getValue(); pA_VM2_MsgEnd = new PATypes.PA_VM2_MsgEnd(); arrayOfByte324 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte324)); onPA_VM2_MsgEnd(pA_VM2_MsgEnd);case 33923: this.data = (byte[])pA_VM2_MsgEnd.getValue(); pA_VM_MsgEnd = new PATypes.PA_VM_MsgEnd(); arrayOfByte158 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte158)); onPA_VM_MsgEnd(pA_VM_MsgEnd);case 33922: this.data = (byte[])arrayOfByte158.getValue(); pA_WPC_MsgEnd = new PATypes.PA_WPC_MsgEnd(); arrayOfByte323 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte323)); onPA_WPC_MsgEnd(pA_WPC_MsgEnd);case 33921: this.data = (byte[])pA_WPC_MsgEnd.getValue(); pA_VehCharg_MsgEnd = new PATypes.PA_VehCharg_MsgEnd(); arrayOfByte157 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte157)); onPA_VehCharg_MsgEnd(pA_VehCharg_MsgEnd);case 33920: this.data = (byte[])arrayOfByte157.getValue(); pA_SC_MsgEnd = new PATypes.PA_SC_MsgEnd(); arrayOfByte322 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte322)); onPA_SC_MsgEnd(pA_SC_MsgEnd);case 33919: this.data = (byte[])pA_SC_MsgEnd.getValue(); pA_PAS_MsgEnd = new PATypes.PA_PAS_MsgEnd(); arrayOfByte322 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte322)); onPA_PAS_MsgEnd(pA_PAS_MsgEnd);case 33918: this.data = (byte[])pA_PAS_MsgEnd.getValue(); pA_PAC_MsgEnd = new PATypes.PA_PAC_MsgEnd(); arrayOfByte322 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte322)); onPA_PAC_MsgEnd(pA_PAC_MsgEnd);case 33917: this.data = (byte[])pA_PAC_MsgEnd.getValue(); pA_VFC_MsgEnd = new PATypes.PA_VFC_MsgEnd(); arrayOfByte156 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte156)); onPA_VFC_MsgEnd(pA_VFC_MsgEnd);case 33916: this.data = (byte[])arrayOfByte156.getValue(); pA_HUD_MsgEnd = new PATypes.PA_HUD_MsgEnd(); arrayOfByte321 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte321)); onPA_HUD_MsgEnd(pA_HUD_MsgEnd);case 33915: this.data = (byte[])pA_HUD_MsgEnd.getValue(); pA_Device_MsgEnd = new PATypes.PA_Device_MsgEnd(); arrayOfByte155 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte155)); onPA_Device_MsgEnd(pA_Device_MsgEnd);case 33914: this.data = (byte[])arrayOfByte155.getValue(); pA_SS_MsgEnd = new PATypes.PA_SS_MsgEnd(); arrayOfByte155 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte155)); onPA_SS_MsgEnd(pA_SS_MsgEnd);case 33913: this.data = (byte[])arrayOfByte155.getValue(); pA_PSET_MsgEnd = new PATypes.PA_PSET_MsgEnd(); arrayOfByte320 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte320)); onPA_PSET_MsgEnd(pA_PSET_MsgEnd);case 33912: this.data = (byte[])pA_PSET_MsgEnd.getValue(); pA_DriveMode_MsgEnd = new PATypes.PA_DriveMode_MsgEnd(); arrayOfByte154 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte154)); onPA_DriveMode_MsgEnd(pA_DriveMode_MsgEnd);case 33911: this.data = (byte[])arrayOfByte154.getValue(); pA_TCH_MsgEnd = new PATypes.PA_TCH_MsgEnd(); arrayOfByte154 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte154)); onPA_TCH_MsgEnd(pA_TCH_MsgEnd);case 33910: this.data = (byte[])arrayOfByte154.getValue(); pA_Fragra_MsgEnd = new PATypes.PA_Fragra_MsgEnd(); arrayOfByte154 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte154)); onPA_Fragra_MsgEnd(pA_Fragra_MsgEnd);case 33909: this.data = (byte[])arrayOfByte154.getValue(); pA_SWH_MsgEnd = new PATypes.PA_SWH_MsgEnd(); arrayOfByte154 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte154)); onPA_SWH_MsgEnd(pA_SWH_MsgEnd);case 33908: this.data = (byte[])arrayOfByte154.getValue(); pA_SCV_MsgEnd = new PATypes.PA_SCV_MsgEnd(); arrayOfByte319 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte319)); onPA_SCV_MsgEnd(pA_SCV_MsgEnd);case 33907: this.data = (byte[])pA_SCV_MsgEnd.getValue(); pA_CL_MsgEnd = new PATypes.PA_CL_MsgEnd(); arrayOfByte319 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte319)); onPA_CL_MsgEnd(pA_CL_MsgEnd);case 33906: this.data = (byte[])pA_CL_MsgEnd.getValue(); pA_DID_MsgEnd = new PATypes.PA_DID_MsgEnd(); arrayOfByte153 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte153)); onPA_DID_MsgEnd(pA_DID_MsgEnd);case 33905: this.data = (byte[])arrayOfByte153.getValue(); pA_DiagProxy_MsgEnd = new PATypes.PA_DiagProxy_MsgEnd(); arrayOfByte153 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte153)); onPA_DiagProxy_MsgEnd(pA_DiagProxy_MsgEnd);case 33904: this.data = (byte[])arrayOfByte153.getValue(); pA_Asy_MsgEnd = new PATypes.PA_Asy_MsgEnd(); arrayOfByte318 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte318)); onPA_Asy_MsgEnd(pA_Asy_MsgEnd);case 33903: this.data = (byte[])pA_Asy_MsgEnd.getValue(); pA_TS_MsgEnd = new PATypes.PA_TS_MsgEnd(); arrayOfByte318 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte318)); onPA_TS_MsgEnd(pA_TS_MsgEnd);case 33902: this.data = (byte[])pA_TS_MsgEnd.getValue(); pA_AP_Version = new PATypes.PA_AP_Version(); arrayOfByte318 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte318)); onPA_AP_Version(pA_AP_Version);case 33901: this.data = (byte[])pA_AP_Version.getValue(); pA_AmpDiagResult = new PATypes.PA_AmpDiagResult(); arrayOfByte318 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte318)); onPA_AmpDiagResult(pA_AmpDiagResult);case 33900: this.data = (byte[])pA_AmpDiagResult.getValue(); pA_PSET_ProfilesInuse = new PATypes.PA_PSET_ProfilesInuse(); arrayOfByte152 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte152)); onPA_PSET_ProfilesInuse(pA_PSET_ProfilesInuse);case 33899: this.data = (byte[])arrayOfByte152.getValue(); pA_PSET_ProfileDownloadStatus = new PATypes.PA_PSET_ProfileDownloadStatus(); arrayOfByte152 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte152)); onPA_PSET_ProfileDownloadStatus(pA_PSET_ProfileDownloadStatus);case 33898: this.data = (byte[])arrayOfByte152.getValue(); pA_PSET_ProfileCloudData = new PATypes.PA_PSET_ProfileCloudData(); this(VendorVehicleHalPAProto.Profileclouddata.parseFrom(this.data)); onPA_PSET_ProfileCloudData(pA_PSET_ProfileCloudData);case 33897: this.data = (byte[])pA_PSET_ProfileCloudData.getValue(); pA_PSET_ProfAct = new PATypes.PA_PSET_ProfAct(); arrayOfByte317 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte317)); onPA_PSET_ProfAct(pA_PSET_ProfAct);case 33896: this.data = (byte[])pA_PSET_ProfAct.getValue(); pA_PSET_GID_Result = new PATypes.PA_PSET_GID_Result(); arrayOfByte317 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte317)); onPA_PSET_GID_Result(pA_PSET_GID_Result);case 33895: this.data = (byte[])pA_PSET_GID_Result.getValue(); pA_PSET_SeatLocationAdjust = new PATypes.PA_PSET_SeatLocationAdjust(); arrayOfByte151 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte151)); onPA_PSET_SeatLocationAdjust(pA_PSET_SeatLocationAdjust);case 33894: this.data = (byte[])arrayOfByte151.getValue(); pA_PSET_SeatButtonOnOff = new PATypes.PA_PSET_SeatButtonOnOff(); arrayOfByte316 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte316)); onPA_PSET_SeatButtonOnOff(pA_PSET_SeatButtonOnOff);case 33893: this.data = (byte[])pA_PSET_SeatButtonOnOff.getValue(); pA_PSET_User6 = new PATypes.PA_PSET_User6(); arrayOfByte150 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte150)); onPA_PSET_User6(pA_PSET_User6);case 33892: this.data = (byte[])arrayOfByte150.getValue(); pA_PSET_User5 = new PATypes.PA_PSET_User5(); arrayOfByte150 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte150)); onPA_PSET_User5(pA_PSET_User5);case 33891: this.data = (byte[])arrayOfByte150.getValue(); pA_PSET_User4 = new PATypes.PA_PSET_User4(); arrayOfByte150 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte150)); onPA_PSET_User4(pA_PSET_User4);case 33890: this.data = (byte[])arrayOfByte150.getValue(); pA_PSET_User3 = new PATypes.PA_PSET_User3(); arrayOfByte150 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte150)); onPA_PSET_User3(pA_PSET_User3);case 33889: this.data = (byte[])arrayOfByte150.getValue(); pA_PSET_User2 = new PATypes.PA_PSET_User2(); arrayOfByte315 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte315)); onPA_PSET_User2(pA_PSET_User2);case 33888: this.data = (byte[])pA_PSET_User2.getValue(); pA_PSET_User1 = new PATypes.PA_PSET_User1(); arrayOfByte149 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte149)); onPA_PSET_User1(pA_PSET_User1);case 33887: this.data = (byte[])arrayOfByte149.getValue(); pA_PSET_SimplUnlockCurrent = new PATypes.PA_PSET_SimplUnlockCurrent(); arrayOfByte149 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte149)); onPA_PSET_SimplUnlockCurrent(pA_PSET_SimplUnlockCurrent);case 33886: this.data = (byte[])arrayOfByte149.getValue(); pA_PSET_NFC_Result = new PATypes.PA_PSET_NFC_Result(); arrayOfByte314 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte314)); onPA_PSET_NFC_Result(pA_PSET_NFC_Result);case 33885: this.data = (byte[])pA_PSET_NFC_Result.getValue(); pA_PSET_NFCID = new PATypes.PA_PSET_NFCID(); arrayOfByte148 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte148)); onPA_PSET_NFCID(pA_PSET_NFCID);case 33884: this.data = (byte[])arrayOfByte148.getValue(); pA_PSET_LYNKID_Result = new PATypes.PA_PSET_LYNKID_Result(); arrayOfByte148 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte148)); onPA_PSET_LYNKID_Result(pA_PSET_LYNKID_Result);case 33883: this.data = (byte[])arrayOfByte148.getValue(); pA_PSET_LYNKID = new PATypes.PA_PSET_LYNKID(); arrayOfByte148 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte148)); onPA_PSET_LYNKID(pA_PSET_LYNKID);case 33882: this.data = (byte[])arrayOfByte148.getValue(); pA_PSET_AutLogOutCurrent = new PATypes.PA_PSET_AutLogOutCurrent(); arrayOfByte313 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte313)); onPA_PSET_AutLogOutCurrent(pA_PSET_AutLogOutCurrent);case 33881: this.data = (byte[])pA_PSET_AutLogOutCurrent.getValue(); pA_PSET_MaxNrProfReached = new PATypes.PA_PSET_MaxNrProfReached(); arrayOfByte147 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte147)); onPA_PSET_MaxNrProfReached(pA_PSET_MaxNrProfReached);case 33880: this.data = (byte[])arrayOfByte147.getValue(); pA_PSET_PChangeAllowed = new PATypes.PA_PSET_PChangeAllowed(); arrayOfByte312 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte312)); onPA_PSET_PChangeAllowed(pA_PSET_PChangeAllowed);case 33879: this.data = (byte[])pA_PSET_PChangeAllowed.getValue(); pA_PSET_KeyID = new PATypes.PA_PSET_KeyID(); arrayOfByte312 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte312)); onPA_PSET_KeyID(pA_PSET_KeyID);case 33878: this.data = (byte[])pA_PSET_KeyID.getValue(); pA_PSET_Key_Result = new PATypes.PA_PSET_Key_Result(); arrayOfByte146 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte146)); onPA_PSET_Key_Result(pA_PSET_Key_Result);case 33877: this.data = (byte[])arrayOfByte146.getValue(); pA_PSET_FactoryDefaultResult = new PATypes.PA_PSET_FactoryDefaultResult(); arrayOfByte146 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte146)); onPA_PSET_FactoryDefaultResult(pA_PSET_FactoryDefaultResult);case 33876: this.data = (byte[])arrayOfByte146.getValue(); pA_PSET_FactoryDefault = new PATypes.PA_PSET_FactoryDefault(); arrayOfByte146 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte146)); onPA_PSET_FactoryDefault(pA_PSET_FactoryDefault);case 33875: this.data = (byte[])arrayOfByte146.getValue(); pA_PSET_ProfileFactoryDefaultResult = new PATypes.PA_PSET_ProfileFactoryDefaultResult(); arrayOfByte311 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte311)); onPA_PSET_ProfileFactoryDefaultResult(pA_PSET_ProfileFactoryDefaultResult);case 33874: this.data = (byte[])pA_PSET_ProfileFactoryDefaultResult.getValue(); pA_PSET_ProfileFactoryDefault = new PATypes.PA_PSET_ProfileFactoryDefault(); arrayOfByte145 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte145)); onPA_PSET_ProfileFactoryDefault(pA_PSET_ProfileFactoryDefault);case 33873: this.data = (byte[])arrayOfByte145.getValue(); pA_PSET_LogOut = new PATypes.PA_PSET_LogOut(); arrayOfByte145 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte145)); onPA_PSET_LogOut(pA_PSET_LogOut);case 33872: this.data = (byte[])arrayOfByte145.getValue(); pA_PSET_DeleteProfile = new PATypes.PA_PSET_DeleteProfile(); arrayOfByte310 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte310)); onPA_PSET_DeleteProfile(pA_PSET_DeleteProfile);case 33871: this.data = (byte[])pA_PSET_DeleteProfile.getValue(); pA_PSET_NewProfile = new PATypes.PA_PSET_NewProfile(); arrayOfByte144 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte144)); onPA_PSET_NewProfile(pA_PSET_NewProfile);case 33870: this.data = (byte[])arrayOfByte144.getValue(); pA_PSET_ActiveProfile = new PATypes.PA_PSET_ActiveProfile(); arrayOfByte144 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte144)); onPA_PSET_ActiveProfile(pA_PSET_ActiveProfile);case 33869: this.data = (byte[])arrayOfByte144.getValue(); pA_VFS_DPS = new PATypes.PA_VFS_DPS(); arrayOfByte309 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte309)); onPA_VFS_DPS(pA_VFS_DPS);case 33868: this.data = (byte[])pA_VFS_DPS.getValue(); pA_VFS_FaceIdnReq = new PATypes.PA_VFS_FaceIdnReq(); arrayOfByte309 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte309)); onPA_VFS_FaceIdnReq(pA_VFS_FaceIdnReq);case 33867: this.data = (byte[])pA_VFS_FaceIdnReq.getValue(); pA_ChdLockReRight_ChdMod = new PATypes.PA_ChdLockReRight_ChdMod(); arrayOfByte143 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte143)); onPA_ChdLockReRight_ChdMod(pA_ChdLockReRight_ChdMod);case 33866: this.data = (byte[])arrayOfByte143.getValue(); pA_ChdLockReLeft_ChdMod = new PATypes.PA_ChdLockReLeft_ChdMod(); arrayOfByte308 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte308)); onPA_ChdLockReLeft_ChdMod(pA_ChdLockReLeft_ChdMod);case 33865: this.data = (byte[])pA_ChdLockReLeft_ChdMod.getValue(); pA_ChdLockReRight = new PATypes.PA_ChdLockReRight(); arrayOfByte308 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte308)); onPA_ChdLockReRight(pA_ChdLockReRight);case 33864: this.data = (byte[])pA_ChdLockReRight.getValue(); pA_ChdLockReLeft = new PATypes.PA_ChdLockReLeft(); arrayOfByte142 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte142)); onPA_ChdLockReLeft(pA_ChdLockReLeft);case 33863: this.data = (byte[])arrayOfByte142.getValue(); pA_WinPosnStsAtReRi = new PATypes.PA_WinPosnStsAtReRi(); arrayOfByte142 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte142)); onPA_WinPosnStsAtReRi(pA_WinPosnStsAtReRi);case 33862: this.data = (byte[])arrayOfByte142.getValue(); pA_WinPosnStsAtReLe = new PATypes.PA_WinPosnStsAtReLe(); arrayOfByte307 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte307)); onPA_WinPosnStsAtReLe(pA_WinPosnStsAtReLe);case 33861: this.data = (byte[])pA_WinPosnStsAtReLe.getValue(); pA_WinPosnStsAtPass = new PATypes.PA_WinPosnStsAtPass(); arrayOfByte307 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte307)); onPA_WinPosnStsAtPass(pA_WinPosnStsAtPass);case 33860: this.data = (byte[])pA_WinPosnStsAtPass.getValue(); pA_WinPosnStsAtDrvr = new PATypes.PA_WinPosnStsAtDrvr(); arrayOfByte307 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte307)); onPA_WinPosnStsAtDrvr(pA_WinPosnStsAtDrvr);case 33859: this.data = (byte[])pA_WinPosnStsAtDrvr.getValue(); pA_WinOpenReRiReq = new PATypes.PA_WinOpenReRiReq(); arrayOfByte307 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte307)); onPA_WinOpenReRiReq(pA_WinOpenReRiReq);case 33858: this.data = (byte[])pA_WinOpenReRiReq.getValue(); pA_WinOpenReLeReq = new PATypes.PA_WinOpenReLeReq(); arrayOfByte141 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte141)); onPA_WinOpenReLeReq(pA_WinOpenReLeReq);case 33857: this.data = (byte[])arrayOfByte141.getValue(); pA_WinOpenPassReq = new PATypes.PA_WinOpenPassReq(); arrayOfByte306 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte306)); onPA_WinOpenPassReq(pA_WinOpenPassReq);case 33856: this.data = (byte[])pA_WinOpenPassReq.getValue(); pA_WinOpenDrvrReq = new PATypes.PA_WinOpenDrvrReq(); arrayOfByte140 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte140)); onPA_WinOpenDrvrReq(pA_WinOpenDrvrReq);case 33855: this.data = (byte[])arrayOfByte140.getValue(); pA_EgyRgnLvlSet = new PATypes.PA_EgyRgnLvlSet(); arrayOfByte305 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte305)); onPA_EgyRgnLvlSet(pA_EgyRgnLvlSet);case 33854: this.data = (byte[])pA_EgyRgnLvlSet.getValue(); pA_AmbLiRadarCorrlnReq = new PATypes.PA_AmbLiRadarCorrlnReq(); arrayOfByte139 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte139)); onPA_AmbLiRadarCorrlnReq(pA_AmbLiRadarCorrlnReq);case 33853: this.data = (byte[])arrayOfByte139.getValue(); pA_MoodLiColorAdjReq = new PATypes.PA_MoodLiColorAdjReq(); arrayOfByte304 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte304)); onPA_MoodLiColorAdjReq(pA_MoodLiColorAdjReq);case 33852: this.data = (byte[])pA_MoodLiColorAdjReq.getValue(); pA_CustomEffectBreath = new PATypes.PA_CustomEffectBreath(); arrayOfByte304 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte304)); onPA_CustomEffectBreath(pA_CustomEffectBreath);case 33851: this.data = (byte[])pA_CustomEffectBreath.getValue(); pA_ReadLightAllOnSwitch = new PATypes.PA_ReadLightAllOnSwitch(); arrayOfByte138 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte138)); onPA_ReadLightAllOnSwitch(pA_ReadLightAllOnSwitch);case 33850: this.data = (byte[])arrayOfByte138.getValue(); pA_GoodbyeLight = new PATypes.PA_GoodbyeLight(); arrayOfByte303 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte303)); onPA_GoodbyeLight(pA_GoodbyeLight);case 33849: this.data = (byte[])pA_GoodbyeLight.getValue(); pA_WelcomeLight = new PATypes.PA_WelcomeLight(); arrayOfByte303 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte303)); onPA_WelcomeLight(pA_WelcomeLight);case 33848: this.data = (byte[])pA_WelcomeLight.getValue(); pA_CourtesyLight = new PATypes.PA_CourtesyLight(); arrayOfByte303 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte303)); onPA_CourtesyLight(pA_CourtesyLight);case 33847: this.data = (byte[])pA_CourtesyLight.getValue(); pA_WeatherInfoConService = new PATypes.PA_WeatherInfoConService(); arrayOfByte303 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte303)); onPA_WeatherInfoConService(pA_WeatherInfoConService);case 33846: this.data = (byte[])pA_WeatherInfoConService.getValue(); pA_ReadLightThirdRowRight = new PATypes.PA_ReadLightThirdRowRight(); arrayOfByte137 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte137)); onPA_ReadLightThirdRowRight(pA_ReadLightThirdRowRight);case 33845: this.data = (byte[])arrayOfByte137.getValue(); pA_ReadLightThirdRowLeft = new PATypes.PA_ReadLightThirdRowLeft(); arrayOfByte302 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte302)); onPA_ReadLightThirdRowLeft(pA_ReadLightThirdRowLeft);case 33844: this.data = (byte[])pA_ReadLightThirdRowLeft.getValue(); pA_ReadLightSecondRowRight = new PATypes.PA_ReadLightSecondRowRight(); arrayOfByte136 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte136)); onPA_ReadLightSecondRowRight(pA_ReadLightSecondRowRight);case 33843: this.data = (byte[])arrayOfByte136.getValue(); pA_ReadLightSecondRowLeft = new PATypes.PA_ReadLightSecondRowLeft(); arrayOfByte136 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte136)); onPA_ReadLightSecondRowLeft(pA_ReadLightSecondRowLeft);case 33842: this.data = (byte[])arrayOfByte136.getValue(); pA_ReadLightFrontRight = new PATypes.PA_ReadLightFrontRight(); arrayOfByte301 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte301)); onPA_ReadLightFrontRight(pA_ReadLightFrontRight);case 33841: this.data = (byte[])pA_ReadLightFrontRight.getValue(); pA_ReadLightFrontLeft = new PATypes.PA_ReadLightFrontLeft(); arrayOfByte301 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte301)); onPA_ReadLightFrontLeft(pA_ReadLightFrontLeft);case 33840: this.data = (byte[])pA_ReadLightFrontLeft.getValue(); pA_AmbLiPhoneOpenReq = new PATypes.PA_AmbLiPhoneOpenReq(); arrayOfByte301 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte301)); onPA_AmbLiPhoneOpenReq(pA_AmbLiPhoneOpenReq);case 33839: this.data = (byte[])pA_AmbLiPhoneOpenReq.getValue(); pA_AmbLiMilgOpenReq = new PATypes.PA_AmbLiMilgOpenReq(); arrayOfByte135 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte135)); onPA_AmbLiMilgOpenReq(pA_AmbLiMilgOpenReq);case 33838: this.data = (byte[])arrayOfByte135.getValue(); pA_MoodLightSwitch = new PATypes.PA_MoodLightSwitch(); arrayOfByte300 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte300)); onPA_MoodLightSwitch(pA_MoodLightSwitch);case 33837: this.data = (byte[])pA_MoodLightSwitch.getValue(); pA_Zone3ColorSettings = new PATypes.PA_Zone3ColorSettings(); arrayOfByte300 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte300)); onPA_Zone3ColorSettings(pA_Zone3ColorSettings);case 33836: this.data = (byte[])pA_Zone3ColorSettings.getValue(); pA_Zone3IntensitySettings = new PATypes.PA_Zone3IntensitySettings(); arrayOfByte134 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte134)); onPA_Zone3IntensitySettings(pA_Zone3IntensitySettings);case 33835: this.data = (byte[])arrayOfByte134.getValue(); pA_Zone3StatusSettings = new PATypes.PA_Zone3StatusSettings(); arrayOfByte299 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte299)); onPA_Zone3StatusSettings(pA_Zone3StatusSettings);case 33834: this.data = (byte[])pA_Zone3StatusSettings.getValue(); pA_Zone2ColorSettings = new PATypes.PA_Zone2ColorSettings(); arrayOfByte133 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte133)); onPA_Zone2ColorSettings(pA_Zone2ColorSettings);case 33833: this.data = (byte[])arrayOfByte133.getValue(); pA_Zone2IntensitySettings = new PATypes.PA_Zone2IntensitySettings(); arrayOfByte133 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte133)); onPA_Zone2IntensitySettings(pA_Zone2IntensitySettings);case 33832: this.data = (byte[])arrayOfByte133.getValue(); pA_Zone2StatusSettings = new PATypes.PA_Zone2StatusSettings(); arrayOfByte298 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte298)); onPA_Zone2StatusSettings(pA_Zone2StatusSettings);case 33831: this.data = (byte[])pA_Zone2StatusSettings.getValue(); pA_Zone1ColorSettings = new PATypes.PA_Zone1ColorSettings(); arrayOfByte132 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte132)); onPA_Zone1ColorSettings(pA_Zone1ColorSettings);case 33830: this.data = (byte[])arrayOfByte132.getValue(); pA_Zone1IntensitySettings = new PATypes.PA_Zone1IntensitySettings(); arrayOfByte297 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte297)); onPA_Zone1IntensitySettings(pA_Zone1IntensitySettings);case 33829: this.data = (byte[])pA_Zone1IntensitySettings.getValue(); pA_Zone1StatusSettings = new PATypes.PA_Zone1StatusSettings(); arrayOfByte297 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte297)); onPA_Zone1StatusSettings(pA_Zone1StatusSettings);case 33828: this.data = (byte[])pA_Zone1StatusSettings.getValue(); pA_ZoneAllColorSettings = new PATypes.PA_ZoneAllColorSettings(); arrayOfByte131 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte131)); onPA_ZoneAllColorSettings(pA_ZoneAllColorSettings);case 33827: this.data = (byte[])arrayOfByte131.getValue(); pA_ZoneAllIntensitySettings = new PATypes.PA_ZoneAllIntensitySettings(); arrayOfByte296 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte296)); onPA_ZoneAllIntensitySettings(pA_ZoneAllIntensitySettings);case 33826: this.data = (byte[])pA_ZoneAllIntensitySettings.getValue(); pA_ZoneAllStatusSettings = new PATypes.PA_ZoneAllStatusSettings(); arrayOfByte296 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte296)); onPA_ZoneAllStatusSettings(pA_ZoneAllStatusSettings);case 33825: this.data = (byte[])pA_ZoneAllStatusSettings.getValue(); pA_TransitionColor2Settings = new PATypes.PA_TransitionColor2Settings(); arrayOfByte130 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte130)); onPA_TransitionColor2Settings(pA_TransitionColor2Settings);case 33824: this.data = (byte[])arrayOfByte130.getValue(); pA_TransitionColor1Settings = new PATypes.PA_TransitionColor1Settings(); arrayOfByte295 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte295)); onPA_TransitionColor1Settings(pA_TransitionColor1Settings);case 33823: this.data = (byte[])pA_TransitionColor1Settings.getValue(); pA_TransitionEffectSel = new PATypes.PA_TransitionEffectSel(); arrayOfByte295 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte295)); onPA_TransitionEffectSel(pA_TransitionEffectSel);case 33822: this.data = (byte[])pA_TransitionEffectSel.getValue(); pA_CustomEffect = new PATypes.PA_CustomEffect(); arrayOfByte129 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte129)); onPA_CustomEffect(pA_CustomEffect);case 33821: this.data = (byte[])arrayOfByte129.getValue(); pA_AmbLiMod_WeatherIndn = new PATypes.PA_AmbLiMod_WeatherIndn(); arrayOfByte129 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte129)); onPA_AmbLiMod_WeatherIndn(pA_AmbLiMod_WeatherIndn);case 33820: this.data = (byte[])arrayOfByte129.getValue(); pA_AmbLiMod_MusicShowMode = new PATypes.PA_AmbLiMod_MusicShowMode(); arrayOfByte294 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte294)); onPA_AmbLiMod_MusicShowMode(pA_AmbLiMod_MusicShowMode);case 33819: this.data = (byte[])pA_AmbLiMod_MusicShowMode.getValue(); pA_AmbLiMod_DriveMode = new PATypes.PA_AmbLiMod_DriveMode(); arrayOfByte294 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte294)); onPA_AmbLiMod_DriveMode(pA_AmbLiMod_DriveMode);case 33818: this.data = (byte[])pA_AmbLiMod_DriveMode.getValue(); pA_AmbLiMod_CustomizedMode = new PATypes.PA_AmbLiMod_CustomizedMode(); arrayOfByte128 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte128)); onPA_AmbLiMod_CustomizedMode(pA_AmbLiMod_CustomizedMode);case 33817: this.data = (byte[])arrayOfByte128.getValue(); pA_AmbLiMod_None = new PATypes.PA_AmbLiMod_None(); arrayOfByte128 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte128)); onPA_AmbLiMod_None(pA_AmbLiMod_None);case 33816: this.data = (byte[])arrayOfByte128.getValue(); pA_AmbLiModSetting = new PATypes.PA_AmbLiModSetting(); arrayOfByte293 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte293)); onPA_AmbLiModSetting(pA_AmbLiModSetting);case 33815: this.data = (byte[])pA_AmbLiModSetting.getValue(); pA_AmbLiAll = new PATypes.PA_AmbLiAll(); arrayOfByte127 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte127)); onPA_AmbLiAll(pA_AmbLiAll);case 33814: this.data = (byte[])arrayOfByte127.getValue(); pA_HmiCarLocatorSetReq = new PATypes.PA_HmiCarLocatorSetReq(); arrayOfByte127 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte127)); onPA_HmiCarLocatorSetReq(pA_HmiCarLocatorSetReq);case 33813: this.data = (byte[])arrayOfByte127.getValue(); pA_SunRoofTiltReq = new PATypes.PA_SunRoofTiltReq(); arrayOfByte127 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte127)); onPA_SunRoofTiltReq(pA_SunRoofTiltReq);case 33812: this.data = (byte[])arrayOfByte127.getValue(); pA_SunCurtOpenPosnReq = new PATypes.PA_SunCurtOpenPosnReq(); arrayOfByte292 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte292)); onPA_SunCurtOpenPosnReq(pA_SunCurtOpenPosnReq);case 33811: this.data = (byte[])pA_SunCurtOpenPosnReq.getValue(); pA_SunRoofOpenPosnReq = new PATypes.PA_SunRoofOpenPosnReq(); arrayOfByte126 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte126)); onPA_SunRoofOpenPosnReq(pA_SunRoofOpenPosnReq);case 33810: this.data = (byte[])arrayOfByte126.getValue(); pA_SunCurtainPosnSts = new PATypes.PA_SunCurtainPosnSts(); arrayOfByte291 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte291)); onPA_SunCurtainPosnSts(pA_SunCurtainPosnSts);case 33809: this.data = (byte[])pA_SunCurtainPosnSts.getValue(); pA_SunRoofPosnSts = new PATypes.PA_SunRoofPosnSts(); arrayOfByte291 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte291)); onPA_SunRoofPosnSts(pA_SunRoofPosnSts);case 33808: this.data = (byte[])pA_SunRoofPosnSts.getValue(); pA_CloseSunCurtain_Btn = new PATypes.PA_CloseSunCurtain_Btn(); arrayOfByte291 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte291)); onPA_CloseSunCurtain_Btn(pA_CloseSunCurtain_Btn);case 33807: this.data = (byte[])pA_CloseSunCurtain_Btn.getValue(); pA_OpenSunCurtain_Btn = new PATypes.PA_OpenSunCurtain_Btn(); arrayOfByte291 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte291)); onPA_OpenSunCurtain_Btn(pA_OpenSunCurtain_Btn);case 33806: this.data = (byte[])pA_OpenSunCurtain_Btn.getValue(); pA_CloseSunRoof_Btn = new PATypes.PA_CloseSunRoof_Btn(); arrayOfByte291 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte291)); onPA_CloseSunRoof_Btn(pA_CloseSunRoof_Btn);case 33805: this.data = (byte[])pA_CloseSunRoof_Btn.getValue(); pA_OpenSunRoof_Btn = new PATypes.PA_OpenSunRoof_Btn(); arrayOfByte125 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte125)); onPA_OpenSunRoof_Btn(pA_OpenSunRoof_Btn);case 33804: this.data = (byte[])arrayOfByte125.getValue(); pA_SunCurtain_Setting = new PATypes.PA_SunCurtain_Setting(); arrayOfByte290 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte290)); onPA_SunCurtain_Setting(pA_SunCurtain_Setting);case 33803: this.data = (byte[])pA_SunCurtain_Setting.getValue(); pA_VehCharg_ChrgnOrDisChrgnStsFb = new PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb(); arrayOfByte124 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte124)); onPA_VehCharg_ChrgnOrDisChrgnStsFb(pA_VehCharg_ChrgnOrDisChrgnStsFb);case 33802: this.data = (byte[])arrayOfByte124.getValue(); pA_VehCharg_HvBattChrgnTiEstimd = new PATypes.PA_VehCharg_HvBattChrgnTiEstimd(); arrayOfByte124 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte124)); onPA_VehCharg_HvBattChrgnTiEstimd(pA_VehCharg_HvBattChrgnTiEstimd);case 33801: this.data = (byte[])arrayOfByte124.getValue(); pA_VehCharg_OnBdChrgrIAct = new PATypes.PA_VehCharg_OnBdChrgrIAct(); arrayOfByte124 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte124)); onPA_VehCharg_OnBdChrgrIAct(pA_VehCharg_OnBdChrgrIAct);case 33800: this.data = (byte[])arrayOfByte124.getValue(); pA_VehCharg_OnBdChrgrUAct = new PATypes.PA_VehCharg_OnBdChrgrUAct(); arrayOfByte124 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte124)); onPA_VehCharg_OnBdChrgrUAct(pA_VehCharg_OnBdChrgrUAct);case 33799: this.data = (byte[])arrayOfByte124.getValue(); pA_VehCharg_DispHvBattLvlOfChrg = new PATypes.PA_VehCharg_DispHvBattLvlOfChrg(); arrayOfByte289 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte289)); onPA_VehCharg_DispHvBattLvlOfChrg(pA_VehCharg_DispHvBattLvlOfChrg);case 33798: this.data = (byte[])pA_VehCharg_DispHvBattLvlOfChrg.getValue(); pA_VehCharg_DchaEgyAct = new PATypes.PA_VehCharg_DchaEgyAct(); arrayOfByte289 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte289)); onPA_VehCharg_DchaEgyAct(pA_VehCharg_DchaEgyAct);case 33797: this.data = (byte[])pA_VehCharg_DchaEgyAct.getValue(); pA_VehCharg_HvBattDchaTiEstimd = new PATypes.PA_VehCharg_HvBattDchaTiEstimd(); arrayOfByte123 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte123)); onPA_VehCharg_HvBattDchaTiEstimd(pA_VehCharg_HvBattDchaTiEstimd);case 33796: this.data = (byte[])arrayOfByte123.getValue(); pA_VehCharg_DchaIAct = new PATypes.PA_VehCharg_DchaIAct(); arrayOfByte288 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte288)); onPA_VehCharg_DchaIAct(pA_VehCharg_DchaIAct);case 33795: this.data = (byte[])pA_VehCharg_DchaIAct.getValue(); pA_VehCharg_DchaUAct = new PATypes.PA_VehCharg_DchaUAct(); arrayOfByte288 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte288)); onPA_VehCharg_DchaUAct(pA_VehCharg_DchaUAct);case 33794: this.data = (byte[])pA_VehCharg_DchaUAct.getValue(); pA_VehCharg_DisChargeRecord = new PATypes.PA_VehCharg_DisChargeRecord(); arrayOfByte122 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte122)); onPA_VehCharg_DisChargeRecord(pA_VehCharg_DisChargeRecord);case 33793: this.data = (byte[])arrayOfByte122.getValue(); pA_VehCharg_DisChargeSwitch = new PATypes.PA_VehCharg_DisChargeSwitch(); arrayOfByte287 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte287)); onPA_VehCharg_DisChargeSwitch(pA_VehCharg_DisChargeSwitch);case 33792: this.data = (byte[])pA_VehCharg_DisChargeSwitch.getValue(); pA_VehCharg_DisChargInfoShow = new PATypes.PA_VehCharg_DisChargInfoShow(); arrayOfByte121 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte121)); onPA_VehCharg_DisChargInfoShow(pA_VehCharg_DisChargInfoShow);case 33791: this.data = (byte[])arrayOfByte121.getValue(); pA_VehCharg_DisChargSOC = new PATypes.PA_VehCharg_DisChargSOC(); arrayOfByte121 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte121)); onPA_VehCharg_DisChargSOC(pA_VehCharg_DisChargSOC);case 33790: this.data = (byte[])arrayOfByte121.getValue(); pA_VehCharg_Appointment = new PATypes.PA_VehCharg_Appointment(); arrayOfByte286 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte286)); onPA_VehCharg_Appointment(pA_VehCharg_Appointment);case 33789: this.data = (byte[])pA_VehCharg_Appointment.getValue(); pA_VehCharg_ChargLight = new PATypes.PA_VehCharg_ChargLight(); arrayOfByte286 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte286)); onPA_VehCharg_ChargLight(pA_VehCharg_ChargLight);case 33788: this.data = (byte[])pA_VehCharg_ChargLight.getValue(); pA_VehCharg_ChargInfoShow = new PATypes.PA_VehCharg_ChargInfoShow(); arrayOfByte120 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte120)); onPA_VehCharg_ChargInfoShow(pA_VehCharg_ChargInfoShow);case 33787: this.data = (byte[])arrayOfByte120.getValue(); pA_VehCharg_ChargSt = new PATypes.PA_VehCharg_ChargSt(); arrayOfByte120 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte120)); onPA_VehCharg_ChargSt(pA_VehCharg_ChargSt);case 33786: this.data = (byte[])arrayOfByte120.getValue(); pA_VehCharg_SetSOC = new PATypes.PA_VehCharg_SetSOC(); arrayOfByte285 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte285)); onPA_VehCharg_SetSOC(pA_VehCharg_SetSOC);case 33785: this.data = (byte[])pA_VehCharg_SetSOC.getValue(); pA_VehCharg_SetA = new PATypes.PA_VehCharg_SetA(); arrayOfByte285 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte285)); onPA_VehCharg_SetA(pA_VehCharg_SetA);case 33784: this.data = (byte[])pA_VehCharg_SetA.getValue(); pA_VehCharg_ChargRemind = new PATypes.PA_VehCharg_ChargRemind(); arrayOfByte285 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte285)); onPA_VehCharg_ChargRemind(pA_VehCharg_ChargRemind);case 33783: this.data = (byte[])pA_VehCharg_ChargRemind.getValue(); pA_TS_energyReStats100 = new PATypes.PA_TS_energyReStats100(); arrayOfByte119 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte119)); onPA_TS_energyReStats100(pA_TS_energyReStats100);case 33782: this.data = (byte[])arrayOfByte119.getValue(); pA_TS_energyReStats10 = new PATypes.PA_TS_energyReStats10(); arrayOfByte284 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte284)); onPA_TS_energyReStats10(pA_TS_energyReStats10);case 33781: this.data = (byte[])pA_TS_energyReStats10.getValue(); pA_TS_energyStats100 = new PATypes.PA_TS_energyStats100(); arrayOfByte284 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte284)); onPA_TS_energyStats100(pA_TS_energyStats100);case 33780: this.data = (byte[])pA_TS_energyStats100.getValue(); pA_TS_energyStats10 = new PATypes.PA_TS_energyStats10(); arrayOfByte284 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte284)); onPA_TS_energyStats10(pA_TS_energyStats10);case 33779: this.data = (byte[])pA_TS_energyStats10.getValue(); pA_TS_fuelStats100 = new PATypes.PA_TS_fuelStats100(); arrayOfByte118 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte118)); onPA_TS_fuelStats100(pA_TS_fuelStats100);case 33778: this.data = (byte[])arrayOfByte118.getValue(); pA_TS_fuelStats10 = new PATypes.PA_TS_fuelStats10(); arrayOfByte118 = this.data; this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte118)); onPA_TS_fuelStats10(pA_TS_fuelStats10);case 33777: this.data = (byte[])arrayOfByte118.getValue(); pA_TS_TripAverageEnConsumption5Km = new PATypes.PA_TS_TripAverageEnConsumption5Km(); arrayOfByte118 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte118)); onPA_TS_TripAverageEnConsumption5Km(pA_TS_TripAverageEnConsumption5Km);case 33776: this.data = (byte[])arrayOfByte118.getValue(); pA_TS_TripAverageEnConsumption05Km = new PATypes.PA_TS_TripAverageEnConsumption05Km(); arrayOfByte118 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte118)); onPA_TS_TripAverageEnConsumption05Km(pA_TS_TripAverageEnConsumption05Km);case 33775: this.data = (byte[])arrayOfByte118.getValue(); pA_TS_TripAverageConsumption5Km = new PATypes.PA_TS_TripAverageConsumption5Km(); arrayOfByte283 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte283)); onPA_TS_TripAverageConsumption5Km(pA_TS_TripAverageConsumption5Km);case 33774: this.data = (byte[])pA_TS_TripAverageConsumption5Km.getValue(); pA_TS_TripAverageConsumption05Km = new PATypes.PA_TS_TripAverageConsumption05Km(); arrayOfByte117 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte117)); onPA_TS_TripAverageConsumption05Km(pA_TS_TripAverageConsumption05Km);case 33773: this.data = (byte[])arrayOfByte117.getValue(); pA_TS_OdometerTripMeter2 = new PATypes.PA_TS_OdometerTripMeter2(); arrayOfByte117 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte117)); onPA_TS_OdometerTripMeter2(pA_TS_OdometerTripMeter2);case 33772: this.data = (byte[])arrayOfByte117.getValue(); pA_TS_Zero_Emission = new PATypes.PA_TS_Zero_Emission(); arrayOfByte282 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte282)); onPA_TS_Zero_Emission(pA_TS_Zero_Emission);case 33771: this.data = (byte[])pA_TS_Zero_Emission.getValue(); pA_TS_EDT_time2 = new PATypes.PA_TS_EDT_time2(); arrayOfByte282 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte282)); onPA_TS_EDT_time2(pA_TS_EDT_time2);case 33770: this.data = (byte[])pA_TS_EDT_time2.getValue(); pA_TS_DTEHV_round = new PATypes.PA_TS_DTEHV_round(); arrayOfByte282 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte282)); onPA_TS_DTEHV_round(pA_TS_DTEHV_round);case 33769: this.data = (byte[])pA_TS_DTEHV_round.getValue(); pA_TS_DTEHVBattIndicated = new PATypes.PA_TS_DTEHVBattIndicated(); arrayOfByte116 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte116)); onPA_TS_DTEHVBattIndicated(pA_TS_DTEHVBattIndicated);case 33768: this.data = (byte[])arrayOfByte116.getValue(); pA_TS_DTEIndicated = new PATypes.PA_TS_DTEIndicated(); arrayOfByte281 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte281)); onPA_TS_DTEIndicated(pA_TS_DTEIndicated);case 33767: this.data = (byte[])pA_TS_DTEIndicated.getValue(); pA_D0D0 = new PATypes.PA_D0D0(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_D0D0(pA_D0D0);case 33766: this.data = (byte[])pA_D0D0.getValue(); pA_D0D1 = new PATypes.PA_D0D1(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_D0D1(pA_D0D1);case 33765: this.data = (byte[])pA_D0D1.getValue(); pA_D0D2 = new PATypes.PA_D0D2(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_D0D2(pA_D0D2);case 33764: this.data = (byte[])pA_D0D2.getValue(); pA_Privacy_Compliance_Reset = new PATypes.PA_Privacy_Compliance_Reset(); arrayOfByte281 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte281)); onPA_Privacy_Compliance_Reset(pA_Privacy_Compliance_Reset);case 33763: this.data = (byte[])pA_Privacy_Compliance_Reset.getValue(); pA_AuthorityMicrophoneSwitch = new PATypes.PA_AuthorityMicrophoneSwitch(); arrayOfByte115 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte115)); onPA_AuthorityMicrophoneSwitch(pA_AuthorityMicrophoneSwitch);case 33762: this.data = (byte[])arrayOfByte115.getValue(); pA_AuthorityCameraSwitch = new PATypes.PA_AuthorityCameraSwitch(); arrayOfByte280 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte280)); onPA_AuthorityCameraSwitch(pA_AuthorityCameraSwitch);case 33761: this.data = (byte[])pA_AuthorityCameraSwitch.getValue(); pA_AuthorityLocationSwitch = new PATypes.PA_AuthorityLocationSwitch(); arrayOfByte114 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte114)); onPA_AuthorityLocationSwitch(pA_AuthorityLocationSwitch);case 33760: this.data = (byte[])arrayOfByte114.getValue(); pA_FD92 = new PATypes.PA_FD92(); arrayOfByte114 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte114)); onPA_FD92(pA_FD92);case 33759: this.data = (byte[])arrayOfByte114.getValue(); pA_FD91 = new PATypes.PA_FD91(); arrayOfByte114 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte114)); onPA_FD91(pA_FD91);case 33758: this.data = (byte[])arrayOfByte114.getValue(); pA_FD86 = new PATypes.PA_FD86(); arrayOfByte279 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte279)); onPA_FD86(pA_FD86);case 33757: this.data = (byte[])pA_FD86.getValue(); pA_FD88 = new PATypes.PA_FD88(); arrayOfByte113 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte113)); onPA_FD88(pA_FD88);case 33756: this.data = (byte[])arrayOfByte113.getValue(); pA_FD85 = new PATypes.PA_FD85(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD85(pA_FD85);case 33755: this.data = (byte[])pA_FD85.getValue(); pA_FD62 = new PATypes.PA_FD62(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD62(pA_FD62);case 33754: this.data = (byte[])pA_FD62.getValue(); pA_FD43 = new PATypes.PA_FD43(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD43(pA_FD43);case 33753: this.data = (byte[])pA_FD43.getValue(); pA_FD41 = new PATypes.PA_FD41(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD41(pA_FD41);case 33752: this.data = (byte[])pA_FD41.getValue(); pA_FD44 = new PATypes.PA_FD44(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD44(pA_FD44);case 33751: this.data = (byte[])pA_FD44.getValue(); pA_FD42 = new PATypes.PA_FD42(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD42(pA_FD42);case 33750: this.data = (byte[])pA_FD42.getValue(); pA_FD23 = new PATypes.PA_FD23(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD23(pA_FD23);case 33749: this.data = (byte[])pA_FD23.getValue(); pA_FD30 = new PATypes.PA_FD30(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD30(pA_FD30);case 33748: this.data = (byte[])pA_FD30.getValue(); pA_FD5A = new PATypes.PA_FD5A(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD5A(pA_FD5A);case 33747: this.data = (byte[])pA_FD5A.getValue(); pA_FD17 = new PATypes.PA_FD17(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD17(pA_FD17);case 33746: this.data = (byte[])pA_FD17.getValue(); pA_FD12 = new PATypes.PA_FD12(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD12(pA_FD12);case 33745: this.data = (byte[])pA_FD12.getValue(); pA_FD29 = new PATypes.PA_FD29(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_FD29(pA_FD29);case 33744: this.data = (byte[])pA_FD29.getValue(); pA_FD39 = new PATypes.PA_FD39(); arrayOfByte112 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte112)); onPA_FD39(pA_FD39);case 33743: this.data = (byte[])arrayOfByte112.getValue(); pA_FD28 = new PATypes.PA_FD28(); arrayOfByte278 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte278)); onPA_FD28(pA_FD28);case 33742: this.data = (byte[])pA_FD28.getValue(); pA_FD27 = new PATypes.PA_FD27(); arrayOfByte111 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte111)); onPA_FD27(pA_FD27);case 33741: this.data = (byte[])arrayOfByte111.getValue(); pA_FD26 = new PATypes.PA_FD26(); arrayOfByte111 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte111)); onPA_FD26(pA_FD26);case 33740: this.data = (byte[])arrayOfByte111.getValue(); pA_CSDM_PSD_EN = new PATypes.PA_CSDM_PSD_EN(); arrayOfByte111 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte111)); onPA_CSDM_PSD_EN(pA_CSDM_PSD_EN);case 33739: this.data = (byte[])arrayOfByte111.getValue(); pA_D907 = new PATypes.PA_D907(); arrayOfByte277 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte277)); onPA_D907(pA_D907);case 33738: this.data = (byte[])pA_D907.getValue(); pA_Manufacturing_Signal = new PATypes.PA_Manufacturing_Signal(); arrayOfByte277 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte277)); onPA_Manufacturing_Signal(pA_Manufacturing_Signal);case 33737: this.data = (byte[])pA_Manufacturing_Signal.getValue(); pA_VolvoHWSD_Reading = new PATypes.PA_VolvoHWSD_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_VolvoHWSD_Reading(pA_VolvoHWSD_Reading);case 33736: this.data = (byte[])pA_VolvoHWSD_Reading.getValue(); pA_VolvoDelivery_Assemble_Reading = new PATypes.PA_VolvoDelivery_Assemble_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_VolvoDelivery_Assemble_Reading(pA_VolvoDelivery_Assemble_Reading);case 33735: this.data = (byte[])pA_VolvoDelivery_Assemble_Reading.getValue(); pA_GeelyHSWD_Reading = new PATypes.PA_GeelyHSWD_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_GeelyHSWD_Reading(pA_GeelyHSWD_Reading);case 33734: this.data = (byte[])pA_GeelyHSWD_Reading.getValue(); pA_Geely_Delivery_Assemble_Reading = new PATypes.PA_Geely_Delivery_Assemble_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_Geely_Delivery_Assemble_Reading(pA_Geely_Delivery_Assemble_Reading);case 33733: this.data = (byte[])pA_Geely_Delivery_Assemble_Reading.getValue(); pA_HW_Version_Reading = new PATypes.PA_HW_Version_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_HW_Version_Reading(pA_HW_Version_Reading);case 33732: this.data = (byte[])pA_HW_Version_Reading.getValue(); pA_IHUID_Reading = new PATypes.PA_IHUID_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_IHUID_Reading(pA_IHUID_Reading);case 33731: this.data = (byte[])pA_IHUID_Reading.getValue(); pA_XDSN_Reading = new PATypes.PA_XDSN_Reading(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_XDSN_Reading(pA_XDSN_Reading);case 33730: this.data = (byte[])pA_XDSN_Reading.getValue(); pA_Product_Serial_Number = new PATypes.PA_Product_Serial_Number(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_Product_Serial_Number(pA_Product_Serial_Number);case 33729: this.data = (byte[])pA_Product_Serial_Number.getValue(); pA_Dcm_D912_PSD_MONITOR_EN = new PATypes.PA_Dcm_D912_PSD_MONITOR_EN(); arrayOfByte110 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte110)); onPA_Dcm_D912_PSD_MONITOR_EN(pA_Dcm_D912_PSD_MONITOR_EN);case 33728: this.data = (byte[])arrayOfByte110.getValue(); pA_Chat_Video_IN = new PATypes.PA_Chat_Video_IN(); arrayOfByte110 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte110)); onPA_Chat_Video_IN(pA_Chat_Video_IN);case 33727: this.data = (byte[])arrayOfByte110.getValue(); pA_Gesture_Video_IN = new PATypes.PA_Gesture_Video_IN(); arrayOfByte276 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte276)); onPA_Gesture_Video_IN(pA_Gesture_Video_IN);case 33726: this.data = (byte[])pA_Gesture_Video_IN.getValue(); pA_DVR_Video_IN = new PATypes.PA_DVR_Video_IN(); arrayOfByte109 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte109)); onPA_DVR_Video_IN(pA_DVR_Video_IN);case 33725: this.data = (byte[])arrayOfByte109.getValue(); pA_PASWAM_Video_in = new PATypes.PA_PASWAM_Video_in(); arrayOfByte109 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte109)); onPA_PASWAM_Video_in(pA_PASWAM_Video_in);case 33724: this.data = (byte[])arrayOfByte109.getValue(); pA_CSD_MONITOR_EN = new PATypes.PA_CSD_MONITOR_EN(); arrayOfByte275 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte275)); onPA_CSD_MONITOR_EN(pA_CSD_MONITOR_EN);case 33723: this.data = (byte[])pA_CSD_MONITOR_EN.getValue(); pA_DiagProxy_Psd_GW_Fun = new PATypes.PA_DiagProxy_Psd_GW_Fun(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DiagProxy_Psd_GW_Fun(pA_DiagProxy_Psd_GW_Fun);case 33722: this.data = (byte[])pA_DiagProxy_Psd_GW_Fun.getValue(); pA_DiagProxy_Psd_GW_Phy = new PATypes.PA_DiagProxy_Psd_GW_Phy(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DiagProxy_Psd_GW_Phy(pA_DiagProxy_Psd_GW_Phy);case 33721: this.data = (byte[])pA_DiagProxy_Psd_GW_Phy.getValue(); pA_DiagProxy_Csdm_GW_Fun = new PATypes.PA_DiagProxy_Csdm_GW_Fun(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DiagProxy_Csdm_GW_Fun(pA_DiagProxy_Csdm_GW_Fun);case 33720: this.data = (byte[])pA_DiagProxy_Csdm_GW_Fun.getValue(); pA_DiagProxy_Csdm_GW_Phy = new PATypes.PA_DiagProxy_Csdm_GW_Phy(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DiagProxy_Csdm_GW_Phy(pA_DiagProxy_Csdm_GW_Phy);case 33719: this.data = (byte[])pA_DiagProxy_Csdm_GW_Phy.getValue(); pA_DiagProxy_Csd_GW_Fun = new PATypes.PA_DiagProxy_Csd_GW_Fun(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DiagProxy_Csd_GW_Fun(pA_DiagProxy_Csd_GW_Fun);case 33718: this.data = (byte[])pA_DiagProxy_Csd_GW_Fun.getValue(); pA_DiagProxy_Csd_GW_Phy = new PATypes.PA_DiagProxy_Csd_GW_Phy(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DiagProxy_Csd_GW_Phy(pA_DiagProxy_Csd_GW_Phy);case 33717: this.data = (byte[])pA_DiagProxy_Csd_GW_Phy.getValue(); pA_DiagProxy_Status = new PATypes.PA_DiagProxy_Status(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DiagProxy_Status(pA_DiagProxy_Status);case 33716: this.data = (byte[])pA_DiagProxy_Status.getValue(); pA_HealthOfEngOil = new PATypes.PA_HealthOfEngOil(); arrayOfByte108 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte108)); onPA_HealthOfEngOil(pA_HealthOfEngOil);case 33715: this.data = (byte[])arrayOfByte108.getValue(); pA_NatUsgDayOfOil = new PATypes.PA_NatUsgDayOfOil(); arrayOfByte108 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte108)); onPA_NatUsgDayOfOil(pA_NatUsgDayOfOil);case 33714: this.data = (byte[])arrayOfByte108.getValue(); pA_DstTrvldOfEng = new PATypes.PA_DstTrvldOfEng(); arrayOfByte274 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte274)); onPA_DstTrvldOfEng(pA_DstTrvldOfEng);case 33713: this.data = (byte[])pA_DstTrvldOfEng.getValue(); pA_DstTrvldOfEV = new PATypes.PA_DstTrvldOfEV(); arrayOfByte274 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte274)); onPA_DstTrvldOfEV(pA_DstTrvldOfEV);case 33712: this.data = (byte[])pA_DstTrvldOfEV.getValue(); pA_DstTrvldAct = new PATypes.PA_DstTrvldAct(); arrayOfByte274 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte274)); onPA_DstTrvldAct(pA_DstTrvldAct);case 33711: this.data = (byte[])pA_DstTrvldAct.getValue(); pA_ServiceReminderType = new PATypes.PA_ServiceReminderType(); arrayOfByte274 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte274)); onPA_ServiceReminderType(pA_ServiceReminderType);case 33710: this.data = (byte[])pA_ServiceReminderType.getValue(); pA_Locking_ApproachToOpenTrSwt = new PATypes.PA_Locking_ApproachToOpenTrSwt(); arrayOfByte107 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte107)); onPA_Locking_ApproachToOpenTrSwt(pA_Locking_ApproachToOpenTrSwt);case 33709: this.data = (byte[])arrayOfByte107.getValue(); pA_DoubleLock = new PATypes.PA_DoubleLock(); arrayOfByte273 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte273)); onPA_DoubleLock(pA_DoubleLock);case 33708: this.data = (byte[])pA_DoubleLock.getValue(); pA_RearMirrors = new PATypes.PA_RearMirrors(); arrayOfByte106 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte106)); onPA_RearMirrors(pA_RearMirrors);case 33707: this.data = (byte[])arrayOfByte106.getValue(); pA_UnlckTrunk = new PATypes.PA_UnlckTrunk(); arrayOfByte106 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte106)); onPA_UnlckTrunk(pA_UnlckTrunk);case 33706: this.data = (byte[])arrayOfByte106.getValue(); pA_LifeDetectionSwitch = new PATypes.PA_LifeDetectionSwitch(); arrayOfByte106 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte106)); onPA_LifeDetectionSwitch(pA_LifeDetectionSwitch);case 33705: this.data = (byte[])arrayOfByte106.getValue(); pA_PowerFlow_HEV = new PATypes.PA_PowerFlow_HEV(); arrayOfByte106 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte106)); onPA_PowerFlow_HEV(pA_PowerFlow_HEV);case 33704: this.data = (byte[])arrayOfByte106.getValue(); pA_IntelligentFuSave = new PATypes.PA_IntelligentFuSave(); arrayOfByte106 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte106)); onPA_IntelligentFuSave(pA_IntelligentFuSave);case 33703: this.data = (byte[])arrayOfByte106.getValue(); pA_TripCom_RstAEC = new PATypes.PA_TripCom_RstAEC(); arrayOfByte272 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte272)); onPA_TripCom_RstAEC(pA_TripCom_RstAEC);case 33702: this.data = (byte[])pA_TripCom_RstAEC.getValue(); pA_TripCom_RstAFC = new PATypes.PA_TripCom_RstAFC(); arrayOfByte272 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte272)); onPA_TripCom_RstAFC(pA_TripCom_RstAFC);case 33701: this.data = (byte[])pA_TripCom_RstAFC.getValue(); pA_TripCom_RstEDT = new PATypes.PA_TripCom_RstEDT(); arrayOfByte105 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte105)); onPA_TripCom_RstEDT(pA_TripCom_RstEDT);case 33700: this.data = (byte[])arrayOfByte105.getValue(); pA_TripCom_RstAVS = new PATypes.PA_TripCom_RstAVS(); arrayOfByte271 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte271)); onPA_TripCom_RstAVS(pA_TripCom_RstAVS);case 33699: this.data = (byte[])pA_TripCom_RstAVS.getValue(); pA_TripCom_RstTrip = new PATypes.PA_TripCom_RstTrip(); arrayOfByte104 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte104)); onPA_TripCom_RstTrip(pA_TripCom_RstTrip);case 33698: this.data = (byte[])arrayOfByte104.getValue(); pA_TripCom_RetALL = new PATypes.PA_TripCom_RetALL(); arrayOfByte104 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte104)); onPA_TripCom_RetALL(pA_TripCom_RetALL);case 33697: this.data = (byte[])arrayOfByte104.getValue(); pA_RefuleAutoResetSetting = new PATypes.PA_RefuleAutoResetSetting(); arrayOfByte270 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte270)); onPA_RefuleAutoResetSetting(pA_RefuleAutoResetSetting);case 33696: this.data = (byte[])pA_RefuleAutoResetSetting.getValue(); pA_ParkingAutoResetSetting = new PATypes.PA_ParkingAutoResetSetting(); arrayOfByte270 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte270)); onPA_ParkingAutoResetSetting(pA_ParkingAutoResetSetting);case 33695: this.data = (byte[])pA_ParkingAutoResetSetting.getValue(); pA_VINDiffMsg = new PATypes.PA_VINDiffMsg(); arrayOfByte103 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte103)); onPA_VINDiffMsg(pA_VINDiffMsg);case 33694: this.data = (byte[])arrayOfByte103.getValue(); pA_CollectionRadio = new PATypes.PA_CollectionRadio(); arrayOfByte269 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte269)); onPA_CollectionRadio(pA_CollectionRadio);case 33693: this.data = (byte[])pA_CollectionRadio.getValue(); pA_SourceSwitch = new PATypes.PA_SourceSwitch(); arrayOfByte102 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte102)); onPA_SourceSwitch(pA_SourceSwitch);case 33692: this.data = (byte[])arrayOfByte102.getValue(); pA_NaviHome = new PATypes.PA_NaviHome(); arrayOfByte268 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte268)); onPA_NaviHome(pA_NaviHome);case 33691: this.data = (byte[])pA_NaviHome.getValue(); pA_360Panorama = new PATypes.PA_360Panorama(); arrayOfByte101 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte101)); onPA_360Panorama(pA_360Panorama);case 33690: this.data = (byte[])arrayOfByte101.getValue(); pA_DVR = new PATypes.PA_DVR(); arrayOfByte267 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte267)); onPA_DVR(pA_DVR);case 33689: this.data = (byte[])pA_DVR.getValue(); pA_ScreenSwitch = new PATypes.PA_ScreenSwitch(); arrayOfByte100 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte100)); onPA_ScreenSwitch(pA_ScreenSwitch);case 33688: this.data = (byte[])arrayOfByte100.getValue(); pA_SelfDefineFuncReq = new PATypes.PA_SelfDefineFuncReq(); arrayOfByte266 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte266)); onPA_SelfDefineFuncReq(pA_SelfDefineFuncReq);case 33687: this.data = (byte[])pA_SelfDefineFuncReq.getValue(); pA_TailgateSts = new PATypes.PA_TailgateSts(); arrayOfByte99 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte99)); onPA_TailgateSts(pA_TailgateSts);case 33686: this.data = (byte[])arrayOfByte99.getValue(); pA_ElectricTailgate_PosSetting = new PATypes.PA_ElectricTailgate_PosSetting(); arrayOfByte99 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte99)); onPA_ElectricTailgate_PosSetting(pA_ElectricTailgate_PosSetting);case 33685: this.data = (byte[])arrayOfByte99.getValue(); pA_ElectricTailgate_OpenBtn = new PATypes.PA_ElectricTailgate_OpenBtn(); arrayOfByte99 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte99)); onPA_ElectricTailgate_OpenBtn(pA_ElectricTailgate_OpenBtn);case 33684: this.data = (byte[])arrayOfByte99.getValue(); pA_ElectricTailgate_Setting = new PATypes.PA_ElectricTailgate_Setting(); arrayOfByte265 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte265)); onPA_ElectricTailgate_Setting(pA_ElectricTailgate_Setting);case 33683: this.data = (byte[])pA_ElectricTailgate_Setting.getValue(); pA_ChangeFailMsg = new PATypes.PA_ChangeFailMsg(); arrayOfByte265 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte265)); onPA_ChangeFailMsg(pA_ChangeFailMsg);case 33682: this.data = (byte[])pA_ChangeFailMsg.getValue(); pA_Battery_Charge_Percent = new PATypes.PA_Battery_Charge_Percent(); arrayOfByte98 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte98)); onPA_Battery_Charge_Percent(pA_Battery_Charge_Percent);case 33681: this.data = (byte[])arrayOfByte98.getValue(); pA_PM_Charge = new PATypes.PA_PM_Charge(); arrayOfByte98 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte98)); onPA_PM_Charge(pA_PM_Charge);case 33680: this.data = (byte[])arrayOfByte98.getValue(); pA_PM_Hold = new PATypes.PA_PM_Hold(); arrayOfByte98 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte98)); onPA_PM_Hold(pA_PM_Hold);case 33679: this.data = (byte[])arrayOfByte98.getValue(); pA_ElecSeatbelt_Passenger = new PATypes.PA_ElecSeatbelt_Passenger(); arrayOfByte98 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte98)); onPA_ElecSeatbelt_Passenger(pA_ElecSeatbelt_Passenger);case 33678: this.data = (byte[])arrayOfByte98.getValue(); pA_ElecSeatbelt_Driver = new PATypes.PA_ElecSeatbelt_Driver(); arrayOfByte98 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte98)); onPA_ElecSeatbelt_Driver(pA_ElecSeatbelt_Driver);case 33677: this.data = (byte[])arrayOfByte98.getValue(); pA_CSDTheme_Setting = new PATypes.PA_CSDTheme_Setting(); arrayOfByte264 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte264)); onPA_CSDTheme_Setting(pA_CSDTheme_Setting);case 33676: this.data = (byte[])pA_CSDTheme_Setting.getValue(); pA_DIMTheme_DrvSetting = new PATypes.PA_DIMTheme_DrvSetting(); arrayOfByte264 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte264)); onPA_DIMTheme_DrvSetting(pA_DIMTheme_DrvSetting);case 33675: this.data = (byte[])pA_DIMTheme_DrvSetting.getValue(); pA_Individualtheme_OnOff = new PATypes.PA_Individualtheme_OnOff(); arrayOfByte97 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte97)); onPA_Individualtheme_OnOff(pA_Individualtheme_OnOff);case 33674: this.data = (byte[])arrayOfByte97.getValue(); pA_LockgFbSoundSet = new PATypes.PA_LockgFbSoundSet(); arrayOfByte263 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte263)); onPA_LockgFbSoundSet(pA_LockgFbSoundSet);case 33673: this.data = (byte[])pA_LockgFbSoundSet.getValue(); pA_TwoStepUnlck_Setting = new PATypes.PA_TwoStepUnlck_Setting(); arrayOfByte96 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte96)); onPA_TwoStepUnlck_Setting(pA_TwoStepUnlck_Setting);case 33672: this.data = (byte[])arrayOfByte96.getValue(); pA_PasAcsLock_Setting = new PATypes.PA_PasAcsLock_Setting(); arrayOfByte262 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte262)); onPA_PasAcsLock_Setting(pA_PasAcsLock_Setting);case 33671: this.data = (byte[])pA_PasAcsLock_Setting.getValue(); pA_UnLockSetting = new PATypes.PA_UnLockSetting(); arrayOfByte262 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte262)); onPA_UnLockSetting(pA_UnLockSetting);case 33670: this.data = (byte[])pA_UnLockSetting.getValue(); pA_PowerFlow_MHEV = new PATypes.PA_PowerFlow_MHEV(); arrayOfByte262 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte262)); onPA_PowerFlow_MHEV(pA_PowerFlow_MHEV);case 33669: this.data = (byte[])pA_PowerFlow_MHEV.getValue(); pA_PowerFlow = new PATypes.PA_PowerFlow(); arrayOfByte262 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte262)); onPA_PowerFlow(pA_PowerFlow);case 33668: this.data = (byte[])pA_PowerFlow.getValue(); pA_SailingSwitch = new PATypes.PA_SailingSwitch(); arrayOfByte95 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte95)); onPA_SailingSwitch(pA_SailingSwitch);case 33667: this.data = (byte[])arrayOfByte95.getValue(); pA_SpeedWarnSpeedLimit = new PATypes.PA_SpeedWarnSpeedLimit(); arrayOfByte95 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte95)); onPA_SpeedWarnSpeedLimit(pA_SpeedWarnSpeedLimit);case 33666: this.data = (byte[])arrayOfByte95.getValue(); pA_SpeedWarnOnOff = new PATypes.PA_SpeedWarnOnOff(); arrayOfByte95 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte95)); onPA_SpeedWarnOnOff(pA_SpeedWarnOnOff);case 33665: this.data = (byte[])arrayOfByte95.getValue(); pA_LowAlarmVolSet = new PATypes.PA_LowAlarmVolSet(); arrayOfByte95 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte95)); onPA_LowAlarmVolSet(pA_LowAlarmVolSet);case 33664: this.data = (byte[])arrayOfByte95.getValue(); pA_SpeedWarnSet = new PATypes.PA_SpeedWarnSet(); arrayOfByte95 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte95)); onPA_SpeedWarnSet(pA_SpeedWarnSet);case 33663: this.data = (byte[])arrayOfByte95.getValue(); pA_External_Sound_Setting = new PATypes.PA_External_Sound_Setting(); arrayOfByte261 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte261)); onPA_External_Sound_Setting(pA_External_Sound_Setting);case 33662: this.data = (byte[])pA_External_Sound_Setting.getValue(); pA_Total_Traveled_Distance = new PATypes.PA_Total_Traveled_Distance(); arrayOfByte94 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte94)); onPA_Total_Traveled_Distance(pA_Total_Traveled_Distance);case 33661: this.data = (byte[])arrayOfByte94.getValue(); pA_AutoHoldStatus = new PATypes.PA_AutoHoldStatus(); arrayOfByte260 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte260)); onPA_AutoHoldStatus(pA_AutoHoldStatus);case 33660: this.data = (byte[])pA_AutoHoldStatus.getValue(); pA_EPBAutoApply = new PATypes.PA_EPBAutoApply(); arrayOfByte93 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte93)); onPA_EPBAutoApply(pA_EPBAutoApply);case 33659: this.data = (byte[])arrayOfByte93.getValue(); pA_SuspMoveDirInform = new PATypes.PA_SuspMoveDirInform(); arrayOfByte93 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte93)); onPA_SuspMoveDirInform(pA_SuspMoveDirInform);case 33658: this.data = (byte[])arrayOfByte93.getValue(); pA_SuspHeiSetting = new PATypes.PA_SuspHeiSetting(); arrayOfByte259 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte259)); onPA_SuspHeiSetting(pA_SuspHeiSetting);case 33657: this.data = (byte[])pA_SuspHeiSetting.getValue(); pA_DeacLevCtrSetting = new PATypes.PA_DeacLevCtrSetting(); arrayOfByte92 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte92)); onPA_DeacLevCtrSetting(pA_DeacLevCtrSetting);case 33656: this.data = (byte[])arrayOfByte92.getValue(); pA_EasyEntrySetting = new PATypes.PA_EasyEntrySetting(); arrayOfByte258 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte258)); onPA_EasyEntrySetting(pA_EasyEntrySetting);case 33655: this.data = (byte[])pA_EasyEntrySetting.getValue(); pA_HillDescentSetting = new PATypes.PA_HillDescentSetting(); arrayOfByte91 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte91)); onPA_HillDescentSetting(pA_HillDescentSetting);case 33654: this.data = (byte[])arrayOfByte91.getValue(); pA_MirrTiltSetg = new PATypes.PA_MirrTiltSetg(); arrayOfByte257 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte257)); onPA_MirrTiltSetg(pA_MirrTiltSetg);case 33653: this.data = (byte[])pA_MirrTiltSetg.getValue(); pA_RearMirrorFold_Auto = new PATypes.PA_RearMirrorFold_Auto(); arrayOfByte90 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte90)); onPA_RearMirrorFold_Auto(pA_RearMirrorFold_Auto);case 33652: this.data = (byte[])arrayOfByte90.getValue(); pA_WelGoodbyeLightMod = new PATypes.PA_WelGoodbyeLightMod(); arrayOfByte90 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte90)); onPA_WelGoodbyeLightMod(pA_WelGoodbyeLightMod);case 33651: this.data = (byte[])arrayOfByte90.getValue(); pA_WelGoodbyeLightSwitch = new PATypes.PA_WelGoodbyeLightSwitch(); arrayOfByte90 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte90)); onPA_WelGoodbyeLightSwitch(pA_WelGoodbyeLightSwitch);case 33650: this.data = (byte[])arrayOfByte90.getValue(); pA_LeftRightSetting = new PATypes.PA_LeftRightSetting(); arrayOfByte90 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte90)); onPA_LeftRightSetting(pA_LeftRightSetting);case 33649: this.data = (byte[])arrayOfByte90.getValue(); pA_BendingLight = new PATypes.PA_BendingLight(); arrayOfByte256 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte256)); onPA_BendingLight(pA_BendingLight);case 33648: this.data = (byte[])pA_BendingLight.getValue(); pA_ApproachLightOnOff_Setting = new PATypes.PA_ApproachLightOnOff_Setting(); arrayOfByte256 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte256)); onPA_ApproachLightOnOff_Setting(pA_ApproachLightOnOff_Setting);case 33647: this.data = (byte[])pA_ApproachLightOnOff_Setting.getValue(); pA_AL_HomeSafeLight = new PATypes.PA_AL_HomeSafeLight(); arrayOfByte256 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte256)); onPA_AL_HomeSafeLight(pA_AL_HomeSafeLight);case 33646: this.data = (byte[])pA_AL_HomeSafeLight.getValue(); pA_CornrgLi_Setting = new PATypes.PA_CornrgLi_Setting(); arrayOfByte256 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte256)); onPA_CornrgLi_Setting(pA_CornrgLi_Setting);case 33645: this.data = (byte[])pA_CornrgLi_Setting.getValue(); pA_AFSLight_Setting = new PATypes.PA_AFSLight_Setting(); arrayOfByte89 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte89)); onPA_AFSLight_Setting(pA_AFSLight_Setting);case 33644: this.data = (byte[])arrayOfByte89.getValue(); pA_PBC_ESCSportActiv = new PATypes.PA_PBC_ESCSportActiv(); arrayOfByte255 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte255)); onPA_PBC_ESCSportActiv(pA_PBC_ESCSportActiv);case 33643: this.data = (byte[])pA_PBC_ESCSportActiv.getValue(); pA_SS_Activation = new PATypes.PA_SS_Activation(); arrayOfByte88 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte88)); onPA_SS_Activation(pA_SS_Activation);case 33642: this.data = (byte[])arrayOfByte88.getValue(); pA_SteeringWheelPosAdj = new PATypes.PA_SteeringWheelPosAdj(); arrayOfByte254 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte254)); onPA_SteeringWheelPosAdj(pA_SteeringWheelPosAdj);case 33641: this.data = (byte[])pA_SteeringWheelPosAdj.getValue(); pA_Steer_SteeringMod = new PATypes.PA_Steer_SteeringMod(); arrayOfByte254 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte254)); onPA_Steer_SteeringMod(pA_Steer_SteeringMod);case 33640: this.data = (byte[])pA_Steer_SteeringMod.getValue(); pA_Steer_SteerAsscLvl = new PATypes.PA_Steer_SteerAsscLvl(); arrayOfByte254 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte254)); onPA_Steer_SteerAsscLvl(pA_Steer_SteerAsscLvl);case 33639: this.data = (byte[])pA_Steer_SteerAsscLvl.getValue(); pA_FindCaReminder_Setting = new PATypes.PA_FindCaReminder_Setting(); arrayOfByte87 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte87)); onPA_FindCaReminder_Setting(pA_FindCaReminder_Setting);case 33638: this.data = (byte[])arrayOfByte87.getValue(); pA_UUN_RedGuardSts = new PATypes.PA_UUN_RedGuardSts(); arrayOfByte87 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte87)); onPA_UUN_RedGuardSts(pA_UUN_RedGuardSts);case 33637: this.data = (byte[])arrayOfByte87.getValue(); pA_UUN_PasArmngSts = new PATypes.PA_UUN_PasArmngSts(); arrayOfByte87 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte87)); onPA_UUN_PasArmngSts(pA_UUN_PasArmngSts);case 33636: this.data = (byte[])arrayOfByte87.getValue(); pA_WPC_PhoneForget = new PATypes.PA_WPC_PhoneForget(); arrayOfByte87 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte87)); onPA_WPC_PhoneForget(pA_WPC_PhoneForget);case 33635: this.data = (byte[])arrayOfByte87.getValue(); pA_WPC_InchargeStatus = new PATypes.PA_WPC_InchargeStatus(); arrayOfByte253 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte253)); onPA_WPC_InchargeStatus(pA_WPC_InchargeStatus);case 33634: this.data = (byte[])pA_WPC_InchargeStatus.getValue(); pA_WPC_Setting = new PATypes.PA_WPC_Setting(); arrayOfByte86 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte86)); onPA_WPC_Setting(pA_WPC_Setting);case 33633: this.data = (byte[])arrayOfByte86.getValue(); pA_PassSeatSwtSelnOfSpplFctSts = new PATypes.PA_PassSeatSwtSelnOfSpplFctSts(); arrayOfByte252 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte252)); onPA_PassSeatSwtSelnOfSpplFctSts(pA_PassSeatSwtSelnOfSpplFctSts);case 33632: this.data = (byte[])pA_PassSeatSwtSelnOfSpplFctSts.getValue(); pA_DrvrSeatSwtSelnOfSpplFctSts = new PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts(); arrayOfByte252 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte252)); onPA_DrvrSeatSwtSelnOfSpplFctSts(pA_DrvrSeatSwtSelnOfSpplFctSts);case 33631: this.data = (byte[])pA_DrvrSeatSwtSelnOfSpplFctSts.getValue(); pA_HotStoneMassagePassAllowd = new PATypes.PA_HotStoneMassagePassAllowd(); arrayOfByte85 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte85)); onPA_HotStoneMassagePassAllowd(pA_HotStoneMassagePassAllowd);case 33630: this.data = (byte[])arrayOfByte85.getValue(); pA_HotStoneMassageDrvrAllowd = new PATypes.PA_HotStoneMassageDrvrAllowd(); arrayOfByte251 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte251)); onPA_HotStoneMassageDrvrAllowd(pA_HotStoneMassageDrvrAllowd);case 33629: this.data = (byte[])pA_HotStoneMassageDrvrAllowd.getValue(); pA_SeatRowSecRiSwtStsPassSeatSwtInclSts = new PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts(); arrayOfByte251 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte251)); onPA_SeatRowSecRiSwtStsPassSeatSwtInclSts(pA_SeatRowSecRiSwtStsPassSeatSwtInclSts);case 33628: this.data = (byte[])pA_SeatRowSecRiSwtStsPassSeatSwtInclSts.getValue(); pA_SeatRowSecLeSwtStsPassSeatSwtInclSts = new PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts(); arrayOfByte251 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte251)); onPA_SeatRowSecLeSwtStsPassSeatSwtInclSts(pA_SeatRowSecLeSwtStsPassSeatSwtInclSts);case 33627: this.data = (byte[])pA_SeatRowSecLeSwtStsPassSeatSwtInclSts.getValue(); pA_SecRowSeatInclRiFwdBackwAllowd = new PATypes.PA_SecRowSeatInclRiFwdBackwAllowd(); arrayOfByte84 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte84)); onPA_SecRowSeatInclRiFwdBackwAllowd(pA_SecRowSeatInclRiFwdBackwAllowd);case 33626: this.data = (byte[])arrayOfByte84.getValue(); pA_SecRowSeatInclLeFwdBackwAllowd = new PATypes.PA_SecRowSeatInclLeFwdBackwAllowd(); arrayOfByte250 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte250)); onPA_SecRowSeatInclLeFwdBackwAllowd(pA_SecRowSeatInclLeFwdBackwAllowd);case 33625: this.data = (byte[])pA_SecRowSeatInclLeFwdBackwAllowd.getValue(); pA_SeatRowSecRiSwtStsPassSeatSwtSldSts = new PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts(); arrayOfByte83 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte83)); onPA_SeatRowSecRiSwtStsPassSeatSwtSldSts(pA_SeatRowSecRiSwtStsPassSeatSwtSldSts);case 33624: this.data = (byte[])arrayOfByte83.getValue(); pA_SecRowSeatLenRiFwdBackwAllowd = new PATypes.PA_SecRowSeatLenRiFwdBackwAllowd(); arrayOfByte249 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte249)); onPA_SecRowSeatLenRiFwdBackwAllowd(pA_SecRowSeatLenRiFwdBackwAllowd);case 33623: this.data = (byte[])pA_SecRowSeatLenRiFwdBackwAllowd.getValue(); pA_SeatRowSecLeSwtStsPassSeatSwtSldSts = new PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts(); arrayOfByte249 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte249)); onPA_SeatRowSecLeSwtStsPassSeatSwtSldSts(pA_SeatRowSecLeSwtStsPassSeatSwtSldSts);case 33622: this.data = (byte[])pA_SeatRowSecLeSwtStsPassSeatSwtSldSts.getValue(); pA_SecRowSeatLenLeFwdBackwAllowd = new PATypes.PA_SecRowSeatLenLeFwdBackwAllowd(); arrayOfByte82 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte82)); onPA_SecRowSeatLenLeFwdBackwAllowd(pA_SecRowSeatLenLeFwdBackwAllowd);case 33621: this.data = (byte[])arrayOfByte82.getValue(); pA_SeatFoldRaiseRowThrdRiAllowd = new PATypes.PA_SeatFoldRaiseRowThrdRiAllowd(); arrayOfByte82 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte82)); onPA_SeatFoldRaiseRowThrdRiAllowd(pA_SeatFoldRaiseRowThrdRiAllowd);case 33620: this.data = (byte[])arrayOfByte82.getValue(); pA_SeatFoldRaiseRowThrdLeAllowd = new PATypes.PA_SeatFoldRaiseRowThrdLeAllowd(); arrayOfByte82 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte82)); onPA_SeatFoldRaiseRowThrdLeAllowd(pA_SeatFoldRaiseRowThrdLeAllowd);case 33619: this.data = (byte[])arrayOfByte82.getValue(); pA_PassMultFuncMenuExt = new PATypes.PA_PassMultFuncMenuExt(); arrayOfByte82 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte82)); onPA_PassMultFuncMenuExt(pA_PassMultFuncMenuExt);case 33618: this.data = (byte[])arrayOfByte82.getValue(); pA_DrvrMultFuncMenuExt = new PATypes.PA_DrvrMultFuncMenuExt(); arrayOfByte248 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte248)); onPA_DrvrMultFuncMenuExt(pA_DrvrMultFuncMenuExt);case 33617: this.data = (byte[])pA_DrvrMultFuncMenuExt.getValue(); pA_PassMassgRunng = new PATypes.PA_PassMassgRunng(); arrayOfByte81 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte81)); onPA_PassMassgRunng(pA_PassMassgRunng);case 33616: this.data = (byte[])arrayOfByte81.getValue(); pA_DrvrMassgRunng = new PATypes.PA_DrvrMassgRunng(); arrayOfByte81 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte81)); onPA_DrvrMassgRunng(pA_DrvrMassgRunng);case 33615: this.data = (byte[])arrayOfByte81.getValue(); pA_PassSeatDispMassgFct_MassgInten = new PATypes.PA_PassSeatDispMassgFct_MassgInten(); arrayOfByte247 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte247)); onPA_PassSeatDispMassgFct_MassgInten(pA_PassSeatDispMassgFct_MassgInten);case 33614: this.data = (byte[])pA_PassSeatDispMassgFct_MassgInten.getValue(); pA_PassSeatDispMassgFct_MassgProg = new PATypes.PA_PassSeatDispMassgFct_MassgProg(); arrayOfByte80 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte80)); onPA_PassSeatDispMassgFct_MassgProg(pA_PassSeatDispMassgFct_MassgProg);case 33613: this.data = (byte[])arrayOfByte80.getValue(); pA_PassSeatDispMassgFct_OnOff = new PATypes.PA_PassSeatDispMassgFct_OnOff(); arrayOfByte80 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte80)); onPA_PassSeatDispMassgFct_OnOff(pA_PassSeatDispMassgFct_OnOff);case 33612: this.data = (byte[])arrayOfByte80.getValue(); pA_PassSeatMassageStsAllowd = new PATypes.PA_PassSeatMassageStsAllowd(); arrayOfByte246 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte246)); onPA_PassSeatMassageStsAllowd(pA_PassSeatMassageStsAllowd);case 33611: this.data = (byte[])pA_PassSeatMassageStsAllowd.getValue(); pA_DrvrSeatDispMassgFct_MassgInten = new PATypes.PA_DrvrSeatDispMassgFct_MassgInten(); arrayOfByte246 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte246)); onPA_DrvrSeatDispMassgFct_MassgInten(pA_DrvrSeatDispMassgFct_MassgInten);case 33610: this.data = (byte[])pA_DrvrSeatDispMassgFct_MassgInten.getValue(); pA_DrvrSeatDispMassgFct_MassgProg = new PATypes.PA_DrvrSeatDispMassgFct_MassgProg(); arrayOfByte246 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte246)); onPA_DrvrSeatDispMassgFct_MassgProg(pA_DrvrSeatDispMassgFct_MassgProg);case 33609: this.data = (byte[])pA_DrvrSeatDispMassgFct_MassgProg.getValue(); pA_DrvrSeatDispMassgFct_OnOff = new PATypes.PA_DrvrSeatDispMassgFct_OnOff(); arrayOfByte246 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte246)); onPA_DrvrSeatDispMassgFct_OnOff(pA_DrvrSeatDispMassgFct_OnOff);case 33608: this.data = (byte[])pA_DrvrSeatDispMassgFct_OnOff.getValue(); pA_DrvrSeatMassageStsAllowd = new PATypes.PA_DrvrSeatMassageStsAllowd(); arrayOfByte79 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte79)); onPA_DrvrSeatMassageStsAllowd(pA_DrvrSeatMassageStsAllowd);case 33607: this.data = (byte[])arrayOfByte79.getValue(); pA_PassSeatCushExtStsAllowd = new PATypes.PA_PassSeatCushExtStsAllowd(); arrayOfByte79 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte79)); onPA_PassSeatCushExtStsAllowd(pA_PassSeatCushExtStsAllowd);case 33606: this.data = (byte[])arrayOfByte79.getValue(); pA_DrvrSeatCushExtStsAllowd = new PATypes.PA_DrvrSeatCushExtStsAllowd(); arrayOfByte79 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte79)); onPA_DrvrSeatCushExtStsAllowd(pA_DrvrSeatCushExtStsAllowd);case 33605: this.data = (byte[])arrayOfByte79.getValue(); pA_PassSeatSideUpDownStsAllowd = new PATypes.PA_PassSeatSideUpDownStsAllowd(); arrayOfByte245 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte245)); onPA_PassSeatSideUpDownStsAllowd(pA_PassSeatSideUpDownStsAllowd);case 33604: this.data = (byte[])pA_PassSeatSideUpDownStsAllowd.getValue(); pA_DrvrSeatSideUpDownStsAllowd = new PATypes.PA_DrvrSeatSideUpDownStsAllowd(); arrayOfByte245 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte245)); onPA_DrvrSeatSideUpDownStsAllowd(pA_DrvrSeatSideUpDownStsAllowd);case 33603: this.data = (byte[])pA_DrvrSeatSideUpDownStsAllowd.getValue(); pA_PassSeatSideFwdBackwStsAllowd = new PATypes.PA_PassSeatSideFwdBackwStsAllowd(); arrayOfByte78 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte78)); onPA_PassSeatSideFwdBackwStsAllowd(pA_PassSeatSideFwdBackwStsAllowd);case 33602: this.data = (byte[])arrayOfByte78.getValue(); pA_DrvrSeatSideFwdBackwStsAllowd = new PATypes.PA_DrvrSeatSideFwdBackwStsAllowd(); arrayOfByte78 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte78)); onPA_DrvrSeatSideFwdBackwStsAllowd(pA_DrvrSeatSideFwdBackwStsAllowd);case 33601: this.data = (byte[])arrayOfByte78.getValue(); pA_PassSeatLmbrUpDownStsAllowd = new PATypes.PA_PassSeatLmbrUpDownStsAllowd(); arrayOfByte78 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte78)); onPA_PassSeatLmbrUpDownStsAllowd(pA_PassSeatLmbrUpDownStsAllowd);case 33600: this.data = (byte[])arrayOfByte78.getValue(); pA_PassSeatLmbrFwdBackwStsAllowd = new PATypes.PA_PassSeatLmbrFwdBackwStsAllowd(); arrayOfByte78 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte78)); onPA_PassSeatLmbrFwdBackwStsAllowd(pA_PassSeatLmbrFwdBackwStsAllowd);case 33599: this.data = (byte[])arrayOfByte78.getValue(); pA_DrvrSeatLmbrUpDownStsAllowd = new PATypes.PA_DrvrSeatLmbrUpDownStsAllowd(); arrayOfByte244 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte244)); onPA_DrvrSeatLmbrUpDownStsAllowd(pA_DrvrSeatLmbrUpDownStsAllowd);case 33598: this.data = (byte[])pA_DrvrSeatLmbrUpDownStsAllowd.getValue(); pA_DrvrSeatLmbrFwdBackwStsAllowd = new PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd(); arrayOfByte77 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte77)); onPA_DrvrSeatLmbrFwdBackwStsAllowd(pA_DrvrSeatLmbrFwdBackwStsAllowd);case 33597: this.data = (byte[])arrayOfByte77.getValue(); pA_PassSeatSwtAdjmtOfSpplFctHozlSts = new PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts(); arrayOfByte77 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte77)); onPA_PassSeatSwtAdjmtOfSpplFctHozlSts(pA_PassSeatSwtAdjmtOfSpplFctHozlSts);case 33596: this.data = (byte[])arrayOfByte77.getValue(); pA_PassSeatSwtAdjmtOfSpplFctVertSts = new PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts(); arrayOfByte243 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte243)); onPA_PassSeatSwtAdjmtOfSpplFctVertSts(pA_PassSeatSwtAdjmtOfSpplFctVertSts);case 33595: this.data = (byte[])pA_PassSeatSwtAdjmtOfSpplFctVertSts.getValue(); pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts = new PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts(); arrayOfByte76 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte76)); onPA_DrvrSeatSwtAdjmtOfSpplFctHozlSts(pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts);case 33594: this.data = (byte[])arrayOfByte76.getValue(); pA_DrvrSeatSwtAdjmtOfSpplFctVertSts = new PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts(); arrayOfByte76 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte76)); onPA_DrvrSeatSwtAdjmtOfSpplFctVertSts(pA_DrvrSeatSwtAdjmtOfSpplFctVertSts);case 33593: this.data = (byte[])arrayOfByte76.getValue(); pA_PassSeatActvSpplFct = new PATypes.PA_PassSeatActvSpplFct(); arrayOfByte76 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte76)); onPA_PassSeatActvSpplFct(pA_PassSeatActvSpplFct);case 33592: this.data = (byte[])arrayOfByte76.getValue(); pA_DrvrSeatActvSpplFct = new PATypes.PA_DrvrSeatActvSpplFct(); arrayOfByte242 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte242)); onPA_DrvrSeatActvSpplFct(pA_DrvrSeatActvSpplFct);case 33591: this.data = (byte[])pA_DrvrSeatActvSpplFct.getValue(); pA_EasyInOutDrvrSeatAdjmt = new PATypes.PA_EasyInOutDrvrSeatAdjmt(); arrayOfByte242 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte242)); onPA_EasyInOutDrvrSeatAdjmt(pA_EasyInOutDrvrSeatAdjmt);case 33590: this.data = (byte[])pA_EasyInOutDrvrSeatAdjmt.getValue(); pA_EasyInOutDrvrSeatAllowd = new PATypes.PA_EasyInOutDrvrSeatAllowd(); arrayOfByte242 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte242)); onPA_EasyInOutDrvrSeatAllowd(pA_EasyInOutDrvrSeatAllowd);case 33589: this.data = (byte[])pA_EasyInOutDrvrSeatAllowd.getValue(); pA_PassSeatSwtInclSts = new PATypes.PA_PassSeatSwtInclSts(); arrayOfByte242 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte242)); onPA_PassSeatSwtInclSts(pA_PassSeatSwtInclSts);case 33588: this.data = (byte[])pA_PassSeatSwtInclSts.getValue(); pA_PassSeatSwtInclStsAllowd = new PATypes.PA_PassSeatSwtInclStsAllowd(); arrayOfByte75 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte75)); onPA_PassSeatSwtInclStsAllowd(pA_PassSeatSwtInclStsAllowd);case 33587: this.data = (byte[])arrayOfByte75.getValue(); pA_DrvrSeatSwtInclSts = new PATypes.PA_DrvrSeatSwtInclSts(); arrayOfByte75 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte75)); onPA_DrvrSeatSwtInclSts(pA_DrvrSeatSwtInclSts);case 33586: this.data = (byte[])arrayOfByte75.getValue(); pA_DrvrSeatSwtInclStsAllowd = new PATypes.PA_DrvrSeatSwtInclStsAllowd(); arrayOfByte75 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte75)); onPA_DrvrSeatSwtInclStsAllowd(pA_DrvrSeatSwtInclStsAllowd);case 33585: this.data = (byte[])arrayOfByte75.getValue(); pA_PassSeatSwtHeiFrntSts = new PATypes.PA_PassSeatSwtHeiFrntSts(); arrayOfByte75 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte75)); onPA_PassSeatSwtHeiFrntSts(pA_PassSeatSwtHeiFrntSts);case 33584: this.data = (byte[])arrayOfByte75.getValue(); pA_PassSeatSwtHeiFrntStsAllowd = new PATypes.PA_PassSeatSwtHeiFrntStsAllowd(); arrayOfByte241 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte241)); onPA_PassSeatSwtHeiFrntStsAllowd(pA_PassSeatSwtHeiFrntStsAllowd);case 33583: this.data = (byte[])pA_PassSeatSwtHeiFrntStsAllowd.getValue(); pA_DrvrSeatSwtHeiFrntSts = new PATypes.PA_DrvrSeatSwtHeiFrntSts(); arrayOfByte241 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte241)); onPA_DrvrSeatSwtHeiFrntSts(pA_DrvrSeatSwtHeiFrntSts);case 33582: this.data = (byte[])pA_DrvrSeatSwtHeiFrntSts.getValue(); pA_DrvrSeatSwtHeiFrntStsAllowd = new PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd(); arrayOfByte74 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte74)); onPA_DrvrSeatSwtHeiFrntStsAllowd(pA_DrvrSeatSwtHeiFrntStsAllowd);case 33581: this.data = (byte[])arrayOfByte74.getValue(); pA_PassSeatSwtHeiSts = new PATypes.PA_PassSeatSwtHeiSts(); arrayOfByte240 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte240)); onPA_PassSeatSwtHeiSts(pA_PassSeatSwtHeiSts);case 33580: this.data = (byte[])pA_PassSeatSwtHeiSts.getValue(); pA_PassSeatSwtHeiStsAllowd = new PATypes.PA_PassSeatSwtHeiStsAllowd(); arrayOfByte240 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte240)); onPA_PassSeatSwtHeiStsAllowd(pA_PassSeatSwtHeiStsAllowd);case 33579: this.data = (byte[])pA_PassSeatSwtHeiStsAllowd.getValue(); pA_DrvrSeatSwtHeiSts = new PATypes.PA_DrvrSeatSwtHeiSts(); arrayOfByte73 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte73)); onPA_DrvrSeatSwtHeiSts(pA_DrvrSeatSwtHeiSts);case 33578: this.data = (byte[])arrayOfByte73.getValue(); pA_DrvrSeatSwtHeiStsAllowd = new PATypes.PA_DrvrSeatSwtHeiStsAllowd(); arrayOfByte239 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte239)); onPA_DrvrSeatSwtHeiStsAllowd(pA_DrvrSeatSwtHeiStsAllowd);case 33577: this.data = (byte[])pA_DrvrSeatSwtHeiStsAllowd.getValue(); pA_PassSeatSwtSldSts = new PATypes.PA_PassSeatSwtSldSts(); arrayOfByte72 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte72)); onPA_PassSeatSwtSldSts(pA_PassSeatSwtSldSts);case 33576: this.data = (byte[])arrayOfByte72.getValue(); pA_PassSeatExtAdjAllowd = new PATypes.PA_PassSeatExtAdjAllowd(); arrayOfByte238 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte238)); onPA_PassSeatExtAdjAllowd(pA_PassSeatExtAdjAllowd);case 33575: this.data = (byte[])pA_PassSeatExtAdjAllowd.getValue(); pA_DrvrSeatSwtSldSts = new PATypes.PA_DrvrSeatSwtSldSts(); arrayOfByte238 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte238)); onPA_DrvrSeatSwtSldSts(pA_DrvrSeatSwtSldSts);case 33574: this.data = (byte[])pA_DrvrSeatSwtSldSts.getValue(); pA_DrvrSeatExtAdjAllowd = new PATypes.PA_DrvrSeatExtAdjAllowd(); arrayOfByte71 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte71)); onPA_DrvrSeatExtAdjAllowd(pA_DrvrSeatExtAdjAllowd);case 33573: this.data = (byte[])arrayOfByte71.getValue(); pA_PAS_SnsrFltStsWarn = new PATypes.PA_PAS_SnsrFltStsWarn(); arrayOfByte71 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte71)); onPA_PAS_SnsrFltStsWarn(pA_PAS_SnsrFltStsWarn);case 33572: this.data = (byte[])arrayOfByte71.getValue(); pA_PEB_PrkgEmgyBrkSysSts = new PATypes.PA_PEB_PrkgEmgyBrkSysSts(); arrayOfByte237 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte237)); onPA_PEB_PrkgEmgyBrkSysSts(pA_PEB_PrkgEmgyBrkSysSts);case 33571: this.data = (byte[])pA_PEB_PrkgEmgyBrkSysSts.getValue(); pA_PEB_PrkgEmgBrkSysSwt = new PATypes.PA_PEB_PrkgEmgBrkSysSwt(); arrayOfByte237 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte237)); onPA_PEB_PrkgEmgBrkSysSwt(pA_PEB_PrkgEmgBrkSysSwt);case 33570: this.data = (byte[])pA_PEB_PrkgEmgBrkSysSwt.getValue(); pA_PAS_AudWarnOfSnsrParkAssiFrnt = new PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt(); arrayOfByte70 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte70)); onPA_PAS_AudWarnOfSnsrParkAssiFrnt(pA_PAS_AudWarnOfSnsrParkAssiFrnt);case 33569: this.data = (byte[])arrayOfByte70.getValue(); pA_PAS_AudWarnOfSnsrParkAssiRe = new PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe(); arrayOfByte70 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte70)); onPA_PAS_AudWarnOfSnsrParkAssiRe(pA_PAS_AudWarnOfSnsrParkAssiRe);case 33568: this.data = (byte[])arrayOfByte70.getValue(); pA_PAS_OutdRiOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt(); arrayOfByte70 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte70)); onPA_PAS_OutdRiOfSnsrPrkgAssiFrnt(pA_PAS_OutdRiOfSnsrPrkgAssiFrnt);case 33567: this.data = (byte[])arrayOfByte70.getValue(); pA_PAS_OutdLeOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt(); arrayOfByte236 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte236)); onPA_PAS_OutdLeOfSnsrPrkgAssiFrnt(pA_PAS_OutdLeOfSnsrPrkgAssiFrnt);case 33566: this.data = (byte[])pA_PAS_OutdLeOfSnsrPrkgAssiFrnt.getValue(); pA_PAS_InsdRiOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt(); arrayOfByte69 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte69)); onPA_PAS_InsdRiOfSnsrPrkgAssiFrnt(pA_PAS_InsdRiOfSnsrPrkgAssiFrnt);case 33565: this.data = (byte[])arrayOfByte69.getValue(); pA_PAS_InsdLeOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt(); arrayOfByte235 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte235)); onPA_PAS_InsdLeOfSnsrPrkgAssiFrnt(pA_PAS_InsdLeOfSnsrPrkgAssiFrnt);case 33564: this.data = (byte[])pA_PAS_InsdLeOfSnsrPrkgAssiFrnt.getValue(); pA_PAS_OutdRiOfSnsrPrkgAssiRe = new PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe(); arrayOfByte68 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte68)); onPA_PAS_OutdRiOfSnsrPrkgAssiRe(pA_PAS_OutdRiOfSnsrPrkgAssiRe);case 33563: this.data = (byte[])arrayOfByte68.getValue(); pA_PAS_OutdLeOfSnsrPrkgAssiRe = new PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe(); arrayOfByte68 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte68)); onPA_PAS_OutdLeOfSnsrPrkgAssiRe(pA_PAS_OutdLeOfSnsrPrkgAssiRe);case 33562: this.data = (byte[])arrayOfByte68.getValue(); pA_PAS_InsdRiOfSnsrPrkgAssiRe = new PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe(); arrayOfByte68 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte68)); onPA_PAS_InsdRiOfSnsrPrkgAssiRe(pA_PAS_InsdRiOfSnsrPrkgAssiRe);case 33561: this.data = (byte[])arrayOfByte68.getValue(); pA_PAS_InsdLeOfSnsrPrkgAssiRe = new PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe(); arrayOfByte234 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte234)); onPA_PAS_InsdLeOfSnsrPrkgAssiRe(pA_PAS_InsdLeOfSnsrPrkgAssiRe);case 33560: this.data = (byte[])pA_PAS_InsdLeOfSnsrPrkgAssiRe.getValue(); pA_PAS_PrkgDstCtrlSts = new PATypes.PA_PAS_PrkgDstCtrlSts(); arrayOfByte234 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte234)); onPA_PAS_PrkgDstCtrlSts(pA_PAS_PrkgDstCtrlSts);case 33559: this.data = (byte[])pA_PAS_PrkgDstCtrlSts.getValue(); pA_PAS_PrkgDstCtrlSysSwt = new PATypes.PA_PAS_PrkgDstCtrlSysSwt(); arrayOfByte234 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte234)); onPA_PAS_PrkgDstCtrlSysSwt(pA_PAS_PrkgDstCtrlSysSwt);case 33558: this.data = (byte[])pA_PAS_PrkgDstCtrlSysSwt.getValue(); pA_SAP_TouchUnlckTyp = new PATypes.PA_SAP_TouchUnlckTyp(); arrayOfByte234 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte234)); onPA_SAP_TouchUnlckTyp(pA_SAP_TouchUnlckTyp);case 33557: this.data = (byte[])pA_SAP_TouchUnlckTyp.getValue(); pA_SAP_PrkgProgsDisp = new PATypes.PA_SAP_PrkgProgsDisp(); arrayOfByte67 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte67)); onPA_SAP_PrkgProgsDisp(pA_SAP_PrkgProgsDisp);case 33556: this.data = (byte[])arrayOfByte67.getValue(); pA_SAP_DrvrAsscSysDisp = new PATypes.PA_SAP_DrvrAsscSysDisp(); arrayOfByte67 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte67)); onPA_SAP_DrvrAsscSysDisp(pA_SAP_DrvrAsscSysDisp);case 33555: this.data = (byte[])arrayOfByte67.getValue(); pA_SAP_DrvrAsscSysSts = new PATypes.PA_SAP_DrvrAsscSysSts(); arrayOfByte67 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte67)); onPA_SAP_DrvrAsscSysSts(pA_SAP_DrvrAsscSysSts);case 33554: this.data = (byte[])arrayOfByte67.getValue(); pA_SAP_PrkgFctDiDisp = new PATypes.PA_SAP_PrkgFctDiDisp(); arrayOfByte233 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte233)); onPA_SAP_PrkgFctDiDisp(pA_SAP_PrkgFctDiDisp);case 33553: this.data = (byte[])pA_SAP_PrkgFctDiDisp.getValue(); pA_SAP_DrvrAsscSysBtnPush = new PATypes.PA_SAP_DrvrAsscSysBtnPush(); arrayOfByte233 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte233)); onPA_SAP_DrvrAsscSysBtnPush(pA_SAP_DrvrAsscSysBtnPush);case 33552: this.data = (byte[])pA_SAP_DrvrAsscSysBtnPush.getValue(); pA_PAC_RctaIndcnRe = new PATypes.PA_PAC_RctaIndcnRe(); arrayOfByte66 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte66)); onPA_PAC_RctaIndcnRe(pA_PAC_RctaIndcnRe);case 33551: this.data = (byte[])arrayOfByte66.getValue(); pA_PAC_RctaIndcnLe = new PATypes.PA_PAC_RctaIndcnLe(); arrayOfByte66 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte66)); onPA_PAC_RctaIndcnLe(pA_PAC_RctaIndcnLe);case 33550: this.data = (byte[])arrayOfByte66.getValue(); pA_PAC_ImgSnsrClrReq = new PATypes.PA_PAC_ImgSnsrClrReq(); arrayOfByte232 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte232)); onPA_PAC_ImgSnsrClrReq(pA_PAC_ImgSnsrClrReq);case 33549: this.data = (byte[])pA_PAC_ImgSnsrClrReq.getValue(); pA_PAC_PlaModStsResp = new PATypes.PA_PAC_PlaModStsResp(); arrayOfByte232 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte232)); onPA_PAC_PlaModStsResp(pA_PAC_PlaModStsResp);case 33548: this.data = (byte[])pA_PAC_PlaModStsResp.getValue(); pA_PAC_RoadCalForVisnAgWideResp = new PATypes.PA_PAC_RoadCalForVisnAgWideResp(); arrayOfByte65 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte65)); onPA_PAC_RoadCalForVisnAgWideResp(pA_PAC_RoadCalForVisnAgWideResp);case 33547: this.data = (byte[])arrayOfByte65.getValue(); pA_PAC_VehMdlClrResp = new PATypes.PA_PAC_VehMdlClrResp(); arrayOfByte65 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte65)); onPA_PAC_VehMdlClrResp(pA_PAC_VehMdlClrResp);case 33546: this.data = (byte[])arrayOfByte65.getValue(); pA_PAC_TurnEntryAgWideVisResp = new PATypes.PA_PAC_TurnEntryAgWideVisResp(); arrayOfByte231 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte231)); onPA_PAC_TurnEntryAgWideVisResp(pA_PAC_TurnEntryAgWideVisResp);case 33545: this.data = (byte[])pA_PAC_TurnEntryAgWideVisResp.getValue(); pA_PAC_ThrDTouringViewResp = new PATypes.PA_PAC_ThrDTouringViewResp(); arrayOfByte231 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte231)); onPA_PAC_ThrDTouringViewResp(pA_PAC_ThrDTouringViewResp);case 33544: this.data = (byte[])pA_PAC_ThrDTouringViewResp.getValue(); pA_PAC_ThrDObjDethResp = new PATypes.PA_PAC_ThrDObjDethResp(); arrayOfByte64 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte64)); onPA_PAC_ThrDObjDethResp(pA_PAC_ThrDObjDethResp);case 33543: this.data = (byte[])arrayOfByte64.getValue(); pA_PAC_PedDetnResp = new PATypes.PA_PAC_PedDetnResp(); arrayOfByte64 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte64)); onPA_PAC_PedDetnResp(pA_PAC_PedDetnResp);case 33542: this.data = (byte[])arrayOfByte64.getValue(); pA_PAC_VisnAgExtnResp = new PATypes.PA_PAC_VisnAgExtnResp(); arrayOfByte230 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte230)); onPA_PAC_VisnAgExtnResp(pA_PAC_VisnAgExtnResp);case 33541: this.data = (byte[])pA_PAC_VisnAgExtnResp.getValue(); pA_PAC_PrkgIndcrLineResp = new PATypes.PA_PAC_PrkgIndcrLineResp(); arrayOfByte63 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte63)); onPA_PAC_PrkgIndcrLineResp(pA_PAC_PrkgIndcrLineResp);case 33540: this.data = (byte[])arrayOfByte63.getValue(); pA_PAC_VisnImgAgWide3DInUse = new PATypes.PA_PAC_VisnImgAgWide3DInUse(); arrayOfByte229 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte229)); onPA_PAC_VisnImgAgWide3DInUse(pA_PAC_VisnImgAgWide3DInUse);case 33539: this.data = (byte[])pA_PAC_VisnImgAgWide3DInUse.getValue(); pA_PAC_VisnImgAgWide2DInUse = new PATypes.PA_PAC_VisnImgAgWide2DInUse(); arrayOfByte229 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte229)); onPA_PAC_VisnImgAgWide2DInUse(pA_PAC_VisnImgAgWide2DInUse);case 33538: this.data = (byte[])pA_PAC_VisnImgAgWide2DInUse.getValue(); pA_PAC_TxStrtVisReq = new PATypes.PA_PAC_TxStrtVisReq(); arrayOfByte62 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte62)); onPA_PAC_TxStrtVisReq(pA_PAC_TxStrtVisReq);case 33537: this.data = (byte[])arrayOfByte62.getValue(); pA_PAC_SwtDispOnAndOffStsResp = new PATypes.PA_PAC_SwtDispOnAndOffStsResp(); arrayOfByte62 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte62)); onPA_PAC_SwtDispOnAndOffStsResp(pA_PAC_SwtDispOnAndOffStsResp);case 33536: this.data = (byte[])arrayOfByte62.getValue(); pA_DspVersion = new PATypes.PA_DspVersion(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_DspVersion(pA_DspVersion);case 33535: this.data = (byte[])pA_DspVersion.getValue(); pA_ErrorReport = new PATypes.PA_ErrorReport(); arrayOfByte228 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte228)); onPA_ErrorReport(pA_ErrorReport);case 33534: this.data = (byte[])pA_ErrorReport.getValue(); pA_AR_WarningVlo = new PATypes.PA_AR_WarningVlo(); arrayOfByte61 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte61)); onPA_AR_WarningVlo(pA_AR_WarningVlo);case 33533: this.data = (byte[])arrayOfByte61.getValue(); pA_McuLog_Panic = new PATypes.PA_McuLog_Panic(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_McuLog_Panic(pA_McuLog_Panic);case 33532: this.data = (byte[])pA_McuLog_Panic.getValue(); pA_VFC_SetVehSceneMode = new PATypes.PA_VFC_SetVehSceneMode(); arrayOfByte60 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte60)); onPA_VFC_SetVehSceneMode(pA_VFC_SetVehSceneMode);case 33531: this.data = (byte[])arrayOfByte60.getValue(); pA_VFC_SceneModePDC = new PATypes.PA_VFC_SceneModePDC(); arrayOfByte60 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte60)); onPA_VFC_SceneModePDC(pA_VFC_SceneModePDC);case 33530: this.data = (byte[])arrayOfByte60.getValue(); pA_VFC_VFC_Reboot = new PATypes.PA_VFC_VFC_Reboot(); arrayOfByte227 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte227)); onPA_VFC_VFC_Reboot(pA_VFC_VFC_Reboot);case 33529: this.data = (byte[])pA_VFC_VFC_Reboot.getValue(); pA_VFC_SetVehFace = new PATypes.PA_VFC_SetVehFace(); arrayOfByte59 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte59)); onPA_VFC_SetVehFace(pA_VFC_SetVehFace);case 33528: this.data = (byte[])arrayOfByte59.getValue(); pA_VFC_VFCRsrv5 = new PATypes.PA_VFC_VFCRsrv5(); arrayOfByte59 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte59)); onPA_VFC_VFCRsrv5(pA_VFC_VFCRsrv5);case 33527: this.data = (byte[])arrayOfByte59.getValue(); pA_VFC_VFCRsrv4 = new PATypes.PA_VFC_VFCRsrv4(); arrayOfByte59 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte59)); onPA_VFC_VFCRsrv4(pA_VFC_VFCRsrv4);case 33526: this.data = (byte[])arrayOfByte59.getValue(); pA_VFC_VFCRsrv3 = new PATypes.PA_VFC_VFCRsrv3(); arrayOfByte59 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte59)); onPA_VFC_VFCRsrv3(pA_VFC_VFCRsrv3);case 33525: this.data = (byte[])arrayOfByte59.getValue(); pA_VFC_VFCRsrv2 = new PATypes.PA_VFC_VFCRsrv2(); arrayOfByte59 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte59)); onPA_VFC_VFCRsrv2(pA_VFC_VFCRsrv2);case 33524: this.data = (byte[])arrayOfByte59.getValue(); pA_VFC_VFCRsrv1 = new PATypes.PA_VFC_VFCRsrv1(); arrayOfByte226 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte226)); onPA_VFC_VFCRsrv1(pA_VFC_VFCRsrv1);case 33523: this.data = (byte[])pA_VFC_VFCRsrv1.getValue(); pA_VFC_ExteriorLightShow = new PATypes.PA_VFC_ExteriorLightShow(); arrayOfByte226 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte226)); onPA_VFC_ExteriorLightShow(pA_VFC_ExteriorLightShow);case 33522: this.data = (byte[])pA_VFC_ExteriorLightShow.getValue(); pA_VFC_ExteriorLightShowWin = new PATypes.PA_VFC_ExteriorLightShowWin(); arrayOfByte58 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte58)); onPA_VFC_ExteriorLightShowWin(pA_VFC_ExteriorLightShowWin);case 33521: this.data = (byte[])arrayOfByte58.getValue(); pA_VFCNavigationInfoSharing = new PATypes.PA_VFCNavigationInfoSharing(); arrayOfByte225 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte225)); onPA_VFCNavigationInfoSharing(pA_VFCNavigationInfoSharing);case 33520: this.data = (byte[])pA_VFCNavigationInfoSharing.getValue(); pA_VFCGenChaSettingsForHmiCen = new PATypes.PA_VFCGenChaSettingsForHmiCen(); arrayOfByte225 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte225)); onPA_VFCGenChaSettingsForHmiCen(pA_VFCGenChaSettingsForHmiCen);case 33519: this.data = (byte[])pA_VFCGenChaSettingsForHmiCen.getValue(); pA_VFCSetVehCharging = new PATypes.PA_VFCSetVehCharging(); arrayOfByte57 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte57)); onPA_VFCSetVehCharging(pA_VFCSetVehCharging);case 33518: this.data = (byte[])arrayOfByte57.getValue(); pA_VFC_SetVehDvr = new PATypes.PA_VFC_SetVehDvr(); arrayOfByte224 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte224)); onPA_VFC_SetVehDvr(pA_VFC_SetVehDvr);case 33517: this.data = (byte[])pA_VFC_SetVehDvr.getValue(); pA_VFC_SetVehTcam = new PATypes.PA_VFC_SetVehTcam(); arrayOfByte224 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte224)); onPA_VFC_SetVehTcam(pA_VFC_SetVehTcam);case 33516: this.data = (byte[])pA_VFC_SetVehTcam.getValue(); pA_VFC_SetVehAvm = new PATypes.PA_VFC_SetVehAvm(); arrayOfByte56 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte56)); onPA_VFC_SetVehAvm(pA_VFC_SetVehAvm);case 33515: this.data = (byte[])arrayOfByte56.getValue(); pA_VFC_SetVehApa = new PATypes.PA_VFC_SetVehApa(); arrayOfByte223 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte223)); onPA_VFC_SetVehApa(pA_VFC_SetVehApa);case 33514: this.data = (byte[])pA_VFC_SetVehApa.getValue(); pA_VFC_SetVehPrivateLock = new PATypes.PA_VFC_SetVehPrivateLock(); arrayOfByte55 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte55)); onPA_VFC_SetVehPrivateLock(pA_VFC_SetVehPrivateLock);case 33513: this.data = (byte[])arrayOfByte55.getValue(); pA_VFC_SetVehCenClkIndcnAndSetg = new PATypes.PA_VFC_SetVehCenClkIndcnAndSetg(); arrayOfByte55 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte55)); onPA_VFC_SetVehCenClkIndcnAndSetg(pA_VFC_SetVehCenClkIndcnAndSetg);case 33512: this.data = (byte[])arrayOfByte55.getValue(); pA_VFC_TelephoneManager = new PATypes.PA_VFC_TelephoneManager(); arrayOfByte222 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte222)); onPA_VFC_TelephoneManager(pA_VFC_TelephoneManager);case 33511: this.data = (byte[])pA_VFC_TelephoneManager.getValue(); pA_VFC_FaceIdnForHmiCen = new PATypes.PA_VFC_FaceIdnForHmiCen(); arrayOfByte222 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte222)); onPA_VFC_FaceIdnForHmiCen(pA_VFC_FaceIdnForHmiCen);case 33510: this.data = (byte[])pA_VFC_FaceIdnForHmiCen.getValue(); pA_VFC_ParkAssiCtrlForHmiCen = new PATypes.PA_VFC_ParkAssiCtrlForHmiCen(); arrayOfByte222 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte222)); onPA_VFC_ParkAssiCtrlForHmiCen(pA_VFC_ParkAssiCtrlForHmiCen);case 33509: this.data = (byte[])pA_VFC_ParkAssiCtrlForHmiCen.getValue(); pA_VFC_IPWakeup = new PATypes.PA_VFC_IPWakeup(); arrayOfByte222 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte222)); onPA_VFC_IPWakeup(pA_VFC_IPWakeup);case 33508: this.data = (byte[])pA_VFC_IPWakeup.getValue(); pA_VF_HUD_ARD311Data = new PATypes.PA_VF_HUD_ARD311Data(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_VF_HUD_ARD311Data(pA_VF_HUD_ARD311Data);case 33507: this.data = (byte[])pA_VF_HUD_ARD311Data.getValue(); pA_VF_HUD_ARD310Data = new PATypes.PA_VF_HUD_ARD310Data(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_VF_HUD_ARD310Data(pA_VF_HUD_ARD310Data);case 33506: this.data = (byte[])pA_VF_HUD_ARD310Data.getValue(); pA_VF_HUD_ARD300Data = new PATypes.PA_VF_HUD_ARD300Data(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_VF_HUD_ARD300Data(pA_VF_HUD_ARD300Data);case 33505: this.data = (byte[])pA_VF_HUD_ARD300Data.getValue(); pA_VF_HUD_ARActvSts = new PATypes.PA_VF_HUD_ARActvSts(); arrayOfByte54 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte54)); onPA_VF_HUD_ARActvSts(pA_VF_HUD_ARActvSts);case 33504: this.data = (byte[])arrayOfByte54.getValue(); pA_VF_HUD_HudSnowModeReq = new PATypes.PA_VF_HUD_HudSnowModeReq(); arrayOfByte221 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte221)); onPA_VF_HUD_HudSnowModeReq(pA_VF_HUD_HudSnowModeReq);case 33503: this.data = (byte[])pA_VF_HUD_HudSnowModeReq.getValue(); pA_VF_HUD_HudRstForSetgAndData = new PATypes.PA_VF_HUD_HudRstForSetgAndData(); arrayOfByte221 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte221)); onPA_VF_HUD_HudRstForSetgAndData(pA_VF_HUD_HudRstForSetgAndData);case 33502: this.data = (byte[])pA_VF_HUD_HudRstForSetgAndData.getValue(); pA_VF_HUD_ImgRotAdjmtReq = new PATypes.PA_VF_HUD_ImgRotAdjmtReq(); arrayOfByte53 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte53)); onPA_VF_HUD_ImgRotAdjmtReq(pA_VF_HUD_ImgRotAdjmtReq);case 33501: this.data = (byte[])arrayOfByte53.getValue(); pA_VF_HUD_ErgoAdjmtReq = new PATypes.PA_VF_HUD_ErgoAdjmtReq(); arrayOfByte220 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte220)); onPA_VF_HUD_ErgoAdjmtReq(pA_VF_HUD_ErgoAdjmtReq);case 33500: this.data = (byte[])pA_VF_HUD_ErgoAdjmtReq.getValue(); pA_VF_HUD_IllmnReq = new PATypes.PA_VF_HUD_IllmnReq(); arrayOfByte52 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte52)); onPA_VF_HUD_IllmnReq(pA_VF_HUD_IllmnReq);case 33499: this.data = (byte[])arrayOfByte52.getValue(); pA_VF_HUD_ActvSts = new PATypes.PA_VF_HUD_ActvSts(); arrayOfByte219 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte219)); onPA_VF_HUD_ActvSts(pA_VF_HUD_ActvSts);case 33498: this.data = (byte[])pA_VF_HUD_ActvSts.getValue(); pA_Device_Supplier_Code = new PATypes.PA_Device_Supplier_Code(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_Device_Supplier_Code(pA_Device_Supplier_Code);case 33497: this.data = (byte[])pA_Device_Supplier_Code.getValue(); pA_Device_Project_Code = new PATypes.PA_Device_Project_Code(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_Device_Project_Code(pA_Device_Project_Code);case 33496: this.data = (byte[])pA_Device_Project_Code.getValue(); pA_Device_VPVersion_HD = new PATypes.PA_Device_VPVersion_HD(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_Device_VPVersion_HD(pA_Device_VPVersion_HD);case 33495: this.data = (byte[])pA_Device_VPVersion_HD.getValue(); pA_Device_SN = new PATypes.PA_Device_SN(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_Device_SN(pA_Device_SN);case 33494: this.data = (byte[])pA_Device_SN.getValue(); pA_Device_IHUID = new PATypes.PA_Device_IHUID(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_Device_IHUID(pA_Device_IHUID);case 33493: this.data = (byte[])pA_Device_IHUID.getValue(); pA_VP_Version = new PATypes.PA_VP_Version(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_VP_Version(pA_VP_Version);case 33492: this.data = (byte[])pA_VP_Version.getValue(); pA_VIN_VinNum = new PATypes.PA_VIN_VinNum(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data)); onPA_VIN_VinNum(pA_VIN_VinNum);case 33491: this.data = (byte[])pA_VIN_VinNum.getValue(); pA_SAP_PrkgUnlck = new PATypes.PA_SAP_PrkgUnlck(); this(VendorVehicleHalPAProto.Touchtime.parseFrom(this.data)); onPA_SAP_PrkgUnlck(pA_SAP_PrkgUnlck);case 33490: this.data = (byte[])pA_SAP_PrkgUnlck.getValue(); pA_PowerSoftKeyBrightness = new PATypes.PA_PowerSoftKeyBrightness(); arrayOfByte51 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte51)); onPA_PowerSoftKeyBrightness(pA_PowerSoftKeyBrightness);case 33489: this.data = (byte[])arrayOfByte51.getValue(); pA_PowerSoftKeySwitch = new PATypes.PA_PowerSoftKeySwitch(); arrayOfByte51 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte51)); onPA_PowerSoftKeySwitch(pA_PowerSoftKeySwitch);case 33488: this.data = (byte[])arrayOfByte51.getValue(); pA_LinkSwitch = new PATypes.PA_LinkSwitch(); arrayOfByte51 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte51)); onPA_LinkSwitch(pA_LinkSwitch);case 33487: this.data = (byte[])arrayOfByte51.getValue(); pA_LcfgPsdNightVal = new PATypes.PA_LcfgPsdNightVal(); arrayOfByte51 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte51)); onPA_LcfgPsdNightVal(pA_LcfgPsdNightVal);case 33486: this.data = (byte[])arrayOfByte51.getValue(); pA_LcfgPsdDayVal = new PATypes.PA_LcfgPsdDayVal(); arrayOfByte218 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte218)); onPA_LcfgPsdDayVal(pA_LcfgPsdDayVal);case 33485: this.data = (byte[])pA_LcfgPsdDayVal.getValue(); pA_LcfgCsdNightVal = new PATypes.PA_LcfgCsdNightVal(); arrayOfByte218 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte218)); onPA_LcfgCsdNightVal(pA_LcfgCsdNightVal);case 33484: this.data = (byte[])pA_LcfgCsdNightVal.getValue(); pA_LcfgCsdDayVal = new PATypes.PA_LcfgCsdDayVal(); arrayOfByte50 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte50)); onPA_LcfgCsdDayVal(pA_LcfgCsdDayVal);case 33483: this.data = (byte[])arrayOfByte50.getValue(); pA_LcfgDftBckVal = new PATypes.PA_LcfgDftBckVal(); arrayOfByte217 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte217)); onPA_LcfgDftBckVal(pA_LcfgDftBckVal);case 33482: this.data = (byte[])pA_LcfgDftBckVal.getValue(); pA_t_dim_rheo = new PATypes.PA_t_dim_rheo(); arrayOfByte49 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte49)); onPA_t_dim_rheo(pA_t_dim_rheo);case 33481: this.data = (byte[])arrayOfByte49.getValue(); pA_t_dim_slow = new PATypes.PA_t_dim_slow(); arrayOfByte49 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte49)); onPA_t_dim_slow(pA_t_dim_slow);case 33480: this.data = (byte[])arrayOfByte49.getValue(); pA_t_dim_fast = new PATypes.PA_t_dim_fast(); arrayOfByte216 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte216)); onPA_t_dim_fast(pA_t_dim_fast);case 33479: this.data = (byte[])pA_t_dim_fast.getValue(); pA_PSDBrightness = new PATypes.PA_PSDBrightness(); arrayOfByte48 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte48)); onPA_PSDBrightness(pA_PSDBrightness);case 33478: this.data = (byte[])arrayOfByte48.getValue(); pA_CSDBrightness = new PATypes.PA_CSDBrightness(); arrayOfByte48 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte48)); onPA_CSDBrightness(pA_CSDBrightness);case 33477: this.data = (byte[])arrayOfByte48.getValue(); pA_DayNightMode = new PATypes.PA_DayNightMode(); arrayOfByte215 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte215)); onPA_DayNightMode(pA_DayNightMode);case 33476: this.data = (byte[])pA_DayNightMode.getValue(); pA_BackBrightness = new PATypes.PA_BackBrightness(); arrayOfByte215 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte215)); onPA_BackBrightness(pA_BackBrightness);case 33475: this.data = (byte[])pA_BackBrightness.getValue(); pA_SysSetPUnit = new PATypes.PA_SysSetPUnit(); arrayOfByte47 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte47)); onPA_SysSetPUnit(pA_SysSetPUnit);case 33474: this.data = (byte[])arrayOfByte47.getValue(); pA_SysSetDstLong = new PATypes.PA_SysSetDstLong(); arrayOfByte47 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte47)); onPA_SysSetDstLong(pA_SysSetDstLong);case 33473: this.data = (byte[])arrayOfByte47.getValue(); pA_SysSetVolUnit = new PATypes.PA_SysSetVolUnit(); arrayOfByte47 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte47)); onPA_SysSetVolUnit(pA_SysSetVolUnit);case 33472: this.data = (byte[])arrayOfByte47.getValue(); pA_SysSetSpdUnit = new PATypes.PA_SysSetSpdUnit(); arrayOfByte214 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte214)); onPA_SysSetSpdUnit(pA_SysSetSpdUnit);case 33471: this.data = (byte[])pA_SysSetSpdUnit.getValue(); pA_SysSetFuCnsUnit = new PATypes.PA_SysSetFuCnsUnit(); arrayOfByte46 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte46)); onPA_SysSetFuCnsUnit(pA_SysSetFuCnsUnit);case 33470: this.data = (byte[])arrayOfByte46.getValue(); pA_SysSetTempUnit = new PATypes.PA_SysSetTempUnit(); arrayOfByte213 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte213)); onPA_SysSetTempUnit(pA_SysSetTempUnit);case 33469: this.data = (byte[])pA_SysSetTempUnit.getValue(); pA_SysSetDateFmt = new PATypes.PA_SysSetDateFmt(); arrayOfByte213 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte213)); onPA_SysSetDateFmt(pA_SysSetDateFmt);case 33468: this.data = (byte[])pA_SysSetDateFmt.getValue(); pA_SysSetClkFmt = new PATypes.PA_SysSetClkFmt(); arrayOfByte213 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte213)); onPA_SysSetClkFmt(pA_SysSetClkFmt);case 33467: this.data = (byte[])pA_SysSetClkFmt.getValue(); pA_SysSetOfLang = new PATypes.PA_SysSetOfLang(); arrayOfByte45 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte45)); onPA_SysSetOfLang(pA_SysSetOfLang);case 33466: this.data = (byte[])arrayOfByte45.getValue(); pA_Power_Res = new PATypes.PA_Power_Res(); this(VendorVehicleHalPAProto.PwrctrlVptoapimpl.parseFrom(this.data)); onPA_Power_Res(pA_Power_Res);case 33465: this.data = (byte[])pA_Power_Res.getValue(); pA_DriveMode_Adaptive = new PATypes.PA_DriveMode_Adaptive(); arrayOfByte212 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte212)); onPA_DriveMode_Adaptive(pA_DriveMode_Adaptive);case 33464: this.data = (byte[])pA_DriveMode_Adaptive.getValue(); pA_DriveMode_Animation = new PATypes.PA_DriveMode_Animation(); arrayOfByte44 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte44)); onPA_DriveMode_Animation(pA_DriveMode_Animation);case 33463: this.data = (byte[])arrayOfByte44.getValue(); pA_DriveMode_Value = new PATypes.PA_DriveMode_Value(); arrayOfByte44 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte44)); onPA_DriveMode_Value(pA_DriveMode_Value);case 33462: this.data = (byte[])arrayOfByte44.getValue(); pA_DriveMode_Suspension_Settings = new PATypes.PA_DriveMode_Suspension_Settings(); arrayOfByte44 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte44)); onPA_DriveMode_Suspension_Settings(pA_DriveMode_Suspension_Settings);case 33461: this.data = (byte[])arrayOfByte44.getValue(); pA_DriveMode_Engine_StartStop = new PATypes.PA_DriveMode_Engine_StartStop(); arrayOfByte44 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte44)); onPA_DriveMode_Engine_StartStop(pA_DriveMode_Engine_StartStop);case 33460: this.data = (byte[])arrayOfByte44.getValue(); pA_DriveMode_DIMTheme_Settings = new PATypes.PA_DriveMode_DIMTheme_Settings(); arrayOfByte44 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte44)); onPA_DriveMode_DIMTheme_Settings(pA_DriveMode_DIMTheme_Settings);case 33459: this.data = (byte[])arrayOfByte44.getValue(); pA_DriveMode_SteeringWheelAssistLevel_Settings = new PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings(); arrayOfByte44 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte44)); onPA_DriveMode_SteeringWheelAssistLevel_Settings(pA_DriveMode_SteeringWheelAssistLevel_Settings);case 33458: this.data = (byte[])arrayOfByte44.getValue(); pA_DriveMode_AirConditioner_Settings = new PATypes.PA_DriveMode_AirConditioner_Settings(); arrayOfByte211 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte211)); onPA_DriveMode_AirConditioner_Settings(pA_DriveMode_AirConditioner_Settings);case 33457: this.data = (byte[])pA_DriveMode_AirConditioner_Settings.getValue(); pA_DriveMode_Powertrain_Settings = new PATypes.PA_DriveMode_Powertrain_Settings(); arrayOfByte211 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte211)); onPA_DriveMode_Powertrain_Settings(pA_DriveMode_Powertrain_Settings);case 33456: this.data = (byte[])pA_DriveMode_Powertrain_Settings.getValue(); pA_DriveMode_Brake_Settings = new PATypes.PA_DriveMode_Brake_Settings(); arrayOfByte43 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte43)); onPA_DriveMode_Brake_Settings(pA_DriveMode_Brake_Settings);case 33455: this.data = (byte[])arrayOfByte43.getValue(); pA_DriveMode_Individual_Settings = new PATypes.PA_DriveMode_Individual_Settings(); arrayOfByte43 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte43)); onPA_DriveMode_Individual_Settings(pA_DriveMode_Individual_Settings);case 33454: this.data = (byte[])arrayOfByte43.getValue(); pA_DriveMode_active_time = new PATypes.PA_DriveMode_active_time(); arrayOfByte210 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte210)); onPA_DriveMode_active_time(pA_DriveMode_active_time);case 33453: this.data = (byte[])pA_DriveMode_active_time.getValue(); pA_DriveMode_confirmation_timeout = new PATypes.PA_DriveMode_confirmation_timeout(); arrayOfByte210 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte210)); onPA_DriveMode_confirmation_timeout(pA_DriveMode_confirmation_timeout);case 33452: this.data = (byte[])pA_DriveMode_confirmation_timeout.getValue(); pA_DriveMode_Rock = new PATypes.PA_DriveMode_Rock(); arrayOfByte42 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte42)); onPA_DriveMode_Rock(pA_DriveMode_Rock);case 33451: this.data = (byte[])arrayOfByte42.getValue(); pA_DriveMode_Mud = new PATypes.PA_DriveMode_Mud(); arrayOfByte209 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte209)); onPA_DriveMode_Mud(pA_DriveMode_Mud);case 33450: this.data = (byte[])pA_DriveMode_Mud.getValue(); pA_DriveMode_Sand = new PATypes.PA_DriveMode_Sand(); arrayOfByte209 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte209)); onPA_DriveMode_Sand(pA_DriveMode_Sand);case 33449: this.data = (byte[])pA_DriveMode_Sand.getValue(); pA_DriveMode_Snow = new PATypes.PA_DriveMode_Snow(); arrayOfByte41 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte41)); onPA_DriveMode_Snow(pA_DriveMode_Snow);case 33448: this.data = (byte[])arrayOfByte41.getValue(); pA_DriveMode_Power = new PATypes.PA_DriveMode_Power(); arrayOfByte208 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte208)); onPA_DriveMode_Power(pA_DriveMode_Power);case 33447: this.data = (byte[])pA_DriveMode_Power.getValue(); pA_DriveMode_Hybrid = new PATypes.PA_DriveMode_Hybrid(); arrayOfByte208 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte208)); onPA_DriveMode_Hybrid(pA_DriveMode_Hybrid);case 33446: this.data = (byte[])pA_DriveMode_Hybrid.getValue(); pA_DriveMode_Pure = new PATypes.PA_DriveMode_Pure(); arrayOfByte208 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte208)); onPA_DriveMode_Pure(pA_DriveMode_Pure);case 33445: this.data = (byte[])pA_DriveMode_Pure.getValue(); pA_DriveMode_Save = new PATypes.PA_DriveMode_Save(); arrayOfByte40 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte40)); onPA_DriveMode_Save(pA_DriveMode_Save);case 33444: this.data = (byte[])arrayOfByte40.getValue(); pA_DriveMode_AWD = new PATypes.PA_DriveMode_AWD(); arrayOfByte207 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte207)); onPA_DriveMode_AWD(pA_DriveMode_AWD);case 33443: this.data = (byte[])pA_DriveMode_AWD.getValue(); pA_DriveMode_XC = new PATypes.PA_DriveMode_XC(); arrayOfByte39 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte39)); onPA_DriveMode_XC(pA_DriveMode_XC);case 33442: this.data = (byte[])arrayOfByte39.getValue(); pA_DriveMode_Individual = new PATypes.PA_DriveMode_Individual(); arrayOfByte206 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte206)); onPA_DriveMode_Individual(pA_DriveMode_Individual);case 33441: this.data = (byte[])pA_DriveMode_Individual.getValue(); pA_DriveMode_Dynamic = new PATypes.PA_DriveMode_Dynamic(); arrayOfByte206 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte206)); onPA_DriveMode_Dynamic(pA_DriveMode_Dynamic);case 33440: this.data = (byte[])pA_DriveMode_Dynamic.getValue(); pA_DriveMode_Comfort = new PATypes.PA_DriveMode_Comfort(); arrayOfByte38 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte38)); onPA_DriveMode_Comfort(pA_DriveMode_Comfort);case 33439: this.data = (byte[])arrayOfByte38.getValue(); pA_DriveMode_Eco = new PATypes.PA_DriveMode_Eco(); arrayOfByte38 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte38)); onPA_DriveMode_Eco(pA_DriveMode_Eco);case 33438: this.data = (byte[])arrayOfByte38.getValue(); pA_TCH_CupHoldrOcpyFbSts = new PATypes.PA_TCH_CupHoldrOcpyFbSts(); arrayOfByte205 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte205)); onPA_TCH_CupHoldrOcpyFbSts(pA_TCH_CupHoldrOcpyFbSts);case 33437: this.data = (byte[])pA_TCH_CupHoldrOcpyFbSts.getValue(); pA_TCH_CupHoldrAvlSts = new PATypes.PA_TCH_CupHoldrAvlSts(); arrayOfByte205 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte205)); onPA_TCH_CupHoldrAvlSts(pA_TCH_CupHoldrAvlSts);case 33436: this.data = (byte[])pA_TCH_CupHoldrAvlSts.getValue(); pA_TCH_CupHoldrVoltgErr = new PATypes.PA_TCH_CupHoldrVoltgErr(); arrayOfByte37 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte37)); onPA_TCH_CupHoldrVoltgErr(pA_TCH_CupHoldrVoltgErr);case 33435: this.data = (byte[])arrayOfByte37.getValue(); pA_TCH_CupHoldrActvAllwd = new PATypes.PA_TCH_CupHoldrActvAllwd(); arrayOfByte37 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte37)); onPA_TCH_CupHoldrActvAllwd(pA_TCH_CupHoldrActvAllwd);case 33434: this.data = (byte[])arrayOfByte37.getValue(); pA_TCH_CupHoldrStsFd = new PATypes.PA_TCH_CupHoldrStsFd(); arrayOfByte37 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte37)); onPA_TCH_CupHoldrStsFd(pA_TCH_CupHoldrStsFd);case 33433: this.data = (byte[])arrayOfByte37.getValue(); pA_Fragra_FragRefrshAutSetg = new PATypes.PA_Fragra_FragRefrshAutSetg(); arrayOfByte204 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte204)); onPA_Fragra_FragRefrshAutSetg(pA_Fragra_FragRefrshAutSetg);case 33432: this.data = (byte[])pA_Fragra_FragRefrshAutSetg.getValue(); pA_Fragra_AirFragCh5RunngSts = new PATypes.PA_Fragra_AirFragCh5RunngSts(); arrayOfByte36 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte36)); onPA_Fragra_AirFragCh5RunngSts(pA_Fragra_AirFragCh5RunngSts);case 33431: this.data = (byte[])arrayOfByte36.getValue(); pA_Fragra_AirFragCh4RunngSts = new PATypes.PA_Fragra_AirFragCh4RunngSts(); arrayOfByte203 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte203)); onPA_Fragra_AirFragCh4RunngSts(pA_Fragra_AirFragCh4RunngSts);case 33430: this.data = (byte[])pA_Fragra_AirFragCh4RunngSts.getValue(); pA_Fragra_AirFragCh3RunngSts = new PATypes.PA_Fragra_AirFragCh3RunngSts(); arrayOfByte203 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte203)); onPA_Fragra_AirFragCh3RunngSts(pA_Fragra_AirFragCh3RunngSts);case 33429: this.data = (byte[])pA_Fragra_AirFragCh3RunngSts.getValue(); pA_Fragra_AirFragCh2RunngSts = new PATypes.PA_Fragra_AirFragCh2RunngSts(); arrayOfByte35 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte35)); onPA_Fragra_AirFragCh2RunngSts(pA_Fragra_AirFragCh2RunngSts);case 33428: this.data = (byte[])arrayOfByte35.getValue(); pA_Fragra_AirFragCh1RunngSts = new PATypes.PA_Fragra_AirFragCh1RunngSts(); arrayOfByte202 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte202)); onPA_Fragra_AirFragCh1RunngSts(pA_Fragra_AirFragCh1RunngSts);case 33427: this.data = (byte[])pA_Fragra_AirFragCh1RunngSts.getValue(); pA_Fragra_Tast5UseUpRmd = new PATypes.PA_Fragra_Tast5UseUpRmd(); arrayOfByte202 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte202)); onPA_Fragra_Tast5UseUpRmd(pA_Fragra_Tast5UseUpRmd);case 33426: this.data = (byte[])pA_Fragra_Tast5UseUpRmd.getValue(); pA_Fragra_Tast4UseUpRmd = new PATypes.PA_Fragra_Tast4UseUpRmd(); arrayOfByte34 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte34)); onPA_Fragra_Tast4UseUpRmd(pA_Fragra_Tast4UseUpRmd);case 33425: this.data = (byte[])arrayOfByte34.getValue(); pA_Fragra_Tast3UseUpRmd = new PATypes.PA_Fragra_Tast3UseUpRmd(); arrayOfByte201 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte201)); onPA_Fragra_Tast3UseUpRmd(pA_Fragra_Tast3UseUpRmd);case 33424: this.data = (byte[])pA_Fragra_Tast3UseUpRmd.getValue(); pA_Fragra_Tast2UseUpRmd = new PATypes.PA_Fragra_Tast2UseUpRmd(); arrayOfByte201 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte201)); onPA_Fragra_Tast2UseUpRmd(pA_Fragra_Tast2UseUpRmd);case 33423: this.data = (byte[])pA_Fragra_Tast2UseUpRmd.getValue(); pA_Fragra_Tast1UseUpRmd = new PATypes.PA_Fragra_Tast1UseUpRmd(); arrayOfByte201 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte201)); onPA_Fragra_Tast1UseUpRmd(pA_Fragra_Tast1UseUpRmd);case 33422: this.data = (byte[])pA_Fragra_Tast1UseUpRmd.getValue(); pA_Fragra_Taste5ID = new PATypes.PA_Fragra_Taste5ID(); arrayOfByte33 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte33)); onPA_Fragra_Taste5ID(pA_Fragra_Taste5ID);case 33421: this.data = (byte[])arrayOfByte33.getValue(); pA_Fragra_Taste4ID = new PATypes.PA_Fragra_Taste4ID(); arrayOfByte200 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte200)); onPA_Fragra_Taste4ID(pA_Fragra_Taste4ID);case 33420: this.data = (byte[])pA_Fragra_Taste4ID.getValue(); pA_Fragra_Taste3ID = new PATypes.PA_Fragra_Taste3ID(); arrayOfByte200 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte200)); onPA_Fragra_Taste3ID(pA_Fragra_Taste3ID);case 33419: this.data = (byte[])pA_Fragra_Taste3ID.getValue(); pA_Fragra_Taste2ID = new PATypes.PA_Fragra_Taste2ID(); arrayOfByte32 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte32)); onPA_Fragra_Taste2ID(pA_Fragra_Taste2ID);case 33418: this.data = (byte[])arrayOfByte32.getValue(); pA_Fragra_Taste1ID = new PATypes.PA_Fragra_Taste1ID(); arrayOfByte32 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte32)); onPA_Fragra_Taste1ID(pA_Fragra_Taste1ID);case 33417: this.data = (byte[])arrayOfByte32.getValue(); pA_Fragra_RefrshReq = new PATypes.PA_Fragra_RefrshReq(); arrayOfByte32 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte32)); onPA_Fragra_RefrshReq(pA_Fragra_RefrshReq);case 33416: this.data = (byte[])arrayOfByte32.getValue(); pA_Fragra_Sts = new PATypes.PA_Fragra_Sts(); arrayOfByte32 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte32)); onPA_Fragra_Sts(pA_Fragra_Sts);case 33415: this.data = (byte[])arrayOfByte32.getValue(); pA_Fragra_SceneSetSts = new PATypes.PA_Fragra_SceneSetSts(); arrayOfByte32 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte32)); onPA_Fragra_SceneSetSts(pA_Fragra_SceneSetSts);case 33414: this.data = (byte[])arrayOfByte32.getValue(); pA_Fragra_ModReqSts = new PATypes.PA_Fragra_ModReqSts(); arrayOfByte199 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte199)); onPA_Fragra_ModReqSts(pA_Fragra_ModReqSts);case 33413: this.data = (byte[])pA_Fragra_ModReqSts.getValue(); pA_Fragra_LvlReqSts = new PATypes.PA_Fragra_LvlReqSts(); arrayOfByte31 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte31)); onPA_Fragra_LvlReqSts(pA_Fragra_LvlReqSts);case 33412: this.data = (byte[])arrayOfByte31.getValue(); pA_Fragra_TypRatReqFSts = new PATypes.PA_Fragra_TypRatReqFSts(); arrayOfByte198 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte198)); onPA_Fragra_TypRatReqFSts(pA_Fragra_TypRatReqFSts);case 33411: this.data = (byte[])pA_Fragra_TypRatReqFSts.getValue(); pA_Fragra_TypRatReqESts = new PATypes.PA_Fragra_TypRatReqESts(); arrayOfByte30 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte30)); onPA_Fragra_TypRatReqESts(pA_Fragra_TypRatReqESts);case 33410: this.data = (byte[])arrayOfByte30.getValue(); pA_Fragra_TypRatReqDSts = new PATypes.PA_Fragra_TypRatReqDSts(); arrayOfByte197 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte197)); onPA_Fragra_TypRatReqDSts(pA_Fragra_TypRatReqDSts);case 33409: this.data = (byte[])pA_Fragra_TypRatReqDSts.getValue(); pA_Fragra_TypRatReqCSts = new PATypes.PA_Fragra_TypRatReqCSts(); arrayOfByte29 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte29)); onPA_Fragra_TypRatReqCSts(pA_Fragra_TypRatReqCSts);case 33408: this.data = (byte[])arrayOfByte29.getValue(); pA_Fragra_TypRatReqBSts = new PATypes.PA_Fragra_TypRatReqBSts(); arrayOfByte196 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte196)); onPA_Fragra_TypRatReqBSts(pA_Fragra_TypRatReqBSts);case 33407: this.data = (byte[])pA_Fragra_TypRatReqBSts.getValue(); pA_Fragra_TypRatReqASts = new PATypes.PA_Fragra_TypRatReqASts(); arrayOfByte196 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte196)); onPA_Fragra_TypRatReqASts(pA_Fragra_TypRatReqASts);case 33406: this.data = (byte[])pA_Fragra_TypRatReqASts.getValue(); pA_Fragra_Actn = new PATypes.PA_Fragra_Actn(); arrayOfByte28 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte28)); onPA_Fragra_Actn(pA_Fragra_Actn);case 33405: this.data = (byte[])arrayOfByte28.getValue(); pA_PM25_IncomingAirQlyPopUpReq = new PATypes.PA_PM25_IncomingAirQlyPopUpReq(); arrayOfByte28 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte28)); onPA_PM25_IncomingAirQlyPopUpReq(pA_PM25_IncomingAirQlyPopUpReq);case 33404: this.data = (byte[])arrayOfByte28.getValue(); pA_PM25_OutdPm25Sts = new PATypes.PA_PM25_OutdPm25Sts(); arrayOfByte195 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte195)); onPA_PM25_OutdPm25Sts(pA_PM25_OutdPm25Sts);case 33403: this.data = (byte[])pA_PM25_OutdPm25Sts.getValue(); pA_PM25_IntPm25Sts = new PATypes.PA_PM25_IntPm25Sts(); arrayOfByte27 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte27)); onPA_PM25_IntPm25Sts(pA_PM25_IntPm25Sts);case 33402: this.data = (byte[])arrayOfByte27.getValue(); pA_PM25_IntrPm25HiWarn = new PATypes.PA_PM25_IntrPm25HiWarn(); arrayOfByte194 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte194)); onPA_PM25_IntrPm25HiWarn(pA_PM25_IntrPm25HiWarn);case 33401: this.data = (byte[])pA_PM25_IntrPm25HiWarn.getValue(); pA_PM25_OutdPm25Lvl = new PATypes.PA_PM25_OutdPm25Lvl(); arrayOfByte26 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte26)); onPA_PM25_OutdPm25Lvl(pA_PM25_OutdPm25Lvl);case 33400: this.data = (byte[])arrayOfByte26.getValue(); pA_PM25_IntPm25Lvl = new PATypes.PA_PM25_IntPm25Lvl(); arrayOfByte26 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte26)); onPA_PM25_IntPm25Lvl(pA_PM25_IntPm25Lvl);case 33399: this.data = (byte[])arrayOfByte26.getValue(); pA_PM25_OutdPm25Vlu = new PATypes.PA_PM25_OutdPm25Vlu(); arrayOfByte26 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte26)); onPA_PM25_OutdPm25Vlu(pA_PM25_OutdPm25Vlu);case 33398: this.data = (byte[])arrayOfByte26.getValue(); pA_PM25_IntPm25Vlu = new PATypes.PA_PM25_IntPm25Vlu(); arrayOfByte193 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte193)); onPA_PM25_IntPm25Vlu(pA_PM25_IntPm25Vlu);case 33397: this.data = (byte[])pA_PM25_IntPm25Vlu.getValue(); pA_PM25_Actvn = new PATypes.PA_PM25_Actvn(); arrayOfByte193 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte193)); onPA_PM25_Actvn(pA_PM25_Actvn);case 33396: this.data = (byte[])pA_PM25_Actvn.getValue(); pA_IAQC_ActnSts = new PATypes.PA_IAQC_ActnSts(); arrayOfByte193 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte193)); onPA_IAQC_ActnSts(pA_IAQC_ActnSts);case 33395: this.data = (byte[])pA_IAQC_ActnSts.getValue(); pA_SWH_AvlSts = new PATypes.PA_SWH_AvlSts(); arrayOfByte25 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte25)); onPA_SWH_AvlSts(pA_SWH_AvlSts);case 33394: this.data = (byte[])arrayOfByte25.getValue(); pA_SWH_ManualLvlSts = new PATypes.PA_SWH_ManualLvlSts(); arrayOfByte192 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte192)); onPA_SWH_ManualLvlSts(pA_SWH_ManualLvlSts);case 33393: this.data = (byte[])pA_SWH_ManualLvlSts.getValue(); pA_SWH_AutoReqSts = new PATypes.PA_SWH_AutoReqSts(); arrayOfByte192 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte192)); onPA_SWH_AutoReqSts(pA_SWH_AutoReqSts);case 33392: this.data = (byte[])pA_SWH_AutoReqSts.getValue(); pA_SWH_Actvn = new PATypes.PA_SWH_Actvn(); arrayOfByte24 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte24)); onPA_SWH_Actvn(pA_SWH_Actvn);case 33391: this.data = (byte[])arrayOfByte24.getValue(); pA_SCV_FirstRiAvlSts = new PATypes.PA_SCV_FirstRiAvlSts(); arrayOfByte191 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte191)); onPA_SCV_FirstRiAvlSts(pA_SCV_FirstRiAvlSts);case 33390: this.data = (byte[])pA_SCV_FirstRiAvlSts.getValue(); pA_SCV_FirstLeAvlSts = new PATypes.PA_SCV_FirstLeAvlSts(); arrayOfByte191 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte191)); onPA_SCV_FirstLeAvlSts(pA_SCV_FirstLeAvlSts);case 33389: this.data = (byte[])pA_SCV_FirstLeAvlSts.getValue(); pA_SCV_FirstRiTmrSts = new PATypes.PA_SCV_FirstRiTmrSts(); arrayOfByte191 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte191)); onPA_SCV_FirstRiTmrSts(pA_SCV_FirstRiTmrSts);case 33388: this.data = (byte[])pA_SCV_FirstRiTmrSts.getValue(); pA_SCV_FirstLeTmrSts = new PATypes.PA_SCV_FirstLeTmrSts(); arrayOfByte191 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte191)); onPA_SCV_FirstLeTmrSts(pA_SCV_FirstLeTmrSts);case 33387: this.data = (byte[])pA_SCV_FirstLeTmrSts.getValue(); pA_SCV_FirstRiLvlSts = new PATypes.PA_SCV_FirstRiLvlSts(); arrayOfByte23 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte23)); onPA_SCV_FirstRiLvlSts(pA_SCV_FirstRiLvlSts);case 33386: this.data = (byte[])arrayOfByte23.getValue(); pA_SCV_FirstLeLvlSts = new PATypes.PA_SCV_FirstLeLvlSts(); arrayOfByte23 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte23)); onPA_SCV_FirstLeLvlSts(pA_SCV_FirstLeLvlSts);case 33385: this.data = (byte[])arrayOfByte23.getValue(); pA_SCV_FirstActvn = new PATypes.PA_SCV_FirstActvn(); arrayOfByte190 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte190)); onPA_SCV_FirstActvn(pA_SCV_FirstActvn);case 33384: this.data = (byte[])pA_SCV_FirstActvn.getValue(); pA_SCH_SecRiAvlSts = new PATypes.PA_SCH_SecRiAvlSts(); arrayOfByte22 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte22)); onPA_SCH_SecRiAvlSts(pA_SCH_SecRiAvlSts);case 33383: this.data = (byte[])arrayOfByte22.getValue(); pA_SCH_SecLeAvlSts = new PATypes.PA_SCH_SecLeAvlSts(); arrayOfByte189 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte189)); onPA_SCH_SecLeAvlSts(pA_SCH_SecLeAvlSts);case 33382: this.data = (byte[])pA_SCH_SecLeAvlSts.getValue(); pA_SCH_FirstRiAvlSts = new PATypes.PA_SCH_FirstRiAvlSts(); arrayOfByte21 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte21)); onPA_SCH_FirstRiAvlSts(pA_SCH_FirstRiAvlSts);case 33381: this.data = (byte[])arrayOfByte21.getValue(); pA_SCH_FirstLeAvlSts = new PATypes.PA_SCH_FirstLeAvlSts(); arrayOfByte21 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte21)); onPA_SCH_FirstLeAvlSts(pA_SCH_FirstLeAvlSts);case 33380: this.data = (byte[])arrayOfByte21.getValue(); pA_SCH_SecRiTmrSts = new PATypes.PA_SCH_SecRiTmrSts(); arrayOfByte188 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte188)); onPA_SCH_SecRiTmrSts(pA_SCH_SecRiTmrSts);case 33379: this.data = (byte[])pA_SCH_SecRiTmrSts.getValue(); pA_SCH_SecLeTmrSts = new PATypes.PA_SCH_SecLeTmrSts(); arrayOfByte20 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte20)); onPA_SCH_SecLeTmrSts(pA_SCH_SecLeTmrSts);case 33378: this.data = (byte[])arrayOfByte20.getValue(); pA_SCH_FirstRiTmrSts = new PATypes.PA_SCH_FirstRiTmrSts(); arrayOfByte20 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte20)); onPA_SCH_FirstRiTmrSts(pA_SCH_FirstRiTmrSts);case 33377: this.data = (byte[])arrayOfByte20.getValue(); pA_SCH_FirstLeTmrSts = new PATypes.PA_SCH_FirstLeTmrSts(); arrayOfByte187 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte187)); onPA_SCH_FirstLeTmrSts(pA_SCH_FirstLeTmrSts);case 33376: this.data = (byte[])pA_SCH_FirstLeTmrSts.getValue(); pA_SCH_SecRiLvlSts = new PATypes.PA_SCH_SecRiLvlSts(); arrayOfByte187 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte187)); onPA_SCH_SecRiLvlSts(pA_SCH_SecRiLvlSts);case 33375: this.data = (byte[])pA_SCH_SecRiLvlSts.getValue(); pA_SCH_SecLeLvlSts = new PATypes.PA_SCH_SecLeLvlSts(); arrayOfByte19 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte19)); onPA_SCH_SecLeLvlSts(pA_SCH_SecLeLvlSts);case 33374: this.data = (byte[])arrayOfByte19.getValue(); pA_SCH_FirstRiLvlSts = new PATypes.PA_SCH_FirstRiLvlSts(); arrayOfByte186 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte186)); onPA_SCH_FirstRiLvlSts(pA_SCH_FirstRiLvlSts);case 33373: this.data = (byte[])pA_SCH_FirstRiLvlSts.getValue(); pA_SCH_FirstLeLvlSts = new PATypes.PA_SCH_FirstLeLvlSts(); arrayOfByte186 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte186)); onPA_SCH_FirstLeLvlSts(pA_SCH_FirstLeLvlSts);case 33372: this.data = (byte[])pA_SCH_FirstLeLvlSts.getValue(); pA_SCH_SecActvn = new PATypes.PA_SCH_SecActvn(); arrayOfByte18 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte18)); onPA_SCH_SecActvn(pA_SCH_SecActvn);case 33371: this.data = (byte[])arrayOfByte18.getValue(); pA_SCH_FirstActvn = new PATypes.PA_SCH_FirstActvn(); arrayOfByte18 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte18)); onPA_SCH_FirstActvn(pA_SCH_FirstActvn);case 33370: this.data = (byte[])arrayOfByte18.getValue(); pA_CL_ModeFrstLeft_ByHardKey = new PATypes.PA_CL_ModeFrstLeft_ByHardKey(); arrayOfByte18 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte18)); onPA_CL_ModeFrstLeft_ByHardKey(pA_CL_ModeFrstLeft_ByHardKey);case 33369: this.data = (byte[])arrayOfByte18.getValue(); pA_CL_LeftTemp_ByHardKey = new PATypes.PA_CL_LeftTemp_ByHardKey(); arrayOfByte18 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte18)); onPA_CL_LeftTemp_ByHardKey(pA_CL_LeftTemp_ByHardKey);case 33368: this.data = (byte[])arrayOfByte18.getValue(); pA_CL_FanLevel_ByHardKey = new PATypes.PA_CL_FanLevel_ByHardKey(); arrayOfByte18 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte18)); onPA_CL_FanLevel_ByHardKey(pA_CL_FanLevel_ByHardKey);case 33367: this.data = (byte[])arrayOfByte18.getValue(); pA_CL_InteCleanUnpleSmell = new PATypes.PA_CL_InteCleanUnpleSmell(); arrayOfByte185 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte185)); onPA_CL_InteCleanUnpleSmell(pA_CL_InteCleanUnpleSmell);case 33366: this.data = (byte[])pA_CL_InteCleanUnpleSmell.getValue(); pA_CL_ElecDefRunErr = new PATypes.PA_CL_ElecDefRunErr(); arrayOfByte185 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte185)); onPA_CL_ElecDefRunErr(pA_CL_ElecDefRunErr);case 33365: this.data = (byte[])pA_CL_ElecDefRunErr.getValue(); pA_CL_CCSMPopUp = new PATypes.PA_CL_CCSMPopUp(); arrayOfByte17 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte17)); onPA_CL_CCSMPopUp(pA_CL_CCSMPopUp);case 33364: this.data = (byte[])arrayOfByte17.getValue(); pA_CL_PassElecAir = new PATypes.PA_CL_PassElecAir(); this(VendorVehicleHalPAProto.Elecairalldata.parseFrom(this.data)); onPA_CL_PassElecAir(pA_CL_PassElecAir);case 33363: this.data = (byte[])pA_CL_PassElecAir.getValue(); pA_CL_DrvElecAir = new PATypes.PA_CL_DrvElecAir(); this(VendorVehicleHalPAProto.Elecairalldata.parseFrom(this.data)); onPA_CL_DrvElecAir(pA_CL_DrvElecAir);case 33362: this.data = (byte[])pA_CL_DrvElecAir.getValue(); pA_CL_GClean = new PATypes.PA_CL_GClean(); arrayOfByte184 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte184)); onPA_CL_GClean(pA_CL_GClean);case 33361: this.data = (byte[])pA_CL_GClean.getValue(); pA_CL_SecAutoSw = new PATypes.PA_CL_SecAutoSw(); arrayOfByte16 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte16)); onPA_CL_SecAutoSw(pA_CL_SecAutoSw);case 33360: this.data = (byte[])arrayOfByte16.getValue(); pA_CL_SecLockClimaSw = new PATypes.PA_CL_SecLockClimaSw(); arrayOfByte183 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte183)); onPA_CL_SecLockClimaSw(pA_CL_SecLockClimaSw);case 33359: this.data = (byte[])pA_CL_SecLockClimaSw.getValue(); pA_CL_TWinRfClsdPopSw = new PATypes.PA_CL_TWinRfClsdPopSw(); arrayOfByte183 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte183)); onPA_CL_TWinRfClsdPopSw(pA_CL_TWinRfClsdPopSw);case 33358: this.data = (byte[])pA_CL_TWinRfClsdPopSw.getValue(); pA_CL_ElecAirAvlStsPop = new PATypes.PA_CL_ElecAirAvlStsPop(); arrayOfByte15 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte15)); onPA_CL_ElecAirAvlStsPop(pA_CL_ElecAirAvlStsPop);case 33357: this.data = (byte[])arrayOfByte15.getValue(); pA_CL_PassSwt = new PATypes.PA_CL_PassSwt(); arrayOfByte182 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte182)); onPA_CL_PassSwt(pA_CL_PassSwt);case 33356: this.data = (byte[])pA_CL_PassSwt.getValue(); pA_CL_DrvSwt = new PATypes.PA_CL_DrvSwt(); arrayOfByte182 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte182)); onPA_CL_DrvSwt(pA_CL_DrvSwt);case 33355: this.data = (byte[])pA_CL_DrvSwt.getValue(); pA_CL_ClmCloseWinPop = new PATypes.PA_CL_ClmCloseWinPop(); arrayOfByte182 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte182)); onPA_CL_ClmCloseWinPop(pA_CL_ClmCloseWinPop);case 33354: this.data = (byte[])pA_CL_ClmCloseWinPop.getValue(); pA_CL_WipReSrvMod = new PATypes.PA_CL_WipReSrvMod(); arrayOfByte182 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte182)); onPA_CL_WipReSrvMod(pA_CL_WipReSrvMod);case 33353: this.data = (byte[])pA_CL_WipReSrvMod.getValue(); pA_CL_WipFrntSrvMod = new PATypes.PA_CL_WipFrntSrvMod(); arrayOfByte14 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte14)); onPA_CL_WipFrntSrvMod(pA_CL_WipFrntSrvMod);case 33352: this.data = (byte[])arrayOfByte14.getValue(); pA_CL_WipReAutReq = new PATypes.PA_CL_WipReAutReq(); arrayOfByte14 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte14)); onPA_CL_WipReAutReq(pA_CL_WipReAutReq);case 33351: this.data = (byte[])arrayOfByte14.getValue(); pA_CL_IntelliClimaPop = new PATypes.PA_CL_IntelliClimaPop(); arrayOfByte14 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte14)); onPA_CL_IntelliClimaPop(pA_CL_IntelliClimaPop);case 33350: this.data = (byte[])arrayOfByte14.getValue(); pA_CL_HumPop = new PATypes.PA_CL_HumPop(); arrayOfByte181 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte181)); onPA_CL_HumPop(pA_CL_HumPop);case 33349: this.data = (byte[])pA_CL_HumPop.getValue(); pA_CL_HumCtrl = new PATypes.PA_CL_HumCtrl(); arrayOfByte181 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte181)); onPA_CL_HumCtrl(pA_CL_HumCtrl);case 33348: this.data = (byte[])pA_CL_HumCtrl.getValue(); pA_CL_PostClimaWarn = new PATypes.PA_CL_PostClimaWarn(); arrayOfByte13 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte13)); onPA_CL_PostClimaWarn(pA_CL_PostClimaWarn);case 33347: this.data = (byte[])arrayOfByte13.getValue(); pA_CL_SecRowOnOffSwith = new PATypes.PA_CL_SecRowOnOffSwith(); arrayOfByte180 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte180)); onPA_CL_SecRowOnOffSwith(pA_CL_SecRowOnOffSwith);case 33346: this.data = (byte[])pA_CL_SecRowOnOffSwith.getValue(); pA_CL_RearDefrostPopup = new PATypes.PA_CL_RearDefrostPopup(); arrayOfByte12 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte12)); onPA_CL_RearDefrostPopup(pA_CL_RearDefrostPopup);case 33345: this.data = (byte[])arrayOfByte12.getValue(); pA_CL_FrntDefrostPopup = new PATypes.PA_CL_FrntDefrostPopup(); arrayOfByte179 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte179)); onPA_CL_FrntDefrostPopup(pA_CL_FrntDefrostPopup);case 33344: this.data = (byte[])pA_CL_FrntDefrostPopup.getValue(); pA_CL_AutoDefrostPopup = new PATypes.PA_CL_AutoDefrostPopup(); arrayOfByte179 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte179)); onPA_CL_AutoDefrostPopup(pA_CL_AutoDefrostPopup);case 33343: this.data = (byte[])pA_CL_AutoDefrostPopup.getValue(); pA_CL_AutoDefrostSetting = new PATypes.PA_CL_AutoDefrostSetting(); arrayOfByte11 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte11)); onPA_CL_AutoDefrostSetting(pA_CL_AutoDefrostSetting);case 33342: this.data = (byte[])arrayOfByte11.getValue(); pA_CL_SecFanLevel = new PATypes.PA_CL_SecFanLevel(); arrayOfByte11 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte11)); onPA_CL_SecFanLevel(pA_CL_SecFanLevel);case 33341: this.data = (byte[])arrayOfByte11.getValue(); pA_CL_SecRightTemp = new PATypes.PA_CL_SecRightTemp(); arrayOfByte178 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte178)); onPA_CL_SecRightTemp(pA_CL_SecRightTemp);case 33340: this.data = (byte[])pA_CL_SecRightTemp.getValue(); pA_CL_SecLeftTemp = new PATypes.PA_CL_SecLeftTemp(); arrayOfByte10 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte10)); onPA_CL_SecLeftTemp(pA_CL_SecLeftTemp);case 33339: this.data = (byte[])arrayOfByte10.getValue(); pA_CL_HvacReCtr = new PATypes.PA_CL_HvacReCtr(); arrayOfByte10 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte10)); onPA_CL_HvacReCtr(pA_CL_HvacReCtr);case 33338: this.data = (byte[])arrayOfByte10.getValue(); pA_CL_AirCtrlOff = new PATypes.PA_CL_AirCtrlOff(); arrayOfByte177 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte177)); onPA_CL_AirCtrlOff(pA_CL_AirCtrlOff);case 33337: this.data = (byte[])pA_CL_AirCtrlOff.getValue(); pA_CL_Post = new PATypes.PA_CL_Post(); arrayOfByte9 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte9)); onPA_CL_Post(pA_CL_Post);case 33336: this.data = (byte[])arrayOfByte9.getValue(); pA_CL_Pre = new PATypes.PA_CL_Pre(); arrayOfByte9 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte9)); onPA_CL_Pre(pA_CL_Pre);case 33335: this.data = (byte[])arrayOfByte9.getValue(); pA_CL_ECOClimate = new PATypes.PA_CL_ECOClimate(); arrayOfByte176 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte176)); onPA_CL_ECOClimate(pA_CL_ECOClimate);case 33334: this.data = (byte[])pA_CL_ECOClimate.getValue(); pA_CL_Sync = new PATypes.PA_CL_Sync(); arrayOfByte176 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte176)); onPA_CL_Sync(pA_CL_Sync);case 33333: this.data = (byte[])pA_CL_Sync.getValue(); pA_CL_RearDefrost = new PATypes.PA_CL_RearDefrost(); arrayOfByte8 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte8)); onPA_CL_RearDefrost(pA_CL_RearDefrost);case 33332: this.data = (byte[])arrayOfByte8.getValue(); pA_CL_FrontDefrost = new PATypes.PA_CL_FrontDefrost(); arrayOfByte175 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte175)); onPA_CL_FrontDefrost(pA_CL_FrontDefrost);case 33331: this.data = (byte[])pA_CL_FrontDefrost.getValue(); pA_WDC_AutoRearDefrost = new PATypes.PA_WDC_AutoRearDefrost(); arrayOfByte175 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte175)); onPA_WDC_AutoRearDefrost(pA_WDC_AutoRearDefrost);case 33330: this.data = (byte[])pA_WDC_AutoRearDefrost.getValue(); pA_WDC_AutoFrontDefrost = new PATypes.PA_WDC_AutoFrontDefrost(); arrayOfByte175 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte175)); onPA_WDC_AutoFrontDefrost(pA_WDC_AutoFrontDefrost);case 33329: this.data = (byte[])pA_WDC_AutoFrontDefrost.getValue(); pA_CL_MaxDefrost = new PATypes.PA_CL_MaxDefrost(); arrayOfByte175 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte175)); onPA_CL_MaxDefrost(pA_CL_MaxDefrost);case 33328: this.data = (byte[])pA_CL_MaxDefrost.getValue(); pA_CL_AutoSetting = new PATypes.PA_CL_AutoSetting(); arrayOfByte175 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte175)); onPA_CL_AutoSetting(pA_CL_AutoSetting);case 33327: this.data = (byte[])pA_CL_AutoSetting.getValue(); pA_CL_RecircSetting = new PATypes.PA_CL_RecircSetting(); arrayOfByte7 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte7)); onPA_CL_RecircSetting(pA_CL_RecircSetting);case 33326: this.data = (byte[])arrayOfByte7.getValue(); pA_CL_RightTemp = new PATypes.PA_CL_RightTemp(); arrayOfByte174 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte174)); onPA_CL_RightTemp(pA_CL_RightTemp);case 33325: this.data = (byte[])pA_CL_RightTemp.getValue(); pA_CL_LeftTemp = new PATypes.PA_CL_LeftTemp(); arrayOfByte174 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte174)); onPA_CL_LeftTemp(pA_CL_LeftTemp);case 33324: this.data = (byte[])pA_CL_LeftTemp.getValue(); pA_CL_FanLevel = new PATypes.PA_CL_FanLevel(); arrayOfByte174 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte174)); onPA_CL_FanLevel(pA_CL_FanLevel);case 33323: this.data = (byte[])pA_CL_FanLevel.getValue(); pA_CL_MaxAC = new PATypes.PA_CL_MaxAC(); arrayOfByte6 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte6)); onPA_CL_MaxAC(pA_CL_MaxAC);case 33322: this.data = (byte[])arrayOfByte6.getValue(); pA_CL_ModeSec = new PATypes.PA_CL_ModeSec(); arrayOfByte6 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte6)); onPA_CL_ModeSec(pA_CL_ModeSec);case 33321: this.data = (byte[])arrayOfByte6.getValue(); pA_CL_ModeFrstRight = new PATypes.PA_CL_ModeFrstRight(); arrayOfByte6 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte6)); onPA_CL_ModeFrstRight(pA_CL_ModeFrstRight);case 33320: this.data = (byte[])arrayOfByte6.getValue(); pA_CL_ModeFrstLeft = new PATypes.PA_CL_ModeFrstLeft(); arrayOfByte6 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte6)); onPA_CL_ModeFrstLeft(pA_CL_ModeFrstLeft);case 33319: this.data = (byte[])arrayOfByte6.getValue(); pA_CL_Recirc = new PATypes.PA_CL_Recirc(); arrayOfByte173 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte173)); onPA_CL_Recirc(pA_CL_Recirc);case 33318: this.data = (byte[])pA_CL_Recirc.getValue(); pA_CL_Auto = new PATypes.PA_CL_Auto(); arrayOfByte5 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte5)); onPA_CL_Auto(pA_CL_Auto);case 33317: this.data = (byte[])arrayOfByte5.getValue(); pA_CL_AC = new PATypes.PA_CL_AC(); arrayOfByte5 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte5)); onPA_CL_AC(pA_CL_AC);case 33316: this.data = (byte[])arrayOfByte5.getValue(); pA_Asy_EMA = new PATypes.PA_Asy_EMA(); arrayOfByte5 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte5)); onPA_Asy_EMA(pA_Asy_EMA);case 33315: this.data = (byte[])arrayOfByte5.getValue(); pA_Asy_ELKA = new PATypes.PA_Asy_ELKA(); arrayOfByte5 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte5)); onPA_Asy_ELKA(pA_Asy_ELKA);case 33314: this.data = (byte[])arrayOfByte5.getValue(); pA_Asy_LKA_Warning_Mode = new PATypes.PA_Asy_LKA_Warning_Mode(); arrayOfByte172 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte172)); onPA_Asy_LKA_Warning_Mode(pA_Asy_LKA_Warning_Mode);case 33313: this.data = (byte[])pA_Asy_LKA_Warning_Mode.getValue(); pA_Asy_LKA_Mode = new PATypes.PA_Asy_LKA_Mode(); arrayOfByte172 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte172)); onPA_Asy_LKA_Mode(pA_Asy_LKA_Mode);case 33312: this.data = (byte[])pA_Asy_LKA_Mode.getValue(); pA_Asy_LKA = new PATypes.PA_Asy_LKA(); arrayOfByte4 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte4)); onPA_Asy_LKA(pA_Asy_LKA);case 33311: this.data = (byte[])arrayOfByte4.getValue(); pA_Asy_DOW = new PATypes.PA_Asy_DOW(); arrayOfByte4 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte4)); onPA_Asy_DOW(pA_Asy_DOW);case 33310: this.data = (byte[])arrayOfByte4.getValue(); pA_Asy_RCTA = new PATypes.PA_Asy_RCTA(); arrayOfByte4 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte4)); onPA_Asy_RCTA(pA_Asy_RCTA);case 33309: this.data = (byte[])arrayOfByte4.getValue(); pA_Asy_RCW = new PATypes.PA_Asy_RCW(); arrayOfByte4 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte4)); onPA_Asy_RCW(pA_Asy_RCW);case 33308: this.data = (byte[])arrayOfByte4.getValue(); pA_Asy_LCA_Warning = new PATypes.PA_Asy_LCA_Warning(); arrayOfByte4 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte4)); onPA_Asy_LCA_Warning(pA_Asy_LCA_Warning);case 33307: this.data = (byte[])arrayOfByte4.getValue(); pA_Asy_LCA = new PATypes.PA_Asy_LCA(); arrayOfByte4 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte4)); onPA_Asy_LCA(pA_Asy_LCA);case 33306: this.data = (byte[])arrayOfByte4.getValue(); pA_Asy_CMS_Warning = new PATypes.PA_Asy_CMS_Warning(); arrayOfByte171 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte171)); onPA_Asy_CMS_Warning(pA_Asy_CMS_Warning);case 33305: this.data = (byte[])pA_Asy_CMS_Warning.getValue(); pA_Asy_CMS = new PATypes.PA_Asy_CMS(); arrayOfByte171 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte171)); onPA_Asy_CMS(pA_Asy_CMS);case 33304: this.data = (byte[])pA_Asy_CMS.getValue(); pA_Asy_DPS_Reminder = new PATypes.PA_Asy_DPS_Reminder(); arrayOfByte3 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte3)); onPA_Asy_DPS_Reminder(pA_Asy_DPS_Reminder);case 33303: this.data = (byte[])arrayOfByte3.getValue(); pA_Asy_DPS = new PATypes.PA_Asy_DPS(); arrayOfByte3 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte3)); onPA_Asy_DPS(pA_Asy_DPS);case 33302: this.data = (byte[])arrayOfByte3.getValue(); pA_Asy_ELOW = new PATypes.PA_Asy_ELOW(); arrayOfByte170 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte170)); onPA_Asy_ELOW(pA_Asy_ELOW);case 33301: this.data = (byte[])pA_Asy_ELOW.getValue(); pA_Asy_TLA_Sound_Warning = new PATypes.PA_Asy_TLA_Sound_Warning(); arrayOfByte2 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte2)); onPA_Asy_TLA_Sound_Warning(pA_Asy_TLA_Sound_Warning);case 33300: this.data = (byte[])arrayOfByte2.getValue(); pA_Asy_TLA = new PATypes.PA_Asy_TLA(); arrayOfByte169 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte169)); onPA_Asy_TLA(pA_Asy_TLA);case 33299: this.data = (byte[])pA_Asy_TLA.getValue(); pA_Asy_SpeedCompensation = new PATypes.PA_Asy_SpeedCompensation(); arrayOfByte1 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte1)); onPA_Asy_SpeedCompensation(pA_Asy_SpeedCompensation);
/*      */         case 33298: this.data = (byte[])arrayOfByte1.getValue(); pA_Asy_TSR_Warning = new PATypes.PA_Asy_TSR_Warning(); arrayOfByte168 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte168)); onPA_Asy_TSR_Warning(pA_Asy_TSR_Warning);
/*      */         case 33297: this.data = (byte[])pA_Asy_TSR_Warning.getValue(); pA_Asy_OtherTSR = new PATypes.PA_Asy_OtherTSR(); arrayOfByte168 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte168)); onPA_Asy_OtherTSR(pA_Asy_OtherTSR);
/*      */         case 33296: this.data = (byte[])pA_Asy_OtherTSR.getValue(); pA_Asy_TSR = new PATypes.PA_Asy_TSR(); arrayOfByte168 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte168)); onPA_Asy_TSR(pA_Asy_TSR);
/*      */         case 33295: this.data = (byte[])pA_Asy_TSR.getValue(); pA_Asy_HWA = new PATypes.PA_Asy_HWA(); arrayOfByte168 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte168)); onPA_Asy_HWA(pA_Asy_HWA);
/* 4066 */         case 33294: break; }  this.data = (byte[])pA_Asy_HWA.getValue(); PATypes.PA_Asy_ACCandTSR pA_Asy_ACCandTSR = new PATypes.PA_Asy_ACCandTSR(); byte[] arrayOfByte168 = this.data; this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte168)); onPA_Asy_ACCandTSR(pA_Asy_ACCandTSR); } catch (Exception exception)
/* 4067 */     { exception.printStackTrace(); }
/*      */      } public Object convertPAData(ECarXCarPropertyValue paramECarXCarPropertyValue) { try {
/*      */       byte[] arrayOfByte628; PATypes.PA_VehMdlClrReq pA_VehMdlClrReq; byte[] arrayOfByte627; PATypes.PA_TurnEntryAgWideVisReq pA_TurnEntryAgWideVisReq; byte[] arrayOfByte626; PATypes.PA_TopVisnDispExtnReq pA_TopVisnDispExtnReq; byte[] arrayOfByte625; PATypes.PA_ThrDTouringViewReq pA_ThrDTouringViewReq; byte[] arrayOfByte624; PATypes.PA_SurrndgsObjDetnReq pA_SurrndgsObjDetnReq; byte[] arrayOfByte623; PATypes.PA_PrkgIndcrLineReq pA_PrkgIndcrLineReq; byte[] arrayOfByte622; PATypes.PA_HudDispModSetgReq pA_HudDispModSetgReq; byte[] arrayOfByte621; PATypes.PA_FaceSgnInForProf pA_FaceSgnInForProf; byte[] arrayOfByte620; PATypes.PA_FaceIdnReq pA_FaceIdnReq; byte[] arrayOfByte619; PATypes.PA_CnclFaceReqForProf pA_CnclFaceReqForProf; byte[] arrayOfByte618; PATypes.PA_VehCharg_ChargingColumn pA_VehCharg_ChargingColumn; byte[] arrayOfByte617; PATypes.PA_SCEMOD_SceneModSeldCustomization pA_SCEMOD_SceneModSeldCustomization; byte[] arrayOfByte616; PATypes.PA_SCEMOD_SceneModSeldQuitStranger pA_SCEMOD_SceneModSeldQuitStranger; byte[] arrayOfByte615; PATypes.PA_SENSOR_JoyForbidState pA_SENSOR_JoyForbidState; byte[] arrayOfByte614; PATypes.PA_SENSOR_JoyLimitState pA_SENSOR_JoyLimitState; byte[] arrayOfByte613; PATypes.PA_SENSOR_EngHrToSrvValue pA_SENSOR_EngHrToSrvValue; byte[] arrayOfByte612; PATypes.PA_SENSOR_DayToSrvValue pA_SENSOR_DayToSrvValue; byte[] arrayOfByte611; PATypes.PA_SENSOR_DstToSrvValue pA_SENSOR_DstToSrvValue; byte[] arrayOfByte610; PATypes.PA_FD_FaceIdnReq pA_FD_FaceIdnReq; byte[] arrayOfByte609; PATypes.PA_SCEMOD_SceneModSeldPassengerRepose pA_SCEMOD_SceneModSeldPassengerRepose; byte[] arrayOfByte608; PATypes.PA_SCEMOD_PassSceneModSeldValue pA_SCEMOD_PassSceneModSeldValue; byte[] arrayOfByte607; PATypes.PA_SCEMOD_SceneModSeldGoddess pA_SCEMOD_SceneModSeldGoddess; byte[] arrayOfByte606; PATypes.PA_SCEMOD_SceneModSeldValue pA_SCEMOD_SceneModSeldValue; byte[] arrayOfByte605; PATypes.PA_SCEMOD_SceneModSeldKing pA_SCEMOD_SceneModSeldKing; byte[] arrayOfByte604; PATypes.PA_SCEMOD_SceneModSeldEco pA_SCEMOD_SceneModSeldEco; byte[] arrayOfByte603; PATypes.PA_SCEMOD_SceneModSeldRearRowTheater pA_SCEMOD_SceneModSeldRearRowTheater; byte[] arrayOfByte602; PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater pA_SCEMOD_SceneModSeldFrontRowTheater; byte[] arrayOfByte601; PATypes.PA_SCEMOD_SceneModSeldSecondRightRest pA_SCEMOD_SceneModSeldSecondRightRest; byte[] arrayOfByte600; PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest pA_SCEMOD_SceneModSeldSecondLeftRest; byte[] arrayOfByte599; PATypes.PA_SCEMOD_SceneModSeldPassengerRest pA_SCEMOD_SceneModSeldPassengerRest; byte[] arrayOfByte598; PATypes.PA_SCEMOD_SceneModSeldDriverRest pA_SCEMOD_SceneModSeldDriverRest; byte[] arrayOfByte597; PATypes.PA_SCEMOD_SceneModSeldChild pA_SCEMOD_SceneModSeldChild; byte[] arrayOfByte596; PATypes.PA_SCEMOD_SceneModSeldBiochal pA_SCEMOD_SceneModSeldBiochal; byte[] arrayOfByte595; PATypes.PA_SCEMOD_SceneModSeldStranger pA_SCEMOD_SceneModSeldStranger; byte[] arrayOfByte594; PATypes.PA_SCEMOD_SceneModSeldCarWash pA_SCEMOD_SceneModSeldCarWash; byte[] arrayOfByte593; PATypes.PA_SCEMOD_SceneModSeldPet pA_SCEMOD_SceneModSeldPet; byte[] arrayOfByte592; PATypes.PA_SCEMOD_SceneModSeldRomantic pA_SCEMOD_SceneModSeldRomantic; byte[] arrayOfByte591; PATypes.PA_SCEMOD_SceneModSeldWakeUp pA_SCEMOD_SceneModSeldWakeUp; byte[] arrayOfByte590; PATypes.PA_TS_CurTripTime pA_TS_CurTripTime; byte[] arrayOfByte589; PATypes.PA_TS_CurTripDis pA_TS_CurTripDis; byte[] arrayOfByte588; PATypes.PA_NAVI_VehEgyCoornFctStChg pA_NAVI_VehEgyCoornFctStChg; byte[] arrayOfByte587; PATypes.PA_NAVI_VehEgyCoornOpenAndCls pA_NAVI_VehEgyCoornOpenAndCls; byte[] arrayOfByte586; PATypes.PA_HUD_DispModSet pA_HUD_DispModSet; PATypes.PA_PSET_NameP5 pA_PSET_NameP5; PATypes.PA_PSET_NameP4 pA_PSET_NameP4; PATypes.PA_PSET_NameP3 pA_PSET_NameP3; PATypes.PA_PSET_NameP2 pA_PSET_NameP2; PATypes.PA_PSET_NameP1 pA_PSET_NameP1; byte[] arrayOfByte585; PATypes.PA_AmbLi_MsgEnd pA_AmbLi_MsgEnd; byte[] arrayOfByte584; PATypes.PA_VM2_MsgEnd pA_VM2_MsgEnd; byte[] arrayOfByte583; PATypes.PA_VM_MsgEnd pA_VM_MsgEnd; byte[] arrayOfByte582; PATypes.PA_WPC_MsgEnd pA_WPC_MsgEnd; byte[] arrayOfByte581; PATypes.PA_VehCharg_MsgEnd pA_VehCharg_MsgEnd; byte[] arrayOfByte580; PATypes.PA_SC_MsgEnd pA_SC_MsgEnd; byte[] arrayOfByte579; PATypes.PA_PAS_MsgEnd pA_PAS_MsgEnd; byte[] arrayOfByte578; PATypes.PA_PAC_MsgEnd pA_PAC_MsgEnd; byte[] arrayOfByte577; PATypes.PA_VFC_MsgEnd pA_VFC_MsgEnd; byte[] arrayOfByte576; PATypes.PA_HUD_MsgEnd pA_HUD_MsgEnd; byte[] arrayOfByte575; PATypes.PA_Device_MsgEnd pA_Device_MsgEnd; byte[] arrayOfByte574; PATypes.PA_SS_MsgEnd pA_SS_MsgEnd; byte[] arrayOfByte573; PATypes.PA_PSET_MsgEnd pA_PSET_MsgEnd; byte[] arrayOfByte572; PATypes.PA_DriveMode_MsgEnd pA_DriveMode_MsgEnd; byte[] arrayOfByte571; PATypes.PA_TCH_MsgEnd pA_TCH_MsgEnd; byte[] arrayOfByte570; PATypes.PA_Fragra_MsgEnd pA_Fragra_MsgEnd; byte[] arrayOfByte569; PATypes.PA_SWH_MsgEnd pA_SWH_MsgEnd; byte[] arrayOfByte568; PATypes.PA_SCV_MsgEnd pA_SCV_MsgEnd; byte[] arrayOfByte567; PATypes.PA_CL_MsgEnd pA_CL_MsgEnd; byte[] arrayOfByte566; PATypes.PA_DID_MsgEnd pA_DID_MsgEnd; byte[] arrayOfByte565; PATypes.PA_DiagProxy_MsgEnd pA_DiagProxy_MsgEnd; byte[] arrayOfByte564; PATypes.PA_Asy_MsgEnd pA_Asy_MsgEnd; byte[] arrayOfByte563; PATypes.PA_TS_MsgEnd pA_TS_MsgEnd; byte[] arrayOfByte562; PATypes.PA_AP_Version pA_AP_Version; byte[] arrayOfByte561; PATypes.PA_AmpDiagResult pA_AmpDiagResult; byte[] arrayOfByte560; PATypes.PA_PSET_ProfilesInuse pA_PSET_ProfilesInuse; byte[] arrayOfByte559; PATypes.PA_PSET_ProfileDownloadStatus pA_PSET_ProfileDownloadStatus; PATypes.PA_PSET_ProfileCloudData pA_PSET_ProfileCloudData; byte[] arrayOfByte558; PATypes.PA_PSET_ProfAct pA_PSET_ProfAct; byte[] arrayOfByte557; PATypes.PA_PSET_GID_Result pA_PSET_GID_Result; byte[] arrayOfByte556; PATypes.PA_PSET_SeatLocationAdjust pA_PSET_SeatLocationAdjust; byte[] arrayOfByte555; PATypes.PA_PSET_SeatButtonOnOff pA_PSET_SeatButtonOnOff; byte[] arrayOfByte554; PATypes.PA_PSET_User6 pA_PSET_User6; byte[] arrayOfByte553; PATypes.PA_PSET_User5 pA_PSET_User5; byte[] arrayOfByte552; PATypes.PA_PSET_User4 pA_PSET_User4; byte[] arrayOfByte551; PATypes.PA_PSET_User3 pA_PSET_User3; byte[] arrayOfByte550; PATypes.PA_PSET_User2 pA_PSET_User2; byte[] arrayOfByte549; PATypes.PA_PSET_User1 pA_PSET_User1; byte[] arrayOfByte548; PATypes.PA_PSET_SimplUnlockCurrent pA_PSET_SimplUnlockCurrent; byte[] arrayOfByte547; PATypes.PA_PSET_NFC_Result pA_PSET_NFC_Result; byte[] arrayOfByte546; PATypes.PA_PSET_NFCID pA_PSET_NFCID; byte[] arrayOfByte545; PATypes.PA_PSET_LYNKID_Result pA_PSET_LYNKID_Result; byte[] arrayOfByte544; PATypes.PA_PSET_LYNKID pA_PSET_LYNKID; byte[] arrayOfByte543; PATypes.PA_PSET_AutLogOutCurrent pA_PSET_AutLogOutCurrent; byte[] arrayOfByte542; PATypes.PA_PSET_MaxNrProfReached pA_PSET_MaxNrProfReached; byte[] arrayOfByte541; PATypes.PA_PSET_PChangeAllowed pA_PSET_PChangeAllowed; byte[] arrayOfByte540; PATypes.PA_PSET_KeyID pA_PSET_KeyID; byte[] arrayOfByte539; PATypes.PA_PSET_Key_Result pA_PSET_Key_Result; byte[] arrayOfByte538; PATypes.PA_PSET_FactoryDefaultResult pA_PSET_FactoryDefaultResult; byte[] arrayOfByte537; PATypes.PA_PSET_FactoryDefault pA_PSET_FactoryDefault; byte[] arrayOfByte536; PATypes.PA_PSET_ProfileFactoryDefaultResult pA_PSET_ProfileFactoryDefaultResult; byte[] arrayOfByte535; PATypes.PA_PSET_ProfileFactoryDefault pA_PSET_ProfileFactoryDefault; byte[] arrayOfByte534; PATypes.PA_PSET_LogOut pA_PSET_LogOut; byte[] arrayOfByte533; PATypes.PA_PSET_DeleteProfile pA_PSET_DeleteProfile; byte[] arrayOfByte532; PATypes.PA_PSET_NewProfile pA_PSET_NewProfile; byte[] arrayOfByte531; PATypes.PA_PSET_ActiveProfile pA_PSET_ActiveProfile; byte[] arrayOfByte530; PATypes.PA_VFS_DPS pA_VFS_DPS; byte[] arrayOfByte529; PATypes.PA_VFS_FaceIdnReq pA_VFS_FaceIdnReq; byte[] arrayOfByte528; PATypes.PA_ChdLockReRight_ChdMod pA_ChdLockReRight_ChdMod; byte[] arrayOfByte527; PATypes.PA_ChdLockReLeft_ChdMod pA_ChdLockReLeft_ChdMod; byte[] arrayOfByte526; PATypes.PA_ChdLockReRight pA_ChdLockReRight; byte[] arrayOfByte525; PATypes.PA_ChdLockReLeft pA_ChdLockReLeft; byte[] arrayOfByte524; PATypes.PA_WinPosnStsAtReRi pA_WinPosnStsAtReRi; byte[] arrayOfByte523; PATypes.PA_WinPosnStsAtReLe pA_WinPosnStsAtReLe; byte[] arrayOfByte522; PATypes.PA_WinPosnStsAtPass pA_WinPosnStsAtPass; byte[] arrayOfByte521; PATypes.PA_WinPosnStsAtDrvr pA_WinPosnStsAtDrvr; byte[] arrayOfByte520; PATypes.PA_WinOpenReRiReq pA_WinOpenReRiReq; byte[] arrayOfByte519; PATypes.PA_WinOpenReLeReq pA_WinOpenReLeReq; byte[] arrayOfByte518; PATypes.PA_WinOpenPassReq pA_WinOpenPassReq; byte[] arrayOfByte517; PATypes.PA_WinOpenDrvrReq pA_WinOpenDrvrReq; byte[] arrayOfByte516; PATypes.PA_EgyRgnLvlSet pA_EgyRgnLvlSet; byte[] arrayOfByte515; PATypes.PA_AmbLiRadarCorrlnReq pA_AmbLiRadarCorrlnReq; byte[] arrayOfByte514; PATypes.PA_MoodLiColorAdjReq pA_MoodLiColorAdjReq; byte[] arrayOfByte513; PATypes.PA_CustomEffectBreath pA_CustomEffectBreath; byte[] arrayOfByte512; PATypes.PA_ReadLightAllOnSwitch pA_ReadLightAllOnSwitch; byte[] arrayOfByte511; PATypes.PA_GoodbyeLight pA_GoodbyeLight; byte[] arrayOfByte510; PATypes.PA_WelcomeLight pA_WelcomeLight; byte[] arrayOfByte509; PATypes.PA_CourtesyLight pA_CourtesyLight; byte[] arrayOfByte508; PATypes.PA_WeatherInfoConService pA_WeatherInfoConService; byte[] arrayOfByte507; PATypes.PA_ReadLightThirdRowRight pA_ReadLightThirdRowRight; byte[] arrayOfByte506; PATypes.PA_ReadLightThirdRowLeft pA_ReadLightThirdRowLeft; byte[] arrayOfByte505; PATypes.PA_ReadLightSecondRowRight pA_ReadLightSecondRowRight; byte[] arrayOfByte504; PATypes.PA_ReadLightSecondRowLeft pA_ReadLightSecondRowLeft; byte[] arrayOfByte503; PATypes.PA_ReadLightFrontRight pA_ReadLightFrontRight; byte[] arrayOfByte502; PATypes.PA_ReadLightFrontLeft pA_ReadLightFrontLeft; byte[] arrayOfByte501; PATypes.PA_AmbLiPhoneOpenReq pA_AmbLiPhoneOpenReq; byte[] arrayOfByte500; PATypes.PA_AmbLiMilgOpenReq pA_AmbLiMilgOpenReq; byte[] arrayOfByte499; PATypes.PA_MoodLightSwitch pA_MoodLightSwitch; byte[] arrayOfByte498; PATypes.PA_Zone3ColorSettings pA_Zone3ColorSettings; byte[] arrayOfByte497; PATypes.PA_Zone3IntensitySettings pA_Zone3IntensitySettings; byte[] arrayOfByte496; PATypes.PA_Zone3StatusSettings pA_Zone3StatusSettings; byte[] arrayOfByte495; PATypes.PA_Zone2ColorSettings pA_Zone2ColorSettings; byte[] arrayOfByte494; PATypes.PA_Zone2IntensitySettings pA_Zone2IntensitySettings; byte[] arrayOfByte493; PATypes.PA_Zone2StatusSettings pA_Zone2StatusSettings; byte[] arrayOfByte492; PATypes.PA_Zone1ColorSettings pA_Zone1ColorSettings; byte[] arrayOfByte491; PATypes.PA_Zone1IntensitySettings pA_Zone1IntensitySettings; byte[] arrayOfByte490; PATypes.PA_Zone1StatusSettings pA_Zone1StatusSettings; byte[] arrayOfByte489; PATypes.PA_ZoneAllColorSettings pA_ZoneAllColorSettings; byte[] arrayOfByte488; PATypes.PA_ZoneAllIntensitySettings pA_ZoneAllIntensitySettings; byte[] arrayOfByte487; PATypes.PA_ZoneAllStatusSettings pA_ZoneAllStatusSettings; byte[] arrayOfByte486; PATypes.PA_TransitionColor2Settings pA_TransitionColor2Settings; byte[] arrayOfByte485; PATypes.PA_TransitionColor1Settings pA_TransitionColor1Settings; byte[] arrayOfByte484; PATypes.PA_TransitionEffectSel pA_TransitionEffectSel; byte[] arrayOfByte483; PATypes.PA_CustomEffect pA_CustomEffect; byte[] arrayOfByte482; PATypes.PA_AmbLiMod_WeatherIndn pA_AmbLiMod_WeatherIndn; byte[] arrayOfByte481; PATypes.PA_AmbLiMod_MusicShowMode pA_AmbLiMod_MusicShowMode; byte[] arrayOfByte480; PATypes.PA_AmbLiMod_DriveMode pA_AmbLiMod_DriveMode; byte[] arrayOfByte479; PATypes.PA_AmbLiMod_CustomizedMode pA_AmbLiMod_CustomizedMode; byte[] arrayOfByte478; PATypes.PA_AmbLiMod_None pA_AmbLiMod_None; byte[] arrayOfByte477; PATypes.PA_AmbLiModSetting pA_AmbLiModSetting; byte[] arrayOfByte476; PATypes.PA_AmbLiAll pA_AmbLiAll; byte[] arrayOfByte475; PATypes.PA_HmiCarLocatorSetReq pA_HmiCarLocatorSetReq; byte[] arrayOfByte474; PATypes.PA_SunRoofTiltReq pA_SunRoofTiltReq; byte[] arrayOfByte473; PATypes.PA_SunCurtOpenPosnReq pA_SunCurtOpenPosnReq; byte[] arrayOfByte472; PATypes.PA_SunRoofOpenPosnReq pA_SunRoofOpenPosnReq; byte[] arrayOfByte471; PATypes.PA_SunCurtainPosnSts pA_SunCurtainPosnSts; byte[] arrayOfByte470; PATypes.PA_SunRoofPosnSts pA_SunRoofPosnSts; byte[] arrayOfByte469; PATypes.PA_CloseSunCurtain_Btn pA_CloseSunCurtain_Btn; byte[] arrayOfByte468; PATypes.PA_OpenSunCurtain_Btn pA_OpenSunCurtain_Btn; byte[] arrayOfByte467; PATypes.PA_CloseSunRoof_Btn pA_CloseSunRoof_Btn; byte[] arrayOfByte466; PATypes.PA_OpenSunRoof_Btn pA_OpenSunRoof_Btn; byte[] arrayOfByte465; PATypes.PA_SunCurtain_Setting pA_SunCurtain_Setting; byte[] arrayOfByte464; PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb pA_VehCharg_ChrgnOrDisChrgnStsFb; byte[] arrayOfByte463; PATypes.PA_VehCharg_HvBattChrgnTiEstimd pA_VehCharg_HvBattChrgnTiEstimd; byte[] arrayOfByte462; PATypes.PA_VehCharg_OnBdChrgrIAct pA_VehCharg_OnBdChrgrIAct; byte[] arrayOfByte461; PATypes.PA_VehCharg_OnBdChrgrUAct pA_VehCharg_OnBdChrgrUAct; byte[] arrayOfByte460; PATypes.PA_VehCharg_DispHvBattLvlOfChrg pA_VehCharg_DispHvBattLvlOfChrg; byte[] arrayOfByte459; PATypes.PA_VehCharg_DchaEgyAct pA_VehCharg_DchaEgyAct; byte[] arrayOfByte458; PATypes.PA_VehCharg_HvBattDchaTiEstimd pA_VehCharg_HvBattDchaTiEstimd; byte[] arrayOfByte457; PATypes.PA_VehCharg_DchaIAct pA_VehCharg_DchaIAct; byte[] arrayOfByte456; PATypes.PA_VehCharg_DchaUAct pA_VehCharg_DchaUAct; byte[] arrayOfByte455; PATypes.PA_VehCharg_DisChargeRecord pA_VehCharg_DisChargeRecord; byte[] arrayOfByte454; PATypes.PA_VehCharg_DisChargeSwitch pA_VehCharg_DisChargeSwitch; byte[] arrayOfByte453; PATypes.PA_VehCharg_DisChargInfoShow pA_VehCharg_DisChargInfoShow; byte[] arrayOfByte452; PATypes.PA_VehCharg_DisChargSOC pA_VehCharg_DisChargSOC; byte[] arrayOfByte451; PATypes.PA_VehCharg_Appointment pA_VehCharg_Appointment; byte[] arrayOfByte450; PATypes.PA_VehCharg_ChargLight pA_VehCharg_ChargLight; byte[] arrayOfByte449; PATypes.PA_VehCharg_ChargInfoShow pA_VehCharg_ChargInfoShow; byte[] arrayOfByte448; PATypes.PA_VehCharg_ChargSt pA_VehCharg_ChargSt; byte[] arrayOfByte447; PATypes.PA_VehCharg_SetSOC pA_VehCharg_SetSOC; byte[] arrayOfByte446; PATypes.PA_VehCharg_SetA pA_VehCharg_SetA; byte[] arrayOfByte445; PATypes.PA_VehCharg_ChargRemind pA_VehCharg_ChargRemind; byte[] arrayOfByte444; PATypes.PA_TS_energyReStats100 pA_TS_energyReStats100; byte[] arrayOfByte443; PATypes.PA_TS_energyReStats10 pA_TS_energyReStats10; byte[] arrayOfByte442; PATypes.PA_TS_energyStats100 pA_TS_energyStats100; byte[] arrayOfByte441; PATypes.PA_TS_energyStats10 pA_TS_energyStats10; byte[] arrayOfByte440; PATypes.PA_TS_fuelStats100 pA_TS_fuelStats100; byte[] arrayOfByte439; PATypes.PA_TS_fuelStats10 pA_TS_fuelStats10; byte[] arrayOfByte438; PATypes.PA_TS_TripAverageEnConsumption5Km pA_TS_TripAverageEnConsumption5Km; byte[] arrayOfByte437; PATypes.PA_TS_TripAverageEnConsumption05Km pA_TS_TripAverageEnConsumption05Km; byte[] arrayOfByte436; PATypes.PA_TS_TripAverageConsumption5Km pA_TS_TripAverageConsumption5Km; byte[] arrayOfByte435; PATypes.PA_TS_TripAverageConsumption05Km pA_TS_TripAverageConsumption05Km; byte[] arrayOfByte434; PATypes.PA_TS_OdometerTripMeter2 pA_TS_OdometerTripMeter2; byte[] arrayOfByte433; PATypes.PA_TS_Zero_Emission pA_TS_Zero_Emission; byte[] arrayOfByte432; PATypes.PA_TS_EDT_time2 pA_TS_EDT_time2; byte[] arrayOfByte431; PATypes.PA_TS_DTEHV_round pA_TS_DTEHV_round; byte[] arrayOfByte430; PATypes.PA_TS_DTEHVBattIndicated pA_TS_DTEHVBattIndicated; byte[] arrayOfByte429; PATypes.PA_TS_DTEIndicated pA_TS_DTEIndicated; PATypes.PA_D0D0 pA_D0D0; PATypes.PA_D0D1 pA_D0D1; PATypes.PA_D0D2 pA_D0D2; byte[] arrayOfByte428; PATypes.PA_Privacy_Compliance_Reset pA_Privacy_Compliance_Reset; byte[] arrayOfByte427; PATypes.PA_AuthorityMicrophoneSwitch pA_AuthorityMicrophoneSwitch; byte[] arrayOfByte426; PATypes.PA_AuthorityCameraSwitch pA_AuthorityCameraSwitch; byte[] arrayOfByte425; PATypes.PA_AuthorityLocationSwitch pA_AuthorityLocationSwitch; byte[] arrayOfByte424; PATypes.PA_FD92 pA_FD92; byte[] arrayOfByte423; PATypes.PA_FD91 pA_FD91; byte[] arrayOfByte422; PATypes.PA_FD86 pA_FD86; byte[] arrayOfByte421; PATypes.PA_FD88 pA_FD88; PATypes.PA_FD85 pA_FD85; PATypes.PA_FD62 pA_FD62; PATypes.PA_FD43 pA_FD43; PATypes.PA_FD41 pA_FD41; PATypes.PA_FD44 pA_FD44; PATypes.PA_FD42 pA_FD42; PATypes.PA_FD23 pA_FD23; PATypes.PA_FD30 pA_FD30; PATypes.PA_FD5A pA_FD5A; PATypes.PA_FD17 pA_FD17; PATypes.PA_FD12 pA_FD12; PATypes.PA_FD29 pA_FD29; byte[] arrayOfByte420; PATypes.PA_FD39 pA_FD39; byte[] arrayOfByte419; PATypes.PA_FD28 pA_FD28; byte[] arrayOfByte418; PATypes.PA_FD27 pA_FD27; byte[] arrayOfByte417; PATypes.PA_FD26 pA_FD26; byte[] arrayOfByte416; PATypes.PA_CSDM_PSD_EN pA_CSDM_PSD_EN; byte[] arrayOfByte415; PATypes.PA_D907 pA_D907; byte[] arrayOfByte414; PATypes.PA_Manufacturing_Signal pA_Manufacturing_Signal; PATypes.PA_VolvoHWSD_Reading pA_VolvoHWSD_Reading; PATypes.PA_VolvoDelivery_Assemble_Reading pA_VolvoDelivery_Assemble_Reading; PATypes.PA_GeelyHSWD_Reading pA_GeelyHSWD_Reading; PATypes.PA_Geely_Delivery_Assemble_Reading pA_Geely_Delivery_Assemble_Reading; PATypes.PA_HW_Version_Reading pA_HW_Version_Reading; PATypes.PA_IHUID_Reading pA_IHUID_Reading; PATypes.PA_XDSN_Reading pA_XDSN_Reading; PATypes.PA_Product_Serial_Number pA_Product_Serial_Number; byte[] arrayOfByte413; PATypes.PA_Dcm_D912_PSD_MONITOR_EN pA_Dcm_D912_PSD_MONITOR_EN; byte[] arrayOfByte412; PATypes.PA_Chat_Video_IN pA_Chat_Video_IN; byte[] arrayOfByte411; PATypes.PA_Gesture_Video_IN pA_Gesture_Video_IN; byte[] arrayOfByte410; PATypes.PA_DVR_Video_IN pA_DVR_Video_IN; byte[] arrayOfByte409; PATypes.PA_PASWAM_Video_in pA_PASWAM_Video_in; byte[] arrayOfByte408; PATypes.PA_CSD_MONITOR_EN pA_CSD_MONITOR_EN; PATypes.PA_DiagProxy_Psd_GW_Fun pA_DiagProxy_Psd_GW_Fun; PATypes.PA_DiagProxy_Psd_GW_Phy pA_DiagProxy_Psd_GW_Phy; PATypes.PA_DiagProxy_Csdm_GW_Fun pA_DiagProxy_Csdm_GW_Fun; PATypes.PA_DiagProxy_Csdm_GW_Phy pA_DiagProxy_Csdm_GW_Phy; PATypes.PA_DiagProxy_Csd_GW_Fun pA_DiagProxy_Csd_GW_Fun; PATypes.PA_DiagProxy_Csd_GW_Phy pA_DiagProxy_Csd_GW_Phy; PATypes.PA_DiagProxy_Status pA_DiagProxy_Status; byte[] arrayOfByte407; PATypes.PA_HealthOfEngOil pA_HealthOfEngOil; byte[] arrayOfByte406; PATypes.PA_NatUsgDayOfOil pA_NatUsgDayOfOil; byte[] arrayOfByte405; PATypes.PA_DstTrvldOfEng pA_DstTrvldOfEng; byte[] arrayOfByte404; PATypes.PA_DstTrvldOfEV pA_DstTrvldOfEV; byte[] arrayOfByte403; PATypes.PA_DstTrvldAct pA_DstTrvldAct; byte[] arrayOfByte402; PATypes.PA_ServiceReminderType pA_ServiceReminderType; byte[] arrayOfByte401; PATypes.PA_Locking_ApproachToOpenTrSwt pA_Locking_ApproachToOpenTrSwt; byte[] arrayOfByte400; PATypes.PA_DoubleLock pA_DoubleLock; byte[] arrayOfByte399; PATypes.PA_RearMirrors pA_RearMirrors; byte[] arrayOfByte398; PATypes.PA_UnlckTrunk pA_UnlckTrunk; byte[] arrayOfByte397; PATypes.PA_LifeDetectionSwitch pA_LifeDetectionSwitch; byte[] arrayOfByte396; PATypes.PA_PowerFlow_HEV pA_PowerFlow_HEV; byte[] arrayOfByte395; PATypes.PA_IntelligentFuSave pA_IntelligentFuSave; byte[] arrayOfByte394; PATypes.PA_TripCom_RstAEC pA_TripCom_RstAEC; byte[] arrayOfByte393; PATypes.PA_TripCom_RstAFC pA_TripCom_RstAFC; byte[] arrayOfByte392; PATypes.PA_TripCom_RstEDT pA_TripCom_RstEDT; byte[] arrayOfByte391; PATypes.PA_TripCom_RstAVS pA_TripCom_RstAVS; byte[] arrayOfByte390; PATypes.PA_TripCom_RstTrip pA_TripCom_RstTrip; byte[] arrayOfByte389; PATypes.PA_TripCom_RetALL pA_TripCom_RetALL; byte[] arrayOfByte388; PATypes.PA_RefuleAutoResetSetting pA_RefuleAutoResetSetting; byte[] arrayOfByte387; PATypes.PA_ParkingAutoResetSetting pA_ParkingAutoResetSetting; byte[] arrayOfByte386; PATypes.PA_VINDiffMsg pA_VINDiffMsg; byte[] arrayOfByte385; PATypes.PA_CollectionRadio pA_CollectionRadio; byte[] arrayOfByte384; PATypes.PA_SourceSwitch pA_SourceSwitch; byte[] arrayOfByte383; PATypes.PA_NaviHome pA_NaviHome; byte[] arrayOfByte382; PATypes.PA_360Panorama pA_360Panorama; byte[] arrayOfByte381; PATypes.PA_DVR pA_DVR; byte[] arrayOfByte380; PATypes.PA_ScreenSwitch pA_ScreenSwitch; byte[] arrayOfByte379; PATypes.PA_SelfDefineFuncReq pA_SelfDefineFuncReq; byte[] arrayOfByte378; PATypes.PA_TailgateSts pA_TailgateSts; byte[] arrayOfByte377; PATypes.PA_ElectricTailgate_PosSetting pA_ElectricTailgate_PosSetting; byte[] arrayOfByte376; PATypes.PA_ElectricTailgate_OpenBtn pA_ElectricTailgate_OpenBtn; byte[] arrayOfByte375; PATypes.PA_ElectricTailgate_Setting pA_ElectricTailgate_Setting; byte[] arrayOfByte374; PATypes.PA_ChangeFailMsg pA_ChangeFailMsg; byte[] arrayOfByte373; PATypes.PA_Battery_Charge_Percent pA_Battery_Charge_Percent; byte[] arrayOfByte372; PATypes.PA_PM_Charge pA_PM_Charge; byte[] arrayOfByte371; PATypes.PA_PM_Hold pA_PM_Hold; byte[] arrayOfByte370; PATypes.PA_ElecSeatbelt_Passenger pA_ElecSeatbelt_Passenger; byte[] arrayOfByte369; PATypes.PA_ElecSeatbelt_Driver pA_ElecSeatbelt_Driver; byte[] arrayOfByte368; PATypes.PA_CSDTheme_Setting pA_CSDTheme_Setting; byte[] arrayOfByte367; PATypes.PA_DIMTheme_DrvSetting pA_DIMTheme_DrvSetting; byte[] arrayOfByte366; PATypes.PA_Individualtheme_OnOff pA_Individualtheme_OnOff; byte[] arrayOfByte365; PATypes.PA_LockgFbSoundSet pA_LockgFbSoundSet; byte[] arrayOfByte364; PATypes.PA_TwoStepUnlck_Setting pA_TwoStepUnlck_Setting; byte[] arrayOfByte363; PATypes.PA_PasAcsLock_Setting pA_PasAcsLock_Setting; byte[] arrayOfByte362; PATypes.PA_UnLockSetting pA_UnLockSetting; byte[] arrayOfByte361; PATypes.PA_PowerFlow_MHEV pA_PowerFlow_MHEV; byte[] arrayOfByte360; PATypes.PA_PowerFlow pA_PowerFlow; byte[] arrayOfByte359; PATypes.PA_SailingSwitch pA_SailingSwitch; byte[] arrayOfByte358; PATypes.PA_SpeedWarnSpeedLimit pA_SpeedWarnSpeedLimit; byte[] arrayOfByte357; PATypes.PA_SpeedWarnOnOff pA_SpeedWarnOnOff; byte[] arrayOfByte356; PATypes.PA_LowAlarmVolSet pA_LowAlarmVolSet; byte[] arrayOfByte355; PATypes.PA_SpeedWarnSet pA_SpeedWarnSet; byte[] arrayOfByte354; PATypes.PA_External_Sound_Setting pA_External_Sound_Setting; byte[] arrayOfByte353; PATypes.PA_Total_Traveled_Distance pA_Total_Traveled_Distance; byte[] arrayOfByte352; PATypes.PA_AutoHoldStatus pA_AutoHoldStatus; byte[] arrayOfByte351; PATypes.PA_EPBAutoApply pA_EPBAutoApply; byte[] arrayOfByte350; PATypes.PA_SuspMoveDirInform pA_SuspMoveDirInform; byte[] arrayOfByte349; PATypes.PA_SuspHeiSetting pA_SuspHeiSetting; byte[] arrayOfByte348; PATypes.PA_DeacLevCtrSetting pA_DeacLevCtrSetting; byte[] arrayOfByte347; PATypes.PA_EasyEntrySetting pA_EasyEntrySetting; byte[] arrayOfByte346; PATypes.PA_HillDescentSetting pA_HillDescentSetting; byte[] arrayOfByte345; PATypes.PA_MirrTiltSetg pA_MirrTiltSetg; byte[] arrayOfByte344; PATypes.PA_RearMirrorFold_Auto pA_RearMirrorFold_Auto; byte[] arrayOfByte343; PATypes.PA_WelGoodbyeLightMod pA_WelGoodbyeLightMod; byte[] arrayOfByte342; PATypes.PA_WelGoodbyeLightSwitch pA_WelGoodbyeLightSwitch; byte[] arrayOfByte341; PATypes.PA_LeftRightSetting pA_LeftRightSetting; byte[] arrayOfByte340; PATypes.PA_BendingLight pA_BendingLight; byte[] arrayOfByte339; PATypes.PA_ApproachLightOnOff_Setting pA_ApproachLightOnOff_Setting; byte[] arrayOfByte338; PATypes.PA_AL_HomeSafeLight pA_AL_HomeSafeLight; byte[] arrayOfByte337; PATypes.PA_CornrgLi_Setting pA_CornrgLi_Setting; byte[] arrayOfByte336; PATypes.PA_AFSLight_Setting pA_AFSLight_Setting; byte[] arrayOfByte335; PATypes.PA_PBC_ESCSportActiv pA_PBC_ESCSportActiv; byte[] arrayOfByte334; PATypes.PA_SS_Activation pA_SS_Activation; byte[] arrayOfByte333; PATypes.PA_SteeringWheelPosAdj pA_SteeringWheelPosAdj; byte[] arrayOfByte332; PATypes.PA_Steer_SteeringMod pA_Steer_SteeringMod; byte[] arrayOfByte331; PATypes.PA_Steer_SteerAsscLvl pA_Steer_SteerAsscLvl; byte[] arrayOfByte330; PATypes.PA_FindCaReminder_Setting pA_FindCaReminder_Setting; byte[] arrayOfByte329; PATypes.PA_UUN_RedGuardSts pA_UUN_RedGuardSts; byte[] arrayOfByte328; PATypes.PA_UUN_PasArmngSts pA_UUN_PasArmngSts; byte[] arrayOfByte327; PATypes.PA_WPC_PhoneForget pA_WPC_PhoneForget; byte[] arrayOfByte326; PATypes.PA_WPC_InchargeStatus pA_WPC_InchargeStatus; byte[] arrayOfByte325; PATypes.PA_WPC_Setting pA_WPC_Setting; byte[] arrayOfByte324; PATypes.PA_PassSeatSwtSelnOfSpplFctSts pA_PassSeatSwtSelnOfSpplFctSts; byte[] arrayOfByte323; PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts pA_DrvrSeatSwtSelnOfSpplFctSts; byte[] arrayOfByte322; PATypes.PA_HotStoneMassagePassAllowd pA_HotStoneMassagePassAllowd; byte[] arrayOfByte321; PATypes.PA_HotStoneMassageDrvrAllowd pA_HotStoneMassageDrvrAllowd; byte[] arrayOfByte320; PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts pA_SeatRowSecRiSwtStsPassSeatSwtInclSts; byte[] arrayOfByte319; PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts pA_SeatRowSecLeSwtStsPassSeatSwtInclSts; byte[] arrayOfByte318; PATypes.PA_SecRowSeatInclRiFwdBackwAllowd pA_SecRowSeatInclRiFwdBackwAllowd; byte[] arrayOfByte317; PATypes.PA_SecRowSeatInclLeFwdBackwAllowd pA_SecRowSeatInclLeFwdBackwAllowd; byte[] arrayOfByte316; PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts pA_SeatRowSecRiSwtStsPassSeatSwtSldSts; byte[] arrayOfByte315; PATypes.PA_SecRowSeatLenRiFwdBackwAllowd pA_SecRowSeatLenRiFwdBackwAllowd; byte[] arrayOfByte314; PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts pA_SeatRowSecLeSwtStsPassSeatSwtSldSts; byte[] arrayOfByte313; PATypes.PA_SecRowSeatLenLeFwdBackwAllowd pA_SecRowSeatLenLeFwdBackwAllowd; byte[] arrayOfByte312; PATypes.PA_SeatFoldRaiseRowThrdRiAllowd pA_SeatFoldRaiseRowThrdRiAllowd; byte[] arrayOfByte311; PATypes.PA_SeatFoldRaiseRowThrdLeAllowd pA_SeatFoldRaiseRowThrdLeAllowd; byte[] arrayOfByte310; PATypes.PA_PassMultFuncMenuExt pA_PassMultFuncMenuExt; byte[] arrayOfByte309; PATypes.PA_DrvrMultFuncMenuExt pA_DrvrMultFuncMenuExt; byte[] arrayOfByte308; PATypes.PA_PassMassgRunng pA_PassMassgRunng; byte[] arrayOfByte307; PATypes.PA_DrvrMassgRunng pA_DrvrMassgRunng; byte[] arrayOfByte306; PATypes.PA_PassSeatDispMassgFct_MassgInten pA_PassSeatDispMassgFct_MassgInten; byte[] arrayOfByte305; PATypes.PA_PassSeatDispMassgFct_MassgProg pA_PassSeatDispMassgFct_MassgProg; byte[] arrayOfByte304; PATypes.PA_PassSeatDispMassgFct_OnOff pA_PassSeatDispMassgFct_OnOff; byte[] arrayOfByte303; PATypes.PA_PassSeatMassageStsAllowd pA_PassSeatMassageStsAllowd; byte[] arrayOfByte302; PATypes.PA_DrvrSeatDispMassgFct_MassgInten pA_DrvrSeatDispMassgFct_MassgInten; byte[] arrayOfByte301; PATypes.PA_DrvrSeatDispMassgFct_MassgProg pA_DrvrSeatDispMassgFct_MassgProg; byte[] arrayOfByte300; PATypes.PA_DrvrSeatDispMassgFct_OnOff pA_DrvrSeatDispMassgFct_OnOff; byte[] arrayOfByte299; PATypes.PA_DrvrSeatMassageStsAllowd pA_DrvrSeatMassageStsAllowd; byte[] arrayOfByte298; PATypes.PA_PassSeatCushExtStsAllowd pA_PassSeatCushExtStsAllowd; byte[] arrayOfByte297; PATypes.PA_DrvrSeatCushExtStsAllowd pA_DrvrSeatCushExtStsAllowd; byte[] arrayOfByte296; PATypes.PA_PassSeatSideUpDownStsAllowd pA_PassSeatSideUpDownStsAllowd; byte[] arrayOfByte295; PATypes.PA_DrvrSeatSideUpDownStsAllowd pA_DrvrSeatSideUpDownStsAllowd; byte[] arrayOfByte294; PATypes.PA_PassSeatSideFwdBackwStsAllowd pA_PassSeatSideFwdBackwStsAllowd; byte[] arrayOfByte293; PATypes.PA_DrvrSeatSideFwdBackwStsAllowd pA_DrvrSeatSideFwdBackwStsAllowd; byte[] arrayOfByte292; PATypes.PA_PassSeatLmbrUpDownStsAllowd pA_PassSeatLmbrUpDownStsAllowd; byte[] arrayOfByte291; PATypes.PA_PassSeatLmbrFwdBackwStsAllowd pA_PassSeatLmbrFwdBackwStsAllowd; byte[] arrayOfByte290; PATypes.PA_DrvrSeatLmbrUpDownStsAllowd pA_DrvrSeatLmbrUpDownStsAllowd; byte[] arrayOfByte289; PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd pA_DrvrSeatLmbrFwdBackwStsAllowd; byte[] arrayOfByte288; PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts pA_PassSeatSwtAdjmtOfSpplFctHozlSts; byte[] arrayOfByte287; PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts pA_PassSeatSwtAdjmtOfSpplFctVertSts; byte[] arrayOfByte286; PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts; byte[] arrayOfByte285; PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts pA_DrvrSeatSwtAdjmtOfSpplFctVertSts; byte[] arrayOfByte284; PATypes.PA_PassSeatActvSpplFct pA_PassSeatActvSpplFct; byte[] arrayOfByte283; PATypes.PA_DrvrSeatActvSpplFct pA_DrvrSeatActvSpplFct; byte[] arrayOfByte282; PATypes.PA_EasyInOutDrvrSeatAdjmt pA_EasyInOutDrvrSeatAdjmt; byte[] arrayOfByte281; PATypes.PA_EasyInOutDrvrSeatAllowd pA_EasyInOutDrvrSeatAllowd; byte[] arrayOfByte280; PATypes.PA_PassSeatSwtInclSts pA_PassSeatSwtInclSts; byte[] arrayOfByte279; PATypes.PA_PassSeatSwtInclStsAllowd pA_PassSeatSwtInclStsAllowd; byte[] arrayOfByte278; PATypes.PA_DrvrSeatSwtInclSts pA_DrvrSeatSwtInclSts; byte[] arrayOfByte277; PATypes.PA_DrvrSeatSwtInclStsAllowd pA_DrvrSeatSwtInclStsAllowd; byte[] arrayOfByte276; PATypes.PA_PassSeatSwtHeiFrntSts pA_PassSeatSwtHeiFrntSts; byte[] arrayOfByte275; PATypes.PA_PassSeatSwtHeiFrntStsAllowd pA_PassSeatSwtHeiFrntStsAllowd; byte[] arrayOfByte274; PATypes.PA_DrvrSeatSwtHeiFrntSts pA_DrvrSeatSwtHeiFrntSts; byte[] arrayOfByte273; PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd pA_DrvrSeatSwtHeiFrntStsAllowd; byte[] arrayOfByte272; PATypes.PA_PassSeatSwtHeiSts pA_PassSeatSwtHeiSts; byte[] arrayOfByte271; PATypes.PA_PassSeatSwtHeiStsAllowd pA_PassSeatSwtHeiStsAllowd; byte[] arrayOfByte270; PATypes.PA_DrvrSeatSwtHeiSts pA_DrvrSeatSwtHeiSts; byte[] arrayOfByte269; PATypes.PA_DrvrSeatSwtHeiStsAllowd pA_DrvrSeatSwtHeiStsAllowd; byte[] arrayOfByte268; PATypes.PA_PassSeatSwtSldSts pA_PassSeatSwtSldSts; byte[] arrayOfByte267; PATypes.PA_PassSeatExtAdjAllowd pA_PassSeatExtAdjAllowd; byte[] arrayOfByte266; PATypes.PA_DrvrSeatSwtSldSts pA_DrvrSeatSwtSldSts; byte[] arrayOfByte265; PATypes.PA_DrvrSeatExtAdjAllowd pA_DrvrSeatExtAdjAllowd; byte[] arrayOfByte264; PATypes.PA_PAS_SnsrFltStsWarn pA_PAS_SnsrFltStsWarn; byte[] arrayOfByte263; PATypes.PA_PEB_PrkgEmgyBrkSysSts pA_PEB_PrkgEmgyBrkSysSts; byte[] arrayOfByte262; PATypes.PA_PEB_PrkgEmgBrkSysSwt pA_PEB_PrkgEmgBrkSysSwt; byte[] arrayOfByte261; PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt pA_PAS_AudWarnOfSnsrParkAssiFrnt; byte[] arrayOfByte260; PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe pA_PAS_AudWarnOfSnsrParkAssiRe; byte[] arrayOfByte259; PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt pA_PAS_OutdRiOfSnsrPrkgAssiFrnt; byte[] arrayOfByte258; PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt pA_PAS_OutdLeOfSnsrPrkgAssiFrnt; byte[] arrayOfByte257; PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt pA_PAS_InsdRiOfSnsrPrkgAssiFrnt; byte[] arrayOfByte256; PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt pA_PAS_InsdLeOfSnsrPrkgAssiFrnt; byte[] arrayOfByte255; PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe pA_PAS_OutdRiOfSnsrPrkgAssiRe; byte[] arrayOfByte254; PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe pA_PAS_OutdLeOfSnsrPrkgAssiRe; byte[] arrayOfByte253; PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe pA_PAS_InsdRiOfSnsrPrkgAssiRe; byte[] arrayOfByte252; PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe pA_PAS_InsdLeOfSnsrPrkgAssiRe; byte[] arrayOfByte251; PATypes.PA_PAS_PrkgDstCtrlSts pA_PAS_PrkgDstCtrlSts; byte[] arrayOfByte250; PATypes.PA_PAS_PrkgDstCtrlSysSwt pA_PAS_PrkgDstCtrlSysSwt; byte[] arrayOfByte249; PATypes.PA_SAP_TouchUnlckTyp pA_SAP_TouchUnlckTyp; byte[] arrayOfByte248; PATypes.PA_SAP_PrkgProgsDisp pA_SAP_PrkgProgsDisp; byte[] arrayOfByte247; PATypes.PA_SAP_DrvrAsscSysDisp pA_SAP_DrvrAsscSysDisp; byte[] arrayOfByte246; PATypes.PA_SAP_DrvrAsscSysSts pA_SAP_DrvrAsscSysSts; byte[] arrayOfByte245; PATypes.PA_SAP_PrkgFctDiDisp pA_SAP_PrkgFctDiDisp; byte[] arrayOfByte244; PATypes.PA_SAP_DrvrAsscSysBtnPush pA_SAP_DrvrAsscSysBtnPush; byte[] arrayOfByte243; PATypes.PA_PAC_RctaIndcnRe pA_PAC_RctaIndcnRe; byte[] arrayOfByte242; PATypes.PA_PAC_RctaIndcnLe pA_PAC_RctaIndcnLe; byte[] arrayOfByte241; PATypes.PA_PAC_ImgSnsrClrReq pA_PAC_ImgSnsrClrReq; byte[] arrayOfByte240; PATypes.PA_PAC_PlaModStsResp pA_PAC_PlaModStsResp; byte[] arrayOfByte239; PATypes.PA_PAC_RoadCalForVisnAgWideResp pA_PAC_RoadCalForVisnAgWideResp; byte[] arrayOfByte238; PATypes.PA_PAC_VehMdlClrResp pA_PAC_VehMdlClrResp; byte[] arrayOfByte237; PATypes.PA_PAC_TurnEntryAgWideVisResp pA_PAC_TurnEntryAgWideVisResp; byte[] arrayOfByte236; PATypes.PA_PAC_ThrDTouringViewResp pA_PAC_ThrDTouringViewResp; byte[] arrayOfByte235; PATypes.PA_PAC_ThrDObjDethResp pA_PAC_ThrDObjDethResp; byte[] arrayOfByte234; PATypes.PA_PAC_PedDetnResp pA_PAC_PedDetnResp; byte[] arrayOfByte233; PATypes.PA_PAC_VisnAgExtnResp pA_PAC_VisnAgExtnResp; byte[] arrayOfByte232; PATypes.PA_PAC_PrkgIndcrLineResp pA_PAC_PrkgIndcrLineResp; byte[] arrayOfByte231; PATypes.PA_PAC_VisnImgAgWide3DInUse pA_PAC_VisnImgAgWide3DInUse; byte[] arrayOfByte230; PATypes.PA_PAC_VisnImgAgWide2DInUse pA_PAC_VisnImgAgWide2DInUse; byte[] arrayOfByte229; PATypes.PA_PAC_TxStrtVisReq pA_PAC_TxStrtVisReq; byte[] arrayOfByte228; PATypes.PA_PAC_SwtDispOnAndOffStsResp pA_PAC_SwtDispOnAndOffStsResp; PATypes.PA_DspVersion pA_DspVersion; byte[] arrayOfByte227; PATypes.PA_ErrorReport pA_ErrorReport; byte[] arrayOfByte226; PATypes.PA_AR_WarningVlo pA_AR_WarningVlo; PATypes.PA_McuLog_Panic pA_McuLog_Panic; byte[] arrayOfByte225; PATypes.PA_VFC_SetVehSceneMode pA_VFC_SetVehSceneMode; byte[] arrayOfByte224; PATypes.PA_VFC_SceneModePDC pA_VFC_SceneModePDC; byte[] arrayOfByte223; PATypes.PA_VFC_VFC_Reboot pA_VFC_VFC_Reboot; byte[] arrayOfByte222; PATypes.PA_VFC_SetVehFace pA_VFC_SetVehFace; byte[] arrayOfByte221; PATypes.PA_VFC_VFCRsrv5 pA_VFC_VFCRsrv5; byte[] arrayOfByte220; PATypes.PA_VFC_VFCRsrv4 pA_VFC_VFCRsrv4; byte[] arrayOfByte219; PATypes.PA_VFC_VFCRsrv3 pA_VFC_VFCRsrv3; byte[] arrayOfByte218; PATypes.PA_VFC_VFCRsrv2 pA_VFC_VFCRsrv2; byte[] arrayOfByte217; PATypes.PA_VFC_VFCRsrv1 pA_VFC_VFCRsrv1; byte[] arrayOfByte216; PATypes.PA_VFC_ExteriorLightShow pA_VFC_ExteriorLightShow; byte[] arrayOfByte215; PATypes.PA_VFC_ExteriorLightShowWin pA_VFC_ExteriorLightShowWin; byte[] arrayOfByte214; PATypes.PA_VFCNavigationInfoSharing pA_VFCNavigationInfoSharing; byte[] arrayOfByte213; PATypes.PA_VFCGenChaSettingsForHmiCen pA_VFCGenChaSettingsForHmiCen; byte[] arrayOfByte212; PATypes.PA_VFCSetVehCharging pA_VFCSetVehCharging; byte[] arrayOfByte211; PATypes.PA_VFC_SetVehDvr pA_VFC_SetVehDvr; byte[] arrayOfByte210; PATypes.PA_VFC_SetVehTcam pA_VFC_SetVehTcam; byte[] arrayOfByte209; PATypes.PA_VFC_SetVehAvm pA_VFC_SetVehAvm; byte[] arrayOfByte208; PATypes.PA_VFC_SetVehApa pA_VFC_SetVehApa; byte[] arrayOfByte207; PATypes.PA_VFC_SetVehPrivateLock pA_VFC_SetVehPrivateLock; byte[] arrayOfByte206; PATypes.PA_VFC_SetVehCenClkIndcnAndSetg pA_VFC_SetVehCenClkIndcnAndSetg; byte[] arrayOfByte205; PATypes.PA_VFC_TelephoneManager pA_VFC_TelephoneManager; byte[] arrayOfByte204; PATypes.PA_VFC_FaceIdnForHmiCen pA_VFC_FaceIdnForHmiCen; byte[] arrayOfByte203; PATypes.PA_VFC_ParkAssiCtrlForHmiCen pA_VFC_ParkAssiCtrlForHmiCen; byte[] arrayOfByte202; PATypes.PA_VFC_IPWakeup pA_VFC_IPWakeup; PATypes.PA_VF_HUD_ARD311Data pA_VF_HUD_ARD311Data; PATypes.PA_VF_HUD_ARD310Data pA_VF_HUD_ARD310Data; PATypes.PA_VF_HUD_ARD300Data pA_VF_HUD_ARD300Data; byte[] arrayOfByte201; PATypes.PA_VF_HUD_ARActvSts pA_VF_HUD_ARActvSts; byte[] arrayOfByte200; PATypes.PA_VF_HUD_HudSnowModeReq pA_VF_HUD_HudSnowModeReq; byte[] arrayOfByte199; PATypes.PA_VF_HUD_HudRstForSetgAndData pA_VF_HUD_HudRstForSetgAndData; byte[] arrayOfByte198; PATypes.PA_VF_HUD_ImgRotAdjmtReq pA_VF_HUD_ImgRotAdjmtReq; byte[] arrayOfByte197; PATypes.PA_VF_HUD_ErgoAdjmtReq pA_VF_HUD_ErgoAdjmtReq; byte[] arrayOfByte196; PATypes.PA_VF_HUD_IllmnReq pA_VF_HUD_IllmnReq; byte[] arrayOfByte195; PATypes.PA_VF_HUD_ActvSts pA_VF_HUD_ActvSts; PATypes.PA_Device_Supplier_Code pA_Device_Supplier_Code; PATypes.PA_Device_Project_Code pA_Device_Project_Code; PATypes.PA_Device_VPVersion_HD pA_Device_VPVersion_HD; PATypes.PA_Device_SN pA_Device_SN; PATypes.PA_Device_IHUID pA_Device_IHUID; PATypes.PA_VP_Version pA_VP_Version; PATypes.PA_VIN_VinNum pA_VIN_VinNum; PATypes.PA_SAP_PrkgUnlck pA_SAP_PrkgUnlck; byte[] arrayOfByte194; PATypes.PA_PowerSoftKeyBrightness pA_PowerSoftKeyBrightness; byte[] arrayOfByte193; PATypes.PA_PowerSoftKeySwitch pA_PowerSoftKeySwitch; byte[] arrayOfByte192; PATypes.PA_LinkSwitch pA_LinkSwitch; byte[] arrayOfByte191; PATypes.PA_LcfgPsdNightVal pA_LcfgPsdNightVal; byte[] arrayOfByte190; PATypes.PA_LcfgPsdDayVal pA_LcfgPsdDayVal; byte[] arrayOfByte189; PATypes.PA_LcfgCsdNightVal pA_LcfgCsdNightVal; byte[] arrayOfByte188; PATypes.PA_LcfgCsdDayVal pA_LcfgCsdDayVal; byte[] arrayOfByte187; PATypes.PA_LcfgDftBckVal pA_LcfgDftBckVal; byte[] arrayOfByte186; PATypes.PA_t_dim_rheo pA_t_dim_rheo; byte[] arrayOfByte185; PATypes.PA_t_dim_slow pA_t_dim_slow; byte[] arrayOfByte184; PATypes.PA_t_dim_fast pA_t_dim_fast; byte[] arrayOfByte183; PATypes.PA_PSDBrightness pA_PSDBrightness; byte[] arrayOfByte182; PATypes.PA_CSDBrightness pA_CSDBrightness; byte[] arrayOfByte181; PATypes.PA_DayNightMode pA_DayNightMode; byte[] arrayOfByte180; PATypes.PA_BackBrightness pA_BackBrightness; byte[] arrayOfByte179; PATypes.PA_SysSetPUnit pA_SysSetPUnit; byte[] arrayOfByte178; PATypes.PA_SysSetDstLong pA_SysSetDstLong; byte[] arrayOfByte177; PATypes.PA_SysSetVolUnit pA_SysSetVolUnit; byte[] arrayOfByte176; PATypes.PA_SysSetSpdUnit pA_SysSetSpdUnit; byte[] arrayOfByte175; PATypes.PA_SysSetFuCnsUnit pA_SysSetFuCnsUnit; byte[] arrayOfByte174; PATypes.PA_SysSetTempUnit pA_SysSetTempUnit; byte[] arrayOfByte173; PATypes.PA_SysSetDateFmt pA_SysSetDateFmt; byte[] arrayOfByte172; PATypes.PA_SysSetClkFmt pA_SysSetClkFmt; byte[] arrayOfByte171; PATypes.PA_SysSetOfLang pA_SysSetOfLang; PATypes.PA_Power_Res pA_Power_Res; byte[] arrayOfByte170; PATypes.PA_DriveMode_Adaptive pA_DriveMode_Adaptive; byte[] arrayOfByte169; PATypes.PA_DriveMode_Animation pA_DriveMode_Animation; byte[] arrayOfByte168; PATypes.PA_DriveMode_Value pA_DriveMode_Value; byte[] arrayOfByte167; PATypes.PA_DriveMode_Suspension_Settings pA_DriveMode_Suspension_Settings; byte[] arrayOfByte166; PATypes.PA_DriveMode_Engine_StartStop pA_DriveMode_Engine_StartStop; byte[] arrayOfByte165; PATypes.PA_DriveMode_DIMTheme_Settings pA_DriveMode_DIMTheme_Settings; byte[] arrayOfByte164; PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings pA_DriveMode_SteeringWheelAssistLevel_Settings; byte[] arrayOfByte163; PATypes.PA_DriveMode_AirConditioner_Settings pA_DriveMode_AirConditioner_Settings; byte[] arrayOfByte162; PATypes.PA_DriveMode_Powertrain_Settings pA_DriveMode_Powertrain_Settings; byte[] arrayOfByte161; PATypes.PA_DriveMode_Brake_Settings pA_DriveMode_Brake_Settings; byte[] arrayOfByte160; PATypes.PA_DriveMode_Individual_Settings pA_DriveMode_Individual_Settings; byte[] arrayOfByte159; PATypes.PA_DriveMode_active_time pA_DriveMode_active_time; byte[] arrayOfByte158; PATypes.PA_DriveMode_confirmation_timeout pA_DriveMode_confirmation_timeout; byte[] arrayOfByte157; PATypes.PA_DriveMode_Rock pA_DriveMode_Rock; byte[] arrayOfByte156; PATypes.PA_DriveMode_Mud pA_DriveMode_Mud; byte[] arrayOfByte155; PATypes.PA_DriveMode_Sand pA_DriveMode_Sand; byte[] arrayOfByte154; PATypes.PA_DriveMode_Snow pA_DriveMode_Snow; byte[] arrayOfByte153; PATypes.PA_DriveMode_Power pA_DriveMode_Power; byte[] arrayOfByte152; PATypes.PA_DriveMode_Hybrid pA_DriveMode_Hybrid; byte[] arrayOfByte151; PATypes.PA_DriveMode_Pure pA_DriveMode_Pure; byte[] arrayOfByte150; PATypes.PA_DriveMode_Save pA_DriveMode_Save; byte[] arrayOfByte149; PATypes.PA_DriveMode_AWD pA_DriveMode_AWD; byte[] arrayOfByte148; PATypes.PA_DriveMode_XC pA_DriveMode_XC; byte[] arrayOfByte147; PATypes.PA_DriveMode_Individual pA_DriveMode_Individual; byte[] arrayOfByte146; PATypes.PA_DriveMode_Dynamic pA_DriveMode_Dynamic; byte[] arrayOfByte145; PATypes.PA_DriveMode_Comfort pA_DriveMode_Comfort; byte[] arrayOfByte144; PATypes.PA_DriveMode_Eco pA_DriveMode_Eco; byte[] arrayOfByte143; PATypes.PA_TCH_CupHoldrOcpyFbSts pA_TCH_CupHoldrOcpyFbSts; byte[] arrayOfByte142; PATypes.PA_TCH_CupHoldrAvlSts pA_TCH_CupHoldrAvlSts; byte[] arrayOfByte141; PATypes.PA_TCH_CupHoldrVoltgErr pA_TCH_CupHoldrVoltgErr; byte[] arrayOfByte140; PATypes.PA_TCH_CupHoldrActvAllwd pA_TCH_CupHoldrActvAllwd; byte[] arrayOfByte139; PATypes.PA_TCH_CupHoldrStsFd pA_TCH_CupHoldrStsFd; byte[] arrayOfByte138; PATypes.PA_Fragra_FragRefrshAutSetg pA_Fragra_FragRefrshAutSetg; byte[] arrayOfByte137; PATypes.PA_Fragra_AirFragCh5RunngSts pA_Fragra_AirFragCh5RunngSts; byte[] arrayOfByte136; PATypes.PA_Fragra_AirFragCh4RunngSts pA_Fragra_AirFragCh4RunngSts; byte[] arrayOfByte135; PATypes.PA_Fragra_AirFragCh3RunngSts pA_Fragra_AirFragCh3RunngSts; byte[] arrayOfByte134; PATypes.PA_Fragra_AirFragCh2RunngSts pA_Fragra_AirFragCh2RunngSts; byte[] arrayOfByte133; PATypes.PA_Fragra_AirFragCh1RunngSts pA_Fragra_AirFragCh1RunngSts; byte[] arrayOfByte132; PATypes.PA_Fragra_Tast5UseUpRmd pA_Fragra_Tast5UseUpRmd; byte[] arrayOfByte131; PATypes.PA_Fragra_Tast4UseUpRmd pA_Fragra_Tast4UseUpRmd; byte[] arrayOfByte130; PATypes.PA_Fragra_Tast3UseUpRmd pA_Fragra_Tast3UseUpRmd; byte[] arrayOfByte129; PATypes.PA_Fragra_Tast2UseUpRmd pA_Fragra_Tast2UseUpRmd; byte[] arrayOfByte128; PATypes.PA_Fragra_Tast1UseUpRmd pA_Fragra_Tast1UseUpRmd; byte[] arrayOfByte127; PATypes.PA_Fragra_Taste5ID pA_Fragra_Taste5ID; byte[] arrayOfByte126; PATypes.PA_Fragra_Taste4ID pA_Fragra_Taste4ID; byte[] arrayOfByte125; PATypes.PA_Fragra_Taste3ID pA_Fragra_Taste3ID; byte[] arrayOfByte124; PATypes.PA_Fragra_Taste2ID pA_Fragra_Taste2ID; byte[] arrayOfByte123; PATypes.PA_Fragra_Taste1ID pA_Fragra_Taste1ID; byte[] arrayOfByte122; PATypes.PA_Fragra_RefrshReq pA_Fragra_RefrshReq; byte[] arrayOfByte121; PATypes.PA_Fragra_Sts pA_Fragra_Sts; byte[] arrayOfByte120; PATypes.PA_Fragra_SceneSetSts pA_Fragra_SceneSetSts; byte[] arrayOfByte119; PATypes.PA_Fragra_ModReqSts pA_Fragra_ModReqSts; byte[] arrayOfByte118; PATypes.PA_Fragra_LvlReqSts pA_Fragra_LvlReqSts; byte[] arrayOfByte117; PATypes.PA_Fragra_TypRatReqFSts pA_Fragra_TypRatReqFSts; byte[] arrayOfByte116; PATypes.PA_Fragra_TypRatReqESts pA_Fragra_TypRatReqESts; byte[] arrayOfByte115; PATypes.PA_Fragra_TypRatReqDSts pA_Fragra_TypRatReqDSts; byte[] arrayOfByte114; PATypes.PA_Fragra_TypRatReqCSts pA_Fragra_TypRatReqCSts; byte[] arrayOfByte113; PATypes.PA_Fragra_TypRatReqBSts pA_Fragra_TypRatReqBSts; byte[] arrayOfByte112; PATypes.PA_Fragra_TypRatReqASts pA_Fragra_TypRatReqASts; byte[] arrayOfByte111; PATypes.PA_Fragra_Actn pA_Fragra_Actn; byte[] arrayOfByte110; PATypes.PA_PM25_IncomingAirQlyPopUpReq pA_PM25_IncomingAirQlyPopUpReq; byte[] arrayOfByte109; PATypes.PA_PM25_OutdPm25Sts pA_PM25_OutdPm25Sts; byte[] arrayOfByte108; PATypes.PA_PM25_IntPm25Sts pA_PM25_IntPm25Sts; byte[] arrayOfByte107; PATypes.PA_PM25_IntrPm25HiWarn pA_PM25_IntrPm25HiWarn; byte[] arrayOfByte106; PATypes.PA_PM25_OutdPm25Lvl pA_PM25_OutdPm25Lvl; byte[] arrayOfByte105; PATypes.PA_PM25_IntPm25Lvl pA_PM25_IntPm25Lvl; byte[] arrayOfByte104; PATypes.PA_PM25_OutdPm25Vlu pA_PM25_OutdPm25Vlu; byte[] arrayOfByte103; PATypes.PA_PM25_IntPm25Vlu pA_PM25_IntPm25Vlu; byte[] arrayOfByte102; PATypes.PA_PM25_Actvn pA_PM25_Actvn; byte[] arrayOfByte101; PATypes.PA_IAQC_ActnSts pA_IAQC_ActnSts; byte[] arrayOfByte100; PATypes.PA_SWH_AvlSts pA_SWH_AvlSts; byte[] arrayOfByte99; PATypes.PA_SWH_ManualLvlSts pA_SWH_ManualLvlSts; byte[] arrayOfByte98; PATypes.PA_SWH_AutoReqSts pA_SWH_AutoReqSts; byte[] arrayOfByte97; PATypes.PA_SWH_Actvn pA_SWH_Actvn; byte[] arrayOfByte96; PATypes.PA_SCV_FirstRiAvlSts pA_SCV_FirstRiAvlSts; byte[] arrayOfByte95; PATypes.PA_SCV_FirstLeAvlSts pA_SCV_FirstLeAvlSts; byte[] arrayOfByte94; PATypes.PA_SCV_FirstRiTmrSts pA_SCV_FirstRiTmrSts; byte[] arrayOfByte93; PATypes.PA_SCV_FirstLeTmrSts pA_SCV_FirstLeTmrSts; byte[] arrayOfByte92; PATypes.PA_SCV_FirstRiLvlSts pA_SCV_FirstRiLvlSts; byte[] arrayOfByte91; PATypes.PA_SCV_FirstLeLvlSts pA_SCV_FirstLeLvlSts; byte[] arrayOfByte90; PATypes.PA_SCV_FirstActvn pA_SCV_FirstActvn; byte[] arrayOfByte89; PATypes.PA_SCH_SecRiAvlSts pA_SCH_SecRiAvlSts; byte[] arrayOfByte88; PATypes.PA_SCH_SecLeAvlSts pA_SCH_SecLeAvlSts; byte[] arrayOfByte87; PATypes.PA_SCH_FirstRiAvlSts pA_SCH_FirstRiAvlSts; byte[] arrayOfByte86; PATypes.PA_SCH_FirstLeAvlSts pA_SCH_FirstLeAvlSts; byte[] arrayOfByte85; PATypes.PA_SCH_SecRiTmrSts pA_SCH_SecRiTmrSts; byte[] arrayOfByte84; PATypes.PA_SCH_SecLeTmrSts pA_SCH_SecLeTmrSts; byte[] arrayOfByte83; PATypes.PA_SCH_FirstRiTmrSts pA_SCH_FirstRiTmrSts; byte[] arrayOfByte82; PATypes.PA_SCH_FirstLeTmrSts pA_SCH_FirstLeTmrSts; byte[] arrayOfByte81; PATypes.PA_SCH_SecRiLvlSts pA_SCH_SecRiLvlSts; byte[] arrayOfByte80; PATypes.PA_SCH_SecLeLvlSts pA_SCH_SecLeLvlSts; byte[] arrayOfByte79; PATypes.PA_SCH_FirstRiLvlSts pA_SCH_FirstRiLvlSts; byte[] arrayOfByte78; PATypes.PA_SCH_FirstLeLvlSts pA_SCH_FirstLeLvlSts; byte[] arrayOfByte77; PATypes.PA_SCH_SecActvn pA_SCH_SecActvn; byte[] arrayOfByte76; PATypes.PA_SCH_FirstActvn pA_SCH_FirstActvn; byte[] arrayOfByte75; PATypes.PA_CL_ModeFrstLeft_ByHardKey pA_CL_ModeFrstLeft_ByHardKey; byte[] arrayOfByte74; PATypes.PA_CL_LeftTemp_ByHardKey pA_CL_LeftTemp_ByHardKey; byte[] arrayOfByte73; PATypes.PA_CL_FanLevel_ByHardKey pA_CL_FanLevel_ByHardKey; byte[] arrayOfByte72; PATypes.PA_CL_InteCleanUnpleSmell pA_CL_InteCleanUnpleSmell; byte[] arrayOfByte71; PATypes.PA_CL_ElecDefRunErr pA_CL_ElecDefRunErr; byte[] arrayOfByte70; PATypes.PA_CL_CCSMPopUp pA_CL_CCSMPopUp; PATypes.PA_CL_PassElecAir pA_CL_PassElecAir; PATypes.PA_CL_DrvElecAir pA_CL_DrvElecAir; byte[] arrayOfByte69; PATypes.PA_CL_GClean pA_CL_GClean; byte[] arrayOfByte68; PATypes.PA_CL_SecAutoSw pA_CL_SecAutoSw; byte[] arrayOfByte67; PATypes.PA_CL_SecLockClimaSw pA_CL_SecLockClimaSw; byte[] arrayOfByte66; PATypes.PA_CL_TWinRfClsdPopSw pA_CL_TWinRfClsdPopSw; byte[] arrayOfByte65; PATypes.PA_CL_ElecAirAvlStsPop pA_CL_ElecAirAvlStsPop; byte[] arrayOfByte64; PATypes.PA_CL_PassSwt pA_CL_PassSwt; byte[] arrayOfByte63; PATypes.PA_CL_DrvSwt pA_CL_DrvSwt; byte[] arrayOfByte62; PATypes.PA_CL_ClmCloseWinPop pA_CL_ClmCloseWinPop; byte[] arrayOfByte61; PATypes.PA_CL_WipReSrvMod pA_CL_WipReSrvMod; byte[] arrayOfByte60; PATypes.PA_CL_WipFrntSrvMod pA_CL_WipFrntSrvMod; byte[] arrayOfByte59; PATypes.PA_CL_WipReAutReq pA_CL_WipReAutReq; byte[] arrayOfByte58; PATypes.PA_CL_IntelliClimaPop pA_CL_IntelliClimaPop; byte[] arrayOfByte57; PATypes.PA_CL_HumPop pA_CL_HumPop; byte[] arrayOfByte56; PATypes.PA_CL_HumCtrl pA_CL_HumCtrl; byte[] arrayOfByte55; PATypes.PA_CL_PostClimaWarn pA_CL_PostClimaWarn; byte[] arrayOfByte54; PATypes.PA_CL_SecRowOnOffSwith pA_CL_SecRowOnOffSwith; byte[] arrayOfByte53; PATypes.PA_CL_RearDefrostPopup pA_CL_RearDefrostPopup; byte[] arrayOfByte52; PATypes.PA_CL_FrntDefrostPopup pA_CL_FrntDefrostPopup; byte[] arrayOfByte51; PATypes.PA_CL_AutoDefrostPopup pA_CL_AutoDefrostPopup; byte[] arrayOfByte50; PATypes.PA_CL_AutoDefrostSetting pA_CL_AutoDefrostSetting; byte[] arrayOfByte49; PATypes.PA_CL_SecFanLevel pA_CL_SecFanLevel; byte[] arrayOfByte48; PATypes.PA_CL_SecRightTemp pA_CL_SecRightTemp; byte[] arrayOfByte47; PATypes.PA_CL_SecLeftTemp pA_CL_SecLeftTemp; byte[] arrayOfByte46; PATypes.PA_CL_HvacReCtr pA_CL_HvacReCtr; byte[] arrayOfByte45; PATypes.PA_CL_AirCtrlOff pA_CL_AirCtrlOff; byte[] arrayOfByte44; PATypes.PA_CL_Post pA_CL_Post; byte[] arrayOfByte43; PATypes.PA_CL_Pre pA_CL_Pre; byte[] arrayOfByte42; PATypes.PA_CL_ECOClimate pA_CL_ECOClimate; byte[] arrayOfByte41; PATypes.PA_CL_Sync pA_CL_Sync; byte[] arrayOfByte40; PATypes.PA_CL_RearDefrost pA_CL_RearDefrost; byte[] arrayOfByte39; PATypes.PA_CL_FrontDefrost pA_CL_FrontDefrost; byte[] arrayOfByte38; PATypes.PA_WDC_AutoRearDefrost pA_WDC_AutoRearDefrost; byte[] arrayOfByte37; PATypes.PA_WDC_AutoFrontDefrost pA_WDC_AutoFrontDefrost; byte[] arrayOfByte36; PATypes.PA_CL_MaxDefrost pA_CL_MaxDefrost; byte[] arrayOfByte35; PATypes.PA_CL_AutoSetting pA_CL_AutoSetting; byte[] arrayOfByte34; PATypes.PA_CL_RecircSetting pA_CL_RecircSetting; byte[] arrayOfByte33; PATypes.PA_CL_RightTemp pA_CL_RightTemp; byte[] arrayOfByte32; PATypes.PA_CL_LeftTemp pA_CL_LeftTemp; byte[] arrayOfByte31; PATypes.PA_CL_FanLevel pA_CL_FanLevel; byte[] arrayOfByte30; PATypes.PA_CL_MaxAC pA_CL_MaxAC; byte[] arrayOfByte29; PATypes.PA_CL_ModeSec pA_CL_ModeSec; byte[] arrayOfByte28; PATypes.PA_CL_ModeFrstRight pA_CL_ModeFrstRight; byte[] arrayOfByte27; PATypes.PA_CL_ModeFrstLeft pA_CL_ModeFrstLeft; byte[] arrayOfByte26; PATypes.PA_CL_Recirc pA_CL_Recirc; byte[] arrayOfByte25; PATypes.PA_CL_Auto pA_CL_Auto; byte[] arrayOfByte24; PATypes.PA_CL_AC pA_CL_AC; byte[] arrayOfByte23; PATypes.PA_Asy_EMA pA_Asy_EMA; byte[] arrayOfByte22; PATypes.PA_Asy_ELKA pA_Asy_ELKA; byte[] arrayOfByte21; PATypes.PA_Asy_LKA_Warning_Mode pA_Asy_LKA_Warning_Mode; byte[] arrayOfByte20; PATypes.PA_Asy_LKA_Mode pA_Asy_LKA_Mode; byte[] arrayOfByte19; PATypes.PA_Asy_LKA pA_Asy_LKA; byte[] arrayOfByte18; PATypes.PA_Asy_DOW pA_Asy_DOW; byte[] arrayOfByte17; PATypes.PA_Asy_RCTA pA_Asy_RCTA; byte[] arrayOfByte16; PATypes.PA_Asy_RCW pA_Asy_RCW; byte[] arrayOfByte15; PATypes.PA_Asy_LCA_Warning pA_Asy_LCA_Warning; byte[] arrayOfByte14; PATypes.PA_Asy_LCA pA_Asy_LCA; byte[] arrayOfByte13; PATypes.PA_Asy_CMS_Warning pA_Asy_CMS_Warning; byte[] arrayOfByte12; PATypes.PA_Asy_CMS pA_Asy_CMS; byte[] arrayOfByte11; PATypes.PA_Asy_DPS_Reminder pA_Asy_DPS_Reminder; byte[] arrayOfByte10; PATypes.PA_Asy_DPS pA_Asy_DPS; byte[] arrayOfByte9; PATypes.PA_Asy_ELOW pA_Asy_ELOW; byte[] arrayOfByte8; PATypes.PA_Asy_TLA_Sound_Warning pA_Asy_TLA_Sound_Warning; byte[] arrayOfByte7; PATypes.PA_Asy_TLA pA_Asy_TLA; byte[] arrayOfByte6; PATypes.PA_Asy_SpeedCompensation pA_Asy_SpeedCompensation; byte[] arrayOfByte5; PATypes.PA_Asy_TSR_Warning pA_Asy_TSR_Warning; byte[] arrayOfByte4; PATypes.PA_Asy_OtherTSR pA_Asy_OtherTSR;
/*      */       byte[] arrayOfByte3;
/*      */       PATypes.PA_Asy_TSR pA_Asy_TSR;
/*      */       byte[] arrayOfByte2;
/*      */       PATypes.PA_Asy_HWA pA_Asy_HWA;
/* 4074 */       switch (paramECarXCarPropertyValue.getPropertyId()) {
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
/*      */         default:
/* 7427 */           return null;
/*      */         case 33973:
/*      */           this.data = (byte[])paramECarXCarPropertyValue.getValue();
/*      */           arrayOfByte628 = this.data;
/*      */           pA_VehMdlClrReq = new PATypes.PA_VehMdlClrReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte628));
/*      */           return pA_VehMdlClrReq;
/*      */         case 33972:
/*      */           this.data = (byte[])pA_VehMdlClrReq.getValue();
/*      */           arrayOfByte627 = this.data;
/*      */           pA_TurnEntryAgWideVisReq = new PATypes.PA_TurnEntryAgWideVisReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte627));
/*      */           return pA_TurnEntryAgWideVisReq;
/*      */         case 33971:
/*      */           this.data = (byte[])pA_TurnEntryAgWideVisReq.getValue();
/*      */           arrayOfByte626 = this.data;
/*      */           pA_TopVisnDispExtnReq = new PATypes.PA_TopVisnDispExtnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte626));
/*      */           return pA_TopVisnDispExtnReq;
/*      */         case 33970:
/*      */           this.data = (byte[])pA_TopVisnDispExtnReq.getValue();
/*      */           arrayOfByte625 = this.data;
/*      */           pA_ThrDTouringViewReq = new PATypes.PA_ThrDTouringViewReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte625));
/*      */           return pA_ThrDTouringViewReq;
/*      */         case 33969:
/*      */           this.data = (byte[])pA_ThrDTouringViewReq.getValue();
/*      */           arrayOfByte624 = this.data;
/*      */           pA_SurrndgsObjDetnReq = new PATypes.PA_SurrndgsObjDetnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte624));
/*      */           return pA_SurrndgsObjDetnReq;
/*      */         case 33968:
/*      */           this.data = (byte[])pA_SurrndgsObjDetnReq.getValue();
/*      */           arrayOfByte623 = this.data;
/*      */           pA_PrkgIndcrLineReq = new PATypes.PA_PrkgIndcrLineReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte623));
/*      */           return pA_PrkgIndcrLineReq;
/*      */         case 33967:
/*      */           this.data = (byte[])pA_PrkgIndcrLineReq.getValue();
/*      */           arrayOfByte622 = this.data;
/*      */           pA_HudDispModSetgReq = new PATypes.PA_HudDispModSetgReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte622));
/*      */           return pA_HudDispModSetgReq;
/*      */         case 33966:
/*      */           this.data = (byte[])pA_HudDispModSetgReq.getValue();
/*      */           arrayOfByte621 = this.data;
/*      */           pA_FaceSgnInForProf = new PATypes.PA_FaceSgnInForProf(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte621));
/*      */           return pA_FaceSgnInForProf;
/*      */         case 33965:
/*      */           this.data = (byte[])pA_FaceSgnInForProf.getValue();
/*      */           arrayOfByte620 = this.data;
/*      */           pA_FaceIdnReq = new PATypes.PA_FaceIdnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte620));
/*      */           return pA_FaceIdnReq;
/*      */         case 33964:
/*      */           this.data = (byte[])pA_FaceIdnReq.getValue();
/*      */           arrayOfByte619 = this.data;
/*      */           pA_CnclFaceReqForProf = new PATypes.PA_CnclFaceReqForProf(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte619));
/*      */           return pA_CnclFaceReqForProf;
/*      */         case 33963:
/*      */           this.data = (byte[])pA_CnclFaceReqForProf.getValue();
/*      */           arrayOfByte618 = this.data;
/*      */           pA_VehCharg_ChargingColumn = new PATypes.PA_VehCharg_ChargingColumn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte618));
/*      */           return pA_VehCharg_ChargingColumn;
/*      */         case 33962:
/*      */           this.data = (byte[])pA_VehCharg_ChargingColumn.getValue();
/*      */           arrayOfByte617 = this.data;
/*      */           pA_SCEMOD_SceneModSeldCustomization = new PATypes.PA_SCEMOD_SceneModSeldCustomization(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte617));
/*      */           return pA_SCEMOD_SceneModSeldCustomization;
/*      */         case 33961:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldCustomization.getValue();
/*      */           arrayOfByte616 = this.data;
/*      */           pA_SCEMOD_SceneModSeldQuitStranger = new PATypes.PA_SCEMOD_SceneModSeldQuitStranger(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte616));
/*      */           return pA_SCEMOD_SceneModSeldQuitStranger;
/*      */         case 33960:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldQuitStranger.getValue();
/*      */           arrayOfByte615 = this.data;
/*      */           pA_SENSOR_JoyForbidState = new PATypes.PA_SENSOR_JoyForbidState(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte615));
/*      */           return pA_SENSOR_JoyForbidState;
/*      */         case 33959:
/*      */           this.data = (byte[])pA_SENSOR_JoyForbidState.getValue();
/*      */           arrayOfByte614 = this.data;
/*      */           pA_SENSOR_JoyLimitState = new PATypes.PA_SENSOR_JoyLimitState(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte614));
/*      */           return pA_SENSOR_JoyLimitState;
/*      */         case 33958:
/*      */           this.data = (byte[])pA_SENSOR_JoyLimitState.getValue();
/*      */           arrayOfByte613 = this.data;
/*      */           pA_SENSOR_EngHrToSrvValue = new PATypes.PA_SENSOR_EngHrToSrvValue(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte613));
/*      */           return pA_SENSOR_EngHrToSrvValue;
/*      */         case 33957:
/*      */           this.data = (byte[])pA_SENSOR_EngHrToSrvValue.getValue();
/*      */           arrayOfByte612 = this.data;
/*      */           pA_SENSOR_DayToSrvValue = new PATypes.PA_SENSOR_DayToSrvValue(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte612));
/*      */           return pA_SENSOR_DayToSrvValue;
/*      */         case 33956:
/*      */           this.data = (byte[])pA_SENSOR_DayToSrvValue.getValue();
/*      */           arrayOfByte611 = this.data;
/*      */           pA_SENSOR_DstToSrvValue = new PATypes.PA_SENSOR_DstToSrvValue(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte611));
/*      */           return pA_SENSOR_DstToSrvValue;
/*      */         case 33955:
/*      */           this.data = (byte[])pA_SENSOR_DstToSrvValue.getValue();
/*      */           arrayOfByte610 = this.data;
/*      */           pA_FD_FaceIdnReq = new PATypes.PA_FD_FaceIdnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte610));
/*      */           return pA_FD_FaceIdnReq;
/*      */         case 33954:
/*      */           this.data = (byte[])pA_FD_FaceIdnReq.getValue();
/*      */           arrayOfByte609 = this.data;
/*      */           pA_SCEMOD_SceneModSeldPassengerRepose = new PATypes.PA_SCEMOD_SceneModSeldPassengerRepose(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte609));
/*      */           return pA_SCEMOD_SceneModSeldPassengerRepose;
/*      */         case 33953:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldPassengerRepose.getValue();
/*      */           arrayOfByte608 = this.data;
/*      */           pA_SCEMOD_PassSceneModSeldValue = new PATypes.PA_SCEMOD_PassSceneModSeldValue(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte608));
/*      */           return pA_SCEMOD_PassSceneModSeldValue;
/*      */         case 33952:
/*      */           this.data = (byte[])pA_SCEMOD_PassSceneModSeldValue.getValue();
/*      */           arrayOfByte607 = this.data;
/*      */           pA_SCEMOD_SceneModSeldGoddess = new PATypes.PA_SCEMOD_SceneModSeldGoddess(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte607));
/*      */           return pA_SCEMOD_SceneModSeldGoddess;
/*      */         case 33951:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldGoddess.getValue();
/*      */           arrayOfByte606 = this.data;
/*      */           pA_SCEMOD_SceneModSeldValue = new PATypes.PA_SCEMOD_SceneModSeldValue(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte606));
/*      */           return pA_SCEMOD_SceneModSeldValue;
/*      */         case 33950:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldValue.getValue();
/*      */           arrayOfByte605 = this.data;
/*      */           pA_SCEMOD_SceneModSeldKing = new PATypes.PA_SCEMOD_SceneModSeldKing(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte605));
/*      */           return pA_SCEMOD_SceneModSeldKing;
/*      */         case 33949:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldKing.getValue();
/*      */           arrayOfByte604 = this.data;
/*      */           pA_SCEMOD_SceneModSeldEco = new PATypes.PA_SCEMOD_SceneModSeldEco(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte604));
/*      */           return pA_SCEMOD_SceneModSeldEco;
/*      */         case 33948:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldEco.getValue();
/*      */           arrayOfByte603 = this.data;
/*      */           pA_SCEMOD_SceneModSeldRearRowTheater = new PATypes.PA_SCEMOD_SceneModSeldRearRowTheater(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte603));
/*      */           return pA_SCEMOD_SceneModSeldRearRowTheater;
/*      */         case 33947:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldRearRowTheater.getValue();
/*      */           arrayOfByte602 = this.data;
/*      */           pA_SCEMOD_SceneModSeldFrontRowTheater = new PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte602));
/*      */           return pA_SCEMOD_SceneModSeldFrontRowTheater;
/*      */         case 33946:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldFrontRowTheater.getValue();
/*      */           arrayOfByte601 = this.data;
/*      */           pA_SCEMOD_SceneModSeldSecondRightRest = new PATypes.PA_SCEMOD_SceneModSeldSecondRightRest(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte601));
/*      */           return pA_SCEMOD_SceneModSeldSecondRightRest;
/*      */         case 33945:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldSecondRightRest.getValue();
/*      */           arrayOfByte600 = this.data;
/*      */           pA_SCEMOD_SceneModSeldSecondLeftRest = new PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte600));
/*      */           return pA_SCEMOD_SceneModSeldSecondLeftRest;
/*      */         case 33944:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldSecondLeftRest.getValue();
/*      */           arrayOfByte599 = this.data;
/*      */           pA_SCEMOD_SceneModSeldPassengerRest = new PATypes.PA_SCEMOD_SceneModSeldPassengerRest(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte599));
/*      */           return pA_SCEMOD_SceneModSeldPassengerRest;
/*      */         case 33943:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldPassengerRest.getValue();
/*      */           arrayOfByte598 = this.data;
/*      */           pA_SCEMOD_SceneModSeldDriverRest = new PATypes.PA_SCEMOD_SceneModSeldDriverRest(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte598));
/*      */           return pA_SCEMOD_SceneModSeldDriverRest;
/*      */         case 33942:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldDriverRest.getValue();
/*      */           arrayOfByte597 = this.data;
/*      */           pA_SCEMOD_SceneModSeldChild = new PATypes.PA_SCEMOD_SceneModSeldChild(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte597));
/*      */           return pA_SCEMOD_SceneModSeldChild;
/*      */         case 33941:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldChild.getValue();
/*      */           arrayOfByte596 = this.data;
/*      */           pA_SCEMOD_SceneModSeldBiochal = new PATypes.PA_SCEMOD_SceneModSeldBiochal(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte596));
/*      */           return pA_SCEMOD_SceneModSeldBiochal;
/*      */         case 33940:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldBiochal.getValue();
/*      */           arrayOfByte595 = this.data;
/*      */           pA_SCEMOD_SceneModSeldStranger = new PATypes.PA_SCEMOD_SceneModSeldStranger(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte595));
/*      */           return pA_SCEMOD_SceneModSeldStranger;
/*      */         case 33939:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldStranger.getValue();
/*      */           arrayOfByte594 = this.data;
/*      */           pA_SCEMOD_SceneModSeldCarWash = new PATypes.PA_SCEMOD_SceneModSeldCarWash(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte594));
/*      */           return pA_SCEMOD_SceneModSeldCarWash;
/*      */         case 33938:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldCarWash.getValue();
/*      */           arrayOfByte593 = this.data;
/*      */           pA_SCEMOD_SceneModSeldPet = new PATypes.PA_SCEMOD_SceneModSeldPet(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte593));
/*      */           return pA_SCEMOD_SceneModSeldPet;
/*      */         case 33937:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldPet.getValue();
/*      */           arrayOfByte592 = this.data;
/*      */           pA_SCEMOD_SceneModSeldRomantic = new PATypes.PA_SCEMOD_SceneModSeldRomantic(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte592));
/*      */           return pA_SCEMOD_SceneModSeldRomantic;
/*      */         case 33936:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldRomantic.getValue();
/*      */           arrayOfByte591 = this.data;
/*      */           pA_SCEMOD_SceneModSeldWakeUp = new PATypes.PA_SCEMOD_SceneModSeldWakeUp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte591));
/*      */           return pA_SCEMOD_SceneModSeldWakeUp;
/*      */         case 33935:
/*      */           this.data = (byte[])pA_SCEMOD_SceneModSeldWakeUp.getValue();
/*      */           arrayOfByte590 = this.data;
/*      */           pA_TS_CurTripTime = new PATypes.PA_TS_CurTripTime(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte590));
/*      */           return pA_TS_CurTripTime;
/*      */         case 33934:
/*      */           this.data = (byte[])pA_TS_CurTripTime.getValue();
/*      */           arrayOfByte589 = this.data;
/*      */           pA_TS_CurTripDis = new PATypes.PA_TS_CurTripDis(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte589));
/*      */           return pA_TS_CurTripDis;
/*      */         case 33933:
/*      */           this.data = (byte[])pA_TS_CurTripDis.getValue();
/*      */           arrayOfByte588 = this.data;
/*      */           pA_NAVI_VehEgyCoornFctStChg = new PATypes.PA_NAVI_VehEgyCoornFctStChg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte588));
/*      */           return pA_NAVI_VehEgyCoornFctStChg;
/*      */         case 33932:
/*      */           this.data = (byte[])pA_NAVI_VehEgyCoornFctStChg.getValue();
/*      */           arrayOfByte587 = this.data;
/*      */           pA_NAVI_VehEgyCoornOpenAndCls = new PATypes.PA_NAVI_VehEgyCoornOpenAndCls(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte587));
/*      */           return pA_NAVI_VehEgyCoornOpenAndCls;
/*      */         case 33931:
/*      */           this.data = (byte[])pA_NAVI_VehEgyCoornOpenAndCls.getValue();
/*      */           arrayOfByte586 = this.data;
/*      */           pA_HUD_DispModSet = new PATypes.PA_HUD_DispModSet(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte586));
/*      */           return pA_HUD_DispModSet;
/*      */         case 33930:
/*      */           this.data = (byte[])pA_HUD_DispModSet.getValue();
/*      */           pA_PSET_NameP5 = new PATypes.PA_PSET_NameP5(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_PSET_NameP5;
/*      */         case 33929:
/*      */           this.data = (byte[])pA_PSET_NameP5.getValue();
/*      */           pA_PSET_NameP4 = new PATypes.PA_PSET_NameP4(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_PSET_NameP4;
/*      */         case 33928:
/*      */           this.data = (byte[])pA_PSET_NameP4.getValue();
/*      */           pA_PSET_NameP3 = new PATypes.PA_PSET_NameP3(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_PSET_NameP3;
/*      */         case 33927:
/*      */           this.data = (byte[])pA_PSET_NameP3.getValue();
/*      */           pA_PSET_NameP2 = new PATypes.PA_PSET_NameP2(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_PSET_NameP2;
/*      */         case 33926:
/*      */           this.data = (byte[])pA_PSET_NameP2.getValue();
/*      */           pA_PSET_NameP1 = new PATypes.PA_PSET_NameP1(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_PSET_NameP1;
/*      */         case 33925:
/*      */           this.data = (byte[])pA_PSET_NameP1.getValue();
/*      */           arrayOfByte585 = this.data;
/*      */           pA_AmbLi_MsgEnd = new PATypes.PA_AmbLi_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte585));
/*      */           return pA_AmbLi_MsgEnd;
/*      */         case 33924:
/*      */           this.data = (byte[])pA_AmbLi_MsgEnd.getValue();
/*      */           arrayOfByte584 = this.data;
/*      */           pA_VM2_MsgEnd = new PATypes.PA_VM2_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte584));
/*      */           return pA_VM2_MsgEnd;
/*      */         case 33923:
/*      */           this.data = (byte[])pA_VM2_MsgEnd.getValue();
/*      */           arrayOfByte583 = this.data;
/*      */           pA_VM_MsgEnd = new PATypes.PA_VM_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte583));
/*      */           return pA_VM_MsgEnd;
/*      */         case 33922:
/*      */           this.data = (byte[])pA_VM_MsgEnd.getValue();
/*      */           arrayOfByte582 = this.data;
/*      */           pA_WPC_MsgEnd = new PATypes.PA_WPC_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte582));
/*      */           return pA_WPC_MsgEnd;
/*      */         case 33921:
/*      */           this.data = (byte[])pA_WPC_MsgEnd.getValue();
/*      */           arrayOfByte581 = this.data;
/*      */           pA_VehCharg_MsgEnd = new PATypes.PA_VehCharg_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte581));
/*      */           return pA_VehCharg_MsgEnd;
/*      */         case 33920:
/*      */           this.data = (byte[])pA_VehCharg_MsgEnd.getValue();
/*      */           arrayOfByte580 = this.data;
/*      */           pA_SC_MsgEnd = new PATypes.PA_SC_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte580));
/*      */           return pA_SC_MsgEnd;
/*      */         case 33919:
/*      */           this.data = (byte[])pA_SC_MsgEnd.getValue();
/*      */           arrayOfByte579 = this.data;
/*      */           pA_PAS_MsgEnd = new PATypes.PA_PAS_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte579));
/*      */           return pA_PAS_MsgEnd;
/*      */         case 33918:
/*      */           this.data = (byte[])pA_PAS_MsgEnd.getValue();
/*      */           arrayOfByte578 = this.data;
/*      */           pA_PAC_MsgEnd = new PATypes.PA_PAC_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte578));
/*      */           return pA_PAC_MsgEnd;
/*      */         case 33917:
/*      */           this.data = (byte[])pA_PAC_MsgEnd.getValue();
/*      */           arrayOfByte577 = this.data;
/*      */           pA_VFC_MsgEnd = new PATypes.PA_VFC_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte577));
/*      */           return pA_VFC_MsgEnd;
/*      */         case 33916:
/*      */           this.data = (byte[])pA_VFC_MsgEnd.getValue();
/*      */           arrayOfByte576 = this.data;
/*      */           pA_HUD_MsgEnd = new PATypes.PA_HUD_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte576));
/*      */           return pA_HUD_MsgEnd;
/*      */         case 33915:
/*      */           this.data = (byte[])pA_HUD_MsgEnd.getValue();
/*      */           arrayOfByte575 = this.data;
/*      */           pA_Device_MsgEnd = new PATypes.PA_Device_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte575));
/*      */           return pA_Device_MsgEnd;
/*      */         case 33914:
/*      */           this.data = (byte[])pA_Device_MsgEnd.getValue();
/*      */           arrayOfByte574 = this.data;
/*      */           pA_SS_MsgEnd = new PATypes.PA_SS_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte574));
/*      */           return pA_SS_MsgEnd;
/*      */         case 33913:
/*      */           this.data = (byte[])pA_SS_MsgEnd.getValue();
/*      */           arrayOfByte573 = this.data;
/*      */           pA_PSET_MsgEnd = new PATypes.PA_PSET_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte573));
/*      */           return pA_PSET_MsgEnd;
/*      */         case 33912:
/*      */           this.data = (byte[])pA_PSET_MsgEnd.getValue();
/*      */           arrayOfByte572 = this.data;
/*      */           pA_DriveMode_MsgEnd = new PATypes.PA_DriveMode_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte572));
/*      */           return pA_DriveMode_MsgEnd;
/*      */         case 33911:
/*      */           this.data = (byte[])pA_DriveMode_MsgEnd.getValue();
/*      */           arrayOfByte571 = this.data;
/*      */           pA_TCH_MsgEnd = new PATypes.PA_TCH_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte571));
/*      */           return pA_TCH_MsgEnd;
/*      */         case 33910:
/*      */           this.data = (byte[])pA_TCH_MsgEnd.getValue();
/*      */           arrayOfByte570 = this.data;
/*      */           pA_Fragra_MsgEnd = new PATypes.PA_Fragra_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte570));
/*      */           return pA_Fragra_MsgEnd;
/*      */         case 33909:
/*      */           this.data = (byte[])pA_Fragra_MsgEnd.getValue();
/*      */           arrayOfByte569 = this.data;
/*      */           pA_SWH_MsgEnd = new PATypes.PA_SWH_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte569));
/*      */           return pA_SWH_MsgEnd;
/*      */         case 33908:
/*      */           this.data = (byte[])pA_SWH_MsgEnd.getValue();
/*      */           arrayOfByte568 = this.data;
/*      */           pA_SCV_MsgEnd = new PATypes.PA_SCV_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte568));
/*      */           return pA_SCV_MsgEnd;
/*      */         case 33907:
/*      */           this.data = (byte[])pA_SCV_MsgEnd.getValue();
/*      */           arrayOfByte567 = this.data;
/*      */           pA_CL_MsgEnd = new PATypes.PA_CL_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte567));
/*      */           return pA_CL_MsgEnd;
/*      */         case 33906:
/*      */           this.data = (byte[])pA_CL_MsgEnd.getValue();
/*      */           arrayOfByte566 = this.data;
/*      */           pA_DID_MsgEnd = new PATypes.PA_DID_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte566));
/*      */           return pA_DID_MsgEnd;
/*      */         case 33905:
/*      */           this.data = (byte[])pA_DID_MsgEnd.getValue();
/*      */           arrayOfByte565 = this.data;
/*      */           pA_DiagProxy_MsgEnd = new PATypes.PA_DiagProxy_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte565));
/*      */           return pA_DiagProxy_MsgEnd;
/*      */         case 33904:
/*      */           this.data = (byte[])pA_DiagProxy_MsgEnd.getValue();
/*      */           arrayOfByte564 = this.data;
/*      */           pA_Asy_MsgEnd = new PATypes.PA_Asy_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte564));
/*      */           return pA_Asy_MsgEnd;
/*      */         case 33903:
/*      */           this.data = (byte[])pA_Asy_MsgEnd.getValue();
/*      */           arrayOfByte563 = this.data;
/*      */           pA_TS_MsgEnd = new PATypes.PA_TS_MsgEnd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte563));
/*      */           return pA_TS_MsgEnd;
/*      */         case 33902:
/*      */           this.data = (byte[])pA_TS_MsgEnd.getValue();
/*      */           arrayOfByte562 = this.data;
/*      */           pA_AP_Version = new PATypes.PA_AP_Version(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte562));
/*      */           return pA_AP_Version;
/*      */         case 33901:
/*      */           this.data = (byte[])pA_AP_Version.getValue();
/*      */           arrayOfByte561 = this.data;
/*      */           pA_AmpDiagResult = new PATypes.PA_AmpDiagResult(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte561));
/*      */           return pA_AmpDiagResult;
/*      */         case 33900:
/*      */           this.data = (byte[])pA_AmpDiagResult.getValue();
/*      */           arrayOfByte560 = this.data;
/*      */           pA_PSET_ProfilesInuse = new PATypes.PA_PSET_ProfilesInuse(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte560));
/*      */           return pA_PSET_ProfilesInuse;
/*      */         case 33899:
/*      */           this.data = (byte[])pA_PSET_ProfilesInuse.getValue();
/*      */           arrayOfByte559 = this.data;
/*      */           pA_PSET_ProfileDownloadStatus = new PATypes.PA_PSET_ProfileDownloadStatus(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte559));
/*      */           return pA_PSET_ProfileDownloadStatus;
/*      */         case 33898:
/*      */           this.data = (byte[])pA_PSET_ProfileDownloadStatus.getValue();
/*      */           pA_PSET_ProfileCloudData = new PATypes.PA_PSET_ProfileCloudData(VendorVehicleHalPAProto.Profileclouddata.parseFrom(this.data));
/*      */           return pA_PSET_ProfileCloudData;
/*      */         case 33897:
/*      */           this.data = (byte[])pA_PSET_ProfileCloudData.getValue();
/*      */           arrayOfByte558 = this.data;
/*      */           pA_PSET_ProfAct = new PATypes.PA_PSET_ProfAct(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte558));
/*      */           return pA_PSET_ProfAct;
/*      */         case 33896:
/*      */           this.data = (byte[])pA_PSET_ProfAct.getValue();
/*      */           arrayOfByte557 = this.data;
/*      */           pA_PSET_GID_Result = new PATypes.PA_PSET_GID_Result(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte557));
/*      */           return pA_PSET_GID_Result;
/*      */         case 33895:
/*      */           this.data = (byte[])pA_PSET_GID_Result.getValue();
/*      */           arrayOfByte556 = this.data;
/*      */           pA_PSET_SeatLocationAdjust = new PATypes.PA_PSET_SeatLocationAdjust(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte556));
/*      */           return pA_PSET_SeatLocationAdjust;
/*      */         case 33894:
/*      */           this.data = (byte[])pA_PSET_SeatLocationAdjust.getValue();
/*      */           arrayOfByte555 = this.data;
/*      */           pA_PSET_SeatButtonOnOff = new PATypes.PA_PSET_SeatButtonOnOff(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte555));
/*      */           return pA_PSET_SeatButtonOnOff;
/*      */         case 33893:
/*      */           this.data = (byte[])pA_PSET_SeatButtonOnOff.getValue();
/*      */           arrayOfByte554 = this.data;
/*      */           pA_PSET_User6 = new PATypes.PA_PSET_User6(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte554));
/*      */           return pA_PSET_User6;
/*      */         case 33892:
/*      */           this.data = (byte[])pA_PSET_User6.getValue();
/*      */           arrayOfByte553 = this.data;
/*      */           pA_PSET_User5 = new PATypes.PA_PSET_User5(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte553));
/*      */           return pA_PSET_User5;
/*      */         case 33891:
/*      */           this.data = (byte[])pA_PSET_User5.getValue();
/*      */           arrayOfByte552 = this.data;
/*      */           pA_PSET_User4 = new PATypes.PA_PSET_User4(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte552));
/*      */           return pA_PSET_User4;
/*      */         case 33890:
/*      */           this.data = (byte[])pA_PSET_User4.getValue();
/*      */           arrayOfByte551 = this.data;
/*      */           pA_PSET_User3 = new PATypes.PA_PSET_User3(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte551));
/*      */           return pA_PSET_User3;
/*      */         case 33889:
/*      */           this.data = (byte[])pA_PSET_User3.getValue();
/*      */           arrayOfByte550 = this.data;
/*      */           pA_PSET_User2 = new PATypes.PA_PSET_User2(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte550));
/*      */           return pA_PSET_User2;
/*      */         case 33888:
/*      */           this.data = (byte[])pA_PSET_User2.getValue();
/*      */           arrayOfByte549 = this.data;
/*      */           pA_PSET_User1 = new PATypes.PA_PSET_User1(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte549));
/*      */           return pA_PSET_User1;
/*      */         case 33887:
/*      */           this.data = (byte[])pA_PSET_User1.getValue();
/*      */           arrayOfByte548 = this.data;
/*      */           pA_PSET_SimplUnlockCurrent = new PATypes.PA_PSET_SimplUnlockCurrent(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte548));
/*      */           return pA_PSET_SimplUnlockCurrent;
/*      */         case 33886:
/*      */           this.data = (byte[])pA_PSET_SimplUnlockCurrent.getValue();
/*      */           arrayOfByte547 = this.data;
/*      */           pA_PSET_NFC_Result = new PATypes.PA_PSET_NFC_Result(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte547));
/*      */           return pA_PSET_NFC_Result;
/*      */         case 33885:
/*      */           this.data = (byte[])pA_PSET_NFC_Result.getValue();
/*      */           arrayOfByte546 = this.data;
/*      */           pA_PSET_NFCID = new PATypes.PA_PSET_NFCID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte546));
/*      */           return pA_PSET_NFCID;
/*      */         case 33884:
/*      */           this.data = (byte[])pA_PSET_NFCID.getValue();
/*      */           arrayOfByte545 = this.data;
/*      */           pA_PSET_LYNKID_Result = new PATypes.PA_PSET_LYNKID_Result(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte545));
/*      */           return pA_PSET_LYNKID_Result;
/*      */         case 33883:
/*      */           this.data = (byte[])pA_PSET_LYNKID_Result.getValue();
/*      */           arrayOfByte544 = this.data;
/*      */           pA_PSET_LYNKID = new PATypes.PA_PSET_LYNKID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte544));
/*      */           return pA_PSET_LYNKID;
/*      */         case 33882:
/*      */           this.data = (byte[])pA_PSET_LYNKID.getValue();
/*      */           arrayOfByte543 = this.data;
/*      */           pA_PSET_AutLogOutCurrent = new PATypes.PA_PSET_AutLogOutCurrent(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte543));
/*      */           return pA_PSET_AutLogOutCurrent;
/*      */         case 33881:
/*      */           this.data = (byte[])pA_PSET_AutLogOutCurrent.getValue();
/*      */           arrayOfByte542 = this.data;
/*      */           pA_PSET_MaxNrProfReached = new PATypes.PA_PSET_MaxNrProfReached(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte542));
/*      */           return pA_PSET_MaxNrProfReached;
/*      */         case 33880:
/*      */           this.data = (byte[])pA_PSET_MaxNrProfReached.getValue();
/*      */           arrayOfByte541 = this.data;
/*      */           pA_PSET_PChangeAllowed = new PATypes.PA_PSET_PChangeAllowed(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte541));
/*      */           return pA_PSET_PChangeAllowed;
/*      */         case 33879:
/*      */           this.data = (byte[])pA_PSET_PChangeAllowed.getValue();
/*      */           arrayOfByte540 = this.data;
/*      */           pA_PSET_KeyID = new PATypes.PA_PSET_KeyID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte540));
/*      */           return pA_PSET_KeyID;
/*      */         case 33878:
/*      */           this.data = (byte[])pA_PSET_KeyID.getValue();
/*      */           arrayOfByte539 = this.data;
/*      */           pA_PSET_Key_Result = new PATypes.PA_PSET_Key_Result(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte539));
/*      */           return pA_PSET_Key_Result;
/*      */         case 33877:
/*      */           this.data = (byte[])pA_PSET_Key_Result.getValue();
/*      */           arrayOfByte538 = this.data;
/*      */           pA_PSET_FactoryDefaultResult = new PATypes.PA_PSET_FactoryDefaultResult(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte538));
/*      */           return pA_PSET_FactoryDefaultResult;
/*      */         case 33876:
/*      */           this.data = (byte[])pA_PSET_FactoryDefaultResult.getValue();
/*      */           arrayOfByte537 = this.data;
/*      */           pA_PSET_FactoryDefault = new PATypes.PA_PSET_FactoryDefault(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte537));
/*      */           return pA_PSET_FactoryDefault;
/*      */         case 33875:
/*      */           this.data = (byte[])pA_PSET_FactoryDefault.getValue();
/*      */           arrayOfByte536 = this.data;
/*      */           pA_PSET_ProfileFactoryDefaultResult = new PATypes.PA_PSET_ProfileFactoryDefaultResult(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte536));
/*      */           return pA_PSET_ProfileFactoryDefaultResult;
/*      */         case 33874:
/*      */           this.data = (byte[])pA_PSET_ProfileFactoryDefaultResult.getValue();
/*      */           arrayOfByte535 = this.data;
/*      */           pA_PSET_ProfileFactoryDefault = new PATypes.PA_PSET_ProfileFactoryDefault(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte535));
/*      */           return pA_PSET_ProfileFactoryDefault;
/*      */         case 33873:
/*      */           this.data = (byte[])pA_PSET_ProfileFactoryDefault.getValue();
/*      */           arrayOfByte534 = this.data;
/*      */           pA_PSET_LogOut = new PATypes.PA_PSET_LogOut(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte534));
/*      */           return pA_PSET_LogOut;
/*      */         case 33872:
/*      */           this.data = (byte[])pA_PSET_LogOut.getValue();
/*      */           arrayOfByte533 = this.data;
/*      */           pA_PSET_DeleteProfile = new PATypes.PA_PSET_DeleteProfile(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte533));
/*      */           return pA_PSET_DeleteProfile;
/*      */         case 33871:
/*      */           this.data = (byte[])pA_PSET_DeleteProfile.getValue();
/*      */           arrayOfByte532 = this.data;
/*      */           pA_PSET_NewProfile = new PATypes.PA_PSET_NewProfile(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte532));
/*      */           return pA_PSET_NewProfile;
/*      */         case 33870:
/*      */           this.data = (byte[])pA_PSET_NewProfile.getValue();
/*      */           arrayOfByte531 = this.data;
/*      */           pA_PSET_ActiveProfile = new PATypes.PA_PSET_ActiveProfile(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte531));
/*      */           return pA_PSET_ActiveProfile;
/*      */         case 33869:
/*      */           this.data = (byte[])pA_PSET_ActiveProfile.getValue();
/*      */           arrayOfByte530 = this.data;
/*      */           pA_VFS_DPS = new PATypes.PA_VFS_DPS(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte530));
/*      */           return pA_VFS_DPS;
/*      */         case 33868:
/*      */           this.data = (byte[])pA_VFS_DPS.getValue();
/*      */           arrayOfByte529 = this.data;
/*      */           pA_VFS_FaceIdnReq = new PATypes.PA_VFS_FaceIdnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte529));
/*      */           return pA_VFS_FaceIdnReq;
/*      */         case 33867:
/*      */           this.data = (byte[])pA_VFS_FaceIdnReq.getValue();
/*      */           arrayOfByte528 = this.data;
/*      */           pA_ChdLockReRight_ChdMod = new PATypes.PA_ChdLockReRight_ChdMod(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte528));
/*      */           return pA_ChdLockReRight_ChdMod;
/*      */         case 33866:
/*      */           this.data = (byte[])pA_ChdLockReRight_ChdMod.getValue();
/*      */           arrayOfByte527 = this.data;
/*      */           pA_ChdLockReLeft_ChdMod = new PATypes.PA_ChdLockReLeft_ChdMod(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte527));
/*      */           return pA_ChdLockReLeft_ChdMod;
/*      */         case 33865:
/*      */           this.data = (byte[])pA_ChdLockReLeft_ChdMod.getValue();
/*      */           arrayOfByte526 = this.data;
/*      */           pA_ChdLockReRight = new PATypes.PA_ChdLockReRight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte526));
/*      */           return pA_ChdLockReRight;
/*      */         case 33864:
/*      */           this.data = (byte[])pA_ChdLockReRight.getValue();
/*      */           arrayOfByte525 = this.data;
/*      */           pA_ChdLockReLeft = new PATypes.PA_ChdLockReLeft(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte525));
/*      */           return pA_ChdLockReLeft;
/*      */         case 33863:
/*      */           this.data = (byte[])pA_ChdLockReLeft.getValue();
/*      */           arrayOfByte524 = this.data;
/*      */           pA_WinPosnStsAtReRi = new PATypes.PA_WinPosnStsAtReRi(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte524));
/*      */           return pA_WinPosnStsAtReRi;
/*      */         case 33862:
/*      */           this.data = (byte[])pA_WinPosnStsAtReRi.getValue();
/*      */           arrayOfByte523 = this.data;
/*      */           pA_WinPosnStsAtReLe = new PATypes.PA_WinPosnStsAtReLe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte523));
/*      */           return pA_WinPosnStsAtReLe;
/*      */         case 33861:
/*      */           this.data = (byte[])pA_WinPosnStsAtReLe.getValue();
/*      */           arrayOfByte522 = this.data;
/*      */           pA_WinPosnStsAtPass = new PATypes.PA_WinPosnStsAtPass(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte522));
/*      */           return pA_WinPosnStsAtPass;
/*      */         case 33860:
/*      */           this.data = (byte[])pA_WinPosnStsAtPass.getValue();
/*      */           arrayOfByte521 = this.data;
/*      */           pA_WinPosnStsAtDrvr = new PATypes.PA_WinPosnStsAtDrvr(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte521));
/*      */           return pA_WinPosnStsAtDrvr;
/*      */         case 33859:
/*      */           this.data = (byte[])pA_WinPosnStsAtDrvr.getValue();
/*      */           arrayOfByte520 = this.data;
/*      */           pA_WinOpenReRiReq = new PATypes.PA_WinOpenReRiReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte520));
/*      */           return pA_WinOpenReRiReq;
/*      */         case 33858:
/*      */           this.data = (byte[])pA_WinOpenReRiReq.getValue();
/*      */           arrayOfByte519 = this.data;
/*      */           pA_WinOpenReLeReq = new PATypes.PA_WinOpenReLeReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte519));
/*      */           return pA_WinOpenReLeReq;
/*      */         case 33857:
/*      */           this.data = (byte[])pA_WinOpenReLeReq.getValue();
/*      */           arrayOfByte518 = this.data;
/*      */           pA_WinOpenPassReq = new PATypes.PA_WinOpenPassReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte518));
/*      */           return pA_WinOpenPassReq;
/*      */         case 33856:
/*      */           this.data = (byte[])pA_WinOpenPassReq.getValue();
/*      */           arrayOfByte517 = this.data;
/*      */           pA_WinOpenDrvrReq = new PATypes.PA_WinOpenDrvrReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte517));
/*      */           return pA_WinOpenDrvrReq;
/*      */         case 33855:
/*      */           this.data = (byte[])pA_WinOpenDrvrReq.getValue();
/*      */           arrayOfByte516 = this.data;
/*      */           pA_EgyRgnLvlSet = new PATypes.PA_EgyRgnLvlSet(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte516));
/*      */           return pA_EgyRgnLvlSet;
/*      */         case 33854:
/*      */           this.data = (byte[])pA_EgyRgnLvlSet.getValue();
/*      */           arrayOfByte515 = this.data;
/*      */           pA_AmbLiRadarCorrlnReq = new PATypes.PA_AmbLiRadarCorrlnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte515));
/*      */           return pA_AmbLiRadarCorrlnReq;
/*      */         case 33853:
/*      */           this.data = (byte[])pA_AmbLiRadarCorrlnReq.getValue();
/*      */           arrayOfByte514 = this.data;
/*      */           pA_MoodLiColorAdjReq = new PATypes.PA_MoodLiColorAdjReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte514));
/*      */           return pA_MoodLiColorAdjReq;
/*      */         case 33852:
/*      */           this.data = (byte[])pA_MoodLiColorAdjReq.getValue();
/*      */           arrayOfByte513 = this.data;
/*      */           pA_CustomEffectBreath = new PATypes.PA_CustomEffectBreath(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte513));
/*      */           return pA_CustomEffectBreath;
/*      */         case 33851:
/*      */           this.data = (byte[])pA_CustomEffectBreath.getValue();
/*      */           arrayOfByte512 = this.data;
/*      */           pA_ReadLightAllOnSwitch = new PATypes.PA_ReadLightAllOnSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte512));
/*      */           return pA_ReadLightAllOnSwitch;
/*      */         case 33850:
/*      */           this.data = (byte[])pA_ReadLightAllOnSwitch.getValue();
/*      */           arrayOfByte511 = this.data;
/*      */           pA_GoodbyeLight = new PATypes.PA_GoodbyeLight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte511));
/*      */           return pA_GoodbyeLight;
/*      */         case 33849:
/*      */           this.data = (byte[])pA_GoodbyeLight.getValue();
/*      */           arrayOfByte510 = this.data;
/*      */           pA_WelcomeLight = new PATypes.PA_WelcomeLight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte510));
/*      */           return pA_WelcomeLight;
/*      */         case 33848:
/*      */           this.data = (byte[])pA_WelcomeLight.getValue();
/*      */           arrayOfByte509 = this.data;
/*      */           pA_CourtesyLight = new PATypes.PA_CourtesyLight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte509));
/*      */           return pA_CourtesyLight;
/*      */         case 33847:
/*      */           this.data = (byte[])pA_CourtesyLight.getValue();
/*      */           arrayOfByte508 = this.data;
/*      */           pA_WeatherInfoConService = new PATypes.PA_WeatherInfoConService(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte508));
/*      */           return pA_WeatherInfoConService;
/*      */         case 33846:
/*      */           this.data = (byte[])pA_WeatherInfoConService.getValue();
/*      */           arrayOfByte507 = this.data;
/*      */           pA_ReadLightThirdRowRight = new PATypes.PA_ReadLightThirdRowRight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte507));
/*      */           return pA_ReadLightThirdRowRight;
/*      */         case 33845:
/*      */           this.data = (byte[])pA_ReadLightThirdRowRight.getValue();
/*      */           arrayOfByte506 = this.data;
/*      */           pA_ReadLightThirdRowLeft = new PATypes.PA_ReadLightThirdRowLeft(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte506));
/*      */           return pA_ReadLightThirdRowLeft;
/*      */         case 33844:
/*      */           this.data = (byte[])pA_ReadLightThirdRowLeft.getValue();
/*      */           arrayOfByte505 = this.data;
/*      */           pA_ReadLightSecondRowRight = new PATypes.PA_ReadLightSecondRowRight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte505));
/*      */           return pA_ReadLightSecondRowRight;
/*      */         case 33843:
/*      */           this.data = (byte[])pA_ReadLightSecondRowRight.getValue();
/*      */           arrayOfByte504 = this.data;
/*      */           pA_ReadLightSecondRowLeft = new PATypes.PA_ReadLightSecondRowLeft(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte504));
/*      */           return pA_ReadLightSecondRowLeft;
/*      */         case 33842:
/*      */           this.data = (byte[])pA_ReadLightSecondRowLeft.getValue();
/*      */           arrayOfByte503 = this.data;
/*      */           pA_ReadLightFrontRight = new PATypes.PA_ReadLightFrontRight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte503));
/*      */           return pA_ReadLightFrontRight;
/*      */         case 33841:
/*      */           this.data = (byte[])pA_ReadLightFrontRight.getValue();
/*      */           arrayOfByte502 = this.data;
/*      */           pA_ReadLightFrontLeft = new PATypes.PA_ReadLightFrontLeft(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte502));
/*      */           return pA_ReadLightFrontLeft;
/*      */         case 33840:
/*      */           this.data = (byte[])pA_ReadLightFrontLeft.getValue();
/*      */           arrayOfByte501 = this.data;
/*      */           pA_AmbLiPhoneOpenReq = new PATypes.PA_AmbLiPhoneOpenReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte501));
/*      */           return pA_AmbLiPhoneOpenReq;
/*      */         case 33839:
/*      */           this.data = (byte[])pA_AmbLiPhoneOpenReq.getValue();
/*      */           arrayOfByte500 = this.data;
/*      */           pA_AmbLiMilgOpenReq = new PATypes.PA_AmbLiMilgOpenReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte500));
/*      */           return pA_AmbLiMilgOpenReq;
/*      */         case 33838:
/*      */           this.data = (byte[])pA_AmbLiMilgOpenReq.getValue();
/*      */           arrayOfByte499 = this.data;
/*      */           pA_MoodLightSwitch = new PATypes.PA_MoodLightSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte499));
/*      */           return pA_MoodLightSwitch;
/*      */         case 33837:
/*      */           this.data = (byte[])pA_MoodLightSwitch.getValue();
/*      */           arrayOfByte498 = this.data;
/*      */           pA_Zone3ColorSettings = new PATypes.PA_Zone3ColorSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte498));
/*      */           return pA_Zone3ColorSettings;
/*      */         case 33836:
/*      */           this.data = (byte[])pA_Zone3ColorSettings.getValue();
/*      */           arrayOfByte497 = this.data;
/*      */           pA_Zone3IntensitySettings = new PATypes.PA_Zone3IntensitySettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte497));
/*      */           return pA_Zone3IntensitySettings;
/*      */         case 33835:
/*      */           this.data = (byte[])pA_Zone3IntensitySettings.getValue();
/*      */           arrayOfByte496 = this.data;
/*      */           pA_Zone3StatusSettings = new PATypes.PA_Zone3StatusSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte496));
/*      */           return pA_Zone3StatusSettings;
/*      */         case 33834:
/*      */           this.data = (byte[])pA_Zone3StatusSettings.getValue();
/*      */           arrayOfByte495 = this.data;
/*      */           pA_Zone2ColorSettings = new PATypes.PA_Zone2ColorSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte495));
/*      */           return pA_Zone2ColorSettings;
/*      */         case 33833:
/*      */           this.data = (byte[])pA_Zone2ColorSettings.getValue();
/*      */           arrayOfByte494 = this.data;
/*      */           pA_Zone2IntensitySettings = new PATypes.PA_Zone2IntensitySettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte494));
/*      */           return pA_Zone2IntensitySettings;
/*      */         case 33832:
/*      */           this.data = (byte[])pA_Zone2IntensitySettings.getValue();
/*      */           arrayOfByte493 = this.data;
/*      */           pA_Zone2StatusSettings = new PATypes.PA_Zone2StatusSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte493));
/*      */           return pA_Zone2StatusSettings;
/*      */         case 33831:
/*      */           this.data = (byte[])pA_Zone2StatusSettings.getValue();
/*      */           arrayOfByte492 = this.data;
/*      */           pA_Zone1ColorSettings = new PATypes.PA_Zone1ColorSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte492));
/*      */           return pA_Zone1ColorSettings;
/*      */         case 33830:
/*      */           this.data = (byte[])pA_Zone1ColorSettings.getValue();
/*      */           arrayOfByte491 = this.data;
/*      */           pA_Zone1IntensitySettings = new PATypes.PA_Zone1IntensitySettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte491));
/*      */           return pA_Zone1IntensitySettings;
/*      */         case 33829:
/*      */           this.data = (byte[])pA_Zone1IntensitySettings.getValue();
/*      */           arrayOfByte490 = this.data;
/*      */           pA_Zone1StatusSettings = new PATypes.PA_Zone1StatusSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte490));
/*      */           return pA_Zone1StatusSettings;
/*      */         case 33828:
/*      */           this.data = (byte[])pA_Zone1StatusSettings.getValue();
/*      */           arrayOfByte489 = this.data;
/*      */           pA_ZoneAllColorSettings = new PATypes.PA_ZoneAllColorSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte489));
/*      */           return pA_ZoneAllColorSettings;
/*      */         case 33827:
/*      */           this.data = (byte[])pA_ZoneAllColorSettings.getValue();
/*      */           arrayOfByte488 = this.data;
/*      */           pA_ZoneAllIntensitySettings = new PATypes.PA_ZoneAllIntensitySettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte488));
/*      */           return pA_ZoneAllIntensitySettings;
/*      */         case 33826:
/*      */           this.data = (byte[])pA_ZoneAllIntensitySettings.getValue();
/*      */           arrayOfByte487 = this.data;
/*      */           pA_ZoneAllStatusSettings = new PATypes.PA_ZoneAllStatusSettings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte487));
/*      */           return pA_ZoneAllStatusSettings;
/*      */         case 33825:
/*      */           this.data = (byte[])pA_ZoneAllStatusSettings.getValue();
/*      */           arrayOfByte486 = this.data;
/*      */           pA_TransitionColor2Settings = new PATypes.PA_TransitionColor2Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte486));
/*      */           return pA_TransitionColor2Settings;
/*      */         case 33824:
/*      */           this.data = (byte[])pA_TransitionColor2Settings.getValue();
/*      */           arrayOfByte485 = this.data;
/*      */           pA_TransitionColor1Settings = new PATypes.PA_TransitionColor1Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte485));
/*      */           return pA_TransitionColor1Settings;
/*      */         case 33823:
/*      */           this.data = (byte[])pA_TransitionColor1Settings.getValue();
/*      */           arrayOfByte484 = this.data;
/*      */           pA_TransitionEffectSel = new PATypes.PA_TransitionEffectSel(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte484));
/*      */           return pA_TransitionEffectSel;
/*      */         case 33822:
/*      */           this.data = (byte[])pA_TransitionEffectSel.getValue();
/*      */           arrayOfByte483 = this.data;
/*      */           pA_CustomEffect = new PATypes.PA_CustomEffect(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte483));
/*      */           return pA_CustomEffect;
/*      */         case 33821:
/*      */           this.data = (byte[])pA_CustomEffect.getValue();
/*      */           arrayOfByte482 = this.data;
/*      */           pA_AmbLiMod_WeatherIndn = new PATypes.PA_AmbLiMod_WeatherIndn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte482));
/*      */           return pA_AmbLiMod_WeatherIndn;
/*      */         case 33820:
/*      */           this.data = (byte[])pA_AmbLiMod_WeatherIndn.getValue();
/*      */           arrayOfByte481 = this.data;
/*      */           pA_AmbLiMod_MusicShowMode = new PATypes.PA_AmbLiMod_MusicShowMode(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte481));
/*      */           return pA_AmbLiMod_MusicShowMode;
/*      */         case 33819:
/*      */           this.data = (byte[])pA_AmbLiMod_MusicShowMode.getValue();
/*      */           arrayOfByte480 = this.data;
/*      */           pA_AmbLiMod_DriveMode = new PATypes.PA_AmbLiMod_DriveMode(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte480));
/*      */           return pA_AmbLiMod_DriveMode;
/*      */         case 33818:
/*      */           this.data = (byte[])pA_AmbLiMod_DriveMode.getValue();
/*      */           arrayOfByte479 = this.data;
/*      */           pA_AmbLiMod_CustomizedMode = new PATypes.PA_AmbLiMod_CustomizedMode(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte479));
/*      */           return pA_AmbLiMod_CustomizedMode;
/*      */         case 33817:
/*      */           this.data = (byte[])pA_AmbLiMod_CustomizedMode.getValue();
/*      */           arrayOfByte478 = this.data;
/*      */           pA_AmbLiMod_None = new PATypes.PA_AmbLiMod_None(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte478));
/*      */           return pA_AmbLiMod_None;
/*      */         case 33816:
/*      */           this.data = (byte[])pA_AmbLiMod_None.getValue();
/*      */           arrayOfByte477 = this.data;
/*      */           pA_AmbLiModSetting = new PATypes.PA_AmbLiModSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte477));
/*      */           return pA_AmbLiModSetting;
/*      */         case 33815:
/*      */           this.data = (byte[])pA_AmbLiModSetting.getValue();
/*      */           arrayOfByte476 = this.data;
/*      */           pA_AmbLiAll = new PATypes.PA_AmbLiAll(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte476));
/*      */           return pA_AmbLiAll;
/*      */         case 33814:
/*      */           this.data = (byte[])pA_AmbLiAll.getValue();
/*      */           arrayOfByte475 = this.data;
/*      */           pA_HmiCarLocatorSetReq = new PATypes.PA_HmiCarLocatorSetReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte475));
/*      */           return pA_HmiCarLocatorSetReq;
/*      */         case 33813:
/*      */           this.data = (byte[])pA_HmiCarLocatorSetReq.getValue();
/*      */           arrayOfByte474 = this.data;
/*      */           pA_SunRoofTiltReq = new PATypes.PA_SunRoofTiltReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte474));
/*      */           return pA_SunRoofTiltReq;
/*      */         case 33812:
/*      */           this.data = (byte[])pA_SunRoofTiltReq.getValue();
/*      */           arrayOfByte473 = this.data;
/*      */           pA_SunCurtOpenPosnReq = new PATypes.PA_SunCurtOpenPosnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte473));
/*      */           return pA_SunCurtOpenPosnReq;
/*      */         case 33811:
/*      */           this.data = (byte[])pA_SunCurtOpenPosnReq.getValue();
/*      */           arrayOfByte472 = this.data;
/*      */           pA_SunRoofOpenPosnReq = new PATypes.PA_SunRoofOpenPosnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte472));
/*      */           return pA_SunRoofOpenPosnReq;
/*      */         case 33810:
/*      */           this.data = (byte[])pA_SunRoofOpenPosnReq.getValue();
/*      */           arrayOfByte471 = this.data;
/*      */           pA_SunCurtainPosnSts = new PATypes.PA_SunCurtainPosnSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte471));
/*      */           return pA_SunCurtainPosnSts;
/*      */         case 33809:
/*      */           this.data = (byte[])pA_SunCurtainPosnSts.getValue();
/*      */           arrayOfByte470 = this.data;
/*      */           pA_SunRoofPosnSts = new PATypes.PA_SunRoofPosnSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte470));
/*      */           return pA_SunRoofPosnSts;
/*      */         case 33808:
/*      */           this.data = (byte[])pA_SunRoofPosnSts.getValue();
/*      */           arrayOfByte469 = this.data;
/*      */           pA_CloseSunCurtain_Btn = new PATypes.PA_CloseSunCurtain_Btn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte469));
/*      */           return pA_CloseSunCurtain_Btn;
/*      */         case 33807:
/*      */           this.data = (byte[])pA_CloseSunCurtain_Btn.getValue();
/*      */           arrayOfByte468 = this.data;
/*      */           pA_OpenSunCurtain_Btn = new PATypes.PA_OpenSunCurtain_Btn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte468));
/*      */           return pA_OpenSunCurtain_Btn;
/*      */         case 33806:
/*      */           this.data = (byte[])pA_OpenSunCurtain_Btn.getValue();
/*      */           arrayOfByte467 = this.data;
/*      */           pA_CloseSunRoof_Btn = new PATypes.PA_CloseSunRoof_Btn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte467));
/*      */           return pA_CloseSunRoof_Btn;
/*      */         case 33805:
/*      */           this.data = (byte[])pA_CloseSunRoof_Btn.getValue();
/*      */           arrayOfByte466 = this.data;
/*      */           pA_OpenSunRoof_Btn = new PATypes.PA_OpenSunRoof_Btn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte466));
/*      */           return pA_OpenSunRoof_Btn;
/*      */         case 33804:
/*      */           this.data = (byte[])pA_OpenSunRoof_Btn.getValue();
/*      */           arrayOfByte465 = this.data;
/*      */           pA_SunCurtain_Setting = new PATypes.PA_SunCurtain_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte465));
/*      */           return pA_SunCurtain_Setting;
/*      */         case 33803:
/*      */           this.data = (byte[])pA_SunCurtain_Setting.getValue();
/*      */           arrayOfByte464 = this.data;
/*      */           pA_VehCharg_ChrgnOrDisChrgnStsFb = new PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte464));
/*      */           return pA_VehCharg_ChrgnOrDisChrgnStsFb;
/*      */         case 33802:
/*      */           this.data = (byte[])pA_VehCharg_ChrgnOrDisChrgnStsFb.getValue();
/*      */           arrayOfByte463 = this.data;
/*      */           pA_VehCharg_HvBattChrgnTiEstimd = new PATypes.PA_VehCharg_HvBattChrgnTiEstimd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte463));
/*      */           return pA_VehCharg_HvBattChrgnTiEstimd;
/*      */         case 33801:
/*      */           this.data = (byte[])pA_VehCharg_HvBattChrgnTiEstimd.getValue();
/*      */           arrayOfByte462 = this.data;
/*      */           pA_VehCharg_OnBdChrgrIAct = new PATypes.PA_VehCharg_OnBdChrgrIAct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte462));
/*      */           return pA_VehCharg_OnBdChrgrIAct;
/*      */         case 33800:
/*      */           this.data = (byte[])pA_VehCharg_OnBdChrgrIAct.getValue();
/*      */           arrayOfByte461 = this.data;
/*      */           pA_VehCharg_OnBdChrgrUAct = new PATypes.PA_VehCharg_OnBdChrgrUAct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte461));
/*      */           return pA_VehCharg_OnBdChrgrUAct;
/*      */         case 33799:
/*      */           this.data = (byte[])pA_VehCharg_OnBdChrgrUAct.getValue();
/*      */           arrayOfByte460 = this.data;
/*      */           pA_VehCharg_DispHvBattLvlOfChrg = new PATypes.PA_VehCharg_DispHvBattLvlOfChrg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte460));
/*      */           return pA_VehCharg_DispHvBattLvlOfChrg;
/*      */         case 33798:
/*      */           this.data = (byte[])pA_VehCharg_DispHvBattLvlOfChrg.getValue();
/*      */           arrayOfByte459 = this.data;
/*      */           pA_VehCharg_DchaEgyAct = new PATypes.PA_VehCharg_DchaEgyAct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte459));
/*      */           return pA_VehCharg_DchaEgyAct;
/*      */         case 33797:
/*      */           this.data = (byte[])pA_VehCharg_DchaEgyAct.getValue();
/*      */           arrayOfByte458 = this.data;
/*      */           pA_VehCharg_HvBattDchaTiEstimd = new PATypes.PA_VehCharg_HvBattDchaTiEstimd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte458));
/*      */           return pA_VehCharg_HvBattDchaTiEstimd;
/*      */         case 33796:
/*      */           this.data = (byte[])pA_VehCharg_HvBattDchaTiEstimd.getValue();
/*      */           arrayOfByte457 = this.data;
/*      */           pA_VehCharg_DchaIAct = new PATypes.PA_VehCharg_DchaIAct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte457));
/*      */           return pA_VehCharg_DchaIAct;
/*      */         case 33795:
/*      */           this.data = (byte[])pA_VehCharg_DchaIAct.getValue();
/*      */           arrayOfByte456 = this.data;
/*      */           pA_VehCharg_DchaUAct = new PATypes.PA_VehCharg_DchaUAct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte456));
/*      */           return pA_VehCharg_DchaUAct;
/*      */         case 33794:
/*      */           this.data = (byte[])pA_VehCharg_DchaUAct.getValue();
/*      */           arrayOfByte455 = this.data;
/*      */           pA_VehCharg_DisChargeRecord = new PATypes.PA_VehCharg_DisChargeRecord(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte455));
/*      */           return pA_VehCharg_DisChargeRecord;
/*      */         case 33793:
/*      */           this.data = (byte[])pA_VehCharg_DisChargeRecord.getValue();
/*      */           arrayOfByte454 = this.data;
/*      */           pA_VehCharg_DisChargeSwitch = new PATypes.PA_VehCharg_DisChargeSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte454));
/*      */           return pA_VehCharg_DisChargeSwitch;
/*      */         case 33792:
/*      */           this.data = (byte[])pA_VehCharg_DisChargeSwitch.getValue();
/*      */           arrayOfByte453 = this.data;
/*      */           pA_VehCharg_DisChargInfoShow = new PATypes.PA_VehCharg_DisChargInfoShow(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte453));
/*      */           return pA_VehCharg_DisChargInfoShow;
/*      */         case 33791:
/*      */           this.data = (byte[])pA_VehCharg_DisChargInfoShow.getValue();
/*      */           arrayOfByte452 = this.data;
/*      */           pA_VehCharg_DisChargSOC = new PATypes.PA_VehCharg_DisChargSOC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte452));
/*      */           return pA_VehCharg_DisChargSOC;
/*      */         case 33790:
/*      */           this.data = (byte[])pA_VehCharg_DisChargSOC.getValue();
/*      */           arrayOfByte451 = this.data;
/*      */           pA_VehCharg_Appointment = new PATypes.PA_VehCharg_Appointment(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte451));
/*      */           return pA_VehCharg_Appointment;
/*      */         case 33789:
/*      */           this.data = (byte[])pA_VehCharg_Appointment.getValue();
/*      */           arrayOfByte450 = this.data;
/*      */           pA_VehCharg_ChargLight = new PATypes.PA_VehCharg_ChargLight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte450));
/*      */           return pA_VehCharg_ChargLight;
/*      */         case 33788:
/*      */           this.data = (byte[])pA_VehCharg_ChargLight.getValue();
/*      */           arrayOfByte449 = this.data;
/*      */           pA_VehCharg_ChargInfoShow = new PATypes.PA_VehCharg_ChargInfoShow(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte449));
/*      */           return pA_VehCharg_ChargInfoShow;
/*      */         case 33787:
/*      */           this.data = (byte[])pA_VehCharg_ChargInfoShow.getValue();
/*      */           arrayOfByte448 = this.data;
/*      */           pA_VehCharg_ChargSt = new PATypes.PA_VehCharg_ChargSt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte448));
/*      */           return pA_VehCharg_ChargSt;
/*      */         case 33786:
/*      */           this.data = (byte[])pA_VehCharg_ChargSt.getValue();
/*      */           arrayOfByte447 = this.data;
/*      */           pA_VehCharg_SetSOC = new PATypes.PA_VehCharg_SetSOC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte447));
/*      */           return pA_VehCharg_SetSOC;
/*      */         case 33785:
/*      */           this.data = (byte[])pA_VehCharg_SetSOC.getValue();
/*      */           arrayOfByte446 = this.data;
/*      */           pA_VehCharg_SetA = new PATypes.PA_VehCharg_SetA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte446));
/*      */           return pA_VehCharg_SetA;
/*      */         case 33784:
/*      */           this.data = (byte[])pA_VehCharg_SetA.getValue();
/*      */           arrayOfByte445 = this.data;
/*      */           pA_VehCharg_ChargRemind = new PATypes.PA_VehCharg_ChargRemind(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte445));
/*      */           return pA_VehCharg_ChargRemind;
/*      */         case 33783:
/*      */           this.data = (byte[])pA_VehCharg_ChargRemind.getValue();
/*      */           arrayOfByte444 = this.data;
/*      */           pA_TS_energyReStats100 = new PATypes.PA_TS_energyReStats100(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte444));
/*      */           return pA_TS_energyReStats100;
/*      */         case 33782:
/*      */           this.data = (byte[])pA_TS_energyReStats100.getValue();
/*      */           arrayOfByte443 = this.data;
/*      */           pA_TS_energyReStats10 = new PATypes.PA_TS_energyReStats10(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte443));
/*      */           return pA_TS_energyReStats10;
/*      */         case 33781:
/*      */           this.data = (byte[])pA_TS_energyReStats10.getValue();
/*      */           arrayOfByte442 = this.data;
/*      */           pA_TS_energyStats100 = new PATypes.PA_TS_energyStats100(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte442));
/*      */           return pA_TS_energyStats100;
/*      */         case 33780:
/*      */           this.data = (byte[])pA_TS_energyStats100.getValue();
/*      */           arrayOfByte441 = this.data;
/*      */           pA_TS_energyStats10 = new PATypes.PA_TS_energyStats10(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte441));
/*      */           return pA_TS_energyStats10;
/*      */         case 33779:
/*      */           this.data = (byte[])pA_TS_energyStats10.getValue();
/*      */           arrayOfByte440 = this.data;
/*      */           pA_TS_fuelStats100 = new PATypes.PA_TS_fuelStats100(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte440));
/*      */           return pA_TS_fuelStats100;
/*      */         case 33778:
/*      */           this.data = (byte[])pA_TS_fuelStats100.getValue();
/*      */           arrayOfByte439 = this.data;
/*      */           pA_TS_fuelStats10 = new PATypes.PA_TS_fuelStats10(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte439));
/*      */           return pA_TS_fuelStats10;
/*      */         case 33777:
/*      */           this.data = (byte[])pA_TS_fuelStats10.getValue();
/*      */           arrayOfByte438 = this.data;
/*      */           pA_TS_TripAverageEnConsumption5Km = new PATypes.PA_TS_TripAverageEnConsumption5Km(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte438));
/*      */           return pA_TS_TripAverageEnConsumption5Km;
/*      */         case 33776:
/*      */           this.data = (byte[])pA_TS_TripAverageEnConsumption5Km.getValue();
/*      */           arrayOfByte437 = this.data;
/*      */           pA_TS_TripAverageEnConsumption05Km = new PATypes.PA_TS_TripAverageEnConsumption05Km(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte437));
/*      */           return pA_TS_TripAverageEnConsumption05Km;
/*      */         case 33775:
/*      */           this.data = (byte[])pA_TS_TripAverageEnConsumption05Km.getValue();
/*      */           arrayOfByte436 = this.data;
/*      */           pA_TS_TripAverageConsumption5Km = new PATypes.PA_TS_TripAverageConsumption5Km(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte436));
/*      */           return pA_TS_TripAverageConsumption5Km;
/*      */         case 33774:
/*      */           this.data = (byte[])pA_TS_TripAverageConsumption5Km.getValue();
/*      */           arrayOfByte435 = this.data;
/*      */           pA_TS_TripAverageConsumption05Km = new PATypes.PA_TS_TripAverageConsumption05Km(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte435));
/*      */           return pA_TS_TripAverageConsumption05Km;
/*      */         case 33773:
/*      */           this.data = (byte[])pA_TS_TripAverageConsumption05Km.getValue();
/*      */           arrayOfByte434 = this.data;
/*      */           pA_TS_OdometerTripMeter2 = new PATypes.PA_TS_OdometerTripMeter2(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte434));
/*      */           return pA_TS_OdometerTripMeter2;
/*      */         case 33772:
/*      */           this.data = (byte[])pA_TS_OdometerTripMeter2.getValue();
/*      */           arrayOfByte433 = this.data;
/*      */           pA_TS_Zero_Emission = new PATypes.PA_TS_Zero_Emission(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte433));
/*      */           return pA_TS_Zero_Emission;
/*      */         case 33771:
/*      */           this.data = (byte[])pA_TS_Zero_Emission.getValue();
/*      */           arrayOfByte432 = this.data;
/*      */           pA_TS_EDT_time2 = new PATypes.PA_TS_EDT_time2(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte432));
/*      */           return pA_TS_EDT_time2;
/*      */         case 33770:
/*      */           this.data = (byte[])pA_TS_EDT_time2.getValue();
/*      */           arrayOfByte431 = this.data;
/*      */           pA_TS_DTEHV_round = new PATypes.PA_TS_DTEHV_round(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte431));
/*      */           return pA_TS_DTEHV_round;
/*      */         case 33769:
/*      */           this.data = (byte[])pA_TS_DTEHV_round.getValue();
/*      */           arrayOfByte430 = this.data;
/*      */           pA_TS_DTEHVBattIndicated = new PATypes.PA_TS_DTEHVBattIndicated(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte430));
/*      */           return pA_TS_DTEHVBattIndicated;
/*      */         case 33768:
/*      */           this.data = (byte[])pA_TS_DTEHVBattIndicated.getValue();
/*      */           arrayOfByte429 = this.data;
/*      */           pA_TS_DTEIndicated = new PATypes.PA_TS_DTEIndicated(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte429));
/*      */           return pA_TS_DTEIndicated;
/*      */         case 33767:
/*      */           this.data = (byte[])pA_TS_DTEIndicated.getValue();
/*      */           pA_D0D0 = new PATypes.PA_D0D0(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_D0D0;
/*      */         case 33766:
/*      */           this.data = (byte[])pA_D0D0.getValue();
/*      */           pA_D0D1 = new PATypes.PA_D0D1(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_D0D1;
/*      */         case 33765:
/*      */           this.data = (byte[])pA_D0D1.getValue();
/*      */           pA_D0D2 = new PATypes.PA_D0D2(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_D0D2;
/*      */         case 33764:
/*      */           this.data = (byte[])pA_D0D2.getValue();
/*      */           arrayOfByte428 = this.data;
/*      */           pA_Privacy_Compliance_Reset = new PATypes.PA_Privacy_Compliance_Reset(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte428));
/*      */           return pA_Privacy_Compliance_Reset;
/*      */         case 33763:
/*      */           this.data = (byte[])pA_Privacy_Compliance_Reset.getValue();
/*      */           arrayOfByte427 = this.data;
/*      */           pA_AuthorityMicrophoneSwitch = new PATypes.PA_AuthorityMicrophoneSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte427));
/*      */           return pA_AuthorityMicrophoneSwitch;
/*      */         case 33762:
/*      */           this.data = (byte[])pA_AuthorityMicrophoneSwitch.getValue();
/*      */           arrayOfByte426 = this.data;
/*      */           pA_AuthorityCameraSwitch = new PATypes.PA_AuthorityCameraSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte426));
/*      */           return pA_AuthorityCameraSwitch;
/*      */         case 33761:
/*      */           this.data = (byte[])pA_AuthorityCameraSwitch.getValue();
/*      */           arrayOfByte425 = this.data;
/*      */           pA_AuthorityLocationSwitch = new PATypes.PA_AuthorityLocationSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte425));
/*      */           return pA_AuthorityLocationSwitch;
/*      */         case 33760:
/*      */           this.data = (byte[])pA_AuthorityLocationSwitch.getValue();
/*      */           arrayOfByte424 = this.data;
/*      */           pA_FD92 = new PATypes.PA_FD92(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte424));
/*      */           return pA_FD92;
/*      */         case 33759:
/*      */           this.data = (byte[])pA_FD92.getValue();
/*      */           arrayOfByte423 = this.data;
/*      */           pA_FD91 = new PATypes.PA_FD91(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte423));
/*      */           return pA_FD91;
/*      */         case 33758:
/*      */           this.data = (byte[])pA_FD91.getValue();
/*      */           arrayOfByte422 = this.data;
/*      */           pA_FD86 = new PATypes.PA_FD86(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte422));
/*      */           return pA_FD86;
/*      */         case 33757:
/*      */           this.data = (byte[])pA_FD86.getValue();
/*      */           arrayOfByte421 = this.data;
/*      */           pA_FD88 = new PATypes.PA_FD88(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte421));
/*      */           return pA_FD88;
/*      */         case 33756:
/*      */           this.data = (byte[])pA_FD88.getValue();
/*      */           pA_FD85 = new PATypes.PA_FD85(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD85;
/*      */         case 33755:
/*      */           this.data = (byte[])pA_FD85.getValue();
/*      */           pA_FD62 = new PATypes.PA_FD62(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD62;
/*      */         case 33754:
/*      */           this.data = (byte[])pA_FD62.getValue();
/*      */           pA_FD43 = new PATypes.PA_FD43(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD43;
/*      */         case 33753:
/*      */           this.data = (byte[])pA_FD43.getValue();
/*      */           pA_FD41 = new PATypes.PA_FD41(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD41;
/*      */         case 33752:
/*      */           this.data = (byte[])pA_FD41.getValue();
/*      */           pA_FD44 = new PATypes.PA_FD44(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD44;
/*      */         case 33751:
/*      */           this.data = (byte[])pA_FD44.getValue();
/*      */           pA_FD42 = new PATypes.PA_FD42(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD42;
/*      */         case 33750:
/*      */           this.data = (byte[])pA_FD42.getValue();
/*      */           pA_FD23 = new PATypes.PA_FD23(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD23;
/*      */         case 33749:
/*      */           this.data = (byte[])pA_FD23.getValue();
/*      */           pA_FD30 = new PATypes.PA_FD30(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD30;
/*      */         case 33748:
/*      */           this.data = (byte[])pA_FD30.getValue();
/*      */           pA_FD5A = new PATypes.PA_FD5A(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD5A;
/*      */         case 33747:
/*      */           this.data = (byte[])pA_FD5A.getValue();
/*      */           pA_FD17 = new PATypes.PA_FD17(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD17;
/*      */         case 33746:
/*      */           this.data = (byte[])pA_FD17.getValue();
/*      */           pA_FD12 = new PATypes.PA_FD12(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD12;
/*      */         case 33745:
/*      */           this.data = (byte[])pA_FD12.getValue();
/*      */           pA_FD29 = new PATypes.PA_FD29(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_FD29;
/*      */         case 33744:
/*      */           this.data = (byte[])pA_FD29.getValue();
/*      */           arrayOfByte420 = this.data;
/*      */           pA_FD39 = new PATypes.PA_FD39(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte420));
/*      */           return pA_FD39;
/*      */         case 33743:
/*      */           this.data = (byte[])pA_FD39.getValue();
/*      */           arrayOfByte419 = this.data;
/*      */           pA_FD28 = new PATypes.PA_FD28(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte419));
/*      */           return pA_FD28;
/*      */         case 33742:
/*      */           this.data = (byte[])pA_FD28.getValue();
/*      */           arrayOfByte418 = this.data;
/*      */           pA_FD27 = new PATypes.PA_FD27(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte418));
/*      */           return pA_FD27;
/*      */         case 33741:
/*      */           this.data = (byte[])pA_FD27.getValue();
/*      */           arrayOfByte417 = this.data;
/*      */           pA_FD26 = new PATypes.PA_FD26(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte417));
/*      */           return pA_FD26;
/*      */         case 33740:
/*      */           this.data = (byte[])pA_FD26.getValue();
/*      */           arrayOfByte416 = this.data;
/*      */           pA_CSDM_PSD_EN = new PATypes.PA_CSDM_PSD_EN(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte416));
/*      */           return pA_CSDM_PSD_EN;
/*      */         case 33739:
/*      */           this.data = (byte[])pA_CSDM_PSD_EN.getValue();
/*      */           arrayOfByte415 = this.data;
/*      */           pA_D907 = new PATypes.PA_D907(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte415));
/*      */           return pA_D907;
/*      */         case 33738:
/*      */           this.data = (byte[])pA_D907.getValue();
/*      */           arrayOfByte414 = this.data;
/*      */           pA_Manufacturing_Signal = new PATypes.PA_Manufacturing_Signal(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte414));
/*      */           return pA_Manufacturing_Signal;
/*      */         case 33737:
/*      */           this.data = (byte[])pA_Manufacturing_Signal.getValue();
/*      */           pA_VolvoHWSD_Reading = new PATypes.PA_VolvoHWSD_Reading(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_VolvoHWSD_Reading;
/*      */         case 33736:
/*      */           this.data = (byte[])pA_VolvoHWSD_Reading.getValue();
/*      */           pA_VolvoDelivery_Assemble_Reading = new PATypes.PA_VolvoDelivery_Assemble_Reading(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_VolvoDelivery_Assemble_Reading;
/*      */         case 33735:
/*      */           this.data = (byte[])pA_VolvoDelivery_Assemble_Reading.getValue();
/*      */           pA_GeelyHSWD_Reading = new PATypes.PA_GeelyHSWD_Reading(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_GeelyHSWD_Reading;
/*      */         case 33734:
/*      */           this.data = (byte[])pA_GeelyHSWD_Reading.getValue();
/*      */           pA_Geely_Delivery_Assemble_Reading = new PATypes.PA_Geely_Delivery_Assemble_Reading(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_Geely_Delivery_Assemble_Reading;
/*      */         case 33733:
/*      */           this.data = (byte[])pA_Geely_Delivery_Assemble_Reading.getValue();
/*      */           pA_HW_Version_Reading = new PATypes.PA_HW_Version_Reading(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_HW_Version_Reading;
/*      */         case 33732:
/*      */           this.data = (byte[])pA_HW_Version_Reading.getValue();
/*      */           pA_IHUID_Reading = new PATypes.PA_IHUID_Reading(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_IHUID_Reading;
/*      */         case 33731:
/*      */           this.data = (byte[])pA_IHUID_Reading.getValue();
/*      */           pA_XDSN_Reading = new PATypes.PA_XDSN_Reading(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_XDSN_Reading;
/*      */         case 33730:
/*      */           this.data = (byte[])pA_XDSN_Reading.getValue();
/*      */           pA_Product_Serial_Number = new PATypes.PA_Product_Serial_Number(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_Product_Serial_Number;
/*      */         case 33729:
/*      */           this.data = (byte[])pA_Product_Serial_Number.getValue();
/*      */           arrayOfByte413 = this.data;
/*      */           pA_Dcm_D912_PSD_MONITOR_EN = new PATypes.PA_Dcm_D912_PSD_MONITOR_EN(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte413));
/*      */           return pA_Dcm_D912_PSD_MONITOR_EN;
/*      */         case 33728:
/*      */           this.data = (byte[])pA_Dcm_D912_PSD_MONITOR_EN.getValue();
/*      */           arrayOfByte412 = this.data;
/*      */           pA_Chat_Video_IN = new PATypes.PA_Chat_Video_IN(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte412));
/*      */           return pA_Chat_Video_IN;
/*      */         case 33727:
/*      */           this.data = (byte[])pA_Chat_Video_IN.getValue();
/*      */           arrayOfByte411 = this.data;
/*      */           pA_Gesture_Video_IN = new PATypes.PA_Gesture_Video_IN(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte411));
/*      */           return pA_Gesture_Video_IN;
/*      */         case 33726:
/*      */           this.data = (byte[])pA_Gesture_Video_IN.getValue();
/*      */           arrayOfByte410 = this.data;
/*      */           pA_DVR_Video_IN = new PATypes.PA_DVR_Video_IN(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte410));
/*      */           return pA_DVR_Video_IN;
/*      */         case 33725:
/*      */           this.data = (byte[])pA_DVR_Video_IN.getValue();
/*      */           arrayOfByte409 = this.data;
/*      */           pA_PASWAM_Video_in = new PATypes.PA_PASWAM_Video_in(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte409));
/*      */           return pA_PASWAM_Video_in;
/*      */         case 33724:
/*      */           this.data = (byte[])pA_PASWAM_Video_in.getValue();
/*      */           arrayOfByte408 = this.data;
/*      */           pA_CSD_MONITOR_EN = new PATypes.PA_CSD_MONITOR_EN(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte408));
/*      */           return pA_CSD_MONITOR_EN;
/*      */         case 33723:
/*      */           this.data = (byte[])pA_CSD_MONITOR_EN.getValue();
/*      */           pA_DiagProxy_Psd_GW_Fun = new PATypes.PA_DiagProxy_Psd_GW_Fun(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DiagProxy_Psd_GW_Fun;
/*      */         case 33722:
/*      */           this.data = (byte[])pA_DiagProxy_Psd_GW_Fun.getValue();
/*      */           pA_DiagProxy_Psd_GW_Phy = new PATypes.PA_DiagProxy_Psd_GW_Phy(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DiagProxy_Psd_GW_Phy;
/*      */         case 33721:
/*      */           this.data = (byte[])pA_DiagProxy_Psd_GW_Phy.getValue();
/*      */           pA_DiagProxy_Csdm_GW_Fun = new PATypes.PA_DiagProxy_Csdm_GW_Fun(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DiagProxy_Csdm_GW_Fun;
/*      */         case 33720:
/*      */           this.data = (byte[])pA_DiagProxy_Csdm_GW_Fun.getValue();
/*      */           pA_DiagProxy_Csdm_GW_Phy = new PATypes.PA_DiagProxy_Csdm_GW_Phy(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DiagProxy_Csdm_GW_Phy;
/*      */         case 33719:
/*      */           this.data = (byte[])pA_DiagProxy_Csdm_GW_Phy.getValue();
/*      */           pA_DiagProxy_Csd_GW_Fun = new PATypes.PA_DiagProxy_Csd_GW_Fun(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DiagProxy_Csd_GW_Fun;
/*      */         case 33718:
/*      */           this.data = (byte[])pA_DiagProxy_Csd_GW_Fun.getValue();
/*      */           pA_DiagProxy_Csd_GW_Phy = new PATypes.PA_DiagProxy_Csd_GW_Phy(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DiagProxy_Csd_GW_Phy;
/*      */         case 33717:
/*      */           this.data = (byte[])pA_DiagProxy_Csd_GW_Phy.getValue();
/*      */           pA_DiagProxy_Status = new PATypes.PA_DiagProxy_Status(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DiagProxy_Status;
/*      */         case 33716:
/*      */           this.data = (byte[])pA_DiagProxy_Status.getValue();
/*      */           arrayOfByte407 = this.data;
/*      */           pA_HealthOfEngOil = new PATypes.PA_HealthOfEngOil(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte407));
/*      */           return pA_HealthOfEngOil;
/*      */         case 33715:
/*      */           this.data = (byte[])pA_HealthOfEngOil.getValue();
/*      */           arrayOfByte406 = this.data;
/*      */           pA_NatUsgDayOfOil = new PATypes.PA_NatUsgDayOfOil(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte406));
/*      */           return pA_NatUsgDayOfOil;
/*      */         case 33714:
/*      */           this.data = (byte[])pA_NatUsgDayOfOil.getValue();
/*      */           arrayOfByte405 = this.data;
/*      */           pA_DstTrvldOfEng = new PATypes.PA_DstTrvldOfEng(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte405));
/*      */           return pA_DstTrvldOfEng;
/*      */         case 33713:
/*      */           this.data = (byte[])pA_DstTrvldOfEng.getValue();
/*      */           arrayOfByte404 = this.data;
/*      */           pA_DstTrvldOfEV = new PATypes.PA_DstTrvldOfEV(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte404));
/*      */           return pA_DstTrvldOfEV;
/*      */         case 33712:
/*      */           this.data = (byte[])pA_DstTrvldOfEV.getValue();
/*      */           arrayOfByte403 = this.data;
/*      */           pA_DstTrvldAct = new PATypes.PA_DstTrvldAct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte403));
/*      */           return pA_DstTrvldAct;
/*      */         case 33711:
/*      */           this.data = (byte[])pA_DstTrvldAct.getValue();
/*      */           arrayOfByte402 = this.data;
/*      */           pA_ServiceReminderType = new PATypes.PA_ServiceReminderType(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte402));
/*      */           return pA_ServiceReminderType;
/*      */         case 33710:
/*      */           this.data = (byte[])pA_ServiceReminderType.getValue();
/*      */           arrayOfByte401 = this.data;
/*      */           pA_Locking_ApproachToOpenTrSwt = new PATypes.PA_Locking_ApproachToOpenTrSwt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte401));
/*      */           return pA_Locking_ApproachToOpenTrSwt;
/*      */         case 33709:
/*      */           this.data = (byte[])pA_Locking_ApproachToOpenTrSwt.getValue();
/*      */           arrayOfByte400 = this.data;
/*      */           pA_DoubleLock = new PATypes.PA_DoubleLock(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte400));
/*      */           return pA_DoubleLock;
/*      */         case 33708:
/*      */           this.data = (byte[])pA_DoubleLock.getValue();
/*      */           arrayOfByte399 = this.data;
/*      */           pA_RearMirrors = new PATypes.PA_RearMirrors(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte399));
/*      */           return pA_RearMirrors;
/*      */         case 33707:
/*      */           this.data = (byte[])pA_RearMirrors.getValue();
/*      */           arrayOfByte398 = this.data;
/*      */           pA_UnlckTrunk = new PATypes.PA_UnlckTrunk(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte398));
/*      */           return pA_UnlckTrunk;
/*      */         case 33706:
/*      */           this.data = (byte[])pA_UnlckTrunk.getValue();
/*      */           arrayOfByte397 = this.data;
/*      */           pA_LifeDetectionSwitch = new PATypes.PA_LifeDetectionSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte397));
/*      */           return pA_LifeDetectionSwitch;
/*      */         case 33705:
/*      */           this.data = (byte[])pA_LifeDetectionSwitch.getValue();
/*      */           arrayOfByte396 = this.data;
/*      */           pA_PowerFlow_HEV = new PATypes.PA_PowerFlow_HEV(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte396));
/*      */           return pA_PowerFlow_HEV;
/*      */         case 33704:
/*      */           this.data = (byte[])pA_PowerFlow_HEV.getValue();
/*      */           arrayOfByte395 = this.data;
/*      */           pA_IntelligentFuSave = new PATypes.PA_IntelligentFuSave(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte395));
/*      */           return pA_IntelligentFuSave;
/*      */         case 33703:
/*      */           this.data = (byte[])pA_IntelligentFuSave.getValue();
/*      */           arrayOfByte394 = this.data;
/*      */           pA_TripCom_RstAEC = new PATypes.PA_TripCom_RstAEC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte394));
/*      */           return pA_TripCom_RstAEC;
/*      */         case 33702:
/*      */           this.data = (byte[])pA_TripCom_RstAEC.getValue();
/*      */           arrayOfByte393 = this.data;
/*      */           pA_TripCom_RstAFC = new PATypes.PA_TripCom_RstAFC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte393));
/*      */           return pA_TripCom_RstAFC;
/*      */         case 33701:
/*      */           this.data = (byte[])pA_TripCom_RstAFC.getValue();
/*      */           arrayOfByte392 = this.data;
/*      */           pA_TripCom_RstEDT = new PATypes.PA_TripCom_RstEDT(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte392));
/*      */           return pA_TripCom_RstEDT;
/*      */         case 33700:
/*      */           this.data = (byte[])pA_TripCom_RstEDT.getValue();
/*      */           arrayOfByte391 = this.data;
/*      */           pA_TripCom_RstAVS = new PATypes.PA_TripCom_RstAVS(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte391));
/*      */           return pA_TripCom_RstAVS;
/*      */         case 33699:
/*      */           this.data = (byte[])pA_TripCom_RstAVS.getValue();
/*      */           arrayOfByte390 = this.data;
/*      */           pA_TripCom_RstTrip = new PATypes.PA_TripCom_RstTrip(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte390));
/*      */           return pA_TripCom_RstTrip;
/*      */         case 33698:
/*      */           this.data = (byte[])pA_TripCom_RstTrip.getValue();
/*      */           arrayOfByte389 = this.data;
/*      */           pA_TripCom_RetALL = new PATypes.PA_TripCom_RetALL(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte389));
/*      */           return pA_TripCom_RetALL;
/*      */         case 33697:
/*      */           this.data = (byte[])pA_TripCom_RetALL.getValue();
/*      */           arrayOfByte388 = this.data;
/*      */           pA_RefuleAutoResetSetting = new PATypes.PA_RefuleAutoResetSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte388));
/*      */           return pA_RefuleAutoResetSetting;
/*      */         case 33696:
/*      */           this.data = (byte[])pA_RefuleAutoResetSetting.getValue();
/*      */           arrayOfByte387 = this.data;
/*      */           pA_ParkingAutoResetSetting = new PATypes.PA_ParkingAutoResetSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte387));
/*      */           return pA_ParkingAutoResetSetting;
/*      */         case 33695:
/*      */           this.data = (byte[])pA_ParkingAutoResetSetting.getValue();
/*      */           arrayOfByte386 = this.data;
/*      */           pA_VINDiffMsg = new PATypes.PA_VINDiffMsg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte386));
/*      */           return pA_VINDiffMsg;
/*      */         case 33694:
/*      */           this.data = (byte[])pA_VINDiffMsg.getValue();
/*      */           arrayOfByte385 = this.data;
/*      */           pA_CollectionRadio = new PATypes.PA_CollectionRadio(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte385));
/*      */           return pA_CollectionRadio;
/*      */         case 33693:
/*      */           this.data = (byte[])pA_CollectionRadio.getValue();
/*      */           arrayOfByte384 = this.data;
/*      */           pA_SourceSwitch = new PATypes.PA_SourceSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte384));
/*      */           return pA_SourceSwitch;
/*      */         case 33692:
/*      */           this.data = (byte[])pA_SourceSwitch.getValue();
/*      */           arrayOfByte383 = this.data;
/*      */           pA_NaviHome = new PATypes.PA_NaviHome(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte383));
/*      */           return pA_NaviHome;
/*      */         case 33691:
/*      */           this.data = (byte[])pA_NaviHome.getValue();
/*      */           arrayOfByte382 = this.data;
/*      */           pA_360Panorama = new PATypes.PA_360Panorama(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte382));
/*      */           return pA_360Panorama;
/*      */         case 33690:
/*      */           this.data = (byte[])pA_360Panorama.getValue();
/*      */           arrayOfByte381 = this.data;
/*      */           pA_DVR = new PATypes.PA_DVR(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte381));
/*      */           return pA_DVR;
/*      */         case 33689:
/*      */           this.data = (byte[])pA_DVR.getValue();
/*      */           arrayOfByte380 = this.data;
/*      */           pA_ScreenSwitch = new PATypes.PA_ScreenSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte380));
/*      */           return pA_ScreenSwitch;
/*      */         case 33688:
/*      */           this.data = (byte[])pA_ScreenSwitch.getValue();
/*      */           arrayOfByte379 = this.data;
/*      */           pA_SelfDefineFuncReq = new PATypes.PA_SelfDefineFuncReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte379));
/*      */           return pA_SelfDefineFuncReq;
/*      */         case 33687:
/*      */           this.data = (byte[])pA_SelfDefineFuncReq.getValue();
/*      */           arrayOfByte378 = this.data;
/*      */           pA_TailgateSts = new PATypes.PA_TailgateSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte378));
/*      */           return pA_TailgateSts;
/*      */         case 33686:
/*      */           this.data = (byte[])pA_TailgateSts.getValue();
/*      */           arrayOfByte377 = this.data;
/*      */           pA_ElectricTailgate_PosSetting = new PATypes.PA_ElectricTailgate_PosSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte377));
/*      */           return pA_ElectricTailgate_PosSetting;
/*      */         case 33685:
/*      */           this.data = (byte[])pA_ElectricTailgate_PosSetting.getValue();
/*      */           arrayOfByte376 = this.data;
/*      */           pA_ElectricTailgate_OpenBtn = new PATypes.PA_ElectricTailgate_OpenBtn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte376));
/*      */           return pA_ElectricTailgate_OpenBtn;
/*      */         case 33684:
/*      */           this.data = (byte[])pA_ElectricTailgate_OpenBtn.getValue();
/*      */           arrayOfByte375 = this.data;
/*      */           pA_ElectricTailgate_Setting = new PATypes.PA_ElectricTailgate_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte375));
/*      */           return pA_ElectricTailgate_Setting;
/*      */         case 33683:
/*      */           this.data = (byte[])pA_ElectricTailgate_Setting.getValue();
/*      */           arrayOfByte374 = this.data;
/*      */           pA_ChangeFailMsg = new PATypes.PA_ChangeFailMsg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte374));
/*      */           return pA_ChangeFailMsg;
/*      */         case 33682:
/*      */           this.data = (byte[])pA_ChangeFailMsg.getValue();
/*      */           arrayOfByte373 = this.data;
/*      */           pA_Battery_Charge_Percent = new PATypes.PA_Battery_Charge_Percent(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte373));
/*      */           return pA_Battery_Charge_Percent;
/*      */         case 33681:
/*      */           this.data = (byte[])pA_Battery_Charge_Percent.getValue();
/*      */           arrayOfByte372 = this.data;
/*      */           pA_PM_Charge = new PATypes.PA_PM_Charge(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte372));
/*      */           return pA_PM_Charge;
/*      */         case 33680:
/*      */           this.data = (byte[])pA_PM_Charge.getValue();
/*      */           arrayOfByte371 = this.data;
/*      */           pA_PM_Hold = new PATypes.PA_PM_Hold(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte371));
/*      */           return pA_PM_Hold;
/*      */         case 33679:
/*      */           this.data = (byte[])pA_PM_Hold.getValue();
/*      */           arrayOfByte370 = this.data;
/*      */           pA_ElecSeatbelt_Passenger = new PATypes.PA_ElecSeatbelt_Passenger(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte370));
/*      */           return pA_ElecSeatbelt_Passenger;
/*      */         case 33678:
/*      */           this.data = (byte[])pA_ElecSeatbelt_Passenger.getValue();
/*      */           arrayOfByte369 = this.data;
/*      */           pA_ElecSeatbelt_Driver = new PATypes.PA_ElecSeatbelt_Driver(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte369));
/*      */           return pA_ElecSeatbelt_Driver;
/*      */         case 33677:
/*      */           this.data = (byte[])pA_ElecSeatbelt_Driver.getValue();
/*      */           arrayOfByte368 = this.data;
/*      */           pA_CSDTheme_Setting = new PATypes.PA_CSDTheme_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte368));
/*      */           return pA_CSDTheme_Setting;
/*      */         case 33676:
/*      */           this.data = (byte[])pA_CSDTheme_Setting.getValue();
/*      */           arrayOfByte367 = this.data;
/*      */           pA_DIMTheme_DrvSetting = new PATypes.PA_DIMTheme_DrvSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte367));
/*      */           return pA_DIMTheme_DrvSetting;
/*      */         case 33675:
/*      */           this.data = (byte[])pA_DIMTheme_DrvSetting.getValue();
/*      */           arrayOfByte366 = this.data;
/*      */           pA_Individualtheme_OnOff = new PATypes.PA_Individualtheme_OnOff(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte366));
/*      */           return pA_Individualtheme_OnOff;
/*      */         case 33674:
/*      */           this.data = (byte[])pA_Individualtheme_OnOff.getValue();
/*      */           arrayOfByte365 = this.data;
/*      */           pA_LockgFbSoundSet = new PATypes.PA_LockgFbSoundSet(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte365));
/*      */           return pA_LockgFbSoundSet;
/*      */         case 33673:
/*      */           this.data = (byte[])pA_LockgFbSoundSet.getValue();
/*      */           arrayOfByte364 = this.data;
/*      */           pA_TwoStepUnlck_Setting = new PATypes.PA_TwoStepUnlck_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte364));
/*      */           return pA_TwoStepUnlck_Setting;
/*      */         case 33672:
/*      */           this.data = (byte[])pA_TwoStepUnlck_Setting.getValue();
/*      */           arrayOfByte363 = this.data;
/*      */           pA_PasAcsLock_Setting = new PATypes.PA_PasAcsLock_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte363));
/*      */           return pA_PasAcsLock_Setting;
/*      */         case 33671:
/*      */           this.data = (byte[])pA_PasAcsLock_Setting.getValue();
/*      */           arrayOfByte362 = this.data;
/*      */           pA_UnLockSetting = new PATypes.PA_UnLockSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte362));
/*      */           return pA_UnLockSetting;
/*      */         case 33670:
/*      */           this.data = (byte[])pA_UnLockSetting.getValue();
/*      */           arrayOfByte361 = this.data;
/*      */           pA_PowerFlow_MHEV = new PATypes.PA_PowerFlow_MHEV(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte361));
/*      */           return pA_PowerFlow_MHEV;
/*      */         case 33669:
/*      */           this.data = (byte[])pA_PowerFlow_MHEV.getValue();
/*      */           arrayOfByte360 = this.data;
/*      */           pA_PowerFlow = new PATypes.PA_PowerFlow(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte360));
/*      */           return pA_PowerFlow;
/*      */         case 33668:
/*      */           this.data = (byte[])pA_PowerFlow.getValue();
/*      */           arrayOfByte359 = this.data;
/*      */           pA_SailingSwitch = new PATypes.PA_SailingSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte359));
/*      */           return pA_SailingSwitch;
/*      */         case 33667:
/*      */           this.data = (byte[])pA_SailingSwitch.getValue();
/*      */           arrayOfByte358 = this.data;
/*      */           pA_SpeedWarnSpeedLimit = new PATypes.PA_SpeedWarnSpeedLimit(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte358));
/*      */           return pA_SpeedWarnSpeedLimit;
/*      */         case 33666:
/*      */           this.data = (byte[])pA_SpeedWarnSpeedLimit.getValue();
/*      */           arrayOfByte357 = this.data;
/*      */           pA_SpeedWarnOnOff = new PATypes.PA_SpeedWarnOnOff(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte357));
/*      */           return pA_SpeedWarnOnOff;
/*      */         case 33665:
/*      */           this.data = (byte[])pA_SpeedWarnOnOff.getValue();
/*      */           arrayOfByte356 = this.data;
/*      */           pA_LowAlarmVolSet = new PATypes.PA_LowAlarmVolSet(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte356));
/*      */           return pA_LowAlarmVolSet;
/*      */         case 33664:
/*      */           this.data = (byte[])pA_LowAlarmVolSet.getValue();
/*      */           arrayOfByte355 = this.data;
/*      */           pA_SpeedWarnSet = new PATypes.PA_SpeedWarnSet(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte355));
/*      */           return pA_SpeedWarnSet;
/*      */         case 33663:
/*      */           this.data = (byte[])pA_SpeedWarnSet.getValue();
/*      */           arrayOfByte354 = this.data;
/*      */           pA_External_Sound_Setting = new PATypes.PA_External_Sound_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte354));
/*      */           return pA_External_Sound_Setting;
/*      */         case 33662:
/*      */           this.data = (byte[])pA_External_Sound_Setting.getValue();
/*      */           arrayOfByte353 = this.data;
/*      */           pA_Total_Traveled_Distance = new PATypes.PA_Total_Traveled_Distance(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte353));
/*      */           return pA_Total_Traveled_Distance;
/*      */         case 33661:
/*      */           this.data = (byte[])pA_Total_Traveled_Distance.getValue();
/*      */           arrayOfByte352 = this.data;
/*      */           pA_AutoHoldStatus = new PATypes.PA_AutoHoldStatus(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte352));
/*      */           return pA_AutoHoldStatus;
/*      */         case 33660:
/*      */           this.data = (byte[])pA_AutoHoldStatus.getValue();
/*      */           arrayOfByte351 = this.data;
/*      */           pA_EPBAutoApply = new PATypes.PA_EPBAutoApply(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte351));
/*      */           return pA_EPBAutoApply;
/*      */         case 33659:
/*      */           this.data = (byte[])pA_EPBAutoApply.getValue();
/*      */           arrayOfByte350 = this.data;
/*      */           pA_SuspMoveDirInform = new PATypes.PA_SuspMoveDirInform(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte350));
/*      */           return pA_SuspMoveDirInform;
/*      */         case 33658:
/*      */           this.data = (byte[])pA_SuspMoveDirInform.getValue();
/*      */           arrayOfByte349 = this.data;
/*      */           pA_SuspHeiSetting = new PATypes.PA_SuspHeiSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte349));
/*      */           return pA_SuspHeiSetting;
/*      */         case 33657:
/*      */           this.data = (byte[])pA_SuspHeiSetting.getValue();
/*      */           arrayOfByte348 = this.data;
/*      */           pA_DeacLevCtrSetting = new PATypes.PA_DeacLevCtrSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte348));
/*      */           return pA_DeacLevCtrSetting;
/*      */         case 33656:
/*      */           this.data = (byte[])pA_DeacLevCtrSetting.getValue();
/*      */           arrayOfByte347 = this.data;
/*      */           pA_EasyEntrySetting = new PATypes.PA_EasyEntrySetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte347));
/*      */           return pA_EasyEntrySetting;
/*      */         case 33655:
/*      */           this.data = (byte[])pA_EasyEntrySetting.getValue();
/*      */           arrayOfByte346 = this.data;
/*      */           pA_HillDescentSetting = new PATypes.PA_HillDescentSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte346));
/*      */           return pA_HillDescentSetting;
/*      */         case 33654:
/*      */           this.data = (byte[])pA_HillDescentSetting.getValue();
/*      */           arrayOfByte345 = this.data;
/*      */           pA_MirrTiltSetg = new PATypes.PA_MirrTiltSetg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte345));
/*      */           return pA_MirrTiltSetg;
/*      */         case 33653:
/*      */           this.data = (byte[])pA_MirrTiltSetg.getValue();
/*      */           arrayOfByte344 = this.data;
/*      */           pA_RearMirrorFold_Auto = new PATypes.PA_RearMirrorFold_Auto(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte344));
/*      */           return pA_RearMirrorFold_Auto;
/*      */         case 33652:
/*      */           this.data = (byte[])pA_RearMirrorFold_Auto.getValue();
/*      */           arrayOfByte343 = this.data;
/*      */           pA_WelGoodbyeLightMod = new PATypes.PA_WelGoodbyeLightMod(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte343));
/*      */           return pA_WelGoodbyeLightMod;
/*      */         case 33651:
/*      */           this.data = (byte[])pA_WelGoodbyeLightMod.getValue();
/*      */           arrayOfByte342 = this.data;
/*      */           pA_WelGoodbyeLightSwitch = new PATypes.PA_WelGoodbyeLightSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte342));
/*      */           return pA_WelGoodbyeLightSwitch;
/*      */         case 33650:
/*      */           this.data = (byte[])pA_WelGoodbyeLightSwitch.getValue();
/*      */           arrayOfByte341 = this.data;
/*      */           pA_LeftRightSetting = new PATypes.PA_LeftRightSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte341));
/*      */           return pA_LeftRightSetting;
/*      */         case 33649:
/*      */           this.data = (byte[])pA_LeftRightSetting.getValue();
/*      */           arrayOfByte340 = this.data;
/*      */           pA_BendingLight = new PATypes.PA_BendingLight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte340));
/*      */           return pA_BendingLight;
/*      */         case 33648:
/*      */           this.data = (byte[])pA_BendingLight.getValue();
/*      */           arrayOfByte339 = this.data;
/*      */           pA_ApproachLightOnOff_Setting = new PATypes.PA_ApproachLightOnOff_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte339));
/*      */           return pA_ApproachLightOnOff_Setting;
/*      */         case 33647:
/*      */           this.data = (byte[])pA_ApproachLightOnOff_Setting.getValue();
/*      */           arrayOfByte338 = this.data;
/*      */           pA_AL_HomeSafeLight = new PATypes.PA_AL_HomeSafeLight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte338));
/*      */           return pA_AL_HomeSafeLight;
/*      */         case 33646:
/*      */           this.data = (byte[])pA_AL_HomeSafeLight.getValue();
/*      */           arrayOfByte337 = this.data;
/*      */           pA_CornrgLi_Setting = new PATypes.PA_CornrgLi_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte337));
/*      */           return pA_CornrgLi_Setting;
/*      */         case 33645:
/*      */           this.data = (byte[])pA_CornrgLi_Setting.getValue();
/*      */           arrayOfByte336 = this.data;
/*      */           pA_AFSLight_Setting = new PATypes.PA_AFSLight_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte336));
/*      */           return pA_AFSLight_Setting;
/*      */         case 33644:
/*      */           this.data = (byte[])pA_AFSLight_Setting.getValue();
/*      */           arrayOfByte335 = this.data;
/*      */           pA_PBC_ESCSportActiv = new PATypes.PA_PBC_ESCSportActiv(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte335));
/*      */           return pA_PBC_ESCSportActiv;
/*      */         case 33643:
/*      */           this.data = (byte[])pA_PBC_ESCSportActiv.getValue();
/*      */           arrayOfByte334 = this.data;
/*      */           pA_SS_Activation = new PATypes.PA_SS_Activation(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte334));
/*      */           return pA_SS_Activation;
/*      */         case 33642:
/*      */           this.data = (byte[])pA_SS_Activation.getValue();
/*      */           arrayOfByte333 = this.data;
/*      */           pA_SteeringWheelPosAdj = new PATypes.PA_SteeringWheelPosAdj(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte333));
/*      */           return pA_SteeringWheelPosAdj;
/*      */         case 33641:
/*      */           this.data = (byte[])pA_SteeringWheelPosAdj.getValue();
/*      */           arrayOfByte332 = this.data;
/*      */           pA_Steer_SteeringMod = new PATypes.PA_Steer_SteeringMod(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte332));
/*      */           return pA_Steer_SteeringMod;
/*      */         case 33640:
/*      */           this.data = (byte[])pA_Steer_SteeringMod.getValue();
/*      */           arrayOfByte331 = this.data;
/*      */           pA_Steer_SteerAsscLvl = new PATypes.PA_Steer_SteerAsscLvl(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte331));
/*      */           return pA_Steer_SteerAsscLvl;
/*      */         case 33639:
/*      */           this.data = (byte[])pA_Steer_SteerAsscLvl.getValue();
/*      */           arrayOfByte330 = this.data;
/*      */           pA_FindCaReminder_Setting = new PATypes.PA_FindCaReminder_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte330));
/*      */           return pA_FindCaReminder_Setting;
/*      */         case 33638:
/*      */           this.data = (byte[])pA_FindCaReminder_Setting.getValue();
/*      */           arrayOfByte329 = this.data;
/*      */           pA_UUN_RedGuardSts = new PATypes.PA_UUN_RedGuardSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte329));
/*      */           return pA_UUN_RedGuardSts;
/*      */         case 33637:
/*      */           this.data = (byte[])pA_UUN_RedGuardSts.getValue();
/*      */           arrayOfByte328 = this.data;
/*      */           pA_UUN_PasArmngSts = new PATypes.PA_UUN_PasArmngSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte328));
/*      */           return pA_UUN_PasArmngSts;
/*      */         case 33636:
/*      */           this.data = (byte[])pA_UUN_PasArmngSts.getValue();
/*      */           arrayOfByte327 = this.data;
/*      */           pA_WPC_PhoneForget = new PATypes.PA_WPC_PhoneForget(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte327));
/*      */           return pA_WPC_PhoneForget;
/*      */         case 33635:
/*      */           this.data = (byte[])pA_WPC_PhoneForget.getValue();
/*      */           arrayOfByte326 = this.data;
/*      */           pA_WPC_InchargeStatus = new PATypes.PA_WPC_InchargeStatus(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte326));
/*      */           return pA_WPC_InchargeStatus;
/*      */         case 33634:
/*      */           this.data = (byte[])pA_WPC_InchargeStatus.getValue();
/*      */           arrayOfByte325 = this.data;
/*      */           pA_WPC_Setting = new PATypes.PA_WPC_Setting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte325));
/*      */           return pA_WPC_Setting;
/*      */         case 33633:
/*      */           this.data = (byte[])pA_WPC_Setting.getValue();
/*      */           arrayOfByte324 = this.data;
/*      */           pA_PassSeatSwtSelnOfSpplFctSts = new PATypes.PA_PassSeatSwtSelnOfSpplFctSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte324));
/*      */           return pA_PassSeatSwtSelnOfSpplFctSts;
/*      */         case 33632:
/*      */           this.data = (byte[])pA_PassSeatSwtSelnOfSpplFctSts.getValue();
/*      */           arrayOfByte323 = this.data;
/*      */           pA_DrvrSeatSwtSelnOfSpplFctSts = new PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte323));
/*      */           return pA_DrvrSeatSwtSelnOfSpplFctSts;
/*      */         case 33631:
/*      */           this.data = (byte[])pA_DrvrSeatSwtSelnOfSpplFctSts.getValue();
/*      */           arrayOfByte322 = this.data;
/*      */           pA_HotStoneMassagePassAllowd = new PATypes.PA_HotStoneMassagePassAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte322));
/*      */           return pA_HotStoneMassagePassAllowd;
/*      */         case 33630:
/*      */           this.data = (byte[])pA_HotStoneMassagePassAllowd.getValue();
/*      */           arrayOfByte321 = this.data;
/*      */           pA_HotStoneMassageDrvrAllowd = new PATypes.PA_HotStoneMassageDrvrAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte321));
/*      */           return pA_HotStoneMassageDrvrAllowd;
/*      */         case 33629:
/*      */           this.data = (byte[])pA_HotStoneMassageDrvrAllowd.getValue();
/*      */           arrayOfByte320 = this.data;
/*      */           pA_SeatRowSecRiSwtStsPassSeatSwtInclSts = new PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte320));
/*      */           return pA_SeatRowSecRiSwtStsPassSeatSwtInclSts;
/*      */         case 33628:
/*      */           this.data = (byte[])pA_SeatRowSecRiSwtStsPassSeatSwtInclSts.getValue();
/*      */           arrayOfByte319 = this.data;
/*      */           pA_SeatRowSecLeSwtStsPassSeatSwtInclSts = new PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte319));
/*      */           return pA_SeatRowSecLeSwtStsPassSeatSwtInclSts;
/*      */         case 33627:
/*      */           this.data = (byte[])pA_SeatRowSecLeSwtStsPassSeatSwtInclSts.getValue();
/*      */           arrayOfByte318 = this.data;
/*      */           pA_SecRowSeatInclRiFwdBackwAllowd = new PATypes.PA_SecRowSeatInclRiFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte318));
/*      */           return pA_SecRowSeatInclRiFwdBackwAllowd;
/*      */         case 33626:
/*      */           this.data = (byte[])pA_SecRowSeatInclRiFwdBackwAllowd.getValue();
/*      */           arrayOfByte317 = this.data;
/*      */           pA_SecRowSeatInclLeFwdBackwAllowd = new PATypes.PA_SecRowSeatInclLeFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte317));
/*      */           return pA_SecRowSeatInclLeFwdBackwAllowd;
/*      */         case 33625:
/*      */           this.data = (byte[])pA_SecRowSeatInclLeFwdBackwAllowd.getValue();
/*      */           arrayOfByte316 = this.data;
/*      */           pA_SeatRowSecRiSwtStsPassSeatSwtSldSts = new PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte316));
/*      */           return pA_SeatRowSecRiSwtStsPassSeatSwtSldSts;
/*      */         case 33624:
/*      */           this.data = (byte[])pA_SeatRowSecRiSwtStsPassSeatSwtSldSts.getValue();
/*      */           arrayOfByte315 = this.data;
/*      */           pA_SecRowSeatLenRiFwdBackwAllowd = new PATypes.PA_SecRowSeatLenRiFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte315));
/*      */           return pA_SecRowSeatLenRiFwdBackwAllowd;
/*      */         case 33623:
/*      */           this.data = (byte[])pA_SecRowSeatLenRiFwdBackwAllowd.getValue();
/*      */           arrayOfByte314 = this.data;
/*      */           pA_SeatRowSecLeSwtStsPassSeatSwtSldSts = new PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte314));
/*      */           return pA_SeatRowSecLeSwtStsPassSeatSwtSldSts;
/*      */         case 33622:
/*      */           this.data = (byte[])pA_SeatRowSecLeSwtStsPassSeatSwtSldSts.getValue();
/*      */           arrayOfByte313 = this.data;
/*      */           pA_SecRowSeatLenLeFwdBackwAllowd = new PATypes.PA_SecRowSeatLenLeFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte313));
/*      */           return pA_SecRowSeatLenLeFwdBackwAllowd;
/*      */         case 33621:
/*      */           this.data = (byte[])pA_SecRowSeatLenLeFwdBackwAllowd.getValue();
/*      */           arrayOfByte312 = this.data;
/*      */           pA_SeatFoldRaiseRowThrdRiAllowd = new PATypes.PA_SeatFoldRaiseRowThrdRiAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte312));
/*      */           return pA_SeatFoldRaiseRowThrdRiAllowd;
/*      */         case 33620:
/*      */           this.data = (byte[])pA_SeatFoldRaiseRowThrdRiAllowd.getValue();
/*      */           arrayOfByte311 = this.data;
/*      */           pA_SeatFoldRaiseRowThrdLeAllowd = new PATypes.PA_SeatFoldRaiseRowThrdLeAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte311));
/*      */           return pA_SeatFoldRaiseRowThrdLeAllowd;
/*      */         case 33619:
/*      */           this.data = (byte[])pA_SeatFoldRaiseRowThrdLeAllowd.getValue();
/*      */           arrayOfByte310 = this.data;
/*      */           pA_PassMultFuncMenuExt = new PATypes.PA_PassMultFuncMenuExt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte310));
/*      */           return pA_PassMultFuncMenuExt;
/*      */         case 33618:
/*      */           this.data = (byte[])pA_PassMultFuncMenuExt.getValue();
/*      */           arrayOfByte309 = this.data;
/*      */           pA_DrvrMultFuncMenuExt = new PATypes.PA_DrvrMultFuncMenuExt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte309));
/*      */           return pA_DrvrMultFuncMenuExt;
/*      */         case 33617:
/*      */           this.data = (byte[])pA_DrvrMultFuncMenuExt.getValue();
/*      */           arrayOfByte308 = this.data;
/*      */           pA_PassMassgRunng = new PATypes.PA_PassMassgRunng(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte308));
/*      */           return pA_PassMassgRunng;
/*      */         case 33616:
/*      */           this.data = (byte[])pA_PassMassgRunng.getValue();
/*      */           arrayOfByte307 = this.data;
/*      */           pA_DrvrMassgRunng = new PATypes.PA_DrvrMassgRunng(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte307));
/*      */           return pA_DrvrMassgRunng;
/*      */         case 33615:
/*      */           this.data = (byte[])pA_DrvrMassgRunng.getValue();
/*      */           arrayOfByte306 = this.data;
/*      */           pA_PassSeatDispMassgFct_MassgInten = new PATypes.PA_PassSeatDispMassgFct_MassgInten(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte306));
/*      */           return pA_PassSeatDispMassgFct_MassgInten;
/*      */         case 33614:
/*      */           this.data = (byte[])pA_PassSeatDispMassgFct_MassgInten.getValue();
/*      */           arrayOfByte305 = this.data;
/*      */           pA_PassSeatDispMassgFct_MassgProg = new PATypes.PA_PassSeatDispMassgFct_MassgProg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte305));
/*      */           return pA_PassSeatDispMassgFct_MassgProg;
/*      */         case 33613:
/*      */           this.data = (byte[])pA_PassSeatDispMassgFct_MassgProg.getValue();
/*      */           arrayOfByte304 = this.data;
/*      */           pA_PassSeatDispMassgFct_OnOff = new PATypes.PA_PassSeatDispMassgFct_OnOff(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte304));
/*      */           return pA_PassSeatDispMassgFct_OnOff;
/*      */         case 33612:
/*      */           this.data = (byte[])pA_PassSeatDispMassgFct_OnOff.getValue();
/*      */           arrayOfByte303 = this.data;
/*      */           pA_PassSeatMassageStsAllowd = new PATypes.PA_PassSeatMassageStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte303));
/*      */           return pA_PassSeatMassageStsAllowd;
/*      */         case 33611:
/*      */           this.data = (byte[])pA_PassSeatMassageStsAllowd.getValue();
/*      */           arrayOfByte302 = this.data;
/*      */           pA_DrvrSeatDispMassgFct_MassgInten = new PATypes.PA_DrvrSeatDispMassgFct_MassgInten(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte302));
/*      */           return pA_DrvrSeatDispMassgFct_MassgInten;
/*      */         case 33610:
/*      */           this.data = (byte[])pA_DrvrSeatDispMassgFct_MassgInten.getValue();
/*      */           arrayOfByte301 = this.data;
/*      */           pA_DrvrSeatDispMassgFct_MassgProg = new PATypes.PA_DrvrSeatDispMassgFct_MassgProg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte301));
/*      */           return pA_DrvrSeatDispMassgFct_MassgProg;
/*      */         case 33609:
/*      */           this.data = (byte[])pA_DrvrSeatDispMassgFct_MassgProg.getValue();
/*      */           arrayOfByte300 = this.data;
/*      */           pA_DrvrSeatDispMassgFct_OnOff = new PATypes.PA_DrvrSeatDispMassgFct_OnOff(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte300));
/*      */           return pA_DrvrSeatDispMassgFct_OnOff;
/*      */         case 33608:
/*      */           this.data = (byte[])pA_DrvrSeatDispMassgFct_OnOff.getValue();
/*      */           arrayOfByte299 = this.data;
/*      */           pA_DrvrSeatMassageStsAllowd = new PATypes.PA_DrvrSeatMassageStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte299));
/*      */           return pA_DrvrSeatMassageStsAllowd;
/*      */         case 33607:
/*      */           this.data = (byte[])pA_DrvrSeatMassageStsAllowd.getValue();
/*      */           arrayOfByte298 = this.data;
/*      */           pA_PassSeatCushExtStsAllowd = new PATypes.PA_PassSeatCushExtStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte298));
/*      */           return pA_PassSeatCushExtStsAllowd;
/*      */         case 33606:
/*      */           this.data = (byte[])pA_PassSeatCushExtStsAllowd.getValue();
/*      */           arrayOfByte297 = this.data;
/*      */           pA_DrvrSeatCushExtStsAllowd = new PATypes.PA_DrvrSeatCushExtStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte297));
/*      */           return pA_DrvrSeatCushExtStsAllowd;
/*      */         case 33605:
/*      */           this.data = (byte[])pA_DrvrSeatCushExtStsAllowd.getValue();
/*      */           arrayOfByte296 = this.data;
/*      */           pA_PassSeatSideUpDownStsAllowd = new PATypes.PA_PassSeatSideUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte296));
/*      */           return pA_PassSeatSideUpDownStsAllowd;
/*      */         case 33604:
/*      */           this.data = (byte[])pA_PassSeatSideUpDownStsAllowd.getValue();
/*      */           arrayOfByte295 = this.data;
/*      */           pA_DrvrSeatSideUpDownStsAllowd = new PATypes.PA_DrvrSeatSideUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte295));
/*      */           return pA_DrvrSeatSideUpDownStsAllowd;
/*      */         case 33603:
/*      */           this.data = (byte[])pA_DrvrSeatSideUpDownStsAllowd.getValue();
/*      */           arrayOfByte294 = this.data;
/*      */           pA_PassSeatSideFwdBackwStsAllowd = new PATypes.PA_PassSeatSideFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte294));
/*      */           return pA_PassSeatSideFwdBackwStsAllowd;
/*      */         case 33602:
/*      */           this.data = (byte[])pA_PassSeatSideFwdBackwStsAllowd.getValue();
/*      */           arrayOfByte293 = this.data;
/*      */           pA_DrvrSeatSideFwdBackwStsAllowd = new PATypes.PA_DrvrSeatSideFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte293));
/*      */           return pA_DrvrSeatSideFwdBackwStsAllowd;
/*      */         case 33601:
/*      */           this.data = (byte[])pA_DrvrSeatSideFwdBackwStsAllowd.getValue();
/*      */           arrayOfByte292 = this.data;
/*      */           pA_PassSeatLmbrUpDownStsAllowd = new PATypes.PA_PassSeatLmbrUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte292));
/*      */           return pA_PassSeatLmbrUpDownStsAllowd;
/*      */         case 33600:
/*      */           this.data = (byte[])pA_PassSeatLmbrUpDownStsAllowd.getValue();
/*      */           arrayOfByte291 = this.data;
/*      */           pA_PassSeatLmbrFwdBackwStsAllowd = new PATypes.PA_PassSeatLmbrFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte291));
/*      */           return pA_PassSeatLmbrFwdBackwStsAllowd;
/*      */         case 33599:
/*      */           this.data = (byte[])pA_PassSeatLmbrFwdBackwStsAllowd.getValue();
/*      */           arrayOfByte290 = this.data;
/*      */           pA_DrvrSeatLmbrUpDownStsAllowd = new PATypes.PA_DrvrSeatLmbrUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte290));
/*      */           return pA_DrvrSeatLmbrUpDownStsAllowd;
/*      */         case 33598:
/*      */           this.data = (byte[])pA_DrvrSeatLmbrUpDownStsAllowd.getValue();
/*      */           arrayOfByte289 = this.data;
/*      */           pA_DrvrSeatLmbrFwdBackwStsAllowd = new PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte289));
/*      */           return pA_DrvrSeatLmbrFwdBackwStsAllowd;
/*      */         case 33597:
/*      */           this.data = (byte[])pA_DrvrSeatLmbrFwdBackwStsAllowd.getValue();
/*      */           arrayOfByte288 = this.data;
/*      */           pA_PassSeatSwtAdjmtOfSpplFctHozlSts = new PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte288));
/*      */           return pA_PassSeatSwtAdjmtOfSpplFctHozlSts;
/*      */         case 33596:
/*      */           this.data = (byte[])pA_PassSeatSwtAdjmtOfSpplFctHozlSts.getValue();
/*      */           arrayOfByte287 = this.data;
/*      */           pA_PassSeatSwtAdjmtOfSpplFctVertSts = new PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte287));
/*      */           return pA_PassSeatSwtAdjmtOfSpplFctVertSts;
/*      */         case 33595:
/*      */           this.data = (byte[])pA_PassSeatSwtAdjmtOfSpplFctVertSts.getValue();
/*      */           arrayOfByte286 = this.data;
/*      */           pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts = new PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte286));
/*      */           return pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts;
/*      */         case 33594:
/*      */           this.data = (byte[])pA_DrvrSeatSwtAdjmtOfSpplFctHozlSts.getValue();
/*      */           arrayOfByte285 = this.data;
/*      */           pA_DrvrSeatSwtAdjmtOfSpplFctVertSts = new PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte285));
/*      */           return pA_DrvrSeatSwtAdjmtOfSpplFctVertSts;
/*      */         case 33593:
/*      */           this.data = (byte[])pA_DrvrSeatSwtAdjmtOfSpplFctVertSts.getValue();
/*      */           arrayOfByte284 = this.data;
/*      */           pA_PassSeatActvSpplFct = new PATypes.PA_PassSeatActvSpplFct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte284));
/*      */           return pA_PassSeatActvSpplFct;
/*      */         case 33592:
/*      */           this.data = (byte[])pA_PassSeatActvSpplFct.getValue();
/*      */           arrayOfByte283 = this.data;
/*      */           pA_DrvrSeatActvSpplFct = new PATypes.PA_DrvrSeatActvSpplFct(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte283));
/*      */           return pA_DrvrSeatActvSpplFct;
/*      */         case 33591:
/*      */           this.data = (byte[])pA_DrvrSeatActvSpplFct.getValue();
/*      */           arrayOfByte282 = this.data;
/*      */           pA_EasyInOutDrvrSeatAdjmt = new PATypes.PA_EasyInOutDrvrSeatAdjmt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte282));
/*      */           return pA_EasyInOutDrvrSeatAdjmt;
/*      */         case 33590:
/*      */           this.data = (byte[])pA_EasyInOutDrvrSeatAdjmt.getValue();
/*      */           arrayOfByte281 = this.data;
/*      */           pA_EasyInOutDrvrSeatAllowd = new PATypes.PA_EasyInOutDrvrSeatAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte281));
/*      */           return pA_EasyInOutDrvrSeatAllowd;
/*      */         case 33589:
/*      */           this.data = (byte[])pA_EasyInOutDrvrSeatAllowd.getValue();
/*      */           arrayOfByte280 = this.data;
/*      */           pA_PassSeatSwtInclSts = new PATypes.PA_PassSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte280));
/*      */           return pA_PassSeatSwtInclSts;
/*      */         case 33588:
/*      */           this.data = (byte[])pA_PassSeatSwtInclSts.getValue();
/*      */           arrayOfByte279 = this.data;
/*      */           pA_PassSeatSwtInclStsAllowd = new PATypes.PA_PassSeatSwtInclStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte279));
/*      */           return pA_PassSeatSwtInclStsAllowd;
/*      */         case 33587:
/*      */           this.data = (byte[])pA_PassSeatSwtInclStsAllowd.getValue();
/*      */           arrayOfByte278 = this.data;
/*      */           pA_DrvrSeatSwtInclSts = new PATypes.PA_DrvrSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte278));
/*      */           return pA_DrvrSeatSwtInclSts;
/*      */         case 33586:
/*      */           this.data = (byte[])pA_DrvrSeatSwtInclSts.getValue();
/*      */           arrayOfByte277 = this.data;
/*      */           pA_DrvrSeatSwtInclStsAllowd = new PATypes.PA_DrvrSeatSwtInclStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte277));
/*      */           return pA_DrvrSeatSwtInclStsAllowd;
/*      */         case 33585:
/*      */           this.data = (byte[])pA_DrvrSeatSwtInclStsAllowd.getValue();
/*      */           arrayOfByte276 = this.data;
/*      */           pA_PassSeatSwtHeiFrntSts = new PATypes.PA_PassSeatSwtHeiFrntSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte276));
/*      */           return pA_PassSeatSwtHeiFrntSts;
/*      */         case 33584:
/*      */           this.data = (byte[])pA_PassSeatSwtHeiFrntSts.getValue();
/*      */           arrayOfByte275 = this.data;
/*      */           pA_PassSeatSwtHeiFrntStsAllowd = new PATypes.PA_PassSeatSwtHeiFrntStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte275));
/*      */           return pA_PassSeatSwtHeiFrntStsAllowd;
/*      */         case 33583:
/*      */           this.data = (byte[])pA_PassSeatSwtHeiFrntStsAllowd.getValue();
/*      */           arrayOfByte274 = this.data;
/*      */           pA_DrvrSeatSwtHeiFrntSts = new PATypes.PA_DrvrSeatSwtHeiFrntSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte274));
/*      */           return pA_DrvrSeatSwtHeiFrntSts;
/*      */         case 33582:
/*      */           this.data = (byte[])pA_DrvrSeatSwtHeiFrntSts.getValue();
/*      */           arrayOfByte273 = this.data;
/*      */           pA_DrvrSeatSwtHeiFrntStsAllowd = new PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte273));
/*      */           return pA_DrvrSeatSwtHeiFrntStsAllowd;
/*      */         case 33581:
/*      */           this.data = (byte[])pA_DrvrSeatSwtHeiFrntStsAllowd.getValue();
/*      */           arrayOfByte272 = this.data;
/*      */           pA_PassSeatSwtHeiSts = new PATypes.PA_PassSeatSwtHeiSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte272));
/*      */           return pA_PassSeatSwtHeiSts;
/*      */         case 33580:
/*      */           this.data = (byte[])pA_PassSeatSwtHeiSts.getValue();
/*      */           arrayOfByte271 = this.data;
/*      */           pA_PassSeatSwtHeiStsAllowd = new PATypes.PA_PassSeatSwtHeiStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte271));
/*      */           return pA_PassSeatSwtHeiStsAllowd;
/*      */         case 33579:
/*      */           this.data = (byte[])pA_PassSeatSwtHeiStsAllowd.getValue();
/*      */           arrayOfByte270 = this.data;
/*      */           pA_DrvrSeatSwtHeiSts = new PATypes.PA_DrvrSeatSwtHeiSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte270));
/*      */           return pA_DrvrSeatSwtHeiSts;
/*      */         case 33578:
/*      */           this.data = (byte[])pA_DrvrSeatSwtHeiSts.getValue();
/*      */           arrayOfByte269 = this.data;
/*      */           pA_DrvrSeatSwtHeiStsAllowd = new PATypes.PA_DrvrSeatSwtHeiStsAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte269));
/*      */           return pA_DrvrSeatSwtHeiStsAllowd;
/*      */         case 33577:
/*      */           this.data = (byte[])pA_DrvrSeatSwtHeiStsAllowd.getValue();
/*      */           arrayOfByte268 = this.data;
/*      */           pA_PassSeatSwtSldSts = new PATypes.PA_PassSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte268));
/*      */           return pA_PassSeatSwtSldSts;
/*      */         case 33576:
/*      */           this.data = (byte[])pA_PassSeatSwtSldSts.getValue();
/*      */           arrayOfByte267 = this.data;
/*      */           pA_PassSeatExtAdjAllowd = new PATypes.PA_PassSeatExtAdjAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte267));
/*      */           return pA_PassSeatExtAdjAllowd;
/*      */         case 33575:
/*      */           this.data = (byte[])pA_PassSeatExtAdjAllowd.getValue();
/*      */           arrayOfByte266 = this.data;
/*      */           pA_DrvrSeatSwtSldSts = new PATypes.PA_DrvrSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte266));
/*      */           return pA_DrvrSeatSwtSldSts;
/*      */         case 33574:
/*      */           this.data = (byte[])pA_DrvrSeatSwtSldSts.getValue();
/*      */           arrayOfByte265 = this.data;
/*      */           pA_DrvrSeatExtAdjAllowd = new PATypes.PA_DrvrSeatExtAdjAllowd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte265));
/*      */           return pA_DrvrSeatExtAdjAllowd;
/*      */         case 33573:
/*      */           this.data = (byte[])pA_DrvrSeatExtAdjAllowd.getValue();
/*      */           arrayOfByte264 = this.data;
/*      */           pA_PAS_SnsrFltStsWarn = new PATypes.PA_PAS_SnsrFltStsWarn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte264));
/*      */           return pA_PAS_SnsrFltStsWarn;
/*      */         case 33572:
/*      */           this.data = (byte[])pA_PAS_SnsrFltStsWarn.getValue();
/*      */           arrayOfByte263 = this.data;
/*      */           pA_PEB_PrkgEmgyBrkSysSts = new PATypes.PA_PEB_PrkgEmgyBrkSysSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte263));
/*      */           return pA_PEB_PrkgEmgyBrkSysSts;
/*      */         case 33571:
/*      */           this.data = (byte[])pA_PEB_PrkgEmgyBrkSysSts.getValue();
/*      */           arrayOfByte262 = this.data;
/*      */           pA_PEB_PrkgEmgBrkSysSwt = new PATypes.PA_PEB_PrkgEmgBrkSysSwt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte262));
/*      */           return pA_PEB_PrkgEmgBrkSysSwt;
/*      */         case 33570:
/*      */           this.data = (byte[])pA_PEB_PrkgEmgBrkSysSwt.getValue();
/*      */           arrayOfByte261 = this.data;
/*      */           pA_PAS_AudWarnOfSnsrParkAssiFrnt = new PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte261));
/*      */           return pA_PAS_AudWarnOfSnsrParkAssiFrnt;
/*      */         case 33569:
/*      */           this.data = (byte[])pA_PAS_AudWarnOfSnsrParkAssiFrnt.getValue();
/*      */           arrayOfByte260 = this.data;
/*      */           pA_PAS_AudWarnOfSnsrParkAssiRe = new PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte260));
/*      */           return pA_PAS_AudWarnOfSnsrParkAssiRe;
/*      */         case 33568:
/*      */           this.data = (byte[])pA_PAS_AudWarnOfSnsrParkAssiRe.getValue();
/*      */           arrayOfByte259 = this.data;
/*      */           pA_PAS_OutdRiOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte259));
/*      */           return pA_PAS_OutdRiOfSnsrPrkgAssiFrnt;
/*      */         case 33567:
/*      */           this.data = (byte[])pA_PAS_OutdRiOfSnsrPrkgAssiFrnt.getValue();
/*      */           arrayOfByte258 = this.data;
/*      */           pA_PAS_OutdLeOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte258));
/*      */           return pA_PAS_OutdLeOfSnsrPrkgAssiFrnt;
/*      */         case 33566:
/*      */           this.data = (byte[])pA_PAS_OutdLeOfSnsrPrkgAssiFrnt.getValue();
/*      */           arrayOfByte257 = this.data;
/*      */           pA_PAS_InsdRiOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte257));
/*      */           return pA_PAS_InsdRiOfSnsrPrkgAssiFrnt;
/*      */         case 33565:
/*      */           this.data = (byte[])pA_PAS_InsdRiOfSnsrPrkgAssiFrnt.getValue();
/*      */           arrayOfByte256 = this.data;
/*      */           pA_PAS_InsdLeOfSnsrPrkgAssiFrnt = new PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte256));
/*      */           return pA_PAS_InsdLeOfSnsrPrkgAssiFrnt;
/*      */         case 33564:
/*      */           this.data = (byte[])pA_PAS_InsdLeOfSnsrPrkgAssiFrnt.getValue();
/*      */           arrayOfByte255 = this.data;
/*      */           pA_PAS_OutdRiOfSnsrPrkgAssiRe = new PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte255));
/*      */           return pA_PAS_OutdRiOfSnsrPrkgAssiRe;
/*      */         case 33563:
/*      */           this.data = (byte[])pA_PAS_OutdRiOfSnsrPrkgAssiRe.getValue();
/*      */           arrayOfByte254 = this.data;
/*      */           pA_PAS_OutdLeOfSnsrPrkgAssiRe = new PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte254));
/*      */           return pA_PAS_OutdLeOfSnsrPrkgAssiRe;
/*      */         case 33562:
/*      */           this.data = (byte[])pA_PAS_OutdLeOfSnsrPrkgAssiRe.getValue();
/*      */           arrayOfByte253 = this.data;
/*      */           pA_PAS_InsdRiOfSnsrPrkgAssiRe = new PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte253));
/*      */           return pA_PAS_InsdRiOfSnsrPrkgAssiRe;
/*      */         case 33561:
/*      */           this.data = (byte[])pA_PAS_InsdRiOfSnsrPrkgAssiRe.getValue();
/*      */           arrayOfByte252 = this.data;
/*      */           pA_PAS_InsdLeOfSnsrPrkgAssiRe = new PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte252));
/*      */           return pA_PAS_InsdLeOfSnsrPrkgAssiRe;
/*      */         case 33560:
/*      */           this.data = (byte[])pA_PAS_InsdLeOfSnsrPrkgAssiRe.getValue();
/*      */           arrayOfByte251 = this.data;
/*      */           pA_PAS_PrkgDstCtrlSts = new PATypes.PA_PAS_PrkgDstCtrlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte251));
/*      */           return pA_PAS_PrkgDstCtrlSts;
/*      */         case 33559:
/*      */           this.data = (byte[])pA_PAS_PrkgDstCtrlSts.getValue();
/*      */           arrayOfByte250 = this.data;
/*      */           pA_PAS_PrkgDstCtrlSysSwt = new PATypes.PA_PAS_PrkgDstCtrlSysSwt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte250));
/*      */           return pA_PAS_PrkgDstCtrlSysSwt;
/*      */         case 33558:
/*      */           this.data = (byte[])pA_PAS_PrkgDstCtrlSysSwt.getValue();
/*      */           arrayOfByte249 = this.data;
/*      */           pA_SAP_TouchUnlckTyp = new PATypes.PA_SAP_TouchUnlckTyp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte249));
/*      */           return pA_SAP_TouchUnlckTyp;
/*      */         case 33557:
/*      */           this.data = (byte[])pA_SAP_TouchUnlckTyp.getValue();
/*      */           arrayOfByte248 = this.data;
/*      */           pA_SAP_PrkgProgsDisp = new PATypes.PA_SAP_PrkgProgsDisp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte248));
/*      */           return pA_SAP_PrkgProgsDisp;
/*      */         case 33556:
/*      */           this.data = (byte[])pA_SAP_PrkgProgsDisp.getValue();
/*      */           arrayOfByte247 = this.data;
/*      */           pA_SAP_DrvrAsscSysDisp = new PATypes.PA_SAP_DrvrAsscSysDisp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte247));
/*      */           return pA_SAP_DrvrAsscSysDisp;
/*      */         case 33555:
/*      */           this.data = (byte[])pA_SAP_DrvrAsscSysDisp.getValue();
/*      */           arrayOfByte246 = this.data;
/*      */           pA_SAP_DrvrAsscSysSts = new PATypes.PA_SAP_DrvrAsscSysSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte246));
/*      */           return pA_SAP_DrvrAsscSysSts;
/*      */         case 33554:
/*      */           this.data = (byte[])pA_SAP_DrvrAsscSysSts.getValue();
/*      */           arrayOfByte245 = this.data;
/*      */           pA_SAP_PrkgFctDiDisp = new PATypes.PA_SAP_PrkgFctDiDisp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte245));
/*      */           return pA_SAP_PrkgFctDiDisp;
/*      */         case 33553:
/*      */           this.data = (byte[])pA_SAP_PrkgFctDiDisp.getValue();
/*      */           arrayOfByte244 = this.data;
/*      */           pA_SAP_DrvrAsscSysBtnPush = new PATypes.PA_SAP_DrvrAsscSysBtnPush(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte244));
/*      */           return pA_SAP_DrvrAsscSysBtnPush;
/*      */         case 33552:
/*      */           this.data = (byte[])pA_SAP_DrvrAsscSysBtnPush.getValue();
/*      */           arrayOfByte243 = this.data;
/*      */           pA_PAC_RctaIndcnRe = new PATypes.PA_PAC_RctaIndcnRe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte243));
/*      */           return pA_PAC_RctaIndcnRe;
/*      */         case 33551:
/*      */           this.data = (byte[])pA_PAC_RctaIndcnRe.getValue();
/*      */           arrayOfByte242 = this.data;
/*      */           pA_PAC_RctaIndcnLe = new PATypes.PA_PAC_RctaIndcnLe(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte242));
/*      */           return pA_PAC_RctaIndcnLe;
/*      */         case 33550:
/*      */           this.data = (byte[])pA_PAC_RctaIndcnLe.getValue();
/*      */           arrayOfByte241 = this.data;
/*      */           pA_PAC_ImgSnsrClrReq = new PATypes.PA_PAC_ImgSnsrClrReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte241));
/*      */           return pA_PAC_ImgSnsrClrReq;
/*      */         case 33549:
/*      */           this.data = (byte[])pA_PAC_ImgSnsrClrReq.getValue();
/*      */           arrayOfByte240 = this.data;
/*      */           pA_PAC_PlaModStsResp = new PATypes.PA_PAC_PlaModStsResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte240));
/*      */           return pA_PAC_PlaModStsResp;
/*      */         case 33548:
/*      */           this.data = (byte[])pA_PAC_PlaModStsResp.getValue();
/*      */           arrayOfByte239 = this.data;
/*      */           pA_PAC_RoadCalForVisnAgWideResp = new PATypes.PA_PAC_RoadCalForVisnAgWideResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte239));
/*      */           return pA_PAC_RoadCalForVisnAgWideResp;
/*      */         case 33547:
/*      */           this.data = (byte[])pA_PAC_RoadCalForVisnAgWideResp.getValue();
/*      */           arrayOfByte238 = this.data;
/*      */           pA_PAC_VehMdlClrResp = new PATypes.PA_PAC_VehMdlClrResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte238));
/*      */           return pA_PAC_VehMdlClrResp;
/*      */         case 33546:
/*      */           this.data = (byte[])pA_PAC_VehMdlClrResp.getValue();
/*      */           arrayOfByte237 = this.data;
/*      */           pA_PAC_TurnEntryAgWideVisResp = new PATypes.PA_PAC_TurnEntryAgWideVisResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte237));
/*      */           return pA_PAC_TurnEntryAgWideVisResp;
/*      */         case 33545:
/*      */           this.data = (byte[])pA_PAC_TurnEntryAgWideVisResp.getValue();
/*      */           arrayOfByte236 = this.data;
/*      */           pA_PAC_ThrDTouringViewResp = new PATypes.PA_PAC_ThrDTouringViewResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte236));
/*      */           return pA_PAC_ThrDTouringViewResp;
/*      */         case 33544:
/*      */           this.data = (byte[])pA_PAC_ThrDTouringViewResp.getValue();
/*      */           arrayOfByte235 = this.data;
/*      */           pA_PAC_ThrDObjDethResp = new PATypes.PA_PAC_ThrDObjDethResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte235));
/*      */           return pA_PAC_ThrDObjDethResp;
/*      */         case 33543:
/*      */           this.data = (byte[])pA_PAC_ThrDObjDethResp.getValue();
/*      */           arrayOfByte234 = this.data;
/*      */           pA_PAC_PedDetnResp = new PATypes.PA_PAC_PedDetnResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte234));
/*      */           return pA_PAC_PedDetnResp;
/*      */         case 33542:
/*      */           this.data = (byte[])pA_PAC_PedDetnResp.getValue();
/*      */           arrayOfByte233 = this.data;
/*      */           pA_PAC_VisnAgExtnResp = new PATypes.PA_PAC_VisnAgExtnResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte233));
/*      */           return pA_PAC_VisnAgExtnResp;
/*      */         case 33541:
/*      */           this.data = (byte[])pA_PAC_VisnAgExtnResp.getValue();
/*      */           arrayOfByte232 = this.data;
/*      */           pA_PAC_PrkgIndcrLineResp = new PATypes.PA_PAC_PrkgIndcrLineResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte232));
/*      */           return pA_PAC_PrkgIndcrLineResp;
/*      */         case 33540:
/*      */           this.data = (byte[])pA_PAC_PrkgIndcrLineResp.getValue();
/*      */           arrayOfByte231 = this.data;
/*      */           pA_PAC_VisnImgAgWide3DInUse = new PATypes.PA_PAC_VisnImgAgWide3DInUse(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte231));
/*      */           return pA_PAC_VisnImgAgWide3DInUse;
/*      */         case 33539:
/*      */           this.data = (byte[])pA_PAC_VisnImgAgWide3DInUse.getValue();
/*      */           arrayOfByte230 = this.data;
/*      */           pA_PAC_VisnImgAgWide2DInUse = new PATypes.PA_PAC_VisnImgAgWide2DInUse(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte230));
/*      */           return pA_PAC_VisnImgAgWide2DInUse;
/*      */         case 33538:
/*      */           this.data = (byte[])pA_PAC_VisnImgAgWide2DInUse.getValue();
/*      */           arrayOfByte229 = this.data;
/*      */           pA_PAC_TxStrtVisReq = new PATypes.PA_PAC_TxStrtVisReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte229));
/*      */           return pA_PAC_TxStrtVisReq;
/*      */         case 33537:
/*      */           this.data = (byte[])pA_PAC_TxStrtVisReq.getValue();
/*      */           arrayOfByte228 = this.data;
/*      */           pA_PAC_SwtDispOnAndOffStsResp = new PATypes.PA_PAC_SwtDispOnAndOffStsResp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte228));
/*      */           return pA_PAC_SwtDispOnAndOffStsResp;
/*      */         case 33536:
/*      */           this.data = (byte[])pA_PAC_SwtDispOnAndOffStsResp.getValue();
/*      */           pA_DspVersion = new PATypes.PA_DspVersion(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_DspVersion;
/*      */         case 33535:
/*      */           this.data = (byte[])pA_DspVersion.getValue();
/*      */           arrayOfByte227 = this.data;
/*      */           pA_ErrorReport = new PATypes.PA_ErrorReport(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte227));
/*      */           return pA_ErrorReport;
/*      */         case 33534:
/*      */           this.data = (byte[])pA_ErrorReport.getValue();
/*      */           arrayOfByte226 = this.data;
/*      */           pA_AR_WarningVlo = new PATypes.PA_AR_WarningVlo(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte226));
/*      */           return pA_AR_WarningVlo;
/*      */         case 33533:
/*      */           this.data = (byte[])pA_AR_WarningVlo.getValue();
/*      */           pA_McuLog_Panic = new PATypes.PA_McuLog_Panic(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_McuLog_Panic;
/*      */         case 33532:
/*      */           this.data = (byte[])pA_McuLog_Panic.getValue();
/*      */           arrayOfByte225 = this.data;
/*      */           pA_VFC_SetVehSceneMode = new PATypes.PA_VFC_SetVehSceneMode(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte225));
/*      */           return pA_VFC_SetVehSceneMode;
/*      */         case 33531:
/*      */           this.data = (byte[])pA_VFC_SetVehSceneMode.getValue();
/*      */           arrayOfByte224 = this.data;
/*      */           pA_VFC_SceneModePDC = new PATypes.PA_VFC_SceneModePDC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte224));
/*      */           return pA_VFC_SceneModePDC;
/*      */         case 33530:
/*      */           this.data = (byte[])pA_VFC_SceneModePDC.getValue();
/*      */           arrayOfByte223 = this.data;
/*      */           pA_VFC_VFC_Reboot = new PATypes.PA_VFC_VFC_Reboot(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte223));
/*      */           return pA_VFC_VFC_Reboot;
/*      */         case 33529:
/*      */           this.data = (byte[])pA_VFC_VFC_Reboot.getValue();
/*      */           arrayOfByte222 = this.data;
/*      */           pA_VFC_SetVehFace = new PATypes.PA_VFC_SetVehFace(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte222));
/*      */           return pA_VFC_SetVehFace;
/*      */         case 33528:
/*      */           this.data = (byte[])pA_VFC_SetVehFace.getValue();
/*      */           arrayOfByte221 = this.data;
/*      */           pA_VFC_VFCRsrv5 = new PATypes.PA_VFC_VFCRsrv5(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte221));
/*      */           return pA_VFC_VFCRsrv5;
/*      */         case 33527:
/*      */           this.data = (byte[])pA_VFC_VFCRsrv5.getValue();
/*      */           arrayOfByte220 = this.data;
/*      */           pA_VFC_VFCRsrv4 = new PATypes.PA_VFC_VFCRsrv4(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte220));
/*      */           return pA_VFC_VFCRsrv4;
/*      */         case 33526:
/*      */           this.data = (byte[])pA_VFC_VFCRsrv4.getValue();
/*      */           arrayOfByte219 = this.data;
/*      */           pA_VFC_VFCRsrv3 = new PATypes.PA_VFC_VFCRsrv3(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte219));
/*      */           return pA_VFC_VFCRsrv3;
/*      */         case 33525:
/*      */           this.data = (byte[])pA_VFC_VFCRsrv3.getValue();
/*      */           arrayOfByte218 = this.data;
/*      */           pA_VFC_VFCRsrv2 = new PATypes.PA_VFC_VFCRsrv2(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte218));
/*      */           return pA_VFC_VFCRsrv2;
/*      */         case 33524:
/*      */           this.data = (byte[])pA_VFC_VFCRsrv2.getValue();
/*      */           arrayOfByte217 = this.data;
/*      */           pA_VFC_VFCRsrv1 = new PATypes.PA_VFC_VFCRsrv1(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte217));
/*      */           return pA_VFC_VFCRsrv1;
/*      */         case 33523:
/*      */           this.data = (byte[])pA_VFC_VFCRsrv1.getValue();
/*      */           arrayOfByte216 = this.data;
/*      */           pA_VFC_ExteriorLightShow = new PATypes.PA_VFC_ExteriorLightShow(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte216));
/*      */           return pA_VFC_ExteriorLightShow;
/*      */         case 33522:
/*      */           this.data = (byte[])pA_VFC_ExteriorLightShow.getValue();
/*      */           arrayOfByte215 = this.data;
/*      */           pA_VFC_ExteriorLightShowWin = new PATypes.PA_VFC_ExteriorLightShowWin(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte215));
/*      */           return pA_VFC_ExteriorLightShowWin;
/*      */         case 33521:
/*      */           this.data = (byte[])pA_VFC_ExteriorLightShowWin.getValue();
/*      */           arrayOfByte214 = this.data;
/*      */           pA_VFCNavigationInfoSharing = new PATypes.PA_VFCNavigationInfoSharing(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte214));
/*      */           return pA_VFCNavigationInfoSharing;
/*      */         case 33520:
/*      */           this.data = (byte[])pA_VFCNavigationInfoSharing.getValue();
/*      */           arrayOfByte213 = this.data;
/*      */           pA_VFCGenChaSettingsForHmiCen = new PATypes.PA_VFCGenChaSettingsForHmiCen(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte213));
/*      */           return pA_VFCGenChaSettingsForHmiCen;
/*      */         case 33519:
/*      */           this.data = (byte[])pA_VFCGenChaSettingsForHmiCen.getValue();
/*      */           arrayOfByte212 = this.data;
/*      */           pA_VFCSetVehCharging = new PATypes.PA_VFCSetVehCharging(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte212));
/*      */           return pA_VFCSetVehCharging;
/*      */         case 33518:
/*      */           this.data = (byte[])pA_VFCSetVehCharging.getValue();
/*      */           arrayOfByte211 = this.data;
/*      */           pA_VFC_SetVehDvr = new PATypes.PA_VFC_SetVehDvr(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte211));
/*      */           return pA_VFC_SetVehDvr;
/*      */         case 33517:
/*      */           this.data = (byte[])pA_VFC_SetVehDvr.getValue();
/*      */           arrayOfByte210 = this.data;
/*      */           pA_VFC_SetVehTcam = new PATypes.PA_VFC_SetVehTcam(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte210));
/*      */           return pA_VFC_SetVehTcam;
/*      */         case 33516:
/*      */           this.data = (byte[])pA_VFC_SetVehTcam.getValue();
/*      */           arrayOfByte209 = this.data;
/*      */           pA_VFC_SetVehAvm = new PATypes.PA_VFC_SetVehAvm(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte209));
/*      */           return pA_VFC_SetVehAvm;
/*      */         case 33515:
/*      */           this.data = (byte[])pA_VFC_SetVehAvm.getValue();
/*      */           arrayOfByte208 = this.data;
/*      */           pA_VFC_SetVehApa = new PATypes.PA_VFC_SetVehApa(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte208));
/*      */           return pA_VFC_SetVehApa;
/*      */         case 33514:
/*      */           this.data = (byte[])pA_VFC_SetVehApa.getValue();
/*      */           arrayOfByte207 = this.data;
/*      */           pA_VFC_SetVehPrivateLock = new PATypes.PA_VFC_SetVehPrivateLock(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte207));
/*      */           return pA_VFC_SetVehPrivateLock;
/*      */         case 33513:
/*      */           this.data = (byte[])pA_VFC_SetVehPrivateLock.getValue();
/*      */           arrayOfByte206 = this.data;
/*      */           pA_VFC_SetVehCenClkIndcnAndSetg = new PATypes.PA_VFC_SetVehCenClkIndcnAndSetg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte206));
/*      */           return pA_VFC_SetVehCenClkIndcnAndSetg;
/*      */         case 33512:
/*      */           this.data = (byte[])pA_VFC_SetVehCenClkIndcnAndSetg.getValue();
/*      */           arrayOfByte205 = this.data;
/*      */           pA_VFC_TelephoneManager = new PATypes.PA_VFC_TelephoneManager(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte205));
/*      */           return pA_VFC_TelephoneManager;
/*      */         case 33511:
/*      */           this.data = (byte[])pA_VFC_TelephoneManager.getValue();
/*      */           arrayOfByte204 = this.data;
/*      */           pA_VFC_FaceIdnForHmiCen = new PATypes.PA_VFC_FaceIdnForHmiCen(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte204));
/*      */           return pA_VFC_FaceIdnForHmiCen;
/*      */         case 33510:
/*      */           this.data = (byte[])pA_VFC_FaceIdnForHmiCen.getValue();
/*      */           arrayOfByte203 = this.data;
/*      */           pA_VFC_ParkAssiCtrlForHmiCen = new PATypes.PA_VFC_ParkAssiCtrlForHmiCen(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte203));
/*      */           return pA_VFC_ParkAssiCtrlForHmiCen;
/*      */         case 33509:
/*      */           this.data = (byte[])pA_VFC_ParkAssiCtrlForHmiCen.getValue();
/*      */           arrayOfByte202 = this.data;
/*      */           pA_VFC_IPWakeup = new PATypes.PA_VFC_IPWakeup(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte202));
/*      */           return pA_VFC_IPWakeup;
/*      */         case 33508:
/*      */           this.data = (byte[])pA_VFC_IPWakeup.getValue();
/*      */           pA_VF_HUD_ARD311Data = new PATypes.PA_VF_HUD_ARD311Data(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_VF_HUD_ARD311Data;
/*      */         case 33507:
/*      */           this.data = (byte[])pA_VF_HUD_ARD311Data.getValue();
/*      */           pA_VF_HUD_ARD310Data = new PATypes.PA_VF_HUD_ARD310Data(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_VF_HUD_ARD310Data;
/*      */         case 33506:
/*      */           this.data = (byte[])pA_VF_HUD_ARD310Data.getValue();
/*      */           pA_VF_HUD_ARD300Data = new PATypes.PA_VF_HUD_ARD300Data(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_VF_HUD_ARD300Data;
/*      */         case 33505:
/*      */           this.data = (byte[])pA_VF_HUD_ARD300Data.getValue();
/*      */           arrayOfByte201 = this.data;
/*      */           pA_VF_HUD_ARActvSts = new PATypes.PA_VF_HUD_ARActvSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte201));
/*      */           return pA_VF_HUD_ARActvSts;
/*      */         case 33504:
/*      */           this.data = (byte[])pA_VF_HUD_ARActvSts.getValue();
/*      */           arrayOfByte200 = this.data;
/*      */           pA_VF_HUD_HudSnowModeReq = new PATypes.PA_VF_HUD_HudSnowModeReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte200));
/*      */           return pA_VF_HUD_HudSnowModeReq;
/*      */         case 33503:
/*      */           this.data = (byte[])pA_VF_HUD_HudSnowModeReq.getValue();
/*      */           arrayOfByte199 = this.data;
/*      */           pA_VF_HUD_HudRstForSetgAndData = new PATypes.PA_VF_HUD_HudRstForSetgAndData(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte199));
/*      */           return pA_VF_HUD_HudRstForSetgAndData;
/*      */         case 33502:
/*      */           this.data = (byte[])pA_VF_HUD_HudRstForSetgAndData.getValue();
/*      */           arrayOfByte198 = this.data;
/*      */           pA_VF_HUD_ImgRotAdjmtReq = new PATypes.PA_VF_HUD_ImgRotAdjmtReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte198));
/*      */           return pA_VF_HUD_ImgRotAdjmtReq;
/*      */         case 33501:
/*      */           this.data = (byte[])pA_VF_HUD_ImgRotAdjmtReq.getValue();
/*      */           arrayOfByte197 = this.data;
/*      */           pA_VF_HUD_ErgoAdjmtReq = new PATypes.PA_VF_HUD_ErgoAdjmtReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte197));
/*      */           return pA_VF_HUD_ErgoAdjmtReq;
/*      */         case 33500:
/*      */           this.data = (byte[])pA_VF_HUD_ErgoAdjmtReq.getValue();
/*      */           arrayOfByte196 = this.data;
/*      */           pA_VF_HUD_IllmnReq = new PATypes.PA_VF_HUD_IllmnReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte196));
/*      */           return pA_VF_HUD_IllmnReq;
/*      */         case 33499:
/*      */           this.data = (byte[])pA_VF_HUD_IllmnReq.getValue();
/*      */           arrayOfByte195 = this.data;
/*      */           pA_VF_HUD_ActvSts = new PATypes.PA_VF_HUD_ActvSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte195));
/*      */           return pA_VF_HUD_ActvSts;
/*      */         case 33498:
/*      */           this.data = (byte[])pA_VF_HUD_ActvSts.getValue();
/*      */           pA_Device_Supplier_Code = new PATypes.PA_Device_Supplier_Code(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_Device_Supplier_Code;
/*      */         case 33497:
/*      */           this.data = (byte[])pA_Device_Supplier_Code.getValue();
/*      */           pA_Device_Project_Code = new PATypes.PA_Device_Project_Code(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_Device_Project_Code;
/*      */         case 33496:
/*      */           this.data = (byte[])pA_Device_Project_Code.getValue();
/*      */           pA_Device_VPVersion_HD = new PATypes.PA_Device_VPVersion_HD(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_Device_VPVersion_HD;
/*      */         case 33495:
/*      */           this.data = (byte[])pA_Device_VPVersion_HD.getValue();
/*      */           pA_Device_SN = new PATypes.PA_Device_SN(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_Device_SN;
/*      */         case 33494:
/*      */           this.data = (byte[])pA_Device_SN.getValue();
/*      */           pA_Device_IHUID = new PATypes.PA_Device_IHUID(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_Device_IHUID;
/*      */         case 33493:
/*      */           this.data = (byte[])pA_Device_IHUID.getValue();
/*      */           pA_VP_Version = new PATypes.PA_VP_Version(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_VP_Version;
/*      */         case 33492:
/*      */           this.data = (byte[])pA_VP_Version.getValue();
/*      */           pA_VIN_VinNum = new PATypes.PA_VIN_VinNum(VendorVehicleHalPAProto.PAByteType.parseFrom(this.data));
/*      */           return pA_VIN_VinNum;
/*      */         case 33491:
/*      */           this.data = (byte[])pA_VIN_VinNum.getValue();
/*      */           pA_SAP_PrkgUnlck = new PATypes.PA_SAP_PrkgUnlck(VendorVehicleHalPAProto.Touchtime.parseFrom(this.data));
/*      */           return pA_SAP_PrkgUnlck;
/*      */         case 33490:
/*      */           this.data = (byte[])pA_SAP_PrkgUnlck.getValue();
/*      */           arrayOfByte194 = this.data;
/*      */           pA_PowerSoftKeyBrightness = new PATypes.PA_PowerSoftKeyBrightness(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte194));
/*      */           return pA_PowerSoftKeyBrightness;
/*      */         case 33489:
/*      */           this.data = (byte[])pA_PowerSoftKeyBrightness.getValue();
/*      */           arrayOfByte193 = this.data;
/*      */           pA_PowerSoftKeySwitch = new PATypes.PA_PowerSoftKeySwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte193));
/*      */           return pA_PowerSoftKeySwitch;
/*      */         case 33488:
/*      */           this.data = (byte[])pA_PowerSoftKeySwitch.getValue();
/*      */           arrayOfByte192 = this.data;
/*      */           pA_LinkSwitch = new PATypes.PA_LinkSwitch(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte192));
/*      */           return pA_LinkSwitch;
/*      */         case 33487:
/*      */           this.data = (byte[])pA_LinkSwitch.getValue();
/*      */           arrayOfByte191 = this.data;
/*      */           pA_LcfgPsdNightVal = new PATypes.PA_LcfgPsdNightVal(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte191));
/*      */           return pA_LcfgPsdNightVal;
/*      */         case 33486:
/*      */           this.data = (byte[])pA_LcfgPsdNightVal.getValue();
/*      */           arrayOfByte190 = this.data;
/*      */           pA_LcfgPsdDayVal = new PATypes.PA_LcfgPsdDayVal(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte190));
/*      */           return pA_LcfgPsdDayVal;
/*      */         case 33485:
/*      */           this.data = (byte[])pA_LcfgPsdDayVal.getValue();
/*      */           arrayOfByte189 = this.data;
/*      */           pA_LcfgCsdNightVal = new PATypes.PA_LcfgCsdNightVal(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte189));
/*      */           return pA_LcfgCsdNightVal;
/*      */         case 33484:
/*      */           this.data = (byte[])pA_LcfgCsdNightVal.getValue();
/*      */           arrayOfByte188 = this.data;
/*      */           pA_LcfgCsdDayVal = new PATypes.PA_LcfgCsdDayVal(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte188));
/*      */           return pA_LcfgCsdDayVal;
/*      */         case 33483:
/*      */           this.data = (byte[])pA_LcfgCsdDayVal.getValue();
/*      */           arrayOfByte187 = this.data;
/*      */           pA_LcfgDftBckVal = new PATypes.PA_LcfgDftBckVal(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte187));
/*      */           return pA_LcfgDftBckVal;
/*      */         case 33482:
/*      */           this.data = (byte[])pA_LcfgDftBckVal.getValue();
/*      */           arrayOfByte186 = this.data;
/*      */           pA_t_dim_rheo = new PATypes.PA_t_dim_rheo(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte186));
/*      */           return pA_t_dim_rheo;
/*      */         case 33481:
/*      */           this.data = (byte[])pA_t_dim_rheo.getValue();
/*      */           arrayOfByte185 = this.data;
/*      */           pA_t_dim_slow = new PATypes.PA_t_dim_slow(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte185));
/*      */           return pA_t_dim_slow;
/*      */         case 33480:
/*      */           this.data = (byte[])pA_t_dim_slow.getValue();
/*      */           arrayOfByte184 = this.data;
/*      */           pA_t_dim_fast = new PATypes.PA_t_dim_fast(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte184));
/*      */           return pA_t_dim_fast;
/*      */         case 33479:
/*      */           this.data = (byte[])pA_t_dim_fast.getValue();
/*      */           arrayOfByte183 = this.data;
/*      */           pA_PSDBrightness = new PATypes.PA_PSDBrightness(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte183));
/*      */           return pA_PSDBrightness;
/*      */         case 33478:
/*      */           this.data = (byte[])pA_PSDBrightness.getValue();
/*      */           arrayOfByte182 = this.data;
/*      */           pA_CSDBrightness = new PATypes.PA_CSDBrightness(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte182));
/*      */           return pA_CSDBrightness;
/*      */         case 33477:
/*      */           this.data = (byte[])pA_CSDBrightness.getValue();
/*      */           arrayOfByte181 = this.data;
/*      */           pA_DayNightMode = new PATypes.PA_DayNightMode(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte181));
/*      */           return pA_DayNightMode;
/*      */         case 33476:
/*      */           this.data = (byte[])pA_DayNightMode.getValue();
/*      */           arrayOfByte180 = this.data;
/*      */           pA_BackBrightness = new PATypes.PA_BackBrightness(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte180));
/*      */           return pA_BackBrightness;
/*      */         case 33475:
/*      */           this.data = (byte[])pA_BackBrightness.getValue();
/*      */           arrayOfByte179 = this.data;
/*      */           pA_SysSetPUnit = new PATypes.PA_SysSetPUnit(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte179));
/*      */           return pA_SysSetPUnit;
/*      */         case 33474:
/*      */           this.data = (byte[])pA_SysSetPUnit.getValue();
/*      */           arrayOfByte178 = this.data;
/*      */           pA_SysSetDstLong = new PATypes.PA_SysSetDstLong(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte178));
/*      */           return pA_SysSetDstLong;
/*      */         case 33473:
/*      */           this.data = (byte[])pA_SysSetDstLong.getValue();
/*      */           arrayOfByte177 = this.data;
/*      */           pA_SysSetVolUnit = new PATypes.PA_SysSetVolUnit(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte177));
/*      */           return pA_SysSetVolUnit;
/*      */         case 33472:
/*      */           this.data = (byte[])pA_SysSetVolUnit.getValue();
/*      */           arrayOfByte176 = this.data;
/*      */           pA_SysSetSpdUnit = new PATypes.PA_SysSetSpdUnit(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte176));
/*      */           return pA_SysSetSpdUnit;
/*      */         case 33471:
/*      */           this.data = (byte[])pA_SysSetSpdUnit.getValue();
/*      */           arrayOfByte175 = this.data;
/*      */           pA_SysSetFuCnsUnit = new PATypes.PA_SysSetFuCnsUnit(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte175));
/*      */           return pA_SysSetFuCnsUnit;
/*      */         case 33470:
/*      */           this.data = (byte[])pA_SysSetFuCnsUnit.getValue();
/*      */           arrayOfByte174 = this.data;
/*      */           pA_SysSetTempUnit = new PATypes.PA_SysSetTempUnit(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte174));
/*      */           return pA_SysSetTempUnit;
/*      */         case 33469:
/*      */           this.data = (byte[])pA_SysSetTempUnit.getValue();
/*      */           arrayOfByte173 = this.data;
/*      */           pA_SysSetDateFmt = new PATypes.PA_SysSetDateFmt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte173));
/*      */           return pA_SysSetDateFmt;
/*      */         case 33468:
/*      */           this.data = (byte[])pA_SysSetDateFmt.getValue();
/*      */           arrayOfByte172 = this.data;
/*      */           pA_SysSetClkFmt = new PATypes.PA_SysSetClkFmt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte172));
/*      */           return pA_SysSetClkFmt;
/*      */         case 33467:
/*      */           this.data = (byte[])pA_SysSetClkFmt.getValue();
/*      */           arrayOfByte171 = this.data;
/*      */           pA_SysSetOfLang = new PATypes.PA_SysSetOfLang(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte171));
/*      */           return pA_SysSetOfLang;
/*      */         case 33466:
/*      */           this.data = (byte[])pA_SysSetOfLang.getValue();
/*      */           pA_Power_Res = new PATypes.PA_Power_Res(VendorVehicleHalPAProto.PwrctrlVptoapimpl.parseFrom(this.data));
/*      */           return pA_Power_Res;
/*      */         case 33465:
/*      */           this.data = (byte[])pA_Power_Res.getValue();
/*      */           arrayOfByte170 = this.data;
/*      */           pA_DriveMode_Adaptive = new PATypes.PA_DriveMode_Adaptive(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte170));
/*      */           return pA_DriveMode_Adaptive;
/*      */         case 33464:
/*      */           this.data = (byte[])pA_DriveMode_Adaptive.getValue();
/*      */           arrayOfByte169 = this.data;
/*      */           pA_DriveMode_Animation = new PATypes.PA_DriveMode_Animation(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte169));
/*      */           return pA_DriveMode_Animation;
/*      */         case 33463:
/*      */           this.data = (byte[])pA_DriveMode_Animation.getValue();
/*      */           arrayOfByte168 = this.data;
/*      */           pA_DriveMode_Value = new PATypes.PA_DriveMode_Value(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte168));
/*      */           return pA_DriveMode_Value;
/*      */         case 33462:
/*      */           this.data = (byte[])pA_DriveMode_Value.getValue();
/*      */           arrayOfByte167 = this.data;
/*      */           pA_DriveMode_Suspension_Settings = new PATypes.PA_DriveMode_Suspension_Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte167));
/*      */           return pA_DriveMode_Suspension_Settings;
/*      */         case 33461:
/*      */           this.data = (byte[])pA_DriveMode_Suspension_Settings.getValue();
/*      */           arrayOfByte166 = this.data;
/*      */           pA_DriveMode_Engine_StartStop = new PATypes.PA_DriveMode_Engine_StartStop(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte166));
/*      */           return pA_DriveMode_Engine_StartStop;
/*      */         case 33460:
/*      */           this.data = (byte[])pA_DriveMode_Engine_StartStop.getValue();
/*      */           arrayOfByte165 = this.data;
/*      */           pA_DriveMode_DIMTheme_Settings = new PATypes.PA_DriveMode_DIMTheme_Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte165));
/*      */           return pA_DriveMode_DIMTheme_Settings;
/*      */         case 33459:
/*      */           this.data = (byte[])pA_DriveMode_DIMTheme_Settings.getValue();
/*      */           arrayOfByte164 = this.data;
/*      */           pA_DriveMode_SteeringWheelAssistLevel_Settings = new PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte164));
/*      */           return pA_DriveMode_SteeringWheelAssistLevel_Settings;
/*      */         case 33458:
/*      */           this.data = (byte[])pA_DriveMode_SteeringWheelAssistLevel_Settings.getValue();
/*      */           arrayOfByte163 = this.data;
/*      */           pA_DriveMode_AirConditioner_Settings = new PATypes.PA_DriveMode_AirConditioner_Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte163));
/*      */           return pA_DriveMode_AirConditioner_Settings;
/*      */         case 33457:
/*      */           this.data = (byte[])pA_DriveMode_AirConditioner_Settings.getValue();
/*      */           arrayOfByte162 = this.data;
/*      */           pA_DriveMode_Powertrain_Settings = new PATypes.PA_DriveMode_Powertrain_Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte162));
/*      */           return pA_DriveMode_Powertrain_Settings;
/*      */         case 33456:
/*      */           this.data = (byte[])pA_DriveMode_Powertrain_Settings.getValue();
/*      */           arrayOfByte161 = this.data;
/*      */           pA_DriveMode_Brake_Settings = new PATypes.PA_DriveMode_Brake_Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte161));
/*      */           return pA_DriveMode_Brake_Settings;
/*      */         case 33455:
/*      */           this.data = (byte[])pA_DriveMode_Brake_Settings.getValue();
/*      */           arrayOfByte160 = this.data;
/*      */           pA_DriveMode_Individual_Settings = new PATypes.PA_DriveMode_Individual_Settings(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte160));
/*      */           return pA_DriveMode_Individual_Settings;
/*      */         case 33454:
/*      */           this.data = (byte[])pA_DriveMode_Individual_Settings.getValue();
/*      */           arrayOfByte159 = this.data;
/*      */           pA_DriveMode_active_time = new PATypes.PA_DriveMode_active_time(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte159));
/*      */           return pA_DriveMode_active_time;
/*      */         case 33453:
/*      */           this.data = (byte[])pA_DriveMode_active_time.getValue();
/*      */           arrayOfByte158 = this.data;
/*      */           pA_DriveMode_confirmation_timeout = new PATypes.PA_DriveMode_confirmation_timeout(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte158));
/*      */           return pA_DriveMode_confirmation_timeout;
/*      */         case 33452:
/*      */           this.data = (byte[])pA_DriveMode_confirmation_timeout.getValue();
/*      */           arrayOfByte157 = this.data;
/*      */           pA_DriveMode_Rock = new PATypes.PA_DriveMode_Rock(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte157));
/*      */           return pA_DriveMode_Rock;
/*      */         case 33451:
/*      */           this.data = (byte[])pA_DriveMode_Rock.getValue();
/*      */           arrayOfByte156 = this.data;
/*      */           pA_DriveMode_Mud = new PATypes.PA_DriveMode_Mud(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte156));
/*      */           return pA_DriveMode_Mud;
/*      */         case 33450:
/*      */           this.data = (byte[])pA_DriveMode_Mud.getValue();
/*      */           arrayOfByte155 = this.data;
/*      */           pA_DriveMode_Sand = new PATypes.PA_DriveMode_Sand(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte155));
/*      */           return pA_DriveMode_Sand;
/*      */         case 33449:
/*      */           this.data = (byte[])pA_DriveMode_Sand.getValue();
/*      */           arrayOfByte154 = this.data;
/*      */           pA_DriveMode_Snow = new PATypes.PA_DriveMode_Snow(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte154));
/*      */           return pA_DriveMode_Snow;
/*      */         case 33448:
/*      */           this.data = (byte[])pA_DriveMode_Snow.getValue();
/*      */           arrayOfByte153 = this.data;
/*      */           pA_DriveMode_Power = new PATypes.PA_DriveMode_Power(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte153));
/*      */           return pA_DriveMode_Power;
/*      */         case 33447:
/*      */           this.data = (byte[])pA_DriveMode_Power.getValue();
/*      */           arrayOfByte152 = this.data;
/*      */           pA_DriveMode_Hybrid = new PATypes.PA_DriveMode_Hybrid(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte152));
/*      */           return pA_DriveMode_Hybrid;
/*      */         case 33446:
/*      */           this.data = (byte[])pA_DriveMode_Hybrid.getValue();
/*      */           arrayOfByte151 = this.data;
/*      */           pA_DriveMode_Pure = new PATypes.PA_DriveMode_Pure(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte151));
/*      */           return pA_DriveMode_Pure;
/*      */         case 33445:
/*      */           this.data = (byte[])pA_DriveMode_Pure.getValue();
/*      */           arrayOfByte150 = this.data;
/*      */           pA_DriveMode_Save = new PATypes.PA_DriveMode_Save(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte150));
/*      */           return pA_DriveMode_Save;
/*      */         case 33444:
/*      */           this.data = (byte[])pA_DriveMode_Save.getValue();
/*      */           arrayOfByte149 = this.data;
/*      */           pA_DriveMode_AWD = new PATypes.PA_DriveMode_AWD(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte149));
/*      */           return pA_DriveMode_AWD;
/*      */         case 33443:
/*      */           this.data = (byte[])pA_DriveMode_AWD.getValue();
/*      */           arrayOfByte148 = this.data;
/*      */           pA_DriveMode_XC = new PATypes.PA_DriveMode_XC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte148));
/*      */           return pA_DriveMode_XC;
/*      */         case 33442:
/*      */           this.data = (byte[])pA_DriveMode_XC.getValue();
/*      */           arrayOfByte147 = this.data;
/*      */           pA_DriveMode_Individual = new PATypes.PA_DriveMode_Individual(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte147));
/*      */           return pA_DriveMode_Individual;
/*      */         case 33441:
/*      */           this.data = (byte[])pA_DriveMode_Individual.getValue();
/*      */           arrayOfByte146 = this.data;
/*      */           pA_DriveMode_Dynamic = new PATypes.PA_DriveMode_Dynamic(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte146));
/*      */           return pA_DriveMode_Dynamic;
/*      */         case 33440:
/*      */           this.data = (byte[])pA_DriveMode_Dynamic.getValue();
/*      */           arrayOfByte145 = this.data;
/*      */           pA_DriveMode_Comfort = new PATypes.PA_DriveMode_Comfort(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte145));
/*      */           return pA_DriveMode_Comfort;
/*      */         case 33439:
/*      */           this.data = (byte[])pA_DriveMode_Comfort.getValue();
/*      */           arrayOfByte144 = this.data;
/*      */           pA_DriveMode_Eco = new PATypes.PA_DriveMode_Eco(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte144));
/*      */           return pA_DriveMode_Eco;
/*      */         case 33438:
/*      */           this.data = (byte[])pA_DriveMode_Eco.getValue();
/*      */           arrayOfByte143 = this.data;
/*      */           pA_TCH_CupHoldrOcpyFbSts = new PATypes.PA_TCH_CupHoldrOcpyFbSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte143));
/*      */           return pA_TCH_CupHoldrOcpyFbSts;
/*      */         case 33437:
/*      */           this.data = (byte[])pA_TCH_CupHoldrOcpyFbSts.getValue();
/*      */           arrayOfByte142 = this.data;
/*      */           pA_TCH_CupHoldrAvlSts = new PATypes.PA_TCH_CupHoldrAvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte142));
/*      */           return pA_TCH_CupHoldrAvlSts;
/*      */         case 33436:
/*      */           this.data = (byte[])pA_TCH_CupHoldrAvlSts.getValue();
/*      */           arrayOfByte141 = this.data;
/*      */           pA_TCH_CupHoldrVoltgErr = new PATypes.PA_TCH_CupHoldrVoltgErr(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte141));
/*      */           return pA_TCH_CupHoldrVoltgErr;
/*      */         case 33435:
/*      */           this.data = (byte[])pA_TCH_CupHoldrVoltgErr.getValue();
/*      */           arrayOfByte140 = this.data;
/*      */           pA_TCH_CupHoldrActvAllwd = new PATypes.PA_TCH_CupHoldrActvAllwd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte140));
/*      */           return pA_TCH_CupHoldrActvAllwd;
/*      */         case 33434:
/*      */           this.data = (byte[])pA_TCH_CupHoldrActvAllwd.getValue();
/*      */           arrayOfByte139 = this.data;
/*      */           pA_TCH_CupHoldrStsFd = new PATypes.PA_TCH_CupHoldrStsFd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte139));
/*      */           return pA_TCH_CupHoldrStsFd;
/*      */         case 33433:
/*      */           this.data = (byte[])pA_TCH_CupHoldrStsFd.getValue();
/*      */           arrayOfByte138 = this.data;
/*      */           pA_Fragra_FragRefrshAutSetg = new PATypes.PA_Fragra_FragRefrshAutSetg(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte138));
/*      */           return pA_Fragra_FragRefrshAutSetg;
/*      */         case 33432:
/*      */           this.data = (byte[])pA_Fragra_FragRefrshAutSetg.getValue();
/*      */           arrayOfByte137 = this.data;
/*      */           pA_Fragra_AirFragCh5RunngSts = new PATypes.PA_Fragra_AirFragCh5RunngSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte137));
/*      */           return pA_Fragra_AirFragCh5RunngSts;
/*      */         case 33431:
/*      */           this.data = (byte[])pA_Fragra_AirFragCh5RunngSts.getValue();
/*      */           arrayOfByte136 = this.data;
/*      */           pA_Fragra_AirFragCh4RunngSts = new PATypes.PA_Fragra_AirFragCh4RunngSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte136));
/*      */           return pA_Fragra_AirFragCh4RunngSts;
/*      */         case 33430:
/*      */           this.data = (byte[])pA_Fragra_AirFragCh4RunngSts.getValue();
/*      */           arrayOfByte135 = this.data;
/*      */           pA_Fragra_AirFragCh3RunngSts = new PATypes.PA_Fragra_AirFragCh3RunngSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte135));
/*      */           return pA_Fragra_AirFragCh3RunngSts;
/*      */         case 33429:
/*      */           this.data = (byte[])pA_Fragra_AirFragCh3RunngSts.getValue();
/*      */           arrayOfByte134 = this.data;
/*      */           pA_Fragra_AirFragCh2RunngSts = new PATypes.PA_Fragra_AirFragCh2RunngSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte134));
/*      */           return pA_Fragra_AirFragCh2RunngSts;
/*      */         case 33428:
/*      */           this.data = (byte[])pA_Fragra_AirFragCh2RunngSts.getValue();
/*      */           arrayOfByte133 = this.data;
/*      */           pA_Fragra_AirFragCh1RunngSts = new PATypes.PA_Fragra_AirFragCh1RunngSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte133));
/*      */           return pA_Fragra_AirFragCh1RunngSts;
/*      */         case 33427:
/*      */           this.data = (byte[])pA_Fragra_AirFragCh1RunngSts.getValue();
/*      */           arrayOfByte132 = this.data;
/*      */           pA_Fragra_Tast5UseUpRmd = new PATypes.PA_Fragra_Tast5UseUpRmd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte132));
/*      */           return pA_Fragra_Tast5UseUpRmd;
/*      */         case 33426:
/*      */           this.data = (byte[])pA_Fragra_Tast5UseUpRmd.getValue();
/*      */           arrayOfByte131 = this.data;
/*      */           pA_Fragra_Tast4UseUpRmd = new PATypes.PA_Fragra_Tast4UseUpRmd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte131));
/*      */           return pA_Fragra_Tast4UseUpRmd;
/*      */         case 33425:
/*      */           this.data = (byte[])pA_Fragra_Tast4UseUpRmd.getValue();
/*      */           arrayOfByte130 = this.data;
/*      */           pA_Fragra_Tast3UseUpRmd = new PATypes.PA_Fragra_Tast3UseUpRmd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte130));
/*      */           return pA_Fragra_Tast3UseUpRmd;
/*      */         case 33424:
/*      */           this.data = (byte[])pA_Fragra_Tast3UseUpRmd.getValue();
/*      */           arrayOfByte129 = this.data;
/*      */           pA_Fragra_Tast2UseUpRmd = new PATypes.PA_Fragra_Tast2UseUpRmd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte129));
/*      */           return pA_Fragra_Tast2UseUpRmd;
/*      */         case 33423:
/*      */           this.data = (byte[])pA_Fragra_Tast2UseUpRmd.getValue();
/*      */           arrayOfByte128 = this.data;
/*      */           pA_Fragra_Tast1UseUpRmd = new PATypes.PA_Fragra_Tast1UseUpRmd(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte128));
/*      */           return pA_Fragra_Tast1UseUpRmd;
/*      */         case 33422:
/*      */           this.data = (byte[])pA_Fragra_Tast1UseUpRmd.getValue();
/*      */           arrayOfByte127 = this.data;
/*      */           pA_Fragra_Taste5ID = new PATypes.PA_Fragra_Taste5ID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte127));
/*      */           return pA_Fragra_Taste5ID;
/*      */         case 33421:
/*      */           this.data = (byte[])pA_Fragra_Taste5ID.getValue();
/*      */           arrayOfByte126 = this.data;
/*      */           pA_Fragra_Taste4ID = new PATypes.PA_Fragra_Taste4ID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte126));
/*      */           return pA_Fragra_Taste4ID;
/*      */         case 33420:
/*      */           this.data = (byte[])pA_Fragra_Taste4ID.getValue();
/*      */           arrayOfByte125 = this.data;
/*      */           pA_Fragra_Taste3ID = new PATypes.PA_Fragra_Taste3ID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte125));
/*      */           return pA_Fragra_Taste3ID;
/*      */         case 33419:
/*      */           this.data = (byte[])pA_Fragra_Taste3ID.getValue();
/*      */           arrayOfByte124 = this.data;
/*      */           pA_Fragra_Taste2ID = new PATypes.PA_Fragra_Taste2ID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte124));
/*      */           return pA_Fragra_Taste2ID;
/*      */         case 33418:
/*      */           this.data = (byte[])pA_Fragra_Taste2ID.getValue();
/*      */           arrayOfByte123 = this.data;
/*      */           pA_Fragra_Taste1ID = new PATypes.PA_Fragra_Taste1ID(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte123));
/*      */           return pA_Fragra_Taste1ID;
/*      */         case 33417:
/*      */           this.data = (byte[])pA_Fragra_Taste1ID.getValue();
/*      */           arrayOfByte122 = this.data;
/*      */           pA_Fragra_RefrshReq = new PATypes.PA_Fragra_RefrshReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte122));
/*      */           return pA_Fragra_RefrshReq;
/*      */         case 33416:
/*      */           this.data = (byte[])pA_Fragra_RefrshReq.getValue();
/*      */           arrayOfByte121 = this.data;
/*      */           pA_Fragra_Sts = new PATypes.PA_Fragra_Sts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte121));
/*      */           return pA_Fragra_Sts;
/*      */         case 33415:
/*      */           this.data = (byte[])pA_Fragra_Sts.getValue();
/*      */           arrayOfByte120 = this.data;
/*      */           pA_Fragra_SceneSetSts = new PATypes.PA_Fragra_SceneSetSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte120));
/*      */           return pA_Fragra_SceneSetSts;
/*      */         case 33414:
/*      */           this.data = (byte[])pA_Fragra_SceneSetSts.getValue();
/*      */           arrayOfByte119 = this.data;
/*      */           pA_Fragra_ModReqSts = new PATypes.PA_Fragra_ModReqSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte119));
/*      */           return pA_Fragra_ModReqSts;
/*      */         case 33413:
/*      */           this.data = (byte[])pA_Fragra_ModReqSts.getValue();
/*      */           arrayOfByte118 = this.data;
/*      */           pA_Fragra_LvlReqSts = new PATypes.PA_Fragra_LvlReqSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte118));
/*      */           return pA_Fragra_LvlReqSts;
/*      */         case 33412:
/*      */           this.data = (byte[])pA_Fragra_LvlReqSts.getValue();
/*      */           arrayOfByte117 = this.data;
/*      */           pA_Fragra_TypRatReqFSts = new PATypes.PA_Fragra_TypRatReqFSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte117));
/*      */           return pA_Fragra_TypRatReqFSts;
/*      */         case 33411:
/*      */           this.data = (byte[])pA_Fragra_TypRatReqFSts.getValue();
/*      */           arrayOfByte116 = this.data;
/*      */           pA_Fragra_TypRatReqESts = new PATypes.PA_Fragra_TypRatReqESts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte116));
/*      */           return pA_Fragra_TypRatReqESts;
/*      */         case 33410:
/*      */           this.data = (byte[])pA_Fragra_TypRatReqESts.getValue();
/*      */           arrayOfByte115 = this.data;
/*      */           pA_Fragra_TypRatReqDSts = new PATypes.PA_Fragra_TypRatReqDSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte115));
/*      */           return pA_Fragra_TypRatReqDSts;
/*      */         case 33409:
/*      */           this.data = (byte[])pA_Fragra_TypRatReqDSts.getValue();
/*      */           arrayOfByte114 = this.data;
/*      */           pA_Fragra_TypRatReqCSts = new PATypes.PA_Fragra_TypRatReqCSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte114));
/*      */           return pA_Fragra_TypRatReqCSts;
/*      */         case 33408:
/*      */           this.data = (byte[])pA_Fragra_TypRatReqCSts.getValue();
/*      */           arrayOfByte113 = this.data;
/*      */           pA_Fragra_TypRatReqBSts = new PATypes.PA_Fragra_TypRatReqBSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte113));
/*      */           return pA_Fragra_TypRatReqBSts;
/*      */         case 33407:
/*      */           this.data = (byte[])pA_Fragra_TypRatReqBSts.getValue();
/*      */           arrayOfByte112 = this.data;
/*      */           pA_Fragra_TypRatReqASts = new PATypes.PA_Fragra_TypRatReqASts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte112));
/*      */           return pA_Fragra_TypRatReqASts;
/*      */         case 33406:
/*      */           this.data = (byte[])pA_Fragra_TypRatReqASts.getValue();
/*      */           arrayOfByte111 = this.data;
/*      */           pA_Fragra_Actn = new PATypes.PA_Fragra_Actn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte111));
/*      */           return pA_Fragra_Actn;
/*      */         case 33405:
/*      */           this.data = (byte[])pA_Fragra_Actn.getValue();
/*      */           arrayOfByte110 = this.data;
/*      */           pA_PM25_IncomingAirQlyPopUpReq = new PATypes.PA_PM25_IncomingAirQlyPopUpReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte110));
/*      */           return pA_PM25_IncomingAirQlyPopUpReq;
/*      */         case 33404:
/*      */           this.data = (byte[])pA_PM25_IncomingAirQlyPopUpReq.getValue();
/*      */           arrayOfByte109 = this.data;
/*      */           pA_PM25_OutdPm25Sts = new PATypes.PA_PM25_OutdPm25Sts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte109));
/*      */           return pA_PM25_OutdPm25Sts;
/*      */         case 33403:
/*      */           this.data = (byte[])pA_PM25_OutdPm25Sts.getValue();
/*      */           arrayOfByte108 = this.data;
/*      */           pA_PM25_IntPm25Sts = new PATypes.PA_PM25_IntPm25Sts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte108));
/*      */           return pA_PM25_IntPm25Sts;
/*      */         case 33402:
/*      */           this.data = (byte[])pA_PM25_IntPm25Sts.getValue();
/*      */           arrayOfByte107 = this.data;
/*      */           pA_PM25_IntrPm25HiWarn = new PATypes.PA_PM25_IntrPm25HiWarn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte107));
/*      */           return pA_PM25_IntrPm25HiWarn;
/*      */         case 33401:
/*      */           this.data = (byte[])pA_PM25_IntrPm25HiWarn.getValue();
/*      */           arrayOfByte106 = this.data;
/*      */           pA_PM25_OutdPm25Lvl = new PATypes.PA_PM25_OutdPm25Lvl(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte106));
/*      */           return pA_PM25_OutdPm25Lvl;
/*      */         case 33400:
/*      */           this.data = (byte[])pA_PM25_OutdPm25Lvl.getValue();
/*      */           arrayOfByte105 = this.data;
/*      */           pA_PM25_IntPm25Lvl = new PATypes.PA_PM25_IntPm25Lvl(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte105));
/*      */           return pA_PM25_IntPm25Lvl;
/*      */         case 33399:
/*      */           this.data = (byte[])pA_PM25_IntPm25Lvl.getValue();
/*      */           arrayOfByte104 = this.data;
/*      */           pA_PM25_OutdPm25Vlu = new PATypes.PA_PM25_OutdPm25Vlu(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte104));
/*      */           return pA_PM25_OutdPm25Vlu;
/*      */         case 33398:
/*      */           this.data = (byte[])pA_PM25_OutdPm25Vlu.getValue();
/*      */           arrayOfByte103 = this.data;
/*      */           pA_PM25_IntPm25Vlu = new PATypes.PA_PM25_IntPm25Vlu(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte103));
/*      */           return pA_PM25_IntPm25Vlu;
/*      */         case 33397:
/*      */           this.data = (byte[])pA_PM25_IntPm25Vlu.getValue();
/*      */           arrayOfByte102 = this.data;
/*      */           pA_PM25_Actvn = new PATypes.PA_PM25_Actvn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte102));
/*      */           return pA_PM25_Actvn;
/*      */         case 33396:
/*      */           this.data = (byte[])pA_PM25_Actvn.getValue();
/*      */           arrayOfByte101 = this.data;
/*      */           pA_IAQC_ActnSts = new PATypes.PA_IAQC_ActnSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte101));
/*      */           return pA_IAQC_ActnSts;
/*      */         case 33395:
/*      */           this.data = (byte[])pA_IAQC_ActnSts.getValue();
/*      */           arrayOfByte100 = this.data;
/*      */           pA_SWH_AvlSts = new PATypes.PA_SWH_AvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte100));
/*      */           return pA_SWH_AvlSts;
/*      */         case 33394:
/*      */           this.data = (byte[])pA_SWH_AvlSts.getValue();
/*      */           arrayOfByte99 = this.data;
/*      */           pA_SWH_ManualLvlSts = new PATypes.PA_SWH_ManualLvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte99));
/*      */           return pA_SWH_ManualLvlSts;
/*      */         case 33393:
/*      */           this.data = (byte[])pA_SWH_ManualLvlSts.getValue();
/*      */           arrayOfByte98 = this.data;
/*      */           pA_SWH_AutoReqSts = new PATypes.PA_SWH_AutoReqSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte98));
/*      */           return pA_SWH_AutoReqSts;
/*      */         case 33392:
/*      */           this.data = (byte[])pA_SWH_AutoReqSts.getValue();
/*      */           arrayOfByte97 = this.data;
/*      */           pA_SWH_Actvn = new PATypes.PA_SWH_Actvn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte97));
/*      */           return pA_SWH_Actvn;
/*      */         case 33391:
/*      */           this.data = (byte[])pA_SWH_Actvn.getValue();
/*      */           arrayOfByte96 = this.data;
/*      */           pA_SCV_FirstRiAvlSts = new PATypes.PA_SCV_FirstRiAvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte96));
/*      */           return pA_SCV_FirstRiAvlSts;
/*      */         case 33390:
/*      */           this.data = (byte[])pA_SCV_FirstRiAvlSts.getValue();
/*      */           arrayOfByte95 = this.data;
/*      */           pA_SCV_FirstLeAvlSts = new PATypes.PA_SCV_FirstLeAvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte95));
/*      */           return pA_SCV_FirstLeAvlSts;
/*      */         case 33389:
/*      */           this.data = (byte[])pA_SCV_FirstLeAvlSts.getValue();
/*      */           arrayOfByte94 = this.data;
/*      */           pA_SCV_FirstRiTmrSts = new PATypes.PA_SCV_FirstRiTmrSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte94));
/*      */           return pA_SCV_FirstRiTmrSts;
/*      */         case 33388:
/*      */           this.data = (byte[])pA_SCV_FirstRiTmrSts.getValue();
/*      */           arrayOfByte93 = this.data;
/*      */           pA_SCV_FirstLeTmrSts = new PATypes.PA_SCV_FirstLeTmrSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte93));
/*      */           return pA_SCV_FirstLeTmrSts;
/*      */         case 33387:
/*      */           this.data = (byte[])pA_SCV_FirstLeTmrSts.getValue();
/*      */           arrayOfByte92 = this.data;
/*      */           pA_SCV_FirstRiLvlSts = new PATypes.PA_SCV_FirstRiLvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte92));
/*      */           return pA_SCV_FirstRiLvlSts;
/*      */         case 33386:
/*      */           this.data = (byte[])pA_SCV_FirstRiLvlSts.getValue();
/*      */           arrayOfByte91 = this.data;
/*      */           pA_SCV_FirstLeLvlSts = new PATypes.PA_SCV_FirstLeLvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte91));
/*      */           return pA_SCV_FirstLeLvlSts;
/*      */         case 33385:
/*      */           this.data = (byte[])pA_SCV_FirstLeLvlSts.getValue();
/*      */           arrayOfByte90 = this.data;
/*      */           pA_SCV_FirstActvn = new PATypes.PA_SCV_FirstActvn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte90));
/*      */           return pA_SCV_FirstActvn;
/*      */         case 33384:
/*      */           this.data = (byte[])pA_SCV_FirstActvn.getValue();
/*      */           arrayOfByte89 = this.data;
/*      */           pA_SCH_SecRiAvlSts = new PATypes.PA_SCH_SecRiAvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte89));
/*      */           return pA_SCH_SecRiAvlSts;
/*      */         case 33383:
/*      */           this.data = (byte[])pA_SCH_SecRiAvlSts.getValue();
/*      */           arrayOfByte88 = this.data;
/*      */           pA_SCH_SecLeAvlSts = new PATypes.PA_SCH_SecLeAvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte88));
/*      */           return pA_SCH_SecLeAvlSts;
/*      */         case 33382:
/*      */           this.data = (byte[])pA_SCH_SecLeAvlSts.getValue();
/*      */           arrayOfByte87 = this.data;
/*      */           pA_SCH_FirstRiAvlSts = new PATypes.PA_SCH_FirstRiAvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte87));
/*      */           return pA_SCH_FirstRiAvlSts;
/*      */         case 33381:
/*      */           this.data = (byte[])pA_SCH_FirstRiAvlSts.getValue();
/*      */           arrayOfByte86 = this.data;
/*      */           pA_SCH_FirstLeAvlSts = new PATypes.PA_SCH_FirstLeAvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte86));
/*      */           return pA_SCH_FirstLeAvlSts;
/*      */         case 33380:
/*      */           this.data = (byte[])pA_SCH_FirstLeAvlSts.getValue();
/*      */           arrayOfByte85 = this.data;
/*      */           pA_SCH_SecRiTmrSts = new PATypes.PA_SCH_SecRiTmrSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte85));
/*      */           return pA_SCH_SecRiTmrSts;
/*      */         case 33379:
/*      */           this.data = (byte[])pA_SCH_SecRiTmrSts.getValue();
/*      */           arrayOfByte84 = this.data;
/*      */           pA_SCH_SecLeTmrSts = new PATypes.PA_SCH_SecLeTmrSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte84));
/*      */           return pA_SCH_SecLeTmrSts;
/*      */         case 33378:
/*      */           this.data = (byte[])pA_SCH_SecLeTmrSts.getValue();
/*      */           arrayOfByte83 = this.data;
/*      */           pA_SCH_FirstRiTmrSts = new PATypes.PA_SCH_FirstRiTmrSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte83));
/*      */           return pA_SCH_FirstRiTmrSts;
/*      */         case 33377:
/*      */           this.data = (byte[])pA_SCH_FirstRiTmrSts.getValue();
/*      */           arrayOfByte82 = this.data;
/*      */           pA_SCH_FirstLeTmrSts = new PATypes.PA_SCH_FirstLeTmrSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte82));
/*      */           return pA_SCH_FirstLeTmrSts;
/*      */         case 33376:
/*      */           this.data = (byte[])pA_SCH_FirstLeTmrSts.getValue();
/*      */           arrayOfByte81 = this.data;
/*      */           pA_SCH_SecRiLvlSts = new PATypes.PA_SCH_SecRiLvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte81));
/*      */           return pA_SCH_SecRiLvlSts;
/*      */         case 33375:
/*      */           this.data = (byte[])pA_SCH_SecRiLvlSts.getValue();
/*      */           arrayOfByte80 = this.data;
/*      */           pA_SCH_SecLeLvlSts = new PATypes.PA_SCH_SecLeLvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte80));
/*      */           return pA_SCH_SecLeLvlSts;
/*      */         case 33374:
/*      */           this.data = (byte[])pA_SCH_SecLeLvlSts.getValue();
/*      */           arrayOfByte79 = this.data;
/*      */           pA_SCH_FirstRiLvlSts = new PATypes.PA_SCH_FirstRiLvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte79));
/*      */           return pA_SCH_FirstRiLvlSts;
/*      */         case 33373:
/*      */           this.data = (byte[])pA_SCH_FirstRiLvlSts.getValue();
/*      */           arrayOfByte78 = this.data;
/*      */           pA_SCH_FirstLeLvlSts = new PATypes.PA_SCH_FirstLeLvlSts(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte78));
/*      */           return pA_SCH_FirstLeLvlSts;
/*      */         case 33372:
/*      */           this.data = (byte[])pA_SCH_FirstLeLvlSts.getValue();
/*      */           arrayOfByte77 = this.data;
/*      */           pA_SCH_SecActvn = new PATypes.PA_SCH_SecActvn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte77));
/*      */           return pA_SCH_SecActvn;
/*      */         case 33371:
/*      */           this.data = (byte[])pA_SCH_SecActvn.getValue();
/*      */           arrayOfByte76 = this.data;
/*      */           pA_SCH_FirstActvn = new PATypes.PA_SCH_FirstActvn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte76));
/*      */           return pA_SCH_FirstActvn;
/*      */         case 33370:
/*      */           this.data = (byte[])pA_SCH_FirstActvn.getValue();
/*      */           arrayOfByte75 = this.data;
/*      */           pA_CL_ModeFrstLeft_ByHardKey = new PATypes.PA_CL_ModeFrstLeft_ByHardKey(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte75));
/*      */           return pA_CL_ModeFrstLeft_ByHardKey;
/*      */         case 33369:
/*      */           this.data = (byte[])pA_CL_ModeFrstLeft_ByHardKey.getValue();
/*      */           arrayOfByte74 = this.data;
/*      */           pA_CL_LeftTemp_ByHardKey = new PATypes.PA_CL_LeftTemp_ByHardKey(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte74));
/*      */           return pA_CL_LeftTemp_ByHardKey;
/*      */         case 33368:
/*      */           this.data = (byte[])pA_CL_LeftTemp_ByHardKey.getValue();
/*      */           arrayOfByte73 = this.data;
/*      */           pA_CL_FanLevel_ByHardKey = new PATypes.PA_CL_FanLevel_ByHardKey(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte73));
/*      */           return pA_CL_FanLevel_ByHardKey;
/*      */         case 33367:
/*      */           this.data = (byte[])pA_CL_FanLevel_ByHardKey.getValue();
/*      */           arrayOfByte72 = this.data;
/*      */           pA_CL_InteCleanUnpleSmell = new PATypes.PA_CL_InteCleanUnpleSmell(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte72));
/*      */           return pA_CL_InteCleanUnpleSmell;
/*      */         case 33366:
/*      */           this.data = (byte[])pA_CL_InteCleanUnpleSmell.getValue();
/*      */           arrayOfByte71 = this.data;
/*      */           pA_CL_ElecDefRunErr = new PATypes.PA_CL_ElecDefRunErr(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte71));
/*      */           return pA_CL_ElecDefRunErr;
/*      */         case 33365:
/*      */           this.data = (byte[])pA_CL_ElecDefRunErr.getValue();
/*      */           arrayOfByte70 = this.data;
/*      */           pA_CL_CCSMPopUp = new PATypes.PA_CL_CCSMPopUp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte70));
/*      */           return pA_CL_CCSMPopUp;
/*      */         case 33364:
/*      */           this.data = (byte[])pA_CL_CCSMPopUp.getValue();
/*      */           pA_CL_PassElecAir = new PATypes.PA_CL_PassElecAir(VendorVehicleHalPAProto.Elecairalldata.parseFrom(this.data));
/*      */           return pA_CL_PassElecAir;
/*      */         case 33363:
/*      */           this.data = (byte[])pA_CL_PassElecAir.getValue();
/*      */           pA_CL_DrvElecAir = new PATypes.PA_CL_DrvElecAir(VendorVehicleHalPAProto.Elecairalldata.parseFrom(this.data));
/*      */           return pA_CL_DrvElecAir;
/*      */         case 33362:
/*      */           this.data = (byte[])pA_CL_DrvElecAir.getValue();
/*      */           arrayOfByte69 = this.data;
/*      */           pA_CL_GClean = new PATypes.PA_CL_GClean(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte69));
/*      */           return pA_CL_GClean;
/*      */         case 33361:
/*      */           this.data = (byte[])pA_CL_GClean.getValue();
/*      */           arrayOfByte68 = this.data;
/*      */           pA_CL_SecAutoSw = new PATypes.PA_CL_SecAutoSw(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte68));
/*      */           return pA_CL_SecAutoSw;
/*      */         case 33360:
/*      */           this.data = (byte[])pA_CL_SecAutoSw.getValue();
/*      */           arrayOfByte67 = this.data;
/*      */           pA_CL_SecLockClimaSw = new PATypes.PA_CL_SecLockClimaSw(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte67));
/*      */           return pA_CL_SecLockClimaSw;
/*      */         case 33359:
/*      */           this.data = (byte[])pA_CL_SecLockClimaSw.getValue();
/*      */           arrayOfByte66 = this.data;
/*      */           pA_CL_TWinRfClsdPopSw = new PATypes.PA_CL_TWinRfClsdPopSw(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte66));
/*      */           return pA_CL_TWinRfClsdPopSw;
/*      */         case 33358:
/*      */           this.data = (byte[])pA_CL_TWinRfClsdPopSw.getValue();
/*      */           arrayOfByte65 = this.data;
/*      */           pA_CL_ElecAirAvlStsPop = new PATypes.PA_CL_ElecAirAvlStsPop(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte65));
/*      */           return pA_CL_ElecAirAvlStsPop;
/*      */         case 33357:
/*      */           this.data = (byte[])pA_CL_ElecAirAvlStsPop.getValue();
/*      */           arrayOfByte64 = this.data;
/*      */           pA_CL_PassSwt = new PATypes.PA_CL_PassSwt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte64));
/*      */           return pA_CL_PassSwt;
/*      */         case 33356:
/*      */           this.data = (byte[])pA_CL_PassSwt.getValue();
/*      */           arrayOfByte63 = this.data;
/*      */           pA_CL_DrvSwt = new PATypes.PA_CL_DrvSwt(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte63));
/*      */           return pA_CL_DrvSwt;
/*      */         case 33355:
/*      */           this.data = (byte[])pA_CL_DrvSwt.getValue();
/*      */           arrayOfByte62 = this.data;
/*      */           pA_CL_ClmCloseWinPop = new PATypes.PA_CL_ClmCloseWinPop(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte62));
/*      */           return pA_CL_ClmCloseWinPop;
/*      */         case 33354:
/*      */           this.data = (byte[])pA_CL_ClmCloseWinPop.getValue();
/*      */           arrayOfByte61 = this.data;
/*      */           pA_CL_WipReSrvMod = new PATypes.PA_CL_WipReSrvMod(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte61));
/*      */           return pA_CL_WipReSrvMod;
/*      */         case 33353:
/*      */           this.data = (byte[])pA_CL_WipReSrvMod.getValue();
/*      */           arrayOfByte60 = this.data;
/*      */           pA_CL_WipFrntSrvMod = new PATypes.PA_CL_WipFrntSrvMod(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte60));
/*      */           return pA_CL_WipFrntSrvMod;
/*      */         case 33352:
/*      */           this.data = (byte[])pA_CL_WipFrntSrvMod.getValue();
/*      */           arrayOfByte59 = this.data;
/*      */           pA_CL_WipReAutReq = new PATypes.PA_CL_WipReAutReq(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte59));
/*      */           return pA_CL_WipReAutReq;
/*      */         case 33351:
/*      */           this.data = (byte[])pA_CL_WipReAutReq.getValue();
/*      */           arrayOfByte58 = this.data;
/*      */           pA_CL_IntelliClimaPop = new PATypes.PA_CL_IntelliClimaPop(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte58));
/*      */           return pA_CL_IntelliClimaPop;
/*      */         case 33350:
/*      */           this.data = (byte[])pA_CL_IntelliClimaPop.getValue();
/*      */           arrayOfByte57 = this.data;
/*      */           pA_CL_HumPop = new PATypes.PA_CL_HumPop(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte57));
/*      */           return pA_CL_HumPop;
/*      */         case 33349:
/*      */           this.data = (byte[])pA_CL_HumPop.getValue();
/*      */           arrayOfByte56 = this.data;
/*      */           pA_CL_HumCtrl = new PATypes.PA_CL_HumCtrl(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte56));
/*      */           return pA_CL_HumCtrl;
/*      */         case 33348:
/*      */           this.data = (byte[])pA_CL_HumCtrl.getValue();
/*      */           arrayOfByte55 = this.data;
/*      */           pA_CL_PostClimaWarn = new PATypes.PA_CL_PostClimaWarn(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte55));
/*      */           return pA_CL_PostClimaWarn;
/*      */         case 33347:
/*      */           this.data = (byte[])pA_CL_PostClimaWarn.getValue();
/*      */           arrayOfByte54 = this.data;
/*      */           pA_CL_SecRowOnOffSwith = new PATypes.PA_CL_SecRowOnOffSwith(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte54));
/*      */           return pA_CL_SecRowOnOffSwith;
/*      */         case 33346:
/*      */           this.data = (byte[])pA_CL_SecRowOnOffSwith.getValue();
/*      */           arrayOfByte53 = this.data;
/*      */           pA_CL_RearDefrostPopup = new PATypes.PA_CL_RearDefrostPopup(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte53));
/*      */           return pA_CL_RearDefrostPopup;
/*      */         case 33345:
/*      */           this.data = (byte[])pA_CL_RearDefrostPopup.getValue();
/*      */           arrayOfByte52 = this.data;
/*      */           pA_CL_FrntDefrostPopup = new PATypes.PA_CL_FrntDefrostPopup(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte52));
/*      */           return pA_CL_FrntDefrostPopup;
/*      */         case 33344:
/*      */           this.data = (byte[])pA_CL_FrntDefrostPopup.getValue();
/*      */           arrayOfByte51 = this.data;
/*      */           pA_CL_AutoDefrostPopup = new PATypes.PA_CL_AutoDefrostPopup(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte51));
/*      */           return pA_CL_AutoDefrostPopup;
/*      */         case 33343:
/*      */           this.data = (byte[])pA_CL_AutoDefrostPopup.getValue();
/*      */           arrayOfByte50 = this.data;
/*      */           pA_CL_AutoDefrostSetting = new PATypes.PA_CL_AutoDefrostSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte50));
/*      */           return pA_CL_AutoDefrostSetting;
/*      */         case 33342:
/*      */           this.data = (byte[])pA_CL_AutoDefrostSetting.getValue();
/*      */           arrayOfByte49 = this.data;
/*      */           pA_CL_SecFanLevel = new PATypes.PA_CL_SecFanLevel(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte49));
/*      */           return pA_CL_SecFanLevel;
/*      */         case 33341:
/*      */           this.data = (byte[])pA_CL_SecFanLevel.getValue();
/*      */           arrayOfByte48 = this.data;
/*      */           pA_CL_SecRightTemp = new PATypes.PA_CL_SecRightTemp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte48));
/*      */           return pA_CL_SecRightTemp;
/*      */         case 33340:
/*      */           this.data = (byte[])pA_CL_SecRightTemp.getValue();
/*      */           arrayOfByte47 = this.data;
/*      */           pA_CL_SecLeftTemp = new PATypes.PA_CL_SecLeftTemp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte47));
/*      */           return pA_CL_SecLeftTemp;
/*      */         case 33339:
/*      */           this.data = (byte[])pA_CL_SecLeftTemp.getValue();
/*      */           arrayOfByte46 = this.data;
/*      */           pA_CL_HvacReCtr = new PATypes.PA_CL_HvacReCtr(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte46));
/*      */           return pA_CL_HvacReCtr;
/*      */         case 33338:
/*      */           this.data = (byte[])pA_CL_HvacReCtr.getValue();
/*      */           arrayOfByte45 = this.data;
/*      */           pA_CL_AirCtrlOff = new PATypes.PA_CL_AirCtrlOff(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte45));
/*      */           return pA_CL_AirCtrlOff;
/*      */         case 33337:
/*      */           this.data = (byte[])pA_CL_AirCtrlOff.getValue();
/*      */           arrayOfByte44 = this.data;
/*      */           pA_CL_Post = new PATypes.PA_CL_Post(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte44));
/*      */           return pA_CL_Post;
/*      */         case 33336:
/*      */           this.data = (byte[])pA_CL_Post.getValue();
/*      */           arrayOfByte43 = this.data;
/*      */           pA_CL_Pre = new PATypes.PA_CL_Pre(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte43));
/*      */           return pA_CL_Pre;
/*      */         case 33335:
/*      */           this.data = (byte[])pA_CL_Pre.getValue();
/*      */           arrayOfByte42 = this.data;
/*      */           pA_CL_ECOClimate = new PATypes.PA_CL_ECOClimate(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte42));
/*      */           return pA_CL_ECOClimate;
/*      */         case 33334:
/*      */           this.data = (byte[])pA_CL_ECOClimate.getValue();
/*      */           arrayOfByte41 = this.data;
/*      */           pA_CL_Sync = new PATypes.PA_CL_Sync(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte41));
/*      */           return pA_CL_Sync;
/*      */         case 33333:
/*      */           this.data = (byte[])pA_CL_Sync.getValue();
/*      */           arrayOfByte40 = this.data;
/*      */           pA_CL_RearDefrost = new PATypes.PA_CL_RearDefrost(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte40));
/*      */           return pA_CL_RearDefrost;
/*      */         case 33332:
/*      */           this.data = (byte[])pA_CL_RearDefrost.getValue();
/*      */           arrayOfByte39 = this.data;
/*      */           pA_CL_FrontDefrost = new PATypes.PA_CL_FrontDefrost(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte39));
/*      */           return pA_CL_FrontDefrost;
/*      */         case 33331:
/*      */           this.data = (byte[])pA_CL_FrontDefrost.getValue();
/*      */           arrayOfByte38 = this.data;
/*      */           pA_WDC_AutoRearDefrost = new PATypes.PA_WDC_AutoRearDefrost(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte38));
/*      */           return pA_WDC_AutoRearDefrost;
/*      */         case 33330:
/*      */           this.data = (byte[])pA_WDC_AutoRearDefrost.getValue();
/*      */           arrayOfByte37 = this.data;
/*      */           pA_WDC_AutoFrontDefrost = new PATypes.PA_WDC_AutoFrontDefrost(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte37));
/*      */           return pA_WDC_AutoFrontDefrost;
/*      */         case 33329:
/*      */           this.data = (byte[])pA_WDC_AutoFrontDefrost.getValue();
/*      */           arrayOfByte36 = this.data;
/*      */           pA_CL_MaxDefrost = new PATypes.PA_CL_MaxDefrost(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte36));
/*      */           return pA_CL_MaxDefrost;
/*      */         case 33328:
/*      */           this.data = (byte[])pA_CL_MaxDefrost.getValue();
/*      */           arrayOfByte35 = this.data;
/*      */           pA_CL_AutoSetting = new PATypes.PA_CL_AutoSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte35));
/*      */           return pA_CL_AutoSetting;
/*      */         case 33327:
/*      */           this.data = (byte[])pA_CL_AutoSetting.getValue();
/*      */           arrayOfByte34 = this.data;
/*      */           pA_CL_RecircSetting = new PATypes.PA_CL_RecircSetting(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte34));
/*      */           return pA_CL_RecircSetting;
/*      */         case 33326:
/*      */           this.data = (byte[])pA_CL_RecircSetting.getValue();
/*      */           arrayOfByte33 = this.data;
/*      */           pA_CL_RightTemp = new PATypes.PA_CL_RightTemp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte33));
/*      */           return pA_CL_RightTemp;
/*      */         case 33325:
/*      */           this.data = (byte[])pA_CL_RightTemp.getValue();
/*      */           arrayOfByte32 = this.data;
/*      */           pA_CL_LeftTemp = new PATypes.PA_CL_LeftTemp(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte32));
/*      */           return pA_CL_LeftTemp;
/*      */         case 33324:
/*      */           this.data = (byte[])pA_CL_LeftTemp.getValue();
/*      */           arrayOfByte31 = this.data;
/*      */           pA_CL_FanLevel = new PATypes.PA_CL_FanLevel(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte31));
/*      */           return pA_CL_FanLevel;
/*      */         case 33323:
/*      */           this.data = (byte[])pA_CL_FanLevel.getValue();
/*      */           arrayOfByte30 = this.data;
/*      */           pA_CL_MaxAC = new PATypes.PA_CL_MaxAC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte30));
/*      */           return pA_CL_MaxAC;
/*      */         case 33322:
/*      */           this.data = (byte[])pA_CL_MaxAC.getValue();
/*      */           arrayOfByte29 = this.data;
/*      */           pA_CL_ModeSec = new PATypes.PA_CL_ModeSec(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte29));
/*      */           return pA_CL_ModeSec;
/*      */         case 33321:
/*      */           this.data = (byte[])pA_CL_ModeSec.getValue();
/*      */           arrayOfByte28 = this.data;
/*      */           pA_CL_ModeFrstRight = new PATypes.PA_CL_ModeFrstRight(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte28));
/*      */           return pA_CL_ModeFrstRight;
/*      */         case 33320:
/*      */           this.data = (byte[])pA_CL_ModeFrstRight.getValue();
/*      */           arrayOfByte27 = this.data;
/*      */           pA_CL_ModeFrstLeft = new PATypes.PA_CL_ModeFrstLeft(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte27));
/*      */           return pA_CL_ModeFrstLeft;
/*      */         case 33319:
/*      */           this.data = (byte[])pA_CL_ModeFrstLeft.getValue();
/*      */           arrayOfByte26 = this.data;
/*      */           pA_CL_Recirc = new PATypes.PA_CL_Recirc(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte26));
/*      */           return pA_CL_Recirc;
/*      */         case 33318:
/*      */           this.data = (byte[])pA_CL_Recirc.getValue();
/*      */           arrayOfByte25 = this.data;
/*      */           pA_CL_Auto = new PATypes.PA_CL_Auto(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte25));
/*      */           return pA_CL_Auto;
/*      */         case 33317:
/*      */           this.data = (byte[])pA_CL_Auto.getValue();
/*      */           arrayOfByte24 = this.data;
/*      */           pA_CL_AC = new PATypes.PA_CL_AC(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte24));
/*      */           return pA_CL_AC;
/*      */         case 33316:
/*      */           this.data = (byte[])pA_CL_AC.getValue();
/*      */           arrayOfByte23 = this.data;
/*      */           pA_Asy_EMA = new PATypes.PA_Asy_EMA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte23));
/*      */           return pA_Asy_EMA;
/*      */         case 33315:
/*      */           this.data = (byte[])pA_Asy_EMA.getValue();
/*      */           arrayOfByte22 = this.data;
/*      */           pA_Asy_ELKA = new PATypes.PA_Asy_ELKA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte22));
/*      */           return pA_Asy_ELKA;
/*      */         case 33314:
/*      */           this.data = (byte[])pA_Asy_ELKA.getValue();
/*      */           arrayOfByte21 = this.data;
/*      */           pA_Asy_LKA_Warning_Mode = new PATypes.PA_Asy_LKA_Warning_Mode(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte21));
/*      */           return pA_Asy_LKA_Warning_Mode;
/*      */         case 33313:
/*      */           this.data = (byte[])pA_Asy_LKA_Warning_Mode.getValue();
/*      */           arrayOfByte20 = this.data;
/*      */           pA_Asy_LKA_Mode = new PATypes.PA_Asy_LKA_Mode(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte20));
/*      */           return pA_Asy_LKA_Mode;
/*      */         case 33312:
/*      */           this.data = (byte[])pA_Asy_LKA_Mode.getValue();
/*      */           arrayOfByte19 = this.data;
/*      */           pA_Asy_LKA = new PATypes.PA_Asy_LKA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte19));
/*      */           return pA_Asy_LKA;
/*      */         case 33311:
/*      */           this.data = (byte[])pA_Asy_LKA.getValue();
/*      */           arrayOfByte18 = this.data;
/*      */           pA_Asy_DOW = new PATypes.PA_Asy_DOW(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte18));
/*      */           return pA_Asy_DOW;
/*      */         case 33310:
/*      */           this.data = (byte[])pA_Asy_DOW.getValue();
/*      */           arrayOfByte17 = this.data;
/*      */           pA_Asy_RCTA = new PATypes.PA_Asy_RCTA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte17));
/*      */           return pA_Asy_RCTA;
/*      */         case 33309:
/*      */           this.data = (byte[])pA_Asy_RCTA.getValue();
/*      */           arrayOfByte16 = this.data;
/*      */           pA_Asy_RCW = new PATypes.PA_Asy_RCW(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte16));
/*      */           return pA_Asy_RCW;
/*      */         case 33308:
/*      */           this.data = (byte[])pA_Asy_RCW.getValue();
/*      */           arrayOfByte15 = this.data;
/*      */           pA_Asy_LCA_Warning = new PATypes.PA_Asy_LCA_Warning(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte15));
/*      */           return pA_Asy_LCA_Warning;
/*      */         case 33307:
/*      */           this.data = (byte[])pA_Asy_LCA_Warning.getValue();
/*      */           arrayOfByte14 = this.data;
/*      */           pA_Asy_LCA = new PATypes.PA_Asy_LCA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte14));
/*      */           return pA_Asy_LCA;
/*      */         case 33306:
/*      */           this.data = (byte[])pA_Asy_LCA.getValue();
/*      */           arrayOfByte13 = this.data;
/*      */           pA_Asy_CMS_Warning = new PATypes.PA_Asy_CMS_Warning(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte13));
/*      */           return pA_Asy_CMS_Warning;
/*      */         case 33305:
/*      */           this.data = (byte[])pA_Asy_CMS_Warning.getValue();
/*      */           arrayOfByte12 = this.data;
/*      */           pA_Asy_CMS = new PATypes.PA_Asy_CMS(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte12));
/*      */           return pA_Asy_CMS;
/*      */         case 33304:
/*      */           this.data = (byte[])pA_Asy_CMS.getValue();
/*      */           arrayOfByte11 = this.data;
/*      */           pA_Asy_DPS_Reminder = new PATypes.PA_Asy_DPS_Reminder(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte11));
/*      */           return pA_Asy_DPS_Reminder;
/*      */         case 33303:
/*      */           this.data = (byte[])pA_Asy_DPS_Reminder.getValue();
/*      */           arrayOfByte10 = this.data;
/*      */           pA_Asy_DPS = new PATypes.PA_Asy_DPS(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte10));
/*      */           return pA_Asy_DPS;
/*      */         case 33302:
/*      */           this.data = (byte[])pA_Asy_DPS.getValue();
/*      */           arrayOfByte9 = this.data;
/*      */           pA_Asy_ELOW = new PATypes.PA_Asy_ELOW(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte9));
/*      */           return pA_Asy_ELOW;
/*      */         case 33301:
/*      */           this.data = (byte[])pA_Asy_ELOW.getValue();
/*      */           arrayOfByte8 = this.data;
/*      */           pA_Asy_TLA_Sound_Warning = new PATypes.PA_Asy_TLA_Sound_Warning(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte8));
/*      */           return pA_Asy_TLA_Sound_Warning;
/*      */         case 33300:
/*      */           this.data = (byte[])pA_Asy_TLA_Sound_Warning.getValue();
/*      */           arrayOfByte7 = this.data;
/*      */           pA_Asy_TLA = new PATypes.PA_Asy_TLA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte7));
/*      */           return pA_Asy_TLA;
/*      */         case 33299:
/*      */           this.data = (byte[])pA_Asy_TLA.getValue();
/*      */           arrayOfByte6 = this.data;
/*      */           pA_Asy_SpeedCompensation = new PATypes.PA_Asy_SpeedCompensation(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte6));
/*      */           return pA_Asy_SpeedCompensation;
/*      */         case 33298:
/*      */           this.data = (byte[])pA_Asy_SpeedCompensation.getValue();
/*      */           arrayOfByte5 = this.data;
/*      */           pA_Asy_TSR_Warning = new PATypes.PA_Asy_TSR_Warning(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte5));
/*      */           return pA_Asy_TSR_Warning;
/*      */         case 33297:
/*      */           this.data = (byte[])pA_Asy_TSR_Warning.getValue();
/*      */           arrayOfByte4 = this.data;
/*      */           pA_Asy_OtherTSR = new PATypes.PA_Asy_OtherTSR(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte4));
/*      */           return pA_Asy_OtherTSR;
/*      */         case 33296:
/*      */           this.data = (byte[])pA_Asy_OtherTSR.getValue();
/*      */           arrayOfByte3 = this.data;
/*      */           pA_Asy_TSR = new PATypes.PA_Asy_TSR(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte3));
/*      */           return pA_Asy_TSR;
/*      */         case 33295:
/*      */           this.data = (byte[])pA_Asy_TSR.getValue();
/*      */           arrayOfByte2 = this.data;
/*      */           pA_Asy_HWA = new PATypes.PA_Asy_HWA(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte2));
/*      */           return pA_Asy_HWA;
/*      */         case 33294:
/*      */           break;
/*      */       } 
/*      */       this.data = (byte[])pA_Asy_HWA.getValue();
/*      */       byte[] arrayOfByte1 = this.data;
/*      */       return new PATypes.PA_Asy_ACCandTSR(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte1));
/*      */     } catch (Exception exception) {
/*      */       exception.printStackTrace();
/*      */     }  }
/*      */ 
/*      */   
/*      */   public void onPA_Asy_ACCandTSR(PATypes.PA_Asy_ACCandTSR paramPA_Asy_ACCandTSR) {}
/*      */   
/*      */   public void onPA_Asy_HWA(PATypes.PA_Asy_HWA paramPA_Asy_HWA) {}
/*      */   
/*      */   public void onPA_Asy_TSR(PATypes.PA_Asy_TSR paramPA_Asy_TSR) {}
/*      */   
/*      */   public void onPA_Asy_OtherTSR(PATypes.PA_Asy_OtherTSR paramPA_Asy_OtherTSR) {}
/*      */   
/*      */   public void onPA_Asy_TSR_Warning(PATypes.PA_Asy_TSR_Warning paramPA_Asy_TSR_Warning) {}
/*      */   
/*      */   public void onPA_Asy_SpeedCompensation(PATypes.PA_Asy_SpeedCompensation paramPA_Asy_SpeedCompensation) {}
/*      */   
/*      */   public void onPA_Asy_TLA(PATypes.PA_Asy_TLA paramPA_Asy_TLA) {}
/*      */   
/*      */   public void onPA_Asy_TLA_Sound_Warning(PATypes.PA_Asy_TLA_Sound_Warning paramPA_Asy_TLA_Sound_Warning) {}
/*      */   
/*      */   public void onPA_Asy_ELOW(PATypes.PA_Asy_ELOW paramPA_Asy_ELOW) {}
/*      */   
/*      */   public void onPA_Asy_DPS(PATypes.PA_Asy_DPS paramPA_Asy_DPS) {}
/*      */   
/*      */   public void onPA_Asy_DPS_Reminder(PATypes.PA_Asy_DPS_Reminder paramPA_Asy_DPS_Reminder) {}
/*      */   
/*      */   public void onPA_Asy_CMS(PATypes.PA_Asy_CMS paramPA_Asy_CMS) {}
/*      */   
/*      */   public void onPA_Asy_CMS_Warning(PATypes.PA_Asy_CMS_Warning paramPA_Asy_CMS_Warning) {}
/*      */   
/*      */   public void onPA_Asy_LCA(PATypes.PA_Asy_LCA paramPA_Asy_LCA) {}
/*      */   
/*      */   public void onPA_Asy_LCA_Warning(PATypes.PA_Asy_LCA_Warning paramPA_Asy_LCA_Warning) {}
/*      */   
/*      */   public void onPA_Asy_RCW(PATypes.PA_Asy_RCW paramPA_Asy_RCW) {}
/*      */   
/*      */   public void onPA_Asy_RCTA(PATypes.PA_Asy_RCTA paramPA_Asy_RCTA) {}
/*      */   
/*      */   public void onPA_Asy_DOW(PATypes.PA_Asy_DOW paramPA_Asy_DOW) {}
/*      */   
/*      */   public void onPA_Asy_LKA(PATypes.PA_Asy_LKA paramPA_Asy_LKA) {}
/*      */   
/*      */   public void onPA_Asy_LKA_Mode(PATypes.PA_Asy_LKA_Mode paramPA_Asy_LKA_Mode) {}
/*      */   
/*      */   public void onPA_Asy_LKA_Warning_Mode(PATypes.PA_Asy_LKA_Warning_Mode paramPA_Asy_LKA_Warning_Mode) {}
/*      */   
/*      */   public void onPA_Asy_ELKA(PATypes.PA_Asy_ELKA paramPA_Asy_ELKA) {}
/*      */   
/*      */   public void onPA_Asy_EMA(PATypes.PA_Asy_EMA paramPA_Asy_EMA) {}
/*      */   
/*      */   public void onPA_CL_AC(PATypes.PA_CL_AC paramPA_CL_AC) {}
/*      */   
/*      */   public void onPA_CL_Auto(PATypes.PA_CL_Auto paramPA_CL_Auto) {}
/*      */   
/*      */   public void onPA_CL_Recirc(PATypes.PA_CL_Recirc paramPA_CL_Recirc) {}
/*      */   
/*      */   public void onPA_CL_ModeFrstLeft(PATypes.PA_CL_ModeFrstLeft paramPA_CL_ModeFrstLeft) {}
/*      */   
/*      */   public void onPA_CL_ModeFrstRight(PATypes.PA_CL_ModeFrstRight paramPA_CL_ModeFrstRight) {}
/*      */   
/*      */   public void onPA_CL_ModeSec(PATypes.PA_CL_ModeSec paramPA_CL_ModeSec) {}
/*      */   
/*      */   public void onPA_CL_MaxAC(PATypes.PA_CL_MaxAC paramPA_CL_MaxAC) {}
/*      */   
/*      */   public void onPA_CL_FanLevel(PATypes.PA_CL_FanLevel paramPA_CL_FanLevel) {}
/*      */   
/*      */   public void onPA_CL_LeftTemp(PATypes.PA_CL_LeftTemp paramPA_CL_LeftTemp) {}
/*      */   
/*      */   public void onPA_CL_RightTemp(PATypes.PA_CL_RightTemp paramPA_CL_RightTemp) {}
/*      */   
/*      */   public void onPA_CL_RecircSetting(PATypes.PA_CL_RecircSetting paramPA_CL_RecircSetting) {}
/*      */   
/*      */   public void onPA_CL_AutoSetting(PATypes.PA_CL_AutoSetting paramPA_CL_AutoSetting) {}
/*      */   
/*      */   public void onPA_CL_MaxDefrost(PATypes.PA_CL_MaxDefrost paramPA_CL_MaxDefrost) {}
/*      */   
/*      */   public void onPA_WDC_AutoFrontDefrost(PATypes.PA_WDC_AutoFrontDefrost paramPA_WDC_AutoFrontDefrost) {}
/*      */   
/*      */   public void onPA_WDC_AutoRearDefrost(PATypes.PA_WDC_AutoRearDefrost paramPA_WDC_AutoRearDefrost) {}
/*      */   
/*      */   public void onPA_CL_FrontDefrost(PATypes.PA_CL_FrontDefrost paramPA_CL_FrontDefrost) {}
/*      */   
/*      */   public void onPA_CL_RearDefrost(PATypes.PA_CL_RearDefrost paramPA_CL_RearDefrost) {}
/*      */   
/*      */   public void onPA_CL_Sync(PATypes.PA_CL_Sync paramPA_CL_Sync) {}
/*      */   
/*      */   public void onPA_CL_ECOClimate(PATypes.PA_CL_ECOClimate paramPA_CL_ECOClimate) {}
/*      */   
/*      */   public void onPA_CL_Pre(PATypes.PA_CL_Pre paramPA_CL_Pre) {}
/*      */   
/*      */   public void onPA_CL_Post(PATypes.PA_CL_Post paramPA_CL_Post) {}
/*      */   
/*      */   public void onPA_CL_AirCtrlOff(PATypes.PA_CL_AirCtrlOff paramPA_CL_AirCtrlOff) {}
/*      */   
/*      */   public void onPA_CL_HvacReCtr(PATypes.PA_CL_HvacReCtr paramPA_CL_HvacReCtr) {}
/*      */   
/*      */   public void onPA_CL_SecLeftTemp(PATypes.PA_CL_SecLeftTemp paramPA_CL_SecLeftTemp) {}
/*      */   
/*      */   public void onPA_CL_SecRightTemp(PATypes.PA_CL_SecRightTemp paramPA_CL_SecRightTemp) {}
/*      */   
/*      */   public void onPA_CL_SecFanLevel(PATypes.PA_CL_SecFanLevel paramPA_CL_SecFanLevel) {}
/*      */   
/*      */   public void onPA_CL_AutoDefrostSetting(PATypes.PA_CL_AutoDefrostSetting paramPA_CL_AutoDefrostSetting) {}
/*      */   
/*      */   public void onPA_CL_AutoDefrostPopup(PATypes.PA_CL_AutoDefrostPopup paramPA_CL_AutoDefrostPopup) {}
/*      */   
/*      */   public void onPA_CL_FrntDefrostPopup(PATypes.PA_CL_FrntDefrostPopup paramPA_CL_FrntDefrostPopup) {}
/*      */   
/*      */   public void onPA_CL_RearDefrostPopup(PATypes.PA_CL_RearDefrostPopup paramPA_CL_RearDefrostPopup) {}
/*      */   
/*      */   public void onPA_CL_SecRowOnOffSwith(PATypes.PA_CL_SecRowOnOffSwith paramPA_CL_SecRowOnOffSwith) {}
/*      */   
/*      */   public void onPA_CL_PostClimaWarn(PATypes.PA_CL_PostClimaWarn paramPA_CL_PostClimaWarn) {}
/*      */   
/*      */   public void onPA_CL_HumCtrl(PATypes.PA_CL_HumCtrl paramPA_CL_HumCtrl) {}
/*      */   
/*      */   public void onPA_CL_HumPop(PATypes.PA_CL_HumPop paramPA_CL_HumPop) {}
/*      */   
/*      */   public void onPA_CL_IntelliClimaPop(PATypes.PA_CL_IntelliClimaPop paramPA_CL_IntelliClimaPop) {}
/*      */   
/*      */   public void onPA_CL_WipReAutReq(PATypes.PA_CL_WipReAutReq paramPA_CL_WipReAutReq) {}
/*      */   
/*      */   public void onPA_CL_WipFrntSrvMod(PATypes.PA_CL_WipFrntSrvMod paramPA_CL_WipFrntSrvMod) {}
/*      */   
/*      */   public void onPA_CL_WipReSrvMod(PATypes.PA_CL_WipReSrvMod paramPA_CL_WipReSrvMod) {}
/*      */   
/*      */   public void onPA_CL_ClmCloseWinPop(PATypes.PA_CL_ClmCloseWinPop paramPA_CL_ClmCloseWinPop) {}
/*      */   
/*      */   public void onPA_CL_DrvSwt(PATypes.PA_CL_DrvSwt paramPA_CL_DrvSwt) {}
/*      */   
/*      */   public void onPA_CL_PassSwt(PATypes.PA_CL_PassSwt paramPA_CL_PassSwt) {}
/*      */   
/*      */   public void onPA_CL_ElecAirAvlStsPop(PATypes.PA_CL_ElecAirAvlStsPop paramPA_CL_ElecAirAvlStsPop) {}
/*      */   
/*      */   public void onPA_CL_TWinRfClsdPopSw(PATypes.PA_CL_TWinRfClsdPopSw paramPA_CL_TWinRfClsdPopSw) {}
/*      */   
/*      */   public void onPA_CL_SecLockClimaSw(PATypes.PA_CL_SecLockClimaSw paramPA_CL_SecLockClimaSw) {}
/*      */   
/*      */   public void onPA_CL_SecAutoSw(PATypes.PA_CL_SecAutoSw paramPA_CL_SecAutoSw) {}
/*      */   
/*      */   public void onPA_CL_GClean(PATypes.PA_CL_GClean paramPA_CL_GClean) {}
/*      */   
/*      */   public void onPA_CL_DrvElecAir(PATypes.PA_CL_DrvElecAir paramPA_CL_DrvElecAir) {}
/*      */   
/*      */   public void onPA_CL_PassElecAir(PATypes.PA_CL_PassElecAir paramPA_CL_PassElecAir) {}
/*      */   
/*      */   public void onPA_CL_CCSMPopUp(PATypes.PA_CL_CCSMPopUp paramPA_CL_CCSMPopUp) {}
/*      */   
/*      */   public void onPA_CL_ElecDefRunErr(PATypes.PA_CL_ElecDefRunErr paramPA_CL_ElecDefRunErr) {}
/*      */   
/*      */   public void onPA_CL_InteCleanUnpleSmell(PATypes.PA_CL_InteCleanUnpleSmell paramPA_CL_InteCleanUnpleSmell) {}
/*      */   
/*      */   public void onPA_CL_FanLevel_ByHardKey(PATypes.PA_CL_FanLevel_ByHardKey paramPA_CL_FanLevel_ByHardKey) {}
/*      */   
/*      */   public void onPA_CL_LeftTemp_ByHardKey(PATypes.PA_CL_LeftTemp_ByHardKey paramPA_CL_LeftTemp_ByHardKey) {}
/*      */   
/*      */   public void onPA_CL_ModeFrstLeft_ByHardKey(PATypes.PA_CL_ModeFrstLeft_ByHardKey paramPA_CL_ModeFrstLeft_ByHardKey) {}
/*      */   
/*      */   public void onPA_SCH_FirstActvn(PATypes.PA_SCH_FirstActvn paramPA_SCH_FirstActvn) {}
/*      */   
/*      */   public void onPA_SCH_SecActvn(PATypes.PA_SCH_SecActvn paramPA_SCH_SecActvn) {}
/*      */   
/*      */   public void onPA_SCH_FirstLeLvlSts(PATypes.PA_SCH_FirstLeLvlSts paramPA_SCH_FirstLeLvlSts) {}
/*      */   
/*      */   public void onPA_SCH_FirstRiLvlSts(PATypes.PA_SCH_FirstRiLvlSts paramPA_SCH_FirstRiLvlSts) {}
/*      */   
/*      */   public void onPA_SCH_SecLeLvlSts(PATypes.PA_SCH_SecLeLvlSts paramPA_SCH_SecLeLvlSts) {}
/*      */   
/*      */   public void onPA_SCH_SecRiLvlSts(PATypes.PA_SCH_SecRiLvlSts paramPA_SCH_SecRiLvlSts) {}
/*      */   
/*      */   public void onPA_SCH_FirstLeTmrSts(PATypes.PA_SCH_FirstLeTmrSts paramPA_SCH_FirstLeTmrSts) {}
/*      */   
/*      */   public void onPA_SCH_FirstRiTmrSts(PATypes.PA_SCH_FirstRiTmrSts paramPA_SCH_FirstRiTmrSts) {}
/*      */   
/*      */   public void onPA_SCH_SecLeTmrSts(PATypes.PA_SCH_SecLeTmrSts paramPA_SCH_SecLeTmrSts) {}
/*      */   
/*      */   public void onPA_SCH_SecRiTmrSts(PATypes.PA_SCH_SecRiTmrSts paramPA_SCH_SecRiTmrSts) {}
/*      */   
/*      */   public void onPA_SCH_FirstLeAvlSts(PATypes.PA_SCH_FirstLeAvlSts paramPA_SCH_FirstLeAvlSts) {}
/*      */   
/*      */   public void onPA_SCH_FirstRiAvlSts(PATypes.PA_SCH_FirstRiAvlSts paramPA_SCH_FirstRiAvlSts) {}
/*      */   
/*      */   public void onPA_SCH_SecLeAvlSts(PATypes.PA_SCH_SecLeAvlSts paramPA_SCH_SecLeAvlSts) {}
/*      */   
/*      */   public void onPA_SCH_SecRiAvlSts(PATypes.PA_SCH_SecRiAvlSts paramPA_SCH_SecRiAvlSts) {}
/*      */   
/*      */   public void onPA_SCV_FirstActvn(PATypes.PA_SCV_FirstActvn paramPA_SCV_FirstActvn) {}
/*      */   
/*      */   public void onPA_SCV_FirstLeLvlSts(PATypes.PA_SCV_FirstLeLvlSts paramPA_SCV_FirstLeLvlSts) {}
/*      */   
/*      */   public void onPA_SCV_FirstRiLvlSts(PATypes.PA_SCV_FirstRiLvlSts paramPA_SCV_FirstRiLvlSts) {}
/*      */   
/*      */   public void onPA_SCV_FirstLeTmrSts(PATypes.PA_SCV_FirstLeTmrSts paramPA_SCV_FirstLeTmrSts) {}
/*      */   
/*      */   public void onPA_SCV_FirstRiTmrSts(PATypes.PA_SCV_FirstRiTmrSts paramPA_SCV_FirstRiTmrSts) {}
/*      */   
/*      */   public void onPA_SCV_FirstLeAvlSts(PATypes.PA_SCV_FirstLeAvlSts paramPA_SCV_FirstLeAvlSts) {}
/*      */   
/*      */   public void onPA_SCV_FirstRiAvlSts(PATypes.PA_SCV_FirstRiAvlSts paramPA_SCV_FirstRiAvlSts) {}
/*      */   
/*      */   public void onPA_SWH_Actvn(PATypes.PA_SWH_Actvn paramPA_SWH_Actvn) {}
/*      */   
/*      */   public void onPA_SWH_AutoReqSts(PATypes.PA_SWH_AutoReqSts paramPA_SWH_AutoReqSts) {}
/*      */   
/*      */   public void onPA_SWH_ManualLvlSts(PATypes.PA_SWH_ManualLvlSts paramPA_SWH_ManualLvlSts) {}
/*      */   
/*      */   public void onPA_SWH_AvlSts(PATypes.PA_SWH_AvlSts paramPA_SWH_AvlSts) {}
/*      */   
/*      */   public void onPA_IAQC_ActnSts(PATypes.PA_IAQC_ActnSts paramPA_IAQC_ActnSts) {}
/*      */   
/*      */   public void onPA_PM25_Actvn(PATypes.PA_PM25_Actvn paramPA_PM25_Actvn) {}
/*      */   
/*      */   public void onPA_PM25_IntPm25Vlu(PATypes.PA_PM25_IntPm25Vlu paramPA_PM25_IntPm25Vlu) {}
/*      */   
/*      */   public void onPA_PM25_OutdPm25Vlu(PATypes.PA_PM25_OutdPm25Vlu paramPA_PM25_OutdPm25Vlu) {}
/*      */   
/*      */   public void onPA_PM25_IntPm25Lvl(PATypes.PA_PM25_IntPm25Lvl paramPA_PM25_IntPm25Lvl) {}
/*      */   
/*      */   public void onPA_PM25_OutdPm25Lvl(PATypes.PA_PM25_OutdPm25Lvl paramPA_PM25_OutdPm25Lvl) {}
/*      */   
/*      */   public void onPA_PM25_IntrPm25HiWarn(PATypes.PA_PM25_IntrPm25HiWarn paramPA_PM25_IntrPm25HiWarn) {}
/*      */   
/*      */   public void onPA_PM25_IntPm25Sts(PATypes.PA_PM25_IntPm25Sts paramPA_PM25_IntPm25Sts) {}
/*      */   
/*      */   public void onPA_PM25_OutdPm25Sts(PATypes.PA_PM25_OutdPm25Sts paramPA_PM25_OutdPm25Sts) {}
/*      */   
/*      */   public void onPA_PM25_IncomingAirQlyPopUpReq(PATypes.PA_PM25_IncomingAirQlyPopUpReq paramPA_PM25_IncomingAirQlyPopUpReq) {}
/*      */   
/*      */   public void onPA_Fragra_Actn(PATypes.PA_Fragra_Actn paramPA_Fragra_Actn) {}
/*      */   
/*      */   public void onPA_Fragra_TypRatReqASts(PATypes.PA_Fragra_TypRatReqASts paramPA_Fragra_TypRatReqASts) {}
/*      */   
/*      */   public void onPA_Fragra_TypRatReqBSts(PATypes.PA_Fragra_TypRatReqBSts paramPA_Fragra_TypRatReqBSts) {}
/*      */   
/*      */   public void onPA_Fragra_TypRatReqCSts(PATypes.PA_Fragra_TypRatReqCSts paramPA_Fragra_TypRatReqCSts) {}
/*      */   
/*      */   public void onPA_Fragra_TypRatReqDSts(PATypes.PA_Fragra_TypRatReqDSts paramPA_Fragra_TypRatReqDSts) {}
/*      */   
/*      */   public void onPA_Fragra_TypRatReqESts(PATypes.PA_Fragra_TypRatReqESts paramPA_Fragra_TypRatReqESts) {}
/*      */   
/*      */   public void onPA_Fragra_TypRatReqFSts(PATypes.PA_Fragra_TypRatReqFSts paramPA_Fragra_TypRatReqFSts) {}
/*      */   
/*      */   public void onPA_Fragra_LvlReqSts(PATypes.PA_Fragra_LvlReqSts paramPA_Fragra_LvlReqSts) {}
/*      */   
/*      */   public void onPA_Fragra_ModReqSts(PATypes.PA_Fragra_ModReqSts paramPA_Fragra_ModReqSts) {}
/*      */   
/*      */   public void onPA_Fragra_SceneSetSts(PATypes.PA_Fragra_SceneSetSts paramPA_Fragra_SceneSetSts) {}
/*      */   
/*      */   public void onPA_Fragra_Sts(PATypes.PA_Fragra_Sts paramPA_Fragra_Sts) {}
/*      */   
/*      */   public void onPA_Fragra_RefrshReq(PATypes.PA_Fragra_RefrshReq paramPA_Fragra_RefrshReq) {}
/*      */   
/*      */   public void onPA_Fragra_Taste1ID(PATypes.PA_Fragra_Taste1ID paramPA_Fragra_Taste1ID) {}
/*      */   
/*      */   public void onPA_Fragra_Taste2ID(PATypes.PA_Fragra_Taste2ID paramPA_Fragra_Taste2ID) {}
/*      */   
/*      */   public void onPA_Fragra_Taste3ID(PATypes.PA_Fragra_Taste3ID paramPA_Fragra_Taste3ID) {}
/*      */   
/*      */   public void onPA_Fragra_Taste4ID(PATypes.PA_Fragra_Taste4ID paramPA_Fragra_Taste4ID) {}
/*      */   
/*      */   public void onPA_Fragra_Taste5ID(PATypes.PA_Fragra_Taste5ID paramPA_Fragra_Taste5ID) {}
/*      */   
/*      */   public void onPA_Fragra_Tast1UseUpRmd(PATypes.PA_Fragra_Tast1UseUpRmd paramPA_Fragra_Tast1UseUpRmd) {}
/*      */   
/*      */   public void onPA_Fragra_Tast2UseUpRmd(PATypes.PA_Fragra_Tast2UseUpRmd paramPA_Fragra_Tast2UseUpRmd) {}
/*      */   
/*      */   public void onPA_Fragra_Tast3UseUpRmd(PATypes.PA_Fragra_Tast3UseUpRmd paramPA_Fragra_Tast3UseUpRmd) {}
/*      */   
/*      */   public void onPA_Fragra_Tast4UseUpRmd(PATypes.PA_Fragra_Tast4UseUpRmd paramPA_Fragra_Tast4UseUpRmd) {}
/*      */   
/*      */   public void onPA_Fragra_Tast5UseUpRmd(PATypes.PA_Fragra_Tast5UseUpRmd paramPA_Fragra_Tast5UseUpRmd) {}
/*      */   
/*      */   public void onPA_Fragra_AirFragCh1RunngSts(PATypes.PA_Fragra_AirFragCh1RunngSts paramPA_Fragra_AirFragCh1RunngSts) {}
/*      */   
/*      */   public void onPA_Fragra_AirFragCh2RunngSts(PATypes.PA_Fragra_AirFragCh2RunngSts paramPA_Fragra_AirFragCh2RunngSts) {}
/*      */   
/*      */   public void onPA_Fragra_AirFragCh3RunngSts(PATypes.PA_Fragra_AirFragCh3RunngSts paramPA_Fragra_AirFragCh3RunngSts) {}
/*      */   
/*      */   public void onPA_Fragra_AirFragCh4RunngSts(PATypes.PA_Fragra_AirFragCh4RunngSts paramPA_Fragra_AirFragCh4RunngSts) {}
/*      */   
/*      */   public void onPA_Fragra_AirFragCh5RunngSts(PATypes.PA_Fragra_AirFragCh5RunngSts paramPA_Fragra_AirFragCh5RunngSts) {}
/*      */   
/*      */   public void onPA_Fragra_FragRefrshAutSetg(PATypes.PA_Fragra_FragRefrshAutSetg paramPA_Fragra_FragRefrshAutSetg) {}
/*      */   
/*      */   public void onPA_TCH_CupHoldrStsFd(PATypes.PA_TCH_CupHoldrStsFd paramPA_TCH_CupHoldrStsFd) {}
/*      */   
/*      */   public void onPA_TCH_CupHoldrActvAllwd(PATypes.PA_TCH_CupHoldrActvAllwd paramPA_TCH_CupHoldrActvAllwd) {}
/*      */   
/*      */   public void onPA_TCH_CupHoldrVoltgErr(PATypes.PA_TCH_CupHoldrVoltgErr paramPA_TCH_CupHoldrVoltgErr) {}
/*      */   
/*      */   public void onPA_TCH_CupHoldrAvlSts(PATypes.PA_TCH_CupHoldrAvlSts paramPA_TCH_CupHoldrAvlSts) {}
/*      */   
/*      */   public void onPA_TCH_CupHoldrOcpyFbSts(PATypes.PA_TCH_CupHoldrOcpyFbSts paramPA_TCH_CupHoldrOcpyFbSts) {}
/*      */   
/*      */   public void onPA_DriveMode_Eco(PATypes.PA_DriveMode_Eco paramPA_DriveMode_Eco) {}
/*      */   
/*      */   public void onPA_DriveMode_Comfort(PATypes.PA_DriveMode_Comfort paramPA_DriveMode_Comfort) {}
/*      */   
/*      */   public void onPA_DriveMode_Dynamic(PATypes.PA_DriveMode_Dynamic paramPA_DriveMode_Dynamic) {}
/*      */   
/*      */   public void onPA_DriveMode_Individual(PATypes.PA_DriveMode_Individual paramPA_DriveMode_Individual) {}
/*      */   
/*      */   public void onPA_DriveMode_XC(PATypes.PA_DriveMode_XC paramPA_DriveMode_XC) {}
/*      */   
/*      */   public void onPA_DriveMode_AWD(PATypes.PA_DriveMode_AWD paramPA_DriveMode_AWD) {}
/*      */   
/*      */   public void onPA_DriveMode_Save(PATypes.PA_DriveMode_Save paramPA_DriveMode_Save) {}
/*      */   
/*      */   public void onPA_DriveMode_Pure(PATypes.PA_DriveMode_Pure paramPA_DriveMode_Pure) {}
/*      */   
/*      */   public void onPA_DriveMode_Hybrid(PATypes.PA_DriveMode_Hybrid paramPA_DriveMode_Hybrid) {}
/*      */   
/*      */   public void onPA_DriveMode_Power(PATypes.PA_DriveMode_Power paramPA_DriveMode_Power) {}
/*      */   
/*      */   public void onPA_DriveMode_Snow(PATypes.PA_DriveMode_Snow paramPA_DriveMode_Snow) {}
/*      */   
/*      */   public void onPA_DriveMode_Sand(PATypes.PA_DriveMode_Sand paramPA_DriveMode_Sand) {}
/*      */   
/*      */   public void onPA_DriveMode_Mud(PATypes.PA_DriveMode_Mud paramPA_DriveMode_Mud) {}
/*      */   
/*      */   public void onPA_DriveMode_Rock(PATypes.PA_DriveMode_Rock paramPA_DriveMode_Rock) {}
/*      */   
/*      */   public void onPA_DriveMode_confirmation_timeout(PATypes.PA_DriveMode_confirmation_timeout paramPA_DriveMode_confirmation_timeout) {}
/*      */   
/*      */   public void onPA_DriveMode_active_time(PATypes.PA_DriveMode_active_time paramPA_DriveMode_active_time) {}
/*      */   
/*      */   public void onPA_DriveMode_Individual_Settings(PATypes.PA_DriveMode_Individual_Settings paramPA_DriveMode_Individual_Settings) {}
/*      */   
/*      */   public void onPA_DriveMode_Brake_Settings(PATypes.PA_DriveMode_Brake_Settings paramPA_DriveMode_Brake_Settings) {}
/*      */   
/*      */   public void onPA_DriveMode_Powertrain_Settings(PATypes.PA_DriveMode_Powertrain_Settings paramPA_DriveMode_Powertrain_Settings) {}
/*      */   
/*      */   public void onPA_DriveMode_AirConditioner_Settings(PATypes.PA_DriveMode_AirConditioner_Settings paramPA_DriveMode_AirConditioner_Settings) {}
/*      */   
/*      */   public void onPA_DriveMode_SteeringWheelAssistLevel_Settings(PATypes.PA_DriveMode_SteeringWheelAssistLevel_Settings paramPA_DriveMode_SteeringWheelAssistLevel_Settings) {}
/*      */   
/*      */   public void onPA_DriveMode_DIMTheme_Settings(PATypes.PA_DriveMode_DIMTheme_Settings paramPA_DriveMode_DIMTheme_Settings) {}
/*      */   
/*      */   public void onPA_DriveMode_Engine_StartStop(PATypes.PA_DriveMode_Engine_StartStop paramPA_DriveMode_Engine_StartStop) {}
/*      */   
/*      */   public void onPA_DriveMode_Suspension_Settings(PATypes.PA_DriveMode_Suspension_Settings paramPA_DriveMode_Suspension_Settings) {}
/*      */   
/*      */   public void onPA_DriveMode_Value(PATypes.PA_DriveMode_Value paramPA_DriveMode_Value) {}
/*      */   
/*      */   public void onPA_DriveMode_Animation(PATypes.PA_DriveMode_Animation paramPA_DriveMode_Animation) {}
/*      */   
/*      */   public void onPA_DriveMode_Adaptive(PATypes.PA_DriveMode_Adaptive paramPA_DriveMode_Adaptive) {}
/*      */   
/*      */   public void onPA_Power_Res(PATypes.PA_Power_Res paramPA_Power_Res) {}
/*      */   
/*      */   public void onPA_SysSetOfLang(PATypes.PA_SysSetOfLang paramPA_SysSetOfLang) {}
/*      */   
/*      */   public void onPA_SysSetClkFmt(PATypes.PA_SysSetClkFmt paramPA_SysSetClkFmt) {}
/*      */   
/*      */   public void onPA_SysSetDateFmt(PATypes.PA_SysSetDateFmt paramPA_SysSetDateFmt) {}
/*      */   
/*      */   public void onPA_SysSetTempUnit(PATypes.PA_SysSetTempUnit paramPA_SysSetTempUnit) {}
/*      */   
/*      */   public void onPA_SysSetFuCnsUnit(PATypes.PA_SysSetFuCnsUnit paramPA_SysSetFuCnsUnit) {}
/*      */   
/*      */   public void onPA_SysSetSpdUnit(PATypes.PA_SysSetSpdUnit paramPA_SysSetSpdUnit) {}
/*      */   
/*      */   public void onPA_SysSetVolUnit(PATypes.PA_SysSetVolUnit paramPA_SysSetVolUnit) {}
/*      */   
/*      */   public void onPA_SysSetDstLong(PATypes.PA_SysSetDstLong paramPA_SysSetDstLong) {}
/*      */   
/*      */   public void onPA_SysSetPUnit(PATypes.PA_SysSetPUnit paramPA_SysSetPUnit) {}
/*      */   
/*      */   public void onPA_BackBrightness(PATypes.PA_BackBrightness paramPA_BackBrightness) {}
/*      */   
/*      */   public void onPA_DayNightMode(PATypes.PA_DayNightMode paramPA_DayNightMode) {}
/*      */   
/*      */   public void onPA_CSDBrightness(PATypes.PA_CSDBrightness paramPA_CSDBrightness) {}
/*      */   
/*      */   public void onPA_PSDBrightness(PATypes.PA_PSDBrightness paramPA_PSDBrightness) {}
/*      */   
/*      */   public void onPA_t_dim_fast(PATypes.PA_t_dim_fast paramPA_t_dim_fast) {}
/*      */   
/*      */   public void onPA_t_dim_slow(PATypes.PA_t_dim_slow paramPA_t_dim_slow) {}
/*      */   
/*      */   public void onPA_t_dim_rheo(PATypes.PA_t_dim_rheo paramPA_t_dim_rheo) {}
/*      */   
/*      */   public void onPA_LcfgDftBckVal(PATypes.PA_LcfgDftBckVal paramPA_LcfgDftBckVal) {}
/*      */   
/*      */   public void onPA_LcfgCsdDayVal(PATypes.PA_LcfgCsdDayVal paramPA_LcfgCsdDayVal) {}
/*      */   
/*      */   public void onPA_LcfgCsdNightVal(PATypes.PA_LcfgCsdNightVal paramPA_LcfgCsdNightVal) {}
/*      */   
/*      */   public void onPA_LcfgPsdDayVal(PATypes.PA_LcfgPsdDayVal paramPA_LcfgPsdDayVal) {}
/*      */   
/*      */   public void onPA_LcfgPsdNightVal(PATypes.PA_LcfgPsdNightVal paramPA_LcfgPsdNightVal) {}
/*      */   
/*      */   public void onPA_LinkSwitch(PATypes.PA_LinkSwitch paramPA_LinkSwitch) {}
/*      */   
/*      */   public void onPA_PowerSoftKeySwitch(PATypes.PA_PowerSoftKeySwitch paramPA_PowerSoftKeySwitch) {}
/*      */   
/*      */   public void onPA_PowerSoftKeyBrightness(PATypes.PA_PowerSoftKeyBrightness paramPA_PowerSoftKeyBrightness) {}
/*      */   
/*      */   public void onPA_SAP_PrkgUnlck(PATypes.PA_SAP_PrkgUnlck paramPA_SAP_PrkgUnlck) {}
/*      */   
/*      */   public void onPA_VIN_VinNum(PATypes.PA_VIN_VinNum paramPA_VIN_VinNum) {}
/*      */   
/*      */   public void onPA_VP_Version(PATypes.PA_VP_Version paramPA_VP_Version) {}
/*      */   
/*      */   public void onPA_Device_IHUID(PATypes.PA_Device_IHUID paramPA_Device_IHUID) {}
/*      */   
/*      */   public void onPA_Device_SN(PATypes.PA_Device_SN paramPA_Device_SN) {}
/*      */   
/*      */   public void onPA_Device_VPVersion_HD(PATypes.PA_Device_VPVersion_HD paramPA_Device_VPVersion_HD) {}
/*      */   
/*      */   public void onPA_Device_Project_Code(PATypes.PA_Device_Project_Code paramPA_Device_Project_Code) {}
/*      */   
/*      */   public void onPA_Device_Supplier_Code(PATypes.PA_Device_Supplier_Code paramPA_Device_Supplier_Code) {}
/*      */   
/*      */   public void onPA_VF_HUD_ActvSts(PATypes.PA_VF_HUD_ActvSts paramPA_VF_HUD_ActvSts) {}
/*      */   
/*      */   public void onPA_VF_HUD_IllmnReq(PATypes.PA_VF_HUD_IllmnReq paramPA_VF_HUD_IllmnReq) {}
/*      */   
/*      */   public void onPA_VF_HUD_ErgoAdjmtReq(PATypes.PA_VF_HUD_ErgoAdjmtReq paramPA_VF_HUD_ErgoAdjmtReq) {}
/*      */   
/*      */   public void onPA_VF_HUD_ImgRotAdjmtReq(PATypes.PA_VF_HUD_ImgRotAdjmtReq paramPA_VF_HUD_ImgRotAdjmtReq) {}
/*      */   
/*      */   public void onPA_VF_HUD_HudRstForSetgAndData(PATypes.PA_VF_HUD_HudRstForSetgAndData paramPA_VF_HUD_HudRstForSetgAndData) {}
/*      */   
/*      */   public void onPA_VF_HUD_HudSnowModeReq(PATypes.PA_VF_HUD_HudSnowModeReq paramPA_VF_HUD_HudSnowModeReq) {}
/*      */   
/*      */   public void onPA_VF_HUD_ARActvSts(PATypes.PA_VF_HUD_ARActvSts paramPA_VF_HUD_ARActvSts) {}
/*      */   
/*      */   public void onPA_VF_HUD_ARD300Data(PATypes.PA_VF_HUD_ARD300Data paramPA_VF_HUD_ARD300Data) {}
/*      */   
/*      */   public void onPA_VF_HUD_ARD310Data(PATypes.PA_VF_HUD_ARD310Data paramPA_VF_HUD_ARD310Data) {}
/*      */   
/*      */   public void onPA_VF_HUD_ARD311Data(PATypes.PA_VF_HUD_ARD311Data paramPA_VF_HUD_ARD311Data) {}
/*      */   
/*      */   public void onPA_VFC_IPWakeup(PATypes.PA_VFC_IPWakeup paramPA_VFC_IPWakeup) {}
/*      */   
/*      */   public void onPA_VFC_ParkAssiCtrlForHmiCen(PATypes.PA_VFC_ParkAssiCtrlForHmiCen paramPA_VFC_ParkAssiCtrlForHmiCen) {}
/*      */   
/*      */   public void onPA_VFC_FaceIdnForHmiCen(PATypes.PA_VFC_FaceIdnForHmiCen paramPA_VFC_FaceIdnForHmiCen) {}
/*      */   
/*      */   public void onPA_VFC_TelephoneManager(PATypes.PA_VFC_TelephoneManager paramPA_VFC_TelephoneManager) {}
/*      */   
/*      */   public void onPA_VFC_SetVehCenClkIndcnAndSetg(PATypes.PA_VFC_SetVehCenClkIndcnAndSetg paramPA_VFC_SetVehCenClkIndcnAndSetg) {}
/*      */   
/*      */   public void onPA_VFC_SetVehPrivateLock(PATypes.PA_VFC_SetVehPrivateLock paramPA_VFC_SetVehPrivateLock) {}
/*      */   
/*      */   public void onPA_VFC_SetVehApa(PATypes.PA_VFC_SetVehApa paramPA_VFC_SetVehApa) {}
/*      */   
/*      */   public void onPA_VFC_SetVehAvm(PATypes.PA_VFC_SetVehAvm paramPA_VFC_SetVehAvm) {}
/*      */   
/*      */   public void onPA_VFC_SetVehTcam(PATypes.PA_VFC_SetVehTcam paramPA_VFC_SetVehTcam) {}
/*      */   
/*      */   public void onPA_VFC_SetVehDvr(PATypes.PA_VFC_SetVehDvr paramPA_VFC_SetVehDvr) {}
/*      */   
/*      */   public void onPA_VFCSetVehCharging(PATypes.PA_VFCSetVehCharging paramPA_VFCSetVehCharging) {}
/*      */   
/*      */   public void onPA_VFCGenChaSettingsForHmiCen(PATypes.PA_VFCGenChaSettingsForHmiCen paramPA_VFCGenChaSettingsForHmiCen) {}
/*      */   
/*      */   public void onPA_VFCNavigationInfoSharing(PATypes.PA_VFCNavigationInfoSharing paramPA_VFCNavigationInfoSharing) {}
/*      */   
/*      */   public void onPA_VFC_ExteriorLightShowWin(PATypes.PA_VFC_ExteriorLightShowWin paramPA_VFC_ExteriorLightShowWin) {}
/*      */   
/*      */   public void onPA_VFC_ExteriorLightShow(PATypes.PA_VFC_ExteriorLightShow paramPA_VFC_ExteriorLightShow) {}
/*      */   
/*      */   public void onPA_VFC_VFCRsrv1(PATypes.PA_VFC_VFCRsrv1 paramPA_VFC_VFCRsrv1) {}
/*      */   
/*      */   public void onPA_VFC_VFCRsrv2(PATypes.PA_VFC_VFCRsrv2 paramPA_VFC_VFCRsrv2) {}
/*      */   
/*      */   public void onPA_VFC_VFCRsrv3(PATypes.PA_VFC_VFCRsrv3 paramPA_VFC_VFCRsrv3) {}
/*      */   
/*      */   public void onPA_VFC_VFCRsrv4(PATypes.PA_VFC_VFCRsrv4 paramPA_VFC_VFCRsrv4) {}
/*      */   
/*      */   public void onPA_VFC_VFCRsrv5(PATypes.PA_VFC_VFCRsrv5 paramPA_VFC_VFCRsrv5) {}
/*      */   
/*      */   public void onPA_VFC_SetVehFace(PATypes.PA_VFC_SetVehFace paramPA_VFC_SetVehFace) {}
/*      */   
/*      */   public void onPA_VFC_VFC_Reboot(PATypes.PA_VFC_VFC_Reboot paramPA_VFC_VFC_Reboot) {}
/*      */   
/*      */   public void onPA_VFC_SceneModePDC(PATypes.PA_VFC_SceneModePDC paramPA_VFC_SceneModePDC) {}
/*      */   
/*      */   public void onPA_VFC_SetVehSceneMode(PATypes.PA_VFC_SetVehSceneMode paramPA_VFC_SetVehSceneMode) {}
/*      */   
/*      */   public void onPA_McuLog_Panic(PATypes.PA_McuLog_Panic paramPA_McuLog_Panic) {}
/*      */   
/*      */   public void onPA_AR_WarningVlo(PATypes.PA_AR_WarningVlo paramPA_AR_WarningVlo) {}
/*      */   
/*      */   public void onPA_ErrorReport(PATypes.PA_ErrorReport paramPA_ErrorReport) {}
/*      */   
/*      */   public void onPA_DspVersion(PATypes.PA_DspVersion paramPA_DspVersion) {}
/*      */   
/*      */   public void onPA_PAC_SwtDispOnAndOffStsResp(PATypes.PA_PAC_SwtDispOnAndOffStsResp paramPA_PAC_SwtDispOnAndOffStsResp) {}
/*      */   
/*      */   public void onPA_PAC_TxStrtVisReq(PATypes.PA_PAC_TxStrtVisReq paramPA_PAC_TxStrtVisReq) {}
/*      */   
/*      */   public void onPA_PAC_VisnImgAgWide2DInUse(PATypes.PA_PAC_VisnImgAgWide2DInUse paramPA_PAC_VisnImgAgWide2DInUse) {}
/*      */   
/*      */   public void onPA_PAC_VisnImgAgWide3DInUse(PATypes.PA_PAC_VisnImgAgWide3DInUse paramPA_PAC_VisnImgAgWide3DInUse) {}
/*      */   
/*      */   public void onPA_PAC_PrkgIndcrLineResp(PATypes.PA_PAC_PrkgIndcrLineResp paramPA_PAC_PrkgIndcrLineResp) {}
/*      */   
/*      */   public void onPA_PAC_VisnAgExtnResp(PATypes.PA_PAC_VisnAgExtnResp paramPA_PAC_VisnAgExtnResp) {}
/*      */   
/*      */   public void onPA_PAC_PedDetnResp(PATypes.PA_PAC_PedDetnResp paramPA_PAC_PedDetnResp) {}
/*      */   
/*      */   public void onPA_PAC_ThrDObjDethResp(PATypes.PA_PAC_ThrDObjDethResp paramPA_PAC_ThrDObjDethResp) {}
/*      */   
/*      */   public void onPA_PAC_ThrDTouringViewResp(PATypes.PA_PAC_ThrDTouringViewResp paramPA_PAC_ThrDTouringViewResp) {}
/*      */   
/*      */   public void onPA_PAC_TurnEntryAgWideVisResp(PATypes.PA_PAC_TurnEntryAgWideVisResp paramPA_PAC_TurnEntryAgWideVisResp) {}
/*      */   
/*      */   public void onPA_PAC_VehMdlClrResp(PATypes.PA_PAC_VehMdlClrResp paramPA_PAC_VehMdlClrResp) {}
/*      */   
/*      */   public void onPA_PAC_RoadCalForVisnAgWideResp(PATypes.PA_PAC_RoadCalForVisnAgWideResp paramPA_PAC_RoadCalForVisnAgWideResp) {}
/*      */   
/*      */   public void onPA_PAC_PlaModStsResp(PATypes.PA_PAC_PlaModStsResp paramPA_PAC_PlaModStsResp) {}
/*      */   
/*      */   public void onPA_PAC_ImgSnsrClrReq(PATypes.PA_PAC_ImgSnsrClrReq paramPA_PAC_ImgSnsrClrReq) {}
/*      */   
/*      */   public void onPA_PAC_RctaIndcnLe(PATypes.PA_PAC_RctaIndcnLe paramPA_PAC_RctaIndcnLe) {}
/*      */   
/*      */   public void onPA_PAC_RctaIndcnRe(PATypes.PA_PAC_RctaIndcnRe paramPA_PAC_RctaIndcnRe) {}
/*      */   
/*      */   public void onPA_SAP_DrvrAsscSysBtnPush(PATypes.PA_SAP_DrvrAsscSysBtnPush paramPA_SAP_DrvrAsscSysBtnPush) {}
/*      */   
/*      */   public void onPA_SAP_PrkgFctDiDisp(PATypes.PA_SAP_PrkgFctDiDisp paramPA_SAP_PrkgFctDiDisp) {}
/*      */   
/*      */   public void onPA_SAP_DrvrAsscSysSts(PATypes.PA_SAP_DrvrAsscSysSts paramPA_SAP_DrvrAsscSysSts) {}
/*      */   
/*      */   public void onPA_SAP_DrvrAsscSysDisp(PATypes.PA_SAP_DrvrAsscSysDisp paramPA_SAP_DrvrAsscSysDisp) {}
/*      */   
/*      */   public void onPA_SAP_PrkgProgsDisp(PATypes.PA_SAP_PrkgProgsDisp paramPA_SAP_PrkgProgsDisp) {}
/*      */   
/*      */   public void onPA_SAP_TouchUnlckTyp(PATypes.PA_SAP_TouchUnlckTyp paramPA_SAP_TouchUnlckTyp) {}
/*      */   
/*      */   public void onPA_PAS_PrkgDstCtrlSysSwt(PATypes.PA_PAS_PrkgDstCtrlSysSwt paramPA_PAS_PrkgDstCtrlSysSwt) {}
/*      */   
/*      */   public void onPA_PAS_PrkgDstCtrlSts(PATypes.PA_PAS_PrkgDstCtrlSts paramPA_PAS_PrkgDstCtrlSts) {}
/*      */   
/*      */   public void onPA_PAS_InsdLeOfSnsrPrkgAssiRe(PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiRe paramPA_PAS_InsdLeOfSnsrPrkgAssiRe) {}
/*      */   
/*      */   public void onPA_PAS_InsdRiOfSnsrPrkgAssiRe(PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiRe paramPA_PAS_InsdRiOfSnsrPrkgAssiRe) {}
/*      */   
/*      */   public void onPA_PAS_OutdLeOfSnsrPrkgAssiRe(PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiRe paramPA_PAS_OutdLeOfSnsrPrkgAssiRe) {}
/*      */   
/*      */   public void onPA_PAS_OutdRiOfSnsrPrkgAssiRe(PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiRe paramPA_PAS_OutdRiOfSnsrPrkgAssiRe) {}
/*      */   
/*      */   public void onPA_PAS_InsdLeOfSnsrPrkgAssiFrnt(PATypes.PA_PAS_InsdLeOfSnsrPrkgAssiFrnt paramPA_PAS_InsdLeOfSnsrPrkgAssiFrnt) {}
/*      */   
/*      */   public void onPA_PAS_InsdRiOfSnsrPrkgAssiFrnt(PATypes.PA_PAS_InsdRiOfSnsrPrkgAssiFrnt paramPA_PAS_InsdRiOfSnsrPrkgAssiFrnt) {}
/*      */   
/*      */   public void onPA_PAS_OutdLeOfSnsrPrkgAssiFrnt(PATypes.PA_PAS_OutdLeOfSnsrPrkgAssiFrnt paramPA_PAS_OutdLeOfSnsrPrkgAssiFrnt) {}
/*      */   
/*      */   public void onPA_PAS_OutdRiOfSnsrPrkgAssiFrnt(PATypes.PA_PAS_OutdRiOfSnsrPrkgAssiFrnt paramPA_PAS_OutdRiOfSnsrPrkgAssiFrnt) {}
/*      */   
/*      */   public void onPA_PAS_AudWarnOfSnsrParkAssiRe(PATypes.PA_PAS_AudWarnOfSnsrParkAssiRe paramPA_PAS_AudWarnOfSnsrParkAssiRe) {}
/*      */   
/*      */   public void onPA_PAS_AudWarnOfSnsrParkAssiFrnt(PATypes.PA_PAS_AudWarnOfSnsrParkAssiFrnt paramPA_PAS_AudWarnOfSnsrParkAssiFrnt) {}
/*      */   
/*      */   public void onPA_PEB_PrkgEmgBrkSysSwt(PATypes.PA_PEB_PrkgEmgBrkSysSwt paramPA_PEB_PrkgEmgBrkSysSwt) {}
/*      */   
/*      */   public void onPA_PEB_PrkgEmgyBrkSysSts(PATypes.PA_PEB_PrkgEmgyBrkSysSts paramPA_PEB_PrkgEmgyBrkSysSts) {}
/*      */   
/*      */   public void onPA_PAS_SnsrFltStsWarn(PATypes.PA_PAS_SnsrFltStsWarn paramPA_PAS_SnsrFltStsWarn) {}
/*      */   
/*      */   public void onPA_DrvrSeatExtAdjAllowd(PATypes.PA_DrvrSeatExtAdjAllowd paramPA_DrvrSeatExtAdjAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtSldSts(PATypes.PA_DrvrSeatSwtSldSts paramPA_DrvrSeatSwtSldSts) {}
/*      */   
/*      */   public void onPA_PassSeatExtAdjAllowd(PATypes.PA_PassSeatExtAdjAllowd paramPA_PassSeatExtAdjAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatSwtSldSts(PATypes.PA_PassSeatSwtSldSts paramPA_PassSeatSwtSldSts) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtHeiStsAllowd(PATypes.PA_DrvrSeatSwtHeiStsAllowd paramPA_DrvrSeatSwtHeiStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtHeiSts(PATypes.PA_DrvrSeatSwtHeiSts paramPA_DrvrSeatSwtHeiSts) {}
/*      */   
/*      */   public void onPA_PassSeatSwtHeiStsAllowd(PATypes.PA_PassSeatSwtHeiStsAllowd paramPA_PassSeatSwtHeiStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatSwtHeiSts(PATypes.PA_PassSeatSwtHeiSts paramPA_PassSeatSwtHeiSts) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtHeiFrntStsAllowd(PATypes.PA_DrvrSeatSwtHeiFrntStsAllowd paramPA_DrvrSeatSwtHeiFrntStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtHeiFrntSts(PATypes.PA_DrvrSeatSwtHeiFrntSts paramPA_DrvrSeatSwtHeiFrntSts) {}
/*      */   
/*      */   public void onPA_PassSeatSwtHeiFrntStsAllowd(PATypes.PA_PassSeatSwtHeiFrntStsAllowd paramPA_PassSeatSwtHeiFrntStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatSwtHeiFrntSts(PATypes.PA_PassSeatSwtHeiFrntSts paramPA_PassSeatSwtHeiFrntSts) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtInclStsAllowd(PATypes.PA_DrvrSeatSwtInclStsAllowd paramPA_DrvrSeatSwtInclStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtInclSts(PATypes.PA_DrvrSeatSwtInclSts paramPA_DrvrSeatSwtInclSts) {}
/*      */   
/*      */   public void onPA_PassSeatSwtInclStsAllowd(PATypes.PA_PassSeatSwtInclStsAllowd paramPA_PassSeatSwtInclStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatSwtInclSts(PATypes.PA_PassSeatSwtInclSts paramPA_PassSeatSwtInclSts) {}
/*      */   
/*      */   public void onPA_EasyInOutDrvrSeatAllowd(PATypes.PA_EasyInOutDrvrSeatAllowd paramPA_EasyInOutDrvrSeatAllowd) {}
/*      */   
/*      */   public void onPA_EasyInOutDrvrSeatAdjmt(PATypes.PA_EasyInOutDrvrSeatAdjmt paramPA_EasyInOutDrvrSeatAdjmt) {}
/*      */   
/*      */   public void onPA_DrvrSeatActvSpplFct(PATypes.PA_DrvrSeatActvSpplFct paramPA_DrvrSeatActvSpplFct) {}
/*      */   
/*      */   public void onPA_PassSeatActvSpplFct(PATypes.PA_PassSeatActvSpplFct paramPA_PassSeatActvSpplFct) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtAdjmtOfSpplFctVertSts(PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctVertSts paramPA_DrvrSeatSwtAdjmtOfSpplFctVertSts) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtAdjmtOfSpplFctHozlSts(PATypes.PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts paramPA_DrvrSeatSwtAdjmtOfSpplFctHozlSts) {}
/*      */   
/*      */   public void onPA_PassSeatSwtAdjmtOfSpplFctVertSts(PATypes.PA_PassSeatSwtAdjmtOfSpplFctVertSts paramPA_PassSeatSwtAdjmtOfSpplFctVertSts) {}
/*      */   
/*      */   public void onPA_PassSeatSwtAdjmtOfSpplFctHozlSts(PATypes.PA_PassSeatSwtAdjmtOfSpplFctHozlSts paramPA_PassSeatSwtAdjmtOfSpplFctHozlSts) {}
/*      */   
/*      */   public void onPA_DrvrSeatLmbrFwdBackwStsAllowd(PATypes.PA_DrvrSeatLmbrFwdBackwStsAllowd paramPA_DrvrSeatLmbrFwdBackwStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatLmbrUpDownStsAllowd(PATypes.PA_DrvrSeatLmbrUpDownStsAllowd paramPA_DrvrSeatLmbrUpDownStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatLmbrFwdBackwStsAllowd(PATypes.PA_PassSeatLmbrFwdBackwStsAllowd paramPA_PassSeatLmbrFwdBackwStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatLmbrUpDownStsAllowd(PATypes.PA_PassSeatLmbrUpDownStsAllowd paramPA_PassSeatLmbrUpDownStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatSideFwdBackwStsAllowd(PATypes.PA_DrvrSeatSideFwdBackwStsAllowd paramPA_DrvrSeatSideFwdBackwStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatSideFwdBackwStsAllowd(PATypes.PA_PassSeatSideFwdBackwStsAllowd paramPA_PassSeatSideFwdBackwStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatSideUpDownStsAllowd(PATypes.PA_DrvrSeatSideUpDownStsAllowd paramPA_DrvrSeatSideUpDownStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatSideUpDownStsAllowd(PATypes.PA_PassSeatSideUpDownStsAllowd paramPA_PassSeatSideUpDownStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatCushExtStsAllowd(PATypes.PA_DrvrSeatCushExtStsAllowd paramPA_DrvrSeatCushExtStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatCushExtStsAllowd(PATypes.PA_PassSeatCushExtStsAllowd paramPA_PassSeatCushExtStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatMassageStsAllowd(PATypes.PA_DrvrSeatMassageStsAllowd paramPA_DrvrSeatMassageStsAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatDispMassgFct_OnOff(PATypes.PA_DrvrSeatDispMassgFct_OnOff paramPA_DrvrSeatDispMassgFct_OnOff) {}
/*      */   
/*      */   public void onPA_DrvrSeatDispMassgFct_MassgProg(PATypes.PA_DrvrSeatDispMassgFct_MassgProg paramPA_DrvrSeatDispMassgFct_MassgProg) {}
/*      */   
/*      */   public void onPA_DrvrSeatDispMassgFct_MassgInten(PATypes.PA_DrvrSeatDispMassgFct_MassgInten paramPA_DrvrSeatDispMassgFct_MassgInten) {}
/*      */   
/*      */   public void onPA_PassSeatMassageStsAllowd(PATypes.PA_PassSeatMassageStsAllowd paramPA_PassSeatMassageStsAllowd) {}
/*      */   
/*      */   public void onPA_PassSeatDispMassgFct_OnOff(PATypes.PA_PassSeatDispMassgFct_OnOff paramPA_PassSeatDispMassgFct_OnOff) {}
/*      */   
/*      */   public void onPA_PassSeatDispMassgFct_MassgProg(PATypes.PA_PassSeatDispMassgFct_MassgProg paramPA_PassSeatDispMassgFct_MassgProg) {}
/*      */   
/*      */   public void onPA_PassSeatDispMassgFct_MassgInten(PATypes.PA_PassSeatDispMassgFct_MassgInten paramPA_PassSeatDispMassgFct_MassgInten) {}
/*      */   
/*      */   public void onPA_DrvrMassgRunng(PATypes.PA_DrvrMassgRunng paramPA_DrvrMassgRunng) {}
/*      */   
/*      */   public void onPA_PassMassgRunng(PATypes.PA_PassMassgRunng paramPA_PassMassgRunng) {}
/*      */   
/*      */   public void onPA_DrvrMultFuncMenuExt(PATypes.PA_DrvrMultFuncMenuExt paramPA_DrvrMultFuncMenuExt) {}
/*      */   
/*      */   public void onPA_PassMultFuncMenuExt(PATypes.PA_PassMultFuncMenuExt paramPA_PassMultFuncMenuExt) {}
/*      */   
/*      */   public void onPA_SeatFoldRaiseRowThrdLeAllowd(PATypes.PA_SeatFoldRaiseRowThrdLeAllowd paramPA_SeatFoldRaiseRowThrdLeAllowd) {}
/*      */   
/*      */   public void onPA_SeatFoldRaiseRowThrdRiAllowd(PATypes.PA_SeatFoldRaiseRowThrdRiAllowd paramPA_SeatFoldRaiseRowThrdRiAllowd) {}
/*      */   
/*      */   public void onPA_SecRowSeatLenLeFwdBackwAllowd(PATypes.PA_SecRowSeatLenLeFwdBackwAllowd paramPA_SecRowSeatLenLeFwdBackwAllowd) {}
/*      */   
/*      */   public void onPA_SeatRowSecLeSwtStsPassSeatSwtSldSts(PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtSldSts paramPA_SeatRowSecLeSwtStsPassSeatSwtSldSts) {}
/*      */   
/*      */   public void onPA_SecRowSeatLenRiFwdBackwAllowd(PATypes.PA_SecRowSeatLenRiFwdBackwAllowd paramPA_SecRowSeatLenRiFwdBackwAllowd) {}
/*      */   
/*      */   public void onPA_SeatRowSecRiSwtStsPassSeatSwtSldSts(PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtSldSts paramPA_SeatRowSecRiSwtStsPassSeatSwtSldSts) {}
/*      */   
/*      */   public void onPA_SecRowSeatInclLeFwdBackwAllowd(PATypes.PA_SecRowSeatInclLeFwdBackwAllowd paramPA_SecRowSeatInclLeFwdBackwAllowd) {}
/*      */   
/*      */   public void onPA_SecRowSeatInclRiFwdBackwAllowd(PATypes.PA_SecRowSeatInclRiFwdBackwAllowd paramPA_SecRowSeatInclRiFwdBackwAllowd) {}
/*      */   
/*      */   public void onPA_SeatRowSecLeSwtStsPassSeatSwtInclSts(PATypes.PA_SeatRowSecLeSwtStsPassSeatSwtInclSts paramPA_SeatRowSecLeSwtStsPassSeatSwtInclSts) {}
/*      */   
/*      */   public void onPA_SeatRowSecRiSwtStsPassSeatSwtInclSts(PATypes.PA_SeatRowSecRiSwtStsPassSeatSwtInclSts paramPA_SeatRowSecRiSwtStsPassSeatSwtInclSts) {}
/*      */   
/*      */   public void onPA_HotStoneMassageDrvrAllowd(PATypes.PA_HotStoneMassageDrvrAllowd paramPA_HotStoneMassageDrvrAllowd) {}
/*      */   
/*      */   public void onPA_HotStoneMassagePassAllowd(PATypes.PA_HotStoneMassagePassAllowd paramPA_HotStoneMassagePassAllowd) {}
/*      */   
/*      */   public void onPA_DrvrSeatSwtSelnOfSpplFctSts(PATypes.PA_DrvrSeatSwtSelnOfSpplFctSts paramPA_DrvrSeatSwtSelnOfSpplFctSts) {}
/*      */   
/*      */   public void onPA_PassSeatSwtSelnOfSpplFctSts(PATypes.PA_PassSeatSwtSelnOfSpplFctSts paramPA_PassSeatSwtSelnOfSpplFctSts) {}
/*      */   
/*      */   public void onPA_WPC_Setting(PATypes.PA_WPC_Setting paramPA_WPC_Setting) {}
/*      */   
/*      */   public void onPA_WPC_InchargeStatus(PATypes.PA_WPC_InchargeStatus paramPA_WPC_InchargeStatus) {}
/*      */   
/*      */   public void onPA_WPC_PhoneForget(PATypes.PA_WPC_PhoneForget paramPA_WPC_PhoneForget) {}
/*      */   
/*      */   public void onPA_UUN_PasArmngSts(PATypes.PA_UUN_PasArmngSts paramPA_UUN_PasArmngSts) {}
/*      */   
/*      */   public void onPA_UUN_RedGuardSts(PATypes.PA_UUN_RedGuardSts paramPA_UUN_RedGuardSts) {}
/*      */   
/*      */   public void onPA_FindCaReminder_Setting(PATypes.PA_FindCaReminder_Setting paramPA_FindCaReminder_Setting) {}
/*      */   
/*      */   public void onPA_Steer_SteerAsscLvl(PATypes.PA_Steer_SteerAsscLvl paramPA_Steer_SteerAsscLvl) {}
/*      */   
/*      */   public void onPA_Steer_SteeringMod(PATypes.PA_Steer_SteeringMod paramPA_Steer_SteeringMod) {}
/*      */   
/*      */   public void onPA_SteeringWheelPosAdj(PATypes.PA_SteeringWheelPosAdj paramPA_SteeringWheelPosAdj) {}
/*      */   
/*      */   public void onPA_SS_Activation(PATypes.PA_SS_Activation paramPA_SS_Activation) {}
/*      */   
/*      */   public void onPA_PBC_ESCSportActiv(PATypes.PA_PBC_ESCSportActiv paramPA_PBC_ESCSportActiv) {}
/*      */   
/*      */   public void onPA_AFSLight_Setting(PATypes.PA_AFSLight_Setting paramPA_AFSLight_Setting) {}
/*      */   
/*      */   public void onPA_CornrgLi_Setting(PATypes.PA_CornrgLi_Setting paramPA_CornrgLi_Setting) {}
/*      */   
/*      */   public void onPA_AL_HomeSafeLight(PATypes.PA_AL_HomeSafeLight paramPA_AL_HomeSafeLight) {}
/*      */   
/*      */   public void onPA_ApproachLightOnOff_Setting(PATypes.PA_ApproachLightOnOff_Setting paramPA_ApproachLightOnOff_Setting) {}
/*      */   
/*      */   public void onPA_BendingLight(PATypes.PA_BendingLight paramPA_BendingLight) {}
/*      */   
/*      */   public void onPA_LeftRightSetting(PATypes.PA_LeftRightSetting paramPA_LeftRightSetting) {}
/*      */   
/*      */   public void onPA_WelGoodbyeLightSwitch(PATypes.PA_WelGoodbyeLightSwitch paramPA_WelGoodbyeLightSwitch) {}
/*      */   
/*      */   public void onPA_WelGoodbyeLightMod(PATypes.PA_WelGoodbyeLightMod paramPA_WelGoodbyeLightMod) {}
/*      */   
/*      */   public void onPA_RearMirrorFold_Auto(PATypes.PA_RearMirrorFold_Auto paramPA_RearMirrorFold_Auto) {}
/*      */   
/*      */   public void onPA_MirrTiltSetg(PATypes.PA_MirrTiltSetg paramPA_MirrTiltSetg) {}
/*      */   
/*      */   public void onPA_HillDescentSetting(PATypes.PA_HillDescentSetting paramPA_HillDescentSetting) {}
/*      */   
/*      */   public void onPA_EasyEntrySetting(PATypes.PA_EasyEntrySetting paramPA_EasyEntrySetting) {}
/*      */   
/*      */   public void onPA_DeacLevCtrSetting(PATypes.PA_DeacLevCtrSetting paramPA_DeacLevCtrSetting) {}
/*      */   
/*      */   public void onPA_SuspHeiSetting(PATypes.PA_SuspHeiSetting paramPA_SuspHeiSetting) {}
/*      */   
/*      */   public void onPA_SuspMoveDirInform(PATypes.PA_SuspMoveDirInform paramPA_SuspMoveDirInform) {}
/*      */   
/*      */   public void onPA_EPBAutoApply(PATypes.PA_EPBAutoApply paramPA_EPBAutoApply) {}
/*      */   
/*      */   public void onPA_AutoHoldStatus(PATypes.PA_AutoHoldStatus paramPA_AutoHoldStatus) {}
/*      */   
/*      */   public void onPA_Total_Traveled_Distance(PATypes.PA_Total_Traveled_Distance paramPA_Total_Traveled_Distance) {}
/*      */   
/*      */   public void onPA_External_Sound_Setting(PATypes.PA_External_Sound_Setting paramPA_External_Sound_Setting) {}
/*      */   
/*      */   public void onPA_SpeedWarnSet(PATypes.PA_SpeedWarnSet paramPA_SpeedWarnSet) {}
/*      */   
/*      */   public void onPA_LowAlarmVolSet(PATypes.PA_LowAlarmVolSet paramPA_LowAlarmVolSet) {}
/*      */   
/*      */   public void onPA_SpeedWarnOnOff(PATypes.PA_SpeedWarnOnOff paramPA_SpeedWarnOnOff) {}
/*      */   
/*      */   public void onPA_SpeedWarnSpeedLimit(PATypes.PA_SpeedWarnSpeedLimit paramPA_SpeedWarnSpeedLimit) {}
/*      */   
/*      */   public void onPA_SailingSwitch(PATypes.PA_SailingSwitch paramPA_SailingSwitch) {}
/*      */   
/*      */   public void onPA_PowerFlow(PATypes.PA_PowerFlow paramPA_PowerFlow) {}
/*      */   
/*      */   public void onPA_PowerFlow_MHEV(PATypes.PA_PowerFlow_MHEV paramPA_PowerFlow_MHEV) {}
/*      */   
/*      */   public void onPA_UnLockSetting(PATypes.PA_UnLockSetting paramPA_UnLockSetting) {}
/*      */   
/*      */   public void onPA_PasAcsLock_Setting(PATypes.PA_PasAcsLock_Setting paramPA_PasAcsLock_Setting) {}
/*      */   
/*      */   public void onPA_TwoStepUnlck_Setting(PATypes.PA_TwoStepUnlck_Setting paramPA_TwoStepUnlck_Setting) {}
/*      */   
/*      */   public void onPA_LockgFbSoundSet(PATypes.PA_LockgFbSoundSet paramPA_LockgFbSoundSet) {}
/*      */   
/*      */   public void onPA_Individualtheme_OnOff(PATypes.PA_Individualtheme_OnOff paramPA_Individualtheme_OnOff) {}
/*      */   
/*      */   public void onPA_DIMTheme_DrvSetting(PATypes.PA_DIMTheme_DrvSetting paramPA_DIMTheme_DrvSetting) {}
/*      */   
/*      */   public void onPA_CSDTheme_Setting(PATypes.PA_CSDTheme_Setting paramPA_CSDTheme_Setting) {}
/*      */   
/*      */   public void onPA_ElecSeatbelt_Driver(PATypes.PA_ElecSeatbelt_Driver paramPA_ElecSeatbelt_Driver) {}
/*      */   
/*      */   public void onPA_ElecSeatbelt_Passenger(PATypes.PA_ElecSeatbelt_Passenger paramPA_ElecSeatbelt_Passenger) {}
/*      */   
/*      */   public void onPA_PM_Hold(PATypes.PA_PM_Hold paramPA_PM_Hold) {}
/*      */   
/*      */   public void onPA_PM_Charge(PATypes.PA_PM_Charge paramPA_PM_Charge) {}
/*      */   
/*      */   public void onPA_Battery_Charge_Percent(PATypes.PA_Battery_Charge_Percent paramPA_Battery_Charge_Percent) {}
/*      */   
/*      */   public void onPA_ChangeFailMsg(PATypes.PA_ChangeFailMsg paramPA_ChangeFailMsg) {}
/*      */   
/*      */   public void onPA_ElectricTailgate_Setting(PATypes.PA_ElectricTailgate_Setting paramPA_ElectricTailgate_Setting) {}
/*      */   
/*      */   public void onPA_ElectricTailgate_OpenBtn(PATypes.PA_ElectricTailgate_OpenBtn paramPA_ElectricTailgate_OpenBtn) {}
/*      */   
/*      */   public void onPA_ElectricTailgate_PosSetting(PATypes.PA_ElectricTailgate_PosSetting paramPA_ElectricTailgate_PosSetting) {}
/*      */   
/*      */   public void onPA_TailgateSts(PATypes.PA_TailgateSts paramPA_TailgateSts) {}
/*      */   
/*      */   public void onPA_SelfDefineFuncReq(PATypes.PA_SelfDefineFuncReq paramPA_SelfDefineFuncReq) {}
/*      */   
/*      */   public void onPA_ScreenSwitch(PATypes.PA_ScreenSwitch paramPA_ScreenSwitch) {}
/*      */   
/*      */   public void onPA_DVR(PATypes.PA_DVR paramPA_DVR) {}
/*      */   
/*      */   public void onPA_360Panorama(PATypes.PA_360Panorama paramPA_360Panorama) {}
/*      */   
/*      */   public void onPA_NaviHome(PATypes.PA_NaviHome paramPA_NaviHome) {}
/*      */   
/*      */   public void onPA_SourceSwitch(PATypes.PA_SourceSwitch paramPA_SourceSwitch) {}
/*      */   
/*      */   public void onPA_CollectionRadio(PATypes.PA_CollectionRadio paramPA_CollectionRadio) {}
/*      */   
/*      */   public void onPA_VINDiffMsg(PATypes.PA_VINDiffMsg paramPA_VINDiffMsg) {}
/*      */   
/*      */   public void onPA_ParkingAutoResetSetting(PATypes.PA_ParkingAutoResetSetting paramPA_ParkingAutoResetSetting) {}
/*      */   
/*      */   public void onPA_RefuleAutoResetSetting(PATypes.PA_RefuleAutoResetSetting paramPA_RefuleAutoResetSetting) {}
/*      */   
/*      */   public void onPA_TripCom_RetALL(PATypes.PA_TripCom_RetALL paramPA_TripCom_RetALL) {}
/*      */   
/*      */   public void onPA_TripCom_RstTrip(PATypes.PA_TripCom_RstTrip paramPA_TripCom_RstTrip) {}
/*      */   
/*      */   public void onPA_TripCom_RstAVS(PATypes.PA_TripCom_RstAVS paramPA_TripCom_RstAVS) {}
/*      */   
/*      */   public void onPA_TripCom_RstEDT(PATypes.PA_TripCom_RstEDT paramPA_TripCom_RstEDT) {}
/*      */   
/*      */   public void onPA_TripCom_RstAFC(PATypes.PA_TripCom_RstAFC paramPA_TripCom_RstAFC) {}
/*      */   
/*      */   public void onPA_TripCom_RstAEC(PATypes.PA_TripCom_RstAEC paramPA_TripCom_RstAEC) {}
/*      */   
/*      */   public void onPA_IntelligentFuSave(PATypes.PA_IntelligentFuSave paramPA_IntelligentFuSave) {}
/*      */   
/*      */   public void onPA_PowerFlow_HEV(PATypes.PA_PowerFlow_HEV paramPA_PowerFlow_HEV) {}
/*      */   
/*      */   public void onPA_LifeDetectionSwitch(PATypes.PA_LifeDetectionSwitch paramPA_LifeDetectionSwitch) {}
/*      */   
/*      */   public void onPA_UnlckTrunk(PATypes.PA_UnlckTrunk paramPA_UnlckTrunk) {}
/*      */   
/*      */   public void onPA_RearMirrors(PATypes.PA_RearMirrors paramPA_RearMirrors) {}
/*      */   
/*      */   public void onPA_DoubleLock(PATypes.PA_DoubleLock paramPA_DoubleLock) {}
/*      */   
/*      */   public void onPA_Locking_ApproachToOpenTrSwt(PATypes.PA_Locking_ApproachToOpenTrSwt paramPA_Locking_ApproachToOpenTrSwt) {}
/*      */   
/*      */   public void onPA_ServiceReminderType(PATypes.PA_ServiceReminderType paramPA_ServiceReminderType) {}
/*      */   
/*      */   public void onPA_DstTrvldAct(PATypes.PA_DstTrvldAct paramPA_DstTrvldAct) {}
/*      */   
/*      */   public void onPA_DstTrvldOfEV(PATypes.PA_DstTrvldOfEV paramPA_DstTrvldOfEV) {}
/*      */   
/*      */   public void onPA_DstTrvldOfEng(PATypes.PA_DstTrvldOfEng paramPA_DstTrvldOfEng) {}
/*      */   
/*      */   public void onPA_NatUsgDayOfOil(PATypes.PA_NatUsgDayOfOil paramPA_NatUsgDayOfOil) {}
/*      */   
/*      */   public void onPA_HealthOfEngOil(PATypes.PA_HealthOfEngOil paramPA_HealthOfEngOil) {}
/*      */   
/*      */   public void onPA_DiagProxy_Status(PATypes.PA_DiagProxy_Status paramPA_DiagProxy_Status) {}
/*      */   
/*      */   public void onPA_DiagProxy_Csd_GW_Phy(PATypes.PA_DiagProxy_Csd_GW_Phy paramPA_DiagProxy_Csd_GW_Phy) {}
/*      */   
/*      */   public void onPA_DiagProxy_Csd_GW_Fun(PATypes.PA_DiagProxy_Csd_GW_Fun paramPA_DiagProxy_Csd_GW_Fun) {}
/*      */   
/*      */   public void onPA_DiagProxy_Csdm_GW_Phy(PATypes.PA_DiagProxy_Csdm_GW_Phy paramPA_DiagProxy_Csdm_GW_Phy) {}
/*      */   
/*      */   public void onPA_DiagProxy_Csdm_GW_Fun(PATypes.PA_DiagProxy_Csdm_GW_Fun paramPA_DiagProxy_Csdm_GW_Fun) {}
/*      */   
/*      */   public void onPA_DiagProxy_Psd_GW_Phy(PATypes.PA_DiagProxy_Psd_GW_Phy paramPA_DiagProxy_Psd_GW_Phy) {}
/*      */   
/*      */   public void onPA_DiagProxy_Psd_GW_Fun(PATypes.PA_DiagProxy_Psd_GW_Fun paramPA_DiagProxy_Psd_GW_Fun) {}
/*      */   
/*      */   public void onPA_CSD_MONITOR_EN(PATypes.PA_CSD_MONITOR_EN paramPA_CSD_MONITOR_EN) {}
/*      */   
/*      */   public void onPA_PASWAM_Video_in(PATypes.PA_PASWAM_Video_in paramPA_PASWAM_Video_in) {}
/*      */   
/*      */   public void onPA_DVR_Video_IN(PATypes.PA_DVR_Video_IN paramPA_DVR_Video_IN) {}
/*      */   
/*      */   public void onPA_Gesture_Video_IN(PATypes.PA_Gesture_Video_IN paramPA_Gesture_Video_IN) {}
/*      */   
/*      */   public void onPA_Chat_Video_IN(PATypes.PA_Chat_Video_IN paramPA_Chat_Video_IN) {}
/*      */   
/*      */   public void onPA_Dcm_D912_PSD_MONITOR_EN(PATypes.PA_Dcm_D912_PSD_MONITOR_EN paramPA_Dcm_D912_PSD_MONITOR_EN) {}
/*      */   
/*      */   public void onPA_Product_Serial_Number(PATypes.PA_Product_Serial_Number paramPA_Product_Serial_Number) {}
/*      */   
/*      */   public void onPA_XDSN_Reading(PATypes.PA_XDSN_Reading paramPA_XDSN_Reading) {}
/*      */   
/*      */   public void onPA_IHUID_Reading(PATypes.PA_IHUID_Reading paramPA_IHUID_Reading) {}
/*      */   
/*      */   public void onPA_HW_Version_Reading(PATypes.PA_HW_Version_Reading paramPA_HW_Version_Reading) {}
/*      */   
/*      */   public void onPA_Geely_Delivery_Assemble_Reading(PATypes.PA_Geely_Delivery_Assemble_Reading paramPA_Geely_Delivery_Assemble_Reading) {}
/*      */   
/*      */   public void onPA_GeelyHSWD_Reading(PATypes.PA_GeelyHSWD_Reading paramPA_GeelyHSWD_Reading) {}
/*      */   
/*      */   public void onPA_VolvoDelivery_Assemble_Reading(PATypes.PA_VolvoDelivery_Assemble_Reading paramPA_VolvoDelivery_Assemble_Reading) {}
/*      */   
/*      */   public void onPA_VolvoHWSD_Reading(PATypes.PA_VolvoHWSD_Reading paramPA_VolvoHWSD_Reading) {}
/*      */   
/*      */   public void onPA_Manufacturing_Signal(PATypes.PA_Manufacturing_Signal paramPA_Manufacturing_Signal) {}
/*      */   
/*      */   public void onPA_D907(PATypes.PA_D907 paramPA_D907) {}
/*      */   
/*      */   public void onPA_CSDM_PSD_EN(PATypes.PA_CSDM_PSD_EN paramPA_CSDM_PSD_EN) {}
/*      */   
/*      */   public void onPA_FD26(PATypes.PA_FD26 paramPA_FD26) {}
/*      */   
/*      */   public void onPA_FD27(PATypes.PA_FD27 paramPA_FD27) {}
/*      */   
/*      */   public void onPA_FD28(PATypes.PA_FD28 paramPA_FD28) {}
/*      */   
/*      */   public void onPA_FD39(PATypes.PA_FD39 paramPA_FD39) {}
/*      */   
/*      */   public void onPA_FD29(PATypes.PA_FD29 paramPA_FD29) {}
/*      */   
/*      */   public void onPA_FD12(PATypes.PA_FD12 paramPA_FD12) {}
/*      */   
/*      */   public void onPA_FD17(PATypes.PA_FD17 paramPA_FD17) {}
/*      */   
/*      */   public void onPA_FD5A(PATypes.PA_FD5A paramPA_FD5A) {}
/*      */   
/*      */   public void onPA_FD30(PATypes.PA_FD30 paramPA_FD30) {}
/*      */   
/*      */   public void onPA_FD23(PATypes.PA_FD23 paramPA_FD23) {}
/*      */   
/*      */   public void onPA_FD42(PATypes.PA_FD42 paramPA_FD42) {}
/*      */   
/*      */   public void onPA_FD44(PATypes.PA_FD44 paramPA_FD44) {}
/*      */   
/*      */   public void onPA_FD41(PATypes.PA_FD41 paramPA_FD41) {}
/*      */   
/*      */   public void onPA_FD43(PATypes.PA_FD43 paramPA_FD43) {}
/*      */   
/*      */   public void onPA_FD62(PATypes.PA_FD62 paramPA_FD62) {}
/*      */   
/*      */   public void onPA_FD85(PATypes.PA_FD85 paramPA_FD85) {}
/*      */   
/*      */   public void onPA_FD88(PATypes.PA_FD88 paramPA_FD88) {}
/*      */   
/*      */   public void onPA_FD86(PATypes.PA_FD86 paramPA_FD86) {}
/*      */   
/*      */   public void onPA_FD91(PATypes.PA_FD91 paramPA_FD91) {}
/*      */   
/*      */   public void onPA_FD92(PATypes.PA_FD92 paramPA_FD92) {}
/*      */   
/*      */   public void onPA_AuthorityLocationSwitch(PATypes.PA_AuthorityLocationSwitch paramPA_AuthorityLocationSwitch) {}
/*      */   
/*      */   public void onPA_AuthorityCameraSwitch(PATypes.PA_AuthorityCameraSwitch paramPA_AuthorityCameraSwitch) {}
/*      */   
/*      */   public void onPA_AuthorityMicrophoneSwitch(PATypes.PA_AuthorityMicrophoneSwitch paramPA_AuthorityMicrophoneSwitch) {}
/*      */   
/*      */   public void onPA_Privacy_Compliance_Reset(PATypes.PA_Privacy_Compliance_Reset paramPA_Privacy_Compliance_Reset) {}
/*      */   
/*      */   public void onPA_D0D2(PATypes.PA_D0D2 paramPA_D0D2) {}
/*      */   
/*      */   public void onPA_D0D1(PATypes.PA_D0D1 paramPA_D0D1) {}
/*      */   
/*      */   public void onPA_D0D0(PATypes.PA_D0D0 paramPA_D0D0) {}
/*      */   
/*      */   public void onPA_TS_DTEIndicated(PATypes.PA_TS_DTEIndicated paramPA_TS_DTEIndicated) {}
/*      */   
/*      */   public void onPA_TS_DTEHVBattIndicated(PATypes.PA_TS_DTEHVBattIndicated paramPA_TS_DTEHVBattIndicated) {}
/*      */   
/*      */   public void onPA_TS_DTEHV_round(PATypes.PA_TS_DTEHV_round paramPA_TS_DTEHV_round) {}
/*      */   
/*      */   public void onPA_TS_EDT_time2(PATypes.PA_TS_EDT_time2 paramPA_TS_EDT_time2) {}
/*      */   
/*      */   public void onPA_TS_Zero_Emission(PATypes.PA_TS_Zero_Emission paramPA_TS_Zero_Emission) {}
/*      */   
/*      */   public void onPA_TS_OdometerTripMeter2(PATypes.PA_TS_OdometerTripMeter2 paramPA_TS_OdometerTripMeter2) {}
/*      */   
/*      */   public void onPA_TS_TripAverageConsumption05Km(PATypes.PA_TS_TripAverageConsumption05Km paramPA_TS_TripAverageConsumption05Km) {}
/*      */   
/*      */   public void onPA_TS_TripAverageConsumption5Km(PATypes.PA_TS_TripAverageConsumption5Km paramPA_TS_TripAverageConsumption5Km) {}
/*      */   
/*      */   public void onPA_TS_TripAverageEnConsumption05Km(PATypes.PA_TS_TripAverageEnConsumption05Km paramPA_TS_TripAverageEnConsumption05Km) {}
/*      */   
/*      */   public void onPA_TS_TripAverageEnConsumption5Km(PATypes.PA_TS_TripAverageEnConsumption5Km paramPA_TS_TripAverageEnConsumption5Km) {}
/*      */   
/*      */   public void onPA_TS_fuelStats10(PATypes.PA_TS_fuelStats10 paramPA_TS_fuelStats10) {}
/*      */   
/*      */   public void onPA_TS_fuelStats100(PATypes.PA_TS_fuelStats100 paramPA_TS_fuelStats100) {}
/*      */   
/*      */   public void onPA_TS_energyStats10(PATypes.PA_TS_energyStats10 paramPA_TS_energyStats10) {}
/*      */   
/*      */   public void onPA_TS_energyStats100(PATypes.PA_TS_energyStats100 paramPA_TS_energyStats100) {}
/*      */   
/*      */   public void onPA_TS_energyReStats10(PATypes.PA_TS_energyReStats10 paramPA_TS_energyReStats10) {}
/*      */   
/*      */   public void onPA_TS_energyReStats100(PATypes.PA_TS_energyReStats100 paramPA_TS_energyReStats100) {}
/*      */   
/*      */   public void onPA_VehCharg_ChargRemind(PATypes.PA_VehCharg_ChargRemind paramPA_VehCharg_ChargRemind) {}
/*      */   
/*      */   public void onPA_VehCharg_SetA(PATypes.PA_VehCharg_SetA paramPA_VehCharg_SetA) {}
/*      */   
/*      */   public void onPA_VehCharg_SetSOC(PATypes.PA_VehCharg_SetSOC paramPA_VehCharg_SetSOC) {}
/*      */   
/*      */   public void onPA_VehCharg_ChargSt(PATypes.PA_VehCharg_ChargSt paramPA_VehCharg_ChargSt) {}
/*      */   
/*      */   public void onPA_VehCharg_ChargInfoShow(PATypes.PA_VehCharg_ChargInfoShow paramPA_VehCharg_ChargInfoShow) {}
/*      */   
/*      */   public void onPA_VehCharg_ChargLight(PATypes.PA_VehCharg_ChargLight paramPA_VehCharg_ChargLight) {}
/*      */   
/*      */   public void onPA_VehCharg_Appointment(PATypes.PA_VehCharg_Appointment paramPA_VehCharg_Appointment) {}
/*      */   
/*      */   public void onPA_VehCharg_DisChargSOC(PATypes.PA_VehCharg_DisChargSOC paramPA_VehCharg_DisChargSOC) {}
/*      */   
/*      */   public void onPA_VehCharg_DisChargInfoShow(PATypes.PA_VehCharg_DisChargInfoShow paramPA_VehCharg_DisChargInfoShow) {}
/*      */   
/*      */   public void onPA_VehCharg_DisChargeSwitch(PATypes.PA_VehCharg_DisChargeSwitch paramPA_VehCharg_DisChargeSwitch) {}
/*      */   
/*      */   public void onPA_VehCharg_DisChargeRecord(PATypes.PA_VehCharg_DisChargeRecord paramPA_VehCharg_DisChargeRecord) {}
/*      */   
/*      */   public void onPA_VehCharg_DchaUAct(PATypes.PA_VehCharg_DchaUAct paramPA_VehCharg_DchaUAct) {}
/*      */   
/*      */   public void onPA_VehCharg_DchaIAct(PATypes.PA_VehCharg_DchaIAct paramPA_VehCharg_DchaIAct) {}
/*      */   
/*      */   public void onPA_VehCharg_HvBattDchaTiEstimd(PATypes.PA_VehCharg_HvBattDchaTiEstimd paramPA_VehCharg_HvBattDchaTiEstimd) {}
/*      */   
/*      */   public void onPA_VehCharg_DchaEgyAct(PATypes.PA_VehCharg_DchaEgyAct paramPA_VehCharg_DchaEgyAct) {}
/*      */   
/*      */   public void onPA_VehCharg_DispHvBattLvlOfChrg(PATypes.PA_VehCharg_DispHvBattLvlOfChrg paramPA_VehCharg_DispHvBattLvlOfChrg) {}
/*      */   
/*      */   public void onPA_VehCharg_OnBdChrgrUAct(PATypes.PA_VehCharg_OnBdChrgrUAct paramPA_VehCharg_OnBdChrgrUAct) {}
/*      */   
/*      */   public void onPA_VehCharg_OnBdChrgrIAct(PATypes.PA_VehCharg_OnBdChrgrIAct paramPA_VehCharg_OnBdChrgrIAct) {}
/*      */   
/*      */   public void onPA_VehCharg_HvBattChrgnTiEstimd(PATypes.PA_VehCharg_HvBattChrgnTiEstimd paramPA_VehCharg_HvBattChrgnTiEstimd) {}
/*      */   
/*      */   public void onPA_VehCharg_ChrgnOrDisChrgnStsFb(PATypes.PA_VehCharg_ChrgnOrDisChrgnStsFb paramPA_VehCharg_ChrgnOrDisChrgnStsFb) {}
/*      */   
/*      */   public void onPA_SunCurtain_Setting(PATypes.PA_SunCurtain_Setting paramPA_SunCurtain_Setting) {}
/*      */   
/*      */   public void onPA_OpenSunRoof_Btn(PATypes.PA_OpenSunRoof_Btn paramPA_OpenSunRoof_Btn) {}
/*      */   
/*      */   public void onPA_CloseSunRoof_Btn(PATypes.PA_CloseSunRoof_Btn paramPA_CloseSunRoof_Btn) {}
/*      */   
/*      */   public void onPA_OpenSunCurtain_Btn(PATypes.PA_OpenSunCurtain_Btn paramPA_OpenSunCurtain_Btn) {}
/*      */   
/*      */   public void onPA_CloseSunCurtain_Btn(PATypes.PA_CloseSunCurtain_Btn paramPA_CloseSunCurtain_Btn) {}
/*      */   
/*      */   public void onPA_SunRoofPosnSts(PATypes.PA_SunRoofPosnSts paramPA_SunRoofPosnSts) {}
/*      */   
/*      */   public void onPA_SunCurtainPosnSts(PATypes.PA_SunCurtainPosnSts paramPA_SunCurtainPosnSts) {}
/*      */   
/*      */   public void onPA_SunRoofOpenPosnReq(PATypes.PA_SunRoofOpenPosnReq paramPA_SunRoofOpenPosnReq) {}
/*      */   
/*      */   public void onPA_SunCurtOpenPosnReq(PATypes.PA_SunCurtOpenPosnReq paramPA_SunCurtOpenPosnReq) {}
/*      */   
/*      */   public void onPA_SunRoofTiltReq(PATypes.PA_SunRoofTiltReq paramPA_SunRoofTiltReq) {}
/*      */   
/*      */   public void onPA_HmiCarLocatorSetReq(PATypes.PA_HmiCarLocatorSetReq paramPA_HmiCarLocatorSetReq) {}
/*      */   
/*      */   public void onPA_AmbLiAll(PATypes.PA_AmbLiAll paramPA_AmbLiAll) {}
/*      */   
/*      */   public void onPA_AmbLiModSetting(PATypes.PA_AmbLiModSetting paramPA_AmbLiModSetting) {}
/*      */   
/*      */   public void onPA_AmbLiMod_None(PATypes.PA_AmbLiMod_None paramPA_AmbLiMod_None) {}
/*      */   
/*      */   public void onPA_AmbLiMod_CustomizedMode(PATypes.PA_AmbLiMod_CustomizedMode paramPA_AmbLiMod_CustomizedMode) {}
/*      */   
/*      */   public void onPA_AmbLiMod_DriveMode(PATypes.PA_AmbLiMod_DriveMode paramPA_AmbLiMod_DriveMode) {}
/*      */   
/*      */   public void onPA_AmbLiMod_MusicShowMode(PATypes.PA_AmbLiMod_MusicShowMode paramPA_AmbLiMod_MusicShowMode) {}
/*      */   
/*      */   public void onPA_AmbLiMod_WeatherIndn(PATypes.PA_AmbLiMod_WeatherIndn paramPA_AmbLiMod_WeatherIndn) {}
/*      */   
/*      */   public void onPA_CustomEffect(PATypes.PA_CustomEffect paramPA_CustomEffect) {}
/*      */   
/*      */   public void onPA_TransitionEffectSel(PATypes.PA_TransitionEffectSel paramPA_TransitionEffectSel) {}
/*      */   
/*      */   public void onPA_TransitionColor1Settings(PATypes.PA_TransitionColor1Settings paramPA_TransitionColor1Settings) {}
/*      */   
/*      */   public void onPA_TransitionColor2Settings(PATypes.PA_TransitionColor2Settings paramPA_TransitionColor2Settings) {}
/*      */   
/*      */   public void onPA_ZoneAllStatusSettings(PATypes.PA_ZoneAllStatusSettings paramPA_ZoneAllStatusSettings) {}
/*      */   
/*      */   public void onPA_ZoneAllIntensitySettings(PATypes.PA_ZoneAllIntensitySettings paramPA_ZoneAllIntensitySettings) {}
/*      */   
/*      */   public void onPA_ZoneAllColorSettings(PATypes.PA_ZoneAllColorSettings paramPA_ZoneAllColorSettings) {}
/*      */   
/*      */   public void onPA_Zone1StatusSettings(PATypes.PA_Zone1StatusSettings paramPA_Zone1StatusSettings) {}
/*      */   
/*      */   public void onPA_Zone1IntensitySettings(PATypes.PA_Zone1IntensitySettings paramPA_Zone1IntensitySettings) {}
/*      */   
/*      */   public void onPA_Zone1ColorSettings(PATypes.PA_Zone1ColorSettings paramPA_Zone1ColorSettings) {}
/*      */   
/*      */   public void onPA_Zone2StatusSettings(PATypes.PA_Zone2StatusSettings paramPA_Zone2StatusSettings) {}
/*      */   
/*      */   public void onPA_Zone2IntensitySettings(PATypes.PA_Zone2IntensitySettings paramPA_Zone2IntensitySettings) {}
/*      */   
/*      */   public void onPA_Zone2ColorSettings(PATypes.PA_Zone2ColorSettings paramPA_Zone2ColorSettings) {}
/*      */   
/*      */   public void onPA_Zone3StatusSettings(PATypes.PA_Zone3StatusSettings paramPA_Zone3StatusSettings) {}
/*      */   
/*      */   public void onPA_Zone3IntensitySettings(PATypes.PA_Zone3IntensitySettings paramPA_Zone3IntensitySettings) {}
/*      */   
/*      */   public void onPA_Zone3ColorSettings(PATypes.PA_Zone3ColorSettings paramPA_Zone3ColorSettings) {}
/*      */   
/*      */   public void onPA_MoodLightSwitch(PATypes.PA_MoodLightSwitch paramPA_MoodLightSwitch) {}
/*      */   
/*      */   public void onPA_AmbLiMilgOpenReq(PATypes.PA_AmbLiMilgOpenReq paramPA_AmbLiMilgOpenReq) {}
/*      */   
/*      */   public void onPA_AmbLiPhoneOpenReq(PATypes.PA_AmbLiPhoneOpenReq paramPA_AmbLiPhoneOpenReq) {}
/*      */   
/*      */   public void onPA_ReadLightFrontLeft(PATypes.PA_ReadLightFrontLeft paramPA_ReadLightFrontLeft) {}
/*      */   
/*      */   public void onPA_ReadLightFrontRight(PATypes.PA_ReadLightFrontRight paramPA_ReadLightFrontRight) {}
/*      */   
/*      */   public void onPA_ReadLightSecondRowLeft(PATypes.PA_ReadLightSecondRowLeft paramPA_ReadLightSecondRowLeft) {}
/*      */   
/*      */   public void onPA_ReadLightSecondRowRight(PATypes.PA_ReadLightSecondRowRight paramPA_ReadLightSecondRowRight) {}
/*      */   
/*      */   public void onPA_ReadLightThirdRowLeft(PATypes.PA_ReadLightThirdRowLeft paramPA_ReadLightThirdRowLeft) {}
/*      */   
/*      */   public void onPA_ReadLightThirdRowRight(PATypes.PA_ReadLightThirdRowRight paramPA_ReadLightThirdRowRight) {}
/*      */   
/*      */   public void onPA_WeatherInfoConService(PATypes.PA_WeatherInfoConService paramPA_WeatherInfoConService) {}
/*      */   
/*      */   public void onPA_CourtesyLight(PATypes.PA_CourtesyLight paramPA_CourtesyLight) {}
/*      */   
/*      */   public void onPA_WelcomeLight(PATypes.PA_WelcomeLight paramPA_WelcomeLight) {}
/*      */   
/*      */   public void onPA_GoodbyeLight(PATypes.PA_GoodbyeLight paramPA_GoodbyeLight) {}
/*      */   
/*      */   public void onPA_ReadLightAllOnSwitch(PATypes.PA_ReadLightAllOnSwitch paramPA_ReadLightAllOnSwitch) {}
/*      */   
/*      */   public void onPA_CustomEffectBreath(PATypes.PA_CustomEffectBreath paramPA_CustomEffectBreath) {}
/*      */   
/*      */   public void onPA_MoodLiColorAdjReq(PATypes.PA_MoodLiColorAdjReq paramPA_MoodLiColorAdjReq) {}
/*      */   
/*      */   public void onPA_AmbLiRadarCorrlnReq(PATypes.PA_AmbLiRadarCorrlnReq paramPA_AmbLiRadarCorrlnReq) {}
/*      */   
/*      */   public void onPA_EgyRgnLvlSet(PATypes.PA_EgyRgnLvlSet paramPA_EgyRgnLvlSet) {}
/*      */   
/*      */   public void onPA_WinOpenDrvrReq(PATypes.PA_WinOpenDrvrReq paramPA_WinOpenDrvrReq) {}
/*      */   
/*      */   public void onPA_WinOpenPassReq(PATypes.PA_WinOpenPassReq paramPA_WinOpenPassReq) {}
/*      */   
/*      */   public void onPA_WinOpenReLeReq(PATypes.PA_WinOpenReLeReq paramPA_WinOpenReLeReq) {}
/*      */   
/*      */   public void onPA_WinOpenReRiReq(PATypes.PA_WinOpenReRiReq paramPA_WinOpenReRiReq) {}
/*      */   
/*      */   public void onPA_WinPosnStsAtDrvr(PATypes.PA_WinPosnStsAtDrvr paramPA_WinPosnStsAtDrvr) {}
/*      */   
/*      */   public void onPA_WinPosnStsAtPass(PATypes.PA_WinPosnStsAtPass paramPA_WinPosnStsAtPass) {}
/*      */   
/*      */   public void onPA_WinPosnStsAtReLe(PATypes.PA_WinPosnStsAtReLe paramPA_WinPosnStsAtReLe) {}
/*      */   
/*      */   public void onPA_WinPosnStsAtReRi(PATypes.PA_WinPosnStsAtReRi paramPA_WinPosnStsAtReRi) {}
/*      */   
/*      */   public void onPA_ChdLockReLeft(PATypes.PA_ChdLockReLeft paramPA_ChdLockReLeft) {}
/*      */   
/*      */   public void onPA_ChdLockReRight(PATypes.PA_ChdLockReRight paramPA_ChdLockReRight) {}
/*      */   
/*      */   public void onPA_ChdLockReLeft_ChdMod(PATypes.PA_ChdLockReLeft_ChdMod paramPA_ChdLockReLeft_ChdMod) {}
/*      */   
/*      */   public void onPA_ChdLockReRight_ChdMod(PATypes.PA_ChdLockReRight_ChdMod paramPA_ChdLockReRight_ChdMod) {}
/*      */   
/*      */   public void onPA_VFS_FaceIdnReq(PATypes.PA_VFS_FaceIdnReq paramPA_VFS_FaceIdnReq) {}
/*      */   
/*      */   public void onPA_VFS_DPS(PATypes.PA_VFS_DPS paramPA_VFS_DPS) {}
/*      */   
/*      */   public void onPA_PSET_ActiveProfile(PATypes.PA_PSET_ActiveProfile paramPA_PSET_ActiveProfile) {}
/*      */   
/*      */   public void onPA_PSET_NewProfile(PATypes.PA_PSET_NewProfile paramPA_PSET_NewProfile) {}
/*      */   
/*      */   public void onPA_PSET_DeleteProfile(PATypes.PA_PSET_DeleteProfile paramPA_PSET_DeleteProfile) {}
/*      */   
/*      */   public void onPA_PSET_LogOut(PATypes.PA_PSET_LogOut paramPA_PSET_LogOut) {}
/*      */   
/*      */   public void onPA_PSET_ProfileFactoryDefault(PATypes.PA_PSET_ProfileFactoryDefault paramPA_PSET_ProfileFactoryDefault) {}
/*      */   
/*      */   public void onPA_PSET_ProfileFactoryDefaultResult(PATypes.PA_PSET_ProfileFactoryDefaultResult paramPA_PSET_ProfileFactoryDefaultResult) {}
/*      */   
/*      */   public void onPA_PSET_FactoryDefault(PATypes.PA_PSET_FactoryDefault paramPA_PSET_FactoryDefault) {}
/*      */   
/*      */   public void onPA_PSET_FactoryDefaultResult(PATypes.PA_PSET_FactoryDefaultResult paramPA_PSET_FactoryDefaultResult) {}
/*      */   
/*      */   public void onPA_PSET_Key_Result(PATypes.PA_PSET_Key_Result paramPA_PSET_Key_Result) {}
/*      */   
/*      */   public void onPA_PSET_KeyID(PATypes.PA_PSET_KeyID paramPA_PSET_KeyID) {}
/*      */   
/*      */   public void onPA_PSET_PChangeAllowed(PATypes.PA_PSET_PChangeAllowed paramPA_PSET_PChangeAllowed) {}
/*      */   
/*      */   public void onPA_PSET_MaxNrProfReached(PATypes.PA_PSET_MaxNrProfReached paramPA_PSET_MaxNrProfReached) {}
/*      */   
/*      */   public void onPA_PSET_AutLogOutCurrent(PATypes.PA_PSET_AutLogOutCurrent paramPA_PSET_AutLogOutCurrent) {}
/*      */   
/*      */   public void onPA_PSET_LYNKID(PATypes.PA_PSET_LYNKID paramPA_PSET_LYNKID) {}
/*      */   
/*      */   public void onPA_PSET_LYNKID_Result(PATypes.PA_PSET_LYNKID_Result paramPA_PSET_LYNKID_Result) {}
/*      */   
/*      */   public void onPA_PSET_NFCID(PATypes.PA_PSET_NFCID paramPA_PSET_NFCID) {}
/*      */   
/*      */   public void onPA_PSET_NFC_Result(PATypes.PA_PSET_NFC_Result paramPA_PSET_NFC_Result) {}
/*      */   
/*      */   public void onPA_PSET_SimplUnlockCurrent(PATypes.PA_PSET_SimplUnlockCurrent paramPA_PSET_SimplUnlockCurrent) {}
/*      */   
/*      */   public void onPA_PSET_User1(PATypes.PA_PSET_User1 paramPA_PSET_User1) {}
/*      */   
/*      */   public void onPA_PSET_User2(PATypes.PA_PSET_User2 paramPA_PSET_User2) {}
/*      */   
/*      */   public void onPA_PSET_User3(PATypes.PA_PSET_User3 paramPA_PSET_User3) {}
/*      */   
/*      */   public void onPA_PSET_User4(PATypes.PA_PSET_User4 paramPA_PSET_User4) {}
/*      */   
/*      */   public void onPA_PSET_User5(PATypes.PA_PSET_User5 paramPA_PSET_User5) {}
/*      */   
/*      */   public void onPA_PSET_User6(PATypes.PA_PSET_User6 paramPA_PSET_User6) {}
/*      */   
/*      */   public void onPA_PSET_SeatButtonOnOff(PATypes.PA_PSET_SeatButtonOnOff paramPA_PSET_SeatButtonOnOff) {}
/*      */   
/*      */   public void onPA_PSET_SeatLocationAdjust(PATypes.PA_PSET_SeatLocationAdjust paramPA_PSET_SeatLocationAdjust) {}
/*      */   
/*      */   public void onPA_PSET_GID_Result(PATypes.PA_PSET_GID_Result paramPA_PSET_GID_Result) {}
/*      */   
/*      */   public void onPA_PSET_ProfAct(PATypes.PA_PSET_ProfAct paramPA_PSET_ProfAct) {}
/*      */   
/*      */   public void onPA_PSET_ProfileCloudData(PATypes.PA_PSET_ProfileCloudData paramPA_PSET_ProfileCloudData) {}
/*      */   
/*      */   public void onPA_PSET_ProfileDownloadStatus(PATypes.PA_PSET_ProfileDownloadStatus paramPA_PSET_ProfileDownloadStatus) {}
/*      */   
/*      */   public void onPA_PSET_ProfilesInuse(PATypes.PA_PSET_ProfilesInuse paramPA_PSET_ProfilesInuse) {}
/*      */   
/*      */   public void onPA_AmpDiagResult(PATypes.PA_AmpDiagResult paramPA_AmpDiagResult) {}
/*      */   
/*      */   public void onPA_AP_Version(PATypes.PA_AP_Version paramPA_AP_Version) {}
/*      */   
/*      */   public void onPA_TS_MsgEnd(PATypes.PA_TS_MsgEnd paramPA_TS_MsgEnd) {}
/*      */   
/*      */   public void onPA_Asy_MsgEnd(PATypes.PA_Asy_MsgEnd paramPA_Asy_MsgEnd) {}
/*      */   
/*      */   public void onPA_DiagProxy_MsgEnd(PATypes.PA_DiagProxy_MsgEnd paramPA_DiagProxy_MsgEnd) {}
/*      */   
/*      */   public void onPA_DID_MsgEnd(PATypes.PA_DID_MsgEnd paramPA_DID_MsgEnd) {}
/*      */   
/*      */   public void onPA_CL_MsgEnd(PATypes.PA_CL_MsgEnd paramPA_CL_MsgEnd) {}
/*      */   
/*      */   public void onPA_SCV_MsgEnd(PATypes.PA_SCV_MsgEnd paramPA_SCV_MsgEnd) {}
/*      */   
/*      */   public void onPA_SWH_MsgEnd(PATypes.PA_SWH_MsgEnd paramPA_SWH_MsgEnd) {}
/*      */   
/*      */   public void onPA_Fragra_MsgEnd(PATypes.PA_Fragra_MsgEnd paramPA_Fragra_MsgEnd) {}
/*      */   
/*      */   public void onPA_TCH_MsgEnd(PATypes.PA_TCH_MsgEnd paramPA_TCH_MsgEnd) {}
/*      */   
/*      */   public void onPA_DriveMode_MsgEnd(PATypes.PA_DriveMode_MsgEnd paramPA_DriveMode_MsgEnd) {}
/*      */   
/*      */   public void onPA_PSET_MsgEnd(PATypes.PA_PSET_MsgEnd paramPA_PSET_MsgEnd) {}
/*      */   
/*      */   public void onPA_SS_MsgEnd(PATypes.PA_SS_MsgEnd paramPA_SS_MsgEnd) {}
/*      */   
/*      */   public void onPA_Device_MsgEnd(PATypes.PA_Device_MsgEnd paramPA_Device_MsgEnd) {}
/*      */   
/*      */   public void onPA_HUD_MsgEnd(PATypes.PA_HUD_MsgEnd paramPA_HUD_MsgEnd) {}
/*      */   
/*      */   public void onPA_VFC_MsgEnd(PATypes.PA_VFC_MsgEnd paramPA_VFC_MsgEnd) {}
/*      */   
/*      */   public void onPA_PAC_MsgEnd(PATypes.PA_PAC_MsgEnd paramPA_PAC_MsgEnd) {}
/*      */   
/*      */   public void onPA_PAS_MsgEnd(PATypes.PA_PAS_MsgEnd paramPA_PAS_MsgEnd) {}
/*      */   
/*      */   public void onPA_SC_MsgEnd(PATypes.PA_SC_MsgEnd paramPA_SC_MsgEnd) {}
/*      */   
/*      */   public void onPA_VehCharg_MsgEnd(PATypes.PA_VehCharg_MsgEnd paramPA_VehCharg_MsgEnd) {}
/*      */   
/*      */   public void onPA_WPC_MsgEnd(PATypes.PA_WPC_MsgEnd paramPA_WPC_MsgEnd) {}
/*      */   
/*      */   public void onPA_VM_MsgEnd(PATypes.PA_VM_MsgEnd paramPA_VM_MsgEnd) {}
/*      */   
/*      */   public void onPA_VM2_MsgEnd(PATypes.PA_VM2_MsgEnd paramPA_VM2_MsgEnd) {}
/*      */   
/*      */   public void onPA_AmbLi_MsgEnd(PATypes.PA_AmbLi_MsgEnd paramPA_AmbLi_MsgEnd) {}
/*      */   
/*      */   public void onPA_PSET_NameP1(PATypes.PA_PSET_NameP1 paramPA_PSET_NameP1) {}
/*      */   
/*      */   public void onPA_PSET_NameP2(PATypes.PA_PSET_NameP2 paramPA_PSET_NameP2) {}
/*      */   
/*      */   public void onPA_PSET_NameP3(PATypes.PA_PSET_NameP3 paramPA_PSET_NameP3) {}
/*      */   
/*      */   public void onPA_PSET_NameP4(PATypes.PA_PSET_NameP4 paramPA_PSET_NameP4) {}
/*      */   
/*      */   public void onPA_PSET_NameP5(PATypes.PA_PSET_NameP5 paramPA_PSET_NameP5) {}
/*      */   
/*      */   public void onPA_HUD_DispModSet(PATypes.PA_HUD_DispModSet paramPA_HUD_DispModSet) {}
/*      */   
/*      */   public void onPA_NAVI_VehEgyCoornOpenAndCls(PATypes.PA_NAVI_VehEgyCoornOpenAndCls paramPA_NAVI_VehEgyCoornOpenAndCls) {}
/*      */   
/*      */   public void onPA_NAVI_VehEgyCoornFctStChg(PATypes.PA_NAVI_VehEgyCoornFctStChg paramPA_NAVI_VehEgyCoornFctStChg) {}
/*      */   
/*      */   public void onPA_TS_CurTripDis(PATypes.PA_TS_CurTripDis paramPA_TS_CurTripDis) {}
/*      */   
/*      */   public void onPA_TS_CurTripTime(PATypes.PA_TS_CurTripTime paramPA_TS_CurTripTime) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldWakeUp(PATypes.PA_SCEMOD_SceneModSeldWakeUp paramPA_SCEMOD_SceneModSeldWakeUp) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldRomantic(PATypes.PA_SCEMOD_SceneModSeldRomantic paramPA_SCEMOD_SceneModSeldRomantic) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldPet(PATypes.PA_SCEMOD_SceneModSeldPet paramPA_SCEMOD_SceneModSeldPet) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldCarWash(PATypes.PA_SCEMOD_SceneModSeldCarWash paramPA_SCEMOD_SceneModSeldCarWash) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldStranger(PATypes.PA_SCEMOD_SceneModSeldStranger paramPA_SCEMOD_SceneModSeldStranger) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldBiochal(PATypes.PA_SCEMOD_SceneModSeldBiochal paramPA_SCEMOD_SceneModSeldBiochal) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldChild(PATypes.PA_SCEMOD_SceneModSeldChild paramPA_SCEMOD_SceneModSeldChild) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldDriverRest(PATypes.PA_SCEMOD_SceneModSeldDriverRest paramPA_SCEMOD_SceneModSeldDriverRest) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldPassengerRest(PATypes.PA_SCEMOD_SceneModSeldPassengerRest paramPA_SCEMOD_SceneModSeldPassengerRest) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldSecondLeftRest(PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest paramPA_SCEMOD_SceneModSeldSecondLeftRest) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldSecondRightRest(PATypes.PA_SCEMOD_SceneModSeldSecondRightRest paramPA_SCEMOD_SceneModSeldSecondRightRest) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldFrontRowTheater(PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater paramPA_SCEMOD_SceneModSeldFrontRowTheater) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldRearRowTheater(PATypes.PA_SCEMOD_SceneModSeldRearRowTheater paramPA_SCEMOD_SceneModSeldRearRowTheater) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldEco(PATypes.PA_SCEMOD_SceneModSeldEco paramPA_SCEMOD_SceneModSeldEco) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldKing(PATypes.PA_SCEMOD_SceneModSeldKing paramPA_SCEMOD_SceneModSeldKing) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldValue(PATypes.PA_SCEMOD_SceneModSeldValue paramPA_SCEMOD_SceneModSeldValue) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldGoddess(PATypes.PA_SCEMOD_SceneModSeldGoddess paramPA_SCEMOD_SceneModSeldGoddess) {}
/*      */   
/*      */   public void onPA_SCEMOD_PassSceneModSeldValue(PATypes.PA_SCEMOD_PassSceneModSeldValue paramPA_SCEMOD_PassSceneModSeldValue) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldPassengerRepose(PATypes.PA_SCEMOD_SceneModSeldPassengerRepose paramPA_SCEMOD_SceneModSeldPassengerRepose) {}
/*      */   
/*      */   public void onPA_FD_FaceIdnReq(PATypes.PA_FD_FaceIdnReq paramPA_FD_FaceIdnReq) {}
/*      */   
/*      */   public void onPA_SENSOR_DstToSrvValue(PATypes.PA_SENSOR_DstToSrvValue paramPA_SENSOR_DstToSrvValue) {}
/*      */   
/*      */   public void onPA_SENSOR_DayToSrvValue(PATypes.PA_SENSOR_DayToSrvValue paramPA_SENSOR_DayToSrvValue) {}
/*      */   
/*      */   public void onPA_SENSOR_EngHrToSrvValue(PATypes.PA_SENSOR_EngHrToSrvValue paramPA_SENSOR_EngHrToSrvValue) {}
/*      */   
/*      */   public void onPA_SENSOR_JoyLimitState(PATypes.PA_SENSOR_JoyLimitState paramPA_SENSOR_JoyLimitState) {}
/*      */   
/*      */   public void onPA_SENSOR_JoyForbidState(PATypes.PA_SENSOR_JoyForbidState paramPA_SENSOR_JoyForbidState) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldQuitStranger(PATypes.PA_SCEMOD_SceneModSeldQuitStranger paramPA_SCEMOD_SceneModSeldQuitStranger) {}
/*      */   
/*      */   public void onPA_SCEMOD_SceneModSeldCustomization(PATypes.PA_SCEMOD_SceneModSeldCustomization paramPA_SCEMOD_SceneModSeldCustomization) {}
/*      */   
/*      */   public void onPA_VehCharg_ChargingColumn(PATypes.PA_VehCharg_ChargingColumn paramPA_VehCharg_ChargingColumn) {}
/*      */   
/*      */   public void onPA_CnclFaceReqForProf(PATypes.PA_CnclFaceReqForProf paramPA_CnclFaceReqForProf) {}
/*      */   
/*      */   public void onPA_FaceIdnReq(PATypes.PA_FaceIdnReq paramPA_FaceIdnReq) {}
/*      */   
/*      */   public void onPA_FaceSgnInForProf(PATypes.PA_FaceSgnInForProf paramPA_FaceSgnInForProf) {}
/*      */   
/*      */   public void onPA_HudDispModSetgReq(PATypes.PA_HudDispModSetgReq paramPA_HudDispModSetgReq) {}
/*      */   
/*      */   public void onPA_PrkgIndcrLineReq(PATypes.PA_PrkgIndcrLineReq paramPA_PrkgIndcrLineReq) {}
/*      */   
/*      */   public void onPA_SurrndgsObjDetnReq(PATypes.PA_SurrndgsObjDetnReq paramPA_SurrndgsObjDetnReq) {}
/*      */   
/*      */   public void onPA_ThrDTouringViewReq(PATypes.PA_ThrDTouringViewReq paramPA_ThrDTouringViewReq) {}
/*      */   
/*      */   public void onPA_TopVisnDispExtnReq(PATypes.PA_TopVisnDispExtnReq paramPA_TopVisnDispExtnReq) {}
/*      */   
/*      */   public void onPA_TurnEntryAgWideVisReq(PATypes.PA_TurnEntryAgWideVisReq paramPA_TurnEntryAgWideVisReq) {}
/*      */   
/*      */   public void onPA_VehMdlClrReq(PATypes.PA_VehMdlClrReq paramPA_VehMdlClrReq) {}
/*      */   
/*      */   void onErrorEvent(int paramInt1, int paramInt2) {}
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\CarPAEventCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */