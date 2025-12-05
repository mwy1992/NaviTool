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
/*     */ public final class WindowPosnReqTyp
/*     */ {
/*     */   public static final int WindowposnreqtypClsfull = 1;
/*     */   public static final int WindowposnreqtypFinetuning = 255;
/*     */   public static final int WindowposnreqtypFinetuningreduce = 254;
/*     */   public static final int WindowposnreqtypOpenfull = 26;
/*     */   public static final int WindowposnreqtypPercopen12 = 4;
/*     */   public static final int WindowposnreqtypPercopen16 = 5;
/*     */   public static final int WindowposnreqtypPercopen20 = 6;
/*     */   public static final int WindowposnreqtypPercopen24 = 7;
/*     */   public static final int WindowposnreqtypPercopen28 = 8;
/*     */   public static final int WindowposnreqtypPercopen32 = 9;
/*     */   public static final int WindowposnreqtypPercopen36 = 10;
/*     */   public static final int WindowposnreqtypPercopen4 = 2;
/*     */   public static final int WindowposnreqtypPercopen40 = 11;
/*     */   public static final int WindowposnreqtypPercopen44 = 12;
/*     */   public static final int WindowposnreqtypPercopen48 = 13;
/*     */   public static final int WindowposnreqtypPercopen52 = 14;
/*     */   public static final int WindowposnreqtypPercopen56 = 15;
/*     */   public static final int WindowposnreqtypPercopen60 = 16;
/*     */   public static final int WindowposnreqtypPercopen64 = 17;
/*     */   public static final int WindowposnreqtypPercopen68 = 18;
/*     */   public static final int WindowposnreqtypPercopen72 = 19;
/*     */   public static final int WindowposnreqtypPercopen76 = 20;
/*     */   public static final int WindowposnreqtypPercopen8 = 3;
/*     */   public static final int WindowposnreqtypPercopen80 = 21;
/*     */   public static final int WindowposnreqtypPercopen84 = 22;
/*     */   public static final int WindowposnreqtypPercopen88 = 23;
/*     */   public static final int WindowposnreqtypPercopen92 = 24;
/*     */   public static final int WindowposnreqtypPercopen96 = 25;
/*     */   public static final int WindowposnreqtypPosnukwn = 0;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  45 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  46 */     switch (paramInt) { default: switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 135 */             return str;
/*     */           case 255:
/*     */             str = "WindowposnreqtypFinetuning";
/*     */           case 254:
/*     */             break;
/*     */         } 
/*     */         str = "WindowposnreqtypFinetuningreduce";
/*     */       case 26:
/*     */         str = "WindowposnreqtypOpenfull";
/*     */       case 25:
/*     */         str = "WindowposnreqtypPercopen96";
/*     */       case 24:
/*     */         str = "WindowposnreqtypPercopen92";
/*     */       case 23:
/*     */         str = "WindowposnreqtypPercopen88";
/*     */       case 22:
/*     */         str = "WindowposnreqtypPercopen84";
/*     */       case 21:
/*     */         str = "WindowposnreqtypPercopen80";
/*     */       case 20:
/*     */         str = "WindowposnreqtypPercopen76";
/*     */       case 19:
/*     */         str = "WindowposnreqtypPercopen72";
/*     */       case 18:
/*     */         str = "WindowposnreqtypPercopen68";
/*     */       case 17:
/*     */         str = "WindowposnreqtypPercopen64";
/*     */       case 16:
/*     */         str = "WindowposnreqtypPercopen60";
/*     */       case 15:
/*     */         str = "WindowposnreqtypPercopen56";
/*     */       case 14:
/*     */         str = "WindowposnreqtypPercopen52";
/*     */       case 13:
/*     */         str = "WindowposnreqtypPercopen48";
/*     */       case 12:
/*     */         str = "WindowposnreqtypPercopen44";
/*     */       case 11:
/*     */         str = "WindowposnreqtypPercopen40";
/*     */       case 10:
/*     */         str = "WindowposnreqtypPercopen36";
/*     */       case 9:
/*     */         str = "WindowposnreqtypPercopen32";
/*     */       case 8:
/*     */         str = "WindowposnreqtypPercopen28";
/*     */       case 7:
/*     */         str = "WindowposnreqtypPercopen24";
/*     */       case 6:
/*     */         str = "WindowposnreqtypPercopen20";
/*     */       case 5:
/*     */         str = "WindowposnreqtypPercopen16";
/*     */       case 4:
/*     */         str = "WindowposnreqtypPercopen12";
/*     */       case 3:
/*     */         str = "WindowposnreqtypPercopen8";
/*     */       case 2:
/*     */         str = "WindowposnreqtypPercopen4";
/*     */       case 1:
/*     */         str = "WindowposnreqtypClsfull";
/*     */       case 0:
/*     */         break; }
/*     */     
/*     */     str = "WindowposnreqtypPosnukwn";
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
/* 208 */     boolean bool = false;
/*     */     
/* 210 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 254 || paramInt == 255)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 239 */       bool = true;
/*     */     }
/*     */     
/* 242 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\WindowPosnReqTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */