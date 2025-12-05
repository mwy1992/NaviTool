package android.car.diagnostic;

import android.annotation.SystemApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SystemApi
public final class IntegerSensorIndex {
  public static final int ABSOLUTE_BAROMETRIC_PRESSURE = 11;
  
  public static final int AMBIENT_AIR_TEMPERATURE = 13;
  
  public static final int COMMANDED_SECONDARY_AIR_STATUS = 5;
  
  public static final int CONTROL_MODULE_VOLTAGE = 12;
  
  public static final int DISTANCE_TRAVELED_SINCE_CODES_CLEARED = 10;
  
  public static final int DISTANCE_TRAVELED_WITH_MALFUNCTION_INDICATOR_LIGHT_ON = 8;
  
  public static final int DRIVER_DEMAND_PERCENT_TORQUE = 24;
  
  public static final int ENGINE_ACTUAL_PERCENT_TORQUE = 25;
  
  public static final int ENGINE_OIL_TEMPERATURE = 23;
  
  public static final int ENGINE_PERCENT_TORQUE_DATA_IDLE = 27;
  
  public static final int ENGINE_PERCENT_TORQUE_DATA_POINT1 = 28;
  
  public static final int ENGINE_PERCENT_TORQUE_DATA_POINT2 = 29;
  
  public static final int ENGINE_PERCENT_TORQUE_DATA_POINT3 = 30;
  
  public static final int ENGINE_PERCENT_TORQUE_DATA_POINT4 = 31;
  
  public static final int ENGINE_REFERENCE_PERCENT_TORQUE = 26;
  
  public static final int FUEL_RAIL_ABSOLUTE_PRESSURE = 22;
  
  public static final int FUEL_SYSTEM_STATUS = 0;
  
  public static final int FUEL_TYPE = 21;
  
  public static final int IGNITION_MONITORS_SUPPORTED = 2;
  
  public static final int IGNITION_SPECIFIC_MONITORS = 3;
  
  public static final int INTAKE_AIR_TEMPERATURE = 4;
  
  public static final int LAST_SYSTEM = 31;
  
  public static final int MALFUNCTION_INDICATOR_LIGHT_ON = 1;
  
  public static final int MAX_AIR_FLOW_RATE_FROM_MASS_AIR_FLOW_SENSOR = 20;
  
  public static final int MAX_FUEL_AIR_EQUIVALENCE_RATIO = 16;
  
  public static final int MAX_INTAKE_MANIFOLD_ABSOLUTE_PRESSURE = 19;
  
  public static final int MAX_OXYGEN_SENSOR_CURRENT = 18;
  
  public static final int MAX_OXYGEN_SENSOR_VOLTAGE = 17;
  
  public static final int NUM_OXYGEN_SENSORS_PRESENT = 6;
  
  public static final int RUNTIME_SINCE_ENGINE_START = 7;
  
  public static final int TIME_SINCE_TROUBLE_CODES_CLEARED = 15;
  
  public static final int TIME_WITH_MALFUNCTION_LIGHT_ON = 14;
  
  public static final int VENDOR_START = 32;
  
  public static final int WARMUPS_SINCE_CODES_CLEARED = 9;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SensorIndex {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\diagnostic\IntegerSensorIndex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */