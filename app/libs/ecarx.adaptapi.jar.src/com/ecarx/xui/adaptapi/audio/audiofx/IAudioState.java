package com.ecarx.xui.adaptapi.audio.audiofx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IAudioState {
  public static final int AUDIO_PROVIDER_BOSE = 2;
  
  public static final int AUDIO_PROVIDER_DEFAULT = 0;
  
  public static final int AUDIO_PROVIDER_HARMAN = 1;
  
  public static final int NAVI_VOICE_MIX_AUTO = 1;
  
  public static final int NAVI_VOICE_MIX_DIRECTLY = 2;
  
  int getNaviVoiceMixMode();
  
  int getSoundStageOptimizedSeat();
  
  boolean isBootUpMusicOn();
  
  boolean isSoundStageOptimizedSeatSupported();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AudioProvider {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NaviVoiceMixMode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\IAudioState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */