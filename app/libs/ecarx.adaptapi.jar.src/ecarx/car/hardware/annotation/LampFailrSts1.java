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
/*    */ public final class LampFailrSts1
/*    */ {
/*    */   public static final int BrkAndIndcrTurnAllFailr = 7;
/*    */   public static final int BrkLampAndIndcrTurnLeFailr = 6;
/*    */   public static final int BrkLampAndIndcrTurnRiFailr = 5;
/*    */   public static final int BrkLampFailr = 4;
/*    */   public static final int LampIndcrTurnLeAndRiFailr = 3;
/*    */   public static final int LampIndcrTurnLeFailr = 2;
/*    */   public static final int LampIndcrTurnRiFailr = 1;
/*    */   public static final int LampNoFailr = 0;
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
/*    */         str = "BrkAndIndcrTurnAllFailr";
/*    */       case 6:
/*    */         str = "BrkLampAndIndcrTurnLeFailr";
/*    */       case 5:
/*    */         str = "BrkLampAndIndcrTurnRiFailr";
/*    */       case 4:
/*    */         str = "BrkLampFailr";
/*    */       case 3:
/*    */         str = "LampIndcrTurnLeAndRiFailr";
/*    */       case 2:
/*    */         str = "LampIndcrTurnLeFailr";
/*    */       case 1:
/*    */         str = "LampIndcrTurnRiFailr";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "LampNoFailr";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LampFailrSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */