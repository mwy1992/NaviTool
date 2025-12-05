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
/*    */ public final class EngHybSts1
/*    */ {
/*    */   public static final int EngMntn = 3;
/*    */   public static final int FuOutOfDateFStrtOfEngGslToCnse = 2;
/*    */   public static final int FuOutOfDateRefu = 0;
/*    */   public static final int FuOutOfDateStrtOfEngGsl = 1;
/*    */   public static final int Spare = 4;
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
/*    */         str = "Spare";
/*    */       case 3:
/*    */         str = "EngMntn";
/*    */       case 2:
/*    */         str = "FuOutOfDateFStrtOfEngGslToCnse";
/*    */       case 1:
/*    */         str = "FuOutOfDateStrtOfEngGsl";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "FuOutOfDateRefu";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\EngHybSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */