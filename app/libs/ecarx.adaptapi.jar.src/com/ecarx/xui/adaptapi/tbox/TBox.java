/*    */ package com.ecarx.xui.adaptapi.tbox;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.telephony.CellInfo;
/*    */ import android.telephony.SignalStrength;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.tbox.journallog.IJournalLog;
/*    */ import com.ecarx.xui.adaptapi.tbox.ota.IOta;
/*    */ import com.ecarx.xui.adaptapi.tbox.tboxmessager.ITBoxMessager;
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
/*    */ public abstract class TBox
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static TBox create(Context paramContext) {
/* 31 */     return TBoxImpl.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract CellInfo getCellInfo();
/*    */   
/*    */   public abstract String getHardwareVersion();
/*    */   
/*    */   public abstract String getICCID();
/*    */   
/*    */   public abstract IJournalLog getIJournalLog();
/*    */   
/*    */   public abstract String getIMEI();
/*    */   
/*    */   public abstract String getIMSI();
/*    */   
/*    */   public abstract String getLineNumber();
/*    */   
/*    */   public abstract String getMSISDN();
/*    */   
/*    */   public abstract String getNetworkOperator();
/*    */   
/*    */   public abstract String getNetworkOperatorName();
/*    */   
/*    */   public abstract String getNetworkType();
/*    */   
/*    */   public abstract IOta getOta();
/*    */   
/*    */   public abstract SignalStrength getSignalStrength();
/*    */   
/*    */   public abstract String getSoftwareVersion();
/*    */   
/*    */   public abstract int getSoftwareVersionCode();
/*    */   
/*    */   public abstract String getTBoxID();
/*    */   
/*    */   public abstract ITBoxMessager getTBoxMessager();
/*    */   
/*    */   public abstract ITBoxSettings getTBoxSettings();
/*    */   
/*    */   public abstract String getTBoxSupplierCode();
/*    */   
/*    */   public abstract boolean isSubscribed();
/*    */   
/*    */   public abstract boolean setGIDProfIDLnk(String paramString, int paramInt);
/*    */   
/*    */   public abstract boolean setTBoxReset();
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\TBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */