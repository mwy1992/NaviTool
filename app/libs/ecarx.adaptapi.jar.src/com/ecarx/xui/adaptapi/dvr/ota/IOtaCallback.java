package com.ecarx.xui.adaptapi.dvr.ota;

public interface IOtaCallback {
  void onFailed(int paramInt);
  
  void onRebootingAfterOta();
  
  void onShouldBeginInstall();
  
  void onSucceeded();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\ota\IOtaCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */