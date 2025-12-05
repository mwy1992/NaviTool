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
/*     */ public final class DoorOpenerSts
/*     */ {
/*     */   public static final int FullClsd = 1;
/*     */   public static final int FullOpend = 5;
/*     */   public static final int HalfClsd = 9;
/*     */   public static final int MovgIn = 6;
/*     */   public static final int MovgInBrkg = 7;
/*     */   public static final int MovgOut = 2;
/*     */   public static final int MovgOutBrkg = 3;
/*     */   public static final int StopDurgCls = 8;
/*     */   public static final int StopDurgOpen = 4;
/*     */   public static final int StopMinPntForCls = 10;
/*     */   public static final int Ukwn = 0;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  29 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  30 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  65 */         return str;
/*     */       case 10:
/*     */         str = "StopMinPntForCls";
/*     */       case 9:
/*     */         str = "HalfClsd";
/*     */       case 8:
/*     */         str = "StopDurgCls";
/*     */       case 7:
/*     */         str = "MovgInBrkg";
/*     */       case 6:
/*     */         str = "MovgIn";
/*     */       case 5:
/*     */         str = "FullOpend";
/*     */       case 4:
/*     */         str = "StopDurgOpen";
/*     */       case 3:
/*     */         str = "MovgOutBrkg";
/*     */       case 2:
/*     */         str = "MovgOut";
/*     */       case 1:
/*     */         str = "FullClsd";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Ukwn";
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
/* 102 */     boolean bool = false;
/*     */     
/* 104 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10)
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
/* 115 */       bool = true;
/*     */     }
/*     */     
/* 118 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DoorOpenerSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */