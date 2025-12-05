package com.ecarx.xui.adaptapi.car.base;

import com.ecarx.xui.adaptapi.FunctionStatus;

public interface IProValue<T> {
  int getPropertyId();
  
  FunctionStatus getStatus();
  
  T getValue();
  
  int getZoneId();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\base\IProValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */