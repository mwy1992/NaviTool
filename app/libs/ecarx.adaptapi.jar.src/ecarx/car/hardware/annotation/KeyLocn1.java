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
/*     */ public final class KeyLocn1
/*     */ {
/*     */   public static final int KeyLocnAll = 1;
/*     */   public static final int KeyLocnAllExt = 2;
/*     */   public static final int KeyLocnAllInt = 6;
/*     */   public static final int KeyLocnDrvrExt = 3;
/*     */   public static final int KeyLocnDrvrInt = 7;
/*     */   public static final int KeyLocnIdle = 0;
/*     */   public static final int KeyLocnPassExt = 4;
/*     */   public static final int KeyLocnPassInt = 8;
/*     */   public static final int KeyLocnResvInt = 9;
/*     */   public static final int KeyLocnResvIntSimple = 10;
/*     */   public static final int KeyLocnTrExt = 5;
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
/*     */         str = "KeyLocnResvIntSimple";
/*     */       case 9:
/*     */         str = "KeyLocnResvInt";
/*     */       case 8:
/*     */         str = "KeyLocnPassInt";
/*     */       case 7:
/*     */         str = "KeyLocnDrvrInt";
/*     */       case 6:
/*     */         str = "KeyLocnAllInt";
/*     */       case 5:
/*     */         str = "KeyLocnTrExt";
/*     */       case 4:
/*     */         str = "KeyLocnPassExt";
/*     */       case 3:
/*     */         str = "KeyLocnDrvrExt";
/*     */       case 2:
/*     */         str = "KeyLocnAllExt";
/*     */       case 1:
/*     */         str = "KeyLocnAll";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "KeyLocnIdle";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\KeyLocn1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */