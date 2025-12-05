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
/*    */ public final class MessageType
/*    */ {
/*    */   public static final int METADATA = 6;
/*    */   public static final int POSITION = 1;
/*    */   public static final int PROFILELONG = 5;
/*    */   public static final int PROFILESHORT = 4;
/*    */   public static final int Reserved_7 = 7;
/*    */   public static final int SEGMENT = 2;
/*    */   public static final int STUB = 3;
/*    */   public static final int SystemSpecific = 0;
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
/*    */         str = "Reserved_7";
/*    */       case 6:
/*    */         str = "METADATA";
/*    */       case 5:
/*    */         str = "PROFILELONG";
/*    */       case 4:
/*    */         str = "PROFILESHORT";
/*    */       case 3:
/*    */         str = "STUB";
/*    */       case 2:
/*    */         str = "SEGMENT";
/*    */       case 1:
/*    */         str = "POSITION";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "SystemSpecific";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MessageType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */