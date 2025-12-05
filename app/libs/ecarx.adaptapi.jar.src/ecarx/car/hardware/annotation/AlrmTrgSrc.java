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
/*     */ public final class AlrmTrgSrc
/*     */ {
/*     */   public static final int DoorDrvr = 6;
/*     */   public static final int DoorPass = 7;
/*     */   public static final int DoorReLe = 8;
/*     */   public static final int DoorReRi = 9;
/*     */   public static final int Hood = 4;
/*     */   public static final int NoTrigSrc = 0;
/*     */   public static final int SnsrIncln = 2;
/*     */   public static final int SnsrIntrScanr = 3;
/*     */   public static final int SnsrSoundrBattBacked = 1;
/*     */   public static final int Tr = 5;
/*     */   public static final int VehImobnInvld = 10;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  29 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  30 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  65 */         return str;
/*     */       case 10:
/*     */         str = "VehImobnInvld";
/*     */       case 9:
/*     */         str = "DoorReRi";
/*     */       case 8:
/*     */         str = "DoorReLe";
/*     */       case 7:
/*     */         str = "DoorPass";
/*     */       case 6:
/*     */         str = "DoorDrvr";
/*     */       case 5:
/*     */         str = "Tr";
/*     */       case 4:
/*     */         str = "Hood";
/*     */       case 3:
/*     */         str = "SnsrIntrScanr";
/*     */       case 2:
/*     */         str = "SnsrIncln";
/*     */       case 1:
/*     */         str = "SnsrSoundrBattBacked";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoTrigSrc";
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
/* 102 */     boolean bool = false;
/*     */     
/* 104 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10)
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
/* 115 */       bool = true;
/*     */     }
/*     */     
/* 118 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\AlrmTrgSrc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */