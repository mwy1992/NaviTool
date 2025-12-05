package com.ecarx.xui.adaptapi.car.sensor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ITireSensor {
  public static final int QUICKLEAKING_STATE_NORMAL = 5247233;
  
  public static final int QUICKLEAKING_STATE_WARN = 5247234;
  
  public static final int TIRE_MSG_FLAG_FRONT_LEFT = 5249280;
  
  public static final int TIRE_MSG_FLAG_FRONT_RIGHT = 5251072;
  
  public static final int TIRE_MSG_FLAG_REAR_LEFT = 5251328;
  
  public static final int TIRE_MSG_FLAG_REAR_RIGHT = 5251584;
  
  public static final int TIRE_PRESSURE_FRONT_LEFT = 5243136;
  
  public static final int TIRE_PRESSURE_FRONT_RIGHT = 5243392;
  
  public static final int TIRE_PRESSURE_REAR_LEFT = 5243648;
  
  public static final int TIRE_PRESSURE_REAR_RIGHT = 5243904;
  
  public static final int TIRE_SENSOR_STATES_FRONT_LEFT = 5248256;
  
  public static final int TIRE_SENSOR_STATES_FRONT_RIGHT = 5248512;
  
  public static final int TIRE_SENSOR_STATES_REAR_LEFT = 5248768;
  
  public static final int TIRE_SENSOR_STATES_REAR_RIGHT = 5249024;
  
  public static final int TIRE_SENSOR_STATE_BATTERY_LOW = 5248261;
  
  public static final int TIRE_SENSOR_STATE_COLLECTING = 5248258;
  
  public static final int TIRE_SENSOR_STATE_COLLECT_COMPLETED = 5248259;
  
  public static final int TIRE_SENSOR_STATE_ERROR = 5248260;
  
  public static final int TIRE_SENSOR_STATE_INITIAL = 5248257;
  
  public static final int TIRE_SENSOR_STATE_UNKNOWN = -1;
  
  public static final int TIRE_TEMPERATURE_FRONT_LEFT = 5244160;
  
  public static final int TIRE_TEMPERATURE_FRONT_RIGHT = 5244416;
  
  public static final int TIRE_TEMPERATURE_REAR_LEFT = 5244672;
  
  public static final int TIRE_TEMPERATURE_REAR_RIGHT = 5244928;
  
  public static final int TIRE_TPMS_SYS_STATES = 5259264;
  
  public static final int TIRE_WARNING_FRONT_LEFT = 5245184;
  
  public static final int TIRE_WARNING_FRONT_LEFT_QUICKLEAKING = 5247232;
  
  public static final int TIRE_WARNING_FRONT_LEFT_TEMPERATURE = 5246208;
  
  public static final int TIRE_WARNING_FRONT_RIGHT = 5245440;
  
  public static final int TIRE_WARNING_FRONT_RIGHT_QUICKLEAKING = 5247488;
  
  public static final int TIRE_WARNING_FRONT_RIGHT_TEMPERATURE = 5246464;
  
  public static final int TIRE_WARNING_REAR_LEFT = 5245696;
  
  public static final int TIRE_WARNING_REAR_LEFT_QUICKLEAKING = 5247744;
  
  public static final int TIRE_WARNING_REAR_LEFT_TEMPERATURE = 5246720;
  
  public static final int TIRE_WARNING_REAR_RIGHT = 5245952;
  
  public static final int TIRE_WARNING_REAR_RIGHT_QUICKLEAKING = 5248000;
  
  public static final int TIRE_WARNING_REAR_RIGHT_TEMPERATURE = 5246976;
  
  public static final int TPMS_STATES_CMN_WARN = 5259266;
  
  public static final int TPMS_STATES_FL_WARN = 5259267;
  
  public static final int TPMS_STATES_FR_WARN = 5259268;
  
  public static final int TPMS_STATES_NO_WARN = 5259265;
  
  public static final int TPMS_STATES_RL_WARN = 5259269;
  
  public static final int TPMS_STATES_RR_WARN = 5259270;
  
  public static final int TPMS_STATES_SYS_FAILURE = 5259272;
  
  public static final int TPMS_STATES_SYS_NOT_AVI = 5259271;
  
  public static final int WARNING_LEVEL_FAULT = 5245188;
  
  public static final int WARNING_LEVEL_HIGH_PRESSURE = 5245189;
  
  public static final int WARNING_LEVEL_HIGH_WARN = 5245187;
  
  public static final int WARNING_LEVEL_LOW_WARN = 5245186;
  
  public static final int WARNING_LEVEL_NO_WARN = 5245185;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TireMsgFlagStates {
    public static final int NORMAL = 5249281;
    
    public static final int WARNING = 5249282;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TireQuickleakingStates {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TireSensorStates {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TireWarning {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TpmsStates {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Type {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\ITireSensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */