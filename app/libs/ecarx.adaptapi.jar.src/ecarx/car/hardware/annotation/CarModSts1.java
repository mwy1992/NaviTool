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
/*    */ public final class CarModSts1
/*    */ {
/*    */   public static final int CarModCrash = 3;
/*    */   public static final int CarModDyno = 5;
/*    */   public static final int CarModFcy = 2;
/*    */   public static final int CarModNorm = 0;
/*    */   public static final int CarModTrnsp = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     if (paramInt != 5) { switch (paramInt) {
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
/*    */         default:
/* 41 */           return str;
/*    */         case 3:
/*    */           str = "CarModCrash";
/*    */         case 2:
/*    */           str = "CarModFcy";
/*    */         case 1:
/*    */           str = "CarModTrnsp";
/*    */         case 0:
/*    */           break;
/*    */       } 
/*    */       str = "CarModNorm"; }
/*    */     
/*    */     str = "CarModDyno";
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
/* 66 */     boolean bool = false;
/*    */     
/* 68 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 5)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 73 */       bool = true;
/*    */     }
/*    */     
/* 76 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CarModSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */