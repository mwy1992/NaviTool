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
/*    */ public final class SapParkingbuttonpush
/*    */ {
/*    */   public static final int CancelPrkButtonPressed = 5;
/*    */   public static final int PASButtonPressed = 9;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 18 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 19 */     if (paramInt != 5) { if (paramInt == 9)
/*    */       {
/*    */ 
/*    */ 
/*    */         
/* 24 */         str = "PASButtonPressed"; }  }
/*    */     else
/*    */     { str = "CancelPrkButtonPressed"; }
/* 27 */      return str;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isValid(int paramInt) {
/* 46 */     boolean bool = false;
/*    */     
/* 48 */     if (paramInt == 5 || paramInt == 9)
/*    */     {
/* 50 */       bool = true;
/*    */     }
/*    */     
/* 53 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SapParkingbuttonpush.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */