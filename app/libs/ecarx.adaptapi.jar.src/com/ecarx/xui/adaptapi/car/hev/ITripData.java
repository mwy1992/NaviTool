package com.ecarx.xui.adaptapi.car.hev;

import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ITripData {
  public static final int AUTO_RESET_OPTION_4_HOURS = 612369153;
  
  public static final int AUTO_RESET_OPTION_CHARGING = 612369154;
  
  @VendorDefinition(author = "@ECARX", date = "2021-02-20", project = "KXEXDHU", requirement = "")
  public static final int AUTO_RESET_OPTION_PARKING = 612369156;
  
  @VendorDefinition(author = "@ECARX", date = "2021-02-20", project = "KXEXDHU", requirement = "")
  public static final int AUTO_RESET_OPTION_PARKING_OIL = 612369155;
  
  public static final int RESET_OPTION_AUTO = 612368641;
  
  public static final int RESET_OPTION_MANUAL = 612368642;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-21", project = "DHU", requirement = "")
  public static final int TRIP_AIR_CONDITION_PERCENTAGE = 12294;
  
  @VendorDefinition(author = "@ECARX", date = "2021-07-13", project = "KX/EX", requirement = "XQ2020081252797")
  public static final int TRIP_DC_ALL = 612369926;
  
  @VendorDefinition(author = "@ECARX", date = "2020-09-10", project = "ALL", requirement = "XQ2020081252797")
  public static final int TRIP_DC_AVERAGE_FUEL_CONSUMPTION = 612369924;
  
  @VendorDefinition(author = "@ECARX", date = "2021-07-13", project = "KX/EX", requirement = "XQ2020081252797")
  public static final int TRIP_DC_AVERAGE_POWER_CONSUMPTION = 612369925;
  
  @VendorDefinition(author = "@ECARX", date = "2020-09-10", project = "ALL", requirement = "XQ2020081252797")
  public static final int TRIP_DC_AVERAGE_SPEED = 612369922;
  
  @VendorDefinition(author = "@ECARX", date = "2020-09-10", project = "ALL", requirement = "XQ2020081252797")
  public static final int TRIP_DC_SUBTOTAL_MILEAGE = 612369921;
  
  @VendorDefinition(author = "@ECARX", date = "2020-09-10", project = "ALL", requirement = "XQ2020081252797")
  public static final int TRIP_DC_TRAVEL_TIME = 612369923;
  
  public static final int TRIP_DI_AVG_ENE_CONSUMPTION = 8195;
  
  public static final int TRIP_DI_AVG_SPEED = 8194;
  
  public static final int TRIP_DI_TOTAL_REGENERATION = 8193;
  
  public static final int TRIP_ED_BATTERY_CLIMATE_PERCENTAGE = 12290;
  
  public static final int TRIP_ED_CABIN_CLIMATE_PERCENTAGE = 12291;
  
  public static final int TRIP_ED_ENTERTAINMENT_PERCENTAGE = 12293;
  
  public static final int TRIP_ED_LIGHT_PERCENTAGE = 12292;
  
  public static final int TRIP_ED_OTHER_PERCENTAGE = 12543;
  
  public static final int TRIP_ED_PROPULSION_PERCENTAGE = 12289;
  
  @VendorDefinition(author = "@ECARX", date = "2021-5-21", project = "DHU", requirement = "")
  public static final int TRIP_ED_SOUND_PERCENTAGE = 12295;
  
  public static final int TRIP_FUNC_AUTO_RESET_OPTION = 612369152;
  
  @VendorDefinition(author = "@ECARX", date = "2020-09-10", project = "ALL", requirement = "")
  public static final int TRIP_FUNC_DRIVING_COMPUTER = 612369920;
  
  public static final int TRIP_FUNC_RESET = 612368896;
  
  public static final int TRIP_FUNC_RESET_OPTION = 612368640;
  
  public static final int TRIP_INFO_TYPE_AVG_ENERGY = 4096;
  
  public static final int TRIP_INFO_TYPE_DEFAULT = 0;
  
  public static final int TRIP_INFO_TYPE_DRIVING_INFO = 8192;
  
  public static final int TRIP_INFO_TYPE_ENERGY_DISTRIBUTION = 12288;
  
  public static final int TRIP_TYPE_DEFAULT = 0;
  
  public static final int TRIP_TYPE_TRIP2 = 1;
  
  IAvgEnergyInfo getLatestAvgEnergyInfo();
  
  IDrivingInfo getLatestDrivingInfo();
  
  ITripInfo getLatestTripInfo(int paramInt1, int paramInt2);
  
  int[] getSupportedUpdateFrequencyUnit();
  
  ITripInfo[] getTripInfo(int paramInt1, int paramInt2);
  
  @Deprecated
  int getUpdateFrequencyUnit();
  
  FunctionStatus isTripDataSupported();
  
  FunctionStatus isTripDataSupported(int paramInt);
  
  FunctionStatus isTripDataSupported(int paramInt1, int paramInt2);
  
  void registerTripListener(int paramInt, ITripListener paramITripListener);
  
  void registerTripListener(ITripListener paramITripListener);
  
  @Deprecated
  void setUpdateFrequencyUnit(int paramInt);
  
  void unregisterTripListener(ITripListener paramITripListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AutoResetTripOption {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2020-09-10", project = "ALL", requirement = "")
  public static @interface ComputerInfoIds {}
  
  public static interface IAvgEnergyInfo extends ITripInfo {
    float getAvgEleConsumption();
    
    float getAvgEnergyFeedback();
    
    float getAvgFuelConsumption();
  }
  
  public static interface IDrivingInfo extends ITripInfo {
    float getEleDrivingPercentage();
    
    int getTripDistance();
    
    int getTripDistanceByEle();
    
    int getTripDistanceByFuel();
    
    int getTripDistanceInCurrentDay();
    
    long getTripDuration();
    
    float getTripEleConsumption();
    
    float getTripFuelConsumption();
  }
  
  public static interface ITripInfo {
    boolean containsInfoId(int param1Int);
    
    int[] getContainsInfoIds();
    
    int getFrequencyUnit();
    
    int getInfoType();
    
    float getInfoValue(int param1Int);
    
    int getTripType();
  }
  
  public static interface ITripInfoListener extends ITripListener {
    void onTripDataReset(int param1Int);
    
    void onTripInfoUpdate(ITripData.ITripInfo param1ITripInfo);
  }
  
  @Deprecated
  public static interface ITripListener {
    void onAvgEnergyInfoUpdate(ITripData.IAvgEnergyInfo param1IAvgEnergyInfo);
    
    void onDrivingInfoUpdate(ITripData.IDrivingInfo param1IDrivingInfo);
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InfoIds {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InfoType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ResetTripOption {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TripFunction {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TripType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\ITripData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */