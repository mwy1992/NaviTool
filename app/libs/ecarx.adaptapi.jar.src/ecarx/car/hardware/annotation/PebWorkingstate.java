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
/*    */ public final class PebWorkingstate
/*    */ {
/*    */   public static final int Failure = 3;
/*    */   public static final int Inactivate = 2;
/*    */   public static final int Inhibited = 4;
/*    */   public static final int Initialze = 7;
/*    */   public static final int MSPActivate = 6;
/*    */   public static final int Off = 0;
/*    */   public static final int PEBActivate = 5;
/*    */   public static final int Standby = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 24 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 25 */     switch (paramInt) {
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
/* 51 */         return str;
/*    */       case 7:
/*    */         str = "Initialze";
/*    */       case 6:
/*    */         str = "MSPActivate";
/*    */       case 5:
/*    */         str = "PEBActivate";
/*    */       case 4:
/*    */         str = "Inhibited";
/*    */       case 3:
/*    */         str = "Failure";
/*    */       case 2:
/*    */         str = "Inactivate";
/*    */       case 1:
/*    */         str = "Standby";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Off";
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
/* 82 */     boolean bool = false;
/*    */     
/* 84 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 92 */       bool = true;
/*    */     }
/*    */     
/* 95 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PebWorkingstate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */