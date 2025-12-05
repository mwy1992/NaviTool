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
/*    */ public final class InhibitApSwdlType
/*    */ {
/*    */   public static final int NotReady = 0;
/*    */   public static final int Ready = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 18 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 19 */     switch (paramInt) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 27 */         return str;
/*    */       case 1:
/*    */         str = "Ready";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NotReady";
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
/* 46 */     boolean bool = false;
/*    */     
/* 48 */     if (paramInt == 0 || paramInt == 1)
/*    */     {
/* 50 */       bool = true;
/*    */     }
/*    */     
/* 53 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\InhibitApSwdlType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */