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
/*    */ public final class MapProvider
/*    */ {
/*    */   public static final int AutoNavi = 6;
/*    */   public static final int IPC = 4;
/*    */   public static final int NavInfo = 5;
/*    */   public static final int NokiaHERENAVTEQ = 1;
/*    */   public static final int NotAvailable = 7;
/*    */   public static final int TomTomTeleAtlas = 2;
/*    */   public static final int Unknown = 0;
/*    */   public static final int Zenrin = 3;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 26 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 27 */     switch (paramInt) {
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
/*    */       default:
/* 53 */         return str;
/*    */       case 7:
/*    */         str = "NotAvailable";
/*    */       case 6:
/*    */         str = "AutoNavi";
/*    */       case 5:
/*    */         str = "NavInfo";
/*    */       case 4:
/*    */         str = "IPC";
/*    */       case 3:
/*    */         str = "Zenrin";
/*    */       case 2:
/*    */         str = "TomTomTeleAtlas";
/*    */       case 1:
/*    */         str = "NokiaHERENAVTEQ";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "Unknown";
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
/* 84 */     boolean bool = false;
/*    */     
/* 86 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7)
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MapProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */