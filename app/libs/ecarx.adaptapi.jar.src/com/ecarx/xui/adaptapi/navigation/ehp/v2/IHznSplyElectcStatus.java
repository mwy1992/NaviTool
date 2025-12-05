package com.ecarx.xui.adaptapi.navigation.ehp.v2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IHznSplyElectcStatus extends IV2Message {
  public static final int EHP_STATUS_NOT_RUNNING = 2;
  
  public static final int EHP_STATUS_NOT_SUPPORT = 1;
  
  public static final int EHP_STATUS_RUNNING = 3;
  
  public static final int EHP_STATUS_UNKNOWN = 0;
  
  int getStatus();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EHPStatus {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\IHznSplyElectcStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */