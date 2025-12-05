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
/*    */ public final class ProfileActiveStatus
/*    */ {
/*    */   public static final int ProfileActiveDefalt = 0;
/*    */   public static final int ProfileActiveFailed = 3;
/*    */   public static final int ProfileActivePramaerror = 4;
/*    */   public static final int ProfileActiveSuccess = 1;
/*    */   public static final int ProfileActiveUnused = 2;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 21 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 22 */     switch (paramInt) {
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
/* 39 */         return str;
/*    */       case 4:
/*    */         str = "ProfileActivePramaerror";
/*    */       case 3:
/*    */         str = "ProfileActiveFailed";
/*    */       case 2:
/*    */         str = "ProfileActiveUnused";
/*    */       case 1:
/*    */         str = "ProfileActiveSuccess";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "ProfileActiveDefalt";
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
/* 64 */     boolean bool = false;
/*    */     
/* 66 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 71 */       bool = true;
/*    */     }
/*    */     
/* 74 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ProfileActiveStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */