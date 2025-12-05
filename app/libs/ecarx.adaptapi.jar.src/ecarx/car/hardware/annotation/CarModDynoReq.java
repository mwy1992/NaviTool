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
/*    */ public final class CarModDynoReq
/*    */ {
/*    */   public static final int Cnfrm1 = 1;
/*    */   public static final int Cnfrm2 = 2;
/*    */   public static final int Confg = 3;
/*    */   public static final int Dyno = 4;
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
/*    */       default:
/* 37 */         return str;
/*    */       case 4:
/*    */         str = "Dyno";
/*    */       case 3:
/*    */         str = "Confg";
/*    */       case 2:
/*    */         str = "Cnfrm2";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "Cnfrm1";
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
/* 62 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CarModDynoReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */