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
/*     */ public final class DrvrHmiUsrIfSetg
/*     */ {
/*     */   public static final int UsrIfDft = 0;
/*     */   public static final int UsrIfVrnt1 = 1;
/*     */   public static final int UsrIfVrnt2 = 2;
/*     */   public static final int UsrIfVrnt3 = 3;
/*     */   public static final int UsrIfVrnt4 = 4;
/*     */   public static final int UsrIfVrnt5 = 5;
/*     */   public static final int UsrIfVrnt6 = 6;
/*     */   public static final int UsrIfVrnt7 = 7;
/*     */   public static final int UsrIfVrnt8 = 8;
/*     */   public static final int UsrIfVrnt9 = 9;
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
/*     */         str = "UsrIfVrnt9";
/*     */       case 8:
/*     */         str = "UsrIfVrnt8";
/*     */       case 7:
/*     */         str = "UsrIfVrnt7";
/*     */       case 6:
/*     */         str = "UsrIfVrnt6";
/*     */       case 5:
/*     */         str = "UsrIfVrnt5";
/*     */       case 4:
/*     */         str = "UsrIfVrnt4";
/*     */       case 3:
/*     */         str = "UsrIfVrnt3";
/*     */       case 2:
/*     */         str = "UsrIfVrnt2";
/*     */       case 1:
/*     */         str = "UsrIfVrnt1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "UsrIfDft";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvrHmiUsrIfSetg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */