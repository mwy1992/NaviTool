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
/*    */ public final class BrkMsgWarn1
/*    */ {
/*    */   public static final int Msg1 = 1;
/*    */   public static final int Msg2 = 2;
/*    */   public static final int Msg3 = 3;
/*    */   public static final int Msg4 = 4;
/*    */   public static final int Msg5 = 5;
/*    */   public static final int Msg6 = 6;
/*    */   public static final int Msg7 = 7;
/*    */   public static final int NoReq = 0;
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
/*    */         str = "Msg7";
/*    */       case 6:
/*    */         str = "Msg6";
/*    */       case 5:
/*    */         str = "Msg5";
/*    */       case 4:
/*    */         str = "Msg4";
/*    */       case 3:
/*    */         str = "Msg3";
/*    */       case 2:
/*    */         str = "Msg2";
/*    */       case 1:
/*    */         str = "Msg1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\BrkMsgWarn1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */