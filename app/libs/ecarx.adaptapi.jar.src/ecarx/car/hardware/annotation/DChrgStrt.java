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
/*     */ public final class DChrgStrt
/*     */ {
/*     */   public static final int CarUnlocked = 5;
/*     */   public static final int Finished = 2;
/*     */   public static final int FuelLow = 8;
/*     */   public static final int HoodOpen = 4;
/*     */   public static final int MaxNoStart = 3;
/*     */   public static final int MaxTi = 10;
/*     */   public static final int NoValidKeyInCar = 11;
/*     */   public static final int NotSet = 0;
/*     */   public static final int PropFlt = 9;
/*     */   public static final int PwrSplyErr = 7;
/*     */   public static final int Start = 1;
/*     */   public static final int ValidKeyInCar = 6;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  30 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  31 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  69 */         return str;
/*     */       case 11:
/*     */         str = "NoValidKeyInCar";
/*     */       case 10:
/*     */         str = "MaxTi";
/*     */       case 9:
/*     */         str = "PropFlt";
/*     */       case 8:
/*     */         str = "FuelLow";
/*     */       case 7:
/*     */         str = "PwrSplyErr";
/*     */       case 6:
/*     */         str = "ValidKeyInCar";
/*     */       case 5:
/*     */         str = "CarUnlocked";
/*     */       case 4:
/*     */         str = "HoodOpen";
/*     */       case 3:
/*     */         str = "MaxNoStart";
/*     */       case 2:
/*     */         str = "Finished";
/*     */       case 1:
/*     */         str = "Start";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NotSet";
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
/* 108 */     boolean bool = false;
/*     */     
/* 110 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11)
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
/* 122 */       bool = true;
/*     */     }
/*     */     
/* 125 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DChrgStrt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */