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
/*    */ public final class DiagcTouchPanReq
/*    */ {
/*    */   public static final int DiagcForTouchPan_HapticNotOper = 4;
/*    */   public static final int DiagcForTouchPan_MemErr = 2;
/*    */   public static final int DiagcForTouchPan_NoFlt = 0;
/*    */   public static final int DiagcForTouchPan_OutdURng = 1;
/*    */   public static final int DiagcForTouchPan_Spare1 = 5;
/*    */   public static final int DiagcForTouchPan_Spare2 = 6;
/*    */   public static final int DiagcForTouchPan_Spare3 = 7;
/*    */   public static final int DiagcForTouchPan_TouchNotOper = 3;
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
/*    */         str = "DiagcForTouchPan_Spare3";
/*    */       case 6:
/*    */         str = "DiagcForTouchPan_Spare2";
/*    */       case 5:
/*    */         str = "DiagcForTouchPan_Spare1";
/*    */       case 4:
/*    */         str = "DiagcForTouchPan_HapticNotOper";
/*    */       case 3:
/*    */         str = "DiagcForTouchPan_TouchNotOper";
/*    */       case 2:
/*    */         str = "DiagcForTouchPan_MemErr";
/*    */       case 1:
/*    */         str = "DiagcForTouchPan_OutdURng";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "DiagcForTouchPan_NoFlt";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DiagcTouchPanReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */