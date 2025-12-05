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
/*     */ public final class OnBdChrgrHndlSts1
/*     */ {
/*     */   public static final int ConnectedWithPower = 3;
/*     */   public static final int ConnectedWithoutPower = 1;
/*     */   public static final int DischargeConnectwithoutpowerincar = 4;
/*     */   public static final int DischargeConnectwithoutpoweroutcar = 5;
/*     */   public static final int DischargeConnectwithpowerincar = 6;
/*     */   public static final int DischargeConnectwithpoweroutcar = 7;
/*     */   public static final int Disconnected = 0;
/*     */   public static final int Fault = 9;
/*     */   public static final int Init = 8;
/*     */   public static final int NotCompleteConnnected = 10;
/*     */   public static final int PowerAvailableButNotActivated = 2;
/*     */   public static final int Reserved0_11 = 11;
/*     */   public static final int Reserved1_12 = 12;
/*     */   public static final int Reserved2_13 = 13;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  32 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  33 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  77 */         return str;
/*     */       case 13:
/*     */         str = "Reserved2_13";
/*     */       case 12:
/*     */         str = "Reserved1_12";
/*     */       case 11:
/*     */         str = "Reserved0_11";
/*     */       case 10:
/*     */         str = "NotCompleteConnnected";
/*     */       case 9:
/*     */         str = "Fault";
/*     */       case 8:
/*     */         str = "Init";
/*     */       case 7:
/*     */         str = "DischargeConnectwithpoweroutcar";
/*     */       case 6:
/*     */         str = "DischargeConnectwithpowerincar";
/*     */       case 5:
/*     */         str = "DischargeConnectwithoutpoweroutcar";
/*     */       case 4:
/*     */         str = "DischargeConnectwithoutpowerincar";
/*     */       case 3:
/*     */         str = "ConnectedWithPower";
/*     */       case 2:
/*     */         str = "PowerAvailableButNotActivated";
/*     */       case 1:
/*     */         str = "ConnectedWithoutPower";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Disconnected";
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
/* 120 */     boolean bool = false;
/*     */     
/* 122 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13)
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
/* 136 */       bool = true;
/*     */     }
/*     */     
/* 139 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\OnBdChrgrHndlSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */