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
/*    */ public final class SteerLockMgrWarnIndcn
/*    */ {
/*    */   public static final int CryptoSteerLockMsgMgr = 5;
/*    */   public static final int FltSteerLockMsgMgr = 3;
/*    */   public static final int SftySteerLockMsgMgr = 6;
/*    */   public static final int SteerLockMgrNoMsg = 0;
/*    */   public static final int SteerLockMsgInVldMgr = 7;
/*    */   public static final int SteerLockMsgNotProgdMgr = 2;
/*    */   public static final int SteerLockTiOutMsgMgr = 1;
/*    */   public static final int SteerLockTqMsgMgr = 4;
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
/*    */         str = "SteerLockMsgInVldMgr";
/*    */       case 6:
/*    */         str = "SftySteerLockMsgMgr";
/*    */       case 5:
/*    */         str = "CryptoSteerLockMsgMgr";
/*    */       case 4:
/*    */         str = "SteerLockTqMsgMgr";
/*    */       case 3:
/*    */         str = "FltSteerLockMsgMgr";
/*    */       case 2:
/*    */         str = "SteerLockMsgNotProgdMgr";
/*    */       case 1:
/*    */         str = "SteerLockTiOutMsgMgr";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "SteerLockMgrNoMsg";
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


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\SteerLockMgrWarnIndcn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */