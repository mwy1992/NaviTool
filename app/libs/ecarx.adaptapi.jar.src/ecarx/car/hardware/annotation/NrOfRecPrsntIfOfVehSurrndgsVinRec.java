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
/*     */ public final class NrOfRecPrsntIfOfVehSurrndgsVinRec
/*     */ {
/*     */   public static final int Initial = 0;
/*     */   public static final int Reserved_10 = 10;
/*     */   public static final int _1 = 1;
/*     */   public static final int _2 = 2;
/*     */   public static final int _3 = 3;
/*     */   public static final int _4 = 4;
/*     */   public static final int _5 = 5;
/*     */   public static final int _6 = 6;
/*     */   public static final int _7 = 7;
/*     */   public static final int _8 = 8;
/*     */   public static final int _9 = 9;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  29 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  30 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  65 */         return str;
/*     */       case 10:
/*     */         str = "Reserved_10";
/*     */       case 9:
/*     */         str = "_9";
/*     */       case 8:
/*     */         str = "_8";
/*     */       case 7:
/*     */         str = "_7";
/*     */       case 6:
/*     */         str = "_6";
/*     */       case 5:
/*     */         str = "_5";
/*     */       case 4:
/*     */         str = "_4";
/*     */       case 3:
/*     */         str = "_3";
/*     */       case 2:
/*     */         str = "_2";
/*     */       case 1:
/*     */         str = "_1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Initial";
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
/* 102 */     boolean bool = false;
/*     */     
/* 104 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10)
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
/* 115 */       bool = true;
/*     */     }
/*     */     
/* 118 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\NrOfRecPrsntIfOfVehSurrndgsVinRec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */