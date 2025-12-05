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
/*    */ public final class TrsmActrPosn1
/*    */ {
/*    */   public static final int Drv = 6;
/*    */   public static final int Neut = 4;
/*    */   public static final int NeutDrv = 5;
/*    */   public static final int Park = 0;
/*    */   public static final int ParkRvs = 1;
/*    */   public static final int Rvs = 2;
/*    */   public static final int RvsNeut = 3;
/*    */   public static final int Undefd = 7;
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
/*    */         str = "Undefd";
/*    */       case 6:
/*    */         str = "Drv";
/*    */       case 5:
/*    */         str = "NeutDrv";
/*    */       case 4:
/*    */         str = "Neut";
/*    */       case 3:
/*    */         str = "RvsNeut";
/*    */       case 2:
/*    */         str = "Rvs";
/*    */       case 1:
/*    */         str = "ParkRvs";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Park";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TrsmActrPosn1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */