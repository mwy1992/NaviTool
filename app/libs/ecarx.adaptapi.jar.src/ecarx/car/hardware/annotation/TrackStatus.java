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
/*    */ public final class TrackStatus
/*    */ {
/*    */   public static final int CLOSE_RANGE_PREDICTED_MARKING = 2;
/*    */   public static final int FAR_RANGE_PREDICTED_MARKING = 3;
/*    */   public static final int NO_MARKING_DETECTED = 0;
/*    */   public static final int PREDICTED_MARKING = 4;
/*    */   public static final int TRACKED_DETECTED_MARKING = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     switch (paramInt) {
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
/* 41 */         return str;
/*    */       case 4:
/*    */         str = "PREDICTED_MARKING";
/*    */       case 3:
/*    */         str = "FAR_RANGE_PREDICTED_MARKING";
/*    */       case 2:
/*    */         str = "CLOSE_RANGE_PREDICTED_MARKING";
/*    */       case 1:
/*    */         str = "TRACKED_DETECTED_MARKING";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NO_MARKING_DETECTED";
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
/* 66 */     boolean bool = false;
/*    */     
/* 68 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 73 */       bool = true;
/*    */     }
/*    */     
/* 76 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TrackStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */