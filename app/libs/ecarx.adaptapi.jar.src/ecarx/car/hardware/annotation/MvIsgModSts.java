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
/*     */ public final class MvIsgModSts
/*     */ {
/*     */   public static final int DchrgActv = 33;
/*     */   public static final int DchrgDone = 34;
/*     */   public static final int DchrgFlt = 35;
/*     */   public static final int DchrgOutOfRng = 36;
/*     */   public static final int ESAActv = 28;
/*     */   public static final int ESADone = 29;
/*     */   public static final int ESAFlt = 30;
/*     */   public static final int ESAInhb = 32;
/*     */   public static final int ESAOutOfRng = 31;
/*     */   public static final int GenrDerating = 20;
/*     */   public static final int GenrFlt = 18;
/*     */   public static final int GenrMax = 21;
/*     */   public static final int GenrOutOfRng = 19;
/*     */   public static final int Inin = 0;
/*     */   public static final int IninFlt = 8;
/*     */   public static final int PwrDwn = 6;
/*     */   public static final int Reserved1_5 = 5;
/*     */   public static final int Reserved2_7 = 7;
/*     */   public static final int Reserved3_9 = 9;
/*     */   public static final int Reserved4_10 = 10;
/*     */   public static final int Reserved5_17 = 17;
/*     */   public static final int Reserved6_22 = 22;
/*     */   public static final int Reserved7_37 = 37;
/*     */   public static final int SpdCtrl = 3;
/*     */   public static final int SpdCtrlDerating = 26;
/*     */   public static final int SpdCtrlFlt = 23;
/*     */   public static final int SpdCtrlInhb = 25;
/*     */   public static final int SpdCtrlMax = 27;
/*     */   public static final int SpdCtrlOutOfRng = 24;
/*     */   public static final int Stb = 1;
/*     */   public static final int StrtActv = 11;
/*     */   public static final int StrtDone = 12;
/*     */   public static final int StrtFlt = 14;
/*     */   public static final int StrtIdl = 13;
/*     */   public static final int StrtInhb = 16;
/*     */   public static final int StrtOutOfRng = 15;
/*     */   public static final int TqCtrl = 2;
/*     */   public static final int TqCtrlDetrating = 42;
/*     */   public static final int TqCtrlFlt = 39;
/*     */   public static final int TqCtrlIdl = 38;
/*     */   public static final int TqCtrlInhb = 41;
/*     */   public static final int TqCtrlMax = 43;
/*     */   public static final int TqCtrlOutOfRng = 40;
/*     */   public static final int UDcCtrl = 4;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  62 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  63 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 197 */         return str;
/*     */       case 43:
/*     */         str = "TqCtrlMax";
/*     */       case 42:
/*     */         str = "TqCtrlDetrating";
/*     */       case 41:
/*     */         str = "TqCtrlInhb";
/*     */       case 40:
/*     */         str = "TqCtrlOutOfRng";
/*     */       case 39:
/*     */         str = "TqCtrlFlt";
/*     */       case 38:
/*     */         str = "TqCtrlIdl";
/*     */       case 37:
/*     */         str = "Reserved7_37";
/*     */       case 36:
/*     */         str = "DchrgOutOfRng";
/*     */       case 35:
/*     */         str = "DchrgFlt";
/*     */       case 34:
/*     */         str = "DchrgDone";
/*     */       case 33:
/*     */         str = "DchrgActv";
/*     */       case 32:
/*     */         str = "ESAInhb";
/*     */       case 31:
/*     */         str = "ESAOutOfRng";
/*     */       case 30:
/*     */         str = "ESAFlt";
/*     */       case 29:
/*     */         str = "ESADone";
/*     */       case 28:
/*     */         str = "ESAActv";
/*     */       case 27:
/*     */         str = "SpdCtrlMax";
/*     */       case 26:
/*     */         str = "SpdCtrlDerating";
/*     */       case 25:
/*     */         str = "SpdCtrlInhb";
/*     */       case 24:
/*     */         str = "SpdCtrlOutOfRng";
/*     */       case 23:
/*     */         str = "SpdCtrlFlt";
/*     */       case 22:
/*     */         str = "Reserved6_22";
/*     */       case 21:
/*     */         str = "GenrMax";
/*     */       case 20:
/*     */         str = "GenrDerating";
/*     */       case 19:
/*     */         str = "GenrOutOfRng";
/*     */       case 18:
/*     */         str = "GenrFlt";
/*     */       case 17:
/*     */         str = "Reserved5_17";
/*     */       case 16:
/*     */         str = "StrtInhb";
/*     */       case 15:
/*     */         str = "StrtOutOfRng";
/*     */       case 14:
/*     */         str = "StrtFlt";
/*     */       case 13:
/*     */         str = "StrtIdl";
/*     */       case 12:
/*     */         str = "StrtDone";
/*     */       case 11:
/*     */         str = "StrtActv";
/*     */       case 10:
/*     */         str = "Reserved4_10";
/*     */       case 9:
/*     */         str = "Reserved3_9";
/*     */       case 8:
/*     */         str = "IninFlt";
/*     */       case 7:
/*     */         str = "Reserved2_7";
/*     */       case 6:
/*     */         str = "PwrDwn";
/*     */       case 5:
/*     */         str = "Reserved1_5";
/*     */       case 4:
/*     */         str = "UDcCtrl";
/*     */       case 3:
/*     */         str = "SpdCtrl";
/*     */       case 2:
/*     */         str = "TqCtrl";
/*     */       case 1:
/*     */         str = "Stb";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Inin";
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
/* 300 */     boolean bool = false;
/*     */     
/* 302 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31 || paramInt == 32 || paramInt == 33 || paramInt == 34 || paramInt == 35 || paramInt == 36 || paramInt == 37 || paramInt == 38 || paramInt == 39 || paramInt == 40 || paramInt == 41 || paramInt == 42 || paramInt == 43)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 346 */       bool = true;
/*     */     }
/*     */     
/* 349 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MvIsgModSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */