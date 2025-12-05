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
/*     */ public final class VisnImgDispModReq
/*     */ {
/*     */   public static final int _2D_FrontView = 1;
/*     */   public static final int _2D_FrontWideView = 7;
/*     */   public static final int _2D_LeftFrontAndRightFrontView = 5;
/*     */   public static final int _2D_LeftRearAndRightRearView = 6;
/*     */   public static final int _2D_LeftView = 3;
/*     */   public static final int _2D_NotActive = 0;
/*     */   public static final int _2D_RearView = 2;
/*     */   public static final int _2D_RearWideView = 8;
/*     */   public static final int _2D_RightView = 4;
/*     */   public static final int _3D_FrontView = 13;
/*     */   public static final int _3D_LeftFrontView = 17;
/*     */   public static final int _3D_LeftRearView = 19;
/*     */   public static final int _3D_LeftView = 15;
/*     */   public static final int _3D_RearView = 14;
/*     */   public static final int _3D_RightFrontView = 18;
/*     */   public static final int _3D_RightRearView = 20;
/*     */   public static final int _3D_RightView = 16;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  35 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  36 */     switch (paramInt) { default: switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/*  89 */             return str;
/*     */           case 20:
/*     */             str = "_3D_RightRearView";
/*     */           case 19:
/*     */             str = "_3D_LeftRearView";
/*     */           case 18:
/*     */             str = "_3D_RightFrontView";
/*     */           case 17:
/*     */             str = "_3D_LeftFrontView";
/*     */           case 16:
/*     */             str = "_3D_RightView";
/*     */           case 15:
/*     */             str = "_3D_LeftView";
/*     */           case 14:
/*     */             str = "_3D_RearView";
/*     */           case 13:
/*     */             break;
/*     */         } 
/*     */         str = "_3D_FrontView";
/*     */       case 8:
/*     */         str = "_2D_RearWideView";
/*     */       case 7:
/*     */         str = "_2D_FrontWideView";
/*     */       case 6:
/*     */         str = "_2D_LeftRearAndRightRearView";
/*     */       case 5:
/*     */         str = "_2D_LeftFrontAndRightFrontView";
/*     */       case 4:
/*     */         str = "_2D_RightView";
/*     */       case 3:
/*     */         str = "_2D_LeftView";
/*     */       case 2:
/*     */         str = "_2D_RearView";
/*     */       case 1:
/*     */         str = "_2D_FrontView";
/*     */       case 0:
/*     */         break; }
/*     */     
/*     */     str = "_2D_NotActive";
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
/* 138 */     boolean bool = false;
/*     */     
/* 140 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20)
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
/*     */ 
/*     */       
/* 157 */       bool = true;
/*     */     }
/*     */     
/* 160 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VisnImgDispModReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */