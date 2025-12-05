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
/*     */ public final class RemPrkgWarn
/*     */ {
/*     */   public static final int AVMCameraSmudginess = 43;
/*     */   public static final int BTConnectionMissing3Cycle = 32;
/*     */   public static final int BluetoochFailure = 5;
/*     */   public static final int BrakePedalPressed = 37;
/*     */   public static final int CallDialBeyond2Min = 9;
/*     */   public static final int CallDialLessThan2Min = 51;
/*     */   public static final int Default = 0;
/*     */   public static final int DoorOpen = 39;
/*     */   public static final int DoorUnlockOrTrailIsConnected = 54;
/*     */   public static final int EPBTrigger = 33;
/*     */   public static final int EngineOffOrHVDown = 4;
/*     */   public static final int ExternalECUFailure = 1;
/*     */   public static final int FCTAWarning = 47;
/*     */   public static final int FrontUSSSmudginess = 45;
/*     */   public static final int FrontUSSSmudginessAndRearUSSSmudginess = 44;
/*     */   public static final int GasPedalPressed = 36;
/*     */   public static final int GearIntervention = 35;
/*     */   public static final int GradientOfTheGroundExceed8OrTheSuspendFaultIsNotRemovedExceed30s = 10;
/*     */   public static final int HeavyRain = 7;
/*     */   public static final int HoodOpen = 41;
/*     */   public static final int KeyInVehicle = 53;
/*     */   public static final int LateralEvadibleBrake = 11;
/*     */   public static final int MobileApp = 12;
/*     */   public static final int ObjectsDetectedIncludeTrajectory = 42;
/*     */   public static final int OneMoveLengthGreaterThan0m = 52;
/*     */   public static final int OtherFunctionActive = 3;
/*     */   public static final int OutsideRearMirrorFold = 38;
/*     */   public static final int PASECUFailure = 2;
/*     */   public static final int ParkingSpaceLimit = 14;
/*     */   public static final int RCTAWarning = 48;
/*     */   public static final int RearUSSSmudginess = 46;
/*     */   public static final int RemoteArangeOverflow6m = 49;
/*     */   public static final int Reserved10_24 = 24;
/*     */   public static final int Reserved11_25 = 25;
/*     */   public static final int Reserved12_26 = 26;
/*     */   public static final int Reserved13_27 = 27;
/*     */   public static final int Reserved14_28 = 28;
/*     */   public static final int Reserved15_29 = 29;
/*     */   public static final int Reserved16_30 = 30;
/*     */   public static final int Reserved17_31 = 31;
/*     */   public static final int Reserved1_15 = 15;
/*     */   public static final int Reserved2_16 = 16;
/*     */   public static final int Reserved3_17 = 17;
/*     */   public static final int Reserved4_18 = 18;
/*     */   public static final int Reserved5_19 = 19;
/*     */   public static final int Reserved6_20 = 20;
/*     */   public static final int Reserved7_21 = 21;
/*     */   public static final int Reserved8_22 = 22;
/*     */   public static final int Reserved9_23 = 23;
/*     */   public static final int SpeedGreaterThan3kmh = 6;
/*     */   public static final int SteeringWheelIntervention = 34;
/*     */   public static final int Suspend8Times_MobileDevicePushMoveButton20Times = 8;
/*     */   public static final int TrunkOpen = 40;
/*     */   public static final int UserNoPushButton = 50;
/*     */   public static final int VMMIsFail = 13;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  73 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  74 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 241 */         return str;
/*     */       case 54:
/*     */         str = "DoorUnlockOrTrailIsConnected";
/*     */       case 53:
/*     */         str = "KeyInVehicle";
/*     */       case 52:
/*     */         str = "OneMoveLengthGreaterThan0m";
/*     */       case 51:
/*     */         str = "CallDialLessThan2Min";
/*     */       case 50:
/*     */         str = "UserNoPushButton";
/*     */       case 49:
/*     */         str = "RemoteArangeOverflow6m";
/*     */       case 48:
/*     */         str = "RCTAWarning";
/*     */       case 47:
/*     */         str = "FCTAWarning";
/*     */       case 46:
/*     */         str = "RearUSSSmudginess";
/*     */       case 45:
/*     */         str = "FrontUSSSmudginess";
/*     */       case 44:
/*     */         str = "FrontUSSSmudginessAndRearUSSSmudginess";
/*     */       case 43:
/*     */         str = "AVMCameraSmudginess";
/*     */       case 42:
/*     */         str = "ObjectsDetectedIncludeTrajectory";
/*     */       case 41:
/*     */         str = "HoodOpen";
/*     */       case 40:
/*     */         str = "TrunkOpen";
/*     */       case 39:
/*     */         str = "DoorOpen";
/*     */       case 38:
/*     */         str = "OutsideRearMirrorFold";
/*     */       case 37:
/*     */         str = "BrakePedalPressed";
/*     */       case 36:
/*     */         str = "GasPedalPressed";
/*     */       case 35:
/*     */         str = "GearIntervention";
/*     */       case 34:
/*     */         str = "SteeringWheelIntervention";
/*     */       case 33:
/*     */         str = "EPBTrigger";
/*     */       case 32:
/*     */         str = "BTConnectionMissing3Cycle";
/*     */       case 31:
/*     */         str = "Reserved17_31";
/*     */       case 30:
/*     */         str = "Reserved16_30";
/*     */       case 29:
/*     */         str = "Reserved15_29";
/*     */       case 28:
/*     */         str = "Reserved14_28";
/*     */       case 27:
/*     */         str = "Reserved13_27";
/*     */       case 26:
/*     */         str = "Reserved12_26";
/*     */       case 25:
/*     */         str = "Reserved11_25";
/*     */       case 24:
/*     */         str = "Reserved10_24";
/*     */       case 23:
/*     */         str = "Reserved9_23";
/*     */       case 22:
/*     */         str = "Reserved8_22";
/*     */       case 21:
/*     */         str = "Reserved7_21";
/*     */       case 20:
/*     */         str = "Reserved6_20";
/*     */       case 19:
/*     */         str = "Reserved5_19";
/*     */       case 18:
/*     */         str = "Reserved4_18";
/*     */       case 17:
/*     */         str = "Reserved3_17";
/*     */       case 16:
/*     */         str = "Reserved2_16";
/*     */       case 15:
/*     */         str = "Reserved1_15";
/*     */       case 14:
/*     */         str = "ParkingSpaceLimit";
/*     */       case 13:
/*     */         str = "VMMIsFail";
/*     */       case 12:
/*     */         str = "MobileApp";
/*     */       case 11:
/*     */         str = "LateralEvadibleBrake";
/*     */       case 10:
/*     */         str = "GradientOfTheGroundExceed8OrTheSuspendFaultIsNotRemovedExceed30s";
/*     */       case 9:
/*     */         str = "CallDialBeyond2Min";
/*     */       case 8:
/*     */         str = "Suspend8Times_MobileDevicePushMoveButton20Times";
/*     */       case 7:
/*     */         str = "HeavyRain";
/*     */       case 6:
/*     */         str = "SpeedGreaterThan3kmh";
/*     */       case 5:
/*     */         str = "BluetoochFailure";
/*     */       case 4:
/*     */         str = "EngineOffOrHVDown";
/*     */       case 3:
/*     */         str = "OtherFunctionActive";
/*     */       case 2:
/*     */         str = "PASECUFailure";
/*     */       case 1:
/*     */         str = "ExternalECUFailure";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Default";
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
/* 366 */     boolean bool = false;
/*     */     
/* 368 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31 || paramInt == 32 || paramInt == 33 || paramInt == 34 || paramInt == 35 || paramInt == 36 || paramInt == 37 || paramInt == 38 || paramInt == 39 || paramInt == 40 || paramInt == 41 || paramInt == 42 || paramInt == 43 || paramInt == 44 || paramInt == 45 || paramInt == 46 || paramInt == 47 || paramInt == 48 || paramInt == 49 || paramInt == 50 || paramInt == 51 || paramInt == 52 || paramInt == 53 || paramInt == 54)
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
/* 423 */       bool = true;
/*     */     }
/*     */     
/* 426 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RemPrkgWarn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */