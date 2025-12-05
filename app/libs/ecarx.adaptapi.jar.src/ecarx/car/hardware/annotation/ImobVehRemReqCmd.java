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
/*    */ public final class ImobVehRemReqCmd
/*    */ {
/*    */   public static final int ImobRemChkReq = 4;
/*    */   public static final int ImobRemReqIdle = 0;
/*    */   public static final int ImobRemStsReq = 5;
/*    */   public static final int ImobnRemReq = 2;
/*    */   public static final int NoImobnRemReq = 1;
/*    */   public static final int SpdLimRemReq = 3;
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
/*    */         str = "ImobRemStsReq";
/*    */       case 4:
/*    */         str = "ImobRemChkReq";
/*    */       case 3:
/*    */         str = "SpdLimRemReq";
/*    */       case 2:
/*    */         str = "ImobnRemReq";
/*    */       case 1:
/*    */         str = "NoImobnRemReq";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ImobRemReqIdle";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ImobVehRemReqCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */