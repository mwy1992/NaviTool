package com.ecarx.xui.adaptapi.car.sensor;

import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.car.Pairs;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public interface ISensorFunction<T> {
  public static final int SENSOR_TYPE_CONTINUOUS = 1;
  
  public static final int SENSOR_TYPE_EVENT = 2;
  
  public static final int SENSOR_TYPE_GROUP = 3;
  
  public static final int SENSOR_TYPE_NOT_SUPPORT = 0;
  
  ISensorStatus<T> sensorType(int paramInt);
  
  public static interface ISensorEnd<T> {
    void addTo(Consumer<ISensorFunction<T>> param1Consumer);
  }
  
  public static interface ISensorStatus<T> {
    ISensorFunction.ISensorValue<T> fixStatus(FunctionStatus param1FunctionStatus);
    
    ISensorFunction.ISensorValue<T> usePAToStatus(int param1Int);
    
    ISensorFunction.ISensorValue<T> useSigToStatus(int param1Int, IntFunction<FunctionStatus> param1IntFunction);
    
    ISensorFunction.ISensorValue<T> useSigsToStatus(Supplier<FunctionStatus> param1Supplier, int... param1VarArgs);
  }
  
  public static interface ISensorValue<T> {
    ISensorFunction.ISensorEnd<T> useSigOrPaToValue(int param1Int, IntFunction<T> param1IntFunction);
    
    ISensorFunction.ISensorEnd<T> useSigOrPaToValue(Pairs<Integer, T> param1Pairs, int param1Int);
    
    ISensorFunction.ISensorEnd<T> useSigsOrPasToValue(Supplier<T> param1Supplier, int... param1VarArgs);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\ISensorFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */