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
/*     */ public final class ProfileId
/*     */ {
/*     */   public static final int Profile0 = 0;
/*     */   public static final int Profile1 = 1;
/*     */   public static final int Profile10 = 10;
/*     */   public static final int Profile11 = 11;
/*     */   public static final int Profile2 = 2;
/*     */   public static final int Profile3 = 3;
/*     */   public static final int Profile4 = 4;
/*     */   public static final int Profile5 = 5;
/*     */   public static final int Profile6 = 6;
/*     */   public static final int Profile7 = 7;
/*     */   public static final int Profile8 = 8;
/*     */   public static final int Profile9 = 9;
/*     */   public static final int ProfileCarsharing = 12;
/*     */   public static final int ProfileDefault = 13;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/*  75 */         return str;
/*     */       case 13:
/*     */         str = "ProfileDefault";
/*     */       case 12:
/*     */         str = "ProfileCarsharing";
/*     */       case 11:
/*     */         str = "Profile11";
/*     */       case 10:
/*     */         str = "Profile10";
/*     */       case 9:
/*     */         str = "Profile9";
/*     */       case 8:
/*     */         str = "Profile8";
/*     */       case 7:
/*     */         str = "Profile7";
/*     */       case 6:
/*     */         str = "Profile6";
/*     */       case 5:
/*     */         str = "Profile5";
/*     */       case 4:
/*     */         str = "Profile4";
/*     */       case 3:
/*     */         str = "Profile3";
/*     */       case 2:
/*     */         str = "Profile2";
/*     */       case 1:
/*     */         str = "Profile1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Profile0";
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
/* 118 */     boolean bool = false;
/*     */     
/* 120 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13)
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
/* 134 */       bool = true;
/*     */     }
/*     */     
/* 137 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ProfileId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */