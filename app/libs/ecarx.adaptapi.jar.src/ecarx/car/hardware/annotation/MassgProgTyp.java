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
/*    */ public final class MassgProgTyp
/*    */ {
/*    */   public static final int Prog1 = 0;
/*    */   public static final int Prog2 = 1;
/*    */   public static final int Prog3 = 2;
/*    */   public static final int Prog4 = 3;
/*    */   public static final int Prog5 = 4;
/*    */   public static final int Prog6 = 5;
/*    */   public static final int Prog7 = 6;
/*    */   public static final int Prog8 = 7;
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
/*    */         str = "Prog8";
/*    */       case 6:
/*    */         str = "Prog7";
/*    */       case 5:
/*    */         str = "Prog6";
/*    */       case 4:
/*    */         str = "Prog5";
/*    */       case 3:
/*    */         str = "Prog4";
/*    */       case 2:
/*    */         str = "Prog3";
/*    */       case 1:
/*    */         str = "Prog2";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Prog1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MassgProgTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */