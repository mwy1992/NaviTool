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
/*     */ public final class AsyAutDrvgAvl
/*     */ {
/*     */   public static final int CannotReactivate = 18;
/*     */   public static final int DrvModSeldNotOk = 11;
/*     */   public static final int DrvrBucdRqrd = 6;
/*     */   public static final int DrvrDoorNotClsd = 7;
/*     */   public static final int DrvrNotInLoopDetd = 5;
/*     */   public static final int EndOfHndsOffAllwdArea = 16;
/*     */   public static final int EpbAppld = 12;
/*     */   public static final int GearNotInDrv = 8;
/*     */   public static final int HiSpd = 2;
/*     */   public static final int HldTiMaxExcdd = 10;
/*     */   public static final int LatCtrlNotAvl = 1;
/*     */   public static final int MltpleMonRoadReq = 15;
/*     */   public static final int NoMsg = 0;
/*     */   public static final int NotInUse1 = 19;
/*     */   public static final int OvrdTiMaxExcdd = 4;
/*     */   public static final int Reserved10_29 = 29;
/*     */   public static final int Reserved11_30 = 30;
/*     */   public static final int Reserved12_31 = 31;
/*     */   public static final int Reserved1_20 = 20;
/*     */   public static final int Reserved2_21 = 21;
/*     */   public static final int Reserved3_22 = 22;
/*     */   public static final int Reserved4_23 = 23;
/*     */   public static final int Reserved5_24 = 24;
/*     */   public static final int Reserved6_25 = 25;
/*     */   public static final int Reserved7_26 = 26;
/*     */   public static final int Reserved8_27 = 27;
/*     */   public static final int Reserved9_28 = 28;
/*     */   public static final int RoadMonWm = 17;
/*     */   public static final int SnsrBlkd = 9;
/*     */   public static final int SpdLowLimExcdd = 13;
/*     */   public static final int TrlrPrsnt = 14;
/*     */   public static final int VehToFolwMiss = 3;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  50 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  51 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 149 */         return str;
/*     */       case 31:
/*     */         str = "Reserved12_31";
/*     */       case 30:
/*     */         str = "Reserved11_30";
/*     */       case 29:
/*     */         str = "Reserved10_29";
/*     */       case 28:
/*     */         str = "Reserved9_28";
/*     */       case 27:
/*     */         str = "Reserved8_27";
/*     */       case 26:
/*     */         str = "Reserved7_26";
/*     */       case 25:
/*     */         str = "Reserved6_25";
/*     */       case 24:
/*     */         str = "Reserved5_24";
/*     */       case 23:
/*     */         str = "Reserved4_23";
/*     */       case 22:
/*     */         str = "Reserved3_22";
/*     */       case 21:
/*     */         str = "Reserved2_21";
/*     */       case 20:
/*     */         str = "Reserved1_20";
/*     */       case 19:
/*     */         str = "NotInUse1";
/*     */       case 18:
/*     */         str = "CannotReactivate";
/*     */       case 17:
/*     */         str = "RoadMonWm";
/*     */       case 16:
/*     */         str = "EndOfHndsOffAllwdArea";
/*     */       case 15:
/*     */         str = "MltpleMonRoadReq";
/*     */       case 14:
/*     */         str = "TrlrPrsnt";
/*     */       case 13:
/*     */         str = "SpdLowLimExcdd";
/*     */       case 12:
/*     */         str = "EpbAppld";
/*     */       case 11:
/*     */         str = "DrvModSeldNotOk";
/*     */       case 10:
/*     */         str = "HldTiMaxExcdd";
/*     */       case 9:
/*     */         str = "SnsrBlkd";
/*     */       case 8:
/*     */         str = "GearNotInDrv";
/*     */       case 7:
/*     */         str = "DrvrDoorNotClsd";
/*     */       case 6:
/*     */         str = "DrvrBucdRqrd";
/*     */       case 5:
/*     */         str = "DrvrNotInLoopDetd";
/*     */       case 4:
/*     */         str = "OvrdTiMaxExcdd";
/*     */       case 3:
/*     */         str = "VehToFolwMiss";
/*     */       case 2:
/*     */         str = "HiSpd";
/*     */       case 1:
/*     */         str = "LatCtrlNotAvl";
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
/* 228 */     boolean bool = false;
/*     */     
/* 230 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 262 */       bool = true;
/*     */     }
/*     */     
/* 265 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AsyAutDrvgAvl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */