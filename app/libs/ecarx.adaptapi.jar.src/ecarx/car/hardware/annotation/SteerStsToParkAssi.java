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
/*    */ public final class SteerStsToParkAssi
/*    */ {
/*    */   public static final int CtrlDifHi = 2;
/*    */   public static final int NormOper = 0;
/*    */   public static final int Spare1 = 6;
/*    */   public static final int Spare2 = 7;
/*    */   public static final int SteerAbortByDrvrIntv = 4;
/*    */   public static final int SteerAbortBySpdHi = 1;
/*    */   public static final int SteerCtrlIntErr = 3;
/*    */   public static final int SteerTqHi = 5;
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
/*    */         str = "Spare2";
/*    */       case 6:
/*    */         str = "Spare1";
/*    */       case 5:
/*    */         str = "SteerTqHi";
/*    */       case 4:
/*    */         str = "SteerAbortByDrvrIntv";
/*    */       case 3:
/*    */         str = "SteerCtrlIntErr";
/*    */       case 2:
/*    */         str = "CtrlDifHi";
/*    */       case 1:
/*    */         str = "SteerAbortBySpdHi";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NormOper";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SteerStsToParkAssi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */