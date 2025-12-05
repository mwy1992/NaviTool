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
/*    */ public final class PtTrsmModReq
/*    */ {
/*    */   public static final int Engd = 1;
/*    */   public static final int EngdEco = 2;
/*    */   public static final int EngdWithPMax = 0;
/*    */   public static final int Neut = 4;
/*    */   public static final int NeutEco = 5;
/*    */   public static final int Resd1 = 3;
/*    */   public static final int Tran = 6;
/*    */   public static final int TranWithTqCpChg = 7;
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
/*    */         str = "TranWithTqCpChg";
/*    */       case 6:
/*    */         str = "Tran";
/*    */       case 5:
/*    */         str = "NeutEco";
/*    */       case 4:
/*    */         str = "Neut";
/*    */       case 3:
/*    */         str = "Resd1";
/*    */       case 2:
/*    */         str = "EngdEco";
/*    */       case 1:
/*    */         str = "Engd";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "EngdWithPMax";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PtTrsmModReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */