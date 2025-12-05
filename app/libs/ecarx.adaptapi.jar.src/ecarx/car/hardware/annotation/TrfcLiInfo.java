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
/*     */ public final class TrfcLiInfo
/*     */ {
/*     */   public static final int LightenGreenCircle = 4;
/*     */   public static final int LightenGreenLeftArrow = 7;
/*     */   public static final int LightenGreenRightArrow = 13;
/*     */   public static final int LightenGreenStraightArrow = 10;
/*     */   public static final int LightenRedCircle = 2;
/*     */   public static final int LightenRedLeftArrow = 5;
/*     */   public static final int LightenRedRightArrow = 11;
/*     */   public static final int LightenRedStraightArrow = 8;
/*     */   public static final int LightenYellowCircle = 3;
/*     */   public static final int LightenYellowLeftArrow = 6;
/*     */   public static final int LightenYellowRightArrow = 12;
/*     */   public static final int LightenYellowStraightArrow = 9;
/*     */   public static final int Timetogo = 1;
/*     */   public static final int empty = 0;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  32 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  33 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  77 */         return str;
/*     */       case 13:
/*     */         str = "LightenGreenRightArrow";
/*     */       case 12:
/*     */         str = "LightenYellowRightArrow";
/*     */       case 11:
/*     */         str = "LightenRedRightArrow";
/*     */       case 10:
/*     */         str = "LightenGreenStraightArrow";
/*     */       case 9:
/*     */         str = "LightenYellowStraightArrow";
/*     */       case 8:
/*     */         str = "LightenRedStraightArrow";
/*     */       case 7:
/*     */         str = "LightenGreenLeftArrow";
/*     */       case 6:
/*     */         str = "LightenYellowLeftArrow";
/*     */       case 5:
/*     */         str = "LightenRedLeftArrow";
/*     */       case 4:
/*     */         str = "LightenGreenCircle";
/*     */       case 3:
/*     */         str = "LightenYellowCircle";
/*     */       case 2:
/*     */         str = "LightenRedCircle";
/*     */       case 1:
/*     */         str = "Timetogo";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "empty";
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
/* 120 */     boolean bool = false;
/*     */     
/* 122 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13)
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
/* 136 */       bool = true;
/*     */     }
/*     */     
/* 139 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TrfcLiInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */