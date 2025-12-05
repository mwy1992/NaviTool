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
/*    */ public final class ChargColor
/*    */ {
/*    */   public static final int Blue = 3;
/*    */   public static final int Blue2 = 4;
/*    */   public static final int DefaultValue = 7;
/*    */   public static final int Gray = 0;
/*    */   public static final int GrayYellow = 1;
/*    */   public static final int Green = 2;
/*    */   public static final int Red = 6;
/*    */   public static final int Yellow = 5;
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
/*    */       case 7:
/*    */         str = "DefaultValue";
/*    */       case 6:
/*    */         str = "Red";
/*    */       case 5:
/*    */         str = "Yellow";
/*    */       case 4:
/*    */         str = "Blue2";
/*    */       case 3:
/*    */         str = "Blue";
/*    */       case 2:
/*    */         str = "Green";
/*    */       case 1:
/*    */         str = "GrayYellow";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Gray";
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
/* 84 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ChargColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */