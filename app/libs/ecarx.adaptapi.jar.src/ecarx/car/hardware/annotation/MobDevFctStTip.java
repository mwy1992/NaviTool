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
/*     */ public final class MobDevFctStTip
/*     */ {
/*     */   public static final int Continue = 7;
/*     */   public static final int Default = 0;
/*     */   public static final int NotToSearch = 6;
/*     */   public static final int OutToRange = 8;
/*     */   public static final int Parking = 5;
/*     */   public static final int PushButtonStartSearchParkingSlot = 1;
/*     */   public static final int Searching = 2;
/*     */   public static final int StartParkingIn = 3;
/*     */   public static final int StartParkingOut = 4;
/*     */   public static final int TheftProtection = 9;
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
/*     */         str = "TheftProtection";
/*     */       case 8:
/*     */         str = "OutToRange";
/*     */       case 7:
/*     */         str = "Continue";
/*     */       case 6:
/*     */         str = "NotToSearch";
/*     */       case 5:
/*     */         str = "Parking";
/*     */       case 4:
/*     */         str = "StartParkingOut";
/*     */       case 3:
/*     */         str = "StartParkingIn";
/*     */       case 2:
/*     */         str = "Searching";
/*     */       case 1:
/*     */         str = "PushButtonStartSearchParkingSlot";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Default";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MobDevFctStTip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */