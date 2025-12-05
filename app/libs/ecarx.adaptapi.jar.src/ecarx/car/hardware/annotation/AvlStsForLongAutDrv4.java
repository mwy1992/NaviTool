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
/*     */ public final class AvlStsForLongAutDrv4
/*     */ {
/*     */   public static final int AccCncl = 2;
/*     */   public static final int DrvModSeldNotOk = 12;
/*     */   public static final int DrvrBucdRqrd = 4;
/*     */   public static final int DrvrDoorNotClsd = 5;
/*     */   public static final int EpbAppld = 13;
/*     */   public static final int GearNeut = 7;
/*     */   public static final int GearNotInDrv = 6;
/*     */   public static final int HldTiMaxExcdd = 9;
/*     */   public static final int LgtCtrlNotAvl = 1;
/*     */   public static final int NoMsg = 0;
/*     */   public static final int NoVehAhd = 3;
/*     */   public static final int OvrdTiMaxExcdd = 10;
/*     */   public static final int SnsrBlkd = 8;
/*     */   public static final int SpdLowLimExcdd = 11;
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
/*     */         str = "EpbAppld";
/*     */       case 12:
/*     */         str = "DrvModSeldNotOk";
/*     */       case 11:
/*     */         str = "SpdLowLimExcdd";
/*     */       case 10:
/*     */         str = "OvrdTiMaxExcdd";
/*     */       case 9:
/*     */         str = "HldTiMaxExcdd";
/*     */       case 8:
/*     */         str = "SnsrBlkd";
/*     */       case 7:
/*     */         str = "GearNeut";
/*     */       case 6:
/*     */         str = "GearNotInDrv";
/*     */       case 5:
/*     */         str = "DrvrDoorNotClsd";
/*     */       case 4:
/*     */         str = "DrvrBucdRqrd";
/*     */       case 3:
/*     */         str = "NoVehAhd";
/*     */       case 2:
/*     */         str = "AccCncl";
/*     */       case 1:
/*     */         str = "LgtCtrlNotAvl";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoMsg";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AvlStsForLongAutDrv4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */