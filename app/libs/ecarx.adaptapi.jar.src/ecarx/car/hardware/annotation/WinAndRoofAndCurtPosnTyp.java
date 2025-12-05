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
/*     */ public final class WinAndRoofAndCurtPosnTyp
/*     */ {
/*     */   public static final int ClsFull = 1;
/*     */   public static final int Movg = 31;
/*     */   public static final int OpenFull = 26;
/*     */   public static final int PercOpen12 = 4;
/*     */   public static final int PercOpen16 = 5;
/*     */   public static final int PercOpen20 = 6;
/*     */   public static final int PercOpen24 = 7;
/*     */   public static final int PercOpen28 = 8;
/*     */   public static final int PercOpen32 = 9;
/*     */   public static final int PercOpen36 = 10;
/*     */   public static final int PercOpen4 = 2;
/*     */   public static final int PercOpen40 = 11;
/*     */   public static final int PercOpen44 = 12;
/*     */   public static final int PercOpen48 = 13;
/*     */   public static final int PercOpen52 = 14;
/*     */   public static final int PercOpen56 = 15;
/*     */   public static final int PercOpen60 = 16;
/*     */   public static final int PercOpen64 = 17;
/*     */   public static final int PercOpen68 = 18;
/*     */   public static final int PercOpen72 = 19;
/*     */   public static final int PercOpen76 = 20;
/*     */   public static final int PercOpen8 = 3;
/*     */   public static final int PercOpen80 = 21;
/*     */   public static final int PercOpen84 = 22;
/*     */   public static final int PercOpen88 = 23;
/*     */   public static final int PercOpen92 = 24;
/*     */   public static final int PercOpen96 = 25;
/*     */   public static final int PosnUkwn = 0;
/*     */   public static final int Resd1 = 27;
/*     */   public static final int Resd2 = 28;
/*     */   public static final int Resd3 = 29;
/*     */   public static final int Resd4 = 30;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  50 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  51 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 149 */         return str;
/*     */       case 31:
/*     */         str = "Movg";
/*     */       case 30:
/*     */         str = "Resd4";
/*     */       case 29:
/*     */         str = "Resd3";
/*     */       case 28:
/*     */         str = "Resd2";
/*     */       case 27:
/*     */         str = "Resd1";
/*     */       case 26:
/*     */         str = "OpenFull";
/*     */       case 25:
/*     */         str = "PercOpen96";
/*     */       case 24:
/*     */         str = "PercOpen92";
/*     */       case 23:
/*     */         str = "PercOpen88";
/*     */       case 22:
/*     */         str = "PercOpen84";
/*     */       case 21:
/*     */         str = "PercOpen80";
/*     */       case 20:
/*     */         str = "PercOpen76";
/*     */       case 19:
/*     */         str = "PercOpen72";
/*     */       case 18:
/*     */         str = "PercOpen68";
/*     */       case 17:
/*     */         str = "PercOpen64";
/*     */       case 16:
/*     */         str = "PercOpen60";
/*     */       case 15:
/*     */         str = "PercOpen56";
/*     */       case 14:
/*     */         str = "PercOpen52";
/*     */       case 13:
/*     */         str = "PercOpen48";
/*     */       case 12:
/*     */         str = "PercOpen44";
/*     */       case 11:
/*     */         str = "PercOpen40";
/*     */       case 10:
/*     */         str = "PercOpen36";
/*     */       case 9:
/*     */         str = "PercOpen32";
/*     */       case 8:
/*     */         str = "PercOpen28";
/*     */       case 7:
/*     */         str = "PercOpen24";
/*     */       case 6:
/*     */         str = "PercOpen20";
/*     */       case 5:
/*     */         str = "PercOpen16";
/*     */       case 4:
/*     */         str = "PercOpen12";
/*     */       case 3:
/*     */         str = "PercOpen8";
/*     */       case 2:
/*     */         str = "PercOpen4";
/*     */       case 1:
/*     */         str = "ClsFull";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "PosnUkwn";
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
/* 228 */     boolean bool = false;
/*     */     
/* 230 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 262 */       bool = true;
/*     */     }
/*     */     
/* 265 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WinAndRoofAndCurtPosnTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */