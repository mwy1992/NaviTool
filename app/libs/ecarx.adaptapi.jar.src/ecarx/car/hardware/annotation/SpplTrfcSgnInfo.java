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
/*     */ public final class SpplTrfcSgnInfo
/*     */ {
/*     */   public static final int Distanceduring = 12;
/*     */   public static final int Distanceto = 11;
/*     */   public static final int End = 18;
/*     */   public static final int Fog = 14;
/*     */   public static final int Generalsupplementarysign = 17;
/*     */   public static final int Ice = 7;
/*     */   public static final int Left = 1;
/*     */   public static final int Night = 15;
/*     */   public static final int Off = 0;
/*     */   public static final int Rain = 3;
/*     */   public static final int Ramp = 16;
/*     */   public static final int Right = 2;
/*     */   public static final int Schoolarea = 13;
/*     */   public static final int Snow = 4;
/*     */   public static final int Snowandrain = 5;
/*     */   public static final int Timelimit = 10;
/*     */   public static final int Trailer = 8;
/*     */   public static final int Wet = 6;
/*     */   public static final int Zone = 9;
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
/*     */         str = "End";
/*     */       case 17:
/*     */         str = "Generalsupplementarysign";
/*     */       case 16:
/*     */         str = "Ramp";
/*     */       case 15:
/*     */         str = "Night";
/*     */       case 14:
/*     */         str = "Fog";
/*     */       case 13:
/*     */         str = "Schoolarea";
/*     */       case 12:
/*     */         str = "Distanceduring";
/*     */       case 11:
/*     */         str = "Distanceto";
/*     */       case 10:
/*     */         str = "Timelimit";
/*     */       case 9:
/*     */         str = "Zone";
/*     */       case 8:
/*     */         str = "Trailer";
/*     */       case 7:
/*     */         str = "Ice";
/*     */       case 6:
/*     */         str = "Wet";
/*     */       case 5:
/*     */         str = "Snowandrain";
/*     */       case 4:
/*     */         str = "Snow";
/*     */       case 3:
/*     */         str = "Rain";
/*     */       case 2:
/*     */         str = "Right";
/*     */       case 1:
/*     */         str = "Left";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SpplTrfcSgnInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */