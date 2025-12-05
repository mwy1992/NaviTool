/*     */ package ecarx.car.hardware.annotation;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PrkgAuxInfoDisp
/*     */ {
/*     */   public static final int ChooseParkingMode = 8;
/*     */   public static final int ChooseParkingMode_Or_ChangeOtherParkingSpaces = 7;
/*     */   public static final int NoReq = 0;
/*     */   public static final int ParkingSlotSelected = 5;
/*     */   public static final int ParkingTypeRecommandButtonOff = 6;
/*     */   public static final int PleaseForward = 2;
/*     */   public static final int PleasePayAttentionToSurrounding = 1;
/*     */   public static final int PressTtheBrakePedal = 3;
/*     */   public static final int SelectParkingSlot = 4;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  27 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  28 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/*  57 */         return str;
/*     */       case 8:
/*     */         str = "ChooseParkingMode";
/*     */       case 7:
/*     */         str = "ChooseParkingMode_Or_ChangeOtherParkingSpaces";
/*     */       case 6:
/*     */         str = "ParkingTypeRecommandButtonOff";
/*     */       case 5:
/*     */         str = "ParkingSlotSelected";
/*     */       case 4:
/*     */         str = "SelectParkingSlot";
/*     */       case 3:
/*     */         str = "PressTtheBrakePedal";
/*     */       case 2:
/*     */         str = "PleaseForward";
/*     */       case 1:
/*     */         str = "PleasePayAttentionToSurrounding";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoReq";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isValid(int paramInt) {
/*  90 */     boolean bool = false;
/*     */     
/*  92 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       bool = true;
/*     */     }
/*     */     
/* 104 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgAuxInfoDisp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */