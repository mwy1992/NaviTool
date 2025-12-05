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
/*    */ public final class MsgReqForDK
/*    */ {
/*    */   public static final int Deleted = 6;
/*    */   public static final int MinsLeftToEndTi15 = 3;
/*    */   public static final int MinsLeftToEndTi30 = 2;
/*    */   public static final int TiExpired = 4;
/*    */   public static final int WarnDelDK = 5;
/*    */   public static final int idle = 1;
/*    */   public static final int resd = 7;
/*    */   public static final int resd2 = 8;
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
/*    */       case 8:
/*    */         str = "resd2";
/*    */       case 7:
/*    */         str = "resd";
/*    */       case 6:
/*    */         str = "Deleted";
/*    */       case 5:
/*    */         str = "WarnDelDK";
/*    */       case 4:
/*    */         str = "TiExpired";
/*    */       case 3:
/*    */         str = "MinsLeftToEndTi15";
/*    */       case 2:
/*    */         str = "MinsLeftToEndTi30";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "idle";
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
/* 86 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MsgReqForDK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */