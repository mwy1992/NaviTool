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
/*    */ public final class CSDThemeColor
/*    */ {
/*    */   public static final int ThemeColor1 = 1;
/*    */   public static final int ThemeColor2 = 2;
/*    */   public static final int ThemeColor3 = 3;
/*    */   public static final int ThemeColor4 = 4;
/*    */   public static final int ThemeColor5 = 5;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 21 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 22 */     switch (paramInt) {
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
/* 39 */         return str;
/*    */       case 5:
/*    */         str = "ThemeColor5";
/*    */       case 4:
/*    */         str = "ThemeColor4";
/*    */       case 3:
/*    */         str = "ThemeColor3";
/*    */       case 2:
/*    */         str = "ThemeColor2";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "ThemeColor1";
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
/* 64 */     boolean bool = false;
/*    */     
/* 66 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 71 */       bool = true;
/*    */     }
/*    */     
/* 74 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CSDThemeColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */