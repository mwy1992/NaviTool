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
/*    */ public final class WhlMotSysModStsTyp1
/*    */ {
/*    */   public static final int CluOper = 4;
/*    */   public static final int Flt = 7;
/*    */   public static final int Inin = 0;
/*    */   public static final int PreChrg = 5;
/*    */   public static final int PwrDwn = 6;
/*    */   public static final int SpdCtrlIdle = 3;
/*    */   public static final int Stb = 1;
/*    */   public static final int TqCtrl = 2;
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
/*    */         str = "Flt";
/*    */       case 6:
/*    */         str = "PwrDwn";
/*    */       case 5:
/*    */         str = "PreChrg";
/*    */       case 4:
/*    */         str = "CluOper";
/*    */       case 3:
/*    */         str = "SpdCtrlIdle";
/*    */       case 2:
/*    */         str = "TqCtrl";
/*    */       case 1:
/*    */         str = "Stb";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Inin";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WhlMotSysModStsTyp1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */