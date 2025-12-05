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
/*    */ public final class Backup3
/*    */ {
/*    */   public static final int Bkp1 = 0;
/*    */   public static final int Bkp2 = 1;
/*    */   public static final int Bkp3 = 2;
/*    */   public static final int Bkp4 = 3;
/*    */   public static final int Bkp5 = 4;
/*    */   public static final int Bkp6 = 5;
/*    */   public static final int Bkp7 = 6;
/*    */   public static final int Bkp8 = 7;
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
/*    */         str = "Bkp8";
/*    */       case 6:
/*    */         str = "Bkp7";
/*    */       case 5:
/*    */         str = "Bkp6";
/*    */       case 4:
/*    */         str = "Bkp5";
/*    */       case 3:
/*    */         str = "Bkp4";
/*    */       case 2:
/*    */         str = "Bkp3";
/*    */       case 1:
/*    */         str = "Bkp2";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Bkp1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\Backup3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */