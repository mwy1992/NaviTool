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
/*    */ public final class PasSpeakeralarmfeedback
/*    */ {
/*    */   public static final int BuzzerOff = 0;
/*    */   public static final int BuzzerOn = 1;
/*    */   public static final int BuzzerOnAt2Hz = 3;
/*    */   public static final int BuzzerOnAt4Hz = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 20 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 21 */     switch (paramInt) {
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
/* 35 */         return str;
/*    */       case 3:
/*    */         str = "BuzzerOnAt2Hz";
/*    */       case 2:
/*    */         str = "BuzzerOnAt4Hz";
/*    */       case 1:
/*    */         str = "BuzzerOn";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "BuzzerOff";
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
/* 58 */     boolean bool = false;
/*    */     
/* 60 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3)
/*    */     {
/*    */ 
/*    */       
/* 64 */       bool = true;
/*    */     }
/*    */     
/* 67 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PasSpeakeralarmfeedback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */