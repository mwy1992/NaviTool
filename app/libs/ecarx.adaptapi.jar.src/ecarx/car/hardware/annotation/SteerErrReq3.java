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
/*    */ public final class SteerErrReq3
/*    */ {
/*    */   public static final int NoReq = 0;
/*    */   public static final int Spare01 = 5;
/*    */   public static final int Spare02 = 6;
/*    */   public static final int Spare03 = 7;
/*    */   public static final int SteerAssiSrvRqrd = 1;
/*    */   public static final int SteerAssiTmpRedn = 4;
/*    */   public static final int SteerAssiUrgentSrvRqrd = 3;
/*    */   public static final int SteerErrStopSfty = 2;
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
/*    */         str = "Spare03";
/*    */       case 6:
/*    */         str = "Spare02";
/*    */       case 5:
/*    */         str = "Spare01";
/*    */       case 4:
/*    */         str = "SteerAssiTmpRedn";
/*    */       case 3:
/*    */         str = "SteerAssiUrgentSrvRqrd";
/*    */       case 2:
/*    */         str = "SteerErrStopSfty";
/*    */       case 1:
/*    */         str = "SteerAssiSrvRqrd";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoReq";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SteerErrReq3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */