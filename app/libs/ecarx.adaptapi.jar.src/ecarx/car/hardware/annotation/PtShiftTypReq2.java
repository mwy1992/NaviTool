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
/*     */ public final class PtShiftTypReq2
/*     */ {
/*     */   public static final int AShiftQly0 = 12;
/*     */   public static final int AShiftQly1 = 13;
/*     */   public static final int AShiftQly2 = 14;
/*     */   public static final int AShiftQly3 = 15;
/*     */   public static final int ShiftQly0 = 0;
/*     */   public static final int ShiftQly1 = 1;
/*     */   public static final int ShiftQly10 = 10;
/*     */   public static final int ShiftQly11 = 11;
/*     */   public static final int ShiftQly2 = 2;
/*     */   public static final int ShiftQly3 = 3;
/*     */   public static final int ShiftQly4 = 4;
/*     */   public static final int ShiftQly5 = 5;
/*     */   public static final int ShiftQly6 = 6;
/*     */   public static final int ShiftQly7 = 7;
/*     */   public static final int ShiftQly8 = 8;
/*     */   public static final int ShiftQly9 = 9;
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
/*     */         str = "AShiftQly3";
/*     */       case 14:
/*     */         str = "AShiftQly2";
/*     */       case 13:
/*     */         str = "AShiftQly1";
/*     */       case 12:
/*     */         str = "AShiftQly0";
/*     */       case 11:
/*     */         str = "ShiftQly11";
/*     */       case 10:
/*     */         str = "ShiftQly10";
/*     */       case 9:
/*     */         str = "ShiftQly9";
/*     */       case 8:
/*     */         str = "ShiftQly8";
/*     */       case 7:
/*     */         str = "ShiftQly7";
/*     */       case 6:
/*     */         str = "ShiftQly6";
/*     */       case 5:
/*     */         str = "ShiftQly5";
/*     */       case 4:
/*     */         str = "ShiftQly4";
/*     */       case 3:
/*     */         str = "ShiftQly3";
/*     */       case 2:
/*     */         str = "ShiftQly2";
/*     */       case 1:
/*     */         str = "ShiftQly1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "ShiftQly0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PtShiftTypReq2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */