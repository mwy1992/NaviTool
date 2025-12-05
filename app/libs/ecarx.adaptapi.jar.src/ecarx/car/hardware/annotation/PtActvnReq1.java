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
/*    */ public final class PtActvnReq1
/*    */ {
/*    */   public static final int NoPtActvnReq = 0;
/*    */   public static final int PtActvnNotDriving = 3;
/*    */   public static final int PtActvnReq = 1;
/*    */   public static final int PtActvnReqRem = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 22 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 23 */     switch (paramInt) {
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
/* 37 */         return str;
/*    */       case 3:
/*    */         str = "PtActvnNotDriving";
/*    */       case 2:
/*    */         str = "PtActvnReqRem";
/*    */       case 1:
/*    */         str = "PtActvnReq";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoPtActvnReq";
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
/* 60 */     boolean bool = false;
/*    */     
/* 62 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3)
/*    */     {
/*    */ 
/*    */       
/* 66 */       bool = true;
/*    */     }
/*    */     
/* 69 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PtActvnReq1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */