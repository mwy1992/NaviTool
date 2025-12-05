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
/*     */ public final class DrvrAsscSysSts
/*     */ {
/*     */   public static final int Abort = 8;
/*     */   public static final int Failure = 2;
/*     */   public static final int Off = 0;
/*     */   public static final int ParkingProcessActive = 4;
/*     */   public static final int ParkingProcessCompleted = 5;
/*     */   public static final int PreParkingprocessactive = 9;
/*     */   public static final int Quit = 6;
/*     */   public static final int Searching = 3;
/*     */   public static final int Standby = 1;
/*     */   public static final int Suspend = 7;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  28 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  29 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  61 */         return str;
/*     */       case 9:
/*     */         str = "PreParkingprocessactive";
/*     */       case 8:
/*     */         str = "Abort";
/*     */       case 7:
/*     */         str = "Suspend";
/*     */       case 6:
/*     */         str = "Quit";
/*     */       case 5:
/*     */         str = "ParkingProcessCompleted";
/*     */       case 4:
/*     */         str = "ParkingProcessActive";
/*     */       case 3:
/*     */         str = "Searching";
/*     */       case 2:
/*     */         str = "Failure";
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
/*  96 */     boolean bool = false;
/*     */     
/*  98 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       bool = true;
/*     */     }
/*     */     
/* 111 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvrAsscSysSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */