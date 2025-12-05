package com.ecarx.xui.adaptapi.tpms;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ICalibrator {
  public static final int CALIBRATE_WARNING_CMN_WARN = 1;
  
  public static final int CALIBRATE_WARNING_FL_WARN = 2;
  
  public static final int CALIBRATE_WARNING_FR_WARN = 3;
  
  public static final int CALIBRATE_WARNING_NO_WARN = 0;
  
  public static final int CALIBRATE_WARNING_RL_WARN = 4;
  
  public static final int CALIBRATE_WARNING_RR_WARN = 5;
  
  public static final int CALIBRATE_WARNING_SYS_FAILR = 7;
  
  public static final int CALIBRATE_WARNING_SYS_NOT_AVI = 6;
  
  public static final int STATE_CALIBRATING = 5;
  
  public static final int STATE_FAILED = 3;
  
  public static final int STATE_IDLE = 1;
  
  public static final int STATE_SUCCESS = 2;
  
  public static final int STATE_TIME_OUT = 4;
  
  public static final int STATE_UNKNOWN = 2147483637;
  
  int getCalibrateWarning();
  
  boolean isTirePressureCalibrationReady();
  
  boolean registerCalibrationStateListener(ICalibrationStateListener paramICalibrationStateListener);
  
  boolean releaseTirePressureCalibrationCallback(ITirePressureCalibrationCallback paramITirePressureCalibrationCallback);
  
  boolean requestTirePressureCalibration(ITirePressureCalibrationCallback paramITirePressureCalibrationCallback);
  
  boolean unregisterCalibrationStateListener(ICalibrationStateListener paramICalibrationStateListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CalibrateWarning {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CalibrationState {}
  
  public static interface ICalibrationStateListener {
    void onCalibrateWarning(int param1Int);
    
    void onCalibrationReady(boolean param1Boolean);
  }
  
  public static interface ITirePressureCalibrationCallback {
    void onTirePressureCalibrationStateChanged(int param1Int);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tpms\ICalibrator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */