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
/*     */ public final class PtGearReq1
/*     */ {
/*     */   public static final int Gear1 = 0;
/*     */   public static final int Gear2 = 1;
/*     */   public static final int Gear3 = 2;
/*     */   public static final int Gear4 = 3;
/*     */   public static final int Gear5 = 4;
/*     */   public static final int Gear6 = 5;
/*     */   public static final int Gear7 = 6;
/*     */   public static final int Gear8 = 7;
/*     */   public static final int Spare = 8;
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
/*     */         str = "Spare";
/*     */       case 7:
/*     */         str = "Gear8";
/*     */       case 6:
/*     */         str = "Gear7";
/*     */       case 5:
/*     */         str = "Gear6";
/*     */       case 4:
/*     */         str = "Gear5";
/*     */       case 3:
/*     */         str = "Gear4";
/*     */       case 2:
/*     */         str = "Gear3";
/*     */       case 1:
/*     */         str = "Gear2";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Gear1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PtGearReq1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */