package com.ecarx.xui.adaptapi.dvr.forp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDvrInfo {
  public static final int DVR_MODEL_NAME = 1;
  
  public static final int DVR_SOFTWARE_VERSION = 2;
  
  String getDvrInfoString(int paramInt);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface StrInfoId {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\IDvrInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */