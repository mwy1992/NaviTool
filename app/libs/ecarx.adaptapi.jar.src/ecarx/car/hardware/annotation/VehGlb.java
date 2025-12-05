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
/*     */ public final class VehGlb
/*     */ {
/*     */   public static final int VehMktGlb_China = 10;
/*     */   public static final int VehMktGlb_Europe = 2;
/*     */   public static final int VehMktGlb_India = 13;
/*     */   public static final int VehMktGlb_Israel = 14;
/*     */   public static final int VehMktGlb_Japan = 12;
/*     */   public static final int VehMktGlb_Korea = 9;
/*     */   public static final int VehMktGlb_MiddleEastAfrica = 5;
/*     */   public static final int VehMktGlb_NorthAmerica = 3;
/*     */   public static final int VehMktGlb_Pacific = 7;
/*     */   public static final int VehMktGlb_Russia = 8;
/*     */   public static final int VehMktGlb_SNA = 0;
/*     */   public static final int VehMktGlb_SouthAmerica = 4;
/*     */   public static final int VehMktGlb_SouthEastAsia = 6;
/*     */   public static final int VehMktGlb_Spare = 16;
/*     */   public static final int VehMktGlb_Taiwan = 11;
/*     */   public static final int VehMktGlb_Turkey = 15;
/*     */   public static final int VehMktGlb_World = 1;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  35 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  36 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  89 */         return str;
/*     */       case 16:
/*     */         str = "VehMktGlb_Spare";
/*     */       case 15:
/*     */         str = "VehMktGlb_Turkey";
/*     */       case 14:
/*     */         str = "VehMktGlb_Israel";
/*     */       case 13:
/*     */         str = "VehMktGlb_India";
/*     */       case 12:
/*     */         str = "VehMktGlb_Japan";
/*     */       case 11:
/*     */         str = "VehMktGlb_Taiwan";
/*     */       case 10:
/*     */         str = "VehMktGlb_China";
/*     */       case 9:
/*     */         str = "VehMktGlb_Korea";
/*     */       case 8:
/*     */         str = "VehMktGlb_Russia";
/*     */       case 7:
/*     */         str = "VehMktGlb_Pacific";
/*     */       case 6:
/*     */         str = "VehMktGlb_SouthEastAsia";
/*     */       case 5:
/*     */         str = "VehMktGlb_MiddleEastAfrica";
/*     */       case 4:
/*     */         str = "VehMktGlb_SouthAmerica";
/*     */       case 3:
/*     */         str = "VehMktGlb_NorthAmerica";
/*     */       case 2:
/*     */         str = "VehMktGlb_Europe";
/*     */       case 1:
/*     */         str = "VehMktGlb_World";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "VehMktGlb_SNA";
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
/* 138 */     boolean bool = false;
/*     */     
/* 140 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16)
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
/* 157 */       bool = true;
/*     */     }
/*     */     
/* 160 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VehGlb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */