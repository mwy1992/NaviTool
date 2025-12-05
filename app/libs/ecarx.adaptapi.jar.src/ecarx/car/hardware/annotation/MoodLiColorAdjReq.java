/*    */ package ecarx.car.hardware.annotation;
/*    */ 
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MoodLiColorAdjReq
/*    */ {
/*    */   public static final int MoodlicoloradjreqGlacier = 5;
/*    */   public static final int MoodlicoloradjreqGold = 2;
/*    */   public static final int MoodlicoloradjreqRainforest = 4;
/*    */   public static final int MoodlicoloradjreqSunset = 3;
/*    */   public static final int MoodlicoloradjreqTuscanwhite = 1;
/*    */   public static final int MoodlicoloradjreqVineyard = 6;
/*    */   public static final int MoodlicoloradjreqWhiteforest = 0;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     switch (paramInt) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 47 */         return str;
/*    */       case 6:
/*    */         str = "MoodlicoloradjreqVineyard";
/*    */       case 5:
/*    */         str = "MoodlicoloradjreqGlacier";
/*    */       case 4:
/*    */         str = "MoodlicoloradjreqRainforest";
/*    */       case 3:
/*    */         str = "MoodlicoloradjreqSunset";
/*    */       case 2:
/*    */         str = "MoodlicoloradjreqGold";
/*    */       case 1:
/*    */         str = "MoodlicoloradjreqTuscanwhite";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "MoodlicoloradjreqWhiteforest";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isValid(int paramInt) {
/* 76 */     boolean bool = false;
/*    */     
/* 78 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 85 */       bool = true;
/*    */     }
/*    */     
/* 88 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MoodLiColorAdjReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */