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
/*     */ public final class DvrErrSts
/*     */ {
/*     */   public static final int AbnormalVolt = 14;
/*     */   public static final int DVROccupied = 11;
/*     */   public static final int EthernetError = 3;
/*     */   public static final int GSensorError = 4;
/*     */   public static final int NandFlashReadingError = 5;
/*     */   public static final int NandFlashWritingError = 6;
/*     */   public static final int NoCameraConnected = 1;
/*     */   public static final int NoError = 0;
/*     */   public static final int OverHeatProtectionMode = 10;
/*     */   public static final int PASErrorHappened = 8;
/*     */   public static final int RecordingError = 2;
/*     */   public static final int Reserved1_9 = 9;
/*     */   public static final int SystemCrashOrWatchDogTimeout = 7;
/*     */   public static final int TFcardFragment = 13;
/*     */   public static final int TFcardSlow = 12;
/*     */   public static final int UnknownError = 15;
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
/*     */         str = "UnknownError";
/*     */       case 14:
/*     */         str = "AbnormalVolt";
/*     */       case 13:
/*     */         str = "TFcardFragment";
/*     */       case 12:
/*     */         str = "TFcardSlow";
/*     */       case 11:
/*     */         str = "DVROccupied";
/*     */       case 10:
/*     */         str = "OverHeatProtectionMode";
/*     */       case 9:
/*     */         str = "Reserved1_9";
/*     */       case 8:
/*     */         str = "PASErrorHappened";
/*     */       case 7:
/*     */         str = "SystemCrashOrWatchDogTimeout";
/*     */       case 6:
/*     */         str = "NandFlashWritingError";
/*     */       case 5:
/*     */         str = "NandFlashReadingError";
/*     */       case 4:
/*     */         str = "GSensorError";
/*     */       case 3:
/*     */         str = "EthernetError";
/*     */       case 2:
/*     */         str = "RecordingError";
/*     */       case 1:
/*     */         str = "NoCameraConnected";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoError";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DvrErrSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */