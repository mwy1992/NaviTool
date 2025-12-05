/*    */ package com.ecarx.xui.adaptapi.wifiap;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.net.wifi.WifiConfiguration;
/*    */ import com.ecarx.xui.adaptapi.Nullable;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
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
/*    */ @VendorDefinition(author = "@ECARX", date = "2021-09-01", project = "EF1E")
/*    */ public abstract class ExternalWifiAP
/*    */   extends WifiAp
/*    */ {
/*    */   public static final int WIFI_AP_STATE_DISABLED = 11;
/*    */   public static final int WIFI_AP_STATE_DISABLING = 10;
/*    */   public static final int WIFI_AP_STATE_ENABLED = 13;
/*    */   public static final int WIFI_AP_STATE_ENABLING = 12;
/*    */   public static final int WIFI_AP_STATE_FAILED = 14;
/*    */   
/*    */   public static ExternalWifiAP create(Context paramContext) {
/* 29 */     return null;
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
/*    */   public static ExternalWifiAP create(Context paramContext, int paramInt) {
/* 44 */     return null;
/*    */   }
/*    */   
/*    */   public abstract boolean enableInternet(Boolean paramBoolean);
/*    */   
/*    */   @Nullable
/*    */   public abstract WifiConfiguration getWifiApConfiguration();
/*    */   
/*    */   public abstract int getWifiApState();
/*    */   
/*    */   public abstract boolean isWifiApEnabled();
/*    */   
/*    */   public abstract void registerApStateChangeListener(ExternalApStateListener paramExternalApStateListener);
/*    */   
/*    */   public abstract void registerWifiApConfigChangeListener(WifiApConfigChangeListener paramWifiApConfigChangeListener);
/*    */   
/*    */   public abstract void setSoftAp(WifiConfiguration paramWifiConfiguration, ActionListener paramActionListener);
/*    */   
/*    */   public abstract boolean startSoftAp(@Nullable WifiConfiguration paramWifiConfiguration);
/*    */   
/*    */   public abstract boolean stopSoftAp();
/*    */   
/*    */   public abstract void unregisterApStateListener(ExternalApStateListener paramExternalApStateListener);
/*    */   
/*    */   public abstract void unregisterWifiApConfigChangeListener(WifiApConfigChangeListener paramWifiApConfigChangeListener);
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface WifiApState {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\ExternalWifiAP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */