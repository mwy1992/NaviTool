package com.ecarx.xui.adaptapi.navigation.ehp.v2.profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IProfLongValue {
  public static final int PROF_LONG_TYPE_AVERAGE_SPEED = 17;
  
  public static final int PROF_LONG_TYPE_DESTINATION = 16;
  
  public static final int PROF_LONG_TYPE_EXTENDED_LANE = 10;
  
  public static final int PROF_LONG_TYPE_MERGE_LINK = 21;
  
  public static final int PROF_LONG_TYPE_RT_TRAFFIC_FLOW_SPEED = 18;
  
  public static final int PROF_LONG_TYPE_TRAFFIC_EVENT = 19;
  
  public static final int PROF_LONG_TYPE_TRAFFIC_SIGN = 8;
  
  public static final int PROF_LONG_TYPE_WEATHER_INFO = 20;
  
  int getProfileType();
  
  int getValue();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProfileType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\profile\IProfLongValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */