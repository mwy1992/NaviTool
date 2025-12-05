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
/*     */ public final class Channel
/*     */ {
/*     */   public static final int CH1 = 1;
/*     */   public static final int CH10 = 10;
/*     */   public static final int CH11 = 11;
/*     */   public static final int CH12 = 12;
/*     */   public static final int CH2 = 2;
/*     */   public static final int CH3 = 3;
/*     */   public static final int CH4 = 4;
/*     */   public static final int CH5 = 5;
/*     */   public static final int CH6 = 6;
/*     */   public static final int CH7 = 7;
/*     */   public static final int CH8 = 8;
/*     */   public static final int CH9 = 9;
/*     */   public static final int Invalid = 0;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  31 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  32 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  73 */         return str;
/*     */       case 12:
/*     */         str = "CH12";
/*     */       case 11:
/*     */         str = "CH11";
/*     */       case 10:
/*     */         str = "CH10";
/*     */       case 9:
/*     */         str = "CH9";
/*     */       case 8:
/*     */         str = "CH8";
/*     */       case 7:
/*     */         str = "CH7";
/*     */       case 6:
/*     */         str = "CH6";
/*     */       case 5:
/*     */         str = "CH5";
/*     */       case 4:
/*     */         str = "CH4";
/*     */       case 3:
/*     */         str = "CH3";
/*     */       case 2:
/*     */         str = "CH2";
/*     */       case 1:
/*     */         str = "CH1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Invalid";
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
/* 114 */     boolean bool = false;
/*     */     
/* 116 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12)
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
/* 129 */       bool = true;
/*     */     }
/*     */     
/* 132 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\Channel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */