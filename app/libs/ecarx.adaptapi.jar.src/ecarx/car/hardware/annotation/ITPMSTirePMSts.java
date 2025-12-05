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
/*    */ public final class ITPMSTirePMSts
/*    */ {
/*    */   public static final int CmnWarn = 1;
/*    */   public static final int NoWarn = 0;
/*    */   public static final int SysFailr = 7;
/*    */   public static final int SysUnAvi = 6;
/*    */   public static final int WarnFL = 2;
/*    */   public static final int WarnFR = 3;
/*    */   public static final int WarnRL = 4;
/*    */   public static final int WarnRR = 5;
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
/*    */         str = "SysFailr";
/*    */       case 6:
/*    */         str = "SysUnAvi";
/*    */       case 5:
/*    */         str = "WarnRR";
/*    */       case 4:
/*    */         str = "WarnRL";
/*    */       case 3:
/*    */         str = "WarnFR";
/*    */       case 2:
/*    */         str = "WarnFL";
/*    */       case 1:
/*    */         str = "CmnWarn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ITPMSTirePMSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */