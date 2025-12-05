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
/*     */ public final class PrkgClimaWarn
/*     */ {
/*     */   public static final int ActvnLimd = 8;
/*     */   public static final int BattLo = 2;
/*     */   public static final int Error = 6;
/*     */   public static final int FuAndBattLo = 3;
/*     */   public static final int FuLo = 1;
/*     */   public static final int HVError = 7;
/*     */   public static final int NoWarn = 0;
/*     */   public static final int Thi = 5;
/*     */   public static final int Tlo = 4;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  26 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  55 */         return str;
/*     */       case 8:
/*     */         str = "ActvnLimd";
/*     */       case 7:
/*     */         str = "HVError";
/*     */       case 6:
/*     */         str = "Error";
/*     */       case 5:
/*     */         str = "Thi";
/*     */       case 4:
/*     */         str = "Tlo";
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
/*  88 */     boolean bool = false;
/*     */     
/*  90 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       bool = true;
/*     */     }
/*     */     
/* 102 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgClimaWarn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */