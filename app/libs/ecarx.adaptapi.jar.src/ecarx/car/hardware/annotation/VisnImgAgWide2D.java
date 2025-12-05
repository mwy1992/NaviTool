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
/*    */ public final class VisnImgAgWide2D
/*    */ {
/*    */   public static final int FrontAndAVM = 1;
/*    */   public static final int FrontZoomIn180DegView = 8;
/*    */   public static final int LeftAndAVM = 3;
/*    */   public static final int LeftFrontAndRightFrontView = 10;
/*    */   public static final int LeftRearAndRightRearView = 11;
/*    */   public static final int RearAndAVM = 4;
/*    */   public static final int RearZoomIn180DegView = 9;
/*    */   public static final int RightAndAVM = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 24 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 25 */     switch (paramInt) {
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
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 51 */         return str;
/*    */       case 11:
/*    */         str = "LeftRearAndRightRearView";
/*    */       case 10:
/*    */         str = "LeftFrontAndRightFrontView";
/*    */       case 9:
/*    */         str = "RearZoomIn180DegView";
/*    */       case 8:
/*    */         str = "FrontZoomIn180DegView";
/*    */       case 4:
/*    */         str = "RearAndAVM";
/*    */       case 3:
/*    */         str = "LeftAndAVM";
/*    */       case 2:
/*    */         str = "RightAndAVM";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "FrontAndAVM";
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
/* 82 */     boolean bool = false;
/*    */     
/* 84 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 92 */       bool = true;
/*    */     }
/*    */     
/* 95 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VisnImgAgWide2D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */