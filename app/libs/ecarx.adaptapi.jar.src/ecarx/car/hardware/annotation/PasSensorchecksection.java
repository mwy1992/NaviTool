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
/*    */ public final class PasSensorchecksection
/*    */ {
/*    */   public static final int FifthGreenLight = 5;
/*    */   public static final int FirstRedLight = 1;
/*    */   public static final int FourthGreenLight = 4;
/*    */   public static final int NoAction = 0;
/*    */   public static final int SecondYellowLight = 2;
/*    */   public static final int SixthGreenLight = 6;
/*    */   public static final int ThirdYellowLight = 3;
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
/*    */         str = "SixthGreenLight";
/*    */       case 5:
/*    */         str = "FifthGreenLight";
/*    */       case 4:
/*    */         str = "FourthGreenLight";
/*    */       case 3:
/*    */         str = "ThirdYellowLight";
/*    */       case 2:
/*    */         str = "SecondYellowLight";
/*    */       case 1:
/*    */         str = "FirstRedLight";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoAction";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PasSensorchecksection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */