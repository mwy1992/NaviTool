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
/*     */ public final class LVPwrSplyErrSts
/*     */ {
/*     */   public static final int PwrSplyErrSts_AltFltCom = 13;
/*     */   public static final int PwrSplyErrSts_AltFltElec = 11;
/*     */   public static final int PwrSplyErrSts_AltFltMecl = 10;
/*     */   public static final int PwrSplyErrSts_AltFltT = 12;
/*     */   public static final int PwrSplyErrSts_BattRlyFlt = 3;
/*     */   public static final int PwrSplyErrSts_BattSnsrComFlt = 4;
/*     */   public static final int PwrSplyErrSts_BattSnsrHwFlt = 5;
/*     */   public static final int PwrSplyErrSts_FltComDcDc = 6;
/*     */   public static final int PwrSplyErrSts_FltDcDc = 8;
/*     */   public static final int PwrSplyErrSts_FltElecDcDc = 7;
/*     */   public static final int PwrSplyErrSts_Spare6 = 15;
/*     */   public static final int PwrSplyErrSts_SpprtBattFltChrgn = 14;
/*     */   public static final int PwrSplyErrSts_SupCptrHwFlt = 9;
/*     */   public static final int PwrSplyErrSts_SysOk = 0;
/*     */   public static final int PwrSplyErrSts_UhiDurgDrvg = 1;
/*     */   public static final int PwrSplyErrSts_UloDurgdrvg = 2;
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
/*     */         str = "PwrSplyErrSts_Spare6";
/*     */       case 14:
/*     */         str = "PwrSplyErrSts_SpprtBattFltChrgn";
/*     */       case 13:
/*     */         str = "PwrSplyErrSts_AltFltCom";
/*     */       case 12:
/*     */         str = "PwrSplyErrSts_AltFltT";
/*     */       case 11:
/*     */         str = "PwrSplyErrSts_AltFltElec";
/*     */       case 10:
/*     */         str = "PwrSplyErrSts_AltFltMecl";
/*     */       case 9:
/*     */         str = "PwrSplyErrSts_SupCptrHwFlt";
/*     */       case 8:
/*     */         str = "PwrSplyErrSts_FltDcDc";
/*     */       case 7:
/*     */         str = "PwrSplyErrSts_FltElecDcDc";
/*     */       case 6:
/*     */         str = "PwrSplyErrSts_FltComDcDc";
/*     */       case 5:
/*     */         str = "PwrSplyErrSts_BattSnsrHwFlt";
/*     */       case 4:
/*     */         str = "PwrSplyErrSts_BattSnsrComFlt";
/*     */       case 3:
/*     */         str = "PwrSplyErrSts_BattRlyFlt";
/*     */       case 2:
/*     */         str = "PwrSplyErrSts_UloDurgdrvg";
/*     */       case 1:
/*     */         str = "PwrSplyErrSts_UhiDurgDrvg";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "PwrSplyErrSts_SysOk";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LVPwrSplyErrSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */