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
/*     */ public final class DrvrFbOfPrkgMod2
/*     */ {
/*     */   public static final int Cancel = 1;
/*     */   public static final int Default = 0;
/*     */   public static final int HorizontalLeftParkingOut = 9;
/*     */   public static final int HorizontalParkingIn = 2;
/*     */   public static final int HorizontalRightParkingOut = 10;
/*     */   public static final int PerpendicularLeftParkingOutBackward = 13;
/*     */   public static final int PerpendicularLeftParkingOutForward = 11;
/*     */   public static final int PerpendicularParkingIn = 3;
/*     */   public static final int PerpendicularParkingInBackward = 5;
/*     */   public static final int PerpendicularParkingInForward = 4;
/*     */   public static final int PerpendicularRightParkingOutBackward = 14;
/*     */   public static final int PerpendicularRightParkingOutForward = 12;
/*     */   public static final int Reserved1_6 = 6;
/*     */   public static final int Reserved2_7 = 7;
/*     */   public static final int Reserved3_8 = 8;
/*     */   public static final int Reserved6_15 = 15;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  34 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  35 */     switch (paramInt) {
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
/*  85 */         return str;
/*     */       case 15:
/*     */         str = "Reserved6_15";
/*     */       case 14:
/*     */         str = "PerpendicularRightParkingOutBackward";
/*     */       case 13:
/*     */         str = "PerpendicularLeftParkingOutBackward";
/*     */       case 12:
/*     */         str = "PerpendicularRightParkingOutForward";
/*     */       case 11:
/*     */         str = "PerpendicularLeftParkingOutForward";
/*     */       case 10:
/*     */         str = "HorizontalRightParkingOut";
/*     */       case 9:
/*     */         str = "HorizontalLeftParkingOut";
/*     */       case 8:
/*     */         str = "Reserved3_8";
/*     */       case 7:
/*     */         str = "Reserved2_7";
/*     */       case 6:
/*     */         str = "Reserved1_6";
/*     */       case 5:
/*     */         str = "PerpendicularParkingInBackward";
/*     */       case 4:
/*     */         str = "PerpendicularParkingInForward";
/*     */       case 3:
/*     */         str = "PerpendicularParkingIn";
/*     */       case 2:
/*     */         str = "HorizontalParkingIn";
/*     */       case 1:
/*     */         str = "Cancel";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Default";
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
/* 132 */     boolean bool = false;
/*     */     
/* 134 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15)
/*     */     {
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
/* 150 */       bool = true;
/*     */     }
/*     */     
/* 153 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvrFbOfPrkgMod2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */