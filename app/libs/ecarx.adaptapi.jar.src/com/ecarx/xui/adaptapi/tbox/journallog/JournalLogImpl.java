/*    */ package com.ecarx.xui.adaptapi.tbox.journallog;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.utils.ProperUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JournalLogImpl
/*    */   implements IJournalLog
/*    */ {
/*    */   private IJournalLog.JournalLogStatusCallback mJournalLogStatusCallback;
/*    */   
/*    */   public JournalLogImpl(Context paramContext) {}
/*    */   
/*    */   public FunctionStatus isJournalLogSupported() {
/* 23 */     return FunctionStatus.notavailable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isJournalLogServiceOn() {
/* 33 */     return ((Boolean)ProperUtils.getPropertyValue("IJournalLog_JournalLogServiceOn", boolean.class)).booleanValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean setJournalLogServiceOn(boolean paramBoolean) {
/* 44 */     return ProperUtils.setPropertyValue("IJournalLog_JournalLogServiceOn", Boolean.valueOf(paramBoolean));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setJournalLogStatusCallback(IJournalLog.JournalLogStatusCallback paramJournalLogStatusCallback) {
/* 54 */     this.mJournalLogStatusCallback = paramJournalLogStatusCallback;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void unsetJournalLogStatusCallback(IJournalLog.JournalLogStatusCallback paramJournalLogStatusCallback) {
/* 64 */     this.mJournalLogStatusCallback = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\journallog\JournalLogImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */