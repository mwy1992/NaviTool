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
/*    */ public final class SteerMod
/*    */ {
/*    */   public static final int Mod1 = 1;
/*    */   public static final int Mod2 = 2;
/*    */   public static final int Mod3 = 3;
/*    */   public static final int Mod4 = 4;
/*    */   public static final int Resd5 = 5;
/*    */   public static final int Resd6 = 6;
/*    */   public static final int Resd7 = 7;
/*    */   public static final int Ukwn = 0;
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
/*    */         str = "Resd7";
/*    */       case 6:
/*    */         str = "Resd6";
/*    */       case 5:
/*    */         str = "Resd5";
/*    */       case 4:
/*    */         str = "Mod4";
/*    */       case 3:
/*    */         str = "Mod3";
/*    */       case 2:
/*    */         str = "Mod2";
/*    */       case 1:
/*    */         str = "Mod1";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Ukwn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SteerMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */