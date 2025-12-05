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
/*    */ public final class SeatClimaTmr
/*    */ {
/*    */   public static final int Continuous = 59;
/*    */   public static final int pre15min = 15;
/*    */   public static final int pre30min = 30;
/*    */   public static final int pre5min = 5;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 20 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 21 */     if (paramInt != 5) { if (paramInt != 15) { if (paramInt != 30) { if (paramInt == 59)
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 32 */             str = "Continuous"; }  } else { str = "pre30min"; }  } else { str = "pre15min"; }
/*    */        }
/*    */     else { str = "pre5min"; }
/* 35 */      return str;
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
/* 58 */     boolean bool = false;
/*    */     
/* 60 */     if (paramInt == 5 || paramInt == 15 || paramInt == 30 || paramInt == 59)
/*    */     {
/*    */ 
/*    */       
/* 64 */       bool = true;
/*    */     }
/*    */     
/* 67 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SeatClimaTmr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */