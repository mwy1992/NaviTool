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
/*    */ public final class WipgSpdIntlFromHmi
/*    */ {
/*    */   public static final int Posn0 = 0;
/*    */   public static final int Posn1 = 1;
/*    */   public static final int Posn2 = 2;
/*    */   public static final int Posn3 = 3;
/*    */   public static final int Posn4 = 4;
/*    */   public static final int Posn5 = 5;
/*    */   public static final int Posn6 = 6;
/*    */   public static final int Posn7 = 7;
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
/*    */         str = "Posn7";
/*    */       case 6:
/*    */         str = "Posn6";
/*    */       case 5:
/*    */         str = "Posn5";
/*    */       case 4:
/*    */         str = "Posn4";
/*    */       case 3:
/*    */         str = "Posn3";
/*    */       case 2:
/*    */         str = "Posn2";
/*    */       case 1:
/*    */         str = "Posn1";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Posn0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WipgSpdIntlFromHmi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */