package com.ecarx.xui.adaptapi.peripherals.wear;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IIntelligentKey {
  public static final int STATUS_CONNECTED = 2;
  
  public static final int STATUS_CONNECTING = 1;
  
  public static final int STATUS_DISCONNECT = 0;
  
  int getConnectionState();
  
  void registerIntelligentKeyConnectionStateCallback(IIntelligentKeyConnectionStateCallback paramIIntelligentKeyConnectionStateCallback);
  
  void unRegisterIntelligentKeyConnectionStateCallback(IIntelligentKeyConnectionStateCallback paramIIntelligentKeyConnectionStateCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ConnectionState {}
  
  public static interface IIntelligentKeyConnectionStateCallback {
    void onStateChanged(int param1Int1, int param1Int2);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\peripherals\wear\IIntelligentKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */