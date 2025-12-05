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
/*     */ public final class SelectM
/*     */ {
/*     */   public static final int MapA = 1;
/*     */   public static final int MapB = 2;
/*     */   public static final int MapC = 3;
/*     */   public static final int MapD = 4;
/*     */   public static final int MapE = 5;
/*     */   public static final int MapF = 6;
/*     */   public static final int MapG = 7;
/*     */   public static final int MapH = 8;
/*     */   public static final int MapI = 9;
/*     */   public static final int MapJ = 10;
/*     */   public static final int NoReq = 0;
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
/*     */         str = "MapJ";
/*     */       case 9:
/*     */         str = "MapI";
/*     */       case 8:
/*     */         str = "MapH";
/*     */       case 7:
/*     */         str = "MapG";
/*     */       case 6:
/*     */         str = "MapF";
/*     */       case 5:
/*     */         str = "MapE";
/*     */       case 4:
/*     */         str = "MapD";
/*     */       case 3:
/*     */         str = "MapC";
/*     */       case 2:
/*     */         str = "MapB";
/*     */       case 1:
/*     */         str = "MapA";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoReq";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SelectM.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */