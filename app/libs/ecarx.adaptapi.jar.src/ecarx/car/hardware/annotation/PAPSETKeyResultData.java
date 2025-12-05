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
/*    */ public final class PAPSETKeyResultData
/*    */ {
/*    */   public static final int KeyResultMultikeys = 2;
/*    */   public static final int KeyResultNokeyfound = 3;
/*    */   public static final int KeyResultSuccess = 4;
/*    */   public static final int KeyResultTimeout = 1;
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
/*    */       case 4:
/*    */         str = "KeyResultSuccess";
/*    */       case 3:
/*    */         str = "KeyResultNokeyfound";
/*    */       case 2:
/*    */         str = "KeyResultMultikeys";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "KeyResultTimeout";
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
/* 60 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PAPSETKeyResultData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */