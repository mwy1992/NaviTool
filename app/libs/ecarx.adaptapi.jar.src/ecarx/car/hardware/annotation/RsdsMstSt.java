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
/*    */ public final class RsdsMstSt
/*    */ {
/*    */   public static final int Blkd = 3;
/*    */   public static final int Cal = 7;
/*    */   public static final int Cfg = 0;
/*    */   public static final int Faulty = 4;
/*    */   public static final int Hot = 6;
/*    */   public static final int Runng = 2;
/*    */   public static final int Shutdown = 5;
/*    */   public static final int StrtUp = 1;
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
/*    */         str = "Cal";
/*    */       case 6:
/*    */         str = "Hot";
/*    */       case 5:
/*    */         str = "Shutdown";
/*    */       case 4:
/*    */         str = "Faulty";
/*    */       case 3:
/*    */         str = "Blkd";
/*    */       case 2:
/*    */         str = "Runng";
/*    */       case 1:
/*    */         str = "StrtUp";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Cfg";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RsdsMstSt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */