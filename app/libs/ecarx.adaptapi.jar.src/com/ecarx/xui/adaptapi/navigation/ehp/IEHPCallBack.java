package com.ecarx.xui.adaptapi.navigation.ehp;

import com.ecarx.xui.adaptapi.VendorDefinition;

public interface IEHPCallBack {
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
  void onGpsInfoChange(GpsInfo paramGpsInfo);
  
  public static interface GpsInfo {
    int getBiasTiForMins();
    
    int getBiasTiForMsec();
    
    int getBiasTiForSec();
    
    double getLatitude();
    
    double getLongitude();
    
    int getOriTiForMins();
    
    int getOriTiForMsec();
    
    int getOriTiForSec();
    
    int getUTCForDay();
    
    int getUTCForHr();
    
    int getUTCForMins();
    
    int getUTCForMth();
    
    int getUTCForSec();
    
    int getUTCForYr();
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\IEHPCallBack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */