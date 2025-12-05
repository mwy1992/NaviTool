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
/*     */ public final class SwtDispOnAndOffStsResp1
/*     */ {
/*     */   public static final int AVMEnterByDTC = 3;
/*     */   public static final int AVMEnterByRgear = 2;
/*     */   public static final int AVMEnterBySoftSwitch = 1;
/*     */   public static final int AVMEnterByVideoTransmitStart = 4;
/*     */   public static final int AVMExitAfter5sWhenEnterPgear = 9;
/*     */   public static final int AVMExitByAllCamerasFault = 12;
/*     */   public static final int AVMExitByOverspeed = 8;
/*     */   public static final int AVMExitBySoftSwitch = 7;
/*     */   public static final int AVMExitBySystemFault = 11;
/*     */   public static final int AVMExitByVideoTransmitStop = 10;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  26 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  27 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  59 */         return str;
/*     */       case 12:
/*     */         str = "AVMExitByAllCamerasFault";
/*     */       case 11:
/*     */         str = "AVMExitBySystemFault";
/*     */       case 10:
/*     */         str = "AVMExitByVideoTransmitStop";
/*     */       case 9:
/*     */         str = "AVMExitAfter5sWhenEnterPgear";
/*     */       case 8:
/*     */         str = "AVMExitByOverspeed";
/*     */       case 7:
/*     */         str = "AVMExitBySoftSwitch";
/*     */       case 4:
/*     */         str = "AVMEnterByVideoTransmitStart";
/*     */       case 3:
/*     */         str = "AVMEnterByDTC";
/*     */       case 2:
/*     */         str = "AVMEnterByRgear";
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     str = "AVMEnterBySoftSwitch";
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
/*  94 */     boolean bool = false;
/*     */     
/*  96 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 106 */       bool = true;
/*     */     }
/*     */     
/* 109 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SwtDispOnAndOffStsResp1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */