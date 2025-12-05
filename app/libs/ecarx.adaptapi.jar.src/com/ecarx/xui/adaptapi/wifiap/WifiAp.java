/*    */ package com.ecarx.xui.adaptapi.wifiap;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*    */ import java.util.List;
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
/*    */ public abstract class WifiAp
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static WifiAp create(Context paramContext) {
/* 32 */     return WifiApImp.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract int getMaxConnections();
/*    */   
/*    */   public abstract IWifiAPHost getWifiAPHost();
/*    */   
/*    */   public abstract List<IWifiApClient> getWifiApClients();
/*    */   
/*    */   public abstract FunctionStatus isWifi5GModeSupported();
/*    */   
/*    */   public abstract FunctionStatus isWifiAPSupported();
/*    */   
/*    */   public abstract FunctionStatus isWifiSupported();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-07-07", project = "ALL", requirement = "")
/*    */   public abstract boolean query5GMode();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-07-07", project = "ALL", requirement = "")
/*    */   public abstract void set5GMode(boolean paramBoolean);
/*    */   
/*    */   public abstract boolean setMaxConnections(int paramInt);
/*    */   
/*    */   public abstract boolean setWifiApClientCallback(IWifiApClientCallback paramIWifiApClientCallback);
/*    */   
/*    */   public abstract boolean unsetWifiApClientCallback(IWifiApClientCallback paramIWifiApClientCallback);
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\WifiAp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */