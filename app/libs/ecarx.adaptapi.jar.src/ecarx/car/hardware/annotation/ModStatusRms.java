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
/*     */ public final class ModStatusRms
/*     */ {
/*     */   public static final int Abnormal = 5;
/*     */   public static final int Invalid = 0;
/*     */   public static final int Invalid1 = 6;
/*     */   public static final int Invalid10 = 15;
/*     */   public static final int Invalid2 = 7;
/*     */   public static final int Invalid3 = 8;
/*     */   public static final int Invalid4 = 9;
/*     */   public static final int Invalid5 = 10;
/*     */   public static final int Invalid6 = 11;
/*     */   public static final int Invalid7 = 12;
/*     */   public static final int Invalid8 = 13;
/*     */   public static final int Invalid9 = 14;
/*     */   public static final int OffSts = 3;
/*     */   public static final int PwrCns = 1;
/*     */   public static final int PwrGen = 2;
/*     */   public static final int RdySts = 4;
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
/*     */         str = "Invalid10";
/*     */       case 14:
/*     */         str = "Invalid9";
/*     */       case 13:
/*     */         str = "Invalid8";
/*     */       case 12:
/*     */         str = "Invalid7";
/*     */       case 11:
/*     */         str = "Invalid6";
/*     */       case 10:
/*     */         str = "Invalid5";
/*     */       case 9:
/*     */         str = "Invalid4";
/*     */       case 8:
/*     */         str = "Invalid3";
/*     */       case 7:
/*     */         str = "Invalid2";
/*     */       case 6:
/*     */         str = "Invalid1";
/*     */       case 5:
/*     */         str = "Abnormal";
/*     */       case 4:
/*     */         str = "RdySts";
/*     */       case 3:
/*     */         str = "OffSts";
/*     */       case 2:
/*     */         str = "PwrGen";
/*     */       case 1:
/*     */         str = "PwrCns";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Invalid";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ModStatusRms.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */