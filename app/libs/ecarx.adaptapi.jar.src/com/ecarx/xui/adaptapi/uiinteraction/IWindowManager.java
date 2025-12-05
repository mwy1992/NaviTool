package com.ecarx.xui.adaptapi.uiinteraction;

import android.graphics.Rect;

public interface IWindowManager {
  IWindow[] getWindowList();
  
  boolean registerWindowObserver(IWindowObserver paramIWindowObserver);
  
  boolean unregisterWindowObserver(IWindowObserver paramIWindowObserver);
  
  public static interface IWindow {
    int getDisplayId();
    
    String getPackage();
    
    int getType();
    
    int getUID();
    
    int getViewVisibility();
    
    Rect getWindowFrame();
    
    String getWindowIdentity();
    
    String getWindowTag();
  }
  
  public static interface IWindowObserver {
    void onWindowAdded(IWindowManager.IWindow param1IWindow);
    
    void onWindowRemoved(IWindowManager.IWindow param1IWindow);
  }
  
  public static interface IWindowViewObserver extends IWindowObserver {
    void onWindowFrameChanged(IWindowManager.IWindow param1IWindow, Rect param1Rect1, Rect param1Rect2);
    
    void onWindowVisibilityChanged(IWindowManager.IWindow param1IWindow, int param1Int);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\IWindowManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */