package com.ecarx.xui.adaptapi.tbox.ota;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IOta {
  public static final int FAILED_REASON_DEVICE_BUSY = 2;
  
  public static final int FAILED_REASON_DEVICE_DISCONNECTED = 1;
  
  int getOtaBaseSoftwareVersionCode();
  
  String getOtaBaseSoftwareVersionName();
  
  boolean installPackage(IOtaSession paramIOtaSession, String paramString);
  
  void releaseOtaCallback(IOtaSessionCallback paramIOtaSessionCallback);
  
  IOtaSession requestOta(IOtaSessionCallback paramIOtaSessionCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OtaFailedReason {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\ota\IOta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */