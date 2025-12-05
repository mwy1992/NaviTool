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
/*    */ public final class VFMiscMirrTiltSetg
/*    */ {
/*    */   public static final int Left = 1;
/*    */   public static final int OFF = 0;
/*    */   public static final int ON = 3;
/*    */   public static final int Right = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 20 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 21 */     switch (paramInt) {
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
/* 35 */         return str;
/*    */       case 3:
/*    */         str = "ON";
/*    */       case 2:
/*    */         str = "Right";
/*    */       case 1:
/*    */         str = "Left";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "OFF";
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
/* 58 */     boolean bool = false;
/*    */     
/* 60 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3)
/*    */     {
/*    */ 
/*    */       
/* 64 */       bool = true;
/*    */     }
/*    */     
/* 67 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VFMiscMirrTiltSetg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */