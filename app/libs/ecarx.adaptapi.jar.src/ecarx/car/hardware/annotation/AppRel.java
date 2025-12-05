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
/*    */ public final class AppRel
/*    */ {
/*    */   public static final int Applied = 0;
/*    */   public static final int Applying = 2;
/*    */   public static final int CompletelyReleased = 6;
/*    */   public static final int HapPrepared = 7;
/*    */   public static final int HoldApplied = 5;
/*    */   public static final int Released = 1;
/*    */   public static final int Releasing = 3;
/*    */   public static final int Unknown = 4;
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
/*    */         str = "HapPrepared";
/*    */       case 6:
/*    */         str = "CompletelyReleased";
/*    */       case 5:
/*    */         str = "HoldApplied";
/*    */       case 4:
/*    */         str = "Unknown";
/*    */       case 3:
/*    */         str = "Releasing";
/*    */       case 2:
/*    */         str = "Applying";
/*    */       case 1:
/*    */         str = "Released";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Applied";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AppRel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */