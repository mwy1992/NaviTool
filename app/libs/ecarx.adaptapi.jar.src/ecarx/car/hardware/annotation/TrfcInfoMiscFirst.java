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
/*     */ public final class TrfcInfoMiscFirst
/*     */ {
/*     */   public static final int EndOfVehiclePassingNotAllowed = 3;
/*     */   public static final int NoEntrance = 1;
/*     */   public static final int Off = 0;
/*     */   public static final int Reserved_12 = 12;
/*     */   public static final int Roadwork = 8;
/*     */   public static final int Schoolandchildrenwarning = 7;
/*     */   public static final int SpeedLimitControl = 5;
/*     */   public static final int Stop = 4;
/*     */   public static final int USNightSpeedLimit = 6;
/*     */   public static final int VehiclePassingNotAllowed = 2;
/*     */   public static final int leftcurve = 9;
/*     */   public static final int rightcurve = 10;
/*     */   public static final int seriescurves = 11;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  31 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  32 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  73 */         return str;
/*     */       case 12:
/*     */         str = "Reserved_12";
/*     */       case 11:
/*     */         str = "seriescurves";
/*     */       case 10:
/*     */         str = "rightcurve";
/*     */       case 9:
/*     */         str = "leftcurve";
/*     */       case 8:
/*     */         str = "Roadwork";
/*     */       case 7:
/*     */         str = "Schoolandchildrenwarning";
/*     */       case 6:
/*     */         str = "USNightSpeedLimit";
/*     */       case 5:
/*     */         str = "SpeedLimitControl";
/*     */       case 4:
/*     */         str = "Stop";
/*     */       case 3:
/*     */         str = "EndOfVehiclePassingNotAllowed";
/*     */       case 2:
/*     */         str = "VehiclePassingNotAllowed";
/*     */       case 1:
/*     */         str = "NoEntrance";
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
/* 114 */     boolean bool = false;
/*     */     
/* 116 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12)
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
/* 129 */       bool = true;
/*     */     }
/*     */     
/* 132 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TrfcInfoMiscFirst.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */