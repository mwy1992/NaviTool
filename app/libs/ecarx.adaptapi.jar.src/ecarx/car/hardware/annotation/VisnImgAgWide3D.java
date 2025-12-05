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
/*     */ public final class VisnImgAgWide3D
/*     */ {
/*     */   public static final int Notactive = 0;
/*     */   public static final int pre3DFront = 1;
/*     */   public static final int pre3DLeft = 3;
/*     */   public static final int pre3DLeftFront = 5;
/*     */   public static final int pre3DLeftRear = 7;
/*     */   public static final int pre3DRear = 4;
/*     */   public static final int pre3DRight = 2;
/*     */   public static final int pre3DRightFront = 6;
/*     */   public static final int pre3DRightRear = 8;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  25 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  26 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  55 */         return str;
/*     */       case 8:
/*     */         str = "pre3DRightRear";
/*     */       case 7:
/*     */         str = "pre3DLeftRear";
/*     */       case 6:
/*     */         str = "pre3DRightFront";
/*     */       case 5:
/*     */         str = "pre3DLeftFront";
/*     */       case 4:
/*     */         str = "pre3DRear";
/*     */       case 3:
/*     */         str = "pre3DLeft";
/*     */       case 2:
/*     */         str = "pre3DRight";
/*     */       case 1:
/*     */         str = "pre3DFront";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Notactive";
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
/*  88 */     boolean bool = false;
/*     */     
/*  90 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       bool = true;
/*     */     }
/*     */     
/* 102 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VisnImgAgWide3D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */