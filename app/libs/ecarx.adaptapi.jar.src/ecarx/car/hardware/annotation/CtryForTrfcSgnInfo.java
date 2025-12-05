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
/*     */ public final class CtryForTrfcSgnInfo
/*     */ {
/*     */   public static final int Argentina = 27;
/*     */   public static final int Belarus = 28;
/*     */   public static final int Belgium = 6;
/*     */   public static final int Brazil = 26;
/*     */   public static final int Canada = 15;
/*     */   public static final int Chile = 25;
/*     */   public static final int China = 17;
/*     */   public static final int Denmark = 3;
/*     */   public static final int Egypt = 24;
/*     */   public static final int Finland = 2;
/*     */   public static final int France = 7;
/*     */   public static final int Germany = 8;
/*     */   public static final int Indonesia = 20;
/*     */   public static final int Iran = 22;
/*     */   public static final int Italy = 12;
/*     */   public static final int Japan = 16;
/*     */   public static final int Kazakhstan = 29;
/*     */   public static final int Malaysia = 18;
/*     */   public static final int Netherlands = 9;
/*     */   public static final int Norway = 4;
/*     */   public static final int Russia = 11;
/*     */   public static final int SaudiArabia = 23;
/*     */   public static final int Spain = 13;
/*     */   public static final int Sweden = 1;
/*     */   public static final int Switzerland = 10;
/*     */   public static final int Thailand = 19;
/*     */   public static final int UK = 5;
/*     */   public static final int USA = 14;
/*     */   public static final int Ukwn = 0;
/*     */   public static final int Vietnam = 21;
/*     */   public static final int reserved_30 = 30;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  49 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  50 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 145 */         return str;
/*     */       case 30:
/*     */         str = "reserved_30";
/*     */       case 29:
/*     */         str = "Kazakhstan";
/*     */       case 28:
/*     */         str = "Belarus";
/*     */       case 27:
/*     */         str = "Argentina";
/*     */       case 26:
/*     */         str = "Brazil";
/*     */       case 25:
/*     */         str = "Chile";
/*     */       case 24:
/*     */         str = "Egypt";
/*     */       case 23:
/*     */         str = "SaudiArabia";
/*     */       case 22:
/*     */         str = "Iran";
/*     */       case 21:
/*     */         str = "Vietnam";
/*     */       case 20:
/*     */         str = "Indonesia";
/*     */       case 19:
/*     */         str = "Thailand";
/*     */       case 18:
/*     */         str = "Malaysia";
/*     */       case 17:
/*     */         str = "China";
/*     */       case 16:
/*     */         str = "Japan";
/*     */       case 15:
/*     */         str = "Canada";
/*     */       case 14:
/*     */         str = "USA";
/*     */       case 13:
/*     */         str = "Spain";
/*     */       case 12:
/*     */         str = "Italy";
/*     */       case 11:
/*     */         str = "Russia";
/*     */       case 10:
/*     */         str = "Switzerland";
/*     */       case 9:
/*     */         str = "Netherlands";
/*     */       case 8:
/*     */         str = "Germany";
/*     */       case 7:
/*     */         str = "France";
/*     */       case 6:
/*     */         str = "Belgium";
/*     */       case 5:
/*     */         str = "UK";
/*     */       case 4:
/*     */         str = "Norway";
/*     */       case 3:
/*     */         str = "Denmark";
/*     */       case 2:
/*     */         str = "Finland";
/*     */       case 1:
/*     */         str = "Sweden";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Ukwn";
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
/* 222 */     boolean bool = false;
/*     */     
/* 224 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 255 */       bool = true;
/*     */     }
/*     */     
/* 258 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CtryForTrfcSgnInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */