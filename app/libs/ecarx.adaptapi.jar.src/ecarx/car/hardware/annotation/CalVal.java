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
/*    */ public final class CalVal
/*    */ {
/*    */   public static final int CalCmplOk = 0;
/*    */   public static final int DiagcTroCodPres = 3;
/*    */   public static final int Resd1 = 4;
/*    */   public static final int Resd2 = 5;
/*    */   public static final int Resd3 = 6;
/*    */   public static final int Resd4 = 7;
/*    */   public static final int SeatNotCal = 1;
/*    */   public static final int ValOutOfRng = 2;
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
/*    */         str = "Resd4";
/*    */       case 6:
/*    */         str = "Resd3";
/*    */       case 5:
/*    */         str = "Resd2";
/*    */       case 4:
/*    */         str = "Resd1";
/*    */       case 3:
/*    */         str = "DiagcTroCodPres";
/*    */       case 2:
/*    */         str = "ValOutOfRng";
/*    */       case 1:
/*    */         str = "SeatNotCal";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "CalCmplOk";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CalVal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */