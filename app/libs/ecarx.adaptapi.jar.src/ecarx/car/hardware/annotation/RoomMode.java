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
/*     */ public final class RoomMode
/*     */ {
/*     */   public static final int Centerpoint_All = 3;
/*     */   public static final int Centerpoint_Driver_Future = 4;
/*     */   public static final int Centerpoint_Rear_Future = 5;
/*     */   public static final int Reserved1_7 = 7;
/*     */   public static final int Reserved2_8 = 8;
/*     */   public static final int Reserved3_9 = 9;
/*     */   public static final int Reserved4_10 = 10;
/*     */   public static final int Reserved5_11 = 11;
/*     */   public static final int Reserved6_12 = 12;
/*     */   public static final int Reserved7_13 = 13;
/*     */   public static final int Reserved8_14 = 14;
/*     */   public static final int Reserved9_15 = 15;
/*     */   public static final int Stereo_All = 0;
/*     */   public static final int Stereo_Driver = 1;
/*     */   public static final int Stereo_Rear = 2;
/*     */   public static final int custom = 6;
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
/*     */         str = "Reserved9_15";
/*     */       case 14:
/*     */         str = "Reserved8_14";
/*     */       case 13:
/*     */         str = "Reserved7_13";
/*     */       case 12:
/*     */         str = "Reserved6_12";
/*     */       case 11:
/*     */         str = "Reserved5_11";
/*     */       case 10:
/*     */         str = "Reserved4_10";
/*     */       case 9:
/*     */         str = "Reserved3_9";
/*     */       case 8:
/*     */         str = "Reserved2_8";
/*     */       case 7:
/*     */         str = "Reserved1_7";
/*     */       case 6:
/*     */         str = "custom";
/*     */       case 5:
/*     */         str = "Centerpoint_Rear_Future";
/*     */       case 4:
/*     */         str = "Centerpoint_Driver_Future";
/*     */       case 3:
/*     */         str = "Centerpoint_All";
/*     */       case 2:
/*     */         str = "Stereo_Rear";
/*     */       case 1:
/*     */         str = "Stereo_Driver";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Stereo_All";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RoomMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */