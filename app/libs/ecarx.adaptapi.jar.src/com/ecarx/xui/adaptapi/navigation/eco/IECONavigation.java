package com.ecarx.xui.adaptapi.navigation.eco;

import android.os.Bundle;
import com.ecarx.xui.adaptapi.FunctionStatus;

public interface IECONavigation {
  FunctionStatus isECONavigationSupported();
  
  void updateRoadConditionInfo(IRoadConditionInfo paramIRoadConditionInfo);
  
  public static interface IRoadConditionInfo {
    int getCurrentRoadCondition();
    
    int getCurrentRoadCongestionLength();
    
    int getCurrentRoadCongestionLevel();
    
    int getCurrentRoadPassTime();
    
    int getDistanceToNextCongestionRoad();
    
    Bundle getExtendInformation();
    
    int getNavigationState();
    
    int getNextCongestionRoadLength();
    
    int getNextCongestionRoadPassTime();
    
    int getNextRoadCongestionLevel();
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\eco\IECONavigation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */