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
/*     */ public final class HmiHvacFanLvl
/*     */ {
/*     */   public static final int LvlAutMinus = 11;
/*     */   public static final int LvlAutMinusMinus = 10;
/*     */   public static final int LvlAutNorm = 12;
/*     */   public static final int LvlAutPlus = 13;
/*     */   public static final int LvlAutPlusPlus = 14;
/*     */   public static final int LvlMan1 = 1;
/*     */   public static final int LvlMan2 = 2;
/*     */   public static final int LvlMan3 = 3;
/*     */   public static final int LvlMan4 = 4;
/*     */   public static final int LvlMan5 = 5;
/*     */   public static final int LvlMan6 = 6;
/*     */   public static final int LvlMan7 = 7;
/*     */   public static final int LvlMan8 = 8;
/*     */   public static final int LvlMan9 = 9;
/*     */   public static final int Off = 0;
/*     */   public static final int Reserved_15 = 15;
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
/*     */         str = "Reserved_15";
/*     */       case 14:
/*     */         str = "LvlAutPlusPlus";
/*     */       case 13:
/*     */         str = "LvlAutPlus";
/*     */       case 12:
/*     */         str = "LvlAutNorm";
/*     */       case 11:
/*     */         str = "LvlAutMinus";
/*     */       case 10:
/*     */         str = "LvlAutMinusMinus";
/*     */       case 9:
/*     */         str = "LvlMan9";
/*     */       case 8:
/*     */         str = "LvlMan8";
/*     */       case 7:
/*     */         str = "LvlMan7";
/*     */       case 6:
/*     */         str = "LvlMan6";
/*     */       case 5:
/*     */         str = "LvlMan5";
/*     */       case 4:
/*     */         str = "LvlMan4";
/*     */       case 3:
/*     */         str = "LvlMan3";
/*     */       case 2:
/*     */         str = "LvlMan2";
/*     */       case 1:
/*     */         str = "LvlMan1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HmiHvacFanLvl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */