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
/*    */ public final class HmiCmptmtAirDistbnFrnt
/*    */ {
/*    */   public static final int Aut = 7;
/*    */   public static final int Defrst = 2;
/*    */   public static final int Flr = 0;
/*    */   public static final int FlrDefrst = 3;
/*    */   public static final int FlrVent = 4;
/*    */   public static final int FlrVentDefrst = 6;
/*    */   public static final int Vent = 1;
/*    */   public static final int VentDefrst = 5;
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
/*    */         str = "Aut";
/*    */       case 6:
/*    */         str = "FlrVentDefrst";
/*    */       case 5:
/*    */         str = "VentDefrst";
/*    */       case 4:
/*    */         str = "FlrVent";
/*    */       case 3:
/*    */         str = "FlrDefrst";
/*    */       case 2:
/*    */         str = "Defrst";
/*    */       case 1:
/*    */         str = "Vent";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Flr";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HmiCmptmtAirDistbnFrnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */