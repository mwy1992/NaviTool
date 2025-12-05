package com.ecarx.xui.adaptapi.device.ext;

import com.ecarx.xui.adaptapi.VendorDefinition;

@VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
public interface IA2dpExtension {
  String getA2dpConnectedAddress();
  
  int getA2dpConnectionState();
  
  int getA2dpLocalVolume(String paramString);
  
  int getA2dpThresholdVolume(String paramString);
  
  boolean isA2dpConnected();
  
  boolean isA2dpServiceReady();
  
  void muteA2dpAudio(boolean paramBoolean, String paramString);
  
  void pauseA2dpRender();
  
  boolean registerA2dpCallback(IA2dpCallback paramIA2dpCallback);
  
  boolean reqA2dpConnect(String paramString);
  
  boolean reqA2dpDisconnect(String paramString);
  
  boolean setA2dpLocalVolume(int paramInt);
  
  void startA2dpRender();
  
  boolean unregisterA2dpCallback(IA2dpCallback paramIA2dpCallback);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\IA2dpExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */