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
/*    */ public final class ElecAirVentnAvlSts
/*    */ {
/*    */   public static final int Available = 1;
/*    */   public static final int Energylimi = 5;
/*    */   public static final int Error = 3;
/*    */   public static final int Functionallimit = 4;
/*    */   public static final int None = 0;
/*    */   public static final int Unavailable = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 22 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 23 */     switch (paramInt) {
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
/* 43 */         return str;
/*    */       case 5:
/*    */         str = "Energylimi";
/*    */       case 4:
/*    */         str = "Functionallimit";
/*    */       case 3:
/*    */         str = "Error";
/*    */       case 2:
/*    */         str = "Unavailable";
/*    */       case 1:
/*    */         str = "Available";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "None";
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
/* 70 */     boolean bool = false;
/*    */     
/* 72 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 78 */       bool = true;
/*    */     }
/*    */     
/* 81 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ElecAirVentnAvlSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */