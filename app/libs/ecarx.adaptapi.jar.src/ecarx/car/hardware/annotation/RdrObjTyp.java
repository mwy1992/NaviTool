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
/*     */ public final class RdrObjTyp
/*     */ {
/*     */   public static final int Anim = 7;
/*     */   public static final int Bicycle = 9;
/*     */   public static final int Car = 1;
/*     */   public static final int MotorCycle = 2;
/*     */   public static final int ObjGen = 8;
/*     */   public static final int ObstdVert1 = 5;
/*     */   public static final int ObstdVert2 = 6;
/*     */   public static final int Ped = 4;
/*     */   public static final int Reserved_11 = 11;
/*     */   public static final int Truck = 3;
/*     */   public static final int Ukwn = 0;
/*     */   public static final int VehofUkwnClass = 10;
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
/*     */         str = "Reserved_11";
/*     */       case 10:
/*     */         str = "VehofUkwnClass";
/*     */       case 9:
/*     */         str = "Bicycle";
/*     */       case 8:
/*     */         str = "ObjGen";
/*     */       case 7:
/*     */         str = "Anim";
/*     */       case 6:
/*     */         str = "ObstdVert2";
/*     */       case 5:
/*     */         str = "ObstdVert1";
/*     */       case 4:
/*     */         str = "Ped";
/*     */       case 3:
/*     */         str = "Truck";
/*     */       case 2:
/*     */         str = "MotorCycle";
/*     */       case 1:
/*     */         str = "Car";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Ukwn";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RdrObjTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */