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
/*     */ public final class LockActvnSafe1
/*     */ {
/*     */   public static final int LockActvnLock = 2;
/*     */   public static final int LockActvnOff = 0;
/*     */   public static final int LockActvnSafe = 3;
/*     */   public static final int LockActvnUnlck = 1;
/*     */   public static final int LockActvnUnlckByCrash0 = 12;
/*     */   public static final int LockActvnUnlckByCrash1 = 4;
/*     */   public static final int LockActvnUnlckByCrash2 = 8;
/*     */   public static final int LockActvnUnlckByCrash3 = 14;
/*     */   public static final int LockActvnUnlckByCrash4 = 13;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  27 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  28 */     if (paramInt != 8) { switch (paramInt) { default: switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             default:
/*  57 */               return str;
/*     */             case 14:
/*     */               str = "LockActvnUnlckByCrash3";
/*     */             case 13:
/*     */               str = "LockActvnUnlckByCrash4";
/*     */             case 12:
/*     */               break;
/*     */           } 
/*     */           str = "LockActvnUnlckByCrash0";
/*     */         case 4:
/*     */           str = "LockActvnUnlckByCrash1";
/*     */         case 3:
/*     */           str = "LockActvnSafe";
/*     */         case 2:
/*     */           str = "LockActvnLock";
/*     */         case 1:
/*     */           str = "LockActvnUnlck";
/*     */         case 0:
/*     */           break; }
/*     */       
/*     */       str = "LockActvnOff"; }
/*     */     
/*     */     str = "LockActvnUnlckByCrash2";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isValid(int paramInt) {
/*  90 */     boolean bool = false;
/*     */     
/*  92 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 8 || paramInt == 12 || paramInt == 13 || paramInt == 14)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       bool = true;
/*     */     }
/*     */     
/* 104 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LockActvnSafe1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */