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
/*     */ public final class RPAReq
/*     */ {
/*     */   public static final int Continue = 9;
/*     */   public static final int Idle = 0;
/*     */   public static final int OutMode = 3;
/*     */   public static final int Pause = 8;
/*     */   public static final int Start = 1;
/*     */   public static final int Start_Parking_In = 6;
/*     */   public static final int Start_Parking_Out = 7;
/*     */   public static final int Start_Searching = 5;
/*     */   public static final int Stop = 2;
/*     */   public static final int Undo = 4;
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
/*     */         str = "Continue";
/*     */       case 8:
/*     */         str = "Pause";
/*     */       case 7:
/*     */         str = "Start_Parking_Out";
/*     */       case 6:
/*     */         str = "Start_Parking_In";
/*     */       case 5:
/*     */         str = "Start_Searching";
/*     */       case 4:
/*     */         str = "Undo";
/*     */       case 3:
/*     */         str = "OutMode";
/*     */       case 2:
/*     */         str = "Stop";
/*     */       case 1:
/*     */         str = "Start";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Idle";
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
/*  98 */     if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 0)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RPAReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */