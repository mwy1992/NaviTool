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
/*     */ public final class LgtDegrad1
/*     */ {
/*     */   public static final int AbsEscTemporarilyOff_Yellow = 2;
/*     */   public static final int EpbFailr_Yellow = 6;
/*     */   public static final int EscServiceRequired_Yellow = 3;
/*     */   public static final int EscTemporarilyOff_Yellow = 4;
/*     */   public static final int GeneralBrakeFailure_Yellow = 11;
/*     */   public static final int LgtFailr_Red = 1;
/*     */   public static final int NoDegradation_Green = 0;
/*     */   public static final int PropADModCtrlInhbn_Yellow = 8;
/*     */   public static final int PropTotallyFault_Yellow = 10;
/*     */   public static final int PropTrqLimitation_Yellow = 9;
/*     */   public static final int Reserved4_12 = 12;
/*     */   public static final int Reserved5_13 = 13;
/*     */   public static final int Reserved6_14 = 14;
/*     */   public static final int Reserved7_15 = 15;
/*     */   public static final int StcTemporarilyOff_Yellow = 5;
/*     */   public static final int VdswNOK_Yellow = 7;
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
/*     */         str = "Reserved7_15";
/*     */       case 14:
/*     */         str = "Reserved6_14";
/*     */       case 13:
/*     */         str = "Reserved5_13";
/*     */       case 12:
/*     */         str = "Reserved4_12";
/*     */       case 11:
/*     */         str = "GeneralBrakeFailure_Yellow";
/*     */       case 10:
/*     */         str = "PropTotallyFault_Yellow";
/*     */       case 9:
/*     */         str = "PropTrqLimitation_Yellow";
/*     */       case 8:
/*     */         str = "PropADModCtrlInhbn_Yellow";
/*     */       case 7:
/*     */         str = "VdswNOK_Yellow";
/*     */       case 6:
/*     */         str = "EpbFailr_Yellow";
/*     */       case 5:
/*     */         str = "StcTemporarilyOff_Yellow";
/*     */       case 4:
/*     */         str = "EscTemporarilyOff_Yellow";
/*     */       case 3:
/*     */         str = "EscServiceRequired_Yellow";
/*     */       case 2:
/*     */         str = "AbsEscTemporarilyOff_Yellow";
/*     */       case 1:
/*     */         str = "LgtFailr_Red";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoDegradation_Green";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LgtDegrad1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */