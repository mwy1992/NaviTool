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
/*     */ public final class LangTyp
/*     */ {
/*     */   public static final int Lang1 = 1;
/*     */   public static final int Lang10 = 10;
/*     */   public static final int Lang11 = 11;
/*     */   public static final int Lang12 = 12;
/*     */   public static final int Lang13 = 13;
/*     */   public static final int Lang14 = 14;
/*     */   public static final int Lang15 = 15;
/*     */   public static final int Lang16 = 16;
/*     */   public static final int Lang17 = 17;
/*     */   public static final int Lang18 = 18;
/*     */   public static final int Lang19 = 19;
/*     */   public static final int Lang2 = 2;
/*     */   public static final int Lang20 = 20;
/*     */   public static final int Lang21 = 21;
/*     */   public static final int Lang22 = 22;
/*     */   public static final int Lang23 = 23;
/*     */   public static final int Lang24 = 24;
/*     */   public static final int Lang25 = 25;
/*     */   public static final int Lang26 = 26;
/*     */   public static final int Lang27 = 27;
/*     */   public static final int Lang28 = 28;
/*     */   public static final int Lang29 = 29;
/*     */   public static final int Lang3 = 3;
/*     */   public static final int Lang30 = 30;
/*     */   public static final int Lang31 = 31;
/*     */   public static final int Lang32 = 32;
/*     */   public static final int Lang33 = 33;
/*     */   public static final int Lang34 = 34;
/*     */   public static final int Lang35 = 35;
/*     */   public static final int Lang36 = 36;
/*     */   public static final int Lang37 = 37;
/*     */   public static final int Lang4 = 4;
/*     */   public static final int Lang5 = 5;
/*     */   public static final int Lang6 = 6;
/*     */   public static final int Lang7 = 7;
/*     */   public static final int Lang8 = 8;
/*     */   public static final int Lang9 = 9;
/*     */   public static final int Ukwn = 0;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  56 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  57 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 173 */         return str;
/*     */       case 37:
/*     */         str = "Lang37";
/*     */       case 36:
/*     */         str = "Lang36";
/*     */       case 35:
/*     */         str = "Lang35";
/*     */       case 34:
/*     */         str = "Lang34";
/*     */       case 33:
/*     */         str = "Lang33";
/*     */       case 32:
/*     */         str = "Lang32";
/*     */       case 31:
/*     */         str = "Lang31";
/*     */       case 30:
/*     */         str = "Lang30";
/*     */       case 29:
/*     */         str = "Lang29";
/*     */       case 28:
/*     */         str = "Lang28";
/*     */       case 27:
/*     */         str = "Lang27";
/*     */       case 26:
/*     */         str = "Lang26";
/*     */       case 25:
/*     */         str = "Lang25";
/*     */       case 24:
/*     */         str = "Lang24";
/*     */       case 23:
/*     */         str = "Lang23";
/*     */       case 22:
/*     */         str = "Lang22";
/*     */       case 21:
/*     */         str = "Lang21";
/*     */       case 20:
/*     */         str = "Lang20";
/*     */       case 19:
/*     */         str = "Lang19";
/*     */       case 18:
/*     */         str = "Lang18";
/*     */       case 17:
/*     */         str = "Lang17";
/*     */       case 16:
/*     */         str = "Lang16";
/*     */       case 15:
/*     */         str = "Lang15";
/*     */       case 14:
/*     */         str = "Lang14";
/*     */       case 13:
/*     */         str = "Lang13";
/*     */       case 12:
/*     */         str = "Lang12";
/*     */       case 11:
/*     */         str = "Lang11";
/*     */       case 10:
/*     */         str = "Lang10";
/*     */       case 9:
/*     */         str = "Lang9";
/*     */       case 8:
/*     */         str = "Lang8";
/*     */       case 7:
/*     */         str = "Lang7";
/*     */       case 6:
/*     */         str = "Lang6";
/*     */       case 5:
/*     */         str = "Lang5";
/*     */       case 4:
/*     */         str = "Lang4";
/*     */       case 3:
/*     */         str = "Lang3";
/*     */       case 2:
/*     */         str = "Lang2";
/*     */       case 1:
/*     */         str = "Lang1";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "Ukwn";
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
/* 264 */     boolean bool = false;
/*     */     
/* 266 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31 || paramInt == 32 || paramInt == 33 || paramInt == 34 || paramInt == 35 || paramInt == 36 || paramInt == 37)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 304 */       bool = true;
/*     */     }
/*     */     
/* 307 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\LangTyp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */