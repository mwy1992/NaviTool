package com.ecarx.xui.adaptapi.car.sensor;

public interface ISensorGroupValue {
  int getInterval();
  
  int getSensorGroupType();
  
  long getTickTime();
  
  public static interface IAcc3dValue extends ISensorGroupValue {
    int getAxis();
    
    float getValuePitch();
    
    float getValueRoll();
    
    float getValueYaw();
  }
  
  public static interface IFourWheelBreakPressure extends ISensorGroupValue {
    float getVFLBreakPressure();
    
    float getVFRBreakPressure();
    
    float getVRLBreakPressure();
    
    float getVRRBreakPressure();
  }
  
  public static interface IGyroValue extends ISensorGroupValue {
    int getAxis();
    
    float getTemperature();
    
    float getValuePitch();
    
    float getValueRoll();
    
    float getValueYaw();
  }
  
  public static interface IShaftTorque extends ISensorGroupValue {
    float getFrontShaftTorque();
    
    float getRearShaftTorque();
  }
  
  public static interface ISpeedPulseValue extends ISensorGroupValue {
    float getSpeedValue();
  }
  
  public static interface IW4mValue extends ISensorGroupValue {
    int getGearState();
    
    float getLatAcc();
    
    float getLonAcc();
    
    float getSteerAngle();
    
    float getVFLSpeed();
    
    float getVFRSpeed();
    
    float getVRLSpeed();
    
    float getVRRSpeed();
    
    float getYawRate();
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\ISensorGroupValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */