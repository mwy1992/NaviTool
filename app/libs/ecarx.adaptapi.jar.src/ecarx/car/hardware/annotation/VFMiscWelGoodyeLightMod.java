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
/*    */ public final class VFMiscWelGoodyeLightMod
/*    */ {
/*    */   public static final int Mode1 = 1;
/*    */   public static final int Mode2 = 2;
/*    */   public static final int Mode3 = 3;
/*    */   public static final int Mode4 = 4;
/*    */   public static final int Mode5 = 5;
/*    */   public static final int Mode6 = 6;
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
/*    */       case 6:
/*    */         str = "Mode6";
/*    */       case 5:
/*    */         str = "Mode5";
/*    */       case 4:
/*    */         str = "Mode4";
/*    */       case 3:
/*    */         str = "Mode3";
/*    */       case 2:
/*    */         str = "Mode2";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "Mode1";
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
/* 72 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VFMiscWelGoodyeLightMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */