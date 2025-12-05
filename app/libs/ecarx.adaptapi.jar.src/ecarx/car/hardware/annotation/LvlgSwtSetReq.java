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
/*    */ public final class LvlgSwtSetReq
/*    */ {
/*    */   public static final int Level0 = 0;
/*    */   public static final int Level1 = 1;
/*    */   public static final int Level2 = 2;
/*    */   public static final int Level3 = 3;
/*    */   public static final int Level4 = 4;
/*    */   public static final int Level5 = 5;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 43 */         return str;
/*    */       case 5:
/*    */         str = "Level5";
/*    */       case 4:
/*    */         str = "Level4";
/*    */       case 3:
/*    */         str = "Level3";
/*    */       case 2:
/*    */         str = "Level2";
/*    */       case 1:
/*    */         str = "Level1";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Level0";
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
/* 70 */     boolean bool = false;
/*    */     
/* 72 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 78 */       bool = true;
/*    */     }
/*    */     
/* 81 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LvlgSwtSetReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */