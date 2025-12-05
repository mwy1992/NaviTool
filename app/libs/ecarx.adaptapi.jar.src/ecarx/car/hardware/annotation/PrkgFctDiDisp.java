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
/*    */ public final class PrkgFctDiDisp
/*    */ {
/*    */   public static final int FunctionConflictParkingDisable = 2;
/*    */   public static final int GradientOverRangeParkingDisable = 5;
/*    */   public static final int HeavyRainParkingDisable = 4;
/*    */   public static final int RVCMsystemFailureParkingDisable = 6;
/*    */   public static final int SpeedOver20kmhParkingDisable = 3;
/*    */   public static final int SystemFaultParkingDisable = 1;
/*    */   public static final int SystemIsNormal = 0;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 26 */     switch (paramInt) {
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
/* 49 */         return str;
/*    */       case 6:
/*    */         str = "RVCMsystemFailureParkingDisable";
/*    */       case 5:
/*    */         str = "GradientOverRangeParkingDisable";
/*    */       case 4:
/*    */         str = "HeavyRainParkingDisable";
/*    */       case 3:
/*    */         str = "SpeedOver20kmhParkingDisable";
/*    */       case 2:
/*    */         str = "FunctionConflictParkingDisable";
/*    */       case 1:
/*    */         str = "SystemFaultParkingDisable";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "SystemIsNormal";
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
/* 78 */     boolean bool = false;
/*    */     
/* 80 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 87 */       bool = true;
/*    */     }
/*    */     
/* 90 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgFctDiDisp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */