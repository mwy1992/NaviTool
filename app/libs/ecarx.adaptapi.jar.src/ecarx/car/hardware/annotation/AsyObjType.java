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
/*     */ public final class AsyObjType
/*     */ {
/*     */   public static final int Animal = 8;
/*     */   public static final int Bus = 4;
/*     */   public static final int Car = 0;
/*     */   public static final int Cyclist = 2;
/*     */   public static final int Motorbike = 3;
/*     */   public static final int Pedestrian = 1;
/*     */   public static final int Tree = 6;
/*     */   public static final int Truck = 5;
/*     */   public static final int Unknown = 9;
/*     */   public static final int Wall = 7;
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
/*     */         str = "Unknown";
/*     */       case 8:
/*     */         str = "Animal";
/*     */       case 7:
/*     */         str = "Wall";
/*     */       case 6:
/*     */         str = "Tree";
/*     */       case 5:
/*     */         str = "Truck";
/*     */       case 4:
/*     */         str = "Bus";
/*     */       case 3:
/*     */         str = "Motorbike";
/*     */       case 2:
/*     */         str = "Cyclist";
/*     */       case 1:
/*     */         str = "Pedestrian";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Car";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AsyObjType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */