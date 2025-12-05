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
/*     */ public final class EpbReq
/*     */ {
/*     */   public static final int ApplyReq = 3;
/*     */   public static final int AutoApplyReq = 7;
/*     */   public static final int BrkPadWearAdjReq = 10;
/*     */   public static final int DAR_ReleaseReq = 6;
/*     */   public static final int DclBrkMechReq = 5;
/*     */   public static final int EmergencyApplyReq = 2;
/*     */   public static final int EpbBackupReq = 12;
/*     */   public static final int External_ApplyReq = 8;
/*     */   public static final int External_ReleaseReq = 9;
/*     */   public static final int HapPreparationReq = 11;
/*     */   public static final int NoRequest = 0;
/*     */   public static final int ReleaseReq = 4;
/*     */   public static final int Reserved_13 = 13;
/*     */   public static final int RollerTestBenchReq = 1;
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
/*     */         str = "Reserved_13";
/*     */       case 12:
/*     */         str = "EpbBackupReq";
/*     */       case 11:
/*     */         str = "HapPreparationReq";
/*     */       case 10:
/*     */         str = "BrkPadWearAdjReq";
/*     */       case 9:
/*     */         str = "External_ReleaseReq";
/*     */       case 8:
/*     */         str = "External_ApplyReq";
/*     */       case 7:
/*     */         str = "AutoApplyReq";
/*     */       case 6:
/*     */         str = "DAR_ReleaseReq";
/*     */       case 5:
/*     */         str = "DclBrkMechReq";
/*     */       case 4:
/*     */         str = "ReleaseReq";
/*     */       case 3:
/*     */         str = "ApplyReq";
/*     */       case 2:
/*     */         str = "EmergencyApplyReq";
/*     */       case 1:
/*     */         str = "RollerTestBenchReq";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\EpbReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */