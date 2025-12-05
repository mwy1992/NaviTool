package com.ecarx.xui.adaptapi.audio.audiofx;

import com.ecarx.xui.adaptapi.FunctionStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IHarmanEqualizer {
  public static final int HARMAN_BAND_HIGH = 3;
  
  public static final int HARMAN_BAND_LOW = 1;
  
  public static final int HARMAN_BAND_MID = 2;
  
  public static final int HARMAN_SETTING_BAND_LEVEL = 8195;
  
  public static final int HARMAN_SETTING_CLARIFI = 8193;
  
  public static final int HARMAN_SETTING_SURROUND_SOUND = 8194;
  
  short getBandLevel(int paramInt);
  
  short[] getBandLevelRange();
  
  boolean isHarmanClariFiOnOff();
  
  FunctionStatus isHarmanSettingSupported(int paramInt);
  
  boolean isSurroundSoundOnOff();
  
  boolean registerHarmanSettingListener(IHarmanSettingListener paramIHarmanSettingListener);
  
  void setBandLevel(int paramInt, short paramShort);
  
  boolean setHarmanClariFiOnOff(boolean paramBoolean);
  
  boolean setSurroundSoundOnOff(boolean paramBoolean);
  
  boolean unregisterHarmanSettingListener(IHarmanSettingListener paramIHarmanSettingListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HarmanBand {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HarmanSettings {}
  
  public static interface IHarmanSettingListener {
    void onBandChanged(int param1Int1, int param1Int2);
    
    void onHarmanSettingStateChanged(int param1Int);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\IHarmanEqualizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */