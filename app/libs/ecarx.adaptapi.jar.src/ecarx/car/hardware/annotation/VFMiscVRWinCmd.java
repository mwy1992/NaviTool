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
/*     */ public final class VFMiscVRWinCmd
/*     */ {
/*     */   public static final int LittlechangedriverHigh = 10;
/*     */   public static final int LittlechangedriverLow = 11;
/*     */   public static final int LittlechangepassHigh = 12;
/*     */   public static final int LittlechangepassLow = 13;
/*     */   public static final int LittlechangerearleftHigh = 14;
/*     */   public static final int LittlechangerearleftLow = 15;
/*     */   public static final int LittlechangerearrightHigh = 16;
/*     */   public static final int LittlechangerearrightLow = 17;
/*     */   public static final int Open20 = 7;
/*     */   public static final int OpenFront = 5;
/*     */   public static final int OpenFront48 = 8;
/*     */   public static final int OpenFull = 0;
/*     */   public static final int OpenIndeDriver = 1;
/*     */   public static final int OpenIndePass = 2;
/*     */   public static final int OpenIndeRearLeft = 3;
/*     */   public static final int OpenIndeRearRight = 4;
/*     */   public static final int OpenRear = 6;
/*     */   public static final int OpenRear48 = 9;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  34 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  35 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  91 */         return str;
/*     */       case 17:
/*     */         str = "LittlechangerearrightLow";
/*     */       case 16:
/*     */         str = "LittlechangerearrightHigh";
/*     */       case 15:
/*     */         str = "LittlechangerearleftLow";
/*     */       case 14:
/*     */         str = "LittlechangerearleftHigh";
/*     */       case 13:
/*     */         str = "LittlechangepassLow";
/*     */       case 12:
/*     */         str = "LittlechangepassHigh";
/*     */       case 11:
/*     */         str = "LittlechangedriverLow";
/*     */       case 10:
/*     */         str = "LittlechangedriverHigh";
/*     */       case 9:
/*     */         str = "OpenRear48";
/*     */       case 8:
/*     */         str = "OpenFront48";
/*     */       case 7:
/*     */         str = "Open20";
/*     */       case 6:
/*     */         str = "OpenRear";
/*     */       case 5:
/*     */         str = "OpenFront";
/*     */       case 4:
/*     */         str = "OpenIndeRearRight";
/*     */       case 3:
/*     */         str = "OpenIndeRearLeft";
/*     */       case 2:
/*     */         str = "OpenIndePass";
/*     */       case 1:
/*     */         str = "OpenIndeDriver";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "OpenFull";
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
/* 142 */     boolean bool = false;
/*     */     
/* 144 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17)
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
/* 162 */       bool = true;
/*     */     }
/*     */     
/* 165 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VFMiscVRWinCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */