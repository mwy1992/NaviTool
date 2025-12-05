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
/*    */ public final class AsyEmgyLaneWarn
/*    */ {
/*    */   public static final int ClosedByUser = 5;
/*    */   public static final int NoTrfcJamDriving = 3;
/*    */   public static final int NoTrfcJamParking = 4;
/*    */   public static final int NoWarn = 0;
/*    */   public static final int Reserved1_2 = 2;
/*    */   public static final int Reserved2_6 = 6;
/*    */   public static final int Reserved3_7 = 7;
/*    */   public static final int TrfcJamOccupying = 1;
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
/*    */         str = "Reserved3_7";
/*    */       case 6:
/*    */         str = "Reserved2_6";
/*    */       case 5:
/*    */         str = "ClosedByUser";
/*    */       case 4:
/*    */         str = "NoTrfcJamParking";
/*    */       case 3:
/*    */         str = "NoTrfcJamDriving";
/*    */       case 2:
/*    */         str = "Reserved1_2";
/*    */       case 1:
/*    */         str = "TrfcJamOccupying";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoWarn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AsyEmgyLaneWarn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */