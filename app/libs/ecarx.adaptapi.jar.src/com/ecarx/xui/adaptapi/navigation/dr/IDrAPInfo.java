package com.ecarx.xui.adaptapi.navigation.dr;

@Deprecated
public interface IDrAPInfo {
  IAcc3d getAcc3d();
  
  IGyro getGyro();
  
  IMountAngle getMountAngle();
  
  IPulse getPulse();
  
  IW4m getW4m();
  
  public static interface IAcc3d {
    int getAxis();
    
    int getInterval();
    
    long getTickTime();
    
    float getValuePitch();
    
    float getValueRoll();
    
    float getValueYaw();
  }
  
  public static interface IGyro {
    int getAxis();
    
    int getInterval();
    
    float getTemperature();
    
    long getTickTime();
    
    float getValuePitch();
    
    float getValueRoll();
    
    float getValueYaw();
  }
  
  public static interface IMountAngle {
    float getPitchMountAngle();
    
    float getRollMountAngle();
    
    float getYawMountAngle();
    
    boolean hasMountAngle();
  }
  
  public static interface IPulse {
    int getInterval();
    
    long getTickTime();
    
    float getValue();
  }
  
  public static interface IW4m {
    int getGearState();
    
    int getInterval();
    
    float getLatAcc();
    
    float getLonAcc();
    
    float getSteerAngle();
    
    long getTickTime();
    
    float getVFL();
    
    float getVFR();
    
    float getVRL();
    
    float getVRR();
    
    float getYawRate();
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\IDrAPInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */