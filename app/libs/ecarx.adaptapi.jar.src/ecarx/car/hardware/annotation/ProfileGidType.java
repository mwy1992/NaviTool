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
/*    */ public final class ProfileGidType
/*    */ {
/*    */   public static final int ProfileConnectgidCsd = 17;
/*    */   public static final int ProfileDisconnectGid = 19;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 18 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 19 */     if (paramInt != 17) { if (paramInt == 19)
/*    */       {
/*    */ 
/*    */ 
/*    */         
/* 24 */         str = "ProfileDisconnectGid"; }  }
/*    */     else
/*    */     { str = "ProfileConnectgidCsd"; }
/* 27 */      return str;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isValid(int paramInt) {
/* 46 */     boolean bool = false;
/*    */     
/* 48 */     if (paramInt == 17 || paramInt == 19)
/*    */     {
/* 50 */       bool = true;
/*    */     }
/*    */     
/* 53 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ProfileGidType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */