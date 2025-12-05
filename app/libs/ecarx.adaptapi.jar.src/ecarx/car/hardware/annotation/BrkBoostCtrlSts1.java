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
/*    */ public final class BrkBoostCtrlSts1
/*    */ {
/*    */   public static final int Diagn = 2;
/*    */   public static final int FullOper = 7;
/*    */   public static final int Inin = 0;
/*    */   public static final int LimdOper = 5;
/*    */   public static final int NotAvl = 1;
/*    */   public static final int PostRunLimdOper = 6;
/*    */   public static final int SngOper = 4;
/*    */   public static final int Undefd = 3;
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
/*    */         str = "FullOper";
/*    */       case 6:
/*    */         str = "PostRunLimdOper";
/*    */       case 5:
/*    */         str = "LimdOper";
/*    */       case 4:
/*    */         str = "SngOper";
/*    */       case 3:
/*    */         str = "Undefd";
/*    */       case 2:
/*    */         str = "Diagn";
/*    */       case 1:
/*    */         str = "NotAvl";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Inin";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\BrkBoostCtrlSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */