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
/*    */ public final class PrkgImgDispReq
/*    */ {
/*    */   public static final int DisplayAPA = 2;
/*    */   public static final int DisplayAVP = 6;
/*    */   public static final int DisplayHPP = 5;
/*    */   public static final int DisplayRPA = 3;
/*    */   public static final int DisplayRPAPlus = 4;
/*    */   public static final int DisplayRSPA = 1;
/*    */   public static final int NotDisplay = 0;
/*    */   public static final int Reserved1_7 = 7;
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
/*    */         str = "Reserved1_7";
/*    */       case 6:
/*    */         str = "DisplayAVP";
/*    */       case 5:
/*    */         str = "DisplayHPP";
/*    */       case 4:
/*    */         str = "DisplayRPAPlus";
/*    */       case 3:
/*    */         str = "DisplayRPA";
/*    */       case 2:
/*    */         str = "DisplayAPA";
/*    */       case 1:
/*    */         str = "DisplayRSPA";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NotDisplay";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgImgDispReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */