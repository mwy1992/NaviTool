package com.ecarx.xui.adaptapi.device.ext;

import com.ecarx.xui.adaptapi.VendorDefinition;
import com.ecarx.xui.adaptapi.device.ext.common.BtDevice;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface IBtExtension {
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean cancelBtDiscovery();
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-27", project = "HX11")
  boolean getA2dpAutoRejectConnStatus();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  IA2dpExtension getA2dpExtension();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  int getBtState();
  
  String getConnectedPhoneNumber();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  int getHeadsetPower(BtDevice paramBtDevice);
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-27", project = "HX11")
  boolean getHfpAutoRejectConnStatus();
  
  IMultiBtPbapExtension getMultiBtPbapExtension();
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-25", project = "KX11")
  String getPSDBluetoothMacAddress();
  
  IPbapExtension getPbapExtension();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "HX11")
  boolean isBLEScanEnable();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean isBtDiscovering();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean isBtEnabled();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean registerBtCallback(IBtExtensionCallback paramIBtExtensionCallback);
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean reqBtPair(String paramString);
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  List<BtDevice> reqBtPairedDevices();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean reqBtUnpair(String paramString);
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-27", project = "HX11")
  boolean setA2dpAutoRejectConnStatus(boolean paramBoolean);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "HX11")
  boolean setBLEScanEnable(boolean paramBoolean);
  
  @VendorDefinition(author = "@ECARX", date = "2022-03-14", project = "HX11")
  boolean setBluetoothAutoConnect(String paramString, int paramInt, boolean paramBoolean);
  
  boolean setBluetoothAutoConnect(String paramString, boolean paramBoolean);
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean setBtEnable(boolean paramBoolean);
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-27", project = "HX11")
  boolean setHfpAutoRejectConnStatus(boolean paramBoolean);
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean startBtDiscovery();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "HX11")
  boolean startDiscoveryOnlyClassic();
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
  boolean unregisterBtCallback(IBtExtensionCallback paramIBtExtensionCallback);
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Profile {
    public static final int AUTO_CONNECT_PROFILE_A2DP = 2;
    
    public static final int AUTO_CONNECT_PROFILE_HFP = 1;
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\IBtExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */