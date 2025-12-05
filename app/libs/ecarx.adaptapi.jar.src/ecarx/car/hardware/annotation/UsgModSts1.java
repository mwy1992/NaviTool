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
/*    */ public final class UsgModSts1
/*    */ {
/*    */   public static final int UsgModAbdnd = 0;
/*    */   public static final int UsgModActv = 11;
/*    */   public static final int UsgModCnvinc = 2;
/*    */   public static final int UsgModDrvg = 13;
/*    */   public static final int UsgModInActv = 1;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 24 */     if (paramInt != 11) { if (paramInt != 13) { switch (paramInt) {
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
/*    */           default:
/* 41 */             return str;
/*    */           case 2:
/*    */             str = "UsgModCnvinc";
/*    */           case 1:
/*    */             str = "UsgModInActv";
/*    */           case 0:
/*    */             break;
/*    */         } 
/*    */         str = "UsgModAbdnd"; }
/*    */       
/*    */       str = "UsgModDrvg"; }
/*    */     
/*    */     str = "UsgModActv";
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
/* 66 */     boolean bool = false;
/*    */     
/* 68 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 11 || paramInt == 13)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 73 */       bool = true;
/*    */     }
/*    */     
/* 76 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\UsgModSts1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */