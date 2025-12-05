/*    */ package com.ecarx.xui.adaptapi.uiinteraction;
/*    */ 
/*    */ import android.app.ActivityManager;
/*    */ import android.app.IActivityManager;
/*    */ import android.content.Context;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public class FreeFormWindowImpl
/*    */   implements IFreeFormWindow
/*    */ {
/*    */   private static final String TAG = "FreeFormWindowImpl";
/*    */   private static FreeFormWindowImpl sFreeFormWindowImpl;
/*    */   private IActivityManager mAm;
/*    */   private Context mContext;
/*    */   
/*    */   public FreeFormWindowImpl(Context paramContext) {
/* 17 */     this.mContext = paramContext;
/* 18 */     this.mAm = ActivityManager.getService();
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
/*    */ 
/*    */   
/*    */   public int changeFreeformWindowSize(String paramString, boolean paramBoolean) {
/* 39 */     if (this.mAm == null) {
/* 40 */       this.mAm = ActivityManager.getService();
/*    */     }
/*    */     try {
/* 43 */       return this.mAm.changeFreeformWindowSize(paramString, paramBoolean, null);
/* 44 */     } catch (RemoteException remoteException) {
/* 45 */       remoteException.printStackTrace();
/* 46 */       return -1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\FreeFormWindowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */