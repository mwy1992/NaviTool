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
/*    */ public final class Type4
/*    */ {
/*    */   public static final int FORWARD = 3;
/*    */   public static final int LEFT = 1;
/*    */   public static final int LEFT_FORWARD = 4;
/*    */   public static final int LEFT_RIGHT = 5;
/*    */   public static final int LEFT_RIGHT_FORWARD = 7;
/*    */   public static final int RIGHT = 2;
/*    */   public static final int RIGHT_FORWARD = 6;
/*    */   public static final int UNKNOWN = 0;
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
/*    */         str = "LEFT_RIGHT_FORWARD";
/*    */       case 6:
/*    */         str = "RIGHT_FORWARD";
/*    */       case 5:
/*    */         str = "LEFT_RIGHT";
/*    */       case 4:
/*    */         str = "LEFT_FORWARD";
/*    */       case 3:
/*    */         str = "FORWARD";
/*    */       case 2:
/*    */         str = "RIGHT";
/*    */       case 1:
/*    */         str = "LEFT";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "UNKNOWN";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\Type4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */