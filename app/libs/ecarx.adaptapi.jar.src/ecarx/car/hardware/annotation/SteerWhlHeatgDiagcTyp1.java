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
/*    */ public final class SteerWhlHeatgDiagcTyp1
/*    */ {
/*    */   public static final int CmnFailr = 1;
/*    */   public static final int EdgeSho = 3;
/*    */   public static final int FltPwrSplyErr = 5;
/*    */   public static final int FltSwtHiSide = 6;
/*    */   public static final int NotEdgePres = 2;
/*    */   public static final int OK = 0;
/*    */   public static final int SigFailr = 7;
/*    */   public static final int SnsrFltT = 4;
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
/*    */         str = "SigFailr";
/*    */       case 6:
/*    */         str = "FltSwtHiSide";
/*    */       case 5:
/*    */         str = "FltPwrSplyErr";
/*    */       case 4:
/*    */         str = "SnsrFltT";
/*    */       case 3:
/*    */         str = "EdgeSho";
/*    */       case 2:
/*    */         str = "NotEdgePres";
/*    */       case 1:
/*    */         str = "CmnFailr";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "OK";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SteerWhlHeatgDiagcTyp1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */