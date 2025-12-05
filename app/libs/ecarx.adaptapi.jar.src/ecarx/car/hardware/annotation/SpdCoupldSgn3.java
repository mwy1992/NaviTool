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
/*     */ public final class SpdCoupldSgn3
/*     */ {
/*     */   public static final int EndOfAllLiml = 1;
/*     */   public static final int EndOfCty = 11;
/*     */   public static final int EndOfFreeWaySgn1 = 8;
/*     */   public static final int EndOfFreeWaySgn2 = 9;
/*     */   public static final int EndOfHiWaySgn1 = 4;
/*     */   public static final int EndOfHiWaySgn2 = 5;
/*     */   public static final int EndOfSpdArLo = 15;
/*     */   public static final int EndOfSpdLim = 16;
/*     */   public static final int EndOfTown = 13;
/*     */   public static final int EndOfTownSec = 18;
/*     */   public static final int FreeWaySgn1 = 6;
/*     */   public static final int FreeWaySgn2 = 7;
/*     */   public static final int HiWaySgn1 = 2;
/*     */   public static final int HiWaySgn2 = 3;
/*     */   public static final int NoSpdInfo = 0;
/*     */   public static final int StrtOfCty = 10;
/*     */   public static final int StrtOfSpdArLo = 14;
/*     */   public static final int StrtOfTown = 12;
/*     */   public static final int StrtOfTownSec = 17;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  37 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  38 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  97 */         return str;
/*     */       case 18:
/*     */         str = "EndOfTownSec";
/*     */       case 17:
/*     */         str = "StrtOfTownSec";
/*     */       case 16:
/*     */         str = "EndOfSpdLim";
/*     */       case 15:
/*     */         str = "EndOfSpdArLo";
/*     */       case 14:
/*     */         str = "StrtOfSpdArLo";
/*     */       case 13:
/*     */         str = "EndOfTown";
/*     */       case 12:
/*     */         str = "StrtOfTown";
/*     */       case 11:
/*     */         str = "EndOfCty";
/*     */       case 10:
/*     */         str = "StrtOfCty";
/*     */       case 9:
/*     */         str = "EndOfFreeWaySgn2";
/*     */       case 8:
/*     */         str = "EndOfFreeWaySgn1";
/*     */       case 7:
/*     */         str = "FreeWaySgn2";
/*     */       case 6:
/*     */         str = "FreeWaySgn1";
/*     */       case 5:
/*     */         str = "EndOfHiWaySgn2";
/*     */       case 4:
/*     */         str = "EndOfHiWaySgn1";
/*     */       case 3:
/*     */         str = "HiWaySgn2";
/*     */       case 2:
/*     */         str = "HiWaySgn1";
/*     */       case 1:
/*     */         str = "EndOfAllLiml";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoSpdInfo";
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
/* 150 */     boolean bool = false;
/*     */     
/* 152 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18)
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
/* 171 */       bool = true;
/*     */     }
/*     */     
/* 174 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SpdCoupldSgn3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */