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
/*     */ public final class EpbSts
/*     */ {
/*     */   public static final int ActrAllReld = 9;
/*     */   public static final int AllAppld = 3;
/*     */   public static final int AllInTran = 5;
/*     */   public static final int BrkgDyn = 12;
/*     */   public static final int BrkgDynByActr = 6;
/*     */   public static final int BrkgDynDegraded = 10;
/*     */   public static final int Err = 15;
/*     */   public static final int Resd0 = 0;
/*     */   public static final int Resd1 = 1;
/*     */   public static final int Resd11 = 11;
/*     */   public static final int Resd13 = 13;
/*     */   public static final int Resd14 = 14;
/*     */   public static final int Resd2 = 2;
/*     */   public static final int Resd4 = 4;
/*     */   public static final int Resd7 = 7;
/*     */   public static final int Resd8 = 8;
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
/*     */         str = "Err";
/*     */       case 14:
/*     */         str = "Resd14";
/*     */       case 13:
/*     */         str = "Resd13";
/*     */       case 12:
/*     */         str = "BrkgDyn";
/*     */       case 11:
/*     */         str = "Resd11";
/*     */       case 10:
/*     */         str = "BrkgDynDegraded";
/*     */       case 9:
/*     */         str = "ActrAllReld";
/*     */       case 8:
/*     */         str = "Resd8";
/*     */       case 7:
/*     */         str = "Resd7";
/*     */       case 6:
/*     */         str = "BrkgDynByActr";
/*     */       case 5:
/*     */         str = "AllInTran";
/*     */       case 4:
/*     */         str = "Resd4";
/*     */       case 3:
/*     */         str = "AllAppld";
/*     */       case 2:
/*     */         str = "Resd2";
/*     */       case 1:
/*     */         str = "Resd1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Resd0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\EpbSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */