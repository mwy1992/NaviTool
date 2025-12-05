package com.ecarx.xui.adaptapi.dvr.forp;

import com.ecarx.xui.adaptapi.FunctionStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDvrFunction {
  public static final int COMMON_VALUE_ERROR = 253;
  
  public static final int COMMON_VALUE_OFF = 0;
  
  public static final int COMMON_VALUE_ON = 1;
  
  public static final int COMMON_VALUE_UNKNOWN = 255;
  
  float getCustomizeFunctionValue(int paramInt);
  
  int getFunctionValue(int paramInt);
  
  int[] getSupportedFunctionValue(int paramInt);
  
  FunctionStatus isFunctionSupported(int paramInt);
  
  boolean registerFunctionValueWatcher(IFunctionValueWatcher paramIFunctionValueWatcher);
  
  boolean setCustomizeFunctionValue(int paramInt, float paramFloat);
  
  boolean setFunctionValue(int paramInt1, int paramInt2);
  
  boolean unregisterFunctionValueWatcher(IFunctionValueWatcher paramIFunctionValueWatcher);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CommonValue {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DvrFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DvrFunctionValue {}
  
  public static interface IFunctionValueWatcher {
    void onCustomizeFunctionValueChanged(int param1Int, float param1Float);
    
    void onFunctionValueChanged(int param1Int1, int param1Int2);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\IDvrFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */