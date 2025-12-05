package com.ecarx.xui.adaptapi.audio.audiofx;

import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IEqualizer {
  public static final int EQUALIZER_CLASSIC = 4;
  
  public static final int EQUALIZER_FLAT = 0;
  
  public static final int EQUALIZER_JAZZ = 3;
  
  public static final int EQUALIZER_POP = 1;
  
  public static final int EQUALIZER_ROCK = 2;
  
  public static final int EQUALIZER_VOICE = 5;
  
  public static final int MAX_BASS_LEVEL_HIGH = 3;
  
  public static final int MAX_BASS_LEVEL_LOW = 1;
  
  public static final int MAX_BASS_LEVEL_MEDIUM = 2;
  
  short getBand(int paramInt);
  
  int[] getBandFreqRange(short paramShort);
  
  short getBandLevel(short paramShort);
  
  short[] getBandLevelRange();
  
  int getCenterFreq(short paramShort);
  
  short getCurrentPreset();
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
  int getMaxBassLevel();
  
  short getNumberOfBands();
  
  short getNumberOfPresets();
  
  String getPresetName(short paramShort);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-14", project = "SMART")
  int[] getSupportAudioEqualizerArr();
  
  FunctionStatus isEqualizerSupported();
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
  boolean isMaxBassOn();
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
  boolean isMaxBassSupported();
  
  boolean registerEqualizerStateListener(IEqualizerStateListener paramIEqualizerStateListener);
  
  void setBandLevel(short paramShort1, short paramShort2);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
  void setMaxBassLevel(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-07-13", project = "Lambda")
  void setMaxBassOn(boolean paramBoolean);
  
  boolean unregisterEqualizerStateListener(IEqualizerStateListener paramIEqualizerStateListener);
  
  void usePreset(short paramShort);
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2022-06-14", project = "SMART")
  public static @interface AudioEqualizerType {}
  
  public static interface IEqualizerStateListener {
    void onEqualizerModeChanged(int param1Int);
    
    void onEqualizerStateChanged(FunctionStatus param1FunctionStatus);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
  public static @interface MaxBassLevel {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\IEqualizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */