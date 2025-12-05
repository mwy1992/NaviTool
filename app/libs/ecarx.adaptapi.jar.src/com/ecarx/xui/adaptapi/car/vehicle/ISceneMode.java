package com.ecarx.xui.adaptapi.car.vehicle;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ISceneMode {
  public static final int SCENE_FUNC_AWAKENING = 788660736;
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-12", project = "smart", requirement = "")
  public static final int SCENE_FUNC_AWAKENING_OFF_REASON = 788660752;
  
  public static final int SCENE_FUNC_BIOCHEMICAL_MODE = 788595712;
  
  public static final int SCENE_FUNC_CHILDREN_MODE = 788596224;
  
  public static final int SCENE_FUNC_CLEAN_MODE = 788595456;
  
  @VendorDefinition(author = "@ECARX", date = "2021-11-29", project = "SMART")
  public static final int SCENE_FUNC_ECO_PLUS_MODE = 788663808;
  
  @VendorDefinition(author = "@ECARX", date = "2022-02-21", project = "smart", requirement = "")
  public static final int SCENE_FUNC_ECO_PLUS_MODE_OFF_REASON = 788663824;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-20", project = "EF1E")
  public static final int SCENE_FUNC_GUARD_MODE = 788663296;
  
  @VendorDefinition(author = "@ECARX", date = "2021-05-14", project = "KX11/EX11")
  public static final int SCENE_FUNC_KING_MODE = 788662016;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-08", project = "SMART")
  public static final int SCENE_FUNC_KTV_MODE = 788664064;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-20", project = "EF1E")
  public static final int SCENE_FUNC_MEETING_MODE = 788663552;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-19", project = "E02")
  public static final int SCENE_FUNC_NAP_MODE = 788662272;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-29", project = "FX11", requirement = "")
  public static final int SCENE_FUNC_NAP_SELECT_THEME_MODE = 788662288;
  
  @VendorDefinition(author = "@ECARX", date = "2021-05-14", project = "KX11/EX11")
  public static final int SCENE_FUNC_NORMAL_MODE = 788661504;
  
  public static final int SCENE_FUNC_PARENT_CHILD = 788660992;
  
  public static final int SCENE_FUNC_PET_MODE = 788595968;
  
  @VendorDefinition(author = "@ECARX", date = "2022-02-21", project = "smart", requirement = "")
  public static final int SCENE_FUNC_PET_MODE_OFF_REASON = 788595984;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-24", project = "KX11")
  public static final int SCENE_FUNC_QUEEN_MODE = 788662528;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-20", project = "EF1E")
  public static final int SCENE_FUNC_REAR_ROW_VIDEO_MODE = 788663040;
  
  @VendorDefinition(author = "@ECARX", date = "2021-05-14", project = "KX11/EX11")
  public static final int SCENE_FUNC_ROMANTIC_MODE = 788661760;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-20", project = "EF1E")
  public static final int SCENE_FUNC_SLEEP_MODE = 788662784;
  
  public static final int SCENE_FUNC_SMOKING = 788660480;
  
  @VendorDefinition(author = "@ECARX", date = "2022-03-28", project = "HX11")
  public static final int SCENE_FUNC_THEATER_MODE = 788594944;
  
  public static final int SCENE_FUNC_WASH_MODE = 788595200;
  
  public static final int SCENE_FUNC_YUEDONG = 788661248;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EcoPlusModeOffReason {
    public static final int AMBIENCE_LIGHT_ON = 788663826;
    
    public static final int DRIVER_MODE_SWITCH = 788663829;
    
    public static final int FRONT_FAN_ON = 788663825;
    
    public static final int SEAT_HEAT_ON = 788663827;
    
    public static final int SEAT_VENTILATION_ON = 788663828;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PetModeOffReason {
    public static final int LOW_SOC = 788595987;
    
    public static final int NON_P = 788595986;
    
    public static final int USAGEMODE_CHANGE = 788595985;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SceneAwakingReasonMode {
    public static final int FAN_OFF = 788660753;
    
    public static final int TIME_OUT = 788660754;
    
    public static final int USAGEMODE_CHANGE = 788660755;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SceneFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SceneNapThemeMode {
    public static final int THEME_MODE_1 = 788662289;
    
    public static final int THEME_MODE_2 = 788662290;
    
    public static final int THEME_MODE_3 = 788662291;
    
    public static final int THEME_MODE_4 = 788662292;
    
    public static final int THEME_MODE_5 = 788662293;
    
    public static final int THEME_MODE_UNKNOWN = 788662288;
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\ISceneMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */