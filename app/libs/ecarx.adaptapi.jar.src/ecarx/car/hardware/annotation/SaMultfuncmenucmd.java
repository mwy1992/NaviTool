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
/*    */ public final class SaMultfuncmenucmd
/*    */ {
/*    */   public static final int BackBlster = 2;
/*    */   public static final int CushExtn = 3;
/*    */   public static final int HdrestHeiAndHdrestTilt = 4;
/*    */   public static final int LumExtnAndLumHei = 1;
/*    */   public static final int MassgFct = 5;
/*    */   public static final int NotAvl = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 43 */         return str;
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
/* 70 */     boolean bool = false;
/*    */     
/* 72 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 78 */       bool = true;
/*    */     }
/*    */     
/* 81 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SaMultfuncmenucmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */