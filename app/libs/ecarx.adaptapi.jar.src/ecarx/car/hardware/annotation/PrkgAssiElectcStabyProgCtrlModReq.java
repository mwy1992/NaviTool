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
/*    */ public final class PrkgAssiElectcStabyProgCtrlModReq
/*    */ {
/*    */   public static final int PASElectcStabyProgCtrlMod_APARequest = 1;
/*    */   public static final int PASElectcStabyProgCtrlMod_APAcontrolactive = 4;
/*    */   public static final int PASElectcStabyProgCtrlMod_HPAcontrolactive = 6;
/*    */   public static final int PASElectcStabyProgCtrlMod_HPArequest = 3;
/*    */   public static final int PASElectcStabyProgCtrlMod_NoRequest = 0;
/*    */   public static final int PASElectcStabyProgCtrlMod_RPAcontrolactive = 5;
/*    */   public static final int PASElectcStabyProgCtrlMod_RPArequest = 2;
/*    */   public static final int PASElectcStabyProgCtrlMod_Reserved2 = 7;
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
/*    */         str = "PASElectcStabyProgCtrlMod_Reserved2";
/*    */       case 6:
/*    */         str = "PASElectcStabyProgCtrlMod_HPAcontrolactive";
/*    */       case 5:
/*    */         str = "PASElectcStabyProgCtrlMod_RPAcontrolactive";
/*    */       case 4:
/*    */         str = "PASElectcStabyProgCtrlMod_APAcontrolactive";
/*    */       case 3:
/*    */         str = "PASElectcStabyProgCtrlMod_HPArequest";
/*    */       case 2:
/*    */         str = "PASElectcStabyProgCtrlMod_RPArequest";
/*    */       case 1:
/*    */         str = "PASElectcStabyProgCtrlMod_APARequest";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "PASElectcStabyProgCtrlMod_NoRequest";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgAssiElectcStabyProgCtrlModReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */