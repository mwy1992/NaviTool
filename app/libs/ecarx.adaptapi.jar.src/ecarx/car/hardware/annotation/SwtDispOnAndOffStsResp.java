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
/*     */ public final class SwtDispOnAndOffStsResp
/*     */ {
/*     */   public static final int EnterByHardSwitch = 2;
/*     */   public static final int EnterByRGear = 3;
/*     */   public static final int EnterBySoftSwitch = 1;
/*     */   public static final int ExitByHardSwitch = 9;
/*     */   public static final int ExitByOverSpeed = 10;
/*     */   public static final int ExitByPGearAfter5s = 11;
/*     */   public static final int ExitBySoftSwitch = 8;
/*     */   public static final int ExitBySystemFault = 12;
/*     */   public static final int InValid = 0;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  27 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  28 */     switch (paramInt) { default: switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  57 */             return str;
/*     */           case 12:
/*     */             str = "ExitBySystemFault";
/*     */           case 11:
/*     */             str = "ExitByPGearAfter5s";
/*     */           case 10:
/*     */             str = "ExitByOverSpeed";
/*     */           case 9:
/*     */             str = "ExitByHardSwitch";
/*     */           case 8:
/*     */             break;
/*     */         } 
/*     */         str = "ExitBySoftSwitch";
/*     */       case 3:
/*     */         str = "EnterByRGear";
/*     */       case 2:
/*     */         str = "EnterByHardSwitch";
/*     */       case 1:
/*     */         str = "EnterBySoftSwitch";
/*     */       case 0:
/*     */         break; }
/*     */     
/*     */     str = "InValid";
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
/*  90 */     boolean bool = false;
/*     */     
/*  92 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 8)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       bool = true;
/*     */     }
/*     */     
/* 104 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SwtDispOnAndOffStsResp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */