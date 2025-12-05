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
/*    */ public final class PrkgTyp
/*    */ {
/*    */   public static final int Default = 0;
/*    */   public static final int LeftParallel = 2;
/*    */   public static final int LeftPerpendicular = 1;
/*    */   public static final int Reserved2_5 = 5;
/*    */   public static final int Reserved3_6 = 6;
/*    */   public static final int Reserved4_7 = 7;
/*    */   public static final int RightParallel = 4;
/*    */   public static final int RightPerpendicular = 3;
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
/*    */         str = "Reserved4_7";
/*    */       case 6:
/*    */         str = "Reserved3_6";
/*    */       case 5:
/*    */         str = "Reserved2_5";
/*    */       case 4:
/*    */         str = "RightParallel";
/*    */       case 3:
/*    */         str = "RightPerpendicular";
/*    */       case 2:
/*    */         str = "LeftParallel";
/*    */       case 1:
/*    */         str = "LeftPerpendicular";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Default";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */