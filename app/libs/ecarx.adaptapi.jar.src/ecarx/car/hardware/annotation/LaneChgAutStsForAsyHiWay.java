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
/*     */ public final class LaneChgAutStsForAsyHiWay
/*     */ {
/*     */   public static final int LaneChgCncOnLeSide = 9;
/*     */   public static final int LaneChgCncOnRiSide = 10;
/*     */   public static final int LaneChgFailrOnLeSide = 3;
/*     */   public static final int LaneChgFailrOnRiSide = 4;
/*     */   public static final int LaneChgNotAvlOnLeSide = 5;
/*     */   public static final int LaneChgNotAvlOnRiSide = 6;
/*     */   public static final int LaneChgOnLeSideFinsh = 1;
/*     */   public static final int LaneChgOnLeSideProgress = 7;
/*     */   public static final int LaneChgOnRiSideFinsh = 2;
/*     */   public static final int LaneChgOnRiSideProgress = 8;
/*     */   public static final int NoLaneChg = 0;
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
/*     */         str = "LaneChgCncOnRiSide";
/*     */       case 9:
/*     */         str = "LaneChgCncOnLeSide";
/*     */       case 8:
/*     */         str = "LaneChgOnRiSideProgress";
/*     */       case 7:
/*     */         str = "LaneChgOnLeSideProgress";
/*     */       case 6:
/*     */         str = "LaneChgNotAvlOnRiSide";
/*     */       case 5:
/*     */         str = "LaneChgNotAvlOnLeSide";
/*     */       case 4:
/*     */         str = "LaneChgFailrOnRiSide";
/*     */       case 3:
/*     */         str = "LaneChgFailrOnLeSide";
/*     */       case 2:
/*     */         str = "LaneChgOnRiSideFinsh";
/*     */       case 1:
/*     */         str = "LaneChgOnLeSideFinsh";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoLaneChg";
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
/* 104 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LaneChgAutStsForAsyHiWay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */