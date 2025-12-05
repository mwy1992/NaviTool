/*    */ package android.car.app.menu;
/*    */ 
/*    */ import android.os.Bundle;
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
/*    */ 
/*    */ public class RootMenu
/*    */ {
/*    */   private final Bundle mBundle;
/*    */   private final String mRootId;
/*    */   
/*    */   public RootMenu(String paramString) {
/* 35 */     this(paramString, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RootMenu(String paramString, Bundle paramBundle) {
/* 45 */     this.mRootId = paramString;
/* 46 */     this.mBundle = paramBundle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getId() {
/* 55 */     return this.mRootId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Bundle getBundle() {
/* 64 */     return new Bundle(this.mBundle);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\app\menu\RootMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */