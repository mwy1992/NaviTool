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
/*    */ public final class LineColor
/*    */ {
/*    */   public static final int Blue = 3;
/*    */   public static final int Green = 5;
/*    */   public static final int Orange = 4;
/*    */   public static final int Other = 6;
/*    */   public static final int Red = 2;
/*    */   public static final int White = 0;
/*    */   public static final int Yellow = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 26 */     switch (paramInt) {
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
/* 49 */         return str;
/*    */       case 6:
/*    */         str = "Other";
/*    */       case 5:
/*    */         str = "Green";
/*    */       case 4:
/*    */         str = "Orange";
/*    */       case 3:
/*    */         str = "Blue";
/*    */       case 2:
/*    */         str = "Red";
/*    */       case 1:
/*    */         str = "Yellow";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "White";
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
/* 78 */     boolean bool = false;
/*    */     
/* 80 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 87 */       bool = true;
/*    */     }
/*    */     
/* 90 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LineColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */