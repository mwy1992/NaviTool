package com.ecarx.xui.adaptapi.navigation.speed;

import android.os.Bundle;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ISpeedLimitingInfo {
  public static final int INFO_STATE_END = 1;
  
  public static final int INFO_STATE_START = 2;
  
  public static final int INFO_STATE_UNKNOWN = 0;
  
  public static final int ROAD_COUNTY = 3;
  
  public static final int ROAD_EXPRESS = 6;
  
  public static final int ROAD_HIGH_SPEED = 0;
  
  public static final int ROAD_NATION = 1;
  
  public static final int ROAD_NAVI_ERROR = -1;
  
  public static final int ROAD_NOMAL = 9;
  
  public static final int ROAD_NO_NAV = 10;
  
  public static final int ROAD_PRIMARY = 7;
  
  public static final int ROAD_PROV = 2;
  
  public static final int ROAD_SECONDARY = 8;
  
  public static final int ROAD_TOWN = 4;
  
  public static final int ROAD_VILLAGE = 5;
  
  ElecLimitingInfo getElecLimitingInfo();
  
  Bundle getExtendInformation();
  
  String getInfoPackage();
  
  int getInfoState();
  
  JctWayInfo getJctWayInfo();
  
  RoadInfo getRoadInfo();
  
  public static interface ElecLimitingInfo {
    int getDist();
    
    double getLat();
    
    double getLong();
    
    int getSpeed();
  }
  
  public static interface JctWayInfo {
    int getDist();
    
    double getLat();
    
    double getLong();
  }
  
  public static interface RoadInfo {
    int getRoadClass();
    
    String getRoadName();
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RoadType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SpeedLimitationState {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\speed\ISpeedLimitingInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */