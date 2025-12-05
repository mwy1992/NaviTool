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
/*    */ public final class AsyALgtCtrlMod1
/*    */ {
/*    */   public static final int AsyALgtCtrlMod_APA = 11;
/*    */   public static final int AsyALgtCtrlMod_HPA = 13;
/*    */   public static final int AsyALgtCtrlMod_NoReq = 0;
/*    */   public static final int AsyALgtCtrlMod_PEB = 10;
/*    */   public static final int AsyALgtCtrlMod_RPA = 12;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     if (paramInt != 0) { switch (paramInt) {
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
/*    */         default:
/* 41 */           return str;
/*    */         case 13:
/*    */           str = "AsyALgtCtrlMod_HPA";
/*    */         case 12:
/*    */           str = "AsyALgtCtrlMod_RPA";
/*    */         case 11:
/*    */           str = "AsyALgtCtrlMod_APA";
/*    */         case 10:
/*    */           break;
/*    */       } 
/*    */       str = "AsyALgtCtrlMod_PEB"; }
/*    */     
/*    */     str = "AsyALgtCtrlMod_NoReq";
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
/* 66 */     boolean bool = false;
/*    */     
/* 68 */     if (paramInt == 0 || paramInt == 11 || paramInt == 10 || paramInt == 13 || paramInt == 12)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 73 */       bool = true;
/*    */     }
/*    */     
/* 76 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AsyALgtCtrlMod1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */