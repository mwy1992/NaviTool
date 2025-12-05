package com.ecarx.xui.adaptapi.tbox.tboxmessager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ITBoxMessager {
  public static final int TBOX_MSG_DEFAULT = 0;
  
  public static final int TBOX_MSG_NAVI = 2;
  
  public static final int TBOX_MSG_TEXT = 1;
  
  INaviInfoFromTBox getNaviInfo();
  
  int getTBoxMsgType();
  
  void setTBoxMessageCallback(TBoxMessageCallback paramTBoxMessageCallback, int paramInt);
  
  void unsetTBoxMessageCallback(TBoxMessageCallback paramTBoxMessageCallback);
  
  public static interface TBoxMessageCallback {
    void onTBoxMessageGet(Object param1Object, int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TBoxMessageType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\tboxmessager\ITBoxMessager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */