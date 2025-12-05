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
/*    */ public final class UnlckKeylsCfg2
/*    */ {
/*    */   public static final int UnlckCen = 0;
/*    */   public static final int UnlckInd = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 20 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 21 */     switch (paramInt) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 29 */         return str;
/*    */       case 1:
/*    */         str = "UnlckInd";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "UnlckCen";
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
/* 48 */     boolean bool = false;
/*    */     
/* 50 */     if (paramInt == 0 || paramInt == 1)
/*    */     {
/* 52 */       bool = true;
/*    */     }
/*    */     
/* 55 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\UnlckKeylsCfg2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */