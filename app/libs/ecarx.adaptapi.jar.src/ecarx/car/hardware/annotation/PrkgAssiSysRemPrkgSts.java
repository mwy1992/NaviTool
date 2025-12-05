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
/*     */ public final class PrkgAssiSysRemPrkgSts
/*     */ {
/*     */   public static final int Abort = 8;
/*     */   public static final int Cancel = 14;
/*     */   public static final int Failure = 13;
/*     */   public static final int OFF = 0;
/*     */   public static final int Parkprocessactive = 6;
/*     */   public static final int Quit = 12;
/*     */   public static final int Remoteparkactive = 5;
/*     */   public static final int Remoteparkcompleted = 11;
/*     */   public static final int Remoteparkinpreactive = 4;
/*     */   public static final int Remoteparkinstandby = 1;
/*     */   public static final int Remoteparkoutprocscompleted = 10;
/*     */   public static final int Remoteparkoutstandby = 2;
/*     */   public static final int Remoteparkprocesscompleted = 9;
/*     */   public static final int Searching = 3;
/*     */   public static final int Suspend = 7;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  33 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  34 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  81 */         return str;
/*     */       case 14:
/*     */         str = "Cancel";
/*     */       case 13:
/*     */         str = "Failure";
/*     */       case 12:
/*     */         str = "Quit";
/*     */       case 11:
/*     */         str = "Remoteparkcompleted";
/*     */       case 10:
/*     */         str = "Remoteparkoutprocscompleted";
/*     */       case 9:
/*     */         str = "Remoteparkprocesscompleted";
/*     */       case 8:
/*     */         str = "Abort";
/*     */       case 7:
/*     */         str = "Suspend";
/*     */       case 6:
/*     */         str = "Parkprocessactive";
/*     */       case 5:
/*     */         str = "Remoteparkactive";
/*     */       case 4:
/*     */         str = "Remoteparkinpreactive";
/*     */       case 3:
/*     */         str = "Searching";
/*     */       case 2:
/*     */         str = "Remoteparkoutstandby";
/*     */       case 1:
/*     */         str = "Remoteparkinstandby";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "OFF";
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
/* 126 */     boolean bool = false;
/*     */     
/* 128 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14)
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
/* 143 */       bool = true;
/*     */     }
/*     */     
/* 146 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PrkgAssiSysRemPrkgSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */