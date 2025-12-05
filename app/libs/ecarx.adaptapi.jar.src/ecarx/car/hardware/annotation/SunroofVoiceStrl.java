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
/*    */ public final class SunroofVoiceStrl
/*    */ {
/*    */   public static final int Close100perc = 6;
/*    */   public static final int Close20perc = 2;
/*    */   public static final int Close50perc = 4;
/*    */   public static final int Idle = 0;
/*    */   public static final int Open100perc = 5;
/*    */   public static final int Open20perc = 1;
/*    */   public static final int Open50perc = 3;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 47 */         return str;
/*    */       case 6:
/*    */         str = "Close100perc";
/*    */       case 5:
/*    */         str = "Open100perc";
/*    */       case 4:
/*    */         str = "Close50perc";
/*    */       case 3:
/*    */         str = "Open50perc";
/*    */       case 2:
/*    */         str = "Close20perc";
/*    */       case 1:
/*    */         str = "Open20perc";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Idle";
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
/* 76 */     boolean bool = false;
/*    */     
/* 78 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 85 */       bool = true;
/*    */     }
/*    */     
/* 88 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SunroofVoiceStrl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */