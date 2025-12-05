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
/*    */ public final class TrsmSts
/*    */ {
/*    */   public static final int Failure = 7;
/*    */   public static final int Initialization = 1;
/*    */   public static final int Invalid = 6;
/*    */   public static final int LimpHome = 5;
/*    */   public static final int ReadyRun = 2;
/*    */   public static final int Reserved_3 = 3;
/*    */   public static final int ShutDown = 4;
/*    */   public static final int Sleep = 0;
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
/*    */         str = "Failure";
/*    */       case 6:
/*    */         str = "Invalid";
/*    */       case 5:
/*    */         str = "LimpHome";
/*    */       case 4:
/*    */         str = "ShutDown";
/*    */       case 3:
/*    */         str = "Reserved_3";
/*    */       case 2:
/*    */         str = "ReadyRun";
/*    */       case 1:
/*    */         str = "Initialization";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Sleep";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TrsmSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */