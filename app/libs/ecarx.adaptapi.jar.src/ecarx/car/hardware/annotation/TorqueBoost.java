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
/*    */ public final class TorqueBoost
/*    */ {
/*    */   public static final int BoostMode0 = 4;
/*    */   public static final int BoostMode1 = 5;
/*    */   public static final int TorqueMode0 = 0;
/*    */   public static final int TorqueMode1 = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 22 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 23 */     if (paramInt != 0) { if (paramInt != 2) { switch (paramInt) {
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
/*    */           default:
/* 37 */             return str;
/*    */           case 5:
/*    */             str = "BoostMode1";
/*    */           case 4:
/*    */             break;
/*    */         } 
/*    */         str = "BoostMode0"; }
/*    */       
/*    */       str = "TorqueMode1"; }
/*    */     
/*    */     str = "TorqueMode0";
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
/* 60 */     boolean bool = false;
/*    */     
/* 62 */     if (paramInt == 0 || paramInt == 2 || paramInt == 4 || paramInt == 5)
/*    */     {
/*    */ 
/*    */       
/* 66 */       bool = true;
/*    */     }
/*    */     
/* 69 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TorqueBoost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */