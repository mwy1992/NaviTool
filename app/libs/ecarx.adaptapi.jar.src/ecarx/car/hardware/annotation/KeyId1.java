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
/*     */ public final class KeyId1
/*     */ {
/*     */   public static final int Key0 = 0;
/*     */   public static final int Key1 = 1;
/*     */   public static final int Key10 = 10;
/*     */   public static final int Key11 = 11;
/*     */   public static final int Key2 = 2;
/*     */   public static final int Key3 = 3;
/*     */   public static final int Key4 = 4;
/*     */   public static final int Key5 = 5;
/*     */   public static final int Key6 = 6;
/*     */   public static final int Key7 = 7;
/*     */   public static final int Key8 = 8;
/*     */   public static final int Key9 = 9;
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
/*     */         str = "Key11";
/*     */       case 10:
/*     */         str = "Key10";
/*     */       case 9:
/*     */         str = "Key9";
/*     */       case 8:
/*     */         str = "Key8";
/*     */       case 7:
/*     */         str = "Key7";
/*     */       case 6:
/*     */         str = "Key6";
/*     */       case 5:
/*     */         str = "Key5";
/*     */       case 4:
/*     */         str = "Key4";
/*     */       case 3:
/*     */         str = "Key3";
/*     */       case 2:
/*     */         str = "Key2";
/*     */       case 1:
/*     */         str = "Key1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Key0";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\KeyId1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */