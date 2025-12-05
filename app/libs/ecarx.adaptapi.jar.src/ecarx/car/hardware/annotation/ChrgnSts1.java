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
/*     */ public final class ChrgnSts1
/*     */ {
/*     */   public static final int Booking = 6;
/*     */   public static final int Charging = 2;
/*     */   public static final int ChargingComplete = 4;
/*     */   public static final int ChargingEnd = 3;
/*     */   public static final int Chargingfalut = 11;
/*     */   public static final int Discharging = 8;
/*     */   public static final int DischargingComplete = 10;
/*     */   public static final int DischargingEnd = 9;
/*     */   public static final int DischargingFalut = 12;
/*     */   public static final int Heating = 5;
/*     */   public static final int NoCharging = 1;
/*     */   public static final int NoDischaring = 7;
/*     */   public static final int _default = 0;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  31 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  32 */     switch (paramInt) {
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
/*  73 */         return str;
/*     */       case 12:
/*     */         str = "DischargingFalut";
/*     */       case 11:
/*     */         str = "Chargingfalut";
/*     */       case 10:
/*     */         str = "DischargingComplete";
/*     */       case 9:
/*     */         str = "DischargingEnd";
/*     */       case 8:
/*     */         str = "Discharging";
/*     */       case 7:
/*     */         str = "NoDischaring";
/*     */       case 6:
/*     */         str = "Booking";
/*     */       case 5:
/*     */         str = "Heating";
/*     */       case 4:
/*     */         str = "ChargingComplete";
/*     */       case 3:
/*     */         str = "ChargingEnd";
/*     */       case 2:
/*     */         str = "Charging";
/*     */       case 1:
/*     */         str = "NoCharging";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "_default";
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
/* 114 */     boolean bool = false;
/*     */     
/* 116 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12)
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
/* 129 */       bool = true;
/*     */     }
/*     */     
/* 132 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ChrgnSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */