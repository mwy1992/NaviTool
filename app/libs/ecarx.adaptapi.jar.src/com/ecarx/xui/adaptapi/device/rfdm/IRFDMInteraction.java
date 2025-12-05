package com.ecarx.xui.adaptapi.device.rfdm;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

@VendorDefinition(author = "@ECARX", date = "2022-03-23", project = "EF1E", requirement = "")
public interface IRFDMInteraction {
  public static final int RECEIVE_TYPE_OPEN_APP = 131;
  
  public static final int RECEIVE_TYPE_REMOTE_CONTROL = 130;
  
  public static final int RECEIVE_TYPE_REQ = 128;
  
  public static final int RECEIVE_TYPE_REQ_ASSISTANT_IS_TTS_PLAYING = 134;
  
  public static final int RECEIVE_TYPE_SET_PROFILE = 133;
  
  public static final int RECEIVE_TYPE_SET_SETTING = 129;
  
  public static final int RECEIVE_TYPE_SET_SMART_SCENE = 132;
  
  public static final int SEND_TYPE_ACK = 1;
  
  public static final int SEND_TYPE_ASSISTANT_ASR = 2;
  
  public static final int SEND_TYPE_ASSISTANT_IS_TTS_PLAYING = 11;
  
  public static final int SEND_TYPE_ASSISTANT_TTS_STATE = 10;
  
  public static final int SEND_TYPE_NAVIGATION = 3;
  
  public static final int SEND_TYPE_SMART_SCENE = 9;
  
  public static final int SEND_TYPE_SUNRISE_SUNSET_TIME = 6;
  
  public static final int SEND_TYPE_SYNC = 0;
  
  public static final int SEND_TYPE_SYNC_CAR_TEMP_AQR = 4;
  
  public static final int SEND_TYPE_SYNC_LOCATION = 7;
  
  public static final int SEND_TYPE_SYNC_SETTINGS = 8;
  
  public static final int SEND_TYPE_SYNC_TIME = 5;
  
  Map<Integer, List<Integer>> filterCallBackType(Map<Integer, List<Integer>> paramMap);
  
  boolean registerRFDMInteractionCallback(IRFDMInteractionCallback paramIRFDMInteractionCallback);
  
  boolean sendProtocolMessage(int paramInt, String paramString);
  
  boolean unregisterRFDMInteractionCallback(IRFDMInteractionCallback paramIRFDMInteractionCallback);
  
  public static interface IRFDMInteractionCallback {
    void onReceiveMessage(int param1Int, String param1String);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ReceiveProtocolType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SendProtocolType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\rfdm\IRFDMInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */