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
/*     */ public final class PtAllwdToTrsmActr1
/*     */ {
/*     */   public static final int NotAllwd1 = 0;
/*     */   public static final int NotAllwd2 = 3;
/*     */   public static final int NotAllwd3 = 7;
/*     */   public static final int NotAllwd4 = 11;
/*     */   public static final int NotAllwd5 = 12;
/*     */   public static final int NotAllwd6 = 13;
/*     */   public static final int NotAllwd7 = 14;
/*     */   public static final int NotAllwd8 = 15;
/*     */   public static final int ParkRelsAllwd = 4;
/*     */   public static final int ParkRelsNotAllwd = 8;
/*     */   public static final int RvsAllwd = 1;
/*     */   public static final int RvsAllwdAndParkRelsAllwd = 5;
/*     */   public static final int RvsAllwdAndParkRelsNotAllwd = 9;
/*     */   public static final int RvsNotAllwd = 2;
/*     */   public static final int RvsNotAllwdAndParkRelsAllwd = 6;
/*     */   public static final int RvsNotAllwdAndParkRelsNotAllwd = 10;
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
/*     */         str = "NotAllwd8";
/*     */       case 14:
/*     */         str = "NotAllwd7";
/*     */       case 13:
/*     */         str = "NotAllwd6";
/*     */       case 12:
/*     */         str = "NotAllwd5";
/*     */       case 11:
/*     */         str = "NotAllwd4";
/*     */       case 10:
/*     */         str = "RvsNotAllwdAndParkRelsNotAllwd";
/*     */       case 9:
/*     */         str = "RvsAllwdAndParkRelsNotAllwd";
/*     */       case 8:
/*     */         str = "ParkRelsNotAllwd";
/*     */       case 7:
/*     */         str = "NotAllwd3";
/*     */       case 6:
/*     */         str = "RvsNotAllwdAndParkRelsAllwd";
/*     */       case 5:
/*     */         str = "RvsAllwdAndParkRelsAllwd";
/*     */       case 4:
/*     */         str = "ParkRelsAllwd";
/*     */       case 3:
/*     */         str = "NotAllwd2";
/*     */       case 2:
/*     */         str = "RvsNotAllwd";
/*     */       case 1:
/*     */         str = "RvsAllwd";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NotAllwd1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PtAllwdToTrsmActr1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */