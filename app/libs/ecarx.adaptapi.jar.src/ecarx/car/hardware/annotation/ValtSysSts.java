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
/*     */ public final class ValtSysSts
/*     */ {
/*     */   public static final int Abort = 4;
/*     */   public static final int Failure = 5;
/*     */   public static final int Localization = 3;
/*     */   public static final int MapDownloading = 2;
/*     */   public static final int MapListLoading = 1;
/*     */   public static final int Off = 0;
/*     */   public static final int ParkingInComplete = 12;
/*     */   public static final int ParkingInCruse = 10;
/*     */   public static final int ParkingInPreactive = 9;
/*     */   public static final int ParkingInProcess = 11;
/*     */   public static final int ParkingInStandby = 8;
/*     */   public static final int ParkingOutComplete = 20;
/*     */   public static final int ParkingOutCruse = 18;
/*     */   public static final int ParkingOutPreactive = 17;
/*     */   public static final int ParkingOutProcess = 19;
/*     */   public static final int ParkingOutStandby = 16;
/*     */   public static final int Reserved1_6 = 6;
/*     */   public static final int Reserved2_7 = 7;
/*     */   public static final int Reserved3_13 = 13;
/*     */   public static final int Reserved4_14 = 14;
/*     */   public static final int Reserved5_15 = 15;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  39 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  40 */     switch (paramInt) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 105 */         return str;
/*     */       case 20:
/*     */         str = "ParkingOutComplete";
/*     */       case 19:
/*     */         str = "ParkingOutProcess";
/*     */       case 18:
/*     */         str = "ParkingOutCruse";
/*     */       case 17:
/*     */         str = "ParkingOutPreactive";
/*     */       case 16:
/*     */         str = "ParkingOutStandby";
/*     */       case 15:
/*     */         str = "Reserved5_15";
/*     */       case 14:
/*     */         str = "Reserved4_14";
/*     */       case 13:
/*     */         str = "Reserved3_13";
/*     */       case 12:
/*     */         str = "ParkingInComplete";
/*     */       case 11:
/*     */         str = "ParkingInProcess";
/*     */       case 10:
/*     */         str = "ParkingInCruse";
/*     */       case 9:
/*     */         str = "ParkingInPreactive";
/*     */       case 8:
/*     */         str = "ParkingInStandby";
/*     */       case 7:
/*     */         str = "Reserved2_7";
/*     */       case 6:
/*     */         str = "Reserved1_6";
/*     */       case 5:
/*     */         str = "Failure";
/*     */       case 4:
/*     */         str = "Abort";
/*     */       case 3:
/*     */         str = "Localization";
/*     */       case 2:
/*     */         str = "MapDownloading";
/*     */       case 1:
/*     */         str = "MapListLoading";
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
/* 162 */     boolean bool = false;
/*     */     
/* 164 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20)
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
/*     */ 
/*     */       
/* 185 */       bool = true;
/*     */     }
/*     */     
/* 188 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ValtSysSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */