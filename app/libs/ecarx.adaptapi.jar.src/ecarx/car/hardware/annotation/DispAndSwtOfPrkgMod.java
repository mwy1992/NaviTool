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
/*     */ public final class DispAndSwtOfPrkgMod
/*     */ {
/*     */   public static final int HorizontalParkingInOrPerpendicularParkingIn_ForwardOrBackward = 8;
/*     */   public static final int HorizontalParkingIn_PerpendicularParkingIn_Backward = 6;
/*     */   public static final int HorizontalParkingIn_PerpendicularParkingIn_Forward = 5;
/*     */   public static final int HorizontalParkingOutOrPerpendicularParkingOut_Backward = 13;
/*     */   public static final int HorizontalParkingOutOrPerpendicularParkingOut_Forward = 12;
/*     */   public static final int HorizontalParkingOutOrPerpendicularParkingOut_ForwardOrBacward = 15;
/*     */   public static final int NoRequest = 0;
/*     */   public static final int OnlyHorizontalParkingIn = 2;
/*     */   public static final int OnlyHorizontalParkingOut = 9;
/*     */   public static final int OnlyPerpendicularParkingIn_backward = 4;
/*     */   public static final int OnlyPerpendicularParkingIn_forward = 3;
/*     */   public static final int OnlyPerpendicularParkingOut_Backward = 11;
/*     */   public static final int OnlyPerpendicularParkingOut_Forward = 10;
/*     */   public static final int Parkin_Outselect = 1;
/*     */   public static final int PerpendicularParkingIn_ForwardOrBackward = 7;
/*     */   public static final int PerpendicularParkingOut_ForwardOrBacward = 14;
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
/*     */         str = "HorizontalParkingOutOrPerpendicularParkingOut_ForwardOrBacward";
/*     */       case 14:
/*     */         str = "PerpendicularParkingOut_ForwardOrBacward";
/*     */       case 13:
/*     */         str = "HorizontalParkingOutOrPerpendicularParkingOut_Backward";
/*     */       case 12:
/*     */         str = "HorizontalParkingOutOrPerpendicularParkingOut_Forward";
/*     */       case 11:
/*     */         str = "OnlyPerpendicularParkingOut_Backward";
/*     */       case 10:
/*     */         str = "OnlyPerpendicularParkingOut_Forward";
/*     */       case 9:
/*     */         str = "OnlyHorizontalParkingOut";
/*     */       case 8:
/*     */         str = "HorizontalParkingInOrPerpendicularParkingIn_ForwardOrBackward";
/*     */       case 7:
/*     */         str = "PerpendicularParkingIn_ForwardOrBackward";
/*     */       case 6:
/*     */         str = "HorizontalParkingIn_PerpendicularParkingIn_Backward";
/*     */       case 5:
/*     */         str = "HorizontalParkingIn_PerpendicularParkingIn_Forward";
/*     */       case 4:
/*     */         str = "OnlyPerpendicularParkingIn_backward";
/*     */       case 3:
/*     */         str = "OnlyPerpendicularParkingIn_forward";
/*     */       case 2:
/*     */         str = "OnlyHorizontalParkingIn";
/*     */       case 1:
/*     */         str = "Parkin_Outselect";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoRequest";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DispAndSwtOfPrkgMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */