package com.ecarx.xui.adaptapi.dvr;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface IOperation {
  public static final int MODE_AUTO_STARTED_EMERGENCY_RECORDING = 16;
  
  public static final int MODE_BROWSE_EDIT = 16384;
  
  public static final int MODE_BROWSE_EMERGENCY_RECORD = 128;
  
  public static final int MODE_BROWSE_GENERAL_RECORD = 64;
  
  public static final int MODE_BROWSE_PHOTO = 512;
  
  public static final int MODE_BROWSE_RISK_RECORD = 256;
  
  public static final int MODE_COMMUNICATE_ERROR = 131072;
  
  public static final int MODE_EXIT_BROWSE_EDIT = 65536;
  
  public static final int MODE_GENERAL_RECORDING = 2;
  
  public static final int MODE_INITIALIZING = 1;
  
  public static final int MODE_PAUSE_RECORD = 4;
  
  public static final int MODE_RISK_RECORDING = 32;
  
  public static final int MODE_SETTING = 32768;
  
  public static final int MODE_SYSTEM_FAULT = 8192;
  
  public static final int MODE_UPDATE_MODE = 4096;
  
  public static final int MODE_USER_STARTED_EMERGENCY_RECORDING = 8;
  
  public static final int MODE_VIDEO_PAUSE = 2048;
  
  public static final int MODE_VIDEO_PLAYING = 1024;
  
  public static final int OPERATION_STATUS_FAILED = 2;
  
  public static final int OPERATION_STATUS_FILE_NOT_FOUND = 4;
  
  public static final int OPERATION_STATUS_IN_PROGRESS = 3;
  
  public static final int OPERATION_STATUS_NO_RESPONSE = 0;
  
  public static final int OPERATION_STATUS_NO_SPACE = 5;
  
  public static final int OPERATION_STATUS_OTHER = 6;
  
  public static final int OPERATION_STATUS_SUCCEEDED = 1;
  
  public static final int PLAY_STATUS_NONE = 0;
  
  public static final int PLAY_STATUS_PAUSED = 2;
  
  public static final int PLAY_STATUS_PLAYING = 1;
  
  public static final int PLAY_STATUS_STOP = 3;
  
  public static final int ROTATE_DIRECTION_ANTICLOCKWISE = 2;
  
  public static final int ROTATE_DIRECTION_CLOCKWISE = 1;
  
  public static final int SDCARD_STATUS_EMERGENCY_VIDEO_PARTITION_FULL = 6;
  
  public static final int SDCARD_STATUS_ERROR = 3;
  
  public static final int SDCARD_STATUS_FORMATTING = 8;
  
  public static final int SDCARD_STATUS_INSUFFICIENT_STORAGE = 5;
  
  public static final int SDCARD_STATUS_NORMAL = 1;
  
  public static final int SDCARD_STATUS_NOT_FORMATTED = 4;
  
  public static final int SDCARD_STATUS_NO_SDCARD = 2;
  
  public static final int SDCARD_STATUS_PHOTO_PARTITION_FULL = 7;
  
  boolean backToHome();
  
  boolean browseFirstPage();
  
  boolean browseLastPage();
  
  boolean browseNextPage();
  
  boolean browsePage(int paramInt);
  
  boolean browsePreviousPage();
  
  boolean capture();
  
  boolean changeMode(int paramInt);
  
  boolean deleteAllFiles();
  
  boolean deleteAllFilesWithType(int paramInt);
  
  boolean deleteFiles(List<IDvrFile> paramList);
  
  boolean exitPlay();
  
  boolean formatSdcard();
  
  int getCurrentMode();
  
  int getPageCount();
  
  int getPlayingStatus();
  
  int getSdcardStatus();
  
  boolean isCameraOnline();
  
  boolean lockFile(IDvrFile paramIDvrFile);
  
  boolean moveVideosToEmergencyVideoPartition(List<IDvrVideoFile> paramList);
  
  boolean naviDown();
  
  boolean naviLeft();
  
  boolean naviRight();
  
  boolean naviUp();
  
  boolean pause();
  
  boolean play();
  
  boolean play(IDvrFile paramIDvrFile);
  
  boolean playNext();
  
  boolean playPrevious();
  
  boolean replay();
  
  boolean rotatePhoto(int paramInt);
  
  boolean rotatePhoto(IDvrPhotoFile paramIDvrPhotoFile, int paramInt);
  
  boolean selectAllFiles();
  
  boolean selectFile(IDvrFile paramIDvrFile);
  
  void setCallback(IOperationCallback paramIOperationCallback);
  
  boolean unlockFile(IDvrFile paramIDvrFile);
  
  void unsetCallback(IOperationCallback paramIOperationCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DvrMode {}
  
  public static interface IOperationCallback {
    void onBackToHomeStatus(int param1Int);
    
    void onBrowsingFiles(List<IDvrFile> param1List);
    
    void onBrowsingPageChanged(int param1Int1, int param1Int2);
    
    void onCaptureStatus(int param1Int, IDvrPhotoFile param1IDvrPhotoFile);
    
    void onChangeModeStatus(int param1Int);
    
    void onDeleteAllFilesStatus(int param1Int);
    
    void onDeleteFilesStatus(int param1Int);
    
    void onLockFileStatus(IDvrFile param1IDvrFile, int param1Int);
    
    void onMode(int param1Int);
    
    void onMoveVideosToEmergencyVideoPartitionStatus(int param1Int);
    
    void onPlayStatus(IDvrFile param1IDvrFile, int param1Int);
    
    void onSdcardFormattingStatus(int param1Int);
    
    void onSdcardStatus(int param1Int);
    
    void onSwitchPageStatus(int param1Int);
    
    void onUnlockFileStatus(IDvrFile param1IDvrFile, int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OperationStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PlayStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RotateDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SdcardStatus {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\IOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */