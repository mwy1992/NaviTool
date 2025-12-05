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
/*    */ public final class LineTyp
/*    */ {
/*    */   public static final int BottsDots = 3;
/*    */   public static final int Dashed = 2;
/*    */   public static final int Double = 5;
/*    */   public static final int Reserved1_6 = 6;
/*    */   public static final int Reserved2_7 = 7;
/*    */   public static final int Solid = 1;
/*    */   public static final int Unknown = 0;
/*    */   public static final int VirtualTrackedlanemarker = 4;
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
/*    */         str = "Reserved2_7";
/*    */       case 6:
/*    */         str = "Reserved1_6";
/*    */       case 5:
/*    */         str = "Double";
/*    */       case 4:
/*    */         str = "VirtualTrackedlanemarker";
/*    */       case 3:
/*    */         str = "BottsDots";
/*    */       case 2:
/*    */         str = "Dashed";
/*    */       case 1:
/*    */         str = "Solid";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Unknown";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LineTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */