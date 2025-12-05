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
/*     */ public final class DrvPfmncRedn
/*     */ {
/*     */   public static final int FltIndcn1 = 1;
/*     */   public static final int FltIndcn10 = 10;
/*     */   public static final int FltIndcn11 = 11;
/*     */   public static final int FltIndcn12 = 12;
/*     */   public static final int FltIndcn13 = 13;
/*     */   public static final int FltIndcn14 = 14;
/*     */   public static final int FltIndcn15 = 15;
/*     */   public static final int FltIndcn2 = 2;
/*     */   public static final int FltIndcn3 = 3;
/*     */   public static final int FltIndcn4 = 4;
/*     */   public static final int FltIndcn5 = 5;
/*     */   public static final int FltIndcn6 = 6;
/*     */   public static final int FltIndcn7 = 7;
/*     */   public static final int FltIndcn8 = 8;
/*     */   public static final int FltIndcn9 = 9;
/*     */   public static final int NoIndcn = 0;
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
/*     */         str = "FltIndcn15";
/*     */       case 14:
/*     */         str = "FltIndcn14";
/*     */       case 13:
/*     */         str = "FltIndcn13";
/*     */       case 12:
/*     */         str = "FltIndcn12";
/*     */       case 11:
/*     */         str = "FltIndcn11";
/*     */       case 10:
/*     */         str = "FltIndcn10";
/*     */       case 9:
/*     */         str = "FltIndcn9";
/*     */       case 8:
/*     */         str = "FltIndcn8";
/*     */       case 7:
/*     */         str = "FltIndcn7";
/*     */       case 6:
/*     */         str = "FltIndcn6";
/*     */       case 5:
/*     */         str = "FltIndcn5";
/*     */       case 4:
/*     */         str = "FltIndcn4";
/*     */       case 3:
/*     */         str = "FltIndcn3";
/*     */       case 2:
/*     */         str = "FltIndcn2";
/*     */       case 1:
/*     */         str = "FltIndcn1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoIndcn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvPfmncRedn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */