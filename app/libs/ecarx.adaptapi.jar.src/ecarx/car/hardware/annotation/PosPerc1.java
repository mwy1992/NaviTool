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
/*    */ public final class PosPerc1
/*    */ {
/*    */   public static final int NoReq = 0;
/*    */   public static final int _0to20PercTopPos = 1;
/*    */   public static final int _21to40PercTopPos = 2;
/*    */   public static final int _41to60PercTopPos = 3;
/*    */   public static final int _61to80PercTopPos = 4;
/*    */   public static final int _81to100PercTopPos = 5;
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
/*    */       default:
/* 45 */         return str;
/*    */       case 5:
/*    */         str = "_81to100PercTopPos";
/*    */       case 4:
/*    */         str = "_61to80PercTopPos";
/*    */       case 3:
/*    */         str = "_41to60PercTopPos";
/*    */       case 2:
/*    */         str = "_21to40PercTopPos";
/*    */       case 1:
/*    */         str = "_0to20PercTopPos";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoReq";
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
/* 72 */     boolean bool = false;
/*    */     
/* 74 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 80 */       bool = true;
/*    */     }
/*    */     
/* 83 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PosPerc1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */