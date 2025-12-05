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
/*     */ public final class PrkgDstCtrlSysSts
/*     */ {
/*     */   public static final int Covered = 8;
/*     */   public static final int FrontActive = 3;
/*     */   public static final int FrontActiveTrailerMode = 9;
/*     */   public static final int FrontRearActive = 2;
/*     */   public static final int Inhibited = 6;
/*     */   public static final int Initialize = 7;
/*     */   public static final int Off = 0;
/*     */   public static final int RearActive = 4;
/*     */   public static final int Reserved1_10 = 10;
/*     */   public static final int Reserved2_11 = 11;
/*     */   public static final int Reserved3_12 = 12;
/*     */   public static final int Reserved4_13 = 13;
/*     */   public static final int Reserved5_14 = 14;
/*     */   public static final int Reserved6_15 = 15;
/*     */   public static final int Standby = 1;
/*     */   public static final int SystemFailure = 5;
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
/*     */         str = "Reserved5_14";
/*     */       case 13:
/*     */         str = "Reserved4_13";
/*     */       case 12:
/*     */         str = "Reserved3_12";
/*     */       case 11:
/*     */         str = "Reserved2_11";
/*     */       case 10:
/*     */         str = "Reserved1_10";
/*     */       case 9:
/*     */         str = "FrontActiveTrailerMode";
/*     */       case 8:
/*     */         str = "Covered";
/*     */       case 7:
/*     */         str = "Initialize";
/*     */       case 6:
/*     */         str = "Inhibited";
/*     */       case 5:
/*     */         str = "SystemFailure";
/*     */       case 4:
/*     */         str = "RearActive";
/*     */       case 3:
/*     */         str = "FrontActive";
/*     */       case 2:
/*     */         str = "FrontRearActive";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgDstCtrlSysSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */