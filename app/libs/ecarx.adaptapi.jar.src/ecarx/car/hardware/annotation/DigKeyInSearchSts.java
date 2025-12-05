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
/*     */ public final class DigKeyInSearchSts
/*     */ {
/*     */   public static final int DigKeySearchInCntrCnslFnd = 4;
/*     */   public static final int DigKeySearchInDrvrFrntFnd = 3;
/*     */   public static final int DigKeySearchInIdle = 0;
/*     */   public static final int DigKeySearchInInProgs = 1;
/*     */   public static final int DigKeySearchInNoPrsnt = 2;
/*     */   public static final int DigKeySearchInPassFrntFnd = 5;
/*     */   public static final int DigKeySearchInPassRearFnd = 6;
/*     */   public static final int DigKeySearchInTrFnd = 7;
/*     */   public static final int Resd = 8;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  27 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  28 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  57 */         return str;
/*     */       case 8:
/*     */         str = "Resd";
/*     */       case 7:
/*     */         str = "DigKeySearchInTrFnd";
/*     */       case 6:
/*     */         str = "DigKeySearchInPassRearFnd";
/*     */       case 5:
/*     */         str = "DigKeySearchInPassFrntFnd";
/*     */       case 4:
/*     */         str = "DigKeySearchInCntrCnslFnd";
/*     */       case 3:
/*     */         str = "DigKeySearchInDrvrFrntFnd";
/*     */       case 2:
/*     */         str = "DigKeySearchInNoPrsnt";
/*     */       case 1:
/*     */         str = "DigKeySearchInInProgs";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "DigKeySearchInIdle";
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
/*  90 */     boolean bool = false;
/*     */     
/*  92 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       bool = true;
/*     */     }
/*     */     
/* 104 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DigKeyInSearchSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */