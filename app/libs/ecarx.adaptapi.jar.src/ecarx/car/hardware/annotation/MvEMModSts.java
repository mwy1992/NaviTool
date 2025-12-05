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
/*     */ public final class MvEMModSts
/*     */ {
/*     */   public static final int Failure = 2;
/*     */   public static final int GenNoBatCtl = 11;
/*     */   public static final int GenNoBatCtlDer = 12;
/*     */   public static final int InitFlt = 14;
/*     */   public static final int Initial = 7;
/*     */   public static final int Openbridge = 0;
/*     */   public static final int PwrDwn = 8;
/*     */   public static final int SpdCtl = 5;
/*     */   public static final int SpdCtlDer = 6;
/*     */   public static final int Stdby = 1;
/*     */   public static final int TqCtl = 3;
/*     */   public static final int TqCtlDer = 4;
/*     */   public static final int UDcCtl = 9;
/*     */   public static final int UDcCtlDer = 10;
/*     */   public static final int ZeroTqCtrl = 13;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  33 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  34 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  81 */         return str;
/*     */       case 14:
/*     */         str = "InitFlt";
/*     */       case 13:
/*     */         str = "ZeroTqCtrl";
/*     */       case 12:
/*     */         str = "GenNoBatCtlDer";
/*     */       case 11:
/*     */         str = "GenNoBatCtl";
/*     */       case 10:
/*     */         str = "UDcCtlDer";
/*     */       case 9:
/*     */         str = "UDcCtl";
/*     */       case 8:
/*     */         str = "PwrDwn";
/*     */       case 7:
/*     */         str = "Initial";
/*     */       case 6:
/*     */         str = "SpdCtlDer";
/*     */       case 5:
/*     */         str = "SpdCtl";
/*     */       case 4:
/*     */         str = "TqCtlDer";
/*     */       case 3:
/*     */         str = "TqCtl";
/*     */       case 2:
/*     */         str = "Failure";
/*     */       case 1:
/*     */         str = "Stdby";
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
/* 126 */     boolean bool = false;
/*     */     
/* 128 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14)
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
/* 143 */       bool = true;
/*     */     }
/*     */     
/* 146 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MvEMModSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */