package com.ecarx.xui.adaptapi.diminteraction;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VendorDefinition(author = "@ECARX", date = "2020-07-24", project = "ALL", requirement = "XQ2020072339282")
public interface IDimMenuInteraction {
  public static final int ACTIVE_TYPE_IDLE = 0;
  
  public static final int ACTIVE_TYPE_MEDIA_PLAYING = 1;
  
  public static final int ACTIVE_TYPE_NO_CALLING = 4;
  
  public static final int ACTIVE_TYPE_NO_MEDIA = 3;
  
  public static final int ACTIVE_TYPE_PHONE_CALLING = 2;
  
  public static final int CENTER_STATE_CALL = 2;
  
  public static final int CENTER_STATE_EXIT = 0;
  
  public static final int CENTER_STATE_MEDIA = 1;
  
  public static final int ENTER_ACTION_MEDIA_CONFIRM_KEY = 1;
  
  public static final int ENTER_ACTION_N_SECONDS_NO_ACTION = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int MENU_TAB_CONTROL_CENTER = 4;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-01", project = "KX11")
  public static final int MENU_TAB_MENU_CLOSE = 5;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-01", project = "KX11")
  public static final int MENU_TAB_MENU_OPEN_OTHER = 0;
  
  public static final int MENU_TAB_MUSIC = 3;
  
  public static final int MENU_TAB_NAVIGATION = 2;
  
  public static final int MENU_TAB_PHONE = 1;
  
  public static final int NAVI_MODE_3D_LANE = 5;
  
  public static final int NAVI_MODE_AR = 4;
  
  public static final int NAVI_MODE_FULL = 3;
  
  public static final int NAVI_MODE_OFF = 1;
  
  public static final int NAVI_MODE_SIMPLIFY = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int THEME_COLOR_ADAS = 7;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int THEME_COLOR_COMFORT = 1;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int THEME_COLOR_DYNAMIC = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int THEME_COLOR_ECO = 4;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int THEME_COLOR_TERRAIN = 3;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int THEME_DAY = 5;
  
  @VendorDefinition(author = "@ECARX", date = "2021-08-12", project = "EX11")
  public static final int THEME_NIGHT = 6;
  
  int getNaviMode();
  
  void notifyDimControlCenterActiveType(int paramInt);
  
  void notifyDimEnterControlCenter(int paramInt);
  
  void notifyDimSwitchThemeCompeted(boolean paramBoolean);
  
  void notifyIHUReady();
  
  void registerDimMenuInteractionCallback(IDimMenuInteractionCallback paramIDimMenuInteractionCallback);
  
  void requestDimSwitchTabWindow(int paramInt);
  
  void requestDimTheme();
  
  @Deprecated
  void setVolume(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-9-26", project = "EX11")
  void setVolume(boolean paramBoolean, int paramInt);
  
  boolean switchNaviMode(int paramInt);
  
  void unregisterDimMenuInteractionCallback(IDimMenuInteractionCallback paramIDimMenuInteractionCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ControlCenterActiveType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ControlCenterState {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DimMenuTab {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DimTheme {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EnterControlCenterAction {}
  
  public static interface IDimMenuInteractionCallback {
    void onChangeNaviMode(int param1Int);
    
    void onControlCenterStateChanged(int param1Int);
    
    @VendorDefinition(author = "@ECARX", date = "2021-4-25", project = "KX11/EX11")
    void onEngineStatusChanged(boolean param1Boolean);
    
    void onTabChanged(int param1Int);
    
    void onThemeChanged(int param1Int);
    
    @VendorDefinition(author = "@ECARX", date = "2021-8-6", project = "EX11")
    void onVolumeBarStatusChanged(boolean param1Boolean);
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NaviMode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\IDimMenuInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */