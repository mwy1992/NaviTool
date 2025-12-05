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
/*    */ public final class TailgatePos
/*    */ {
/*    */   public static final int Fail = 1;
/*    */   public static final int Unknown = 0;
/*    */   public static final int _0to20PercTopPos = 2;
/*    */   public static final int _21to40PercTopPos = 3;
/*    */   public static final int _41to60PercTopPos = 4;
/*    */   public static final int _61to80PercTopPos = 5;
/*    */   public static final int _81to100PercTopPos = 6;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 26 */     switch (paramInt) {
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
/* 49 */         return str;
/*    */       case 6:
/*    */         str = "_81to100PercTopPos";
/*    */       case 5:
/*    */         str = "_61to80PercTopPos";
/*    */       case 4:
/*    */         str = "_41to60PercTopPos";
/*    */       case 3:
/*    */         str = "_21to40PercTopPos";
/*    */       case 2:
/*    */         str = "_0to20PercTopPos";
/*    */       case 1:
/*    */         str = "Fail";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Unknown";
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
/* 78 */     boolean bool = false;
/*    */     
/* 80 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 87 */       bool = true;
/*    */     }
/*    */     
/* 90 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TailgatePos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */