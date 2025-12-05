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
/*     */ public final class HomePrkgSysSts
/*     */ {
/*     */   public static final int Abort = 17;
/*     */   public static final int Cruse = 4;
/*     */   public static final int FunctionCompleted = 16;
/*     */   public static final int Localization = 3;
/*     */   public static final int MapBuilding = 2;
/*     */   public static final int Off = 0;
/*     */   public static final int ParkingInPreactive = 8;
/*     */   public static final int ParkingInProcess = 9;
/*     */   public static final int ParkingOutPreactive = 12;
/*     */   public static final int ParkingOutProcess = 13;
/*     */   public static final int Reserved1_5 = 5;
/*     */   public static final int Reserved2_6 = 6;
/*     */   public static final int Reserved3_7 = 7;
/*     */   public static final int Reserved4_10 = 10;
/*     */   public static final int Reserved5_11 = 11;
/*     */   public static final int Reserved6_14 = 14;
/*     */   public static final int Reserved7_15 = 15;
/*     */   public static final int Standby = 1;
/*     */   public static final int Suspend = 18;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  37 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  38 */     switch (paramInt) {
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
/*  97 */         return str;
/*     */       case 18:
/*     */         str = "Suspend";
/*     */       case 17:
/*     */         str = "Abort";
/*     */       case 16:
/*     */         str = "FunctionCompleted";
/*     */       case 15:
/*     */         str = "Reserved7_15";
/*     */       case 14:
/*     */         str = "Reserved6_14";
/*     */       case 13:
/*     */         str = "ParkingOutProcess";
/*     */       case 12:
/*     */         str = "ParkingOutPreactive";
/*     */       case 11:
/*     */         str = "Reserved5_11";
/*     */       case 10:
/*     */         str = "Reserved4_10";
/*     */       case 9:
/*     */         str = "ParkingInProcess";
/*     */       case 8:
/*     */         str = "ParkingInPreactive";
/*     */       case 7:
/*     */         str = "Reserved3_7";
/*     */       case 6:
/*     */         str = "Reserved2_6";
/*     */       case 5:
/*     */         str = "Reserved1_5";
/*     */       case 4:
/*     */         str = "Cruse";
/*     */       case 3:
/*     */         str = "Localization";
/*     */       case 2:
/*     */         str = "MapBuilding";
/*     */       case 1:
/*     */         str = "Standby";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Off";
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
/* 150 */     boolean bool = false;
/*     */     
/* 152 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18)
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
/*     */ 
/*     */ 
/*     */       
/* 171 */       bool = true;
/*     */     }
/*     */     
/* 174 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HomePrkgSysSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */