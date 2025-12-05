package com.ecarx.xui.adaptapi.car.base;

import com.ecarx.xui.adaptapi.FunctionStatus;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ICarFunction {
  public static final int CAR_MODULE_ADAS = 671088640;
  
  public static final int CAR_MODULE_AMBIENCE_LIGHT = 704643072;
  
  public static final int CAR_MODULE_AUDIO = 771751936;
  
  public static final int CAR_MODULE_BCM = 553648128;
  
  public static final int CAR_MODULE_COMMON = 0;
  
  public static final int CAR_MODULE_DAYMODE = 687865856;
  
  public static final int CAR_MODULE_DRIVE_MODE = 570425344;
  
  public static final int CAR_MODULE_HUD = 654311424;
  
  public static final int CAR_MODULE_HVAC = 268435456;
  
  public static final int CAR_MODULE_HYBRID = 603979776;
  
  public static final int CAR_MODULE_LAMP = 721420288;
  
  public static final int CAR_MODULE_PAS = 587202560;
  
  public static final int CAR_MODULE_SAFETY = 738197504;
  
  public static final int CAR_MODULE_SCENE = 788529152;
  
  public static final int CAR_MODULE_SEAT = 754974720;
  
  public static final int CAR_MODULE_SETTING = 536870912;
  
  public static final int CAR_MODULE_SUPERHYBRID = 822083584;
  
  public static final int CAR_MODULE_UNIT = 620756992;
  
  public static final int CAR_MODULE_VENDOR = -2147483648;
  
  public static final int CAR_MODULE_VOICE = 805306368;
  
  public static final int CAR_MODULE_WPC = 637534208;
  
  public static final int COMMON_VALUE_DEFAULT = 2;
  
  public static final int COMMON_VALUE_ERROR = 253;
  
  public static final int COMMON_VALUE_NONE = 254;
  
  public static final int COMMON_VALUE_OFF = 0;
  
  public static final int COMMON_VALUE_ON = 1;
  
  public static final int COMMON_VALUE_UNKNOWN = 255;
  
  float getCustomizeFunctionValue(int paramInt) throws UnsupportedOperationException;
  
  float getCustomizeFunctionValue(int paramInt1, int paramInt2) throws UnsupportedOperationException;
  
  int getFunctionValue(int paramInt) throws UnsupportedOperationException;
  
  int getFunctionValue(int paramInt1, int paramInt2) throws UnsupportedOperationException;
  
  int[] getSupportedFunctionValue(int paramInt) throws UnsupportedOperationException;
  
  int[] getSupportedFunctionValue(int paramInt1, int paramInt2) throws UnsupportedOperationException;
  
  int[] getSupportedFunctionZones(int paramInt) throws UnsupportedOperationException;
  
  FunctionStatus isFunctionSupported(int paramInt);
  
  FunctionStatus isFunctionSupported(int paramInt1, int paramInt2);
  
  FunctionStatus isFunctionSupported(int paramInt1, int paramInt2, int paramInt3);
  
  boolean registerFunctionValueWatcher(int paramInt, IFunctionValueWatcher paramIFunctionValueWatcher) throws UnsupportedOperationException;
  
  boolean registerFunctionValueWatcher(IFunctionValueWatcher paramIFunctionValueWatcher) throws UnsupportedOperationException;
  
  boolean registerFunctionValueWatcher(int[] paramArrayOfint, IFunctionValueWatcher paramIFunctionValueWatcher) throws UnsupportedOperationException;
  
  boolean setCustomizeFunctionValue(int paramInt, float paramFloat) throws UnsupportedOperationException;
  
  boolean setCustomizeFunctionValue(int paramInt1, int paramInt2, float paramFloat) throws UnsupportedOperationException;
  
  boolean setFunctionValue(int paramInt1, int paramInt2) throws UnsupportedOperationException;
  
  boolean setFunctionValue(int paramInt1, int paramInt2, int paramInt3) throws UnsupportedOperationException;
  
  boolean unregisterFunctionValueWatcher(IFunctionValueWatcher paramIFunctionValueWatcher) throws UnsupportedOperationException;
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CarFunction {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CarFunctionFlt {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CarFunctionInt {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CarFunctionValue {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CarModule {}
  
  public static interface IFunctionValueWatcher {
    void onCustomizeFunctionValueChanged(int param1Int1, int param1Int2, float param1Float);
    
    void onFunctionChanged(int param1Int);
    
    void onFunctionValueChanged(int param1Int1, int param1Int2, int param1Int3);
    
    void onSupportedFunctionStatusChanged(int param1Int1, int param1Int2, FunctionStatus param1FunctionStatus);
    
    void onSupportedFunctionValueChanged(int param1Int, int[] param1ArrayOfint);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\base\ICarFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */