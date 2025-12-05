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
/*     */ public final class State
/*     */ {
/*     */   public static final int BlinkingGreen = 7;
/*     */   public static final int BlinkingRed = 9;
/*     */   public static final int BlinkingYellow = 8;
/*     */   public static final int Green = 3;
/*     */   public static final int GreenAndYellow = 5;
/*     */   public static final int Red = 1;
/*     */   public static final int RedAndGreen = 6;
/*     */   public static final int RedAndYellow = 4;
/*     */   public static final int Unkwn = 0;
/*     */   public static final int Yellow = 2;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  28 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  29 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  61 */         return str;
/*     */       case 9:
/*     */         str = "BlinkingRed";
/*     */       case 8:
/*     */         str = "BlinkingYellow";
/*     */       case 7:
/*     */         str = "BlinkingGreen";
/*     */       case 6:
/*     */         str = "RedAndGreen";
/*     */       case 5:
/*     */         str = "GreenAndYellow";
/*     */       case 4:
/*     */         str = "RedAndYellow";
/*     */       case 3:
/*     */         str = "Green";
/*     */       case 2:
/*     */         str = "Yellow";
/*     */       case 1:
/*     */         str = "Red";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Unkwn";
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
/*  96 */     boolean bool = false;
/*     */     
/*  98 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       bool = true;
/*     */     }
/*     */     
/* 111 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\State.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */