package com.ecarx.xui.adaptapi.car.hev;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;

public interface ICharging {
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int BATTERY_MODEL_STATE_1 = 606078721;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int BATTERY_MODEL_STATE_2 = 606078722;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int BATTERY_MODEL_STATE_3 = 606078723;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int BATTERY_MODEL_STATE_4 = 606078724;
  
  public static final int CHARGE_FUNC_ADJUST_MAX_CURRENT = 605031168;
  
  public static final int CHARGE_FUNC_AUTO_DISCHARGE_LEVEL = 605161216;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-23", project = "KX11")
  public static final int CHARGE_FUNC_BATTERY_CHARGING_CURRENT_POWER = 606080000;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-23", project = "KX11")
  public static final int CHARGE_FUNC_BATTERY_DISCHARGING_CURRENT_POWER = 606080256;
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-06", project = "EX11")
  public static final int CHARGE_FUNC_BATTERY_SOC_CALIBRATION = 606079744;
  
  public static final int CHARGE_FUNC_BATTERY_STABILITY = 605031680;
  
  public static final int CHARGE_FUNC_BATTERY_TEMP_MAINTAIN_STATUS = 605032192;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-09", project = "EX11")
  public static final int CHARGE_FUNC_CHARGE_PHEV_BATTERY_COLOR = 606079488;
  
  public static final int CHARGE_FUNC_CHARGING = 605028608;
  
  public static final int CHARGE_FUNC_CHARGING_CURRENT = 605029888;
  
  public static final int CHARGE_FUNC_CHARGING_CURRENT_MAX = 605030144;
  
  public static final int CHARGE_FUNC_CHARGING_CURRENT_MIN = 605030400;
  
  public static final int CHARGE_FUNC_CHARGING_CURRENT_STEP = 605030656;
  
  @VendorDefinition(author = "@ECARX", date = "2022-2-15", project = "ALL")
  public static final int CHARGE_FUNC_CHARGING_DISCHARGING_STATE = 605225984;
  
  public static final int CHARGE_FUNC_CHARGING_ENERGY = 605291776;
  
  public static final int CHARGE_FUNC_CHARGING_ESTIMATED_TIME = 605291264;
  
  public static final int CHARGE_FUNC_CHARGING_ESTIMATED_TIME_DC = 605292032;
  
  public static final int CHARGE_FUNC_CHARGING_PLUG_STATE = 605225472;
  
  public static final int CHARGE_FUNC_CHARGING_PLUG_TYPE = 605225216;
  
  public static final int CHARGE_FUNC_CHARGING_SOC = 605028864;
  
  public static final int CHARGE_FUNC_CHARGING_SOC_MAX = 605029120;
  
  public static final int CHARGE_FUNC_CHARGING_SOC_MIN = 605029376;
  
  public static final int CHARGE_FUNC_CHARGING_SOC_STEP = 605029632;
  
  public static final int CHARGE_FUNC_CHARGING_SPEED = 605291520;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-25", project = "ALL")
  public static final int CHARGE_FUNC_CHARGING_STATE = 605225728;
  
  public static final int CHARGE_FUNC_CHARGING_WORK_CURRENT = 605291008;
  
  public static final int CHARGE_FUNC_CHARGING_WORK_VOLTAGE = 605290752;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-09", project = "EX11")
  public static final int CHARGE_FUNC_DISCHARGE_STOP_BY_TARGET_STATE = 606079232;
  
  public static final int CHARGE_FUNC_DISCHARGING_ENETGY = 605357056;
  
  public static final int CHARGE_FUNC_DISCHARGING_ESTIMATED_TIME = 605356800;
  
  public static final int CHARGE_FUNC_DISCHARGING_SOC = 605160192;
  
  public static final int CHARGE_FUNC_DISCHARGING_SOC_MAX = 605160448;
  
  public static final int CHARGE_FUNC_DISCHARGING_SOC_MIN = 605160704;
  
  public static final int CHARGE_FUNC_DISCHARGING_SOC_STEP = 605160960;
  
  public static final int CHARGE_FUNC_DISCHARGING_SWITCH_V2L = 605159936;
  
  public static final int CHARGE_FUNC_DISCHARGING_SWITCH_V2V = 605159680;
  
  public static final int CHARGE_FUNC_DISCHARGING_WORK_CURRENT = 605356544;
  
  public static final int CHARGE_FUNC_DISCHARGING_WORK_VOLTAGE = 605356288;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-15", project = "ALL")
  public static final int CHARGE_FUNC_ENDURANCE_MILEAGE = 606079744;
  
  public static final int CHARGE_FUNC_EXTENDED_BATTERY_LIFE = 605031424;
  
  public static final int CHARGE_FUNC_EXTERNAL_CHARGING_LIGHT = 605031936;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int CHARGE_FUNC_EXTERNAL_POWER_SUPPLY = 606078976;
  
  public static final int CHARGE_FUNC_MAINTAIN_BATTERY_TEMP = 605030912;
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-31", project = "EX11")
  public static final int CHARGE_FUNC_NOTIFICATION_WRONG_OPERATION_REMIND = 606142720;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static final int CHARGE_FUNC_PHEV_BATTERY_CHARGING_MODE = 605357568;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-15", project = "KX")
  public static final int CHARGE_FUNC_PHEV_PARKING_POWER = 605358080;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static final int CHARGE_FUNC_PHEV_RARELY_CHARGING_MODE = 605357824;
  
  public static final int CHARGE_FUNC_PRE_CHARGING = 605094144;
  
  public static final int CHARGE_FUNC_PRE_CHARGING_CURRENT = 605094656;
  
  public static final int CHARGE_FUNC_PRE_CHARGING_IMMEDIATELY = 605095424;
  
  public static final int CHARGE_FUNC_PRE_CHARGING_SOC = 605094400;
  
  public static final int CHARGE_FUNC_PRE_CHARGING_STATUS = 605094912;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-15", project = "KX")
  public static final int CHARGE_FUNC_PRE_CHARGING_TYPE = 605095168;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING = 606077184;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_CUS_FRI = 606082304;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_CUS_MON = 606081280;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_CUS_SAT = 606082560;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_CUS_SUN = 606082816;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_CUS_THUR = 606082048;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_CUS_TUE = 606081536;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_CUS_WED = 606081792;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_MODE = 606077440;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_ONCE = 606077696;
  
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_PEAK_VALLEY_PERIOD = 606085120;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-09", project = "Smart")
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_RESTORE = 606077952;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-01", project = "Smart")
  public static final int CHARGE_FUNC_TRAVEL_APPOINT_CHARGING_SAVE = 606078464;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-27", project = "Lambda")
  public static final int CHARGE_FUNC_TRAVEL_HVAC = 606078208;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-27", project = "Lambda")
  public static final int CHARGE_FUNC_WARM_UP = 605030944;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-09", project = "Smart")
  public static final int CHARGE_FUNC_WARM_UP_LEVEL = 605030928;
  
  public static final int CHARGE_PLUG_AC = 605225217;
  
  public static final int CHARGE_PLUG_DC = 605225218;
  
  public static final int CHARGE_PLUG_DISCHARGE = 605225219;
  
  public static final int CHARGE_PLUG_ERROR = 253;
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EF1E")
  public static final int CHARGE_PLUG_NOTMATCH = 605225220;
  
  public static final int CHARGE_PLUG_STATE_CHARGING = 605225474;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-09", project = "Smart")
  public static final int CHARGE_PLUG_STATE_CHARGING_FAIL = 605225486;
  
  public static final int CHARGE_PLUG_STATE_CHARGING_PAUSE = 605225483;
  
  public static final int CHARGE_PLUG_STATE_COMPLETED = 605225475;
  
  public static final int CHARGE_PLUG_STATE_CONNECTED = 605225481;
  
  public static final int CHARGE_PLUG_STATE_DISCHARGING = 605225478;
  
  public static final int CHARGE_PLUG_STATE_DISCHARGING_COMPLETED = 605225479;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-22", project = "EX11")
  public static final int CHARGE_PLUG_STATE_DISCHARGING_END = 605225488;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-09", project = "Smart")
  public static final int CHARGE_PLUG_STATE_DISCHARGING_FAIL = 605225487;
  
  public static final int CHARGE_PLUG_STATE_DISCHARGING_PAUSE = 605225484;
  
  public static final int CHARGE_PLUG_STATE_DISCONNECTED = 605225482;
  
  public static final int CHARGE_PLUG_STATE_ERROR = 605225477;
  
  public static final int CHARGE_PLUG_STATE_HEATING = 605225480;
  
  public static final int CHARGE_PLUG_STATE_MULTI = 605225476;
  
  public static final int CHARGE_PLUG_STATE_PREPARED = 605225473;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static final int CHARGE_PLUG_STATE_RESERVE_WAITING = 605225485;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-22", project = "EX11")
  public static final int CHARGE_PLUG_STATE_TARGET_VALUE_OWER_THAN_CURRENT = 606078720;
  
  public static final int CHARGE_PLUG_STATE_UNKNOWN = 255;
  
  public static final int CHARGE_PLUG_UNKNOWN = 255;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-07", project = "EF1E")
  public static final int CHARGE_PLUG_WAITING = 605225221;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static final int PHEV_CHARGE_MODE_ACTIVE = 605357569;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static final int PHEV_CHARGE_MODE_OFF = 605357571;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static final int PHEV_CHARGE_MODE_SOC_HOLD = 605357570;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int POWER_CHARGE_MODE_FAIL = 606078979;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int POWER_CHARGE_MODE_FINISH = 606078980;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int POWER_CHARGE_MODE_FUEL_LOW = 606078981;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int POWER_CHARGE_MODE_OFF = 606078978;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int POWER_CHARGE_MODE_ON = 606078977;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static final int POWER_CHARGE_MODE_TIMEOUT = 606078982;
  
  public static final int PRE_CHARGING_STATUS_CANCELED = 605094918;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static final int PRE_CHARGING_STATUS_CANCEL_FAILED = 605094919;
  
  public static final int PRE_CHARGING_STATUS_CHARGING = 605094917;
  
  public static final int PRE_CHARGING_STATUS_FAILED = 605094914;
  
  public static final int PRE_CHARGING_STATUS_FAILURE = 605094915;
  
  public static final int PRE_CHARGING_STATUS_SCHEDULING = 605094916;
  
  public static final int PRE_CHARGING_STATUS_SUCCEED = 605094913;
  
  @VendorDefinition(author = "@ECARX", date = "2021-09-26", project = "ALL")
  public static final int PRE_CHARGING_STATUS_TIMEOUT = 605094920;
  
  public static final int PRE_CHARGING_STATUS_UNKNOWN = 255;
  
  public static final int TRAVEL_APPOINT_CHARGING_MODE_ALLWEEK = 606077443;
  
  public static final int TRAVEL_APPOINT_CHARGING_MODE_CUSTOM = 606077444;
  
  public static final int TRAVEL_APPOINT_CHARGING_MODE_ONCE = 606077441;
  
  public static final int TRAVEL_APPOINT_CHARGING_MODE_UNKNOWN = 255;
  
  public static final int TRAVEL_APPOINT_CHARGING_MODE_WEEKDATS = 606077442;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-09", project = "DHU")
  public static final int WARM_UP_ECO = 605030929;
  
  @VendorDefinition(author = "@ECARX", date = "2021-04-09", project = "DHU")
  public static final int WARM_UP_SPORT = 605030930;
  
  Calendar[] getChargingTimeSetting(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL")
  Calendar[] getHistoricalDischargeCapacityTime();
  
  @VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL")
  Float[] getHistoricalDischargeCapacityValue();
  
  Calendar[] getPreChargingTime();
  
  void registerListener(IChargingListener paramIChargingListener);
  
  boolean setChargingTimeSetting(int paramInt, Calendar[] paramArrayOfCalendar);
  
  boolean setPreChargingTime(Calendar paramCalendar1, Calendar paramCalendar2);
  
  void unregisterListener(IChargingListener paramIChargingListener);
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
  public static @interface BatteryColorState {
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_BLUE = 606079492;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_BLUE2 = 606079493;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_DEFAULT = 606079496;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_GRAY = 606079489;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_GRAYYELLOW = 606079490;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_GREEN = 606079491;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_RED = 606079495;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-06", project = "EX11")
    public static final int PHEV_BATTERY_COLOR_YELLOW = 606079494;
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static @interface BatteryModelState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BatteryTempMaintainStatus {
    public static final int BATTERY_TEMP_MAINTAIN_STATUS_IDLE = 605032196;
    
    public static final int BATTERY_TEMP_MAINTAIN_STATUS_MAINTAIN = 605032193;
    
    public static final int BATTERY_TEMP_MAINTAIN_STATUS_OFF = 0;
    
    public static final int BATTERY_TEMP_MAINTAIN_STATUS_ON = 1;
    
    public static final int BATTERY_TEMP_MAINTAIN_STATUS_PRESTART = 605032195;
    
    public static final int BATTERY_TEMP_MAINTAIN_STATUS_STANDBY = 605032194;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChargingDisChargingState {
    public static final int ACCHRGNFLTVEHSIDE = 605226023;
    
    public static final int AC_CHARGING = 605225986;
    
    public static final int AC_CHARGINGSUSPEND = 605226021;
    
    public static final int AC_CHRGNFLTCHRGRSIDE = 605226004;
    
    public static final int BOOKING = 605225990;
    
    public static final int BOOSTCHARGING = 605226024;
    
    public static final int BOOSTCHARGINGFLT = 605226025;
    
    public static final int CHARGING_CMPL = 605225988;
    
    public static final int CHARGING_END = 605225987;
    
    public static final int CHARING_FALUT = 605226001;
    
    public static final int DC_CHARGING = 605226005;
    
    public static final int DC_CHARGINGEND = 605226022;
    
    public static final int DC_CHRGNFLTCHRGRSIDECOMFLT = 605226019;
    
    public static final int DC_CHRGNFLTCHRGRSIDECONFLT = 605226016;
    
    public static final int DC_CHRGNFLTCHRGRSIDEEMGYFLT = 605226018;
    
    public static final int DC_CHRGNFLTCHRGRSIDEHWFLT = 605226017;
    
    public static final int DC_CHRGNFLTCHRGRSIDETEMPFLT = 605226009;
    
    public static final int DC_CHRGNFLTVEHSIDE = 605226008;
    
    public static final int DEFAULT = 2;
    
    public static final int DISCHARING = 605225992;
    
    public static final int DISCHARING_CMPL = 605226000;
    
    public static final int DISCHARING_END = 605225993;
    
    public static final int DISCHARING_FALUT = 605226002;
    
    public static final int HEATING = 605225989;
    
    public static final int NO_CHARGING = 605225985;
    
    public static final int NO_DISCHARING = 605225991;
    
    public static final int SUPERCHARGING = 605226020;
    
    public static final int WIRELESSCHARGING = 605226032;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChargingFunction {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChargingPlugState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChargingPlugType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChargingTimeSettingType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-12-09", project = "EX11")
  public static @interface DisChargeStopState {
    @VendorDefinition(author = "@ECARX", date = "2021-12-03", project = "EX11")
    public static final int DISCHARGE_STOP_STATE_REACH = 606079234;
    
    @VendorDefinition(author = "@ECARX", date = "2021-12-03", project = "EX11")
    public static final int DISCHARGE_STOP_STATE_UN_REACH = 606079233;
  }
  
  public static interface IChargingListener {
    void onPreChargingTimeChanged(Calendar[] param1ArrayOfCalendar);
  }
  
  public static interface ITravelChargingListener extends IChargingListener {
    void onChargingTimeSettingChanged(int param1Int, Calendar[] param1ArrayOfCalendar);
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2020-12-24", project = "ALL")
  public static @interface PHEVPowerBatteryMode {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-09-17", project = "EX11")
  public static @interface PowerSupplyMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PreChargingStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PreChargingType {
    public static final int CHARGE_FUNC_PRE_CHARGING_TYPE_CYCLE = 605095170;
    
    public static final int CHARGE_FUNC_PRE_CHARGING_TYPE_OFF = 605095168;
    
    public static final int CHARGE_FUNC_PRE_CHARGING_TYPE_SINGLE = 605095169;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TravelAppointChargingMode {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-04-09", project = "DHU")
  public static @interface WarmUpLevel {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\ICharging.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */