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
/*     */ public final class IsgModTyp1
/*     */ {
/*     */   public static final int Flt = 7;
/*     */   public static final int Inin = 0;
/*     */   public static final int PreChrg = 5;
/*     */   public static final int PwrDwn = 6;
/*     */   public static final int Reserved1_9 = 9;
/*     */   public static final int Reserved2_10 = 10;
/*     */   public static final int Reserved3_11 = 11;
/*     */   public static final int Reserved4_12 = 12;
/*     */   public static final int Reserved5_13 = 13;
/*     */   public static final int Reserved6_14 = 14;
/*     */   public static final int Reserved7_15 = 15;
/*     */   public static final int SpdCtrl = 3;
/*     */   public static final int Stb = 1;
/*     */   public static final int TcsCtrl = 8;
/*     */   public static final int TqCtrl = 2;
/*     */   public static final int UDcCtrl = 4;
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
/*     */         str = "Reserved7_15";
/*     */       case 14:
/*     */         str = "Reserved6_14";
/*     */       case 13:
/*     */         str = "Reserved5_13";
/*     */       case 12:
/*     */         str = "Reserved4_12";
/*     */       case 11:
/*     */         str = "Reserved3_11";
/*     */       case 10:
/*     */         str = "Reserved2_10";
/*     */       case 9:
/*     */         str = "Reserved1_9";
/*     */       case 8:
/*     */         str = "TcsCtrl";
/*     */       case 7:
/*     */         str = "Flt";
/*     */       case 6:
/*     */         str = "PwrDwn";
/*     */       case 5:
/*     */         str = "PreChrg";
/*     */       case 4:
/*     */         str = "UDcCtrl";
/*     */       case 3:
/*     */         str = "SpdCtrl";
/*     */       case 2:
/*     */         str = "TqCtrl";
/*     */       case 1:
/*     */         str = "Stb";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Inin";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\IsgModTyp1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */