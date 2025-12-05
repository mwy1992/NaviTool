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
/*     */ public final class AsyALgtSts
/*     */ {
/*     */   public static final int AccSts1_Active = 2;
/*     */   public static final int AccSts1_Override = 4;
/*     */   public static final int AccSts1_PermanentFailure = 8;
/*     */   public static final int AccSts1_StandActive = 5;
/*     */   public static final int AccSts1_StandBy = 1;
/*     */   public static final int AccSts1_StandWait = 6;
/*     */   public static final int AccSts1_TemporaryFailure = 7;
/*     */   public static final int Reserved1_0 = 0;
/*     */   public static final int Reserved2_3 = 3;
/*     */   public static final int Reserved3_9 = 9;
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
/*     */         str = "Reserved3_9";
/*     */       case 8:
/*     */         str = "AccSts1_PermanentFailure";
/*     */       case 7:
/*     */         str = "AccSts1_TemporaryFailure";
/*     */       case 6:
/*     */         str = "AccSts1_StandWait";
/*     */       case 5:
/*     */         str = "AccSts1_StandActive";
/*     */       case 4:
/*     */         str = "AccSts1_Override";
/*     */       case 3:
/*     */         str = "Reserved2_3";
/*     */       case 2:
/*     */         str = "AccSts1_Active";
/*     */       case 1:
/*     */         str = "AccSts1_StandBy";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Reserved1_0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AsyALgtSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */