/*    */ package com.ecarx.xui.adaptapi.wifiap;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.net.wifi.ScanResult;
/*    */ import android.net.wifi.WifiConfiguration;
/*    */ import android.net.wifi.WifiInfo;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.NonNull;
/*    */ import com.ecarx.xui.adaptapi.Nullable;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
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
/*    */ @VendorDefinition(author = "@ECARX", date = "2021-09-01", project = "EF1E")
/*    */ public abstract class ExternalWifiManager
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int BUSY = 2;
/*    */   public static final int ERROR = 0;
/*    */   public static final int IN_PROGRESS = 1;
/*    */   
/*    */   public static ExternalWifiManager create(Context paramContext) {
/* 62 */     return null;
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
/*    */   public static ExternalWifiManager create(Context paramContext, int paramInt) {
/* 77 */     return null;
/*    */   }
/*    */   
/*    */   public abstract int addNetwork(WifiConfiguration paramWifiConfiguration);
/*    */   
/*    */   public abstract void connect(@NonNull WifiConfiguration paramWifiConfiguration, @Nullable ActionListener paramActionListener);
/*    */   
/*    */   public abstract boolean disconnect();
/*    */   
/*    */   public abstract boolean enableNetwork(int paramInt, boolean paramBoolean);
/*    */   
/*    */   public abstract List<WifiConfiguration> getConfiguredNetworks();
/*    */   
/*    */   public abstract WifiInfo getConnectionInfo();
/*    */   
/*    */   @Nullable
/*    */   public abstract WifiConfiguration getHideSSID(String paramString);
/*    */   
/*    */   public abstract List<ScanResult> getScanResults();
/*    */   
/*    */   public abstract int getWifiState();
/*    */   
/*    */   public abstract FunctionStatus isSupported();
/*    */   
/*    */   public abstract boolean isWifiEnabled();
/*    */   
/*    */   public abstract void registerConnectionStateListener(ExternalWifiConnectionStateListener paramExternalWifiConnectionStateListener);
/*    */   
/*    */   public abstract void registerScanResultListener(ExternalScanResultListener paramExternalScanResultListener);
/*    */   
/*    */   public abstract void registerWifiStateListener(ExternalWifiStateListener paramExternalWifiStateListener);
/*    */   
/*    */   public abstract boolean removeNetwork(int paramInt);
/*    */   
/*    */   public abstract boolean setWifiEnabled(boolean paramBoolean);
/*    */   
/*    */   public abstract boolean startScan();
/*    */   
/*    */   public abstract void unregisterConnectionStateListener(ExternalWifiConnectionStateListener paramExternalWifiConnectionStateListener);
/*    */   
/*    */   public abstract void unregisterScanResultListener(ExternalScanResultListener paramExternalScanResultListener);
/*    */   
/*    */   public abstract void unregisterWifiStateListener(ExternalWifiStateListener paramExternalWifiStateListener);
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface ActionListenerFailureReason {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\ExternalWifiManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */