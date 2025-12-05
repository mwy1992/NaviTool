package com.ecarx.xui.adaptapi.dvr;

import com.ecarx.xui.adaptapi.Tribool;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ISettings {
  public static final int CRASH_SENSITIVITY_LEVEL_DEFAULT = 2147483637;
  
  public static final int CRASH_SENSITIVITY_LEVEL_HIGH = 3;
  
  public static final int CRASH_SENSITIVITY_LEVEL_LOW = 1;
  
  public static final int CRASH_SENSITIVITY_LEVEL_MIDDLE = 2;
  
  public static final int CRASH_SENSITIVITY_LEVEL_OFF = 0;
  
  public static final int RESOLUTION_1080P_30FPS = 2;
  
  public static final int RESOLUTION_720P_30FPS = 1;
  
  boolean factoryReset();
  
  int getRecordingDuration();
  
  int getResolutionType();
  
  int[] getSupportedRecordingDuration();
  
  Tribool ifRecordAudio();
  
  void setAudioRecordingCfg(boolean paramBoolean);
  
  void setCallback(IDvrSettingsCallback paramIDvrSettingsCallback);
  
  boolean setCrashSensitivityLevel(int paramInt);
  
  boolean setParkMonitor(boolean paramBoolean);
  
  void setRecordingDuration(int paramInt);
  
  void setResolutionType(int paramInt);
  
  void unsetCallback(IDvrSettingsCallback paramIDvrSettingsCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CrashSensitivityLevel {}
  
  public static interface IDvrSettingsCallback {
    void onCrashSensitivityLevelChanged(int param1Int);
    
    void onFactoryResetStatus(int param1Int);
    
    void onParkMonitorChange(boolean param1Boolean);
    
    void onRecordAudioCfg(boolean param1Boolean);
    
    void onRecordingDurationChange(int param1Int);
    
    void onResolutionTypeChange(int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ResolutionType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\ISettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */