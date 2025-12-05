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
/*     */ public final class SignType
/*     */ {
/*     */   public static final int DistanceFor = 18;
/*     */   public static final int DistanceIn = 17;
/*     */   public static final int Empty = 0;
/*     */   public static final int End = 13;
/*     */   public static final int ExcptTractors = 15;
/*     */   public static final int Fog = 4;
/*     */   public static final int IcyOrWet = 14;
/*     */   public static final int IcyRoad = 1;
/*     */   public static final int LeExit = 7;
/*     */   public static final int Night = 11;
/*     */   public static final int PssgCarTrailer = 9;
/*     */   public static final int Ramp = 12;
/*     */   public static final int RiExit = 6;
/*     */   public static final int Rstrct = 5;
/*     */   public static final int SchoolZn = 10;
/*     */   public static final int SpdZn = 8;
/*     */   public static final int TmRstrct = 3;
/*     */   public static final int Trucks = 16;
/*     */   public static final int WeightLimit = 19;
/*     */   public static final int WetRoad = 2;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  38 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  39 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 101 */         return str;
/*     */       case 19:
/*     */         str = "WeightLimit";
/*     */       case 18:
/*     */         str = "DistanceFor";
/*     */       case 17:
/*     */         str = "DistanceIn";
/*     */       case 16:
/*     */         str = "Trucks";
/*     */       case 15:
/*     */         str = "ExcptTractors";
/*     */       case 14:
/*     */         str = "IcyOrWet";
/*     */       case 13:
/*     */         str = "End";
/*     */       case 12:
/*     */         str = "Ramp";
/*     */       case 11:
/*     */         str = "Night";
/*     */       case 10:
/*     */         str = "SchoolZn";
/*     */       case 9:
/*     */         str = "PssgCarTrailer";
/*     */       case 8:
/*     */         str = "SpdZn";
/*     */       case 7:
/*     */         str = "LeExit";
/*     */       case 6:
/*     */         str = "RiExit";
/*     */       case 5:
/*     */         str = "Rstrct";
/*     */       case 4:
/*     */         str = "Fog";
/*     */       case 3:
/*     */         str = "TmRstrct";
/*     */       case 2:
/*     */         str = "WetRoad";
/*     */       case 1:
/*     */         str = "IcyRoad";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Empty";
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
/* 156 */     boolean bool = false;
/*     */     
/* 158 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19)
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
/* 178 */       bool = true;
/*     */     }
/*     */     
/* 181 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SignType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */