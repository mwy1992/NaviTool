package com.ecarx.xui.adaptapi.navigation;

import com.ecarx.xui.adaptapi.navigation.dr.IDrAutoByFwk;
import com.ecarx.xui.adaptapi.navigation.dr.IDrAutoByMap;
import com.ecarx.xui.adaptapi.navigation.eco.IECONavigation;
import com.ecarx.xui.adaptapi.navigation.ehp.IEHP;
import com.ecarx.xui.adaptapi.navigation.gps.IGCJLocation;
import com.ecarx.xui.adaptapi.navigation.speed.ISpeed;
import com.ecarx.xui.adaptapi.navigation.vcu.IVCUNavigation;

public interface INavigation {
  IDrAutoByFwk getDrAutoByFwk();
  
  @Deprecated
  IDrAutoByMap getDrAutoByMap();
  
  IECONavigation getECONavigation();
  
  IEHP getEHPManager();
  
  IGCJLocation getGCJLocation();
  
  ISpeed getSpeedInfo();
  
  IVCUNavigation getVCUNavigation();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\INavigation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */