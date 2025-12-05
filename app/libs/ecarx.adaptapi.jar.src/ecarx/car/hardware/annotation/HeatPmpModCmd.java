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
/*     */ public final class HeatPmpModCmd
/*     */ {
/*     */   public static final int Initialization = 0;
/*     */   public static final int Mode1 = 1;
/*     */   public static final int Mode10 = 10;
/*     */   public static final int Mode11 = 11;
/*     */   public static final int Mode12 = 12;
/*     */   public static final int Mode13 = 13;
/*     */   public static final int Mode14 = 14;
/*     */   public static final int Mode15 = 15;
/*     */   public static final int Mode16 = 16;
/*     */   public static final int Mode17 = 17;
/*     */   public static final int Mode18 = 18;
/*     */   public static final int Mode19 = 19;
/*     */   public static final int Mode2 = 2;
/*     */   public static final int Mode20 = 20;
/*     */   public static final int Mode3 = 3;
/*     */   public static final int Mode4 = 4;
/*     */   public static final int Mode5 = 5;
/*     */   public static final int Mode6 = 6;
/*     */   public static final int Mode7 = 7;
/*     */   public static final int Mode8 = 8;
/*     */   public static final int Mode9 = 9;
/*     */   public static final int Reserved_21 = 21;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  40 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  41 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 109 */         return str;
/*     */       case 21:
/*     */         str = "Reserved_21";
/*     */       case 20:
/*     */         str = "Mode20";
/*     */       case 19:
/*     */         str = "Mode19";
/*     */       case 18:
/*     */         str = "Mode18";
/*     */       case 17:
/*     */         str = "Mode17";
/*     */       case 16:
/*     */         str = "Mode16";
/*     */       case 15:
/*     */         str = "Mode15";
/*     */       case 14:
/*     */         str = "Mode14";
/*     */       case 13:
/*     */         str = "Mode13";
/*     */       case 12:
/*     */         str = "Mode12";
/*     */       case 11:
/*     */         str = "Mode11";
/*     */       case 10:
/*     */         str = "Mode10";
/*     */       case 9:
/*     */         str = "Mode9";
/*     */       case 8:
/*     */         str = "Mode8";
/*     */       case 7:
/*     */         str = "Mode7";
/*     */       case 6:
/*     */         str = "Mode6";
/*     */       case 5:
/*     */         str = "Mode5";
/*     */       case 4:
/*     */         str = "Mode4";
/*     */       case 3:
/*     */         str = "Mode3";
/*     */       case 2:
/*     */         str = "Mode2";
/*     */       case 1:
/*     */         str = "Mode1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Initialization";
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
/* 168 */     boolean bool = false;
/*     */     
/* 170 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21)
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
/*     */       
/* 192 */       bool = true;
/*     */     }
/*     */     
/* 195 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HeatPmpModCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */