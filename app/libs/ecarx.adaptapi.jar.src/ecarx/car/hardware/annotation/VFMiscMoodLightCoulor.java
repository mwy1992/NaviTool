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
/*     */ public final class VFMiscMoodLightCoulor
/*     */ {
/*     */   public static final int Blue = 6;
/*     */   public static final int Green = 4;
/*     */   public static final int Indigo = 5;
/*     */   public static final int OFF = 0;
/*     */   public static final int Orange = 2;
/*     */   public static final int Red = 1;
/*     */   public static final int Violet = 7;
/*     */   public static final int White = 8;
/*     */   public static final int Yellow = 3;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  26 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  55 */         return str;
/*     */       case 8:
/*     */         str = "White";
/*     */       case 7:
/*     */         str = "Violet";
/*     */       case 6:
/*     */         str = "Blue";
/*     */       case 5:
/*     */         str = "Indigo";
/*     */       case 4:
/*     */         str = "Green";
/*     */       case 3:
/*     */         str = "Yellow";
/*     */       case 2:
/*     */         str = "Orange";
/*     */       case 1:
/*     */         str = "Red";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "OFF";
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
/*  88 */     boolean bool = false;
/*     */     
/*  90 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       bool = true;
/*     */     }
/*     */     
/* 102 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VFMiscMoodLightCoulor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */