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
/*    */ public final class SeatActvSpplFct1
/*    */ {
/*    */   public static final int BackBlster = 2;
/*    */   public static final int CushExtn = 3;
/*    */   public static final int HdrestHeiAndHdrestTilt = 4;
/*    */   public static final int LegrestFct = 7;
/*    */   public static final int LumExtnAndLumHei = 1;
/*    */   public static final int MassgFct = 5;
/*    */   public static final int NotAvl = 0;
/*    */   public static final int ShoulderFct = 6;
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
/*    */         str = "LegrestFct";
/*    */       case 6:
/*    */         str = "ShoulderFct";
/*    */       case 5:
/*    */         str = "MassgFct";
/*    */       case 4:
/*    */         str = "HdrestHeiAndHdrestTilt";
/*    */       case 3:
/*    */         str = "CushExtn";
/*    */       case 2:
/*    */         str = "BackBlster";
/*    */       case 1:
/*    */         str = "LumExtnAndLumHei";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NotAvl";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SeatActvSpplFct1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */