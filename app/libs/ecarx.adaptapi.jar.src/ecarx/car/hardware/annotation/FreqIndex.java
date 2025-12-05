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
/*    */ public final class FreqIndex
/*    */ {
/*    */   public static final int _10_5Hz = 6;
/*    */   public static final int _11_8Hz = 7;
/*    */   public static final int _13Hz = 8;
/*    */   public static final int _5Hz = 1;
/*    */   public static final int _6_34Hz = 2;
/*    */   public static final int _7_2Hz = 3;
/*    */   public static final int _8_3Hz = 4;
/*    */   public static final int _9_73Hz = 5;
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
/*    */       case 8:
/*    */         str = "_13Hz";
/*    */       case 7:
/*    */         str = "_11_8Hz";
/*    */       case 6:
/*    */         str = "_10_5Hz";
/*    */       case 5:
/*    */         str = "_9_73Hz";
/*    */       case 4:
/*    */         str = "_8_3Hz";
/*    */       case 3:
/*    */         str = "_7_2Hz";
/*    */       case 2:
/*    */         str = "_6_34Hz";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "_5Hz";
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
/* 86 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\FreqIndex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */