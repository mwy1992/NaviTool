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
/*    */ public final class BlowerReSts
/*    */ {
/*    */   public static final int HvacFanReSts2_EmgyOff = 4;
/*    */   public static final int HvacFanReSts2_ILimnActv = 1;
/*    */   public static final int HvacFanReSts2_Na = 0;
/*    */   public static final int HvacFanReSts2_Resd1 = 3;
/*    */   public static final int HvacFanReSts2_Resd2 = 5;
/*    */   public static final int HvacFanReSts2_SpOk = 2;
/*    */   public static final int HvacFanReSts2_StsInvld2 = 8;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 26 */     if (paramInt != 8) { switch (paramInt) {
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
/*    */         default:
/* 49 */           return str;
/*    */         case 5:
/*    */           str = "HvacFanReSts2_Resd2";
/*    */         case 4:
/*    */           str = "HvacFanReSts2_EmgyOff";
/*    */         case 3:
/*    */           str = "HvacFanReSts2_Resd1";
/*    */         case 2:
/*    */           str = "HvacFanReSts2_SpOk";
/*    */         case 1:
/*    */           str = "HvacFanReSts2_ILimnActv";
/*    */         case 0:
/*    */           break;
/*    */       } 
/*    */       str = "HvacFanReSts2_Na"; }
/*    */     
/*    */     str = "HvacFanReSts2_StsInvld2";
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
/* 78 */     boolean bool = false;
/*    */     
/* 80 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 8)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 87 */       bool = true;
/*    */     }
/*    */     
/* 90 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\BlowerReSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */