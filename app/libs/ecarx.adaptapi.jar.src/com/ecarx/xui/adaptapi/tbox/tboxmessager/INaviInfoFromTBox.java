package com.ecarx.xui.adaptapi.tbox.tboxmessager;

import com.ecarx.xui.adaptapi.NonNull;

public interface INaviInfoFromTBox {
  @NonNull
  String getLat();
  
  @NonNull
  String getLon();
  
  String getMessageId();
  
  String getMessageTitle();
  
  String getSender();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\tboxmessager\INaviInfoFromTBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */