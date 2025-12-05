package com.ecarx.xui.adaptapi.dvr.ota;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IOta {
  public static final int FAILED_FILE_ERROR = 5;
  
  public static final int FAILED_NO_FILE = 4;
  
  public static final int FAILED_NO_RESPONSE = 0;
  
  public static final int FAILED_NO_SDCARD = 3;
  
  public static final int FAILED_OTHER_REASON = 6;
  
  String getDvrDspVersionName();
  
  String getDvrMcuVersionName();
  
  int getOtaBaseSoftwareVersionCode();
  
  String getOtaBaseSoftwareVersionName();
  
  boolean installPackage(IOtaSession paramIOtaSession, String paramString);
  
  void releaseOtaCallback(IOtaCallback paramIOtaCallback);
  
  IOtaSession requestOta(IOtaCallback paramIOtaCallback);
  
  boolean supportOtaFromIhu();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OtaFailedReason {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\ota\IOta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */