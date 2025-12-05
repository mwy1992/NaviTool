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
/*     */ public final class ErsStrtRes
/*     */ {
/*     */   public static final int ErsStrtAbrtEngCoolant = 16;
/*     */   public static final int ErsStrtAbrtEngFault = 15;
/*     */   public static final int ErsStrtAbrtLoBatt = 18;
/*     */   public static final int ErsStrtAbrtLoFuel = 17;
/*     */   public static final int ErsStrtAbrtOther = 19;
/*     */   public static final int ErsStrtInhCarUnlocked = 3;
/*     */   public static final int ErsStrtInhDoorOpen = 5;
/*     */   public static final int ErsStrtInhEngCoolant = 12;
/*     */   public static final int ErsStrtInhEngFault = 13;
/*     */   public static final int ErsStrtInhGearNotP = 7;
/*     */   public static final int ErsStrtInhHoodOpen = 6;
/*     */   public static final int ErsStrtInhKeyInCar = 4;
/*     */   public static final int ErsStrtInhLoBatt = 11;
/*     */   public static final int ErsStrtInhLoFuel = 10;
/*     */   public static final int ErsStrtInhMaxNoStart = 2;
/*     */   public static final int ErsStrtInhOther = 14;
/*     */   public static final int ErsStrtInhPedalPressed = 9;
/*     */   public static final int ErsStrtInhUserInCar = 8;
/*     */   public static final int ErsStrtNotSet = 0;
/*     */   public static final int ErsStrtSuccess = 1;
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
/*     */         str = "ErsStrtAbrtOther";
/*     */       case 18:
/*     */         str = "ErsStrtAbrtLoBatt";
/*     */       case 17:
/*     */         str = "ErsStrtAbrtLoFuel";
/*     */       case 16:
/*     */         str = "ErsStrtAbrtEngCoolant";
/*     */       case 15:
/*     */         str = "ErsStrtAbrtEngFault";
/*     */       case 14:
/*     */         str = "ErsStrtInhOther";
/*     */       case 13:
/*     */         str = "ErsStrtInhEngFault";
/*     */       case 12:
/*     */         str = "ErsStrtInhEngCoolant";
/*     */       case 11:
/*     */         str = "ErsStrtInhLoBatt";
/*     */       case 10:
/*     */         str = "ErsStrtInhLoFuel";
/*     */       case 9:
/*     */         str = "ErsStrtInhPedalPressed";
/*     */       case 8:
/*     */         str = "ErsStrtInhUserInCar";
/*     */       case 7:
/*     */         str = "ErsStrtInhGearNotP";
/*     */       case 6:
/*     */         str = "ErsStrtInhHoodOpen";
/*     */       case 5:
/*     */         str = "ErsStrtInhDoorOpen";
/*     */       case 4:
/*     */         str = "ErsStrtInhKeyInCar";
/*     */       case 3:
/*     */         str = "ErsStrtInhCarUnlocked";
/*     */       case 2:
/*     */         str = "ErsStrtInhMaxNoStart";
/*     */       case 1:
/*     */         str = "ErsStrtSuccess";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "ErsStrtNotSet";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ErsStrtRes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */