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
/*    */ public final class SeatOffsCalResp1
/*    */ {
/*    */   public static final int CalCmplOk = 8;
/*    */   public static final int DiagcTroCodPres = 6;
/*    */   public static final int PFluc = 2;
/*    */   public static final int POutOfRng = 1;
/*    */   public static final int SeatNotCal = 4;
/*    */   public static final int TOutOfRng = 7;
/*    */   public static final int ULo = 3;
/*    */   public static final int WaitSec10ForNewCal = 5;
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
/*    */       case 8:
/*    */         str = "CalCmplOk";
/*    */       case 7:
/*    */         str = "TOutOfRng";
/*    */       case 6:
/*    */         str = "DiagcTroCodPres";
/*    */       case 5:
/*    */         str = "WaitSec10ForNewCal";
/*    */       case 4:
/*    */         str = "SeatNotCal";
/*    */       case 3:
/*    */         str = "ULo";
/*    */       case 2:
/*    */         str = "PFluc";
/*    */       case 1:
/*    */         break;
/*    */     } 
/*    */     str = "POutOfRng";
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
/* 86 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SeatOffsCalResp1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */