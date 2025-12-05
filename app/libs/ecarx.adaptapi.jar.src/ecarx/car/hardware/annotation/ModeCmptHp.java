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
/*    */ public final class ModeCmptHp
/*    */ {
/*    */   public static final int cool = 1;
/*    */   public static final int cool_defog = 4;
/*    */   public static final int cool_hot = 3;
/*    */   public static final int cool_hot_defog = 6;
/*    */   public static final int hot = 2;
/*    */   public static final int hot_defog = 5;
/*    */   public static final int reserved_7 = 7;
/*    */   public static final int vent = 0;
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
/*    */         str = "reserved_7";
/*    */       case 6:
/*    */         str = "cool_hot_defog";
/*    */       case 5:
/*    */         str = "hot_defog";
/*    */       case 4:
/*    */         str = "cool_defog";
/*    */       case 3:
/*    */         str = "cool_hot";
/*    */       case 2:
/*    */         str = "hot";
/*    */       case 1:
/*    */         str = "cool";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "vent";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ModeCmptHp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */