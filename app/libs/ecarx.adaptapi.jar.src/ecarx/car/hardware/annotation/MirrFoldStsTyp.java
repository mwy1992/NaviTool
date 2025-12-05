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
/*    */ public final class MirrFoldStsTyp
/*    */ {
/*    */   public static final int MirrFoldPosn = 2;
/*    */   public static final int MirrFoldPosnUndefd = 0;
/*    */   public static final int MirrMovgToFold = 4;
/*    */   public static final int MirrMovgToNotFold = 3;
/*    */   public static final int MirrNotFoldPosn = 1;
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
/*    */       case 4:
/*    */         str = "MirrMovgToFold";
/*    */       case 3:
/*    */         str = "MirrMovgToNotFold";
/*    */       case 2:
/*    */         str = "MirrFoldPosn";
/*    */       case 1:
/*    */         str = "MirrNotFoldPosn";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "MirrFoldPosnUndefd";
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
/* 68 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MirrFoldStsTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */