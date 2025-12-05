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
/*    */ public final class VibrationFltSts
/*    */ {
/*    */   public static final int FltSts_NoFlt = 0;
/*    */   public static final int FltSts_VibrationOpenCirc = 2;
/*    */   public static final int FltSts_VibrationShoCirc = 1;
/*    */   public static final int FltSts_invalid = 3;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 22 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 23 */     switch (paramInt) {
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
/* 37 */         return str;
/*    */       case 3:
/*    */         str = "FltSts_invalid";
/*    */       case 2:
/*    */         str = "FltSts_VibrationOpenCirc";
/*    */       case 1:
/*    */         str = "FltSts_VibrationShoCirc";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "FltSts_NoFlt";
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
/* 60 */     boolean bool = false;
/*    */     
/* 62 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3)
/*    */     {
/*    */ 
/*    */       
/* 66 */       bool = true;
/*    */     }
/*    */     
/* 69 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VibrationFltSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */