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
/*    */ public final class GlbRst
/*    */ {
/*    */   public static final int CarSetgRst = 1;
/*    */   public static final int DataAndSetgAllRst = 4;
/*    */   public static final int NoRst = 0;
/*    */   public static final int PrsnlSetgActvRst = 2;
/*    */   public static final int PrsnlSetgAllRst = 3;
/*    */   public static final int Resd1 = 5;
/*    */   public static final int Resd2 = 6;
/*    */   public static final int Resd3 = 7;
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
/*    */         str = "Resd3";
/*    */       case 6:
/*    */         str = "Resd2";
/*    */       case 5:
/*    */         str = "Resd1";
/*    */       case 4:
/*    */         str = "DataAndSetgAllRst";
/*    */       case 3:
/*    */         str = "PrsnlSetgAllRst";
/*    */       case 2:
/*    */         str = "PrsnlSetgActvRst";
/*    */       case 1:
/*    */         str = "CarSetgRst";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoRst";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\GlbRst.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */