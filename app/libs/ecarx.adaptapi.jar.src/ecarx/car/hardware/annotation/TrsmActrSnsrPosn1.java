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
/*    */ public final class TrsmActrSnsrPosn1
/*    */ {
/*    */   public static final int Drv = 1;
/*    */   public static final int Neut = 3;
/*    */   public static final int NeutDrv = 2;
/*    */   public static final int Park = 7;
/*    */   public static final int ParkRvs = 6;
/*    */   public static final int Rvs = 5;
/*    */   public static final int RvsNeut = 4;
/*    */   public static final int Undefd = 0;
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
/*    */         str = "Park";
/*    */       case 6:
/*    */         str = "ParkRvs";
/*    */       case 5:
/*    */         str = "Rvs";
/*    */       case 4:
/*    */         str = "RvsNeut";
/*    */       case 3:
/*    */         str = "Neut";
/*    */       case 2:
/*    */         str = "NeutDrv";
/*    */       case 1:
/*    */         str = "Drv";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TrsmActrSnsrPosn1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */