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
/*     */ public final class ModCfmd
/*     */ {
/*     */   public static final int ACC_HWA = 9;
/*     */   public static final int APA = 11;
/*     */   public static final int HPA = 13;
/*     */   public static final int NoReq = 0;
/*     */   public static final int PEB = 10;
/*     */   public static final int RPA = 12;
/*     */   public static final int Reserved1_1 = 1;
/*     */   public static final int Reserved2_2 = 2;
/*     */   public static final int Reserved3_3 = 3;
/*     */   public static final int Reserved4_4 = 4;
/*     */   public static final int Reserved5_5 = 5;
/*     */   public static final int Reserved6_6 = 6;
/*     */   public static final int Reserved7_7 = 7;
/*     */   public static final int Reserved8_8 = 8;
/*     */   public static final int SHWA = 15;
/*     */   public static final int TJP = 14;
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
/*     */         str = "SHWA";
/*     */       case 14:
/*     */         str = "TJP";
/*     */       case 13:
/*     */         str = "HPA";
/*     */       case 12:
/*     */         str = "RPA";
/*     */       case 11:
/*     */         str = "APA";
/*     */       case 10:
/*     */         str = "PEB";
/*     */       case 9:
/*     */         str = "ACC_HWA";
/*     */       case 8:
/*     */         str = "Reserved8_8";
/*     */       case 7:
/*     */         str = "Reserved7_7";
/*     */       case 6:
/*     */         str = "Reserved6_6";
/*     */       case 5:
/*     */         str = "Reserved5_5";
/*     */       case 4:
/*     */         str = "Reserved4_4";
/*     */       case 3:
/*     */         str = "Reserved3_3";
/*     */       case 2:
/*     */         str = "Reserved2_2";
/*     */       case 1:
/*     */         str = "Reserved1_1";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ModCfmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */