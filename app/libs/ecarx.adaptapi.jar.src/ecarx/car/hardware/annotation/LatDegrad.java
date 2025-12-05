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
/*     */ public final class LatDegrad
/*     */ {
/*     */   public static final int NoDegradation_Green = 0;
/*     */   public static final int Red_fault1 = 1;
/*     */   public static final int Reserved1_11 = 11;
/*     */   public static final int Yellow_fault10 = 10;
/*     */   public static final int Yellow_fault2 = 2;
/*     */   public static final int Yellow_fault3 = 3;
/*     */   public static final int Yellow_fault4 = 4;
/*     */   public static final int Yellow_fault5 = 5;
/*     */   public static final int Yellow_fault6 = 6;
/*     */   public static final int Yellow_fault7 = 7;
/*     */   public static final int Yellow_fault8 = 8;
/*     */   public static final int Yellow_fault9 = 9;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  30 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  31 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  69 */         return str;
/*     */       case 11:
/*     */         str = "Reserved1_11";
/*     */       case 10:
/*     */         str = "Yellow_fault10";
/*     */       case 9:
/*     */         str = "Yellow_fault9";
/*     */       case 8:
/*     */         str = "Yellow_fault8";
/*     */       case 7:
/*     */         str = "Yellow_fault7";
/*     */       case 6:
/*     */         str = "Yellow_fault6";
/*     */       case 5:
/*     */         str = "Yellow_fault5";
/*     */       case 4:
/*     */         str = "Yellow_fault4";
/*     */       case 3:
/*     */         str = "Yellow_fault3";
/*     */       case 2:
/*     */         str = "Yellow_fault2";
/*     */       case 1:
/*     */         str = "Red_fault1";
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
/* 108 */     boolean bool = false;
/*     */     
/* 110 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11)
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
/* 122 */       bool = true;
/*     */     }
/*     */     
/* 125 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LatDegrad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */