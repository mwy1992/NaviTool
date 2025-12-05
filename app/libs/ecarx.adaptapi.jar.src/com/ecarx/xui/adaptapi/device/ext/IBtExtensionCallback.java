package com.ecarx.xui.adaptapi.device.ext;

import com.ecarx.xui.adaptapi.VendorDefinition;
import com.ecarx.xui.adaptapi.device.ext.common.BtDevice;
import java.util.List;

@VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
public interface IBtExtensionCallback {
  void onAdapterStateChanged(int paramInt1, int paramInt2);
  
  void onDeviceBondStateChanged(BtDevice paramBtDevice, int paramInt1, int paramInt2);
  
  void onDeviceFoundChanged(int paramInt, BtDevice paramBtDevice);
  
  void onDevicePowerUpdated(BtDevice paramBtDevice, int paramInt);
  
  void onDeviceUuidsUpdated(BtDevice paramBtDevice);
  
  void onPairedDevicesChanged(List<BtDevice> paramList);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\IBtExtensionCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */