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
/*    */ public final class StandStillMgrStsForHld1
/*    */ {
/*    */   public static final int StandStillMgrStsForHldVal0 = 0;
/*    */   public static final int StandStillMgrStsForHldVal1 = 1;
/*    */   public static final int StandStillMgrStsForHldVal2 = 2;
/*    */   public static final int StandStillMgrStsForHldVal3 = 3;
/*    */   public static final int StandStillMgrStsForHldVal4 = 4;
/*    */   public static final int StandStillMgrStsForHldVal5 = 5;
/*    */   public static final int StandStillMgrStsForHldVal6 = 6;
/*    */   public static final int StandStillMgrStsForHldVal7 = 7;
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
/*    */         str = "StandStillMgrStsForHldVal7";
/*    */       case 6:
/*    */         str = "StandStillMgrStsForHldVal6";
/*    */       case 5:
/*    */         str = "StandStillMgrStsForHldVal5";
/*    */       case 4:
/*    */         str = "StandStillMgrStsForHldVal4";
/*    */       case 3:
/*    */         str = "StandStillMgrStsForHldVal3";
/*    */       case 2:
/*    */         str = "StandStillMgrStsForHldVal2";
/*    */       case 1:
/*    */         str = "StandStillMgrStsForHldVal1";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "StandStillMgrStsForHldVal0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\StandStillMgrStsForHld1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */