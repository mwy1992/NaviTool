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
/*    */ public final class CmptmtCoolgSts
/*    */ {
/*    */   public static final int OffByAmbTOutOfRng = 3;
/*    */   public static final int OffByEvaprTLo = 1;
/*    */   public static final int OffByLoadCut = 5;
/*    */   public static final int OffByPLo = 2;
/*    */   public static final int OffBySysFailr = 4;
/*    */   public static final int OffNoReq = 0;
/*    */   public static final int On = 7;
/*    */   public static final int OnWithBattCoolg = 6;
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
/*    */         str = "On";
/*    */       case 6:
/*    */         str = "OnWithBattCoolg";
/*    */       case 5:
/*    */         str = "OffByLoadCut";
/*    */       case 4:
/*    */         str = "OffBySysFailr";
/*    */       case 3:
/*    */         str = "OffByAmbTOutOfRng";
/*    */       case 2:
/*    */         str = "OffByPLo";
/*    */       case 1:
/*    */         str = "OffByEvaprTLo";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "OffNoReq";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CmptmtCoolgSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */