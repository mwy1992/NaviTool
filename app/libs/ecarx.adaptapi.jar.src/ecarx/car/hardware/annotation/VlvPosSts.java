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
/*     */ public final class VlvPosSts
/*     */ {
/*     */   public static final int FullClosePosition = 0;
/*     */   public static final int FullOpenPosition = 20;
/*     */   public static final int Level10OpenPosition = 10;
/*     */   public static final int Level11OpenPosition = 11;
/*     */   public static final int Level12OpenPosition = 12;
/*     */   public static final int Level13OpenPosition = 13;
/*     */   public static final int Level14OpenPosition = 14;
/*     */   public static final int Level15OpenPosition = 15;
/*     */   public static final int Level16OpenPosition = 16;
/*     */   public static final int Level17OpenPosition = 17;
/*     */   public static final int Level18OpenPosition = 18;
/*     */   public static final int Level19OpenPosition = 19;
/*     */   public static final int Level1OpenPosition = 1;
/*     */   public static final int Level2OpenPosition = 2;
/*     */   public static final int Level3OpenPosition = 3;
/*     */   public static final int Level4OpenPosition = 4;
/*     */   public static final int Level5OpenPosition = 5;
/*     */   public static final int Level6OpenPosition = 6;
/*     */   public static final int Level7OpenPosition = 7;
/*     */   public static final int Level8OpenPosition = 8;
/*     */   public static final int Level9OpenPosition = 9;
/*     */   public static final int Reserved_22 = 22;
/*     */   public static final int UnknowPosition = 21;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  41 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  42 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 113 */         return str;
/*     */       case 22:
/*     */         str = "Reserved_22";
/*     */       case 21:
/*     */         str = "UnknowPosition";
/*     */       case 20:
/*     */         str = "FullOpenPosition";
/*     */       case 19:
/*     */         str = "Level19OpenPosition";
/*     */       case 18:
/*     */         str = "Level18OpenPosition";
/*     */       case 17:
/*     */         str = "Level17OpenPosition";
/*     */       case 16:
/*     */         str = "Level16OpenPosition";
/*     */       case 15:
/*     */         str = "Level15OpenPosition";
/*     */       case 14:
/*     */         str = "Level14OpenPosition";
/*     */       case 13:
/*     */         str = "Level13OpenPosition";
/*     */       case 12:
/*     */         str = "Level12OpenPosition";
/*     */       case 11:
/*     */         str = "Level11OpenPosition";
/*     */       case 10:
/*     */         str = "Level10OpenPosition";
/*     */       case 9:
/*     */         str = "Level9OpenPosition";
/*     */       case 8:
/*     */         str = "Level8OpenPosition";
/*     */       case 7:
/*     */         str = "Level7OpenPosition";
/*     */       case 6:
/*     */         str = "Level6OpenPosition";
/*     */       case 5:
/*     */         str = "Level5OpenPosition";
/*     */       case 4:
/*     */         str = "Level4OpenPosition";
/*     */       case 3:
/*     */         str = "Level3OpenPosition";
/*     */       case 2:
/*     */         str = "Level2OpenPosition";
/*     */       case 1:
/*     */         str = "Level1OpenPosition";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "FullClosePosition";
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
/* 174 */     boolean bool = false;
/*     */     
/* 176 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 21 || paramInt == 22)
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
/* 199 */       bool = true;
/*     */     }
/*     */     
/* 202 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VlvPosSts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */