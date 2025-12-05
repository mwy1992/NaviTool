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
/*    */ public final class ButtonLocation
/*    */ {
/*    */   public static final int MemBut1 = 1;
/*    */   public static final int MemBut2 = 2;
/*    */   public static final int MemBut3 = 3;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 19 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 20 */     switch (paramInt) {
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
/* 31 */         return str;
/*    */       case 3:
/*    */         str = "MemBut3";
/*    */       case 2:
/*    */         str = "MemBut2";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "MemBut1";
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
/* 52 */     boolean bool = false;
/*    */     
/* 54 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3)
/*    */     {
/*    */       
/* 57 */       bool = true;
/*    */     }
/*    */     
/* 60 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ButtonLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */