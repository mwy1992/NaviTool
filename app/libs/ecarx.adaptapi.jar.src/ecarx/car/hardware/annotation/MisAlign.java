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
/*    */ public final class MisAlign
/*    */ {
/*    */   public static final int AutoCalibrateFail_CauseMisalignmentDegreeIsLargerThanThresholdOrOtherReason = 5;
/*    */   public static final int CalibrationNotStart = 0;
/*    */   public static final int CanNotBeCalibratedDynamicallyCauseOtherReason = 7;
/*    */   public static final int CanNotBeCalibratedStaticallyCauseOtherReason = 4;
/*    */   public static final int MisalignmentDegreeIsLargerThanThreshold_DynamicCalibrationFailInFactoryOrAftersales = 6;
/*    */   public static final int MisalignmentDegreeIsLargerThanThreshold_StaticCalibrationFail = 3;
/*    */   public static final int SuccessfullyAutoCalibrated = 2;
/*    */   public static final int SuccessfullyCalibratedInFactoryOrAftersales = 1;
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
/*    */         str = "CanNotBeCalibratedDynamicallyCauseOtherReason";
/*    */       case 6:
/*    */         str = "MisalignmentDegreeIsLargerThanThreshold_DynamicCalibrationFailInFactoryOrAftersales";
/*    */       case 5:
/*    */         str = "AutoCalibrateFail_CauseMisalignmentDegreeIsLargerThanThresholdOrOtherReason";
/*    */       case 4:
/*    */         str = "CanNotBeCalibratedStaticallyCauseOtherReason";
/*    */       case 3:
/*    */         str = "MisalignmentDegreeIsLargerThanThreshold_StaticCalibrationFail";
/*    */       case 2:
/*    */         str = "SuccessfullyAutoCalibrated";
/*    */       case 1:
/*    */         str = "SuccessfullyCalibratedInFactoryOrAftersales";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "CalibrationNotStart";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MisAlign.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */