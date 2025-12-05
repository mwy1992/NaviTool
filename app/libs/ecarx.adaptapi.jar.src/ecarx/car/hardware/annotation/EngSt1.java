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
/*     */ public final class EngSt1
/*     */ {
/*     */   public static final int AftRun = 9;
/*     */   public static final int Awake = 1;
/*     */   public static final int Ini = 0;
/*     */   public static final int PreStrtg = 3;
/*     */   public static final int Rdy = 2;
/*     */   public static final int RunngRemStrtd = 8;
/*     */   public static final int RunngRunng = 5;
/*     */   public static final int RunngStb = 6;
/*     */   public static final int RunngStrtgInProgs = 7;
/*     */   public static final int StrtgInProgs = 4;
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
/*     */         str = "AftRun";
/*     */       case 8:
/*     */         str = "RunngRemStrtd";
/*     */       case 7:
/*     */         str = "RunngStrtgInProgs";
/*     */       case 6:
/*     */         str = "RunngStb";
/*     */       case 5:
/*     */         str = "RunngRunng";
/*     */       case 4:
/*     */         str = "StrtgInProgs";
/*     */       case 3:
/*     */         str = "PreStrtg";
/*     */       case 2:
/*     */         str = "Rdy";
/*     */       case 1:
/*     */         str = "Awake";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Ini";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\EngSt1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */