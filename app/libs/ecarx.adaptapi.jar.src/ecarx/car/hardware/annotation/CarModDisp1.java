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
/*    */ public final class CarModDisp1
/*    */ {
/*    */   public static final int Crash = 7;
/*    */   public static final int Dyno = 5;
/*    */   public static final int Facy = 1;
/*    */   public static final int FacyStop = 2;
/*    */   public static final int NoDisp = 0;
/*    */   public static final int Norm = 6;
/*    */   public static final int Trnsp = 3;
/*    */   public static final int TrnspStop = 4;
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
/*    */         str = "Crash";
/*    */       case 6:
/*    */         str = "Norm";
/*    */       case 5:
/*    */         str = "Dyno";
/*    */       case 4:
/*    */         str = "TrnspStop";
/*    */       case 3:
/*    */         str = "Trnsp";
/*    */       case 2:
/*    */         str = "FacyStop";
/*    */       case 1:
/*    */         str = "Facy";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoDisp";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CarModDisp1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */