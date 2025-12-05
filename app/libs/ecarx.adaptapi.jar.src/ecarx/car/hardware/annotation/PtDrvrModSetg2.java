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
/*    */ public final class PtDrvrModSetg2
/*    */ {
/*    */   public static final int AWD = 7;
/*    */   public static final int Cmft = 1;
/*    */   public static final int Dyn = 3;
/*    */   public static final int Eco = 2;
/*    */   public static final int Hyb = 5;
/*    */   public static final int Pure = 4;
/*    */   public static final int Pwr = 6;
/*    */   public static final int Undefd = 0;
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
/*    */         str = "AWD";
/*    */       case 6:
/*    */         str = "Pwr";
/*    */       case 5:
/*    */         str = "Hyb";
/*    */       case 4:
/*    */         str = "Pure";
/*    */       case 3:
/*    */         str = "Dyn";
/*    */       case 2:
/*    */         str = "Eco";
/*    */       case 1:
/*    */         str = "Cmft";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Undefd";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PtDrvrModSetg2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */