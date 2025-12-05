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
/*    */ public final class AutHldDrvrDisp
/*    */ {
/*    */   public static final int Err = 5;
/*    */   public static final int Msg1 = 1;
/*    */   public static final int Msg2 = 2;
/*    */   public static final int Msg3 = 3;
/*    */   public static final int Msg4 = 4;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     switch (paramInt) {
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
/* 41 */         return str;
/*    */       case 5:
/*    */         str = "Err";
/*    */       case 4:
/*    */         str = "Msg4";
/*    */       case 3:
/*    */         str = "Msg3";
/*    */       case 2:
/*    */         str = "Msg2";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "Msg1";
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
/* 66 */     boolean bool = false;
/*    */     
/* 68 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 73 */       bool = true;
/*    */     }
/*    */     
/* 76 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AutHldDrvrDisp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */