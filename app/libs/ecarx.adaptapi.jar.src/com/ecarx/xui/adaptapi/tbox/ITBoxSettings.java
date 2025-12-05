package com.ecarx.xui.adaptapi.tbox;

import com.ecarx.xui.adaptapi.FunctionStatus;

@Deprecated
public interface ITBoxSettings {
  boolean isCarLocatorEnabled();
  
  FunctionStatus isCarLocatorSupported();
  
  boolean isKeylockEnabled();
  
  FunctionStatus isKeylockSupported();
  
  boolean isRVDCEnabled();
  
  void setCarLocatorCallback(ICarLocatorCallback paramICarLocatorCallback);
  
  void setCarLocatorEnable(boolean paramBoolean);
  
  void setKeylockCallback(IKeylockCallback paramIKeylockCallback);
  
  void setKeylockEnable(boolean paramBoolean);
  
  void setRVDCStatus(boolean paramBoolean);
  
  void unsetCarLocatorCallback(ICarLocatorCallback paramICarLocatorCallback);
  
  void unsetKeylockCallback(IKeylockCallback paramIKeylockCallback);
  
  public static interface ICarLocatorCallback {
    void onCarLocatorEnabled(boolean param1Boolean);
    
    void onRVDCEnabled(boolean param1Boolean);
  }
  
  public static interface IKeylockCallback {
    void onKeylockEnabled(boolean param1Boolean);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\ITBoxSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */