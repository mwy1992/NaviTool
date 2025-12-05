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
/*     */ public final class Type1
/*     */ {
/*     */   public static final int Animal = 7;
/*     */   public static final int Bycycle = 9;
/*     */   public static final int Car = 1;
/*     */   public static final int ConstructionWorkTrailer = 12;
/*     */   public static final int MotorCycle = 2;
/*     */   public static final int ObjGen = 8;
/*     */   public static final int ObstclVert1Tree = 5;
/*     */   public static final int ObstclVert2Pole = 6;
/*     */   public static final int Pedestrian = 4;
/*     */   public static final int Reserved1_13 = 13;
/*     */   public static final int Reserved2_14 = 14;
/*     */   public static final int Reserved3_15 = 15;
/*     */   public static final int RoadConstructionMarker = 11;
/*     */   public static final int TruckOrBus = 3;
/*     */   public static final int UnkwnClass = 0;
/*     */   public static final int VehOfUkwnClass = 10;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  34 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  35 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  85 */         return str;
/*     */       case 15:
/*     */         str = "Reserved3_15";
/*     */       case 14:
/*     */         str = "Reserved2_14";
/*     */       case 13:
/*     */         str = "Reserved1_13";
/*     */       case 12:
/*     */         str = "ConstructionWorkTrailer";
/*     */       case 11:
/*     */         str = "RoadConstructionMarker";
/*     */       case 10:
/*     */         str = "VehOfUkwnClass";
/*     */       case 9:
/*     */         str = "Bycycle";
/*     */       case 8:
/*     */         str = "ObjGen";
/*     */       case 7:
/*     */         str = "Animal";
/*     */       case 6:
/*     */         str = "ObstclVert2Pole";
/*     */       case 5:
/*     */         str = "ObstclVert1Tree";
/*     */       case 4:
/*     */         str = "Pedestrian";
/*     */       case 3:
/*     */         str = "TruckOrBus";
/*     */       case 2:
/*     */         str = "MotorCycle";
/*     */       case 1:
/*     */         str = "Car";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "UnkwnClass";
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
/* 132 */     boolean bool = false;
/*     */     
/* 134 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15)
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
/* 150 */       bool = true;
/*     */     }
/*     */     
/* 153 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\Type1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */