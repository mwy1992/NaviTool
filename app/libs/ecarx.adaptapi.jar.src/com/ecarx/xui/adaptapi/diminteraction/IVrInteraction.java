package com.ecarx.xui.adaptapi.diminteraction;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IVrInteraction {
  public static final int ACTION_BUTTON_BACK = 16;
  
  public static final int ACTION_BUTTON_CONFIRM = 17;
  
  public static final int ACTION_BUTTON_DOWN = 10;
  
  public static final int ACTION_BUTTON_LEFT = 7;
  
  public static final int ACTION_BUTTON_RIGHT = 8;
  
  public static final int ACTION_BUTTON_UP = 9;
  
  public static final int ACTION_SEARCH_ALL_CONTACTS = 4;
  
  public static final int ACTION_SEARCH_CALL_LOG = 3;
  
  public static final int ACTION_SEARCH_CONTACTS = 1;
  
  public static final int ACTION_SEARCH_FAV_CONTACTS = 2;
  
  public static final int ACTION_SEARCH_NAVI_ADDRESS = 5;
  
  public static final int ACTION_SELECT = 32;
  
  public static final int ACTION_VOICE_TO_TEXT = 6;
  
  public static final int DATA_TYPE_ADDRESS = 2;
  
  public static final int DATA_TYPE_CONTACT = 1;
  
  public static final int DATA_TYPE_ILLEGAL = 0;
  
  public static final int SEARCH_STATUS_COMPLETED = 2;
  
  public static final int SEARCH_STATUS_NOT_RECOGNIZED = 4;
  
  public static final int SEARCH_STATUS_ONGOING = 1;
  
  public static final int SEARCH_STATUS_TIME_OUT = 3;
  
  public static final int VR_STATUS_IDLE = 0;
  
  public static final int VR_STATUS_LISTENING = 1;
  
  public static final int VR_STATUS_PROCESSING = 2;
  
  public static final int VR_STATUS_PROMTING = 4;
  
  public static final int VR_STATUS_WAITING = -2147483648;
  
  void notifyVoiceToTextCompleted(String paramString);
  
  void notifyVrSearchStates(int paramInt);
  
  void notifyVrStatusChanged(int paramInt1, int paramInt2);
  
  void notifyVrTTSText(String paramString);
  
  void registerVrCallback(IVrInteractionCallback paramIVrInteractionCallback);
  
  void unRegisterVrCallback(IVrInteractionCallback paramIVrInteractionCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionDataType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionType {}
  
  public static interface IVrInteractionCallback {
    void onDoInteractionAction(int param1Int1, int param1Int2, Object param1Object);
    
    void onVrInfoUpdateReqired();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VrSearchStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VrStatus {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\IVrInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */