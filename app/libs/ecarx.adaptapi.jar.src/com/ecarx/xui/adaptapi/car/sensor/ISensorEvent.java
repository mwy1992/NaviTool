package com.ecarx.xui.adaptapi.car.sensor;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ISensorEvent {
  public static final int ABS_STATE_ACTIVE = 2101506;
  
  public static final int ABS_STATE_NORMAL = 2101505;
  
  public static final int ABS_STATE_UNKNOWN = -1;
  
  public static final int ABS_WARNING_STATE_FLSG = 3158018;
  
  public static final int ABS_WARNING_STATE_OFF = 3158020;
  
  public static final int ABS_WARNING_STATE_ON = 3158017;
  
  public static final int ABS_WARNING_STATE_RESD = 3158019;
  
  public static final int AIRBAG_STATUS_EJECTED = 2109698;
  
  public static final int AIRBAG_STATUS_FAULT = 2109699;
  
  public static final int AIRBAG_STATUS_NORMAL = 2109697;
  
  public static final int AIRBAG_STATUS_UNKNOWN = -1;
  
  public static final int AQI_LEVEL_HIGHER_POLLUTION = 2106117;
  
  public static final int AQI_LEVEL_HIGH_POLLUTION = 2106116;
  
  public static final int AQI_LEVEL_LOWER_POLLUTION = 2106118;
  
  public static final int AQI_LEVEL_LOW_POLLUTION = 2106114;
  
  public static final int AQI_LEVEL_MEDIUM_POLLUTION = 2106115;
  
  public static final int AQI_LEVEL_NO_POLLUTION = 2106113;
  
  public static final int AQI_LEVEL_UNKNOWN = -1;
  
  public static final int BATTERY_STATE_CHARGING = 2102530;
  
  public static final int BATTERY_STATE_CHARGING_COMPLETED = 2102531;
  
  public static final int BATTERY_STATE_CHARGING_ERROR = 2102532;
  
  public static final int BATTERY_STATE_CHARGING_PREPARED = 2102529;
  
  public static final int BATTERY_STATE_DISCHARGING = 2102534;
  
  public static final int BATTERY_STATE_DISCHARGING_COMPLETED = 2102535;
  
  public static final int BATTERY_STATE_DISCHARGING_ERROR = 2102536;
  
  public static final int BATTERY_STATE_DISCHARGING_PREPARED = 2102533;
  
  public static final int BATTERY_STATE_FAST_CHARGING = 2102545;
  
  public static final int BATTERY_STATE_HV_FAILURE = 2102549;
  
  public static final int BATTERY_STATE_SUPER_FAST_CHARGING = 2102546;
  
  public static final int BATTERY_STATE_SYSTEM_ERROR = 2102548;
  
  public static final int BATTERY_STATE_UNKNOWN = -1;
  
  public static final int BRAKE_FLUID_LEVEL_LOW = 2098690;
  
  public static final int BRAKE_FLUID_LEVEL_NORMAL = 2098689;
  
  public static final int BRAKE_FLUID_LEVEL_UNKNOWN = -1;
  
  public static final int BRK_WARNING_STATE_OFF = 3153922;
  
  public static final int BRK_WARNING_STATE_ON = 3153921;
  
  public static final int CAR_MODE_CRASH = 2102276;
  
  public static final int CAR_MODE_DYNO = 2102277;
  
  public static final int CAR_MODE_FACTORY = 2102274;
  
  public static final int CAR_MODE_NORMAL = 2102273;
  
  public static final int CAR_MODE_TRANSPORT = 2102275;
  
  public static final int CAR_MODE_UNKNOWN = -1;
  
  public static final int CO2_LEVEL_HIGHER_POLLUTION = 2106629;
  
  public static final int CO2_LEVEL_HIGH_POLLUTION = 2106628;
  
  public static final int CO2_LEVEL_LOWER_POLLUTION = 2106630;
  
  public static final int CO2_LEVEL_LOW_POLLUTION = 2106626;
  
  public static final int CO2_LEVEL_MEDIUM_POLLUTION = 2106627;
  
  public static final int CO2_LEVEL_NO_POLLUTION = 2106625;
  
  public static final int CO2_LEVEL_UNKNOWN = -1;
  
  public static final int DAY_NIGHT_MODE_DAY = 2101249;
  
  public static final int DAY_NIGHT_MODE_NIGHT = 2101250;
  
  public static final int DAY_NIGHT_MODE_UNKNOWN = -1;
  
  public static final int ENGINE_COOLANT_LEVEL_LOW = 2098434;
  
  public static final int ENGINE_COOLANT_LEVEL_LOW_1 = 2098435;
  
  public static final int ENGINE_COOLANT_LEVEL_NORMAL = 2098433;
  
  public static final int ENGINE_COOLANT_LEVEL_UNKNOWN = -1;
  
  public static final int ENGINE_OIL_LEVEL_HIGH = 2098180;
  
  public static final int ENGINE_OIL_LEVEL_LOW_1 = 2098178;
  
  public static final int ENGINE_OIL_LEVEL_LOW_2 = 2098179;
  
  public static final int ENGINE_OIL_LEVEL_OK = 2098177;
  
  public static final int ENGINE_OIL_LEVEL_UNKNOWN = -1;
  
  public static final int ENGINE_START_STOP_STATE_AUTO_STOPPING = 2103047;
  
  public static final int ENGINE_START_STOP_STATE_ENGINE_RESTART = 2103045;
  
  public static final int ENGINE_START_STOP_STATE_OPERATION = 2103046;
  
  public static final int ENGINE_START_STOP_STATE_RESET = 2103041;
  
  public static final int ENGINE_START_STOP_STATE_STANDBY = 2103042;
  
  public static final int ENGINE_START_STOP_STATE_STARTER_RESTART = 2103044;
  
  public static final int ENGINE_START_STOP_STATE_STOPPED = 2103043;
  
  public static final int ENGINE_START_STOP_STATE_UNKNOWN = -1;
  
  public static final int ENGINE_STATE_CRANKING = 2102786;
  
  public static final int ENGINE_STATE_FAULT = 2102789;
  
  public static final int ENGINE_STATE_RUNNING = 2102788;
  
  public static final int ENGINE_STATE_STOP = 2102785;
  
  public static final int ENGINE_STATE_STOPPING = 2102787;
  
  public static final int ENGINE_STATE_UNKNOWN = -1;
  
  public static final int ESC_WARNING_STATE_FLSG = 3162114;
  
  public static final int ESC_WARNING_STATE_OFF = 3162116;
  
  public static final int ESC_WARNING_STATE_ON = 3162113;
  
  public static final int ESC_WARNING_STATE_RESD = 3162115;
  
  public static final int EYEBALL_ATTENTION_BY_THE_SCREEN = 3148802;
  
  public static final int EYEBALL_ATTENTION_OUT_OFF_SCREEN = 3148801;
  
  public static final int EYEBALL_ATTENTION_STATE_UNKNOW = 3148800;
  
  public static final int GEAR_DRIVE = 2097696;
  
  public static final int GEAR_EIGHTH = 2097672;
  
  public static final int GEAR_FIFTH = 2097669;
  
  public static final int GEAR_FIRST = 2097665;
  
  public static final int GEAR_FOURTH = 2097668;
  
  public static final int GEAR_NEUTRAL = 2097680;
  
  public static final int GEAR_NINTH = 2097673;
  
  public static final int GEAR_PARK = 2097712;
  
  public static final int GEAR_REVERSE = 2097728;
  
  public static final int GEAR_SECOND = 2097666;
  
  public static final int GEAR_SEVENTH = 2097671;
  
  public static final int GEAR_SIXTH = 2097670;
  
  public static final int GEAR_TENTH = 2097674;
  
  public static final int GEAR_THIRD = 2097667;
  
  public static final int GEAR_UNKNOWN = -1;
  
  public static final int HANDBRAKE_STATE_LOCK = 2097921;
  
  public static final int HANDBRAKE_STATE_UNKNOWN = -1;
  
  public static final int HANDBRAKE_STATE_UNLOCK = 2097922;
  
  public static final int IGNITION_STATE_ACC = 2097412;
  
  public static final int IGNITION_STATE_DRIVING = 2097415;
  
  public static final int IGNITION_STATE_LOCK = 2097410;
  
  public static final int IGNITION_STATE_OFF = 2097411;
  
  public static final int IGNITION_STATE_ON = 2097413;
  
  public static final int IGNITION_STATE_START = 2097414;
  
  public static final int IGNITION_STATE_UNDEFINED = 2097409;
  
  public static final int PM25_LEVEL_HIGHER_POLLUTION = 2105605;
  
  public static final int PM25_LEVEL_HIGH_POLLUTION = 2105604;
  
  public static final int PM25_LEVEL_LOWER_POLLUTION = 2105606;
  
  public static final int PM25_LEVEL_LOW_POLLUTION = 2105602;
  
  public static final int PM25_LEVEL_MEDIUM_POLLUTION = 2105603;
  
  public static final int PM25_LEVEL_NO_POLLUTION = 2105601;
  
  public static final int PM25_LEVEL_UNKNOWN = -1;
  
  public static final int PM25_SENSOR_STATE_COLLECTING = 2106882;
  
  public static final int PM25_SENSOR_STATE_COMPLETED = 2106884;
  
  public static final int PM25_SENSOR_STATE_ERROR = 2106883;
  
  public static final int PM25_SENSOR_STATE_INITIAL = 2106881;
  
  public static final int PM25_SENSOR_STATE_UNKNOWN = -1;
  
  public static final int RAIN_SENSOR_STATE_OFF = 3149570;
  
  public static final int RAIN_SENSOR_STATE_ON = 3149569;
  
  public static final int SAFE_BELT_STATE_BUCKLED = 2101762;
  
  public static final int SAFE_BELT_STATE_UNBUCKLED = 2101761;
  
  public static final int SAFE_BELT_STATE_UNKNOWN = -1;
  
  public static final int SEAT_OCCUPATION_STATUS_FAULT = 2110211;
  
  public static final int SEAT_OCCUPATION_STATUS_NONE = 2110209;
  
  public static final int SEAT_OCCUPATION_STATUS_OCCUPIED = 2110210;
  
  public static final int SEAT_OCCUPATION_STATUS_UNKNOWN = -1;
  
  public static final int SENSOR_EVENT_UNKNOWN = -1;
  
  public static final int SNSR_CLEAN_WARNING_STATE_OFF = 3153922;
  
  public static final int SNSR_CLEAN_WARNING_STATE_ON = 3153921;
  
  public static final int SNSR_WARNING_STATE_FAULT = 3166210;
  
  public static final int SNSR_WARNING_STATE_NOFAULT = 3166209;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-25", project = "KX11/EX11")
  public static final int STAND_STILL_UNKNOWN = 3148288;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-12", project = "KX11/EX11")
  public static final int STAND_STILL_VAL1 = 3148289;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-12", project = "KX11/EX11")
  public static final int STAND_STILL_VAL2 = 3148290;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-12", project = "KX11/EX11")
  public static final int STAND_STILL_VAL3 = 3148291;
  
  public static final int TIREDNESS_DRIVING_OFF = 3148546;
  
  public static final int TIREDNESS_DRIVING_ON = 3148545;
  
  public static final int WARNING_LEVEL_1 = 3145730;
  
  public static final int WARNING_LEVEL_2 = 3145731;
  
  public static final int WARNING_OFF = 3145728;
  
  public static final int WARNING_ON = 3145729;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AQILevel {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AbsState {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@GEELY", date = "2022-11-2", project = "ONEOS")
  public static @interface AbsWarnState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AirbagStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BatteryStates {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BrakeFluidLevel {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@GEELY", date = "2022-11-2", project = "ONEOS")
  public static @interface BrkWarnState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CO2Level {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CarMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DayNightMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@GEELY", date = "2022-11-02", project = "ONEOS")
  public static @interface DriverTirednessStatus {
    public static final int DISTRACTIVE = 3149827;
    
    public static final int NO_WARNING = 3149826;
    
    public static final int RESERVED = 3149830;
    
    public static final int UNAVAILABLE = 3149824;
    
    public static final int UNKNOWN = 3149825;
    
    public static final int WARNING_LEVEL_1 = 3149828;
    
    public static final int WARNING_LEVEL_2 = 3149829;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EngineCoolantLevel {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EngineOilLevel {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EngineStartStopStates {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EngineStates {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@GEELY", date = "2022-11-2", project = "ONEOS")
  public static @interface EscWarnState {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-07-13", project = "Smart")
  public static @interface EyeBallTrackState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GearState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HandBrakeState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IgnitionState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface JoyForbidState {
    public static final int JOY_FORBID_STATE_OFF = 4195585;
    
    public static final int JOY_FORBID_STATE_ON = 4195586;
    
    public static final int JOY_FORBID_STATE_UNKNOWN = -1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface JoyLimitState {
    public static final int JOY_LIMIT_STATE_OFF = 4195841;
    
    public static final int JOY_LIMIT_STATE_ON = 4195842;
    
    public static final int JOY_LIMIT_STATE_UNKNOWN = -1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LightSensorState {
    public static final int DAY = 2100993;
    
    public static final int NIGHT = 2100994;
    
    public static final int UNKNOWN = -1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OriginSafeBeltState {
    public static final int FAULT_BUCKLED = 2167300;
    
    public static final int FAULT_UNBUCKLED = 2167299;
    
    public static final int NORMAL_BUCKLED = 2167298;
    
    public static final int NORMAL_UNBUCKLED = 2167297;
    
    public static final int UNKNOWN = -1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PM25Level {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PM25SensorState {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2022-05-19", project = "EF1E")
  public static @interface RainSensorState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SafeBeltState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SeatOccupationStatus {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SensorEvent {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@GEELY", date = "2022-11-2", project = "ONEOS")
  public static @interface SnsrCleanWarnState {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@GEELY", date = "2022-11-2", project = "ONEOS")
  public static @interface SnsrWarnState {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-06-25", project = "EX11")
  public static @interface TirednessDrivingState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TwliBriStsState {
    public static final int DAY = 2100992;
    
    public static final int NIGHT = 2100993;
    
    public static final int UNKNOWN = -1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-4-12", project = "KX11/EX11")
  public static @interface VehMtnState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WarningState {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\ISensorEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */