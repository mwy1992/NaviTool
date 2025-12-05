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
/*     */ public final class DrvrGearLvrLockIndcn3
/*     */ {
/*     */   public static final int ChgOfVehMovmtDirNotPsbl = 4;
/*     */   public static final int EngStrtNoPsbl = 3;
/*     */   public static final int GearLvrMovmtToManNotAllwd = 2;
/*     */   public static final int GearLvrRelsByBrkPedl = 1;
/*     */   public static final int GearLvrRelsByBrkPedlAndLockButton = 8;
/*     */   public static final int GearShiftSrvRqrd = 5;
/*     */   public static final int ManModActvd = 6;
/*     */   public static final int NoIndcn = 0;
/*     */   public static final int PLockUnavailable = 14;
/*     */   public static final int ReleaseLockButton = 7;
/*     */   public static final int RetuenShifterToInitialState = 9;
/*     */   public static final int ReturnPaddleToInitialState = 13;
/*     */   public static final int ShiftToDOrMToAllowManualMode = 10;
/*     */   public static final int StopPushingLockButton = 12;
/*     */   public static final int StopPushingPButton = 11;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  33 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  34 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  81 */         return str;
/*     */       case 14:
/*     */         str = "PLockUnavailable";
/*     */       case 13:
/*     */         str = "ReturnPaddleToInitialState";
/*     */       case 12:
/*     */         str = "StopPushingLockButton";
/*     */       case 11:
/*     */         str = "StopPushingPButton";
/*     */       case 10:
/*     */         str = "ShiftToDOrMToAllowManualMode";
/*     */       case 9:
/*     */         str = "RetuenShifterToInitialState";
/*     */       case 8:
/*     */         str = "GearLvrRelsByBrkPedlAndLockButton";
/*     */       case 7:
/*     */         str = "ReleaseLockButton";
/*     */       case 6:
/*     */         str = "ManModActvd";
/*     */       case 5:
/*     */         str = "GearShiftSrvRqrd";
/*     */       case 4:
/*     */         str = "ChgOfVehMovmtDirNotPsbl";
/*     */       case 3:
/*     */         str = "EngStrtNoPsbl";
/*     */       case 2:
/*     */         str = "GearLvrMovmtToManNotAllwd";
/*     */       case 1:
/*     */         str = "GearLvrRelsByBrkPedl";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoIndcn";
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
/* 126 */     boolean bool = false;
/*     */     
/* 128 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14)
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
/* 143 */       bool = true;
/*     */     }
/*     */     
/* 146 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvrGearLvrLockIndcn3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */