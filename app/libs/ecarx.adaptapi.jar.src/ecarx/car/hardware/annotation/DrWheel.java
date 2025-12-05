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
/*    */ public final class DrWheel
/*    */ {
/*    */   public static final int Fourwheels = 3;
/*    */   public static final int Frontwheel = 1;
/*    */   public static final int Invalid = 0;
/*    */   public static final int Rearwheel = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 22 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 23 */     switch (paramInt) {
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
/* 37 */         return str;
/*    */       case 3:
/*    */         str = "Fourwheels";
/*    */       case 2:
/*    */         str = "Rearwheel";
/*    */       case 1:
/*    */         str = "Frontwheel";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Invalid";
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
/* 60 */     boolean bool = false;
/*    */     
/* 62 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3)
/*    */     {
/*    */ 
/*    */       
/* 66 */       bool = true;
/*    */     }
/*    */     
/* 69 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */