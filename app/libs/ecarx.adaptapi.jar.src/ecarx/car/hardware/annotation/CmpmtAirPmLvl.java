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
/*    */ public final class CmpmtAirPmLvl
/*    */ {
/*    */   public static final int Invalid = 7;
/*    */   public static final int Level1 = 0;
/*    */   public static final int Level2 = 1;
/*    */   public static final int Level3 = 2;
/*    */   public static final int Level4 = 3;
/*    */   public static final int Level5 = 4;
/*    */   public static final int Level6 = 5;
/*    */   public static final int Reserved_6 = 6;
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
/*    */         str = "Invalid";
/*    */       case 6:
/*    */         str = "Reserved_6";
/*    */       case 5:
/*    */         str = "Level6";
/*    */       case 4:
/*    */         str = "Level5";
/*    */       case 3:
/*    */         str = "Level4";
/*    */       case 2:
/*    */         str = "Level3";
/*    */       case 1:
/*    */         str = "Level2";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Level1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CmpmtAirPmLvl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */