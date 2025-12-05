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
/*    */ public final class SeatAvlsts
/*    */ {
/*    */   public static final int ShcAvailable = 1;
/*    */   public static final int ShcEnergylimit = 5;
/*    */   public static final int ShcError = 3;
/*    */   public static final int ShcFunctionalimit = 4;
/*    */   public static final int ShcNone = 0;
/*    */   public static final int ShcUnavailable = 2;
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
/*    */         str = "ShcEnergylimit";
/*    */       case 4:
/*    */         str = "ShcFunctionalimit";
/*    */       case 3:
/*    */         str = "ShcError";
/*    */       case 2:
/*    */         str = "ShcUnavailable";
/*    */       case 1:
/*    */         str = "ShcAvailable";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ShcNone";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SeatAvlsts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */