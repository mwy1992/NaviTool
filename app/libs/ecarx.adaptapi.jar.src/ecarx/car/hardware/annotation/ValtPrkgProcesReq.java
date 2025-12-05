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
/*     */ public final class ValtPrkgProcesReq
/*     */ {
/*     */   public static final int AppropriateLightStatusRequirment = 6;
/*     */   public static final int EPBRequirement = 5;
/*     */   public static final int GearPRequirement = 3;
/*     */   public static final int LocalizationProcess = 2;
/*     */   public static final int MapChooseOrDeleteOrNew = 1;
/*     */   public static final int MapGenerating = 17;
/*     */   public static final int MapGeneratingFail = 18;
/*     */   public static final int MapGeneratingSuccessfully = 19;
/*     */   public static final int MobileConnectOrActivateRequirement = 4;
/*     */   public static final int NoRequest = 0;
/*     */   public static final int ParkOutLearning_moving = 15;
/*     */   public static final int ParkOutLearning_standstill = 16;
/*     */   public static final int ParkingFunctionTypeChoosingForNewMap = 10;
/*     */   public static final int ParkingProcessFail = 9;
/*     */   public static final int ParkingProcessFinishSuccessfully = 8;
/*     */   public static final int ParkingProcessIsOnGoing = 7;
/*     */   public static final int SlotConfirmForNewMap = 13;
/*     */   public static final int SlotHasBeenSearchedForNewMap = 12;
/*     */   public static final int SlotLearningSuccessfully = 14;
/*     */   public static final int SlotSearchingForNewMap = 11;
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
/*     */         str = "MapGeneratingSuccessfully";
/*     */       case 18:
/*     */         str = "MapGeneratingFail";
/*     */       case 17:
/*     */         str = "MapGenerating";
/*     */       case 16:
/*     */         str = "ParkOutLearning_standstill";
/*     */       case 15:
/*     */         str = "ParkOutLearning_moving";
/*     */       case 14:
/*     */         str = "SlotLearningSuccessfully";
/*     */       case 13:
/*     */         str = "SlotConfirmForNewMap";
/*     */       case 12:
/*     */         str = "SlotHasBeenSearchedForNewMap";
/*     */       case 11:
/*     */         str = "SlotSearchingForNewMap";
/*     */       case 10:
/*     */         str = "ParkingFunctionTypeChoosingForNewMap";
/*     */       case 9:
/*     */         str = "ParkingProcessFail";
/*     */       case 8:
/*     */         str = "ParkingProcessFinishSuccessfully";
/*     */       case 7:
/*     */         str = "ParkingProcessIsOnGoing";
/*     */       case 6:
/*     */         str = "AppropriateLightStatusRequirment";
/*     */       case 5:
/*     */         str = "EPBRequirement";
/*     */       case 4:
/*     */         str = "MobileConnectOrActivateRequirement";
/*     */       case 3:
/*     */         str = "GearPRequirement";
/*     */       case 2:
/*     */         str = "LocalizationProcess";
/*     */       case 1:
/*     */         str = "MapChooseOrDeleteOrNew";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoRequest";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ValtPrkgProcesReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */