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
/*    */ public final class TypOfObjFrnt1
/*    */ {
/*    */   public static final int Animal = 4;
/*    */   public static final int Bikecycle = 3;
/*    */   public static final int Bus = 6;
/*    */   public static final int Car = 1;
/*    */   public static final int Motocycle = 5;
/*    */   public static final int NoDisplay = 0;
/*    */   public static final int Pedestrian = 2;
/*    */   public static final int Truck = 7;
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
/*    */         str = "Truck";
/*    */       case 6:
/*    */         str = "Bus";
/*    */       case 5:
/*    */         str = "Motocycle";
/*    */       case 4:
/*    */         str = "Animal";
/*    */       case 3:
/*    */         str = "Bikecycle";
/*    */       case 2:
/*    */         str = "Pedestrian";
/*    */       case 1:
/*    */         str = "Car";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoDisplay";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TypOfObjFrnt1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */