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
/*    */ public final class SapParkingprocesssts
/*    */ {
/*    */   public static final int ClearDTextDispFeedback = 0;
/*    */   public static final int ParkingFinished = 3;
/*    */   public static final int ParkingSpaceSearched = 1;
/*    */   public static final int ParkingSpaceSelected = 2;
/*    */   public static final int SearchingParkingSpace = 8;
/*    */   public static final int Speed = 5;
/*    */   public static final int UndoProcessTextDisp = 9;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     switch (paramInt) {
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
/* 47 */         return str;
/*    */       case 9:
/*    */         str = "UndoProcessTextDisp";
/*    */       case 8:
/*    */         str = "SearchingParkingSpace";
/*    */       case 5:
/*    */         str = "Speed";
/*    */       case 3:
/*    */         str = "ParkingFinished";
/*    */       case 2:
/*    */         str = "ParkingSpaceSelected";
/*    */       case 1:
/*    */         str = "ParkingSpaceSearched";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ClearDTextDispFeedback";
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
/* 76 */     boolean bool = false;
/*    */     
/* 78 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 5 || paramInt == 8 || paramInt == 9)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 85 */       bool = true;
/*    */     }
/*    */     
/* 88 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SapParkingprocesssts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */