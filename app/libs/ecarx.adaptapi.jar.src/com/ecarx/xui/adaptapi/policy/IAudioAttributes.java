package com.ecarx.xui.adaptapi.policy;

import android.view.Display;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IAudioAttributes {
  public static final int AUDIO_DUCKABLE_DUCK = 1;
  
  public static final int AUDIO_DUCKABLE_UNDUCK = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-27", project = "HX11")
  public static final String CONTENT_TYPE_DAB = "DAB";
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-27", project = "HX11")
  public static final String CONTENT_TYPE_DAB_TA = "DAB_TA";
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-27", project = "HX11")
  public static final String CONTENT_TYPE_FM_TA = "FM_TA";
  
  public static final String CONTENT_TYPE_MD_AM = "AM";
  
  public static final String CONTENT_TYPE_MD_AUDIO_ASSISTANT = "AUDIO_ASSISTAN";
  
  public static final String CONTENT_TYPE_MD_AUX = "AUX";
  
  public static final String CONTENT_TYPE_MD_AU_MEDIA = "AU_MEDIA";
  
  public static final String CONTENT_TYPE_MD_AU_NAVI = "AU_NAVI";
  
  public static final String CONTENT_TYPE_MD_AU_VR_USB = "AU_VR_USB";
  
  public static final String CONTENT_TYPE_MD_AU_VR_WIRELESS = "AU_VR_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_BCALL = "BCALL";
  
  public static final String CONTENT_TYPE_MD_BLUETOOTH_HFP = "BLUETOOTH_HFP";
  
  public static final String CONTENT_TYPE_MD_BLUETOOTH_RINGTONE = "BLUETOOTH_RINGTONE";
  
  public static final String CONTENT_TYPE_MD_BT_AUDIO = "BT_AUDIO";
  
  public static final String CONTENT_TYPE_MD_CP_ALERT = "CP_ALERT";
  
  public static final String CONTENT_TYPE_MD_CP_ALTERNATE = "CP_ALTERNATE";
  
  public static final String CONTENT_TYPE_MD_CP_ALTERNATE_DUCK = "CP_ALTERNATE_DUCK";
  
  public static final String CONTENT_TYPE_MD_CP_HEY_SIRI_AUX_AUDIO_OUT_DUCK = "CP_HEY_SIRI_AUX_AUDIO_OUT_DUCK";
  
  public static final String CONTENT_TYPE_MD_CP_HEY_SIRI_AUX_AUDIO_OUT_DUCK_USB = "CP_HEY_SIRI_AUX_AUDIO_OUT_DUCK_USB";
  
  public static final String CONTENT_TYPE_MD_CP_HEY_SIRI_AUX_AUDIO_OUT_DUCK_WIRELESS = "CP_HEY_SIRI_AUX_AUDIO_OUT_DUCK_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_HEY_SIRI_AUX_AUDIO_OUT_USB = "CP_HEY_SIRI_AUX_AUDIO_OUT_USB";
  
  public static final String CONTENT_TYPE_MD_CP_HEY_SIRI_AUX_AUDIO_OUT_WIRELESS = "CP_HEY_SIRI_AUX_AUDIO_OUT_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_MEDIA = "CP_MEDIA";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_FACETIME_USB = "CP_PHONE_FACETIME_USB";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_FACETIME_WIRELESS = "CP_PHONE_FACETIME_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_FB_USB = "CP_PHONE_FB_USB";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_FB_WIRELESS = "CP_PHONE_FB_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_NB_USB = "CP_PHONE_NB_USB";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_NB_WIRELESS = "CP_PHONE_NB_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_SWB_USB = "CP_PHONE_SWB_USB";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_SWB_WIRELESS = "CP_PHONE_SWB_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_WB_USB = "CP_PHONE_WB_USB";
  
  public static final String CONTENT_TYPE_MD_CP_PHONE_WB_WIRELESS = "CP_PHONE_WB_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_SIRI_SPEAKING_USB = "CP_SIRI_SPEAKING_USB";
  
  public static final String CONTENT_TYPE_MD_CP_SIRI_SPEAKING_WIRELESS = "CP_SIRI_SPEAKING_WIRELESS";
  
  public static final String CONTENT_TYPE_MD_CP_TMP_MEDIA = "CP_TMP_MEDIA";
  
  public static final String CONTENT_TYPE_MD_DAB = "DAB";
  
  public static final String CONTENT_TYPE_MD_DAB_TA = "DAB_TA";
  
  public static final String CONTENT_TYPE_MD_DONOTDISTURB = "DONOTDISTURB";
  
  public static final String CONTENT_TYPE_MD_ECALL = "ECALL";
  
  public static final String CONTENT_TYPE_MD_FM = "FM";
  
  public static final String CONTENT_TYPE_MD_FM_TA = "FM_TA";
  
  public static final String CONTENT_TYPE_MD_ICALL = "ICALL";
  
  public static final String CONTENT_TYPE_MD_ICC = "ICC";
  
  public static final String CONTENT_TYPE_MD_KTV = "KTV";
  
  public static final String CONTENT_TYPE_MD_MOVIE = "MOVIE";
  
  public static final String CONTENT_TYPE_MD_MUSIC = "MUSIC";
  
  public static final String CONTENT_TYPE_MD_NAVI_GUIDANCE = "NAVI_GUIDANCE";
  
  public static final String CONTENT_TYPE_MD_NAVI_HINT = "NAVI_HINT";
  
  public static final String CONTENT_TYPE_MD_ONCALL = "ONCALL";
  
  public static final String CONTENT_TYPE_MD_PHONE_COMING_HINT = "PHONE_COMING_HINT";
  
  public static final String CONTENT_TYPE_MD_TTS = "TTS";
  
  public static final String CONTENT_TYPE_MD_UNKNOWN = "UNKNOWN";
  
  @VendorDefinition(author = "@ECARX", date = "2022-4-15", project = "EF1E")
  public static final String CONTENT_TYPE_OCC = "OCC";
  
  public static final String INPUT_SOURCE_MD_AU_VR_USB = "AA_VU_USB";
  
  public static final String INPUT_SOURCE_MD_AU_VR_WIRELESS = "AA_VU_WIRELESS";
  
  public static final String INPUT_SOURCE_MD_CP_AUX_AUDIO_IN_USB = "CP_AUX_AUDIO_IN_USB";
  
  public static final String INPUT_SOURCE_MD_CP_AUX_AUDIO_IN_WIRELESS = "CP_AUX_AUDIO_IN_WIRELESS";
  
  public static final String INPUT_SOURCE_MD_CP_DEFAULT_INPUT = "CP_DEFAULT_INPUT";
  
  public static final String INPUT_SOURCE_MD_CP_FACETIME_USB = "CP_FACETIME_USB";
  
  public static final String INPUT_SOURCE_MD_CP_FACETIME_WIRELESS = "CP_FACETIME_WIRELESS";
  
  public static final String INPUT_SOURCE_MD_CP_LEGENCY_SIRI_USB = "CP_LEGENCY_SIRI_USB";
  
  public static final String INPUT_SOURCE_MD_CP_LEGENCY_SIRI_WIRELESS = "CP_LEGENCY_SIRI_WIRELESS";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_FB_USB = "CP_PHONE_FB_USB";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_FB_WIRELESS = "CP_PHONE_FB_WIRELESS";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_NB_USB = "CP_PHONE_NB_USB";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_NB_WIRELESS = "CP_PHONE_NB_WIRELESS";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_SWB_USB = "CP_PHONE_SWB_USB";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_SWB_WIRELESS = "CP_PHONE_SWB_WIRELESS";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_WB_USB = "CP_PHONE_WB_USB";
  
  public static final String INPUT_SOURCE_MD_CP_PHONE_WB_WIRELESS = "CP_PHONE_WB_WIRELESS";
  
  public static final String USAGE_ALARM = "ALARM";
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-27", project = "HX11")
  public static final String USAGE_DAB = "DAB";
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-27", project = "HX11")
  public static final String USAGE_DAB_TA = "DAB_TA";
  
  @VendorDefinition(author = "@ECARX", date = "2022-1-27", project = "HX11")
  public static final String USAGE_FM_TA = "FM_TA";
  
  @VendorDefinition(author = "@ECARX", date = "2025-05-25", project = "Lambda")
  public static final String USAGE_MD_AM = "MD_AM";
  
  public static final String USAGE_MD_ASSISTANT = "ASSISTANT";
  
  public static final String USAGE_MD_AU_MEDIA = "AU_MEDIA";
  
  public static final String USAGE_MD_AU_NAVI = "AU_NAVI";
  
  public static final String USAGE_MD_AU_VR_USB = "AU_VR_USB";
  
  public static final String USAGE_MD_AU_VR_WIRELESS = "AU_VR_WIRELESS";
  
  public static final String USAGE_MD_BICALL = "BICALL";
  
  public static final String USAGE_MD_BT_AUDIO = "BT_AUDIO";
  
  public static final String USAGE_MD_CP_ALERT = "CP_ALERT";
  
  public static final String USAGE_MD_CP_ALTERNATE = "CP_ALTERNATE";
  
  public static final String USAGE_MD_CP_ALTERNATE_DUCK = "CP_ALTERNATE_DUCK";
  
  public static final String USAGE_MD_CP_AUX_AUDIO_OUT_DUCK = "CP_AUX_AUDIO_OUT_DUCK";
  
  public static final String USAGE_MD_CP_AUX_AUDIO_OUT_DUCK_USB = "CP_AUX_AUDIO_OUT_DUCK_USB";
  
  public static final String USAGE_MD_CP_AUX_AUDIO_OUT_DUCK_WIRELESS = "CP_AUX_AUDIO_OUT_DUCK_WIRELESS";
  
  public static final String USAGE_MD_CP_AUX_AUDIO_OUT_USB = "CP_AUX_AUDIO_OUT_USB";
  
  public static final String USAGE_MD_CP_AUX_AUDIO_OUT_WIRELESS = "CP_AUX_AUDIO_OUT_WIRELESS";
  
  public static final String USAGE_MD_CP_MEDIA = "CP_MEDIA";
  
  public static final String USAGE_MD_CP_PHONE_FACETIME_USB = "CP_PHONE_FACETIME_USB";
  
  public static final String USAGE_MD_CP_PHONE_FACETIME_WIRELESS = "CP_PHONE_FACETIME_WIRELESS";
  
  public static final String USAGE_MD_CP_PHONE_FB_USB = "CP_PHONE_FB_USB";
  
  public static final String USAGE_MD_CP_PHONE_FB_WIRELESS = "CP_PHONE_FB_WIRELESS";
  
  public static final String USAGE_MD_CP_PHONE_NB_USB = "CP_PHONE_NB_USB";
  
  public static final String USAGE_MD_CP_PHONE_NB_WIRELESS = "CP_PHONE_NB_WIRELESS";
  
  public static final String USAGE_MD_CP_PHONE_SWB_USB = "CP_PHONE_SWB_USB";
  
  public static final String USAGE_MD_CP_PHONE_SWB_WIRELESS = "CP_PHONE_SWB_WIRELESS";
  
  public static final String USAGE_MD_CP_PHONE_WB_USB = "CP_PHONE_WB_USB";
  
  public static final String USAGE_MD_CP_PHONE_WB_WIRELESS = "CP_PHONE_WB_WIRELESS";
  
  public static final String USAGE_MD_CP_SIRI_SPEAKING_USB = "CP_SIRI_SPEAKING_USB";
  
  public static final String USAGE_MD_CP_SIRI_SPEAKING_WIRELESS = "CP_SIRI_SPEAKING_WIRELESS";
  
  public static final String USAGE_MD_CP_TMP_MEDIA = "CP_TMP_MEDIA";
  
  public static final String USAGE_MD_DAB = "DAB";
  
  public static final String USAGE_MD_DAB_TA = "DAB_TA";
  
  public static final String USAGE_MD_DONOTDISTURB = "DONOTDISTURB";
  
  public static final String USAGE_MD_ECALL = "ECALL";
  
  @VendorDefinition(author = "@ECARX", date = "2025-05-25", project = "Lambda")
  public static final String USAGE_MD_FM = "MD_FM";
  
  public static final String USAGE_MD_FM_TA = "FM_TA";
  
  public static final String USAGE_MD_ICC = "ICC";
  
  public static final String USAGE_MD_KTV = "KTV";
  
  public static final String USAGE_MD_MEDIA = "MEDIA";
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-27", project = "Lambda")
  public static final String USAGE_MD_MEDIA_REAR = "REAR_MEDIA";
  
  public static final String USAGE_MD_NAVIGATION_GUIDANCE = "NAVIGATION_GUIDANCE";
  
  public static final String USAGE_MD_NAVIGATION_HINT = "NAVIGATION_HINT";
  
  @VendorDefinition(author = "@ECARX", date = "2022-3-31", project = "EF1E")
  public static final String USAGE_MD_OCC = "USAGE_MD_OCC";
  
  public static final String USAGE_MD_RADIO = "RADIO";
  
  public static final String USAGE_MD_TTS = "TTS";
  
  public static final String USAGE_MD_VOICE_COMMUNICATION = "VOICE_COMMUNICATION";
  
  public static final String USAGE_MD_VOICE_COMMUNICATION_SIGNALLING = "VOICE_COMMUNICATION_SIGNALLING";
  
  public static final String USAGE_NONE = "NONE";
  
  public static final String USAGE_NOTIFICATION = "NOTIFICATION";
  
  public static final String USAGE_NOTIFICATION_RINGTONE = "NOTIFICATION_RINGTONE";
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-26", project = "KX11", requirement = "")
  int getActiveAudioFocusType();
  
  int getAndroidAutoInputSource(String paramString);
  
  int getAudioAtrributesContentType(String paramString);
  
  int getAudioAtrributesUsage(String paramString);
  
  int getAudioAtrributesUsage(String paramString, Display paramDisplay);
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "EF1E")
  int getAudioUsageWithPackageName(String paramString);
  
  int getCarplayInputSource(String paramString);
  
  int registerAudioFocusCallback(IAudioFocusCallback paramIAudioFocusCallback);
  
  void setDuckAudioPolicy(@DuckMode int paramInt1, int paramInt2, int paramInt3);
  
  void unregisterAudioPolicyAsync(IAudioFocusCallback paramIAudioFocusCallback);
  
  String usageToString();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ContentType {}
  
  public static @interface DuckMode {}
  
  public static interface IAudioFocusCallback {
    void onAudioFocusCallbackGain(String param1String);
    
    @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "EF1E")
    void onAudioFocusCallbackGain(String param1String1, String param1String2);
    
    void onAudioFocusCallbackLoss(String param1String);
    
    @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "EF1E")
    void onAudioFocusCallbackLoss(String param1String1, String param1String2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InputSource_Android_Auto {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InputSource_Carplay {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Usage {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\IAudioAttributes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */