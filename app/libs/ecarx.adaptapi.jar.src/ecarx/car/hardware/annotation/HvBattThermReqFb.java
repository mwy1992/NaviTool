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
/*     */ public final class HvBattThermReqFb
/*     */ {
/*     */   public static final int CompressorCooling = 4;
/*     */   public static final int CoolingFinish = 5;
/*     */   public static final int Default = 0;
/*     */   public static final int Fault = 8;
/*     */   public static final int HeatFinished = 2;
/*     */   public static final int Heating = 1;
/*     */   public static final int HeatingByEmotCoolt = 7;
/*     */   public static final int Inhibited = 6;
/*     */   public static final int RadiatorCooling = 3;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  27 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  28 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  57 */         return str;
/*     */       case 8:
/*     */         str = "Fault";
/*     */       case 7:
/*     */         str = "HeatingByEmotCoolt";
/*     */       case 6:
/*     */         str = "Inhibited";
/*     */       case 5:
/*     */         str = "CoolingFinish";
/*     */       case 4:
/*     */         str = "CompressorCooling";
/*     */       case 3:
/*     */         str = "RadiatorCooling";
/*     */       case 2:
/*     */         str = "HeatFinished";
/*     */       case 1:
/*     */         str = "Heating";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Default";
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
/*  90 */     boolean bool = false;
/*     */     
/*  92 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       bool = true;
/*     */     }
/*     */     
/* 104 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\HvBattThermReqFb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */