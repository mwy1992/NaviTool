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
/*     */ public final class RPAOutModeSubT
/*     */ {
/*     */   public static final int HeadPrpndLeOut = 4;
/*     */   public static final int HeadPrpndRiOut = 3;
/*     */   public static final int Idle = 0;
/*     */   public static final int PrlRiOut = 1;
/*     */   public static final int Resd1 = 7;
/*     */   public static final int Resd2 = 8;
/*     */   public static final int RrlLeOut = 2;
/*     */   public static final int TailPrpndLeOut = 6;
/*     */   public static final int TailPrpndRiOut = 5;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  27 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  28 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  57 */         return str;
/*     */       case 8:
/*     */         str = "Resd2";
/*     */       case 7:
/*     */         str = "Resd1";
/*     */       case 6:
/*     */         str = "TailPrpndLeOut";
/*     */       case 5:
/*     */         str = "TailPrpndRiOut";
/*     */       case 4:
/*     */         str = "HeadPrpndLeOut";
/*     */       case 3:
/*     */         str = "HeadPrpndRiOut";
/*     */       case 2:
/*     */         str = "RrlLeOut";
/*     */       case 1:
/*     */         str = "PrlRiOut";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Idle";
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
/*  90 */     boolean bool = false;
/*     */     
/*  92 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       bool = true;
/*     */     }
/*     */     
/* 104 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RPAOutModeSubT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */