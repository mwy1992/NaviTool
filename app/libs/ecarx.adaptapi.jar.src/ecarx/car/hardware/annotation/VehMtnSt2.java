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
/*    */ public final class VehMtnSt2
/*    */ {
/*    */   public static final int RollgBackwVal1 = 6;
/*    */   public static final int RollgBackwVal2 = 7;
/*    */   public static final int RollgFwdVal1 = 4;
/*    */   public static final int RollgFwdVal2 = 5;
/*    */   public static final int StandStillVal1 = 1;
/*    */   public static final int StandStillVal2 = 2;
/*    */   public static final int StandStillVal3 = 3;
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
/*    */         str = "RollgBackwVal2";
/*    */       case 6:
/*    */         str = "RollgBackwVal1";
/*    */       case 5:
/*    */         str = "RollgFwdVal2";
/*    */       case 4:
/*    */         str = "RollgFwdVal1";
/*    */       case 3:
/*    */         str = "StandStillVal3";
/*    */       case 2:
/*    */         str = "StandStillVal2";
/*    */       case 1:
/*    */         str = "StandStillVal1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VehMtnSt2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */