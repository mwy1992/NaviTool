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
/*     */ public final class VisnRecSts
/*     */ {
/*     */   public static final int AVMbrowse = 8;
/*     */   public static final int Emergencybrowse = 7;
/*     */   public static final int Emergencyrecord = 3;
/*     */   public static final int Error = 15;
/*     */   public static final int GeneralRecord = 1;
/*     */   public static final int Generalbrowse = 6;
/*     */   public static final int Initializing = 0;
/*     */   public static final int ParkingBrowse = 5;
/*     */   public static final int Pauserecord = 2;
/*     */   public static final int Pausevideo = 11;
/*     */   public static final int Photobrowse = 9;
/*     */   public static final int Playvideo = 10;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  30 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  31 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  69 */         return str;
/*     */       case 15:
/*     */         str = "Error";
/*     */       case 11:
/*     */         str = "Pausevideo";
/*     */       case 10:
/*     */         str = "Playvideo";
/*     */       case 9:
/*     */         str = "Photobrowse";
/*     */       case 8:
/*     */         str = "AVMbrowse";
/*     */       case 7:
/*     */         str = "Emergencybrowse";
/*     */       case 6:
/*     */         str = "Generalbrowse";
/*     */       case 5:
/*     */         str = "ParkingBrowse";
/*     */       case 3:
/*     */         str = "Emergencyrecord";
/*     */       case 2:
/*     */         str = "Pauserecord";
/*     */       case 1:
/*     */         str = "GeneralRecord";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Initializing";
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
/* 108 */     boolean bool = false;
/*     */     
/* 110 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 15 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11)
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
/* 122 */       bool = true;
/*     */     }
/*     */     
/* 125 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VisnRecSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */