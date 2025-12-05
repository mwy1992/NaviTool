/*     */ package ecarx.car.hardware.annotation;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DrvrAsscSysDisp
/*     */ {
/*     */   public static final int APASelectRRpaSelectP = 53;
/*     */   public static final int APASelectRRpaSelectPSmallSlotRecommendRPA = 64;
/*     */   public static final int AvmFailOrNoCalibration_UndoInvalid = 45;
/*     */   public static final int CameraSmugled_Active = 49;
/*     */   public static final int CameraSmugled_BeforeActive = 17;
/*     */   public static final int DoorOpen_Active = 22;
/*     */   public static final int DoorOpen_BeforeActive = 10;
/*     */   public static final int EPBActivePleaseUseMobileAPPToConnectVehicle = 76;
/*     */   public static final int EngOff_UndoInvalid = 42;
/*     */   public static final int EpbActivated_Active = 29;
/*     */   public static final int FctaActive_Active = 70;
/*     */   public static final int FoundParkingSlot = 78;
/*     */   public static final int FrontAndRearUssCovered_Active = 50;
/*     */   public static final int FrontUssCovered_Active = 68;
/*     */   public static final int FrontUssCovered_BeforeActive = 72;
/*     */   public static final int FunctionConflict_BeforeActive = 38;
/*     */   public static final int GradeOfRainOverflow_UndoInvalid = 47;
/*     */   public static final int GradientOverRange_BeforeActive = 15;
/*     */   public static final int GradientOverRange_Searching = 13;
/*     */   public static final int GradientOverranging_UndoInvalid = 33;
/*     */   public static final int GradientOverranging_UndoValid = 48;
/*     */   public static final int HeavyRain_BeforeActive = 39;
/*     */   public static final int HoldOpen_Active = 27;
/*     */   public static final int HoldOpen_BeforeActive = 20;
/*     */   public static final int InterruptTimesOverflow_UndoInvalid = 32;
/*     */   public static final int InterveneSystemActive_UndoInvalid = 35;
/*     */   public static final int MirrorFold_Active = 26;
/*     */   public static final int MirrorFold_BeforeActive = 18;
/*     */   public static final int MoveTimesOverflow_UndoInvalid = 31;
/*     */   public static final int ObstacleOccur_Active = 28;
/*     */   public static final int Off = 0;
/*     */   public static final int OutOfTrajectory_UndoInvalid = 36;
/*     */   public static final int OverrideByGasPedal_Active = 51;
/*     */   public static final int OverrideByGearShift_Active = 46;
/*     */   public static final int OverrideBySteeringWheel_Active = 57;
/*     */   public static final int ParkingFinished = 56;
/*     */   public static final int ParkingInParkingOutSelect = 1;
/*     */   public static final int ParkingInterruptRecoverPleaseSelectContinueOrNot = 75;
/*     */   public static final int ParkingQuit = 74;
/*     */   public static final int ParkingTimeout_UndoInvalid = 40;
/*     */   public static final int PasFail_UndoInvalid = 44;
/*     */   public static final int PleaseConnectTheAppAndTakeOutKey = 79;
/*     */   public static final int RctaActive_Active = 71;
/*     */   public static final int RearUSSCovered_And_BeforeActive = 73;
/*     */   public static final int RearUssCovered_Active = 69;
/*     */   public static final int RelatedSystemFail_UndoInvalid = 34;
/*     */   public static final int ReleaseTheBrakePedal = 54;
/*     */   public static final int RemoteParkAssistIsFinished = 82;
/*     */   public static final int RemoteParkAssistIsQuit = 81;
/*     */   public static final int RemoteParkAssistIsWorking = 80;
/*     */   public static final int Reserve1 = 2;
/*     */   public static final int Reserve2 = 58;
/*     */   public static final int Reserve3 = 60;
/*     */   public static final int Reserve4 = 62;
/*     */   public static final int Reserve5 = 63;
/*     */   public static final int Reserve6 = 65;
/*     */   public static final int Reserve7 = 66;
/*     */   public static final int Reserve8 = 67;
/*     */   public static final int SearchedParkingSlotPressTheBrakePedalAndSelectParkingSlot_APA = 4;
/*     */   public static final int SearchedParkingSlotPressTheBrakePedalAndSelectParkingSlot_APARPA = 9;
/*     */   public static final int SearchedParkingSlotPressTheBrakePedalAndSelectParkingSlot_RPA = 11;
/*     */   public static final int SearchingParkingSlot = 77;
/*     */   public static final int SeatBeltReleased_Active = 21;
/*     */   public static final int SeatBeltReleased_BeforeActive = 8;
/*     */   public static final int SelectDGear = 59;
/*     */   public static final int SelectRGear = 61;
/*     */   public static final int SelectRecommendParkingSpaceAndHangD_Or_ClickAnotherParkingSpace = 5;
/*     */   public static final int SelectRecommendParkingSpaceAndHangR_Or_ClickAnotherParkingSpace = 6;
/*     */   public static final int SpaceLimit_UndoInvalid = 41;
/*     */   public static final int SpeedNotZeroAndCanNotParkingOut = 7;
/*     */   public static final int SysTimeoutParkingFunctionQuitPleaseTakeOverTheCar = 55;
/*     */   public static final int SystemFault_BeforeActive = 37;
/*     */   public static final int TheUserResponseTimeout_UndoInvalid = 43;
/*     */   public static final int TheUserResponseTimeout_UndoValid = 52;
/*     */   public static final int TowbarActive_Active = 25;
/*     */   public static final int TowbarActive_BeforeActive = 16;
/*     */   public static final int TrailerActive_Active = 24;
/*     */   public static final int TrailerActive_BeforeActive = 14;
/*     */   public static final int TrunkOpen_Active = 23;
/*     */   public static final int TrunkOpen_BeforeActive = 12;
/*     */   public static final int UssCovered_BeforeActive = 19;
/*     */   public static final int VehicleSpeedIsTooFastPleaseSlowDown = 3;
/*     */   public static final int VehicleSpeedOverranging_UndoInvalid = 30;
/*     */   
/*     */   public static String toString(int paramInt) {
/* 101 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 102 */     switch (paramInt) {
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
/*     */       default:
/* 353 */         return str;
/*     */       case 82:
/*     */         str = "RemoteParkAssistIsFinished";
/*     */       case 81:
/*     */         str = "RemoteParkAssistIsQuit";
/*     */       case 80:
/*     */         str = "RemoteParkAssistIsWorking";
/*     */       case 79:
/*     */         str = "PleaseConnectTheAppAndTakeOutKey";
/*     */       case 78:
/*     */         str = "FoundParkingSlot";
/*     */       case 77:
/*     */         str = "SearchingParkingSlot";
/*     */       case 76:
/*     */         str = "EPBActivePleaseUseMobileAPPToConnectVehicle";
/*     */       case 75:
/*     */         str = "ParkingInterruptRecoverPleaseSelectContinueOrNot";
/*     */       case 74:
/*     */         str = "ParkingQuit";
/*     */       case 73:
/*     */         str = "RearUSSCovered_And_BeforeActive";
/*     */       case 72:
/*     */         str = "FrontUssCovered_BeforeActive";
/*     */       case 71:
/*     */         str = "RctaActive_Active";
/*     */       case 70:
/*     */         str = "FctaActive_Active";
/*     */       case 69:
/*     */         str = "RearUssCovered_Active";
/*     */       case 68:
/*     */         str = "FrontUssCovered_Active";
/*     */       case 67:
/*     */         str = "Reserve8";
/*     */       case 66:
/*     */         str = "Reserve7";
/*     */       case 65:
/*     */         str = "Reserve6";
/*     */       case 64:
/*     */         str = "APASelectRRpaSelectPSmallSlotRecommendRPA";
/*     */       case 63:
/*     */         str = "Reserve5";
/*     */       case 62:
/*     */         str = "Reserve4";
/*     */       case 61:
/*     */         str = "SelectRGear";
/*     */       case 60:
/*     */         str = "Reserve3";
/*     */       case 59:
/*     */         str = "SelectDGear";
/*     */       case 58:
/*     */         str = "Reserve2";
/*     */       case 57:
/*     */         str = "OverrideBySteeringWheel_Active";
/*     */       case 56:
/*     */         str = "ParkingFinished";
/*     */       case 55:
/*     */         str = "SysTimeoutParkingFunctionQuitPleaseTakeOverTheCar";
/*     */       case 54:
/*     */         str = "ReleaseTheBrakePedal";
/*     */       case 53:
/*     */         str = "APASelectRRpaSelectP";
/*     */       case 52:
/*     */         str = "TheUserResponseTimeout_UndoValid";
/*     */       case 51:
/*     */         str = "OverrideByGasPedal_Active";
/*     */       case 50:
/*     */         str = "FrontAndRearUssCovered_Active";
/*     */       case 49:
/*     */         str = "CameraSmugled_Active";
/*     */       case 48:
/*     */         str = "GradientOverranging_UndoValid";
/*     */       case 47:
/*     */         str = "GradeOfRainOverflow_UndoInvalid";
/*     */       case 46:
/*     */         str = "OverrideByGearShift_Active";
/*     */       case 45:
/*     */         str = "AvmFailOrNoCalibration_UndoInvalid";
/*     */       case 44:
/*     */         str = "PasFail_UndoInvalid";
/*     */       case 43:
/*     */         str = "TheUserResponseTimeout_UndoInvalid";
/*     */       case 42:
/*     */         str = "EngOff_UndoInvalid";
/*     */       case 41:
/*     */         str = "SpaceLimit_UndoInvalid";
/*     */       case 40:
/*     */         str = "ParkingTimeout_UndoInvalid";
/*     */       case 39:
/*     */         str = "HeavyRain_BeforeActive";
/*     */       case 38:
/*     */         str = "FunctionConflict_BeforeActive";
/*     */       case 37:
/*     */         str = "SystemFault_BeforeActive";
/*     */       case 36:
/*     */         str = "OutOfTrajectory_UndoInvalid";
/*     */       case 35:
/*     */         str = "InterveneSystemActive_UndoInvalid";
/*     */       case 34:
/*     */         str = "RelatedSystemFail_UndoInvalid";
/*     */       case 33:
/*     */         str = "GradientOverranging_UndoInvalid";
/*     */       case 32:
/*     */         str = "InterruptTimesOverflow_UndoInvalid";
/*     */       case 31:
/*     */         str = "MoveTimesOverflow_UndoInvalid";
/*     */       case 30:
/*     */         str = "VehicleSpeedOverranging_UndoInvalid";
/*     */       case 29:
/*     */         str = "EpbActivated_Active";
/*     */       case 28:
/*     */         str = "ObstacleOccur_Active";
/*     */       case 27:
/*     */         str = "HoldOpen_Active";
/*     */       case 26:
/*     */         str = "MirrorFold_Active";
/*     */       case 25:
/*     */         str = "TowbarActive_Active";
/*     */       case 24:
/*     */         str = "TrailerActive_Active";
/*     */       case 23:
/*     */         str = "TrunkOpen_Active";
/*     */       case 22:
/*     */         str = "DoorOpen_Active";
/*     */       case 21:
/*     */         str = "SeatBeltReleased_Active";
/*     */       case 20:
/*     */         str = "HoldOpen_BeforeActive";
/*     */       case 19:
/*     */         str = "UssCovered_BeforeActive";
/*     */       case 18:
/*     */         str = "MirrorFold_BeforeActive";
/*     */       case 17:
/*     */         str = "CameraSmugled_BeforeActive";
/*     */       case 16:
/*     */         str = "TowbarActive_BeforeActive";
/*     */       case 15:
/*     */         str = "GradientOverRange_BeforeActive";
/*     */       case 14:
/*     */         str = "TrailerActive_BeforeActive";
/*     */       case 13:
/*     */         str = "GradientOverRange_Searching";
/*     */       case 12:
/*     */         str = "TrunkOpen_BeforeActive";
/*     */       case 11:
/*     */         str = "SearchedParkingSlotPressTheBrakePedalAndSelectParkingSlot_RPA";
/*     */       case 10:
/*     */         str = "DoorOpen_BeforeActive";
/*     */       case 9:
/*     */         str = "SearchedParkingSlotPressTheBrakePedalAndSelectParkingSlot_APARPA";
/*     */       case 8:
/*     */         str = "SeatBeltReleased_BeforeActive";
/*     */       case 7:
/*     */         str = "SpeedNotZeroAndCanNotParkingOut";
/*     */       case 6:
/*     */         str = "SelectRecommendParkingSpaceAndHangR_Or_ClickAnotherParkingSpace";
/*     */       case 5:
/*     */         str = "SelectRecommendParkingSpaceAndHangD_Or_ClickAnotherParkingSpace";
/*     */       case 4:
/*     */         str = "SearchedParkingSlotPressTheBrakePedalAndSelectParkingSlot_APA";
/*     */       case 3:
/*     */         str = "VehicleSpeedIsTooFastPleaseSlowDown";
/*     */       case 2:
/*     */         str = "Reserve1";
/*     */       case 1:
/*     */         str = "ParkingInParkingOutSelect";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Off";
/*     */   }
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
/*     */   public static boolean isValid(int paramInt) {
/* 534 */     boolean bool = false;
/*     */     
/* 536 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31 || paramInt == 32 || paramInt == 33 || paramInt == 34 || paramInt == 35 || paramInt == 36 || paramInt == 37 || paramInt == 38 || paramInt == 39 || paramInt == 40 || paramInt == 41 || paramInt == 42 || paramInt == 43 || paramInt == 44 || paramInt == 45 || paramInt == 46 || paramInt == 47 || paramInt == 48 || paramInt == 49 || paramInt == 50 || paramInt == 51 || paramInt == 52 || paramInt == 53 || paramInt == 54 || paramInt == 55 || paramInt == 56 || paramInt == 57 || paramInt == 58 || paramInt == 59 || paramInt == 60 || paramInt == 61 || paramInt == 62 || paramInt == 63 || paramInt == 64 || paramInt == 65 || paramInt == 66 || paramInt == 67 || paramInt == 68 || paramInt == 69 || paramInt == 70 || paramInt == 71 || paramInt == 72 || paramInt == 73 || paramInt == 74 || paramInt == 75 || paramInt == 76 || paramInt == 77 || paramInt == 78 || paramInt == 79 || paramInt == 80 || paramInt == 81 || paramInt == 82)
/*     */     {
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
/* 619 */       bool = true;
/*     */     }
/*     */     
/* 622 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvrAsscSysDisp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */