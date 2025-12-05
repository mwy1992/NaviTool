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
/*     */ public final class DrvrAsscSysBtnPush
/*     */ {
/*     */   public static final int APAFunctionOnButtionPressed = 1;
/*     */   public static final int APAFunctionOnButtonNoPress = 0;
/*     */   public static final int Cancelparkingbuttonnopress = 4;
/*     */   public static final int Cancelparkingbuttonpressed = 5;
/*     */   public static final int ComfirmEnterAutoParkingButtonPressed = 8;
/*     */   public static final int Confirmparkingbuttonnopressed = 6;
/*     */   public static final int ManualButtonPressed = 7;
/*     */   public static final int PASbuttonPressed = 9;
/*     */   public static final int RPAbuttonPressed = 11;
/*     */   public static final int RPAbuttonpresse = 10;
/*     */   public static final int Reserved_12 = 12;
/*     */   public static final int Undobuttonnopress = 2;
/*     */   public static final int Undobuttonpressed = 3;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  31 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  32 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  73 */         return str;
/*     */       case 12:
/*     */         str = "Reserved_12";
/*     */       case 11:
/*     */         str = "RPAbuttonPressed";
/*     */       case 10:
/*     */         str = "RPAbuttonpresse";
/*     */       case 9:
/*     */         str = "PASbuttonPressed";
/*     */       case 8:
/*     */         str = "ComfirmEnterAutoParkingButtonPressed";
/*     */       case 7:
/*     */         str = "ManualButtonPressed";
/*     */       case 6:
/*     */         str = "Confirmparkingbuttonnopressed";
/*     */       case 5:
/*     */         str = "Cancelparkingbuttonpressed";
/*     */       case 4:
/*     */         str = "Cancelparkingbuttonnopress";
/*     */       case 3:
/*     */         str = "Undobuttonpressed";
/*     */       case 2:
/*     */         str = "Undobuttonnopress";
/*     */       case 1:
/*     */         str = "APAFunctionOnButtionPressed";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "APAFunctionOnButtonNoPress";
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
/* 114 */     boolean bool = false;
/*     */     
/* 116 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12)
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
/* 129 */       bool = true;
/*     */     }
/*     */     
/* 132 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\DrvrAsscSysBtnPush.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */