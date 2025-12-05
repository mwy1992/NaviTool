package com.ecarx.xui.adaptapi.dvr.ota;

import com.ecarx.xui.adaptapi.FutureFeature;

@FutureFeature
public interface IOtaSession {
  int getOtaProgress();
  
  boolean ifSystemWillRebootAfterOta();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\ota\IOtaSession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */