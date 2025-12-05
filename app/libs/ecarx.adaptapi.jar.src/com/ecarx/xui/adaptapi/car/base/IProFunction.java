package com.ecarx.xui.adaptapi.car.base;

import com.ecarx.xui.adaptapi.CallStatus;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IProFunction extends ICarFunction {
  <E> IProValue<E> getProperty(int paramInt) throws UnsupportedOperationException;
  
  <E> IProValue<E> getProperty(int paramInt1, int paramInt2) throws UnsupportedOperationException;
  
  <E> CallStatus setProperty(IProValue<E> paramIProValue);
  
  public static interface IPropertyWatcher extends ICarFunction.IFunctionValueWatcher {
    <E> void onPropertyChanged(IProValue<E> param1IProValue);
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PropertyId {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\base\IProFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */