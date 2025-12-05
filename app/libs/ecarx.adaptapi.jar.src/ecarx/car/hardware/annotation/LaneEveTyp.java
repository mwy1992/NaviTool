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
/*    */ public final class LaneEveTyp
/*    */ {
/*    */   public static final int ClosingFork = 2;
/*    */   public static final int MarkingTypeChangeDashedToSolid = 3;
/*    */   public static final int MarkingTypeChangeSolidTtoDashed = 4;
/*    */   public static final int MarkingTypeChangeStartOfDashed = 5;
/*    */   public static final int MarkingTypeChangeStartOfSolid = 6;
/*    */   public static final int NoEvent = 0;
/*    */   public static final int OpeningFork = 1;
/*    */   public static final int Reserved_7 = 7;
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
/*    */         str = "MarkingTypeChangeStartOfSolid";
/*    */       case 5:
/*    */         str = "MarkingTypeChangeStartOfDashed";
/*    */       case 4:
/*    */         str = "MarkingTypeChangeSolidTtoDashed";
/*    */       case 3:
/*    */         str = "MarkingTypeChangeDashedToSolid";
/*    */       case 2:
/*    */         str = "ClosingFork";
/*    */       case 1:
/*    */         str = "OpeningFork";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoEvent";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LaneEveTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */