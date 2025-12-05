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
/*     */ public final class InhbCdnOfPrkgEmgyBrk
/*     */ {
/*     */   public static final int DriverDoorNotClose = 3;
/*     */   public static final int DriverSideRearDoorNoClose = 5;
/*     */   public static final int ESCError = 7;
/*     */   public static final int GearSignalIsInvalid = 12;
/*     */   public static final int HoodNotClose = 2;
/*     */   public static final int MissCommunicateWithAcceleratePedalSignal = 26;
/*     */   public static final int MissCommunicateWithBrakePedalSignal = 28;
/*     */   public static final int MissCommunicateWithDriverDoor = 20;
/*     */   public static final int MissCommunicateWithDriverSideRearDoor = 22;
/*     */   public static final int MissCommunicateWithEPBSignal = 29;
/*     */   public static final int MissCommunicateWithESCSignal = 17;
/*     */   public static final int MissCommunicateWithGearSignal = 13;
/*     */   public static final int MissCommunicateWithHood = 19;
/*     */   public static final int MissCommunicateWithPassengerDoor = 21;
/*     */   public static final int MissCommunicateWithPassengerSideRearDoor = 23;
/*     */   public static final int MissCommunicateWithSteeringAngle = 30;
/*     */   public static final int MissCommunicateWithTailgate = 18;
/*     */   public static final int MissCommunicateWithTheLateralAndLongitudinalAccelerationSignal = 27;
/*     */   public static final int MissCommunicateWithTrailerModeSignal = 25;
/*     */   public static final int MissCommunicateWithVehicleSpeedSignal = 14;
/*     */   public static final int MissCommunicateWithVehicleStandstillStatus = 31;
/*     */   public static final int MissCommunicateWithWheelSpeedDirection = 16;
/*     */   public static final int MissCommunicateWithsafetyBeltSignal = 24;
/*     */   public static final int NoInhibitedConditions = 0;
/*     */   public static final int PassengerDoorNotClose = 4;
/*     */   public static final int PassengerSideRearDoorNoClose = 6;
/*     */   public static final int RainIsTooLarge = 33;
/*     */   public static final int RearviewMirrorFold = 32;
/*     */   public static final int Reserved1_15 = 15;
/*     */   public static final int SafetyBeltUnlock = 8;
/*     */   public static final int TailgateNotClose = 1;
/*     */   public static final int TheLateralAndLongitudinalAccelerationSignalIsInvalid = 11;
/*     */   public static final int TrailerMode = 9;
/*     */   public static final int VehicleSpeedIsInvalid = 10;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  52 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  53 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 157 */         return str;
/*     */       case 33:
/*     */         str = "RainIsTooLarge";
/*     */       case 32:
/*     */         str = "RearviewMirrorFold";
/*     */       case 31:
/*     */         str = "MissCommunicateWithVehicleStandstillStatus";
/*     */       case 30:
/*     */         str = "MissCommunicateWithSteeringAngle";
/*     */       case 29:
/*     */         str = "MissCommunicateWithEPBSignal";
/*     */       case 28:
/*     */         str = "MissCommunicateWithBrakePedalSignal";
/*     */       case 27:
/*     */         str = "MissCommunicateWithTheLateralAndLongitudinalAccelerationSignal";
/*     */       case 26:
/*     */         str = "MissCommunicateWithAcceleratePedalSignal";
/*     */       case 25:
/*     */         str = "MissCommunicateWithTrailerModeSignal";
/*     */       case 24:
/*     */         str = "MissCommunicateWithsafetyBeltSignal";
/*     */       case 23:
/*     */         str = "MissCommunicateWithPassengerSideRearDoor";
/*     */       case 22:
/*     */         str = "MissCommunicateWithDriverSideRearDoor";
/*     */       case 21:
/*     */         str = "MissCommunicateWithPassengerDoor";
/*     */       case 20:
/*     */         str = "MissCommunicateWithDriverDoor";
/*     */       case 19:
/*     */         str = "MissCommunicateWithHood";
/*     */       case 18:
/*     */         str = "MissCommunicateWithTailgate";
/*     */       case 17:
/*     */         str = "MissCommunicateWithESCSignal";
/*     */       case 16:
/*     */         str = "MissCommunicateWithWheelSpeedDirection";
/*     */       case 15:
/*     */         str = "Reserved1_15";
/*     */       case 14:
/*     */         str = "MissCommunicateWithVehicleSpeedSignal";
/*     */       case 13:
/*     */         str = "MissCommunicateWithGearSignal";
/*     */       case 12:
/*     */         str = "GearSignalIsInvalid";
/*     */       case 11:
/*     */         str = "TheLateralAndLongitudinalAccelerationSignalIsInvalid";
/*     */       case 10:
/*     */         str = "VehicleSpeedIsInvalid";
/*     */       case 9:
/*     */         str = "TrailerMode";
/*     */       case 8:
/*     */         str = "SafetyBeltUnlock";
/*     */       case 7:
/*     */         str = "ESCError";
/*     */       case 6:
/*     */         str = "PassengerSideRearDoorNoClose";
/*     */       case 5:
/*     */         str = "DriverSideRearDoorNoClose";
/*     */       case 4:
/*     */         str = "PassengerDoorNotClose";
/*     */       case 3:
/*     */         str = "DriverDoorNotClose";
/*     */       case 2:
/*     */         str = "HoodNotClose";
/*     */       case 1:
/*     */         str = "TailgateNotClose";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoInhibitedConditions";
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
/* 240 */     boolean bool = false;
/*     */     
/* 242 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31 || paramInt == 32 || paramInt == 33)
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
/* 276 */       bool = true;
/*     */     }
/*     */     
/* 279 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\InhbCdnOfPrkgEmgyBrk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */