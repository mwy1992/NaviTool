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
/*    */ public final class ADModCtrlInhbn
/*    */ {
/*    */   public static final int AutoParkingModInhb = 2;
/*    */   public static final int L12AndAutoParkingModInhb = 3;
/*    */   public static final int L12LgtCtrlModInhb = 1;
/*    */   public static final int L3ADAndAutoParkingAndL12LgtCtrlModInhb = 7;
/*    */   public static final int L3ADAndAutoParkingModInhb = 6;
/*    */   public static final int L3ADAndL12LgtCtrlModInhb = 5;
/*    */   public static final int L3ADModInhb = 4;
/*    */   public static final int NoInhb = 0;
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
/*    */         str = "L3ADAndAutoParkingAndL12LgtCtrlModInhb";
/*    */       case 6:
/*    */         str = "L3ADAndAutoParkingModInhb";
/*    */       case 5:
/*    */         str = "L3ADAndL12LgtCtrlModInhb";
/*    */       case 4:
/*    */         str = "L3ADModInhb";
/*    */       case 3:
/*    */         str = "L12AndAutoParkingModInhb";
/*    */       case 2:
/*    */         str = "AutoParkingModInhb";
/*    */       case 1:
/*    */         str = "L12LgtCtrlModInhb";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoInhb";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ADModCtrlInhbn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */