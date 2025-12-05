package com.ecarx.xui.adaptapi.uiinteraction;

import com.ecarx.xui.adaptapi.FunctionStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IMultiWindow {
  public static final int SCREEN_TYPE_BOTTOM = 4;
  
  public static final int SCREEN_TYPE_LEFT = 1;
  
  public static final int SCREEN_TYPE_RIGHT = 2;
  
  public static final int SCREEN_TYPE_TOP = 3;
  
  void closeSplitScreenMode();
  
  void closeSplitScreenMode(int paramInt);
  
  String getScreenStackPackageName(int paramInt);
  
  boolean isActivitySupportedSplitScreen(String paramString1, String paramString2);
  
  boolean isInSplitScreenWindowingMode();
  
  boolean isPackageSupportedSplitScreen(String paramString);
  
  FunctionStatus isSplitScreenModeSupported();
  
  int moveActivityBetweenDisplay(int paramInt);
  
  void swapDockedAndFullscreenStack();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScreenType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\IMultiWindow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */