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
/*    */ public final class VehEgyCoornActvtMsg
/*    */ {
/*    */   public static final int BattModNotMet = 3;
/*    */   public static final int DestNotSet = 6;
/*    */   public static final int DrvModNotMet = 2;
/*    */   public static final int EngLoSpd = 4;
/*    */   public static final int LossofNegnSig = 5;
/*    */   public static final int NoResponse = 0;
/*    */   public static final int NotInPlanPah = 7;
/*    */   public static final int VehModNotMetNeed = 1;
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
/*    */         str = "NotInPlanPah";
/*    */       case 6:
/*    */         str = "DestNotSet";
/*    */       case 5:
/*    */         str = "LossofNegnSig";
/*    */       case 4:
/*    */         str = "EngLoSpd";
/*    */       case 3:
/*    */         str = "BattModNotMet";
/*    */       case 2:
/*    */         str = "DrvModNotMet";
/*    */       case 1:
/*    */         str = "VehModNotMetNeed";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoResponse";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VehEgyCoornActvtMsg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */