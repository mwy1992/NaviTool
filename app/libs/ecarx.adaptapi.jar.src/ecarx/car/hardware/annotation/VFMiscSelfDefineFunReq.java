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
/*    */ public final class VFMiscSelfDefineFunReq
/*    */ {
/*    */   public static final int Funreq0NaviScreenSwitch = 0;
/*    */   public static final int Funreq1Dvr = 1;
/*    */   public static final int Funreq2360panorama = 2;
/*    */   public static final int Funreq3NaviHome = 3;
/*    */   public static final int Funreq4SourceSwitch = 4;
/*    */   public static final int Funreq5CollectionRadio = 5;
/*    */   public static final int Funreq6Unlcktrunk = 6;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     switch (paramInt) {
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
/*    */       default:
/* 47 */         return str;
/*    */       case 6:
/*    */         str = "Funreq6Unlcktrunk";
/*    */       case 5:
/*    */         str = "Funreq5CollectionRadio";
/*    */       case 4:
/*    */         str = "Funreq4SourceSwitch";
/*    */       case 3:
/*    */         str = "Funreq3NaviHome";
/*    */       case 2:
/*    */         str = "Funreq2360panorama";
/*    */       case 1:
/*    */         str = "Funreq1Dvr";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Funreq0NaviScreenSwitch";
/*    */   }
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
/*    */   public static boolean isValid(int paramInt) {
/* 76 */     boolean bool = false;
/*    */     
/* 78 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 85 */       bool = true;
/*    */     }
/*    */     
/* 88 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VFMiscSelfDefineFunReq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */