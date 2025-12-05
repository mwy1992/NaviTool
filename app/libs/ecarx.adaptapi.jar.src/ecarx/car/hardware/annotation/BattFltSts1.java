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
/*    */ public final class BattFltSts1
/*    */ {
/*    */   public static final int HiTFlt = 3;
/*    */   public static final int NoFlt = 0;
/*    */   public static final int OvFlt = 1;
/*    */   public static final int Spare1 = 4;
/*    */   public static final int Spare2 = 5;
/*    */   public static final int Spare3 = 6;
/*    */   public static final int Spare4 = 7;
/*    */   public static final int UvFlt = 2;
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
/*    */         str = "Spare4";
/*    */       case 6:
/*    */         str = "Spare3";
/*    */       case 5:
/*    */         str = "Spare2";
/*    */       case 4:
/*    */         str = "Spare1";
/*    */       case 3:
/*    */         str = "HiTFlt";
/*    */       case 2:
/*    */         str = "UvFlt";
/*    */       case 1:
/*    */         str = "OvFlt";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoFlt";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\BattFltSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */