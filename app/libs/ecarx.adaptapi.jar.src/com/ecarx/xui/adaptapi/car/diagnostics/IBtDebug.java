package com.ecarx.xui.adaptapi.car.diagnostics;

public interface IBtDebug {
  boolean enableDUTMode(boolean paramBoolean);
  
  boolean enableSSPMode(boolean paramBoolean);
  
  boolean enableVirtualSniffer(boolean paramBoolean);
  
  boolean isDUTModeEnabled();
  
  boolean isSSPModeEnabled();
  
  boolean isVirtualSnifferEnabled();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\IBtDebug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */