package com.ecarx.xui.adaptapi.car.roadpath;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IRoadPath {
  public static final int CONF_PATH_INIT = 0;
  
  public static final int CONF_PATH_INVALID = 2;
  
  public static final int CONF_PATH_RESERVED = 3;
  
  public static final int CONF_PATH_VALID = 1;
  
  void addCallback(RoadDataStatusCallback paramRoadDataStatusCallback);
  
  void removeCallback(RoadDataStatusCallback paramRoadDataStatusCallback);
  
  boolean setConfCurrSpd(int paramInt);
  
  boolean setConfPath(int paramInt);
  
  boolean setRoadCondData(int[] paramArrayOfint);
  
  boolean setRoadSlopeData(int[] paramArrayOfint);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ConfPath {}
  
  public static interface RoadDataStatusCallback {
    void onRoadCondState(boolean param1Boolean);
    
    void onRoadSlopeState(boolean param1Boolean);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\roadpath\IRoadPath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */