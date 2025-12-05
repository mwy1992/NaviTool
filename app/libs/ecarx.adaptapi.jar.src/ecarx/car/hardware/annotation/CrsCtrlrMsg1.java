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
/*    */ public final class CrsCtrlrMsg1
/*    */ {
/*    */   public static final int BrkOvrheatd = 7;
/*    */   public static final int CrsCtrlrCncl = 1;
/*    */   public static final int CrsCtrlrCnclSpdLoLimExcdd = 5;
/*    */   public static final int CrsCtrlrInhb = 3;
/*    */   public static final int DrvModSeldNotOk = 6;
/*    */   public static final int NoMsg = 0;
/*    */   public static final int OvrdTiMaxExcdd = 2;
/*    */   public static final int SpdLoLimExcdd = 4;
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
/*    */         str = "BrkOvrheatd";
/*    */       case 6:
/*    */         str = "DrvModSeldNotOk";
/*    */       case 5:
/*    */         str = "CrsCtrlrCnclSpdLoLimExcdd";
/*    */       case 4:
/*    */         str = "SpdLoLimExcdd";
/*    */       case 3:
/*    */         str = "CrsCtrlrInhb";
/*    */       case 2:
/*    */         str = "OvrdTiMaxExcdd";
/*    */       case 1:
/*    */         str = "CrsCtrlrCncl";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoMsg";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\CrsCtrlrMsg1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */