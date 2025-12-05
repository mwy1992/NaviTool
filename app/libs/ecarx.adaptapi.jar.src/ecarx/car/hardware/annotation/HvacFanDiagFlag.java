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
/*    */ public final class HvacFanDiagFlag
/*    */ {
/*    */   public static final int ErrorADConvertor = 1;
/*    */   public static final int Errorbridgedriverovercurrent = 4;
/*    */   public static final int Errorbridgedriverovertemperature = 8;
/*    */   public static final int ErrortemperatureSensor = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 22 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 23 */     if (paramInt != 4) { if (paramInt != 8) { switch (paramInt) {
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
/*    */           default:
/* 37 */             return str;
/*    */           case 2:
/*    */             str = "ErrortemperatureSensor";
/*    */           case 1:
/*    */             break;
/*    */         } 
/*    */         str = "ErrorADConvertor"; }
/*    */       
/*    */       str = "Errorbridgedriverovertemperature"; }
/*    */     
/*    */     str = "Errorbridgedriverovercurrent";
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
/* 60 */     boolean bool = false;
/*    */     
/* 62 */     if (paramInt == 8 || paramInt == 1 || paramInt == 4 || paramInt == 2)
/*    */     {
/*    */ 
/*    */       
/* 66 */       bool = true;
/*    */     }
/*    */     
/* 69 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HvacFanDiagFlag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */