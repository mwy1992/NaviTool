package com.ecarx.xui.adaptapi.diminteraction;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface INaviInteraction {
  public static final int ACTION_ADD_WAY_POINT = 7;
  
  public static final int ACTION_AUTO_ZOOM_OFF = 18;
  
  public static final int ACTION_AUTO_ZOOM_ON = 17;
  
  public static final int ACTION_CANCEL_MUTE = 4;
  
  public static final int ACTION_CANCEL_NAVIGATION = 2;
  
  public static final int ACTION_DIM_DISPLAY_3D_LANE = 37;
  
  public static final int ACTION_DIM_DISPLAY_AR = 36;
  
  public static final int ACTION_DIM_DISPLAY_FULL = 35;
  
  public static final int ACTION_DIM_DISPLAY_OFF = 33;
  
  public static final int ACTION_DIM_DISPLAY_SIMPLIFY = 34;
  
  public static final int ACTION_GET_FAVORITE = 5;
  
  public static final int ACTION_GET_HISTORY = 6;
  
  public static final int ACTION_MUTE = 3;
  
  public static final int ACTION_NEARBY_GAS_CHARGING_STATION = 8;
  
  public static final int ACTION_START_NAVIGATION = 1;
  
  public static final int ACTION_ZOOM_IN = 19;
  
  public static final int ACTION_ZOOM_OUT = 20;
  
  public static final int DIRECTION_EAST = 0;
  
  public static final int DIRECTION_EAST_NORTH = 4;
  
  public static final int DIRECTION_EAST_SOUTH = 5;
  
  public static final int DIRECTION_NORTH = 3;
  
  public static final int DIRECTION_SOUTH = 1;
  
  public static final int DIRECTION_WEST = 2;
  
  public static final int DIRECTION_WEST_NORTH = 6;
  
  public static final int DIRECTION_WEST_SOUTH = 7;
  
  public static final String EXT_KEY_DIM_DISPLAY_MODE = "EXT_KEY_DIM_DISPLAY_MODE";
  
  public static final int NAVIGATION_STATUS_END = 3;
  
  public static final int NAVIGATION_STATUS_REROUTING = 4;
  
  public static final int NAVIGATION_STATUS_START = 2;
  
  public static final int NAVIGATION_STATUS_SUCCEED = 1;
  
  public static final int NAVIGATION_STATUS_TUNNEL_END = 6;
  
  public static final int NAVIGATION_STATUS_TUNNEL_ENTER = 5;
  
  public static final int NAVIGATION_STATUS_UNNAVI = 0;
  
  public static final int TYPE_DEFAULT = 0;
  
  public static final int TYPE_DESTINATION = 3;
  
  public static final int TYPE_FAVORITE = 1;
  
  public static final int TYPE_HISTORY = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2022-03-14", project = "SMART")
  void UpdateDistanceToNextGuidancePoint(String paramString, int paramInt);
  
  void notifyDestinationReached(String paramString, int paramInt);
  
  void notifyDestinationReached(String paramString, Bitmap paramBitmap);
  
  void notifyNavigationStatus(int paramInt);
  
  void notifyTurnByTurnStarted();
  
  void notifyTurnByTurnStopped();
  
  void registerNavigationInteractionCallback(INavigationInteractionCallback paramINavigationInteractionCallback);
  
  void unregisterNavigationInteractionCallback(INavigationInteractionCallback paramINavigationInteractionCallback);
  
  void updateAddresses(int paramInt, List<IAddress> paramList);
  
  void updateDayNightMode(int paramInt);
  
  void updateDistanceToDestination(int paramInt);
  
  void updateDistanceToNextGuidancePoint(int paramInt);
  
  void updateDriveDirection(int paramInt);
  
  void updateETA(int paramInt);
  
  void updateExtensionInfo(Bundle paramBundle);
  
  void updateHighwayExitInfo(IHighwayExitInfo paramIHighwayExitInfo);
  
  void updateLaneInfo(ILaneInfo[] paramArrayOfILaneInfo);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
  void updateLastRangeInfo(LastRangeInfo paramLastRangeInfo);
  
  void updateMuteState(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
  void updateNaviInfo(NaviInfo paramNaviInfo);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
  void updateNaviStatus(NaviStatus paramNaviStatus);
  
  void updateNavigationInfo(INavigationInfo paramINavigationInfo);
  
  void updateNextGuidancePointName(String paramString);
  
  void updateRoadCameraInfo(IRoadCamera paramIRoadCamera);
  
  void updateSearchAddresses(int paramInt, List<IAddress> paramList, String paramString);
  
  void updateServiceAreaInfo(IServiceArea paramIServiceArea);
  
  @VendorDefinition(author = "@ECARX", date = "2022-03-28", project = "HX11")
  void updateTotalDistanceToDestination(int paramInt);
  
  void updateTurnByTurnArrow(int paramInt);
  
  void updateTurnByTurnArrow(Bitmap paramBitmap);
  
  void updateTurnByTurnArrow(String paramString);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AddressType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DestinationType {
    public static final int DESTINATION_TYPE_CHARGING_STATION = 3;
    
    public static final int DESTINATION_TYPE_NULL = 0;
    
    public static final int DESTINATION_TYPE_OTHER = 4;
    
    public static final int DESTINATION_TYPE_PARKING_LOT = 2;
    
    public static final int DESTINATION_TYPE_STATION = 1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Direction {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DistanceUnit {
    public static final int DEFAULT = 0;
    
    public static final int FT = 5;
    
    public static final int KM = 1;
    
    public static final int METER = 3;
    
    public static final int MILES = 2;
    
    public static final int YARDS = 4;
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ExtensionKey {
    public static final String KEY_DESTINATION_TYPE = "KEY_DESTINATION_TYPE";
    
    public static final String KEY_DEST_CHARGE_STATION_POWER = "KEY_DEST_CHARGE_STATION_POWER";
    
    public static final String KEY_DEST_LEFT_SOC = "KEY_DEST_LEFT_SOC";
    
    public static final String KEY_DIM_DISPLAY_MODE = "EXT_KEY_DIM_DISPLAY_MODE";
    
    public static final String KEY_NAVI_INFO_DEST_NAME = "KEY_NAVI_INFO_DEST_NAME";
    
    public static final String KEY_NAVI_INFO_LANE_STATUS = "KEY_NAVI_INFO_LANE_STATUS";
    
    public static final String KEY_NAVI_INFO_ROAD_TYPE = "KEY_NAVI_INFO_ROAD_TYPE";
  }
  
  public static interface IAddress {
    String getAddressName();
    
    String getCityName();
    
    long getDistance();
    
    String getFullAddress();
    
    double getLatitude();
    
    double getLongitude();
  }
  
  public static interface IHighwayExitInfo {
    int getEtaDistance();
    
    int getEtaTime();
    
    String getExitDirection();
    
    String getExitNumber();
  }
  
  public static interface ILaneInfo {
    Bitmap getLaneBackIcon();
    
    int getLaneBackIconId();
    
    int getLaneNumber();
  }
  
  public static interface INavigationInfo {
    int getDayNightMode();
    
    long getDistanceToDestination();
    
    long getDistanceToNextGuidancePoint();
    
    int getDrivingDirection();
    
    long getETA();
    
    Bundle getExtensionInfo();
    
    INaviInteraction.IHighwayExitInfo getHighwayExitInfo();
    
    INaviInteraction.ILaneInfo[] getLaneInfo();
    
    int getMuteState();
    
    int getNavigationStatus();
    
    int getNavigationTurnId();
    
    String getNavigationTurnSVG();
    
    String getNextGuidancePointName();
    
    INaviInteraction.IRoadCamera getRoadCameraInfo();
    
    INaviInteraction.IServiceArea getServiceAreaInfo();
  }
  
  public static interface INavigationInteractionCallback {
    void onDoInteractionAction(int param1Int, INaviInteraction.IAddress param1IAddress);
    
    void onSearchAddress(String param1String);
  }
  
  public static interface IRoadCamera {
    public static final int TYPE_AGAINST_RULES = 3;
    
    public static final int TYPE_BICYCLE_LANE = 7;
    
    public static final int TYPE_BUS_LANE = 4;
    
    public static final int TYPE_EMERGENCY_LANE = 5;
    
    public static final int TYPE_MONITOR = 1;
    
    public static final int TYPE_RAD_LIGHT = 2;
    
    public static final int TYPE_SPEED = 0;
    
    public static final int TYPE_TAKE_PHOTO = 6;
    
    int getAreaDistance();
    
    int getCameraType();
    
    int getLimitSpeed();
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface CameraType {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CameraType {}
  
  public static interface IServiceArea {
    int getAreaDistance();
    
    String getAreaName();
    
    int getAreaType();
    
    int getEtaTime();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NavigationStatus {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\INaviInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */