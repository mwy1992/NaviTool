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
/*    */ public final class WipgSpd2
/*    */ {
/*    */   public static final int WipgSpd0Rpm = 0;
/*    */   public static final int WipgSpd40Rpm = 1;
/*    */   public static final int WipgSpd43Rpm = 2;
/*    */   public static final int WipgSpd46Rpm = 3;
/*    */   public static final int WipgSpd50Rpm = 4;
/*    */   public static final int WipgSpd54Rpm = 5;
/*    */   public static final int WipgSpd57Rpm = 6;
/*    */   public static final int WipgSpd60Rpm = 7;
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
/*    */         str = "WipgSpd60Rpm";
/*    */       case 6:
/*    */         str = "WipgSpd57Rpm";
/*    */       case 5:
/*    */         str = "WipgSpd54Rpm";
/*    */       case 4:
/*    */         str = "WipgSpd50Rpm";
/*    */       case 3:
/*    */         str = "WipgSpd46Rpm";
/*    */       case 2:
/*    */         str = "WipgSpd43Rpm";
/*    */       case 1:
/*    */         str = "WipgSpd40Rpm";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "WipgSpd0Rpm";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WipgSpd2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */