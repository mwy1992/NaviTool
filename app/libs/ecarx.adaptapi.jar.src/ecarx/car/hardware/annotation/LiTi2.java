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
/*     */ public final class LiTi2
/*     */ {
/*     */   public static final int Resd1 = 13;
/*     */   public static final int Resd2 = 14;
/*     */   public static final int Resd3 = 15;
/*     */   public static final int Sec0 = 0;
/*     */   public static final int Sec10 = 1;
/*     */   public static final int Sec100 = 10;
/*     */   public static final int Sec110 = 11;
/*     */   public static final int Sec120 = 12;
/*     */   public static final int Sec20 = 2;
/*     */   public static final int Sec30 = 3;
/*     */   public static final int Sec40 = 4;
/*     */   public static final int Sec50 = 5;
/*     */   public static final int Sec60 = 6;
/*     */   public static final int Sec70 = 7;
/*     */   public static final int Sec80 = 8;
/*     */   public static final int Sec90 = 9;
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
/*     */         str = "Resd3";
/*     */       case 14:
/*     */         str = "Resd2";
/*     */       case 13:
/*     */         str = "Resd1";
/*     */       case 12:
/*     */         str = "Sec120";
/*     */       case 11:
/*     */         str = "Sec110";
/*     */       case 10:
/*     */         str = "Sec100";
/*     */       case 9:
/*     */         str = "Sec90";
/*     */       case 8:
/*     */         str = "Sec80";
/*     */       case 7:
/*     */         str = "Sec70";
/*     */       case 6:
/*     */         str = "Sec60";
/*     */       case 5:
/*     */         str = "Sec50";
/*     */       case 4:
/*     */         str = "Sec40";
/*     */       case 3:
/*     */         str = "Sec30";
/*     */       case 2:
/*     */         str = "Sec20";
/*     */       case 1:
/*     */         str = "Sec10";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Sec0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LiTi2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */