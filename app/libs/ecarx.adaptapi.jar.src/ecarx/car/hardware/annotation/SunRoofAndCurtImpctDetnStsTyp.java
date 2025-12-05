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
/*    */ public final class SunRoofAndCurtImpctDetnStsTyp
/*    */ {
/*    */   public static final int ClsBlk = 3;
/*    */   public static final int ClsPinch = 2;
/*    */   public static final int ImpctDetnDi = 0;
/*    */   public static final int ImpctDetnEna = 1;
/*    */   public static final int OpenBlk = 5;
/*    */   public static final int OpenPinch = 4;
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
/*    */         str = "OpenBlk";
/*    */       case 4:
/*    */         str = "OpenPinch";
/*    */       case 3:
/*    */         str = "ClsBlk";
/*    */       case 2:
/*    */         str = "ClsPinch";
/*    */       case 1:
/*    */         str = "ImpctDetnEna";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ImpctDetnDi";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SunRoofAndCurtImpctDetnStsTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */