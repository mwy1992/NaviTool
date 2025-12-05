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
/*     */ public final class TrsmOilFlow
/*     */ {
/*     */   public static final int Lvl0 = 0;
/*     */   public static final int Lvl1 = 1;
/*     */   public static final int Lvl10 = 10;
/*     */   public static final int Lvl11 = 11;
/*     */   public static final int Lvl12 = 12;
/*     */   public static final int Lvl13 = 13;
/*     */   public static final int Lvl14 = 14;
/*     */   public static final int Lvl15 = 15;
/*     */   public static final int Lvl16 = 16;
/*     */   public static final int Lvl17 = 17;
/*     */   public static final int Lvl18 = 18;
/*     */   public static final int Lvl19 = 19;
/*     */   public static final int Lvl2 = 2;
/*     */   public static final int Lvl20 = 20;
/*     */   public static final int Lvl3 = 3;
/*     */   public static final int Lvl4 = 4;
/*     */   public static final int Lvl5 = 5;
/*     */   public static final int Lvl6 = 6;
/*     */   public static final int Lvl7 = 7;
/*     */   public static final int Lvl8 = 8;
/*     */   public static final int Lvl9 = 9;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  39 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  40 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 105 */         return str;
/*     */       case 20:
/*     */         str = "Lvl20";
/*     */       case 19:
/*     */         str = "Lvl19";
/*     */       case 18:
/*     */         str = "Lvl18";
/*     */       case 17:
/*     */         str = "Lvl17";
/*     */       case 16:
/*     */         str = "Lvl16";
/*     */       case 15:
/*     */         str = "Lvl15";
/*     */       case 14:
/*     */         str = "Lvl14";
/*     */       case 13:
/*     */         str = "Lvl13";
/*     */       case 12:
/*     */         str = "Lvl12";
/*     */       case 11:
/*     */         str = "Lvl11";
/*     */       case 10:
/*     */         str = "Lvl10";
/*     */       case 9:
/*     */         str = "Lvl9";
/*     */       case 8:
/*     */         str = "Lvl8";
/*     */       case 7:
/*     */         str = "Lvl7";
/*     */       case 6:
/*     */         str = "Lvl6";
/*     */       case 5:
/*     */         str = "Lvl5";
/*     */       case 4:
/*     */         str = "Lvl4";
/*     */       case 3:
/*     */         str = "Lvl3";
/*     */       case 2:
/*     */         str = "Lvl2";
/*     */       case 1:
/*     */         str = "Lvl1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Lvl0";
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
/* 162 */     boolean bool = false;
/*     */     
/* 164 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       bool = true;
/*     */     }
/*     */     
/* 188 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TrsmOilFlow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */