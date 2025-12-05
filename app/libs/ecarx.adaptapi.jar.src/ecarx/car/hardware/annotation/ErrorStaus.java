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
/*    */ public final class ErrorStaus
/*    */ {
/*    */   public static final int ErrorSts_HOSWD_CUFault = 3;
/*    */   public static final int ErrorSts_HOSWD_Ready = 2;
/*    */   public static final int ErrorSts_HOSWD_SMFault = 4;
/*    */   public static final int ErrorSts_HOSWD_SVFault = 5;
/*    */   public static final int ErrorSts_Init_Diag = 0;
/*    */   public static final int ErrorSts_Reserved1 = 1;
/*    */   public static final int ErrorSts_Reserved2 = 6;
/*    */   public static final int ErrorSts_Reserved3 = 7;
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
/*    */         str = "ErrorSts_Reserved3";
/*    */       case 6:
/*    */         str = "ErrorSts_Reserved2";
/*    */       case 5:
/*    */         str = "ErrorSts_HOSWD_SVFault";
/*    */       case 4:
/*    */         str = "ErrorSts_HOSWD_SMFault";
/*    */       case 3:
/*    */         str = "ErrorSts_HOSWD_CUFault";
/*    */       case 2:
/*    */         str = "ErrorSts_HOSWD_Ready";
/*    */       case 1:
/*    */         str = "ErrorSts_Reserved1";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ErrorSts_Init_Diag";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ErrorStaus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */