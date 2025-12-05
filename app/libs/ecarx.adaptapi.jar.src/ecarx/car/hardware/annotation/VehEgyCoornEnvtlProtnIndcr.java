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
/*     */ public final class VehEgyCoornEnvtlProtnIndcr
/*     */ {
/*     */   public static final int EnvtlProtnIndcrLvl1 = 1;
/*     */   public static final int EnvtlProtnIndcrLvl2 = 2;
/*     */   public static final int EnvtlProtnIndcrLvl3 = 3;
/*     */   public static final int EnvtlProtnIndcrLvl4 = 4;
/*     */   public static final int EnvtlProtnIndcrLvl5 = 5;
/*     */   public static final int EnvtlProtnIndcrLvl6 = 6;
/*     */   public static final int EnvtlProtnIndcrLvl7 = 7;
/*     */   public static final int EnvtlProtnIndcrLvl8 = 8;
/*     */   public static final int EnvtlProtnIndcrLvl9 = 9;
/*     */   public static final int NoResponse = 0;
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
/*     */         str = "EnvtlProtnIndcrLvl9";
/*     */       case 8:
/*     */         str = "EnvtlProtnIndcrLvl8";
/*     */       case 7:
/*     */         str = "EnvtlProtnIndcrLvl7";
/*     */       case 6:
/*     */         str = "EnvtlProtnIndcrLvl6";
/*     */       case 5:
/*     */         str = "EnvtlProtnIndcrLvl5";
/*     */       case 4:
/*     */         str = "EnvtlProtnIndcrLvl4";
/*     */       case 3:
/*     */         str = "EnvtlProtnIndcrLvl3";
/*     */       case 2:
/*     */         str = "EnvtlProtnIndcrLvl2";
/*     */       case 1:
/*     */         str = "EnvtlProtnIndcrLvl1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoResponse";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VehEgyCoornEnvtlProtnIndcr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */