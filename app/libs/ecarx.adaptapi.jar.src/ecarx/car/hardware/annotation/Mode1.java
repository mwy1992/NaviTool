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
/*     */ public final class Mode1
/*     */ {
/*     */   public static final int BackwardScanning = 13;
/*     */   public static final int BackwardWipingOff = 9;
/*     */   public static final int BackwardWipingOn = 5;
/*     */   public static final int BreathOff = 15;
/*     */   public static final int BreathOn = 14;
/*     */   public static final int ForwardScanning = 12;
/*     */   public static final int ForwardWipingOff = 8;
/*     */   public static final int ForwardWipingOn = 4;
/*     */   public static final int GradualOff = 3;
/*     */   public static final int GradualOn = 2;
/*     */   public static final int InwardWipingOff = 11;
/*     */   public static final int InwardWipingOn = 7;
/*     */   public static final int Off = 0;
/*     */   public static final int On = 1;
/*     */   public static final int OutwardWipingOff = 10;
/*     */   public static final int OutwardWipingOn = 6;
/*     */   public static final int Spare1 = 16;
/*     */   public static final int Spare2 = 17;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  36 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  37 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  93 */         return str;
/*     */       case 17:
/*     */         str = "Spare2";
/*     */       case 16:
/*     */         str = "Spare1";
/*     */       case 15:
/*     */         str = "BreathOff";
/*     */       case 14:
/*     */         str = "BreathOn";
/*     */       case 13:
/*     */         str = "BackwardScanning";
/*     */       case 12:
/*     */         str = "ForwardScanning";
/*     */       case 11:
/*     */         str = "InwardWipingOff";
/*     */       case 10:
/*     */         str = "OutwardWipingOff";
/*     */       case 9:
/*     */         str = "BackwardWipingOff";
/*     */       case 8:
/*     */         str = "ForwardWipingOff";
/*     */       case 7:
/*     */         str = "InwardWipingOn";
/*     */       case 6:
/*     */         str = "OutwardWipingOn";
/*     */       case 5:
/*     */         str = "BackwardWipingOn";
/*     */       case 4:
/*     */         str = "ForwardWipingOn";
/*     */       case 3:
/*     */         str = "GradualOff";
/*     */       case 2:
/*     */         str = "GradualOn";
/*     */       case 1:
/*     */         str = "On";
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
/* 144 */     boolean bool = false;
/*     */     
/* 146 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17)
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
/* 164 */       bool = true;
/*     */     }
/*     */     
/* 167 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\Mode1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */