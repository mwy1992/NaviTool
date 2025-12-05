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
/*     */ public final class SunRoofAndCurtExtCmd2
/*     */ {
/*     */   public static final int SunRoofAndCurtExtCmdTyp_AutClsFast = 7;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_AutOpenFast = 8;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_CurtAndPanInin = 15;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_CurtClsFull = 2;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_CurtClsShort = 9;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_CurtHalfOpn = 13;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_CurtOpenFull = 3;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_CurtOpnShort = 10;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_Idle = 0;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_PanAndCurtStop = 1;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_PanClsFull = 4;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_PanClsShort = 11;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_PanHalfOpn = 14;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_PanOpenFull = 5;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_PanOpnShort = 12;
/*     */   public static final int SunRoofAndCurtExtCmdTyp_PanTilt = 6;
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
/*     */         str = "SunRoofAndCurtExtCmdTyp_CurtAndPanInin";
/*     */       case 14:
/*     */         str = "SunRoofAndCurtExtCmdTyp_PanHalfOpn";
/*     */       case 13:
/*     */         str = "SunRoofAndCurtExtCmdTyp_CurtHalfOpn";
/*     */       case 12:
/*     */         str = "SunRoofAndCurtExtCmdTyp_PanOpnShort";
/*     */       case 11:
/*     */         str = "SunRoofAndCurtExtCmdTyp_PanClsShort";
/*     */       case 10:
/*     */         str = "SunRoofAndCurtExtCmdTyp_CurtOpnShort";
/*     */       case 9:
/*     */         str = "SunRoofAndCurtExtCmdTyp_CurtClsShort";
/*     */       case 8:
/*     */         str = "SunRoofAndCurtExtCmdTyp_AutOpenFast";
/*     */       case 7:
/*     */         str = "SunRoofAndCurtExtCmdTyp_AutClsFast";
/*     */       case 6:
/*     */         str = "SunRoofAndCurtExtCmdTyp_PanTilt";
/*     */       case 5:
/*     */         str = "SunRoofAndCurtExtCmdTyp_PanOpenFull";
/*     */       case 4:
/*     */         str = "SunRoofAndCurtExtCmdTyp_PanClsFull";
/*     */       case 3:
/*     */         str = "SunRoofAndCurtExtCmdTyp_CurtOpenFull";
/*     */       case 2:
/*     */         str = "SunRoofAndCurtExtCmdTyp_CurtClsFull";
/*     */       case 1:
/*     */         str = "SunRoofAndCurtExtCmdTyp_PanAndCurtStop";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "SunRoofAndCurtExtCmdTyp_Idle";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SunRoofAndCurtExtCmd2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */