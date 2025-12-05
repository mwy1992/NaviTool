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
/*     */ public final class BrkSysSts1
/*     */ {
/*     */   public static final int Activated_FailOperation = 9;
/*     */   public static final int Activated_FullAvailable = 8;
/*     */   public static final int Activated_RedundancyLost = 10;
/*     */   public static final int Activation_Pending = 5;
/*     */   public static final int Activation_PendingFailOperation = 7;
/*     */   public static final int Activation_PendingRedundancyLost = 6;
/*     */   public static final int Activation_Preparation = 4;
/*     */   public static final int Deactivation_Pending = 11;
/*     */   public static final int NotActivated_FullAvailable = 3;
/*     */   public static final int NotAvailable_NotReleased = 1;
/*     */   public static final int NotAvailable_Permanent = 2;
/*     */   public static final int NotAvailable_Temporary = 0;
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
/*     */         str = "Deactivation_Pending";
/*     */       case 10:
/*     */         str = "Activated_RedundancyLost";
/*     */       case 9:
/*     */         str = "Activated_FailOperation";
/*     */       case 8:
/*     */         str = "Activated_FullAvailable";
/*     */       case 7:
/*     */         str = "Activation_PendingFailOperation";
/*     */       case 6:
/*     */         str = "Activation_PendingRedundancyLost";
/*     */       case 5:
/*     */         str = "Activation_Pending";
/*     */       case 4:
/*     */         str = "Activation_Preparation";
/*     */       case 3:
/*     */         str = "NotActivated_FullAvailable";
/*     */       case 2:
/*     */         str = "NotAvailable_Permanent";
/*     */       case 1:
/*     */         str = "NotAvailable_NotReleased";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NotAvailable_Temporary";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\BrkSysSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */