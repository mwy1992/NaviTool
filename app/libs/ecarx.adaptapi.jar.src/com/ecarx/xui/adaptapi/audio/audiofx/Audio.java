/*    */ package com.ecarx.xui.adaptapi.audio.audiofx;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.CallStatus;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Audio
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int AUDIO_SETTING_BOOT_UP_MUSIC = 4098;
/*    */   public static final int AUDIO_SETTING_NAVI_MIX_MODE = 4097;
/*    */   public static final int AUDIO_SETTING_SEAT_SOUND_OPTIMIZE = 4099;
/*    */   public static final int AUDIO_SYSTEM_LEVEL_2D_SOURROUND = 2;
/*    */   public static final int AUDIO_SYSTEM_LEVEL_3D_SOURROUND = 4;
/*    */   public static final int AUDIO_SYSTEM_LEVEL_ENTRY = 1;
/*    */   public static final int PRESET_MODE_ALL = 0;
/*    */   public static final int PRESET_MODE_CHAUFFEUR = 3;
/*    */   public static final int PRESET_MODE_DRIVER = 1;
/*    */   public static final int PRESET_MODE_FOUCS_DRIVING = 7;
/*    */   public static final int PRESET_MODE_INDIVIDUAL_1 = 4;
/*    */   public static final int PRESET_MODE_INDIVIDUAL_2 = 5;
/*    */   public static final int PRESET_MODE_KIDS = 2;
/*    */   public static final int PRESET_MODE_REAR_ENTERTAINMENT = 8;
/*    */   
/*    */   public static Audio create(Context paramContext) {
/* 39 */     return AudioImp.create(paramContext);
/*    */   }
/*    */   
/*    */   public static final int PRESET_MODE_REAR_SLEEPING = 6;
/*    */   public static final int SOURROUND_SOUND_LEVEL_HIGH = 64;
/*    */   public static final int SOURROUND_SOUND_LEVEL_LOW = 16;
/*    */   public static final int SOURROUND_SOUND_LEVEL_MEDIUM = 32;
/*    */   public static final int ZONE_LEFT_FRONT_MEDIA = 1;
/*    */   public static final int ZONE_LEFT_FRONT_NAVIGATION = 2;
/*    */   public static final int ZONE_LEFT_FRONT_PHONE = 4;
/*    */   public static final int ZONE_LEFT_REAR_MEDIA = 256;
/*    */   public static final int ZONE_LEFT_REAR_PHONE = 1024;
/*    */   public static final int ZONE_RIGHT_FRONT_MEDIA = 16;
/*    */   public static final int ZONE_RIGHT_FRONT_NAVIGATION = 32;
/*    */   public static final int ZONE_RIGHT_FRONT_PHONE = 64;
/*    */   public static final int ZONE_RIGHT_REAR_MEDIA = 4096;
/*    */   public static final int ZONE_RIGHT_REAR_PHONE = 16384;
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-3-31", project = "EF1E")
/*    */   @AudioChannel
/*    */   public abstract int getAudioChannel();
/*    */   
/*    */   public abstract int getAudioProvider();
/*    */   
/*    */   public abstract IAudioState getAudioState();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
/*    */   public abstract int getAudioSystemLevel();
/*    */   
/*    */   public abstract ICompensation getCompensation();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public abstract int[] getControlZonesByMode(int paramInt);
/*    */   
/*    */   public abstract IEqualizer getEqualizer();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-13", project = "EF1E")
/*    */   public abstract List<String[]> getExternalArtificialSoundList();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-1-27", project = "HX11")
/*    */   public abstract Map<Integer, String> getExternalVirtualEngineSoundPathMap();
/*    */   
/*    */   public abstract IFaderBalance getFaderBalance();
/*    */   
/*    */   public abstract IHarmanEqualizer getHarmanEqualizer();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-21", project = "EF1E")
/*    */   @MicState
/*    */   public abstract int getICCMICState();
/*    */   
/*    */   public abstract FunctionStatus getMicStatus(String paramString);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public abstract int getPresetMode();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
/*    */   public abstract int getSourroundSoundLevel();
/*    */   
/*    */   public abstract FunctionStatus getSpeakerStatus(String paramString);
/*    */   
/*    */   public abstract FunctionStatus isAudioSettingSupported(int paramInt);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public abstract boolean isControlZoneEnable(int paramInt1, int paramInt2);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public abstract boolean isSurroundSoundLevelSupported();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
/*    */   public abstract boolean isSurroundSoundOn();
/*    */   
/*    */   public abstract boolean registerAudioSettingListener(IAudioSettingListener paramIAudioSettingListener);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-21", project = "EF1E")
/*    */   public abstract boolean registerICCMICStateListener(IICCMICStateListener paramIICCMICStateListener);
/*    */   
/*    */   public abstract void setBootUpMusicOnOff(boolean paramBoolean);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public abstract void setControlZoneEnable(int paramInt1, int paramInt2, boolean paramBoolean);
/*    */   
/*    */   public abstract CallStatus setMicOccupyState(@MicState int paramInt);
/*    */   
/*    */   public abstract void setMicStatusListener(String paramString, IMicStatusListener paramIMicStatusListener);
/*    */   
/*    */   public abstract void setNaviVoiceMixMode(int paramInt);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public abstract void setPresetMode(int paramInt);
/*    */   
/*    */   public abstract void setSeatSoundStageOptimize(int paramInt);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
/*    */   public abstract void setSourroundSoundLevel(int paramInt);
/*    */   
/*    */   public abstract void setSpeakerStatusListener(String paramString, ISpeakerListener paramISpeakerListener);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
/*    */   public abstract void setSurroundSoundOnOff(boolean paramBoolean);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-27", project = "EF1E")
/*    */   public abstract void setVRPasTTSSoundZoneSwitchState(int paramInt);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-21", project = "EF1E")
/*    */   public abstract CallStatus setVRState(int paramInt1, @MicState int paramInt2);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-27", project = "EF1E")
/*    */   public abstract void startVrPasTts(int paramInt);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-27", project = "EF1E")
/*    */   public abstract void stopVrPasTts();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-3-31", project = "EF1E")
/*    */   public abstract CallStatus switchAudioChannel(@AudioChannel int paramInt);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-10-12", project = "EF1E")
/*    */   public abstract void switchAudioChannel(@AudioChannel int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract boolean unregisterAudioSettingListener(IAudioSettingListener paramIAudioSettingListener);
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-21", project = "EF1E")
/*    */   public abstract boolean unregisterICCMICStateListener(IICCMICStateListener paramIICCMICStateListener);
/*    */   
/*    */   @Retention(RetentionPolicy.CLASS)
/*    */   public static @interface AudioChannel {
/*    */     public static final int CHANNEL_BOTH = 2;
/*    */     public static final int CHANNEL_EXTERIOR = 1;
/*    */     public static final int CHANNEL_INTERIOR = 0;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface AudioSettings {}
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
/*    */   static @interface AudioSystemLevel {}
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public static @interface ControlZoneType {}
/*    */   
/*    */   public static interface IAudioSettingListener {
/*    */     void onAudioSettingStateChanged(int param1Int);
/*    */     
/*    */     void onNaviMixModeChanged(int param1Int);
/*    */     
/*    */     void onTwoSurroundChanged(boolean param1Boolean);
/*    */   }
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-6-21", project = "EF1E")
/*    */   public static interface IICCMICStateListener {
/*    */     @VendorDefinition(author = "@ECARX", date = "2022-6-21", project = "EF1E")
/*    */     void onICCMICStateChanged(int param1Int);
/*    */   }
/*    */   
/*    */   public static interface IMicStatusListener {
/*    */     void onMicStatusChanged(String param1String, FunctionStatus param1FunctionStatus);
/*    */   }
/*    */   
/*    */   public static interface ISpeakerListener {
/*    */     void onSpeakerStatusChanged(String param1String, FunctionStatus param1FunctionStatus);
/*    */   }
/*    */   
/*    */   static @interface MicState {
/*    */     public static final int ABANDON = 0;
/*    */     public static final int END_OF_SOUND = 3;
/*    */     public static final int OCCUPY = 1;
/*    */     public static final int SOUND = 2;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface MicWakeState {
/*    */     public static final int CSD_BUTTON = 1;
/*    */     public static final int HARD_KEY = 0;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface PasTtsPos {
/*    */     public static final int FRONT_LEFT = 0;
/*    */     public static final int FRONT_RIGHT = 1;
/*    */     public static final int REAR_LEFT = 2;
/*    */     public static final int REAR_RIGHT = 3;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface PasTtsSoundZoneSwitch {
/*    */     public static final int OFF = 0;
/*    */     public static final int ON = 1;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-09-08", project = "Lambda")
/*    */   public static @interface PresetMode {}
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   @VendorDefinition(author = "@ECARX", date = "2021-06-30", project = "Lambda")
/*    */   static @interface SourroundSoundLevel {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\Audio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */