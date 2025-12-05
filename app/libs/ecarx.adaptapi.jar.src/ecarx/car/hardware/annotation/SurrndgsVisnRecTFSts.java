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
/*     */ public final class SurrndgsVisnRecTFSts
/*     */ {
/*     */   public static final int NoTFcard = 1;
/*     */   public static final int Normal = 0;
/*     */   public static final int TFCardDoNotBeInitialized = 2;
/*     */   public static final int TFCardNotFormat = 3;
/*     */   public static final int TFcardCantWrite = 4;
/*     */   public static final int TFcardEmergencyVideoAreaFull = 8;
/*     */   public static final int TFcardEmergencyVideoAreaOverZeroPointThree = 6;
/*     */   public static final int TFcardIncompatible = 5;
/*     */   public static final int TFcardLackOfSpace = 7;
/*     */   public static final int TFcardPhotoAreaFull = 9;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  28 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  29 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  61 */         return str;
/*     */       case 9:
/*     */         str = "TFcardPhotoAreaFull";
/*     */       case 8:
/*     */         str = "TFcardEmergencyVideoAreaFull";
/*     */       case 7:
/*     */         str = "TFcardLackOfSpace";
/*     */       case 6:
/*     */         str = "TFcardEmergencyVideoAreaOverZeroPointThree";
/*     */       case 5:
/*     */         str = "TFcardIncompatible";
/*     */       case 4:
/*     */         str = "TFcardCantWrite";
/*     */       case 3:
/*     */         str = "TFCardNotFormat";
/*     */       case 2:
/*     */         str = "TFCardDoNotBeInitialized";
/*     */       case 1:
/*     */         str = "NoTFcard";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Normal";
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
/*  96 */     boolean bool = false;
/*     */     
/*  98 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       bool = true;
/*     */     }
/*     */     
/* 111 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SurrndgsVisnRecTFSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */