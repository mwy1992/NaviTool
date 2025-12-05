package com.ecarx.xui.adaptapi.diminteraction;

import android.graphics.Bitmap;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IPhoneCallInteraction {
  public static final int CALL_STATUS_BUSY = 9;
  
  public static final int CALL_STATUS_CALLBACK_REJECTED = 13;
  
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
  
  public static final int CALL_STATUS_OFFHOOK = 11;
  
  public static final int CALL_STATUS_ON_CALL = 16;
  
  public static final int CALL_STATUS_ON_HOLD = 17;
  
  public static final int CALL_STATUS_REJECTED = 10;
  
  public static final int CALL_STATUS_RINGING = 8;
  
  public static final int CALL_STATUS_START_FAILED = 1;
  
  void registerPhoneCallback(IPhoneCallInteractionCallback paramIPhoneCallInteractionCallback);
  
  void unRegisterPhoneCallback(IPhoneCallInteractionCallback paramIPhoneCallInteractionCallback);
  
  void updateCallInfo(ICallInfo paramICallInfo);
  
  void updateConnectedMobileDeviceState(String paramString, int paramInt1, int paramInt2);
  
  void updateSecondCallInfo(ICallInfo paramICallInfo);
  
  void writeCallLog2DBCompleted();
  
  void writeContact2DBCompleted();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CallStatus {}
  
  public static interface ICallInfo {
    int getActiveCallId();
    
    Bitmap getAvatar();
    
    int getCallCount();
    
    long getCallDuration();
    
    int getCallId();
    
    int getCallStatus();
    
    @VendorDefinition(author = "@ECARX", date = "2021-10-21", project = "HX11")
    String getCompany();
    
    String getContactName();
    
    String getContactNumber();
    
    @VendorDefinition(author = "@ECARX", date = "2021-10-21", project = "HX11")
    String getTitle();
    
    boolean isHandFree();
    
    boolean isMicOnVehicleMuted();
    
    boolean isRingtoneMuted();
  }
  
  public static interface IPhoneCallInteractionCallback {
    void onAnswerAndEndCall(String param1String);
    
    void onAnswerAndHoldCall(String param1String);
    
    void onAnswerCall(String param1String);
    
    void onCallInfoUpdateRequired();
    
    void onEndCall(String param1String);
    
    void onRequestConnectedMobileDeviceInfo();
    
    void onSwitchCall();
    
    void onSwitchChannel(int param1Int);
    
    void onSwitchMicMode(int param1Int);
    
    void onSwitchRingtoneMuteMode(int param1Int);
    
    void placeCall(String param1String);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\IPhoneCallInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */