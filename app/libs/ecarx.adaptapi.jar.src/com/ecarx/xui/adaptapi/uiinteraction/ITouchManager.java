package com.ecarx.xui.adaptapi.uiinteraction;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ITouchManager {
  public static final int INTERCEPT_MODE_DISPATCH = 1;
  
  public static final int INTERCEPT_MODE_INTERCEPT = 2;
  
  boolean registerFullScreenTouchListener(int paramInt, View.OnTouchListener paramOnTouchListener);
  
  boolean unregisterFullScreenTouchListener(View.OnTouchListener paramOnTouchListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InterceptMode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\ITouchManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */