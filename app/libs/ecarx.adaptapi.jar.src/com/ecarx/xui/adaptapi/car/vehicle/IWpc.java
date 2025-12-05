package com.ecarx.xui.adaptapi.car.vehicle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IWpc {
  public static final int CHARGE_STATE_CHARGING = 637665539;
  
  public static final int CHARGE_STATE_ERROR = 637665541;
  
  public static final int CHARGE_STATE_FAST_CHARGING = 637665546;
  
  public static final int CHARGE_STATE_FOD = 637665544;
  
  public static final int CHARGE_STATE_FULLY_CHARGED = 637665540;
  
  public static final int CHARGE_STATE_NO_DEVICE = 637665537;
  
  public static final int CHARGE_STATE_OFF = 0;
  
  public static final int CHARGE_STATE_OVERHEAT = 637665542;
  
  public static final int CHARGE_STATE_OVERPOWER = 637665543;
  
  public static final int CHARGE_STATE_OVERVOLTAGE = 637665552;
  
  public static final int CHARGE_STATE_PEPS_INTERRUPT = 637665545;
  
  public static final int CHARGE_STATE_STANDBY = 637665538;
  
  public static final int CHARGE_STATE_UNKNOWN = 255;
  
  public static final int WORK_MODE_AUTO = 637600001;
  
  public static final int WORK_MODE_OFF = 0;
  
  public static final int WPC_FUNC_CHARGE_FORGET_REMINDER = 637731072;
  
  public static final int WPC_FUNC_CHARGE_STATES = 637665536;
  
  public static final int WPC_FUNC_WORK_MODE = 637600000;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChargingStates {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WorkMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WpcFunction {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\IWpc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */