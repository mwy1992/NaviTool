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
/*    */ public final class LgtFctFail
/*    */ {
/*    */   public static final int APAFailure = 2;
/*    */   public static final int HPAFailure = 4;
/*    */   public static final int HWAFailure = 5;
/*    */   public static final int NoFailure = 0;
/*    */   public static final int RPAFailure = 3;
/*    */   public static final int Reserved3_7 = 7;
/*    */   public static final int SHWAFailure = 6;
/*    */   public static final int TJPFailure = 1;
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
/*    */         str = "Reserved3_7";
/*    */       case 6:
/*    */         str = "SHWAFailure";
/*    */       case 5:
/*    */         str = "HWAFailure";
/*    */       case 4:
/*    */         str = "HPAFailure";
/*    */       case 3:
/*    */         str = "RPAFailure";
/*    */       case 2:
/*    */         str = "APAFailure";
/*    */       case 1:
/*    */         str = "TJPFailure";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoFailure";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LgtFctFail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */