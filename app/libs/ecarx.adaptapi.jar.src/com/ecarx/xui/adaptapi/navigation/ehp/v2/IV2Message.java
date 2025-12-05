package com.ecarx.xui.adaptapi.navigation.ehp.v2;

import android.os.Bundle;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IV2Message {
  public static final int LONG_RANGE_MESSAGE = 4096;
  
  public static final int MESSAGE_TYPE_HZN_DATA = 6;
  
  public static final int MESSAGE_TYPE_HZN_EDGE = 3;
  
  public static final int MESSAGE_TYPE_HZN_POSITION = 1;
  
  public static final int MESSAGE_TYPE_HZN_POSITION_LR = 4097;
  
  public static final int MESSAGE_TYPE_HZN_PROFLONG = 5;
  
  public static final int MESSAGE_TYPE_HZN_PROFLONG_LR = 4101;
  
  public static final int MESSAGE_TYPE_HZN_PROFSHORT = 4;
  
  public static final int MESSAGE_TYPE_HZN_SEGMENT = 2;
  
  public static final int MESSAGE_TYPE_HZN_STATUS = 0;
  
  int getCyclicCounter();
  
  Bundle getExtendValue();
  
  int getMessageType();
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MessageType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\IV2Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */