package com.ecarx.xui.adaptapi.oncall;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Call {
  public static final int CALL_STATUS_BUSY = 9;
  
  public static final int CALL_STATUS_CALLBACK_REJECTED = 13;
  
  public static final int CALL_STATUS_CALL_CONNECTED = 16;
  
  public static final int CALL_STATUS_CONNECTING = 2;
  
  public static final int CALL_STATUS_CONNECT_FAILED = 3;
  
  public static final int CALL_STATUS_DATA_UPLOADING = 4;
  
  public static final int CALL_STATUS_DATA_UPLOAD_FAILED = 5;
  
  public static final int CALL_STATUS_DIALING = 6;
  
  public static final int CALL_STATUS_DIAL_FAILED = 7;
  
  public static final int CALL_STATUS_END = 15;
  
  public static final int CALL_STATUS_HANGING_UP = 14;
  
  public static final int CALL_STATUS_IDLE = 0;
  
  public static final int CALL_STATUS_IN_COMING_CALL = 12;
  
  public static final int CALL_STATUS_IN_ECALL_CALLBACK = 21;
  
  @VendorDefinition(author = "@ECARX", date = "2020-10-31", project = "ALL", requirement = "")
  public static final int CALL_STATUS_IN_ECALL_RESCUE_INFO = 22;
  
  public static final int CALL_STATUS_NOT_SUBSCRIBED = 20;
  
  public static final int CALL_STATUS_OFFHOOK = 11;
  
  public static final int CALL_STATUS_REJECTED = 10;
  
  public static final int CALL_STATUS_RINGING = 8;
  
  public static final int CALL_STATUS_START_FAILED = 1;
  
  public static final int CALL_TYPE_BCALL = 4;
  
  public static final int CALL_TYPE_ECALL = 1;
  
  public static final int CALL_TYPE_ICALL = 3;
  
  public static final int CALL_TYPE_IDLE = -2147483647;
  
  public static final int CALL_TYPE_ONCALL = 2;
  
  public static final int START_CAUSE_CALLBACK = 4;
  
  public static final int START_CAUSE_EMERGENCY_SITUATIONS = 3;
  
  public static final int START_CAUSE_USER_START_FROM_HARD_KEY = 1;
  
  public static final int START_CAUSE_USER_START_FROM_IHU = 2;
  
  void accept();
  
  void end();
  
  int getDuration();
  
  int getStartCause();
  
  int getStatus();
  
  int getType();
  
  boolean isCallback();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CallStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CallType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface StartCause {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\oncall\Call.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */