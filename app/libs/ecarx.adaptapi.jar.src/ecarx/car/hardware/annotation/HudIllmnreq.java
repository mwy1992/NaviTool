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
/*     */ public final class HudIllmnreq
/*     */ {
/*     */   public static final int HudIllmnvalue0 = 10;
/*     */   public static final int HudIllmnvalue1 = 11;
/*     */   public static final int HudIllmnvalue10 = 20;
/*     */   public static final int HudIllmnvalue10n = 0;
/*     */   public static final int HudIllmnvalue1n = 9;
/*     */   public static final int HudIllmnvalue2 = 12;
/*     */   public static final int HudIllmnvalue2n = 8;
/*     */   public static final int HudIllmnvalue3 = 13;
/*     */   public static final int HudIllmnvalue3n = 7;
/*     */   public static final int HudIllmnvalue4 = 14;
/*     */   public static final int HudIllmnvalue4n = 6;
/*     */   public static final int HudIllmnvalue5 = 15;
/*     */   public static final int HudIllmnvalue5n = 5;
/*     */   public static final int HudIllmnvalue6 = 16;
/*     */   public static final int HudIllmnvalue6n = 4;
/*     */   public static final int HudIllmnvalue7 = 17;
/*     */   public static final int HudIllmnvalue7n = 3;
/*     */   public static final int HudIllmnvalue8 = 18;
/*     */   public static final int HudIllmnvalue8n = 2;
/*     */   public static final int HudIllmnvalue9 = 19;
/*     */   public static final int HudIllmnvalue9n = 1;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  37 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  38 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 103 */         return str;
/*     */       case 20:
/*     */         str = "HudIllmnvalue10";
/*     */       case 19:
/*     */         str = "HudIllmnvalue9";
/*     */       case 18:
/*     */         str = "HudIllmnvalue8";
/*     */       case 17:
/*     */         str = "HudIllmnvalue7";
/*     */       case 16:
/*     */         str = "HudIllmnvalue6";
/*     */       case 15:
/*     */         str = "HudIllmnvalue5";
/*     */       case 14:
/*     */         str = "HudIllmnvalue4";
/*     */       case 13:
/*     */         str = "HudIllmnvalue3";
/*     */       case 12:
/*     */         str = "HudIllmnvalue2";
/*     */       case 11:
/*     */         str = "HudIllmnvalue1";
/*     */       case 10:
/*     */         str = "HudIllmnvalue0";
/*     */       case 9:
/*     */         str = "HudIllmnvalue1n";
/*     */       case 8:
/*     */         str = "HudIllmnvalue2n";
/*     */       case 7:
/*     */         str = "HudIllmnvalue3n";
/*     */       case 6:
/*     */         str = "HudIllmnvalue4n";
/*     */       case 5:
/*     */         str = "HudIllmnvalue5n";
/*     */       case 4:
/*     */         str = "HudIllmnvalue6n";
/*     */       case 3:
/*     */         str = "HudIllmnvalue7n";
/*     */       case 2:
/*     */         str = "HudIllmnvalue8n";
/*     */       case 1:
/*     */         str = "HudIllmnvalue9n";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "HudIllmnvalue10n";
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
/* 160 */     boolean bool = false;
/*     */     
/* 162 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       bool = true;
/*     */     }
/*     */     
/* 186 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HudIllmnreq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */