package com.ecarx.xui.adaptapi.car.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IAudio {
  public static final int ACOUSTIC_EFFECT_MODE_JAZZ = 771817729;
  
  public static final int ACOUSTIC_EFFECT_MODE_OFF = 0;
  
  public static final int ACOUSTIC_EFFECT_MODE_OPERA = 771817730;
  
  public static final int ACOUSTIC_EFFECT_MODE_THEATRE = 771817731;
  
  public static final int AUDIO_DEVICE_FAULT = 772014339;
  
  public static final int AUDIO_DEVICE_NORMAL = 772014337;
  
  public static final int AUDIO_DEVICE_RESTORE = 772014338;
  
  public static final int SETTING_FUNC_ACOUSTIC_EFFECT_MODE = 771817728;
  
  public static final int SETTING_FUNC_AUDIO_DEVICE_STATE = 772014336;
  
  public static final int SETTING_FUNC_AUDIO_SEPARATED = 771948800;
  
  public static final int SETTING_FUNC_CAE_SWITCH = 771818240;
  
  public static final int SETTING_FUNC_HXT_SWITCH = 771817984;
  
  public static final int SETTING_FUNC_MULTIMEDIA_SOUND_EFFECT = 771818496;
  
  public static final int SETTING_FUNC_SOFT_BUTTON_SOUND_TYPE = 771883264;
  
  public static final int SETTING_FUNC_SOUND_WARNING_VOLUME = 538771712;
  
  public static final int SOFT_BUTTON_SOUND_TYPE_1 = 771883265;
  
  public static final int SOFT_BUTTON_SOUND_TYPE_2 = 771883266;
  
  public static final int SOFT_BUTTON_SOUND_TYPE_3 = 771883267;
  
  public static final int SOFT_BUTTON_SOUND_TYPE_OFF = 0;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AcousticEffectMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AudioDeviceState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AudioFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SoftButtonSoundType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IAudio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */