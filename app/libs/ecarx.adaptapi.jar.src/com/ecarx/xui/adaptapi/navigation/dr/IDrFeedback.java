package com.ecarx.xui.adaptapi.navigation.dr;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDrFeedback {
  public static final int TYPE_FEADBACK_BRIDGE = 16;
  
  public static final int TYPE_FEADBACK_ELEVATED = 8;
  
  public static final int TYPE_FEADBACK_INVALID = 0;
  
  public static final int TYPE_FEADBACK_MATCHED = 1;
  
  public static final int TYPE_FEADBACK_ROUND_ABOUT = 4;
  
  public static final int TYPE_FEADBACK_TUNNEL = 2;
  
  int getCount();
  
  LocFeedbackNode[] getFeedbackNode();
  
  long getTicktime();
  
  double toRoadEndDist();
  
  double toRoadStartDist();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FeadbackType {}
  
  public static interface LocFeedbackNode {
    int getFeedbackType();
    
    int getLat();
    
    int getLon();
    
    float getProbability();
    
    float getRoadAZi();
    
    int getRoadWidth();
    
    int getZLevel();
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\IDrFeedback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */