package com.ecarx.xui.adaptapi.tbox.ota;

public interface IOtaSession {
  boolean cancel();
  
  boolean couldBeginInstallRightNow();
  
  int getOtaProgress();
  
  boolean ifSystemWillRebootAfterOta();
  
  boolean isInstallationStarted();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\ota\IOtaSession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */