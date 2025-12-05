package com.ecarx.xui.adaptapi.audio.audiofx;

import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ICompensation {
  public static final int AUDIO_SETTING_COMPENSATION_LEVEL = 3;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-23", project = "3BE02")
  public static final int AUDIO_SETTING_DTS_SOUND = 5;
  
  public static final int AUDIO_SETTING_EFFECT_ENHANCE = 4;
  
  public static final int AUDIO_SETTING_LOUDNESS_COMPENSATION = 1;
  
  public static final int AUDIO_SETTING_SPEED_COMPENSATION = 2;
  
  public static final int COMPENSATION_LEVEL_HIGH = 101;
  
  public static final int COMPENSATION_LEVEL_LOW = 99;
  
  public static final int COMPENSATION_LEVEL_MEDIUM = 100;
  
  public static final int COMPENSATION_LEVEL_OFF = 98;
  
  public static final int DTS_MODE_CINEMA = 4;
  
  public static final int DTS_MODE_DYNAMIC = 2;
  
  public static final int DTS_MODE_NATURAL = 1;
  
  public static final int DTS_MODE_OFF = 0;
  
  public static final int DTS_MODE_VOICE = 3;
  
  public static final int EFFECT_ENHANCE_ALL_BLANCE = 4;
  
  public static final int EFFECT_ENHANCE_CENTERPOINT = 5;
  
  public static final int EFFECT_ENHANCE_DRIVE = 1;
  
  public static final int EFFECT_ENHANCE_OFF = 0;
  
  public static final int EFFECT_ENHANCE_PASSENGER = 2;
  
  int getCompensationLevelOfSpeedCompensatedVolume();
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-23", project = "3BE02")
  int getDtsSoundMode();
  
  int getEffectEnhanceMode();
  
  int[] getSupportedEffectEnhanceMode();
  
  FunctionStatus isCompensationSettingSupported(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-23", project = "3BE02")
  boolean isDtsSoundEnabled();
  
  boolean isLoudnessEnabled();
  
  boolean isSpeedCompensatedVolumeEnabled();
  
  boolean registerCompensationSettingListener(ICompensationSettingListener paramICompensationSettingListener);
  
  void setCompensationLevelOfSpeedCompensatedVolume(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-23", project = "3BE02")
  boolean setDtsSoundMode(int paramInt);
  
  boolean setEffectEnhanceMode(int paramInt);
  
  void setLoudnessEnable(boolean paramBoolean);
  
  void setSpeedCompensatedVolumeEnable(boolean paramBoolean);
  
  boolean unregisterCompensationSettingListener(ICompensationSettingListener paramICompensationSettingListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CompensationLevel {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CompensationSettings {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-06-23", project = "3BE02")
  public static @interface DtsSoundMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EffectEnhanceMode {}
  
  public static interface ICompensationSettingListener {
    void onCompensationSettingStateChanged(int param1Int);
    
    void onEffectEnhanceModeChanged(int param1Int);
    
    void onLevelOfSpeedVolumeChanged(int param1Int);
    
    void onLoudnessChanged(boolean param1Boolean);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\ICompensation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */