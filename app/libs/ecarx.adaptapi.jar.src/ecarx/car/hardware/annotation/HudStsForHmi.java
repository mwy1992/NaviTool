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
/*    */ public final class HudStsForHmi
/*    */ {
/*    */   public static final int HudStsAvl = 0;
/*    */   public static final int HudStsCalMod = 1;
/*    */   public static final int HudStsErr = 3;
/*    */   public static final int HudStsTmpNotAvl = 2;
/*    */   public static final int Resd1 = 4;
/*    */   public static final int Resd2 = 5;
/*    */   public static final int Resd3 = 6;
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
/*    */         str = "Resd3";
/*    */       case 5:
/*    */         str = "Resd2";
/*    */       case 4:
/*    */         str = "Resd1";
/*    */       case 3:
/*    */         str = "HudStsErr";
/*    */       case 2:
/*    */         str = "HudStsTmpNotAvl";
/*    */       case 1:
/*    */         str = "HudStsCalMod";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "HudStsAvl";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HudStsForHmi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */