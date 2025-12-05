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
/*     */ public final class ClimaWarn
/*     */ {
/*     */   public static final int ActvnLimd = 8;
/*     */   public static final int BattLo = 2;
/*     */   public static final int Error = 6;
/*     */   public static final int FuAndBattLo = 3;
/*     */   public static final int FuLo = 1;
/*     */   public static final int HVError = 7;
/*     */   public static final int NoWarn = 0;
/*     */   public static final int THi = 5;
/*     */   public static final int TLo = 4;
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
/*     */         str = "ActvnLimd";
/*     */       case 7:
/*     */         str = "HVError";
/*     */       case 6:
/*     */         str = "Error";
/*     */       case 5:
/*     */         str = "THi";
/*     */       case 4:
/*     */         str = "TLo";
/*     */       case 3:
/*     */         str = "FuAndBattLo";
/*     */       case 2:
/*     */         str = "BattLo";
/*     */       case 1:
/*     */         str = "FuLo";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoWarn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ClimaWarn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */