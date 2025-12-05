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
/*    */ public final class ProfileGidbindStatus
/*    */ {
/*    */   public static final int ProfileAllunbindfailed = 6;
/*    */   public static final int ProfileAllunbindsuccess = 5;
/*    */   public static final int ProfileBindfailed = 2;
/*    */   public static final int ProfileBindsuccess = 1;
/*    */   public static final int ProfileDefalt = 0;
/*    */   public static final int ProfileUnbindfailed = 4;
/*    */   public static final int ProfileUnbindsuccess = 3;
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
/*    */         str = "ProfileAllunbindfailed";
/*    */       case 5:
/*    */         str = "ProfileAllunbindsuccess";
/*    */       case 4:
/*    */         str = "ProfileUnbindfailed";
/*    */       case 3:
/*    */         str = "ProfileUnbindsuccess";
/*    */       case 2:
/*    */         str = "ProfileBindfailed";
/*    */       case 1:
/*    */         str = "ProfileBindsuccess";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ProfileDefalt";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ProfileGidbindStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */