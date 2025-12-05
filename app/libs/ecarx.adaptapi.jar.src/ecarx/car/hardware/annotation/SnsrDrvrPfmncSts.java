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
/*    */ public final class SnsrDrvrPfmncSts
/*    */ {
/*    */   public static final int Sensor_Blkd = 3;
/*    */   public static final int Sensor_Curr = 7;
/*    */   public static final int Sensor_Faulty = 4;
/*    */   public static final int Sensor_Hot = 5;
/*    */   public static final int Sensor_Runng = 2;
/*    */   public static final int Sensor_Shutdown = 1;
/*    */   public static final int Sensor_StrtUp = 0;
/*    */   public static final int Sensor_Vol = 6;
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
/*    */         str = "Sensor_Curr";
/*    */       case 6:
/*    */         str = "Sensor_Vol";
/*    */       case 5:
/*    */         str = "Sensor_Hot";
/*    */       case 4:
/*    */         str = "Sensor_Faulty";
/*    */       case 3:
/*    */         str = "Sensor_Blkd";
/*    */       case 2:
/*    */         str = "Sensor_Runng";
/*    */       case 1:
/*    */         str = "Sensor_Shutdown";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Sensor_StrtUp";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SnsrDrvrPfmncSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */