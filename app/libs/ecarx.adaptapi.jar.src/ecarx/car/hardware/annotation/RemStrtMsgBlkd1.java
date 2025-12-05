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
/*     */ public final class RemStrtMsgBlkd1
/*     */ {
/*     */   public static final int BrkPedlPsd = 6;
/*     */   public static final int EngFlt = 7;
/*     */   public static final int GearLvrNotInP = 2;
/*     */   public static final int HoodOpend = 8;
/*     */   public static final int ImobActvd = 9;
/*     */   public static final int KeyInVeh = 4;
/*     */   public static final int LoBatt = 1;
/*     */   public static final int LoFuLvl = 3;
/*     */   public static final int NoFailr = 0;
/*     */   public static final int NrOfClimaLim = 5;
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
/*     */         str = "ImobActvd";
/*     */       case 8:
/*     */         str = "HoodOpend";
/*     */       case 7:
/*     */         str = "EngFlt";
/*     */       case 6:
/*     */         str = "BrkPedlPsd";
/*     */       case 5:
/*     */         str = "NrOfClimaLim";
/*     */       case 4:
/*     */         str = "KeyInVeh";
/*     */       case 3:
/*     */         str = "LoFuLvl";
/*     */       case 2:
/*     */         str = "GearLvrNotInP";
/*     */       case 1:
/*     */         str = "LoBatt";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoFailr";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\RemStrtMsgBlkd1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */