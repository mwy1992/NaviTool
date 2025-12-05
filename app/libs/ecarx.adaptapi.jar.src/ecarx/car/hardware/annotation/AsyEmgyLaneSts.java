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
/*    */ public final class AsyEmgyLaneSts
/*    */ {
/*    */   public static final int ELOWNotInUse = 7;
/*    */   public static final int ELOWOff = 1;
/*    */   public static final int ELOWOn = 6;
/*    */   public static final int ELOWServiceRequired = 5;
/*    */   public static final int ELOWStandby = 2;
/*    */   public static final int ELOWUnavailable = 4;
/*    */   public static final int ELOWUnknown = 0;
/*    */   public static final int Reserved_3 = 3;
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
/*    */         str = "ELOWNotInUse";
/*    */       case 6:
/*    */         str = "ELOWOn";
/*    */       case 5:
/*    */         str = "ELOWServiceRequired";
/*    */       case 4:
/*    */         str = "ELOWUnavailable";
/*    */       case 3:
/*    */         str = "Reserved_3";
/*    */       case 2:
/*    */         str = "ELOWStandby";
/*    */       case 1:
/*    */         str = "ELOWOff";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ELOWUnknown";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AsyEmgyLaneSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */