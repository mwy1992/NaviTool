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
/*    */ public final class SapParkingexitpicturereturn
/*    */ {
/*    */   public static final int CheckSelf = 3;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 17 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 18 */     if (paramInt == 3)
/*    */     {
/* 20 */       str = "CheckSelf";
/*    */     }
/*    */     
/* 23 */     return str;
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
/*    */   public static boolean isValid(int paramInt) {
/* 40 */     boolean bool = false;
/*    */     
/* 42 */     if (paramInt == 3) {
/* 43 */       bool = true;
/*    */     }
/*    */     
/* 46 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SapParkingexitpicturereturn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */