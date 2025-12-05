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
/*    */ public final class RSPAControl
/*    */ {
/*    */   public static final int RSPACtrl_Backward = 2;
/*    */   public static final int RSPACtrl_Exit_Function = 5;
/*    */   public static final int RSPACtrl_Forward = 3;
/*    */   public static final int RSPACtrl_Function_On = 1;
/*    */   public static final int RSPACtrl_Idle = 0;
/*    */   public static final int RSPACtrl_Release_Button = 4;
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
/*    */       default:
/* 45 */         return str;
/*    */       case 5:
/*    */         str = "RSPACtrl_Exit_Function";
/*    */       case 4:
/*    */         str = "RSPACtrl_Release_Button";
/*    */       case 3:
/*    */         str = "RSPACtrl_Forward";
/*    */       case 2:
/*    */         str = "RSPACtrl_Backward";
/*    */       case 1:
/*    */         str = "RSPACtrl_Function_On";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "RSPACtrl_Idle";
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
/* 72 */     boolean bool = false;
/*    */     
/* 74 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 0)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 80 */       bool = true;
/*    */     }
/*    */     
/* 83 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RSPAControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */