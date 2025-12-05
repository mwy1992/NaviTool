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
/*    */ public final class PrkLatLgtFail
/*    */ {
/*    */   public static final int BrakeFailure = 2;
/*    */   public static final int CommunicationFailure = 5;
/*    */   public static final int NoFailure = 0;
/*    */   public static final int PropulsionFailure = 3;
/*    */   public static final int RBUFailure = 4;
/*    */   public static final int RWSFailure = 7;
/*    */   public static final int SteeringFailure = 1;
/*    */   public static final int VDSWInternalFailure = 6;
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
/*    */         str = "RWSFailure";
/*    */       case 6:
/*    */         str = "VDSWInternalFailure";
/*    */       case 5:
/*    */         str = "CommunicationFailure";
/*    */       case 4:
/*    */         str = "RBUFailure";
/*    */       case 3:
/*    */         str = "PropulsionFailure";
/*    */       case 2:
/*    */         str = "BrakeFailure";
/*    */       case 1:
/*    */         str = "SteeringFailure";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoFailure";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkLatLgtFail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */