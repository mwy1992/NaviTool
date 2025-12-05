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
/*     */ public final class BlowerReErrSts
/*     */ {
/*     */   public static final int HvacFanReSts1_CircSho = 2;
/*     */   public static final int HvacFanReSts1_IntErr = 1;
/*     */   public static final int HvacFanReSts1_MotIntrptDetd = 8;
/*     */   public static final int HvacFanReSts1_Na = 0;
/*     */   public static final int HvacFanReSts1_Resd1 = 3;
/*     */   public static final int HvacFanReSts1_Resd2 = 5;
/*     */   public static final int HvacFanReSts1_Resd3 = 9;
/*     */   public static final int HvacFanReSts1_Resd4 = 17;
/*     */   public static final int HvacFanReSts1_TOver = 4;
/*     */   public static final int HvacFanReSts1_UHi = 16;
/*     */   public static final int HvacFanReSts1_Uli = 32;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  29 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  30 */     if (paramInt != 32) { switch (paramInt) { default: switch (paramInt) { default: switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 default:
/*  65 */                   return str;
/*     */                 case 17:
/*     */                   str = "HvacFanReSts1_Resd4";
/*     */                 case 16:
/*     */                   break;
/*     */               } 
/*     */               str = "HvacFanReSts1_UHi";
/*     */             case 9:
/*     */               str = "HvacFanReSts1_Resd3";
/*     */             case 8:
/*     */               break; }
/*     */           
/*     */           str = "HvacFanReSts1_MotIntrptDetd";
/*     */         case 5:
/*     */           str = "HvacFanReSts1_Resd2";
/*     */         case 4:
/*     */           str = "HvacFanReSts1_TOver";
/*     */         case 3:
/*     */           str = "HvacFanReSts1_Resd1";
/*     */         case 2:
/*     */           str = "HvacFanReSts1_CircSho";
/*     */         case 1:
/*     */           str = "HvacFanReSts1_IntErr";
/*     */         case 0:
/*     */           break; }
/*     */       
/*     */       str = "HvacFanReSts1_Na"; }
/*     */     
/*     */     str = "HvacFanReSts1_Uli";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isValid(int paramInt) {
/* 102 */     boolean bool = false;
/*     */     
/* 104 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 8 || paramInt == 9 || paramInt == 16 || paramInt == 17 || paramInt == 32)
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
/* 115 */       bool = true;
/*     */     }
/*     */     
/* 118 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\BlowerReErrSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */