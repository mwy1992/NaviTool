package com.ecarx.xui.adaptapi.navigation.gps;

import android.location.Location;
import com.ecarx.xui.adaptapi.FunctionStatus;

public interface IGCJLocation {
  FunctionStatus isGCJLocationSupported();
  
  void updateGCJLocation(Location paramLocation);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\gps\IGCJLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */