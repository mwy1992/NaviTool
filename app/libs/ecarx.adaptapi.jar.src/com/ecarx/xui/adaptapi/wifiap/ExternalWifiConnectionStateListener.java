package com.ecarx.xui.adaptapi.wifiap;

import android.net.wifi.WifiInfo;
import com.ecarx.xui.adaptapi.VendorDefinition;

@VendorDefinition(author = "@ECARX", date = "2021-09-01", project = "EF1E")
public interface ExternalWifiConnectionStateListener {
  void onConnectionStateChanged(WifiInfo paramWifiInfo);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\ExternalWifiConnectionStateListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */