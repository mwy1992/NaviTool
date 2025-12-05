package com.ecarx.xui.adaptapi.binder;

public interface IConnectable {
  void connect();
  
  void disconnect();
  
  void registerConnectWatcher(IConnectWatcher paramIConnectWatcher);
  
  void unregisterConnectWatcher();
  
  public static interface IConnectWatcher {
    void onConnected();
    
    void onDisConnected();
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\binder\IConnectable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */