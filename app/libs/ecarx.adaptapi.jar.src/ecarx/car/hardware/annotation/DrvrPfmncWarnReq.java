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
/*    */ public final class DrvrPfmncWarnReq
/*    */ {
/*    */   public static final int Distractive = 3;
/*    */   public static final int NoWarning = 2;
/*    */   public static final int Reserved_6 = 6;
/*    */   public static final int Unavailable = 0;
/*    */   public static final int Unknown = 1;
/*    */   public static final int Warninglevel1 = 4;
/*    */   public static final int Warninglevel2 = 5;
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
/*    */         str = "Reserved_6";
/*    */       case 5:
/*    */         str = "Warninglevel2";
/*    */       case 4:
/*    */         str = "Warninglevel1";
/*    */       case 3:
/*    */         str = "Distractive";
/*    */       case 2:
/*    */         str = "NoWarning";
/*    */       case 1:
/*    */         str = "Unknown";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Unavailable";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvrPfmncWarnReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */