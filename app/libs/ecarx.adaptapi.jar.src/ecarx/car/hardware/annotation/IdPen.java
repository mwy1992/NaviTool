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
/*     */ public final class IdPen
/*     */ {
/*     */   public static final int Prof1 = 1;
/*     */   public static final int Prof10 = 10;
/*     */   public static final int Prof11 = 11;
/*     */   public static final int Prof12 = 12;
/*     */   public static final int Prof13 = 13;
/*     */   public static final int Prof2 = 2;
/*     */   public static final int Prof3 = 3;
/*     */   public static final int Prof4 = 4;
/*     */   public static final int Prof5 = 5;
/*     */   public static final int Prof6 = 6;
/*     */   public static final int Prof7 = 7;
/*     */   public static final int Prof8 = 8;
/*     */   public static final int Prof9 = 9;
/*     */   public static final int ProfAll = 15;
/*     */   public static final int ProfUkwn = 0;
/*     */   public static final int Resd14 = 14;
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
/*     */         str = "ProfAll";
/*     */       case 14:
/*     */         str = "Resd14";
/*     */       case 13:
/*     */         str = "Prof13";
/*     */       case 12:
/*     */         str = "Prof12";
/*     */       case 11:
/*     */         str = "Prof11";
/*     */       case 10:
/*     */         str = "Prof10";
/*     */       case 9:
/*     */         str = "Prof9";
/*     */       case 8:
/*     */         str = "Prof8";
/*     */       case 7:
/*     */         str = "Prof7";
/*     */       case 6:
/*     */         str = "Prof6";
/*     */       case 5:
/*     */         str = "Prof5";
/*     */       case 4:
/*     */         str = "Prof4";
/*     */       case 3:
/*     */         str = "Prof3";
/*     */       case 2:
/*     */         str = "Prof2";
/*     */       case 1:
/*     */         str = "Prof1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "ProfUkwn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\IdPen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */