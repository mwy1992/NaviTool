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
/*     */ public final class DispOfPrpsnMod4
/*     */ {
/*     */   public static final int Abnormal = 13;
/*     */   public static final int BrkgRgnAndEngOff = 10;
/*     */   public static final int BrkgRgnAndEngOnAndChrgn = 12;
/*     */   public static final int BrkgRgnAndOnEng = 11;
/*     */   public static final int ChrgnWithOnBdChrgr = 1;
/*     */   public static final int NoPrpsnMotElecAndEngOff = 7;
/*     */   public static final int NoPrpsnMotElecAndOnEng = 8;
/*     */   public static final int NoPrpsnMotElecAndOnEngAndChrgn = 9;
/*     */   public static final int NotRdy = 0;
/*     */   public static final int OnlyEngPrpsn = 4;
/*     */   public static final int OnlyEngPrpsnAndChrgn = 5;
/*     */   public static final int OnlyPrpsnMotElec = 6;
/*     */   public static final int PrpsnMotElecAndEngChrgn = 14;
/*     */   public static final int PrpsnMotElecAndEngOn = 15;
/*     */   public static final int PrpsnMotElecAndPrpsnEng = 2;
/*     */   public static final int PrpsnMotElecAndPrpsnEngAndChrgn = 3;
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
/*     */         str = "PrpsnMotElecAndEngOn";
/*     */       case 14:
/*     */         str = "PrpsnMotElecAndEngChrgn";
/*     */       case 13:
/*     */         str = "Abnormal";
/*     */       case 12:
/*     */         str = "BrkgRgnAndEngOnAndChrgn";
/*     */       case 11:
/*     */         str = "BrkgRgnAndOnEng";
/*     */       case 10:
/*     */         str = "BrkgRgnAndEngOff";
/*     */       case 9:
/*     */         str = "NoPrpsnMotElecAndOnEngAndChrgn";
/*     */       case 8:
/*     */         str = "NoPrpsnMotElecAndOnEng";
/*     */       case 7:
/*     */         str = "NoPrpsnMotElecAndEngOff";
/*     */       case 6:
/*     */         str = "OnlyPrpsnMotElec";
/*     */       case 5:
/*     */         str = "OnlyEngPrpsnAndChrgn";
/*     */       case 4:
/*     */         str = "OnlyEngPrpsn";
/*     */       case 3:
/*     */         str = "PrpsnMotElecAndPrpsnEngAndChrgn";
/*     */       case 2:
/*     */         str = "PrpsnMotElecAndPrpsnEng";
/*     */       case 1:
/*     */         str = "ChrgnWithOnBdChrgr";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NotRdy";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DispOfPrpsnMod4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */