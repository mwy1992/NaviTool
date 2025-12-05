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
/*    */ public final class OnBdChrgrHndlSts
/*    */ {
/*    */   public static final int ConnectedWithPower = 3;
/*    */   public static final int ConnectedWithoutPower = 1;
/*    */   public static final int Disconnected = 0;
/*    */   public static final int Fault = 5;
/*    */   public static final int Init = 4;
/*    */   public static final int PowerAvailableButNotActivated = 2;
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
/*    */         str = "Fault";
/*    */       case 4:
/*    */         str = "Init";
/*    */       case 3:
/*    */         str = "ConnectedWithPower";
/*    */       case 2:
/*    */         str = "PowerAvailableButNotActivated";
/*    */       case 1:
/*    */         str = "ConnectedWithoutPower";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Disconnected";
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
/* 74 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\OnBdChrgrHndlSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */