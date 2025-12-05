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
/*     */ public final class PatSeld
/*     */ {
/*     */   public static final int BiochalPatseld = 8;
/*     */   public static final int CarWashPatseld = 9;
/*     */   public static final int CustomizationPatseld = 12;
/*     */   public static final int EcoPatseld = 10;
/*     */   public static final int GoddessPatseld = 14;
/*     */   public static final int KingPatseld = 11;
/*     */   public static final int MeetingPatseld = 13;
/*     */   public static final int NoSeld = 0;
/*     */   public static final int ParentchildPatSeld = 2;
/*     */   public static final int PetPatseld = 7;
/*     */   public static final int RefrshPatSeld = 1;
/*     */   public static final int Restpatseld = 3;
/*     */   public static final int RomanticPatseld = 4;
/*     */   public static final int StrangerPatseld = 5;
/*     */   public static final int TheaterPatseld = 6;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  33 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  34 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  81 */         return str;
/*     */       case 14:
/*     */         str = "GoddessPatseld";
/*     */       case 13:
/*     */         str = "MeetingPatseld";
/*     */       case 12:
/*     */         str = "CustomizationPatseld";
/*     */       case 11:
/*     */         str = "KingPatseld";
/*     */       case 10:
/*     */         str = "EcoPatseld";
/*     */       case 9:
/*     */         str = "CarWashPatseld";
/*     */       case 8:
/*     */         str = "BiochalPatseld";
/*     */       case 7:
/*     */         str = "PetPatseld";
/*     */       case 6:
/*     */         str = "TheaterPatseld";
/*     */       case 5:
/*     */         str = "StrangerPatseld";
/*     */       case 4:
/*     */         str = "RomanticPatseld";
/*     */       case 3:
/*     */         str = "Restpatseld";
/*     */       case 2:
/*     */         str = "ParentchildPatSeld";
/*     */       case 1:
/*     */         str = "RefrshPatSeld";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoSeld";
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
/* 126 */     boolean bool = false;
/*     */     
/* 128 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14)
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
/* 143 */       bool = true;
/*     */     }
/*     */     
/* 146 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\PatSeld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */