package com.ecarx.xui.adaptapi.device.log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDeviceLog {
  public static final int TYPE_ALL = 0;
  
  public static final int TYPE_ANR = 7;
  
  public static final int TYPE_DEFAULT = 2147483637;
  
  public static final int TYPE_ERROR = 8;
  
  public static final int TYPE_EVENTS = 3;
  
  public static final int TYPE_EXCEPTION = 9;
  
  public static final int TYPE_KERNEL = 2;
  
  public static final int TYPE_LOGCAT = 6;
  
  public static final int TYPE_MAP = 18;
  
  public static final int TYPE_MODEM = 4;
  
  public static final int TYPE_NET = 5;
  
  public static final int TYPE_SYSTEM = 1;
  
  public static final int TYPE_TOP = 16;
  
  public static final int TYPE_VR = 17;
  
  String[] getLogRootFolders();
  
  String[] getLogRootFolders(int paramInt);
  
  void setLogcatLogLevel(int[] paramArrayOfint);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LogType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\log\IDeviceLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */