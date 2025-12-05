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
/*    */ public final class DoorHndlSts
/*    */ {
/*    */   public static final int Flt = 7;
/*    */   public static final int FullDplyd = 4;
/*    */   public static final int FullRtrctd = 1;
/*    */   public static final int MovgIn = 5;
/*    */   public static final int MovgOut = 2;
/*    */   public static final int StopDurgDply = 3;
/*    */   public static final int StopDurgRtrct = 6;
/*    */   public static final int Ukwn = 0;
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
/*    */         str = "Flt";
/*    */       case 6:
/*    */         str = "StopDurgRtrct";
/*    */       case 5:
/*    */         str = "MovgIn";
/*    */       case 4:
/*    */         str = "FullDplyd";
/*    */       case 3:
/*    */         str = "StopDurgDply";
/*    */       case 2:
/*    */         str = "MovgOut";
/*    */       case 1:
/*    */         str = "FullRtrctd";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Ukwn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DoorHndlSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */