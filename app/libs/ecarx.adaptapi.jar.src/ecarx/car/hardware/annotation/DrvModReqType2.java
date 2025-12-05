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
/*     */ public final class DrvModReqType2
/*     */ {
/*     */   public static final int Adaptive = 6;
/*     */   public static final int Comfort_Normal = 2;
/*     */   public static final int Dynamic_Sport = 3;
/*     */   public static final int ECO = 1;
/*     */   public static final int Err = 15;
/*     */   public static final int Hybrid = 9;
/*     */   public static final int Individual = 4;
/*     */   public static final int Mud = 13;
/*     */   public static final int Offroad_CrossTerrain = 5;
/*     */   public static final int Power = 10;
/*     */   public static final int Pure_EV = 8;
/*     */   public static final int Race = 7;
/*     */   public static final int Rock = 14;
/*     */   public static final int Sand = 12;
/*     */   public static final int Snow = 11;
/*     */   public static final int Undefd = 0;
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
/*     */         str = "Err";
/*     */       case 14:
/*     */         str = "Rock";
/*     */       case 13:
/*     */         str = "Mud";
/*     */       case 12:
/*     */         str = "Sand";
/*     */       case 11:
/*     */         str = "Snow";
/*     */       case 10:
/*     */         str = "Power";
/*     */       case 9:
/*     */         str = "Hybrid";
/*     */       case 8:
/*     */         str = "Pure_EV";
/*     */       case 7:
/*     */         str = "Race";
/*     */       case 6:
/*     */         str = "Adaptive";
/*     */       case 5:
/*     */         str = "Offroad_CrossTerrain";
/*     */       case 4:
/*     */         str = "Individual";
/*     */       case 3:
/*     */         str = "Dynamic_Sport";
/*     */       case 2:
/*     */         str = "Comfort_Normal";
/*     */       case 1:
/*     */         str = "ECO";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Undefd";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvModReqType2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */