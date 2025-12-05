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
/*     */ public final class LockTrigSrc2
/*     */ {
/*     */   public static final int Apprch = 9;
/*     */   public static final int Crash = 8;
/*     */   public static final int InsOth = 11;
/*     */   public static final int IntrSwt = 3;
/*     */   public static final int KeyRem = 1;
/*     */   public static final int Keyls = 2;
/*     */   public static final int NoTrigSrc = 0;
/*     */   public static final int OutsOth = 10;
/*     */   public static final int Slam = 6;
/*     */   public static final int SpdAut = 4;
/*     */   public static final int Telm = 7;
/*     */   public static final int TmrAut = 5;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  30 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  31 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  69 */         return str;
/*     */       case 11:
/*     */         str = "InsOth";
/*     */       case 10:
/*     */         str = "OutsOth";
/*     */       case 9:
/*     */         str = "Apprch";
/*     */       case 8:
/*     */         str = "Crash";
/*     */       case 7:
/*     */         str = "Telm";
/*     */       case 6:
/*     */         str = "Slam";
/*     */       case 5:
/*     */         str = "TmrAut";
/*     */       case 4:
/*     */         str = "SpdAut";
/*     */       case 3:
/*     */         str = "IntrSwt";
/*     */       case 2:
/*     */         str = "Keyls";
/*     */       case 1:
/*     */         str = "KeyRem";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoTrigSrc";
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
/* 108 */     boolean bool = false;
/*     */     
/* 110 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11)
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
/* 122 */       bool = true;
/*     */     }
/*     */     
/* 125 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LockTrigSrc2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */