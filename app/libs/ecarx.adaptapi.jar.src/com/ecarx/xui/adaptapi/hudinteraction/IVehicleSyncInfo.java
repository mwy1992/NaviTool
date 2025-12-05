package com.ecarx.xui.adaptapi.hudinteraction;

import com.ecarx.xui.adaptapi.VendorDefinition;

@VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "ALL", requirement = "XQ2020081841652")
public interface IVehicleSyncInfo {
  double getSteerWhlSnsrAg();
  
  double getSteerWhlSnsrAgSpd();
  
  double getVehicleSpeed();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\IVehicleSyncInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */