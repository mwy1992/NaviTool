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
/*     */ public final class EpbDrvrDisp
/*     */ {
/*     */   public static final int Msg0 = 0;
/*     */   public static final int Msg10 = 10;
/*     */   public static final int Msg11 = 11;
/*     */   public static final int Msg12 = 12;
/*     */   public static final int Msg13 = 13;
/*     */   public static final int Msg14 = 14;
/*     */   public static final int Msg15 = 15;
/*     */   public static final int Msg3 = 3;
/*     */   public static final int Msg4 = 4;
/*     */   public static final int Msg5 = 5;
/*     */   public static final int Msg6 = 6;
/*     */   public static final int Msg8 = 8;
/*     */   public static final int Resd1 = 1;
/*     */   public static final int Resd2 = 2;
/*     */   public static final int Resd7 = 7;
/*     */   public static final int Resd9 = 9;
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
/*     */         str = "Msg15";
/*     */       case 14:
/*     */         str = "Msg14";
/*     */       case 13:
/*     */         str = "Msg13";
/*     */       case 12:
/*     */         str = "Msg12";
/*     */       case 11:
/*     */         str = "Msg11";
/*     */       case 10:
/*     */         str = "Msg10";
/*     */       case 9:
/*     */         str = "Resd9";
/*     */       case 8:
/*     */         str = "Msg8";
/*     */       case 7:
/*     */         str = "Resd7";
/*     */       case 6:
/*     */         str = "Msg6";
/*     */       case 5:
/*     */         str = "Msg5";
/*     */       case 4:
/*     */         str = "Msg4";
/*     */       case 3:
/*     */         str = "Msg3";
/*     */       case 2:
/*     */         str = "Resd2";
/*     */       case 1:
/*     */         str = "Resd1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Msg0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\EpbDrvrDisp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */