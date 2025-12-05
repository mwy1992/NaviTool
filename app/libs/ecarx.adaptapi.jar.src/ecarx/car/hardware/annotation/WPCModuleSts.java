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
/*     */ public final class WPCModuleSts
/*     */ {
/*     */   public static final int Charging = 2;
/*     */   public static final int ChargingCompleted = 8;
/*     */   public static final int DeactivatedbyUser = 9;
/*     */   public static final int FOD = 3;
/*     */   public static final int Invalid = 15;
/*     */   public static final int OFF = 7;
/*     */   public static final int OverPowerProtected = 5;
/*     */   public static final int OverTemperatureProtected = 0;
/*     */   public static final int Resvd2 = 10;
/*     */   public static final int Resvd3 = 11;
/*     */   public static final int Resvd4 = 12;
/*     */   public static final int Resvd5 = 13;
/*     */   public static final int Resvd6 = 14;
/*     */   public static final int Standby = 1;
/*     */   public static final int Transmittingcoildisable = 6;
/*     */   public static final int VoltageProtected = 4;
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
/*     */         str = "Invalid";
/*     */       case 14:
/*     */         str = "Resvd6";
/*     */       case 13:
/*     */         str = "Resvd5";
/*     */       case 12:
/*     */         str = "Resvd4";
/*     */       case 11:
/*     */         str = "Resvd3";
/*     */       case 10:
/*     */         str = "Resvd2";
/*     */       case 9:
/*     */         str = "DeactivatedbyUser";
/*     */       case 8:
/*     */         str = "ChargingCompleted";
/*     */       case 7:
/*     */         str = "OFF";
/*     */       case 6:
/*     */         str = "Transmittingcoildisable";
/*     */       case 5:
/*     */         str = "OverPowerProtected";
/*     */       case 4:
/*     */         str = "VoltageProtected";
/*     */       case 3:
/*     */         str = "FOD";
/*     */       case 2:
/*     */         str = "Charging";
/*     */       case 1:
/*     */         str = "Standby";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "OverTemperatureProtected";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WPCModuleSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */