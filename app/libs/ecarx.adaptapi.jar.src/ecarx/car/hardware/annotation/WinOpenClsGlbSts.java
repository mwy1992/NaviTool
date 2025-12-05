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
/*    */ public final class WinOpenClsGlbSts
/*    */ {
/*    */   public static final int WinOpenClsGlbReqFromTelm_Close = 2;
/*    */   public static final int WinOpenClsGlbReqFromTelm_Idle = 0;
/*    */   public static final int WinOpenClsGlbReqFromTelm_Open = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 21 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 22 */     switch (paramInt) {
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
/* 33 */         return str;
/*    */       case 2:
/*    */         str = "WinOpenClsGlbReqFromTelm_Close";
/*    */       case 1:
/*    */         str = "WinOpenClsGlbReqFromTelm_Open";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "WinOpenClsGlbReqFromTelm_Idle";
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
/* 54 */     boolean bool = false;
/*    */     
/* 56 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2)
/*    */     {
/*    */       
/* 59 */       bool = true;
/*    */     }
/*    */     
/* 62 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WinOpenClsGlbSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */