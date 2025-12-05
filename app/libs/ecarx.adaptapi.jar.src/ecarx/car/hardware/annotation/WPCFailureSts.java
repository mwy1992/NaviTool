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
/*     */ public final class WPCFailureSts
/*     */ {
/*     */   public static final int InternalFailure = 5;
/*     */   public static final int Invalid = 15;
/*     */   public static final int NoFailure = 0;
/*     */   public static final int OFOD = 7;
/*     */   public static final int OverPowerProtected = 4;
/*     */   public static final int OverTemperature = 1;
/*     */   public static final int RFOD = 2;
/*     */   public static final int Reserved1_8 = 8;
/*     */   public static final int Reserved2_9 = 9;
/*     */   public static final int Reserved3_10 = 10;
/*     */   public static final int Reserved4_11 = 11;
/*     */   public static final int Reserved5_12 = 12;
/*     */   public static final int Reserved6_13 = 13;
/*     */   public static final int Reserved7_14 = 14;
/*     */   public static final int SmartPhoneNoResponseOrUnknown = 6;
/*     */   public static final int VoltageProtected = 3;
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
/*     */       default:
/*  85 */         return str;
/*     */       case 15:
/*     */         str = "Invalid";
/*     */       case 14:
/*     */         str = "Reserved7_14";
/*     */       case 13:
/*     */         str = "Reserved6_13";
/*     */       case 12:
/*     */         str = "Reserved5_12";
/*     */       case 11:
/*     */         str = "Reserved4_11";
/*     */       case 10:
/*     */         str = "Reserved3_10";
/*     */       case 9:
/*     */         str = "Reserved2_9";
/*     */       case 8:
/*     */         str = "Reserved1_8";
/*     */       case 7:
/*     */         str = "OFOD";
/*     */       case 6:
/*     */         str = "SmartPhoneNoResponseOrUnknown";
/*     */       case 5:
/*     */         str = "InternalFailure";
/*     */       case 4:
/*     */         str = "OverPowerProtected";
/*     */       case 3:
/*     */         str = "VoltageProtected";
/*     */       case 2:
/*     */         str = "RFOD";
/*     */       case 1:
/*     */         str = "OverTemperature";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoFailure";
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
/* 132 */     boolean bool = false;
/*     */     
/* 134 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15)
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
/* 150 */       bool = true;
/*     */     }
/*     */     
/* 153 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WPCFailureSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */