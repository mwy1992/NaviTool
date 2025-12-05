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
/*     */ public final class ChrgrSts1
/*     */ {
/*     */   public static final int Alrm = 3;
/*     */   public static final int BookChrgn = 9;
/*     */   public static final int Boot = 6;
/*     */   public static final int Chrgn = 2;
/*     */   public static final int Cooling = 12;
/*     */   public static final int Diagc = 5;
/*     */   public static final int DisChrgn = 8;
/*     */   public static final int Heating = 11;
/*     */   public static final int Idle = 0;
/*     */   public static final int PreStrt = 1;
/*     */   public static final int Rstrt = 7;
/*     */   public static final int Shutdown = 10;
/*     */   public static final int Srv = 4;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  31 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  32 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  73 */         return str;
/*     */       case 12:
/*     */         str = "Cooling";
/*     */       case 11:
/*     */         str = "Heating";
/*     */       case 10:
/*     */         str = "Shutdown";
/*     */       case 9:
/*     */         str = "BookChrgn";
/*     */       case 8:
/*     */         str = "DisChrgn";
/*     */       case 7:
/*     */         str = "Rstrt";
/*     */       case 6:
/*     */         str = "Boot";
/*     */       case 5:
/*     */         str = "Diagc";
/*     */       case 4:
/*     */         str = "Srv";
/*     */       case 3:
/*     */         str = "Alrm";
/*     */       case 2:
/*     */         str = "Chrgn";
/*     */       case 1:
/*     */         str = "PreStrt";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Idle";
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
/* 114 */     boolean bool = false;
/*     */     
/* 116 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12)
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
/* 129 */       bool = true;
/*     */     }
/*     */     
/* 132 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ChrgrSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */