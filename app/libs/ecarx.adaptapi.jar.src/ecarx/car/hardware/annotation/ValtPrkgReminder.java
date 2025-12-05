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
/*     */ public final class ValtPrkgReminder
/*     */ {
/*     */   public static final int ConnectOvertime_FunctionExit = 5;
/*     */   public static final int DoorsAreOpen_FunctionExit = 11;
/*     */   public static final int DoorsOrHoodOrTailgateOrRearviewMirrorUnanticipatedStatus_PleaseShowOnCarModel = 14;
/*     */   public static final int EnvironmentUnavailable_FunctionExit = 4;
/*     */   public static final int FunctionExit = 2;
/*     */   public static final int HoodIsOpen_FunctionExit = 9;
/*     */   public static final int LearningDistanceBeyondLimit_FunctionExit = 7;
/*     */   public static final int LearningTimeBeyondLimit_FunctionExit = 8;
/*     */   public static final int LocalizationFailure_FunctionExit = 13;
/*     */   public static final int NetwokUnavailable_FunctionExit = 3;
/*     */   public static final int NoFault = 0;
/*     */   public static final int Overspeed_FunctionExit = 6;
/*     */   public static final int PleaseSlowDown = 15;
/*     */   public static final int RearviewMirrorsAreFold_FunctionExit = 12;
/*     */   public static final int SystemFailure_FunctionUnavailable = 1;
/*     */   public static final int TailgateIsOpen_FunctionExit = 10;
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
/*     */         str = "PleaseSlowDown";
/*     */       case 14:
/*     */         str = "DoorsOrHoodOrTailgateOrRearviewMirrorUnanticipatedStatus_PleaseShowOnCarModel";
/*     */       case 13:
/*     */         str = "LocalizationFailure_FunctionExit";
/*     */       case 12:
/*     */         str = "RearviewMirrorsAreFold_FunctionExit";
/*     */       case 11:
/*     */         str = "DoorsAreOpen_FunctionExit";
/*     */       case 10:
/*     */         str = "TailgateIsOpen_FunctionExit";
/*     */       case 9:
/*     */         str = "HoodIsOpen_FunctionExit";
/*     */       case 8:
/*     */         str = "LearningTimeBeyondLimit_FunctionExit";
/*     */       case 7:
/*     */         str = "LearningDistanceBeyondLimit_FunctionExit";
/*     */       case 6:
/*     */         str = "Overspeed_FunctionExit";
/*     */       case 5:
/*     */         str = "ConnectOvertime_FunctionExit";
/*     */       case 4:
/*     */         str = "EnvironmentUnavailable_FunctionExit";
/*     */       case 3:
/*     */         str = "NetwokUnavailable_FunctionExit";
/*     */       case 2:
/*     */         str = "FunctionExit";
/*     */       case 1:
/*     */         str = "SystemFailure_FunctionUnavailable";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoFault";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ValtPrkgReminder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */