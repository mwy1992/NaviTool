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
/*    */ public final class IntrLiGen2RoofReqTyp
/*    */ {
/*    */   public static final int Courtesy = 2;
/*    */   public static final int ForceOff = 6;
/*    */   public static final int ForceOn = 5;
/*    */   public static final int Manual = 3;
/*    */   public static final int Polite = 4;
/*    */   public static final int Unknow = 0;
/*    */   public static final int Welcome = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 26 */     switch (paramInt) {
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
/* 49 */         return str;
/*    */       case 6:
/*    */         str = "ForceOff";
/*    */       case 5:
/*    */         str = "ForceOn";
/*    */       case 4:
/*    */         str = "Polite";
/*    */       case 3:
/*    */         str = "Manual";
/*    */       case 2:
/*    */         str = "Courtesy";
/*    */       case 1:
/*    */         str = "Welcome";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Unknow";
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
/* 78 */     boolean bool = false;
/*    */     
/* 80 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 87 */       bool = true;
/*    */     }
/*    */     
/* 90 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\IntrLiGen2RoofReqTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */