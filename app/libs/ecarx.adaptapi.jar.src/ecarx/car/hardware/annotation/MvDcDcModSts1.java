/*    */ package ecarx.car.hardware.annotation;
/*    */ 
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MvDcDcModSts1
/*    */ {
/*    */   public static final int AutoMod = 13;
/*    */   public static final int Fwd = 4;
/*    */   public static final int IninInProgs = 10;
/*    */   public static final int Invalid = 15;
/*    */   public static final int Reserved_2 = 2;
/*    */   public static final int Rvs = 5;
/*    */   public static final int ShutDwnInProgs = 11;
/*    */   public static final int StbBy = 3;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 26 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 27 */     if (paramInt != 13) { if (paramInt != 15) { switch (paramInt) { default: switch (paramInt) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */               
/*    */               default:
/* 53 */                 return str;
/*    */               case 11:
/*    */                 str = "ShutDwnInProgs";
/*    */               case 10:
/*    */                 break;
/*    */             } 
/*    */             str = "IninInProgs";
/*    */           case 5:
/*    */             str = "Rvs";
/*    */           case 4:
/*    */             str = "Fwd";
/*    */           case 3:
/*    */             str = "StbBy";
/*    */           case 2:
/*    */             break; }
/*    */         
/*    */         str = "Reserved_2"; }
/*    */       
/*    */       str = "Invalid"; }
/*    */     
/*    */     str = "AutoMod";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isValid(int paramInt) {
/* 84 */     boolean bool = false;
/*    */     
/* 86 */     if (paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 10 || paramInt == 11 || paramInt == 13 || paramInt == 15)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 94 */       bool = true;
/*    */     }
/*    */     
/* 97 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MvDcDcModSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */