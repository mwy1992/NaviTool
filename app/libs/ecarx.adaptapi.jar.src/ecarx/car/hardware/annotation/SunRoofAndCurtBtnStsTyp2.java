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
/*    */ 
/*    */ 
/*    */ public final class SunRoofAndCurtBtnStsTyp2
/*    */ {
/*    */   public static final int BackwStep1 = 1;
/*    */   public static final int BackwStep2 = 2;
/*    */   public static final int Failr = 7;
/*    */   public static final int ForwStep1 = 3;
/*    */   public static final int ForwStep2 = 4;
/*    */   public static final int Idle = 0;
/*    */   public static final int TiltDwnStep1 = 6;
/*    */   public static final int TiltUpStep1 = 5;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 26 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 27 */     switch (paramInt) {
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
/* 53 */         return str;
/*    */       case 7:
/*    */         str = "Failr";
/*    */       case 6:
/*    */         str = "TiltDwnStep1";
/*    */       case 5:
/*    */         str = "TiltUpStep1";
/*    */       case 4:
/*    */         str = "ForwStep2";
/*    */       case 3:
/*    */         str = "ForwStep1";
/*    */       case 2:
/*    */         str = "BackwStep2";
/*    */       case 1:
/*    */         str = "BackwStep1";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Idle";
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
/* 84 */     boolean bool = false;
/*    */     
/* 86 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 94 */       bool = true;
/*    */     }
/*    */     
/* 97 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SunRoofAndCurtBtnStsTyp2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */