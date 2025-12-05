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
/*     */ public final class CarModDynoCnfrm
/*     */ {
/*     */   public static final int Cfmd1 = 0;
/*     */   public static final int Cfmd2 = 2;
/*     */   public static final int ExitDyno = 6;
/*     */   public static final int NotCfmd1 = 1;
/*     */   public static final int NotCfmd2 = 3;
/*     */   public static final int Resd1 = 8;
/*     */   public static final int Resd2 = 9;
/*     */   public static final int Resd3 = 10;
/*     */   public static final int Resd4 = 11;
/*     */   public static final int Resd5 = 12;
/*     */   public static final int Resd6 = 13;
/*     */   public static final int Resd7 = 14;
/*     */   public static final int Resd8 = 15;
/*     */   public static final int StayInDyno = 7;
/*     */   public static final int WhlDrv2 = 4;
/*     */   public static final int WhlDrv4 = 5;
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
/*     */         str = "Resd8";
/*     */       case 14:
/*     */         str = "Resd7";
/*     */       case 13:
/*     */         str = "Resd6";
/*     */       case 12:
/*     */         str = "Resd5";
/*     */       case 11:
/*     */         str = "Resd4";
/*     */       case 10:
/*     */         str = "Resd3";
/*     */       case 9:
/*     */         str = "Resd2";
/*     */       case 8:
/*     */         str = "Resd1";
/*     */       case 7:
/*     */         str = "StayInDyno";
/*     */       case 6:
/*     */         str = "ExitDyno";
/*     */       case 5:
/*     */         str = "WhlDrv4";
/*     */       case 4:
/*     */         str = "WhlDrv2";
/*     */       case 3:
/*     */         str = "NotCfmd2";
/*     */       case 2:
/*     */         str = "Cfmd2";
/*     */       case 1:
/*     */         str = "NotCfmd1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Cfmd1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CarModDynoCnfrm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */