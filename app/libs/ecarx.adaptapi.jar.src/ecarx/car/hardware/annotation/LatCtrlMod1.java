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
/*     */ public final class LatCtrlMod1
/*     */ {
/*     */   public static final int APA = 13;
/*     */   public static final int DsrMueSplit = 7;
/*     */   public static final int DsrOversteer = 6;
/*     */   public static final int DsrTrlrStaby = 8;
/*     */   public static final int EmgyLaneKeepAidForObjRe = 2;
/*     */   public static final int EmgyLaneKeepAidForStat = 3;
/*     */   public static final int EmgyManvAssi = 9;
/*     */   public static final int HPA = 15;
/*     */   public static final int HighWayAssist = 1;
/*     */   public static final int NoReq = 0;
/*     */   public static final int RPA = 14;
/*     */   public static final int Reserved1_10 = 10;
/*     */   public static final int Reserved2_11 = 11;
/*     */   public static final int SHWA = 12;
/*     */   public static final int SftyLaneKeepAid = 4;
/*     */   public static final int SteerAssc = 5;
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
/*     */         str = "HPA";
/*     */       case 14:
/*     */         str = "RPA";
/*     */       case 13:
/*     */         str = "APA";
/*     */       case 12:
/*     */         str = "SHWA";
/*     */       case 11:
/*     */         str = "Reserved2_11";
/*     */       case 10:
/*     */         str = "Reserved1_10";
/*     */       case 9:
/*     */         str = "EmgyManvAssi";
/*     */       case 8:
/*     */         str = "DsrTrlrStaby";
/*     */       case 7:
/*     */         str = "DsrMueSplit";
/*     */       case 6:
/*     */         str = "DsrOversteer";
/*     */       case 5:
/*     */         str = "SteerAssc";
/*     */       case 4:
/*     */         str = "SftyLaneKeepAid";
/*     */       case 3:
/*     */         str = "EmgyLaneKeepAidForStat";
/*     */       case 2:
/*     */         str = "EmgyLaneKeepAidForObjRe";
/*     */       case 1:
/*     */         str = "HighWayAssist";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoReq";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LatCtrlMod1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */