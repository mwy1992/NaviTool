package com.ecarx.xui.adaptapi.lighting;

import com.ecarx.xui.adaptapi.FunctionStatus;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ILightingShow {
  public static final int ERROR_CODE_ACC_NOT_CONVENIENCE = 1;
  
  public static final int ERROR_CODE_BATTERY_LOW = 4;
  
  public static final int ERROR_CODE_BRAKE_PRESSED = 6;
  
  public static final int ERROR_CODE_DOOR_NOT_CLOSED = 2;
  
  public static final int ERROR_CODE_HWL_ON = 7;
  
  public static final int ERROR_CODE_LAMP_FAULT = 5;
  
  public static final int ERROR_CODE_NO_ERROR = 0;
  
  public static final int ERROR_CODE_UNKNOWN = 255;
  
  public static final int ERROR_CODE_WINDOW_NOT_DOWN = 3;
  
  public static final int SHOW_MODE_MULTIPLE = 2;
  
  public static final int SHOW_MODE_SINGLE = 1;
  
  public static final int SHOW_STATE_END = 4;
  
  public static final int SHOW_STATE_ERROR = 5;
  
  public static final int SHOW_STATE_IDLE = 255;
  
  public static final int SHOW_STATE_PREPARE = 6;
  
  public static final int SHOW_STATE_SHOWING = 2;
  
  public static final int SHOW_STATE_START = 1;
  
  public static final int SHOW_STATE_STOP = 3;
  
  public static final int SHOW_STATE_UNKNOWN = 0;
  
  public static final int SHOW_TYPE_EXTERIOR = 1;
  
  public static final int SHOW_TYPE_INTERIOR = 2;
  
  public static final int SHOW_TYPE_WELCOME = 3;
  
  public static final int VEHICLE_IP_INTERNET_MASTER = 1;
  
  public static final int VEHICLE_IP_LOCAL_MASTER = 2;
  
  public static final int VEHICLE_IP_LOCAL_SLAVE = 3;
  
  int getLightShowFileDownloadReq();
  
  int[] getLightingShowError();
  
  ILightingShowInfo[] getLightingShowInfo(int paramInt);
  
  int getLightingShowMode();
  
  int getLightingShowState();
  
  int getLightingShowType();
  
  int[] getVehicleIpTable(int paramInt);
  
  FunctionStatus isLightingShowEnabled();
  
  FunctionStatus isLightingShowFileDownload();
  
  FunctionStatus isWelcomeLightFileDownload();
  
  void registerLightingShowWatcher(ILightingShowWatcher paramILightingShowWatcher);
  
  boolean sendIpMessage(int paramInt, String paramString);
  
  boolean sendLightingShowSource(byte[] paramArrayOfbyte);
  
  boolean sendLightingShowSourceEnd();
  
  boolean sendLightingShowSourceStart();
  
  int setLightShowFileDownloadResult(int paramInt);
  
  int setLightShowFileRequestResult(int paramInt);
  
  boolean setLightingShowMode(int paramInt);
  
  boolean setLightingShowType(int paramInt);
  
  void startLightingShow();
  
  void stopLightingShow();
  
  void unregisterLightingShowWatcher(ILightingShowWatcher paramILightingShowWatcher);
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DownloadResult {
    public static final int FAILED = 2;
    
    public static final int IDLE = 0;
    
    public static final int SUCCEED = 1;
    
    public static final int TIME_OUT = 3;
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ErrorCode {}
  
  public static interface ILightingShowInfo {
    String getDescription();
    
    String getName();
    
    String getPath();
    
    int getPayType();
    
    int getShowMode();
    
    int getShowType();
    
    String getUUID();
  }
  
  public static interface ILightingShowWatcher {
    void onLightingShowEnableChanged(FunctionStatus param1FunctionStatus);
    
    void onLightingShowError(int[] param1ArrayOfint);
    
    void onLightingShowFileDownloadFunctionStatus(FunctionStatus param1FunctionStatus);
    
    void onLightingShowFileDownloadState(int param1Int);
    
    void onLightingShowStateChanged(int param1Int);
    
    void onWelcomeLightFileDownloadFunctionStatus(FunctionStatus param1FunctionStatus);
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ReqState {
    public static final int NOT_REQUEST_DOWNLOAD = 0;
    
    public static final int REQUEST_DOWNLOAD = 1;
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ReqStateResult {
    public static final int FAILED = 0;
    
    public static final int SUCCEED = 1;
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ShowMode {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ShowState {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ShowType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VehicleIpType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\lighting\ILightingShow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */