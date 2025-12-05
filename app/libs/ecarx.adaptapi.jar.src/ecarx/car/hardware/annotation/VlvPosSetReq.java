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
/*     */ public final class VlvPosSetReq
/*     */ {
/*     */   public static final int MovetoLevel10OpenPosition = 10;
/*     */   public static final int MovetoLevel11OpenPosition = 11;
/*     */   public static final int MovetoLevel12OpenPosition = 12;
/*     */   public static final int MovetoLevel13OpenPosition = 13;
/*     */   public static final int MovetoLevel14OpenPosition = 14;
/*     */   public static final int MovetoLevel15OpenPosition = 15;
/*     */   public static final int MovetoLevel16OpenPosition = 16;
/*     */   public static final int MovetoLevel17OpenPosition = 17;
/*     */   public static final int MovetoLevel18OpenPosition = 18;
/*     */   public static final int MovetoLevel19OpenPosition = 19;
/*     */   public static final int MovetoLevel1OpenPosition = 1;
/*     */   public static final int MovetoLevel2OpenPosition = 2;
/*     */   public static final int MovetoLevel3OpenPosition = 3;
/*     */   public static final int MovetoLevel4OpenPosition = 4;
/*     */   public static final int MovetoLevel5OpenPosition = 5;
/*     */   public static final int MovetoLevel6OpenPosition = 6;
/*     */   public static final int MovetoLevel7OpenPosition = 7;
/*     */   public static final int MovetoLevel8OpenPosition = 8;
/*     */   public static final int MovetoLevel9OpenPosition = 9;
/*     */   public static final int MovetofullClosePosition = 0;
/*     */   public static final int MovetofullOpenPosition = 20;
/*     */   public static final int Reserved_21 = 21;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  40 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  41 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 109 */         return str;
/*     */       case 21:
/*     */         str = "Reserved_21";
/*     */       case 20:
/*     */         str = "MovetofullOpenPosition";
/*     */       case 19:
/*     */         str = "MovetoLevel19OpenPosition";
/*     */       case 18:
/*     */         str = "MovetoLevel18OpenPosition";
/*     */       case 17:
/*     */         str = "MovetoLevel17OpenPosition";
/*     */       case 16:
/*     */         str = "MovetoLevel16OpenPosition";
/*     */       case 15:
/*     */         str = "MovetoLevel15OpenPosition";
/*     */       case 14:
/*     */         str = "MovetoLevel14OpenPosition";
/*     */       case 13:
/*     */         str = "MovetoLevel13OpenPosition";
/*     */       case 12:
/*     */         str = "MovetoLevel12OpenPosition";
/*     */       case 11:
/*     */         str = "MovetoLevel11OpenPosition";
/*     */       case 10:
/*     */         str = "MovetoLevel10OpenPosition";
/*     */       case 9:
/*     */         str = "MovetoLevel9OpenPosition";
/*     */       case 8:
/*     */         str = "MovetoLevel8OpenPosition";
/*     */       case 7:
/*     */         str = "MovetoLevel7OpenPosition";
/*     */       case 6:
/*     */         str = "MovetoLevel6OpenPosition";
/*     */       case 5:
/*     */         str = "MovetoLevel5OpenPosition";
/*     */       case 4:
/*     */         str = "MovetoLevel4OpenPosition";
/*     */       case 3:
/*     */         str = "MovetoLevel3OpenPosition";
/*     */       case 2:
/*     */         str = "MovetoLevel2OpenPosition";
/*     */       case 1:
/*     */         str = "MovetoLevel1OpenPosition";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "MovetofullClosePosition";
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
/* 168 */     boolean bool = false;
/*     */     
/* 170 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21)
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
/* 192 */       bool = true;
/*     */     }
/*     */     
/* 195 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VlvPosSetReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */