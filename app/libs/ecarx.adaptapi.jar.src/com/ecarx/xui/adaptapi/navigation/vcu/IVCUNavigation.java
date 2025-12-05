package com.ecarx.xui.adaptapi.navigation.vcu;

import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VendorDefinition(author = "@ECARX", date = "2022-01-07", project = "Lambda")
public interface IVCUNavigation {
  FunctionStatus isVCUNavigationSupported();
  
  void updateNaviInfo(IVcuNaviInfo paramIVcuNaviInfo);
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DestinationType {
    public static final int CHARGING_STATION = 3;
    
    public static final int FUEL_STATION = 1;
    
    public static final int NULL = 0;
    
    public static final int OTHER = 4;
    
    public static final int PARKING_LOT = 2;
    
    public static final int RESERVED = 5;
  }
  
  public static interface IVcuNaviInfo {
    int getDestinationType();
    
    int getExpectedDestinationDay();
    
    float getExpectedDestinationElectricity();
    
    int getExpectedDestinationHr();
    
    int getExpectedDestinationMins();
    
    float getNavigationChargingMaxPower();
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\vcu\IVCUNavigation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */