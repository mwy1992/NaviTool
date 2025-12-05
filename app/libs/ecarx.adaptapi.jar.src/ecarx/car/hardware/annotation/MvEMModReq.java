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
/*     */ public final class MvEMModReq
/*     */ {
/*     */   public static final int GenNoBatCtl = 5;
/*     */   public static final int Openbridge = 0;
/*     */   public static final int Reserved10_12 = 12;
/*     */   public static final int Reserved11_13 = 13;
/*     */   public static final int Reserved12_14 = 14;
/*     */   public static final int Reserved13_15 = 15;
/*     */   public static final int Reserved5_7 = 7;
/*     */   public static final int Reserved6_8 = 8;
/*     */   public static final int Reserved7_9 = 9;
/*     */   public static final int Reserved8_10 = 10;
/*     */   public static final int Reserved9_11 = 11;
/*     */   public static final int SpdCtl = 3;
/*     */   public static final int StdBy = 1;
/*     */   public static final int TqCtl = 2;
/*     */   public static final int UDcCtl = 4;
/*     */   public static final int ZeroTqCtrl = 6;
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
/*     */         str = "Reserved13_15";
/*     */       case 14:
/*     */         str = "Reserved12_14";
/*     */       case 13:
/*     */         str = "Reserved11_13";
/*     */       case 12:
/*     */         str = "Reserved10_12";
/*     */       case 11:
/*     */         str = "Reserved9_11";
/*     */       case 10:
/*     */         str = "Reserved8_10";
/*     */       case 9:
/*     */         str = "Reserved7_9";
/*     */       case 8:
/*     */         str = "Reserved6_8";
/*     */       case 7:
/*     */         str = "Reserved5_7";
/*     */       case 6:
/*     */         str = "ZeroTqCtrl";
/*     */       case 5:
/*     */         str = "GenNoBatCtl";
/*     */       case 4:
/*     */         str = "UDcCtl";
/*     */       case 3:
/*     */         str = "SpdCtl";
/*     */       case 2:
/*     */         str = "TqCtl";
/*     */       case 1:
/*     */         str = "StdBy";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Openbridge";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MvEMModReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */