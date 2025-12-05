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
/*     */ public final class EyeGazeZone1
/*     */ {
/*     */   public static final int DIM = 5;
/*     */   public static final int HUD = 4;
/*     */   public static final int IHU = 6;
/*     */   public static final int Reserved3_21 = 21;
/*     */   public static final int Reserved4_22 = 22;
/*     */   public static final int Reserved5_23 = 23;
/*     */   public static final int Reserved6_24 = 24;
/*     */   public static final int SteerWheelLe = 19;
/*     */   public static final int SteerWheelRi = 20;
/*     */   public static final int Unavilable = 0;
/*     */   public static final int doordriver = 9;
/*     */   public static final int doorpassanger = 12;
/*     */   public static final int floordriver = 13;
/*     */   public static final int floorpassanger = 14;
/*     */   public static final int greenzone_1_3_4 = 16;
/*     */   public static final int other = 15;
/*     */   public static final int rearmirrordriver = 8;
/*     */   public static final int rearmirrorinner = 2;
/*     */   public static final int rearmirrorpassanger = 11;
/*     */   public static final int redzone_9_12_13_14 = 18;
/*     */   public static final int windowdriver = 7;
/*     */   public static final int windowpassagner = 10;
/*     */   public static final int windshielddriver = 1;
/*     */   public static final int windshieldpassager = 3;
/*     */   public static final int yellowzone_2_5_6_7_8_10_11 = 17;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  43 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  44 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 121 */         return str;
/*     */       case 24:
/*     */         str = "Reserved6_24";
/*     */       case 23:
/*     */         str = "Reserved5_23";
/*     */       case 22:
/*     */         str = "Reserved4_22";
/*     */       case 21:
/*     */         str = "Reserved3_21";
/*     */       case 20:
/*     */         str = "SteerWheelRi";
/*     */       case 19:
/*     */         str = "SteerWheelLe";
/*     */       case 18:
/*     */         str = "redzone_9_12_13_14";
/*     */       case 17:
/*     */         str = "yellowzone_2_5_6_7_8_10_11";
/*     */       case 16:
/*     */         str = "greenzone_1_3_4";
/*     */       case 15:
/*     */         str = "other";
/*     */       case 14:
/*     */         str = "floorpassanger";
/*     */       case 13:
/*     */         str = "floordriver";
/*     */       case 12:
/*     */         str = "doorpassanger";
/*     */       case 11:
/*     */         str = "rearmirrorpassanger";
/*     */       case 10:
/*     */         str = "windowpassagner";
/*     */       case 9:
/*     */         str = "doordriver";
/*     */       case 8:
/*     */         str = "rearmirrordriver";
/*     */       case 7:
/*     */         str = "windowdriver";
/*     */       case 6:
/*     */         str = "IHU";
/*     */       case 5:
/*     */         str = "DIM";
/*     */       case 4:
/*     */         str = "HUD";
/*     */       case 3:
/*     */         str = "windshieldpassager";
/*     */       case 2:
/*     */         str = "rearmirrorinner";
/*     */       case 1:
/*     */         str = "windshielddriver";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Unavilable";
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
/* 186 */     boolean bool = false;
/*     */     
/* 188 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24)
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
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 213 */       bool = true;
/*     */     }
/*     */     
/* 216 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\EyeGazeZone1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */