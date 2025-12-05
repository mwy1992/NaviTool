package com.ecarx.xui.adaptapi.car.diagnostics;

import java.util.List;

public interface IDtcManager {
  List<IDtcInfo> getDtcInfos();
  
  boolean registerWatcher(IDtcInfoWatcher paramIDtcInfoWatcher);
  
  void unregisterWatcher(IDtcInfoWatcher paramIDtcInfoWatcher);
  
  public static interface IDtcInfo {
    String getDtcCode();
    
    String getDtcId();
    
    int getEcuType();
    
    int getStatus();
    
    long getTicktime();
  }
  
  public static interface IDtcInfoWatcher {
    void onDtcInfosChanged(List<IDtcManager.IDtcInfo> param1List);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\IDtcManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */