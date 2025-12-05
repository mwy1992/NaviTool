package com.ecarx.xui.adaptapi.policy;

import android.view.Display;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IWindowManagerPolicy {
  public static final String CODE_ACTIVATE_PAGE = "ACTIVATE_PAGE";
  
  public static final String CODE_ACTIVATE_PAGE_TRD = "ACTIVATE_PAGE_TRD";
  
  @Deprecated
  public static final String CODE_APP_POP_FULLSCREEN = "APP_POP_FULLSCREEN";
  
  @Deprecated
  public static final String CODE_APP_TOAST = "APP_TOAST";
  
  public static final String CODE_CAMERA_RADAR = "CAMERA_RADAR";
  
  public static final String CODE_CONVENIENCE_MODE = "CONVENIENCE_MODE";
  
  public static final String CODE_DOCK_BAR = "DOCK_BAR";
  
  public static final String CODE_DRIVING_MODE_POP = "DRIVING_MODE_POP";
  
  public static final String CODE_HARDWARE_TOAST = "HARDWARE_TOAST";
  
  public static final String CODE_INTELLIGENT_AVATAR = "INTELLIGENT_AVATAR";
  
  public static final String CODE_LANDING_PAGE = "LANDING_PAGE";
  
  public static final String CODE_LAUNCHER_APP = "LAUNCHER_APP";
  
  @Deprecated
  public static final String CODE_LOCK_SCREEN_VIEW = "LOCK_SCREEN_VIEW";
  
  public static final String CODE_NAVIGATION_BAR = "NAVIGATION_BAR";
  
  public static final String CODE_NEWCOMER_GUIDE = "NEWCOMER_GUIDE";
  
  public static final String CODE_NOTIFY_CENTER = "NOTIFY_CENTER";
  
  @Deprecated
  public static final String CODE_ONCALL = "ONCALL";
  
  public static final String CODE_OTA_POPUP = "OTA_POPUP";
  
  public static final String CODE_PARTIAL = "PARTIAL";
  
  public static final String CODE_PHONE_POPUP = "PHONE_POPUP";
  
  public static final String CODE_SCREENSAVER = "SCREENSAVER";
  
  public static final String CODE_SOS = "SOS";
  
  public static final String CODE_SPLIT_WINDOW_MENU = "SPLIT_WINDOW_MENU";
  
  public static final String CODE_STARTUP_WARNING = "STARTUP_WARNING";
  
  public static final String CODE_STATUS_BAR = "STATUS_BAR";
  
  public static final String CODE_STATUS_BAR_POP = "STATUS_BAR_POP";
  
  public static final String CODE_SWIPE_FROM_BOTTOM_VIEW = "SWIPE_FROM_BOTTOM_VIEW";
  
  public static final String CODE_SWIPE_FROM_LEFT_VIEW = "SWIPE_FROM_LEFT_VIEW";
  
  public static final String CODE_SWIPE_FROM_RIGHT_VIEW = "SWIPE_FROM_RIGHT_VIEW";
  
  public static final String CODE_SWIPE_FROM_TOP_VIEW = "SWIPE_FROM_TOP_VIEW";
  
  public static final String CODE_THEME_LOADING = "THEME_LOADING";
  
  @Deprecated
  public static final String CODE_UNLOCK_SCREEN_VIEW = "UNLOCK_SCREEN_VIEW";
  
  public static final String CODE_VPA_VECHCON = "VPA_VECHCON";
  
  public static final String CODE_XIAOKA = "XIAOKA";
  
  int getWindowTypeByCode(String paramString);
  
  int getWindowTypeByCode(String paramString, Display paramDisplay);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WindowCode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\IWindowManagerPolicy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */