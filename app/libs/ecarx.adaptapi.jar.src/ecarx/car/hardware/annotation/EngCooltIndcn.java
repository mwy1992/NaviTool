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
/*     */ public final class EngCooltIndcn
/*     */ {
/*     */   public static final int CooltLvlLoToEngStop = 5;
/*     */   public static final int CooltLvlLoToLvlChk = 8;
/*     */   public static final int CooltLvlLoToMan = 7;
/*     */   public static final int CooltLvlLoToStopSafe = 6;
/*     */   public static final int EngTHiToEngStop = 3;
/*     */   public static final int EngTHiToMan = 4;
/*     */   public static final int EngTHiToSpdRedn = 1;
/*     */   public static final int EngTHiToStopSafe = 2;
/*     */   public static final int MsgNoWarn = 0;
/*     */   public static final int MsgSrvRqrd = 9;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  28 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  29 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  61 */         return str;
/*     */       case 9:
/*     */         str = "MsgSrvRqrd";
/*     */       case 8:
/*     */         str = "CooltLvlLoToLvlChk";
/*     */       case 7:
/*     */         str = "CooltLvlLoToMan";
/*     */       case 6:
/*     */         str = "CooltLvlLoToStopSafe";
/*     */       case 5:
/*     */         str = "CooltLvlLoToEngStop";
/*     */       case 4:
/*     */         str = "EngTHiToMan";
/*     */       case 3:
/*     */         str = "EngTHiToEngStop";
/*     */       case 2:
/*     */         str = "EngTHiToStopSafe";
/*     */       case 1:
/*     */         str = "EngTHiToSpdRedn";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "MsgNoWarn";
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
/*  96 */     boolean bool = false;
/*     */     
/*  98 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       bool = true;
/*     */     }
/*     */     
/* 111 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\EngCooltIndcn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */