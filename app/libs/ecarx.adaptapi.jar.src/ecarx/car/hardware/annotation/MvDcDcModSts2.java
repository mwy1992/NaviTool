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
/*    */ public final class MvDcDcModSts2
/*    */ {
/*    */   public static final int AutoMod = 5;
/*    */   public static final int Derating = 4;
/*    */   public static final int Fwd = 1;
/*    */   public static final int IninInProgs = 2;
/*    */   public static final int Invalid = 6;
/*    */   public static final int ShutDownInProgs = 3;
/*    */   public static final int StdBy = 0;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 26 */     switch (paramInt) {
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
/* 49 */         return str;
/*    */       case 6:
/*    */         str = "Invalid";
/*    */       case 5:
/*    */         str = "AutoMod";
/*    */       case 4:
/*    */         str = "Derating";
/*    */       case 3:
/*    */         str = "ShutDownInProgs";
/*    */       case 2:
/*    */         str = "IninInProgs";
/*    */       case 1:
/*    */         str = "Fwd";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "StdBy";
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
/* 78 */     boolean bool = false;
/*    */     
/* 80 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 87 */       bool = true;
/*    */     }
/*    */     
/* 90 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MvDcDcModSts2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */