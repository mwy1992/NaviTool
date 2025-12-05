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
/*     */ public final class SpdCutOff
/*     */ {
/*     */   public static final int Always = 15;
/*     */   public static final int Val2400 = 0;
/*     */   public static final int Val2530 = 1;
/*     */   public static final int Val2670 = 2;
/*     */   public static final int Val2820 = 3;
/*     */   public static final int Val3000 = 4;
/*     */   public static final int Val3200 = 5;
/*     */   public static final int Val3430 = 6;
/*     */   public static final int Val3690 = 7;
/*     */   public static final int Val4000 = 8;
/*     */   public static final int Val4360 = 9;
/*     */   public static final int Val4800 = 10;
/*     */   public static final int Val5330 = 11;
/*     */   public static final int Val6000 = 12;
/*     */   public static final int Val6860 = 13;
/*     */   public static final int Val8000 = 14;
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
/*     */         str = "Always";
/*     */       case 14:
/*     */         str = "Val8000";
/*     */       case 13:
/*     */         str = "Val6860";
/*     */       case 12:
/*     */         str = "Val6000";
/*     */       case 11:
/*     */         str = "Val5330";
/*     */       case 10:
/*     */         str = "Val4800";
/*     */       case 9:
/*     */         str = "Val4360";
/*     */       case 8:
/*     */         str = "Val4000";
/*     */       case 7:
/*     */         str = "Val3690";
/*     */       case 6:
/*     */         str = "Val3430";
/*     */       case 5:
/*     */         str = "Val3200";
/*     */       case 4:
/*     */         str = "Val3000";
/*     */       case 3:
/*     */         str = "Val2820";
/*     */       case 2:
/*     */         str = "Val2670";
/*     */       case 1:
/*     */         str = "Val2530";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Val2400";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SpdCutOff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */