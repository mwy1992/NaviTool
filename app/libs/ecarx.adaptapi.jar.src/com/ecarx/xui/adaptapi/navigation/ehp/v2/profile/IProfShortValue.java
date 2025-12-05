package com.ecarx.xui.adaptapi.navigation.ehp.v2.profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IProfShortValue {
  public static final int PROF_SHORT_TYPE_CURVATURE = 1;
  
  public static final int PROF_SHORT_TYPE_HEADING_CHANGE = 8;
  
  public static final int PROF_SHORT_TYPE_ROAD_CONDITION = 6;
  
  public static final int PROF_SHORT_TYPE_SLOPE = 3;
  
  public static final int PROF_SHORT_TYPE_SPEED_SIGN_POSITION = 7;
  
  public static final int PROF_SHORT_TYPE_TRAFFIC_FLOW = 19;
  
  public static final int PROF_SHORT_TYPE_TRAVEL_SPEED = 18;
  
  int getProfileType();
  
  int getValue();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProfileType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\profile\IProfShortValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */