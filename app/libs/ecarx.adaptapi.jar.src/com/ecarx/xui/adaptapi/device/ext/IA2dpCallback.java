package com.ecarx.xui.adaptapi.device.ext;

import com.ecarx.xui.adaptapi.VendorDefinition;

@VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
public interface IA2dpCallback {
  void onA2dpServiceReady();
  
  void onA2dpStateChanged(String paramString, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\IA2dpCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */