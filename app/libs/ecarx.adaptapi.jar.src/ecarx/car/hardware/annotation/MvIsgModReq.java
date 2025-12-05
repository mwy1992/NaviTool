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
/*     */ public final class MvIsgModReq
/*     */ {
/*     */   public static final int DISCHARGE = 8;
/*     */   public static final int ESA = 7;
/*     */   public static final int GENERATORNoBATT = 10;
/*     */   public static final int Reserved1_0 = 0;
/*     */   public static final int Reserved2_5 = 5;
/*     */   public static final int Reserved3_9 = 9;
/*     */   public static final int STARTER = 3;
/*     */   public static final int SpdCtrl = 6;
/*     */   public static final int Stb = 1;
/*     */   public static final int TqCtrl = 2;
/*     */   public static final int UDcCtrl = 4;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  29 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  30 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  65 */         return str;
/*     */       case 10:
/*     */         str = "GENERATORNoBATT";
/*     */       case 9:
/*     */         str = "Reserved3_9";
/*     */       case 8:
/*     */         str = "DISCHARGE";
/*     */       case 7:
/*     */         str = "ESA";
/*     */       case 6:
/*     */         str = "SpdCtrl";
/*     */       case 5:
/*     */         str = "Reserved2_5";
/*     */       case 4:
/*     */         str = "UDcCtrl";
/*     */       case 3:
/*     */         str = "STARTER";
/*     */       case 2:
/*     */         str = "TqCtrl";
/*     */       case 1:
/*     */         str = "Stb";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Reserved1_0";
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
/* 102 */     boolean bool = false;
/*     */     
/* 104 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 10 || paramInt == 9)
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
/* 115 */       bool = true;
/*     */     }
/*     */     
/* 118 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MvIsgModReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */