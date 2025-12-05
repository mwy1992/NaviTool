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
/*     */ public final class BuzzerReq
/*     */ {
/*     */   public static final int BuzzerOFF = 0;
/*     */   public static final int BuzzerON = 1;
/*     */   public static final int BuzzerONat2Hz = 3;
/*     */   public static final int BuzzerONat4Hz = 2;
/*     */   public static final int LeftON = 4;
/*     */   public static final int LeftONat2Hz = 6;
/*     */   public static final int LeftONat4Hz = 5;
/*     */   public static final int RightON = 7;
/*     */   public static final int RightONat2Hz = 9;
/*     */   public static final int RightONat4Hz = 8;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  28 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  29 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  61 */         return str;
/*     */       case 9:
/*     */         str = "RightONat2Hz";
/*     */       case 8:
/*     */         str = "RightONat4Hz";
/*     */       case 7:
/*     */         str = "RightON";
/*     */       case 6:
/*     */         str = "LeftONat2Hz";
/*     */       case 5:
/*     */         str = "LeftONat4Hz";
/*     */       case 4:
/*     */         str = "LeftON";
/*     */       case 3:
/*     */         str = "BuzzerONat2Hz";
/*     */       case 2:
/*     */         str = "BuzzerONat4Hz";
/*     */       case 1:
/*     */         str = "BuzzerON";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "BuzzerOFF";
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
/*  96 */     boolean bool = false;
/*     */     
/*  98 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       bool = true;
/*     */     }
/*     */     
/* 111 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\BuzzerReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */